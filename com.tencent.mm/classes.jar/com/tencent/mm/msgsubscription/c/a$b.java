package com.tencent.mm.msgsubscription.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter$SubscribeMsgReportInfo;", "", "()V", "jumpInfo", "", "getJumpInfo", "()Ljava/lang/String;", "setJumpInfo", "(Ljava/lang/String;)V", "jumpType", "", "getJumpType", "()I", "setJumpType", "(I)V", "msgContent", "getMsgContent", "setMsgContent", "msgTitle", "getMsgTitle", "setMsgTitle", "templateId", "getTemplateId", "setTemplateId", "templateType", "getTemplateType", "setTemplateType", "type", "getType", "setType", "username", "getUsername", "setUsername", "reset", "", "AccountType", "SubscribeMsgJumpType", "SubscribeMsgOpType", "plugin-comm_release"})
public final class a$b
{
  String fQs = "";
  public int jumpType;
  public String lnb = "";
  public int mod;
  public String mqc = "";
  String mqd = "";
  public int type;
  String username = "";
  
  public final void YW(String paramString)
  {
    AppMethodBeat.i(219051);
    p.k(paramString, "<set-?>");
    this.fQs = paramString;
    AppMethodBeat.o(219051);
  }
  
  public final void YX(String paramString)
  {
    AppMethodBeat.i(219053);
    p.k(paramString, "<set-?>");
    this.mqd = paramString;
    AppMethodBeat.o(219053);
  }
  
  public final void reset()
  {
    this.username = "";
    this.type = 0;
    this.lnb = "";
    this.mod = 0;
    this.mqc = "";
    this.fQs = "";
    this.jumpType = 0;
    this.mqd = "";
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(219050);
    p.k(paramString, "<set-?>");
    this.username = paramString;
    AppMethodBeat.o(219050);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.c.a.b
 * JD-Core Version:    0.7.0.1
 */