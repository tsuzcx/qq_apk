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
  public boolean diE;
  public String goQ;
  public boolean isVisible;
  private Context mContext;
  public ViewManager mViewManager;
  private String sOr;
  public double sOv;
  public double sOw;
  public boolean sQR;
  private View sQS;
  private TextView sQu;
  private ProgressBar sQv;
  private String sQy;
  public final String sTP;
  public ImageView sTQ;
  public FrameLayout sTR;
  private TextView sTS;
  public boolean sTT;
  
  public l(d paramd, Context paramContext)
  {
    AppMethodBeat.i(55993);
    this.sTP = "info_window_tag";
    this.diE = false;
    this.sQR = true;
    this.sOv = 1000000.0D;
    this.sOw = 1000000.0D;
    this.isVisible = true;
    this.sQy = "";
    this.mContext = paramContext;
    this.sTT = false;
    this.sTQ = new ImageView(paramContext);
    this.sTQ.setBackgroundResource(2131233299);
    this.sTQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.sTR = ((FrameLayout)View.inflate(paramContext, 2131494732, null));
    this.sTQ.setImageResource(2131232887);
    this.sQS = this.sTR;
    this.mViewManager = ((ViewManager)paramd.getViewManager());
    AppMethodBeat.o(55993);
  }
  
  public final String getPreText()
  {
    return this.sQy;
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(55994);
    this.sOr = paramString;
    paramString = this.sOr;
    this.sQu = ((TextView)this.sTR.findViewById(2131301545));
    this.sQv = ((ProgressBar)this.sTR.findViewById(2131301532));
    this.sTS = ((TextView)this.sTR.findViewById(2131301537));
    if ((paramString == null) || (paramString.equals("")))
    {
      this.sQv.setVisibility(0);
      if ((this.goQ == null) || (this.goQ.equals(""))) {
        break label201;
      }
      this.sTS.setVisibility(0);
      this.sTS.setText(this.goQ);
    }
    for (;;)
    {
      if (this.sQR)
      {
        this.mViewManager.updateViewLayout(this.sTQ, this.sOv, this.sOw, false);
        if (this.sTT) {
          this.mViewManager.showInfoWindowByView(this.sTQ);
        }
      }
      AppMethodBeat.o(55994);
      return;
      this.sQv.setVisibility(8);
      this.sQu.setVisibility(0);
      this.sQu.setText(paramString);
      break;
      label201:
      this.sTS.setText("");
      this.sTS.setVisibility(8);
    }
  }
  
  public final class a
    implements TencentMap.InfoWindowAdapter
  {
    private a() {}
    
    public final View getInfoWindow(Marker paramMarker)
    {
      AppMethodBeat.i(55992);
      ad.i("ZItemOverlay", "get info window: %s", new Object[] { Integer.valueOf(l.this.sTR.getVisibility()) });
      if ("info_window_tag".equals(paramMarker.getTag()))
      {
        paramMarker = l.this.sTR;
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