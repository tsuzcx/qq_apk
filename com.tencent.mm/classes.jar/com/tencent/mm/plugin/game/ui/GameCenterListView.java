package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GameCenterListView
  extends ListView
{
  static boolean nwl;
  static int nwn;
  private View Ww;
  private Context mContext;
  private Scroller mScroller;
  private boolean nwh;
  private float nwi;
  private int nwj;
  private boolean nwk;
  private boolean nwm;
  private ImageView nwo;
  private ImageView nwp;
  
  public GameCenterListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public static void setCanPulldown(boolean paramBoolean)
  {
    nwl = paramBoolean;
  }
  
  public static void setDefaultPadding(int paramInt)
  {
    nwn = paramInt;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(111780);
    if (this.Ww == null)
    {
      AppMethodBeat.o(111780);
      return;
    }
    if (this.mScroller.computeScrollOffset())
    {
      int i = this.mScroller.getCurrY();
      this.Ww.setPadding(0, i, 0, 0);
      float f = (nwn - i) / nwn * 255.0F;
      i = (int)f;
      int j = (int)f;
      this.nwp.setAlpha(255 - i);
      this.nwo.setAlpha(j);
      invalidate();
    }
    AppMethodBeat.o(111780);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(111779);
    boolean bool;
    if ((!nwl) || (this.Ww == null))
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(111779);
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    int i;
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            bool = super.dispatchTouchEvent(paramMotionEvent);
            AppMethodBeat.o(111779);
            return bool;
            this.nwm = false;
            this.nwi = paramMotionEvent.getRawY();
          }
        } while (!this.nwk);
        if (this.nwm)
        {
          AppMethodBeat.o(111779);
          return true;
        }
        i = (int)(paramMotionEvent.getRawY() - this.nwi);
        if (this.Ww.getPaddingTop() > nwn + this.nwj) {
          break;
        }
      } while ((i <= 0) || (Math.abs(i) < this.nwj));
      this.nwm = true;
      this.mScroller.startScroll(0, this.Ww.getPaddingTop(), 0, -this.Ww.getPaddingTop(), 500);
      this.nwo.setClickable(true);
      invalidate();
      paramMotionEvent.setAction(3);
      super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(111779);
      return true;
    } while ((this.Ww.getPaddingTop() < -this.nwj) || (i >= 0) || (Math.abs(i) < this.nwj));
    this.nwm = true;
    this.mScroller.startScroll(0, 0, 0, nwn, 500);
    invalidate();
    paramMotionEvent.setAction(3);
    super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(111779);
    return true;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(111777);
    super.onFinishInflate();
    this.nwj = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
    this.mScroller = new Scroller(this.mContext);
    super.setOnScrollListener(new GameCenterListView.1(this));
    AppMethodBeat.o(111777);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(111778);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (!this.nwh))
    {
      this.Ww = getChildAt(0);
      this.nwp = ((ImageView)this.Ww.findViewById(2131824663));
      this.nwo = ((ImageView)this.Ww.findViewById(2131824614));
      this.nwh = true;
    }
    AppMethodBeat.o(111778);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterListView
 * JD-Core Version:    0.7.0.1
 */