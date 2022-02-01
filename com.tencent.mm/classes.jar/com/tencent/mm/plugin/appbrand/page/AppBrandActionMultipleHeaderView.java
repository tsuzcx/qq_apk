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

public class AppBrandActionMultipleHeaderView
  extends LinearLayout
{
  private ImageView dsD;
  private String lYC;
  private String path;
  private int type;
  private String username;
  private TextView vk;
  
  public AppBrandActionMultipleHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(134932);
    init(paramContext);
    AppMethodBeat.o(134932);
  }
  
  @TargetApi(11)
  public AppBrandActionMultipleHeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(134933);
    init(paramContext);
    AppMethodBeat.o(134933);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(134934);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131493091, this);
    this.dsD = ((ImageView)findViewById(2131296883));
    this.vk = ((TextView)findViewById(2131296884));
    AppMethodBeat.o(134934);
  }
  
  public String getH5Url()
  {
    return this.lYC;
  }
  
  public ImageView getImageView()
  {
    return this.dsD;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public String getUsername()
  {
    return this.username;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(134936);
    this.dsD.setImageDrawable(paramDrawable);
    AppMethodBeat.o(134936);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(134935);
    this.dsD.setImageResource(paramInt);
    AppMethodBeat.o(134935);
  }
  
  public void setTextViewText(String paramString)
  {
    AppMethodBeat.i(134937);
    this.vk.setText(paramString);
    AppMethodBeat.o(134937);
  }
  
  public void setTextViewTextColor(int paramInt)
  {
    AppMethodBeat.i(134938);
    this.vk.setTextColor(paramInt);
    AppMethodBeat.o(134938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.AppBrandActionMultipleHeaderView
 * JD-Core Version:    0.7.0.1
 */