package com.tencent.mm.msgsubscription;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.bkn;
import com.tencent.mm.protocal.protobuf.czv;
import com.tencent.mm.protocal.protobuf.czx;
import com.tencent.mm.protocal.protobuf.czy;
import com.tencent.mm.protocal.protobuf.daa;
import d.g.b.k;
import d.l;
import d.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "Landroid/os/Parcelable;", "alwaysChosenStatus", "", "appIconUrl", "", "appName", "cacheMaxSize", "", "subscribeMsgItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Lkotlin/collections/ArrayList;", "notShowAlways", "wordingInfo", "Lcom/tencent/mm/msgsubscription/WordingInfo;", "isOpened", "showEntry", "buffer", "", "showStyle", "showInfo", "Lcom/tencent/mm/msgsubscription/ShowInfo;", "mainDescription", "subDescription", "wxaErrorCode", "wxaErrorMessage", "wxaUserCancel", "(ZLjava/lang/String;Ljava/lang/String;ILjava/util/ArrayList;ZLcom/tencent/mm/msgsubscription/WordingInfo;ZZ[BILcom/tencent/mm/msgsubscription/ShowInfo;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Z)V", "(Ljava/util/ArrayList;Z)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAlwaysChosenStatus", "()Z", "getAppIconUrl", "()Ljava/lang/String;", "getAppName", "getBuffer", "()[B", "getCacheMaxSize", "()I", "setOpened", "(Z)V", "getMainDescription", "getNotShowAlways", "getShowEntry", "getShowInfo", "()Lcom/tencent/mm/msgsubscription/ShowInfo;", "getShowStyle", "getSubDescription", "getSubscribeMsgItems", "()Ljava/util/ArrayList;", "getWordingInfo", "()Lcom/tencent/mm/msgsubscription/WordingInfo;", "getWxaErrorCode", "getWxaErrorMessage", "getWxaUserCancel", "describeContents", "toString", "writeToParcel", "", "flags", "Companion", "wxbiz-msgsubscription-sdk_release"})
public final class SubscribeMsgRequestResult
  implements Parcelable
{
  public static final Parcelable.Creator<SubscribeMsgRequestResult> CREATOR;
  public static final a hGs;
  public final String appName;
  public final byte[] buffer;
  private final boolean hGd;
  public final String hGe;
  public final int hGf;
  public final ArrayList<SubscribeMsgTmpItem> hGg;
  private final boolean hGh;
  public final WordingInfo hGi;
  public boolean hGj;
  public final boolean hGk;
  public final int hGl;
  public final ShowInfo hGm;
  public final String hGn;
  public final String hGo;
  public final int hGp;
  public final String hGq;
  public final boolean hGr;
  
  static
  {
    AppMethodBeat.i(149546);
    hGs = new a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(149546);
  }
  
  public SubscribeMsgRequestResult(Parcel paramParcel)
  {
    AppMethodBeat.i(149545);
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.hGd = bool1;
      String str = paramParcel.readString();
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.hGe = ((String)localObject);
      str = paramParcel.readString();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.appName = ((String)localObject);
      this.hGf = paramParcel.readInt();
      this.hGi = ((WordingInfo)paramParcel.readParcelable(WordingInfo.class.getClassLoader()));
      localObject = new ArrayList();
      paramParcel.readList((List)localObject, SubscribeMsgTmpItem.class.getClassLoader());
      this.hGg = ((ArrayList)localObject);
      if (paramParcel.readByte() == 0) {
        break label326;
      }
      bool1 = true;
      label143:
      this.hGh = bool1;
      if (paramParcel.readByte() == 0) {
        break label331;
      }
      bool1 = true;
      label157:
      this.hGj = bool1;
      if (paramParcel.readByte() == 0) {
        break label336;
      }
      bool1 = true;
      label171:
      this.hGk = bool1;
      this.buffer = new byte[paramParcel.readInt()];
      paramParcel.readByteArray(this.buffer);
      this.hGl = paramParcel.readInt();
      this.hGm = ((ShowInfo)paramParcel.readParcelable(ShowInfo.class.getClassLoader()));
      str = paramParcel.readString();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.hGn = ((String)localObject);
      str = paramParcel.readString();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.hGo = ((String)localObject);
      this.hGp = paramParcel.readInt();
      str = paramParcel.readString();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.hGq = ((String)localObject);
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
      this.hGr = bool1;
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
    this.hGd = paramBoolean1;
    this.hGe = paramString1;
    this.appName = paramString2;
    this.hGf = paramInt1;
    this.hGg = paramArrayList;
    this.hGh = paramBoolean2;
    this.hGi = paramWordingInfo;
    this.hGj = paramBoolean3;
    this.hGk = paramBoolean4;
    this.buffer = paramArrayOfByte;
    this.hGl = paramInt2;
    this.hGm = paramShowInfo;
    this.hGn = paramString3;
    this.hGo = paramString4;
    this.hGp = paramInt3;
    this.hGq = paramString5;
    this.hGr = paramBoolean5;
    AppMethodBeat.o(149543);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(149542);
    String str = "SubscribeMsgRequestResult(alwaysChosenStatus=" + this.hGd + ", appIconUrl='" + this.hGe + "', appName='" + this.appName + "', cacheMaxSize=" + this.hGf + ", subscribeMsgItems=" + this.hGg + ", notShowAlways=" + this.hGh + ", wordingInfo=" + this.hGi + ", CREATOR=" + CREATOR + ')';
    AppMethodBeat.o(149542);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(149541);
    k.h(paramParcel, "parcel");
    if (this.hGd)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.hGe);
      paramParcel.writeString(this.appName);
      paramParcel.writeInt(this.hGf);
      paramParcel.writeParcelable((Parcelable)this.hGi, paramInt);
      paramParcel.writeList((List)this.hGg);
      if (!this.hGh) {
        break label248;
      }
      b1 = 1;
      label85:
      paramParcel.writeByte(b1);
      if (!this.hGj) {
        break label253;
      }
      b1 = 1;
      label99:
      paramParcel.writeByte(b1);
      if (!this.hGk) {
        break label258;
      }
      b1 = 1;
      label113:
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.buffer.length);
      paramParcel.writeByteArray(this.buffer);
      paramParcel.writeInt(this.hGl);
      paramParcel.writeParcelable((Parcelable)this.hGm, paramInt);
      String str2 = this.hGn;
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      paramParcel.writeString(str1);
      str2 = this.hGo;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      paramParcel.writeString(str1);
      paramParcel.writeInt(this.hGp);
      paramParcel.writeString(this.hGq);
      if (!this.hGr) {
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "from", "response", "Lcom/tencent/mm/protocal/protobuf/SubscribeMsgResp;", "wxbiz-msgsubscription-sdk_release"})
  public static final class a
  {
    public static SubscribeMsgRequestResult a(czx paramczx)
    {
      AppMethodBeat.i(179495);
      k.h(paramczx, "response");
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = paramczx.rZM;
      k.g(localObject1, "response.InfoList");
      localObject1 = ((Iterable)localObject1).iterator();
      Object localObject2;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (czv)((Iterator)localObject1).next();
        localObject3 = new ArrayList();
        localObject4 = ((czv)localObject2).CNr;
        k.g(localObject4, "it.KeyWordList");
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (bkn)((Iterator)localObject4).next();
          ((ArrayList)localObject3).add(new o(((bkn)localObject5).Name, ((bkn)localObject5).vJI));
        }
        k.g(localObject2, "it");
        localArrayList.add(new SubscribeMsgTmpItem((czv)localObject2, (ArrayList)localObject3));
      }
      boolean bool1;
      if (paramczx.ErK == 1)
      {
        bool1 = true;
        localObject1 = paramczx.ErI;
        if (localObject1 != null) {
          break label894;
        }
        localObject1 = "";
      }
      label234:
      label628:
      label886:
      label894:
      for (;;)
      {
        localObject2 = paramczx.ErH;
        if (localObject2 == null) {
          localObject2 = "";
        }
        for (;;)
        {
          int j = paramczx.ErL;
          boolean bool2;
          Object localObject6;
          Object localObject7;
          Object localObject8;
          Object localObject9;
          boolean bool3;
          boolean bool4;
          int k;
          if (paramczx.ErJ == 1)
          {
            bool2 = true;
            localObject3 = paramczx.ErG;
            if (localObject3 != null)
            {
              localObject4 = ((daa)localObject3).hGC;
              localObject3 = localObject4;
              if (localObject4 != null) {}
            }
            else
            {
              localObject3 = "";
            }
            localObject4 = paramczx.ErG;
            if (localObject4 != null)
            {
              localObject5 = ((daa)localObject4).hGD;
              localObject4 = localObject5;
              if (localObject5 != null) {}
            }
            else
            {
              localObject4 = "";
            }
            localObject5 = paramczx.ErG;
            if (localObject5 != null)
            {
              localObject6 = ((daa)localObject5).hGE;
              localObject5 = localObject6;
              if (localObject6 != null) {}
            }
            else
            {
              localObject5 = "";
            }
            localObject6 = paramczx.ErG;
            if (localObject6 != null)
            {
              localObject7 = ((daa)localObject6).hGF;
              localObject6 = localObject7;
              if (localObject7 != null) {}
            }
            else
            {
              localObject6 = "";
            }
            localObject7 = paramczx.ErG;
            if (localObject7 != null)
            {
              localObject8 = ((daa)localObject7).hGG;
              localObject7 = localObject8;
              if (localObject8 != null) {}
            }
            else
            {
              localObject7 = "";
            }
            localObject8 = paramczx.ErG;
            if (localObject8 != null)
            {
              localObject9 = ((daa)localObject8).hGH;
              localObject8 = localObject9;
              if (localObject9 != null) {}
            }
            else
            {
              localObject8 = "";
            }
            localObject9 = paramczx.ErG;
            if (localObject9 != null)
            {
              localObject10 = ((daa)localObject9).hGI;
              localObject9 = localObject10;
              if (localObject10 != null) {}
            }
            else
            {
              localObject9 = "";
            }
            Object localObject10 = paramczx.ErG;
            if (localObject10 != null)
            {
              localObject11 = ((daa)localObject10).hGJ;
              localObject10 = localObject11;
              if (localObject11 != null) {}
            }
            else
            {
              localObject10 = "";
            }
            Object localObject11 = paramczx.ErG;
            if (localObject11 != null)
            {
              localObject12 = ((daa)localObject11).hGK;
              localObject11 = localObject12;
              if (localObject12 != null) {}
            }
            else
            {
              localObject11 = "";
            }
            Object localObject12 = paramczx.ErG;
            if (localObject12 != null)
            {
              localObject13 = ((daa)localObject12).hGL;
              localObject12 = localObject13;
              if (localObject13 != null) {}
            }
            else
            {
              localObject12 = "";
            }
            Object localObject13 = paramczx.ErG;
            if (localObject13 != null)
            {
              String str = ((daa)localObject13).hGM;
              localObject13 = str;
              if (str != null) {}
            }
            else
            {
              localObject13 = "";
            }
            localObject8 = new WordingInfo((String)localObject3, (String)localObject4, (String)localObject5, (String)localObject6, (String)localObject7, (String)localObject8, (String)localObject9, (String)localObject10, (String)localObject11, (String)localObject12, (String)localObject13);
            if (paramczx.Ery != 1) {
              break label866;
            }
            bool3 = true;
            if (paramczx.ErP != 1) {
              break label872;
            }
            bool4 = true;
            localObject3 = paramczx.Buffer;
            if (localObject3 == null) {
              break label878;
            }
            localObject3 = ((b)localObject3).toByteArray();
            k = paramczx.ErV;
            localObject4 = paramczx.ErW;
            if (localObject4 == null) {
              break label886;
            }
          }
          for (int i = ((czy)localObject4).DJf;; i = -1)
          {
            localObject4 = paramczx.ErW;
            if (localObject4 != null)
            {
              localObject5 = ((czy)localObject4).DAn;
              localObject4 = localObject5;
              if (localObject5 != null) {}
            }
            else
            {
              localObject4 = "";
            }
            localObject5 = paramczx.ErW;
            if (localObject5 != null)
            {
              localObject6 = ((czy)localObject5).ErX;
              localObject5 = localObject6;
              if (localObject6 != null) {}
            }
            else
            {
              localObject5 = "";
            }
            localObject9 = new ShowInfo(i, (String)localObject4, (String)localObject5);
            localObject5 = paramczx.ErT;
            localObject4 = localObject5;
            if (localObject5 == null) {
              localObject4 = "";
            }
            localObject6 = paramczx.ErU;
            localObject5 = localObject6;
            if (localObject6 == null) {
              localObject5 = "";
            }
            i = paramczx.ErQ;
            localObject7 = paramczx.ErR;
            localObject6 = localObject7;
            if (localObject7 == null) {
              localObject6 = "";
            }
            paramczx = new SubscribeMsgRequestResult(bool1, (String)localObject1, (String)localObject2, j, localArrayList, bool2, (WordingInfo)localObject8, bool3, bool4, (byte[])localObject3, k, (ShowInfo)localObject9, (String)localObject4, (String)localObject5, i, (String)localObject6, paramczx.ErS);
            AppMethodBeat.o(179495);
            return paramczx;
            bool1 = false;
            break;
            bool2 = false;
            break label234;
            bool3 = false;
            break label617;
            bool4 = false;
            break label628;
            localObject3 = new byte[0];
            break label646;
          }
        }
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/msgsubscription/SubscribeMsgRequestResult$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "wxbiz-msgsubscription-sdk_release"})
  public static final class b
    implements Parcelable.Creator<SubscribeMsgRequestResult>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.SubscribeMsgRequestResult
 * JD-Core Version:    0.7.0.1
 */