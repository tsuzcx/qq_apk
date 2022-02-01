package com.tencent.mm.msgsubscription;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fkc;
import java.io.InvalidClassException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Landroid/os/Parcelable;", "title", "", "templateId", "templateType", "", "chooseStatus", "keyWordList", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Lkotlin/collections/ArrayList;", "settingStatus", "isOpened", "", "sceneDesc", "wxaSubscribeStatusString", "isBaned", "tid", "IsAudioTemplate", "IsAcceptWithAudio", "audioTemplateUrl", "isForceNotifyTemplate", "isAcceptWithForceNotify", "(Ljava/lang/String;Ljava/lang/String;IILjava/util/ArrayList;IZLjava/lang/String;Ljava/lang/String;ZIZZLjava/lang/String;ZZ)V", "item", "Lcom/tencent/mm/protocal/protobuf/SubscribeMsgItem;", "(Lcom/tencent/mm/protocal/protobuf/SubscribeMsgItem;Ljava/util/ArrayList;)V", "(Ljava/lang/String;Ljava/lang/String;IILjava/util/ArrayList;IZLjava/lang/String;)V", "switchOpened", "(Ljava/lang/String;IIZ)V", "timestamp", "", "(Ljava/lang/String;J)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAudioTemplateUrl", "()Ljava/lang/String;", "getChooseStatus", "()I", "setChooseStatus", "(I)V", "isAcceptWithAudio", "()Z", "setAcceptWithAudio", "(Z)V", "setAcceptWithForceNotify", "isAudioTemplate", "isFromProfile", "setFromProfile", "isOpen", "setOpen", "getKeyWordList", "()Ljava/util/ArrayList;", "getSceneDesc", "getSettingStatus", "setSettingStatus", "getTemplateId", "getTemplateType$annotations", "()V", "getTemplateType", "getTid", "getTitle", "updateTimestamp", "getUpdateTimestamp", "()J", "setUpdateTimestamp", "(J)V", "getWxaSubscribeStatusString", "describeContents", "toString", "writeToParcel", "", "dest", "flags", "Companion", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SubscribeMsgTmpItem
  implements Parcelable
{
  public static final Parcelable.Creator<SubscribeMsgTmpItem> CREATOR;
  public static final SubscribeMsgTmpItem.a phP;
  public boolean hU;
  public final String nSg;
  public final String phQ;
  public final int phR;
  public final ArrayList<r<String, String>> phS;
  public int phT;
  public long phU;
  public boolean phV;
  public final String phW;
  public final boolean phX;
  public final boolean phY;
  public final String phZ;
  public int pht;
  public boolean phu;
  public final boolean pia;
  public boolean pib;
  public final int tid;
  public final String title;
  
  static
  {
    AppMethodBeat.i(149554);
    phP = new SubscribeMsgTmpItem.a((byte)0);
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
    this.nSg = ((String)localObject1);
    this.phR = paramParcel.readInt();
    this.pht = paramParcel.readInt();
    int i = paramParcel.readInt();
    this.phS = new ArrayList(i);
    label160:
    Object localObject2;
    if (i != 0)
    {
      try
      {
        localObject1 = this.phS;
        localObject3 = paramParcel.readSerializable();
        if (localObject3 != null) {
          break label352;
        }
        localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.Pair<kotlin.String, kotlin.String>");
        AppMethodBeat.o(149553);
        throw ((Throwable)localObject1);
      }
      catch (InvalidClassException localInvalidClassException) {}
    }
    else
    {
      this.phT = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label370;
      }
      bool1 = true;
      this.hU = bool1;
      this.phU = paramParcel.readLong();
      localObject3 = paramParcel.readString();
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      this.phQ = ((String)localObject2);
      if (paramParcel.readByte() == 0) {
        break label375;
      }
      bool1 = true;
      label207:
      this.phV = bool1;
      localObject3 = paramParcel.readString();
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      this.phW = ((String)localObject2);
      this.tid = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label380;
      }
      bool1 = true;
      label255:
      this.phX = bool1;
      if (paramParcel.readInt() != 1) {
        break label385;
      }
      bool1 = true;
      label270:
      this.phY = bool1;
      if (paramParcel.readInt() != 1) {
        break label390;
      }
      bool1 = true;
      label285:
      this.phu = bool1;
      localObject3 = paramParcel.readString();
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      this.phZ = ((String)localObject2);
      if (paramParcel.readInt() != 1) {
        break label395;
      }
      bool1 = true;
      label325:
      this.pia = bool1;
      if (paramParcel.readInt() != 1) {
        break label400;
      }
    }
    label385:
    label390:
    label395:
    label400:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.pib = bool1;
      AppMethodBeat.o(149553);
      return;
      label352:
      ((ArrayList)localObject2).add((r)localObject3);
      i -= 1;
      break;
      label370:
      bool1 = false;
      break label160;
      label375:
      bool1 = false;
      break label207;
      label380:
      bool1 = false;
      break label255;
      bool1 = false;
      break label270;
      bool1 = false;
      break label285;
      bool1 = false;
      break label325;
    }
  }
  
  public SubscribeMsgTmpItem(fkc paramfkc, ArrayList<r<String, String>> paramArrayList) {}
  
  public SubscribeMsgTmpItem(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(149552);
    this.title = "";
    this.nSg = paramString;
    this.phR = paramInt1;
    this.pht = -1;
    this.phT = paramInt2;
    this.phS = new ArrayList();
    this.hU = paramBoolean;
    this.phU = 0L;
    this.phQ = "";
    this.phV = false;
    this.phW = "";
    this.tid = -1;
    this.phX = false;
    this.phY = false;
    this.phu = false;
    this.phZ = "";
    this.pia = false;
    this.pib = false;
    AppMethodBeat.o(149552);
  }
  
  public SubscribeMsgTmpItem(String paramString, long paramLong)
  {
    this(paramString, 0, 0, false);
    AppMethodBeat.i(236262);
    this.phU = paramLong;
    AppMethodBeat.o(236262);
  }
  
  public SubscribeMsgTmpItem(String paramString1, String paramString2, int paramInt1, int paramInt2, ArrayList<r<String, String>> paramArrayList, int paramInt3, boolean paramBoolean, String paramString3)
  {
    this(paramString1, paramString2, paramInt1, paramInt2, paramArrayList, paramInt3, paramBoolean, paramString3, "");
    AppMethodBeat.i(149551);
    AppMethodBeat.o(149551);
  }
  
  private SubscribeMsgTmpItem(String paramString1, String paramString2, int paramInt1, int paramInt2, ArrayList<r<String, String>> paramArrayList, int paramInt3, boolean paramBoolean1, String paramString3, String paramString4, boolean paramBoolean2, int paramInt4, boolean paramBoolean3, boolean paramBoolean4, String paramString5, boolean paramBoolean5, boolean paramBoolean6)
  {
    this.title = paramString1;
    this.nSg = paramString2;
    this.phR = paramInt1;
    this.pht = paramInt2;
    this.phS = paramArrayList;
    this.phT = paramInt3;
    this.hU = paramBoolean1;
    this.phU = 0L;
    this.phQ = paramString3;
    this.phV = false;
    this.phW = paramString4;
    this.tid = paramInt4;
    this.phX = paramBoolean2;
    this.phY = paramBoolean3;
    this.phu = paramBoolean4;
    this.phZ = paramString5;
    this.pia = paramBoolean5;
    this.pib = paramBoolean6;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(149549);
    String str = "SubscribeMsgTmpItem(title='" + this.title + "', templateId='" + this.nSg + "', templateType=" + this.phR + ", chooseStatus=" + this.pht + ", settingStatus=" + this.phT + ", settingStatus=" + this.phT + ", CREATOR=" + CREATOR + ')';
    AppMethodBeat.o(149549);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(149548);
    if (paramParcel != null) {
      paramParcel.writeString(this.title);
    }
    if (paramParcel != null) {
      paramParcel.writeString(this.nSg);
    }
    if (paramParcel != null) {
      paramParcel.writeInt(this.phR);
    }
    if (paramParcel != null) {
      paramParcel.writeInt(this.pht);
    }
    if (paramParcel != null) {
      paramParcel.writeInt(this.phS.size());
    }
    Iterator localIterator = ((Iterable)this.phS).iterator();
    while (localIterator.hasNext())
    {
      r localr = (r)localIterator.next();
      if (paramParcel != null) {
        paramParcel.writeSerializable((Serializable)localr);
      }
    }
    if (paramParcel != null) {
      paramParcel.writeInt(this.phT);
    }
    byte b;
    if (paramParcel != null)
    {
      if (this.hU)
      {
        b = 1;
        paramParcel.writeByte(b);
      }
    }
    else
    {
      if (paramParcel != null) {
        paramParcel.writeLong(this.phU);
      }
      if (paramParcel != null) {
        paramParcel.writeString(this.phQ);
      }
      if (paramParcel != null)
      {
        if (!this.phV) {
          break label335;
        }
        b = 1;
        label191:
        paramParcel.writeByte(b);
      }
      if (paramParcel != null) {
        paramParcel.writeString(this.phW);
      }
      if (paramParcel != null) {
        paramParcel.writeInt(this.tid);
      }
      if (paramParcel != null)
      {
        if (!this.phX) {
          break label340;
        }
        paramInt = 1;
        label233:
        paramParcel.writeInt(paramInt);
      }
      if (paramParcel != null)
      {
        if (!this.phY) {
          break label345;
        }
        paramInt = 1;
        label251:
        paramParcel.writeInt(paramInt);
      }
      if (paramParcel != null)
      {
        if (!this.phu) {
          break label350;
        }
        paramInt = 1;
        label269:
        paramParcel.writeInt(paramInt);
      }
      if (paramParcel != null) {
        paramParcel.writeString(this.phZ);
      }
      if (paramParcel != null)
      {
        if (!this.pia) {
          break label355;
        }
        paramInt = 1;
        label299:
        paramParcel.writeInt(paramInt);
      }
      if (paramParcel != null) {
        if (!this.pib) {
          break label360;
        }
      }
    }
    label335:
    label340:
    label345:
    label350:
    label355:
    label360:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(149548);
      return;
      b = 0;
      break;
      b = 0;
      break label191;
      paramInt = 0;
      break label233;
      paramInt = 0;
      break label251;
      paramInt = 0;
      break label269;
      paramInt = 0;
      break label299;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/msgsubscription/SubscribeMsgTmpItem$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<SubscribeMsgTmpItem>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.SubscribeMsgTmpItem
 * JD-Core Version:    0.7.0.1
 */