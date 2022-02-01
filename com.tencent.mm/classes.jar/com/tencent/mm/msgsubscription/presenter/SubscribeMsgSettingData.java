package com.tencent.mm.msgsubscription.presenter;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.WordingInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;", "Landroid/os/Parcelable;", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "filter", "", "(Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;Z)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "exampleTitle", "", "getExampleTitle", "()Ljava/lang/String;", "setExampleTitle", "(Ljava/lang/String;)V", "items", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "originalData", "showEntry", "getShowEntry", "()Z", "setShowEntry", "(Z)V", "subscribeSwitch", "getSubscribeSwitch", "setSubscribeSwitch", "copyItem", "", "Ljava/util/ArrayList;", "describeContents", "", "getItemChanged", "isSubscribeMsgTmpItemChanged", "a", "b", "refresh", "", "writeToParcel", "flags", "CREATOR", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SubscribeMsgSettingData
  implements Parcelable
{
  public static final SubscribeMsgSettingData.a CREATOR;
  public List<SubscribeMsgTmpItem> bMQ;
  public boolean oyB;
  public boolean phH;
  public String pjA;
  public SubscribeMsgRequestResult pjB;
  
  static
  {
    AppMethodBeat.i(149578);
    CREATOR = new SubscribeMsgSettingData.a((byte)0);
    AppMethodBeat.o(149578);
  }
  
  public SubscribeMsgSettingData(Parcel paramParcel)
  {
    AppMethodBeat.i(149577);
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.phH = bool1;
      if (paramParcel.readByte() == 0) {
        break label125;
      }
    }
    label125:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.oyB = bool1;
      ArrayList localArrayList = paramParcel.createTypedArrayList(SubscribeMsgTmpItem.CREATOR);
      s.checkNotNull(localArrayList);
      s.s(localArrayList, "parcel.createTypedArrayL…ribeMsgTmpItem.CREATOR)!!");
      this.bMQ = ((List)localArrayList);
      this.pjA = String.valueOf(paramParcel.readString());
      paramParcel = paramParcel.readParcelable(SubscribeMsgRequestResult.class.getClassLoader());
      s.checkNotNull(paramParcel);
      s.s(paramParcel, "parcel.readParcelable(Su…class.java.classLoader)!!");
      this.pjB = ((SubscribeMsgRequestResult)paramParcel);
      AppMethodBeat.o(149577);
      return;
      bool1 = false;
      break;
    }
  }
  
  public SubscribeMsgSettingData(SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
  {
    AppMethodBeat.i(149576);
    this.pjB = paramSubscribeMsgRequestResult;
    this.phH = paramSubscribeMsgRequestResult.phH;
    this.oyB = paramSubscribeMsgRequestResult.phG;
    Object localObject1 = paramSubscribeMsgRequestResult.phF;
    if (localObject1 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      this.pjA = ((String)localObject1);
      localObject1 = (List)new ArrayList();
      paramSubscribeMsgRequestResult = ((Iterable)paramSubscribeMsgRequestResult.phC).iterator();
      while (paramSubscribeMsgRequestResult.hasNext())
      {
        localObject2 = (SubscribeMsgTmpItem)paramSubscribeMsgRequestResult.next();
        Parcel localParcel = Parcel.obtain();
        s.s(localParcel, "obtain()");
        ((SubscribeMsgTmpItem)localObject2).writeToParcel(localParcel, 0);
        localParcel.setDataPosition(0);
        ((List)localObject1).add(new SubscribeMsgTmpItem(localParcel));
        localParcel.recycle();
      }
      Object localObject2 = ((WordingInfo)localObject1).pii;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
    this.bMQ = ((List)localObject1);
    AppMethodBeat.o(149576);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(149575);
    s.u(paramParcel, "parcel");
    if (this.phH)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.oyB) {
        break label82;
      }
    }
    label82:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeTypedList(this.bMQ);
      paramParcel.writeString(this.pjA);
      paramParcel.writeParcelable((Parcelable)this.pjB, paramInt);
      AppMethodBeat.o(149575);
      return;
      b1 = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.presenter.SubscribeMsgSettingData
 * JD-Core Version:    0.7.0.1
 */