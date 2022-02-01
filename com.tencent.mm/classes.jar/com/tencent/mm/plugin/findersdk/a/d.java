package com.tencent.mm.plugin.findersdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.f;
import com.tencent.mm.message.k.b;
import com.tencent.mm.protocal.protobuf.bvh;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderAlbum;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "shareAlbum", "Lcom/tencent/mm/protocal/protobuf/FinderShareAlbum;", "getShareAlbum", "()Lcom/tencent/mm/protocal/protobuf/FinderShareAlbum;", "setShareAlbum", "(Lcom/tencent/mm/protocal/protobuf/FinderShareAlbum;)V", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends f
{
  public bvh oUa;
  
  public d()
  {
    AppMethodBeat.i(273937);
    this.oUa = new bvh();
    AppMethodBeat.o(273937);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, com.tencent.mm.g.d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(273956);
    s.u(paramStringBuilder, "sb");
    paramStringBuilder.append(q.a(this.oUa));
    AppMethodBeat.o(273956);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(273963);
    s.u(paramMap, "values");
    paramMap = q.H(".msg.appmsg", paramMap);
    s.s(paramMap, "parseFinderAlbum(\".msg.appmsg\", values)");
    this.oUa = paramMap;
    AppMethodBeat.o(273963);
  }
  
  public final f biW()
  {
    AppMethodBeat.i(273950);
    Object localObject = new d();
    ((d)localObject).oUa = this.oUa;
    localObject = (f)localObject;
    AppMethodBeat.o(273950);
    return localObject;
  }
  
  public final bvh frs()
  {
    return this.oUa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.d
 * JD-Core Version:    0.7.0.1
 */