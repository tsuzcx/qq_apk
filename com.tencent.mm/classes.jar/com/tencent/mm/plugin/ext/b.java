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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.a.a.a;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.f.a.fx;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.pluginsdk.model.n;
import com.tencent.mm.pluginsdk.model.n.a;
import com.tencent.mm.pluginsdk.model.n.b;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.protocal.protobuf.ces;
import com.tencent.mm.protocal.protobuf.ezb;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cg;
import com.tencent.mm.storage.cj;
import com.tencent.mm.storage.cs;
import com.tencent.mm.storage.ct;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class b
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private static boolean wsn;
  MStorageEx.IOnStorageChange vgY;
  private final long wrW;
  private com.tencent.mm.storage.ao wrX;
  private com.tencent.mm.storage.ch wrY;
  private ct wrZ;
  private com.tencent.mm.plugin.ext.a.a wsa;
  private b.a wsb;
  private b.b wsc;
  private HashMap<String, Integer> wsd;
  private i.a wse;
  n.a wsf;
  private MMHandler wsg;
  private LinkedList<String> wsh;
  private final long wsi;
  private MMHandler wsj;
  private MStorage.IOnStorageChange wsk;
  private boolean wsl;
  private boolean wsm;
  
  static
  {
    AppMethodBeat.i(24363);
    int i = m.aus();
    try
    {
      if (!Build.CPU_ABI.contains("armeabi")) {
        Log.e("hakon SilkCodec", "x86 machines not supported.");
      }
      for (;;)
      {
        HashMap localHashMap = new HashMap();
        baseDBFactories = localHashMap;
        localHashMap.put(Integer.valueOf("OPENMSGLISTENER_TABLE".hashCode()), new h.b()
        {
          public final String[] getSQLs()
          {
            return com.tencent.mm.storage.ch.SQL_CREATE;
          }
        });
        baseDBFactories.put(Integer.valueOf("USEROPENIDINAPP_TABLE".hashCode()), new b.4());
        baseDBFactories.put(Integer.valueOf("WXATOKENINFO_TABLE".hashCode()), new b.5());
        wsn = false;
        AppMethodBeat.o(24363);
        return;
        if ((i & 0x400) == 0) {
          break;
        }
        b.class.getClassLoader();
        com.tencent.mm.compatible.util.j.KW("wechatvoicesilk");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("hakon SilkCodec", "load library failed!");
        continue;
        if ((i & 0x200) != 0) {
          Log.e("hakon SilkCodec", "load library failed! silk don't support armv6!!!!");
        } else {
          Log.e("hakon SilkCodec", "load library failed! silk don't support armv5!!!!");
        }
      }
    }
  }
  
  public b()
  {
    AppMethodBeat.i(24346);
    this.wrW = 1600L;
    this.wsd = new HashMap();
    this.wse = new i.a()
    {
      public final void onNotifyChange(i arg1, i.c paramAnonymousc)
      {
        AppMethodBeat.i(24338);
        if (CrashReportFactory.isBackupMerge())
        {
          AppMethodBeat.o(24338);
          return;
        }
        if ((??? == null) || (paramAnonymousc == null) || (paramAnonymousc.kvM == null))
        {
          Log.e("MicroMsg.SubCoreExt", "onMsgChange, wrong args");
          AppMethodBeat.o(24338);
          return;
        }
        for (;;)
        {
          int i;
          synchronized (b.this)
          {
            Object localObject = b.dhh().hAB();
            if (localObject == null)
            {
              Log.i("MicroMsg.SubCoreExt", "onMsgChange onNotifyChange getValidOpenMsgListener cu == null");
              AppMethodBeat.o(24338);
              return;
            }
            Log.d("MicroMsg.SubCoreExt", "onMsgChange onNotifyChange listener count = %s", new Object[] { Integer.valueOf(((Cursor)localObject).getCount()) });
            if (((Cursor)localObject).getCount() <= 0)
            {
              ((Cursor)localObject).close();
              Log.i("MicroMsg.SubCoreExt", "onMsgChange onNotifyChange cu.getCount() <= 0");
              AppMethodBeat.o(24338);
              return;
            }
            ((Cursor)localObject).close();
            i = 0;
            if (i < paramAnonymousc.kvM.size())
            {
              localObject = (ca)paramAnonymousc.kvM.get(i);
              if ((localObject == null) || (((et)localObject).field_isSend != 0) || (((et)localObject).field_status == 4) || (((ca)localObject).getType() == 9999) || (((ca)localObject).getType() == 10000) || (ab.QY(((et)localObject).field_talker)) || (ab.Rc(((et)localObject).field_talker))) {
                break label425;
              }
              Integer localInteger = (Integer)b.a(b.this).get(((et)localObject).field_talker);
              if (localInteger == null)
              {
                b.a(b.this).put(((et)localObject).field_talker, Integer.valueOf(1));
                Log.d("MicroMsg.SubCoreExt", "onMsgChange %s, %d", new Object[] { ((et)localObject).field_talker, Integer.valueOf(1) });
              }
              else
              {
                b.a(b.this).put(((et)localObject).field_talker, Integer.valueOf(localInteger.intValue() + 1));
                Log.d("MicroMsg.SubCoreExt", "onMsgChange %s, %d", new Object[] { ((et)localObject).field_talker, Integer.valueOf(localInteger.intValue() + 1) });
              }
            }
          }
          if (b.a(b.this).size() > 0) {
            b.this.dhn();
          }
          for (;;)
          {
            AppMethodBeat.o(24338);
            return;
            Log.i("MicroMsg.SubCoreExt", "notifyMsgUsers.size < 1");
          }
          label425:
          i += 1;
        }
      }
    };
    this.wsf = new n.a()
    {
      public final void a(s paramAnonymouss)
      {
        AppMethodBeat.i(24339);
        if (paramAnonymouss == null)
        {
          AppMethodBeat.o(24339);
          return;
        }
        Iterator localIterator = paramAnonymouss.hhb().Tmk.iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          Object localObject1 = (ezb)localIterator.next();
          Log.v("MicroMsg.SubCoreExt", "AppId[%s], UserName[%s], Xml[%s]", new Object[] { paramAnonymouss.appID, ((ezb)localObject1).UserName, ((ezb)localObject1).UzG });
          if ((!Util.isNullOrNil(((ezb)localObject1).UserName)) && (!Util.isNullOrNil(((ezb)localObject1).UzG)))
          {
            bh.beI();
            Object localObject2 = com.tencent.mm.model.c.bbL().bwg(((ezb)localObject1).UserName);
            if ((localObject2 == null) || ((int)((com.tencent.mm.contact.d)localObject2).jxt <= 0))
            {
              Log.e("MicroMsg.SubCoreExt", "contact is null");
            }
            else if (((as)localObject2).hxX())
            {
              Log.w("MicroMsg.SubCoreExt", "isBizContact");
            }
            else
            {
              localObject2 = n.bpG(((ezb)localObject1).UzG);
              if ((localObject2 != null) && (!Util.isNullOrNil(((n.b)localObject2).QVk)))
              {
                Log.v("MicroMsg.SubCoreExt", "AppId[%s], openId[%s]", new Object[] { paramAnonymouss.appID, ((n.b)localObject2).QVk });
                localObject1 = new cs(paramAnonymouss.appID, ((ezb)localObject1).UserName, ((n.b)localObject2).QVk);
                b.dhi().a((cs)localObject1);
                i = 1;
              }
            }
          }
        }
        if (i != 0) {
          b.this.dhn();
        }
        AppMethodBeat.o(24339);
      }
    };
    this.wsg = new MMHandler(Looper.getMainLooper())
    {
      @JgMethodChecked(author=20, fComment="checked", lastDate="20140514", reviewer=20, vComment={com.jg.EType.INTENTCHECK})
      public final void handleMessage(Message arg1)
      {
        AppMethodBeat.i(24341);
        if ((MMApplicationContext.getContext() == null) || (!bh.aHB()))
        {
          Log.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler wrong status");
          AppMethodBeat.o(24341);
          return;
        }
        Cursor localCursor = b.dhh().hAB();
        if (localCursor == null)
        {
          Log.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler getValidOpenMsgListener cu == null");
          AppMethodBeat.o(24341);
          return;
        }
        Log.d("MicroMsg.SubCoreExt", "notifyMsgChangeHandler listener count = %s", new Object[] { Integer.valueOf(localCursor.getCount()) });
        if (localCursor.getCount() <= 0)
        {
          localCursor.close();
          Log.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler cu.getCount() <= 0");
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
              Log.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler waitForNotify.entrySet() == null");
              AppMethodBeat.o(24341);
              return;
            }
          }
          localcg = new cg();
        }
        catch (Exception ???)
        {
          Log.e("MicroMsg.SubCoreExt", "Exception in handleMessage, %s", new Object[] { ???.getMessage() });
          if (localCursor != null) {
            localCursor.close();
          }
          AppMethodBeat.o(24341);
          return;
        }
        cg localcg;
        localcg.convertFrom(localCursor);
        if ((Util.isNullOrNil(localcg.field_appId)) || (Util.isNullOrNil(localcg.field_packageName)))
        {
          Log.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler wrong msgListener, appid = %s, package = %s", new Object[] { localcg.field_appId, localcg.field_packageName });
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
            localObject3 = Util.nullAsNil((String)???.getKey());
            localObject4 = (Integer)???.getValue();
            bh.beI();
            ??? = com.tencent.mm.model.c.bbR().bwx((String)localObject3);
            if ((??? != null) && (!Util.isNullOrNil(???.field_username)) && (???.field_unReadCount <= 0))
            {
              Log.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler no unread in conversation");
            }
            else if ((!ab.QY((String)localObject3)) && (!ab.Lj((String)localObject3)) && (!ab.Qm((String)localObject3)))
            {
              Object localObject5 = b.dhi();
              ??? = localcg.field_appId;
              if ((??? == null) || (???.length() <= 0) || (localObject3 == null)) {
                break label1139;
              }
              if (((String)localObject3).length() <= 0)
              {
                break label1139;
                label499:
                if ((??? != null) && (!Util.isNullOrNil(???.field_openId)) && (!Util.isNullOrNil(???.field_username))) {
                  break label715;
                }
                Log.d("MicroMsg.SubCoreExt", "notifyMsgChangeHandler openId is null, go get it.");
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
                localObject5 = ((ct)localObject5).db.query("UserOpenIdInApp", null, "appId=? and username=? ", new String[] { Util.escapeSqlValue(???), Util.escapeSqlValue((String)localObject3) }, null, null, null, 2);
                if (!((Cursor)localObject5).moveToFirst())
                {
                  Log.w("MicroMsg.scanner.UserOpenIdInAppStorage", "get null with appId-%s, username-%s:", new Object[] { ???, localObject3 });
                  ((Cursor)localObject5).close();
                  ??? = null;
                  break label499;
                }
                ??? = new cs();
                ???.convertFrom((Cursor)localObject5);
                ((Cursor)localObject5).close();
                break label499;
                label686:
                b.a(b.this).put(localObject3, Integer.valueOf(???.intValue() + ((Integer)localObject4).intValue()));
              }
              label715:
              Log.v("MicroMsg.SubCoreExt", "username[%s], appId[%s], openId[%s]", new Object[] { ???.field_username, ???.field_appId, ???.field_openId });
              localArrayList.add(String.format("%s,%s,%s", new Object[] { ???.field_openId, localObject4, Long.valueOf(System.currentTimeMillis() - 1600L) }));
            }
          }
          if (localLinkedList.size() > 0)
          {
            Log.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler doGetGetUserInfoInApp");
            localObject4 = b.this;
            ??? = localcg.field_appId;
            if ((!Util.isNullOrNil(???)) && (localLinkedList.size() > 0))
            {
              localObject2 = n.hgQ();
              localObject3 = MMApplicationContext.getContext();
              localObject4 = ((b)localObject4).wsf;
              Log.d("MicroMsg.GetUserInfoInAppLogic", "getGetUserInfoInApp");
              if (!n.QVh) {
                ((n)localObject2).hgR();
              }
              if ((bh.aHB()) && (localObject3 != null))
              {
                if (localLinkedList.size() != 0) {
                  break label929;
                }
                Log.d("MicroMsg.GetUserInfoInAppLogic", "userNameList empty");
              }
            }
          }
          while (localArrayList.size() <= 0)
          {
            localCursor.close();
            Log.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler userDataList.size() <= 0");
            AppMethodBeat.o(24341);
            return;
            label929:
            ((n)localObject2).QVj = ((n.a)localObject4);
            ??? = new s(???, localLinkedList);
            com.tencent.mm.pluginsdk.model.app.ao.fmC();
            com.tencent.mm.pluginsdk.model.app.e.a(14, ???);
          }
          if (localcg.field_status != 1) {
            break label1144;
          }
        }
        label1139:
        label1144:
        for (int i = 1;; i = 0)
        {
          if (i == 0)
          {
            Log.w("MicroMsg.SubCoreExt", "invalid msgListener, appid = %s, package = %s", new Object[] { localcg.field_appId, localcg.field_packageName });
            break label311;
          }
          if ((Util.isNullOrNil(localcg.field_appId)) || (Util.isNullOrNil(localcg.field_packageName))) {
            break label311;
          }
          Log.i("MicroMsg.SubCoreExt", "notify app, appId = %s, package = %s", new Object[] { localcg.field_appId, localcg.field_packageName });
          ??? = new Intent("com.tencent.mm.plugin.openapi.Intent.ACTION_NOTIFY_MSG");
          ???.addCategory("com.tencent.mm.category." + localcg.field_packageName);
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
          MMApplicationContext.getContext().sendBroadcast(???);
          break label311;
          break;
          ??? = null;
          break label499;
        }
      }
    };
    this.wsh = new LinkedList();
    this.wsi = 60L;
    this.wsj = new MMHandler(Looper.getMainLooper())
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
              localObject2 = com.tencent.mm.pluginsdk.model.app.h.o((String)localObject1, false, false);
              if (localObject2 == null)
              {
                Log.w("MicroMsg.SubCoreExt", "appInfo is null");
                continue;
              }
              if (!Util.isNullOrNil(((g)localObject2).field_appId)) {
                break label137;
              }
            }
            catch (Exception paramAnonymousMessage)
            {
              Log.e("MicroMsg.SubCoreExt", "exception in onAppInfoStgChange, %s", new Object[] { paramAnonymousMessage.getMessage() });
              AppMethodBeat.o(24342);
              return;
            }
            Log.w("MicroMsg.SubCoreExt", "appId is null");
            continue;
            Log.d("MicroMsg.SubCoreExt", "onAppInfoStgChange, notify[%s], appFlag[%s], id[%s]", new Object[] { localObject1, Integer.valueOf(((g)localObject2).field_appInfoFlag), ((g)localObject2).field_appId });
            localObject1 = b.dhh().bxk(((g)localObject2).field_appId);
            if (localObject1 != null) {
              break;
            }
            Log.w("MicroMsg.SubCoreExt", "openMsgListener is null, appId = %s", new Object[] { ((g)localObject2).field_appId });
          }
          if (!com.tencent.mm.pluginsdk.model.app.h.o((g)localObject2)) {
            break;
          }
        } while (((cg)localObject1).field_status == 1);
        com.tencent.mm.storage.ch localch;
        for (((cg)localObject1).field_status = 1;; ((cg)localObject1).field_status = 0)
        {
          localch = b.dhh();
          localObject2 = ((g)localObject2).field_appId;
          if ((!Util.isNullOrNil((String)localObject2)) && (localObject1 != null) && (!Util.isNullOrNil(((cg)localObject1).field_appId))) {
            break label289;
          }
          Log.w("MicroMsg.OpenMsgListenerStorage", "wrong argument");
          break;
          if (((cg)localObject1).field_status == 0) {
            break;
          }
        }
        label289:
        ContentValues localContentValues = ((cg)localObject1).convertTo();
        if (localContentValues.size() > 0) {}
        for (int i = localch.db.update("OpenMsgListener", localContentValues, "appId=?", new String[] { Util.escapeSqlValue((String)localObject2) });; i = 0)
        {
          Log.d("MicroMsg.OpenMsgListenerStorage", "update: id=%s, ret=%s ", new Object[] { ((cg)localObject1).field_appId, Integer.valueOf(i) });
          break;
          label360:
          b.b(b.this).clear();
          AppMethodBeat.o(24342);
          return;
        }
      }
    };
    this.wsk = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
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
    this.vgY = new MStorageEx.IOnStorageChange()
    {
      public final void onNotifyChange(int paramAnonymousInt, MStorageEx paramAnonymousMStorageEx, Object paramAnonymousObject)
      {
        AppMethodBeat.i(24335);
        if ((paramAnonymousObject == null) || (!(paramAnonymousObject instanceof String)))
        {
          Log.d("MicroMsg.SubCoreExt", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousMStorageEx, paramAnonymousObject });
          AppMethodBeat.o(24335);
          return;
        }
        if (!bh.aHB())
        {
          Log.i("MicroMsg.SubCoreExt", "onNotifyChange acc not ready");
          AppMethodBeat.o(24335);
          return;
        }
        bh.beI();
        if (paramAnonymousMStorageEx == com.tencent.mm.model.c.bbL()) {
          b.d(b.this);
        }
        AppMethodBeat.o(24335);
      }
    };
    this.wsl = true;
    this.wsm = false;
    AppMethodBeat.o(24346);
  }
  
  public static as JO(long paramLong)
  {
    AppMethodBeat.i(24358);
    if ((bh.aHB()) && (paramLong > 0L))
    {
      bh.beI();
      as localas = com.tencent.mm.model.c.bbL().UT(paramLong);
      AppMethodBeat.o(24358);
      return localas;
    }
    AppMethodBeat.o(24358);
    return null;
  }
  
  public static void JP(long paramLong)
  {
    AppMethodBeat.i(24359);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(24359);
      return;
    }
    try
    {
      bh.beI();
      if (com.tencent.mm.model.c.bbO().Ot(paramLong))
      {
        bh.beI();
        i locali = com.tencent.mm.model.c.bbO();
        bh.beI();
        locali.aN(com.tencent.mm.model.c.bbO().Oq(paramLong));
        AppMethodBeat.o(24359);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.SubCoreExt", localException.getMessage());
      Log.printErrStackTrace("MicroMsg.SubCoreExt", localException, "", new Object[0]);
      AppMethodBeat.o(24359);
      return;
    }
    Log.e("MicroMsg.SubCoreExt", "msgId is out of range, ".concat(String.valueOf(paramLong)));
    AppMethodBeat.o(24359);
  }
  
  public static b dhf()
  {
    AppMethodBeat.i(24347);
    bh.beC();
    b localb2 = (b)com.tencent.mm.model.ch.RZ("plugin.ext");
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      bh.beC().a("plugin.ext", localb1);
    }
    AppMethodBeat.o(24347);
    return localb1;
  }
  
  public static com.tencent.mm.storage.ao dhg()
  {
    AppMethodBeat.i(24348);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (dhf().wrX == null)
    {
      localObject = dhf();
      bh.beI();
      ((b)localObject).wrX = new com.tencent.mm.storage.ao(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = dhf().wrX;
    AppMethodBeat.o(24348);
    return localObject;
  }
  
  public static com.tencent.mm.storage.ch dhh()
  {
    AppMethodBeat.i(24349);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (dhf().wrY == null)
    {
      localObject = dhf();
      bh.beI();
      ((b)localObject).wrY = new com.tencent.mm.storage.ch(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = dhf().wrY;
    AppMethodBeat.o(24349);
    return localObject;
  }
  
  public static ct dhi()
  {
    AppMethodBeat.i(24350);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (dhf().wrZ == null)
    {
      localObject = dhf();
      bh.beI();
      ((b)localObject).wrZ = new ct(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = dhf().wrZ;
    AppMethodBeat.o(24350);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.ext.a.a dhj()
  {
    AppMethodBeat.i(24351);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (dhf().wsa == null)
    {
      localObject = dhf();
      bh.beI();
      ((b)localObject).wsa = new com.tencent.mm.plugin.ext.a.a(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = dhf().wsa;
    AppMethodBeat.o(24351);
    return localObject;
  }
  
  private static void dhk()
  {
    AppMethodBeat.i(24353);
    com.tencent.mm.vfs.q localq = new com.tencent.mm.vfs.q(com.tencent.mm.kernel.h.aHG().kcB);
    if (!localq.ifE()) {
      localq.ifL();
    }
    localq = new com.tencent.mm.vfs.q(com.tencent.mm.kernel.h.aHG().kcB + "image/ext/pcm");
    if (!localq.ifE()) {
      localq.ifL();
    }
    Log.i("MicroMsg.SubCoreExt", "summerpcm accPath[%s] [%s]", new Object[] { com.tencent.mm.kernel.h.aHG().kcB, Util.getStack() });
    AppMethodBeat.o(24353);
  }
  
  public static String dhl()
  {
    AppMethodBeat.i(24356);
    String str = com.tencent.mm.kernel.h.aHG().kcB + "image/ext/pcm";
    AppMethodBeat.o(24356);
    return str;
  }
  
  public static void dhm()
  {
    AppMethodBeat.i(24357);
    Object localObject = (String)dhg().get(ar.a.Vmu, null);
    Log.i("MicroMsg.SubCoreExt", "sendSportBroadcast pkgNames = ".concat(String.valueOf(localObject)));
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
        com.tencent.mm.compatible.a.a.a(12, new b.6(localIntent));
        localIntent.putExtra("EXTRA_EXT_OPEN_NOTIFY_TYPE", "SPORT_MESSAGE");
        MMApplicationContext.getContext().sendBroadcast(localIntent);
        i += 1;
      }
    }
    AppMethodBeat.o(24357);
  }
  
  private void nF(boolean paramBoolean)
  {
    AppMethodBeat.i(24361);
    if (!this.wsl)
    {
      AppMethodBeat.o(24361);
      return;
    }
    if ((paramBoolean) && (this.wsm))
    {
      Log.i("MicroMsg.SubCoreExt", "fromStartApp and already try to init");
      AppMethodBeat.o(24361);
      return;
    }
    if ((!paramBoolean) && (!wsn))
    {
      AppMethodBeat.o(24361);
      return;
    }
    Log.i("MicroMsg.SubCoreExt", "initLocalVoiceControl,fromStartApp:%s,hasTryToInit:%s,hasCallApi:%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.wsm), Boolean.valueOf(wsn) });
    this.wsl = false;
    bh.aHJ().postToWorkerDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24336);
        Object localObject2;
        int i;
        int j;
        try
        {
          localObject2 = com.tencent.mm.n.h.axc().getValue("VoiceRecognizeSprSoMD5");
          localObject3 = com.tencent.mm.n.h.axc().getValue("VoiceRecognizeSprDataMD5");
          if ((localObject2 == null) || (localObject3 == null) || (com.tencent.mm.compatible.deviceinfo.q.is64BitRuntime()))
          {
            Log.i("MicroMsg.SubCoreExt", "error mMd5So:%s,  mMd5Data:%s", new Object[] { localObject2, localObject3 });
            b.e(b.this);
            AppMethodBeat.o(24336);
            return;
          }
          Object localObject1 = "/system/lib/";
          if (Build.VERSION.SDK_INT >= 24) {
            localObject1 = "/vendor/lib/";
          }
          Log.i("MicroMsg.SubCoreExt", "mMd5So:%s,  mMd5Data:%s,  mSoPath:%s", new Object[] { localObject2, localObject3, localObject1 });
          l = System.currentTimeMillis();
          Object localObject5 = com.qq.wx.voice.embed.recognizer.b.a.cio;
          Object localObject4 = MMApplicationContext.getContext();
          localObject5 = ((com.qq.wx.voice.embed.recognizer.b)localObject5).cin;
          if (((com.qq.wx.voice.embed.recognizer.e)localObject5).d) {
            i = 0;
          }
          for (;;)
          {
            localObject1 = MMApplicationContext.getDefaultPreference();
            Log.i("MicroMsg.SubCoreExt", "checkFiles ret:%s,use time:%s", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
            if (i != 0) {
              break label700;
            }
            l = System.currentTimeMillis();
            localObject3 = new LinkedList();
            ((List)localObject3).add("tmessage");
            ((List)localObject3).add("officialaccounts");
            ((List)localObject3).add("helper_entry");
            bh.beI();
            localObject2 = com.tencent.mm.model.c.bbU().aPi("@t.qq.com");
            if (localObject2 != null) {
              ((List)localObject3).add(((cj)localObject2).name);
            }
            localObject2 = new ArrayList();
            bh.beI();
            localObject3 = com.tencent.mm.model.c.bbL().a("@all.contact.android", null, (List)localObject3, null, true, true);
            if (localObject3 != null) {
              break;
            }
            Log.w("MicroMsg.SubCoreExt", "initLocalVoiceControl cu is null");
            b.e(b.this);
            AppMethodBeat.o(24336);
            return;
            j = ((com.qq.wx.voice.embed.recognizer.e)localObject5).cit.checkFiles((Context)localObject4, (String)localObject1, (String)localObject2, (String)localObject3);
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
              localObject4 = new com.tencent.mm.storage.f();
              ((com.tencent.mm.storage.f)localObject4).convertFrom((Cursor)localObject3);
              ((ArrayList)localObject2).add(new com.qq.wx.voice.embed.recognizer.d(((com.tencent.mm.storage.f)localObject4).field_username, ((com.tencent.mm.storage.f)localObject4).field_nickname, ((com.tencent.mm.storage.f)localObject4).field_conRemark));
              ((Cursor)localObject3).moveToNext();
            }
          }
          ((Cursor)localObject3).close();
        }
        catch (Exception localException)
        {
          Log.i("MicroMsg.SubCoreExt", "initLocalVoiceControl Exception:%s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(24336);
          return;
        }
        Log.i("MicroMsg.SubCoreExt", "init cusor,count:%s,use time:%s", new Object[] { Integer.valueOf(((Cursor)localObject3).getCount()), Long.valueOf(System.currentTimeMillis() - l) });
        long l = System.currentTimeMillis();
        Object localObject3 = com.qq.wx.voice.embed.recognizer.b.a.cio.cin;
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
            Log.i("MicroMsg.SubCoreExt", "init ret:%s,use time:%s", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
            b.e(b.this);
          }
          for (;;)
          {
            b.e(b.this);
            AppMethodBeat.o(24336);
            return;
            if (((com.qq.wx.voice.embed.recognizer.e)localObject3).e)
            {
              j = ((com.qq.wx.voice.embed.recognizer.e)localObject3).cit.update((ArrayList)localObject2);
              i = j;
              if (j < 0) {
                break;
              }
              break label741;
            }
            j = ((com.qq.wx.voice.embed.recognizer.e)localObject3).cit.init((ArrayList)localObject2);
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
  
  public void clearPluginData(int paramInt) {}
  
  public final void dhn()
  {
    AppMethodBeat.i(24360);
    this.wsg.removeMessages(0);
    this.wsg.sendEmptyMessageDelayed(0, 1600L);
    AppMethodBeat.o(24360);
  }
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(24354);
    Object localObject = new fx();
    ((fx)localObject).fBF.op = 1;
    if (!EventCenter.instance.publish((IEvent)localObject)) {
      Log.e("MicroMsg.SubCoreExt", "ExtAgentLifeEvent event fail in onAccountPostReset");
    }
    n.hgQ().hgR();
    bh.beI();
    com.tencent.mm.model.c.bbO().a(this.wse, null);
    if (this.wsb == null) {
      this.wsb = new b.a();
    }
    EventCenter.instance.addListener(this.wsb);
    if (this.wsc == null) {
      this.wsc = new b.b();
    }
    EventCenter.instance.addListener(this.wsc);
    localObject = com.tencent.mm.pluginsdk.model.app.ao.fmz();
    if (localObject != null) {
      ((com.tencent.mm.pluginsdk.model.app.j)localObject).add(this.wsk);
    }
    localObject = MMApplicationContext.getDefaultPreference();
    this.wsm = ((SharedPreferences)localObject).getBoolean("hasTryToInitVoiceControlData", false);
    wsn = ((SharedPreferences)localObject).getBoolean("hasCallVoiceControlApi", false);
    Log.i("MicroMsg.SubCoreExt", "onAccountPostReset,hasTryToInit:%s,hasCallApi:%s", new Object[] { Boolean.valueOf(this.wsm), Boolean.valueOf(wsn) });
    bh.beI();
    com.tencent.mm.model.c.bbL().add(this.vgY);
    nF(true);
    com.tencent.mm.plugin.ext.d.c.dhB();
    dhk();
    AppMethodBeat.o(24354);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(24355);
    if (this.wsb != null) {
      EventCenter.instance.removeListener(this.wsb);
    }
    if (this.wsc != null) {
      EventCenter.instance.removeListener(this.wsc);
    }
    Object localObject = com.tencent.mm.pluginsdk.model.app.ao.fmz();
    if (localObject != null) {
      ((com.tencent.mm.pluginsdk.model.app.j)localObject).remove(this.wsk);
    }
    bh.beI();
    com.tencent.mm.model.c.bbO().a(this.wse);
    localObject = new fx();
    ((fx)localObject).fBF.op = 2;
    if (!EventCenter.instance.publish((IEvent)localObject)) {
      Log.e("MicroMsg.SubCoreExt", "ExtAgentLifeEvent event fail in onAccountRelease");
    }
    localObject = n.hgQ();
    if (bh.aHB())
    {
      n.QVh = false;
      com.tencent.mm.pluginsdk.model.app.ao.fmC().b(14, (u)localObject);
    }
    bh.beI();
    com.tencent.mm.model.c.bbL().remove(this.vgY);
    com.tencent.mm.plugin.ext.d.c.dhC();
    AppMethodBeat.o(24355);
  }
  
  public void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(24352);
    dhk();
    AppMethodBeat.o(24352);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.b
 * JD-Core Version:    0.7.0.1
 */