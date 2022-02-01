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
  public d hSS;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(175345);
    this.hSS = new d();
    this.context = paramContext;
    AppMethodBeat.o(175345);
  }
  
  public final void a(com.tencent.mm.picker.c.a parama)
  {
    AppMethodBeat.i(175346);
    this.hSa = parama;
    Object localObject = this.context;
    aGc();
    aFZ();
    aGa();
    parama = this.hSS;
    localObject = new WheelView((Context)localObject);
    parama.hSg = this.hSa.hSg;
    if (parama.hSV == null) {
      parama.hSV = ((WheelView)localObject);
    }
    parama.hSW = parama.hSV;
    if (this.hSa.hSe != null) {
      this.hSS.hSe = this.hSa.hSe;
    }
    parama = this.hSS;
    localObject = this.hSa.label;
    if (localObject != null) {
      parama.hSW.setLabel((String)localObject);
    }
    parama = this.hSS;
    boolean bool = this.hSa.hSf;
    parama.hSW.setCyclic(bool);
    eM(this.hSa.lA);
    this.hSS.setDividerColor(this.hSa.hRF);
    this.hSS.hSG = this.hSa.hSG;
    this.hSS.hSE = this.hSa.hSE;
    parama = this.hSS;
    bool = this.hSa.hRy;
    parama.hSW.hRy = bool;
    this.hSS.pI(this.hSa.hr);
    this.hSS.setDividerColor(this.hSa.hRF);
    AppMethodBeat.o(175346);
  }
  
  public final void a(com.tencent.mm.picker.d.b paramb)
  {
    this.hSa.hSe = paramb;
    this.hSS.hSe = this.hSa.hSe;
  }
  
  public final boolean aGd()
  {
    return this.hSa.hSF;
  }
  
  public final void aGe()
  {
    AppMethodBeat.i(175349);
    if (this.hSa.hSb != null)
    {
      int[] arrayOfInt = this.hSS.aGi();
      this.hSa.hSb.pH(arrayOfInt[0]);
    }
    AppMethodBeat.o(175349);
  }
  
  public final WheelView aGf()
  {
    AppMethodBeat.i(175350);
    if (this.hSS.hSV == null) {
      this.hSS.hSV = new WheelView(this.context);
    }
    WheelView localWheelView = this.hSS.hSV;
    AppMethodBeat.o(175350);
    return localWheelView;
  }
  
  public final void aI(List<T> paramList)
  {
    AppMethodBeat.i(175347);
    d locald = this.hSS;
    locald.hSX = paramList;
    locald.hSW.setAdapter(new com.tencent.mm.picker.a.a(locald.hSX));
    locald.hSW.setCurrentItem(0);
    locald.hSW.setIsOptions(true);
    d.1 local1 = new d.1(locald);
    if ((paramList != null) && (locald.hSY)) {
      locald.hSW.setOnItemSelectedListener(local1);
    }
    if (this.hSS != null) {
      this.hSS.pI(this.hSa.option);
    }
    AppMethodBeat.o(175347);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(175348);
    if (((String)paramView.getTag()).equals("submit")) {
      aGe();
    }
    dismiss();
    AppMethodBeat.o(175348);
  }
  
  public final void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(175351);
    this.hSS.hSW.setDividerHeight(paramFloat);
    AppMethodBeat.o(175351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.picker.f.b
 * JD-Core Version:    0.7.0.1
 */