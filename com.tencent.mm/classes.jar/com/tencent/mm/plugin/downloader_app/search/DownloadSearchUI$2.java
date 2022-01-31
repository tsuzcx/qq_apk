package com.tencent.mm.plugin.downloader_app.search;

import android.content.pm.PackageInfo;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.plugin.downloader.c.a.a.h;
import com.tencent.mm.plugin.downloader.c.a.a.i;
import com.tencent.mm.plugin.downloader.c.b.f;
import com.tencent.mm.plugin.downloader.c.b.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class DownloadSearchUI$2
  implements w.a
{
  DownloadSearchUI$2(DownloadSearchUI paramDownloadSearchUI, String paramString) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.b paramb, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(136182);
    ab.i("MicroMsg.DownloadSearchUI", "errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (DownloadSearchUI.c(this.lbG))
    {
      AppMethodBeat.o(136182);
      return 0;
    }
    DownloadSearchUI.d(this.lbG).setVisibility(8);
    Object localObject1;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (com.tencent.mm.plugin.downloader.c.a.a.m)paramb.fsW.fta;
      if ((paramString == null) || (paramString.kWg == null) || (bo.es(paramString.kWg.kVZ))) {
        break label613;
      }
      paramm = new ArrayList();
      paramInt1 = 0;
      Iterator localIterator = paramString.kWg.kVZ.iterator();
      if (localIterator.hasNext())
      {
        paramString = (h)localIterator.next();
        localObject1 = this.lbH;
        if (paramString == null)
        {
          paramString = null;
          label159:
          if (paramString == null) {
            break label689;
          }
          paramInt1 += 1;
          paramString.position = paramInt1;
          paramm.add(paramString);
        }
      }
    }
    label689:
    for (;;)
    {
      break;
      paramb = new b();
      paramb.type = 3;
      Object localObject3 = paramString.kVX;
      if (localObject3 == null)
      {
        paramString = null;
        break label159;
      }
      Object localObject2 = ((com.tencent.mm.plugin.downloader.c.a.a.d)localObject3).kVQ;
      localObject3 = ((com.tencent.mm.plugin.downloader.c.a.a.d)localObject3).kVS;
      if (localObject3 != null) {
        paramb.jumpUrl = ((com.tencent.mm.plugin.downloader.c.a.a.c)localObject3).kVP;
      }
      if (localObject2 == null)
      {
        paramString = null;
        break label159;
      }
      localObject3 = ((j)localObject2).kWV;
      com.tencent.mm.plugin.downloader.c.b.d locald = ((j)localObject2).kWW;
      localObject2 = ((j)localObject2).kWX;
      if (localObject3 == null)
      {
        paramString = null;
        break label159;
      }
      if (((com.tencent.mm.plugin.downloader.c.b.c)localObject3).status != 0)
      {
        paramString = null;
        break label159;
      }
      paramb.appId = ((com.tencent.mm.plugin.downloader.c.b.c)localObject3).cwc;
      paramb.lbJ = paramString.kVY;
      paramb.iconUrl = ((com.tencent.mm.plugin.downloader.c.b.c)localObject3).kWy;
      if ((locald != null) && (!bo.es(locald.kWE))) {
        paramb.lbK = locald.kWE;
      }
      if ((localObject2 != null) && (((f)localObject2).kWM != null)) {
        paramb.size = ((f)localObject2).kWM.kWo;
      }
      paramb.lbI = ((String)localObject1);
      paramb.state = 1;
      paramString = paramb;
      if (localObject2 == null) {
        break label159;
      }
      paramString = paramb;
      if (((f)localObject2).kWM == null) {
        break label159;
      }
      paramString = com.tencent.mm.plugin.appbrand.s.b.getPackageInfo(ah.getContext(), ((f)localObject2).kWM.kWn);
      localObject1 = com.tencent.mm.plugin.downloader.model.d.JD(paramb.appId);
      if (paramString == null)
      {
        paramString = paramb;
        if (localObject1 == null) {
          break label159;
        }
        paramString = paramb;
        if (((com.tencent.mm.plugin.downloader.g.a)localObject1).field_status != 3) {
          break label159;
        }
        paramString = paramb;
        if (!e.cN(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_filePath)) {
          break label159;
        }
        paramb.state = 4;
        paramString = paramb;
        break label159;
      }
      if (paramString.versionCode < ((f)localObject2).kWM.kWr)
      {
        paramb.state = 3;
        paramString = paramb;
        break label159;
      }
      paramb.state = 2;
      paramString = paramb;
      break label159;
      DownloadSearchUI.e(this.lbG).setVisibility(8);
      paramString = DownloadSearchUI.a(this.lbG);
      paramString.setVisibility(0);
      paramString.lbz.clear();
      if (!bo.es(paramm)) {
        paramString.lbz.addAll(paramm);
      }
      paramString.setData(paramString.lbz);
      com.tencent.mm.plugin.downloader_app.c.a.a(13, 1303, 0, 1, "", "", "");
      for (;;)
      {
        AppMethodBeat.o(136182);
        return 0;
        label613:
        DownloadSearchUI.a(this.lbG).setVisibility(8);
        DownloadSearchUI.e(this.lbG).setVisibility(0);
        DownloadSearchUI.e(this.lbG).setText(this.lbG.getString(2131299040, new Object[] { this.lbH }));
        com.tencent.mm.plugin.downloader_app.c.a.a(13, 1304, 0, 1, "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.search.DownloadSearchUI.2
 * JD-Core Version:    0.7.0.1
 */