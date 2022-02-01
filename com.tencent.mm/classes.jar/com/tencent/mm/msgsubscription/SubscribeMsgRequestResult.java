package com.tencent.mm.msgsubscription;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "Landroid/os/Parcelable;", "alwaysChosenStatus", "", "appIconUrl", "", "appName", "cacheMaxSize", "", "subscribeMsgItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Lkotlin/collections/ArrayList;", "notShowAlways", "notShowReject", "wordingInfo", "Lcom/tencent/mm/msgsubscription/WordingInfo;", "isOpened", "showEntry", "buffer", "", "showStyle", "showInfo", "Lcom/tencent/mm/msgsubscription/ShowInfo;", "mainDescription", "subDescription", "wxaErrorCode", "wxaErrorMessage", "wxaUserCancel", "extData", "(ZLjava/lang/String;Ljava/lang/String;ILjava/util/ArrayList;ZZLcom/tencent/mm/msgsubscription/WordingInfo;ZZ[BILcom/tencent/mm/msgsubscription/ShowInfo;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZLjava/lang/String;)V", "(Ljava/util/ArrayList;Z)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAlwaysChosenStatus", "()Z", "getAppIconUrl", "()Ljava/lang/String;", "getAppName", "getBuffer", "()[B", "getCacheMaxSize", "()I", "getExtData", "setOpened", "(Z)V", "getMainDescription", "getNotShowAlways", "getNotShowReject", "getShowEntry", "getShowInfo", "()Lcom/tencent/mm/msgsubscription/ShowInfo;", "getShowStyle", "getSubDescription", "getSubscribeMsgItems", "()Ljava/util/ArrayList;", "getWordingInfo", "()Lcom/tencent/mm/msgsubscription/WordingInfo;", "getWxaErrorCode", "getWxaErrorMessage", "getWxaUserCancel", "describeContents", "toString", "writeToParcel", "", "flags", "Companion", "wxbiz-msgsubscription-sdk_release"})
public final class SubscribeMsgRequestResult
  implements Parcelable
{
  public static final Parcelable.Creator<SubscribeMsgRequestResult> CREATOR;
  public static final SubscribeMsgRequestResult.a jyx;
  public final String appName;
  public final byte[] buffer;
  public final String extData;
  private final boolean jyh;
  public final String jyi;
  public final int jyj;
  public final ArrayList<SubscribeMsgTmpItem> jyk;
  public final boolean jyl;
  public final boolean jym;
  public final WordingInfo jyn;
  public boolean jyo;
  public final boolean jyp;
  public final int jyq;
  public final ShowInfo jyr;
  public final String jys;
  public final String jyt;
  public final int jyu;
  public final String jyv;
  public final boolean jyw;
  
  static
  {
    AppMethodBeat.i(149546);
    jyx = new SubscribeMsgRequestResult.a((byte)0);
    CREATOR = (Parcelable.Creator)new SubscribeMsgRequestResult.b();
    AppMethodBeat.o(149546);
  }
  
  public SubscribeMsgRequestResult(Parcel paramParcel)
  {
    AppMethodBeat.i(149545);
    Object localObject;
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.jyh = bool1;
      String str = paramParcel.readString();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.jyi = ((String)localObject);
      str = paramParcel.readString();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.appName = ((String)localObject);
      this.jyj = paramParcel.readInt();
      this.jyn = ((WordingInfo)paramParcel.readParcelable(WordingInfo.class.getClassLoader()));
      localObject = new ArrayList();
      paramParcel.readList((List)localObject, SubscribeMsgTmpItem.class.getClassLoader());
      this.jyk = ((ArrayList)localObject);
      if (paramParcel.readByte() == 0) {
        break label362;
      }
      bool1 = true;
      label143:
      this.jyl = bool1;
      if (paramParcel.readByte() == 0) {
        break label367;
      }
      bool1 = true;
      label157:
      this.jyo = bool1;
      if (paramParcel.readByte() == 0) {
        break label372;
      }
      bool1 = true;
      label171:
      this.jyp = bool1;
      this.buffer = new byte[paramParcel.readInt()];
      paramParcel.readByteArray(this.buffer);
      this.jyq = paramParcel.readInt();
      this.jyr = ((ShowInfo)paramParcel.readParcelable(ShowInfo.class.getClassLoader()));
      str = paramParcel.readString();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.jys = ((String)localObject);
      str = paramParcel.readString();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.jyt = ((String)localObject);
      this.jyu = paramParcel.readInt();
      str = paramParcel.readString();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.jyv = ((String)localObject);
      if (paramParcel.readByte() == 0) {
        break label377;
      }
      bool1 = true;
      label310:
      this.jyw = bool1;
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
      this.jym = bool1;
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
    AppMethodBeat.i(194257);
    this.jyh = paramBoolean1;
    this.jyi = paramString1;
    this.appName = paramString2;
    this.jyj = paramInt1;
    this.jyk = paramArrayList;
    this.jyl = paramBoolean2;
    this.jym = paramBoolean3;
    this.jyn = paramWordingInfo;
    this.jyo = paramBoolean4;
    this.jyp = paramBoolean5;
    this.buffer = paramArrayOfByte;
    this.jyq = paramInt2;
    this.jyr = paramShowInfo;
    this.jys = paramString3;
    this.jyt = paramString4;
    this.jyu = paramInt3;
    this.jyv = paramString5;
    this.jyw = paramBoolean6;
    this.extData = paramString6;
    AppMethodBeat.o(194257);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(149542);
    String str = "SubscribeMsgRequestResult(alwaysChosenStatus=" + this.jyh + ", appIconUrl='" + this.jyi + "', appName='" + this.appName + "', cacheMaxSize=" + this.jyj + ", subscribeMsgItems=" + this.jyk + ", notShowAlways=" + this.jyl + ", wordingInfo=" + this.jyn + ", CREATOR=" + CREATOR + ')';
    AppMethodBeat.o(149542);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(149541);
    p.h(paramParcel, "parcel");
    if (this.jyh)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.jyi);
      paramParcel.writeString(this.appName);
      paramParcel.writeInt(this.jyj);
      paramParcel.writeParcelable((Parcelable)this.jyn, paramInt);
      paramParcel.writeList((List)this.jyk);
      if (!this.jyl) {
        break label270;
      }
      b1 = 1;
      label85:
      paramParcel.writeByte(b1);
      if (!this.jyo) {
        break label275;
      }
      b1 = 1;
      label99:
      paramParcel.writeByte(b1);
      if (!this.jyp) {
        break label280;
      }
      b1 = 1;
      label113:
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.buffer.length);
      paramParcel.writeByteArray(this.buffer);
      paramParcel.writeInt(this.jyq);
      paramParcel.writeParcelable((Parcelable)this.jyr, paramInt);
      String str2 = this.jys;
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      paramParcel.writeString(str1);
      str2 = this.jyt;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      paramParcel.writeString(str1);
      paramParcel.writeInt(this.jyu);
      paramParcel.writeString(this.jyv);
      if (!this.jyw) {
        break label285;
      }
      b1 = 1;
      label230:
      paramParcel.writeByte(b1);
      if (!this.jym) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.SubscribeMsgRequestResult
 * JD-Core Version:    0.7.0.1
 */