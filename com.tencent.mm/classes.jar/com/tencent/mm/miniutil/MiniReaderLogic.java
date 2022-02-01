package com.tencent.mm.miniutil;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.xweb.f.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class MiniReaderLogic
{
  private static String a(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, String paramString2, boolean paramBoolean6)
  {
    AppMethodBeat.i(223518);
    Context localContext = MMApplicationContext.getContext();
    String str = "";
    Object localObject;
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
        paramBoolean5 = ao.gJY();
        localObject = new ArrayList();
        if (!paramBoolean4) {
          break label377;
        }
        localJSONObject2 = a(8, 2131232769, localContext.getString(2131759412), true, 1);
        if (!paramBoolean2) {
          continue;
        }
        localJSONObject2.put("from", "multitask");
      }
      catch (Exception paramString1)
      {
        JSONObject localJSONObject1;
        label286:
        Log.e("MicroMsg.FilesFloatBall.MiniReaderLogic", "getMenuInfo() Exception:%s %s", new Object[] { paramString1.getClass().getSimpleName(), paramString1.getMessage() });
        paramString1 = str;
        continue;
        localJSONObject2.put("from", "");
      }
      localJSONObject2.put("hasCurrentMultiTask", paramString2);
      localJSONObject2.put("multiTaskId", MD5Util.getMD5String(String.format("%s", new Object[] { paramString1 })));
      paramString1 = a(4, 2131232222, localContext.getString(2131758937), true, 2);
      paramString2 = a(5, 2131233106, localContext.getString(2131759414), paramBoolean3, 3);
      if (paramBoolean5) {
        ((ArrayList)localObject).add(localJSONObject2);
      }
      ((ArrayList)localObject).add(paramString1);
      ((ArrayList)localObject).add(paramString2);
      if (paramBoolean6) {
        ((ArrayList)localObject).add(a(7, 2131231022, localContext.getString(2131755574), true, 4));
      }
      localJSONObject1.put("menuItems", new JSONArray((Collection)localObject));
      paramString1 = localJSONObject1.toString();
      AppMethodBeat.o(223518);
      return paramString1;
      localJSONObject1.put("className", "com.tencent.mm.ui.tools.MiniQbCallBackUI");
    }
    label377:
    JSONObject localJSONObject2 = h(8, 2131232769, localContext.getString(2131759412));
    if (paramBoolean2) {
      localJSONObject2.put("from", "multitask");
    }
    for (;;)
    {
      label410:
      localJSONObject2.put("hasCurrentMultiTask", paramString2);
      localJSONObject2.put("multiTaskId", MD5Util.getMD5String(String.format("%s", new Object[] { paramString1 })));
      paramString1 = h(4, 2131232222, localContext.getString(2131758937));
      if (paramBoolean5) {
        ((ArrayList)localObject).add(localJSONObject2);
      }
      ((ArrayList)localObject).add(paramString1);
      if (!paramBoolean6) {
        break label286;
      }
      ((ArrayList)localObject).add(h(7, 2131231022, localContext.getString(2131755574)));
      break label286;
      localJSONObject2.put("from", "");
      while (!paramBoolean1)
      {
        paramString2 = "0";
        break label410;
        if (paramBoolean1)
        {
          paramString2 = "1";
          break;
        }
        paramString2 = "0";
        break;
      }
      paramString2 = "1";
    }
  }
  
  private static JSONObject a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean, int paramInt3)
  {
    AppMethodBeat.i(223519);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", paramInt1);
      localJSONObject.put("iconResId", paramInt2);
      localJSONObject.put("text", paramString);
      localJSONObject.put("isShow", paramBoolean);
      localJSONObject.put("idx", paramInt3);
      AppMethodBeat.o(223519);
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
  
  public static void a(boolean paramBoolean1, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1, String paramString5, boolean paramBoolean2)
  {
    AppMethodBeat.i(223524);
    a(paramBoolean1, false, paramContext, paramString1, paramString2, paramString3, paramString4, paramValueCallback, paramValueCallback1, true, paramString5, paramBoolean2, false);
    AppMethodBeat.o(223524);
  }
  
  public static void a(boolean paramBoolean1, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1, boolean paramBoolean2, String paramString5, boolean paramBoolean3)
  {
    AppMethodBeat.i(223526);
    HashMap localHashMap = new HashMap();
    localHashMap.put("menuData", a(paramString1, paramBoolean1, false, false, true, paramBoolean2, paramString5, paramBoolean3));
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
      a.a(paramContext, paramString1, paramString2, paramString3, paramString4, true, localHashMap, f.a.SyT, paramValueCallback, paramValueCallback1, true);
      AppMethodBeat.o(223526);
      return;
      paramBoolean2 = false;
    }
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1)
  {
    AppMethodBeat.i(223521);
    a(paramBoolean1, paramBoolean2, false, false, paramContext, paramString1, paramString2, paramString3, paramString4, paramValueCallback, paramValueCallback1, true, "", 0, true, false);
    AppMethodBeat.o(223521);
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1, String paramString5, boolean paramBoolean3)
  {
    AppMethodBeat.i(223522);
    a(paramBoolean1, false, false, paramBoolean2, paramContext, paramString1, paramString2, paramString3, paramString4, paramValueCallback, paramValueCallback1, true, paramString5, 0, paramBoolean3, false);
    AppMethodBeat.o(223522);
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1, boolean paramBoolean3, String paramString5, boolean paramBoolean4, boolean paramBoolean5)
  {
    AppMethodBeat.i(223525);
    HashMap localHashMap = new HashMap();
    localHashMap.put("menuData", a(paramString1, paramBoolean1, paramBoolean2, false, false, paramBoolean3, paramString5, paramBoolean5));
    localHashMap.put("query_param", "feature_wx_float_window");
    a.a(paramContext, paramString1, paramString2, paramString3, paramString4, false, localHashMap, f.a.SyT, paramValueCallback, paramValueCallback1, paramBoolean4);
    AppMethodBeat.o(223525);
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1, int paramInt, boolean paramBoolean4)
  {
    AppMethodBeat.i(223520);
    a(paramBoolean1, paramBoolean2, paramBoolean3, false, paramContext, paramString1, paramString2, paramString3, paramString4, paramValueCallback, paramValueCallback1, false, "", paramInt, true, paramBoolean4);
    AppMethodBeat.o(223520);
  }
  
  private static void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1, boolean paramBoolean5, String paramString5, int paramInt, boolean paramBoolean6, boolean paramBoolean7)
  {
    AppMethodBeat.i(223523);
    HashMap localHashMap = new HashMap();
    localHashMap.put("menuData", a(paramString1, paramBoolean1, paramBoolean2, paramBoolean4, paramBoolean3, paramBoolean5, paramString5, paramBoolean7));
    if (paramBoolean4)
    {
      int i = 1;
      if (Util.isEqual(paramInt, 9)) {
        i = 3;
      }
      localHashMap.put("param_flag", String.valueOf(i));
    }
    a.a(paramContext, paramString1, paramString2, paramString3, paramString4, true, localHashMap, f.a.SyT, paramValueCallback, paramValueCallback1, paramBoolean6);
    AppMethodBeat.o(223523);
  }
  
  private static JSONObject h(int paramInt1, int paramInt2, String paramString)
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
  
  public static abstract class a<T>
    implements ValueCallback<T>
  {
    public boolean iBj = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.miniutil.MiniReaderLogic
 * JD-Core Version:    0.7.0.1
 */