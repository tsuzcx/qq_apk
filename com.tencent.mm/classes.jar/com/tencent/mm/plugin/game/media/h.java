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
import com.tencent.mm.game.report.b.a;
import com.tencent.mm.plugin.game.b.b.e;
import com.tencent.mm.plugin.game.widget.GameGridLayoutManager;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.ao;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class h
  extends RecyclerView
{
  private View pjS;
  private int sZs;
  a sZt;
  private boolean sZu;
  private boolean sZv;
  private Set<Integer> sZw;
  
  public h(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(40990);
    this.sZw = new HashSet();
    this.sZs = paramInt;
    this.sZt = new a(getContext());
    getContext();
    paramContext = new GameGridLayoutManager();
    paramContext.anN = new GridLayoutManager.b()
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
    this.pjS = LayoutInflater.from(getContext()).inflate(2131494300, this, false);
    this.pjS.setVisibility(8);
    paramContext = this.sZt;
    View localView = this.pjS;
    paramContext.sZz.add(localView);
    setAdapter(this.sZt);
    AppMethodBeat.o(40990);
  }
  
  public final boolean Gl(int paramInt)
  {
    AppMethodBeat.i(40992);
    int i = ((LinearLayoutManager)getLayoutManager()).jY();
    if ((paramInt == 0) && (this.sZu) && (i >= this.sZt.getItemCount() - 2))
    {
      this.pjS.setVisibility(0);
      AppMethodBeat.o(40992);
      return true;
    }
    AppMethodBeat.o(40992);
    return false;
  }
  
  public final e Gm(int paramInt)
  {
    AppMethodBeat.i(40993);
    e locale = this.sZt.Gm(paramInt);
    AppMethodBeat.o(40993);
    return locale;
  }
  
  public final void b(LinkedList<e> paramLinkedList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(40991);
    this.sZu = paramBoolean1;
    this.sZv = paramBoolean2;
    this.pjS.setVisibility(8);
    a locala = this.sZt;
    locala.sZA.clear();
    locala.sZA.addAll(paramLinkedList);
    locala.arg.notifyChanged();
    AppMethodBeat.o(40991);
  }
  
  public final void setOnItemClickListener(com.tencent.mm.plugin.appbrand.widget.recyclerview.b paramb)
  {
    this.sZt.mOw = paramb;
  }
  
  final class a
    extends RecyclerView.a<h.c>
  {
    private Context mContext;
    private ViewGroup mOs;
    private ViewGroup mOt;
    com.tencent.mm.plugin.appbrand.widget.recyclerview.b mOw;
    LinkedList<e> sZA;
    LinkedList<View> sZy;
    LinkedList<View> sZz;
    
    a(Context paramContext)
    {
      AppMethodBeat.i(40979);
      this.sZy = new LinkedList();
      this.sZz = new LinkedList();
      this.sZA = new LinkedList();
      this.mContext = paramContext;
      AppMethodBeat.o(40979);
    }
    
    private int Bl(int paramInt)
    {
      AppMethodBeat.i(40983);
      if ((paramInt < 0) || (paramInt >= this.sZA.size()))
      {
        AppMethodBeat.o(40983);
        return paramInt;
      }
      int j = 0;
      int i = 0;
      if (j < paramInt + 1)
      {
        e locale = (e)this.sZA.get(j);
        if ((locale.sVz) || (locale.sVA)) {
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
        a.a(ai.getContext(), h.d(h.this), paramInt1, paramInt2, paramString1, a.a(i, localHashMap));
        AppMethodBeat.o(40984);
        return;
      }
    }
    
    public final e Gm(int paramInt)
    {
      AppMethodBeat.i(40982);
      if ((paramInt < 0) || (paramInt >= this.sZA.size()))
      {
        AppMethodBeat.o(40982);
        return null;
      }
      e locale = (e)this.sZA.get(paramInt);
      AppMethodBeat.o(40982);
      return locale;
    }
    
    public final int getItemCount()
    {
      int j = 0;
      AppMethodBeat.i(40980);
      int k = this.sZA.size();
      int i;
      if (this.sZy.isEmpty())
      {
        i = 0;
        if (!this.sZz.isEmpty()) {
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
      if ((paramInt == 0) && (!this.sZy.isEmpty()))
      {
        AppMethodBeat.o(40981);
        return 2147483647;
      }
      if ((paramInt == getItemCount() - 1) && (!this.sZz.isEmpty()))
      {
        AppMethodBeat.o(40981);
        return 2147483646;
      }
      if (this.sZy.isEmpty()) {}
      for (int i = 0;; i = 1)
      {
        paramInt -= i;
        if ((paramInt >= 0) && (paramInt < this.sZA.size())) {
          break;
        }
        AppMethodBeat.o(40981);
        return 0;
      }
      e locale = (e)this.sZA.get(paramInt);
      if ((locale != null) && (locale.sVz))
      {
        AppMethodBeat.o(40981);
        return 1;
      }
      if ((locale != null) && (locale.sVA))
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
      this.mSize = ao.fromDPToPix(ai.getContext(), 1);
      AppMethodBeat.o(40987);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(40988);
      paramRecyclerView = (GridLayoutManager)paramRecyclerView.getLayoutManager();
      RecyclerView.bw(paramView);
      paramView = (GridLayoutManager.LayoutParams)paramView.getLayoutParams();
      int i = paramRecyclerView.anI;
      ac.i("MicroMsg.GameHaowanRecycleView", "getItemOffsets, spanSize = %d, spanCount = %d, index = %d", new Object[] { Integer.valueOf(paramView.anQ), Integer.valueOf(i), Integer.valueOf(paramView.anP) });
      if (paramView.anQ != i)
      {
        if (paramView.anP == 0)
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
    public ImageView lXd;
    public TextView sZE;
    public TextView sZF;
    public GameVideoTagContainer sZG;
    public TextView sZH;
    public ImageView sZI;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(40989);
      this.sZE = ((TextView)paramView.findViewById(2131305821));
      this.lXd = ((ImageView)paramView.findViewById(2131306344));
      this.sZF = ((TextView)paramView.findViewById(2131299617));
      this.sZG = ((GameVideoTagContainer)paramView.findViewById(2131306397));
      this.sZH = ((TextView)paramView.findViewById(2131306405));
      this.sZI = ((ImageView)paramView.findViewById(2131300564));
      AppMethodBeat.o(40989);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.h
 * JD-Core Version:    0.7.0.1
 */