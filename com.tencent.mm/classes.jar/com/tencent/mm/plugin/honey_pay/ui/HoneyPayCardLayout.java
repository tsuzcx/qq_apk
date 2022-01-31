package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.apf;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;

public class HoneyPayCardLayout
  extends LinearLayout
{
  private ImageView iIS;
  private TextView lkA;
  private TextView lkB;
  private WalletTextView lkC;
  private TextView lkD;
  private CdnImageView lkE;
  private String lki;
  
  public HoneyPayCardLayout(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public HoneyPayCardLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public HoneyPayCardLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    View localView = inflate(getContext(), a.g.honey_pay_card_layout, this);
    this.iIS = ((ImageView)localView.findViewById(a.f.hpcl_avatar_iv));
    this.lkC = ((WalletTextView)localView.findViewById(a.f.hpcl_quota_tv));
    this.lkA = ((TextView)localView.findViewById(a.f.hpcl_username_tv));
    this.lkB = ((TextView)localView.findViewById(a.f.hpcl_remain_tv));
    this.lkD = ((TextView)localView.findViewById(a.f.hpcl_card_type_tv));
    this.lkE = ((CdnImageView)localView.findViewById(a.f.hpcl_card_type_iv));
    this.lkC.setPrefix(ab.cML());
  }
  
  public void setCardRecord(apf paramapf)
  {
    long l1 = 0L;
    this.lki = paramapf.tef;
    this.lkD.setText(paramapf.imz);
    if (!bk.bl(paramapf.bVO)) {
      this.lkE.dl(paramapf.bVO, c.sr(paramapf.ilo));
    }
    a.b.a(this.iIS, paramapf.sMy, 0.06F, false);
    e.f(this.lkA, paramapf.sMy);
    this.lkC.setText(c.eR(paramapf.sQd));
    if (paramapf.tlh == 0)
    {
      this.lkB.setTextColor(Color.parseColor("#FA9D3B"));
      this.lkB.setText(a.i.honey_pay_waiting_for_receive);
      return;
    }
    long l2;
    if (paramapf.tlh == 1) {
      if (paramapf.tlj == 0L)
      {
        l2 = paramapf.tli;
        if (l2 >= 0L) {
          break label254;
        }
        y.w("MicroMsg.HoneyPayCardLayout", "unused quota wrong: %s", new Object[] { Long.valueOf(l2) });
      }
    }
    for (;;)
    {
      this.lkB.setText(getContext().getString(a.i.honey_pay_used_month, new Object[] { ab.cML() + c.eR(l1) }));
      return;
      y.i("MicroMsg.HoneyPayCardLayout", "show check detail");
      this.lkB.setText("");
      return;
      y.w("MicroMsg.HoneyPayCardLayout", "unknown rcvd: %s", new Object[] { Integer.valueOf(paramapf.tlh) });
      return;
      label254:
      l1 = l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardLayout
 * JD-Core Version:    0.7.0.1
 */