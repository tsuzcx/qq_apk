package com.tencent.mm.plugin.appbrand.r.a;

import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public abstract interface d
{
  public abstract void O(View paramView, int paramInt);
  
  public abstract void a(WebChromeClient.CustomViewCallback paramCustomViewCallback);
  
  public abstract void a(b paramb);
  
  public abstract boolean aXV();
  
  public abstract void b(b paramb);
  
  public abstract boolean bwI();
  
  public abstract void rK(int paramInt);
  
  public abstract void release();
  
  public static final class a
  {
    public static int va(int paramInt)
    {
      AppMethodBeat.i(197427);
      new a();
      int i = a.vb(paramInt);
      ad.i("Luggage.WXA.WindowFullscreenHandler.Factory", "convertActivityOrientation2Direction [%d]->[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(197427);
      return i;
    }
    
    final class a
    {
      static int vb(int paramInt)
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.a.d
 * JD-Core Version:    0.7.0.1
 */