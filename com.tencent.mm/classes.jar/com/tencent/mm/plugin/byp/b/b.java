package com.tencent.mm.plugin.byp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.protocal.protobuf.sm;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/byp/cgi/CgiBypSendEmoij;", "Lcom/tencent/mm/plugin/byp/cgi/CgiBypSend;", "bizType", "", "session_id", "", "from_username", "to_username", "emoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "msgId", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/storage/emotion/EmojiInfo;J)V", "onSendFailed", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/protocal/protobuf/BypSendResponse;", "onSendSuccessfully", "Companion", "plugin-byp_release"})
public final class b
  extends a
{
  private static final boolean cWq;
  public static final b.a pPA;
  private final EmojiInfo dEz;
  private final int fuQ = 3;
  private final long msgId;
  private final String pPy;
  private final String pPz;
  private final String session_id;
  
  static
  {
    boolean bool = false;
    AppMethodBeat.i(199110);
    pPA = new b.a((byte)0);
    if (BuildInfo.DEBUG) {
      bool = true;
    }
    cWq = bool;
    AppMethodBeat.o(199110);
  }
  
  public b(String paramString1, String paramString2, String paramString3, EmojiInfo paramEmojiInfo, long paramLong)
  {
    super(3, localsm);
    this.session_id = paramString1;
    this.pPy = paramString2;
    this.pPz = paramString3;
    this.dEz = paramEmojiInfo;
    this.msgId = paramLong;
    paramString1 = this.pPv.LaA;
    paramString1.md5 = this.dEz.getMd5();
    paramString1.type = this.dEz.getType();
    paramString1.len = this.dEz.getSize();
    paramString1.KZW = this.dEz.getContent();
    paramString1.KZY = 0;
    paramString1 = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(paramString1, "MMKernel.service(IMessengerStorage::class.java)");
    paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramString1).eiy().Hb(this.msgId);
    paramString1.setContent(this.pPy + paramString1.getContent());
    paramString2 = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(paramString2, "MMKernel.service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)paramString2).eiy().a(this.msgId, paramString1);
    AppMethodBeat.o(199109);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, sr paramsr)
  {
    AppMethodBeat.i(199108);
    p.h(paramsr, "resp");
    Log.e("Byp.CgiBypSendEmoij", "[onSendFailed] bizType=" + this.fuQ + " sessionId=" + this.session_id + " toUsername=" + this.pPz + " fromUsername=" + this.pPy + " errCode:" + paramInt2 + " errMsg:" + paramString);
    AppMethodBeat.o(199108);
  }
  
  public final void a(sr paramsr)
  {
    AppMethodBeat.i(199107);
    p.h(paramsr, "resp");
    Log.i("Byp.CgiBypSendEmoij", "[onSendSuccessfully] bizType=" + this.fuQ + " msgSvrId=" + paramsr.LaI + "  sessionId=" + this.session_id + " toUsername=" + this.pPz + " fromUsername=" + this.pPy);
    AppMethodBeat.o(199107);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.b.b
 * JD-Core Version:    0.7.0.1
 */