package com.tencent.mm.plugin.ext;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import com.jg.JgMethodChecked;
import com.qq.wx.voice.embed.recognizer.Grammar;
import com.qq.wx.voice.embed.recognizer.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.a.a.a;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.a.fi;
import com.tencent.mm.g.a.fq;
import com.tencent.mm.g.a.fw;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.pluginsdk.model.k.b;
import com.tencent.mm.protocal.protobuf.bbz;
import com.tencent.mm.protocal.protobuf.dir;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cb;
import com.tencent.mm.storage.f;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class b
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private static boolean pKl;
  n.b oXb;
  private final long pJU;
  private ab pJV;
  private bq pJW;
  private cb pJX;
  private com.tencent.mm.plugin.ext.a.a pJY;
  private a pJZ;
  private b pKa;
  private HashMap<String, Integer> pKb;
  private h.a pKc;
  com.tencent.mm.pluginsdk.model.k.a pKd;
  private com.tencent.mm.sdk.platformtools.ap pKe;
  private LinkedList<String> pKf;
  private final long pKg;
  private com.tencent.mm.sdk.platformtools.ap pKh;
  private com.tencent.mm.sdk.e.k.a pKi;
  private boolean pKj;
  private boolean pKk;
  
  static
  {
    AppMethodBeat.i(24363);
    int i = com.tencent.mm.compatible.deviceinfo.m.WG();
    try
    {
      if (!Build.CPU_ABI.contains("armeabi")) {
        ad.e("hakon SilkCodec", "x86 machines not supported.");
      }
      for (;;)
      {
        HashMap localHashMap = new HashMap();
        baseDBFactories = localHashMap;
        localHashMap.put(Integer.valueOf("OPENMSGLISTENER_TABLE".hashCode()), new h.b()
        {
          public final String[] getSQLs()
          {
            return bq.SQL_CREATE;
          }
        });
        baseDBFactories.put(Integer.valueOf("USEROPENIDINAPP_TABLE".hashCode()), new h.b()
        {
          public final String[] getSQLs()
          {
            return cb.SQL_CREATE;
          }
        });
        baseDBFactories.put(Integer.valueOf("WXATOKENINFO_TABLE".hashCode()), new b.5());
        pKl = false;
        AppMethodBeat.o(24363);
        return;
        if ((i & 0x400) == 0) {
          break;
        }
        b.class.getClassLoader();
        com.tencent.mm.compatible.util.j.pq("wechatvoicesilk");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("hakon SilkCodec", "load library failed!");
        continue;
        if ((i & 0x200) != 0) {
          ad.e("hakon SilkCodec", "load library failed! silk don't support armv6!!!!");
        } else {
          ad.e("hakon SilkCodec", "load library failed! silk don't support armv5!!!!");
        }
      }
    }
  }
  
  public b()
  {
    AppMethodBeat.i(24346);
    this.pJU = 1600L;
    this.pKb = new HashMap();
    this.pKc = new h.a()
    {
      public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.h arg1, h.c paramAnonymousc)
      {
        AppMethodBeat.i(24338);
        if ((??? == null) || (paramAnonymousc == null) || (paramAnonymousc.tyE == null))
        {
          ad.e("MicroMsg.SubCoreExt", "onMsgChange, wrong args");
          AppMethodBeat.o(24338);
          return;
        }
        for (;;)
        {
          int i;
          synchronized (b.this)
          {
            Object localObject = b.ceL().eMN();
            if (localObject == null)
            {
              ad.i("MicroMsg.SubCoreExt", "onMsgChange onNotifyChange getValidOpenMsgListener cu == null");
              AppMethodBeat.o(24338);
              return;
            }
            ad.d("MicroMsg.SubCoreExt", "onMsgChange onNotifyChange listener count = %s", new Object[] { Integer.valueOf(((Cursor)localObject).getCount()) });
            if (((Cursor)localObject).getCount() <= 0)
            {
              ((Cursor)localObject).close();
              ad.i("MicroMsg.SubCoreExt", "onMsgChange onNotifyChange cu.getCount() <= 0");
              AppMethodBeat.o(24338);
              return;
            }
            ((Cursor)localObject).close();
            i = 0;
            if (i < paramAnonymousc.tyE.size())
            {
              localObject = (bl)paramAnonymousc.tyE.get(i);
              if ((localObject == null) || (((du)localObject).field_isSend != 0) || (((du)localObject).field_status == 4) || (((bl)localObject).getType() == 9999) || (((bl)localObject).getType() == 10000) || (w.tp(((du)localObject).field_talker)) || (w.tt(((du)localObject).field_talker))) {
                break label412;
              }
              Integer localInteger = (Integer)b.a(b.this).get(((du)localObject).field_talker);
              if (localInteger == null)
              {
                b.a(b.this).put(((du)localObject).field_talker, Integer.valueOf(1));
                ad.d("MicroMsg.SubCoreExt", "onMsgChange %s, %d", new Object[] { ((du)localObject).field_talker, Integer.valueOf(1) });
              }
              else
              {
                b.a(b.this).put(((du)localObject).field_talker, Integer.valueOf(localInteger.intValue() + 1));
                ad.d("MicroMsg.SubCoreExt", "onMsgChange %s, %d", new Object[] { ((du)localObject).field_talker, Integer.valueOf(localInteger.intValue() + 1) });
              }
            }
          }
          if (b.a(b.this).size() > 0) {
            b.this.ceR();
          }
          for (;;)
          {
            AppMethodBeat.o(24338);
            return;
            ad.i("MicroMsg.SubCoreExt", "notifyMsgUsers.size < 1");
          }
          label412:
          i += 1;
        }
      }
    };
    this.pKd = new com.tencent.mm.pluginsdk.model.k.a()
    {
      public final void a(com.tencent.mm.pluginsdk.model.n paramAnonymousn)
      {
        AppMethodBeat.i(24339);
        if (paramAnonymousn == null)
        {
          AppMethodBeat.o(24339);
          return;
        }
        Iterator localIterator = paramAnonymousn.evq().Dzz.iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          Object localObject1 = (dir)localIterator.next();
          ad.v("MicroMsg.SubCoreExt", "AppId[%s], UserName[%s], Xml[%s]", new Object[] { paramAnonymousn.jzF, ((dir)localObject1).mAQ, ((dir)localObject1).Ezc });
          if ((!bt.isNullOrNil(((dir)localObject1).mAQ)) && (!bt.isNullOrNil(((dir)localObject1).Ezc)))
          {
            az.arV();
            Object localObject2 = com.tencent.mm.model.c.apM().aHW(((dir)localObject1).mAQ);
            if ((localObject2 == null) || ((int)((com.tencent.mm.n.b)localObject2).fId <= 0))
            {
              ad.e("MicroMsg.SubCoreExt", "contact is null");
            }
            else if (((af)localObject2).eKB())
            {
              ad.w("MicroMsg.SubCoreExt", "isBizContact");
            }
            else
            {
              localObject2 = com.tencent.mm.pluginsdk.model.k.aAG(((dir)localObject1).Ezc);
              if ((localObject2 != null) && (!bt.isNullOrNil(((k.b)localObject2).BOP)))
              {
                ad.v("MicroMsg.SubCoreExt", "AppId[%s], openId[%s]", new Object[] { paramAnonymousn.jzF, ((k.b)localObject2).BOP });
                localObject1 = new ca(paramAnonymousn.jzF, ((dir)localObject1).mAQ, ((k.b)localObject2).BOP);
                b.ceM().a((ca)localObject1);
                i = 1;
              }
            }
          }
        }
        if (i != 0) {
          b.this.ceR();
        }
        AppMethodBeat.o(24339);
      }
    };
    this.pKe = new com.tencent.mm.sdk.platformtools.ap(Looper.getMainLooper())
    {
      @JgMethodChecked(author=20, fComment="checked", lastDate="20140514", reviewer=20, vComment={com.jg.EType.INTENTCHECK})
      public final void handleMessage(Message arg1)
      {
        AppMethodBeat.i(24341);
        if ((aj.getContext() == null) || (!az.afw()))
        {
          ad.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler wrong status");
          AppMethodBeat.o(24341);
          return;
        }
        Cursor localCursor = b.ceL().eMN();
        if (localCursor == null)
        {
          ad.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler getValidOpenMsgListener cu == null");
          AppMethodBeat.o(24341);
          return;
        }
        ad.d("MicroMsg.SubCoreExt", "notifyMsgChangeHandler listener count = %s", new Object[] { Integer.valueOf(localCursor.getCount()) });
        if (localCursor.getCount() <= 0)
        {
          localCursor.close();
          ad.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler cu.getCount() <= 0");
          AppMethodBeat.o(24341);
          return;
        }
        LinkedList localLinkedList;
        ArrayList localArrayList;
        try
        {
          if (!localCursor.moveToFirst()) {
            break label320;
          }
          HashMap localHashMap = new HashMap();
          synchronized (b.this)
          {
            localHashMap.putAll(b.a(b.this));
            b.a(b.this).clear();
            localLinkedList = new LinkedList();
            localArrayList = new ArrayList();
            if (localHashMap.entrySet() == null)
            {
              ad.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler waitForNotify.entrySet() == null");
              AppMethodBeat.o(24341);
              return;
            }
          }
          localbp = new bp();
        }
        catch (Exception ???)
        {
          ad.e("MicroMsg.SubCoreExt", "Exception in handleMessage, %s", new Object[] { ???.getMessage() });
          if (localCursor != null) {
            localCursor.close();
          }
          AppMethodBeat.o(24341);
          return;
        }
        bp localbp;
        localbp.convertFrom(localCursor);
        if ((bt.isNullOrNil(localbp.field_appId)) || (bt.isNullOrNil(localbp.field_packageName)))
        {
          ad.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler wrong msgListener, appid = %s, package = %s", new Object[] { localbp.field_appId, localbp.field_packageName });
          label311:
          if (!localCursor.moveToNext())
          {
            label320:
            localCursor.close();
            AppMethodBeat.o(24341);
          }
        }
        else
        {
          Object localObject2 = localObject1.entrySet().iterator();
          Object localObject3;
          Object localObject4;
          while (((Iterator)localObject2).hasNext())
          {
            ??? = (Map.Entry)((Iterator)localObject2).next();
            localObject3 = bt.nullAsNil((String)???.getKey());
            localObject4 = (Integer)???.getValue();
            az.arV();
            ??? = com.tencent.mm.model.c.apR().aIn((String)localObject3);
            if ((??? != null) && (!bt.isNullOrNil(???.field_username)) && (???.field_unReadCount <= 0))
            {
              ad.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler no unread in conversation");
            }
            else if ((!w.tp((String)localObject3)) && (!w.pF((String)localObject3)) && (!w.sE((String)localObject3)))
            {
              Object localObject5 = b.ceM();
              ??? = localbp.field_appId;
              if ((??? == null) || (???.length() <= 0) || (localObject3 == null)) {
                break label1139;
              }
              if (((String)localObject3).length() <= 0)
              {
                break label1139;
                label499:
                if ((??? != null) && (!bt.isNullOrNil(???.field_openId)) && (!bt.isNullOrNil(???.field_username))) {
                  break label715;
                }
                ad.d("MicroMsg.SubCoreExt", "notifyMsgChangeHandler openId is null, go get it.");
                ??? = (Integer)b.a(b.this).get(localObject3);
                if (??? != null) {
                  break label686;
                }
                b.a(b.this).put(localObject3, localObject4);
              }
              for (;;)
              {
                localLinkedList.add(localObject3);
                break;
                localObject5 = ((cb)localObject5).db.a("UserOpenIdInApp", null, "appId=? and username=? ", new String[] { bt.aFQ(???), bt.aFQ((String)localObject3) }, null, null, null, 2);
                if (!((Cursor)localObject5).moveToFirst())
                {
                  ad.w("MicroMsg.scanner.UserOpenIdInAppStorage", "get null with appId-%s, username-%s:", new Object[] { ???, localObject3 });
                  ((Cursor)localObject5).close();
                  ??? = null;
                  break label499;
                }
                ??? = new ca();
                ???.convertFrom((Cursor)localObject5);
                ((Cursor)localObject5).close();
                break label499;
                label686:
                b.a(b.this).put(localObject3, Integer.valueOf(???.intValue() + ((Integer)localObject4).intValue()));
              }
              label715:
              ad.v("MicroMsg.SubCoreExt", "username[%s], appId[%s], openId[%s]", new Object[] { ???.field_username, ???.field_appId, ???.field_openId });
              localArrayList.add(String.format("%s,%s,%s", new Object[] { ???.field_openId, localObject4, Long.valueOf(System.currentTimeMillis() - 1600L) }));
            }
          }
          if (localLinkedList.size() > 0)
          {
            ad.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler doGetGetUserInfoInApp");
            localObject4 = b.this;
            ??? = localbp.field_appId;
            if ((!bt.isNullOrNil(???)) && (localLinkedList.size() > 0))
            {
              localObject2 = com.tencent.mm.pluginsdk.model.k.evg();
              localObject3 = aj.getContext();
              localObject4 = ((b)localObject4).pKd;
              ad.d("MicroMsg.GetUserInfoInAppLogic", "getGetUserInfoInApp");
              if (!com.tencent.mm.pluginsdk.model.k.BOM) {
                ((com.tencent.mm.pluginsdk.model.k)localObject2).evh();
              }
              if ((az.afw()) && (localObject3 != null))
              {
                if (localLinkedList.size() != 0) {
                  break label929;
                }
                ad.d("MicroMsg.GetUserInfoInAppLogic", "userNameList empty");
              }
            }
          }
          while (localArrayList.size() <= 0)
          {
            localCursor.close();
            ad.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler userDataList.size() <= 0");
            AppMethodBeat.o(24341);
            return;
            label929:
            ((com.tencent.mm.pluginsdk.model.k)localObject2).BOO = ((com.tencent.mm.pluginsdk.model.k.a)localObject4);
            ??? = new com.tencent.mm.pluginsdk.model.n(???, localLinkedList);
            com.tencent.mm.pluginsdk.model.app.ap.cZT();
            com.tencent.mm.pluginsdk.model.app.e.a(14, ???);
          }
          if (localbp.field_status != 1) {
            break label1144;
          }
        }
        label1139:
        label1144:
        for (int i = 1;; i = 0)
        {
          if (i == 0)
          {
            ad.w("MicroMsg.SubCoreExt", "invalid msgListener, appid = %s, package = %s", new Object[] { localbp.field_appId, localbp.field_packageName });
            break label311;
          }
          if ((bt.isNullOrNil(localbp.field_appId)) || (bt.isNullOrNil(localbp.field_packageName))) {
            break label311;
          }
          ad.i("MicroMsg.SubCoreExt", "notify app, appId = %s, package = %s", new Object[] { localbp.field_appId, localbp.field_packageName });
          ??? = new Intent("com.tencent.mm.plugin.openapi.Intent.ACTION_NOTIFY_MSG");
          ???.addCategory("com.tencent.mm.category." + localbp.field_packageName);
          com.tencent.mm.compatible.a.a.a(12, new a.a()
          {
            public final void run()
            {
              AppMethodBeat.i(24340);
              paramAnonymousMessage.setFlags(32);
              AppMethodBeat.o(24340);
            }
          });
          ???.putExtra("EXTRA_EXT_OPEN_NOTIFY_TYPE", "NEW_MESSAGE");
          ???.putStringArrayListExtra("EXTRA_EXT_OPEN_USER_DATA", localArrayList);
          aj.getContext().sendBroadcast(???);
          break label311;
          break;
          ??? = null;
          break label499;
        }
      }
    };
    this.pKf = new LinkedList();
    this.pKg = 60L;
    this.pKh = new com.tencent.mm.sdk.platformtools.ap(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(24342);
        Object localObject1;
        Object localObject2;
        label137:
        do
        {
          for (;;)
          {
            try
            {
              i = b.b(b.this).size();
              if (i <= 0)
              {
                AppMethodBeat.o(24342);
                return;
              }
              paramAnonymousMessage = b.b(b.this).iterator();
              if (!paramAnonymousMessage.hasNext()) {
                break label360;
              }
              localObject1 = (String)paramAnonymousMessage.next();
              if ("*".equals(localObject1)) {
                continue;
              }
              localObject2 = com.tencent.mm.pluginsdk.model.app.h.j((String)localObject1, false, false);
              if (localObject2 == null)
              {
                ad.w("MicroMsg.SubCoreExt", "appInfo is null");
                continue;
              }
              if (!bt.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId)) {
                break label137;
              }
            }
            catch (Exception paramAnonymousMessage)
            {
              ad.e("MicroMsg.SubCoreExt", "exception in onAppInfoStgChange, %s", new Object[] { paramAnonymousMessage.getMessage() });
              AppMethodBeat.o(24342);
              return;
            }
            ad.w("MicroMsg.SubCoreExt", "appId is null");
            continue;
            ad.d("MicroMsg.SubCoreExt", "onAppInfoStgChange, notify[%s], appFlag[%s], id[%s]", new Object[] { localObject1, Integer.valueOf(((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appInfoFlag), ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId });
            localObject1 = b.ceL().aIZ(((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId);
            if (localObject1 != null) {
              break;
            }
            ad.w("MicroMsg.SubCoreExt", "openMsgListener is null, appId = %s", new Object[] { ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId });
          }
          if (!com.tencent.mm.pluginsdk.model.app.h.n((com.tencent.mm.pluginsdk.model.app.g)localObject2)) {
            break;
          }
        } while (((bp)localObject1).field_status == 1);
        bq localbq;
        for (((bp)localObject1).field_status = 1;; ((bp)localObject1).field_status = 0)
        {
          localbq = b.ceL();
          localObject2 = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId;
          if ((!bt.isNullOrNil((String)localObject2)) && (localObject1 != null) && (!bt.isNullOrNil(((bp)localObject1).field_appId))) {
            break label289;
          }
          ad.w("MicroMsg.OpenMsgListenerStorage", "wrong argument");
          break;
          if (((bp)localObject1).field_status == 0) {
            break;
          }
        }
        label289:
        ContentValues localContentValues = ((bp)localObject1).convertTo();
        if (localContentValues.size() > 0) {}
        for (int i = localbq.db.update("OpenMsgListener", localContentValues, "appId=?", new String[] { bt.aFQ((String)localObject2) });; i = 0)
        {
          ad.d("MicroMsg.OpenMsgListenerStorage", "update: id=%s, ret=%s ", new Object[] { ((bp)localObject1).field_appId, Integer.valueOf(i) });
          break;
          label360:
          b.b(b.this).clear();
          AppMethodBeat.o(24342);
          return;
        }
      }
    };
    this.pKi = new com.tencent.mm.sdk.e.k.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
      {
        AppMethodBeat.i(24343);
        if (!b.b(b.this).contains(paramAnonymousString)) {
          b.b(b.this).add(paramAnonymousString);
        }
        b.c(b.this).removeMessages(0);
        b.c(b.this).sendEmptyMessageDelayed(0, 60L);
        AppMethodBeat.o(24343);
      }
    };
    this.oXb = new n.b()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.sdk.e.n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(24335);
        if ((paramAnonymousObject == null) || (!(paramAnonymousObject instanceof String)))
        {
          ad.d("MicroMsg.SubCoreExt", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousn, paramAnonymousObject });
          AppMethodBeat.o(24335);
          return;
        }
        if (!az.afw())
        {
          ad.i("MicroMsg.SubCoreExt", "onNotifyChange acc not ready");
          AppMethodBeat.o(24335);
          return;
        }
        az.arV();
        if (paramAnonymousn == com.tencent.mm.model.c.apM()) {
          b.d(b.this);
        }
        AppMethodBeat.o(24335);
      }
    };
    this.pKj = true;
    this.pKk = false;
    AppMethodBeat.o(24346);
  }
  
  public static b ceJ()
  {
    AppMethodBeat.i(24347);
    az.arP();
    b localb2 = (b)bz.ut("plugin.ext");
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      az.arP().a("plugin.ext", localb1);
    }
    AppMethodBeat.o(24347);
    return localb1;
  }
  
  public static ab ceK()
  {
    AppMethodBeat.i(24348);
    com.tencent.mm.kernel.g.afz().aeD();
    if (ceJ().pJV == null)
    {
      localObject = ceJ();
      az.arV();
      ((b)localObject).pJV = new ab(com.tencent.mm.model.c.afg());
    }
    Object localObject = ceJ().pJV;
    AppMethodBeat.o(24348);
    return localObject;
  }
  
  public static bq ceL()
  {
    AppMethodBeat.i(24349);
    com.tencent.mm.kernel.g.afz().aeD();
    if (ceJ().pJW == null)
    {
      localObject = ceJ();
      az.arV();
      ((b)localObject).pJW = new bq(com.tencent.mm.model.c.afg());
    }
    Object localObject = ceJ().pJW;
    AppMethodBeat.o(24349);
    return localObject;
  }
  
  public static cb ceM()
  {
    AppMethodBeat.i(24350);
    com.tencent.mm.kernel.g.afz().aeD();
    if (ceJ().pJX == null)
    {
      localObject = ceJ();
      az.arV();
      ((b)localObject).pJX = new cb(com.tencent.mm.model.c.afg());
    }
    Object localObject = ceJ().pJX;
    AppMethodBeat.o(24350);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.ext.a.a ceN()
  {
    AppMethodBeat.i(24351);
    com.tencent.mm.kernel.g.afz().aeD();
    if (ceJ().pJY == null)
    {
      localObject = ceJ();
      az.arV();
      ((b)localObject).pJY = new com.tencent.mm.plugin.ext.a.a(com.tencent.mm.model.c.afg());
    }
    Object localObject = ceJ().pJY;
    AppMethodBeat.o(24351);
    return localObject;
  }
  
  private static void ceO()
  {
    AppMethodBeat.i(24353);
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(com.tencent.mm.kernel.g.afB().gcW);
    if (!locale.exists()) {
      locale.mkdirs();
    }
    locale = new com.tencent.mm.vfs.e(com.tencent.mm.kernel.g.afB().gcW + "image/ext/pcm");
    if (!locale.exists()) {
      locale.mkdirs();
    }
    ad.i("MicroMsg.SubCoreExt", "summerpcm accPath[%s] [%s]", new Object[] { com.tencent.mm.kernel.g.afB().gcW, bt.eGN() });
    AppMethodBeat.o(24353);
  }
  
  public static String ceP()
  {
    AppMethodBeat.i(24356);
    String str = com.tencent.mm.kernel.g.afB().gcW + "image/ext/pcm";
    AppMethodBeat.o(24356);
    return str;
  }
  
  public static void ceQ()
  {
    AppMethodBeat.i(24357);
    Object localObject = (String)ceK().get(ae.a.FlO, null);
    ad.i("MicroMsg.SubCoreExt", "sendSportBroadcast pkgNames = ".concat(String.valueOf(localObject)));
    if (localObject != null)
    {
      localObject = ((String)localObject).split(";");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject[i];
        Intent localIntent = new Intent("com.tencent.mm.plugin.openapi.Intent.ACTION_SET_SPORT_STEP");
        localIntent.setPackage(str);
        com.tencent.mm.compatible.a.a.a(12, new a.a()
        {
          public final void run()
          {
            AppMethodBeat.i(24337);
            this.val$intent.setFlags(32);
            AppMethodBeat.o(24337);
          }
        });
        localIntent.putExtra("EXTRA_EXT_OPEN_NOTIFY_TYPE", "SPORT_MESSAGE");
        aj.getContext().sendBroadcast(localIntent);
        i += 1;
      }
    }
    AppMethodBeat.o(24357);
  }
  
  private void kn(boolean paramBoolean)
  {
    AppMethodBeat.i(24361);
    if (!this.pKj)
    {
      AppMethodBeat.o(24361);
      return;
    }
    if ((paramBoolean) && (this.pKk))
    {
      ad.i("MicroMsg.SubCoreExt", "fromStartApp and already try to init");
      AppMethodBeat.o(24361);
      return;
    }
    if ((!paramBoolean) && (!pKl))
    {
      AppMethodBeat.o(24361);
      return;
    }
    ad.i("MicroMsg.SubCoreExt", "initLocalVoiceControl,fromStartApp:%s,hasTryToInit:%s,hasCallApi:%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.pKk), Boolean.valueOf(pKl) });
    this.pKj = false;
    az.afE().m(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24336);
        Object localObject2;
        int i;
        int j;
        try
        {
          localObject2 = com.tencent.mm.m.g.Zd().getValue("VoiceRecognizeSprSoMD5");
          localObject3 = com.tencent.mm.m.g.Zd().getValue("VoiceRecognizeSprDataMD5");
          if ((localObject2 == null) || (localObject3 == null) || (q.is64BitRuntime()))
          {
            ad.i("MicroMsg.SubCoreExt", "error mMd5So:%s,  mMd5Data:%s", new Object[] { localObject2, localObject3 });
            b.e(b.this);
            AppMethodBeat.o(24336);
            return;
          }
          Object localObject1 = "/system/lib/";
          if (Build.VERSION.SDK_INT >= 24) {
            localObject1 = "/vendor/lib/";
          }
          ad.i("MicroMsg.SubCoreExt", "mMd5So:%s,  mMd5Data:%s,  mSoPath:%s", new Object[] { localObject2, localObject3, localObject1 });
          l = System.currentTimeMillis();
          Object localObject5 = com.qq.wx.voice.embed.recognizer.b.a.bNJ;
          Object localObject4 = aj.getContext();
          localObject5 = ((com.qq.wx.voice.embed.recognizer.b)localObject5).bNI;
          if (((com.qq.wx.voice.embed.recognizer.e)localObject5).d) {
            i = 0;
          }
          for (;;)
          {
            localObject1 = aj.eFE();
            ad.i("MicroMsg.SubCoreExt", "checkFiles ret:%s,use time:%s", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
            if (i != 0) {
              break label700;
            }
            l = System.currentTimeMillis();
            localObject3 = new LinkedList();
            ((List)localObject3).add("tmessage");
            ((List)localObject3).add("officialaccounts");
            ((List)localObject3).add("helper_entry");
            az.arV();
            localObject2 = com.tencent.mm.model.c.apU().agP("@t.qq.com");
            if (localObject2 != null) {
              ((List)localObject3).add(((br)localObject2).name);
            }
            localObject2 = new ArrayList();
            az.arV();
            localObject3 = com.tencent.mm.model.c.apM().a("@all.contact.android", null, (List)localObject3, null, true, true);
            if (localObject3 != null) {
              break;
            }
            ad.w("MicroMsg.SubCoreExt", "initLocalVoiceControl cu is null");
            b.e(b.this);
            AppMethodBeat.o(24336);
            return;
            j = ((com.qq.wx.voice.embed.recognizer.e)localObject5).bNP.checkFiles((Context)localObject4, (String)localObject1, (String)localObject2, (String)localObject3);
            i = j;
            if (j >= 0)
            {
              ((com.qq.wx.voice.embed.recognizer.e)localObject5).d = true;
              i = 0;
            }
          }
          if (((Cursor)localObject3).moveToFirst()) {
            while (!((Cursor)localObject3).isAfterLast())
            {
              localObject4 = new f();
              ((f)localObject4).convertFrom((Cursor)localObject3);
              ((ArrayList)localObject2).add(new d(((f)localObject4).field_username, ((f)localObject4).field_nickname, ((f)localObject4).field_conRemark));
              ((Cursor)localObject3).moveToNext();
            }
          }
          ((Cursor)localObject3).close();
        }
        catch (Exception localException)
        {
          ad.i("MicroMsg.SubCoreExt", "initLocalVoiceControl Exception:%s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(24336);
          return;
        }
        ad.i("MicroMsg.SubCoreExt", "init cusor,count:%s,use time:%s", new Object[] { Integer.valueOf(((Cursor)localObject3).getCount()), Long.valueOf(System.currentTimeMillis() - l) });
        long l = System.currentTimeMillis();
        Object localObject3 = com.qq.wx.voice.embed.recognizer.b.a.bNJ.bNI;
        if (!((com.qq.wx.voice.embed.recognizer.e)localObject3).d) {
          i = -304;
        }
        for (;;)
        {
          if (i == 0)
          {
            localException.edit().putBoolean("hasInitVoiceControlData", true).putBoolean("hasTryToInitVoiceControlData", true).commit();
            b.f(b.this);
            label569:
            ad.i("MicroMsg.SubCoreExt", "init ret:%s,use time:%s", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
            b.e(b.this);
          }
          for (;;)
          {
            b.e(b.this);
            AppMethodBeat.o(24336);
            return;
            if (((com.qq.wx.voice.embed.recognizer.e)localObject3).e)
            {
              j = ((com.qq.wx.voice.embed.recognizer.e)localObject3).bNP.update((ArrayList)localObject2);
              i = j;
              if (j < 0) {
                break;
              }
              break label741;
            }
            j = ((com.qq.wx.voice.embed.recognizer.e)localObject3).bNP.init((ArrayList)localObject2);
            i = j;
            if (j < 0) {
              break;
            }
            ((com.qq.wx.voice.embed.recognizer.e)localObject3).e = true;
            break label741;
            localException.edit().putBoolean("hasInitVoiceControlData", false).commit();
            break label569;
            label700:
            localException.edit().putBoolean("hasInitVoiceControlData", false).putBoolean("hasTryToInitVoiceControlData", true).commit();
            b.f(b.this);
          }
          label741:
          i = 0;
        }
      }
    }, 10000L);
    AppMethodBeat.o(24361);
  }
  
  public static af pu(long paramLong)
  {
    AppMethodBeat.i(24358);
    if ((az.afw()) && (paramLong > 0L))
    {
      az.arV();
      af localaf = com.tencent.mm.model.c.apM().wl(paramLong);
      AppMethodBeat.o(24358);
      return localaf;
    }
    AppMethodBeat.o(24358);
    return null;
  }
  
  public static void pv(long paramLong)
  {
    AppMethodBeat.i(24359);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(24359);
      return;
    }
    try
    {
      az.arV();
      if (com.tencent.mm.model.c.apO().rp(paramLong))
      {
        az.arV();
        com.tencent.mm.plugin.messenger.foundation.a.a.h localh = com.tencent.mm.model.c.apO();
        az.arV();
        localh.ao(com.tencent.mm.model.c.apO().rm(paramLong));
        AppMethodBeat.o(24359);
        return;
      }
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.SubCoreExt", localException.getMessage());
      ad.printErrStackTrace("MicroMsg.SubCoreExt", localException, "", new Object[0]);
      AppMethodBeat.o(24359);
      return;
    }
    ad.e("MicroMsg.SubCoreExt", "msgId is out of range, ".concat(String.valueOf(paramLong)));
    AppMethodBeat.o(24359);
  }
  
  public final void ceR()
  {
    AppMethodBeat.i(24360);
    this.pKe.removeMessages(0);
    this.pKe.sendEmptyMessageDelayed(0, 1600L);
    AppMethodBeat.o(24360);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(24354);
    Object localObject = new fi();
    ((fi)localObject).dhG.op = 1;
    if (!com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject)) {
      ad.e("MicroMsg.SubCoreExt", "ExtAgentLifeEvent event fail in onAccountPostReset");
    }
    com.tencent.mm.pluginsdk.model.k.evg().evh();
    az.arV();
    com.tencent.mm.model.c.apO().a(this.pKc, null);
    if (this.pJZ == null) {
      this.pJZ = new a();
    }
    com.tencent.mm.sdk.b.a.ESL.c(this.pJZ);
    if (this.pKa == null) {
      this.pKa = new b();
    }
    com.tencent.mm.sdk.b.a.ESL.c(this.pKa);
    localObject = com.tencent.mm.pluginsdk.model.app.ap.cZQ();
    if (localObject != null) {
      ((com.tencent.mm.pluginsdk.model.app.j)localObject).add(this.pKi);
    }
    localObject = aj.eFE();
    this.pKk = ((SharedPreferences)localObject).getBoolean("hasTryToInitVoiceControlData", false);
    pKl = ((SharedPreferences)localObject).getBoolean("hasCallVoiceControlApi", false);
    ad.i("MicroMsg.SubCoreExt", "onAccountPostReset,hasTryToInit:%s,hasCallApi:%s", new Object[] { Boolean.valueOf(this.pKk), Boolean.valueOf(pKl) });
    az.arV();
    com.tencent.mm.model.c.apM().a(this.oXb);
    kn(true);
    com.tencent.mm.plugin.ext.d.c.cff();
    ceO();
    AppMethodBeat.o(24354);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(24355);
    if (this.pJZ != null) {
      com.tencent.mm.sdk.b.a.ESL.d(this.pJZ);
    }
    if (this.pKa != null) {
      com.tencent.mm.sdk.b.a.ESL.d(this.pKa);
    }
    Object localObject = com.tencent.mm.pluginsdk.model.app.ap.cZQ();
    if (localObject != null) {
      ((com.tencent.mm.pluginsdk.model.app.j)localObject).remove(this.pKi);
    }
    az.arV();
    com.tencent.mm.model.c.apO().a(this.pKc);
    localObject = new fi();
    ((fi)localObject).dhG.op = 2;
    if (!com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject)) {
      ad.e("MicroMsg.SubCoreExt", "ExtAgentLifeEvent event fail in onAccountRelease");
    }
    localObject = com.tencent.mm.pluginsdk.model.k.evg();
    if (az.afw())
    {
      com.tencent.mm.pluginsdk.model.k.BOM = false;
      com.tencent.mm.pluginsdk.model.app.ap.cZT().b(14, (u)localObject);
    }
    az.arV();
    com.tencent.mm.model.c.apM().b(this.oXb);
    com.tencent.mm.plugin.ext.d.c.cfg();
    AppMethodBeat.o(24355);
  }
  
  public void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(24352);
    ceO();
    AppMethodBeat.o(24352);
  }
  
  public static final class a
    extends com.tencent.mm.sdk.b.c<fq>
  {
    public a()
    {
      AppMethodBeat.i(161360);
      this.__eventId = fq.class.getName().hashCode();
      AppMethodBeat.o(161360);
    }
  }
  
  public static final class b
    extends com.tencent.mm.sdk.b.c<fw>
  {
    public b()
    {
      super();
      AppMethodBeat.i(161361);
      this.__eventId = fw.class.getName().hashCode();
      AppMethodBeat.o(161361);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.b
 * JD-Core Version:    0.7.0.1
 */