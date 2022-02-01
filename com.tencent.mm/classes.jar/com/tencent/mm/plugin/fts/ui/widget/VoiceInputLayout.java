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
import com.tencent.mm.q.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.List;

public abstract class VoiceInputLayout
  extends LinearLayout
{
  protected int currentState = 1;
  public final MTimerHandler jxC = new MTimerHandler(new MTimerHandler.CallBack()
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
        VoiceInputLayout.this.Ny(i);
      }
      AppMethodBeat.o(112379);
      return true;
    }
  }, true);
  public MMHandler ndA = new MMHandler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      AppMethodBeat.i(112373);
      if (paramAnonymousMessage.what != 0)
      {
        if (paramAnonymousMessage.what == 1) {
          Log.w("MicroMsg.VoiceInputLayout", "Recognized revealTime force finished %s", new Object[] { Integer.valueOf(VoiceInputLayout.this.currentState) });
        }
      }
      else
      {
        Log.d("MicroMsg.VoiceInputLayout", "Recognized force finished %s", new Object[] { Integer.valueOf(VoiceInputLayout.this.currentState) });
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
  protected VoiceInputLayout.a xfw;
  protected b xhi = null;
  private com.tencent.mm.modelvoiceaddr.b xhj;
  protected boolean xhk = false;
  private int xhl = 3000;
  private int xhm = 10000;
  public MMHandler xhn = new MMHandler()
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
        VoiceInputLayout.this.dQo();
        AppMethodBeat.o(112378);
        return;
        paramAnonymousMessage = paramAnonymousMessage.getData();
        VoiceInputLayout.this.ai(paramAnonymousMessage.getInt("localCode"), paramAnonymousMessage.getInt("errType"), paramAnonymousMessage.getInt("errCode"));
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
  
  protected abstract void Ny(int paramInt);
  
  public final void ai(int paramInt1, int paramInt2, int paramInt3)
  {
    Log.d("MicroMsg.VoiceInputLayout", "doNetworkError localerrorType:%s,errorType:%s,errCode:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.currentState = 1;
    onReset();
    if (this.xhi != null) {
      this.xhi.Nx(paramInt1);
    }
  }
  
  public final void biE()
  {
    Log.d("MicroMsg.VoiceInputLayout", "doCancel. state = %s", new Object[] { Integer.valueOf(this.currentState) });
    if (this.currentState == 1) {
      return;
    }
    this.currentState = 1;
    if (this.xhi != null) {
      this.xhi.dPR();
    }
    if (this.xhj != null) {
      this.xhj.cancel(true);
    }
    onReset();
  }
  
  protected abstract void dPZ();
  
  protected abstract void dQa();
  
  public final void dQm()
  {
    if ((a.cC(getContext())) || (a.cA(getContext())) || (a.cE(getContext())))
    {
      Log.d("MicroMsg.VoiceInputLayout", "voip is running, cann't record voice");
      onReset();
    }
    do
    {
      do
      {
        return;
        boolean bool = com.tencent.mm.pluginsdk.permission.b.n(getContext(), "android.permission.RECORD_AUDIO");
        Log.d("MicroMsg.VoiceInputLayout", "summerper checkPermission checkMicrophone[%s]", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break;
        }
        Log.d("MicroMsg.VoiceInputLayout", "doStart currentState = %s", new Object[] { Integer.valueOf(this.currentState) });
      } while (this.currentState != 1);
      this.currentState = 2;
      if (this.xhi != null) {
        this.xhi.dPN();
      }
      this.jxC.startTimer(50L);
      dPZ();
      if (MMApplicationContext.isMMProcess()) {}
      for (this.xhj = new g();; this.xhj = SceneVoiceInputAddrProxy.getInstance())
      {
        this.xhj.init(g.jwq, 8, new g.b()
        {
          public final void b(String[] paramAnonymousArrayOfString, List<String> paramAnonymousList)
          {
            AppMethodBeat.i(112376);
            VoiceInputLayout.this.xhi.c(paramAnonymousArrayOfString, paramAnonymousList);
            VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(0);
            VoiceInputLayout.a(VoiceInputLayout.this).sendEmptyMessageDelayed(0, VoiceInputLayout.e(VoiceInputLayout.this));
            AppMethodBeat.o(112376);
          }
          
          public final void biv()
          {
            AppMethodBeat.i(112374);
            Log.d("MicroMsg.VoiceInputLayout", "onRecordFin() onRecordFin currentState = %s", new Object[] { Integer.valueOf(VoiceInputLayout.this.currentState) });
            if (VoiceInputLayout.c(VoiceInputLayout.this) != null) {
              VoiceInputLayout.c(VoiceInputLayout.this).stopTimer();
            }
            VoiceInputLayout.d(VoiceInputLayout.this).sendEmptyMessage(0);
            AppMethodBeat.o(112374);
          }
          
          public final void biz()
          {
            AppMethodBeat.i(112375);
            Log.d("MicroMsg.VoiceInputLayout", "onRecognize Finish");
            VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(0);
            VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(1);
            VoiceInputLayout.this.xhi.dPT();
            VoiceInputLayout.this.reset(false);
            AppMethodBeat.o(112375);
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
        this.xhj.start();
        return;
      }
    } while (!(getContext() instanceof Activity));
    com.tencent.mm.pluginsdk.permission.b.b((Activity)getContext(), "android.permission.RECORD_AUDIO", 80);
  }
  
  public final void dQn()
  {
    Log.d("MicroMsg.VoiceInputLayout", "do Stop. currentState = %s", new Object[] { Integer.valueOf(this.currentState) });
    if ((this.currentState == 1) || (this.currentState != 2)) {}
    do
    {
      return;
      this.currentState = 3;
      if (this.xhi != null) {
        this.xhi.dPQ();
      }
      if (this.jxC != null) {
        this.jxC.stopTimer();
      }
      this.ndA.removeMessages(0);
      this.ndA.sendEmptyMessageDelayed(0, this.xhl);
      this.ndA.sendEmptyMessageDelayed(1, this.xhm);
      dQa();
    } while (this.xhj == null);
    this.xhj.stop(true);
  }
  
  public final void dQo()
  {
    Log.d("MicroMsg.VoiceInputLayout", "doWaiting currentState = %s", new Object[] { Integer.valueOf(this.currentState) });
    if (this.currentState != 2) {
      return;
    }
    this.currentState = 3;
    this.ndA.removeMessages(0);
    this.ndA.sendEmptyMessageDelayed(0, this.xhl);
    this.ndA.sendEmptyMessageDelayed(1, this.xhm);
    dQa();
  }
  
  public final void dQp()
  {
    ai(12, -1, -1);
  }
  
  public int getCurrentState()
  {
    return this.currentState;
  }
  
  protected abstract void onReset();
  
  protected final void reset(boolean paramBoolean)
  {
    Log.d("MicroMsg.VoiceInputLayout", "reset currentState %s", new Object[] { Integer.valueOf(this.currentState) });
    if (this.currentState == 1) {}
    do
    {
      return;
      this.currentState = 1;
      onReset();
    } while ((!paramBoolean) || (this.xhi == null));
    this.xhi.dPS();
  }
  
  public void setFromFullScreen(boolean paramBoolean)
  {
    this.xhk = paramBoolean;
  }
  
  public void setLongClickLisnter(VoiceInputLayout.a parama)
  {
    this.xfw = parama;
  }
  
  public void setVoiceDetectListener(b paramb)
  {
    this.xhi = paramb;
  }
  
  public static abstract interface b
  {
    public abstract void Nx(int paramInt);
    
    public abstract void c(String[] paramArrayOfString, List<String> paramList);
    
    public abstract void dPN();
    
    public abstract void dPQ();
    
    public abstract void dPR();
    
    public abstract void dPS();
    
    public abstract void dPT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout
 * JD-Core Version:    0.7.0.1
 */