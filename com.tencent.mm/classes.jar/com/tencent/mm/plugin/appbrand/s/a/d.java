package com.tencent.mm.plugin.appbrand.s.a;

import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public abstract interface d
{
  public abstract void O(View paramView, int paramInt);
  
  public abstract void a(WebChromeClient.CustomViewCallback paramCustomViewCallback);
  
  public abstract void a(b paramb);
  
  public abstract boolean aNT();
  
  public abstract void b(b paramb);
  
  public abstract boolean blI();
  
  public abstract void qw(int paramInt);
  
  public abstract void release();
  
  public static final class a
  {
    public static int tE(int paramInt)
    {
      AppMethodBeat.i(194517);
      new a();
      int i = a.tF(paramInt);
      ad.i("Luggage.WXA.WindowFullscreenHandler.Factory", "convertActivityOrientation2Direction [%d]->[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(194517);
      return i;
    }
    
    final class a
    {
      static int tF(int paramInt)
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.a.d
 * JD-Core Version:    0.7.0.1
 */