package com.tencent.mm.plugin.flash.c;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.aw;
import com.tencent.mm.g.b.a.ax;
import com.tencent.mm.g.b.a.ay;
import com.tencent.mm.g.b.a.az;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  private static ay wID = null;
  private static long wIE = 0L;
  private static az wIF = null;
  private static aw wIG = null;
  private static JSONArray wIH;
  private static String wII = "";
  
  public static void MW(int paramInt)
  {
    AppMethodBeat.i(186675);
    ay localay = dLi();
    localay.eqP = paramInt;
    if (wIH != null) {
      localay.iE(wIH.toString().replace(',', ';'));
    }
    localay.iD(wII);
    if (!TextUtils.isEmpty(wII)) {}
    try
    {
      String[] arrayOfString = wII.split("-");
      if (arrayOfString.length > 0) {
        localay.eqR = Integer.parseInt(arrayOfString[(arrayOfString.length - 1)]);
      }
      label84:
      wIE = wID.erc;
      localay.bfK();
      wID = null;
      wII = "";
      wIH = null;
      AppMethodBeat.o(186675);
      return;
    }
    catch (Exception localException)
    {
      break label84;
    }
  }
  
  public static void MX(int paramInt)
  {
    AppMethodBeat.i(186678);
    az localaz = dLj();
    localaz.eqP = paramInt;
    if (wIH != null) {
      localaz.iH(wIH.toString().replace(',', ';'));
    }
    localaz.iG(wII);
    if (!TextUtils.isEmpty(wII)) {}
    try
    {
      String[] arrayOfString = wII.split("-");
      if (arrayOfString.length > 0) {
        localaz.eqR = Integer.parseInt(arrayOfString[(arrayOfString.length - 1)]);
      }
      label84:
      localaz.bfK();
      wIF = null;
      wII = "";
      wIH = null;
      AppMethodBeat.o(186678);
      return;
    }
    catch (Exception localException)
    {
      break label84;
    }
  }
  
  public static void MY(int paramInt)
  {
    AppMethodBeat.i(186686);
    if (TextUtils.isEmpty(wII))
    {
      wII += String.valueOf(paramInt);
      AppMethodBeat.o(186686);
      return;
    }
    wII = wII + "-" + paramInt;
    AppMethodBeat.o(186686);
  }
  
  public static void au(Intent paramIntent)
  {
    AppMethodBeat.i(186680);
    if (paramIntent != null)
    {
      dLk().eqz = System.currentTimeMillis();
      aw localaw = dLk();
      localaw.eqA = localaw.x("functionName", paramIntent.getStringExtra("key_function_name"), true);
      int i = paramIntent.getIntExtra("key_business_type", -1);
      dLk().eqC = i;
      localaw = dLk();
      localaw.ekB = localaw.x("appId", paramIntent.getStringExtra("appId"), true);
      dLk().eqF = 1L;
      dLk().eqG = paramIntent.getLongExtra("confirm_page_timestamp", -1L);
      dLk().eqH = System.currentTimeMillis();
      dLk().eqK = paramIntent.getIntExtra("check_alive_type", -1);
    }
    AppMethodBeat.o(186680);
  }
  
  public static void axl(String paramString)
  {
    AppMethodBeat.i(186674);
    dLi().erk = System.currentTimeMillis();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      MW(localJSONObject.optInt("err_code", localJSONObject.optInt("errorcode", 0)));
      AppMethodBeat.o(186674);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", localJSONException, "parse face fail result error.%s", new Object[] { paramString });
      AppMethodBeat.o(186674);
    }
  }
  
  public static void axm(String paramString)
  {
    AppMethodBeat.i(186677);
    try
    {
      MX(new JSONObject(paramString).optInt("err_code", 0));
      AppMethodBeat.o(186677);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", localJSONException, "parse face fail result error.%s", new Object[] { paramString });
      AppMethodBeat.o(186677);
    }
  }
  
  public static void axn(String paramString)
  {
    AppMethodBeat.i(186682);
    s(paramString, Integer.valueOf(0));
    AppMethodBeat.o(186682);
  }
  
  public static void axo(String paramString)
  {
    AppMethodBeat.i(186684);
    if ((wIH != null) && (wIH.toString().contains(paramString)))
    {
      AppMethodBeat.o(186684);
      return;
    }
    axn(paramString);
    AppMethodBeat.o(186684);
  }
  
  public static void bq(int paramInt, String paramString)
  {
    AppMethodBeat.i(186688);
    ax localax = new ax();
    localax.eqL = 2;
    localax.eqM = 0;
    localax.eqN = paramInt;
    localax.iC(paramString);
    localax.bfK();
    AppMethodBeat.o(186688);
  }
  
  public static ay dLi()
  {
    AppMethodBeat.i(186673);
    if (wID == null)
    {
      localay = new ay();
      wID = localay;
      localay.erc = wIE;
    }
    ay localay = wID;
    AppMethodBeat.o(186673);
    return localay;
  }
  
  public static az dLj()
  {
    AppMethodBeat.i(186676);
    if (wIF == null) {
      wIF = new az();
    }
    az localaz = wIF;
    AppMethodBeat.o(186676);
    return localaz;
  }
  
  public static aw dLk()
  {
    AppMethodBeat.i(186679);
    if (wIG == null) {
      wIG = new aw();
    }
    aw localaw = wIG;
    AppMethodBeat.o(186679);
    return localaw;
  }
  
  public static void pr(boolean paramBoolean)
  {
    AppMethodBeat.i(186681);
    Log.i("MicroMsg.FaceFlashManagerReport", "doReport14560 success:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    aw localaw = dLk();
    if (paramBoolean) {}
    for (long l = 1L;; l = 0L)
    {
      localaw.eqD = l;
      dLk().eqE = (System.currentTimeMillis() - dLk().eqz);
      dLk().eqJ = System.currentTimeMillis();
      dLk().bfK();
      wIG = null;
      AppMethodBeat.o(186681);
      return;
    }
  }
  
  public static void s(String paramString, Object paramObject)
  {
    AppMethodBeat.i(186683);
    if (wIH == null) {
      wIH = new JSONArray();
    }
    Log.i("MicroMsg.FaceFlashManagerReport", "updateFaceFlashState key:%s value:%s", new Object[] { paramString, paramObject });
    JSONObject localJSONObject;
    if (x(wIH)) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put(paramString, paramObject);
      label67:
      wIH.put(localJSONObject);
      AppMethodBeat.o(186683);
      return;
    }
    catch (JSONException paramString)
    {
      break label67;
    }
  }
  
  private static boolean x(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(186685);
    if (paramJSONArray.toString().length() <= 1000)
    {
      AppMethodBeat.o(186685);
      return true;
    }
    AppMethodBeat.o(186685);
    return false;
  }
  
  public static void z(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(186687);
    ax localax = new ax();
    localax.eqL = 1;
    localax.eqM = paramInt1;
    localax.eqN = paramInt2;
    localax.iC(paramString);
    localax.bfK();
    AppMethodBeat.o(186687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.c.b
 * JD-Core Version:    0.7.0.1
 */