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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.List;

public abstract class VoiceInputLayout
  extends LinearLayout
{
  protected int currentState = 1;
  public final ap gcG = new ap(new VoiceInputLayout.4(this), true);
  public ak ipC = new VoiceInputLayout.1(this);
  protected VoiceInputLayout.a nbV;
  protected VoiceInputLayout.b nck = null;
  private com.tencent.mm.modelvoiceaddr.b ncl;
  protected boolean ncm = false;
  private int ncn = 3000;
  private int nco = 10000;
  public ak ncp = new VoiceInputLayout.3(this);
  
  public VoiceInputLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @TargetApi(11)
  public VoiceInputLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void U(int paramInt1, int paramInt2, int paramInt3)
  {
    ab.d("MicroMsg.VoiceInputLayout", "doNetworkError localerrorType:%s,errorType:%s,errCode:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.currentState = 1;
    onReset();
    if (this.nck != null) {
      this.nck.wE(paramInt1);
    }
  }
  
  public final void amT()
  {
    ab.d("MicroMsg.VoiceInputLayout", "doCancel. state = %s", new Object[] { Integer.valueOf(this.currentState) });
    if (this.currentState == 1) {
      return;
    }
    this.currentState = 1;
    if (this.nck != null) {
      this.nck.bDu();
    }
    if (this.ncl != null) {
      this.ncl.cancel(true);
    }
    onReset();
  }
  
  protected abstract void bDD();
  
  protected abstract void bDE();
  
  public final void bDF()
  {
    if ((a.bO(getContext())) || (a.bM(getContext())))
    {
      ab.d("MicroMsg.VoiceInputLayout", "voip is running, cann't record voice");
      onReset();
    }
    do
    {
      do
      {
        return;
        boolean bool = com.tencent.mm.pluginsdk.permission.b.o(getContext(), "android.permission.RECORD_AUDIO");
        ab.d("MicroMsg.VoiceInputLayout", "summerper checkPermission checkMicrophone[%s]", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break;
        }
        ab.d("MicroMsg.VoiceInputLayout", "doStart currentState = %s", new Object[] { Integer.valueOf(this.currentState) });
      } while (this.currentState != 1);
      this.currentState = 2;
      if (this.nck != null) {
        this.nck.bDq();
      }
      this.gcG.ag(50L, 50L);
      bDD();
      if (ah.brt()) {}
      for (this.ncl = new g();; this.ncl = SceneVoiceInputAddrProxy.getInstance())
      {
        this.ncl.init(g.gbA, 8, new g.b()
        {
          public final void amK()
          {
            AppMethodBeat.i(62208);
            ab.d("MicroMsg.VoiceInputLayout", "onRecordFin() onRecordFin currentState = %s", new Object[] { Integer.valueOf(VoiceInputLayout.this.currentState) });
            if (VoiceInputLayout.c(VoiceInputLayout.this) != null) {
              VoiceInputLayout.c(VoiceInputLayout.this).stopTimer();
            }
            VoiceInputLayout.d(VoiceInputLayout.this).sendEmptyMessage(0);
            AppMethodBeat.o(62208);
          }
          
          public final void amO()
          {
            AppMethodBeat.i(62209);
            ab.d("MicroMsg.VoiceInputLayout", "onRecognize Finish");
            VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(0);
            VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(1);
            VoiceInputLayout.this.nck.bDw();
            VoiceInputLayout.this.reset(false);
            AppMethodBeat.o(62209);
          }
          
          public final void b(String[] paramAnonymousArrayOfString, List<String> paramAnonymousList)
          {
            AppMethodBeat.i(138303);
            VoiceInputLayout.this.nck.c(paramAnonymousArrayOfString, paramAnonymousList);
            VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(0);
            VoiceInputLayout.a(VoiceInputLayout.this).sendEmptyMessageDelayed(0, VoiceInputLayout.e(VoiceInputLayout.this));
            AppMethodBeat.o(138303);
          }
          
          public final void c(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, long paramAnonymousLong)
          {
            AppMethodBeat.i(62211);
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
            AppMethodBeat.o(62211);
          }
        });
        this.ncl.start();
        return;
      }
    } while (!(getContext() instanceof Activity));
    com.tencent.mm.pluginsdk.permission.b.b((Activity)getContext(), "android.permission.RECORD_AUDIO", 80);
  }
  
  public final void bDG()
  {
    ab.d("MicroMsg.VoiceInputLayout", "do Stop. currentState = %s", new Object[] { Integer.valueOf(this.currentState) });
    if ((this.currentState == 1) || (this.currentState != 2)) {}
    do
    {
      return;
      this.currentState = 3;
      if (this.nck != null) {
        this.nck.bDt();
      }
      if (this.gcG != null) {
        this.gcG.stopTimer();
      }
      this.ipC.removeMessages(0);
      this.ipC.sendEmptyMessageDelayed(0, this.ncn);
      this.ipC.sendEmptyMessageDelayed(1, this.nco);
      bDE();
    } while (this.ncl == null);
    this.ncl.stop(true);
  }
  
  public final void bDH()
  {
    ab.d("MicroMsg.VoiceInputLayout", "doWaiting currentState = %s", new Object[] { Integer.valueOf(this.currentState) });
    if (this.currentState != 2) {
      return;
    }
    this.currentState = 3;
    this.ipC.removeMessages(0);
    this.ipC.sendEmptyMessageDelayed(0, this.ncn);
    this.ipC.sendEmptyMessageDelayed(1, this.nco);
    bDE();
  }
  
  public final void bDI()
  {
    U(12, -1, -1);
  }
  
  public int getCurrentState()
  {
    return this.currentState;
  }
  
  protected abstract void onReset();
  
  protected final void reset(boolean paramBoolean)
  {
    ab.d("MicroMsg.VoiceInputLayout", "reset currentState %s", new Object[] { Integer.valueOf(this.currentState) });
    if (this.currentState == 1) {}
    do
    {
      return;
      this.currentState = 1;
      onReset();
    } while ((!paramBoolean) || (this.nck == null));
    this.nck.bDv();
  }
  
  public void setFromFullScreen(boolean paramBoolean)
  {
    this.ncm = paramBoolean;
  }
  
  public void setLongClickLisnter(VoiceInputLayout.a parama)
  {
    this.nbV = parama;
  }
  
  public void setVoiceDetectListener(VoiceInputLayout.b paramb)
  {
    this.nck = paramb;
  }
  
  protected abstract void wF(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout
 * JD-Core Version:    0.7.0.1
 */