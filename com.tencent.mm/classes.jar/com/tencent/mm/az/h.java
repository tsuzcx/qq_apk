package com.tencent.mm.az;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.pluginsdk.ui.tools.b;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.en;
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
    localf.ihe = 0;
    localf.ihg = paramString1;
    localf.ihh = 0.0F;
    localf.ihk = "";
    localf.ihl = paramString2;
    localf.ihq = paramString4;
    localf.ihf = 1;
    paramString1 = (b)paramb.ao(b.class);
    if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1.songLyric)))
    {
      localf.ihp = paramString1.songLyric;
      localf.ihx = paramString1.songAlbumUrl;
      localf.ihi = paramb.title;
      localf.ihj = paramb.description;
      localf.iho = paramb.url;
      if (bt.isNullOrNil(paramb.hAl)) {
        break label200;
      }
    }
    label200:
    for (paramString1 = paramb.hAl;; paramString1 = paramb.hzN)
    {
      localf.ihn = paramString1;
      localf.ihm = paramb.hAk;
      localf.iht = paramb.appId;
      localf.ihr = paramString3;
      AppMethodBeat.o(103254);
      return localf;
      localf.ihp = null;
      break;
    }
  }
  
  public static f a(String paramString, TimeLineObject paramTimeLineObject, int paramInt)
  {
    String str = null;
    AppMethodBeat.i(103253);
    if ((paramTimeLineObject == null) || (paramTimeLineObject.HAT == null) || (paramTimeLineObject.HAT.GaQ == null) || (paramTimeLineObject.HAT.GaQ.size() <= 0))
    {
      AppMethodBeat.o(103253);
      return null;
    }
    byn localbyn = (byn)paramTimeLineObject.HAT.GaQ.get(0);
    if (localbyn == null)
    {
      AppMethodBeat.o(103253);
      return null;
    }
    f localf = new f();
    localf.ihe = paramInt;
    localf.ihg = paramTimeLineObject.Id;
    localf.ihh = 0.0F;
    localf.ihk = "";
    if (!TextUtils.isEmpty(localbyn.songAlbumUrl)) {
      localf.ihx = localbyn.songAlbumUrl;
    }
    localf.ihl = localbyn.GSI;
    localf.ihq = null;
    localf.ihf = 1;
    localf.ihp = localbyn.songLyric;
    localf.ihi = localbyn.Title;
    localf.ihj = localbyn.Desc;
    if (paramTimeLineObject.HAT != null) {
      str = paramTimeLineObject.HAT.Url;
    }
    localf.iho = str;
    localf.ihn = localbyn.GSM;
    localf.ihm = localbyn.Url;
    localf.ihu = localbyn.GSJ;
    localf.ihw = localbyn.Id;
    localf.ihr = paramString;
    localf.iht = paramTimeLineObject.HAS.Id;
    localf.ihA = paramTimeLineObject.nDo;
    localf.ihH = paramTimeLineObject.Id;
    AppMethodBeat.o(103253);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.az.h
 * JD-Core Version:    0.7.0.1
 */