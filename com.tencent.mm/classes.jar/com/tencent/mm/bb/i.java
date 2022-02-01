package com.tencent.mm.bb;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.plugin.comm.a;
import com.tencent.mm.plugin.findersdk.a.an;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.protocal.protobuf.ex;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class i
  extends g
{
  public static f a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, h paramh)
  {
    AppMethodBeat.i(248841);
    if ((paramh != null) && (paramh.lVY != null) && (!Util.isNullOrNil(paramh.lVY.singerName))) {
      paramString3 = paramh.lVY.singerName;
    }
    for (;;)
    {
      paramString1 = a(paramInt, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11);
      a(paramString1, paramh);
      AppMethodBeat.o(248841);
      return paramString1;
    }
  }
  
  public static f a(k.b paramb, String paramString1, String paramString2, String paramString3, String paramString4, h paramh)
  {
    AppMethodBeat.i(248839);
    if (paramb == null)
    {
      AppMethodBeat.o(248839);
      return null;
    }
    f localf = new f();
    localf.lVr = 0;
    localf.lVt = paramString1;
    localf.lVu = 0.0F;
    localf.lVx = "";
    localf.lVy = paramString2;
    localf.lVD = paramString4;
    localf.lVs = 1;
    paramString1 = (com.tencent.mm.pluginsdk.ui.tools.b)paramb.ar(com.tencent.mm.pluginsdk.ui.tools.b.class);
    if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1.songLyric)))
    {
      localf.lVC = paramString1.songLyric;
      localf.lVK = paramString1.songAlbumUrl;
      if ((paramString1 == null) || (Util.isNullOrNil(paramString1.Ruy))) {
        break label233;
      }
      localf.lVw = paramString1.Ruy;
      label134:
      localf.lVv = paramb.title;
      localf.lVB = paramb.url;
      if (Util.isNullOrNil(paramb.lmt)) {
        break label245;
      }
    }
    label233:
    label245:
    for (paramString1 = paramb.lmt;; paramString1 = paramb.llW)
    {
      localf.lVA = paramString1;
      localf.lVz = paramb.lms;
      localf.lVG = paramb.appId;
      localf.lVE = paramString3;
      paramb = a.ubo;
      localf.lVV = a.cPl();
      a(localf, paramh);
      AppMethodBeat.o(248839);
      return localf;
      localf.lVC = null;
      break;
      localf.lVw = paramb.description;
      break label134;
    }
  }
  
  public static f a(String paramString, TimeLineObject paramTimeLineObject, int paramInt, h paramh)
  {
    String str = null;
    AppMethodBeat.i(248835);
    if ((paramTimeLineObject == null) || (paramTimeLineObject.ContentObj == null) || (paramTimeLineObject.ContentObj.Sqr == null) || (paramTimeLineObject.ContentObj.Sqr.size() <= 0))
    {
      AppMethodBeat.o(248835);
      return null;
    }
    cvt localcvt = (cvt)paramTimeLineObject.ContentObj.Sqr.get(0);
    if (localcvt == null)
    {
      AppMethodBeat.o(248835);
      return null;
    }
    f localf = new f();
    localf.lVr = paramInt;
    localf.lVt = paramTimeLineObject.Id;
    localf.lVu = 0.0F;
    localf.lVx = "";
    if (!TextUtils.isEmpty(localcvt.songAlbumUrl)) {
      localf.lVK = localcvt.songAlbumUrl;
    }
    localf.lVy = localcvt.TDF;
    localf.lVD = null;
    localf.lVs = 1;
    localf.lVC = localcvt.songLyric;
    localf.lVv = localcvt.fwr;
    if ((paramTimeLineObject.ContentObj.lVY != null) && (!Util.isNullOrNil(paramTimeLineObject.ContentObj.lVY.singerName))) {}
    for (localf.lVw = paramTimeLineObject.ContentObj.lVY.singerName;; localf.lVw = localcvt.CMB)
    {
      if (paramTimeLineObject.ContentObj != null) {
        str = paramTimeLineObject.ContentObj.Url;
      }
      localf.lVB = str;
      localf.lVA = localcvt.TDI;
      localf.lVz = localcvt.Url;
      localf.lVH = localcvt.TDG;
      localf.lVJ = localcvt.Id;
      localf.lVE = paramString;
      localf.lVG = paramTimeLineObject.AppInfo.Id;
      localf.lVN = paramTimeLineObject.UserName;
      localf.lVU = paramTimeLineObject.Id;
      localf.lVX = true;
      paramString = a.ubo;
      localf.lVV = a.cPl();
      a(localf, paramh);
      AppMethodBeat.o(248835);
      return localf;
    }
  }
  
  private static void a(f paramf, h paramh)
  {
    boolean bool = true;
    AppMethodBeat.i(248844);
    Object localObject = a.ubo;
    if (a.asG(paramf.lVG)) {
      paramf.lVX = true;
    }
    for (;;)
    {
      if ((paramh != null) && (paramh.lVY != null))
      {
        localObject = paramh.lVY;
        if ((Util.isNullOrNil(((dbr)localObject).HLH)) && (!Util.isNullOrNil(paramf.lVv))) {
          ((dbr)localObject).HLH = paramf.lVv;
        }
        if ((Util.isNullOrNil(((dbr)localObject).songLyric)) && (!Util.isNullOrNil(paramf.lVC))) {
          ((dbr)localObject).songLyric = paramf.lVC;
        }
      }
      ((com.tencent.mm.bb.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.bb.a.b.class)).a(paramf, paramh);
      AppMethodBeat.o(248844);
      return;
      if (paramh != null)
      {
        if (!an.b(paramh.lVY)) {}
        for (;;)
        {
          paramf.lVX = bool;
          break;
          bool = false;
        }
      }
      paramf.lVX = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bb.i
 * JD-Core Version:    0.7.0.1
 */