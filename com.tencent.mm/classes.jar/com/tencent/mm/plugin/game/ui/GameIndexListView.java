package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.Scroller;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.w;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.game.d.ba;
import com.tencent.mm.plugin.game.d.bb;
import com.tencent.mm.plugin.game.g.b;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.sdk.platformtools.y;

public class GameIndexListView
  extends LoadMoreRecyclerView
{
  private static boolean kYj = true;
  private static boolean kYn;
  private static int kYp = 0;
  private static int lbK = 0;
  private static int lbT = 0;
  private Scroller GB;
  private View VH;
  private float kYk;
  private int kYl;
  private boolean kYo;
  private ImageView kYq;
  private ImageView kYr;
  GameIndexListView.b lbQ;
  private bb lbR;
  private boolean lbS = true;
  private Context mContext;
  
  public GameIndexListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  private void bai()
  {
    Object localObject2 = new b.a();
    Object localObject3 = new ba();
    if (this.lbR != null)
    {
      localObject1 = this.lbR.kUB;
      ((ba)localObject3).kUz = ((com.tencent.mm.bv.b)localObject1);
      ((b.a)localObject2).ecH = ((a)localObject3);
      ((b.a)localObject2).ecI = new bb();
      ((b.a)localObject2).uri = "/cgi-bin/mmgame-bin/getgameindex4feedslist";
      ((b.a)localObject2).ecG = 2943;
      ((b.a)localObject2).ecJ = 0;
      ((b.a)localObject2).ecK = 0;
      localObject2 = ((b.a)localObject2).Kt();
      localObject3 = new GameIndexListView.2(this);
      if (!(this.mContext instanceof com.tencent.mm.vending.e.b)) {
        break label121;
      }
    }
    label121:
    for (Object localObject1 = (com.tencent.mm.vending.e.b)this.mContext;; localObject1 = null)
    {
      w.a((com.tencent.mm.ah.b)localObject2, (w.a)localObject3, false, (com.tencent.mm.vending.e.b)localObject1);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public static int getSourceScene()
  {
    return lbK;
  }
  
  public static void setCanPulldown(boolean paramBoolean)
  {
    kYn = paramBoolean;
  }
  
  public static void setDefaultPadding(int paramInt)
  {
    kYp = paramInt;
  }
  
  public static void setInitPadding(int paramInt)
  {
    lbT = paramInt;
    kYj = true;
  }
  
  public static void setSourceScene(int paramInt)
  {
    lbK = paramInt;
  }
  
  public void computeScroll()
  {
    if (this.VH == null) {}
    while (!this.GB.computeScrollOffset()) {
      return;
    }
    int i = this.GB.getCurrY();
    y.d("MicroMsg.GameIndexListView", "computeScroll, currY = " + i);
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
    label120:
    do
    {
      do
      {
        for (;;)
        {
          return super.dispatchTouchEvent(paramMotionEvent);
          this.kYo = false;
          this.kYk = paramMotionEvent.getRawY();
          continue;
          if ((((LinearLayoutManager)getLayoutManager()).gY() == 0) && (this.VH != null) && (this.VH.getTop() == 0)) {}
          for (i = 1; i != 0; i = 0)
          {
            if (!this.kYo) {
              break label120;
            }
            return true;
          }
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
    y.d("MicroMsg.GameIndexListView", "onFinishInflate");
    this.kYl = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
    this.GB = new Scroller(this.mContext);
    getContext();
    setLayoutManager(new LinearLayoutManager());
    this.lbQ = new GameIndexListView.b(this);
    setAdapter(this.lbQ);
    a(new GameIndexListView.a(this, getResources(), g.b.game_divided_line_color));
    setLoadingView(g.f.game_feed_loading_view);
    setOnLoadingStateChangedListener(new GameIndexListView.1(this));
    dZ(true);
    bai();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    y.d("MicroMsg.GameIndexListView", "onLayout, changed = " + paramBoolean);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((kYj) || (this.VH == null) || (this.kYr == null) || (this.kYq == null))
    {
      this.VH = getChildAt(0);
      if (this.VH != null)
      {
        this.VH.setPadding(0, lbT, 0, 0);
        this.kYr = ((ImageView)this.VH.findViewById(g.e.small_image));
        this.kYq = ((ImageView)this.VH.findViewById(g.e.big_image));
      }
      kYj = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameIndexListView
 * JD-Core Version:    0.7.0.1
 */