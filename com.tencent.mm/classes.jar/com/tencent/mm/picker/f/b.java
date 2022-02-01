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
  public d mCM;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(175345);
    this.mCM = new d();
    this.context = paramContext;
    AppMethodBeat.o(175345);
  }
  
  public final void a(com.tencent.mm.picker.c.a parama)
  {
    AppMethodBeat.i(175346);
    this.mBU = parama;
    Object localObject = this.context;
    buT();
    buQ();
    buR();
    parama = this.mCM;
    localObject = new WheelView((Context)localObject);
    parama.mCb = this.mBU.mCb;
    if (parama.mCQ == null) {
      parama.mCQ = ((WheelView)localObject);
    }
    parama.mCR = parama.mCQ;
    if (this.mBU.mBZ != null) {
      this.mCM.mBZ = this.mBU.mBZ;
    }
    parama = this.mCM;
    localObject = this.mBU.label;
    if (localObject != null) {
      parama.mCR.setLabel((String)localObject);
    }
    parama = this.mCM;
    boolean bool = this.mBU.mCa;
    parama.mCR.setCyclic(bool);
    gP(this.mBU.bxO);
    this.mCM.setDividerColor(this.mBU.mBx);
    this.mCM.mCA = this.mBU.mCA;
    this.mCM.mCy = this.mBU.mCy;
    parama = this.mCM;
    bool = this.mBU.mBq;
    parama.mCR.mBq = bool;
    this.mCM.xU(this.mBU.bwU);
    this.mCM.setDividerColor(this.mBU.mBx);
    AppMethodBeat.o(175346);
  }
  
  public final void aM(List<T> paramList)
  {
    AppMethodBeat.i(175347);
    d locald = this.mCM;
    locald.mCS = paramList;
    locald.mCR.setAdapter(new com.tencent.mm.picker.a.a(locald.mCS));
    locald.mCR.setCurrentItem(0);
    locald.mCR.setIsOptions(true);
    d.1 local1 = new d.1(locald);
    if ((paramList != null) && (locald.mCT)) {
      locald.mCR.setOnItemSelectedListener(local1);
    }
    if (this.mCM != null) {
      this.mCM.xU(this.mBU.option);
    }
    AppMethodBeat.o(175347);
  }
  
  public final boolean buU()
  {
    return this.mBU.mCz;
  }
  
  public final void buV()
  {
    AppMethodBeat.i(175349);
    if (this.mBU.mBW != null)
    {
      int[] arrayOfInt = this.mCM.bva();
      this.mBU.mBW.xT(arrayOfInt[0]);
    }
    AppMethodBeat.o(175349);
  }
  
  public final WheelView buW()
  {
    AppMethodBeat.i(175350);
    if (this.mCM.mCQ == null) {
      this.mCM.mCQ = new WheelView(this.context);
    }
    WheelView localWheelView = this.mCM.mCQ;
    AppMethodBeat.o(175350);
    return localWheelView;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(175348);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/picker/view/OptionsPickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (((String)paramView.getTag()).equals("submit")) {
      buV();
    }
    dismiss();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/picker/view/OptionsPickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(175348);
  }
  
  public final void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(175351);
    this.mCM.mCR.setDividerHeight(paramFloat);
    AppMethodBeat.o(175351);
  }
  
  public final void setOnValueChangedListener(com.tencent.mm.picker.d.b paramb)
  {
    this.mBU.mBZ = paramb;
    this.mCM.mBZ = this.mBU.mBZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.f.b
 * JD-Core Version:    0.7.0.1
 */