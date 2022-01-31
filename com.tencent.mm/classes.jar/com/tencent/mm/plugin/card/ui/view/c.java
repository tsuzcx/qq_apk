package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.ye;

public final class c
  extends i
{
  private View kAU;
  private TextView kAV;
  
  public final void bfq()
  {
    AppMethodBeat.i(88737);
    if (this.kAU != null) {
      this.kAU.setVisibility(8);
    }
    AppMethodBeat.o(88737);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(88736);
    if (this.kAU == null)
    {
      this.kAU = ((ViewStub)findViewById(2131822077)).inflate();
      this.kAV = ((TextView)this.kAU.findViewById(2131821995));
    }
    this.kAU.setVisibility(0);
    this.kAU.setOnClickListener(this.kBh.bdz());
    b localb = this.kBh.bdv();
    if (!TextUtils.isEmpty(localb.bbd().wGr.wPl))
    {
      this.kAV.setText(localb.bbd().wGr.wPl);
      AppMethodBeat.o(88736);
      return;
    }
    this.kAV.setText(getString(2131297991));
    AppMethodBeat.o(88736);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.c
 * JD-Core Version:    0.7.0.1
 */