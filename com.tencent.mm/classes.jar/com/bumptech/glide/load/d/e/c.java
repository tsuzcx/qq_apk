package com.bumptech.glide.load.d.e;

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
import android.support.d.a.b;
import android.view.Gravity;
import com.bumptech.glide.b.a;
import com.bumptech.glide.g.j;
import com.bumptech.glide.load.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.List;

public class c
  extends Drawable
  implements Animatable, b, g.b
{
  boolean aHN;
  final a aLL;
  private int aLM;
  private boolean aLN;
  private Rect aLO;
  private List<Object> aLP;
  private boolean isRunning;
  private boolean isStarted;
  private boolean isVisible;
  private int loopCount;
  private Paint paint;
  
  public c(Context paramContext, a parama, l<Bitmap> paraml, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    this(new a(new g(com.bumptech.glide.c.af(paramContext), parama, paramInt1, paramInt2, paraml, paramBitmap)));
    AppMethodBeat.i(77484);
    AppMethodBeat.o(77484);
  }
  
  c(a parama)
  {
    AppMethodBeat.i(77485);
    this.isVisible = true;
    this.aLM = -1;
    this.aLL = ((a)j.checkNotNull(parama, "Argument must not be null"));
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
  
  private void pK()
  {
    AppMethodBeat.i(77489);
    if (!this.aHN) {}
    for (boolean bool = true;; bool = false)
    {
      j.checkArgument(bool, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
      if (this.aLL.aLQ.getFrameCount() != 1) {
        break;
      }
      invalidateSelf();
      AppMethodBeat.o(77489);
      return;
    }
    if (!this.isRunning)
    {
      this.isRunning = true;
      this.aLL.aLQ.a(this);
      invalidateSelf();
    }
    AppMethodBeat.o(77489);
  }
  
  private void pL()
  {
    AppMethodBeat.i(77490);
    this.isRunning = false;
    this.aLL.aLQ.b(this);
    AppMethodBeat.o(77490);
  }
  
  private Rect pM()
  {
    AppMethodBeat.i(77498);
    if (this.aLO == null) {
      this.aLO = new Rect();
    }
    Rect localRect = this.aLO;
    AppMethodBeat.o(77498);
    return localRect;
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(77495);
    if (this.aHN)
    {
      AppMethodBeat.o(77495);
      return;
    }
    if (this.aLN)
    {
      Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), pM());
      this.aLN = false;
    }
    paramCanvas.drawBitmap(this.aLL.aLQ.pO(), null, pM(), getPaint());
    AppMethodBeat.o(77495);
  }
  
  public final ByteBuffer getBuffer()
  {
    AppMethodBeat.i(77486);
    ByteBuffer localByteBuffer = this.aLL.aLQ.aLR.getData().asReadOnlyBuffer();
    AppMethodBeat.o(77486);
    return localByteBuffer;
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.aLL;
  }
  
  public int getIntrinsicHeight()
  {
    AppMethodBeat.i(77493);
    int i = this.aLL.aLQ.pO().getHeight();
    AppMethodBeat.o(77493);
    return i;
  }
  
  public int getIntrinsicWidth()
  {
    AppMethodBeat.i(77492);
    int i = this.aLL.aLQ.pO().getWidth();
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
    this.aLN = true;
    AppMethodBeat.o(77494);
  }
  
  public final Bitmap pJ()
  {
    return this.aLL.aLQ.aLY;
  }
  
  public final void pN()
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
    localObject = this.aLL.aLQ;
    if (((g)localObject).aLV != null) {}
    for (int i = ((g)localObject).aLV.index;; i = -1)
    {
      if (i == this.aLL.aLQ.getFrameCount() - 1) {
        this.loopCount += 1;
      }
      if ((this.aLM == -1) || (this.loopCount < this.aLM)) {
        break label169;
      }
      if (this.aLP == null) {
        break;
      }
      i = 0;
      int j = this.aLP.size();
      while (i < j)
      {
        this.aLP.get(i);
        i += 1;
      }
    }
    stop();
    label169:
    AppMethodBeat.o(77500);
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
    if (!this.aHN)
    {
      bool = true;
      j.checkArgument(bool, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
      this.isVisible = paramBoolean1;
      if (paramBoolean1) {
        break label52;
      }
      pL();
    }
    for (;;)
    {
      paramBoolean1 = super.setVisible(paramBoolean1, paramBoolean2);
      AppMethodBeat.o(77491);
      return paramBoolean1;
      bool = false;
      break;
      label52:
      if (this.isStarted) {
        pK();
      }
    }
  }
  
  public void start()
  {
    AppMethodBeat.i(77487);
    this.isStarted = true;
    this.loopCount = 0;
    if (this.isVisible) {
      pK();
    }
    AppMethodBeat.o(77487);
  }
  
  public void stop()
  {
    AppMethodBeat.i(77488);
    this.isStarted = false;
    pL();
    AppMethodBeat.o(77488);
  }
  
  static final class a
    extends Drawable.ConstantState
  {
    final g aLQ;
    
    a(g paramg)
    {
      this.aLQ = paramg;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.d.e.c
 * JD-Core Version:    0.7.0.1
 */