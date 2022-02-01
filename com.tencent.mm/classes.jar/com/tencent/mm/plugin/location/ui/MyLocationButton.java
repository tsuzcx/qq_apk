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
import com.tencent.mm.plugin.k.b;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class MyLocationButton
  extends FrameLayout
{
  private Context context;
  public b.a gmA;
  private ImageButton yHE;
  private LinearLayout yHF;
  private com.tencent.mm.plugin.k.d yHG;
  private boolean yHH;
  
  public MyLocationButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55828);
    this.yHH = true;
    this.gmA = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(55826);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(55826);
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
            com.tencent.mm.modelgeo.d.bca().c(MyLocationButton.e(MyLocationButton.this));
            AppMethodBeat.o(55825);
          }
        });
        AppMethodBeat.o(55826);
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
    this.yHH = true;
    this.gmA = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(55826);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(55826);
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
            com.tencent.mm.modelgeo.d.bca().c(MyLocationButton.e(MyLocationButton.this));
            AppMethodBeat.o(55825);
          }
        });
        AppMethodBeat.o(55826);
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
    View localView = View.inflate(this.context, 2131495804, this);
    this.yHE = ((ImageButton)localView.findViewById(2131303725));
    this.yHF = ((LinearLayout)localView.findViewById(2131306284));
    AppMethodBeat.o(55829);
  }
  
  public final void edf()
  {
    AppMethodBeat.i(55830);
    this.yHE.setImageResource(2131234438);
    AppMethodBeat.o(55830);
  }
  
  public final void edg()
  {
    AppMethodBeat.i(55831);
    this.yHE.setImageResource(2131234439);
    AppMethodBeat.o(55831);
  }
  
  public ImageButton getMyLocationBtn()
  {
    return this.yHE;
  }
  
  public LinearLayout getProgressBar()
  {
    return this.yHF;
  }
  
  public void setAnimToSelf(boolean paramBoolean)
  {
    this.yHH = paramBoolean;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(55832);
    this.yHE.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(55832);
  }
  
  public void setProgressBar(com.tencent.mm.plugin.k.d paramd)
  {
    AppMethodBeat.i(55833);
    this.yHG = paramd;
    this.yHF.setVisibility(0);
    this.yHE.setVisibility(8);
    com.tencent.mm.modelgeo.d.bca().b(this.gmA, true);
    AppMethodBeat.o(55833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.MyLocationButton
 * JD-Core Version:    0.7.0.1
 */