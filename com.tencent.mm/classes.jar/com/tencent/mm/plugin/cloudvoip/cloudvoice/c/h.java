package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;

 enum h
{
  private h() {}
  
  static void pt(int paramInt)
  {
    y.i("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: operate network change: %d", new Object[] { Integer.valueOf(paramInt) });
    String str = ae.getProcessName();
    y.i("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: current process name is %s", new Object[] { str });
    Bundle localBundle = new Bundle();
    localBundle.putString("from_process", str);
    localBundle.putInt("opcode", paramInt);
    f.a("com.tencent.mm", localBundle, h.a.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.h
 * JD-Core Version:    0.7.0.1
 */