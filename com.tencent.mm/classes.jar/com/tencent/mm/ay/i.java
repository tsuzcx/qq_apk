package com.tencent.mm.ay;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.plugin.comm.a;
import com.tencent.mm.plugin.i.a.al;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.fa;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class i
  extends g
{
  public static f a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, h paramh)
  {
    AppMethodBeat.i(192719);
    paramString1 = a(paramInt, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11);
    a(paramString1, paramh);
    AppMethodBeat.o(192719);
    return paramString1;
  }
  
  public static f a(k.b paramb, String paramString1, String paramString2, String paramString3, String paramString4, h paramh)
  {
    AppMethodBeat.i(192718);
    if (paramb == null)
    {
      AppMethodBeat.o(192718);
      return null;
    }
    f localf = new f();
    localf.jeT = 0;
    localf.jeV = paramString1;
    localf.jeW = 0.0F;
    localf.jeZ = "";
    localf.jfa = paramString2;
    localf.jff = paramString4;
    localf.jeU = 1;
    paramString1 = (com.tencent.mm.pluginsdk.ui.tools.b)paramb.as(com.tencent.mm.pluginsdk.ui.tools.b.class);
    if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1.songLyric)))
    {
      localf.jfe = paramString1.songLyric;
      localf.jfm = paramString1.songAlbumUrl;
      localf.jeX = paramb.title;
      localf.jeY = paramb.description;
      localf.jfd = paramb.url;
      if (Util.isNullOrNil(paramb.ixe)) {
        break label207;
      }
    }
    label207:
    for (paramString1 = paramb.ixe;; paramString1 = paramb.iwH)
    {
      localf.jfc = paramString1;
      localf.jfb = paramb.ixd;
      localf.jfi = paramb.appId;
      localf.jfg = paramString3;
      a(localf, paramh);
      AppMethodBeat.o(192718);
      return localf;
      localf.jfe = null;
      break;
    }
  }
  
  public static f a(String paramString, TimeLineObject paramTimeLineObject, int paramInt, h paramh)
  {
    String str = null;
    AppMethodBeat.i(192717);
    if ((paramTimeLineObject == null) || (paramTimeLineObject.ContentObj == null) || (paramTimeLineObject.ContentObj.LoV == null) || (paramTimeLineObject.ContentObj.LoV.size() <= 0))
    {
      AppMethodBeat.o(192717);
      return null;
    }
    cnb localcnb = (cnb)paramTimeLineObject.ContentObj.LoV.get(0);
    if (localcnb == null)
    {
      AppMethodBeat.o(192717);
      return null;
    }
    f localf = new f();
    localf.jeT = paramInt;
    localf.jeV = paramTimeLineObject.Id;
    localf.jeW = 0.0F;
    localf.jeZ = "";
    if (!TextUtils.isEmpty(localcnb.songAlbumUrl)) {
      localf.jfm = localcnb.songAlbumUrl;
    }
    localf.jfa = localcnb.Msz;
    localf.jff = null;
    localf.jeU = 1;
    localf.jfe = localcnb.songLyric;
    localf.jeX = localcnb.Title;
    localf.jeY = localcnb.Desc;
    if (paramTimeLineObject.ContentObj != null) {
      str = paramTimeLineObject.ContentObj.Url;
    }
    localf.jfd = str;
    localf.jfc = localcnb.MsC;
    localf.jfb = localcnb.Url;
    localf.jfj = localcnb.MsA;
    localf.jfl = localcnb.Id;
    localf.jfg = paramString;
    localf.jfi = paramTimeLineObject.AppInfo.Id;
    localf.jfp = paramTimeLineObject.UserName;
    localf.jfw = paramTimeLineObject.Id;
    localf.jfx = true;
    a(localf, paramh);
    AppMethodBeat.o(192717);
    return localf;
  }
  
  private static void a(f paramf, h paramh)
  {
    boolean bool = true;
    AppMethodBeat.i(192720);
    a locala = a.qCo;
    if (a.akQ(paramf.jfi)) {
      paramf.jfx = true;
    }
    for (;;)
    {
      ((com.tencent.mm.ay.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.ay.a.b.class)).a(paramf, paramh);
      AppMethodBeat.o(192720);
      return;
      if (paramh != null)
      {
        if (!al.b(paramh.jfy)) {}
        for (;;)
        {
          paramf.jfx = bool;
          break;
          bool = false;
        }
      }
      paramf.jfx = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ay.i
 * JD-Core Version:    0.7.0.1
 */