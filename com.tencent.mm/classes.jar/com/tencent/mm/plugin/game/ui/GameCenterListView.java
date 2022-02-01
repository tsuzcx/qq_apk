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
import com.tencent.mm.plugin.game.h.e;

public class GameCenterListView
  extends ListView
{
  static boolean IOa;
  static int IOc;
  private boolean INX;
  private float INY;
  private boolean INZ;
  private boolean IOb;
  private ImageView IOd;
  private ImageView IOe;
  private int doK;
  private Context mContext;
  private Scroller mScroller;
  private View nJ;
  
  public GameCenterListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public static void setCanPulldown(boolean paramBoolean)
  {
    IOa = paramBoolean;
  }
  
  public static void setDefaultPadding(int paramInt)
  {
    IOc = paramInt;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(41947);
    if (this.nJ == null)
    {
      AppMethodBeat.o(41947);
      return;
    }
    if (this.mScroller.computeScrollOffset())
    {
      int i = this.mScroller.getCurrY();
      this.nJ.setPadding(0, i, 0, 0);
      float f = (IOc - i) / IOc * 255.0F;
      i = (int)f;
      int j = (int)f;
      this.IOe.setAlpha(255 - i);
      this.IOd.setAlpha(j);
      invalidate();
    }
    AppMethodBeat.o(41947);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(41946);
    boolean bool;
    if ((!IOa) || (this.nJ == null))
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
            this.IOb = false;
            this.INY = paramMotionEvent.getRawY();
          }
        } while (!this.INZ);
        if (this.IOb)
        {
          AppMethodBeat.o(41946);
          return true;
        }
        i = (int)(paramMotionEvent.getRawY() - this.INY);
        if (this.nJ.getPaddingTop() > IOc + this.doK) {
          break;
        }
      } while ((i <= 0) || (Math.abs(i) < this.doK));
      this.IOb = true;
      this.mScroller.startScroll(0, this.nJ.getPaddingTop(), 0, -this.nJ.getPaddingTop(), 500);
      this.IOd.setClickable(true);
      invalidate();
      paramMotionEvent.setAction(3);
      super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(41946);
      return true;
    } while ((this.nJ.getPaddingTop() < -this.doK) || (i >= 0) || (Math.abs(i) < this.doK));
    this.IOb = true;
    this.mScroller.startScroll(0, 0, 0, IOc, 500);
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
    this.doK = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
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
    if ((paramBoolean) && (!this.INX))
    {
      this.nJ = getChildAt(0);
      this.IOe = ((ImageView)this.nJ.findViewById(h.e.HXN));
      this.IOd = ((ImageView)this.nJ.findViewById(h.e.HTA));
      this.INX = true;
    }
    AppMethodBeat.o(41945);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterListView
 * JD-Core Version:    0.7.0.1
 */