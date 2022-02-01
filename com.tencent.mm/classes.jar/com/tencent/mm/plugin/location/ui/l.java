package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.plugin.map.a.d;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.plugin.q.d;

public final class l
  implements c
{
  private String Ejj;
  public double Ejn;
  public double Ejo;
  public boolean ElI;
  private View ElJ;
  private TextView Ell;
  private ProgressBar Elm;
  private String Elp;
  public final String EoE;
  public ImageView EoF;
  public FrameLayout EoG;
  private TextView EoH;
  public boolean EoI;
  public boolean fCB;
  public boolean isVisible;
  private Context mContext;
  public ViewManager mViewManager;
  public String poiName;
  
  public l(d paramd, Context paramContext)
  {
    AppMethodBeat.i(55993);
    this.EoE = "info_window_tag";
    this.fCB = false;
    this.ElI = true;
    this.Ejn = 1000000.0D;
    this.Ejo = 1000000.0D;
    this.isVisible = true;
    this.Elp = "";
    this.mContext = paramContext;
    this.EoI = false;
    this.EoF = new ImageView(paramContext);
    this.EoF.setBackgroundResource(a.d.mm_trans);
    this.EoF.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.EoG = ((FrameLayout)View.inflate(paramContext, a.f.map_overlay_layout, null));
    this.EoF.setImageResource(a.d.location_current_marker);
    this.ElJ = this.EoG;
    this.mViewManager = ((ViewManager)paramd.getViewManager());
    AppMethodBeat.o(55993);
  }
  
  public final String getPreText()
  {
    return this.Elp;
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(55994);
    this.Ejj = paramString;
    paramString = this.Ejj;
    this.Ell = ((TextView)this.EoG.findViewById(a.e.location_tips));
    this.Elm = ((ProgressBar)this.EoG.findViewById(a.e.location_load_progress));
    this.EoH = ((TextView)this.EoG.findViewById(a.e.location_poiname));
    if ((paramString == null) || (paramString.equals("")))
    {
      this.Elm.setVisibility(0);
      if ((this.poiName == null) || (this.poiName.equals(""))) {
        break label204;
      }
      this.EoH.setVisibility(0);
      this.EoH.setText(this.poiName);
    }
    for (;;)
    {
      if (this.ElI)
      {
        this.mViewManager.updateViewLayout(this.EoF, this.Ejn, this.Ejo, false);
        if (this.EoI) {
          this.mViewManager.showInfoWindowByView(this.EoF);
        }
      }
      AppMethodBeat.o(55994);
      return;
      this.Elm.setVisibility(8);
      this.Ell.setVisibility(0);
      this.Ell.setText(paramString);
      break;
      label204:
      this.EoH.setText("");
      this.EoH.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.l
 * JD-Core Version:    0.7.0.1
 */