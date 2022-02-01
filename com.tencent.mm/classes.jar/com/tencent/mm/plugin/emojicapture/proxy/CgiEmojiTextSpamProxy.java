package com.tencent.mm.plugin.emojicapture.proxy;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.protocal.protobuf.amu;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/proxy/CgiEmojiTextSpamProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "TAG", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "shouldBlock", "", "getCallback", "()Lkotlin/jvm/functions/Function1;", "setCallback", "(Lkotlin/jvm/functions/Function1;)V", "cgiEmojiTextSpam", "text", "cgiEmojiTextSpamCallback", "cgiEmojiTextSpamRemote", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CgiEmojiTextSpamProxy
  extends com.tencent.mm.remoteservice.a
{
  private final String TAG = "MicroMsg.CgiEmojiTextSpamProxy";
  private b<? super Boolean, ah> callback;
  
  public CgiEmojiTextSpamProxy(d paramd)
  {
    super(paramd);
  }
  
  private static final Object a(CgiEmojiTextSpamProxy paramCgiEmojiTextSpamProxy, b.a parama)
  {
    AppMethodBeat.i(269311);
    s.u(paramCgiEmojiTextSpamProxy, "this$0");
    s.u(parama, "cgiBack");
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      parama = (amu)parama.ott;
      Log.i(paramCgiEmojiTextSpamProxy.TAG, "CgiTextAntiSpam " + parama.ZtI + ' ' + parama.ZtJ + ' ' + parama.ZtK);
    }
    for (boolean bool = parama.ZtI;; bool = false)
    {
      paramCgiEmojiTextSpamProxy = paramCgiEmojiTextSpamProxy.CLIENT_CALL("cgiEmojiTextSpamCallback", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(269311);
      return paramCgiEmojiTextSpamProxy;
      Log.w(paramCgiEmojiTextSpamProxy.TAG, "CgiTextAntiSpam error " + parama.errType + ' ' + parama.errCode);
    }
  }
  
  private static final void a(String paramString, CgiEmojiTextSpamProxy paramCgiEmojiTextSpamProxy)
  {
    AppMethodBeat.i(269315);
    s.u(paramCgiEmojiTextSpamProxy, "this$0");
    new com.tencent.mm.plugin.emojicapture.a.a(paramString).bFJ().g(new CgiEmojiTextSpamProxy..ExternalSyntheticLambda0(paramCgiEmojiTextSpamProxy));
    AppMethodBeat.o(269315);
  }
  
  public final void cgiEmojiTextSpam(String paramString, b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(378);
    Log.i(this.TAG, s.X("cgiEmojiTextSpam ", paramString));
    REMOTE_CALL("cgiEmojiTextSpamRemote", new Object[] { paramString });
    this.callback = paramb;
    AppMethodBeat.o(378);
  }
  
  @e
  public final void cgiEmojiTextSpamCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(379);
    Log.i(this.TAG, s.X("cgiEmojiTextSpamCallback ", Boolean.valueOf(paramBoolean)));
    b localb = this.callback;
    if (localb != null) {
      localb.invoke(Boolean.valueOf(paramBoolean));
    }
    AppMethodBeat.o(379);
  }
  
  @com.tencent.mm.remoteservice.f
  public final void cgiEmojiTextSpamRemote(String paramString)
  {
    AppMethodBeat.i(380);
    MMHandlerThread.postToMainThread(new CgiEmojiTextSpamProxy..ExternalSyntheticLambda1(paramString, this));
    AppMethodBeat.o(380);
  }
  
  public final b<Boolean, ah> getCallback()
  {
    return this.callback;
  }
  
  public final void setCallback(b<? super Boolean, ah> paramb)
  {
    this.callback = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.proxy.CgiEmojiTextSpamProxy
 * JD-Core Version:    0.7.0.1
 */