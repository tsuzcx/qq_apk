package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/ShareLiveAppMsgPiece;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "liveId", "", "getLiveId", "()Ljava/lang/String;", "setLiveId", "(Ljava/lang/String;)V", "liveName", "getLiveName", "setLiveName", "thumbUrl", "getThumbUrl", "setThumbUrl", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "toString", "Companion", "plugin-logic_release"})
public final class k
  extends f
{
  public static final a zaS;
  public String qud = "";
  public String thumbUrl = "";
  public String zaR = "";
  
  static
  {
    AppMethodBeat.i(202687);
    zaS = new a((byte)0);
    AppMethodBeat.o(202687);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(202685);
    if (paramb != null)
    {
      if (paramb.type == 60)
      {
        if (paramMap == null) {
          d.g.b.k.fvU();
        }
        paramb = bt.nullAsNil((String)paramMap.get(".msg.appmsg.mmlive.live_id"));
        d.g.b.k.g(paramb, "Util.nullAsNil(values!![….appmsg.mmlive.live_id\"])");
        this.zaR = paramb;
        paramb = bt.nullAsNil((String)paramMap.get(".msg.appmsg.title"));
        d.g.b.k.g(paramb, "Util.nullAsNil(values!![\".msg.appmsg.title\"])");
        this.qud = paramb;
        paramMap = bt.nullAsNil((String)paramMap.get(".msg.appmsg.thumburl"));
        d.g.b.k.g(paramMap, "Util.nullAsNil(values!![\".msg.appmsg.thumburl\"])");
        this.thumbUrl = paramMap;
        ad.i("MicroMsg.ShareLiveAppMsgPiece", toString());
      }
      AppMethodBeat.o(202685);
      return;
    }
    AppMethodBeat.o(202685);
  }
  
  public final f apu()
  {
    AppMethodBeat.i(202684);
    f localf = (f)new k();
    AppMethodBeat.o(202684);
    return localf;
  }
  
  public final void b(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202683);
    if (paramb != null)
    {
      if ((paramb.type == 60) && (paramStringBuilder != null))
      {
        paramStringBuilder.append("<mmlive>");
        paramStringBuilder.append("<live_id>");
        paramStringBuilder.append(k.b.ry(this.zaR));
        paramStringBuilder.append("</live_id>");
        paramStringBuilder.append("</mmlive>");
        AppMethodBeat.o(202683);
      }
    }
    else
    {
      AppMethodBeat.o(202683);
      return;
    }
    AppMethodBeat.o(202683);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(202686);
    String str = "ShareLiveAppMsgPiece(liveId='" + this.zaR + "', liveName='" + this.qud + "', thumbUrl='" + this.thumbUrl + "')";
    AppMethodBeat.o(202686);
    return str;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/ShareLiveAppMsgPiece$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.b.k
 * JD-Core Version:    0.7.0.1
 */