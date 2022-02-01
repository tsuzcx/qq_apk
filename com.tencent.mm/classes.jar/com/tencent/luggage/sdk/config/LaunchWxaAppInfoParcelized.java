package com.tencent.luggage.sdk.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/config/LaunchWxaAppInfoParcelized;", "Landroid/os/Parcelable;", "permission", "Lcom/tencent/mm/plugin/appbrand/permission/AppRuntimeApiPermissionBundle;", "errorAction", "opConfig", "", "relyCommLibUpdate", "", "restartOnAttrAsyncUpdatedWithLaunchRequestedLatestVersion", "(Lcom/tencent/mm/plugin/appbrand/permission/AppRuntimeApiPermissionBundle;Landroid/os/Parcelable;Ljava/lang/String;ZZ)V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LaunchWxaAppInfoParcelized
  implements Parcelable
{
  public static final Parcelable.Creator<LaunchWxaAppInfoParcelized> CREATOR;
  public AppRuntimeApiPermissionBundle eqi;
  public Parcelable eqj;
  public String eqk;
  public boolean eql;
  public boolean eqm;
  
  static
  {
    AppMethodBeat.i(220226);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(220226);
  }
  
  public LaunchWxaAppInfoParcelized(AppRuntimeApiPermissionBundle paramAppRuntimeApiPermissionBundle, Parcelable paramParcelable, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.eqi = paramAppRuntimeApiPermissionBundle;
    this.eqj = paramParcelable;
    this.eqk = paramString;
    this.eql = paramBoolean1;
    this.eqm = paramBoolean2;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(220234);
    s.u(paramParcel, "out");
    paramParcel.writeParcelable((Parcelable)this.eqi, paramInt);
    paramParcel.writeParcelable(this.eqj, paramInt);
    paramParcel.writeString(this.eqk);
    if (this.eql)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.eqm) {
        break label81;
      }
    }
    label81:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(220234);
      return;
      paramInt = 0;
      break;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<LaunchWxaAppInfoParcelized>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.config.LaunchWxaAppInfoParcelized
 * JD-Core Version:    0.7.0.1
 */