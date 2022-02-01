package com.tencent.mm.plugin.ball.ui;

import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.ball.a.f;
import com.tencent.mm.plugin.ball.a.f.a;
import com.tencent.mm.plugin.ball.view.FloatIndicatorView;
import com.tencent.mm.plugin.ball.view.FloatIndicatorView.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.SwipeBackLayout;

public final class e
{
  private boolean lft;
  public f rZC;
  private com.tencent.mm.plugin.ball.d.e rZD;
  private boolean saA;
  private boolean saB;
  private long saC;
  public FloatIndicatorView sav;
  int saw;
  int sax;
  FrameLayout.LayoutParams say;
  private boolean saz;
  
  public e(f paramf, com.tencent.mm.plugin.ball.d.e parame)
  {
    AppMethodBeat.i(106321);
    this.saC = -1L;
    this.rZC = paramf;
    this.rZD = parame;
    this.sav = new FloatIndicatorView(this.rZC.getActivity());
    this.sav.setOnOrientationChangedListener(new FloatIndicatorView.a()
    {
      public final void lj(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(106316);
        Log.i("MicroMsg.FloatIndicatorController", "onOrientationChanged, isLandscape:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        e.this.li(paramAnonymousBoolean);
        e.this.say.bottomMargin = e.this.sax;
        e.this.say.rightMargin = e.this.saw;
        e.this.sav.setLayoutParams(e.this.say);
        Log.i("MicroMsg.FloatIndicatorController", "onOrientationChanged layoutParams, right:%s, bottom:%s", new Object[] { Integer.valueOf(e.this.say.rightMargin), Integer.valueOf(e.this.say.bottomMargin) });
        AppMethodBeat.o(106316);
      }
    });
    if (a.kr(MMApplicationContext.getContext()) > a.ks(MMApplicationContext.getContext())) {}
    for (boolean bool = true;; bool = false)
    {
      li(bool);
      this.say = new FrameLayout.LayoutParams(-2, -2);
      this.say.gravity = 8388693;
      this.say.bottomMargin = this.sax;
      this.say.rightMargin = this.saw;
      this.sav.setLayoutParams(this.say);
      Log.i("MicroMsg.FloatIndicatorController", "createFloatIndicator layoutParams, right:%s, bottom:%s", new Object[] { Integer.valueOf(this.say.rightMargin), Integer.valueOf(this.say.bottomMargin) });
      AppMethodBeat.o(106321);
      return;
    }
  }
  
  private void bWU()
  {
    AppMethodBeat.i(106323);
    com.tencent.mm.plugin.ball.f.e.eJ(this.rZC.getActivity());
    if (this.lft)
    {
      this.sax = (-com.tencent.mm.plugin.ball.f.e.saQ);
      this.saw = (cwu() - com.tencent.mm.plugin.ball.f.e.saQ);
      AppMethodBeat.o(106323);
      return;
    }
    this.saw = (-com.tencent.mm.plugin.ball.f.e.saQ);
    this.sax = (cwu() - com.tencent.mm.plugin.ball.f.e.saQ);
    AppMethodBeat.o(106323);
  }
  
  private int cwu()
  {
    AppMethodBeat.i(106324);
    if (this.rZC.cuS() >= 0)
    {
      i = this.rZC.cuS();
      AppMethodBeat.o(106324);
      return i;
    }
    int i = com.tencent.mm.plugin.ball.f.e.saV;
    AppMethodBeat.o(106324);
    return i;
  }
  
  private void cwv()
  {
    AppMethodBeat.i(106327);
    if (!this.saA)
    {
      AppMethodBeat.o(106327);
      return;
    }
    if (this.sav != null)
    {
      this.sav.setVisibility(8);
      this.saA = false;
    }
    AppMethodBeat.o(106327);
  }
  
  private void cww()
  {
    AppMethodBeat.i(106328);
    ViewGroup localViewGroup;
    if (this.sav != null)
    {
      this.sav.setVisibility(8);
      localViewGroup = this.rZC.cuR();
    }
    for (;;)
    {
      int i;
      try
      {
        if (this.sav.getParent() == null)
        {
          int k = localViewGroup.getChildCount();
          i = 0;
          int j = k;
          if (i < localViewGroup.getChildCount())
          {
            if (!(localViewGroup.getChildAt(i) instanceof SwipeBackLayout)) {
              break label132;
            }
            j = i + 1;
          }
          localViewGroup.addView(this.sav, j);
          AppMethodBeat.o(106328);
          return;
        }
        Log.w("MicroMsg.FloatIndicatorController", "attachFloatIndicatorView, already attached");
        AppMethodBeat.o(106328);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.FloatIndicatorController", localException, "attachFloatIndicatorView exception:%s", new Object[] { localException });
      }
      AppMethodBeat.o(106328);
      return;
      label132:
      i += 1;
    }
  }
  
  final void li(boolean paramBoolean)
  {
    AppMethodBeat.i(106322);
    Log.i("MicroMsg.FloatIndicatorController", "updateOrientation, isLandscape:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lft = paramBoolean;
    bWU();
    AppMethodBeat.o(106322);
  }
  
  public final void start()
  {
    AppMethodBeat.i(106325);
    Log.i("MicroMsg.FloatIndicatorController", "start FloatIndicatorController");
    cwv();
    this.saC = -1L;
    this.saz = false;
    this.saA = false;
    this.saB = false;
    if (!this.rZC.aOg())
    {
      AppMethodBeat.o(106325);
      return;
    }
    this.rZC.a(new f.a() {});
    cww();
    AppMethodBeat.o(106325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.ui.e
 * JD-Core Version:    0.7.0.1
 */