package com.tencent.mm.msgsubscription;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "chooseStatus", "", "getChooseStatus", "()I", "setChooseStatus", "(I)V", "isAcceptWithAudio", "", "()Z", "setAcceptWithAudio", "(Z)V", "templateId", "", "getTemplateId", "()Ljava/lang/String;", "setTemplateId", "(Ljava/lang/String;)V", "describeContents", "writeToParcel", "", "flags", "Companion", "wxbiz-msgsubscription-sdk_release"})
public final class SubscribeMsgRequestDialogUiData$ItemUiData
  implements Parcelable
{
  public static final Parcelable.Creator<ItemUiData> CREATOR;
  private static final int mnI = 1;
  private static final int mnJ = 0;
  public static final SubscribeMsgRequestDialogUiData.ItemUiData.a mnK;
  public String lnb = "";
  public int mnG;
  public boolean mnH;
  
  static
  {
    AppMethodBeat.i(149535);
    mnK = new SubscribeMsgRequestDialogUiData.ItemUiData.a((byte)0);
    mnI = 1;
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(149535);
  }
  
  public SubscribeMsgRequestDialogUiData$ItemUiData() {}
  
  public SubscribeMsgRequestDialogUiData$ItemUiData(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(149534);
    String str2 = paramParcel.readString();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.lnb = str1;
    this.mnG = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.mnH = bool;
      AppMethodBeat.o(149534);
      return;
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(149533);
    p.k(paramParcel, "parcel");
    paramParcel.writeString(this.lnb);
    paramParcel.writeInt(this.mnG);
    if (this.mnH) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(149533);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData;", "wxbiz-msgsubscription-sdk_release"})
  public static final class b
    implements Parcelable.Creator<SubscribeMsgRequestDialogUiData.ItemUiData>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData.ItemUiData
 * JD-Core Version:    0.7.0.1
 */