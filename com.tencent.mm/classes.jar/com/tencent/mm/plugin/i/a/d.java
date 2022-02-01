package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.protocal.protobuf.bcf;
import java.util.Map;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderAlbum;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "shareAlbum", "Lcom/tencent/mm/protocal/protobuf/FinderShareAlbum;", "getShareAlbum", "()Lcom/tencent/mm/protocal/protobuf/FinderShareAlbum;", "setShareAlbum", "(Lcom/tencent/mm/protocal/protobuf/FinderShareAlbum;)V", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"})
public final class d
  extends f
{
  public bcf jle;
  
  public d()
  {
    AppMethodBeat.i(208771);
    this.jle = new bcf();
    AppMethodBeat.o(208771);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, com.tencent.mm.i.d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208769);
    p.h(paramStringBuilder, "sb");
    paramStringBuilder.append(l.a(this.jle));
    AppMethodBeat.o(208769);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(208770);
    p.h(paramMap, "values");
    paramMap = l.A(".msg.appmsg", paramMap);
    p.g(paramMap, "FinderShareParser.parseF…um(\".msg.appmsg\", values)");
    this.jle = paramMap;
    AppMethodBeat.o(208770);
  }
  
  public final f aHj()
  {
    AppMethodBeat.i(208768);
    Object localObject = new d();
    ((d)localObject).jle = this.jle;
    localObject = (f)localObject;
    AppMethodBeat.o(208768);
    return localObject;
  }
  
  public final bcf dJw()
  {
    return this.jle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.d
 * JD-Core Version:    0.7.0.1
 */