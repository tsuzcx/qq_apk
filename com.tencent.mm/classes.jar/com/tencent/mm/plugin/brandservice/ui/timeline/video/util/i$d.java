package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.MMWebView;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
final class i$d
  implements n.c
{
  i$d(i parami, boolean paramBoolean) {}
  
  public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
  {
    AppMethodBeat.i(152975);
    h.qsU.idkeyStat(480L, 0L, 1L, false);
    paraml.clear();
    if ((this.kiM) && (i.a(this.kiJ, 16)))
    {
      i = this.kiJ.kiA;
      localObject1 = this.kiJ.aZT();
      if (localObject1 != null)
      {
        localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131302283);
        paraml.a(i, (CharSequence)localObject1, 2131231024, i.b(this.kiJ, 16));
      }
    }
    else
    {
      if (i.a(this.kiJ, 8))
      {
        i = this.kiJ.kiz;
        localObject1 = this.kiJ.aZT();
        if (localObject1 == null) {
          break label249;
        }
        localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131302282);
        label136:
        paraml.a(i, (CharSequence)localObject1, 2131231038, i.b(this.kiJ, 8));
      }
      if ((!this.kiM) && (i.a(this.kiJ, 16)))
      {
        i = this.kiJ.kiA;
        localObject1 = this.kiJ.aZT();
        if (localObject1 == null) {
          break label255;
        }
      }
    }
    label249:
    label255:
    for (Object localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131302283);; localObject1 = null)
    {
      paraml.a(i, (CharSequence)localObject1, 2131231024, i.b(this.kiJ, 16));
      if (!this.kiM) {
        break label261;
      }
      AppMethodBeat.o(152975);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label136;
    }
    for (;;)
    {
      try
      {
        label261:
        Bundle localBundle = new Bundle();
        localObject1 = this.kiJ.aZT();
        if (localObject1 != null)
        {
          i = localObject1.hashCode();
          localBundle.putInt("WebViewShare_BinderID", i);
          localObject1 = this.kiJ.aZT();
          if (localObject1 == null) {
            continue;
          }
          localObject1 = ((TmplShareWebViewToolUI)localObject1).deI();
          if (localObject1 == null) {
            continue;
          }
          localObject1 = ((MMWebView)localObject1).getUrl();
          localBundle.putString("WebViewShare_wv_url", (String)localObject1);
          localObject1 = this.kiJ.aZT();
          if (localObject1 == null) {
            continue;
          }
          localObject1 = ((TmplShareWebViewToolUI)localObject1).igU;
          if (localObject1 == null) {
            continue;
          }
          localObject1 = ((d)localObject1).i(109, localBundle);
          if (localObject1 == null) {
            continue;
          }
          i = ((Bundle)localObject1).getInt("key_hao_kan_permission", 0);
        }
      }
      catch (RemoteException localRemoteException1)
      {
        int k;
        int j = -1;
        ab.e(this.kiJ.TAG, "isSetHaoKan, e = " + localRemoteException1.getMessage());
        i = -1;
        continue;
        Object localObject2 = null;
        continue;
        if ((!i.a(this.kiJ, 0)) || (i != 1)) {
          continue;
        }
        i = this.kiJ.kiD;
        localObject2 = this.kiJ.aZT();
        if (localObject2 != null)
        {
          localObject2 = ((TmplShareWebViewToolUI)localObject2).getString(2131302284);
          paraml.a(i, (CharSequence)localObject2, 2131231005);
          continue;
        }
        localObject2 = null;
        continue;
        localObject2 = null;
        continue;
        localObject2 = null;
        continue;
        localObject2 = null;
        continue;
        localObject2 = null;
        continue;
        i = -1;
        j = -1;
        continue;
      }
      try
      {
        k = ((Bundle)localObject1).getInt("key_hao_kan_recommand", -1);
        j = i;
        i = k;
        if (j == 1)
        {
          if ((!i.a(this.kiJ, 0)) || (i != 0)) {
            continue;
          }
          i = this.kiJ.kiC;
          localObject1 = this.kiJ.aZT();
          if (localObject1 == null) {
            continue;
          }
          localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131302292);
          paraml.a(i, (CharSequence)localObject1, 2131231018);
        }
        if (i.a(this.kiJ, 64))
        {
          i = this.kiJ.kiB;
          localObject1 = this.kiJ.aZT();
          if (localObject1 == null) {
            continue;
          }
          localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131302102);
          paraml.a(i, (CharSequence)localObject1, 2131231015, i.b(this.kiJ, 64));
        }
        if (i.a(this.kiJ, 1))
        {
          i = this.kiJ.kiE;
          localObject1 = this.kiJ.aZT();
          if (localObject1 == null) {
            continue;
          }
          localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131306010);
          paraml.a(i, (CharSequence)localObject1, 2131231003, i.b(this.kiJ, 1));
        }
        if (i.a(this.kiJ, 0))
        {
          i = this.kiJ.kiG;
          localObject1 = this.kiJ.aZT();
          if (localObject1 == null) {
            continue;
          }
          localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131297684);
          paraml.a(i, (CharSequence)localObject1, 2131231006, i.b(this.kiJ, 0));
        }
        if (i.a(this.kiJ, 32))
        {
          i = this.kiJ.kiF;
          localObject1 = this.kiJ.aZT();
          if (localObject1 == null) {
            continue;
          }
          localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131305999);
          paraml.a(i, (CharSequence)localObject1, 2131231007, i.b(this.kiJ, 32));
        }
        AppMethodBeat.o(152975);
        return;
      }
      catch (RemoteException localRemoteException2)
      {
        j = i;
        continue;
      }
      i = 0;
      continue;
      localObject1 = null;
      continue;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i.d
 * JD-Core Version:    0.7.0.1
 */