package com.tencent.mm.msgsubscription;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.ui.b.b;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "isAlways", "", "()I", "setAlways", "(I)V", "opType", "getOpType", "setOpType", "uIItem", "Ljava/util/ArrayList;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData;", "Lkotlin/collections/ArrayList;", "getUIItem", "()Ljava/util/ArrayList;", "setUIItem", "(Ljava/util/ArrayList;)V", "describeContents", "writeToParcel", "", "flags", "Companion", "ItemUiData", "wxbiz-msgsubscription-sdk_release"})
public final class SubscribeMsgRequestDialogUiData
  implements Parcelable
{
  public static final Parcelable.Creator<SubscribeMsgRequestDialogUiData> CREATOR;
  private static final int izO = 0;
  private static final int izP = 1;
  private static final int izQ = 2;
  private static final int izR = 3;
  private static final int izS = 1;
  private static final int izT = 0;
  public static final a izU;
  public int izM;
  public ArrayList<ItemUiData> izN;
  public int opType;
  
  static
  {
    AppMethodBeat.i(149539);
    izU = new a((byte)0);
    izP = 1;
    izQ = 2;
    izR = 3;
    izS = 1;
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(149539);
  }
  
  public SubscribeMsgRequestDialogUiData()
  {
    AppMethodBeat.i(149537);
    this.opType = izO;
    this.izN = new ArrayList();
    AppMethodBeat.o(149537);
  }
  
  public SubscribeMsgRequestDialogUiData(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(149538);
    this.opType = paramParcel.readInt();
    this.izM = paramParcel.readInt();
    ArrayList localArrayList = new ArrayList();
    paramParcel.readList((List)localArrayList, ItemUiData.class.getClassLoader());
    this.izN = localArrayList;
    AppMethodBeat.o(149538);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(149536);
    p.h(paramParcel, "parcel");
    paramParcel.writeInt(this.opType);
    paramParcel.writeInt(this.izM);
    paramParcel.writeList((List)this.izN);
    AppMethodBeat.o(149536);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "chooseStatus", "", "getChooseStatus", "()I", "setChooseStatus", "(I)V", "templateId", "", "getTemplateId", "()Ljava/lang/String;", "setTemplateId", "(Ljava/lang/String;)V", "describeContents", "writeToParcel", "", "flags", "Companion", "wxbiz-msgsubscription-sdk_release"})
  public static final class ItemUiData
    implements Parcelable
  {
    public static final Parcelable.Creator<ItemUiData> CREATOR;
    private static final int izW = 1;
    private static final int izX = 0;
    public static final a izY;
    public String hAT = "";
    public int izV;
    
    static
    {
      AppMethodBeat.i(149535);
      izY = new a((byte)0);
      izW = 1;
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
      this.hAT = str1;
      this.izV = paramParcel.readInt();
      AppMethodBeat.o(149534);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(149533);
      p.h(paramParcel, "parcel");
      paramParcel.writeString(this.hAT);
      paramParcel.writeInt(this.izV);
      AppMethodBeat.o(149533);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData$Companion;", "", "()V", "CHOOSE_STATUS_CHECK", "", "getCHOOSE_STATUS_CHECK", "()I", "CHOOSE_STATUS_UNCHECK", "getCHOOSE_STATUS_UNCHECK", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData;", "wxbiz-msgsubscription-sdk_release"})
    public static final class a {}
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData;", "wxbiz-msgsubscription-sdk_release"})
    public static final class b
      implements Parcelable.Creator<SubscribeMsgRequestDialogUiData.ItemUiData>
    {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "IS_ALWAYS_NO", "", "getIS_ALWAYS_NO", "()I", "IS_ALWAYS_YES", "getIS_ALWAYS_YES", "OP_TYPE_CANCEL", "getOP_TYPE_CANCEL", "OP_TYPE_CONFIRM", "getOP_TYPE_CONFIRM", "OP_TYPE_NONE", "getOP_TYPE_NONE", "OP_TYPE_REJECT", "getOP_TYPE_REJECT", "build", "event", "itemsShowOnDialog", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "isAlwaysCbCheck", "", "wxbiz-msgsubscription-sdk_release"})
  public static final class a
  {
    public static SubscribeMsgRequestDialogUiData a(int paramInt, List<b.b> paramList, boolean paramBoolean)
    {
      AppMethodBeat.i(149531);
      p.h(paramList, "itemsShowOnDialog");
      SubscribeMsgRequestDialogUiData localSubscribeMsgRequestDialogUiData = new SubscribeMsgRequestDialogUiData();
      int i;
      label43:
      label56:
      Object localObject;
      ArrayList localArrayList;
      SubscribeMsgRequestDialogUiData.ItemUiData localItemUiData;
      if (paramBoolean)
      {
        i = SubscribeMsgRequestDialogUiData.aOl();
        localSubscribeMsgRequestDialogUiData.izM = i;
        if (paramInt != 1) {
          break label154;
        }
        paramInt = SubscribeMsgRequestDialogUiData.aOi();
        localSubscribeMsgRequestDialogUiData.opType = paramInt;
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break label185;
        }
        localObject = (b.b)paramList.next();
        localArrayList = localSubscribeMsgRequestDialogUiData.izN;
        localItemUiData = new SubscribeMsgRequestDialogUiData.ItemUiData();
        String str = ((b.b)localObject).hAT;
        p.h(str, "<set-?>");
        localItemUiData.hAT = str;
        if (!((b.b)localObject).iDC) {
          break label173;
        }
        localObject = SubscribeMsgRequestDialogUiData.ItemUiData.izY;
      }
      for (paramInt = SubscribeMsgRequestDialogUiData.ItemUiData.aOn();; paramInt = SubscribeMsgRequestDialogUiData.ItemUiData.aOo())
      {
        localItemUiData.izV = paramInt;
        localArrayList.add(localItemUiData);
        break label56;
        i = SubscribeMsgRequestDialogUiData.aOm();
        break;
        label154:
        if (paramInt == 3)
        {
          paramInt = SubscribeMsgRequestDialogUiData.aOk();
          break label43;
        }
        paramInt = SubscribeMsgRequestDialogUiData.aOj();
        break label43;
        label173:
        localObject = SubscribeMsgRequestDialogUiData.ItemUiData.izY;
      }
      label185:
      AppMethodBeat.o(149531);
      return localSubscribeMsgRequestDialogUiData;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "wxbiz-msgsubscription-sdk_release"})
  public static final class b
    implements Parcelable.Creator<SubscribeMsgRequestDialogUiData>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData
 * JD-Core Version:    0.7.0.1
 */