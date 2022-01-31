package com.tencent.luggage.xweb_ext.extendplugin.component.a.b;

import android.app.Activity;
import android.support.v4.app.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class a$9
  implements a.a
{
  a$9(a parama, Activity paramActivity, com.tencent.luggage.xweb_ext.extendplugin.a parama1) {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(154403);
    ab.i(this.bGK.xo(), "onRequestPermissionsResult callback, requestCode:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 117)
    {
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        al.p(new a.9.1(this), 50L);
        AppMethodBeat.o(154403);
        return;
      }
      ab.i(this.bGK.xo(), "onRequestPermissionsResult callback, camera permission not grant");
      this.bGh.ck("fail:system permission denied");
      AppMethodBeat.o(154403);
      return;
    }
    if (paramInt == 118)
    {
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        al.p(new a.9.2(this), 50L);
        AppMethodBeat.o(154403);
        return;
      }
      ab.i(this.bGK.xo(), "onRequestPermissionsResult callback, microphone permission not grant");
      this.bGh.ck("fail:system permission denied");
    }
    AppMethodBeat.o(154403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a.9
 * JD-Core Version:    0.7.0.1
 */