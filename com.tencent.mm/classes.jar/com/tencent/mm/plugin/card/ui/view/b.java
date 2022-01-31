package com.tencent.mm.plugin.card.ui.view;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
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
import com.tencent.mm.protocal.protobuf.adv;
import com.tencent.mm.protocal.protobuf.ax;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public final class b
  extends i
{
  private MMActivity jpX;
  private View kAP;
  private TextView kAQ;
  private g kAR;
  private com.tencent.mm.plugin.card.base.b klk;
  
  public final void bfq()
  {
    AppMethodBeat.i(88735);
    this.kAP.setVisibility(8);
    AppMethodBeat.o(88735);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(88733);
    super.destroy();
    this.jpX = null;
    this.kAR = null;
    AppMethodBeat.o(88733);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(88732);
    this.jpX = this.kBh.bdy();
    this.kAR = this.kBh.bdA();
    AppMethodBeat.o(88732);
  }
  
  public final void update()
  {
    AppMethodBeat.i(88734);
    if (this.kAP == null)
    {
      this.kAP = ((ViewStub)findViewById(2131822080)).inflate();
      this.kAP.findViewById(2131821984).setOnClickListener(this.kBh.bdz());
    }
    this.klk = this.kBh.bdv();
    this.kAR = this.kBh.bdA();
    boolean bool1 = this.kAR.beD();
    boolean bool2 = this.kAR.beE();
    Object localObject2;
    Object localObject1;
    int i;
    Object localObject3;
    StateListDrawable localStateListDrawable;
    if (bool1)
    {
      this.kAP.setVisibility(0);
      ab.i("MicroMsg.CardAcceptView", "updateAcceptView() acceptViewVisible:" + bool1 + " acceptViewEnabled:" + bool2);
      localObject2 = (Button)this.kAP.findViewById(2131821984);
      localObject1 = this.kAP.findViewById(2131821983);
      ((View)localObject1).setBackgroundDrawable(null);
      ((View)localObject1).setOnClickListener(null);
      i = this.jpX.getResources().getDimensionPixelSize(2131428185);
      if (!bool2) {
        break label1112;
      }
      if (!TextUtils.isEmpty(this.klk.bbd().wGi)) {
        ((Button)localObject2).setText(this.klk.bbd().wGi);
      }
      if (!this.klk.baL()) {
        break label839;
      }
      ((Button)localObject2).setTextColor(l.IB(this.klk.bbd().color));
      localObject1 = l.b(this.jpX, l.IB(this.klk.bbd().color), i);
      localObject3 = l.dR(l.IB(this.klk.bbd().color), i);
      localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject3);
      localStateListDrawable.addState(new int[0], (Drawable)localObject1);
      i = this.jpX.getResources().getColor(2131690709);
      int j = l.IB(this.klk.bbd().color);
      ((Button)localObject2).setBackgroundDrawable(localStateListDrawable);
      ((Button)localObject2).setTextColor(new ColorStateList(new int[][] { { 16842919, 16842910 }, new int[0] }, new int[] { i, j }));
      localObject1 = (LinearLayout.LayoutParams)this.kAP.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).topMargin = this.jpX.getResources().getDimensionPixelSize(2131428158);
      this.kAP.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.kAP.findViewById(2131821993).setVisibility(8);
      localObject1 = this.kBh.bdD();
      localObject2 = (CheckBox)this.kAP.findViewById(2131821994);
      if ((((f)localObject1).bbH() == null) || (!((f)localObject1).bbH().kmz)) {
        break label821;
      }
      ab.i("MicroMsg.CardAcceptView", "updateFollowBox() show followbox");
      ((CheckBox)localObject2).setVisibility(0);
      localObject3 = this.klk.bbd().wGt;
      if ((localObject3 == null) || (TextUtils.isEmpty(((adv)localObject3).text))) {
        break label805;
      }
      ((CheckBox)localObject2).setText(((adv)localObject3).text);
      ((CheckBox)localObject2).setChecked(((f)localObject1).bbH().cJz);
      ((CheckBox)localObject2).setOnClickListener(new b.1(this, (f)localObject1));
    }
    for (;;)
    {
      if ((!this.klk.baM()) && (!this.klk.baK()))
      {
        if ((this.klk.bbd().wGu != null) && (!bo.isNullOrNil(this.klk.bbd().wGu.text)))
        {
          if (this.kAQ == null) {
            this.kAQ = ((TextView)this.kAP.findViewById(2131821992));
          }
          this.kAQ.setText(this.klk.bbd().wGu.text);
          if (!bo.isNullOrNil(this.klk.bbd().wGu.url))
          {
            this.kAQ.setOnClickListener(this.kBh.bdz());
            this.kAQ.setTextColor(l.IB(this.klk.bbd().color));
          }
          this.kAQ.setVisibility(0);
          AppMethodBeat.o(88734);
          return;
          ab.i("MicroMsg.CardAcceptView", "updateAcceptView(), mAcceptCardView is Gone");
          this.kAP.setVisibility(8);
          AppMethodBeat.o(88734);
          return;
          label805:
          ((CheckBox)localObject2).setText(((f)localObject1).bbH().title);
          break;
          label821:
          ab.i("MicroMsg.CardAcceptView", "updateFollowBox() not show followbox");
          ((CheckBox)localObject2).setVisibility(8);
          continue;
          label839:
          if ((this.klk.baM()) || (this.klk.baK()) || (this.klk.baN()))
          {
            localObject1 = l.dR(l.IB(this.klk.bbd().color), i);
            localObject3 = l.dR(l.bS(this.klk.bbd().color, 175), i);
            localStateListDrawable = new StateListDrawable();
            localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject3);
            localStateListDrawable.addState(new int[0], (Drawable)localObject1);
            ((Button)localObject2).setBackgroundDrawable(localStateListDrawable);
            ((Button)localObject2).setTextColor(this.jpX.getResources().getColor(2131690799));
            localObject1 = (LinearLayout.LayoutParams)((Button)localObject2).getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).width = -1;
            ((Button)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
            continue;
          }
          localObject1 = l.dR(l.IB(this.klk.bbd().color), i);
          localObject3 = l.dR(l.bS(this.klk.bbd().color, 175), i);
          localStateListDrawable = new StateListDrawable();
          localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject3);
          localStateListDrawable.addState(new int[0], (Drawable)localObject1);
          ((Button)localObject2).setBackgroundDrawable(localStateListDrawable);
          ((Button)localObject2).setTextColor(this.jpX.getResources().getColor(2131690799));
          continue;
          label1112:
          this.kAP.setEnabled(false);
          ((View)localObject1).setEnabled(false);
          ((Button)localObject2).setEnabled(false);
          if (this.klk.baL()) {}
          for (localObject1 = this.klk.bbd().wGi;; localObject1 = this.kAR.bew())
          {
            ((Button)localObject2).setText((CharSequence)localObject1);
            if (!this.klk.baL()) {
              break label1299;
            }
            ((Button)localObject2).setTextColor(l.bS(this.klk.bbd().color, 125));
            ((Button)localObject2).setBackgroundDrawable(l.b(this.jpX, l.bS(this.klk.bbd().color, 125), i));
            localObject1 = (LinearLayout.LayoutParams)this.kAP.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).topMargin = this.jpX.getResources().getDimensionPixelSize(2131428159);
            this.kAP.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.kAP.findViewById(2131821993).setVisibility(8);
            break;
          }
          label1299:
          if ((this.klk.baM()) || (this.klk.baK()) || (this.klk.baN()))
          {
            ((Button)localObject2).setTextColor(this.jpX.getResources().getColor(2131690143));
            ((Button)localObject2).setBackgroundDrawable(l.I(this.jpX, this.jpX.getResources().getColor(2131689821)));
            localObject1 = (LinearLayout.LayoutParams)((Button)localObject2).getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).width = -1;
            ((Button)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
            continue;
          }
          ((Button)localObject2).setTextColor(this.jpX.getResources().getColor(2131690143));
          ((Button)localObject2).setBackgroundDrawable(l.I(this.jpX, this.jpX.getResources().getColor(2131689821)));
          continue;
        }
        if (this.kAQ != null) {
          this.kAQ.setVisibility(8);
        }
      }
    }
    AppMethodBeat.o(88734);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.b
 * JD-Core Version:    0.7.0.1
 */