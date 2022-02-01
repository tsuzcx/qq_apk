package com.tencent.mm.msgsubscription;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.ui.f.c;
import com.tencent.mm.msgsubscription.ui.f.e;
import com.tencent.mm.msgsubscription.ui.f.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "isAlways", "", "()I", "setAlways", "(I)V", "opType", "getOpType", "setOpType", "uIItem", "Ljava/util/ArrayList;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData;", "Lkotlin/collections/ArrayList;", "getUIItem", "()Ljava/util/ArrayList;", "setUIItem", "(Ljava/util/ArrayList;)V", "describeContents", "writeToParcel", "", "flags", "Companion", "ItemUiData", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SubscribeMsgRequestDialogUiData
  implements Parcelable
{
  public static final Parcelable.Creator<SubscribeMsgRequestDialogUiData> CREATOR;
  public static final a phj;
  private static final int phm = 0;
  private static final int phn;
  private static final int pho;
  private static final int php;
  private static final int phq;
  private static final int phr = 0;
  public int opType;
  public int phk;
  public ArrayList<ItemUiData> phl;
  
  static
  {
    AppMethodBeat.i(149539);
    phj = new a((byte)0);
    phn = 1;
    pho = 2;
    php = 3;
    phq = 1;
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(149539);
  }
  
  public SubscribeMsgRequestDialogUiData()
  {
    AppMethodBeat.i(149537);
    this.opType = phm;
    this.phl = new ArrayList();
    AppMethodBeat.o(149537);
  }
  
  public SubscribeMsgRequestDialogUiData(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(149538);
    this.opType = paramParcel.readInt();
    this.phk = paramParcel.readInt();
    ArrayList localArrayList = new ArrayList();
    paramParcel.readList((List)localArrayList, ItemUiData.class.getClassLoader());
    paramParcel = ah.aiuX;
    this.phl = localArrayList;
    AppMethodBeat.o(149538);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(149536);
    s.u(paramParcel, "parcel");
    paramParcel.writeInt(this.opType);
    paramParcel.writeInt(this.phk);
    paramParcel.writeList((List)this.phl);
    AppMethodBeat.o(149536);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "chooseStatus", "", "getChooseStatus", "()I", "setChooseStatus", "(I)V", "forceNotify", "", "getForceNotify", "()Z", "setForceNotify", "(Z)V", "isAcceptWithAudio", "setAcceptWithAudio", "templateId", "", "getTemplateId", "()Ljava/lang/String;", "setTemplateId", "(Ljava/lang/String;)V", "describeContents", "writeToParcel", "", "flags", "Companion", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class ItemUiData
    implements Parcelable
  {
    public static final Parcelable.Creator<ItemUiData> CREATOR;
    public static final SubscribeMsgRequestDialogUiData.ItemUiData.a phs;
    private static final int phw;
    private static final int phx = 0;
    public String nSg = "";
    public int pht;
    public boolean phu;
    public boolean phv;
    
    static
    {
      AppMethodBeat.i(149535);
      phs = new SubscribeMsgRequestDialogUiData.ItemUiData.a((byte)0);
      phw = 1;
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
      this.nSg = str1;
      this.pht = paramParcel.readInt();
      if (paramParcel.readInt() == 1)
      {
        bool1 = true;
        this.phu = bool1;
        if (paramParcel.readInt() != 0) {
          break label90;
        }
      }
      label90:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.phv = bool1;
        AppMethodBeat.o(149534);
        return;
        bool1 = false;
        break;
      }
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(149533);
      s.u(paramParcel, "parcel");
      paramParcel.writeString(this.nSg);
      paramParcel.writeInt(this.pht);
      if (this.phu)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        if (!this.phv) {
          break label68;
        }
      }
      label68:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(149533);
        return;
        paramInt = 0;
        break;
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData;", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements Parcelable.Creator<SubscribeMsgRequestDialogUiData.ItemUiData>
    {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "IS_ALWAYS_NO", "", "getIS_ALWAYS_NO", "()I", "IS_ALWAYS_YES", "getIS_ALWAYS_YES", "OP_TYPE_CANCEL", "getOP_TYPE_CANCEL", "OP_TYPE_CONFIRM", "getOP_TYPE_CONFIRM", "OP_TYPE_NONE", "getOP_TYPE_NONE", "OP_TYPE_REJECT", "getOP_TYPE_REJECT", "build", "event", "itemsShowOnDialog", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "isAlwaysCbCheck", "", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static SubscribeMsgRequestDialogUiData o(int paramInt, List<f.c> paramList, boolean paramBoolean)
    {
      AppMethodBeat.i(149531);
      s.u(paramList, "itemsShowOnDialog");
      SubscribeMsgRequestDialogUiData localSubscribeMsgRequestDialogUiData = new SubscribeMsgRequestDialogUiData();
      int i;
      label64:
      label77:
      Object localObject1;
      ArrayList localArrayList;
      SubscribeMsgRequestDialogUiData.ItemUiData localItemUiData;
      Object localObject2;
      if (paramBoolean)
      {
        i = SubscribeMsgRequestDialogUiData.bPU();
        localSubscribeMsgRequestDialogUiData.phk = i;
        switch (paramInt)
        {
        case 2: 
        default: 
          paramInt = SubscribeMsgRequestDialogUiData.bPS();
          localSubscribeMsgRequestDialogUiData.opType = paramInt;
          paramList = paramList.iterator();
          if (!paramList.hasNext()) {
            break label251;
          }
          localObject1 = (f.c)paramList.next();
          localArrayList = localSubscribeMsgRequestDialogUiData.phl;
          localItemUiData = new SubscribeMsgRequestDialogUiData.ItemUiData();
          localObject2 = ((f.c)localObject1).nSg;
          s.u(localObject2, "<set-?>");
          localItemUiData.nSg = ((String)localObject2);
          if (((f.c)localObject1).plZ)
          {
            localObject2 = SubscribeMsgRequestDialogUiData.ItemUiData.phs;
            paramInt = SubscribeMsgRequestDialogUiData.ItemUiData.bPW();
            label151:
            localItemUiData.pht = paramInt;
            if (!(localObject1 instanceof f.f)) {
              break label227;
            }
            localItemUiData.phu = ((f.f)localObject1).pmk;
          }
          break;
        }
      }
      for (;;)
      {
        localObject1 = ah.aiuX;
        localArrayList.add(localItemUiData);
        break label77;
        i = SubscribeMsgRequestDialogUiData.bPV();
        break;
        paramInt = SubscribeMsgRequestDialogUiData.bPR();
        break label64;
        paramInt = SubscribeMsgRequestDialogUiData.bPT();
        break label64;
        localObject2 = SubscribeMsgRequestDialogUiData.ItemUiData.phs;
        paramInt = SubscribeMsgRequestDialogUiData.ItemUiData.bPX();
        break label151;
        label227:
        if ((localObject1 instanceof f.e)) {
          localItemUiData.phv = ((f.e)localObject1).phv;
        }
      }
      label251:
      AppMethodBeat.o(149531);
      return localSubscribeMsgRequestDialogUiData;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<SubscribeMsgRequestDialogUiData>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData
 * JD-Core Version:    0.7.0.1
 */