package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.v;
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
import com.tencent.mm.plugin.game.d.aa;
import com.tencent.mm.plugin.game.d.af;
import com.tencent.mm.plugin.game.d.au;
import com.tencent.mm.plugin.game.d.bb;
import com.tencent.mm.plugin.game.d.bc;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public class GameIndexListView
  extends LoadMoreRecyclerView
{
  private static boolean sfJ = true;
  private static boolean sfM;
  private static int sfO = 0;
  private static int sjf = 0;
  private static int sjo = 0;
  private View adC;
  private Context mContext;
  private Scroller mScroller;
  private int pd;
  private float sfK;
  private boolean sfN;
  private ImageView sfP;
  private ImageView sfQ;
  b sjl;
  private bc sjm;
  private boolean sjn = true;
  
  public GameIndexListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  private void cEi()
  {
    AppMethodBeat.i(42165);
    Object localObject2 = new b.a();
    Object localObject3 = new bb();
    if (this.sjm != null)
    {
      localObject1 = this.sjm.scf;
      ((bb)localObject3).scd = ((com.tencent.mm.bx.b)localObject1);
      ((b.a)localObject2).gUU = ((a)localObject3);
      ((b.a)localObject2).gUV = new bc();
      ((b.a)localObject2).uri = "/cgi-bin/mmgame-bin/getgameindex4feedslist";
      ((b.a)localObject2).funcId = 2943;
      ((b.a)localObject2).reqCmdId = 0;
      ((b.a)localObject2).respCmdId = 0;
      localObject2 = ((b.a)localObject2).atI();
      localObject3 = new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
        {
          AppMethodBeat.i(42154);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GameIndexListView", "doCgi, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          boolean bool;
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            GameIndexListView.a(GameIndexListView.this, (bc)paramAnonymousb.gUT.gUX);
            paramAnonymousb = GameIndexListView.b(GameIndexListView.this);
            bool = GameIndexListView.c(GameIndexListView.this);
            if ((paramAnonymousb != null) && (!bt.gL(paramAnonymousb.sce))) {
              break label177;
            }
            paramAnonymousString = null;
          }
          for (;;)
          {
            GameIndexListView.d(GameIndexListView.this);
            com.tencent.mm.plugin.game.model.ad.a(GameIndexListView.b(GameIndexListView.this));
            if (!GameIndexListView.b(GameIndexListView.this).scg) {
              GameIndexListView.this.showLoading(false);
            }
            if (!bt.gL(paramAnonymousString))
            {
              paramAnonymousb = GameIndexListView.e(GameIndexListView.this);
              paramAnonymousb.sjq.addAll(paramAnonymousString);
              paramAnonymousb.aql.notifyChanged();
            }
            AppMethodBeat.o(42154);
            return 0;
            label177:
            paramAnonymousString = new LinkedList();
            if ((bool) && (!bt.isNullOrNil(paramAnonymousb.rZX)))
            {
              paramAnonymousn = new d();
              paramAnonymousn.type = 2000;
              paramAnonymousn.rVn = paramAnonymousb.rZX;
              paramAnonymousString.add(paramAnonymousn);
            }
            paramAnonymousb = paramAnonymousb.sce.iterator();
            while (paramAnonymousb.hasNext())
            {
              paramAnonymousn = (af)paramAnonymousb.next();
              Object localObject;
              if (paramAnonymousn.sab == 7)
              {
                if ((paramAnonymousn.saR != null) && (!bt.gL(paramAnonymousn.saR.rZV)))
                {
                  if (!bt.isNullOrNil(paramAnonymousn.saR.Title))
                  {
                    localObject = new d();
                    ((d)localObject).rVo = paramAnonymousn;
                    ((d)localObject).type = 1000;
                    paramAnonymousString.add(localObject);
                  }
                  localObject = paramAnonymousn.saR.rZV.iterator();
                  while (((Iterator)localObject).hasNext())
                  {
                    aa localaa = (aa)((Iterator)localObject).next();
                    d locald = new d();
                    locald.rVo = paramAnonymousn;
                    locald.type = 1001;
                    locald.rVp = paramAnonymousn.saR.rZV.indexOf(localaa);
                    paramAnonymousString.add(locald);
                  }
                  localObject = new d();
                  ((d)localObject).rVo = paramAnonymousn;
                  ((d)localObject).type = 1002;
                  paramAnonymousString.add(localObject);
                }
              }
              else
              {
                localObject = new d();
                ((d)localObject).type = paramAnonymousn.sab;
                ((d)localObject).position = paramAnonymousn.rZY;
                ((d)localObject).rVo = paramAnonymousn;
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
    return sjf;
  }
  
  public static void setCanPulldown(boolean paramBoolean)
  {
    sfM = paramBoolean;
  }
  
  public static void setDefaultPadding(int paramInt)
  {
    sfO = paramInt;
  }
  
  public static void setInitPadding(int paramInt)
  {
    sjo = paramInt;
    sfJ = true;
  }
  
  public static void setSourceScene(int paramInt)
  {
    sjf = paramInt;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(42168);
    if (this.adC == null)
    {
      AppMethodBeat.o(42168);
      return;
    }
    if (this.mScroller.computeScrollOffset())
    {
      int i = this.mScroller.getCurrY();
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.GameIndexListView", "computeScroll, currY = ".concat(String.valueOf(i)));
      this.adC.setPadding(0, i, 0, 0);
      float f = (sfO - i) / sfO * 255.0F;
      i = (int)f;
      int j = (int)f;
      this.sfQ.setAlpha(255 - i);
      this.sfP.setAlpha(j);
      invalidate();
    }
    AppMethodBeat.o(42168);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(42167);
    boolean bool;
    if ((!sfM) || (this.adC == null))
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
          this.sfN = false;
          this.sfK = paramMotionEvent.getRawY();
          continue;
          if ((((LinearLayoutManager)getLayoutManager()).jO() == 0) && (this.adC != null) && (this.adC.getTop() == 0)) {}
          for (i = 1; i != 0; i = 0)
          {
            if (!this.sfN) {
              break label144;
            }
            AppMethodBeat.o(42167);
            return true;
          }
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
      AppMethodBeat.o(42167);
      return true;
    } while ((this.adC.getPaddingTop() < -this.pd) || (i >= 0) || (Math.abs(i) < this.pd));
    this.sfN = true;
    this.mScroller.startScroll(0, 0, 0, sfO, 500);
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
    this.pd = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
    this.mScroller = new Scroller(this.mContext);
    getContext();
    setLayoutManager(new LinearLayoutManager());
    this.sjl = new b();
    setAdapter(this.sjl);
    a(new GameIndexListView.a(this, getResources()));
    setLoadingView(2131494300);
    setOnLoadingStateChangedListener(new LoadMoreRecyclerView.a()
    {
      public final void bpD()
      {
        AppMethodBeat.i(42153);
        GameIndexListView.a(GameIndexListView.this);
        AppMethodBeat.o(42153);
      }
    });
    showLoading(true);
    cEi();
    AppMethodBeat.o(42164);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(42166);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.GameIndexListView", "onLayout, changed = ".concat(String.valueOf(paramBoolean)));
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((sfJ) || (this.adC == null) || (this.sfQ == null) || (this.sfP == null))
    {
      this.adC = getChildAt(0);
      if (this.adC != null)
      {
        this.adC.setPadding(0, sjo, 0, 0);
        this.sfQ = ((ImageView)this.adC.findViewById(2131304853));
        this.sfP = ((ImageView)this.adC.findViewById(2131297217));
      }
      sfJ = false;
    }
    AppMethodBeat.o(42166);
  }
  
  public final class b
    extends RecyclerView.a<a>
  {
    LinkedList<d> sjq;
    
    public b()
    {
      AppMethodBeat.i(42159);
      this.sjq = new LinkedList();
      AppMethodBeat.o(42159);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(42161);
      int i = this.sjq.size();
      AppMethodBeat.o(42161);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(42160);
      paramInt = ((d)this.sjq.get(paramInt)).type;
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