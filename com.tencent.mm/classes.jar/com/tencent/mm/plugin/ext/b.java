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
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.a.fq;
import com.tencent.mm.g.a.fy;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.pluginsdk.model.l.a;
import com.tencent.mm.pluginsdk.model.l.b;
import com.tencent.mm.protocal.protobuf.bxa;
import com.tencent.mm.protocal.protobuf.eot;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ch;
import com.tencent.mm.storage.ci;
import com.tencent.mm.storage.cr;
import com.tencent.mm.storage.cs;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class b
  implements bd
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private static boolean sMs;
  MStorageEx.IOnStorageChange rBr;
  private final long sMb;
  private com.tencent.mm.storage.ao sMc;
  private ch sMd;
  private cs sMe;
  private com.tencent.mm.plugin.ext.a.a sMf;
  private a sMg;
  private b.b sMh;
  private HashMap<String, Integer> sMi;
  private i.a sMj;
  l.a sMk;
  private MMHandler sMl;
  private LinkedList<String> sMm;
  private final long sMn;
  private MMHandler sMo;
  private MStorage.IOnStorageChange sMp;
  private boolean sMq;
  private boolean sMr;
  
  static
  {
    AppMethodBeat.i(24363);
    int i = m.aon();
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
            return ch.SQL_CREATE;
          }
        });
        baseDBFactories.put(Integer.valueOf("USEROPENIDINAPP_TABLE".hashCode()), new h.b()
        {
          public final String[] getSQLs()
          {
            return cs.SQL_CREATE;
          }
        });
        baseDBFactories.put(Integer.valueOf("WXATOKENINFO_TABLE".hashCode()), new b.5());
        sMs = false;
        AppMethodBeat.o(24363);
        return;
        if ((i & 0x400) == 0) {
          break;
        }
        b.class.getClassLoader();
        com.tencent.mm.compatible.util.j.Ed("wechatvoicesilk");
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
    this.sMb = 1600L;
    this.sMi = new HashMap();
    this.sMj = new i.a()
    {
      public final void a(i arg1, i.c paramAnonymousc)
      {
        AppMethodBeat.i(24338);
        if ((??? == null) || (paramAnonymousc == null) || (paramAnonymousc.hIs == null))
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
            Object localObject = b.cSh().gEl();
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
            if (i < paramAnonymousc.hIs.size())
            {
              localObject = (ca)paramAnonymousc.hIs.get(i);
              if ((localObject == null) || (((eo)localObject).field_isSend != 0) || (((eo)localObject).field_status == 4) || (((ca)localObject).getType() == 9999) || (((ca)localObject).getType() == 10000) || (ab.JF(((eo)localObject).field_talker)) || (ab.JJ(((eo)localObject).field_talker))) {
                break label412;
              }
              Integer localInteger = (Integer)b.a(b.this).get(((eo)localObject).field_talker);
              if (localInteger == null)
              {
                b.a(b.this).put(((eo)localObject).field_talker, Integer.valueOf(1));
                Log.d("MicroMsg.SubCoreExt", "onMsgChange %s, %d", new Object[] { ((eo)localObject).field_talker, Integer.valueOf(1) });
              }
              else
              {
                b.a(b.this).put(((eo)localObject).field_talker, Integer.valueOf(localInteger.intValue() + 1));
                Log.d("MicroMsg.SubCoreExt", "onMsgChange %s, %d", new Object[] { ((eo)localObject).field_talker, Integer.valueOf(localInteger.intValue() + 1) });
              }
            }
          }
          if (b.a(b.this).size() > 0) {
            b.this.cSn();
          }
          for (;;)
          {
            AppMethodBeat.o(24338);
            return;
            Log.i("MicroMsg.SubCoreExt", "notifyMsgUsers.size < 1");
          }
          label412:
          i += 1;
        }
      }
    };
    this.sMk = new l.a()
    {
      public final void a(com.tencent.mm.pluginsdk.model.o paramAnonymouso)
      {
        AppMethodBeat.i(24339);
        if (paramAnonymouso == null)
        {
          AppMethodBeat.o(24339);
          return;
        }
        Iterator localIterator = paramAnonymouso.gmC().McK.iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          Object localObject1 = (eot)localIterator.next();
          Log.v("MicroMsg.SubCoreExt", "AppId[%s], UserName[%s], Xml[%s]", new Object[] { paramAnonymouso.appID, ((eot)localObject1).UserName, ((eot)localObject1).NmT });
          if ((!Util.isNullOrNil(((eot)localObject1).UserName)) && (!Util.isNullOrNil(((eot)localObject1).NmT)))
          {
            bg.aVF();
            Object localObject2 = com.tencent.mm.model.c.aSN().bjJ(((eot)localObject1).UserName);
            if ((localObject2 == null) || ((int)((com.tencent.mm.contact.c)localObject2).gMZ <= 0))
            {
              Log.e("MicroMsg.SubCoreExt", "contact is null");
            }
            else if (((as)localObject2).gBM())
            {
              Log.w("MicroMsg.SubCoreExt", "isBizContact");
            }
            else
            {
              localObject2 = com.tencent.mm.pluginsdk.model.l.bdq(((eot)localObject1).NmT);
              if ((localObject2 != null) && (!Util.isNullOrNil(((l.b)localObject2).JVc)))
              {
                Log.v("MicroMsg.SubCoreExt", "AppId[%s], openId[%s]", new Object[] { paramAnonymouso.appID, ((l.b)localObject2).JVc });
                localObject1 = new cr(paramAnonymouso.appID, ((eot)localObject1).UserName, ((l.b)localObject2).JVc);
                b.cSi().a((cr)localObject1);
                i = 1;
              }
            }
          }
        }
        if (i != 0) {
          b.this.cSn();
        }
        AppMethodBeat.o(24339);
      }
    };
    this.sMl = new MMHandler(Looper.getMainLooper())
    {
      @JgMethodChecked(author=20, fComment="checked", lastDate="20140514", reviewer=20, vComment={com.jg.EType.INTENTCHECK})
      public final void handleMessage(Message arg1)
      {
        AppMethodBeat.i(24341);
        if ((MMApplicationContext.getContext() == null) || (!bg.aAc()))
        {
          Log.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler wrong status");
          AppMethodBeat.o(24341);
          return;
        }
        Cursor localCursor = b.cSh().gEl();
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
          localcg = new com.tencent.mm.storage.cg();
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
        com.tencent.mm.storage.cg localcg;
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
            bg.aVF();
            ??? = com.tencent.mm.model.c.aST().bjY((String)localObject3);
            if ((??? != null) && (!Util.isNullOrNil(???.field_username)) && (???.field_unReadCount <= 0))
            {
              Log.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler no unread in conversation");
            }
            else if ((!ab.JF((String)localObject3)) && (!ab.Eq((String)localObject3)) && (!ab.IT((String)localObject3)))
            {
              Object localObject5 = b.cSi();
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
                localObject5 = ((cs)localObject5).db.query("UserOpenIdInApp", null, "appId=? and username=? ", new String[] { Util.escapeSqlValue(???), Util.escapeSqlValue((String)localObject3) }, null, null, null, 2);
                if (!((Cursor)localObject5).moveToFirst())
                {
                  Log.w("MicroMsg.scanner.UserOpenIdInAppStorage", "get null with appId-%s, username-%s:", new Object[] { ???, localObject3 });
                  ((Cursor)localObject5).close();
                  ??? = null;
                  break label499;
                }
                ??? = new cr();
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
              localObject2 = com.tencent.mm.pluginsdk.model.l.gms();
              localObject3 = MMApplicationContext.getContext();
              localObject4 = ((b)localObject4).sMk;
              Log.d("MicroMsg.GetUserInfoInAppLogic", "getGetUserInfoInApp");
              if (!com.tencent.mm.pluginsdk.model.l.JUZ) {
                ((com.tencent.mm.pluginsdk.model.l)localObject2).gmt();
              }
              if ((bg.aAc()) && (localObject3 != null))
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
            ((com.tencent.mm.pluginsdk.model.l)localObject2).JVb = ((l.a)localObject4);
            ??? = new com.tencent.mm.pluginsdk.model.o(???, localLinkedList);
            com.tencent.mm.pluginsdk.model.app.ao.eAV();
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
    this.sMm = new LinkedList();
    this.sMn = 60L;
    this.sMo = new MMHandler(Looper.getMainLooper())
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
              if (!Util.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId)) {
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
            Log.d("MicroMsg.SubCoreExt", "onAppInfoStgChange, notify[%s], appFlag[%s], id[%s]", new Object[] { localObject1, Integer.valueOf(((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appInfoFlag), ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId });
            localObject1 = b.cSh().bkL(((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId);
            if (localObject1 != null) {
              break;
            }
            Log.w("MicroMsg.SubCoreExt", "openMsgListener is null, appId = %s", new Object[] { ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId });
          }
          if (!com.tencent.mm.pluginsdk.model.app.h.o((com.tencent.mm.pluginsdk.model.app.g)localObject2)) {
            break;
          }
        } while (((com.tencent.mm.storage.cg)localObject1).field_status == 1);
        ch localch;
        for (((com.tencent.mm.storage.cg)localObject1).field_status = 1;; ((com.tencent.mm.storage.cg)localObject1).field_status = 0)
        {
          localch = b.cSh();
          localObject2 = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId;
          if ((!Util.isNullOrNil((String)localObject2)) && (localObject1 != null) && (!Util.isNullOrNil(((com.tencent.mm.storage.cg)localObject1).field_appId))) {
            break label289;
          }
          Log.w("MicroMsg.OpenMsgListenerStorage", "wrong argument");
          break;
          if (((com.tencent.mm.storage.cg)localObject1).field_status == 0) {
            break;
          }
        }
        label289:
        ContentValues localContentValues = ((com.tencent.mm.storage.cg)localObject1).convertTo();
        if (localContentValues.size() > 0) {}
        for (int i = localch.db.update("OpenMsgListener", localContentValues, "appId=?", new String[] { Util.escapeSqlValue((String)localObject2) });; i = 0)
        {
          Log.d("MicroMsg.OpenMsgListenerStorage", "update: id=%s, ret=%s ", new Object[] { ((com.tencent.mm.storage.cg)localObject1).field_appId, Integer.valueOf(i) });
          break;
          label360:
          b.b(b.this).clear();
          AppMethodBeat.o(24342);
          return;
        }
      }
    };
    this.sMp = new MStorage.IOnStorageChange()
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
    this.rBr = new b.2(this);
    this.sMq = true;
    this.sMr = false;
    AppMethodBeat.o(24346);
  }
  
  public static as DA(long paramLong)
  {
    AppMethodBeat.i(24358);
    if ((bg.aAc()) && (paramLong > 0L))
    {
      bg.aVF();
      as localas = com.tencent.mm.model.c.aSN().Nh(paramLong);
      AppMethodBeat.o(24358);
      return localas;
    }
    AppMethodBeat.o(24358);
    return null;
  }
  
  public static void DB(long paramLong)
  {
    AppMethodBeat.i(24359);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(24359);
      return;
    }
    try
    {
      bg.aVF();
      if (com.tencent.mm.model.c.aSQ().He(paramLong))
      {
        bg.aVF();
        i locali = com.tencent.mm.model.c.aSQ();
        bg.aVF();
        locali.aD(com.tencent.mm.model.c.aSQ().Hb(paramLong));
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
  
  public static b cSf()
  {
    AppMethodBeat.i(24347);
    bg.aVz();
    b localb2 = (b)com.tencent.mm.model.cg.KG("plugin.ext");
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      bg.aVz().a("plugin.ext", localb1);
    }
    AppMethodBeat.o(24347);
    return localb1;
  }
  
  public static com.tencent.mm.storage.ao cSg()
  {
    AppMethodBeat.i(24348);
    com.tencent.mm.kernel.g.aAf().azk();
    if (cSf().sMc == null)
    {
      localObject = cSf();
      bg.aVF();
      ((b)localObject).sMc = new com.tencent.mm.storage.ao(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = cSf().sMc;
    AppMethodBeat.o(24348);
    return localObject;
  }
  
  public static ch cSh()
  {
    AppMethodBeat.i(24349);
    com.tencent.mm.kernel.g.aAf().azk();
    if (cSf().sMd == null)
    {
      localObject = cSf();
      bg.aVF();
      ((b)localObject).sMd = new ch(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = cSf().sMd;
    AppMethodBeat.o(24349);
    return localObject;
  }
  
  public static cs cSi()
  {
    AppMethodBeat.i(24350);
    com.tencent.mm.kernel.g.aAf().azk();
    if (cSf().sMe == null)
    {
      localObject = cSf();
      bg.aVF();
      ((b)localObject).sMe = new cs(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = cSf().sMe;
    AppMethodBeat.o(24350);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.ext.a.a cSj()
  {
    AppMethodBeat.i(24351);
    com.tencent.mm.kernel.g.aAf().azk();
    if (cSf().sMf == null)
    {
      localObject = cSf();
      bg.aVF();
      ((b)localObject).sMf = new com.tencent.mm.plugin.ext.a.a(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = cSf().sMf;
    AppMethodBeat.o(24351);
    return localObject;
  }
  
  private static void cSk()
  {
    AppMethodBeat.i(24353);
    com.tencent.mm.vfs.o localo = new com.tencent.mm.vfs.o(com.tencent.mm.kernel.g.aAh().hqG);
    if (!localo.exists()) {
      localo.mkdirs();
    }
    localo = new com.tencent.mm.vfs.o(com.tencent.mm.kernel.g.aAh().hqG + "image/ext/pcm");
    if (!localo.exists()) {
      localo.mkdirs();
    }
    Log.i("MicroMsg.SubCoreExt", "summerpcm accPath[%s] [%s]", new Object[] { com.tencent.mm.kernel.g.aAh().hqG, Util.getStack() });
    AppMethodBeat.o(24353);
  }
  
  public static String cSl()
  {
    AppMethodBeat.i(24356);
    String str = com.tencent.mm.kernel.g.aAh().hqG + "image/ext/pcm";
    AppMethodBeat.o(24356);
    return str;
  }
  
  public static void cSm()
  {
    AppMethodBeat.i(24357);
    Object localObject = (String)cSg().get(ar.a.NYu, null);
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
  
  private void ms(boolean paramBoolean)
  {
    AppMethodBeat.i(24361);
    if (!this.sMq)
    {
      AppMethodBeat.o(24361);
      return;
    }
    if ((paramBoolean) && (this.sMr))
    {
      Log.i("MicroMsg.SubCoreExt", "fromStartApp and already try to init");
      AppMethodBeat.o(24361);
      return;
    }
    if ((!paramBoolean) && (!sMs))
    {
      AppMethodBeat.o(24361);
      return;
    }
    Log.i("MicroMsg.SubCoreExt", "initLocalVoiceControl,fromStartApp:%s,hasTryToInit:%s,hasCallApi:%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.sMr), Boolean.valueOf(sMs) });
    this.sMq = false;
    bg.aAk().postToWorkerDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24336);
        Object localObject2;
        int i;
        int j;
        try
        {
          localObject2 = com.tencent.mm.n.h.aqJ().getValue("VoiceRecognizeSprSoMD5");
          localObject3 = com.tencent.mm.n.h.aqJ().getValue("VoiceRecognizeSprDataMD5");
          if ((localObject2 == null) || (localObject3 == null) || (q.is64BitRuntime()))
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
          Object localObject5 = com.qq.wx.voice.embed.recognizer.b.a.cgn;
          Object localObject4 = MMApplicationContext.getContext();
          localObject5 = ((com.qq.wx.voice.embed.recognizer.b)localObject5).cgm;
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
            bg.aVF();
            localObject2 = com.tencent.mm.model.c.aSW().aEY("@t.qq.com");
            if (localObject2 != null) {
              ((List)localObject3).add(((ci)localObject2).name);
            }
            localObject2 = new ArrayList();
            bg.aVF();
            localObject3 = com.tencent.mm.model.c.aSN().a("@all.contact.android", null, (List)localObject3, null, true, true);
            if (localObject3 != null) {
              break;
            }
            Log.w("MicroMsg.SubCoreExt", "initLocalVoiceControl cu is null");
            b.e(b.this);
            AppMethodBeat.o(24336);
            return;
            j = ((com.qq.wx.voice.embed.recognizer.e)localObject5).cgs.checkFiles((Context)localObject4, (String)localObject1, (String)localObject2, (String)localObject3);
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
              ((ArrayList)localObject2).add(new d(((com.tencent.mm.storage.f)localObject4).field_username, ((com.tencent.mm.storage.f)localObject4).field_nickname, ((com.tencent.mm.storage.f)localObject4).field_conRemark));
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
        Object localObject3 = com.qq.wx.voice.embed.recognizer.b.a.cgn.cgm;
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
              j = ((com.qq.wx.voice.embed.recognizer.e)localObject3).cgs.update((ArrayList)localObject2);
              i = j;
              if (j < 0) {
                break;
              }
              break label741;
            }
            j = ((com.qq.wx.voice.embed.recognizer.e)localObject3).cgs.init((ArrayList)localObject2);
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
  
  public final void cSn()
  {
    AppMethodBeat.i(24360);
    this.sMl.removeMessages(0);
    this.sMl.sendEmptyMessageDelayed(0, 1600L);
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
    Object localObject = new fq();
    ((fq)localObject).dIO.op = 1;
    if (!EventCenter.instance.publish((IEvent)localObject)) {
      Log.e("MicroMsg.SubCoreExt", "ExtAgentLifeEvent event fail in onAccountPostReset");
    }
    com.tencent.mm.pluginsdk.model.l.gms().gmt();
    bg.aVF();
    com.tencent.mm.model.c.aSQ().a(this.sMj, null);
    if (this.sMg == null) {
      this.sMg = new a();
    }
    EventCenter.instance.addListener(this.sMg);
    if (this.sMh == null) {
      this.sMh = new b.b();
    }
    EventCenter.instance.addListener(this.sMh);
    localObject = com.tencent.mm.pluginsdk.model.app.ao.eAS();
    if (localObject != null) {
      ((com.tencent.mm.pluginsdk.model.app.j)localObject).add(this.sMp);
    }
    localObject = MMApplicationContext.getDefaultPreference();
    this.sMr = ((SharedPreferences)localObject).getBoolean("hasTryToInitVoiceControlData", false);
    sMs = ((SharedPreferences)localObject).getBoolean("hasCallVoiceControlApi", false);
    Log.i("MicroMsg.SubCoreExt", "onAccountPostReset,hasTryToInit:%s,hasCallApi:%s", new Object[] { Boolean.valueOf(this.sMr), Boolean.valueOf(sMs) });
    bg.aVF();
    com.tencent.mm.model.c.aSN().add(this.rBr);
    ms(true);
    com.tencent.mm.plugin.ext.d.c.cSB();
    cSk();
    AppMethodBeat.o(24354);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(24355);
    if (this.sMg != null) {
      EventCenter.instance.removeListener(this.sMg);
    }
    if (this.sMh != null) {
      EventCenter.instance.removeListener(this.sMh);
    }
    Object localObject = com.tencent.mm.pluginsdk.model.app.ao.eAS();
    if (localObject != null) {
      ((com.tencent.mm.pluginsdk.model.app.j)localObject).remove(this.sMp);
    }
    bg.aVF();
    com.tencent.mm.model.c.aSQ().a(this.sMj);
    localObject = new fq();
    ((fq)localObject).dIO.op = 2;
    if (!EventCenter.instance.publish((IEvent)localObject)) {
      Log.e("MicroMsg.SubCoreExt", "ExtAgentLifeEvent event fail in onAccountRelease");
    }
    localObject = com.tencent.mm.pluginsdk.model.l.gms();
    if (bg.aAc())
    {
      com.tencent.mm.pluginsdk.model.l.JUZ = false;
      com.tencent.mm.pluginsdk.model.app.ao.eAV().b(14, (u)localObject);
    }
    bg.aVF();
    com.tencent.mm.model.c.aSN().remove(this.rBr);
    com.tencent.mm.plugin.ext.d.c.cSC();
    AppMethodBeat.o(24355);
  }
  
  public void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(24352);
    cSk();
    AppMethodBeat.o(24352);
  }
  
  public static final class a
    extends IListener<fy>
  {
    public a()
    {
      AppMethodBeat.i(161360);
      this.__eventId = fy.class.getName().hashCode();
      AppMethodBeat.o(161360);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.b
 * JD-Core Version:    0.7.0.1
 */