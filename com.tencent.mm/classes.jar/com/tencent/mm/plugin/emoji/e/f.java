package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.q;
import com.tencent.mm.cc.a.b;
import com.tencent.mm.emoji.a.l;
import com.tencent.mm.emoji.loader.d.i.a;
import com.tencent.mm.g.a.bk;
import com.tencent.mm.g.a.dg;
import com.tencent.mm.g.a.dg.b;
import com.tencent.mm.g.a.ry;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI;
import com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.pluginsdk.h.a.a.m;
import com.tencent.mm.protocal.protobuf.ctv;
import com.tencent.mm.protocal.protobuf.ctw;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.as.a;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.storage.emotion.s;
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
      ad.e("MicroMsg.emoji.EmojiMgrImpl", "showEmoji fail cause md5 is no valid");
      AppMethodBeat.o(108448);
      return;
    }
    EmojiInfo localEmojiInfo = k.getEmojiStorageMgr().FyY.aJx(paramString1);
    if (localEmojiInfo == null)
    {
      ad.e("MicroMsg.emoji.EmojiMgrImpl", "showEmoji fail cause md5 is no valid");
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
      if (w.pF(paramString4))
      {
        paramString1 = bi.uf(paramString5);
        localIntent.putExtra("room_id", paramString6);
      }
      localIntent.putExtra("msg_sender", paramString1);
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.adn(), "com/tencent/mm/plugin/emoji/mgr/EmojiMgrImpl", "showEmoji", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString1.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/emoji/mgr/EmojiMgrImpl", "showEmoji", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(108448);
      return;
      localIntent.putExtra("custom_smiley_preview_appid", localEmojiInfo.field_app_id);
    }
  }
  
  static void cN(String paramString, int paramInt)
  {
    AppMethodBeat.i(108445);
    com.tencent.mm.g.a.r localr = new com.tencent.mm.g.a.r();
    localr.dbz.dbA = paramString;
    localr.dbz.status = paramInt;
    localr.dbz.dbB = 0;
    com.tencent.mm.sdk.b.a.ESL.l(localr);
    ad.d("MicroMsg.emoji.EmojiMgrImpl", "attachid:%s percentage:%d status:%d", new Object[] { paramString, Integer.valueOf(0), Integer.valueOf(paramInt) });
    AppMethodBeat.o(108445);
  }
  
  public final boolean J(ArrayList<SmileyInfo> paramArrayList)
  {
    AppMethodBeat.i(108472);
    boolean bool = k.getEmojiStorageMgr().Fzg.aL(paramArrayList);
    AppMethodBeat.o(108472);
    return bool;
  }
  
  public final boolean K(ArrayList<SmileyPanelConfigInfo> paramArrayList)
  {
    AppMethodBeat.i(108473);
    com.tencent.mm.storage.emotion.t localt = k.getEmojiStorageMgr().Fzh;
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      ad.i("MicroMsg.emoji.SmileyPanelConfigInfoStorage", "insertSmileyConfigInfoList failed. list is null.");
      AppMethodBeat.o(108473);
      return false;
    }
    com.tencent.mm.storagebase.h localh;
    long l;
    if ((localt.db instanceof com.tencent.mm.storagebase.h))
    {
      localh = (com.tencent.mm.storagebase.h)localt.db;
      l = localh.rb(Thread.currentThread().getId());
    }
    for (;;)
    {
      localt.db.delete("SmileyPanelConfigInfo", null, null);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localt.insert((SmileyPanelConfigInfo)paramArrayList.next());
      }
      int i = -1;
      if (localh != null) {
        i = localh.mX(l);
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
  
  public final EmojiInfo TA(String paramString)
  {
    AppMethodBeat.i(108441);
    paramString = Tz(paramString);
    AppMethodBeat.o(108441);
    return paramString;
  }
  
  public final String TB(String paramString)
  {
    AppMethodBeat.i(108453);
    paramString = EmojiLogic.TB(paramString);
    AppMethodBeat.o(108453);
    return paramString;
  }
  
  public final List<EmojiInfo> TC(String paramString)
  {
    AppMethodBeat.i(108456);
    if (com.tencent.mm.kernel.g.afB().isSDCardAvailable())
    {
      paramString = (ArrayList)k.getEmojiStorageMgr().FyY.TC(paramString);
      AppMethodBeat.o(108456);
      return paramString;
    }
    paramString = new ArrayList();
    AppMethodBeat.o(108456);
    return paramString;
  }
  
  public final String TD(String paramString)
  {
    AppMethodBeat.i(108458);
    paramString = k.getEmojiDescMgr().TD(paramString);
    AppMethodBeat.o(108458);
    return paramString;
  }
  
  public final boolean TE(String paramString)
  {
    AppMethodBeat.i(108459);
    if ((paramString != null) && (paramString.equals("capture")))
    {
      AppMethodBeat.o(108459);
      return true;
    }
    boolean bool = k.getEmojiStorageMgr().FyZ.aJp(paramString);
    AppMethodBeat.o(108459);
    return bool;
  }
  
  public final ArrayList<String> TF(String paramString)
  {
    AppMethodBeat.i(108460);
    as localas = k.getEmojiDescMgr();
    if (!localas.mInit) {
      localas.eLu();
    }
    long l = System.currentTimeMillis();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (com.tencent.mm.ui.tools.f.aLJ(paramString) > localas.Fyv)
    {
      ad.i("MicroMsg.emoji.EmojiDescNewMgr", "input text over checkout limit.");
      AppMethodBeat.o(108460);
      return null;
    }
    if ((!bt.isNullOrNil(paramString)) && (localas.Fyz != null))
    {
      Object localObject1 = paramString.toLowerCase();
      paramString = new ArrayList();
      if (localas.Fyy.containsKey(localObject1)) {
        paramString.addAll((Collection)localas.Fyx.get(localas.Fyy.get(localObject1)));
      }
      for (;;)
      {
        localObject1 = paramString.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (String)((Iterator)localObject1).next();
          localObject2 = (ArrayList)localas.Fyz.get(localObject2);
          if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty())) {
            localArrayList1.addAll((Collection)localObject2);
          }
        }
        paramString.add(localObject1);
      }
      ad.i("MicroMsg.emoji.EmojiDescNewMgr", "changeText: %s, %s", new Object[] { Integer.valueOf(paramString.size()), Integer.valueOf(localArrayList1.size()) });
    }
    if (!localArrayList1.isEmpty())
    {
      Collections.sort(localArrayList1, localas.FyA);
      int i = 0;
      while (i < localArrayList1.size())
      {
        localArrayList2.add(((as.a)localArrayList1.get(i)).md5);
        i += 1;
      }
    }
    ad.d("MicroMsg.emoji.EmojiDescNewMgr", "cpan[check desc]User time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(108460);
    return localArrayList2;
  }
  
  public final String TG(String paramString)
  {
    AppMethodBeat.i(108461);
    paramString = EmojiLogic.TG(paramString);
    AppMethodBeat.o(108461);
    return paramString;
  }
  
  public final String TH(String paramString)
  {
    AppMethodBeat.i(108462);
    paramString = EmojiLogic.TH(paramString);
    AppMethodBeat.o(108462);
    return paramString;
  }
  
  public final int TI(String paramString)
  {
    AppMethodBeat.i(108463);
    int i = EmojiLogic.TI(paramString);
    AppMethodBeat.o(108463);
    return i;
  }
  
  public final String TJ(String paramString)
  {
    AppMethodBeat.i(108464);
    paramString = EmojiLogic.TJ(paramString);
    AppMethodBeat.o(108464);
    return paramString;
  }
  
  public final void TK(String paramString)
  {
    AppMethodBeat.i(108476);
    if (bt.isNullOrNil(paramString)) {
      ad.i("MicroMsg.emoji.EmojiCommandMgr", "emoji command is null.");
    }
    Object localObject1;
    if ("sync".equalsIgnoreCase(paramString))
    {
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fgj, Boolean.TRUE);
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fgo, Boolean.TRUE);
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fgp, Boolean.TRUE);
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fgs, Long.valueOf(System.currentTimeMillis()));
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fgt, Long.valueOf(System.currentTimeMillis()));
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fgi, Long.valueOf(0L));
      com.tencent.mm.kernel.g.afA().gcy.a(new com.tencent.mm.plugin.emoji.f.e(0), 0);
      com.tencent.mm.kernel.g.afA().gcy.a(new com.tencent.mm.plugin.emoji.f.e(1), 0);
      localObject1 = new com.tencent.mm.plugin.emoji.f.n(8, null, 15, true);
      com.tencent.mm.kernel.g.afA().gcy.a((com.tencent.mm.al.n)localObject1, 0);
    }
    while (bu.eGT())
    {
      Object localObject3;
      Object localObject4;
      if ("new".equalsIgnoreCase(paramString))
      {
        com.tencent.mm.z.c.adr().w(262147, true);
        com.tencent.mm.kernel.g.afB().afk().set(208899, Boolean.TRUE);
        com.tencent.mm.kernel.g.afB().afk().set(229633, "http://mmbiz.qpic.cn/mmemoticon/Q3auHgzwzM5eOptD4jIj72I8icMVEKwzSYkC30IgjMvSibGfqsEdy0ibXayiaZtbibSXV5EPZEWILOvbrjjLtQ9P4QQ/0");
        com.tencent.mm.kernel.g.afB().afk().set(229634, System.currentTimeMillis());
        AppMethodBeat.o(108476);
        return;
        if ("rcheart".equalsIgnoreCase(paramString))
        {
          k.getEmojiStorageMgr().FyZ.eNu();
        }
        else if ("recover".equalsIgnoreCase(paramString))
        {
          ad.i("MicroMsg.emoji.EmojiCommandMgr", "recover   begin");
          k.getEmojiStorageMgr().FyY.init(aj.getContext());
          k.getEmojiStorageMgr().FyZ.init(aj.getContext());
          ad.i("MicroMsg.emoji.EmojiCommandMgr", "recover   end");
        }
        else
        {
          Object localObject2;
          if ("clean".equalsIgnoreCase(paramString))
          {
            ad.i("MicroMsg.emoji.EmojiCommandMgr", "begin clean");
            localObject1 = d.bUB();
            localObject2 = com.tencent.mm.emoji.d.a.fSR;
            ((d)localObject1).Ty(com.tencent.mm.emoji.d.a.acD());
            com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fgo, Boolean.TRUE);
            ad.i("MicroMsg.emoji.EmojiCommandMgr", "end clean");
          }
          else
          {
            if ("dump".equalsIgnoreCase(paramString))
            {
              ad.i("MicroMsg.emoji.EmojiCommandMgr", "begin dump emoji db info:");
              localObject1 = (ArrayList)k.getEmojiStorageMgr().FyZ.eNg();
              if (((ArrayList)localObject1).size() > 0)
              {
                int j = ((ArrayList)localObject1).size();
                int i = 0;
                while (i < j)
                {
                  ad.i("MicroMsg.emoji.EmojiCommandMgr", "i:%d group info:%s", new Object[] { Integer.valueOf(i), ((EmojiGroupInfo)((ArrayList)localObject1).get(i)).toString() });
                  i += 1;
                }
              }
              localObject2 = null;
              localObject1 = null;
              try
              {
                localObject3 = k.getEmojiStorageMgr().FyY.getAll();
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
                      ad.i("MicroMsg.emoji.EmojiCommandMgr", "emoji info:%s", new Object[] { ((EmojiInfo)localObject4).toString() });
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
              ad.i("MicroMsg.emoji.EmojiCommandMgr", "end dump emoji db info:");
              continue;
            }
            label702:
            if ("config".equalsIgnoreCase(paramString))
            {
              com.tencent.mm.pluginsdk.h.a.a.b.ewn().e(37, 1, -1, false);
              com.tencent.mm.pluginsdk.h.a.a.b.ewn().e(37, 2, -1, false);
              com.tencent.mm.pluginsdk.h.a.a.b.ewn().e(37, 4, -1, false);
              com.tencent.mm.kernel.g.afB().afk().set(ae.a.FgA, Integer.valueOf(0));
              com.tencent.mm.kernel.g.afB().afk().set(ae.a.FgB, Integer.valueOf(0));
              com.tencent.mm.kernel.g.afB().afk().set(ae.a.FgD, Integer.valueOf(0));
              localObject1 = new m(37);
              com.tencent.mm.kernel.g.afA().gcy.a((com.tencent.mm.al.n)localObject1, 0);
              com.tencent.mm.vfs.i.deleteFile(com.tencent.mm.cg.b.Fah);
            }
            else if ("tuzki".equalsIgnoreCase(paramString))
            {
              com.tencent.mm.plugin.emoji.f.a.bVg();
              com.tencent.mm.plugin.emoji.f.a.bVh();
            }
            else if (paramString.startsWith("reset-first"))
            {
              com.tencent.mm.kernel.g.afB().afk().set(ae.a.Ftz, Boolean.FALSE);
              com.tencent.mm.kernel.g.afB().afk().set(ae.a.FtA, Boolean.FALSE);
              com.tencent.mm.kernel.g.afB().afk().set(ae.a.FtB, Boolean.FALSE);
              com.tencent.mm.kernel.g.afB().afk().set(ae.a.FtC, Boolean.FALSE);
            }
            else if (paramString.startsWith("cleanThumb"))
            {
              localObject1 = com.tencent.mm.emoji.d.a.fSR;
              com.tencent.mm.emoji.d.a.acF();
              Toast.makeText(aj.getContext(), "clean thumb done", 0).show();
            }
          }
        }
      }
      else
      {
        if ("free".equalsIgnoreCase(paramString))
        {
          com.tencent.mm.z.c.adr().w(262149, true);
          com.tencent.mm.kernel.g.afB().afk().set(208913, Boolean.TRUE);
          com.tencent.mm.kernel.g.afB().afk().set(229633, "http://mmbiz.qpic.cn/mmemoticon/Q3auHgzwzM5eOptD4jIj72I8icMVEKwzSYkC30IgjMvSibGfqsEdy0ibXayiaZtbibSXV5EPZEWILOvbrjjLtQ9P4QQ/0");
          com.tencent.mm.kernel.g.afB().afk().set(229634, System.currentTimeMillis());
          AppMethodBeat.o(108476);
          return;
        }
        if ("newp".equalsIgnoreCase(paramString))
        {
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fgn, Boolean.TRUE);
          AppMethodBeat.o(108476);
          return;
        }
        if ("newpe".equalsIgnoreCase(paramString))
        {
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fgr, Boolean.TRUE);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("add"))
        {
          a.Tw(paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("backup"))
        {
          paramString = new com.tencent.mm.plugin.emoji.f.c(0, 1, Arrays.asList(paramString.replace("backup", "").trim().split(",")));
          com.tencent.mm.kernel.g.afA().gcy.a(paramString, 0);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("h5"))
        {
          paramString = paramString.replace("h5", "").trim();
          PreferenceManager.getDefaultSharedPreferences(aj.getContext()).edit().putString("h5", paramString).commit();
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("md5"))
        {
          localObject1 = paramString.replace("md5", "").trim();
          paramString = (String)localObject1;
          if (bt.isNullOrNil((String)localObject1)) {
            paramString = "/sdcard/test.png";
          }
          ad.i("MicroMsg.emoji.EmojiCommandMgr", com.tencent.mm.vfs.i.aEN(paramString));
          ad.i("MicroMsg.emoji.EmojiCommandMgr", ai.du(paramString));
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("recommend"))
        {
          paramString = com.tencent.mm.plugin.emoji.g.d.Ud("<NewRecommendEmotion><Emotion><ProductID>com.tencent.xin.emoticon.person.stiker_144984189945aa5830d33cd7dc</ProductID><RecType>3</RecType><Name>野萌君</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/duc2TvpEgSTWy4k8MnuicFjyiazriaGWDX52HzNWeLVTjtJcjZeZEicTn5kJFPYdicWZTuUZJgiaADK9I/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/DhduwiaBa7lchicgAfwibeykm81eGWXkMDgGJ8DWcOcIc28C7oTic4Y09Pick8Fw69KiaZVxrHl8S2lPY/0</Panel><ButtonType>1</ButtonType></Emotion><Emotion><ProductID>com.tencent.xin.emoticon.person.stiker_14389422638f6ca818af405e21</ProductID><RecType>3</RecType><Name>猪仔和羊妹</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/iaUiazNVkRp7iaZjrMuYgfH8kB5xkyYv20CYzY3W9HCLBr2XybJibGKKtXibMnAfZnRTH/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/PiajxSqBRaEJR9canNKZ7RYI3hx5BPCSwQmuhhlNWD1jzUSOx3CWqEtibd65zOjySd/0</Panel><ButtonType>1</ButtonType></Emotion><Emotion><ProductID>com.tencent.xin.emoticon.person.stiker_1444199720f5ea147582ff0512</ProductID><RecType>3</RecType><Name>让红包飞</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/nMl9ssowtibXLY57PdK8Nsh827vlsw4TGHPgLUehd2R455xnwe3xpoVDIKpAuXU1Aic3XbH1LfMr7fp4DgO7o8IQ/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/duc2TvpEgST18reErFRzNFR8EiahI4Iibp4ZnW1ibJYt4MMLvQvjx3sHGTMuTOgnREq5f2GXLhuzalOOz3icw9NGbA/0</Panel><ButtonType>1</ButtonType></Emotion><Emotion><ProductID>com.tencent.xin.emoticon.xiaobendan</ProductID><RecType>3</RecType><Name>小笨蛋与大坏蛋</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/ajNVdqHZLLC8ILTt0pqcaCVkldLMydoNJcupoR7qUojia3vKlgd74uQ/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/ajNVdqHZLLC8ILTt0pqcaAAEUI4a7z5ECqpUXbQw95PY1mpc4p0FxA/0</Panel><ButtonType>1</ButtonType></Emotion><Emotion><ProductID>com.tencent.xin.emoticon.shin2</ProductID><RecType>3</RecType><Name>野原新之助2</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/iciaySdkria4apGIW1wvSbPC9oxWQPHZyicaccx5JDIp2uE/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/ajNVdqHZLLASEAAX7xw76beia5j4HyA0rq9WgtgscicJo7935UCpCpog/0</Panel><ButtonType>1</ButtonType></Emotion></NewRecommendEmotion>");
          k.getEmojiStorageMgr().FyZ.eNm();
          k.getEmojiStorageMgr().FyZ.aI(paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("count"))
        {
          paramString = paramString.replace("count", "").trim();
          com.tencent.mm.m.g.Zd().put("CustomEmojiMaxSize", paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("auto"))
        {
          paramString = paramString.replace("auto", "").trim();
          com.tencent.mm.m.g.Zd().put("C2CEmojiNotAutoDownloadTimeRange", paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("bo"))
        {
          if (paramString.replace("bo", "").trim().equalsIgnoreCase("1"))
          {
            PreferenceManager.getDefaultSharedPreferences(aj.getContext()).edit().putBoolean("broken", true).commit();
            AppMethodBeat.o(108476);
            return;
          }
          PreferenceManager.getDefaultSharedPreferences(aj.getContext()).edit().putBoolean("broken", false).commit();
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
          k.getEmojiStorageMgr().Fzg.aL(paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("panel"))
        {
          paramString.replace("panel", "").trim();
          paramString = new bk();
          paramString.ddG.subType = 1;
          paramString.ddG.ddH = 37;
          paramString.ddG.filePath = (com.tencent.mm.loader.j.b.aih() + "CheckResUpdate/37.1.data");
          com.tencent.mm.sdk.b.a.ESL.l(paramString);
          paramString = new bk();
          paramString.ddG.subType = 2;
          paramString.ddG.ddH = 37;
          paramString.ddG.filePath = "/sdcard/tencent/MicroMsg/CheckResUpdate/37.2.data";
          com.tencent.mm.sdk.b.a.ESL.l(paramString);
          paramString = new bk();
          paramString.ddG.subType = 3;
          paramString.ddG.ddH = 37;
          paramString.ddG.filePath = (com.tencent.mm.loader.j.b.aih() + "CheckResUpdate/37.3.data");
          com.tencent.mm.sdk.b.a.ESL.l(paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("key"))
        {
          paramString = com.tencent.mm.b.g.getMessageDigest(String.valueOf(System.currentTimeMillis()).getBytes());
          ad.i("MicroMsg.emoji.EmojiCommandMgr", "create key :%s" + bt.aGs(paramString));
          k.getEmojiStorageMgr().FyY.WM(153);
          localObject1 = new EmojiInfo();
          ((EmojiInfo)localObject1).field_md5 = paramString;
          ((EmojiInfo)localObject1).field_catalog = 153;
          k.getEmojiStorageMgr().FyY.K((EmojiInfo)localObject1);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("delete"))
        {
          a.Tv(paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("delete-db"))
        {
          paramString = paramString.replace("delete-db", "").trim();
          k.getEmojiStorageMgr().FyY.cz(paramString, true);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("delete-file"))
        {
          a.Tu(paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("batchDownload"))
        {
          paramString = paramString.split(" ");
          if (paramString.length > 1)
          {
            paramString = new com.tencent.mm.plugin.emoji.f.e(bt.aGh(paramString[1]));
            com.tencent.mm.kernel.g.afA().gcy.a(paramString, 0);
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
            com.tencent.mm.kernel.g.afA().gcy.a(paramString, 0);
          }
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("test"))
        {
          ad.i("MicroMsg.emoji.EmojiCommandMgr", "theTest: %s", new Object[] { paramString });
          com.tencent.e.h.Iye.aP(new a.1());
        }
      }
    }
    AppMethodBeat.o(108476);
  }
  
  public final void TL(String paramString)
  {
    AppMethodBeat.i(176179);
    v localv = k.getEmojiStorageMgr().Fzj;
    LinkedList localLinkedList;
    int i;
    if (!bt.isNullOrNil(paramString))
    {
      localLinkedList = localv.tvP;
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < localv.tvP.size())
        {
          if (bt.kU(((u)localv.tvP.get(i)).key, paramString))
          {
            localu = (u)localv.tvP.get(i);
            if (localu == null)
            {
              localu = new u();
              localu.key = paramString;
              localu.FBZ += 1;
              localu.glk = System.currentTimeMillis();
              localv.tvP.add(0, localu);
              if (localv.tvP.size() > 9) {
                localv.tvP.remove(localv.tvP.size() - 1);
              }
              localv.doNotify("event_update_recent", 0, Integer.valueOf(localv.tvP.size()));
              AppMethodBeat.o(176179);
            }
          }
          else
          {
            i += 1;
            continue;
          }
          localv.tvP.remove(i);
          continue;
        }
        i = -1;
      }
      finally
      {
        AppMethodBeat.o(176179);
      }
      u localu = null;
    }
  }
  
  public final boolean TM(String paramString)
  {
    bool2 = false;
    AppMethodBeat.i(108499);
    com.tencent.mm.plugin.gif.f localf = new com.tencent.mm.plugin.gif.f(paramString);
    int i = (int)com.tencent.mm.vfs.i.aMN(paramString);
    if (i != 0) {
      bool1 = bool2;
    }
    try
    {
      if (i <= com.tencent.mm.m.b.YJ())
      {
        bool1 = bool2;
        if (localf.spr[0] <= com.tencent.mm.m.b.YI())
        {
          i = localf.spr[1];
          int j = com.tencent.mm.m.b.YI();
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
        ad.e("MicroMsg.emoji.EmojiMgrImpl", bt.m(paramString));
        bool1 = bool2;
        continue;
        bool1 = true;
      }
    }
    AppMethodBeat.o(108499);
    return bool1;
  }
  
  public final void TN(String paramString)
  {
    AppMethodBeat.i(108501);
    if (!bt.isNullOrNil(paramString))
    {
      ad.i("MicroMsg.emoji.EmojiMgrImpl", "deleteCaptureEmoji md: ".concat(String.valueOf(paramString)));
      k.getEmojiStorageMgr().FyY.cz(paramString, true);
      k.getEmojiStorageMgr().FyY.doNotify("delete_emoji_info_notify");
    }
    AppMethodBeat.o(108501);
  }
  
  public final void TO(String paramString)
  {
    AppMethodBeat.i(108503);
    EmojiInfo localEmojiInfo = Tz(paramString);
    if (localEmojiInfo != null)
    {
      paramString = com.tencent.mm.emoji.c.i.fSK;
      com.tencent.mm.emoji.c.i.o(localEmojiInfo);
      AppMethodBeat.o(108503);
      return;
    }
    ad.w("MicroMsg.emoji.EmojiMgrImpl", "addCaptureEmojiUploadTask: emojiInfo null by md5 %s", new Object[] { paramString });
    AppMethodBeat.o(108503);
  }
  
  public final EmojiInfo Tz(String paramString)
  {
    AppMethodBeat.i(108440);
    paramString = k.getEmojiStorageMgr().FyY.aJx(paramString);
    AppMethodBeat.o(108440);
    return paramString;
  }
  
  public final EmojiInfo a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    AppMethodBeat.i(108451);
    paramString1 = k.getEmojiStorageMgr().FyY.e(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3);
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
  
  public final void a(Context paramContext, bl parambl, String paramString)
  {
    AppMethodBeat.i(108444);
    if ((paramContext == null) || (parambl == null))
    {
      ad.w("MicroMsg.emoji.EmojiMgrImpl", "context or msg is null");
      AppMethodBeat.o(108444);
      return;
    }
    ar localar = ar.aIF(parambl.field_content);
    Object localObject2 = k.b.rx(parambl.field_content);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new k.b();
      ((k.b)localObject1).gHg = localar.md5;
    }
    localObject2 = k.getEmojiStorageMgr().FyY.aJx(((k.b)localObject1).gHg);
    if ((localObject2 != null) && (((EmojiInfo)localObject2).fZM()))
    {
      if (parambl.field_isSend == 1)
      {
        a(paramContext, ((k.b)localObject1).gHg, ((k.b)localObject1).appId, ((k.b)localObject1).appName, parambl.field_msgSvrId, parambl.field_talker, parambl.field_content, paramString);
        AppMethodBeat.o(108444);
        return;
      }
      a(paramContext, ((EmojiInfo)localObject2).JS(), ((k.b)localObject1).appId, ((k.b)localObject1).appName, parambl.field_msgSvrId, parambl.field_talker, parambl.field_content, paramString);
      AppMethodBeat.o(108444);
      return;
    }
    paramContext = k.getEmojiStorageMgr().FyY.aJx(((k.b)localObject1).gHg);
    if (paramContext == null)
    {
      parambl = ((k.b)localObject1).gHg;
      if (bt.isNullOrNil(parambl))
      {
        ad.e("MicroMsg.emoji.EmojiMgrImpl", "md5 is null.");
        AppMethodBeat.o(108444);
        return;
      }
      paramContext = new EmojiInfo();
      paramContext.field_md5 = parambl;
      paramContext.field_app_id = ((k.b)localObject1).appId;
      paramContext.field_catalog = EmojiInfo.LBQ;
      paramContext.field_size = ((k.b)localObject1).gHe;
      paramContext.field_temp = 1;
      paramContext.field_state = EmojiInfo.LCg;
      k.getEmojiStorageMgr().FyY.K(paramContext);
    }
    for (;;)
    {
      cN(paramContext.field_md5, 0);
      ad.d("MicroMsg.emoji.EmojiMgrImpl", "start change cdn url. md5:%s", new Object[] { paramContext.field_md5 });
      parambl = paramContext.field_md5;
      paramString = com.tencent.mm.emoji.loader.e.fLn;
      com.tencent.mm.emoji.loader.e.a(paramContext, true, new i.a()
      {
        public final void df(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(108439);
          if (paramAnonymousBoolean)
          {
            f.cN(this.kzy, 1);
            AppMethodBeat.o(108439);
            return;
          }
          f.cN(this.kzy, 2);
          AppMethodBeat.o(108439);
        }
      });
      AppMethodBeat.o(108444);
      return;
    }
  }
  
  public final void a(String paramString, EmojiInfo paramEmojiInfo, bl parambl)
  {
    AppMethodBeat.i(108447);
    if ((paramEmojiInfo == null) && (parambl == null))
    {
      AppMethodBeat.o(108447);
      return;
    }
    EmojiInfo localEmojiInfo = paramEmojiInfo;
    if (paramEmojiInfo == null) {
      localEmojiInfo = k.getEmojiStorageMgr().FyY.aJx(parambl.field_imgPath);
    }
    k.bUY().a(paramString, localEmojiInfo, parambl);
    AppMethodBeat.o(108447);
  }
  
  public final boolean a(Context paramContext, EmojiInfo paramEmojiInfo, int paramInt, String paramString)
  {
    AppMethodBeat.i(108443);
    if (paramContext == null)
    {
      ad.e("MicroMsg.emoji.EmojiMgrImpl", "[cpan] save emoji failed. context is null");
      AppMethodBeat.o(108443);
      return false;
    }
    if (paramEmojiInfo == null)
    {
      ad.e("MicroMsg.emoji.EmojiMgrImpl", "[cpan] save emoji failed. emoji is null");
      AppMethodBeat.o(108443);
      return false;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, EmojiAddCustomDialogUI.class);
    localIntent.putExtra("extra_id", paramEmojiInfo.JS());
    localIntent.putExtra("extra_scence", paramInt);
    localIntent.putExtra("extra_move_to_top", true);
    localIntent.putExtra("extra_username", paramString);
    localIntent.putExtra("extra_current", false);
    localIntent.putExtra("key_is_selfie", false);
    localIntent.putExtra("key_attached_text", null);
    localIntent.putExtra("key_attached_emoji_md5", null);
    localIntent.putExtra("key_imitate_md5", null);
    localIntent.addFlags(65536);
    paramEmojiInfo = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramEmojiInfo.adn(), "com/tencent/mm/plugin/emoji/mgr/EmojiMgrImpl", "saveCustomEmoji", "(Landroid/content/Context;Lcom/tencent/mm/storage/emotion/EmojiInfo;ILjava/lang/String;IZZZLjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramEmojiInfo.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/emoji/mgr/EmojiMgrImpl", "saveCustomEmoji", "(Landroid/content/Context;Lcom/tencent/mm/storage/emotion/EmojiInfo;ILjava/lang/String;IZZZLjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(108443);
    return true;
  }
  
  public final boolean a(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(108468);
    paramBoolean = com.tencent.mm.emoji.decode.a.aaP().a(paramEmojiInfo, paramBoolean);
    AppMethodBeat.o(108468);
    return paramBoolean;
  }
  
  public final boolean a(String paramString1, String paramString2, long paramLong, String paramString3, f.a parama)
  {
    boolean bool = false;
    AppMethodBeat.i(108455);
    com.tencent.mm.plugin.emoji.model.c localc = k.bUY();
    ad.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml ".concat(String.valueOf(paramString2)));
    paramString1 = av.a(bw.K(paramString2, "msg"), paramString1, paramString2, paramString3);
    if (paramString1 == null)
    {
      ad.i("MicroMsg.emoji.EmojiService", "prepareEmoji failed. emoji msg info is null.");
      AppMethodBeat.o(108455);
      return true;
    }
    paramString1.drA = paramLong;
    ad.i("MicroMsg.emoji.EmojiService", "summerbadcr prepareEmoji msgSvrId[%d], stack[%s]", new Object[] { Long.valueOf(paramLong), bt.eGN() });
    localc.TZ(paramString1.dft);
    if (!EmojiLogic.TY(l.abv())) {
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
      EmojiInfo localEmojiInfo = Tz(paramEmojiInfo.field_md5);
      if ((localEmojiInfo != null) && (localEmojiInfo.field_reserved4 != paramEmojiInfo.field_reserved4)) {
        paramEmojiInfo.field_reserved4 = localEmojiInfo.field_reserved4;
      }
    }
    paramEmojiInfo = com.tencent.mm.emoji.decode.a.aaP().a(paramEmojiInfo);
    AppMethodBeat.o(108466);
    return paramEmojiInfo;
  }
  
  public final boolean abA()
  {
    AppMethodBeat.i(108493);
    if ((bu.eGT()) || (l.abA()))
    {
      AppMethodBeat.o(108493);
      return true;
    }
    AppMethodBeat.o(108493);
    return false;
  }
  
  public final boolean abz()
  {
    AppMethodBeat.i(108492);
    boolean bool = l.abz();
    AppMethodBeat.o(108492);
    return bool;
  }
  
  public final boolean bUD()
  {
    AppMethodBeat.i(108469);
    boolean bool = l.abs();
    AppMethodBeat.o(108469);
    return bool;
  }
  
  public final ArrayList<SmileyInfo> bUE()
  {
    AppMethodBeat.i(108470);
    ArrayList localArrayList = k.getEmojiStorageMgr().Fzg.bUE();
    AppMethodBeat.o(108470);
    return localArrayList;
  }
  
  public final ArrayList<SmileyPanelConfigInfo> bUF()
  {
    AppMethodBeat.i(108471);
    ArrayList localArrayList = k.getEmojiStorageMgr().Fzh.bUF();
    AppMethodBeat.o(108471);
    return localArrayList;
  }
  
  public final com.tencent.mm.bc.f bUG()
  {
    AppMethodBeat.i(108475);
    com.tencent.mm.bc.f localf = h.bUO().bUG();
    AppMethodBeat.o(108475);
    return localf;
  }
  
  public final boolean bUH()
  {
    AppMethodBeat.i(108477);
    if ((bu.eGT()) || (l.abB()))
    {
      AppMethodBeat.o(108477);
      return true;
    }
    AppMethodBeat.o(108477);
    return false;
  }
  
  public final String bUI()
  {
    AppMethodBeat.i(108478);
    h.bUO();
    String str = h.bUI();
    AppMethodBeat.o(108478);
    return str;
  }
  
  public final void bUJ()
  {
    AppMethodBeat.i(108479);
    h.bUO();
    bk localbk = new bk();
    localbk.ddG.filePath = (com.tencent.mm.loader.j.b.aih() + "CheckResUpdate/37.1.data.decompressed");
    localbk.ddG.ddH = 37;
    localbk.ddG.subType = 1;
    h.a(localbk, h.a.owa, h.ovA);
    AppMethodBeat.o(108479);
  }
  
  public final boolean bUK()
  {
    AppMethodBeat.i(108491);
    boolean bool = l.aby();
    AppMethodBeat.o(108491);
    return bool;
  }
  
  public final List<u> bUL()
  {
    AppMethodBeat.i(108495);
    List localList = k.getEmojiStorageMgr().Fzj.bUL();
    AppMethodBeat.o(108495);
    return localList;
  }
  
  public final void bUM()
  {
    AppMethodBeat.i(108496);
    Object localObject = k.getEmojiStorageMgr().Fzj.bUL();
    JSONArray localJSONArray = new JSONArray();
    localObject = ((List)localObject).iterator();
    do
    {
      u localu;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localu = (u)((Iterator)localObject).next();
      } while (localu.toJson() == null);
      localJSONArray.put(localu.toJson());
    } while (localJSONArray.length() < 9);
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.Ftw, localJSONArray.toString());
    AppMethodBeat.o(108496);
  }
  
  public final boolean bUN()
  {
    AppMethodBeat.i(108500);
    if (!com.tencent.mm.kernel.g.afB().afk().getBoolean(ae.a.FtC, true)) {}
    for (int i = 1;; i = 0)
    {
      l.isSpringFestivalEnable();
      if (i == 0) {
        break;
      }
      AppMethodBeat.o(108500);
      return true;
    }
    AppMethodBeat.o(108500);
    return false;
  }
  
  public final <T> T c(ae.a parama, T paramT)
  {
    AppMethodBeat.i(108497);
    parama = com.tencent.mm.kernel.g.afB().afk().get(parama, paramT);
    AppMethodBeat.o(108497);
    return parama;
  }
  
  public final int d(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(108480);
    if ((paramBoolean) || ((paramEmojiInfo != null) && (paramEmojiInfo.field_activityid != null) && (paramEmojiInfo.field_activityid.startsWith("Selfie:")))) {}
    for (int i = 1; i != 0; i = 0)
    {
      i = com.tencent.mm.m.b.YJ();
      AppMethodBeat.o(108480);
      return i;
    }
    i = com.tencent.mm.m.b.YH();
    AppMethodBeat.o(108480);
    return i;
  }
  
  public final void d(ae.a parama, Object paramObject)
  {
    AppMethodBeat.i(108498);
    com.tencent.mm.kernel.g.afB().afk().set(parama, paramObject);
    AppMethodBeat.o(108498);
  }
  
  public final av fa(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108449);
    Map localMap = bw.K(paramString1, "msg");
    if (localMap == null)
    {
      ad.w("MicroMsg.emoji.EmojiMgrImpl", "get from xml, but attrs is null");
      AppMethodBeat.o(108449);
      return null;
    }
    paramString2 = av.e(localMap, paramString2, paramString1);
    if (paramString2 == null)
    {
      ad.w("MicroMsg.emoji.EmojiMgrImpl", "parserEmojiXml error ".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(108449);
      return null;
    }
    AppMethodBeat.o(108449);
    return paramString2;
  }
  
  public final String fb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108474);
    com.tencent.mm.emoji.d.a locala = com.tencent.mm.emoji.d.a.fSR;
    paramString1 = EmojiLogic.P(com.tencent.mm.emoji.d.a.acD(), paramString1, paramString2);
    AppMethodBeat.o(108474);
    return paramString1;
  }
  
  public final String getAccPath()
  {
    AppMethodBeat.i(108457);
    String str = com.tencent.mm.kernel.g.afB().gcW;
    AppMethodBeat.o(108457);
    return str;
  }
  
  public final String getDataEmojiPath()
  {
    AppMethodBeat.i(190101);
    String str = h.getDataEmojiPath();
    AppMethodBeat.o(190101);
    return str;
  }
  
  public final void h(k.a parama)
  {
    AppMethodBeat.i(108487);
    k.getEmojiStorageMgr().FyY.remove(parama);
    AppMethodBeat.o(108487);
  }
  
  public final void i(k.a parama)
  {
    AppMethodBeat.i(108488);
    k.getEmojiStorageMgr().FyY.add(parama);
    AppMethodBeat.o(108488);
  }
  
  public final void j(k.a parama)
  {
    AppMethodBeat.i(108489);
    k.getEmojiStorageMgr().FyZ.remove(parama);
    AppMethodBeat.o(108489);
  }
  
  public final void k(k.a parama)
  {
    AppMethodBeat.i(108490);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.afy().aeZ()).agu()) {
      k.getEmojiStorageMgr().FyZ.add(parama);
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
    if (paramEmojiInfo.field_catalog == EmojiGroupInfo.LBO)
    {
      localObject = paramEmojiInfo;
      if (paramEmojiInfo.getContent().length() > 0)
      {
        localObject = paramEmojiInfo;
        if (EmojiInfo.ail(bt.getInt(paramEmojiInfo.getContent(), 0)))
        {
          Cursor localCursor = k.getEmojiStorageMgr().FyY.WL(bt.getInt(paramEmojiInfo.getContent(), 0));
          EmojiInfo localEmojiInfo = paramEmojiInfo;
          if (localCursor != null)
          {
            localEmojiInfo = paramEmojiInfo;
            if (localCursor.getCount() > 1)
            {
              int i = bt.iX(localCursor.getCount() - 1, 0);
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
      if ((paramEmojiInfo.field_catalog == EmojiInfo.LBU) || (String.valueOf(EmojiInfo.LBU).equals(paramEmojiInfo.field_groupId)))
      {
        AppMethodBeat.o(108465);
        return 2131232753;
      }
      if ((paramEmojiInfo.field_catalog == EmojiInfo.LBV) || (String.valueOf(EmojiInfo.LBV).equals(paramEmojiInfo.field_groupId)))
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
      if (paramEmojiInfo.field_catalog == EmojiInfo.LBU) {
        return new int[] { 2131232755, 2131232756, 2131232754 };
      }
      if (paramEmojiInfo.field_catalog == EmojiInfo.LBV) {
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
      localObject = Tz(paramEmojiInfo.field_md5);
      if ((localObject != null) && (((EmojiInfo)localObject).field_reserved4 != paramEmojiInfo.field_reserved4)) {
        paramEmojiInfo.field_reserved4 = ((EmojiInfo)localObject).field_reserved4;
      }
    }
    paramEmojiInfo = com.tencent.mm.emoji.decode.a.aaP().a(paramEmojiInfo);
    if (com.tencent.mm.sdk.platformtools.t.cp(paramEmojiInfo))
    {
      localObject = MMWXGFJNI.nativeWxamToGif(paramEmojiInfo);
      if (bt.cw((byte[])localObject)) {
        ad.w("MicroMsg.emoji.EmojiMgrImpl", "decodeAsGif: wxam to gif error");
      }
      for (;;)
      {
        AppMethodBeat.o(108467);
        return localObject;
        ad.i("MicroMsg.emoji.EmojiMgrImpl", "decodeAsGif: %s, %s", new Object[] { Integer.valueOf(paramEmojiInfo.length), Integer.valueOf(localObject.length) });
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
    ((List)localObject).add(paramEmojiInfo.JS());
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().FyY.m(1, (List)localObject);
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().FyY.L(paramEmojiInfo);
    paramEmojiInfo = new dg();
    paramEmojiInfo.dfp.type = 2;
    com.tencent.mm.sdk.b.a.ESL.l(paramEmojiInfo);
    if (!paramEmojiInfo.dfq.dfr)
    {
      paramEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().Fzb.eNR();
      if (paramEmojiInfo != null)
      {
        localObject = paramEmojiInfo.ElD.iterator();
        while (((Iterator)localObject).hasNext())
        {
          ctw localctw = (ctw)((Iterator)localObject).next();
          if (localctw.ProductID.equals(String.valueOf("capture"))) {
            localctw.CEo = 0;
          }
        }
      }
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().Fzb.a(paramEmojiInfo);
      com.tencent.mm.cc.a.eCL();
      paramEmojiInfo = com.tencent.mm.cc.a.EMi;
      a.b.aEG(String.valueOf("capture"));
    }
    AppMethodBeat.o(108502);
  }
  
  public final void updateEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108452);
    k.getEmojiStorageMgr().FyY.L(paramEmojiInfo);
    AppMethodBeat.o(108452);
  }
  
  public final boolean v(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(108446);
    if (paramContext == null)
    {
      ad.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: context is null");
      AppMethodBeat.o(108446);
      return false;
    }
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      ad.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: userName or imgPath is null");
      AppMethodBeat.o(108446);
      return false;
    }
    EmojiInfo localEmojiInfo = k.getEmojiStorageMgr().FyY.aJx(paramString2);
    if (localEmojiInfo == null)
    {
      ad.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: emoji not found, imgPath %s", new Object[] { paramString2 });
      AppMethodBeat.o(108446);
      return false;
    }
    if ((localEmojiInfo.field_type == EmojiInfo.LCa) || (localEmojiInfo.field_type == EmojiInfo.LCb))
    {
      paramContext = new WXMediaMessage();
      paramString2 = localEmojiInfo.gaa();
      if (com.tencent.mm.vfs.i.eK(localEmojiInfo.gab())) {
        paramContext.thumbData = com.tencent.mm.vfs.i.aR(localEmojiInfo.gab(), 0, -1);
      }
      for (;;)
      {
        paramContext.mediaObject = new WXEmojiObject(paramString2);
        paramString2 = new ry();
        paramString2.dxx.doG = paramContext;
        paramString2.dxx.appId = localEmojiInfo.field_app_id;
        paramString2.dxx.appName = null;
        paramString2.dxx.toUser = paramString1;
        paramString2.dxx.dxy = 0;
        paramString2.dxx.dxB = localEmojiInfo.JS();
        com.tencent.mm.sdk.b.a.ESL.l(paramString2);
        AppMethodBeat.o(108446);
        return true;
        paramContext.setThumbImage(localEmojiInfo.fZO());
      }
    }
    paramString2 = localEmojiInfo;
    if (localEmojiInfo.field_type == EmojiInfo.LBX)
    {
      if (!EmojiInfo.ail(localEmojiInfo.field_catalog)) {
        break label363;
      }
      paramContext = k.getEmojiStorageMgr().FyY.WL(localEmojiInfo.field_catalog);
    }
    for (;;)
    {
      paramString2 = localEmojiInfo;
      if (paramContext != null)
      {
        int i = bt.iX(paramContext.getCount() - 1, 0);
        paramString2 = new EmojiInfo();
        paramContext.moveToPosition(i);
        paramString2.convertFrom(paramContext);
        paramContext.close();
      }
      k.bUY().a(paramString1, paramString2, null);
      break;
      label363:
      if ((localEmojiInfo.field_catalog == EmojiInfo.LBS) && (localEmojiInfo.getContent().length() > 0) && (EmojiInfo.ail(bt.getInt(localEmojiInfo.getContent(), 0)))) {
        paramContext = k.getEmojiStorageMgr().FyY.WL(bt.getInt(localEmojiInfo.getContent(), 0));
      } else {
        paramContext = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.f
 * JD-Core Version:    0.7.0.1
 */