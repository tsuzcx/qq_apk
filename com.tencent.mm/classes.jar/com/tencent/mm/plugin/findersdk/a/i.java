package com.tencent.mm.plugin.findersdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.d;
import com.tencent.mm.message.f;
import com.tencent.mm.message.k.b;
import com.tencent.mm.protocal.protobuf.bvn;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderTopic;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "shareTopic", "Lcom/tencent/mm/protocal/protobuf/FinderShareTopic;", "getShareTopic", "()Lcom/tencent/mm/protocal/protobuf/FinderShareTopic;", "setShareTopic", "(Lcom/tencent/mm/protocal/protobuf/FinderShareTopic;)V", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends f
{
  public bvn oTZ;
  
  public i()
  {
    AppMethodBeat.i(168874);
    this.oTZ = new bvn();
    AppMethodBeat.o(168874);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168872);
    s.u(paramStringBuilder, "sb");
    paramStringBuilder.append(q.a(this.oTZ));
    AppMethodBeat.o(168872);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(168873);
    s.u(paramMap, "values");
    paramMap = q.F(".msg.appmsg", paramMap);
    s.s(paramMap, "parseFinderTopic(\".msg.appmsg\", values)");
    this.oTZ = paramMap;
    AppMethodBeat.o(168873);
  }
  
  public final f biW()
  {
    AppMethodBeat.i(168871);
    Object localObject = new i();
    ((i)localObject).oTZ = this.oTZ;
    localObject = (f)localObject;
    AppMethodBeat.o(168871);
    return localObject;
  }
  
  public final bvn frr()
  {
    return this.oTZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.i
 * JD-Core Version:    0.7.0.1
 */