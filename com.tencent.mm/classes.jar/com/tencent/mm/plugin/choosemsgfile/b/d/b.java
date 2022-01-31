package com.tencent.mm.plugin.choosemsgfile.b.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.bq.d;
import com.tencent.mm.choosemsgfile.compat.a.a;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.choosemsgfile.b.b.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.widget.b.e.a;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class b
{
  private static ae<Integer, com.tencent.mm.at.a.a.c> kFS;
  
  static
  {
    AppMethodBeat.i(54410);
    kFS = new ae(3);
    AppMethodBeat.o(54410);
  }
  
  public static List<String> IX(String paramString)
  {
    AppMethodBeat.i(54393);
    localArrayList = new ArrayList();
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(54393);
      return localArrayList;
    }
    try
    {
      paramString = new com.tencent.mm.aa.f(paramString);
      int i = 0;
      while (i < paramString.length())
      {
        String str = paramString.optString(i, "");
        if (!bo.isNullOrNil(str)) {
          localArrayList.add(str);
        }
        i += 1;
      }
      return localArrayList;
    }
    catch (com.tencent.mm.aa.g paramString)
    {
      ab.printErrStackTrace("MicroMsg.MsgFileUtils", paramString, "", new Object[0]);
      AppMethodBeat.o(54393);
    }
  }
  
  public static String IY(String paramString)
  {
    AppMethodBeat.i(54402);
    if (bo.isNullOrNil(paramString))
    {
      ab.i("MicroMsg.MsgFileUtils", "type is null, use default type");
      AppMethodBeat.o(54402);
      return "all";
    }
    if (("all".equals(paramString)) || ("image".equals(paramString)) || ("video".equals(paramString)) || ("file".equals(paramString)))
    {
      ab.i("MicroMsg.MsgFileUtils", "type is invalid, use default type");
      AppMethodBeat.o(54402);
      return paramString;
    }
    AppMethodBeat.o(54402);
    return "all";
  }
  
  public static String IZ(String paramString)
  {
    AppMethodBeat.i(54405);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(54405);
        return "#888888";
        if (paramString.equals("txt"))
        {
          i = 0;
          continue;
          if (paramString.equals("rtf"))
          {
            i = 1;
            continue;
            if (paramString.equals("doc"))
            {
              i = 2;
              continue;
              if (paramString.equals("docx"))
              {
                i = 3;
                continue;
                if (paramString.equals("pdf"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("xls"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("xlsx"))
                    {
                      i = 6;
                      continue;
                      if (paramString.equals("ppt"))
                      {
                        i = 7;
                        continue;
                        if (paramString.equals("pptx"))
                        {
                          i = 8;
                          continue;
                          if (paramString.equals("url"))
                          {
                            i = 9;
                            continue;
                            if (paramString.equals("mp3pro"))
                            {
                              i = 10;
                              continue;
                              if (paramString.equals("vqf"))
                              {
                                i = 11;
                                continue;
                                if (paramString.equals("cd"))
                                {
                                  i = 12;
                                  continue;
                                  if (paramString.equals("md"))
                                  {
                                    i = 13;
                                    continue;
                                    if (paramString.equals("mod"))
                                    {
                                      i = 14;
                                      continue;
                                      if (paramString.equals("vorbis"))
                                      {
                                        i = 15;
                                        continue;
                                        if (paramString.equals("au"))
                                        {
                                          i = 16;
                                          continue;
                                          if (paramString.equals("amr"))
                                          {
                                            i = 17;
                                            continue;
                                            if (paramString.equals("silk"))
                                            {
                                              i = 18;
                                              continue;
                                              if (paramString.equals("wma"))
                                              {
                                                i = 19;
                                                continue;
                                                if (paramString.equals("mmf"))
                                                {
                                                  i = 20;
                                                  continue;
                                                  if (paramString.equals("mid"))
                                                  {
                                                    i = 21;
                                                    continue;
                                                    if (paramString.equals("midi"))
                                                    {
                                                      i = 22;
                                                      continue;
                                                      if (paramString.equals("mp3"))
                                                      {
                                                        i = 23;
                                                        continue;
                                                        if (paramString.equals("aac"))
                                                        {
                                                          i = 24;
                                                          continue;
                                                          if (paramString.equals("ape"))
                                                          {
                                                            i = 25;
                                                            continue;
                                                            if (paramString.equals("aiff"))
                                                            {
                                                              i = 26;
                                                              continue;
                                                              if (paramString.equals("aif"))
                                                              {
                                                                i = 27;
                                                                continue;
                                                                if (paramString.equals("avi"))
                                                                {
                                                                  i = 28;
                                                                  continue;
                                                                  if (paramString.equals("m4v"))
                                                                  {
                                                                    i = 29;
                                                                    continue;
                                                                    if (paramString.equals("vob"))
                                                                    {
                                                                      i = 30;
                                                                      continue;
                                                                      if (paramString.equals("mpeg"))
                                                                      {
                                                                        i = 31;
                                                                        continue;
                                                                        if (paramString.equals("mpe"))
                                                                        {
                                                                          i = 32;
                                                                          continue;
                                                                          if (paramString.equals("asx"))
                                                                          {
                                                                            i = 33;
                                                                            continue;
                                                                            if (paramString.equals("asf"))
                                                                            {
                                                                              i = 34;
                                                                              continue;
                                                                              if (paramString.equals("f4v"))
                                                                              {
                                                                                i = 35;
                                                                                continue;
                                                                                if (paramString.equals("flv"))
                                                                                {
                                                                                  i = 36;
                                                                                  continue;
                                                                                  if (paramString.equals("mkv"))
                                                                                  {
                                                                                    i = 37;
                                                                                    continue;
                                                                                    if (paramString.equals("wmv"))
                                                                                    {
                                                                                      i = 38;
                                                                                      continue;
                                                                                      if (paramString.equals("wm"))
                                                                                      {
                                                                                        i = 39;
                                                                                        continue;
                                                                                        if (paramString.equals("3gp"))
                                                                                        {
                                                                                          i = 40;
                                                                                          continue;
                                                                                          if (paramString.equals("mp4"))
                                                                                          {
                                                                                            i = 41;
                                                                                            continue;
                                                                                            if (paramString.equals("rmvb"))
                                                                                            {
                                                                                              i = 42;
                                                                                              continue;
                                                                                              if (paramString.equals("rm"))
                                                                                              {
                                                                                                i = 43;
                                                                                                continue;
                                                                                                if (paramString.equals("ra"))
                                                                                                {
                                                                                                  i = 44;
                                                                                                  continue;
                                                                                                  if (paramString.equals("ram"))
                                                                                                  {
                                                                                                    i = 45;
                                                                                                    continue;
                                                                                                    if (paramString.equals("jfif"))
                                                                                                    {
                                                                                                      i = 46;
                                                                                                      continue;
                                                                                                      if (paramString.equals("tiff"))
                                                                                                      {
                                                                                                        i = 47;
                                                                                                        continue;
                                                                                                        if (paramString.equals("tif"))
                                                                                                        {
                                                                                                          i = 48;
                                                                                                          continue;
                                                                                                          if (paramString.equals("jpe"))
                                                                                                          {
                                                                                                            i = 49;
                                                                                                            continue;
                                                                                                            if (paramString.equals("dib"))
                                                                                                            {
                                                                                                              i = 50;
                                                                                                              continue;
                                                                                                              if (paramString.equals("jpeg"))
                                                                                                              {
                                                                                                                i = 51;
                                                                                                                continue;
                                                                                                                if (paramString.equals("jpg"))
                                                                                                                {
                                                                                                                  i = 52;
                                                                                                                  continue;
                                                                                                                  if (paramString.equals("png"))
                                                                                                                  {
                                                                                                                    i = 53;
                                                                                                                    continue;
                                                                                                                    if (paramString.equals("bmp"))
                                                                                                                    {
                                                                                                                      i = 54;
                                                                                                                      continue;
                                                                                                                      if (paramString.equals("gif"))
                                                                                                                      {
                                                                                                                        i = 55;
                                                                                                                        continue;
                                                                                                                        if (paramString.equals("rar"))
                                                                                                                        {
                                                                                                                          i = 56;
                                                                                                                          continue;
                                                                                                                          if (paramString.equals("zip"))
                                                                                                                          {
                                                                                                                            i = 57;
                                                                                                                            continue;
                                                                                                                            if (paramString.equals("7z"))
                                                                                                                            {
                                                                                                                              i = 58;
                                                                                                                              continue;
                                                                                                                              if (paramString.equals("iso"))
                                                                                                                              {
                                                                                                                                i = 59;
                                                                                                                                continue;
                                                                                                                                if (paramString.equals("cab"))
                                                                                                                                {
                                                                                                                                  i = 60;
                                                                                                                                  continue;
                                                                                                                                  if (paramString.equals("unknown")) {
                                                                                                                                    i = 61;
                                                                                                                                  }
                                                                                                                                }
                                                                                                                              }
                                                                                                                            }
                                                                                                                          }
                                                                                                                        }
                                                                                                                      }
                                                                                                                    }
                                                                                                                  }
                                                                                                                }
                                                                                                              }
                                                                                                            }
                                                                                                          }
                                                                                                        }
                                                                                                      }
                                                                                                    }
                                                                                                  }
                                                                                                }
                                                                                              }
                                                                                            }
                                                                                          }
                                                                                        }
                                                                                      }
                                                                                    }
                                                                                  }
                                                                                }
                                                                              }
                                                                            }
                                                                          }
                                                                        }
                                                                      }
                                                                    }
                                                                  }
                                                                }
                                                              }
                                                            }
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    AppMethodBeat.o(54405);
    return "#3980c1";
    AppMethodBeat.o(54405);
    return "#c84e3a";
    AppMethodBeat.o(54405);
    return "#278453";
    AppMethodBeat.o(54405);
    return "#ff7a42";
    AppMethodBeat.o(54405);
    return "#33B0D6";
    AppMethodBeat.o(54405);
    return "#42AA73";
    AppMethodBeat.o(54405);
    return "#6781F0";
  }
  
  public static void J(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(54409);
    String str = String.format(paramContext.getString(2131298356), new Object[] { Integer.valueOf(paramInt) });
    paramContext = new e.a(paramContext);
    paramContext.avu(str).rI(false);
    paramContext.b(new b.1()).show();
    AppMethodBeat.o(54409);
  }
  
  private static com.tencent.mm.plugin.choosemsgfile.b.b.a a(com.tencent.mm.plugin.choosemsgfile.b.c.c paramc, bi parambi)
  {
    AppMethodBeat.i(54395);
    if (parambi.dxV())
    {
      paramc = new com.tencent.mm.plugin.choosemsgfile.b.b.b(paramc, parambi);
      AppMethodBeat.o(54395);
      return paramc;
    }
    if (parambi.dvX())
    {
      paramc = new com.tencent.mm.plugin.choosemsgfile.b.b.g(paramc, parambi);
      AppMethodBeat.o(54395);
      return paramc;
    }
    AppMethodBeat.o(54395);
    return null;
  }
  
  public static com.tencent.mm.plugin.choosemsgfile.b.b.a a(com.tencent.mm.plugin.choosemsgfile.b.c.c paramc, bi parambi, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(54392);
    String str = paramString2;
    if (bo.isNullOrNil(paramString2)) {
      str = "all";
    }
    paramString2 = IX(paramString3);
    paramString3 = str.toLowerCase();
    int i = -1;
    switch (paramString3.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(54392);
        return null;
        if (paramString3.equals("all"))
        {
          i = 0;
          continue;
          if (paramString3.equals("image"))
          {
            i = 1;
            continue;
            if (paramString3.equals("video"))
            {
              i = 2;
              continue;
              if (paramString3.equals("file")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    paramString2 = a(paramc, parambi, paramString1, paramString2);
    paramString1 = paramString2;
    if (paramString2 == null)
    {
      paramString2 = b(paramc, parambi);
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = a(paramc, parambi);
      }
    }
    AppMethodBeat.o(54392);
    return paramString1;
    paramc = a(paramc, parambi);
    AppMethodBeat.o(54392);
    return paramc;
    paramc = b(paramc, parambi);
    AppMethodBeat.o(54392);
    return paramc;
    paramc = a(paramc, parambi, paramString1, paramString2);
    AppMethodBeat.o(54392);
    return paramc;
  }
  
  private static com.tencent.mm.plugin.choosemsgfile.b.b.a a(com.tencent.mm.plugin.choosemsgfile.b.c.c paramc, bi parambi, String paramString, List<String> paramList)
  {
    AppMethodBeat.i(54394);
    if (parambi.bCn())
    {
      Object localObject = parambi.field_content;
      if (localObject != null)
      {
        localObject = j.b.mY((String)localObject);
        if ((localObject != null) && (((j.b)localObject).type == 6))
        {
          paramc = new com.tencent.mm.plugin.choosemsgfile.b.b.f(paramc, parambi, paramString);
          if ((paramList == null) || (paramList.size() == 0))
          {
            AppMethodBeat.o(54394);
            return paramc;
          }
          parambi = paramList.iterator();
          while (parambi.hasNext())
          {
            paramString = (String)parambi.next();
            if (paramc.getFileName().endsWith(paramString))
            {
              AppMethodBeat.o(54394);
              return paramc;
            }
          }
        }
      }
    }
    AppMethodBeat.o(54394);
    return null;
  }
  
  public static void a(int paramInt1, int paramInt2, Intent paramIntent, a.a parama)
  {
    AppMethodBeat.i(54406);
    if (paramInt1 == 291) {
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(54406);
      return;
      if (paramIntent == null)
      {
        ab.e("MicroMsg.MsgFileUtils", "data is null");
        a(parama, "data is null");
        AppMethodBeat.o(54406);
        return;
      }
      paramIntent = paramIntent.getParcelableArrayListExtra("FILEPATHS");
      if (paramIntent == null)
      {
        ab.e("MicroMsg.MsgFileUtils", "msgFiles is null");
        a(parama, "msgFiles is null");
        AppMethodBeat.o(54406);
        return;
      }
      if (parama != null) {
        parama.a(-1, "", paramIntent);
      }
      AppMethodBeat.o(54406);
      return;
      if (paramIntent == null)
      {
        ab.e("MicroMsg.MsgFileUtils", "data is null");
        a(parama, "data is null");
        AppMethodBeat.o(54406);
        return;
      }
      a(parama, paramIntent.getStringExtra("ERRMSG"));
      AppMethodBeat.o(54406);
      return;
      if (parama != null) {
        parama.a(0, "", null);
      }
    }
  }
  
  public static void a(Context paramContext, View paramView, com.tencent.mm.plugin.choosemsgfile.b.b.a parama)
  {
    AppMethodBeat.i(54401);
    Intent localIntent = new Intent();
    if (parama == null)
    {
      ab.e("MicroMsg.MsgFileUtils", "[enterGallery] item == null");
      AppMethodBeat.o(54401);
      return;
    }
    parama = parama.kEz;
    if (parama == null)
    {
      ab.e("MicroMsg.MsgFileUtils", "[enterGallery] msg == null");
      AppMethodBeat.o(54401);
      return;
    }
    int k = paramContext.getResources().getConfiguration().orientation;
    int j = 0;
    int i = 0;
    int[] arrayOfInt = new int[2];
    if (paramView != null)
    {
      j = paramView.getWidth();
      i = paramView.getHeight();
      paramView.getLocationInWindow(arrayOfInt);
    }
    localIntent.addFlags(536870912);
    localIntent.putExtra("img_gallery_msg_id", parama.field_msgId).putExtra("img_gallery_msg_svr_id", parama.field_msgSvrId).putExtra("img_gallery_talker", parama.field_talker).putExtra("img_gallery_chatroom_name", parama.field_talker).putExtra("img_gallery_orientation", k).putExtra("show_enter_grid", false).putExtra("img_gallery_enter_from_scene", 1);
    if (paramView != null) {
      localIntent.putExtra("img_gallery_width", j).putExtra("img_gallery_height", i).putExtra("img_gallery_left", arrayOfInt[0]).putExtra("img_gallery_top", arrayOfInt[1]).putExtra("img_gallery_enter_from_grid", true);
    }
    for (;;)
    {
      d.f(paramContext, "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", localIntent);
      ((Activity)paramContext).overridePendingTransition(0, 0);
      AppMethodBeat.o(54401);
      return;
      localIntent.putExtra("img_gallery_back_from_grid", true);
    }
  }
  
  private static void a(a.a parama, String paramString)
  {
    AppMethodBeat.i(54407);
    if (parama != null) {
      parama.a(1, paramString, null);
    }
    AppMethodBeat.o(54407);
  }
  
  private static com.tencent.mm.plugin.choosemsgfile.b.b.a b(com.tencent.mm.plugin.choosemsgfile.b.c.c paramc, bi parambi)
  {
    AppMethodBeat.i(54396);
    if ((parambi.byj()) || (parambi.byk()))
    {
      paramc = new h(paramc, parambi);
      AppMethodBeat.o(54396);
      return paramc;
    }
    AppMethodBeat.o(54396);
    return null;
  }
  
  public static String b(bi parambi, boolean paramBoolean)
  {
    String str1 = null;
    AppMethodBeat.i(54397);
    if (parambi == null)
    {
      AppMethodBeat.o(54397);
      return null;
    }
    if (parambi.field_isSend == 1)
    {
      parambi = r.Zn();
      AppMethodBeat.o(54397);
      return parambi;
    }
    if (paramBoolean) {
      str1 = bf.pu(parambi.field_content);
    }
    String str2 = str1;
    if (bo.isNullOrNil(str1)) {
      str2 = parambi.field_talker;
    }
    AppMethodBeat.o(54397);
    return str2;
  }
  
  public static String cP(String paramString)
  {
    AppMethodBeat.i(54408);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(54408);
      return "";
    }
    int i = paramString.lastIndexOf(".");
    if (i < 0)
    {
      AppMethodBeat.o(54408);
      return "";
    }
    paramString = paramString.substring(i + 1);
    AppMethodBeat.o(54408);
    return paramString;
  }
  
  public static final com.tencent.mm.at.a.a.c dD(Context paramContext)
  {
    AppMethodBeat.i(54400);
    com.tencent.mm.at.a.a.c localc = (com.tencent.mm.at.a.a.c)kFS.get(Integer.valueOf(4));
    Object localObject = localc;
    if (localc == null)
    {
      localObject = new c.a();
      ((c.a)localObject).fHt = 1;
      ((c.a)localObject).eOf = true;
      ((c.a)localObject).eNT = (com.tencent.mm.cb.a.gw(paramContext) / 4);
      ((c.a)localObject).eNS = (com.tencent.mm.cb.a.gw(paramContext) / 4);
      ((c.a)localObject).eOa = 2131690341;
      localObject = ((c.a)localObject).ahY();
      kFS.put(Integer.valueOf(4), localObject);
    }
    AppMethodBeat.o(54400);
    return localObject;
  }
  
  public static void f(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(54404);
    if (!com.tencent.mm.kernel.g.RL().isSDCardAvailable())
    {
      com.tencent.mm.ui.base.t.ii(paramContext);
      AppMethodBeat.o(54404);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
    localIntent.putExtra("app_msg_id", paramLong);
    localIntent.putExtra("scene", 1);
    paramContext.startActivity(localIntent);
    AppMethodBeat.o(54404);
  }
  
  public static String in(long paramLong)
  {
    AppMethodBeat.i(54398);
    Object localObject = new Date(paramLong);
    localObject = com.tencent.mm.ui.gridviewheaders.a.dNj().a((Date)localObject, ah.getContext());
    AppMethodBeat.o(54398);
    return localObject;
  }
  
  public static long io(long paramLong)
  {
    AppMethodBeat.i(54399);
    Date localDate = new Date(paramLong);
    paramLong = com.tencent.mm.ui.gridviewheaders.a.dNj().b(localDate);
    AppMethodBeat.o(54399);
    return paramLong;
  }
  
  public static String nD(String paramString)
  {
    AppMethodBeat.i(54403);
    if (com.tencent.mm.model.t.lA(paramString))
    {
      localObject = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().arw(paramString);
      if ((localObject != null) && (!bo.isNullOrNil(((aq)localObject).field_nickname)))
      {
        paramString = ((aq)localObject).field_nickname;
        AppMethodBeat.o(54403);
        return paramString;
      }
      localObject = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.chatroom.a.c.class)).YJ().oU(paramString);
      if (localObject == null)
      {
        ab.e("MicroMsg.MsgFileUtils", "%s chatRoomMember is null", new Object[] { paramString });
        AppMethodBeat.o(54403);
        return "";
      }
      paramString = ((u)localObject).field_displayname;
      AppMethodBeat.o(54403);
      return paramString;
    }
    Object localObject = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().arw(paramString);
    if (localObject == null)
    {
      ab.e("MicroMsg.MsgFileUtils", "%s, contact is null", new Object[] { paramString });
      AppMethodBeat.o(54403);
      return "";
    }
    paramString = ((aq)localObject).field_nickname;
    AppMethodBeat.o(54403);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.d.b
 * JD-Core Version:    0.7.0.1
 */