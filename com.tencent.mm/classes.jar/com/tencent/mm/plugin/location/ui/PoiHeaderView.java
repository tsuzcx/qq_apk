package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.sdk.platformtools.y;

public class PoiHeaderView
  extends RelativeLayout
{
  private Context context;
  public TextView dqa;
  public String lFt = "";
  public String lFu = "";
  public SimpleImageView lFv;
  
  public PoiHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    paramContext = View.inflate(this.context, a.f.poi_header_view, this);
    this.dqa = ((TextView)paramContext.findViewById(a.e.header_text));
    this.lFv = ((SimpleImageView)paramContext.findViewById(a.e.header_logo));
    this.dqa.setVisibility(8);
    this.lFv.setVisibility(8);
    setVisibility(8);
    setOnClickListener(new PoiHeaderView.1(this));
  }
  
  public void setViewUrl(String paramString)
  {
    y.d("MicroMsg.PoiHeaderView", "viewUrl " + paramString);
    this.lFu = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.PoiHeaderView
 * JD-Core Version:    0.7.0.1
 */