package com.tencent.mm.plugin.emojicapture.proxy;

import a.f.a.b;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.e;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/proxy/CgiEmojiTextSpamProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "TAG", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "shouldBlock", "", "getCallback", "()Lkotlin/jvm/functions/Function1;", "setCallback", "(Lkotlin/jvm/functions/Function1;)V", "cgiEmojiTextSpam", "text", "cgiEmojiTextSpamCallback", "cgiEmojiTextSpamRemote", "plugin-emojicapture_release"})
public final class CgiEmojiTextSpamProxy
  extends a
{
  private final String TAG = "MicroMsg.CgiEmojiTextSpamProxy";
  private b<? super Boolean, y> evv;
  
  public CgiEmojiTextSpamProxy(d paramd)
  {
    super(paramd);
  }
  
  public final void cgiEmojiTextSpam(String paramString, b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(2800);
    ab.i(this.TAG, "cgiEmojiTextSpam ".concat(String.valueOf(paramString)));
    REMOTE_CALL("cgiEmojiTextSpamRemote", new Object[] { paramString });
    this.evv = paramb;
    AppMethodBeat.o(2800);
  }
  
  @e
  public final void cgiEmojiTextSpamCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(2801);
    ab.i(this.TAG, "cgiEmojiTextSpamCallback ".concat(String.valueOf(paramBoolean)));
    b localb = this.evv;
    if (localb != null)
    {
      localb.S(Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(2801);
      return;
    }
    AppMethodBeat.o(2801);
  }
  
  @f
  public final void cgiEmojiTextSpamRemote(String paramString)
  {
    AppMethodBeat.i(2802);
    al.d((Runnable)new CgiEmojiTextSpamProxy.a(this, paramString));
    AppMethodBeat.o(2802);
  }
  
  public final b<Boolean, y> getCallback()
  {
    return this.evv;
  }
  
  public final void setCallback(b<? super Boolean, y> paramb)
  {
    this.evv = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.proxy.CgiEmojiTextSpamProxy
 * JD-Core Version:    0.7.0.1
 */