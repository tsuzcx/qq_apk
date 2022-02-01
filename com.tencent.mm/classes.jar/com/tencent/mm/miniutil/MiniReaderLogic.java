package com.tencent.mm.miniutil;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.comm.c.d;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.aw;
import com.tencent.mm.xwebutil.a;
import com.tencent.xweb.h.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class MiniReaderLogic
{
  private static String a(Activity paramActivity, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, String paramString2, boolean paramBoolean6)
  {
    AppMethodBeat.i(231714);
    Context localContext = MMApplicationContext.getContext();
    String str = "";
    Object localObject;
    JSONObject localJSONObject2;
    for (;;)
    {
      try
      {
        localJSONObject1 = new JSONObject();
        localJSONObject1.put("pkgName", localContext.getPackageName());
        if (!paramBoolean5) {
          continue;
        }
        localJSONObject1.put("className", "com.tencent.mm.ui.tools.MiniQbCallBackMMUI");
        localObject = new JSONObject();
        ((JSONObject)localObject).put("type", "miniqb");
        ((JSONObject)localObject).put("filePath", paramString1);
        ((JSONObject)localObject).put("processName", MMApplicationContext.getProcessName());
        ((JSONObject)localObject).put("appid", paramString2);
        localJSONObject1.put("thirdCtx", localObject);
        if (!aw.isDarkMode()) {
          continue;
        }
        i = 1;
      }
      catch (Exception paramActivity)
      {
        JSONObject localJSONObject1;
        label356:
        Log.e("MicroMsg.FilesFloatBall.MiniReaderLogic", "getMenuInfo() Exception:%s %s", new Object[] { paramActivity.getClass().getSimpleName(), paramActivity.getMessage() });
        label402:
        paramActivity = str;
        continue;
        int i = 0;
        continue;
        localJSONObject2.put("from", "");
      }
      localJSONObject1.put("darkMode", i);
      paramBoolean5 = bwA();
      localObject = new ArrayList();
      if (paramBoolean4)
      {
        localJSONObject2 = a(8, c.d.float_multitask_light_on, localContext.getString(c.h.files_enter_float_ball), true, 1);
        if (paramBoolean2)
        {
          localJSONObject2.put("from", "multitask");
          break label720;
          localJSONObject2.put("hasCurrentMultiTask", paramString2);
          localJSONObject2.put("multiTaskId", MD5Util.getMD5String(String.format("%s", new Object[] { paramString1 })));
          paramString1 = a(4, c.d.export_to_mobile, localContext.getString(c.h.export_to_mobile), true, 2);
          paramString2 = a(5, c.d.icon_file_handoff, localContext.getString(c.h.files_open_in_computer), paramBoolean3, 3);
          if (paramBoolean5) {
            ((ArrayList)localObject).add(localJSONObject2);
          }
          ((ArrayList)localObject).add(paramString1);
          ((ArrayList)localObject).add(paramString2);
          if (paramBoolean6) {
            ((ArrayList)localObject).add(a(7, c.d.app_brand_open_material_more, localContext.getString(c.h.app_brand_open_material_more), true, 4));
          }
          if ((aw.jkS()) || (aj.aAy(paramActivity.getTaskId())))
          {
            i = c.d.icons_outlined_seperated;
            paramString1 = localContext.getString(c.h.split_screen);
            if (aw.aAj(paramActivity.getTaskId())) {
              break label738;
            }
            paramBoolean1 = true;
            ((ArrayList)localObject).add(a(11, i, paramString1, paramBoolean1, 5));
            ((ArrayList)localObject).add(a(12, c.d.icons_outlined_merge, localContext.getString(c.h.close_split_screen), aw.aAj(paramActivity.getTaskId()), 5));
          }
          localJSONObject1.put("menuItems", new JSONArray((Collection)localObject));
          paramActivity = localJSONObject1.toString();
          AppMethodBeat.o(231714);
          return paramActivity;
          localJSONObject1.put("className", "com.tencent.mm.ui.tools.MiniQbCallBackUI");
          continue;
        }
      }
      localJSONObject2 = i(8, c.d.float_multitask_light_on, localContext.getString(c.h.files_enter_float_ball));
      if (paramBoolean2)
      {
        localJSONObject2.put("from", "multitask");
        break label743;
      }
    }
    for (;;)
    {
      localJSONObject2.put("hasCurrentMultiTask", paramString2);
      localJSONObject2.put("multiTaskId", MD5Util.getMD5String(String.format("%s", new Object[] { paramString1 })));
      paramString1 = i(4, c.d.export_to_mobile, localContext.getString(c.h.export_to_mobile));
      if (paramBoolean5) {
        ((ArrayList)localObject).add(localJSONObject2);
      }
      ((ArrayList)localObject).add(paramString1);
      if (paramBoolean6) {
        ((ArrayList)localObject).add(i(7, c.d.app_brand_open_material_more, localContext.getString(c.h.app_brand_open_material_more)));
      }
      if ((!aw.jkS()) && (!aj.aAy(paramActivity.getTaskId()))) {
        break label402;
      }
      if (aw.aAj(paramActivity.getTaskId()))
      {
        ((ArrayList)localObject).add(i(12, c.d.icons_outlined_merge, localContext.getString(c.h.close_split_screen)));
        break label402;
        localJSONObject2.put("from", "");
        break label743;
      }
      ((ArrayList)localObject).add(i(11, c.d.icons_outlined_seperated, localContext.getString(c.h.split_screen)));
      break label402;
      label720:
      if (paramBoolean1)
      {
        paramString2 = "1";
        break;
      }
      paramString2 = "0";
      break;
      label738:
      paramBoolean1 = false;
      break label356;
      label743:
      if (paramBoolean1) {
        paramString2 = "1";
      } else {
        paramString2 = "0";
      }
    }
  }
  
  private static JSONObject a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean, int paramInt3)
  {
    AppMethodBeat.i(231716);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", paramInt1);
      localJSONObject.put("iconResId", paramInt2);
      localJSONObject.put("text", paramString);
      localJSONObject.put("isShow", paramBoolean);
      localJSONObject.put("idx", paramInt3);
      AppMethodBeat.o(231716);
      return localJSONObject;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.FilesFloatBall.MiniReaderLogic", "getMenuInfo() Exception:%s %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
      }
    }
  }
  
  public static void a(boolean paramBoolean1, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1, String paramString5, boolean paramBoolean2)
  {
    AppMethodBeat.i(231733);
    a(paramBoolean1, false, paramActivity, paramString1, paramString2, paramString3, paramString4, paramValueCallback, paramValueCallback1, true, paramString5, paramBoolean2, false);
    AppMethodBeat.o(231733);
  }
  
  public static void a(boolean paramBoolean1, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1, boolean paramBoolean2, String paramString5, boolean paramBoolean3)
  {
    AppMethodBeat.i(231740);
    HashMap localHashMap = new HashMap();
    localHashMap.put("menuData", a(paramActivity, paramString1, paramBoolean1, false, false, true, paramBoolean2, paramString5, paramBoolean3));
    for (;;)
    {
      try
      {
        paramString5 = new JSONArray();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("id", 1);
        if (paramBoolean1) {
          continue;
        }
        paramBoolean2 = true;
        localJSONObject.put("isShow", paramBoolean2);
        paramString5.put(localJSONObject);
        localJSONObject = new JSONObject();
        localJSONObject.put("id", 2);
        localJSONObject.put("isShow", paramBoolean1);
        paramString5.put(localJSONObject);
        localHashMap.put("update_menu_param", paramString5.toString());
      }
      catch (Exception paramString5)
      {
        Log.e("MicroMsg.FilesFloatBall.MiniReaderLogic", "updateMenu() Exception:%s %s", new Object[] { paramString5.getClass().getSimpleName(), paramString5.getMessage() });
        continue;
      }
      a.a(paramActivity, paramString1, paramString2, paramString3, paramString4, true, localHashMap, h.a.aiet, paramValueCallback, paramValueCallback1, true);
      AppMethodBeat.o(231740);
      return;
      paramBoolean2 = false;
    }
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1)
  {
    AppMethodBeat.i(231722);
    a(paramBoolean1, paramBoolean2, false, false, paramActivity, paramString1, paramString2, paramString3, paramString4, paramValueCallback, paramValueCallback1, true, "", 0, true, false);
    AppMethodBeat.o(231722);
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1, String paramString5, boolean paramBoolean3)
  {
    AppMethodBeat.i(231727);
    a(paramBoolean1, false, false, paramBoolean2, paramActivity, paramString1, paramString2, paramString3, paramString4, paramValueCallback, paramValueCallback1, true, paramString5, 0, paramBoolean3, false);
    AppMethodBeat.o(231727);
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1, boolean paramBoolean3, String paramString5, boolean paramBoolean4, boolean paramBoolean5)
  {
    AppMethodBeat.i(231737);
    HashMap localHashMap = new HashMap();
    localHashMap.put("menuData", a(paramActivity, paramString1, paramBoolean1, paramBoolean2, false, false, paramBoolean3, paramString5, paramBoolean5));
    localHashMap.put("query_param", "feature_wx_float_window");
    a.a(paramActivity, paramString1, paramString2, paramString3, paramString4, false, localHashMap, h.a.aiet, paramValueCallback, paramValueCallback1, paramBoolean4);
    AppMethodBeat.o(231737);
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1, int paramInt, boolean paramBoolean4)
  {
    AppMethodBeat.i(231719);
    a(paramBoolean1, paramBoolean2, paramBoolean3, false, paramActivity, paramString1, paramString2, paramString3, paramString4, paramValueCallback, paramValueCallback1, false, "", paramInt, true, paramBoolean4);
    AppMethodBeat.o(231719);
  }
  
  private static void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1, boolean paramBoolean5, String paramString5, int paramInt, boolean paramBoolean6, boolean paramBoolean7)
  {
    AppMethodBeat.i(231730);
    HashMap localHashMap = new HashMap();
    localHashMap.put("menuData", a(paramActivity, paramString1, paramBoolean1, paramBoolean2, paramBoolean4, paramBoolean3, paramBoolean5, paramString5, paramBoolean7));
    if (paramBoolean4)
    {
      int i = 1;
      if (Util.isEqual(paramInt, 9)) {
        i = 3;
      }
      localHashMap.put("param_flag", String.valueOf(i));
    }
    a.a(paramActivity, paramString1, paramString2, paramString3, paramString4, true, localHashMap, h.a.aiet, paramValueCallback, paramValueCallback1, paramBoolean6);
    AppMethodBeat.o(231730);
  }
  
  /* Error */
  private static boolean bwA()
  {
    // Byte code:
    //   0: ldc_w 303
    //   3: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 309	com/tencent/mm/sdk/platformtools/BuildInfo:IS_FLAVOR_RED	Z
    //   9: ifeq +11 -> 20
    //   12: ldc_w 303
    //   15: invokestatic 185	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: iconst_1
    //   19: ireturn
    //   20: ldc_w 311
    //   23: invokestatic 317	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   26: checkcast 311	com/tencent/mm/plugin/expt/b/c
    //   29: getstatic 323	com/tencent/mm/plugin/expt/b/c$a:zuk	Lcom/tencent/mm/plugin/expt/b/c$a;
    //   32: ldc2_w 324
    //   35: invokeinterface 328 4 0
    //   40: lstore_0
    //   41: invokestatic 28	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   44: invokestatic 334	com/tencent/xweb/x5/a/e:getMiniQBVersion	(Landroid/content/Context;)Ljava/lang/String;
    //   47: astore 5
    //   49: aload 5
    //   51: invokestatic 338	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   54: ifne +119 -> 173
    //   57: aload 5
    //   59: ldc_w 340
    //   62: ldc 30
    //   64: invokevirtual 344	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   67: astore 6
    //   69: aload 6
    //   71: invokestatic 338	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   74: ifne +99 -> 173
    //   77: aload 6
    //   79: invokestatic 349	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   82: invokevirtual 353	java/lang/Long:longValue	()J
    //   85: lstore_2
    //   86: lload_2
    //   87: lload_0
    //   88: lcmp
    //   89: iflt +84 -> 173
    //   92: iconst_1
    //   93: istore 4
    //   95: ldc 189
    //   97: ldc_w 355
    //   100: iconst_2
    //   101: anewarray 4	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: iload 4
    //   108: invokestatic 360	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   111: aastore
    //   112: dup
    //   113: iconst_1
    //   114: aload 5
    //   116: aastore
    //   117: invokestatic 362	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: ldc_w 303
    //   123: invokestatic 185	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: iload 4
    //   128: ireturn
    //   129: astore 5
    //   131: iconst_0
    //   132: istore 4
    //   134: ldc 189
    //   136: ldc_w 364
    //   139: iconst_2
    //   140: anewarray 4	java/lang/Object
    //   143: dup
    //   144: iconst_0
    //   145: aload 5
    //   147: invokevirtual 195	java/lang/Object:getClass	()Ljava/lang/Class;
    //   150: invokevirtual 200	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   153: aastore
    //   154: dup
    //   155: iconst_1
    //   156: aload 5
    //   158: invokevirtual 367	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   161: aastore
    //   162: invokestatic 209	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   165: goto -45 -> 120
    //   168: astore 5
    //   170: goto -36 -> 134
    //   173: iconst_0
    //   174: istore 4
    //   176: goto -81 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   40	48	0	l1	long
    //   85	2	2	l2	long
    //   93	82	4	bool	boolean
    //   47	68	5	str1	String
    //   129	28	5	localObject1	Object
    //   168	1	5	localObject2	Object
    //   67	11	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   41	86	129	finally
    //   95	120	168	finally
  }
  
  private static JSONObject i(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(150142);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", paramInt1);
      localJSONObject.put("iconResId", paramInt2);
      localJSONObject.put("text", paramString);
      AppMethodBeat.o(150142);
      return localJSONObject;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.FilesFloatBall.MiniReaderLogic", "getMenuInfo() Exception:%s %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
      }
    }
  }
  
  public static final class MiniQbFloatBallMenuActionBrandEvent
    implements Parcelable
  {
    public static final Parcelable.Creator<MiniQbFloatBallMenuActionBrandEvent> CREATOR;
    public int action;
    public String filePath;
    
    static
    {
      AppMethodBeat.i(150139);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(150139);
    }
    
    public MiniQbFloatBallMenuActionBrandEvent(int paramInt, String paramString)
    {
      this.action = paramInt;
      this.filePath = paramString;
    }
    
    protected MiniQbFloatBallMenuActionBrandEvent(Parcel paramParcel)
    {
      AppMethodBeat.i(150138);
      this.action = paramParcel.readInt();
      this.filePath = paramParcel.readString();
      AppMethodBeat.o(150138);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(150137);
      paramParcel.writeInt(this.action);
      paramParcel.writeString(this.filePath);
      AppMethodBeat.o(150137);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.miniutil.MiniReaderLogic
 * JD-Core Version:    0.7.0.1
 */