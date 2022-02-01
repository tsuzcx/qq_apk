package com.tencent.mm.at;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.g;
import com.tencent.mm.f.a.bu;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import org.json.JSONObject;

public class b
{
  public static final String lKJ;
  public static final String lKK;
  public static final String lKL;
  public static final String lKM;
  private static b lKN;
  private String lKO;
  private boolean lKP;
  public IListener<bu> lKQ;
  
  static
  {
    AppMethodBeat.i(104519);
    lKJ = com.tencent.mm.loader.j.b.aSE() + "fonts/";
    lKK = lKJ + "temp/";
    lKL = lKJ + "WXkatonglemiao.ttf";
    lKM = lKJ + "WXxiari.ttf";
    AppMethodBeat.o(104519);
  }
  
  public b()
  {
    AppMethodBeat.i(104512);
    this.lKO = "emoji_font_meta.json";
    this.lKP = false;
    this.lKQ = new b.1(this);
    AppMethodBeat.o(104512);
  }
  
  public static b bkO()
  {
    AppMethodBeat.i(104513);
    try
    {
      if (lKN == null) {
        lKN = new b();
      }
      b localb = lKN;
      AppMethodBeat.o(104513);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(104513);
    }
  }
  
  public static void bkQ()
  {
    AppMethodBeat.i(104514);
    com.tencent.mm.pluginsdk.k.a.a.b.hii();
    com.tencent.mm.pluginsdk.k.a.a.b.apP(57);
    AppMethodBeat.o(104514);
  }
  
  public static String[] bkS()
  {
    return new String[] { lKM, lKL };
  }
  
  private static boolean c(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(104517);
    String str1 = paramJSONObject.optString("name");
    paramJSONObject = paramJSONObject.optString("md5");
    String str2 = lKK + str1;
    String str3 = g.getMD5(str2);
    if ((Util.isNullOrNil(str3)) || (!str3.equalsIgnoreCase(paramJSONObject)))
    {
      Log.e("MicroMsg.FontResLogic", "download %s not match! %s %s", new Object[] { str1, str3, paramJSONObject });
      AppMethodBeat.o(104517);
      return false;
    }
    if (!paramString.equalsIgnoreCase(str2)) {
      u.oo(str2, paramString);
    }
    AppMethodBeat.o(104517);
    return true;
  }
  
  public final boolean bkP()
  {
    return this.lKP;
  }
  
  public final boolean bkR()
  {
    AppMethodBeat.i(104515);
    if ((u.agG(lKL)) && (u.agG(lKM))) {
      Log.i("MicroMsg.FontResLogic", "font file exist");
    }
    for (this.lKP = true;; this.lKP = false)
    {
      boolean bool = this.lKP;
      AppMethodBeat.o(104515);
      return bool;
    }
  }
  
  public final void g(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        AppMethodBeat.i(104516);
        Log.i("MicroMsg.FontResLogic", "unzipRes: %s", new Object[] { paramString });
        if (!u.agG(paramString)) {
          break;
        }
        u.bBD(lKK);
        int j = u.gj(paramString, lKK);
        Log.i("MicroMsg.FontResLogic", "unzip file ret: %s", new Object[] { Integer.valueOf(j) });
        if (j != 0) {
          break;
        }
      }
      finally {}
      try
      {
        if (!u.agG(lKK + this.lKO)) {
          break label471;
        }
        paramString = u.bBS(lKK + this.lKO);
        Log.i("MicroMsg.FontResLogic", "meta json: %s", new Object[] { paramString });
        localJSONObject = new JSONObject(paramString);
        paramString = localJSONObject.optJSONObject("WXkatonglemiao.ttf");
        localJSONObject = localJSONObject.optJSONObject("WXxiari.ttf");
        if ((paramString == null) || (localJSONObject == null)) {
          break label471;
        }
        if (c(paramString, lKL)) {
          continue;
        }
        h.IzE.p(933L, 13L, 1L);
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.FontResLogic", paramString, "unzipRes error: %s", new Object[] { paramString.getMessage() });
        h.IzE.p(933L, 15L, 1L);
        Log.i("MicroMsg.FontResLogic", "unzip failed");
        this.lKP = false;
        u.dK(lKK, true);
        AppMethodBeat.o(104516);
        continue;
      }
      finally
      {
        Log.i("MicroMsg.FontResLogic", "unzip failed");
        this.lKP = false;
        u.dK(lKK, true);
        AppMethodBeat.o(104516);
      }
      return;
      if (!c(localJSONObject, lKM))
      {
        h.IzE.p(933L, 14L, 1L);
        Log.i("MicroMsg.FontResLogic", "unzip failed");
        this.lKP = false;
        u.dK(lKK, true);
        AppMethodBeat.o(104516);
      }
      else
      {
        Log.i("MicroMsg.FontResLogic", "unzip res success");
        if (!bkR()) {
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
        this.lKP = false;
      }
      for (;;)
      {
        u.dK(lKK, true);
        AppMethodBeat.o(104516);
        break;
        Log.i("MicroMsg.FontResLogic", "unzip success");
        h.IzE.p(933L, 16L, 1L);
        com.tencent.mm.pluginsdk.k.a.a.b.hii().aT(paramInt1, paramInt2, paramInt3);
      }
      AppMethodBeat.o(104516);
      break;
      label471:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.at.b
 * JD-Core Version:    0.7.0.1
 */