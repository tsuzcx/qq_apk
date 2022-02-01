package com.tencent.mm.live.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "", "liveId", "", "micId", "", "audience", "roomId", "sdkUid", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAudience", "()Ljava/lang/String;", "setAudience", "(Ljava/lang/String;)V", "getLiveId", "()J", "setLiveId", "(J)V", "getMicId", "setMicId", "getRoomId", "setRoomId", "getSdkUid", "setSdkUid", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "plugin-logic_release"})
public final class a$a
{
  public static final a gxk;
  public long gmP;
  public String gxh;
  public String gxi;
  public String gxj;
  public String roomId;
  
  static
  {
    AppMethodBeat.i(189969);
    gxk = new a((byte)0);
    AppMethodBeat.o(189969);
  }
  
  public a$a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(189968);
    this.gmP = paramLong;
    this.gxh = paramString1;
    this.gxi = paramString2;
    this.roomId = paramString3;
    this.gxj = paramString4;
    AppMethodBeat.o(189968);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(189967);
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(189967);
      return false;
    }
    if (k.g(((a)paramObject).gxi, this.gxi))
    {
      AppMethodBeat.o(189967);
      return true;
    }
    AppMethodBeat.o(189967);
    return false;
  }
  
  public final int hashCode()
  {
    int m = 0;
    AppMethodBeat.i(189971);
    long l = this.gmP;
    int n = (int)(l ^ l >>> 32);
    String str = this.gxh;
    int i;
    int j;
    if (str != null)
    {
      i = str.hashCode();
      str = this.gxi;
      if (str == null) {
        break label128;
      }
      j = str.hashCode();
      label59:
      str = this.roomId;
      if (str == null) {
        break label133;
      }
    }
    label128:
    label133:
    for (int k = str.hashCode();; k = 0)
    {
      str = this.gxj;
      if (str != null) {
        m = str.hashCode();
      }
      AppMethodBeat.o(189971);
      return (k + (j + (i + n * 31) * 31) * 31) * 31 + m;
      i = 0;
      break;
      j = 0;
      break label59;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(189970);
    String str = "LiveMicUser(liveId=" + this.gmP + ", micId=" + this.gxh + ", audience=" + this.gxi + ", roomId=" + this.roomId + ", sdkUid=" + this.gxj + ")";
    AppMethodBeat.o(189970);
    return str;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser$Companion;", "", "()V", "getTitleModel", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.b.a.a
 * JD-Core Version:    0.7.0.1
 */