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
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public class LargeTouchableAreasItemView
  extends LinearLayout
{
  private static final int fsf;
  private final ArrayList<b> fsg;
  private d fsh;
  private a fsi;
  private int fsj;
  private boolean fsk;
  private int fsl;
  private int fsm;
  private ImageButton fsn;
  private final Paint mPaint;
  
  static
  {
    AppMethodBeat.i(12655);
    fsf = Color.argb(0, 0, 0, 0);
    AppMethodBeat.o(12655);
  }
  
  public LargeTouchableAreasItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(12650);
    this.fsg = new ArrayList();
    this.mPaint = new Paint();
    this.fsl = -1;
    this.fsm = -1;
    setOrientation(0);
    setDescendantFocusability(393216);
    this.fsh = new d(this);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.fsj = ((int)(paramContext.getResources().getDisplayMetrics().density * 66.0F + 0.5F));
    LayoutInflater.from(paramContext).inflate(2131493529, this);
    AppMethodBeat.o(12650);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(12653);
    Iterator localIterator = this.fsg.iterator();
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
    return this.fsk;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(12651);
    super.onFinishInflate();
    this.fsn = ((ImageButton)findViewById(2131297595));
    this.fsn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(12649);
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
    if ((paramInt1 != this.fsl) || (paramInt2 != this.fsm))
    {
      this.fsl = paramInt1;
      this.fsm = paramInt2;
      Object localObject1 = this.fsh;
      if (((d)localObject1).fxM != null) {
        ((d)localObject1).fxM.clear();
      }
      ((d)localObject1).fxN = null;
      localObject1 = new Rect(paramInt1 - this.fsn.getWidth() - this.fsj, 0, paramInt1, paramInt2);
      paramInt1 = fsf;
      Object localObject2 = this.fsn;
      d locald = this.fsh;
      localObject2 = new TouchDelegate((Rect)localObject1, (View)localObject2);
      if (locald.fxM == null) {
        locald.fxM = new ArrayList();
      }
      locald.fxM.add(localObject2);
      this.fsg.add(new b((Rect)localObject1, paramInt1));
      setTouchDelegate(this.fsh);
    }
    AppMethodBeat.o(12652);
  }
  
  public void setItemViewSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(12654);
    ImageButton localImageButton;
    if (this.fsk != paramBoolean)
    {
      this.fsk = paramBoolean;
      localImageButton = this.fsn;
      if (!this.fsk) {
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
    this.fsi = parama;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.LargeTouchableAreasItemView
 * JD-Core Version:    0.7.0.1
 */