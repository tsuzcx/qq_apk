package com.tencent.mm.modelvoiceaddr.ui;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.f;
import com.tencent.mm.modelvoiceaddr.f.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.r.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.ui.tools.d;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.tools.r.b;

public final class b
  extends r
{
  public boolean hFB;
  public int hFC;
  public int hFD;
  a hFE;
  public VoiceSearchLayout hFF;
  private VoiceSearchLayout.a hFG;
  
  public b()
  {
    AppMethodBeat.i(148635);
    this.hFB = true;
    this.hFG = new VoiceSearchLayout.a()
    {
      public final void a(boolean paramAnonymousBoolean, String[] paramAnonymousArrayOfString, long paramAnonymousLong)
      {
        AppMethodBeat.i(148634);
        ad.d("MicroMsg.VoiceSearchViewHelper", "on voice search return, success %B, voice id %d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Long.valueOf(paramAnonymousLong) });
        if (b.this.hFE != null) {
          b.this.hFE.a(paramAnonymousBoolean, paramAnonymousArrayOfString, paramAnonymousLong, b.this.hFD);
        }
        AppMethodBeat.o(148634);
      }
      
      public final void aEd()
      {
        AppMethodBeat.i(148632);
        if ((a.ce(aj.getContext())) || (a.cc(aj.getContext())))
        {
          AppMethodBeat.o(148632);
          return;
        }
        ad.d("MicroMsg.VoiceSearchViewHelper", "on voice search start");
        h.vKh.f(10453, new Object[] { Integer.valueOf(b.this.hFC), Integer.valueOf(3) });
        if (b.this.hFE != null) {
          b.this.hFE.aEh();
        }
        AppMethodBeat.o(148632);
      }
      
      public final void aEe()
      {
        AppMethodBeat.i(148633);
        ad.d("MicroMsg.VoiceSearchViewHelper", "on voice search cancel");
        h.vKh.f(10453, new Object[] { Integer.valueOf(b.this.hFC), Integer.valueOf(4) });
        if (b.this.Hto != null)
        {
          b.this.Hto.setEditTextEnabled(true);
          b.this.Hto.setStatusBtnEnabled(true);
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
    this.hFB = true;
    this.hFG = new VoiceSearchLayout.a()
    {
      public final void a(boolean paramAnonymousBoolean, String[] paramAnonymousArrayOfString, long paramAnonymousLong)
      {
        AppMethodBeat.i(148634);
        ad.d("MicroMsg.VoiceSearchViewHelper", "on voice search return, success %B, voice id %d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Long.valueOf(paramAnonymousLong) });
        if (b.this.hFE != null) {
          b.this.hFE.a(paramAnonymousBoolean, paramAnonymousArrayOfString, paramAnonymousLong, b.this.hFD);
        }
        AppMethodBeat.o(148634);
      }
      
      public final void aEd()
      {
        AppMethodBeat.i(148632);
        if ((a.ce(aj.getContext())) || (a.cc(aj.getContext())))
        {
          AppMethodBeat.o(148632);
          return;
        }
        ad.d("MicroMsg.VoiceSearchViewHelper", "on voice search start");
        h.vKh.f(10453, new Object[] { Integer.valueOf(b.this.hFC), Integer.valueOf(3) });
        if (b.this.hFE != null) {
          b.this.hFE.aEh();
        }
        AppMethodBeat.o(148632);
      }
      
      public final void aEe()
      {
        AppMethodBeat.i(148633);
        ad.d("MicroMsg.VoiceSearchViewHelper", "on voice search cancel");
        h.vKh.f(10453, new Object[] { Integer.valueOf(b.this.hFC), Integer.valueOf(4) });
        if (b.this.Hto != null)
        {
          b.this.Hto.setEditTextEnabled(true);
          b.this.Hto.setStatusBtnEnabled(true);
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
    if (this.hFF != null) {
      this.hFF.setOnSearchListener(this.hFG);
    }
    AppMethodBeat.o(148641);
  }
  
  public final void a(a parama)
  {
    this.hFE = parama;
    this.Htp = parama;
  }
  
  public final boolean aEf()
  {
    boolean bool1 = false;
    AppMethodBeat.i(148639);
    boolean bool2 = this.hFB;
    if (this.hFF == null) {
      bool1 = true;
    }
    ad.d("MicroMsg.VoiceSearchViewHelper", "check has voice search, Enable %B, layout is null ? %B", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    bool1 = this.hFB;
    AppMethodBeat.o(148639);
    return bool1;
  }
  
  public final void aEg()
  {
    AppMethodBeat.i(148640);
    ad.d("MicroMsg.VoiceSearchViewHelper", "do require voice search");
    if (this.Hto != null)
    {
      this.Hto.setEditTextEnabled(false);
      this.Hto.setStatusBtnEnabled(false);
    }
    if ((this.hFF != null) && (this.hFF.getVisibility() == 8))
    {
      ad.d("MicroMsg.VoiceSearchViewHelper", "do voice search layout start");
      Object localObject = this.hFF;
      int i = this.hFD;
      boolean bool = com.tencent.mm.pluginsdk.permission.b.o(((VoiceSearchLayout)localObject).getContext(), "android.permission.RECORD_AUDIO");
      ad.i("MicroMsg.VoiceSearchLayout", "summerper checkPermission checkMicrophone[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        ad.d("MicroMsg.VoiceSearchLayout", "doStart " + ((VoiceSearchLayout)localObject).isStart);
        ((VoiceSearchLayout)localObject).hFm = i;
        ((VoiceSearchLayout)localObject).isStart = true;
        ((VoiceSearchLayout)localObject).hFl = false;
        if (((VoiceSearchLayout)localObject).hFj != null) {
          ((VoiceSearchLayout)localObject).hFj.aEd();
        }
        ((VoiceSearchLayout)localObject).setVisibility(0);
        ((VoiceSearchLayout)localObject).hFy.av(50L, 50L);
        ((VoiceSearchLayout)localObject).eH(true);
        ((VoiceSearchLayout)localObject).hFx = 0;
        ((VoiceSearchLayout)localObject).hFq = new f(new VoiceSearchLayout.4((VoiceSearchLayout)localObject), i);
        localObject = ((VoiceSearchLayout)localObject).hFq;
        ad.i("MicroMsg.SceneVoiceAddr", "start record");
        if ((((f)localObject).hDV == 0) && (ay.is2G(aj.getContext()))) {}
        for (bool = true;; bool = false)
        {
          ((f)localObject).hEf = bool;
          ad.i("MicroMsg.SceneVoiceAddr", "mEnableAmrMode: %b", new Object[] { Boolean.valueOf(((f)localObject).hEf) });
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
    ad.d("MicroMsg.VoiceSearchViewHelper", "do cancel");
    if (this.hFF != null) {
      this.hFF.aDZ();
    }
    if (this.Hto != null)
    {
      this.Hto.setEditTextEnabled(true);
      this.Hto.setStatusBtnEnabled(true);
    }
    AppMethodBeat.o(148637);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(148642);
    if (4 == paramInt)
    {
      if ((this.hFF != null) && (this.hFF.getVisibility() == 0)) {}
      for (bool = true;; bool = false)
      {
        ad.d("MicroMsg.VoiceSearchViewHelper", "on back key down, try hide voice search panel, it is visiable[%B]", new Object[] { Boolean.valueOf(bool) });
        cancel();
        if (!bool) {
          break;
        }
        AppMethodBeat.o(148642);
        return true;
      }
    }
    ad.d("MicroMsg.VoiceSearchViewHelper", "not match key code, pass to super");
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(148642);
    return bool;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(148638);
    fdW();
    cancel();
    AppMethodBeat.o(148638);
  }
  
  public static abstract interface a
    extends r.b
  {
    public abstract void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong, int paramInt);
    
    public abstract void aEh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.ui.b
 * JD-Core Version:    0.7.0.1
 */