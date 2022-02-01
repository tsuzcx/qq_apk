package com.tencent.mm.plugin.gamelive.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$LiveSingleCommentPayload;", "Landroid/os/Parcelable;", "msgType", "", "senderNickName", "", "senderHeadImgUrl", "content", "msgCreateTime", "msgSeq", "", "comboRewardCount", "rankingPosition", "rewardProductId", "thumbnailFileUrl", "giftName", "comboProductCount", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getComboProductCount", "()I", "setComboProductCount", "(I)V", "getComboRewardCount", "()Ljava/lang/Integer;", "setComboRewardCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getGiftName", "setGiftName", "getMsgCreateTime", "setMsgCreateTime", "getMsgSeq", "()Ljava/lang/Long;", "setMsgSeq", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getMsgType", "setMsgType", "getRankingPosition", "setRankingPosition", "getRewardProductId", "setRewardProductId", "getSenderHeadImgUrl", "setSenderHeadImgUrl", "getSenderNickName", "setSenderNickName", "getThumbnailFileUrl", "setThumbnailFileUrl", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$LiveSingleCommentPayload;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-gamelive_release"})
public final class GameLiveAppbrandEventService$LiveSingleCommentPayload
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR;
  public Integer Dmm;
  public String Dmn;
  public String Dmo;
  public Integer Dmp;
  public Long Dmq;
  public Integer Dmr;
  public Integer Dms;
  public String Dmt;
  public String Dmu;
  public int Dmv;
  public String content;
  public String ySp;
  
  static
  {
    AppMethodBeat.i(207862);
    CREATOR = new a();
    AppMethodBeat.o(207862);
  }
  
  private GameLiveAppbrandEventService$LiveSingleCommentPayload(byte paramByte)
  {
    this();
  }
  
  public GameLiveAppbrandEventService$LiveSingleCommentPayload(Integer paramInteger1, String paramString1, String paramString2, String paramString3, Integer paramInteger2, Long paramLong, Integer paramInteger3, Integer paramInteger4, String paramString4, String paramString5, String paramString6, int paramInt)
  {
    this.Dmm = paramInteger1;
    this.Dmn = paramString1;
    this.Dmo = paramString2;
    this.content = paramString3;
    this.Dmp = paramInteger2;
    this.Dmq = paramLong;
    this.Dmr = paramInteger3;
    this.Dms = paramInteger4;
    this.Dmt = paramString4;
    this.Dmu = paramString5;
    this.ySp = paramString6;
    this.Dmv = paramInt;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(207855);
    if (this != paramObject)
    {
      if ((paramObject instanceof LiveSingleCommentPayload))
      {
        paramObject = (LiveSingleCommentPayload)paramObject;
        if ((!p.h(this.Dmm, paramObject.Dmm)) || (!p.h(this.Dmn, paramObject.Dmn)) || (!p.h(this.Dmo, paramObject.Dmo)) || (!p.h(this.content, paramObject.content)) || (!p.h(this.Dmp, paramObject.Dmp)) || (!p.h(this.Dmq, paramObject.Dmq)) || (!p.h(this.Dmr, paramObject.Dmr)) || (!p.h(this.Dms, paramObject.Dms)) || (!p.h(this.Dmt, paramObject.Dmt)) || (!p.h(this.Dmu, paramObject.Dmu)) || (!p.h(this.ySp, paramObject.ySp)) || (this.Dmv != paramObject.Dmv)) {}
      }
    }
    else
    {
      AppMethodBeat.o(207855);
      return true;
    }
    AppMethodBeat.o(207855);
    return false;
  }
  
  public final int hashCode()
  {
    int i6 = 0;
    AppMethodBeat.i(207853);
    Object localObject = this.Dmm;
    int i;
    int j;
    label42:
    int k;
    label59:
    int m;
    label77:
    int n;
    label95:
    int i1;
    label113:
    int i2;
    label131:
    int i3;
    label149:
    int i4;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.Dmn;
      if (localObject == null) {
        break label285;
      }
      j = localObject.hashCode();
      localObject = this.Dmo;
      if (localObject == null) {
        break label290;
      }
      k = localObject.hashCode();
      localObject = this.content;
      if (localObject == null) {
        break label295;
      }
      m = localObject.hashCode();
      localObject = this.Dmp;
      if (localObject == null) {
        break label301;
      }
      n = localObject.hashCode();
      localObject = this.Dmq;
      if (localObject == null) {
        break label307;
      }
      i1 = localObject.hashCode();
      localObject = this.Dmr;
      if (localObject == null) {
        break label313;
      }
      i2 = localObject.hashCode();
      localObject = this.Dms;
      if (localObject == null) {
        break label319;
      }
      i3 = localObject.hashCode();
      localObject = this.Dmt;
      if (localObject == null) {
        break label325;
      }
      i4 = localObject.hashCode();
      label167:
      localObject = this.Dmu;
      if (localObject == null) {
        break label331;
      }
    }
    label285:
    label290:
    label295:
    label301:
    label307:
    label313:
    label319:
    label325:
    label331:
    for (int i5 = localObject.hashCode();; i5 = 0)
    {
      localObject = this.ySp;
      if (localObject != null) {
        i6 = localObject.hashCode();
      }
      int i7 = this.Dmv;
      AppMethodBeat.o(207853);
      return ((i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + i * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i6) * 31 + i7;
      i = 0;
      break;
      j = 0;
      break label42;
      k = 0;
      break label59;
      m = 0;
      break label77;
      n = 0;
      break label95;
      i1 = 0;
      break label113;
      i2 = 0;
      break label131;
      i3 = 0;
      break label149;
      i4 = 0;
      break label167;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(207851);
    String str = "LiveSingleCommentPayload(msgType=" + this.Dmm + ", senderNickName=" + this.Dmn + ", senderHeadImgUrl=" + this.Dmo + ", content=" + this.content + ", msgCreateTime=" + this.Dmp + ", msgSeq=" + this.Dmq + ", comboRewardCount=" + this.Dmr + ", rankingPosition=" + this.Dms + ", rewardProductId=" + this.Dmt + ", thumbnailFileUrl=" + this.Dmu + ", giftName=" + this.ySp + ", comboProductCount=" + this.Dmv + ")";
    AppMethodBeat.o(207851);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(207859);
    p.k(paramParcel, "parcel");
    Object localObject = this.Dmm;
    if (localObject != null)
    {
      paramParcel.writeInt(1);
      paramParcel.writeInt(((Integer)localObject).intValue());
      paramParcel.writeString(this.Dmn);
      paramParcel.writeString(this.Dmo);
      paramParcel.writeString(this.content);
      localObject = this.Dmp;
      if (localObject == null) {
        break label191;
      }
      paramParcel.writeInt(1);
      paramParcel.writeInt(((Integer)localObject).intValue());
      label79:
      localObject = this.Dmq;
      if (localObject == null) {
        break label199;
      }
      paramParcel.writeInt(1);
      paramParcel.writeLong(((Long)localObject).longValue());
      label101:
      localObject = this.Dmr;
      if (localObject == null) {
        break label207;
      }
      paramParcel.writeInt(1);
      paramParcel.writeInt(((Integer)localObject).intValue());
      label123:
      localObject = this.Dms;
      if (localObject == null) {
        break label215;
      }
      paramParcel.writeInt(1);
      paramParcel.writeInt(((Integer)localObject).intValue());
    }
    for (;;)
    {
      paramParcel.writeString(this.Dmt);
      paramParcel.writeString(this.Dmu);
      paramParcel.writeString(this.ySp);
      paramParcel.writeInt(this.Dmv);
      AppMethodBeat.o(207859);
      return;
      paramParcel.writeInt(0);
      break;
      label191:
      paramParcel.writeInt(0);
      break label79;
      label199:
      paramParcel.writeInt(0);
      break label101;
      label207:
      paramParcel.writeInt(0);
      break label123;
      label215:
      paramParcel.writeInt(0);
    }
  }
  
  @l(iBK={1, 1, 16})
  public static final class a
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      Integer localInteger4 = null;
      AppMethodBeat.i(208648);
      p.k(paramParcel, "in");
      Integer localInteger1;
      String str1;
      String str2;
      String str3;
      Integer localInteger2;
      label62:
      Long localLong;
      if (paramParcel.readInt() != 0)
      {
        localInteger1 = Integer.valueOf(paramParcel.readInt());
        str1 = paramParcel.readString();
        str2 = paramParcel.readString();
        str3 = paramParcel.readString();
        if (paramParcel.readInt() == 0) {
          break label160;
        }
        localInteger2 = Integer.valueOf(paramParcel.readInt());
        if (paramParcel.readInt() == 0) {
          break label165;
        }
        localLong = Long.valueOf(paramParcel.readLong());
        label78:
        if (paramParcel.readInt() == 0) {
          break label171;
        }
      }
      label160:
      label165:
      label171:
      for (Integer localInteger3 = Integer.valueOf(paramParcel.readInt());; localInteger3 = null)
      {
        if (paramParcel.readInt() != 0) {
          localInteger4 = Integer.valueOf(paramParcel.readInt());
        }
        paramParcel = new GameLiveAppbrandEventService.LiveSingleCommentPayload(localInteger1, str1, str2, str3, localInteger2, localLong, localInteger3, localInteger4, paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readInt());
        AppMethodBeat.o(208648);
        return paramParcel;
        localInteger1 = null;
        break;
        localInteger2 = null;
        break label62;
        localLong = null;
        break label78;
      }
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new GameLiveAppbrandEventService.LiveSingleCommentPayload[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveSingleCommentPayload
 * JD-Core Version:    0.7.0.1
 */