package com.tencent.mm.plugin.appbrand.ui.recents;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.t;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class f
  extends a
  implements a.a
{
  private final List<a> iTU;
  private final List<Class<? extends a>> iTV;
  private boolean iTW;
  private final f.a iTX;
  ViewGroup iux;
  
  public f(Activity paramActivity, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(133417);
    this.iTV = new LinkedList();
    if ((paramActivity == null) || (paramViewGroup == null))
    {
      paramActivity = new IllegalStateException("Unexpected parameters");
      AppMethodBeat.o(133417);
      throw paramActivity;
    }
    this.iTX = new f.a(this, paramActivity, (byte)0);
    this.iTW = paramBoolean2;
    paramViewGroup = new LinearLayout(paramViewGroup.getContext());
    paramViewGroup.setOrientation(1);
    this.iux = paramViewGroup;
    this.iTU = a(paramActivity, this.iux, paramBoolean1);
    a(this.iTU, this.iux);
    aM(this.iTU);
    AppMethodBeat.o(133417);
  }
  
  private void a(List<a> paramList, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(133424);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(133424);
      return;
    }
    if (paramViewGroup == null)
    {
      AppMethodBeat.o(133424);
      return;
    }
    int i = 0;
    if (i < paramList.size())
    {
      localObject1 = (a)paramList.get(i);
      paramViewGroup.addView(((a)localObject1).aNe());
      Object localObject2;
      if (i != paramList.size() - 1)
      {
        if (i != 0) {
          paramList.get(i - 1);
        }
        localObject2 = (a)paramList.get(i + 1);
        if ((!this.iTV.contains(localObject1.getClass())) && (!this.iTV.contains(localObject2.getClass()))) {
          break label182;
        }
        localObject1 = new LinearLayout(paramViewGroup.getContext());
        ((LinearLayout)localObject1).setOrientation(1);
        j((ViewGroup)localObject1);
        paramViewGroup.addView((View)localObject1, -1, -2);
      }
      for (;;)
      {
        i += 1;
        break;
        label182:
        if (this.iTW)
        {
          int j = paramViewGroup.getContext().getResources().getDimensionPixelOffset(2131428077);
          int k = paramViewGroup.getContext().getResources().getDimensionPixelOffset(2131428067);
          localObject1 = new LinearLayout(paramViewGroup.getContext());
          ((LinearLayout)localObject1).setOrientation(0);
          paramViewGroup.addView((View)localObject1, -1, -2);
          localObject2 = paramViewGroup.getContext();
          Object localObject3 = new View((Context)localObject2);
          ((View)localObject3).setBackgroundColor(-1);
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(k, j);
          localLayoutParams.gravity = 3;
          ((LinearLayout)localObject1).addView((View)localObject3, localLayoutParams);
          localObject3 = new View((Context)localObject2);
          ((View)localObject3).setBackgroundColor(paramViewGroup.getResources().getColor(2131689718));
          localLayoutParams = new LinearLayout.LayoutParams(0, j, 1.0F);
          localLayoutParams.gravity = 17;
          ((LinearLayout)localObject1).addView((View)localObject3, localLayoutParams);
          localObject2 = new View((Context)localObject2);
          ((View)localObject2).setBackgroundColor(-1);
          localObject3 = new LinearLayout.LayoutParams(k, j);
          ((LinearLayout.LayoutParams)localObject3).gravity = 5;
          ((LinearLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        }
        else
        {
          localObject1 = new View(paramViewGroup.getContext());
          ((View)localObject1).setBackgroundColor(-1);
          localObject2 = new LinearLayout.LayoutParams(this.iTX.iTZ, this.iTX.iTY);
          ((LinearLayout.LayoutParams)localObject2).gravity = 3;
          paramViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        }
      }
    }
    Object localObject1 = paramViewGroup.getContext();
    paramList = new ColorDrawable(this.iTX.iUc);
    localObject1 = new ImageView((Context)localObject1);
    if (this.iTW) {
      ((ImageView)localObject1).setBackgroundColor(0);
    }
    for (;;)
    {
      paramViewGroup.addView((View)localObject1, 0, new LinearLayout.LayoutParams(-1, this.iTX.iUd));
      j(paramViewGroup);
      AppMethodBeat.o(133424);
      return;
      ((ImageView)localObject1).setImageDrawable(paramList);
      ((ImageView)localObject1).setBackgroundColor(-1);
    }
  }
  
  protected static void a(List<a> paramList, a parama)
  {
    AppMethodBeat.i(133419);
    if (parama != null) {
      paramList.add(parama);
    }
    AppMethodBeat.o(133419);
  }
  
  private static void aM(List<a> paramList)
  {
    AppMethodBeat.i(133425);
    if (paramList == null)
    {
      AppMethodBeat.o(133425);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((a)paramList.next()).eR(false);
    }
    AppMethodBeat.o(133425);
  }
  
  private void aNp()
  {
    int j = 0;
    AppMethodBeat.i(133432);
    Iterator localIterator = this.iTU.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!((a)localIterator.next()).aNf()) {
        break label154;
      }
      i += 1;
    }
    label154:
    for (;;)
    {
      break;
      localIterator = this.iTU.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala.aNf())
        {
          if (j == 0) {
            locala.pG(2130837769);
          }
          for (;;)
          {
            j += 1;
            break;
            if ((j == this.iTU.size() - 1) || (j == i - 1)) {
              locala.pG(2130837767);
            } else {
              locala.pG(2130837768);
            }
          }
        }
      }
      AppMethodBeat.o(133432);
      return;
    }
  }
  
  private void j(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(133426);
    FrameLayout localFrameLayout = new FrameLayout(paramViewGroup.getContext());
    Object localObject = localFrameLayout.getContext();
    ColorDrawable localColorDrawable = new ColorDrawable(this.iTX.iUc);
    ImageView localImageView = new ImageView((Context)localObject);
    if (this.iTW)
    {
      localImageView.setBackgroundColor(0);
      localFrameLayout.addView(localImageView, -1, this.iTX.iUd);
      localFrameLayout.addView(new View((Context)localObject), -1, this.iTX.iUb);
      localObject = new ImageView((Context)localObject);
      if (!this.iTW) {
        break label170;
      }
      ((ImageView)localObject).setBackgroundColor(0);
    }
    for (;;)
    {
      localFrameLayout.addView((View)localObject, -1, this.iTX.iUd);
      localFrameLayout.setId(2131820562);
      paramViewGroup.addView(localFrameLayout, -1, -2);
      AppMethodBeat.o(133426);
      return;
      localImageView.setImageDrawable(localColorDrawable);
      localImageView.setBackgroundColor(-1);
      break;
      label170:
      ((ImageView)localObject).setImageDrawable(localColorDrawable);
      ((ImageView)localObject).setBackgroundColor(-1);
    }
  }
  
  protected a a(Activity paramActivity, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(133420);
    paramActivity = new j(paramActivity, paramViewGroup);
    paramActivity.iSl = this;
    AppMethodBeat.o(133420);
    return paramActivity;
  }
  
  protected List<a> a(Activity paramActivity, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    AppMethodBeat.i(133418);
    ArrayList localArrayList = new ArrayList(2);
    a(localArrayList, b(paramActivity, paramViewGroup, paramBoolean));
    a(localArrayList, c(paramActivity, paramViewGroup));
    a(localArrayList, b(paramActivity, paramViewGroup));
    a(localArrayList, a(paramActivity, paramViewGroup));
    AppMethodBeat.o(133418);
    return localArrayList;
  }
  
  public final void a(a parama, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(133433);
    if (this.iux == null)
    {
      AppMethodBeat.o(133433);
      return;
    }
    ab.i("AppBrandLauncherRecentsListHeaderController", "onViewEnabledChanged [%s] [%s] [%b]", new Object[] { parama, paramView, Boolean.valueOf(paramBoolean) });
    if ((this.iux == null) || (this.iTU == null)) {
      paramView = this.iTU.iterator();
    }
    Object localObject;
    int i;
    for (;;)
    {
      if (paramView.hasNext())
      {
        localObject = ((a)paramView.next()).aNe();
        if ((localObject != null) && (((View)localObject).getVisibility() == 0))
        {
          ab.i("AppBrandLauncherRecentsListHeaderController", "hasValidHeader %s", new Object[] { parama });
          i = 1;
          if (i != 0)
          {
            this.iux.setVisibility(0);
            label141:
            if (this.iTW) {
              aNp();
            }
            AppMethodBeat.o(133433);
            return;
            i = 0;
            label162:
            if (i < this.iTU.size() - 1)
            {
              paramView = (a)this.iTU.get(i);
              if (paramView != null)
              {
                if (paramView.aNf()) {
                  break label244;
                }
                paramView = this.iux.getChildAt(this.iux.indexOfChild(paramView.aNe()) + 1);
                if (paramView != null) {
                  paramView.setVisibility(8);
                }
              }
            }
          }
        }
      }
    }
    label235:
    label365:
    for (;;)
    {
      i += 1;
      break label162;
      break;
      label244:
      int j = i + 1;
      label250:
      if (j < this.iTU.size())
      {
        localObject = (a)this.iTU.get(j);
        if ((localObject == null) || (!((a)localObject).aNf())) {}
      }
      for (j = 1;; j = 0)
      {
        if (j == 0) {
          break label365;
        }
        paramView = this.iux.getChildAt(this.iux.indexOfChild(paramView.aNe()) + 1);
        if (paramView == null) {
          break label235;
        }
        paramView.setVisibility(0);
        break label235;
        j += 1;
        break label250;
        this.iux.setVisibility(8);
        break label141;
        i = 0;
        break;
      }
    }
  }
  
  public final void aNd()
  {
    AppMethodBeat.i(133427);
    Iterator localIterator = this.iTU.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).aNd();
    }
    AppMethodBeat.o(133427);
  }
  
  public final View aNe()
  {
    return this.iux;
  }
  
  protected a b(Activity paramActivity, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(133421);
    t.axz();
    paramActivity = new b(paramActivity, paramViewGroup);
    paramActivity.iSl = this;
    AppMethodBeat.o(133421);
    return paramActivity;
  }
  
  protected a b(Activity paramActivity, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    AppMethodBeat.i(133423);
    if (paramBoolean)
    {
      paramActivity = new c(paramActivity, paramViewGroup);
      paramActivity.iSl = this;
      AppMethodBeat.o(133423);
      return paramActivity;
    }
    AppMethodBeat.o(133423);
    return null;
  }
  
  protected a c(Activity paramActivity, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(133422);
    paramActivity = new i(paramActivity, paramViewGroup);
    paramActivity.iSl = this;
    AppMethodBeat.o(133422);
    return paramActivity;
  }
  
  public final void eS(boolean paramBoolean) {}
  
  public final void onDetached()
  {
    AppMethodBeat.i(133428);
    Iterator localIterator = this.iTU.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onDetached();
    }
    this.iTU.clear();
    AppMethodBeat.o(133428);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(133429);
    Iterator localIterator = this.iTU.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onResume();
    }
    AppMethodBeat.o(133429);
  }
  
  public final void pF(int paramInt)
  {
    AppMethodBeat.i(133430);
    Iterator localIterator = this.iTU.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).pF(paramInt);
    }
    AppMethodBeat.o(133430);
  }
  
  public final void pG(int paramInt)
  {
    AppMethodBeat.i(133431);
    aNp();
    AppMethodBeat.o(133431);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.f
 * JD-Core Version:    0.7.0.1
 */