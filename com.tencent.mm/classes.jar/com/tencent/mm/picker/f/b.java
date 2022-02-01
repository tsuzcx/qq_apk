package com.tencent.mm.picker.f;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.picker.d.c;
import java.util.List;

public final class b<T>
  extends a
  implements View.OnClickListener
{
  private Context context;
  public d isX;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(175345);
    this.isX = new d();
    this.context = paramContext;
    AppMethodBeat.o(175345);
  }
  
  public final void a(com.tencent.mm.picker.c.a parama)
  {
    AppMethodBeat.i(175346);
    this.isf = parama;
    Object localObject = this.context;
    aMP();
    aMM();
    aMN();
    parama = this.isX;
    localObject = new WheelView((Context)localObject);
    parama.isl = this.isf.isl;
    if (parama.ita == null) {
      parama.ita = ((WheelView)localObject);
    }
    parama.itb = parama.ita;
    if (this.isf.isj != null) {
      this.isX.isj = this.isf.isj;
    }
    parama = this.isX;
    localObject = this.isf.label;
    if (localObject != null) {
      parama.itb.setLabel((String)localObject);
    }
    parama = this.isX;
    boolean bool = this.isf.isk;
    parama.itb.setCyclic(bool);
    fg(this.isf.mz);
    this.isX.setDividerColor(this.isf.irK);
    this.isX.isL = this.isf.isL;
    this.isX.isJ = this.isf.isJ;
    parama = this.isX;
    bool = this.isf.irD;
    parama.itb.irD = bool;
    this.isX.qv(this.isf.it);
    this.isX.setDividerColor(this.isf.irK);
    AppMethodBeat.o(175346);
  }
  
  public final void a(com.tencent.mm.picker.d.b paramb)
  {
    this.isf.isj = paramb;
    this.isX.isj = this.isf.isj;
  }
  
  public final void aF(List<T> paramList)
  {
    AppMethodBeat.i(175347);
    d locald = this.isX;
    locald.itc = paramList;
    locald.itb.setAdapter(new com.tencent.mm.picker.a.a(locald.itc));
    locald.itb.setCurrentItem(0);
    locald.itb.setIsOptions(true);
    d.1 local1 = new d.1(locald);
    if ((paramList != null) && (locald.itd)) {
      locald.itb.setOnItemSelectedListener(local1);
    }
    if (this.isX != null) {
      this.isX.qv(this.isf.option);
    }
    AppMethodBeat.o(175347);
  }
  
  public final boolean aMQ()
  {
    return this.isf.isK;
  }
  
  public final void aMR()
  {
    AppMethodBeat.i(175349);
    if (this.isf.isg != null)
    {
      int[] arrayOfInt = this.isX.aMV();
      this.isf.isg.qu(arrayOfInt[0]);
    }
    AppMethodBeat.o(175349);
  }
  
  public final WheelView aMS()
  {
    AppMethodBeat.i(175350);
    if (this.isX.ita == null) {
      this.isX.ita = new WheelView(this.context);
    }
    WheelView localWheelView = this.isX.ita;
    AppMethodBeat.o(175350);
    return localWheelView;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(175348);
    if (((String)paramView.getTag()).equals("submit")) {
      aMR();
    }
    dismiss();
    AppMethodBeat.o(175348);
  }
  
  public final void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(175351);
    this.isX.itb.setDividerHeight(paramFloat);
    AppMethodBeat.o(175351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.f.b
 * JD-Core Version:    0.7.0.1
 */