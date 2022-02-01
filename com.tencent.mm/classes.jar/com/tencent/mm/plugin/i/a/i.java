package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.col;
import java.util.Map;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentMegaVideo;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "shareObject", "Lcom/tencent/mm/protocal/protobuf/MegaVideoShareObject;", "getShareObject", "()Lcom/tencent/mm/protocal/protobuf/MegaVideoShareObject;", "setShareObject", "(Lcom/tencent/mm/protocal/protobuf/MegaVideoShareObject;)V", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"})
public final class i
  extends f
{
  public col jlh;
  
  public i()
  {
    AppMethodBeat.i(208787);
    this.jlh = new col();
    AppMethodBeat.o(208787);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208784);
    p.h(paramStringBuilder, "sb");
    paramStringBuilder.append(l.a(this.jlh));
    AppMethodBeat.o(208784);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(208786);
    paramMap = l.y(".msg.appmsg", paramMap);
    p.g(paramMap, "FinderShareParser.parseM…eo(\".msg.appmsg\", values)");
    this.jlh = paramMap;
    AppMethodBeat.o(208786);
  }
  
  public final f aHj()
  {
    AppMethodBeat.i(208785);
    Object localObject = new i();
    ((i)localObject).jlh = this.jlh;
    localObject = (f)localObject;
    AppMethodBeat.o(208785);
    return localObject;
  }
  
  public final col dJz()
  {
    return this.jlh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.i
 * JD-Core Version:    0.7.0.1
 */