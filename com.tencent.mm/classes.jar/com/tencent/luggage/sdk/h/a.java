package com.tencent.luggage.sdk.h;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/wxa_ktx/ActivityUtils;", "", "()V", "REQUEST_CODE_LOW_BITS_MAGIC_NUM", "", "TAG", "", "hashCodeAsRequestCode", "safeRequestWindowFeature", "", "Landroid/app/Activity;", "feature", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a evH;
  
  static
  {
    AppMethodBeat.i(176450);
    evH = new a();
    AppMethodBeat.o(176450);
  }
  
  public static final boolean b(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(177599);
    s.u(paramActivity, "<this>");
    boolean bool = ((AppCompatActivity)paramActivity).supportRequestWindowFeature(paramInt);
    AppMethodBeat.o(177599);
    return bool;
  }
  
  public static final int ce(Object paramObject)
  {
    AppMethodBeat.i(176449);
    s.u(paramObject, "<this>");
    int i = paramObject.hashCode();
    AppMethodBeat.o(176449);
    return i & 0xFFFF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.sdk.h.a
 * JD-Core Version:    0.7.0.1
 */