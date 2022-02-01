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
import com.tencent.mm.protocal.protobuf.cbv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.f;

public class HoneyPayCardLayout
  extends LinearLayout
{
  private ImageView qyu;
  private String yjY;
  private TextView ykq;
  private TextView ykr;
  private WalletTextView yks;
  private TextView ykt;
  private CdnImageView yku;
  
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
    View localView = inflate(getContext(), 2131495017, this);
    this.qyu = ((ImageView)localView.findViewById(2131302384));
    this.yks = ((WalletTextView)localView.findViewById(2131302388));
    this.ykq = ((TextView)localView.findViewById(2131302390));
    this.ykr = ((TextView)localView.findViewById(2131302389));
    this.ykt = ((TextView)localView.findViewById(2131302386));
    this.yku = ((CdnImageView)localView.findViewById(2131302385));
    this.yks.setPrefix(ah.hhz());
    AppMethodBeat.o(64681);
  }
  
  public void setCardRecord(cbv paramcbv)
  {
    long l1 = 0L;
    AppMethodBeat.i(64682);
    this.yjY = paramcbv.LWD;
    this.ykt.setText(paramcbv.pTn);
    if (!Util.isNullOrNil(paramcbv.icon)) {
      this.yku.gI(paramcbv.icon, c.OM(paramcbv.nHh));
    }
    a.b.a(this.qyu, paramcbv.LjD, 0.06F, false);
    f.i(this.ykq, paramcbv.LjD);
    this.yks.setText(c.GO(paramcbv.LpD));
    if (paramcbv.MhI == 0)
    {
      this.ykr.setTextColor(getResources().getColor(2131099792));
      this.ykr.setText(2131761700);
      AppMethodBeat.o(64682);
      return;
    }
    long l2;
    if (paramcbv.MhI == 1) {
      if (paramcbv.MhK == 0L)
      {
        l2 = paramcbv.MhJ;
        if (l2 >= 0L) {
          break label281;
        }
        Log.w("MicroMsg.HoneyPayCardLayout", "unused quota wrong: %s", new Object[] { Long.valueOf(l2) });
      }
    }
    for (;;)
    {
      this.ykr.setText(getContext().getString(2131761699, new Object[] { ah.hhz() + c.GO(l1) }));
      AppMethodBeat.o(64682);
      return;
      Log.i("MicroMsg.HoneyPayCardLayout", "show check detail");
      this.ykr.setText("");
      AppMethodBeat.o(64682);
      return;
      Log.w("MicroMsg.HoneyPayCardLayout", "unknown rcvd: %s", new Object[] { Integer.valueOf(paramcbv.MhI) });
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