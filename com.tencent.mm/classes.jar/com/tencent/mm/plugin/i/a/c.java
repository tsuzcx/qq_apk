package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.ark;
import d.g.b.p;
import d.l;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderTopic;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "shareTopic", "Lcom/tencent/mm/protocal/protobuf/FinderShareTopic;", "getShareTopic", "()Lcom/tencent/mm/protocal/protobuf/FinderShareTopic;", "setShareTopic", "(Lcom/tencent/mm/protocal/protobuf/FinderShareTopic;)V", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"})
public final class c
  extends f
{
  public ark ind;
  
  public c()
  {
    AppMethodBeat.i(168874);
    this.ind = new ark();
    AppMethodBeat.o(168874);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168872);
    p.h(paramStringBuilder, "sb");
    paramStringBuilder.append(e.a(this.ind));
    AppMethodBeat.o(168872);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(168873);
    p.h(paramMap, "values");
    paramMap = e.w(".msg.appmsg", paramMap);
    p.g(paramMap, "FinderShareParser.parseF…ic(\".msg.appmsg\", values)");
    this.ind = paramMap;
    AppMethodBeat.o(168873);
  }
  
  public final f aot()
  {
    AppMethodBeat.i(168871);
    Object localObject = new c();
    ((c)localObject).ind = this.ind;
    localObject = (f)localObject;
    AppMethodBeat.o(168871);
    return localObject;
  }
  
  public final ark cPa()
  {
    return this.ind;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.c
 * JD-Core Version:    0.7.0.1
 */