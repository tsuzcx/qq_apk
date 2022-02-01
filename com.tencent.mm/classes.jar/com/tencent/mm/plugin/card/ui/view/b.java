package com.tencent.mm.plugin.card.ui.view;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.plugin.card.mgr.e;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.bj;
import com.tencent.mm.protocal.protobuf.bzp;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public final class b
  extends i
{
  private View wJa;
  private TextView wJb;
  private g wJc;
  private com.tencent.mm.plugin.card.base.b wru;
  private MMActivity wry;
  
  public final void destroy()
  {
    AppMethodBeat.i(113660);
    super.destroy();
    this.wry = null;
    this.wJc = null;
    AppMethodBeat.o(113660);
  }
  
  public final void doE()
  {
    AppMethodBeat.i(113662);
    this.wJa.setVisibility(8);
    AppMethodBeat.o(113662);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113659);
    this.wry = this.wJs.dmn();
    this.wJc = this.wJs.dmp();
    AppMethodBeat.o(113659);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113661);
    if (this.wJa == null)
    {
      this.wJa = ((ViewStub)findViewById(a.d.wfk)).inflate();
      this.wJa.findViewById(a.d.fvn).setOnClickListener(this.wJs.dmo());
    }
    this.wru = this.wJs.dmk();
    this.wJc = this.wJs.dmp();
    boolean bool1 = this.wJc.dno();
    boolean bool2 = this.wJc.dnp();
    Object localObject2;
    Object localObject1;
    int i;
    Object localObject3;
    Object localObject4;
    if (bool1)
    {
      this.wJa.setVisibility(0);
      Log.i("MicroMsg.CardAcceptView", "updateAcceptView() acceptViewVisible:" + bool1 + " acceptViewEnabled:" + bool2);
      localObject2 = (Button)this.wJa.findViewById(a.d.fvn);
      localObject1 = this.wJa.findViewById(a.d.wfj);
      ((View)localObject1).setBackgroundDrawable(null);
      ((View)localObject1).setOnClickListener(null);
      i = this.wry.getResources().getDimensionPixelSize(a.b.wdZ);
      if (!bool2) {
        break label1146;
      }
      if (!TextUtils.isEmpty(this.wru.djK().ZdS)) {
        ((Button)localObject2).setText(this.wru.djK().ZdS);
      }
      if (!this.wru.djq()) {
        break label873;
      }
      ((Button)localObject2).setTextColor(l.alv(this.wru.djK().nRQ));
      localObject3 = l.e(this.wry, l.alv(this.wru.djK().nRQ), i);
      localObject4 = l.gx(l.alv(this.wru.djK().nRQ), i);
      localObject1 = new StateListDrawable();
      ((StateListDrawable)localObject1).addState(new int[] { 16842919 }, (Drawable)localObject4);
      ((StateListDrawable)localObject1).addState(new int[0], (Drawable)localObject3);
      i = this.wry.getResources().getColor(a.a.white);
      int j = l.alv(this.wru.djK().nRQ);
      localObject3 = new int[0];
      ((Button)localObject2).setBackgroundDrawable((Drawable)localObject1);
      ((Button)localObject2).setTextColor(new ColorStateList(new int[][] { { 16842919, 16842910 }, localObject3 }, new int[] { i, j }));
      localObject1 = (LinearLayout.LayoutParams)this.wJa.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).topMargin = this.wry.getResources().getDimensionPixelSize(a.b.wdK);
      this.wJa.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.wJa.findViewById(a.d.wjZ).setVisibility(8);
      localObject1 = this.wJs.dms();
      this.wJa.setBackgroundColor(this.wry.getResources().getColor(a.a.white));
      localObject2 = (CheckBox)this.wJa.findViewById(a.d.wgk);
      if ((((e)localObject1).dkn() == null) || (!((e)localObject1).dkn().wsK)) {
        break label855;
      }
      Log.i("MicroMsg.CardAcceptView", "updateFollowBox() show followbox");
      ((CheckBox)localObject2).setVisibility(0);
      localObject3 = this.wru.djK().Zed;
      if ((localObject3 == null) || (TextUtils.isEmpty(((bzp)localObject3).text))) {
        break label839;
      }
      ((CheckBox)localObject2).setText(((bzp)localObject3).text);
      ((CheckBox)localObject2).setChecked(((e)localObject1).dkn().idG);
      ((CheckBox)localObject2).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113658);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/plugin/card/ui/view/CardAcceptView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (((CheckBox)paramAnonymousView).isChecked()) {}
          for (this.wJd.dkn().idG = true;; this.wJd.dkn().idG = false)
          {
            a.a(this, "com/tencent/mm/plugin/card/ui/view/CardAcceptView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(113658);
            return;
          }
        }
      });
    }
    for (;;)
    {
      if ((!this.wru.djr()) && (!this.wru.djp()))
      {
        if ((this.wru.djK().Zee != null) && (!Util.isNullOrNil(this.wru.djK().Zee.text)))
        {
          if (this.wJb == null) {
            this.wJb = ((TextView)this.wJa.findViewById(a.d.wfh));
          }
          this.wJb.setText(this.wru.djK().Zee.text);
          if (!Util.isNullOrNil(this.wru.djK().Zee.url))
          {
            this.wJb.setOnClickListener(this.wJs.dmo());
            this.wJb.setTextColor(l.alv(this.wru.djK().nRQ));
          }
          this.wJb.setVisibility(0);
          AppMethodBeat.o(113661);
          return;
          Log.i("MicroMsg.CardAcceptView", "updateAcceptView(), mAcceptCardView is Gone");
          this.wJa.setVisibility(8);
          AppMethodBeat.o(113661);
          return;
          label839:
          ((CheckBox)localObject2).setText(((e)localObject1).dkn().title);
          break;
          label855:
          Log.i("MicroMsg.CardAcceptView", "updateFollowBox() not show followbox");
          ((CheckBox)localObject2).setVisibility(8);
          continue;
          label873:
          if ((this.wru.djr()) || (this.wru.djp()) || (this.wru.djs()))
          {
            localObject1 = l.gx(l.alv(this.wru.djK().nRQ), i);
            localObject3 = l.gx(l.convertStringToRGB(this.wru.djK().nRQ, 175), i);
            localObject4 = new StateListDrawable();
            ((StateListDrawable)localObject4).addState(new int[] { 16842919 }, (Drawable)localObject3);
            ((StateListDrawable)localObject4).addState(new int[0], (Drawable)localObject1);
            ((Button)localObject2).setBackgroundDrawable((Drawable)localObject4);
            ((Button)localObject2).setTextColor(this.wry.getResources().getColor(a.a.white_text_color_selector));
            localObject1 = (LinearLayout.LayoutParams)((Button)localObject2).getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).width = -1;
            ((Button)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
            continue;
          }
          localObject1 = l.gx(l.alv(this.wru.djK().nRQ), i);
          localObject3 = l.gx(l.convertStringToRGB(this.wru.djK().nRQ, 175), i);
          localObject4 = new StateListDrawable();
          ((StateListDrawable)localObject4).addState(new int[] { 16842919 }, (Drawable)localObject3);
          ((StateListDrawable)localObject4).addState(new int[0], (Drawable)localObject1);
          ((Button)localObject2).setBackgroundDrawable((Drawable)localObject4);
          ((Button)localObject2).setTextColor(this.wry.getResources().getColor(a.a.white_text_color_selector));
          continue;
          label1146:
          this.wJa.setEnabled(false);
          ((View)localObject1).setEnabled(false);
          ((Button)localObject2).setEnabled(false);
          if (this.wru.djq()) {}
          for (localObject1 = this.wru.djK().ZdS;; localObject1 = this.wJc.dnh())
          {
            ((Button)localObject2).setText((CharSequence)localObject1);
            if (!this.wru.djq()) {
              break label1334;
            }
            ((Button)localObject2).setTextColor(l.convertStringToRGB(this.wru.djK().nRQ, 125));
            ((Button)localObject2).setBackgroundDrawable(l.e(this.wry, l.convertStringToRGB(this.wru.djK().nRQ, 125), i));
            localObject1 = (LinearLayout.LayoutParams)this.wJa.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).topMargin = this.wry.getResources().getDimensionPixelSize(a.b.wdL);
            this.wJa.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.wJa.findViewById(a.d.wjZ).setVisibility(8);
            break;
          }
          label1334:
          if ((this.wru.djr()) || (this.wru.djp()) || (this.wru.djs()))
          {
            ((Button)localObject2).setTextColor(this.wry.getResources().getColor(a.a.grey_background_text_color));
            ((Button)localObject2).setBackgroundDrawable(l.ag(this.wry, this.wry.getResources().getColor(a.a.wdz)));
            localObject1 = (LinearLayout.LayoutParams)((Button)localObject2).getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).width = -1;
            ((Button)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
            continue;
          }
          ((Button)localObject2).setTextColor(this.wry.getResources().getColor(a.a.grey_background_text_color));
          ((Button)localObject2).setBackgroundDrawable(l.ag(this.wry, this.wry.getResources().getColor(a.a.wdz)));
          continue;
        }
        if (this.wJb != null) {
          this.wJb.setVisibility(8);
        }
      }
    }
    AppMethodBeat.o(113661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.b
 * JD-Core Version:    0.7.0.1
 */