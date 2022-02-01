package com.tencent.mm.msgsubscription;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dku;
import d.l;
import d.o;
import d.v;
import java.io.InvalidClassException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Landroid/os/Parcelable;", "title", "", "templateId", "templateType", "", "chooseStatus", "keyWordList", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Lkotlin/collections/ArrayList;", "settingStatus", "isOpened", "", "sceneDesc", "wxaSubscribeStatusString", "isBaned", "tid", "(Ljava/lang/String;Ljava/lang/String;IILjava/util/ArrayList;IZLjava/lang/String;Ljava/lang/String;ZI)V", "item", "Lcom/tencent/mm/protocal/protobuf/SubscribeMsgItem;", "(Lcom/tencent/mm/protocal/protobuf/SubscribeMsgItem;Ljava/util/ArrayList;)V", "(Ljava/lang/String;Ljava/lang/String;IILjava/util/ArrayList;IZLjava/lang/String;)V", "switchOpened", "(Ljava/lang/String;IIZ)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getChooseStatus", "()I", "setChooseStatus", "(I)V", "()Z", "isFromProfile", "setFromProfile", "(Z)V", "isOpen", "setOpen", "getKeyWordList", "()Ljava/util/ArrayList;", "getSceneDesc", "()Ljava/lang/String;", "getSettingStatus", "setSettingStatus", "getTemplateId", "templateType$annotations", "()V", "getTemplateType", "getTid", "getTitle", "updateTimestamp", "", "getUpdateTimestamp", "()J", "setUpdateTimestamp", "(J)V", "getWxaSubscribeStatusString", "describeContents", "toString", "writeToParcel", "", "dest", "flags", "Companion", "wxbiz-msgsubscription-sdk_release"})
public final class SubscribeMsgTmpItem
  implements Parcelable
{
  public static final Parcelable.Creator<SubscribeMsgTmpItem> CREATOR;
  public static final a iAx;
  public boolean Vp;
  public final String hAT;
  public final String iAp;
  public final int iAq;
  public final ArrayList<o<String, String>> iAr;
  public int iAs;
  public long iAt;
  public boolean iAu;
  public final String iAv;
  public final boolean iAw;
  public int izV;
  public final int tid;
  public final String title;
  
  static
  {
    AppMethodBeat.i(149554);
    iAx = new a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(149554);
  }
  
  public SubscribeMsgTmpItem(Parcel paramParcel)
  {
    AppMethodBeat.i(149553);
    Object localObject3 = paramParcel.readString();
    Object localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = "";
    }
    this.title = ((String)localObject1);
    localObject3 = paramParcel.readString();
    localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = "";
    }
    this.hAT = ((String)localObject1);
    this.iAq = paramParcel.readInt();
    this.izV = paramParcel.readInt();
    int i = paramParcel.readInt();
    this.iAr = new ArrayList(i);
    label160:
    Object localObject2;
    if (i != 0)
    {
      try
      {
        localObject1 = this.iAr;
        localObject3 = paramParcel.readSerializable();
        if (localObject3 != null) {
          break label267;
        }
        localObject1 = new v("null cannot be cast to non-null type kotlin.Pair<kotlin.String, kotlin.String>");
        AppMethodBeat.o(149553);
        throw ((Throwable)localObject1);
      }
      catch (InvalidClassException localInvalidClassException) {}
    }
    else
    {
      this.iAs = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label285;
      }
      bool1 = true;
      this.Vp = bool1;
      this.iAt = paramParcel.readLong();
      localObject3 = paramParcel.readString();
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      this.iAp = ((String)localObject2);
      if (paramParcel.readByte() == 0) {
        break label290;
      }
      bool1 = true;
      label207:
      this.iAu = bool1;
      localObject3 = paramParcel.readString();
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      this.iAv = ((String)localObject2);
      this.tid = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label295;
      }
    }
    label267:
    label285:
    label290:
    label295:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.iAw = bool1;
      AppMethodBeat.o(149553);
      return;
      ((ArrayList)localObject2).add((o)localObject3);
      i -= 1;
      break;
      bool1 = false;
      break label160;
      bool1 = false;
      break label207;
    }
  }
  
  public SubscribeMsgTmpItem(dku paramdku, ArrayList<o<String, String>> paramArrayList) {}
  
  public SubscribeMsgTmpItem(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(149552);
    this.title = "";
    this.hAT = paramString;
    this.iAq = paramInt1;
    this.izV = -1;
    this.iAs = paramInt2;
    this.iAr = new ArrayList();
    this.Vp = paramBoolean;
    this.iAt = 0L;
    this.iAp = "";
    this.iAu = false;
    this.iAv = "";
    this.tid = -1;
    this.iAw = false;
    AppMethodBeat.o(149552);
  }
  
  public SubscribeMsgTmpItem(String paramString1, String paramString2, int paramInt1, int paramInt2, ArrayList<o<String, String>> paramArrayList, int paramInt3, boolean paramBoolean, String paramString3)
  {
    this(paramString1, paramString2, paramInt1, paramInt2, paramArrayList, paramInt3, paramBoolean, paramString3, "");
    AppMethodBeat.i(149551);
    AppMethodBeat.o(149551);
  }
  
  private SubscribeMsgTmpItem(String paramString1, String paramString2, int paramInt1, int paramInt2, ArrayList<o<String, String>> paramArrayList, int paramInt3, boolean paramBoolean1, String paramString3, String paramString4, boolean paramBoolean2, int paramInt4)
  {
    this.title = paramString1;
    this.hAT = paramString2;
    this.iAq = paramInt1;
    this.izV = paramInt2;
    this.iAr = paramArrayList;
    this.iAs = paramInt3;
    this.Vp = paramBoolean1;
    this.iAt = 0L;
    this.iAp = paramString3;
    this.iAu = false;
    this.iAv = paramString4;
    this.tid = paramInt4;
    this.iAw = paramBoolean2;
  }
  
  public final int aOp()
  {
    return this.iAs;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(149549);
    String str = "SubscribeMsgTmpItem(title='" + this.title + "', templateId='" + this.hAT + "', templateType=" + this.iAq + ", chooseStatus=" + this.izV + ", settingStatus=" + this.iAs + ", settingStatus=" + this.iAs + ", CREATOR=" + CREATOR + ')';
    AppMethodBeat.o(149549);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = 1;
    AppMethodBeat.i(149548);
    if (paramParcel != null) {
      paramParcel.writeString(this.title);
    }
    if (paramParcel != null) {
      paramParcel.writeString(this.hAT);
    }
    if (paramParcel != null) {
      paramParcel.writeInt(this.iAq);
    }
    if (paramParcel != null) {
      paramParcel.writeInt(this.izV);
    }
    if (paramParcel != null) {
      paramParcel.writeInt(this.iAr.size());
    }
    Iterator localIterator = ((Iterable)this.iAr).iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      if (paramParcel != null) {
        paramParcel.writeSerializable((Serializable)localo);
      }
    }
    if (paramParcel != null) {
      paramParcel.writeInt(this.iAs);
    }
    byte b;
    if (paramParcel != null)
    {
      if (this.Vp)
      {
        b = 1;
        paramParcel.writeByte(b);
      }
    }
    else
    {
      if (paramParcel != null) {
        paramParcel.writeLong(this.iAt);
      }
      if (paramParcel != null) {
        paramParcel.writeString(this.iAp);
      }
      if (paramParcel != null)
      {
        if (!this.iAu) {
          break label247;
        }
        b = 1;
        label190:
        paramParcel.writeByte(b);
      }
      if (paramParcel != null) {
        paramParcel.writeString(this.iAv);
      }
      if (paramParcel != null) {
        paramParcel.writeInt(this.tid);
      }
      if (paramParcel == null) {
        break label257;
      }
      if (!this.iAw) {
        break label252;
      }
    }
    for (;;)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(149548);
      return;
      b = 0;
      break;
      label247:
      b = 0;
      break label190;
      label252:
      paramInt = 0;
    }
    label257:
    AppMethodBeat.o(149548);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem$Companion;", "", "()V", "CHOOSE_STATUS_CHECKED", "", "CHOOSE_STATUS_UNCHECK", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "OP_ALWAYS_ALLOW", "OP_ALWAYS_REJECT", "OP_DEFAULT", "SHOW_STYLE_LIST", "SHOW_STYLE_SINGLE", "STATUS_SUBSCRIBED", "STATUS_UNSUBSCRIBED", "TYPE_TMPL_FOREVER", "TYPE_TMPL_ONCE", "OpType", "SubscribeStatus", "TMPL_TYPE", "wxbiz-msgsubscription-sdk_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/msgsubscription/SubscribeMsgTmpItem$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "wxbiz-msgsubscription-sdk_release"})
  public static final class b
    implements Parcelable.Creator<SubscribeMsgTmpItem>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.SubscribeMsgTmpItem
 * JD-Core Version:    0.7.0.1
 */