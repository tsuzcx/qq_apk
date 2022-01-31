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
import android.view.TouchDelegate;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.Iterator;

public class LargeTouchableAreasItemView
  extends LinearLayout
{
  private static final int doX = Color.argb(0, 0, 0, 0);
  private final ArrayList<LargeTouchableAreasItemView.b> doY = new ArrayList();
  private d doZ;
  private LargeTouchableAreasItemView.a dpa;
  private int dpb;
  private boolean dpc;
  private int dpd = -1;
  private int dpe = -1;
  private ImageButton dpf;
  private final Paint mPaint = new Paint();
  
  public LargeTouchableAreasItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(0);
    setDescendantFocusability(393216);
    this.doZ = new d(this);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.dpb = ((int)(paramContext.getResources().getDisplayMetrics().density * 66.0F + 0.5F));
    LayoutInflater.from(paramContext).inflate(a.f.checkbox_large_touch_view, this);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    Iterator localIterator = this.doY.iterator();
    while (localIterator.hasNext())
    {
      LargeTouchableAreasItemView.b localb = (LargeTouchableAreasItemView.b)localIterator.next();
      this.mPaint.setColor(localb.color);
      paramCanvas.drawRect(localb.rect, this.mPaint);
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public boolean getSelected()
  {
    return this.dpc;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.dpf = ((ImageButton)findViewById(a.e.btn_select));
    this.dpf.setOnClickListener(new LargeTouchableAreasItemView.1(this));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = paramInt3 - paramInt1;
    paramInt2 = paramInt4 - paramInt2;
    if ((paramInt1 != this.dpd) || (paramInt2 != this.dpe))
    {
      this.dpd = paramInt1;
      this.dpe = paramInt2;
      Object localObject1 = this.doZ;
      if (((d)localObject1).dty != null) {
        ((d)localObject1).dty.clear();
      }
      ((d)localObject1).dtz = null;
      localObject1 = new Rect(paramInt1 - this.dpf.getWidth() - this.dpb, 0, paramInt1, paramInt2);
      paramInt1 = doX;
      Object localObject2 = this.dpf;
      d locald = this.doZ;
      localObject2 = new TouchDelegate((Rect)localObject1, (View)localObject2);
      if (locald.dty == null) {
        locald.dty = new ArrayList();
      }
      locald.dty.add(localObject2);
      this.doY.add(new LargeTouchableAreasItemView.b((Rect)localObject1, paramInt1));
      setTouchDelegate(this.doZ);
    }
  }
  
  public void setItemViewSelected(boolean paramBoolean)
  {
    ImageButton localImageButton;
    if (this.dpc != paramBoolean)
    {
      this.dpc = paramBoolean;
      localImageButton = this.dpf;
      if (!this.dpc) {
        break label35;
      }
    }
    label35:
    for (int i = a.h.checkbox_selected;; i = a.h.checkbox_unselected)
    {
      localImageButton.setImageResource(i);
      return;
    }
  }
  
  public void setOnLargeTouchableAreasListener(LargeTouchableAreasItemView.a parama)
  {
    this.dpa = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.LargeTouchableAreasItemView
 * JD-Core Version:    0.7.0.1
 */