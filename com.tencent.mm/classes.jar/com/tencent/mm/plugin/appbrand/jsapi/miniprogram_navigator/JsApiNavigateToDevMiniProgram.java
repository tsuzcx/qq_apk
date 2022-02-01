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
  
  protected final c bkg()
  {
    return l.kWp;
  }
  
  static final class DevPkgInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<DevPkgInfo> CREATOR;
    String appId;
    String dJJ;
    String dJK;
    String kWb;
    
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
      this.dJJ = paramParcel.readString();
      this.dJK = paramParcel.readString();
      this.kWb = paramParcel.readString();
      AppMethodBeat.o(46625);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46624);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.dJJ);
      paramParcel.writeString(this.dJK);
      paramParcel.writeString(this.kWb);
      AppMethodBeat.o(46624);
    }
  }
  
  static final class a
    implements k<JsApiNavigateToDevMiniProgram.DevPkgInfo, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiNavigateToDevMiniProgram
 * JD-Core Version:    0.7.0.1
 */