package com.tencent.mm.plugin.emojicapture.proxy;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.a.b;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/proxy/CgiEmojiTextSpamProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "TAG", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "shouldBlock", "", "getCallback", "()Lkotlin/jvm/functions/Function1;", "setCallback", "(Lkotlin/jvm/functions/Function1;)V", "cgiEmojiTextSpam", "text", "cgiEmojiTextSpamCallback", "cgiEmojiTextSpamRemote", "plugin-emojicapture_release"})
public final class CgiEmojiTextSpamProxy
  extends com.tencent.mm.remoteservice.a
{
  private final String TAG = "MicroMsg.CgiEmojiTextSpamProxy";
  private b<? super Boolean, y> fPk;
  
  public CgiEmojiTextSpamProxy(d paramd)
  {
    super(paramd);
  }
  
  public final void cgiEmojiTextSpam(String paramString, b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(378);
    ac.i(this.TAG, "cgiEmojiTextSpam ".concat(String.valueOf(paramString)));
    REMOTE_CALL("cgiEmojiTextSpamRemote", new Object[] { paramString });
    this.fPk = paramb;
    AppMethodBeat.o(378);
  }
  
  @e
  public final void cgiEmojiTextSpamCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(379);
    ac.i(this.TAG, "cgiEmojiTextSpamCallback ".concat(String.valueOf(paramBoolean)));
    b localb = this.fPk;
    if (localb != null)
    {
      localb.ay(Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(379);
      return;
    }
    AppMethodBeat.o(379);
  }
  
  @com.tencent.mm.remoteservice.f
  public final void cgiEmojiTextSpamRemote(final String paramString)
  {
    AppMethodBeat.i(380);
    ap.f((Runnable)new a(this, paramString));
    AppMethodBeat.o(380);
  }
  
  public final b<Boolean, y> getCallback()
  {
    return this.fPk;
  }
  
  public final void setCallback(b<? super Boolean, y> paramb)
  {
    this.fPk = paramb;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(CgiEmojiTextSpamProxy paramCgiEmojiTextSpamProxy, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(377);
      new com.tencent.mm.plugin.emojicapture.a.a(paramString).aBB().g((com.tencent.mm.vending.c.a)new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(377);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.proxy.CgiEmojiTextSpamProxy
 * JD-Core Version:    0.7.0.1
 */