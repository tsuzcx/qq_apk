package com.tencent.mm.aj.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/message/piece/AppMsgContentFilePiece;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "fileuploadtoken", "", "getFileuploadtoken", "()Ljava/lang/String;", "setFileuploadtoken", "(Ljava/lang/String;)V", "overwriteNewMsgId", "", "getOverwriteNewMsgId", "()J", "setOverwriteNewMsgId", "(J)V", "cloneContent", "get", "values", "", "key", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "", "reset", "Companion", "plugin-comm_release"})
public final class b
  extends f
{
  public static final a lqD;
  public long lqB;
  public String lqC = "";
  
  static
  {
    AppMethodBeat.i(243560);
    lqD = new a((byte)0);
    AppMethodBeat.o(243560);
  }
  
  public final void OX(String paramString)
  {
    AppMethodBeat.i(243552);
    p.k(paramString, "<set-?>");
    this.lqC = paramString;
    AppMethodBeat.o(243552);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2) {}
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(243558);
    p.k(paramMap, "values");
    p.k(paramb, "content");
    if (paramb.type == 6)
    {
      this.lqB = Util.getLong((String)paramMap.get(".msg.appmsg.appattach.overwrite_newmsgid"), 0L);
      paramMap = Util.nullAsNil((String)paramMap.get(".msg.appmsg.appattach.".concat(String.valueOf("fileuploadtoken"))));
      p.j(paramMap, "Util.nullAsNil(values[\".….appmsg.appattach.$key\"])");
      this.lqC = paramMap;
    }
    AppMethodBeat.o(243558);
  }
  
  public final f aPj()
  {
    AppMethodBeat.i(243554);
    Object localObject = new b();
    ((b)localObject).lqB = this.lqB;
    ((b)localObject).lqC = this.lqC;
    localObject = (f)localObject;
    AppMethodBeat.o(243554);
    return localObject;
  }
  
  public final void reset()
  {
    this.lqB = 0L;
    this.lqC = "";
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/message/piece/AppMsgContentFilePiece$Companion;", "", "()V", "TAG", "", "plugin-comm_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.a.b
 * JD-Core Version:    0.7.0.1
 */