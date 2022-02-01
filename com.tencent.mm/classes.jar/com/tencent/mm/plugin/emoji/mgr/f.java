package com.tencent.mm.plugin.emoji.mgr;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.cd;
import com.tencent.mm.autogen.a.cd.a;
import com.tencent.mm.autogen.a.ed;
import com.tencent.mm.autogen.a.ed.b;
import com.tencent.mm.autogen.a.wm;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.cc.a.b;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.br;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.e.l;
import com.tencent.mm.plugin.emoji.h.d;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.d.2;
import com.tencent.mm.plugin.emoji.model.i.1;
import com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI;
import com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.fdc;
import com.tencent.mm.protocal.protobuf.fdd;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bh.a;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.storage.emotion.v;
import com.tencent.mm.storage.emotion.w;
import com.tencent.mm.storage.emotion.x;
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
  implements com.tencent.mm.pluginsdk.b.d
{
  private static void a(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(108448);
    if (paramString1.equals("-1"))
    {
      Log.e("MicroMsg.emoji.EmojiMgrImpl", "showEmoji fail cause md5 is no valid");
      AppMethodBeat.o(108448);
      return;
    }
    EmojiInfo localEmojiInfo = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.bza(paramString1);
    if (localEmojiInfo == null)
    {
      Log.e("MicroMsg.emoji.EmojiMgrImpl", "showEmoji fail cause md5 is no valid");
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
      if (au.bwE(paramString4))
      {
        paramString1 = br.JJ(paramString5);
        localIntent.putExtra("room_id", paramString6);
      }
      localIntent.putExtra("msg_sender", paramString1);
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString1.aYi(), "com/tencent/mm/plugin/emoji/mgr/EmojiMgrImpl", "showEmoji", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString1.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/emoji/mgr/EmojiMgrImpl", "showEmoji", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(108448);
      return;
      localIntent.putExtra("custom_smiley_preview_appid", localEmojiInfo.field_app_id);
    }
  }
  
  public static void aor(String paramString)
  {
    AppMethodBeat.i(269926);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.emoji.EmojiMgrImpl", "doSceneGetEmotionDesc get emotion desc faild.");
      AppMethodBeat.o(269926);
      return;
    }
    paramString = new l(paramString);
    com.tencent.mm.kernel.h.baD().mCm.a(paramString, 0);
    AppMethodBeat.o(269926);
  }
  
  public static String dzu()
  {
    AppMethodBeat.i(269925);
    String str = "https://" + WeChatHosts.domainString(h.h.host_support_weixin_qq_com) + "/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0";
    AppMethodBeat.o(269925);
    return str;
  }
  
  private static void ea(String paramString, int paramInt)
  {
    AppMethodBeat.i(108445);
    com.tencent.mm.autogen.a.y localy = new com.tencent.mm.autogen.a.y();
    localy.hzL.hzM = paramString;
    localy.hzL.status = paramInt;
    localy.hzL.percentage = 0;
    localy.publish();
    Log.d("MicroMsg.emoji.EmojiMgrImpl", "attachid:%s percentage:%d status:%d", new Object[] { paramString, Integer.valueOf(0), Integer.valueOf(paramInt) });
    AppMethodBeat.o(108445);
  }
  
  public final boolean Z(ArrayList<SmileyInfo> paramArrayList)
  {
    AppMethodBeat.i(108472);
    boolean bool = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjD.cd(paramArrayList);
    AppMethodBeat.o(108472);
    return bool;
  }
  
  public final EmojiInfo a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    AppMethodBeat.i(108451);
    paramString1 = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.e(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3);
    AppMethodBeat.o(108451);
    return paramString1;
  }
  
  public final String a(Context paramContext, WXMediaMessage paramWXMediaMessage, String paramString)
  {
    AppMethodBeat.i(108454);
    paramContext = EmojiLogic.b(paramContext, paramWXMediaMessage, paramString);
    AppMethodBeat.o(108454);
    return paramContext;
  }
  
  public final void a(Context paramContext, cc paramcc, String paramString)
  {
    AppMethodBeat.i(108444);
    if ((paramContext == null) || (paramcc == null))
    {
      Log.w("MicroMsg.emoji.EmojiMgrImpl", "context or msg is null");
      AppMethodBeat.o(108444);
      return;
    }
    bg localbg = bg.byj(paramcc.field_content);
    Object localObject2 = k.b.Hf(paramcc.field_content);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new k.b();
      ((k.b)localObject1).nRf = localbg.md5;
    }
    localObject2 = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.bza(((k.b)localObject1).nRf);
    if ((localObject2 != null) && (((EmojiInfo)localObject2).kLZ()))
    {
      if (paramcc.field_isSend == 1)
      {
        a(paramContext, ((k.b)localObject1).nRf, ((k.b)localObject1).appId, ((k.b)localObject1).appName, paramcc.field_msgSvrId, paramcc.field_talker, paramcc.field_content, paramString);
        AppMethodBeat.o(108444);
        return;
      }
      a(paramContext, ((EmojiInfo)localObject2).getMd5(), ((k.b)localObject1).appId, ((k.b)localObject1).appName, paramcc.field_msgSvrId, paramcc.field_talker, paramcc.field_content, paramString);
      AppMethodBeat.o(108444);
      return;
    }
    paramContext = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.bza(((k.b)localObject1).nRf);
    if (paramContext == null)
    {
      paramcc = ((k.b)localObject1).nRf;
      if (Util.isNullOrNil(paramcc))
      {
        Log.e("MicroMsg.emoji.EmojiMgrImpl", "md5 is null.");
        AppMethodBeat.o(108444);
        return;
      }
      paramContext = new EmojiInfo();
      paramContext.field_md5 = paramcc;
      paramContext.field_app_id = ((k.b)localObject1).appId;
      paramContext.field_catalog = EmojiInfo.aklG;
      paramContext.field_size = ((k.b)localObject1).nRd;
      paramContext.field_temp = 1;
      paramContext.field_state = EmojiInfo.aklW;
      com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.L(paramContext);
    }
    for (;;)
    {
      ea(paramContext.field_md5, 0);
      Log.d("MicroMsg.emoji.EmojiMgrImpl", "start change cdn url. md5:%s", new Object[] { paramContext.field_md5 });
      paramcc = paramContext.field_md5;
      paramString = com.tencent.mm.emoji.b.e.mgl;
      com.tencent.mm.emoji.b.e.a(paramContext, true, new f.1(paramcc));
      AppMethodBeat.o(108444);
      return;
    }
  }
  
  public final void a(com.tencent.mm.emoji.sync.a parama)
  {
    AppMethodBeat.i(270136);
    com.tencent.mm.plugin.emoji.model.s.dAm().c(parama);
    AppMethodBeat.o(270136);
  }
  
  public final void a(String paramString, EmojiInfo paramEmojiInfo, cc paramcc)
  {
    AppMethodBeat.i(108447);
    if ((paramEmojiInfo == null) && (paramcc == null))
    {
      AppMethodBeat.o(108447);
      return;
    }
    EmojiInfo localEmojiInfo = paramEmojiInfo;
    if (paramEmojiInfo == null) {
      localEmojiInfo = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.bza(paramcc.field_imgPath);
    }
    if (au.bwZ(paramString))
    {
      com.tencent.mm.plugin.emoji.model.s.dAk().b(paramString, localEmojiInfo, paramcc);
      AppMethodBeat.o(108447);
      return;
    }
    com.tencent.mm.plugin.emoji.model.s.dAj().a(paramString, localEmojiInfo, paramcc);
    AppMethodBeat.o(108447);
  }
  
  public final boolean a(Context paramContext, EmojiInfo paramEmojiInfo, int paramInt, String paramString)
  {
    AppMethodBeat.i(108443);
    if (paramContext == null)
    {
      Log.e("MicroMsg.emoji.EmojiMgrImpl", "[cpan] save emoji failed. context is null");
      AppMethodBeat.o(108443);
      return false;
    }
    if (paramEmojiInfo == null)
    {
      Log.e("MicroMsg.emoji.EmojiMgrImpl", "[cpan] save emoji failed. emoji is null");
      AppMethodBeat.o(108443);
      return false;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, EmojiAddCustomDialogUI.class);
    localIntent.putExtra("extra_id", paramEmojiInfo.getMd5());
    localIntent.putExtra("extra_scence", paramInt);
    localIntent.putExtra("extra_move_to_top", true);
    localIntent.putExtra("extra_username", paramString);
    localIntent.putExtra("extra_current", false);
    localIntent.putExtra("key_is_selfie", false);
    localIntent.putExtra("key_attached_text", null);
    localIntent.putExtra("key_attached_emoji_md5", null);
    localIntent.putExtra("key_imitate_md5", null);
    localIntent.addFlags(65536);
    paramEmojiInfo = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramEmojiInfo.aYi(), "com/tencent/mm/plugin/emoji/mgr/EmojiMgrImpl", "saveCustomEmoji", "(Landroid/content/Context;Lcom/tencent/mm/storage/emotion/EmojiInfo;ILjava/lang/String;IZZZLjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramEmojiInfo.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/emoji/mgr/EmojiMgrImpl", "saveCustomEmoji", "(Landroid/content/Context;Lcom/tencent/mm/storage/emotion/EmojiInfo;ILjava/lang/String;IZZZLjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(108443);
    return true;
  }
  
  public final boolean a(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(108468);
    paramBoolean = com.tencent.mm.emoji.decode.a.aUc().a(paramEmojiInfo, paramBoolean);
    AppMethodBeat.o(108468);
    return paramBoolean;
  }
  
  public final boolean a(String paramString1, String paramString2, long paramLong, String paramString3, g.a parama)
  {
    AppMethodBeat.i(108455);
    if (au.bwZ(paramString1))
    {
      localObject = com.tencent.mm.plugin.emoji.model.s.dAk();
      paramString2 = bk.bH(paramString1, paramString2, paramString3);
      if (paramString2 == null) {
        Log.i("MicroMsg.emoji.EmojiBypService", "prepareEmoji failed. emoji msg info is null.");
      }
      for (;;)
      {
        AppMethodBeat.o(108455);
        return true;
        paramString2.hTh = paramLong;
        Log.i("MicroMsg.emoji.EmojiBypService", "prepareEmoji msgSvrId[%d], stack[%s]", new Object[] { Long.valueOf(paramLong), Util.getStack() });
        paramString1 = paramString2.productId;
        com.tencent.mm.kernel.h.baH().postToWorker(new d.2((com.tencent.mm.plugin.emoji.model.d)localObject, paramString1));
        if (paramString2 != null) {
          break;
        }
        Log.w("MicroMsg.emoji.EmojiBypService", "downloadEmoji msginfo is null.");
      }
      if ((parama != null) && (parama.mpN != null) && (parama.mpN.Njv == paramString2.hTh))
      {
        paramString2.jUq = br.d(parama);
        paramString2.peI = parama.mpN.YFL;
        paramString2.createTime = parama.mpN.CreateTime;
      }
      paramString1 = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.bza(paramString2.md5);
      if (paramString1 != null)
      {
        Log.i("MicroMsg.emoji.EmojiBypService", "downloadEmoji: db emoji info not null %s msgInfomd5 %s svrId %s", new Object[] { paramString1.field_md5, paramString2.md5, Long.valueOf(paramString2.hTh) });
        com.tencent.mm.plugin.emoji.g.d.b(paramString2, paramString1);
        com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.M(paramString1);
      }
      for (;;)
      {
        if (paramString2.adjq) {
          com.tencent.mm.plugin.emoji.model.d.a(paramString2, paramString1, parama);
        }
        Log.i("MicroMsg.emoji.EmojiBypService", "start download emoji %s, fileExist %b", new Object[] { paramString1.getMd5(), Boolean.valueOf(paramString1.kLZ()) });
        if (paramString1.kLZ()) {
          break;
        }
        Log.i("MicroMsg.emoji.EmojiBypService", "cdnurl and cncrypt url is null. ");
        com.tencent.mm.plugin.emoji.model.d.b(paramString2);
        break;
        Log.i("MicroMsg.emoji.EmojiBypService", "downloadEmoji: create emoji info %s", new Object[] { paramString2.md5 });
        paramString1 = com.tencent.mm.plugin.emoji.model.d.a(paramString2);
      }
    }
    Object localObject = com.tencent.mm.plugin.emoji.model.s.dAj();
    paramString1 = bk.bH(paramString1, paramString2, paramString3);
    if (paramString1 == null)
    {
      Log.i("MicroMsg.emoji.EmojiService", "prepareEmoji failed. emoji msg info is null.");
      AppMethodBeat.o(108455);
      return true;
    }
    paramString1.hTh = paramLong;
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yRL, false);
    Log.i("MicroMsg.emoji.EmojiService", "summerbadcr prepareEmoji msgSvrId[%d], useMsgDesc:%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(bool) });
    if (bool)
    {
      com.tencent.mm.plugin.emoji.model.i.c(paramString1);
      if (EmojiLogic.aoH(com.tencent.mm.emoji.c.o.aUS())) {
        break label497;
      }
    }
    label497:
    for (bool = true;; bool = false)
    {
      ((com.tencent.mm.plugin.emoji.model.i)localObject).a(paramString1, parama, bool);
      AppMethodBeat.o(108455);
      return true;
      paramString2 = paramString1.productId;
      com.tencent.mm.kernel.h.baH().postToWorker(new i.1((com.tencent.mm.plugin.emoji.model.i)localObject, paramString2));
      break;
    }
  }
  
  public final byte[] a(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108466);
    if (paramEmojiInfo != null)
    {
      EmojiInfo localEmojiInfo = aoe(paramEmojiInfo.field_md5);
      if ((localEmojiInfo != null) && (localEmojiInfo.field_reserved4 != paramEmojiInfo.field_reserved4)) {
        paramEmojiInfo.field_reserved4 = localEmojiInfo.field_reserved4;
      }
    }
    paramEmojiInfo = com.tencent.mm.emoji.decode.a.aUc().a(paramEmojiInfo);
    AppMethodBeat.o(108466);
    return paramEmojiInfo;
  }
  
  public final boolean aUW()
  {
    AppMethodBeat.i(108492);
    boolean bool = com.tencent.mm.emoji.c.o.aUW();
    AppMethodBeat.o(108492);
    return bool;
  }
  
  public final boolean aUX()
  {
    AppMethodBeat.i(108493);
    if ((WeChatEnvironment.hasDebugger()) || (com.tencent.mm.emoji.c.o.aUX()))
    {
      AppMethodBeat.o(108493);
      return true;
    }
    AppMethodBeat.o(108493);
    return false;
  }
  
  public final boolean aa(ArrayList<SmileyPanelConfigInfo> paramArrayList)
  {
    AppMethodBeat.i(108473);
    w localw = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjE;
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      Log.i("MicroMsg.emoji.SmileyPanelConfigInfoStorage", "insertSmileyConfigInfoList failed. list is null.");
      AppMethodBeat.o(108473);
      return false;
    }
    Log.i("MicroMsg.emoji.SmileyPanelConfigInfoStorage", "insertSmileyConfigInfoList: %s", new Object[] { Integer.valueOf(paramArrayList.size()) });
    com.tencent.mm.storagebase.h localh;
    long l;
    if ((localw.db instanceof com.tencent.mm.storagebase.h))
    {
      localh = (com.tencent.mm.storagebase.h)localw.db;
      l = localh.beginTransaction(Thread.currentThread().getId());
    }
    for (;;)
    {
      localw.db.delete("SmileyPanelConfigInfo", null, null);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localw.insert((SmileyPanelConfigInfo)paramArrayList.next());
      }
      int i = -1;
      if (localh != null) {
        i = localh.endTransaction(l);
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
  
  public final EmojiInfo aoe(String paramString)
  {
    AppMethodBeat.i(108440);
    paramString = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.bza(paramString);
    AppMethodBeat.o(108440);
    return paramString;
  }
  
  public final EmojiInfo aof(String paramString)
  {
    AppMethodBeat.i(108441);
    paramString = aoe(paramString);
    AppMethodBeat.o(108441);
    return paramString;
  }
  
  public final String aog(String paramString)
  {
    AppMethodBeat.i(108453);
    paramString = EmojiLogic.aog(paramString);
    AppMethodBeat.o(108453);
    return paramString;
  }
  
  public final List<EmojiInfo> aoh(String paramString)
  {
    AppMethodBeat.i(108456);
    if (com.tencent.mm.kernel.h.baE().isSDCardAvailable())
    {
      paramString = (ArrayList)com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.aoh(paramString);
      AppMethodBeat.o(108456);
      return paramString;
    }
    paramString = new ArrayList();
    AppMethodBeat.o(108456);
    return paramString;
  }
  
  public final String aoi(String paramString)
  {
    AppMethodBeat.i(108458);
    paramString = com.tencent.mm.plugin.emoji.model.s.getEmojiDescMgr().aoi(paramString);
    AppMethodBeat.o(108458);
    return paramString;
  }
  
  public final boolean aoj(String paramString)
  {
    AppMethodBeat.i(108459);
    if ((paramString != null) && (paramString.equals("capture")))
    {
      AppMethodBeat.o(108459);
      return true;
    }
    boolean bool = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjv.byS(paramString);
    AppMethodBeat.o(108459);
    return bool;
  }
  
  public final ArrayList<String> aok(String paramString)
  {
    AppMethodBeat.i(108460);
    bh localbh = com.tencent.mm.plugin.emoji.model.s.getEmojiDescMgr();
    if (!localbh.mInit) {
      localbh.jaY();
    }
    long l = System.currentTimeMillis();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    if (!localbh.mInit) {
      localbh.jaY();
    }
    if (com.tencent.mm.ui.tools.g.bCx(paramString) > localbh.adiQ) {
      Log.i("MicroMsg.emoji.EmojiDescNewMgr", "input text over checkout limit.");
    }
    for (;;)
    {
      paramString = localArrayList3.iterator();
      while (paramString.hasNext())
      {
        Object localObject = (String)paramString.next();
        localObject = (ArrayList)localbh.adiU.get(localObject);
        if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
          localArrayList1.addAll((Collection)localObject);
        }
      }
      if ((!Util.isNullOrNil(paramString)) && (localbh.adiU != null))
      {
        paramString = paramString.toLowerCase();
        if (localbh.adiT.containsKey(paramString))
        {
          paramString = (String)localbh.adiT.get(paramString);
          paramString = (List)localbh.adiS.get(paramString);
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
    Log.i("MicroMsg.emoji.EmojiDescNewMgr", "changeText: %s, %s", new Object[] { Integer.valueOf(localArrayList3.size()), Integer.valueOf(localArrayList1.size()) });
    if (!localArrayList1.isEmpty())
    {
      Collections.sort(localArrayList1, localbh.adiV);
      int i = 0;
      while (i < localArrayList1.size())
      {
        localArrayList2.add(((bh.a)localArrayList1.get(i)).md5);
        i += 1;
      }
    }
    Log.d("MicroMsg.emoji.EmojiDescNewMgr", "cpan[check desc]User time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(108460);
    return localArrayList2;
  }
  
  public final String aol(String paramString)
  {
    AppMethodBeat.i(108461);
    paramString = EmojiLogic.aol(paramString);
    AppMethodBeat.o(108461);
    return paramString;
  }
  
  public final String aom(String paramString)
  {
    AppMethodBeat.i(108462);
    paramString = EmojiLogic.aom(paramString);
    AppMethodBeat.o(108462);
    return paramString;
  }
  
  public final int aon(String paramString)
  {
    AppMethodBeat.i(108463);
    int i = EmojiLogic.aon(paramString);
    AppMethodBeat.o(108463);
    return i;
  }
  
  public final String aoo(String paramString)
  {
    AppMethodBeat.i(108464);
    paramString = EmojiLogic.aoo(paramString);
    AppMethodBeat.o(108464);
    return paramString;
  }
  
  public final void aop(String paramString)
  {
    AppMethodBeat.i(108476);
    if (Util.isNullOrNil(paramString)) {
      Log.i("MicroMsg.emoji.EmojiCommandMgr", "emoji command is null.");
    }
    Object localObject1;
    if ("sync".equalsIgnoreCase(paramString))
    {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acHX, Boolean.TRUE);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acId, Boolean.TRUE);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acIe, Boolean.TRUE);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acIi, Long.valueOf(System.currentTimeMillis()));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acIj, Long.valueOf(System.currentTimeMillis()));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acHW, Long.valueOf(0L));
      new com.tencent.mm.emoji.sync.f(0).start();
      new com.tencent.mm.emoji.sync.f(1).start();
      localObject1 = new com.tencent.mm.plugin.emoji.e.o(8, null, 15, true);
      com.tencent.mm.kernel.h.baD().mCm.a((p)localObject1, 0);
    }
    while (WeChatEnvironment.hasDebugger())
    {
      Object localObject3;
      Object localObject4;
      if ("new".equalsIgnoreCase(paramString))
      {
        com.tencent.mm.aa.c.aYo().Q(262147, true);
        com.tencent.mm.kernel.h.baE().ban().B(208899, Boolean.TRUE);
        com.tencent.mm.kernel.h.baE().ban().B(229633, "http://mmbiz.qpic.cn/mmemoticon/Q3auHgzwzM5eOptD4jIj72I8icMVEKwzSYkC30IgjMvSibGfqsEdy0ibXayiaZtbibSXV5EPZEWILOvbrjjLtQ9P4QQ/0");
        com.tencent.mm.kernel.h.baE().ban().B(229634, System.currentTimeMillis());
        AppMethodBeat.o(108476);
        return;
        if ("rcheart".equalsIgnoreCase(paramString))
        {
          com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjv.jdj();
        }
        else if ("recover".equalsIgnoreCase(paramString))
        {
          Log.i("MicroMsg.emoji.EmojiCommandMgr", "recover   begin");
          com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.init(MMApplicationContext.getContext());
          com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjv.init(MMApplicationContext.getContext());
          Log.i("MicroMsg.emoji.EmojiCommandMgr", "recover   end");
        }
        else if ("clean".equalsIgnoreCase(paramString))
        {
          Log.i("MicroMsg.emoji.EmojiCommandMgr", "begin clean");
          d.dzs().aod(com.tencent.mm.plugin.emoji.g.d.bzQ());
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acId, Boolean.TRUE);
          Log.i("MicroMsg.emoji.EmojiCommandMgr", "end clean");
        }
        else
        {
          if ("dump".equalsIgnoreCase(paramString))
          {
            Log.i("MicroMsg.emoji.EmojiCommandMgr", "begin dump emoji db info:");
            localObject1 = (ArrayList)com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjv.jcW();
            if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
            {
              int j = ((ArrayList)localObject1).size();
              int i = 0;
              while (i < j)
              {
                Log.i("MicroMsg.emoji.EmojiCommandMgr", "i:%d group info:%s", new Object[] { Integer.valueOf(i), ((EmojiGroupInfo)((ArrayList)localObject1).get(i)).toString() });
                i += 1;
              }
            }
            Object localObject2 = null;
            localObject1 = null;
            try
            {
              localObject3 = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.getAll();
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
                    Log.i("MicroMsg.emoji.EmojiCommandMgr", "emoji info:%s", new Object[] { ((EmojiInfo)localObject4).toString() });
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
                break label682;
              }
              localException.close();
              AppMethodBeat.o(108476);
            }
            Log.i("MicroMsg.emoji.EmojiCommandMgr", "end dump emoji db info:");
            continue;
          }
          label682:
          if ("tuzki".equalsIgnoreCase(paramString))
          {
            com.tencent.mm.plugin.emoji.e.a.dAs();
            com.tencent.mm.plugin.emoji.e.a.dAt();
          }
          else if (paramString.startsWith("reset-first"))
          {
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acWT, Boolean.FALSE);
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acWU, Boolean.FALSE);
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acWV, Boolean.FALSE);
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acWW, Boolean.FALSE);
          }
          else if (paramString.startsWith("cleanThumb"))
          {
            localObject1 = com.tencent.mm.emoji.f.c.moq;
            com.tencent.mm.emoji.f.c.aWE();
            Toast.makeText(MMApplicationContext.getContext(), "clean thumb done", 0).show();
          }
        }
      }
      else
      {
        if ("free".equalsIgnoreCase(paramString))
        {
          com.tencent.mm.aa.c.aYo().Q(262149, true);
          com.tencent.mm.kernel.h.baE().ban().B(208913, Boolean.TRUE);
          com.tencent.mm.kernel.h.baE().ban().B(229633, "http://mmbiz.qpic.cn/mmemoticon/Q3auHgzwzM5eOptD4jIj72I8icMVEKwzSYkC30IgjMvSibGfqsEdy0ibXayiaZtbibSXV5EPZEWILOvbrjjLtQ9P4QQ/0");
          com.tencent.mm.kernel.h.baE().ban().B(229634, System.currentTimeMillis());
          AppMethodBeat.o(108476);
          return;
        }
        if ("newp".equalsIgnoreCase(paramString))
        {
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acIc, Boolean.TRUE);
          AppMethodBeat.o(108476);
          return;
        }
        if ("newpe".equalsIgnoreCase(paramString))
        {
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acIh, Boolean.TRUE);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("add"))
        {
          paramString.replace("add", "").trim().split(",");
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("backup"))
        {
          paramString = new com.tencent.mm.plugin.emoji.e.c(0, 1, Arrays.asList(paramString.replace("backup", "").trim().split(",")));
          com.tencent.mm.kernel.h.baD().mCm.a(paramString, 0);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("h5"))
        {
          paramString = paramString.replace("h5", "").trim();
          PreferenceManager.getDefaultSharedPreferences(MMApplicationContext.getContext()).edit().putString("h5", paramString).commit();
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("md5"))
        {
          localObject1 = paramString.replace("md5", "").trim();
          paramString = (String)localObject1;
          if (Util.isNullOrNil((String)localObject1)) {
            paramString = "/sdcard/test.png";
          }
          Log.i("MicroMsg.emoji.EmojiCommandMgr", com.tencent.mm.vfs.y.bub(paramString));
          Log.i("MicroMsg.emoji.EmojiCommandMgr", MD5Util.getMD5String(paramString));
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("recommend"))
        {
          paramString = com.tencent.mm.plugin.emoji.f.d.aoM("<NewRecommendEmotion><Emotion><ProductID>com.tencent.xin.emoticon.person.stiker_144984189945aa5830d33cd7dc</ProductID><RecType>3</RecType><Name>野萌君</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/duc2TvpEgSTWy4k8MnuicFjyiazriaGWDX52HzNWeLVTjtJcjZeZEicTn5kJFPYdicWZTuUZJgiaADK9I/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/DhduwiaBa7lchicgAfwibeykm81eGWXkMDgGJ8DWcOcIc28C7oTic4Y09Pick8Fw69KiaZVxrHl8S2lPY/0</Panel><ButtonType>1</ButtonType></Emotion><Emotion><ProductID>com.tencent.xin.emoticon.person.stiker_14389422638f6ca818af405e21</ProductID><RecType>3</RecType><Name>猪仔和羊妹</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/iaUiazNVkRp7iaZjrMuYgfH8kB5xkyYv20CYzY3W9HCLBr2XybJibGKKtXibMnAfZnRTH/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/PiajxSqBRaEJR9canNKZ7RYI3hx5BPCSwQmuhhlNWD1jzUSOx3CWqEtibd65zOjySd/0</Panel><ButtonType>1</ButtonType></Emotion><Emotion><ProductID>com.tencent.xin.emoticon.person.stiker_1444199720f5ea147582ff0512</ProductID><RecType>3</RecType><Name>让红包飞</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/nMl9ssowtibXLY57PdK8Nsh827vlsw4TGHPgLUehd2R455xnwe3xpoVDIKpAuXU1Aic3XbH1LfMr7fp4DgO7o8IQ/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/duc2TvpEgST18reErFRzNFR8EiahI4Iibp4ZnW1ibJYt4MMLvQvjx3sHGTMuTOgnREq5f2GXLhuzalOOz3icw9NGbA/0</Panel><ButtonType>1</ButtonType></Emotion><Emotion><ProductID>com.tencent.xin.emoticon.xiaobendan</ProductID><RecType>3</RecType><Name>小笨蛋与大坏蛋</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/ajNVdqHZLLC8ILTt0pqcaCVkldLMydoNJcupoR7qUojia3vKlgd74uQ/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/ajNVdqHZLLC8ILTt0pqcaAAEUI4a7z5ECqpUXbQw95PY1mpc4p0FxA/0</Panel><ButtonType>1</ButtonType></Emotion><Emotion><ProductID>com.tencent.xin.emoticon.shin2</ProductID><RecType>3</RecType><Name>野原新之助2</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/iciaySdkria4apGIW1wvSbPC9oxWQPHZyicaccx5JDIp2uE/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/ajNVdqHZLLASEAAX7xw76beia5j4HyA0rq9WgtgscicJo7935UCpCpog/0</Panel><ButtonType>1</ButtonType></Emotion></NewRecommendEmotion>");
          com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjv.jdb();
          com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjv.ca(paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("count"))
        {
          paramString = paramString.replace("count", "").trim();
          com.tencent.mm.k.i.aRC().put("CustomEmojiMaxSize", paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("auto"))
        {
          paramString = paramString.replace("auto", "").trim();
          com.tencent.mm.k.i.aRC().put("C2CEmojiNotAutoDownloadTimeRange", paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("bo"))
        {
          if (paramString.replace("bo", "").trim().equalsIgnoreCase("1"))
          {
            PreferenceManager.getDefaultSharedPreferences(MMApplicationContext.getContext()).edit().putBoolean("broken", true).commit();
            AppMethodBeat.o(108476);
            return;
          }
          PreferenceManager.getDefaultSharedPreferences(MMApplicationContext.getContext()).edit().putBoolean("broken", false).commit();
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
          com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjD.cd(paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("panel"))
        {
          paramString.replace("panel", "").trim();
          paramString = new cd();
          paramString.hCg.subType = 1;
          paramString.hCg.hCh = 37;
          paramString.hCg.filePath = (com.tencent.mm.loader.i.b.bmz() + "CheckResUpdate/37.1.data");
          paramString.publish();
          paramString = new cd();
          paramString.hCg.subType = 2;
          paramString.hCg.hCh = 37;
          paramString.hCg.filePath = "/sdcard/tencent/MicroMsg/CheckResUpdate/37.2.data";
          paramString.publish();
          paramString = new cd();
          paramString.hCg.subType = 3;
          paramString.hCg.hCh = 37;
          paramString.hCg.filePath = (com.tencent.mm.loader.i.b.bmz() + "CheckResUpdate/37.3.data");
          paramString.publish();
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("key"))
        {
          paramString = com.tencent.mm.b.g.getMessageDigest(String.valueOf(System.currentTimeMillis()).getBytes());
          Log.i("MicroMsg.emoji.EmojiCommandMgr", "create key :%s" + Util.secPrint(paramString));
          com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.azi(153);
          localObject1 = new EmojiInfo();
          ((EmojiInfo)localObject1).field_md5 = paramString;
          ((EmojiInfo)localObject1).field_catalog = 153;
          com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.L((EmojiInfo)localObject1);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("delete-db"))
        {
          paramString = paramString.replace("delete-db", "").trim();
          com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.bzb(paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("delete-file"))
        {
          a.aob(paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("batchDownload"))
        {
          paramString = paramString.split(" ");
          if (paramString.length > 1) {
            new com.tencent.mm.emoji.sync.f(Util.safeParseInt(paramString[1])).start();
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
            paramString = new com.tencent.mm.plugin.emoji.e.e((LinkedList)localObject1);
            com.tencent.mm.kernel.h.baD().mCm.a(paramString, 0);
          }
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("test"))
        {
          Log.i("MicroMsg.emoji.EmojiCommandMgr", "theTest: %s", new Object[] { paramString });
          com.tencent.threadpool.h.ahAA.bm(new a.1());
        }
      }
    }
    AppMethodBeat.o(108476);
  }
  
  public final void aoq(String paramString)
  {
    AppMethodBeat.i(270156);
    com.tencent.mm.plugin.emoji.sync.a locala = com.tencent.mm.plugin.emoji.model.s.dAm();
    LinkedList localLinkedList = new LinkedList();
    if (Util.isEqual(paramString, String.valueOf(EmojiGroupInfo.aklD))) {
      localLinkedList.add(new com.tencent.mm.plugin.emoji.sync.a.b("com.tencent.xin.emoticon.tusiji"));
    }
    for (;;)
    {
      locala.xPe.fe(localLinkedList);
      if (!locala.xPe.xPp) {
        locala.xPe.dAN();
      }
      AppMethodBeat.o(270156);
      return;
      localLinkedList.add(new com.tencent.mm.plugin.emoji.sync.a.a(paramString));
    }
  }
  
  public final void aos(String paramString)
  {
    AppMethodBeat.i(176179);
    com.tencent.mm.storage.emotion.y localy = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjG;
    LinkedList localLinkedList;
    int i;
    if (!Util.isNullOrNil(paramString))
    {
      localLinkedList = localy.KNn;
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < localy.KNn.size())
        {
          if (Util.isEqual(((x)localy.KNn.get(i)).key, paramString))
          {
            localx = (x)localy.KNn.get(i);
            if (localx == null)
            {
              localx = new x();
              localx.key = paramString;
              localx.admN += 1;
              localx.mJI = System.currentTimeMillis();
              localy.KNn.add(0, localx);
              if (localy.KNn.size() > 9) {
                localy.KNn.remove(localy.KNn.size() - 1);
              }
              localy.doNotify("event_update_recent", 0, Integer.valueOf(localy.KNn.size()));
              AppMethodBeat.o(176179);
            }
          }
          else
          {
            i += 1;
            continue;
          }
          localy.KNn.remove(i);
          continue;
        }
        i = -1;
      }
      finally
      {
        AppMethodBeat.o(176179);
      }
      x localx = null;
    }
  }
  
  public final boolean aot(String paramString)
  {
    bool2 = false;
    AppMethodBeat.i(108499);
    com.tencent.mm.plugin.gif.f localf = new com.tencent.mm.plugin.gif.f(paramString);
    int i = (int)com.tencent.mm.vfs.y.bEl(paramString);
    if (i != 0) {
      bool1 = bool2;
    }
    try
    {
      if (i <= com.tencent.mm.k.c.aRi())
      {
        bool1 = bool2;
        if (localf.JgK[0] <= com.tencent.mm.k.c.aRh())
        {
          i = localf.JgK[1];
          int j = com.tencent.mm.k.c.aRh();
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
        Log.e("MicroMsg.emoji.EmojiMgrImpl", Util.stackTraceToString(paramString));
        bool1 = bool2;
        continue;
        bool1 = true;
      }
    }
    AppMethodBeat.o(108499);
    return bool1;
  }
  
  public final boolean aou(String paramString)
  {
    bool2 = false;
    AppMethodBeat.i(270256);
    com.tencent.mm.plugin.gif.f localf = new com.tencent.mm.plugin.gif.f(paramString);
    int i = (int)com.tencent.mm.vfs.y.bEl(paramString);
    if (i != 0) {
      bool1 = bool2;
    }
    try
    {
      if (i <= com.tencent.mm.k.c.aRf())
      {
        bool1 = bool2;
        if (localf.JgK[0] <= com.tencent.mm.k.c.aRh())
        {
          i = localf.JgK[1];
          int j = com.tencent.mm.k.c.aRh();
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
        Log.e("MicroMsg.emoji.EmojiMgrImpl", Util.stackTraceToString(paramString));
        bool1 = bool2;
        continue;
        bool1 = true;
      }
    }
    AppMethodBeat.o(270256);
    return bool1;
  }
  
  public final void aov(String paramString)
  {
    AppMethodBeat.i(108501);
    if (!Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.emoji.EmojiMgrImpl", "deleteCaptureEmoji md: ".concat(String.valueOf(paramString)));
      com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.bzb(paramString);
      com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.doNotify("delete_emoji_info_notify");
    }
    AppMethodBeat.o(108501);
  }
  
  public final void aow(String paramString)
  {
    AppMethodBeat.i(108503);
    EmojiInfo localEmojiInfo = aoe(paramString);
    if (localEmojiInfo != null)
    {
      paramString = com.tencent.mm.emoji.e.h.mol;
      com.tencent.mm.emoji.e.h.m(localEmojiInfo);
      AppMethodBeat.o(108503);
      return;
    }
    Log.w("MicroMsg.emoji.EmojiMgrImpl", "addCaptureEmojiUploadTask: emojiInfo null by md5 %s", new Object[] { paramString });
    AppMethodBeat.o(108503);
  }
  
  public final void b(com.tencent.mm.emoji.sync.a parama)
  {
    AppMethodBeat.i(270142);
    com.tencent.mm.plugin.emoji.model.s.dAm().d(parama);
    AppMethodBeat.o(270142);
  }
  
  public final <T> T c(at.a parama, T paramT)
  {
    AppMethodBeat.i(108497);
    parama = com.tencent.mm.kernel.h.baE().ban().get(parama, paramT);
    AppMethodBeat.o(108497);
    return parama;
  }
  
  public final int d(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(108480);
    if ((paramBoolean) || ((paramEmojiInfo != null) && (paramEmojiInfo.field_activityid != null) && (paramEmojiInfo.field_activityid.startsWith("Selfie:")))) {}
    for (int i = 1; i != 0; i = 0)
    {
      i = com.tencent.mm.k.c.aRi();
      AppMethodBeat.o(108480);
      return i;
    }
    i = com.tencent.mm.k.c.aRg();
    AppMethodBeat.o(108480);
    return i;
  }
  
  public final void d(at.a parama, Object paramObject)
  {
    AppMethodBeat.i(108498);
    com.tencent.mm.kernel.h.baE().ban().set(parama, paramObject);
    AppMethodBeat.o(108498);
  }
  
  public final void dzA()
  {
    AppMethodBeat.i(108479);
    h localh = h.dzH();
    cd localcd = new cd();
    cd.a locala = localcd.hCg;
    com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
    locala.filePath = com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.nK(37, 1);
    localcd.hCg.hCh = 37;
    localcd.hCg.subType = 1;
    localcd.hCg.hCi = -1;
    localh.b(localcd);
    AppMethodBeat.o(108479);
  }
  
  public final void dzB()
  {
    AppMethodBeat.i(270121);
    com.tencent.mm.plugin.emoji.model.s.dAm().dAK();
    AppMethodBeat.o(270121);
  }
  
  public final boolean dzC()
  {
    AppMethodBeat.i(270129);
    boolean bool = com.tencent.mm.plugin.emoji.model.s.dAm().xPe.xPp;
    AppMethodBeat.o(270129);
    return bool;
  }
  
  public final boolean dzD()
  {
    AppMethodBeat.i(108491);
    boolean bool = com.tencent.mm.emoji.c.o.aUV();
    AppMethodBeat.o(108491);
    return bool;
  }
  
  public final List<x> dzE()
  {
    AppMethodBeat.i(108495);
    List localList = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjG.dzE();
    AppMethodBeat.o(108495);
    return localList;
  }
  
  public final void dzF()
  {
    AppMethodBeat.i(108496);
    Object localObject = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjG.dzE();
    JSONArray localJSONArray = new JSONArray();
    localObject = ((List)localObject).iterator();
    do
    {
      x localx;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localx = (x)((Iterator)localObject).next();
      } while (localx.toJson() == null);
      localJSONArray.put(localx.toJson());
    } while (localJSONArray.length() < 9);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acWQ, localJSONArray.toString());
    AppMethodBeat.o(108496);
  }
  
  public final boolean dzG()
  {
    AppMethodBeat.i(108500);
    int i;
    if (!com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acWW, true))
    {
      i = 1;
      if ((!com.tencent.mm.emoji.c.o.isSpringFestivalEnable()) || (com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acWX, false))) {
        break label69;
      }
    }
    label69:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) && (j == 0)) {
        break label74;
      }
      AppMethodBeat.o(108500);
      return true;
      i = 0;
      break;
    }
    label74:
    AppMethodBeat.o(108500);
    return false;
  }
  
  public final boolean dzt()
  {
    AppMethodBeat.i(108469);
    boolean bool = com.tencent.mm.emoji.c.o.aUP();
    AppMethodBeat.o(108469);
    return bool;
  }
  
  public final ArrayList<SmileyInfo> dzv()
  {
    AppMethodBeat.i(108470);
    ArrayList localArrayList = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjD.dzv();
    AppMethodBeat.o(108470);
    return localArrayList;
  }
  
  public final ArrayList<SmileyPanelConfigInfo> dzw()
  {
    AppMethodBeat.i(108471);
    ArrayList localArrayList = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjE.dzw();
    AppMethodBeat.o(108471);
    return localArrayList;
  }
  
  public final com.tencent.mm.modelpackage.g dzx()
  {
    AppMethodBeat.i(108475);
    com.tencent.mm.modelpackage.g localg = h.dzH().dzx();
    AppMethodBeat.o(108475);
    return localg;
  }
  
  public final boolean dzy()
  {
    AppMethodBeat.i(108477);
    if ((WeChatEnvironment.hasDebugger()) || (com.tencent.mm.emoji.c.o.aUY()))
    {
      AppMethodBeat.o(108477);
      return true;
    }
    AppMethodBeat.o(108477);
    return false;
  }
  
  public final String dzz()
  {
    AppMethodBeat.i(108478);
    h.dzH();
    String str = h.dzz();
    AppMethodBeat.o(108478);
    return str;
  }
  
  public final bk gM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108449);
    Map localMap = XmlParser.parseXml(paramString1, "msg", null);
    if (localMap == null)
    {
      Log.w("MicroMsg.emoji.EmojiMgrImpl", "get from xml, but attrs is null");
      AppMethodBeat.o(108449);
      return null;
    }
    paramString2 = bk.e(localMap, paramString2, paramString1);
    if (paramString2 == null)
    {
      Log.w("MicroMsg.emoji.EmojiMgrImpl", "parserEmojiXml error ".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(108449);
      return null;
    }
    AppMethodBeat.o(108449);
    return paramString2;
  }
  
  public final String gN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108474);
    paramString1 = EmojiLogic.W(com.tencent.mm.plugin.emoji.g.d.bzQ(), paramString1, paramString2);
    AppMethodBeat.o(108474);
    return paramString1;
  }
  
  public final String getAccPath()
  {
    AppMethodBeat.i(108457);
    String str = com.tencent.mm.kernel.h.baE().mCJ;
    AppMethodBeat.o(108457);
    return str;
  }
  
  public final String getDataEmojiPath()
  {
    AppMethodBeat.i(270100);
    String str = h.getDataEmojiPath();
    AppMethodBeat.o(270100);
    return str;
  }
  
  public final void h(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(108487);
    com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.remove(paramIOnStorageChange);
    AppMethodBeat.o(108487);
  }
  
  public final void i(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(108488);
    com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.add(paramIOnStorageChange);
    AppMethodBeat.o(108488);
  }
  
  public final void j(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(108489);
    com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjv.remove(paramIOnStorageChange);
    AppMethodBeat.o(108489);
  }
  
  public final void k(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(108490);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA()) {
      com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjv.add(paramIOnStorageChange);
    }
    AppMethodBeat.o(108490);
  }
  
  public final EmojiInfo o(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(108450);
    paramString = a(paramString, "", paramInt1, paramInt2, paramInt3, "");
    AppMethodBeat.o(108450);
    return paramString;
  }
  
  public final EmojiInfo p(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108442);
    Object localObject = paramEmojiInfo;
    if (com.tencent.mm.plugin.emoji.g.d.A(paramEmojiInfo))
    {
      Cursor localCursor = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.azh(Util.getInt(paramEmojiInfo.getContent(), 0));
      EmojiInfo localEmojiInfo = paramEmojiInfo;
      if (localCursor != null)
      {
        localEmojiInfo = paramEmojiInfo;
        if (localCursor.getCount() > 1)
        {
          int i = Util.getIntRandom(localCursor.getCount() - 1, 0);
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
    AppMethodBeat.o(108442);
    return localObject;
  }
  
  public final int q(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108465);
    if (paramEmojiInfo != null)
    {
      int i;
      if ((paramEmojiInfo.field_catalog == EmojiInfo.aklK) || (String.valueOf(EmojiInfo.aklK).equals(paramEmojiInfo.field_groupId)))
      {
        i = h.d.jsb;
        AppMethodBeat.o(108465);
        return i;
      }
      if ((paramEmojiInfo.field_catalog == EmojiInfo.aklL) || (String.valueOf(EmojiInfo.aklL).equals(paramEmojiInfo.field_groupId)))
      {
        i = h.d.dice;
        AppMethodBeat.o(108465);
        return i;
      }
    }
    AppMethodBeat.o(108465);
    return 0;
  }
  
  public final int[] r(EmojiInfo paramEmojiInfo)
  {
    if (paramEmojiInfo != null)
    {
      if (paramEmojiInfo.field_catalog == EmojiInfo.aklK) {
        return new int[] { h.d.jsb_j, h.d.jsb_s, h.d.jsb_b };
      }
      if (paramEmojiInfo.field_catalog == EmojiInfo.aklL) {
        return new int[] { h.d.dice_action_0, h.d.dice_action_1, h.d.dice_action_2, h.d.dice_action_3 };
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
      localObject = aoe(paramEmojiInfo.field_md5);
      if ((localObject != null) && (((EmojiInfo)localObject).field_reserved4 != paramEmojiInfo.field_reserved4)) {
        paramEmojiInfo.field_reserved4 = ((EmojiInfo)localObject).field_reserved4;
      }
    }
    paramEmojiInfo = com.tencent.mm.emoji.decode.a.aUc().a(paramEmojiInfo);
    if (ImgUtil.isWXGF(paramEmojiInfo))
    {
      localObject = MMWXGFJNI.nativeWxamToGif(paramEmojiInfo);
      if (Util.isNullOrNil((byte[])localObject)) {
        Log.w("MicroMsg.emoji.EmojiMgrImpl", "decodeAsGif: wxam to gif error");
      }
      for (;;)
      {
        AppMethodBeat.o(108467);
        return localObject;
        Log.i("MicroMsg.emoji.EmojiMgrImpl", "decodeAsGif: %s, %s", new Object[] { Integer.valueOf(paramEmojiInfo.length), Integer.valueOf(localObject.length) });
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
    ((List)localObject).add(paramEmojiInfo.getMd5());
    ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiStorageMgr().adju.V(1, (List)localObject);
    ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiStorageMgr().adju.M(paramEmojiInfo);
    paramEmojiInfo = new ed();
    paramEmojiInfo.hDT.type = 2;
    paramEmojiInfo.publish();
    if (!paramEmojiInfo.hDU.hDV)
    {
      paramEmojiInfo = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiStorageMgr().adjx.jdK();
      if (paramEmojiInfo != null)
      {
        localObject = paramEmojiInfo.abCG.iterator();
        while (((Iterator)localObject).hasNext())
        {
          fdd localfdd = (fdd)((Iterator)localObject).next();
          if (localfdd.ProductID.equals(String.valueOf("capture"))) {
            localfdd.crs = 0;
          }
        }
      }
      ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiStorageMgr().adjx.a(paramEmojiInfo);
      com.tencent.mm.cc.a.iRg();
      paramEmojiInfo = com.tencent.mm.cc.a.aclv;
      a.b.btU(String.valueOf("capture"));
    }
    AppMethodBeat.o(108502);
  }
  
  public final void updateEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108452);
    com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.M(paramEmojiInfo);
    AppMethodBeat.o(108452);
  }
  
  public final boolean y(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(108446);
    if (paramContext == null)
    {
      Log.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: context is null");
      AppMethodBeat.o(108446);
      return false;
    }
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      Log.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: userName or imgPath is null");
      AppMethodBeat.o(108446);
      return false;
    }
    EmojiInfo localEmojiInfo = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.bza(paramString2);
    if (localEmojiInfo == null)
    {
      Log.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: emoji not found, imgPath %s", new Object[] { paramString2 });
      AppMethodBeat.o(108446);
      return false;
    }
    if ((localEmojiInfo.field_type == EmojiInfo.aklQ) || (localEmojiInfo.field_type == EmojiInfo.aklR))
    {
      paramContext = new WXMediaMessage();
      paramString2 = localEmojiInfo.kMn();
      if (com.tencent.mm.vfs.y.ZC(localEmojiInfo.kMo())) {
        paramContext.thumbData = com.tencent.mm.vfs.y.bi(localEmojiInfo.kMo(), 0, -1);
      }
      for (;;)
      {
        paramContext.mediaObject = new WXEmojiObject(paramString2);
        paramString2 = new wm();
        paramString2.hZZ.hzF = paramContext;
        paramString2.hZZ.appId = localEmojiInfo.field_app_id;
        paramString2.hZZ.appName = null;
        paramString2.hZZ.toUser = paramString1;
        paramString2.hZZ.hKZ = 0;
        paramString2.hZZ.iac = localEmojiInfo.getMd5();
        paramString2.publish();
        AppMethodBeat.o(108446);
        return true;
        paramContext.setThumbImage(localEmojiInfo.kMc());
      }
    }
    paramString2 = localEmojiInfo;
    if (localEmojiInfo.field_type == EmojiInfo.aklN)
    {
      if (!EmojiInfo.aNG(localEmojiInfo.field_catalog)) {
        break label367;
      }
      paramContext = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.azh(localEmojiInfo.field_catalog);
    }
    for (;;)
    {
      paramString2 = localEmojiInfo;
      if (paramContext != null)
      {
        int i = Util.getIntRandom(paramContext.getCount() - 1, 0);
        paramString2 = new EmojiInfo();
        paramContext.moveToPosition(i);
        paramString2.convertFrom(paramContext);
        paramContext.close();
      }
      if (au.bwZ(paramString1))
      {
        com.tencent.mm.plugin.emoji.model.s.dAk().b(paramString1, paramString2, null);
        break;
        label367:
        if ((localEmojiInfo.field_catalog != EmojiInfo.aklI) || (localEmojiInfo.getContent().length() <= 0) || (!EmojiInfo.aNG(Util.getInt(localEmojiInfo.getContent(), 0)))) {
          break label438;
        }
        paramContext = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.azh(Util.getInt(localEmojiInfo.getContent(), 0));
        continue;
      }
      com.tencent.mm.plugin.emoji.model.s.dAj().a(paramString1, paramString2, null);
      break;
      label438:
      paramContext = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.mgr.f
 * JD-Core Version:    0.7.0.1
 */