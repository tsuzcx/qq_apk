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
import com.tencent.mm.sdk.platformtools.ad;

public final class b
{
  private static volatile int kiY = 0;
  private static volatile boolean sInitialized = false;
  
  public static int bgt()
  {
    return kiY;
  }
  
  public static String bgu()
  {
    switch (kiY)
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
  
  public static View cw(Context paramContext)
  {
    AppMethodBeat.i(121603);
    if (!sInitialized) {
      initialize();
    }
    ad.d("MicroMsg.WidgetDrawableViewFactory", "inflate(mode : %d)", new Object[] { Integer.valueOf(kiY) });
    switch (kiY)
    {
    default: 
      paramContext = new MHardwareAccelerateDrawableView(paramContext);
      paramContext.getDrawContext().jTe = com.tencent.mm.plugin.appbrand.dynamic.b.b.bfW();
      paramContext.setDrawActionReportable(new com.tencent.mm.plugin.appbrand.canvas.c.a()
      {
        public final void ax(float paramAnonymousFloat)
        {
          AppMethodBeat.i(121599);
          b.b(paramAnonymousFloat, 2, this.kjd.getTraceId());
          AppMethodBeat.o(121599);
        }
        
        public final void ay(float paramAnonymousFloat)
        {
          AppMethodBeat.i(121600);
          b.b(paramAnonymousFloat, 3, this.kjd.getTraceId());
          AppMethodBeat.o(121600);
        }
        
        public final void bdA()
        {
          AppMethodBeat.i(121601);
          u.Cf(this.kjd.getTraceId());
          AppMethodBeat.o(121601);
        }
        
        public final void d(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt)
        {
          AppMethodBeat.i(121598);
          com.tencent.mm.plugin.appbrand.widget.f.a.d(0, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousInt);
          AppMethodBeat.o(121598);
        }
        
        public final void sH(long paramAnonymousLong)
        {
          AppMethodBeat.i(121596);
          com.tencent.mm.plugin.appbrand.widget.f.a.H(667, paramAnonymousLong);
          AppMethodBeat.o(121596);
        }
        
        public final void sI(long paramAnonymousLong)
        {
          AppMethodBeat.i(121597);
          com.tencent.mm.plugin.appbrand.widget.f.a.I(668, paramAnonymousLong);
          AppMethodBeat.o(121597);
        }
      });
      AppMethodBeat.o(121603);
      return paramContext;
    case 1: 
      paramContext = new MTextureView(paramContext);
      paramContext.getDrawContext().jTe = com.tencent.mm.plugin.appbrand.dynamic.b.b.bfW();
      paramContext.setDrawActionReportable(new com.tencent.mm.plugin.appbrand.canvas.c.a()
      {
        public final void ax(float paramAnonymousFloat)
        {
          AppMethodBeat.i(121575);
          b.b(paramAnonymousFloat, 2, this.kiZ.getTraceId());
          AppMethodBeat.o(121575);
        }
        
        public final void ay(float paramAnonymousFloat)
        {
          AppMethodBeat.i(121576);
          b.b(paramAnonymousFloat, 3, this.kiZ.getTraceId());
          AppMethodBeat.o(121576);
        }
        
        public final void bdA()
        {
          AppMethodBeat.i(121577);
          u.Cf(this.kiZ.getTraceId());
          AppMethodBeat.o(121577);
        }
        
        public final void d(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt)
        {
          AppMethodBeat.i(121574);
          com.tencent.mm.plugin.appbrand.widget.f.a.d(1, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousInt);
          AppMethodBeat.o(121574);
        }
        
        public final void sH(long paramAnonymousLong)
        {
          AppMethodBeat.i(121572);
          com.tencent.mm.plugin.appbrand.widget.f.a.H(682, paramAnonymousLong);
          AppMethodBeat.o(121572);
        }
        
        public final void sI(long paramAnonymousLong)
        {
          AppMethodBeat.i(121573);
          com.tencent.mm.plugin.appbrand.widget.f.a.I(683, paramAnonymousLong);
          AppMethodBeat.o(121573);
        }
      });
      AppMethodBeat.o(121603);
      return paramContext;
    case 2: 
      paramContext = new MSurfaceView(paramContext);
      paramContext.getDrawContext().jTe = com.tencent.mm.plugin.appbrand.dynamic.b.b.bfW();
      paramContext.setDrawActionReportable(new com.tencent.mm.plugin.appbrand.canvas.c.a()
      {
        public final void ax(float paramAnonymousFloat)
        {
          AppMethodBeat.i(121581);
          b.b(paramAnonymousFloat, 2, this.kja.getTraceId());
          AppMethodBeat.o(121581);
        }
        
        public final void ay(float paramAnonymousFloat)
        {
          AppMethodBeat.i(121582);
          b.b(paramAnonymousFloat, 3, this.kja.getTraceId());
          AppMethodBeat.o(121582);
        }
        
        public final void bdA()
        {
          AppMethodBeat.i(121583);
          if (TextUtils.isEmpty(this.kja.getTraceId()))
          {
            u.i("MicroMsg.WidgetDrawableViewFactory", "traceId is null return", new Object[0]);
            AppMethodBeat.o(121583);
            return;
          }
          u.Cf(this.kja.getTraceId());
          AppMethodBeat.o(121583);
        }
        
        public final void d(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt)
        {
          AppMethodBeat.i(121580);
          com.tencent.mm.plugin.appbrand.widget.f.a.d(2, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousInt);
          AppMethodBeat.o(121580);
        }
        
        public final void sH(long paramAnonymousLong)
        {
          AppMethodBeat.i(121578);
          com.tencent.mm.plugin.appbrand.widget.f.a.H(667, paramAnonymousLong);
          AppMethodBeat.o(121578);
        }
        
        public final void sI(long paramAnonymousLong)
        {
          AppMethodBeat.i(121579);
          com.tencent.mm.plugin.appbrand.widget.f.a.I(668, paramAnonymousLong);
          AppMethodBeat.o(121579);
        }
      });
      AppMethodBeat.o(121603);
      return paramContext;
    case 3: 
      paramContext = new MCanvasView(paramContext);
      paramContext.getDrawContext().jTe = com.tencent.mm.plugin.appbrand.dynamic.b.b.bfW();
      paramContext.setDrawActionReportable(new com.tencent.mm.plugin.appbrand.canvas.c.a()
      {
        public final void ax(float paramAnonymousFloat)
        {
          AppMethodBeat.i(121587);
          b.b(paramAnonymousFloat, 2, this.kjb.getTraceId());
          AppMethodBeat.o(121587);
        }
        
        public final void ay(float paramAnonymousFloat)
        {
          AppMethodBeat.i(121588);
          b.b(paramAnonymousFloat, 3, this.kjb.getTraceId());
          AppMethodBeat.o(121588);
        }
        
        public final void bdA()
        {
          AppMethodBeat.i(121589);
          u.Cf(this.kjb.getTraceId());
          AppMethodBeat.o(121589);
        }
        
        public final void d(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt)
        {
          AppMethodBeat.i(121586);
          com.tencent.mm.plugin.appbrand.widget.f.a.d(3, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousInt);
          AppMethodBeat.o(121586);
        }
        
        public final void sH(long paramAnonymousLong)
        {
          AppMethodBeat.i(121584);
          com.tencent.mm.plugin.appbrand.widget.f.a.H(685, paramAnonymousLong);
          AppMethodBeat.o(121584);
        }
        
        public final void sI(long paramAnonymousLong)
        {
          AppMethodBeat.i(121585);
          com.tencent.mm.plugin.appbrand.widget.f.a.I(684, paramAnonymousLong);
          AppMethodBeat.o(121585);
        }
      });
      AppMethodBeat.o(121603);
      return paramContext;
    }
    paramContext = new MDrawableView(paramContext);
    paramContext.getDrawContext().jTe = com.tencent.mm.plugin.appbrand.dynamic.b.b.bfW();
    paramContext.setDrawActionReportable(new com.tencent.mm.plugin.appbrand.canvas.c.a()
    {
      public final void ax(float paramAnonymousFloat)
      {
        AppMethodBeat.i(121593);
        b.b(paramAnonymousFloat, 2, this.kjc.getTraceId());
        AppMethodBeat.o(121593);
      }
      
      public final void ay(float paramAnonymousFloat)
      {
        AppMethodBeat.i(121594);
        b.b(paramAnonymousFloat, 3, this.kjc.getTraceId());
        AppMethodBeat.o(121594);
      }
      
      public final void bdA()
      {
        AppMethodBeat.i(121595);
        u.Cf(this.kjc.getTraceId());
        AppMethodBeat.o(121595);
      }
      
      public final void d(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt)
      {
        AppMethodBeat.i(121592);
        com.tencent.mm.plugin.appbrand.widget.f.a.d(4, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousInt);
        AppMethodBeat.o(121592);
      }
      
      public final void sH(long paramAnonymousLong)
      {
        AppMethodBeat.i(121590);
        com.tencent.mm.plugin.appbrand.widget.f.a.H(667, paramAnonymousLong);
        AppMethodBeat.o(121590);
      }
      
      public final void sI(long paramAnonymousLong)
      {
        AppMethodBeat.i(121591);
        com.tencent.mm.plugin.appbrand.widget.f.a.I(668, paramAnonymousLong);
        AppMethodBeat.o(121591);
      }
    });
    AppMethodBeat.o(121603);
    return paramContext;
  }
  
  public static void initialize()
  {
    AppMethodBeat.i(121602);
    com.tencent.mm.ci.a.post(new b.1());
    AppMethodBeat.o(121602);
  }
  
  public static void su(int paramInt)
  {
    kiY = paramInt;
    sInitialized = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.widget.b
 * JD-Core Version:    0.7.0.1
 */