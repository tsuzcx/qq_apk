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
import com.tencent.mm.protocal.protobuf.csx;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity;

public final class a
  extends i
{
  private View nHN;
  
  public final void bMB()
  {
    AppMethodBeat.i(113657);
    this.nHN.setVisibility(8);
    AppMethodBeat.o(113657);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113655);
    this.nHN = findViewById(2131297718);
    AppMethodBeat.o(113655);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113656);
    Object localObject = this.nIg.bKy();
    b localb = this.nIg.bKt();
    MMActivity localMMActivity = this.nIg.bKw();
    e.a locala = this.nIg.bKA();
    f localf = this.nIg.bKB();
    if (((com.tencent.mm.plugin.card.ui.a.g)localObject).bLK())
    {
      this.nHN.setVisibility(0);
      findViewById(2131296318).setVisibility(0);
      localObject = (ImageView)findViewById(2131296317);
      TextView localTextView1 = (TextView)findViewById(2131296319);
      TextView localTextView2 = (TextView)findViewById(2131296323);
      if (locala.nys != null) {
        localTextView1.setText(com.tencent.mm.pluginsdk.ui.span.k.b(localMMActivity, ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(locala.nys).ZW(), localTextView1.getTextSize()));
      }
      if (locala.fsv == 23) {
        if (!TextUtils.isEmpty(localb.bHV().CSe)) {
          localTextView2.setText(localb.bHV().CSe);
        }
      }
      for (;;)
      {
        a.b.a((ImageView)localObject, locala.nys, 0.15F, false);
        ((ImageView)localObject).setOnClickListener(this.nIg.bKx());
        AppMethodBeat.o(113656);
        return;
        if (!TextUtils.isEmpty(localb.bHV().nsJ))
        {
          localTextView2.setText(localMMActivity.getString(2131756954, new Object[] { localb.bHV().nsJ }));
        }
        else
        {
          localTextView2.setText(localMMActivity.getString(2131756954, new Object[] { localf.getTitle() }));
          continue;
          if ((localb.bHX() != null) && (!TextUtils.isEmpty(localb.bHX().Ekz))) {
            localTextView2.setText(localb.bHX().Ekz);
          } else if (!TextUtils.isEmpty(localb.bHV().nsJ))
          {
            if (localb.bHG()) {
              localTextView2.setText(localMMActivity.getString(2131756907, new Object[] { localb.bHV().nsJ }));
            } else {
              localTextView2.setText(localMMActivity.getString(2131756870, new Object[] { localb.bHV().nsJ }));
            }
          }
          else if (localb.bHG()) {
            localTextView2.setText(localMMActivity.getString(2131756907, new Object[] { localf.getTitle() }));
          } else {
            localTextView2.setText(localMMActivity.getString(2131756870, new Object[] { localf.getTitle() }));
          }
        }
      }
    }
    if (((com.tencent.mm.plugin.card.ui.a.g)localObject).bLL())
    {
      if (!TextUtils.isEmpty(localb.bHV().CSe))
      {
        this.nHN.setVisibility(0);
        findViewById(2131296318).setVisibility(8);
        ((TextView)findViewById(2131296323)).setText(localb.bHV().CSe);
        AppMethodBeat.o(113656);
        return;
      }
      this.nHN.setVisibility(8);
      AppMethodBeat.o(113656);
      return;
    }
    bMB();
    AppMethodBeat.o(113656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.a
 * JD-Core Version:    0.7.0.1
 */