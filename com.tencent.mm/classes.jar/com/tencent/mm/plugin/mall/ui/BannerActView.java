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
import com.tencent.mm.wallet_core.ui.i;
import java.util.List;

public class BannerActView
  extends LinearLayout
{
  private z KJA;
  private TextView KJB;
  private List<com.tencent.mm.plugin.wallet_core.model.mall.a> KJz;
  
  public BannerActView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(66024);
    this.KJB = ((TextView)LayoutInflater.from(getContext()).inflate(a.g.banner_activity_view, this, true).findViewById(a.f.mall_banner_wording));
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(66023);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mall/ui/BannerActView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        BannerActView.this.setVisibility(8);
        com.tencent.mm.plugin.wallet_core.model.mall.b.lY(BannerActView.a(BannerActView.this));
        if ((BannerActView.a(BannerActView.this) != null) && (BannerActView.a(BannerActView.this).size() > 0)) {
          i.bC(BannerActView.this.getContext(), ((com.tencent.mm.plugin.wallet_core.model.mall.a)BannerActView.a(BannerActView.this).get(0)).VKF);
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
    this.KJz = paramList;
    if ((this.KJz == null) || (this.KJz.size() <= 0)) {
      Log.i("MicroMsg.BannerActivityView", "func[setActivityList] actList null");
    }
    while (!com.tencent.mm.plugin.wallet_core.model.mall.b.lX(this.KJz))
    {
      setVisibility(8);
      AppMethodBeat.o(66026);
      return;
    }
    this.KJB.setText(((com.tencent.mm.plugin.wallet_core.model.mall.a)this.KJz.get(0)).VKE);
    setVisibility(0);
    AppMethodBeat.o(66026);
  }
  
  public void setData(z paramz)
  {
    AppMethodBeat.i(66025);
    this.KJA = paramz;
    if (this.KJA != null)
    {
      this.KJB.setText(this.KJA.field_bulletin_content);
      setVisibility(0);
      AppMethodBeat.o(66025);
      return;
    }
    setVisibility(8);
    AppMethodBeat.o(66025);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.BannerActView
 * JD-Core Version:    0.7.0.1
 */