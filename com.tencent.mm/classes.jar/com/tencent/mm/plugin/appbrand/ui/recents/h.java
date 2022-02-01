package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.appbrand.appusage.ap;
import com.tencent.mm.plugin.appbrand.appusage.ap.c;
import com.tencent.mm.plugin.appbrand.appusage.ap.e;
import com.tencent.mm.plugin.appbrand.appusage.v;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class h
  extends a
  implements a.a
{
  private final List<a> mQp;
  private final List<Class<? extends a>> mQq;
  private boolean mQr;
  private boolean mQs;
  private int mQt;
  private final ap mQu;
  private final b mQv;
  ViewGroup mcI;
  
  public h(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    AppMethodBeat.i(180403);
    this.mQq = new LinkedList();
    this.mQs = false;
    this.mQt = 2;
    if ((paramFragmentActivity == null) || (paramViewGroup == null))
    {
      paramFragmentActivity = new IllegalStateException("Unexpected parameters");
      AppMethodBeat.o(180403);
      throw paramFragmentActivity;
    }
    this.mQv = new b(paramFragmentActivity, (byte)0);
    this.mQr = paramBoolean;
    paramViewGroup = new LinearLayout(paramViewGroup.getContext());
    paramViewGroup.setOrientation(1);
    this.mcI = paramViewGroup;
    this.mQp = a(paramFragmentActivity, this.mcI);
    a(this.mQp, this.mcI);
    bH(this.mQp);
    vF(0);
    this.mQu = new ap();
    bBG();
    paramFragmentActivity = (ap.e)f.cI(new ap.e(this.mQu));
    com.tencent.mm.modelgeo.d.aIh().b((b.a)paramFragmentActivity, false);
    AppMethodBeat.o(180403);
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
      paramViewGroup.addView(((a)localObject1).bBp());
      if (i == this.mQt) {
        paramViewGroup.addView(new a(paramViewGroup.getContext()), -1, this.mQv.mQz);
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
          if ((this.mQq.contains(localObject1.getClass())) || (this.mQq.contains(localObject2.getClass())))
          {
            localObject1 = new LinearLayout(paramViewGroup.getContext());
            ((LinearLayout)localObject1).setOrientation(1);
            l((ViewGroup)localObject1);
            paramViewGroup.addView((View)localObject1, -1, -2);
          }
          else
          {
            Object localObject3;
            if (this.mQr)
            {
              int j = paramViewGroup.getContext().getResources().getDimensionPixelOffset(2131165850);
              int k = paramViewGroup.getContext().getResources().getDimensionPixelOffset(2131165840);
              localObject1 = new LinearLayout(paramViewGroup.getContext());
              ((LinearLayout)localObject1).setOrientation(0);
              paramViewGroup.addView((View)localObject1, -1, -2);
              localObject2 = paramViewGroup.getContext();
              localObject3 = new View((Context)localObject2);
              ((View)localObject3).setBackgroundColor(((Context)localObject2).getResources().getColor(2131099650));
              LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(k, j);
              localLayoutParams.gravity = 3;
              ((LinearLayout)localObject1).addView((View)localObject3, localLayoutParams);
              localObject3 = new View((Context)localObject2);
              ((View)localObject3).setBackgroundColor(paramViewGroup.getResources().getColor(2131099960));
              localLayoutParams = new LinearLayout.LayoutParams(0, j, 1.0F);
              localLayoutParams.gravity = 17;
              ((LinearLayout)localObject1).addView((View)localObject3, localLayoutParams);
              localObject3 = new View((Context)localObject2);
              ((View)localObject3).setBackgroundColor(((Context)localObject2).getResources().getColor(2131099650));
              localObject2 = new LinearLayout.LayoutParams(k, j);
              ((LinearLayout.LayoutParams)localObject2).gravity = 5;
              ((LinearLayout)localObject1).addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
            }
            else
            {
              localObject1 = paramViewGroup.getContext();
              localObject2 = new View((Context)localObject1);
              localObject3 = new LinearLayout((Context)localObject1);
              ((LinearLayout)localObject3).setPadding(this.mQv.mQx, 0, 0, 0);
              ((LinearLayout)localObject3).setBackgroundResource(2131099650);
              ((LinearLayout)localObject3).addView((View)localObject2, new LinearLayout.LayoutParams(-1, this.mQv.mQw));
              ((View)localObject2).setBackgroundColor(((Context)localObject1).getResources().getColor(2131099736));
              new LinearLayout.LayoutParams(this.mQv.mQx, this.mQv.mQw).gravity = 3;
              paramViewGroup.addView((View)localObject3, new LinearLayout.LayoutParams(-1, -2));
            }
          }
        }
      }
    }
    paramList = paramViewGroup.getContext();
    Object localObject1 = new ColorDrawable(this.mQv.mQA);
    Object localObject2 = new ImageView(paramList);
    if ((this.mQr) || (!this.mQs)) {
      ((ImageView)localObject2).setBackgroundColor(0);
    }
    for (;;)
    {
      paramViewGroup.addView((View)localObject2, 0, new LinearLayout.LayoutParams(-1, this.mQv.mQB));
      l(paramViewGroup);
      AppMethodBeat.o(49150);
      return;
      ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
      ((ImageView)localObject2).setBackgroundColor(paramList.getResources().getColor(2131099650));
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
  
  private void bBG()
  {
    AppMethodBeat.i(180404);
    Iterator localIterator = this.mQp.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (a)localIterator.next();
      if ((localObject1 instanceof ap.c))
      {
        ap localap = this.mQu;
        ap.c localc = (ap.c)localObject1;
        p.h(localc, "receiver");
        synchronized (localap.jTy)
        {
          List localList = (List)localap.jTy.get(localc.bdh());
          localObject1 = localList;
          if (localList == null)
          {
            localObject1 = (List)new ArrayList();
            localap.jTy.put(localc.bdh(), localObject1);
          }
          ((List)localObject1).add(localc);
        }
      }
    }
    AppMethodBeat.o(180404);
  }
  
  private void bBH()
  {
    int j = 0;
    AppMethodBeat.i(49158);
    Iterator localIterator = this.mQp.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!((a)localIterator.next()).bBq()) {
        break label159;
      }
      i += 1;
    }
    label159:
    for (;;)
    {
      break;
      localIterator = this.mQp.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala.bBq())
        {
          if (j == 0) {
            locala.vG(2131231015);
          }
          for (;;)
          {
            j += 1;
            break;
            if ((j == this.mQp.size() - 1) || (j == i - 1)) {
              locala.vG(2131231013);
            } else {
              locala.vG(2131231014);
            }
          }
        }
      }
      AppMethodBeat.o(49158);
      return;
    }
  }
  
  private static void bH(List<a> paramList)
  {
    AppMethodBeat.i(49151);
    if (paramList == null)
    {
      AppMethodBeat.o(49151);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((a)paramList.next()).hL(false);
    }
    AppMethodBeat.o(49151);
  }
  
  private void l(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(49152);
    FrameLayout localFrameLayout = new FrameLayout(paramViewGroup.getContext());
    Context localContext = localFrameLayout.getContext();
    ColorDrawable localColorDrawable = new ColorDrawable(this.mQv.mQA);
    ImageView localImageView = new ImageView(localContext);
    if ((this.mQr) || (!this.mQs))
    {
      localImageView.setBackgroundColor(0);
      localFrameLayout.addView(localImageView, -1, this.mQv.mQB);
      localFrameLayout.addView(new View(localContext), -1, this.mQv.mQz);
      localImageView = new ImageView(localContext);
      if ((!this.mQr) && (this.mQs)) {
        break label194;
      }
      localImageView.setBackgroundColor(0);
    }
    for (;;)
    {
      localFrameLayout.addView(localImageView, -1, this.mQv.mQB);
      localFrameLayout.setId(2131296764);
      paramViewGroup.addView(localFrameLayout, -1, -2);
      AppMethodBeat.o(49152);
      return;
      localImageView.setImageDrawable(localColorDrawable);
      localImageView.setBackgroundColor(localContext.getResources().getColor(2131099803));
      break;
      label194:
      localImageView.setImageDrawable(localColorDrawable);
      localImageView.setBackgroundColor(localContext.getResources().getColor(2131099650));
    }
  }
  
  protected List<a> a(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(180405);
    ArrayList localArrayList = new ArrayList(2);
    Object localObject = new d(paramFragmentActivity, paramViewGroup);
    ((a)localObject).mOm = this;
    a(localArrayList, (a)localObject);
    a(localArrayList, c(paramFragmentActivity, paramViewGroup));
    localObject = new c(paramFragmentActivity, paramViewGroup);
    ((a)localObject).mOm = this;
    a(localArrayList, (a)localObject);
    localObject = new e(paramFragmentActivity, paramViewGroup);
    ((a)localObject).mOm = this;
    a(localArrayList, (a)localObject);
    a(localArrayList, b(paramFragmentActivity, paramViewGroup));
    AppMethodBeat.o(180405);
    return localArrayList;
  }
  
  public final void a(a parama, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(49159);
    if (this.mcI == null)
    {
      AppMethodBeat.o(49159);
      return;
    }
    ae.i("AppBrandLauncherRecentsListHeaderController", "onViewEnabledChanged [%s] [%s] [%b]", new Object[] { parama, paramView, Boolean.valueOf(paramBoolean) });
    if ((this.mcI == null) || (this.mQp == null)) {
      paramView = this.mQp.iterator();
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
        localObject = ((a)paramView.next()).bBp();
        if ((localObject != null) && (((View)localObject).getVisibility() == 0))
        {
          ae.i("AppBrandLauncherRecentsListHeaderController", "hasValidHeader %s", new Object[] { parama });
          i = 1;
          if (i != 0)
          {
            this.mcI.setVisibility(0);
            if (this.mQr) {
              bBH();
            }
            AppMethodBeat.o(49159);
            return;
            i = 0;
            paramBoolean = false;
            if (i < this.mQp.size() - 1)
            {
              paramView = (a)this.mQp.get(i);
              bool = paramBoolean;
              if (paramView != null)
              {
                if (paramBoolean) {
                  break label399;
                }
                paramBoolean = paramView.bBq();
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
      if (!paramView.bBq())
      {
        localObject = this.mcI.getChildAt(this.mcI.indexOfChild(paramView.bBp()) + 1);
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
        if ((!(localObject instanceof a)) || (!paramBoolean)) {}
      }
      else
      {
        j = i + 1;
        if (j >= this.mQp.size()) {
          break label393;
        }
        localObject = (a)this.mQp.get(j);
        if ((localObject == null) || (!((a)localObject).bBq())) {
          break label366;
        }
      }
      for (int j = 1;; j = 0)
      {
        if (j != 0)
        {
          paramView = this.mcI.getChildAt(this.mcI.indexOfChild(paramView.bBp()) + 1);
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
        this.mcI.setVisibility(8);
        break label141;
        i = 0;
        break label128;
      }
    }
  }
  
  protected a b(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(180406);
    v.bcY();
    paramFragmentActivity = new b(paramFragmentActivity, paramViewGroup);
    paramFragmentActivity.mOm = this;
    AppMethodBeat.o(180406);
    return paramFragmentActivity;
  }
  
  public final View bBp()
  {
    return this.mcI;
  }
  
  public final void bwp()
  {
    AppMethodBeat.i(49153);
    Iterator localIterator = this.mQp.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).bwp();
    }
    AppMethodBeat.o(49153);
  }
  
  protected a c(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(180407);
    paramFragmentActivity = new j(paramFragmentActivity, paramViewGroup);
    paramFragmentActivity.mOm = this;
    AppMethodBeat.o(180407);
    return paramFragmentActivity;
  }
  
  public final void onDetached()
  {
    AppMethodBeat.i(49154);
    Iterator localIterator = this.mQp.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onDetached();
    }
    this.mQp.clear();
    this.mQu.jTy.clear();
    AppMethodBeat.o(49154);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(180408);
    Iterator localIterator = this.mQp.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onPause();
    }
    AppMethodBeat.o(180408);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(49155);
    Iterator localIterator = this.mQp.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onResume();
    }
    AppMethodBeat.o(49155);
  }
  
  public final void vF(int paramInt)
  {
    AppMethodBeat.i(49156);
    Iterator localIterator = this.mQp.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).vF(paramInt);
    }
    AppMethodBeat.o(49156);
  }
  
  public final void vG(int paramInt)
  {
    AppMethodBeat.i(49157);
    bBH();
    AppMethodBeat.o(49157);
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
    final int mQA;
    final int mQB;
    final int mQw;
    final int mQx;
    private final int mQy;
    final int mQz;
    
    private b(Context paramContext)
    {
      AppMethodBeat.i(49142);
      this.mQw = paramContext.getResources().getDimensionPixelSize(2131165923);
      this.mQx = com.tencent.mm.cb.a.fromDPToPix(paramContext, 56);
      this.mQy = 0;
      this.mQz = com.tencent.mm.cb.a.fromDPToPix(paramContext, 8);
      this.mQA = com.tencent.mm.cb.a.n(paramContext, 2131099950);
      this.mQB = 2;
      AppMethodBeat.o(49142);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.h
 * JD-Core Version:    0.7.0.1
 */