package com.tencent.mm.plugin.gamelive.b;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.ui.widget.a.h.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;

public final class b
  extends h.b
{
  private static int Jgg = 1;
  static String TAG = "GameLivePlayGameConditionChoosePage";
  private a Jgf;
  int Jgh;
  ArrayList<b> pUj;
  private View plc;
  
  public b(a parama)
  {
    AppMethodBeat.i(277322);
    this.plc = null;
    this.pUj = new ArrayList();
    this.Jgf = parama;
    AppMethodBeat.o(277322);
  }
  
  public final View E(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(277362);
    this.plc = LayoutInflater.from(paramViewGroup.getContext()).inflate(ba.g.app_brand_gamelive_paygame_condition, paramViewGroup, false);
    this.plc.findViewById(ba.f.paygame_condition_back_button).setOnClickListener(new b..ExternalSyntheticLambda0(this));
    paramViewGroup = (WxRecyclerView)this.plc.findViewById(ba.f.paygame_condition_single__rv);
    WxRecyclerAdapter localWxRecyclerAdapter = new WxRecyclerAdapter(new g()
    {
      public final f<b.b> yF(int paramAnonymousInt)
      {
        AppMethodBeat.i(277370);
        b.c localc = new b.c(b.this);
        AppMethodBeat.o(277370);
        return localc;
      }
    }, this.pUj, false);
    localWxRecyclerAdapter.agOe = new i.c() {};
    paramViewGroup.setAdapter(localWxRecyclerAdapter);
    paramViewGroup = this.plc;
    AppMethodBeat.o(277362);
    return paramViewGroup;
  }
  
  public static abstract interface a
  {
    public abstract void fC(String paramString, int paramInt);
  }
  
  final class b
    implements cc
  {
    public int Jgj;
    public String mWording;
    
    public b(int paramInt, String paramString)
    {
      this.mWording = paramString;
      this.Jgj = paramInt;
    }
    
    public final int a(k paramk)
    {
      AppMethodBeat.i(277330);
      if ((paramk instanceof b))
      {
        if ((this.Jgj == ((b)paramk).Jgj) && (TextUtils.equals(this.mWording, ((b)paramk).mWording)))
        {
          AppMethodBeat.o(277330);
          return 0;
        }
        AppMethodBeat.o(277330);
        return 1;
      }
      AppMethodBeat.o(277330);
      return 1;
    }
    
    public final long bZA()
    {
      return this.Jgj;
    }
    
    public final int bZB()
    {
      AppMethodBeat.i(277340);
      int i = b.Jgg;
      AppMethodBeat.o(277340);
      return i;
    }
  }
  
  final class c
    extends f<b.b>
  {
    c() {}
    
    public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt) {}
    
    public final int getLayoutId()
    {
      return ba.g.app_brand_gamelive_paygame_condition_single_item;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.b.b
 * JD-Core Version:    0.7.0.1
 */