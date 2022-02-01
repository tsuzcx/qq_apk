package com.tencent.mm.plugin.appbrand.jsapi.msgsubscription;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.util.a.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor;", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/ISubscribeMsgCGIExecutor;", "username", "", "eventListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor$EventListener;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor$EventListener;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "(Ljava/lang/String;)V", "buffers", "", "getBuffers", "()[B", "setBuffers", "([B)V", "dispatcher", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "getDispatcher", "()Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "setDispatcher", "(Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;)V", "getEventListener", "()Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor$EventListener;", "setEventListener", "(Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor$EventListener;)V", "value", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "subscribeMsgTmpItems", "getSubscribeMsgTmpItems", "()Ljava/util/List;", "setSubscribeMsgTmpItems", "(Ljava/util/List;)V", "uIData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "getUIData", "()Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "setUIData", "(Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;)V", "dealWithCgiResult", "", "context", "Landroid/content/Context;", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "describeContents", "", "onNetSceneEndCallback", "errType", "errCode", "errMsg", "requestCgi", "writeToParcel", "dest", "flags", "Companion", "EventListener", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SubscribeMsgExecutor
  implements ISubscribeMsgCGIExecutor
{
  public static final Parcelable.Creator<SubscribeMsgExecutor> CREATOR;
  public static final SubscribeMsgExecutor.a sjp;
  SubscribeMsgRequestDialogUiData piL;
  a.a siV;
  c sjq;
  byte[] sjr;
  List<SubscribeMsgTmpItem> sjs;
  final String username;
  
  static
  {
    AppMethodBeat.i(50627);
    sjp = new SubscribeMsgExecutor.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(50627);
  }
  
  public SubscribeMsgExecutor(Parcel paramParcel)
  {
    this(String.valueOf(paramParcel.readString()));
    AppMethodBeat.i(50626);
    List localList = this.sjs;
    Object localObject = paramParcel.createTypedArrayList(SubscribeMsgTmpItem.CREATOR);
    if (localObject == null) {}
    for (localObject = (Collection)ab.aivy;; localObject = (Collection)localObject)
    {
      localList.addAll((Collection)localObject);
      this.sjr = new byte[paramParcel.readInt()];
      localObject = this.sjr;
      s.checkNotNull(localObject);
      paramParcel.readByteArray((byte[])localObject);
      this.piL = ((SubscribeMsgRequestDialogUiData)paramParcel.readParcelable(SubscribeMsgRequestDialogUiData.class.getClassLoader()));
      AppMethodBeat.o(50626);
      return;
    }
  }
  
  private SubscribeMsgExecutor(String paramString)
  {
    AppMethodBeat.i(50624);
    this.username = paramString;
    this.sjs = ((List)new ArrayList());
    this.siV = ((a.a)a.siO);
    AppMethodBeat.o(50624);
  }
  
  public SubscribeMsgExecutor(String paramString, c paramc)
  {
    this(paramString);
    AppMethodBeat.i(50625);
    this.sjq = paramc;
    AppMethodBeat.o(50625);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
  {
    AppMethodBeat.i(50622);
    s.u(paramString, "errMsg");
    c localc = this.sjq;
    if (localc != null) {
      localc.a(paramInt1, paramInt2, paramString, paramSubscribeMsgRequestResult);
    }
    AppMethodBeat.o(50622);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(50623);
    if (paramParcel != null) {
      paramParcel.writeString(this.username);
    }
    if (paramParcel != null) {
      paramParcel.writeTypedList(this.sjs);
    }
    Object localObject;
    if (paramParcel != null)
    {
      localObject = this.sjr;
      if (localObject != null) {
        break label103;
      }
    }
    label103:
    for (int i = 0;; i = localObject.length)
    {
      paramParcel.writeInt(i);
      if (paramParcel != null)
      {
        byte[] arrayOfByte = this.sjr;
        localObject = arrayOfByte;
        if (arrayOfByte == null) {
          localObject = new byte[0];
        }
        paramParcel.writeByteArray((byte[])localObject);
      }
      if (paramParcel != null) {
        paramParcel.writeParcelable((Parcelable)this.piL, paramInt);
      }
      AppMethodBeat.o(50623);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<SubscribeMsgExecutor>
  {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor$EventListener;", "", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "onSubscribeMsgDone", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult);
    
    public abstract void c(SubscribeMsgRequestResult paramSubscribeMsgRequestResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.msgsubscription.SubscribeMsgExecutor
 * JD-Core Version:    0.7.0.1
 */