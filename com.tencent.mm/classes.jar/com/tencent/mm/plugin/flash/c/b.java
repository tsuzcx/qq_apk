package com.tencent.mm.plugin.flash.c;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.cc;
import com.tencent.mm.autogen.mmdata.rpt.cd;
import com.tencent.mm.autogen.mmdata.rpt.ce;
import com.tencent.mm.autogen.mmdata.rpt.cf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  private static cc HjA = null;
  private static JSONArray HjB;
  private static JSONArray HjC;
  private static String HjD = "";
  private static ce Hjx = null;
  private static long Hjy = 0L;
  private static cf Hjz = null;
  
  private static boolean A(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(264890);
    if (paramJSONArray.toString().length() <= 1000)
    {
      AppMethodBeat.o(264890);
      return true;
    }
    AppMethodBeat.o(264890);
    return false;
  }
  
  public static void F(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(264897);
    cd localcd = new cd();
    localcd.ivj = 1;
    localcd.ivk = paramInt1;
    localcd.inj = paramInt2;
    localcd.lr(paramString);
    localcd.bMH();
    AppMethodBeat.o(264897);
  }
  
  /* Error */
  public static void F(String paramString, Object paramObject)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 86
    //   5: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 88	com/tencent/mm/plugin/flash/c/b:HjC	Lorg/json/JSONArray;
    //   11: ifnonnull +13 -> 24
    //   14: new 43	org/json/JSONArray
    //   17: dup
    //   18: invokespecial 89	org/json/JSONArray:<init>	()V
    //   21: putstatic 88	com/tencent/mm/plugin/flash/c/b:HjC	Lorg/json/JSONArray;
    //   24: ldc 91
    //   26: ldc 93
    //   28: iconst_2
    //   29: anewarray 4	java/lang/Object
    //   32: dup
    //   33: iconst_0
    //   34: aload_0
    //   35: aastore
    //   36: dup
    //   37: iconst_1
    //   38: aload_1
    //   39: aastore
    //   40: invokestatic 98	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: getstatic 88	com/tencent/mm/plugin/flash/c/b:HjC	Lorg/json/JSONArray;
    //   46: invokestatic 100	com/tencent/mm/plugin/flash/c/b:A	(Lorg/json/JSONArray;)Z
    //   49: ifeq +26 -> 75
    //   52: new 102	org/json/JSONObject
    //   55: dup
    //   56: invokespecial 103	org/json/JSONObject:<init>	()V
    //   59: astore_2
    //   60: aload_2
    //   61: aload_0
    //   62: aload_1
    //   63: invokevirtual 107	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   66: pop
    //   67: getstatic 88	com/tencent/mm/plugin/flash/c/b:HjC	Lorg/json/JSONArray;
    //   70: aload_2
    //   71: invokevirtual 110	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   74: pop
    //   75: ldc 86
    //   77: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: ldc 2
    //   82: monitorexit
    //   83: return
    //   84: astore_0
    //   85: goto -18 -> 67
    //   88: astore_0
    //   89: ldc 2
    //   91: monitorexit
    //   92: aload_0
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	paramString	String
    //   0	94	1	paramObject	Object
    //   59	12	2	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   60	67	84	org/json/JSONException
    //   3	24	88	finally
    //   24	60	88	finally
    //   60	67	88	finally
    //   67	75	88	finally
    //   75	80	88	finally
  }
  
  public static void VL(int paramInt)
  {
    AppMethodBeat.i(264820);
    ce localce = fuO();
    localce.ivm = paramInt;
    if (HjC != null) {
      localce.lt(HjC.toString().replace(',', ';'));
    }
    if (HjB != null) {
      localce.lw(HjB.toString().replace(',', ';'));
    }
    localce.ls(HjD);
    if (!TextUtils.isEmpty(HjD)) {}
    try
    {
      String[] arrayOfString = HjD.split("-");
      if (arrayOfString.length > 0) {
        localce.ivo = Integer.parseInt(arrayOfString[(arrayOfString.length - 1)]);
      }
      label108:
      Hjy = Hjx.ivz;
      localce.bMH();
      Hjx = null;
      HjD = "";
      HjC = null;
      HjB = null;
      AppMethodBeat.o(264820);
      return;
    }
    catch (Exception localException)
    {
      break label108;
    }
  }
  
  public static void VM(int paramInt)
  {
    AppMethodBeat.i(264847);
    cf localcf = fuP();
    localcf.ivm = paramInt;
    if (HjC != null) {
      localcf.ly(HjC.toString().replace(',', ';'));
    }
    localcf.lx(HjD);
    if (!TextUtils.isEmpty(HjD)) {}
    try
    {
      String[] arrayOfString = HjD.split("-");
      if (arrayOfString.length > 0) {
        localcf.ivo = Integer.parseInt(arrayOfString[(arrayOfString.length - 1)]);
      }
      label84:
      localcf.bMH();
      Hjz = null;
      HjD = "";
      HjC = null;
      AppMethodBeat.o(264847);
      return;
    }
    catch (Exception localException)
    {
      break label84;
    }
  }
  
  public static void VN(int paramInt)
  {
    AppMethodBeat.i(264894);
    if (TextUtils.isEmpty(HjD))
    {
      HjD += String.valueOf(paramInt);
      AppMethodBeat.o(264894);
      return;
    }
    HjD = HjD + "-" + paramInt;
    AppMethodBeat.o(264894);
  }
  
  public static void aDA(String paramString)
  {
    AppMethodBeat.i(264877);
    F(paramString, Integer.valueOf(0));
    AppMethodBeat.o(264877);
  }
  
  public static void aDB(String paramString)
  {
    AppMethodBeat.i(264886);
    if ((HjC != null) && (HjC.toString().contains(paramString)))
    {
      AppMethodBeat.o(264886);
      return;
    }
    aDA(paramString);
    AppMethodBeat.o(264886);
  }
  
  public static void aDz(String paramString)
  {
    AppMethodBeat.i(264807);
    fuO().ivH = System.currentTimeMillis();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      VL(localJSONObject.optInt("err_code", localJSONObject.optInt("errorcode", 0)));
      AppMethodBeat.o(264807);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", localJSONException, "parse face fail result error.%s", new Object[] { paramString });
      AppMethodBeat.o(264807);
    }
  }
  
  public static void aS(Intent paramIntent)
  {
    AppMethodBeat.i(264858);
    if (paramIntent != null)
    {
      fuQ().iuX = System.currentTimeMillis();
      cc localcc = fuQ();
      localcc.iuY = localcc.F("functionName", paramIntent.getStringExtra("key_function_name"), true);
      int i = paramIntent.getIntExtra("key_business_type", -1);
      fuQ().iva = i;
      localcc = fuQ();
      localcc.ilF = localcc.F("appId", paramIntent.getStringExtra("appId"), true);
      fuQ().ivd = 1L;
      fuQ().ive = paramIntent.getLongExtra("confirm_page_timestamp", -1L);
      fuQ().ivf = System.currentTimeMillis();
      fuQ().ivi = paramIntent.getIntExtra("check_alive_type", -1);
    }
    AppMethodBeat.o(264858);
  }
  
  public static void bW(int paramInt, String paramString)
  {
    AppMethodBeat.i(264900);
    cd localcd = new cd();
    localcd.ivj = 2;
    localcd.ivk = 0;
    localcd.inj = paramInt;
    localcd.lr(paramString);
    localcd.bMH();
    AppMethodBeat.o(264900);
  }
  
  public static void fh(String paramString, int paramInt)
  {
    AppMethodBeat.i(264840);
    try
    {
      VM(new JSONObject(paramString).optInt("errorcode", paramInt));
      AppMethodBeat.o(264840);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", localJSONException, "parse face fail result error.%s", new Object[] { paramString });
      AppMethodBeat.o(264840);
    }
  }
  
  public static ce fuO()
  {
    AppMethodBeat.i(264793);
    ce localce;
    if (Hjx == null)
    {
      localce = new ce();
      Hjx = localce;
      localce.ivz = Hjy;
      if (!aw.jkP()) {
        break label58;
      }
    }
    label58:
    for (int i = 2;; i = 1)
    {
      Hjx.ivL = i;
      localce = Hjx;
      AppMethodBeat.o(264793);
      return localce;
    }
  }
  
  public static cf fuP()
  {
    AppMethodBeat.i(264831);
    if (Hjz == null) {
      Hjz = new cf();
    }
    cf localcf = Hjz;
    AppMethodBeat.o(264831);
    return localcf;
  }
  
  public static cc fuQ()
  {
    AppMethodBeat.i(264851);
    if (HjA == null) {
      HjA = new cc();
    }
    cc localcc = HjA;
    AppMethodBeat.o(264851);
    return localcc;
  }
  
  public static void q(HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(264871);
    if (HjB == null) {
      HjB = new JSONArray();
    }
    if ((A(HjB)) && (paramHashMap != null) && (paramHashMap.size() > 0))
    {
      paramHashMap = new JSONObject(paramHashMap);
      Log.i("MicroMsg.FaceFlashManagerReport", "updateFaceSdkState:%s", new Object[] { paramHashMap });
      if (HjB.length() >= 5)
      {
        HjB.remove(0);
        HjB.put(paramHashMap);
      }
    }
    AppMethodBeat.o(264871);
  }
  
  public static void vC(boolean paramBoolean)
  {
    AppMethodBeat.i(264865);
    Log.i("MicroMsg.FaceFlashManagerReport", "doReport14560 success:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    cc localcc = fuQ();
    if (paramBoolean) {}
    for (long l = 1L;; l = 0L)
    {
      localcc.ivb = l;
      fuQ().ivc = (System.currentTimeMillis() - fuQ().iuX);
      fuQ().ivh = System.currentTimeMillis();
      fuQ().bMH();
      HjA = null;
      AppMethodBeat.o(264865);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.c.b
 * JD-Core Version:    0.7.0.1
 */