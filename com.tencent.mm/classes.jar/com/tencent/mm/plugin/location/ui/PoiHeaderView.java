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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class PoiHeaderView
  extends RelativeLayout
{
  private Context context;
  public TextView ful;
  public String sQZ;
  public String sRa;
  public SimpleImageView sRb;
  
  public PoiHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55854);
    this.sQZ = "";
    this.sRa = "";
    this.context = paramContext;
    paramContext = View.inflate(this.context, 2131495098, this);
    this.ful = ((TextView)paramContext.findViewById(2131300728));
    this.sRb = ((SimpleImageView)paramContext.findViewById(2131300721));
    this.ful.setVisibility(8);
    this.sRb.setVisibility(8);
    setVisibility(8);
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(55853);
        Intent localIntent = new Intent();
        if (bt.isNullOrNil(PoiHeaderView.a(PoiHeaderView.this))) {}
        for (paramAnonymousView = PoiHeaderView.b(PoiHeaderView.this);; paramAnonymousView = PoiHeaderView.a(PoiHeaderView.this))
        {
          ad.d("MicroMsg.PoiHeaderView", "click url %s", new Object[] { paramAnonymousView });
          localIntent.putExtra("rawUrl", paramAnonymousView);
          localIntent.putExtra("showShare", false);
          d.e(PoiHeaderView.this.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
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
    this.sRa = paramString;
    AppMethodBeat.o(55855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.PoiHeaderView
 * JD-Core Version:    0.7.0.1
 */