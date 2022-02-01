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
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.ui.MMActivity;

public final class u
  extends i
{
  private View tGo;
  
  public final void cKY()
  {
    AppMethodBeat.i(113708);
    if (this.tGo != null) {
      this.tGo.setVisibility(8);
    }
    AppMethodBeat.o(113708);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113707);
    if (this.tGo == null) {
      this.tGo = ((ViewStub)findViewById(a.d.tcZ)).inflate();
    }
    b localb = this.tFT.cIS();
    MMActivity localMMActivity = this.tFT.cIV();
    Object localObject = localb.cGt().SdM;
    TextView localTextView1;
    TextView localTextView2;
    LinearLayout localLinearLayout;
    LinearLayout.LayoutParams localLayoutParams1;
    LinearLayout.LayoutParams localLayoutParams2;
    if (this.tGo != null)
    {
      localTextView1 = (TextView)this.tGo.findViewById(a.d.tda);
      localTextView1.setText(((acg)localObject).title);
      localTextView1.setTextColor(l.arR(localb.cGs().lmL));
      localTextView2 = (TextView)this.tGo.findViewById(a.d.tcY);
      localLinearLayout = (LinearLayout)this.tGo.findViewById(a.d.tdJ);
      localLayoutParams1 = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
      if (!localb.cFY()) {
        break label428;
      }
      localLayoutParams2 = (LinearLayout.LayoutParams)localTextView1.getLayoutParams();
      if (TextUtils.isEmpty(((acg)localObject).tnZ)) {
        break label403;
      }
      localTextView2.setText(((acg)localObject).tnZ);
      localTextView2.setVisibility(0);
      localLayoutParams1.height = localMMActivity.getResources().getDimensionPixelOffset(a.b.sZO);
      localLayoutParams2.bottomMargin = localMMActivity.getResources().getDimensionPixelSize(a.b.BasicPaddingSize);
      localObject = (LinearLayout.LayoutParams)localTextView2.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = localMMActivity.getResources().getDimensionPixelSize(a.b.BasicPaddingSize);
      localTextView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localTextView2.invalidate();
    }
    for (;;)
    {
      localLayoutParams2.height = localMMActivity.getResources().getDimensionPixelSize(a.b.sZQ);
      localTextView1.setLayoutParams(localLayoutParams2);
      localTextView1.invalidate();
      int i = localMMActivity.getResources().getDimensionPixelSize(a.b.sZS);
      localTextView1.setBackgroundDrawable(l.g(localMMActivity, localb.cGs().lmL, i));
      localTextView1.setTextColor(l.ap(localMMActivity, localb.cGs().lmL));
      localLinearLayout.setBackgroundDrawable(null);
      localTextView1.setOnClickListener(this.tFT.cIW());
      localLinearLayout.setLayoutParams(localLayoutParams1);
      localLinearLayout.invalidate();
      this.tGo.invalidate();
      if (localb.cFY()) {
        localLinearLayout.getLayoutParams();
      }
      AppMethodBeat.o(113707);
      return;
      label403:
      localTextView2.setVisibility(8);
      localLayoutParams1.height = localMMActivity.getResources().getDimensionPixelOffset(a.b.sZP);
    }
    label428:
    if (!TextUtils.isEmpty(((acg)localObject).tnZ))
    {
      localTextView2.setText(((acg)localObject).tnZ);
      localTextView2.setVisibility(0);
    }
    for (localLayoutParams1.height = localMMActivity.getResources().getDimensionPixelOffset(a.b.sZX);; localLayoutParams1.height = localMMActivity.getResources().getDimensionPixelOffset(a.b.sZY))
    {
      localLinearLayout.setOnClickListener(this.tFT.cIW());
      break;
      localTextView2.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.u
 * JD-Core Version:    0.7.0.1
 */