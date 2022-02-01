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
import com.tencent.mm.plugin.appbrand.jsapi.y.c;
import com.tencent.mm.plugin.appbrand.widget.c.a;
import com.tencent.mm.plugin.appbrand.widget.c.b;
import com.tencent.mm.plugin.gif.MMAnimateView;

public final class l
  implements b
{
  public final a eX(Context paramContext)
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
    private ImageView ewg;
    private c eyH;
    private MMAnimateView tfD;
    private boolean tfE;
    private ad.b tfF;
    
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(47486);
      this.eyH = null;
      this.tfD = new MMAnimateView(paramContext);
      addView(this.tfD, new ViewGroup.LayoutParams(-1, -1));
      this.tfD.setVisibility(8);
      this.ewg = new ImageView(paramContext);
      addView(this.ewg, new ViewGroup.LayoutParams(-1, -1));
      this.ewg.setVisibility(8);
      AppMethodBeat.o(47486);
    }
    
    public final boolean cqz()
    {
      return this.tfE;
    }
    
    public final ad.b getKeyValueSet()
    {
      return this.tfF;
    }
    
    public final c getReferrerPolicy()
    {
      return this.eyH;
    }
    
    public final View getView()
    {
      return this;
    }
    
    public final void setImageBitmap(Bitmap paramBitmap)
    {
      AppMethodBeat.i(47489);
      this.tfD.setVisibility(8);
      this.ewg.setVisibility(0);
      this.ewg.setImageBitmap(paramBitmap);
      AppMethodBeat.o(47489);
    }
    
    public final void setImageByteArray(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(47488);
      this.tfD.setVisibility(0);
      this.ewg.setVisibility(8);
      this.tfD.h(paramArrayOfByte, "");
      AppMethodBeat.o(47488);
    }
    
    public final void setImageFilePath(String paramString)
    {
      AppMethodBeat.i(47487);
      this.tfD.setVisibility(0);
      this.ewg.setVisibility(8);
      this.tfD.setImageFilePath(paramString);
      AppMethodBeat.o(47487);
    }
    
    public final void setInterceptEvent(boolean paramBoolean)
    {
      this.tfE = paramBoolean;
    }
    
    public final void setKeyValueSet(ad.b paramb)
    {
      this.tfF = paramb;
    }
    
    public final void setReferrerPolicy(c paramc)
    {
      this.eyH = paramc;
    }
    
    public final void setScaleType(ImageView.ScaleType paramScaleType)
    {
      AppMethodBeat.i(47490);
      this.ewg.setScaleType(paramScaleType);
      this.tfD.setScaleType(paramScaleType);
      AppMethodBeat.o(47490);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.l
 * JD-Core Version:    0.7.0.1
 */