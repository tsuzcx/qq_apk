package com.tencent.mm.plugin.bottle.ui;

import android.graphics.drawable.AnimationDrawable;
import android.media.ToneGenerator;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.f.b.h;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.bottle.a.h.c;
import com.tencent.mm.plugin.bottle.a.h.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.MMEditText;

final class ThrowBottleUI$2
  implements View.OnTouchListener
{
  ThrowBottleUI$2(ThrowBottleUI paramThrowBottleUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView != ThrowBottleUI.f(this.ibL)) {}
    boolean bool;
    do
    {
      do
      {
        return false;
        switch (paramMotionEvent.getAction())
        {
        default: 
          return false;
        }
      } while (ThrowBottleUI.g(this.ibL));
      bool = com.tencent.mm.pluginsdk.permission.a.a(ThrowBottleUI.h(this.ibL), "android.permission.RECORD_AUDIO", 80, null, null);
      y.i("MM.Bottle.ThrowBottleUI", "summerper checkPermission checkMicrophone[%b]", new Object[] { Boolean.valueOf(bool) });
    } while (!bool);
    paramView = this.ibL;
    paramView.ibC = true;
    paramView.ibz.setBackgroundDrawable(com.tencent.mm.cb.a.g(paramView.hZZ, R.g.record_shape_press));
    paramMotionEvent = paramView.ibz;
    if (paramView.ibi) {}
    for (int i = R.l.bottle_throw_voice_btn_pressed_text;; i = R.l.bottle_throw_text_btn_text)
    {
      paramMotionEvent.setText(i);
      if (!paramView.ibi) {
        break;
      }
      if ((!com.tencent.mm.r.a.bk(paramView.getContext())) && (!com.tencent.mm.r.a.bi(paramView.hZZ))) {
        break label185;
      }
      y.d("MM.Bottle.ThrowBottleUI", "voip is running, can't record voice");
      return false;
    }
    label185:
    au.Hx();
    if (!c.isSDCardAvailable())
    {
      s.gM(paramView.hZZ);
      return false;
    }
    paramView.isRecording = true;
    y.v("MM.Bottle.ThrowBottleUI", "record start");
    if (paramView.ibn != null)
    {
      paramView.ibn.hYq = null;
      paramView.ibn = null;
    }
    paramView.ibn = new h.d(paramView.getContext(), paramView);
    paramView.eNb.S(100L, 100L);
    paramView.ibu.setVisibility(0);
    paramView.ibv.setVisibility(0);
    paramView.ibt = ((AnimationDrawable)paramView.ibv.getBackground());
    paramView.ibt.start();
    paramView.ibw.setVisibility(8);
    if (paramView.ibn != null)
    {
      ag.Zm("keep_app_silent");
      paramView.ibn.cE("_USER_FOR_THROWBOTTLE_");
      paramView.ibD = false;
      paramView.ibI.S(200L, 200L);
      paramView.ibo.startTone(24);
      paramView.handler.postDelayed(new ThrowBottleUI.7(paramView), 200L);
      paramView.ibr.vibrate(50L);
      paramView.ibn.a(paramView.ibK);
    }
    paramView.hZZ.getWindow().getDecorView().setKeepScreenOn(true);
    return false;
    ThrowBottleUI.i(this.ibL);
    ThrowBottleUI.f(this.ibL).setBackgroundDrawable(com.tencent.mm.cb.a.g(ThrowBottleUI.h(this.ibL), R.g.record_shape_normal));
    paramView = ThrowBottleUI.f(this.ibL);
    if (ThrowBottleUI.j(this.ibL))
    {
      i = R.l.bottle_throw_voice_btn_text;
      paramView.setText(i);
      if (!ThrowBottleUI.j(this.ibL)) {
        break label521;
      }
      if (!ThrowBottleUI.k(this.ibL)) {
        this.ibL.axk();
      }
    }
    for (;;)
    {
      ThrowBottleUI.o(this.ibL);
      return false;
      i = R.l.bottle_throw_text_btn_text;
      break;
      label521:
      ThrowBottleUI.l(this.ibL);
      paramView = ThrowBottleUI.m(this.ibL).getText().toString().trim();
      if (paramView.length() < 5)
      {
        ThrowBottleUI.h(this.ibL).ok(R.l.bottle_throw_text_too_short);
        return false;
      }
      ThrowBottleUI.m(this.ibL).setText("");
      new h.c(paramView, this.ibL);
      ThrowBottleUI.n(this.ibL);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.ThrowBottleUI.2
 * JD-Core Version:    0.7.0.1
 */