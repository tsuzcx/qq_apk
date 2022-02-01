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
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;", "Landroid/os/Parcelable;", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "filter", "", "(Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;Z)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "exampleTitle", "", "getExampleTitle", "()Ljava/lang/String;", "setExampleTitle", "(Ljava/lang/String;)V", "items", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "originalData", "showEntry", "getShowEntry", "()Z", "setShowEntry", "(Z)V", "subscribeSwitch", "getSubscribeSwitch", "setSubscribeSwitch", "copyItem", "", "Ljava/util/ArrayList;", "describeContents", "", "getItemChanged", "isSubscribeMsgTmpItemChanged", "a", "b", "refresh", "", "writeToParcel", "flags", "CREATOR", "plugin-comm_release"})
public final class SubscribeMsgSettingData
  implements Parcelable
{
  public static final SubscribeMsgSettingData.a CREATOR;
  public boolean lGT;
  public List<SubscribeMsgTmpItem> lxh;
  public boolean mnT;
  public String mpO;
  public SubscribeMsgRequestResult mpP;
  
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
      this.mnT = bool1;
      if (paramParcel.readByte() == 0) {
        break label118;
      }
    }
    label118:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.lGT = bool1;
      ArrayList localArrayList = paramParcel.createTypedArrayList(SubscribeMsgTmpItem.CREATOR);
      if (localArrayList == null) {
        p.iCn();
      }
      this.lxh = ((List)localArrayList);
      this.mpO = String.valueOf(paramParcel.readString());
      paramParcel = paramParcel.readParcelable(SubscribeMsgRequestResult.class.getClassLoader());
      if (paramParcel == null) {
        p.iCn();
      }
      this.mpP = ((SubscribeMsgRequestResult)paramParcel);
      AppMethodBeat.o(149577);
      return;
      bool1 = false;
      break;
    }
  }
  
  public SubscribeMsgSettingData(SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
  {
    AppMethodBeat.i(149576);
    this.mpP = paramSubscribeMsgRequestResult;
    this.mnT = paramSubscribeMsgRequestResult.mnT;
    this.lGT = paramSubscribeMsgRequestResult.mnS;
    Object localObject1 = paramSubscribeMsgRequestResult.mnR;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((WordingInfo)localObject1).mor;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    this.mpO = ((String)localObject1);
    localObject1 = (List)new ArrayList();
    paramSubscribeMsgRequestResult = ((Iterable)paramSubscribeMsgRequestResult.mnO).iterator();
    while (paramSubscribeMsgRequestResult.hasNext())
    {
      localObject2 = (SubscribeMsgTmpItem)paramSubscribeMsgRequestResult.next();
      Parcel localParcel = Parcel.obtain();
      p.j(localParcel, "Parcel.obtain()");
      ((SubscribeMsgTmpItem)localObject2).writeToParcel(localParcel, 0);
      localParcel.setDataPosition(0);
      ((List)localObject1).add(new SubscribeMsgTmpItem(localParcel));
      localParcel.recycle();
    }
    this.lxh = ((List)localObject1);
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
    p.k(paramParcel, "parcel");
    if (this.mnT)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.lGT) {
        break label82;
      }
    }
    label82:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeTypedList(this.lxh);
      paramParcel.writeString(this.mpO);
      paramParcel.writeParcelable((Parcelable)this.mpP, paramInt);
      AppMethodBeat.o(149575);
      return;
      b1 = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.presenter.SubscribeMsgSettingData
 * JD-Core Version:    0.7.0.1
 */