package com.tencent.mm.plugin.appbrand.device_discovery.bluetooth;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fh;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.b;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/MonitoredBluetoothDeviceInfo;", "Lcom/tencent/mm/autogen/table/BaseMonitoredBluetoothDeviceInfo;", "Lcom/tencent/mm/plugin/appbrand/device_discovery/IJsObject;", "Lcom/tencent/mm/plugin/appbrand/device_discovery/IDbObject;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "json", "Lorg/json/JSONObject;", "getJson", "()Lorg/json/JSONObject;", "json$delegate", "Lkotlin/Lazy;", "describeContents", "", "equals", "", "other", "", "fromJson", "jsonObj", "fromPersistableBundle", "", "bundle", "Landroid/os/PersistableBundle;", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "hashCode", "isValid", "toJson", "toPersistableBundle", "toString", "", "writeToParcel", "flags", "isValidVersionType", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MonitoredBluetoothDeviceInfo
  extends fh
  implements Parcelable
{
  public static final MonitoredBluetoothDeviceInfo.a CREATOR;
  public static final IAutoDBItem.MAutoDBInfo nVV;
  public final j rhl;
  
  static
  {
    AppMethodBeat.i(321757);
    CREATOR = new MonitoredBluetoothDeviceInfo.a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = fh.aJm();
    s.checkNotNull(localMAutoDBInfo);
    nVV = localMAutoDBInfo;
    AppMethodBeat.o(321757);
  }
  
  public MonitoredBluetoothDeviceInfo()
  {
    AppMethodBeat.i(321736);
    this.rhl = k.cm((kotlin.g.a.a)new MonitoredBluetoothDeviceInfo.b(this));
    AppMethodBeat.o(321736);
  }
  
  public MonitoredBluetoothDeviceInfo(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(321743);
    this.field_appId = paramParcel.readString();
    this.field_bluetoothDeviceId = paramParcel.readString();
    this.field_wechatToken = paramParcel.readString();
    this.field_versionType = paramParcel.readInt();
    this.field_entryPackage = paramParcel.readString();
    this.field_updateTime = paramParcel.readLong();
    AppMethodBeat.o(321743);
  }
  
  private static boolean zO(int paramInt)
  {
    return (1 == paramInt) || (2 == paramInt) || (paramInt == 0);
  }
  
  public final boolean T(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(321773);
    s.u(paramJSONObject, "jsonObj");
    try
    {
      this.field_appId = paramJSONObject.getString("appid");
      this.field_bluetoothDeviceId = paramJSONObject.getString("bluetoothDeviceId");
      this.field_wechatToken = paramJSONObject.getString("deviceId");
      this.field_versionType = b.a(paramJSONObject.optString("envVersion"), b.shS).euz;
      this.field_entryPackage = paramJSONObject.optString("entryPackage");
      bool = true;
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        com.tencent.mm.plugin.appbrand.device_discovery.a locala = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
        com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrand.MonitoredBluetoothDeviceInfo", s.X("fromJson fail since ", paramJSONObject));
        boolean bool = false;
      }
    }
    AppMethodBeat.o(321773);
    return bool;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(321801);
    if (this == paramObject)
    {
      AppMethodBeat.o(321801);
      return true;
    }
    Class localClass = getClass();
    if (paramObject == null) {}
    for (Object localObject = null; !s.p(localClass, localObject); localObject = paramObject.getClass())
    {
      AppMethodBeat.o(321801);
      return false;
    }
    if (paramObject == null)
    {
      paramObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.MonitoredBluetoothDeviceInfo");
      AppMethodBeat.o(321801);
      throw paramObject;
    }
    if ((!s.p(this.field_appId, this.field_appId)) || (this.field_versionType != this.field_versionType) || (!s.p(this.field_entryPackage, this.field_entryPackage)) || (!s.p(this.field_wechatToken, this.field_wechatToken)) || (!s.p(this.field_bluetoothDeviceId, this.field_bluetoothDeviceId)))
    {
      AppMethodBeat.o(321801);
      return false;
    }
    AppMethodBeat.o(321801);
    return true;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return nVV;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(321808);
    int i = this.field_appId.hashCode();
    int j = this.field_versionType;
    int k = this.field_entryPackage.hashCode();
    int m = this.field_wechatToken.hashCode();
    int n = this.field_bluetoothDeviceId.hashCode();
    AppMethodBeat.o(321808);
    return (((i * 31 + j) * 31 + k) * 31 + m) * 31 + n;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(321780);
    CharSequence localCharSequence = (CharSequence)this.field_appId;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label118;
      }
      localCharSequence = (CharSequence)this.field_bluetoothDeviceId;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label108;
      }
      i = 1;
      label55:
      if (i != 0) {
        break label118;
      }
      localCharSequence = (CharSequence)this.field_wechatToken;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label113;
      }
    }
    label108:
    label113:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || (!zO(this.field_versionType))) {
        break label118;
      }
      AppMethodBeat.o(321780);
      return true;
      i = 0;
      break;
      i = 0;
      break label55;
    }
    label118:
    AppMethodBeat.o(321780);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(321817);
    String str = "MonitoredBluetoothDeviceInfo(appId=" + this.field_appId + ", bluetoothDeviceId=" + this.field_bluetoothDeviceId + ", wechatToken=" + this.field_wechatToken + ", versionType=" + this.field_versionType + ", entryPackage=" + this.field_entryPackage + ", updateTime=" + this.field_updateTime + ", isBlocked=" + this.field_isBlocked + ')';
    AppMethodBeat.o(321817);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(321790);
    s.u(paramParcel, "parcel");
    paramParcel.writeString(this.field_appId);
    paramParcel.writeString(this.field_bluetoothDeviceId);
    paramParcel.writeString(this.field_wechatToken);
    paramParcel.writeInt(this.field_versionType);
    paramParcel.writeString(this.field_entryPackage);
    paramParcel.writeLong(this.field_updateTime);
    AppMethodBeat.o(321790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.MonitoredBluetoothDeviceInfo
 * JD-Core Version:    0.7.0.1
 */