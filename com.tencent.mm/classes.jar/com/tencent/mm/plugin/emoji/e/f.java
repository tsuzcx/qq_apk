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
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.ca.a.b;
import com.tencent.mm.emoji.loader.d.i.a;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.g.a.dl;
import com.tencent.mm.g.a.dl.b;
import com.tencent.mm.g.a.sv;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.x;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI;
import com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.protocal.protobuf.dfo;
import com.tencent.mm.protocal.protobuf.dfp;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.ba.a;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.storage.emotion.t;
import com.tencent.mm.storage.emotion.v;
import com.tencent.mm.storage.emotion.w;
import com.tencent.mm.vfs.o;
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
      ae.e("MicroMsg.emoji.EmojiMgrImpl", "showEmoji fail cause md5 is no valid");
      AppMethodBeat.o(108448);
      return;
    }
    EmojiInfo localEmojiInfo = k.getEmojiStorageMgr().JfU.aWl(paramString1);
    if (localEmojiInfo == null)
    {
      ae.e("MicroMsg.emoji.EmojiMgrImpl", "showEmoji fail cause md5 is no valid");
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
      if (x.wb(paramString4))
      {
        paramString1 = bl.BM(paramString5);
        localIntent.putExtra("room_id", paramString6);
      }
      localIntent.putExtra("msg_sender", paramString1);
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.ahE(), "com/tencent/mm/plugin/emoji/mgr/EmojiMgrImpl", "showEmoji", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString1.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/emoji/mgr/EmojiMgrImpl", "showEmoji", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(108448);
      return;
      localIntent.putExtra("custom_smiley_preview_appid", localEmojiInfo.field_app_id);
    }
  }
  
  static void cZ(String paramString, int paramInt)
  {
    AppMethodBeat.i(108445);
    com.tencent.mm.g.a.s locals = new com.tencent.mm.g.a.s();
    locals.dlt.dlu = paramString;
    locals.dlt.status = paramInt;
    locals.dlt.percentage = 0;
    com.tencent.mm.sdk.b.a.IvT.l(locals);
    ae.d("MicroMsg.emoji.EmojiMgrImpl", "attachid:%s percentage:%d status:%d", new Object[] { paramString, Integer.valueOf(0), Integer.valueOf(paramInt) });
    AppMethodBeat.o(108445);
  }
  
  public final boolean O(ArrayList<SmileyInfo> paramArrayList)
  {
    AppMethodBeat.i(108472);
    boolean bool = k.getEmojiStorageMgr().Jgc.aV(paramArrayList);
    AppMethodBeat.o(108472);
    return bool;
  }
  
  public final boolean P(ArrayList<SmileyPanelConfigInfo> paramArrayList)
  {
    AppMethodBeat.i(108473);
    com.tencent.mm.storage.emotion.u localu = k.getEmojiStorageMgr().Jgd;
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      ae.i("MicroMsg.emoji.SmileyPanelConfigInfoStorage", "insertSmileyConfigInfoList failed. list is null.");
      AppMethodBeat.o(108473);
      return false;
    }
    ae.i("MicroMsg.emoji.SmileyPanelConfigInfoStorage", "insertSmileyConfigInfoList: %s", new Object[] { Integer.valueOf(paramArrayList.size()) });
    com.tencent.mm.storagebase.h localh;
    long l;
    if ((localu.db instanceof com.tencent.mm.storagebase.h))
    {
      localh = (com.tencent.mm.storagebase.h)localu.db;
      l = localh.yi(Thread.currentThread().getId());
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
        i = localh.sW(l);
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
    paramString1 = k.getEmojiStorageMgr().JfU.e(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3);
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
  
  public final void a(Context paramContext, com.tencent.mm.storage.bv parambv, String paramString)
  {
    AppMethodBeat.i(108444);
    if ((paramContext == null) || (parambv == null))
    {
      ae.w("MicroMsg.emoji.EmojiMgrImpl", "context or msg is null");
      AppMethodBeat.o(108444);
      return;
    }
    az localaz = az.aVt(parambv.field_content);
    Object localObject2 = k.b.zb(parambv.field_content);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new k.b();
      ((k.b)localObject1).hCE = localaz.md5;
    }
    localObject2 = k.getEmojiStorageMgr().JfU.aWl(((k.b)localObject1).hCE);
    if ((localObject2 != null) && (((EmojiInfo)localObject2).fxn()))
    {
      if (parambv.field_isSend == 1)
      {
        a(paramContext, ((k.b)localObject1).hCE, ((k.b)localObject1).appId, ((k.b)localObject1).appName, parambv.field_msgSvrId, parambv.field_talker, parambv.field_content, paramString);
        AppMethodBeat.o(108444);
        return;
      }
      a(paramContext, ((EmojiInfo)localObject2).Lj(), ((k.b)localObject1).appId, ((k.b)localObject1).appName, parambv.field_msgSvrId, parambv.field_talker, parambv.field_content, paramString);
      AppMethodBeat.o(108444);
      return;
    }
    paramContext = k.getEmojiStorageMgr().JfU.aWl(((k.b)localObject1).hCE);
    if (paramContext == null)
    {
      parambv = ((k.b)localObject1).hCE;
      if (bu.isNullOrNil(parambv))
      {
        ae.e("MicroMsg.emoji.EmojiMgrImpl", "md5 is null.");
        AppMethodBeat.o(108444);
        return;
      }
      paramContext = new EmojiInfo();
      paramContext.field_md5 = parambv;
      paramContext.field_app_id = ((k.b)localObject1).appId;
      paramContext.field_catalog = EmojiInfo.OzU;
      paramContext.field_size = ((k.b)localObject1).hCC;
      paramContext.field_temp = 1;
      paramContext.field_state = EmojiInfo.OAk;
      k.getEmojiStorageMgr().JfU.J(paramContext);
    }
    for (;;)
    {
      cZ(paramContext.field_md5, 0);
      ae.d("MicroMsg.emoji.EmojiMgrImpl", "start change cdn url. md5:%s", new Object[] { paramContext.field_md5 });
      parambv = paramContext.field_md5;
      paramString = com.tencent.mm.emoji.loader.e.gkR;
      com.tencent.mm.emoji.loader.e.a(paramContext, true, new i.a()
      {
        public final void dg(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(108439);
          if (paramAnonymousBoolean)
          {
            f.cZ(this.lCn, 1);
            AppMethodBeat.o(108439);
            return;
          }
          f.cZ(this.lCn, 2);
          AppMethodBeat.o(108439);
        }
      });
      AppMethodBeat.o(108444);
      return;
    }
  }
  
  public final void a(String paramString, EmojiInfo paramEmojiInfo, com.tencent.mm.storage.bv parambv)
  {
    AppMethodBeat.i(108447);
    if ((paramEmojiInfo == null) && (parambv == null))
    {
      AppMethodBeat.o(108447);
      return;
    }
    EmojiInfo localEmojiInfo = paramEmojiInfo;
    if (paramEmojiInfo == null) {
      localEmojiInfo = k.getEmojiStorageMgr().JfU.aWl(parambv.field_imgPath);
    }
    k.cif().a(paramString, localEmojiInfo, parambv);
    AppMethodBeat.o(108447);
  }
  
  public final boolean a(Context paramContext, EmojiInfo paramEmojiInfo, int paramInt, String paramString)
  {
    AppMethodBeat.i(108443);
    if (paramContext == null)
    {
      ae.e("MicroMsg.emoji.EmojiMgrImpl", "[cpan] save emoji failed. context is null");
      AppMethodBeat.o(108443);
      return false;
    }
    if (paramEmojiInfo == null)
    {
      ae.e("MicroMsg.emoji.EmojiMgrImpl", "[cpan] save emoji failed. emoji is null");
      AppMethodBeat.o(108443);
      return false;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, EmojiAddCustomDialogUI.class);
    localIntent.putExtra("extra_id", paramEmojiInfo.Lj());
    localIntent.putExtra("extra_scence", paramInt);
    localIntent.putExtra("extra_move_to_top", true);
    localIntent.putExtra("extra_username", paramString);
    localIntent.putExtra("extra_current", false);
    localIntent.putExtra("key_is_selfie", false);
    localIntent.putExtra("key_attached_text", null);
    localIntent.putExtra("key_attached_emoji_md5", null);
    localIntent.putExtra("key_imitate_md5", null);
    localIntent.addFlags(65536);
    paramEmojiInfo = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramEmojiInfo.ahE(), "com/tencent/mm/plugin/emoji/mgr/EmojiMgrImpl", "saveCustomEmoji", "(Landroid/content/Context;Lcom/tencent/mm/storage/emotion/EmojiInfo;ILjava/lang/String;IZZZLjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramEmojiInfo.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/emoji/mgr/EmojiMgrImpl", "saveCustomEmoji", "(Landroid/content/Context;Lcom/tencent/mm/storage/emotion/EmojiInfo;ILjava/lang/String;IZZZLjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(108443);
    return true;
  }
  
  public final boolean a(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(108468);
    paramBoolean = com.tencent.mm.emoji.decode.a.aeE().a(paramEmojiInfo, paramBoolean);
    AppMethodBeat.o(108468);
    return paramBoolean;
  }
  
  public final boolean a(String paramString1, String paramString2, long paramLong, String paramString3, e.a parama)
  {
    boolean bool = false;
    AppMethodBeat.i(108455);
    com.tencent.mm.plugin.emoji.model.c localc = k.cif();
    ae.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml ".concat(String.valueOf(paramString2)));
    paramString1 = bd.a(bx.M(paramString2, "msg"), paramString1, paramString2, paramString3);
    if (paramString1 == null)
    {
      ae.i("MicroMsg.emoji.EmojiService", "prepareEmoji failed. emoji msg info is null.");
      AppMethodBeat.o(108455);
      return true;
    }
    paramString1.dCd = paramLong;
    ae.i("MicroMsg.emoji.EmojiService", "summerbadcr prepareEmoji msgSvrId[%d], stack[%s]", new Object[] { Long.valueOf(paramLong), bu.fpN() });
    localc.acI(paramString1.dpp);
    if (!EmojiLogic.acH(com.tencent.mm.emoji.a.m.afm())) {
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
      EmojiInfo localEmojiInfo = aci(paramEmojiInfo.field_md5);
      if ((localEmojiInfo != null) && (localEmojiInfo.field_reserved4 != paramEmojiInfo.field_reserved4)) {
        paramEmojiInfo.field_reserved4 = localEmojiInfo.field_reserved4;
      }
    }
    paramEmojiInfo = com.tencent.mm.emoji.decode.a.aeE().a(paramEmojiInfo);
    AppMethodBeat.o(108466);
    return paramEmojiInfo;
  }
  
  public final EmojiInfo aci(String paramString)
  {
    AppMethodBeat.i(108440);
    paramString = k.getEmojiStorageMgr().JfU.aWl(paramString);
    AppMethodBeat.o(108440);
    return paramString;
  }
  
  public final EmojiInfo acj(String paramString)
  {
    AppMethodBeat.i(108441);
    paramString = aci(paramString);
    AppMethodBeat.o(108441);
    return paramString;
  }
  
  public final String ack(String paramString)
  {
    AppMethodBeat.i(108453);
    paramString = EmojiLogic.ack(paramString);
    AppMethodBeat.o(108453);
    return paramString;
  }
  
  public final List<EmojiInfo> acl(String paramString)
  {
    AppMethodBeat.i(108456);
    if (com.tencent.mm.kernel.g.ajR().isSDCardAvailable())
    {
      paramString = (ArrayList)k.getEmojiStorageMgr().JfU.acl(paramString);
      AppMethodBeat.o(108456);
      return paramString;
    }
    paramString = new ArrayList();
    AppMethodBeat.o(108456);
    return paramString;
  }
  
  public final String acm(String paramString)
  {
    AppMethodBeat.i(108458);
    paramString = k.getEmojiDescMgr().acm(paramString);
    AppMethodBeat.o(108458);
    return paramString;
  }
  
  public final boolean acn(String paramString)
  {
    AppMethodBeat.i(108459);
    if ((paramString != null) && (paramString.equals("capture")))
    {
      AppMethodBeat.o(108459);
      return true;
    }
    boolean bool = k.getEmojiStorageMgr().JfV.aWd(paramString);
    AppMethodBeat.o(108459);
    return bool;
  }
  
  public final ArrayList<String> aco(String paramString)
  {
    AppMethodBeat.i(108460);
    ba localba = k.getEmojiDescMgr();
    if (!localba.mInit) {
      localba.fuZ();
    }
    long l = System.currentTimeMillis();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    if (!localba.mInit) {
      localba.fuZ();
    }
    if (com.tencent.mm.ui.tools.f.aYK(paramString) > localba.Jfq) {
      ae.i("MicroMsg.emoji.EmojiDescNewMgr", "input text over checkout limit.");
    }
    for (;;)
    {
      paramString = localArrayList3.iterator();
      while (paramString.hasNext())
      {
        Object localObject = (String)paramString.next();
        localObject = (ArrayList)localba.Jfu.get(localObject);
        if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
          localArrayList1.addAll((Collection)localObject);
        }
      }
      if ((!bu.isNullOrNil(paramString)) && (localba.Jfu != null))
      {
        paramString = paramString.toLowerCase();
        if (localba.Jft.containsKey(paramString))
        {
          paramString = (String)localba.Jft.get(paramString);
          paramString = (List)localba.Jfs.get(paramString);
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
    ae.i("MicroMsg.emoji.EmojiDescNewMgr", "changeText: %s, %s", new Object[] { Integer.valueOf(localArrayList3.size()), Integer.valueOf(localArrayList1.size()) });
    if (!localArrayList1.isEmpty())
    {
      Collections.sort(localArrayList1, localba.Jfv);
      int i = 0;
      while (i < localArrayList1.size())
      {
        localArrayList2.add(((ba.a)localArrayList1.get(i)).md5);
        i += 1;
      }
    }
    ae.d("MicroMsg.emoji.EmojiDescNewMgr", "cpan[check desc]User time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(108460);
    return localArrayList2;
  }
  
  public final String acp(String paramString)
  {
    AppMethodBeat.i(108461);
    paramString = EmojiLogic.acp(paramString);
    AppMethodBeat.o(108461);
    return paramString;
  }
  
  public final String acq(String paramString)
  {
    AppMethodBeat.i(108462);
    paramString = EmojiLogic.acq(paramString);
    AppMethodBeat.o(108462);
    return paramString;
  }
  
  public final int acr(String paramString)
  {
    AppMethodBeat.i(108463);
    int i = EmojiLogic.acr(paramString);
    AppMethodBeat.o(108463);
    return i;
  }
  
  public final String acs(String paramString)
  {
    AppMethodBeat.i(108464);
    paramString = EmojiLogic.acs(paramString);
    AppMethodBeat.o(108464);
    return paramString;
  }
  
  public final void act(String paramString)
  {
    AppMethodBeat.i(108476);
    if (bu.isNullOrNil(paramString)) {
      ae.i("MicroMsg.emoji.EmojiCommandMgr", "emoji command is null.");
    }
    Object localObject1;
    if ("sync".equalsIgnoreCase(paramString))
    {
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IKM, Boolean.TRUE);
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IKR, Boolean.TRUE);
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IKS, Boolean.TRUE);
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IKV, Long.valueOf(System.currentTimeMillis()));
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IKW, Long.valueOf(System.currentTimeMillis()));
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IKL, Long.valueOf(0L));
      com.tencent.mm.kernel.g.ajQ().gDv.a(new com.tencent.mm.plugin.emoji.f.e(0), 0);
      com.tencent.mm.kernel.g.ajQ().gDv.a(new com.tencent.mm.plugin.emoji.f.e(1), 0);
      localObject1 = new com.tencent.mm.plugin.emoji.f.n(8, null, 15, true);
      com.tencent.mm.kernel.g.ajQ().gDv.a((com.tencent.mm.ak.n)localObject1, 0);
    }
    while (com.tencent.mm.sdk.platformtools.bv.fpT())
    {
      Object localObject3;
      Object localObject4;
      if ("new".equalsIgnoreCase(paramString))
      {
        com.tencent.mm.y.c.ahI().w(262147, true);
        com.tencent.mm.kernel.g.ajR().ajA().set(208899, Boolean.TRUE);
        com.tencent.mm.kernel.g.ajR().ajA().set(229633, "http://mmbiz.qpic.cn/mmemoticon/Q3auHgzwzM5eOptD4jIj72I8icMVEKwzSYkC30IgjMvSibGfqsEdy0ibXayiaZtbibSXV5EPZEWILOvbrjjLtQ9P4QQ/0");
        com.tencent.mm.kernel.g.ajR().ajA().set(229634, System.currentTimeMillis());
        AppMethodBeat.o(108476);
        return;
        if ("rcheart".equalsIgnoreCase(paramString))
        {
          k.getEmojiStorageMgr().JfV.fxg();
        }
        else if ("recover".equalsIgnoreCase(paramString))
        {
          ae.i("MicroMsg.emoji.EmojiCommandMgr", "recover   begin");
          k.getEmojiStorageMgr().JfU.init(ak.getContext());
          k.getEmojiStorageMgr().JfV.init(ak.getContext());
          ae.i("MicroMsg.emoji.EmojiCommandMgr", "recover   end");
        }
        else
        {
          Object localObject2;
          if ("clean".equalsIgnoreCase(paramString))
          {
            ae.i("MicroMsg.emoji.EmojiCommandMgr", "begin clean");
            localObject1 = d.chI();
            localObject2 = com.tencent.mm.emoji.d.a.gsI;
            ((d)localObject1).ach(com.tencent.mm.emoji.d.a.agD());
            com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IKR, Boolean.TRUE);
            ae.i("MicroMsg.emoji.EmojiCommandMgr", "end clean");
          }
          else
          {
            if ("dump".equalsIgnoreCase(paramString))
            {
              ae.i("MicroMsg.emoji.EmojiCommandMgr", "begin dump emoji db info:");
              localObject1 = (ArrayList)k.getEmojiStorageMgr().JfV.fwS();
              if (((ArrayList)localObject1).size() > 0)
              {
                int j = ((ArrayList)localObject1).size();
                int i = 0;
                while (i < j)
                {
                  ae.i("MicroMsg.emoji.EmojiCommandMgr", "i:%d group info:%s", new Object[] { Integer.valueOf(i), ((EmojiGroupInfo)((ArrayList)localObject1).get(i)).toString() });
                  i += 1;
                }
              }
              localObject2 = null;
              localObject1 = null;
              try
              {
                localObject3 = k.getEmojiStorageMgr().JfU.getAll();
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
                      ae.i("MicroMsg.emoji.EmojiCommandMgr", "emoji info:%s", new Object[] { ((EmojiInfo)localObject4).toString() });
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
              ae.i("MicroMsg.emoji.EmojiCommandMgr", "end dump emoji db info:");
              continue;
            }
            label702:
            if ("config".equalsIgnoreCase(paramString))
            {
              com.tencent.mm.pluginsdk.j.a.a.b.fes().f(37, 1, -1, false);
              com.tencent.mm.pluginsdk.j.a.a.b.fes().f(37, 2, -1, false);
              com.tencent.mm.pluginsdk.j.a.a.b.fes().f(37, 4, -1, false);
              com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ILd, Integer.valueOf(0));
              com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ILe, Integer.valueOf(0));
              com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ILg, Integer.valueOf(0));
              localObject1 = new com.tencent.mm.pluginsdk.j.a.a.m(37);
              com.tencent.mm.kernel.g.ajQ().gDv.a((com.tencent.mm.ak.n)localObject1, 0);
              o.deleteFile(com.tencent.mm.ce.b.IDD);
            }
            else if ("tuzki".equalsIgnoreCase(paramString))
            {
              com.tencent.mm.plugin.emoji.f.a.cin();
              com.tencent.mm.plugin.emoji.f.a.cio();
            }
            else if (paramString.startsWith("reset-first"))
            {
              com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IYx, Boolean.FALSE);
              com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IYy, Boolean.FALSE);
              com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IYz, Boolean.FALSE);
              com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IYA, Boolean.FALSE);
            }
            else if (paramString.startsWith("cleanThumb"))
            {
              localObject1 = com.tencent.mm.emoji.d.a.gsI;
              com.tencent.mm.emoji.d.a.agF();
              Toast.makeText(ak.getContext(), "clean thumb done", 0).show();
            }
          }
        }
      }
      else
      {
        if ("free".equalsIgnoreCase(paramString))
        {
          com.tencent.mm.y.c.ahI().w(262149, true);
          com.tencent.mm.kernel.g.ajR().ajA().set(208913, Boolean.TRUE);
          com.tencent.mm.kernel.g.ajR().ajA().set(229633, "http://mmbiz.qpic.cn/mmemoticon/Q3auHgzwzM5eOptD4jIj72I8icMVEKwzSYkC30IgjMvSibGfqsEdy0ibXayiaZtbibSXV5EPZEWILOvbrjjLtQ9P4QQ/0");
          com.tencent.mm.kernel.g.ajR().ajA().set(229634, System.currentTimeMillis());
          AppMethodBeat.o(108476);
          return;
        }
        if ("newp".equalsIgnoreCase(paramString))
        {
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IKQ, Boolean.TRUE);
          AppMethodBeat.o(108476);
          return;
        }
        if ("newpe".equalsIgnoreCase(paramString))
        {
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IKU, Boolean.TRUE);
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
          com.tencent.mm.kernel.g.ajQ().gDv.a(paramString, 0);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("h5"))
        {
          paramString = paramString.replace("h5", "").trim();
          PreferenceManager.getDefaultSharedPreferences(ak.getContext()).edit().putString("h5", paramString).commit();
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("md5"))
        {
          localObject1 = paramString.replace("md5", "").trim();
          paramString = (String)localObject1;
          if (bu.isNullOrNil((String)localObject1)) {
            paramString = "/sdcard/test.png";
          }
          ae.i("MicroMsg.emoji.EmojiCommandMgr", o.aRh(paramString));
          ae.i("MicroMsg.emoji.EmojiCommandMgr", com.tencent.mm.sdk.platformtools.aj.ej(paramString));
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("recommend"))
        {
          paramString = com.tencent.mm.plugin.emoji.g.d.acM("<NewRecommendEmotion><Emotion><ProductID>com.tencent.xin.emoticon.person.stiker_144984189945aa5830d33cd7dc</ProductID><RecType>3</RecType><Name>野萌君</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/duc2TvpEgSTWy4k8MnuicFjyiazriaGWDX52HzNWeLVTjtJcjZeZEicTn5kJFPYdicWZTuUZJgiaADK9I/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/DhduwiaBa7lchicgAfwibeykm81eGWXkMDgGJ8DWcOcIc28C7oTic4Y09Pick8Fw69KiaZVxrHl8S2lPY/0</Panel><ButtonType>1</ButtonType></Emotion><Emotion><ProductID>com.tencent.xin.emoticon.person.stiker_14389422638f6ca818af405e21</ProductID><RecType>3</RecType><Name>猪仔和羊妹</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/iaUiazNVkRp7iaZjrMuYgfH8kB5xkyYv20CYzY3W9HCLBr2XybJibGKKtXibMnAfZnRTH/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/PiajxSqBRaEJR9canNKZ7RYI3hx5BPCSwQmuhhlNWD1jzUSOx3CWqEtibd65zOjySd/0</Panel><ButtonType>1</ButtonType></Emotion><Emotion><ProductID>com.tencent.xin.emoticon.person.stiker_1444199720f5ea147582ff0512</ProductID><RecType>3</RecType><Name>让红包飞</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/nMl9ssowtibXLY57PdK8Nsh827vlsw4TGHPgLUehd2R455xnwe3xpoVDIKpAuXU1Aic3XbH1LfMr7fp4DgO7o8IQ/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/duc2TvpEgST18reErFRzNFR8EiahI4Iibp4ZnW1ibJYt4MMLvQvjx3sHGTMuTOgnREq5f2GXLhuzalOOz3icw9NGbA/0</Panel><ButtonType>1</ButtonType></Emotion><Emotion><ProductID>com.tencent.xin.emoticon.xiaobendan</ProductID><RecType>3</RecType><Name>小笨蛋与大坏蛋</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/ajNVdqHZLLC8ILTt0pqcaCVkldLMydoNJcupoR7qUojia3vKlgd74uQ/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/ajNVdqHZLLC8ILTt0pqcaAAEUI4a7z5ECqpUXbQw95PY1mpc4p0FxA/0</Panel><ButtonType>1</ButtonType></Emotion><Emotion><ProductID>com.tencent.xin.emoticon.shin2</ProductID><RecType>3</RecType><Name>野原新之助2</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/iciaySdkria4apGIW1wvSbPC9oxWQPHZyicaccx5JDIp2uE/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/ajNVdqHZLLASEAAX7xw76beia5j4HyA0rq9WgtgscicJo7935UCpCpog/0</Panel><ButtonType>1</ButtonType></Emotion></NewRecommendEmotion>");
          k.getEmojiStorageMgr().JfV.fwY();
          k.getEmojiStorageMgr().JfV.aS(paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("count"))
        {
          paramString = paramString.replace("count", "").trim();
          com.tencent.mm.n.g.acL().put("CustomEmojiMaxSize", paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("auto"))
        {
          paramString = paramString.replace("auto", "").trim();
          com.tencent.mm.n.g.acL().put("C2CEmojiNotAutoDownloadTimeRange", paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("bo"))
        {
          if (paramString.replace("bo", "").trim().equalsIgnoreCase("1"))
          {
            PreferenceManager.getDefaultSharedPreferences(ak.getContext()).edit().putBoolean("broken", true).commit();
            AppMethodBeat.o(108476);
            return;
          }
          PreferenceManager.getDefaultSharedPreferences(ak.getContext()).edit().putBoolean("broken", false).commit();
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
          k.getEmojiStorageMgr().Jgc.aV(paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("panel"))
        {
          paramString.replace("panel", "").trim();
          paramString = new bn();
          paramString.dny.subType = 1;
          paramString.dny.dnz = 37;
          paramString.dny.filePath = (com.tencent.mm.loader.j.b.asj() + "CheckResUpdate/37.1.data");
          com.tencent.mm.sdk.b.a.IvT.l(paramString);
          paramString = new bn();
          paramString.dny.subType = 2;
          paramString.dny.dnz = 37;
          paramString.dny.filePath = "/sdcard/tencent/MicroMsg/CheckResUpdate/37.2.data";
          com.tencent.mm.sdk.b.a.IvT.l(paramString);
          paramString = new bn();
          paramString.dny.subType = 3;
          paramString.dny.dnz = 37;
          paramString.dny.filePath = (com.tencent.mm.loader.j.b.asj() + "CheckResUpdate/37.3.data");
          com.tencent.mm.sdk.b.a.IvT.l(paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("key"))
        {
          paramString = com.tencent.mm.b.g.getMessageDigest(String.valueOf(System.currentTimeMillis()).getBytes());
          ae.i("MicroMsg.emoji.EmojiCommandMgr", "create key :%s" + bu.aSM(paramString));
          k.getEmojiStorageMgr().JfU.abN(153);
          localObject1 = new EmojiInfo();
          ((EmojiInfo)localObject1).field_md5 = paramString;
          ((EmojiInfo)localObject1).field_catalog = 153;
          k.getEmojiStorageMgr().JfU.J((EmojiInfo)localObject1);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("delete"))
        {
          a.acf(paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("delete-db"))
        {
          paramString = paramString.replace("delete-db", "").trim();
          k.getEmojiStorageMgr().JfU.cO(paramString, true);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("delete-file"))
        {
          a.ace(paramString);
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("batchDownload"))
        {
          paramString = paramString.split(" ");
          if (paramString.length > 1)
          {
            paramString = new com.tencent.mm.plugin.emoji.f.e(bu.aSB(paramString[1]));
            com.tencent.mm.kernel.g.ajQ().gDv.a(paramString, 0);
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
            com.tencent.mm.kernel.g.ajQ().gDv.a(paramString, 0);
          }
          AppMethodBeat.o(108476);
          return;
        }
        if (paramString.startsWith("test"))
        {
          ae.i("MicroMsg.emoji.EmojiCommandMgr", "theTest: %s", new Object[] { paramString });
          com.tencent.e.h.MqF.aO(new a.1());
        }
      }
    }
    AppMethodBeat.o(108476);
  }
  
  public final void acu(String paramString)
  {
    AppMethodBeat.i(176179);
    w localw = k.getEmojiStorageMgr().Jgf;
    LinkedList localLinkedList;
    int i;
    if (!bu.isNullOrNil(paramString))
    {
      localLinkedList = localw.vTm;
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < localw.vTm.size())
        {
          if (bu.lX(((v)localw.vTm.get(i)).key, paramString))
          {
            localv = (v)localw.vTm.get(i);
            if (localv == null)
            {
              localv = new v();
              localv.key = paramString;
              localv.JiY += 1;
              localv.hiI = System.currentTimeMillis();
              localw.vTm.add(0, localv);
              if (localw.vTm.size() > 9) {
                localw.vTm.remove(localw.vTm.size() - 1);
              }
              localw.doNotify("event_update_recent", 0, Integer.valueOf(localw.vTm.size()));
              AppMethodBeat.o(176179);
            }
          }
          else
          {
            i += 1;
            continue;
          }
          localw.vTm.remove(i);
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
  
  public final boolean acv(String paramString)
  {
    bool2 = false;
    AppMethodBeat.i(108499);
    com.tencent.mm.plugin.gif.f localf = new com.tencent.mm.plugin.gif.f(paramString);
    int i = (int)o.aZR(paramString);
    if (i != 0) {
      bool1 = bool2;
    }
    try
    {
      if (i <= com.tencent.mm.n.b.acq())
      {
        bool1 = bool2;
        if (localf.uLz[0] <= com.tencent.mm.n.b.acp())
        {
          i = localf.uLz[1];
          int j = com.tencent.mm.n.b.acp();
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
        ae.e("MicroMsg.emoji.EmojiMgrImpl", bu.o(paramString));
        bool1 = bool2;
        continue;
        bool1 = true;
      }
    }
    AppMethodBeat.o(108499);
    return bool1;
  }
  
  public final void acw(String paramString)
  {
    AppMethodBeat.i(108501);
    if (!bu.isNullOrNil(paramString))
    {
      ae.i("MicroMsg.emoji.EmojiMgrImpl", "deleteCaptureEmoji md: ".concat(String.valueOf(paramString)));
      k.getEmojiStorageMgr().JfU.cO(paramString, true);
      k.getEmojiStorageMgr().JfU.doNotify("delete_emoji_info_notify");
    }
    AppMethodBeat.o(108501);
  }
  
  public final void acx(String paramString)
  {
    AppMethodBeat.i(108503);
    EmojiInfo localEmojiInfo = aci(paramString);
    if (localEmojiInfo != null)
    {
      paramString = com.tencent.mm.emoji.c.i.gsD;
      com.tencent.mm.emoji.c.i.o(localEmojiInfo);
      AppMethodBeat.o(108503);
      return;
    }
    ae.w("MicroMsg.emoji.EmojiMgrImpl", "addCaptureEmojiUploadTask: emojiInfo null by md5 %s", new Object[] { paramString });
    AppMethodBeat.o(108503);
  }
  
  public final boolean afq()
  {
    AppMethodBeat.i(108492);
    boolean bool = com.tencent.mm.emoji.a.m.afq();
    AppMethodBeat.o(108492);
    return bool;
  }
  
  public final boolean afr()
  {
    AppMethodBeat.i(108493);
    if ((com.tencent.mm.sdk.platformtools.bv.fpT()) || (com.tencent.mm.emoji.a.m.afr()))
    {
      AppMethodBeat.o(108493);
      return true;
    }
    AppMethodBeat.o(108493);
    return false;
  }
  
  public final <T> T c(am.a parama, T paramT)
  {
    AppMethodBeat.i(108497);
    parama = com.tencent.mm.kernel.g.ajR().ajA().get(parama, paramT);
    AppMethodBeat.o(108497);
    return parama;
  }
  
  public final boolean chK()
  {
    AppMethodBeat.i(108469);
    boolean bool = com.tencent.mm.emoji.a.m.afj();
    AppMethodBeat.o(108469);
    return bool;
  }
  
  public final ArrayList<SmileyInfo> chL()
  {
    AppMethodBeat.i(108470);
    ArrayList localArrayList = k.getEmojiStorageMgr().Jgc.chL();
    AppMethodBeat.o(108470);
    return localArrayList;
  }
  
  public final ArrayList<SmileyPanelConfigInfo> chM()
  {
    AppMethodBeat.i(108471);
    ArrayList localArrayList = k.getEmojiStorageMgr().Jgd.chM();
    AppMethodBeat.o(108471);
    return localArrayList;
  }
  
  public final com.tencent.mm.bb.f chN()
  {
    AppMethodBeat.i(108475);
    com.tencent.mm.bb.f localf = h.chV().chN();
    AppMethodBeat.o(108475);
    return localf;
  }
  
  public final boolean chO()
  {
    AppMethodBeat.i(108477);
    if ((com.tencent.mm.sdk.platformtools.bv.fpT()) || (com.tencent.mm.emoji.a.m.afs()))
    {
      AppMethodBeat.o(108477);
      return true;
    }
    AppMethodBeat.o(108477);
    return false;
  }
  
  public final String chP()
  {
    AppMethodBeat.i(108478);
    h.chV();
    String str = h.chP();
    AppMethodBeat.o(108478);
    return str;
  }
  
  public final void chQ()
  {
    AppMethodBeat.i(108479);
    h.chV();
    bn localbn = new bn();
    localbn.dny.filePath = (com.tencent.mm.loader.j.b.asj() + "CheckResUpdate/37.1.data.decompressed");
    localbn.dny.dnz = 37;
    localbn.dny.subType = 1;
    h.a(localbn, h.a.pJO, h.pJo);
    AppMethodBeat.o(108479);
  }
  
  public final boolean chR()
  {
    AppMethodBeat.i(108491);
    boolean bool = com.tencent.mm.emoji.a.m.afp();
    AppMethodBeat.o(108491);
    return bool;
  }
  
  public final List<v> chS()
  {
    AppMethodBeat.i(108495);
    List localList = k.getEmojiStorageMgr().Jgf.chS();
    AppMethodBeat.o(108495);
    return localList;
  }
  
  public final void chT()
  {
    AppMethodBeat.i(108496);
    Object localObject = k.getEmojiStorageMgr().Jgf.chS();
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
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IYu, localJSONArray.toString());
    AppMethodBeat.o(108496);
  }
  
  public final boolean chU()
  {
    AppMethodBeat.i(108500);
    if (!com.tencent.mm.kernel.g.ajR().ajA().getBoolean(am.a.IYA, true)) {}
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
      i = com.tencent.mm.n.b.acq();
      AppMethodBeat.o(108480);
      return i;
    }
    i = com.tencent.mm.n.b.aco();
    AppMethodBeat.o(108480);
    return i;
  }
  
  public final void d(am.a parama, Object paramObject)
  {
    AppMethodBeat.i(108498);
    com.tencent.mm.kernel.g.ajR().ajA().set(parama, paramObject);
    AppMethodBeat.o(108498);
  }
  
  public final bd fB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108449);
    Map localMap = bx.M(paramString1, "msg");
    if (localMap == null)
    {
      ae.w("MicroMsg.emoji.EmojiMgrImpl", "get from xml, but attrs is null");
      AppMethodBeat.o(108449);
      return null;
    }
    paramString2 = bd.e(localMap, paramString2, paramString1);
    if (paramString2 == null)
    {
      ae.w("MicroMsg.emoji.EmojiMgrImpl", "parserEmojiXml error ".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(108449);
      return null;
    }
    AppMethodBeat.o(108449);
    return paramString2;
  }
  
  public final String fC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108474);
    com.tencent.mm.emoji.d.a locala = com.tencent.mm.emoji.d.a.gsI;
    paramString1 = EmojiLogic.R(com.tencent.mm.emoji.d.a.agD(), paramString1, paramString2);
    AppMethodBeat.o(108474);
    return paramString1;
  }
  
  public final String getAccPath()
  {
    AppMethodBeat.i(108457);
    String str = com.tencent.mm.kernel.g.ajR().gDT;
    AppMethodBeat.o(108457);
    return str;
  }
  
  public final String getDataEmojiPath()
  {
    AppMethodBeat.i(194861);
    String str = h.getDataEmojiPath();
    AppMethodBeat.o(194861);
    return str;
  }
  
  public final void h(k.a parama)
  {
    AppMethodBeat.i(108487);
    k.getEmojiStorageMgr().JfU.remove(parama);
    AppMethodBeat.o(108487);
  }
  
  public final void i(k.a parama)
  {
    AppMethodBeat.i(108488);
    k.getEmojiStorageMgr().JfU.add(parama);
    AppMethodBeat.o(108488);
  }
  
  public final void j(k.a parama)
  {
    AppMethodBeat.i(108489);
    k.getEmojiStorageMgr().JfV.remove(parama);
    AppMethodBeat.o(108489);
  }
  
  public final void k(k.a parama)
  {
    AppMethodBeat.i(108490);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajO().ajq()).akL()) {
      k.getEmojiStorageMgr().JfV.add(parama);
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
    if (paramEmojiInfo.field_catalog == EmojiGroupInfo.OzS)
    {
      localObject = paramEmojiInfo;
      if (paramEmojiInfo.getContent().length() > 0)
      {
        localObject = paramEmojiInfo;
        if (EmojiInfo.abI(bu.getInt(paramEmojiInfo.getContent(), 0)))
        {
          Cursor localCursor = k.getEmojiStorageMgr().JfU.abM(bu.getInt(paramEmojiInfo.getContent(), 0));
          EmojiInfo localEmojiInfo = paramEmojiInfo;
          if (localCursor != null)
          {
            localEmojiInfo = paramEmojiInfo;
            if (localCursor.getCount() > 1)
            {
              int i = bu.jA(localCursor.getCount() - 1, 0);
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
      if ((paramEmojiInfo.field_catalog == EmojiInfo.OzY) || (String.valueOf(EmojiInfo.OzY).equals(paramEmojiInfo.field_groupId)))
      {
        AppMethodBeat.o(108465);
        return 2131232753;
      }
      if ((paramEmojiInfo.field_catalog == EmojiInfo.OzZ) || (String.valueOf(EmojiInfo.OzZ).equals(paramEmojiInfo.field_groupId)))
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
      if (paramEmojiInfo.field_catalog == EmojiInfo.OzY) {
        return new int[] { 2131232755, 2131232756, 2131232754 };
      }
      if (paramEmojiInfo.field_catalog == EmojiInfo.OzZ) {
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
      localObject = aci(paramEmojiInfo.field_md5);
      if ((localObject != null) && (((EmojiInfo)localObject).field_reserved4 != paramEmojiInfo.field_reserved4)) {
        paramEmojiInfo.field_reserved4 = ((EmojiInfo)localObject).field_reserved4;
      }
    }
    paramEmojiInfo = com.tencent.mm.emoji.decode.a.aeE().a(paramEmojiInfo);
    if (com.tencent.mm.sdk.platformtools.u.cy(paramEmojiInfo))
    {
      localObject = MMWXGFJNI.nativeWxamToGif(paramEmojiInfo);
      if (bu.cF((byte[])localObject)) {
        ae.w("MicroMsg.emoji.EmojiMgrImpl", "decodeAsGif: wxam to gif error");
      }
      for (;;)
      {
        AppMethodBeat.o(108467);
        return localObject;
        ae.i("MicroMsg.emoji.EmojiMgrImpl", "decodeAsGif: %s, %s", new Object[] { Integer.valueOf(paramEmojiInfo.length), Integer.valueOf(localObject.length) });
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
    ((List)localObject).add(paramEmojiInfo.Lj());
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().JfU.s(1, (List)localObject);
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().JfU.K(paramEmojiInfo);
    paramEmojiInfo = new dl();
    paramEmojiInfo.dpl.type = 2;
    com.tencent.mm.sdk.b.a.IvT.l(paramEmojiInfo);
    if (!paramEmojiInfo.dpm.dpn)
    {
      paramEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().JfX.fxE();
      if (paramEmojiInfo != null)
      {
        localObject = paramEmojiInfo.HMN.iterator();
        while (((Iterator)localObject).hasNext())
        {
          dfp localdfp = (dfp)((Iterator)localObject).next();
          if (localdfp.ProductID.equals(String.valueOf("capture"))) {
            localdfp.FUF = 0;
          }
        }
      }
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().JfX.a(paramEmojiInfo);
      com.tencent.mm.ca.a.flq();
      paramEmojiInfo = com.tencent.mm.ca.a.Ipp;
      a.b.aRa(String.valueOf("capture"));
    }
    AppMethodBeat.o(108502);
  }
  
  public final void updateEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108452);
    k.getEmojiStorageMgr().JfU.K(paramEmojiInfo);
    AppMethodBeat.o(108452);
  }
  
  public final boolean v(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(108446);
    if (paramContext == null)
    {
      ae.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: context is null");
      AppMethodBeat.o(108446);
      return false;
    }
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)))
    {
      ae.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: userName or imgPath is null");
      AppMethodBeat.o(108446);
      return false;
    }
    EmojiInfo localEmojiInfo = k.getEmojiStorageMgr().JfU.aWl(paramString2);
    if (localEmojiInfo == null)
    {
      ae.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: emoji not found, imgPath %s", new Object[] { paramString2 });
      AppMethodBeat.o(108446);
      return false;
    }
    if ((localEmojiInfo.field_type == EmojiInfo.OAe) || (localEmojiInfo.field_type == EmojiInfo.OAf))
    {
      paramContext = new WXMediaMessage();
      paramString2 = localEmojiInfo.fSQ();
      if (o.fB(localEmojiInfo.fSR())) {
        paramContext.thumbData = o.bb(localEmojiInfo.fSR(), 0, -1);
      }
      for (;;)
      {
        paramContext.mediaObject = new WXEmojiObject(paramString2);
        paramString2 = new sv();
        paramString2.dIs.dve = paramContext;
        paramString2.dIs.appId = localEmojiInfo.field_app_id;
        paramString2.dIs.appName = null;
        paramString2.dIs.toUser = paramString1;
        paramString2.dIs.dvf = 0;
        paramString2.dIs.dIv = localEmojiInfo.Lj();
        com.tencent.mm.sdk.b.a.IvT.l(paramString2);
        AppMethodBeat.o(108446);
        return true;
        paramContext.setThumbImage(localEmojiInfo.fxp());
      }
    }
    paramString2 = localEmojiInfo;
    if (localEmojiInfo.field_type == EmojiInfo.OAb)
    {
      if (!EmojiInfo.abI(localEmojiInfo.field_catalog)) {
        break label363;
      }
      paramContext = k.getEmojiStorageMgr().JfU.abM(localEmojiInfo.field_catalog);
    }
    for (;;)
    {
      paramString2 = localEmojiInfo;
      if (paramContext != null)
      {
        int i = bu.jA(paramContext.getCount() - 1, 0);
        paramString2 = new EmojiInfo();
        paramContext.moveToPosition(i);
        paramString2.convertFrom(paramContext);
        paramContext.close();
      }
      k.cif().a(paramString1, paramString2, null);
      break;
      label363:
      if ((localEmojiInfo.field_catalog == EmojiInfo.OzW) && (localEmojiInfo.getContent().length() > 0) && (EmojiInfo.abI(bu.getInt(localEmojiInfo.getContent(), 0)))) {
        paramContext = k.getEmojiStorageMgr().JfU.abM(bu.getInt(localEmojiInfo.getContent(), 0));
      } else {
        paramContext = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.f
 * JD-Core Version:    0.7.0.1
 */