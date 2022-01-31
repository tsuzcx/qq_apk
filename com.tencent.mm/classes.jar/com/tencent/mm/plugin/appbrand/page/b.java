package com.tencent.mm.plugin.appbrand.page;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.mm.compatible.util.d;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class b
{
  private int adN;
  private View gSt;
  WebChromeClient.CustomViewCallback gSu;
  private int gSv = 0;
  final Set<ae> gSw = Collections.newSetFromMap(new ConcurrentHashMap());
  private Context mContext;
  
  b(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void amR()
  {
    Iterator localIterator = this.gSw.iterator();
    while (localIterator.hasNext()) {
      ((ae)localIterator.next()).anw();
    }
  }
  
  final void a(ae paramae)
  {
    this.gSw.add(paramae);
  }
  
  final boolean amQ()
  {
    if (this.gSt == null) {
      return false;
    }
    if (this.gSu != null) {
      this.gSu.onCustomViewHidden();
    }
    Object localObject = (Activity)this.mContext;
    ViewGroup localViewGroup = (ViewGroup)((Activity)localObject).getWindow().getDecorView();
    localViewGroup.setSystemUiVisibility(this.gSv);
    localViewGroup.removeView(this.gSt);
    ((Activity)localObject).getWindow().clearFlags(1024);
    ((Activity)localObject).setRequestedOrientation(this.adN);
    this.gSt = null;
    this.gSu = null;
    localObject = this.gSw.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ae)((Iterator)localObject).next()).ajc();
    }
    return true;
  }
  
  final void z(View paramView, int paramInt)
  {
    amQ();
    this.gSt = paramView;
    Activity localActivity = (Activity)this.mContext;
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    ViewGroup localViewGroup = (ViewGroup)localActivity.getWindow().getDecorView();
    this.gSv = localViewGroup.getSystemUiVisibility();
    localViewGroup.addView(paramView, localLayoutParams);
    paramView.setX(0.0F);
    paramView.setY(0.0F);
    if (d.gG(19))
    {
      localViewGroup.setSystemUiVisibility(2);
      localActivity.getWindow().addFlags(1024);
      this.adN = localActivity.getRequestedOrientation();
      switch (paramInt)
      {
      default: 
        localActivity.setRequestedOrientation(9);
      }
    }
    for (;;)
    {
      amR();
      return;
      localViewGroup.setSystemUiVisibility(4102);
      break;
      localActivity.setRequestedOrientation(0);
      continue;
      localActivity.setRequestedOrientation(8);
      continue;
      localActivity.setRequestedOrientation(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.b
 * JD-Core Version:    0.7.0.1
 */