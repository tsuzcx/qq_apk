package com.tencent.mm.plugin.appbrand.jsapi;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.a.e;

final class JsApiShowImageOperateSheet$BottomSheetLogicHelper$5
  implements View.OnClickListener
{
  JsApiShowImageOperateSheet$BottomSheetLogicHelper$5(JsApiShowImageOperateSheet.BottomSheetLogicHelper paramBottomSheetLogicHelper) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(45656);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/appbrand/jsapi/JsApiShowImageOperateSheet$BottomSheetLogicHelper$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (JsApiShowImageOperateSheet.BottomSheetLogicHelper.b(this.kuo).isShowing()) {
      JsApiShowImageOperateSheet.BottomSheetLogicHelper.b(this.kuo).bpT();
    }
    JsApiShowImageOperateSheet.BottomSheetLogicHelper.h(this.kuo);
    a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/JsApiShowImageOperateSheet$BottomSheetLogicHelper$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(45656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper.5
 * JD-Core Version:    0.7.0.1
 */