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
  public d iMa;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(175345);
    this.iMa = new d();
    this.context = paramContext;
    AppMethodBeat.o(175345);
  }
  
  public final void a(com.tencent.mm.picker.c.a parama)
  {
    AppMethodBeat.i(175346);
    this.iLi = parama;
    Object localObject = this.context;
    aQa();
    aPX();
    aPY();
    parama = this.iMa;
    localObject = new WheelView((Context)localObject);
    parama.iLo = this.iLi.iLo;
    if (parama.iMd == null) {
      parama.iMd = ((WheelView)localObject);
    }
    parama.iMe = parama.iMd;
    if (this.iLi.iLm != null) {
      this.iMa.iLm = this.iLi.iLm;
    }
    parama = this.iMa;
    localObject = this.iLi.label;
    if (localObject != null) {
      parama.iMe.setLabel((String)localObject);
    }
    parama = this.iMa;
    boolean bool = this.iLi.iLn;
    parama.iMe.setCyclic(bool);
    fk(this.iLi.ov);
    this.iMa.setDividerColor(this.iLi.iKN);
    this.iMa.iLO = this.iLi.iLO;
    this.iMa.iLM = this.iLi.iLM;
    parama = this.iMa;
    bool = this.iLi.iKG;
    parama.iMe.iKG = bool;
    this.iMa.qV(this.iLi.kl);
    this.iMa.setDividerColor(this.iLi.iKN);
    AppMethodBeat.o(175346);
  }
  
  public final void a(com.tencent.mm.picker.d.b paramb)
  {
    this.iLi.iLm = paramb;
    this.iMa.iLm = this.iLi.iLm;
  }
  
  public final void aG(List<T> paramList)
  {
    AppMethodBeat.i(175347);
    d locald = this.iMa;
    locald.iMf = paramList;
    locald.iMe.setAdapter(new com.tencent.mm.picker.a.a(locald.iMf));
    locald.iMe.setCurrentItem(0);
    locald.iMe.setIsOptions(true);
    d.1 local1 = new d.1(locald);
    if ((paramList != null) && (locald.iMg)) {
      locald.iMe.setOnItemSelectedListener(local1);
    }
    if (this.iMa != null) {
      this.iMa.qV(this.iLi.option);
    }
    AppMethodBeat.o(175347);
  }
  
  public final boolean aQb()
  {
    return this.iLi.iLN;
  }
  
  public final void aQc()
  {
    AppMethodBeat.i(175349);
    if (this.iLi.iLj != null)
    {
      int[] arrayOfInt = this.iMa.aQg();
      this.iLi.iLj.qU(arrayOfInt[0]);
    }
    AppMethodBeat.o(175349);
  }
  
  public final WheelView aQd()
  {
    AppMethodBeat.i(175350);
    if (this.iMa.iMd == null) {
      this.iMa.iMd = new WheelView(this.context);
    }
    WheelView localWheelView = this.iMa.iMd;
    AppMethodBeat.o(175350);
    return localWheelView;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(175348);
    if (((String)paramView.getTag()).equals("submit")) {
      aQc();
    }
    dismiss();
    AppMethodBeat.o(175348);
  }
  
  public final void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(175351);
    this.iMa.iMe.setDividerHeight(paramFloat);
    AppMethodBeat.o(175351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.f.b
 * JD-Core Version:    0.7.0.1
 */