package com.tencent.mm.message.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.d;
import com.tencent.mm.message.f;
import com.tencent.mm.message.k.b;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/message/piece/TeenModeAppMsgPiece;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "referMsg", "", "getReferMsg", "()Ljava/lang/String;", "setReferMsg", "(Ljava/lang/String;)V", "teenagerModeGuardianTicket", "getTeenagerModeGuardianTicket", "setTeenagerModeGuardianTicket", "teenagerModeTempAccessBizKey", "getTeenagerModeTempAccessBizKey", "setTeenagerModeTempAccessBizKey", "teenagerModeTempAccessBizType", "", "getTeenagerModeTempAccessBizType", "()I", "setTeenagerModeTempAccessBizType", "(I)V", "cloneContent", "getRefMsgVal", "oriContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "thumbHeight", "parseContent", "values", "", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends f
{
  public static final c.a nVF;
  public String nVG;
  public String nVH;
  public int nVI;
  public String nVJ;
  
  static
  {
    AppMethodBeat.i(233957);
    nVF = new c.a((byte)0);
    AppMethodBeat.o(233957);
  }
  
  private static String Hn(String paramString)
  {
    AppMethodBeat.i(233953);
    try
    {
      s.checkNotNull(paramString);
      paramString = paramString.substring(n.a((CharSequence)paramString, "<refermsg>", 0, false, 4) + 10, n.g((CharSequence)paramString, "</refermsg>"));
      s.s(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      AppMethodBeat.o(233953);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(233953);
    }
    return "";
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(233964);
    if ((this.nVG != null) && (paramStringBuilder != null)) {
      paramStringBuilder.append("<teenagerModeGuardianTicket>" + this.nVG + "</teenagerModeGuardianTicket>");
    }
    if (this.nVI > 0)
    {
      if (paramStringBuilder != null) {
        paramStringBuilder.append("<teenagerModeTempAccessBizType>" + this.nVI + "</teenagerModeTempAccessBizType>");
      }
      if (paramStringBuilder != null) {
        paramStringBuilder.append("<teenagerModeTempAccessBizKey>" + this.nVH + "</teenagerModeTempAccessBizKey>");
      }
      if (paramStringBuilder != null) {
        paramStringBuilder.append("<refermsg>" + this.nVJ + "</refermsg>");
      }
    }
    AppMethodBeat.o(233964);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    Object localObject = null;
    AppMethodBeat.i(233968);
    String str;
    if (paramMap == null)
    {
      str = null;
      this.nVG = str;
      if (paramMap != null) {
        break label81;
      }
      str = null;
      label25:
      this.nVI = Util.getInt(str, 0);
      if (paramMap != null) {
        break label96;
      }
      paramMap = null;
      label40:
      this.nVH = paramMap;
      if (paramb != null) {
        break label111;
      }
    }
    label81:
    label96:
    label111:
    for (paramMap = localObject;; paramMap = paramb.nUe)
    {
      this.nVJ = Hn(paramMap);
      AppMethodBeat.o(233968);
      return;
      str = (String)paramMap.get(".msg.appmsg.teenagerModeGuardianTicket");
      break;
      str = (String)paramMap.get(".msg.appmsg.teenagerModeTempAccessBizType");
      break label25;
      paramMap = (String)paramMap.get(".msg.appmsg.teenagerModeTempAccessBizKey");
      break label40;
    }
  }
  
  public final f biW()
  {
    AppMethodBeat.i(233961);
    Object localObject = new c();
    ((c)localObject).nVG = this.nVG;
    ((c)localObject).nVH = this.nVH;
    ((c)localObject).nVI = this.nVI;
    localObject = (f)localObject;
    AppMethodBeat.o(233961);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.message.a.c
 * JD-Core Version:    0.7.0.1
 */