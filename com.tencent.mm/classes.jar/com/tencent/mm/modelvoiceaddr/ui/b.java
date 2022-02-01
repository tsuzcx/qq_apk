package com.tencent.mm.modelvoiceaddr.ui;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.f;
import com.tencent.mm.modelvoiceaddr.f.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.s.a;
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
  a izA;
  public VoiceSearchLayout izB;
  private VoiceSearchLayout.a izC;
  public boolean izx;
  public int izy;
  public int izz;
  
  public b()
  {
    AppMethodBeat.i(148635);
    this.izx = true;
    this.izC = new VoiceSearchLayout.a()
    {
      public final void a(boolean paramAnonymousBoolean, String[] paramAnonymousArrayOfString, long paramAnonymousLong)
      {
        AppMethodBeat.i(148634);
        ad.d("MicroMsg.VoiceSearchViewHelper", "on voice search return, success %B, voice id %d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Long.valueOf(paramAnonymousLong) });
        if (b.this.izA != null) {
          b.this.izA.a(paramAnonymousBoolean, paramAnonymousArrayOfString, paramAnonymousLong, b.this.izz);
        }
        AppMethodBeat.o(148634);
      }
      
      public final void aOd()
      {
        AppMethodBeat.i(148632);
        if ((a.cf(aj.getContext())) || (a.cd(aj.getContext())) || (a.ch(aj.getContext())))
        {
          AppMethodBeat.o(148632);
          return;
        }
        ad.d("MicroMsg.VoiceSearchViewHelper", "on voice search start");
        g.yhR.f(10453, new Object[] { Integer.valueOf(b.this.izy), Integer.valueOf(3) });
        if (b.this.izA != null) {
          b.this.izA.aOh();
        }
        AppMethodBeat.o(148632);
      }
      
      public final void aOe()
      {
        AppMethodBeat.i(148633);
        ad.d("MicroMsg.VoiceSearchViewHelper", "on voice search cancel");
        g.yhR.f(10453, new Object[] { Integer.valueOf(b.this.izy), Integer.valueOf(4) });
        if (b.this.KKP != null)
        {
          b.this.KKP.setEditTextEnabled(true);
          b.this.KKP.setStatusBtnEnabled(true);
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
    this.izx = true;
    this.izC = new VoiceSearchLayout.a()
    {
      public final void a(boolean paramAnonymousBoolean, String[] paramAnonymousArrayOfString, long paramAnonymousLong)
      {
        AppMethodBeat.i(148634);
        ad.d("MicroMsg.VoiceSearchViewHelper", "on voice search return, success %B, voice id %d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Long.valueOf(paramAnonymousLong) });
        if (b.this.izA != null) {
          b.this.izA.a(paramAnonymousBoolean, paramAnonymousArrayOfString, paramAnonymousLong, b.this.izz);
        }
        AppMethodBeat.o(148634);
      }
      
      public final void aOd()
      {
        AppMethodBeat.i(148632);
        if ((a.cf(aj.getContext())) || (a.cd(aj.getContext())) || (a.ch(aj.getContext())))
        {
          AppMethodBeat.o(148632);
          return;
        }
        ad.d("MicroMsg.VoiceSearchViewHelper", "on voice search start");
        g.yhR.f(10453, new Object[] { Integer.valueOf(b.this.izy), Integer.valueOf(3) });
        if (b.this.izA != null) {
          b.this.izA.aOh();
        }
        AppMethodBeat.o(148632);
      }
      
      public final void aOe()
      {
        AppMethodBeat.i(148633);
        ad.d("MicroMsg.VoiceSearchViewHelper", "on voice search cancel");
        g.yhR.f(10453, new Object[] { Integer.valueOf(b.this.izy), Integer.valueOf(4) });
        if (b.this.KKP != null)
        {
          b.this.KKP.setEditTextEnabled(true);
          b.this.KKP.setStatusBtnEnabled(true);
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
    if (this.izB != null) {
      this.izB.setOnSearchListener(this.izC);
    }
    AppMethodBeat.o(148641);
  }
  
  public final void a(a parama)
  {
    this.izA = parama;
    this.KKQ = parama;
  }
  
  public final boolean aOf()
  {
    boolean bool1 = false;
    AppMethodBeat.i(148639);
    boolean bool2 = this.izx;
    if (this.izB == null) {
      bool1 = true;
    }
    ad.d("MicroMsg.VoiceSearchViewHelper", "check has voice search, Enable %B, layout is null ? %B", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    bool1 = this.izx;
    AppMethodBeat.o(148639);
    return bool1;
  }
  
  public final void aOg()
  {
    AppMethodBeat.i(148640);
    ad.d("MicroMsg.VoiceSearchViewHelper", "do require voice search");
    if (this.KKP != null)
    {
      this.KKP.setEditTextEnabled(false);
      this.KKP.setStatusBtnEnabled(false);
    }
    if ((this.izB != null) && (this.izB.getVisibility() == 8))
    {
      ad.d("MicroMsg.VoiceSearchViewHelper", "do voice search layout start");
      Object localObject = this.izB;
      int i = this.izz;
      boolean bool = com.tencent.mm.pluginsdk.permission.b.n(((VoiceSearchLayout)localObject).getContext(), "android.permission.RECORD_AUDIO");
      ad.i("MicroMsg.VoiceSearchLayout", "summerper checkPermission checkMicrophone[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        ad.d("MicroMsg.VoiceSearchLayout", "doStart " + ((VoiceSearchLayout)localObject).isStart);
        ((VoiceSearchLayout)localObject).izi = i;
        ((VoiceSearchLayout)localObject).isStart = true;
        ((VoiceSearchLayout)localObject).izh = false;
        if (((VoiceSearchLayout)localObject).izf != null) {
          ((VoiceSearchLayout)localObject).izf.aOd();
        }
        ((VoiceSearchLayout)localObject).setVisibility(0);
        ((VoiceSearchLayout)localObject).izu.az(50L, 50L);
        ((VoiceSearchLayout)localObject).fd(true);
        ((VoiceSearchLayout)localObject).izt = 0;
        ((VoiceSearchLayout)localObject).izm = new f(new VoiceSearchLayout.4((VoiceSearchLayout)localObject), i);
        localObject = ((VoiceSearchLayout)localObject).izm;
        ad.i("MicroMsg.SceneVoiceAddr", "start record");
        if ((((f)localObject).ixR == 0) && (ay.is2G(aj.getContext()))) {}
        for (bool = true;; bool = false)
        {
          ((f)localObject).iyb = bool;
          ad.i("MicroMsg.SceneVoiceAddr", "mEnableAmrMode: %b", new Object[] { Boolean.valueOf(((f)localObject).iyb) });
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
    if (this.izB != null) {
      this.izB.aNZ();
    }
    if (this.KKP != null)
    {
      this.KKP.setEditTextEnabled(true);
      this.KKP.setStatusBtnEnabled(true);
    }
    AppMethodBeat.o(148637);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(148642);
    if (4 == paramInt)
    {
      if ((this.izB != null) && (this.izB.getVisibility() == 0)) {}
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
    fKE();
    cancel();
    AppMethodBeat.o(148638);
  }
  
  public static abstract interface a
    extends r.b
  {
    public abstract void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong, int paramInt);
    
    public abstract void aOh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.ui.b
 * JD-Core Version:    0.7.0.1
 */