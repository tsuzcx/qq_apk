package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.bcj;
import java.util.Map;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderObject;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "shareObject", "Lcom/tencent/mm/protocal/protobuf/FinderShareObject;", "getShareObject", "()Lcom/tencent/mm/protocal/protobuf/FinderShareObject;", "setShareObject", "(Lcom/tencent/mm/protocal/protobuf/FinderShareObject;)V", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"})
public final class f
  extends com.tencent.mm.ag.f
{
  public bcj jlg;
  
  public f()
  {
    AppMethodBeat.i(168870);
    this.jlg = new bcj();
    AppMethodBeat.o(168870);
  }
  
  public final void a(bcj parambcj)
  {
    AppMethodBeat.i(208778);
    p.h(parambcj, "<set-?>");
    this.jlg = parambcj;
    AppMethodBeat.o(208778);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168868);
    p.h(paramStringBuilder, "sb");
    paramStringBuilder.append(l.b(this.jlg));
    AppMethodBeat.o(168868);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(168869);
    p.h(paramMap, "values");
    p.h(paramb, "content");
    paramMap = l.x(".msg.appmsg", paramMap);
    p.g(paramMap, "FinderShareParser.parse(\".msg.appmsg\", values)");
    this.jlg = paramMap;
    AppMethodBeat.o(168869);
  }
  
  public final com.tencent.mm.ag.f aHj()
  {
    AppMethodBeat.i(168867);
    Object localObject = new f();
    ((f)localObject).jlg = this.jlg;
    localObject = (com.tencent.mm.ag.f)localObject;
    AppMethodBeat.o(168867);
    return localObject;
  }
  
  public final bcj dJx()
  {
    return this.jlg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.f
 * JD-Core Version:    0.7.0.1
 */