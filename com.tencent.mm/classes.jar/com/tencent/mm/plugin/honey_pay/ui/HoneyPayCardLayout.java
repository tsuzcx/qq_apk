package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.ave;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;

public class HoneyPayCardLayout
  extends LinearLayout
{
  private ImageView kPy;
  private String nHE;
  private TextView nHW;
  private TextView nHX;
  private WalletTextView nHY;
  private TextView nHZ;
  private CdnImageView nIa;
  
  public HoneyPayCardLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(41788);
    init();
    AppMethodBeat.o(41788);
  }
  
  public HoneyPayCardLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(41789);
    init();
    AppMethodBeat.o(41789);
  }
  
  public HoneyPayCardLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(41790);
    init();
    AppMethodBeat.o(41790);
  }
  
  private void init()
  {
    AppMethodBeat.i(41791);
    View localView = inflate(getContext(), 2130969862, this);
    this.kPy = ((ImageView)localView.findViewById(2131825000));
    this.nHY = ((WalletTextView)localView.findViewById(2131825002));
    this.nHW = ((TextView)localView.findViewById(2131825001));
    this.nHX = ((TextView)localView.findViewById(2131825003));
    this.nHZ = ((TextView)localView.findViewById(2131824999));
    this.nIa = ((CdnImageView)localView.findViewById(2131824998));
    this.nHY.setPrefix(ae.dSz());
    AppMethodBeat.o(41791);
  }
  
  public void setCardRecord(ave paramave)
  {
    long l1 = 0L;
    AppMethodBeat.i(41792);
    this.nHE = paramave.xcf;
    this.nHZ.setText(paramave.knv);
    if (!bo.isNullOrNil(paramave.cDz)) {
      this.nIa.eq(paramave.cDz, c.xr(paramave.iFL));
    }
    a.b.a(this.kPy, paramave.wKl, 0.06F, false);
    e.d(this.nHW, paramave.wKl);
    this.nHY.setText(c.kn(paramave.wOy));
    if (paramave.xkA == 0)
    {
      this.nHX.setTextColor(Color.parseColor("#FA9D3B"));
      this.nHX.setText(2131300717);
      AppMethodBeat.o(41792);
      return;
    }
    long l2;
    if (paramave.xkA == 1) {
      if (paramave.xkC == 0L)
      {
        l2 = paramave.xkB;
        if (l2 >= 0L) {
          break label277;
        }
        ab.w("MicroMsg.HoneyPayCardLayout", "unused quota wrong: %s", new Object[] { Long.valueOf(l2) });
      }
    }
    for (;;)
    {
      this.nHX.setText(getContext().getString(2131300716, new Object[] { ae.dSz() + c.kn(l1) }));
      AppMethodBeat.o(41792);
      return;
      ab.i("MicroMsg.HoneyPayCardLayout", "show check detail");
      this.nHX.setText("");
      AppMethodBeat.o(41792);
      return;
      ab.w("MicroMsg.HoneyPayCardLayout", "unknown rcvd: %s", new Object[] { Integer.valueOf(paramave.xkA) });
      AppMethodBeat.o(41792);
      return;
      label277:
      l1 = l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardLayout
 * JD-Core Version:    0.7.0.1
 */