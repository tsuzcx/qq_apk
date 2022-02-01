package com.tencent.mm.plugin.findersdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.d;
import com.tencent.mm.message.f;
import com.tencent.mm.message.k.b;
import com.tencent.mm.protocal.protobuf.bvm;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderPoi;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "sharePoi", "Lcom/tencent/mm/protocal/protobuf/FinderSharePoi;", "getSharePoi", "()Lcom/tencent/mm/protocal/protobuf/FinderSharePoi;", "setSharePoi", "(Lcom/tencent/mm/protocal/protobuf/FinderSharePoi;)V", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends f
{
  public bvm oUd;
  
  public g()
  {
    AppMethodBeat.i(273978);
    this.oUd = new bvm();
    AppMethodBeat.o(273978);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(273995);
    s.u(paramStringBuilder, "sb");
    if (paramb == null)
    {
      paramString = null;
      if (paramb != null) {
        break label48;
      }
    }
    label48:
    for (paramInt1 = 0;; paramInt1 = paramb.nUa)
    {
      if (q.f(paramString, paramInt1) == 2) {
        break label57;
      }
      AppMethodBeat.o(273995);
      return;
      paramString = paramb.nUd;
      break;
    }
    label57:
    paramStringBuilder.append(q.bJ(2, q.a(this.oUd)));
    AppMethodBeat.o(273995);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(274001);
    s.u(paramMap, "values");
    paramMap = q.I(".msg.appmsg.finder.detail", paramMap);
    s.s(paramMap, "parseFinderPoi(FinderSha…getOuterPrifix(), values)");
    this.oUd = paramMap;
    AppMethodBeat.o(274001);
  }
  
  public final f biW()
  {
    AppMethodBeat.i(273989);
    Object localObject = new g();
    ((g)localObject).oUd = this.oUd;
    localObject = (f)localObject;
    AppMethodBeat.o(273989);
    return localObject;
  }
  
  public final bvm fru()
  {
    return this.oUd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.g
 * JD-Core Version:    0.7.0.1
 */