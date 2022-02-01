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
import com.tencent.mm.ce.b;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.plugin.map.a.d;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;

public final class l
  implements c
{
  private String KbS;
  public double KbW;
  public double KbX;
  private TextView KdU;
  private ProgressBar KdV;
  private String KdY;
  public boolean Ker;
  private View Kes;
  public final String Khk;
  public ImageView Khl;
  public FrameLayout Khm;
  private TextView Khn;
  public boolean Kho;
  public boolean hHq;
  public boolean isVisible;
  private Context mContext;
  public ViewManager mViewManager;
  public String poiName;
  
  public l(d paramd, Context paramContext)
  {
    AppMethodBeat.i(55993);
    this.Khk = "info_window_tag";
    this.hHq = false;
    this.Ker = true;
    this.KbW = 1000000.0D;
    this.KbX = 1000000.0D;
    this.isVisible = true;
    this.KdY = "";
    this.mContext = paramContext;
    this.Kho = false;
    this.Khl = new ImageView(paramContext);
    this.Khl.setBackgroundResource(a.d.mm_trans);
    this.Khl.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.Khm = ((FrameLayout)View.inflate(paramContext, a.f.map_overlay_layout, null));
    paramContext = this.Khl;
    if (b.iRp()) {}
    for (int i = a.d.location_current_marker_easy_mode;; i = a.d.location_current_marker)
    {
      paramContext.setImageResource(i);
      this.Kes = this.Khm;
      this.mViewManager = ((ViewManager)paramd.getViewManager());
      AppMethodBeat.o(55993);
      return;
    }
  }
  
  public final String getPreText()
  {
    return this.KdY;
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(55994);
    this.KbS = paramString;
    paramString = this.KbS;
    this.KdU = ((TextView)this.Khm.findViewById(a.e.location_tips));
    this.KdV = ((ProgressBar)this.Khm.findViewById(a.e.location_load_progress));
    this.Khn = ((TextView)this.Khm.findViewById(a.e.location_poiname));
    if ((paramString == null) || (paramString.equals("")))
    {
      this.KdV.setVisibility(0);
      if ((this.poiName == null) || (this.poiName.equals(""))) {
        break label204;
      }
      this.Khn.setVisibility(0);
      this.Khn.setText(this.poiName);
    }
    for (;;)
    {
      if (this.Ker)
      {
        this.mViewManager.updateViewLayout(this.Khl, this.KbW, this.KbX, false);
        if (this.Kho) {
          this.mViewManager.showInfoWindowByView(this.Khl);
        }
      }
      AppMethodBeat.o(55994);
      return;
      this.KdV.setVisibility(8);
      this.KdU.setVisibility(0);
      this.KdU.setText(paramString);
      break;
      label204:
      this.Khn.setText("");
      this.Khn.setVisibility(8);
    }
  }
  
  public final class a
    implements TencentMap.InfoWindowAdapter
  {
    private a() {}
    
    public final View getInfoWindow(Marker paramMarker)
    {
      AppMethodBeat.i(55992);
      Log.i("ZItemOverlay", "get info window: %s", new Object[] { Integer.valueOf(l.this.Khm.getVisibility()) });
      if ("info_window_tag".equals(paramMarker.getTag()))
      {
        paramMarker = l.this.Khm;
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