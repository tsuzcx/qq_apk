package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.protocal.protobuf.ald;
import d.g.b.k;
import d.l;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderObject;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "shareObject", "Lcom/tencent/mm/protocal/protobuf/FinderShareObject;", "getShareObject", "()Lcom/tencent/mm/protocal/protobuf/FinderShareObject;", "setShareObject", "(Lcom/tencent/mm/protocal/protobuf/FinderShareObject;)V", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"})
public final class b
  extends f
{
  public ald htg;
  
  public b()
  {
    AppMethodBeat.i(168870);
    this.htg = new ald();
    AppMethodBeat.o(168870);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(168869);
    k.h(paramMap, "values");
    k.h(paramb, "content");
    paramMap = d.s(".msg.appmsg", paramMap);
    k.g(paramMap, "FinderShareParser.parse(\".msg.appmsg\", values)");
    this.htg = paramMap;
    AppMethodBeat.o(168869);
  }
  
  public final f apu()
  {
    AppMethodBeat.i(168867);
    Object localObject = new b();
    ((b)localObject).htg = this.htg;
    localObject = (f)localObject;
    AppMethodBeat.o(168867);
    return localObject;
  }
  
  public final void b(StringBuilder paramStringBuilder, k.b paramb, String paramString, com.tencent.mm.i.d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168868);
    k.h(paramStringBuilder, "sb");
    paramStringBuilder.append(d.a(this.htg));
    AppMethodBeat.o(168868);
  }
  
  public final ald cty()
  {
    return this.htg;
  }
  
  public final void d(ald paramald)
  {
    AppMethodBeat.i(203653);
    k.h(paramald, "<set-?>");
    this.htg = paramald;
    AppMethodBeat.o(203653);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.b
 * JD-Core Version:    0.7.0.1
 */