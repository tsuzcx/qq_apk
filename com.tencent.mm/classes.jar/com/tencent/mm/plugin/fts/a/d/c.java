package com.tencent.mm.plugin.fts.a.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface c
{
  public abstract String a(ImageView paramImageView, String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2);
  
  public abstract void a(Context paramContext, ImageView paramImageView, String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2);
  
  public abstract Bitmap b(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2);
  
  public abstract void cSA();
  
  public abstract void cSB();
  
  public abstract void cSw();
  
  public abstract void cSx();
  
  public abstract boolean cSy();
  
  public abstract void cSz();
  
  public static final class a
    extends BitmapDrawable
  {
    private a(Resources paramResources, Bitmap paramBitmap)
    {
      super(paramBitmap);
    }
    
    public static void a(Resources paramResources, Bitmap paramBitmap, ImageView paramImageView)
    {
      AppMethodBeat.i(131732);
      paramImageView.setImageDrawable(new a(paramResources, paramBitmap));
      paramImageView.postInvalidate();
      AppMethodBeat.o(131732);
    }
    
    public final void draw(Canvas paramCanvas)
    {
      AppMethodBeat.i(131733);
      if ((getBitmap() != null) && (!getBitmap().isRecycled())) {
        super.draw(paramCanvas);
      }
      AppMethodBeat.o(131733);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.d.c
 * JD-Core Version:    0.7.0.1
 */