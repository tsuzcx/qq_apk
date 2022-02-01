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
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.g;

public class HoneyPayCardLayout
  extends LinearLayout
{
  private String DKa;
  private TextView DKs;
  private TextView DKt;
  private WalletTextView DKu;
  private TextView DKv;
  private CdnImageView DKw;
  private ImageView tXu;
  
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
    this.tXu = ((ImageView)localView.findViewById(a.f.hpcl_avatar_iv));
    this.DKu = ((WalletTextView)localView.findViewById(a.f.hpcl_quota_tv));
    this.DKs = ((TextView)localView.findViewById(a.f.hpcl_username_tv));
    this.DKt = ((TextView)localView.findViewById(a.f.hpcl_remain_tv));
    this.DKv = ((TextView)localView.findViewById(a.f.hpcl_card_type_tv));
    this.DKw = ((CdnImageView)localView.findViewById(a.f.hpcl_card_type_iv));
    this.DKu.setPrefix(ah.ijb());
    AppMethodBeat.o(64681);
  }
  
  public void setCardRecord(cjy paramcjy)
  {
    long l1 = 0L;
    AppMethodBeat.i(64682);
    this.DKa = paramcjy.TfK;
    this.DKv.setText(paramcjy.tpo);
    if (!Util.isNullOrNil(paramcjy.icon)) {
      this.DKw.hr(paramcjy.icon, c.UU(paramcjy.qJt));
    }
    a.b.a(this.tXu, paramcjy.SkU, 0.06F, false);
    g.j(this.DKs, paramcjy.SkU);
    this.DKu.setText(c.Od(paramcjy.SqZ));
    if (paramcjy.Trv == 0)
    {
      this.DKt.setTextColor(getResources().getColor(a.c.Orange));
      this.DKt.setText(a.i.honey_pay_waiting_for_receive);
      AppMethodBeat.o(64682);
      return;
    }
    long l2;
    if (paramcjy.Trv == 1) {
      if (paramcjy.Trx == 0L)
      {
        l2 = paramcjy.Trw;
        if (l2 >= 0L) {
          break label286;
        }
        Log.w("MicroMsg.HoneyPayCardLayout", "unused quota wrong: %s", new Object[] { Long.valueOf(l2) });
      }
    }
    for (;;)
    {
      this.DKt.setText(getContext().getString(a.i.honey_pay_used_month, new Object[] { ah.ijb() + c.Od(l1) }));
      AppMethodBeat.o(64682);
      return;
      Log.i("MicroMsg.HoneyPayCardLayout", "show check detail");
      this.DKt.setText("");
      AppMethodBeat.o(64682);
      return;
      Log.w("MicroMsg.HoneyPayCardLayout", "unknown rcvd: %s", new Object[] { Integer.valueOf(paramcjy.Trv) });
      AppMethodBeat.o(64682);
      return;
      label286:
      l1 = l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardLayout
 * JD-Core Version:    0.7.0.1
 */