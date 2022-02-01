package com.tencent.mm.live.model.b;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "", "liveId", "", "micId", "", "audience", "roomId", "sdkUid", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAudience", "()Ljava/lang/String;", "setAudience", "(Ljava/lang/String;)V", "getLiveId", "()J", "setLiveId", "(J)V", "getMicId", "setMicId", "getRoomId", "setRoomId", "getSdkUid", "setSdkUid", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$a
{
  public static final a nbQ;
  public long liveId;
  public String mXH;
  public String mXK;
  public String mXx;
  public String roomId;
  
  static
  {
    AppMethodBeat.i(246709);
    nbQ = new a((byte)0);
    AppMethodBeat.o(246709);
  }
  
  public a$a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(246702);
    this.liveId = paramLong;
    this.mXx = paramString1;
    this.mXK = paramString2;
    this.roomId = paramString3;
    this.mXH = paramString4;
    AppMethodBeat.o(246702);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(246717);
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(246717);
      return false;
    }
    if (s.p(((a)paramObject).mXK, this.mXK))
    {
      AppMethodBeat.o(246717);
      return true;
    }
    AppMethodBeat.o(246717);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(246729);
    int i = q.a..ExternalSyntheticBackport0.m(this.liveId);
    int j = this.mXx.hashCode();
    int k = this.mXK.hashCode();
    int m = this.roomId.hashCode();
    int n = this.mXH.hashCode();
    AppMethodBeat.o(246729);
    return (((i * 31 + j) * 31 + k) * 31 + m) * 31 + n;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(246722);
    String str = "LiveMicUser(liveId=" + this.liveId + ", micId=" + this.mXx + ", audience=" + this.mXK + ", roomId=" + this.roomId + ", sdkUid=" + this.mXH + ')';
    AppMethodBeat.o(246722);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser$Companion;", "", "()V", "getTitleModel", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.model.b.a.a
 * JD-Core Version:    0.7.0.1
 */