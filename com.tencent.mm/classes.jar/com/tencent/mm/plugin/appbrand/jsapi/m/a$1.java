package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.widget.NumberPicker;
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
    Object localObject2 = this.gzB;
    Object localObject1 = (AppBrandDatePicker)((a)localObject2).N(AppBrandDatePicker.class);
    if (localObject1 == null)
    {
      ((d)localObject2).j("fail cant init view", null);
      return;
    }
    com.tencent.mm.plugin.appbrand.widget.picker.a locala = ((b)localObject2).hzI;
    locala.setOnResultListener(new a.2((a)localObject2));
    if (((a)localObject2).gzw != null) {
      ((AppBrandDatePicker)localObject1).setMinDate(((a)localObject2).gzw.longValue());
    }
    if (((a)localObject2).gzx != null) {
      ((AppBrandDatePicker)localObject1).setMaxDate(((a)localObject2).gzx.longValue());
    }
    ((AppBrandDatePicker)localObject1).a(((a)localObject2).gzy, ((a)localObject2).gzz, ((a)localObject2).gzA, null);
    boolean bool1;
    boolean bool2;
    if (((a)localObject2).gzv.ordinal() >= a.a.gzC.ordinal())
    {
      bool1 = true;
      if (((a)localObject2).gzv.ordinal() < a.a.gzD.ordinal()) {
        break label320;
      }
      bool2 = true;
      label160:
      if (((a)localObject2).gzv.ordinal() < a.a.gzE.ordinal()) {
        break label326;
      }
      label177:
      ((AppBrandDatePicker)localObject1).hzJ = bool1;
      ((AppBrandDatePicker)localObject1).hzK = bool2;
      ((AppBrandDatePicker)localObject1).hzL = bool3;
      if (((AppBrandDatePicker)localObject1).hzM != null)
      {
        ((AppBrandDatePicker)localObject1).hzM.setEnabled(bool1);
        localObject2 = ((AppBrandDatePicker)localObject1).hzM;
        if (!bool1) {
          break label332;
        }
        i = 0;
        label227:
        ((NumberPicker)localObject2).setVisibility(i);
      }
      if (((AppBrandDatePicker)localObject1).hzN != null)
      {
        ((AppBrandDatePicker)localObject1).hzN.setEnabled(bool2);
        localObject2 = ((AppBrandDatePicker)localObject1).hzN;
        if (!bool2) {
          break label338;
        }
        i = 0;
        label265:
        ((NumberPicker)localObject2).setVisibility(i);
      }
      if (((AppBrandDatePicker)localObject1).hzO != null)
      {
        ((AppBrandDatePicker)localObject1).hzO.setEnabled(bool3);
        localObject1 = ((AppBrandDatePicker)localObject1).hzO;
        if (!bool3) {
          break label344;
        }
      }
    }
    label320:
    label326:
    label332:
    label338:
    label344:
    for (int i = j;; i = 8)
    {
      ((NumberPicker)localObject1).setVisibility(i);
      locala.show();
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label160;
      bool3 = false;
      break label177;
      i = 8;
      break label227;
      i = 8;
      break label265;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.a.1
 * JD-Core Version:    0.7.0.1
 */