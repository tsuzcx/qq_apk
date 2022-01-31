package com.tencent.mm.ao;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.c.g;
import com.tencent.mm.g.a.bg;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.g.a.a.b.c;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public class b
{
  public static final String fAS;
  public static final String fAT;
  public static final String fAU;
  public static final String fAV;
  private static b fAW;
  private String fAX;
  public boolean fAY;
  public c<bg> fAZ;
  
  static
  {
    AppMethodBeat.i(62293);
    fAS = com.tencent.mm.compatible.util.e.eQw + "fonts/";
    fAT = fAS + "temp/";
    fAU = fAS + "WXkatonglemiao.ttf";
    fAV = fAS + "WXxiari.ttf";
    AppMethodBeat.o(62293);
  }
  
  public b()
  {
    AppMethodBeat.i(62285);
    this.fAX = "emoji_font_meta.json";
    this.fAY = false;
    this.fAZ = new b.1(this);
    AppMethodBeat.o(62285);
  }
  
  public static b agp()
  {
    AppMethodBeat.i(62286);
    try
    {
      if (fAW == null) {
        fAW = new b();
      }
      b localb = fAW;
      AppMethodBeat.o(62286);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(62286);
    }
  }
  
  public static void agr()
  {
    AppMethodBeat.i(62287);
    b.c.dmg();
    com.tencent.mm.pluginsdk.g.a.a.b.LE(57);
    AppMethodBeat.o(62287);
  }
  
  public static String[] agt()
  {
    return new String[] { fAV, fAU };
  }
  
  private static boolean b(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(62290);
    String str1 = paramJSONObject.optString("name");
    paramJSONObject = paramJSONObject.optString("md5");
    String str2 = fAT + str1;
    String str3 = g.getMD5(str2);
    if ((bo.isNullOrNil(str3)) || (!str3.equalsIgnoreCase(paramJSONObject)))
    {
      ab.e("MicroMsg.FontResLogic", "download %s not match! %s %s", new Object[] { str1, str3, paramJSONObject });
      AppMethodBeat.o(62290);
      return false;
    }
    if (!paramString.equalsIgnoreCase(str2)) {
      com.tencent.mm.vfs.e.aT(str2, paramString);
    }
    AppMethodBeat.o(62290);
    return true;
  }
  
  public final boolean agq()
  {
    return this.fAY;
  }
  
  public final boolean ags()
  {
    AppMethodBeat.i(62288);
    if ((com.tencent.mm.vfs.e.cN(fAU)) && (com.tencent.mm.vfs.e.cN(fAV))) {
      ab.i("MicroMsg.FontResLogic", "font file exist");
    }
    for (this.fAY = true;; this.fAY = false)
    {
      boolean bool = this.fAY;
      AppMethodBeat.o(62288);
      return bool;
    }
  }
  
  public final void e(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        AppMethodBeat.i(62289);
        ab.i("MicroMsg.FontResLogic", "unzipRes: %s", new Object[] { paramString });
        if (!com.tencent.mm.vfs.e.cN(paramString)) {
          break;
        }
        com.tencent.mm.vfs.e.um(fAT);
        int j = com.tencent.mm.vfs.e.iH(paramString, fAT);
        ab.i("MicroMsg.FontResLogic", "unzip file ret: %s", new Object[] { Integer.valueOf(j) });
        if (j != 0) {
          break;
        }
      }
      finally {}
      try
      {
        if (!com.tencent.mm.vfs.e.cN(fAT + this.fAX)) {
          break label471;
        }
        paramString = com.tencent.mm.vfs.e.cS(fAT + this.fAX);
        ab.i("MicroMsg.FontResLogic", "meta json: %s", new Object[] { paramString });
        localJSONObject = new JSONObject(paramString);
        paramString = localJSONObject.optJSONObject("WXkatonglemiao.ttf");
        localJSONObject = localJSONObject.optJSONObject("WXxiari.ttf");
        if ((paramString == null) || (localJSONObject == null)) {
          break label471;
        }
        if (b(paramString, fAU)) {
          continue;
        }
        h.qsU.j(933L, 13L, 1L);
      }
      catch (Exception paramString)
      {
        ab.printErrStackTrace("MicroMsg.FontResLogic", paramString, "unzipRes error: %s", new Object[] { paramString.getMessage() });
        h.qsU.j(933L, 15L, 1L);
        ab.i("MicroMsg.FontResLogic", "unzip failed");
        this.fAY = false;
        com.tencent.mm.vfs.e.O(fAT, true);
        AppMethodBeat.o(62289);
        continue;
      }
      finally
      {
        ab.i("MicroMsg.FontResLogic", "unzip failed");
        this.fAY = false;
        com.tencent.mm.vfs.e.O(fAT, true);
        AppMethodBeat.o(62289);
      }
      return;
      if (!b(localJSONObject, fAV))
      {
        h.qsU.j(933L, 14L, 1L);
        ab.i("MicroMsg.FontResLogic", "unzip failed");
        this.fAY = false;
        com.tencent.mm.vfs.e.O(fAT, true);
        AppMethodBeat.o(62289);
      }
      else
      {
        ab.i("MicroMsg.FontResLogic", "unzip res success");
        if (!ags()) {
          break label471;
        }
        ab.i("MicroMsg.FontResLogic", "unzipRes success");
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        ab.i("MicroMsg.FontResLogic", "unzip failed");
        this.fAY = false;
      }
      for (;;)
      {
        com.tencent.mm.vfs.e.O(fAT, true);
        AppMethodBeat.o(62289);
        break;
        ab.i("MicroMsg.FontResLogic", "unzip success");
        h.qsU.j(933L, 16L, 1L);
        b.c.dmg().as(paramInt1, paramInt2, paramInt3);
      }
      AppMethodBeat.o(62289);
      break;
      label471:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ao.b
 * JD-Core Version:    0.7.0.1
 */