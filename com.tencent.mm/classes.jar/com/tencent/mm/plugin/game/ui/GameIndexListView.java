package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.w;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;
import com.tencent.mm.plugin.game.d.aa;
import com.tencent.mm.plugin.game.d.af;
import com.tencent.mm.plugin.game.d.au;
import com.tencent.mm.plugin.game.d.bb;
import com.tencent.mm.plugin.game.d.bc;
import com.tencent.mm.plugin.game.model.ad;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;

public class GameIndexListView
  extends LoadMoreRecyclerView
{
  private static boolean tnC = true;
  private static boolean tnF;
  private static int tnH = 0;
  private static int tqY = 0;
  private static int trh = 0;
  private View aew;
  private Context mContext;
  private Scroller mScroller;
  private int qc;
  private float tnD;
  private boolean tnG;
  private ImageView tnI;
  private ImageView tnJ;
  b tre;
  private bc trf;
  private boolean trg = true;
  
  public GameIndexListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  private void cRs()
  {
    AppMethodBeat.i(42165);
    Object localObject2 = new b.a();
    Object localObject3 = new bb();
    if (this.trf != null)
    {
      localObject1 = this.trf.tjZ;
      ((bb)localObject3).tjX = ((com.tencent.mm.bw.b)localObject1);
      ((b.a)localObject2).hvt = ((a)localObject3);
      ((b.a)localObject2).hvu = new bc();
      ((b.a)localObject2).uri = "/cgi-bin/mmgame-bin/getgameindex4feedslist";
      ((b.a)localObject2).funcId = 2943;
      ((b.a)localObject2).reqCmdId = 0;
      ((b.a)localObject2).respCmdId = 0;
      localObject2 = ((b.a)localObject2).aAz();
      localObject3 = new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
        {
          AppMethodBeat.i(42154);
          ac.i("MicroMsg.GameIndexListView", "doCgi, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          boolean bool;
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            GameIndexListView.a(GameIndexListView.this, (bc)paramAnonymousb.hvs.hvw);
            paramAnonymousb = GameIndexListView.b(GameIndexListView.this);
            bool = GameIndexListView.c(GameIndexListView.this);
            if ((paramAnonymousb != null) && (!bs.gY(paramAnonymousb.tjY))) {
              break label177;
            }
            paramAnonymousString = null;
          }
          for (;;)
          {
            GameIndexListView.d(GameIndexListView.this);
            ad.a(GameIndexListView.b(GameIndexListView.this));
            if (!GameIndexListView.b(GameIndexListView.this).tka) {
              GameIndexListView.this.showLoading(false);
            }
            if (!bs.gY(paramAnonymousString))
            {
              paramAnonymousb = GameIndexListView.e(GameIndexListView.this);
              paramAnonymousb.trj.addAll(paramAnonymousString);
              paramAnonymousb.arg.notifyChanged();
            }
            AppMethodBeat.o(42154);
            return 0;
            label177:
            paramAnonymousString = new LinkedList();
            if ((bool) && (!bs.isNullOrNil(paramAnonymousb.thQ)))
            {
              paramAnonymousn = new d();
              paramAnonymousn.type = 2000;
              paramAnonymousn.tdf = paramAnonymousb.thQ;
              paramAnonymousString.add(paramAnonymousn);
            }
            paramAnonymousb = paramAnonymousb.tjY.iterator();
            while (paramAnonymousb.hasNext())
            {
              paramAnonymousn = (af)paramAnonymousb.next();
              Object localObject;
              if (paramAnonymousn.thU == 7)
              {
                if ((paramAnonymousn.tiL != null) && (!bs.gY(paramAnonymousn.tiL.thO)))
                {
                  if (!bs.isNullOrNil(paramAnonymousn.tiL.Title))
                  {
                    localObject = new d();
                    ((d)localObject).tdg = paramAnonymousn;
                    ((d)localObject).type = 1000;
                    paramAnonymousString.add(localObject);
                  }
                  localObject = paramAnonymousn.tiL.thO.iterator();
                  while (((Iterator)localObject).hasNext())
                  {
                    aa localaa = (aa)((Iterator)localObject).next();
                    d locald = new d();
                    locald.tdg = paramAnonymousn;
                    locald.type = 1001;
                    locald.tdh = paramAnonymousn.tiL.thO.indexOf(localaa);
                    paramAnonymousString.add(locald);
                  }
                  localObject = new d();
                  ((d)localObject).tdg = paramAnonymousn;
                  ((d)localObject).type = 1002;
                  paramAnonymousString.add(localObject);
                }
              }
              else
              {
                localObject = new d();
                ((d)localObject).type = paramAnonymousn.thU;
                ((d)localObject).position = paramAnonymousn.thR;
                ((d)localObject).tdg = paramAnonymousn;
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
      x.a((com.tencent.mm.ak.b)localObject2, (x.a)localObject3, false, (com.tencent.mm.vending.e.b)localObject1);
      AppMethodBeat.o(42165);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public static int getSourceScene()
  {
    return tqY;
  }
  
  public static void setCanPulldown(boolean paramBoolean)
  {
    tnF = paramBoolean;
  }
  
  public static void setDefaultPadding(int paramInt)
  {
    tnH = paramInt;
  }
  
  public static void setInitPadding(int paramInt)
  {
    trh = paramInt;
    tnC = true;
  }
  
  public static void setSourceScene(int paramInt)
  {
    tqY = paramInt;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(42168);
    if (this.aew == null)
    {
      AppMethodBeat.o(42168);
      return;
    }
    if (this.mScroller.computeScrollOffset())
    {
      int i = this.mScroller.getCurrY();
      ac.d("MicroMsg.GameIndexListView", "computeScroll, currY = ".concat(String.valueOf(i)));
      this.aew.setPadding(0, i, 0, 0);
      float f = (tnH - i) / tnH * 255.0F;
      i = (int)f;
      int j = (int)f;
      this.tnJ.setAlpha(255 - i);
      this.tnI.setAlpha(j);
      invalidate();
    }
    AppMethodBeat.o(42168);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(42167);
    boolean bool;
    if ((!tnF) || (this.aew == null))
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
          this.tnG = false;
          this.tnD = paramMotionEvent.getRawY();
          continue;
          if ((((LinearLayoutManager)getLayoutManager()).jW() == 0) && (this.aew != null) && (this.aew.getTop() == 0)) {}
          for (i = 1; i != 0; i = 0)
          {
            if (!this.tnG) {
              break label144;
            }
            AppMethodBeat.o(42167);
            return true;
          }
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
      AppMethodBeat.o(42167);
      return true;
    } while ((this.aew.getPaddingTop() < -this.qc) || (i >= 0) || (Math.abs(i) < this.qc));
    this.tnG = true;
    this.mScroller.startScroll(0, 0, 0, tnH, 500);
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
    ac.d("MicroMsg.GameIndexListView", "onFinishInflate");
    this.qc = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
    this.mScroller = new Scroller(this.mContext);
    getContext();
    setLayoutManager(new LinearLayoutManager());
    this.tre = new b();
    setAdapter(this.tre);
    a(new GameIndexListView.a(this, getResources()));
    setLoadingView(2131494300);
    setOnLoadingStateChangedListener(new LoadMoreRecyclerView.a()
    {
      public final void bwz()
      {
        AppMethodBeat.i(42153);
        GameIndexListView.a(GameIndexListView.this);
        AppMethodBeat.o(42153);
      }
    });
    showLoading(true);
    cRs();
    AppMethodBeat.o(42164);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(42166);
    ac.d("MicroMsg.GameIndexListView", "onLayout, changed = ".concat(String.valueOf(paramBoolean)));
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((tnC) || (this.aew == null) || (this.tnJ == null) || (this.tnI == null))
    {
      this.aew = getChildAt(0);
      if (this.aew != null)
      {
        this.aew.setPadding(0, trh, 0, 0);
        this.tnJ = ((ImageView)this.aew.findViewById(2131304853));
        this.tnI = ((ImageView)this.aew.findViewById(2131297217));
      }
      tnC = false;
    }
    AppMethodBeat.o(42166);
  }
  
  public final class b
    extends RecyclerView.a<a>
  {
    LinkedList<d> trj;
    
    public b()
    {
      AppMethodBeat.i(42159);
      this.trj = new LinkedList();
      AppMethodBeat.o(42159);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(42161);
      int i = this.trj.size();
      AppMethodBeat.o(42161);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(42160);
      paramInt = ((d)this.trj.get(paramInt)).type;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameIndexListView
 * JD-Core Version:    0.7.0.1
 */