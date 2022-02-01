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
import com.qq.wx.voice.embed.recognizer.Grammar;
import com.qq.wx.voice.embed.recognizer.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.gi;
import com.tencent.mm.autogen.a.gq;
import com.tencent.mm.autogen.a.gw;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.compatible.a.a.a;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.y;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.model.p.a;
import com.tencent.mm.pluginsdk.model.p.b;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.protocal.protobuf.fvc;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.IListener;
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
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.ch;
import com.tencent.mm.storage.cm;
import com.tencent.mm.storage.cv;
import com.tencent.mm.storage.cw;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class SubCoreExt
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private static boolean zOt;
  MStorageEx.IOnStorageChange yta;
  private final long zOc;
  private aq zOd;
  private com.tencent.mm.storage.ci zOe;
  private cw zOf;
  private com.tencent.mm.plugin.ext.a.a zOg;
  private ExtOpenApiCallEventListener zOh;
  private ExtStepCountEventListener zOi;
  private HashMap<String, Integer> zOj;
  private i.a zOk;
  p.a zOl;
  private MMHandler zOm;
  private LinkedList<String> zOn;
  private final long zOo;
  private MMHandler zOp;
  private MStorage.IOnStorageChange zOq;
  private boolean zOr;
  private boolean zOs;
  
  static
  {
    AppMethodBeat.i(24363);
    int i = m.aOK();
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
            return com.tencent.mm.storage.ci.SQL_CREATE;
          }
        });
        baseDBFactories.put(Integer.valueOf("USEROPENIDINAPP_TABLE".hashCode()), new h.b()
        {
          public final String[] getSQLs()
          {
            return cw.SQL_CREATE;
          }
        });
        baseDBFactories.put(Integer.valueOf("WXATOKENINFO_TABLE".hashCode()), new SubCoreExt.5());
        zOt = false;
        AppMethodBeat.o(24363);
        return;
        if ((i & 0x400) == 0) {
          break;
        }
        SubCoreExt.class.getClassLoader();
        k.DA("wechatvoicesilk");
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
  
  public SubCoreExt()
  {
    AppMethodBeat.i(24346);
    this.zOc = 1600L;
    this.zOj = new HashMap();
    this.zOk = new i.a()
    {
      public final void onNotifyChange(com.tencent.mm.plugin.messenger.foundation.a.a.i arg1, i.c paramAnonymousc)
      {
        AppMethodBeat.i(24338);
        if (CrashReportFactory.isBackupMerge())
        {
          AppMethodBeat.o(24338);
          return;
        }
        if ((??? == null) || (paramAnonymousc == null) || (paramAnonymousc.mZo == null))
        {
          Log.e("MicroMsg.SubCoreExt", "onMsgChange, wrong args");
          AppMethodBeat.o(24338);
          return;
        }
        for (;;)
        {
          int i;
          synchronized (SubCoreExt.this)
          {
            Object localObject = SubCoreExt.dNS().jcE();
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
            if (i < paramAnonymousc.mZo.size())
            {
              localObject = (cc)paramAnonymousc.mZo.get(i);
              if ((localObject == null) || (((fi)localObject).field_isSend != 0) || (((fi)localObject).field_status == 4) || (((cc)localObject).getType() == 9999) || (((cc)localObject).getType() == 10000) || (ab.IW(((fi)localObject).field_talker)) || (ab.Ja(((fi)localObject).field_talker))) {
                break label425;
              }
              Integer localInteger = (Integer)SubCoreExt.a(SubCoreExt.this).get(((fi)localObject).field_talker);
              if (localInteger == null)
              {
                SubCoreExt.a(SubCoreExt.this).put(((fi)localObject).field_talker, Integer.valueOf(1));
                Log.d("MicroMsg.SubCoreExt", "onMsgChange %s, %d", new Object[] { ((fi)localObject).field_talker, Integer.valueOf(1) });
              }
              else
              {
                SubCoreExt.a(SubCoreExt.this).put(((fi)localObject).field_talker, Integer.valueOf(localInteger.intValue() + 1));
                Log.d("MicroMsg.SubCoreExt", "onMsgChange %s, %d", new Object[] { ((fi)localObject).field_talker, Integer.valueOf(localInteger.intValue() + 1) });
              }
            }
          }
          if (SubCoreExt.a(SubCoreExt.this).size() > 0) {
            SubCoreExt.this.dNY();
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
    this.zOl = new p.a()
    {
      public final void a(com.tencent.mm.pluginsdk.model.u paramAnonymousu)
      {
        AppMethodBeat.i(24339);
        if (paramAnonymousu == null)
        {
          AppMethodBeat.o(24339);
          return;
        }
        Iterator localIterator = paramAnonymousu.iIb().aaAn.iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          Object localObject1 = (fvc)localIterator.next();
          Log.v("MicroMsg.SubCoreExt", "AppId[%s], UserName[%s], Xml[%s]", new Object[] { paramAnonymousu.appID, ((fvc)localObject1).UserName, ((fvc)localObject1).abTB });
          if ((!Util.isNullOrNil(((fvc)localObject1).UserName)) && (!Util.isNullOrNil(((fvc)localObject1).abTB)))
          {
            bh.bCz();
            Object localObject2 = com.tencent.mm.model.c.bzA().bxu(((fvc)localObject1).UserName);
            if ((localObject2 == null) || ((int)((com.tencent.mm.contact.d)localObject2).maN <= 0))
            {
              Log.e("MicroMsg.SubCoreExt", "contact is null");
            }
            else if (((au)localObject2).iZC())
            {
              Log.w("MicroMsg.SubCoreExt", "isBizContact");
            }
            else
            {
              localObject2 = p.bpw(((fvc)localObject1).abTB);
              if ((localObject2 != null) && (!Util.isNullOrNil(((p.b)localObject2).XRf)))
              {
                Log.v("MicroMsg.SubCoreExt", "AppId[%s], openId[%s]", new Object[] { paramAnonymousu.appID, ((p.b)localObject2).XRf });
                localObject1 = new cv(paramAnonymousu.appID, ((fvc)localObject1).UserName, ((p.b)localObject2).XRf);
                SubCoreExt.dNT().a((cv)localObject1);
                i = 1;
              }
            }
          }
        }
        if (i != 0) {
          SubCoreExt.this.dNY();
        }
        AppMethodBeat.o(24339);
      }
    };
    this.zOm = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message arg1)
      {
        AppMethodBeat.i(24341);
        if ((MMApplicationContext.getContext() == null) || (!bh.baz()))
        {
          Log.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler wrong status");
          AppMethodBeat.o(24341);
          return;
        }
        Cursor localCursor = SubCoreExt.dNS().jcE();
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
          synchronized (SubCoreExt.this)
          {
            localHashMap.putAll(SubCoreExt.a(SubCoreExt.this));
            SubCoreExt.a(SubCoreExt.this).clear();
            localLinkedList = new LinkedList();
            localArrayList = new ArrayList();
            if (localHashMap.entrySet() == null)
            {
              Log.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler waitForNotify.entrySet() == null");
              AppMethodBeat.o(24341);
              return;
            }
          }
          localch = new ch();
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
        ch localch;
        localch.convertFrom(localCursor);
        if ((Util.isNullOrNil(localch.field_appId)) || (Util.isNullOrNil(localch.field_packageName)))
        {
          Log.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler wrong msgListener, appid = %s, package = %s", new Object[] { localch.field_appId, localch.field_packageName });
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
            bh.bCz();
            ??? = com.tencent.mm.model.c.bzG().bxM((String)localObject3);
            if ((??? != null) && (!Util.isNullOrNil(???.field_username)) && (???.field_unReadCount <= 0))
            {
              Log.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler no unread in conversation");
            }
            else if ((!ab.IW((String)localObject3)) && (!au.bwE((String)localObject3)) && (!ab.IS((String)localObject3)))
            {
              Object localObject5 = SubCoreExt.dNT();
              ??? = localch.field_appId;
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
                ??? = (Integer)SubCoreExt.a(SubCoreExt.this).get(localObject3);
                if (??? != null) {
                  break label686;
                }
                SubCoreExt.a(SubCoreExt.this).put(localObject3, localObject4);
              }
              for (;;)
              {
                localLinkedList.add(localObject3);
                break;
                localObject5 = ((cw)localObject5).db.query("UserOpenIdInApp", null, "appId=? and username=? ", new String[] { Util.escapeSqlValue(???), Util.escapeSqlValue((String)localObject3) }, null, null, null, 2);
                if (!((Cursor)localObject5).moveToFirst())
                {
                  Log.w("MicroMsg.scanner.UserOpenIdInAppStorage", "get null with appId-%s, username-%s:", new Object[] { ???, localObject3 });
                  ((Cursor)localObject5).close();
                  ??? = null;
                  break label499;
                }
                ??? = new cv();
                ???.convertFrom((Cursor)localObject5);
                ((Cursor)localObject5).close();
                break label499;
                label686:
                SubCoreExt.a(SubCoreExt.this).put(localObject3, Integer.valueOf(???.intValue() + ((Integer)localObject4).intValue()));
              }
              label715:
              Log.v("MicroMsg.SubCoreExt", "username[%s], appId[%s], openId[%s]", new Object[] { ???.field_username, ???.field_appId, ???.field_openId });
              localArrayList.add(String.format("%s,%s,%s", new Object[] { ???.field_openId, localObject4, Long.valueOf(System.currentTimeMillis() - 1600L) }));
            }
          }
          if (localLinkedList.size() > 0)
          {
            Log.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler doGetGetUserInfoInApp");
            localObject4 = SubCoreExt.this;
            ??? = localch.field_appId;
            if ((!Util.isNullOrNil(???)) && (localLinkedList.size() > 0))
            {
              localObject2 = p.iHP();
              localObject3 = MMApplicationContext.getContext();
              localObject4 = ((SubCoreExt)localObject4).zOl;
              Log.d("MicroMsg.GetUserInfoInAppLogic", "getGetUserInfoInApp");
              if (!p.XRc) {
                ((p)localObject2).iHQ();
              }
              if ((bh.baz()) && (localObject3 != null))
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
            ((p)localObject2).XRe = ((p.a)localObject4);
            ??? = new com.tencent.mm.pluginsdk.model.u(???, localLinkedList);
            as.gxq();
            com.tencent.mm.pluginsdk.model.app.e.a(14, ???);
          }
          if (localch.field_status != 1) {
            break label1144;
          }
        }
        label1139:
        label1144:
        for (int i = 1;; i = 0)
        {
          if (i == 0)
          {
            Log.w("MicroMsg.SubCoreExt", "invalid msgListener, appid = %s, package = %s", new Object[] { localch.field_appId, localch.field_packageName });
            break label311;
          }
          if ((Util.isNullOrNil(localch.field_appId)) || (Util.isNullOrNil(localch.field_packageName))) {
            break label311;
          }
          Log.i("MicroMsg.SubCoreExt", "notify app, appId = %s, package = %s", new Object[] { localch.field_appId, localch.field_packageName });
          ??? = new Intent("com.tencent.mm.plugin.openapi.Intent.ACTION_NOTIFY_MSG");
          ???.addCategory("com.tencent.mm.category." + localch.field_packageName);
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
    this.zOn = new LinkedList();
    this.zOo = 60L;
    this.zOp = new MMHandler(Looper.getMainLooper())
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
              i = SubCoreExt.b(SubCoreExt.this).size();
              if (i <= 0)
              {
                AppMethodBeat.o(24342);
                return;
              }
              paramAnonymousMessage = SubCoreExt.b(SubCoreExt.this).iterator();
              if (!paramAnonymousMessage.hasNext()) {
                break label360;
              }
              localObject1 = (String)paramAnonymousMessage.next();
              if ("*".equals(localObject1)) {
                continue;
              }
              localObject2 = com.tencent.mm.pluginsdk.model.app.h.s((String)localObject1, false, false);
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
            localObject1 = SubCoreExt.dNS().byD(((g)localObject2).field_appId);
            if (localObject1 != null) {
              break;
            }
            Log.w("MicroMsg.SubCoreExt", "openMsgListener is null, appId = %s", new Object[] { ((g)localObject2).field_appId });
          }
          if (!com.tencent.mm.pluginsdk.model.app.h.o((g)localObject2)) {
            break;
          }
        } while (((ch)localObject1).field_status == 1);
        com.tencent.mm.storage.ci localci;
        for (((ch)localObject1).field_status = 1;; ((ch)localObject1).field_status = 0)
        {
          localci = SubCoreExt.dNS();
          localObject2 = ((g)localObject2).field_appId;
          if ((!Util.isNullOrNil((String)localObject2)) && (localObject1 != null) && (!Util.isNullOrNil(((ch)localObject1).field_appId))) {
            break label289;
          }
          Log.w("MicroMsg.OpenMsgListenerStorage", "wrong argument");
          break;
          if (((ch)localObject1).field_status == 0) {
            break;
          }
        }
        label289:
        ContentValues localContentValues = ((ch)localObject1).convertTo();
        if (localContentValues.size() > 0) {}
        for (int i = localci.db.update("OpenMsgListener", localContentValues, "appId=?", new String[] { Util.escapeSqlValue((String)localObject2) });; i = 0)
        {
          Log.d("MicroMsg.OpenMsgListenerStorage", "update: id=%s, ret=%s ", new Object[] { ((ch)localObject1).field_appId, Integer.valueOf(i) });
          break;
          label360:
          SubCoreExt.b(SubCoreExt.this).clear();
          AppMethodBeat.o(24342);
          return;
        }
      }
    };
    this.zOq = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(24343);
        if (!SubCoreExt.b(SubCoreExt.this).contains(paramAnonymousString)) {
          SubCoreExt.b(SubCoreExt.this).add(paramAnonymousString);
        }
        SubCoreExt.c(SubCoreExt.this).removeMessages(0);
        SubCoreExt.c(SubCoreExt.this).sendEmptyMessageDelayed(0, 60L);
        AppMethodBeat.o(24343);
      }
    };
    this.yta = new MStorageEx.IOnStorageChange()
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
        if (!bh.baz())
        {
          Log.i("MicroMsg.SubCoreExt", "onNotifyChange acc not ready");
          AppMethodBeat.o(24335);
          return;
        }
        bh.bCz();
        if (paramAnonymousMStorageEx == com.tencent.mm.model.c.bzA()) {
          SubCoreExt.d(SubCoreExt.this);
        }
        AppMethodBeat.o(24335);
      }
    };
    this.zOr = true;
    this.zOs = false;
    AppMethodBeat.o(24346);
  }
  
  public static SubCoreExt dNQ()
  {
    AppMethodBeat.i(24347);
    bh.bCt();
    SubCoreExt localSubCoreExt2 = (SubCoreExt)com.tencent.mm.model.ci.Ka("plugin.ext");
    SubCoreExt localSubCoreExt1 = localSubCoreExt2;
    if (localSubCoreExt2 == null)
    {
      localSubCoreExt1 = new SubCoreExt();
      bh.bCt().a("plugin.ext", localSubCoreExt1);
    }
    AppMethodBeat.o(24347);
    return localSubCoreExt1;
  }
  
  public static aq dNR()
  {
    AppMethodBeat.i(24348);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (dNQ().zOd == null)
    {
      localObject = dNQ();
      bh.bCz();
      ((SubCoreExt)localObject).zOd = new aq(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = dNQ().zOd;
    AppMethodBeat.o(24348);
    return localObject;
  }
  
  public static com.tencent.mm.storage.ci dNS()
  {
    AppMethodBeat.i(24349);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (dNQ().zOe == null)
    {
      localObject = dNQ();
      bh.bCz();
      ((SubCoreExt)localObject).zOe = new com.tencent.mm.storage.ci(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = dNQ().zOe;
    AppMethodBeat.o(24349);
    return localObject;
  }
  
  public static cw dNT()
  {
    AppMethodBeat.i(24350);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (dNQ().zOf == null)
    {
      localObject = dNQ();
      bh.bCz();
      ((SubCoreExt)localObject).zOf = new cw(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = dNQ().zOf;
    AppMethodBeat.o(24350);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.ext.a.a dNU()
  {
    AppMethodBeat.i(24351);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (dNQ().zOg == null)
    {
      localObject = dNQ();
      bh.bCz();
      ((SubCoreExt)localObject).zOg = new com.tencent.mm.plugin.ext.a.a(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = dNQ().zOg;
    AppMethodBeat.o(24351);
    return localObject;
  }
  
  private static void dNV()
  {
    AppMethodBeat.i(24353);
    com.tencent.mm.vfs.u localu = new com.tencent.mm.vfs.u(com.tencent.mm.kernel.h.baE().mCJ);
    if (!localu.jKS()) {
      localu.jKY();
    }
    localu = new com.tencent.mm.vfs.u(com.tencent.mm.kernel.h.baE().mCJ + "image/ext/pcm");
    if (!localu.jKS()) {
      localu.jKY();
    }
    Log.i("MicroMsg.SubCoreExt", "summerpcm accPath[%s] [%s]", new Object[] { com.tencent.mm.kernel.h.baE().mCJ, Util.getStack() });
    AppMethodBeat.o(24353);
  }
  
  public static String dNW()
  {
    AppMethodBeat.i(24356);
    String str = com.tencent.mm.kernel.h.baE().mCJ + "image/ext/pcm";
    AppMethodBeat.o(24356);
    return str;
  }
  
  public static void dNX()
  {
    AppMethodBeat.i(24357);
    Object localObject = (String)dNR().get(at.a.acNP, null);
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
        com.tencent.mm.compatible.a.a.a(12, new a.a()
        {
          public final void run()
          {
            AppMethodBeat.i(24337);
            SubCoreExt.this.setFlags(32);
            AppMethodBeat.o(24337);
          }
        });
        localIntent.putExtra("EXTRA_EXT_OPEN_NOTIFY_TYPE", "SPORT_MESSAGE");
        MMApplicationContext.getContext().sendBroadcast(localIntent);
        i += 1;
      }
    }
    AppMethodBeat.o(24357);
  }
  
  public static au mm(long paramLong)
  {
    AppMethodBeat.i(24358);
    if ((bh.baz()) && (paramLong > 0L))
    {
      bh.bCz();
      au localau = com.tencent.mm.model.c.bzA().zc(paramLong);
      AppMethodBeat.o(24358);
      return localau;
    }
    AppMethodBeat.o(24358);
    return null;
  }
  
  public static void mn(long paramLong)
  {
    AppMethodBeat.i(24359);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(24359);
      return;
    }
    try
    {
      bh.bCz();
      if (com.tencent.mm.model.c.bzD().so(paramLong))
      {
        bh.bCz();
        com.tencent.mm.plugin.messenger.foundation.a.a.i locali = com.tencent.mm.model.c.bzD();
        bh.bCz();
        locali.bb(com.tencent.mm.model.c.bzD().sl(paramLong));
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
  
  private void pf(boolean paramBoolean)
  {
    AppMethodBeat.i(24361);
    if (!this.zOr)
    {
      AppMethodBeat.o(24361);
      return;
    }
    if ((paramBoolean) && (this.zOs))
    {
      Log.i("MicroMsg.SubCoreExt", "fromStartApp and already try to init");
      AppMethodBeat.o(24361);
      return;
    }
    if ((!paramBoolean) && (!zOt))
    {
      AppMethodBeat.o(24361);
      return;
    }
    Log.i("MicroMsg.SubCoreExt", "initLocalVoiceControl,fromStartApp:%s,hasTryToInit:%s,hasCallApi:%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.zOs), Boolean.valueOf(zOt) });
    this.zOr = false;
    bh.baH().postToWorkerDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24336);
        Object localObject2;
        int i;
        int j;
        try
        {
          localObject2 = com.tencent.mm.k.i.aRC().getValue("VoiceRecognizeSprSoMD5");
          localObject3 = com.tencent.mm.k.i.aRC().getValue("VoiceRecognizeSprDataMD5");
          if ((localObject2 == null) || (localObject3 == null) || (q.awm()))
          {
            Log.i("MicroMsg.SubCoreExt", "error mMd5So:%s,  mMd5Data:%s", new Object[] { localObject2, localObject3 });
            SubCoreExt.e(SubCoreExt.this);
            AppMethodBeat.o(24336);
            return;
          }
          Object localObject1 = "/system/lib/";
          if (Build.VERSION.SDK_INT >= 24) {
            localObject1 = "/vendor/lib/";
          }
          Log.i("MicroMsg.SubCoreExt", "mMd5So:%s,  mMd5Data:%s,  mSoPath:%s", new Object[] { localObject2, localObject3, localObject1 });
          l = System.currentTimeMillis();
          Object localObject5 = b.a.dYN;
          Object localObject4 = MMApplicationContext.getContext();
          localObject5 = ((com.qq.wx.voice.embed.recognizer.b)localObject5).dYM;
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
            bh.bCz();
            localObject2 = com.tencent.mm.model.c.bzJ().aMh("@t.qq.com");
            if (localObject2 != null) {
              ((List)localObject3).add(((cm)localObject2).name);
            }
            localObject2 = new ArrayList();
            bh.bCz();
            localObject3 = com.tencent.mm.model.c.bzA().a("@all.contact.android", null, (List)localObject3, null, true, true);
            if (localObject3 != null) {
              break;
            }
            Log.w("MicroMsg.SubCoreExt", "initLocalVoiceControl cu is null");
            SubCoreExt.e(SubCoreExt.this);
            AppMethodBeat.o(24336);
            return;
            j = ((com.qq.wx.voice.embed.recognizer.e)localObject5).dYS.checkFiles((Context)localObject4, (String)localObject1, (String)localObject2, (String)localObject3);
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
        Object localObject3 = b.a.dYN.dYM;
        if (!((com.qq.wx.voice.embed.recognizer.e)localObject3).d) {
          i = -304;
        }
        for (;;)
        {
          if (i == 0)
          {
            localException.edit().putBoolean("hasInitVoiceControlData", true).putBoolean("hasTryToInitVoiceControlData", true).commit();
            SubCoreExt.f(SubCoreExt.this);
            label569:
            Log.i("MicroMsg.SubCoreExt", "init ret:%s,use time:%s", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
            SubCoreExt.e(SubCoreExt.this);
          }
          for (;;)
          {
            SubCoreExt.e(SubCoreExt.this);
            AppMethodBeat.o(24336);
            return;
            if (((com.qq.wx.voice.embed.recognizer.e)localObject3).e)
            {
              j = ((com.qq.wx.voice.embed.recognizer.e)localObject3).dYS.update((ArrayList)localObject2);
              i = j;
              if (j < 0) {
                break;
              }
              break label741;
            }
            j = ((com.qq.wx.voice.embed.recognizer.e)localObject3).dYS.init((ArrayList)localObject2);
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
            SubCoreExt.f(SubCoreExt.this);
          }
          label741:
          i = 0;
        }
      }
    }, 10000L);
    AppMethodBeat.o(24361);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public final void dNY()
  {
    AppMethodBeat.i(24360);
    this.zOm.removeMessages(0);
    this.zOm.sendEmptyMessageDelayed(0, 1600L);
    AppMethodBeat.o(24360);
  }
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(24354);
    Object localObject = new gi();
    ((gi)localObject).hGu.op = 1;
    if (!((gi)localObject).publish()) {
      Log.e("MicroMsg.SubCoreExt", "ExtAgentLifeEvent event fail in onAccountPostReset");
    }
    p.iHP().iHQ();
    bh.bCz();
    com.tencent.mm.model.c.bzD().a(this.zOk, null);
    if (this.zOh == null) {
      this.zOh = new ExtOpenApiCallEventListener();
    }
    this.zOh.alive();
    if (this.zOi == null) {
      this.zOi = new ExtStepCountEventListener();
    }
    this.zOi.alive();
    localObject = as.gxn();
    if (localObject != null) {
      ((j)localObject).add(this.zOq);
    }
    localObject = MMApplicationContext.getDefaultPreference();
    this.zOs = ((SharedPreferences)localObject).getBoolean("hasTryToInitVoiceControlData", false);
    zOt = ((SharedPreferences)localObject).getBoolean("hasCallVoiceControlApi", false);
    Log.i("MicroMsg.SubCoreExt", "onAccountPostReset,hasTryToInit:%s,hasCallApi:%s", new Object[] { Boolean.valueOf(this.zOs), Boolean.valueOf(zOt) });
    bh.bCz();
    com.tencent.mm.model.c.bzA().add(this.yta);
    pf(true);
    com.tencent.mm.plugin.ext.qrcode.c.dOm();
    dNV();
    AppMethodBeat.o(24354);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(24355);
    if (this.zOh != null) {
      this.zOh.dead();
    }
    if (this.zOi != null) {
      this.zOi.dead();
    }
    Object localObject = as.gxn();
    if (localObject != null) {
      ((j)localObject).remove(this.zOq);
    }
    bh.bCz();
    com.tencent.mm.model.c.bzD().a(this.zOk);
    localObject = new gi();
    ((gi)localObject).hGu.op = 2;
    if (!((gi)localObject).publish()) {
      Log.e("MicroMsg.SubCoreExt", "ExtAgentLifeEvent event fail in onAccountRelease");
    }
    localObject = p.iHP();
    if (bh.baz())
    {
      p.XRc = false;
      as.gxq().b(14, (y)localObject);
    }
    bh.bCz();
    com.tencent.mm.model.c.bzA().remove(this.yta);
    com.tencent.mm.plugin.ext.qrcode.c.dOn();
    AppMethodBeat.o(24355);
  }
  
  public void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(24352);
    dNV();
    AppMethodBeat.o(24352);
  }
  
  public static class ExtOpenApiCallEventListener
    extends IListener<gq>
  {
    public ExtOpenApiCallEventListener()
    {
      super();
      AppMethodBeat.i(161360);
      this.__eventId = gq.class.getName().hashCode();
      AppMethodBeat.o(161360);
    }
  }
  
  public static class ExtStepCountEventListener
    extends IListener<gw>
  {
    public ExtStepCountEventListener()
    {
      super();
      AppMethodBeat.i(161361);
      this.__eventId = gw.class.getName().hashCode();
      AppMethodBeat.o(161361);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.SubCoreExt
 * JD-Core Version:    0.7.0.1
 */