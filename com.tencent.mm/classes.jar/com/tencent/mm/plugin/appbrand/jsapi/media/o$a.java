package com.tencent.mm.plugin.appbrand.jsapi.media;

import a.f.b.j;
import a.l;
import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/VideoMetaData$Companion;", "", "()V", "TAG", "", "obtain", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/VideoMetaData;", "path", "plugin-appbrand-integration_release"})
public final class o$a
{
  public static o CB(String paramString)
  {
    AppMethodBeat.i(143843);
    j.q(paramString, "path");
    if (!e.cN(paramString))
    {
      AppMethodBeat.o(143843);
      return null;
    }
    for (;;)
    {
      MediaMetadataRetriever localMediaMetadataRetriever;
      try
      {
        localMediaMetadataRetriever = new MediaMetadataRetriever();
        localMediaMetadataRetriever.setDataSource(paramString);
        i = bo.getInt(localMediaMetadataRetriever.extractMetadata(24), 0);
        if ((i == 90) || (i == 270))
        {
          i = bo.getInt(localMediaMetadataRetriever.extractMetadata(19), 0);
          j = bo.getInt(localMediaMetadataRetriever.extractMetadata(18), 0);
          long l = bo.getLong(localMediaMetadataRetriever.extractMetadata(9), 0L);
          localMediaMetadataRetriever.release();
          paramString = new o(l, e.avI(paramString), i, j);
          AppMethodBeat.o(143843);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.VideoMetaData", "MetaDataRetriever failed, e = ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(143843);
        return null;
      }
      int i = bo.getInt(localMediaMetadataRetriever.extractMetadata(18), 0);
      int j = bo.getInt(localMediaMetadataRetriever.extractMetadata(19), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.o.a
 * JD-Core Version:    0.7.0.1
 */