package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.mall.a;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

public class BannerActView
  extends LinearLayout
{
  private List<a> tsE;
  private x tsF;
  private TextView tsG;
  
  public BannerActView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(66024);
    this.tsG = ((TextView)LayoutInflater.from(getContext()).inflate(2131493168, this, true).findViewById(2131302007));
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(66023);
        BannerActView.this.setVisibility(8);
        b.gn(BannerActView.a(BannerActView.this));
        if ((BannerActView.a(BannerActView.this) != null) && (BannerActView.a(BannerActView.this).size() > 0)) {
          e.aS(BannerActView.this.getContext(), ((a)BannerActView.a(BannerActView.this).get(0)).Aiz);
        }
        AppMethodBeat.o(66023);
      }
    });
    AppMethodBeat.o(66024);
  }
  
  public void setActivityList(List<a> paramList)
  {
    AppMethodBeat.i(66026);
    this.tsE = paramList;
    if ((this.tsE == null) || (this.tsE.size() <= 0)) {
      ad.i("MicroMsg.BannerActivityView", "func[setActivityList] actList null");
    }
    while (!b.gm(this.tsE))
    {
      setVisibility(8);
      AppMethodBeat.o(66026);
      return;
    }
    this.tsG.setText(((a)this.tsE.get(0)).Aiy);
    setVisibility(0);
    AppMethodBeat.o(66026);
  }
  
  public void setData(x paramx)
  {
    AppMethodBeat.i(66025);
    this.tsF = paramx;
    if (this.tsF != null)
    {
      this.tsG.setText(this.tsF.field_bulletin_content);
      setVisibility(0);
      AppMethodBeat.o(66025);
      return;
    }
    setVisibility(8);
    AppMethodBeat.o(66025);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.BannerActView
 * JD-Core Version:    0.7.0.1
 */