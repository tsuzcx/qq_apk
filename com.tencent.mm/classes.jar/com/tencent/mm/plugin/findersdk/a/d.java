package com.tencent.mm.plugin.findersdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.protocal.protobuf.bja;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderAlbum;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "shareAlbum", "Lcom/tencent/mm/protocal/protobuf/FinderShareAlbum;", "getShareAlbum", "()Lcom/tencent/mm/protocal/protobuf/FinderShareAlbum;", "setShareAlbum", "(Lcom/tencent/mm/protocal/protobuf/FinderShareAlbum;)V", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"})
public final class d
  extends f
{
  public bja mbg;
  
  public d()
  {
    AppMethodBeat.i(208856);
    this.mbg = new bja();
    AppMethodBeat.o(208856);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, com.tencent.mm.i.d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208854);
    p.k(paramStringBuilder, "sb");
    paramStringBuilder.append(k.a(this.mbg));
    AppMethodBeat.o(208854);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(208855);
    p.k(paramMap, "values");
    paramMap = k.A(".msg.appmsg", paramMap);
    p.j(paramMap, "FinderShareParser.parseF…um(\".msg.appmsg\", values)");
    this.mbg = paramMap;
    AppMethodBeat.o(208855);
  }
  
  public final f aPj()
  {
    AppMethodBeat.i(208852);
    Object localObject = new d();
    ((d)localObject).mbg = this.mbg;
    localObject = (f)localObject;
    AppMethodBeat.o(208852);
    return localObject;
  }
  
  public final bja eng()
  {
    return this.mbg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.d
 * JD-Core Version:    0.7.0.1
 */