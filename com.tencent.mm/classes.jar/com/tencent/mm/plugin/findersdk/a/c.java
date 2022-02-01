package com.tencent.mm.plugin.findersdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.f;
import com.tencent.mm.message.k.b;
import com.tencent.mm.protocal.protobuf.bvn;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderActivity;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "shareTopic", "Lcom/tencent/mm/protocal/protobuf/FinderShareTopic;", "getShareTopic", "()Lcom/tencent/mm/protocal/protobuf/FinderShareTopic;", "setShareTopic", "(Lcom/tencent/mm/protocal/protobuf/FinderShareTopic;)V", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends f
{
  public bvn oTZ;
  
  public c()
  {
    AppMethodBeat.i(273933);
    this.oTZ = new bvn();
    AppMethodBeat.o(273933);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(273954);
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
      if (q.f(paramString, paramInt1) == 3) {
        break label57;
      }
      AppMethodBeat.o(273954);
      return;
      paramString = paramb.nUd;
      break;
    }
    label57:
    paramStringBuilder.append(q.bJ(((cn)h.az(cn.class)).getFinderSwitchApi().ffJ(), q.a(this.oTZ)));
    AppMethodBeat.o(273954);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(273961);
    s.u(paramMap, "values");
    paramMap = q.F(".msg.appmsg.finder.detail", paramMap);
    s.s(paramMap, "parseFinderTopic(FinderS…getOuterPrifix(), values)");
    this.oTZ = paramMap;
    AppMethodBeat.o(273961);
  }
  
  public final f biW()
  {
    AppMethodBeat.i(273944);
    Object localObject = new c();
    ((c)localObject).oTZ = this.oTZ;
    localObject = (f)localObject;
    AppMethodBeat.o(273944);
    return localObject;
  }
  
  public final bvn frr()
  {
    return this.oTZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.c
 * JD-Core Version:    0.7.0.1
 */