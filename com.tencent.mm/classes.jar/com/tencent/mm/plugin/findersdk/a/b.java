package com.tencent.mm.plugin.findersdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.d;
import com.tencent.mm.message.f;
import com.tencent.mm.message.k.b;
import com.tencent.mm.protocal.protobuf.bmr;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/api/AppMSgContentFinderLiveObject;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "shareObject", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "getShareObject", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "setShareObject", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;)V", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends f
{
  public bmr HbV;
  
  public b()
  {
    AppMethodBeat.i(273930);
    this.HbV = new bmr();
    AppMethodBeat.o(273930);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(273953);
    s.u(paramStringBuilder, "sb");
    paramStringBuilder.append(q.c(this.HbV));
    AppMethodBeat.o(273953);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(273960);
    s.u(paramMap, "values");
    s.u(paramb, "content");
    paramMap = q.z(".msg.appmsg", paramMap);
    s.s(paramMap, "parseFinderLive(\".msg.appmsg\", values)");
    this.HbV = paramMap;
    AppMethodBeat.o(273960);
  }
  
  public final void b(bmr parambmr)
  {
    AppMethodBeat.i(273941);
    s.u(parambmr, "<set-?>");
    this.HbV = parambmr;
    AppMethodBeat.o(273941);
  }
  
  public final f biW()
  {
    AppMethodBeat.i(273948);
    Object localObject = new b();
    ((b)localObject).HbV = this.HbV;
    localObject = (f)localObject;
    AppMethodBeat.o(273948);
    return localObject;
  }
  
  public final bmr frq()
  {
    return this.HbV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.b
 * JD-Core Version:    0.7.0.1
 */