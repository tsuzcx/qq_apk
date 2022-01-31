package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.widget.ImageView;
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.protocal.c.xt;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.xw;
import com.tencent.mm.protocal.c.yi;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.ys;
import com.tencent.mm.protocal.c.yy;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class l
{
  private static Map<String, g.a> kdN = new HashMap();
  private static com.tencent.mm.a.f<String, Bitmap> kdO = new com.tencent.mm.a.f(10);
  private static ab<String, Bitmap> kdP = new ab(20);
  public Context context;
  public e kdK;
  public HashMap<String, String[]> kdL = new HashMap();
  private HashMap<String, String[]> kdM = new HashMap();
  
  public l(Context paramContext, int paramInt)
  {
    this.context = paramContext;
    int i = paramInt;
    if (paramInt <= 0) {
      i = 24;
    }
    this.kdK = new e(i);
  }
  
  public static Bitmap a(xv paramxv, com.tencent.mm.plugin.fav.a.g paramg)
  {
    if (!com.tencent.mm.compatible.util.f.zF()) {
      localObject = BitmapFactory.decodeResource(ae.getContext().getResources(), n.d.nosdcard_chatting_bg);
    }
    Bitmap localBitmap;
    do
    {
      return localObject;
      if (b.Cw(paramxv.kgC) == null) {
        return null;
      }
      localBitmap = a(paramxv, true, false);
      localObject = localBitmap;
    } while (localBitmap != null);
    Object localObject = b.c(paramxv);
    com.tencent.mm.kernel.g.DS().O(new l.5((String)localObject, paramg, paramxv));
    return localBitmap;
  }
  
  public static Bitmap a(xv paramxv, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean)
  {
    if (!com.tencent.mm.compatible.util.f.zF()) {
      localObject = BitmapFactory.decodeResource(ae.getContext().getResources(), n.d.nosdcard_chatting_bg);
    }
    Bitmap localBitmap;
    do
    {
      return localObject;
      if (paramxv.kgC == null) {
        return null;
      }
      localBitmap = a(paramxv, false, false);
      localObject = localBitmap;
    } while (localBitmap != null);
    Object localObject = b.b(paramxv);
    com.tencent.mm.kernel.g.DS().O(new l.4(paramBoolean, (String)localObject, paramg, paramxv));
    return localBitmap;
  }
  
  private static Bitmap a(xv paramxv, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {}
    for (paramxv = b.c(paramxv); !com.tencent.mm.vfs.e.bK(paramxv); paramxv = b.b(paramxv))
    {
      y.w("MicroMsg.FavoriteImageLogic", "getBitmap file not exist");
      return null;
    }
    return c.aB(paramxv, paramBoolean2);
  }
  
  public static void a(ImageView paramImageView, int paramInt1, xv paramxv, com.tencent.mm.plugin.fav.a.g paramg, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    if (!com.tencent.mm.compatible.util.f.zF()) {
      paramImageView.setImageBitmap(BitmapFactory.decodeResource(ae.getContext().getResources(), n.d.nosdcard_chatting_bg));
    }
    if (paramxv.kgC == null) {
      paramImageView.setImageResource(paramInt1);
    }
    Bitmap localBitmap = a(paramxv, paramg);
    String str = b.b(paramxv);
    if (com.tencent.mm.vfs.e.bK(str)) {
      localBitmap = c(str, paramInt2, paramInt3, true);
    }
    if (localBitmap == null)
    {
      paramImageView.setImageResource(paramInt1);
      paramImageView.setTag(str);
      com.tencent.mm.kernel.g.DS().O(new l.6(str, paramInt2, paramInt3, paramg, paramxv, paramBoolean, paramImageView));
      return;
    }
    paramImageView.setImageBitmap(localBitmap);
  }
  
  public static Bitmap b(xv paramxv, com.tencent.mm.plugin.fav.a.g paramg, int paramInt)
  {
    if (!com.tencent.mm.compatible.util.f.zF())
    {
      localObject2 = BitmapFactory.decodeResource(ae.getContext().getResources(), n.d.nosdcard_chatting_bg);
      return localObject2;
    }
    if (paramxv.kgC == null) {
      return null;
    }
    Object localObject2 = b.b(paramxv);
    if (!com.tencent.mm.vfs.e.bK((String)localObject2))
    {
      y.w("MicroMsg.FavoriteImageLogic", "getBitmap file not exist");
      localObject1 = null;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 != null) {
        break;
      }
      localObject2 = b.b(paramxv);
      com.tencent.mm.kernel.g.DS().O(new l.3((String)localObject2, paramg, paramxv));
      return localObject1;
      localObject1 = (Bitmap)kdO.get(localObject2);
      if (localObject1 == null) {
        break label129;
      }
      y.d("MicroMsg.FavoriteImageLogic", "get bm from cache %s", new Object[] { localObject2 });
    }
    label129:
    y.d("MicroMsg.FavoriteImageLogic", "get from cache fail, try to decode from file");
    Object localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
    Bitmap localBitmap = BitmapFactory.decodeFile((String)localObject2, (BitmapFactory.Options)localObject1);
    if (localBitmap != null)
    {
      y.i("MicroMsg.FavoriteImageLogic", "bitmap recycle %s", new Object[] { localBitmap });
      localBitmap.recycle();
    }
    int j = ((BitmapFactory.Options)localObject1).outWidth;
    int i = ((BitmapFactory.Options)localObject1).outHeight;
    y.d("MicroMsg.FavoriteImageLogic", "width: %s, height: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
    if (j > paramInt) {
      i = ((BitmapFactory.Options)localObject1).outHeight * paramInt / ((BitmapFactory.Options)localObject1).outWidth;
    }
    for (;;)
    {
      paramInt = Math.max(1, paramInt);
      i = Math.max(1, i);
      y.w("MicroMsg.FavoriteImageLogic", "fit long picture, beg %d*%d, after %d*%d", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject1).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject1).outHeight), Integer.valueOf(paramInt), Integer.valueOf(i) });
      int k = BackwardSupportUtil.ExifHelper.YS((String)localObject2);
      if ((k == 90) || (k == 270)) {}
      for (;;)
      {
        localObject1 = com.tencent.mm.sdk.platformtools.c.e((String)localObject2, paramInt, i, false);
        if (localObject1 == null)
        {
          y.e("MicroMsg.FavoriteImageLogic", "getSuitableBmp fail, temBmp is null, filePath = " + (String)localObject2);
          localObject1 = null;
          break;
        }
        localObject1 = com.tencent.mm.sdk.platformtools.c.b((Bitmap)localObject1, k);
        kdO.put(localObject2, localObject1);
        break;
        j = paramInt;
        paramInt = i;
        i = j;
      }
      paramInt = j;
    }
  }
  
  public static void b(com.tencent.mm.plugin.fav.a.g paramg, xv paramxv)
  {
    b(paramg, paramxv, true);
  }
  
  private static void b(com.tencent.mm.plugin.fav.a.g paramg, xv paramxv, boolean paramBoolean)
  {
    String str = b.b(paramxv);
    com.tencent.mm.kernel.g.DS().O(new l.7(paramBoolean, str, paramg, paramxv));
  }
  
  public static Bitmap c(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (!com.tencent.mm.vfs.e.bK(paramString))
    {
      y.w("MicroMsg.FavoriteImageLogic", "file not exist");
      return null;
    }
    Bitmap localBitmap = (Bitmap)kdP.get(paramString);
    if ((localBitmap != null) || (paramBoolean))
    {
      paramBoolean = bool1;
      if (localBitmap != null) {
        paramBoolean = true;
      }
      y.d("MicroMsg.FavoriteImageLogic", "return bm path %s, bm %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
      return localBitmap;
    }
    Object localObject1 = localBitmap;
    for (;;)
    {
      Object localObject2;
      int m;
      try
      {
        localObject2 = new BitmapFactory.Options();
        localObject1 = localBitmap;
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
        localObject1 = localBitmap;
        com.tencent.mm.sdk.platformtools.c.decodeFile(paramString, (BitmapFactory.Options)localObject2);
        localObject1 = localBitmap;
        i = ((BitmapFactory.Options)localObject2).outWidth;
        localObject1 = localBitmap;
        j = ((BitmapFactory.Options)localObject2).outHeight;
        localObject1 = localBitmap;
        m = BackwardSupportUtil.ExifHelper.YS(paramString);
        if (m == 90) {
          break label592;
        }
        if (m != 270) {
          break label574;
        }
      }
      catch (IOException paramString)
      {
        y.e("MicroMsg.FavoriteImageLogic", paramString.getMessage());
        return localObject1;
      }
      localObject1 = localBitmap;
      ((BitmapFactory.Options)localObject2).inSampleSize = 1;
      localObject1 = localBitmap;
      if (i / ((BitmapFactory.Options)localObject2).inSampleSize > paramInt2)
      {
        localObject1 = localBitmap;
        if (j / ((BitmapFactory.Options)localObject2).inSampleSize > paramInt1)
        {
          localObject1 = localBitmap;
          ((BitmapFactory.Options)localObject2).inSampleSize += 1;
          continue;
        }
      }
      localObject1 = localBitmap;
      int k = j * paramInt2 / paramInt1;
      localObject1 = localBitmap;
      y.d("MicroMsg.FavoriteImageLogic", "decode top region width: %d, height: %d, scaleheight: %d, rotate: %b", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k), Boolean.valueOf(paramBoolean) });
      Rect localRect;
      BitmapRegionDecoder localBitmapRegionDecoder;
      if ((k > 0) && (i > k))
      {
        localObject1 = localBitmap;
        localRect = new Rect();
        localObject1 = localBitmap;
        localRect.top = 0;
        localObject1 = localBitmap;
        localRect.left = 0;
        if (paramBoolean)
        {
          localObject1 = localBitmap;
          localRect.right = k;
          localObject1 = localBitmap;
          localRect.bottom = j;
          localObject1 = localBitmap;
          localBitmapRegionDecoder = BitmapRegionDecoder.newInstance(paramString, true);
          localObject1 = localBitmap;
          ((BitmapFactory.Options)localObject2).inJustDecodeBounds = false;
          localObject1 = localBitmap;
        }
      }
      for (localBitmap = localBitmapRegionDecoder.decodeRegion(localRect, (BitmapFactory.Options)localObject2);; localBitmap = com.tencent.mm.sdk.platformtools.c.decodeFile(paramString, (BitmapFactory.Options)localObject2))
      {
        localObject2 = localBitmap;
        if (localBitmap != null)
        {
          localObject2 = localBitmap;
          if (paramBoolean)
          {
            localObject1 = localBitmap;
            localObject2 = com.tencent.mm.sdk.platformtools.c.b(localBitmap, m);
          }
        }
        if (localObject2 == null) {
          break label559;
        }
        localObject1 = localObject2;
        y.d("MicroMsg.FavoriteImageLogic", "width %d, height %d, tw %d, th %d", new Object[] { Integer.valueOf(((Bitmap)localObject2).getWidth()), Integer.valueOf(((Bitmap)localObject2).getHeight()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        localObject1 = localObject2;
        kdP.put(paramString, localObject2);
        return localObject2;
        localObject1 = localBitmap;
        localRect.right = j;
        localObject1 = localBitmap;
        localRect.bottom = k;
        break;
        localObject1 = localBitmap;
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = false;
        localObject1 = localBitmap;
      }
      label559:
      localObject1 = localObject2;
      y.w("MicroMsg.FavoriteImageLogic", "decode bm fail!");
      return localObject2;
      label574:
      k = i;
      paramBoolean = bool2;
      int i = j;
      int j = k;
      continue;
      label592:
      paramBoolean = true;
    }
  }
  
  public static Bitmap j(xv paramxv)
  {
    if (!com.tencent.mm.compatible.util.f.zF()) {
      return BitmapFactory.decodeResource(ae.getContext().getResources(), n.d.nosdcard_chatting_bg);
    }
    if (paramxv.kgC == null) {
      return null;
    }
    return a(paramxv, false, true);
  }
  
  public final void a(ImageView paramImageView, xv paramxv, com.tencent.mm.plugin.fav.a.g paramg, int paramInt1, int paramInt2, int paramInt3)
  {
    String str = null;
    if (paramImageView == null) {}
    yy localyy;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!com.tencent.mm.compatible.util.f.zF())
            {
              paramImageView.setImageResource(n.d.nosdcard_chatting_bg);
              return;
            }
          } while (paramg == null);
          switch (paramg.field_type)
          {
          case 6: 
          case 8: 
          case 9: 
          case 12: 
          case 13: 
          case 14: 
          default: 
            y.w("MicroMsg.FavoriteImageLogic", "attach thumb, pass type is %d", new Object[] { Integer.valueOf(paramg.field_type) });
            return;
          }
        } while (paramxv == null);
        a(paramImageView, paramxv, paramg, paramxv.bIm, paramInt1, paramInt2, paramInt3);
        return;
      } while (paramxv == null);
      a(paramImageView, paramxv, paramg, paramxv.bIm, paramInt1, paramInt2, paramInt3);
      return;
      localyy = paramg.field_favProto.sWh;
      if (paramxv != null) {
        break;
      }
    } while (localyy == null);
    this.kdK.a(paramImageView, null, localyy.thumbUrl, paramInt1, paramInt2, paramInt3);
    return;
    if (localyy == null)
    {
      label207:
      if (!bk.bl(str)) {
        break label343;
      }
      str = paramxv.bIm;
    }
    label343:
    for (;;)
    {
      a(paramImageView, paramxv, paramg, str, paramInt1, paramInt2, paramInt3);
      return;
      str = localyy.thumbUrl;
      break label207;
      paramxv = paramg.field_favProto.sWj;
      if (paramxv == null) {
        break;
      }
      this.kdK.a(paramImageView, null, paramxv.thumbUrl, paramInt1, paramInt2, paramInt3);
      return;
      paramxv = paramg.field_favProto.sWl;
      if (paramxv == null) {
        break;
      }
      this.kdK.a(paramImageView, null, paramxv.thumbUrl, paramInt1, paramInt2, paramInt3);
      return;
      paramxv = paramg.field_favProto.sWj;
      if (paramxv == null) {
        break;
      }
      this.kdK.a(paramImageView, null, paramxv.thumbUrl, paramInt1, paramInt2, paramInt3);
      return;
    }
  }
  
  public final void a(ImageView paramImageView, xv paramxv, com.tencent.mm.plugin.fav.a.g paramg, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    String str = b.Cw(paramxv.kgC);
    String[] arrayOfString = null;
    if (paramxv.kgC != null)
    {
      arrayOfString = (String[])this.kdM.get(str);
      if (arrayOfString != null) {
        break label118;
      }
      arrayOfString = new String[1];
      arrayOfString[0] = b.c(paramxv);
      this.kdM.put(str, arrayOfString);
    }
    label118:
    for (;;)
    {
      this.kdK.a(paramImageView, arrayOfString, paramString, paramInt1, paramInt2, paramInt3);
      if ((arrayOfString == null) || (arrayOfString.length <= 0)) {
        return;
      }
      paramImageView = arrayOfString[0];
      com.tencent.mm.kernel.g.DS().O(new l.1(this, paramImageView, paramg, paramxv));
      return;
    }
  }
  
  public final void b(ImageView paramImageView, xv paramxv, com.tencent.mm.plugin.fav.a.g paramg, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject2 = null;
    if (paramImageView == null) {
      return;
    }
    if (!com.tencent.mm.compatible.util.f.zF())
    {
      paramImageView.setImageResource(n.d.nosdcard_chatting_bg);
      return;
    }
    if ((paramg == null) || (paramxv == null))
    {
      paramImageView.setImageDrawable(a.g(this.context, paramInt1));
      return;
    }
    Object localObject1;
    switch (paramxv.aYU)
    {
    case 6: 
    case 8: 
    case 9: 
    case 12: 
    case 13: 
    case 16: 
    case 17: 
    case 18: 
    default: 
      y.w("MicroMsg.FavoriteImageLogic", "attach thumb, pass type is %d", new Object[] { Integer.valueOf(paramg.field_type) });
      return;
    case 7: 
      a(paramImageView, paramxv, paramg, paramxv.bIm, paramInt1, paramInt2, paramInt3);
      return;
    case 4: 
    case 15: 
      a(paramImageView, paramxv, paramg, paramxv.bIm, paramInt1, paramInt2, paramInt3);
      return;
    case 5: 
      if (paramxv.sVA != null)
      {
        localObject1 = paramxv.sVA.sWh;
        label203:
        if (localObject1 != null) {
          break label287;
        }
        localObject1 = localObject2;
        label212:
        if (!bk.bl((String)localObject1)) {
          break label613;
        }
        localObject1 = paramxv.bIm;
      }
      break;
    }
    label287:
    label613:
    for (;;)
    {
      a(paramImageView, paramxv, paramg, (String)localObject1, paramInt1, paramInt2, paramInt3);
      return;
      y.w("MicroMsg.FavoriteImageLogic", "webpage: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramxv.kgC, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
      localObject1 = null;
      break label203;
      localObject1 = ((yy)localObject1).thumbUrl;
      break label212;
      if (paramxv.sVA == null)
      {
        y.w("MicroMsg.FavoriteImageLogic", "good: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramxv.kgC, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
        return;
      }
      paramxv = paramxv.sVA.sWj;
      if (paramxv == null) {
        break;
      }
      this.kdK.a(paramImageView, null, paramxv.thumbUrl, paramInt1, paramInt2, paramInt3);
      return;
      if (paramxv.sVA == null)
      {
        y.w("MicroMsg.FavoriteImageLogic", "tv: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramxv.kgC, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
        return;
      }
      paramxv = paramxv.sVA.sWl;
      if (paramxv == null) {
        break;
      }
      this.kdK.a(paramImageView, null, paramxv.thumbUrl, paramInt1, paramInt2, paramInt3);
      return;
      if (paramxv.sVA == null)
      {
        y.w("MicroMsg.FavoriteImageLogic", "product: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramxv.kgC, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
        return;
      }
      paramxv = paramxv.sVA.sWj;
      if (paramxv == null) {
        break;
      }
      this.kdK.a(paramImageView, null, paramxv.thumbUrl, paramInt1, paramInt2, paramInt3);
      return;
      if (paramxv.sVA == null)
      {
        y.w("MicroMsg.FavoriteImageLogic", "app brand: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[] { paramxv.kgC, Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_id) });
        return;
      }
      paramxv = paramxv.sVA.sWu;
      if (paramxv == null) {
        break;
      }
      this.kdK.a(paramImageView, null, paramxv.iconUrl, paramInt1, paramInt2, paramInt3);
      return;
    }
  }
  
  public final void destory()
  {
    e locale = this.kdK;
    synchronized (locale.dMQ)
    {
      y.d("MicroMsg.ImageEngine", "do clear mark");
      locale.smf.clear();
      locale.smg.clear();
      locale.smf = new HashMap();
      locale.smg = new HashMap();
      this.kdL.clear();
      this.kdM.clear();
      this.kdK.destroy();
      this.context = null;
      this.kdL = null;
      this.kdM = null;
      this.kdK = null;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.l
 * JD-Core Version:    0.7.0.1
 */