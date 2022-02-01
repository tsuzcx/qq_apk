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
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.e;
import com.tencent.mm.network.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bd.a;
import com.tencent.mm.sdk.platformtools.bs;
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
  public static Bitmap Bh(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(124113);
    if ((bs.isNullOrNil(paramString)) || (!com.tencent.mm.kernel.g.agR().isSDCardAvailable()) || (!com.tencent.mm.kernel.g.agP().afY()))
    {
      AppMethodBeat.o(124113);
      return null;
    }
    Bitmap localBitmap = af.aDg().Bi(paramString);
    if (localBitmap == null) {
      bool = true;
    }
    ac.i("MicroMsg.BrandLogic", "get verify user icon = %s, is null ? %s", new Object[] { paramString, String.valueOf(bool) });
    AppMethodBeat.o(124113);
    return localBitmap;
  }
  
  private static Bitmap aCL()
  {
    localObject1 = null;
    AppMethodBeat.i(124115);
    Object localObject4 = new BitmapFactory.Options();
    f.eUu();
    try
    {
      Object localObject2 = ai.getContext().getResources().openRawResource(2131233478);
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
          ac.printErrStackTrace("MicroMsg.BrandLogic", localIOException2, "", new Object[0]);
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
          ac.printErrStackTrace("MicroMsg.BrandLogic", localIOException1, "", new Object[0]);
        }
      }
    }
    finally
    {
      if (localObject1 == null) {}
    }
  }
  
  public static Bitmap bb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124114);
    if (!com.tencent.mm.kernel.g.agR().isSDCardAvailable())
    {
      paramString1 = aCL();
      AppMethodBeat.o(124114);
      return paramString1;
    }
    if ((paramString1 == null) || (!com.tencent.mm.kernel.g.agP().afY()))
    {
      AppMethodBeat.o(124114);
      return null;
    }
    final String str = paramString2;
    if (paramString2 == null)
    {
      paramString2 = bc(paramString1, null);
      str = paramString2;
      if (paramString2 == null)
      {
        AppMethodBeat.o(124114);
        return null;
      }
    }
    paramString2 = af.aDg();
    Object localObject;
    if (paramString2.hyk.containsKey(paramString1))
    {
      localObject = (Bitmap)((WeakReference)paramString2.hyk.get(paramString1)).get();
      if ((localObject == null) || (((Bitmap)localObject).isRecycled()))
      {
        localObject = bc(paramString1, str);
        localObject = f.aKz(a.Bj(paramString1 + (String)localObject));
        if (localObject == null)
        {
          ac.i("MicroMsg.BrandLogic", "not found brand icon local");
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
      paramString2 = (WeakReference)paramString2.hyk.get(paramString1);
      if (paramString2 == null) {
        break;
      }
      paramString2 = (Bitmap)paramString2.get();
      break label162;
      localObject = bc(paramString1, str);
      localObject = f.aKz(a.Bj(paramString1 + (String)localObject));
      if (localObject == null)
      {
        ac.i("MicroMsg.BrandLogic", "not found brand icon local");
        break;
      }
      paramString2.f(paramString1, (Bitmap)localObject);
    }
    label262:
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124105);
        n.a locala = af.aDg();
        String str1 = this.hyg;
        String str2 = str;
        if ((bs.isNullOrNil(str1)) || (bs.isNullOrNil(str2)))
        {
          ac.e("MicroMsg.BrandLogic", "pushing for brand " + str1 + ", url " + str2);
          AppMethodBeat.o(124105);
          return;
        }
        if (bs.pN(bs.m((Integer)locala.hyj.get(str1))) < 300L)
        {
          ac.i("MicroMsg.BrandLogic", "downloading interval less than 5 mins for ".concat(String.valueOf(str1)));
          AppMethodBeat.o(124105);
          return;
        }
        locala.hyj.put(str1, Integer.valueOf((int)bs.aNx()));
        if ((locala.hyl == null) || (locala.hyl.eVH())) {
          locala.hyl = new bd(1, "brand-logic");
        }
        str2 = n.bc(str1, str2);
        locala.hyl.c(new n.b(str1, str2));
        AppMethodBeat.o(124105);
      }
    });
    AppMethodBeat.o(124114);
    return null;
  }
  
  static String bc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124116);
    if ((paramString1 == null) || (!com.tencent.mm.kernel.g.agP().afY()))
    {
      AppMethodBeat.o(124116);
      return null;
    }
    paramString1 = af.aCW().AE(paramString1);
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
    List<Object> hyi;
    Map<String, Integer> hyj;
    Map<String, WeakReference<Bitmap>> hyk;
    bd hyl;
    
    public a()
    {
      AppMethodBeat.i(124106);
      this.hyi = new ArrayList();
      this.hyj = new HashMap();
      this.hyk = new HashMap();
      this.hyl = null;
      AppMethodBeat.o(124106);
    }
    
    public static String Bj(String paramString)
    {
      AppMethodBeat.i(124109);
      if (com.tencent.mm.kernel.g.agP().afY())
      {
        paramString = ((p)com.tencent.mm.kernel.g.ab(p.class)).awU() + "/brand_" + com.tencent.mm.b.g.getMessageDigest(paramString.getBytes());
        AppMethodBeat.o(124109);
        return paramString;
      }
      AppMethodBeat.o(124109);
      return "";
    }
    
    final Bitmap Bi(String paramString)
    {
      AppMethodBeat.i(124108);
      String str = String.format("%s%f", new Object[] { paramString, Float.valueOf(1.5F) });
      Bitmap localBitmap1;
      if (this.hyk.containsKey(str))
      {
        Bitmap localBitmap2 = (Bitmap)((WeakReference)this.hyk.get(str)).get();
        if (localBitmap2 != null)
        {
          localBitmap1 = localBitmap2;
          if (!localBitmap2.isRecycled()) {}
        }
        else
        {
          localBitmap1 = BackwardSupportUtil.b.n(paramString, 1.5F);
          this.hyk.remove(str);
          this.hyk.put(str, new WeakReference(localBitmap1));
        }
      }
      for (;;)
      {
        AppMethodBeat.o(124108);
        return localBitmap1;
        localBitmap1 = BackwardSupportUtil.b.n(paramString, 1.5F);
        this.hyk.put(str, new WeakReference(localBitmap1));
      }
    }
    
    public final void aCM()
    {
      AppMethodBeat.i(124107);
      this.hyi.clear();
      AppMethodBeat.o(124107);
    }
    
    final void f(String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(124110);
      Bitmap localBitmap1;
      if (this.hyk.containsKey(paramString)) {
        localBitmap1 = (Bitmap)((WeakReference)this.hyk.get(paramString)).get();
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
          this.hyk.remove(paramString);
          this.hyk.put(paramString, new WeakReference(localBitmap1));
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
          ac.i("MicroMsg.BrandLogic", "recycle bitmap:%s", new Object[] { paramBitmap.toString() });
          paramBitmap.recycle();
          AppMethodBeat.o(124110);
        }
      }
    }
  }
  
  static final class b
    implements bd.a
  {
    public byte[] htZ = null;
    private final String hym;
    private final String url;
    
    public b(String paramString1, String paramString2)
    {
      this.hym = paramString1;
      this.url = paramString2;
    }
    
    public final boolean aBj()
    {
      AppMethodBeat.i(124111);
      if ((bs.isNullOrNil(this.hym)) || (bs.isNullOrNil(this.url)))
      {
        AppMethodBeat.o(124111);
        return false;
      }
      Object localObject1;
      Object localObject2;
      try
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        localObject1 = b.u(this.url, 3000, 5000);
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
        ac.e("MicroMsg.BrandLogic", "exception:%s", new Object[] { bs.m(localException1) });
        ac.e("MicroMsg.BrandLogic", "get url:" + this.url + " failed.");
        this.htZ = null;
        AppMethodBeat.o(124111);
        return false;
      }
      this.htZ = localException1.toByteArray();
      localException1.close();
      if (bs.cv(this.htZ))
      {
        ac.e("MicroMsg.BrandLogic", "imgBuff null brand:" + this.hym);
        AppMethodBeat.o(124111);
        return false;
      }
      n.a locala;
      String str;
      if (com.tencent.mm.kernel.g.agP().afY())
      {
        ar.a.hnx.cZ(this.htZ.length, 0);
        locala = af.aDg();
        localObject1 = this.hym;
        str = this.url;
        localObject2 = this.htZ;
      }
      try
      {
        str = (String)localObject1 + str;
        localObject2 = f.ck((byte[])localObject2);
        f.a((Bitmap)localObject2, 100, Bitmap.CompressFormat.PNG, n.a.Bj(str), false);
        locala.f((String)localObject1, (Bitmap)localObject2);
        ac.i("MicroMsg.BrandLogic", "update brand icon for  " + (String)localObject1 + ", done");
        locala.hyj.remove(localObject1);
        AppMethodBeat.o(124111);
        return true;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ac.e("MicroMsg.BrandLogic", "exception:%s", new Object[] { bs.m(localException2) });
        }
      }
    }
    
    public final boolean aBk()
    {
      AppMethodBeat.i(124112);
      n.a locala = af.aDg();
      int i = 0;
      try
      {
        while (i < locala.hyi.size())
        {
          locala.hyi.get(i);
          i += 1;
        }
        return false;
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.BrandLogic", "exception:%s", new Object[] { bs.m(localException) });
        AppMethodBeat.o(124112);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.n
 * JD-Core Version:    0.7.0.1
 */