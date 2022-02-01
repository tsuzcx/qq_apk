package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.canvas.widget.MCanvasView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MDrawableView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MHardwareAccelerateDrawableView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MSurfaceView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MTextureView;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  private static volatile int lpY = 0;
  private static volatile boolean sInitialized = false;
  
  public static int bCu()
  {
    return lpY;
  }
  
  public static String bCv()
  {
    switch (lpY)
    {
    default: 
      return "MHADrawableView";
    case 1: 
      return "MTextureView";
    case 2: 
      return "MSurfaceView";
    case 3: 
      return "MCanvasView";
    }
    return "MDrawableView";
  }
  
  public static View cU(Context paramContext)
  {
    AppMethodBeat.i(121603);
    if (!sInitialized) {
      initialize();
    }
    Log.d("MicroMsg.WidgetDrawableViewFactory", "inflate(mode : %d)", new Object[] { Integer.valueOf(lpY) });
    switch (lpY)
    {
    default: 
      paramContext = new MHardwareAccelerateDrawableView(paramContext);
      paramContext.getDrawContext().kZr = com.tencent.mm.plugin.appbrand.dynamic.b.b.bBX();
      paramContext.setDrawActionReportable(new com.tencent.mm.plugin.appbrand.canvas.c.a()
      {
        public final void Ba(long paramAnonymousLong)
        {
          AppMethodBeat.i(121596);
          com.tencent.mm.plugin.appbrand.widget.g.a.J(667, paramAnonymousLong);
          AppMethodBeat.o(121596);
        }
        
        public final void Bb(long paramAnonymousLong)
        {
          AppMethodBeat.i(121597);
          com.tencent.mm.plugin.appbrand.widget.g.a.K(668, paramAnonymousLong);
          AppMethodBeat.o(121597);
        }
        
        public final void aH(float paramAnonymousFloat)
        {
          AppMethodBeat.i(121599);
          b.b(paramAnonymousFloat, 2, this.lqd.getTraceId());
          AppMethodBeat.o(121599);
        }
        
        public final void aI(float paramAnonymousFloat)
        {
          AppMethodBeat.i(121600);
          b.b(paramAnonymousFloat, 3, this.lqd.getTraceId());
          AppMethodBeat.o(121600);
        }
        
        public final void bzw()
        {
          AppMethodBeat.i(121601);
          u.Ls(this.lqd.getTraceId());
          AppMethodBeat.o(121601);
        }
        
        public final void d(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt)
        {
          AppMethodBeat.i(121598);
          com.tencent.mm.plugin.appbrand.widget.g.a.d(0, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousInt);
          AppMethodBeat.o(121598);
        }
      });
      AppMethodBeat.o(121603);
      return paramContext;
    case 1: 
      paramContext = new MTextureView(paramContext);
      paramContext.getDrawContext().kZr = com.tencent.mm.plugin.appbrand.dynamic.b.b.bBX();
      paramContext.setDrawActionReportable(new com.tencent.mm.plugin.appbrand.canvas.c.a()
      {
        public final void Ba(long paramAnonymousLong)
        {
          AppMethodBeat.i(121572);
          com.tencent.mm.plugin.appbrand.widget.g.a.J(682, paramAnonymousLong);
          AppMethodBeat.o(121572);
        }
        
        public final void Bb(long paramAnonymousLong)
        {
          AppMethodBeat.i(121573);
          com.tencent.mm.plugin.appbrand.widget.g.a.K(683, paramAnonymousLong);
          AppMethodBeat.o(121573);
        }
        
        public final void aH(float paramAnonymousFloat)
        {
          AppMethodBeat.i(121575);
          b.b(paramAnonymousFloat, 2, this.lpZ.getTraceId());
          AppMethodBeat.o(121575);
        }
        
        public final void aI(float paramAnonymousFloat)
        {
          AppMethodBeat.i(121576);
          b.b(paramAnonymousFloat, 3, this.lpZ.getTraceId());
          AppMethodBeat.o(121576);
        }
        
        public final void bzw()
        {
          AppMethodBeat.i(121577);
          u.Ls(this.lpZ.getTraceId());
          AppMethodBeat.o(121577);
        }
        
        public final void d(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt)
        {
          AppMethodBeat.i(121574);
          com.tencent.mm.plugin.appbrand.widget.g.a.d(1, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousInt);
          AppMethodBeat.o(121574);
        }
      });
      AppMethodBeat.o(121603);
      return paramContext;
    case 2: 
      paramContext = new MSurfaceView(paramContext);
      paramContext.getDrawContext().kZr = com.tencent.mm.plugin.appbrand.dynamic.b.b.bBX();
      paramContext.setDrawActionReportable(new com.tencent.mm.plugin.appbrand.canvas.c.a()
      {
        public final void Ba(long paramAnonymousLong)
        {
          AppMethodBeat.i(121578);
          com.tencent.mm.plugin.appbrand.widget.g.a.J(667, paramAnonymousLong);
          AppMethodBeat.o(121578);
        }
        
        public final void Bb(long paramAnonymousLong)
        {
          AppMethodBeat.i(121579);
          com.tencent.mm.plugin.appbrand.widget.g.a.K(668, paramAnonymousLong);
          AppMethodBeat.o(121579);
        }
        
        public final void aH(float paramAnonymousFloat)
        {
          AppMethodBeat.i(121581);
          b.b(paramAnonymousFloat, 2, this.lqa.getTraceId());
          AppMethodBeat.o(121581);
        }
        
        public final void aI(float paramAnonymousFloat)
        {
          AppMethodBeat.i(121582);
          b.b(paramAnonymousFloat, 3, this.lqa.getTraceId());
          AppMethodBeat.o(121582);
        }
        
        public final void bzw()
        {
          AppMethodBeat.i(121583);
          if (TextUtils.isEmpty(this.lqa.getTraceId()))
          {
            u.i("MicroMsg.WidgetDrawableViewFactory", "traceId is null return", new Object[0]);
            AppMethodBeat.o(121583);
            return;
          }
          u.Ls(this.lqa.getTraceId());
          AppMethodBeat.o(121583);
        }
        
        public final void d(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt)
        {
          AppMethodBeat.i(121580);
          com.tencent.mm.plugin.appbrand.widget.g.a.d(2, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousInt);
          AppMethodBeat.o(121580);
        }
      });
      AppMethodBeat.o(121603);
      return paramContext;
    case 3: 
      paramContext = new MCanvasView(paramContext);
      paramContext.getDrawContext().kZr = com.tencent.mm.plugin.appbrand.dynamic.b.b.bBX();
      paramContext.setDrawActionReportable(new com.tencent.mm.plugin.appbrand.canvas.c.a()
      {
        public final void Ba(long paramAnonymousLong)
        {
          AppMethodBeat.i(121584);
          com.tencent.mm.plugin.appbrand.widget.g.a.J(685, paramAnonymousLong);
          AppMethodBeat.o(121584);
        }
        
        public final void Bb(long paramAnonymousLong)
        {
          AppMethodBeat.i(121585);
          com.tencent.mm.plugin.appbrand.widget.g.a.K(684, paramAnonymousLong);
          AppMethodBeat.o(121585);
        }
        
        public final void aH(float paramAnonymousFloat)
        {
          AppMethodBeat.i(121587);
          b.b(paramAnonymousFloat, 2, this.lqb.getTraceId());
          AppMethodBeat.o(121587);
        }
        
        public final void aI(float paramAnonymousFloat)
        {
          AppMethodBeat.i(121588);
          b.b(paramAnonymousFloat, 3, this.lqb.getTraceId());
          AppMethodBeat.o(121588);
        }
        
        public final void bzw()
        {
          AppMethodBeat.i(121589);
          u.Ls(this.lqb.getTraceId());
          AppMethodBeat.o(121589);
        }
        
        public final void d(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt)
        {
          AppMethodBeat.i(121586);
          com.tencent.mm.plugin.appbrand.widget.g.a.d(3, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousInt);
          AppMethodBeat.o(121586);
        }
      });
      AppMethodBeat.o(121603);
      return paramContext;
    }
    paramContext = new MDrawableView(paramContext);
    paramContext.getDrawContext().kZr = com.tencent.mm.plugin.appbrand.dynamic.b.b.bBX();
    paramContext.setDrawActionReportable(new com.tencent.mm.plugin.appbrand.canvas.c.a()
    {
      public final void Ba(long paramAnonymousLong)
      {
        AppMethodBeat.i(121590);
        com.tencent.mm.plugin.appbrand.widget.g.a.J(667, paramAnonymousLong);
        AppMethodBeat.o(121590);
      }
      
      public final void Bb(long paramAnonymousLong)
      {
        AppMethodBeat.i(121591);
        com.tencent.mm.plugin.appbrand.widget.g.a.K(668, paramAnonymousLong);
        AppMethodBeat.o(121591);
      }
      
      public final void aH(float paramAnonymousFloat)
      {
        AppMethodBeat.i(121593);
        b.b(paramAnonymousFloat, 2, this.lqc.getTraceId());
        AppMethodBeat.o(121593);
      }
      
      public final void aI(float paramAnonymousFloat)
      {
        AppMethodBeat.i(121594);
        b.b(paramAnonymousFloat, 3, this.lqc.getTraceId());
        AppMethodBeat.o(121594);
      }
      
      public final void bzw()
      {
        AppMethodBeat.i(121595);
        u.Ls(this.lqc.getTraceId());
        AppMethodBeat.o(121595);
      }
      
      public final void d(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt)
      {
        AppMethodBeat.i(121592);
        com.tencent.mm.plugin.appbrand.widget.g.a.d(4, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousInt);
        AppMethodBeat.o(121592);
      }
    });
    AppMethodBeat.o(121603);
    return paramContext;
  }
  
  public static void initialize()
  {
    AppMethodBeat.i(121602);
    com.tencent.mm.ch.a.post(new b.1());
    AppMethodBeat.o(121602);
  }
  
  public static void wt(int paramInt)
  {
    lpY = paramInt;
    sInitialized = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.widget.b
 * JD-Core Version:    0.7.0.1
 */