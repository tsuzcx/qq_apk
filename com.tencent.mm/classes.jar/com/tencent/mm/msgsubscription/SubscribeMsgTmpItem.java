package com.tencent.mm.msgsubscription;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.efc;
import java.io.InvalidClassException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.l;
import kotlin.o;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Landroid/os/Parcelable;", "title", "", "templateId", "templateType", "", "chooseStatus", "keyWordList", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Lkotlin/collections/ArrayList;", "settingStatus", "isOpened", "", "sceneDesc", "wxaSubscribeStatusString", "isBaned", "tid", "(Ljava/lang/String;Ljava/lang/String;IILjava/util/ArrayList;IZLjava/lang/String;Ljava/lang/String;ZI)V", "item", "Lcom/tencent/mm/protocal/protobuf/SubscribeMsgItem;", "(Lcom/tencent/mm/protocal/protobuf/SubscribeMsgItem;Ljava/util/ArrayList;)V", "(Ljava/lang/String;Ljava/lang/String;IILjava/util/ArrayList;IZLjava/lang/String;)V", "switchOpened", "(Ljava/lang/String;IIZ)V", "timestamp", "", "(Ljava/lang/String;J)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getChooseStatus", "()I", "setChooseStatus", "(I)V", "()Z", "isFromProfile", "setFromProfile", "(Z)V", "isOpen", "setOpen", "getKeyWordList", "()Ljava/util/ArrayList;", "getSceneDesc", "()Ljava/lang/String;", "getSettingStatus", "setSettingStatus", "getTemplateId", "templateType$annotations", "()V", "getTemplateType", "getTid", "getTitle", "updateTimestamp", "getUpdateTimestamp", "()J", "setUpdateTimestamp", "(J)V", "getWxaSubscribeStatusString", "describeContents", "toString", "writeToParcel", "", "dest", "flags", "Companion", "wxbiz-msgsubscription-sdk_release"})
public final class SubscribeMsgTmpItem
  implements Parcelable
{
  public static final Parcelable.Creator<SubscribeMsgTmpItem> CREATOR;
  public static final SubscribeMsgTmpItem.a jyG;
  public boolean VC;
  public final String ixM;
  public final ArrayList<o<String, String>> jyA;
  public int jyB;
  public long jyC;
  public boolean jyD;
  public final String jyE;
  public final boolean jyF;
  public int jyd;
  public final String jyy;
  public final int jyz;
  public final int tid;
  public final String title;
  
  static
  {
    AppMethodBeat.i(149554);
    jyG = new SubscribeMsgTmpItem.a((byte)0);
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
    this.ixM = ((String)localObject1);
    this.jyz = paramParcel.readInt();
    this.jyd = paramParcel.readInt();
    int i = paramParcel.readInt();
    this.jyA = new ArrayList(i);
    label160:
    Object localObject2;
    if (i != 0)
    {
      try
      {
        localObject1 = this.jyA;
        localObject3 = paramParcel.readSerializable();
        if (localObject3 != null) {
          break label267;
        }
        localObject1 = new t("null cannot be cast to non-null type kotlin.Pair<kotlin.String, kotlin.String>");
        AppMethodBeat.o(149553);
        throw ((Throwable)localObject1);
      }
      catch (InvalidClassException localInvalidClassException) {}
    }
    else
    {
      this.jyB = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label285;
      }
      bool1 = true;
      this.VC = bool1;
      this.jyC = paramParcel.readLong();
      localObject3 = paramParcel.readString();
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      this.jyy = ((String)localObject2);
      if (paramParcel.readByte() == 0) {
        break label290;
      }
      bool1 = true;
      label207:
      this.jyD = bool1;
      localObject3 = paramParcel.readString();
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      this.jyE = ((String)localObject2);
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
      this.jyF = bool1;
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
  
  public SubscribeMsgTmpItem(efc paramefc, ArrayList<o<String, String>> paramArrayList) {}
  
  public SubscribeMsgTmpItem(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(149552);
    this.title = "";
    this.ixM = paramString;
    this.jyz = paramInt1;
    this.jyd = -1;
    this.jyB = paramInt2;
    this.jyA = new ArrayList();
    this.VC = paramBoolean;
    this.jyC = 0L;
    this.jyy = "";
    this.jyD = false;
    this.jyE = "";
    this.tid = -1;
    this.jyF = false;
    AppMethodBeat.o(149552);
  }
  
  public SubscribeMsgTmpItem(String paramString, long paramLong)
  {
    this(paramString, 0, 0, false);
    AppMethodBeat.i(194258);
    this.jyC = paramLong;
    AppMethodBeat.o(194258);
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
    this.ixM = paramString2;
    this.jyz = paramInt1;
    this.jyd = paramInt2;
    this.jyA = paramArrayList;
    this.jyB = paramInt3;
    this.VC = paramBoolean1;
    this.jyC = 0L;
    this.jyy = paramString3;
    this.jyD = false;
    this.jyE = paramString4;
    this.tid = paramInt4;
    this.jyF = paramBoolean2;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(149549);
    String str = "SubscribeMsgTmpItem(title='" + this.title + "', templateId='" + this.ixM + "', templateType=" + this.jyz + ", chooseStatus=" + this.jyd + ", settingStatus=" + this.jyB + ", settingStatus=" + this.jyB + ", CREATOR=" + CREATOR + ')';
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
      paramParcel.writeString(this.ixM);
    }
    if (paramParcel != null) {
      paramParcel.writeInt(this.jyz);
    }
    if (paramParcel != null) {
      paramParcel.writeInt(this.jyd);
    }
    if (paramParcel != null) {
      paramParcel.writeInt(this.jyA.size());
    }
    Iterator localIterator = ((Iterable)this.jyA).iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      if (paramParcel != null) {
        paramParcel.writeSerializable((Serializable)localo);
      }
    }
    if (paramParcel != null) {
      paramParcel.writeInt(this.jyB);
    }
    byte b;
    if (paramParcel != null)
    {
      if (this.VC)
      {
        b = 1;
        paramParcel.writeByte(b);
      }
    }
    else
    {
      if (paramParcel != null) {
        paramParcel.writeLong(this.jyC);
      }
      if (paramParcel != null) {
        paramParcel.writeString(this.jyy);
      }
      if (paramParcel != null)
      {
        if (!this.jyD) {
          break label247;
        }
        b = 1;
        label190:
        paramParcel.writeByte(b);
      }
      if (paramParcel != null) {
        paramParcel.writeString(this.jyE);
      }
      if (paramParcel != null) {
        paramParcel.writeInt(this.tid);
      }
      if (paramParcel == null) {
        break label257;
      }
      if (!this.jyF) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.SubscribeMsgTmpItem
 * JD-Core Version:    0.7.0.1
 */