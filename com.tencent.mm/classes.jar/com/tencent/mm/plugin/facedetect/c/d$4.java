package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

final class d$4
  implements View.OnClickListener
{
  d$4(d paramd, Bundle paramBundle, int paramInt, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    if (bk.bl(this.jNw.jNv))
    {
      y.e("MicroMsg.FaceDetectMpController", "alvinluo feedback url is null");
      return;
    }
    if ((this.jNw.jNg != null) && (this.jNw.jNg.get() != null)) {
      ((e)this.jNw.jNg.get()).aOe();
    }
    paramView = null;
    if (this.jNu != null) {
      paramView = this.jNu.getString("verify_result");
    }
    for (;;)
    {
      try
      {
        if (this.jNw.appId != null)
        {
          localObject = this.jNw.appId;
          int i = this.bEg;
          if (paramView == null) {
            break label232;
          }
          paramView = q.encode(String.format("appid=%s;errcode=%d;identifyid=%s", new Object[] { localObject, Integer.valueOf(i), paramView }), "UTF-8");
          paramView = this.jNw.jNv + "?customInfo=" + paramView;
          y.i("MicroMsg.FaceDetectMpController", "alvinluo feedback url: %s", new Object[] { paramView });
          localObject = new Intent();
          ((Intent)localObject).putExtra("rawUrl", paramView);
          com.tencent.mm.br.d.b(this.val$context, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
          return;
        }
      }
      catch (Exception paramView)
      {
        y.printErrStackTrace("MicroMsg.FaceDetectMpController", paramView, "alvinluo start feedback webview exception", new Object[0]);
        return;
      }
      Object localObject = "";
      continue;
      label232:
      paramView = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.c.d.4
 * JD-Core Version:    0.7.0.1
 */