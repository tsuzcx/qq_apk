package com.tencent.mm.plugin.gallery.b;

import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/utils/MediaUtil;", "", "()V", "TAG", "", "getVideoInfo", "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "filePath", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g HRf;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(165053);
    HRf = new g();
    TAG = "MicroMsg.MediaUtil";
    AppMethodBeat.o(165053);
  }
  
  public static b aBH(String paramString)
  {
    AppMethodBeat.i(165052);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      paramString = new b();
      AppMethodBeat.o(165052);
      return paramString;
    }
    Object localObject2 = f.aVX(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new b();
    }
    if ((((b)localObject1).height <= 0) || (((b)localObject1).width <= 0)) {}
    try
    {
      localObject2 = new MediaMetadataRetriever();
      ((MediaMetadataRetriever)localObject2).setDataSource(paramString);
      ((b)localObject1).width = Util.getInt(((MediaMetadataRetriever)localObject2).extractMetadata(18), 0);
      ((b)localObject1).height = Util.getInt(((MediaMetadataRetriever)localObject2).extractMetadata(19), 0);
      ((b)localObject1).videoBitrate = Util.getInt(((MediaMetadataRetriever)localObject2).extractMetadata(20), 0);
      ((b)localObject1).videoDuration = Util.getInt(((MediaMetadataRetriever)localObject2).extractMetadata(9), 0);
      ((MediaMetadataRetriever)localObject2).release();
      label136:
      int i = SightVideoJNI.getMp4RotateVFS(paramString);
      Log.i(TAG, "width %d, height %d, rotate %d", new Object[] { Integer.valueOf(((b)localObject1).width), Integer.valueOf(((b)localObject1).height), Integer.valueOf(i) });
      switch (i)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(165052);
        return localObject1;
        i = ((b)localObject1).height;
        ((b)localObject1).height = ((b)localObject1).width;
        paramString = ah.aiuX;
        ((b)localObject1).width = i;
      }
    }
    catch (Exception localException)
    {
      break label136;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.b.g
 * JD-Core Version:    0.7.0.1
 */