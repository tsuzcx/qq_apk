package com.tencent.mm.console;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.eggspring.d.a;

final class a$7
  implements com.tencent.mm.am.h
{
  a$7(Context paramContext) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(20119);
    if (2812 == paramp.getType())
    {
      com.tencent.mm.kernel.h.aZW().b(2812, this);
      paramString = (a)paramp;
      Toast.makeText(this.val$context, "errType:" + paramInt1 + ", errCode:" + paramInt2 + ", coupon ret_code:" + paramString.xEF + ", coupon ret_msg:" + paramString.xEG + ".", 1).show();
    }
    AppMethodBeat.o(20119);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.a.7
 * JD-Core Version:    0.7.0.1
 */