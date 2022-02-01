package com.tencent.mm.plugin.fts.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/fts/ui/logic/FTSEducationRedDot;", "", "msgId", "", "(Ljava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "bizType", "", "getBizType", "()J", "setBizType", "(J)V", "clientVersion", "", "getClientVersion", "()I", "setClientVersion", "(I)V", "exposeExpiredTime", "getExposeExpiredTime", "setExposeExpiredTime", "exposeTimestamp", "getExposeTimestamp", "setExposeTimestamp", "h5Version", "getH5Version", "setH5Version", "getMsgId", "setMsgId", "redDotAction", "getRedDotAction", "setRedDotAction", "component1", "copy", "equals", "", "other", "fromJSONStr", "", "value", "hashCode", "needShowRedDot", "showRedDot", "toJSONStr", "toString", "ui-fts_release"})
public final class g
{
  long BQf;
  long BQg;
  long BQh;
  int BQi;
  long BQj;
  final String TAG;
  int lZO;
  String msgId;
  
  private g(String paramString)
  {
    AppMethodBeat.i(189811);
    this.msgId = paramString;
    this.TAG = "MicroMsg.FTS.FTSEducationRedDot";
    this.BQh = -1L;
    AppMethodBeat.o(189811);
  }
  
  public final boolean NH(long paramLong)
  {
    AppMethodBeat.i(189802);
    long l;
    if (this.BQj == 0L)
    {
      l = cm.bfE();
      if ((this.BQh != paramLong) || (this.BQi != 1) || (l + this.BQg * 1000L < cm.bfE()) || (d.RAD < this.lZO) || (ai.anh(0) < this.BQf)) {
        break label127;
      }
    }
    label127:
    for (boolean bool = true;; bool = false)
    {
      Log.i(this.TAG, "needShowRedDot " + bool + ' ' + paramLong);
      AppMethodBeat.o(189802);
      return bool;
      l = this.BQj;
      break;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(189822);
    if (this != paramObject)
    {
      if ((paramObject instanceof g))
      {
        paramObject = (g)paramObject;
        if (!p.h(this.msgId, paramObject.msgId)) {}
      }
    }
    else
    {
      AppMethodBeat.o(189822);
      return true;
    }
    AppMethodBeat.o(189822);
    return false;
  }
  
  public final String erW()
  {
    AppMethodBeat.i(189810);
    Object localObject = new i();
    ((i)localObject).g("msgId", this.msgId);
    ((i)localObject).s("h5Version", this.BQf);
    ((i)localObject).s("exposeExpiredTime", this.BQg);
    ((i)localObject).s("bizType", this.BQh);
    ((i)localObject).al("redDotAction", this.BQi);
    ((i)localObject).s("exposeTimestamp", this.BQj);
    localObject = ((i)localObject).toString();
    p.j(localObject, "json.toString()");
    AppMethodBeat.o(189810);
    return localObject;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(189818);
    String str = this.msgId;
    if (str != null)
    {
      int i = str.hashCode();
      AppMethodBeat.o(189818);
      return i;
    }
    AppMethodBeat.o(189818);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(189816);
    String str = "FTSEducationRedDot(msgId=" + this.msgId + ")";
    AppMethodBeat.o(189816);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.g
 * JD-Core Version:    0.7.0.1
 */