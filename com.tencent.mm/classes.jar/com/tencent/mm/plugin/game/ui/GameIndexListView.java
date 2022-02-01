package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Scroller;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;
import com.tencent.mm.plugin.game.h.b;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.model.ad;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.protobuf.aj;
import com.tencent.mm.plugin.game.protobuf.aq;
import com.tencent.mm.plugin.game.protobuf.bg;
import com.tencent.mm.plugin.game.protobuf.bn;
import com.tencent.mm.plugin.game.protobuf.bo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public class GameIndexListView
  extends LoadMoreRecyclerView
{
  private static boolean INX = true;
  private static boolean IOa;
  private static int IOc = 0;
  private static int IRA = 0;
  private static int IRr = 0;
  private float INY;
  private boolean IOb;
  private ImageView IOd;
  private ImageView IOe;
  b IRx;
  private bo IRy;
  private boolean IRz = true;
  private int doK;
  private Context mContext;
  private Scroller mScroller;
  private View nJ;
  
  public GameIndexListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  private void fDo()
  {
    AppMethodBeat.i(42165);
    Object localObject2 = new c.a();
    Object localObject3 = new bn();
    if (this.IRy != null)
    {
      localObject1 = this.IRy.IJW;
      ((bn)localObject3).IJU = ((com.tencent.mm.bx.b)localObject1);
      ((c.a)localObject2).otE = ((a)localObject3);
      ((c.a)localObject2).otF = new bo();
      ((c.a)localObject2).uri = "/cgi-bin/mmgame-bin/getgameindex4feedslist";
      ((c.a)localObject2).funcId = 2943;
      ((c.a)localObject2).otG = 0;
      ((c.a)localObject2).respCmdId = 0;
      localObject2 = ((c.a)localObject2).bEF();
      localObject3 = new z.a()
      {
        public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, c paramAnonymousc, p paramAnonymousp)
        {
          AppMethodBeat.i(42154);
          Log.i("MicroMsg.GameIndexListView", "doCgi, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          boolean bool;
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            GameIndexListView.a(GameIndexListView.this, (bo)c.c.b(paramAnonymousc.otC));
            paramAnonymousc = GameIndexListView.b(GameIndexListView.this);
            bool = GameIndexListView.c(GameIndexListView.this);
            if ((paramAnonymousc != null) && (!Util.isNullOrNil(paramAnonymousc.IJV))) {
              break label177;
            }
            paramAnonymousString = null;
          }
          for (;;)
          {
            GameIndexListView.d(GameIndexListView.this);
            ad.a(GameIndexListView.b(GameIndexListView.this));
            if (!GameIndexListView.b(GameIndexListView.this).IJX) {
              GameIndexListView.this.showLoading(false);
            }
            if (!Util.isNullOrNil(paramAnonymousString))
            {
              paramAnonymousc = GameIndexListView.e(GameIndexListView.this);
              paramAnonymousc.yaU.addAll(paramAnonymousString);
              paramAnonymousc.bZE.notifyChanged();
            }
            AppMethodBeat.o(42154);
            return 0;
            label177:
            paramAnonymousString = new LinkedList();
            if ((bool) && (!Util.isNullOrNil(paramAnonymousc.IHJ)))
            {
              paramAnonymousp = new d();
              paramAnonymousp.type = 2000;
              paramAnonymousp.ICA = paramAnonymousc.IHJ;
              paramAnonymousString.add(paramAnonymousp);
            }
            paramAnonymousc = paramAnonymousc.IJV.iterator();
            while (paramAnonymousc.hasNext())
            {
              paramAnonymousp = (aq)paramAnonymousc.next();
              Object localObject;
              if (paramAnonymousp.IHN == 7)
              {
                if ((paramAnonymousp.IIM != null) && (!Util.isNullOrNil(paramAnonymousp.IIM.IHH)))
                {
                  if (!Util.isNullOrNil(paramAnonymousp.IIM.hAP))
                  {
                    localObject = new d();
                    ((d)localObject).ICB = paramAnonymousp;
                    ((d)localObject).type = 1000;
                    paramAnonymousString.add(localObject);
                  }
                  localObject = paramAnonymousp.IIM.IHH.iterator();
                  while (((Iterator)localObject).hasNext())
                  {
                    aj localaj = (aj)((Iterator)localObject).next();
                    d locald = new d();
                    locald.ICB = paramAnonymousp;
                    locald.type = 1001;
                    locald.ICC = paramAnonymousp.IIM.IHH.indexOf(localaj);
                    paramAnonymousString.add(locald);
                  }
                  localObject = new d();
                  ((d)localObject).ICB = paramAnonymousp;
                  ((d)localObject).type = 1002;
                  paramAnonymousString.add(localObject);
                }
              }
              else
              {
                localObject = new d();
                ((d)localObject).type = paramAnonymousp.IHN;
                ((d)localObject).position = paramAnonymousp.IHK;
                ((d)localObject).ICB = paramAnonymousp;
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
      z.a((c)localObject2, (z.a)localObject3, false, (com.tencent.mm.vending.e.b)localObject1);
      AppMethodBeat.o(42165);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public static int getSourceScene()
  {
    return IRr;
  }
  
  public static void setCanPulldown(boolean paramBoolean)
  {
    IOa = paramBoolean;
  }
  
  public static void setDefaultPadding(int paramInt)
  {
    IOc = paramInt;
  }
  
  public static void setInitPadding(int paramInt)
  {
    IRA = paramInt;
    INX = true;
  }
  
  public static void setSourceScene(int paramInt)
  {
    IRr = paramInt;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(42168);
    if (this.nJ == null)
    {
      AppMethodBeat.o(42168);
      return;
    }
    if (this.mScroller.computeScrollOffset())
    {
      int i = this.mScroller.getCurrY();
      Log.d("MicroMsg.GameIndexListView", "computeScroll, currY = ".concat(String.valueOf(i)));
      this.nJ.setPadding(0, i, 0, 0);
      float f = (IOc - i) / IOc * 255.0F;
      i = (int)f;
      int j = (int)f;
      this.IOe.setAlpha(255 - i);
      this.IOd.setAlpha(j);
      invalidate();
    }
    AppMethodBeat.o(42168);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(42167);
    boolean bool;
    if ((!IOa) || (this.nJ == null))
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
          this.IOb = false;
          this.INY = paramMotionEvent.getRawY();
          continue;
          if ((((LinearLayoutManager)getLayoutManager()).Ju() == 0) && (this.nJ != null) && (this.nJ.getTop() == 0)) {}
          for (i = 1; i != 0; i = 0)
          {
            if (!this.IOb) {
              break label144;
            }
            AppMethodBeat.o(42167);
            return true;
          }
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
      AppMethodBeat.o(42167);
      return true;
    } while ((this.nJ.getPaddingTop() < -this.doK) || (i >= 0) || (Math.abs(i) < this.doK));
    this.IOb = true;
    this.mScroller.startScroll(0, 0, 0, IOc, 500);
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
    this.doK = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
    this.mScroller = new Scroller(this.mContext);
    getContext();
    setLayoutManager(new LinearLayoutManager());
    this.IRx = new b();
    setAdapter(this.IRx);
    a(new GameIndexListView.a(this, getResources(), h.b.HSI));
    setLoadingView(h.f.HZn);
    setOnLoadingStateChangedListener(new LoadMoreRecyclerView.a()
    {
      public final void onLoadMore(LoadMoreRecyclerView paramAnonymousLoadMoreRecyclerView, RecyclerView.a paramAnonymousa)
      {
        AppMethodBeat.i(276584);
        GameIndexListView.a(GameIndexListView.this);
        AppMethodBeat.o(276584);
      }
    });
    showLoading(true);
    fDo();
    AppMethodBeat.o(42164);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(42166);
    Log.d("MicroMsg.GameIndexListView", "onLayout, changed = ".concat(String.valueOf(paramBoolean)));
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((INX) || (this.nJ == null) || (this.IOe == null) || (this.IOd == null))
    {
      this.nJ = getChildAt(0);
      if (this.nJ != null)
      {
        this.nJ.setPadding(0, IRA, 0, 0);
        this.IOe = ((ImageView)this.nJ.findViewById(h.e.HXN));
        this.IOd = ((ImageView)this.nJ.findViewById(h.e.HTA));
      }
      INX = false;
    }
    AppMethodBeat.o(42166);
  }
  
  public final class b
    extends RecyclerView.a<a>
  {
    LinkedList<d> yaU;
    
    public b()
    {
      AppMethodBeat.i(42159);
      this.yaU = new LinkedList();
      AppMethodBeat.o(42159);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(42161);
      int i = this.yaU.size();
      AppMethodBeat.o(42161);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(42160);
      paramInt = ((d)this.yaU.get(paramInt)).type;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameIndexListView
 * JD-Core Version:    0.7.0.1
 */