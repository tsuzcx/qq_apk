package com.tencent.mm.modelvoiceaddr.ui;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.f;
import com.tencent.mm.modelvoiceaddr.f.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.r.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.ui.tools.d;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.tools.r.b;

public final class b
  extends r
{
  public boolean igd;
  public int ige;
  public int igf;
  a igg;
  public VoiceSearchLayout igh;
  private VoiceSearchLayout.a igi;
  
  public b()
  {
    AppMethodBeat.i(148635);
    this.igd = true;
    this.igi = new VoiceSearchLayout.a()
    {
      public final void a(boolean paramAnonymousBoolean, String[] paramAnonymousArrayOfString, long paramAnonymousLong)
      {
        AppMethodBeat.i(148634);
        ac.d("MicroMsg.VoiceSearchViewHelper", "on voice search return, success %B, voice id %d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Long.valueOf(paramAnonymousLong) });
        if (b.this.igg != null) {
          b.this.igg.a(paramAnonymousBoolean, paramAnonymousArrayOfString, paramAnonymousLong, b.this.igf);
        }
        AppMethodBeat.o(148634);
      }
      
      public final void aKU()
      {
        AppMethodBeat.i(148632);
        if ((a.ci(ai.getContext())) || (a.cf(ai.getContext())) || (a.ck(ai.getContext())))
        {
          AppMethodBeat.o(148632);
          return;
        }
        ac.d("MicroMsg.VoiceSearchViewHelper", "on voice search start");
        h.wUl.f(10453, new Object[] { Integer.valueOf(b.this.ige), Integer.valueOf(3) });
        if (b.this.igg != null) {
          b.this.igg.aKY();
        }
        AppMethodBeat.o(148632);
      }
      
      public final void aKV()
      {
        AppMethodBeat.i(148633);
        ac.d("MicroMsg.VoiceSearchViewHelper", "on voice search cancel");
        h.wUl.f(10453, new Object[] { Integer.valueOf(b.this.ige), Integer.valueOf(4) });
        if (b.this.ITL != null)
        {
          b.this.ITL.setEditTextEnabled(true);
          b.this.ITL.setStatusBtnEnabled(true);
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
    this.igd = true;
    this.igi = new VoiceSearchLayout.a()
    {
      public final void a(boolean paramAnonymousBoolean, String[] paramAnonymousArrayOfString, long paramAnonymousLong)
      {
        AppMethodBeat.i(148634);
        ac.d("MicroMsg.VoiceSearchViewHelper", "on voice search return, success %B, voice id %d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Long.valueOf(paramAnonymousLong) });
        if (b.this.igg != null) {
          b.this.igg.a(paramAnonymousBoolean, paramAnonymousArrayOfString, paramAnonymousLong, b.this.igf);
        }
        AppMethodBeat.o(148634);
      }
      
      public final void aKU()
      {
        AppMethodBeat.i(148632);
        if ((a.ci(ai.getContext())) || (a.cf(ai.getContext())) || (a.ck(ai.getContext())))
        {
          AppMethodBeat.o(148632);
          return;
        }
        ac.d("MicroMsg.VoiceSearchViewHelper", "on voice search start");
        h.wUl.f(10453, new Object[] { Integer.valueOf(b.this.ige), Integer.valueOf(3) });
        if (b.this.igg != null) {
          b.this.igg.aKY();
        }
        AppMethodBeat.o(148632);
      }
      
      public final void aKV()
      {
        AppMethodBeat.i(148633);
        ac.d("MicroMsg.VoiceSearchViewHelper", "on voice search cancel");
        h.wUl.f(10453, new Object[] { Integer.valueOf(b.this.ige), Integer.valueOf(4) });
        if (b.this.ITL != null)
        {
          b.this.ITL.setEditTextEnabled(true);
          b.this.ITL.setStatusBtnEnabled(true);
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
    if (this.igh != null) {
      this.igh.setOnSearchListener(this.igi);
    }
    AppMethodBeat.o(148641);
  }
  
  public final void a(a parama)
  {
    this.igg = parama;
    this.ITM = parama;
  }
  
  public final boolean aKW()
  {
    boolean bool1 = false;
    AppMethodBeat.i(148639);
    boolean bool2 = this.igd;
    if (this.igh == null) {
      bool1 = true;
    }
    ac.d("MicroMsg.VoiceSearchViewHelper", "check has voice search, Enable %B, layout is null ? %B", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    bool1 = this.igd;
    AppMethodBeat.o(148639);
    return bool1;
  }
  
  public final void aKX()
  {
    AppMethodBeat.i(148640);
    ac.d("MicroMsg.VoiceSearchViewHelper", "do require voice search");
    if (this.ITL != null)
    {
      this.ITL.setEditTextEnabled(false);
      this.ITL.setStatusBtnEnabled(false);
    }
    if ((this.igh != null) && (this.igh.getVisibility() == 8))
    {
      ac.d("MicroMsg.VoiceSearchViewHelper", "do voice search layout start");
      Object localObject = this.igh;
      int i = this.igf;
      boolean bool = com.tencent.mm.pluginsdk.permission.b.o(((VoiceSearchLayout)localObject).getContext(), "android.permission.RECORD_AUDIO");
      ac.i("MicroMsg.VoiceSearchLayout", "summerper checkPermission checkMicrophone[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        ac.d("MicroMsg.VoiceSearchLayout", "doStart " + ((VoiceSearchLayout)localObject).isStart);
        ((VoiceSearchLayout)localObject).ifO = i;
        ((VoiceSearchLayout)localObject).isStart = true;
        ((VoiceSearchLayout)localObject).ifN = false;
        if (((VoiceSearchLayout)localObject).ifL != null) {
          ((VoiceSearchLayout)localObject).ifL.aKU();
        }
        ((VoiceSearchLayout)localObject).setVisibility(0);
        ((VoiceSearchLayout)localObject).iga.au(50L, 50L);
        ((VoiceSearchLayout)localObject).fb(true);
        ((VoiceSearchLayout)localObject).ifZ = 0;
        ((VoiceSearchLayout)localObject).ifS = new f(new VoiceSearchLayout.4((VoiceSearchLayout)localObject), i);
        localObject = ((VoiceSearchLayout)localObject).ifS;
        ac.i("MicroMsg.SceneVoiceAddr", "start record");
        if ((((f)localObject).iex == 0) && (ax.is2G(ai.getContext()))) {}
        for (bool = true;; bool = false)
        {
          ((f)localObject).ieH = bool;
          ac.i("MicroMsg.SceneVoiceAddr", "mEnableAmrMode: %b", new Object[] { Boolean.valueOf(((f)localObject).ieH) });
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
    ac.d("MicroMsg.VoiceSearchViewHelper", "do cancel");
    if (this.igh != null) {
      this.igh.aKQ();
    }
    if (this.ITL != null)
    {
      this.ITL.setEditTextEnabled(true);
      this.ITL.setStatusBtnEnabled(true);
    }
    AppMethodBeat.o(148637);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(148642);
    if (4 == paramInt)
    {
      if ((this.igh != null) && (this.igh.getVisibility() == 0)) {}
      for (bool = true;; bool = false)
      {
        ac.d("MicroMsg.VoiceSearchViewHelper", "on back key down, try hide voice search panel, it is visiable[%B]", new Object[] { Boolean.valueOf(bool) });
        cancel();
        if (!bool) {
          break;
        }
        AppMethodBeat.o(148642);
        return true;
      }
    }
    ac.d("MicroMsg.VoiceSearchViewHelper", "not match key code, pass to super");
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(148642);
    return bool;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(148638);
    ftR();
    cancel();
    AppMethodBeat.o(148638);
  }
  
  public static abstract interface a
    extends r.b
  {
    public abstract void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong, int paramInt);
    
    public abstract void aKY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.ui.b
 * JD-Core Version:    0.7.0.1
 */