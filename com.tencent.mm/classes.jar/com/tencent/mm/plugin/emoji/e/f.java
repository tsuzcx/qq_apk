package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.cb.a.b;
import com.tencent.mm.emoji.loader.d.i.a;
import com.tencent.mm.g.a.bk;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.g.a.dh.b;
import com.tencent.mm.g.a.sh;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.bi;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI;
import com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.protocal.protobuf.czh;
import com.tencent.mm.protocal.protobuf.czi;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.av.a;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.storage.emotion.t;
import com.tencent.mm.storage.emotion.u;
import com.tencent.mm.storage.emotion.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

public final class f
  implements com.tencent.mm.pluginsdk.a.d
{
  private static void a(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(108448);
    if (paramString1.equals("-1"))
    {
      ac.e("MicroMsg.emoji.EmojiMgrImpl", "showEmoji fail cause md5 is no valid");
      AppMethodBeat.o(108448);
      return;
    }
    EmojiInfo localEmojiInfo = k.getEmojiStorageMgr().GXZ.aOT(paramString1);
    if (localEmojiInfo == null)
    {
      ac.e("MicroMsg.emoji.EmojiMgrImpl", "showEmoji fail cause md5 is no valid");
      AppMethodBeat.o(108448);
      return;
    }
    Intent localIntent = new Intent(paramContext, CustomSmileyPreviewUI.class);
    localIntent.putExtra("custom_smiley_preview_md5", paramString1);
    if (paramString2 != null) {
      localIntent.putExtra("custom_smiley_preview_appid", paramString2);
    }
    for (;;)
    {
      localIntent.putExtra("custom_smiley_preview_appname", paramString3);
      localIntent.putExtra("msg_id", paramLong);
      localIntent.putExtra("msg_content", paramString5);
      paramString1 = paramString4;
      if (com.tencent.mm.model.w.sQ(paramString4))
      {
        paramString1 = bi.yl(paramString5);
        localIntent.putExtra("room_id", paramString6);
      }
      localIntent.putExtra("msg_sender", paramString1);
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.aeD(), "com/tencent/mm/plugin/emoji/mgr/EmojiMgrImpl", "showEmoji", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString1.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/emoji/mgr/EmojiMgrImpl", "showEmoji", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(108448);
      return;
      localIntent.putExtra("custom_smiley_preview_appid", localEmojiInfo.field_app_id);
    }
  }
  
  static void cS(String paramString, int paramInt)
  {
    AppMethodBeat.i(108445);
    com.tencent.mm.g.a.s locals = new com.tencent.mm.g.a.s();
    locals.cYZ.cZa = paramString;
    locals.cYZ.status = paramInt;
    locals.cYZ.percentage = 0;
    com.tencent.mm.sdk.b.a.GpY.l(locals);
    ac.d("MicroMsg.emoji.EmojiMgrImpl", "attachid:%s percentage:%d status:%d", new Object[] { paramString, Integer.valueOf(0), Integer.valueOf(paramInt) });
    AppMethodBeat.o(108445);
  }
  
  public final boolean O(ArrayList<SmileyInfo> paramArrayList)
  {
    AppMethodBeat.i(108472);
    boolean bool = k.getEmojiStorageMgr().GYh.aX(paramArrayList);
    AppMethodBeat.o(108472);
    return bool;
  }
  
  public final boolean P(ArrayList<SmileyPanelConfigInfo> paramArrayList)
  {
    AppMethodBeat.i(108473);
    u localu = k.getEmojiStorageMgr().GYi;
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      ac.i("MicroMsg.emoji.SmileyPanelConfigInfoStorage", "insertSmileyConfigInfoList failed. list is null.");
      AppMethodBeat.o(108473);
      return false;
    }
    com.tencent.mm.storagebase.h localh;
    long l;
    if ((localu.db instanceof com.tencent.mm.storagebase.h))
    {
      localh = (com.tencent.mm.storagebase.h)localu.db;
      l = localh.vE(Thread.currentThread().getId());
    }
    for (;;)
    {
      localu.db.delete("SmileyPanelConfigInfo", null, null);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localu.insert((SmileyPanelConfigInfo)paramArrayList.next());
      }
      int i = -1;
      if (localh != null) {
        i = localh.qL(l);
      }
      if (i < 0) {
        break;
      }
      AppMethodBeat.o(108473);
      return true;
      l = -1L;
      localh = null;
    }
  }
  
  public final EmojiInfo XL(String paramString)
  {
    AppMethodBeat.i(108440);
    paramString = k.getEmojiStorageMgr().GXZ.aOT(paramString);
    AppMethodBeat.o(108440);
    return paramString;
  }
  
  public final EmojiInfo XM(String paramString)
  {
    AppMethodBeat.i(108441);
    paramString = XL(paramString);
    AppMethodBeat.o(108441);
    return paramString;
  }
  
  public final String XN(String paramString)
  {
    AppMethodBeat.i(108453);
    paramString = EmojiLogic.XN(paramString);
    AppMethodBeat.o(108453);
    return paramString;
  }
  
  public final List<EmojiInfo> XO(String paramString)
  {
    AppMethodBeat.i(108456);
    if (com.tencent.mm.kernel.g.agR().isSDCardAvailable())
    {
      paramString = (ArrayList)k.getEmojiStorageMgr().GXZ.XO(paramString);
      AppMethodBeat.o(108456);
      return paramString;
    }
    paramString = new ArrayList();
    AppMethodBeat.o(108456);
    return paramString;
  }
  
  public final String XP(String paramString)
  {
    AppMethodBeat.i(108458);
    paramString = k.getEmojiDescMgr().XP(paramString);
    AppMethodBeat.o(108458);
    return paramString;
  }
  
  public final boolean XQ(String paramString)
  {
    AppMethodBeat.i(108459);
    if ((paramString != null) && (paramString.equals("capture")))
    {
      AppMethodBeat.o(108459);
      return true;
    }
    boolean bool = k.getEmojiStorageMgr().GYa.aOL(paramString);
    AppMethodBeat.o(108459);
    return bool;
  }
  
  public final ArrayList<String> XR(String paramString)
  {
    AppMethodBeat.i(108460);
    av localav = k.getEmojiDescMgr();
    if (!localav.mInit) {
      localav.faW();
    }
    long l = System.currentTimeMillis();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    if (!localav.mInit) {
      localav.faW();
    }
    if (com.tencent.mm.ui.tools.f.aRl(paramString) > localav.GXv) {
      ac.i("MicroMsg.emoji.EmojiDescNewMgr", "input text over checkout limit.");
    }
    for (;;)
    {
      paramString = localArrayList3.iterator();
      while (paramString.hasNext())
      {
        Object localObject = (String)paramString.next();
        localObject = (ArrayList)localav.GXz.get(localObject);
        if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
          localArrayList1.addAll((Collection)localObject);
        }
      }
      if ((!bs.isNullOrNil(paramString)) && (localav.GXz != null))
      {
        paramString = paramString.toLowerCase();
        if (localav.GXy.containsKey(paramString))
        {
          paramString = (String)localav.GXy.get(paramString);
          paramString = (List)localav.GXx.get(paramString);
          if (paramString != null) {
            localArrayList3.addAll(paramString);
          }
        }
        else
        {
          localArrayList3.add(paramString);
        }
      }
    }
    ac.i("MicroMsg.emoji.EmojiDescNewMgr", "changeText: %s, %s", new Object[] { Integer.valueOf(localArrayList3.size()), Integer.valueOf(localArrayList1.size()) });
    if (!localArrayList1.isEmpty())
    {
      Collections.sort(localArrayList1, localav.GXA);
      int i = 0;
      while (i < localArrayList1.size())
      {
        localArrayList2.add(((av.a)localArrayList1.get(i)).md5);
        i += 1;
      }
    }
    ac.d("MicroMsg.emoji.EmojiDescNewMgr", "cpan[check desc]User time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(108460);
    return localArrayList2;
  }
  
  public final String XS(String paramString)
  {
    AppMethodBeat.i(108461);
    paramString = EmojiLogic.XS(paramString);
    AppMethodBeat.o(108461);
    return paramString;
  }
  
  public final String XT(String paramString)
  {
    AppMethodBeat.i(108462);
    paramString = EmojiLogic.XT(paramString);
    AppMethodBeat.o(108462);
    return paramString;
  }
  
  public final int XU(String paramString)
  {
    AppMethodBeat.i(108463);
    int i = EmojiLogic.XU(paramString);
    AppMethodBeat.o(108463);
    return i;
  }
  
  public final String XV(String paramString)
  {
    AppMethodBeat.i(108464);
    paramString = EmojiLogic.XV(paramString);
    AppMethodBeat.o(108464);
    return paramString;
  }
  
  public final void XW(String paramString)
  {
    AppMethodBeat.i(108476);
    if (bs.isNullOrNil(paramString)) {
      ac.i("MicroMsg.emoji.EmojiCommandMgr", "emoji command is null.");
    }
    Object localObject1;
    if ("sync".equalsIgnoreCase(paramString))
    {
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GDX, Boolean.TRUE);
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GEc, Boolean.TRUE);
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GEd, Boolean.TRUE);
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GEg, Long.valueOf(System.currentTimeMillis()));
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GEh, Long.valueOf(System.currentTimeMillis()));
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GDW, Long.valueOf(0L));
      com.tencent.mm.kernel.g.agQ().ghe.a(new com.tencent.mm.plugin.emoji.f.e(0), 0);
      com.tencent.mm.kernel.g.agQ().ghe.a(new com.tencent.mm.plugin.emoji.f.e(1), 0);
      localObject1 = new com.tencent.mm.plugin.emoji.f.n(8, null, 15, true);
      com.tencent.mm.kernel.g.agQ().ghe.a((com.tencent.mm.ak.n)localObject1, 0);
    }
    while (bt.eWo())
    {
      Object localObject3;
      Object localObject4;
      if ("new".equalsIgnoreCase(paramString))
      {
        com.tencent.mm.y.c.aeH().w(262147, true);
        com.tencent.mm.kernel.g.agR().agA().set(208899, Boolean.TRUE);
        com.tencent.mm.kernel.g.agR().agA().set(229633, "http://mmbiz.qpic.cn/mmemoticon/Q3auHgzwzM5eOptD4jIj72I8icMVEKwzSYkC30IgjMvSibGfqsEdy0ibXayiaZtbibSXV5EPZEWILOvbrjjLtQ9P4QQ/0");
        com.tencent.mm.kernel.g.agR().agA().set(229634, System.currentTimeMillis());
        AppMethodBeat.o(108476);
        return;
        if ("rcheart".equalsIgnoreCase(paramString))
        {
          k.getEmojiStorageMgr().GYa.fcY();
        }
        else if ("recover".equalsIgnoreCase(paramString))
        {
          ac.i("MicroMsg.emoji.EmojiCommandMgr", "recover   begin");
          k.getEmojiStorageMgr().GXZ.init(ai.getContext());
          k.getEmojiStorageMgr().GYa.init(ai.getContext());
          ac.i("MicroMsg.emoji.EmojiCommandMgr", "recover   end");
        }
        else
        {
          Object localObject2;
          if ("clean".equalsIgnoreCase(paramString))
          {
            ac.i("MicroMsg.emoji.EmojiCommandMgr", "begin clean");
            localObject1 = d.cbO();
            localObject2 = com.tencent.mm.emoji.d.a.fWM;
            ((d)localObject1).XK(com.tencent.mm.emoji.d.a.adJ());
            com.tencent.mm.kernel.g.agR().agA().set(ah.a.GEc, Boolean.TRUE);
            ac.i("MicroMsg.emoji.EmojiCommandMgr", "end clean");
          }
          else
          {
            if ("dump".equalsIgnoreCase(paramString))
            {
              ac.i("MicroMsg.emoji.EmojiCommandMgr", "begin dump emoji db info:");
              localObject1 = (ArrayList)k.getEmojiStorageMgr().GYa.fcK();
              if (((ArrayList)localObject1).size() > 0)
              {
                int j = ((ArrayList)localObject1).size();
                int i = 0;
                while (i < j)
                {
                  ac.i("MicroMsg.emoji.EmojiCommandMgr", "i:%d group info:%s", new Object[] { Integer.valueOf(i), ((EmojiGroupInfo)((ArrayList)localObject1).get(i)).toString() });
                  i += 1;
                }
              }
              localObject2 = null;
              localObject1 = null;
              try
              {
                localObject3 = k.getEmojiStorageMgr().GXZ.getAll();
                if (localObject3 != null)
                {
                  localObject1 = localObject3;
                  localObject2 = localObject3;
                  if (((Cursor)localObject3).moveToFirst())
                  {
                    boolean bool;
                    do
                    {
                      localObject1 = localObject3;
                      localObject2 = localObject3;
                      localObject4 = new EmojiInfo();
                      localObject1 = localObject3;
                      localObject2 = localObject3;
                      ((EmojiInfo)localObject4).convertFrom((Cursor)localObject3);
                      localObject1 = localObject3;
                      localObject2 = localObject3;
                      ac.i("MicroMsg.emoji.EmojiCommandMgr", "emoji info:%s", new Object[] { ((EmojiInfo)localObject4).toString() });
                      localObject1 = localObject3;
                      localObject2 = localObject3;
                      bool = ((Cursor)localObject3).moveToNext();
                    } while (bool);
                  }
                }
                if (localObject3 != null) {
                  ((Cursor)localObject3).close();
                }
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  if (localObject1 != null) {
                    ((Cursor)localObject1).close();
                  }
                }
              }
              finally
              {
                if (localException == null) {
                  break label702;
                }
                localException.close();
                AppMethodBeat.o(108476);
              }
              ac.i("MicroMsg.emoji.EmojiCommandMgr", "end dump emoji db info:");
              continue;
            }
            label702:
            if ("config".equalsIgnoreCase(paramString))
            {
              com.tencent.mm.pluginsdk.h.a.a.b.eLH().f(37, 1, -1, false);
              com.tencent.mm.pluginsdk.h.a.a.b.eLH().f(37, 2, -1, false);
              com.tencent.mm.pluginsdk.h.a.a.b.eLH().f(37, 4, -1, false);
              com.tencent.mm.kernel.g.agR().agA().set(ah.a.GEo, Integer.valueOf(0));
              com.tencent.mm.kernel.g.agR().agA().set(ah.a.GEp, Integer.valueOf(0));
              com.tencent.mm.kernel.g.agR().agA().set(ah.a.GEr, Integer.valueOf(0));
              localObject1 = new com.tencent.mm.pluginsdk.h.a.a.m(37);
              com.tencent.mm.kernel.g.agQ().ghe.a((com.tencent.mm.ak.n)localObject1, 0);
              com.tencent.mm.vfs.i.deleteFile(com.tencent.mm.cf.b.Gxy);
            }
            else if ("tuzki".equalsIgnoreCase(paramString))
            {
              com.tencent.mm.plugin.emoji.f.a.cct();
              com.tencent.mm.plugin.emoji.f.a.ccu();
            }
            else if (paramString.startsWith("reset-first"))
            {
              com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRt, Boolean.FALSE);
              com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRu, Boolean.FALSE);
              com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRv, Boolean.FALSE);
              com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRw, Boolean.FALSE);
            }
            else if (paramString.startsWith("cleanThumb"))
            {
              localObject1 = com.tencent.mm.emoji.d.a.fWM;
              com.tencent.mm.emoji.d.a.adL();
              Toast.makeText(ai.getContext(), "clean thumb done", 0).show();
            }
          }
        }
      }
      else
      {
        if ("free".equalsIgnoreCase(paramString))
        {
          com.tencent.mm.y.c.aeH().w(262149, true);
          com.tencent.mm.kernel.g.agR().agA().set(208913, Boolean.TRUE);
          com.tencent.mm.kernel.g.agR().agA().set(229633, "http://mmbiz.qpic.cn/mmemoticon/Q3auHgzwzM5eOptD4jIj72I8icMVEKwzSYkC30IgjMvSibGfqsEdy0ibXayiaZtbibSXV5EPZEWILOvbrjjLtQ9P4QQ/0");
          com.tencent.mm.kernel.g.agR().agA().set(229634, System.currentTimeMillis());
          AppMethodBeat.o(108476);
          return;
        }
        if ("newp".equalsIgnoreCase(paramString))
        {
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GEb, Boolean.TRUE);
          AppMethodBeat.o(108476);
          return;
        }
        if ("newpe".equalsIgnoreCase(paramString))
        {
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GEf, Boolean.TRUE);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("add"))
        {
          a.XI(paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("backup"))
        {
          paramString = new com.tencent.mm.plugin.emoji.f.c(0, 1, Arrays.asList(paramString.replace("backup", "").trim().split(",")));
          com.tencent.mm.kernel.g.agQ().ghe.a(paramString, 0);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("h5"))
        {
          paramString = paramString.replace("h5", "").trim();
          PreferenceManager.getDefaultSharedPreferences(ai.getContext()).edit().putString("h5", paramString).commit();
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("md5"))
        {
          localObject1 = paramString.replace("md5", "").trim();
          paramString = (String)localObject1;
          if (bs.isNullOrNil((String)localObject1)) {
            paramString = "/sdcard/test.png";
          }
          ac.i("MicroMsg.emoji.EmojiCommandMgr", com.tencent.mm.vfs.i.aKe(paramString));
          ac.i("MicroMsg.emoji.EmojiCommandMgr", ah.dg(paramString));
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("recommend"))
        {
          paramString = com.tencent.mm.plugin.emoji.g.d.Yp("<NewRecommendEmotion><Emotion><ProductID>com.tencent.xin.emoticon.person.stiker_144984189945aa5830d33cd7dc</ProductID><RecType>3</RecType><Name>野萌君</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/duc2TvpEgSTWy4k8MnuicFjyiazriaGWDX52HzNWeLVTjtJcjZeZEicTn5kJFPYdicWZTuUZJgiaADK9I/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/DhduwiaBa7lchicgAfwibeykm81eGWXkMDgGJ8DWcOcIc28C7oTic4Y09Pick8Fw69KiaZVxrHl8S2lPY/0</Panel><ButtonType>1</ButtonType></Emotion><Emotion><ProductID>com.tencent.xin.emoticon.person.stiker_14389422638f6ca818af405e21</ProductID><RecType>3</RecType><Name>猪仔和羊妹</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/iaUiazNVkRp7iaZjrMuYgfH8kB5xkyYv20CYzY3W9HCLBr2XybJibGKKtXibMnAfZnRTH/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/PiajxSqBRaEJR9canNKZ7RYI3hx5BPCSwQmuhhlNWD1jzUSOx3CWqEtibd65zOjySd/0</Panel><ButtonType>1</ButtonType></Emotion><Emotion><ProductID>com.tencent.xin.emoticon.person.stiker_1444199720f5ea147582ff0512</ProductID><RecType>3</RecType><Name>让红包飞</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/nMl9ssowtibXLY57PdK8Nsh827vlsw4TGHPgLUehd2R455xnwe3xpoVDIKpAuXU1Aic3XbH1LfMr7fp4DgO7o8IQ/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/duc2TvpEgST18reErFRzNFR8EiahI4Iibp4ZnW1ibJYt4MMLvQvjx3sHGTMuTOgnREq5f2GXLhuzalOOz3icw9NGbA/0</Panel><ButtonType>1</ButtonType></Emotion><Emotion><ProductID>com.tencent.xin.emoticon.xiaobendan</ProductID><RecType>3</RecType><Name>小笨蛋与大坏蛋</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/ajNVdqHZLLC8ILTt0pqcaCVkldLMydoNJcupoR7qUojia3vKlgd74uQ/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/ajNVdqHZLLC8ILTt0pqcaAAEUI4a7z5ECqpUXbQw95PY1mpc4p0FxA/0</Panel><ButtonType>1</ButtonType></Emotion><Emotion><ProductID>com.tencent.xin.emoticon.shin2</ProductID><RecType>3</RecType><Name>野原新之助2</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/iciaySdkria4apGIW1wvSbPC9oxWQPHZyicaccx5JDIp2uE/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/ajNVdqHZLLASEAAX7xw76beia5j4HyA0rq9WgtgscicJo7935UCpCpog/0</Panel><ButtonType>1</ButtonType></Emotion></NewRecommendEmotion>");
          k.getEmojiStorageMgr().GYa.fcQ();
          k.getEmojiStorageMgr().GYa.aU(paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("count"))
        {
          paramString = paramString.replace("count", "").trim();
          com.tencent.mm.m.g.ZY().put("CustomEmojiMaxSize", paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("auto"))
        {
          paramString = paramString.replace("auto", "").trim();
          com.tencent.mm.m.g.ZY().put("C2CEmojiNotAutoDownloadTimeRange", paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("bo"))
        {
          if (paramString.replace("bo", "").trim().equalsIgnoreCase("1"))
          {
            PreferenceManager.getDefaultSharedPreferences(ai.getContext()).edit().putBoolean("broken", true).commit();
            AppMethodBeat.o(108476);
            return;
          }
          PreferenceManager.getDefaultSharedPreferences(ai.getContext()).edit().putBoolean("broken", false).commit();
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("newsmiley"))
        {
          paramString = new ArrayList();
          localObject1 = new SmileyInfo("/::AAA", "[机智]", "[机智]", "[机智]", "[机智]", "[机智]", "emoji2.png", 1000);
          SmileyInfo localSmileyInfo1 = new SmileyInfo("/::BBB", "[滑稽]", "[滑稽]", "[滑稽]", "[滑稽]", "[滑稽]", "emoji3.png", 1001);
          localObject3 = new SmileyInfo("[Pose]", "[摆姿势]", "[摆姿势]", "[摆姿势]", "[摆姿势]", "[摆姿势]", "emoji4.png", 1002);
          localObject4 = new SmileyInfo("/::DDD", "[瞪]", "[瞪]", "[瞪]", "[瞪]", "[瞪]", "emoji5.png", 1003);
          SmileyInfo localSmileyInfo2 = new SmileyInfo("/::FFF", "[捂脸]", "[捂脸]", "[捂脸]", "[捂脸]", "[捂脸]", "emoji6.png", 1004);
          SmileyInfo localSmileyInfo3 = new SmileyInfo("/::Doge", "[Doge]", "[Doge]", "[Doge]", "[Doge]", "[Doge]", "emoji7.png", 1005);
          paramString.add(localObject1);
          paramString.add(localSmileyInfo1);
          paramString.add(localObject3);
          paramString.add(localObject4);
          paramString.add(localSmileyInfo2);
          paramString.add(localSmileyInfo3);
          k.getEmojiStorageMgr().GYh.aX(paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("panel"))
        {
          paramString.replace("panel", "").trim();
          paramString = new bk();
          paramString.dbc.subType = 1;
          paramString.dbc.dbd = 37;
          paramString.dbc.filePath = (com.tencent.mm.loader.j.b.aph() + "CheckResUpdate/37.1.data");
          com.tencent.mm.sdk.b.a.GpY.l(paramString);
          paramString = new bk();
          paramString.dbc.subType = 2;
          paramString.dbc.dbd = 37;
          paramString.dbc.filePath = "/sdcard/tencent/MicroMsg/CheckResUpdate/37.2.data";
          com.tencent.mm.sdk.b.a.GpY.l(paramString);
          paramString = new bk();
          paramString.dbc.subType = 3;
          paramString.dbc.dbd = 37;
          paramString.dbc.filePath = (com.tencent.mm.loader.j.b.aph() + "CheckResUpdate/37.3.data");
          com.tencent.mm.sdk.b.a.GpY.l(paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("key"))
        {
          paramString = com.tencent.mm.b.g.getMessageDigest(String.valueOf(System.currentTimeMillis()).getBytes());
          ac.i("MicroMsg.emoji.EmojiCommandMgr", "create key :%s" + bs.aLJ(paramString));
          k.getEmojiStorageMgr().GXZ.YW(153);
          localObject1 = new EmojiInfo();
          ((EmojiInfo)localObject1).field_md5 = paramString;
          ((EmojiInfo)localObject1).field_catalog = 153;
          k.getEmojiStorageMgr().GXZ.K((EmojiInfo)localObject1);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("delete"))
        {
          a.XH(paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("delete-db"))
        {
          paramString = paramString.replace("delete-db", "").trim();
          k.getEmojiStorageMgr().GXZ.cF(paramString, true);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("delete-file"))
        {
          a.XG(paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("batchDownload"))
        {
          paramString = paramString.split(" ");
          if (paramString.length > 1)
          {
            paramString = new com.tencent.mm.plugin.emoji.f.e(bs.aLy(paramString[1]));
            com.tencent.mm.kernel.g.agQ().ghe.a(paramString, 0);
          }
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("getInfo"))
        {
          paramString = paramString.split(" ");
          if (paramString.length > 1)
          {
            localObject1 = new LinkedList();
            ((LinkedList)localObject1).add(paramString[1]);
            paramString = new com.tencent.mm.plugin.emoji.f.e((LinkedList)localObject1);
            com.tencent.mm.kernel.g.agQ().ghe.a(paramString, 0);
          }
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("test"))
        {
          ac.i("MicroMsg.emoji.EmojiCommandMgr", "theTest: %s", new Object[] { paramString });
          com.tencent.e.h.JZN.aS(new a.1());
        }
      }
    }
    AppMethodBeat.o(108476);
  }
  
  public final void XX(String paramString)
  {
    AppMethodBeat.i(176179);
    com.tencent.mm.storage.emotion.w localw = k.getEmojiStorageMgr().GYk;
    LinkedList localLinkedList;
    int i;
    if (!bs.isNullOrNil(paramString))
    {
      localLinkedList = localw.uEi;
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < localw.uEi.size())
        {
          if (bs.lr(((v)localw.uEi.get(i)).key, paramString))
          {
            localv = (v)localw.uEi.get(i);
            if (localv == null)
            {
              localv = new v();
              localv.key = paramString;
              localv.Hbc += 1;
              localv.gLX = System.currentTimeMillis();
              localw.uEi.add(0, localv);
              if (localw.uEi.size() > 9) {
                localw.uEi.remove(localw.uEi.size() - 1);
              }
              localw.doNotify("event_update_recent", 0, Integer.valueOf(localw.uEi.size()));
              AppMethodBeat.o(176179);
            }
          }
          else
          {
            i += 1;
            continue;
          }
          localw.uEi.remove(i);
          continue;
        }
        i = -1;
      }
      finally
      {
        AppMethodBeat.o(176179);
      }
      v localv = null;
    }
  }
  
  public final boolean XY(String paramString)
  {
    bool2 = false;
    AppMethodBeat.i(108499);
    com.tencent.mm.plugin.gif.f localf = new com.tencent.mm.plugin.gif.f(paramString);
    int i = (int)com.tencent.mm.vfs.i.aSp(paramString);
    if (i != 0) {
      bool1 = bool2;
    }
    try
    {
      if (i <= com.tencent.mm.m.b.ZG())
      {
        bool1 = bool2;
        if (localf.txk[0] <= com.tencent.mm.m.b.ZF())
        {
          i = localf.txk[1];
          int j = com.tencent.mm.m.b.ZF();
          if (i <= j) {
            break label104;
          }
          bool1 = bool2;
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ac.e("MicroMsg.emoji.EmojiMgrImpl", bs.m(paramString));
        bool1 = bool2;
        continue;
        bool1 = true;
      }
    }
    AppMethodBeat.o(108499);
    return bool1;
  }
  
  public final void XZ(String paramString)
  {
    AppMethodBeat.i(108501);
    if (!bs.isNullOrNil(paramString))
    {
      ac.i("MicroMsg.emoji.EmojiMgrImpl", "deleteCaptureEmoji md: ".concat(String.valueOf(paramString)));
      k.getEmojiStorageMgr().GXZ.cF(paramString, true);
      k.getEmojiStorageMgr().GXZ.doNotify("delete_emoji_info_notify");
    }
    AppMethodBeat.o(108501);
  }
  
  public final void Ya(String paramString)
  {
    AppMethodBeat.i(108503);
    EmojiInfo localEmojiInfo = XL(paramString);
    if (localEmojiInfo != null)
    {
      paramString = com.tencent.mm.emoji.c.i.fWF;
      com.tencent.mm.emoji.c.i.o(localEmojiInfo);
      AppMethodBeat.o(108503);
      return;
    }
    ac.w("MicroMsg.emoji.EmojiMgrImpl", "addCaptureEmojiUploadTask: emojiInfo null by md5 %s", new Object[] { paramString });
    AppMethodBeat.o(108503);
  }
  
  public final EmojiInfo a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    AppMethodBeat.i(108451);
    paramString1 = k.getEmojiStorageMgr().GXZ.e(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3);
    AppMethodBeat.o(108451);
    return paramString1;
  }
  
  public final String a(Context paramContext, WXMediaMessage paramWXMediaMessage, String paramString)
  {
    AppMethodBeat.i(108454);
    paramContext = EmojiLogic.a(paramWXMediaMessage, paramString);
    AppMethodBeat.o(108454);
    return paramContext;
  }
  
  public final void a(Context paramContext, bo parambo, String paramString)
  {
    AppMethodBeat.i(108444);
    if ((paramContext == null) || (parambo == null))
    {
      ac.w("MicroMsg.emoji.EmojiMgrImpl", "context or msg is null");
      AppMethodBeat.o(108444);
      return;
    }
    au localau = au.aOb(parambo.field_content);
    Object localObject2 = k.b.vA(parambo.field_content);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new k.b();
      ((k.b)localObject1).hhH = localau.md5;
    }
    localObject2 = k.getEmojiStorageMgr().GXZ.aOT(((k.b)localObject1).hhH);
    if ((localObject2 != null) && (((EmojiInfo)localObject2).fdp()))
    {
      if (parambo.field_isSend == 1)
      {
        a(paramContext, ((k.b)localObject1).hhH, ((k.b)localObject1).appId, ((k.b)localObject1).appName, parambo.field_msgSvrId, parambo.field_talker, parambo.field_content, paramString);
        AppMethodBeat.o(108444);
        return;
      }
      a(paramContext, ((EmojiInfo)localObject2).JC(), ((k.b)localObject1).appId, ((k.b)localObject1).appName, parambo.field_msgSvrId, parambo.field_talker, parambo.field_content, paramString);
      AppMethodBeat.o(108444);
      return;
    }
    paramContext = k.getEmojiStorageMgr().GXZ.aOT(((k.b)localObject1).hhH);
    if (paramContext == null)
    {
      parambo = ((k.b)localObject1).hhH;
      if (bs.isNullOrNil(parambo))
      {
        ac.e("MicroMsg.emoji.EmojiMgrImpl", "md5 is null.");
        AppMethodBeat.o(108444);
        return;
      }
      paramContext = new EmojiInfo();
      paramContext.field_md5 = parambo;
      paramContext.field_app_id = ((k.b)localObject1).appId;
      paramContext.field_catalog = EmojiInfo.Jss;
      paramContext.field_size = ((k.b)localObject1).hhF;
      paramContext.field_temp = 1;
      paramContext.field_state = EmojiInfo.Kgh;
      k.getEmojiStorageMgr().GXZ.K(paramContext);
    }
    for (;;)
    {
      cS(paramContext.field_md5, 0);
      ac.d("MicroMsg.emoji.EmojiMgrImpl", "start change cdn url. md5:%s", new Object[] { paramContext.field_md5 });
      parambo = paramContext.field_md5;
      paramString = com.tencent.mm.emoji.loader.e.fOZ;
      com.tencent.mm.emoji.loader.e.a(paramContext, true, new i.a()
      {
        public final void de(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(108439);
          if (paramAnonymousBoolean)
          {
            f.cS(this.laP, 1);
            AppMethodBeat.o(108439);
            return;
          }
          f.cS(this.laP, 2);
          AppMethodBeat.o(108439);
        }
      });
      AppMethodBeat.o(108444);
      return;
    }
  }
  
  public final void a(String paramString, EmojiInfo paramEmojiInfo, bo parambo)
  {
    AppMethodBeat.i(108447);
    if ((paramEmojiInfo == null) && (parambo == null))
    {
      AppMethodBeat.o(108447);
      return;
    }
    EmojiInfo localEmojiInfo = paramEmojiInfo;
    if (paramEmojiInfo == null) {
      localEmojiInfo = k.getEmojiStorageMgr().GXZ.aOT(parambo.field_imgPath);
    }
    k.ccl().a(paramString, localEmojiInfo, parambo);
    AppMethodBeat.o(108447);
  }
  
  public final boolean a(Context paramContext, EmojiInfo paramEmojiInfo, int paramInt, String paramString)
  {
    AppMethodBeat.i(108443);
    if (paramContext == null)
    {
      ac.e("MicroMsg.emoji.EmojiMgrImpl", "[cpan] save emoji failed. context is null");
      AppMethodBeat.o(108443);
      return false;
    }
    if (paramEmojiInfo == null)
    {
      ac.e("MicroMsg.emoji.EmojiMgrImpl", "[cpan] save emoji failed. emoji is null");
      AppMethodBeat.o(108443);
      return false;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, EmojiAddCustomDialogUI.class);
    localIntent.putExtra("extra_id", paramEmojiInfo.JC());
    localIntent.putExtra("extra_scence", paramInt);
    localIntent.putExtra("extra_move_to_top", true);
    localIntent.putExtra("extra_username", paramString);
    localIntent.putExtra("extra_current", false);
    localIntent.putExtra("key_is_selfie", false);
    localIntent.putExtra("key_attached_text", null);
    localIntent.putExtra("key_attached_emoji_md5", null);
    localIntent.putExtra("key_imitate_md5", null);
    localIntent.addFlags(65536);
    paramEmojiInfo = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramEmojiInfo.aeD(), "com/tencent/mm/plugin/emoji/mgr/EmojiMgrImpl", "saveCustomEmoji", "(Landroid/content/Context;Lcom/tencent/mm/storage/emotion/EmojiInfo;ILjava/lang/String;IZZZLjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramEmojiInfo.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/emoji/mgr/EmojiMgrImpl", "saveCustomEmoji", "(Landroid/content/Context;Lcom/tencent/mm/storage/emotion/EmojiInfo;ILjava/lang/String;IZZZLjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(108443);
    return true;
  }
  
  public final boolean a(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(108468);
    paramBoolean = com.tencent.mm.emoji.decode.a.abO().a(paramEmojiInfo, paramBoolean);
    AppMethodBeat.o(108468);
    return paramBoolean;
  }
  
  public final boolean a(String paramString1, String paramString2, long paramLong, String paramString3, f.a parama)
  {
    boolean bool = false;
    AppMethodBeat.i(108455);
    com.tencent.mm.plugin.emoji.model.c localc = k.ccl();
    ac.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml ".concat(String.valueOf(paramString2)));
    paramString1 = ay.a(bv.L(paramString2, "msg"), paramString1, paramString2, paramString3);
    if (paramString1 == null)
    {
      ac.i("MicroMsg.emoji.EmojiService", "prepareEmoji failed. emoji msg info is null.");
      AppMethodBeat.o(108455);
      return true;
    }
    paramString1.dpl = paramLong;
    ac.i("MicroMsg.emoji.EmojiService", "summerbadcr prepareEmoji msgSvrId[%d], stack[%s]", new Object[] { Long.valueOf(paramLong), bs.eWi() });
    localc.Yl(paramString1.dcO);
    if (!EmojiLogic.Yk(com.tencent.mm.emoji.a.m.acu())) {
      bool = true;
    }
    localc.a(paramString1, parama, bool);
    AppMethodBeat.o(108455);
    return true;
  }
  
  public final byte[] a(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108466);
    if (paramEmojiInfo != null)
    {
      EmojiInfo localEmojiInfo = XL(paramEmojiInfo.field_md5);
      if ((localEmojiInfo != null) && (localEmojiInfo.field_reserved4 != paramEmojiInfo.field_reserved4)) {
        paramEmojiInfo.field_reserved4 = localEmojiInfo.field_reserved4;
      }
    }
    paramEmojiInfo = com.tencent.mm.emoji.decode.a.abO().a(paramEmojiInfo);
    AppMethodBeat.o(108466);
    return paramEmojiInfo;
  }
  
  public final boolean acy()
  {
    AppMethodBeat.i(108492);
    boolean bool = com.tencent.mm.emoji.a.m.acy();
    AppMethodBeat.o(108492);
    return bool;
  }
  
  public final boolean acz()
  {
    AppMethodBeat.i(108493);
    if ((bt.eWo()) || (com.tencent.mm.emoji.a.m.acz()))
    {
      AppMethodBeat.o(108493);
      return true;
    }
    AppMethodBeat.o(108493);
    return false;
  }
  
  public final <T> T c(ah.a parama, T paramT)
  {
    AppMethodBeat.i(108497);
    parama = com.tencent.mm.kernel.g.agR().agA().get(parama, paramT);
    AppMethodBeat.o(108497);
    return parama;
  }
  
  public final boolean cbQ()
  {
    AppMethodBeat.i(108469);
    boolean bool = com.tencent.mm.emoji.a.m.acr();
    AppMethodBeat.o(108469);
    return bool;
  }
  
  public final ArrayList<SmileyInfo> cbR()
  {
    AppMethodBeat.i(108470);
    ArrayList localArrayList = k.getEmojiStorageMgr().GYh.cbR();
    AppMethodBeat.o(108470);
    return localArrayList;
  }
  
  public final ArrayList<SmileyPanelConfigInfo> cbS()
  {
    AppMethodBeat.i(108471);
    ArrayList localArrayList = k.getEmojiStorageMgr().GYi.cbS();
    AppMethodBeat.o(108471);
    return localArrayList;
  }
  
  public final com.tencent.mm.bb.f cbT()
  {
    AppMethodBeat.i(108475);
    com.tencent.mm.bb.f localf = h.ccb().cbT();
    AppMethodBeat.o(108475);
    return localf;
  }
  
  public final boolean cbU()
  {
    AppMethodBeat.i(108477);
    if ((bt.eWo()) || (com.tencent.mm.emoji.a.m.acA()))
    {
      AppMethodBeat.o(108477);
      return true;
    }
    AppMethodBeat.o(108477);
    return false;
  }
  
  public final String cbV()
  {
    AppMethodBeat.i(108478);
    h.ccb();
    String str = h.cbV();
    AppMethodBeat.o(108478);
    return str;
  }
  
  public final void cbW()
  {
    AppMethodBeat.i(108479);
    h.ccb();
    bk localbk = new bk();
    localbk.dbc.filePath = (com.tencent.mm.loader.j.b.aph() + "CheckResUpdate/37.1.data.decompressed");
    localbk.dbc.dbd = 37;
    localbk.dbc.subType = 1;
    h.a(localbk, h.a.oZA, h.oZa);
    AppMethodBeat.o(108479);
  }
  
  public final boolean cbX()
  {
    AppMethodBeat.i(108491);
    boolean bool = com.tencent.mm.emoji.a.m.acx();
    AppMethodBeat.o(108491);
    return bool;
  }
  
  public final List<v> cbY()
  {
    AppMethodBeat.i(108495);
    List localList = k.getEmojiStorageMgr().GYk.cbY();
    AppMethodBeat.o(108495);
    return localList;
  }
  
  public final void cbZ()
  {
    AppMethodBeat.i(108496);
    Object localObject = k.getEmojiStorageMgr().GYk.cbY();
    JSONArray localJSONArray = new JSONArray();
    localObject = ((List)localObject).iterator();
    do
    {
      v localv;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localv = (v)((Iterator)localObject).next();
      } while (localv.toJson() == null);
      localJSONArray.put(localv.toJson());
    } while (localJSONArray.length() < 9);
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRq, localJSONArray.toString());
    AppMethodBeat.o(108496);
  }
  
  public final boolean cca()
  {
    AppMethodBeat.i(108500);
    if (!com.tencent.mm.kernel.g.agR().agA().getBoolean(ah.a.GRw, true)) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.emoji.a.m.isSpringFestivalEnable();
      if (i == 0) {
        break;
      }
      AppMethodBeat.o(108500);
      return true;
    }
    AppMethodBeat.o(108500);
    return false;
  }
  
  public final int d(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(108480);
    if ((paramBoolean) || ((paramEmojiInfo != null) && (paramEmojiInfo.field_activityid != null) && (paramEmojiInfo.field_activityid.startsWith("Selfie:")))) {}
    for (int i = 1; i != 0; i = 0)
    {
      i = com.tencent.mm.m.b.ZG();
      AppMethodBeat.o(108480);
      return i;
    }
    i = com.tencent.mm.m.b.ZE();
    AppMethodBeat.o(108480);
    return i;
  }
  
  public final void d(ah.a parama, Object paramObject)
  {
    AppMethodBeat.i(108498);
    com.tencent.mm.kernel.g.agR().agA().set(parama, paramObject);
    AppMethodBeat.o(108498);
  }
  
  public final ay fn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108449);
    Map localMap = bv.L(paramString1, "msg");
    if (localMap == null)
    {
      ac.w("MicroMsg.emoji.EmojiMgrImpl", "get from xml, but attrs is null");
      AppMethodBeat.o(108449);
      return null;
    }
    paramString2 = ay.e(localMap, paramString2, paramString1);
    if (paramString2 == null)
    {
      ac.w("MicroMsg.emoji.EmojiMgrImpl", "parserEmojiXml error ".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(108449);
      return null;
    }
    AppMethodBeat.o(108449);
    return paramString2;
  }
  
  public final String fo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108474);
    com.tencent.mm.emoji.d.a locala = com.tencent.mm.emoji.d.a.fWM;
    paramString1 = EmojiLogic.P(com.tencent.mm.emoji.d.a.adJ(), paramString1, paramString2);
    AppMethodBeat.o(108474);
    return paramString1;
  }
  
  public final String getAccPath()
  {
    AppMethodBeat.i(108457);
    String str = com.tencent.mm.kernel.g.agR().ghC;
    AppMethodBeat.o(108457);
    return str;
  }
  
  public final String getDataEmojiPath()
  {
    AppMethodBeat.i(207440);
    String str = h.getDataEmojiPath();
    AppMethodBeat.o(207440);
    return str;
  }
  
  public final void h(k.a parama)
  {
    AppMethodBeat.i(108487);
    k.getEmojiStorageMgr().GXZ.remove(parama);
    AppMethodBeat.o(108487);
  }
  
  public final void i(k.a parama)
  {
    AppMethodBeat.i(108488);
    k.getEmojiStorageMgr().GXZ.add(parama);
    AppMethodBeat.o(108488);
  }
  
  public final void j(k.a parama)
  {
    AppMethodBeat.i(108489);
    k.getEmojiStorageMgr().GYa.remove(parama);
    AppMethodBeat.o(108489);
  }
  
  public final void k(k.a parama)
  {
    AppMethodBeat.i(108490);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.agO().agp()).ahL()) {
      k.getEmojiStorageMgr().GYa.add(parama);
    }
    AppMethodBeat.o(108490);
  }
  
  public final EmojiInfo l(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(108450);
    paramString = a(paramString, "", paramInt1, paramInt2, paramInt3, "");
    AppMethodBeat.o(108450);
    return paramString;
  }
  
  public final void onDestroy() {}
  
  public final EmojiInfo p(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108442);
    Object localObject = paramEmojiInfo;
    if (paramEmojiInfo.field_catalog == EmojiGroupInfo.Jsq)
    {
      localObject = paramEmojiInfo;
      if (paramEmojiInfo.getContent().length() > 0)
      {
        localObject = paramEmojiInfo;
        if (EmojiInfo.YR(bs.getInt(paramEmojiInfo.getContent(), 0)))
        {
          Cursor localCursor = k.getEmojiStorageMgr().GXZ.YV(bs.getInt(paramEmojiInfo.getContent(), 0));
          EmojiInfo localEmojiInfo = paramEmojiInfo;
          if (localCursor != null)
          {
            localEmojiInfo = paramEmojiInfo;
            if (localCursor.getCount() > 1)
            {
              int i = bs.jk(localCursor.getCount() - 1, 0);
              localEmojiInfo = new EmojiInfo();
              localCursor.moveToPosition(i);
              localEmojiInfo.convertFrom(localCursor);
            }
          }
          localObject = localEmojiInfo;
          if (localCursor != null)
          {
            localCursor.close();
            localObject = localEmojiInfo;
          }
        }
      }
    }
    AppMethodBeat.o(108442);
    return localObject;
  }
  
  public final int q(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108465);
    if (paramEmojiInfo != null)
    {
      if ((paramEmojiInfo.field_catalog == EmojiInfo.Jsw) || (String.valueOf(EmojiInfo.Jsw).equals(paramEmojiInfo.field_groupId)))
      {
        AppMethodBeat.o(108465);
        return 2131232753;
      }
      if ((paramEmojiInfo.field_catalog == EmojiInfo.Jsx) || (String.valueOf(EmojiInfo.Jsx).equals(paramEmojiInfo.field_groupId)))
      {
        AppMethodBeat.o(108465);
        return 2131231929;
      }
    }
    AppMethodBeat.o(108465);
    return 0;
  }
  
  public final int[] r(EmojiInfo paramEmojiInfo)
  {
    if (paramEmojiInfo != null)
    {
      if (paramEmojiInfo.field_catalog == EmojiInfo.Jsw) {
        return new int[] { 2131232755, 2131232756, 2131232754 };
      }
      if (paramEmojiInfo.field_catalog == EmojiInfo.Jsx) {
        return new int[] { 2131231936, 2131231937, 2131231938, 2131231939 };
      }
    }
    return null;
  }
  
  public final byte[] s(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108467);
    Object localObject;
    if (paramEmojiInfo != null)
    {
      localObject = XL(paramEmojiInfo.field_md5);
      if ((localObject != null) && (((EmojiInfo)localObject).field_reserved4 != paramEmojiInfo.field_reserved4)) {
        paramEmojiInfo.field_reserved4 = ((EmojiInfo)localObject).field_reserved4;
      }
    }
    paramEmojiInfo = com.tencent.mm.emoji.decode.a.abO().a(paramEmojiInfo);
    if (com.tencent.mm.sdk.platformtools.s.co(paramEmojiInfo))
    {
      localObject = MMWXGFJNI.nativeWxamToGif(paramEmojiInfo);
      if (bs.cv((byte[])localObject)) {
        ac.w("MicroMsg.emoji.EmojiMgrImpl", "decodeAsGif: wxam to gif error");
      }
      for (;;)
      {
        AppMethodBeat.o(108467);
        return localObject;
        ac.i("MicroMsg.emoji.EmojiMgrImpl", "decodeAsGif: %s, %s", new Object[] { Integer.valueOf(paramEmojiInfo.length), Integer.valueOf(localObject.length) });
      }
    }
    AppMethodBeat.o(108467);
    return paramEmojiInfo;
  }
  
  public final void t(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108502);
    paramEmojiInfo.field_groupId = "capture";
    Object localObject = new ArrayList();
    ((List)localObject).add(paramEmojiInfo.JC());
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().GXZ.p(1, (List)localObject);
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().GXZ.L(paramEmojiInfo);
    paramEmojiInfo = new dh();
    paramEmojiInfo.dcK.type = 2;
    com.tencent.mm.sdk.b.a.GpY.l(paramEmojiInfo);
    if (!paramEmojiInfo.dcL.dcM)
    {
      paramEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().GYc.fdv();
      if (paramEmojiInfo != null)
      {
        localObject = paramEmojiInfo.FIC.iterator();
        while (((Iterator)localObject).hasNext())
        {
          czi localczi = (czi)((Iterator)localObject).next();
          if (localczi.ProductID.equals(String.valueOf("capture"))) {
            localczi.DWO = 0;
          }
        }
      }
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().GYc.a(paramEmojiInfo);
      com.tencent.mm.cb.a.eSf();
      paramEmojiInfo = com.tencent.mm.cb.a.Gju;
      a.b.aJX(String.valueOf("capture"));
    }
    AppMethodBeat.o(108502);
  }
  
  public final boolean u(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(108446);
    if (paramContext == null)
    {
      ac.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: context is null");
      AppMethodBeat.o(108446);
      return false;
    }
    if ((bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString2)))
    {
      ac.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: userName or imgPath is null");
      AppMethodBeat.o(108446);
      return false;
    }
    EmojiInfo localEmojiInfo = k.getEmojiStorageMgr().GXZ.aOT(paramString2);
    if (localEmojiInfo == null)
    {
      ac.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: emoji not found, imgPath %s", new Object[] { paramString2 });
      AppMethodBeat.o(108446);
      return false;
    }
    if ((localEmojiInfo.field_type == EmojiInfo.Kgb) || (localEmojiInfo.field_type == EmojiInfo.Kgc))
    {
      paramContext = new WXMediaMessage();
      paramString2 = localEmojiInfo.ghd();
      if (com.tencent.mm.vfs.i.eA(localEmojiInfo.ghe())) {
        paramContext.thumbData = com.tencent.mm.vfs.i.aU(localEmojiInfo.ghe(), 0, -1);
      }
      for (;;)
      {
        paramContext.mediaObject = new WXEmojiObject(paramString2);
        paramString2 = new sh();
        paramString2.dvk.dis = paramContext;
        paramString2.dvk.appId = localEmojiInfo.field_app_id;
        paramString2.dvk.appName = null;
        paramString2.dvk.toUser = paramString1;
        paramString2.dvk.dit = 0;
        paramString2.dvk.dvn = localEmojiInfo.JC();
        com.tencent.mm.sdk.b.a.GpY.l(paramString2);
        AppMethodBeat.o(108446);
        return true;
        paramContext.setThumbImage(localEmojiInfo.fxG());
      }
    }
    paramString2 = localEmojiInfo;
    if (localEmojiInfo.field_type == EmojiInfo.KfY)
    {
      if (!EmojiInfo.YR(localEmojiInfo.field_catalog)) {
        break label363;
      }
      paramContext = k.getEmojiStorageMgr().GXZ.YV(localEmojiInfo.field_catalog);
    }
    for (;;)
    {
      paramString2 = localEmojiInfo;
      if (paramContext != null)
      {
        int i = bs.jk(paramContext.getCount() - 1, 0);
        paramString2 = new EmojiInfo();
        paramContext.moveToPosition(i);
        paramString2.convertFrom(paramContext);
        paramContext.close();
      }
      k.ccl().a(paramString1, paramString2, null);
      break;
      label363:
      if ((localEmojiInfo.field_catalog == EmojiInfo.Jsu) && (localEmojiInfo.getContent().length() > 0) && (EmojiInfo.YR(bs.getInt(localEmojiInfo.getContent(), 0)))) {
        paramContext = k.getEmojiStorageMgr().GXZ.YV(bs.getInt(localEmojiInfo.getContent(), 0));
      } else {
        paramContext = null;
      }
    }
  }
  
  public final void updateEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108452);
    k.getEmojiStorageMgr().GXZ.L(paramEmojiInfo);
    AppMethodBeat.o(108452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.f
 * JD-Core Version:    0.7.0.1
 */