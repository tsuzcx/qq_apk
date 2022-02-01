package com.tencent.mm.message.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.d;
import com.tencent.mm.message.f;
import com.tencent.mm.message.k.b;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/message/piece/AppMsgContentFilePiece;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "fileuploadtoken", "", "getFileuploadtoken", "()Ljava/lang/String;", "setFileuploadtoken", "(Ljava/lang/String;)V", "overwriteNewMsgId", "", "getOverwriteNewMsgId", "()J", "setOverwriteNewMsgId", "(J)V", "cloneContent", "get", "values", "", "key", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "", "reset", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends f
{
  public static final b.a nVC;
  public long nVD;
  public String nVE = "";
  
  static
  {
    AppMethodBeat.i(233946);
    nVC = new b.a((byte)0);
    AppMethodBeat.o(233946);
  }
  
  public final void Hm(String paramString)
  {
    AppMethodBeat.i(233949);
    s.u(paramString, "<set-?>");
    this.nVE = paramString;
    AppMethodBeat.o(233949);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2) {}
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(233958);
    s.u(paramMap, "values");
    s.u(paramb, "content");
    if (paramb.type == 6)
    {
      this.nVD = Util.getLong((String)paramMap.get(".msg.appmsg.appattach.overwrite_newmsgid"), 0L);
      paramMap = Util.nullAsNil((String)paramMap.get(s.X(".msg.appmsg.appattach.", "fileuploadtoken")));
      s.s(paramMap, "nullAsNil(values[\".msg.appmsg.appattach.$key\"])");
      this.nVE = paramMap;
    }
    AppMethodBeat.o(233958);
  }
  
  public final f biW()
  {
    AppMethodBeat.i(233951);
    Object localObject = new b();
    ((b)localObject).nVD = this.nVD;
    ((b)localObject).nVE = this.nVE;
    localObject = (f)localObject;
    AppMethodBeat.o(233951);
    return localObject;
  }
  
  public final void reset()
  {
    this.nVD = 0L;
    this.nVE = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.message.a.b
 * JD-Core Version:    0.7.0.1
 */