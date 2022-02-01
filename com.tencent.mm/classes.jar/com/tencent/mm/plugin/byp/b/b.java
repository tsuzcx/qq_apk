package com.tencent.mm.plugin.byp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.sf;
import com.tencent.mm.protocal.protobuf.sk;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/byp/cgi/CgiBypSendEmoij;", "Lcom/tencent/mm/plugin/byp/cgi/CgiBypSend;", "bizType", "", "session_id", "", "from_username", "to_username", "emoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "msgId", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/storage/emotion/EmojiInfo;J)V", "onSendFailed", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/protocal/protobuf/BypSendResponse;", "onSendSuccessfully", "Companion", "plugin-byp_release"})
public final class b
  extends a
{
  private static final boolean dal;
  public static final a sWB;
  private final String from_username;
  private final EmojiInfo fxn;
  private final int hDp = 3;
  private final long msgId;
  private final String sWA;
  private final String session_id;
  
  static
  {
    boolean bool = false;
    AppMethodBeat.i(213412);
    sWB = new a((byte)0);
    if (BuildInfo.DEBUG) {
      bool = true;
    }
    dal = bool;
    AppMethodBeat.o(213412);
  }
  
  public b(String paramString1, String paramString2, String paramString3, EmojiInfo paramEmojiInfo, long paramLong)
  {
    super(3, localsf);
    this.session_id = paramString1;
    this.from_username = paramString2;
    this.sWA = paramString3;
    this.fxn = paramEmojiInfo;
    this.msgId = paramLong;
    paramString1 = cFe().SbJ;
    paramString1.md5 = this.fxn.getMd5();
    paramString1.type = this.fxn.getType();
    paramString1.fTZ = this.fxn.getSize();
    paramString1.Sbf = this.fxn.getContent();
    paramString1.Sbh = 0;
    paramString1 = h.ae(n.class);
    p.j(paramString1, "MMKernel.service(IMessengerStorage::class.java)");
    paramString1 = ((n)paramString1).eSe().Oq(this.msgId);
    paramString1.setContent(this.from_username + paramString1.getContent());
    paramString2 = h.ae(n.class);
    p.j(paramString2, "MMKernel.service(IMessengerStorage::class.java)");
    ((n)paramString2).eSe().a(this.msgId, paramString1);
    AppMethodBeat.o(213410);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, sk paramsk)
  {
    AppMethodBeat.i(213407);
    p.k(paramsk, "resp");
    Log.e("Byp.CgiBypSendEmoij", "[onSendFailed] bizType=" + this.hDp + " sessionId=" + this.session_id + " toUsername=" + this.sWA + " fromUsername=" + this.from_username + " errCode:" + paramInt2 + " errMsg:" + paramString);
    AppMethodBeat.o(213407);
  }
  
  public final void a(sk paramsk)
  {
    AppMethodBeat.i(213402);
    p.k(paramsk, "resp");
    Log.i("Byp.CgiBypSendEmoij", "[onSendSuccessfully] bizType=" + this.hDp + " msgSvrId=" + paramsk.SbR + "  sessionId=" + this.session_id + " toUsername=" + this.sWA + " fromUsername=" + this.from_username);
    AppMethodBeat.o(213402);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/byp/cgi/CgiBypSendEmoij$Companion;", "", "()V", "TAG", "", "isDebug", "", "()Z", "plugin-byp_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.b.b
 * JD-Core Version:    0.7.0.1
 */