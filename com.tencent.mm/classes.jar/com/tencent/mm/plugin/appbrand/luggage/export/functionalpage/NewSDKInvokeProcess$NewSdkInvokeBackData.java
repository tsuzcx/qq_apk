package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/NewSDKInvokeProcess$NewSdkInvokeBackData;", "Landroid/os/Parcelable;", "invokeReq", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "backData", "", "(Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;Ljava/lang/String;)V", "getBackData", "()Ljava/lang/String;", "getInvokeReq", "()Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
final class NewSDKInvokeProcess$NewSdkInvokeBackData
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR;
  final WechatNativeExtraDataInvokeFunctionalPage lOK;
  final String lOL;
  
  static
  {
    AppMethodBeat.i(189375);
    CREATOR = new a();
    AppMethodBeat.o(189375);
  }
  
  public NewSDKInvokeProcess$NewSdkInvokeBackData(WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, String paramString)
  {
    AppMethodBeat.i(189370);
    this.lOK = paramWechatNativeExtraDataInvokeFunctionalPage;
    this.lOL = paramString;
    AppMethodBeat.o(189370);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(189373);
    if (this != paramObject)
    {
      if ((paramObject instanceof NewSdkInvokeBackData))
      {
        paramObject = (NewSdkInvokeBackData)paramObject;
        if ((!p.i(this.lOK, paramObject.lOK)) || (!p.i(this.lOL, paramObject.lOL))) {}
      }
    }
    else
    {
      AppMethodBeat.o(189373);
      return true;
    }
    AppMethodBeat.o(189373);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(189372);
    Object localObject = this.lOK;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.lOL;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(189372);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(189371);
    String str = "NewSdkInvokeBackData(invokeReq=" + this.lOK + ", backData=" + this.lOL + ")";
    AppMethodBeat.o(189371);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(189374);
    p.h(paramParcel, "parcel");
    this.lOK.writeToParcel(paramParcel, 0);
    paramParcel.writeString(this.lOL);
    AppMethodBeat.o(189374);
  }
  
  @l(gfx={1, 1, 16})
  public static final class a
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(189369);
      p.h(paramParcel, "in");
      paramParcel = new NewSDKInvokeProcess.NewSdkInvokeBackData((WechatNativeExtraDataInvokeFunctionalPage)WechatNativeExtraDataInvokeFunctionalPage.CREATOR.createFromParcel(paramParcel), paramParcel.readString());
      AppMethodBeat.o(189369);
      return paramParcel;
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new NewSDKInvokeProcess.NewSdkInvokeBackData[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.NewSDKInvokeProcess.NewSdkInvokeBackData
 * JD-Core Version:    0.7.0.1
 */