package com.tencent.mm.msgsubscription;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.ui.c.c;
import com.tencent.mm.msgsubscription.ui.c.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "isAlways", "", "()I", "setAlways", "(I)V", "opType", "getOpType", "setOpType", "uIItem", "Ljava/util/ArrayList;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData;", "Lkotlin/collections/ArrayList;", "getUIItem", "()Ljava/util/ArrayList;", "setUIItem", "(Ljava/util/ArrayList;)V", "describeContents", "writeToParcel", "", "flags", "Companion", "ItemUiData", "wxbiz-msgsubscription-sdk_release"})
public final class SubscribeMsgRequestDialogUiData
  implements Parcelable
{
  public static final Parcelable.Creator<SubscribeMsgRequestDialogUiData> CREATOR;
  private static final int mnA = 1;
  private static final int mnB = 2;
  private static final int mnC = 3;
  private static final int mnD = 1;
  private static final int mnE = 0;
  public static final a mnF;
  private static final int mnz = 0;
  public int mnx;
  public ArrayList<SubscribeMsgRequestDialogUiData.ItemUiData> mny;
  public int opType;
  
  static
  {
    AppMethodBeat.i(149539);
    mnF = new a((byte)0);
    mnA = 1;
    mnB = 2;
    mnC = 3;
    mnD = 1;
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(149539);
  }
  
  public SubscribeMsgRequestDialogUiData()
  {
    AppMethodBeat.i(149537);
    this.opType = mnz;
    this.mny = new ArrayList();
    AppMethodBeat.o(149537);
  }
  
  public SubscribeMsgRequestDialogUiData(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(149538);
    this.opType = paramParcel.readInt();
    this.mnx = paramParcel.readInt();
    ArrayList localArrayList = new ArrayList();
    paramParcel.readList((List)localArrayList, SubscribeMsgRequestDialogUiData.ItemUiData.class.getClassLoader());
    this.mny = localArrayList;
    AppMethodBeat.o(149538);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(149536);
    p.k(paramParcel, "parcel");
    paramParcel.writeInt(this.opType);
    paramParcel.writeInt(this.mnx);
    paramParcel.writeList((List)this.mny);
    AppMethodBeat.o(149536);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "IS_ALWAYS_NO", "", "getIS_ALWAYS_NO", "()I", "IS_ALWAYS_YES", "getIS_ALWAYS_YES", "OP_TYPE_CANCEL", "getOP_TYPE_CANCEL", "OP_TYPE_CONFIRM", "getOP_TYPE_CONFIRM", "OP_TYPE_NONE", "getOP_TYPE_NONE", "OP_TYPE_REJECT", "getOP_TYPE_REJECT", "build", "event", "itemsShowOnDialog", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "isAlwaysCbCheck", "", "wxbiz-msgsubscription-sdk_release"})
  public static final class a
  {
    public static SubscribeMsgRequestDialogUiData a(int paramInt, List<c.c> paramList, boolean paramBoolean)
    {
      AppMethodBeat.i(149531);
      p.k(paramList, "itemsShowOnDialog");
      SubscribeMsgRequestDialogUiData localSubscribeMsgRequestDialogUiData = new SubscribeMsgRequestDialogUiData();
      int i;
      label43:
      label56:
      c.c localc;
      ArrayList localArrayList;
      SubscribeMsgRequestDialogUiData.ItemUiData localItemUiData;
      Object localObject;
      if (paramBoolean)
      {
        i = SubscribeMsgRequestDialogUiData.bso();
        localSubscribeMsgRequestDialogUiData.mnx = i;
        if (paramInt != 1) {
          break label175;
        }
        paramInt = SubscribeMsgRequestDialogUiData.bsl();
        localSubscribeMsgRequestDialogUiData.opType = paramInt;
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break label206;
        }
        localc = (c.c)paramList.next();
        localArrayList = localSubscribeMsgRequestDialogUiData.mny;
        localItemUiData = new SubscribeMsgRequestDialogUiData.ItemUiData();
        localObject = localc.lnb;
        p.k(localObject, "<set-?>");
        localItemUiData.lnb = ((String)localObject);
        if (!localc.msB) {
          break label194;
        }
        localObject = SubscribeMsgRequestDialogUiData.ItemUiData.mnK;
      }
      for (paramInt = SubscribeMsgRequestDialogUiData.ItemUiData.bsq();; paramInt = SubscribeMsgRequestDialogUiData.ItemUiData.bsr())
      {
        localItemUiData.mnG = paramInt;
        if ((localc instanceof c.e)) {
          localItemUiData.mnH = ((c.e)localc).msJ;
        }
        localArrayList.add(localItemUiData);
        break label56;
        i = SubscribeMsgRequestDialogUiData.bsp();
        break;
        label175:
        if (paramInt == 3)
        {
          paramInt = SubscribeMsgRequestDialogUiData.bsn();
          break label43;
        }
        paramInt = SubscribeMsgRequestDialogUiData.bsm();
        break label43;
        label194:
        localObject = SubscribeMsgRequestDialogUiData.ItemUiData.mnK;
      }
      label206:
      AppMethodBeat.o(149531);
      return localSubscribeMsgRequestDialogUiData;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "wxbiz-msgsubscription-sdk_release"})
  public static final class b
    implements Parcelable.Creator<SubscribeMsgRequestDialogUiData>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData
 * JD-Core Version:    0.7.0.1
 */