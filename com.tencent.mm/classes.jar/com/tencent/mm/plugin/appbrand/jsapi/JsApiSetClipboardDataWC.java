package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.x.l;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.secinforeport.a.a;

public final class JsApiSetClipboardDataWC
  extends l<r>
{
  static class ReportClipBoardTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<ReportClipBoardTask> CREATOR;
    private String kxv;
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
      e(paramParcel);
      AppMethodBeat.o(45648);
    }
    
    public ReportClipBoardTask(String paramString1, String paramString2, int paramInt)
    {
      this.mAppId = paramString1;
      this.kxv = paramString2;
      this.mLength = paramInt;
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(45647);
      a locala = a.yRN;
      a.K(this.mLength, this.mAppId, this.kxv);
      AppMethodBeat.o(45647);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(45649);
      this.mAppId = paramParcel.readString();
      this.kxv = paramParcel.readString();
      this.mLength = paramParcel.readInt();
      AppMethodBeat.o(45649);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45650);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.kxv);
      paramParcel.writeInt(this.mLength);
      AppMethodBeat.o(45650);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiSetClipboardDataWC
 * JD-Core Version:    0.7.0.1
 */