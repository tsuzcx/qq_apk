package com.tencent.mm.plugin.gamelive.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$LiveSingleCommentPayload;", "Landroid/os/Parcelable;", "msgType", "", "senderNickName", "", "senderHeadImgUrl", "content", "msgCreateTime", "msgSeq", "", "comboRewardCount", "rankingPosition", "rewardProductId", "thumbnailFileUrl", "giftName", "comboProductCount", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getComboProductCount", "()I", "setComboProductCount", "(I)V", "getComboRewardCount", "()Ljava/lang/Integer;", "setComboRewardCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getGiftName", "setGiftName", "getMsgCreateTime", "setMsgCreateTime", "getMsgSeq", "()Ljava/lang/Long;", "setMsgSeq", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getMsgType", "setMsgType", "getRankingPosition", "setRankingPosition", "getRewardProductId", "setRewardProductId", "getSenderHeadImgUrl", "setSenderHeadImgUrl", "getSenderNickName", "setSenderNickName", "getThumbnailFileUrl", "setThumbnailFileUrl", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$LiveSingleCommentPayload;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class GameLiveAppbrandEventService$LiveSingleCommentPayload
  implements Parcelable
{
  public static final Parcelable.Creator<LiveSingleCommentPayload> CREATOR;
  public String DKv;
  public Integer JfA;
  public String JfB;
  public String JfC;
  public Integer JfD;
  public Long JfE;
  public Integer JfF;
  public Integer JfG;
  public String JfH;
  public String JfI;
  public int JfJ;
  public String content;
  
  static
  {
    AppMethodBeat.i(277462);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(277462);
  }
  
  private GameLiveAppbrandEventService$LiveSingleCommentPayload(byte paramByte)
  {
    this();
  }
  
  public GameLiveAppbrandEventService$LiveSingleCommentPayload(Integer paramInteger1, String paramString1, String paramString2, String paramString3, Integer paramInteger2, Long paramLong, Integer paramInteger3, Integer paramInteger4, String paramString4, String paramString5, String paramString6, int paramInt)
  {
    this.JfA = paramInteger1;
    this.JfB = paramString1;
    this.JfC = paramString2;
    this.content = paramString3;
    this.JfD = paramInteger2;
    this.JfE = paramLong;
    this.JfF = paramInteger3;
    this.JfG = paramInteger4;
    this.JfH = paramString4;
    this.JfI = paramString5;
    this.DKv = paramString6;
    this.JfJ = paramInt;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(277493);
    if (this == paramObject)
    {
      AppMethodBeat.o(277493);
      return true;
    }
    if (!(paramObject instanceof LiveSingleCommentPayload))
    {
      AppMethodBeat.o(277493);
      return false;
    }
    paramObject = (LiveSingleCommentPayload)paramObject;
    if (!s.p(this.JfA, paramObject.JfA))
    {
      AppMethodBeat.o(277493);
      return false;
    }
    if (!s.p(this.JfB, paramObject.JfB))
    {
      AppMethodBeat.o(277493);
      return false;
    }
    if (!s.p(this.JfC, paramObject.JfC))
    {
      AppMethodBeat.o(277493);
      return false;
    }
    if (!s.p(this.content, paramObject.content))
    {
      AppMethodBeat.o(277493);
      return false;
    }
    if (!s.p(this.JfD, paramObject.JfD))
    {
      AppMethodBeat.o(277493);
      return false;
    }
    if (!s.p(this.JfE, paramObject.JfE))
    {
      AppMethodBeat.o(277493);
      return false;
    }
    if (!s.p(this.JfF, paramObject.JfF))
    {
      AppMethodBeat.o(277493);
      return false;
    }
    if (!s.p(this.JfG, paramObject.JfG))
    {
      AppMethodBeat.o(277493);
      return false;
    }
    if (!s.p(this.JfH, paramObject.JfH))
    {
      AppMethodBeat.o(277493);
      return false;
    }
    if (!s.p(this.JfI, paramObject.JfI))
    {
      AppMethodBeat.o(277493);
      return false;
    }
    if (!s.p(this.DKv, paramObject.DKv))
    {
      AppMethodBeat.o(277493);
      return false;
    }
    if (this.JfJ != paramObject.JfJ)
    {
      AppMethodBeat.o(277493);
      return false;
    }
    AppMethodBeat.o(277493);
    return true;
  }
  
  public final int hashCode()
  {
    int i6 = 0;
    AppMethodBeat.i(277485);
    int i;
    int j;
    label26:
    int k;
    label35:
    int m;
    label45:
    int n;
    label55:
    int i1;
    label65:
    int i2;
    label75:
    int i3;
    label85:
    int i4;
    label95:
    int i5;
    if (this.JfA == null)
    {
      i = 0;
      if (this.JfB != null) {
        break label200;
      }
      j = 0;
      if (this.JfC != null) {
        break label211;
      }
      k = 0;
      if (this.content != null) {
        break label222;
      }
      m = 0;
      if (this.JfD != null) {
        break label234;
      }
      n = 0;
      if (this.JfE != null) {
        break label246;
      }
      i1 = 0;
      if (this.JfF != null) {
        break label258;
      }
      i2 = 0;
      if (this.JfG != null) {
        break label270;
      }
      i3 = 0;
      if (this.JfH != null) {
        break label282;
      }
      i4 = 0;
      if (this.JfI != null) {
        break label294;
      }
      i5 = 0;
      label105:
      if (this.DKv != null) {
        break label306;
      }
    }
    for (;;)
    {
      int i7 = this.JfJ;
      AppMethodBeat.o(277485);
      return ((i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + i * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i6) * 31 + i7;
      i = this.JfA.hashCode();
      break;
      label200:
      j = this.JfB.hashCode();
      break label26;
      label211:
      k = this.JfC.hashCode();
      break label35;
      label222:
      m = this.content.hashCode();
      break label45;
      label234:
      n = this.JfD.hashCode();
      break label55;
      label246:
      i1 = this.JfE.hashCode();
      break label65;
      label258:
      i2 = this.JfF.hashCode();
      break label75;
      label270:
      i3 = this.JfG.hashCode();
      break label85;
      label282:
      i4 = this.JfH.hashCode();
      break label95;
      label294:
      i5 = this.JfI.hashCode();
      break label105;
      label306:
      i6 = this.DKv.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(277474);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("LiveSingleCommentPayload(msgType=").append(this.JfA).append(", senderNickName=").append(this.JfB).append(", senderHeadImgUrl=").append(this.JfC).append(", content=").append(this.content).append(", msgCreateTime=").append(this.JfD).append(", msgSeq=").append(this.JfE).append(", comboRewardCount=").append(this.JfF).append(", rankingPosition=").append(this.JfG).append(", rewardProductId=").append(this.JfH).append(", thumbnailFileUrl=").append(this.JfI).append(", giftName=").append(this.DKv).append(", comboProductCount=");
    ((StringBuilder)localObject).append(this.JfJ).append(')');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(277474);
    return localObject;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(277508);
    s.u(paramParcel, "out");
    Object localObject = this.JfA;
    if (localObject == null)
    {
      paramParcel.writeInt(0);
      paramParcel.writeString(this.JfB);
      paramParcel.writeString(this.JfC);
      paramParcel.writeString(this.content);
      localObject = this.JfD;
      if (localObject != null) {
        break label159;
      }
      paramParcel.writeInt(0);
      label63:
      localObject = this.JfE;
      if (localObject != null) {
        break label175;
      }
      paramParcel.writeInt(0);
      label77:
      localObject = this.JfF;
      if (localObject != null) {
        break label191;
      }
      paramParcel.writeInt(0);
      label91:
      localObject = this.JfG;
      if (localObject != null) {
        break label207;
      }
      paramParcel.writeInt(0);
    }
    for (;;)
    {
      paramParcel.writeString(this.JfH);
      paramParcel.writeString(this.JfI);
      paramParcel.writeString(this.DKv);
      paramParcel.writeInt(this.JfJ);
      AppMethodBeat.o(277508);
      return;
      paramParcel.writeInt(1);
      paramParcel.writeInt(((Integer)localObject).intValue());
      break;
      label159:
      paramParcel.writeInt(1);
      paramParcel.writeInt(((Integer)localObject).intValue());
      break label63;
      label175:
      paramParcel.writeInt(1);
      paramParcel.writeLong(((Long)localObject).longValue());
      break label77;
      label191:
      paramParcel.writeInt(1);
      paramParcel.writeInt(((Integer)localObject).intValue());
      break label91;
      label207:
      paramParcel.writeInt(1);
      paramParcel.writeInt(((Integer)localObject).intValue());
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<GameLiveAppbrandEventService.LiveSingleCommentPayload>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveSingleCommentPayload
 * JD-Core Version:    0.7.0.1
 */