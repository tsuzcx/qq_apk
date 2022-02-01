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
  private View lmD;
  private final Set<b> lmI;
  private Context mContext;
  private int mOrientation;
  private int nnT;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(6269);
    this.nnT = 0;
    this.lmI = Collections.newSetFromMap(new ConcurrentHashMap());
    this.mContext = paramContext;
    AppMethodBeat.o(6269);
  }
  
  private void blJ()
  {
    AppMethodBeat.i(6274);
    Iterator localIterator = this.lmI.iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(6274);
  }
  
  private void blK()
  {
    AppMethodBeat.i(6275);
    Iterator localIterator = this.lmI.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).Cx();
    }
    AppMethodBeat.o(6275);
  }
  
  public final void O(View paramView, int paramInt)
  {
    AppMethodBeat.i(6270);
    aNT();
    this.lmD = paramView;
    Activity localActivity = (Activity)this.mContext;
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    ViewGroup localViewGroup = (ViewGroup)localActivity.getWindow().getDecorView();
    this.nnT = localViewGroup.getSystemUiVisibility();
    localViewGroup.addView(paramView, localLayoutParams);
    paramView.setX(0.0F);
    paramView.setY(0.0F);
    if (d.lg(19))
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
      blJ();
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
    if (!this.lmI.contains(paramb)) {
      this.lmI.add(paramb);
    }
    AppMethodBeat.o(6272);
  }
  
  public final boolean aNT()
  {
    AppMethodBeat.i(6271);
    if (this.lmD == null)
    {
      AppMethodBeat.o(6271);
      return false;
    }
    Activity localActivity = (Activity)this.mContext;
    ViewGroup localViewGroup = (ViewGroup)localActivity.getWindow().getDecorView();
    localViewGroup.setSystemUiVisibility(this.nnT);
    localViewGroup.removeView(this.lmD);
    localActivity.getWindow().clearFlags(1024);
    localActivity.setRequestedOrientation(this.mOrientation);
    this.lmD = null;
    blK();
    AppMethodBeat.o(6271);
    return true;
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(6273);
    this.lmI.remove(paramb);
    AppMethodBeat.o(6273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */