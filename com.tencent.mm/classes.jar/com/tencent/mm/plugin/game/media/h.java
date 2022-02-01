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
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.b.b.e;
import com.tencent.mm.plugin.game.widget.GameGridLayoutManager;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.at;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class h
  extends RecyclerView
{
  private View rkW;
  private int xAC;
  private int xAD;
  a xAE;
  private boolean xAF;
  private boolean xAG;
  private Set<Integer> xAH;
  
  public h(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    AppMethodBeat.i(204112);
    this.xAH = new HashSet();
    this.xAC = paramInt1;
    this.xAD = paramInt2;
    this.xAE = new a(getContext());
    getContext();
    paramContext = new GameGridLayoutManager();
    paramContext.apR = new GridLayoutManager.b()
    {
      public final int bX(int paramAnonymousInt)
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
    this.rkW = LayoutInflater.from(getContext()).inflate(2131494862, this, false);
    this.rkW.setVisibility(8);
    paramContext = this.xAE;
    View localView = this.rkW;
    paramContext.xAK.add(localView);
    setAdapter(this.xAE);
    AppMethodBeat.o(204112);
  }
  
  public final boolean Of(int paramInt)
  {
    AppMethodBeat.i(40992);
    int i = ((LinearLayoutManager)getLayoutManager()).ku();
    if ((paramInt == 0) && (this.xAF) && (i >= this.xAE.getItemCount() - 2))
    {
      this.rkW.setVisibility(0);
      AppMethodBeat.o(40992);
      return true;
    }
    AppMethodBeat.o(40992);
    return false;
  }
  
  public final e Og(int paramInt)
  {
    AppMethodBeat.i(40993);
    e locale = this.xAE.Og(paramInt);
    AppMethodBeat.o(40993);
    return locale;
  }
  
  public final void b(LinkedList<e> paramLinkedList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(40991);
    this.xAF = paramBoolean1;
    this.xAG = paramBoolean2;
    this.rkW.setVisibility(8);
    a locala = this.xAE;
    locala.xAL.clear();
    locala.xAL.addAll(paramLinkedList);
    locala.atj.notifyChanged();
    AppMethodBeat.o(40991);
  }
  
  public final void setOnItemClickListener(com.tencent.mm.plugin.appbrand.widget.recyclerview.b paramb)
  {
    this.xAE.oEh = paramb;
  }
  
  final class a
    extends RecyclerView.a<h.c>
  {
    private Context mContext;
    private ViewGroup oEd;
    private ViewGroup oEe;
    com.tencent.mm.plugin.appbrand.widget.recyclerview.b oEh;
    LinkedList<View> xAJ;
    LinkedList<View> xAK;
    LinkedList<e> xAL;
    
    a(Context paramContext)
    {
      AppMethodBeat.i(40979);
      this.xAJ = new LinkedList();
      this.xAK = new LinkedList();
      this.xAL = new LinkedList();
      this.mContext = paramContext;
      AppMethodBeat.o(40979);
    }
    
    private int FO(int paramInt)
    {
      AppMethodBeat.i(40983);
      if ((paramInt < 0) || (paramInt >= this.xAL.size()))
      {
        AppMethodBeat.o(40983);
        return paramInt;
      }
      int j = 0;
      int i = 0;
      if (j < paramInt + 1)
      {
        e locale = (e)this.xAL.get(j);
        if ((locale.xuJ) || (locale.xuK)) {
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
    
    private void e(int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      AppMethodBeat.i(40984);
      if (h.d(h.this) == 8762) {}
      for (int i = 7;; i = 6)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("videoid", paramString2);
        com.tencent.mm.game.report.b.a.a(MMApplicationContext.getContext(), h.d(h.this), paramInt1, paramInt2, paramString1, h.e(h.this), com.tencent.mm.game.report.b.a.c(i, localHashMap));
        AppMethodBeat.o(40984);
        return;
      }
    }
    
    public final e Og(int paramInt)
    {
      AppMethodBeat.i(40982);
      if ((paramInt < 0) || (paramInt >= this.xAL.size()))
      {
        AppMethodBeat.o(40982);
        return null;
      }
      e locale = (e)this.xAL.get(paramInt);
      AppMethodBeat.o(40982);
      return locale;
    }
    
    public final int getItemCount()
    {
      int j = 0;
      AppMethodBeat.i(40980);
      int k = this.xAL.size();
      int i;
      if (this.xAJ.isEmpty())
      {
        i = 0;
        if (!this.xAK.isEmpty()) {
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
      if ((paramInt == 0) && (!this.xAJ.isEmpty()))
      {
        AppMethodBeat.o(40981);
        return 2147483647;
      }
      if ((paramInt == getItemCount() - 1) && (!this.xAK.isEmpty()))
      {
        AppMethodBeat.o(40981);
        return 2147483646;
      }
      if (this.xAJ.isEmpty()) {}
      for (int i = 0;; i = 1)
      {
        paramInt -= i;
        if ((paramInt >= 0) && (paramInt < this.xAL.size())) {
          break;
        }
        AppMethodBeat.o(40981);
        return 0;
      }
      e locale = (e)this.xAL.get(paramInt);
      if ((locale != null) && (locale.xuJ))
      {
        AppMethodBeat.o(40981);
        return 1;
      }
      if ((locale != null) && (locale.xuK))
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
      this.mSize = at.fromDPToPix(MMApplicationContext.getContext(), 1);
      AppMethodBeat.o(40987);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(40988);
      paramRecyclerView = (GridLayoutManager)paramRecyclerView.getLayoutManager();
      RecyclerView.bw(paramView);
      paramView = (GridLayoutManager.LayoutParams)paramView.getLayoutParams();
      int i = paramRecyclerView.apM;
      Log.i("MicroMsg.GameHaowanRecycleView", "getItemOffsets, spanSize = %d, spanCount = %d, index = %d", new Object[] { Integer.valueOf(paramView.apU), Integer.valueOf(i), Integer.valueOf(paramView.apT) });
      if (paramView.apU != i)
      {
        if (paramView.apT == 0)
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
    extends RecyclerView.v
  {
    public ImageView nNv;
    public TextView xAP;
    public TextView xAQ;
    public GameVideoTagContainer xAR;
    public TextView xAS;
    public ImageView xAT;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(40989);
      this.xAP = ((TextView)paramView.findViewById(2131309100));
      this.nNv = ((ImageView)paramView.findViewById(2131309770));
      this.xAQ = ((TextView)paramView.findViewById(2131300251));
      this.xAR = ((GameVideoTagContainer)paramView.findViewById(2131309828));
      this.xAS = ((TextView)paramView.findViewById(2131309836));
      this.xAT = ((ImageView)paramView.findViewById(2131302096));
      AppMethodBeat.o(40989);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.h
 * JD-Core Version:    0.7.0.1
 */