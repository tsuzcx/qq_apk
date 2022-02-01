package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.q;
import com.tencent.mm.ch.a.b;
import com.tencent.mm.emoji.loader.d.i.a;
import com.tencent.mm.f.a.bu;
import com.tencent.mm.f.a.bu.a;
import com.tencent.mm.f.a.dt;
import com.tencent.mm.f.a.dt.b;
import com.tencent.mm.f.a.uw;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.f.l;
import com.tencent.mm.plugin.emoji.i.d;
import com.tencent.mm.plugin.emoji.i.h;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.d.2;
import com.tencent.mm.plugin.emoji.model.p;
import com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI;
import com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.pluginsdk.k.a.a.m;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.eiv;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.sdk.event.EventCenter;
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
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bf.a;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.storage.emotion.s;
import com.tencent.mm.storage.emotion.w;
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
    EmojiInfo localEmojiInfo = p.getEmojiStorageMgr().VFH.bxK(paramString1);
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
      if (ab.Lj(paramString4))
      {
        paramString1 = bq.RL(paramString5);
        localIntent.putExtra("room_id", paramString6);
      }
      localIntent.putExtra("msg_sender", paramString1);
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString1.aFh(), "com/tencent/mm/plugin/emoji/mgr/EmojiMgrImpl", "showEmoji", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString1.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/emoji/mgr/EmojiMgrImpl", "showEmoji", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(108448);
      return;
      localIntent.putExtra("custom_smiley_preview_appid", localEmojiInfo.field_app_id);
    }
  }
  
  public static void auq(String paramString)
  {
    AppMethodBeat.i(257846);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.emoji.EmojiMgrImpl", "doSceneGetEmotionDesc get emotion desc faild.");
      AppMethodBeat.o(257846);
      return;
    }
    paramString = new l(paramString);
    com.tencent.mm.kernel.h.aHF().kcd.a(paramString, 0);
    AppMethodBeat.o(257846);
  }
  
  public static String cUn()
  {
    AppMethodBeat.i(257827);
    String str = "https://" + WeChatHosts.domainString(i.h.host_support_weixin_qq_com) + "/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0";
    AppMethodBeat.o(257827);
    return str;
  }
  
  private static void dz(String paramString, int paramInt)
  {
    AppMethodBeat.i(108445);
    com.tencent.mm.f.a.v localv = new com.tencent.mm.f.a.v();
    localv.fvq.fvr = paramString;
    localv.fvq.status = paramInt;
    localv.fvq.percentage = 0;
    EventCenter.instance.publish(localv);
    Log.d("MicroMsg.emoji.EmojiMgrImpl", "attachid:%s percentage:%d status:%d", new Object[] { paramString, Integer.valueOf(0), Integer.valueOf(paramInt) });
    AppMethodBeat.o(108445);
  }
  
  public final boolean V(ArrayList<SmileyInfo> paramArrayList)
  {
    AppMethodBeat.i(108472);
    boolean bool = p.getEmojiStorageMgr().VFP.bC(paramArrayList);
    AppMethodBeat.o(108472);
    return bool;
  }
  
  public final boolean W(ArrayList<SmileyPanelConfigInfo> paramArrayList)
  {
    AppMethodBeat.i(108473);
    com.tencent.mm.storage.emotion.u localu = p.getEmojiStorageMgr().VFQ;
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      Log.i("MicroMsg.emoji.SmileyPanelConfigInfoStorage", "insertSmileyConfigInfoList failed. list is null.");
      AppMethodBeat.o(108473);
      return false;
    }
    Log.i("MicroMsg.emoji.SmileyPanelConfigInfoStorage", "insertSmileyConfigInfoList: %s", new Object[] { Integer.valueOf(paramArrayList.size()) });
    com.tencent.mm.storagebase.h localh;
    long l;
    if ((localu.db instanceof com.tencent.mm.storagebase.h))
    {
      localh = (com.tencent.mm.storagebase.h)localu.db;
      l = localh.beginTransaction(Thread.currentThread().getId());
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
  
  public final EmojiInfo a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    AppMethodBeat.i(108451);
    paramString1 = p.getEmojiStorageMgr().VFH.e(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3);
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
  
  public final void a(Context paramContext, ca paramca, String paramString)
  {
    AppMethodBeat.i(108444);
    if ((paramContext == null) || (paramca == null))
    {
      Log.w("MicroMsg.emoji.EmojiMgrImpl", "context or msg is null");
      AppMethodBeat.o(108444);
      return;
    }
    be localbe = be.bwQ(paramca.field_content);
    Object localObject2 = k.b.OQ(paramca.field_content);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new k.b();
      ((k.b)localObject1).llZ = localbe.md5;
    }
    localObject2 = p.getEmojiStorageMgr().VFH.bxK(((k.b)localObject1).llZ);
    if ((localObject2 != null) && (((EmojiInfo)localObject2).hBp()))
    {
      if (paramca.field_isSend == 1)
      {
        a(paramContext, ((k.b)localObject1).llZ, ((k.b)localObject1).appId, ((k.b)localObject1).appName, paramca.field_msgSvrId, paramca.field_talker, paramca.field_content, paramString);
        AppMethodBeat.o(108444);
        return;
      }
      a(paramContext, ((EmojiInfo)localObject2).getMd5(), ((k.b)localObject1).appId, ((k.b)localObject1).appName, paramca.field_msgSvrId, paramca.field_talker, paramca.field_content, paramString);
      AppMethodBeat.o(108444);
      return;
    }
    paramContext = p.getEmojiStorageMgr().VFH.bxK(((k.b)localObject1).llZ);
    if (paramContext == null)
    {
      paramca = ((k.b)localObject1).llZ;
      if (Util.isNullOrNil(paramca))
      {
        Log.e("MicroMsg.emoji.EmojiMgrImpl", "md5 is null.");
        AppMethodBeat.o(108444);
        return;
      }
      paramContext = new EmojiInfo();
      paramContext.field_md5 = paramca;
      paramContext.field_app_id = ((k.b)localObject1).appId;
      paramContext.field_catalog = EmojiInfo.YCx;
      paramContext.field_size = ((k.b)localObject1).llX;
      paramContext.field_temp = 1;
      paramContext.field_state = EmojiInfo.ZuH;
      p.getEmojiStorageMgr().VFH.L(paramContext);
    }
    for (;;)
    {
      dz(paramContext.field_md5, 0);
      Log.d("MicroMsg.emoji.EmojiMgrImpl", "start change cdn url. md5:%s", new Object[] { paramContext.field_md5 });
      paramca = paramContext.field_md5;
      paramString = com.tencent.mm.emoji.loader.e.jGI;
      com.tencent.mm.emoji.loader.e.a(paramContext, true, new i.a()
      {
        public final void ep(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(108439);
          if (paramAnonymousBoolean)
          {
            f.dA(this.lQU, 1);
            AppMethodBeat.o(108439);
            return;
          }
          f.dA(this.lQU, 2);
          AppMethodBeat.o(108439);
        }
      });
      AppMethodBeat.o(108444);
      return;
    }
  }
  
  public final void a(com.tencent.mm.emoji.sync.a parama)
  {
    AppMethodBeat.i(257842);
    p.cUP().c(parama);
    AppMethodBeat.o(257842);
  }
  
  public final void a(String paramString, EmojiInfo paramEmojiInfo, ca paramca)
  {
    AppMethodBeat.i(108447);
    if ((paramEmojiInfo == null) && (paramca == null))
    {
      AppMethodBeat.o(108447);
      return;
    }
    EmojiInfo localEmojiInfo = paramEmojiInfo;
    if (paramEmojiInfo == null) {
      localEmojiInfo = p.getEmojiStorageMgr().VFH.bxK(paramca.field_imgPath);
    }
    if (as.bvS(paramString))
    {
      p.cUN().b(paramString, localEmojiInfo, paramca);
      AppMethodBeat.o(108447);
      return;
    }
    p.cUM().a(paramString, localEmojiInfo, paramca);
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
    paramEmojiInfo = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramEmojiInfo.aFh(), "com/tencent/mm/plugin/emoji/mgr/EmojiMgrImpl", "saveCustomEmoji", "(Landroid/content/Context;Lcom/tencent/mm/storage/emotion/EmojiInfo;ILjava/lang/String;IZZZLjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramEmojiInfo.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/emoji/mgr/EmojiMgrImpl", "saveCustomEmoji", "(Landroid/content/Context;Lcom/tencent/mm/storage/emotion/EmojiInfo;ILjava/lang/String;IZZZLjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(108443);
    return true;
  }
  
  public final boolean a(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(108468);
    paramBoolean = com.tencent.mm.emoji.decode.a.aBf().a(paramEmojiInfo, paramBoolean);
    AppMethodBeat.o(108468);
    return paramBoolean;
  }
  
  public final boolean a(String paramString1, String paramString2, long paramLong, String paramString3, h.a parama)
  {
    AppMethodBeat.i(108455);
    if (as.bvS(paramString1))
    {
      localObject = p.cUN();
      paramString2 = bi.bk(paramString1, paramString2, paramString3);
      if (paramString2 == null) {
        Log.i("MicroMsg.emoji.EmojiBypService", "prepareEmoji failed. emoji msg info is null.");
      }
      for (;;)
      {
        AppMethodBeat.o(108455);
        return true;
        paramString2.fNu = paramLong;
        Log.i("MicroMsg.emoji.EmojiBypService", "prepareEmoji msgSvrId[%d], stack[%s]", new Object[] { Long.valueOf(paramLong), Util.getStack() });
        paramString1 = paramString2.productId;
        com.tencent.mm.kernel.h.aHJ().postToWorker(new d.2((com.tencent.mm.plugin.emoji.model.d)localObject, paramString1));
        if (paramString2 != null) {
          break;
        }
        Log.w("MicroMsg.emoji.EmojiBypService", "downloadEmoji msginfo is null.");
      }
      if ((parama != null) && (parama.jQG != null) && (parama.jQG.HlH == paramString2.fNu))
      {
        paramString2.hxx = bq.d(parama);
        paramString2.mkX = parama.jQG.RIK;
        paramString2.createTime = parama.jQG.CreateTime;
      }
      paramString1 = p.getEmojiStorageMgr().VFH.bxK(paramString2.md5);
      if (paramString1 != null)
      {
        Log.i("MicroMsg.emoji.EmojiBypService", "downloadEmoji: db emoji info not null %s msgInfomd5 %s svrId %s", new Object[] { paramString1.field_md5, paramString2.md5, Long.valueOf(paramString2.fNu) });
        com.tencent.mm.plugin.emoji.i.b.b(paramString2, paramString1);
        p.getEmojiStorageMgr().VFH.M(paramString1);
      }
      for (;;)
      {
        if (paramString2.VFD) {
          com.tencent.mm.plugin.emoji.model.d.a(paramString2, paramString1, parama);
        }
        Log.i("MicroMsg.emoji.EmojiBypService", "start download emoji %s, fileExist %b", new Object[] { paramString1.getMd5(), Boolean.valueOf(paramString1.hBp()) });
        if (paramString1.hBp()) {
          break;
        }
        Log.i("MicroMsg.emoji.EmojiBypService", "cdnurl and cncrypt url is null. ");
        com.tencent.mm.plugin.emoji.model.d.b(paramString2);
        break;
        Log.i("MicroMsg.emoji.EmojiBypService", "downloadEmoji: create emoji info %s", new Object[] { paramString2.md5 });
        paramString1 = com.tencent.mm.plugin.emoji.model.d.a(paramString2);
      }
    }
    Object localObject = p.cUM();
    paramString1 = bi.bk(paramString1, paramString2, paramString3);
    if (paramString1 == null)
    {
      Log.i("MicroMsg.emoji.EmojiService", "prepareEmoji failed. emoji msg info is null.");
      AppMethodBeat.o(108455);
      return true;
    }
    paramString1.fNu = paramLong;
    Log.i("MicroMsg.emoji.EmojiService", "summerbadcr prepareEmoji msgSvrId[%d], stack[%s]", new Object[] { Long.valueOf(paramLong), Util.getStack() });
    ((com.tencent.mm.plugin.emoji.model.i)localObject).auJ(paramString1.productId);
    if (!EmojiLogic.auI(com.tencent.mm.emoji.b.o.aBV())) {}
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.plugin.emoji.model.i)localObject).a(paramString1, parama, bool);
      AppMethodBeat.o(108455);
      return true;
    }
  }
  
  public final byte[] a(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108466);
    if (paramEmojiInfo != null)
    {
      EmojiInfo localEmojiInfo = aud(paramEmojiInfo.field_md5);
      if ((localEmojiInfo != null) && (localEmojiInfo.field_reserved4 != paramEmojiInfo.field_reserved4)) {
        paramEmojiInfo.field_reserved4 = localEmojiInfo.field_reserved4;
      }
    }
    paramEmojiInfo = com.tencent.mm.emoji.decode.a.aBf().a(paramEmojiInfo);
    AppMethodBeat.o(108466);
    return paramEmojiInfo;
  }
  
  public final boolean aBZ()
  {
    AppMethodBeat.i(108492);
    boolean bool = com.tencent.mm.emoji.b.o.aBZ();
    AppMethodBeat.o(108492);
    return bool;
  }
  
  public final boolean aCa()
  {
    AppMethodBeat.i(108493);
    if ((WeChatEnvironment.hasDebugger()) || (com.tencent.mm.emoji.b.o.aCa()))
    {
      AppMethodBeat.o(108493);
      return true;
    }
    AppMethodBeat.o(108493);
    return false;
  }
  
  public final EmojiInfo aud(String paramString)
  {
    AppMethodBeat.i(108440);
    paramString = p.getEmojiStorageMgr().VFH.bxK(paramString);
    AppMethodBeat.o(108440);
    return paramString;
  }
  
  public final EmojiInfo aue(String paramString)
  {
    AppMethodBeat.i(108441);
    paramString = aud(paramString);
    AppMethodBeat.o(108441);
    return paramString;
  }
  
  public final String auf(String paramString)
  {
    AppMethodBeat.i(108453);
    paramString = EmojiLogic.auf(paramString);
    AppMethodBeat.o(108453);
    return paramString;
  }
  
  public final List<EmojiInfo> aug(String paramString)
  {
    AppMethodBeat.i(108456);
    if (com.tencent.mm.kernel.h.aHG().isSDCardAvailable())
    {
      paramString = (ArrayList)p.getEmojiStorageMgr().VFH.aug(paramString);
      AppMethodBeat.o(108456);
      return paramString;
    }
    paramString = new ArrayList();
    AppMethodBeat.o(108456);
    return paramString;
  }
  
  public final String auh(String paramString)
  {
    AppMethodBeat.i(108458);
    paramString = p.getEmojiDescMgr().auh(paramString);
    AppMethodBeat.o(108458);
    return paramString;
  }
  
  public final boolean aui(String paramString)
  {
    AppMethodBeat.i(108459);
    if ((paramString != null) && (paramString.equals("capture")))
    {
      AppMethodBeat.o(108459);
      return true;
    }
    boolean bool = p.getEmojiStorageMgr().VFI.bxB(paramString);
    AppMethodBeat.o(108459);
    return bool;
  }
  
  public final ArrayList<String> auj(String paramString)
  {
    AppMethodBeat.i(108460);
    bf localbf = p.getEmojiDescMgr();
    if (!localbf.mInit) {
      localbf.hyS();
    }
    long l = System.currentTimeMillis();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    if (!localbf.mInit) {
      localbf.hyS();
    }
    if (com.tencent.mm.ui.tools.g.bAB(paramString) > localbf.VFd) {
      Log.i("MicroMsg.emoji.EmojiDescNewMgr", "input text over checkout limit.");
    }
    for (;;)
    {
      paramString = localArrayList3.iterator();
      while (paramString.hasNext())
      {
        Object localObject = (String)paramString.next();
        localObject = (ArrayList)localbf.VFh.get(localObject);
        if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
          localArrayList1.addAll((Collection)localObject);
        }
      }
      if ((!Util.isNullOrNil(paramString)) && (localbf.VFh != null))
      {
        paramString = paramString.toLowerCase();
        if (localbf.VFg.containsKey(paramString))
        {
          paramString = (String)localbf.VFg.get(paramString);
          paramString = (List)localbf.VFf.get(paramString);
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
      Collections.sort(localArrayList1, localbf.VFi);
      int i = 0;
      while (i < localArrayList1.size())
      {
        localArrayList2.add(((bf.a)localArrayList1.get(i)).md5);
        i += 1;
      }
    }
    Log.d("MicroMsg.emoji.EmojiDescNewMgr", "cpan[check desc]User time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(108460);
    return localArrayList2;
  }
  
  public final String auk(String paramString)
  {
    AppMethodBeat.i(108461);
    paramString = EmojiLogic.auk(paramString);
    AppMethodBeat.o(108461);
    return paramString;
  }
  
  public final String aul(String paramString)
  {
    AppMethodBeat.i(108462);
    paramString = EmojiLogic.aul(paramString);
    AppMethodBeat.o(108462);
    return paramString;
  }
  
  public final int aum(String paramString)
  {
    AppMethodBeat.i(108463);
    int i = EmojiLogic.aum(paramString);
    AppMethodBeat.o(108463);
    return i;
  }
  
  public final String aun(String paramString)
  {
    AppMethodBeat.i(108464);
    paramString = EmojiLogic.aun(paramString);
    AppMethodBeat.o(108464);
    return paramString;
  }
  
  public final void auo(String paramString)
  {
    AppMethodBeat.i(108476);
    if (Util.isNullOrNil(paramString)) {
      Log.i("MicroMsg.emoji.EmojiCommandMgr", "emoji command is null.");
    }
    Object localObject1;
    if ("sync".equalsIgnoreCase(paramString))
    {
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VgI, Boolean.TRUE);
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VgN, Boolean.TRUE);
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VgO, Boolean.TRUE);
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VgR, Long.valueOf(System.currentTimeMillis()));
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VgS, Long.valueOf(System.currentTimeMillis()));
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VgH, Long.valueOf(0L));
      new com.tencent.mm.emoji.sync.f(0).start();
      new com.tencent.mm.emoji.sync.f(1).start();
      localObject1 = new com.tencent.mm.plugin.emoji.f.o(8, null, 15, true);
      com.tencent.mm.kernel.h.aHF().kcd.a((q)localObject1, 0);
    }
    while (WeChatEnvironment.hasDebugger())
    {
      Object localObject3;
      Object localObject4;
      if ("new".equalsIgnoreCase(paramString))
      {
        com.tencent.mm.aa.c.aFn().C(262147, true);
        com.tencent.mm.kernel.h.aHG().aHp().i(208899, Boolean.TRUE);
        com.tencent.mm.kernel.h.aHG().aHp().i(229633, "http://mmbiz.qpic.cn/mmemoticon/Q3auHgzwzM5eOptD4jIj72I8icMVEKwzSYkC30IgjMvSibGfqsEdy0ibXayiaZtbibSXV5EPZEWILOvbrjjLtQ9P4QQ/0");
        com.tencent.mm.kernel.h.aHG().aHp().i(229634, System.currentTimeMillis());
        AppMethodBeat.o(108476);
        return;
        if ("rcheart".equalsIgnoreCase(paramString))
        {
          p.getEmojiStorageMgr().VFI.hBi();
        }
        else if ("recover".equalsIgnoreCase(paramString))
        {
          Log.i("MicroMsg.emoji.EmojiCommandMgr", "recover   begin");
          p.getEmojiStorageMgr().VFH.init(MMApplicationContext.getContext());
          p.getEmojiStorageMgr().VFI.init(MMApplicationContext.getContext());
          Log.i("MicroMsg.emoji.EmojiCommandMgr", "recover   end");
        }
        else if ("clean".equalsIgnoreCase(paramString))
        {
          Log.i("MicroMsg.emoji.EmojiCommandMgr", "begin clean");
          d.cUl().auc(com.tencent.mm.plugin.emoji.i.b.bcb());
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VgN, Boolean.TRUE);
          Log.i("MicroMsg.emoji.EmojiCommandMgr", "end clean");
        }
        else
        {
          if ("dump".equalsIgnoreCase(paramString))
          {
            Log.i("MicroMsg.emoji.EmojiCommandMgr", "begin dump emoji db info:");
            localObject1 = (ArrayList)p.getEmojiStorageMgr().VFI.hAV();
            if (((ArrayList)localObject1).size() > 0)
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
              localObject3 = p.getEmojiStorageMgr().VFH.getAll();
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
                break label677;
              }
              localException.close();
              AppMethodBeat.o(108476);
            }
            Log.i("MicroMsg.emoji.EmojiCommandMgr", "end dump emoji db info:");
            continue;
          }
          label677:
          if ("config".equalsIgnoreCase(paramString))
          {
            com.tencent.mm.pluginsdk.k.a.a.b.hii().g(37, 1, -1, false);
            com.tencent.mm.pluginsdk.k.a.a.b.hii().g(37, 2, -1, false);
            com.tencent.mm.pluginsdk.k.a.a.b.hii().g(37, 4, -1, false);
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VgZ, Integer.valueOf(0));
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vha, Integer.valueOf(0));
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vhc, Integer.valueOf(0));
            localObject1 = new m(37);
            com.tencent.mm.kernel.h.aHF().kcd.a((q)localObject1, 0);
            com.tencent.mm.vfs.u.deleteFile(com.tencent.mm.cl.b.UXV);
          }
          else if ("tuzki".equalsIgnoreCase(paramString))
          {
            com.tencent.mm.plugin.emoji.f.a.cUV();
            com.tencent.mm.plugin.emoji.f.a.cUW();
          }
          else if (paramString.startsWith("reset-first"))
          {
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vvk, Boolean.FALSE);
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vvl, Boolean.FALSE);
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vvm, Boolean.FALSE);
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vvn, Boolean.FALSE);
          }
          else if (paramString.startsWith("cleanThumb"))
          {
            localObject1 = com.tencent.mm.emoji.e.a.jPz;
            com.tencent.mm.emoji.e.a.aDF();
            Toast.makeText(MMApplicationContext.getContext(), "clean thumb done", 0).show();
          }
        }
      }
      else
      {
        if ("free".equalsIgnoreCase(paramString))
        {
          com.tencent.mm.aa.c.aFn().C(262149, true);
          com.tencent.mm.kernel.h.aHG().aHp().i(208913, Boolean.TRUE);
          com.tencent.mm.kernel.h.aHG().aHp().i(229633, "http://mmbiz.qpic.cn/mmemoticon/Q3auHgzwzM5eOptD4jIj72I8icMVEKwzSYkC30IgjMvSibGfqsEdy0ibXayiaZtbibSXV5EPZEWILOvbrjjLtQ9P4QQ/0");
          com.tencent.mm.kernel.h.aHG().aHp().i(229634, System.currentTimeMillis());
          AppMethodBeat.o(108476);
          return;
        }
        if ("newp".equalsIgnoreCase(paramString))
        {
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VgM, Boolean.TRUE);
          AppMethodBeat.o(108476);
          return;
        }
        if ("newpe".equalsIgnoreCase(paramString))
        {
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VgQ, Boolean.TRUE);
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
          paramString = new com.tencent.mm.plugin.emoji.f.c(0, 1, Arrays.asList(paramString.replace("backup", "").trim().split(",")));
          com.tencent.mm.kernel.h.aHF().kcd.a(paramString, 0);
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
          Log.i("MicroMsg.emoji.EmojiCommandMgr", com.tencent.mm.vfs.u.buc(paramString));
          Log.i("MicroMsg.emoji.EmojiCommandMgr", MD5Util.getMD5String(paramString));
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("recommend"))
        {
          paramString = com.tencent.mm.plugin.emoji.g.d.auN("<NewRecommendEmotion><Emotion><ProductID>com.tencent.xin.emoticon.person.stiker_144984189945aa5830d33cd7dc</ProductID><RecType>3</RecType><Name>野萌君</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/duc2TvpEgSTWy4k8MnuicFjyiazriaGWDX52HzNWeLVTjtJcjZeZEicTn5kJFPYdicWZTuUZJgiaADK9I/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/DhduwiaBa7lchicgAfwibeykm81eGWXkMDgGJ8DWcOcIc28C7oTic4Y09Pick8Fw69KiaZVxrHl8S2lPY/0</Panel><ButtonType>1</ButtonType></Emotion><Emotion><ProductID>com.tencent.xin.emoticon.person.stiker_14389422638f6ca818af405e21</ProductID><RecType>3</RecType><Name>猪仔和羊妹</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/iaUiazNVkRp7iaZjrMuYgfH8kB5xkyYv20CYzY3W9HCLBr2XybJibGKKtXibMnAfZnRTH/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/PiajxSqBRaEJR9canNKZ7RYI3hx5BPCSwQmuhhlNWD1jzUSOx3CWqEtibd65zOjySd/0</Panel><ButtonType>1</ButtonType></Emotion><Emotion><ProductID>com.tencent.xin.emoticon.person.stiker_1444199720f5ea147582ff0512</ProductID><RecType>3</RecType><Name>让红包飞</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/nMl9ssowtibXLY57PdK8Nsh827vlsw4TGHPgLUehd2R455xnwe3xpoVDIKpAuXU1Aic3XbH1LfMr7fp4DgO7o8IQ/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/duc2TvpEgST18reErFRzNFR8EiahI4Iibp4ZnW1ibJYt4MMLvQvjx3sHGTMuTOgnREq5f2GXLhuzalOOz3icw9NGbA/0</Panel><ButtonType>1</ButtonType></Emotion><Emotion><ProductID>com.tencent.xin.emoticon.xiaobendan</ProductID><RecType>3</RecType><Name>小笨蛋与大坏蛋</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/ajNVdqHZLLC8ILTt0pqcaCVkldLMydoNJcupoR7qUojia3vKlgd74uQ/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/ajNVdqHZLLC8ILTt0pqcaAAEUI4a7z5ECqpUXbQw95PY1mpc4p0FxA/0</Panel><ButtonType>1</ButtonType></Emotion><Emotion><ProductID>com.tencent.xin.emoticon.shin2</ProductID><RecType>3</RecType><Name>野原新之助2</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/iciaySdkria4apGIW1wvSbPC9oxWQPHZyicaccx5JDIp2uE/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/ajNVdqHZLLASEAAX7xw76beia5j4HyA0rq9WgtgscicJo7935UCpCpog/0</Panel><ButtonType>1</ButtonType></Emotion></NewRecommendEmotion>");
          p.getEmojiStorageMgr().VFI.hBa();
          p.getEmojiStorageMgr().VFI.bz(paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("count"))
        {
          paramString = paramString.replace("count", "").trim();
          com.tencent.mm.n.h.axc().put("CustomEmojiMaxSize", paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("auto"))
        {
          paramString = paramString.replace("auto", "").trim();
          com.tencent.mm.n.h.axc().put("C2CEmojiNotAutoDownloadTimeRange", paramString);
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
          p.getEmojiStorageMgr().VFP.bC(paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("panel"))
        {
          paramString.replace("panel", "").trim();
          paramString = new bu();
          paramString.fxB.subType = 1;
          paramString.fxB.fxC = 37;
          paramString.fxB.filePath = (com.tencent.mm.loader.j.b.aSL() + "CheckResUpdate/37.1.data");
          EventCenter.instance.publish(paramString);
          paramString = new bu();
          paramString.fxB.subType = 2;
          paramString.fxB.fxC = 37;
          paramString.fxB.filePath = "/sdcard/tencent/MicroMsg/CheckResUpdate/37.2.data";
          EventCenter.instance.publish(paramString);
          paramString = new bu();
          paramString.fxB.subType = 3;
          paramString.fxB.fxC = 37;
          paramString.fxB.filePath = (com.tencent.mm.loader.j.b.aSL() + "CheckResUpdate/37.3.data");
          EventCenter.instance.publish(paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("key"))
        {
          paramString = com.tencent.mm.b.g.getMessageDigest(String.valueOf(System.currentTimeMillis()).getBytes());
          Log.i("MicroMsg.emoji.EmojiCommandMgr", "create key :%s" + Util.secPrint(paramString));
          p.getEmojiStorageMgr().VFH.asT(153);
          localObject1 = new EmojiInfo();
          ((EmojiInfo)localObject1).field_md5 = paramString;
          ((EmojiInfo)localObject1).field_catalog = 153;
          p.getEmojiStorageMgr().VFH.L((EmojiInfo)localObject1);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("delete-db"))
        {
          paramString = paramString.replace("delete-db", "").trim();
          p.getEmojiStorageMgr().VFH.du(paramString, true);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("delete-file"))
        {
          a.aua(paramString);
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
            paramString = new com.tencent.mm.plugin.emoji.f.e((LinkedList)localObject1);
            com.tencent.mm.kernel.h.aHF().kcd.a(paramString, 0);
          }
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("test"))
        {
          Log.i("MicroMsg.emoji.EmojiCommandMgr", "theTest: %s", new Object[] { paramString });
          com.tencent.e.h.ZvG.be(new a.1());
        }
      }
    }
    AppMethodBeat.o(108476);
  }
  
  public final void aup(String paramString)
  {
    AppMethodBeat.i(257845);
    com.tencent.mm.plugin.emoji.h.a locala = p.cUP();
    LinkedList localLinkedList = new LinkedList();
    if (Util.isEqual(paramString, String.valueOf(EmojiGroupInfo.YCu))) {
      localLinkedList.add(new com.tencent.mm.plugin.emoji.h.a.b("com.tencent.xin.emoticon.tusiji"));
    }
    for (;;)
    {
      locala.uGy.di(localLinkedList);
      if (!locala.uGy.uGJ) {
        locala.uGy.cVn();
      }
      AppMethodBeat.o(257845);
      return;
      localLinkedList.add(new com.tencent.mm.plugin.emoji.h.a.a(paramString));
    }
  }
  
  public final void aur(String paramString)
  {
    AppMethodBeat.i(176179);
    w localw = p.getEmojiStorageMgr().VFS;
    LinkedList localLinkedList;
    int i;
    if (!Util.isNullOrNil(paramString))
    {
      localLinkedList = localw.ESJ;
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < localw.ESJ.size())
        {
          if (Util.isEqual(((com.tencent.mm.storage.emotion.v)localw.ESJ.get(i)).key, paramString))
          {
            localv = (com.tencent.mm.storage.emotion.v)localw.ESJ.get(i);
            if (localv == null)
            {
              localv = new com.tencent.mm.storage.emotion.v();
              localv.key = paramString;
              localv.VIP += 1;
              localv.kje = System.currentTimeMillis();
              localw.ESJ.add(0, localv);
              if (localw.ESJ.size() > 9) {
                localw.ESJ.remove(localw.ESJ.size() - 1);
              }
              localw.doNotify("event_update_recent", 0, Integer.valueOf(localw.ESJ.size()));
              AppMethodBeat.o(176179);
            }
          }
          else
          {
            i += 1;
            continue;
          }
          localw.ESJ.remove(i);
          continue;
        }
        i = -1;
      }
      finally
      {
        AppMethodBeat.o(176179);
      }
      com.tencent.mm.storage.emotion.v localv = null;
    }
  }
  
  public final boolean aus(String paramString)
  {
    bool2 = false;
    AppMethodBeat.i(108499);
    com.tencent.mm.plugin.gif.f localf = new com.tencent.mm.plugin.gif.f(paramString);
    int i = (int)com.tencent.mm.vfs.u.bBQ(paramString);
    if (i != 0) {
      bool1 = bool2;
    }
    try
    {
      if (i <= com.tencent.mm.n.c.awI())
      {
        bool1 = bool2;
        if (localf.Dna[0] <= com.tencent.mm.n.c.awH())
        {
          i = localf.Dna[1];
          int j = com.tencent.mm.n.c.awH();
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
  
  public final boolean aut(String paramString)
  {
    bool2 = false;
    AppMethodBeat.i(257849);
    com.tencent.mm.plugin.gif.f localf = new com.tencent.mm.plugin.gif.f(paramString);
    int i = (int)com.tencent.mm.vfs.u.bBQ(paramString);
    if (i != 0) {
      bool1 = bool2;
    }
    try
    {
      if (i <= com.tencent.mm.n.c.awF())
      {
        bool1 = bool2;
        if (localf.Dna[0] <= com.tencent.mm.n.c.awH())
        {
          i = localf.Dna[1];
          int j = com.tencent.mm.n.c.awH();
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
    AppMethodBeat.o(257849);
    return bool1;
  }
  
  public final void auu(String paramString)
  {
    AppMethodBeat.i(108501);
    if (!Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.emoji.EmojiMgrImpl", "deleteCaptureEmoji md: ".concat(String.valueOf(paramString)));
      p.getEmojiStorageMgr().VFH.du(paramString, true);
      p.getEmojiStorageMgr().VFH.doNotify("delete_emoji_info_notify");
    }
    AppMethodBeat.o(108501);
  }
  
  public final void auv(String paramString)
  {
    AppMethodBeat.i(108503);
    EmojiInfo localEmojiInfo = aud(paramString);
    if (localEmojiInfo != null)
    {
      paramString = com.tencent.mm.emoji.d.i.jPu;
      com.tencent.mm.emoji.d.i.n(localEmojiInfo);
      AppMethodBeat.o(108503);
      return;
    }
    Log.w("MicroMsg.emoji.EmojiMgrImpl", "addCaptureEmojiUploadTask: emojiInfo null by md5 %s", new Object[] { paramString });
    AppMethodBeat.o(108503);
  }
  
  public final void b(com.tencent.mm.emoji.sync.a parama)
  {
    AppMethodBeat.i(257843);
    p.cUP().d(parama);
    AppMethodBeat.o(257843);
  }
  
  public final <T> T c(ar.a parama, T paramT)
  {
    AppMethodBeat.i(108497);
    parama = com.tencent.mm.kernel.h.aHG().aHp().get(parama, paramT);
    AppMethodBeat.o(108497);
    return parama;
  }
  
  public final boolean cUm()
  {
    AppMethodBeat.i(108469);
    boolean bool = com.tencent.mm.emoji.b.o.aBS();
    AppMethodBeat.o(108469);
    return bool;
  }
  
  public final ArrayList<SmileyInfo> cUo()
  {
    AppMethodBeat.i(108470);
    ArrayList localArrayList = p.getEmojiStorageMgr().VFP.cUo();
    AppMethodBeat.o(108470);
    return localArrayList;
  }
  
  public final ArrayList<SmileyPanelConfigInfo> cUp()
  {
    AppMethodBeat.i(108471);
    ArrayList localArrayList = p.getEmojiStorageMgr().VFQ.cUp();
    AppMethodBeat.o(108471);
    return localArrayList;
  }
  
  public final com.tencent.mm.be.g cUq()
  {
    AppMethodBeat.i(108475);
    com.tencent.mm.be.g localg = h.cUA().cUq();
    AppMethodBeat.o(108475);
    return localg;
  }
  
  public final boolean cUr()
  {
    AppMethodBeat.i(108477);
    if ((WeChatEnvironment.hasDebugger()) || (com.tencent.mm.emoji.b.o.aCb()))
    {
      AppMethodBeat.o(108477);
      return true;
    }
    AppMethodBeat.o(108477);
    return false;
  }
  
  public final String cUs()
  {
    AppMethodBeat.i(108478);
    h.cUA();
    String str = h.cUs();
    AppMethodBeat.o(108478);
    return str;
  }
  
  public final void cUt()
  {
    AppMethodBeat.i(108479);
    h localh = h.cUA();
    bu localbu = new bu();
    bu.a locala = localbu.fxB;
    com.tencent.mm.pluginsdk.k.a.a.b.hii();
    locala.filePath = com.tencent.mm.pluginsdk.k.a.a.b.lV(37, 1);
    localbu.fxB.fxC = 37;
    localbu.fxB.subType = 1;
    localbu.fxB.fxD = -1;
    localh.b(localbu);
    AppMethodBeat.o(108479);
  }
  
  public final void cUu()
  {
    AppMethodBeat.i(257839);
    p.cUP().cVk();
    AppMethodBeat.o(257839);
  }
  
  public final boolean cUv()
  {
    AppMethodBeat.i(257840);
    boolean bool = p.cUP().uGy.uGJ;
    AppMethodBeat.o(257840);
    return bool;
  }
  
  public final boolean cUw()
  {
    AppMethodBeat.i(108491);
    boolean bool = com.tencent.mm.emoji.b.o.aBY();
    AppMethodBeat.o(108491);
    return bool;
  }
  
  public final List<com.tencent.mm.storage.emotion.v> cUx()
  {
    AppMethodBeat.i(108495);
    List localList = p.getEmojiStorageMgr().VFS.cUx();
    AppMethodBeat.o(108495);
    return localList;
  }
  
  public final void cUy()
  {
    AppMethodBeat.i(108496);
    Object localObject = p.getEmojiStorageMgr().VFS.cUx();
    JSONArray localJSONArray = new JSONArray();
    localObject = ((List)localObject).iterator();
    do
    {
      com.tencent.mm.storage.emotion.v localv;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localv = (com.tencent.mm.storage.emotion.v)((Iterator)localObject).next();
      } while (localv.toJson() == null);
      localJSONArray.put(localv.toJson());
    } while (localJSONArray.length() < 9);
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vvh, localJSONArray.toString());
    AppMethodBeat.o(108496);
  }
  
  public final boolean cUz()
  {
    AppMethodBeat.i(108500);
    if (!com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.Vvn, true)) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.emoji.b.o.isSpringFestivalEnable();
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
      i = com.tencent.mm.n.c.awI();
      AppMethodBeat.o(108480);
      return i;
    }
    i = com.tencent.mm.n.c.awG();
    AppMethodBeat.o(108480);
    return i;
  }
  
  public final void d(ar.a parama, Object paramObject)
  {
    AppMethodBeat.i(108498);
    com.tencent.mm.kernel.h.aHG().aHp().set(parama, paramObject);
    AppMethodBeat.o(108498);
  }
  
  public final String getAccPath()
  {
    AppMethodBeat.i(108457);
    String str = com.tencent.mm.kernel.h.aHG().kcB;
    AppMethodBeat.o(108457);
    return str;
  }
  
  public final String getDataEmojiPath()
  {
    AppMethodBeat.i(257838);
    String str = h.getDataEmojiPath();
    AppMethodBeat.o(257838);
    return str;
  }
  
  public final bi gg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108449);
    Map localMap = XmlParser.parseXml(paramString1, "msg", null);
    if (localMap == null)
    {
      Log.w("MicroMsg.emoji.EmojiMgrImpl", "get from xml, but attrs is null");
      AppMethodBeat.o(108449);
      return null;
    }
    paramString2 = bi.e(localMap, paramString2, paramString1);
    if (paramString2 == null)
    {
      Log.w("MicroMsg.emoji.EmojiMgrImpl", "parserEmojiXml error ".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(108449);
      return null;
    }
    AppMethodBeat.o(108449);
    return paramString2;
  }
  
  public final String gh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108474);
    paramString1 = EmojiLogic.T(com.tencent.mm.plugin.emoji.i.b.bcb(), paramString1, paramString2);
    AppMethodBeat.o(108474);
    return paramString1;
  }
  
  public final void h(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(108487);
    p.getEmojiStorageMgr().VFH.remove(paramIOnStorageChange);
    AppMethodBeat.o(108487);
  }
  
  public final void i(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(108488);
    p.getEmojiStorageMgr().VFH.add(paramIOnStorageChange);
    AppMethodBeat.o(108488);
  }
  
  public final void j(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(108489);
    p.getEmojiStorageMgr().VFI.remove(paramIOnStorageChange);
    AppMethodBeat.o(108489);
  }
  
  public final void k(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(108490);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE()) {
      p.getEmojiStorageMgr().VFI.add(paramIOnStorageChange);
    }
    AppMethodBeat.o(108490);
  }
  
  public final EmojiInfo n(String paramString, int paramInt1, int paramInt2, int paramInt3)
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
    if (com.tencent.mm.plugin.emoji.i.b.A(paramEmojiInfo))
    {
      Cursor localCursor = p.getEmojiStorageMgr().VFH.asS(Util.getInt(paramEmojiInfo.getContent(), 0));
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
      if ((paramEmojiInfo.field_catalog == EmojiInfo.YCB) || (String.valueOf(EmojiInfo.YCB).equals(paramEmojiInfo.field_groupId)))
      {
        i = i.d.jsb;
        AppMethodBeat.o(108465);
        return i;
      }
      if ((paramEmojiInfo.field_catalog == EmojiInfo.YCC) || (String.valueOf(EmojiInfo.YCC).equals(paramEmojiInfo.field_groupId)))
      {
        i = i.d.dice;
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
      if (paramEmojiInfo.field_catalog == EmojiInfo.YCB) {
        return new int[] { i.d.jsb_j, i.d.jsb_s, i.d.jsb_b };
      }
      if (paramEmojiInfo.field_catalog == EmojiInfo.YCC) {
        return new int[] { i.d.dice_action_0, i.d.dice_action_1, i.d.dice_action_2, i.d.dice_action_3 };
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
      localObject = aud(paramEmojiInfo.field_md5);
      if ((localObject != null) && (((EmojiInfo)localObject).field_reserved4 != paramEmojiInfo.field_reserved4)) {
        paramEmojiInfo.field_reserved4 = ((EmojiInfo)localObject).field_reserved4;
      }
    }
    paramEmojiInfo = com.tencent.mm.emoji.decode.a.aBf().a(paramEmojiInfo);
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
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().VFH.A(1, (List)localObject);
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().VFH.M(paramEmojiInfo);
    paramEmojiInfo = new dt();
    paramEmojiInfo.fzk.type = 2;
    EventCenter.instance.publish(paramEmojiInfo);
    if (!paramEmojiInfo.fzl.fzm)
    {
      paramEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().VFK.hBK();
      if (paramEmojiInfo != null)
      {
        localObject = paramEmojiInfo.UkP.iterator();
        while (((Iterator)localObject).hasNext())
        {
          eiw localeiw = (eiw)((Iterator)localObject).next();
          if (localeiw.ProductID.equals(String.valueOf("capture"))) {
            localeiw.CqR = 0;
          }
        }
      }
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().VFK.a(paramEmojiInfo);
      com.tencent.mm.ch.a.hqW();
      paramEmojiInfo = com.tencent.mm.ch.a.UQl;
      a.b.btV(String.valueOf("capture"));
    }
    AppMethodBeat.o(108502);
  }
  
  public final void updateEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108452);
    p.getEmojiStorageMgr().VFH.M(paramEmojiInfo);
    AppMethodBeat.o(108452);
  }
  
  public final boolean x(Context paramContext, String paramString1, String paramString2)
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
    EmojiInfo localEmojiInfo = p.getEmojiStorageMgr().VFH.bxK(paramString2);
    if (localEmojiInfo == null)
    {
      Log.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: emoji not found, imgPath %s", new Object[] { paramString2 });
      AppMethodBeat.o(108446);
      return false;
    }
    if ((localEmojiInfo.field_type == EmojiInfo.ZuB) || (localEmojiInfo.field_type == EmojiInfo.ZuC))
    {
      paramContext = new WXMediaMessage();
      paramString2 = localEmojiInfo.ifh();
      if (com.tencent.mm.vfs.u.agG(localEmojiInfo.ifi())) {
        paramContext.thumbData = com.tencent.mm.vfs.u.aY(localEmojiInfo.ifi(), 0, -1);
      }
      for (;;)
      {
        paramContext.mediaObject = new WXEmojiObject(paramString2);
        paramString2 = new uw();
        paramString2.fUc.fvl = paramContext;
        paramString2.fUc.appId = localEmojiInfo.field_app_id;
        paramString2.fUc.appName = null;
        paramString2.fUc.toUser = paramString1;
        paramString2.fUc.fFO = 0;
        paramString2.fUc.fUf = localEmojiInfo.getMd5();
        EventCenter.instance.publish(paramString2);
        AppMethodBeat.o(108446);
        return true;
        paramContext.setThumbImage(localEmojiInfo.hBs());
      }
    }
    paramString2 = localEmojiInfo;
    if (localEmojiInfo.field_type == EmojiInfo.YCE)
    {
      if (!EmojiInfo.aAA(localEmojiInfo.field_catalog)) {
        break label370;
      }
      paramContext = p.getEmojiStorageMgr().VFH.asS(localEmojiInfo.field_catalog);
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
      if (as.bvS(paramString1))
      {
        p.cUN().b(paramString1, paramString2, null);
        break;
        label370:
        if ((localEmojiInfo.field_catalog != EmojiInfo.YCz) || (localEmojiInfo.getContent().length() <= 0) || (!EmojiInfo.aAA(Util.getInt(localEmojiInfo.getContent(), 0)))) {
          break label441;
        }
        paramContext = p.getEmojiStorageMgr().VFH.asS(Util.getInt(localEmojiInfo.getContent(), 0));
        continue;
      }
      p.cUM().a(paramString1, paramString2, null);
      break;
      label441:
      paramContext = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.f
 * JD-Core Version:    0.7.0.1
 */