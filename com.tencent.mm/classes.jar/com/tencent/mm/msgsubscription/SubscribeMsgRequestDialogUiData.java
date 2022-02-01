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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "isAlways", "", "()I", "setAlways", "(I)V", "opType", "getOpType", "setOpType", "uIItem", "Ljava/util/ArrayList;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData;", "Lkotlin/collections/ArrayList;", "getUIItem", "()Ljava/util/ArrayList;", "setUIItem", "(Ljava/util/ArrayList;)V", "describeContents", "writeToParcel", "", "flags", "Companion", "ItemUiData", "wxbiz-msgsubscription-sdk_release"})
public final class SubscribeMsgRequestDialogUiData
  implements Parcelable
{
  public static final Parcelable.Creator<SubscribeMsgRequestDialogUiData> CREATOR;
  public static final a igA;
  private static final int igu = 0;
  private static final int igv = 1;
  private static final int igw = 2;
  private static final int igx = 3;
  private static final int igy = 1;
  private static final int igz = 0;
  public int igs;
  public ArrayList<ItemUiData> igt;
  public int opType;
  
  static
  {
    AppMethodBeat.i(149539);
    igA = new a((byte)0);
    igv = 1;
    igw = 2;
    igx = 3;
    igy = 1;
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(149539);
  }
  
  public SubscribeMsgRequestDialogUiData()
  {
    AppMethodBeat.i(149537);
    this.opType = igu;
    this.igt = new ArrayList();
    AppMethodBeat.o(149537);
  }
  
  public SubscribeMsgRequestDialogUiData(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(149538);
    this.opType = paramParcel.readInt();
    this.igs = paramParcel.readInt();
    ArrayList localArrayList = new ArrayList();
    paramParcel.readList((List)localArrayList, ItemUiData.class.getClassLoader());
    this.igt = localArrayList;
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
    paramParcel.writeInt(this.igs);
    paramParcel.writeList((List)this.igt);
    AppMethodBeat.o(149536);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "chooseStatus", "", "getChooseStatus", "()I", "setChooseStatus", "(I)V", "templateId", "", "getTemplateId", "()Ljava/lang/String;", "setTemplateId", "(Ljava/lang/String;)V", "describeContents", "writeToParcel", "", "flags", "Companion", "wxbiz-msgsubscription-sdk_release"})
  public static final class ItemUiData
    implements Parcelable
  {
    public static final Parcelable.Creator<ItemUiData> CREATOR;
    private static final int igC = 1;
    private static final int igD = 0;
    public static final a igE;
    public String hiK = "";
    public int igB;
    
    static
    {
      AppMethodBeat.i(149535);
      igE = new a((byte)0);
      igC = 1;
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
      this.hiK = str1;
      this.igB = paramParcel.readInt();
      AppMethodBeat.o(149534);
    }
    
    public final void EQ(String paramString)
    {
      AppMethodBeat.i(179494);
      k.h(paramString, "<set-?>");
      this.hiK = paramString;
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
      paramParcel.writeString(this.hiK);
      paramParcel.writeInt(this.igB);
      AppMethodBeat.o(149533);
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData$Companion;", "", "()V", "CHOOSE_STATUS_CHECK", "", "getCHOOSE_STATUS_CHECK", "()I", "CHOOSE_STATUS_UNCHECK", "getCHOOSE_STATUS_UNCHECK", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData;", "wxbiz-msgsubscription-sdk_release"})
    public static final class a {}
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData;", "wxbiz-msgsubscription-sdk_release"})
    public static final class b
      implements Parcelable.Creator<SubscribeMsgRequestDialogUiData.ItemUiData>
    {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "IS_ALWAYS_NO", "", "getIS_ALWAYS_NO", "()I", "IS_ALWAYS_YES", "getIS_ALWAYS_YES", "OP_TYPE_CANCEL", "getOP_TYPE_CANCEL", "OP_TYPE_CONFIRM", "getOP_TYPE_CONFIRM", "OP_TYPE_NONE", "getOP_TYPE_NONE", "OP_TYPE_REJECT", "getOP_TYPE_REJECT", "build", "event", "itemsShowOnDialog", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "isAlwaysCbCheck", "", "wxbiz-msgsubscription-sdk_release"})
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
        i = SubscribeMsgRequestDialogUiData.aLc();
        localSubscribeMsgRequestDialogUiData.igs = i;
        if (paramInt != 1) {
          break label143;
        }
        paramInt = SubscribeMsgRequestDialogUiData.aKZ();
        localSubscribeMsgRequestDialogUiData.opType = paramInt;
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break label174;
        }
        localObject = (b.b)paramList.next();
        localArrayList = localSubscribeMsgRequestDialogUiData.igt;
        localItemUiData = new SubscribeMsgRequestDialogUiData.ItemUiData();
        localItemUiData.EQ(((b.b)localObject).hiK);
        if (!((b.b)localObject).ikl) {
          break label162;
        }
        localObject = SubscribeMsgRequestDialogUiData.ItemUiData.igE;
      }
      for (paramInt = SubscribeMsgRequestDialogUiData.ItemUiData.aLe();; paramInt = SubscribeMsgRequestDialogUiData.ItemUiData.aLf())
      {
        localItemUiData.igB = paramInt;
        localArrayList.add(localItemUiData);
        break label56;
        i = SubscribeMsgRequestDialogUiData.aLd();
        break;
        label143:
        if (paramInt == 3)
        {
          paramInt = SubscribeMsgRequestDialogUiData.aLb();
          break label43;
        }
        paramInt = SubscribeMsgRequestDialogUiData.aLa();
        break label43;
        label162:
        localObject = SubscribeMsgRequestDialogUiData.ItemUiData.igE;
      }
      label174:
      AppMethodBeat.o(149531);
      return localSubscribeMsgRequestDialogUiData;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "wxbiz-msgsubscription-sdk_release"})
  public static final class b
    implements Parcelable.Creator<SubscribeMsgRequestDialogUiData>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData
 * JD-Core Version:    0.7.0.1
 */