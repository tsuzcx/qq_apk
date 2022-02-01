package com.tencent.mm.plugin.findersdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.bcp;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/api/AppMSgContentFinderLiveInviteObject;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "shareObject", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "getShareObject", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "setShareObject", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;)V", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"})
public final class a
  extends f
{
  public bcp Bvb;
  
  public a()
  {
    AppMethodBeat.i(209828);
    this.Bvb = new bcp();
    AppMethodBeat.o(209828);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209826);
    p.k(paramStringBuilder, "sb");
    paramStringBuilder.append(k.d(this.Bvb));
    AppMethodBeat.o(209826);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(209827);
    p.k(paramMap, "values");
    p.k(paramb, "content");
    paramMap = k.v(".msg.appmsg", paramMap);
    p.j(paramMap, "FinderShareParser.parseF…ve(\".msg.appmsg\", values)");
    this.Bvb = paramMap;
    AppMethodBeat.o(209827);
  }
  
  public final f aPj()
  {
    AppMethodBeat.i(209825);
    Object localObject = new a();
    ((a)localObject).Bvb = this.Bvb;
    localObject = (f)localObject;
    AppMethodBeat.o(209825);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.a
 * JD-Core Version:    0.7.0.1
 */