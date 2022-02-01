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
  public d jLI;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(175345);
    this.jLI = new d();
    this.context = paramContext;
    AppMethodBeat.o(175345);
  }
  
  public final void a(com.tencent.mm.picker.c.a parama)
  {
    AppMethodBeat.i(175346);
    this.jKP = parama;
    Object localObject = this.context;
    ble();
    blb();
    blc();
    parama = this.jLI;
    localObject = new WheelView((Context)localObject);
    parama.jKW = this.jKP.jKW;
    if (parama.jLL == null) {
      parama.jLL = ((WheelView)localObject);
    }
    parama.jLM = parama.jLL;
    if (this.jKP.jKU != null) {
      this.jLI.jKU = this.jKP.jKU;
    }
    parama = this.jLI;
    localObject = this.jKP.label;
    if (localObject != null) {
      parama.jLM.setLabel((String)localObject);
    }
    parama = this.jLI;
    boolean bool = this.jKP.jKV;
    parama.jLM.setCyclic(bool);
    gd(this.jKP.ox);
    this.jLI.setDividerColor(this.jKP.jKu);
    this.jLI.jLw = this.jKP.jLw;
    this.jLI.jLu = this.jKP.jLu;
    parama = this.jLI;
    bool = this.jKP.jKn;
    parama.jLM.jKn = bool;
    this.jLI.uQ(this.jKP.kn);
    this.jLI.setDividerColor(this.jKP.jKu);
    AppMethodBeat.o(175346);
  }
  
  public final void a(com.tencent.mm.picker.d.b paramb)
  {
    this.jKP.jKU = paramb;
    this.jLI.jKU = this.jKP.jKU;
  }
  
  public final void aO(List<T> paramList)
  {
    AppMethodBeat.i(175347);
    d locald = this.jLI;
    locald.jLN = paramList;
    locald.jLM.setAdapter(new com.tencent.mm.picker.a.a(locald.jLN));
    locald.jLM.setCurrentItem(0);
    locald.jLM.setIsOptions(true);
    d.1 local1 = new d.1(locald);
    if ((paramList != null) && (locald.jLO)) {
      locald.jLM.setOnItemSelectedListener(local1);
    }
    if (this.jLI != null) {
      this.jLI.uQ(this.jKP.option);
    }
    AppMethodBeat.o(175347);
  }
  
  public final boolean blf()
  {
    return this.jKP.jLv;
  }
  
  public final void blg()
  {
    AppMethodBeat.i(175349);
    if (this.jKP.jKR != null)
    {
      int[] arrayOfInt = this.jLI.blk();
      this.jKP.jKR.uP(arrayOfInt[0]);
    }
    AppMethodBeat.o(175349);
  }
  
  public final WheelView blh()
  {
    AppMethodBeat.i(175350);
    if (this.jLI.jLL == null) {
      this.jLI.jLL = new WheelView(this.context);
    }
    WheelView localWheelView = this.jLI.jLL;
    AppMethodBeat.o(175350);
    return localWheelView;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(175348);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/picker/view/OptionsPickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (((String)paramView.getTag()).equals("submit")) {
      blg();
    }
    dismiss();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/picker/view/OptionsPickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(175348);
  }
  
  public final void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(175351);
    this.jLI.jLM.setDividerHeight(paramFloat);
    AppMethodBeat.o(175351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.picker.f.b
 * JD-Core Version:    0.7.0.1
 */