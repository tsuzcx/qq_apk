package com.tencent.mm.plugin.cloudvoip.cloudvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q;
import com.tencent.mm.sdk.platformtools.Log;

public class PluginCloudVoice
  extends f
  implements c, com.tencent.mm.plugin.cloudvoip.cloudvoice.a.a
{
  private static final String[] qrx = { "confService", "ilink_network", "ilink_xlog" };
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(90784);
    super.configure(paramg);
    Log.i("MicroMsg.OpenVoice.PluginCloudVoice", "hy: PluginCloudVoice configure");
    AppMethodBeat.o(90784);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(90783);
    Log.i("MicroMsg.OpenVoice.PluginCloudVoice", "hy: PluginCloudVoice execute");
    AppMethodBeat.o(90783);
  }
  
  public void onAccountInitialized(e.c paramc) {}
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(90785);
    Log.i("MicroMsg.OpenVoice.PluginCloudVoice", "hy: account release. uninit openvoice so");
    com.tencent.mm.plugin.expansions.a.cMr();
    q localq = q.qta;
    localq.aj(localq.qtQ);
    AppMethodBeat.o(90785);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.PluginCloudVoice
 * JD-Core Version:    0.7.0.1
 */