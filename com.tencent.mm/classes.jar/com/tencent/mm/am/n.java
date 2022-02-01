package com.tencent.mm.am;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.c;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.e;
import com.tencent.mm.network.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.be.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class n
{
  public static Bitmap aT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124114);
    if (!com.tencent.mm.kernel.g.afB().isSDCardAvailable())
    {
      paramString1 = avT();
      AppMethodBeat.o(124114);
      return paramString1;
    }
    if ((paramString1 == null) || (!com.tencent.mm.kernel.g.afz().aeI()))
    {
      AppMethodBeat.o(124114);
      return null;
    }
    final String str = paramString2;
    if (paramString2 == null)
    {
      paramString2 = aU(paramString1, null);
      str = paramString2;
      if (paramString2 == null)
      {
        AppMethodBeat.o(124114);
        return null;
      }
    }
    paramString2 = af.awo();
    Object localObject;
    if (paramString2.gXL.containsKey(paramString1))
    {
      localObject = (Bitmap)((WeakReference)paramString2.gXL.get(paramString1)).get();
      if ((localObject == null) || (((Bitmap)localObject).isRecycled()))
      {
        localObject = aU(paramString1, str);
        localObject = f.aFi(a.xd(paramString1 + (String)localObject));
        if (localObject == null)
        {
          ad.i("MicroMsg.BrandLogic", "not found brand icon local");
          paramString2 = null;
          label162:
          if (paramString2 == null) {
            break label262;
          }
          AppMethodBeat.o(124114);
          return paramString2;
        }
        paramString2.g(paramString1, (Bitmap)localObject);
      }
    }
    for (;;)
    {
      paramString2 = (WeakReference)paramString2.gXL.get(paramString1);
      if (paramString2 == null) {
        break;
      }
      paramString2 = (Bitmap)paramString2.get();
      break label162;
      localObject = aU(paramString1, str);
      localObject = f.aFi(a.xd(paramString1 + (String)localObject));
      if (localObject == null)
      {
        ad.i("MicroMsg.BrandLogic", "not found brand icon local");
        break;
      }
      paramString2.g(paramString1, (Bitmap)localObject);
    }
    label262:
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124105);
        n.a locala = af.awo();
        String str1 = this.gXH;
        String str2 = str;
        if ((bt.isNullOrNil(str1)) || (bt.isNullOrNil(str2)))
        {
          ad.e("MicroMsg.BrandLogic", "pushing for brand " + str1 + ", url " + str2);
          AppMethodBeat.o(124105);
          return;
        }
        if (bt.lZ(bt.l((Integer)locala.gXK.get(str1))) < 300L)
        {
          ad.i("MicroMsg.BrandLogic", "downloading interval less than 5 mins for ".concat(String.valueOf(str1)));
          AppMethodBeat.o(124105);
          return;
        }
        locala.gXK.put(str1, Integer.valueOf((int)bt.aGK()));
        if ((locala.gXM == null) || (locala.gXM.eGm())) {
          locala.gXM = new be(1, "brand-logic");
        }
        str2 = n.aU(str1, str2);
        locala.gXM.c(new n.b(str1, str2));
        AppMethodBeat.o(124105);
      }
    });
    AppMethodBeat.o(124114);
    return null;
  }
  
  static String aU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124116);
    if ((paramString1 == null) || (!com.tencent.mm.kernel.g.afz().aeI()))
    {
      AppMethodBeat.o(124116);
      return null;
    }
    paramString1 = af.awe().wy(paramString1);
    if (paramString1.field_brandIconURL != null)
    {
      paramString1 = paramString1.field_brandIconURL;
      AppMethodBeat.o(124116);
      return paramString1;
    }
    AppMethodBeat.o(124116);
    return paramString2;
  }
  
  private static Bitmap avT()
  {
    localObject1 = null;
    AppMethodBeat.i(124115);
    Object localObject4 = new BitmapFactory.Options();
    f.eFa();
    try
    {
      Object localObject2 = aj.getContext().getResources().openRawResource(2131233478);
      localObject1 = localObject2;
      localObject4 = BitmapFactory.decodeStream((InputStream)localObject2, null, (BitmapFactory.Options)localObject4);
      localObject1 = localObject4;
      if (localObject2 != null) {}
      try
      {
        ((InputStream)localObject2).close();
        localObject2 = localObject1;
        if (localObject1 != null) {
          localObject2 = f.a(localObject1, false, localObject1.getWidth() >> 1);
        }
        AppMethodBeat.o(124115);
        return localObject2;
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.BrandLogic", localIOException2, "", new Object[0]);
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
          ad.printErrStackTrace("MicroMsg.BrandLogic", localIOException1, "", new Object[0]);
        }
      }
    }
    finally
    {
      if (localObject1 == null) {}
    }
  }
  
  public static Bitmap xb(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(124113);
    if ((bt.isNullOrNil(paramString)) || (!com.tencent.mm.kernel.g.afB().isSDCardAvailable()) || (!com.tencent.mm.kernel.g.afz().aeI()))
    {
      AppMethodBeat.o(124113);
      return null;
    }
    Bitmap localBitmap = af.awo().xc(paramString);
    if (localBitmap == null) {
      bool = true;
    }
    ad.i("MicroMsg.BrandLogic", "get verify user icon = %s, is null ? %s", new Object[] { paramString, String.valueOf(bool) });
    AppMethodBeat.o(124113);
    return localBitmap;
  }
  
  public static final class a
  {
    List<Object> gXJ;
    Map<String, Integer> gXK;
    Map<String, WeakReference<Bitmap>> gXL;
    be gXM;
    
    public a()
    {
      AppMethodBeat.i(124106);
      this.gXJ = new ArrayList();
      this.gXK = new HashMap();
      this.gXL = new HashMap();
      this.gXM = null;
      AppMethodBeat.o(124106);
    }
    
    public static String xd(String paramString)
    {
      AppMethodBeat.i(124109);
      if (com.tencent.mm.kernel.g.afz().aeI())
      {
        paramString = ((p)com.tencent.mm.kernel.g.ab(p.class)).aqf() + "/brand_" + com.tencent.mm.b.g.getMessageDigest(paramString.getBytes());
        AppMethodBeat.o(124109);
        return paramString;
      }
      AppMethodBeat.o(124109);
      return "";
    }
    
    public final void avU()
    {
      AppMethodBeat.i(124107);
      this.gXJ.clear();
      AppMethodBeat.o(124107);
    }
    
    final void g(String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(124110);
      Bitmap localBitmap1;
      if (this.gXL.containsKey(paramString)) {
        localBitmap1 = (Bitmap)((WeakReference)this.gXL.get(paramString)).get();
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
          localBitmap1 = f.a(localBitmap1, true, localBitmap1.getWidth() >> 1);
          this.gXL.remove(paramString);
          this.gXL.put(paramString, new WeakReference(localBitmap1));
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
          ad.i("MicroMsg.BrandLogic", "recycle bitmap:%s", new Object[] { paramBitmap.toString() });
          paramBitmap.recycle();
          AppMethodBeat.o(124110);
        }
      }
    }
    
    final Bitmap xc(String paramString)
    {
      AppMethodBeat.i(124108);
      String str = String.format("%s%f", new Object[] { paramString, Float.valueOf(1.5F) });
      Bitmap localBitmap1;
      if (this.gXL.containsKey(str))
      {
        Bitmap localBitmap2 = (Bitmap)((WeakReference)this.gXL.get(str)).get();
        if (localBitmap2 != null)
        {
          localBitmap1 = localBitmap2;
          if (!localBitmap2.isRecycled()) {}
        }
        else
        {
          localBitmap1 = BackwardSupportUtil.b.n(paramString, 1.5F);
          this.gXL.remove(str);
          this.gXL.put(str, new WeakReference(localBitmap1));
        }
      }
      for (;;)
      {
        AppMethodBeat.o(124108);
        return localBitmap1;
        localBitmap1 = BackwardSupportUtil.b.n(paramString, 1.5F);
        this.gXL.put(str, new WeakReference(localBitmap1));
      }
    }
  }
  
  static final class b
    implements be.a
  {
    public byte[] gTA = null;
    private final String gXN;
    private final String url;
    
    public b(String paramString1, String paramString2)
    {
      this.gXN = paramString1;
      this.url = paramString2;
    }
    
    public final boolean aus()
    {
      AppMethodBeat.i(124111);
      if ((bt.isNullOrNil(this.gXN)) || (bt.isNullOrNil(this.url)))
      {
        AppMethodBeat.o(124111);
        return false;
      }
      Object localObject1;
      Object localObject2;
      try
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        localObject1 = b.v(this.url, 3000, 5000);
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
        ad.e("MicroMsg.BrandLogic", "exception:%s", new Object[] { bt.m(localException1) });
        ad.e("MicroMsg.BrandLogic", "get url:" + this.url + " failed.");
        this.gTA = null;
        AppMethodBeat.o(124111);
        return false;
      }
      this.gTA = localException1.toByteArray();
      localException1.close();
      if (bt.cw(this.gTA))
      {
        ad.e("MicroMsg.BrandLogic", "imgBuff null brand:" + this.gXN);
        AppMethodBeat.o(124111);
        return false;
      }
      n.a locala;
      String str;
      if (com.tencent.mm.kernel.g.afz().aeI())
      {
        ar.a.gMX.cZ(this.gTA.length, 0);
        locala = af.awo();
        localObject1 = this.gXN;
        str = this.url;
        localObject2 = this.gTA;
      }
      try
      {
        str = (String)localObject1 + str;
        localObject2 = f.cl((byte[])localObject2);
        f.a((Bitmap)localObject2, 100, Bitmap.CompressFormat.PNG, n.a.xd(str), false);
        locala.g((String)localObject1, (Bitmap)localObject2);
        ad.i("MicroMsg.BrandLogic", "update brand icon for  " + (String)localObject1 + ", done");
        locala.gXK.remove(localObject1);
        AppMethodBeat.o(124111);
        return true;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ad.e("MicroMsg.BrandLogic", "exception:%s", new Object[] { bt.m(localException2) });
        }
      }
    }
    
    public final boolean aut()
    {
      AppMethodBeat.i(124112);
      n.a locala = af.awo();
      int i = 0;
      try
      {
        while (i < locala.gXJ.size())
        {
          locala.gXJ.get(i);
          i += 1;
        }
        return false;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.BrandLogic", "exception:%s", new Object[] { bt.m(localException) });
        AppMethodBeat.o(124112);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.n
 * JD-Core Version:    0.7.0.1
 */