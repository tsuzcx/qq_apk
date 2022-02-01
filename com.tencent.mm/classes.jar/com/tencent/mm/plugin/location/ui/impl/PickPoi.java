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
import com.tencent.mm.ce.b;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.plugin.map.a.a;
import com.tencent.mm.plugin.map.a.d;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.plugin.map.a.i;
import com.tencent.mm.sdk.platformtools.Log;

public class PickPoi
  extends FrameLayout
{
  public c.a KhE;
  protected c Khx;
  private ImageView Kjf;
  private f Kjg;
  boolean Kjh;
  private e Kji;
  c.b Kjj;
  private Animation bCz;
  private Context context;
  
  public PickPoi(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(56082);
    this.Kjg = new f();
    this.Kjh = true;
    this.Kji = null;
    this.KhE = new c.a()
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
        if ((PickPoi.b(PickPoi.this).d(paramAnonymousAddr)) && (PickPoi.c(PickPoi.this) != null))
        {
          if (PickPoi.this.Kjj != null) {
            PickPoi.this.Kjj.a(PickPoi.b(PickPoi.this));
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
    this.Kjg = new f();
    this.Kjh = true;
    this.Kji = null;
    this.KhE = new c.a()
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
        if ((PickPoi.b(PickPoi.this).d(paramAnonymousAddr)) && (PickPoi.c(PickPoi.this) != null))
        {
          if (PickPoi.this.Kjj != null) {
            PickPoi.this.Kjj.a(PickPoi.b(PickPoi.this));
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
    this.Kjg = new f();
    this.Kjh = true;
    this.Kji = null;
    this.KhE = new c.a()
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
        if ((PickPoi.b(PickPoi.this).d(paramAnonymousAddr)) && (PickPoi.c(PickPoi.this) != null))
        {
          if (PickPoi.this.Kjj != null) {
            PickPoi.this.Kjj.a(PickPoi.b(PickPoi.this));
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
    this.Khx = c.bJh();
    this.bCz = AnimationUtils.loadAnimation(paramContext, a.a.translate_map);
    View localView = LayoutInflater.from(paramContext).inflate(a.f.location_poi_pick, this, true);
    this.Kjf = ((ImageView)localView.findViewById(a.e.location_here));
    if (b.iRp()) {
      this.Kjf.setImageResource(a.d.location_current_marker_easy_mode);
    }
    post(new PickPoi.1(this, localView, paramContext));
    AppMethodBeat.o(56085);
  }
  
  public final void e(double paramDouble1, double paramDouble2, boolean paramBoolean)
  {
    AppMethodBeat.i(264983);
    this.Kjg = new f();
    this.Kjg.type = 3;
    this.Kjg.mName = this.context.getResources().getString(a.i.location);
    this.Kjg.HHO = paramDouble1;
    this.Kjg.HHN = paramDouble2;
    this.Kjg.Kjq = "";
    this.Khx.a(this.KhE);
    this.Khx.a(paramDouble1, paramDouble2, this.KhE, null, paramBoolean);
    this.Kjh = true;
    AppMethodBeat.o(264983);
  }
  
  public f getPoi()
  {
    return this.Kjg;
  }
  
  public final void play()
  {
    AppMethodBeat.i(182075);
    this.Kjf.clearAnimation();
    this.Kjf.startAnimation(this.bCz);
    AppMethodBeat.o(182075);
  }
  
  public void setAdapter(e parame)
  {
    this.Kji = parame;
  }
  
  public void setLocationArrow(int paramInt)
  {
    AppMethodBeat.i(56087);
    this.Kjf.setImageResource(paramInt);
    AppMethodBeat.o(56087);
  }
  
  public void setOnCurPoiGet(c.b paramb)
  {
    this.Kjj = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.PickPoi
 * JD-Core Version:    0.7.0.1
 */