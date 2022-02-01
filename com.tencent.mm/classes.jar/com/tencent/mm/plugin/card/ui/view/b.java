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
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.atd;
import com.tencent.mm.protocal.protobuf.bc;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;

public final class b
  extends i
{
  private View oOj;
  private TextView oOk;
  private g oOl;
  private com.tencent.mm.plugin.card.base.b owK;
  private MMActivity owO;
  
  public final void bYr()
  {
    AppMethodBeat.i(113662);
    this.oOj.setVisibility(8);
    AppMethodBeat.o(113662);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(113660);
    super.destroy();
    this.owO = null;
    this.oOl = null;
    AppMethodBeat.o(113660);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113659);
    this.owO = this.oOB.bWo();
    this.oOl = this.oOB.bWq();
    AppMethodBeat.o(113659);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113661);
    if (this.oOj == null)
    {
      this.oOj = ((ViewStub)findViewById(2131297720)).inflate();
      this.oOj.findViewById(2131297710).setOnClickListener(this.oOB.bWp());
    }
    this.owK = this.oOB.bWl();
    this.oOl = this.oOB.bWq();
    boolean bool1 = this.oOl.bXr();
    boolean bool2 = this.oOl.bXs();
    Object localObject2;
    Object localObject1;
    int i;
    Object localObject3;
    Object localObject4;
    if (bool1)
    {
      this.oOj.setVisibility(0);
      ad.i("MicroMsg.CardAcceptView", "updateAcceptView() acceptViewVisible:" + bool1 + " acceptViewEnabled:" + bool2);
      localObject2 = (Button)this.oOj.findViewById(2131297710);
      localObject1 = this.oOj.findViewById(2131297719);
      ((View)localObject1).setBackgroundDrawable(null);
      ((View)localObject1).setOnClickListener(null);
      i = this.owO.getResources().getDimensionPixelSize(2131165984);
      if (!bool2) {
        break label1140;
      }
      if (!TextUtils.isEmpty(this.owK.bTN().FRH)) {
        ((Button)localObject2).setText(this.owK.bTN().FRH);
      }
      if (!this.owK.bTu()) {
        break label867;
      }
      ((Button)localObject2).setTextColor(l.Zh(this.owK.bTN().hAD));
      localObject3 = l.f(this.owO, l.Zh(this.owK.bTN().hAD), i);
      localObject4 = l.eU(l.Zh(this.owK.bTN().hAD), i);
      localObject1 = new StateListDrawable();
      ((StateListDrawable)localObject1).addState(new int[] { 16842919 }, (Drawable)localObject4);
      ((StateListDrawable)localObject1).addState(new int[0], (Drawable)localObject3);
      i = this.owO.getResources().getColor(2131101179);
      int j = l.Zh(this.owK.bTN().hAD);
      localObject3 = new int[] { 16842919, 16842910 };
      localObject4 = new int[0];
      ((Button)localObject2).setBackgroundDrawable((Drawable)localObject1);
      ((Button)localObject2).setTextColor(new ColorStateList(new int[][] { localObject3, localObject4 }, new int[] { i, j }));
      localObject1 = (LinearLayout.LayoutParams)this.oOj.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).topMargin = this.owO.getResources().getDimensionPixelSize(2131165957);
      this.oOj.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.oOj.findViewById(2131299164).setVisibility(8);
      localObject1 = this.oOB.bWt();
      this.oOj.setBackgroundColor(this.owO.getResources().getColor(2131101179));
      localObject2 = (CheckBox)this.oOj.findViewById(2131297795);
      if ((((f)localObject1).bUr() == null) || (!((f)localObject1).bUr().oxZ)) {
        break label849;
      }
      ad.i("MicroMsg.CardAcceptView", "updateFollowBox() show followbox");
      ((CheckBox)localObject2).setVisibility(0);
      localObject3 = this.owK.bTN().FRS;
      if ((localObject3 == null) || (TextUtils.isEmpty(((atd)localObject3).text))) {
        break label833;
      }
      ((CheckBox)localObject2).setText(((atd)localObject3).text);
      ((CheckBox)localObject2).setChecked(((f)localObject1).bUr().dKs);
      ((CheckBox)localObject2).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113658);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/card/ui/view/CardAcceptView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (((CheckBox)paramAnonymousView).isChecked()) {}
          for (this.oOm.bUr().dKs = true;; this.oOm.bUr().dKs = false)
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
      if ((!this.owK.bTv()) && (!this.owK.bTt()))
      {
        if ((this.owK.bTN().FRT != null) && (!bt.isNullOrNil(this.owK.bTN().FRT.text)))
        {
          if (this.oOk == null) {
            this.oOk = ((TextView)this.oOj.findViewById(2131297717));
          }
          this.oOk.setText(this.owK.bTN().FRT.text);
          if (!bt.isNullOrNil(this.owK.bTN().FRT.url))
          {
            this.oOk.setOnClickListener(this.oOB.bWp());
            this.oOk.setTextColor(l.Zh(this.owK.bTN().hAD));
          }
          this.oOk.setVisibility(0);
          AppMethodBeat.o(113661);
          return;
          ad.i("MicroMsg.CardAcceptView", "updateAcceptView(), mAcceptCardView is Gone");
          this.oOj.setVisibility(8);
          AppMethodBeat.o(113661);
          return;
          label833:
          ((CheckBox)localObject2).setText(((f)localObject1).bUr().title);
          break;
          label849:
          ad.i("MicroMsg.CardAcceptView", "updateFollowBox() not show followbox");
          ((CheckBox)localObject2).setVisibility(8);
          continue;
          label867:
          if ((this.owK.bTv()) || (this.owK.bTt()) || (this.owK.bTw()))
          {
            localObject1 = l.eU(l.Zh(this.owK.bTN().hAD), i);
            localObject3 = l.eU(l.cJ(this.owK.bTN().hAD, 175), i);
            localObject4 = new StateListDrawable();
            ((StateListDrawable)localObject4).addState(new int[] { 16842919 }, (Drawable)localObject3);
            ((StateListDrawable)localObject4).addState(new int[0], (Drawable)localObject1);
            ((Button)localObject2).setBackgroundDrawable((Drawable)localObject4);
            ((Button)localObject2).setTextColor(this.owO.getResources().getColor(2131101185));
            localObject1 = (LinearLayout.LayoutParams)((Button)localObject2).getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).width = -1;
            ((Button)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
            continue;
          }
          localObject1 = l.eU(l.Zh(this.owK.bTN().hAD), i);
          localObject3 = l.eU(l.cJ(this.owK.bTN().hAD, 175), i);
          localObject4 = new StateListDrawable();
          ((StateListDrawable)localObject4).addState(new int[] { 16842919 }, (Drawable)localObject3);
          ((StateListDrawable)localObject4).addState(new int[0], (Drawable)localObject1);
          ((Button)localObject2).setBackgroundDrawable((Drawable)localObject4);
          ((Button)localObject2).setTextColor(this.owO.getResources().getColor(2131101185));
          continue;
          label1140:
          this.oOj.setEnabled(false);
          ((View)localObject1).setEnabled(false);
          ((Button)localObject2).setEnabled(false);
          if (this.owK.bTu()) {}
          for (localObject1 = this.owK.bTN().FRH;; localObject1 = this.oOl.bXk())
          {
            ((Button)localObject2).setText((CharSequence)localObject1);
            if (!this.owK.bTu()) {
              break label1327;
            }
            ((Button)localObject2).setTextColor(l.cJ(this.owK.bTN().hAD, 125));
            ((Button)localObject2).setBackgroundDrawable(l.f(this.owO, l.cJ(this.owK.bTN().hAD, 125), i));
            localObject1 = (LinearLayout.LayoutParams)this.oOj.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).topMargin = this.owO.getResources().getDimensionPixelSize(2131165958);
            this.oOj.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.oOj.findViewById(2131299164).setVisibility(8);
            break;
          }
          label1327:
          if ((this.owK.bTv()) || (this.owK.bTt()) || (this.owK.bTw()))
          {
            ((Button)localObject2).setTextColor(this.owO.getResources().getColor(2131100469));
            ((Button)localObject2).setBackgroundDrawable(l.P(this.owO, this.owO.getResources().getColor(2131100081)));
            localObject1 = (LinearLayout.LayoutParams)((Button)localObject2).getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).width = -1;
            ((Button)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
            continue;
          }
          ((Button)localObject2).setTextColor(this.owO.getResources().getColor(2131100469));
          ((Button)localObject2).setBackgroundDrawable(l.P(this.owO, this.owO.getResources().getColor(2131100081)));
          continue;
        }
        if (this.oOk != null) {
          this.oOk.setVisibility(8);
        }
      }
    }
    AppMethodBeat.o(113661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.b
 * JD-Core Version:    0.7.0.1
 */