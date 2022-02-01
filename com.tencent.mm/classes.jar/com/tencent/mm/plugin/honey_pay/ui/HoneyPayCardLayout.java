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
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.daf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.model.ai;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.i;

public class HoneyPayCardLayout
  extends LinearLayout
{
  private String JAW;
  private TextView JBo;
  private TextView JBp;
  private WalletTextView JBq;
  private TextView JBr;
  private CdnImageView JBs;
  private ImageView xaN;
  
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
    View localView = inflate(getContext(), a.g.honey_pay_card_layout, this);
    this.xaN = ((ImageView)localView.findViewById(a.f.hpcl_avatar_iv));
    this.JBq = ((WalletTextView)localView.findViewById(a.f.hpcl_quota_tv));
    this.JBo = ((TextView)localView.findViewById(a.f.hpcl_username_tv));
    this.JBp = ((TextView)localView.findViewById(a.f.hpcl_remain_tv));
    this.JBr = ((TextView)localView.findViewById(a.f.hpcl_card_type_tv));
    this.JBs = ((CdnImageView)localView.findViewById(a.f.hpcl_card_type_iv));
    this.JBq.setPrefix(ai.jOX());
    AppMethodBeat.o(64681);
  }
  
  public void setCardRecord(daf paramdaf)
  {
    long l1 = 0L;
    AppMethodBeat.i(64682);
    this.JAW = paramdaf.aatc;
    this.JBr.setText(paramdaf.wtN);
    if (!Util.isNullOrNil(paramdaf.icon)) {
      this.JBs.iz(paramdaf.icon, c.YP(paramdaf.tNW));
    }
    a.b.a(this.xaN, paramdaf.Zje, 0.06F, false);
    i.j(this.JBo, paramdaf.Zje);
    this.JBq.setText(c.rY(paramdaf.Zqa));
    if (paramdaf.aaFH == 0)
    {
      this.JBp.setTextColor(getResources().getColor(a.c.Orange));
      this.JBp.setText(a.i.honey_pay_waiting_for_receive);
      AppMethodBeat.o(64682);
      return;
    }
    long l2;
    if (paramdaf.aaFH == 1) {
      if (paramdaf.aaFJ == 0L)
      {
        l2 = paramdaf.aaFI;
        if (l2 >= 0L) {
          break label286;
        }
        Log.w("MicroMsg.HoneyPayCardLayout", "unused quota wrong: %s", new Object[] { Long.valueOf(l2) });
      }
    }
    for (;;)
    {
      this.JBp.setText(getContext().getString(a.i.honey_pay_used_month, new Object[] { ai.jOX() + c.rY(l1) }));
      AppMethodBeat.o(64682);
      return;
      Log.i("MicroMsg.HoneyPayCardLayout", "show check detail");
      this.JBp.setText("");
      AppMethodBeat.o(64682);
      return;
      Log.w("MicroMsg.HoneyPayCardLayout", "unknown rcvd: %s", new Object[] { Integer.valueOf(paramdaf.aaFH) });
      AppMethodBeat.o(64682);
      return;
      label286:
      l1 = l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardLayout
 * JD-Core Version:    0.7.0.1
 */