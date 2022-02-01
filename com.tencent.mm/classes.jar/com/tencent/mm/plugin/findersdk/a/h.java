package com.tencent.mm.plugin.findersdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.d;
import com.tencent.mm.message.f;
import com.tencent.mm.message.k.b;
import com.tencent.mm.protocal.protobuf.bth;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderProductObject;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "shareObject", "Lcom/tencent/mm/protocal/protobuf/FinderProductShareObject;", "getShareObject", "()Lcom/tencent/mm/protocal/protobuf/FinderProductShareObject;", "setShareObject", "(Lcom/tencent/mm/protocal/protobuf/FinderProductShareObject;)V", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends f
{
  public bth HbZ;
  
  public h()
  {
    AppMethodBeat.i(273985);
    this.HbZ = new bth();
    AppMethodBeat.o(273985);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(274011);
    s.u(paramStringBuilder, "sb");
    paramStringBuilder.append(q.c(this.HbZ));
    AppMethodBeat.o(274011);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(274016);
    s.u(paramMap, "values");
    s.u(paramb, "content");
    paramMap = q.A(".msg.appmsg", paramMap);
    s.s(paramMap, "parseProduct(\".msg.appmsg\", values)");
    this.HbZ = paramMap;
    AppMethodBeat.o(274016);
  }
  
  public final void b(bth parambth)
  {
    AppMethodBeat.i(273997);
    s.u(parambth, "<set-?>");
    this.HbZ = parambth;
    AppMethodBeat.o(273997);
  }
  
  public final f biW()
  {
    AppMethodBeat.i(274005);
    Object localObject = new h();
    ((h)localObject).HbZ = this.HbZ;
    localObject = (f)localObject;
    AppMethodBeat.o(274005);
    return localObject;
  }
  
  public final bth frv()
  {
    return this.HbZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.h
 * JD-Core Version:    0.7.0.1
 */