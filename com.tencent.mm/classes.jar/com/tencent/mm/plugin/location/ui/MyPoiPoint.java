package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.sdk.platformtools.Log;

public class MyPoiPoint
  extends FrameLayout
{
  private com.tencent.mm.plugin.p.d Kem;
  public com.tencent.mm.modelgeo.d Ken;
  private boolean Keo;
  Circle Kep;
  private final String TAG;
  public b.a lsF;
  
  private MyPoiPoint(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(55836);
    this.TAG = "MicroMsg.MyPoiPoint";
    this.Keo = false;
    this.lsF = new b.a()
    {
      public final boolean onGetLocation(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
      {
        AppMethodBeat.i(264963);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(264963);
          return false;
        }
        Log.d("MicroMsg.MyPoiPoint", "new location comes! lat : %f, lng: %f, accuracy: %f.", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1), Double.valueOf(paramAnonymousDouble2) });
        if (MyPoiPoint.a(MyPoiPoint.this) != null)
        {
          if (MyPoiPoint.this.Kep == null) {
            break label151;
          }
          MyPoiPoint.this.Kep.setCenter(new LatLng(paramAnonymousFloat2, paramAnonymousFloat1));
          MyPoiPoint.this.Kep.setRadius(paramAnonymousDouble2);
          if (MyPoiPoint.b(MyPoiPoint.this)) {
            break label179;
          }
          MyPoiPoint.c(MyPoiPoint.this);
          MyPoiPoint.a(MyPoiPoint.this).addPinView(MyPoiPoint.this, paramAnonymousFloat2, paramAnonymousFloat1);
        }
        for (;;)
        {
          AppMethodBeat.o(264963);
          return true;
          label151:
          MyPoiPoint.this.Kep = MyPoiPoint.a(MyPoiPoint.this).drawAccuracyCircle(paramAnonymousFloat2, paramAnonymousFloat1, paramAnonymousDouble2);
          break;
          label179:
          MyPoiPoint.a(MyPoiPoint.this).updateLocaitonPinLayout(MyPoiPoint.this, paramAnonymousFloat2, paramAnonymousFloat1);
        }
      }
    };
    init(paramContext);
    AppMethodBeat.o(55836);
  }
  
  public MyPoiPoint(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55837);
    this.TAG = "MicroMsg.MyPoiPoint";
    this.Keo = false;
    this.lsF = new b.a()
    {
      public final boolean onGetLocation(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
      {
        AppMethodBeat.i(264963);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(264963);
          return false;
        }
        Log.d("MicroMsg.MyPoiPoint", "new location comes! lat : %f, lng: %f, accuracy: %f.", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1), Double.valueOf(paramAnonymousDouble2) });
        if (MyPoiPoint.a(MyPoiPoint.this) != null)
        {
          if (MyPoiPoint.this.Kep == null) {
            break label151;
          }
          MyPoiPoint.this.Kep.setCenter(new LatLng(paramAnonymousFloat2, paramAnonymousFloat1));
          MyPoiPoint.this.Kep.setRadius(paramAnonymousDouble2);
          if (MyPoiPoint.b(MyPoiPoint.this)) {
            break label179;
          }
          MyPoiPoint.c(MyPoiPoint.this);
          MyPoiPoint.a(MyPoiPoint.this).addPinView(MyPoiPoint.this, paramAnonymousFloat2, paramAnonymousFloat1);
        }
        for (;;)
        {
          AppMethodBeat.o(264963);
          return true;
          label151:
          MyPoiPoint.this.Kep = MyPoiPoint.a(MyPoiPoint.this).drawAccuracyCircle(paramAnonymousFloat2, paramAnonymousFloat1, paramAnonymousDouble2);
          break;
          label179:
          MyPoiPoint.a(MyPoiPoint.this).updateLocaitonPinLayout(MyPoiPoint.this, paramAnonymousFloat2, paramAnonymousFloat1);
        }
      }
    };
    init(paramContext);
    AppMethodBeat.o(55837);
  }
  
  public MyPoiPoint(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(55838);
    this.TAG = "MicroMsg.MyPoiPoint";
    this.Keo = false;
    this.lsF = new b.a()
    {
      public final boolean onGetLocation(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
      {
        AppMethodBeat.i(264963);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(264963);
          return false;
        }
        Log.d("MicroMsg.MyPoiPoint", "new location comes! lat : %f, lng: %f, accuracy: %f.", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1), Double.valueOf(paramAnonymousDouble2) });
        if (MyPoiPoint.a(MyPoiPoint.this) != null)
        {
          if (MyPoiPoint.this.Kep == null) {
            break label151;
          }
          MyPoiPoint.this.Kep.setCenter(new LatLng(paramAnonymousFloat2, paramAnonymousFloat1));
          MyPoiPoint.this.Kep.setRadius(paramAnonymousDouble2);
          if (MyPoiPoint.b(MyPoiPoint.this)) {
            break label179;
          }
          MyPoiPoint.c(MyPoiPoint.this);
          MyPoiPoint.a(MyPoiPoint.this).addPinView(MyPoiPoint.this, paramAnonymousFloat2, paramAnonymousFloat1);
        }
        for (;;)
        {
          AppMethodBeat.o(264963);
          return true;
          label151:
          MyPoiPoint.this.Kep = MyPoiPoint.a(MyPoiPoint.this).drawAccuracyCircle(paramAnonymousFloat2, paramAnonymousFloat1, paramAnonymousDouble2);
          break;
          label179:
          MyPoiPoint.a(MyPoiPoint.this).updateLocaitonPinLayout(MyPoiPoint.this, paramAnonymousFloat2, paramAnonymousFloat1);
        }
      }
    };
    init(paramContext);
    AppMethodBeat.o(55838);
  }
  
  public MyPoiPoint(Context paramContext, com.tencent.mm.plugin.p.d paramd)
  {
    this(paramContext);
    this.Kem = paramd;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(55839);
    LayoutInflater.from(paramContext).inflate(a.f.poi_my_point, this, true);
    this.Ken = com.tencent.mm.modelgeo.d.bJl();
    fUT();
    AppMethodBeat.o(55839);
  }
  
  public final void fUT()
  {
    AppMethodBeat.i(55840);
    Log.d("MicroMsg.MyPoiPoint", "enableLocation");
    this.Ken.a(this.lsF, true);
    AppMethodBeat.o(55840);
  }
  
  public void setIMapView(com.tencent.mm.plugin.p.d paramd)
  {
    this.Kem = paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.MyPoiPoint
 * JD-Core Version:    0.7.0.1
 */