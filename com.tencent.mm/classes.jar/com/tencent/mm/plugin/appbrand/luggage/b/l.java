package com.tencent.mm.plugin.appbrand.luggage.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.jsapi.v.c;
import com.tencent.mm.plugin.appbrand.widget.b.a;
import com.tencent.mm.plugin.appbrand.widget.b.b;
import com.tencent.mm.plugin.gif.MMAnimateView;

public final class l
  implements b
{
  public final a ec(Context paramContext)
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
    private c cFt;
    private ImageView cJr;
    private ad.b qaA;
    private MMAnimateView qay;
    private boolean qaz;
    
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(47486);
      this.cFt = null;
      this.qay = new MMAnimateView(paramContext);
      addView(this.qay, new ViewGroup.LayoutParams(-1, -1));
      this.qay.setVisibility(8);
      this.cJr = new ImageView(paramContext);
      addView(this.cJr, new ViewGroup.LayoutParams(-1, -1));
      this.cJr.setVisibility(8);
      AppMethodBeat.o(47486);
    }
    
    public final boolean bQC()
    {
      return this.qaz;
    }
    
    public final ad.b getKeyValueSet()
    {
      return this.qaA;
    }
    
    public final c getReferrerPolicy()
    {
      return this.cFt;
    }
    
    public final View getView()
    {
      return this;
    }
    
    public final void setImageBitmap(Bitmap paramBitmap)
    {
      AppMethodBeat.i(47489);
      this.qay.setVisibility(8);
      this.cJr.setVisibility(0);
      this.cJr.setImageBitmap(paramBitmap);
      AppMethodBeat.o(47489);
    }
    
    public final void setImageByteArray(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(47488);
      this.qay.setVisibility(0);
      this.cJr.setVisibility(8);
      this.qay.h(paramArrayOfByte, "");
      AppMethodBeat.o(47488);
    }
    
    public final void setImageFilePath(String paramString)
    {
      AppMethodBeat.i(47487);
      this.qay.setVisibility(0);
      this.cJr.setVisibility(8);
      this.qay.setImageFilePath(paramString);
      AppMethodBeat.o(47487);
    }
    
    public final void setInterceptEvent(boolean paramBoolean)
    {
      this.qaz = paramBoolean;
    }
    
    public final void setKeyValueSet(ad.b paramb)
    {
      this.qaA = paramb;
    }
    
    public final void setReferrerPolicy(c paramc)
    {
      this.cFt = paramc;
    }
    
    public final void setScaleType(ImageView.ScaleType paramScaleType)
    {
      AppMethodBeat.i(47490);
      this.cJr.setScaleType(paramScaleType);
      this.qay.setScaleType(paramScaleType);
      AppMethodBeat.o(47490);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.l
 * JD-Core Version:    0.7.0.1
 */