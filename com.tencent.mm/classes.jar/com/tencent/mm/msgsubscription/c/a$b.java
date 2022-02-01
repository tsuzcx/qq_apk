package com.tencent.mm.msgsubscription.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter$SubscribeMsgReportInfo;", "", "()V", "jumpInfo", "", "getJumpInfo", "()Ljava/lang/String;", "setJumpInfo", "(Ljava/lang/String;)V", "jumpType", "", "getJumpType", "()I", "setJumpType", "(I)V", "msgContent", "getMsgContent", "setMsgContent", "msgTitle", "getMsgTitle", "setMsgTitle", "templateId", "getTemplateId", "setTemplateId", "templateType", "getTemplateType", "setTemplateType", "type", "getType", "setType", "username", "getUsername", "setUsername", "reset", "", "AccountType", "SubscribeMsgJumpType", "SubscribeMsgOpType", "plugin-comm_release"})
public final class a$b
{
  public String dWG = "";
  public String ixM = "";
  public String jAu = "";
  public String jAv = "";
  public int jumpType;
  public int jyz;
  public int type;
  public String username = "";
  
  public final void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(223333);
    p.h(paramString, "<set-?>");
    this.username = paramString;
    AppMethodBeat.o(223333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.c.a.b
 * JD-Core Version:    0.7.0.1
 */