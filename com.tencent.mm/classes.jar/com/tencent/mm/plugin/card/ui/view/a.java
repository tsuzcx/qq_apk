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
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.plugin.card.ui.e.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.ehs;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;

public final class a
  extends i
{
  private View tFA;
  
  public final void cKY()
  {
    AppMethodBeat.i(113657);
    this.tFA.setVisibility(8);
    AppMethodBeat.o(113657);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113655);
    this.tFA = findViewById(a.d.taY);
    AppMethodBeat.o(113655);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113656);
    Object localObject = this.tFT.cIX();
    b localb = this.tFT.cIS();
    MMActivity localMMActivity = this.tFT.cIV();
    e.a locala = this.tFT.cIZ();
    f localf = this.tFT.cJa();
    if (((g)localObject).cKk())
    {
      this.tFA.setVisibility(0);
      findViewById(a.d.taz).setVisibility(0);
      localObject = (ImageView)findViewById(a.d.tay);
      TextView localTextView1 = (TextView)findViewById(a.d.taA);
      TextView localTextView2 = (TextView)findViewById(a.d.taB);
      if (locala.tuY != null) {
        localTextView1.setText(l.b(localMMActivity, ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(locala.tuY).ayr(), localTextView1.getTextSize()));
      }
      if (locala.jaR == 23) {
        if (!TextUtils.isEmpty(localb.cGs().Sgo)) {
          localTextView2.setText(localb.cGs().Sgo);
        }
      }
      for (;;)
      {
        a.b.a((ImageView)localObject, locala.tuY, 0.15F, false);
        ((ImageView)localObject).setOnClickListener(this.tFT.cIW());
        AppMethodBeat.o(113656);
        return;
        if (!TextUtils.isEmpty(localb.cGs().tpo))
        {
          localTextView2.setText(localMMActivity.getString(a.g.tlk, new Object[] { localb.cGs().tpo }));
        }
        else
        {
          localTextView2.setText(localMMActivity.getString(a.g.tlk, new Object[] { localf.getTitle() }));
          continue;
          if ((localb.cGu() != null) && (!TextUtils.isEmpty(localb.cGu().UjL))) {
            localTextView2.setText(localb.cGu().UjL);
          } else if (!TextUtils.isEmpty(localb.cGs().tpo))
          {
            if (localb.cGc()) {
              localTextView2.setText(localMMActivity.getString(a.g.tkH, new Object[] { localb.cGs().tpo }));
            } else {
              localTextView2.setText(localMMActivity.getString(a.g.tkm, new Object[] { localb.cGs().tpo }));
            }
          }
          else if (localb.cGc()) {
            localTextView2.setText(localMMActivity.getString(a.g.tkH, new Object[] { localf.getTitle() }));
          } else {
            localTextView2.setText(localMMActivity.getString(a.g.tkm, new Object[] { localf.getTitle() }));
          }
        }
      }
    }
    if (((g)localObject).cKl())
    {
      if (!TextUtils.isEmpty(localb.cGs().Sgo))
      {
        this.tFA.setVisibility(0);
        findViewById(a.d.taz).setVisibility(8);
        ((TextView)findViewById(a.d.taB)).setText(localb.cGs().Sgo);
        AppMethodBeat.o(113656);
        return;
      }
      this.tFA.setVisibility(8);
      AppMethodBeat.o(113656);
      return;
    }
    cKY();
    AppMethodBeat.o(113656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.a
 * JD-Core Version:    0.7.0.1
 */