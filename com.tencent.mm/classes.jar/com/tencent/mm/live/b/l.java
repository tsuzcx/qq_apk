package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import java.util.Map;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/ShareLiveAppMsgPiece;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "liveId", "", "getLiveId", "()Ljava/lang/String;", "setLiveId", "(Ljava/lang/String;)V", "liveName", "getLiveName", "setLiveName", "thumbUrl", "getThumbUrl", "setThumbUrl", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "toString", "Companion", "plugin-logic_release"})
public final class l
  extends f
{
  public static final a gPo;
  public String gGA = "";
  public String gPn = "";
  public String thumbUrl = "";
  
  static
  {
    AppMethodBeat.i(212164);
    gPo = new a((byte)0);
    AppMethodBeat.o(212164);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(212160);
    if (paramb != null)
    {
      if ((paramb.type == 60) && (paramStringBuilder != null))
      {
        paramStringBuilder.append("<mmlive>");
        paramStringBuilder.append("<live_id>");
        paramStringBuilder.append(k.b.ys(this.gPn));
        paramStringBuilder.append("</live_id>");
        paramStringBuilder.append("</mmlive>");
        AppMethodBeat.o(212160);
      }
    }
    else
    {
      AppMethodBeat.o(212160);
      return;
    }
    AppMethodBeat.o(212160);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(212162);
    if (paramb != null)
    {
      if (paramb.type == 60)
      {
        if (paramMap == null) {
          p.gfZ();
        }
        paramb = bt.nullAsNil((String)paramMap.get(".msg.appmsg.mmlive.live_id"));
        p.g(paramb, "Util.nullAsNil(values!![….appmsg.mmlive.live_id\"])");
        this.gPn = paramb;
        paramb = bt.nullAsNil((String)paramMap.get(".msg.appmsg.title"));
        p.g(paramb, "Util.nullAsNil(values!![\".msg.appmsg.title\"])");
        this.gGA = paramb;
        paramMap = bt.nullAsNil((String)paramMap.get(".msg.appmsg.thumburl"));
        p.g(paramMap, "Util.nullAsNil(values!![\".msg.appmsg.thumburl\"])");
        this.thumbUrl = paramMap;
        ad.i("MicroMsg.ShareLiveAppMsgPiece", toString());
      }
      AppMethodBeat.o(212162);
      return;
    }
    AppMethodBeat.o(212162);
  }
  
  public final f aot()
  {
    AppMethodBeat.i(212161);
    f localf = (f)new l();
    AppMethodBeat.o(212161);
    return localf;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(212163);
    String str = "ShareLiveAppMsgPiece(liveId='" + this.gPn + "', liveName='" + this.gGA + "', thumbUrl='" + this.thumbUrl + "')";
    AppMethodBeat.o(212163);
    return str;
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/ShareLiveAppMsgPiece$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.l
 * JD-Core Version:    0.7.0.1
 */