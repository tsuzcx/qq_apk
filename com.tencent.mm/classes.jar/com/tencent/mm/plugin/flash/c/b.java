package com.tencent.mm.plugin.flash.c;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.bg;
import com.tencent.mm.f.b.a.bh;
import com.tencent.mm.f.b.a.bi;
import com.tencent.mm.f.b.a.bj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  private static bi BBQ = null;
  private static long BBR = 0L;
  private static bj BBS = null;
  private static bg BBT = null;
  private static JSONArray BBU;
  private static JSONArray BBV;
  private static String BBW = "";
  
  public static void B(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(192819);
    bh localbh = new bh();
    localbh.gmf = 1;
    localbh.gmg = paramInt1;
    localbh.ggm = paramInt2;
    localbh.jJ(paramString);
    localbh.bpa();
    AppMethodBeat.o(192819);
  }
  
  public static void Ss(int paramInt)
  {
    AppMethodBeat.i(192753);
    bi localbi = epM();
    localbi.gmi = paramInt;
    if (BBV != null) {
      localbi.jL(BBV.toString().replace(',', ';'));
    }
    if (BBU != null) {
      localbi.jO(BBU.toString().replace(',', ';'));
    }
    localbi.jK(BBW);
    if (!TextUtils.isEmpty(BBW)) {}
    try
    {
      String[] arrayOfString = BBW.split("-");
      if (arrayOfString.length > 0) {
        localbi.gmk = Integer.parseInt(arrayOfString[(arrayOfString.length - 1)]);
      }
      label108:
      BBR = BBQ.gmv;
      localbi.bpa();
      BBQ = null;
      BBW = "";
      BBV = null;
      BBU = null;
      AppMethodBeat.o(192753);
      return;
    }
    catch (Exception localException)
    {
      break label108;
    }
  }
  
  public static void St(int paramInt)
  {
    AppMethodBeat.i(192763);
    bj localbj = epN();
    localbj.gmi = paramInt;
    if (BBV != null) {
      localbj.jQ(BBV.toString().replace(',', ';'));
    }
    localbj.jP(BBW);
    if (!TextUtils.isEmpty(BBW)) {}
    try
    {
      String[] arrayOfString = BBW.split("-");
      if (arrayOfString.length > 0) {
        localbj.gmk = Integer.parseInt(arrayOfString[(arrayOfString.length - 1)]);
      }
      label84:
      localbj.bpa();
      BBS = null;
      BBW = "";
      BBV = null;
      AppMethodBeat.o(192763);
      return;
    }
    catch (Exception localException)
    {
      break label84;
    }
  }
  
  public static void Su(int paramInt)
  {
    AppMethodBeat.i(192813);
    if (TextUtils.isEmpty(BBW))
    {
      BBW += String.valueOf(paramInt);
      AppMethodBeat.o(192813);
      return;
    }
    BBW = BBW + "-" + paramInt;
    AppMethodBeat.o(192813);
  }
  
  public static void aHh(String paramString)
  {
    AppMethodBeat.i(192747);
    epM().gmD = System.currentTimeMillis();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      Ss(localJSONObject.optInt("err_code", localJSONObject.optInt("errorcode", 0)));
      AppMethodBeat.o(192747);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", localJSONException, "parse face fail result error.%s", new Object[] { paramString });
      AppMethodBeat.o(192747);
    }
  }
  
  public static void aHi(String paramString)
  {
    AppMethodBeat.i(192793);
    s(paramString, Integer.valueOf(0));
    AppMethodBeat.o(192793);
  }
  
  public static void aHj(String paramString)
  {
    AppMethodBeat.i(192806);
    if ((BBV != null) && (BBV.toString().contains(paramString)))
    {
      AppMethodBeat.o(192806);
      return;
    }
    aHi(paramString);
    AppMethodBeat.o(192806);
  }
  
  public static void az(Intent paramIntent)
  {
    AppMethodBeat.i(192775);
    if (paramIntent != null)
    {
      epO().glT = System.currentTimeMillis();
      bg localbg = epO();
      localbg.glU = localbg.z("functionName", paramIntent.getStringExtra("key_function_name"), true);
      int i = paramIntent.getIntExtra("key_business_type", -1);
      epO().glW = i;
      localbg = epO();
      localbg.gfg = localbg.z("appId", paramIntent.getStringExtra("appId"), true);
      epO().glZ = 1L;
      epO().gma = paramIntent.getLongExtra("confirm_page_timestamp", -1L);
      epO().gmb = System.currentTimeMillis();
      epO().gme = paramIntent.getIntExtra("check_alive_type", -1);
    }
    AppMethodBeat.o(192775);
  }
  
  public static void bs(int paramInt, String paramString)
  {
    AppMethodBeat.i(192826);
    bh localbh = new bh();
    localbh.gmf = 2;
    localbh.gmg = 0;
    localbh.ggm = paramInt;
    localbh.jJ(paramString);
    localbh.bpa();
    AppMethodBeat.o(192826);
  }
  
  public static bi epM()
  {
    AppMethodBeat.i(192741);
    bi localbi;
    if (BBQ == null)
    {
      localbi = new bi();
      BBQ = localbi;
      localbi.gmv = BBR;
      if (!ar.hIE()) {
        break label58;
      }
    }
    label58:
    for (int i = 2;; i = 1)
    {
      BBQ.gmI = i;
      localbi = BBQ;
      AppMethodBeat.o(192741);
      return localbi;
    }
  }
  
  public static bj epN()
  {
    AppMethodBeat.i(192755);
    if (BBS == null) {
      BBS = new bj();
    }
    bj localbj = BBS;
    AppMethodBeat.o(192755);
    return localbj;
  }
  
  public static bg epO()
  {
    AppMethodBeat.i(192766);
    if (BBT == null) {
      BBT = new bg();
    }
    bg localbg = BBT;
    AppMethodBeat.o(192766);
    return localbg;
  }
  
  public static void es(String paramString, int paramInt)
  {
    AppMethodBeat.i(192758);
    try
    {
      St(new JSONObject(paramString).optInt("errorcode", paramInt));
      AppMethodBeat.o(192758);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", localJSONException, "parse face fail result error.%s", new Object[] { paramString });
      AppMethodBeat.o(192758);
    }
  }
  
  public static void n(HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(192790);
    if (BBU == null) {
      BBU = new JSONArray();
    }
    if ((x(BBU)) && (paramHashMap != null) && (paramHashMap.size() > 0))
    {
      paramHashMap = new JSONObject(paramHashMap);
      Log.i("MicroMsg.FaceFlashManagerReport", "updateFaceSdkState:%s", new Object[] { paramHashMap });
      if (BBU.length() >= 5)
      {
        BBU.remove(0);
        BBU.put(paramHashMap);
      }
    }
    AppMethodBeat.o(192790);
  }
  
  public static void rL(boolean paramBoolean)
  {
    AppMethodBeat.i(192782);
    Log.i("MicroMsg.FaceFlashManagerReport", "doReport14560 success:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    bg localbg = epO();
    if (paramBoolean) {}
    for (long l = 1L;; l = 0L)
    {
      localbg.glX = l;
      epO().glY = (System.currentTimeMillis() - epO().glT);
      epO().gmd = System.currentTimeMillis();
      epO().bpa();
      BBT = null;
      AppMethodBeat.o(192782);
      return;
    }
  }
  
  /* Error */
  public static void s(String paramString, Object paramObject)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 364
    //   6: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 82	com/tencent/mm/plugin/flash/c/b:BBV	Lorg/json/JSONArray;
    //   12: ifnonnull +13 -> 25
    //   15: new 84	org/json/JSONArray
    //   18: dup
    //   19: invokespecial 310	org/json/JSONArray:<init>	()V
    //   22: putstatic 82	com/tencent/mm/plugin/flash/c/b:BBV	Lorg/json/JSONArray;
    //   25: ldc_w 325
    //   28: ldc_w 366
    //   31: iconst_2
    //   32: anewarray 4	java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: aload_0
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: aload_1
    //   42: aastore
    //   43: invokestatic 330	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   46: getstatic 82	com/tencent/mm/plugin/flash/c/b:BBV	Lorg/json/JSONArray;
    //   49: invokestatic 314	com/tencent/mm/plugin/flash/c/b:x	(Lorg/json/JSONArray;)Z
    //   52: ifeq +26 -> 78
    //   55: new 182	org/json/JSONObject
    //   58: dup
    //   59: invokespecial 367	org/json/JSONObject:<init>	()V
    //   62: astore_2
    //   63: aload_2
    //   64: aload_0
    //   65: aload_1
    //   66: invokevirtual 370	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   69: pop
    //   70: getstatic 82	com/tencent/mm/plugin/flash/c/b:BBV	Lorg/json/JSONArray;
    //   73: aload_2
    //   74: invokevirtual 341	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   77: pop
    //   78: ldc_w 364
    //   81: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: ldc 2
    //   86: monitorexit
    //   87: return
    //   88: astore_0
    //   89: goto -19 -> 70
    //   92: astore_0
    //   93: ldc 2
    //   95: monitorexit
    //   96: aload_0
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	paramString	String
    //   0	98	1	paramObject	Object
    //   62	12	2	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   63	70	88	org/json/JSONException
    //   3	25	92	finally
    //   25	63	92	finally
    //   63	70	92	finally
    //   70	78	92	finally
    //   78	84	92	finally
  }
  
  private static boolean x(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(192808);
    if (paramJSONArray.toString().length() <= 1000)
    {
      AppMethodBeat.o(192808);
      return true;
    }
    AppMethodBeat.o(192808);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.c.b
 * JD-Core Version:    0.7.0.1
 */