package com.tencent.mm.av;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f.b;
import com.tencent.mm.b.p;
import com.tencent.mm.b.q;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.MMJpegOptim;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bo;
import com.tencent.mm.vfs.i;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import junit.framework.Assert;

public final class g
  extends k
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS ImgInfo ( id INTEGER PRIMARY KEY, msgSvrId LONG, offset INT, totalLen INT, bigImgPath TEXT, thumbImgPath TEXT )", "CREATE TABLE IF NOT EXISTS ImgInfo2 ( id INTEGER PRIMARY KEY, msgSvrId LONG, offset INT, totalLen INT, bigImgPath TEXT, thumbImgPath TEXT, createtime INT, msglocalid INT, status INT, nettimes INT, reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text, hashdthumb int DEFAULT 0, iscomplete INT DEFAULT 1, origImgMD5 TEXT, compressType INT DEFAULT 0, midImgPath TEXT, forwardType INT DEFAULT 0, hevcPath TEXT, sendImgType INT DEFAULT 0 )", "CREATE INDEX IF NOT EXISTS  serverImgInfoIndex ON ImgInfo2 ( msgSvrId ) ", "CREATE INDEX IF NOT EXISTS  serverImgInfoHdIndex ON ImgInfo2 ( reserved1 ) ", "CREATE INDEX IF NOT EXISTS  msgLocalIdIndex ON ImgInfo2 ( msglocalid ) ", "insert into imginfo2 (id,msgSvrId , offset , totalLen , bigImgPath , thumbImgPath) select id, msgSvrId, offset ,totallen , bigimgpath , thumbimgpath from imginfo; ", "delete from ImgInfo ; ", "CREATE INDEX IF NOT EXISTS iscomplete_index ON ImgInfo2 ( iscomplete ) ", "CREATE INDEX IF NOT EXISTS origImgMD5_index ON ImgInfo2 ( origImgMD5 ) " };
  public static int hHH = 150;
  public static long hHI = 0L;
  public static int hHv = 0;
  private ao gox;
  private Map<Integer, WeakReference<ImageView>> hHA;
  private Map<Integer, WeakReference<View>> hHB;
  private Set<Integer> hHC;
  private Map<String, String> hHD;
  private final AtomicLong hHE;
  private FrameLayout.LayoutParams hHF;
  private SoftReference<ColorDrawable> hHG;
  com.tencent.mm.b.f<String, Bitmap> hHw;
  private com.tencent.mm.b.f<String, String> hHx;
  private List<b> hHy;
  private Map<Integer, WeakReference<ImageView>> hHz;
  public com.tencent.mm.storagebase.h hpA;
  
  public g(com.tencent.mm.storagebase.h paramh)
  {
    AppMethodBeat.i(150566);
    this.hHw = new com.tencent.mm.memory.a.b(40, new f.b() {}, getClass());
    this.hHx = new com.tencent.mm.memory.a.c(40);
    this.hHy = new ArrayList();
    this.hHz = new HashMap();
    this.hHA = new HashMap();
    this.hHB = new HashMap();
    this.hHC = new HashSet();
    this.gox = new ao(Looper.getMainLooper());
    this.hHD = new HashMap();
    this.hHE = new AtomicLong(1L);
    this.hpA = null;
    this.hHF = new FrameLayout.LayoutParams(-2, -2);
    a(paramh);
    this.hpA = paramh;
    aFd();
    AppMethodBeat.o(150566);
  }
  
  /* Error */
  private static String Cp(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 180
    //   5: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 186	java/lang/System:currentTimeMillis	()J
    //   11: lstore_3
    //   12: getstatic 82	com/tencent/mm/av/g:hHI	J
    //   15: lstore 5
    //   17: lload_3
    //   18: lstore_1
    //   19: lload 5
    //   21: lload_3
    //   22: lcmp
    //   23: ifne +11 -> 34
    //   26: lconst_1
    //   27: invokestatic 191	java/lang/Thread:sleep	(J)V
    //   30: invokestatic 186	java/lang/System:currentTimeMillis	()J
    //   33: lstore_1
    //   34: lload_1
    //   35: putstatic 82	com/tencent/mm/av/g:hHI	J
    //   38: new 193	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   45: aload_0
    //   46: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: lload_1
    //   50: invokevirtual 201	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   53: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokevirtual 209	java/lang/String:getBytes	()[B
    //   59: invokestatic 215	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   62: astore_0
    //   63: ldc 217
    //   65: ldc 219
    //   67: iconst_2
    //   68: anewarray 101	java/lang/Object
    //   71: dup
    //   72: iconst_0
    //   73: aload_0
    //   74: aastore
    //   75: dup
    //   76: iconst_1
    //   77: lload_1
    //   78: invokestatic 225	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   81: aastore
    //   82: invokestatic 230	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   85: ldc 180
    //   87: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: ldc 2
    //   92: monitorexit
    //   93: aload_0
    //   94: areturn
    //   95: astore 7
    //   97: goto -67 -> 30
    //   100: astore_0
    //   101: ldc 2
    //   103: monitorexit
    //   104: aload_0
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	paramString	String
    //   18	60	1	l1	long
    //   11	11	3	l2	long
    //   15	5	5	l3	long
    //   95	1	7	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   26	30	95	java/lang/InterruptedException
    //   3	17	100	finally
    //   26	30	100	finally
    //   30	34	100	finally
    //   34	90	100	finally
  }
  
  public static String K(bo parambo)
  {
    AppMethodBeat.i(150635);
    if (parambo == null)
    {
      ac.w("MicroMsg.ImgInfoStorage", "[getBigPicPath] msg is null.");
      AppMethodBeat.o(150635);
      return null;
    }
    long l = System.currentTimeMillis();
    Object localObject2;
    Object localObject1;
    if (parambo.field_isSend == 1)
    {
      localObject2 = o.aFx().qg(parambo.field_msgId);
      localObject1 = localObject2;
      if (((e)localObject2).dcd != 0L) {}
    }
    else
    {
      localObject1 = o.aFx().qf(parambo.field_msgSvrId);
    }
    if (com.tencent.mm.kernel.g.agR().isSDCardAvailable()) {
      if (parambo.field_isSend == 1)
      {
        parambo = f.c((e)localObject1);
        localObject2 = o.aFx().p(parambo, "", "");
        if ((parambo != null) && (parambo.length() > 0) && (i.eA((String)localObject2)))
        {
          AppMethodBeat.o(150635);
          return localObject2;
        }
        parambo = ((e)localObject1).hGM;
        localObject1 = o.aFx().p(parambo, "", "");
        if ((parambo != null) && (parambo.length() > 0) && (i.eA((String)localObject1)))
        {
          AppMethodBeat.o(150635);
          return localObject1;
        }
      }
      else if (((e)localObject1).aEZ())
      {
        parambo = ((e)localObject1).hGM;
        if (!((e)localObject1).aFa()) {
          break label297;
        }
        localObject1 = f.a((e)localObject1);
        if ((localObject1 == null) || (((e)localObject1).dcd <= 0L) || (!((e)localObject1).aEZ()) || (!i.eA(o.aFx().p(((e)localObject1).hGM, "", "")))) {
          break label297;
        }
        parambo = ((e)localObject1).hGM;
      }
    }
    label297:
    for (;;)
    {
      AppMethodBeat.o(150635);
      return parambo;
      ac.d("MicroMsg.ImgInfoStorage", "getBigPicPath use time:%s", new Object[] { System.currentTimeMillis() - l });
      AppMethodBeat.o(150635);
      return null;
    }
  }
  
  private long a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, PString paramPString, PInt paramPInt1, PInt paramPInt2, String paramString3, String paramString4, long paramLong, com.tencent.mm.b.b paramb1, com.tencent.mm.b.b paramb2, n.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(150612);
    if (paramInt1 == 0)
    {
      paramString1 = a(paramString1, 0, true, paramInt2, paramInt3, paramPInt1, paramPInt2, paramPString.value, paramLong, paramString3, paramString4, paramb2, paramb1, parama);
      if (paramString1 == null)
      {
        AppMethodBeat.o(150612);
        return -1L;
      }
      paramPString.value = paramString1.hGO;
      if (i.eA(paramString2))
      {
        paramPString = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).Xx(paramString1.hGM);
        i.lZ(paramString2, p(paramPString, "", ""));
        paramString1.Ci(paramPString);
      }
      if (paramBoolean) {}
      for (paramLong = f(paramString1);; paramLong = e(paramString1))
      {
        if (paramLong != -1L) {
          doNotify();
        }
        AppMethodBeat.o(150612);
        return paramLong;
      }
    }
    if (paramInt1 == 1)
    {
      paramString2 = a(paramString1, 1, true, paramInt2, paramInt3, paramPInt1, paramPInt2, paramPString.value, paramLong, paramString3, paramString4, paramb2, paramb1, parama);
      if (paramString2 == null)
      {
        AppMethodBeat.o(150612);
        return -1L;
      }
      paramPString.value = paramString2.hGO;
      paramString2.qe(0L);
      paramString2.oz(0L);
      paramString2.oL((int)i.aSp(p(paramString2.hGM, "", "")));
      paramString1 = a(paramString1, 0, false, paramInt2, paramInt3, new PInt(), new PInt(), "", paramLong, paramString3, paramString4, paramb2, paramb1, parama);
      if (paramString1 == null)
      {
        AppMethodBeat.o(150612);
        return 0L;
      }
      paramString1.Ce(paramString2.hGM);
      paramString1.Cg(paramString2.hGO);
      paramString1.Cf(paramString2.hGN);
      paramString1.oL(0);
      long l = this.hpA.vE(Thread.currentThread().getId());
      paramString1.oM((int)e(paramString2));
      if (paramBoolean) {}
      for (paramLong = f(paramString1);; paramLong = e(paramString1))
      {
        ac.d("MicroMsg.ImgInfoStorage", "summersafecdn insert ret[%d],  getLocalId[%d], getMsgLocalId[%d], getBigImgPath[%s], getMidImgPath[%s], getTotalLen[%d]", new Object[] { Long.valueOf(paramLong), Long.valueOf(paramString1.dcd), Long.valueOf(paramString1.hGV), paramString1.hGM, paramString1.hGN, Integer.valueOf(paramString1.hux) });
        if (l > 0L) {
          com.tencent.mm.kernel.g.agR().ghG.qL(l);
        }
        if (paramLong != -1L) {
          doNotify();
        }
        AppMethodBeat.o(150612);
        return paramLong;
      }
    }
    Assert.assertTrue(false);
    AppMethodBeat.o(150612);
    return 0L;
  }
  
  private Bitmap a(String paramString1, int paramInt1, int paramInt2, PInt paramPInt1, PInt paramPInt2, boolean paramBoolean, String paramString2, com.tencent.mm.b.b paramb)
  {
    AppMethodBeat.i(150618);
    ac.i("MicroMsg.ImgInfoStorage", "summersafecdn getPreSendBitmap origPath[%s], compressType[%d],needSave[%b], stack[%s], thumbPath: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), bs.eWi(), paramString2 });
    Object localObject2 = (Bitmap)this.hHw.aJ(f.Ck(paramString1));
    Object localObject4 = null;
    Object localObject3;
    Object localObject1;
    Object localObject5;
    if (localObject2 != null)
    {
      localObject3 = localObject2;
      if (!((Bitmap)localObject2).isRecycled()) {}
    }
    else
    {
      localObject1 = ak(paramString1, paramInt1);
      if (bs.isNullOrNil((String)localObject1)) {
        break label497;
      }
      int i;
      int j;
      if (((String)localObject1).endsWith("hd"))
      {
        localObject5 = localObject1;
        if (localObject2 != null)
        {
          localObject3 = localObject2;
          localObject4 = localObject1;
          if (!((Bitmap)localObject2).isRecycled()) {
            break label486;
          }
        }
        i = ae.aKM((String)localObject5);
        j = BackwardSupportUtil.ExifHelper.ce((String)localObject5);
        if (i <= 0) {
          break label355;
        }
      }
      label173:
      label333:
      label355:
      for (localObject2 = ae.aK((String)localObject5, i, j + paramInt2 * 90);; localObject2 = com.tencent.mm.sdk.platformtools.f.aG((String)localObject5, 120, 120))
      {
        if (localObject2 != null)
        {
          this.hHw.o(f.Ck(paramString1), localObject2);
          paramPInt1.value = ((Bitmap)localObject2).getWidth();
          paramPInt2.value = ((Bitmap)localObject2).getHeight();
          if (paramBoolean)
          {
            if (localObject1 != null) {
              break label480;
            }
            paramString1 = ak(paramString1, paramInt1);
            label230:
            paramPInt1 = paramString1;
            if (!bs.isNullOrNil(paramString1))
            {
              paramPInt1 = paramString1;
              if (paramString1.endsWith("hd")) {
                paramPInt1 = paramString1.substring(0, paramString1.length() - 2);
              }
            }
            if (paramb != null) {
              paramb.IA();
            }
            if ((bs.isNullOrNil(paramPInt1)) || (!i.eA(paramPInt1)) || (i.aSp(paramPInt1) <= 0L)) {
              break label369;
            }
            i.lZ(paramPInt1, paramString2);
            ac.i("MicroMsg.ImgInfoStorage", "copy from old thumbPath %s %s", new Object[] { paramPInt1, paramString2 });
          }
        }
        AppMethodBeat.o(150618);
        return localObject2;
        localObject2 = com.tencent.mm.sdk.platformtools.f.aKz((String)localObject1);
        localObject5 = paramString1;
        break;
      }
      label369:
      if ((!bs.isNullOrNil(paramPInt1)) && (i.eA(paramPInt1))) {
        ac.i("MicroMsg.ImgInfoStorage", "oldThumbFile Length %s", new Object[] { Long.valueOf(i.aSp(paramPInt1)) });
      }
    }
    for (;;)
    {
      label432:
      try
      {
        if ((bs.isNullOrNil(paramPInt1)) || (!paramPInt1.endsWith("hd"))) {
          break label469;
        }
        paramInt1 = 1;
      }
      catch (IOException paramString1) {}
      com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject2, paramInt1, Bitmap.CompressFormat.JPEG, paramString2, false);
      ac.i("MicroMsg.ImgInfoStorage", "saveBitmapToImage thumbPath %s", new Object[] { paramString2 });
      break label333;
      break label333;
      label469:
      paramInt1 = 0;
      label480:
      label486:
      label497:
      while (paramInt1 == 0)
      {
        paramInt1 = 90;
        break label432;
        paramString1 = (String)localObject1;
        break label230;
        localObject2 = localObject3;
        localObject1 = localObject4;
        break label173;
        localObject5 = paramString1;
        break;
      }
      paramInt1 = 80;
    }
  }
  
  private Bitmap a(String paramString, boolean paramBoolean1, float paramFloat, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt, boolean paramBoolean5)
  {
    AppMethodBeat.i(150590);
    paramString = a(paramString, paramBoolean1, paramFloat, paramBoolean2, paramBoolean3, paramBoolean4, paramInt, paramBoolean5, null);
    AppMethodBeat.o(150590);
    return paramString;
  }
  
  private Bitmap a(String paramString, boolean paramBoolean1, float paramFloat, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt, boolean paramBoolean5, Bitmap paramBitmap)
  {
    AppMethodBeat.i(150591);
    String str = paramString;
    if (!paramBoolean1) {
      str = b(paramString, false, true);
    }
    if (str == null)
    {
      AppMethodBeat.o(150591);
      return null;
    }
    Object localObject1 = null;
    int k;
    label87:
    Object localObject2;
    label145:
    long l;
    int m;
    int n;
    int i;
    int j;
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      k = 1;
      if (paramBoolean5)
      {
        paramString = (Bitmap)this.hHw.aJ(str);
        localObject1 = paramString;
        if (paramString == null)
        {
          if (paramString != null) {
            break label691;
          }
          paramBoolean1 = true;
          ac.l("MicroMsg.ImgInfoStorage", "bm is null:%b,  url:%s", new Object[] { Boolean.valueOf(paramBoolean1), str });
          localObject1 = paramString;
        }
      }
      if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
      {
        localObject2 = localObject1;
        if (k == 0) {}
      }
      else
      {
        bs.eWj();
        if (k == 0) {
          break label696;
        }
        paramString = paramBitmap;
        if (paramBitmap == null) {
          paramString = u.FE(str);
        }
        if (paramString == null) {
          break label916;
        }
        l = System.currentTimeMillis();
        m = paramString.getWidth();
        n = paramString.getHeight();
        i = n;
        j = m;
        if (paramBoolean3)
        {
          if (hHv == 0) {
            hHv = com.tencent.mm.cc.a.av(ai.getContext(), 2131166264);
          }
          if (m <= hHv)
          {
            i = n;
            j = m;
            if (n <= hHv) {}
          }
          else
          {
            if (m <= n) {
              break label707;
            }
            i = n * hHv / m;
            j = hHv;
          }
        }
        label258:
        n = i;
        m = j;
        if (paramBoolean4)
        {
          if (str.endsWith("hd")) {
            break label954;
          }
          j = (int)(paramString.getWidth() * paramFloat * 1.25F);
          i = (int)(paramString.getHeight() * paramFloat * 1.25F);
        }
      }
    }
    label691:
    label696:
    label954:
    for (;;)
    {
      float f;
      if ((j >= 160.0F * paramFloat) || (i >= 160.0F * paramFloat)) {
        if (i > j)
        {
          f = 160.0F * paramFloat / i;
          label352:
          j = (int)(j * f);
          i = (int)(f * i);
        }
      }
      for (;;)
      {
        m = j;
        if (j < 60.0F * paramFloat)
        {
          ac.d("MicroMsg.ImgInfoStorage", "pic to small width is %d ", new Object[] { Integer.valueOf(j) });
          m = (int)(60.0F * paramFloat);
        }
        j = i;
        if (i < 60.0F * paramFloat)
        {
          ac.d("MicroMsg.ImgInfoStorage", "pic to small height is %d ", new Object[] { Integer.valueOf(i) });
          j = (int)(60.0F * paramFloat);
        }
        paramBitmap = ai.getContext();
        localObject1 = new int[2];
        if (j >= m)
        {
          paramFloat = j / m;
          if (paramFloat <= 2.0F)
          {
            i = com.tencent.mm.cc.a.av(paramBitmap, 2131165213);
            j = (int)(i / paramFloat);
            label507:
            localObject1[0] = j;
            localObject1[1] = i;
            m = localObject1[0];
            n = localObject1[1];
          }
        }
        for (;;)
        {
          try
          {
            paramBitmap = Bitmap.createScaledBitmap(paramString, m, n, true);
            if ((paramString != paramBitmap) && (k == 0))
            {
              ac.i("MicroMsg.ImgInfoStorage", "[bitmapFromUriPath]:bitmap recycle %s", new Object[] { paramString.toString() });
              paramString.recycle();
            }
            if (paramBoolean4)
            {
              paramString = com.tencent.mm.sdk.platformtools.f.k(paramBitmap, paramInt);
              localObject1 = System.currentTimeMillis() - l;
              if (paramString != null) {
                continue;
              }
              paramBitmap = "";
              ac.i("MicroMsg.ImgInfoStorage", "cached file :%s bitmap time:%s bitmap:%s", new Object[] { str, localObject1, paramBitmap });
              localObject2 = paramString;
              if (paramString != null)
              {
                localObject2 = paramString;
                if (k == 0)
                {
                  this.hHw.o(str, paramString);
                  localObject2 = paramString;
                }
              }
              AppMethodBeat.o(150591);
              return localObject2;
              k = 0;
              break;
              paramBoolean1 = false;
              break label87;
              paramBitmap = com.tencent.mm.sdk.platformtools.f.o(str, paramFloat);
              break label145;
              label707:
              if (m == n)
              {
                i = hHv;
                j = hHv;
                break label258;
              }
              j = m * hHv / n;
              i = hHv;
              break label258;
              f = 160.0F * paramFloat / j;
              break label352;
              j = com.tencent.mm.cc.a.av(paramBitmap, 2131165215);
              i = (int)(j * paramFloat);
              break label507;
              paramFloat = m / j;
              if (paramFloat <= 2.0F)
              {
                j = com.tencent.mm.cc.a.av(paramBitmap, 2131165213);
                i = (int)(j / paramFloat);
                break label507;
              }
              i = com.tencent.mm.cc.a.av(paramBitmap, 2131165215);
              j = (int)(i * paramFloat);
            }
          }
          catch (OutOfMemoryError paramBitmap)
          {
            paramBitmap = paramString;
            continue;
          }
          catch (IllegalArgumentException paramBitmap)
          {
            paramBitmap = paramString;
            continue;
            if (paramBoolean2)
            {
              paramString = com.tencent.mm.sdk.platformtools.f.a(paramBitmap, true, com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 3));
              ac.i("MicroMsg.ImgInfoStorage", "[bitmapFromUriPath]:bitmap recycle %s", new Object[] { paramBitmap.toString() });
              paramBitmap.recycle();
              continue;
            }
            paramString = paramBitmap;
            continue;
            paramBitmap = paramString.toString();
            continue;
          }
          ac.e("MicroMsg.ImgInfoStorage", "img maybe delete, %s, %s", new Object[] { str, Boolean.valueOf(i.eA(str)) });
          localObject2 = localObject1;
        }
      }
    }
  }
  
  private e a(String paramString1, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, PInt paramPInt1, PInt paramPInt2, String paramString2, long paramLong, String paramString3, String paramString4, com.tencent.mm.b.b paramb1, com.tencent.mm.b.b paramb2, n.a parama)
  {
    AppMethodBeat.i(150624);
    if (!i.eA(paramString1))
    {
      AppMethodBeat.o(150624);
      return null;
    }
    String str = f.Ck(paramString1);
    paramb1 = a(paramString1, paramInt1, paramBoolean, paramInt3, paramPInt1, paramPInt2, paramString2, paramString3, paramb1);
    if ((parama != null) && (parama.hGP == paramInt1))
    {
      paramString4 = parama.aFo();
      paramPInt2 = paramString4.hJl;
      paramString2 = paramString4.hJm;
      paramPInt1 = paramString4.hGY;
      paramString3 = paramString4.hJn;
      paramString4 = paramString4.hJo;
      ac.i("MicroMsg.ImgInfoStorage", "summersafecdn found CompressType path %s, source:%d, compressType:%d, pMidImgName[%s], pMidImgPath[%s]", new Object[] { paramString1, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString3.value, paramString4.value });
      paramString4 = new e();
      paramString4.drx = -1;
      paramString4.setLocalId(aFe());
      paramString4.qe(paramLong);
      if (!bs.isNullOrNil(paramPInt1)) {
        paramString4.Ch(paramPInt1);
      }
      paramString4.oP(0);
      paramString4.setSource(paramInt2);
      if (paramInt2 != 4) {
        break label564;
      }
      if (paramString1.startsWith(af.awP()))
      {
        paramString4.oN(3);
        label232:
        if (paramBoolean)
        {
          paramString4.Ce(paramPInt2.value + ".jpg");
          if (!bs.isNullOrNil(paramString3.value)) {
            paramString4.Cf(paramString3.value + ".jpg");
          }
          if (bs.isNullOrNil(paramString4.hGO)) {
            paramString4.Cg(paramb1);
          }
          paramString4.oL((int)i.aSp(paramString2.value));
          if (paramString4.hux == 0) {
            ac.i("MicroMsg.ImgInfoStorage", "thumb file totlen is 0 %s", new Object[] { paramString2.value });
          }
          paramString4.Cd(str);
        }
        paramString4.setCreateTime((int)bs.aNx());
        paramString4.oQ(paramInt1);
        ac.d("MicroMsg.ImgInfoStorage", "fromPathToImgInfo insert: compress img size = " + paramString4.hux);
        AppMethodBeat.o(150624);
        return paramString4;
      }
    }
    else
    {
      if ((parama == null) || (parama.hGP == paramInt1)) {
        break label573;
      }
      paramPInt2 = null;
    }
    for (paramPInt1 = null;; paramPInt1 = paramString4)
    {
      paramString4 = new PString();
      paramString2 = new PString();
      paramString3 = new PString();
      paramb2 = new PString();
      paramPInt1 = a(paramString1, str, paramInt1, paramBoolean, paramString4, paramString2, paramString3, paramb2, paramPInt1, paramPInt2);
      ac.i("MicroMsg.ImgInfoStorage", "summersafecdn user change CompressType path %s, source:%d, compressType:%d, pMidImgName[%s], pMidImgPath[%s]", new Object[] { paramString1, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString3.value, paramb2.value });
      paramPInt2 = paramString4;
      break;
      paramString4.oN(2);
      break label232;
      label564:
      paramString4.oN(1);
      break label232;
      label573:
      paramPInt2 = paramb2;
    }
  }
  
  private String a(String paramString1, int paramInt1, boolean paramBoolean, int paramInt2, PInt paramPInt1, PInt paramPInt2, String paramString2, String paramString3, com.tencent.mm.b.b paramb)
  {
    AppMethodBeat.i(150622);
    ac.i("MicroMsg.ImgInfoStorage", "genThumbImg, orig:%s", new Object[] { paramString1 });
    if (!i.eA(paramString1))
    {
      ac.e("MicroMsg.ImgInfoStorage", "file not exit:%s", new Object[] { paramString1 });
      AppMethodBeat.o(150622);
      return null;
    }
    String str = paramString3;
    if (bs.isNullOrNil(paramString3)) {
      str = aFg();
    }
    str = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(str));
    paramString3 = a(str, "th_", "", false);
    if (paramb == null) {
      paramString3 = p(str, "th_", "");
    }
    if (paramBoolean)
    {
      if ((!bs.isNullOrNil(paramString2)) && (i.eA(paramString2))) {
        break label257;
      }
      long l = bs.Gn();
      a(paramString1, paramInt1, paramInt2, paramPInt1, paramPInt2, true, paramString3, paramb);
      if (!i.eA(paramString3)) {
        break label246;
      }
      com.tencent.mm.plugin.report.service.h.wUl.f(10921, new Object[] { Long.valueOf(i.aSp(paramString3)), Long.valueOf(i.aSp(paramString1)), Integer.valueOf(90), Long.valueOf(bs.aO(l)) });
    }
    for (;;)
    {
      ac.d("MicroMsg.ImgInfoStorage", "insert: thumbName = ".concat(String.valueOf(str)));
      AppMethodBeat.o(150622);
      return str;
      label246:
      ac.e("MicroMsg.ImgInfoStorage", " thumbImg not exits");
      continue;
      label257:
      i.lZ(paramString2, paramString3);
    }
  }
  
  private void a(ImageView paramImageView1, ImageView paramImageView2, View paramView, String paramString, float paramFloat)
  {
    AppMethodBeat.i(150586);
    int k = paramString.hashCode();
    int m = paramImageView1.hashCode();
    Iterator localIterator = this.hHy.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (m == localb.hHO)
      {
        ac.i("MicroMsg.ImgInfoStorage", "setbitmapFromUri  [%d, %s] ", new Object[] { Integer.valueOf(localb.hHO), localb.url });
        localb.url = paramString;
        if (!this.hHC.contains(Integer.valueOf(k)))
        {
          this.hHC.add(Integer.valueOf(k));
          f(paramString, paramFloat);
        }
        AppMethodBeat.o(150586);
        return;
      }
    }
    this.hHz.put(Integer.valueOf(m), new WeakReference(paramImageView1));
    int i;
    if (paramImageView2 != null)
    {
      i = paramImageView2.hashCode();
      this.hHA.put(Integer.valueOf(i), new WeakReference(paramImageView2));
    }
    for (;;)
    {
      int j;
      if (paramView != null)
      {
        j = paramView.hashCode();
        this.hHB.put(Integer.valueOf(j), new WeakReference(paramView));
      }
      for (;;)
      {
        paramImageView1 = new b(m, paramString, i, j);
        this.hHy.add(paramImageView1);
        if (!this.hHC.contains(Integer.valueOf(k)))
        {
          this.hHC.add(Integer.valueOf(k));
          f(paramString, paramFloat);
        }
        AppMethodBeat.o(150586);
        return;
        j = 0;
      }
      i = 0;
    }
  }
  
  private static void a(com.tencent.mm.storagebase.h paramh)
  {
    AppMethodBeat.i(150569);
    Cursor localCursor = paramh.a("PRAGMA table_info(ImgInfo2)", null, 2);
    int i4 = localCursor.getColumnIndex("name");
    int j = 0;
    int i = 0;
    int n = 0;
    int i2 = 0;
    int i3 = 0;
    int i1 = 0;
    int m = 0;
    int k = 0;
    while (localCursor.moveToNext()) {
      if (i4 >= 0)
      {
        String str = localCursor.getString(i4);
        if ("hashdthumb".equals(str)) {
          k = 1;
        }
        if ("iscomplete".equals(str)) {
          m = 1;
        }
        if ("origImgMD5".equals(str)) {
          i1 = 1;
        }
        if ("compressType".equals(str)) {
          i3 = 1;
        }
        if ("midImgPath".equals(str)) {
          i2 = 1;
        }
        if ("forwardType".equals(str)) {
          n = 1;
        }
        if (!"hevcPath".equals(str)) {
          break label364;
        }
        i = 1;
      }
    }
    label364:
    for (;;)
    {
      if ("sendImgType".endsWith("colName")) {
        j = 1;
      }
      break;
      localCursor.close();
      long l = com.tencent.mm.kernel.g.agR().ghG.vE(Thread.currentThread().getId());
      if (k == 0) {
        paramh.execSQL("ImgInfo2", "Alter table ImgInfo2 add hashdthumb INT DEFAULT 0");
      }
      if (m == 0) {
        paramh.execSQL("ImgInfo2", "Alter table ImgInfo2 add iscomplete INT DEFAULT 1");
      }
      if (i1 == 0) {
        paramh.execSQL("ImgInfo2", "Alter table ImgInfo2 add origImgMD5 TEXT");
      }
      if (i3 == 0) {
        paramh.execSQL("ImgInfo2", "Alter table ImgInfo2 add compressType INT DEFAULT 0");
      }
      if (i2 == 0) {
        paramh.execSQL("ImgInfo2", "Alter table ImgInfo2 add midImgPath TEXT");
      }
      if (n == 0) {
        paramh.execSQL("ImgInfo2", "Alter table ImgInfo2 add forwardType INT DEFAULT 0");
      }
      if (i == 0) {
        paramh.execSQL("ImgInfo2", "Alter table ImgInfo2 add hevcPath TEXT");
      }
      if (j == 0) {
        paramh.execSQL("ImgInfo2", "Alter table ImgInfo2 add sendImgType INT DEFAULT 0");
      }
      if (l > 0L) {
        com.tencent.mm.kernel.g.agR().ghG.qL(l);
      }
      AppMethodBeat.o(150569);
      return;
    }
  }
  
  public static String aFg()
  {
    try
    {
      AppMethodBeat.i(150620);
      String str = Cp("");
      AppMethodBeat.o(150620);
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private e aj(String paramString, int paramInt)
  {
    AppMethodBeat.i(150597);
    e locale = new e();
    paramString = a("ImgInfo2", null, "origImgMD5=? AND compressType=?", new String[] { String.valueOf(paramString), String.valueOf(paramInt) });
    if (paramString.moveToFirst()) {
      locale.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(150597);
    return locale;
  }
  
  private String ak(String paramString, int paramInt)
  {
    AppMethodBeat.i(150617);
    paramString = aj(f.Ck(paramString), paramInt);
    if (!bs.isNullOrNil(paramString.hGO))
    {
      paramString = R(paramString.hGO, true);
      if (i.eA(paramString))
      {
        AppMethodBeat.o(150617);
        return paramString;
      }
    }
    AppMethodBeat.o(150617);
    return null;
  }
  
  private Cursor b(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(150608);
    paramString1 = a(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2);
    AppMethodBeat.o(150608);
    return paramString1;
  }
  
  private long f(e parame)
  {
    AppMethodBeat.i(150614);
    long l = this.hpA.fdL().insertOrThrow("ImgInfo2", "id", parame.convertTo());
    if (l != -1L) {
      parame.aFc();
    }
    ac.i("MicroMsg.ImgInfoStorage", "insert img, result:%d, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d", new Object[] { Long.valueOf(l), Long.valueOf(parame.dcd), Long.valueOf(parame.hGV), Long.valueOf(parame.dpl), Integer.valueOf(parame.hGX) });
    AppMethodBeat.o(150614);
    return l;
  }
  
  private void f(final String paramString, final float paramFloat)
  {
    AppMethodBeat.i(150587);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150562);
        g.this.a(paramString, true, paramFloat, true, false, this.hHL, this.hHM);
        g.a(g.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(150561);
            g.a(g.this, g.2.this.hHK);
            AppMethodBeat.o(150561);
          }
        });
        AppMethodBeat.o(150562);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(150563);
        String str = super.toString() + "|loadImginBackground";
        AppMethodBeat.o(150563);
        return str;
      }
    });
    AppMethodBeat.o(150587);
  }
  
  public static String tl(String paramString)
  {
    AppMethodBeat.i(150573);
    paramString = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(paramString));
    AppMethodBeat.o(150573);
    return paramString;
  }
  
  public final String Cl(String paramString)
  {
    AppMethodBeat.i(150574);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(150574);
      return null;
    }
    String str1 = "";
    String str2 = paramString.trim();
    if (str2.startsWith("THUMBNAIL://")) {
      paramString = str2.substring(12);
    }
    for (;;)
    {
      try
      {
        paramString = oR(Integer.valueOf(paramString).intValue()).hGO;
        paramString = p(paramString, str1, "");
        AppMethodBeat.o(150574);
        return paramString;
      }
      catch (NumberFormatException paramString)
      {
        ac.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + paramString.getMessage());
        AppMethodBeat.o(150574);
        return null;
      }
      paramString = str2;
      if (str2.startsWith("THUMBNAIL_DIRPATH://"))
      {
        paramString = str2.substring(23);
        str1 = "th_";
      }
    }
  }
  
  public final Bitmap Cm(String paramString)
  {
    AppMethodBeat.i(150592);
    float f = com.tencent.mm.cc.a.getDensity(ai.getContext());
    paramString = com.tencent.mm.sdk.platformtools.f.o(b(paramString, false, true), f);
    AppMethodBeat.o(150592);
    return paramString;
  }
  
  public final String Cn(String paramString)
  {
    AppMethodBeat.i(150615);
    paramString = a("THUMBNAIL_DIRPATH://th_".concat(String.valueOf(paramString)), "th_", "", false);
    AppMethodBeat.o(150615);
    return paramString;
  }
  
  public final String Co(String paramString)
  {
    AppMethodBeat.i(150616);
    paramString = a(paramString, "", ".jpg", false);
    AppMethodBeat.o(150616);
    return paramString;
  }
  
  public final String Cq(String paramString)
  {
    AppMethodBeat.i(210348);
    paramString = b(paramString, false, true);
    AppMethodBeat.o(210348);
    return paramString;
  }
  
  public final e I(bo parambo)
  {
    AppMethodBeat.i(150595);
    e locale = qg(parambo.field_msgId);
    Object localObject = locale;
    if (locale.dcd == 0L)
    {
      parambo = qf(parambo.field_msgSvrId);
      localObject = parambo;
      if (parambo.dcd == 0L)
      {
        ac.e("MicroMsg.ImgInfoStorage", "deleteByMsg can't find correspond imgInfo");
        AppMethodBeat.o(150595);
        return null;
      }
    }
    AppMethodBeat.o(150595);
    return localObject;
  }
  
  public final void J(bo parambo)
  {
    AppMethodBeat.i(150599);
    parambo = I(parambo);
    if ((parambo == null) || (parambo.dcd == 0L))
    {
      ac.e("MicroMsg.ImgInfoStorage", "deleteByMsg can't find correspond imgInfo");
      AppMethodBeat.o(150599);
      return;
    }
    i.deleteFile(p(parambo.hGM, "", ""));
    i.deleteFile(p(parambo.hGR, "", ""));
    i.deleteFile(p(parambo.hGO, "", ""));
    i.deleteFile(p(parambo.hGO, "", "") + "hd");
    this.hpA.delete("ImgInfo2", "id=?", new String[] { parambo.dcd });
    if (parambo.aFa())
    {
      parambo = oR(parambo.hGX);
      if (parambo == null)
      {
        AppMethodBeat.o(150599);
        return;
      }
      i.deleteFile(p(parambo.hGM, "", ""));
      i.deleteFile(p(parambo.hGR, "", ""));
      i.deleteFile(p(parambo.hGO, "", ""));
      i.deleteFile(p(parambo.hGO, "", "") + "hd");
      this.hpA.delete("ImgInfo2", "id=?", new String[] { parambo.dcd });
    }
    AppMethodBeat.o(150599);
  }
  
  public final String R(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(150581);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(150581);
      return null;
    }
    String str = paramString.trim();
    if (str.startsWith("THUMBNAIL://")) {
      paramString = str.substring(12);
    }
    do
    {
      try
      {
        paramString = oR(Integer.valueOf(paramString).intValue()).hGO;
        paramString = a(paramString, "", "", paramBoolean);
        AppMethodBeat.o(150581);
        return paramString;
      }
      catch (NumberFormatException paramString)
      {
        ac.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + paramString.getMessage());
        AppMethodBeat.o(150581);
        return null;
      }
      paramString = str;
    } while (!str.startsWith("THUMBNAIL_DIRPATH://"));
    paramString = a(str.substring(20).substring(3), "th_", "", paramBoolean);
    AppMethodBeat.o(150581);
    return paramString;
  }
  
  public final int a(int paramInt, e parame)
  {
    AppMethodBeat.i(150627);
    paramInt = a(Long.valueOf(paramInt), parame);
    AppMethodBeat.o(150627);
    return paramInt;
  }
  
  public final int a(Long paramLong, e parame)
  {
    AppMethodBeat.i(150628);
    long l = System.currentTimeMillis();
    ContentValues localContentValues = parame.convertTo();
    if (localContentValues.size() == 0) {}
    for (int i = 1;; i = this.hpA.update("ImgInfo2", localContentValues, "id=?", new String[] { String.valueOf(paramLong) }))
    {
      ac.i("MicroMsg.ImgInfoStorage", "update last :%d values : %s %s", new Object[] { Long.valueOf(System.currentTimeMillis() - Long.valueOf(l).longValue()), localContentValues.toString(), Integer.valueOf(i) });
      if (i != -1)
      {
        parame.aFc();
        doNotify();
      }
      AppMethodBeat.o(150628);
      return i;
    }
  }
  
  public final long a(String paramString1, int paramInt1, int paramInt2, int paramInt3, PString paramPString, PInt paramPInt1, PInt paramPInt2, String paramString2, String paramString3, long paramLong, com.tencent.mm.b.b paramb1, com.tencent.mm.b.b paramb2, n.a parama)
  {
    AppMethodBeat.i(150611);
    paramLong = a(paramString1, null, paramInt1, paramInt2, paramInt3, paramPString, paramPInt1, paramPInt2, paramString2, paramString3, paramLong, paramb1, paramb2, parama, false);
    AppMethodBeat.o(150611);
    return paramLong;
  }
  
  public final long a(String paramString, int paramInt1, int paramInt2, PString paramPString, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(150610);
    long l = a(paramString, paramInt1, paramInt2, 0, paramPString, paramPInt1, paramPInt2, "", "", -1L, null, null, null);
    AppMethodBeat.o(150610);
    return l;
  }
  
  public final long a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, PString paramPString, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(150609);
    long l = a(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramPString, paramPInt1, paramPInt2, "", "", -1L, null, null, null, true);
    AppMethodBeat.o(150609);
    return l;
  }
  
  public final long a(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean, String paramString1, int paramInt, String paramString2, PString paramPString, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(150626);
    String str1 = "SERVERID://".concat(String.valueOf(paramLong));
    String str2 = com.tencent.mm.b.g.getMessageDigest(str1.getBytes());
    String str3 = p(str2, "th_", "");
    Bitmap localBitmap;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 0))
    {
      localBitmap = com.tencent.mm.sdk.platformtools.f.ck(paramArrayOfByte);
      if (localBitmap == null) {
        ac.e("MicroMsg.ImgInfoStorage", "create decodeByteArray failed: " + new String(paramArrayOfByte));
      }
      if ((paramBoolean) || (localBitmap == null)) {}
    }
    try
    {
      localBitmap = com.tencent.mm.sdk.platformtools.f.ax(localBitmap);
      paramPInt1.value = localBitmap.getWidth();
      paramPInt2.value = localBitmap.getHeight();
      com.tencent.mm.sdk.platformtools.f.a(localBitmap, 90, Bitmap.CompressFormat.JPEG, str3, true);
      paramArrayOfByte = new e();
      if (!bs.isNullOrNil(paramString1))
      {
        paramArrayOfByte.setOffset(paramInt);
        paramArrayOfByte.oL(paramInt);
        paramArrayOfByte.drx = -1;
        paramArrayOfByte.setLocalId(aFe());
        paramArrayOfByte.Ce(paramString1);
        paramArrayOfByte.Cg("THUMBNAIL_DIRPATH://th_".concat(String.valueOf(str2)));
        paramPString.value = paramArrayOfByte.hGO;
        if (paramBoolean)
        {
          paramArrayOfByte.oz(0L);
          paramArrayOfByte.oQ(1);
          paramArrayOfByte.Ch(paramString2);
          paramArrayOfByte.setCreateTime((int)bs.aNx());
          paramLong = e(paramArrayOfByte);
          if (paramLong != -1L) {
            doNotify();
          }
          AppMethodBeat.o(150626);
          return paramLong;
        }
      }
    }
    catch (IOException paramPInt1)
    {
      for (;;)
      {
        ac.e("MicroMsg.ImgInfoStorage", "create thumbnail from byte failed: " + str2 + " " + new String(paramArrayOfByte));
        continue;
        paramArrayOfByte.oz(paramLong);
        paramArrayOfByte.oQ(0);
        continue;
        paramString1 = str1;
      }
    }
  }
  
  public final long a(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean, String paramString, PString paramPString, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(150625);
    paramLong = a(paramArrayOfByte, paramLong, paramBoolean, "", 0, paramString, paramPString, paramPInt1, paramPInt2);
    AppMethodBeat.o(150625);
    return paramLong;
  }
  
  public final Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(150607);
    paramString1 = this.hpA.query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, null, null, null);
    AppMethodBeat.o(150607);
    return paramString1;
  }
  
  public final Bitmap a(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(150630);
    if (paramBoolean) {}
    for (String str = "location_backgroup_key_from".concat(String.valueOf(paramLong));; str = "location_backgroup_key_tor".concat(String.valueOf(paramLong)))
    {
      Bitmap localBitmap2 = (Bitmap)this.hHw.aJ(str);
      Bitmap localBitmap1;
      if (localBitmap2 != null)
      {
        localBitmap1 = localBitmap2;
        if (!localBitmap2.isRecycled()) {}
      }
      else
      {
        localBitmap1 = com.tencent.mm.sdk.platformtools.f.s(paramString, paramInt1, paramInt2, paramInt3);
        this.hHw.o(str, localBitmap1);
      }
      AppMethodBeat.o(150630);
      return localBitmap1;
    }
  }
  
  public final Bitmap a(String paramString, float paramFloat, Context paramContext)
  {
    AppMethodBeat.i(150593);
    paramString = a(paramString, paramFloat, paramContext, -1);
    AppMethodBeat.o(150593);
    return paramString;
  }
  
  public final Bitmap a(String paramString, float paramFloat, Context paramContext, int paramInt)
  {
    AppMethodBeat.i(150594);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(150594);
      return null;
    }
    String str = paramString.trim();
    Bitmap localBitmap = (Bitmap)this.hHw.aJ(str);
    int k;
    int m;
    int j;
    int i;
    if (localBitmap != null)
    {
      paramString = localBitmap;
      if (!localBitmap.isRecycled()) {}
    }
    else
    {
      localBitmap = BackwardSupportUtil.b.n(str, paramFloat);
      if (localBitmap == null) {
        break label355;
      }
      k = localBitmap.getWidth();
      m = localBitmap.getHeight();
      if (k < m) {
        break label275;
      }
      j = BackwardSupportUtil.b.g(paramContext, hHH);
      i = (int)(m / k * j);
      if ((j > 0) && (i > 0) && (j <= 2048) && (i <= 2048)) {
        break label302;
      }
      ac.e("MicroMsg.ImgInfoStorage", "getVideoThumb, error Scale Size %d*%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 188L, 1L, false);
      paramString = null;
      label191:
      paramContext = paramString;
      if (paramInt != -1) {
        paramContext = com.tencent.mm.sdk.platformtools.f.k(paramString, paramInt);
      }
      if (localBitmap != paramContext)
      {
        ac.i("MicroMsg.ImgInfoStorage", "[getVideoThumb] bitmap:%s", new Object[] { localBitmap.toString() });
        localBitmap.recycle();
      }
      ac.d("MicroMsg.ImgInfoStorage", "cached file ".concat(String.valueOf(str)));
      this.hHw.o(str, paramContext);
    }
    label275:
    label302:
    label355:
    for (paramString = paramContext;; paramString = localBitmap)
    {
      for (;;)
      {
        AppMethodBeat.o(150594);
        return paramString;
        i = BackwardSupportUtil.b.g(paramContext, hHH);
        j = (int)(k / m * i);
        break;
        try
        {
          paramString = Bitmap.createScaledBitmap(localBitmap, j, i, true);
        }
        catch (Exception paramString)
        {
          ac.e("MicroMsg.ImgInfoStorage", "getVideoThumb, Bitmap.createScaledBitmap Exception:%s", new Object[] { paramString.getMessage() });
          paramString = null;
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 188L, 1L, false);
        }
      }
      break label191;
    }
  }
  
  public final Bitmap a(String paramString, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(150583);
    paramString = a(paramString, false, paramFloat, paramBoolean, false, false, -1);
    AppMethodBeat.o(150583);
    return paramString;
  }
  
  public final Bitmap a(String paramString, boolean paramBoolean1, float paramFloat, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt)
  {
    AppMethodBeat.i(150589);
    paramString = a(paramString, paramBoolean1, paramFloat, paramBoolean2, paramBoolean3, paramBoolean4, paramInt, true);
    AppMethodBeat.o(150589);
    return paramString;
  }
  
  public final String a(String paramString1, int paramInt1, PString paramPString, PInt paramPInt1, PInt paramPInt2, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(150619);
    if (!i.eA(paramString1))
    {
      ac.e("MicroMsg.ImgInfoStorage", "file not exit:%s", new Object[] { paramString1 });
      AppMethodBeat.o(150619);
      return null;
    }
    String str1 = paramString2;
    if (bs.isNullOrNil(paramString2)) {
      str1 = aFg();
    }
    String str2 = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(str1));
    paramString2 = a(str2, "th_", "", false);
    paramPString.value = str2;
    long l = bs.Gn();
    paramPInt2 = a(paramString1, paramInt1, paramInt2, paramPInt1, paramPInt2, false, null, null);
    paramPString = (String)this.hHx.get(paramString1);
    if (paramPString != null) {}
    for (paramPString = (Bitmap)this.hHw.get(paramPString);; paramPString = null)
    {
      if (paramPString != null)
      {
        paramPInt1 = paramPString;
        if (!paramPString.isRecycled()) {}
      }
      else
      {
        paramPInt1 = a(paramString1, true, com.tencent.mm.cc.a.getDensity(ai.getContext()), false, false, true, 2131231564, true, paramPInt2);
        this.hHx.put(paramString1, paramString2);
      }
      if (paramPInt1 != null) {
        this.hHw.o(paramString2, paramPInt1);
      }
      ac.i("MicroMsg.ImgInfoStorage", "test decode thumb img:%d", new Object[] { Long.valueOf(bs.aO(l)) });
      AppMethodBeat.o(150619);
      return str1;
    }
  }
  
  public final String a(String paramString1, String paramString2, int paramInt, boolean paramBoolean, PString paramPString1, PString paramPString2, PString paramPString3, PString paramPString4, String paramString3, com.tencent.mm.b.b paramb)
  {
    AppMethodBeat.i(150623);
    Object localObject = paramString3;
    if (bs.isNullOrNil(paramString3))
    {
      localObject = Cp(paramString1);
      ac.i("MicroMsg.ImgInfoStorage", "generateMd5: %s, %s", new Object[] { localObject, paramString1 });
    }
    paramString3 = a((String)localObject, "", ".jpg", false);
    if (paramb == null) {
      paramString3 = a((String)localObject, "", ".jpg", true);
    }
    ac.i("MicroMsg.ImgInfoStorage", "fullPath is %s", new Object[] { paramString3 });
    if (i.aSp(paramString3) > 0L)
    {
      ac.i("MicroMsg.ImgInfoStorage", "genBigImg file already exist!");
      com.tencent.mm.plugin.report.service.h.wUl.dB(944, 8);
    }
    paramPString1.value = ((String)localObject);
    paramPString2.value = paramString3;
    if ((paramBoolean) && (!bs.isNullOrNil(paramString2)) && (paramInt == 0))
    {
      paramString2 = aj(paramString2, paramInt);
      if (!bs.isNullOrNil(paramString2.hGM))
      {
        localObject = p(paramString2.hGM, "", "");
        if (paramb != null) {
          paramb.IA();
        }
        i.lZ((String)localObject, paramString3);
        if (i.aSp((String)localObject) > 0L)
        {
          if (!bs.isNullOrNil(paramString2.hGY))
          {
            paramString1 = paramString2.hGY;
            AppMethodBeat.o(150623);
            return paramString1;
          }
          AppMethodBeat.o(150623);
          return null;
        }
        ac.w("MicroMsg.ImgInfoStorage", "ERR: copy old match file failed ,:%s ,%s ", new Object[] { paramString1, paramString3 });
      }
    }
    label1157:
    label1216:
    label1222:
    label2377:
    label3530:
    label3533:
    try
    {
      if (ax.isWifi(ai.getContext())) {
        i = bs.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("CompressPicLevelForWifi"), 60);
      }
      for (;;)
      {
        ac.i("MicroMsg.ImgInfoStorage", "genBigImg CompressPicLevel-level:%d", new Object[] { Integer.valueOf(i) });
        if ((i > 10) && (i <= 100)) {
          break label3550;
        }
        n = 70;
        j = 0;
        m = 0;
        k = 1080;
        i = j;
        try
        {
          if (!ax.isWifi(ai.getContext())) {
            break;
          }
          i = j;
          paramString2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("CompressResolutionForWifi");
          i = j;
          i1 = paramString2.indexOf("*");
          if (-1 == i1) {
            break label3542;
          }
          i = j;
          m = Integer.valueOf(paramString2.substring(0, i1)).intValue();
          i = m;
          j = Integer.valueOf(paramString2.substring(i1 + 1)).intValue();
          i = j;
        }
        catch (Exception paramString2)
        {
          for (;;)
          {
            int i1;
            m = i;
            continue;
            continue;
            continue;
            continue;
            i = m;
            continue;
            continue;
            paramBoolean = bool1;
            continue;
            j = i;
            continue;
            continue;
            continue;
            boolean bool1 = false;
            continue;
            i = 1080;
          }
        }
        k = i;
        try
        {
          i = bs.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("UseOptImage"), 0);
          com.tencent.mm.kernel.g.agP();
          paramString2 = new p(com.tencent.mm.kernel.a.getUin());
          if ((int)(paramString2.longValue() / 100L) % 100 + 1 > i) {
            break label3536;
          }
          bool1 = true;
          ac.i("MicroMsg.ImgInfoStorage", "fromPathToImgInfo useOpt:%b opt:%d uin:(%d,%d) debug:%b sdk:%d", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i), Long.valueOf(paramString2.longValue()), Long.valueOf(paramString2.longValue() / 100L), Boolean.valueOf(com.tencent.mm.sdk.a.b.eUk()), Integer.valueOf(Build.VERSION.SDK_INT) });
        }
        catch (Exception paramString2)
        {
          int i7;
          int i4;
          for (;;)
          {
            ac.e("MicroMsg.ImgInfoStorage", "get useopt :%s", new Object[] { bs.m(paramString2) });
            bool1 = false;
            continue;
            if (k >= 2160)
            {
              j = 0;
              i = 1080;
            }
            else
            {
              i = k;
              j = m;
              if (k <= 0)
              {
                i = k;
                j = m;
                if (m > 3240)
                {
                  j = 1620;
                  i = 0;
                  continue;
                  paramBoolean = false;
                }
              }
            }
          }
          int i5 = ((BitmapFactory.Options)localObject).outWidth;
          int i6 = ((BitmapFactory.Options)localObject).outHeight;
          if (((BitmapFactory.Options)localObject).outWidth <= ((BitmapFactory.Options)localObject).outHeight) {
            break label1829;
          }
          k = ((BitmapFactory.Options)localObject).outWidth;
          if (((BitmapFactory.Options)localObject).outWidth >= ((BitmapFactory.Options)localObject).outHeight) {
            break label1839;
          }
          int i2 = ((BitmapFactory.Options)localObject).outWidth;
          if (i <= 0) {
            break label1869;
          }
          int i3 = i2 / i;
          if (((BitmapFactory.Options)localObject).outHeight <= i) {
            break label1849;
          }
          j = ((BitmapFactory.Options)localObject).outHeight * i / i2;
          if (((BitmapFactory.Options)localObject).outWidth <= i) {
            break label1859;
          }
          i = i * ((BitmapFactory.Options)localObject).outWidth / i2;
          k = i;
          i = j;
          if (i * k <= 10240000) {
            break label3523;
          }
          double d = Math.sqrt(i * k / 10240000.0D);
          j = (int)(i / d);
          k = (int)(k / d);
          ac.i("MicroMsg.ImgInfoStorage", "genBigImg [%d, %d] -> target:[h,w]:[%d,%d]", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject).outHeight), Integer.valueOf(((BitmapFactory.Options)localObject).outWidth), Integer.valueOf(j), Integer.valueOf(k) });
          if (localObject == null) {
            break label1949;
          }
          paramString2 = ((BitmapFactory.Options)localObject).outMimeType;
          long l2 = i.aSp(paramString1);
          boolean bool2 = MMNativeJpeg.IsJpegFile(paramString1);
          if ((paramString2 == null) || ((!paramString2.endsWith("jpeg")) && (!paramString2.endsWith("jpg")) && (!paramString2.endsWith("bmp")) && (!paramString2.endsWith("png")) && (!paramString2.endsWith("gif")))) {
            break label1956;
          }
          i2 = 1;
          if ((paramInt != 0) || ((m == 0) && (l2 <= 204800L) && ((localObject == null) || (i3 <= 0))) || (l2 <= i7)) {
            break label1969;
          }
          if ((i4 >= 55) && (bool2)) {
            break label3516;
          }
          paramBoolean = false;
          if (!paramBoolean) {
            break label1962;
          }
          long l1;
          long l3;
          for (i = 18;; i = 8)
          {
            l1 = bs.eWj();
            m = com.tencent.mm.sdk.platformtools.f.a(paramBoolean, paramString1, j, k, Bitmap.CompressFormat.JPEG, n, paramString3, paramb);
            if ((m == 1) || (!paramBoolean)) {
              break label3513;
            }
            i = 28;
            m = com.tencent.mm.sdk.platformtools.f.a(false, paramString1, j, k, Bitmap.CompressFormat.JPEG, n, paramString3, paramb);
            paramBoolean = false;
            l3 = i.aSp(paramString3);
            ac.i("MicroMsg.ImgInfoStorage", "genBigImg check use orig , orig:%d aftercomp:%d diff percent:[%d] picCompressAvoidanceRemainderPerc:%d  %s ", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(100L * l3 / l2), Integer.valueOf(i1), paramString3 });
            k = m;
            bool1 = paramBoolean;
            j = i;
            if (i2 != 0)
            {
              k = m;
              bool1 = paramBoolean;
              j = i;
              if ((l2 - l3) * 100L < i1 * l2)
              {
                i.lZ(paramString1, paramString3);
                bool1 = false;
                j = 48;
                k = 1;
              }
            }
            l1 = bs.eWj() - l1;
            i = k;
            paramBoolean = bool1;
            if (k == 1) {
              break label2377;
            }
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 187L, 1L, false);
            ac.e("MicroMsg.ImgInfoStorage", "createThumbNail big pic fail: %s", new Object[] { paramString1 });
            AppMethodBeat.o(150623);
            return null;
            k = ((BitmapFactory.Options)localObject).outHeight;
            break;
            i2 = ((BitmapFactory.Options)localObject).outHeight;
            break label1276;
            j = ((BitmapFactory.Options)localObject).outHeight;
            break label1311;
            i = ((BitmapFactory.Options)localObject).outWidth;
            break label1334;
            i3 = k / j;
            if (((BitmapFactory.Options)localObject).outHeight > j)
            {
              i = ((BitmapFactory.Options)localObject).outHeight * j / k;
              if (((BitmapFactory.Options)localObject).outWidth <= j) {
                break label1939;
              }
            }
            for (j = j * ((BitmapFactory.Options)localObject).outWidth / k;; j = ((BitmapFactory.Options)localObject).outWidth)
            {
              k = j;
              break;
              i = ((BitmapFactory.Options)localObject).outHeight;
              break label1899;
            }
            paramString2 = "";
            break label1447;
            i2 = 0;
            break label1516;
          }
          ac.i("MicroMsg.ImgInfoStorage", "summersafecdn createThumbNail big pic no compress, calculatedQuality:%d, origLen:%d oriWidth:%d oriHeight:%d", new Object[] { Integer.valueOf(i4), Long.valueOf(l2), Integer.valueOf(i5), Integer.valueOf(i6) });
          if (i2 == 0) {
            break label3211;
          }
          i.lZ(paramString1, paramString3);
          com.tencent.mm.an.f.aDD();
          if (!com.tencent.mm.an.b.oz(256)) {
            break label3384;
          }
          if (paramInt != 1) {
            break label3392;
          }
          i = 0;
          for (;;)
          {
            for (;;)
            {
              try
              {
                m = Integer.valueOf(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("CompressMidPicLevel")).intValue();
                i = m;
              }
              catch (Exception paramString2)
              {
                continue;
              }
              try
              {
                m = Integer.valueOf(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("CompressMidPicSize")).intValue();
                ac.i("MicroMsg.ImgInfoStorage", "summersafecdn CompressMidPicLevel-level:%d size:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(m) });
                if (i > 10)
                {
                  i1 = i;
                  if (i <= 100) {}
                }
                else
                {
                  i1 = 52;
                }
                if ((m > 0) && (m <= 800)) {
                  break label3506;
                }
                i = 800;
                if (k <= i) {
                  break label3503;
                }
                k = i;
                if (j <= i) {
                  break label3500;
                }
                j = i;
                bool1 = true;
                paramBoolean = bool1;
                if (i4 != 0)
                {
                  paramBoolean = bool1;
                  if (i4 <= i1) {
                    paramBoolean = false;
                  }
                }
                if ((paramBoolean) || (l2 > 800L) || ((localObject != null) && ((i6 > i) || (i5 > i))))
                {
                  paramPString3.value = Cp(paramString1);
                  paramPString4.value = a(paramPString3.value, "", ".jpg", false);
                  i = com.tencent.mm.sdk.platformtools.f.a(false, paramString1, j, k, Bitmap.CompressFormat.JPEG, i1, paramPString4.value, paramb);
                  ac.d("MicroMsg.ImgInfoStorage", "summersafecdn pMidImgName[%s], pMidImgPath[%s], useOpt[%b], ret[%b] [%d, %d]", new Object[] { paramPString3.value, paramPString4.value, Boolean.FALSE, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
                  l1 = 0L;
                  j = 38;
                  paramBoolean = false;
                  paramString2 = com.tencent.mm.sdk.platformtools.f.aKw(paramString3);
                  if (paramString2 == null) {
                    continue;
                  }
                  k = paramString2.outWidth;
                  if (paramString2 == null) {
                    continue;
                  }
                  m = paramString2.outHeight;
                  l3 = i.aSp(paramString3);
                  i2 = MMNativeJpeg.queryQuality(paramString3);
                  boolean bool3 = MMNativeJpeg.IsJpegFile(paramString3);
                  paramString2 = com.tencent.mm.plugin.report.service.h.wUl;
                  if (!bool2) {
                    continue;
                  }
                  i1 = 1;
                  paramString2.f(11713, new Object[] { Integer.valueOf(i), Long.valueOf(l1), Integer.valueOf(j), Integer.valueOf(i1), Long.valueOf(l2), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(paramInt), Long.valueOf(l3), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i4), Integer.valueOf(i2) });
                  ac.i("MicroMsg.ImgInfoStorage", "genBigImg ret:%d useOpt:%b scene:%d [%d,%d,%d,%d,%b]->[%d,%d,%d,%d,%b] [%s]->[%s]", new Object[] { Integer.valueOf(i), Boolean.valueOf(paramBoolean), Integer.valueOf(j), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i4), Long.valueOf(l2), Boolean.valueOf(bool2), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i2), Long.valueOf(l3), Boolean.valueOf(bool3), paramString1, paramString3 });
                  if ((paramInt == 0) && (l3 >= 40960L) && (bool3) && (!MMNativeJpeg.isProgressive(paramString3)))
                  {
                    paramString2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("EnableCDNUploadImg");
                    if ((!bs.isNullOrNil(paramString2)) && (paramString2.equals("1")))
                    {
                      l1 = bs.eWj();
                      if (!paramBoolean) {
                        continue;
                      }
                      j = 19;
                      paramString2 = paramString3 + ".prog";
                      i.lZ(paramString3, paramString2);
                      if ((!bs.isNullOrNil(paramString2)) && (!bs.isNullOrNil(paramString3)) && (i.eA(paramString2))) {
                        continue;
                      }
                      bool1 = false;
                      i.deleteFile(paramString2);
                      if (bool1) {
                        break label3497;
                      }
                      bool1 = MMNativeJpeg.convertToProgressive(paramString3, n);
                      j = 29;
                      long l4 = bs.eWj();
                      long l5 = i.aSp(paramString3);
                      paramString2 = com.tencent.mm.plugin.report.service.h.wUl;
                      if (!bool1) {
                        continue;
                      }
                      n = 1;
                      if (!bool2) {
                        continue;
                      }
                      i1 = 1;
                      paramString2.f(11713, new Object[] { Integer.valueOf(n), Long.valueOf(l4 - l1), Integer.valueOf(j), Integer.valueOf(i1), Long.valueOf(l2), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(paramInt), Long.valueOf(l3), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i4), Integer.valueOf(i2), Long.valueOf(l5) });
                      ac.i("MicroMsg.ImgInfoStorage", "genBigImg PROGRESS ret:%d progret:%b size:%d useOpt:%b scene:%d [%d,%d,%d,%d,%b]->[%d,%d,%d,%d,%b] [%s]->[%s]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Long.valueOf(l5), Boolean.valueOf(paramBoolean), Integer.valueOf(j), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i4), Long.valueOf(l2), Boolean.valueOf(bool2), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i2), Long.valueOf(l3), Boolean.valueOf(bool3), paramString1, paramString3 });
                      if (!bool1)
                      {
                        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 186L, 1L, false);
                        ac.e("MicroMsg.ImgInfoStorage", "genBigImg convert to progressive failed %s", new Object[] { paramString3 });
                      }
                    }
                  }
                  AppMethodBeat.o(150623);
                  return null;
                  if (com.tencent.mm.sdk.platformtools.f.a(false, paramString1, i5, i6, Bitmap.CompressFormat.JPEG, 100, paramString3, paramb) == 1) {
                    break;
                  }
                  com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 187L, 1L, false);
                  ac.e("MicroMsg.ImgInfoStorage", "createThumbNail big pic fail (for cvrt to jpg): %s", new Object[] { paramString1 });
                  AppMethodBeat.o(150623);
                  return null;
                }
              }
              catch (Exception paramString2)
              {
                m = 0;
                continue;
                paramPString3.value = paramPString1.value;
                paramPString4.value = paramPString2.value;
                ac.d("MicroMsg.ImgInfoStorage", "summersafecdn not need to compress mid pic needCompressByQuality[%b], [%d, %d; %d, %d] use big pMidImgName[%s], pMidImgPath[%s]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i6), Integer.valueOf(i5), Integer.valueOf(j), Integer.valueOf(k), paramPString3.value, paramPString4.value });
                l1 = 0L;
                i = 1;
                j = 38;
                paramBoolean = false;
              }
            }
            ac.d("MicroMsg.ImgInfoStorage", "summersafecdn not use CDNNEWPROTO");
            l1 = 0L;
            i = 1;
            j = 38;
            paramBoolean = false;
            continue;
            k = -1;
            continue;
            m = -1;
            continue;
            i1 = 2;
            continue;
            if (MMJpegOptim.convertToProgressive(q.k(paramString2, false), q.k(paramString3, false), n) == 0)
            {
              bool1 = true;
            }
            else
            {
              bool1 = false;
              continue;
              j = 9;
              bool1 = MMNativeJpeg.convertToProgressive(paramString3, n);
              continue;
              n = -1;
              continue;
              i1 = 2;
            }
          }
        }
        if (com.tencent.mm.sdk.a.b.eUk()) {
          bool1 = true;
        }
        if (!com.tencent.mm.compatible.util.d.la(16)) {
          break label3533;
        }
        bool1 = false;
        ac.i("MicroMsg.ImgInfoStorage", "genBigImg configLong:%d configShort:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(k) });
        if ((m > 0) || (k > 0)) {
          break label1157;
        }
        j = 0;
        i = 1080;
        m = bs.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
        k = m;
        if (m <= 0) {
          k = 100;
        }
        i7 = k * 1024;
        i1 = bs.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("PicCompressAvoidanceRemainderPerc"), 10);
        if ((i1 > 0) && (i1 < 100)) {
          break label3530;
        }
        i1 = 10;
        i4 = MMNativeJpeg.queryQuality(paramString1);
        k = 1;
        m = k;
        if (i4 != 0)
        {
          m = k;
          if (i4 <= n) {
            m = 0;
          }
        }
        ac.d("MicroMsg.ImgInfoStorage", "genBigImg insert : original img path: %s, fullpath:%s, needimg:%b,comresstype:%d Avoidance[%d,%d] ", new Object[] { paramString1, paramString3, Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(i7), Integer.valueOf(i1) });
        if (!paramBoolean) {
          break label3203;
        }
        localObject = com.tencent.mm.sdk.platformtools.f.aKw(paramString1);
        if ((localObject != null) && (((BitmapFactory.Options)localObject).outWidth != 0) && (((BitmapFactory.Options)localObject).outHeight != 0)) {
          break label1222;
        }
        if (localObject != null) {
          break label1216;
        }
        paramBoolean = true;
        ac.w("MicroMsg.ImgInfoStorage", "genBigImg getImageOptions error:%s, origOptions_null:%b", new Object[] { paramString1, Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(150623);
        return null;
        if (ax.is2G(ai.getContext())) {
          i = bs.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("CompressPicLevelFor2G"), 40);
        } else if (ax.is3G(ai.getContext())) {
          i = bs.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("CompressPicLevelFor3G"), 40);
        } else {
          i = bs.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("CompressPicLevelFor4G"), 60);
        }
      }
    }
    catch (Exception paramString2)
    {
      label1869:
      label3536:
      label3542:
      label3550:
      for (;;)
      {
        int n;
        int j;
        int m;
        int k;
        int i = 0;
        continue;
        i = j;
        label1899:
        if (ax.is2G(ai.getContext()))
        {
          i = j;
          paramString2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("CompressResolutionFor2G");
        }
        else
        {
          i = j;
          label1516:
          if (ax.is3G(ai.getContext()))
          {
            i = j;
            paramString2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("CompressResolutionFor3G");
          }
          else
          {
            i = j;
            paramString2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("CompressResolutionFor4G");
            continue;
            label1276:
            n = i;
          }
        }
      }
    }
  }
  
  public final String a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(150570);
    if (bs.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(150570);
      return null;
    }
    if (paramString1.startsWith("SERVERID://")) {}
    for (String str1 = paramString1.substring(11);; str1 = "") {
      for (;;)
      {
        try
        {
          str1 = qf(Long.valueOf(str1).longValue()).hGM;
          if (paramString1.startsWith("THUMBNAIL_DIRPATH://"))
          {
            paramString1 = paramString1.substring(23);
            paramString2 = "th_";
            String str3 = com.tencent.mm.plugin.image.d.awL();
            String str4 = com.tencent.mm.plugin.image.d.awM();
            String str2 = str1;
            if (bs.isNullOrNil(str1)) {
              str2 = paramString1;
            }
            paramString1 = l.b(str3, str4, paramString2, str2, paramString3, paramBoolean);
            AppMethodBeat.o(150570);
            return paramString1;
          }
        }
        catch (NumberFormatException paramString1)
        {
          ac.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + paramString1.getMessage());
          AppMethodBeat.o(150570);
          return null;
        }
      }
    }
  }
  
  public final String a(byte[] paramArrayOfByte, Bitmap.CompressFormat paramCompressFormat)
  {
    AppMethodBeat.i(150576);
    if (bs.cv(paramArrayOfByte))
    {
      ac.e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
      AppMethodBeat.o(150576);
      return null;
    }
    String str1 = aFg();
    String str2 = p(str1, "th_", "");
    ac.d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = %s", new Object[] { str2 });
    try
    {
      com.tencent.mm.sdk.platformtools.f.a(BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length), 100, paramCompressFormat, str2, true);
      paramArrayOfByte = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(str1));
      AppMethodBeat.o(150576);
      return paramArrayOfByte;
    }
    catch (IOException localIOException)
    {
      ac.e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", new Object[] { localIOException });
      paramArrayOfByte = a(paramArrayOfByte, true, paramCompressFormat);
      AppMethodBeat.o(150576);
      return paramArrayOfByte;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", new Object[] { localException });
      paramArrayOfByte = a(paramArrayOfByte, true, paramCompressFormat);
      AppMethodBeat.o(150576);
    }
    return paramArrayOfByte;
  }
  
  /* Error */
  public final String a(byte[] paramArrayOfByte, Bitmap.CompressFormat paramCompressFormat, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 1455
    //   3: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 1438	com/tencent/mm/sdk/platformtools/bs:cv	([B)Z
    //   10: ifeq +19 -> 29
    //   13: ldc 217
    //   15: ldc_w 1440
    //   18: invokestatic 751	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc_w 1455
    //   24: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aconst_null
    //   28: areturn
    //   29: invokestatic 186	java/lang/System:currentTimeMillis	()J
    //   32: lstore 10
    //   34: invokestatic 715	com/tencent/mm/av/g:aFg	()Ljava/lang/String;
    //   37: astore 16
    //   39: aload_0
    //   40: aload 16
    //   42: ldc_w 725
    //   45: ldc_w 288
    //   48: invokevirtual 292	com/tencent/mm/av/g:p	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   51: astore 17
    //   53: new 193	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   60: aload 17
    //   62: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: ldc_w 1457
    //   68: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: astore 15
    //   76: ldc 217
    //   78: ldc_w 1459
    //   81: aload 17
    //   83: invokestatic 720	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   86: invokevirtual 723	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   89: invokestatic 700	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: aload_1
    //   93: arraylength
    //   94: istore 9
    //   96: new 1281	android/graphics/BitmapFactory$Options
    //   99: dup
    //   100: invokespecial 1460	android/graphics/BitmapFactory$Options:<init>	()V
    //   103: astore 18
    //   105: aload 18
    //   107: iconst_1
    //   108: putfield 1464	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   111: aload_1
    //   112: iconst_0
    //   113: aload_1
    //   114: arraylength
    //   115: aload 18
    //   117: invokestatic 1467	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   120: pop
    //   121: aconst_null
    //   122: astore 13
    //   124: aload 15
    //   126: iconst_0
    //   127: invokestatic 1471	com/tencent/mm/vfs/i:cS	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   130: astore 12
    //   132: aload 12
    //   134: astore 13
    //   136: aload 12
    //   138: aload_1
    //   139: invokevirtual 1476	java/io/OutputStream:write	([B)V
    //   142: aload 12
    //   144: astore 13
    //   146: aload 12
    //   148: invokevirtual 1479	java/io/OutputStream:flush	()V
    //   151: aload 12
    //   153: astore 13
    //   155: aload_1
    //   156: iload_3
    //   157: iload 4
    //   159: invokestatic 1480	com/tencent/mm/sdk/platformtools/f:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   162: astore 19
    //   164: aload 12
    //   166: astore 13
    //   168: aload_1
    //   169: arraylength
    //   170: istore 8
    //   172: aload 19
    //   174: ifnull +320 -> 494
    //   177: bipush 100
    //   179: istore 7
    //   181: aload 12
    //   183: astore 13
    //   185: aload_1
    //   186: arraylength
    //   187: istore_3
    //   188: iload_3
    //   189: ldc_w 1481
    //   192: if_icmple +530 -> 722
    //   195: new 1483	java/io/ByteArrayOutputStream
    //   198: dup
    //   199: invokespecial 1484	java/io/ByteArrayOutputStream:<init>	()V
    //   202: astore 14
    //   204: aload 14
    //   206: astore 13
    //   208: aload 19
    //   210: aload_2
    //   211: bipush 100
    //   213: aload 14
    //   215: invokevirtual 1488	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   218: pop
    //   219: aload 14
    //   221: astore 13
    //   223: aload 14
    //   225: invokevirtual 1491	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   228: arraylength
    //   229: istore 4
    //   231: bipush 100
    //   233: istore_3
    //   234: aload 14
    //   236: astore 13
    //   238: iload_3
    //   239: istore 7
    //   241: aload 14
    //   243: invokevirtual 1491	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   246: arraylength
    //   247: ldc_w 1481
    //   250: if_icmple +64 -> 314
    //   253: iload_3
    //   254: bipush 15
    //   256: if_icmplt +58 -> 314
    //   259: aload 14
    //   261: astore 13
    //   263: iload_3
    //   264: istore 7
    //   266: aload 14
    //   268: invokevirtual 1494	java/io/ByteArrayOutputStream:reset	()V
    //   271: iload_3
    //   272: iconst_5
    //   273: isub
    //   274: istore_3
    //   275: aload 14
    //   277: astore 13
    //   279: iload_3
    //   280: istore 7
    //   282: aload 19
    //   284: aload_2
    //   285: iload_3
    //   286: aload 14
    //   288: invokevirtual 1488	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   291: pop
    //   292: aload 14
    //   294: astore 13
    //   296: iload_3
    //   297: istore 7
    //   299: aload 14
    //   301: invokevirtual 1491	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   304: arraylength
    //   305: istore 8
    //   307: iload 8
    //   309: istore 4
    //   311: goto -77 -> 234
    //   314: aload 12
    //   316: astore 13
    //   318: aload 14
    //   320: invokevirtual 1495	java/io/ByteArrayOutputStream:close	()V
    //   323: aload 12
    //   325: astore 13
    //   327: aload 19
    //   329: iload_3
    //   330: aload_2
    //   331: aload 17
    //   333: iconst_1
    //   334: invokestatic 533	com/tencent/mm/sdk/platformtools/f:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   337: pop
    //   338: aload 12
    //   340: astore 13
    //   342: ldc 217
    //   344: ldc_w 1497
    //   347: iconst_3
    //   348: anewarray 101	java/lang/Object
    //   351: dup
    //   352: iconst_0
    //   353: aload 15
    //   355: aastore
    //   356: dup
    //   357: iconst_1
    //   358: aload 17
    //   360: aastore
    //   361: dup
    //   362: iconst_2
    //   363: iload_3
    //   364: invokestatic 419	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   367: aastore
    //   368: invokestatic 320	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   371: aload 12
    //   373: astore 13
    //   375: getstatic 739	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   378: sipush 16498
    //   381: bipush 10
    //   383: anewarray 101	java/lang/Object
    //   386: dup
    //   387: iconst_0
    //   388: aload 5
    //   390: invokestatic 1500	com/tencent/mm/sdk/platformtools/bs:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   393: ldc_w 1502
    //   396: invokestatic 1508	com/tencent/mm/compatible/util/p:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   399: aastore
    //   400: dup
    //   401: iconst_1
    //   402: iload 6
    //   404: invokestatic 443	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   407: aastore
    //   408: dup
    //   409: iconst_2
    //   410: iload 9
    //   412: invokestatic 419	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   415: aastore
    //   416: dup
    //   417: iconst_3
    //   418: aload 18
    //   420: getfield 1287	android/graphics/BitmapFactory$Options:outHeight	I
    //   423: invokestatic 419	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   426: aastore
    //   427: dup
    //   428: iconst_4
    //   429: aload 18
    //   431: getfield 1284	android/graphics/BitmapFactory$Options:outWidth	I
    //   434: invokestatic 419	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   437: aastore
    //   438: dup
    //   439: iconst_5
    //   440: iload 4
    //   442: invokestatic 419	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   445: aastore
    //   446: dup
    //   447: bipush 6
    //   449: aload 19
    //   451: invokevirtual 501	android/graphics/Bitmap:getHeight	()I
    //   454: invokestatic 419	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   457: aastore
    //   458: dup
    //   459: bipush 7
    //   461: aload 19
    //   463: invokevirtual 496	android/graphics/Bitmap:getWidth	()I
    //   466: invokestatic 419	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   469: aastore
    //   470: dup
    //   471: bipush 8
    //   473: iconst_0
    //   474: invokestatic 419	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   477: aastore
    //   478: dup
    //   479: bipush 9
    //   481: invokestatic 186	java/lang/System:currentTimeMillis	()J
    //   484: lload 10
    //   486: lsub
    //   487: invokestatic 225	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   490: aastore
    //   491: invokevirtual 745	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   494: aload 15
    //   496: invokestatic 302	com/tencent/mm/vfs/i:eA	(Ljava/lang/String;)Z
    //   499: ifeq +17 -> 516
    //   502: ldc 217
    //   504: ldc_w 1510
    //   507: invokestatic 700	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   510: aload 15
    //   512: invokestatic 1045	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   515: pop
    //   516: aload 12
    //   518: ifnull +8 -> 526
    //   521: aload 12
    //   523: invokevirtual 1511	java/io/OutputStream:close	()V
    //   526: ldc_w 717
    //   529: aload 16
    //   531: invokestatic 720	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   534: invokevirtual 723	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   537: astore_1
    //   538: ldc_w 1455
    //   541: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   544: aload_1
    //   545: areturn
    //   546: astore 13
    //   548: goto -225 -> 323
    //   551: astore 13
    //   553: aconst_null
    //   554: astore 14
    //   556: aload 14
    //   558: astore 13
    //   560: ldc 217
    //   562: ldc_w 1513
    //   565: invokestatic 751	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   568: iload 7
    //   570: istore_3
    //   571: iload 8
    //   573: istore 4
    //   575: aload 14
    //   577: ifnull -254 -> 323
    //   580: aload 12
    //   582: astore 13
    //   584: aload 14
    //   586: invokevirtual 1495	java/io/ByteArrayOutputStream:close	()V
    //   589: iload 7
    //   591: istore_3
    //   592: iload 8
    //   594: istore 4
    //   596: goto -273 -> 323
    //   599: astore 13
    //   601: iload 7
    //   603: istore_3
    //   604: iload 8
    //   606: istore 4
    //   608: goto -285 -> 323
    //   611: astore 5
    //   613: aconst_null
    //   614: astore 14
    //   616: aload 14
    //   618: ifnull +12 -> 630
    //   621: aload 12
    //   623: astore 13
    //   625: aload 14
    //   627: invokevirtual 1495	java/io/ByteArrayOutputStream:close	()V
    //   630: aload 12
    //   632: astore 13
    //   634: ldc_w 1455
    //   637: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   640: aload 12
    //   642: astore 13
    //   644: aload 5
    //   646: athrow
    //   647: astore 13
    //   649: aload 12
    //   651: astore 5
    //   653: aload 13
    //   655: astore 12
    //   657: ldc 217
    //   659: ldc_w 1450
    //   662: iconst_1
    //   663: anewarray 101	java/lang/Object
    //   666: dup
    //   667: iconst_0
    //   668: aload 12
    //   670: aastore
    //   671: invokestatic 612	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   674: aload_0
    //   675: aload_1
    //   676: iconst_1
    //   677: aload_2
    //   678: invokevirtual 1453	com/tencent/mm/av/g:a	([BZLandroid/graphics/Bitmap$CompressFormat;)Ljava/lang/String;
    //   681: astore_1
    //   682: aload 15
    //   684: invokestatic 302	com/tencent/mm/vfs/i:eA	(Ljava/lang/String;)Z
    //   687: ifeq +17 -> 704
    //   690: ldc 217
    //   692: ldc_w 1510
    //   695: invokestatic 700	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   698: aload 15
    //   700: invokestatic 1045	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   703: pop
    //   704: aload 5
    //   706: ifnull +8 -> 714
    //   709: aload 5
    //   711: invokevirtual 1511	java/io/OutputStream:close	()V
    //   714: ldc_w 1455
    //   717: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   720: aload_1
    //   721: areturn
    //   722: aload 12
    //   724: astore 13
    //   726: aload 15
    //   728: aload 17
    //   730: invokestatic 1516	com/tencent/mm/vfs/i:ma	(Ljava/lang/String;Ljava/lang/String;)Z
    //   733: pop
    //   734: iload 7
    //   736: istore_3
    //   737: iload 8
    //   739: istore 4
    //   741: goto -403 -> 338
    //   744: astore 5
    //   746: aload 12
    //   748: astore 13
    //   750: ldc 217
    //   752: ldc_w 1450
    //   755: iconst_1
    //   756: anewarray 101	java/lang/Object
    //   759: dup
    //   760: iconst_0
    //   761: aload 5
    //   763: aastore
    //   764: invokestatic 612	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   767: aload 12
    //   769: astore 13
    //   771: aload_0
    //   772: aload_1
    //   773: iconst_1
    //   774: aload_2
    //   775: invokevirtual 1453	com/tencent/mm/av/g:a	([BZLandroid/graphics/Bitmap$CompressFormat;)Ljava/lang/String;
    //   778: astore_1
    //   779: aload 15
    //   781: invokestatic 302	com/tencent/mm/vfs/i:eA	(Ljava/lang/String;)Z
    //   784: ifeq +17 -> 801
    //   787: ldc 217
    //   789: ldc_w 1510
    //   792: invokestatic 700	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   795: aload 15
    //   797: invokestatic 1045	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   800: pop
    //   801: aload 12
    //   803: ifnull +8 -> 811
    //   806: aload 12
    //   808: invokevirtual 1511	java/io/OutputStream:close	()V
    //   811: ldc_w 1455
    //   814: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   817: aload_1
    //   818: areturn
    //   819: astore_1
    //   820: aconst_null
    //   821: astore 13
    //   823: aload 15
    //   825: invokestatic 302	com/tencent/mm/vfs/i:eA	(Ljava/lang/String;)Z
    //   828: ifeq +17 -> 845
    //   831: ldc 217
    //   833: ldc_w 1510
    //   836: invokestatic 700	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   839: aload 15
    //   841: invokestatic 1045	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   844: pop
    //   845: aload 13
    //   847: ifnull +8 -> 855
    //   850: aload 13
    //   852: invokevirtual 1511	java/io/OutputStream:close	()V
    //   855: ldc_w 1455
    //   858: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   861: aload_1
    //   862: athrow
    //   863: astore 13
    //   865: goto -235 -> 630
    //   868: astore_1
    //   869: goto -343 -> 526
    //   872: astore_2
    //   873: goto -159 -> 714
    //   876: astore_2
    //   877: goto -66 -> 811
    //   880: astore_2
    //   881: goto -26 -> 855
    //   884: astore_1
    //   885: goto -62 -> 823
    //   888: astore_1
    //   889: aload 5
    //   891: astore 13
    //   893: goto -70 -> 823
    //   896: astore 5
    //   898: aconst_null
    //   899: astore 12
    //   901: goto -155 -> 746
    //   904: astore 12
    //   906: aload 13
    //   908: astore 5
    //   910: goto -253 -> 657
    //   913: astore 5
    //   915: aload 13
    //   917: astore 14
    //   919: goto -303 -> 616
    //   922: astore 13
    //   924: goto -368 -> 556
    //   927: astore 13
    //   929: iload 4
    //   931: istore 8
    //   933: goto -377 -> 556
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	936	0	this	g
    //   0	936	1	paramArrayOfByte	byte[]
    //   0	936	2	paramCompressFormat	Bitmap.CompressFormat
    //   0	936	3	paramInt1	int
    //   0	936	4	paramInt2	int
    //   0	936	5	paramString	String
    //   0	936	6	paramBoolean	boolean
    //   179	556	7	i	int
    //   170	762	8	j	int
    //   94	317	9	k	int
    //   32	453	10	l	long
    //   130	770	12	localObject1	Object
    //   904	1	12	localIOException1	IOException
    //   122	252	13	localObject2	Object
    //   546	1	13	localException1	Exception
    //   551	1	13	localException2	Exception
    //   558	25	13	localObject3	Object
    //   599	1	13	localException3	Exception
    //   623	20	13	localObject4	Object
    //   647	7	13	localIOException2	IOException
    //   724	127	13	localObject5	Object
    //   863	1	13	localException4	Exception
    //   891	25	13	str1	String
    //   922	1	13	localException5	Exception
    //   927	1	13	localException6	Exception
    //   202	716	14	localObject6	Object
    //   74	766	15	str2	String
    //   37	493	16	str3	String
    //   51	678	17	str4	String
    //   103	327	18	localOptions	BitmapFactory.Options
    //   162	300	19	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   318	323	546	java/lang/Exception
    //   195	204	551	java/lang/Exception
    //   584	589	599	java/lang/Exception
    //   195	204	611	finally
    //   136	142	647	java/io/IOException
    //   146	151	647	java/io/IOException
    //   155	164	647	java/io/IOException
    //   168	172	647	java/io/IOException
    //   185	188	647	java/io/IOException
    //   318	323	647	java/io/IOException
    //   327	338	647	java/io/IOException
    //   342	371	647	java/io/IOException
    //   375	494	647	java/io/IOException
    //   584	589	647	java/io/IOException
    //   625	630	647	java/io/IOException
    //   634	640	647	java/io/IOException
    //   644	647	647	java/io/IOException
    //   726	734	647	java/io/IOException
    //   136	142	744	java/lang/Exception
    //   146	151	744	java/lang/Exception
    //   155	164	744	java/lang/Exception
    //   168	172	744	java/lang/Exception
    //   185	188	744	java/lang/Exception
    //   327	338	744	java/lang/Exception
    //   342	371	744	java/lang/Exception
    //   375	494	744	java/lang/Exception
    //   634	640	744	java/lang/Exception
    //   644	647	744	java/lang/Exception
    //   726	734	744	java/lang/Exception
    //   124	132	819	finally
    //   625	630	863	java/lang/Exception
    //   521	526	868	java/lang/Exception
    //   709	714	872	java/lang/Exception
    //   806	811	876	java/lang/Exception
    //   850	855	880	java/lang/Exception
    //   136	142	884	finally
    //   146	151	884	finally
    //   155	164	884	finally
    //   168	172	884	finally
    //   185	188	884	finally
    //   318	323	884	finally
    //   327	338	884	finally
    //   342	371	884	finally
    //   375	494	884	finally
    //   584	589	884	finally
    //   625	630	884	finally
    //   634	640	884	finally
    //   644	647	884	finally
    //   726	734	884	finally
    //   750	767	884	finally
    //   771	779	884	finally
    //   657	682	888	finally
    //   124	132	896	java/lang/Exception
    //   124	132	904	java/io/IOException
    //   208	219	913	finally
    //   223	231	913	finally
    //   241	253	913	finally
    //   266	271	913	finally
    //   282	292	913	finally
    //   299	307	913	finally
    //   560	568	913	finally
    //   208	219	922	java/lang/Exception
    //   223	231	922	java/lang/Exception
    //   241	253	927	java/lang/Exception
    //   266	271	927	java/lang/Exception
    //   282	292	927	java/lang/Exception
    //   299	307	927	java/lang/Exception
  }
  
  /* Error */
  public final String a(byte[] paramArrayOfByte, Bitmap.CompressFormat paramCompressFormat, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 1518
    //   3: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 1438	com/tencent/mm/sdk/platformtools/bs:cv	([B)Z
    //   10: ifeq +19 -> 29
    //   13: ldc 217
    //   15: ldc_w 1440
    //   18: invokestatic 751	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc_w 1518
    //   24: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aconst_null
    //   28: areturn
    //   29: invokestatic 186	java/lang/System:currentTimeMillis	()J
    //   32: lstore 10
    //   34: invokestatic 715	com/tencent/mm/av/g:aFg	()Ljava/lang/String;
    //   37: astore 17
    //   39: aload_0
    //   40: aload 17
    //   42: ldc_w 725
    //   45: ldc_w 288
    //   48: invokevirtual 292	com/tencent/mm/av/g:p	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   51: astore 19
    //   53: new 193	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   60: aload 19
    //   62: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: ldc_w 1457
    //   68: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: astore 16
    //   76: ldc 217
    //   78: ldc_w 1459
    //   81: aload 19
    //   83: invokestatic 720	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   86: invokevirtual 723	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   89: invokestatic 700	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: aload_1
    //   93: arraylength
    //   94: istore 9
    //   96: new 1281	android/graphics/BitmapFactory$Options
    //   99: dup
    //   100: invokespecial 1460	android/graphics/BitmapFactory$Options:<init>	()V
    //   103: astore 18
    //   105: aload 18
    //   107: iconst_1
    //   108: putfield 1464	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   111: aload_1
    //   112: iconst_0
    //   113: aload_1
    //   114: arraylength
    //   115: aload 18
    //   117: invokestatic 1467	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   120: pop
    //   121: aload 18
    //   123: getfield 1284	android/graphics/BitmapFactory$Options:outWidth	I
    //   126: istore 7
    //   128: aload 18
    //   130: getfield 1287	android/graphics/BitmapFactory$Options:outHeight	I
    //   133: istore 6
    //   135: sipush 720
    //   138: iload 7
    //   140: if_icmpgt +13 -> 153
    //   143: ldc_w 1519
    //   146: iload 6
    //   148: i2f
    //   149: fcmpl
    //   150: ifle +283 -> 433
    //   153: iload 7
    //   155: istore 5
    //   157: aconst_null
    //   158: astore 13
    //   160: aload 16
    //   162: iconst_0
    //   163: invokestatic 1471	com/tencent/mm/vfs/i:cS	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   166: astore 12
    //   168: aload 12
    //   170: astore 13
    //   172: aload 12
    //   174: aload_1
    //   175: invokevirtual 1476	java/io/OutputStream:write	([B)V
    //   178: aload 12
    //   180: astore 13
    //   182: aload 12
    //   184: invokevirtual 1479	java/io/OutputStream:flush	()V
    //   187: aload 12
    //   189: astore 13
    //   191: aload_1
    //   192: iload 5
    //   194: iload 6
    //   196: invokestatic 1480	com/tencent/mm/sdk/platformtools/f:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   199: astore 14
    //   201: aload 12
    //   203: astore 13
    //   205: iload 5
    //   207: aload 14
    //   209: invokevirtual 496	android/graphics/Bitmap:getWidth	()I
    //   212: if_icmpeq +240 -> 452
    //   215: aload 12
    //   217: astore 13
    //   219: aload 14
    //   221: iload 5
    //   223: iload 6
    //   225: iconst_1
    //   226: invokestatic 586	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   229: astore 14
    //   231: aload 12
    //   233: astore 13
    //   235: aload 14
    //   237: invokevirtual 501	android/graphics/Bitmap:getHeight	()I
    //   240: i2f
    //   241: aload 14
    //   243: invokevirtual 496	android/graphics/Bitmap:getWidth	()I
    //   246: i2f
    //   247: ldc_w 1520
    //   250: fmul
    //   251: fcmpl
    //   252: ifle +203 -> 455
    //   255: aload 12
    //   257: astore 13
    //   259: aload 14
    //   261: iconst_0
    //   262: iconst_0
    //   263: aload 14
    //   265: invokevirtual 496	android/graphics/Bitmap:getWidth	()I
    //   268: aload 14
    //   270: invokevirtual 496	android/graphics/Bitmap:getWidth	()I
    //   273: i2f
    //   274: ldc_w 1520
    //   277: fmul
    //   278: f2i
    //   279: invokestatic 1524	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   282: astore 15
    //   284: aload 12
    //   286: astore 13
    //   288: aload_1
    //   289: arraylength
    //   290: istore 6
    //   292: aload 15
    //   294: ifnull +404 -> 698
    //   297: bipush 70
    //   299: istore 5
    //   301: new 1483	java/io/ByteArrayOutputStream
    //   304: dup
    //   305: invokespecial 1484	java/io/ByteArrayOutputStream:<init>	()V
    //   308: astore 14
    //   310: aload 14
    //   312: astore 13
    //   314: aload 15
    //   316: aload_2
    //   317: bipush 70
    //   319: aload 14
    //   321: invokevirtual 1488	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   324: pop
    //   325: aload 14
    //   327: astore 13
    //   329: aload 14
    //   331: invokevirtual 1491	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   334: arraylength
    //   335: istore 7
    //   337: bipush 70
    //   339: istore 5
    //   341: iload 7
    //   343: istore 6
    //   345: aload 14
    //   347: astore 13
    //   349: iload 5
    //   351: istore 7
    //   353: aload 14
    //   355: invokevirtual 1491	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   358: arraylength
    //   359: ldc_w 1481
    //   362: if_icmple +125 -> 487
    //   365: iload 5
    //   367: bipush 15
    //   369: if_icmplt +118 -> 487
    //   372: aload 14
    //   374: astore 13
    //   376: iload 5
    //   378: istore 7
    //   380: aload 14
    //   382: invokevirtual 1494	java/io/ByteArrayOutputStream:reset	()V
    //   385: iload 5
    //   387: iconst_5
    //   388: isub
    //   389: istore 5
    //   391: aload 14
    //   393: astore 13
    //   395: iload 5
    //   397: istore 7
    //   399: aload 15
    //   401: aload_2
    //   402: iload 5
    //   404: aload 14
    //   406: invokevirtual 1488	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   409: pop
    //   410: aload 14
    //   412: astore 13
    //   414: iload 5
    //   416: istore 7
    //   418: aload 14
    //   420: invokevirtual 1491	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   423: arraylength
    //   424: istore 8
    //   426: iload 8
    //   428: istore 6
    //   430: goto -85 -> 345
    //   433: sipush 720
    //   436: istore 5
    //   438: iload 6
    //   440: sipush 720
    //   443: imul
    //   444: iload 7
    //   446: idiv
    //   447: istore 6
    //   449: goto -292 -> 157
    //   452: goto -221 -> 231
    //   455: aload 12
    //   457: astore 13
    //   459: aload 14
    //   461: iconst_0
    //   462: iconst_0
    //   463: aload 14
    //   465: invokevirtual 501	android/graphics/Bitmap:getHeight	()I
    //   468: i2f
    //   469: ldc_w 1520
    //   472: fdiv
    //   473: f2i
    //   474: aload 14
    //   476: invokevirtual 501	android/graphics/Bitmap:getHeight	()I
    //   479: invokestatic 1524	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   482: astore 15
    //   484: goto -200 -> 284
    //   487: aload 12
    //   489: astore 13
    //   491: aload 14
    //   493: invokevirtual 1495	java/io/ByteArrayOutputStream:close	()V
    //   496: iload 6
    //   498: istore 8
    //   500: iload 5
    //   502: istore 7
    //   504: aload 12
    //   506: astore 13
    //   508: aload 15
    //   510: iload 7
    //   512: aload_2
    //   513: aload 19
    //   515: iconst_1
    //   516: invokestatic 533	com/tencent/mm/sdk/platformtools/f:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   519: pop
    //   520: aload 12
    //   522: astore 13
    //   524: ldc 217
    //   526: ldc_w 1497
    //   529: iconst_3
    //   530: anewarray 101	java/lang/Object
    //   533: dup
    //   534: iconst_0
    //   535: aload 16
    //   537: aastore
    //   538: dup
    //   539: iconst_1
    //   540: aload 19
    //   542: aastore
    //   543: dup
    //   544: iconst_2
    //   545: iload 7
    //   547: invokestatic 419	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   550: aastore
    //   551: invokestatic 320	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   554: aload 12
    //   556: astore 13
    //   558: getstatic 739	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   561: astore 14
    //   563: aload 12
    //   565: astore 13
    //   567: aload_3
    //   568: invokestatic 1500	com/tencent/mm/sdk/platformtools/bs:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   571: ldc_w 1502
    //   574: invokestatic 1508	com/tencent/mm/compatible/util/p:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   577: astore_3
    //   578: iload 4
    //   580: ifeq +352 -> 932
    //   583: iconst_1
    //   584: istore 5
    //   586: aload 12
    //   588: astore 13
    //   590: aload 14
    //   592: sipush 16498
    //   595: bipush 10
    //   597: anewarray 101	java/lang/Object
    //   600: dup
    //   601: iconst_0
    //   602: aload_3
    //   603: aastore
    //   604: dup
    //   605: iconst_1
    //   606: iload 5
    //   608: invokestatic 419	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   611: aastore
    //   612: dup
    //   613: iconst_2
    //   614: iload 9
    //   616: invokestatic 419	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   619: aastore
    //   620: dup
    //   621: iconst_3
    //   622: aload 18
    //   624: getfield 1287	android/graphics/BitmapFactory$Options:outHeight	I
    //   627: invokestatic 419	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   630: aastore
    //   631: dup
    //   632: iconst_4
    //   633: aload 18
    //   635: getfield 1284	android/graphics/BitmapFactory$Options:outWidth	I
    //   638: invokestatic 419	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   641: aastore
    //   642: dup
    //   643: iconst_5
    //   644: iload 8
    //   646: invokestatic 419	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   649: aastore
    //   650: dup
    //   651: bipush 6
    //   653: aload 15
    //   655: invokevirtual 501	android/graphics/Bitmap:getHeight	()I
    //   658: invokestatic 419	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   661: aastore
    //   662: dup
    //   663: bipush 7
    //   665: aload 15
    //   667: invokevirtual 496	android/graphics/Bitmap:getWidth	()I
    //   670: invokestatic 419	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   673: aastore
    //   674: dup
    //   675: bipush 8
    //   677: iconst_1
    //   678: invokestatic 419	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   681: aastore
    //   682: dup
    //   683: bipush 9
    //   685: invokestatic 186	java/lang/System:currentTimeMillis	()J
    //   688: lload 10
    //   690: lsub
    //   691: invokestatic 225	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   694: aastore
    //   695: invokevirtual 745	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   698: aload 16
    //   700: invokestatic 302	com/tencent/mm/vfs/i:eA	(Ljava/lang/String;)Z
    //   703: ifeq +17 -> 720
    //   706: ldc 217
    //   708: ldc_w 1510
    //   711: invokestatic 700	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   714: aload 16
    //   716: invokestatic 1045	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   719: pop
    //   720: aload 12
    //   722: ifnull +8 -> 730
    //   725: aload 12
    //   727: invokevirtual 1511	java/io/OutputStream:close	()V
    //   730: ldc_w 717
    //   733: aload 17
    //   735: invokestatic 720	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   738: invokevirtual 723	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   741: astore_1
    //   742: ldc_w 1518
    //   745: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   748: aload_1
    //   749: areturn
    //   750: astore 13
    //   752: iload 5
    //   754: istore 7
    //   756: iload 6
    //   758: istore 8
    //   760: goto -256 -> 504
    //   763: astore 13
    //   765: aconst_null
    //   766: astore 14
    //   768: aload 14
    //   770: astore 13
    //   772: ldc 217
    //   774: ldc_w 1513
    //   777: invokestatic 751	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   780: iload 5
    //   782: istore 7
    //   784: iload 6
    //   786: istore 8
    //   788: aload 14
    //   790: ifnull -286 -> 504
    //   793: aload 12
    //   795: astore 13
    //   797: aload 14
    //   799: invokevirtual 1495	java/io/ByteArrayOutputStream:close	()V
    //   802: iload 5
    //   804: istore 7
    //   806: iload 6
    //   808: istore 8
    //   810: goto -306 -> 504
    //   813: astore 13
    //   815: iload 5
    //   817: istore 7
    //   819: iload 6
    //   821: istore 8
    //   823: goto -319 -> 504
    //   826: astore_3
    //   827: aconst_null
    //   828: astore 14
    //   830: aload 14
    //   832: ifnull +12 -> 844
    //   835: aload 12
    //   837: astore 13
    //   839: aload 14
    //   841: invokevirtual 1495	java/io/ByteArrayOutputStream:close	()V
    //   844: aload 12
    //   846: astore 13
    //   848: ldc_w 1518
    //   851: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   854: aload 12
    //   856: astore 13
    //   858: aload_3
    //   859: athrow
    //   860: astore 13
    //   862: aload 12
    //   864: astore_3
    //   865: aload 13
    //   867: astore 12
    //   869: ldc 217
    //   871: ldc_w 1450
    //   874: iconst_1
    //   875: anewarray 101	java/lang/Object
    //   878: dup
    //   879: iconst_0
    //   880: aload 12
    //   882: aastore
    //   883: invokestatic 612	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   886: aload_0
    //   887: aload_1
    //   888: iconst_1
    //   889: aload_2
    //   890: invokevirtual 1453	com/tencent/mm/av/g:a	([BZLandroid/graphics/Bitmap$CompressFormat;)Ljava/lang/String;
    //   893: astore_1
    //   894: aload 16
    //   896: invokestatic 302	com/tencent/mm/vfs/i:eA	(Ljava/lang/String;)Z
    //   899: ifeq +17 -> 916
    //   902: ldc 217
    //   904: ldc_w 1510
    //   907: invokestatic 700	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   910: aload 16
    //   912: invokestatic 1045	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   915: pop
    //   916: aload_3
    //   917: ifnull +7 -> 924
    //   920: aload_3
    //   921: invokevirtual 1511	java/io/OutputStream:close	()V
    //   924: ldc_w 1518
    //   927: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   930: aload_1
    //   931: areturn
    //   932: iconst_0
    //   933: istore 5
    //   935: goto -349 -> 586
    //   938: astore_3
    //   939: aconst_null
    //   940: astore 12
    //   942: aload 12
    //   944: astore 13
    //   946: ldc 217
    //   948: ldc_w 1450
    //   951: iconst_1
    //   952: anewarray 101	java/lang/Object
    //   955: dup
    //   956: iconst_0
    //   957: aload_3
    //   958: aastore
    //   959: invokestatic 612	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   962: aload 12
    //   964: astore 13
    //   966: aload_0
    //   967: aload_1
    //   968: iconst_1
    //   969: aload_2
    //   970: invokevirtual 1453	com/tencent/mm/av/g:a	([BZLandroid/graphics/Bitmap$CompressFormat;)Ljava/lang/String;
    //   973: astore_1
    //   974: aload 16
    //   976: invokestatic 302	com/tencent/mm/vfs/i:eA	(Ljava/lang/String;)Z
    //   979: ifeq +17 -> 996
    //   982: ldc 217
    //   984: ldc_w 1510
    //   987: invokestatic 700	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   990: aload 16
    //   992: invokestatic 1045	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   995: pop
    //   996: aload 12
    //   998: ifnull +8 -> 1006
    //   1001: aload 12
    //   1003: invokevirtual 1511	java/io/OutputStream:close	()V
    //   1006: ldc_w 1518
    //   1009: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1012: aload_1
    //   1013: areturn
    //   1014: astore_1
    //   1015: aconst_null
    //   1016: astore 13
    //   1018: aload 16
    //   1020: invokestatic 302	com/tencent/mm/vfs/i:eA	(Ljava/lang/String;)Z
    //   1023: ifeq +17 -> 1040
    //   1026: ldc 217
    //   1028: ldc_w 1510
    //   1031: invokestatic 700	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1034: aload 16
    //   1036: invokestatic 1045	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   1039: pop
    //   1040: aload 13
    //   1042: ifnull +8 -> 1050
    //   1045: aload 13
    //   1047: invokevirtual 1511	java/io/OutputStream:close	()V
    //   1050: ldc_w 1518
    //   1053: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1056: aload_1
    //   1057: athrow
    //   1058: astore 13
    //   1060: goto -216 -> 844
    //   1063: astore_1
    //   1064: goto -334 -> 730
    //   1067: astore_2
    //   1068: goto -144 -> 924
    //   1071: astore_2
    //   1072: goto -66 -> 1006
    //   1075: astore_2
    //   1076: goto -26 -> 1050
    //   1079: astore_1
    //   1080: goto -62 -> 1018
    //   1083: astore_1
    //   1084: aload_3
    //   1085: astore 13
    //   1087: goto -69 -> 1018
    //   1090: astore_3
    //   1091: goto -149 -> 942
    //   1094: astore 12
    //   1096: aload 13
    //   1098: astore_3
    //   1099: goto -230 -> 869
    //   1102: astore_3
    //   1103: aload 13
    //   1105: astore 14
    //   1107: goto -277 -> 830
    //   1110: astore 13
    //   1112: goto -344 -> 768
    //   1115: astore 13
    //   1117: iload 7
    //   1119: istore 5
    //   1121: goto -353 -> 768
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1124	0	this	g
    //   0	1124	1	paramArrayOfByte	byte[]
    //   0	1124	2	paramCompressFormat	Bitmap.CompressFormat
    //   0	1124	3	paramString	String
    //   0	1124	4	paramBoolean	boolean
    //   155	965	5	i	int
    //   133	687	6	j	int
    //   126	992	7	k	int
    //   424	398	8	m	int
    //   94	521	9	n	int
    //   32	657	10	l	long
    //   166	836	12	localObject1	Object
    //   1094	1	12	localIOException1	IOException
    //   158	431	13	localObject2	Object
    //   750	1	13	localException1	Exception
    //   763	1	13	localException2	Exception
    //   770	26	13	localObject3	Object
    //   813	1	13	localException3	Exception
    //   837	20	13	localObject4	Object
    //   860	6	13	localIOException2	IOException
    //   944	102	13	localObject5	Object
    //   1058	1	13	localException4	Exception
    //   1085	19	13	str1	String
    //   1110	1	13	localException5	Exception
    //   1115	1	13	localException6	Exception
    //   199	907	14	localObject6	Object
    //   282	384	15	localBitmap	Bitmap
    //   74	961	16	str2	String
    //   37	697	17	str3	String
    //   103	531	18	localOptions	BitmapFactory.Options
    //   51	490	19	str4	String
    // Exception table:
    //   from	to	target	type
    //   491	496	750	java/lang/Exception
    //   301	310	763	java/lang/Exception
    //   797	802	813	java/lang/Exception
    //   301	310	826	finally
    //   172	178	860	java/io/IOException
    //   182	187	860	java/io/IOException
    //   191	201	860	java/io/IOException
    //   205	215	860	java/io/IOException
    //   219	231	860	java/io/IOException
    //   235	255	860	java/io/IOException
    //   259	284	860	java/io/IOException
    //   288	292	860	java/io/IOException
    //   459	484	860	java/io/IOException
    //   491	496	860	java/io/IOException
    //   508	520	860	java/io/IOException
    //   524	554	860	java/io/IOException
    //   558	563	860	java/io/IOException
    //   567	578	860	java/io/IOException
    //   590	698	860	java/io/IOException
    //   797	802	860	java/io/IOException
    //   839	844	860	java/io/IOException
    //   848	854	860	java/io/IOException
    //   858	860	860	java/io/IOException
    //   160	168	938	java/lang/Exception
    //   160	168	1014	finally
    //   839	844	1058	java/lang/Exception
    //   725	730	1063	java/lang/Exception
    //   920	924	1067	java/lang/Exception
    //   1001	1006	1071	java/lang/Exception
    //   1045	1050	1075	java/lang/Exception
    //   172	178	1079	finally
    //   182	187	1079	finally
    //   191	201	1079	finally
    //   205	215	1079	finally
    //   219	231	1079	finally
    //   235	255	1079	finally
    //   259	284	1079	finally
    //   288	292	1079	finally
    //   459	484	1079	finally
    //   491	496	1079	finally
    //   508	520	1079	finally
    //   524	554	1079	finally
    //   558	563	1079	finally
    //   567	578	1079	finally
    //   590	698	1079	finally
    //   797	802	1079	finally
    //   839	844	1079	finally
    //   848	854	1079	finally
    //   858	860	1079	finally
    //   946	962	1079	finally
    //   966	974	1079	finally
    //   869	894	1083	finally
    //   172	178	1090	java/lang/Exception
    //   182	187	1090	java/lang/Exception
    //   191	201	1090	java/lang/Exception
    //   205	215	1090	java/lang/Exception
    //   219	231	1090	java/lang/Exception
    //   235	255	1090	java/lang/Exception
    //   259	284	1090	java/lang/Exception
    //   288	292	1090	java/lang/Exception
    //   459	484	1090	java/lang/Exception
    //   508	520	1090	java/lang/Exception
    //   524	554	1090	java/lang/Exception
    //   558	563	1090	java/lang/Exception
    //   567	578	1090	java/lang/Exception
    //   590	698	1090	java/lang/Exception
    //   848	854	1090	java/lang/Exception
    //   858	860	1090	java/lang/Exception
    //   160	168	1094	java/io/IOException
    //   314	325	1102	finally
    //   329	337	1102	finally
    //   353	365	1102	finally
    //   380	385	1102	finally
    //   399	410	1102	finally
    //   418	426	1102	finally
    //   772	780	1102	finally
    //   314	325	1110	java/lang/Exception
    //   329	337	1110	java/lang/Exception
    //   353	365	1115	java/lang/Exception
    //   380	385	1115	java/lang/Exception
    //   399	410	1115	java/lang/Exception
    //   418	426	1115	java/lang/Exception
  }
  
  public final String a(byte[] paramArrayOfByte, boolean paramBoolean, Bitmap.CompressFormat paramCompressFormat)
  {
    AppMethodBeat.i(150575);
    paramArrayOfByte = a(paramArrayOfByte, paramBoolean, paramCompressFormat, false);
    AppMethodBeat.o(150575);
    return paramArrayOfByte;
  }
  
  /* Error */
  public final String a(byte[] paramArrayOfByte, boolean paramBoolean1, Bitmap.CompressFormat paramCompressFormat, boolean paramBoolean2)
  {
    // Byte code:
    //   0: ldc_w 1529
    //   3: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 1438	com/tencent/mm/sdk/platformtools/bs:cv	([B)Z
    //   10: ifeq +19 -> 29
    //   13: ldc 217
    //   15: ldc_w 1440
    //   18: invokestatic 751	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc_w 1529
    //   24: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aconst_null
    //   28: areturn
    //   29: invokestatic 715	com/tencent/mm/av/g:aFg	()Ljava/lang/String;
    //   32: astore 9
    //   34: aload_0
    //   35: aload 9
    //   37: ldc_w 725
    //   40: ldc_w 288
    //   43: invokevirtual 292	com/tencent/mm/av/g:p	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   46: astore 10
    //   48: new 193	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   55: aload 10
    //   57: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: ldc_w 1457
    //   63: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: astore 8
    //   71: ldc 217
    //   73: ldc_w 1459
    //   76: aload 10
    //   78: invokestatic 720	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   81: invokevirtual 723	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   84: invokestatic 700	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: aload 8
    //   89: iconst_0
    //   90: invokestatic 1471	com/tencent/mm/vfs/i:cS	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   93: astore 7
    //   95: aload 7
    //   97: aload_1
    //   98: invokevirtual 1476	java/io/OutputStream:write	([B)V
    //   101: aload 7
    //   103: invokevirtual 1479	java/io/OutputStream:flush	()V
    //   106: iload_2
    //   107: ifeq +112 -> 219
    //   110: sipush 128
    //   113: istore 5
    //   115: goto +294 -> 409
    //   118: iload 4
    //   120: ifeq +113 -> 233
    //   123: aload 8
    //   125: aconst_null
    //   126: invokestatic 1533	com/tencent/mm/sdk/platformtools/f:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   129: astore_1
    //   130: aload_1
    //   131: ifnull +36 -> 167
    //   134: aload_1
    //   135: bipush 90
    //   137: aload_3
    //   138: aload 10
    //   140: iconst_1
    //   141: invokestatic 533	com/tencent/mm/sdk/platformtools/f:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   144: pop
    //   145: ldc 217
    //   147: ldc_w 1535
    //   150: iconst_2
    //   151: anewarray 101	java/lang/Object
    //   154: dup
    //   155: iconst_0
    //   156: aload 8
    //   158: aastore
    //   159: dup
    //   160: iconst_1
    //   161: aload 10
    //   163: aastore
    //   164: invokestatic 320	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   167: aload 8
    //   169: invokestatic 302	com/tencent/mm/vfs/i:eA	(Ljava/lang/String;)Z
    //   172: ifeq +17 -> 189
    //   175: ldc 217
    //   177: ldc_w 1510
    //   180: invokestatic 700	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: aload 8
    //   185: invokestatic 1045	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   188: pop
    //   189: aload 7
    //   191: ifnull +8 -> 199
    //   194: aload 7
    //   196: invokevirtual 1511	java/io/OutputStream:close	()V
    //   199: ldc_w 717
    //   202: aload 9
    //   204: invokestatic 720	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   207: invokevirtual 723	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   210: astore_1
    //   211: ldc_w 1529
    //   214: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   217: aload_1
    //   218: areturn
    //   219: bipush 120
    //   221: istore 5
    //   223: goto +186 -> 409
    //   226: bipush 120
    //   228: istore 6
    //   230: goto -112 -> 118
    //   233: aload 8
    //   235: iload 5
    //   237: iload 6
    //   239: iconst_0
    //   240: invokestatic 1538	com/tencent/mm/sdk/platformtools/f:e	(Ljava/lang/String;IIZ)Landroid/graphics/Bitmap;
    //   243: astore_1
    //   244: goto -114 -> 130
    //   247: astore_3
    //   248: aconst_null
    //   249: astore_1
    //   250: getstatic 739	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   253: ldc2_w 1152
    //   256: ldc2_w 1539
    //   259: lconst_1
    //   260: iconst_0
    //   261: invokevirtual 1159	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   264: ldc 217
    //   266: new 193	java/lang/StringBuilder
    //   269: dup
    //   270: ldc_w 1542
    //   273: invokespecial 695	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   276: aload 9
    //   278: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: ldc_w 1544
    //   284: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload_3
    //   288: invokevirtual 1166	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   291: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokestatic 751	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   300: aload 8
    //   302: invokestatic 302	com/tencent/mm/vfs/i:eA	(Ljava/lang/String;)Z
    //   305: ifeq +17 -> 322
    //   308: ldc 217
    //   310: ldc_w 1510
    //   313: invokestatic 700	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: aload 8
    //   318: invokestatic 1045	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   321: pop
    //   322: aload_1
    //   323: ifnull +7 -> 330
    //   326: aload_1
    //   327: invokevirtual 1511	java/io/OutputStream:close	()V
    //   330: ldc_w 1529
    //   333: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   336: aconst_null
    //   337: areturn
    //   338: astore_3
    //   339: aconst_null
    //   340: astore_1
    //   341: aload 8
    //   343: invokestatic 302	com/tencent/mm/vfs/i:eA	(Ljava/lang/String;)Z
    //   346: ifeq +17 -> 363
    //   349: ldc 217
    //   351: ldc_w 1510
    //   354: invokestatic 700	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   357: aload 8
    //   359: invokestatic 1045	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   362: pop
    //   363: aload_1
    //   364: ifnull +7 -> 371
    //   367: aload_1
    //   368: invokevirtual 1511	java/io/OutputStream:close	()V
    //   371: ldc_w 1529
    //   374: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   377: aload_3
    //   378: athrow
    //   379: astore_1
    //   380: goto -181 -> 199
    //   383: astore_1
    //   384: goto -54 -> 330
    //   387: astore_1
    //   388: goto -17 -> 371
    //   391: astore_3
    //   392: aload 7
    //   394: astore_1
    //   395: goto -54 -> 341
    //   398: astore_3
    //   399: goto -58 -> 341
    //   402: astore_3
    //   403: aload 7
    //   405: astore_1
    //   406: goto -156 -> 250
    //   409: iload_2
    //   410: ifeq -184 -> 226
    //   413: sipush 128
    //   416: istore 6
    //   418: goto -300 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	421	0	this	g
    //   0	421	1	paramArrayOfByte	byte[]
    //   0	421	2	paramBoolean1	boolean
    //   0	421	3	paramCompressFormat	Bitmap.CompressFormat
    //   0	421	4	paramBoolean2	boolean
    //   113	123	5	i	int
    //   228	189	6	j	int
    //   93	311	7	localOutputStream	java.io.OutputStream
    //   69	289	8	str1	String
    //   32	245	9	str2	String
    //   46	116	10	str3	String
    // Exception table:
    //   from	to	target	type
    //   87	95	247	java/lang/Exception
    //   87	95	338	finally
    //   194	199	379	java/lang/Exception
    //   326	330	383	java/lang/Exception
    //   367	371	387	java/lang/Exception
    //   95	106	391	finally
    //   123	130	391	finally
    //   134	167	391	finally
    //   233	244	391	finally
    //   250	300	398	finally
    //   95	106	402	java/lang/Exception
    //   123	130	402	java/lang/Exception
    //   134	167	402	java/lang/Exception
    //   233	244	402	java/lang/Exception
  }
  
  public final HashMap<Long, e> a(Long... paramVarArgs)
  {
    AppMethodBeat.i(150601);
    Object localObject1 = "(";
    int k = paramVarArgs.length;
    int i = 0;
    int j = 1;
    Object localObject2;
    if (i < k)
    {
      long l = paramVarArgs[i].longValue();
      localObject2 = new StringBuilder().append((String)localObject1);
      if (j != 0) {}
      for (localObject1 = Long.valueOf(l);; localObject1 = ",".concat(String.valueOf(l)))
      {
        localObject1 = localObject1;
        i += 1;
        j = 0;
        break;
      }
    }
    paramVarArgs = b("ImgInfo2", null, "msgSvrId in ".concat(String.valueOf((String)localObject1 + ")")), null);
    localObject1 = new HashMap();
    while (paramVarArgs.moveToNext())
    {
      localObject2 = new e();
      ((e)localObject2).convertFrom(paramVarArgs);
      ((HashMap)localObject1).put(Long.valueOf(((e)localObject2).dpl), localObject2);
    }
    paramVarArgs.close();
    AppMethodBeat.o(150601);
    return localObject1;
  }
  
  public final boolean a(ImageView paramImageView1, String paramString, float paramFloat, int paramInt1, int paramInt2, ImageView paramImageView2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(150584);
    boolean bool = a(paramImageView1, paramString, false, paramFloat, paramInt1, paramInt2, paramImageView2, paramInt3, paramInt4, paramView);
    AppMethodBeat.o(150584);
    return bool;
  }
  
  public final boolean a(ImageView paramImageView1, String paramString, boolean paramBoolean, float paramFloat, int paramInt1, int paramInt2, ImageView paramImageView2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(150585);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.ImgInfoStorage", "invalid uri is %s", new Object[] { paramString });
      AppMethodBeat.o(150585);
      return false;
    }
    label586:
    label598:
    label613:
    label1126:
    for (;;)
    {
      synchronized (this.hHD)
      {
        boolean bool = this.hHD.containsKey(paramString);
        String str = b(paramString, paramBoolean, false);
        if (bs.isNullOrNil(str))
        {
          ac.e("MicroMsg.ImgInfoStorage", "getFullThumbPathByCache uri is null, uri:%s", new Object[] { bs.nullAsNil(paramString) });
          AppMethodBeat.o(150585);
          return false;
        }
        localObject = str;
        if (!bool)
        {
          localObject = str;
          if (!str.endsWith("hd"))
          {
            localObject = str;
            if (i.eA(str + "hd"))
            {
              this.hHD.put(paramString, str + "hd");
              localObject = str + "hd";
            }
          }
        }
        if (!((String)localObject).endsWith("hd")) {
          break label1126;
        }
        paramString = (Bitmap)this.hHw.aJ(localObject);
        if (paramString == null)
        {
          a(paramImageView1, paramImageView2, paramView, (String)localObject, paramFloat);
          localObject = ((String)localObject).substring(0, ((String)localObject).length() - 2);
          i = 1;
          if (paramString != null) {
            break label1123;
          }
          paramString = (Bitmap)this.hHw.aJ(localObject);
          if ((paramString == null) || (paramString.isRecycled())) {
            break label653;
          }
          ac.i("MicroMsg.ImgInfoStorage", "[setbitmapFromUri] bitmap width %d,height %d", new Object[] { Integer.valueOf(paramString.getWidth()), Integer.valueOf(paramString.getHeight()) });
          paramImageView1.setBackgroundDrawable(null);
          g.a.a(paramString, paramImageView1);
          if (paramImageView1.getLayoutParams().width == -2) {
            break label586;
          }
          localObject = this.hHF;
          if (paramInt4 != 0) {
            break label598;
          }
          ((FrameLayout.LayoutParams)localObject).gravity = 5;
          paramImageView1.setLayoutParams((ViewGroup.LayoutParams)localObject);
          if (paramString.getWidth() < paramString.getHeight() * 2.5D) {
            break label613;
          }
          paramInt1 = 1;
          if (paramString.getHeight() < paramString.getWidth() * 2.5D) {
            break label619;
          }
          paramInt2 = 1;
          if ((paramInt1 != 0) || (paramInt2 != 0)) {
            paramImageView1.setScaleType(ImageView.ScaleType.CENTER);
          }
          if (paramImageView2 != null)
          {
            paramImageView1 = new FrameLayout.LayoutParams(paramString.getWidth(), paramString.getHeight());
            if (paramInt4 != 0) {
              break label625;
            }
            paramImageView1.gravity = 5;
            paramImageView2.setLayoutParams(paramImageView1);
          }
          if (paramView != null)
          {
            paramImageView1 = new FrameLayout.LayoutParams(paramString.getWidth(), paramString.getHeight());
            if (paramInt4 != 0) {
              break label639;
            }
            paramImageView1.gravity = 5;
            paramView.setLayoutParams(paramImageView1);
          }
          AppMethodBeat.o(150585);
          return true;
        }
      }
      if (this.hHw.remove(((String)localObject).substring(0, ((String)localObject).length() - 2)) != null) {
        ac.d("MicroMsg.ImgInfoStorage", "remove low quality thumb from cacheMap, path: ".concat(String.valueOf(localObject)));
      }
      int i = 0;
      continue;
      Object localObject = (FrameLayout.LayoutParams)paramImageView1.getLayoutParams();
      continue;
      label742:
      if (paramInt4 == 1)
      {
        ((FrameLayout.LayoutParams)localObject).gravity = 3;
        continue;
        paramInt1 = 0;
        continue;
        label619:
        paramInt2 = 0;
        continue;
        label625:
        if (paramInt4 == 1)
        {
          paramImageView1.gravity = 3;
          continue;
          label639:
          if (paramInt4 == 1)
          {
            paramImageView1.gravity = 3;
            continue;
            float f;
            if (paramInt3 > 0)
            {
              paramImageView1.setBackgroundResource(paramInt3);
              paramImageView1.setImageDrawable(null);
              if ((paramInt1 >= 160) || (paramInt2 >= 160)) {
                if (paramInt2 > paramInt1)
                {
                  f = 160.0F / paramInt2;
                  paramInt1 = (int)(paramInt1 * f);
                  paramInt2 = (int)(f * paramInt2);
                  if (paramInt1 <= 0) {
                    break label919;
                  }
                  paramInt3 = (int)(paramInt1 * paramFloat);
                  if (paramInt2 <= 0) {
                    break label926;
                  }
                  paramInt1 = paramInt2;
                  paramInt1 = (int)(paramInt1 * paramFloat);
                  paramInt2 = paramInt3;
                  if (paramInt2 >= 60.0F * paramFloat) {
                    break label1120;
                  }
                  ac.d("MicroMsg.ImgInfoStorage", "pic to small width is %d ", new Object[] { Integer.valueOf(paramInt2) });
                  paramInt2 = (int)(60.0F * paramFloat);
                }
              }
            }
            for (;;)
            {
              paramInt3 = paramInt1;
              if (paramInt1 < 60.0F * paramFloat)
              {
                ac.d("MicroMsg.ImgInfoStorage", "pic to small height is %d ", new Object[] { Integer.valueOf(paramInt1) });
                paramInt3 = (int)(60.0F * paramFloat);
              }
              paramString = new FrameLayout.LayoutParams(paramInt2, paramInt3);
              if (paramInt4 == 0)
              {
                paramString.gravity = 5;
                if (paramView == null) {
                  break label1117;
                }
                paramView.setLayoutParams(paramString);
              }
              for (;;)
              {
                paramImageView1.setLayoutParams(paramString);
                if (i == 0) {
                  a(paramImageView1, paramImageView2, paramView, (String)localObject, paramFloat);
                }
                AppMethodBeat.o(150585);
                return false;
                f = 160.0F / paramInt1;
                break;
                paramInt1 = 120;
                break label724;
                paramInt1 = 75;
                break label742;
                if (paramInt1 > 0)
                {
                  paramInt3 = (int)(paramInt1 * paramFloat * 1.25F);
                  if (paramInt2 <= 0) {
                    break label983;
                  }
                }
                for (;;)
                {
                  paramInt1 = (int)(paramInt2 * paramFloat * 1.25F);
                  paramInt2 = paramInt3;
                  break;
                  paramInt1 = 120;
                  break label938;
                  paramInt2 = 75;
                }
                if (paramInt4 != 1) {
                  break label865;
                }
                paramString.gravity = 3;
                break label865;
                if ((this.hHG == null) || (this.hHG.get() == null)) {
                  this.hHG = new SoftReference(new ColorDrawable(-1118482));
                }
                paramImageView1.setImageDrawable((ColorDrawable)this.hHG.get());
                if (paramInt1 > 0)
                {
                  paramInt1 = (int)(paramInt1 * paramFloat * 1.25F);
                  if (paramInt2 <= 0) {
                    break label1110;
                  }
                }
                for (;;)
                {
                  paramString = new FrameLayout.LayoutParams(paramInt1, (int)(paramInt2 * paramFloat * 1.25F));
                  break;
                  paramInt1 = 120;
                  break label1061;
                  paramInt2 = 75;
                }
              }
            }
            continue;
            i = 0;
            paramString = null;
          }
        }
      }
    }
  }
  
  public final boolean a(bo parambo, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150631);
    String str = K(parambo);
    if (!bs.isNullOrNil(str))
    {
      boolean bool = a(str, parambo.field_imgPath, paramInt1, paramInt2, 0, 0);
      AppMethodBeat.o(150631);
      return bool;
    }
    AppMethodBeat.o(150631);
    return false;
  }
  
  /* Error */
  public final boolean a(String arg1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: ldc_w 1628
    //   3: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 217
    //   8: ldc_w 1630
    //   11: iconst_5
    //   12: anewarray 101	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_1
    //   18: aastore
    //   19: dup
    //   20: iconst_1
    //   21: aload_2
    //   22: aastore
    //   23: dup
    //   24: iconst_2
    //   25: iload_3
    //   26: invokestatic 419	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   29: aastore
    //   30: dup
    //   31: iconst_3
    //   32: iload 4
    //   34: invokestatic 419	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   37: aastore
    //   38: dup
    //   39: iconst_4
    //   40: invokestatic 449	com/tencent/mm/sdk/platformtools/bs:eWi	()Lcom/tencent/mm/sdk/platformtools/as;
    //   43: aastore
    //   44: invokestatic 320	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   47: invokestatic 186	java/lang/System:currentTimeMillis	()J
    //   50: lstore 10
    //   52: invokestatic 567	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
    //   55: invokestatic 1028	com/tencent/mm/cc/a:getDensity	(Landroid/content/Context;)F
    //   58: fstore 7
    //   60: aload_1
    //   61: invokestatic 470	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   64: ifne +10 -> 74
    //   67: aload_2
    //   68: invokestatic 470	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   71: ifeq +11 -> 82
    //   74: ldc_w 1628
    //   77: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: iconst_0
    //   81: ireturn
    //   82: aload_0
    //   83: aload_2
    //   84: iconst_0
    //   85: iconst_1
    //   86: invokevirtual 548	com/tencent/mm/av/g:b	(Ljava/lang/String;ZZ)Ljava/lang/String;
    //   89: astore 13
    //   91: aload 13
    //   93: invokestatic 470	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   96: ifeq +11 -> 107
    //   99: ldc_w 1628
    //   102: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: iconst_0
    //   106: ireturn
    //   107: aload 13
    //   109: ldc_w 472
    //   112: invokevirtual 475	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   115: ifne +98 -> 213
    //   118: new 193	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   125: aload 13
    //   127: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: ldc_w 472
    //   133: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: astore 15
    //   141: aload 13
    //   143: astore 14
    //   145: aload 15
    //   147: astore 13
    //   149: aload 14
    //   151: invokestatic 1279	com/tencent/mm/sdk/platformtools/f:aKw	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   154: astore 16
    //   156: aload 16
    //   158: ifnull +23 -> 181
    //   161: aload 16
    //   163: getfield 1284	android/graphics/BitmapFactory$Options:outWidth	I
    //   166: ifle +15 -> 181
    //   169: aload 16
    //   171: astore 15
    //   173: aload 16
    //   175: getfield 1287	android/graphics/BitmapFactory$Options:outHeight	I
    //   178: ifgt +118 -> 296
    //   181: getstatic 739	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   184: ldc2_w 1152
    //   187: ldc2_w 1631
    //   190: lconst_1
    //   191: iconst_0
    //   192: invokevirtual 1159	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   195: aload 14
    //   197: invokestatic 372	com/tencent/mm/vfs/i:aSp	(Ljava/lang/String;)J
    //   200: lconst_0
    //   201: lcmp
    //   202: ifle +29 -> 231
    //   205: ldc_w 1628
    //   208: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   211: iconst_0
    //   212: ireturn
    //   213: aload 13
    //   215: iconst_0
    //   216: aload 13
    //   218: invokevirtual 296	java/lang/String:length	()I
    //   221: iconst_2
    //   222: isub
    //   223: invokevirtual 505	java/lang/String:substring	(II)Ljava/lang/String;
    //   226: astore 14
    //   228: goto -79 -> 149
    //   231: new 1281	android/graphics/BitmapFactory$Options
    //   234: dup
    //   235: invokespecial 1460	android/graphics/BitmapFactory$Options:<init>	()V
    //   238: astore 15
    //   240: invokestatic 1635	com/tencent/mm/sdk/platformtools/f:eUu	()V
    //   243: ldc 217
    //   245: ldc_w 1637
    //   248: iconst_3
    //   249: anewarray 101	java/lang/Object
    //   252: dup
    //   253: iconst_0
    //   254: aload 15
    //   256: aastore
    //   257: dup
    //   258: iconst_1
    //   259: aload 15
    //   261: getfield 1284	android/graphics/BitmapFactory$Options:outWidth	I
    //   264: invokestatic 419	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   267: aastore
    //   268: dup
    //   269: iconst_2
    //   270: aload 15
    //   272: getfield 1287	android/graphics/BitmapFactory$Options:outHeight	I
    //   275: invokestatic 419	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   278: aastore
    //   279: invokestatic 230	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   282: getstatic 739	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   285: ldc2_w 1152
    //   288: ldc2_w 1638
    //   291: lconst_1
    //   292: iconst_0
    //   293: invokevirtual 1159	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   296: aload 15
    //   298: getfield 1284	android/graphics/BitmapFactory$Options:outWidth	I
    //   301: ifne +10 -> 311
    //   304: aload 15
    //   306: iload 5
    //   308: putfield 1284	android/graphics/BitmapFactory$Options:outWidth	I
    //   311: aload 15
    //   313: getfield 1287	android/graphics/BitmapFactory$Options:outHeight	I
    //   316: ifne +10 -> 326
    //   319: aload 15
    //   321: iload 6
    //   323: putfield 1287	android/graphics/BitmapFactory$Options:outHeight	I
    //   326: aload 15
    //   328: getfield 1284	android/graphics/BitmapFactory$Options:outWidth	I
    //   331: i2f
    //   332: fload 7
    //   334: fmul
    //   335: ldc_w 575
    //   338: fmul
    //   339: f2i
    //   340: istore 9
    //   342: aload 15
    //   344: getfield 1287	android/graphics/BitmapFactory$Options:outHeight	I
    //   347: i2f
    //   348: fload 7
    //   350: fmul
    //   351: ldc_w 575
    //   354: fmul
    //   355: f2i
    //   356: istore 8
    //   358: iload 9
    //   360: i2f
    //   361: ldc_w 576
    //   364: fload 7
    //   366: fmul
    //   367: fcmpl
    //   368: ifge +24 -> 392
    //   371: iload 8
    //   373: istore 6
    //   375: iload 9
    //   377: istore 5
    //   379: iload 8
    //   381: i2f
    //   382: ldc_w 576
    //   385: fload 7
    //   387: fmul
    //   388: fcmpl
    //   389: iflt +40 -> 429
    //   392: iload 8
    //   394: iload 9
    //   396: if_icmple +215 -> 611
    //   399: ldc_w 576
    //   402: fload 7
    //   404: fmul
    //   405: iload 8
    //   407: i2f
    //   408: fdiv
    //   409: fstore 7
    //   411: iload 9
    //   413: i2f
    //   414: fload 7
    //   416: fmul
    //   417: f2i
    //   418: istore 5
    //   420: fload 7
    //   422: iload 8
    //   424: i2f
    //   425: fmul
    //   426: f2i
    //   427: istore 6
    //   429: iload 4
    //   431: ifne +195 -> 626
    //   434: aload_1
    //   435: iload 6
    //   437: iload 5
    //   439: getstatic 530	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   442: aload 13
    //   444: new 377	com/tencent/mm/pointers/PInt
    //   447: dup
    //   448: invokespecial 378	com/tencent/mm/pointers/PInt:<init>	()V
    //   451: new 377	com/tencent/mm/pointers/PInt
    //   454: dup
    //   455: invokespecial 378	com/tencent/mm/pointers/PInt:<init>	()V
    //   458: invokestatic 1642	com/tencent/mm/sdk/platformtools/f:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   461: istore 12
    //   463: ldc 217
    //   465: ldc_w 1644
    //   468: iconst_4
    //   469: anewarray 101	java/lang/Object
    //   472: dup
    //   473: iconst_0
    //   474: new 193	java/lang/StringBuilder
    //   477: dup
    //   478: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   481: invokestatic 186	java/lang/System:currentTimeMillis	()J
    //   484: lload 10
    //   486: lsub
    //   487: invokevirtual 201	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   490: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: aastore
    //   494: dup
    //   495: iconst_1
    //   496: iload 6
    //   498: invokestatic 419	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   501: aastore
    //   502: dup
    //   503: iconst_2
    //   504: iload 5
    //   506: invokestatic 419	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   509: aastore
    //   510: dup
    //   511: iconst_3
    //   512: iload 12
    //   514: invokestatic 443	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   517: aastore
    //   518: invokestatic 320	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   521: aload_0
    //   522: aload 14
    //   524: iconst_1
    //   525: invokestatic 567	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
    //   528: invokestatic 1028	com/tencent/mm/cc/a:getDensity	(Landroid/content/Context;)F
    //   531: iconst_1
    //   532: iconst_0
    //   533: iconst_1
    //   534: iload_3
    //   535: iconst_0
    //   536: invokespecial 1174	com/tencent/mm/av/g:a	(Ljava/lang/String;ZFZZZIZ)Landroid/graphics/Bitmap;
    //   539: pop
    //   540: iload 12
    //   542: ifeq +169 -> 711
    //   545: aload_0
    //   546: getfield 150	com/tencent/mm/av/g:hHD	Ljava/util/Map;
    //   549: astore_1
    //   550: aload_1
    //   551: monitorenter
    //   552: aload_0
    //   553: getfield 150	com/tencent/mm/av/g:hHD	Ljava/util/Map;
    //   556: aload_2
    //   557: invokeinterface 1573 2 0
    //   562: ifeq +38 -> 600
    //   565: aload_0
    //   566: getfield 150	com/tencent/mm/av/g:hHD	Ljava/util/Map;
    //   569: aload_2
    //   570: invokeinterface 820 2 0
    //   575: checkcast 56	java/lang/String
    //   578: ldc_w 472
    //   581: invokevirtual 475	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   584: ifne +16 -> 600
    //   587: aload_0
    //   588: getfield 150	com/tencent/mm/av/g:hHD	Ljava/util/Map;
    //   591: aload_2
    //   592: aload 13
    //   594: invokeinterface 803 3 0
    //   599: pop
    //   600: aload_1
    //   601: monitorexit
    //   602: ldc_w 1628
    //   605: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   608: iload 12
    //   610: ireturn
    //   611: ldc_w 576
    //   614: fload 7
    //   616: fmul
    //   617: iload 9
    //   619: i2f
    //   620: fdiv
    //   621: fstore 7
    //   623: goto -212 -> 411
    //   626: aload_1
    //   627: iload 6
    //   629: iload 5
    //   631: getstatic 530	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   634: aload 13
    //   636: new 377	com/tencent/mm/pointers/PInt
    //   639: dup
    //   640: invokespecial 378	com/tencent/mm/pointers/PInt:<init>	()V
    //   643: new 377	com/tencent/mm/pointers/PInt
    //   646: dup
    //   647: invokespecial 378	com/tencent/mm/pointers/PInt:<init>	()V
    //   650: invokestatic 1646	com/tencent/mm/sdk/platformtools/f:b	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   653: istore 12
    //   655: goto -192 -> 463
    //   658: astore_1
    //   659: getstatic 739	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   662: ldc2_w 1152
    //   665: ldc2_w 1647
    //   668: lconst_1
    //   669: iconst_0
    //   670: invokevirtual 1159	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   673: ldc 217
    //   675: ldc_w 1650
    //   678: iconst_1
    //   679: anewarray 101	java/lang/Object
    //   682: dup
    //   683: iconst_0
    //   684: aload_1
    //   685: invokevirtual 1651	java/lang/Exception:toString	()Ljava/lang/String;
    //   688: aastore
    //   689: invokestatic 612	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   692: ldc_w 1628
    //   695: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   698: iconst_0
    //   699: ireturn
    //   700: astore_2
    //   701: aload_1
    //   702: monitorexit
    //   703: ldc_w 1628
    //   706: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   709: aload_2
    //   710: athrow
    //   711: getstatic 739	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   714: ldc2_w 1152
    //   717: ldc2_w 1647
    //   720: lconst_1
    //   721: iconst_0
    //   722: invokevirtual 1159	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   725: goto -123 -> 602
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	728	0	this	g
    //   0	728	2	paramString2	String
    //   0	728	3	paramInt1	int
    //   0	728	4	paramInt2	int
    //   0	728	5	paramInt3	int
    //   0	728	6	paramInt4	int
    //   58	564	7	f	float
    //   356	67	8	i	int
    //   340	278	9	j	int
    //   50	435	10	l	long
    //   461	193	12	bool	boolean
    //   89	546	13	localObject1	Object
    //   143	380	14	localObject2	Object
    //   139	204	15	localObject3	Object
    //   154	20	16	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   434	463	658	java/lang/Exception
    //   626	655	658	java/lang/Exception
    //   552	600	700	finally
    //   600	602	700	finally
    //   701	703	700	finally
  }
  
  public final void aFd()
  {
    AppMethodBeat.i(150567);
    Cursor localCursor = this.hpA.a("SELECT max(id) FROM ImgInfo2", null, 2);
    long l;
    if (localCursor.moveToFirst()) {
      l = localCursor.getLong(0) + 1L;
    }
    synchronized (this.hHE)
    {
      if (l > this.hHE.get()) {
        this.hHE.set(l);
      }
      localCursor.close();
      ac.i("MicroMsg.ImgInfoStorage", "loading new img id: " + this.hHE.get());
      AppMethodBeat.o(150567);
      return;
    }
  }
  
  public final long aFe()
  {
    AppMethodBeat.i(150568);
    synchronized (this.hHE)
    {
      long l = this.hHE.getAndIncrement();
      AppMethodBeat.o(150568);
      return l;
    }
  }
  
  public final List<e> aFf()
  {
    AppMethodBeat.i(150598);
    Object localObject = "select * " + " FROM ImgInfo2";
    localObject = (String)localObject + " WHERE iscomplete= 0 AND totalLen != 0 ";
    localObject = this.hpA.a((String)localObject, null, 0);
    if (!((Cursor)localObject).moveToFirst())
    {
      ((Cursor)localObject).close();
      AppMethodBeat.o(150598);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      e locale1 = new e();
      locale1.convertFrom((Cursor)localObject);
      e locale2 = oS((int)locale1.dcd);
      if (locale2 != null) {
        if ((locale2.dpl != 0L) || (locale2.hGV != 0L)) {
          localArrayList.add(locale1);
        }
      }
      while (!((Cursor)localObject).moveToNext())
      {
        ((Cursor)localObject).close();
        AppMethodBeat.o(150598);
        return localArrayList;
        if ((locale1.dpl != 0L) || (locale1.hGV != 0L)) {
          localArrayList.add(locale1);
        }
      }
    }
  }
  
  public final String aa(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150580);
    if (bs.cv(paramArrayOfByte))
    {
      ac.e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
      AppMethodBeat.o(150580);
      return null;
    }
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    MMBitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, (BitmapFactory.Options)localObject);
    if ((((BitmapFactory.Options)localObject).outWidth < 0) || (((BitmapFactory.Options)localObject).outHeight < 0))
    {
      ac.e("MicroMsg.ImgInfoStorage", "Bad thumbBuf, perhaps it's not complete or damaged ??");
      AppMethodBeat.o(150580);
      return null;
    }
    localObject = aFg();
    String str = p((String)localObject, "th_", "");
    ac.d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = ".concat(String.valueOf(str)));
    i.deleteFile(str);
    i.f(str, paramArrayOfByte, paramArrayOfByte.length);
    paramArrayOfByte = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(localObject));
    AppMethodBeat.o(150580);
    return paramArrayOfByte;
  }
  
  public final Bitmap b(String paramString, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(150588);
    paramString = a(paramString, true, paramFloat, paramBoolean, true, false, 0);
    AppMethodBeat.o(150588);
    return paramString;
  }
  
  public final String b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(150633);
    Object localObject;
    if ((paramString != null) && (this.hHD.containsKey(paramString)))
    {
      localObject = (String)this.hHD.get(paramString);
      AppMethodBeat.o(150633);
      return localObject;
    }
    if (paramBoolean1) {}
    for (String str = paramString;; str = R(paramString, paramBoolean2))
    {
      localObject = str;
      if (bs.isNullOrNil(str)) {
        break;
      }
      this.hHD.put(paramString, str);
      localObject = str;
      break;
    }
  }
  
  public final HashMap<Long, e> b(Long... paramVarArgs)
  {
    AppMethodBeat.i(150602);
    Object localObject1 = "(";
    int k = paramVarArgs.length;
    int i = 0;
    int j = 1;
    Object localObject2;
    if (i < k)
    {
      long l = paramVarArgs[i].longValue();
      localObject2 = new StringBuilder().append((String)localObject1);
      if (j != 0) {}
      for (localObject1 = Long.valueOf(l);; localObject1 = ",".concat(String.valueOf(l)))
      {
        localObject1 = localObject1;
        i += 1;
        j = 0;
        break;
      }
    }
    paramVarArgs = b("ImgInfo2", null, "msglocalid in ".concat(String.valueOf((String)localObject1 + ")")), null);
    localObject1 = new HashMap();
    while (paramVarArgs.moveToNext())
    {
      localObject2 = new e();
      ((e)localObject2).convertFrom(paramVarArgs);
      ((HashMap)localObject1).put(Long.valueOf(((e)localObject2).dpl), localObject2);
    }
    paramVarArgs.close();
    AppMethodBeat.o(150602);
    return localObject1;
  }
  
  public final e c(Long paramLong)
  {
    AppMethodBeat.i(150596);
    e locale = new e();
    paramLong = a("ImgInfo2", null, "id=?", new String[] { String.valueOf(paramLong) });
    if ((paramLong != null) && (paramLong.moveToFirst())) {
      locale.convertFrom(paramLong);
    }
    paramLong.close();
    AppMethodBeat.o(150596);
    return locale;
  }
  
  public final String d(e parame)
  {
    Object localObject = null;
    AppMethodBeat.i(150600);
    if (parame == null)
    {
      AppMethodBeat.o(150600);
      return null;
    }
    if (parame.aFa())
    {
      parame = parame.hGX;
      Cursor localCursor = b("ImgInfo2", new String[] { "bigImgPath" }, "id=? and totalLen = offset", new String[] { parame });
      parame = localObject;
      if (localCursor.moveToFirst()) {
        parame = localCursor.getString(0);
      }
      localCursor.close();
      AppMethodBeat.o(150600);
      return parame;
    }
    AppMethodBeat.o(150600);
    return null;
  }
  
  public final long e(e parame)
  {
    AppMethodBeat.i(150613);
    long l = this.hpA.a("ImgInfo2", "id", parame.convertTo());
    if (l != -1L) {
      parame.aFc();
    }
    ac.i("MicroMsg.ImgInfoStorage", "insert img, result:%d, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d", new Object[] { Long.valueOf(l), Long.valueOf(parame.dcd), Long.valueOf(parame.hGV), Long.valueOf(parame.dpl), Integer.valueOf(parame.hGX) });
    AppMethodBeat.o(150613);
    return l;
  }
  
  public final Bitmap e(String paramString, float paramFloat)
  {
    AppMethodBeat.i(150582);
    paramString = a(paramString, paramFloat, false);
    AppMethodBeat.o(150582);
    return paramString;
  }
  
  public final String getFullPath(String paramString)
  {
    AppMethodBeat.i(150572);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150572);
      return null;
    }
    String str1 = "";
    if (paramString.startsWith("SERVERID://")) {
      str1 = paramString.substring(11);
    }
    for (;;)
    {
      try
      {
        str1 = qf(Long.valueOf(str1).longValue()).hGM;
        String str2 = com.tencent.mm.plugin.image.d.awL();
        String str3 = com.tencent.mm.plugin.image.d.awM();
        if (bs.isNullOrNil(str1))
        {
          paramString = l.j(str2, str3, "th_", paramString, "");
          AppMethodBeat.o(150572);
          return paramString;
        }
      }
      catch (NumberFormatException paramString)
      {
        ac.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + paramString.getMessage());
        AppMethodBeat.o(150572);
        return null;
      }
      paramString = str1;
    }
  }
  
  public final Bitmap l(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(150629);
    if (paramBoolean) {}
    for (String str = "location_backgroup_key_from";; str = "location_backgroup_key_tor")
    {
      Bitmap localBitmap2 = (Bitmap)this.hHw.aJ(str);
      Bitmap localBitmap1;
      if (localBitmap2 != null)
      {
        localBitmap1 = localBitmap2;
        if (!localBitmap2.isRecycled()) {}
      }
      else
      {
        localBitmap1 = com.tencent.mm.sdk.platformtools.f.ji(paramInt1, paramInt2);
        this.hHw.o(str, localBitmap1);
      }
      AppMethodBeat.o(150629);
      return localBitmap1;
    }
  }
  
  public final e oR(int paramInt)
  {
    AppMethodBeat.i(150603);
    e locale = c(Long.valueOf(paramInt));
    AppMethodBeat.o(150603);
    return locale;
  }
  
  /* Error */
  public final e oS(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 1726
    //   3: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc_w 897
    //   10: aconst_null
    //   11: ldc_w 1728
    //   14: iconst_1
    //   15: anewarray 56	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: iload_1
    //   21: invokestatic 927	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   24: aastore
    //   25: invokespecial 1559	com/tencent/mm/av/g:b	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull +147 -> 177
    //   33: aload_3
    //   34: astore 4
    //   36: aload_3
    //   37: invokeinterface 933 1 0
    //   42: ifeq +135 -> 177
    //   45: aload_3
    //   46: astore 4
    //   48: new 259	com/tencent/mm/av/e
    //   51: dup
    //   52: invokespecial 646	com/tencent/mm/av/e:<init>	()V
    //   55: astore_2
    //   56: aload_3
    //   57: astore 4
    //   59: aload_2
    //   60: aload_3
    //   61: invokevirtual 937	com/tencent/mm/av/e:convertFrom	(Landroid/database/Cursor;)V
    //   64: aload_2
    //   65: astore 4
    //   67: aload_3
    //   68: ifnull +12 -> 80
    //   71: aload_3
    //   72: invokeinterface 895 1 0
    //   77: aload_2
    //   78: astore 4
    //   80: ldc_w 1726
    //   83: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: aload 4
    //   88: areturn
    //   89: astore 5
    //   91: aconst_null
    //   92: astore_2
    //   93: aconst_null
    //   94: astore_3
    //   95: aload_3
    //   96: astore 4
    //   98: ldc 217
    //   100: ldc_w 1730
    //   103: iconst_1
    //   104: anewarray 101	java/lang/Object
    //   107: dup
    //   108: iconst_0
    //   109: aload 5
    //   111: invokevirtual 1651	java/lang/Exception:toString	()Ljava/lang/String;
    //   114: aastore
    //   115: invokestatic 1195	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   118: aload_2
    //   119: astore 4
    //   121: aload_3
    //   122: ifnull -42 -> 80
    //   125: aload_3
    //   126: invokeinterface 895 1 0
    //   131: aload_2
    //   132: astore 4
    //   134: goto -54 -> 80
    //   137: astore_2
    //   138: aconst_null
    //   139: astore 4
    //   141: aload 4
    //   143: ifnull +10 -> 153
    //   146: aload 4
    //   148: invokeinterface 895 1 0
    //   153: ldc_w 1726
    //   156: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: aload_2
    //   160: athrow
    //   161: astore_2
    //   162: goto -21 -> 141
    //   165: astore 5
    //   167: aconst_null
    //   168: astore_2
    //   169: goto -74 -> 95
    //   172: astore 5
    //   174: goto -79 -> 95
    //   177: aconst_null
    //   178: astore_2
    //   179: goto -115 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	g
    //   0	182	1	paramInt	int
    //   55	77	2	locale	e
    //   137	23	2	localObject1	Object
    //   161	1	2	localObject2	Object
    //   168	11	2	localObject3	Object
    //   28	98	3	localCursor	Cursor
    //   34	113	4	localObject4	Object
    //   89	21	5	localException1	Exception
    //   165	1	5	localException2	Exception
    //   172	1	5	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   6	29	89	java/lang/Exception
    //   6	29	137	finally
    //   36	45	161	finally
    //   48	56	161	finally
    //   59	64	161	finally
    //   98	118	161	finally
    //   36	45	165	java/lang/Exception
    //   48	56	165	java/lang/Exception
    //   59	64	172	java/lang/Exception
  }
  
  public final String p(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(150571);
    paramString1 = a(paramString1, paramString2, paramString3, true);
    AppMethodBeat.o(150571);
    return paramString1;
  }
  
  public final e qf(long paramLong)
  {
    AppMethodBeat.i(150604);
    e locale = new e();
    Cursor localCursor = b("ImgInfo2", null, "msgSvrId=?", new String[] { String.valueOf(paramLong) });
    if (localCursor.moveToFirst()) {
      locale.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(150604);
    return locale;
  }
  
  public final e qg(long paramLong)
  {
    AppMethodBeat.i(150605);
    e locale = new e();
    Cursor localCursor = b("ImgInfo2", null, "msglocalid=?", new String[] { String.valueOf(paramLong) });
    if (localCursor.moveToLast()) {
      locale.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(150605);
    return locale;
  }
  
  static final class b
  {
    int hHO;
    int hHP;
    int hHQ;
    String url;
    
    b(int paramInt1, String paramString, int paramInt2, int paramInt3)
    {
      this.hHO = paramInt1;
      this.url = paramString;
      this.hHP = paramInt2;
      this.hHQ = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.av.g
 * JD-Core Version:    0.7.0.1
 */