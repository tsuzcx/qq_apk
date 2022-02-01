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
import com.tencent.mm.protocal.protobuf.bgj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;

public class HoneyPayCardLayout
  extends LinearLayout
{
  private ImageView nVN;
  private TextView svC;
  private TextView svD;
  private WalletTextView svE;
  private TextView svF;
  private CdnImageView svG;
  private String svk;
  
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
    this.nVN = ((ImageView)localView.findViewById(2131300790));
    this.svE = ((WalletTextView)localView.findViewById(2131300794));
    this.svC = ((TextView)localView.findViewById(2131300796));
    this.svD = ((TextView)localView.findViewById(2131300795));
    this.svF = ((TextView)localView.findViewById(2131300792));
    this.svG = ((CdnImageView)localView.findViewById(2131300791));
    this.svE.setPrefix(ah.fkg());
    AppMethodBeat.o(64681);
  }
  
  public void setCardRecord(bgj parambgj)
  {
    long l1 = 0L;
    AppMethodBeat.i(64682);
    this.svk = parambgj.Duy;
    this.svF.setText(parambgj.nsJ);
    if (!bt.isNullOrNil(parambgj.dub)) {
      this.svG.fz(parambgj.dub, c.ET(parambgj.lpz));
    }
    a.b.a(this.nVN, parambgj.CWy, 0.06F, false);
    e.f(this.svC, parambgj.CWy);
    this.svE.setText(c.qX(parambgj.Dbe));
    if (parambgj.DEk == 0)
    {
      this.svD.setTextColor(getResources().getColor(2131099777));
      this.svD.setText(2131760314);
      AppMethodBeat.o(64682);
      return;
    }
    long l2;
    if (parambgj.DEk == 1) {
      if (parambgj.DEm == 0L)
      {
        l2 = parambgj.DEl;
        if (l2 >= 0L) {
          break label281;
        }
        ad.w("MicroMsg.HoneyPayCardLayout", "unused quota wrong: %s", new Object[] { Long.valueOf(l2) });
      }
    }
    for (;;)
    {
      this.svD.setText(getContext().getString(2131760313, new Object[] { ah.fkg() + c.qX(l1) }));
      AppMethodBeat.o(64682);
      return;
      ad.i("MicroMsg.HoneyPayCardLayout", "show check detail");
      this.svD.setText("");
      AppMethodBeat.o(64682);
      return;
      ad.w("MicroMsg.HoneyPayCardLayout", "unknown rcvd: %s", new Object[] { Integer.valueOf(parambgj.DEk) });
      AppMethodBeat.o(64682);
      return;
      label281:
      l1 = l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardLayout
 * JD-Core Version:    0.7.0.1
 */