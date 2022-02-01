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
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.ui.MMActivity;

public final class u
  extends i
{
  private View wJN;
  
  public final void doE()
  {
    AppMethodBeat.i(113708);
    if (this.wJN != null) {
      this.wJN.setVisibility(8);
    }
    AppMethodBeat.o(113708);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113707);
    if (this.wJN == null) {
      this.wJN = ((ViewStub)findViewById(a.d.whn)).inflate();
    }
    b localb = this.wJs.dmk();
    MMActivity localMMActivity = this.wJs.dmn();
    Object localObject = localb.djL().ZbG;
    TextView localTextView1;
    TextView localTextView2;
    LinearLayout localLinearLayout;
    LinearLayout.LayoutParams localLayoutParams1;
    LinearLayout.LayoutParams localLayoutParams2;
    if (this.wJN != null)
    {
      localTextView1 = (TextView)this.wJN.findViewById(a.d.who);
      localTextView1.setText(((aek)localObject).title);
      localTextView1.setTextColor(l.alv(localb.djK().nRQ));
      localTextView2 = (TextView)this.wJN.findViewById(a.d.whm);
      localLinearLayout = (LinearLayout)this.wJN.findViewById(a.d.whX);
      localLayoutParams1 = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
      if (!localb.djq()) {
        break label422;
      }
      localLayoutParams2 = (LinearLayout.LayoutParams)localTextView1.getLayoutParams();
      if (TextUtils.isEmpty(((aek)localObject).wsA)) {
        break label397;
      }
      localTextView2.setText(((aek)localObject).wsA);
      localTextView2.setVisibility(0);
      localLayoutParams1.height = localMMActivity.getResources().getDimensionPixelOffset(a.b.wdV);
      localLayoutParams2.bottomMargin = localMMActivity.getResources().getDimensionPixelSize(a.b.BasicPaddingSize);
      localObject = (LinearLayout.LayoutParams)localTextView2.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = localMMActivity.getResources().getDimensionPixelSize(a.b.BasicPaddingSize);
      localTextView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localTextView2.invalidate();
    }
    for (;;)
    {
      localLayoutParams2.height = localMMActivity.getResources().getDimensionPixelSize(a.b.wdX);
      localTextView1.setLayoutParams(localLayoutParams2);
      localTextView1.invalidate();
      int i = localMMActivity.getResources().getDimensionPixelSize(a.b.wdZ);
      localTextView1.setBackgroundDrawable(l.g(localMMActivity, localb.djK().nRQ, i));
      localTextView1.setTextColor(l.aq(localMMActivity, localb.djK().nRQ));
      localLinearLayout.setBackgroundDrawable(null);
      localTextView1.setOnClickListener(this.wJs.dmo());
      localLinearLayout.setLayoutParams(localLayoutParams1);
      localLinearLayout.invalidate();
      this.wJN.invalidate();
      if (localb.djq()) {
        localLinearLayout.getLayoutParams();
      }
      AppMethodBeat.o(113707);
      return;
      label397:
      localTextView2.setVisibility(8);
      localLayoutParams1.height = localMMActivity.getResources().getDimensionPixelOffset(a.b.wdW);
    }
    label422:
    if (!TextUtils.isEmpty(((aek)localObject).wsA))
    {
      localTextView2.setText(((aek)localObject).wsA);
      localTextView2.setVisibility(0);
    }
    for (localLayoutParams1.height = localMMActivity.getResources().getDimensionPixelOffset(a.b.wee);; localLayoutParams1.height = localMMActivity.getResources().getDimensionPixelOffset(a.b.wef))
    {
      localLinearLayout.setOnClickListener(this.wJs.dmo());
      break;
      localTextView2.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.u
 * JD-Core Version:    0.7.0.1
 */