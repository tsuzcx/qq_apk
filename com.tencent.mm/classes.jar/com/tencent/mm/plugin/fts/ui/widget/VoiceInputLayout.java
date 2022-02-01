package com.tencent.mm.plugin.fts.ui.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.SceneVoiceInputAddrProxy;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.modelvoiceaddr.g.b;
import com.tencent.mm.r.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import java.util.List;

public abstract class VoiceInputLayout
  extends LinearLayout
{
  protected int currentState = 1;
  public final av hFy = new av(new av.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(112379);
      if (VoiceInputLayout.b(VoiceInputLayout.this) == null)
      {
        AppMethodBeat.o(112379);
        return true;
      }
      int i = VoiceInputLayout.b(VoiceInputLayout.this).getMaxAmplitudeRate();
      if (VoiceInputLayout.this.currentState == 2) {
        VoiceInputLayout.this.DQ(i);
      }
      AppMethodBeat.o(112379);
      return true;
    }
  }, true);
  public ap kQO = new ap()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      AppMethodBeat.i(112373);
      if (paramAnonymousMessage.what != 0)
      {
        if (paramAnonymousMessage.what == 1) {
          ad.w("MicroMsg.VoiceInputLayout", "Recognized revealTime force finished %s", new Object[] { Integer.valueOf(VoiceInputLayout.this.currentState) });
        }
      }
      else
      {
        ad.d("MicroMsg.VoiceInputLayout", "Recognized force finished %s", new Object[] { Integer.valueOf(VoiceInputLayout.this.currentState) });
        if (VoiceInputLayout.this.currentState == 3) {
          break label91;
        }
        AppMethodBeat.o(112373);
        return;
      }
      AppMethodBeat.o(112373);
      return;
      label91:
      VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(0);
      VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(1);
      if (VoiceInputLayout.b(VoiceInputLayout.this) != null) {
        VoiceInputLayout.b(VoiceInputLayout.this).cancel(true);
      }
      VoiceInputLayout.this.reset(true);
      AppMethodBeat.o(112373);
    }
  };
  protected a rxV;
  protected b rzB = null;
  private com.tencent.mm.modelvoiceaddr.b rzC;
  protected boolean rzD = false;
  private int rzE = 3000;
  private int rzF = 10000;
  public ap rzG = new ap()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      AppMethodBeat.i(112378);
      switch (paramAnonymousMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(112378);
        return;
        VoiceInputLayout.this.cyP();
        AppMethodBeat.o(112378);
        return;
        paramAnonymousMessage = paramAnonymousMessage.getData();
        VoiceInputLayout.this.ac(paramAnonymousMessage.getInt("localCode"), paramAnonymousMessage.getInt("errType"), paramAnonymousMessage.getInt("errCode"));
      }
    }
  };
  
  public VoiceInputLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @TargetApi(11)
  public VoiceInputLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected abstract void DQ(int paramInt);
  
  public final void aDZ()
  {
    ad.d("MicroMsg.VoiceInputLayout", "doCancel. state = %s", new Object[] { Integer.valueOf(this.currentState) });
    if (this.currentState == 1) {
      return;
    }
    this.currentState = 1;
    if (this.rzB != null) {
      this.rzB.cyx();
    }
    if (this.rzC != null) {
      this.rzC.cancel(true);
    }
    onReset();
  }
  
  public final void ac(int paramInt1, int paramInt2, int paramInt3)
  {
    ad.d("MicroMsg.VoiceInputLayout", "doNetworkError localerrorType:%s,errorType:%s,errCode:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.currentState = 1;
    onReset();
    if (this.rzB != null) {
      this.rzB.DP(paramInt1);
    }
  }
  
  protected abstract void cyG();
  
  protected abstract void cyH();
  
  public final void cyN()
  {
    if ((a.ce(getContext())) || (a.cc(getContext())))
    {
      ad.d("MicroMsg.VoiceInputLayout", "voip is running, cann't record voice");
      onReset();
    }
    do
    {
      do
      {
        return;
        boolean bool = com.tencent.mm.pluginsdk.permission.b.o(getContext(), "android.permission.RECORD_AUDIO");
        ad.d("MicroMsg.VoiceInputLayout", "summerper checkPermission checkMicrophone[%s]", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break;
        }
        ad.d("MicroMsg.VoiceInputLayout", "doStart currentState = %s", new Object[] { Integer.valueOf(this.currentState) });
      } while (this.currentState != 1);
      this.currentState = 2;
      if (this.rzB != null) {
        this.rzB.cyt();
      }
      this.hFy.av(50L, 50L);
      cyG();
      if (aj.cbv()) {}
      for (this.rzC = new g();; this.rzC = SceneVoiceInputAddrProxy.getInstance())
      {
        this.rzC.init(g.hEm, 8, new g.b()
        {
          public final void aDQ()
          {
            AppMethodBeat.i(112374);
            ad.d("MicroMsg.VoiceInputLayout", "onRecordFin() onRecordFin currentState = %s", new Object[] { Integer.valueOf(VoiceInputLayout.this.currentState) });
            if (VoiceInputLayout.c(VoiceInputLayout.this) != null) {
              VoiceInputLayout.c(VoiceInputLayout.this).stopTimer();
            }
            VoiceInputLayout.d(VoiceInputLayout.this).sendEmptyMessage(0);
            AppMethodBeat.o(112374);
          }
          
          public final void aDU()
          {
            AppMethodBeat.i(112375);
            ad.d("MicroMsg.VoiceInputLayout", "onRecognize Finish");
            VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(0);
            VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(1);
            VoiceInputLayout.this.rzB.cyz();
            VoiceInputLayout.this.reset(false);
            AppMethodBeat.o(112375);
          }
          
          public final void b(String[] paramAnonymousArrayOfString, List<String> paramAnonymousList)
          {
            AppMethodBeat.i(112376);
            VoiceInputLayout.this.rzB.c(paramAnonymousArrayOfString, paramAnonymousList);
            VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(0);
            VoiceInputLayout.a(VoiceInputLayout.this).sendEmptyMessageDelayed(0, VoiceInputLayout.e(VoiceInputLayout.this));
            AppMethodBeat.o(112376);
          }
          
          public final void c(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, long paramAnonymousLong)
          {
            AppMethodBeat.i(112377);
            VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(0);
            VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(1);
            Message localMessage = new Message();
            Bundle localBundle = new Bundle();
            localBundle.putInt("localCode", paramAnonymousInt1);
            localBundle.putInt("errType", paramAnonymousInt2);
            localBundle.putInt("errCode", paramAnonymousInt3);
            localMessage.setData(localBundle);
            localMessage.what = 1;
            VoiceInputLayout.d(VoiceInputLayout.this).sendMessage(localMessage);
            AppMethodBeat.o(112377);
          }
        });
        this.rzC.start();
        return;
      }
    } while (!(getContext() instanceof Activity));
    com.tencent.mm.pluginsdk.permission.b.b((Activity)getContext(), "android.permission.RECORD_AUDIO", 80);
  }
  
  public final void cyO()
  {
    ad.d("MicroMsg.VoiceInputLayout", "do Stop. currentState = %s", new Object[] { Integer.valueOf(this.currentState) });
    if ((this.currentState == 1) || (this.currentState != 2)) {}
    do
    {
      return;
      this.currentState = 3;
      if (this.rzB != null) {
        this.rzB.cyw();
      }
      if (this.hFy != null) {
        this.hFy.stopTimer();
      }
      this.kQO.removeMessages(0);
      this.kQO.sendEmptyMessageDelayed(0, this.rzE);
      this.kQO.sendEmptyMessageDelayed(1, this.rzF);
      cyH();
    } while (this.rzC == null);
    this.rzC.stop(true);
  }
  
  public final void cyP()
  {
    ad.d("MicroMsg.VoiceInputLayout", "doWaiting currentState = %s", new Object[] { Integer.valueOf(this.currentState) });
    if (this.currentState != 2) {
      return;
    }
    this.currentState = 3;
    this.kQO.removeMessages(0);
    this.kQO.sendEmptyMessageDelayed(0, this.rzE);
    this.kQO.sendEmptyMessageDelayed(1, this.rzF);
    cyH();
  }
  
  public final void cyQ()
  {
    ac(12, -1, -1);
  }
  
  public int getCurrentState()
  {
    return this.currentState;
  }
  
  protected abstract void onReset();
  
  protected final void reset(boolean paramBoolean)
  {
    ad.d("MicroMsg.VoiceInputLayout", "reset currentState %s", new Object[] { Integer.valueOf(this.currentState) });
    if (this.currentState == 1) {}
    do
    {
      return;
      this.currentState = 1;
      onReset();
    } while ((!paramBoolean) || (this.rzB == null));
    this.rzB.cyy();
  }
  
  public void setFromFullScreen(boolean paramBoolean)
  {
    this.rzD = paramBoolean;
  }
  
  public void setLongClickLisnter(a parama)
  {
    this.rxV = parama;
  }
  
  public void setVoiceDetectListener(b paramb)
  {
    this.rzB = paramb;
  }
  
  public static abstract interface a
  {
    public abstract void cyC();
  }
  
  public static abstract interface b
  {
    public abstract void DP(int paramInt);
    
    public abstract void c(String[] paramArrayOfString, List<String> paramList);
    
    public abstract void cyt();
    
    public abstract void cyw();
    
    public abstract void cyx();
    
    public abstract void cyy();
    
    public abstract void cyz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout
 * JD-Core Version:    0.7.0.1
 */