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
import com.tencent.mm.plugin.appbrand.jsapi.u.c;
import com.tencent.mm.plugin.appbrand.widget.b.a;
import com.tencent.mm.plugin.appbrand.widget.b.b;
import com.tencent.mm.plugin.gif.MMAnimateView;

public final class n
  implements b
{
  public final a ed(Context paramContext)
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
    private c cEN;
    private ImageView cIN;
    private MMAnimateView naj;
    private boolean nak;
    private ad.b nal;
    
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(47486);
      this.cEN = null;
      this.naj = new MMAnimateView(paramContext);
      addView(this.naj, new ViewGroup.LayoutParams(-1, -1));
      this.naj.setVisibility(8);
      this.cIN = new ImageView(paramContext);
      addView(this.cIN, new ViewGroup.LayoutParams(-1, -1));
      this.cIN.setVisibility(8);
      AppMethodBeat.o(47486);
    }
    
    public final boolean bEY()
    {
      return this.nak;
    }
    
    public final ad.b getKeyValueSet()
    {
      return this.nal;
    }
    
    public final c getReferrerPolicy()
    {
      return this.cEN;
    }
    
    public final View getView()
    {
      return this;
    }
    
    public final void setImageBitmap(Bitmap paramBitmap)
    {
      AppMethodBeat.i(47489);
      this.naj.setVisibility(8);
      this.cIN.setVisibility(0);
      this.cIN.setImageBitmap(paramBitmap);
      AppMethodBeat.o(47489);
    }
    
    public final void setImageByteArray(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(47488);
      this.naj.setVisibility(0);
      this.cIN.setVisibility(8);
      this.naj.g(paramArrayOfByte, "");
      AppMethodBeat.o(47488);
    }
    
    public final void setImageFilePath(String paramString)
    {
      AppMethodBeat.i(47487);
      this.naj.setVisibility(0);
      this.cIN.setVisibility(8);
      this.naj.setImageFilePath(paramString);
      AppMethodBeat.o(47487);
    }
    
    public final void setInterceptEvent(boolean paramBoolean)
    {
      this.nak = paramBoolean;
    }
    
    public final void setKeyValueSet(ad.b paramb)
    {
      this.nal = paramb;
    }
    
    public final void setReferrerPolicy(c paramc)
    {
      this.cEN = paramc;
    }
    
    public final void setScaleType(ImageView.ScaleType paramScaleType)
    {
      AppMethodBeat.i(47490);
      this.cIN.setScaleType(paramScaleType);
      this.naj.setScaleType(paramScaleType);
      AppMethodBeat.o(47490);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.n
 * JD-Core Version:    0.7.0.1
 */