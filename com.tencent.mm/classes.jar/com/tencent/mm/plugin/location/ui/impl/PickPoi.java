package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.sdk.platformtools.ad;

public class PickPoi
  extends FrameLayout
{
  private Animation FD;
  private Context context;
  protected c vfb;
  public c.a vfi;
  private View vgH;
  private f vgI;
  boolean vgJ;
  private e vgK;
  c.b vgL;
  
  public PickPoi(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(56082);
    this.vgI = new f();
    this.vgJ = true;
    this.vgK = null;
    this.vfi = new c.a()
    {
      public final void b(Addr paramAnonymousAddr)
      {
        AppMethodBeat.i(56081);
        ad.d("MicroMsg.PickPoi", "onLocationAddr %s", new Object[] { paramAnonymousAddr.toString() });
        if (PickPoi.b(PickPoi.this) == null)
        {
          ad.i("MicroMsg.PickPoi", "error, empty poi!");
          AppMethodBeat.o(56081);
          return;
        }
        if ((PickPoi.b(PickPoi.this).c(paramAnonymousAddr)) && (PickPoi.c(PickPoi.this) != null))
        {
          if (PickPoi.this.vgL != null) {
            PickPoi.this.vgL.a(PickPoi.b(PickPoi.this));
          }
          PickPoi.c(PickPoi.this).notifyDataSetChanged();
        }
        AppMethodBeat.o(56081);
      }
    };
    init(paramContext);
    AppMethodBeat.o(56082);
  }
  
  public PickPoi(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(56083);
    this.vgI = new f();
    this.vgJ = true;
    this.vgK = null;
    this.vfi = new c.a()
    {
      public final void b(Addr paramAnonymousAddr)
      {
        AppMethodBeat.i(56081);
        ad.d("MicroMsg.PickPoi", "onLocationAddr %s", new Object[] { paramAnonymousAddr.toString() });
        if (PickPoi.b(PickPoi.this) == null)
        {
          ad.i("MicroMsg.PickPoi", "error, empty poi!");
          AppMethodBeat.o(56081);
          return;
        }
        if ((PickPoi.b(PickPoi.this).c(paramAnonymousAddr)) && (PickPoi.c(PickPoi.this) != null))
        {
          if (PickPoi.this.vgL != null) {
            PickPoi.this.vgL.a(PickPoi.b(PickPoi.this));
          }
          PickPoi.c(PickPoi.this).notifyDataSetChanged();
        }
        AppMethodBeat.o(56081);
      }
    };
    init(paramContext);
    AppMethodBeat.o(56083);
  }
  
  public PickPoi(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(56084);
    this.vgI = new f();
    this.vgJ = true;
    this.vgK = null;
    this.vfi = new c.a()
    {
      public final void b(Addr paramAnonymousAddr)
      {
        AppMethodBeat.i(56081);
        ad.d("MicroMsg.PickPoi", "onLocationAddr %s", new Object[] { paramAnonymousAddr.toString() });
        if (PickPoi.b(PickPoi.this) == null)
        {
          ad.i("MicroMsg.PickPoi", "error, empty poi!");
          AppMethodBeat.o(56081);
          return;
        }
        if ((PickPoi.b(PickPoi.this).c(paramAnonymousAddr)) && (PickPoi.c(PickPoi.this) != null))
        {
          if (PickPoi.this.vgL != null) {
            PickPoi.this.vgL.a(PickPoi.b(PickPoi.this));
          }
          PickPoi.c(PickPoi.this).notifyDataSetChanged();
        }
        AppMethodBeat.o(56081);
      }
    };
    init(paramContext);
    AppMethodBeat.o(56084);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(56085);
    this.context = paramContext;
    this.vfb = c.aHN();
    this.FD = AnimationUtils.loadAnimation(paramContext, 2130772163);
    View localView = LayoutInflater.from(paramContext).inflate(2131494598, this, true);
    this.vgH = localView.findViewById(2131301523);
    post(new PickPoi.1(this, localView, paramContext));
    AppMethodBeat.o(56085);
  }
  
  public f getPoi()
  {
    return this.vgI;
  }
  
  public final void l(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(56086);
    this.vgI = new f();
    this.vgI.type = 3;
    this.vgI.mName = this.context.getResources().getString(2131760711);
    this.vgI.bXD = paramDouble1;
    this.vgI.bXE = paramDouble2;
    this.vgI.vgT = "";
    this.vfb.a(this.vfi);
    this.vfb.a(paramDouble1, paramDouble2, this.vfi);
    this.vgJ = true;
    AppMethodBeat.o(56086);
  }
  
  public final void play()
  {
    AppMethodBeat.i(182075);
    this.vgH.clearAnimation();
    this.vgH.startAnimation(this.FD);
    AppMethodBeat.o(182075);
  }
  
  public void setAdapter(e parame)
  {
    this.vgK = parame;
  }
  
  public void setLocationArrow(int paramInt)
  {
    AppMethodBeat.i(56087);
    ((ImageView)this.vgH).setImageResource(paramInt);
    AppMethodBeat.o(56087);
  }
  
  public void setOnCurPoiGet(c.b paramb)
  {
    this.vgL = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.PickPoi
 * JD-Core Version:    0.7.0.1
 */