package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WxaAttributes$WxaVersionModuleInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WxaVersionModuleInfo> CREATOR;
  public String[] aliases;
  public boolean independent;
  public String md5;
  public String name;
  public String obG;
  public List<WxaAttributes.WxaPluginCodeInfo> obO;
  public List<WxaAttributes.WxaWidgetInfo> obP;
  private JSONObject obQ;
  public int size;
  
  static
  {
    AppMethodBeat.i(123516);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(123516);
  }
  
  public WxaAttributes$WxaVersionModuleInfo() {}
  
  protected WxaAttributes$WxaVersionModuleInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(123515);
    this.name = paramParcel.readString();
    this.md5 = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.independent = bool;
      this.size = paramParcel.readInt();
      this.aliases = paramParcel.createStringArray();
      this.obO = paramParcel.createTypedArrayList(WxaAttributes.WxaPluginCodeInfo.CREATOR);
      this.obG = paramParcel.readString();
      this.obP = paramParcel.createTypedArrayList(WxaAttributes.WxaWidgetInfo.CREATOR);
      AppMethodBeat.o(123515);
      return;
    }
  }
  
  private static String[] I(JSONObject paramJSONObject)
  {
    int i = 0;
    AppMethodBeat.i(123513);
    paramJSONObject = paramJSONObject.optJSONArray("alias");
    if ((paramJSONObject == null) || (paramJSONObject.length() <= 0))
    {
      AppMethodBeat.o(123513);
      return new String[0];
    }
    String[] arrayOfString = new String[paramJSONObject.length()];
    while (i < paramJSONObject.length())
    {
      arrayOfString[i] = paramJSONObject.optString(i);
      i += 1;
    }
    AppMethodBeat.o(123513);
    return arrayOfString;
  }
  
  public static List<WxaVersionModuleInfo> afw(String paramString)
  {
    AppMethodBeat.i(123512);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(123512);
      return null;
    }
    try
    {
      Object localObject = new JSONArray(paramString);
      int i = ((JSONArray)localObject).length();
      if (i <= 0)
      {
        AppMethodBeat.o(123512);
        return null;
      }
      localObject = l((JSONArray)localObject);
      AppMethodBeat.o(123512);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.AppBrand.WxaAttributes.WxaVersionModuleInfo", "parse json array, json = %s, e = %s", new Object[] { paramString, localJSONException });
      AppMethodBeat.o(123512);
    }
    return null;
  }
  
  public static List<WxaVersionModuleInfo> l(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(123511);
    if (paramJSONArray == null)
    {
      AppMethodBeat.o(123511);
      return null;
    }
    try
    {
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      while (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        if (localJSONObject != null)
        {
          WxaVersionModuleInfo localWxaVersionModuleInfo = new WxaVersionModuleInfo();
          localWxaVersionModuleInfo.obQ = localJSONObject;
          localWxaVersionModuleInfo.name = localJSONObject.getString("name");
          localWxaVersionModuleInfo.md5 = localJSONObject.getString("md5");
          localWxaVersionModuleInfo.size = localJSONObject.optInt("size", 0);
          localWxaVersionModuleInfo.independent = localJSONObject.optBoolean("independent", false);
          localWxaVersionModuleInfo.aliases = I(localJSONObject);
          localWxaVersionModuleInfo.obG = localJSONObject.optString("without_lib_md5");
          localWxaVersionModuleInfo.obP = WxaAttributes.WxaWidgetInfo.m(localJSONObject.optJSONArray("widget_list"));
          localWxaVersionModuleInfo.obO = WxaAttributes.WxaPluginCodeInfo.a(localWxaVersionModuleInfo.obP, localJSONObject.opt("separated_plugin_list"), 23);
          localLinkedList.add(localWxaVersionModuleInfo);
        }
        i += 1;
      }
      AppMethodBeat.o(123511);
      return localLinkedList;
    }
    catch (JSONException paramJSONArray)
    {
      Log.e("MicroMsg.AppBrand.WxaAttributes.WxaVersionModuleInfo", "parse json array, e = %s", new Object[] { paramJSONArray });
      AppMethodBeat.o(123511);
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(123514);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.md5);
    if (this.independent) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.size);
      paramParcel.writeStringArray(this.aliases);
      paramParcel.writeTypedList(this.obO);
      paramParcel.writeString(this.obG);
      paramParcel.writeTypedList(this.obP);
      AppMethodBeat.o(123514);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionModuleInfo
 * JD-Core Version:    0.7.0.1
 */