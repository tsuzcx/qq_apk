package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.net.HttpURLConnection;

final class ProtocolThreeThreeUI$6
  implements Runnable
{
  ProtocolThreeThreeUI$6(ProtocolThreeThreeUI paramProtocolThreeThreeUI, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(21154);
    ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[] { m.U(this.mOZ.getIntent()), Integer.valueOf(m.V(this.mOZ.getIntent())), this.val$url });
    a.bAk();
    a.a(this.val$url, new a.a()
    {
      public final void h(Exception paramAnonymousException)
      {
        AppMethodBeat.i(21153);
        ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", new Object[] { m.U(ProtocolThreeThreeUI.6.this.mOZ.getIntent()), Integer.valueOf(m.V(ProtocolThreeThreeUI.6.this.mOZ.getIntent())), paramAnonymousException.getMessage() });
        d.a(ProtocolThreeThreeUI.6.this.mOZ.ssid, 3, ProtocolThreeThreeUI.6.this.mOZ.getIntent());
        AppMethodBeat.o(21153);
      }
      
      public final void h(HttpURLConnection paramAnonymousHttpURLConnection)
      {
        AppMethodBeat.i(21152);
        int i = paramAnonymousHttpURLConnection.getResponseCode();
        ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[] { m.U(ProtocolThreeThreeUI.6.this.mOZ.getIntent()), Integer.valueOf(m.V(ProtocolThreeThreeUI.6.this.mOZ.getIntent())), Integer.valueOf(i) });
        if (i == 200)
        {
          ProtocolThreeThreeUI.c(ProtocolThreeThreeUI.6.this.mOZ);
          AppMethodBeat.o(21152);
          return;
        }
        if (i == 302)
        {
          paramAnonymousHttpURLConnection = paramAnonymousHttpURLConnection.getHeaderField("Location");
          ProtocolThreeThreeUI.a(ProtocolThreeThreeUI.6.this.mOZ, paramAnonymousHttpURLConnection);
          AppMethodBeat.o(21152);
          return;
        }
        ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[] { m.U(ProtocolThreeThreeUI.6.this.mOZ.getIntent()), Integer.valueOf(m.V(ProtocolThreeThreeUI.6.this.mOZ.getIntent())) });
        d.a(ProtocolThreeThreeUI.6.this.mOZ.ssid, 3, ProtocolThreeThreeUI.6.this.mOZ.getIntent());
        AppMethodBeat.o(21152);
      }
    });
    AppMethodBeat.o(21154);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI.6
 * JD-Core Version:    0.7.0.1
 */