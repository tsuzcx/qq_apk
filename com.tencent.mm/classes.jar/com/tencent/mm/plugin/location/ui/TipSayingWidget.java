package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.plugin.map.a.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bk;

public class TipSayingWidget
  extends LinearLayout
{
  private Context context;
  private String diG;
  private TextView dqa;
  private ImageView lGW;
  private Chronometer lGX;
  private int lGY = 0;
  
  public TipSayingWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    paramContext = View.inflate(this.context, a.f.tips_saying, this);
    this.lGW = ((ImageView)paramContext.findViewById(a.e.saying_iv));
    this.dqa = ((TextView)paramContext.findViewById(a.e.sayint_tips));
    this.lGX = ((Chronometer)findViewById(a.e.chronometer));
  }
  
  public void setCurSaying(String paramString)
  {
    if (bk.bl(paramString))
    {
      setVisibility(8);
      return;
    }
    setVisibility(0);
    a.b.p(this.lGW, paramString);
    if (bk.bl(this.diG)) {
      this.diG = q.Gj();
    }
    if (this.diG.equals(paramString))
    {
      this.dqa.setText(this.context.getString(a.h.track_somebody_saying, new Object[] { paramString }));
      this.lGX.setVisibility(0);
      return;
    }
    this.dqa.setText(this.context.getString(a.h.track_somebody_saying, new Object[] { paramString }));
    this.lGX.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.TipSayingWidget
 * JD-Core Version:    0.7.0.1
 */