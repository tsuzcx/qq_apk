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
import com.tencent.mm.sdk.platformtools.aq;

public class MyLocationButton
  extends FrameLayout
{
  private Context context;
  public b.a fHp;
  private ImageButton vnN;
  private LinearLayout vnO;
  private com.tencent.mm.plugin.k.d vnP;
  private boolean vnQ;
  
  public MyLocationButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55828);
    this.vnQ = true;
    this.fHp = new b.a()
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
        new aq(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(55825);
            com.tencent.mm.modelgeo.d.aIh().c(MyLocationButton.e(MyLocationButton.this));
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
    this.vnQ = true;
    this.fHp = new b.a()
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
        new aq(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(55825);
            com.tencent.mm.modelgeo.d.aIh().c(MyLocationButton.e(MyLocationButton.this));
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
    View localView = View.inflate(this.context, 2131494990, this);
    this.vnN = ((ImageButton)localView.findViewById(2131301519));
    this.vnO = ((LinearLayout)localView.findViewById(2131303518));
    AppMethodBeat.o(55829);
  }
  
  public final void dju()
  {
    AppMethodBeat.i(55830);
    this.vnN.setImageResource(2131233629);
    AppMethodBeat.o(55830);
  }
  
  public final void djv()
  {
    AppMethodBeat.i(55831);
    this.vnN.setImageResource(2131233630);
    AppMethodBeat.o(55831);
  }
  
  public ImageButton getMyLocationBtn()
  {
    return this.vnN;
  }
  
  public LinearLayout getProgressBar()
  {
    return this.vnO;
  }
  
  public void setAnimToSelf(boolean paramBoolean)
  {
    this.vnQ = paramBoolean;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(55832);
    this.vnN.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(55832);
  }
  
  public void setProgressBar(com.tencent.mm.plugin.k.d paramd)
  {
    AppMethodBeat.i(55833);
    this.vnP = paramd;
    this.vnO.setVisibility(0);
    this.vnN.setVisibility(8);
    com.tencent.mm.modelgeo.d.aIh().b(this.fHp, true);
    AppMethodBeat.o(55833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.MyLocationButton
 * JD-Core Version:    0.7.0.1
 */