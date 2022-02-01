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
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.be;
import com.tencent.mm.protocal.protobuf.blx;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public final class b
  extends i
{
  private View tFB;
  private TextView tFC;
  private g tFD;
  private com.tencent.mm.plugin.card.base.b tmU;
  private MMActivity tmY;
  
  public final void cKY()
  {
    AppMethodBeat.i(113662);
    this.tFB.setVisibility(8);
    AppMethodBeat.o(113662);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(113660);
    super.destroy();
    this.tmY = null;
    this.tFD = null;
    AppMethodBeat.o(113660);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113659);
    this.tmY = this.tFT.cIV();
    this.tFD = this.tFT.cIX();
    AppMethodBeat.o(113659);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113661);
    if (this.tFB == null)
    {
      this.tFB = ((ViewStub)findViewById(a.d.tba)).inflate();
      this.tFB.findViewById(a.d.duV).setOnClickListener(this.tFT.cIW());
    }
    this.tmU = this.tFT.cIS();
    this.tFD = this.tFT.cIX();
    boolean bool1 = this.tFD.cJY();
    boolean bool2 = this.tFD.cJZ();
    Object localObject2;
    Object localObject1;
    int i;
    Object localObject3;
    StateListDrawable localStateListDrawable;
    if (bool1)
    {
      this.tFB.setVisibility(0);
      Log.i("MicroMsg.CardAcceptView", "updateAcceptView() acceptViewVisible:" + bool1 + " acceptViewEnabled:" + bool2);
      localObject2 = (Button)this.tFB.findViewById(a.d.duV);
      localObject1 = this.tFB.findViewById(a.d.taZ);
      ((View)localObject1).setBackgroundDrawable(null);
      ((View)localObject1).setOnClickListener(null);
      i = this.tmY.getResources().getDimensionPixelSize(a.b.sZS);
      if (!bool2) {
        break label1142;
      }
      if (!TextUtils.isEmpty(this.tmU.cGs().SfX)) {
        ((Button)localObject2).setText(this.tmU.cGs().SfX);
      }
      if (!this.tmU.cFY()) {
        break label869;
      }
      ((Button)localObject2).setTextColor(l.arR(this.tmU.cGs().lmL));
      localObject1 = l.e(this.tmY, l.arR(this.tmU.cGs().lmL), i);
      localObject3 = l.fF(l.arR(this.tmU.cGs().lmL), i);
      localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject3);
      localStateListDrawable.addState(new int[0], (Drawable)localObject1);
      i = this.tmY.getResources().getColor(a.a.white);
      int j = l.arR(this.tmU.cGs().lmL);
      ((Button)localObject2).setBackgroundDrawable(localStateListDrawable);
      ((Button)localObject2).setTextColor(new ColorStateList(new int[][] { { 16842919, 16842910 }, new int[0] }, new int[] { i, j }));
      localObject1 = (LinearLayout.LayoutParams)this.tFB.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).topMargin = this.tmY.getResources().getDimensionPixelSize(a.b.sZC);
      this.tFB.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.tFB.findViewById(a.d.tfD).setVisibility(8);
      localObject1 = this.tFT.cJa();
      this.tFB.setBackgroundColor(this.tmY.getResources().getColor(a.a.white));
      localObject2 = (CheckBox)this.tFB.findViewById(a.d.tbX);
      if ((((f)localObject1).cGW() == null) || (!((f)localObject1).cGW().toj)) {
        break label851;
      }
      Log.i("MicroMsg.CardAcceptView", "updateFollowBox() show followbox");
      ((CheckBox)localObject2).setVisibility(0);
      localObject3 = this.tmU.cGs().Sgi;
      if ((localObject3 == null) || (TextUtils.isEmpty(((blx)localObject3).text))) {
        break label835;
      }
      ((CheckBox)localObject2).setText(((blx)localObject3).text);
      ((CheckBox)localObject2).setChecked(((f)localObject1).cGW().fXF);
      ((CheckBox)localObject2).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113658);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/plugin/card/ui/view/CardAcceptView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (((CheckBox)paramAnonymousView).isChecked()) {}
          for (this.tFE.cGW().fXF = true;; this.tFE.cGW().fXF = false)
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
      if ((!this.tmU.cFZ()) && (!this.tmU.cFX()))
      {
        if ((this.tmU.cGs().Sgj != null) && (!Util.isNullOrNil(this.tmU.cGs().Sgj.text)))
        {
          if (this.tFC == null) {
            this.tFC = ((TextView)this.tFB.findViewById(a.d.taX));
          }
          this.tFC.setText(this.tmU.cGs().Sgj.text);
          if (!Util.isNullOrNil(this.tmU.cGs().Sgj.url))
          {
            this.tFC.setOnClickListener(this.tFT.cIW());
            this.tFC.setTextColor(l.arR(this.tmU.cGs().lmL));
          }
          this.tFC.setVisibility(0);
          AppMethodBeat.o(113661);
          return;
          Log.i("MicroMsg.CardAcceptView", "updateAcceptView(), mAcceptCardView is Gone");
          this.tFB.setVisibility(8);
          AppMethodBeat.o(113661);
          return;
          label835:
          ((CheckBox)localObject2).setText(((f)localObject1).cGW().title);
          break;
          label851:
          Log.i("MicroMsg.CardAcceptView", "updateFollowBox() not show followbox");
          ((CheckBox)localObject2).setVisibility(8);
          continue;
          label869:
          if ((this.tmU.cFZ()) || (this.tmU.cFX()) || (this.tmU.cGa()))
          {
            localObject1 = l.fF(l.arR(this.tmU.cGs().lmL), i);
            localObject3 = l.fF(l.convertStringToRGB(this.tmU.cGs().lmL, 175), i);
            localStateListDrawable = new StateListDrawable();
            localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject3);
            localStateListDrawable.addState(new int[0], (Drawable)localObject1);
            ((Button)localObject2).setBackgroundDrawable(localStateListDrawable);
            ((Button)localObject2).setTextColor(this.tmY.getResources().getColor(a.a.white_text_color_selector));
            localObject1 = (LinearLayout.LayoutParams)((Button)localObject2).getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).width = -1;
            ((Button)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
            continue;
          }
          localObject1 = l.fF(l.arR(this.tmU.cGs().lmL), i);
          localObject3 = l.fF(l.convertStringToRGB(this.tmU.cGs().lmL, 175), i);
          localStateListDrawable = new StateListDrawable();
          localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject3);
          localStateListDrawable.addState(new int[0], (Drawable)localObject1);
          ((Button)localObject2).setBackgroundDrawable(localStateListDrawable);
          ((Button)localObject2).setTextColor(this.tmY.getResources().getColor(a.a.white_text_color_selector));
          continue;
          label1142:
          this.tFB.setEnabled(false);
          ((View)localObject1).setEnabled(false);
          ((Button)localObject2).setEnabled(false);
          if (this.tmU.cFY()) {}
          for (localObject1 = this.tmU.cGs().SfX;; localObject1 = this.tFD.cJR())
          {
            ((Button)localObject2).setText((CharSequence)localObject1);
            if (!this.tmU.cFY()) {
              break label1330;
            }
            ((Button)localObject2).setTextColor(l.convertStringToRGB(this.tmU.cGs().lmL, 125));
            ((Button)localObject2).setBackgroundDrawable(l.e(this.tmY, l.convertStringToRGB(this.tmU.cGs().lmL, 125), i));
            localObject1 = (LinearLayout.LayoutParams)this.tFB.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).topMargin = this.tmY.getResources().getDimensionPixelSize(a.b.sZD);
            this.tFB.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.tFB.findViewById(a.d.tfD).setVisibility(8);
            break;
          }
          label1330:
          if ((this.tmU.cFZ()) || (this.tmU.cFX()) || (this.tmU.cGa()))
          {
            ((Button)localObject2).setTextColor(this.tmY.getResources().getColor(a.a.grey_background_text_color));
            ((Button)localObject2).setBackgroundDrawable(l.Z(this.tmY, this.tmY.getResources().getColor(a.a.sZq)));
            localObject1 = (LinearLayout.LayoutParams)((Button)localObject2).getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).width = -1;
            ((Button)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
            continue;
          }
          ((Button)localObject2).setTextColor(this.tmY.getResources().getColor(a.a.grey_background_text_color));
          ((Button)localObject2).setBackgroundDrawable(l.Z(this.tmY, this.tmY.getResources().getColor(a.a.sZq)));
          continue;
        }
        if (this.tFC != null) {
          this.tFC.setVisibility(8);
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