package com.tencent.mm.plugin.game.media;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager.b;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.autogen.b.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.widget.GameGridLayoutManager;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class h
  extends RecyclerView
{
  private int IyG;
  private int IyH;
  a IyI;
  private boolean IyJ;
  private boolean IyK;
  private Set<Integer> IyL;
  private View xWS;
  
  public h(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    AppMethodBeat.i(276819);
    this.IyL = new HashSet();
    this.IyG = paramInt1;
    this.IyH = paramInt2;
    this.IyI = new a(getContext());
    getContext();
    paramContext = new GameGridLayoutManager();
    paramContext.bWq = new GridLayoutManager.b()
    {
      public final int fJ(int paramAnonymousInt)
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
    this.xWS = LayoutInflater.from(getContext()).inflate(h.f.HZn, this, false);
    this.xWS.setVisibility(8);
    paramContext = this.IyI;
    View localView = this.xWS;
    paramContext.IyO.add(localView);
    setAdapter(this.IyI);
    AppMethodBeat.o(276819);
  }
  
  public final boolean Xs(int paramInt)
  {
    AppMethodBeat.i(40992);
    int i = ((LinearLayoutManager)getLayoutManager()).Jw();
    if ((paramInt == 0) && (this.IyJ) && (i >= this.IyI.getItemCount() - 2))
    {
      this.xWS.setVisibility(0);
      AppMethodBeat.o(40992);
      return true;
    }
    AppMethodBeat.o(40992);
    return false;
  }
  
  public final e Xt(int paramInt)
  {
    AppMethodBeat.i(40993);
    e locale = this.IyI.Xt(paramInt);
    AppMethodBeat.o(40993);
    return locale;
  }
  
  public final void b(LinkedList<e> paramLinkedList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(40991);
    this.IyJ = paramBoolean1;
    this.IyK = paramBoolean2;
    this.xWS.setVisibility(8);
    a locala = this.IyI;
    locala.IyP.clear();
    locala.IyP.addAll(paramLinkedList);
    locala.bZE.notifyChanged();
    AppMethodBeat.o(40991);
  }
  
  public final void setOnItemClickListener(com.tencent.mm.plugin.appbrand.widget.recyclerview.b paramb)
  {
    this.IyI.uRc = paramb;
  }
  
  final class a
    extends RecyclerView.a<h.c>
  {
    LinkedList<View> IyN;
    LinkedList<View> IyO;
    LinkedList<e> IyP;
    private Context mContext;
    private ViewGroup uQY;
    private ViewGroup uQZ;
    com.tencent.mm.plugin.appbrand.widget.recyclerview.b uRc;
    
    a(Context paramContext)
    {
      AppMethodBeat.i(40979);
      this.IyN = new LinkedList();
      this.IyO = new LinkedList();
      this.IyP = new LinkedList();
      this.mContext = paramContext;
      AppMethodBeat.o(40979);
    }
    
    private int Ke(int paramInt)
    {
      AppMethodBeat.i(40983);
      if ((paramInt < 0) || (paramInt >= this.IyP.size()))
      {
        AppMethodBeat.o(40983);
        return paramInt;
      }
      int j = 0;
      int i = 0;
      if (j < paramInt + 1)
      {
        e locale = (e)this.IyP.get(j);
        if ((locale.Idj) || (locale.Idk)) {
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
    
    private void g(int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      AppMethodBeat.i(40984);
      if (h.d(h.this) == 8762) {}
      for (int i = 7;; i = 6)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("videoid", paramString2);
        com.tencent.mm.game.report.b.a.a(MMApplicationContext.getContext(), h.d(h.this), paramInt1, paramInt2, paramString1, h.e(h.this), com.tencent.mm.game.report.b.a.a(i, localHashMap));
        AppMethodBeat.o(40984);
        return;
      }
    }
    
    public final e Xt(int paramInt)
    {
      AppMethodBeat.i(40982);
      if ((paramInt < 0) || (paramInt >= this.IyP.size()))
      {
        AppMethodBeat.o(40982);
        return null;
      }
      e locale = (e)this.IyP.get(paramInt);
      AppMethodBeat.o(40982);
      return locale;
    }
    
    public final int getItemCount()
    {
      int j = 0;
      AppMethodBeat.i(40980);
      int k = this.IyP.size();
      int i;
      if (this.IyN.isEmpty())
      {
        i = 0;
        if (!this.IyO.isEmpty()) {
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
      if ((paramInt == 0) && (!this.IyN.isEmpty()))
      {
        AppMethodBeat.o(40981);
        return 2147483647;
      }
      if ((paramInt == getItemCount() - 1) && (!this.IyO.isEmpty()))
      {
        AppMethodBeat.o(40981);
        return 2147483646;
      }
      if (this.IyN.isEmpty()) {}
      for (int i = 0;; i = 1)
      {
        paramInt -= i;
        if ((paramInt >= 0) && (paramInt < this.IyP.size())) {
          break;
        }
        AppMethodBeat.o(40981);
        return 0;
      }
      e locale = (e)this.IyP.get(paramInt);
      if ((locale != null) && (locale.Idj))
      {
        AppMethodBeat.o(40981);
        return 1;
      }
      if ((locale != null) && (locale.Idk))
      {
        AppMethodBeat.o(40981);
        return 2;
      }
      AppMethodBeat.o(40981);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.h
 * JD-Core Version:    0.7.0.1
 */