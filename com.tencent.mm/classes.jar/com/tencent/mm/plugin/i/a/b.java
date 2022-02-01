package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.axf;
import java.util.Map;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/findersdk/api/AppMSgContentFinderLiveObject;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "shareObject", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "getShareObject", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "setShareObject", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;)V", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"})
public final class b
  extends f
{
  public axf wDV;
  
  public b()
  {
    AppMethodBeat.i(208762);
    this.wDV = new axf();
    AppMethodBeat.o(208762);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208760);
    p.h(paramStringBuilder, "sb");
    paramStringBuilder.append(l.c(this.wDV));
    AppMethodBeat.o(208760);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(208761);
    p.h(paramMap, "values");
    p.h(paramb, "content");
    paramMap = l.v(".msg.appmsg", paramMap);
    p.g(paramMap, "FinderShareParser.parseF…ve(\".msg.appmsg\", values)");
    this.wDV = paramMap;
    AppMethodBeat.o(208761);
  }
  
  public final f aHj()
  {
    AppMethodBeat.i(208759);
    Object localObject = new b();
    ((b)localObject).wDV = this.wDV;
    localObject = (f)localObject;
    AppMethodBeat.o(208759);
    return localObject;
  }
  
  public final void b(axf paramaxf)
  {
    AppMethodBeat.i(208758);
    p.h(paramaxf, "<set-?>");
    this.wDV = paramaxf;
    AppMethodBeat.o(208758);
  }
  
  public final axf dJu()
  {
    return this.wDV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.b
 * JD-Core Version:    0.7.0.1
 */