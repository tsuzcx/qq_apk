package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import java.util.Map;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/ShareLiveAppMsgPiece;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "liveId", "", "getLiveId", "()Ljava/lang/String;", "setLiveId", "(Ljava/lang/String;)V", "liveName", "getLiveName", "setLiveName", "thumbUrl", "getThumbUrl", "setThumbUrl", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "toString", "Companion", "plugin-logic_release"})
public final class l
  extends f
{
  public static final l.a gRW;
  public String gJj = "";
  public String gRV = "";
  public String thumbUrl = "";
  
  static
  {
    AppMethodBeat.i(215784);
    gRW = new l.a((byte)0);
    AppMethodBeat.o(215784);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(215780);
    if (paramb != null)
    {
      if ((paramb.type == 60) && (paramStringBuilder != null))
      {
        paramStringBuilder.append("<mmlive>");
        paramStringBuilder.append("<live_id>");
        paramStringBuilder.append(k.b.zc(this.gRV));
        paramStringBuilder.append("</live_id>");
        paramStringBuilder.append("</mmlive>");
        AppMethodBeat.o(215780);
      }
    }
    else
    {
      AppMethodBeat.o(215780);
      return;
    }
    AppMethodBeat.o(215780);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(215782);
    if (paramb != null)
    {
      if (paramb.type == 60)
      {
        if (paramMap == null) {
          p.gkB();
        }
        paramb = bu.nullAsNil((String)paramMap.get(".msg.appmsg.mmlive.live_id"));
        p.g(paramb, "Util.nullAsNil(values!![….appmsg.mmlive.live_id\"])");
        this.gRV = paramb;
        paramb = bu.nullAsNil((String)paramMap.get(".msg.appmsg.title"));
        p.g(paramb, "Util.nullAsNil(values!![\".msg.appmsg.title\"])");
        this.gJj = paramb;
        paramMap = bu.nullAsNil((String)paramMap.get(".msg.appmsg.thumburl"));
        p.g(paramMap, "Util.nullAsNil(values!![\".msg.appmsg.thumburl\"])");
        this.thumbUrl = paramMap;
        ae.i("MicroMsg.ShareLiveAppMsgPiece", toString());
      }
      AppMethodBeat.o(215782);
      return;
    }
    AppMethodBeat.o(215782);
  }
  
  public final f aoI()
  {
    AppMethodBeat.i(215781);
    f localf = (f)new l();
    AppMethodBeat.o(215781);
    return localf;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(215783);
    String str = "ShareLiveAppMsgPiece(liveId='" + this.gRV + "', liveName='" + this.gJj + "', thumbUrl='" + this.thumbUrl + "')";
    AppMethodBeat.o(215783);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.l
 * JD-Core Version:    0.7.0.1
 */