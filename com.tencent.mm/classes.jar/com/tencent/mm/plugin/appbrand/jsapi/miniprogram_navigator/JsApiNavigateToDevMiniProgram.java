package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCVoid;

public final class JsApiNavigateToDevMiniProgram
  extends a
{
  private static final int CTRL_INDEX = 351;
  private static final String NAME = "navigateToDevMiniProgram";
  
  protected final c bGm()
  {
    return m.mfl;
  }
  
  static final class DevPkgInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<DevPkgInfo> CREATOR;
    String appId;
    String ecN;
    String ecO;
    String meX;
    
    static
    {
      AppMethodBeat.i(46626);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46626);
    }
    
    DevPkgInfo() {}
    
    DevPkgInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(46625);
      this.appId = paramParcel.readString();
      this.ecN = paramParcel.readString();
      this.ecO = paramParcel.readString();
      this.meX = paramParcel.readString();
      AppMethodBeat.o(46625);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(226909);
      String str = "DevPkgInfo{appId='" + this.appId + '\'' + ", downloadURL='" + this.ecN + '\'' + ", checkSumMd5='" + this.ecO + '\'' + ", extoptions='" + this.meX + '\'' + '}';
      AppMethodBeat.o(226909);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46624);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.ecN);
      paramParcel.writeString(this.ecO);
      paramParcel.writeString(this.meX);
      AppMethodBeat.o(46624);
    }
  }
  
  static final class a
    implements k<JsApiNavigateToDevMiniProgram.DevPkgInfo, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiNavigateToDevMiniProgram
 * JD-Core Version:    0.7.0.1
 */