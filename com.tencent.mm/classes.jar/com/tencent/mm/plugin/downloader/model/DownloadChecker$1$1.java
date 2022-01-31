package com.tencent.mm.plugin.downloader.model;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCLong;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.xweb.WebView;
import java.lang.ref.WeakReference;

final class DownloadChecker$1$1
  implements Runnable
{
  DownloadChecker$1$1(DownloadChecker.1 param1, DownloadChecker.DownloadInterceptBean paramDownloadInterceptBean) {}
  
  public final void run()
  {
    AppMethodBeat.i(2342);
    Object localObject1;
    Object localObject3;
    Object localObject2;
    if ((this.kXL.kXJ != null) && (this.kXL.kXJ.get() != null))
    {
      localObject1 = (WebView)this.kXL.kXJ.get();
      if (localObject1 != null)
      {
        localObject3 = ((WebView)localObject1).getContext();
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
    }
    for (;;)
    {
      if ((this.kXK == null) || (!this.kXK.cmX))
      {
        if (localObject2 != null)
        {
          localObject2.loadUrl(this.kXL.val$downloadUrl);
          ab.i("MicroMsg.DownloadChecker", "reload apk");
          AppMethodBeat.o(2342);
        }
      }
      else
      {
        ab.i("MicroMsg.DownloadChecker", "confirm type: %d", new Object[] { Integer.valueOf(this.kXK.kXO) });
        if (localObject1 != null) {
          break label580;
        }
        localObject1 = ah.getContext();
      }
      label580:
      for (;;)
      {
        switch (this.kXK.kXO)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(2342);
          return;
          if (!at.isNetworkConnected(ah.getContext()))
          {
            Toast.makeText(ah.getContext(), ah.getContext().getString(2131300360), 0).show();
            ab.i("MicroMsg.DownloadChecker", "startDownload fail, network not ready");
            AppMethodBeat.o(2342);
            return;
          }
          if ((at.isWifi(ah.getContext())) || (!(localObject1 instanceof MMActivity)) || (((MMActivity)localObject1).isFinishing()))
          {
            if (((IPCLong)f.a("com.tencent.mm", this.kXK, DownloadChecker.a.class)).value > 0L) {
              Toast.makeText(ah.getContext(), ah.getContext().getString(2131299883), 0).show();
            }
            AppMethodBeat.o(2342);
            return;
          }
          h.a((Context)localObject1, ah.getResources().getString(2131305852), ah.getResources().getString(2131305853), ah.getResources().getString(2131305847), ah.getResources().getString(2131296888), false, new DownloadChecker.1.1.1(this), new DownloadChecker.1.1.2(this), 2131690701);
          AppMethodBeat.o(2342);
          return;
          localObject3 = new Intent();
          ((Intent)localObject3).setClassName((Context)localObject1, "com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI");
          ((Intent)localObject3).putExtra("task_name", this.kXK.appName);
          ((Intent)localObject3).putExtra("title", this.kXK.appName);
          ((Intent)localObject3).putExtra("thumb_url", this.kXK.iconUrl);
          ((Intent)localObject3).putExtra("task_url", this.kXK.downloadUrl);
          ((Intent)localObject3).putExtra("alternative_url", this.kXK.kXQ);
          ((Intent)localObject3).putExtra("task_size", this.kXK.size);
          ((Intent)localObject3).putExtra("file_md5", this.kXK.cqq);
          ((Intent)localObject3).putExtra("fileType", 1);
          ((Intent)localObject3).putExtra("appid", this.kXK.appId);
          ((Intent)localObject3).putExtra("package_name", this.kXK.packageName);
          if (localObject2 != null) {
            ((Intent)localObject3).putExtra("page_url", localObject2.getUrl());
          }
          ((Intent)localObject3).putExtra("page_scene", -1);
          ((Intent)localObject3).putExtra("task_scene", 8070);
          ((Intent)localObject3).addFlags(268435456);
          ah.getContext().startActivity((Intent)localObject3);
          AppMethodBeat.o(2342);
          return;
          ab.i("MicroMsg.DownloadChecker", "coonfirm url: %s", new Object[] { this.kXK.kXP });
        }
      }
      localObject3 = null;
      localObject2 = localObject1;
      localObject1 = localObject3;
      continue;
      localObject1 = null;
      localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.DownloadChecker.1.1
 * JD-Core Version:    0.7.0.1
 */