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

public final class m
  implements b
{
  public final a dE(Context paramContext)
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
    private c crU;
    private ImageView cum;
    private MMAnimateView lOi;
    private boolean lOj;
    
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(47486);
      this.crU = null;
      this.lOi = new MMAnimateView(paramContext);
      addView(this.lOi, new ViewGroup.LayoutParams(-1, -1));
      this.lOi.setVisibility(8);
      this.cum = new ImageView(paramContext);
      addView(this.cum, new ViewGroup.LayoutParams(-1, -1));
      this.cum.setVisibility(8);
      AppMethodBeat.o(47486);
    }
    
    public final boolean biZ()
    {
      return this.lOj;
    }
    
    public final c getReferrerPolicy()
    {
      return this.crU;
    }
    
    public final View getView()
    {
      return this;
    }
    
    public final void setImageBitmap(Bitmap paramBitmap)
    {
      AppMethodBeat.i(47489);
      this.lOi.setVisibility(8);
      this.cum.setVisibility(0);
      this.cum.setImageBitmap(paramBitmap);
      AppMethodBeat.o(47489);
    }
    
    public final void setImageByteArray(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(47488);
      this.lOi.setVisibility(0);
      this.cum.setVisibility(8);
      this.lOi.g(paramArrayOfByte, "");
      AppMethodBeat.o(47488);
    }
    
    public final void setImageFilePath(String paramString)
    {
      AppMethodBeat.i(47487);
      this.lOi.setVisibility(0);
      this.cum.setVisibility(8);
      this.lOi.setImageFilePath(paramString);
      AppMethodBeat.o(47487);
    }
    
    public final void setInterceptEvent(boolean paramBoolean)
    {
      this.lOj = paramBoolean;
    }
    
    public final void setReferrerPolicy(c paramc)
    {
      this.crU = paramc;
    }
    
    public final void setScaleType(ImageView.ScaleType paramScaleType)
    {
      AppMethodBeat.i(47490);
      this.cum.setScaleType(paramScaleType);
      this.lOi.setScaleType(paramScaleType);
      AppMethodBeat.o(47490);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.m
 * JD-Core Version:    0.7.0.1
 */