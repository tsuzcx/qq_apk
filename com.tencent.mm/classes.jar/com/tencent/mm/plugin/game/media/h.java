package com.tencent.mm.plugin.game.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.v;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class h
  extends RecyclerView
{
  private View oGs;
  private int rRC;
  a rRD;
  private boolean rRE;
  private boolean rRF;
  private Set<Integer> rRG;
  
  public h(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(40990);
    this.rRG = new HashSet();
    this.rRC = paramInt;
    this.rRD = new a(getContext());
    getContext();
    paramContext = new GameGridLayoutManager();
    paramContext.amS = new GridLayoutManager.b()
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
    a(new h.b());
    this.oGs = LayoutInflater.from(getContext()).inflate(2131494300, this, false);
    this.oGs.setVisibility(8);
    paramContext = this.rRD;
    View localView = this.oGs;
    paramContext.rRJ.add(localView);
    setAdapter(this.rRD);
    AppMethodBeat.o(40990);
  }
  
  public final boolean Ep(int paramInt)
  {
    AppMethodBeat.i(40992);
    int i = ((LinearLayoutManager)getLayoutManager()).jQ();
    if ((paramInt == 0) && (this.rRE) && (i >= this.rRD.getItemCount() - 2))
    {
      this.oGs.setVisibility(0);
      AppMethodBeat.o(40992);
      return true;
    }
    AppMethodBeat.o(40992);
    return false;
  }
  
  public final e Eq(int paramInt)
  {
    AppMethodBeat.i(40993);
    e locale = this.rRD.Eq(paramInt);
    AppMethodBeat.o(40993);
    return locale;
  }
  
  public final void b(LinkedList<e> paramLinkedList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(40991);
    this.rRE = paramBoolean1;
    this.rRF = paramBoolean2;
    this.oGs.setVisibility(8);
    a locala = this.rRD;
    locala.rRK.clear();
    locala.rRK.addAll(paramLinkedList);
    locala.aql.notifyChanged();
    AppMethodBeat.o(40991);
  }
  
  public final void setOnItemClickListener(com.tencent.mm.plugin.appbrand.widget.recyclerview.b paramb)
  {
    this.rRD.mmv = paramb;
  }
  
  final class a
    extends RecyclerView.a<h.c>
  {
    private Context mContext;
    private ViewGroup mmr;
    private ViewGroup mms;
    com.tencent.mm.plugin.appbrand.widget.recyclerview.b mmv;
    LinkedList<View> rRI;
    LinkedList<View> rRJ;
    LinkedList<e> rRK;
    
    a(Context paramContext)
    {
      AppMethodBeat.i(40979);
      this.rRI = new LinkedList();
      this.rRJ = new LinkedList();
      this.rRK = new LinkedList();
      this.mContext = paramContext;
      AppMethodBeat.o(40979);
    }
    
    private int At(int paramInt)
    {
      AppMethodBeat.i(40983);
      if ((paramInt < 0) || (paramInt >= this.rRK.size()))
      {
        AppMethodBeat.o(40983);
        return paramInt;
      }
      int j = 0;
      int i = 0;
      if (j < paramInt + 1)
      {
        e locale = (e)this.rRK.get(j);
        if ((locale.rNJ) || (locale.rNK)) {
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
    
    private void d(int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      AppMethodBeat.i(40984);
      if (h.d(h.this) == 8762) {}
      for (int i = 7;; i = 6)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("videoid", paramString2);
        a.a(aj.getContext(), h.d(h.this), paramInt1, paramInt2, paramString1, a.a(i, localHashMap));
        AppMethodBeat.o(40984);
        return;
      }
    }
    
    public final e Eq(int paramInt)
    {
      AppMethodBeat.i(40982);
      if ((paramInt < 0) || (paramInt >= this.rRK.size()))
      {
        AppMethodBeat.o(40982);
        return null;
      }
      e locale = (e)this.rRK.get(paramInt);
      AppMethodBeat.o(40982);
      return locale;
    }
    
    public final int getItemCount()
    {
      int j = 0;
      AppMethodBeat.i(40980);
      int k = this.rRK.size();
      int i;
      if (this.rRI.isEmpty())
      {
        i = 0;
        if (!this.rRJ.isEmpty()) {
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
      if ((paramInt == 0) && (!this.rRI.isEmpty()))
      {
        AppMethodBeat.o(40981);
        return 2147483647;
      }
      if ((paramInt == getItemCount() - 1) && (!this.rRJ.isEmpty()))
      {
        AppMethodBeat.o(40981);
        return 2147483646;
      }
      if (this.rRI.isEmpty()) {}
      for (int i = 0;; i = 1)
      {
        paramInt -= i;
        if ((paramInt >= 0) && (paramInt < this.rRK.size())) {
          break;
        }
        AppMethodBeat.o(40981);
        return 0;
      }
      e locale = (e)this.rRK.get(paramInt);
      if ((locale != null) && (locale.rNJ))
      {
        AppMethodBeat.o(40981);
        return 1;
      }
      if ((locale != null) && (locale.rNK))
      {
        AppMethodBeat.o(40981);
        return 2;
      }
      AppMethodBeat.o(40981);
      return 0;
    }
  }
  
  static final class c
    extends RecyclerView.v
  {
    public ImageView lvj;
    public TextView rRO;
    public TextView rRP;
    public GameVideoTagContainer rRQ;
    public TextView rRR;
    public ImageView rRS;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(40989);
      this.rRO = ((TextView)paramView.findViewById(2131305821));
      this.lvj = ((ImageView)paramView.findViewById(2131306344));
      this.rRP = ((TextView)paramView.findViewById(2131299617));
      this.rRQ = ((GameVideoTagContainer)paramView.findViewById(2131306397));
      this.rRR = ((TextView)paramView.findViewById(2131306405));
      this.rRS = ((ImageView)paramView.findViewById(2131300564));
      AppMethodBeat.o(40989);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.h
 * JD-Core Version:    0.7.0.1
 */