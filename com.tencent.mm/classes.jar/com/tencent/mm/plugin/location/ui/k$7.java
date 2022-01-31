package com.tencent.mm.plugin.location.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bg.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bo;

final class k$7
  implements View.OnTouchListener
{
  k$7(k paramk) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(113537);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(113537);
      return false;
      this.oeg.odV = true;
      this.oeg.odQ.setVisibility(0);
      this.oeg.odP.reset();
      paramView = this.oeg.odP;
      if (!paramView.oeI)
      {
        paramView.fAK = true;
        paramView.bLZ();
      }
      this.oeg.odO.setPressed(true);
      if (this.oeg.odV)
      {
        ay.a(ah.getContext(), 2131304257, new k.7.1(this));
        this.oeg.odW = 1;
        ab.i("MicroMsg.TalkMgr", "micBtn pressed down");
        this.oeg.odY = bo.yB();
        this.oeg.oec.akS();
        this.oeg.display();
        continue;
        if (this.oeg.odV)
        {
          continue;
          this.oeg.odO.setPressed(false);
          this.oeg.odQ.setVisibility(8);
          this.oeg.odP.reset();
          this.oeg.odP.fAK = false;
          if (this.oeg.odV)
          {
            this.oeg.odV = false;
            if (this.oeg.odW == 5)
            {
              ab.i("MicroMsg.TalkMgr", "cancel during seize-success prepare time");
              this.oeg.odZ.stopTimer();
              this.oeg.oea.stopTimer();
            }
            this.oeg.odW = 0;
            this.oeg.oee.stopTimer();
            this.oeg.oec.akT();
            ay.ax(ah.getContext(), 2131304260);
            this.oeg.display();
            if (this.oeg.oed != null) {
              this.oeg.oed.bLP();
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.k.7
 * JD-Core Version:    0.7.0.1
 */