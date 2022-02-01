package com.tencent.mm.plugin.findersdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.bcp;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/api/AppMSgContentFinderLiveObject;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "shareObject", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "getShareObject", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "setShareObject", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;)V", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"})
public final class b
  extends f
{
  public bcp Bvb;
  
  public b()
  {
    AppMethodBeat.i(208882);
    this.Bvb = new bcp();
    AppMethodBeat.o(208882);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208879);
    p.k(paramStringBuilder, "sb");
    paramStringBuilder.append(k.c(this.Bvb));
    AppMethodBeat.o(208879);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(208881);
    p.k(paramMap, "values");
    p.k(paramb, "content");
    paramMap = k.u(".msg.appmsg", paramMap);
    p.j(paramMap, "FinderShareParser.parseF…ve(\".msg.appmsg\", values)");
    this.Bvb = paramMap;
    AppMethodBeat.o(208881);
  }
  
  public final f aPj()
  {
    AppMethodBeat.i(208878);
    Object localObject = new b();
    ((b)localObject).Bvb = this.Bvb;
    localObject = (f)localObject;
    AppMethodBeat.o(208878);
    return localObject;
  }
  
  public final void b(bcp parambcp)
  {
    AppMethodBeat.i(208877);
    p.k(parambcp, "<set-?>");
    this.Bvb = parambcp;
    AppMethodBeat.o(208877);
  }
  
  public final bcp ene()
  {
    return this.Bvb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.b
 * JD-Core Version:    0.7.0.1
 */