package com.tencent.mm.plugin.appbrand.platform.window;

import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public abstract interface d
{
  public abstract void O(View paramView, int paramInt);
  
  public abstract void a(WebChromeClient.CustomViewCallback paramCustomViewCallback);
  
  public abstract void a(b paramb);
  
  public abstract boolean aYo();
  
  public abstract void b(b paramb);
  
  public abstract boolean bxz();
  
  public abstract void rM(int paramInt);
  
  public abstract void release();
  
  public static final class a
  {
    public static int vf(int paramInt)
    {
      AppMethodBeat.i(207968);
      new a();
      int i = a.vg(paramInt);
      ae.i("Luggage.WXA.WindowFullscreenHandler.Factory", "convertActivityOrientation2Direction [%d]->[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(207968);
      return i;
    }
    
    final class a
    {
      static int vg(int paramInt)
      {
        switch (paramInt)
        {
        default: 
          return 0;
        case 0: 
          return 90;
        case 8: 
          return -90;
        }
        return 180;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.d
 * JD-Core Version:    0.7.0.1
 */