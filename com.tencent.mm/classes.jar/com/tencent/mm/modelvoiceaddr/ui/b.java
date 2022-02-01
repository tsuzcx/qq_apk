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
import com.tencent.mm.ui.tools.d;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.ui.tools.s.b;

public final class b
  extends s
{
  public boolean jxF;
  public int jxG;
  public int jxH;
  a jxI;
  public VoiceSearchLayout jxJ;
  private VoiceSearchLayout.a jxK;
  
  public b()
  {
    AppMethodBeat.i(148635);
    this.jxF = true;
    this.jxK = new VoiceSearchLayout.a()
    {
      public final void a(boolean paramAnonymousBoolean, String[] paramAnonymousArrayOfString, long paramAnonymousLong)
      {
        AppMethodBeat.i(148634);
        Log.d("MicroMsg.VoiceSearchViewHelper", "on voice search return, success %B, voice id %d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Long.valueOf(paramAnonymousLong) });
        if (b.this.jxI != null) {
          b.this.jxI.a(paramAnonymousBoolean, paramAnonymousArrayOfString, paramAnonymousLong, b.this.jxH);
        }
        AppMethodBeat.o(148634);
      }
      
      public final void biI()
      {
        AppMethodBeat.i(148632);
        if ((a.cC(MMApplicationContext.getContext())) || (a.cA(MMApplicationContext.getContext())) || (a.cE(MMApplicationContext.getContext())))
        {
          AppMethodBeat.o(148632);
          return;
        }
        Log.d("MicroMsg.VoiceSearchViewHelper", "on voice search start");
        h.CyF.a(10453, new Object[] { Integer.valueOf(b.this.jxG), Integer.valueOf(3) });
        if (b.this.jxI != null) {
          b.this.jxI.biM();
        }
        AppMethodBeat.o(148632);
      }
      
      public final void biJ()
      {
        AppMethodBeat.i(148633);
        Log.d("MicroMsg.VoiceSearchViewHelper", "on voice search cancel");
        h.CyF.a(10453, new Object[] { Integer.valueOf(b.this.jxG), Integer.valueOf(4) });
        if (b.this.Qwh != null)
        {
          b.this.Qwh.setEditTextEnabled(true);
          b.this.Qwh.setStatusBtnEnabled(true);
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
    this.jxF = true;
    this.jxK = new VoiceSearchLayout.a()
    {
      public final void a(boolean paramAnonymousBoolean, String[] paramAnonymousArrayOfString, long paramAnonymousLong)
      {
        AppMethodBeat.i(148634);
        Log.d("MicroMsg.VoiceSearchViewHelper", "on voice search return, success %B, voice id %d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Long.valueOf(paramAnonymousLong) });
        if (b.this.jxI != null) {
          b.this.jxI.a(paramAnonymousBoolean, paramAnonymousArrayOfString, paramAnonymousLong, b.this.jxH);
        }
        AppMethodBeat.o(148634);
      }
      
      public final void biI()
      {
        AppMethodBeat.i(148632);
        if ((a.cC(MMApplicationContext.getContext())) || (a.cA(MMApplicationContext.getContext())) || (a.cE(MMApplicationContext.getContext())))
        {
          AppMethodBeat.o(148632);
          return;
        }
        Log.d("MicroMsg.VoiceSearchViewHelper", "on voice search start");
        h.CyF.a(10453, new Object[] { Integer.valueOf(b.this.jxG), Integer.valueOf(3) });
        if (b.this.jxI != null) {
          b.this.jxI.biM();
        }
        AppMethodBeat.o(148632);
      }
      
      public final void biJ()
      {
        AppMethodBeat.i(148633);
        Log.d("MicroMsg.VoiceSearchViewHelper", "on voice search cancel");
        h.CyF.a(10453, new Object[] { Integer.valueOf(b.this.jxG), Integer.valueOf(4) });
        if (b.this.Qwh != null)
        {
          b.this.Qwh.setEditTextEnabled(true);
          b.this.Qwh.setStatusBtnEnabled(true);
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
    if (this.jxJ != null) {
      this.jxJ.setOnSearchListener(this.jxK);
    }
    AppMethodBeat.o(148641);
  }
  
  public final void a(a parama)
  {
    this.jxI = parama;
    this.Qwi = parama;
  }
  
  public final boolean biK()
  {
    boolean bool1 = false;
    AppMethodBeat.i(148639);
    boolean bool2 = this.jxF;
    if (this.jxJ == null) {
      bool1 = true;
    }
    Log.d("MicroMsg.VoiceSearchViewHelper", "check has voice search, Enable %B, layout is null ? %B", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    bool1 = this.jxF;
    AppMethodBeat.o(148639);
    return bool1;
  }
  
  public final void biL()
  {
    AppMethodBeat.i(148640);
    Log.d("MicroMsg.VoiceSearchViewHelper", "do require voice search");
    if (this.Qwh != null)
    {
      this.Qwh.setEditTextEnabled(false);
      this.Qwh.setStatusBtnEnabled(false);
    }
    if ((this.jxJ != null) && (this.jxJ.getVisibility() == 8))
    {
      Log.d("MicroMsg.VoiceSearchViewHelper", "do voice search layout start");
      Object localObject = this.jxJ;
      int i = this.jxH;
      boolean bool = com.tencent.mm.pluginsdk.permission.b.n(((VoiceSearchLayout)localObject).getContext(), "android.permission.RECORD_AUDIO");
      Log.i("MicroMsg.VoiceSearchLayout", "summerper checkPermission checkMicrophone[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        Log.d("MicroMsg.VoiceSearchLayout", "doStart " + ((VoiceSearchLayout)localObject).isStart);
        ((VoiceSearchLayout)localObject).jxq = i;
        ((VoiceSearchLayout)localObject).isStart = true;
        ((VoiceSearchLayout)localObject).jxp = false;
        if (((VoiceSearchLayout)localObject).jxn != null) {
          ((VoiceSearchLayout)localObject).jxn.biI();
        }
        ((VoiceSearchLayout)localObject).setVisibility(0);
        ((VoiceSearchLayout)localObject).jxC.startTimer(50L);
        ((VoiceSearchLayout)localObject).fW(true);
        ((VoiceSearchLayout)localObject).jxB = 0;
        ((VoiceSearchLayout)localObject).jxu = new f(new VoiceSearchLayout.4((VoiceSearchLayout)localObject), i);
        localObject = ((VoiceSearchLayout)localObject).jxu;
        Log.i("MicroMsg.SceneVoiceAddr", "start record");
        if ((((f)localObject).jvZ == 0) && (NetStatusUtil.is2G(MMApplicationContext.getContext()))) {}
        for (bool = true;; bool = false)
        {
          ((f)localObject).jwj = bool;
          Log.i("MicroMsg.SceneVoiceAddr", "mEnableAmrMode: %b", new Object[] { Boolean.valueOf(((f)localObject).jwj) });
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
    if (this.jxJ != null) {
      this.jxJ.biE();
    }
    if (this.Qwh != null)
    {
      this.Qwh.setEditTextEnabled(true);
      this.Qwh.setStatusBtnEnabled(true);
    }
    AppMethodBeat.o(148637);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(148642);
    if (4 == paramInt)
    {
      if ((this.jxJ != null) && (this.jxJ.getVisibility() == 0)) {}
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
    gXP();
    cancel();
    AppMethodBeat.o(148638);
  }
  
  public static abstract interface a
    extends s.b
  {
    public abstract void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong, int paramInt);
    
    public abstract void biM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.ui.b
 * JD-Core Version:    0.7.0.1
 */