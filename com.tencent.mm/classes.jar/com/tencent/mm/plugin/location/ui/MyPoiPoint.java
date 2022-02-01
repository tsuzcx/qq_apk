package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.sdk.platformtools.ad;

public class MyPoiPoint
  extends FrameLayout
{
  private final String TAG;
  public b.a fjJ;
  private com.tencent.mm.plugin.k.d sQM;
  public com.tencent.mm.modelgeo.d sQN;
  private boolean sQO;
  Circle sQP;
  
  private MyPoiPoint(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(55836);
    this.TAG = "MicroMsg.MyPoiPoint";
    this.sQO = false;
    this.fjJ = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(55835);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(55835);
          return false;
        }
        ad.d("MicroMsg.MyPoiPoint", "new location comes! lat : %f, lng: %f, accuracy: %f.", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1), Double.valueOf(paramAnonymousDouble2) });
        if (MyPoiPoint.a(MyPoiPoint.this) != null)
        {
          if (MyPoiPoint.this.sQP == null) {
            break label151;
          }
          MyPoiPoint.this.sQP.setCenter(new LatLng(paramAnonymousFloat2, paramAnonymousFloat1));
          MyPoiPoint.this.sQP.setRadius(paramAnonymousDouble2);
          if (MyPoiPoint.b(MyPoiPoint.this)) {
            break label179;
          }
          MyPoiPoint.c(MyPoiPoint.this);
          MyPoiPoint.a(MyPoiPoint.this).addPinView(MyPoiPoint.this, paramAnonymousFloat2, paramAnonymousFloat1);
        }
        for (;;)
        {
          AppMethodBeat.o(55835);
          return true;
          label151:
          MyPoiPoint.this.sQP = MyPoiPoint.a(MyPoiPoint.this).drawAccuracyCircle(paramAnonymousFloat2, paramAnonymousFloat1, paramAnonymousDouble2);
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
    this.sQO = false;
    this.fjJ = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(55835);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(55835);
          return false;
        }
        ad.d("MicroMsg.MyPoiPoint", "new location comes! lat : %f, lng: %f, accuracy: %f.", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1), Double.valueOf(paramAnonymousDouble2) });
        if (MyPoiPoint.a(MyPoiPoint.this) != null)
        {
          if (MyPoiPoint.this.sQP == null) {
            break label151;
          }
          MyPoiPoint.this.sQP.setCenter(new LatLng(paramAnonymousFloat2, paramAnonymousFloat1));
          MyPoiPoint.this.sQP.setRadius(paramAnonymousDouble2);
          if (MyPoiPoint.b(MyPoiPoint.this)) {
            break label179;
          }
          MyPoiPoint.c(MyPoiPoint.this);
          MyPoiPoint.a(MyPoiPoint.this).addPinView(MyPoiPoint.this, paramAnonymousFloat2, paramAnonymousFloat1);
        }
        for (;;)
        {
          AppMethodBeat.o(55835);
          return true;
          label151:
          MyPoiPoint.this.sQP = MyPoiPoint.a(MyPoiPoint.this).drawAccuracyCircle(paramAnonymousFloat2, paramAnonymousFloat1, paramAnonymousDouble2);
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
    this.sQO = false;
    this.fjJ = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(55835);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(55835);
          return false;
        }
        ad.d("MicroMsg.MyPoiPoint", "new location comes! lat : %f, lng: %f, accuracy: %f.", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1), Double.valueOf(paramAnonymousDouble2) });
        if (MyPoiPoint.a(MyPoiPoint.this) != null)
        {
          if (MyPoiPoint.this.sQP == null) {
            break label151;
          }
          MyPoiPoint.this.sQP.setCenter(new LatLng(paramAnonymousFloat2, paramAnonymousFloat1));
          MyPoiPoint.this.sQP.setRadius(paramAnonymousDouble2);
          if (MyPoiPoint.b(MyPoiPoint.this)) {
            break label179;
          }
          MyPoiPoint.c(MyPoiPoint.this);
          MyPoiPoint.a(MyPoiPoint.this).addPinView(MyPoiPoint.this, paramAnonymousFloat2, paramAnonymousFloat1);
        }
        for (;;)
        {
          AppMethodBeat.o(55835);
          return true;
          label151:
          MyPoiPoint.this.sQP = MyPoiPoint.a(MyPoiPoint.this).drawAccuracyCircle(paramAnonymousFloat2, paramAnonymousFloat1, paramAnonymousDouble2);
          break;
          label179:
          MyPoiPoint.a(MyPoiPoint.this).updateLocaitonPinLayout(MyPoiPoint.this, paramAnonymousFloat2, paramAnonymousFloat1);
        }
      }
    };
    init(paramContext);
    AppMethodBeat.o(55838);
  }
  
  public MyPoiPoint(Context paramContext, com.tencent.mm.plugin.k.d paramd)
  {
    this(paramContext);
    this.sQM = paramd;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(55839);
    LayoutInflater.from(paramContext).inflate(2131495100, this, true);
    this.sQN = com.tencent.mm.modelgeo.d.axT();
    cJG();
    AppMethodBeat.o(55839);
  }
  
  public final void cJG()
  {
    AppMethodBeat.i(55840);
    ad.d("MicroMsg.MyPoiPoint", "enableLocation");
    this.sQN.b(this.fjJ, true);
    AppMethodBeat.o(55840);
  }
  
  public void setIMapView(com.tencent.mm.plugin.k.d paramd)
  {
    this.sQM = paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.MyPoiPoint
 * JD-Core Version:    0.7.0.1
 */