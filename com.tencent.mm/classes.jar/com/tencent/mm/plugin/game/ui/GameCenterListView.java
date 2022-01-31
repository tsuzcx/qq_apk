package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Scroller;
import com.tencent.mm.plugin.game.g.e;

public class GameCenterListView
  extends ListView
{
  static boolean kYn;
  static int kYp;
  private Scroller GB;
  private View VH;
  private boolean kYj;
  private float kYk;
  private int kYl;
  private boolean kYm;
  private boolean kYo;
  private ImageView kYq;
  private ImageView kYr;
  private Context mContext;
  
  public GameCenterListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public static void setCanPulldown(boolean paramBoolean)
  {
    kYn = paramBoolean;
  }
  
  public static void setDefaultPadding(int paramInt)
  {
    kYp = paramInt;
  }
  
  public void computeScroll()
  {
    if (this.VH == null) {}
    while (!this.GB.computeScrollOffset()) {
      return;
    }
    int i = this.GB.getCurrY();
    this.VH.setPadding(0, i, 0, 0);
    float f = (kYp - i) / kYp * 255.0F;
    i = (int)f;
    int j = (int)f;
    this.kYr.setAlpha(255 - i);
    this.kYq.setAlpha(j);
    invalidate();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!kYn) || (this.VH == null)) {
      return super.dispatchTouchEvent(paramMotionEvent);
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
            return super.dispatchTouchEvent(paramMotionEvent);
            this.kYo = false;
            this.kYk = paramMotionEvent.getRawY();
          }
        } while (!this.kYm);
        if (this.kYo) {
          return true;
        }
        i = (int)(paramMotionEvent.getRawY() - this.kYk);
        if (this.VH.getPaddingTop() > kYp + this.kYl) {
          break;
        }
      } while ((i <= 0) || (Math.abs(i) < this.kYl));
      this.kYo = true;
      this.GB.startScroll(0, this.VH.getPaddingTop(), 0, -this.VH.getPaddingTop(), 500);
      this.kYq.setClickable(true);
      invalidate();
      paramMotionEvent.setAction(3);
      super.dispatchTouchEvent(paramMotionEvent);
      return true;
    } while ((this.VH.getPaddingTop() < -this.kYl) || (i >= 0) || (Math.abs(i) < this.kYl));
    this.kYo = true;
    this.GB.startScroll(0, 0, 0, kYp, 500);
    invalidate();
    paramMotionEvent.setAction(3);
    super.dispatchTouchEvent(paramMotionEvent);
    return true;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.kYl = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
    this.GB = new Scroller(this.mContext);
    super.setOnScrollListener(new GameCenterListView.1(this));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (!this.kYj))
    {
      this.VH = getChildAt(0);
      this.kYr = ((ImageView)this.VH.findViewById(g.e.small_image));
      this.kYq = ((ImageView)this.VH.findViewById(g.e.big_image));
      this.kYj = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterListView
 * JD-Core Version:    0.7.0.1
 */