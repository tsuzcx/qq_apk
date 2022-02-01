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
import com.tencent.mm.protocal.protobuf.bkb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;

public class HoneyPayCardLayout
  extends LinearLayout
{
  private ImageView ozi;
  private String tCZ;
  private TextView tDr;
  private TextView tDs;
  private WalletTextView tDt;
  private TextView tDu;
  private CdnImageView tDv;
  
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
    this.ozi = ((ImageView)localView.findViewById(2131300790));
    this.tDt = ((WalletTextView)localView.findViewById(2131300794));
    this.tDr = ((TextView)localView.findViewById(2131300796));
    this.tDs = ((TextView)localView.findViewById(2131300795));
    this.tDu = ((TextView)localView.findViewById(2131300792));
    this.tDv = ((CdnImageView)localView.findViewById(2131300791));
    this.tDt.setPrefix(ah.fAw());
    AppMethodBeat.o(64681);
  }
  
  public void setCardRecord(bkb parambkb)
  {
    long l1 = 0L;
    AppMethodBeat.i(64682);
    this.tCZ = parambkb.EPH;
    this.tDu.setText(parambkb.nVJ);
    if (!bs.isNullOrNil(parambkb.drM)) {
      this.tDv.fE(parambkb.drM, c.GP(parambkb.lRv));
    }
    a.b.a(this.ozi, parambkb.Eph, 0.06F, false);
    e.f(this.tDr, parambkb.Eph);
    this.tDt.setText(c.vA(parambkb.Eub));
    if (parambkb.EZF == 0)
    {
      this.tDs.setTextColor(getResources().getColor(2131099777));
      this.tDs.setText(2131760314);
      AppMethodBeat.o(64682);
      return;
    }
    long l2;
    if (parambkb.EZF == 1) {
      if (parambkb.EZH == 0L)
      {
        l2 = parambkb.EZG;
        if (l2 >= 0L) {
          break label281;
        }
        ac.w("MicroMsg.HoneyPayCardLayout", "unused quota wrong: %s", new Object[] { Long.valueOf(l2) });
      }
    }
    for (;;)
    {
      this.tDs.setText(getContext().getString(2131760313, new Object[] { ah.fAw() + c.vA(l1) }));
      AppMethodBeat.o(64682);
      return;
      ac.i("MicroMsg.HoneyPayCardLayout", "show check detail");
      this.tDs.setText("");
      AppMethodBeat.o(64682);
      return;
      ac.w("MicroMsg.HoneyPayCardLayout", "unknown rcvd: %s", new Object[] { Integer.valueOf(parambkb.EZF) });
      AppMethodBeat.o(64682);
      return;
      label281:
      l1 = l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardLayout
 * JD-Core Version:    0.7.0.1
 */