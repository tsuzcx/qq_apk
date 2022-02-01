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
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.ui.MMActivity;

public final class u
  extends i
{
  private View oOW;
  
  public final void bYr()
  {
    AppMethodBeat.i(113708);
    if (this.oOW != null) {
      this.oOW.setVisibility(8);
    }
    AppMethodBeat.o(113708);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113707);
    if (this.oOW == null) {
      this.oOW = ((ViewStub)findViewById(2131297868)).inflate();
    }
    b localb = this.oOB.bWl();
    MMActivity localMMActivity = this.oOB.bWo();
    Object localObject = localb.bTO().FPx;
    TextView localTextView1;
    TextView localTextView2;
    LinearLayout localLinearLayout;
    LinearLayout.LayoutParams localLayoutParams1;
    LinearLayout.LayoutParams localLayoutParams2;
    if (this.oOW != null)
    {
      localTextView1 = (TextView)this.oOW.findViewById(2131297869);
      localTextView1.setText(((aaf)localObject).title);
      localTextView1.setTextColor(l.Zh(localb.bTN().hAD));
      localTextView2 = (TextView)this.oOW.findViewById(2131297867);
      localLinearLayout = (LinearLayout)this.oOW.findViewById(2131297922);
      localLayoutParams1 = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
      if (!localb.bTu()) {
        break label418;
      }
      localLayoutParams2 = (LinearLayout.LayoutParams)localTextView1.getLayoutParams();
      if (TextUtils.isEmpty(((aaf)localObject).oxO)) {
        break label394;
      }
      localTextView2.setText(((aaf)localObject).oxO);
      localTextView2.setVisibility(0);
      localLayoutParams1.height = localMMActivity.getResources().getDimensionPixelOffset(2131165980);
      localLayoutParams2.bottomMargin = localMMActivity.getResources().getDimensionPixelSize(2131165187);
      localObject = (LinearLayout.LayoutParams)localTextView2.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = localMMActivity.getResources().getDimensionPixelSize(2131165187);
      localTextView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localTextView2.invalidate();
    }
    for (;;)
    {
      localLayoutParams2.height = localMMActivity.getResources().getDimensionPixelSize(2131165982);
      localTextView1.setLayoutParams(localLayoutParams2);
      localTextView1.invalidate();
      int i = localMMActivity.getResources().getDimensionPixelSize(2131165984);
      localTextView1.setBackgroundDrawable(l.h(localMMActivity, localb.bTN().hAD, i));
      localTextView1.setTextColor(l.af(localMMActivity, localb.bTN().hAD));
      localLinearLayout.setBackgroundDrawable(null);
      localTextView1.setOnClickListener(this.oOB.bWp());
      localLinearLayout.setLayoutParams(localLayoutParams1);
      localLinearLayout.invalidate();
      this.oOW.invalidate();
      if (localb.bTu()) {
        localLinearLayout.getLayoutParams();
      }
      AppMethodBeat.o(113707);
      return;
      label394:
      localTextView2.setVisibility(8);
      localLayoutParams1.height = localMMActivity.getResources().getDimensionPixelOffset(2131165981);
    }
    label418:
    if (!TextUtils.isEmpty(((aaf)localObject).oxO))
    {
      localTextView2.setText(((aaf)localObject).oxO);
      localTextView2.setVisibility(0);
    }
    for (localLayoutParams1.height = localMMActivity.getResources().getDimensionPixelOffset(2131165994);; localLayoutParams1.height = localMMActivity.getResources().getDimensionPixelOffset(2131165995))
    {
      localLinearLayout.setOnClickListener(this.oOB.bWp());
      break;
      localTextView2.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.u
 * JD-Core Version:    0.7.0.1
 */