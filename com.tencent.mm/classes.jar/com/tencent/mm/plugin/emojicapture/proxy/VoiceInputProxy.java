package com.tencent.mm.plugin.emojicapture.proxy;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.modelvoiceaddr.g.b;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.e;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "uiCallback", "Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "TAG", "", "getUiCallback", "()Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;", "setUiCallback", "(Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;)V", "getMaxAmplitudeRate", "", "getMaxAmplitudeRateRemote", "onRecongnizeFinish", "", "onRes", "voiceText", "start", "startRemote", "stop", "fromUI", "", "stopRemote", "Companion", "UICallback", "plugin-emojicapture_release"})
public final class VoiceInputProxy
  extends a
{
  private static g lwN;
  public static final VoiceInputProxy.a lwO;
  private final String TAG;
  private VoiceInputProxy.b lwM;
  
  static
  {
    AppMethodBeat.i(2855);
    lwO = new VoiceInputProxy.a((byte)0);
    AppMethodBeat.o(2855);
  }
  
  public VoiceInputProxy(VoiceInputProxy.b paramb, d paramd)
  {
    super(paramd);
    this.lwM = paramb;
    this.TAG = "MicroMsg.VoiceInputProxy";
  }
  
  @e
  public final int getMaxAmplitudeRate()
  {
    AppMethodBeat.i(2851);
    Object localObject = REMOTE_CALL("getMaxAmplitudeRateRemote", new Object[0]);
    if ((localObject != null) && ((localObject instanceof Integer)))
    {
      int i = ((Number)localObject).intValue();
      AppMethodBeat.o(2851);
      return i;
    }
    AppMethodBeat.o(2851);
    return 0;
  }
  
  @f
  public final int getMaxAmplitudeRateRemote()
  {
    AppMethodBeat.i(2853);
    ab.d(this.TAG, "getMaxAmplitudeRateRemote call " + lwN);
    if (lwN != null)
    {
      g localg = lwN;
      if (localg == null) {
        j.ebi();
      }
      int i = localg.getMaxAmplitudeRate();
      AppMethodBeat.o(2853);
      return i;
    }
    AppMethodBeat.o(2853);
    return 0;
  }
  
  public final VoiceInputProxy.b getUiCallback()
  {
    return this.lwM;
  }
  
  @e
  public final void onRecongnizeFinish()
  {
    AppMethodBeat.i(2850);
    VoiceInputProxy.b localb = this.lwM;
    if (localb != null)
    {
      localb.amO();
      AppMethodBeat.o(2850);
      return;
    }
    AppMethodBeat.o(2850);
  }
  
  @e
  public final void onRes(String paramString)
  {
    AppMethodBeat.i(2849);
    VoiceInputProxy.b localb = this.lwM;
    if (localb != null)
    {
      localb.onRes(paramString);
      AppMethodBeat.o(2849);
      return;
    }
    AppMethodBeat.o(2849);
  }
  
  public final void setUiCallback(VoiceInputProxy.b paramb)
  {
    this.lwM = paramb;
  }
  
  @e
  public final void start()
  {
    AppMethodBeat.i(2847);
    REMOTE_CALL("startRemote", new Object[0]);
    AppMethodBeat.o(2847);
  }
  
  @f
  public final void startRemote()
  {
    AppMethodBeat.i(2852);
    Object localObject = new VoiceInputProxy.c(this);
    localObject = new g(g.gbA, 9, (g.b)localObject);
    lwN = (g)localObject;
    ((g)localObject).start();
    AppMethodBeat.o(2852);
  }
  
  @e
  public final void stop(boolean paramBoolean)
  {
    AppMethodBeat.i(2848);
    REMOTE_CALL("stopRemote", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(2848);
  }
  
  @f
  public final void stopRemote(boolean paramBoolean)
  {
    AppMethodBeat.i(2854);
    g localg = lwN;
    if (localg != null) {
      localg.stop(paramBoolean);
    }
    lwN = null;
    AppMethodBeat.o(2854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.proxy.VoiceInputProxy
 * JD-Core Version:    0.7.0.1
 */