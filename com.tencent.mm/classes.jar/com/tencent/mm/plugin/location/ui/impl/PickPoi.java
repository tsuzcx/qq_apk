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
import com.tencent.mm.sdk.platformtools.ac;

public class PickPoi
  extends FrameLayout
{
  private Animation DM;
  private Context context;
  protected c ucr;
  public c.a ucy;
  private View udX;
  private f udY;
  boolean udZ;
  private e uea;
  c.b ueb;
  
  public PickPoi(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(56082);
    this.udY = new f();
    this.udZ = true;
    this.uea = null;
    this.ucy = new c.a()
    {
      public final void b(Addr paramAnonymousAddr)
      {
        AppMethodBeat.i(56081);
        ac.d("MicroMsg.PickPoi", "onLocationAddr %s", new Object[] { paramAnonymousAddr.toString() });
        if (PickPoi.b(PickPoi.this) == null)
        {
          ac.i("MicroMsg.PickPoi", "error, empty poi!");
          AppMethodBeat.o(56081);
          return;
        }
        if ((PickPoi.b(PickPoi.this).c(paramAnonymousAddr)) && (PickPoi.c(PickPoi.this) != null))
        {
          if (PickPoi.this.ueb != null) {
            PickPoi.this.ueb.a(PickPoi.b(PickPoi.this));
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
    this.udY = new f();
    this.udZ = true;
    this.uea = null;
    this.ucy = new c.a()
    {
      public final void b(Addr paramAnonymousAddr)
      {
        AppMethodBeat.i(56081);
        ac.d("MicroMsg.PickPoi", "onLocationAddr %s", new Object[] { paramAnonymousAddr.toString() });
        if (PickPoi.b(PickPoi.this) == null)
        {
          ac.i("MicroMsg.PickPoi", "error, empty poi!");
          AppMethodBeat.o(56081);
          return;
        }
        if ((PickPoi.b(PickPoi.this).c(paramAnonymousAddr)) && (PickPoi.c(PickPoi.this) != null))
        {
          if (PickPoi.this.ueb != null) {
            PickPoi.this.ueb.a(PickPoi.b(PickPoi.this));
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
    this.udY = new f();
    this.udZ = true;
    this.uea = null;
    this.ucy = new c.a()
    {
      public final void b(Addr paramAnonymousAddr)
      {
        AppMethodBeat.i(56081);
        ac.d("MicroMsg.PickPoi", "onLocationAddr %s", new Object[] { paramAnonymousAddr.toString() });
        if (PickPoi.b(PickPoi.this) == null)
        {
          ac.i("MicroMsg.PickPoi", "error, empty poi!");
          AppMethodBeat.o(56081);
          return;
        }
        if ((PickPoi.b(PickPoi.this).c(paramAnonymousAddr)) && (PickPoi.c(PickPoi.this) != null))
        {
          if (PickPoi.this.ueb != null) {
            PickPoi.this.ueb.a(PickPoi.b(PickPoi.this));
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
    this.ucr = c.aEI();
    this.DM = AnimationUtils.loadAnimation(paramContext, 2130772163);
    View localView = LayoutInflater.from(paramContext).inflate(2131494598, this, true);
    this.udX = localView.findViewById(2131301523);
    post(new PickPoi.1(this, localView, paramContext));
    AppMethodBeat.o(56085);
  }
  
  public f getPoi()
  {
    return this.udY;
  }
  
  public final void l(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(56086);
    this.udY = new f();
    this.udY.type = 3;
    this.udY.mName = this.context.getResources().getString(2131760711);
    this.udY.bNq = paramDouble1;
    this.udY.bNr = paramDouble2;
    this.udY.uek = "";
    this.ucr.a(this.ucy);
    this.ucr.a(paramDouble1, paramDouble2, this.ucy);
    this.udZ = true;
    AppMethodBeat.o(56086);
  }
  
  public final void play()
  {
    AppMethodBeat.i(182075);
    this.udX.clearAnimation();
    this.udX.startAnimation(this.DM);
    AppMethodBeat.o(182075);
  }
  
  public void setAdapter(e parame)
  {
    this.uea = parame;
  }
  
  public void setLocationArrow(int paramInt)
  {
    AppMethodBeat.i(56087);
    ((ImageView)this.udX).setImageResource(paramInt);
    AppMethodBeat.o(56087);
  }
  
  public void setOnCurPoiGet(c.b paramb)
  {
    this.ueb = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.PickPoi
 * JD-Core Version:    0.7.0.1
 */