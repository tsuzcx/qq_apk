package com.tencent.mm.msgsubscription;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "Landroid/os/Parcelable;", "alwaysChosenStatus", "", "appIconUrl", "", "appName", "cacheMaxSize", "", "subscribeMsgItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Lkotlin/collections/ArrayList;", "notShowAlways", "notShowReject", "wordingInfo", "Lcom/tencent/mm/msgsubscription/WordingInfo;", "isOpened", "showEntry", "buffer", "", "showStyle", "showInfo", "Lcom/tencent/mm/msgsubscription/ShowInfo;", "mainDescription", "subDescription", "wxaErrorCode", "wxaErrorMessage", "wxaUserCancel", "extData", "(ZLjava/lang/String;Ljava/lang/String;ILjava/util/ArrayList;ZZLcom/tencent/mm/msgsubscription/WordingInfo;ZZ[BILcom/tencent/mm/msgsubscription/ShowInfo;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZLjava/lang/String;)V", "(Ljava/util/ArrayList;Z)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAlwaysChosenStatus", "()Z", "getAppIconUrl", "()Ljava/lang/String;", "getAppName", "getBuffer", "()[B", "getCacheMaxSize", "()I", "getExtData", "setOpened", "(Z)V", "getMainDescription", "getNotShowAlways", "getNotShowReject", "getShowEntry", "getShowInfo", "()Lcom/tencent/mm/msgsubscription/ShowInfo;", "getShowStyle", "getSubDescription", "getSubscribeMsgItems", "()Ljava/util/ArrayList;", "getWordingInfo", "()Lcom/tencent/mm/msgsubscription/WordingInfo;", "getWxaErrorCode", "getWxaErrorMessage", "getWxaUserCancel", "describeContents", "toString", "writeToParcel", "", "flags", "Companion", "wxbiz-msgsubscription-sdk_release"})
public final class SubscribeMsgRequestResult
  implements Parcelable
{
  public static final Parcelable.Creator<SubscribeMsgRequestResult> CREATOR;
  public static final SubscribeMsgRequestResult.a mob;
  public final String appName;
  public final byte[] buffer;
  public final String extData;
  private final boolean mnL;
  public final String mnM;
  public final int mnN;
  public final ArrayList<SubscribeMsgTmpItem> mnO;
  public final boolean mnP;
  public final boolean mnQ;
  public final WordingInfo mnR;
  public boolean mnS;
  public final boolean mnT;
  public final int mnU;
  public final ShowInfo mnV;
  public final String mnW;
  public final String mnX;
  public final int mnY;
  public final String mnZ;
  public final boolean moa;
  
  static
  {
    AppMethodBeat.i(149546);
    mob = new SubscribeMsgRequestResult.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(149546);
  }
  
  public SubscribeMsgRequestResult(Parcel paramParcel)
  {
    AppMethodBeat.i(149545);
    Object localObject;
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.mnL = bool1;
      String str = paramParcel.readString();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.mnM = ((String)localObject);
      str = paramParcel.readString();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.appName = ((String)localObject);
      this.mnN = paramParcel.readInt();
      this.mnR = ((WordingInfo)paramParcel.readParcelable(WordingInfo.class.getClassLoader()));
      localObject = new ArrayList();
      paramParcel.readList((List)localObject, SubscribeMsgTmpItem.class.getClassLoader());
      this.mnO = ((ArrayList)localObject);
      if (paramParcel.readByte() == 0) {
        break label362;
      }
      bool1 = true;
      label143:
      this.mnP = bool1;
      if (paramParcel.readByte() == 0) {
        break label367;
      }
      bool1 = true;
      label157:
      this.mnS = bool1;
      if (paramParcel.readByte() == 0) {
        break label372;
      }
      bool1 = true;
      label171:
      this.mnT = bool1;
      this.buffer = new byte[paramParcel.readInt()];
      paramParcel.readByteArray(this.buffer);
      this.mnU = paramParcel.readInt();
      this.mnV = ((ShowInfo)paramParcel.readParcelable(ShowInfo.class.getClassLoader()));
      str = paramParcel.readString();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.mnW = ((String)localObject);
      str = paramParcel.readString();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.mnX = ((String)localObject);
      this.mnY = paramParcel.readInt();
      str = paramParcel.readString();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.mnZ = ((String)localObject);
      if (paramParcel.readByte() == 0) {
        break label377;
      }
      bool1 = true;
      label310:
      this.moa = bool1;
      if (paramParcel.readByte() == 0) {
        break label382;
      }
    }
    label362:
    label367:
    label372:
    label377:
    label382:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.mnQ = bool1;
      localObject = paramParcel.readString();
      paramParcel = (Parcel)localObject;
      if (localObject == null) {
        paramParcel = "";
      }
      this.extData = paramParcel;
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
      bool1 = false;
      break label310;
    }
  }
  
  public SubscribeMsgRequestResult(ArrayList<SubscribeMsgTmpItem> paramArrayList, boolean paramBoolean)
  {
    this(false, "", "", 0, paramArrayList, false, false, null, paramBoolean, true, new byte[0], -1, null, "", "", 0, "", false, "");
    AppMethodBeat.i(149544);
    AppMethodBeat.o(149544);
  }
  
  public SubscribeMsgRequestResult(boolean paramBoolean1, String paramString1, String paramString2, int paramInt1, ArrayList<SubscribeMsgTmpItem> paramArrayList, boolean paramBoolean2, boolean paramBoolean3, WordingInfo paramWordingInfo, boolean paramBoolean4, boolean paramBoolean5, byte[] paramArrayOfByte, int paramInt2, ShowInfo paramShowInfo, String paramString3, String paramString4, int paramInt3, String paramString5, boolean paramBoolean6, String paramString6)
  {
    AppMethodBeat.i(263573);
    this.mnL = paramBoolean1;
    this.mnM = paramString1;
    this.appName = paramString2;
    this.mnN = paramInt1;
    this.mnO = paramArrayList;
    this.mnP = paramBoolean2;
    this.mnQ = paramBoolean3;
    this.mnR = paramWordingInfo;
    this.mnS = paramBoolean4;
    this.mnT = paramBoolean5;
    this.buffer = paramArrayOfByte;
    this.mnU = paramInt2;
    this.mnV = paramShowInfo;
    this.mnW = paramString3;
    this.mnX = paramString4;
    this.mnY = paramInt3;
    this.mnZ = paramString5;
    this.moa = paramBoolean6;
    this.extData = paramString6;
    AppMethodBeat.o(263573);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(149542);
    Object localObject = new StringBuilder("SubscribeMsgRequestResult(alwaysChosenStatus=").append(this.mnL).append(", appIconUrl='").append(this.mnM).append("', appName='").append(this.appName).append("', cacheMaxSize=").append(this.mnN).append(", subscribeMsgItems=").append(this.mnO).append(", notShowAlways=").append(this.mnP).append(", notShowReject=").append(this.mnQ).append(", wordingInfo=").append(this.mnR).append(", isOpened=").append(this.mnS).append(", showEntry=").append(this.mnT).append(", buffer=");
    String str = Arrays.toString(this.buffer);
    p.j(str, "java.util.Arrays.toString(this)");
    localObject = str + ", showStyle=" + this.mnU + ", showInfo=" + this.mnV + ", mainDescription=" + this.mnW + ", subDescription=" + this.mnX + ", wxaErrorCode=" + this.mnY + ", wxaErrorMessage='" + this.mnZ + "', wxaUserCancel=" + this.moa + ", extData='" + this.extData + "')";
    AppMethodBeat.o(149542);
    return localObject;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(149541);
    p.k(paramParcel, "parcel");
    if (this.mnL)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.mnM);
      paramParcel.writeString(this.appName);
      paramParcel.writeInt(this.mnN);
      paramParcel.writeParcelable((Parcelable)this.mnR, paramInt);
      paramParcel.writeList((List)this.mnO);
      if (!this.mnP) {
        break label270;
      }
      b1 = 1;
      label85:
      paramParcel.writeByte(b1);
      if (!this.mnS) {
        break label275;
      }
      b1 = 1;
      label99:
      paramParcel.writeByte(b1);
      if (!this.mnT) {
        break label280;
      }
      b1 = 1;
      label113:
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.buffer.length);
      paramParcel.writeByteArray(this.buffer);
      paramParcel.writeInt(this.mnU);
      paramParcel.writeParcelable((Parcelable)this.mnV, paramInt);
      String str2 = this.mnW;
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      paramParcel.writeString(str1);
      str2 = this.mnX;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      paramParcel.writeString(str1);
      paramParcel.writeInt(this.mnY);
      paramParcel.writeString(this.mnZ);
      if (!this.moa) {
        break label285;
      }
      b1 = 1;
      label230:
      paramParcel.writeByte(b1);
      if (!this.mnQ) {
        break label290;
      }
    }
    label270:
    label275:
    label280:
    label285:
    label290:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.extData);
      AppMethodBeat.o(149541);
      return;
      b1 = 0;
      break;
      b1 = 0;
      break label85;
      b1 = 0;
      break label99;
      b1 = 0;
      break label113;
      b1 = 0;
      break label230;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/msgsubscription/SubscribeMsgRequestResult$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "wxbiz-msgsubscription-sdk_release"})
  public static final class b
    implements Parcelable.Creator<SubscribeMsgRequestResult>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.SubscribeMsgRequestResult
 * JD-Core Version:    0.7.0.1
 */