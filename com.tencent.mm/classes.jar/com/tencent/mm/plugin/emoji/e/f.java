package com.tencent.mm.plugin.emoji.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.h.a.be;
import com.tencent.mm.h.a.pb;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.f.d;
import com.tencent.mm.plugin.emoji.f.o;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI;
import com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI;
import com.tencent.mm.pluginsdk.g.a.a.b.c;
import com.tencent.mm.pluginsdk.g.a.a.m;
import com.tencent.mm.protocal.c.bsl;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.aq.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.q;
import com.tencent.mm.storage.emotion.r;
import com.tencent.mm.storage.emotion.t;
import com.tencent.mm.storage.emotion.u;
import com.tencent.mm.storage.emotion.v;
import com.tencent.mm.storage.z;
import com.tencent.recovery.util.Util;
import java.util.ArrayList;
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
    if (paramString1.equals("-1"))
    {
      y.e("MicroMsg.emoji.EmojiMgrImpl", "showEmoji fail cause md5 is no valid");
      return;
    }
    EmojiInfo localEmojiInfo = i.getEmojiStorageMgr().uBb.acC(paramString1);
    if (localEmojiInfo == null)
    {
      y.e("MicroMsg.emoji.EmojiMgrImpl", "showEmoji fail cause md5 is no valid");
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
      if (com.tencent.mm.model.s.fn(paramString4))
      {
        paramString1 = bd.iI(paramString5);
        localIntent.putExtra("room_id", paramString6);
      }
      localIntent.putExtra("msg_sender", paramString1);
      paramContext.startActivity(localIntent);
      return;
      localIntent.putExtra("custom_smiley_preview_appid", localEmojiInfo.field_app_id);
    }
  }
  
  private static boolean a(Context paramContext, EmojiInfo paramEmojiInfo, int paramInt1, String paramString1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString2, ArrayList<String> paramArrayList, String paramString3)
  {
    if (paramContext == null)
    {
      y.e("MicroMsg.emoji.EmojiMgrImpl", "[cpan] save emoji failed. context is null");
      return false;
    }
    if (paramEmojiInfo == null)
    {
      y.e("MicroMsg.emoji.EmojiMgrImpl", "[cpan] save emoji failed. emoji is null");
      return false;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, EmojiAddCustomDialogUI.class);
    localIntent.putExtra("extra_id", paramEmojiInfo.Wv());
    localIntent.putExtra("extra_scence", paramInt1);
    localIntent.putExtra("extra_move_to_top", true);
    localIntent.putExtra("extra_username", paramString1);
    localIntent.putExtra("extra_current", paramBoolean1);
    localIntent.putExtra("key_is_selfie", paramBoolean2);
    localIntent.putExtra("key_attached_text", paramString2);
    localIntent.putExtra("key_attached_emoji_md5", paramArrayList);
    localIntent.putExtra("key_imitate_md5", paramString3);
    localIntent.addFlags(65536);
    if ((paramInt2 > 0) && ((paramContext instanceof Activity))) {
      ((Activity)paramContext).startActivityForResult(localIntent, paramInt2);
    }
    for (;;)
    {
      return true;
      paramContext.startActivity(localIntent);
    }
  }
  
  private static void c(g.a parama)
  {
    i.aHV();
    if (parama == null)
    {
      y.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "msg content is null");
      return;
    }
    String str = parama.dQx;
    if (bk.bl(str))
    {
      y.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "md5 is null.");
      return;
    }
    EmojiInfo localEmojiInfo = new EmojiInfo();
    localEmojiInfo.field_md5 = str;
    localEmojiInfo.field_app_id = parama.appId;
    localEmojiInfo.field_catalog = EmojiInfo.uCT;
    localEmojiInfo.field_size = parama.dQv;
    localEmojiInfo.field_temp = 1;
    localEmojiInfo.field_state = EmojiInfo.uDj;
    i.getEmojiStorageMgr().uBb.p(localEmojiInfo);
    parama = new LinkedList();
    parama.add(str);
    parama = new com.tencent.mm.plugin.emoji.f.f(parama);
    g.DO().dJT.a(parama, 0);
    com.tencent.mm.plugin.emoji.model.c.bx(str, 0);
    y.d("MicroMsg.emoji.EmojiAppMsgDownloadService", "start change cdn url. md5:%s", new Object[] { str });
  }
  
  public final String AA(String paramString)
  {
    return EmojiLogic.AA(paramString);
  }
  
  public final int AB(String paramString)
  {
    return EmojiLogic.AB(paramString);
  }
  
  public final String AC(String paramString)
  {
    return EmojiLogic.AC(paramString);
  }
  
  public final void AD(String paramString)
  {
    if (bk.bl(paramString)) {
      y.i("MicroMsg.emoji.EmojiCommandMgr", "emoji command is null.");
    }
    if ("sync".equalsIgnoreCase(paramString))
    {
      g.DP().Dz().c(ac.a.unY, Boolean.valueOf(true));
      g.DP().Dz().c(ac.a.uod, Boolean.valueOf(true));
      g.DP().Dz().c(ac.a.uog, Long.valueOf(0L));
      g.DP().Dz().c(ac.a.unX, Long.valueOf(0L));
      g.DO().dJT.a(new com.tencent.mm.plugin.emoji.f.f(), 0);
      paramString = new o(8, null, 15, true);
      g.DO().dJT.a(paramString, 0);
    }
    label523:
    do
    {
      return;
      if ("rcheart".equalsIgnoreCase(paramString))
      {
        i.getEmojiStorageMgr().uBc.cwx();
        return;
      }
      if ("recover".equalsIgnoreCase(paramString))
      {
        y.i("MicroMsg.emoji.EmojiCommandMgr", "recover   begin");
        i.getEmojiStorageMgr().uBb.gj(ae.getContext());
        i.getEmojiStorageMgr().uBc.gj(ae.getContext());
        y.i("MicroMsg.emoji.EmojiCommandMgr", "recover   end");
        return;
      }
      if ("clean".equalsIgnoreCase(paramString))
      {
        y.i("MicroMsg.emoji.EmojiCommandMgr", "begin clean");
        c.aHb().Ar(com.tencent.mm.plugin.emoji.h.b.FL());
        g.DP().Dz().c(ac.a.uod, Boolean.valueOf(true));
        y.i("MicroMsg.emoji.EmojiCommandMgr", "end clean");
        return;
      }
      if ("dump".equalsIgnoreCase(paramString))
      {
        y.i("MicroMsg.emoji.EmojiCommandMgr", "begin dump emoji db info:");
        paramString = (ArrayList)i.getEmojiStorageMgr().uBc.cwj();
        if (paramString.size() > 0)
        {
          int j = paramString.size();
          int i = 0;
          while (i < j)
          {
            y.i("MicroMsg.emoji.EmojiCommandMgr", "i:%d group info:%s", new Object[] { Integer.valueOf(i), ((EmojiGroupInfo)paramString.get(i)).toString() });
            i += 1;
          }
        }
        Object localObject = null;
        paramString = null;
        try
        {
          localCursor = i.getEmojiStorageMgr().uBb.aAn();
          if (localCursor != null)
          {
            paramString = localCursor;
            localObject = localCursor;
            if (localCursor.moveToFirst())
            {
              boolean bool;
              do
              {
                paramString = localCursor;
                localObject = localCursor;
                EmojiInfo localEmojiInfo = new EmojiInfo();
                paramString = localCursor;
                localObject = localCursor;
                localEmojiInfo.d(localCursor);
                paramString = localCursor;
                localObject = localCursor;
                y.i("MicroMsg.emoji.EmojiCommandMgr", "emoji info:%s", new Object[] { localEmojiInfo.toString() });
                paramString = localCursor;
                localObject = localCursor;
                bool = localCursor.moveToNext();
              } while (bool);
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Cursor localCursor;
            if (paramString != null) {
              paramString.close();
            }
          }
        }
        finally
        {
          if (localException == null) {
            break label523;
          }
          localException.close();
        }
        y.i("MicroMsg.emoji.EmojiCommandMgr", "end dump emoji db info:");
        return;
      }
      if ("config".equalsIgnoreCase(paramString))
      {
        b.c.clv().d(37, 1, -1, false);
        b.c.clv().d(37, 2, -1, false);
        g.DP().Dz().c(ac.a.uon, Integer.valueOf(0));
        g.DP().Dz().c(ac.a.uoo, Integer.valueOf(0));
        g.DP().Dz().c(ac.a.uoq, Integer.valueOf(0));
        paramString = new m(37);
        g.DO().dJT.a(paramString, 0);
        paramString = new be();
        paramString.bHu.filePath = (com.tencent.mm.compatible.util.e.bkH + "CheckResUpdate/37.1.data.decompressed");
        paramString.bHu.bHv = 37;
        paramString.bHu.brC = 1;
        be localbe = new be();
        localbe.bHu.filePath = (com.tencent.mm.compatible.util.e.bkH + "CheckResUpdate/37.2.data.decompressed");
        localbe.bHu.bHv = 37;
        localbe.bHu.brC = 2;
        h.aHx();
        h.a(paramString, true);
        h.aHx();
        h.b(localbe, true);
        return;
      }
    } while (!"tuzki".equalsIgnoreCase(paramString));
    com.tencent.mm.plugin.emoji.f.b.aHY();
    com.tencent.mm.plugin.emoji.f.b.aHZ();
  }
  
  public final int AE(String paramString)
  {
    return i.getEmojiStorageMgr().uBb.AE(paramString);
  }
  
  public final ArrayList<EmojiInfo> AF(String paramString)
  {
    at localat = i.getEmojiStorageMgr();
    if (at.uBt == null) {
      at.uBt = new HashMap();
    }
    if (at.uBq)
    {
      at.uBt.clear();
      at.uBq = false;
    }
    if ((!at.uBt.containsKey(paramString)) && (g.DP().isSDCardAvailable())) {
      at.uBt.put(paramString, (ArrayList)localat.uBb.Av(paramString));
    }
    return (ArrayList)at.uBt.get(paramString);
  }
  
  public final boolean AG(String paramString)
  {
    com.tencent.mm.plugin.gif.f localf = new com.tencent.mm.plugin.gif.f(paramString);
    int i = com.tencent.mm.a.e.bJ(paramString);
    if (i != 0) {}
    try
    {
      if ((i <= com.tencent.mm.m.b.Ah()) && (localf.lhL[0] <= com.tencent.mm.m.b.Ag()))
      {
        i = localf.lhL[1];
        int j = com.tencent.mm.m.b.Ag();
        if (i <= j) {}
      }
      else
      {
        return false;
      }
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.emoji.EmojiMgrImpl", bk.j(paramString));
      return false;
    }
    return true;
  }
  
  public final EmojiInfo As(String paramString)
  {
    return i.getEmojiStorageMgr().uBb.acC(paramString);
  }
  
  public final EmojiInfo At(String paramString)
  {
    return As(paramString);
  }
  
  public final String Au(String paramString)
  {
    return EmojiLogic.Au(paramString);
  }
  
  public final List<EmojiInfo> Av(String paramString)
  {
    if (g.DP().isSDCardAvailable()) {
      return (ArrayList)i.getEmojiStorageMgr().uBb.Av(paramString);
    }
    return new ArrayList();
  }
  
  public final String Aw(String paramString)
  {
    return i.getEmojiDescMgr().Aw(paramString);
  }
  
  public final boolean Ax(String paramString)
  {
    return i.getEmojiStorageMgr().uBc.acx(paramString);
  }
  
  public final ArrayList<String> Ay(String paramString)
  {
    aq localaq = i.getEmojiDescMgr();
    if (!localaq.mInit) {
      localaq.cuR();
    }
    long l = System.currentTimeMillis();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = com.tencent.mm.ui.tools.f.aek(paramString);
    if ((i < localaq.uAE) || (i > localaq.uAF))
    {
      y.d("MicroMsg.emoji.EmojiDescNewMgr", "input text over checkout limit.");
      return null;
    }
    if ((!bk.bl(paramString)) && (localaq.uAJ != null))
    {
      paramString = paramString.toLowerCase();
      Object localObject = new ArrayList();
      if (localaq.uAI.containsKey(paramString)) {
        ((ArrayList)localObject).addAll((Collection)localaq.uAH.get(localaq.uAI.get(paramString)));
      }
      for (;;)
      {
        paramString = ((ArrayList)localObject).iterator();
        while (paramString.hasNext())
        {
          localObject = (String)paramString.next();
          localObject = (ArrayList)localaq.uAJ.get(localObject);
          if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
            localArrayList1.addAll((Collection)localObject);
          }
        }
        ((ArrayList)localObject).add(paramString);
      }
    }
    if (!localArrayList1.isEmpty())
    {
      Collections.sort(localArrayList1, localaq.uAK);
      i = 0;
      while (i < localArrayList1.size())
      {
        localArrayList2.add(((aq.a)localArrayList1.get(i)).bIW);
        i += 1;
      }
    }
    y.d("MicroMsg.emoji.EmojiDescNewMgr", "cpan[check desc]User time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    return localArrayList2;
  }
  
  public final String Az(String paramString)
  {
    return EmojiLogic.Az(paramString);
  }
  
  public final String FU()
  {
    return g.DP().dKt;
  }
  
  public final EmojiInfo a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    return i.getEmojiStorageMgr().uBb.b(paramString1, paramString2, paramInt1, paramInt2, paramInt3, null, paramString3);
  }
  
  public final <T> T a(ac.a parama, T paramT)
  {
    return g.DP().Dz().get(parama, paramT);
  }
  
  public final String a(Context paramContext, WXMediaMessage paramWXMediaMessage, String paramString)
  {
    return EmojiLogic.b(paramContext, paramWXMediaMessage, paramString);
  }
  
  public final void a(Context paramContext, bi parambi, String paramString)
  {
    if ((paramContext == null) || (parambi == null))
    {
      y.w("MicroMsg.emoji.EmojiMgrImpl", "context or msg is null");
      return;
    }
    ap localap = ap.abP(parambi.field_content);
    Object localObject2 = g.a.gp(parambi.field_content);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new g.a();
      ((g.a)localObject1).dQx = localap.bIW;
    }
    localObject2 = i.getEmojiStorageMgr().uBb.acC(((g.a)localObject1).dQx);
    if (parambi.field_isSend == 1)
    {
      if ((localObject2 != null) && (((EmojiInfo)localObject2).cwz()))
      {
        a(paramContext, ((g.a)localObject1).dQx, ((g.a)localObject1).appId, ((g.a)localObject1).appName, parambi.field_msgSvrId, parambi.field_talker, parambi.field_content, paramString);
        return;
      }
      l = parambi.field_msgId;
      c((g.a)localObject1);
      return;
    }
    if ((localObject2 != null) && (((EmojiInfo)localObject2).cwz()))
    {
      a(paramContext, ((EmojiInfo)localObject2).Wv(), ((g.a)localObject1).appId, ((g.a)localObject1).appName, parambi.field_msgSvrId, parambi.field_talker, parambi.field_content, paramString);
      return;
    }
    long l = parambi.field_msgId;
    c((g.a)localObject1);
  }
  
  public final void a(bsl parambsl)
  {
    i.getEmojiStorageMgr().uBe.b(parambsl);
  }
  
  public final void a(String paramString, EmojiInfo paramEmojiInfo, bi parambi)
  {
    if ((paramEmojiInfo == null) && (parambi == null)) {
      return;
    }
    EmojiInfo localEmojiInfo = paramEmojiInfo;
    if (paramEmojiInfo == null) {
      localEmojiInfo = i.getEmojiStorageMgr().uBb.acC(parambi.field_imgPath);
    }
    i.aHO().a(paramString, localEmojiInfo, parambi);
  }
  
  public final boolean a(Context paramContext, EmojiInfo paramEmojiInfo, int paramInt1, int paramInt2, boolean paramBoolean, String paramString1, ArrayList<String> paramArrayList, String paramString2)
  {
    return a(paramContext, paramEmojiInfo, paramInt1, null, paramInt2, true, paramBoolean, paramString1, paramArrayList, paramString2);
  }
  
  public final boolean a(Context paramContext, EmojiInfo paramEmojiInfo, int paramInt, String paramString)
  {
    return a(paramContext, paramEmojiInfo, paramInt, paramString, -1, false, false, null, null, null);
  }
  
  public final boolean a(EmojiGroupInfo paramEmojiGroupInfo)
  {
    return i.getEmojiStorageMgr().uBc.c(paramEmojiGroupInfo, new String[] { "productID" });
  }
  
  public final boolean a(String paramString1, String paramString2, long paramLong, String paramString3, e.a parama)
  {
    boolean bool = false;
    com.tencent.mm.plugin.emoji.model.d locald = i.aHO();
    y.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml " + paramString2);
    paramString1 = as.a(bn.s(paramString2, "msg"), paramString1, paramString2, paramString3);
    if (paramString1 == null)
    {
      y.i("MicroMsg.emoji.EmojiService", "prepareEmoji failed. emoji msg info is null.");
      return true;
    }
    paramString1.bXr = paramLong;
    y.i("MicroMsg.emoji.EmojiService", "summerbadcr prepareEmoji msgSvrId[%d], stack[%s]", new Object[] { Long.valueOf(paramLong), bk.csb() });
    locald.AQ(paramString1.bJd);
    if (!EmojiLogic.AP(l.aHD())) {
      bool = true;
    }
    locald.a(paramString1, parama, bool);
    return true;
  }
  
  public final byte[] a(EmojiInfo paramEmojiInfo)
  {
    if (paramEmojiInfo != null)
    {
      EmojiInfo localEmojiInfo = As(paramEmojiInfo.field_md5);
      if ((localEmojiInfo != null) && (localEmojiInfo.field_reserved4 != paramEmojiInfo.field_reserved4)) {
        paramEmojiInfo.field_reserved4 = localEmojiInfo.field_reserved4;
      }
    }
    return d.aHc().a(paramEmojiInfo);
  }
  
  public final boolean aHf()
  {
    return EmojiLogic.aHf();
  }
  
  public final boolean aHg()
  {
    return l.aHB();
  }
  
  public final ArrayList<q> aHh()
  {
    return i.getEmojiStorageMgr().uBj.aHh();
  }
  
  public final ArrayList<com.tencent.mm.storage.emotion.s> aHi()
  {
    return i.getEmojiStorageMgr().uBk.aHi();
  }
  
  public final com.tencent.mm.az.f aHj()
  {
    return h.aHx().aHj();
  }
  
  public final String aHk()
  {
    h.aHx();
    return h.aHk();
  }
  
  public final void aHl()
  {
    h.aHx();
    be localbe = new be();
    localbe.bHu.filePath = (com.tencent.mm.compatible.util.e.bkH + "CheckResUpdate/37.1.data.decompressed");
    localbe.bHu.bHv = 37;
    localbe.bHu.brC = 1;
    h.a(localbe, h.a.iXi, h.iWM);
  }
  
  public final bsl aHm()
  {
    return i.getEmojiStorageMgr().uBe.aHm();
  }
  
  public final ArrayList<EmojiGroupInfo> aHn()
  {
    return i.getEmojiStorageMgr().aHn();
  }
  
  public final int aHo()
  {
    return i.getEmojiStorageMgr().aHo();
  }
  
  public final ArrayList<EmojiInfo> aHp()
  {
    return i.getEmojiStorageMgr().aHp();
  }
  
  public final ArrayList<EmojiInfo> aHq()
  {
    at localat = i.getEmojiStorageMgr();
    if (at.uBt == null) {
      at.uBt = new HashMap();
    }
    if ((!at.uBt.containsKey("downloadcustom")) || (at.uBo)) {
      at.uBt.put("downloadcustom", (ArrayList)localat.uBb.cwM());
    }
    at.uBo = false;
    return (ArrayList)at.uBt.get("downloadcustom");
  }
  
  public final com.tencent.mm.as.a.a aHr()
  {
    return i.aHr();
  }
  
  public final boolean aHs()
  {
    return l.aHG();
  }
  
  public final boolean aHt()
  {
    return l.aHt();
  }
  
  public final boolean aHu()
  {
    return (bl.csf()) || (l.aHu());
  }
  
  public final List<u> aHv()
  {
    return i.getEmojiStorageMgr().uBm.aHv();
  }
  
  public final void aHw()
  {
    v localv = i.getEmojiStorageMgr().uBm;
    Object localObject = localv.aHv();
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
    g.DP().Dz().c(ac.a.uzx, localJSONArray.toString());
    localv.uDz = null;
  }
  
  public final void b(ac.a parama, Object paramObject)
  {
    g.DP().Dz().c(parama, paramObject);
  }
  
  public final boolean bNy()
  {
    boolean bool1 = g.DP().Dz().getBoolean(ac.a.uzA, false);
    long l1 = ((Long)g.DP().Dz().get(ac.a.wuQ, Long.valueOf(System.currentTimeMillis()))).longValue();
    boolean bool2 = g.DP().Dz().getBoolean(ac.a.wuR, false);
    long l2 = System.currentTimeMillis();
    return (!bool1) && (!bool2) && (l2 > l1) && (l2 - l1 < 604800000L);
  }
  
  public final void bv(String paramString, int paramInt)
  {
    v localv = i.getEmojiStorageMgr().uBm;
    if (!Util.bl(paramString))
    {
      if (localv.uDz == null) {
        localv.cwV();
      }
      u localu2 = (u)localv.uDz.get(paramString);
      u localu1 = localu2;
      if (localu2 == null)
      {
        localu1 = new u();
        localu1.key = paramString;
        localv.uDz.put(paramString, localu1);
      }
      localu1.position = paramInt;
      localu1.uDy += 1;
      localu1.dXA = System.currentTimeMillis();
      if (localv.uDz == null) {
        localv.cwV();
      }
      localv.b("event_update_recent", 0, Integer.valueOf(localv.uDz.size()));
    }
  }
  
  public final EmojiInfo c(EmojiInfo paramEmojiInfo)
  {
    Object localObject = paramEmojiInfo;
    if (paramEmojiInfo.field_catalog == EmojiGroupInfo.uCR)
    {
      localObject = paramEmojiInfo;
      if (paramEmojiInfo.field_type == EmojiInfo.uDa)
      {
        localObject = paramEmojiInfo;
        if (paramEmojiInfo.getContent().length() > 0)
        {
          localObject = paramEmojiInfo;
          if (EmojiInfo.Fu(bk.getInt(paramEmojiInfo.getContent(), 0)))
          {
            Cursor localCursor = i.getEmojiStorageMgr().uBb.Fy(bk.getInt(paramEmojiInfo.getContent(), 0));
            EmojiInfo localEmojiInfo = paramEmojiInfo;
            if (localCursor != null)
            {
              localEmojiInfo = paramEmojiInfo;
              if (localCursor.getCount() > 1)
              {
                int i = bk.fe(localCursor.getCount() - 1, 0);
                localEmojiInfo = new EmojiInfo();
                localCursor.moveToPosition(i);
                localEmojiInfo.d(localCursor);
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
    return localObject;
  }
  
  public final as cM(String paramString1, String paramString2)
  {
    Map localMap = bn.s(paramString1, "msg");
    if (localMap == null)
    {
      y.w("MicroMsg.emoji.EmojiMgrImpl", "get from xml, but attrs is null");
      return null;
    }
    paramString2 = as.a(localMap, paramString2, paramString1, "");
    if (paramString2 == null)
    {
      y.w("MicroMsg.emoji.EmojiMgrImpl", "parserEmojiXml error " + paramString1);
      return null;
    }
    return paramString2;
  }
  
  public final String cN(String paramString1, String paramString2)
  {
    return EmojiLogic.J(com.tencent.mm.plugin.emoji.h.b.FL(), paramString1, paramString2);
  }
  
  public final int d(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    if ((paramBoolean) || ((paramEmojiInfo != null) && (paramEmojiInfo.field_activityid != null) && (paramEmojiInfo.field_activityid.startsWith("Selfie:")))) {}
    for (int i = 1; i != 0; i = 0) {
      return com.tencent.mm.m.b.Ah();
    }
    return com.tencent.mm.m.b.Af();
  }
  
  public final void d(EmojiInfo paramEmojiInfo)
  {
    i.getEmojiStorageMgr().uBb.q(paramEmojiInfo);
  }
  
  public final int e(EmojiInfo paramEmojiInfo)
  {
    if (paramEmojiInfo != null)
    {
      if ((paramEmojiInfo.field_catalog == EmojiInfo.uCX) || (String.valueOf(EmojiInfo.uCX).equals(paramEmojiInfo.field_groupId))) {
        return f.d.jsb;
      }
      if ((paramEmojiInfo.field_catalog == EmojiInfo.uCY) || (String.valueOf(EmojiInfo.uCY).equals(paramEmojiInfo.field_groupId))) {
        return f.d.dice;
      }
    }
    return 0;
  }
  
  public final int[] f(EmojiInfo paramEmojiInfo)
  {
    if (paramEmojiInfo != null)
    {
      if (paramEmojiInfo.field_catalog == EmojiInfo.uCX) {
        return new int[] { f.d.jsb_j, f.d.jsb_s, f.d.jsb_b };
      }
      if (paramEmojiInfo.field_catalog == EmojiInfo.uCY) {
        return new int[] { f.d.dice_action_0, f.d.dice_action_1, f.d.dice_action_2, f.d.dice_action_3 };
      }
    }
    return null;
  }
  
  public final int fc(boolean paramBoolean)
  {
    return i.getEmojiStorageMgr().uBb.fc(paramBoolean);
  }
  
  public final void g(j.a parama)
  {
    i.getEmojiStorageMgr().uBb.d(parama);
  }
  
  public final boolean g(EmojiInfo paramEmojiInfo)
  {
    return d.aHc().c(paramEmojiInfo, true);
  }
  
  public final EmojiInfo h(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    return a(paramString, "", paramInt1, paramInt2, paramInt3, "");
  }
  
  public final void h(j.a parama)
  {
    i.getEmojiStorageMgr().uBb.c(parama);
  }
  
  public final boolean h(EmojiInfo paramEmojiInfo)
  {
    return (l.aHH()) && (paramEmojiInfo.cwz()) && (paramEmojiInfo.field_width == paramEmojiInfo.field_height) && (paramEmojiInfo.field_width > 100);
  }
  
  public final void i(j.a parama)
  {
    i.getEmojiStorageMgr().uBc.d(parama);
  }
  
  public final void j(j.a parama)
  {
    if (((com.tencent.mm.kernel.b.h)g.DM().Dr()).Ex()) {
      i.getEmojiStorageMgr().uBc.c(parama);
    }
  }
  
  public final void k(j.a parama)
  {
    i.getEmojiStorageMgr().uBm.c(parama);
  }
  
  public final void l(j.a parama)
  {
    i.getEmojiStorageMgr().uBm.d(parama);
  }
  
  public final boolean m(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null)
    {
      y.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: context is null");
      return false;
    }
    if ((bk.bl(paramString1)) || (bk.bl(paramString2)))
    {
      y.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: userName or imgPath is null");
      return false;
    }
    EmojiInfo localEmojiInfo = i.getEmojiStorageMgr().uBb.acC(paramString2);
    if (localEmojiInfo == null)
    {
      y.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: emoji not found, imgPath %s", new Object[] { paramString2 });
      return false;
    }
    if ((localEmojiInfo.field_type == EmojiInfo.uDd) || (localEmojiInfo.field_type == EmojiInfo.uDe))
    {
      paramString2 = new WXMediaMessage();
      String str = com.tencent.mm.plugin.emoji.h.b.FL() + localEmojiInfo.Wv();
      if (com.tencent.mm.vfs.e.bK(str + "_thumb")) {
        paramString2.thumbData = com.tencent.mm.vfs.e.c(str + "_thumb", 0, -1);
      }
      for (;;)
      {
        paramString2.mediaObject = new WXEmojiObject(str);
        paramContext = new pb();
        paramContext.bYE.bRd = paramString2;
        paramContext.bYE.appId = localEmojiInfo.field_app_id;
        paramContext.bYE.appName = null;
        paramContext.bYE.toUser = paramString1;
        paramContext.bYE.bYF = 0;
        paramContext.bYE.bYI = localEmojiInfo.Wv();
        com.tencent.mm.sdk.b.a.udP.m(paramContext);
        return true;
        paramString2.setThumbImage(localEmojiInfo.gl(paramContext));
      }
    }
    paramString2 = localEmojiInfo;
    if (localEmojiInfo.field_type == EmojiInfo.uDa)
    {
      if (!EmojiInfo.Fu(localEmojiInfo.field_catalog)) {
        break label387;
      }
      paramContext = i.getEmojiStorageMgr().uBb.Fy(localEmojiInfo.field_catalog);
    }
    for (;;)
    {
      paramString2 = localEmojiInfo;
      if (paramContext != null)
      {
        int i = bk.fe(paramContext.getCount() - 1, 0);
        paramString2 = new EmojiInfo();
        paramContext.moveToPosition(i);
        paramString2.d(paramContext);
        paramContext.close();
      }
      i.aHO().a(paramString1, paramString2, null);
      break;
      label387:
      if ((localEmojiInfo.field_catalog == EmojiInfo.uCV) && (localEmojiInfo.getContent().length() > 0) && (EmojiInfo.Fu(bk.getInt(localEmojiInfo.getContent(), 0)))) {
        paramContext = i.getEmojiStorageMgr().uBb.Fy(bk.getInt(localEmojiInfo.getContent(), 0));
      } else {
        paramContext = null;
      }
    }
  }
  
  public final void onDestroy() {}
  
  public final boolean r(ArrayList<q> paramArrayList)
  {
    r localr = i.getEmojiStorageMgr().uBj;
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      y.i("MicroMsg.emoji.NewSmileyInfoStorage", "insertSmileyInfoList failed. list is null.");
      return false;
    }
    com.tencent.mm.cf.h localh;
    long l;
    if ((localr.dXw instanceof com.tencent.mm.cf.h))
    {
      localh = (com.tencent.mm.cf.h)localr.dXw;
      l = localh.eV(Thread.currentThread().getId());
    }
    for (;;)
    {
      localr.dXw.delete("SmileyInfo", null, null);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localr.b((q)paramArrayList.next());
      }
      int i = -1;
      if (localh != null) {
        i = localh.hI(l);
      }
      if (i < 0) {
        break;
      }
      return true;
      l = -1L;
      localh = null;
    }
  }
  
  public final boolean s(ArrayList<com.tencent.mm.storage.emotion.s> paramArrayList)
  {
    t localt = i.getEmojiStorageMgr().uBk;
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      y.i("MicroMsg.emoji.SmileyPanelConfigInfoStorage", "insertSmileyConfigInfoList failed. list is null.");
      return false;
    }
    com.tencent.mm.cf.h localh;
    long l;
    if ((localt.dXw instanceof com.tencent.mm.cf.h))
    {
      localh = (com.tencent.mm.cf.h)localt.dXw;
      l = localh.eV(Thread.currentThread().getId());
    }
    for (;;)
    {
      localt.dXw.delete("SmileyPanelConfigInfo", null, null);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localt.b((com.tencent.mm.storage.emotion.s)paramArrayList.next());
      }
      int i = -1;
      if (localh != null) {
        i = localh.hI(l);
      }
      if (i < 0) {
        break;
      }
      return true;
      l = -1L;
      localh = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.f
 * JD-Core Version:    0.7.0.1
 */