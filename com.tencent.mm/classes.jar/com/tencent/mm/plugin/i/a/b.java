package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.arj;
import d.g.b.p;
import d.l;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderObject;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "shareObject", "Lcom/tencent/mm/protocal/protobuf/FinderShareObject;", "getShareObject", "()Lcom/tencent/mm/protocal/protobuf/FinderShareObject;", "setShareObject", "(Lcom/tencent/mm/protocal/protobuf/FinderShareObject;)V", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"})
public final class b
  extends f
{
  public arj inc;
  
  public b()
  {
    AppMethodBeat.i(168870);
    this.inc = new arj();
    AppMethodBeat.o(168870);
  }
  
  public final void a(arj paramarj)
  {
    AppMethodBeat.i(209021);
    p.h(paramarj, "<set-?>");
    this.inc = paramarj;
    AppMethodBeat.o(209021);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168868);
    p.h(paramStringBuilder, "sb");
    paramStringBuilder.append(e.b(this.inc));
    AppMethodBeat.o(168868);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(168869);
    p.h(paramMap, "values");
    p.h(paramb, "content");
    paramMap = e.v(".msg.appmsg", paramMap);
    p.g(paramMap, "FinderShareParser.parse(\".msg.appmsg\", values)");
    this.inc = paramMap;
    AppMethodBeat.o(168869);
  }
  
  public final f aot()
  {
    AppMethodBeat.i(168867);
    Object localObject = new b();
    ((b)localObject).inc = this.inc;
    localObject = (f)localObject;
    AppMethodBeat.o(168867);
    return localObject;
  }
  
  public final arj cOZ()
  {
    return this.inc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.b
 * JD-Core Version:    0.7.0.1
 */