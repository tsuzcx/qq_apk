package com.tencent.mm.plugin.gallery.a;

import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/gallery/utils/MediaUtil;", "", "()V", "TAG", "", "getVideoInfo", "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "filePath", "plugin-gallery_release"})
public final class c
{
  private static final String TAG = "MicroMsg.MediaUtil";
  public static final c sTV;
  
  static
  {
    AppMethodBeat.i(165053);
    sTV = new c();
    TAG = "MicroMsg.MediaUtil";
    AppMethodBeat.o(165053);
  }
  
  public static a aeB(String paramString)
  {
    AppMethodBeat.i(165052);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      paramString = new a();
      AppMethodBeat.o(165052);
      return paramString;
    }
    e.asx(paramString);
    a locala = new a();
    if ((locala.height <= 0) || (locala.width <= 0)) {}
    try
    {
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      localMediaMetadataRetriever.setDataSource(paramString);
      locala.width = bs.getInt(localMediaMetadataRetriever.extractMetadata(18), 0);
      locala.height = bs.getInt(localMediaMetadataRetriever.extractMetadata(19), 0);
      locala.videoBitrate = bs.getInt(localMediaMetadataRetriever.extractMetadata(20), 0);
      locala.videoDuration = bs.getInt(localMediaMetadataRetriever.extractMetadata(9), 0);
      localMediaMetadataRetriever.release();
      label130:
      int i = SightVideoJNI.getMp4RotateVFS(paramString);
      ac.i(TAG, "width %d, height %d, rotate %d", new Object[] { Integer.valueOf(locala.width), Integer.valueOf(locala.height), Integer.valueOf(i) });
      if ((i == 270) || (i == 90))
      {
        i = locala.height;
        locala.height = locala.width;
        locala.width = i;
      }
      AppMethodBeat.o(165052);
      return locala;
    }
    catch (Exception localException)
    {
      break label130;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.a.c
 * JD-Core Version:    0.7.0.1
 */