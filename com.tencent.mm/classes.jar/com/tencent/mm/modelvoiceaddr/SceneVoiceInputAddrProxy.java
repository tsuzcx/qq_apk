package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.e;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.List;

public class SceneVoiceInputAddrProxy
  extends a
  implements b
{
  private static SceneVoiceInputAddrProxy gbL;
  private d evl;
  private b gbM;
  private g.b gbN;
  
  public SceneVoiceInputAddrProxy(d paramd)
  {
    super(paramd);
    AppMethodBeat.i(116729);
    if (paramd == null)
    {
      AppMethodBeat.o(116729);
      return;
    }
    this.evl = paramd;
    paramd.connect(new SceneVoiceInputAddrProxy.1(this));
    AppMethodBeat.o(116729);
  }
  
  public static void create(d paramd)
  {
    AppMethodBeat.i(116727);
    gbL = new SceneVoiceInputAddrProxy(paramd);
    AppMethodBeat.o(116727);
  }
  
  public static SceneVoiceInputAddrProxy getInstance()
  {
    AppMethodBeat.i(116728);
    if (gbL == null) {
      create(new d(ah.getContext()));
    }
    SceneVoiceInputAddrProxy localSceneVoiceInputAddrProxy = gbL;
    AppMethodBeat.o(116728);
    return localSceneVoiceInputAddrProxy;
  }
  
  @e
  public void cancel(boolean paramBoolean)
  {
    AppMethodBeat.i(116732);
    REMOTE_CALL("cancelMM", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(116732);
  }
  
  @f
  public void cancelMM(boolean paramBoolean)
  {
    AppMethodBeat.i(116733);
    if (getInstance().gbM != null) {
      getInstance().gbM.cancel(paramBoolean);
    }
    AppMethodBeat.o(116733);
  }
  
  public void connect(Runnable paramRunnable)
  {
    AppMethodBeat.i(116731);
    if (this.evl == null)
    {
      AppMethodBeat.o(116731);
      return;
    }
    this.evl.connect(paramRunnable);
    AppMethodBeat.o(116731);
  }
  
  @e
  public int getMaxAmplitudeRate()
  {
    AppMethodBeat.i(116738);
    Integer localInteger = (Integer)REMOTE_CALL("getMaxAmplitudeRateMM", new Object[0]);
    if (localInteger == null)
    {
      AppMethodBeat.o(116738);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(116738);
    return i;
  }
  
  @f
  public int getMaxAmplitudeRateMM()
  {
    AppMethodBeat.i(116741);
    if (getInstance().gbM != null)
    {
      int i = getInstance().gbM.getMaxAmplitudeRate();
      AppMethodBeat.o(116741);
      return i;
    }
    AppMethodBeat.o(116741);
    return 0;
  }
  
  public void init(int paramInt1, int paramInt2, g.b paramb)
  {
    AppMethodBeat.i(116739);
    getInstance().gbN = paramb;
    REMOTE_CALL("initMM", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(116739);
  }
  
  @f
  public void initMM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(116740);
    getInstance().gbM = new g(paramInt1, paramInt2, new SceneVoiceInputAddrProxy.2(this));
    AppMethodBeat.o(116740);
  }
  
  public boolean isConnected()
  {
    AppMethodBeat.i(116730);
    if (this.evl == null)
    {
      AppMethodBeat.o(116730);
      return false;
    }
    boolean bool = this.evl.isConnected();
    AppMethodBeat.o(116730);
    return bool;
  }
  
  @e
  public void onErrorCli(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(116743);
    if (getInstance().gbN != null) {
      getInstance().gbN.c(paramInt1, paramInt2, paramInt3, paramLong);
    }
    AppMethodBeat.o(116743);
  }
  
  @e
  public void onRecognizeFinishCli()
  {
    AppMethodBeat.i(116745);
    if (getInstance().gbN != null) {
      getInstance().gbN.amO();
    }
    AppMethodBeat.o(116745);
  }
  
  @e
  public void onRecordFinCli()
  {
    AppMethodBeat.i(116744);
    if (getInstance().gbN != null) {
      getInstance().gbN.amK();
    }
    AppMethodBeat.o(116744);
  }
  
  @e
  public void onResCli(String[] paramArrayOfString, List<String> paramList)
  {
    AppMethodBeat.i(138330);
    if (getInstance().gbN != null) {
      getInstance().gbN.b(paramArrayOfString, paramList);
    }
    AppMethodBeat.o(138330);
  }
  
  @e
  public void start()
  {
    AppMethodBeat.i(116736);
    REMOTE_CALL("startMM", new Object[0]);
    AppMethodBeat.o(116736);
  }
  
  @f
  public void startMM()
  {
    AppMethodBeat.i(116737);
    if (getInstance().gbM != null) {
      getInstance().gbM.start();
    }
    AppMethodBeat.o(116737);
  }
  
  @e
  public void stop(boolean paramBoolean)
  {
    AppMethodBeat.i(116734);
    REMOTE_CALL("stopMM", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(116734);
  }
  
  @f
  public void stopMM(boolean paramBoolean)
  {
    AppMethodBeat.i(116735);
    if (getInstance().gbM != null) {
      getInstance().gbM.stop(paramBoolean);
    }
    AppMethodBeat.o(116735);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.SceneVoiceInputAddrProxy
 * JD-Core Version:    0.7.0.1
 */