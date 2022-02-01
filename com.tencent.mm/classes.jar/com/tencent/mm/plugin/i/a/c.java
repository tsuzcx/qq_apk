package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.arz;
import d.g.b.p;
import d.l;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderTopic;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "shareTopic", "Lcom/tencent/mm/protocal/protobuf/FinderShareTopic;", "getShareTopic", "()Lcom/tencent/mm/protocal/protobuf/FinderShareTopic;", "setShareTopic", "(Lcom/tencent/mm/protocal/protobuf/FinderShareTopic;)V", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"})
public final class c
  extends f
{
  public arz ipX;
  
  public c()
  {
    AppMethodBeat.i(168874);
    this.ipX = new arz();
    AppMethodBeat.o(168874);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168872);
    p.h(paramStringBuilder, "sb");
    paramStringBuilder.append(e.a(this.ipX));
    AppMethodBeat.o(168872);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(168873);
    p.h(paramMap, "values");
    paramMap = e.x(".msg.appmsg", paramMap);
    p.g(paramMap, "FinderShareParser.parseF…ic(\".msg.appmsg\", values)");
    this.ipX = paramMap;
    AppMethodBeat.o(168873);
  }
  
  public final f aoI()
  {
    AppMethodBeat.i(168871);
    Object localObject = new c();
    ((c)localObject).ipX = this.ipX;
    localObject = (f)localObject;
    AppMethodBeat.o(168871);
    return localObject;
  }
  
  public final arz cRF()
  {
    return this.ipX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.c
 * JD-Core Version:    0.7.0.1
 */