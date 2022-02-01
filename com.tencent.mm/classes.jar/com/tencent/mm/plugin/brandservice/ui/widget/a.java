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
  private Context mContext;
  private int mOrientation;
  private View nEb;
  private final Set<b> nEg;
  private int pNM;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(6269);
    this.pNM = 0;
    this.nEg = Collections.newSetFromMap(new ConcurrentHashMap());
    this.mContext = paramContext;
    AppMethodBeat.o(6269);
  }
  
  private void bTL()
  {
    AppMethodBeat.i(6274);
    Iterator localIterator = this.nEg.iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(6274);
  }
  
  private void bTM()
  {
    AppMethodBeat.i(6275);
    Iterator localIterator = this.nEg.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).Na();
    }
    AppMethodBeat.o(6275);
  }
  
  public final void N(View paramView, int paramInt)
  {
    AppMethodBeat.i(6270);
    btC();
    this.nEb = paramView;
    Activity localActivity = (Activity)this.mContext;
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    ViewGroup localViewGroup = (ViewGroup)localActivity.getWindow().getDecorView();
    this.pNM = localViewGroup.getSystemUiVisibility();
    localViewGroup.addView(paramView, localLayoutParams);
    paramView.setX(0.0F);
    paramView.setY(0.0F);
    if (d.oE(19))
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
      bTL();
      AppMethodBeat.o(6270);
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
    AppMethodBeat.i(6272);
    if (!this.nEg.contains(paramb)) {
      this.nEg.add(paramb);
    }
    AppMethodBeat.o(6272);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(6273);
    this.nEg.remove(paramb);
    AppMethodBeat.o(6273);
  }
  
  public final boolean btC()
  {
    AppMethodBeat.i(6271);
    if (this.nEb == null)
    {
      AppMethodBeat.o(6271);
      return false;
    }
    Activity localActivity = (Activity)this.mContext;
    ViewGroup localViewGroup = (ViewGroup)localActivity.getWindow().getDecorView();
    localViewGroup.setSystemUiVisibility(this.pNM);
    localViewGroup.removeView(this.nEb);
    localActivity.getWindow().clearFlags(1024);
    localActivity.setRequestedOrientation(this.mOrientation);
    this.nEb = null;
    bTM();
    AppMethodBeat.o(6271);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */