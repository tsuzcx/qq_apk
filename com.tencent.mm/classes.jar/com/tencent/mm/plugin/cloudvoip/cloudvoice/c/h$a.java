package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class h$a
  implements i<Bundle, Bundle>
{
  private static String iFa;
  private static final n iFb = new h.a.1();
  
  private static Bundle o(Bundle paramBundle)
  {
    int i = paramBundle.getInt("opcode", -1);
    paramBundle = paramBundle.getString("from_process", "");
    iFa = paramBundle;
    if ((bk.bl(paramBundle)) || (!iFa.startsWith("com.tencent.mm")))
    {
      y.e("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: invalid package name %s", new Object[] { iFa });
      return null;
    }
    if (i == 0)
    {
      g.DO().a(iFb);
      return null;
    }
    if (i == 1)
    {
      g.DO().b(iFb);
      return null;
    }
    y.w("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: not valid op code");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.h.a
 * JD-Core Version:    0.7.0.1
 */