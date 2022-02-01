package com.tencent.mm.plugin.gallery.a;

import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/utils/MediaUtil;", "", "()V", "TAG", "", "getVideoInfo", "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "filePath", "plugin-gallery_release"})
public final class c
{
  private static final String TAG = "MicroMsg.MediaUtil";
  public static final c xsz;
  
  static
  {
    AppMethodBeat.i(165053);
    xsz = new c();
    TAG = "MicroMsg.MediaUtil";
    AppMethodBeat.o(165053);
  }
  
  public static a awl(String paramString)
  {
    AppMethodBeat.i(165052);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      paramString = new a();
      AppMethodBeat.o(165052);
      return paramString;
    }
    Object localObject2 = e.aNx(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new a();
    }
    if ((((a)localObject1).height <= 0) || (((a)localObject1).width <= 0)) {}
    try
    {
      localObject2 = new MediaMetadataRetriever();
      ((MediaMetadataRetriever)localObject2).setDataSource(paramString);
      ((a)localObject1).width = Util.getInt(((MediaMetadataRetriever)localObject2).extractMetadata(18), 0);
      ((a)localObject1).height = Util.getInt(((MediaMetadataRetriever)localObject2).extractMetadata(19), 0);
      ((a)localObject1).videoBitrate = Util.getInt(((MediaMetadataRetriever)localObject2).extractMetadata(20), 0);
      ((a)localObject1).videoDuration = Util.getInt(((MediaMetadataRetriever)localObject2).extractMetadata(9), 0);
      ((MediaMetadataRetriever)localObject2).release();
      label136:
      int i = SightVideoJNI.getMp4RotateVFS(paramString);
      Log.i(TAG, "width %d, height %d, rotate %d", new Object[] { Integer.valueOf(((a)localObject1).width), Integer.valueOf(((a)localObject1).height), Integer.valueOf(i) });
      if ((i == 270) || (i == 90))
      {
        i = ((a)localObject1).height;
        ((a)localObject1).height = ((a)localObject1).width;
        ((a)localObject1).width = i;
      }
      AppMethodBeat.o(165052);
      return localObject1;
    }
    catch (Exception localException)
    {
      break label136;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.a.c
 * JD-Core Version:    0.7.0.1
 */