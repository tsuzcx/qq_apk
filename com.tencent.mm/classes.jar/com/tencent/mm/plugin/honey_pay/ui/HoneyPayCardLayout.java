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
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;

public class HoneyPayCardLayout
  extends LinearLayout
{
  private ImageView pcD;
  private String uFI;
  private TextView uGa;
  private TextView uGb;
  private WalletTextView uGc;
  private TextView uGd;
  private CdnImageView uGe;
  
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
    this.pcD = ((ImageView)localView.findViewById(2131300790));
    this.uGc = ((WalletTextView)localView.findViewById(2131300794));
    this.uGa = ((TextView)localView.findViewById(2131300796));
    this.uGb = ((TextView)localView.findViewById(2131300795));
    this.uGd = ((TextView)localView.findViewById(2131300792));
    this.uGe = ((CdnImageView)localView.findViewById(2131300791));
    this.uGc.setPrefix(ah.fRG());
    AppMethodBeat.o(64681);
  }
  
  public void setCardRecord(bol parambol)
  {
    long l1 = 0L;
    AppMethodBeat.i(64682);
    this.uFI = parambol.GyY;
    this.uGd.setText(parambol.ozd);
    if (!bt.isNullOrNil(parambol.dDH)) {
      this.uGe.gb(parambol.dDH, c.Il(parambol.mrl));
    }
    a.b.a(this.pcD, parambol.FWt, 0.06F, false);
    e.f(this.uGa, parambol.FWt);
    this.uGc.setText(c.xK(parambol.Gbu));
    if (parambol.GJe == 0)
    {
      this.uGb.setTextColor(getResources().getColor(2131099777));
      this.uGb.setText(2131760314);
      AppMethodBeat.o(64682);
      return;
    }
    long l2;
    if (parambol.GJe == 1) {
      if (parambol.GJg == 0L)
      {
        l2 = parambol.GJf;
        if (l2 >= 0L) {
          break label281;
        }
        ad.w("MicroMsg.HoneyPayCardLayout", "unused quota wrong: %s", new Object[] { Long.valueOf(l2) });
      }
    }
    for (;;)
    {
      this.uGb.setText(getContext().getString(2131760313, new Object[] { ah.fRG() + c.xK(l1) }));
      AppMethodBeat.o(64682);
      return;
      ad.i("MicroMsg.HoneyPayCardLayout", "show check detail");
      this.uGb.setText("");
      AppMethodBeat.o(64682);
      return;
      ad.w("MicroMsg.HoneyPayCardLayout", "unknown rcvd: %s", new Object[] { Integer.valueOf(parambol.GJe) });
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