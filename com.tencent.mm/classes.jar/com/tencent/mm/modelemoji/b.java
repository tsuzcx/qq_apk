package com.tencent.mm.modelemoji;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.cd;
import com.tencent.mm.d.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import org.json.JSONObject;

public class b
{
  public static final String oDl;
  public static final String oDm;
  public static final String oDn;
  public static final String oDo;
  private static b oDp;
  private String oDq;
  public boolean oDr;
  public IListener<cd> oDs;
  
  static
  {
    AppMethodBeat.i(104519);
    oDl = com.tencent.mm.loader.i.b.bms() + "fonts/";
    oDm = oDl + "temp/";
    oDn = oDl + "WXkatonglemiao.ttf";
    oDo = oDl + "WXxiari.ttf";
    AppMethodBeat.o(104519);
  }
  
  public b()
  {
    AppMethodBeat.i(104512);
    this.oDq = "emoji_font_meta.json";
    this.oDr = false;
    this.oDs = new FontResLogic.1(this, f.hfK);
    AppMethodBeat.o(104512);
  }
  
  public static b bII()
  {
    AppMethodBeat.i(104513);
    try
    {
      if (oDp == null) {
        oDp = new b();
      }
      b localb = oDp;
      AppMethodBeat.o(104513);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(104513);
    }
  }
  
  public static void bIJ()
  {
    AppMethodBeat.i(104514);
    com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
    com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.avS(57);
    AppMethodBeat.o(104514);
  }
  
  public static String[] bIL()
  {
    return new String[] { oDo, oDn };
  }
  
  private static boolean c(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(104517);
    String str1 = paramJSONObject.optString("name");
    paramJSONObject = paramJSONObject.optString("md5");
    String str2 = oDm + str1;
    String str3 = g.getMD5(str2);
    if ((Util.isNullOrNil(str3)) || (!str3.equalsIgnoreCase(paramJSONObject)))
    {
      Log.e("MicroMsg.FontResLogic", "download %s not match! %s %s", new Object[] { str1, str3, paramJSONObject });
      AppMethodBeat.o(104517);
      return false;
    }
    if (!paramString.equalsIgnoreCase(str2)) {
      y.qn(str2, paramString);
    }
    AppMethodBeat.o(104517);
    return true;
  }
  
  public final boolean bIK()
  {
    AppMethodBeat.i(104515);
    if ((y.ZC(oDn)) && (y.ZC(oDo))) {
      Log.i("MicroMsg.FontResLogic", "font file exist");
    }
    for (this.oDr = true;; this.oDr = false)
    {
      boolean bool = this.oDr;
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
        if (!y.ZC(paramString)) {
          break;
        }
        y.bDX(oDm);
        int j = y.aA(paramString, oDm);
        Log.i("MicroMsg.FontResLogic", "unzip file ret: %s", new Object[] { Integer.valueOf(j) });
        if (j != 0) {
          break;
        }
      }
      finally {}
      try
      {
        if (!y.ZC(oDm + this.oDq)) {
          break label471;
        }
        paramString = y.bEn(oDm + this.oDq);
        Log.i("MicroMsg.FontResLogic", "meta json: %s", new Object[] { paramString });
        localJSONObject = new JSONObject(paramString);
        paramString = localJSONObject.optJSONObject("WXkatonglemiao.ttf");
        localJSONObject = localJSONObject.optJSONObject("WXxiari.ttf");
        if ((paramString == null) || (localJSONObject == null)) {
          break label471;
        }
        if (c(paramString, oDn)) {
          continue;
        }
        h.OAn.p(933L, 13L, 1L);
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.FontResLogic", paramString, "unzipRes error: %s", new Object[] { paramString.getMessage() });
        h.OAn.p(933L, 15L, 1L);
        Log.i("MicroMsg.FontResLogic", "unzip failed");
        this.oDr = false;
        y.ew(oDm, true);
        AppMethodBeat.o(104516);
        continue;
      }
      finally
      {
        Log.i("MicroMsg.FontResLogic", "unzip failed");
        this.oDr = false;
        y.ew(oDm, true);
        AppMethodBeat.o(104516);
      }
      return;
      if (!c(localJSONObject, oDo))
      {
        h.OAn.p(933L, 14L, 1L);
        Log.i("MicroMsg.FontResLogic", "unzip failed");
        this.oDr = false;
        y.ew(oDm, true);
        AppMethodBeat.o(104516);
      }
      else
      {
        Log.i("MicroMsg.FontResLogic", "unzip res success");
        if (!bIK()) {
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
        this.oDr = false;
      }
      for (;;)
      {
        y.ew(oDm, true);
        AppMethodBeat.o(104516);
        break;
        Log.i("MicroMsg.FontResLogic", "unzip success");
        h.OAn.p(933L, 16L, 1L);
        com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf().bu(paramInt1, paramInt2, paramInt3);
      }
      AppMethodBeat.o(104516);
      break;
      label471:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelemoji.b
 * JD-Core Version:    0.7.0.1
 */