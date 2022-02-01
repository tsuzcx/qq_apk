package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;
import com.tencent.mm.plugin.game.model.ad;
import com.tencent.mm.plugin.game.protobuf.ah;
import com.tencent.mm.plugin.game.protobuf.ao;
import com.tencent.mm.plugin.game.protobuf.be;
import com.tencent.mm.plugin.game.protobuf.bl;
import com.tencent.mm.plugin.game.protobuf.bm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public class GameIndexListView
  extends LoadMoreRecyclerView
{
  private static boolean xPA;
  private static int xPC = 0;
  private static boolean xPx;
  private static int xSP = 0;
  private static int xSY = 0;
  private View agA;
  private Context mContext;
  private Scroller mScroller;
  private int rZ;
  private boolean xPB;
  private ImageView xPD;
  private ImageView xPE;
  private float xPy;
  b xSV;
  private bm xSW;
  private boolean xSX = true;
  
  static
  {
    xPx = true;
  }
  
  public GameIndexListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  private void dWp()
  {
    AppMethodBeat.i(42165);
    Object localObject2 = new d.a();
    Object localObject3 = new bl();
    if (this.xSW != null)
    {
      localObject1 = this.xSW.xLD;
      ((bl)localObject3).xLB = ((com.tencent.mm.bw.b)localObject1);
      ((d.a)localObject2).iLN = ((a)localObject3);
      ((d.a)localObject2).iLO = new bm();
      ((d.a)localObject2).uri = "/cgi-bin/mmgame-bin/getgameindex4feedslist";
      ((d.a)localObject2).funcId = 2943;
      ((d.a)localObject2).iLP = 0;
      ((d.a)localObject2).respCmdId = 0;
      localObject2 = ((d.a)localObject2).aXF();
      localObject3 = new aa.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd, q paramAnonymousq)
        {
          AppMethodBeat.i(42154);
          Log.i("MicroMsg.GameIndexListView", "doCgi, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          boolean bool;
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            GameIndexListView.a(GameIndexListView.this, (bm)paramAnonymousd.iLL.iLR);
            paramAnonymousd = GameIndexListView.b(GameIndexListView.this);
            bool = GameIndexListView.c(GameIndexListView.this);
            if ((paramAnonymousd != null) && (!Util.isNullOrNil(paramAnonymousd.xLC))) {
              break label177;
            }
            paramAnonymousString = null;
          }
          for (;;)
          {
            GameIndexListView.d(GameIndexListView.this);
            ad.a(GameIndexListView.b(GameIndexListView.this));
            if (!GameIndexListView.b(GameIndexListView.this).xLE) {
              GameIndexListView.this.showLoading(false);
            }
            if (!Util.isNullOrNil(paramAnonymousString))
            {
              paramAnonymousd = GameIndexListView.e(GameIndexListView.this);
              paramAnonymousd.xTa.addAll(paramAnonymousString);
              paramAnonymousd.atj.notifyChanged();
            }
            AppMethodBeat.o(42154);
            return 0;
            label177:
            paramAnonymousString = new LinkedList();
            if ((bool) && (!Util.isNullOrNil(paramAnonymousd.xJu)))
            {
              paramAnonymousq = new com.tencent.mm.plugin.game.model.d();
              paramAnonymousq.type = 2000;
              paramAnonymousq.xEp = paramAnonymousd.xJu;
              paramAnonymousString.add(paramAnonymousq);
            }
            paramAnonymousd = paramAnonymousd.xLC.iterator();
            while (paramAnonymousd.hasNext())
            {
              paramAnonymousq = (ao)paramAnonymousd.next();
              Object localObject;
              if (paramAnonymousq.xJy == 7)
              {
                if ((paramAnonymousq.xKv != null) && (!Util.isNullOrNil(paramAnonymousq.xKv.xJs)))
                {
                  if (!Util.isNullOrNil(paramAnonymousq.xKv.Title))
                  {
                    localObject = new com.tencent.mm.plugin.game.model.d();
                    ((com.tencent.mm.plugin.game.model.d)localObject).xEq = paramAnonymousq;
                    ((com.tencent.mm.plugin.game.model.d)localObject).type = 1000;
                    paramAnonymousString.add(localObject);
                  }
                  localObject = paramAnonymousq.xKv.xJs.iterator();
                  while (((Iterator)localObject).hasNext())
                  {
                    ah localah = (ah)((Iterator)localObject).next();
                    com.tencent.mm.plugin.game.model.d locald = new com.tencent.mm.plugin.game.model.d();
                    locald.xEq = paramAnonymousq;
                    locald.type = 1001;
                    locald.xEr = paramAnonymousq.xKv.xJs.indexOf(localah);
                    paramAnonymousString.add(locald);
                  }
                  localObject = new com.tencent.mm.plugin.game.model.d();
                  ((com.tencent.mm.plugin.game.model.d)localObject).xEq = paramAnonymousq;
                  ((com.tencent.mm.plugin.game.model.d)localObject).type = 1002;
                  paramAnonymousString.add(localObject);
                }
              }
              else
              {
                localObject = new com.tencent.mm.plugin.game.model.d();
                ((com.tencent.mm.plugin.game.model.d)localObject).type = paramAnonymousq.xJy;
                ((com.tencent.mm.plugin.game.model.d)localObject).position = paramAnonymousq.xJv;
                ((com.tencent.mm.plugin.game.model.d)localObject).xEq = paramAnonymousq;
                paramAnonymousString.add(localObject);
              }
            }
          }
        }
      };
      if (!(this.mContext instanceof com.tencent.mm.vending.e.b)) {
        break label131;
      }
    }
    label131:
    for (Object localObject1 = (com.tencent.mm.vending.e.b)this.mContext;; localObject1 = null)
    {
      aa.a((com.tencent.mm.ak.d)localObject2, (aa.a)localObject3, false, (com.tencent.mm.vending.e.b)localObject1);
      AppMethodBeat.o(42165);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public static int getSourceScene()
  {
    return xSP;
  }
  
  public static void setCanPulldown(boolean paramBoolean)
  {
    xPA = paramBoolean;
  }
  
  public static void setDefaultPadding(int paramInt)
  {
    xPC = paramInt;
  }
  
  public static void setInitPadding(int paramInt)
  {
    xSY = paramInt;
    xPx = true;
  }
  
  public static void setSourceScene(int paramInt)
  {
    xSP = paramInt;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(42168);
    if (this.agA == null)
    {
      AppMethodBeat.o(42168);
      return;
    }
    if (this.mScroller.computeScrollOffset())
    {
      int i = this.mScroller.getCurrY();
      Log.d("MicroMsg.GameIndexListView", "computeScroll, currY = ".concat(String.valueOf(i)));
      this.agA.setPadding(0, i, 0, 0);
      float f = (xPC - i) / xPC * 255.0F;
      i = (int)f;
      int j = (int)f;
      this.xPE.setAlpha(255 - i);
      this.xPD.setAlpha(j);
      invalidate();
    }
    AppMethodBeat.o(42168);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(42167);
    boolean bool;
    if ((!xPA) || (this.agA == null))
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(42167);
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
          AppMethodBeat.o(42167);
          return bool;
          this.xPB = false;
          this.xPy = paramMotionEvent.getRawY();
          continue;
          if ((((LinearLayoutManager)getLayoutManager()).ks() == 0) && (this.agA != null) && (this.agA.getTop() == 0)) {}
          for (i = 1; i != 0; i = 0)
          {
            if (!this.xPB) {
              break label144;
            }
            AppMethodBeat.o(42167);
            return true;
          }
        }
        i = (int)(paramMotionEvent.getRawY() - this.xPy);
        if (this.agA.getPaddingTop() > xPC + this.rZ) {
          break;
        }
      } while ((i <= 0) || (Math.abs(i) < this.rZ));
      this.xPB = true;
      this.mScroller.startScroll(0, this.agA.getPaddingTop(), 0, -this.agA.getPaddingTop(), 500);
      this.xPD.setClickable(true);
      invalidate();
      paramMotionEvent.setAction(3);
      super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(42167);
      return true;
    } while ((this.agA.getPaddingTop() < -this.rZ) || (i >= 0) || (Math.abs(i) < this.rZ));
    this.xPB = true;
    this.mScroller.startScroll(0, 0, 0, xPC, 500);
    invalidate();
    paramMotionEvent.setAction(3);
    super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(42167);
    return true;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42164);
    super.onFinishInflate();
    Log.d("MicroMsg.GameIndexListView", "onFinishInflate");
    this.rZ = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
    this.mScroller = new Scroller(this.mContext);
    getContext();
    setLayoutManager(new LinearLayoutManager());
    this.xSV = new b();
    setAdapter(this.xSV);
    a(new a(getResources()));
    setLoadingView(2131494862);
    setOnLoadingStateChangedListener(new LoadMoreRecyclerView.a()
    {
      public final void bYy()
      {
        AppMethodBeat.i(42153);
        GameIndexListView.a(GameIndexListView.this);
        AppMethodBeat.o(42153);
      }
    });
    showLoading(true);
    dWp();
    AppMethodBeat.o(42164);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(42166);
    Log.d("MicroMsg.GameIndexListView", "onLayout, changed = ".concat(String.valueOf(paramBoolean)));
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((xPx) || (this.agA == null) || (this.xPE == null) || (this.xPD == null))
    {
      this.agA = getChildAt(0);
      if (this.agA != null)
      {
        this.agA.setPadding(0, xSY, 0, 0);
        this.xPE = ((ImageView)this.agA.findViewById(2131307939));
        this.xPD = ((ImageView)this.agA.findViewById(2131297372));
      }
      xPx = false;
    }
    AppMethodBeat.o(42166);
  }
  
  public final class a
    extends RecyclerView.h
  {
    private final Drawable amP;
    private int mSize;
    
    public a(Resources paramResources)
    {
      AppMethodBeat.i(42155);
      this.amP = new ColorDrawable(paramResources.getColor(2131100508));
      this.mSize = paramResources.getDimensionPixelSize(2131165433);
      AppMethodBeat.o(42155);
    }
    
    public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(42156);
      int j = paramRecyclerView.getPaddingLeft();
      int k = paramRecyclerView.getWidth();
      int m = paramRecyclerView.getPaddingRight();
      int n = paramRecyclerView.getChildCount();
      int i = 0;
      if (i < n - 1)
      {
        View localView = paramRecyclerView.getChildAt(i);
        Object localObject = ((ViewGroup)localView).getChildAt(0);
        if (((localObject instanceof GameBestSellingItemView)) || ((localObject instanceof GameBestSellingTitle)) || ((localObject instanceof GameFeedModuleTitle))) {
          super.a(paramCanvas, paramRecyclerView, params);
        }
        for (;;)
        {
          i += 1;
          break;
          localObject = (RecyclerView.LayoutParams)localView.getLayoutParams();
          int i1 = localView.getBottom();
          i1 = ((RecyclerView.LayoutParams)localObject).bottomMargin + i1;
          int i2 = this.mSize;
          this.amP.setBounds(j, i1, k - m, i2 + i1);
          this.amP.draw(paramCanvas);
        }
      }
      AppMethodBeat.o(42156);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(42157);
      paramRect.set(0, 0, 0, this.mSize);
      AppMethodBeat.o(42157);
    }
  }
  
  public final class b
    extends RecyclerView.a<a>
  {
    LinkedList<com.tencent.mm.plugin.game.model.d> xTa;
    
    public b()
    {
      AppMethodBeat.i(42159);
      this.xTa = new LinkedList();
      AppMethodBeat.o(42159);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(42161);
      int i = this.xTa.size();
      AppMethodBeat.o(42161);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(42160);
      paramInt = ((com.tencent.mm.plugin.game.model.d)this.xTa.get(paramInt)).type;
      AppMethodBeat.o(42160);
      return paramInt;
    }
    
    public final class a
      extends RecyclerView.v
    {
      public View contentView;
      
      public a(View paramView)
      {
        super();
        AppMethodBeat.i(42158);
        this.contentView = ((ViewGroup)paramView).getChildAt(0);
        AppMethodBeat.o(42158);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameIndexListView
 * JD-Core Version:    0.7.0.1
 */