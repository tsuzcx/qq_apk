package com.tencent.mm.plugin.appbrand.game.e.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

final class d$1
  implements MMActivity.a
{
  d$1(d paramd, c paramc, int paramInt) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(143157);
    if (paramInt1 == 1000)
    {
      ab.i("MicroMsg.WAGameJsApiScreenRecorderEditWC", "hy: on result callback, result code: %d", new Object[] { Integer.valueOf(paramInt2) });
      if (paramInt2 == 0)
      {
        ab.i("MicroMsg.WAGameJsApiScreenRecorderEditWC", "hy: user cancelled share!");
        paramIntent = new HashMap(1);
        paramIntent.put("errCode", Integer.valueOf(803));
        this.htp.h(this.bAX, this.htt.j("fail: user cancelled", paramIntent));
        AppMethodBeat.o(143157);
        return;
      }
      if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.hasExtra("key_req_result")))
      {
        SightCaptureResult localSightCaptureResult = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
        paramInt1 = paramIntent.getIntExtra("key_selected_item", 0);
        paramIntent = paramIntent.getStringExtra("key_ext_url");
        ab.i("MicroMsg.WAGameJsApiScreenRecorderEditWC", "hy: is video: %b, video path %s, thumb path: %s, md5: %s, selectedItem: %d, extUrl: %s", new Object[] { Boolean.valueOf(localSightCaptureResult.mCu), localSightCaptureResult.oFI, localSightCaptureResult.oFJ, localSightCaptureResult.oFL, Integer.valueOf(paramInt1), paramIntent });
        if (!localSightCaptureResult.mCu)
        {
          this.htt.a(this.htp, this.bAX, 3, 804, "not a video");
          AppMethodBeat.o(143157);
          return;
        }
        if ((bo.isNullOrNil(localSightCaptureResult.oFK)) || (bo.isNullOrNil(localSightCaptureResult.oFL)))
        {
          this.htt.a(this.htp, this.bAX, 1, 804, "edit failed!");
          AppMethodBeat.o(143157);
          return;
        }
        Object localObject1 = localSightCaptureResult.oFI;
        Object localObject2 = localSightCaptureResult.oFJ;
        localObject1 = this.htt.a(this.htp, (String)localObject1, "edited_video.mp4", bo.isNullOrNil(paramIntent));
        localObject2 = this.htt.a(this.htp, (String)localObject2, "edited_video_thumb.jpg", bo.isNullOrNil(paramIntent));
        if (localObject1 == null)
        {
          ab.w("MicroMsg.WAGameJsApiScreenRecorderEditWC", "hy: save video temp file failed!");
          this.htt.a(this.htp, this.bAX, 1, 804, "video file save to file system failed!");
          AppMethodBeat.o(143157);
          return;
        }
        if (localObject2 == null)
        {
          ab.w("MicroMsg.WAGameJsApiScreenRecorderEditWC", "hy: save thumb temp file failed!");
          this.htt.a(this.htp, this.bAX, 1, 804, "video thumb file save to file system failed!");
          AppMethodBeat.o(143157);
          return;
        }
        HashMap localHashMap = new HashMap(3);
        localHashMap.put("errCode", Integer.valueOf(0));
        localHashMap.put("videoPath", ((b.a)localObject1).htn);
        localHashMap.put("thumbPath", ((b.a)localObject2).htn);
        localHashMap.put("videoMD5", localSightCaptureResult.oFL);
        localHashMap.put("chosenId", Integer.valueOf(paramInt1));
        localHashMap.put("extUrl", paramIntent);
        this.htp.h(this.bAX, this.htt.j("ok", localHashMap));
        AppMethodBeat.o(143157);
        return;
      }
      this.htt.a(this.htp, this.bAX, 1, 804, "edit file failed!");
    }
    AppMethodBeat.o(143157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.a.d.1
 * JD-Core Version:    0.7.0.1
 */