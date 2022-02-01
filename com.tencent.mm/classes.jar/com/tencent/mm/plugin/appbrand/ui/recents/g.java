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
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.appusage.ao;
import com.tencent.mm.plugin.appbrand.appusage.ao.c;
import com.tencent.mm.plugin.appbrand.appusage.u;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.d;
import com.tencent.mm.plugin.appbrand.ba.e;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.g.b.s;

public class g
  extends a
  implements a.a
{
  public ViewGroup tth;
  private final List<a> ung;
  private final List<Class<? extends a>> unh;
  private boolean uni;
  private boolean unj;
  private int unk;
  private final ao unl;
  private final b unm;
  
  public g(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    AppMethodBeat.i(323106);
    this.unh = new LinkedList();
    this.unj = false;
    this.unk = 2;
    if ((paramFragmentActivity == null) || (paramViewGroup == null))
    {
      paramFragmentActivity = new IllegalStateException("Unexpected parameters");
      AppMethodBeat.o(323106);
      throw paramFragmentActivity;
    }
    this.unm = new b(paramFragmentActivity, (byte)0);
    this.uni = paramBoolean;
    paramViewGroup = new LinearLayout(paramViewGroup.getContext());
    paramViewGroup.setOrientation(1);
    this.tth = paramViewGroup;
    this.ung = a(paramFragmentActivity, this.tth);
    a(this.ung, this.tth);
    dJ(this.ung);
    Dt(0);
    this.unl = new ao();
    cMM();
    this.unl.cjn();
    AppMethodBeat.o(323106);
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
      if (i == this.unk) {
        paramViewGroup.addView(new a(paramViewGroup.getContext()), -1, this.unm.unq);
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
          if ((this.unh.contains(localObject1.getClass())) || (this.unh.contains(localObject2.getClass())))
          {
            localObject1 = new LinearLayout(paramViewGroup.getContext());
            ((LinearLayout)localObject1).setOrientation(1);
            p((ViewGroup)localObject1);
            paramViewGroup.addView((View)localObject1, -1, -2);
          }
          else
          {
            Object localObject3;
            if (this.uni)
            {
              int j = paramViewGroup.getContext().getResources().getDimensionPixelOffset(ba.d.app_brand_recommend_item_line_height);
              int k = paramViewGroup.getContext().getResources().getDimensionPixelOffset(ba.d.app_brand_recommend_item_card_margin);
              localObject1 = new LinearLayout(paramViewGroup.getContext());
              ((LinearLayout)localObject1).setOrientation(0);
              paramViewGroup.addView((View)localObject1, -1, -2);
              localObject2 = paramViewGroup.getContext();
              localObject3 = new View((Context)localObject2);
              ((View)localObject3).setBackgroundColor(((Context)localObject2).getResources().getColor(ba.c.BG_2));
              LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(k, j);
              localLayoutParams.gravity = 3;
              ((LinearLayout)localObject1).addView((View)localObject3, localLayoutParams);
              localObject3 = new View((Context)localObject2);
              ((View)localObject3).setBackgroundColor(paramViewGroup.getResources().getColor(ba.c.app_brand_recommend_card_header_line_color));
              localLayoutParams = new LinearLayout.LayoutParams(0, j, 1.0F);
              localLayoutParams.gravity = 17;
              ((LinearLayout)localObject1).addView((View)localObject3, localLayoutParams);
              localObject3 = new View((Context)localObject2);
              ((View)localObject3).setBackgroundColor(((Context)localObject2).getResources().getColor(ba.c.BG_2));
              localObject2 = new LinearLayout.LayoutParams(k, j);
              ((LinearLayout.LayoutParams)localObject2).gravity = 5;
              ((LinearLayout)localObject1).addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
            }
            else
            {
              localObject1 = paramViewGroup.getContext();
              localObject2 = new View((Context)localObject1);
              localObject3 = new LinearLayout((Context)localObject1);
              ((LinearLayout)localObject3).setPadding(this.unm.uno, 0, 0, 0);
              ((LinearLayout)localObject3).setBackgroundResource(ba.c.BG_2);
              ((LinearLayout)localObject3).addView((View)localObject2, new LinearLayout.LayoutParams(-1, this.unm.unn));
              ((View)localObject2).setBackgroundColor(((Context)localObject1).getResources().getColor(ba.c.FG_3));
              new LinearLayout.LayoutParams(this.unm.uno, this.unm.unn).gravity = 3;
              paramViewGroup.addView((View)localObject3, new LinearLayout.LayoutParams(-1, -2));
            }
          }
        }
      }
    }
    paramList = paramViewGroup.getContext();
    Object localObject1 = new ColorDrawable(this.unm.unr);
    Object localObject2 = new ImageView(paramList);
    if ((this.uni) || (!this.unj)) {
      ((ImageView)localObject2).setBackgroundColor(0);
    }
    for (;;)
    {
      paramViewGroup.addView((View)localObject2, 0, new LinearLayout.LayoutParams(-1, this.unm.uns));
      p(paramViewGroup);
      AppMethodBeat.o(49150);
      return;
      ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
      ((ImageView)localObject2).setBackgroundColor(paramList.getResources().getColor(ba.c.BG_2));
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
  
  private void cMM()
  {
    AppMethodBeat.i(180404);
    Iterator localIterator = this.ung.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (a)localIterator.next();
      if ((localObject1 instanceof ao.c))
      {
        ao localao = this.unl;
        ao.c localc = (ao.c)localObject1;
        s.u(localc, "receiver");
        synchronized (localao.qQp)
        {
          List localList = (List)localao.qQp.get(localc.cjo());
          localObject1 = localList;
          if (localList == null)
          {
            localObject1 = (List)new ArrayList();
            localao.qQp.put(localc.cjo(), localObject1);
          }
          ((List)localObject1).add(localc);
        }
      }
    }
    AppMethodBeat.o(180404);
  }
  
  private void cMN()
  {
    int j = 0;
    AppMethodBeat.i(49158);
    Iterator localIterator = this.ung.iterator();
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
      localIterator = this.ung.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala.getViewEnable())
        {
          if (j == 0) {
            locala.Du(ba.e.app_brand_recommend_header_item_selector_top_round);
          }
          for (;;)
          {
            j += 1;
            break;
            if ((j == this.ung.size() - 1) || (j == i - 1)) {
              locala.Du(ba.e.app_brand_recommend_header_item_selector_bottom_round);
            } else {
              locala.Du(ba.e.app_brand_recommend_header_item_selector_normal);
            }
          }
        }
      }
      AppMethodBeat.o(49158);
      return;
    }
  }
  
  private static void dJ(List<a> paramList)
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
  
  private void p(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(49152);
    FrameLayout localFrameLayout = new FrameLayout(paramViewGroup.getContext());
    Context localContext = localFrameLayout.getContext();
    ColorDrawable localColorDrawable = new ColorDrawable(this.unm.unr);
    ImageView localImageView = new ImageView(localContext);
    if ((this.uni) || (!this.unj))
    {
      localImageView.setBackgroundColor(0);
      localFrameLayout.addView(localImageView, -1, this.unm.uns);
      localFrameLayout.addView(new View(localContext), -1, this.unm.unq);
      localImageView = new ImageView(localContext);
      if ((!this.uni) && (this.unj)) {
        break label194;
      }
      localImageView.setBackgroundColor(0);
    }
    for (;;)
    {
      localFrameLayout.addView(localImageView, -1, this.unm.uns);
      localFrameLayout.setId(ba.f.app_brand_launcher_header_bottom_line);
      paramViewGroup.addView(localFrameLayout, -1, -2);
      AppMethodBeat.o(49152);
      return;
      localImageView.setImageDrawable(localColorDrawable);
      localImageView.setBackgroundColor(localContext.getResources().getColor(ba.c.Red));
      break;
      label194:
      localImageView.setImageDrawable(localColorDrawable);
      localImageView.setBackgroundColor(localContext.getResources().getColor(ba.c.BG_2));
    }
  }
  
  public final void Dt(int paramInt)
  {
    AppMethodBeat.i(49156);
    Iterator localIterator = this.ung.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).Dt(paramInt);
    }
    AppMethodBeat.o(49156);
  }
  
  public final void Du(int paramInt)
  {
    AppMethodBeat.i(49157);
    cMN();
    AppMethodBeat.o(49157);
  }
  
  protected List<a> a(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(323146);
    ArrayList localArrayList = new ArrayList(2);
    Object localObject = new c(paramFragmentActivity, paramViewGroup);
    ((e)localObject).a(this);
    a(localArrayList, (a)localObject);
    boolean bool = ((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
    Log.i("AppBrandLauncherRecentsListHeaderController", "isTeenMode: %s", new Object[] { Boolean.valueOf(bool) });
    if (!bool) {
      a(localArrayList, c(paramFragmentActivity, paramViewGroup));
    }
    localObject = new d(paramFragmentActivity, paramViewGroup);
    ((e)localObject).a(this);
    a(localArrayList, (a)localObject);
    a(localArrayList, b(paramFragmentActivity, paramViewGroup));
    AppMethodBeat.o(323146);
    return localArrayList;
  }
  
  public final void a(a parama, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(49159);
    if (this.tth == null)
    {
      AppMethodBeat.o(49159);
      return;
    }
    Log.i("AppBrandLauncherRecentsListHeaderController", "onViewEnabledChanged [%s] [%s] [%b]", new Object[] { parama, paramView, Boolean.valueOf(paramBoolean) });
    if ((this.tth == null) || (this.ung == null)) {
      paramView = this.ung.iterator();
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
            this.tth.setVisibility(0);
            if (this.uni) {
              cMN();
            }
            AppMethodBeat.o(49159);
            return;
            i = 0;
            paramBoolean = false;
            if (i < this.ung.size() - 1)
            {
              paramView = (a)this.ung.get(i);
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
        localObject = this.tth.getChildAt(this.tth.indexOfChild(paramView.getItemView()) + 1);
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
        if ((!(localObject instanceof a)) || (!paramBoolean)) {}
      }
      else
      {
        j = i + 1;
        if (j >= this.ung.size()) {
          break label393;
        }
        localObject = (a)this.ung.get(j);
        if ((localObject == null) || (!((a)localObject).getViewEnable())) {
          break label366;
        }
      }
      for (int j = 1;; j = 0)
      {
        if (j != 0)
        {
          paramView = this.tth.getChildAt(this.tth.indexOfChild(paramView.getItemView()) + 1);
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
        this.tth.setVisibility(8);
        break label141;
        i = 0;
        break label128;
      }
    }
  }
  
  protected a b(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(323152);
    if (u.cjg())
    {
      paramFragmentActivity = new b(paramFragmentActivity, paramViewGroup);
      paramFragmentActivity.a(this);
      AppMethodBeat.o(323152);
      return paramFragmentActivity;
    }
    AppMethodBeat.o(323152);
    return null;
  }
  
  protected a c(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(323156);
    paramFragmentActivity = new i(paramFragmentActivity, paramViewGroup);
    paramFragmentActivity.a(this);
    AppMethodBeat.o(323156);
    return paramFragmentActivity;
  }
  
  public final View getItemView()
  {
    return this.tth;
  }
  
  public final void iQ()
  {
    AppMethodBeat.i(49154);
    Iterator localIterator = this.ung.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).iQ();
    }
    this.ung.clear();
    this.unl.qQp.clear();
    AppMethodBeat.o(49154);
  }
  
  public final void iR()
  {
    AppMethodBeat.i(49153);
    Iterator localIterator = this.ung.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).iR();
    }
    AppMethodBeat.o(49153);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(180408);
    Iterator localIterator = this.ung.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onPause();
    }
    AppMethodBeat.o(180408);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(49155);
    Iterator localIterator = this.ung.iterator();
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
    final int unn;
    final int uno;
    private final int unp;
    final int unq;
    final int unr;
    final int uns;
    
    private b(Context paramContext)
    {
      AppMethodBeat.i(49142);
      this.unn = paramContext.getResources().getDimensionPixelSize(ba.d.bottomsheet_dividing_line_height);
      this.uno = com.tencent.mm.cd.a.fromDPToPix(paramContext, 56);
      this.unp = 0;
      this.unq = com.tencent.mm.cd.a.fromDPToPix(paramContext, 8);
      this.unr = com.tencent.mm.cd.a.w(paramContext, ba.c.app_brand_launcher_recents_list_inset_shadow);
      this.uns = 2;
      AppMethodBeat.o(49142);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.g
 * JD-Core Version:    0.7.0.1
 */