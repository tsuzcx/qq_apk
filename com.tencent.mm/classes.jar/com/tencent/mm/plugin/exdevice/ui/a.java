package com.tencent.mm.plugin.exdevice.ui;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.appbrand.service.q.a;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.bxc;
import com.tencent.mm.protocal.protobuf.ecf;
import com.tencent.mm.protocal.protobuf.ecx;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.t;

final class a
  extends BaseAdapter
{
  private Context context;
  private boolean rIK;
  private String username;
  
  public a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(231697);
    this.context = paramContext;
    this.username = paramString;
    this.rIK = z.aTY().equals(paramString);
    AppMethodBeat.o(231697);
  }
  
  public final int getCount()
  {
    if (this.rIK) {
      return 2;
    }
    return 1;
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
    if (paramInt == 0) {
      return 0;
    }
    return 1;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(24078);
    paramInt = getItemViewType(paramInt);
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramView = com.tencent.mm.ui.component.a.PRN;
      paramViewGroup = (SportProfileUIC)com.tencent.mm.ui.component.a.ko(this.context).get(SportProfileUIC.class);
    }
    Object localObject1;
    String str;
    switch (paramInt)
    {
    default: 
      paramView = null;
      paramViewGroup = paramView;
      paramView = com.tencent.mm.ui.component.a.PRN;
      localObject1 = (SportProfileUIC)com.tencent.mm.ui.component.a.ko(this.context).get(SportProfileUIC.class);
      str = this.username;
      p.h(paramViewGroup, "itemView");
      p.h(str, "username");
      switch (paramInt)
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(24078);
      return paramViewGroup;
      paramView = LayoutInflater.from((Context)paramViewGroup.getActivity()).inflate(2131494032, null);
      paramViewGroup = new SportProfileUIC.a(paramViewGroup);
      paramViewGroup.rMS = paramView.findViewById(2131301650);
      paramViewGroup.rMT = paramView.findViewById(2131299728);
      paramView.setTag(paramViewGroup);
      break;
      paramView = LayoutInflater.from((Context)paramViewGroup.getActivity()).inflate(2131494033, null);
      paramViewGroup = new SportProfileUIC.b(paramViewGroup);
      localObject1 = paramView.findViewById(2131300204);
      if (localObject1 == null)
      {
        paramView = new t("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(24078);
        throw paramView;
      }
      paramViewGroup.qyu = ((ImageView)localObject1);
      localObject1 = paramView.findViewById(2131299419);
      if (localObject1 == null)
      {
        paramView = new t("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(24078);
        throw paramView;
      }
      paramViewGroup.qpf = ((TextView)localObject1);
      localObject1 = paramView.findViewById(2131300200);
      if (localObject1 == null)
      {
        paramView = new t("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(24078);
        throw paramView;
      }
      paramViewGroup.rIw = ((TextView)localObject1);
      localObject1 = paramView.findViewById(2131300206);
      if (localObject1 == null)
      {
        paramView = new t("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(24078);
        throw paramView;
      }
      paramViewGroup.rMV = ((TextView)localObject1);
      localObject1 = paramView.findViewById(2131300181);
      if (localObject1 == null)
      {
        paramView = new t("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(24078);
        throw paramView;
      }
      paramViewGroup.rMW = ((TextView)localObject1);
      localObject1 = paramView.findViewById(2131297002);
      if (localObject1 == null)
      {
        paramView = new t("null cannot be cast to non-null type android.widget.LinearLayout");
        AppMethodBeat.o(24078);
        throw paramView;
      }
      paramViewGroup.rMX = ((LinearLayout)localObject1);
      paramViewGroup.rMY = paramView.findViewById(2131297001);
      paramViewGroup.rMZ = paramView.findViewById(2131309262);
      paramViewGroup.rNa = ((ImageView)paramView.findViewById(2131300199));
      paramViewGroup.rNb = ((TextView)paramView.findViewById(2131296529));
      paramView.setTag(paramViewGroup);
      break;
      paramView = paramViewGroup.getTag();
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.exdevice.ui.SportProfileUIC.OtherBtnViewHolder");
        AppMethodBeat.o(24078);
        throw paramView;
      }
      paramView = (SportProfileUIC.a)paramView;
      Object localObject2 = paramView.rMT;
      if (localObject2 != null) {
        ((View)localObject2).setOnClickListener((View.OnClickListener)new SportProfileUIC.d((SportProfileUIC)localObject1));
      }
      paramView = paramView.rMS;
      if (paramView != null)
      {
        paramView.setOnClickListener((View.OnClickListener)new SportProfileUIC.f((SportProfileUIC)localObject1));
        continue;
        localObject2 = new z.f();
        paramView = paramViewGroup.getTag();
        if (paramView == null)
        {
          paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.exdevice.ui.SportProfileUIC.ProfileViewHolder");
          AppMethodBeat.o(24078);
          throw paramView;
        }
        ((z.f)localObject2).SYG = ((SportProfileUIC.b)paramView);
        a.b.c(((SportProfileUIC.b)((z.f)localObject2).SYG).qyu, str);
        paramView = ((SportProfileUIC.b)((z.f)localObject2).SYG).rMV;
        if (paramView != null) {
          paramView.setText((CharSequence)aa.getDisplayName(str));
        }
        paramView = ((SportProfileUIC.b)((z.f)localObject2).SYG).qpf;
        if (paramView != null) {
          paramView.setText((CharSequence)f.formatTime(((SportProfileUIC)localObject1).getActivity().getString(2131760813), cl.aWB()));
        }
        paramView = ((SportProfileUIC)localObject1).rMR;
        label834:
        label875:
        Object localObject3;
        label952:
        label1016:
        label1020:
        z.f localf;
        label1066:
        label1095:
        Object localObject4;
        if (paramView != null)
        {
          paramView = paramView.KHS;
          if (paramView != null)
          {
            paramView = (ecx)j.kv((List)paramView);
            if (paramView != null)
            {
              paramInt = paramView.lCq;
              paramView = ((SportProfileUIC.b)((z.f)localObject2).SYG).rMW;
              if (paramView != null) {
                paramView.setText((CharSequence)String.valueOf(paramInt));
              }
              if (paramInt < 10000) {
                break label1415;
              }
              paramView = ((SportProfileUIC.b)((z.f)localObject2).SYG).rMW;
              if (paramView != null) {
                paramView.setTextColor(((SportProfileUIC)localObject1).getActivity().getResources().getColor(2131100342));
              }
              paramView = ((SportProfileUIC)localObject1).rMR;
              if ((paramView == null) || (paramView.ApK != true)) {
                break label1452;
              }
              paramView = ((SportProfileUIC.b)((z.f)localObject2).SYG).rNa;
              if (paramView != null) {
                paramView.setImageResource(2131690082);
              }
              if (p.j(str, z.aTY()))
              {
                paramView = ((SportProfileUIC.b)((z.f)localObject2).SYG).rNa;
                if (paramView != null) {
                  paramView.setOnClickListener((View.OnClickListener)new SportProfileUIC.g((SportProfileUIC)localObject1));
                }
              }
              paramView = ((SportProfileUIC.b)((z.f)localObject2).SYG).rIw;
              if (paramView != null)
              {
                localObject3 = ((SportProfileUIC)localObject1).rMR;
                if (localObject3 == null) {
                  break label1478;
                }
                paramInt = ((bxc)localObject3).Lqb;
                paramView.setText((CharSequence)String.valueOf(paramInt));
              }
              paramView = ((SportProfileUIC.b)((z.f)localObject2).SYG).rMX;
              if (paramView != null) {
                paramView.removeAllViews();
              }
              paramView = ((SportProfileUIC)localObject1).rMR;
              if (paramView == null) {
                break label1493;
              }
              paramView = paramView.McT;
              if (paramView == null) {
                break label1493;
              }
              if (((Collection)paramView).isEmpty()) {
                break label1483;
              }
              paramInt = 1;
              if (paramInt == 0) {
                break label1488;
              }
              if (paramView == null) {
                break label1493;
              }
              paramView = ((SportProfileUIC.b)((z.f)localObject2).SYG).rMX;
              if (paramView != null) {
                paramView.setVisibility(0);
              }
              paramView = ((SportProfileUIC.b)((z.f)localObject2).SYG).rMY;
              if (paramView != null) {
                paramView.setVisibility(0);
              }
              paramView = ((SportProfileUIC)localObject1).rMR;
              if (paramView == null) {
                break label1574;
              }
              paramView = paramView.McT;
              if (paramView == null) {
                break label1574;
              }
              paramView = ((Iterable)paramView).iterator();
              if (!paramView.hasNext()) {
                break label1574;
              }
              localObject3 = (ecf)paramView.next();
              localf = new z.f();
              localf.SYG = ((SportProfileUIC)localObject1).getActivity().getLayoutInflater().inflate(2131494034, (ViewGroup)((SportProfileUIC.b)((z.f)localObject2).SYG).rMX, false);
              localObject4 = ((View)localf.SYG).findViewById(2131296987);
              p.g(localObject4, "view.findViewById<TextVi…(R.id.appbrand_info_1_tv)");
              ((TextView)localObject4).setText((CharSequence)((ecf)localObject3).Ncs);
              localObject4 = ((View)localf.SYG).findViewById(2131296988);
              p.g(localObject4, "view.findViewById<TextVi…(R.id.appbrand_info_2_tv)");
              ((TextView)localObject4).setText((CharSequence)String.valueOf(((ecf)localObject3).Nct));
              localObject4 = ((View)localf.SYG).findViewById(2131296989);
              p.g(localObject4, "view.findViewById<TextVi…(R.id.appbrand_info_3_tv)");
              ((TextView)localObject4).setText((CharSequence)((ecf)localObject3).Ncu);
              localObject4 = (ImageView)((View)localf.SYG).findViewById(2131296986);
              if (!(p.j("21f9d636b41b25be", ((ecf)localObject3).appId) ^ true)) {
                break label1540;
              }
              ((q)g.af(q.class)).b(((ecf)localObject3).appId, (q.a)new SportProfileUIC.h(localf, (ImageView)localObject4));
            }
          }
        }
        for (;;)
        {
          localObject4 = ((SportProfileUIC.b)((z.f)localObject2).SYG).rMX;
          if (localObject4 != null) {
            ((LinearLayout)localObject4).addView((View)localf.SYG);
          }
          ((View)localf.SYG).setOnClickListener((View.OnClickListener)new SportProfileUIC.c((ecf)localObject3, (SportProfileUIC)localObject1, (z.f)localObject2));
          break label1095;
          paramInt = 0;
          break;
          label1415:
          paramView = ((SportProfileUIC.b)((z.f)localObject2).SYG).rMW;
          if (paramView == null) {
            break label834;
          }
          paramView.setTextColor(((SportProfileUIC)localObject1).getActivity().getResources().getColor(2131100341));
          break label834;
          label1452:
          paramView = ((SportProfileUIC.b)((z.f)localObject2).SYG).rNa;
          if (paramView == null) {
            break label875;
          }
          paramView.setImageResource(2131690083);
          break label875;
          label1478:
          paramInt = 0;
          break label952;
          label1483:
          paramInt = 0;
          break label1016;
          label1488:
          paramView = null;
          break label1020;
          label1493:
          paramView = ((SportProfileUIC.b)((z.f)localObject2).SYG).rMX;
          if (paramView != null) {
            paramView.setVisibility(8);
          }
          paramView = ((SportProfileUIC.b)((z.f)localObject2).SYG).rMY;
          if (paramView == null) {
            break label1066;
          }
          paramView.setVisibility(8);
          break label1066;
          label1540:
          ((TextView)((View)localf.SYG).findViewById(2131296992)).setText(2131766360);
          ((ImageView)localObject4).setImageResource(2131690736);
        }
        label1574:
        paramView = ((SportProfileUIC.b)((z.f)localObject2).SYG).rMZ;
        if (paramView != null) {
          paramView.setOnClickListener((View.OnClickListener)new SportProfileUIC.i((SportProfileUIC)localObject1, str));
        }
        paramView = ((SportProfileUIC.b)((z.f)localObject2).SYG).qyu;
        if (paramView != null) {
          paramView.setOnClickListener((View.OnClickListener)new SportProfileUIC.j((SportProfileUIC)localObject1, str));
        }
        if ((p.j(str, z.aTY()) ^ true))
        {
          paramView = ((SportProfileUIC)localObject1).rMR;
          if ((paramView == null) || (paramView.rCx != true))
          {
            paramView = ((SportProfileUIC.b)((z.f)localObject2).SYG).rNb;
            if (paramView != null) {
              paramView.setVisibility(0);
            }
            paramView = ((SportProfileUIC.b)((z.f)localObject2).SYG).rNb;
            if (paramView == null) {
              continue;
            }
            paramView.setOnClickListener((View.OnClickListener)new SportProfileUIC.e((SportProfileUIC)localObject1));
            continue;
          }
        }
        paramView = ((SportProfileUIC.b)((z.f)localObject2).SYG).rNb;
        if (paramView != null) {
          paramView.setVisibility(8);
        }
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    if (this.rIK) {
      return 2;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.a
 * JD-Core Version:    0.7.0.1
 */