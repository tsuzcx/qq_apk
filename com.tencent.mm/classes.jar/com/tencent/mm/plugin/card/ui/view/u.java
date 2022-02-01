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
import com.tencent.mm.protocal.protobuf.aai;
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.ui.MMActivity;

public final class u
  extends i
{
  private View oVy;
  
  public final void bZG()
  {
    AppMethodBeat.i(113708);
    if (this.oVy != null) {
      this.oVy.setVisibility(8);
    }
    AppMethodBeat.o(113708);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113707);
    if (this.oVy == null) {
      this.oVy = ((ViewStub)findViewById(2131297868)).inflate();
    }
    b localb = this.oVd.bXA();
    MMActivity localMMActivity = this.oVd.bXD();
    Object localObject = localb.bVd().GhW;
    TextView localTextView1;
    TextView localTextView2;
    LinearLayout localLinearLayout;
    LinearLayout.LayoutParams localLayoutParams1;
    LinearLayout.LayoutParams localLayoutParams2;
    if (this.oVy != null)
    {
      localTextView1 = (TextView)this.oVy.findViewById(2131297869);
      localTextView1.setText(((aai)localObject).title);
      localTextView1.setTextColor(l.ZY(localb.bVc().hDr));
      localTextView2 = (TextView)this.oVy.findViewById(2131297867);
      localLinearLayout = (LinearLayout)this.oVy.findViewById(2131297922);
      localLayoutParams1 = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
      if (!localb.bUJ()) {
        break label418;
      }
      localLayoutParams2 = (LinearLayout.LayoutParams)localTextView1.getLayoutParams();
      if (TextUtils.isEmpty(((aai)localObject).oEq)) {
        break label394;
      }
      localTextView2.setText(((aai)localObject).oEq);
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
      localTextView1.setBackgroundDrawable(l.h(localMMActivity, localb.bVc().hDr, i));
      localTextView1.setTextColor(l.ah(localMMActivity, localb.bVc().hDr));
      localLinearLayout.setBackgroundDrawable(null);
      localTextView1.setOnClickListener(this.oVd.bXE());
      localLinearLayout.setLayoutParams(localLayoutParams1);
      localLinearLayout.invalidate();
      this.oVy.invalidate();
      if (localb.bUJ()) {
        localLinearLayout.getLayoutParams();
      }
      AppMethodBeat.o(113707);
      return;
      label394:
      localTextView2.setVisibility(8);
      localLayoutParams1.height = localMMActivity.getResources().getDimensionPixelOffset(2131165981);
    }
    label418:
    if (!TextUtils.isEmpty(((aai)localObject).oEq))
    {
      localTextView2.setText(((aai)localObject).oEq);
      localTextView2.setVisibility(0);
    }
    for (localLayoutParams1.height = localMMActivity.getResources().getDimensionPixelOffset(2131165994);; localLayoutParams1.height = localMMActivity.getResources().getDimensionPixelOffset(2131165995))
    {
      localLinearLayout.setOnClickListener(this.oVd.bXE());
      break;
      localTextView2.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.u
 * JD-Core Version:    0.7.0.1
 */