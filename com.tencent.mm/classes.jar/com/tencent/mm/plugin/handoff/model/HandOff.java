package com.tencent.mm.plugin.handoff.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.protocal.protobuf.drz;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "handOffType", "", "from", "", "to", "key", "id", "createTime", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getCreateTime", "()J", "setCreateTime", "(J)V", "getFrom", "()Ljava/lang/String;", "setFrom", "(Ljava/lang/String;)V", "getHandOffType", "()I", "setHandOffType", "(I)V", "getId", "setId", "getKey", "setKey", "getTo", "setTo", "body", "build", "copy", "createBallInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "createMultiTaskInfo", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/MultiTaskShowData;", "", "doCreateBallInfo", "doCreateMultiTaskInfo", "equals", "", "other", "", "getDataType", "hashCode", "update", "newHandOff", "writeToParcel", "", "dest", "flags", "Companion", "api-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class HandOff
  implements Parcelable
{
  public static final HandOff.a Companion = new HandOff.a((byte)0);
  public static final String KId = "handoff#id";
  private long createTime;
  private String from;
  private int handOffType;
  private String id;
  private String key;
  private String to;
  
  public HandOff(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    this.handOffType = paramInt;
    this.from = paramString1;
    this.to = paramString2;
    this.key = paramString3;
    this.id = paramString4;
    this.createTime = paramLong;
  }
  
  public HandOff(Parcel paramParcel)
  {
    this(i, str1, str2, str3, str4, paramParcel.readLong());
  }
  
  public static final String generateKey(int paramInt1, int paramInt2)
  {
    return HandOff.a.generateKey(paramInt1, paramInt2);
  }
  
  protected abstract String body();
  
  public final String build()
  {
    return n.bJB("\n    <handoff type=\"" + getDataType() + "\" id=\"" + this.id + "\" createtime=\"" + this.createTime + "\" from=\"" + this.from + "\" to=\"" + this.to + "\">\n        <handofftype>" + a.fP(Integer.valueOf(this.handOffType)) + "</handofftype>\n        " + body() + "\n    </handoff>\n    ");
  }
  
  public abstract HandOff copy();
  
  public final BallInfo createBallInfo()
  {
    BallInfo localBallInfo = doCreateBallInfo();
    if (localBallInfo == null) {
      return null;
    }
    localBallInfo.oSS.putString("handoff#id", getId());
    return localBallInfo;
  }
  
  public final r<drz, byte[]> createMultiTaskInfo()
  {
    return doCreateMultiTaskInfo();
  }
  
  protected abstract BallInfo doCreateBallInfo();
  
  protected abstract r<drz, byte[]> doCreateMultiTaskInfo();
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof HandOff)) {
      return false;
    }
    if (this.handOffType != ((HandOff)paramObject).handOffType) {
      return false;
    }
    if (!s.p(this.from, ((HandOff)paramObject).from)) {
      return false;
    }
    if (!s.p(this.to, ((HandOff)paramObject).to)) {
      return false;
    }
    if (!s.p(this.key, ((HandOff)paramObject).key)) {
      return false;
    }
    return s.p(this.id, ((HandOff)paramObject).id);
  }
  
  public final long getCreateTime()
  {
    return this.createTime;
  }
  
  public abstract int getDataType();
  
  public final String getFrom()
  {
    return this.from;
  }
  
  public final int getHandOffType()
  {
    return this.handOffType;
  }
  
  public final String getId()
  {
    return this.id;
  }
  
  public final String getKey()
  {
    return this.key;
  }
  
  public final String getTo()
  {
    return this.to;
  }
  
  public int hashCode()
  {
    return (((this.handOffType * 31 + this.from.hashCode()) * 31 + this.to.hashCode()) * 31 + this.key.hashCode()) * 31 + this.id.hashCode();
  }
  
  public final void setCreateTime(long paramLong)
  {
    this.createTime = paramLong;
  }
  
  public final void setFrom(String paramString)
  {
    s.u(paramString, "<set-?>");
    this.from = paramString;
  }
  
  public final void setHandOffType(int paramInt)
  {
    this.handOffType = paramInt;
  }
  
  public final void setId(String paramString)
  {
    s.u(paramString, "<set-?>");
    this.id = paramString;
  }
  
  public final void setKey(String paramString)
  {
    s.u(paramString, "<set-?>");
    this.key = paramString;
  }
  
  public final void setTo(String paramString)
  {
    s.u(paramString, "<set-?>");
    this.to = paramString;
  }
  
  public boolean update(HandOff paramHandOff)
  {
    s.u(paramHandOff, "newHandOff");
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    s.u(paramParcel, "dest");
    paramParcel.writeInt(getHandOffType());
    paramParcel.writeString(getFrom());
    paramParcel.writeString(getTo());
    paramParcel.writeString(getKey());
    paramParcel.writeString(getId());
    paramParcel.writeLong(getCreateTime());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.model.HandOff
 * JD-Core Version:    0.7.0.1
 */