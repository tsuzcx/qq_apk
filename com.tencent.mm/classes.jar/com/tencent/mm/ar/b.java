package com.tencent.mm.ar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.g;
import com.tencent.mm.g.a.bk;
import com.tencent.mm.g.a.bk.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import org.json.JSONObject;

public class b
{
  public static final String hds;
  public static final String hdt;
  public static final String hdu;
  public static final String hdv;
  private static b hdw;
  private String hdx;
  private boolean hdy;
  public c<bk> hdz;
  
  static
  {
    AppMethodBeat.i(104519);
    hds = com.tencent.mm.loader.j.b.aia() + "fonts/";
    hdt = hds + "temp/";
    hdu = hds + "WXkatonglemiao.ttf";
    hdv = hds + "WXxiari.ttf";
    AppMethodBeat.o(104519);
  }
  
  public b()
  {
    AppMethodBeat.i(104512);
    this.hdx = "emoji_font_meta.json";
    this.hdy = false;
    this.hdz = new c() {};
    AppMethodBeat.o(104512);
  }
  
  private static boolean a(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(104517);
    String str1 = paramJSONObject.optString("name");
    paramJSONObject = paramJSONObject.optString("md5");
    String str2 = hdt + str1;
    String str3 = g.getMD5(str2);
    if ((bt.isNullOrNil(str3)) || (!str3.equalsIgnoreCase(paramJSONObject)))
    {
      ad.e("MicroMsg.FontResLogic", "download %s not match! %s %s", new Object[] { str1, str3, paramJSONObject });
      AppMethodBeat.o(104517);
      return false;
    }
    if (!paramString.equalsIgnoreCase(str2)) {
      i.lD(str2, paramString);
    }
    AppMethodBeat.o(104517);
    return true;
  }
  
  public static b axr()
  {
    AppMethodBeat.i(104513);
    try
    {
      if (hdw == null) {
        hdw = new b();
      }
      b localb = hdw;
      AppMethodBeat.o(104513);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(104513);
    }
  }
  
  public static void axt()
  {
    AppMethodBeat.i(104514);
    com.tencent.mm.pluginsdk.h.a.a.b.ewn();
    com.tencent.mm.pluginsdk.h.a.a.b.Ur(57);
    AppMethodBeat.o(104514);
  }
  
  public static String[] axv()
  {
    return new String[] { hdv, hdu };
  }
  
  public final boolean axs()
  {
    return this.hdy;
  }
  
  public final boolean axu()
  {
    AppMethodBeat.i(104515);
    if ((i.eK(hdu)) && (i.eK(hdv))) {
      ad.i("MicroMsg.FontResLogic", "font file exist");
    }
    for (this.hdy = true;; this.hdy = false)
    {
      boolean bool = this.hdy;
      AppMethodBeat.o(104515);
      return bool;
    }
  }
  
  public final void f(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        AppMethodBeat.i(104516);
        ad.i("MicroMsg.FontResLogic", "unzipRes: %s", new Object[] { paramString });
        if (!i.eK(paramString)) {
          break;
        }
        i.aMF(hdt);
        int j = i.fc(paramString, hdt);
        ad.i("MicroMsg.FontResLogic", "unzip file ret: %s", new Object[] { Integer.valueOf(j) });
        if (j != 0) {
          break;
        }
      }
      finally {}
      try
      {
        if (!i.eK(hdt + this.hdx)) {
          break label471;
        }
        paramString = i.aMP(hdt + this.hdx);
        ad.i("MicroMsg.FontResLogic", "meta json: %s", new Object[] { paramString });
        localJSONObject = new JSONObject(paramString);
        paramString = localJSONObject.optJSONObject("WXkatonglemiao.ttf");
        localJSONObject = localJSONObject.optJSONObject("WXxiari.ttf");
        if ((paramString == null) || (localJSONObject == null)) {
          break label471;
        }
        if (a(paramString, hdu)) {
          continue;
        }
        h.vKh.m(933L, 13L, 1L);
      }
      catch (Exception paramString)
      {
        ad.printErrStackTrace("MicroMsg.FontResLogic", paramString, "unzipRes error: %s", new Object[] { paramString.getMessage() });
        h.vKh.m(933L, 15L, 1L);
        ad.i("MicroMsg.FontResLogic", "unzip failed");
        this.hdy = false;
        i.cO(hdt, true);
        AppMethodBeat.o(104516);
        continue;
      }
      finally
      {
        ad.i("MicroMsg.FontResLogic", "unzip failed");
        this.hdy = false;
        i.cO(hdt, true);
        AppMethodBeat.o(104516);
      }
      return;
      if (!a(localJSONObject, hdv))
      {
        h.vKh.m(933L, 14L, 1L);
        ad.i("MicroMsg.FontResLogic", "unzip failed");
        this.hdy = false;
        i.cO(hdt, true);
        AppMethodBeat.o(104516);
      }
      else
      {
        ad.i("MicroMsg.FontResLogic", "unzip res success");
        if (!axu()) {
          break label471;
        }
        ad.i("MicroMsg.FontResLogic", "unzipRes success");
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        ad.i("MicroMsg.FontResLogic", "unzip failed");
        this.hdy = false;
      }
      for (;;)
      {
        i.cO(hdt, true);
        AppMethodBeat.o(104516);
        break;
        ad.i("MicroMsg.FontResLogic", "unzip success");
        h.vKh.m(933L, 16L, 1L);
        com.tencent.mm.pluginsdk.h.a.a.b.ewn().aD(paramInt1, paramInt2, paramInt3);
      }
      AppMethodBeat.o(104516);
      break;
      label471:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ar.b
 * JD-Core Version:    0.7.0.1
 */