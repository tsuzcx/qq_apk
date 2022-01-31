package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.b.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.task.h;

public final class JsApiLaunchMiniProgram
  extends a<c>
{
  public static final int CTRL_INDEX = 166;
  public static final String NAME = "launchMiniProgram";
  
  static final class LaunchPreconditionTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<LaunchPreconditionTask> CREATOR;
    private String hSW;
    private int hSX;
    private int hSY;
    
    static
    {
      AppMethodBeat.i(131335);
      CREATOR = new JsApiLaunchMiniProgram.LaunchPreconditionTask.1();
      AppMethodBeat.o(131335);
    }
    
    LaunchPreconditionTask()
    {
      AppMethodBeat.i(131333);
      this.hSY = JsApiLaunchMiniProgram.LaunchPreconditionTask.a.hSZ.ordinal();
      AppMethodBeat.o(131333);
    }
    
    LaunchPreconditionTask(Parcel paramParcel)
    {
      AppMethodBeat.i(131334);
      this.hSY = JsApiLaunchMiniProgram.LaunchPreconditionTask.a.hSZ.ordinal();
      f(paramParcel);
      AppMethodBeat.o(131334);
    }
    
    public final void ata()
    {
      AppMethodBeat.i(131331);
      h.EZ(this.hSW);
      this.hSY = JsApiLaunchMiniProgram.LaunchPreconditionTask.a.hTb.ordinal();
      AppMethodBeat.o(131331);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(131330);
      this.hSW = paramParcel.readString();
      this.hSX = paramParcel.readInt();
      this.hSY = paramParcel.readInt();
      AppMethodBeat.o(131330);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(131332);
      paramParcel.writeString(this.hSW);
      paramParcel.writeInt(this.hSX);
      paramParcel.writeInt(this.hSY);
      AppMethodBeat.o(131332);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram
 * JD-Core Version:    0.7.0.1
 */