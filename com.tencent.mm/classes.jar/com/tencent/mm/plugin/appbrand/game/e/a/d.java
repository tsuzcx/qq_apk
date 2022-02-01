package com.tencent.mm.plugin.appbrand.game.e.a;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import com.tencent.luggage.h.e;
import com.tencent.luggage.h.e.c;
import com.tencent.luggage.sdk.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.game.g.a.a;
import com.tencent.mm.plugin.appbrand.game.g.b;
import com.tencent.mm.plugin.appbrand.game.g.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.game.api.GameShareOption;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class d
  extends c
{
  protected final void a(final com.tencent.mm.plugin.appbrand.service.c paramc, final int paramInt, b.a parama, String paramString, ArrayList<GameShareOption> paramArrayList, b.d paramd)
  {
    Object localObject = null;
    AppMethodBeat.i(45144);
    ad.i("MicroMsg.WAGameJsApiScreenRecorderEditWC", "hy: wc start edit screen recorder, with result is %s", new Object[] { paramd });
    final int i = a.aC(this);
    Activity localActivity = paramc.au(Activity.class);
    if (localActivity == null)
    {
      paramc.h(paramInt, e("fail:internal error invalid android context", null));
      AppMethodBeat.o(45144);
      return;
    }
    e.aA(localActivity).b(new e.c()
    {
      public final boolean b(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(174728);
        if (paramAnonymousInt1 == i)
        {
          ad.i("MicroMsg.WAGameJsApiScreenRecorderEditWC", "hy: on result callback, result code: %d", new Object[] { Integer.valueOf(paramAnonymousInt2) });
          if ((paramAnonymousInt2 == 0) || (paramAnonymousInt2 == 3001))
          {
            ad.i("MicroMsg.WAGameJsApiScreenRecorderEditWC", "hy: user cancelled share!");
            paramAnonymousIntent = new HashMap(1);
            paramAnonymousIntent.put("errCode", Integer.valueOf(803));
            paramc.h(paramInt, d.this.m("fail: user cancelled", paramAnonymousIntent));
          }
          for (;;)
          {
            AppMethodBeat.o(174728);
            return true;
            if ((paramAnonymousInt2 == -1) && (paramAnonymousIntent != null) && (paramAnonymousIntent.hasExtra("key_req_result")))
            {
              SightCaptureResult localSightCaptureResult = (SightCaptureResult)paramAnonymousIntent.getParcelableExtra("key_req_result");
              paramAnonymousInt1 = paramAnonymousIntent.getIntExtra("key_selected_item", 0);
              paramAnonymousIntent = paramAnonymousIntent.getStringExtra("key_ext_url");
              ad.i("MicroMsg.WAGameJsApiScreenRecorderEditWC", "hy: is video: %b, video path %s, thumb path: %s, md5: %s, selectedItem: %d, extUrl: %s", new Object[] { Boolean.valueOf(localSightCaptureResult.pzW), localSightCaptureResult.vMu, localSightCaptureResult.vMv, localSightCaptureResult.vMx, Integer.valueOf(paramAnonymousInt1), paramAnonymousIntent });
              if (!localSightCaptureResult.pzW)
              {
                d.this.a(paramc, paramInt, 3, 804, "not a video");
              }
              else if ((bt.isNullOrNil(localSightCaptureResult.vMw)) || (bt.isNullOrNil(localSightCaptureResult.vMx)))
              {
                d.this.a(paramc, paramInt, 1, 804, "edit failed!");
              }
              else
              {
                Object localObject2 = localSightCaptureResult.vMu;
                Object localObject1 = localSightCaptureResult.vMv;
                Bitmap localBitmap = com.tencent.mm.plugin.mmsight.d.Gq((String)localObject2);
                if (localBitmap != null) {}
                for (;;)
                {
                  try
                  {
                    com.tencent.mm.sdk.platformtools.g.a(localBitmap, 100, Bitmap.CompressFormat.JPEG, (String)localObject1, true);
                    localObject2 = d.this.a(paramc, (String)localObject2, "edited_video.mp4", bt.isNullOrNil(paramAnonymousIntent));
                    localObject1 = d.this.a(paramc, (String)localObject1, "edited_video_thumb.jpg", bt.isNullOrNil(paramAnonymousIntent));
                    if (localObject2 != null) {
                      break;
                    }
                    ad.w("MicroMsg.WAGameJsApiScreenRecorderEditWC", "hy: save video temp file failed!");
                    d.this.a(paramc, paramInt, 1, 804, "video file save to file system failed!");
                    AppMethodBeat.o(174728);
                    return true;
                  }
                  catch (IOException localIOException)
                  {
                    ad.printErrStackTrace("MicroMsg.WAGameJsApiScreenRecorderEditWC", localIOException, "hy: exception when convert bitmap", new Object[0]);
                    continue;
                  }
                  ad.i("MicroMsg.WAGameJsApiScreenRecorderEditWC", "hy: generated thumb path is null!");
                }
                if (localObject1 == null)
                {
                  ad.w("MicroMsg.WAGameJsApiScreenRecorderEditWC", "hy: save thumb temp file failed!");
                  d.this.a(paramc, paramInt, 1, 804, "video thumb file save to file system failed!");
                  AppMethodBeat.o(174728);
                  return true;
                }
                HashMap localHashMap = new HashMap(3);
                localHashMap.put("errCode", Integer.valueOf(0));
                localHashMap.put("videoPath", ((b.a)localObject2).klD);
                localHashMap.put("thumbPath", ((b.a)localObject1).klD);
                localHashMap.put("videoMD5", localSightCaptureResult.vMx);
                localHashMap.put("chosenId", Integer.valueOf(paramAnonymousInt1));
                localHashMap.put("extUrl", paramAnonymousIntent);
                paramc.h(paramInt, d.this.m("ok", localHashMap));
              }
            }
            else
            {
              d.this.a(paramc, paramInt, 1, 804, "edit file failed!");
            }
          }
        }
        AppMethodBeat.o(174728);
        return false;
      }
    });
    Bundle localBundle = new Bundle();
    localBundle.putString("k_ext_wording", paramString);
    localBundle.putParcelableArrayList("k_ext_share_options", paramArrayList);
    paramArrayList = b.a(paramc.getAppId(), f(paramc));
    paramString = localObject;
    if (paramArrayList.knQ != null) {
      paramString = paramArrayList.knQ.bhD();
    }
    paramString.audioBitrate = 64000;
    paramString.audioSampleRate = paramd.audioSampleRate;
    paramString.audioChannelCount = 1;
    localBundle.putParcelable("k_preferred_trans_param", paramString);
    if ((paramc.getRuntime() != null) && (paramc.getRuntime().aXb() != null)) {}
    for (paramString = paramc.getRuntime().aXb().doD;; paramString = "")
    {
      ((com.tencent.mm.plugin.game.api.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.g.class)).a(localActivity, paramc.getAppId(), paramString, parama.klC, i, localBundle);
      AppMethodBeat.o(45144);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.a.d
 * JD-Core Version:    0.7.0.1
 */