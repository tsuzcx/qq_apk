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
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.al;
import java.util.ArrayList;
import java.util.Iterator;

public class LargeTouchableAreasItemView
  extends LinearLayout
{
  private static final int gwi;
  private final ArrayList<b> gwj;
  private ak gwk;
  private a gwl;
  private int gwm;
  private boolean gwn;
  private int gwo;
  private int gwp;
  private ImageButton gwq;
  private final Paint mPaint;
  
  static
  {
    AppMethodBeat.i(12655);
    gwi = Color.argb(0, 0, 0, 0);
    AppMethodBeat.o(12655);
  }
  
  public LargeTouchableAreasItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(12650);
    this.gwj = new ArrayList();
    this.mPaint = new Paint();
    this.gwo = -1;
    this.gwp = -1;
    setOrientation(0);
    setDescendantFocusability(393216);
    this.gwk = new ak(this);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.gwm = ((int)(paramContext.getResources().getDisplayMetrics().density * 66.0F + 0.5F));
    LayoutInflater.from(paramContext).inflate(2131493641, this);
    AppMethodBeat.o(12650);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(12653);
    Iterator localIterator = this.gwj.iterator();
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
    return this.gwn;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(12651);
    super.onFinishInflate();
    this.gwq = ((ImageButton)findViewById(2131297845));
    this.gwq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(12649);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/chatroom/ui/LargeTouchableAreasItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
    if ((paramInt1 != this.gwo) || (paramInt2 != this.gwp))
    {
      this.gwo = paramInt1;
      this.gwp = paramInt2;
      Object localObject = this.gwk;
      if (((ak)localObject).OLC != null) {
        ((ak)localObject).OLC.clear();
      }
      ((ak)localObject).OLD = null;
      localObject = new Rect(paramInt1 - this.gwq.getWidth() - this.gwm, 0, paramInt1, paramInt2);
      paramInt1 = gwi;
      ImageButton localImageButton = this.gwq;
      this.gwk.a(new al((Rect)localObject, localImageButton));
      this.gwj.add(new b((Rect)localObject, paramInt1));
      setTouchDelegate(this.gwk);
    }
    AppMethodBeat.o(12652);
  }
  
  public void setItemViewSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(12654);
    ImageButton localImageButton;
    if (this.gwn != paramBoolean)
    {
      this.gwn = paramBoolean;
      localImageButton = this.gwq;
      if (!this.gwn) {
        break label46;
      }
    }
    label46:
    for (int i = 2131689951;; i = 2131231825)
    {
      localImageButton.setImageResource(i);
      AppMethodBeat.o(12654);
      return;
    }
  }
  
  public void setOnLargeTouchableAreasListener(a parama)
  {
    this.gwl = parama;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.LargeTouchableAreasItemView
 * JD-Core Version:    0.7.0.1
 */