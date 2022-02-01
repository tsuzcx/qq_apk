package com.tencent.mm.plugin.ball.ui;

import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.ball.a.f;
import com.tencent.mm.plugin.ball.a.f.a;
import com.tencent.mm.plugin.ball.view.FloatIndicatorView;
import com.tencent.mm.plugin.ball.view.FloatIndicatorView.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.SwipeBackLayout;

public final class e
{
  private boolean nKe;
  public f vkT;
  private com.tencent.mm.plugin.ball.d.e vkU;
  public FloatIndicatorView vlM;
  int vlN;
  int vlO;
  FrameLayout.LayoutParams vlP;
  private boolean vlQ;
  private boolean vlR;
  private boolean vlS;
  private long vlT;
  
  public e(f paramf, com.tencent.mm.plugin.ball.d.e parame)
  {
    AppMethodBeat.i(106321);
    this.vlT = -1L;
    this.vkT = paramf;
    this.vkU = parame;
    this.vlM = new FloatIndicatorView(this.vkT.getActivity());
    this.vlM.setOnOrientationChangedListener(new FloatIndicatorView.a()
    {
      public final void mw(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(106316);
        Log.i("MicroMsg.FloatIndicatorController", "onOrientationChanged, isLandscape:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        e.this.mv(paramAnonymousBoolean);
        e.this.vlP.bottomMargin = e.this.vlO;
        e.this.vlP.rightMargin = e.this.vlN;
        e.this.vlM.setLayoutParams(e.this.vlP);
        Log.i("MicroMsg.FloatIndicatorController", "onOrientationChanged layoutParams, right:%s, bottom:%s", new Object[] { Integer.valueOf(e.this.vlP.rightMargin), Integer.valueOf(e.this.vlP.bottomMargin) });
        AppMethodBeat.o(106316);
      }
    });
    if (a.ms(MMApplicationContext.getContext()) > a.mt(MMApplicationContext.getContext())) {}
    for (boolean bool = true;; bool = false)
    {
      mv(bool);
      this.vlP = new FrameLayout.LayoutParams(-2, -2);
      this.vlP.gravity = 8388693;
      this.vlP.bottomMargin = this.vlO;
      this.vlP.rightMargin = this.vlN;
      this.vlM.setLayoutParams(this.vlP);
      Log.i("MicroMsg.FloatIndicatorController", "createFloatIndicator layoutParams, right:%s, bottom:%s", new Object[] { Integer.valueOf(this.vlP.rightMargin), Integer.valueOf(this.vlP.bottomMargin) });
      AppMethodBeat.o(106321);
      return;
    }
  }
  
  private int cZe()
  {
    AppMethodBeat.i(106324);
    if (this.vkT.cXC() >= 0)
    {
      i = this.vkT.cXC();
      AppMethodBeat.o(106324);
      return i;
    }
    int i = com.tencent.mm.plugin.ball.f.e.vmn;
    AppMethodBeat.o(106324);
    return i;
  }
  
  private void cZf()
  {
    AppMethodBeat.i(106327);
    if (!this.vlR)
    {
      AppMethodBeat.o(106327);
      return;
    }
    if (this.vlM != null)
    {
      this.vlM.setVisibility(8);
      this.vlR = false;
    }
    AppMethodBeat.o(106327);
  }
  
  private void cZg()
  {
    AppMethodBeat.i(106328);
    ViewGroup localViewGroup;
    if (this.vlM != null)
    {
      this.vlM.setVisibility(8);
      localViewGroup = this.vkT.cXB();
    }
    for (;;)
    {
      int i;
      try
      {
        if (this.vlM.getParent() == null)
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
          localViewGroup.addView(this.vlM, j);
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
  
  private void cxh()
  {
    AppMethodBeat.i(106323);
    com.tencent.mm.plugin.ball.f.e.fE(this.vkT.getActivity());
    if (this.nKe)
    {
      this.vlO = (-com.tencent.mm.plugin.ball.f.e.vmi);
      this.vlN = (cZe() - com.tencent.mm.plugin.ball.f.e.vmi);
      AppMethodBeat.o(106323);
      return;
    }
    this.vlN = (-com.tencent.mm.plugin.ball.f.e.vmi);
    this.vlO = (cZe() - com.tencent.mm.plugin.ball.f.e.vmi);
    AppMethodBeat.o(106323);
  }
  
  final void mv(boolean paramBoolean)
  {
    AppMethodBeat.i(106322);
    Log.i("MicroMsg.FloatIndicatorController", "updateOrientation, isLandscape:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.nKe = paramBoolean;
    cxh();
    AppMethodBeat.o(106322);
  }
  
  public final void start()
  {
    AppMethodBeat.i(106325);
    Log.i("MicroMsg.FloatIndicatorController", "start FloatIndicatorController");
    cZf();
    this.vlT = -1L;
    this.vlQ = false;
    this.vlR = false;
    this.vlS = false;
    if (!this.vkT.bhU())
    {
      AppMethodBeat.o(106325);
      return;
    }
    this.vkT.a(new f.a() {});
    cZg();
    AppMethodBeat.o(106325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.ui.e
 * JD-Core Version:    0.7.0.1
 */