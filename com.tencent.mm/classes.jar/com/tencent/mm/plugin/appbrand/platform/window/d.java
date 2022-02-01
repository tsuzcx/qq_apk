package com.tencent.mm.plugin.appbrand.platform.window;

import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public abstract interface d
{
  public abstract void O(View paramView, int paramInt);
  
  public abstract void a(WebChromeClient.CustomViewCallback paramCustomViewCallback);
  
  public abstract void a(b paramb);
  
  public abstract void b(b paramb);
  
  public abstract boolean bEz();
  
  public abstract boolean cgP();
  
  public abstract void release();
  
  public abstract void yS(int paramInt);
  
  public static final class a
  {
    public static int CC(int paramInt)
    {
      AppMethodBeat.i(242764);
      new a();
      int i = a.CD(paramInt);
      Log.i("Luggage.WXA.WindowFullscreenHandler.Factory", "convertActivityOrientation2Direction [%d]->[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(242764);
      return i;
    }
    
    final class a
    {
      static int CD(int paramInt)
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