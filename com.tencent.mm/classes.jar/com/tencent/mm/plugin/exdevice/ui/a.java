package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.fhc;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.LinkedList;

final class a
  extends BaseAdapter
{
  private Context context;
  private String username;
  private boolean yAN;
  private LinkedList<LinkedList<fhc>> yAO;
  
  public a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(274726);
    this.context = paramContext;
    this.username = paramString;
    this.yAN = z.bAM().equals(paramString);
    paramString = k.aeZF;
    this.yAO = ((e)k.nq(paramContext).q(e.class)).yAO;
    AppMethodBeat.o(274726);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(274727);
    if (Util.isNullOrNil(this.yAO))
    {
      AppMethodBeat.o(274727);
      return 2;
    }
    int i = this.yAO.size();
    AppMethodBeat.o(274727);
    return i + 2;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(24077);
    AppMethodBeat.o(24077);
    return Integer.valueOf(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(274728);
    if (paramInt == 0)
    {
      AppMethodBeat.o(274728);
      return 0;
    }
    if ((paramInt > 0) && (!Util.isNullOrNil(this.yAO)) && (paramInt <= this.yAO.size()))
    {
      AppMethodBeat.o(274728);
      return 1;
    }
    if (this.yAN)
    {
      AppMethodBeat.o(274728);
      return 2;
    }
    AppMethodBeat.o(274728);
    return 3;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(24078);
    int i = getItemViewType(paramInt);
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramView = k.aeZF;
      paramViewGroup = (e)k.nq(this.context).q(e.class);
      switch (i)
      {
      default: 
        paramView = null;
      }
    }
    for (;;)
    {
      paramViewGroup = paramView;
      paramView = k.aeZF;
      ((e)k.nq(this.context).q(e.class)).a(i, paramViewGroup, this.username, paramInt);
      AppMethodBeat.o(24078);
      return paramViewGroup;
      paramView = LayoutInflater.from((Context)paramViewGroup.getActivity()).inflate(R.i.gjv, null);
      paramViewGroup = new e.d(paramViewGroup);
      paramViewGroup.yEO = paramView.findViewById(R.h.follow_layout);
      paramViewGroup.yEP = paramView.findViewById(R.h.fFZ);
      paramView.setTag(paramViewGroup);
      continue;
      paramView = LayoutInflater.from((Context)paramViewGroup.getActivity()).inflate(R.i.gjt, null);
      paramViewGroup = new e.a(paramViewGroup);
      paramViewGroup.yEL = ((TextView)paramView.findViewById(R.h.fqr));
      paramView.setTag(paramViewGroup);
      continue;
      paramView = LayoutInflater.from((Context)paramViewGroup.getActivity()).inflate(R.i.gjy, null);
      paramViewGroup = new e.c(paramViewGroup);
      paramViewGroup.yEN = ((LinearLayout)paramView.findViewById(R.h.frI));
      paramViewGroup.rIe = ((ImageView)paramView.findViewById(R.h.frx));
      paramViewGroup.pJc = ((TextView)paramView.findViewById(R.h.frC));
      paramView.setTag(paramViewGroup);
      continue;
      paramView = LayoutInflater.from((Context)paramViewGroup.getActivity()).inflate(R.i.gjx, null);
      paramViewGroup = new e.e(paramViewGroup);
      View localView = paramView.findViewById(R.h.fHg);
      if (localView == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(24078);
        throw paramView;
      }
      paramViewGroup.xaN = ((ImageView)localView);
      localView = paramView.findViewById(R.h.date_tv);
      if (localView == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(24078);
        throw paramView;
      }
      paramViewGroup.wRf = ((TextView)localView);
      localView = paramView.findViewById(R.h.gak);
      if (localView == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(24078);
        throw paramView;
      }
      paramViewGroup.yER = ((TextView)localView);
      localView = paramView.findViewById(R.h.fHc);
      if (localView == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(24078);
        throw paramView;
      }
      paramViewGroup.yAA = ((TextView)localView);
      localView = paramView.findViewById(R.h.fHh);
      if (localView == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(24078);
        throw paramView;
      }
      paramViewGroup.yEQ = ((TextView)localView);
      localView = paramView.findViewById(R.h.fGS);
      if (localView == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(24078);
        throw paramView;
      }
      paramViewGroup.yES = ((TextView)localView);
      localView = paramView.findViewById(R.h.frI);
      if (localView == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
        AppMethodBeat.o(24078);
        throw paramView;
      }
      paramViewGroup.yEN = ((LinearLayout)localView);
      paramViewGroup.yET = paramView.findViewById(R.h.frH);
      paramViewGroup.yEU = paramView.findViewById(R.h.gaj);
      paramViewGroup.yEV = ((ImageView)paramView.findViewById(R.h.fHb));
      localView = paramView.findViewById(R.h.gdO);
      if (localView == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(24078);
        throw paramView;
      }
      paramViewGroup.yEW = ((ViewGroup)localView);
      localView = paramView.findViewById(R.h.gaW);
      if (localView == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(24078);
        throw paramView;
      }
      paramViewGroup.yEX = ((TextView)localView);
      localView = paramView.findViewById(R.h.gaR);
      if (localView == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(24078);
        throw paramView;
      }
      paramViewGroup.yEY = ((TextView)localView);
      paramView.setTag(paramViewGroup);
    }
  }
  
  public final int getViewTypeCount()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.a
 * JD-Core Version:    0.7.0.1
 */