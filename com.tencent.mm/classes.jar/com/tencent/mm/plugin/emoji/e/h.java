package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.preference.PreferenceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ca.a.b;
import com.tencent.mm.g.a.bg;
import com.tencent.mm.g.a.da;
import com.tencent.mm.g.a.da.b;
import com.tencent.mm.g.a.qg;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.bf;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.f.n;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI;
import com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureUploadManager.UploadTask;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.pluginsdk.g.a.a.b.c;
import com.tencent.mm.protocal.protobuf.cda;
import com.tencent.mm.protocal.protobuf.cdb;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.aq.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.storage.emotion.s;
import com.tencent.mm.storage.z;
import com.tencent.recovery.util.Util;
import java.io.File;
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

public final class h
  implements com.tencent.mm.pluginsdk.a.d
{
  private static void a(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(52895);
    if (paramString1.equals("-1"))
    {
      ab.e("MicroMsg.emoji.EmojiMgrImpl", "showEmoji fail cause md5 is no valid");
      AppMethodBeat.o(52895);
      return;
    }
    EmojiInfo localEmojiInfo = i.getEmojiStorageMgr().yNn.asP(paramString1);
    if (localEmojiInfo == null)
    {
      ab.e("MicroMsg.emoji.EmojiMgrImpl", "showEmoji fail cause md5 is no valid");
      AppMethodBeat.o(52895);
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
      if (com.tencent.mm.model.t.lA(paramString4))
      {
        paramString1 = bf.pu(paramString5);
        localIntent.putExtra("room_id", paramString6);
      }
      localIntent.putExtra("msg_sender", paramString1);
      paramContext.startActivity(localIntent);
      AppMethodBeat.o(52895);
      return;
      localIntent.putExtra("custom_smiley_preview_appid", localEmojiInfo.field_app_id);
    }
  }
  
  static void ca(String paramString, int paramInt)
  {
    AppMethodBeat.i(139676);
    com.tencent.mm.g.a.q localq = new com.tencent.mm.g.a.q();
    localq.cmM.cmN = paramString;
    localq.cmM.status = paramInt;
    localq.cmM.cmO = 0;
    com.tencent.mm.sdk.b.a.ymk.l(localq);
    ab.d("MicroMsg.emoji.EmojiMgrImpl", "attachid:%s percentage:%d status:%d", new Object[] { paramString, Integer.valueOf(0), Integer.valueOf(paramInt) });
    AppMethodBeat.o(139676);
  }
  
  public final String KA(String paramString)
  {
    AppMethodBeat.i(52908);
    paramString = EmojiLogic.KA(paramString);
    AppMethodBeat.o(52908);
    return paramString;
  }
  
  public final String KB(String paramString)
  {
    AppMethodBeat.i(52909);
    paramString = EmojiLogic.KB(paramString);
    AppMethodBeat.o(52909);
    return paramString;
  }
  
  public final int KC(String paramString)
  {
    AppMethodBeat.i(52910);
    int i = EmojiLogic.KC(paramString);
    AppMethodBeat.o(52910);
    return i;
  }
  
  public final String KD(String paramString)
  {
    AppMethodBeat.i(52911);
    paramString = EmojiLogic.KD(paramString);
    AppMethodBeat.o(52911);
    return paramString;
  }
  
  public final void KE(String paramString)
  {
    AppMethodBeat.i(52922);
    if (bo.isNullOrNil(paramString)) {
      ab.i("MicroMsg.emoji.EmojiCommandMgr", "emoji command is null.");
    }
    Object localObject1;
    if ("sync".equalsIgnoreCase(paramString))
    {
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yxP, Boolean.TRUE);
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yxU, Boolean.TRUE);
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yxV, Boolean.TRUE);
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yxY, Long.valueOf(System.currentTimeMillis()));
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yxZ, Long.valueOf(System.currentTimeMillis()));
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yxO, Long.valueOf(0L));
      com.tencent.mm.kernel.g.RK().eHt.a(new com.tencent.mm.plugin.emoji.f.e(0), 0);
      com.tencent.mm.kernel.g.RK().eHt.a(new com.tencent.mm.plugin.emoji.f.e(1), 0);
      localObject1 = new n(8, null, 15, true);
      com.tencent.mm.kernel.g.RK().eHt.a((com.tencent.mm.ai.m)localObject1, 0);
    }
    while (bp.dud())
    {
      Object localObject4;
      Object localObject5;
      label680:
      Object localObject3;
      if ("new".equalsIgnoreCase(paramString))
      {
        com.tencent.mm.x.c.PJ().x(262147, true);
        com.tencent.mm.kernel.g.RL().Ru().set(208899, Boolean.TRUE);
        com.tencent.mm.kernel.g.RL().Ru().set(229633, "http://mmbiz.qpic.cn/mmemoticon/Q3auHgzwzM5eOptD4jIj72I8icMVEKwzSYkC30IgjMvSibGfqsEdy0ibXayiaZtbibSXV5EPZEWILOvbrjjLtQ9P4QQ/0");
        com.tencent.mm.kernel.g.RL().Ru().set(229634, System.currentTimeMillis());
        AppMethodBeat.o(52922);
        return;
        if ("rcheart".equalsIgnoreCase(paramString))
        {
          i.getEmojiStorageMgr().yNo.dzi();
        }
        else if ("recover".equalsIgnoreCase(paramString))
        {
          ab.i("MicroMsg.emoji.EmojiCommandMgr", "recover   begin");
          i.getEmojiStorageMgr().yNn.init(ah.getContext());
          i.getEmojiStorageMgr().yNo.init(ah.getContext());
          ab.i("MicroMsg.emoji.EmojiCommandMgr", "recover   end");
        }
        else if ("clean".equalsIgnoreCase(paramString))
        {
          ab.i("MicroMsg.emoji.EmojiCommandMgr", "begin clean");
          e.bkP().Ks(com.tencent.mm.plugin.emoji.h.b.YP());
          com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yxU, Boolean.TRUE);
          ab.i("MicroMsg.emoji.EmojiCommandMgr", "end clean");
        }
        else
        {
          if ("dump".equalsIgnoreCase(paramString))
          {
            ab.i("MicroMsg.emoji.EmojiCommandMgr", "begin dump emoji db info:");
            localObject1 = (ArrayList)i.getEmojiStorageMgr().yNo.dyU();
            if (((ArrayList)localObject1).size() > 0)
            {
              int j = ((ArrayList)localObject1).size();
              int i = 0;
              while (i < j)
              {
                ab.i("MicroMsg.emoji.EmojiCommandMgr", "i:%d group info:%s", new Object[] { Integer.valueOf(i), ((EmojiGroupInfo)((ArrayList)localObject1).get(i)).toString() });
                i += 1;
              }
            }
            Object localObject2 = null;
            localObject1 = null;
            try
            {
              localObject4 = i.getEmojiStorageMgr().yNn.getAll();
              if (localObject4 != null)
              {
                localObject1 = localObject4;
                localObject2 = localObject4;
                if (((Cursor)localObject4).moveToFirst())
                {
                  boolean bool;
                  do
                  {
                    localObject1 = localObject4;
                    localObject2 = localObject4;
                    localObject5 = new EmojiInfo();
                    localObject1 = localObject4;
                    localObject2 = localObject4;
                    ((EmojiInfo)localObject5).convertFrom((Cursor)localObject4);
                    localObject1 = localObject4;
                    localObject2 = localObject4;
                    ab.i("MicroMsg.emoji.EmojiCommandMgr", "emoji info:%s", new Object[] { ((EmojiInfo)localObject5).toString() });
                    localObject1 = localObject4;
                    localObject2 = localObject4;
                    bool = ((Cursor)localObject4).moveToNext();
                  } while (bool);
                }
              }
              if (localObject4 != null) {
                ((Cursor)localObject4).close();
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
                break label680;
              }
              localException.close();
              AppMethodBeat.o(52922);
            }
            ab.i("MicroMsg.emoji.EmojiCommandMgr", "end dump emoji db info:");
            continue;
          }
          if ("config".equalsIgnoreCase(paramString))
          {
            b.c.dmg().e(37, 1, -1, false);
            b.c.dmg().e(37, 2, -1, false);
            b.c.dmg().e(37, 4, -1, false);
            com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yyg, Integer.valueOf(0));
            com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yyh, Integer.valueOf(0));
            com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yyj, Integer.valueOf(0));
            localObject1 = new com.tencent.mm.pluginsdk.g.a.a.m(37);
            com.tencent.mm.kernel.g.RK().eHt.a((com.tencent.mm.ai.m)localObject1, 0);
            localObject1 = new bg();
            ((bg)localObject1).coI.filePath = (com.tencent.mm.compatible.util.e.eQz + "CheckResUpdate/37.1.data.decompressed");
            ((bg)localObject1).coI.coJ = 37;
            ((bg)localObject1).coI.subType = 1;
            localObject3 = new bg();
            ((bg)localObject3).coI.filePath = (com.tencent.mm.compatible.util.e.eQz + "CheckResUpdate/37.2.data.decompressed");
            ((bg)localObject3).coI.coJ = 37;
            ((bg)localObject3).coI.subType = 2;
            j.bli();
            j.a((bg)localObject1, true);
            j.bli();
            j.b((bg)localObject3, true);
            com.tencent.mm.vfs.e.deleteFile(com.tencent.mm.cd.b.yug);
          }
          else if ("tuzki".equalsIgnoreCase(paramString))
          {
            com.tencent.mm.plugin.emoji.f.a.blw();
            com.tencent.mm.plugin.emoji.f.a.blx();
          }
          else if (paramString.startsWith("reset-first"))
          {
            com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yKo, Boolean.FALSE);
            com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yKp, Boolean.FALSE);
            com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yKq, Boolean.FALSE);
            com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yKr, Boolean.FALSE);
          }
        }
      }
      else
      {
        if ("free".equalsIgnoreCase(paramString))
        {
          com.tencent.mm.x.c.PJ().x(262149, true);
          com.tencent.mm.kernel.g.RL().Ru().set(208913, Boolean.TRUE);
          com.tencent.mm.kernel.g.RL().Ru().set(229633, "http://mmbiz.qpic.cn/mmemoticon/Q3auHgzwzM5eOptD4jIj72I8icMVEKwzSYkC30IgjMvSibGfqsEdy0ibXayiaZtbibSXV5EPZEWILOvbrjjLtQ9P4QQ/0");
          com.tencent.mm.kernel.g.RL().Ru().set(229634, System.currentTimeMillis());
          AppMethodBeat.o(52922);
          return;
        }
        if ("newp".equalsIgnoreCase(paramString))
        {
          com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yxT, Boolean.TRUE);
          AppMethodBeat.o(52922);
          return;
        }
        if ("newpe".equalsIgnoreCase(paramString))
        {
          com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yxX, Boolean.TRUE);
          AppMethodBeat.o(52922);
          return;
        }
        if (paramString.startsWith("add"))
        {
          b.Kq(paramString);
          AppMethodBeat.o(52922);
          return;
        }
        if (paramString.startsWith("backup"))
        {
          paramString = new com.tencent.mm.plugin.emoji.f.c(0, 1, Arrays.asList(paramString.replace("backup", "").trim().split(",")));
          com.tencent.mm.kernel.g.RK().eHt.a(paramString, 0);
          AppMethodBeat.o(52922);
          return;
        }
        if (paramString.startsWith("h5"))
        {
          paramString = paramString.replace("h5", "").trim();
          PreferenceManager.getDefaultSharedPreferences(ah.getContext()).edit().putString("h5", paramString).commit();
          AppMethodBeat.o(52922);
          return;
        }
        if (paramString.startsWith("md5"))
        {
          localObject1 = paramString.replace("md5", "").trim();
          paramString = (String)localObject1;
          if (bo.isNullOrNil((String)localObject1)) {
            paramString = "/sdcard/test.png";
          }
          ab.i("MicroMsg.emoji.EmojiCommandMgr", com.tencent.mm.a.g.r(new File(paramString)));
          ab.i("MicroMsg.emoji.EmojiCommandMgr", ag.cE(paramString));
          AppMethodBeat.o(52922);
          return;
        }
        if (paramString.startsWith("recommend"))
        {
          paramString = com.tencent.mm.plugin.emoji.g.d.KW("<NewRecommendEmotion><Emotion><ProductID>com.tencent.xin.emoticon.person.stiker_144984189945aa5830d33cd7dc</ProductID><RecType>3</RecType><Name>野萌君</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/duc2TvpEgSTWy4k8MnuicFjyiazriaGWDX52HzNWeLVTjtJcjZeZEicTn5kJFPYdicWZTuUZJgiaADK9I/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/DhduwiaBa7lchicgAfwibeykm81eGWXkMDgGJ8DWcOcIc28C7oTic4Y09Pick8Fw69KiaZVxrHl8S2lPY/0</Panel><ButtonType>1</ButtonType></Emotion><Emotion><ProductID>com.tencent.xin.emoticon.person.stiker_14389422638f6ca818af405e21</ProductID><RecType>3</RecType><Name>猪仔和羊妹</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/iaUiazNVkRp7iaZjrMuYgfH8kB5xkyYv20CYzY3W9HCLBr2XybJibGKKtXibMnAfZnRTH/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/PiajxSqBRaEJR9canNKZ7RYI3hx5BPCSwQmuhhlNWD1jzUSOx3CWqEtibd65zOjySd/0</Panel><ButtonType>1</ButtonType></Emotion><Emotion><ProductID>com.tencent.xin.emoticon.person.stiker_1444199720f5ea147582ff0512</ProductID><RecType>3</RecType><Name>让红包飞</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/nMl9ssowtibXLY57PdK8Nsh827vlsw4TGHPgLUehd2R455xnwe3xpoVDIKpAuXU1Aic3XbH1LfMr7fp4DgO7o8IQ/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/duc2TvpEgST18reErFRzNFR8EiahI4Iibp4ZnW1ibJYt4MMLvQvjx3sHGTMuTOgnREq5f2GXLhuzalOOz3icw9NGbA/0</Panel><ButtonType>1</ButtonType></Emotion><Emotion><ProductID>com.tencent.xin.emoticon.xiaobendan</ProductID><RecType>3</RecType><Name>小笨蛋与大坏蛋</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/ajNVdqHZLLC8ILTt0pqcaCVkldLMydoNJcupoR7qUojia3vKlgd74uQ/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/ajNVdqHZLLC8ILTt0pqcaAAEUI4a7z5ECqpUXbQw95PY1mpc4p0FxA/0</Panel><ButtonType>1</ButtonType></Emotion><Emotion><ProductID>com.tencent.xin.emoticon.shin2</ProductID><RecType>3</RecType><Name>野原新之助2</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/iciaySdkria4apGIW1wvSbPC9oxWQPHZyicaccx5JDIp2uE/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/ajNVdqHZLLASEAAX7xw76beia5j4HyA0rq9WgtgscicJo7935UCpCpog/0</Panel><ButtonType>1</ButtonType></Emotion></NewRecommendEmotion>");
          i.getEmojiStorageMgr().yNo.dza();
          i.getEmojiStorageMgr().yNo.al(paramString);
          AppMethodBeat.o(52922);
          return;
        }
        if (paramString.startsWith("count"))
        {
          paramString = paramString.replace("count", "").trim();
          com.tencent.mm.m.g.Nq().put("CustomEmojiMaxSize", paramString);
          AppMethodBeat.o(52922);
          return;
        }
        if (paramString.startsWith("auto"))
        {
          paramString = paramString.replace("auto", "").trim();
          com.tencent.mm.m.g.Nq().put("C2CEmojiNotAutoDownloadTimeRange", paramString);
          AppMethodBeat.o(52922);
          return;
        }
        if (paramString.startsWith("bo"))
        {
          if (paramString.replace("bo", "").trim().equalsIgnoreCase("1"))
          {
            PreferenceManager.getDefaultSharedPreferences(ah.getContext()).edit().putBoolean("broken", true).commit();
            AppMethodBeat.o(52922);
            return;
          }
          PreferenceManager.getDefaultSharedPreferences(ah.getContext()).edit().putBoolean("broken", false).commit();
          AppMethodBeat.o(52922);
          return;
        }
        if (paramString.startsWith("newsmiley"))
        {
          paramString = new ArrayList();
          localObject1 = new SmileyInfo("/::AAA", "[机智]", "[机智]", "[机智]", "[机智]", "[机智]", "emoji2.png", 1000);
          localObject3 = new SmileyInfo("/::BBB", "[滑稽]", "[滑稽]", "[滑稽]", "[滑稽]", "[滑稽]", "emoji3.png", 1001);
          localObject4 = new SmileyInfo("[Pose]", "[摆姿势]", "[摆姿势]", "[摆姿势]", "[摆姿势]", "[摆姿势]", "emoji4.png", 1002);
          localObject5 = new SmileyInfo("/::DDD", "[瞪]", "[瞪]", "[瞪]", "[瞪]", "[瞪]", "emoji5.png", 1003);
          SmileyInfo localSmileyInfo1 = new SmileyInfo("/::FFF", "[捂脸]", "[捂脸]", "[捂脸]", "[捂脸]", "[捂脸]", "emoji6.png", 1004);
          SmileyInfo localSmileyInfo2 = new SmileyInfo("/::Doge", "[Doge]", "[Doge]", "[Doge]", "[Doge]", "[Doge]", "emoji7.png", 1005);
          paramString.add(localObject1);
          paramString.add(localObject3);
          paramString.add(localObject4);
          paramString.add(localObject5);
          paramString.add(localSmileyInfo1);
          paramString.add(localSmileyInfo2);
          i.getEmojiStorageMgr().yNv.ao(paramString);
          AppMethodBeat.o(52922);
          return;
        }
        if (paramString.startsWith("panel"))
        {
          paramString.replace("panel", "").trim();
          paramString = new bg();
          paramString.coI.subType = 1;
          paramString.coI.coJ = 37;
          paramString.coI.filePath = (com.tencent.mm.compatible.util.e.eQz + "CheckResUpdate/37.1.data");
          com.tencent.mm.sdk.b.a.ymk.l(paramString);
          paramString = new bg();
          paramString.coI.subType = 2;
          paramString.coI.coJ = 37;
          paramString.coI.filePath = "/sdcard/tencent/MicroMsg/CheckResUpdate/37.2.data";
          com.tencent.mm.sdk.b.a.ymk.l(paramString);
          paramString = new bg();
          paramString.coI.subType = 3;
          paramString.coI.coJ = 37;
          paramString.coI.filePath = (com.tencent.mm.compatible.util.e.eQz + "CheckResUpdate/37.3.data");
          com.tencent.mm.sdk.b.a.ymk.l(paramString);
          AppMethodBeat.o(52922);
          return;
        }
        if (paramString.startsWith("key"))
        {
          paramString = com.tencent.mm.a.g.w(String.valueOf(System.currentTimeMillis()).getBytes());
          ab.i("MicroMsg.emoji.EmojiCommandMgr", "create key :%s" + bo.aqg(paramString));
          i.getEmojiStorageMgr().yNn.NI(153);
          localObject1 = new EmojiInfo();
          ((EmojiInfo)localObject1).field_md5 = paramString;
          ((EmojiInfo)localObject1).field_catalog = 153;
          i.getEmojiStorageMgr().yNn.I((EmojiInfo)localObject1);
          AppMethodBeat.o(52922);
          return;
        }
        if (paramString.startsWith("delete"))
        {
          b.Kp(paramString);
          AppMethodBeat.o(52922);
          return;
        }
        if (paramString.startsWith("delete-db"))
        {
          paramString = paramString.replace("delete-db", "").trim();
          i.getEmojiStorageMgr().yNn.asQ(paramString);
          AppMethodBeat.o(52922);
          return;
        }
        if (paramString.startsWith("delete-file"))
        {
          b.Ko(paramString);
          AppMethodBeat.o(52922);
          return;
        }
        if (paramString.startsWith("batchDownload"))
        {
          paramString = paramString.split(" ");
          if (paramString.length > 1)
          {
            paramString = new com.tencent.mm.plugin.emoji.f.e(bo.apV(paramString[1]));
            com.tencent.mm.kernel.g.RK().eHt.a(paramString, 0);
          }
          AppMethodBeat.o(52922);
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
            com.tencent.mm.kernel.g.RK().eHt.a(paramString, 0);
          }
          AppMethodBeat.o(52922);
          return;
        }
        if (paramString.startsWith("test"))
        {
          ab.i("MicroMsg.emoji.EmojiCommandMgr", "theTest: %s", new Object[] { paramString });
          com.tencent.mm.sdk.g.d.ysm.execute(new b.1());
        }
      }
    }
    AppMethodBeat.o(52922);
  }
  
  public final int KF(String paramString)
  {
    AppMethodBeat.i(52930);
    int i = i.getEmojiStorageMgr().yNn.KF(paramString);
    AppMethodBeat.o(52930);
    return i;
  }
  
  public final boolean KG(String paramString)
  {
    bool2 = false;
    AppMethodBeat.i(52951);
    com.tencent.mm.plugin.gif.f localf = new com.tencent.mm.plugin.gif.f(paramString);
    int i = com.tencent.mm.a.e.cM(paramString);
    if (i != 0) {
      bool1 = bool2;
    }
    try
    {
      if (i <= com.tencent.mm.m.b.MW())
      {
        bool1 = bool2;
        if (localf.nFh[0] <= com.tencent.mm.m.b.MV())
        {
          i = localf.nFh[1];
          int j = com.tencent.mm.m.b.MV();
          if (i <= j) {
            break label103;
          }
          bool1 = bool2;
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.emoji.EmojiMgrImpl", bo.l(paramString));
        bool1 = bool2;
        continue;
        bool1 = true;
      }
    }
    AppMethodBeat.o(52951);
    return bool1;
  }
  
  public final void KH(String paramString)
  {
    AppMethodBeat.i(52954);
    if (!bo.isNullOrNil(paramString))
    {
      ab.i("MicroMsg.emoji.EmojiMgrImpl", "deleteCaptureEmoji md: ".concat(String.valueOf(paramString)));
      i.getEmojiStorageMgr().yNn.asQ(paramString);
      i.getEmojiStorageMgr().yNn.doNotify("delete_emoji_info_notify");
    }
    AppMethodBeat.o(52954);
  }
  
  public final EmojiInfo Kt(String paramString)
  {
    AppMethodBeat.i(52888);
    paramString = i.getEmojiStorageMgr().yNn.asP(paramString);
    AppMethodBeat.o(52888);
    return paramString;
  }
  
  public final EmojiInfo Ku(String paramString)
  {
    AppMethodBeat.i(52889);
    paramString = Kt(paramString);
    AppMethodBeat.o(52889);
    return paramString;
  }
  
  public final String Kv(String paramString)
  {
    AppMethodBeat.i(52900);
    paramString = EmojiLogic.Kv(paramString);
    AppMethodBeat.o(52900);
    return paramString;
  }
  
  public final List<EmojiInfo> Kw(String paramString)
  {
    AppMethodBeat.i(52903);
    if (com.tencent.mm.kernel.g.RL().isSDCardAvailable())
    {
      paramString = (ArrayList)i.getEmojiStorageMgr().yNn.Kw(paramString);
      AppMethodBeat.o(52903);
      return paramString;
    }
    paramString = new ArrayList();
    AppMethodBeat.o(52903);
    return paramString;
  }
  
  public final String Kx(String paramString)
  {
    AppMethodBeat.i(52905);
    paramString = i.getEmojiDescMgr().Kx(paramString);
    AppMethodBeat.o(52905);
    return paramString;
  }
  
  public final boolean Ky(String paramString)
  {
    AppMethodBeat.i(52906);
    if ((paramString != null) && (paramString.equals("capture")))
    {
      AppMethodBeat.o(52906);
      return true;
    }
    boolean bool = i.getEmojiStorageMgr().yNo.asJ(paramString);
    AppMethodBeat.o(52906);
    return bool;
  }
  
  public final ArrayList<String> Kz(String paramString)
  {
    AppMethodBeat.i(52907);
    aq localaq = i.getEmojiDescMgr();
    if (!localaq.mInit) {
      localaq.dxs();
    }
    long l = System.currentTimeMillis();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = com.tencent.mm.ui.tools.f.auQ(paramString);
    if ((i < localaq.yMN) || (i > localaq.yMO))
    {
      ab.d("MicroMsg.emoji.EmojiDescNewMgr", "input text over checkout limit.");
      AppMethodBeat.o(52907);
      return null;
    }
    if ((!bo.isNullOrNil(paramString)) && (localaq.yMS != null))
    {
      paramString = paramString.toLowerCase();
      Object localObject = new ArrayList();
      if (localaq.yMR.containsKey(paramString)) {
        ((ArrayList)localObject).addAll((Collection)localaq.yMQ.get(localaq.yMR.get(paramString)));
      }
      for (;;)
      {
        paramString = ((ArrayList)localObject).iterator();
        while (paramString.hasNext())
        {
          localObject = (String)paramString.next();
          localObject = (ArrayList)localaq.yMS.get(localObject);
          if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
            localArrayList1.addAll((Collection)localObject);
          }
        }
        ((ArrayList)localObject).add(paramString);
      }
    }
    if (!localArrayList1.isEmpty())
    {
      Collections.sort(localArrayList1, localaq.yMT);
      i = 0;
      while (i < localArrayList1.size())
      {
        localArrayList2.add(((aq.a)localArrayList1.get(i)).cqq);
        i += 1;
      }
    }
    ab.d("MicroMsg.emoji.EmojiDescNewMgr", "cpan[check desc]User time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(52907);
    return localArrayList2;
  }
  
  public final ArrayList<EmojiInfo> OA()
  {
    AppMethodBeat.i(52935);
    ArrayList localArrayList = i.getEmojiStorageMgr().yNz.OA();
    AppMethodBeat.o(52935);
    return localArrayList;
  }
  
  public final ArrayList<EmojiGroupInfo> OB()
  {
    AppMethodBeat.i(52932);
    ArrayList localArrayList = i.getEmojiStorageMgr().yNz.OB();
    AppMethodBeat.o(52932);
    return localArrayList;
  }
  
  public final boolean OQ()
  {
    AppMethodBeat.i(52943);
    boolean bool = com.tencent.mm.emoji.a.h.OQ();
    AppMethodBeat.o(52943);
    return bool;
  }
  
  public final boolean OR()
  {
    AppMethodBeat.i(52944);
    if ((bp.dud()) || (com.tencent.mm.emoji.a.h.OR()))
    {
      AppMethodBeat.o(52944);
      return true;
    }
    AppMethodBeat.o(52944);
    return false;
  }
  
  public final EmojiInfo a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    AppMethodBeat.i(52898);
    paramString1 = i.getEmojiStorageMgr().yNn.e(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3);
    AppMethodBeat.o(52898);
    return paramString1;
  }
  
  public final String a(Context paramContext, WXMediaMessage paramWXMediaMessage, String paramString)
  {
    AppMethodBeat.i(52901);
    paramContext = EmojiLogic.b(paramContext, paramWXMediaMessage, paramString);
    AppMethodBeat.o(52901);
    return paramContext;
  }
  
  public final void a(Context paramContext, bi parambi, String paramString)
  {
    AppMethodBeat.i(52892);
    if ((paramContext == null) || (parambi == null))
    {
      ab.w("MicroMsg.emoji.EmojiMgrImpl", "context or msg is null");
      AppMethodBeat.o(52892);
      return;
    }
    ap localap = ap.arZ(parambi.field_content);
    Object localObject2 = j.b.mY(parambi.field_content);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new j.b();
      ((j.b)localObject1).fgy = localap.cqq;
    }
    localObject2 = i.getEmojiStorageMgr().yNn.asP(((j.b)localObject1).fgy);
    if ((localObject2 != null) && (((EmojiInfo)localObject2).dzn()))
    {
      if (parambi.field_isSend == 1)
      {
        a(paramContext, ((j.b)localObject1).fgy, ((j.b)localObject1).appId, ((j.b)localObject1).appName, parambi.field_msgSvrId, parambi.field_talker, parambi.field_content, paramString);
        AppMethodBeat.o(52892);
        return;
      }
      a(paramContext, ((EmojiInfo)localObject2).Al(), ((j.b)localObject1).appId, ((j.b)localObject1).appName, parambi.field_msgSvrId, parambi.field_talker, parambi.field_content, paramString);
      AppMethodBeat.o(52892);
      return;
    }
    paramContext = i.getEmojiStorageMgr().yNn.asP(((j.b)localObject1).fgy);
    if (paramContext == null)
    {
      parambi = ((j.b)localObject1).fgy;
      if (bo.isNullOrNil(parambi))
      {
        ab.e("MicroMsg.emoji.EmojiMgrImpl", "md5 is null.");
        AppMethodBeat.o(52892);
        return;
      }
      paramContext = new EmojiInfo();
      paramContext.field_md5 = parambi;
      paramContext.field_app_id = ((j.b)localObject1).appId;
      paramContext.field_catalog = EmojiInfo.yPg;
      paramContext.field_size = ((j.b)localObject1).fgw;
      paramContext.field_temp = 1;
      paramContext.field_state = EmojiInfo.yPw;
      i.getEmojiStorageMgr().yNn.I(paramContext);
    }
    for (;;)
    {
      ca(paramContext.field_md5, 0);
      ab.d("MicroMsg.emoji.EmojiMgrImpl", "start change cdn url. md5:%s", new Object[] { paramContext.field_md5 });
      parambi = paramContext.field_md5;
      paramString = com.tencent.mm.emoji.loader.a.evk;
      com.tencent.mm.emoji.loader.a.a(paramContext, true, new h.1(parambi));
      AppMethodBeat.o(52892);
      return;
    }
  }
  
  public final void a(EmojiCaptureUploadManager.UploadTask paramUploadTask)
  {
    AppMethodBeat.i(52955);
    if (paramUploadTask.lsX == null)
    {
      AppMethodBeat.o(52955);
      return;
    }
    EmojiInfo localEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().yNn.asP(paramUploadTask.lsX);
    if (localEmojiInfo == null)
    {
      AppMethodBeat.o(52955);
      return;
    }
    paramUploadTask = paramUploadTask.lsY;
    ab.d("MicroMsg.emoji.EmojiMgrImpl", "uploadCaptureEmoji emojiInfo.field_md5: " + localEmojiInfo.field_md5);
    paramUploadTask.lsN = System.currentTimeMillis();
    paramUploadTask.eyh = localEmojiInfo.field_captureEnterTime;
    new com.tencent.mm.emoji.a.g(localEmojiInfo, localEmojiInfo.dzB(), localEmojiInfo.field_imitateMd5, new h.2(this, localEmojiInfo, paramUploadTask));
    AppMethodBeat.o(52955);
  }
  
  public final void a(cda paramcda)
  {
    AppMethodBeat.i(52928);
    i.getEmojiStorageMgr().yNq.b(paramcda);
    AppMethodBeat.o(52928);
  }
  
  public final void a(String paramString, EmojiInfo paramEmojiInfo, bi parambi)
  {
    AppMethodBeat.i(52894);
    if ((paramEmojiInfo == null) && (parambi == null))
    {
      AppMethodBeat.o(52894);
      return;
    }
    EmojiInfo localEmojiInfo = paramEmojiInfo;
    if (paramEmojiInfo == null) {
      localEmojiInfo = i.getEmojiStorageMgr().yNn.asP(parambi.field_imgPath);
    }
    i.blo().a(paramString, localEmojiInfo, parambi);
    AppMethodBeat.o(52894);
  }
  
  public final boolean a(Context paramContext, EmojiInfo paramEmojiInfo, int paramInt, String paramString)
  {
    AppMethodBeat.i(52891);
    if (paramContext == null)
    {
      ab.e("MicroMsg.emoji.EmojiMgrImpl", "[cpan] save emoji failed. context is null");
      AppMethodBeat.o(52891);
      return false;
    }
    if (paramEmojiInfo == null)
    {
      ab.e("MicroMsg.emoji.EmojiMgrImpl", "[cpan] save emoji failed. emoji is null");
      AppMethodBeat.o(52891);
      return false;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, EmojiAddCustomDialogUI.class);
    localIntent.putExtra("extra_id", paramEmojiInfo.Al());
    localIntent.putExtra("extra_scence", paramInt);
    localIntent.putExtra("extra_move_to_top", true);
    localIntent.putExtra("extra_username", paramString);
    localIntent.putExtra("extra_current", false);
    localIntent.putExtra("key_is_selfie", false);
    localIntent.putExtra("key_attached_text", null);
    localIntent.putExtra("key_attached_emoji_md5", null);
    localIntent.putExtra("key_imitate_md5", null);
    localIntent.addFlags(65536);
    paramContext.startActivity(localIntent);
    AppMethodBeat.o(52891);
    return true;
  }
  
  public final boolean a(EmojiGroupInfo paramEmojiGroupInfo)
  {
    AppMethodBeat.i(52931);
    boolean bool = i.getEmojiStorageMgr().yNo.update(paramEmojiGroupInfo, new String[] { "productID" });
    AppMethodBeat.o(52931);
    return bool;
  }
  
  public final boolean a(String paramString1, String paramString2, long paramLong, String paramString3, e.a parama)
  {
    boolean bool = false;
    AppMethodBeat.i(52902);
    com.tencent.mm.plugin.emoji.model.c localc = i.blo();
    ab.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml ".concat(String.valueOf(paramString2)));
    paramString1 = as.a(br.F(paramString2, "msg"), paramString1, paramString2, paramString3);
    if (paramString1 == null)
    {
      ab.i("MicroMsg.emoji.EmojiService", "prepareEmoji failed. emoji msg info is null.");
      AppMethodBeat.o(52902);
      return true;
    }
    paramString1.cFn = paramLong;
    ab.i("MicroMsg.emoji.EmojiService", "summerbadcr prepareEmoji msgSvrId[%d], stack[%s]", new Object[] { Long.valueOf(paramLong), bo.dtY() });
    localc.KS(paramString1.cqx);
    if (!EmojiLogic.KR(com.tencent.mm.emoji.a.h.OM())) {
      bool = true;
    }
    localc.a(paramString1, parama, bool);
    AppMethodBeat.o(52902);
    return true;
  }
  
  public final void b(EmojiCaptureUploadManager.UploadTask paramUploadTask)
  {
    AppMethodBeat.i(52958);
    EmojiInfo localEmojiInfo = Kt(paramUploadTask.lsX);
    if (localEmojiInfo != null)
    {
      paramUploadTask = com.tencent.mm.emoji.d.d.eyp;
      com.tencent.mm.emoji.d.d.k(localEmojiInfo);
      AppMethodBeat.o(52958);
      return;
    }
    ab.w("MicroMsg.emoji.EmojiMgrImpl", "addCaptureEmojiUploadTask: emojiInfo null by md5 %s", new Object[] { paramUploadTask.lsX });
    AppMethodBeat.o(52958);
  }
  
  public final boolean bkT()
  {
    AppMethodBeat.i(52915);
    boolean bool = com.tencent.mm.emoji.a.h.OJ();
    AppMethodBeat.o(52915);
    return bool;
  }
  
  public final ArrayList<SmileyInfo> bkU()
  {
    AppMethodBeat.i(52916);
    ArrayList localArrayList = i.getEmojiStorageMgr().yNv.bkU();
    AppMethodBeat.o(52916);
    return localArrayList;
  }
  
  public final ArrayList<SmileyPanelConfigInfo> bkV()
  {
    AppMethodBeat.i(52917);
    ArrayList localArrayList = i.getEmojiStorageMgr().yNw.bkV();
    AppMethodBeat.o(52917);
    return localArrayList;
  }
  
  public final com.tencent.mm.ba.f bkW()
  {
    AppMethodBeat.i(52921);
    com.tencent.mm.ba.f localf = j.bli().bkW();
    AppMethodBeat.o(52921);
    return localf;
  }
  
  public final boolean bkX()
  {
    AppMethodBeat.i(52923);
    if ((bp.dud()) || (com.tencent.mm.emoji.a.h.OS()))
    {
      AppMethodBeat.o(52923);
      return true;
    }
    AppMethodBeat.o(52923);
    return false;
  }
  
  public final String bkY()
  {
    AppMethodBeat.i(52924);
    j.bli();
    String str = j.bkY();
    AppMethodBeat.o(52924);
    return str;
  }
  
  public final void bkZ()
  {
    AppMethodBeat.i(52925);
    j.bli();
    bg localbg = new bg();
    localbg.coI.filePath = (com.tencent.mm.compatible.util.e.eQz + "CheckResUpdate/37.1.data.decompressed");
    localbg.coI.coJ = 37;
    localbg.coI.subType = 1;
    j.a(localbg, j.a.lgv, j.lfY);
    AppMethodBeat.o(52925);
  }
  
  public final cda blb()
  {
    AppMethodBeat.i(52927);
    cda localcda = i.getEmojiStorageMgr().yNq.blb();
    AppMethodBeat.o(52927);
    return localcda;
  }
  
  public final int blc()
  {
    AppMethodBeat.i(52933);
    int i = i.getEmojiStorageMgr().blc();
    AppMethodBeat.o(52933);
    return i;
  }
  
  public final com.tencent.mm.at.a.a bld()
  {
    AppMethodBeat.i(52937);
    com.tencent.mm.at.a.a locala = i.bld();
    AppMethodBeat.o(52937);
    return locala;
  }
  
  public final boolean ble()
  {
    AppMethodBeat.i(52942);
    boolean bool = com.tencent.mm.emoji.a.h.OP();
    AppMethodBeat.o(52942);
    return bool;
  }
  
  public final List<s> blf()
  {
    AppMethodBeat.i(52946);
    List localList = i.getEmojiStorageMgr().yNy.blf();
    AppMethodBeat.o(52946);
    return localList;
  }
  
  public final void blg()
  {
    AppMethodBeat.i(52947);
    com.tencent.mm.storage.emotion.t localt = i.getEmojiStorageMgr().yNy;
    Object localObject = localt.blf();
    JSONArray localJSONArray = new JSONArray();
    localObject = ((List)localObject).iterator();
    do
    {
      s locals;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        locals = (s)((Iterator)localObject).next();
      } while (locals.toJson() == null);
      localJSONArray.put(locals.toJson());
    } while (localJSONArray.length() < 9);
    com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yKl, localJSONArray.toString());
    localt.yQg = null;
    AppMethodBeat.o(52947);
  }
  
  public final boolean blh()
  {
    AppMethodBeat.i(52952);
    if (!com.tencent.mm.kernel.g.RL().Ru().getBoolean(ac.a.yKr, true)) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.emoji.a.h.isSpringFestivalEnable();
      if (i == 0) {
        break;
      }
      AppMethodBeat.o(52952);
      return true;
    }
    AppMethodBeat.o(52952);
    return false;
  }
  
  public final <T> T c(ac.a parama, T paramT)
  {
    AppMethodBeat.i(52948);
    parama = com.tencent.mm.kernel.g.RL().Ru().get(parama, paramT);
    AppMethodBeat.o(52948);
    return parama;
  }
  
  public final boolean c(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(52914);
    paramBoolean = f.bkQ().c(paramEmojiInfo, paramBoolean);
    AppMethodBeat.o(52914);
    return paramBoolean;
  }
  
  public final void cb(String paramString, int paramInt)
  {
    AppMethodBeat.i(52945);
    com.tencent.mm.storage.emotion.t localt = i.getEmojiStorageMgr().yNy;
    if (!Util.isNullOrNil(paramString))
    {
      if (localt.yQg == null) {
        localt.dzG();
      }
      s locals2 = (s)localt.yQg.get(paramString);
      s locals1 = locals2;
      if (locals2 == null)
      {
        locals1 = new s();
        locals1.key = paramString;
        localt.yQg.put(paramString, locals1);
      }
      locals1.position = paramInt;
      locals1.yQf += 1;
      locals1.ePF = System.currentTimeMillis();
      if (localt.yQg == null) {
        localt.dzG();
      }
      localt.doNotify("event_update_recent", 0, Integer.valueOf(localt.yQg.size()));
    }
    AppMethodBeat.o(52945);
  }
  
  public final ArrayList<EmojiInfo> ch(boolean paramBoolean)
  {
    AppMethodBeat.i(52934);
    ArrayList localArrayList = i.getEmojiStorageMgr().ch(paramBoolean);
    AppMethodBeat.o(52934);
    return localArrayList;
  }
  
  public final void d(ac.a parama, Object paramObject)
  {
    AppMethodBeat.i(52949);
    com.tencent.mm.kernel.g.RL().Ru().set(parama, paramObject);
    AppMethodBeat.o(52949);
  }
  
  public final as dN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52896);
    Map localMap = br.F(paramString1, "msg");
    if (localMap == null)
    {
      ab.w("MicroMsg.emoji.EmojiMgrImpl", "get from xml, but attrs is null");
      AppMethodBeat.o(52896);
      return null;
    }
    paramString2 = as.a(localMap, paramString2, paramString1, "");
    if (paramString2 == null)
    {
      ab.w("MicroMsg.emoji.EmojiMgrImpl", "parserEmojiXml error ".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(52896);
      return null;
    }
    AppMethodBeat.o(52896);
    return paramString2;
  }
  
  public final String dO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52920);
    paramString1 = EmojiLogic.M(com.tencent.mm.plugin.emoji.h.b.YP(), paramString1, paramString2);
    AppMethodBeat.o(52920);
    return paramString1;
  }
  
  public final int e(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(52926);
    if ((paramBoolean) || ((paramEmojiInfo != null) && (paramEmojiInfo.field_activityid != null) && (paramEmojiInfo.field_activityid.startsWith("Selfie:")))) {}
    for (int i = 1; i != 0; i = 0)
    {
      i = com.tencent.mm.m.b.MW();
      AppMethodBeat.o(52926);
      return i;
    }
    i = com.tencent.mm.m.b.MU();
    AppMethodBeat.o(52926);
    return i;
  }
  
  public final void e(k.a parama)
  {
    AppMethodBeat.i(52938);
    i.getEmojiStorageMgr().yNn.remove(parama);
    AppMethodBeat.o(52938);
  }
  
  public final void f(k.a parama)
  {
    AppMethodBeat.i(52939);
    i.getEmojiStorageMgr().yNn.add(parama);
    AppMethodBeat.o(52939);
  }
  
  public final void g(k.a parama)
  {
    AppMethodBeat.i(52940);
    i.getEmojiStorageMgr().yNo.remove(parama);
    AppMethodBeat.o(52940);
  }
  
  public final String getAccPath()
  {
    AppMethodBeat.i(52904);
    String str = com.tencent.mm.kernel.g.RL().eHR;
    AppMethodBeat.o(52904);
    return str;
  }
  
  public final void h(k.a parama)
  {
    AppMethodBeat.i(52941);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.RI().Rj()).SD()) {
      i.getEmojiStorageMgr().yNo.add(parama);
    }
    AppMethodBeat.o(52941);
  }
  
  public final void i(k.a parama)
  {
    AppMethodBeat.i(52950);
    i.getEmojiStorageMgr().yNy.add(parama);
    AppMethodBeat.o(52950);
  }
  
  public final EmojiInfo j(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(52897);
    paramString = a(paramString, "", paramInt1, paramInt2, paramInt3, "");
    AppMethodBeat.o(52897);
    return paramString;
  }
  
  public final void j(k.a parama)
  {
    AppMethodBeat.i(52953);
    i.getEmojiStorageMgr().yNy.remove(parama);
    AppMethodBeat.o(52953);
  }
  
  public final byte[] l(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(52913);
    if (paramEmojiInfo != null)
    {
      EmojiInfo localEmojiInfo = Kt(paramEmojiInfo.field_md5);
      if ((localEmojiInfo != null) && (localEmojiInfo.field_reserved4 != paramEmojiInfo.field_reserved4)) {
        paramEmojiInfo.field_reserved4 = localEmojiInfo.field_reserved4;
      }
    }
    paramEmojiInfo = f.bkQ().l(paramEmojiInfo);
    AppMethodBeat.o(52913);
    return paramEmojiInfo;
  }
  
  public final ArrayList<EmojiInfo> lL(String paramString)
  {
    AppMethodBeat.i(52936);
    paramString = i.getEmojiStorageMgr().yNz.lL(paramString);
    AppMethodBeat.o(52936);
    return paramString;
  }
  
  public final EmojiInfo n(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(52890);
    Object localObject = paramEmojiInfo;
    if (paramEmojiInfo.field_catalog == EmojiGroupInfo.yPe)
    {
      localObject = paramEmojiInfo;
      if (paramEmojiInfo.field_type == EmojiInfo.yPn)
      {
        localObject = paramEmojiInfo;
        if (paramEmojiInfo.getContent().length() > 0)
        {
          localObject = paramEmojiInfo;
          if (EmojiInfo.NB(bo.getInt(paramEmojiInfo.getContent(), 0)))
          {
            Cursor localCursor = i.getEmojiStorageMgr().yNn.NH(bo.getInt(paramEmojiInfo.getContent(), 0));
            EmojiInfo localEmojiInfo = paramEmojiInfo;
            if (localCursor != null)
            {
              localEmojiInfo = paramEmojiInfo;
              if (localCursor.getCount() > 1)
              {
                int i = bo.hk(localCursor.getCount() - 1, 0);
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
    }
    AppMethodBeat.o(52890);
    return localObject;
  }
  
  public final int o(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(52912);
    if (paramEmojiInfo != null)
    {
      if ((paramEmojiInfo.field_catalog == EmojiInfo.yPk) || (String.valueOf(EmojiInfo.yPk).equals(paramEmojiInfo.field_groupId)))
      {
        AppMethodBeat.o(52912);
        return 2130839190;
      }
      if ((paramEmojiInfo.field_catalog == EmojiInfo.yPl) || (String.valueOf(EmojiInfo.yPl).equals(paramEmojiInfo.field_groupId)))
      {
        AppMethodBeat.o(52912);
        return 2130838545;
      }
    }
    AppMethodBeat.o(52912);
    return 0;
  }
  
  public final void onDestroy() {}
  
  public final int[] p(EmojiInfo paramEmojiInfo)
  {
    if (paramEmojiInfo != null)
    {
      if (paramEmojiInfo.field_catalog == EmojiInfo.yPk) {
        return new int[] { 2130839192, 2130839193, 2130839191 };
      }
      if (paramEmojiInfo.field_catalog == EmojiInfo.yPl) {
        return new int[] { 2130838552, 2130838553, 2130838554, 2130838555 };
      }
    }
    return null;
  }
  
  public final byte[] q(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(155847);
    Object localObject;
    if (paramEmojiInfo != null)
    {
      localObject = Kt(paramEmojiInfo.field_md5);
      if ((localObject != null) && (((EmojiInfo)localObject).field_reserved4 != paramEmojiInfo.field_reserved4)) {
        paramEmojiInfo.field_reserved4 = ((EmojiInfo)localObject).field_reserved4;
      }
    }
    paramEmojiInfo = f.bkQ().l(paramEmojiInfo);
    if (com.tencent.mm.sdk.platformtools.r.bX(paramEmojiInfo))
    {
      localObject = MMWXGFJNI.nativeWxamToGif(paramEmojiInfo);
      if (bo.ce((byte[])localObject)) {
        ab.w("MicroMsg.emoji.EmojiMgrImpl", "decodeAsGif: wxam to gif error");
      }
      for (;;)
      {
        AppMethodBeat.o(155847);
        return localObject;
        ab.i("MicroMsg.emoji.EmojiMgrImpl", "decodeAsGif: %s, %s", new Object[] { Integer.valueOf(paramEmojiInfo.length), Integer.valueOf(localObject.length) });
      }
    }
    AppMethodBeat.o(155847);
    return paramEmojiInfo;
  }
  
  public final void r(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(52956);
    paramEmojiInfo.field_groupId = "capture";
    Object localObject = new ArrayList();
    ((List)localObject).add(paramEmojiInfo.Al());
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().yNn.l(1, (List)localObject);
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().yNn.J(paramEmojiInfo);
    paramEmojiInfo = new da();
    paramEmojiInfo.cqt.type = 2;
    com.tencent.mm.sdk.b.a.ymk.l(paramEmojiInfo);
    if (!paramEmojiInfo.cqu.cqv)
    {
      paramEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().yNq.blb();
      if (paramEmojiInfo != null)
      {
        localObject = paramEmojiInfo.xND.iterator();
        while (((Iterator)localObject).hasNext())
        {
          cdb localcdb = (cdb)((Iterator)localObject).next();
          if (localcdb.ProductID.equals(String.valueOf("capture"))) {
            localcdb.wux = 0;
          }
        }
      }
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().yNq.b(paramEmojiInfo);
      com.tencent.mm.ca.a.dqM();
      paramEmojiInfo = com.tencent.mm.ca.a.yiH;
      a.b.aoG(String.valueOf("capture"));
    }
    AppMethodBeat.o(52956);
  }
  
  public final boolean r(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(52893);
    if (paramContext == null)
    {
      ab.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: context is null");
      AppMethodBeat.o(52893);
      return false;
    }
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      ab.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: userName or imgPath is null");
      AppMethodBeat.o(52893);
      return false;
    }
    EmojiInfo localEmojiInfo = i.getEmojiStorageMgr().yNn.asP(paramString2);
    if (localEmojiInfo == null)
    {
      ab.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: emoji not found, imgPath %s", new Object[] { paramString2 });
      AppMethodBeat.o(52893);
      return false;
    }
    if ((localEmojiInfo.field_type == EmojiInfo.yPq) || (localEmojiInfo.field_type == EmojiInfo.yPr))
    {
      paramString2 = new WXMediaMessage();
      String str = com.tencent.mm.plugin.emoji.h.b.YP() + localEmojiInfo.Al();
      if (com.tencent.mm.vfs.e.cN(str + "_thumb")) {
        paramString2.thumbData = com.tencent.mm.vfs.e.i(str + "_thumb", 0, -1);
      }
      for (;;)
      {
        paramString2.mediaObject = new WXEmojiObject(str);
        paramContext = new qg();
        paramContext.cGL.cyF = paramString2;
        paramContext.cGL.appId = localEmojiInfo.field_app_id;
        paramContext.cGL.appName = null;
        paramContext.cGL.toUser = paramString1;
        paramContext.cGL.cGM = 0;
        paramContext.cGL.cGP = localEmojiInfo.Al();
        com.tencent.mm.sdk.b.a.ymk.l(paramContext);
        AppMethodBeat.o(52893);
        return true;
        paramString2.setThumbImage(localEmojiInfo.hC(paramContext));
      }
    }
    paramString2 = localEmojiInfo;
    if (localEmojiInfo.field_type == EmojiInfo.yPn)
    {
      if (!EmojiInfo.NB(localEmojiInfo.field_catalog)) {
        break label417;
      }
      paramContext = i.getEmojiStorageMgr().yNn.NH(localEmojiInfo.field_catalog);
    }
    for (;;)
    {
      paramString2 = localEmojiInfo;
      if (paramContext != null)
      {
        int i = bo.hk(paramContext.getCount() - 1, 0);
        paramString2 = new EmojiInfo();
        paramContext.moveToPosition(i);
        paramString2.convertFrom(paramContext);
        paramContext.close();
      }
      i.blo().a(paramString1, paramString2, null);
      break;
      label417:
      if ((localEmojiInfo.field_catalog == EmojiInfo.yPi) && (localEmojiInfo.getContent().length() > 0) && (EmojiInfo.NB(bo.getInt(localEmojiInfo.getContent(), 0)))) {
        paramContext = i.getEmojiStorageMgr().yNn.NH(bo.getInt(localEmojiInfo.getContent(), 0));
      } else {
        paramContext = null;
      }
    }
  }
  
  public final void s(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(52957);
    al.d(new h.3(this, paramEmojiInfo));
    AppMethodBeat.o(52957);
  }
  
  public final void updateEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(52899);
    i.getEmojiStorageMgr().yNn.J(paramEmojiInfo);
    AppMethodBeat.o(52899);
  }
  
  public final boolean w(ArrayList<SmileyInfo> paramArrayList)
  {
    AppMethodBeat.i(52918);
    boolean bool = i.getEmojiStorageMgr().yNv.ao(paramArrayList);
    AppMethodBeat.o(52918);
    return bool;
  }
  
  public final boolean x(ArrayList<SmileyPanelConfigInfo> paramArrayList)
  {
    AppMethodBeat.i(52919);
    com.tencent.mm.storage.emotion.r localr = i.getEmojiStorageMgr().yNw;
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      ab.i("MicroMsg.emoji.SmileyPanelConfigInfoStorage", "insertSmileyConfigInfoList failed. list is null.");
      AppMethodBeat.o(52919);
      return false;
    }
    com.tencent.mm.cg.h localh;
    long l;
    if ((localr.db instanceof com.tencent.mm.cg.h))
    {
      localh = (com.tencent.mm.cg.h)localr.db;
      l = localh.kr(Thread.currentThread().getId());
    }
    for (;;)
    {
      localr.db.delete("SmileyPanelConfigInfo", null, null);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localr.insert((SmileyPanelConfigInfo)paramArrayList.next());
      }
      int i = -1;
      if (localh != null) {
        i = localh.nY(l);
      }
      if (i < 0) {
        break;
      }
      AppMethodBeat.o(52919);
      return true;
      l = -1L;
      localh = null;
    }
  }
  
  public final int y(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(52929);
    int i = i.getEmojiStorageMgr().yNn.y(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(52929);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.h
 * JD-Core Version:    0.7.0.1
 */