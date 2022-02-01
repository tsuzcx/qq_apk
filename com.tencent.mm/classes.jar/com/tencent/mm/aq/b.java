package com.tencent.mm.aq;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.g;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.g.a.bp.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import org.json.JSONObject;

public class b
{
  public static final String iUq;
  public static final String iUr;
  public static final String iUs;
  public static final String iUt;
  private static b iUu;
  private String iUv;
  private boolean iUw;
  public IListener<bp> iUx;
  
  static
  {
    AppMethodBeat.i(104519);
    iUq = com.tencent.mm.loader.j.b.aKC() + "fonts/";
    iUr = iUq + "temp/";
    iUs = iUq + "WXkatonglemiao.ttf";
    iUt = iUq + "WXxiari.ttf";
    AppMethodBeat.o(104519);
  }
  
  public b()
  {
    AppMethodBeat.i(104512);
    this.iUv = "emoji_font_meta.json";
    this.iUw = false;
    this.iUx = new IListener() {};
    AppMethodBeat.o(104512);
  }
  
  private static boolean b(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(104517);
    String str1 = paramJSONObject.optString("name");
    paramJSONObject = paramJSONObject.optString("md5");
    String str2 = iUr + str1;
    String str3 = g.getMD5(str2);
    if ((Util.isNullOrNil(str3)) || (!str3.equalsIgnoreCase(paramJSONObject)))
    {
      Log.e("MicroMsg.FontResLogic", "download %s not match! %s %s", new Object[] { str1, str3, paramJSONObject });
      AppMethodBeat.o(104517);
      return false;
    }
    if (!paramString.equalsIgnoreCase(str2)) {
      s.nx(str2, paramString);
    }
    AppMethodBeat.o(104517);
    return true;
  }
  
  public static void bbA()
  {
    AppMethodBeat.i(104514);
    com.tencent.mm.pluginsdk.j.a.a.b.gnC();
    com.tencent.mm.pluginsdk.j.a.a.b.ahP(57);
    AppMethodBeat.o(104514);
  }
  
  public static String[] bbC()
  {
    return new String[] { iUt, iUs };
  }
  
  public static b bby()
  {
    AppMethodBeat.i(104513);
    try
    {
      if (iUu == null) {
        iUu = new b();
      }
      b localb = iUu;
      AppMethodBeat.o(104513);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(104513);
    }
  }
  
  public final boolean bbB()
  {
    AppMethodBeat.i(104515);
    if ((s.YS(iUs)) && (s.YS(iUt))) {
      Log.i("MicroMsg.FontResLogic", "font file exist");
    }
    for (this.iUw = true;; this.iUw = false)
    {
      boolean bool = this.iUw;
      AppMethodBeat.o(104515);
      return bool;
    }
  }
  
  public final boolean bbz()
  {
    return this.iUw;
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
        Log.i("MicroMsg.FontResLogic", "unzipRes: %s", new Object[] { paramString });
        if (!s.YS(paramString)) {
          break;
        }
        s.boN(iUr);
        int j = s.fW(paramString, iUr);
        Log.i("MicroMsg.FontResLogic", "unzip file ret: %s", new Object[] { Integer.valueOf(j) });
        if (j != 0) {
          break;
        }
      }
      finally {}
      try
      {
        if (!s.YS(iUr + this.iUv)) {
          break label471;
        }
        paramString = s.boY(iUr + this.iUv);
        Log.i("MicroMsg.FontResLogic", "meta json: %s", new Object[] { paramString });
        localJSONObject = new JSONObject(paramString);
        paramString = localJSONObject.optJSONObject("WXkatonglemiao.ttf");
        localJSONObject = localJSONObject.optJSONObject("WXxiari.ttf");
        if ((paramString == null) || (localJSONObject == null)) {
          break label471;
        }
        if (b(paramString, iUs)) {
          continue;
        }
        h.CyF.n(933L, 13L, 1L);
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.FontResLogic", paramString, "unzipRes error: %s", new Object[] { paramString.getMessage() });
        h.CyF.n(933L, 15L, 1L);
        Log.i("MicroMsg.FontResLogic", "unzip failed");
        this.iUw = false;
        s.dy(iUr, true);
        AppMethodBeat.o(104516);
        continue;
      }
      finally
      {
        Log.i("MicroMsg.FontResLogic", "unzip failed");
        this.iUw = false;
        s.dy(iUr, true);
        AppMethodBeat.o(104516);
      }
      return;
      if (!b(localJSONObject, iUt))
      {
        h.CyF.n(933L, 14L, 1L);
        Log.i("MicroMsg.FontResLogic", "unzip failed");
        this.iUw = false;
        s.dy(iUr, true);
        AppMethodBeat.o(104516);
      }
      else
      {
        Log.i("MicroMsg.FontResLogic", "unzip res success");
        if (!bbB()) {
          break label471;
        }
        Log.i("MicroMsg.FontResLogic", "unzipRes success");
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        Log.i("MicroMsg.FontResLogic", "unzip failed");
        this.iUw = false;
      }
      for (;;)
      {
        s.dy(iUr, true);
        AppMethodBeat.o(104516);
        break;
        Log.i("MicroMsg.FontResLogic", "unzip success");
        h.CyF.n(933L, 16L, 1L);
        com.tencent.mm.pluginsdk.j.a.a.b.gnC().aP(paramInt1, paramInt2, paramInt3);
      }
      AppMethodBeat.o(104516);
      break;
      label471:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aq.b
 * JD-Core Version:    0.7.0.1
 */