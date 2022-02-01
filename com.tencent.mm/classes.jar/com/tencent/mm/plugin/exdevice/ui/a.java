package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.appbrand.service.q.a;
import com.tencent.mm.pluginsdk.j.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.cew;
import com.tencent.mm.protocal.protobuf.emg;
import com.tencent.mm.protocal.protobuf.emy;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.t;

final class a
  extends BaseAdapter
{
  private Context context;
  private String username;
  private boolean vos;
  
  public a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(282535);
    this.context = paramContext;
    this.username = paramString;
    this.vos = z.bcZ().equals(paramString);
    AppMethodBeat.o(282535);
  }
  
  public final int getCount()
  {
    if (this.vos) {
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
      paramView = g.Xox;
      paramViewGroup = (e)g.lm(this.context).i(e.class);
    }
    Object localObject1;
    String str;
    switch (paramInt)
    {
    default: 
      paramView = null;
      paramViewGroup = paramView;
      paramView = g.Xox;
      localObject1 = (e)g.lm(this.context).i(e.class);
      str = this.username;
      p.k(paramViewGroup, "itemView");
      p.k(str, "username");
      switch (paramInt)
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(24078);
      return paramViewGroup;
      paramView = LayoutInflater.from((Context)paramViewGroup.getActivity()).inflate(R.i.egB, null);
      paramViewGroup = new e.a(paramViewGroup);
      paramViewGroup.vsC = paramView.findViewById(R.h.follow_layout);
      paramViewGroup.vsD = paramView.findViewById(R.h.dEV);
      paramView.setTag(paramViewGroup);
      break;
      paramView = LayoutInflater.from((Context)paramViewGroup.getActivity()).inflate(R.i.egC, null);
      paramViewGroup = new e.b(paramViewGroup);
      localObject1 = paramView.findViewById(R.h.dGa);
      if (localObject1 == null)
      {
        paramView = new t("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(24078);
        throw paramView;
      }
      paramViewGroup.tXu = ((ImageView)localObject1);
      localObject1 = paramView.findViewById(R.h.date_tv);
      if (localObject1 == null)
      {
        paramView = new t("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(24078);
        throw paramView;
      }
      paramViewGroup.tNP = ((TextView)localObject1);
      localObject1 = paramView.findViewById(R.h.dFW);
      if (localObject1 == null)
      {
        paramView = new t("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(24078);
        throw paramView;
      }
      paramViewGroup.voe = ((TextView)localObject1);
      localObject1 = paramView.findViewById(R.h.dGb);
      if (localObject1 == null)
      {
        paramView = new t("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(24078);
        throw paramView;
      }
      paramViewGroup.vsF = ((TextView)localObject1);
      localObject1 = paramView.findViewById(R.h.dFM);
      if (localObject1 == null)
      {
        paramView = new t("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(24078);
        throw paramView;
      }
      paramViewGroup.vsG = ((TextView)localObject1);
      localObject1 = paramView.findViewById(R.h.drr);
      if (localObject1 == null)
      {
        paramView = new t("null cannot be cast to non-null type android.widget.LinearLayout");
        AppMethodBeat.o(24078);
        throw paramView;
      }
      paramViewGroup.vsH = ((LinearLayout)localObject1);
      paramViewGroup.vsI = paramView.findViewById(R.h.drq);
      paramViewGroup.vsJ = paramView.findViewById(R.h.dXE);
      paramViewGroup.vsK = ((ImageView)paramView.findViewById(R.h.dFV));
      paramViewGroup.vsL = ((TextView)paramView.findViewById(R.h.dqd));
      paramView.setTag(paramViewGroup);
      break;
      paramView = paramViewGroup.getTag();
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.exdevice.ui.SportProfileUIC.OtherBtnViewHolder");
        AppMethodBeat.o(24078);
        throw paramView;
      }
      paramView = (e.a)paramView;
      Object localObject2 = paramView.vsD;
      if (localObject2 != null) {
        ((View)localObject2).setOnClickListener((View.OnClickListener)new e.d((e)localObject1));
      }
      paramView = paramView.vsC;
      if (paramView != null)
      {
        paramView.setOnClickListener((View.OnClickListener)new e.f((e)localObject1));
        continue;
        localObject2 = new aa.f();
        paramView = paramViewGroup.getTag();
        if (paramView == null)
        {
          paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.exdevice.ui.SportProfileUIC.ProfileViewHolder");
          AppMethodBeat.o(24078);
          throw paramView;
        }
        ((aa.f)localObject2).aaBC = ((e.b)paramView);
        a.b.c(((e.b)((aa.f)localObject2).aaBC).tXu, str);
        paramView = ((e.b)((aa.f)localObject2).aaBC).vsF;
        if (paramView != null) {
          paramView.setText((CharSequence)aa.PJ(str));
        }
        paramView = ((e.b)((aa.f)localObject2).aaBC).tNP;
        if (paramView != null) {
          paramView.setText((CharSequence)f.formatTime(((e)localObject1).getActivity().getString(R.l.fmt_date), cm.bfF()));
        }
        paramView = ((e)localObject1).vsB;
        label849:
        label890:
        Object localObject3;
        label967:
        label1110:
        aa.f localf;
        label1031:
        label1035:
        label1081:
        Object localObject4;
        if (paramView != null)
        {
          paramView = paramView.RJm;
          if (paramView != null)
          {
            paramView = (emy)j.lr((List)paramView);
            if (paramView != null)
            {
              paramInt = paramView.oxQ;
              paramView = ((e.b)((aa.f)localObject2).aaBC).vsG;
              if (paramView != null) {
                paramView.setText((CharSequence)String.valueOf(paramInt));
              }
              if (paramInt < 10000) {
                break label1430;
              }
              paramView = ((e.b)((aa.f)localObject2).aaBC).vsG;
              if (paramView != null) {
                paramView.setTextColor(((e)localObject1).getActivity().getResources().getColor(R.e.dkt));
              }
              paramView = ((e)localObject1).vsB;
              if ((paramView == null) || (paramView.Gbs != true)) {
                break label1467;
              }
              paramView = ((e.b)((aa.f)localObject2).aaBC).vsK;
              if (paramView != null) {
                paramView.setImageResource(R.k.device_rank_item_liked);
              }
              if (p.h(str, z.bcZ()))
              {
                paramView = ((e.b)((aa.f)localObject2).aaBC).vsK;
                if (paramView != null) {
                  paramView.setOnClickListener((View.OnClickListener)new e.g((e)localObject1));
                }
              }
              paramView = ((e.b)((aa.f)localObject2).aaBC).voe;
              if (paramView != null)
              {
                localObject3 = ((e)localObject1).vsB;
                if (localObject3 == null) {
                  break label1493;
                }
                paramInt = ((cew)localObject3).Sry;
                paramView.setText((CharSequence)String.valueOf(paramInt));
              }
              paramView = ((e.b)((aa.f)localObject2).aaBC).vsH;
              if (paramView != null) {
                paramView.removeAllViews();
              }
              paramView = ((e)localObject1).vsB;
              if (paramView == null) {
                break label1508;
              }
              paramView = paramView.Tmu;
              if (paramView == null) {
                break label1508;
              }
              if (((Collection)paramView).isEmpty()) {
                break label1498;
              }
              paramInt = 1;
              if (paramInt == 0) {
                break label1503;
              }
              if (paramView == null) {
                break label1508;
              }
              paramView = ((e.b)((aa.f)localObject2).aaBC).vsH;
              if (paramView != null) {
                paramView.setVisibility(0);
              }
              paramView = ((e.b)((aa.f)localObject2).aaBC).vsI;
              if (paramView != null) {
                paramView.setVisibility(0);
              }
              paramView = ((e)localObject1).vsB;
              if (paramView == null) {
                break label1589;
              }
              paramView = paramView.Tmu;
              if (paramView == null) {
                break label1589;
              }
              paramView = ((Iterable)paramView).iterator();
              if (!paramView.hasNext()) {
                break label1589;
              }
              localObject3 = (emg)paramView.next();
              localf = new aa.f();
              localf.aaBC = ((e)localObject1).getActivity().getLayoutInflater().inflate(R.i.egD, (ViewGroup)((e.b)((aa.f)localObject2).aaBC).vsH, false);
              localObject4 = ((View)localf.aaBC).findViewById(R.h.drj);
              p.j(localObject4, "view.findViewById<TextVi…(R.id.appbrand_info_1_tv)");
              ((TextView)localObject4).setText((CharSequence)((emg)localObject3).UoP);
              localObject4 = ((View)localf.aaBC).findViewById(R.h.drk);
              p.j(localObject4, "view.findViewById<TextVi…(R.id.appbrand_info_2_tv)");
              ((TextView)localObject4).setText((CharSequence)String.valueOf(((emg)localObject3).UoQ));
              localObject4 = ((View)localf.aaBC).findViewById(R.h.drl);
              p.j(localObject4, "view.findViewById<TextVi…(R.id.appbrand_info_3_tv)");
              ((TextView)localObject4).setText((CharSequence)((emg)localObject3).UoR);
              localObject4 = (ImageView)((View)localf.aaBC).findViewById(R.h.dri);
              if (!(p.h("21f9d636b41b25be", ((emg)localObject3).appId) ^ true)) {
                break label1555;
              }
              ((q)h.ae(q.class)).b(((emg)localObject3).appId, (q.a)new e.h(localf, (ImageView)localObject4));
            }
          }
        }
        for (;;)
        {
          localObject4 = ((e.b)((aa.f)localObject2).aaBC).vsH;
          if (localObject4 != null) {
            ((LinearLayout)localObject4).addView((View)localf.aaBC);
          }
          ((View)localf.aaBC).setOnClickListener((View.OnClickListener)new e.c((emg)localObject3, (e)localObject1, (aa.f)localObject2));
          break label1110;
          paramInt = 0;
          break;
          label1430:
          paramView = ((e.b)((aa.f)localObject2).aaBC).vsG;
          if (paramView == null) {
            break label849;
          }
          paramView.setTextColor(((e)localObject1).getActivity().getResources().getColor(R.e.dks));
          break label849;
          label1467:
          paramView = ((e.b)((aa.f)localObject2).aaBC).vsK;
          if (paramView == null) {
            break label890;
          }
          paramView.setImageResource(R.k.device_rank_item_unliked);
          break label890;
          label1493:
          paramInt = 0;
          break label967;
          label1498:
          paramInt = 0;
          break label1031;
          label1503:
          paramView = null;
          break label1035;
          label1508:
          paramView = ((e.b)((aa.f)localObject2).aaBC).vsH;
          if (paramView != null) {
            paramView.setVisibility(8);
          }
          paramView = ((e.b)((aa.f)localObject2).aaBC).vsI;
          if (paramView == null) {
            break label1081;
          }
          paramView.setVisibility(8);
          break label1081;
          label1555:
          ((TextView)((View)localf.aaBC).findViewById(R.h.drn)).setText(R.l.eTD);
          ((ImageView)localObject4).setImageResource(R.k.icons_outlined_apple_watch);
        }
        label1589:
        paramView = ((e.b)((aa.f)localObject2).aaBC).vsJ;
        if (paramView != null) {
          paramView.setOnClickListener((View.OnClickListener)new e.i((e)localObject1, str));
        }
        paramView = ((e.b)((aa.f)localObject2).aaBC).tXu;
        if (paramView != null) {
          paramView.setOnClickListener((View.OnClickListener)new e.j((e)localObject1, str));
        }
        if ((p.h(str, z.bcZ()) ^ true))
        {
          paramView = ((e)localObject1).vsB;
          if ((paramView == null) || (paramView.vih != true))
          {
            paramView = ((e.b)((aa.f)localObject2).aaBC).vsL;
            if (paramView != null) {
              paramView.setVisibility(0);
            }
            paramView = ((e.b)((aa.f)localObject2).aaBC).vsL;
            if (paramView == null) {
              continue;
            }
            paramView.setOnClickListener((View.OnClickListener)new e.e((e)localObject1));
            continue;
          }
        }
        paramView = ((e.b)((aa.f)localObject2).aaBC).vsL;
        if (paramView != null) {
          paramView.setVisibility(8);
        }
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    if (this.vos) {
      return 2;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.a
 * JD-Core Version:    0.7.0.1
 */