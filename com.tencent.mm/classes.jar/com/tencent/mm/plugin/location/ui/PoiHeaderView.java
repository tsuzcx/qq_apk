package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public class PoiHeaderView
  extends RelativeLayout
{
  private Context context;
  public TextView fxS;
  public String tZm;
  public String tZn;
  public SimpleImageView tZo;
  
  public PoiHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55854);
    this.tZm = "";
    this.tZn = "";
    this.context = paramContext;
    paramContext = View.inflate(this.context, 2131495098, this);
    this.fxS = ((TextView)paramContext.findViewById(2131300728));
    this.tZo = ((SimpleImageView)paramContext.findViewById(2131300721));
    this.fxS.setVisibility(8);
    this.tZo.setVisibility(8);
    setVisibility(8);
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(55853);
        Intent localIntent = new Intent();
        if (bs.isNullOrNil(PoiHeaderView.a(PoiHeaderView.this))) {}
        for (paramAnonymousView = PoiHeaderView.b(PoiHeaderView.this);; paramAnonymousView = PoiHeaderView.a(PoiHeaderView.this))
        {
          ac.d("MicroMsg.PoiHeaderView", "click url %s", new Object[] { paramAnonymousView });
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
    ac.d("MicroMsg.PoiHeaderView", "viewUrl ".concat(String.valueOf(paramString)));
    this.tZn = paramString;
    AppMethodBeat.o(55855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.PoiHeaderView
 * JD-Core Version:    0.7.0.1
 */