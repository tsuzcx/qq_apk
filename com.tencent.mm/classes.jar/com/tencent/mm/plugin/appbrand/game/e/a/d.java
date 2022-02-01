package com.tencent.mm.plugin.appbrand.game.e.a;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import com.tencent.luggage.k.f;
import com.tencent.luggage.k.f.c;
import com.tencent.luggage.sdk.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.game.g.a.a;
import com.tencent.mm.plugin.appbrand.game.g.b;
import com.tencent.mm.plugin.appbrand.game.g.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.game.api.GameShareOption;
import com.tencent.mm.plugin.game.api.g;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
    Log.i("MicroMsg.WAGameJsApiScreenRecorderEditWC", "hy: wc start edit screen recorder, with result is %s", new Object[] { paramd });
    final int i = a.aI(this);
    Activity localActivity = paramc.ax(Activity.class);
    if (localActivity == null)
    {
      paramc.j(paramInt, h("fail:internal error invalid android context", null));
      AppMethodBeat.o(45144);
      return;
    }
    f.aI(localActivity).b(new f.c()
    {
      public final boolean c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(174728);
        if (paramAnonymousInt1 == i)
        {
          Log.i("MicroMsg.WAGameJsApiScreenRecorderEditWC", "hy: on result callback, result code: %d", new Object[] { Integer.valueOf(paramAnonymousInt2) });
          if ((paramAnonymousInt2 == 0) || (paramAnonymousInt2 == 3001))
          {
            Log.i("MicroMsg.WAGameJsApiScreenRecorderEditWC", "hy: user cancelled share!");
            paramAnonymousIntent = new HashMap(1);
            paramAnonymousIntent.put("errCode", Integer.valueOf(803));
            paramc.j(paramInt, d.this.m("fail: user cancelled", paramAnonymousIntent));
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
              Log.i("MicroMsg.WAGameJsApiScreenRecorderEditWC", "hy: is video: %b, video path %s, thumb path: %s, md5: %s, selectedItem: %d, extUrl: %s", new Object[] { Boolean.valueOf(localSightCaptureResult.wRb), localSightCaptureResult.EYb, localSightCaptureResult.EYc, localSightCaptureResult.EYe, Integer.valueOf(paramAnonymousInt1), paramAnonymousIntent });
              if (!localSightCaptureResult.wRb)
              {
                d.this.a(paramc, paramInt, 3, 804, "not a video");
              }
              else if ((Util.isNullOrNil(localSightCaptureResult.EYd)) || (Util.isNullOrNil(localSightCaptureResult.EYe)))
              {
                d.this.a(paramc, paramInt, 1, 804, "edit failed!");
              }
              else
              {
                Object localObject2 = localSightCaptureResult.EYb;
                Object localObject1 = localSightCaptureResult.EYc;
                Bitmap localBitmap = com.tencent.mm.plugin.mmsight.d.Xd((String)localObject2);
                if (localBitmap != null) {}
                for (;;)
                {
                  try
                  {
                    BitmapUtil.saveBitmapToImage(localBitmap, 100, Bitmap.CompressFormat.JPEG, (String)localObject1, true);
                    localObject2 = d.this.a(paramc, (String)localObject2, "edited_video.mp4", Util.isNullOrNil(paramAnonymousIntent));
                    localObject1 = d.this.a(paramc, (String)localObject1, "edited_video_thumb.jpg", Util.isNullOrNil(paramAnonymousIntent));
                    if (localObject2 != null) {
                      break;
                    }
                    Log.w("MicroMsg.WAGameJsApiScreenRecorderEditWC", "hy: save video temp file failed!");
                    d.this.a(paramc, paramInt, 1, 804, "video file save to file system failed!");
                    AppMethodBeat.o(174728);
                    return true;
                  }
                  catch (IOException localIOException)
                  {
                    Log.printErrStackTrace("MicroMsg.WAGameJsApiScreenRecorderEditWC", localIOException, "hy: exception when convert bitmap", new Object[0]);
                    continue;
                  }
                  Log.i("MicroMsg.WAGameJsApiScreenRecorderEditWC", "hy: generated thumb path is null!");
                }
                if (localObject1 == null)
                {
                  Log.w("MicroMsg.WAGameJsApiScreenRecorderEditWC", "hy: save thumb temp file failed!");
                  d.this.a(paramc, paramInt, 1, 804, "video thumb file save to file system failed!");
                  AppMethodBeat.o(174728);
                  return true;
                }
                HashMap localHashMap = new HashMap(3);
                localHashMap.put("errCode", Integer.valueOf(0));
                localHashMap.put("videoPath", ((b.a)localObject2).onz);
                localHashMap.put("thumbPath", ((b.a)localObject1).onz);
                localHashMap.put("videoMD5", localSightCaptureResult.EYe);
                localHashMap.put("chosenId", Integer.valueOf(paramAnonymousInt1));
                localHashMap.put("extUrl", paramAnonymousIntent);
                paramc.j(paramInt, d.this.m("ok", localHashMap));
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
    paramArrayList = g(paramc);
    paramString = localObject;
    if (paramArrayList.opM != null) {
      paramString = paramArrayList.opM.bOY();
    }
    paramString.audioBitrate = 64000;
    paramString.audioSampleRate = paramd.audioSampleRate;
    paramString.audioChannelCount = 1;
    localBundle.putParcelable("k_preferred_trans_param", paramString);
    if ((paramc.getRuntime() != null) && (paramc.getRuntime().bDx() != null)) {}
    for (paramString = paramc.getRuntime().bDx().fzM;; paramString = "")
    {
      ((g)h.ae(g.class)).a(localActivity, paramc.getAppId(), paramString, parama.ony, i, localBundle);
      AppMethodBeat.o(45144);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.a.d
 * JD-Core Version:    0.7.0.1
 */