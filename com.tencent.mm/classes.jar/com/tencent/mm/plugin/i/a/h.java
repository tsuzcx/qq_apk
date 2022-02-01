package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.bcl;
import java.util.Map;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderTopic;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "shareTopic", "Lcom/tencent/mm/protocal/protobuf/FinderShareTopic;", "getShareTopic", "()Lcom/tencent/mm/protocal/protobuf/FinderShareTopic;", "setShareTopic", "(Lcom/tencent/mm/protocal/protobuf/FinderShareTopic;)V", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"})
public final class h
  extends f
{
  public bcl jld;
  
  public h()
  {
    AppMethodBeat.i(168874);
    this.jld = new bcl();
    AppMethodBeat.o(168874);
  }
  
  public final void a(bcl parambcl)
  {
    AppMethodBeat.i(208783);
    p.h(parambcl, "<set-?>");
    this.jld = parambcl;
    AppMethodBeat.o(208783);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168872);
    p.h(paramStringBuilder, "sb");
    paramStringBuilder.append(l.b(this.jld));
    AppMethodBeat.o(168872);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(168873);
    p.h(paramMap, "values");
    paramMap = l.z(".msg.appmsg", paramMap);
    p.g(paramMap, "FinderShareParser.parseF…ic(\".msg.appmsg\", values)");
    this.jld = paramMap;
    AppMethodBeat.o(168873);
  }
  
  public final f aHj()
  {
    AppMethodBeat.i(168871);
    Object localObject = new h();
    ((h)localObject).jld = this.jld;
    localObject = (f)localObject;
    AppMethodBeat.o(168871);
    return localObject;
  }
  
  public final bcl dJv()
  {
    return this.jld;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.h
 * JD-Core Version:    0.7.0.1
 */