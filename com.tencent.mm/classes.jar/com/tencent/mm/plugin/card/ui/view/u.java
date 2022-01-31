package com.tencent.mm.plugin.card.ui.view;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.ui.MMActivity;

public final class u
  extends i
{
  private View kBC;
  
  public final void bfq()
  {
    AppMethodBeat.i(88781);
    if (this.kBC != null) {
      this.kBC.setVisibility(8);
    }
    AppMethodBeat.o(88781);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(88780);
    if (this.kBC == null) {
      this.kBC = ((ViewStub)findViewById(2131822084)).inflate();
    }
    b localb = this.kBh.bdv();
    MMActivity localMMActivity = this.kBh.bdy();
    Object localObject = localb.bbe().wEb;
    TextView localTextView1;
    TextView localTextView2;
    LinearLayout localLinearLayout;
    LinearLayout.LayoutParams localLayoutParams1;
    LinearLayout.LayoutParams localLayoutParams2;
    if (this.kBC != null)
    {
      localTextView1 = (TextView)this.kBC.findViewById(2131822307);
      localTextView1.setText(((uo)localObject).title);
      localTextView1.setTextColor(l.IB(localb.bbd().color));
      localTextView2 = (TextView)this.kBC.findViewById(2131822308);
      localLinearLayout = (LinearLayout)this.kBC.findViewById(2131822306);
      localLayoutParams1 = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
      if (!localb.baL()) {
        break label418;
      }
      localLayoutParams2 = (LinearLayout.LayoutParams)localTextView1.getLayoutParams();
      if (TextUtils.isEmpty(((uo)localObject).kmo)) {
        break label394;
      }
      localTextView2.setText(((uo)localObject).kmo);
      localTextView2.setVisibility(0);
      localLayoutParams1.height = localMMActivity.getResources().getDimensionPixelOffset(2131428181);
      localLayoutParams2.bottomMargin = localMMActivity.getResources().getDimensionPixelSize(2131427496);
      localObject = (LinearLayout.LayoutParams)localTextView2.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = localMMActivity.getResources().getDimensionPixelSize(2131427496);
      localTextView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localTextView2.invalidate();
    }
    for (;;)
    {
      localLayoutParams2.height = localMMActivity.getResources().getDimensionPixelSize(2131428183);
      localTextView1.setLayoutParams(localLayoutParams2);
      localTextView1.invalidate();
      int i = localMMActivity.getResources().getDimensionPixelSize(2131428185);
      localTextView1.setBackgroundDrawable(l.g(localMMActivity, localb.bbd().color, i));
      localTextView1.setTextColor(l.ag(localMMActivity, localb.bbd().color));
      localLinearLayout.setBackgroundDrawable(null);
      localTextView1.setOnClickListener(this.kBh.bdz());
      localLinearLayout.setLayoutParams(localLayoutParams1);
      localLinearLayout.invalidate();
      this.kBC.invalidate();
      if (localb.baL()) {
        localLinearLayout.getLayoutParams();
      }
      AppMethodBeat.o(88780);
      return;
      label394:
      localTextView2.setVisibility(8);
      localLayoutParams1.height = localMMActivity.getResources().getDimensionPixelOffset(2131428182);
    }
    label418:
    if (!TextUtils.isEmpty(((uo)localObject).kmo))
    {
      localTextView2.setText(((uo)localObject).kmo);
      localTextView2.setVisibility(0);
    }
    for (localLayoutParams1.height = localMMActivity.getResources().getDimensionPixelOffset(2131428195);; localLayoutParams1.height = localMMActivity.getResources().getDimensionPixelOffset(2131428196))
    {
      localLinearLayout.setOnClickListener(this.kBh.bdz());
      break;
      localTextView2.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.u
 * JD-Core Version:    0.7.0.1
 */