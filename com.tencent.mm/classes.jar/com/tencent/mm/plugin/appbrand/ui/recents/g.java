package com.tencent.mm.plugin.appbrand.ui.recents;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.appbrand.appusage.t;
import com.tencent.mm.plugin.appbrand.y.d;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends a
  implements a.a
{
  public ViewGroup gVj;
  private final List<a> hip;
  private final List<Class<? extends a>> hiq = new LinkedList();
  private final a hir;
  
  public g(Activity paramActivity, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if ((paramActivity == null) || (paramViewGroup == null)) {
      throw new IllegalStateException("Unexpected parameters");
    }
    this.hir = new a(paramActivity, (byte)0);
    paramViewGroup = new LinearLayout(paramViewGroup.getContext());
    paramViewGroup.setOrientation(1);
    this.gVj = paramViewGroup;
    ViewGroup localViewGroup = this.gVj;
    paramViewGroup = new ArrayList(2);
    if (paramBoolean)
    {
      localObject = new c(paramActivity, localViewGroup);
      ((a)localObject).hgJ = this;
      paramViewGroup.add(localObject);
    }
    Object localObject = new i(paramActivity, localViewGroup);
    ((a)localObject).hgJ = this;
    paramViewGroup.add(localObject);
    t.adr();
    localObject = new b(paramActivity, localViewGroup);
    ((a)localObject).hgJ = this;
    paramViewGroup.add(localObject);
    paramActivity = new j(paramActivity, localViewGroup);
    paramActivity.hgJ = this;
    paramViewGroup.add(paramActivity);
    this.hip = paramViewGroup;
    a(this.hip, this.gVj);
    aC(this.hip);
  }
  
  private void a(List<a> paramList, ViewGroup paramViewGroup)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    while (paramViewGroup == null) {
      return;
    }
    int i = 0;
    if (i < paramList.size())
    {
      localObject1 = (a)paramList.get(i);
      paramViewGroup.addView(((a)localObject1).apK());
      Object localObject2;
      if (i != paramList.size() - 1)
      {
        if (i != 0) {
          paramList.get(i - 1);
        }
        localObject2 = (a)paramList.get(i + 1);
        if ((!this.hiq.contains(localObject1.getClass())) && (!this.hiq.contains(localObject2.getClass()))) {
          break label166;
        }
        localObject1 = new LinearLayout(paramViewGroup.getContext());
        ((LinearLayout)localObject1).setOrientation(1);
        i((ViewGroup)localObject1);
        paramViewGroup.addView((View)localObject1, -1, -2);
      }
      for (;;)
      {
        i += 1;
        break;
        label166:
        localObject1 = new View(paramViewGroup.getContext());
        ((View)localObject1).setBackgroundColor(-1);
        localObject2 = new LinearLayout.LayoutParams(this.hir.hit, this.hir.his);
        ((LinearLayout.LayoutParams)localObject2).gravity = 3;
        paramViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      }
    }
    Object localObject1 = paramViewGroup.getContext();
    paramList = new ColorDrawable(this.hir.hiw);
    localObject1 = new ImageView((Context)localObject1);
    ((ImageView)localObject1).setImageDrawable(paramList);
    ((ImageView)localObject1).setBackgroundColor(-1);
    paramViewGroup.addView((View)localObject1, 0, new LinearLayout.LayoutParams(-1, this.hir.hix));
    i(paramViewGroup);
  }
  
  private static void aC(List<a> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((a)paramList.next()).dF(false);
      }
    }
  }
  
  private void i(ViewGroup paramViewGroup)
  {
    FrameLayout localFrameLayout = new FrameLayout(paramViewGroup.getContext());
    Object localObject = localFrameLayout.getContext();
    ColorDrawable localColorDrawable = new ColorDrawable(this.hir.hiw);
    ImageView localImageView = new ImageView((Context)localObject);
    localImageView.setImageDrawable(localColorDrawable);
    localImageView.setBackgroundColor(-1);
    localFrameLayout.addView(localImageView, -1, this.hir.hix);
    localFrameLayout.addView(new View((Context)localObject), -1, this.hir.hiv);
    localObject = new ImageView((Context)localObject);
    ((ImageView)localObject).setImageDrawable(localColorDrawable);
    ((ImageView)localObject).setBackgroundColor(-1);
    localFrameLayout.addView((View)localObject, -1, this.hir.hix);
    localFrameLayout.setId(y.g.app_brand_launcher_header_bottom_line);
    paramViewGroup.addView(localFrameLayout, -1, -2);
  }
  
  public final void a(a parama, View paramView, boolean paramBoolean)
  {
    if (this.gVj == null) {
      return;
    }
    y.i("AppBrandLauncherRecentsListHeaderController", "onViewEnabledChanged [%s] [%s] [%b]", new Object[] { parama, paramView, Boolean.valueOf(paramBoolean) });
    if ((this.gVj == null) || (this.hip == null)) {
      paramView = this.hip.iterator();
    }
    Object localObject;
    int i;
    for (;;)
    {
      if (paramView.hasNext())
      {
        localObject = ((a)paramView.next()).apK();
        if ((localObject != null) && (((View)localObject).getVisibility() == 0))
        {
          y.i("AppBrandLauncherRecentsListHeaderController", "hasValidHeader %s", new Object[] { parama });
          i = 1;
          if (i != 0)
          {
            this.gVj.setVisibility(0);
            return;
            i = 0;
            label129:
            if (i < this.hip.size() - 1)
            {
              paramView = (a)this.hip.get(i);
              if (paramView != null)
              {
                if (paramView.apL()) {
                  break label211;
                }
                paramView = this.gVj.getChildAt(this.gVj.indexOfChild(paramView.apK()) + 1);
                if (paramView != null) {
                  paramView.setVisibility(8);
                }
              }
            }
          }
        }
      }
    }
    label202:
    label330:
    for (;;)
    {
      i += 1;
      break label129;
      break;
      label211:
      int j = i + 1;
      label217:
      if (j < this.hip.size())
      {
        localObject = (a)this.hip.get(j);
        if ((localObject == null) || (!((a)localObject).apL())) {}
      }
      for (j = 1;; j = 0)
      {
        if (j == 0) {
          break label330;
        }
        paramView = this.gVj.getChildAt(this.gVj.indexOfChild(paramView.apK()) + 1);
        if (paramView == null) {
          break label202;
        }
        paramView.setVisibility(0);
        break label202;
        j += 1;
        break label217;
        this.gVj.setVisibility(8);
        return;
        i = 0;
        break;
      }
    }
  }
  
  public final void apJ()
  {
    Iterator localIterator = this.hip.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).apJ();
    }
  }
  
  public final View apK()
  {
    return this.gVj;
  }
  
  public final void onDetached()
  {
    Iterator localIterator = this.hip.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onDetached();
    }
    this.hip.clear();
  }
  
  public final void onResume()
  {
    Iterator localIterator = this.hip.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onResume();
    }
  }
  
  private final class a
  {
    final int his;
    final int hit;
    private final int hiu;
    final int hiv;
    final int hiw;
    final int hix;
    
    private a(Context paramContext)
    {
      this.his = com.tencent.mm.plugin.appbrand.v.c.cz(paramContext);
      this.hit = com.tencent.mm.cb.a.fromDPToPix(paramContext, 20);
      this.hiu = 0;
      this.hiv = com.tencent.mm.cb.a.fromDPToPix(paramContext, 12);
      this.hiw = com.tencent.mm.cb.a.i(paramContext, y.d.app_brand_launcher_recents_list_inset_shadow);
      this.hix = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.g
 * JD-Core Version:    0.7.0.1
 */