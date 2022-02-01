package com.tencent.mm.plugin.handoff.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.protocal.protobuf.dar;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "handOffType", "", "from", "", "to", "key", "id", "createTime", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getCreateTime", "()J", "setCreateTime", "(J)V", "getFrom", "()Ljava/lang/String;", "setFrom", "(Ljava/lang/String;)V", "getHandOffType", "()I", "setHandOffType", "(I)V", "getId", "setId", "getKey", "setKey", "getTo", "setTo", "body", "build", "copy", "createBallInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "createMultiTaskInfo", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/MultiTaskShowData;", "", "doCreateBallInfo", "doCreateMultiTaskInfo", "getDataType", "update", "", "newHandOff", "writeToParcel", "dest", "flags", "Companion", "api-handoff_release"})
@Keep
public abstract class HandOff
  implements Parcelable
{
  public static final a Companion = new a((byte)0);
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
    return a.generateKey(paramInt1, paramInt2);
  }
  
  protected abstract String body();
  
  public final String build()
  {
    return n.bHx("\n    <handoff type=\"" + getDataType() + "\" id=\"" + this.id + "\" createtime=\"" + this.createTime + "\" from=\"" + this.from + "\" to=\"" + this.to + "\">\n        <handofftype>" + a.dy(Integer.valueOf(this.handOffType)) + "</handofftype>\n        " + body() + "\n    </handoff>\n    ");
  }
  
  public abstract HandOff copy();
  
  public final BallInfo createBallInfo()
  {
    BallInfo localBallInfo = doCreateBallInfo();
    if (localBallInfo != null)
    {
      localBallInfo.mab.putString("handoff#id", this.id);
      return localBallInfo;
    }
    return null;
  }
  
  public final o<dar, byte[]> createMultiTaskInfo()
  {
    return doCreateMultiTaskInfo();
  }
  
  protected abstract BallInfo doCreateBallInfo();
  
  protected abstract o<dar, byte[]> doCreateMultiTaskInfo();
  
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
  
  public final void setCreateTime(long paramLong)
  {
    this.createTime = paramLong;
  }
  
  public final void setFrom(String paramString)
  {
    p.k(paramString, "<set-?>");
    this.from = paramString;
  }
  
  public final void setHandOffType(int paramInt)
  {
    this.handOffType = paramInt;
  }
  
  public final void setId(String paramString)
  {
    p.k(paramString, "<set-?>");
    this.id = paramString;
  }
  
  public final void setKey(String paramString)
  {
    p.k(paramString, "<set-?>");
    this.key = paramString;
  }
  
  public final void setTo(String paramString)
  {
    p.k(paramString, "<set-?>");
    this.to = paramString;
  }
  
  public void update(HandOff paramHandOff)
  {
    p.k(paramHandOff, "newHandOff");
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    p.k(paramParcel, "dest");
    paramParcel.writeInt(this.handOffType);
    paramParcel.writeString(this.from);
    paramParcel.writeString(this.to);
    paramParcel.writeString(this.key);
    paramParcel.writeString(this.id);
    paramParcel.writeLong(this.createTime);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/handoff/model/HandOff$Companion;", "", "()V", "KId", "", "generateKey", "dataType", "", "handOffType", "api-handoff_release"})
  public static final class a
  {
    public static String generateKey(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(121692);
      String str = paramInt1 + '_' + paramInt2 + '_' + System.currentTimeMillis();
      AppMethodBeat.o(121692);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.model.HandOff
 * JD-Core Version:    0.7.0.1
 */