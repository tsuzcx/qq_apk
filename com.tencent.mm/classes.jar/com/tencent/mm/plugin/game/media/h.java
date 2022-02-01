package com.tencent.mm.plugin.game.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.LayoutParams;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.RecyclerView.w;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.b.b.e;
import com.tencent.mm.plugin.game.widget.GameGridLayoutManager;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.aq;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class h
  extends RecyclerView
{
  private View pNs;
  private int tXj;
  a tXk;
  private boolean tXl;
  private boolean tXm;
  private Set<Integer> tXn;
  
  public h(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(40990);
    this.tXn = new HashSet();
    this.tXj = paramInt;
    this.tXk = new a(getContext());
    getContext();
    paramContext = new GameGridLayoutManager();
    paramContext.apF = new GridLayoutManager.b()
    {
      public final int bW(int paramAnonymousInt)
      {
        AppMethodBeat.i(40976);
        paramAnonymousInt = h.a(h.this).getItemViewType(paramAnonymousInt);
        if ((paramAnonymousInt == 2147483647) || (paramAnonymousInt == 2147483646) || (paramAnonymousInt == 1) || (paramAnonymousInt == 2))
        {
          AppMethodBeat.o(40976);
          return 2;
        }
        AppMethodBeat.o(40976);
        return 1;
      }
    };
    setLayoutManager(paramContext);
    a(new b());
    this.pNs = LayoutInflater.from(getContext()).inflate(2131494300, this, false);
    this.pNs.setVisibility(8);
    paramContext = this.tXk;
    View localView = this.pNs;
    paramContext.tXq.add(localView);
    setAdapter(this.tXk);
    AppMethodBeat.o(40990);
  }
  
  public final boolean HF(int paramInt)
  {
    AppMethodBeat.i(40992);
    int i = ((LinearLayoutManager)getLayoutManager()).ko();
    if ((paramInt == 0) && (this.tXl) && (i >= this.tXk.getItemCount() - 2))
    {
      this.pNs.setVisibility(0);
      AppMethodBeat.o(40992);
      return true;
    }
    AppMethodBeat.o(40992);
    return false;
  }
  
  public final e HG(int paramInt)
  {
    AppMethodBeat.i(40993);
    e locale = this.tXk.HG(paramInt);
    AppMethodBeat.o(40993);
    return locale;
  }
  
  public final void b(LinkedList<e> paramLinkedList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(40991);
    this.tXl = paramBoolean1;
    this.tXm = paramBoolean2;
    this.pNs.setVisibility(8);
    a locala = this.tXk;
    locala.tXr.clear();
    locala.tXr.addAll(paramLinkedList);
    locala.asY.notifyChanged();
    AppMethodBeat.o(40991);
  }
  
  public final void setOnItemClickListener(com.tencent.mm.plugin.appbrand.widget.recyclerview.b paramb)
  {
    this.tXk.noT = paramb;
  }
  
  final class a
    extends RecyclerView.a<h.c>
  {
    private Context mContext;
    private ViewGroup noP;
    private ViewGroup noQ;
    com.tencent.mm.plugin.appbrand.widget.recyclerview.b noT;
    LinkedList<View> tXp;
    LinkedList<View> tXq;
    LinkedList<e> tXr;
    
    a(Context paramContext)
    {
      AppMethodBeat.i(40979);
      this.tXp = new LinkedList();
      this.tXq = new LinkedList();
      this.tXr = new LinkedList();
      this.mContext = paramContext;
      AppMethodBeat.o(40979);
    }
    
    private int BT(int paramInt)
    {
      AppMethodBeat.i(40983);
      if ((paramInt < 0) || (paramInt >= this.tXr.size()))
      {
        AppMethodBeat.o(40983);
        return paramInt;
      }
      int j = 0;
      int i = 0;
      if (j < paramInt + 1)
      {
        e locale = (e)this.tXr.get(j);
        if ((locale.tSe) || (locale.tSf)) {
          break label85;
        }
        i += 1;
      }
      label85:
      for (;;)
      {
        j += 1;
        break;
        AppMethodBeat.o(40983);
        return i;
      }
    }
    
    private void f(int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      AppMethodBeat.i(40984);
      if (h.d(h.this) == 8762) {}
      for (int i = 7;; i = 6)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("videoid", paramString2);
        com.tencent.mm.game.report.b.a.a(aj.getContext(), h.d(h.this), paramInt1, paramInt2, paramString1, com.tencent.mm.game.report.b.a.a(i, localHashMap));
        AppMethodBeat.o(40984);
        return;
      }
    }
    
    public final e HG(int paramInt)
    {
      AppMethodBeat.i(40982);
      if ((paramInt < 0) || (paramInt >= this.tXr.size()))
      {
        AppMethodBeat.o(40982);
        return null;
      }
      e locale = (e)this.tXr.get(paramInt);
      AppMethodBeat.o(40982);
      return locale;
    }
    
    public final int getItemCount()
    {
      int j = 0;
      AppMethodBeat.i(40980);
      int k = this.tXr.size();
      int i;
      if (this.tXp.isEmpty())
      {
        i = 0;
        if (!this.tXq.isEmpty()) {
          break label55;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(40980);
        return i + k + j;
        i = 1;
        break;
        label55:
        j = 1;
      }
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(40981);
      if ((paramInt < 0) || (paramInt >= getItemCount()))
      {
        AppMethodBeat.o(40981);
        return 0;
      }
      if ((paramInt == 0) && (!this.tXp.isEmpty()))
      {
        AppMethodBeat.o(40981);
        return 2147483647;
      }
      if ((paramInt == getItemCount() - 1) && (!this.tXq.isEmpty()))
      {
        AppMethodBeat.o(40981);
        return 2147483646;
      }
      if (this.tXp.isEmpty()) {}
      for (int i = 0;; i = 1)
      {
        paramInt -= i;
        if ((paramInt >= 0) && (paramInt < this.tXr.size())) {
          break;
        }
        AppMethodBeat.o(40981);
        return 0;
      }
      e locale = (e)this.tXr.get(paramInt);
      if ((locale != null) && (locale.tSe))
      {
        AppMethodBeat.o(40981);
        return 1;
      }
      if ((locale != null) && (locale.tSf))
      {
        AppMethodBeat.o(40981);
        return 2;
      }
      AppMethodBeat.o(40981);
      return 0;
    }
  }
  
  static final class b
    extends RecyclerView.h
  {
    private int mSize;
    
    public b()
    {
      AppMethodBeat.i(40987);
      this.mSize = aq.fromDPToPix(aj.getContext(), 1);
      AppMethodBeat.o(40987);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(40988);
      paramRecyclerView = (GridLayoutManager)paramRecyclerView.getLayoutManager();
      RecyclerView.bw(paramView);
      paramView = (GridLayoutManager.LayoutParams)paramView.getLayoutParams();
      int i = paramRecyclerView.apA;
      ad.i("MicroMsg.GameHaowanRecycleView", "getItemOffsets, spanSize = %d, spanCount = %d, index = %d", new Object[] { Integer.valueOf(paramView.apI), Integer.valueOf(i), Integer.valueOf(paramView.apH) });
      if (paramView.apI != i)
      {
        if (paramView.apH == 0)
        {
          paramRect.set(0, this.mSize, this.mSize, this.mSize);
          AppMethodBeat.o(40988);
          return;
        }
        paramRect.set(this.mSize, this.mSize, 0, this.mSize);
        AppMethodBeat.o(40988);
        return;
      }
      paramRect.set(0, 0, 0, 0);
      AppMethodBeat.o(40988);
    }
  }
  
  static final class c
    extends RecyclerView.w
  {
    public ImageView mwS;
    public TextView tXv;
    public TextView tXw;
    public GameVideoTagContainer tXx;
    public TextView tXy;
    public ImageView tXz;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(40989);
      this.tXv = ((TextView)paramView.findViewById(2131305821));
      this.mwS = ((ImageView)paramView.findViewById(2131306344));
      this.tXw = ((TextView)paramView.findViewById(2131299617));
      this.tXx = ((GameVideoTagContainer)paramView.findViewById(2131306397));
      this.tXy = ((TextView)paramView.findViewById(2131306405));
      this.tXz = ((ImageView)paramView.findViewById(2131300564));
      AppMethodBeat.o(40989);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.h
 * JD-Core Version:    0.7.0.1
 */