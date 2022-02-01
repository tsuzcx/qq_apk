package com.tencent.mm.plugin.findersdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.bjf;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderPoi;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "sharePoi", "Lcom/tencent/mm/protocal/protobuf/FinderSharePoi;", "getSharePoi", "()Lcom/tencent/mm/protocal/protobuf/FinderSharePoi;", "setSharePoi", "(Lcom/tencent/mm/protocal/protobuf/FinderSharePoi;)V", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"})
public final class g
  extends f
{
  public bjf mbj;
  
  public g()
  {
    AppMethodBeat.i(207841);
    this.mbj = new bjf();
    AppMethodBeat.o(207841);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207838);
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
      if (k.d(paramString, paramInt1) == 2) {
        break label57;
      }
      AppMethodBeat.o(207838);
      return;
      paramString = null;
      break;
    }
    label57:
    paramStringBuilder.append(k.bf(2, k.a(this.mbj)));
    AppMethodBeat.o(207838);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(207840);
    p.k(paramMap, "values");
    paramMap = k.B(k.enk(), paramMap);
    p.j(paramMap, "FinderShareParser.parseF…getOuterPrifix(), values)");
    this.mbj = paramMap;
    AppMethodBeat.o(207840);
  }
  
  public final f aPj()
  {
    AppMethodBeat.i(207836);
    Object localObject = new g();
    ((g)localObject).mbj = this.mbj;
    localObject = (f)localObject;
    AppMethodBeat.o(207836);
    return localObject;
  }
  
  public final bjf eni()
  {
    return this.mbj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.g
 * JD-Core Version:    0.7.0.1
 */