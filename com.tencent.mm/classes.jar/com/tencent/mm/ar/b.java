package com.tencent.mm.ar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.g.a.bn.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import org.json.JSONObject;

public class b
{
  public static final String hWA;
  public static final String hWB;
  public static final String hWC;
  public static final String hWD;
  private static b hWE;
  private String hWF;
  private boolean hWG;
  public c<bn> hWH;
  
  static
  {
    AppMethodBeat.i(104519);
    hWA = com.tencent.mm.loader.j.b.arN() + "fonts/";
    hWB = hWA + "temp/";
    hWC = hWA + "WXkatonglemiao.ttf";
    hWD = hWA + "WXxiari.ttf";
    AppMethodBeat.o(104519);
  }
  
  public b()
  {
    AppMethodBeat.i(104512);
    this.hWF = "emoji_font_meta.json";
    this.hWG = false;
    this.hWH = new c() {};
    AppMethodBeat.o(104512);
  }
  
  private static boolean a(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(104517);
    String str1 = paramJSONObject.optString("name");
    paramJSONObject = paramJSONObject.optString("md5");
    String str2 = hWB + str1;
    String str3 = com.tencent.mm.d.g.getMD5(str2);
    if ((bt.isNullOrNil(str3)) || (!str3.equalsIgnoreCase(paramJSONObject)))
    {
      ad.e("MicroMsg.FontResLogic", "download %s not match! %s %s", new Object[] { str1, str3, paramJSONObject });
      AppMethodBeat.o(104517);
      return false;
    }
    if (!paramString.equalsIgnoreCase(str2)) {
      i.mA(str2, paramString);
    }
    AppMethodBeat.o(104517);
    return true;
  }
  
  public static b aHo()
  {
    AppMethodBeat.i(104513);
    try
    {
      if (hWE == null) {
        hWE = new b();
      }
      b localb = hWE;
      AppMethodBeat.o(104513);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(104513);
    }
  }
  
  public static void aHq()
  {
    AppMethodBeat.i(104514);
    com.tencent.mm.pluginsdk.j.a.a.b.faE();
    com.tencent.mm.pluginsdk.j.a.a.b.Yx(57);
    AppMethodBeat.o(104514);
  }
  
  public static String[] aHs()
  {
    return new String[] { hWD, hWC };
  }
  
  public final boolean aHp()
  {
    return this.hWG;
  }
  
  public final boolean aHr()
  {
    AppMethodBeat.i(104515);
    if ((i.fv(hWC)) && (i.fv(hWD))) {
      ad.i("MicroMsg.FontResLogic", "font file exist");
    }
    for (this.hWG = true;; this.hWG = false)
    {
      boolean bool = this.hWG;
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
        if (!i.fv(paramString)) {
          break;
        }
        i.aYg(hWB);
        int j = i.fz(paramString, hWB);
        ad.i("MicroMsg.FontResLogic", "unzip file ret: %s", new Object[] { Integer.valueOf(j) });
        if (j != 0) {
          break;
        }
      }
      finally {}
      try
      {
        if (!i.fv(hWB + this.hWF)) {
          break label471;
        }
        paramString = i.aYq(hWB + this.hWF);
        ad.i("MicroMsg.FontResLogic", "meta json: %s", new Object[] { paramString });
        localJSONObject = new JSONObject(paramString);
        paramString = localJSONObject.optJSONObject("WXkatonglemiao.ttf");
        localJSONObject = localJSONObject.optJSONObject("WXxiari.ttf");
        if ((paramString == null) || (localJSONObject == null)) {
          break label471;
        }
        if (a(paramString, hWC)) {
          continue;
        }
        com.tencent.mm.plugin.report.service.g.yhR.n(933L, 13L, 1L);
      }
      catch (Exception paramString)
      {
        ad.printErrStackTrace("MicroMsg.FontResLogic", paramString, "unzipRes error: %s", new Object[] { paramString.getMessage() });
        com.tencent.mm.plugin.report.service.g.yhR.n(933L, 15L, 1L);
        ad.i("MicroMsg.FontResLogic", "unzip failed");
        this.hWG = false;
        i.cZ(hWB, true);
        AppMethodBeat.o(104516);
        continue;
      }
      finally
      {
        ad.i("MicroMsg.FontResLogic", "unzip failed");
        this.hWG = false;
        i.cZ(hWB, true);
        AppMethodBeat.o(104516);
      }
      return;
      if (!a(localJSONObject, hWD))
      {
        com.tencent.mm.plugin.report.service.g.yhR.n(933L, 14L, 1L);
        ad.i("MicroMsg.FontResLogic", "unzip failed");
        this.hWG = false;
        i.cZ(hWB, true);
        AppMethodBeat.o(104516);
      }
      else
      {
        ad.i("MicroMsg.FontResLogic", "unzip res success");
        if (!aHr()) {
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
        this.hWG = false;
      }
      for (;;)
      {
        i.cZ(hWB, true);
        AppMethodBeat.o(104516);
        break;
        ad.i("MicroMsg.FontResLogic", "unzip success");
        com.tencent.mm.plugin.report.service.g.yhR.n(933L, 16L, 1L);
        com.tencent.mm.pluginsdk.j.a.a.b.faE().aG(paramInt1, paramInt2, paramInt3);
      }
      AppMethodBeat.o(104516);
      break;
      label471:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ar.b
 * JD-Core Version:    0.7.0.1
 */