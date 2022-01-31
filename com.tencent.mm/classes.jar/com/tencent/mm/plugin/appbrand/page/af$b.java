package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public final class af$b
{
  boolean hhs;
  int id;
  WeakReference<View> iyQ;
  boolean iyR;
  af.a iyS;
  public int parent;
  int z;
  
  public af$b(View paramView, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(91096);
    this.iyQ = new WeakReference(paramView);
    this.id = paramInt1;
    this.parent = paramInt2;
    this.z = paramInt3;
    this.iyR = paramBoolean1;
    this.hhs = paramBoolean2;
    AppMethodBeat.o(91096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.af.b
 * JD-Core Version:    0.7.0.1
 */