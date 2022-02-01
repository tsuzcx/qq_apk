package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.an;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.Iterator;

public class LargeTouchableAreasItemView
  extends LinearLayout
{
  private static final int jav;
  private boolean jaA;
  private int jaB;
  private int jaC;
  private ImageButton jaD;
  private final ArrayList<b> jaw;
  private an jax;
  private a jay;
  private int jaz;
  private final Paint mPaint;
  
  static
  {
    AppMethodBeat.i(12655);
    jav = Color.argb(0, 0, 0, 0);
    AppMethodBeat.o(12655);
  }
  
  public LargeTouchableAreasItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(12650);
    this.jaw = new ArrayList();
    this.mPaint = new Paint();
    this.jaB = -1;
    this.jaC = -1;
    setOrientation(0);
    setDescendantFocusability(393216);
    this.jax = new an(this);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.jaz = ((int)(paramContext.getResources().getDisplayMetrics().density * 66.0F + 0.5F));
    LayoutInflater.from(paramContext).inflate(a.f.jeb, this);
    AppMethodBeat.o(12650);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(12653);
    Iterator localIterator = this.jaw.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      this.mPaint.setColor(localb.color);
      paramCanvas.drawRect(localb.byG, this.mPaint);
    }
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(12653);
  }
  
  public boolean getSelected()
  {
    return this.jaA;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(12651);
    super.onFinishInflate();
    this.jaD = ((ImageButton)findViewById(a.e.jcn));
    this.jaD.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(12649);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/chatroom/ui/LargeTouchableAreasItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = LargeTouchableAreasItemView.this;
        if (!LargeTouchableAreasItemView.a(LargeTouchableAreasItemView.this)) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setItemViewSelected(bool);
          if (LargeTouchableAreasItemView.b(LargeTouchableAreasItemView.this) != null)
          {
            LargeTouchableAreasItemView.b(LargeTouchableAreasItemView.this);
            LargeTouchableAreasItemView.a(LargeTouchableAreasItemView.this);
          }
          a.a(this, "com/tencent/mm/chatroom/ui/LargeTouchableAreasItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(12649);
          return;
        }
      }
    });
    AppMethodBeat.o(12651);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(12652);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = paramInt3 - paramInt1;
    paramInt2 = paramInt4 - paramInt2;
    if ((paramInt1 != this.jaB) || (paramInt2 != this.jaC))
    {
      this.jaB = paramInt1;
      this.jaC = paramInt2;
      Object localObject = this.jax;
      if (((an)localObject).Wfb != null) {
        ((an)localObject).Wfb.clear();
      }
      ((an)localObject).Wfc = null;
      localObject = new Rect(paramInt1 - this.jaD.getWidth() - this.jaz, 0, paramInt1, paramInt2);
      paramInt1 = jav;
      ImageButton localImageButton = this.jaD;
      this.jax.a(new ao((Rect)localObject, localImageButton));
      this.jaw.add(new b((Rect)localObject, paramInt1));
      setTouchDelegate(this.jax);
    }
    AppMethodBeat.o(12652);
  }
  
  public void setItemViewSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(12654);
    ImageButton localImageButton;
    if (this.jaA != paramBoolean)
    {
      this.jaA = paramBoolean;
      localImageButton = this.jaD;
      if (!this.jaA) {
        break label47;
      }
    }
    label47:
    for (int i = a.h.checkbox_selected;; i = a.d.checkbox_unselected)
    {
      localImageButton.setImageResource(i);
      AppMethodBeat.o(12654);
      return;
    }
  }
  
  public void setOnLargeTouchableAreasListener(a parama)
  {
    this.jay = parama;
  }
  
  public static abstract interface a {}
  
  static final class b
  {
    public Rect byG;
    public int color;
    
    public b(Rect paramRect, int paramInt)
    {
      this.byG = paramRect;
      this.color = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.LargeTouchableAreasItemView
 * JD-Core Version:    0.7.0.1
 */