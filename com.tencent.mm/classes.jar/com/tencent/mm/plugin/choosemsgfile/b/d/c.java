package com.tencent.mm.plugin.choosemsgfile.b.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.br.d;
import com.tencent.mm.choosemsgfile.compat.a.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.al;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.choosemsgfile.b.b.h;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class c
{
  private static ah<Integer, com.tencent.mm.av.a.a.c> oZQ;
  
  static
  {
    AppMethodBeat.i(123381);
    oZQ = new ah(3);
    AppMethodBeat.o(123381);
  }
  
  public static void Q(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(123380);
    String str = String.format(paramContext.getString(2131757349), new Object[] { Integer.valueOf(paramInt) });
    paramContext = new f.a(paramContext);
    paramContext.aZq(str).zi(false);
    paramContext.b(new f.c()
    {
      public final void d(boolean paramAnonymousBoolean, String paramAnonymousString) {}
    }).show();
    AppMethodBeat.o(123380);
  }
  
  private static com.tencent.mm.plugin.choosemsgfile.b.b.a a(com.tencent.mm.plugin.choosemsgfile.b.c.c paramc, bv parambv)
  {
    AppMethodBeat.i(123366);
    if (parambv.fvK())
    {
      paramc = new com.tencent.mm.plugin.choosemsgfile.b.b.b(paramc, parambv);
      AppMethodBeat.o(123366);
      return paramc;
    }
    if (parambv.ftg())
    {
      paramc = new com.tencent.mm.plugin.choosemsgfile.b.b.g(paramc, parambv);
      AppMethodBeat.o(123366);
      return paramc;
    }
    AppMethodBeat.o(123366);
    return null;
  }
  
  public static com.tencent.mm.plugin.choosemsgfile.b.b.a a(com.tencent.mm.plugin.choosemsgfile.b.c.c paramc, bv parambv, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(123363);
    String str = paramString2;
    if (bu.isNullOrNil(paramString2)) {
      str = "all";
    }
    paramString2 = aat(paramString3);
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
    paramString2 = a(paramc, parambv, paramString1, paramString2);
    paramString1 = paramString2;
    if (paramString2 == null)
    {
      paramString2 = b(paramc, parambv);
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = a(paramc, parambv);
      }
    }
    AppMethodBeat.o(123363);
    return paramString1;
    paramc = a(paramc, parambv);
    AppMethodBeat.o(123363);
    return paramc;
    paramc = b(paramc, parambv);
    AppMethodBeat.o(123363);
    return paramc;
    paramc = a(paramc, parambv, paramString1, paramString2);
    AppMethodBeat.o(123363);
    return paramc;
  }
  
  private static com.tencent.mm.plugin.choosemsgfile.b.b.a a(com.tencent.mm.plugin.choosemsgfile.b.c.c paramc, bv parambv, String paramString, List<String> paramList)
  {
    AppMethodBeat.i(123365);
    if (parambv.cVH())
    {
      Object localObject = parambv.field_content;
      if (localObject != null)
      {
        localObject = k.b.zb((String)localObject);
        if ((localObject != null) && (((k.b)localObject).type == 6))
        {
          paramc = new com.tencent.mm.plugin.choosemsgfile.b.b.f(paramc, parambv, paramString);
          if ((paramList == null) || (paramList.size() == 0))
          {
            AppMethodBeat.o(123365);
            return paramc;
          }
          parambv = paramList.iterator();
          while (parambv.hasNext())
          {
            paramString = (String)parambv.next();
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
    if (paramInt1 == b.oZP) {
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
        ae.e("MicroMsg.MsgFileUtils", "data is null");
        a(parama, "data is null");
        AppMethodBeat.o(123377);
        return;
      }
      paramIntent = paramIntent.getParcelableArrayListExtra("FILEPATHS");
      if (paramIntent == null)
      {
        ae.e("MicroMsg.MsgFileUtils", "msgFiles is null");
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
        ae.e("MicroMsg.MsgFileUtils", "data is null");
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
      ae.e("MicroMsg.MsgFileUtils", "[enterGallery] item == null");
      AppMethodBeat.o(123372);
      return;
    }
    parama = parama.oYw;
    if (parama == null)
    {
      ae.e("MicroMsg.MsgFileUtils", "[enterGallery] msg == null");
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
      d.f(paramContext, "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", localIntent);
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
  
  public static List<String> aat(String paramString)
  {
    AppMethodBeat.i(123364);
    localArrayList = new ArrayList();
    if (bu.isNullOrNil(paramString))
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
        if (!bu.isNullOrNil(str)) {
          localArrayList.add(str);
        }
        i += 1;
      }
      return localArrayList;
    }
    catch (com.tencent.mm.ab.g paramString)
    {
      ae.printErrStackTrace("MicroMsg.MsgFileUtils", paramString, "", new Object[0]);
      AppMethodBeat.o(123364);
    }
  }
  
  public static String aau(String paramString)
  {
    AppMethodBeat.i(123373);
    if (bu.isNullOrNil(paramString))
    {
      ae.i("MicroMsg.MsgFileUtils", "type is null, use default type");
      AppMethodBeat.o(123373);
      return "all";
    }
    if (("all".equals(paramString)) || ("image".equals(paramString)) || ("video".equals(paramString)) || ("file".equals(paramString)))
    {
      ae.i("MicroMsg.MsgFileUtils", "type is invalid, use default type");
      AppMethodBeat.o(123373);
      return paramString;
    }
    AppMethodBeat.o(123373);
    return "all";
  }
  
  public static String aav(String paramString)
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
  
  public static String aaw(String paramString)
  {
    AppMethodBeat.i(123379);
    if (bu.isNullOrNil(paramString))
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
  
  private static com.tencent.mm.plugin.choosemsgfile.b.b.a b(com.tencent.mm.plugin.choosemsgfile.b.c.c paramc, bv parambv)
  {
    AppMethodBeat.i(123367);
    if ((parambv.cyG()) || (parambv.cyI()))
    {
      paramc = new h(paramc, parambv);
      AppMethodBeat.o(123367);
      return paramc;
    }
    AppMethodBeat.o(123367);
    return null;
  }
  
  public static String b(bv parambv, boolean paramBoolean)
  {
    String str1 = null;
    AppMethodBeat.i(123368);
    if (parambv == null)
    {
      AppMethodBeat.o(123368);
      return null;
    }
    if (parambv.field_isSend == 1)
    {
      parambv = v.aAC();
      AppMethodBeat.o(123368);
      return parambv;
    }
    if (paramBoolean) {
      str1 = bl.BM(parambv.field_content);
    }
    String str2 = str1;
    if (bu.isNullOrNil(str1)) {
      str2 = parambv.field_talker;
    }
    AppMethodBeat.o(123368);
    return str2;
  }
  
  public static final com.tencent.mm.av.a.a.c ex(Context paramContext)
  {
    AppMethodBeat.i(123371);
    com.tencent.mm.av.a.a.c localc = (com.tencent.mm.av.a.a.c)oZQ.get(Integer.valueOf(4));
    Object localObject = localc;
    if (localc == null)
    {
      localObject = new c.a();
      ((c.a)localObject).ign = 1;
      ((c.a)localObject).igD = true;
      ((c.a)localObject).hgG = (com.tencent.mm.cb.a.iu(paramContext) / 4);
      ((c.a)localObject).hgF = (com.tencent.mm.cb.a.iu(paramContext) / 4);
      ((c.a)localObject).igy = 2131100734;
      localObject = ((c.a)localObject).aJu();
      oZQ.put(Integer.valueOf(4), localObject);
    }
    AppMethodBeat.o(123371);
    return localObject;
  }
  
  public static void g(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(123375);
    if (!com.tencent.mm.kernel.g.ajR().isSDCardAvailable())
    {
      t.g(paramContext, null);
      AppMethodBeat.o(123375);
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).setClassName(paramContext, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
    ((Intent)localObject).putExtra("app_msg_id", paramLong);
    ((Intent)localObject).putExtra("scene", 1);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/choosemsgfile/logic/util/MsgFileUtils", "enterFileProfile", "(Landroid/content/Context;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/choosemsgfile/logic/util/MsgFileUtils", "enterFileProfile", "(Landroid/content/Context;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(123375);
  }
  
  public static String tX(long paramLong)
  {
    AppMethodBeat.i(123369);
    Object localObject = new Date(paramLong);
    localObject = com.tencent.mm.ui.gridviewheaders.a.fNX().a((Date)localObject, ak.getContext());
    AppMethodBeat.o(123369);
    return localObject;
  }
  
  public static long tY(long paramLong)
  {
    AppMethodBeat.i(123370);
    Date localDate = new Date(paramLong);
    paramLong = com.tencent.mm.ui.gridviewheaders.a.fNX().b(localDate);
    AppMethodBeat.o(123370);
    return paramLong;
  }
  
  public static String zO(String paramString)
  {
    AppMethodBeat.i(123374);
    if (x.wb(paramString))
    {
      localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(paramString);
      if ((localObject != null) && (!bu.isNullOrNil(((aw)localObject).field_nickname)))
      {
        paramString = ((aw)localObject).field_nickname;
        AppMethodBeat.o(123374);
        return paramString;
      }
      localObject = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(paramString);
      if (localObject == null)
      {
        ae.e("MicroMsg.MsgFileUtils", "%s chatRoomMember is null", new Object[] { paramString });
        AppMethodBeat.o(123374);
        return "";
      }
      paramString = ((ac)localObject).field_displayname;
      AppMethodBeat.o(123374);
      return paramString;
    }
    Object localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(paramString);
    if (localObject == null)
    {
      ae.e("MicroMsg.MsgFileUtils", "%s, contact is null", new Object[] { paramString });
      AppMethodBeat.o(123374);
      return "";
    }
    paramString = ((aw)localObject).field_nickname;
    AppMethodBeat.o(123374);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.d.c
 * JD-Core Version:    0.7.0.1
 */