package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.bck;
import java.util.Map;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderPoi;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "sharePoi", "Lcom/tencent/mm/protocal/protobuf/FinderSharePoi;", "getSharePoi", "()Lcom/tencent/mm/protocal/protobuf/FinderSharePoi;", "setSharePoi", "(Lcom/tencent/mm/protocal/protobuf/FinderSharePoi;)V", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"})
public final class g
  extends f
{
  public bck wDZ;
  
  public g()
  {
    AppMethodBeat.i(208782);
    this.wDZ = new bck();
    AppMethodBeat.o(208782);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208780);
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
      if (l.d(paramString, paramInt1) == 2) {
        break label57;
      }
      AppMethodBeat.o(208780);
      return;
      paramString = null;
      break;
    }
    label57:
    paramStringBuilder.append(l.bf(2, l.a(this.wDZ)));
    AppMethodBeat.o(208780);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(208781);
    p.h(paramMap, "values");
    paramMap = l.B(l.dJA(), paramMap);
    p.g(paramMap, "FinderShareParser.parseF…getOuterPrifix(), values)");
    this.wDZ = paramMap;
    AppMethodBeat.o(208781);
  }
  
  public final f aHj()
  {
    AppMethodBeat.i(208779);
    Object localObject = new g();
    ((g)localObject).wDZ = this.wDZ;
    localObject = (f)localObject;
    AppMethodBeat.o(208779);
    return localObject;
  }
  
  public final bck dJy()
  {
    return this.wDZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.g
 * JD-Core Version:    0.7.0.1
 */