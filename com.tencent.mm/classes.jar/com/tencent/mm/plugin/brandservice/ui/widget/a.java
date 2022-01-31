package com.tencent.mm.plugin.brandservice.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  private View ivh;
  private final Set<b> ivp;
  private int kjt;
  private Context mContext;
  private int mOrientation;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(14459);
    this.kjt = 0;
    this.ivp = Collections.newSetFromMap(new ConcurrentHashMap());
    this.mContext = paramContext;
    AppMethodBeat.o(14459);
  }
  
  private void aIK()
  {
    AppMethodBeat.i(14464);
    Iterator localIterator = this.ivp.iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(14464);
  }
  
  private void aIL()
  {
    AppMethodBeat.i(14465);
    Iterator localIterator = this.ivp.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).aDk();
    }
    AppMethodBeat.o(14465);
  }
  
  public final void J(View paramView, int paramInt)
  {
    AppMethodBeat.i(14460);
    aIJ();
    this.ivh = paramView;
    Activity localActivity = (Activity)this.mContext;
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    ViewGroup localViewGroup = (ViewGroup)localActivity.getWindow().getDecorView();
    this.kjt = localViewGroup.getSystemUiVisibility();
    localViewGroup.addView(paramView, localLayoutParams);
    paramView.setX(0.0F);
    paramView.setY(0.0F);
    if (d.fw(19))
    {
      localViewGroup.setSystemUiVisibility(2);
      localActivity.getWindow().addFlags(1024);
      this.mOrientation = localActivity.getRequestedOrientation();
      switch (paramInt)
      {
      default: 
        localActivity.setRequestedOrientation(9);
      }
    }
    for (;;)
    {
      aIK();
      AppMethodBeat.o(14460);
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
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(14462);
    if (!this.ivp.contains(paramb)) {
      this.ivp.add(paramb);
    }
    AppMethodBeat.o(14462);
  }
  
  public final boolean aIJ()
  {
    AppMethodBeat.i(14461);
    if (this.ivh == null)
    {
      AppMethodBeat.o(14461);
      return false;
    }
    Activity localActivity = (Activity)this.mContext;
    ViewGroup localViewGroup = (ViewGroup)localActivity.getWindow().getDecorView();
    localViewGroup.setSystemUiVisibility(this.kjt);
    localViewGroup.removeView(this.ivh);
    localActivity.getWindow().clearFlags(1024);
    localActivity.setRequestedOrientation(this.mOrientation);
    this.ivh = null;
    aIL();
    AppMethodBeat.o(14461);
    return true;
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(14463);
    this.ivp.remove(paramb);
    AppMethodBeat.o(14463);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */