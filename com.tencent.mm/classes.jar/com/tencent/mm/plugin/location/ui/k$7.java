package com.tencent.mm.plugin.location.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.mm.bf.c;
import com.tencent.mm.plugin.map.a.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class k$7
  implements View.OnTouchListener
{
  k$7(k paramk) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
            this.lGT.lGI = true;
            this.lGT.lGD.setVisibility(0);
            this.lGT.lGC.reset();
            paramView = this.lGT.lGC;
            if (!paramView.lHv)
            {
              paramView.eku = true;
              paramView.beF();
            }
            this.lGT.lGB.setPressed(true);
          } while (!this.lGT.lGI);
          au.b(ae.getContext(), a.h.talkroom_press, new au.a()
          {
            public final void ug()
            {
              y.i("MicroMsg.TalkMgr", "play press sound end");
            }
          });
          this.lGT.lGJ = 1;
          y.i("MicroMsg.TalkMgr", "micBtn pressed down");
          this.lGT.lGL = bk.UZ();
          this.lGT.lGP.RJ();
          this.lGT.bez();
          return false;
        } while (!this.lGT.lGI);
        return false;
        this.lGT.lGB.setPressed(false);
        this.lGT.lGD.setVisibility(8);
        this.lGT.lGC.reset();
        this.lGT.lGC.eku = false;
      } while (!this.lGT.lGI);
      this.lGT.lGI = false;
      if (this.lGT.lGJ == 5)
      {
        y.i("MicroMsg.TalkMgr", "cancel during seize-success prepare time");
        this.lGT.lGM.stopTimer();
        this.lGT.lGN.stopTimer();
      }
      this.lGT.lGJ = 0;
      this.lGT.lGR.stopTimer();
      this.lGT.lGP.RK();
      au.G(ae.getContext(), a.h.talkroom_up);
      this.lGT.bez();
    } while (this.lGT.lGQ == null);
    this.lGT.lGQ.bev();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.k.7
 * JD-Core Version:    0.7.0.1
 */