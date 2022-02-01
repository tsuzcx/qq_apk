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
  public d pzu;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(175345);
    this.pzu = new d();
    this.context = paramContext;
    AppMethodBeat.o(175345);
  }
  
  public final void a(com.tencent.mm.picker.c.a parama)
  {
    AppMethodBeat.i(175346);
    this.pyC = parama;
    Object localObject = this.context;
    bTc();
    bSZ();
    bTa();
    parama = this.pzu;
    localObject = new WheelView((Context)localObject);
    parama.pyJ = this.pyC.pyJ;
    if (parama.pzy == null) {
      parama.pzy = ((WheelView)localObject);
    }
    parama.pzz = parama.pzy;
    if (this.pyC.pyH != null) {
      this.pzu.pyH = this.pyC.pyH;
    }
    parama = this.pzu;
    localObject = this.pyC.label;
    if (localObject != null) {
      parama.pzz.setLabel((String)localObject);
    }
    parama = this.pzu;
    boolean bool = this.pyC.pyI;
    parama.pzz.setCyclic(bool);
    hE(this.pyC.dqR);
    this.pzu.setDividerColor(this.pyC.pyf);
    this.pzu.pzh = this.pyC.pzh;
    this.pzu.bbg = this.pyC.bbg;
    parama = this.pzu;
    bool = this.pyC.pxZ;
    parama.pzz.pxZ = bool;
    this.pzu.xZ(this.pyC.dpX);
    this.pzu.setDividerColor(this.pyC.pyf);
    AppMethodBeat.o(175346);
  }
  
  public final boolean bTd()
  {
    return this.pyC.pzg;
  }
  
  public final void bTe()
  {
    AppMethodBeat.i(175349);
    if (this.pyC.pyE != null)
    {
      int[] arrayOfInt = this.pzu.bTj();
      this.pyC.pyE.xY(arrayOfInt[0]);
    }
    AppMethodBeat.o(175349);
  }
  
  public final WheelView bTf()
  {
    AppMethodBeat.i(175350);
    if (this.pzu.pzy == null) {
      this.pzu.pzy = new WheelView(this.context);
    }
    WheelView localWheelView = this.pzu.pzy;
    AppMethodBeat.o(175350);
    return localWheelView;
  }
  
  public final void cr(List<T> paramList)
  {
    AppMethodBeat.i(175347);
    d locald = this.pzu;
    locald.pzA = paramList;
    locald.pzz.setAdapter(new com.tencent.mm.picker.a.a(locald.pzA));
    locald.pzz.setCurrentItem(0);
    locald.pzz.setIsOptions(true);
    d.1 local1 = new d.1(locald);
    if ((paramList != null) && (locald.pzB)) {
      locald.pzz.setOnItemSelectedListener(local1);
    }
    if (this.pzu != null) {
      this.pzu.xZ(this.pyC.option);
    }
    AppMethodBeat.o(175347);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(175348);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/picker/view/OptionsPickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (((String)paramView.getTag()).equals("submit")) {
      bTe();
    }
    dismiss();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/picker/view/OptionsPickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(175348);
  }
  
  public final void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(175351);
    this.pzu.pzz.setDividerHeight(paramFloat);
    AppMethodBeat.o(175351);
  }
  
  public final void setOnValueChangedListener(c paramc)
  {
    this.pyC.pyH = paramc;
    this.pzu.pyH = this.pyC.pyH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.picker.f.b
 * JD-Core Version:    0.7.0.1
 */