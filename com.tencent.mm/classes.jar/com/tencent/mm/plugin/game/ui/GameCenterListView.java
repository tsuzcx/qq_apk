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
  static boolean tnF;
  static int tnH;
  private View aew;
  private Context mContext;
  private Scroller mScroller;
  private int qc;
  private boolean tnC;
  private float tnD;
  private boolean tnE;
  private boolean tnG;
  private ImageView tnI;
  private ImageView tnJ;
  
  public GameCenterListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public static void setCanPulldown(boolean paramBoolean)
  {
    tnF = paramBoolean;
  }
  
  public static void setDefaultPadding(int paramInt)
  {
    tnH = paramInt;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(41947);
    if (this.aew == null)
    {
      AppMethodBeat.o(41947);
      return;
    }
    if (this.mScroller.computeScrollOffset())
    {
      int i = this.mScroller.getCurrY();
      this.aew.setPadding(0, i, 0, 0);
      float f = (tnH - i) / tnH * 255.0F;
      i = (int)f;
      int j = (int)f;
      this.tnJ.setAlpha(255 - i);
      this.tnI.setAlpha(j);
      invalidate();
    }
    AppMethodBeat.o(41947);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(41946);
    boolean bool;
    if ((!tnF) || (this.aew == null))
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
            this.tnG = false;
            this.tnD = paramMotionEvent.getRawY();
          }
        } while (!this.tnE);
        if (this.tnG)
        {
          AppMethodBeat.o(41946);
          return true;
        }
        i = (int)(paramMotionEvent.getRawY() - this.tnD);
        if (this.aew.getPaddingTop() > tnH + this.qc) {
          break;
        }
      } while ((i <= 0) || (Math.abs(i) < this.qc));
      this.tnG = true;
      this.mScroller.startScroll(0, this.aew.getPaddingTop(), 0, -this.aew.getPaddingTop(), 500);
      this.tnI.setClickable(true);
      invalidate();
      paramMotionEvent.setAction(3);
      super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(41946);
      return true;
    } while ((this.aew.getPaddingTop() < -this.qc) || (i >= 0) || (Math.abs(i) < this.qc));
    this.tnG = true;
    this.mScroller.startScroll(0, 0, 0, tnH, 500);
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
    this.qc = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
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
    if ((paramBoolean) && (!this.tnC))
    {
      this.aew = getChildAt(0);
      this.tnJ = ((ImageView)this.aew.findViewById(2131304853));
      this.tnI = ((ImageView)this.aew.findViewById(2131297217));
      this.tnC = true;
    }
    AppMethodBeat.o(41945);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterListView
 * JD-Core Version:    0.7.0.1
 */