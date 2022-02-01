package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
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

public final class o
  extends i
{
  private TextView nIA;
  private View nIx;
  private ImageView nIy;
  private TextView nIz;
  
  public final void bMB()
  {
    AppMethodBeat.i(113701);
    this.nIx.setVisibility(8);
    AppMethodBeat.o(113701);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113699);
    this.nIx = findViewById(2131300308);
    this.nIy = ((ImageView)findViewById(2131300306));
    this.nIz = ((TextView)findViewById(2131300310));
    this.nIA = ((TextView)findViewById(2131300309));
    this.nIx.setVisibility(8);
    AppMethodBeat.o(113699);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113700);
    b localb = this.nIg.bKt();
    MMActivity localMMActivity = this.nIg.bKw();
    e.a locala = this.nIg.bKA();
    this.nIx.setVisibility(0);
    this.nIz.setText(com.tencent.mm.pluginsdk.ui.span.k.b(localMMActivity, ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(locala.nys).ZW(), this.nIz.getTextSize()));
    if ((localb.bHX() != null) && (!TextUtils.isEmpty(localb.bHX().Ekz))) {
      this.nIA.setText(com.tencent.mm.pluginsdk.ui.span.k.b(localMMActivity, localb.bHX().Ekz, this.nIA.getTextSize()));
    }
    for (;;)
    {
      a.b.c(this.nIy, locala.nys);
      this.nIy.setOnClickListener(this.nIg.bKx());
      AppMethodBeat.o(113700);
      return;
      if (!TextUtils.isEmpty(localb.bHV().nsJ))
      {
        if (localb.bHG()) {
          this.nIA.setText(localMMActivity.getString(2131756907, new Object[] { localb.bHV().nsJ }));
        } else {
          this.nIA.setText(localMMActivity.getString(2131756870, new Object[] { localb.bHV().nsJ }));
        }
      }
      else if (localb.bHG()) {
        this.nIA.setText(localMMActivity.getString(2131756907, new Object[] { this.nIg.bKB().getTitle() }));
      } else {
        this.nIA.setText(localMMActivity.getString(2131756870, new Object[] { this.nIg.bKB().getTitle() }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.o
 * JD-Core Version:    0.7.0.1
 */