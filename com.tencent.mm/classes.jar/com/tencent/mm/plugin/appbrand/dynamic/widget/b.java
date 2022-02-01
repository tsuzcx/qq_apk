package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.a;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.canvas.widget.MCanvasView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MDrawableView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MHardwareAccelerateDrawableView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MSurfaceView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MTextureView;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class b
{
  private static volatile int rol = 0;
  private static volatile boolean sInitialized = false;
  
  public static int coe()
  {
    return rol;
  }
  
  public static String cof()
  {
    switch (rol)
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
  
  public static View dM(Context paramContext)
  {
    AppMethodBeat.i(121603);
    if (!sInitialized) {
      initialize();
    }
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.WidgetDrawableViewFactory", "inflate(mode : %d)", new Object[] { Integer.valueOf(rol) });
    switch (rol)
    {
    default: 
      paramContext = new MHardwareAccelerateDrawableView(paramContext);
      paramContext.getDrawContext().qTo = com.tencent.mm.plugin.appbrand.dynamic.b.b.cnI();
      paramContext.setDrawActionReportable(new com.tencent.mm.plugin.appbrand.canvas.c.a()
      {
        public final void bF(float paramAnonymousFloat)
        {
          AppMethodBeat.i(121599);
          b.b(paramAnonymousFloat, 2, b.this.getTraceId());
          AppMethodBeat.o(121599);
        }
        
        public final void bG(float paramAnonymousFloat)
        {
          AppMethodBeat.i(121600);
          b.b(paramAnonymousFloat, 3, b.this.getTraceId());
          AppMethodBeat.o(121600);
        }
        
        public final void ckl()
        {
          AppMethodBeat.i(121601);
          u.KN(b.this.getTraceId());
          AppMethodBeat.o(121601);
        }
        
        public final void g(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt)
        {
          AppMethodBeat.i(121598);
          com.tencent.mm.plugin.appbrand.widget.i.a.d(0, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousInt);
          AppMethodBeat.o(121598);
        }
        
        public final void jC(long paramAnonymousLong)
        {
          AppMethodBeat.i(121596);
          com.tencent.mm.plugin.appbrand.widget.i.a.N(667, paramAnonymousLong);
          AppMethodBeat.o(121596);
        }
        
        public final void jD(long paramAnonymousLong)
        {
          AppMethodBeat.i(121597);
          com.tencent.mm.plugin.appbrand.widget.i.a.O(668, paramAnonymousLong);
          AppMethodBeat.o(121597);
        }
      });
      AppMethodBeat.o(121603);
      return paramContext;
    case 1: 
      paramContext = new MTextureView(paramContext);
      paramContext.getDrawContext().qTo = com.tencent.mm.plugin.appbrand.dynamic.b.b.cnI();
      paramContext.setDrawActionReportable(new com.tencent.mm.plugin.appbrand.canvas.c.a()
      {
        public final void bF(float paramAnonymousFloat)
        {
          AppMethodBeat.i(121575);
          b.b(paramAnonymousFloat, 2, b.this.getTraceId());
          AppMethodBeat.o(121575);
        }
        
        public final void bG(float paramAnonymousFloat)
        {
          AppMethodBeat.i(121576);
          b.b(paramAnonymousFloat, 3, b.this.getTraceId());
          AppMethodBeat.o(121576);
        }
        
        public final void ckl()
        {
          AppMethodBeat.i(121577);
          u.KN(b.this.getTraceId());
          AppMethodBeat.o(121577);
        }
        
        public final void g(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt)
        {
          AppMethodBeat.i(121574);
          com.tencent.mm.plugin.appbrand.widget.i.a.d(1, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousInt);
          AppMethodBeat.o(121574);
        }
        
        public final void jC(long paramAnonymousLong)
        {
          AppMethodBeat.i(121572);
          com.tencent.mm.plugin.appbrand.widget.i.a.N(682, paramAnonymousLong);
          AppMethodBeat.o(121572);
        }
        
        public final void jD(long paramAnonymousLong)
        {
          AppMethodBeat.i(121573);
          com.tencent.mm.plugin.appbrand.widget.i.a.O(683, paramAnonymousLong);
          AppMethodBeat.o(121573);
        }
      });
      AppMethodBeat.o(121603);
      return paramContext;
    case 2: 
      paramContext = new MSurfaceView(paramContext);
      paramContext.getDrawContext().qTo = com.tencent.mm.plugin.appbrand.dynamic.b.b.cnI();
      paramContext.setDrawActionReportable(new com.tencent.mm.plugin.appbrand.canvas.c.a()
      {
        public final void bF(float paramAnonymousFloat)
        {
          AppMethodBeat.i(121581);
          b.b(paramAnonymousFloat, 2, b.this.getTraceId());
          AppMethodBeat.o(121581);
        }
        
        public final void bG(float paramAnonymousFloat)
        {
          AppMethodBeat.i(121582);
          b.b(paramAnonymousFloat, 3, b.this.getTraceId());
          AppMethodBeat.o(121582);
        }
        
        public final void ckl()
        {
          AppMethodBeat.i(121583);
          if (TextUtils.isEmpty(b.this.getTraceId()))
          {
            u.i("MicroMsg.WidgetDrawableViewFactory", "traceId is null return", new Object[0]);
            AppMethodBeat.o(121583);
            return;
          }
          u.KN(b.this.getTraceId());
          AppMethodBeat.o(121583);
        }
        
        public final void g(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt)
        {
          AppMethodBeat.i(121580);
          com.tencent.mm.plugin.appbrand.widget.i.a.d(2, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousInt);
          AppMethodBeat.o(121580);
        }
        
        public final void jC(long paramAnonymousLong)
        {
          AppMethodBeat.i(121578);
          com.tencent.mm.plugin.appbrand.widget.i.a.N(667, paramAnonymousLong);
          AppMethodBeat.o(121578);
        }
        
        public final void jD(long paramAnonymousLong)
        {
          AppMethodBeat.i(121579);
          com.tencent.mm.plugin.appbrand.widget.i.a.O(668, paramAnonymousLong);
          AppMethodBeat.o(121579);
        }
      });
      AppMethodBeat.o(121603);
      return paramContext;
    case 3: 
      paramContext = new MCanvasView(paramContext);
      paramContext.getDrawContext().qTo = com.tencent.mm.plugin.appbrand.dynamic.b.b.cnI();
      paramContext.setDrawActionReportable(new com.tencent.mm.plugin.appbrand.canvas.c.a()
      {
        public final void bF(float paramAnonymousFloat)
        {
          AppMethodBeat.i(121587);
          b.b(paramAnonymousFloat, 2, b.this.getTraceId());
          AppMethodBeat.o(121587);
        }
        
        public final void bG(float paramAnonymousFloat)
        {
          AppMethodBeat.i(121588);
          b.b(paramAnonymousFloat, 3, b.this.getTraceId());
          AppMethodBeat.o(121588);
        }
        
        public final void ckl()
        {
          AppMethodBeat.i(121589);
          u.KN(b.this.getTraceId());
          AppMethodBeat.o(121589);
        }
        
        public final void g(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt)
        {
          AppMethodBeat.i(121586);
          com.tencent.mm.plugin.appbrand.widget.i.a.d(3, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousInt);
          AppMethodBeat.o(121586);
        }
        
        public final void jC(long paramAnonymousLong)
        {
          AppMethodBeat.i(121584);
          com.tencent.mm.plugin.appbrand.widget.i.a.N(685, paramAnonymousLong);
          AppMethodBeat.o(121584);
        }
        
        public final void jD(long paramAnonymousLong)
        {
          AppMethodBeat.i(121585);
          com.tencent.mm.plugin.appbrand.widget.i.a.O(684, paramAnonymousLong);
          AppMethodBeat.o(121585);
        }
      });
      AppMethodBeat.o(121603);
      return paramContext;
    }
    paramContext = new MDrawableView(paramContext);
    paramContext.getDrawContext().qTo = com.tencent.mm.plugin.appbrand.dynamic.b.b.cnI();
    paramContext.setDrawActionReportable(new com.tencent.mm.plugin.appbrand.canvas.c.a()
    {
      public final void bF(float paramAnonymousFloat)
      {
        AppMethodBeat.i(121593);
        b.b(paramAnonymousFloat, 2, b.this.getTraceId());
        AppMethodBeat.o(121593);
      }
      
      public final void bG(float paramAnonymousFloat)
      {
        AppMethodBeat.i(121594);
        b.b(paramAnonymousFloat, 3, b.this.getTraceId());
        AppMethodBeat.o(121594);
      }
      
      public final void ckl()
      {
        AppMethodBeat.i(121595);
        u.KN(b.this.getTraceId());
        AppMethodBeat.o(121595);
      }
      
      public final void g(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt)
      {
        AppMethodBeat.i(121592);
        com.tencent.mm.plugin.appbrand.widget.i.a.d(4, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousInt);
        AppMethodBeat.o(121592);
      }
      
      public final void jC(long paramAnonymousLong)
      {
        AppMethodBeat.i(121590);
        com.tencent.mm.plugin.appbrand.widget.i.a.N(667, paramAnonymousLong);
        AppMethodBeat.o(121590);
      }
      
      public final void jD(long paramAnonymousLong)
      {
        AppMethodBeat.i(121591);
        com.tencent.mm.plugin.appbrand.widget.i.a.O(668, paramAnonymousLong);
        AppMethodBeat.o(121591);
      }
    });
    AppMethodBeat.o(121603);
    return paramContext;
  }
  
  public static void initialize()
  {
    AppMethodBeat.i(121602);
    com.tencent.mm.ci.a.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121571);
        Object localObject = a.a.mzH;
        localObject = com.tencent.mm.ipcinvoker.wx_extension.a.a.Fd("100284");
        if (localObject == null)
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WidgetDrawableViewFactory", "widget canvas mode ABTest item is null.");
          AppMethodBeat.o(121571);
          return;
        }
        if (!((c)localObject).isValid())
        {
          b.zW(0);
          AppMethodBeat.o(121571);
          return;
        }
        try
        {
          b.zW(Util.getInt((String)((c)localObject).iWZ().get("mode"), 0));
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WidgetDrawableViewFactory", "current canvas mode is : %d", new Object[] { Integer.valueOf(b.rol) });
          AppMethodBeat.o(121571);
          return;
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.WidgetDrawableViewFactory", "parse widget canvas mode error : %s", new Object[] { android.util.Log.getStackTraceString(localException) });
          AppMethodBeat.o(121571);
        }
      }
    });
    AppMethodBeat.o(121602);
  }
  
  public static void zW(int paramInt)
  {
    rol = paramInt;
    sInitialized = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.widget.b
 * JD-Core Version:    0.7.0.1
 */