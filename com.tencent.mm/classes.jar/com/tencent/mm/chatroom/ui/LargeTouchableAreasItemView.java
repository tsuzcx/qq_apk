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
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.ai;
import java.util.ArrayList;
import java.util.Iterator;

public class LargeTouchableAreasItemView
  extends LinearLayout
{
  private static final int fOT;
  private final ArrayList<b> fOU;
  private ah fOV;
  private a fOW;
  private int fOX;
  private boolean fOY;
  private int fOZ;
  private int fPa;
  private ImageButton fPb;
  private final Paint mPaint;
  
  static
  {
    AppMethodBeat.i(12655);
    fOT = Color.argb(0, 0, 0, 0);
    AppMethodBeat.o(12655);
  }
  
  public LargeTouchableAreasItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(12650);
    this.fOU = new ArrayList();
    this.mPaint = new Paint();
    this.fOZ = -1;
    this.fPa = -1;
    setOrientation(0);
    setDescendantFocusability(393216);
    this.fOV = new ah(this);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.fOX = ((int)(paramContext.getResources().getDisplayMetrics().density * 66.0F + 0.5F));
    LayoutInflater.from(paramContext).inflate(2131493529, this);
    AppMethodBeat.o(12650);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(12653);
    Iterator localIterator = this.fOU.iterator();
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
    return this.fOY;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(12651);
    super.onFinishInflate();
    this.fPb = ((ImageButton)findViewById(2131297595));
    this.fPb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(12649);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/chatroom/ui/LargeTouchableAreasItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
    if ((paramInt1 != this.fOZ) || (paramInt2 != this.fPa))
    {
      this.fOZ = paramInt1;
      this.fPa = paramInt2;
      Object localObject = this.fOV;
      if (((ah)localObject).Jgm != null) {
        ((ah)localObject).Jgm.clear();
      }
      ((ah)localObject).Jgn = null;
      localObject = new Rect(paramInt1 - this.fPb.getWidth() - this.fOX, 0, paramInt1, paramInt2);
      paramInt1 = fOT;
      ImageButton localImageButton = this.fPb;
      this.fOV.a(new ai((Rect)localObject, localImageButton));
      this.fOU.add(new b((Rect)localObject, paramInt1));
      setTouchDelegate(this.fOV);
    }
    AppMethodBeat.o(12652);
  }
  
  public void setItemViewSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(12654);
    ImageButton localImageButton;
    if (this.fOY != paramBoolean)
    {
      this.fOY = paramBoolean;
      localImageButton = this.fPb;
      if (!this.fOY) {
        break label46;
      }
    }
    label46:
    for (int i = 2131689936;; i = 2131231750)
    {
      localImageButton.setImageResource(i);
      AppMethodBeat.o(12654);
      return;
    }
  }
  
  public void setOnLargeTouchableAreasListener(a parama)
  {
    this.fOW = parama;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.LargeTouchableAreasItemView
 * JD-Core Version:    0.7.0.1
 */