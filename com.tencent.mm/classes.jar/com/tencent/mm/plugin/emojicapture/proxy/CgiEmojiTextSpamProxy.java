package com.tencent.mm.plugin.emojicapture.proxy;

import a.d.a.b;
import a.n;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.e;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

public final class CgiEmojiTextSpamProxy
  extends a
{
  private final String TAG = "MicroMsg.CgiEmojiTextSpamProxy";
  private b<? super Boolean, n> jnu;
  
  public CgiEmojiTextSpamProxy(d paramd)
  {
    super(paramd);
  }
  
  public final void cgiEmojiTextSpam(String paramString, b<? super Boolean, n> paramb)
  {
    y.i(this.TAG, "cgiEmojiTextSpam " + paramString);
    REMOTE_CALL("cgiEmojiTextSpamRemote", new Object[] { paramString });
    this.jnu = paramb;
  }
  
  @e
  public final void cgiEmojiTextSpamCallback(boolean paramBoolean)
  {
    y.i(this.TAG, "cgiEmojiTextSpamCallback " + paramBoolean);
    b localb = this.jnu;
    if (localb != null) {
      localb.W(Boolean.valueOf(paramBoolean));
    }
  }
  
  @f
  public final void cgiEmojiTextSpamRemote(String paramString)
  {
    ai.d((Runnable)new CgiEmojiTextSpamProxy.a(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.proxy.CgiEmojiTextSpamProxy
 * JD-Core Version:    0.7.0.1
 */