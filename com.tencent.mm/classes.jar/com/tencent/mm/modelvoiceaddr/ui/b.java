package com.tencent.mm.modelvoiceaddr.ui;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.f;
import com.tencent.mm.modelvoiceaddr.f.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.q.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.tools.e;
import com.tencent.mm.ui.tools.t;
import com.tencent.mm.ui.tools.t.b;

public final class b
  extends t
{
  public boolean mni;
  public int mnj;
  public int mnk;
  private a mnl;
  public VoiceSearchLayout mnm;
  private VoiceSearchLayout.a mnn;
  
  public b()
  {
    AppMethodBeat.i(148635);
    this.mni = true;
    this.mnn = new VoiceSearchLayout.a()
    {
      public final void a(boolean paramAnonymousBoolean, String[] paramAnonymousArrayOfString, long paramAnonymousLong)
      {
        AppMethodBeat.i(148634);
        Log.d("MicroMsg.VoiceSearchViewHelper", "on voice search return, success %B, voice id %d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Long.valueOf(paramAnonymousLong) });
        if (b.b(b.this) != null) {
          b.b(b.this).a(paramAnonymousBoolean, paramAnonymousArrayOfString, paramAnonymousLong, b.f(b.this));
        }
        AppMethodBeat.o(148634);
      }
      
      public final void bsg()
      {
        AppMethodBeat.i(148632);
        if ((a.cy(MMApplicationContext.getContext())) || (a.cw(MMApplicationContext.getContext())) || (a.cB(MMApplicationContext.getContext())))
        {
          AppMethodBeat.o(148632);
          return;
        }
        Log.d("MicroMsg.VoiceSearchViewHelper", "on voice search start");
        h.IzE.a(10453, new Object[] { Integer.valueOf(b.a(b.this)), Integer.valueOf(3) });
        if (b.b(b.this) != null) {
          b.b(b.this).bsk();
        }
        AppMethodBeat.o(148632);
      }
      
      public final void bsh()
      {
        AppMethodBeat.i(148633);
        Log.d("MicroMsg.VoiceSearchViewHelper", "on voice search cancel");
        h.IzE.a(10453, new Object[] { Integer.valueOf(b.a(b.this)), Integer.valueOf(4) });
        if (b.c(b.this) != null)
        {
          b.d(b.this).setEditTextEnabled(true);
          b.e(b.this).setStatusBtnEnabled(true);
        }
        if (b.b(b.this) != null) {
          b.b(b.this);
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
    this.mni = true;
    this.mnn = new VoiceSearchLayout.a()
    {
      public final void a(boolean paramAnonymousBoolean, String[] paramAnonymousArrayOfString, long paramAnonymousLong)
      {
        AppMethodBeat.i(148634);
        Log.d("MicroMsg.VoiceSearchViewHelper", "on voice search return, success %B, voice id %d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Long.valueOf(paramAnonymousLong) });
        if (b.b(b.this) != null) {
          b.b(b.this).a(paramAnonymousBoolean, paramAnonymousArrayOfString, paramAnonymousLong, b.f(b.this));
        }
        AppMethodBeat.o(148634);
      }
      
      public final void bsg()
      {
        AppMethodBeat.i(148632);
        if ((a.cy(MMApplicationContext.getContext())) || (a.cw(MMApplicationContext.getContext())) || (a.cB(MMApplicationContext.getContext())))
        {
          AppMethodBeat.o(148632);
          return;
        }
        Log.d("MicroMsg.VoiceSearchViewHelper", "on voice search start");
        h.IzE.a(10453, new Object[] { Integer.valueOf(b.a(b.this)), Integer.valueOf(3) });
        if (b.b(b.this) != null) {
          b.b(b.this).bsk();
        }
        AppMethodBeat.o(148632);
      }
      
      public final void bsh()
      {
        AppMethodBeat.i(148633);
        Log.d("MicroMsg.VoiceSearchViewHelper", "on voice search cancel");
        h.IzE.a(10453, new Object[] { Integer.valueOf(b.a(b.this)), Integer.valueOf(4) });
        if (b.c(b.this) != null)
        {
          b.d(b.this).setEditTextEnabled(true);
          b.e(b.this).setStatusBtnEnabled(true);
        }
        if (b.b(b.this) != null) {
          b.b(b.this);
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
    if (this.mnm != null) {
      this.mnm.setOnSearchListener(this.mnn);
    }
    AppMethodBeat.o(148641);
  }
  
  public final void a(a parama)
  {
    this.mnl = parama;
    this.XUl = parama;
  }
  
  public final boolean bsi()
  {
    boolean bool1 = false;
    AppMethodBeat.i(148639);
    boolean bool2 = this.mni;
    if (this.mnm == null) {
      bool1 = true;
    }
    Log.d("MicroMsg.VoiceSearchViewHelper", "check has voice search, Enable %B, layout is null ? %B", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    bool1 = this.mni;
    AppMethodBeat.o(148639);
    return bool1;
  }
  
  public final void bsj()
  {
    AppMethodBeat.i(148640);
    Log.d("MicroMsg.VoiceSearchViewHelper", "do require voice search");
    if (this.XUk != null)
    {
      this.XUk.setEditTextEnabled(false);
      this.XUk.setStatusBtnEnabled(false);
    }
    if ((this.mnm != null) && (this.mnm.getVisibility() == 8))
    {
      Log.d("MicroMsg.VoiceSearchViewHelper", "do voice search layout start");
      Object localObject = this.mnm;
      int i = this.mnk;
      boolean bool = com.tencent.mm.pluginsdk.permission.b.o(((VoiceSearchLayout)localObject).getContext(), "android.permission.RECORD_AUDIO");
      Log.i("MicroMsg.VoiceSearchLayout", "summerper checkPermission checkMicrophone[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        Log.d("MicroMsg.VoiceSearchLayout", "doStart " + ((VoiceSearchLayout)localObject).isStart);
        ((VoiceSearchLayout)localObject).mmS = i;
        ((VoiceSearchLayout)localObject).isStart = true;
        ((VoiceSearchLayout)localObject).mmR = false;
        if (((VoiceSearchLayout)localObject).mmP != null) {
          ((VoiceSearchLayout)localObject).mmP.bsg();
        }
        ((VoiceSearchLayout)localObject).setVisibility(0);
        ((VoiceSearchLayout)localObject).mnf.startTimer(50L);
        ((VoiceSearchLayout)localObject).gI(true);
        ((VoiceSearchLayout)localObject).mne = 0;
        ((VoiceSearchLayout)localObject).mmW = new f(new VoiceSearchLayout.4((VoiceSearchLayout)localObject), i);
        localObject = ((VoiceSearchLayout)localObject).mmW;
        Log.i("MicroMsg.SceneVoiceAddr", "start record");
        if ((((f)localObject).mlC == 0) && (NetStatusUtil.is2G(MMApplicationContext.getContext()))) {}
        for (bool = true;; bool = false)
        {
          ((f)localObject).mlM = bool;
          Log.i("MicroMsg.SceneVoiceAddr", "mEnableAmrMode: %b", new Object[] { Boolean.valueOf(((f)localObject).mlM) });
          ThreadPool.post(new f.a((f)localObject), "SceneVoiceAddr_record");
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
    Log.d("MicroMsg.VoiceSearchViewHelper", "do cancel");
    if (this.mnm != null) {
      this.mnm.bsc();
    }
    if (this.XUk != null)
    {
      this.XUk.setEditTextEnabled(true);
      this.XUk.setStatusBtnEnabled(true);
    }
    AppMethodBeat.o(148637);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(148642);
    if (4 == paramInt)
    {
      if ((this.mnm != null) && (this.mnm.getVisibility() == 0)) {}
      for (bool = true;; bool = false)
      {
        Log.d("MicroMsg.VoiceSearchViewHelper", "on back key down, try hide voice search panel, it is visiable[%B]", new Object[] { Boolean.valueOf(bool) });
        cancel();
        if (!bool) {
          break;
        }
        AppMethodBeat.o(148642);
        return true;
      }
    }
    Log.d("MicroMsg.VoiceSearchViewHelper", "not match key code, pass to super");
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(148642);
    return bool;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(148638);
    hVb();
    cancel();
    AppMethodBeat.o(148638);
  }
  
  public static abstract interface a
    extends t.b
  {
    public abstract void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong, int paramInt);
    
    public abstract void bsk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.ui.b
 * JD-Core Version:    0.7.0.1
 */