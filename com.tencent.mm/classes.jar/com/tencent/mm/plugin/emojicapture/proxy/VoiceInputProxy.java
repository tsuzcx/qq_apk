package com.tencent.mm.plugin.emojicapture.proxy;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.modelvoiceaddr.g.b;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.e;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "uiCallback", "Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "TAG", "", "getUiCallback", "()Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;", "setUiCallback", "(Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;)V", "getMaxAmplitudeRate", "", "getMaxAmplitudeRateRemote", "onRecongnizeFinish", "", "onRes", "voiceText", "start", "startRemote", "stop", "fromUI", "", "stopRemote", "Companion", "UICallback", "plugin-emojicapture_release"})
public final class VoiceInputProxy
  extends a
{
  private static g rrK;
  public static final VoiceInputProxy.a rrL;
  private final String TAG;
  private b rrJ;
  
  static
  {
    AppMethodBeat.i(433);
    rrL = new VoiceInputProxy.a((byte)0);
    AppMethodBeat.o(433);
  }
  
  public VoiceInputProxy(b paramb, d paramd)
  {
    super(paramd);
    this.rrJ = paramb;
    this.TAG = "MicroMsg.VoiceInputProxy";
  }
  
  @e
  public final int getMaxAmplitudeRate()
  {
    AppMethodBeat.i(429);
    Object localObject = REMOTE_CALL("getMaxAmplitudeRateRemote", new Object[0]);
    if ((localObject != null) && ((localObject instanceof Integer)))
    {
      int i = ((Number)localObject).intValue();
      AppMethodBeat.o(429);
      return i;
    }
    AppMethodBeat.o(429);
    return 0;
  }
  
  @f
  public final int getMaxAmplitudeRateRemote()
  {
    AppMethodBeat.i(431);
    Log.d(this.TAG, "getMaxAmplitudeRateRemote call " + rrK);
    if (rrK != null)
    {
      g localg = rrK;
      if (localg == null) {
        p.hyc();
      }
      int i = localg.getMaxAmplitudeRate();
      AppMethodBeat.o(431);
      return i;
    }
    AppMethodBeat.o(431);
    return 0;
  }
  
  public final b getUiCallback()
  {
    return this.rrJ;
  }
  
  @e
  public final void onRecongnizeFinish()
  {
    AppMethodBeat.i(428);
    b localb = this.rrJ;
    if (localb != null)
    {
      localb.biz();
      AppMethodBeat.o(428);
      return;
    }
    AppMethodBeat.o(428);
  }
  
  @e
  public final void onRes(String paramString)
  {
    AppMethodBeat.i(427);
    b localb = this.rrJ;
    if (localb != null)
    {
      localb.onRes(paramString);
      AppMethodBeat.o(427);
      return;
    }
    AppMethodBeat.o(427);
  }
  
  public final void setUiCallback(b paramb)
  {
    this.rrJ = paramb;
  }
  
  @e
  public final void start()
  {
    AppMethodBeat.i(425);
    REMOTE_CALL("startRemote", new Object[0]);
    AppMethodBeat.o(425);
  }
  
  @f
  public final void startRemote()
  {
    AppMethodBeat.i(430);
    Object localObject = new VoiceInputProxy.c(this);
    localObject = new g(g.jwq, 9, (g.b)localObject);
    rrK = (g)localObject;
    ((g)localObject).start();
    AppMethodBeat.o(430);
  }
  
  @e
  public final void stop(boolean paramBoolean)
  {
    AppMethodBeat.i(426);
    REMOTE_CALL("stopRemote", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(426);
  }
  
  @f
  public final void stopRemote(boolean paramBoolean)
  {
    AppMethodBeat.i(432);
    g localg = rrK;
    if (localg != null) {
      localg.stop(paramBoolean);
    }
    rrK = null;
    AppMethodBeat.o(432);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;", "", "onRecognizeFinish", "", "onRes", "voiceText", "", "plugin-emojicapture_release"})
  public static abstract interface b
  {
    public abstract void biz();
    
    public abstract void onRes(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.proxy.VoiceInputProxy
 * JD-Core Version:    0.7.0.1
 */