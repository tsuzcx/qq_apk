package com.tencent.mm.plugin.findersdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.bjg;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderActivity;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "shareTopic", "Lcom/tencent/mm/protocal/protobuf/FinderShareTopic;", "getShareTopic", "()Lcom/tencent/mm/protocal/protobuf/FinderShareTopic;", "setShareTopic", "(Lcom/tencent/mm/protocal/protobuf/FinderShareTopic;)V", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"})
public final class c
  extends f
{
  public bjg mbf;
  
  public c()
  {
    AppMethodBeat.i(210382);
    this.mbf = new bjg();
    AppMethodBeat.o(210382);
  }
  
  public final void a(bjg parambjg)
  {
    AppMethodBeat.i(210376);
    p.k(parambjg, "<set-?>");
    this.mbf = parambjg;
    AppMethodBeat.o(210376);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210379);
    p.k(paramStringBuilder, "sb");
    if (paramb != null)
    {
      paramString = paramb.bbr();
      if (paramb == null) {
        break label51;
      }
    }
    label51:
    for (paramInt1 = paramb.loX;; paramInt1 = 0)
    {
      if (k.d(paramString, paramInt1) == 3) {
        break label57;
      }
      AppMethodBeat.o(210379);
      return;
      paramString = null;
      break;
    }
    label57:
    paramb = h.ag(ak.class);
    p.j(paramb, "MMKernel.plugin(IPluginFinder::class.java)");
    paramb = ((ak)paramb).getFinderSwitchApi();
    p.j(paramb, "MMKernel.plugin(IPluginF…ass.java).finderSwitchApi");
    paramStringBuilder.append(k.bf(paramb.edS(), k.b(this.mbf)));
    AppMethodBeat.o(210379);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(210381);
    p.k(paramMap, "values");
    paramMap = k.y(k.enk(), paramMap);
    p.j(paramMap, "FinderShareParser.parseF…getOuterPrifix(), values)");
    this.mbf = paramMap;
    AppMethodBeat.o(210381);
  }
  
  public final f aPj()
  {
    AppMethodBeat.i(210377);
    Object localObject = new c();
    ((c)localObject).mbf = this.mbf;
    localObject = (f)localObject;
    AppMethodBeat.o(210377);
    return localObject;
  }
  
  public final bjg enf()
  {
    return this.mbf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.c
 * JD-Core Version:    0.7.0.1
 */