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
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.protocal.protobuf.yg;
import com.tencent.mm.ui.MMActivity;

public final class u
  extends i
{
  private View olB;
  
  public final void bTM()
  {
    AppMethodBeat.i(113708);
    if (this.olB != null) {
      this.olB.setVisibility(8);
    }
    AppMethodBeat.o(113708);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113707);
    if (this.olB == null) {
      this.olB = ((ViewStub)findViewById(2131297868)).inflate();
    }
    b localb = this.olg.bRG();
    MMActivity localMMActivity = this.olg.bRJ();
    Object localObject = localb.bPj().Ein;
    TextView localTextView1;
    TextView localTextView2;
    LinearLayout localLinearLayout;
    LinearLayout.LayoutParams localLayoutParams1;
    LinearLayout.LayoutParams localLayoutParams2;
    if (this.olB != null)
    {
      localTextView1 = (TextView)this.olB.findViewById(2131297869);
      localTextView1.setText(((yg)localObject).title);
      localTextView1.setTextColor(l.Vy(localb.bPi().hiu));
      localTextView2 = (TextView)this.olB.findViewById(2131297867);
      localLinearLayout = (LinearLayout)this.olB.findViewById(2131297922);
      localLayoutParams1 = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
      if (!localb.bOP()) {
        break label418;
      }
      localLayoutParams2 = (LinearLayout.LayoutParams)localTextView1.getLayoutParams();
      if (TextUtils.isEmpty(((yg)localObject).nUt)) {
        break label394;
      }
      localTextView2.setText(((yg)localObject).nUt);
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
      localTextView1.setBackgroundDrawable(l.h(localMMActivity, localb.bPi().hiu, i));
      localTextView1.setTextColor(l.ag(localMMActivity, localb.bPi().hiu));
      localLinearLayout.setBackgroundDrawable(null);
      localTextView1.setOnClickListener(this.olg.bRK());
      localLinearLayout.setLayoutParams(localLayoutParams1);
      localLinearLayout.invalidate();
      this.olB.invalidate();
      if (localb.bOP()) {
        localLinearLayout.getLayoutParams();
      }
      AppMethodBeat.o(113707);
      return;
      label394:
      localTextView2.setVisibility(8);
      localLayoutParams1.height = localMMActivity.getResources().getDimensionPixelOffset(2131165981);
    }
    label418:
    if (!TextUtils.isEmpty(((yg)localObject).nUt))
    {
      localTextView2.setText(((yg)localObject).nUt);
      localTextView2.setVisibility(0);
    }
    for (localLayoutParams1.height = localMMActivity.getResources().getDimensionPixelOffset(2131165994);; localLayoutParams1.height = localMMActivity.getResources().getDimensionPixelOffset(2131165995))
    {
      localLinearLayout.setOnClickListener(this.olg.bRK());
      break;
      localTextView2.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.u
 * JD-Core Version:    0.7.0.1
 */