package com.tencent.mm.opensdk.diffdev.a;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class b
  implements OAuthListener
{
  b(a parama) {}
  
  public final void onAuthFinish(OAuthErrCode paramOAuthErrCode, String paramString)
  {
    AppMethodBeat.i(128053);
    Log.d("MicroMsg.SDK.ListenerWrapper", String.format("onAuthFinish, errCode = %s, authCode = %s", new Object[] { paramOAuthErrCode.toString(), paramString }));
    a.c(this.f);
    Object localObject = new ArrayList();
    ((List)localObject).addAll(a.a(this.f));
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((OAuthListener)((Iterator)localObject).next()).onAuthFinish(paramOAuthErrCode, paramString);
    }
    AppMethodBeat.o(128053);
  }
  
  public final void onAuthGotQrcode(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(128051);
    Log.d("MicroMsg.SDK.ListenerWrapper", "onAuthGotQrcode, qrcodeImgPath = ".concat(String.valueOf(paramString)));
    Object localObject = new ArrayList();
    ((List)localObject).addAll(a.a(this.f));
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((OAuthListener)((Iterator)localObject).next()).onAuthGotQrcode(paramString, paramArrayOfByte);
    }
    AppMethodBeat.o(128051);
  }
  
  public final void onQrcodeScanned()
  {
    AppMethodBeat.i(128052);
    Log.d("MicroMsg.SDK.ListenerWrapper", "onQrcodeScanned");
    if (a.b(this.f) != null) {
      a.b(this.f).post(new c(this));
    }
    AppMethodBeat.o(128052);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.a.b
 * JD-Core Version:    0.7.0.1
 */