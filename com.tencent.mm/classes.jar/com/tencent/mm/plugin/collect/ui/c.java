package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.preference.Preference;

public final class c
  extends Preference
{
  String djD = null;
  private TextView haW = null;
  private ImageView iIS = null;
  private Context mContext = null;
  String mTitle = null;
  private View mView = null;
  
  public c(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    setLayoutResource(a.g.collect_pay_info_preference);
  }
  
  public c(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.mContext = paramContext;
    setLayoutResource(paramInt);
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    return this.mView;
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.haW = ((TextView)paramView.findViewById(16908310));
    this.iIS = ((ImageView)paramView.findViewById(a.f.collect_payer_avatar));
    this.haW.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.mContext, this.mTitle, this.haW.getTextSize()));
    if (!bk.bl(this.djD))
    {
      this.iIS.setVisibility(0);
      g.DQ();
      paramView = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abk(this.djD);
      if ((paramView == null) || ((int)paramView.dBe <= 0))
      {
        y.d("MicroMsg.CollectPayInfoPreference", "Receiver in contactStg and try to get contact");
        long l = bk.UY();
        am.a.dVy.a(this.djD, "", new c.1(this, l));
        return;
      }
      a.b.a(this.iIS, this.djD);
      return;
    }
    this.iIS.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.c
 * JD-Core Version:    0.7.0.1
 */