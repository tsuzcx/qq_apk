package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.diffdev.OAuthListener;

final class f
  extends AsyncTask<Void, Void, f.a>
{
  private OAuthListener l;
  private String o;
  private int u;
  private String url;
  
  public f(String paramString, OAuthListener paramOAuthListener)
  {
    AppMethodBeat.i(128054);
    this.o = paramString;
    this.l = paramOAuthListener;
    this.url = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", new Object[] { paramString });
    AppMethodBeat.o(128054);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.a.f
 * JD-Core Version:    0.7.0.1
 */