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
  public d iOT;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(175345);
    this.iOT = new d();
    this.context = paramContext;
    AppMethodBeat.o(175345);
  }
  
  public final void a(com.tencent.mm.picker.c.a parama)
  {
    AppMethodBeat.i(175346);
    this.iOb = parama;
    Object localObject = this.context;
    aQz();
    aQw();
    aQx();
    parama = this.iOT;
    localObject = new WheelView((Context)localObject);
    parama.iOh = this.iOb.iOh;
    if (parama.iOW == null) {
      parama.iOW = ((WheelView)localObject);
    }
    parama.iOX = parama.iOW;
    if (this.iOb.iOf != null) {
      this.iOT.iOf = this.iOb.iOf;
    }
    parama = this.iOT;
    localObject = this.iOb.label;
    if (localObject != null) {
      parama.iOX.setLabel((String)localObject);
    }
    parama = this.iOT;
    boolean bool = this.iOb.iOg;
    parama.iOX.setCyclic(bool);
    fl(this.iOb.ov);
    this.iOT.setDividerColor(this.iOb.iNG);
    this.iOT.iOH = this.iOb.iOH;
    this.iOT.iOF = this.iOb.iOF;
    parama = this.iOT;
    bool = this.iOb.iNz;
    parama.iOX.iNz = bool;
    this.iOT.qY(this.iOb.kl);
    this.iOT.setDividerColor(this.iOb.iNG);
    AppMethodBeat.o(175346);
  }
  
  public final void a(com.tencent.mm.picker.d.b paramb)
  {
    this.iOb.iOf = paramb;
    this.iOT.iOf = this.iOb.iOf;
  }
  
  public final void aG(List<T> paramList)
  {
    AppMethodBeat.i(175347);
    d locald = this.iOT;
    locald.iOY = paramList;
    locald.iOX.setAdapter(new com.tencent.mm.picker.a.a(locald.iOY));
    locald.iOX.setCurrentItem(0);
    locald.iOX.setIsOptions(true);
    d.1 local1 = new d.1(locald);
    if ((paramList != null) && (locald.iOZ)) {
      locald.iOX.setOnItemSelectedListener(local1);
    }
    if (this.iOT != null) {
      this.iOT.qY(this.iOb.option);
    }
    AppMethodBeat.o(175347);
  }
  
  public final boolean aQA()
  {
    return this.iOb.iOG;
  }
  
  public final void aQB()
  {
    AppMethodBeat.i(175349);
    if (this.iOb.iOc != null)
    {
      int[] arrayOfInt = this.iOT.aQF();
      this.iOb.iOc.qX(arrayOfInt[0]);
    }
    AppMethodBeat.o(175349);
  }
  
  public final WheelView aQC()
  {
    AppMethodBeat.i(175350);
    if (this.iOT.iOW == null) {
      this.iOT.iOW = new WheelView(this.context);
    }
    WheelView localWheelView = this.iOT.iOW;
    AppMethodBeat.o(175350);
    return localWheelView;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(175348);
    if (((String)paramView.getTag()).equals("submit")) {
      aQB();
    }
    dismiss();
    AppMethodBeat.o(175348);
  }
  
  public final void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(175351);
    this.iOT.iOX.setDividerHeight(paramFloat);
    AppMethodBeat.o(175351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.f.b
 * JD-Core Version:    0.7.0.1
 */