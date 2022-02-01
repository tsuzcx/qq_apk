package com.tencent.mm.aw;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.k.b;
import com.tencent.mm.plugin.comm.a;
import com.tencent.mm.plugin.findersdk.a.cr;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.protocal.protobuf.fr;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class i
  extends g
{
  public static f a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, h paramh)
  {
    AppMethodBeat.i(231025);
    if ((paramh != null) && (paramh.oPb != null) && (!Util.isNullOrNil(paramh.oPb.singerName))) {
      paramString3 = paramh.oPb.singerName;
    }
    for (;;)
    {
      paramString1 = a(paramInt, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11);
      a(paramString1, paramh);
      AppMethodBeat.o(231025);
      return paramString1;
    }
  }
  
  public static f a(k.b paramb, String paramString1, String paramString2, String paramString3, String paramString4, h paramh)
  {
    AppMethodBeat.i(231024);
    if (paramb == null)
    {
      AppMethodBeat.o(231024);
      return null;
    }
    f localf = new f();
    localf.oOt = 0;
    localf.oOv = paramString1;
    localf.oOw = 0.0F;
    localf.oOz = "";
    localf.oOA = paramString2;
    localf.oOF = paramString4;
    localf.oOu = 1;
    paramString1 = (com.tencent.mm.pluginsdk.ui.tools.b)paramb.aK(com.tencent.mm.pluginsdk.ui.tools.b.class);
    if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1.songLyric)))
    {
      localf.oOE = paramString1.songLyric;
      localf.oOM = paramString1.songAlbumUrl;
      if ((paramString1 == null) || (Util.isNullOrNil(paramString1.YqR))) {
        break label233;
      }
      localf.oOy = paramString1.YqR;
      label134:
      localf.oOx = paramb.title;
      localf.oOD = paramb.url;
      if (Util.isNullOrNil(paramb.nRy)) {
        break label245;
      }
    }
    label233:
    label245:
    for (paramString1 = paramb.nRy;; paramString1 = paramb.nRc)
    {
      localf.oOC = paramString1;
      localf.oOB = paramb.nRx;
      localf.oOI = paramb.appId;
      localf.oOG = paramString3;
      paramb = a.xeG;
      localf.oOX = a.dsR();
      a(localf, paramh);
      AppMethodBeat.o(231024);
      return localf;
      localf.oOE = null;
      break;
      localf.oOy = paramb.description;
      break label134;
    }
  }
  
  public static f a(String paramString, TimeLineObject paramTimeLineObject, int paramInt, h paramh)
  {
    String str = null;
    AppMethodBeat.i(231020);
    if ((paramTimeLineObject == null) || (paramTimeLineObject.ContentObj == null) || (paramTimeLineObject.ContentObj.Zpr == null) || (paramTimeLineObject.ContentObj.Zpr.size() <= 0))
    {
      AppMethodBeat.o(231020);
      return null;
    }
    dmz localdmz = (dmz)paramTimeLineObject.ContentObj.Zpr.get(0);
    if (localdmz == null)
    {
      AppMethodBeat.o(231020);
      return null;
    }
    f localf = new f();
    localf.oOt = paramInt;
    localf.oOv = paramTimeLineObject.Id;
    localf.oOw = 0.0F;
    localf.oOz = "";
    if (!TextUtils.isEmpty(localdmz.songAlbumUrl)) {
      localf.oOM = localdmz.songAlbumUrl;
    }
    localf.oOA = localdmz.aaTl;
    localf.oOF = null;
    localf.oOu = 1;
    localf.oOE = localdmz.songLyric;
    localf.oOx = localdmz.hAP;
    if ((paramTimeLineObject.ContentObj.oPb != null) && (!Util.isNullOrNil(paramTimeLineObject.ContentObj.oPb.singerName))) {}
    for (localf.oOy = paramTimeLineObject.ContentObj.oPb.singerName;; localf.oOy = localdmz.IGG)
    {
      if (paramTimeLineObject.ContentObj.oPb != null) {
        localf.oOZ = paramTimeLineObject.ContentObj.oPb.oOZ;
      }
      if (paramTimeLineObject.ContentObj != null) {
        str = paramTimeLineObject.ContentObj.Url;
      }
      localf.oOD = str;
      localf.oOC = localdmz.aaTo;
      localf.oOB = localdmz.Url;
      localf.oOJ = localdmz.aaTm;
      localf.oOL = localdmz.Id;
      localf.oOG = paramString;
      localf.oOI = paramTimeLineObject.AppInfo.Id;
      localf.oOP = paramTimeLineObject.UserName;
      localf.oOW = paramTimeLineObject.Id;
      localf.oPa = true;
      paramString = a.xeG;
      localf.oOX = a.dsR();
      a(localf, paramh);
      AppMethodBeat.o(231020);
      return localf;
    }
  }
  
  private static void a(f paramf, h paramh)
  {
    boolean bool = true;
    AppMethodBeat.i(231027);
    Object localObject = a.xeG;
    if (a.aml(paramf.oOI)) {
      paramf.oPa = true;
    }
    for (;;)
    {
      if ((paramh != null) && (paramh.oPb != null))
      {
        localObject = paramh.oPb;
        if ((Util.isNullOrNil(((dtj)localObject).songName)) && (!Util.isNullOrNil(paramf.oOx))) {
          ((dtj)localObject).songName = paramf.oOx;
        }
        if ((Util.isNullOrNil(((dtj)localObject).songLyric)) && (!Util.isNullOrNil(paramf.oOE))) {
          ((dtj)localObject).songLyric = paramf.oOE;
        }
        if (!Util.isNullOrNil(((dtj)localObject).oOZ)) {
          paramf.oOZ = ((dtj)localObject).oOZ;
        }
      }
      ((com.tencent.mm.aw.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.aw.a.b.class)).a(paramf, paramh);
      AppMethodBeat.o(231027);
      return;
      if (paramh != null)
      {
        if (!cr.b(paramh.oPb)) {}
        for (;;)
        {
          paramf.oPa = bool;
          break;
          bool = false;
        }
      }
      paramf.oPa = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.aw.i
 * JD-Core Version:    0.7.0.1
 */