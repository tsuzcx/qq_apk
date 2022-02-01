package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.z;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.g;
import java.util.List;

public class BannerActView
  extends LinearLayout
{
  private List<com.tencent.mm.plugin.wallet_core.model.mall.a> EPb;
  private z EPc;
  private TextView EPd;
  
  public BannerActView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(66024);
    this.EPd = ((TextView)LayoutInflater.from(getContext()).inflate(a.g.banner_activity_view, this, true).findViewById(a.f.mall_banner_wording));
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(66023);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mall/ui/BannerActView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        BannerActView.this.setVisibility(8);
        com.tencent.mm.plugin.wallet_core.model.mall.b.iQ(BannerActView.a(BannerActView.this));
        if ((BannerActView.a(BannerActView.this) != null) && (BannerActView.a(BannerActView.this).size() > 0)) {
          g.bA(BannerActView.this.getContext(), ((com.tencent.mm.plugin.wallet_core.model.mall.a)BannerActView.a(BannerActView.this).get(0)).OUo);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/BannerActView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(66023);
      }
    });
    AppMethodBeat.o(66024);
  }
  
  public void setActivityList(List<com.tencent.mm.plugin.wallet_core.model.mall.a> paramList)
  {
    AppMethodBeat.i(66026);
    this.EPb = paramList;
    if ((this.EPb == null) || (this.EPb.size() <= 0)) {
      Log.i("MicroMsg.BannerActivityView", "func[setActivityList] actList null");
    }
    while (!com.tencent.mm.plugin.wallet_core.model.mall.b.iP(this.EPb))
    {
      setVisibility(8);
      AppMethodBeat.o(66026);
      return;
    }
    this.EPd.setText(((com.tencent.mm.plugin.wallet_core.model.mall.a)this.EPb.get(0)).OUn);
    setVisibility(0);
    AppMethodBeat.o(66026);
  }
  
  public void setData(z paramz)
  {
    AppMethodBeat.i(66025);
    this.EPc = paramz;
    if (this.EPc != null)
    {
      this.EPd.setText(this.EPc.field_bulletin_content);
      setVisibility(0);
      AppMethodBeat.o(66025);
      return;
    }
    setVisibility(8);
    AppMethodBeat.o(66025);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.BannerActView
 * JD-Core Version:    0.7.0.1
 */