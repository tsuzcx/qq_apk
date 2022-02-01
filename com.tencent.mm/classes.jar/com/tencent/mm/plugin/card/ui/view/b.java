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
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.apj;
import com.tencent.mm.protocal.protobuf.bc;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;

public final class b
  extends i
{
  private com.tencent.mm.plugin.card.base.b nTp;
  private MMActivity nTt;
  private View okO;
  private TextView okP;
  private g okQ;
  
  public final void bTM()
  {
    AppMethodBeat.i(113662);
    this.okO.setVisibility(8);
    AppMethodBeat.o(113662);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(113660);
    super.destroy();
    this.nTt = null;
    this.okQ = null;
    AppMethodBeat.o(113660);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113659);
    this.nTt = this.olg.bRJ();
    this.okQ = this.olg.bRL();
    AppMethodBeat.o(113659);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113661);
    if (this.okO == null)
    {
      this.okO = ((ViewStub)findViewById(2131297720)).inflate();
      this.okO.findViewById(2131297710).setOnClickListener(this.olg.bRK());
    }
    this.nTp = this.olg.bRG();
    this.okQ = this.olg.bRL();
    boolean bool1 = this.okQ.bSM();
    boolean bool2 = this.okQ.bSN();
    Object localObject2;
    Object localObject1;
    int i;
    Object localObject3;
    Object localObject4;
    if (bool1)
    {
      this.okO.setVisibility(0);
      ac.i("MicroMsg.CardAcceptView", "updateAcceptView() acceptViewVisible:" + bool1 + " acceptViewEnabled:" + bool2);
      localObject2 = (Button)this.okO.findViewById(2131297710);
      localObject1 = this.okO.findViewById(2131297719);
      ((View)localObject1).setBackgroundDrawable(null);
      ((View)localObject1).setOnClickListener(null);
      i = this.nTt.getResources().getDimensionPixelSize(2131165984);
      if (!bool2) {
        break label1140;
      }
      if (!TextUtils.isEmpty(this.nTp.bPi().Eky)) {
        ((Button)localObject2).setText(this.nTp.bPi().Eky);
      }
      if (!this.nTp.bOP()) {
        break label867;
      }
      ((Button)localObject2).setTextColor(l.Vy(this.nTp.bPi().hiu));
      localObject3 = l.f(this.nTt, l.Vy(this.nTp.bPi().hiu), i);
      localObject4 = l.eQ(l.Vy(this.nTp.bPi().hiu), i);
      localObject1 = new StateListDrawable();
      ((StateListDrawable)localObject1).addState(new int[] { 16842919 }, (Drawable)localObject4);
      ((StateListDrawable)localObject1).addState(new int[0], (Drawable)localObject3);
      i = this.nTt.getResources().getColor(2131101179);
      int j = l.Vy(this.nTp.bPi().hiu);
      localObject3 = new int[] { 16842919, 16842910 };
      localObject4 = new int[0];
      ((Button)localObject2).setBackgroundDrawable((Drawable)localObject1);
      ((Button)localObject2).setTextColor(new ColorStateList(new int[][] { localObject3, localObject4 }, new int[] { i, j }));
      localObject1 = (LinearLayout.LayoutParams)this.okO.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).topMargin = this.nTt.getResources().getDimensionPixelSize(2131165957);
      this.okO.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.okO.findViewById(2131299164).setVisibility(8);
      localObject1 = this.olg.bRO();
      this.okO.setBackgroundColor(this.nTt.getResources().getColor(2131101179));
      localObject2 = (CheckBox)this.okO.findViewById(2131297795);
      if ((((f)localObject1).bPM() == null) || (!((f)localObject1).bPM().nUE)) {
        break label849;
      }
      ac.i("MicroMsg.CardAcceptView", "updateFollowBox() show followbox");
      ((CheckBox)localObject2).setVisibility(0);
      localObject3 = this.nTp.bPi().EkJ;
      if ((localObject3 == null) || (TextUtils.isEmpty(((apj)localObject3).text))) {
        break label833;
      }
      ((CheckBox)localObject2).setText(((apj)localObject3).text);
      ((CheckBox)localObject2).setChecked(((f)localObject1).bPM().dyf);
      ((CheckBox)localObject2).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113658);
          if (((CheckBox)paramAnonymousView).isChecked())
          {
            this.okR.bPM().dyf = true;
            AppMethodBeat.o(113658);
            return;
          }
          this.okR.bPM().dyf = false;
          AppMethodBeat.o(113658);
        }
      });
    }
    for (;;)
    {
      if ((!this.nTp.bOQ()) && (!this.nTp.bOO()))
      {
        if ((this.nTp.bPi().EkK != null) && (!bs.isNullOrNil(this.nTp.bPi().EkK.text)))
        {
          if (this.okP == null) {
            this.okP = ((TextView)this.okO.findViewById(2131297717));
          }
          this.okP.setText(this.nTp.bPi().EkK.text);
          if (!bs.isNullOrNil(this.nTp.bPi().EkK.url))
          {
            this.okP.setOnClickListener(this.olg.bRK());
            this.okP.setTextColor(l.Vy(this.nTp.bPi().hiu));
          }
          this.okP.setVisibility(0);
          AppMethodBeat.o(113661);
          return;
          ac.i("MicroMsg.CardAcceptView", "updateAcceptView(), mAcceptCardView is Gone");
          this.okO.setVisibility(8);
          AppMethodBeat.o(113661);
          return;
          label833:
          ((CheckBox)localObject2).setText(((f)localObject1).bPM().title);
          break;
          label849:
          ac.i("MicroMsg.CardAcceptView", "updateFollowBox() not show followbox");
          ((CheckBox)localObject2).setVisibility(8);
          continue;
          label867:
          if ((this.nTp.bOQ()) || (this.nTp.bOO()) || (this.nTp.bOR()))
          {
            localObject1 = l.eQ(l.Vy(this.nTp.bPi().hiu), i);
            localObject3 = l.eQ(l.cG(this.nTp.bPi().hiu, 175), i);
            localObject4 = new StateListDrawable();
            ((StateListDrawable)localObject4).addState(new int[] { 16842919 }, (Drawable)localObject3);
            ((StateListDrawable)localObject4).addState(new int[0], (Drawable)localObject1);
            ((Button)localObject2).setBackgroundDrawable((Drawable)localObject4);
            ((Button)localObject2).setTextColor(this.nTt.getResources().getColor(2131101185));
            localObject1 = (LinearLayout.LayoutParams)((Button)localObject2).getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).width = -1;
            ((Button)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
            continue;
          }
          localObject1 = l.eQ(l.Vy(this.nTp.bPi().hiu), i);
          localObject3 = l.eQ(l.cG(this.nTp.bPi().hiu, 175), i);
          localObject4 = new StateListDrawable();
          ((StateListDrawable)localObject4).addState(new int[] { 16842919 }, (Drawable)localObject3);
          ((StateListDrawable)localObject4).addState(new int[0], (Drawable)localObject1);
          ((Button)localObject2).setBackgroundDrawable((Drawable)localObject4);
          ((Button)localObject2).setTextColor(this.nTt.getResources().getColor(2131101185));
          continue;
          label1140:
          this.okO.setEnabled(false);
          ((View)localObject1).setEnabled(false);
          ((Button)localObject2).setEnabled(false);
          if (this.nTp.bOP()) {}
          for (localObject1 = this.nTp.bPi().Eky;; localObject1 = this.okQ.bSF())
          {
            ((Button)localObject2).setText((CharSequence)localObject1);
            if (!this.nTp.bOP()) {
              break label1327;
            }
            ((Button)localObject2).setTextColor(l.cG(this.nTp.bPi().hiu, 125));
            ((Button)localObject2).setBackgroundDrawable(l.f(this.nTt, l.cG(this.nTp.bPi().hiu, 125), i));
            localObject1 = (LinearLayout.LayoutParams)this.okO.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).topMargin = this.nTt.getResources().getDimensionPixelSize(2131165958);
            this.okO.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.okO.findViewById(2131299164).setVisibility(8);
            break;
          }
          label1327:
          if ((this.nTp.bOQ()) || (this.nTp.bOO()) || (this.nTp.bOR()))
          {
            ((Button)localObject2).setTextColor(this.nTt.getResources().getColor(2131100469));
            ((Button)localObject2).setBackgroundDrawable(l.O(this.nTt, this.nTt.getResources().getColor(2131100081)));
            localObject1 = (LinearLayout.LayoutParams)((Button)localObject2).getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).width = -1;
            ((Button)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
            continue;
          }
          ((Button)localObject2).setTextColor(this.nTt.getResources().getColor(2131100469));
          ((Button)localObject2).setBackgroundDrawable(l.O(this.nTt, this.nTt.getResources().getColor(2131100081)));
          continue;
        }
        if (this.okP != null) {
          this.okP.setVisibility(8);
        }
      }
    }
    AppMethodBeat.o(113661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.b
 * JD-Core Version:    0.7.0.1
 */