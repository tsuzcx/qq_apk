package com.tencent.mm.plugin.gallery.model;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.b.i;
import com.tencent.mm.plugin.gallery.b.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/model/GalleryMediaItemProvider;", "Lcom/tencent/mm/plugin/gallery/model/IMediaItemProvider;", "()V", "getNickName", "", "bucketID", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  implements k
{
  public final String ID(String paramString)
  {
    AppMethodBeat.i(289608);
    s.u(paramString, "bucketID");
    if (!Util.isNullOrNil(paramString))
    {
      int i = Util.safeParseInt(paramString);
      if (h.HRi == i)
      {
        paramString = MMApplicationContext.getContext().getString(b.i.gallery_album_weixin);
        AppMethodBeat.o(289608);
        return paramString;
      }
      if (h.HRj == i)
      {
        paramString = MMApplicationContext.getContext().getString(b.i.gallery_album_camera);
        AppMethodBeat.o(289608);
        return paramString;
      }
      if (h.HRk == i)
      {
        paramString = MMApplicationContext.getContext().getString(b.i.gallery_album_download);
        AppMethodBeat.o(289608);
        return paramString;
      }
      if (h.HRl.contains(Integer.valueOf(i)))
      {
        paramString = MMApplicationContext.getContext().getString(b.i.gallery_album_screenshots);
        AppMethodBeat.o(289608);
        return paramString;
      }
      if (h.HRm.contains(Integer.valueOf(i)))
      {
        paramString = MMApplicationContext.getContext().getString(b.i.gallery_album_screenshots_video);
        AppMethodBeat.o(289608);
        return paramString;
      }
      paramString = (GalleryItem.a)e.fAk().get(i);
      if (paramString != null)
      {
        String str = paramString.key;
        s.s(str, "albumName.key");
        str = str.toLowerCase();
        s.s(str, "(this as java.lang.String).toLowerCase()");
        if (s.p(str, "WeChatWork"))
        {
          paramString = MMApplicationContext.getContext().getString(b.i.gallery_album_wechat_work);
          AppMethodBeat.o(289608);
          return paramString;
        }
        paramString = paramString.HHF;
        AppMethodBeat.o(289608);
        return paramString;
      }
    }
    AppMethodBeat.o(289608);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.j
 * JD-Core Version:    0.7.0.1
 */