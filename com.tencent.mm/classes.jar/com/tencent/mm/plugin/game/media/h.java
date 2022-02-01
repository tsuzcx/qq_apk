package com.tencent.mm.plugin.game.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.LayoutParams;
import androidx.recyclerview.widget.GridLayoutManager.b;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.autogen.b.e;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.widget.GameGridLayoutManager;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class h
  extends RecyclerView
{
  private int CED;
  private int CEE;
  a CEF;
  private boolean CEG;
  private boolean CEH;
  private Set<Integer> CEI;
  private View uOi;
  
  public h(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    AppMethodBeat.i(202099);
    this.CEI = new HashSet();
    this.CED = paramInt1;
    this.CEE = paramInt2;
    this.CEF = new a(getContext());
    getContext();
    paramContext = new GameGridLayoutManager();
    paramContext.ahK = new GridLayoutManager.b()
    {
      public final int cx(int paramAnonymousInt)
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
    this.uOi = LayoutInflater.from(getContext()).inflate(g.f.Cnf, this, false);
    this.uOi.setVisibility(8);
    paramContext = this.CEF;
    View localView = this.uOi;
    paramContext.CEL.add(localView);
    setAdapter(this.CEF);
    AppMethodBeat.o(202099);
  }
  
  public final boolean Ty(int paramInt)
  {
    AppMethodBeat.i(40992);
    int i = ((LinearLayoutManager)getLayoutManager()).kL();
    if ((paramInt == 0) && (this.CEG) && (i >= this.CEF.getItemCount() - 2))
    {
      this.uOi.setVisibility(0);
      AppMethodBeat.o(40992);
      return true;
    }
    AppMethodBeat.o(40992);
    return false;
  }
  
  public final e Tz(int paramInt)
  {
    AppMethodBeat.i(40993);
    e locale = this.CEF.Tz(paramInt);
    AppMethodBeat.o(40993);
    return locale;
  }
  
  public final void b(LinkedList<e> paramLinkedList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(40991);
    this.CEG = paramBoolean1;
    this.CEH = paramBoolean2;
    this.uOi.setVisibility(8);
    a locala = this.CEF;
    locala.CEM.clear();
    locala.CEM.addAll(paramLinkedList);
    locala.alc.notifyChanged();
    AppMethodBeat.o(40991);
  }
  
  public final void setOnItemClickListener(com.tencent.mm.plugin.appbrand.widget.recyclerview.b paramb)
  {
    this.CEF.rFQ = paramb;
  }
  
  final class a
    extends RecyclerView.a<h.c>
  {
    LinkedList<View> CEK;
    LinkedList<View> CEL;
    LinkedList<e> CEM;
    private Context mContext;
    private ViewGroup rFM;
    private ViewGroup rFN;
    com.tencent.mm.plugin.appbrand.widget.recyclerview.b rFQ;
    
    a(Context paramContext)
    {
      AppMethodBeat.i(40979);
      this.CEK = new LinkedList();
      this.CEL = new LinkedList();
      this.CEM = new LinkedList();
      this.mContext = paramContext;
      AppMethodBeat.o(40979);
    }
    
    private int Jw(int paramInt)
    {
      AppMethodBeat.i(40983);
      if ((paramInt < 0) || (paramInt >= this.CEM.size()))
      {
        AppMethodBeat.o(40983);
        return paramInt;
      }
      int j = 0;
      int i = 0;
      if (j < paramInt + 1)
      {
        e locale = (e)this.CEM.get(j);
        if ((locale.Crb) || (locale.Crc)) {
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
        com.tencent.mm.game.report.b.a.a(MMApplicationContext.getContext(), h.d(h.this), paramInt1, paramInt2, paramString1, h.e(h.this), com.tencent.mm.game.report.b.a.b(i, localHashMap));
        AppMethodBeat.o(40984);
        return;
      }
    }
    
    public final e Tz(int paramInt)
    {
      AppMethodBeat.i(40982);
      if ((paramInt < 0) || (paramInt >= this.CEM.size()))
      {
        AppMethodBeat.o(40982);
        return null;
      }
      e locale = (e)this.CEM.get(paramInt);
      AppMethodBeat.o(40982);
      return locale;
    }
    
    public final int getItemCount()
    {
      int j = 0;
      AppMethodBeat.i(40980);
      int k = this.CEM.size();
      int i;
      if (this.CEK.isEmpty())
      {
        i = 0;
        if (!this.CEL.isEmpty()) {
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
      if ((paramInt == 0) && (!this.CEK.isEmpty()))
      {
        AppMethodBeat.o(40981);
        return 2147483647;
      }
      if ((paramInt == getItemCount() - 1) && (!this.CEL.isEmpty()))
      {
        AppMethodBeat.o(40981);
        return 2147483646;
      }
      if (this.CEK.isEmpty()) {}
      for (int i = 0;; i = 1)
      {
        paramInt -= i;
        if ((paramInt >= 0) && (paramInt < this.CEM.size())) {
          break;
        }
        AppMethodBeat.o(40981);
        return 0;
      }
      e locale = (e)this.CEM.get(paramInt);
      if ((locale != null) && (locale.Crb))
      {
        AppMethodBeat.o(40981);
        return 1;
      }
      if ((locale != null) && (locale.Crc))
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
      this.mSize = aw.fromDPToPix(MMApplicationContext.getContext(), 1);
      AppMethodBeat.o(40987);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(203801);
      paramRecyclerView = (GridLayoutManager)paramRecyclerView.getLayoutManager();
      RecyclerView.bh(paramView);
      paramView = (GridLayoutManager.LayoutParams)paramView.getLayoutParams();
      int i = paramRecyclerView.ahF;
      Log.i("MicroMsg.GameHaowanRecycleView", "getItemOffsets, spanSize = %d, spanCount = %d, index = %d", new Object[] { Integer.valueOf(paramView.ahN), Integer.valueOf(i), Integer.valueOf(paramView.ahM) });
      if (paramView.ahN != i)
      {
        if (paramView.ahM == 0)
        {
          paramRect.set(0, this.mSize, this.mSize, this.mSize);
          AppMethodBeat.o(203801);
          return;
        }
        paramRect.set(this.mSize, this.mSize, 0, this.mSize);
        AppMethodBeat.o(203801);
        return;
      }
      paramRect.set(0, 0, 0, 0);
      AppMethodBeat.o(203801);
    }
  }
  
  static final class c
    extends RecyclerView.v
  {
    public TextView CEQ;
    public TextView CER;
    public GameVideoTagContainer CES;
    public TextView CET;
    public ImageView CEU;
    public ImageView qPQ;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(40989);
      this.CEQ = ((TextView)paramView.findViewById(g.e.ClR));
      this.qPQ = ((ImageView)paramView.findViewById(g.e.video_icon));
      this.CER = ((TextView)paramView.findViewById(g.e.ChI));
      this.CES = ((GameVideoTagContainer)paramView.findViewById(g.e.Cmc));
      this.CET = ((TextView)paramView.findViewById(g.e.video_title));
      this.CEU = ((ImageView)paramView.findViewById(g.e.Ckz));
      AppMethodBeat.o(40989);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.h
 * JD-Core Version:    0.7.0.1
 */