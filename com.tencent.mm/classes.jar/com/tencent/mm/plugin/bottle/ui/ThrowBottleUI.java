package com.tencent.mm.plugin.bottle.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.media.ToneGenerator;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.j;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.j.a;
import com.tencent.mm.cb.a;
import com.tencent.mm.m.b;
import com.tencent.mm.plugin.bottle.a.h.a;
import com.tencent.mm.plugin.bottle.a.h.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMEditText;

public class ThrowBottleUI
  extends FrameLayout
  implements View.OnClickListener, h.a
{
  private static final int[] eMV = { R.g.amp_land_1, R.g.amp_land_2, R.g.amp_land_3, R.g.amp_land_4, R.g.amp_land_5, R.g.amp_land_6, R.g.amp_land_7, R.g.amp_land_8, R.g.amp_land_9, R.g.amp_land_10, R.g.amp_land_11 };
  private static final int[] ibm = { 0, 9, 18, 27, 37, 46, 55, 64, 74, 85, 93, 100 };
  final am eNb = new am(new ThrowBottleUI.5(this), true);
  BottleBeachUI hZZ;
  ah handler = new ah();
  ImageView iaw;
  ImageButton ibA;
  ThrowBottleFooter ibB;
  boolean ibC = false;
  boolean ibD;
  LinearLayout.LayoutParams ibE = null;
  private int ibF = 0;
  int ibG = 0;
  private ThrowBottleAnimUI.a ibH = new ThrowBottleUI.4(this);
  final am ibI = new am(new am.a()
  {
    int count = 0;
    
    public final boolean tC()
    {
      if (ThrowBottleUI.t(ThrowBottleUI.this) == -1L) {
        ThrowBottleUI.a(ThrowBottleUI.this, bk.UZ());
      }
      if (this.count % 3 == 2) {
        ThrowBottleUI.u(ThrowBottleUI.this).setWidth(ThrowBottleUI.u(ThrowBottleUI.this).getWidth() + 1);
      }
      this.count += 1;
      this.count %= 3;
      long l = bk.cp(ThrowBottleUI.t(ThrowBottleUI.this));
      int i;
      if ((l >= 50000L) && (l <= 60000L))
      {
        if (ThrowBottleUI.v(ThrowBottleUI.this) != null) {
          break label235;
        }
        i = (int)((60000L - l) / 1000L);
        ThrowBottleUI.a(ThrowBottleUI.this, Toast.makeText(ThrowBottleUI.h(ThrowBottleUI.this), ThrowBottleUI.h(ThrowBottleUI.this).getResources().getQuantityString(R.j.chatting_rcd_time_limit, i, new Object[] { Integer.valueOf(i) }), 0));
      }
      for (;;)
      {
        ThrowBottleUI.v(ThrowBottleUI.this).show();
        if (l < 60000L) {
          break;
        }
        y.v("MM.Bottle.ThrowBottleUI", "bottle record stop on countdown");
        ThrowBottleUI.w(ThrowBottleUI.this);
        ThrowBottleUI.this.axk();
        ThrowBottleUI.x(ThrowBottleUI.this);
        com.tencent.mm.sdk.platformtools.au.G(ThrowBottleUI.h(ThrowBottleUI.this), R.l.time_limit);
        return false;
        label235:
        i = (int)((60000L - l) / 1000L);
        ThrowBottleUI.v(ThrowBottleUI.this).setText(ThrowBottleUI.h(ThrowBottleUI.this).getResources().getQuantityString(R.j.chatting_rcd_time_limit, i, new Object[] { Integer.valueOf(i) }));
      }
      return true;
    }
  }, true);
  @SuppressLint({"HandlerLeak"})
  private final ah ibJ = new ThrowBottleUI.8(this);
  final j.a ibK = new ThrowBottleUI.9(this);
  boolean ibi = true;
  h.d ibn;
  ToneGenerator ibo;
  private long ibp = -1L;
  Toast ibq;
  Vibrator ibr;
  ThrowBottleAnimUI ibs;
  AnimationDrawable ibt;
  ImageView ibu;
  TextView ibv;
  ImageView ibw;
  MMEditText ibx;
  View iby;
  Button ibz;
  boolean isRecording = false;
  
  public ThrowBottleUI(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.hZZ = ((BottleBeachUI)paramContext);
  }
  
  private void axi()
  {
    int j = 8;
    this.ibv.setVisibility(8);
    Object localObject = this.ibw;
    boolean bool;
    if (this.ibi)
    {
      i = 8;
      ((ImageView)localObject).setVisibility(i);
      localObject = (View)this.ibx.getParent();
      i = j;
      if (this.ibi) {
        i = 0;
      }
      ((View)localObject).setVisibility(i);
      if (this.ibi) {
        this.ibx.requestFocus();
      }
      if (this.ibi) {
        break label182;
      }
      bool = true;
      label87:
      this.ibi = bool;
      ImageButton localImageButton = this.ibA;
      if (!this.ibi) {
        break label187;
      }
      localObject = a.g(this.hZZ, R.g.chatting_setmode_keyboard_btn);
      label117:
      localImageButton.setImageDrawable((Drawable)localObject);
      if (!this.ibi) {
        break label202;
      }
      er(false);
      label136:
      this.ibz = ((Button)this.hZZ.findViewById(R.h.bottle_throw_btn));
      localObject = this.ibz;
      if (!this.ibi) {
        break label210;
      }
    }
    label182:
    label187:
    label202:
    label210:
    for (int i = R.l.bottle_throw_voice_btn_text;; i = R.l.bottle_throw_text_btn_text)
    {
      ((Button)localObject).setText(i);
      return;
      i = 0;
      break;
      bool = false;
      break label87;
      localObject = a.g(this.hZZ, R.g.chatting_setmode_voice_btn);
      break label117;
      er(true);
      break label136;
    }
  }
  
  private void axj()
  {
    int k;
    int j;
    if (this.ibi)
    {
      k = this.ibv.getLeft();
      j = this.ibv.getTop();
    }
    for (int i = this.ibv.getWidth();; i = 0)
    {
      this.ibs = ((ThrowBottleAnimUI)this.hZZ.findViewById(R.h.bottle_throw_anim_lo));
      this.ibs.setOnThrowEndListener(this.ibH);
      ThrowBottleAnimUI localThrowBottleAnimUI = this.ibs;
      localThrowBottleAnimUI.ibi = this.ibi;
      localThrowBottleAnimUI.abU = k;
      localThrowBottleAnimUI.abV = j;
      localThrowBottleAnimUI.ibg = i;
      localThrowBottleAnimUI.setVisibility(0);
      ai.l(new ThrowBottleAnimUI.1(localThrowBottleAnimUI), 100L);
      return;
      k = this.ibx.getLeft();
      j = this.ibx.getTop();
    }
  }
  
  private void er(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ((InputMethodManager)this.hZZ.getSystemService("input_method")).showSoftInput(this.ibx, 0);
      return;
    }
    ((InputMethodManager)this.hZZ.getSystemService("input_method")).hideSoftInputFromWindow(this.ibx.getWindowToken(), 2);
  }
  
  public final boolean axk()
  {
    y.d("MM.Bottle.ThrowBottleUI", "bottle record stop");
    boolean bool;
    if (this.isRecording)
    {
      this.hZZ.getWindow().getDecorView().setKeepScreenOn(false);
      if (this.ibt != null) {
        this.ibt.stop();
      }
      if (this.ibn == null) {
        break label179;
      }
      bool = this.ibn.un();
      ag.Zn("keep_app_silent");
      this.eNb.stopTimer();
      this.ibI.stopTimer();
      this.ibp = -1L;
    }
    for (;;)
    {
      if (!bool)
      {
        this.ibz.setEnabled(false);
        this.ibz.setBackgroundDrawable(a.g(this.hZZ, R.g.record_shape_disable));
        this.ibu.setVisibility(8);
        this.ibv.setVisibility(8);
        this.ibJ.sendEmptyMessageDelayed(0, 500L);
        com.tencent.mm.model.au.Hx();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
          this.hZZ.ok(R.l.bottle_throw_rcd_too_short);
        }
      }
      for (;;)
      {
        this.isRecording = false;
        return false;
        axj();
      }
      label179:
      bool = false;
    }
  }
  
  public final void cs(int paramInt1, int paramInt2)
  {
    if (paramInt2 == -2002)
    {
      this.hZZ.ol(0);
      this.hZZ.ok(R.l.bottle_banby_expose);
    }
  }
  
  public void onClick(View paramView)
  {
    if (R.h.bottle_attach_btn == paramView.getId())
    {
      if ((!this.ibi) && (this.ibx.getText().toString().trim().length() > 0))
      {
        h.a(this.hZZ, getResources().getString(R.l.bottle_switch_mode_alert_title), null, getResources().getString(R.l.bottle_switch_mode_continue_text), new ThrowBottleUI.3(this), null);
        return;
      }
      axi();
      return;
    }
    this.hZZ.ol(0);
  }
  
  public void setVisibility(int paramInt)
  {
    this.iaw.setVisibility(8);
    int i;
    if (paramInt == 0)
    {
      this.ibi = true;
      this.ibu.setVisibility(8);
      this.ibv.setVisibility(8);
      this.ibv.setWidth(BackwardSupportUtil.b.b(this.hZZ, 120.0F));
      this.ibw.setVisibility(0);
      ((View)this.ibx.getParent()).setVisibility(8);
      this.ibx.setText("");
      this.ibB.setVisibility(0);
      com.tencent.mm.ui.tools.a.c.d(this.ibx).Ig(b.Ab()).a(null);
      this.ibA.setImageDrawable(a.g(this.hZZ, R.g.chatting_setmode_keyboard_btn));
      this.ibz.setBackgroundDrawable(a.g(this.hZZ, R.g.record_shape_normal));
      Button localButton = this.ibz;
      if (this.ibi)
      {
        i = R.l.bottle_throw_voice_btn_text;
        localButton.setText(i);
        ((LinearLayout)this.hZZ.findViewById(R.h.bottle_throw_edit_lo)).setVisibility(0);
        this.hZZ.getWindow().clearFlags(1024);
      }
    }
    for (;;)
    {
      super.setVisibility(paramInt);
      return;
      i = R.l.bottle_throw_text_btn_text;
      break;
      this.hZZ.getWindow().setFlags(1024, 1024);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.ThrowBottleUI
 * JD-Core Version:    0.7.0.1
 */