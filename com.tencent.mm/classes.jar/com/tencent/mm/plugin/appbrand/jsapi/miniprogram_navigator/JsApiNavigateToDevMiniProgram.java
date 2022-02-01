package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;

public final class JsApiNavigateToDevMiniProgram
  extends a
{
  private static final int CTRL_INDEX = 351;
  private static final String NAME = "navigateToDevMiniProgram";
  
  static
  {
    AppMethodBeat.i(326276);
    com.tencent.mm.plugin.appbrand.permission.c.afo("navigateToDevMiniProgram");
    AppMethodBeat.o(326276);
  }
  
  protected final c csb()
  {
    return l.siC;
  }
  
  static final class DevPkgInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<DevPkgInfo> CREATOR;
    String appId;
    String icR;
    String icS;
    String sij;
    
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
      this.icR = paramParcel.readString();
      this.icS = paramParcel.readString();
      this.sij = paramParcel.readString();
      AppMethodBeat.o(46625);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(326240);
      String str = "DevPkgInfo{appId='" + this.appId + '\'' + ", downloadURL='" + this.icR + '\'' + ", checkSumMd5='" + this.icS + '\'' + ", extoptions='" + this.sij + '\'' + '}';
      AppMethodBeat.o(326240);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46624);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.icR);
      paramParcel.writeString(this.icS);
      paramParcel.writeString(this.sij);
      AppMethodBeat.o(46624);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiNavigateToDevMiniProgram
 * JD-Core Version:    0.7.0.1
 */