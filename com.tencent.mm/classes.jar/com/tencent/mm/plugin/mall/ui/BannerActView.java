package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.ui.f;
import java.util.List;

public class BannerActView
  extends LinearLayout
{
  private List<com.tencent.mm.plugin.wallet_core.model.mall.a> vPG;
  private y vPH;
  private TextView vPI;
  
  public BannerActView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(66024);
    this.vPI = ((TextView)LayoutInflater.from(getContext()).inflate(2131493168, this, true).findViewById(2131302007));
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(66023);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/BannerActView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        BannerActView.this.setVisibility(8);
        com.tencent.mm.plugin.wallet_core.model.mall.b.gU(BannerActView.a(BannerActView.this));
        if ((BannerActView.a(BannerActView.this) != null) && (BannerActView.a(BannerActView.this).size() > 0)) {
          f.aY(BannerActView.this.getContext(), ((com.tencent.mm.plugin.wallet_core.model.mall.a)BannerActView.a(BannerActView.this).get(0)).DsQ);
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
    this.vPG = paramList;
    if ((this.vPG == null) || (this.vPG.size() <= 0)) {
      ae.i("MicroMsg.BannerActivityView", "func[setActivityList] actList null");
    }
    while (!com.tencent.mm.plugin.wallet_core.model.mall.b.gT(this.vPG))
    {
      setVisibility(8);
      AppMethodBeat.o(66026);
      return;
    }
    this.vPI.setText(((com.tencent.mm.plugin.wallet_core.model.mall.a)this.vPG.get(0)).DsP);
    setVisibility(0);
    AppMethodBeat.o(66026);
  }
  
  public void setData(y paramy)
  {
    AppMethodBeat.i(66025);
    this.vPH = paramy;
    if (this.vPH != null)
    {
      this.vPI.setText(this.vPH.field_bulletin_content);
      setVisibility(0);
      AppMethodBeat.o(66025);
      return;
    }
    setVisibility(8);
    AppMethodBeat.o(66025);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.BannerActView
 * JD-Core Version:    0.7.0.1
 */