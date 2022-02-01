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
import com.tencent.mm.protocal.protobuf.bet;
import com.tencent.mm.protocal.protobuf.bg;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public final class b
  extends i
{
  private com.tencent.mm.plugin.card.base.b pQV;
  private MMActivity pQZ;
  private View qjF;
  private TextView qjG;
  private g qjH;
  
  public final void cxw()
  {
    AppMethodBeat.i(113662);
    this.qjF.setVisibility(8);
    AppMethodBeat.o(113662);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(113660);
    super.destroy();
    this.pQZ = null;
    this.qjH = null;
    AppMethodBeat.o(113660);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113659);
    this.pQZ = this.qjX.cvt();
    this.qjH = this.qjX.cvv();
    AppMethodBeat.o(113659);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113661);
    if (this.qjF == null)
    {
      this.qjF = ((ViewStub)findViewById(2131298024)).inflate();
      this.qjF.findViewById(2131298014).setOnClickListener(this.qjX.cvu());
    }
    this.pQV = this.qjX.cvq();
    this.qjH = this.qjX.cvv();
    boolean bool1 = this.qjH.cww();
    boolean bool2 = this.qjH.cwx();
    Object localObject2;
    Object localObject1;
    int i;
    Object localObject3;
    StateListDrawable localStateListDrawable;
    if (bool1)
    {
      this.qjF.setVisibility(0);
      Log.i("MicroMsg.CardAcceptView", "updateAcceptView() acceptViewVisible:" + bool1 + " acceptViewEnabled:" + bool2);
      localObject2 = (Button)this.qjF.findViewById(2131298014);
      localObject1 = this.qjF.findViewById(2131298023);
      ((View)localObject1).setBackgroundDrawable(null);
      ((View)localObject1).setOnClickListener(null);
      i = this.pQZ.getResources().getDimensionPixelSize(2131166016);
      if (!bool2) {
        break label1132;
      }
      if (!TextUtils.isEmpty(this.pQV.csQ().LeJ)) {
        ((Button)localObject2).setText(this.pQV.csQ().LeJ);
      }
      if (!this.pQV.csx()) {
        break label859;
      }
      ((Button)localObject2).setTextColor(l.ake(this.pQV.csQ().ixw));
      localObject1 = l.e(this.pQZ, l.ake(this.pQV.csQ().ixw), i);
      localObject3 = l.fi(l.ake(this.pQV.csQ().ixw), i);
      localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject3);
      localStateListDrawable.addState(new int[0], (Drawable)localObject1);
      i = this.pQZ.getResources().getColor(2131101424);
      int j = l.ake(this.pQV.csQ().ixw);
      ((Button)localObject2).setBackgroundDrawable(localStateListDrawable);
      ((Button)localObject2).setTextColor(new ColorStateList(new int[][] { { 16842919, 16842910 }, new int[0] }, new int[] { i, j }));
      localObject1 = (LinearLayout.LayoutParams)this.qjF.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).topMargin = this.pQZ.getResources().getDimensionPixelSize(2131165989);
      this.qjF.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.qjF.findViewById(2131299708).setVisibility(8);
      localObject1 = this.qjX.cvy();
      this.qjF.setBackgroundColor(this.pQZ.getResources().getColor(2131101424));
      localObject2 = (CheckBox)this.qjF.findViewById(2131298110);
      if ((((f)localObject1).ctu() == null) || (!((f)localObject1).ctu().pSk)) {
        break label841;
      }
      Log.i("MicroMsg.CardAcceptView", "updateFollowBox() show followbox");
      ((CheckBox)localObject2).setVisibility(0);
      localObject3 = this.pQV.csQ().LeU;
      if ((localObject3 == null) || (TextUtils.isEmpty(((bet)localObject3).text))) {
        break label825;
      }
      ((CheckBox)localObject2).setText(((bet)localObject3).text);
      ((CheckBox)localObject2).setChecked(((f)localObject1).ctu().edw);
      ((CheckBox)localObject2).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113658);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/card/ui/view/CardAcceptView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (((CheckBox)paramAnonymousView).isChecked()) {}
          for (this.qjI.ctu().edw = true;; this.qjI.ctu().edw = false)
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
      if ((!this.pQV.csy()) && (!this.pQV.csw()))
      {
        if ((this.pQV.csQ().LeV != null) && (!Util.isNullOrNil(this.pQV.csQ().LeV.text)))
        {
          if (this.qjG == null) {
            this.qjG = ((TextView)this.qjF.findViewById(2131298021));
          }
          this.qjG.setText(this.pQV.csQ().LeV.text);
          if (!Util.isNullOrNil(this.pQV.csQ().LeV.url))
          {
            this.qjG.setOnClickListener(this.qjX.cvu());
            this.qjG.setTextColor(l.ake(this.pQV.csQ().ixw));
          }
          this.qjG.setVisibility(0);
          AppMethodBeat.o(113661);
          return;
          Log.i("MicroMsg.CardAcceptView", "updateAcceptView(), mAcceptCardView is Gone");
          this.qjF.setVisibility(8);
          AppMethodBeat.o(113661);
          return;
          label825:
          ((CheckBox)localObject2).setText(((f)localObject1).ctu().title);
          break;
          label841:
          Log.i("MicroMsg.CardAcceptView", "updateFollowBox() not show followbox");
          ((CheckBox)localObject2).setVisibility(8);
          continue;
          label859:
          if ((this.pQV.csy()) || (this.pQV.csw()) || (this.pQV.csz()))
          {
            localObject1 = l.fi(l.ake(this.pQV.csQ().ixw), i);
            localObject3 = l.fi(l.convertStringToRGB(this.pQV.csQ().ixw, 175), i);
            localStateListDrawable = new StateListDrawable();
            localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject3);
            localStateListDrawable.addState(new int[0], (Drawable)localObject1);
            ((Button)localObject2).setBackgroundDrawable(localStateListDrawable);
            ((Button)localObject2).setTextColor(this.pQZ.getResources().getColor(2131101430));
            localObject1 = (LinearLayout.LayoutParams)((Button)localObject2).getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).width = -1;
            ((Button)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
            continue;
          }
          localObject1 = l.fi(l.ake(this.pQV.csQ().ixw), i);
          localObject3 = l.fi(l.convertStringToRGB(this.pQV.csQ().ixw, 175), i);
          localStateListDrawable = new StateListDrawable();
          localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject3);
          localStateListDrawable.addState(new int[0], (Drawable)localObject1);
          ((Button)localObject2).setBackgroundDrawable(localStateListDrawable);
          ((Button)localObject2).setTextColor(this.pQZ.getResources().getColor(2131101430));
          continue;
          label1132:
          this.qjF.setEnabled(false);
          ((View)localObject1).setEnabled(false);
          ((Button)localObject2).setEnabled(false);
          if (this.pQV.csx()) {}
          for (localObject1 = this.pQV.csQ().LeJ;; localObject1 = this.qjH.cwp())
          {
            ((Button)localObject2).setText((CharSequence)localObject1);
            if (!this.pQV.csx()) {
              break label1319;
            }
            ((Button)localObject2).setTextColor(l.convertStringToRGB(this.pQV.csQ().ixw, 125));
            ((Button)localObject2).setBackgroundDrawable(l.e(this.pQZ, l.convertStringToRGB(this.pQV.csQ().ixw, 125), i));
            localObject1 = (LinearLayout.LayoutParams)this.qjF.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).topMargin = this.pQZ.getResources().getDimensionPixelSize(2131165990);
            this.qjF.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.qjF.findViewById(2131299708).setVisibility(8);
            break;
          }
          label1319:
          if ((this.pQV.csy()) || (this.pQV.csw()) || (this.pQV.csz()))
          {
            ((Button)localObject2).setTextColor(this.pQZ.getResources().getColor(2131100571));
            ((Button)localObject2).setBackgroundDrawable(l.U(this.pQZ, this.pQZ.getResources().getColor(2131100112)));
            localObject1 = (LinearLayout.LayoutParams)((Button)localObject2).getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).width = -1;
            ((Button)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
            continue;
          }
          ((Button)localObject2).setTextColor(this.pQZ.getResources().getColor(2131100571));
          ((Button)localObject2).setBackgroundDrawable(l.U(this.pQZ, this.pQZ.getResources().getColor(2131100112)));
          continue;
        }
        if (this.qjG != null) {
          this.qjG.setVisibility(8);
        }
      }
    }
    AppMethodBeat.o(113661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.b
 * JD-Core Version:    0.7.0.1
 */