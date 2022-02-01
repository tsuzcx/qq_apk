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
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class h
  extends a
  implements a.a
{
  ViewGroup lyD;
  private final List<a> mkL;
  private final List<Class<? extends a>> mkM;
  private boolean mkN;
  private boolean mkO;
  private int mkP;
  private final ap mkQ;
  private final b mkR;
  
  public h(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    AppMethodBeat.i(180403);
    this.mkM = new LinkedList();
    this.mkO = false;
    this.mkP = 2;
    if ((paramFragmentActivity == null) || (paramViewGroup == null))
    {
      paramFragmentActivity = new IllegalStateException("Unexpected parameters");
      AppMethodBeat.o(180403);
      throw paramFragmentActivity;
    }
    this.mkR = new b(paramFragmentActivity, (byte)0);
    this.mkN = paramBoolean;
    paramViewGroup = new LinearLayout(paramViewGroup.getContext());
    paramViewGroup.setOrientation(1);
    this.lyD = paramViewGroup;
    this.mkL = a(paramFragmentActivity, this.lyD);
    a(this.mkL, this.lyD);
    bD(this.mkL);
    uV(0);
    this.mkQ = new ap();
    bwG();
    paramFragmentActivity = (ap.e)com.tencent.mm.plugin.appbrand.utils.e.cF(new ap.e(this.mkQ));
    com.tencent.mm.modelgeo.d.aEL().b((b.a)paramFragmentActivity, false);
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
      paramViewGroup.addView(((a)localObject1).bwp());
      if (i == this.mkP) {
        paramViewGroup.addView(new a(paramViewGroup.getContext()), -1, this.mkR.mkV);
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
          if ((this.mkM.contains(localObject1.getClass())) || (this.mkM.contains(localObject2.getClass())))
          {
            localObject1 = new LinearLayout(paramViewGroup.getContext());
            ((LinearLayout)localObject1).setOrientation(1);
            l((ViewGroup)localObject1);
            paramViewGroup.addView((View)localObject1, -1, -2);
          }
          else
          {
            Object localObject3;
            if (this.mkN)
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
              ((LinearLayout)localObject3).setPadding(this.mkR.mkT, 0, 0, 0);
              ((LinearLayout)localObject3).setBackgroundResource(2131099650);
              ((LinearLayout)localObject3).addView((View)localObject2, new LinearLayout.LayoutParams(-1, this.mkR.mkS));
              ((View)localObject2).setBackgroundColor(((Context)localObject1).getResources().getColor(2131099736));
              new LinearLayout.LayoutParams(this.mkR.mkT, this.mkR.mkS).gravity = 3;
              paramViewGroup.addView((View)localObject3, new LinearLayout.LayoutParams(-1, -2));
            }
          }
        }
      }
    }
    paramList = paramViewGroup.getContext();
    Object localObject1 = new ColorDrawable(this.mkR.mkW);
    Object localObject2 = new ImageView(paramList);
    if ((this.mkN) || (!this.mkO)) {
      ((ImageView)localObject2).setBackgroundColor(0);
    }
    for (;;)
    {
      paramViewGroup.addView((View)localObject2, 0, new LinearLayout.LayoutParams(-1, this.mkR.mkX));
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
  
  private static void bD(List<a> paramList)
  {
    AppMethodBeat.i(49151);
    if (paramList == null)
    {
      AppMethodBeat.o(49151);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((a)paramList.next()).hB(false);
    }
    AppMethodBeat.o(49151);
  }
  
  private void bwG()
  {
    AppMethodBeat.i(180404);
    Iterator localIterator = this.mkL.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (a)localIterator.next();
      if ((localObject1 instanceof ap.c))
      {
        ap localap = this.mkQ;
        ap.c localc = (ap.c)localObject1;
        k.h(localc, "receiver");
        synchronized (localap.jwk)
        {
          List localList = (List)localap.jwk.get(localc.aZe());
          localObject1 = localList;
          if (localList == null)
          {
            localObject1 = (List)new ArrayList();
            localap.jwk.put(localc.aZe(), localObject1);
          }
          ((List)localObject1).add(localc);
        }
      }
    }
    AppMethodBeat.o(180404);
  }
  
  private void bwH()
  {
    int j = 0;
    AppMethodBeat.i(49158);
    Iterator localIterator = this.mkL.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!((a)localIterator.next()).bwq()) {
        break label159;
      }
      i += 1;
    }
    label159:
    for (;;)
    {
      break;
      localIterator = this.mkL.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala.bwq())
        {
          if (j == 0) {
            locala.uW(2131231015);
          }
          for (;;)
          {
            j += 1;
            break;
            if ((j == this.mkL.size() - 1) || (j == i - 1)) {
              locala.uW(2131231013);
            } else {
              locala.uW(2131231014);
            }
          }
        }
      }
      AppMethodBeat.o(49158);
      return;
    }
  }
  
  private void l(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(49152);
    FrameLayout localFrameLayout = new FrameLayout(paramViewGroup.getContext());
    Context localContext = localFrameLayout.getContext();
    ColorDrawable localColorDrawable = new ColorDrawable(this.mkR.mkW);
    ImageView localImageView = new ImageView(localContext);
    if ((this.mkN) || (!this.mkO))
    {
      localImageView.setBackgroundColor(0);
      localFrameLayout.addView(localImageView, -1, this.mkR.mkX);
      localFrameLayout.addView(new View(localContext), -1, this.mkR.mkV);
      localImageView = new ImageView(localContext);
      if ((!this.mkN) && (this.mkO)) {
        break label194;
      }
      localImageView.setBackgroundColor(0);
    }
    for (;;)
    {
      localFrameLayout.addView(localImageView, -1, this.mkR.mkX);
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
    ((a)localObject).miJ = this;
    a(localArrayList, (a)localObject);
    a(localArrayList, c(paramFragmentActivity, paramViewGroup));
    localObject = new c(paramFragmentActivity, paramViewGroup);
    ((a)localObject).miJ = this;
    a(localArrayList, (a)localObject);
    localObject = new e(paramFragmentActivity, paramViewGroup);
    ((a)localObject).miJ = this;
    a(localArrayList, (a)localObject);
    a(localArrayList, b(paramFragmentActivity, paramViewGroup));
    AppMethodBeat.o(180405);
    return localArrayList;
  }
  
  public final void a(a parama, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(49159);
    if (this.lyD == null)
    {
      AppMethodBeat.o(49159);
      return;
    }
    ac.i("AppBrandLauncherRecentsListHeaderController", "onViewEnabledChanged [%s] [%s] [%b]", new Object[] { parama, paramView, Boolean.valueOf(paramBoolean) });
    if ((this.lyD == null) || (this.mkL == null)) {
      paramView = this.mkL.iterator();
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
        localObject = ((a)paramView.next()).bwp();
        if ((localObject != null) && (((View)localObject).getVisibility() == 0))
        {
          ac.i("AppBrandLauncherRecentsListHeaderController", "hasValidHeader %s", new Object[] { parama });
          i = 1;
          if (i != 0)
          {
            this.lyD.setVisibility(0);
            if (this.mkN) {
              bwH();
            }
            AppMethodBeat.o(49159);
            return;
            i = 0;
            paramBoolean = false;
            if (i < this.mkL.size() - 1)
            {
              paramView = (a)this.mkL.get(i);
              bool = paramBoolean;
              if (paramView != null)
              {
                if (paramBoolean) {
                  break label399;
                }
                paramBoolean = paramView.bwq();
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
      if (!paramView.bwq())
      {
        localObject = this.lyD.getChildAt(this.lyD.indexOfChild(paramView.bwp()) + 1);
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
        if ((!(localObject instanceof a)) || (!paramBoolean)) {}
      }
      else
      {
        j = i + 1;
        if (j >= this.mkL.size()) {
          break label393;
        }
        localObject = (a)this.mkL.get(j);
        if ((localObject == null) || (!((a)localObject).bwq())) {
          break label366;
        }
      }
      for (int j = 1;; j = 0)
      {
        if (j != 0)
        {
          paramView = this.lyD.getChildAt(this.lyD.indexOfChild(paramView.bwp()) + 1);
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
        this.lyD.setVisibility(8);
        break label141;
        i = 0;
        break label128;
      }
    }
  }
  
  protected a b(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(180406);
    v.aYV();
    paramFragmentActivity = new b(paramFragmentActivity, paramViewGroup);
    paramFragmentActivity.miJ = this;
    AppMethodBeat.o(180406);
    return paramFragmentActivity;
  }
  
  public final void bwo()
  {
    AppMethodBeat.i(49153);
    Iterator localIterator = this.mkL.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).bwo();
    }
    AppMethodBeat.o(49153);
  }
  
  public final View bwp()
  {
    return this.lyD;
  }
  
  protected a c(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(180407);
    paramFragmentActivity = new j(paramFragmentActivity, paramViewGroup);
    paramFragmentActivity.miJ = this;
    AppMethodBeat.o(180407);
    return paramFragmentActivity;
  }
  
  public final void onDetached()
  {
    AppMethodBeat.i(49154);
    Iterator localIterator = this.mkL.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onDetached();
    }
    this.mkL.clear();
    this.mkQ.jwk.clear();
    AppMethodBeat.o(49154);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(180408);
    Iterator localIterator = this.mkL.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onPause();
    }
    AppMethodBeat.o(180408);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(49155);
    Iterator localIterator = this.mkL.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onResume();
    }
    AppMethodBeat.o(49155);
  }
  
  public final void uV(int paramInt)
  {
    AppMethodBeat.i(49156);
    Iterator localIterator = this.mkL.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).uV(paramInt);
    }
    AppMethodBeat.o(49156);
  }
  
  public final void uW(int paramInt)
  {
    AppMethodBeat.i(49157);
    bwH();
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
    final int mkS;
    final int mkT;
    private final int mkU;
    final int mkV;
    final int mkW;
    final int mkX;
    
    private b(Context paramContext)
    {
      AppMethodBeat.i(49142);
      this.mkS = paramContext.getResources().getDimensionPixelSize(2131165923);
      this.mkT = com.tencent.mm.cc.a.fromDPToPix(paramContext, 56);
      this.mkU = 0;
      this.mkV = com.tencent.mm.cc.a.fromDPToPix(paramContext, 8);
      this.mkW = com.tencent.mm.cc.a.n(paramContext, 2131099950);
      this.mkX = 2;
      AppMethodBeat.o(49142);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.h
 * JD-Core Version:    0.7.0.1
 */