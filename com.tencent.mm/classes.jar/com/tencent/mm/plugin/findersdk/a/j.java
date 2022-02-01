package com.tencent.mm.plugin.findersdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.d;
import com.tencent.mm.message.f;
import com.tencent.mm.message.k.b;
import com.tencent.mm.protocal.protobuf.doc;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentMegaVideo;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "shareObject", "Lcom/tencent/mm/protocal/protobuf/MegaVideoShareObject;", "getShareObject", "()Lcom/tencent/mm/protocal/protobuf/MegaVideoShareObject;", "setShareObject", "(Lcom/tencent/mm/protocal/protobuf/MegaVideoShareObject;)V", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends f
{
  public doc oUe;
  
  public j()
  {
    AppMethodBeat.i(273976);
    this.oUe = new doc();
    AppMethodBeat.o(273976);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(273987);
    s.u(paramStringBuilder, "sb");
    paramStringBuilder.append(q.b(this.oUe));
    AppMethodBeat.o(273987);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(273999);
    paramMap = q.E(".msg.appmsg", paramMap);
    s.s(paramMap, "parseMegaVideo(\".msg.appmsg\", values)");
    this.oUe = paramMap;
    AppMethodBeat.o(273999);
  }
  
  public final f biW()
  {
    AppMethodBeat.i(273993);
    Object localObject = new j();
    ((j)localObject).oUe = this.oUe;
    localObject = (f)localObject;
    AppMethodBeat.o(273993);
    return localObject;
  }
  
  public final doc frw()
  {
    return this.oUe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.j
 * JD-Core Version:    0.7.0.1
 */