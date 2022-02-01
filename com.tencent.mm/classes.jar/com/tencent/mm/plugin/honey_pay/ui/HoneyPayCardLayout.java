package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bpd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.f;

public class HoneyPayCardLayout
  extends LinearLayout
{
  private ImageView pjj;
  private TextView uRN;
  private TextView uRO;
  private WalletTextView uRP;
  private TextView uRQ;
  private CdnImageView uRR;
  private String uRv;
  
  public HoneyPayCardLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(64678);
    init();
    AppMethodBeat.o(64678);
  }
  
  public HoneyPayCardLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(64679);
    init();
    AppMethodBeat.o(64679);
  }
  
  public HoneyPayCardLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(64680);
    init();
    AppMethodBeat.o(64680);
  }
  
  private void init()
  {
    AppMethodBeat.i(64681);
    View localView = inflate(getContext(), 2131494439, this);
    this.pjj = ((ImageView)localView.findViewById(2131300790));
    this.uRP = ((WalletTextView)localView.findViewById(2131300794));
    this.uRN = ((TextView)localView.findViewById(2131300796));
    this.uRO = ((TextView)localView.findViewById(2131300795));
    this.uRQ = ((TextView)localView.findViewById(2131300792));
    this.uRR = ((CdnImageView)localView.findViewById(2131300791));
    this.uRP.setPrefix(ah.fWc());
    AppMethodBeat.o(64681);
  }
  
  public void setCardRecord(bpd parambpd)
  {
    long l1 = 0L;
    AppMethodBeat.i(64682);
    this.uRv = parambpd.GSy;
    this.uRQ.setText(parambpd.oFF);
    if (!bu.isNullOrNil(parambpd.dEM)) {
      this.uRR.gk(parambpd.dEM, c.IJ(parambpd.mwj));
    }
    a.b.a(this.pjj, parambpd.GoS, 0.06F, false);
    f.g(this.uRN, parambpd.GoS);
    this.uRP.setText(c.ye(parambpd.Gub));
    if (parambpd.HcF == 0)
    {
      this.uRO.setTextColor(getResources().getColor(2131099777));
      this.uRO.setText(2131760314);
      AppMethodBeat.o(64682);
      return;
    }
    long l2;
    if (parambpd.HcF == 1) {
      if (parambpd.HcH == 0L)
      {
        l2 = parambpd.HcG;
        if (l2 >= 0L) {
          break label281;
        }
        ae.w("MicroMsg.HoneyPayCardLayout", "unused quota wrong: %s", new Object[] { Long.valueOf(l2) });
      }
    }
    for (;;)
    {
      this.uRO.setText(getContext().getString(2131760313, new Object[] { ah.fWc() + c.ye(l1) }));
      AppMethodBeat.o(64682);
      return;
      ae.i("MicroMsg.HoneyPayCardLayout", "show check detail");
      this.uRO.setText("");
      AppMethodBeat.o(64682);
      return;
      ae.w("MicroMsg.HoneyPayCardLayout", "unknown rcvd: %s", new Object[] { Integer.valueOf(parambpd.HcF) });
      AppMethodBeat.o(64682);
      return;
      label281:
      l1 = l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardLayout
 * JD-Core Version:    0.7.0.1
 */