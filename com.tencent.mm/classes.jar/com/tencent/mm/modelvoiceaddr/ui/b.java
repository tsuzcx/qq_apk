package com.tencent.mm.modelvoiceaddr.ui;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import com.tencent.mm.modelvoiceaddr.f;
import com.tencent.mm.modelvoiceaddr.f.a;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.d;
import com.tencent.mm.ui.tools.n;

public final class b
  extends n
{
  public boolean eNe = true;
  public int eNf;
  public int eNg;
  b.a eNh;
  public VoiceSearchLayout eNi;
  private VoiceSearchLayout.a eNj = new b.1(this);
  
  public b() {}
  
  public b(byte paramByte)
  {
    super((byte)0);
  }
  
  protected final boolean TM()
  {
    boolean bool1 = false;
    boolean bool2 = this.eNe;
    if (this.eNi == null) {
      bool1 = true;
    }
    y.d("MicroMsg.VoiceSearchViewHelper", "check has voice search, Enable %B, layout is null ? %B", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    return this.eNe;
  }
  
  protected final void TN()
  {
    y.d("MicroMsg.VoiceSearchViewHelper", "do require voice search");
    if (this.wep != null)
    {
      this.wep.setEditTextEnabled(false);
      this.wep.setStatusBtnEnabled(false);
    }
    Object localObject;
    boolean bool;
    if ((this.eNi != null) && (this.eNi.getVisibility() == 8))
    {
      y.d("MicroMsg.VoiceSearchViewHelper", "do voice search layout start");
      localObject = this.eNi;
      int i = this.eNg;
      bool = a.j(((VoiceSearchLayout)localObject).getContext(), "android.permission.RECORD_AUDIO");
      y.i("MicroMsg.VoiceSearchLayout", "summerper checkPermission checkMicrophone[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break label280;
      }
      y.d("MicroMsg.VoiceSearchLayout", "doStart " + ((VoiceSearchLayout)localObject).bSr);
      ((VoiceSearchLayout)localObject).eMP = i;
      ((VoiceSearchLayout)localObject).bSr = true;
      ((VoiceSearchLayout)localObject).eMO = false;
      if (((VoiceSearchLayout)localObject).eMM != null) {
        ((VoiceSearchLayout)localObject).eMM.TK();
      }
      ((VoiceSearchLayout)localObject).setVisibility(0);
      ((VoiceSearchLayout)localObject).eNb.S(50L, 50L);
      ((VoiceSearchLayout)localObject).cl(true);
      ((VoiceSearchLayout)localObject).eNa = 0;
      ((VoiceSearchLayout)localObject).eMT = new f(new VoiceSearchLayout.4((VoiceSearchLayout)localObject), i);
      localObject = ((VoiceSearchLayout)localObject).eMT;
      y.i("MicroMsg.SceneVoiceAddr", "start record");
      if ((((f)localObject).eLC != 0) || (!aq.is2G(ae.getContext()))) {
        break label275;
      }
      bool = true;
      ((f)localObject).eLN = bool;
      y.i("MicroMsg.SceneVoiceAddr", "mEnableAmrMode: %b", new Object[] { Boolean.valueOf(((f)localObject).eLN) });
      e.post(new f.a((f)localObject), "SceneVoiceAddr_record");
    }
    label275:
    label280:
    while (!(((VoiceSearchLayout)localObject).getContext() instanceof Activity)) {
      for (;;)
      {
        return;
        bool = false;
      }
    }
    a.b((Activity)((VoiceSearchLayout)localObject).getContext(), "android.permission.RECORD_AUDIO", 80);
  }
  
  protected final void TO()
  {
    cancel();
  }
  
  public final void a(Activity paramActivity, Menu paramMenu)
  {
    super.a(paramActivity, paramMenu);
    if (this.eNi != null) {
      this.eNi.setOnSearchListener(this.eNj);
    }
  }
  
  public final void a(b.a parama)
  {
    this.eNh = parama;
    this.weq = parama;
  }
  
  public final void cancel()
  {
    y.d("MicroMsg.VoiceSearchViewHelper", "do cancel");
    if (this.eNi != null) {
      this.eNi.TG();
    }
    if (this.wep != null)
    {
      this.wep.setEditTextEnabled(true);
      this.wep.setStatusBtnEnabled(true);
    }
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (4 == paramInt)
    {
      if ((this.eNi != null) && (this.eNi.getVisibility() == 0)) {}
      for (boolean bool = true;; bool = false)
      {
        y.d("MicroMsg.VoiceSearchViewHelper", "on back key down, try hide voice search panel, it is visiable[%B]", new Object[] { Boolean.valueOf(bool) });
        cancel();
        if (!bool) {
          break;
        }
        return true;
      }
    }
    y.d("MicroMsg.VoiceSearchViewHelper", "not match key code, pass to super");
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.ui.b
 * JD-Core Version:    0.7.0.1
 */