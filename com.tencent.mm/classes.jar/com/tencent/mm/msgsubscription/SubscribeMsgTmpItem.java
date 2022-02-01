package com.tencent.mm.msgsubscription;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.epd;
import java.io.InvalidClassException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.l;
import kotlin.o;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Landroid/os/Parcelable;", "title", "", "templateId", "templateType", "", "chooseStatus", "keyWordList", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Lkotlin/collections/ArrayList;", "settingStatus", "isOpened", "", "sceneDesc", "wxaSubscribeStatusString", "isBaned", "tid", "IsAudioTemplate", "IsAcceptWithAudio", "audioTemplateUrl", "(Ljava/lang/String;Ljava/lang/String;IILjava/util/ArrayList;IZLjava/lang/String;Ljava/lang/String;ZIZZLjava/lang/String;)V", "item", "Lcom/tencent/mm/protocal/protobuf/SubscribeMsgItem;", "(Lcom/tencent/mm/protocal/protobuf/SubscribeMsgItem;Ljava/util/ArrayList;)V", "(Ljava/lang/String;Ljava/lang/String;IILjava/util/ArrayList;IZLjava/lang/String;)V", "switchOpened", "(Ljava/lang/String;IIZ)V", "timestamp", "", "(Ljava/lang/String;J)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAudioTemplateUrl", "()Ljava/lang/String;", "getChooseStatus", "()I", "setChooseStatus", "(I)V", "isAcceptWithAudio", "()Z", "setAcceptWithAudio", "(Z)V", "isAudioTemplate", "isFromProfile", "setFromProfile", "isOpen", "setOpen", "getKeyWordList", "()Ljava/util/ArrayList;", "getSceneDesc", "getSettingStatus", "setSettingStatus", "getTemplateId", "templateType$annotations", "()V", "getTemplateType", "getTid", "getTitle", "updateTimestamp", "getUpdateTimestamp", "()J", "setUpdateTimestamp", "(J)V", "getWxaSubscribeStatusString", "describeContents", "toString", "writeToParcel", "", "dest", "flags", "Companion", "wxbiz-msgsubscription-sdk_release"})
public final class SubscribeMsgTmpItem
  implements Parcelable
{
  public static final Parcelable.Creator<SubscribeMsgTmpItem> CREATOR;
  public static final SubscribeMsgTmpItem.a mom;
  public boolean gZ;
  public final String lnb;
  public int mnG;
  public boolean mnH;
  public final String moc;
  public final int mod;
  public final ArrayList<o<String, String>> moe;
  public int mof;
  public long mog;
  public boolean moh;
  public final String moi;
  public final boolean moj;
  public final boolean mok;
  public final String mol;
  public final int tid;
  public final String title;
  
  static
  {
    AppMethodBeat.i(149554);
    mom = new SubscribeMsgTmpItem.a((byte)0);
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
    this.lnb = ((String)localObject1);
    this.mod = paramParcel.readInt();
    this.mnG = paramParcel.readInt();
    int i = paramParcel.readInt();
    this.moe = new ArrayList(i);
    label160:
    Object localObject2;
    if (i != 0)
    {
      try
      {
        localObject1 = this.moe;
        localObject3 = paramParcel.readSerializable();
        if (localObject3 != null) {
          break label319;
        }
        localObject1 = new t("null cannot be cast to non-null type kotlin.Pair<kotlin.String, kotlin.String>");
        AppMethodBeat.o(149553);
        throw ((Throwable)localObject1);
      }
      catch (InvalidClassException localInvalidClassException) {}
    }
    else
    {
      this.mof = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label337;
      }
      bool1 = true;
      this.gZ = bool1;
      this.mog = paramParcel.readLong();
      localObject3 = paramParcel.readString();
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      this.moc = ((String)localObject2);
      if (paramParcel.readByte() == 0) {
        break label342;
      }
      bool1 = true;
      label207:
      this.moh = bool1;
      localObject3 = paramParcel.readString();
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      this.moi = ((String)localObject2);
      this.tid = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label347;
      }
      bool1 = true;
      label255:
      this.moj = bool1;
      if (paramParcel.readInt() != 1) {
        break label352;
      }
      bool1 = true;
      label270:
      this.mok = bool1;
      if (paramParcel.readInt() != 1) {
        break label357;
      }
    }
    label319:
    label337:
    label342:
    label347:
    label352:
    label357:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.mnH = bool1;
      localObject2 = paramParcel.readString();
      paramParcel = (Parcel)localObject2;
      if (localObject2 == null) {
        paramParcel = "";
      }
      this.mol = paramParcel;
      AppMethodBeat.o(149553);
      return;
      ((ArrayList)localObject2).add((o)localObject3);
      i -= 1;
      break;
      bool1 = false;
      break label160;
      bool1 = false;
      break label207;
      bool1 = false;
      break label255;
      bool1 = false;
      break label270;
    }
  }
  
  public SubscribeMsgTmpItem(epd paramepd, ArrayList<o<String, String>> paramArrayList) {}
  
  public SubscribeMsgTmpItem(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(149552);
    this.title = "";
    this.lnb = paramString;
    this.mod = paramInt1;
    this.mnG = -1;
    this.mof = paramInt2;
    this.moe = new ArrayList();
    this.gZ = paramBoolean;
    this.mog = 0L;
    this.moc = "";
    this.moh = false;
    this.moi = "";
    this.tid = -1;
    this.moj = false;
    this.mok = false;
    this.mnH = false;
    this.mol = "";
    AppMethodBeat.o(149552);
  }
  
  public SubscribeMsgTmpItem(String paramString, long paramLong)
  {
    this(paramString, 0, 0, false);
    AppMethodBeat.i(263623);
    this.mog = paramLong;
    AppMethodBeat.o(263623);
  }
  
  public SubscribeMsgTmpItem(String paramString1, String paramString2, int paramInt1, int paramInt2, ArrayList<o<String, String>> paramArrayList, int paramInt3, boolean paramBoolean, String paramString3)
  {
    this(paramString1, paramString2, paramInt1, paramInt2, paramArrayList, paramInt3, paramBoolean, paramString3, "");
    AppMethodBeat.i(149551);
    AppMethodBeat.o(149551);
  }
  
  private SubscribeMsgTmpItem(String paramString1, String paramString2, int paramInt1, int paramInt2, ArrayList<o<String, String>> paramArrayList, int paramInt3, boolean paramBoolean1, String paramString3, String paramString4, boolean paramBoolean2, int paramInt4, boolean paramBoolean3, boolean paramBoolean4, String paramString5)
  {
    this.title = paramString1;
    this.lnb = paramString2;
    this.mod = paramInt1;
    this.mnG = paramInt2;
    this.moe = paramArrayList;
    this.mof = paramInt3;
    this.gZ = paramBoolean1;
    this.mog = 0L;
    this.moc = paramString3;
    this.moh = false;
    this.moi = paramString4;
    this.tid = paramInt4;
    this.moj = paramBoolean2;
    this.mok = paramBoolean3;
    this.mnH = paramBoolean4;
    this.mol = paramString5;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(149549);
    String str = "SubscribeMsgTmpItem(title='" + this.title + "', templateId='" + this.lnb + "', templateType=" + this.mod + ", chooseStatus=" + this.mnG + ", settingStatus=" + this.mof + ", settingStatus=" + this.mof + ", CREATOR=" + CREATOR + ')';
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
      paramParcel.writeString(this.lnb);
    }
    if (paramParcel != null) {
      paramParcel.writeInt(this.mod);
    }
    if (paramParcel != null) {
      paramParcel.writeInt(this.mnG);
    }
    if (paramParcel != null) {
      paramParcel.writeInt(this.moe.size());
    }
    Iterator localIterator = ((Iterable)this.moe).iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      if (paramParcel != null) {
        paramParcel.writeSerializable((Serializable)localo);
      }
    }
    if (paramParcel != null) {
      paramParcel.writeInt(this.mof);
    }
    byte b;
    if (paramParcel != null)
    {
      if (this.gZ)
      {
        b = 1;
        paramParcel.writeByte(b);
      }
    }
    else
    {
      if (paramParcel != null) {
        paramParcel.writeLong(this.mog);
      }
      if (paramParcel != null) {
        paramParcel.writeString(this.moc);
      }
      if (paramParcel != null)
      {
        if (!this.moh) {
          break label299;
        }
        b = 1;
        label191:
        paramParcel.writeByte(b);
      }
      if (paramParcel != null) {
        paramParcel.writeString(this.moi);
      }
      if (paramParcel != null) {
        paramParcel.writeInt(this.tid);
      }
      if (paramParcel != null)
      {
        if (!this.moj) {
          break label304;
        }
        paramInt = 1;
        label233:
        paramParcel.writeInt(paramInt);
      }
      if (paramParcel != null)
      {
        if (!this.mok) {
          break label309;
        }
        paramInt = 1;
        label251:
        paramParcel.writeInt(paramInt);
      }
      if (paramParcel != null) {
        if (!this.mnH) {
          break label314;
        }
      }
    }
    label299:
    label304:
    label309:
    label314:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      if (paramParcel == null) {
        break label319;
      }
      paramParcel.writeString(this.mol);
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
    }
    label319:
    AppMethodBeat.o(149548);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.SubscribeMsgTmpItem
 * JD-Core Version:    0.7.0.1
 */