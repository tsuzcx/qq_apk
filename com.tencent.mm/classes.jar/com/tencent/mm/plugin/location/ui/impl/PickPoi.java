package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelgeo.c.a;

public class PickPoi
  extends RelativeLayout
{
  private Context context;
  View obW;
  protected c ofr;
  public c.a ofy;
  private double ogH;
  private double ogI;
  private f ogJ;
  boolean ogK;
  private e ogL;
  Animation wq;
  
  public PickPoi(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(113649);
    this.ogJ = new f();
    this.ogK = true;
    this.ogL = null;
    this.ofy = new PickPoi.1(this);
    this.context = paramContext;
    init();
    AppMethodBeat.o(113649);
  }
  
  public PickPoi(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(113650);
    this.ogJ = new f();
    this.ogK = true;
    this.ogL = null;
    this.ofy = new PickPoi.1(this);
    this.context = paramContext;
    init();
    AppMethodBeat.o(113650);
  }
  
  public PickPoi(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(113651);
    this.ogJ = new f();
    this.ogK = true;
    this.ogL = null;
    this.ofy = new PickPoi.1(this);
    this.context = paramContext;
    init();
    AppMethodBeat.o(113651);
  }
  
  private void init()
  {
    AppMethodBeat.i(113652);
    this.ofr = c.agN();
    this.wq = AnimationUtils.loadAnimation(this.context, 2131034284);
    this.obW = LayoutInflater.from(this.context).inflate(2130969993, this, true).findViewById(2131825436);
    AppMethodBeat.o(113652);
  }
  
  public f getPoi()
  {
    return this.ogJ;
  }
  
  public final void l(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(113653);
    this.ogH = paramDouble1;
    this.ogI = paramDouble2;
    this.ogJ = new f();
    this.ogJ.type = 3;
    this.ogJ.mName = this.context.getResources().getString(2131301105);
    this.ogJ.bnl = paramDouble1;
    this.ogJ.bnm = paramDouble2;
    this.ogJ.ogS = "";
    this.ofr.a(this.ofy);
    this.ofr.a(paramDouble1, paramDouble2, this.ofy);
    this.ogK = true;
    AppMethodBeat.o(113653);
  }
  
  public final void m(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(113654);
    l(paramDouble1, paramDouble2);
    this.ogK = false;
    AppMethodBeat.o(113654);
  }
  
  public void setAdapter(e parame)
  {
    this.ogL = parame;
  }
  
  public void setLocationArrow(int paramInt)
  {
    AppMethodBeat.i(113655);
    ((ImageView)this.obW).setImageResource(paramInt);
    AppMethodBeat.o(113655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.PickPoi
 * JD-Core Version:    0.7.0.1
 */