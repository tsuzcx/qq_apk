package com.tencent.mm.plugin.findersdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.cwx;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentMegaVideo;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "shareObject", "Lcom/tencent/mm/protocal/protobuf/MegaVideoShareObject;", "getShareObject", "()Lcom/tencent/mm/protocal/protobuf/MegaVideoShareObject;", "setShareObject", "(Lcom/tencent/mm/protocal/protobuf/MegaVideoShareObject;)V", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"})
public final class i
  extends f
{
  public cwx mbk;
  
  public i()
  {
    AppMethodBeat.i(208941);
    this.mbk = new cwx();
    AppMethodBeat.o(208941);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208935);
    p.k(paramStringBuilder, "sb");
    paramStringBuilder.append(k.a(this.mbk));
    AppMethodBeat.o(208935);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(208939);
    paramMap = k.x(".msg.appmsg", paramMap);
    p.j(paramMap, "FinderShareParser.parseM…eo(\".msg.appmsg\", values)");
    this.mbk = paramMap;
    AppMethodBeat.o(208939);
  }
  
  public final f aPj()
  {
    AppMethodBeat.i(208937);
    Object localObject = new i();
    ((i)localObject).mbk = this.mbk;
    localObject = (f)localObject;
    AppMethodBeat.o(208937);
    return localObject;
  }
  
  public final cwx enj()
  {
    return this.mbk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.i
 * JD-Core Version:    0.7.0.1
 */