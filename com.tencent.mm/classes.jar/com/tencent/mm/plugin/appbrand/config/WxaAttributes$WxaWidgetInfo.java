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

public class WxaAttributes$WxaWidgetInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WxaWidgetInfo> CREATOR;
  public int fyH;
  public String obR;
  public List<WxaAttributes.WxaPluginCodeInfo> obS;
  
  static
  {
    AppMethodBeat.i(175239);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(175239);
  }
  
  public WxaAttributes$WxaWidgetInfo() {}
  
  protected WxaAttributes$WxaWidgetInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(175238);
    this.fyH = paramParcel.readInt();
    this.obR = paramParcel.readString();
    this.obS = paramParcel.createTypedArrayList(WxaAttributes.WxaPluginCodeInfo.CREATOR);
    AppMethodBeat.o(175238);
  }
  
  public static List<WxaWidgetInfo> afx(String paramString)
  {
    AppMethodBeat.i(175236);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(175236);
      return null;
    }
    try
    {
      paramString = m(new JSONArray(paramString));
      AppMethodBeat.o(175236);
      return paramString;
    }
    catch (JSONException paramString)
    {
      Log.e("MicroMsg.AppBrand.WxaAttributes.WxaPluginCodeInfo", "parse json array, e = %s", new Object[] { paramString });
      AppMethodBeat.o(175236);
    }
    return null;
  }
  
  public static List<WxaWidgetInfo> m(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(188270);
    if (paramJSONArray != null) {}
    try
    {
      int i = paramJSONArray.length();
      if (i <= 0)
      {
        AppMethodBeat.o(188270);
        return null;
      }
      LinkedList localLinkedList = new LinkedList();
      i = 0;
      while (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        if (localJSONObject != null)
        {
          WxaWidgetInfo localWxaWidgetInfo = new WxaWidgetInfo();
          localWxaWidgetInfo.fyH = localJSONObject.optInt("package_type");
          localWxaWidgetInfo.obR = localJSONObject.optString("wxapkg_md5");
          if (org.apache.commons.b.a.contains(com.tencent.mm.cx.a.YYz, localWxaWidgetInfo.fyH))
          {
            localWxaWidgetInfo.obS = WxaAttributes.WxaPluginCodeInfo.cz(localJSONObject.opt("separated_plugin_list"));
            localLinkedList.add(localWxaWidgetInfo);
          }
        }
        i += 1;
      }
      AppMethodBeat.o(188270);
      return localLinkedList;
    }
    catch (JSONException paramJSONArray)
    {
      Log.e("MicroMsg.AppBrand.WxaAttributes.WxaPluginCodeInfo", "parse json array, e = %s", new Object[] { paramJSONArray });
      AppMethodBeat.o(188270);
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(175237);
    paramParcel.writeInt(this.fyH);
    paramParcel.writeString(this.obR);
    paramParcel.writeTypedList(this.obS);
    AppMethodBeat.o(175237);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaWidgetInfo
 * JD-Core Version:    0.7.0.1
 */