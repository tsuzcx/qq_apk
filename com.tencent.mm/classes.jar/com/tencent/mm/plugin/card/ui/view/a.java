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
import com.tencent.mm.protocal.protobuf.ddt;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;

public final class a
  extends i
{
  private View oOi;
  
  public final void bYr()
  {
    AppMethodBeat.i(113657);
    this.oOi.setVisibility(8);
    AppMethodBeat.o(113657);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113655);
    this.oOi = findViewById(2131297718);
    AppMethodBeat.o(113655);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113656);
    Object localObject = this.oOB.bWq();
    b localb = this.oOB.bWl();
    MMActivity localMMActivity = this.oOB.bWo();
    e.a locala = this.oOB.bWs();
    f localf = this.oOB.bWt();
    if (((com.tencent.mm.plugin.card.ui.a.g)localObject).bXC())
    {
      this.oOi.setVisibility(0);
      findViewById(2131296318).setVisibility(0);
      localObject = (ImageView)findViewById(2131296317);
      TextView localTextView1 = (TextView)findViewById(2131296319);
      TextView localTextView2 = (TextView)findViewById(2131296323);
      if (locala.oEM != null) {
        localTextView1.setText(k.b(localMMActivity, ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(locala.oEM).adu(), localTextView1.getTextSize()));
      }
      if (locala.fPp == 23) {
        if (!TextUtils.isEmpty(localb.bTN().FRY)) {
          localTextView2.setText(localb.bTN().FRY);
        }
      }
      for (;;)
      {
        a.b.a((ImageView)localObject, locala.oEM, 0.15F, false);
        ((ImageView)localObject).setOnClickListener(this.oOB.bWp());
        AppMethodBeat.o(113656);
        return;
        if (!TextUtils.isEmpty(localb.bTN().ozd))
        {
          localTextView2.setText(localMMActivity.getString(2131756954, new Object[] { localb.bTN().ozd }));
        }
        else
        {
          localTextView2.setText(localMMActivity.getString(2131756954, new Object[] { localf.getTitle() }));
          continue;
          if ((localb.bTP() != null) && (!TextUtils.isEmpty(localb.bTP().Hsf))) {
            localTextView2.setText(localb.bTP().Hsf);
          } else if (!TextUtils.isEmpty(localb.bTN().ozd))
          {
            if (localb.bTy()) {
              localTextView2.setText(localMMActivity.getString(2131756907, new Object[] { localb.bTN().ozd }));
            } else {
              localTextView2.setText(localMMActivity.getString(2131756870, new Object[] { localb.bTN().ozd }));
            }
          }
          else if (localb.bTy()) {
            localTextView2.setText(localMMActivity.getString(2131756907, new Object[] { localf.getTitle() }));
          } else {
            localTextView2.setText(localMMActivity.getString(2131756870, new Object[] { localf.getTitle() }));
          }
        }
      }
    }
    if (((com.tencent.mm.plugin.card.ui.a.g)localObject).bXD())
    {
      if (!TextUtils.isEmpty(localb.bTN().FRY))
      {
        this.oOi.setVisibility(0);
        findViewById(2131296318).setVisibility(8);
        ((TextView)findViewById(2131296323)).setText(localb.bTN().FRY);
        AppMethodBeat.o(113656);
        return;
      }
      this.oOi.setVisibility(8);
      AppMethodBeat.o(113656);
      return;
    }
    bYr();
    AppMethodBeat.o(113656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.a
 * JD-Core Version:    0.7.0.1
 */