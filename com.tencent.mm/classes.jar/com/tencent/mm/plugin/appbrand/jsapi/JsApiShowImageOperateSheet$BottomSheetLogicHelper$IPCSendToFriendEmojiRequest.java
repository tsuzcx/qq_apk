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
  private String hAr;
  
  static
  {
    AppMethodBeat.i(130609);
    CREATOR = new JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCSendToFriendEmojiRequest.1();
    AppMethodBeat.o(130609);
  }
  
  protected JsApiShowImageOperateSheet$BottomSheetLogicHelper$IPCSendToFriendEmojiRequest() {}
  
  protected JsApiShowImageOperateSheet$BottomSheetLogicHelper$IPCSendToFriendEmojiRequest(Parcel paramParcel)
  {
    AppMethodBeat.i(130607);
    this.hAr = paramParcel.readString();
    AppMethodBeat.o(130607);
  }
  
  public final Class<? extends AppBrandProxyUIProcessTask> aBo()
  {
    return JsApiShowImageOperateSheet.BottomSheetLogicHelper.d.class;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(130608);
    paramParcel.writeString(this.hAr);
    AppMethodBeat.o(130608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCSendToFriendEmojiRequest
 * JD-Core Version:    0.7.0.1
 */