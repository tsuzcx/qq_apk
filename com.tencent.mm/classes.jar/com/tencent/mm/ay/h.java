package com.tencent.mm.ay;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.pluginsdk.ui.tools.b;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public final class h
  extends g
{
  public static f a(k.b paramb, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(103254);
    if (paramb == null)
    {
      AppMethodBeat.o(103254);
      return null;
    }
    f localf = new f();
    localf.ijX = 0;
    localf.ijZ = paramString1;
    localf.ika = 0.0F;
    localf.ikd = "";
    localf.ike = paramString2;
    localf.ikj = paramString4;
    localf.ijY = 1;
    paramString1 = (b)paramb.ao(b.class);
    if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1.songLyric)))
    {
      localf.iki = paramString1.songLyric;
      localf.ikq = paramString1.songAlbumUrl;
      localf.ikb = paramb.title;
      localf.ikc = paramb.description;
      localf.ikh = paramb.url;
      if (bu.isNullOrNil(paramb.hCZ)) {
        break label200;
      }
    }
    label200:
    for (paramString1 = paramb.hCZ;; paramString1 = paramb.hCB)
    {
      localf.ikg = paramString1;
      localf.ikf = paramb.hCY;
      localf.ikm = paramb.appId;
      localf.ikk = paramString3;
      AppMethodBeat.o(103254);
      return localf;
      localf.iki = null;
      break;
    }
  }
  
  public static f a(String paramString, TimeLineObject paramTimeLineObject, int paramInt)
  {
    String str = null;
    AppMethodBeat.i(103253);
    if ((paramTimeLineObject == null) || (paramTimeLineObject.HUG == null) || (paramTimeLineObject.HUG.Gtx == null) || (paramTimeLineObject.HUG.Gtx.size() <= 0))
    {
      AppMethodBeat.o(103253);
      return null;
    }
    bzh localbzh = (bzh)paramTimeLineObject.HUG.Gtx.get(0);
    if (localbzh == null)
    {
      AppMethodBeat.o(103253);
      return null;
    }
    f localf = new f();
    localf.ijX = paramInt;
    localf.ijZ = paramTimeLineObject.Id;
    localf.ika = 0.0F;
    localf.ikd = "";
    if (!TextUtils.isEmpty(localbzh.songAlbumUrl)) {
      localf.ikq = localbzh.songAlbumUrl;
    }
    localf.ike = localbzh.Hmj;
    localf.ikj = null;
    localf.ijY = 1;
    localf.iki = localbzh.songLyric;
    localf.ikb = localbzh.Title;
    localf.ikc = localbzh.Desc;
    if (paramTimeLineObject.HUG != null) {
      str = paramTimeLineObject.HUG.Url;
    }
    localf.ikh = str;
    localf.ikg = localbzh.Hmn;
    localf.ikf = localbzh.Url;
    localf.ikn = localbzh.Hmk;
    localf.ikp = localbzh.Id;
    localf.ikk = paramString;
    localf.ikm = paramTimeLineObject.HUF.Id;
    localf.ikt = paramTimeLineObject.nIJ;
    localf.ikA = paramTimeLineObject.Id;
    AppMethodBeat.o(103253);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ay.h
 * JD-Core Version:    0.7.0.1
 */