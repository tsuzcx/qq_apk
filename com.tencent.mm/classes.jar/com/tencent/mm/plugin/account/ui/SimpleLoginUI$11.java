package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.model.c.a;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.pluginsdk.model.app.e;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.model.app.y;
import com.tencent.mm.pluginsdk.model.app.y.1;
import com.tencent.mm.pluginsdk.model.app.y.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;

final class SimpleLoginUI$11
  implements c.a
{
  SimpleLoginUI$11(SimpleLoginUI paramSimpleLoginUI) {}
  
  public final void aQq()
  {
    String str = null;
    AppMethodBeat.i(128768);
    y localy = new y(this.iYc, new y.a()
    {
      public final void aRA()
      {
        AppMethodBeat.i(128767);
        SimpleLoginUI.j(SimpleLoginUI.11.this.iYc);
        AppMethodBeat.o(128767);
      }
    });
    Object localObject1 = ai.eUY();
    if (localObject1 != null)
    {
      localObject1 = ((SharedPreferences)localObject1).getString("key_app_ids_registion_while_not_login", "");
      if (bs.isNullOrNil((String)localObject1)) {
        ac.i("MicroMsg.AppUtil", "no saved appids while not login");
      }
    }
    else
    {
      localObject1 = null;
    }
    Object localObject2;
    for (;;)
    {
      localObject2 = str;
      if (localObject1 == null) {
        break label251;
      }
      localObject2 = str;
      if (((LinkedList)localObject1).isEmpty()) {
        break label251;
      }
      localObject2 = new LinkedList();
      localObject1 = ((LinkedList)localObject1).iterator();
      g localg;
      while (((Iterator)localObject1).hasNext())
      {
        str = (String)((Iterator)localObject1).next();
        localg = com.tencent.mm.pluginsdk.model.app.h.k(str, false, false);
        if ((localg == null) || (localg.field_status == 0)) {
          ((LinkedList)localObject2).add(str);
        }
      }
      localObject2 = ((String)localObject1).split("\\|");
      if ((localObject2 == null) || (localObject2.length <= 0)) {
        break;
      }
      localObject1 = new LinkedList();
      int m = localObject2.length;
      int i = 0;
      int k;
      for (int j = 1; i < m; j = k)
      {
        localg = localObject2[i];
        k = j;
        if (!bs.isNullOrNil(localg))
        {
          ((LinkedList)localObject1).add(localg);
          k = j + 1;
        }
        if (k > 5) {
          break;
        }
        i += 1;
      }
    }
    label251:
    if ((localObject2 == null) || (((LinkedList)localObject2).isEmpty()))
    {
      ac.i("MicroMsg.LoadAppInfoAfterLogin", "no saved appids, just callback");
      q.eLh();
      if (localy.Dis != null) {
        localy.Dis.aRA();
      }
      AppMethodBeat.o(128768);
      return;
    }
    ac.i("MicroMsg.LoadAppInfoAfterLogin", "now do batch get appinfos, appid liSst size is :%d", new Object[] { Integer.valueOf(((LinkedList)localObject2).size()) });
    a.dnB().a(7, localy);
    a.dnx().bi((LinkedList)localObject2);
    if ((localy.mContext != null) && (!((Activity)localy.mContext).isFinishing()))
    {
      localObject1 = localy.mContext;
      localy.mContext.getString(2131755906);
      localy.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject1, localy.mContext.getString(2131755936), true, new y.1(localy));
      AppMethodBeat.o(128768);
      return;
    }
    if (localy.Dis != null) {
      localy.Dis.aRA();
    }
    ac.e("MicroMsg.LoadAppInfoAfterLogin", "dz[loadAppInfo:catch the null window for progress bar");
    AppMethodBeat.o(128768);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.SimpleLoginUI.11
 * JD-Core Version:    0.7.0.1
 */