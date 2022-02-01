package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.e.a;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.den;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;

public final class a
  extends i
{
  private View oUK;
  
  public final void bZG()
  {
    AppMethodBeat.i(113657);
    this.oUK.setVisibility(8);
    AppMethodBeat.o(113657);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113655);
    this.oUK = findViewById(2131297718);
    AppMethodBeat.o(113655);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113656);
    Object localObject = this.oVd.bXF();
    b localb = this.oVd.bXA();
    MMActivity localMMActivity = this.oVd.bXD();
    e.a locala = this.oVd.bXH();
    f localf = this.oVd.bXI();
    if (((com.tencent.mm.plugin.card.ui.a.g)localObject).bYR())
    {
      this.oUK.setVisibility(0);
      findViewById(2131296318).setVisibility(0);
      localObject = (ImageView)findViewById(2131296317);
      TextView localTextView1 = (TextView)findViewById(2131296319);
      TextView localTextView2 = (TextView)findViewById(2131296323);
      if (locala.oLo != null) {
        localTextView1.setText(k.b(localMMActivity, ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(locala.oLo).adF(), localTextView1.getTextSize()));
      }
      if (locala.fRv == 23) {
        if (!TextUtils.isEmpty(localb.bVc().Gkx)) {
          localTextView2.setText(localb.bVc().Gkx);
        }
      }
      for (;;)
      {
        a.b.a((ImageView)localObject, locala.oLo, 0.15F, false);
        ((ImageView)localObject).setOnClickListener(this.oVd.bXE());
        AppMethodBeat.o(113656);
        return;
        if (!TextUtils.isEmpty(localb.bVc().oFF))
        {
          localTextView2.setText(localMMActivity.getString(2131756954, new Object[] { localb.bVc().oFF }));
        }
        else
        {
          localTextView2.setText(localMMActivity.getString(2131756954, new Object[] { localf.getTitle() }));
          continue;
          if ((localb.bVe() != null) && (!TextUtils.isEmpty(localb.bVe().HLH))) {
            localTextView2.setText(localb.bVe().HLH);
          } else if (!TextUtils.isEmpty(localb.bVc().oFF))
          {
            if (localb.bUN()) {
              localTextView2.setText(localMMActivity.getString(2131756907, new Object[] { localb.bVc().oFF }));
            } else {
              localTextView2.setText(localMMActivity.getString(2131756870, new Object[] { localb.bVc().oFF }));
            }
          }
          else if (localb.bUN()) {
            localTextView2.setText(localMMActivity.getString(2131756907, new Object[] { localf.getTitle() }));
          } else {
            localTextView2.setText(localMMActivity.getString(2131756870, new Object[] { localf.getTitle() }));
          }
        }
      }
    }
    if (((com.tencent.mm.plugin.card.ui.a.g)localObject).bYS())
    {
      if (!TextUtils.isEmpty(localb.bVc().Gkx))
      {
        this.oUK.setVisibility(0);
        findViewById(2131296318).setVisibility(8);
        ((TextView)findViewById(2131296323)).setText(localb.bVc().Gkx);
        AppMethodBeat.o(113656);
        return;
      }
      this.oUK.setVisibility(8);
      AppMethodBeat.o(113656);
      return;
    }
    bZG();
    AppMethodBeat.o(113656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.a
 * JD-Core Version:    0.7.0.1
 */