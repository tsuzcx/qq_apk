package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s.ba;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveVisitorWithoutAffinityUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveVisitorUIC;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "plugin-finder_release"})
public final class FinderLiveVisitorWithoutAffinityUIC
  extends FinderLiveVisitorUIC
{
  public FinderLiveVisitorWithoutAffinityUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(255825);
    AppMethodBeat.o(255825);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(255823);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramInt1 == 1005)
      {
        Object localObject = new ArrayList();
        if (paramIntent != null)
        {
          localObject = paramIntent.getStringArrayListExtra("SendMsgUsernames");
          p.g(localObject, "data.getStringArrayListE…sgRetr.KSendMsgUsernames)");
        }
        if (!((Collection)localObject).isEmpty()) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            break label228;
          }
          localObject = ((ArrayList)localObject).iterator();
          String str;
          for (paramIntent = ""; ((Iterator)localObject).hasNext(); paramIntent = paramIntent + str + ';') {
            str = (String)((Iterator)localObject).next();
          }
        }
        localObject = paramIntent;
        if (n.K(paramIntent, ";", false))
        {
          paramInt1 = paramIntent.length();
          if (paramIntent == null)
          {
            paramIntent = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(255823);
            throw paramIntent;
          }
          localObject = paramIntent.substring(0, paramInt1 - 1);
          p.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        paramIntent = m.vli;
        m.a((String)localObject, s.ba.vsY);
        AppMethodBeat.o(255823);
        return;
      }
      if (paramInt1 == 1006)
      {
        paramIntent = m.vli;
        m.a(null, s.ba.vsZ);
      }
    }
    label228:
    AppMethodBeat.o(255823);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(255824);
    p.h(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    Log.i("Finder.FinderLiveVisitorUI", "[LiveLifecycle]onConfigurationChanged orientation:" + paramConfiguration.orientation);
    AppMethodBeat.o(255824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveVisitorWithoutAffinityUIC
 * JD-Core Version:    0.7.0.1
 */