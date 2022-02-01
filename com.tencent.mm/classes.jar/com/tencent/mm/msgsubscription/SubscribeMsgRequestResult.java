package com.tencent.mm.msgsubscription;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "Landroid/os/Parcelable;", "alwaysChosenStatus", "", "appIconUrl", "", "appName", "cacheMaxSize", "", "subscribeMsgItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Lkotlin/collections/ArrayList;", "notShowAlways", "notShowReject", "wordingInfo", "Lcom/tencent/mm/msgsubscription/WordingInfo;", "isOpened", "showEntry", "buffer", "", "showStyle", "showInfo", "Lcom/tencent/mm/msgsubscription/ShowInfo;", "mainDescription", "subDescription", "wxaErrorCode", "wxaErrorMessage", "wxaUserCancel", "extData", "(ZLjava/lang/String;Ljava/lang/String;ILjava/util/ArrayList;ZZLcom/tencent/mm/msgsubscription/WordingInfo;ZZ[BILcom/tencent/mm/msgsubscription/ShowInfo;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZLjava/lang/String;)V", "(Ljava/util/ArrayList;Z)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAlwaysChosenStatus", "()Z", "getAppIconUrl", "()Ljava/lang/String;", "getAppName", "getBuffer", "()[B", "getCacheMaxSize", "()I", "getExtData", "setOpened", "(Z)V", "getMainDescription", "getNotShowAlways", "getNotShowReject", "getShowEntry", "getShowInfo", "()Lcom/tencent/mm/msgsubscription/ShowInfo;", "getShowStyle", "getSubDescription", "getSubscribeMsgItems", "()Ljava/util/ArrayList;", "getWordingInfo", "()Lcom/tencent/mm/msgsubscription/WordingInfo;", "getWxaErrorCode", "getWxaErrorMessage", "getWxaUserCancel", "describeContents", "toString", "writeToParcel", "", "flags", "Companion", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SubscribeMsgRequestResult
  implements Parcelable
{
  public static final Parcelable.Creator<SubscribeMsgRequestResult> CREATOR;
  public static final SubscribeMsgRequestResult.a phy;
  public final String appName;
  public final byte[] buffer;
  public final String extData;
  public final String phA;
  public final int phB;
  public final ArrayList<SubscribeMsgTmpItem> phC;
  public final boolean phD;
  public final boolean phE;
  public final WordingInfo phF;
  public boolean phG;
  public final boolean phH;
  public final int phI;
  public final ShowInfo phJ;
  public final String phK;
  public final String phL;
  public final int phM;
  public final String phN;
  public final boolean phO;
  private final boolean phz;
  
  static
  {
    AppMethodBeat.i(149546);
    phy = new SubscribeMsgRequestResult.a((byte)0);
    CREATOR = (Parcelable.Creator)new SubscribeMsgRequestResult.b();
    AppMethodBeat.o(149546);
  }
  
  public SubscribeMsgRequestResult(Parcel paramParcel)
  {
    AppMethodBeat.i(149545);
    Object localObject1;
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.phz = bool1;
      Object localObject2 = paramParcel.readString();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.phA = ((String)localObject1);
      localObject2 = paramParcel.readString();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.appName = ((String)localObject1);
      this.phB = paramParcel.readInt();
      this.phF = ((WordingInfo)paramParcel.readParcelable(WordingInfo.class.getClassLoader()));
      localObject1 = new ArrayList();
      paramParcel.readList((List)localObject1, SubscribeMsgTmpItem.class.getClassLoader());
      localObject2 = ah.aiuX;
      this.phC = ((ArrayList)localObject1);
      if (paramParcel.readByte() == 0) {
        break label367;
      }
      bool1 = true;
      label148:
      this.phD = bool1;
      if (paramParcel.readByte() == 0) {
        break label372;
      }
      bool1 = true;
      label162:
      this.phG = bool1;
      if (paramParcel.readByte() == 0) {
        break label377;
      }
      bool1 = true;
      label176:
      this.phH = bool1;
      this.buffer = new byte[paramParcel.readInt()];
      paramParcel.readByteArray(this.buffer);
      this.phI = paramParcel.readInt();
      this.phJ = ((ShowInfo)paramParcel.readParcelable(ShowInfo.class.getClassLoader()));
      localObject2 = paramParcel.readString();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.phK = ((String)localObject1);
      localObject2 = paramParcel.readString();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.phL = ((String)localObject1);
      this.phM = paramParcel.readInt();
      localObject2 = paramParcel.readString();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.phN = ((String)localObject1);
      if (paramParcel.readByte() == 0) {
        break label382;
      }
      bool1 = true;
      label315:
      this.phO = bool1;
      if (paramParcel.readByte() == 0) {
        break label387;
      }
    }
    label387:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.phE = bool1;
      localObject1 = paramParcel.readString();
      paramParcel = (Parcel)localObject1;
      if (localObject1 == null) {
        paramParcel = "";
      }
      this.extData = paramParcel;
      AppMethodBeat.o(149545);
      return;
      bool1 = false;
      break;
      label367:
      bool1 = false;
      break label148;
      label372:
      bool1 = false;
      break label162;
      label377:
      bool1 = false;
      break label176;
      label382:
      bool1 = false;
      break label315;
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
    AppMethodBeat.i(236264);
    this.phz = paramBoolean1;
    this.phA = paramString1;
    this.appName = paramString2;
    this.phB = paramInt1;
    this.phC = paramArrayList;
    this.phD = paramBoolean2;
    this.phE = paramBoolean3;
    this.phF = paramWordingInfo;
    this.phG = paramBoolean4;
    this.phH = paramBoolean5;
    this.buffer = paramArrayOfByte;
    this.phI = paramInt2;
    this.phJ = paramShowInfo;
    this.phK = paramString3;
    this.phL = paramString4;
    this.phM = paramInt3;
    this.phN = paramString5;
    this.phO = paramBoolean6;
    this.extData = paramString6;
    AppMethodBeat.o(236264);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(149542);
    Object localObject = new StringBuilder();
    StringBuilder localStringBuilder = ((StringBuilder)localObject).append("SubscribeMsgRequestResult(alwaysChosenStatus=").append(this.phz).append(", appIconUrl='").append(this.phA).append("', appName='").append(this.appName).append("', cacheMaxSize=").append(this.phB).append(", subscribeMsgItems=").append(this.phC).append(", notShowAlways=").append(this.phD).append(", notShowReject=").append(this.phE).append(", wordingInfo=").append(this.phF).append(", isOpened=").append(this.phG).append(", showEntry=").append(this.phH).append(", buffer=");
    String str = Arrays.toString(this.buffer);
    s.s(str, "java.util.Arrays.toString(this)");
    localStringBuilder.append(str).append(", showStyle=");
    ((StringBuilder)localObject).append(this.phI).append(", showInfo=").append(this.phJ).append(", mainDescription=").append(this.phK).append(", subDescription=").append(this.phL).append(", wxaErrorCode=").append(this.phM).append(", wxaErrorMessage='").append(this.phN).append("', wxaUserCancel=").append(this.phO).append(", extData='").append(this.extData).append("')");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(149542);
    return localObject;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(149541);
    s.u(paramParcel, "parcel");
    if (this.phz)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.phA);
      paramParcel.writeString(this.appName);
      paramParcel.writeInt(this.phB);
      paramParcel.writeParcelable((Parcelable)this.phF, paramInt);
      paramParcel.writeList((List)this.phC);
      if (!this.phD) {
        break label270;
      }
      b1 = 1;
      label85:
      paramParcel.writeByte(b1);
      if (!this.phG) {
        break label275;
      }
      b1 = 1;
      label99:
      paramParcel.writeByte(b1);
      if (!this.phH) {
        break label280;
      }
      b1 = 1;
      label113:
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.buffer.length);
      paramParcel.writeByteArray(this.buffer);
      paramParcel.writeInt(this.phI);
      paramParcel.writeParcelable((Parcelable)this.phJ, paramInt);
      String str2 = this.phK;
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      paramParcel.writeString(str1);
      str2 = this.phL;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      paramParcel.writeString(str1);
      paramParcel.writeInt(this.phM);
      paramParcel.writeString(this.phN);
      if (!this.phO) {
        break label285;
      }
      b1 = 1;
      label230:
      paramParcel.writeByte(b1);
      if (!this.phE) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.SubscribeMsgRequestResult
 * JD-Core Version:    0.7.0.1
 */