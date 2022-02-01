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
import com.tencent.mm.ui.as;
import com.tencent.mm.ui.at;
import java.util.ArrayList;
import java.util.Iterator;

public class LargeTouchableAreasItemView
  extends LinearLayout
{
  private static final int lCq;
  private final ArrayList<b> lCr;
  private as lCs;
  private a lCt;
  private int lCu;
  private boolean lCv;
  private int lCw;
  private int lCx;
  private ImageButton lCy;
  private final Paint mPaint;
  
  static
  {
    AppMethodBeat.i(12655);
    lCq = Color.argb(0, 0, 0, 0);
    AppMethodBeat.o(12655);
  }
  
  public LargeTouchableAreasItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(12650);
    this.lCr = new ArrayList();
    this.mPaint = new Paint();
    this.lCw = -1;
    this.lCx = -1;
    setOrientation(0);
    setDescendantFocusability(393216);
    this.lCs = new as(this);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.lCu = ((int)(paramContext.getResources().getDisplayMetrics().density * 66.0F + 0.5F));
    LayoutInflater.from(paramContext).inflate(a.f.lGk, this);
    AppMethodBeat.o(12650);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(12653);
    Iterator localIterator = this.lCr.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      this.mPaint.setColor(localb.color);
      paramCanvas.drawRect(localb.rect, this.mPaint);
    }
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(12653);
  }
  
  public boolean getSelected()
  {
    return this.lCv;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(12651);
    super.onFinishInflate();
    this.lCy = ((ImageButton)findViewById(a.e.lEn));
    this.lCy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(12649);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/chatroom/ui/LargeTouchableAreasItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
    if ((paramInt1 != this.lCw) || (paramInt2 != this.lCx))
    {
      this.lCw = paramInt1;
      this.lCx = paramInt2;
      Object localObject = this.lCs;
      if (((as)localObject).adKJ != null) {
        ((as)localObject).adKJ.clear();
      }
      ((as)localObject).adKK = null;
      localObject = new Rect(paramInt1 - this.lCy.getWidth() - this.lCu, 0, paramInt1, paramInt2);
      paramInt1 = lCq;
      ImageButton localImageButton = this.lCy;
      this.lCs.a(new at((Rect)localObject, localImageButton));
      this.lCr.add(new b((Rect)localObject, paramInt1));
      setTouchDelegate(this.lCs);
    }
    AppMethodBeat.o(12652);
  }
  
  public void setItemViewSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(12654);
    ImageButton localImageButton;
    if (this.lCv != paramBoolean)
    {
      this.lCv = paramBoolean;
      localImageButton = this.lCy;
      if (!this.lCv) {
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
    this.lCt = parama;
  }
  
  public static abstract interface a {}
  
  static final class b
  {
    public int color;
    public Rect rect;
    
    public b(Rect paramRect, int paramInt)
    {
      this.rect = paramRect;
      this.color = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.LargeTouchableAreasItemView
 * JD-Core Version:    0.7.0.1
 */