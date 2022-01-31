package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.k.d;
import com.tencent.mm.plugin.location_soso.ViewManager;

public final class n
  implements c
{
  public boolean ctJ;
  public String eSM;
  public boolean isVisible;
  private Context mContext;
  public ViewManager mViewManager;
  private String nZR;
  public double nZV;
  public double nZW;
  private TextView obU;
  private ProgressBar obV;
  private String obY;
  public boolean ocy;
  private View ocz;
  public final String ofa;
  public ImageView ofb;
  public FrameLayout ofc;
  private TextView ofd;
  public boolean ofe;
  
  public n(d paramd, Context paramContext)
  {
    AppMethodBeat.i(113587);
    this.ofa = "info_window_tag";
    this.ctJ = false;
    this.ocy = true;
    this.nZV = 1000000.0D;
    this.nZW = 1000000.0D;
    this.isVisible = true;
    this.obY = "";
    this.mContext = paramContext;
    this.ofe = false;
    this.ofb = new ImageView(paramContext);
    this.ofb.setBackgroundResource(2130839676);
    this.ofb.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.ofc = ((FrameLayout)View.inflate(paramContext, 2130970117, null));
    this.ofb.setImageResource(2130839292);
    this.ocz = this.ofc;
    this.mViewManager = ((ViewManager)paramd.getViewManager());
    AppMethodBeat.o(113587);
  }
  
  public final String getPreText()
  {
    return this.obY;
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(113588);
    this.nZR = paramString;
    paramString = this.nZR;
    this.obU = ((TextView)this.ofc.findViewById(2131825439));
    this.obV = ((ProgressBar)this.ofc.findViewById(2131825438));
    this.ofd = ((TextView)this.ofc.findViewById(2131826084));
    if ((paramString == null) || (paramString.equals("")))
    {
      this.obV.setVisibility(0);
      if ((this.eSM == null) || (this.eSM.equals(""))) {
        break label201;
      }
      this.ofd.setVisibility(0);
      this.ofd.setText(this.eSM);
    }
    for (;;)
    {
      if (this.ocy)
      {
        this.mViewManager.updateViewLayout(this.ofb, this.nZV, this.nZW, false);
        if (this.ofe) {
          this.mViewManager.showInfoWindowByView(this.ofb);
        }
      }
      AppMethodBeat.o(113588);
      return;
      this.obV.setVisibility(8);
      this.obU.setVisibility(0);
      this.obU.setText(paramString);
      break;
      label201:
      this.ofd.setText("");
      this.ofd.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.n
 * JD-Core Version:    0.7.0.1
 */