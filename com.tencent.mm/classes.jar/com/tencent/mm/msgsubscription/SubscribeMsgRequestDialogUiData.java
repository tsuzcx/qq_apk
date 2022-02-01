package com.tencent.mm.msgsubscription;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.ui.b.b;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "isAlways", "", "()I", "setAlways", "(I)V", "opType", "getOpType", "setOpType", "uIItem", "Ljava/util/ArrayList;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData;", "Lkotlin/collections/ArrayList;", "getUIItem", "()Ljava/util/ArrayList;", "setUIItem", "(Ljava/util/ArrayList;)V", "describeContents", "writeToParcel", "", "flags", "Companion", "ItemUiData", "wxbiz-msgsubscription-sdk_release"})
public final class SubscribeMsgRequestDialogUiData
  implements Parcelable
{
  public static final Parcelable.Creator<SubscribeMsgRequestDialogUiData> CREATOR;
  private static final int hFS = 0;
  private static final int hFT = 1;
  private static final int hFU = 2;
  private static final int hFV = 3;
  private static final int hFW = 1;
  private static final int hFX = 0;
  public static final a hFY;
  public int hFQ;
  public ArrayList<ItemUiData> hFR;
  public int opType;
  
  static
  {
    AppMethodBeat.i(149539);
    hFY = new a((byte)0);
    hFT = 1;
    hFU = 2;
    hFV = 3;
    hFW = 1;
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(149539);
  }
  
  public SubscribeMsgRequestDialogUiData()
  {
    AppMethodBeat.i(149537);
    this.opType = hFS;
    this.hFR = new ArrayList();
    AppMethodBeat.o(149537);
  }
  
  public SubscribeMsgRequestDialogUiData(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(149538);
    this.opType = paramParcel.readInt();
    this.hFQ = paramParcel.readInt();
    ArrayList localArrayList = new ArrayList();
    paramParcel.readList((List)localArrayList, ItemUiData.class.getClassLoader());
    this.hFR = localArrayList;
    AppMethodBeat.o(149538);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(149536);
    k.h(paramParcel, "parcel");
    paramParcel.writeInt(this.opType);
    paramParcel.writeInt(this.hFQ);
    paramParcel.writeList((List)this.hFR);
    AppMethodBeat.o(149536);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "chooseStatus", "", "getChooseStatus", "()I", "setChooseStatus", "(I)V", "templateId", "", "getTemplateId", "()Ljava/lang/String;", "setTemplateId", "(Ljava/lang/String;)V", "describeContents", "writeToParcel", "", "flags", "Companion", "wxbiz-msgsubscription-sdk_release"})
  public static final class ItemUiData
    implements Parcelable
  {
    public static final Parcelable.Creator<ItemUiData> CREATOR;
    private static final int hGa = 1;
    private static final int hGb = 0;
    public static final SubscribeMsgRequestDialogUiData.ItemUiData.a hGc;
    public String gIj = "";
    public int hFZ;
    
    static
    {
      AppMethodBeat.i(149535);
      hGc = new SubscribeMsgRequestDialogUiData.ItemUiData.a((byte)0);
      hGa = 1;
      CREATOR = (Parcelable.Creator)new b();
      AppMethodBeat.o(149535);
    }
    
    public ItemUiData() {}
    
    public ItemUiData(Parcel paramParcel)
    {
      this();
      AppMethodBeat.i(149534);
      String str2 = paramParcel.readString();
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      this.gIj = str1;
      this.hFZ = paramParcel.readInt();
      AppMethodBeat.o(149534);
    }
    
    public final void AL(String paramString)
    {
      AppMethodBeat.i(179494);
      k.h(paramString, "<set-?>");
      this.gIj = paramString;
      AppMethodBeat.o(179494);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(149533);
      k.h(paramParcel, "parcel");
      paramParcel.writeString(this.gIj);
      paramParcel.writeInt(this.hFZ);
      AppMethodBeat.o(149533);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData;", "wxbiz-msgsubscription-sdk_release"})
    public static final class b
      implements Parcelable.Creator<SubscribeMsgRequestDialogUiData.ItemUiData>
    {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "IS_ALWAYS_NO", "", "getIS_ALWAYS_NO", "()I", "IS_ALWAYS_YES", "getIS_ALWAYS_YES", "OP_TYPE_CANCEL", "getOP_TYPE_CANCEL", "OP_TYPE_CONFIRM", "getOP_TYPE_CONFIRM", "OP_TYPE_NONE", "getOP_TYPE_NONE", "OP_TYPE_REJECT", "getOP_TYPE_REJECT", "build", "event", "itemsShowOnDialog", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "isAlwaysCbCheck", "", "wxbiz-msgsubscription-sdk_release"})
  public static final class a
  {
    public static SubscribeMsgRequestDialogUiData a(int paramInt, List<b.b> paramList, boolean paramBoolean)
    {
      AppMethodBeat.i(149531);
      k.h(paramList, "itemsShowOnDialog");
      SubscribeMsgRequestDialogUiData localSubscribeMsgRequestDialogUiData = new SubscribeMsgRequestDialogUiData();
      int i;
      label43:
      label56:
      Object localObject;
      ArrayList localArrayList;
      SubscribeMsgRequestDialogUiData.ItemUiData localItemUiData;
      if (paramBoolean)
      {
        i = SubscribeMsgRequestDialogUiData.aEl();
        localSubscribeMsgRequestDialogUiData.hFQ = i;
        if (paramInt != 1) {
          break label143;
        }
        paramInt = SubscribeMsgRequestDialogUiData.aEi();
        localSubscribeMsgRequestDialogUiData.opType = paramInt;
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break label174;
        }
        localObject = (b.b)paramList.next();
        localArrayList = localSubscribeMsgRequestDialogUiData.hFR;
        localItemUiData = new SubscribeMsgRequestDialogUiData.ItemUiData();
        localItemUiData.AL(((b.b)localObject).gIj);
        if (!((b.b)localObject).hJN) {
          break label162;
        }
        localObject = SubscribeMsgRequestDialogUiData.ItemUiData.hGc;
      }
      for (paramInt = SubscribeMsgRequestDialogUiData.ItemUiData.aEn();; paramInt = SubscribeMsgRequestDialogUiData.ItemUiData.aEo())
      {
        localItemUiData.hFZ = paramInt;
        localArrayList.add(localItemUiData);
        break label56;
        i = SubscribeMsgRequestDialogUiData.aEm();
        break;
        label143:
        if (paramInt == 3)
        {
          paramInt = SubscribeMsgRequestDialogUiData.aEk();
          break label43;
        }
        paramInt = SubscribeMsgRequestDialogUiData.aEj();
        break label43;
        label162:
        localObject = SubscribeMsgRequestDialogUiData.ItemUiData.hGc;
      }
      label174:
      AppMethodBeat.o(149531);
      return localSubscribeMsgRequestDialogUiData;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "wxbiz-msgsubscription-sdk_release"})
  public static final class b
    implements Parcelable.Creator<SubscribeMsgRequestDialogUiData>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData
 * JD-Core Version:    0.7.0.1
 */