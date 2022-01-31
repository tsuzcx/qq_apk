package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.h;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.sdk.platformtools.y;

public final class f
  implements c
{
  public boolean bMo = false;
  private boolean isVisible = true;
  private String lCF;
  private double lCJ = 1000000.0D;
  private double lCK = 1000000.0D;
  private String lEK = "";
  private boolean lFk = true;
  private View lFl;
  private d lFm;
  public String lFn;
  private TextView lFo;
  private TextView lFp;
  public ImageButton lFq;
  
  public f(d paramd, Context paramContext)
  {
    paramContext = ((Activity)paramContext).findViewById(a.e.location_info_frame);
    this.lFo = ((TextView)paramContext.findViewById(a.e.location_info));
    this.lFp = ((TextView)paramContext.findViewById(a.e.location_info_detail));
    this.lFq = ((ImageButton)paramContext.findViewById(a.e.location_navigate_iv));
    this.lFm = paramd;
    this.lFl = paramContext;
  }
  
  public final String getPreText()
  {
    return this.lEK;
  }
  
  public final void setText(String paramString)
  {
    this.lCF = paramString;
    paramString = this.lCF;
    y.d("NewItemOverlay", "popView " + this.lFl.getWidth() + " " + this.lFl.getHeight());
    if ((paramString != null) && (!paramString.equals(""))) {
      this.lFp.setText(paramString);
    }
    if ((this.lFn != null) && (!this.lFn.equals(""))) {
      this.lFo.setText(this.lFn);
    }
    for (;;)
    {
      if (this.lFk)
      {
        this.lFl.setVisibility(0);
        this.lFl.invalidate();
      }
      return;
      this.lFo.setText(a.h.location_conversation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.f
 * JD-Core Version:    0.7.0.1
 */