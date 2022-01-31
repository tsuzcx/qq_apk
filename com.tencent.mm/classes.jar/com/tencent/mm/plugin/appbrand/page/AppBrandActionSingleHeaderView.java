package com.tencent.mm.plugin.appbrand.page;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandActionSingleHeaderView
  extends LinearLayout
{
  private ImageView cuM;
  private TextView euY;
  
  public AppBrandActionSingleHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(87015);
    init(paramContext);
    AppMethodBeat.o(87015);
  }
  
  @TargetApi(11)
  public AppBrandActionSingleHeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(87016);
    init(paramContext);
    AppMethodBeat.o(87016);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(87017);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130968766, this);
    this.cuM = ((ImageView)findViewById(2131821511));
    this.euY = ((TextView)findViewById(2131821512));
    AppMethodBeat.o(87017);
  }
  
  public ImageView getImageView()
  {
    return this.cuM;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(87019);
    this.cuM.setImageDrawable(paramDrawable);
    AppMethodBeat.o(87019);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(87018);
    this.cuM.setImageResource(paramInt);
    AppMethodBeat.o(87018);
  }
  
  public void setTextViewText(String paramString)
  {
    AppMethodBeat.i(87020);
    this.euY.setText(paramString);
    AppMethodBeat.o(87020);
  }
  
  public void setTextViewTextColor(int paramInt)
  {
    AppMethodBeat.i(87021);
    this.euY.setTextColor(paramInt);
    AppMethodBeat.o(87021);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.AppBrandActionSingleHeaderView
 * JD-Core Version:    0.7.0.1
 */