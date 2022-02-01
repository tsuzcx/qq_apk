package com.tencent.mm.msgsubscription;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.czv;
import d.l;
import d.o;
import d.v;
import java.io.InvalidClassException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Landroid/os/Parcelable;", "title", "", "templateId", "templateType", "", "chooseStatus", "keyWordList", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Lkotlin/collections/ArrayList;", "settingStatus", "isOpened", "", "sceneDesc", "wxaSubscribeStatusString", "isBaned", "tid", "(Ljava/lang/String;Ljava/lang/String;IILjava/util/ArrayList;IZLjava/lang/String;Ljava/lang/String;ZI)V", "item", "Lcom/tencent/mm/protocal/protobuf/SubscribeMsgItem;", "(Lcom/tencent/mm/protocal/protobuf/SubscribeMsgItem;Ljava/util/ArrayList;)V", "(Ljava/lang/String;Ljava/lang/String;IILjava/util/ArrayList;IZLjava/lang/String;)V", "switchOpened", "(Ljava/lang/String;IIZ)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getChooseStatus", "()I", "setChooseStatus", "(I)V", "()Z", "isFromProfile", "setFromProfile", "(Z)V", "isOpen", "setOpen", "getKeyWordList", "()Ljava/util/ArrayList;", "getSceneDesc", "()Ljava/lang/String;", "getSettingStatus", "setSettingStatus", "getTemplateId", "templateType$annotations", "()V", "getTemplateType", "getTid", "getTitle", "updateTimestamp", "", "getUpdateTimestamp", "()J", "setUpdateTimestamp", "(J)V", "getWxaSubscribeStatusString", "describeContents", "toString", "writeToParcel", "", "dest", "flags", "Companion", "wxbiz-msgsubscription-sdk_release"})
public final class SubscribeMsgTmpItem
  implements Parcelable
{
  public static final Parcelable.Creator<SubscribeMsgTmpItem> CREATOR;
  public static final SubscribeMsgTmpItem.a hGB;
  public boolean SE;
  public final String gIj;
  public int hFZ;
  public final boolean hGA;
  public final String hGt;
  public final int hGu;
  public final ArrayList<o<String, String>> hGv;
  public int hGw;
  public long hGx;
  public boolean hGy;
  public final String hGz;
  public final int tid;
  public final String title;
  
  static
  {
    AppMethodBeat.i(149554);
    hGB = new SubscribeMsgTmpItem.a((byte)0);
    CREATOR = (Parcelable.Creator)new SubscribeMsgTmpItem.b();
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
    this.gIj = ((String)localObject1);
    this.hGu = paramParcel.readInt();
    this.hFZ = paramParcel.readInt();
    int i = paramParcel.readInt();
    this.hGv = new ArrayList(i);
    label160:
    Object localObject2;
    if (i != 0)
    {
      try
      {
        localObject1 = this.hGv;
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
      this.hGw = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label285;
      }
      bool1 = true;
      this.SE = bool1;
      this.hGx = paramParcel.readLong();
      localObject3 = paramParcel.readString();
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      this.hGt = ((String)localObject2);
      if (paramParcel.readByte() == 0) {
        break label290;
      }
      bool1 = true;
      label207:
      this.hGy = bool1;
      localObject3 = paramParcel.readString();
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      this.hGz = ((String)localObject2);
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
      this.hGA = bool1;
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
  
  public SubscribeMsgTmpItem(czv paramczv, ArrayList<o<String, String>> paramArrayList) {}
  
  public SubscribeMsgTmpItem(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(149552);
    this.title = "";
    this.gIj = paramString;
    this.hGu = paramInt1;
    this.hFZ = -1;
    this.hGw = paramInt2;
    this.hGv = new ArrayList();
    this.SE = paramBoolean;
    this.hGx = 0L;
    this.hGt = "";
    this.hGy = false;
    this.hGz = "";
    this.tid = -1;
    this.hGA = false;
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
    this.gIj = paramString2;
    this.hGu = paramInt1;
    this.hFZ = paramInt2;
    this.hGv = paramArrayList;
    this.hGw = paramInt3;
    this.SE = paramBoolean1;
    this.hGx = 0L;
    this.hGt = paramString3;
    this.hGy = false;
    this.hGz = paramString4;
    this.tid = paramInt4;
    this.hGA = paramBoolean2;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(149549);
    String str = "SubscribeMsgTmpItem(title='" + this.title + "', templateId='" + this.gIj + "', templateType=" + this.hGu + ", chooseStatus=" + this.hFZ + ", settingStatus=" + this.hGw + ", settingStatus=" + this.hGw + ", CREATOR=" + CREATOR + ')';
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
      paramParcel.writeString(this.gIj);
    }
    if (paramParcel != null) {
      paramParcel.writeInt(this.hGu);
    }
    if (paramParcel != null) {
      paramParcel.writeInt(this.hFZ);
    }
    if (paramParcel != null) {
      paramParcel.writeInt(this.hGv.size());
    }
    Iterator localIterator = ((Iterable)this.hGv).iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      if (paramParcel != null) {
        paramParcel.writeSerializable((Serializable)localo);
      }
    }
    if (paramParcel != null) {
      paramParcel.writeInt(this.hGw);
    }
    byte b;
    if (paramParcel != null)
    {
      if (this.SE)
      {
        b = 1;
        paramParcel.writeByte(b);
      }
    }
    else
    {
      if (paramParcel != null) {
        paramParcel.writeLong(this.hGx);
      }
      if (paramParcel != null) {
        paramParcel.writeString(this.hGt);
      }
      if (paramParcel != null)
      {
        if (!this.hGy) {
          break label247;
        }
        b = 1;
        label190:
        paramParcel.writeByte(b);
      }
      if (paramParcel != null) {
        paramParcel.writeString(this.hGz);
      }
      if (paramParcel != null) {
        paramParcel.writeInt(this.tid);
      }
      if (paramParcel == null) {
        break label257;
      }
      if (!this.hGA) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.SubscribeMsgTmpItem
 * JD-Core Version:    0.7.0.1
 */