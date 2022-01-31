package com.tencent.mm.plugin.account.model;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.g.a.a;
import com.tencent.mm.ui.g.a.a.1;
import com.tencent.mm.ui.g.a.c;

public final class h
{
  private c gAP;
  h.a gAQ;
  ak handler;
  
  public h(c paramc, h.a parama)
  {
    this.gAP = paramc;
    this.gAQ = parama;
  }
  
  public final void apL()
  {
    AppMethodBeat.i(124693);
    this.handler = new h.1(this);
    Bundle localBundle = new Bundle();
    localBundle.putString("client_id", ah.getContext().getString(2131306163));
    localBundle.putString("client_secret", ah.getContext().getString(2131306164));
    localBundle.putString("grant_type", "fb_exchange_token");
    localBundle.putString("fb_exchange_token", this.gAP.gsH);
    h.2 local2 = new h.2(this);
    d.post(new a.1(new a(this.gAP), "oauth/access_token", localBundle, "GET", local2), "AsyncFacebookRunner_request");
    AppMethodBeat.o(124693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.h
 * JD-Core Version:    0.7.0.1
 */