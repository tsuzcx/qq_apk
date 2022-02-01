package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;

public class PickPoi
  extends FrameLayout
{
  private Animation FN;
  private Context context;
  protected c yKY;
  public c.a yLe;
  private View yMB;
  private f yMC;
  boolean yMD;
  private e yME;
  c.b yMF;
  
  public PickPoi(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(56082);
    this.yMC = new f();
    this.yMD = true;
    this.yME = null;
    this.yLe = new c.a()
    {
      public final void b(Addr paramAnonymousAddr)
      {
        AppMethodBeat.i(56081);
        Log.d("MicroMsg.PickPoi", "onLocationAddr %s", new Object[] { paramAnonymousAddr.toString() });
        if (PickPoi.b(PickPoi.this) == null)
        {
          Log.i("MicroMsg.PickPoi", "error, empty poi!");
          AppMethodBeat.o(56081);
          return;
        }
        if ((PickPoi.b(PickPoi.this).c(paramAnonymousAddr)) && (PickPoi.c(PickPoi.this) != null))
        {
          if (PickPoi.this.yMF != null) {
            PickPoi.this.yMF.a(PickPoi.b(PickPoi.this));
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
    this.yMC = new f();
    this.yMD = true;
    this.yME = null;
    this.yLe = new c.a()
    {
      public final void b(Addr paramAnonymousAddr)
      {
        AppMethodBeat.i(56081);
        Log.d("MicroMsg.PickPoi", "onLocationAddr %s", new Object[] { paramAnonymousAddr.toString() });
        if (PickPoi.b(PickPoi.this) == null)
        {
          Log.i("MicroMsg.PickPoi", "error, empty poi!");
          AppMethodBeat.o(56081);
          return;
        }
        if ((PickPoi.b(PickPoi.this).c(paramAnonymousAddr)) && (PickPoi.c(PickPoi.this) != null))
        {
          if (PickPoi.this.yMF != null) {
            PickPoi.this.yMF.a(PickPoi.b(PickPoi.this));
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
    this.yMC = new f();
    this.yMD = true;
    this.yME = null;
    this.yLe = new c.a()
    {
      public final void b(Addr paramAnonymousAddr)
      {
        AppMethodBeat.i(56081);
        Log.d("MicroMsg.PickPoi", "onLocationAddr %s", new Object[] { paramAnonymousAddr.toString() });
        if (PickPoi.b(PickPoi.this) == null)
        {
          Log.i("MicroMsg.PickPoi", "error, empty poi!");
          AppMethodBeat.o(56081);
          return;
        }
        if ((PickPoi.b(PickPoi.this).c(paramAnonymousAddr)) && (PickPoi.c(PickPoi.this) != null))
        {
          if (PickPoi.this.yMF != null) {
            PickPoi.this.yMF.a(PickPoi.b(PickPoi.this));
          }
          PickPoi.c(PickPoi.this).notifyDataSetChanged();
        }
        AppMethodBeat.o(56081);
      }
    };
    init(paramContext);
    AppMethodBeat.o(56084);
  }
  
  private void init(final Context paramContext)
  {
    AppMethodBeat.i(56085);
    this.context = paramContext;
    this.yKY = c.bbX();
    this.FN = AnimationUtils.loadAnimation(paramContext, 2130772192);
    final View localView = LayoutInflater.from(paramContext).inflate(2131495309, this, true);
    this.yMB = localView.findViewById(2131303729);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(56080);
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
        localLayoutParams.bottomMargin = ((int)(PickPoi.a(PickPoi.this).getHeight() / 2.0D + 0.5D) + at.fromDPToPix(paramContext, 20));
        localView.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(56080);
      }
    });
    AppMethodBeat.o(56085);
  }
  
  public f getPoi()
  {
    return this.yMC;
  }
  
  public final void l(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(56086);
    this.yMC = new f();
    this.yMC.type = 3;
    this.yMC.mName = this.context.getResources().getString(2131762449);
    this.yMC.cik = paramDouble1;
    this.yMC.cil = paramDouble2;
    this.yMC.yMN = "";
    this.yKY.a(this.yLe);
    this.yKY.a(paramDouble1, paramDouble2, this.yLe);
    this.yMD = true;
    AppMethodBeat.o(56086);
  }
  
  public final void play()
  {
    AppMethodBeat.i(182075);
    this.yMB.clearAnimation();
    this.yMB.startAnimation(this.FN);
    AppMethodBeat.o(182075);
  }
  
  public void setAdapter(e parame)
  {
    this.yME = parame;
  }
  
  public void setLocationArrow(int paramInt)
  {
    AppMethodBeat.i(56087);
    ((ImageView)this.yMB).setImageResource(paramInt);
    AppMethodBeat.o(56087);
  }
  
  public void setOnCurPoiGet(c.b paramb)
  {
    this.yMF = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.PickPoi
 * JD-Core Version:    0.7.0.1
 */