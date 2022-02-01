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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;

public final class l
  implements c
{
  public boolean dsB;
  public boolean isVisible;
  public String jGd;
  private Context mContext;
  public ViewManager mViewManager;
  public double vlC;
  public double vlD;
  private String vly;
  private TextView vnB;
  private ProgressBar vnC;
  private String vnF;
  public boolean vnY;
  private View vnZ;
  public final String vqV;
  public ImageView vqW;
  public FrameLayout vqX;
  private TextView vqY;
  public boolean vqZ;
  
  public l(d paramd, Context paramContext)
  {
    AppMethodBeat.i(55993);
    this.vqV = "info_window_tag";
    this.dsB = false;
    this.vnY = true;
    this.vlC = 1000000.0D;
    this.vlD = 1000000.0D;
    this.isVisible = true;
    this.vnF = "";
    this.mContext = paramContext;
    this.vqZ = false;
    this.vqW = new ImageView(paramContext);
    this.vqW.setBackgroundResource(2131233299);
    this.vqW.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.vqX = ((FrameLayout)View.inflate(paramContext, 2131494732, null));
    this.vqW.setImageResource(2131232887);
    this.vnZ = this.vqX;
    this.mViewManager = ((ViewManager)paramd.getViewManager());
    AppMethodBeat.o(55993);
  }
  
  public final String getPreText()
  {
    return this.vnF;
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(55994);
    this.vly = paramString;
    paramString = this.vly;
    this.vnB = ((TextView)this.vqX.findViewById(2131301545));
    this.vnC = ((ProgressBar)this.vqX.findViewById(2131301532));
    this.vqY = ((TextView)this.vqX.findViewById(2131301537));
    if ((paramString == null) || (paramString.equals("")))
    {
      this.vnC.setVisibility(0);
      if ((this.jGd == null) || (this.jGd.equals(""))) {
        break label201;
      }
      this.vqY.setVisibility(0);
      this.vqY.setText(this.jGd);
    }
    for (;;)
    {
      if (this.vnY)
      {
        this.mViewManager.updateViewLayout(this.vqW, this.vlC, this.vlD, false);
        if (this.vqZ) {
          this.mViewManager.showInfoWindowByView(this.vqW);
        }
      }
      AppMethodBeat.o(55994);
      return;
      this.vnC.setVisibility(8);
      this.vnB.setVisibility(0);
      this.vnB.setText(paramString);
      break;
      label201:
      this.vqY.setText("");
      this.vqY.setVisibility(8);
    }
  }
  
  public final class a
    implements TencentMap.InfoWindowAdapter
  {
    private a() {}
    
    public final View getInfoWindow(Marker paramMarker)
    {
      AppMethodBeat.i(55992);
      ae.i("ZItemOverlay", "get info window: %s", new Object[] { Integer.valueOf(l.this.vqX.getVisibility()) });
      if ("info_window_tag".equals(paramMarker.getTag()))
      {
        paramMarker = l.this.vqX;
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