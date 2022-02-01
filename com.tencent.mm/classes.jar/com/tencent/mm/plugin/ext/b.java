package com.tencent.mm.plugin.ext;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import com.jg.JgMethodChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.a.a.a;
import com.tencent.mm.g.a.fm;
import com.tencent.mm.g.a.fu;
import com.tencent.mm.g.a.ga;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.pluginsdk.model.k;
import com.tencent.mm.pluginsdk.model.k.b;
import com.tencent.mm.protocal.protobuf.bjz;
import com.tencent.mm.protocal.protobuf.dtx;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.cj;
import com.tencent.mm.storage.ck;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public class b
  implements ax
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private static boolean rcG;
  n.b qdR;
  private LinkedList<String> rcA;
  private final long rcB;
  private ap rcC;
  private com.tencent.mm.sdk.e.k.a rcD;
  private boolean rcE;
  private boolean rcF;
  private final long rcp;
  private ai rcq;
  private bz rcr;
  private ck rcs;
  private com.tencent.mm.plugin.ext.a.a rct;
  private a rcu;
  private b rcv;
  private HashMap<String, Integer> rcw;
  private i.a rcx;
  com.tencent.mm.pluginsdk.model.k.a rcy;
  private ap rcz;
  
  static
  {
    AppMethodBeat.i(24363);
    int i = com.tencent.mm.compatible.deviceinfo.m.aaf();
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
            return bz.SQL_CREATE;
          }
        });
        baseDBFactories.put(Integer.valueOf("USEROPENIDINAPP_TABLE".hashCode()), new h.b()
        {
          public final String[] getSQLs()
          {
            return ck.SQL_CREATE;
          }
        });
        baseDBFactories.put(Integer.valueOf("WXATOKENINFO_TABLE".hashCode()), new b.5());
        rcG = false;
        AppMethodBeat.o(24363);
        return;
        if ((i & 0x400) == 0) {
          break;
        }
        b.class.getClassLoader();
        com.tencent.mm.compatible.util.j.vr("wechatvoicesilk");
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
    this.rcp = 1600L;
    this.rcw = new HashMap();
    this.rcx = new i.a()
    {
      public final void a(i arg1, i.c paramAnonymousc)
      {
        AppMethodBeat.i(24338);
        if ((??? == null) || (paramAnonymousc == null) || (paramAnonymousc.gNE == null))
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
            Object localObject = b.crX().fsy();
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
            if (i < paramAnonymousc.gNE.size())
            {
              localObject = (bu)paramAnonymousc.gNE.get(i);
              if ((localObject == null) || (((ei)localObject).field_isSend != 0) || (((ei)localObject).field_status == 4) || (((bu)localObject).getType() == 9999) || (((bu)localObject).getType() == 10000) || (w.Aq(((ei)localObject).field_talker)) || (w.Au(((ei)localObject).field_talker))) {
                break label412;
              }
              Integer localInteger = (Integer)b.a(b.this).get(((ei)localObject).field_talker);
              if (localInteger == null)
              {
                b.a(b.this).put(((ei)localObject).field_talker, Integer.valueOf(1));
                ad.d("MicroMsg.SubCoreExt", "onMsgChange %s, %d", new Object[] { ((ei)localObject).field_talker, Integer.valueOf(1) });
              }
              else
              {
                b.a(b.this).put(((ei)localObject).field_talker, Integer.valueOf(localInteger.intValue() + 1));
                ad.d("MicroMsg.SubCoreExt", "onMsgChange %s, %d", new Object[] { ((ei)localObject).field_talker, Integer.valueOf(localInteger.intValue() + 1) });
              }
            }
          }
          if (b.a(b.this).size() > 0) {
            b.this.csd();
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
    this.rcy = new com.tencent.mm.pluginsdk.model.k.a()
    {
      public final void a(com.tencent.mm.pluginsdk.model.n paramAnonymousn)
      {
        AppMethodBeat.i(24339);
        if (paramAnonymousn == null)
        {
          AppMethodBeat.o(24339);
          return;
        }
        Iterator localIterator = paramAnonymousn.eZE().GEs.iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          Object localObject1 = (dtx)localIterator.next();
          ad.v("MicroMsg.SubCoreExt", "AppId[%s], UserName[%s], Xml[%s]", new Object[] { paramAnonymousn.kuy, ((dtx)localObject1).nDo, ((dtx)localObject1).HGU });
          if ((!bt.isNullOrNil(((dtx)localObject1).nDo)) && (!bt.isNullOrNil(((dtx)localObject1).HGU)))
          {
            com.tencent.mm.model.ba.aBQ();
            Object localObject2 = com.tencent.mm.model.c.azp().aTj(((dtx)localObject1).nDo);
            if ((localObject2 == null) || ((int)((com.tencent.mm.o.b)localObject2).gfj <= 0))
            {
              ad.e("MicroMsg.SubCoreExt", "contact is null");
            }
            else if (((am)localObject2).fqg())
            {
              ad.w("MicroMsg.SubCoreExt", "isBizContact");
            }
            else
            {
              localObject2 = k.aLy(((dtx)localObject1).HGU);
              if ((localObject2 != null) && (!bt.isNullOrNil(((k.b)localObject2).ELN)))
              {
                ad.v("MicroMsg.SubCoreExt", "AppId[%s], openId[%s]", new Object[] { paramAnonymousn.kuy, ((k.b)localObject2).ELN });
                localObject1 = new cj(paramAnonymousn.kuy, ((dtx)localObject1).nDo, ((k.b)localObject2).ELN);
                b.crY().a((cj)localObject1);
                i = 1;
              }
            }
          }
        }
        if (i != 0) {
          b.this.csd();
        }
        AppMethodBeat.o(24339);
      }
    };
    this.rcz = new ap(Looper.getMainLooper())
    {
      @JgMethodChecked(author=20, fComment="checked", lastDate="20140514", reviewer=20, vComment={com.jg.EType.INTENTCHECK})
      public final void handleMessage(Message arg1)
      {
        AppMethodBeat.i(24341);
        if ((aj.getContext() == null) || (!com.tencent.mm.model.ba.ajx()))
        {
          ad.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler wrong status");
          AppMethodBeat.o(24341);
          return;
        }
        Cursor localCursor = b.crX().fsy();
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
          localby = new by();
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
        by localby;
        localby.convertFrom(localCursor);
        if ((bt.isNullOrNil(localby.field_appId)) || (bt.isNullOrNil(localby.field_packageName)))
        {
          ad.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler wrong msgListener, appid = %s, package = %s", new Object[] { localby.field_appId, localby.field_packageName });
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
            com.tencent.mm.model.ba.aBQ();
            ??? = com.tencent.mm.model.c.azv().aTz((String)localObject3);
            if ((??? != null) && (!bt.isNullOrNil(???.field_username)) && (???.field_unReadCount <= 0))
            {
              ad.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler no unread in conversation");
            }
            else if ((!w.Aq((String)localObject3)) && (!w.vF((String)localObject3)) && (!w.zE((String)localObject3)))
            {
              Object localObject5 = b.crY();
              ??? = localby.field_appId;
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
                localObject5 = ((ck)localObject5).db.a("UserOpenIdInApp", null, "appId=? and username=? ", new String[] { bt.aQN(???), bt.aQN((String)localObject3) }, null, null, null, 2);
                if (!((Cursor)localObject5).moveToFirst())
                {
                  ad.w("MicroMsg.scanner.UserOpenIdInAppStorage", "get null with appId-%s, username-%s:", new Object[] { ???, localObject3 });
                  ((Cursor)localObject5).close();
                  ??? = null;
                  break label499;
                }
                ??? = new cj();
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
            ??? = localby.field_appId;
            if ((!bt.isNullOrNil(???)) && (localLinkedList.size() > 0))
            {
              localObject2 = k.eZu();
              localObject3 = aj.getContext();
              localObject4 = ((b)localObject4).rcy;
              ad.d("MicroMsg.GetUserInfoInAppLogic", "getGetUserInfoInApp");
              if (!k.ELK) {
                ((k)localObject2).eZv();
              }
              if ((com.tencent.mm.model.ba.ajx()) && (localObject3 != null))
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
            ((k)localObject2).ELM = ((com.tencent.mm.pluginsdk.model.k.a)localObject4);
            ??? = new com.tencent.mm.pluginsdk.model.n(???, localLinkedList);
            ao.dxT();
            com.tencent.mm.pluginsdk.model.app.e.a(14, ???);
          }
          if (localby.field_status != 1) {
            break label1144;
          }
        }
        label1139:
        label1144:
        for (int i = 1;; i = 0)
        {
          if (i == 0)
          {
            ad.w("MicroMsg.SubCoreExt", "invalid msgListener, appid = %s, package = %s", new Object[] { localby.field_appId, localby.field_packageName });
            break label311;
          }
          if ((bt.isNullOrNil(localby.field_appId)) || (bt.isNullOrNil(localby.field_packageName))) {
            break label311;
          }
          ad.i("MicroMsg.SubCoreExt", "notify app, appId = %s, package = %s", new Object[] { localby.field_appId, localby.field_packageName });
          ??? = new Intent("com.tencent.mm.plugin.openapi.Intent.ACTION_NOTIFY_MSG");
          ???.addCategory("com.tencent.mm.category." + localby.field_packageName);
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
    this.rcA = new LinkedList();
    this.rcB = 60L;
    this.rcC = new ap(Looper.getMainLooper())
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
              localObject2 = h.m((String)localObject1, false, false);
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
            localObject1 = b.crX().aUm(((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId);
            if (localObject1 != null) {
              break;
            }
            ad.w("MicroMsg.SubCoreExt", "openMsgListener is null, appId = %s", new Object[] { ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId });
          }
          if (!h.n((com.tencent.mm.pluginsdk.model.app.g)localObject2)) {
            break;
          }
        } while (((by)localObject1).field_status == 1);
        bz localbz;
        for (((by)localObject1).field_status = 1;; ((by)localObject1).field_status = 0)
        {
          localbz = b.crX();
          localObject2 = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId;
          if ((!bt.isNullOrNil((String)localObject2)) && (localObject1 != null) && (!bt.isNullOrNil(((by)localObject1).field_appId))) {
            break label289;
          }
          ad.w("MicroMsg.OpenMsgListenerStorage", "wrong argument");
          break;
          if (((by)localObject1).field_status == 0) {
            break;
          }
        }
        label289:
        ContentValues localContentValues = ((by)localObject1).convertTo();
        if (localContentValues.size() > 0) {}
        for (int i = localbz.db.update("OpenMsgListener", localContentValues, "appId=?", new String[] { bt.aQN((String)localObject2) });; i = 0)
        {
          ad.d("MicroMsg.OpenMsgListenerStorage", "update: id=%s, ret=%s ", new Object[] { ((by)localObject1).field_appId, Integer.valueOf(i) });
          break;
          label360:
          b.b(b.this).clear();
          AppMethodBeat.o(24342);
          return;
        }
      }
    };
    this.rcD = new com.tencent.mm.sdk.e.k.a()
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
    this.qdR = new n.b()
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
        if (!com.tencent.mm.model.ba.ajx())
        {
          ad.i("MicroMsg.SubCoreExt", "onNotifyChange acc not ready");
          AppMethodBeat.o(24335);
          return;
        }
        com.tencent.mm.model.ba.aBQ();
        if (paramAnonymousn == com.tencent.mm.model.c.azp()) {
          b.d(b.this);
        }
        AppMethodBeat.o(24335);
      }
    };
    this.rcE = true;
    this.rcF = false;
    AppMethodBeat.o(24346);
  }
  
  public static b crV()
  {
    AppMethodBeat.i(24347);
    com.tencent.mm.model.ba.aBK();
    b localb2 = (b)ca.By("plugin.ext");
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      com.tencent.mm.model.ba.aBK().a("plugin.ext", localb1);
    }
    AppMethodBeat.o(24347);
    return localb1;
  }
  
  public static ai crW()
  {
    AppMethodBeat.i(24348);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (crV().rcq == null)
    {
      localObject = crV();
      com.tencent.mm.model.ba.aBQ();
      ((b)localObject).rcq = new ai(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = crV().rcq;
    AppMethodBeat.o(24348);
    return localObject;
  }
  
  public static bz crX()
  {
    AppMethodBeat.i(24349);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (crV().rcr == null)
    {
      localObject = crV();
      com.tencent.mm.model.ba.aBQ();
      ((b)localObject).rcr = new bz(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = crV().rcr;
    AppMethodBeat.o(24349);
    return localObject;
  }
  
  public static ck crY()
  {
    AppMethodBeat.i(24350);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (crV().rcs == null)
    {
      localObject = crV();
      com.tencent.mm.model.ba.aBQ();
      ((b)localObject).rcs = new ck(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = crV().rcs;
    AppMethodBeat.o(24350);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.ext.a.a crZ()
  {
    AppMethodBeat.i(24351);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (crV().rct == null)
    {
      localObject = crV();
      com.tencent.mm.model.ba.aBQ();
      ((b)localObject).rct = new com.tencent.mm.plugin.ext.a.a(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = crV().rct;
    AppMethodBeat.o(24351);
    return localObject;
  }
  
  private static void csa()
  {
    AppMethodBeat.i(24353);
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(com.tencent.mm.kernel.g.ajC().gBm);
    if (!locale.exists()) {
      locale.mkdirs();
    }
    locale = new com.tencent.mm.vfs.e(com.tencent.mm.kernel.g.ajC().gBm + "image/ext/pcm");
    if (!locale.exists()) {
      locale.mkdirs();
    }
    ad.i("MicroMsg.SubCoreExt", "summerpcm accPath[%s] [%s]", new Object[] { com.tencent.mm.kernel.g.ajC().gBm, bt.flS() });
    AppMethodBeat.o(24353);
  }
  
  public static String csb()
  {
    AppMethodBeat.i(24356);
    String str = com.tencent.mm.kernel.g.ajC().gBm + "image/ext/pcm";
    AppMethodBeat.o(24356);
    return str;
  }
  
  public static void csc()
  {
    AppMethodBeat.i(24357);
    Object localObject = (String)crW().get(al.a.IvV, null);
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
  
  private void lk(boolean paramBoolean)
  {
    AppMethodBeat.i(24361);
    if (!this.rcE)
    {
      AppMethodBeat.o(24361);
      return;
    }
    if ((paramBoolean) && (this.rcF))
    {
      ad.i("MicroMsg.SubCoreExt", "fromStartApp and already try to init");
      AppMethodBeat.o(24361);
      return;
    }
    if ((!paramBoolean) && (!rcG))
    {
      AppMethodBeat.o(24361);
      return;
    }
    ad.i("MicroMsg.SubCoreExt", "initLocalVoiceControl,fromStartApp:%s,hasTryToInit:%s,hasCallApi:%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.rcF), Boolean.valueOf(rcG) });
    this.rcE = false;
    com.tencent.mm.model.ba.ajF().n(new b.3(this), 10000L);
    AppMethodBeat.o(24361);
  }
  
  public static am vg(long paramLong)
  {
    AppMethodBeat.i(24358);
    if ((com.tencent.mm.model.ba.ajx()) && (paramLong > 0L))
    {
      com.tencent.mm.model.ba.aBQ();
      am localam = com.tencent.mm.model.c.azp().DE(paramLong);
      AppMethodBeat.o(24358);
      return localam;
    }
    AppMethodBeat.o(24358);
    return null;
  }
  
  public static void vh(long paramLong)
  {
    AppMethodBeat.i(24359);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(24359);
      return;
    }
    try
    {
      com.tencent.mm.model.ba.aBQ();
      if (com.tencent.mm.model.c.azs().yb(paramLong))
      {
        com.tencent.mm.model.ba.aBQ();
        i locali = com.tencent.mm.model.c.azs();
        com.tencent.mm.model.ba.aBQ();
        locali.at(com.tencent.mm.model.c.azs().xY(paramLong));
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
  
  public void clearPluginData(int paramInt) {}
  
  public final void csd()
  {
    AppMethodBeat.i(24360);
    this.rcz.removeMessages(0);
    this.rcz.sendEmptyMessageDelayed(0, 1600L);
    AppMethodBeat.o(24360);
  }
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(24354);
    Object localObject = new fm();
    ((fm)localObject).dqx.op = 1;
    if (!com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject)) {
      ad.e("MicroMsg.SubCoreExt", "ExtAgentLifeEvent event fail in onAccountPostReset");
    }
    k.eZu().eZv();
    com.tencent.mm.model.ba.aBQ();
    com.tencent.mm.model.c.azs().a(this.rcx, null);
    if (this.rcu == null) {
      this.rcu = new a();
    }
    com.tencent.mm.sdk.b.a.IbL.c(this.rcu);
    if (this.rcv == null) {
      this.rcv = new b();
    }
    com.tencent.mm.sdk.b.a.IbL.c(this.rcv);
    localObject = ao.dxQ();
    if (localObject != null) {
      ((com.tencent.mm.pluginsdk.model.app.j)localObject).add(this.rcD);
    }
    localObject = aj.fkD();
    this.rcF = ((SharedPreferences)localObject).getBoolean("hasTryToInitVoiceControlData", false);
    rcG = ((SharedPreferences)localObject).getBoolean("hasCallVoiceControlApi", false);
    ad.i("MicroMsg.SubCoreExt", "onAccountPostReset,hasTryToInit:%s,hasCallApi:%s", new Object[] { Boolean.valueOf(this.rcF), Boolean.valueOf(rcG) });
    com.tencent.mm.model.ba.aBQ();
    com.tencent.mm.model.c.azp().a(this.qdR);
    lk(true);
    com.tencent.mm.plugin.ext.d.c.csr();
    csa();
    AppMethodBeat.o(24354);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(24355);
    if (this.rcu != null) {
      com.tencent.mm.sdk.b.a.IbL.d(this.rcu);
    }
    if (this.rcv != null) {
      com.tencent.mm.sdk.b.a.IbL.d(this.rcv);
    }
    Object localObject = ao.dxQ();
    if (localObject != null) {
      ((com.tencent.mm.pluginsdk.model.app.j)localObject).remove(this.rcD);
    }
    com.tencent.mm.model.ba.aBQ();
    com.tencent.mm.model.c.azs().a(this.rcx);
    localObject = new fm();
    ((fm)localObject).dqx.op = 2;
    if (!com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject)) {
      ad.e("MicroMsg.SubCoreExt", "ExtAgentLifeEvent event fail in onAccountRelease");
    }
    localObject = k.eZu();
    if (com.tencent.mm.model.ba.ajx())
    {
      k.ELK = false;
      ao.dxT().b(14, (u)localObject);
    }
    com.tencent.mm.model.ba.aBQ();
    com.tencent.mm.model.c.azp().b(this.qdR);
    com.tencent.mm.plugin.ext.d.c.css();
    AppMethodBeat.o(24355);
  }
  
  public void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(24352);
    csa();
    AppMethodBeat.o(24352);
  }
  
  public static final class a
    extends com.tencent.mm.sdk.b.c<fu>
  {
    public a()
    {
      AppMethodBeat.i(161360);
      this.__eventId = fu.class.getName().hashCode();
      AppMethodBeat.o(161360);
    }
  }
  
  public static final class b
    extends com.tencent.mm.sdk.b.c<ga>
  {
    public b()
    {
      super();
      AppMethodBeat.i(161361);
      this.__eventId = ga.class.getName().hashCode();
      AppMethodBeat.o(161361);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.b
 * JD-Core Version:    0.7.0.1
 */