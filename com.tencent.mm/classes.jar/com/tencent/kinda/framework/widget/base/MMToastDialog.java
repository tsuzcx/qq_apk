package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.framework.widget.tools.ResourcesUtils;
import com.tencent.kinda.gen.KToastDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.t;

public class MMToastDialog
  implements KToastDialog
{
  private static final String TAG = "MMToastDialog";
  
  public void show(String paramString1, String paramString2)
  {
    AppMethodBeat.i(193252);
    Context localContext = KindaContext.get();
    if (localContext == null)
    {
      ae.e("MMToastDialog", "MMToastDialog showImpl() KindaContext.get() return null!");
      AppMethodBeat.o(193252);
      return;
    }
    int i = ResourcesUtils.getDrawableId(ak.getContext(), paramString2);
    int j = ResourcesUtils.getResId(ak.getContext(), paramString2, "raw");
    if (j != 0) {
      i = j;
    }
    for (;;)
    {
      t.v(localContext, paramString1, i);
      AppMethodBeat.o(193252);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMToastDialog
 * JD-Core Version:    0.7.0.1
 */