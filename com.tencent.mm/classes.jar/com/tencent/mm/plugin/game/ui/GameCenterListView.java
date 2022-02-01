package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GameCenterListView
  extends ListView
{
  static boolean sfM;
  static int sfO;
  private View adC;
  private Context mContext;
  private Scroller mScroller;
  private int pd;
  private boolean sfJ;
  private float sfK;
  private boolean sfL;
  private boolean sfN;
  private ImageView sfP;
  private ImageView sfQ;
  
  public GameCenterListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public static void setCanPulldown(boolean paramBoolean)
  {
    sfM = paramBoolean;
  }
  
  public static void setDefaultPadding(int paramInt)
  {
    sfO = paramInt;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(41947);
    if (this.adC == null)
    {
      AppMethodBeat.o(41947);
      return;
    }
    if (this.mScroller.computeScrollOffset())
    {
      int i = this.mScroller.getCurrY();
      this.adC.setPadding(0, i, 0, 0);
      float f = (sfO - i) / sfO * 255.0F;
      i = (int)f;
      int j = (int)f;
      this.sfQ.setAlpha(255 - i);
      this.sfP.setAlpha(j);
      invalidate();
    }
    AppMethodBeat.o(41947);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(41946);
    boolean bool;
    if ((!sfM) || (this.adC == null))
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(41946);
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
            AppMethodBeat.o(41946);
            return bool;
            this.sfN = false;
            this.sfK = paramMotionEvent.getRawY();
          }
        } while (!this.sfL);
        if (this.sfN)
        {
          AppMethodBeat.o(41946);
          return true;
        }
        i = (int)(paramMotionEvent.getRawY() - this.sfK);
        if (this.adC.getPaddingTop() > sfO + this.pd) {
          break;
        }
      } while ((i <= 0) || (Math.abs(i) < this.pd));
      this.sfN = true;
      this.mScroller.startScroll(0, this.adC.getPaddingTop(), 0, -this.adC.getPaddingTop(), 500);
      this.sfP.setClickable(true);
      invalidate();
      paramMotionEvent.setAction(3);
      super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(41946);
      return true;
    } while ((this.adC.getPaddingTop() < -this.pd) || (i >= 0) || (Math.abs(i) < this.pd));
    this.sfN = true;
    this.mScroller.startScroll(0, 0, 0, sfO, 500);
    invalidate();
    paramMotionEvent.setAction(3);
    super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(41946);
    return true;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(41944);
    super.onFinishInflate();
    this.pd = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
    this.mScroller = new Scroller(this.mContext);
    super.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(41943);
        if ((paramAnonymousInt1 == 0) && (GameCenterListView.a(GameCenterListView.this) != null) && (GameCenterListView.a(GameCenterListView.this).getTop() == 0))
        {
          GameCenterListView.a(GameCenterListView.this, true);
          AppMethodBeat.o(41943);
          return;
        }
        GameCenterListView.a(GameCenterListView.this, false);
        AppMethodBeat.o(41943);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(41944);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(41945);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (!this.sfJ))
    {
      this.adC = getChildAt(0);
      this.sfQ = ((ImageView)this.adC.findViewById(2131304853));
      this.sfP = ((ImageView)this.adC.findViewById(2131297217));
      this.sfJ = true;
    }
    AppMethodBeat.o(41945);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterListView
 * JD-Core Version:    0.7.0.1
 */