package com.tencent.mm.plugin.choosemsgfile.b.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.choosemsgfile.compat.a.a;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.choosemsgfile.b.b.h;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class c
{
  private static LruCache<Integer, com.tencent.mm.av.a.a.c> qoO;
  
  static
  {
    AppMethodBeat.i(123381);
    qoO = new LruCache(3);
    AppMethodBeat.o(123381);
  }
  
  public static String Cc(long paramLong)
  {
    AppMethodBeat.i(123369);
    Object localObject = new Date(paramLong);
    localObject = com.tencent.mm.ui.gridviewheaders.a.gWr().a((Date)localObject, MMApplicationContext.getContext());
    AppMethodBeat.o(123369);
    return localObject;
  }
  
  public static long Cd(long paramLong)
  {
    AppMethodBeat.i(123370);
    Date localDate = new Date(paramLong);
    paramLong = com.tencent.mm.ui.gridviewheaders.a.gWr().b(localDate);
    AppMethodBeat.o(123370);
    return paramLong;
  }
  
  public static String Ir(String paramString)
  {
    AppMethodBeat.i(123374);
    if (ab.Eq(paramString))
    {
      localObject = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(paramString);
      if ((localObject != null) && (!Util.isNullOrNil(((ax)localObject).field_nickname)))
      {
        paramString = ((ax)localObject).field_nickname;
        AppMethodBeat.o(123374);
        return paramString;
      }
      localObject = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(paramString);
      if (localObject == null)
      {
        Log.e("MicroMsg.MsgFileUtils", "%s chatRoomMember is null", new Object[] { paramString });
        AppMethodBeat.o(123374);
        return "";
      }
      paramString = ((ah)localObject).field_displayname;
      AppMethodBeat.o(123374);
      return paramString;
    }
    Object localObject = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(paramString);
    if (localObject == null)
    {
      Log.e("MicroMsg.MsgFileUtils", "%s, contact is null", new Object[] { paramString });
      AppMethodBeat.o(123374);
      return "";
    }
    paramString = ((ax)localObject).field_nickname;
    AppMethodBeat.o(123374);
    return paramString;
  }
  
  public static void V(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(123380);
    String str = String.format(paramContext.getString(2131757566), new Object[] { Integer.valueOf(paramInt) });
    paramContext = new f.a(paramContext);
    paramContext.bow(str).Dq(false);
    paramContext.b(new f.c()
    {
      public final void e(boolean paramAnonymousBoolean, String paramAnonymousString) {}
    }).show();
    AppMethodBeat.o(123380);
  }
  
  private static com.tencent.mm.plugin.choosemsgfile.b.b.a a(com.tencent.mm.plugin.choosemsgfile.b.c.c paramc, ca paramca)
  {
    AppMethodBeat.i(123366);
    if (paramca.gDr())
    {
      paramc = new com.tencent.mm.plugin.choosemsgfile.b.b.b(paramc, paramca);
      AppMethodBeat.o(123366);
      return paramc;
    }
    if (paramca.gAz())
    {
      paramc = new com.tencent.mm.plugin.choosemsgfile.b.b.g(paramc, paramca);
      AppMethodBeat.o(123366);
      return paramc;
    }
    AppMethodBeat.o(123366);
    return null;
  }
  
  public static com.tencent.mm.plugin.choosemsgfile.b.b.a a(com.tencent.mm.plugin.choosemsgfile.b.c.c paramc, ca paramca, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(123363);
    String str = paramString2;
    if (Util.isNullOrNil(paramString2)) {
      str = "all";
    }
    paramString2 = akz(paramString3);
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
        AppMethodBeat.o(123363);
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
    paramString2 = a(paramc, paramca, paramString1, paramString2);
    paramString1 = paramString2;
    if (paramString2 == null)
    {
      paramString2 = b(paramc, paramca);
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = a(paramc, paramca);
      }
    }
    AppMethodBeat.o(123363);
    return paramString1;
    paramc = a(paramc, paramca);
    AppMethodBeat.o(123363);
    return paramc;
    paramc = b(paramc, paramca);
    AppMethodBeat.o(123363);
    return paramc;
    paramc = a(paramc, paramca, paramString1, paramString2);
    AppMethodBeat.o(123363);
    return paramc;
  }
  
  private static com.tencent.mm.plugin.choosemsgfile.b.b.a a(com.tencent.mm.plugin.choosemsgfile.b.c.c paramc, ca paramca, String paramString, List<String> paramList)
  {
    AppMethodBeat.i(123365);
    if (paramca.dOQ())
    {
      Object localObject = paramca.field_content;
      if (localObject != null)
      {
        localObject = k.b.HD((String)localObject);
        if ((localObject != null) && (((k.b)localObject).type == 6))
        {
          paramc = new com.tencent.mm.plugin.choosemsgfile.b.b.f(paramc, paramca, paramString);
          if ((paramList == null) || (paramList.size() == 0))
          {
            AppMethodBeat.o(123365);
            return paramc;
          }
          paramca = paramList.iterator();
          while (paramca.hasNext())
          {
            paramString = (String)paramca.next();
            if (paramc.getFileName().endsWith(paramString))
            {
              AppMethodBeat.o(123365);
              return paramc;
            }
          }
        }
      }
    }
    AppMethodBeat.o(123365);
    return null;
  }
  
  public static void a(int paramInt1, int paramInt2, Intent paramIntent, a.a parama)
  {
    AppMethodBeat.i(123377);
    if (paramInt1 == b.qoN) {
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(123377);
      return;
      if (paramIntent == null)
      {
        Log.e("MicroMsg.MsgFileUtils", "data is null");
        a(parama, "data is null");
        AppMethodBeat.o(123377);
        return;
      }
      paramIntent = paramIntent.getParcelableArrayListExtra("FILEPATHS");
      if (paramIntent == null)
      {
        Log.e("MicroMsg.MsgFileUtils", "msgFiles is null");
        a(parama, "msgFiles is null");
        AppMethodBeat.o(123377);
        return;
      }
      if (parama != null) {
        parama.a(-1, "", paramIntent);
      }
      AppMethodBeat.o(123377);
      return;
      if (paramIntent == null)
      {
        Log.e("MicroMsg.MsgFileUtils", "data is null");
        a(parama, "data is null");
        AppMethodBeat.o(123377);
        return;
      }
      a(parama, paramIntent.getStringExtra("ERRMSG"));
      AppMethodBeat.o(123377);
      return;
      if (parama != null) {
        parama.a(0, "", null);
      }
    }
  }
  
  public static void a(Context paramContext, View paramView, com.tencent.mm.plugin.choosemsgfile.b.b.a parama)
  {
    AppMethodBeat.i(123372);
    Intent localIntent = new Intent();
    if (parama == null)
    {
      Log.e("MicroMsg.MsgFileUtils", "[enterGallery] item == null");
      AppMethodBeat.o(123372);
      return;
    }
    parama = parama.qnv;
    if (parama == null)
    {
      Log.e("MicroMsg.MsgFileUtils", "[enterGallery] msg == null");
      AppMethodBeat.o(123372);
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
      com.tencent.mm.br.c.f(paramContext, "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", localIntent);
      ((Activity)paramContext).overridePendingTransition(0, 0);
      AppMethodBeat.o(123372);
      return;
      localIntent.putExtra("img_gallery_back_from_grid", true);
    }
  }
  
  private static void a(a.a parama, String paramString)
  {
    AppMethodBeat.i(123378);
    if (parama != null) {
      parama.a(1, paramString, null);
    }
    AppMethodBeat.o(123378);
  }
  
  public static String akA(String paramString)
  {
    AppMethodBeat.i(123373);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.MsgFileUtils", "type is null, use default type");
      AppMethodBeat.o(123373);
      return "all";
    }
    if (("all".equals(paramString)) || ("image".equals(paramString)) || ("video".equals(paramString)) || ("file".equals(paramString)))
    {
      Log.i("MicroMsg.MsgFileUtils", "type is invalid, use default type");
      AppMethodBeat.o(123373);
      return paramString;
    }
    AppMethodBeat.o(123373);
    return "all";
  }
  
  public static String akB(String paramString)
  {
    AppMethodBeat.i(123376);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(123376);
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
    AppMethodBeat.o(123376);
    return "#3980c1";
    AppMethodBeat.o(123376);
    return "#c84e3a";
    AppMethodBeat.o(123376);
    return "#278453";
    AppMethodBeat.o(123376);
    return "#ff7a42";
    AppMethodBeat.o(123376);
    return "#33B0D6";
    AppMethodBeat.o(123376);
    return "#42AA73";
    AppMethodBeat.o(123376);
    return "#6781F0";
  }
  
  public static String akC(String paramString)
  {
    AppMethodBeat.i(123379);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(123379);
      return "";
    }
    int i = paramString.lastIndexOf(".");
    if (i < 0)
    {
      AppMethodBeat.o(123379);
      return "";
    }
    paramString = paramString.substring(i + 1);
    AppMethodBeat.o(123379);
    return paramString;
  }
  
  public static List<String> akz(String paramString)
  {
    AppMethodBeat.i(123364);
    localArrayList = new ArrayList();
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(123364);
      return localArrayList;
    }
    try
    {
      paramString = new com.tencent.mm.ab.f(paramString);
      int i = 0;
      while (i < paramString.length())
      {
        String str = paramString.optString(i, "");
        if (!Util.isNullOrNil(str)) {
          localArrayList.add(str);
        }
        i += 1;
      }
      return localArrayList;
    }
    catch (com.tencent.mm.ab.g paramString)
    {
      Log.printErrStackTrace("MicroMsg.MsgFileUtils", paramString, "", new Object[0]);
      AppMethodBeat.o(123364);
    }
  }
  
  private static com.tencent.mm.plugin.choosemsgfile.b.b.a b(com.tencent.mm.plugin.choosemsgfile.b.c.c paramc, ca paramca)
  {
    AppMethodBeat.i(123367);
    if ((paramca.cWJ()) || (paramca.cWL()))
    {
      paramc = new h(paramc, paramca);
      AppMethodBeat.o(123367);
      return paramc;
    }
    AppMethodBeat.o(123367);
    return null;
  }
  
  public static String b(ca paramca, boolean paramBoolean)
  {
    String str1 = null;
    AppMethodBeat.i(123368);
    if (paramca == null)
    {
      AppMethodBeat.o(123368);
      return null;
    }
    if (paramca.field_isSend == 1)
    {
      paramca = z.aTY();
      AppMethodBeat.o(123368);
      return paramca;
    }
    if (paramBoolean) {
      str1 = bp.Ks(paramca.field_content);
    }
    String str2 = str1;
    if (Util.isNullOrNil(str1)) {
      str2 = paramca.field_talker;
    }
    AppMethodBeat.o(123368);
    return str2;
  }
  
  public static final com.tencent.mm.av.a.a.c eT(Context paramContext)
  {
    AppMethodBeat.i(123371);
    com.tencent.mm.av.a.a.c localc = (com.tencent.mm.av.a.a.c)qoO.get(Integer.valueOf(4));
    Object localObject = localc;
    if (localc == null)
    {
      localObject = new c.a();
      ((c.a)localObject).jbi = 1;
      ((c.a)localObject).jby = true;
      ((c.a)localObject).hZA = (com.tencent.mm.cb.a.jn(paramContext) / 4);
      ((c.a)localObject).hZz = (com.tencent.mm.cb.a.jn(paramContext) / 4);
      ((c.a)localObject).jbt = 2131100928;
      localObject = ((c.a)localObject).bdv();
      qoO.put(Integer.valueOf(4), localObject);
    }
    AppMethodBeat.o(123371);
    return localObject;
  }
  
  public static void g(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(123375);
    if (!com.tencent.mm.kernel.g.aAh().isSDCardAvailable())
    {
      u.g(paramContext, null);
      AppMethodBeat.o(123375);
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).setClassName(paramContext, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
    ((Intent)localObject).putExtra("app_msg_id", paramLong);
    ((Intent)localObject).putExtra("scene", 1);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/choosemsgfile/logic/util/MsgFileUtils", "enterFileProfile", "(Landroid/content/Context;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/choosemsgfile/logic/util/MsgFileUtils", "enterFileProfile", "(Landroid/content/Context;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(123375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.d.c
 * JD-Core Version:    0.7.0.1
 */