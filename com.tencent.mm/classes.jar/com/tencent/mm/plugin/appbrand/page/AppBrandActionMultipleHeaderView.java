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
  private ImageView cuM;
  private TextView euY;
  private String iuQ;
  private String path;
  private int type;
  private String username;
  
  public AppBrandActionMultipleHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(87008);
    init(paramContext);
    AppMethodBeat.o(87008);
  }
  
  @TargetApi(11)
  public AppBrandActionMultipleHeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(87009);
    init(paramContext);
    AppMethodBeat.o(87009);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(87010);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130968765, this);
    this.cuM = ((ImageView)findViewById(2131821509));
    this.euY = ((TextView)findViewById(2131821510));
    AppMethodBeat.o(87010);
  }
  
  public String getH5Url()
  {
    return this.iuQ;
  }
  
  public ImageView getImageView()
  {
    return this.cuM;
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
    AppMethodBeat.i(87012);
    this.cuM.setImageDrawable(paramDrawable);
    AppMethodBeat.o(87012);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(87011);
    this.cuM.setImageResource(paramInt);
    AppMethodBeat.o(87011);
  }
  
  public void setTextViewText(String paramString)
  {
    AppMethodBeat.i(87013);
    this.euY.setText(paramString);
    AppMethodBeat.o(87013);
  }
  
  public void setTextViewTextColor(int paramInt)
  {
    AppMethodBeat.i(87014);
    this.euY.setTextColor(paramInt);
    AppMethodBeat.o(87014);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.AppBrandActionMultipleHeaderView
 * JD-Core Version:    0.7.0.1
 */