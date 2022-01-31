package com.tencent.mm.plugin.facedetect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class FaceHeaderPreference
  extends Preference
{
  private MMActivity bER;
  private TextView eXr;
  private ImageView heN;
  private int jRP = 255;
  private Button jRQ;
  private View jRR;
  private View.OnClickListener jRS = null;
  private String jRT = "";
  private String jRU = "";
  private String mTitle = "";
  
  public FaceHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    this.bER = ((MMActivity)paramContext);
  }
  
  public FaceHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.bER = ((MMActivity)paramContext);
    setLayoutResource(a.g.face_print_pref_header);
  }
  
  public final void c(View.OnClickListener paramOnClickListener)
  {
    this.jRS = paramOnClickListener;
    if ((this.jRQ == null) || (this.jRR == null)) {
      return;
    }
    if ((this.jRQ != null) && (this.jRS != null))
    {
      this.jRQ.setOnClickListener(paramOnClickListener);
      this.jRQ.setVisibility(0);
      this.jRR.setVisibility(0);
      return;
    }
    this.jRQ.setVisibility(8);
    this.jRR.setVisibility(8);
  }
  
  public final void cY(String paramString1, String paramString2)
  {
    this.jRT = paramString1;
    this.jRU = paramString2;
    if (this.eXr != null)
    {
      if (!bk.bl(this.jRT))
      {
        this.eXr.setText(this.jRT);
        this.eXr.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.eXr.setVisibility(8);
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.heN = ((ImageView)paramView.findViewById(a.e.face_print_sucesss_icon));
    this.eXr = ((TextView)paramView.findViewById(a.e.face_print_title));
    this.jRQ = ((Button)paramView.findViewById(a.e.right_btn));
    this.jRR = paramView.findViewById(a.e.button_ll);
    if (!bk.bl(this.jRT))
    {
      this.eXr.setText(this.jRT);
      this.eXr.setVisibility(0);
    }
    while ((this.jRQ != null) && (this.jRS != null))
    {
      this.jRQ.setOnClickListener(this.jRS);
      this.jRQ.setVisibility(0);
      this.jRR.setVisibility(0);
      return;
      this.eXr.setVisibility(8);
    }
    if (this.jRQ != null) {
      this.jRQ.setVisibility(8);
    }
    this.jRR.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceHeaderPreference
 * JD-Core Version:    0.7.0.1
 */