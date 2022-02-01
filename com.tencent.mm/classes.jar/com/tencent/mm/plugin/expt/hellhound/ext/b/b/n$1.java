package com.tencent.mm.plugin.expt.hellhound.ext.b.b;

import android.text.TextUtils;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.d;
import com.tencent.mm.sdk.platformtools.Log;

final class n$1
  implements d
{
  n$1(n paramn) {}
  
  public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(300553);
    if ((TextUtils.isEmpty(paramString1)) || (!paramString1.startsWith("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$")))
    {
      AppMethodBeat.o(300553);
      return;
    }
    if ((!"onMMMenuItemSelected".equals(paramString2)) || (!"(Landroid/view/MenuItem;I)V".equals(paramString3)))
    {
      AppMethodBeat.o(300553);
      return;
    }
    Log.i("HABBYGE-MALI.SnsFinderMonitor", "mSnsFinderListener, runOnExit: %b", new Object[] { Boolean.valueOf(c.zGl) });
    AppMethodBeat.o(300553);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(300547);
    if ((TextUtils.isEmpty(paramString1)) || (!paramString1.startsWith("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$")))
    {
      AppMethodBeat.o(300547);
      return;
    }
    if ((!"onMMMenuItemSelected".equals(paramString2)) || (!"(Landroid/view/MenuItem;I)V".equals(paramString3)))
    {
      AppMethodBeat.o(300547);
      return;
    }
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 2))
    {
      AppMethodBeat.o(300547);
      return;
    }
    if (!(paramArrayOfObject[0] instanceof MenuItem))
    {
      AppMethodBeat.o(300547);
      return;
    }
    int i = ((MenuItem)paramArrayOfObject[0]).getItemId();
    if (i == 6) {}
    for (boolean bool = true;; bool = false)
    {
      c.zGl = bool;
      Log.i("HABBYGE-MALI.SnsFinderMonitor", "mSnsFinderListener, runOnEnter: itemId=%d, %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(c.zGl) });
      AppMethodBeat.o(300547);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.b.n.1
 * JD-Core Version:    0.7.0.1
 */