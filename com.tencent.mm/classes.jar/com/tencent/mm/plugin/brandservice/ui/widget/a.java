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
  private final Set<b> moA;
  private View mov;
  private int otA;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(6269);
    this.otA = 0;
    this.moA = Collections.newSetFromMap(new ConcurrentHashMap());
    this.mContext = paramContext;
    AppMethodBeat.o(6269);
  }
  
  private void bwJ()
  {
    AppMethodBeat.i(6274);
    Iterator localIterator = this.moA.iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(6274);
  }
  
  private void bwK()
  {
    AppMethodBeat.i(6275);
    Iterator localIterator = this.moA.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).DA();
    }
    AppMethodBeat.o(6275);
  }
  
  public final void O(View paramView, int paramInt)
  {
    AppMethodBeat.i(6270);
    aXV();
    this.mov = paramView;
    Activity localActivity = (Activity)this.mContext;
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    ViewGroup localViewGroup = (ViewGroup)localActivity.getWindow().getDecorView();
    this.otA = localViewGroup.getSystemUiVisibility();
    localViewGroup.addView(paramView, localLayoutParams);
    paramView.setX(0.0F);
    paramView.setY(0.0F);
    if (d.lz(19))
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
      bwJ();
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
    if (!this.moA.contains(paramb)) {
      this.moA.add(paramb);
    }
    AppMethodBeat.o(6272);
  }
  
  public final boolean aXV()
  {
    AppMethodBeat.i(6271);
    if (this.mov == null)
    {
      AppMethodBeat.o(6271);
      return false;
    }
    Activity localActivity = (Activity)this.mContext;
    ViewGroup localViewGroup = (ViewGroup)localActivity.getWindow().getDecorView();
    localViewGroup.setSystemUiVisibility(this.otA);
    localViewGroup.removeView(this.mov);
    localActivity.getWindow().clearFlags(1024);
    localActivity.setRequestedOrientation(this.mOrientation);
    this.mov = null;
    bwK();
    AppMethodBeat.o(6271);
    return true;
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(6273);
    this.moA.remove(paramb);
    AppMethodBeat.o(6273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */