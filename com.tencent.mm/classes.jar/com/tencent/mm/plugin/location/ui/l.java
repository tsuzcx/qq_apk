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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;

public final class l
  implements c
{
  public boolean drv;
  public boolean isVisible;
  public String jDf;
  private Context mContext;
  public ViewManager mViewManager;
  private String uZn;
  public double uZr;
  public double uZs;
  public boolean vbN;
  private View vbO;
  private TextView vbq;
  private ProgressBar vbr;
  private String vbu;
  public final String veL;
  public ImageView veM;
  public FrameLayout veN;
  private TextView veO;
  public boolean veP;
  
  public l(d paramd, Context paramContext)
  {
    AppMethodBeat.i(55993);
    this.veL = "info_window_tag";
    this.drv = false;
    this.vbN = true;
    this.uZr = 1000000.0D;
    this.uZs = 1000000.0D;
    this.isVisible = true;
    this.vbu = "";
    this.mContext = paramContext;
    this.veP = false;
    this.veM = new ImageView(paramContext);
    this.veM.setBackgroundResource(2131233299);
    this.veM.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.veN = ((FrameLayout)View.inflate(paramContext, 2131494732, null));
    this.veM.setImageResource(2131232887);
    this.vbO = this.veN;
    this.mViewManager = ((ViewManager)paramd.getViewManager());
    AppMethodBeat.o(55993);
  }
  
  public final String getPreText()
  {
    return this.vbu;
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(55994);
    this.uZn = paramString;
    paramString = this.uZn;
    this.vbq = ((TextView)this.veN.findViewById(2131301545));
    this.vbr = ((ProgressBar)this.veN.findViewById(2131301532));
    this.veO = ((TextView)this.veN.findViewById(2131301537));
    if ((paramString == null) || (paramString.equals("")))
    {
      this.vbr.setVisibility(0);
      if ((this.jDf == null) || (this.jDf.equals(""))) {
        break label201;
      }
      this.veO.setVisibility(0);
      this.veO.setText(this.jDf);
    }
    for (;;)
    {
      if (this.vbN)
      {
        this.mViewManager.updateViewLayout(this.veM, this.uZr, this.uZs, false);
        if (this.veP) {
          this.mViewManager.showInfoWindowByView(this.veM);
        }
      }
      AppMethodBeat.o(55994);
      return;
      this.vbr.setVisibility(8);
      this.vbq.setVisibility(0);
      this.vbq.setText(paramString);
      break;
      label201:
      this.veO.setText("");
      this.veO.setVisibility(8);
    }
  }
  
  public final class a
    implements TencentMap.InfoWindowAdapter
  {
    private a() {}
    
    public final View getInfoWindow(Marker paramMarker)
    {
      AppMethodBeat.i(55992);
      ad.i("ZItemOverlay", "get info window: %s", new Object[] { Integer.valueOf(l.this.veN.getVisibility()) });
      if ("info_window_tag".equals(paramMarker.getTag()))
      {
        paramMarker = l.this.veN;
        AppMethodBeat.o(55992);
        return paramMarker;
      }
      AppMethodBeat.o(55992);
      return null;
    }
    
    public final void onInfoWindowDettached(Marker paramMarker, View paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.l
 * JD-Core Version:    0.7.0.1
 */