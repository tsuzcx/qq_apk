package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.k.d;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;

public final class l
  implements c
{
  public boolean dfZ;
  public String gPy;
  public boolean isVisible;
  private Context mContext;
  public ViewManager mViewManager;
  private String tWE;
  public double tWI;
  public double tWJ;
  private TextView tYH;
  private ProgressBar tYI;
  private String tYL;
  public boolean tZe;
  private View tZf;
  public final String ucb;
  public ImageView ucc;
  public FrameLayout ucd;
  private TextView uce;
  public boolean ucf;
  
  public l(d paramd, Context paramContext)
  {
    AppMethodBeat.i(55993);
    this.ucb = "info_window_tag";
    this.dfZ = false;
    this.tZe = true;
    this.tWI = 1000000.0D;
    this.tWJ = 1000000.0D;
    this.isVisible = true;
    this.tYL = "";
    this.mContext = paramContext;
    this.ucf = false;
    this.ucc = new ImageView(paramContext);
    this.ucc.setBackgroundResource(2131233299);
    this.ucc.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.ucd = ((FrameLayout)View.inflate(paramContext, 2131494732, null));
    this.ucc.setImageResource(2131232887);
    this.tZf = this.ucd;
    this.mViewManager = ((ViewManager)paramd.getViewManager());
    AppMethodBeat.o(55993);
  }
  
  public final String getPreText()
  {
    return this.tYL;
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(55994);
    this.tWE = paramString;
    paramString = this.tWE;
    this.tYH = ((TextView)this.ucd.findViewById(2131301545));
    this.tYI = ((ProgressBar)this.ucd.findViewById(2131301532));
    this.uce = ((TextView)this.ucd.findViewById(2131301537));
    if ((paramString == null) || (paramString.equals("")))
    {
      this.tYI.setVisibility(0);
      if ((this.gPy == null) || (this.gPy.equals(""))) {
        break label201;
      }
      this.uce.setVisibility(0);
      this.uce.setText(this.gPy);
    }
    for (;;)
    {
      if (this.tZe)
      {
        this.mViewManager.updateViewLayout(this.ucc, this.tWI, this.tWJ, false);
        if (this.ucf) {
          this.mViewManager.showInfoWindowByView(this.ucc);
        }
      }
      AppMethodBeat.o(55994);
      return;
      this.tYI.setVisibility(8);
      this.tYH.setVisibility(0);
      this.tYH.setText(paramString);
      break;
      label201:
      this.uce.setText("");
      this.uce.setVisibility(8);
    }
  }
  
  public final class a
    implements TencentMap.InfoWindowAdapter
  {
    private a() {}
    
    public final View getInfoWindow(Marker paramMarker)
    {
      AppMethodBeat.i(55992);
      ac.i("ZItemOverlay", "get info window: %s", new Object[] { Integer.valueOf(l.this.ucd.getVisibility()) });
      if ("info_window_tag".equals(paramMarker.getTag()))
      {
        paramMarker = l.this.ucd;
        AppMethodBeat.o(55992);
        return paramMarker;
      }
      AppMethodBeat.o(55992);
      return null;
    }
    
    public final void onInfoWindowDettached(Marker paramMarker, View paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.l
 * JD-Core Version:    0.7.0.1
 */