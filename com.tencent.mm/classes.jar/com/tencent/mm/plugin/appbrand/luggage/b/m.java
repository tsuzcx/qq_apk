package com.tencent.mm.plugin.appbrand.luggage.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.q.c;
import com.tencent.mm.plugin.appbrand.widget.b.a;
import com.tencent.mm.plugin.appbrand.widget.b.b;
import com.tencent.mm.plugin.gif.MMAnimateView;

public final class m
  implements b
{
  public final a dx(Context paramContext)
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
    private c ckD;
    private ImageView kPl;
    private MMAnimateView kPm;
    private boolean kPn;
    
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(47486);
      this.ckD = null;
      this.kPm = new MMAnimateView(paramContext);
      addView(this.kPm, new ViewGroup.LayoutParams(-1, -1));
      this.kPm.setVisibility(8);
      this.kPl = new ImageView(paramContext);
      addView(this.kPl, new ViewGroup.LayoutParams(-1, -1));
      this.kPl.setVisibility(8);
      AppMethodBeat.o(47486);
    }
    
    public final boolean aYz()
    {
      return this.kPn;
    }
    
    public final c getReferrerPolicy()
    {
      return this.ckD;
    }
    
    public final View getView()
    {
      return this;
    }
    
    public final void setImageBitmap(Bitmap paramBitmap)
    {
      AppMethodBeat.i(47489);
      this.kPm.setVisibility(8);
      this.kPl.setVisibility(0);
      this.kPl.setImageBitmap(paramBitmap);
      AppMethodBeat.o(47489);
    }
    
    public final void setImageByteArray(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(47488);
      this.kPm.setVisibility(0);
      this.kPl.setVisibility(8);
      this.kPm.g(paramArrayOfByte, "");
      AppMethodBeat.o(47488);
    }
    
    public final void setImageFilePath(String paramString)
    {
      AppMethodBeat.i(47487);
      this.kPm.setVisibility(0);
      this.kPl.setVisibility(8);
      this.kPm.setImageFilePath(paramString);
      AppMethodBeat.o(47487);
    }
    
    public final void setInterceptEvent(boolean paramBoolean)
    {
      this.kPn = paramBoolean;
    }
    
    public final void setReferrerPolicy(c paramc)
    {
      this.ckD = paramc;
    }
    
    public final void setScaleType(ImageView.ScaleType paramScaleType)
    {
      AppMethodBeat.i(47490);
      this.kPl.setScaleType(paramScaleType);
      this.kPm.setScaleType(paramScaleType);
      AppMethodBeat.o(47490);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.m
 * JD-Core Version:    0.7.0.1
 */