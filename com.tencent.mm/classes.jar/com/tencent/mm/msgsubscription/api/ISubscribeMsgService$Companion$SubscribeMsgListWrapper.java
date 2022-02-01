package com.tencent.mm.msgsubscription.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$Companion$SubscribeMsgListWrapper;", "Landroid/os/Parcelable;", "subscribeMsgList", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "subscribeSwitchOpened", "", "(Ljava/util/List;Z)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getSubscribeMsgList", "()Ljava/util/List;", "setSubscribeMsgList", "(Ljava/util/List;)V", "getSubscribeSwitchOpened", "()Z", "setSubscribeSwitchOpened", "(Z)V", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ISubscribeMsgService$Companion$SubscribeMsgListWrapper
  implements Parcelable
{
  public static final ISubscribeMsgService.Companion.SubscribeMsgListWrapper.a CREATOR;
  public List<SubscribeMsgTmpItem> pis;
  public boolean pit;
  
  static
  {
    AppMethodBeat.i(236679);
    CREATOR = new ISubscribeMsgService.Companion.SubscribeMsgListWrapper.a((byte)0);
    AppMethodBeat.o(236679);
  }
  
  public ISubscribeMsgService$Companion$SubscribeMsgListWrapper(Parcel paramParcel)
  {
    AppMethodBeat.i(236673);
    this.pis = ((List)new ArrayList());
    try
    {
      paramParcel.readTypedList(this.pis, SubscribeMsgTmpItem.CREATOR);
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.pit = bool;
        AppMethodBeat.o(236673);
        return;
      }
      return;
    }
    catch (Exception paramParcel)
    {
      Log.printErrStackTrace("MicroMsg.SubscribeMsgListWrapper", (Throwable)paramParcel, "alvinluo SubscribeMsgListWrapper read parcel exception and clear storage", new Object[0]);
      paramParcel = b.piw;
      paramParcel = b.QW("name_biz");
      if (paramParcel != null)
      {
        paramParcel = paramParcel.piQ;
        if (paramParcel != null) {
          paramParcel.bQd();
        }
      }
      paramParcel = b.piw;
      paramParcel = b.QW("name_wxa");
      if (paramParcel != null)
      {
        paramParcel = paramParcel.piQ;
        if (paramParcel != null) {
          paramParcel.bQd();
        }
      }
      AppMethodBeat.o(236673);
    }
  }
  
  public ISubscribeMsgService$Companion$SubscribeMsgListWrapper(List<SubscribeMsgTmpItem> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(236665);
    this.pis = ((List)new ArrayList());
    this.pis.addAll((Collection)paramList);
    this.pit = paramBoolean;
    AppMethodBeat.o(236665);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(236686);
    s.u(paramParcel, "parcel");
    paramParcel.writeTypedList(this.pis);
    if (this.pit) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      AppMethodBeat.o(236686);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.api.ISubscribeMsgService.Companion.SubscribeMsgListWrapper
 * JD-Core Version:    0.7.0.1
 */