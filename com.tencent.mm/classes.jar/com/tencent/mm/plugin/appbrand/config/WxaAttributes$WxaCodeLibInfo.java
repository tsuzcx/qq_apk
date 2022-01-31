package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WxaAttributes$WxaCodeLibInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WxaCodeLibInfo> CREATOR;
  public String bsd;
  public String cqq;
  public String path;
  public int version;
  
  static
  {
    AppMethodBeat.i(140082);
    CREATOR = new WxaAttributes.WxaCodeLibInfo.1();
    AppMethodBeat.o(140082);
  }
  
  public WxaAttributes$WxaCodeLibInfo() {}
  
  protected WxaAttributes$WxaCodeLibInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(140081);
    this.bsd = paramParcel.readString();
    this.version = paramParcel.readInt();
    this.path = paramParcel.readString();
    this.cqq = paramParcel.readString();
    AppMethodBeat.o(140081);
  }
  
  public static List<WxaCodeLibInfo> AC(String paramString)
  {
    AppMethodBeat.i(96160);
    try
    {
      paramString = new JSONArray(paramString);
      int i = paramString.length();
      if (i <= 0)
      {
        AppMethodBeat.o(96160);
        return null;
      }
      LinkedList localLinkedList = new LinkedList();
      i = 0;
      while (i < paramString.length())
      {
        JSONObject localJSONObject = paramString.getJSONObject(i);
        if (localJSONObject != null)
        {
          WxaCodeLibInfo localWxaCodeLibInfo = new WxaCodeLibInfo();
          localWxaCodeLibInfo.bsd = localJSONObject.optString("provider");
          localWxaCodeLibInfo.version = localJSONObject.optInt("version");
          localWxaCodeLibInfo.path = localJSONObject.optString("path");
          localWxaCodeLibInfo.cqq = localJSONObject.optString("md5");
          localLinkedList.add(localWxaCodeLibInfo);
        }
        i += 1;
      }
      AppMethodBeat.o(96160);
      return localLinkedList;
    }
    catch (JSONException paramString)
    {
      ab.e("MicroMsg.AppBrand.WxaAttributes.WxaCodeLibInfo", "parse json array, e = %s", new Object[] { paramString });
      AppMethodBeat.o(96160);
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(140080);
    paramParcel.writeString(this.bsd);
    paramParcel.writeInt(this.version);
    paramParcel.writeString(this.path);
    paramParcel.writeString(this.cqq);
    AppMethodBeat.o(140080);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaCodeLibInfo
 * JD-Core Version:    0.7.0.1
 */