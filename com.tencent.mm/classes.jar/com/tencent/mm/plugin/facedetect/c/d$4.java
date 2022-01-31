package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;

final class d$4
  implements View.OnClickListener
{
  d$4(d paramd, Bundle paramBundle, int paramInt, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(137);
    if (bo.isNullOrNil(this.mhH.mhE))
    {
      ab.e("MicroMsg.FaceDetectMpController", "alvinluo feedback url is null");
      AppMethodBeat.o(137);
      return;
    }
    if ((this.mhH.mhp != null) && (this.mhH.mhp.get() != null)) {
      ((f)this.mhH.mhp.get()).buh();
    }
    paramView = null;
    if (this.mhD != null) {
      paramView = this.mhD.getString("verify_result");
    }
    try
    {
      Object localObject;
      int i;
      if (this.mhH.appId != null)
      {
        localObject = this.mhH.appId;
        i = this.val$errCode;
        if (paramView == null) {
          break label236;
        }
      }
      for (;;)
      {
        paramView = q.encode(String.format("appid=%s;errcode=%d;identifyid=%s", new Object[] { localObject, Integer.valueOf(i), paramView }), "UTF-8");
        paramView = this.mhH.mhE + "?customInfo=" + paramView;
        ab.i("MicroMsg.FaceDetectMpController", "alvinluo feedback url: %s", new Object[] { paramView });
        localObject = new Intent();
        ((Intent)localObject).putExtra("rawUrl", paramView);
        com.tencent.mm.bq.d.b(this.val$context, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
        AppMethodBeat.o(137);
        return;
        localObject = "";
        break;
        label236:
        paramView = "";
      }
      return;
    }
    catch (Exception paramView)
    {
      ab.printErrStackTrace("MicroMsg.FaceDetectMpController", paramView, "alvinluo start feedback webview exception", new Object[0]);
      AppMethodBeat.o(137);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.c.d.4
 * JD-Core Version:    0.7.0.1
 */