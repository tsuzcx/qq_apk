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
  private ImageView djK;
  private TextView ss;
  
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
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131493092, this);
    this.djK = ((ImageView)findViewById(2131296889));
    this.ss = ((TextView)findViewById(2131296890));
    AppMethodBeat.o(134942);
  }
  
  public ImageView getImageView()
  {
    return this.djK;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(134944);
    this.djK.setImageDrawable(paramDrawable);
    AppMethodBeat.o(134944);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(134943);
    this.djK.setImageResource(paramInt);
    AppMethodBeat.o(134943);
  }
  
  public void setTextViewText(String paramString)
  {
    AppMethodBeat.i(134945);
    this.ss.setText(paramString);
    AppMethodBeat.o(134945);
  }
  
  public void setTextViewTextColor(int paramInt)
  {
    AppMethodBeat.i(134946);
    this.ss.setTextColor(paramInt);
    AppMethodBeat.o(134946);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.AppBrandActionSingleHeaderView
 * JD-Core Version:    0.7.0.1
 */