package com.tencent.mm.plugin.appbrand.luggage.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s.c;
import com.tencent.mm.plugin.appbrand.widget.b.a;
import com.tencent.mm.plugin.appbrand.widget.b.b;
import com.tencent.mm.plugin.gif.MMAnimateView;

public final class n
  implements b
{
  public final a dI(Context paramContext)
  {
    AppMethodBeat.i(47492);
    paramContext = new a(paramContext);
    AppMethodBeat.o(47492);
    return paramContext;
  }
  
  public final class a
    extends FrameLayout
    implements a
  {
    private c csx;
    private ImageView cuP;
    private MMAnimateView lSJ;
    private boolean lSK;
    
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(47486);
      this.csx = null;
      this.lSJ = new MMAnimateView(paramContext);
      addView(this.lSJ, new ViewGroup.LayoutParams(-1, -1));
      this.lSJ.setVisibility(8);
      this.cuP = new ImageView(paramContext);
      addView(this.cuP, new ViewGroup.LayoutParams(-1, -1));
      this.cuP.setVisibility(8);
      AppMethodBeat.o(47486);
    }
    
    public final boolean bjI()
    {
      return this.lSK;
    }
    
    public final c getReferrerPolicy()
    {
      return this.csx;
    }
    
    public final View getView()
    {
      return this;
    }
    
    public final void setImageBitmap(Bitmap paramBitmap)
    {
      AppMethodBeat.i(47489);
      this.lSJ.setVisibility(8);
      this.cuP.setVisibility(0);
      this.cuP.setImageBitmap(paramBitmap);
      AppMethodBeat.o(47489);
    }
    
    public final void setImageByteArray(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(47488);
      this.lSJ.setVisibility(0);
      this.cuP.setVisibility(8);
      this.lSJ.g(paramArrayOfByte, "");
      AppMethodBeat.o(47488);
    }
    
    public final void setImageFilePath(String paramString)
    {
      AppMethodBeat.i(47487);
      this.lSJ.setVisibility(0);
      this.cuP.setVisibility(8);
      this.lSJ.setImageFilePath(paramString);
      AppMethodBeat.o(47487);
    }
    
    public final void setInterceptEvent(boolean paramBoolean)
    {
      this.lSK = paramBoolean;
    }
    
    public final void setReferrerPolicy(c paramc)
    {
      this.csx = paramc;
    }
    
    public final void setScaleType(ImageView.ScaleType paramScaleType)
    {
      AppMethodBeat.i(47490);
      this.cuP.setScaleType(paramScaleType);
      this.lSJ.setScaleType(paramScaleType);
      AppMethodBeat.o(47490);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.n
 * JD-Core Version:    0.7.0.1
 */