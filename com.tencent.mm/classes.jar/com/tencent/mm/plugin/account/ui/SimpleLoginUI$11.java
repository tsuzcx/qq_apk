package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.model.c.a;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.app.w;
import com.tencent.mm.pluginsdk.model.app.w.1;
import com.tencent.mm.pluginsdk.model.app.w.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

final class SimpleLoginUI$11
  implements c.a
{
  SimpleLoginUI$11(SimpleLoginUI paramSimpleLoginUI) {}
  
  public final void aqZ()
  {
    String str = null;
    AppMethodBeat.i(125606);
    w localw = new w(this.gKt, new SimpleLoginUI.11.1(this));
    Object localObject1 = ah.dsQ();
    if (localObject1 != null)
    {
      localObject1 = ((SharedPreferences)localObject1).getString("key_app_ids_registion_while_not_login", "");
      if (bo.isNullOrNil((String)localObject1)) {
        ab.i("MicroMsg.AppUtil", "no saved appids while not login");
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
        break label250;
      }
      localObject2 = str;
      if (((LinkedList)localObject1).isEmpty()) {
        break label250;
      }
      localObject2 = new LinkedList();
      localObject1 = ((LinkedList)localObject1).iterator();
      f localf;
      while (((Iterator)localObject1).hasNext())
      {
        str = (String)((Iterator)localObject1).next();
        localf = g.ca(str, false);
        if ((localf == null) || (localf.field_status == 0)) {
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
        localf = localObject2[i];
        k = j;
        if (!bo.isNullOrNil(localf))
        {
          ((LinkedList)localObject1).add(localf);
          k = j + 1;
        }
        if (k > 5) {
          break;
        }
        i += 1;
      }
    }
    label250:
    if ((localObject2 == null) || (((LinkedList)localObject2).isEmpty()))
    {
      ab.i("MicroMsg.LoadAppInfoAfterLogin", "no saved appids, just callback");
      p.dlG();
      if (localw.vLu != null) {
        localw.vLu.asg();
      }
      AppMethodBeat.o(125606);
      return;
    }
    ab.i("MicroMsg.LoadAppInfoAfterLogin", "now do batch get appinfos, appid liSst size is :%d", new Object[] { Integer.valueOf(((LinkedList)localObject2).size()) });
    a.caf().a(7, localw);
    a.cab().aH((LinkedList)localObject2);
    if ((localw.mContext != null) && (!((Activity)localw.mContext).isFinishing()))
    {
      localObject1 = localw.mContext;
      localw.mContext.getString(2131297087);
      localw.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject1, localw.mContext.getString(2131297112), true, new w.1(localw));
      AppMethodBeat.o(125606);
      return;
    }
    if (localw.vLu != null) {
      localw.vLu.asg();
    }
    ab.e("MicroMsg.LoadAppInfoAfterLogin", "dz[loadAppInfo:catch the null window for progress bar");
    AppMethodBeat.o(125606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.SimpleLoginUI.11
 * JD-Core Version:    0.7.0.1
 */