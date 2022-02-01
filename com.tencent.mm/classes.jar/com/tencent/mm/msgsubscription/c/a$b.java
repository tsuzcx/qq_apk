package com.tencent.mm.msgsubscription.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter$SubscribeMsgReportInfo;", "", "()V", "jumpInfo", "", "getJumpInfo", "()Ljava/lang/String;", "setJumpInfo", "(Ljava/lang/String;)V", "jumpType", "", "getJumpType", "()I", "setJumpType", "(I)V", "msgContent", "getMsgContent", "setMsgContent", "msgTitle", "getMsgTitle", "setMsgTitle", "templateId", "getTemplateId", "setTemplateId", "templateType", "getTemplateType", "setTemplateType", "type", "getType", "setType", "username", "getUsername", "setUsername", "reset", "", "AccountType", "SubscribeMsgJumpType", "SubscribeMsgOpType", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$b
{
  String hWn = "";
  public int jumpType;
  public String nSg = "";
  public int phR;
  public String pjO = "";
  String pjP = "";
  public int type;
  String username = "";
  
  public final void Rb(String paramString)
  {
    AppMethodBeat.i(236257);
    s.u(paramString, "<set-?>");
    this.hWn = paramString;
    AppMethodBeat.o(236257);
  }
  
  public final void Rc(String paramString)
  {
    AppMethodBeat.i(236261);
    s.u(paramString, "<set-?>");
    this.pjP = paramString;
    AppMethodBeat.o(236261);
  }
  
  public final void reset()
  {
    this.username = "";
    this.type = 0;
    this.nSg = "";
    this.phR = 0;
    this.pjO = "";
    this.hWn = "";
    this.jumpType = 0;
    this.pjP = "";
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(236253);
    s.u(paramString, "<set-?>");
    this.username = paramString;
    AppMethodBeat.o(236253);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.c.a.b
 * JD-Core Version:    0.7.0.1
 */