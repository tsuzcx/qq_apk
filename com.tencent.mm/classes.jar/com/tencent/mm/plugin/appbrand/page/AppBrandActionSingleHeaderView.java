package com.tencent.mm.plugin.appbrand.page;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.wxa.a.d;
import com.tencent.luggage.wxa.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandActionSingleHeaderView
  extends LinearLayout
{
  private TextView bFR;
  private ImageView fDJ;
  
  public AppBrandActionSingleHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(134940);
    init(paramContext);
    AppMethodBeat.o(134940);
  }
  
  @TargetApi(11)
  public AppBrandActionSingleHeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(134941);
    init(paramContext);
    AppMethodBeat.o(134941);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(134942);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(a.e.appbrand_action_single_header, this);
    this.fDJ = ((ImageView)findViewById(a.d.appbrand_action_single_header_image));
    this.bFR = ((TextView)findViewById(a.d.appbrand_action_single_header_text));
    AppMethodBeat.o(134942);
  }
  
  public ImageView getImageView()
  {
    return this.fDJ;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(134944);
    this.fDJ.setImageDrawable(paramDrawable);
    AppMethodBeat.o(134944);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(134943);
    this.fDJ.setImageResource(paramInt);
    AppMethodBeat.o(134943);
  }
  
  public void setTextViewText(String paramString)
  {
    AppMethodBeat.i(134945);
    this.bFR.setText(paramString);
    AppMethodBeat.o(134945);
  }
  
  public void setTextViewTextColor(int paramInt)
  {
    AppMethodBeat.i(134946);
    this.bFR.setTextColor(paramInt);
    AppMethodBeat.o(134946);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.AppBrandActionSingleHeaderView
 * JD-Core Version:    0.7.0.1
 */