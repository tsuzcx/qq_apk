package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bcl;
import java.util.Map;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderActivity;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "shareTopic", "Lcom/tencent/mm/protocal/protobuf/FinderShareTopic;", "getShareTopic", "()Lcom/tencent/mm/protocal/protobuf/FinderShareTopic;", "setShareTopic", "(Lcom/tencent/mm/protocal/protobuf/FinderShareTopic;)V", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"})
public final class c
  extends f
{
  public bcl jld;
  
  public c()
  {
    AppMethodBeat.i(208767);
    this.jld = new bcl();
    AppMethodBeat.o(208767);
  }
  
  public final void a(bcl parambcl)
  {
    AppMethodBeat.i(208763);
    p.h(parambcl, "<set-?>");
    this.jld = parambcl;
    AppMethodBeat.o(208763);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208765);
    p.h(paramStringBuilder, "sb");
    if (paramb != null)
    {
      paramString = paramb.aSu();
      if (paramb == null) {
        break label51;
      }
    }
    label51:
    for (paramInt1 = paramb.izD;; paramInt1 = 0)
    {
      if (l.d(paramString, paramInt1) == 1) {
        break label57;
      }
      AppMethodBeat.o(208765);
      return;
      paramString = null;
      break;
    }
    label57:
    paramb = g.ah(aj.class);
    p.g(paramb, "MMKernel.plugin(IPluginFinder::class.java)");
    paramb = ((aj)paramb).getFinderSwitchApi();
    p.g(paramb, "MMKernel.plugin(IPluginF…ass.java).finderSwitchApi");
    paramStringBuilder.append(l.bf(paramb.dCw(), l.b(this.jld)));
    AppMethodBeat.o(208765);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(208766);
    p.h(paramMap, "values");
    paramMap = l.z(l.dJA(), paramMap);
    p.g(paramMap, "FinderShareParser.parseF…getOuterPrifix(), values)");
    this.jld = paramMap;
    AppMethodBeat.o(208766);
  }
  
  public final f aHj()
  {
    AppMethodBeat.i(208764);
    Object localObject = new c();
    ((c)localObject).jld = this.jld;
    localObject = (f)localObject;
    AppMethodBeat.o(208764);
    return localObject;
  }
  
  public final bcl dJv()
  {
    return this.jld;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.c
 * JD-Core Version:    0.7.0.1
 */