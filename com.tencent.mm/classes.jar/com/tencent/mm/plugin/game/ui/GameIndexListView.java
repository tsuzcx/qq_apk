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
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.RecyclerView.w;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;
import com.tencent.mm.plugin.game.d.ab;
import com.tencent.mm.plugin.game.d.ah;
import com.tencent.mm.plugin.game.d.ax;
import com.tencent.mm.plugin.game.d.be;
import com.tencent.mm.plugin.game.d.bf;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public class GameIndexListView
  extends LoadMoreRecyclerView
{
  private static boolean uma = true;
  private static boolean umd;
  private static int umf = 0;
  private static int upE = 0;
  private static int upv = 0;
  private View agn;
  private Context mContext;
  private Scroller mScroller;
  private int rW;
  private float umb;
  private boolean ume;
  private ImageView umg;
  private ImageView umh;
  b upB;
  private bf upC;
  private boolean upD = true;
  
  public GameIndexListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  private void cZX()
  {
    AppMethodBeat.i(42165);
    Object localObject2 = new b.a();
    Object localObject3 = new be();
    if (this.upC != null)
    {
      localObject1 = this.upC.uib;
      ((be)localObject3).uhZ = ((com.tencent.mm.bx.b)localObject1);
      ((b.a)localObject2).hNM = ((a)localObject3);
      ((b.a)localObject2).hNN = new bf();
      ((b.a)localObject2).uri = "/cgi-bin/mmgame-bin/getgameindex4feedslist";
      ((b.a)localObject2).funcId = 2943;
      ((b.a)localObject2).hNO = 0;
      ((b.a)localObject2).respCmdId = 0;
      localObject2 = ((b.a)localObject2).aDC();
      localObject3 = new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
        {
          AppMethodBeat.i(42154);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GameIndexListView", "doCgi, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          boolean bool;
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            GameIndexListView.a(GameIndexListView.this, (bf)paramAnonymousb.hNL.hNQ);
            paramAnonymousb = GameIndexListView.b(GameIndexListView.this);
            bool = GameIndexListView.c(GameIndexListView.this);
            if ((paramAnonymousb != null) && (!bt.hj(paramAnonymousb.uia))) {
              break label177;
            }
            paramAnonymousString = null;
          }
          for (;;)
          {
            GameIndexListView.d(GameIndexListView.this);
            com.tencent.mm.plugin.game.model.ad.a(GameIndexListView.b(GameIndexListView.this));
            if (!GameIndexListView.b(GameIndexListView.this).uic) {
              GameIndexListView.this.showLoading(false);
            }
            if (!bt.hj(paramAnonymousString))
            {
              paramAnonymousb = GameIndexListView.e(GameIndexListView.this);
              paramAnonymousb.upG.addAll(paramAnonymousString);
              paramAnonymousb.asY.notifyChanged();
            }
            AppMethodBeat.o(42154);
            return 0;
            label177:
            paramAnonymousString = new LinkedList();
            if ((bool) && (!bt.isNullOrNil(paramAnonymousb.ufH)))
            {
              paramAnonymousn = new d();
              paramAnonymousn.type = 2000;
              paramAnonymousn.uaV = paramAnonymousb.ufH;
              paramAnonymousString.add(paramAnonymousn);
            }
            paramAnonymousb = paramAnonymousb.uia.iterator();
            while (paramAnonymousb.hasNext())
            {
              paramAnonymousn = (ah)paramAnonymousb.next();
              Object localObject;
              if (paramAnonymousn.ufL == 7)
              {
                if ((paramAnonymousn.ugG != null) && (!bt.hj(paramAnonymousn.ugG.ufF)))
                {
                  if (!bt.isNullOrNil(paramAnonymousn.ugG.Title))
                  {
                    localObject = new d();
                    ((d)localObject).uaW = paramAnonymousn;
                    ((d)localObject).type = 1000;
                    paramAnonymousString.add(localObject);
                  }
                  localObject = paramAnonymousn.ugG.ufF.iterator();
                  while (((Iterator)localObject).hasNext())
                  {
                    ab localab = (ab)((Iterator)localObject).next();
                    d locald = new d();
                    locald.uaW = paramAnonymousn;
                    locald.type = 1001;
                    locald.uaX = paramAnonymousn.ugG.ufF.indexOf(localab);
                    paramAnonymousString.add(locald);
                  }
                  localObject = new d();
                  ((d)localObject).uaW = paramAnonymousn;
                  ((d)localObject).type = 1002;
                  paramAnonymousString.add(localObject);
                }
              }
              else
              {
                localObject = new d();
                ((d)localObject).type = paramAnonymousn.ufL;
                ((d)localObject).position = paramAnonymousn.ufI;
                ((d)localObject).uaW = paramAnonymousn;
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
      x.a((com.tencent.mm.al.b)localObject2, (x.a)localObject3, false, (com.tencent.mm.vending.e.b)localObject1);
      AppMethodBeat.o(42165);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public static int getSourceScene()
  {
    return upv;
  }
  
  public static void setCanPulldown(boolean paramBoolean)
  {
    umd = paramBoolean;
  }
  
  public static void setDefaultPadding(int paramInt)
  {
    umf = paramInt;
  }
  
  public static void setInitPadding(int paramInt)
  {
    upE = paramInt;
    uma = true;
  }
  
  public static void setSourceScene(int paramInt)
  {
    upv = paramInt;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(42168);
    if (this.agn == null)
    {
      AppMethodBeat.o(42168);
      return;
    }
    if (this.mScroller.computeScrollOffset())
    {
      int i = this.mScroller.getCurrY();
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.GameIndexListView", "computeScroll, currY = ".concat(String.valueOf(i)));
      this.agn.setPadding(0, i, 0, 0);
      float f = (umf - i) / umf * 255.0F;
      i = (int)f;
      int j = (int)f;
      this.umh.setAlpha(255 - i);
      this.umg.setAlpha(j);
      invalidate();
    }
    AppMethodBeat.o(42168);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(42167);
    boolean bool;
    if ((!umd) || (this.agn == null))
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
          this.ume = false;
          this.umb = paramMotionEvent.getRawY();
          continue;
          if ((((LinearLayoutManager)getLayoutManager()).km() == 0) && (this.agn != null) && (this.agn.getTop() == 0)) {}
          for (i = 1; i != 0; i = 0)
          {
            if (!this.ume) {
              break label144;
            }
            AppMethodBeat.o(42167);
            return true;
          }
        }
        i = (int)(paramMotionEvent.getRawY() - this.umb);
        if (this.agn.getPaddingTop() > umf + this.rW) {
          break;
        }
      } while ((i <= 0) || (Math.abs(i) < this.rW));
      this.ume = true;
      this.mScroller.startScroll(0, this.agn.getPaddingTop(), 0, -this.agn.getPaddingTop(), 500);
      this.umg.setClickable(true);
      invalidate();
      paramMotionEvent.setAction(3);
      super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(42167);
      return true;
    } while ((this.agn.getPaddingTop() < -this.rW) || (i >= 0) || (Math.abs(i) < this.rW));
    this.ume = true;
    this.mScroller.startScroll(0, 0, 0, umf, 500);
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
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.GameIndexListView", "onFinishInflate");
    this.rW = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
    this.mScroller = new Scroller(this.mContext);
    getContext();
    setLayoutManager(new LinearLayoutManager());
    this.upB = new b();
    setAdapter(this.upB);
    a(new a(getResources()));
    setLoadingView(2131494300);
    setOnLoadingStateChangedListener(new LoadMoreRecyclerView.a()
    {
      public final void bAF()
      {
        AppMethodBeat.i(42153);
        GameIndexListView.a(GameIndexListView.this);
        AppMethodBeat.o(42153);
      }
    });
    showLoading(true);
    cZX();
    AppMethodBeat.o(42164);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(42166);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.GameIndexListView", "onLayout, changed = ".concat(String.valueOf(paramBoolean)));
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((uma) || (this.agn == null) || (this.umh == null) || (this.umg == null))
    {
      this.agn = getChildAt(0);
      if (this.agn != null)
      {
        this.agn.setPadding(0, upE, 0, 0);
        this.umh = ((ImageView)this.agn.findViewById(2131304853));
        this.umg = ((ImageView)this.agn.findViewById(2131297217));
      }
      uma = false;
    }
    AppMethodBeat.o(42166);
  }
  
  public final class a
    extends RecyclerView.h
  {
    private final Drawable amC;
    private int mSize;
    
    public a(Resources paramResources)
    {
      AppMethodBeat.i(42155);
      this.amC = new ColorDrawable(paramResources.getColor(2131100406));
      this.mSize = paramResources.getDimensionPixelSize(2131165421);
      AppMethodBeat.o(42155);
    }
    
    public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.t paramt)
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
          super.a(paramCanvas, paramRecyclerView, paramt);
        }
        for (;;)
        {
          i += 1;
          break;
          localObject = (RecyclerView.LayoutParams)localView.getLayoutParams();
          int i1 = localView.getBottom();
          i1 = ((RecyclerView.LayoutParams)localObject).bottomMargin + i1;
          int i2 = this.mSize;
          this.amC.setBounds(j, i1, k - m, i2 + i1);
          this.amC.draw(paramCanvas);
        }
      }
      AppMethodBeat.o(42156);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(42157);
      paramRect.set(0, 0, 0, this.mSize);
      AppMethodBeat.o(42157);
    }
  }
  
  public final class b
    extends RecyclerView.a<a>
  {
    LinkedList<d> upG;
    
    public b()
    {
      AppMethodBeat.i(42159);
      this.upG = new LinkedList();
      AppMethodBeat.o(42159);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(42161);
      int i = this.upG.size();
      AppMethodBeat.o(42161);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(42160);
      paramInt = ((d)this.upG.get(paramInt)).type;
      AppMethodBeat.o(42160);
      return paramInt;
    }
    
    public final class a
      extends RecyclerView.w
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameIndexListView
 * JD-Core Version:    0.7.0.1
 */