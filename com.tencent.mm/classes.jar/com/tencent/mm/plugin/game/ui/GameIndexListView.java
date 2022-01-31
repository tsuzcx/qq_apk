package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.w;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.game.d.bb;
import com.tencent.mm.plugin.game.d.bc;
import com.tencent.mm.sdk.platformtools.ab;

public class GameIndexListView
  extends LoadMoreRecyclerView
{
  private static boolean nwh = true;
  private static boolean nwl;
  private static int nwn = 0;
  private static int nzF = 0;
  private static int nzO = 0;
  private View Ww;
  private Context mContext;
  private Scroller mScroller;
  private float nwi;
  private int nwj;
  private boolean nwm;
  private ImageView nwo;
  private ImageView nwp;
  GameIndexListView.b nzL;
  private bc nzM;
  private boolean nzN = true;
  
  public GameIndexListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  private void bHn()
  {
    AppMethodBeat.i(111981);
    Object localObject2 = new b.a();
    Object localObject3 = new bb();
    if (this.nzM != null)
    {
      localObject1 = this.nzM.nsD;
      ((bb)localObject3).nsB = ((com.tencent.mm.bv.b)localObject1);
      ((b.a)localObject2).fsX = ((a)localObject3);
      ((b.a)localObject2).fsY = new bc();
      ((b.a)localObject2).uri = "/cgi-bin/mmgame-bin/getgameindex4feedslist";
      ((b.a)localObject2).funcId = 2943;
      ((b.a)localObject2).reqCmdId = 0;
      ((b.a)localObject2).respCmdId = 0;
      localObject2 = ((b.a)localObject2).ado();
      localObject3 = new GameIndexListView.2(this);
      if (!(this.mContext instanceof com.tencent.mm.vending.e.b)) {
        break label131;
      }
    }
    label131:
    for (Object localObject1 = (com.tencent.mm.vending.e.b)this.mContext;; localObject1 = null)
    {
      w.a((com.tencent.mm.ai.b)localObject2, (w.a)localObject3, false, (com.tencent.mm.vending.e.b)localObject1);
      AppMethodBeat.o(111981);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public static int getSourceScene()
  {
    return nzF;
  }
  
  public static void setCanPulldown(boolean paramBoolean)
  {
    nwl = paramBoolean;
  }
  
  public static void setDefaultPadding(int paramInt)
  {
    nwn = paramInt;
  }
  
  public static void setInitPadding(int paramInt)
  {
    nzO = paramInt;
    nwh = true;
  }
  
  public static void setSourceScene(int paramInt)
  {
    nzF = paramInt;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(111984);
    if (this.Ww == null)
    {
      AppMethodBeat.o(111984);
      return;
    }
    if (this.mScroller.computeScrollOffset())
    {
      int i = this.mScroller.getCurrY();
      ab.d("MicroMsg.GameIndexListView", "computeScroll, currY = ".concat(String.valueOf(i)));
      this.Ww.setPadding(0, i, 0, 0);
      float f = (nwn - i) / nwn * 255.0F;
      i = (int)f;
      int j = (int)f;
      this.nwp.setAlpha(255 - i);
      this.nwo.setAlpha(j);
      invalidate();
    }
    AppMethodBeat.o(111984);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(111983);
    boolean bool;
    if ((!nwl) || (this.Ww == null))
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(111983);
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    int i;
    label144:
    do
    {
      do
      {
        for (;;)
        {
          bool = super.dispatchTouchEvent(paramMotionEvent);
          AppMethodBeat.o(111983);
          return bool;
          this.nwm = false;
          this.nwi = paramMotionEvent.getRawY();
          continue;
          if ((((LinearLayoutManager)getLayoutManager()).it() == 0) && (this.Ww != null) && (this.Ww.getTop() == 0)) {}
          for (i = 1; i != 0; i = 0)
          {
            if (!this.nwm) {
              break label144;
            }
            AppMethodBeat.o(111983);
            return true;
          }
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
      AppMethodBeat.o(111983);
      return true;
    } while ((this.Ww.getPaddingTop() < -this.nwj) || (i >= 0) || (Math.abs(i) < this.nwj));
    this.nwm = true;
    this.mScroller.startScroll(0, 0, 0, nwn, 500);
    invalidate();
    paramMotionEvent.setAction(3);
    super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(111983);
    return true;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(111980);
    super.onFinishInflate();
    ab.d("MicroMsg.GameIndexListView", "onFinishInflate");
    this.nwj = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
    this.mScroller = new Scroller(this.mContext);
    getContext();
    setLayoutManager(new LinearLayoutManager());
    this.nzL = new GameIndexListView.b(this);
    setAdapter(this.nzL);
    b(new GameIndexListView.a(this, getResources()));
    setLoadingView(2130969746);
    setOnLoadingStateChangedListener(new GameIndexListView.1(this));
    fv(true);
    bHn();
    AppMethodBeat.o(111980);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(111982);
    ab.d("MicroMsg.GameIndexListView", "onLayout, changed = ".concat(String.valueOf(paramBoolean)));
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((nwh) || (this.Ww == null) || (this.nwp == null) || (this.nwo == null))
    {
      this.Ww = getChildAt(0);
      if (this.Ww != null)
      {
        this.Ww.setPadding(0, nzO, 0, 0);
        this.nwp = ((ImageView)this.Ww.findViewById(2131824663));
        this.nwo = ((ImageView)this.Ww.findViewById(2131824614));
      }
      nwh = false;
    }
    AppMethodBeat.o(111982);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameIndexListView
 * JD-Core Version:    0.7.0.1
 */