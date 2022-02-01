package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class PoiHeaderView
  extends RelativeLayout
{
  public String KeA;
  public SimpleImageView KeB;
  public String Kez;
  private Context context;
  public TextView lKQ;
  
  public PoiHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55854);
    this.Kez = "";
    this.KeA = "";
    this.context = paramContext;
    paramContext = View.inflate(this.context, a.f.poi_header_view, this);
    this.lKQ = ((TextView)paramContext.findViewById(a.e.header_text));
    this.KeB = ((SimpleImageView)paramContext.findViewById(a.e.header_logo));
    this.lKQ.setVisibility(8);
    this.KeB.setVisibility(8);
    setVisibility(8);
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(55853);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/location/ui/PoiHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        localObject = new Intent();
        if (Util.isNullOrNil(PoiHeaderView.a(PoiHeaderView.this))) {}
        for (paramAnonymousView = PoiHeaderView.b(PoiHeaderView.this);; paramAnonymousView = PoiHeaderView.a(PoiHeaderView.this))
        {
          Log.d("MicroMsg.PoiHeaderView", "click url %s", new Object[] { paramAnonymousView });
          ((Intent)localObject).putExtra("rawUrl", paramAnonymousView);
          ((Intent)localObject).putExtra("showShare", false);
          c.g(PoiHeaderView.this.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", (Intent)localObject);
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
    Log.d("MicroMsg.PoiHeaderView", "viewUrl ".concat(String.valueOf(paramString)));
    this.KeA = paramString;
    AppMethodBeat.o(55855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.PoiHeaderView
 * JD-Core Version:    0.7.0.1
 */