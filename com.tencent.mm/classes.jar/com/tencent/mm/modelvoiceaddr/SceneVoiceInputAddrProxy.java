package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.e;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.List;

public class SceneVoiceInputAddrProxy
  extends a
  implements b
{
  private static SceneVoiceInputAddrProxy hED;
  private d fLo;
  private b hEE;
  private g.b hEF;
  
  public SceneVoiceInputAddrProxy(d paramd)
  {
    super(paramd);
    AppMethodBeat.i(148571);
    if (paramd == null)
    {
      AppMethodBeat.o(148571);
      return;
    }
    this.fLo = paramd;
    paramd.connect(new SceneVoiceInputAddrProxy.1(this));
    AppMethodBeat.o(148571);
  }
  
  public static void create(d paramd)
  {
    AppMethodBeat.i(148569);
    hED = new SceneVoiceInputAddrProxy(paramd);
    AppMethodBeat.o(148569);
  }
  
  public static SceneVoiceInputAddrProxy getInstance()
  {
    AppMethodBeat.i(148570);
    if (hED == null) {
      create(new d(aj.getContext()));
    }
    SceneVoiceInputAddrProxy localSceneVoiceInputAddrProxy = hED;
    AppMethodBeat.o(148570);
    return localSceneVoiceInputAddrProxy;
  }
  
  @e
  public void cancel(boolean paramBoolean)
  {
    AppMethodBeat.i(148574);
    REMOTE_CALL("cancelMM", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(148574);
  }
  
  @f
  public void cancelMM(boolean paramBoolean)
  {
    AppMethodBeat.i(148575);
    if (getInstance().hEE != null) {
      getInstance().hEE.cancel(paramBoolean);
    }
    AppMethodBeat.o(148575);
  }
  
  public void connect(Runnable paramRunnable)
  {
    AppMethodBeat.i(148573);
    if (this.fLo == null)
    {
      AppMethodBeat.o(148573);
      return;
    }
    this.fLo.connect(paramRunnable);
    AppMethodBeat.o(148573);
  }
  
  @e
  public int getMaxAmplitudeRate()
  {
    AppMethodBeat.i(148580);
    Integer localInteger = (Integer)REMOTE_CALL("getMaxAmplitudeRateMM", new Object[0]);
    if (localInteger == null)
    {
      AppMethodBeat.o(148580);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(148580);
    return i;
  }
  
  @f
  public int getMaxAmplitudeRateMM()
  {
    AppMethodBeat.i(148583);
    if (getInstance().hEE != null)
    {
      int i = getInstance().hEE.getMaxAmplitudeRate();
      AppMethodBeat.o(148583);
      return i;
    }
    AppMethodBeat.o(148583);
    return 0;
  }
  
  public void init(int paramInt1, int paramInt2, g.b paramb)
  {
    AppMethodBeat.i(148581);
    getInstance().hEF = paramb;
    REMOTE_CALL("initMM", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(148581);
  }
  
  @f
  public void initMM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148582);
    getInstance().hEE = new g(paramInt1, paramInt2, new g.b()
    {
      public final void aDQ()
      {
        AppMethodBeat.i(148567);
        SceneVoiceInputAddrProxy.this.CLIENT_CALL("onRecordFinCli", new Object[0]);
        AppMethodBeat.o(148567);
      }
      
      public final void aDU()
      {
        AppMethodBeat.i(148568);
        SceneVoiceInputAddrProxy.this.CLIENT_CALL("onRecognizeFinishCli", new Object[0]);
        AppMethodBeat.o(148568);
      }
      
      public final void b(String[] paramAnonymousArrayOfString, List<String> paramAnonymousList)
      {
        AppMethodBeat.i(148565);
        SceneVoiceInputAddrProxy.this.CLIENT_CALL("onResCli", new Object[] { paramAnonymousArrayOfString, paramAnonymousList });
        AppMethodBeat.o(148565);
      }
      
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, long paramAnonymousLong)
      {
        AppMethodBeat.i(148566);
        SceneVoiceInputAddrProxy.this.CLIENT_CALL("onErrorCli", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Long.valueOf(paramAnonymousLong) });
        AppMethodBeat.o(148566);
      }
    });
    AppMethodBeat.o(148582);
  }
  
  public boolean isConnected()
  {
    AppMethodBeat.i(148572);
    if (this.fLo == null)
    {
      AppMethodBeat.o(148572);
      return false;
    }
    boolean bool = this.fLo.isConnected();
    AppMethodBeat.o(148572);
    return bool;
  }
  
  @e
  public void onErrorCli(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(148585);
    if (getInstance().hEF != null) {
      getInstance().hEF.c(paramInt1, paramInt2, paramInt3, paramLong);
    }
    AppMethodBeat.o(148585);
  }
  
  @e
  public void onRecognizeFinishCli()
  {
    AppMethodBeat.i(148587);
    if (getInstance().hEF != null) {
      getInstance().hEF.aDU();
    }
    AppMethodBeat.o(148587);
  }
  
  @e
  public void onRecordFinCli()
  {
    AppMethodBeat.i(148586);
    if (getInstance().hEF != null) {
      getInstance().hEF.aDQ();
    }
    AppMethodBeat.o(148586);
  }
  
  @e
  public void onResCli(String[] paramArrayOfString, List<String> paramList)
  {
    AppMethodBeat.i(148584);
    if (getInstance().hEF != null) {
      getInstance().hEF.b(paramArrayOfString, paramList);
    }
    AppMethodBeat.o(148584);
  }
  
  @e
  public void start()
  {
    AppMethodBeat.i(148578);
    REMOTE_CALL("startMM", new Object[0]);
    AppMethodBeat.o(148578);
  }
  
  @f
  public void startMM()
  {
    AppMethodBeat.i(148579);
    if (getInstance().hEE != null) {
      getInstance().hEE.start();
    }
    AppMethodBeat.o(148579);
  }
  
  @e
  public void stop(boolean paramBoolean)
  {
    AppMethodBeat.i(148576);
    REMOTE_CALL("stopMM", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(148576);
  }
  
  @f
  public void stopMM(boolean paramBoolean)
  {
    AppMethodBeat.i(148577);
    if (getInstance().hEE != null) {
      getInstance().hEE.stop(paramBoolean);
    }
    AppMethodBeat.o(148577);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.SceneVoiceInputAddrProxy
 * JD-Core Version:    0.7.0.1
 */