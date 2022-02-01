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
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.cyg;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;

public final class a
  extends i
{
  private View okN;
  
  public final void bTM()
  {
    AppMethodBeat.i(113657);
    this.okN.setVisibility(8);
    AppMethodBeat.o(113657);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113655);
    this.okN = findViewById(2131297718);
    AppMethodBeat.o(113655);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113656);
    Object localObject = this.olg.bRL();
    b localb = this.olg.bRG();
    MMActivity localMMActivity = this.olg.bRJ();
    e.a locala = this.olg.bRN();
    f localf = this.olg.bRO();
    if (((com.tencent.mm.plugin.card.ui.a.g)localObject).bSX())
    {
      this.okN.setVisibility(0);
      findViewById(2131296318).setVisibility(0);
      localObject = (ImageView)findViewById(2131296317);
      TextView localTextView1 = (TextView)findViewById(2131296319);
      TextView localTextView2 = (TextView)findViewById(2131296323);
      if (locala.obt != null) {
        localTextView1.setText(com.tencent.mm.pluginsdk.ui.span.k.b(localMMActivity, ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(locala.obt).aaR(), localTextView1.getTextSize()));
      }
      if (locala.fwc == 23) {
        if (!TextUtils.isEmpty(localb.bPi().EkP)) {
          localTextView2.setText(localb.bPi().EkP);
        }
      }
      for (;;)
      {
        a.b.a((ImageView)localObject, locala.obt, 0.15F, false);
        ((ImageView)localObject).setOnClickListener(this.olg.bRK());
        AppMethodBeat.o(113656);
        return;
        if (!TextUtils.isEmpty(localb.bPi().nVJ))
        {
          localTextView2.setText(localMMActivity.getString(2131756954, new Object[] { localb.bPi().nVJ }));
        }
        else
        {
          localTextView2.setText(localMMActivity.getString(2131756954, new Object[] { localf.getTitle() }));
          continue;
          if ((localb.bPk() != null) && (!TextUtils.isEmpty(localb.bPk().FHx))) {
            localTextView2.setText(localb.bPk().FHx);
          } else if (!TextUtils.isEmpty(localb.bPi().nVJ))
          {
            if (localb.bOT()) {
              localTextView2.setText(localMMActivity.getString(2131756907, new Object[] { localb.bPi().nVJ }));
            } else {
              localTextView2.setText(localMMActivity.getString(2131756870, new Object[] { localb.bPi().nVJ }));
            }
          }
          else if (localb.bOT()) {
            localTextView2.setText(localMMActivity.getString(2131756907, new Object[] { localf.getTitle() }));
          } else {
            localTextView2.setText(localMMActivity.getString(2131756870, new Object[] { localf.getTitle() }));
          }
        }
      }
    }
    if (((com.tencent.mm.plugin.card.ui.a.g)localObject).bSY())
    {
      if (!TextUtils.isEmpty(localb.bPi().EkP))
      {
        this.okN.setVisibility(0);
        findViewById(2131296318).setVisibility(8);
        ((TextView)findViewById(2131296323)).setText(localb.bPi().EkP);
        AppMethodBeat.o(113656);
        return;
      }
      this.okN.setVisibility(8);
      AppMethodBeat.o(113656);
      return;
    }
    bTM();
    AppMethodBeat.o(113656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.a
 * JD-Core Version:    0.7.0.1
 */