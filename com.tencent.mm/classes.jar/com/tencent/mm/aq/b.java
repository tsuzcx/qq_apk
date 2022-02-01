package com.tencent.mm.aq;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.g;
import com.tencent.mm.g.a.bk;
import com.tencent.mm.g.a.bk.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import org.json.JSONObject;

public class b
{
  public static final String hDV;
  public static final String hDW;
  public static final String hDX;
  public static final String hDY;
  private static b hDZ;
  private String hEa;
  private boolean hEb;
  public c<bk> hEc;
  
  static
  {
    AppMethodBeat.i(104519);
    hDV = com.tencent.mm.loader.j.b.apa() + "fonts/";
    hDW = hDV + "temp/";
    hDX = hDV + "WXkatonglemiao.ttf";
    hDY = hDV + "WXxiari.ttf";
    AppMethodBeat.o(104519);
  }
  
  public b()
  {
    AppMethodBeat.i(104512);
    this.hEa = "emoji_font_meta.json";
    this.hEb = false;
    this.hEc = new c() {};
    AppMethodBeat.o(104512);
  }
  
  private static boolean a(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(104517);
    String str1 = paramJSONObject.optString("name");
    paramJSONObject = paramJSONObject.optString("md5");
    String str2 = hDW + str1;
    String str3 = g.getMD5(str2);
    if ((bs.isNullOrNil(str3)) || (!str3.equalsIgnoreCase(paramJSONObject)))
    {
      ac.e("MicroMsg.FontResLogic", "download %s not match! %s %s", new Object[] { str1, str3, paramJSONObject });
      AppMethodBeat.o(104517);
      return false;
    }
    if (!paramString.equalsIgnoreCase(str2)) {
      i.ma(str2, paramString);
    }
    AppMethodBeat.o(104517);
    return true;
  }
  
  public static b aEj()
  {
    AppMethodBeat.i(104513);
    try
    {
      if (hDZ == null) {
        hDZ = new b();
      }
      b localb = hDZ;
      AppMethodBeat.o(104513);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(104513);
    }
  }
  
  public static void aEl()
  {
    AppMethodBeat.i(104514);
    com.tencent.mm.pluginsdk.h.a.a.b.eLH();
    com.tencent.mm.pluginsdk.h.a.a.b.WB(57);
    AppMethodBeat.o(104514);
  }
  
  public static String[] aEn()
  {
    return new String[] { hDY, hDX };
  }
  
  public final boolean aEk()
  {
    return this.hEb;
  }
  
  public final boolean aEm()
  {
    AppMethodBeat.i(104515);
    if ((i.eA(hDX)) && (i.eA(hDY))) {
      ac.i("MicroMsg.FontResLogic", "font file exist");
    }
    for (this.hEb = true;; this.hEb = false)
    {
      boolean bool = this.hEb;
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
        ac.i("MicroMsg.FontResLogic", "unzipRes: %s", new Object[] { paramString });
        if (!i.eA(paramString)) {
          break;
        }
        i.aSh(hDW);
        int j = i.fp(paramString, hDW);
        ac.i("MicroMsg.FontResLogic", "unzip file ret: %s", new Object[] { Integer.valueOf(j) });
        if (j != 0) {
          break;
        }
      }
      finally {}
      try
      {
        if (!i.eA(hDW + this.hEa)) {
          break label471;
        }
        paramString = i.aSr(hDW + this.hEa);
        ac.i("MicroMsg.FontResLogic", "meta json: %s", new Object[] { paramString });
        localJSONObject = new JSONObject(paramString);
        paramString = localJSONObject.optJSONObject("WXkatonglemiao.ttf");
        localJSONObject = localJSONObject.optJSONObject("WXxiari.ttf");
        if ((paramString == null) || (localJSONObject == null)) {
          break label471;
        }
        if (a(paramString, hDX)) {
          continue;
        }
        h.wUl.n(933L, 13L, 1L);
      }
      catch (Exception paramString)
      {
        ac.printErrStackTrace("MicroMsg.FontResLogic", paramString, "unzipRes error: %s", new Object[] { paramString.getMessage() });
        h.wUl.n(933L, 15L, 1L);
        ac.i("MicroMsg.FontResLogic", "unzip failed");
        this.hEb = false;
        i.cU(hDW, true);
        AppMethodBeat.o(104516);
        continue;
      }
      finally
      {
        ac.i("MicroMsg.FontResLogic", "unzip failed");
        this.hEb = false;
        i.cU(hDW, true);
        AppMethodBeat.o(104516);
      }
      return;
      if (!a(localJSONObject, hDY))
      {
        h.wUl.n(933L, 14L, 1L);
        ac.i("MicroMsg.FontResLogic", "unzip failed");
        this.hEb = false;
        i.cU(hDW, true);
        AppMethodBeat.o(104516);
      }
      else
      {
        ac.i("MicroMsg.FontResLogic", "unzip res success");
        if (!aEm()) {
          break label471;
        }
        ac.i("MicroMsg.FontResLogic", "unzipRes success");
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        ac.i("MicroMsg.FontResLogic", "unzip failed");
        this.hEb = false;
      }
      for (;;)
      {
        i.cU(hDW, true);
        AppMethodBeat.o(104516);
        break;
        ac.i("MicroMsg.FontResLogic", "unzip success");
        h.wUl.n(933L, 16L, 1L);
        com.tencent.mm.pluginsdk.h.a.a.b.eLH().aE(paramInt1, paramInt2, paramInt3);
      }
      AppMethodBeat.o(104516);
      break;
      label471:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aq.b
 * JD-Core Version:    0.7.0.1
 */