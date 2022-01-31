package com.tencent.mm.plugin.messenger;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.pluginsdk.ui.a.b;

public class SwitchContactDialogCustomView
  extends LinearLayout
{
  private TextView NI;
  private TextView mcp;
  private ImageView mcq;
  private TextView mcr;
  private TextView mcs;
  
  public SwitchContactDialogCustomView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwitchContactDialogCustomView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(b.b.alert_comfirm_custom_area, this);
    this.NI = ((TextView)findViewById(b.a.title));
    this.mcp = ((TextView)findViewById(b.a.content));
    this.mcq = ((ImageView)findViewById(b.a.photo));
    this.mcr = ((TextView)findViewById(b.a.desc));
    this.mcs = ((TextView)findViewById(b.a.sub_desc));
  }
  
  public void setContent(String paramString)
  {
    this.mcp.setText(paramString);
  }
  
  public void setDesc(String paramString)
  {
    this.mcr.setText(paramString);
  }
  
  public void setOnPhotoOnClick(View.OnClickListener paramOnClickListener)
  {
    if (this.mcq != null) {
      this.mcq.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setPhoto(String paramString)
  {
    a.b.a(this.mcq, paramString);
  }
  
  public void setSubDesc(String paramString)
  {
    this.mcs.setText(paramString);
  }
  
  public void setTilte(String paramString)
  {
    this.NI.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.SwitchContactDialogCustomView
 * JD-Core Version:    0.7.0.1
 */