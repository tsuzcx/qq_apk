package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.appbrand.appusage.ap;
import com.tencent.mm.plugin.appbrand.appusage.ap.c;
import com.tencent.mm.plugin.appbrand.appusage.ap.e;
import com.tencent.mm.plugin.appbrand.appusage.v;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.au.d;
import com.tencent.mm.plugin.appbrand.au.e;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;

public class h
  extends a
  implements a.a
{
  ViewGroup qoE;
  private final List<a> rff;
  private final List<Class<? extends a>> rfg;
  private boolean rfh;
  private boolean rfi;
  private int rfj;
  private final ap rfk;
  private final b rfl;
  
  public h(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    AppMethodBeat.i(276716);
    this.rfg = new LinkedList();
    this.rfi = false;
    this.rfj = 2;
    if ((paramFragmentActivity == null) || (paramViewGroup == null))
    {
      paramFragmentActivity = new IllegalStateException("Unexpected parameters");
      AppMethodBeat.o(276716);
      throw paramFragmentActivity;
    }
    this.rfl = new b(paramFragmentActivity, (byte)0);
    this.rfh = paramBoolean;
    paramViewGroup = new LinearLayout(paramViewGroup.getContext());
    paramViewGroup.setOrientation(1);
    this.qoE = paramViewGroup;
    this.rff = a(paramFragmentActivity, this.qoE);
    a(this.rff, this.qoE);
    bS(this.rff);
    CX(0);
    this.rfk = new ap();
    clp();
    paramFragmentActivity = (ap.e)com.tencent.mm.plugin.appbrand.utils.h.cQ(new ap.e(this.rfk));
    com.tencent.mm.modelgeo.d.blq().b((b.a)paramFragmentActivity, false);
    AppMethodBeat.o(276716);
  }
  
  private void a(List<a> paramList, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(49150);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(49150);
      return;
    }
    if (paramViewGroup == null)
    {
      AppMethodBeat.o(49150);
      return;
    }
    int i = 0;
    if (i < paramList.size())
    {
      localObject1 = (a)paramList.get(i);
      paramViewGroup.addView(((a)localObject1).getItemView());
      if (i == this.rfj) {
        paramViewGroup.addView(new a(paramViewGroup.getContext()), -1, this.rfl.rfp);
      }
      for (;;)
      {
        i += 1;
        break;
        if (i != paramList.size() - 1)
        {
          if (i != 0) {
            paramList.get(i - 1);
          }
          localObject2 = (a)paramList.get(i + 1);
          if ((this.rfg.contains(localObject1.getClass())) || (this.rfg.contains(localObject2.getClass())))
          {
            localObject1 = new LinearLayout(paramViewGroup.getContext());
            ((LinearLayout)localObject1).setOrientation(1);
            m((ViewGroup)localObject1);
            paramViewGroup.addView((View)localObject1, -1, -2);
          }
          else
          {
            Object localObject3;
            if (this.rfh)
            {
              int j = paramViewGroup.getContext().getResources().getDimensionPixelOffset(au.d.app_brand_recommend_item_line_height);
              int k = paramViewGroup.getContext().getResources().getDimensionPixelOffset(au.d.app_brand_recommend_item_card_margin);
              localObject1 = new LinearLayout(paramViewGroup.getContext());
              ((LinearLayout)localObject1).setOrientation(0);
              paramViewGroup.addView((View)localObject1, -1, -2);
              localObject2 = paramViewGroup.getContext();
              localObject3 = new View((Context)localObject2);
              ((View)localObject3).setBackgroundColor(((Context)localObject2).getResources().getColor(au.c.BG_2));
              LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(k, j);
              localLayoutParams.gravity = 3;
              ((LinearLayout)localObject1).addView((View)localObject3, localLayoutParams);
              localObject3 = new View((Context)localObject2);
              ((View)localObject3).setBackgroundColor(paramViewGroup.getResources().getColor(au.c.app_brand_recommend_card_header_line_color));
              localLayoutParams = new LinearLayout.LayoutParams(0, j, 1.0F);
              localLayoutParams.gravity = 17;
              ((LinearLayout)localObject1).addView((View)localObject3, localLayoutParams);
              localObject3 = new View((Context)localObject2);
              ((View)localObject3).setBackgroundColor(((Context)localObject2).getResources().getColor(au.c.BG_2));
              localObject2 = new LinearLayout.LayoutParams(k, j);
              ((LinearLayout.LayoutParams)localObject2).gravity = 5;
              ((LinearLayout)localObject1).addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
            }
            else
            {
              localObject1 = paramViewGroup.getContext();
              localObject2 = new View((Context)localObject1);
              localObject3 = new LinearLayout((Context)localObject1);
              ((LinearLayout)localObject3).setPadding(this.rfl.rfn, 0, 0, 0);
              ((LinearLayout)localObject3).setBackgroundResource(au.c.BG_2);
              ((LinearLayout)localObject3).addView((View)localObject2, new LinearLayout.LayoutParams(-1, this.rfl.rfm));
              ((View)localObject2).setBackgroundColor(((Context)localObject1).getResources().getColor(au.c.FG_3));
              new LinearLayout.LayoutParams(this.rfl.rfn, this.rfl.rfm).gravity = 3;
              paramViewGroup.addView((View)localObject3, new LinearLayout.LayoutParams(-1, -2));
            }
          }
        }
      }
    }
    paramList = paramViewGroup.getContext();
    Object localObject1 = new ColorDrawable(this.rfl.rfq);
    Object localObject2 = new ImageView(paramList);
    if ((this.rfh) || (!this.rfi)) {
      ((ImageView)localObject2).setBackgroundColor(0);
    }
    for (;;)
    {
      paramViewGroup.addView((View)localObject2, 0, new LinearLayout.LayoutParams(-1, this.rfl.rfr));
      m(paramViewGroup);
      AppMethodBeat.o(49150);
      return;
      ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
      ((ImageView)localObject2).setBackgroundColor(paramList.getResources().getColor(au.c.BG_2));
    }
  }
  
  protected static void a(List<a> paramList, a parama)
  {
    AppMethodBeat.i(49145);
    if (parama != null) {
      paramList.add(parama);
    }
    AppMethodBeat.o(49145);
  }
  
  private static void bS(List<a> paramList)
  {
    AppMethodBeat.i(49151);
    if (paramList == null)
    {
      AppMethodBeat.o(49151);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((a)paramList.next()).setViewEnable(false);
    }
    AppMethodBeat.o(49151);
  }
  
  private void clp()
  {
    AppMethodBeat.i(180404);
    Iterator localIterator = this.rff.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (a)localIterator.next();
      if ((localObject1 instanceof ap.c))
      {
        ap localap = this.rfk;
        ap.c localc = (ap.c)localObject1;
        p.k(localc, "receiver");
        synchronized (localap.nQz)
        {
          List localList = (List)localap.nQz.get(localc.bJK());
          localObject1 = localList;
          if (localList == null)
          {
            localObject1 = (List)new ArrayList();
            localap.nQz.put(localc.bJK(), localObject1);
          }
          ((List)localObject1).add(localc);
        }
      }
    }
    AppMethodBeat.o(180404);
  }
  
  private void clq()
  {
    int j = 0;
    AppMethodBeat.i(49158);
    Iterator localIterator = this.rff.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!((a)localIterator.next()).getViewEnable()) {
        break label159;
      }
      i += 1;
    }
    label159:
    for (;;)
    {
      break;
      localIterator = this.rff.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala.getViewEnable())
        {
          if (j == 0) {
            locala.CY(au.e.app_brand_recommend_header_item_selector_top_round);
          }
          for (;;)
          {
            j += 1;
            break;
            if ((j == this.rff.size() - 1) || (j == i - 1)) {
              locala.CY(au.e.app_brand_recommend_header_item_selector_bottom_round);
            } else {
              locala.CY(au.e.app_brand_recommend_header_item_selector_normal);
            }
          }
        }
      }
      AppMethodBeat.o(49158);
      return;
    }
  }
  
  private void m(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(49152);
    FrameLayout localFrameLayout = new FrameLayout(paramViewGroup.getContext());
    Context localContext = localFrameLayout.getContext();
    ColorDrawable localColorDrawable = new ColorDrawable(this.rfl.rfq);
    ImageView localImageView = new ImageView(localContext);
    if ((this.rfh) || (!this.rfi))
    {
      localImageView.setBackgroundColor(0);
      localFrameLayout.addView(localImageView, -1, this.rfl.rfr);
      localFrameLayout.addView(new View(localContext), -1, this.rfl.rfp);
      localImageView = new ImageView(localContext);
      if ((!this.rfh) && (this.rfi)) {
        break label194;
      }
      localImageView.setBackgroundColor(0);
    }
    for (;;)
    {
      localFrameLayout.addView(localImageView, -1, this.rfl.rfr);
      localFrameLayout.setId(au.f.app_brand_launcher_header_bottom_line);
      paramViewGroup.addView(localFrameLayout, -1, -2);
      AppMethodBeat.o(49152);
      return;
      localImageView.setImageDrawable(localColorDrawable);
      localImageView.setBackgroundColor(localContext.getResources().getColor(au.c.Red));
      break;
      label194:
      localImageView.setImageDrawable(localColorDrawable);
      localImageView.setBackgroundColor(localContext.getResources().getColor(au.c.BG_2));
    }
  }
  
  public final void CX(int paramInt)
  {
    AppMethodBeat.i(49156);
    Iterator localIterator = this.rff.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).CX(paramInt);
    }
    AppMethodBeat.o(49156);
  }
  
  public final void CY(int paramInt)
  {
    AppMethodBeat.i(49157);
    clq();
    AppMethodBeat.o(49157);
  }
  
  protected List<a> a(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(276717);
    ArrayList localArrayList = new ArrayList(2);
    Object localObject = new d(paramFragmentActivity, paramViewGroup);
    ((f)localObject).a(this);
    a(localArrayList, (a)localObject);
    a(localArrayList, c(paramFragmentActivity, paramViewGroup));
    localObject = new c(paramFragmentActivity, paramViewGroup);
    ((a)localObject).a(this);
    a(localArrayList, (a)localObject);
    localObject = new e(paramFragmentActivity, paramViewGroup);
    ((f)localObject).a(this);
    a(localArrayList, (a)localObject);
    a(localArrayList, b(paramFragmentActivity, paramViewGroup));
    AppMethodBeat.o(276717);
    return localArrayList;
  }
  
  public final void a(a parama, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(49159);
    if (this.qoE == null)
    {
      AppMethodBeat.o(49159);
      return;
    }
    Log.i("AppBrandLauncherRecentsListHeaderController", "onViewEnabledChanged [%s] [%s] [%b]", new Object[] { parama, paramView, Boolean.valueOf(paramBoolean) });
    if ((this.qoE == null) || (this.rff == null)) {
      paramView = this.rff.iterator();
    }
    Object localObject;
    int i;
    label128:
    label141:
    label164:
    boolean bool;
    for (;;)
    {
      if (paramView.hasNext())
      {
        localObject = ((a)paramView.next()).getItemView();
        if ((localObject != null) && (((View)localObject).getVisibility() == 0))
        {
          Log.i("AppBrandLauncherRecentsListHeaderController", "hasValidHeader %s", new Object[] { parama });
          i = 1;
          if (i != 0)
          {
            this.qoE.setVisibility(0);
            if (this.rfh) {
              clq();
            }
            AppMethodBeat.o(49159);
            return;
            i = 0;
            paramBoolean = false;
            if (i < this.rff.size() - 1)
            {
              paramView = (a)this.rff.get(i);
              bool = paramBoolean;
              if (paramView != null)
              {
                if (paramBoolean) {
                  break label399;
                }
                paramBoolean = paramView.getViewEnable();
              }
            }
          }
        }
      }
    }
    label270:
    label399:
    for (;;)
    {
      if (!paramView.getViewEnable())
      {
        localObject = this.qoE.getChildAt(this.qoE.indexOfChild(paramView.getItemView()) + 1);
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
        if ((!(localObject instanceof a)) || (!paramBoolean)) {}
      }
      else
      {
        j = i + 1;
        if (j >= this.rff.size()) {
          break label393;
        }
        localObject = (a)this.rff.get(j);
        if ((localObject == null) || (!((a)localObject).getViewEnable())) {
          break label366;
        }
      }
      for (int j = 1;; j = 0)
      {
        if (j != 0)
        {
          paramView = this.qoE.getChildAt(this.qoE.indexOfChild(paramView.getItemView()) + 1);
          if (paramView != null) {
            paramView.setVisibility(0);
          }
        }
        bool = paramBoolean;
        i += 1;
        paramBoolean = bool;
        break label164;
        break;
        label366:
        j += 1;
        break label270;
        this.qoE.setVisibility(8);
        break label141;
        i = 0;
        break label128;
      }
    }
  }
  
  protected a b(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(276719);
    v.bJB();
    paramFragmentActivity = new b(paramFragmentActivity, paramViewGroup);
    paramFragmentActivity.a(this);
    AppMethodBeat.o(276719);
    return paramFragmentActivity;
  }
  
  protected a c(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(276721);
    paramFragmentActivity = new j(paramFragmentActivity, paramViewGroup);
    paramFragmentActivity.a(this);
    AppMethodBeat.o(276721);
    return paramFragmentActivity;
  }
  
  public final void cfx()
  {
    AppMethodBeat.i(49153);
    Iterator localIterator = this.rff.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).cfx();
    }
    AppMethodBeat.o(49153);
  }
  
  public final void cfy()
  {
    AppMethodBeat.i(49154);
    Iterator localIterator = this.rff.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).cfy();
    }
    this.rff.clear();
    this.rfk.nQz.clear();
    AppMethodBeat.o(49154);
  }
  
  public final View getItemView()
  {
    return this.qoE;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(180408);
    Iterator localIterator = this.rff.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onPause();
    }
    AppMethodBeat.o(180408);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(49155);
    Iterator localIterator = this.rff.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onResume();
    }
    AppMethodBeat.o(49155);
  }
  
  static final class a
    extends View
  {
    public a(Context paramContext)
    {
      super();
    }
  }
  
  final class b
  {
    final int rfm;
    final int rfn;
    private final int rfo;
    final int rfp;
    final int rfq;
    final int rfr;
    
    private b(Context paramContext)
    {
      AppMethodBeat.i(49142);
      this.rfm = paramContext.getResources().getDimensionPixelSize(au.d.bottomsheet_dividing_line_height);
      this.rfn = com.tencent.mm.ci.a.fromDPToPix(paramContext, 56);
      this.rfo = 0;
      this.rfp = com.tencent.mm.ci.a.fromDPToPix(paramContext, 8);
      this.rfq = com.tencent.mm.ci.a.w(paramContext, au.c.app_brand_launcher_recents_list_inset_shadow);
      this.rfr = 2;
      AppMethodBeat.o(49142);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.h
 * JD-Core Version:    0.7.0.1
 */