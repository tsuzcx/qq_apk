package com.tencent.mm.aq;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.g.a.bn.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import org.json.JSONObject;

public class b
{
  public static final String hZs;
  public static final String hZt;
  public static final String hZu;
  public static final String hZv;
  private static b hZw;
  private String hZx;
  private boolean hZy;
  public c<bn> hZz;
  
  static
  {
    AppMethodBeat.i(104519);
    hZs = com.tencent.mm.loader.j.b.asc() + "fonts/";
    hZt = hZs + "temp/";
    hZu = hZs + "WXkatonglemiao.ttf";
    hZv = hZs + "WXxiari.ttf";
    AppMethodBeat.o(104519);
  }
  
  public b()
  {
    AppMethodBeat.i(104512);
    this.hZx = "emoji_font_meta.json";
    this.hZy = false;
    this.hZz = new c() {};
    AppMethodBeat.o(104512);
  }
  
  private static boolean a(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(104517);
    String str1 = paramJSONObject.optString("name");
    paramJSONObject = paramJSONObject.optString("md5");
    String str2 = hZt + str1;
    String str3 = com.tencent.mm.d.g.getMD5(str2);
    if ((bu.isNullOrNil(str3)) || (!str3.equalsIgnoreCase(paramJSONObject)))
    {
      ae.e("MicroMsg.FontResLogic", "download %s not match! %s %s", new Object[] { str1, str3, paramJSONObject });
      AppMethodBeat.o(104517);
      return false;
    }
    if (!paramString.equalsIgnoreCase(str2)) {
      o.mG(str2, paramString);
    }
    AppMethodBeat.o(104517);
    return true;
  }
  
  public static b aHF()
  {
    AppMethodBeat.i(104513);
    try
    {
      if (hZw == null) {
        hZw = new b();
      }
      b localb = hZw;
      AppMethodBeat.o(104513);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(104513);
    }
  }
  
  public static void aHH()
  {
    AppMethodBeat.i(104514);
    com.tencent.mm.pluginsdk.j.a.a.b.fes();
    com.tencent.mm.pluginsdk.j.a.a.b.Zd(57);
    AppMethodBeat.o(104514);
  }
  
  public static String[] aHJ()
  {
    return new String[] { hZv, hZu };
  }
  
  public final boolean aHG()
  {
    return this.hZy;
  }
  
  public final boolean aHI()
  {
    AppMethodBeat.i(104515);
    if ((o.fB(hZu)) && (o.fB(hZv))) {
      ae.i("MicroMsg.FontResLogic", "font file exist");
    }
    for (this.hZy = true;; this.hZy = false)
    {
      boolean bool = this.hZy;
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
        ae.i("MicroMsg.FontResLogic", "unzipRes: %s", new Object[] { paramString });
        if (!o.fB(paramString)) {
          break;
        }
        o.aZI(hZt);
        int j = o.fD(paramString, hZt);
        ae.i("MicroMsg.FontResLogic", "unzip file ret: %s", new Object[] { Integer.valueOf(j) });
        if (j != 0) {
          break;
        }
      }
      finally {}
      try
      {
        if (!o.fB(hZt + this.hZx)) {
          break label471;
        }
        paramString = o.aZT(hZt + this.hZx);
        ae.i("MicroMsg.FontResLogic", "meta json: %s", new Object[] { paramString });
        localJSONObject = new JSONObject(paramString);
        paramString = localJSONObject.optJSONObject("WXkatonglemiao.ttf");
        localJSONObject = localJSONObject.optJSONObject("WXxiari.ttf");
        if ((paramString == null) || (localJSONObject == null)) {
          break label471;
        }
        if (a(paramString, hZu)) {
          continue;
        }
        com.tencent.mm.plugin.report.service.g.yxI.n(933L, 13L, 1L);
      }
      catch (Exception paramString)
      {
        ae.printErrStackTrace("MicroMsg.FontResLogic", paramString, "unzipRes error: %s", new Object[] { paramString.getMessage() });
        com.tencent.mm.plugin.report.service.g.yxI.n(933L, 15L, 1L);
        ae.i("MicroMsg.FontResLogic", "unzip failed");
        this.hZy = false;
        o.dd(hZt, true);
        AppMethodBeat.o(104516);
        continue;
      }
      finally
      {
        ae.i("MicroMsg.FontResLogic", "unzip failed");
        this.hZy = false;
        o.dd(hZt, true);
        AppMethodBeat.o(104516);
      }
      return;
      if (!a(localJSONObject, hZv))
      {
        com.tencent.mm.plugin.report.service.g.yxI.n(933L, 14L, 1L);
        ae.i("MicroMsg.FontResLogic", "unzip failed");
        this.hZy = false;
        o.dd(hZt, true);
        AppMethodBeat.o(104516);
      }
      else
      {
        ae.i("MicroMsg.FontResLogic", "unzip res success");
        if (!aHI()) {
          break label471;
        }
        ae.i("MicroMsg.FontResLogic", "unzipRes success");
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        ae.i("MicroMsg.FontResLogic", "unzip failed");
        this.hZy = false;
      }
      for (;;)
      {
        o.dd(hZt, true);
        AppMethodBeat.o(104516);
        break;
        ae.i("MicroMsg.FontResLogic", "unzip success");
        com.tencent.mm.plugin.report.service.g.yxI.n(933L, 16L, 1L);
        com.tencent.mm.pluginsdk.j.a.a.b.fes().aH(paramInt1, paramInt2, paramInt3);
      }
      AppMethodBeat.o(104516);
      break;
      label471:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.aq.b
 * JD-Core Version:    0.7.0.1
 */