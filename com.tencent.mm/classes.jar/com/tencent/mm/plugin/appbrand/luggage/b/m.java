package com.tencent.mm.plugin.appbrand.luggage.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p.c;
import com.tencent.mm.plugin.appbrand.widget.b.a;
import com.tencent.mm.plugin.appbrand.widget.b.b;
import com.tencent.mm.plugin.gif.MMAnimateView;

public final class m
  implements b
{
  public final a dG(Context paramContext)
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
    private c chC;
    private ImageView lqK;
    private MMAnimateView lqL;
    private boolean lqM;
    
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(47486);
      this.chC = null;
      this.lqL = new MMAnimateView(paramContext);
      addView(this.lqL, new ViewGroup.LayoutParams(-1, -1));
      this.lqL.setVisibility(8);
      this.lqK = new ImageView(paramContext);
      addView(this.lqK, new ViewGroup.LayoutParams(-1, -1));
      this.lqK.setVisibility(8);
      AppMethodBeat.o(47486);
    }
    
    public final boolean bfw()
    {
      return this.lqM;
    }
    
    public final c getReferrerPolicy()
    {
      return this.chC;
    }
    
    public final View getView()
    {
      return this;
    }
    
    public final void setImageBitmap(Bitmap paramBitmap)
    {
      AppMethodBeat.i(47489);
      this.lqL.setVisibility(8);
      this.lqK.setVisibility(0);
      this.lqK.setImageBitmap(paramBitmap);
      AppMethodBeat.o(47489);
    }
    
    public final void setImageByteArray(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(47488);
      this.lqL.setVisibility(0);
      this.lqK.setVisibility(8);
      this.lqL.g(paramArrayOfByte, "");
      AppMethodBeat.o(47488);
    }
    
    public final void setImageFilePath(String paramString)
    {
      AppMethodBeat.i(47487);
      this.lqL.setVisibility(0);
      this.lqK.setVisibility(8);
      this.lqL.setImageFilePath(paramString);
      AppMethodBeat.o(47487);
    }
    
    public final void setInterceptEvent(boolean paramBoolean)
    {
      this.lqM = paramBoolean;
    }
    
    public final void setReferrerPolicy(c paramc)
    {
      this.chC = paramc;
    }
    
    public final void setScaleType(ImageView.ScaleType paramScaleType)
    {
      AppMethodBeat.i(47490);
      this.lqK.setScaleType(paramScaleType);
      this.lqL.setScaleType(paramScaleType);
      AppMethodBeat.o(47490);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.m
 * JD-Core Version:    0.7.0.1
 */