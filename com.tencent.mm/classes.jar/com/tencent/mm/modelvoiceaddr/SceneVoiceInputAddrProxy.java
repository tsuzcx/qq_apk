package com.tencent.mm.modelvoiceaddr;

import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.e;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Set;

public class SceneVoiceInputAddrProxy
  extends a
  implements b
{
  private static SceneVoiceInputAddrProxy eMe;
  private b eMf;
  private g.b eMg;
  private d eMh;
  
  public SceneVoiceInputAddrProxy(d paramd)
  {
    super(paramd);
    if (paramd == null) {
      return;
    }
    this.eMh = paramd;
    paramd.connect(new SceneVoiceInputAddrProxy.1(this));
  }
  
  public static void create(d paramd)
  {
    eMe = new SceneVoiceInputAddrProxy(paramd);
  }
  
  public static SceneVoiceInputAddrProxy getInstance()
  {
    if (eMe == null) {
      create(new d(ae.getContext()));
    }
    return eMe;
  }
  
  @e
  public void cancel(boolean paramBoolean)
  {
    REMOTE_CALL("cancelMM", new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  @f
  public void cancelMM(boolean paramBoolean)
  {
    if (getInstance().eMf != null) {
      getInstance().eMf.cancel(paramBoolean);
    }
  }
  
  public void connect(Runnable paramRunnable)
  {
    if (this.eMh == null) {
      return;
    }
    this.eMh.connect(paramRunnable);
  }
  
  @e
  public int getMaxAmplitudeRate()
  {
    Integer localInteger = (Integer)REMOTE_CALL("getMaxAmplitudeRateMM", new Object[0]);
    if (localInteger == null) {
      return 0;
    }
    return localInteger.intValue();
  }
  
  @f
  public int getMaxAmplitudeRateMM()
  {
    if (getInstance().eMf != null) {
      return getInstance().eMf.getMaxAmplitudeRate();
    }
    return 0;
  }
  
  public void init(int paramInt1, int paramInt2, g.b paramb)
  {
    getInstance().eMg = paramb;
    REMOTE_CALL("initMM", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  @f
  public void initMM(int paramInt1, int paramInt2)
  {
    getInstance().eMf = new g(paramInt1, paramInt2, new SceneVoiceInputAddrProxy.2(this));
  }
  
  public boolean isConnected()
  {
    if (this.eMh == null) {
      return false;
    }
    return this.eMh.isConnected();
  }
  
  @e
  public void onErrorCli(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    if (getInstance().eMg != null) {
      getInstance().eMg.c(paramInt1, paramInt2, paramInt3, paramLong);
    }
  }
  
  @e
  public void onRecognizeFinishCli()
  {
    if (getInstance().eMg != null) {
      getInstance().eMg.TC();
    }
  }
  
  @e
  public void onRecordFinCli()
  {
    if (getInstance().eMg != null) {
      getInstance().eMg.Ty();
    }
  }
  
  @e
  public void onResCli(String[] paramArrayOfString, Set<String> paramSet)
  {
    if (getInstance().eMg != null) {
      getInstance().eMg.a(paramArrayOfString, paramSet);
    }
  }
  
  @e
  public void start()
  {
    REMOTE_CALL("startMM", new Object[0]);
  }
  
  @f
  public void startMM()
  {
    if (getInstance().eMf != null) {
      getInstance().eMf.start();
    }
  }
  
  @e
  public void stop(boolean paramBoolean)
  {
    REMOTE_CALL("stopMM", new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  @f
  public void stopMM(boolean paramBoolean)
  {
    if (getInstance().eMf != null) {
      getInstance().eMf.stop(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.SceneVoiceInputAddrProxy
 * JD-Core Version:    0.7.0.1
 */