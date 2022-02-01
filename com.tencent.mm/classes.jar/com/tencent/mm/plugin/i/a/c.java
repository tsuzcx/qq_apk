package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.any;
import d.g.b.k;
import d.l;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderTopic;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "shareTopic", "Lcom/tencent/mm/protocal/protobuf/FinderShareTopic;", "getShareTopic", "()Lcom/tencent/mm/protocal/protobuf/FinderShareTopic;", "setShareTopic", "(Lcom/tencent/mm/protocal/protobuf/FinderShareTopic;)V", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"})
public final class c
  extends f
{
  public any hTJ;
  
  public c()
  {
    AppMethodBeat.i(168874);
    this.hTJ = new any();
    AppMethodBeat.o(168874);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168872);
    k.h(paramStringBuilder, "sb");
    paramStringBuilder.append(e.a(this.hTJ));
    AppMethodBeat.o(168872);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(168873);
    k.h(paramMap, "values");
    paramMap = e.u(".msg.appmsg", paramMap);
    k.g(paramMap, "FinderShareParser.parseF…ic(\".msg.appmsg\", values)");
    this.hTJ = paramMap;
    AppMethodBeat.o(168873);
  }
  
  public final f alG()
  {
    AppMethodBeat.i(168871);
    Object localObject = new c();
    ((c)localObject).hTJ = this.hTJ;
    localObject = (f)localObject;
    AppMethodBeat.o(168871);
    return localObject;
  }
  
  public final any cGL()
  {
    return this.hTJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.c
 * JD-Core Version:    0.7.0.1
 */