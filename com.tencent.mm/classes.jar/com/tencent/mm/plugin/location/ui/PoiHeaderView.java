package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class PoiHeaderView
  extends RelativeLayout
{
  private Context context;
  public TextView fRf;
  public String vbV;
  public String vbW;
  public SimpleImageView vbX;
  
  public PoiHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55854);
    this.vbV = "";
    this.vbW = "";
    this.context = paramContext;
    paramContext = View.inflate(this.context, 2131495098, this);
    this.fRf = ((TextView)paramContext.findViewById(2131300728));
    this.vbX = ((SimpleImageView)paramContext.findViewById(2131300721));
    this.fRf.setVisibility(8);
    this.vbX.setVisibility(8);
    setVisibility(8);
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(55853);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/location/ui/PoiHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        localObject = new Intent();
        if (bt.isNullOrNil(PoiHeaderView.a(PoiHeaderView.this))) {}
        for (paramAnonymousView = PoiHeaderView.b(PoiHeaderView.this);; paramAnonymousView = PoiHeaderView.a(PoiHeaderView.this))
        {
          ad.d("MicroMsg.PoiHeaderView", "click url %s", new Object[] { paramAnonymousView });
          ((Intent)localObject).putExtra("rawUrl", paramAnonymousView);
          ((Intent)localObject).putExtra("showShare", false);
          d.f(PoiHeaderView.this.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", (Intent)localObject);
          a.a(this, "com/tencent/mm/plugin/location/ui/PoiHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(55853);
          return;
        }
      }
    });
    AppMethodBeat.o(55854);
  }
  
  public void setViewUrl(String paramString)
  {
    AppMethodBeat.i(55855);
    ad.d("MicroMsg.PoiHeaderView", "viewUrl ".concat(String.valueOf(paramString)));
    this.vbW = paramString;
    AppMethodBeat.o(55855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.PoiHeaderView
 * JD-Core Version:    0.7.0.1
 */