package com.tencent.mm.plugin.findersdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.bje;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderObject;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "shareObject", "Lcom/tencent/mm/protocal/protobuf/FinderShareObject;", "getShareObject", "()Lcom/tencent/mm/protocal/protobuf/FinderShareObject;", "setShareObject", "(Lcom/tencent/mm/protocal/protobuf/FinderShareObject;)V", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"})
public final class f
  extends com.tencent.mm.aj.f
{
  public bje mbi;
  
  public f()
  {
    AppMethodBeat.i(168870);
    this.mbi = new bje();
    AppMethodBeat.o(168870);
  }
  
  public final void a(bje parambje)
  {
    AppMethodBeat.i(207900);
    p.k(parambje, "<set-?>");
    this.mbi = parambje;
    AppMethodBeat.o(207900);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168868);
    p.k(paramStringBuilder, "sb");
    paramStringBuilder.append(k.b(this.mbi));
    AppMethodBeat.o(168868);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(168869);
    p.k(paramMap, "values");
    p.k(paramb, "content");
    paramMap = k.w(".msg.appmsg", paramMap);
    p.j(paramMap, "FinderShareParser.parse(\".msg.appmsg\", values)");
    this.mbi = paramMap;
    AppMethodBeat.o(168869);
  }
  
  public final com.tencent.mm.aj.f aPj()
  {
    AppMethodBeat.i(168867);
    Object localObject = new f();
    ((f)localObject).mbi = this.mbi;
    localObject = (com.tencent.mm.aj.f)localObject;
    AppMethodBeat.o(168867);
    return localObject;
  }
  
  public final bje enh()
  {
    return this.mbi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.f
 * JD-Core Version:    0.7.0.1
 */