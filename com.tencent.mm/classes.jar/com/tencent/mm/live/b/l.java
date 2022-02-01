package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import java.util.Map;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/ShareLiveAppMsgPiece;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "liveId", "", "getLiveId", "()Ljava/lang/String;", "setLiveId", "(Ljava/lang/String;)V", "liveName", "getLiveName", "setLiveName", "thumbUrl", "getThumbUrl", "setThumbUrl", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "toString", "Companion", "plugin-logic_release"})
public final class l
  extends f
{
  public static final a gvD;
  public String gmR = "";
  public String gvC = "";
  public String thumbUrl = "";
  
  static
  {
    AppMethodBeat.i(189878);
    gvD = new a((byte)0);
    AppMethodBeat.o(189878);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(189874);
    if (paramb != null)
    {
      if ((paramb.type == 60) && (paramStringBuilder != null))
      {
        paramStringBuilder.append("<mmlive>");
        paramStringBuilder.append("<live_id>");
        paramStringBuilder.append(k.b.vB(this.gvC));
        paramStringBuilder.append("</live_id>");
        paramStringBuilder.append("</mmlive>");
        AppMethodBeat.o(189874);
      }
    }
    else
    {
      AppMethodBeat.o(189874);
      return;
    }
    AppMethodBeat.o(189874);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(189876);
    if (paramb != null)
    {
      if (paramb.type == 60)
      {
        if (paramMap == null) {
          k.fOy();
        }
        paramb = bs.nullAsNil((String)paramMap.get(".msg.appmsg.mmlive.live_id"));
        k.g(paramb, "Util.nullAsNil(values!![….appmsg.mmlive.live_id\"])");
        this.gvC = paramb;
        paramb = bs.nullAsNil((String)paramMap.get(".msg.appmsg.title"));
        k.g(paramb, "Util.nullAsNil(values!![\".msg.appmsg.title\"])");
        this.gmR = paramb;
        paramMap = bs.nullAsNil((String)paramMap.get(".msg.appmsg.thumburl"));
        k.g(paramMap, "Util.nullAsNil(values!![\".msg.appmsg.thumburl\"])");
        this.thumbUrl = paramMap;
        ac.i("MicroMsg.ShareLiveAppMsgPiece", toString());
      }
      AppMethodBeat.o(189876);
      return;
    }
    AppMethodBeat.o(189876);
  }
  
  public final f alG()
  {
    AppMethodBeat.i(189875);
    f localf = (f)new l();
    AppMethodBeat.o(189875);
    return localf;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(189877);
    String str = "ShareLiveAppMsgPiece(liveId='" + this.gvC + "', liveName='" + this.gmR + "', thumbUrl='" + this.thumbUrl + "')";
    AppMethodBeat.o(189877);
    return str;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/ShareLiveAppMsgPiece$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.l
 * JD-Core Version:    0.7.0.1
 */