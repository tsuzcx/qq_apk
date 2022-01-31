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
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public class LargeTouchableAreasItemView
  extends LinearLayout
{
  private static final int egt;
  private int egA;
  private ImageButton egB;
  private final ArrayList<LargeTouchableAreasItemView.b> egu;
  private d egv;
  private LargeTouchableAreasItemView.a egw;
  private int egx;
  private boolean egy;
  private int egz;
  private final Paint mPaint;
  
  static
  {
    AppMethodBeat.i(104110);
    egt = Color.argb(0, 0, 0, 0);
    AppMethodBeat.o(104110);
  }
  
  public LargeTouchableAreasItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(104105);
    this.egu = new ArrayList();
    this.mPaint = new Paint();
    this.egz = -1;
    this.egA = -1;
    setOrientation(0);
    setDescendantFocusability(393216);
    this.egv = new d(this);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.egx = ((int)(paramContext.getResources().getDisplayMetrics().density * 66.0F + 0.5F));
    LayoutInflater.from(paramContext).inflate(2130969147, this);
    AppMethodBeat.o(104105);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(104108);
    Iterator localIterator = this.egu.iterator();
    while (localIterator.hasNext())
    {
      LargeTouchableAreasItemView.b localb = (LargeTouchableAreasItemView.b)localIterator.next();
      this.mPaint.setColor(localb.color);
      paramCanvas.drawRect(localb.rect, this.mPaint);
    }
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(104108);
  }
  
  public boolean getSelected()
  {
    return this.egy;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(104106);
    super.onFinishInflate();
    this.egB = ((ImageButton)findViewById(2131822803));
    this.egB.setOnClickListener(new LargeTouchableAreasItemView.1(this));
    AppMethodBeat.o(104106);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(104107);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = paramInt3 - paramInt1;
    paramInt2 = paramInt4 - paramInt2;
    if ((paramInt1 != this.egz) || (paramInt2 != this.egA))
    {
      this.egz = paramInt1;
      this.egA = paramInt2;
      Object localObject1 = this.egv;
      if (((d)localObject1).elc != null) {
        ((d)localObject1).elc.clear();
      }
      ((d)localObject1).eld = null;
      localObject1 = new Rect(paramInt1 - this.egB.getWidth() - this.egx, 0, paramInt1, paramInt2);
      paramInt1 = egt;
      Object localObject2 = this.egB;
      d locald = this.egv;
      localObject2 = new TouchDelegate((Rect)localObject1, (View)localObject2);
      if (locald.elc == null) {
        locald.elc = new ArrayList();
      }
      locald.elc.add(localObject2);
      this.egu.add(new LargeTouchableAreasItemView.b((Rect)localObject1, paramInt1));
      setTouchDelegate(this.egv);
    }
    AppMethodBeat.o(104107);
  }
  
  public void setItemViewSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(104109);
    ImageButton localImageButton;
    if (this.egy != paramBoolean)
    {
      this.egy = paramBoolean;
      localImageButton = this.egB;
      if (!this.egy) {
        break label44;
      }
    }
    label44:
    for (int i = 2131231137;; i = 2131231142)
    {
      localImageButton.setImageResource(i);
      AppMethodBeat.o(104109);
      return;
    }
  }
  
  public void setOnLargeTouchableAreasListener(LargeTouchableAreasItemView.a parama)
  {
    this.egw = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.LargeTouchableAreasItemView
 * JD-Core Version:    0.7.0.1
 */