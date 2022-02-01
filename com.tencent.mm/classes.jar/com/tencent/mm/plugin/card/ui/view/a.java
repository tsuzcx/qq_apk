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
import com.tencent.mm.protocal.protobuf.dxr;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;

public final class a
  extends i
{
  private View qjE;
  
  public final void cxw()
  {
    AppMethodBeat.i(113657);
    this.qjE.setVisibility(8);
    AppMethodBeat.o(113657);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113655);
    this.qjE = findViewById(2131298022);
    AppMethodBeat.o(113655);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113656);
    Object localObject = this.qjX.cvv();
    b localb = this.qjX.cvq();
    MMActivity localMMActivity = this.qjX.cvt();
    e.a locala = this.qjX.cvx();
    f localf = this.qjX.cvy();
    if (((com.tencent.mm.plugin.card.ui.a.g)localObject).cwH())
    {
      this.qjE.setVisibility(0);
      findViewById(2131296331).setVisibility(0);
      localObject = (ImageView)findViewById(2131296330);
      TextView localTextView1 = (TextView)findViewById(2131296332);
      TextView localTextView2 = (TextView)findViewById(2131296336);
      if (locala.pZc != null) {
        localTextView1.setText(com.tencent.mm.pluginsdk.ui.span.l.b(localMMActivity, ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(locala.pZc).arI(), localTextView1.getTextSize()));
      }
      if (locala.gwE == 23) {
        if (!TextUtils.isEmpty(localb.csQ().Lfa)) {
          localTextView2.setText(localb.csQ().Lfa);
        }
      }
      for (;;)
      {
        a.b.a((ImageView)localObject, locala.pZc, 0.15F, false);
        ((ImageView)localObject).setOnClickListener(this.qjX.cvu());
        AppMethodBeat.o(113656);
        return;
        if (!TextUtils.isEmpty(localb.csQ().pTn))
        {
          localTextView2.setText(localMMActivity.getString(2131757124, new Object[] { localb.csQ().pTn }));
        }
        else
        {
          localTextView2.setText(localMMActivity.getString(2131757124, new Object[] { localf.getTitle() }));
          continue;
          if ((localb.csS() != null) && (!TextUtils.isEmpty(localb.csS().MXq))) {
            localTextView2.setText(localb.csS().MXq);
          } else if (!TextUtils.isEmpty(localb.csQ().pTn))
          {
            if (localb.csB()) {
              localTextView2.setText(localMMActivity.getString(2131757077, new Object[] { localb.csQ().pTn }));
            } else {
              localTextView2.setText(localMMActivity.getString(2131757035, new Object[] { localb.csQ().pTn }));
            }
          }
          else if (localb.csB()) {
            localTextView2.setText(localMMActivity.getString(2131757077, new Object[] { localf.getTitle() }));
          } else {
            localTextView2.setText(localMMActivity.getString(2131757035, new Object[] { localf.getTitle() }));
          }
        }
      }
    }
    if (((com.tencent.mm.plugin.card.ui.a.g)localObject).cwI())
    {
      if (!TextUtils.isEmpty(localb.csQ().Lfa))
      {
        this.qjE.setVisibility(0);
        findViewById(2131296331).setVisibility(8);
        ((TextView)findViewById(2131296336)).setText(localb.csQ().Lfa);
        AppMethodBeat.o(113656);
        return;
      }
      this.qjE.setVisibility(8);
      AppMethodBeat.o(113656);
      return;
    }
    cxw();
    AppMethodBeat.o(113656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.a
 * JD-Core Version:    0.7.0.1
 */