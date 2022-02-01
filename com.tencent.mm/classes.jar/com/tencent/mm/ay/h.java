package com.tencent.mm.ay;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.pluginsdk.ui.tools.b;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.ej;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.bs;
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
    localf.hNQ = 0;
    localf.hNS = paramString1;
    localf.hNT = 0.0F;
    localf.hNW = "";
    localf.hNX = paramString2;
    localf.hOc = paramString4;
    localf.hNR = 1;
    paramString1 = (b)paramb.ao(b.class);
    if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1.songLyric)))
    {
      localf.hOb = paramString1.songLyric;
      localf.hOj = paramString1.songAlbumUrl;
      localf.hNU = paramb.title;
      localf.hNV = paramb.description;
      localf.hOa = paramb.url;
      if (bs.isNullOrNil(paramb.hic)) {
        break label200;
      }
    }
    label200:
    for (paramString1 = paramb.hic;; paramString1 = paramb.hhE)
    {
      localf.hNZ = paramString1;
      localf.hNY = paramb.hib;
      localf.hOf = paramb.appId;
      localf.hOd = paramString3;
      AppMethodBeat.o(103254);
      return localf;
      localf.hOb = null;
      break;
    }
  }
  
  public static f a(String paramString, TimeLineObject paramTimeLineObject, int paramInt)
  {
    String str = null;
    AppMethodBeat.i(103253);
    if ((paramTimeLineObject == null) || (paramTimeLineObject.FQo == null) || (paramTimeLineObject.FQo.Etz == null) || (paramTimeLineObject.FQo.Etz.size() <= 0))
    {
      AppMethodBeat.o(103253);
      return null;
    }
    btz localbtz = (btz)paramTimeLineObject.FQo.Etz.get(0);
    if (localbtz == null)
    {
      AppMethodBeat.o(103253);
      return null;
    }
    f localf = new f();
    localf.hNQ = paramInt;
    localf.hNS = paramTimeLineObject.Id;
    localf.hNT = 0.0F;
    localf.hNW = "";
    if (!TextUtils.isEmpty(localbtz.songAlbumUrl)) {
      localf.hOj = localbtz.songAlbumUrl;
    }
    localf.hNX = localbtz.Fjh;
    localf.hOc = null;
    localf.hNR = 1;
    localf.hOb = localbtz.songLyric;
    localf.hNU = localbtz.Title;
    localf.hNV = localbtz.Desc;
    if (paramTimeLineObject.FQo != null) {
      str = paramTimeLineObject.FQo.Url;
    }
    localf.hOa = str;
    localf.hNZ = localbtz.Fjl;
    localf.hNY = localbtz.Url;
    localf.hOg = localbtz.Fji;
    localf.hOi = localbtz.Id;
    localf.hOd = paramString;
    localf.hOf = paramTimeLineObject.FQn.Id;
    localf.hOm = paramTimeLineObject.ncR;
    localf.hOt = paramTimeLineObject.Id;
    AppMethodBeat.o(103253);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ay.h
 * JD-Core Version:    0.7.0.1
 */