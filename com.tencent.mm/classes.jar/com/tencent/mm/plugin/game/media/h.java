package com.tencent.mm.plugin.game.media;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
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
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class h
  extends RecyclerView
{
  private View pTX;
  private int uii;
  a uij;
  private boolean uik;
  private boolean uil;
  private Set<Integer> uim;
  
  public h(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(40990);
    this.uim = new HashSet();
    this.uii = paramInt;
    this.uij = new a(getContext());
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
    a(new h.b());
    this.pTX = LayoutInflater.from(getContext()).inflate(2131494300, this, false);
    this.pTX.setVisibility(8);
    paramContext = this.uij;
    View localView = this.pTX;
    paramContext.uiq.add(localView);
    setAdapter(this.uij);
    AppMethodBeat.o(40990);
  }
  
  public final boolean Ic(int paramInt)
  {
    AppMethodBeat.i(40992);
    int i = ((LinearLayoutManager)getLayoutManager()).ko();
    if ((paramInt == 0) && (this.uik) && (i >= this.uij.getItemCount() - 2))
    {
      this.pTX.setVisibility(0);
      AppMethodBeat.o(40992);
      return true;
    }
    AppMethodBeat.o(40992);
    return false;
  }
  
  public final e Id(int paramInt)
  {
    AppMethodBeat.i(40993);
    e locale = this.uij.Id(paramInt);
    AppMethodBeat.o(40993);
    return locale;
  }
  
  public final void b(LinkedList<e> paramLinkedList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(40991);
    this.uik = paramBoolean1;
    this.uil = paramBoolean2;
    this.pTX.setVisibility(8);
    a locala = this.uij;
    locala.uir.clear();
    locala.uir.addAll(paramLinkedList);
    locala.asY.notifyChanged();
    AppMethodBeat.o(40991);
  }
  
  public final void setOnItemClickListener(com.tencent.mm.plugin.appbrand.widget.recyclerview.b paramb)
  {
    this.uij.nud = paramb;
  }
  
  final class a
    extends RecyclerView.a<h.c>
  {
    private Context mContext;
    private ViewGroup ntZ;
    private ViewGroup nua;
    com.tencent.mm.plugin.appbrand.widget.recyclerview.b nud;
    LinkedList<View> uip;
    LinkedList<View> uiq;
    LinkedList<e> uir;
    
    a(Context paramContext)
    {
      AppMethodBeat.i(40979);
      this.uip = new LinkedList();
      this.uiq = new LinkedList();
      this.uir = new LinkedList();
      this.mContext = paramContext;
      AppMethodBeat.o(40979);
    }
    
    private int Cf(int paramInt)
    {
      AppMethodBeat.i(40983);
      if ((paramInt < 0) || (paramInt >= this.uir.size()))
      {
        AppMethodBeat.o(40983);
        return paramInt;
      }
      int j = 0;
      int i = 0;
      if (j < paramInt + 1)
      {
        e locale = (e)this.uir.get(j);
        if ((locale.ucV) || (locale.ucW)) {
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
        com.tencent.mm.game.report.b.a.a(ak.getContext(), h.d(h.this), paramInt1, paramInt2, paramString1, com.tencent.mm.game.report.b.a.b(i, localHashMap));
        AppMethodBeat.o(40984);
        return;
      }
    }
    
    public final e Id(int paramInt)
    {
      AppMethodBeat.i(40982);
      if ((paramInt < 0) || (paramInt >= this.uir.size()))
      {
        AppMethodBeat.o(40982);
        return null;
      }
      e locale = (e)this.uir.get(paramInt);
      AppMethodBeat.o(40982);
      return locale;
    }
    
    public final int getItemCount()
    {
      int j = 0;
      AppMethodBeat.i(40980);
      int k = this.uir.size();
      int i;
      if (this.uip.isEmpty())
      {
        i = 0;
        if (!this.uiq.isEmpty()) {
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
      if ((paramInt == 0) && (!this.uip.isEmpty()))
      {
        AppMethodBeat.o(40981);
        return 2147483647;
      }
      if ((paramInt == getItemCount() - 1) && (!this.uiq.isEmpty()))
      {
        AppMethodBeat.o(40981);
        return 2147483646;
      }
      if (this.uip.isEmpty()) {}
      for (int i = 0;; i = 1)
      {
        paramInt -= i;
        if ((paramInt >= 0) && (paramInt < this.uir.size())) {
          break;
        }
        AppMethodBeat.o(40981);
        return 0;
      }
      e locale = (e)this.uir.get(paramInt);
      if ((locale != null) && (locale.ucV))
      {
        AppMethodBeat.o(40981);
        return 1;
      }
      if ((locale != null) && (locale.ucW))
      {
        AppMethodBeat.o(40981);
        return 2;
      }
      AppMethodBeat.o(40981);
      return 0;
    }
  }
  
  static final class c
    extends RecyclerView.w
  {
    public ImageView mBP;
    public TextView uiv;
    public TextView uiw;
    public GameVideoTagContainer uix;
    public TextView uiy;
    public ImageView uiz;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(40989);
      this.uiv = ((TextView)paramView.findViewById(2131305821));
      this.mBP = ((ImageView)paramView.findViewById(2131306344));
      this.uiw = ((TextView)paramView.findViewById(2131299617));
      this.uix = ((GameVideoTagContainer)paramView.findViewById(2131306397));
      this.uiy = ((TextView)paramView.findViewById(2131306405));
      this.uiz = ((ImageView)paramView.findViewById(2131300564));
      AppMethodBeat.o(40989);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.h
 * JD-Core Version:    0.7.0.1
 */