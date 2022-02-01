package com.tencent.mm.modelvoiceaddr.ui;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.f;
import com.tencent.mm.modelvoiceaddr.f.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.r.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.ui.tools.d;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.tools.r.b;

public final class b
  extends r
{
  public boolean iCq;
  public int iCr;
  public int iCs;
  a iCt;
  public VoiceSearchLayout iCu;
  private VoiceSearchLayout.a iCv;
  
  public b()
  {
    AppMethodBeat.i(148635);
    this.iCq = true;
    this.iCv = new VoiceSearchLayout.a()
    {
      public final void a(boolean paramAnonymousBoolean, String[] paramAnonymousArrayOfString, long paramAnonymousLong)
      {
        AppMethodBeat.i(148634);
        ae.d("MicroMsg.VoiceSearchViewHelper", "on voice search return, success %B, voice id %d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Long.valueOf(paramAnonymousLong) });
        if (b.this.iCt != null) {
          b.this.iCt.a(paramAnonymousBoolean, paramAnonymousArrayOfString, paramAnonymousLong, b.this.iCs);
        }
        AppMethodBeat.o(148634);
      }
      
      public final void aOB()
      {
        AppMethodBeat.i(148632);
        if ((a.ch(ak.getContext())) || (a.cf(ak.getContext())) || (a.cj(ak.getContext())))
        {
          AppMethodBeat.o(148632);
          return;
        }
        ae.d("MicroMsg.VoiceSearchViewHelper", "on voice search start");
        g.yxI.f(10453, new Object[] { Integer.valueOf(b.this.iCr), Integer.valueOf(3) });
        if (b.this.iCt != null) {
          b.this.iCt.aOF();
        }
        AppMethodBeat.o(148632);
      }
      
      public final void aOC()
      {
        AppMethodBeat.i(148633);
        ae.d("MicroMsg.VoiceSearchViewHelper", "on voice search cancel");
        g.yxI.f(10453, new Object[] { Integer.valueOf(b.this.iCr), Integer.valueOf(4) });
        if (b.this.Lhj != null)
        {
          b.this.Lhj.setEditTextEnabled(true);
          b.this.Lhj.setStatusBtnEnabled(true);
        }
        AppMethodBeat.o(148633);
      }
    };
    AppMethodBeat.o(148635);
  }
  
  public b(byte paramByte)
  {
    super((byte)0);
    AppMethodBeat.i(148636);
    this.iCq = true;
    this.iCv = new VoiceSearchLayout.a()
    {
      public final void a(boolean paramAnonymousBoolean, String[] paramAnonymousArrayOfString, long paramAnonymousLong)
      {
        AppMethodBeat.i(148634);
        ae.d("MicroMsg.VoiceSearchViewHelper", "on voice search return, success %B, voice id %d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Long.valueOf(paramAnonymousLong) });
        if (b.this.iCt != null) {
          b.this.iCt.a(paramAnonymousBoolean, paramAnonymousArrayOfString, paramAnonymousLong, b.this.iCs);
        }
        AppMethodBeat.o(148634);
      }
      
      public final void aOB()
      {
        AppMethodBeat.i(148632);
        if ((a.ch(ak.getContext())) || (a.cf(ak.getContext())) || (a.cj(ak.getContext())))
        {
          AppMethodBeat.o(148632);
          return;
        }
        ae.d("MicroMsg.VoiceSearchViewHelper", "on voice search start");
        g.yxI.f(10453, new Object[] { Integer.valueOf(b.this.iCr), Integer.valueOf(3) });
        if (b.this.iCt != null) {
          b.this.iCt.aOF();
        }
        AppMethodBeat.o(148632);
      }
      
      public final void aOC()
      {
        AppMethodBeat.i(148633);
        ae.d("MicroMsg.VoiceSearchViewHelper", "on voice search cancel");
        g.yxI.f(10453, new Object[] { Integer.valueOf(b.this.iCr), Integer.valueOf(4) });
        if (b.this.Lhj != null)
        {
          b.this.Lhj.setEditTextEnabled(true);
          b.this.Lhj.setStatusBtnEnabled(true);
        }
        AppMethodBeat.o(148633);
      }
    };
    AppMethodBeat.o(148636);
  }
  
  public final void a(Activity paramActivity, Menu paramMenu)
  {
    AppMethodBeat.i(148641);
    super.a(paramActivity, paramMenu);
    if (this.iCu != null) {
      this.iCu.setOnSearchListener(this.iCv);
    }
    AppMethodBeat.o(148641);
  }
  
  public final void a(a parama)
  {
    this.iCt = parama;
    this.Lhk = parama;
  }
  
  public final boolean aOD()
  {
    boolean bool1 = false;
    AppMethodBeat.i(148639);
    boolean bool2 = this.iCq;
    if (this.iCu == null) {
      bool1 = true;
    }
    ae.d("MicroMsg.VoiceSearchViewHelper", "check has voice search, Enable %B, layout is null ? %B", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    bool1 = this.iCq;
    AppMethodBeat.o(148639);
    return bool1;
  }
  
  public final void aOE()
  {
    AppMethodBeat.i(148640);
    ae.d("MicroMsg.VoiceSearchViewHelper", "do require voice search");
    if (this.Lhj != null)
    {
      this.Lhj.setEditTextEnabled(false);
      this.Lhj.setStatusBtnEnabled(false);
    }
    if ((this.iCu != null) && (this.iCu.getVisibility() == 8))
    {
      ae.d("MicroMsg.VoiceSearchViewHelper", "do voice search layout start");
      Object localObject = this.iCu;
      int i = this.iCs;
      boolean bool = com.tencent.mm.pluginsdk.permission.b.n(((VoiceSearchLayout)localObject).getContext(), "android.permission.RECORD_AUDIO");
      ae.i("MicroMsg.VoiceSearchLayout", "summerper checkPermission checkMicrophone[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        ae.d("MicroMsg.VoiceSearchLayout", "doStart " + ((VoiceSearchLayout)localObject).isStart);
        ((VoiceSearchLayout)localObject).iCb = i;
        ((VoiceSearchLayout)localObject).isStart = true;
        ((VoiceSearchLayout)localObject).iCa = false;
        if (((VoiceSearchLayout)localObject).iBY != null) {
          ((VoiceSearchLayout)localObject).iBY.aOB();
        }
        ((VoiceSearchLayout)localObject).setVisibility(0);
        ((VoiceSearchLayout)localObject).iCn.ay(50L, 50L);
        ((VoiceSearchLayout)localObject).fg(true);
        ((VoiceSearchLayout)localObject).iCm = 0;
        ((VoiceSearchLayout)localObject).iCf = new f(new VoiceSearchLayout.4((VoiceSearchLayout)localObject), i);
        localObject = ((VoiceSearchLayout)localObject).iCf;
        ae.i("MicroMsg.SceneVoiceAddr", "start record");
        if ((((f)localObject).iAK == 0) && (az.is2G(ak.getContext()))) {}
        for (bool = true;; bool = false)
        {
          ((f)localObject).iAU = bool;
          ae.i("MicroMsg.SceneVoiceAddr", "mEnableAmrMode: %b", new Object[] { Boolean.valueOf(((f)localObject).iAU) });
          com.tencent.mm.sdk.g.b.c(new f.a((f)localObject), "SceneVoiceAddr_record");
          AppMethodBeat.o(148640);
          return;
        }
      }
      if ((((VoiceSearchLayout)localObject).getContext() instanceof Activity)) {
        com.tencent.mm.pluginsdk.permission.b.b((Activity)((VoiceSearchLayout)localObject).getContext(), "android.permission.RECORD_AUDIO", 80);
      }
      AppMethodBeat.o(148640);
      return;
    }
    AppMethodBeat.o(148640);
  }
  
  public final void c(Menu paramMenu)
  {
    AppMethodBeat.i(148643);
    cancel();
    AppMethodBeat.o(148643);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(148637);
    ae.d("MicroMsg.VoiceSearchViewHelper", "do cancel");
    if (this.iCu != null) {
      this.iCu.aOx();
    }
    if (this.Lhj != null)
    {
      this.Lhj.setEditTextEnabled(true);
      this.Lhj.setStatusBtnEnabled(true);
    }
    AppMethodBeat.o(148637);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(148642);
    if (4 == paramInt)
    {
      if ((this.iCu != null) && (this.iCu.getVisibility() == 0)) {}
      for (bool = true;; bool = false)
      {
        ae.d("MicroMsg.VoiceSearchViewHelper", "on back key down, try hide voice search panel, it is visiable[%B]", new Object[] { Boolean.valueOf(bool) });
        cancel();
        if (!bool) {
          break;
        }
        AppMethodBeat.o(148642);
        return true;
      }
    }
    ae.d("MicroMsg.VoiceSearchViewHelper", "not match key code, pass to super");
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(148642);
    return bool;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(148638);
    fOV();
    cancel();
    AppMethodBeat.o(148638);
  }
  
  public static abstract interface a
    extends r.b
  {
    public abstract void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong, int paramInt);
    
    public abstract void aOF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.ui.b
 * JD-Core Version:    0.7.0.1
 */