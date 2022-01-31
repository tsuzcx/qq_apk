package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.widget.NumberPicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandDatePicker;
import com.tencent.mm.plugin.appbrand.widget.picker.b;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    boolean bool3 = true;
    int j = 0;
    AppMethodBeat.i(126336);
    Object localObject2 = this.hWC;
    Object localObject1 = (AppBrandDatePicker)((a)localObject2).ah(AppBrandDatePicker.class);
    if (localObject1 == null)
    {
      ((d)localObject2).l("fail cant init view", null);
      AppMethodBeat.o(126336);
      return;
    }
    com.tencent.mm.plugin.appbrand.widget.picker.a locala = ((b)localObject2).jrY;
    locala.setOnResultListener(new a.2((a)localObject2));
    if (((a)localObject2).hWx != null) {
      ((AppBrandDatePicker)localObject1).setMinDate(((a)localObject2).hWx.longValue());
    }
    if (((a)localObject2).hWy != null) {
      ((AppBrandDatePicker)localObject1).setMaxDate(((a)localObject2).hWy.longValue());
    }
    ((AppBrandDatePicker)localObject1).a(((a)localObject2).hWz, ((a)localObject2).hWA, ((a)localObject2).hWB, null);
    boolean bool1;
    boolean bool2;
    if (((a)localObject2).hWw.ordinal() >= a.a.hWD.ordinal())
    {
      bool1 = true;
      if (((a)localObject2).hWw.ordinal() < a.a.hWE.ordinal()) {
        break label335;
      }
      bool2 = true;
      label170:
      if (((a)localObject2).hWw.ordinal() < a.a.hWF.ordinal()) {
        break label341;
      }
      label187:
      ((AppBrandDatePicker)localObject1).jrZ = bool1;
      ((AppBrandDatePicker)localObject1).jsa = bool2;
      ((AppBrandDatePicker)localObject1).jsb = bool3;
      if (((AppBrandDatePicker)localObject1).jsc != null)
      {
        ((AppBrandDatePicker)localObject1).jsc.setEnabled(bool1);
        localObject2 = ((AppBrandDatePicker)localObject1).jsc;
        if (!bool1) {
          break label347;
        }
        i = 0;
        label237:
        ((NumberPicker)localObject2).setVisibility(i);
      }
      if (((AppBrandDatePicker)localObject1).jsd != null)
      {
        ((AppBrandDatePicker)localObject1).jsd.setEnabled(bool2);
        localObject2 = ((AppBrandDatePicker)localObject1).jsd;
        if (!bool2) {
          break label353;
        }
        i = 0;
        label275:
        ((NumberPicker)localObject2).setVisibility(i);
      }
      if (((AppBrandDatePicker)localObject1).jse != null)
      {
        ((AppBrandDatePicker)localObject1).jse.setEnabled(bool3);
        localObject1 = ((AppBrandDatePicker)localObject1).jse;
        if (!bool3) {
          break label359;
        }
      }
    }
    label335:
    label341:
    label347:
    label353:
    label359:
    for (int i = j;; i = 8)
    {
      ((NumberPicker)localObject1).setVisibility(i);
      locala.show();
      AppMethodBeat.o(126336);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label170;
      bool3 = false;
      break label187;
      i = 8;
      break label237;
      i = 8;
      break label275;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.a.1
 * JD-Core Version:    0.7.0.1
 */