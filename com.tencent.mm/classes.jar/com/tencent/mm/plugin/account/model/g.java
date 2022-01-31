package com.tencent.mm.plugin.account.model;

import android.os.Bundle;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.f.a.a;
import com.tencent.mm.ui.f.a.a.1;
import com.tencent.mm.ui.f.a.c;

public final class g
{
  private c fjx;
  g.a fjy;
  ah handler;
  
  public g(c paramc, g.a parama)
  {
    this.fjx = paramc;
    this.fjy = parama;
  }
  
  public final void Xx()
  {
    this.handler = new g.1(this);
    Bundle localBundle = new Bundle();
    localBundle.putString("client_id", "290293790992170");
    localBundle.putString("client_secret", "6667e9307e67283c76028fd37189c096");
    localBundle.putString("grant_type", "fb_exchange_token");
    localBundle.putString("fb_exchange_token", this.fjx.faP);
    g.2 local2 = new g.2(this);
    e.post(new a.1(new a(this.fjx), "oauth/access_token", localBundle, "GET", local2), "AsyncFacebookRunner_request");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.g
 * JD-Core Version:    0.7.0.1
 */