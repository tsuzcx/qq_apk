package com.tencent.mm.az;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.pluginsdk.ui.tools.b;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.bt;
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
    localf.hnn = 0;
    localf.hnp = paramString1;
    localf.hnq = 0.0F;
    localf.hnt = "";
    localf.hnu = paramString2;
    localf.hnz = paramString4;
    localf.hno = 1;
    paramString1 = (b)paramb.ao(b.class);
    if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1.songLyric)))
    {
      localf.hny = paramString1.songLyric;
      localf.hnG = paramString1.songAlbumUrl;
      localf.hnr = paramb.title;
      localf.hns = paramb.description;
      localf.hnx = paramb.url;
      if (bt.isNullOrNil(paramb.gHB)) {
        break label200;
      }
    }
    label200:
    for (paramString1 = paramb.gHB;; paramString1 = paramb.gHd)
    {
      localf.hnw = paramString1;
      localf.hnv = paramb.gHA;
      localf.hnC = paramb.appId;
      localf.hnA = paramString3;
      AppMethodBeat.o(103254);
      return localf;
      localf.hny = null;
      break;
    }
  }
  
  public static f a(String paramString, TimeLineObject paramTimeLineObject, int paramInt)
  {
    String str = null;
    AppMethodBeat.i(103253);
    if ((paramTimeLineObject == null) || (paramTimeLineObject.Etm == null) || (paramTimeLineObject.Etm.DaC == null) || (paramTimeLineObject.Etm.DaC.size() <= 0))
    {
      AppMethodBeat.o(103253);
      return null;
    }
    bpi localbpi = (bpi)paramTimeLineObject.Etm.DaC.get(0);
    if (localbpi == null)
    {
      AppMethodBeat.o(103253);
      return null;
    }
    f localf = new f();
    localf.hnn = paramInt;
    localf.hnp = paramTimeLineObject.Id;
    localf.hnq = 0.0F;
    localf.hnt = "";
    if (!TextUtils.isEmpty(localbpi.songAlbumUrl)) {
      localf.hnG = localbpi.songAlbumUrl;
    }
    localf.hnu = localbpi.DMQ;
    localf.hnz = null;
    localf.hno = 1;
    localf.hny = localbpi.songLyric;
    localf.hnr = localbpi.Title;
    localf.hns = localbpi.Desc;
    if (paramTimeLineObject.Etm != null) {
      str = paramTimeLineObject.Etm.Url;
    }
    localf.hnx = str;
    localf.hnw = localbpi.DMU;
    localf.hnv = localbpi.Url;
    localf.hnD = localbpi.DMR;
    localf.hnF = localbpi.Id;
    localf.hnA = paramString;
    localf.hnC = paramTimeLineObject.Etl.Id;
    localf.hnJ = paramTimeLineObject.mAQ;
    localf.hnQ = paramTimeLineObject.Id;
    AppMethodBeat.o(103253);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.az.h
 * JD-Core Version:    0.7.0.1
 */