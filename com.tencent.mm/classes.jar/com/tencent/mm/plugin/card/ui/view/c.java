package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.acl;
import com.tencent.mm.protocal.protobuf.ry;

public final class c
  extends i
{
  private View okT;
  private TextView okU;
  
  public final void bTM()
  {
    AppMethodBeat.i(113664);
    if (this.okT != null) {
      this.okT.setVisibility(8);
    }
    AppMethodBeat.o(113664);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113663);
    if (this.okT == null)
    {
      this.okT = ((ViewStub)findViewById(2131297728)).inflate();
      this.okU = ((TextView)this.okT.findViewById(2131297729));
    }
    this.okT.setVisibility(0);
    this.okT.setOnClickListener(this.olg.bRK());
    b localb = this.olg.bRG();
    if (!TextUtils.isEmpty(localb.bPi().EkH.EuW))
    {
      this.okU.setText(localb.bPi().EkH.EuW);
      AppMethodBeat.o(113663);
      return;
    }
    this.okU.setText(getString(2131756933));
    AppMethodBeat.o(113663);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.c
 * JD-Core Version:    0.7.0.1
 */