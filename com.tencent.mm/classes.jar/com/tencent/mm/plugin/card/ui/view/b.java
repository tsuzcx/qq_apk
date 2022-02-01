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
import com.tencent.mm.protocal.protobuf.amg;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;

public final class b
  extends i
{
  private View nHO;
  private TextView nHP;
  private g nHQ;
  private com.tencent.mm.plugin.card.base.b nqp;
  private MMActivity nqt;
  
  public final void bMB()
  {
    AppMethodBeat.i(113662);
    this.nHO.setVisibility(8);
    AppMethodBeat.o(113662);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(113660);
    super.destroy();
    this.nqt = null;
    this.nHQ = null;
    AppMethodBeat.o(113660);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113659);
    this.nqt = this.nIg.bKw();
    this.nHQ = this.nIg.bKy();
    AppMethodBeat.o(113659);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113661);
    if (this.nHO == null)
    {
      this.nHO = ((ViewStub)findViewById(2131297720)).inflate();
      this.nHO.findViewById(2131297710).setOnClickListener(this.nIg.bKx());
    }
    this.nqp = this.nIg.bKt();
    this.nHQ = this.nIg.bKy();
    boolean bool1 = this.nHQ.bLz();
    boolean bool2 = this.nHQ.bLA();
    Object localObject2;
    Object localObject1;
    int i;
    Object localObject3;
    StateListDrawable localStateListDrawable;
    if (bool1)
    {
      this.nHO.setVisibility(0);
      ad.i("MicroMsg.CardAcceptView", "updateAcceptView() acceptViewVisible:" + bool1 + " acceptViewEnabled:" + bool2);
      localObject2 = (Button)this.nHO.findViewById(2131297710);
      localObject1 = this.nHO.findViewById(2131297719);
      ((View)localObject1).setBackgroundDrawable(null);
      ((View)localObject1).setOnClickListener(null);
      i = this.nqt.getResources().getDimensionPixelSize(2131165984);
      if (!bool2) {
        break label1132;
      }
      if (!TextUtils.isEmpty(this.nqp.bHV().CRN)) {
        ((Button)localObject2).setText(this.nqp.bHV().CRN);
      }
      if (!this.nqp.bHC()) {
        break label859;
      }
      ((Button)localObject2).setTextColor(l.Rm(this.nqp.bHV().gHT));
      localObject1 = l.d(this.nqt, l.Rm(this.nqp.bHV().gHT), i);
      localObject3 = l.eN(l.Rm(this.nqp.bHV().gHT), i);
      localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject3);
      localStateListDrawable.addState(new int[0], (Drawable)localObject1);
      i = this.nqt.getResources().getColor(2131101179);
      int j = l.Rm(this.nqp.bHV().gHT);
      ((Button)localObject2).setBackgroundDrawable(localStateListDrawable);
      ((Button)localObject2).setTextColor(new ColorStateList(new int[][] { { 16842919, 16842910 }, new int[0] }, new int[] { i, j }));
      localObject1 = (LinearLayout.LayoutParams)this.nHO.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).topMargin = this.nqt.getResources().getDimensionPixelSize(2131165957);
      this.nHO.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.nHO.findViewById(2131299164).setVisibility(8);
      localObject1 = this.nIg.bKB();
      this.nHO.setBackgroundColor(this.nqt.getResources().getColor(2131101179));
      localObject2 = (CheckBox)this.nHO.findViewById(2131297795);
      if ((((f)localObject1).bIz() == null) || (!((f)localObject1).bIz().nrE)) {
        break label841;
      }
      ad.i("MicroMsg.CardAcceptView", "updateFollowBox() show followbox");
      ((CheckBox)localObject2).setVisibility(0);
      localObject3 = this.nqp.bHV().CRY;
      if ((localObject3 == null) || (TextUtils.isEmpty(((amg)localObject3).text))) {
        break label825;
      }
      ((CheckBox)localObject2).setText(((amg)localObject3).text);
      ((CheckBox)localObject2).setChecked(((f)localObject1).bIz().dAt);
      ((CheckBox)localObject2).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113658);
          if (((CheckBox)paramAnonymousView).isChecked())
          {
            this.nHR.bIz().dAt = true;
            AppMethodBeat.o(113658);
            return;
          }
          this.nHR.bIz().dAt = false;
          AppMethodBeat.o(113658);
        }
      });
    }
    for (;;)
    {
      if ((!this.nqp.bHD()) && (!this.nqp.bHB()))
      {
        if ((this.nqp.bHV().CRZ != null) && (!bt.isNullOrNil(this.nqp.bHV().CRZ.text)))
        {
          if (this.nHP == null) {
            this.nHP = ((TextView)this.nHO.findViewById(2131297717));
          }
          this.nHP.setText(this.nqp.bHV().CRZ.text);
          if (!bt.isNullOrNil(this.nqp.bHV().CRZ.url))
          {
            this.nHP.setOnClickListener(this.nIg.bKx());
            this.nHP.setTextColor(l.Rm(this.nqp.bHV().gHT));
          }
          this.nHP.setVisibility(0);
          AppMethodBeat.o(113661);
          return;
          ad.i("MicroMsg.CardAcceptView", "updateAcceptView(), mAcceptCardView is Gone");
          this.nHO.setVisibility(8);
          AppMethodBeat.o(113661);
          return;
          label825:
          ((CheckBox)localObject2).setText(((f)localObject1).bIz().title);
          break;
          label841:
          ad.i("MicroMsg.CardAcceptView", "updateFollowBox() not show followbox");
          ((CheckBox)localObject2).setVisibility(8);
          continue;
          label859:
          if ((this.nqp.bHD()) || (this.nqp.bHB()) || (this.nqp.bHE()))
          {
            localObject1 = l.eN(l.Rm(this.nqp.bHV().gHT), i);
            localObject3 = l.eN(l.cB(this.nqp.bHV().gHT, 175), i);
            localStateListDrawable = new StateListDrawable();
            localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject3);
            localStateListDrawable.addState(new int[0], (Drawable)localObject1);
            ((Button)localObject2).setBackgroundDrawable(localStateListDrawable);
            ((Button)localObject2).setTextColor(this.nqt.getResources().getColor(2131101185));
            localObject1 = (LinearLayout.LayoutParams)((Button)localObject2).getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).width = -1;
            ((Button)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
            continue;
          }
          localObject1 = l.eN(l.Rm(this.nqp.bHV().gHT), i);
          localObject3 = l.eN(l.cB(this.nqp.bHV().gHT, 175), i);
          localStateListDrawable = new StateListDrawable();
          localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject3);
          localStateListDrawable.addState(new int[0], (Drawable)localObject1);
          ((Button)localObject2).setBackgroundDrawable(localStateListDrawable);
          ((Button)localObject2).setTextColor(this.nqt.getResources().getColor(2131101185));
          continue;
          label1132:
          this.nHO.setEnabled(false);
          ((View)localObject1).setEnabled(false);
          ((Button)localObject2).setEnabled(false);
          if (this.nqp.bHC()) {}
          for (localObject1 = this.nqp.bHV().CRN;; localObject1 = this.nHQ.bLs())
          {
            ((Button)localObject2).setText((CharSequence)localObject1);
            if (!this.nqp.bHC()) {
              break label1319;
            }
            ((Button)localObject2).setTextColor(l.cB(this.nqp.bHV().gHT, 125));
            ((Button)localObject2).setBackgroundDrawable(l.d(this.nqt, l.cB(this.nqp.bHV().gHT, 125), i));
            localObject1 = (LinearLayout.LayoutParams)this.nHO.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).topMargin = this.nqt.getResources().getDimensionPixelSize(2131165958);
            this.nHO.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.nHO.findViewById(2131299164).setVisibility(8);
            break;
          }
          label1319:
          if ((this.nqp.bHD()) || (this.nqp.bHB()) || (this.nqp.bHE()))
          {
            ((Button)localObject2).setTextColor(this.nqt.getResources().getColor(2131100469));
            ((Button)localObject2).setBackgroundDrawable(l.K(this.nqt, this.nqt.getResources().getColor(2131100081)));
            localObject1 = (LinearLayout.LayoutParams)((Button)localObject2).getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).width = -1;
            ((Button)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
            continue;
          }
          ((Button)localObject2).setTextColor(this.nqt.getResources().getColor(2131100469));
          ((Button)localObject2).setBackgroundDrawable(l.K(this.nqt, this.nqt.getResources().getColor(2131100081)));
          continue;
        }
        if (this.nHP != null) {
          this.nHP.setVisibility(8);
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