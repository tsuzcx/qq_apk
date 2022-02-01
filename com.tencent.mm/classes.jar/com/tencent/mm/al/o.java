package com.tencent.mm.al;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.c;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.e;
import com.tencent.mm.network.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bf.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class o
{
  public static Bitmap EI(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(124113);
    if ((bu.isNullOrNil(paramString)) || (!com.tencent.mm.kernel.g.ajR().isSDCardAvailable()) || (!com.tencent.mm.kernel.g.ajP().aiZ()))
    {
      AppMethodBeat.o(124113);
      return null;
    }
    Bitmap localBitmap = ag.aGz().EJ(paramString);
    if (localBitmap == null) {
      bool = true;
    }
    ae.i("MicroMsg.BrandLogic", "get verify user icon = %s, is null ? %s", new Object[] { paramString, String.valueOf(bool) });
    AppMethodBeat.o(124113);
    return localBitmap;
  }
  
  private static Bitmap aGe()
  {
    localObject1 = null;
    AppMethodBeat.i(124115);
    Object localObject4 = new BitmapFactory.Options();
    h.fnS();
    try
    {
      Object localObject2 = ak.getContext().getResources().openRawResource(2131233478);
      localObject1 = localObject2;
      localObject4 = BitmapFactory.decodeStream((InputStream)localObject2, null, (BitmapFactory.Options)localObject4);
      localObject1 = localObject4;
      if (localObject2 != null) {}
      try
      {
        ((InputStream)localObject2).close();
        localObject2 = localObject1;
        if (localObject1 != null) {
          localObject2 = h.a(localObject1, false, localObject1.getWidth() >> 1);
        }
        AppMethodBeat.o(124115);
        return localObject2;
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.BrandLogic", localIOException2, "", new Object[0]);
        }
      }
      try
      {
        localObject1.close();
        AppMethodBeat.o(124115);
        throw localObject3;
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.BrandLogic", localIOException1, "", new Object[0]);
        }
      }
    }
    finally
    {
      if (localObject1 == null) {}
    }
  }
  
  public static Bitmap bc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124114);
    if (!com.tencent.mm.kernel.g.ajR().isSDCardAvailable())
    {
      paramString1 = aGe();
      AppMethodBeat.o(124114);
      return paramString1;
    }
    if ((paramString1 == null) || (!com.tencent.mm.kernel.g.ajP().aiZ()))
    {
      AppMethodBeat.o(124114);
      return null;
    }
    final String str = paramString2;
    if (paramString2 == null)
    {
      paramString2 = bd(paramString1, null);
      str = paramString2;
      if (paramString2 == null)
      {
        AppMethodBeat.o(124114);
        return null;
      }
    }
    paramString2 = ag.aGz();
    Object localObject;
    if (paramString2.hTw.containsKey(paramString1))
    {
      localObject = (Bitmap)((WeakReference)paramString2.hTw.get(paramString1)).get();
      if ((localObject == null) || (((Bitmap)localObject).isRecycled()))
      {
        localObject = bd(paramString1, str);
        localObject = h.aRC(a.EK(paramString1 + (String)localObject));
        if (localObject == null)
        {
          ae.i("MicroMsg.BrandLogic", "not found brand icon local");
          paramString2 = null;
          label162:
          if (paramString2 == null) {
            break label262;
          }
          AppMethodBeat.o(124114);
          return paramString2;
        }
        paramString2.f(paramString1, (Bitmap)localObject);
      }
    }
    for (;;)
    {
      paramString2 = (WeakReference)paramString2.hTw.get(paramString1);
      if (paramString2 == null) {
        break;
      }
      paramString2 = (Bitmap)paramString2.get();
      break label162;
      localObject = bd(paramString1, str);
      localObject = h.aRC(a.EK(paramString1 + (String)localObject));
      if (localObject == null)
      {
        ae.i("MicroMsg.BrandLogic", "not found brand icon local");
        break;
      }
      paramString2.f(paramString1, (Bitmap)localObject);
    }
    label262:
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124105);
        o.a locala = ag.aGz();
        String str1 = this.hTs;
        String str2 = str;
        if ((bu.isNullOrNil(str1)) || (bu.isNullOrNil(str2)))
        {
          ae.e("MicroMsg.BrandLogic", "pushing for brand " + str1 + ", url " + str2);
          AppMethodBeat.o(124105);
          return;
        }
        if (bu.rZ(bu.o((Integer)locala.hTv.get(str1))) < 300L)
        {
          ae.i("MicroMsg.BrandLogic", "downloading interval less than 5 mins for ".concat(String.valueOf(str1)));
          AppMethodBeat.o(124105);
          return;
        }
        locala.hTv.put(str1, Integer.valueOf((int)bu.aRi()));
        if ((locala.hTx == null) || (locala.hTx.fpj())) {
          locala.hTx = new bf(1, "brand-logic");
        }
        str2 = o.bd(str1, str2);
        locala.hTx.c(new o.b(str1, str2));
        AppMethodBeat.o(124105);
      }
    });
    AppMethodBeat.o(124114);
    return null;
  }
  
  static String bd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124116);
    if ((paramString1 == null) || (!com.tencent.mm.kernel.g.ajP().aiZ()))
    {
      AppMethodBeat.o(124116);
      return null;
    }
    paramString1 = ag.aGp().Ef(paramString1);
    if (paramString1.field_brandIconURL != null)
    {
      paramString1 = paramString1.field_brandIconURL;
      AppMethodBeat.o(124116);
      return paramString1;
    }
    AppMethodBeat.o(124116);
    return paramString2;
  }
  
  public static final class a
  {
    List<Object> hTu;
    Map<String, Integer> hTv;
    Map<String, WeakReference<Bitmap>> hTw;
    bf hTx;
    
    public a()
    {
      AppMethodBeat.i(124106);
      this.hTu = new ArrayList();
      this.hTv = new HashMap();
      this.hTw = new HashMap();
      this.hTx = null;
      AppMethodBeat.o(124106);
    }
    
    public static String EK(String paramString)
    {
      AppMethodBeat.i(124109);
      if (com.tencent.mm.kernel.g.ajP().aiZ())
      {
        paramString = ((q)com.tencent.mm.kernel.g.ab(q.class)).azZ() + "/brand_" + com.tencent.mm.b.g.getMessageDigest(paramString.getBytes());
        AppMethodBeat.o(124109);
        return paramString;
      }
      AppMethodBeat.o(124109);
      return "";
    }
    
    final Bitmap EJ(String paramString)
    {
      AppMethodBeat.i(124108);
      String str = String.format("%s%f", new Object[] { paramString, Float.valueOf(1.5F) });
      Bitmap localBitmap1;
      if (this.hTw.containsKey(str))
      {
        Bitmap localBitmap2 = (Bitmap)((WeakReference)this.hTw.get(str)).get();
        if (localBitmap2 != null)
        {
          localBitmap1 = localBitmap2;
          if (!localBitmap2.isRecycled()) {}
        }
        else
        {
          localBitmap1 = BackwardSupportUtil.b.p(paramString, 1.5F);
          this.hTw.remove(str);
          this.hTw.put(str, new WeakReference(localBitmap1));
        }
      }
      for (;;)
      {
        AppMethodBeat.o(124108);
        return localBitmap1;
        localBitmap1 = BackwardSupportUtil.b.p(paramString, 1.5F);
        this.hTw.put(str, new WeakReference(localBitmap1));
      }
    }
    
    public final void aGf()
    {
      AppMethodBeat.i(124107);
      this.hTu.clear();
      AppMethodBeat.o(124107);
    }
    
    final void f(String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(124110);
      Bitmap localBitmap1;
      if (this.hTw.containsKey(paramString)) {
        localBitmap1 = (Bitmap)((WeakReference)this.hTw.get(paramString)).get();
      }
      for (;;)
      {
        Bitmap localBitmap3;
        if (localBitmap1 != null)
        {
          localBitmap3 = localBitmap1;
          if (!localBitmap1.isRecycled()) {
            break label110;
          }
        }
        try
        {
          localBitmap1 = Bitmap.createScaledBitmap(paramBitmap, 128, 128, true);
          localBitmap1 = h.a(localBitmap1, true, localBitmap1.getWidth() >> 1);
          this.hTw.remove(paramString);
          this.hTw.put(paramString, new WeakReference(localBitmap1));
          localBitmap3 = localBitmap1;
          label110:
          if (localBitmap3 == paramBitmap)
          {
            AppMethodBeat.o(124110);
            return;
            localBitmap1 = null;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            Bitmap localBitmap2 = paramBitmap;
          }
          ae.i("MicroMsg.BrandLogic", "recycle bitmap:%s", new Object[] { paramBitmap.toString() });
          paramBitmap.recycle();
          AppMethodBeat.o(124110);
        }
      }
    }
  }
  
  static final class b
    implements bf.a
  {
    public byte[] hPk = null;
    private final String hTy;
    private final String url;
    
    public b(String paramString1, String paramString2)
    {
      this.hTy = paramString1;
      this.url = paramString2;
    }
    
    public final boolean aEC()
    {
      AppMethodBeat.i(124111);
      if ((bu.isNullOrNil(this.hTy)) || (bu.isNullOrNil(this.url)))
      {
        AppMethodBeat.o(124111);
        return false;
      }
      Object localObject1;
      Object localObject2;
      try
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        localObject1 = b.w(this.url, 3000, 5000);
        if (localObject1 == null)
        {
          AppMethodBeat.o(124111);
          return false;
        }
        localObject2 = new byte[1024];
        for (;;)
        {
          int i = ((InputStream)localObject1).read((byte[])localObject2);
          if (i == -1) {
            break;
          }
          localByteArrayOutputStream.write((byte[])localObject2, 0, i);
        }
        ((InputStream)localObject1).close();
      }
      catch (Exception localException1)
      {
        ae.e("MicroMsg.BrandLogic", "exception:%s", new Object[] { bu.o(localException1) });
        ae.e("MicroMsg.BrandLogic", "get url:" + this.url + " failed.");
        this.hPk = null;
        AppMethodBeat.o(124111);
        return false;
      }
      this.hPk = localException1.toByteArray();
      localException1.close();
      if (bu.cF(this.hPk))
      {
        ae.e("MicroMsg.BrandLogic", "imgBuff null brand:" + this.hTy);
        AppMethodBeat.o(124111);
        return false;
      }
      o.a locala;
      String str;
      if (com.tencent.mm.kernel.g.ajP().aiZ())
      {
        au.a.hIH.db(this.hPk.length, 0);
        locala = ag.aGz();
        localObject1 = this.hTy;
        str = this.url;
        localObject2 = this.hPk;
      }
      try
      {
        str = (String)localObject1 + str;
        localObject2 = h.cu((byte[])localObject2);
        h.a((Bitmap)localObject2, 100, Bitmap.CompressFormat.PNG, o.a.EK(str), false);
        locala.f((String)localObject1, (Bitmap)localObject2);
        ae.i("MicroMsg.BrandLogic", "update brand icon for  " + (String)localObject1 + ", done");
        locala.hTv.remove(localObject1);
        AppMethodBeat.o(124111);
        return true;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ae.e("MicroMsg.BrandLogic", "exception:%s", new Object[] { bu.o(localException2) });
        }
      }
    }
    
    public final boolean aED()
    {
      AppMethodBeat.i(124112);
      o.a locala = ag.aGz();
      int i = 0;
      try
      {
        while (i < locala.hTu.size())
        {
          locala.hTu.get(i);
          i += 1;
        }
        return false;
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.BrandLogic", "exception:%s", new Object[] { bu.o(localException) });
        AppMethodBeat.o(124112);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.o
 * JD-Core Version:    0.7.0.1
 */