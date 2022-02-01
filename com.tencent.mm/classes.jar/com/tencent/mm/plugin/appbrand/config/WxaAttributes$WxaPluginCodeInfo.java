package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lcom.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaWidgetInfo;>;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WxaAttributes$WxaPluginCodeInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WxaPluginCodeInfo> CREATOR;
  public List<Integer> contexts;
  public String md5;
  public String nGm;
  public boolean obu;
  public long obv;
  public String prefixPath;
  public String provider;
  public int version;
  
  static
  {
    AppMethodBeat.i(123500);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(123500);
  }
  
  public WxaAttributes$WxaPluginCodeInfo()
  {
    AppMethodBeat.i(175234);
    this.contexts = new LinkedList();
    AppMethodBeat.o(175234);
  }
  
  protected WxaAttributes$WxaPluginCodeInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(123499);
    this.contexts = new LinkedList();
    this.provider = paramParcel.readString();
    this.version = paramParcel.readInt();
    this.md5 = paramParcel.readString();
    this.prefixPath = paramParcel.readString();
    if (paramParcel.readByte() == 1) {}
    for (;;)
    {
      this.obu = bool;
      if (this.contexts == null) {
        this.contexts = new LinkedList();
      }
      paramParcel.readList(this.contexts, Integer.class.getClassLoader());
      this.obv = paramParcel.readLong();
      this.nGm = paramParcel.readString();
      AppMethodBeat.o(123499);
      return;
      bool = false;
    }
  }
  
  public static List<WxaPluginCodeInfo> a(List<WxaAttributes.WxaWidgetInfo> paramList, Object paramObject, int paramInt)
  {
    AppMethodBeat.i(186888);
    Object localObject = null;
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      for (paramList = (List<WxaAttributes.WxaWidgetInfo>)localObject; localIterator.hasNext(); paramList = ((WxaAttributes.WxaWidgetInfo)localObject).obS)
      {
        localObject = (WxaAttributes.WxaWidgetInfo)localIterator.next();
        if (((WxaAttributes.WxaWidgetInfo)localObject).fyH != paramInt) {
          break label76;
        }
      }
    }
    for (;;)
    {
      localObject = paramList;
      if (paramList == null) {
        localObject = cz(paramObject);
      }
      AppMethodBeat.o(186888);
      return localObject;
      label76:
      break;
      paramList = null;
    }
  }
  
  public static List<WxaPluginCodeInfo> cz(Object paramObject)
  {
    AppMethodBeat.i(186892);
    if (paramObject == null)
    {
      AppMethodBeat.o(186892);
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        if ((paramObject instanceof String))
        {
          paramObject = new JSONArray((String)paramObject);
          if (paramObject != null)
          {
            i = paramObject.length();
            if (i != 0) {}
          }
          else
          {
            AppMethodBeat.o(186892);
            return null;
          }
        }
        else
        {
          if ((paramObject instanceof JSONArray))
          {
            paramObject = (JSONArray)paramObject;
            continue;
          }
          Log.e("MicroMsg.AppBrand.WxaAttributes.WxaPluginCodeInfo", "WxaPluginCodeInfo.optPluginCodeInfoList() invalid pluginCodeObj:%s", new Object[] { paramObject.getClass().getName() });
          paramObject = null;
          continue;
        }
        LinkedList localLinkedList = new LinkedList();
        i = 0;
        if (i < paramObject.length())
        {
          JSONObject localJSONObject = paramObject.getJSONObject(i);
          if (localJSONObject == null) {
            break label360;
          }
          WxaPluginCodeInfo localWxaPluginCodeInfo = new WxaPluginCodeInfo();
          localWxaPluginCodeInfo.provider = localJSONObject.optString("plugin_id");
          localWxaPluginCodeInfo.version = localJSONObject.optInt("inner_version");
          localWxaPluginCodeInfo.md5 = localJSONObject.optString("md5");
          localWxaPluginCodeInfo.prefixPath = localJSONObject.optString("prefix_path");
          if (!localJSONObject.optBoolean("auto_update"))
          {
            if (localJSONObject.optInt("auto_update", 0) <= 0) {
              break label367;
            }
            break label355;
            localWxaPluginCodeInfo.obu = bool;
            JSONArray localJSONArray = localJSONObject.optJSONArray("contexts");
            if ((localJSONArray != null) && (localJSONArray.length() > 0)) {
              break label372;
            }
            localWxaPluginCodeInfo.contexts.add(Integer.valueOf(0));
            localWxaPluginCodeInfo.obv = localJSONObject.optLong("dev_key");
            localWxaPluginCodeInfo.nGm = localJSONObject.optString("version_desc");
            localLinkedList.add(localWxaPluginCodeInfo);
            break label360;
            if (j < localJSONArray.length())
            {
              localWxaPluginCodeInfo.contexts.add(Integer.valueOf(localJSONArray.optInt(j)));
              j += 1;
              continue;
            }
            continue;
          }
        }
        else
        {
          AppMethodBeat.o(186892);
          return localLinkedList;
        }
      }
      catch (JSONException paramObject)
      {
        Log.e("MicroMsg.AppBrand.WxaAttributes.WxaPluginCodeInfo", "parse json array, e = %s", new Object[] { paramObject });
        AppMethodBeat.o(186892);
        return null;
      }
      label355:
      boolean bool = true;
      continue;
      label360:
      i += 1;
      continue;
      label367:
      bool = false;
      continue;
      label372:
      int j = 0;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(123498);
    paramParcel.writeString(this.provider);
    paramParcel.writeInt(this.version);
    paramParcel.writeString(this.md5);
    paramParcel.writeString(this.prefixPath);
    if (this.obu) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeList(this.contexts);
      paramParcel.writeLong(this.obv);
      paramParcel.writeString(this.nGm);
      AppMethodBeat.o(123498);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaPluginCodeInfo
 * JD-Core Version:    0.7.0.1
 */