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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import java.util.List;

public abstract class VoiceInputLayout
  extends LinearLayout
{
  protected int currentState = 1;
  public final au iga = new au(new au.a()
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
        VoiceInputLayout.this.FM(i);
      }
      AppMethodBeat.o(112379);
      return true;
    }
  }, true);
  public ao lso = new ao()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      AppMethodBeat.i(112373);
      if (paramAnonymousMessage.what != 0)
      {
        if (paramAnonymousMessage.what == 1) {
          ac.w("MicroMsg.VoiceInputLayout", "Recognized revealTime force finished %s", new Object[] { Integer.valueOf(VoiceInputLayout.this.currentState) });
        }
      }
      else
      {
        ac.d("MicroMsg.VoiceInputLayout", "Recognized force finished %s", new Object[] { Integer.valueOf(VoiceInputLayout.this.currentState) });
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
  protected VoiceInputLayout.a sGN;
  protected b sIt = null;
  private com.tencent.mm.modelvoiceaddr.b sIu;
  protected boolean sIv = false;
  private int sIw = 3000;
  private int sIx = 10000;
  public ao sIy = new ao()
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
        VoiceInputLayout.this.cMb();
        AppMethodBeat.o(112378);
        return;
        paramAnonymousMessage = paramAnonymousMessage.getData();
        VoiceInputLayout.this.ad(paramAnonymousMessage.getInt("localCode"), paramAnonymousMessage.getInt("errType"), paramAnonymousMessage.getInt("errCode"));
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
  
  protected abstract void FM(int paramInt);
  
  public final void aKQ()
  {
    ac.d("MicroMsg.VoiceInputLayout", "doCancel. state = %s", new Object[] { Integer.valueOf(this.currentState) });
    if (this.currentState == 1) {
      return;
    }
    this.currentState = 1;
    if (this.sIt != null) {
      this.sIt.cLJ();
    }
    if (this.sIu != null) {
      this.sIu.cancel(true);
    }
    onReset();
  }
  
  public final void ad(int paramInt1, int paramInt2, int paramInt3)
  {
    ac.d("MicroMsg.VoiceInputLayout", "doNetworkError localerrorType:%s,errorType:%s,errCode:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.currentState = 1;
    onReset();
    if (this.sIt != null) {
      this.sIt.FL(paramInt1);
    }
  }
  
  protected abstract void cLS();
  
  protected abstract void cLT();
  
  public final void cLZ()
  {
    if ((a.ci(getContext())) || (a.cf(getContext())) || (a.ck(getContext())))
    {
      ac.d("MicroMsg.VoiceInputLayout", "voip is running, cann't record voice");
      onReset();
    }
    do
    {
      do
      {
        return;
        boolean bool = com.tencent.mm.pluginsdk.permission.b.o(getContext(), "android.permission.RECORD_AUDIO");
        ac.d("MicroMsg.VoiceInputLayout", "summerper checkPermission checkMicrophone[%s]", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break;
        }
        ac.d("MicroMsg.VoiceInputLayout", "doStart currentState = %s", new Object[] { Integer.valueOf(this.currentState) });
      } while (this.currentState != 1);
      this.currentState = 2;
      if (this.sIt != null) {
        this.sIt.cLF();
      }
      this.iga.au(50L, 50L);
      cLS();
      if (ai.ciE()) {}
      for (this.sIu = new g();; this.sIu = SceneVoiceInputAddrProxy.getInstance())
      {
        this.sIu.init(g.ieO, 8, new g.b()
        {
          public final void aKH()
          {
            AppMethodBeat.i(112374);
            ac.d("MicroMsg.VoiceInputLayout", "onRecordFin() onRecordFin currentState = %s", new Object[] { Integer.valueOf(VoiceInputLayout.this.currentState) });
            if (VoiceInputLayout.c(VoiceInputLayout.this) != null) {
              VoiceInputLayout.c(VoiceInputLayout.this).stopTimer();
            }
            VoiceInputLayout.d(VoiceInputLayout.this).sendEmptyMessage(0);
            AppMethodBeat.o(112374);
          }
          
          public final void aKL()
          {
            AppMethodBeat.i(112375);
            ac.d("MicroMsg.VoiceInputLayout", "onRecognize Finish");
            VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(0);
            VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(1);
            VoiceInputLayout.this.sIt.cLL();
            VoiceInputLayout.this.reset(false);
            AppMethodBeat.o(112375);
          }
          
          public final void b(String[] paramAnonymousArrayOfString, List<String> paramAnonymousList)
          {
            AppMethodBeat.i(112376);
            VoiceInputLayout.this.sIt.c(paramAnonymousArrayOfString, paramAnonymousList);
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
        this.sIu.start();
        return;
      }
    } while (!(getContext() instanceof Activity));
    com.tencent.mm.pluginsdk.permission.b.b((Activity)getContext(), "android.permission.RECORD_AUDIO", 80);
  }
  
  public final void cMa()
  {
    ac.d("MicroMsg.VoiceInputLayout", "do Stop. currentState = %s", new Object[] { Integer.valueOf(this.currentState) });
    if ((this.currentState == 1) || (this.currentState != 2)) {}
    do
    {
      return;
      this.currentState = 3;
      if (this.sIt != null) {
        this.sIt.cLI();
      }
      if (this.iga != null) {
        this.iga.stopTimer();
      }
      this.lso.removeMessages(0);
      this.lso.sendEmptyMessageDelayed(0, this.sIw);
      this.lso.sendEmptyMessageDelayed(1, this.sIx);
      cLT();
    } while (this.sIu == null);
    this.sIu.stop(true);
  }
  
  public final void cMb()
  {
    ac.d("MicroMsg.VoiceInputLayout", "doWaiting currentState = %s", new Object[] { Integer.valueOf(this.currentState) });
    if (this.currentState != 2) {
      return;
    }
    this.currentState = 3;
    this.lso.removeMessages(0);
    this.lso.sendEmptyMessageDelayed(0, this.sIw);
    this.lso.sendEmptyMessageDelayed(1, this.sIx);
    cLT();
  }
  
  public final void cMc()
  {
    ad(12, -1, -1);
  }
  
  public int getCurrentState()
  {
    return this.currentState;
  }
  
  protected abstract void onReset();
  
  protected final void reset(boolean paramBoolean)
  {
    ac.d("MicroMsg.VoiceInputLayout", "reset currentState %s", new Object[] { Integer.valueOf(this.currentState) });
    if (this.currentState == 1) {}
    do
    {
      return;
      this.currentState = 1;
      onReset();
    } while ((!paramBoolean) || (this.sIt == null));
    this.sIt.cLK();
  }
  
  public void setFromFullScreen(boolean paramBoolean)
  {
    this.sIv = paramBoolean;
  }
  
  public void setLongClickLisnter(VoiceInputLayout.a parama)
  {
    this.sGN = parama;
  }
  
  public void setVoiceDetectListener(b paramb)
  {
    this.sIt = paramb;
  }
  
  public static abstract interface b
  {
    public abstract void FL(int paramInt);
    
    public abstract void c(String[] paramArrayOfString, List<String> paramList);
    
    public abstract void cLF();
    
    public abstract void cLI();
    
    public abstract void cLJ();
    
    public abstract void cLK();
    
    public abstract void cLL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout
 * JD-Core Version:    0.7.0.1
 */