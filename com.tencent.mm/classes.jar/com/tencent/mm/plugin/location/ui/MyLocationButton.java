package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.map.a.d;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.plugin.p.b;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class MyLocationButton
  extends FrameLayout
{
  private ImageButton Keg;
  private LinearLayout Keh;
  private com.tencent.mm.plugin.p.d Kei;
  private boolean Kej;
  private Context context;
  public b.a lsF;
  
  public MyLocationButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55828);
    this.Kej = true;
    this.lsF = new b.a()
    {
      public final boolean onGetLocation(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
      {
        AppMethodBeat.i(264949);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(264949);
          return false;
        }
        MyLocationButton.a(MyLocationButton.this).setVisibility(8);
        MyLocationButton.b(MyLocationButton.this).setVisibility(0);
        if ((MyLocationButton.c(MyLocationButton.this) != null) && (MyLocationButton.d(MyLocationButton.this)))
        {
          MyLocationButton.c(MyLocationButton.this).getIController().setCenter(paramAnonymousFloat2, paramAnonymousFloat1);
          if (MyLocationButton.c(MyLocationButton.this).getZoomLevel() < 15) {
            MyLocationButton.c(MyLocationButton.this).getIController().setZoom(15);
          }
        }
        new MMHandler(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(55825);
            com.tencent.mm.modelgeo.d.bJl().a(MyLocationButton.e(MyLocationButton.this));
            AppMethodBeat.o(55825);
          }
        });
        AppMethodBeat.o(264949);
        return false;
      }
    };
    this.context = paramContext;
    init();
    AppMethodBeat.o(55828);
  }
  
  public MyLocationButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(55827);
    this.Kej = true;
    this.lsF = new b.a()
    {
      public final boolean onGetLocation(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
      {
        AppMethodBeat.i(264949);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(264949);
          return false;
        }
        MyLocationButton.a(MyLocationButton.this).setVisibility(8);
        MyLocationButton.b(MyLocationButton.this).setVisibility(0);
        if ((MyLocationButton.c(MyLocationButton.this) != null) && (MyLocationButton.d(MyLocationButton.this)))
        {
          MyLocationButton.c(MyLocationButton.this).getIController().setCenter(paramAnonymousFloat2, paramAnonymousFloat1);
          if (MyLocationButton.c(MyLocationButton.this).getZoomLevel() < 15) {
            MyLocationButton.c(MyLocationButton.this).getIController().setZoom(15);
          }
        }
        new MMHandler(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(55825);
            com.tencent.mm.modelgeo.d.bJl().a(MyLocationButton.e(MyLocationButton.this));
            AppMethodBeat.o(55825);
          }
        });
        AppMethodBeat.o(264949);
        return false;
      }
    };
    this.context = paramContext;
    init();
    AppMethodBeat.o(55827);
  }
  
  private void init()
  {
    AppMethodBeat.i(55829);
    View localView = View.inflate(this.context, a.f.my_location_btn, this);
    this.Keg = ((ImageButton)localView.findViewById(a.e.locate_btn));
    this.Keh = ((LinearLayout)localView.findViewById(a.e.progress_bar));
    AppMethodBeat.o(55829);
  }
  
  public final void fUR()
  {
    AppMethodBeat.i(55830);
    this.Keg.setImageResource(a.d.poi_mylocation_btn_icon_disable);
    AppMethodBeat.o(55830);
  }
  
  public final void fUS()
  {
    AppMethodBeat.i(55831);
    this.Keg.setImageResource(a.d.poi_mylocation_btn_icon_normal);
    AppMethodBeat.o(55831);
  }
  
  public ImageButton getMyLocationBtn()
  {
    return this.Keg;
  }
  
  public LinearLayout getProgressBar()
  {
    return this.Keh;
  }
  
  public void setAnimToSelf(boolean paramBoolean)
  {
    this.Kej = paramBoolean;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(55832);
    this.Keg.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(55832);
  }
  
  public void setProgressBar(com.tencent.mm.plugin.p.d paramd)
  {
    AppMethodBeat.i(55833);
    this.Kei = paramd;
    this.Keh.setVisibility(0);
    this.Keg.setVisibility(8);
    com.tencent.mm.modelgeo.d.bJl().a(this.lsF, true);
    AppMethodBeat.o(55833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.MyLocationButton
 * JD-Core Version:    0.7.0.1
 */