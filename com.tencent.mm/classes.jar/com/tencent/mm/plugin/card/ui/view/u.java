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
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.ui.MMActivity;

public final class u
  extends i
{
  private View qks;
  
  public final void cxw()
  {
    AppMethodBeat.i(113708);
    if (this.qks != null) {
      this.qks.setVisibility(8);
    }
    AppMethodBeat.o(113708);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113707);
    if (this.qks == null) {
      this.qks = ((ViewStub)findViewById(2131298185)).inflate();
    }
    b localb = this.qjX.cvq();
    MMActivity localMMActivity = this.qjX.cvt();
    Object localObject = localb.csR().Lcz;
    TextView localTextView1;
    TextView localTextView2;
    LinearLayout localLinearLayout;
    LinearLayout.LayoutParams localLayoutParams1;
    LinearLayout.LayoutParams localLayoutParams2;
    if (this.qks != null)
    {
      localTextView1 = (TextView)this.qks.findViewById(2131298186);
      localTextView1.setText(((abz)localObject).title);
      localTextView1.setTextColor(l.ake(localb.csQ().ixw));
      localTextView2 = (TextView)this.qks.findViewById(2131298184);
      localLinearLayout = (LinearLayout)this.qks.findViewById(2131298240);
      localLayoutParams1 = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
      if (!localb.csx()) {
        break label418;
      }
      localLayoutParams2 = (LinearLayout.LayoutParams)localTextView1.getLayoutParams();
      if (TextUtils.isEmpty(((abz)localObject).pRZ)) {
        break label394;
      }
      localTextView2.setText(((abz)localObject).pRZ);
      localTextView2.setVisibility(0);
      localLayoutParams1.height = localMMActivity.getResources().getDimensionPixelOffset(2131166012);
      localLayoutParams2.bottomMargin = localMMActivity.getResources().getDimensionPixelSize(2131165190);
      localObject = (LinearLayout.LayoutParams)localTextView2.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = localMMActivity.getResources().getDimensionPixelSize(2131165190);
      localTextView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localTextView2.invalidate();
    }
    for (;;)
    {
      localLayoutParams2.height = localMMActivity.getResources().getDimensionPixelSize(2131166014);
      localTextView1.setLayoutParams(localLayoutParams2);
      localTextView1.invalidate();
      int i = localMMActivity.getResources().getDimensionPixelSize(2131166016);
      localTextView1.setBackgroundDrawable(l.h(localMMActivity, localb.csQ().ixw, i));
      localTextView1.setTextColor(l.ap(localMMActivity, localb.csQ().ixw));
      localLinearLayout.setBackgroundDrawable(null);
      localTextView1.setOnClickListener(this.qjX.cvu());
      localLinearLayout.setLayoutParams(localLayoutParams1);
      localLinearLayout.invalidate();
      this.qks.invalidate();
      if (localb.csx()) {
        localLinearLayout.getLayoutParams();
      }
      AppMethodBeat.o(113707);
      return;
      label394:
      localTextView2.setVisibility(8);
      localLayoutParams1.height = localMMActivity.getResources().getDimensionPixelOffset(2131166013);
    }
    label418:
    if (!TextUtils.isEmpty(((abz)localObject).pRZ))
    {
      localTextView2.setText(((abz)localObject).pRZ);
      localTextView2.setVisibility(0);
    }
    for (localLayoutParams1.height = localMMActivity.getResources().getDimensionPixelOffset(2131166026);; localLayoutParams1.height = localMMActivity.getResources().getDimensionPixelOffset(2131166027))
    {
      localLinearLayout.setOnClickListener(this.qjX.cvu());
      break;
      localTextView2.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.u
 * JD-Core Version:    0.7.0.1
 */