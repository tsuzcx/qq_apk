package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.anx;
import d.g.b.k;
import d.l;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderObject;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "shareObject", "Lcom/tencent/mm/protocal/protobuf/FinderShareObject;", "getShareObject", "()Lcom/tencent/mm/protocal/protobuf/FinderShareObject;", "setShareObject", "(Lcom/tencent/mm/protocal/protobuf/FinderShareObject;)V", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"})
public final class b
  extends f
{
  public anx hTI;
  
  public b()
  {
    AppMethodBeat.i(168870);
    this.hTI = new anx();
    AppMethodBeat.o(168870);
  }
  
  public final void a(anx paramanx)
  {
    AppMethodBeat.i(194869);
    k.h(paramanx, "<set-?>");
    this.hTI = paramanx;
    AppMethodBeat.o(194869);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168868);
    k.h(paramStringBuilder, "sb");
    paramStringBuilder.append(e.b(this.hTI));
    AppMethodBeat.o(168868);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(168869);
    k.h(paramMap, "values");
    k.h(paramb, "content");
    paramMap = e.t(".msg.appmsg", paramMap);
    k.g(paramMap, "FinderShareParser.parse(\".msg.appmsg\", values)");
    this.hTI = paramMap;
    AppMethodBeat.o(168869);
  }
  
  public final f alG()
  {
    AppMethodBeat.i(168867);
    Object localObject = new b();
    ((b)localObject).hTI = this.hTI;
    localObject = (f)localObject;
    AppMethodBeat.o(168867);
    return localObject;
  }
  
  public final anx cGK()
  {
    return this.hTI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.b
 * JD-Core Version:    0.7.0.1
 */