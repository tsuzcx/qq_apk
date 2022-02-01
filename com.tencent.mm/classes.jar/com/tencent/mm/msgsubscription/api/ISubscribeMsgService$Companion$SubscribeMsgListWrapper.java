package com.tencent.mm.msgsubscription.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$Companion$SubscribeMsgListWrapper;", "Landroid/os/Parcelable;", "subscribeMsgList", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "subscribeSwitchOpened", "", "(Ljava/util/List;Z)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getSubscribeMsgList", "()Ljava/util/List;", "setSubscribeMsgList", "(Ljava/util/List;)V", "getSubscribeSwitchOpened", "()Z", "setSubscribeSwitchOpened", "(Z)V", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "plugin-comm_release"})
public final class ISubscribeMsgService$Companion$SubscribeMsgListWrapper
  implements Parcelable
{
  public static final a CREATOR;
  public List<SubscribeMsgTmpItem> jyV;
  public boolean jyW;
  
  static
  {
    AppMethodBeat.i(223225);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(223225);
  }
  
  public ISubscribeMsgService$Companion$SubscribeMsgListWrapper(Parcel paramParcel)
  {
    AppMethodBeat.i(223224);
    this.jyV = ((List)new ArrayList());
    try
    {
      paramParcel.readTypedList(this.jyV, SubscribeMsgTmpItem.CREATOR);
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.jyW = bool;
        AppMethodBeat.o(223224);
        return;
      }
      return;
    }
    catch (Exception paramParcel)
    {
      Log.printErrStackTrace("MicroMsg.SubscribeMsgListWrapper", (Throwable)paramParcel, "alvinluo SubscribeMsgListWrapper read parcel exception and clear storage", new Object[0]);
      paramParcel = b.jza;
      paramParcel = b.Ru("name_biz");
      if (paramParcel != null)
      {
        paramParcel = paramParcel.jzv;
        if (paramParcel != null) {
          paramParcel.biY();
        }
      }
      paramParcel = b.jza;
      paramParcel = b.Ru("name_wxa");
      if (paramParcel != null)
      {
        paramParcel = paramParcel.jzv;
        if (paramParcel != null)
        {
          paramParcel.biY();
          AppMethodBeat.o(223224);
          return;
        }
      }
      AppMethodBeat.o(223224);
    }
  }
  
  public ISubscribeMsgService$Companion$SubscribeMsgListWrapper(List<SubscribeMsgTmpItem> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(223223);
    this.jyV = ((List)new ArrayList());
    this.jyV.addAll((Collection)paramList);
    this.jyW = paramBoolean;
    AppMethodBeat.o(223223);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(223222);
    p.h(paramParcel, "parcel");
    paramParcel.writeTypedList(this.jyV);
    if (this.jyW) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      AppMethodBeat.o(223222);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$Companion$SubscribeMsgListWrapper$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$Companion$SubscribeMsgListWrapper;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$Companion$SubscribeMsgListWrapper;", "plugin-comm_release"})
  public static final class a
    implements Parcelable.Creator<ISubscribeMsgService.Companion.SubscribeMsgListWrapper>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.api.ISubscribeMsgService.Companion.SubscribeMsgListWrapper
 * JD-Core Version:    0.7.0.1
 */