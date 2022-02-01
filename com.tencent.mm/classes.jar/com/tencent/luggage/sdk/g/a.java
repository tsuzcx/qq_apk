package com.tencent.luggage.sdk.g;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/luggage/sdk/wxa_ktx/ActivityUtils;", "", "()V", "REQUEST_CODE_LOW_BITS_MAGIC_NUM", "", "TAG", "", "hashCodeAsRequestCode", "safeRequestWindowFeature", "", "Landroid/app/Activity;", "feature", "luggage-wxa-app_release"})
public final class a
{
  public static final a cpK;
  
  static
  {
    AppMethodBeat.i(176450);
    cpK = new a();
    AppMethodBeat.o(176450);
  }
  
  public static final int aC(Object paramObject)
  {
    AppMethodBeat.i(176449);
    p.h(paramObject, "$this$hashCodeAsRequestCode");
    int i = paramObject.hashCode();
    AppMethodBeat.o(176449);
    return i & 0xFFFF;
  }
  
  public static final boolean b(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(177599);
    p.h(paramActivity, "$this$safeRequestWindowFeature");
    boolean bool = ((AppCompatActivity)paramActivity).supportRequestWindowFeature(paramInt);
    AppMethodBeat.o(177599);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.g.a
 * JD-Core Version:    0.7.0.1
 */