package com.tencent.mm.plugin.fts.ui.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.mm.modelvoiceaddr.SceneVoiceInputAddrProxy;
import com.tencent.mm.modelvoiceaddr.b;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.modelvoiceaddr.g.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Set;

public abstract class VoiceInputLayout
  extends LinearLayout
{
  private final am eNb = new am(new VoiceInputLayout.4(this), true);
  private ah gNQ = new VoiceInputLayout.1(this);
  protected int kFU = 1;
  private VoiceInputLayout.b kFX = null;
  private b kFY;
  protected boolean kFZ = false;
  protected VoiceInputLayout.a kFa;
  private int kGa = 3000;
  private int kGb = 10000;
  private ah kGc = new VoiceInputLayout.3(this);
  
  public VoiceInputLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public VoiceInputLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @TargetApi(11)
  public VoiceInputLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void I(int paramInt1, int paramInt2, int paramInt3)
  {
    y.d("MicroMsg.VoiceInputLayout", "doNetworkError localerrorType:%s,errorType:%s,errCode:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.kFU = 1;
    onReset();
    if (this.kFX != null) {
      this.kFX.rG(paramInt1);
    }
  }
  
  public final void TG()
  {
    y.d("MicroMsg.VoiceInputLayout", "doCancel. state = %s", new Object[] { Integer.valueOf(this.kFU) });
    if (this.kFU == 1) {
      return;
    }
    this.kFU = 1;
    if (this.kFX != null) {
      this.kFX.aWN();
    }
    if (this.kFY != null) {
      this.kFY.cancel(true);
    }
    onReset();
  }
  
  protected abstract void aWS();
  
  protected abstract void aWT();
  
  public final void aWV()
  {
    if ((com.tencent.mm.r.a.bk(getContext())) || (com.tencent.mm.r.a.bi(getContext())))
    {
      y.d("MicroMsg.VoiceInputLayout", "voip is running, cann't record voice");
      onReset();
    }
    do
    {
      do
      {
        return;
        boolean bool = com.tencent.mm.pluginsdk.permission.a.j(getContext(), "android.permission.RECORD_AUDIO");
        y.d("MicroMsg.VoiceInputLayout", "summerper checkPermission checkMicrophone[%s]", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break;
        }
        y.d("MicroMsg.VoiceInputLayout", "doStart currentState = %s", new Object[] { Integer.valueOf(this.kFU) });
      } while (this.kFU != 1);
      this.kFU = 2;
      if (this.kFX != null) {
        this.kFX.aWL();
      }
      this.eNb.S(50L, 50L);
      aWS();
      if (ae.cqV()) {}
      for (this.kFY = new g();; this.kFY = SceneVoiceInputAddrProxy.getInstance())
      {
        this.kFY.init(g.eLT, 8, new g.b()
        {
          public final void TC()
          {
            y.d("MicroMsg.VoiceInputLayout", "onRecognize Finish");
            VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(0);
            VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(1);
            VoiceInputLayout.e(VoiceInputLayout.this).aWP();
            VoiceInputLayout.this.reset(false);
          }
          
          public final void Ty()
          {
            y.d("MicroMsg.VoiceInputLayout", "onRecordFin() onRecordFin currentState = %s", new Object[] { Integer.valueOf(VoiceInputLayout.this.kFU) });
            if (VoiceInputLayout.c(VoiceInputLayout.this) != null) {
              VoiceInputLayout.c(VoiceInputLayout.this).stopTimer();
            }
            VoiceInputLayout.d(VoiceInputLayout.this).sendEmptyMessage(0);
          }
          
          public final void a(String[] paramAnonymousArrayOfString, Set<String> paramAnonymousSet)
          {
            VoiceInputLayout.e(VoiceInputLayout.this).b(paramAnonymousArrayOfString, paramAnonymousSet);
            VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(0);
            VoiceInputLayout.a(VoiceInputLayout.this).sendEmptyMessageDelayed(0, VoiceInputLayout.f(VoiceInputLayout.this));
          }
          
          public final void c(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, long paramAnonymousLong)
          {
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
          }
        });
        this.kFY.start();
        return;
      }
    } while (!(getContext() instanceof Activity));
    com.tencent.mm.pluginsdk.permission.a.b((Activity)getContext(), "android.permission.RECORD_AUDIO", 80);
  }
  
  public final void aWW()
  {
    y.d("MicroMsg.VoiceInputLayout", "do Stop. currentState = %s", new Object[] { Integer.valueOf(this.kFU) });
    if ((this.kFU == 1) || (this.kFU != 2)) {}
    do
    {
      return;
      this.kFU = 3;
      if (this.kFX != null) {
        this.kFX.aWM();
      }
      if (this.eNb != null) {
        this.eNb.stopTimer();
      }
      this.gNQ.removeMessages(0);
      this.gNQ.sendEmptyMessageDelayed(0, this.kGa);
      this.gNQ.sendEmptyMessageDelayed(1, this.kGb);
      aWT();
    } while (this.kFY == null);
    this.kFY.stop(true);
  }
  
  public final void aWX()
  {
    y.d("MicroMsg.VoiceInputLayout", "doWaiting currentState = %s", new Object[] { Integer.valueOf(this.kFU) });
    if (this.kFU != 2) {
      return;
    }
    this.kFU = 3;
    this.gNQ.removeMessages(0);
    this.gNQ.sendEmptyMessageDelayed(0, this.kGa);
    this.gNQ.sendEmptyMessageDelayed(1, this.kGb);
    aWT();
  }
  
  public int getCurrentState()
  {
    return this.kFU;
  }
  
  protected abstract void onReset();
  
  protected abstract void rH(int paramInt);
  
  protected final void reset(boolean paramBoolean)
  {
    y.d("MicroMsg.VoiceInputLayout", "reset currentState %s", new Object[] { Integer.valueOf(this.kFU) });
    if (this.kFU == 1) {}
    do
    {
      return;
      this.kFU = 1;
      onReset();
    } while ((!paramBoolean) || (this.kFX == null));
    this.kFX.aWO();
  }
  
  public void setFromFullScreen(boolean paramBoolean)
  {
    this.kFZ = paramBoolean;
  }
  
  public void setLongClickLisnter(VoiceInputLayout.a parama)
  {
    this.kFa = parama;
  }
  
  public void setVoiceDetectListener(VoiceInputLayout.b paramb)
  {
    this.kFX = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout
 * JD-Core Version:    0.7.0.1
 */