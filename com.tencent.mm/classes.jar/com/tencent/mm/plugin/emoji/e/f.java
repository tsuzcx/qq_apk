package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.ca.a.b;
import com.tencent.mm.emoji.b.n;
import com.tencent.mm.emoji.loader.d.i.a;
import com.tencent.mm.g.a.bp.a;
import com.tencent.mm.g.a.do;
import com.tencent.mm.g.a.do.b;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.f.o;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.c.2;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI;
import com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.pluginsdk.j.a.a.m;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.dyv;
import com.tencent.mm.protocal.protobuf.dyw;
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
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.storage.emotion.v;
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
  implements com.tencent.mm.pluginsdk.a.d
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
    EmojiInfo localEmojiInfo = k.getEmojiStorageMgr().OpN.blk(paramString1);
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
      if (ab.Eq(paramString4))
      {
        paramString1 = com.tencent.mm.model.bp.Ks(paramString5);
        localIntent.putExtra("room_id", paramString6);
      }
      localIntent.putExtra("msg_sender", paramString1);
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.axQ(), "com/tencent/mm/plugin/emoji/mgr/EmojiMgrImpl", "showEmoji", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString1.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/emoji/mgr/EmojiMgrImpl", "showEmoji", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(108448);
      return;
      localIntent.putExtra("custom_smiley_preview_appid", localEmojiInfo.field_app_id);
    }
  }
  
  public static void amx(String paramString)
  {
    AppMethodBeat.i(240125);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.emoji.EmojiMgrImpl", "doSceneGetEmotionDesc get emotion desc faild.");
      AppMethodBeat.o(240125);
      return;
    }
    paramString = new com.tencent.mm.plugin.emoji.f.l(paramString);
    com.tencent.mm.kernel.g.aAg().hqi.a(paramString, 0);
    AppMethodBeat.o(240125);
  }
  
  public static String cFI()
  {
    AppMethodBeat.i(240123);
    String str = "https://" + WeChatHosts.domainString(2131761742) + "/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0";
    AppMethodBeat.o(240123);
    return str;
  }
  
  static void df(String paramString, int paramInt)
  {
    AppMethodBeat.i(108445);
    com.tencent.mm.g.a.u localu = new com.tencent.mm.g.a.u();
    localu.dCJ.dCK = paramString;
    localu.dCJ.status = paramInt;
    localu.dCJ.percentage = 0;
    EventCenter.instance.publish(localu);
    Log.d("MicroMsg.emoji.EmojiMgrImpl", "attachid:%s percentage:%d status:%d", new Object[] { paramString, Integer.valueOf(0), Integer.valueOf(paramInt) });
    AppMethodBeat.o(108445);
  }
  
  public final boolean V(ArrayList<SmileyInfo> paramArrayList)
  {
    AppMethodBeat.i(108472);
    boolean bool = k.getEmojiStorageMgr().OpV.bn(paramArrayList);
    AppMethodBeat.o(108472);
    return bool;
  }
  
  public final boolean W(ArrayList<SmileyPanelConfigInfo> paramArrayList)
  {
    AppMethodBeat.i(108473);
    com.tencent.mm.storage.emotion.u localu = k.getEmojiStorageMgr().OpW;
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
    paramString1 = k.getEmojiStorageMgr().OpN.e(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3);
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
    be localbe = be.bkr(paramca.field_content);
    Object localObject2 = k.b.HD(paramca.field_content);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new k.b();
      ((k.b)localObject1).iwK = localbe.md5;
    }
    localObject2 = k.getEmojiStorageMgr().OpN.blk(((k.b)localObject1).iwK);
    if ((localObject2 != null) && (((EmojiInfo)localObject2).hRx()))
    {
      if (paramca.field_isSend == 1)
      {
        a(paramContext, ((k.b)localObject1).iwK, ((k.b)localObject1).appId, ((k.b)localObject1).appName, paramca.field_msgSvrId, paramca.field_talker, paramca.field_content, paramString);
        AppMethodBeat.o(108444);
        return;
      }
      a(paramContext, ((EmojiInfo)localObject2).getMd5(), ((k.b)localObject1).appId, ((k.b)localObject1).appName, paramca.field_msgSvrId, paramca.field_talker, paramca.field_content, paramString);
      AppMethodBeat.o(108444);
      return;
    }
    paramContext = k.getEmojiStorageMgr().OpN.blk(((k.b)localObject1).iwK);
    if (paramContext == null)
    {
      paramca = ((k.b)localObject1).iwK;
      if (Util.isNullOrNil(paramca))
      {
        Log.e("MicroMsg.emoji.EmojiMgrImpl", "md5 is null.");
        AppMethodBeat.o(108444);
        return;
      }
      paramContext = new EmojiInfo();
      paramContext.field_md5 = paramca;
      paramContext.field_app_id = ((k.b)localObject1).appId;
      paramContext.field_catalog = EmojiInfo.Uup;
      paramContext.field_size = ((k.b)localObject1).iwI;
      paramContext.field_temp = 1;
      paramContext.field_state = EmojiInfo.UuF;
      k.getEmojiStorageMgr().OpN.K(paramContext);
    }
    for (;;)
    {
      df(paramContext.field_md5, 0);
      Log.d("MicroMsg.emoji.EmojiMgrImpl", "start change cdn url. md5:%s", new Object[] { paramContext.field_md5 });
      paramca = paramContext.field_md5;
      paramString = com.tencent.mm.emoji.loader.e.gVM;
      com.tencent.mm.emoji.loader.e.a(paramContext, true, new i.a()
      {
        public final void dQ(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(108439);
          if (paramAnonymousBoolean)
          {
            f.df(this.lhI, 1);
            AppMethodBeat.o(108439);
            return;
          }
          f.df(this.lhI, 2);
          AppMethodBeat.o(108439);
        }
      });
      AppMethodBeat.o(108444);
      return;
    }
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
      localEmojiInfo = k.getEmojiStorageMgr().OpN.blk(paramca.field_imgPath);
    }
    if (as.bjw(paramString))
    {
      k.cGe().b(paramString, localEmojiInfo, paramca);
      AppMethodBeat.o(108447);
      return;
    }
    k.cGd().a(paramString, localEmojiInfo, paramca);
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
    paramEmojiInfo = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramEmojiInfo.axQ(), "com/tencent/mm/plugin/emoji/mgr/EmojiMgrImpl", "saveCustomEmoji", "(Landroid/content/Context;Lcom/tencent/mm/storage/emotion/EmojiInfo;ILjava/lang/String;IZZZLjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramEmojiInfo.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/emoji/mgr/EmojiMgrImpl", "saveCustomEmoji", "(Landroid/content/Context;Lcom/tencent/mm/storage/emotion/EmojiInfo;ILjava/lang/String;IZZZLjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(108443);
    return true;
  }
  
  public final boolean a(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(108468);
    paramBoolean = com.tencent.mm.emoji.decode.a.aum().a(paramEmojiInfo, paramBoolean);
    AppMethodBeat.o(108468);
    return paramBoolean;
  }
  
  public final boolean a(String paramString1, String paramString2, long paramLong, String paramString3, h.a parama)
  {
    AppMethodBeat.i(108455);
    if (as.bjw(paramString1))
    {
      localObject = k.cGe();
      paramString2 = bi.bp(paramString1, paramString2, paramString3);
      if (paramString2 == null) {
        Log.i("MicroMsg.emoji.EmojiBypService", "prepareEmoji failed. emoji msg info is null.");
      }
      for (;;)
      {
        AppMethodBeat.o(108455);
        return true;
        paramString2.dTS = paramLong;
        Log.i("MicroMsg.emoji.EmojiBypService", "prepareEmoji msgSvrId[%d], stack[%s]", new Object[] { Long.valueOf(paramLong), Util.getStack() });
        paramString1 = paramString2.productId;
        com.tencent.mm.kernel.g.aAk().postToWorker(new c.2((com.tencent.mm.plugin.emoji.model.c)localObject, paramString1));
        if (paramString2 != null) {
          break;
        }
        Log.w("MicroMsg.emoji.EmojiBypService", "downloadEmoji msginfo is null.");
      }
      if ((parama != null) && (parama.heO != null) && (parama.heO.Brn == paramString2.dTS))
      {
        paramString2.fqJ = com.tencent.mm.model.bp.d(parama);
        paramString2.jvu = parama.heO.KHs;
        paramString2.createTime = parama.heO.CreateTime;
      }
      paramString1 = k.getEmojiStorageMgr().OpN.blk(paramString2.md5);
      label250:
      int i;
      if (paramString1 != null)
      {
        Log.i("MicroMsg.emoji.EmojiBypService", "downloadEmoji: db emoji info not null %s msgInfomd5 %s svrId %s", new Object[] { paramString1.field_md5, paramString2.md5, Long.valueOf(paramString2.dTS) });
        com.tencent.mm.plugin.emoji.h.b.b(paramString2, paramString1);
        k.getEmojiStorageMgr().OpN.L(paramString1);
        if (paramString2.OpK)
        {
          Log.i("MicroMsg.emoji.EmojiBypService", "insertEmojiMsg: %s, %s msgSvrId: %s", new Object[] { paramString2.md5, paramString1.field_md5, Long.valueOf(paramString2.dTS) });
          if ((paramString2.dTS == 0L) || (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aJ(paramString2.talker, paramString2.dTS).field_msgSvrId != paramString2.dTS))
          {
            paramString3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramString2.talker);
            if ((paramString3 == null) || ((int)paramString3.gMZ == 0))
            {
              paramString3 = new as(paramString2.talker);
              paramString3.setType(2);
              ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().ap(paramString3);
            }
            paramString3 = new ca();
            paramString3.setType(47);
            paramString3.Cy(paramString2.talker);
            if (!z.Im(paramString2.jsh)) {
              break label855;
            }
            i = 1;
            label459:
            paramString3.nv(i);
            paramString3.Cz(paramString1.getMd5());
            paramString3.yF(paramString2.dTS);
            localObject = paramString2.jsh;
            if ((paramString1.NA()) || (paramString1.isGif())) {
              break label861;
            }
            bool = true;
            label507:
            paramString3.setContent(be.a((String)localObject, 0L, bool, paramString1.getMd5(), false, paramString2.OpG));
            paramString3.setCreateTime(com.tencent.mm.model.bp.C(paramString3.field_talker, paramString2.createTime));
            paramString3.setStatus(3);
            if (!Util.isNullOrNil(paramString2.fqK)) {
              paramString3.BB(paramString2.fqK);
            }
            if (parama != null) {
              break label867;
            }
            i = paramString2.fqJ;
            if (i != 0)
            {
              paramString3.setFlag(i);
              if ((paramString3.field_msgId == 0L) && (paramString3.field_isSend == 0) && ((i & 0x2) != 0)) {
                paramString3.setCreateTime(paramString2.createTime);
              }
            }
            if (paramString2.jvu != 0) {
              paramString3.yH(paramString2.jvu);
            }
            Log.i("MicroMsg.emoji.EmojiBypService", "summerbadcr insertEmojiMsg addMsgInfo is null but flag[%d], msgSeq[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramString2.jvu) });
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.model.bp.x(paramString3);
        Log.i("MicroMsg.emoji.EmojiBypService", "start download emoji %s, fileExist %b", new Object[] { paramString1.getMd5(), Boolean.valueOf(paramString1.hRx()) });
        if (paramString1.hRx()) {
          break;
        }
        Log.i("MicroMsg.emoji.EmojiBypService", "cdnurl and cncrypt url is null. ");
        if (paramString2 == null) {
          break;
        }
        ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(new i.c(paramString2.talker, "update", null));
        break;
        Log.i("MicroMsg.emoji.EmojiBypService", "downloadEmoji: create emoji info %s", new Object[] { paramString2.md5 });
        Log.i("MicroMsg.emoji.EmojiBypService", "createEmojiInfo: %s", new Object[] { paramString2.md5 });
        paramString1 = new EmojiInfo();
        com.tencent.mm.plugin.emoji.h.b.b(paramString2, paramString1);
        paramString1.field_temp = 1;
        paramString1.field_state = EmojiInfo.UuF;
        paramString1.field_catalog = EmojiInfo.Uup;
        k.getEmojiStorageMgr().OpN.J(paramString1);
        break label250;
        label855:
        i = 0;
        break label459;
        label861:
        bool = false;
        break label507;
        label867:
        com.tencent.mm.model.bp.a(paramString3, parama);
      }
    }
    Object localObject = k.cGd();
    paramString1 = bi.bp(paramString1, paramString2, paramString3);
    if (paramString1 == null)
    {
      Log.i("MicroMsg.emoji.EmojiService", "prepareEmoji failed. emoji msg info is null.");
      AppMethodBeat.o(108455);
      return true;
    }
    paramString1.dTS = paramLong;
    Log.i("MicroMsg.emoji.EmojiService", "summerbadcr prepareEmoji msgSvrId[%d], stack[%s]", new Object[] { Long.valueOf(paramLong), Util.getStack() });
    ((com.tencent.mm.plugin.emoji.model.d)localObject).amP(paramString1.productId);
    if (!EmojiLogic.amO(n.ava())) {}
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.plugin.emoji.model.d)localObject).a(paramString1, parama, bool);
      AppMethodBeat.o(108455);
      return true;
    }
  }
  
  public final byte[] a(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108466);
    if (paramEmojiInfo != null)
    {
      EmojiInfo localEmojiInfo = aml(paramEmojiInfo.field_md5);
      if ((localEmojiInfo != null) && (localEmojiInfo.field_reserved4 != paramEmojiInfo.field_reserved4)) {
        paramEmojiInfo.field_reserved4 = localEmojiInfo.field_reserved4;
      }
    }
    paramEmojiInfo = com.tencent.mm.emoji.decode.a.aum().a(paramEmojiInfo);
    AppMethodBeat.o(108466);
    return paramEmojiInfo;
  }
  
  public final boolean amA(String paramString)
  {
    bool2 = false;
    AppMethodBeat.i(240126);
    com.tencent.mm.plugin.gif.f localf = new com.tencent.mm.plugin.gif.f(paramString);
    int i = (int)com.tencent.mm.vfs.s.boW(paramString);
    if (i != 0) {
      bool1 = bool2;
    }
    try
    {
      if (i <= com.tencent.mm.n.c.aqm())
      {
        bool1 = bool2;
        if (localf.ydT[0] <= com.tencent.mm.n.c.aqo())
        {
          i = localf.ydT[1];
          int j = com.tencent.mm.n.c.aqo();
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
    AppMethodBeat.o(240126);
    return bool1;
  }
  
  public final void amB(String paramString)
  {
    AppMethodBeat.i(108501);
    if (!Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.emoji.EmojiMgrImpl", "deleteCaptureEmoji md: ".concat(String.valueOf(paramString)));
      k.getEmojiStorageMgr().OpN.dj(paramString, true);
      k.getEmojiStorageMgr().OpN.doNotify("delete_emoji_info_notify");
    }
    AppMethodBeat.o(108501);
  }
  
  public final void amC(String paramString)
  {
    AppMethodBeat.i(108503);
    EmojiInfo localEmojiInfo = aml(paramString);
    if (localEmojiInfo != null)
    {
      paramString = com.tencent.mm.emoji.d.i.hdO;
      com.tencent.mm.emoji.d.i.o(localEmojiInfo);
      AppMethodBeat.o(108503);
      return;
    }
    Log.w("MicroMsg.emoji.EmojiMgrImpl", "addCaptureEmojiUploadTask: emojiInfo null by md5 %s", new Object[] { paramString });
    AppMethodBeat.o(108503);
  }
  
  public final EmojiInfo aml(String paramString)
  {
    AppMethodBeat.i(108440);
    paramString = k.getEmojiStorageMgr().OpN.blk(paramString);
    AppMethodBeat.o(108440);
    return paramString;
  }
  
  public final EmojiInfo amm(String paramString)
  {
    AppMethodBeat.i(108441);
    paramString = aml(paramString);
    AppMethodBeat.o(108441);
    return paramString;
  }
  
  public final String amn(String paramString)
  {
    AppMethodBeat.i(108453);
    paramString = EmojiLogic.amn(paramString);
    AppMethodBeat.o(108453);
    return paramString;
  }
  
  public final List<EmojiInfo> amo(String paramString)
  {
    AppMethodBeat.i(108456);
    if (com.tencent.mm.kernel.g.aAh().isSDCardAvailable())
    {
      paramString = (ArrayList)k.getEmojiStorageMgr().OpN.amo(paramString);
      AppMethodBeat.o(108456);
      return paramString;
    }
    paramString = new ArrayList();
    AppMethodBeat.o(108456);
    return paramString;
  }
  
  public final String amp(String paramString)
  {
    AppMethodBeat.i(108458);
    paramString = k.getEmojiDescMgr().amp(paramString);
    AppMethodBeat.o(108458);
    return paramString;
  }
  
  public final boolean amq(String paramString)
  {
    AppMethodBeat.i(108459);
    if ((paramString != null) && (paramString.equals("capture")))
    {
      AppMethodBeat.o(108459);
      return true;
    }
    boolean bool = k.getEmojiStorageMgr().OpO.blb(paramString);
    AppMethodBeat.o(108459);
    return bool;
  }
  
  public final ArrayList<String> amr(String paramString)
  {
    AppMethodBeat.i(108460);
    bf localbf = k.getEmojiDescMgr();
    if (!localbf.mInit) {
      localbf.gCG();
    }
    long l = System.currentTimeMillis();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    if (!localbf.mInit) {
      localbf.gCG();
    }
    if (com.tencent.mm.ui.tools.f.bnP(paramString) > localbf.Opk) {
      Log.i("MicroMsg.emoji.EmojiDescNewMgr", "input text over checkout limit.");
    }
    for (;;)
    {
      paramString = localArrayList3.iterator();
      while (paramString.hasNext())
      {
        Object localObject = (String)paramString.next();
        localObject = (ArrayList)localbf.Opo.get(localObject);
        if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
          localArrayList1.addAll((Collection)localObject);
        }
      }
      if ((!Util.isNullOrNil(paramString)) && (localbf.Opo != null))
      {
        paramString = paramString.toLowerCase();
        if (localbf.Opn.containsKey(paramString))
        {
          paramString = (String)localbf.Opn.get(paramString);
          paramString = (List)localbf.Opm.get(paramString);
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
      Collections.sort(localArrayList1, localbf.Opp);
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
  
  public final String ams(String paramString)
  {
    AppMethodBeat.i(108461);
    paramString = EmojiLogic.ams(paramString);
    AppMethodBeat.o(108461);
    return paramString;
  }
  
  public final String amt(String paramString)
  {
    AppMethodBeat.i(108462);
    paramString = EmojiLogic.amt(paramString);
    AppMethodBeat.o(108462);
    return paramString;
  }
  
  public final int amu(String paramString)
  {
    AppMethodBeat.i(108463);
    int i = EmojiLogic.amu(paramString);
    AppMethodBeat.o(108463);
    return i;
  }
  
  public final String amv(String paramString)
  {
    AppMethodBeat.i(108464);
    paramString = EmojiLogic.amv(paramString);
    AppMethodBeat.o(108464);
    return paramString;
  }
  
  public final void amw(String paramString)
  {
    AppMethodBeat.i(108476);
    if (Util.isNullOrNil(paramString)) {
      Log.i("MicroMsg.emoji.EmojiCommandMgr", "emoji command is null.");
    }
    Object localObject1;
    if ("sync".equalsIgnoreCase(paramString))
    {
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NSK, Boolean.TRUE);
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NSP, Boolean.TRUE);
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NSQ, Boolean.TRUE);
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NST, Long.valueOf(System.currentTimeMillis()));
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NSU, Long.valueOf(System.currentTimeMillis()));
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NSJ, Long.valueOf(0L));
      com.tencent.mm.kernel.g.aAg().hqi.a(new com.tencent.mm.plugin.emoji.f.e(0), 0);
      com.tencent.mm.kernel.g.aAg().hqi.a(new com.tencent.mm.plugin.emoji.f.e(1), 0);
      localObject1 = new o(8, null, 15, true);
      com.tencent.mm.kernel.g.aAg().hqi.a((q)localObject1, 0);
    }
    while (WeChatEnvironment.hasDebugger())
    {
      Object localObject3;
      Object localObject4;
      if ("new".equalsIgnoreCase(paramString))
      {
        com.tencent.mm.y.c.axV().A(262147, true);
        com.tencent.mm.kernel.g.aAh().azQ().set(208899, Boolean.TRUE);
        com.tencent.mm.kernel.g.aAh().azQ().set(229633, "http://mmbiz.qpic.cn/mmemoticon/Q3auHgzwzM5eOptD4jIj72I8icMVEKwzSYkC30IgjMvSibGfqsEdy0ibXayiaZtbibSXV5EPZEWILOvbrjjLtQ9P4QQ/0");
        com.tencent.mm.kernel.g.aAh().azQ().set(229634, System.currentTimeMillis());
        AppMethodBeat.o(108476);
        return;
        if ("rcheart".equalsIgnoreCase(paramString))
        {
          k.getEmojiStorageMgr().OpO.gET();
        }
        else if ("recover".equalsIgnoreCase(paramString))
        {
          Log.i("MicroMsg.emoji.EmojiCommandMgr", "recover   begin");
          k.getEmojiStorageMgr().OpN.init(MMApplicationContext.getContext());
          k.getEmojiStorageMgr().OpO.init(MMApplicationContext.getContext());
          Log.i("MicroMsg.emoji.EmojiCommandMgr", "recover   end");
        }
        else
        {
          Object localObject2;
          if ("clean".equalsIgnoreCase(paramString))
          {
            Log.i("MicroMsg.emoji.EmojiCommandMgr", "begin clean");
            localObject1 = d.cFF();
            localObject2 = com.tencent.mm.emoji.e.a.hdT;
            ((d)localObject1).amk(com.tencent.mm.emoji.e.a.awt());
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NSP, Boolean.TRUE);
            Log.i("MicroMsg.emoji.EmojiCommandMgr", "end clean");
          }
          else
          {
            if ("dump".equalsIgnoreCase(paramString))
            {
              Log.i("MicroMsg.emoji.EmojiCommandMgr", "begin dump emoji db info:");
              localObject1 = (ArrayList)k.getEmojiStorageMgr().OpO.gEE();
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
              localObject2 = null;
              localObject1 = null;
              try
              {
                localObject3 = k.getEmojiStorageMgr().OpN.getAll();
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
                  break label702;
                }
                localException.close();
                AppMethodBeat.o(108476);
              }
              Log.i("MicroMsg.emoji.EmojiCommandMgr", "end dump emoji db info:");
              continue;
            }
            label702:
            if ("config".equalsIgnoreCase(paramString))
            {
              com.tencent.mm.pluginsdk.j.a.a.b.gnC().g(37, 1, -1, false);
              com.tencent.mm.pluginsdk.j.a.a.b.gnC().g(37, 2, -1, false);
              com.tencent.mm.pluginsdk.j.a.a.b.gnC().g(37, 4, -1, false);
              com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NTb, Integer.valueOf(0));
              com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NTc, Integer.valueOf(0));
              com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NTe, Integer.valueOf(0));
              localObject1 = new m(37);
              com.tencent.mm.kernel.g.aAg().hqi.a((q)localObject1, 0);
              com.tencent.mm.vfs.s.deleteFile(com.tencent.mm.ce.b.NKu);
            }
            else if ("tuzki".equalsIgnoreCase(paramString))
            {
              com.tencent.mm.plugin.emoji.f.a.cGm();
              com.tencent.mm.plugin.emoji.f.a.cGn();
            }
            else if (paramString.startsWith("reset-first"))
            {
              com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OgU, Boolean.FALSE);
              com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OgV, Boolean.FALSE);
              com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OgW, Boolean.FALSE);
              com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OgX, Boolean.FALSE);
            }
            else if (paramString.startsWith("cleanThumb"))
            {
              localObject1 = com.tencent.mm.emoji.e.a.hdT;
              com.tencent.mm.emoji.e.a.awx();
              Toast.makeText(MMApplicationContext.getContext(), "clean thumb done", 0).show();
            }
          }
        }
      }
      else
      {
        if ("free".equalsIgnoreCase(paramString))
        {
          com.tencent.mm.y.c.axV().A(262149, true);
          com.tencent.mm.kernel.g.aAh().azQ().set(208913, Boolean.TRUE);
          com.tencent.mm.kernel.g.aAh().azQ().set(229633, "http://mmbiz.qpic.cn/mmemoticon/Q3auHgzwzM5eOptD4jIj72I8icMVEKwzSYkC30IgjMvSibGfqsEdy0ibXayiaZtbibSXV5EPZEWILOvbrjjLtQ9P4QQ/0");
          com.tencent.mm.kernel.g.aAh().azQ().set(229634, System.currentTimeMillis());
          AppMethodBeat.o(108476);
          return;
        }
        if ("newp".equalsIgnoreCase(paramString))
        {
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NSO, Boolean.TRUE);
          AppMethodBeat.o(108476);
          return;
        }
        if ("newpe".equalsIgnoreCase(paramString))
        {
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NSS, Boolean.TRUE);
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
          com.tencent.mm.kernel.g.aAg().hqi.a(paramString, 0);
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
          Log.i("MicroMsg.emoji.EmojiCommandMgr", com.tencent.mm.vfs.s.bhK(paramString));
          Log.i("MicroMsg.emoji.EmojiCommandMgr", MD5Util.getMD5String(paramString));
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("recommend"))
        {
          paramString = com.tencent.mm.plugin.emoji.g.d.amT("<NewRecommendEmotion><Emotion><ProductID>com.tencent.xin.emoticon.person.stiker_144984189945aa5830d33cd7dc</ProductID><RecType>3</RecType><Name>野萌君</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/duc2TvpEgSTWy4k8MnuicFjyiazriaGWDX52HzNWeLVTjtJcjZeZEicTn5kJFPYdicWZTuUZJgiaADK9I/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/DhduwiaBa7lchicgAfwibeykm81eGWXkMDgGJ8DWcOcIc28C7oTic4Y09Pick8Fw69KiaZVxrHl8S2lPY/0</Panel><ButtonType>1</ButtonType></Emotion><Emotion><ProductID>com.tencent.xin.emoticon.person.stiker_14389422638f6ca818af405e21</ProductID><RecType>3</RecType><Name>猪仔和羊妹</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/iaUiazNVkRp7iaZjrMuYgfH8kB5xkyYv20CYzY3W9HCLBr2XybJibGKKtXibMnAfZnRTH/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/PiajxSqBRaEJR9canNKZ7RYI3hx5BPCSwQmuhhlNWD1jzUSOx3CWqEtibd65zOjySd/0</Panel><ButtonType>1</ButtonType></Emotion><Emotion><ProductID>com.tencent.xin.emoticon.person.stiker_1444199720f5ea147582ff0512</ProductID><RecType>3</RecType><Name>让红包飞</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/nMl9ssowtibXLY57PdK8Nsh827vlsw4TGHPgLUehd2R455xnwe3xpoVDIKpAuXU1Aic3XbH1LfMr7fp4DgO7o8IQ/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/duc2TvpEgST18reErFRzNFR8EiahI4Iibp4ZnW1ibJYt4MMLvQvjx3sHGTMuTOgnREq5f2GXLhuzalOOz3icw9NGbA/0</Panel><ButtonType>1</ButtonType></Emotion><Emotion><ProductID>com.tencent.xin.emoticon.xiaobendan</ProductID><RecType>3</RecType><Name>小笨蛋与大坏蛋</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/ajNVdqHZLLC8ILTt0pqcaCVkldLMydoNJcupoR7qUojia3vKlgd74uQ/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/ajNVdqHZLLC8ILTt0pqcaAAEUI4a7z5ECqpUXbQw95PY1mpc4p0FxA/0</Panel><ButtonType>1</ButtonType></Emotion><Emotion><ProductID>com.tencent.xin.emoticon.shin2</ProductID><RecType>3</RecType><Name>野原新之助2</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/iciaySdkria4apGIW1wvSbPC9oxWQPHZyicaccx5JDIp2uE/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/ajNVdqHZLLASEAAX7xw76beia5j4HyA0rq9WgtgscicJo7935UCpCpog/0</Panel><ButtonType>1</ButtonType></Emotion></NewRecommendEmotion>");
          k.getEmojiStorageMgr().OpO.gEK();
          k.getEmojiStorageMgr().OpO.bk(paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("count"))
        {
          paramString = paramString.replace("count", "").trim();
          com.tencent.mm.n.h.aqJ().put("CustomEmojiMaxSize", paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("auto"))
        {
          paramString = paramString.replace("auto", "").trim();
          com.tencent.mm.n.h.aqJ().put("C2CEmojiNotAutoDownloadTimeRange", paramString);
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
          k.getEmojiStorageMgr().OpV.bn(paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("panel"))
        {
          paramString.replace("panel", "").trim();
          paramString = new com.tencent.mm.g.a.bp();
          paramString.dEN.subType = 1;
          paramString.dEN.dEO = 37;
          paramString.dEN.filePath = (com.tencent.mm.loader.j.b.aKJ() + "CheckResUpdate/37.1.data");
          EventCenter.instance.publish(paramString);
          paramString = new com.tencent.mm.g.a.bp();
          paramString.dEN.subType = 2;
          paramString.dEN.dEO = 37;
          paramString.dEN.filePath = "/sdcard/tencent/MicroMsg/CheckResUpdate/37.2.data";
          EventCenter.instance.publish(paramString);
          paramString = new com.tencent.mm.g.a.bp();
          paramString.dEN.subType = 3;
          paramString.dEN.dEO = 37;
          paramString.dEN.filePath = (com.tencent.mm.loader.j.b.aKJ() + "CheckResUpdate/37.3.data");
          EventCenter.instance.publish(paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("key"))
        {
          paramString = com.tencent.mm.b.g.getMessageDigest(String.valueOf(System.currentTimeMillis()).getBytes());
          Log.i("MicroMsg.emoji.EmojiCommandMgr", "create key :%s" + Util.secPrint(paramString));
          k.getEmojiStorageMgr().OpN.akv(153);
          localObject1 = new EmojiInfo();
          ((EmojiInfo)localObject1).field_md5 = paramString;
          ((EmojiInfo)localObject1).field_catalog = 153;
          k.getEmojiStorageMgr().OpN.K((EmojiInfo)localObject1);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("delete"))
        {
          a.ami(paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("delete-db"))
        {
          paramString = paramString.replace("delete-db", "").trim();
          k.getEmojiStorageMgr().OpN.dj(paramString, true);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("delete-file"))
        {
          a.amh(paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("batchDownload"))
        {
          paramString = paramString.split(" ");
          if (paramString.length > 1)
          {
            paramString = new com.tencent.mm.plugin.emoji.f.e(Util.safeParseInt(paramString[1]));
            com.tencent.mm.kernel.g.aAg().hqi.a(paramString, 0);
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
            com.tencent.mm.kernel.g.aAg().hqi.a(paramString, 0);
          }
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("test"))
        {
          Log.i("MicroMsg.emoji.EmojiCommandMgr", "theTest: %s", new Object[] { paramString });
          com.tencent.f.h.RTc.aX(new a.1());
        }
      }
    }
    AppMethodBeat.o(108476);
  }
  
  public final void amy(String paramString)
  {
    AppMethodBeat.i(176179);
    w localw = k.getEmojiStorageMgr().OpY;
    LinkedList localLinkedList;
    int i;
    if (!Util.isNullOrNil(paramString))
    {
      localLinkedList = localw.zns;
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < localw.zns.size())
        {
          if (Util.isEqual(((v)localw.zns.get(i)).key, paramString))
          {
            localv = (v)localw.zns.get(i);
            if (localv == null)
            {
              localv = new v();
              localv.key = paramString;
              localv.OsQ += 1;
              localv.hwQ = System.currentTimeMillis();
              localw.zns.add(0, localv);
              if (localw.zns.size() > 9) {
                localw.zns.remove(localw.zns.size() - 1);
              }
              localw.doNotify("event_update_recent", 0, Integer.valueOf(localw.zns.size()));
              AppMethodBeat.o(176179);
            }
          }
          else
          {
            i += 1;
            continue;
          }
          localw.zns.remove(i);
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
  
  public final boolean amz(String paramString)
  {
    bool2 = false;
    AppMethodBeat.i(108499);
    com.tencent.mm.plugin.gif.f localf = new com.tencent.mm.plugin.gif.f(paramString);
    int i = (int)com.tencent.mm.vfs.s.boW(paramString);
    if (i != 0) {
      bool1 = bool2;
    }
    try
    {
      if (i <= com.tencent.mm.n.c.aqp())
      {
        bool1 = bool2;
        if (localf.ydT[0] <= com.tencent.mm.n.c.aqo())
        {
          i = localf.ydT[1];
          int j = com.tencent.mm.n.c.aqo();
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
  
  public final boolean ave()
  {
    AppMethodBeat.i(108492);
    boolean bool = n.ave();
    AppMethodBeat.o(108492);
    return bool;
  }
  
  public final boolean avf()
  {
    AppMethodBeat.i(108493);
    if ((WeChatEnvironment.hasDebugger()) || (n.avf()))
    {
      AppMethodBeat.o(108493);
      return true;
    }
    AppMethodBeat.o(108493);
    return false;
  }
  
  public final <T> T c(ar.a parama, T paramT)
  {
    AppMethodBeat.i(108497);
    parama = com.tencent.mm.kernel.g.aAh().azQ().get(parama, paramT);
    AppMethodBeat.o(108497);
    return parama;
  }
  
  public final boolean cFH()
  {
    AppMethodBeat.i(108469);
    boolean bool = n.auX();
    AppMethodBeat.o(108469);
    return bool;
  }
  
  public final ArrayList<SmileyInfo> cFJ()
  {
    AppMethodBeat.i(108470);
    ArrayList localArrayList = k.getEmojiStorageMgr().OpV.cFJ();
    AppMethodBeat.o(108470);
    return localArrayList;
  }
  
  public final ArrayList<SmileyPanelConfigInfo> cFK()
  {
    AppMethodBeat.i(108471);
    ArrayList localArrayList = k.getEmojiStorageMgr().OpW.cFK();
    AppMethodBeat.o(108471);
    return localArrayList;
  }
  
  public final com.tencent.mm.bb.g cFL()
  {
    AppMethodBeat.i(108475);
    com.tencent.mm.bb.g localg = h.cFT().cFL();
    AppMethodBeat.o(108475);
    return localg;
  }
  
  public final boolean cFM()
  {
    AppMethodBeat.i(108477);
    if ((WeChatEnvironment.hasDebugger()) || (n.avg()))
    {
      AppMethodBeat.o(108477);
      return true;
    }
    AppMethodBeat.o(108477);
    return false;
  }
  
  public final String cFN()
  {
    AppMethodBeat.i(108478);
    h.cFT();
    String str = h.cFN();
    AppMethodBeat.o(108478);
    return str;
  }
  
  public final void cFO()
  {
    AppMethodBeat.i(108479);
    h localh = h.cFT();
    com.tencent.mm.g.a.bp localbp = new com.tencent.mm.g.a.bp();
    bp.a locala = localbp.dEN;
    com.tencent.mm.pluginsdk.j.a.a.b.gnC();
    locala.filePath = com.tencent.mm.pluginsdk.j.a.a.b.kC(37, 1);
    localbp.dEN.dEO = 37;
    localbp.dEN.subType = 1;
    localbp.dEN.dEP = -1;
    localh.b(localbp);
    AppMethodBeat.o(108479);
  }
  
  public final boolean cFP()
  {
    AppMethodBeat.i(108491);
    boolean bool = n.avd();
    AppMethodBeat.o(108491);
    return bool;
  }
  
  public final List<v> cFQ()
  {
    AppMethodBeat.i(108495);
    List localList = k.getEmojiStorageMgr().OpY.cFQ();
    AppMethodBeat.o(108495);
    return localList;
  }
  
  public final void cFR()
  {
    AppMethodBeat.i(108496);
    Object localObject = k.getEmojiStorageMgr().OpY.cFQ();
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
    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OgR, localJSONArray.toString());
    AppMethodBeat.o(108496);
  }
  
  public final boolean cFS()
  {
    AppMethodBeat.i(108500);
    if (!com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.OgX, true)) {}
    for (int i = 1;; i = 0)
    {
      n.isSpringFestivalEnable();
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
      i = com.tencent.mm.n.c.aqp();
      AppMethodBeat.o(108480);
      return i;
    }
    i = com.tencent.mm.n.c.aqn();
    AppMethodBeat.o(108480);
    return i;
  }
  
  public final void d(ar.a parama, Object paramObject)
  {
    AppMethodBeat.i(108498);
    com.tencent.mm.kernel.g.aAh().azQ().set(parama, paramObject);
    AppMethodBeat.o(108498);
  }
  
  public final bi fT(String paramString1, String paramString2)
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
  
  public final String fU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108474);
    com.tencent.mm.emoji.e.a locala = com.tencent.mm.emoji.e.a.hdT;
    paramString1 = EmojiLogic.W(com.tencent.mm.emoji.e.a.awt(), paramString1, paramString2);
    AppMethodBeat.o(108474);
    return paramString1;
  }
  
  public final String getAccPath()
  {
    AppMethodBeat.i(108457);
    String str = com.tencent.mm.kernel.g.aAh().hqG;
    AppMethodBeat.o(108457);
    return str;
  }
  
  public final String getDataEmojiPath()
  {
    AppMethodBeat.i(240124);
    String str = h.getDataEmojiPath();
    AppMethodBeat.o(240124);
    return str;
  }
  
  public final void h(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(108487);
    k.getEmojiStorageMgr().OpN.remove(paramIOnStorageChange);
    AppMethodBeat.o(108487);
  }
  
  public final void i(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(108488);
    k.getEmojiStorageMgr().OpN.add(paramIOnStorageChange);
    AppMethodBeat.o(108488);
  }
  
  public final void j(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(108489);
    k.getEmojiStorageMgr().OpO.remove(paramIOnStorageChange);
    AppMethodBeat.o(108489);
  }
  
  public final void k(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(108490);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.aAe().azG()).aBb()) {
      k.getEmojiStorageMgr().OpO.add(paramIOnStorageChange);
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
    if (paramEmojiInfo.field_catalog == EmojiGroupInfo.Uun)
    {
      localObject = paramEmojiInfo;
      if (paramEmojiInfo.getContent().length() > 0)
      {
        localObject = paramEmojiInfo;
        if (EmojiInfo.aww(Util.getInt(paramEmojiInfo.getContent(), 0)))
        {
          Cursor localCursor = k.getEmojiStorageMgr().OpN.aku(Util.getInt(paramEmojiInfo.getContent(), 0));
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
      if ((paramEmojiInfo.field_catalog == EmojiInfo.Uut) || (String.valueOf(EmojiInfo.Uut).equals(paramEmojiInfo.field_groupId)))
      {
        AppMethodBeat.o(108465);
        return 2131233194;
      }
      if ((paramEmojiInfo.field_catalog == EmojiInfo.Uuu) || (String.valueOf(EmojiInfo.Uuu).equals(paramEmojiInfo.field_groupId)))
      {
        AppMethodBeat.o(108465);
        return 2131232013;
      }
    }
    AppMethodBeat.o(108465);
    return 0;
  }
  
  public final int[] r(EmojiInfo paramEmojiInfo)
  {
    if (paramEmojiInfo != null)
    {
      if (paramEmojiInfo.field_catalog == EmojiInfo.Uut) {
        return new int[] { 2131233196, 2131233197, 2131233195 };
      }
      if (paramEmojiInfo.field_catalog == EmojiInfo.Uuu) {
        return new int[] { 2131232020, 2131232021, 2131232022, 2131232023 };
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
      localObject = aml(paramEmojiInfo.field_md5);
      if ((localObject != null) && (((EmojiInfo)localObject).field_reserved4 != paramEmojiInfo.field_reserved4)) {
        paramEmojiInfo.field_reserved4 = ((EmojiInfo)localObject).field_reserved4;
      }
    }
    paramEmojiInfo = com.tencent.mm.emoji.decode.a.aum().a(paramEmojiInfo);
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
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpN.x(1, (List)localObject);
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpN.L(paramEmojiInfo);
    paramEmojiInfo = new do();
    paramEmojiInfo.dGz.type = 2;
    EventCenter.instance.publish(paramEmojiInfo);
    if (!paramEmojiInfo.dGA.dGB)
    {
      paramEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpQ.gFr();
      if (paramEmojiInfo != null)
      {
        localObject = paramEmojiInfo.MYx.iterator();
        while (((Iterator)localObject).hasNext())
        {
          dyw localdyw = (dyw)((Iterator)localObject).next();
          if (localdyw.ProductID.equals(String.valueOf("capture"))) {
            localdyw.xuA = 0;
          }
        }
      }
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpQ.a(paramEmojiInfo);
      com.tencent.mm.ca.a.gvc();
      paramEmojiInfo = com.tencent.mm.ca.a.NCN;
      a.b.bhD(String.valueOf("capture"));
    }
    AppMethodBeat.o(108502);
  }
  
  public final boolean u(Context paramContext, String paramString1, String paramString2)
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
    EmojiInfo localEmojiInfo = k.getEmojiStorageMgr().OpN.blk(paramString2);
    if (localEmojiInfo == null)
    {
      Log.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: emoji not found, imgPath %s", new Object[] { paramString2 });
      AppMethodBeat.o(108446);
      return false;
    }
    if ((localEmojiInfo.field_type == EmojiInfo.Uuz) || (localEmojiInfo.field_type == EmojiInfo.UuA))
    {
      paramContext = new WXMediaMessage();
      paramString2 = localEmojiInfo.hRM();
      if (com.tencent.mm.vfs.s.YS(localEmojiInfo.hRN())) {
        paramContext.thumbData = com.tencent.mm.vfs.s.aW(localEmojiInfo.hRN(), 0, -1);
      }
      for (;;)
      {
        paramContext.mediaObject = new WXEmojiObject(paramString2);
        paramString2 = new tt();
        paramString2.eaf.dCE = paramContext;
        paramString2.eaf.appId = localEmojiInfo.field_app_id;
        paramString2.eaf.appName = null;
        paramString2.eaf.toUser = paramString1;
        paramString2.eaf.dMG = 0;
        paramString2.eaf.eai = localEmojiInfo.getMd5();
        EventCenter.instance.publish(paramString2);
        AppMethodBeat.o(108446);
        return true;
        paramContext.setThumbImage(localEmojiInfo.hRz());
      }
    }
    paramString2 = localEmojiInfo;
    if (localEmojiInfo.field_type == EmojiInfo.Uuw)
    {
      if (!EmojiInfo.aww(localEmojiInfo.field_catalog)) {
        break label370;
      }
      paramContext = k.getEmojiStorageMgr().OpN.aku(localEmojiInfo.field_catalog);
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
      if (as.bjw(paramString1))
      {
        k.cGe().b(paramString1, paramString2, null);
        break;
        label370:
        if ((localEmojiInfo.field_catalog != EmojiInfo.Uur) || (localEmojiInfo.getContent().length() <= 0) || (!EmojiInfo.aww(Util.getInt(localEmojiInfo.getContent(), 0)))) {
          break label441;
        }
        paramContext = k.getEmojiStorageMgr().OpN.aku(Util.getInt(localEmojiInfo.getContent(), 0));
        continue;
      }
      k.cGd().a(paramString1, paramString2, null);
      break;
      label441:
      paramContext = null;
    }
  }
  
  public final void updateEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108452);
    k.getEmojiStorageMgr().OpN.L(paramEmojiInfo);
    AppMethodBeat.o(108452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.f
 * JD-Core Version:    0.7.0.1
 */