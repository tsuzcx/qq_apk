package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;

final class JsApiShowImageOperateSheet$BottomSheetLogicHelper$IPCSendToFriendEmojiRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final Parcelable.Creator<IPCSendToFriendEmojiRequest> CREATOR;
  private String rBi;
  
  static
  {
    AppMethodBeat.i(45689);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(45689);
  }
  
  protected JsApiShowImageOperateSheet$BottomSheetLogicHelper$IPCSendToFriendEmojiRequest() {}
  
  protected JsApiShowImageOperateSheet$BottomSheetLogicHelper$IPCSendToFriendEmojiRequest(Parcel paramParcel)
  {
    AppMethodBeat.i(45687);
    this.rBi = paramParcel.readString();
    AppMethodBeat.o(45687);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final Class<? extends AppBrandProxyUIProcessTask> getTaskClass()
  {
    return JsApiShowImageOperateSheet.BottomSheetLogicHelper.d.class;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(45688);
    paramParcel.writeString(this.rBi);
    AppMethodBeat.o(45688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCSendToFriendEmojiRequest
 * JD-Core Version:    0.7.0.1
 */