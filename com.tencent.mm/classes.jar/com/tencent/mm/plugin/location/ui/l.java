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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;

public final class l
  implements c
{
  public boolean dJM;
  public boolean isVisible;
  public String kHV;
  private Context mContext;
  public ViewManager mViewManager;
  private String yFq;
  public double yFu;
  public double yFv;
  public boolean yHP;
  private View yHQ;
  private TextView yHs;
  private ProgressBar yHt;
  private String yHw;
  public final String yKL;
  public ImageView yKM;
  public FrameLayout yKN;
  private TextView yKO;
  public boolean yKP;
  
  public l(d paramd, Context paramContext)
  {
    AppMethodBeat.i(55993);
    this.yKL = "info_window_tag";
    this.dJM = false;
    this.yHP = true;
    this.yFu = 1000000.0D;
    this.yFv = 1000000.0D;
    this.isVisible = true;
    this.yHw = "";
    this.mContext = paramContext;
    this.yKP = false;
    this.yKM = new ImageView(paramContext);
    this.yKM.setBackgroundResource(2131233974);
    this.yKM.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.yKN = ((FrameLayout)View.inflate(paramContext, 2131495461, null));
    this.yKM.setImageResource(2131233529);
    this.yHQ = this.yKN;
    this.mViewManager = ((ViewManager)paramd.getViewManager());
    AppMethodBeat.o(55993);
  }
  
  public final String getPreText()
  {
    return this.yHw;
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(55994);
    this.yFq = paramString;
    paramString = this.yFq;
    this.yHs = ((TextView)this.yKN.findViewById(2131303755));
    this.yHt = ((ProgressBar)this.yKN.findViewById(2131303738));
    this.yKO = ((TextView)this.yKN.findViewById(2131303747));
    if ((paramString == null) || (paramString.equals("")))
    {
      this.yHt.setVisibility(0);
      if ((this.kHV == null) || (this.kHV.equals(""))) {
        break label201;
      }
      this.yKO.setVisibility(0);
      this.yKO.setText(this.kHV);
    }
    for (;;)
    {
      if (this.yHP)
      {
        this.mViewManager.updateViewLayout(this.yKM, this.yFu, this.yFv, false);
        if (this.yKP) {
          this.mViewManager.showInfoWindowByView(this.yKM);
        }
      }
      AppMethodBeat.o(55994);
      return;
      this.yHt.setVisibility(8);
      this.yHs.setVisibility(0);
      this.yHs.setText(paramString);
      break;
      label201:
      this.yKO.setText("");
      this.yKO.setVisibility(8);
    }
  }
  
  public final class a
    implements TencentMap.InfoWindowAdapter
  {
    private a() {}
    
    public final View getInfoWindow(Marker paramMarker)
    {
      AppMethodBeat.i(55992);
      Log.i("ZItemOverlay", "get info window: %s", new Object[] { Integer.valueOf(l.this.yKN.getVisibility()) });
      if ("info_window_tag".equals(paramMarker.getTag()))
      {
        paramMarker = l.this.yKN;
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