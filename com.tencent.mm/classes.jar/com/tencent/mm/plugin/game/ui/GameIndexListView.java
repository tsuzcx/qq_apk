package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Scroller;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;
import com.tencent.mm.plugin.game.g.b;
import com.tencent.mm.plugin.game.g.c;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.model.ad;
import com.tencent.mm.plugin.game.protobuf.ai;
import com.tencent.mm.plugin.game.protobuf.ap;
import com.tencent.mm.plugin.game.protobuf.bf;
import com.tencent.mm.plugin.game.protobuf.bm;
import com.tencent.mm.plugin.game.protobuf.bn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public class GameIndexListView
  extends LoadMoreRecyclerView
{
  private static boolean CTG = true;
  private static boolean CTJ;
  private static int CTL = 0;
  private static int CXa = 0;
  private static int CXj = 0;
  private float CTH;
  private boolean CTK;
  private ImageView CTM;
  private ImageView CTN;
  b CXg;
  private bn CXh;
  private boolean CXi = true;
  private int bvH;
  private Context mContext;
  private View mL;
  private Scroller mScroller;
  
  public GameIndexListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  private void evS()
  {
    AppMethodBeat.i(42165);
    Object localObject2 = new d.a();
    Object localObject3 = new bm();
    if (this.CXh != null)
    {
      localObject1 = this.CXh.CPM;
      ((bm)localObject3).CPK = ((com.tencent.mm.cd.b)localObject1);
      ((d.a)localObject2).lBU = ((com.tencent.mm.cd.a)localObject3);
      ((d.a)localObject2).lBV = new bn();
      ((d.a)localObject2).uri = "/cgi-bin/mmgame-bin/getgameindex4feedslist";
      ((d.a)localObject2).funcId = 2943;
      ((d.a)localObject2).lBW = 0;
      ((d.a)localObject2).respCmdId = 0;
      localObject2 = ((d.a)localObject2).bgN();
      localObject3 = new aa.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.d paramAnonymousd, q paramAnonymousq)
        {
          AppMethodBeat.i(42154);
          Log.i("MicroMsg.GameIndexListView", "doCgi, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          boolean bool;
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            GameIndexListView.a(GameIndexListView.this, (bn)d.c.b(paramAnonymousd.lBS));
            paramAnonymousd = GameIndexListView.b(GameIndexListView.this);
            bool = GameIndexListView.c(GameIndexListView.this);
            if ((paramAnonymousd != null) && (!Util.isNullOrNil(paramAnonymousd.CPL))) {
              break label177;
            }
            paramAnonymousString = null;
          }
          for (;;)
          {
            GameIndexListView.d(GameIndexListView.this);
            ad.a(GameIndexListView.b(GameIndexListView.this));
            if (!GameIndexListView.b(GameIndexListView.this).CPN) {
              GameIndexListView.this.showLoading(false);
            }
            if (!Util.isNullOrNil(paramAnonymousString))
            {
              paramAnonymousd = GameIndexListView.e(GameIndexListView.this);
              paramAnonymousd.CXl.addAll(paramAnonymousString);
              paramAnonymousd.alc.notifyChanged();
            }
            AppMethodBeat.o(42154);
            return 0;
            label177:
            paramAnonymousString = new LinkedList();
            if ((bool) && (!Util.isNullOrNil(paramAnonymousd.CNB)))
            {
              paramAnonymousq = new com.tencent.mm.plugin.game.model.d();
              paramAnonymousq.type = 2000;
              paramAnonymousq.CIq = paramAnonymousd.CNB;
              paramAnonymousString.add(paramAnonymousq);
            }
            paramAnonymousd = paramAnonymousd.CPL.iterator();
            while (paramAnonymousd.hasNext())
            {
              paramAnonymousq = (ap)paramAnonymousd.next();
              Object localObject;
              if (paramAnonymousq.CNF == 7)
              {
                if ((paramAnonymousq.COC != null) && (!Util.isNullOrNil(paramAnonymousq.COC.CNz)))
                {
                  if (!Util.isNullOrNil(paramAnonymousq.COC.fwr))
                  {
                    localObject = new com.tencent.mm.plugin.game.model.d();
                    ((com.tencent.mm.plugin.game.model.d)localObject).CIr = paramAnonymousq;
                    ((com.tencent.mm.plugin.game.model.d)localObject).type = 1000;
                    paramAnonymousString.add(localObject);
                  }
                  localObject = paramAnonymousq.COC.CNz.iterator();
                  while (((Iterator)localObject).hasNext())
                  {
                    ai localai = (ai)((Iterator)localObject).next();
                    com.tencent.mm.plugin.game.model.d locald = new com.tencent.mm.plugin.game.model.d();
                    locald.CIr = paramAnonymousq;
                    locald.type = 1001;
                    locald.CIs = paramAnonymousq.COC.CNz.indexOf(localai);
                    paramAnonymousString.add(locald);
                  }
                  localObject = new com.tencent.mm.plugin.game.model.d();
                  ((com.tencent.mm.plugin.game.model.d)localObject).CIr = paramAnonymousq;
                  ((com.tencent.mm.plugin.game.model.d)localObject).type = 1002;
                  paramAnonymousString.add(localObject);
                }
              }
              else
              {
                localObject = new com.tencent.mm.plugin.game.model.d();
                ((com.tencent.mm.plugin.game.model.d)localObject).type = paramAnonymousq.CNF;
                ((com.tencent.mm.plugin.game.model.d)localObject).position = paramAnonymousq.CNC;
                ((com.tencent.mm.plugin.game.model.d)localObject).CIr = paramAnonymousq;
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
      aa.a((com.tencent.mm.an.d)localObject2, (aa.a)localObject3, false, (com.tencent.mm.vending.e.b)localObject1);
      AppMethodBeat.o(42165);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public static int getSourceScene()
  {
    return CXa;
  }
  
  public static void setCanPulldown(boolean paramBoolean)
  {
    CTJ = paramBoolean;
  }
  
  public static void setDefaultPadding(int paramInt)
  {
    CTL = paramInt;
  }
  
  public static void setInitPadding(int paramInt)
  {
    CXj = paramInt;
    CTG = true;
  }
  
  public static void setSourceScene(int paramInt)
  {
    CXa = paramInt;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(42168);
    if (this.mL == null)
    {
      AppMethodBeat.o(42168);
      return;
    }
    if (this.mScroller.computeScrollOffset())
    {
      int i = this.mScroller.getCurrY();
      Log.d("MicroMsg.GameIndexListView", "computeScroll, currY = ".concat(String.valueOf(i)));
      this.mL.setPadding(0, i, 0, 0);
      float f = (CTL - i) / CTL * 255.0F;
      i = (int)f;
      int j = (int)f;
      this.CTN.setAlpha(255 - i);
      this.CTM.setAlpha(j);
      invalidate();
    }
    AppMethodBeat.o(42168);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(42167);
    boolean bool;
    if ((!CTJ) || (this.mL == null))
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
          this.CTK = false;
          this.CTH = paramMotionEvent.getRawY();
          continue;
          if ((((LinearLayoutManager)getLayoutManager()).kJ() == 0) && (this.mL != null) && (this.mL.getTop() == 0)) {}
          for (i = 1; i != 0; i = 0)
          {
            if (!this.CTK) {
              break label144;
            }
            AppMethodBeat.o(42167);
            return true;
          }
        }
        i = (int)(paramMotionEvent.getRawY() - this.CTH);
        if (this.mL.getPaddingTop() > CTL + this.bvH) {
          break;
        }
      } while ((i <= 0) || (Math.abs(i) < this.bvH));
      this.CTK = true;
      this.mScroller.startScroll(0, this.mL.getPaddingTop(), 0, -this.mL.getPaddingTop(), 500);
      this.CTM.setClickable(true);
      invalidate();
      paramMotionEvent.setAction(3);
      super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(42167);
      return true;
    } while ((this.mL.getPaddingTop() < -this.bvH) || (i >= 0) || (Math.abs(i) < this.bvH));
    this.CTK = true;
    this.mScroller.startScroll(0, 0, 0, CTL, 500);
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
    this.bvH = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
    this.mScroller = new Scroller(this.mContext);
    getContext();
    setLayoutManager(new LinearLayoutManager());
    this.CXg = new b();
    setAdapter(this.CXg);
    a(new a(getResources(), g.b.Cgz));
    setLoadingView(g.f.Cnf);
    setOnLoadingStateChangedListener(new LoadMoreRecyclerView.a()
    {
      public final void clj()
      {
        AppMethodBeat.i(196334);
        GameIndexListView.a(GameIndexListView.this);
        AppMethodBeat.o(196334);
      }
    });
    showLoading(true);
    evS();
    AppMethodBeat.o(42164);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(42166);
    Log.d("MicroMsg.GameIndexListView", "onLayout, changed = ".concat(String.valueOf(paramBoolean)));
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((CTG) || (this.mL == null) || (this.CTN == null) || (this.CTM == null))
    {
      this.mL = getChildAt(0);
      if (this.mL != null)
      {
        this.mL.setPadding(0, CXj, 0, 0);
        this.CTN = ((ImageView)this.mL.findViewById(g.e.ClF));
        this.CTM = ((ImageView)this.mL.findViewById(g.e.Chr));
      }
      CTG = false;
    }
    AppMethodBeat.o(42166);
  }
  
  public final class a
    extends RecyclerView.h
  {
    private int mSize;
    private final Drawable sQ;
    
    public a(@androidx.annotation.a Resources paramResources, int paramInt)
    {
      AppMethodBeat.i(206449);
      this.sQ = new ColorDrawable(paramResources.getColor(paramInt));
      this.mSize = paramResources.getDimensionPixelSize(g.c.CgO);
      AppMethodBeat.o(206449);
    }
    
    public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(206452);
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
          this.sQ.setBounds(j, i1, k - m, i2 + i1);
          this.sQ.draw(paramCanvas);
        }
      }
      AppMethodBeat.o(206452);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(206453);
      paramRect.set(0, 0, 0, this.mSize);
      AppMethodBeat.o(206453);
    }
  }
  
  public final class b
    extends RecyclerView.a<a>
  {
    LinkedList<com.tencent.mm.plugin.game.model.d> CXl;
    
    public b()
    {
      AppMethodBeat.i(42159);
      this.CXl = new LinkedList();
      AppMethodBeat.o(42159);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(42161);
      int i = this.CXl.size();
      AppMethodBeat.o(42161);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(42160);
      paramInt = ((com.tencent.mm.plugin.game.model.d)this.CXl.get(paramInt)).type;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameIndexListView
 * JD-Core Version:    0.7.0.1
 */