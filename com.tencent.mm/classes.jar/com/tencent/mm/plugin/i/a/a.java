package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.axf;
import java.util.Map;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/findersdk/api/AppMSgContentFinderLiveInviteObject;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "shareObject", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "getShareObject", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "setShareObject", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;)V", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"})
public final class a
  extends f
{
  public axf wDV;
  
  public a()
  {
    AppMethodBeat.i(208757);
    this.wDV = new axf();
    AppMethodBeat.o(208757);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208755);
    p.h(paramStringBuilder, "sb");
    paramStringBuilder.append(l.d(this.wDV));
    AppMethodBeat.o(208755);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(208756);
    p.h(paramMap, "values");
    p.h(paramb, "content");
    paramMap = l.w(".msg.appmsg", paramMap);
    p.g(paramMap, "FinderShareParser.parseF…ve(\".msg.appmsg\", values)");
    this.wDV = paramMap;
    AppMethodBeat.o(208756);
  }
  
  public final f aHj()
  {
    AppMethodBeat.i(208754);
    Object localObject = new a();
    ((a)localObject).wDV = this.wDV;
    localObject = (f)localObject;
    AppMethodBeat.o(208754);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.a
 * JD-Core Version:    0.7.0.1
 */