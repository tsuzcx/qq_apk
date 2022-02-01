package com.tencent.mm.msgsubscription.presenter;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.WordingInfo;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;", "Landroid/os/Parcelable;", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "filter", "", "(Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;Z)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "exampleTitle", "", "getExampleTitle", "()Ljava/lang/String;", "setExampleTitle", "(Ljava/lang/String;)V", "items", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "originalData", "showEntry", "getShowEntry", "()Z", "setShowEntry", "(Z)V", "subscribeSwitch", "getSubscribeSwitch", "setSubscribeSwitch", "copyItem", "", "Ljava/util/ArrayList;", "describeContents", "", "getItemChanged", "isSubscribeMsgTmpItemChanged", "a", "b", "refresh", "", "writeToParcel", "flags", "CREATOR", "plugin-comm_release"})
public final class SubscribeMsgSettingData
  implements Parcelable
{
  public static final a CREATOR;
  public boolean hAd;
  public List<SubscribeMsgTmpItem> hqR;
  public boolean igM;
  public String ihE;
  public SubscribeMsgRequestResult ihF;
  
  static
  {
    AppMethodBeat.i(149578);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(149578);
  }
  
  public SubscribeMsgSettingData(Parcel paramParcel)
  {
    AppMethodBeat.i(149577);
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.igM = bool1;
      if (paramParcel.readByte() == 0) {
        break label124;
      }
    }
    label124:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.hAd = bool1;
      Object localObject = paramParcel.createTypedArrayList(SubscribeMsgTmpItem.CREATOR);
      k.g(localObject, "parcel.createTypedArrayL…scribeMsgTmpItem.CREATOR)");
      this.hqR = ((List)localObject);
      localObject = paramParcel.readString();
      k.g(localObject, "parcel.readString()");
      this.ihE = ((String)localObject);
      paramParcel = paramParcel.readParcelable(SubscribeMsgRequestResult.class.getClassLoader());
      k.g(paramParcel, "parcel.readParcelable(Su…::class.java.classLoader)");
      this.ihF = ((SubscribeMsgRequestResult)paramParcel);
      AppMethodBeat.o(149577);
      return;
      bool1 = false;
      break;
    }
  }
  
  public SubscribeMsgSettingData(SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
  {
    AppMethodBeat.i(149576);
    this.ihF = paramSubscribeMsgRequestResult;
    this.igM = paramSubscribeMsgRequestResult.igM;
    this.hAd = paramSubscribeMsgRequestResult.igL;
    Object localObject1 = paramSubscribeMsgRequestResult.igK;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((WordingInfo)localObject1).ihi;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    this.ihE = ((String)localObject1);
    localObject1 = (List)new ArrayList();
    paramSubscribeMsgRequestResult = ((Iterable)paramSubscribeMsgRequestResult.igI).iterator();
    while (paramSubscribeMsgRequestResult.hasNext())
    {
      localObject2 = (SubscribeMsgTmpItem)paramSubscribeMsgRequestResult.next();
      Parcel localParcel = Parcel.obtain();
      ((SubscribeMsgTmpItem)localObject2).writeToParcel(localParcel, 0);
      localParcel.setDataPosition(0);
      k.g(localParcel, "parcel");
      ((List)localObject1).add(new SubscribeMsgTmpItem(localParcel));
      localParcel.recycle();
    }
    this.hqR = ((List)localObject1);
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
    k.h(paramParcel, "parcel");
    if (this.igM)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.hAd) {
        break label82;
      }
    }
    label82:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeTypedList(this.hqR);
      paramParcel.writeString(this.ihE);
      paramParcel.writeParcelable((Parcelable)this.ihF, paramInt);
      AppMethodBeat.o(149575);
      return;
      b1 = 0;
      break;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;", "plugin-comm_release"})
  public static final class a
    implements Parcelable.Creator<SubscribeMsgSettingData>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.presenter.SubscribeMsgSettingData
 * JD-Core Version:    0.7.0.1
 */