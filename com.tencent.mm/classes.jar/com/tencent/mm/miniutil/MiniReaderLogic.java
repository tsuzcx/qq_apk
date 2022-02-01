package com.tencent.mm.miniutil;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cp.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.xweb.f.a;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class MiniReaderLogic
{
  private static String a(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2)
  {
    AppMethodBeat.i(150140);
    Object localObject = ak.getContext();
    String str = "";
    for (;;)
    {
      try
      {
        localJSONObject1 = new JSONObject();
        localJSONObject1.put("pkgName", ((Context)localObject).getPackageName());
        if (!paramBoolean3) {
          continue;
        }
        localJSONObject1.put("className", "com.tencent.mm.ui.tools.MiniQbCallBackMMUI");
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("type", "miniqb");
        localJSONObject2.put("filePath", paramString1);
        localJSONObject2.put("processName", ak.getProcessName());
        localJSONObject2.put("appid", paramString2);
        localJSONObject1.put("thirdCtx", localJSONObject2);
        paramString2 = new ArrayList();
        if (!paramBoolean2) {
          break label286;
        }
        paramString1 = ((Context)localObject).getString(2131759080);
        if (paramBoolean1) {
          continue;
        }
        paramBoolean2 = true;
      }
      catch (Exception paramString1)
      {
        JSONObject localJSONObject1;
        JSONObject localJSONObject2;
        ae.e("MicroMsg.FilesFloatBall.MiniReaderLogic", "getMenuInfo() Exception:%s %s", new Object[] { paramString1.getClass().getSimpleName(), paramString1.getMessage() });
        paramString1 = str;
        continue;
        paramBoolean2 = false;
        continue;
      }
      paramString1 = a(1, 2131232408, paramString1, paramBoolean2, 1);
      localJSONObject2 = a(2, 2131232407, ((Context)localObject).getString(2131759079), paramBoolean1, 1);
      localObject = a(4, 2131234854, ((Context)localObject).getString(2131758630), true, 2);
      paramString2.add(paramString1);
      paramString2.add(localJSONObject2);
      paramString2.add(localObject);
      localJSONObject1.put("menuItems", new JSONArray(paramString2));
      paramString1 = localJSONObject1.toString();
      AppMethodBeat.o(150140);
      return paramString1;
      localJSONObject1.put("className", "com.tencent.mm.ui.tools.MiniQbCallBackUI");
    }
    label286:
    if (paramBoolean1) {}
    for (paramString1 = h(2, 2131232407, ((Context)localObject).getString(2131759079));; paramString1 = h(1, 2131232408, ((Context)localObject).getString(2131759080)))
    {
      localObject = h(4, 2131234854, ((Context)localObject).getString(2131758630));
      paramString2.add(paramString1);
      paramString2.add(localObject);
      break;
    }
  }
  
  private static JSONObject a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean, int paramInt3)
  {
    AppMethodBeat.i(218654);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", paramInt1);
      localJSONObject.put("iconResId", paramInt2);
      localJSONObject.put("text", paramString);
      localJSONObject.put("isShow", paramBoolean);
      localJSONObject.put("idx", paramInt3);
      AppMethodBeat.o(218654);
      return localJSONObject;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ae.e("MicroMsg.FilesFloatBall.MiniReaderLogic", "getMenuInfo() Exception:%s %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
      }
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1, boolean paramBoolean, String paramString5)
  {
    AppMethodBeat.i(150148);
    HashMap localHashMap = new HashMap();
    localHashMap.put("menuData", a(paramString1, false, true, paramBoolean, paramString5));
    try
    {
      paramString5 = new JSONArray();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", 1);
      localJSONObject.put("isShow", true);
      paramString5.put(localJSONObject);
      localJSONObject = new JSONObject();
      localJSONObject.put("id", 2);
      localJSONObject.put("isShow", false);
      paramString5.put(localJSONObject);
      localHashMap.put("update_menu_param", paramString5.toString());
      a.a(paramContext, paramString1, paramString2, paramString3, paramString4, true, localHashMap, f.a.MMe, paramValueCallback, paramValueCallback1, true);
      AppMethodBeat.o(150148);
      return;
    }
    catch (Exception paramString5)
    {
      for (;;)
      {
        ae.e("MicroMsg.FilesFloatBall.MiniReaderLogic", "updateMenu() Exception:%s %s", new Object[] { paramString5.getClass().getSimpleName(), paramString5.getMessage() });
      }
    }
  }
  
  public static void a(boolean paramBoolean1, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1, boolean paramBoolean2, String paramString5)
  {
    AppMethodBeat.i(150147);
    a(paramBoolean1, paramContext, paramString1, paramString2, paramString3, paramString4, paramValueCallback, paramValueCallback1, paramBoolean2, paramString5, true);
    AppMethodBeat.o(150147);
  }
  
  public static void a(boolean paramBoolean1, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1, boolean paramBoolean2, String paramString5, boolean paramBoolean3)
  {
    AppMethodBeat.i(177289);
    HashMap localHashMap = new HashMap();
    localHashMap.put("menuData", a(paramString1, paramBoolean1, false, paramBoolean2, paramString5));
    localHashMap.put("query_param", "feature_wx_float_window");
    a.a(paramContext, paramString1, paramString2, paramString3, paramString4, false, localHashMap, f.a.MMe, paramValueCallback, paramValueCallback1, paramBoolean3);
    AppMethodBeat.o(177289);
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1)
  {
    AppMethodBeat.i(150144);
    a(paramBoolean1, paramBoolean2, paramContext, paramString1, paramString2, paramString3, paramString4, paramValueCallback, paramValueCallback1, true, "", 0, true);
    AppMethodBeat.o(150144);
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1, int paramInt)
  {
    AppMethodBeat.i(150143);
    a(paramBoolean1, paramBoolean2, paramContext, paramString1, paramString2, paramString3, paramString4, paramValueCallback, paramValueCallback1, false, "", paramInt, true);
    AppMethodBeat.o(150143);
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1, String paramString5, boolean paramBoolean3)
  {
    AppMethodBeat.i(177287);
    a(paramBoolean1, paramBoolean2, paramContext, paramString1, paramString2, paramString3, paramString4, paramValueCallback, paramValueCallback1, true, paramString5, 0, paramBoolean3);
    AppMethodBeat.o(177287);
  }
  
  private static void a(boolean paramBoolean1, boolean paramBoolean2, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1, boolean paramBoolean3, String paramString5, int paramInt, boolean paramBoolean4)
  {
    AppMethodBeat.i(177288);
    HashMap localHashMap = new HashMap();
    localHashMap.put("menuData", a(paramString1, paramBoolean1, paramBoolean2, paramBoolean3, paramString5));
    if (paramBoolean2)
    {
      int i = 1;
      if (bu.jB(paramInt, 9)) {
        i = 3;
      }
      localHashMap.put("param_flag", String.valueOf(i));
    }
    a.a(paramContext, paramString1, paramString2, paramString3, paramString4, true, localHashMap, f.a.MMe, paramValueCallback, paramValueCallback1, paramBoolean4);
    AppMethodBeat.o(177288);
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
        ae.e("MicroMsg.FilesFloatBall.MiniReaderLogic", "getMenuInfo() Exception:%s %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
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
    public boolean hGZ = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.miniutil.MiniReaderLogic
 * JD-Core Version:    0.7.0.1
 */