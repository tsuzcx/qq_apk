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
  private View lOF;
  private final Set<b> lOK;
  private Context mContext;
  private int mOrientation;
  private int nQT;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(6269);
    this.nQT = 0;
    this.lOK = Collections.newSetFromMap(new ConcurrentHashMap());
    this.mContext = paramContext;
    AppMethodBeat.o(6269);
  }
  
  private void bsF()
  {
    AppMethodBeat.i(6274);
    Iterator localIterator = this.lOK.iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(6274);
  }
  
  private void bsG()
  {
    AppMethodBeat.i(6275);
    Iterator localIterator = this.lOK.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).Cb();
    }
    AppMethodBeat.o(6275);
  }
  
  public final void O(View paramView, int paramInt)
  {
    AppMethodBeat.i(6270);
    aUJ();
    this.lOF = paramView;
    Activity localActivity = (Activity)this.mContext;
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    ViewGroup localViewGroup = (ViewGroup)localActivity.getWindow().getDecorView();
    this.nQT = localViewGroup.getSystemUiVisibility();
    localViewGroup.addView(paramView, localLayoutParams);
    paramView.setX(0.0F);
    paramView.setY(0.0F);
    if (d.la(19))
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
      bsF();
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
    if (!this.lOK.contains(paramb)) {
      this.lOK.add(paramb);
    }
    AppMethodBeat.o(6272);
  }
  
  public final boolean aUJ()
  {
    AppMethodBeat.i(6271);
    if (this.lOF == null)
    {
      AppMethodBeat.o(6271);
      return false;
    }
    Activity localActivity = (Activity)this.mContext;
    ViewGroup localViewGroup = (ViewGroup)localActivity.getWindow().getDecorView();
    localViewGroup.setSystemUiVisibility(this.nQT);
    localViewGroup.removeView(this.lOF);
    localActivity.getWindow().clearFlags(1024);
    localActivity.setRequestedOrientation(this.mOrientation);
    this.lOF = null;
    bsG();
    AppMethodBeat.o(6271);
    return true;
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(6273);
    this.lOK.remove(paramb);
    AppMethodBeat.o(6273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */