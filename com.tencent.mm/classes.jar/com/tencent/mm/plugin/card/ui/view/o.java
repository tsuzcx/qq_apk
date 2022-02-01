package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.e.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.ehs;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;

public final class o
  extends i
{
  private View tGk;
  private ImageView tGl;
  private TextView tGm;
  private TextView tGn;
  
  public final void cKY()
  {
    AppMethodBeat.i(113701);
    this.tGk.setVisibility(8);
    AppMethodBeat.o(113701);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113699);
    this.tGk = findViewById(a.d.tfH);
    this.tGl = ((ImageView)findViewById(a.d.tfF));
    this.tGm = ((TextView)findViewById(a.d.tfJ));
    this.tGn = ((TextView)findViewById(a.d.tfI));
    this.tGk.setVisibility(8);
    AppMethodBeat.o(113699);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113700);
    b localb = this.tFT.cIS();
    MMActivity localMMActivity = this.tFT.cIV();
    e.a locala = this.tFT.cIZ();
    this.tGk.setVisibility(0);
    this.tGm.setText(l.b(localMMActivity, ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(locala.tuY).ayr(), this.tGm.getTextSize()));
    if ((localb.cGu() != null) && (!TextUtils.isEmpty(localb.cGu().UjL))) {
      this.tGn.setText(l.b(localMMActivity, localb.cGu().UjL, this.tGn.getTextSize()));
    }
    for (;;)
    {
      a.b.c(this.tGl, locala.tuY);
      this.tGl.setOnClickListener(this.tFT.cIW());
      AppMethodBeat.o(113700);
      return;
      if (!TextUtils.isEmpty(localb.cGs().tpo))
      {
        if (localb.cGc()) {
          this.tGn.setText(localMMActivity.getString(a.g.tkH, new Object[] { localb.cGs().tpo }));
        } else {
          this.tGn.setText(localMMActivity.getString(a.g.tkm, new Object[] { localb.cGs().tpo }));
        }
      }
      else if (localb.cGc()) {
        this.tGn.setText(localMMActivity.getString(a.g.tkH, new Object[] { this.tFT.cJa().getTitle() }));
      } else {
        this.tGn.setText(localMMActivity.getString(a.g.tkm, new Object[] { this.tFT.cJa().getTitle() }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.o
 * JD-Core Version:    0.7.0.1
 */