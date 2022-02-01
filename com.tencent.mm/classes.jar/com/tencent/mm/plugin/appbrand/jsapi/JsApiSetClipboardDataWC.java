package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.z.o;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.secinforeport.a.a;

public final class JsApiSetClipboardDataWC
  extends o<s>
{
  static class ReportClipBoardTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<ReportClipBoardTask> CREATOR;
    private String lBI;
    private String mAppId;
    private int mLength;
    
    static
    {
      AppMethodBeat.i(45651);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45651);
    }
    
    public ReportClipBoardTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45648);
      f(paramParcel);
      AppMethodBeat.o(45648);
    }
    
    public ReportClipBoardTask(String paramString1, String paramString2, int paramInt)
    {
      this.mAppId = paramString1;
      this.lBI = paramString2;
      this.mLength = paramInt;
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(45647);
      a locala = a.CWD;
      a.N(this.mLength, this.mAppId, this.lBI);
      AppMethodBeat.o(45647);
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(45649);
      this.mAppId = paramParcel.readString();
      this.lBI = paramParcel.readString();
      this.mLength = paramParcel.readInt();
      AppMethodBeat.o(45649);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45650);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.lBI);
      paramParcel.writeInt(this.mLength);
      AppMethodBeat.o(45650);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiSetClipboardDataWC
 * JD-Core Version:    0.7.0.1
 */