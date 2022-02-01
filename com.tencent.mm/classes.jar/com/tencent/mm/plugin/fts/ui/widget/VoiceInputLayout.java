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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import java.util.List;

public abstract class VoiceInputLayout
  extends LinearLayout
{
  protected int currentState = 1;
  public final aw iCn = new aw(new aw.a()
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
        VoiceInputLayout.this.Hy(i);
      }
      AppMethodBeat.o(112379);
      return true;
    }
  }, true);
  public aq lVY = new aq()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      AppMethodBeat.i(112373);
      if (paramAnonymousMessage.what != 0)
      {
        if (paramAnonymousMessage.what == 1) {
          ae.w("MicroMsg.VoiceInputLayout", "Recognized revealTime force finished %s", new Object[] { Integer.valueOf(VoiceInputLayout.this.currentState) });
        }
      }
      else
      {
        ae.d("MicroMsg.VoiceInputLayout", "Recognized force finished %s", new Object[] { Integer.valueOf(VoiceInputLayout.this.currentState) });
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
  protected a tOx;
  protected b tPV = null;
  private com.tencent.mm.modelvoiceaddr.b tPW;
  protected boolean tPX = false;
  private int tPY = 3000;
  private int tPZ = 10000;
  public aq tQa = new aq()
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
        VoiceInputLayout.this.cWZ();
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
  
  protected abstract void Hy(int paramInt);
  
  public final void aOx()
  {
    ae.d("MicroMsg.VoiceInputLayout", "doCancel. state = %s", new Object[] { Integer.valueOf(this.currentState) });
    if (this.currentState == 1) {
      return;
    }
    this.currentState = 1;
    if (this.tPV != null) {
      this.tPV.cWH();
    }
    if (this.tPW != null) {
      this.tPW.cancel(true);
    }
    onReset();
  }
  
  public final void ad(int paramInt1, int paramInt2, int paramInt3)
  {
    ae.d("MicroMsg.VoiceInputLayout", "doNetworkError localerrorType:%s,errorType:%s,errCode:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.currentState = 1;
    onReset();
    if (this.tPV != null) {
      this.tPV.Hx(paramInt1);
    }
  }
  
  protected abstract void cWQ();
  
  protected abstract void cWR();
  
  public final void cWX()
  {
    if ((a.ch(getContext())) || (a.cf(getContext())) || (a.cj(getContext())))
    {
      ae.d("MicroMsg.VoiceInputLayout", "voip is running, cann't record voice");
      onReset();
    }
    do
    {
      do
      {
        return;
        boolean bool = com.tencent.mm.pluginsdk.permission.b.n(getContext(), "android.permission.RECORD_AUDIO");
        ae.d("MicroMsg.VoiceInputLayout", "summerper checkPermission checkMicrophone[%s]", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break;
        }
        ae.d("MicroMsg.VoiceInputLayout", "doStart currentState = %s", new Object[] { Integer.valueOf(this.currentState) });
      } while (this.currentState != 1);
      this.currentState = 2;
      if (this.tPV != null) {
        this.tPV.cWD();
      }
      this.iCn.ay(50L, 50L);
      cWQ();
      if (ak.cpe()) {}
      for (this.tPW = new g();; this.tPW = SceneVoiceInputAddrProxy.getInstance())
      {
        this.tPW.init(g.iBb, 8, new g.b()
        {
          public final void aOo()
          {
            AppMethodBeat.i(112374);
            ae.d("MicroMsg.VoiceInputLayout", "onRecordFin() onRecordFin currentState = %s", new Object[] { Integer.valueOf(VoiceInputLayout.this.currentState) });
            if (VoiceInputLayout.c(VoiceInputLayout.this) != null) {
              VoiceInputLayout.c(VoiceInputLayout.this).stopTimer();
            }
            VoiceInputLayout.d(VoiceInputLayout.this).sendEmptyMessage(0);
            AppMethodBeat.o(112374);
          }
          
          public final void aOs()
          {
            AppMethodBeat.i(112375);
            ae.d("MicroMsg.VoiceInputLayout", "onRecognize Finish");
            VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(0);
            VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(1);
            VoiceInputLayout.this.tPV.cWJ();
            VoiceInputLayout.this.reset(false);
            AppMethodBeat.o(112375);
          }
          
          public final void b(String[] paramAnonymousArrayOfString, List<String> paramAnonymousList)
          {
            AppMethodBeat.i(112376);
            VoiceInputLayout.this.tPV.c(paramAnonymousArrayOfString, paramAnonymousList);
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
        this.tPW.start();
        return;
      }
    } while (!(getContext() instanceof Activity));
    com.tencent.mm.pluginsdk.permission.b.b((Activity)getContext(), "android.permission.RECORD_AUDIO", 80);
  }
  
  public final void cWY()
  {
    ae.d("MicroMsg.VoiceInputLayout", "do Stop. currentState = %s", new Object[] { Integer.valueOf(this.currentState) });
    if ((this.currentState == 1) || (this.currentState != 2)) {}
    do
    {
      return;
      this.currentState = 3;
      if (this.tPV != null) {
        this.tPV.cWG();
      }
      if (this.iCn != null) {
        this.iCn.stopTimer();
      }
      this.lVY.removeMessages(0);
      this.lVY.sendEmptyMessageDelayed(0, this.tPY);
      this.lVY.sendEmptyMessageDelayed(1, this.tPZ);
      cWR();
    } while (this.tPW == null);
    this.tPW.stop(true);
  }
  
  public final void cWZ()
  {
    ae.d("MicroMsg.VoiceInputLayout", "doWaiting currentState = %s", new Object[] { Integer.valueOf(this.currentState) });
    if (this.currentState != 2) {
      return;
    }
    this.currentState = 3;
    this.lVY.removeMessages(0);
    this.lVY.sendEmptyMessageDelayed(0, this.tPY);
    this.lVY.sendEmptyMessageDelayed(1, this.tPZ);
    cWR();
  }
  
  public final void cXa()
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
    ae.d("MicroMsg.VoiceInputLayout", "reset currentState %s", new Object[] { Integer.valueOf(this.currentState) });
    if (this.currentState == 1) {}
    do
    {
      return;
      this.currentState = 1;
      onReset();
    } while ((!paramBoolean) || (this.tPV == null));
    this.tPV.cWI();
  }
  
  public void setFromFullScreen(boolean paramBoolean)
  {
    this.tPX = paramBoolean;
  }
  
  public void setLongClickLisnter(a parama)
  {
    this.tOx = parama;
  }
  
  public void setVoiceDetectListener(b paramb)
  {
    this.tPV = paramb;
  }
  
  public static abstract interface a
  {
    public abstract void cWM();
  }
  
  public static abstract interface b
  {
    public abstract void Hx(int paramInt);
    
    public abstract void c(String[] paramArrayOfString, List<String> paramList);
    
    public abstract void cWD();
    
    public abstract void cWG();
    
    public abstract void cWH();
    
    public abstract void cWI();
    
    public abstract void cWJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout
 * JD-Core Version:    0.7.0.1
 */