package com.tencent.mm.msgsubscription;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "Landroid/os/Parcelable;", "alwaysChosenStatus", "", "appIconUrl", "", "appName", "cacheMaxSize", "", "subscribeMsgItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Lkotlin/collections/ArrayList;", "notShowAlways", "wordingInfo", "Lcom/tencent/mm/msgsubscription/WordingInfo;", "isOpened", "showEntry", "buffer", "", "showStyle", "showInfo", "Lcom/tencent/mm/msgsubscription/ShowInfo;", "mainDescription", "subDescription", "wxaErrorCode", "wxaErrorMessage", "wxaUserCancel", "(ZLjava/lang/String;Ljava/lang/String;ILjava/util/ArrayList;ZLcom/tencent/mm/msgsubscription/WordingInfo;ZZ[BILcom/tencent/mm/msgsubscription/ShowInfo;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Z)V", "(Ljava/util/ArrayList;Z)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAlwaysChosenStatus", "()Z", "getAppIconUrl", "()Ljava/lang/String;", "getAppName", "getBuffer", "()[B", "getCacheMaxSize", "()I", "setOpened", "(Z)V", "getMainDescription", "getNotShowAlways", "getShowEntry", "getShowInfo", "()Lcom/tencent/mm/msgsubscription/ShowInfo;", "getShowStyle", "getSubDescription", "getSubscribeMsgItems", "()Ljava/util/ArrayList;", "getWordingInfo", "()Lcom/tencent/mm/msgsubscription/WordingInfo;", "getWxaErrorCode", "getWxaErrorMessage", "getWxaUserCancel", "describeContents", "toString", "writeToParcel", "", "flags", "Companion", "wxbiz-msgsubscription-sdk_release"})
public final class SubscribeMsgRequestResult
  implements Parcelable
{
  public static final Parcelable.Creator<SubscribeMsgRequestResult> CREATOR;
  public static final a iDh;
  public final String appName;
  public final byte[] buffer;
  private final boolean iCS;
  public final String iCT;
  public final int iCU;
  public final ArrayList<SubscribeMsgTmpItem> iCV;
  private final boolean iCW;
  public final WordingInfo iCX;
  public boolean iCY;
  public final boolean iCZ;
  public final int iDa;
  public final ShowInfo iDb;
  public final String iDc;
  public final String iDd;
  public final int iDe;
  public final String iDf;
  public final boolean iDg;
  
  static
  {
    AppMethodBeat.i(149546);
    iDh = new a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(149546);
  }
  
  public SubscribeMsgRequestResult(Parcel paramParcel)
  {
    AppMethodBeat.i(149545);
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.iCS = bool1;
      String str = paramParcel.readString();
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.iCT = ((String)localObject);
      str = paramParcel.readString();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.appName = ((String)localObject);
      this.iCU = paramParcel.readInt();
      this.iCX = ((WordingInfo)paramParcel.readParcelable(WordingInfo.class.getClassLoader()));
      localObject = new ArrayList();
      paramParcel.readList((List)localObject, SubscribeMsgTmpItem.class.getClassLoader());
      this.iCV = ((ArrayList)localObject);
      if (paramParcel.readByte() == 0) {
        break label326;
      }
      bool1 = true;
      label143:
      this.iCW = bool1;
      if (paramParcel.readByte() == 0) {
        break label331;
      }
      bool1 = true;
      label157:
      this.iCY = bool1;
      if (paramParcel.readByte() == 0) {
        break label336;
      }
      bool1 = true;
      label171:
      this.iCZ = bool1;
      this.buffer = new byte[paramParcel.readInt()];
      paramParcel.readByteArray(this.buffer);
      this.iDa = paramParcel.readInt();
      this.iDb = ((ShowInfo)paramParcel.readParcelable(ShowInfo.class.getClassLoader()));
      str = paramParcel.readString();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.iDc = ((String)localObject);
      str = paramParcel.readString();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.iDd = ((String)localObject);
      this.iDe = paramParcel.readInt();
      str = paramParcel.readString();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.iDf = ((String)localObject);
      if (paramParcel.readByte() == 0) {
        break label341;
      }
    }
    label326:
    label331:
    label336:
    label341:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.iDg = bool1;
      AppMethodBeat.o(149545);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label143;
      bool1 = false;
      break label157;
      bool1 = false;
      break label171;
    }
  }
  
  public SubscribeMsgRequestResult(ArrayList<SubscribeMsgTmpItem> paramArrayList, boolean paramBoolean)
  {
    this(false, "", "", 0, paramArrayList, false, null, paramBoolean, true, new byte[0], -1, null, "", "", 0, "", false);
    AppMethodBeat.i(149544);
    AppMethodBeat.o(149544);
  }
  
  public SubscribeMsgRequestResult(boolean paramBoolean1, String paramString1, String paramString2, int paramInt1, ArrayList<SubscribeMsgTmpItem> paramArrayList, boolean paramBoolean2, WordingInfo paramWordingInfo, boolean paramBoolean3, boolean paramBoolean4, byte[] paramArrayOfByte, int paramInt2, ShowInfo paramShowInfo, String paramString3, String paramString4, int paramInt3, String paramString5, boolean paramBoolean5)
  {
    AppMethodBeat.i(149543);
    this.iCS = paramBoolean1;
    this.iCT = paramString1;
    this.appName = paramString2;
    this.iCU = paramInt1;
    this.iCV = paramArrayList;
    this.iCW = paramBoolean2;
    this.iCX = paramWordingInfo;
    this.iCY = paramBoolean3;
    this.iCZ = paramBoolean4;
    this.buffer = paramArrayOfByte;
    this.iDa = paramInt2;
    this.iDb = paramShowInfo;
    this.iDc = paramString3;
    this.iDd = paramString4;
    this.iDe = paramInt3;
    this.iDf = paramString5;
    this.iDg = paramBoolean5;
    AppMethodBeat.o(149543);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(149542);
    String str = "SubscribeMsgRequestResult(alwaysChosenStatus=" + this.iCS + ", appIconUrl='" + this.iCT + "', appName='" + this.appName + "', cacheMaxSize=" + this.iCU + ", subscribeMsgItems=" + this.iCV + ", notShowAlways=" + this.iCW + ", wordingInfo=" + this.iCX + ", CREATOR=" + CREATOR + ')';
    AppMethodBeat.o(149542);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(149541);
    p.h(paramParcel, "parcel");
    if (this.iCS)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.iCT);
      paramParcel.writeString(this.appName);
      paramParcel.writeInt(this.iCU);
      paramParcel.writeParcelable((Parcelable)this.iCX, paramInt);
      paramParcel.writeList((List)this.iCV);
      if (!this.iCW) {
        break label248;
      }
      b1 = 1;
      label85:
      paramParcel.writeByte(b1);
      if (!this.iCY) {
        break label253;
      }
      b1 = 1;
      label99:
      paramParcel.writeByte(b1);
      if (!this.iCZ) {
        break label258;
      }
      b1 = 1;
      label113:
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.buffer.length);
      paramParcel.writeByteArray(this.buffer);
      paramParcel.writeInt(this.iDa);
      paramParcel.writeParcelable((Parcelable)this.iDb, paramInt);
      String str2 = this.iDc;
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      paramParcel.writeString(str1);
      str2 = this.iDd;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      paramParcel.writeString(str1);
      paramParcel.writeInt(this.iDe);
      paramParcel.writeString(this.iDf);
      if (!this.iDg) {
        break label263;
      }
    }
    label258:
    label263:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      AppMethodBeat.o(149541);
      return;
      b1 = 0;
      break;
      label248:
      b1 = 0;
      break label85;
      label253:
      b1 = 0;
      break label99;
      b1 = 0;
      break label113;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "from", "response", "Lcom/tencent/mm/protocal/protobuf/SubscribeMsgResp;", "wxbiz-msgsubscription-sdk_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/msgsubscription/SubscribeMsgRequestResult$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "wxbiz-msgsubscription-sdk_release"})
  public static final class b
    implements Parcelable.Creator<SubscribeMsgRequestResult>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.SubscribeMsgRequestResult
 * JD-Core Version:    0.7.0.1
 */