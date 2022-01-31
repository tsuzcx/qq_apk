package com.tencent.mm.plugin.location.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.ui.base.MMImageButton;

public class ShareHeader
  extends LinearLayout
{
  private TextView eXr;
  private ViewGroup lFJ;
  private MMImageButton lFK;
  private MMImageButton lFL;
  private Context mContext;
  
  public ShareHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  @TargetApi(11)
  public ShareHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    init();
  }
  
  private void init()
  {
    View localView = View.inflate(this.mContext, a.f.share_header, this);
    this.lFJ = ((ViewGroup)localView.findViewById(a.e.header_bar));
    this.lFK = ((MMImageButton)localView.findViewById(a.e.title_left_button));
    this.lFL = ((MMImageButton)localView.findViewById(a.e.title_right_button));
    this.eXr = ((TextView)localView.findViewById(a.e.title));
  }
  
  public ViewGroup getHeaderBar()
  {
    return this.lFJ;
  }
  
  public void setOnLeftClickListener(View.OnClickListener paramOnClickListener)
  {
    this.lFK.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnRightClickListener(View.OnClickListener paramOnClickListener)
  {
    this.lFL.setOnClickListener(paramOnClickListener);
  }
  
  public void setTitle(String paramString)
  {
    this.eXr.setText(paramString);
  }
  
  public void setTitleColor(int paramInt)
  {
    this.eXr.setTextColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.ShareHeader
 * JD-Core Version:    0.7.0.1
 */