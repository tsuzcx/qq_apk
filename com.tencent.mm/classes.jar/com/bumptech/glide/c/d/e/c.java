package com.bumptech.glide.c.d.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.view.Gravity;
import com.bumptech.glide.b.a;
import com.bumptech.glide.c.m;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class c
  extends Drawable
  implements Animatable, g.b
{
  boolean aHT;
  final a aLT;
  private boolean aLU;
  private int aLV;
  private boolean aLW;
  private Rect aLX;
  private boolean isRunning;
  private boolean isVisible;
  private int loopCount;
  private Paint paint;
  
  public c(Context paramContext, a parama, m<Bitmap> paramm, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    this(new a(new g(com.bumptech.glide.c.ad(paramContext), parama, paramInt1, paramInt2, paramm, paramBitmap)));
    AppMethodBeat.i(77484);
    AppMethodBeat.o(77484);
  }
  
  c(a parama)
  {
    AppMethodBeat.i(77485);
    this.isVisible = true;
    this.aLV = -1;
    this.aLT = ((a)i.checkNotNull(parama, "Argument must not be null"));
    AppMethodBeat.o(77485);
  }
  
  private Paint getPaint()
  {
    AppMethodBeat.i(77499);
    if (this.paint == null) {
      this.paint = new Paint(2);
    }
    Paint localPaint = this.paint;
    AppMethodBeat.o(77499);
    return localPaint;
  }
  
  private void pF()
  {
    AppMethodBeat.i(77489);
    if (!this.aHT) {}
    for (boolean bool = true;; bool = false)
    {
      i.checkArgument(bool, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
      if (this.aLT.aLY.getFrameCount() != 1) {
        break;
      }
      invalidateSelf();
      AppMethodBeat.o(77489);
      return;
    }
    if (!this.isRunning)
    {
      this.isRunning = true;
      this.aLT.aLY.a(this);
      invalidateSelf();
    }
    AppMethodBeat.o(77489);
  }
  
  private void pG()
  {
    AppMethodBeat.i(77490);
    this.isRunning = false;
    this.aLT.aLY.b(this);
    AppMethodBeat.o(77490);
  }
  
  private Rect pH()
  {
    AppMethodBeat.i(77498);
    if (this.aLX == null) {
      this.aLX = new Rect();
    }
    Rect localRect = this.aLX;
    AppMethodBeat.o(77498);
    return localRect;
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(77495);
    if (this.aHT)
    {
      AppMethodBeat.o(77495);
      return;
    }
    if (this.aLW)
    {
      Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), pH());
      this.aLW = false;
    }
    paramCanvas.drawBitmap(this.aLT.aLY.pJ(), null, pH(), getPaint());
    AppMethodBeat.o(77495);
  }
  
  public final ByteBuffer getBuffer()
  {
    AppMethodBeat.i(77486);
    ByteBuffer localByteBuffer = this.aLT.aLY.aLZ.getData().asReadOnlyBuffer();
    AppMethodBeat.o(77486);
    return localByteBuffer;
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.aLT;
  }
  
  public int getIntrinsicHeight()
  {
    AppMethodBeat.i(77493);
    int i = this.aLT.aLY.pJ().getHeight();
    AppMethodBeat.o(77493);
    return i;
  }
  
  public int getIntrinsicWidth()
  {
    AppMethodBeat.i(77492);
    int i = this.aLT.aLY.pJ().getWidth();
    AppMethodBeat.o(77492);
    return i;
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public boolean isRunning()
  {
    return this.isRunning;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    AppMethodBeat.i(77494);
    super.onBoundsChange(paramRect);
    this.aLW = true;
    AppMethodBeat.o(77494);
  }
  
  public final Bitmap pE()
  {
    return this.aLT.aLY.aMg;
  }
  
  public final void pI()
  {
    AppMethodBeat.i(77500);
    for (Object localObject = getCallback(); (localObject instanceof Drawable); localObject = ((Drawable)localObject).getCallback()) {}
    if (localObject == null)
    {
      stop();
      invalidateSelf();
      AppMethodBeat.o(77500);
      return;
    }
    invalidateSelf();
    localObject = this.aLT.aLY;
    if (((g)localObject).aMd != null) {}
    for (int i = ((g)localObject).aMd.index;; i = -1)
    {
      if (i == this.aLT.aLY.getFrameCount() - 1) {
        this.loopCount += 1;
      }
      if ((this.aLV != -1) && (this.loopCount >= this.aLV)) {
        stop();
      }
      AppMethodBeat.o(77500);
      return;
    }
  }
  
  public void setAlpha(int paramInt)
  {
    AppMethodBeat.i(77496);
    getPaint().setAlpha(paramInt);
    AppMethodBeat.o(77496);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(77497);
    getPaint().setColorFilter(paramColorFilter);
    AppMethodBeat.o(77497);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(77491);
    boolean bool;
    if (!this.aHT)
    {
      bool = true;
      i.checkArgument(bool, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
      this.isVisible = paramBoolean1;
      if (paramBoolean1) {
        break label52;
      }
      pG();
    }
    for (;;)
    {
      paramBoolean1 = super.setVisible(paramBoolean1, paramBoolean2);
      AppMethodBeat.o(77491);
      return paramBoolean1;
      bool = false;
      break;
      label52:
      if (this.aLU) {
        pF();
      }
    }
  }
  
  public void start()
  {
    AppMethodBeat.i(77487);
    this.aLU = true;
    this.loopCount = 0;
    if (this.isVisible) {
      pF();
    }
    AppMethodBeat.o(77487);
  }
  
  public void stop()
  {
    AppMethodBeat.i(77488);
    this.aLU = false;
    pG();
    AppMethodBeat.o(77488);
  }
  
  static final class a
    extends Drawable.ConstantState
  {
    final g aLY;
    
    a(g paramg)
    {
      this.aLY = paramg;
    }
    
    public final int getChangingConfigurations()
    {
      return 0;
    }
    
    public final Drawable newDrawable()
    {
      AppMethodBeat.i(77483);
      c localc = new c(this);
      AppMethodBeat.o(77483);
      return localc;
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      AppMethodBeat.i(77482);
      paramResources = newDrawable();
      AppMethodBeat.o(77482);
      return paramResources;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.d.e.c
 * JD-Core Version:    0.7.0.1
 */