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
import com.tencent.mm.protocal.protobuf.att;
import com.tencent.mm.protocal.protobuf.bc;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;

public final class b
  extends i
{
  private com.tencent.mm.plugin.card.base.b oDm;
  private MMActivity oDq;
  private View oUL;
  private TextView oUM;
  private g oUN;
  
  public final void bZG()
  {
    AppMethodBeat.i(113662);
    this.oUL.setVisibility(8);
    AppMethodBeat.o(113662);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(113660);
    super.destroy();
    this.oDq = null;
    this.oUN = null;
    AppMethodBeat.o(113660);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113659);
    this.oDq = this.oVd.bXD();
    this.oUN = this.oVd.bXF();
    AppMethodBeat.o(113659);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113661);
    if (this.oUL == null)
    {
      this.oUL = ((ViewStub)findViewById(2131297720)).inflate();
      this.oUL.findViewById(2131297710).setOnClickListener(this.oVd.bXE());
    }
    this.oDm = this.oVd.bXA();
    this.oUN = this.oVd.bXF();
    boolean bool1 = this.oUN.bYG();
    boolean bool2 = this.oUN.bYH();
    Object localObject2;
    Object localObject1;
    int i;
    Object localObject3;
    Object localObject4;
    if (bool1)
    {
      this.oUL.setVisibility(0);
      ae.i("MicroMsg.CardAcceptView", "updateAcceptView() acceptViewVisible:" + bool1 + " acceptViewEnabled:" + bool2);
      localObject2 = (Button)this.oUL.findViewById(2131297710);
      localObject1 = this.oUL.findViewById(2131297719);
      ((View)localObject1).setBackgroundDrawable(null);
      ((View)localObject1).setOnClickListener(null);
      i = this.oDq.getResources().getDimensionPixelSize(2131165984);
      if (!bool2) {
        break label1140;
      }
      if (!TextUtils.isEmpty(this.oDm.bVc().Gkg)) {
        ((Button)localObject2).setText(this.oDm.bVc().Gkg);
      }
      if (!this.oDm.bUJ()) {
        break label867;
      }
      ((Button)localObject2).setTextColor(l.ZY(this.oDm.bVc().hDr));
      localObject3 = l.f(this.oDq, l.ZY(this.oDm.bVc().hDr), i);
      localObject4 = l.eV(l.ZY(this.oDm.bVc().hDr), i);
      localObject1 = new StateListDrawable();
      ((StateListDrawable)localObject1).addState(new int[] { 16842919 }, (Drawable)localObject4);
      ((StateListDrawable)localObject1).addState(new int[0], (Drawable)localObject3);
      i = this.oDq.getResources().getColor(2131101179);
      int j = l.ZY(this.oDm.bVc().hDr);
      localObject3 = new int[] { 16842919, 16842910 };
      localObject4 = new int[0];
      ((Button)localObject2).setBackgroundDrawable((Drawable)localObject1);
      ((Button)localObject2).setTextColor(new ColorStateList(new int[][] { localObject3, localObject4 }, new int[] { i, j }));
      localObject1 = (LinearLayout.LayoutParams)this.oUL.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).topMargin = this.oDq.getResources().getDimensionPixelSize(2131165957);
      this.oUL.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.oUL.findViewById(2131299164).setVisibility(8);
      localObject1 = this.oVd.bXI();
      this.oUL.setBackgroundColor(this.oDq.getResources().getColor(2131101179));
      localObject2 = (CheckBox)this.oUL.findViewById(2131297795);
      if ((((f)localObject1).bVG() == null) || (!((f)localObject1).bVG().oEB)) {
        break label849;
      }
      ae.i("MicroMsg.CardAcceptView", "updateFollowBox() show followbox");
      ((CheckBox)localObject2).setVisibility(0);
      localObject3 = this.oDm.bVc().Gkr;
      if ((localObject3 == null) || (TextUtils.isEmpty(((att)localObject3).text))) {
        break label833;
      }
      ((CheckBox)localObject2).setText(((att)localObject3).text);
      ((CheckBox)localObject2).setChecked(((f)localObject1).bVG().dLH);
      ((CheckBox)localObject2).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113658);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/card/ui/view/CardAcceptView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (((CheckBox)paramAnonymousView).isChecked()) {}
          for (this.oUO.bVG().dLH = true;; this.oUO.bVG().dLH = false)
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
      if ((!this.oDm.bUK()) && (!this.oDm.bUI()))
      {
        if ((this.oDm.bVc().Gks != null) && (!bu.isNullOrNil(this.oDm.bVc().Gks.text)))
        {
          if (this.oUM == null) {
            this.oUM = ((TextView)this.oUL.findViewById(2131297717));
          }
          this.oUM.setText(this.oDm.bVc().Gks.text);
          if (!bu.isNullOrNil(this.oDm.bVc().Gks.url))
          {
            this.oUM.setOnClickListener(this.oVd.bXE());
            this.oUM.setTextColor(l.ZY(this.oDm.bVc().hDr));
          }
          this.oUM.setVisibility(0);
          AppMethodBeat.o(113661);
          return;
          ae.i("MicroMsg.CardAcceptView", "updateAcceptView(), mAcceptCardView is Gone");
          this.oUL.setVisibility(8);
          AppMethodBeat.o(113661);
          return;
          label833:
          ((CheckBox)localObject2).setText(((f)localObject1).bVG().title);
          break;
          label849:
          ae.i("MicroMsg.CardAcceptView", "updateFollowBox() not show followbox");
          ((CheckBox)localObject2).setVisibility(8);
          continue;
          label867:
          if ((this.oDm.bUK()) || (this.oDm.bUI()) || (this.oDm.bUL()))
          {
            localObject1 = l.eV(l.ZY(this.oDm.bVc().hDr), i);
            localObject3 = l.eV(l.cN(this.oDm.bVc().hDr, 175), i);
            localObject4 = new StateListDrawable();
            ((StateListDrawable)localObject4).addState(new int[] { 16842919 }, (Drawable)localObject3);
            ((StateListDrawable)localObject4).addState(new int[0], (Drawable)localObject1);
            ((Button)localObject2).setBackgroundDrawable((Drawable)localObject4);
            ((Button)localObject2).setTextColor(this.oDq.getResources().getColor(2131101185));
            localObject1 = (LinearLayout.LayoutParams)((Button)localObject2).getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).width = -1;
            ((Button)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
            continue;
          }
          localObject1 = l.eV(l.ZY(this.oDm.bVc().hDr), i);
          localObject3 = l.eV(l.cN(this.oDm.bVc().hDr, 175), i);
          localObject4 = new StateListDrawable();
          ((StateListDrawable)localObject4).addState(new int[] { 16842919 }, (Drawable)localObject3);
          ((StateListDrawable)localObject4).addState(new int[0], (Drawable)localObject1);
          ((Button)localObject2).setBackgroundDrawable((Drawable)localObject4);
          ((Button)localObject2).setTextColor(this.oDq.getResources().getColor(2131101185));
          continue;
          label1140:
          this.oUL.setEnabled(false);
          ((View)localObject1).setEnabled(false);
          ((Button)localObject2).setEnabled(false);
          if (this.oDm.bUJ()) {}
          for (localObject1 = this.oDm.bVc().Gkg;; localObject1 = this.oUN.bYz())
          {
            ((Button)localObject2).setText((CharSequence)localObject1);
            if (!this.oDm.bUJ()) {
              break label1327;
            }
            ((Button)localObject2).setTextColor(l.cN(this.oDm.bVc().hDr, 125));
            ((Button)localObject2).setBackgroundDrawable(l.f(this.oDq, l.cN(this.oDm.bVc().hDr, 125), i));
            localObject1 = (LinearLayout.LayoutParams)this.oUL.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).topMargin = this.oDq.getResources().getDimensionPixelSize(2131165958);
            this.oUL.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.oUL.findViewById(2131299164).setVisibility(8);
            break;
          }
          label1327:
          if ((this.oDm.bUK()) || (this.oDm.bUI()) || (this.oDm.bUL()))
          {
            ((Button)localObject2).setTextColor(this.oDq.getResources().getColor(2131100469));
            ((Button)localObject2).setBackgroundDrawable(l.P(this.oDq, this.oDq.getResources().getColor(2131100081)));
            localObject1 = (LinearLayout.LayoutParams)((Button)localObject2).getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).width = -1;
            ((Button)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
            continue;
          }
          ((Button)localObject2).setTextColor(this.oDq.getResources().getColor(2131100469));
          ((Button)localObject2).setBackgroundDrawable(l.P(this.oDq, this.oDq.getResources().getColor(2131100081)));
          continue;
        }
        if (this.oUM != null) {
          this.oUM.setVisibility(8);
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