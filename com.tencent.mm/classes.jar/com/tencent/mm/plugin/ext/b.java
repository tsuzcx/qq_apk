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
import com.tencent.mm.g.a.fj;
import com.tencent.mm.g.a.fr;
import com.tencent.mm.g.a.fx;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.pluginsdk.model.k.b;
import com.tencent.mm.protocal.protobuf.bfr;
import com.tencent.mm.protocal.protobuf.dog;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.cd;
import com.tencent.mm.storage.ce;
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
  private static boolean qsS;
  n.b pAm;
  private final long qsB;
  private ae qsC;
  private bt qsD;
  private ce qsE;
  private com.tencent.mm.plugin.ext.a.a qsF;
  private a qsG;
  private b qsH;
  private HashMap<String, Integer> qsI;
  private h.a qsJ;
  com.tencent.mm.pluginsdk.model.k.a qsK;
  private ao qsL;
  private LinkedList<String> qsM;
  private final long qsN;
  private ao qsO;
  private com.tencent.mm.sdk.e.k.a qsP;
  private boolean qsQ;
  private boolean qsR;
  
  static
  {
    AppMethodBeat.i(24363);
    int i = com.tencent.mm.compatible.deviceinfo.m.XE();
    try
    {
      if (!Build.CPU_ABI.contains("armeabi")) {
        ac.e("hakon SilkCodec", "x86 machines not supported.");
      }
      for (;;)
      {
        HashMap localHashMap = new HashMap();
        baseDBFactories = localHashMap;
        localHashMap.put(Integer.valueOf("OPENMSGLISTENER_TABLE".hashCode()), new h.b()
        {
          public final String[] getSQLs()
          {
            return bt.SQL_CREATE;
          }
        });
        baseDBFactories.put(Integer.valueOf("USEROPENIDINAPP_TABLE".hashCode()), new h.b()
        {
          public final String[] getSQLs()
          {
            return ce.SQL_CREATE;
          }
        });
        baseDBFactories.put(Integer.valueOf("WXATOKENINFO_TABLE".hashCode()), new b.5());
        qsS = false;
        AppMethodBeat.o(24363);
        return;
        if ((i & 0x400) == 0) {
          break;
        }
        b.class.getClassLoader();
        com.tencent.mm.compatible.util.j.sC("wechatvoicesilk");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("hakon SilkCodec", "load library failed!");
        continue;
        if ((i & 0x200) != 0) {
          ac.e("hakon SilkCodec", "load library failed! silk don't support armv6!!!!");
        } else {
          ac.e("hakon SilkCodec", "load library failed! silk don't support armv5!!!!");
        }
      }
    }
  }
  
  public b()
  {
    AppMethodBeat.i(24346);
    this.qsB = 1600L;
    this.qsI = new HashMap();
    this.qsJ = new h.a()
    {
      public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.h arg1, h.c paramAnonymousc)
      {
        AppMethodBeat.i(24338);
        if ((??? == null) || (paramAnonymousc == null) || (paramAnonymousc.gtT == null))
        {
          ac.e("MicroMsg.SubCoreExt", "onMsgChange, wrong args");
          AppMethodBeat.o(24338);
          return;
        }
        for (;;)
        {
          int i;
          synchronized (b.this)
          {
            Object localObject = b.cms().fcr();
            if (localObject == null)
            {
              ac.i("MicroMsg.SubCoreExt", "onMsgChange onNotifyChange getValidOpenMsgListener cu == null");
              AppMethodBeat.o(24338);
              return;
            }
            ac.d("MicroMsg.SubCoreExt", "onMsgChange onNotifyChange listener count = %s", new Object[] { Integer.valueOf(((Cursor)localObject).getCount()) });
            if (((Cursor)localObject).getCount() <= 0)
            {
              ((Cursor)localObject).close();
              ac.i("MicroMsg.SubCoreExt", "onMsgChange onNotifyChange cu.getCount() <= 0");
              AppMethodBeat.o(24338);
              return;
            }
            ((Cursor)localObject).close();
            i = 0;
            if (i < paramAnonymousc.gtT.size())
            {
              localObject = (bo)paramAnonymousc.gtT.get(i);
              if ((localObject == null) || (((dy)localObject).field_isSend != 0) || (((dy)localObject).field_status == 4) || (((bo)localObject).getType() == 9999) || (((bo)localObject).getType() == 10000) || (w.xs(((dy)localObject).field_talker)) || (w.xw(((dy)localObject).field_talker))) {
                break label412;
              }
              Integer localInteger = (Integer)b.a(b.this).get(((dy)localObject).field_talker);
              if (localInteger == null)
              {
                b.a(b.this).put(((dy)localObject).field_talker, Integer.valueOf(1));
                ac.d("MicroMsg.SubCoreExt", "onMsgChange %s, %d", new Object[] { ((dy)localObject).field_talker, Integer.valueOf(1) });
              }
              else
              {
                b.a(b.this).put(((dy)localObject).field_talker, Integer.valueOf(localInteger.intValue() + 1));
                ac.d("MicroMsg.SubCoreExt", "onMsgChange %s, %d", new Object[] { ((dy)localObject).field_talker, Integer.valueOf(localInteger.intValue() + 1) });
              }
            }
          }
          if (b.a(b.this).size() > 0) {
            b.this.cmy();
          }
          for (;;)
          {
            AppMethodBeat.o(24338);
            return;
            ac.i("MicroMsg.SubCoreExt", "notifyMsgUsers.size < 1");
          }
          label412:
          i += 1;
        }
      }
    };
    this.qsK = new com.tencent.mm.pluginsdk.model.k.a()
    {
      public final void a(com.tencent.mm.pluginsdk.model.n paramAnonymousn)
      {
        AppMethodBeat.i(24339);
        if (paramAnonymousn == null)
        {
          AppMethodBeat.o(24339);
          return;
        }
        Iterator localIterator = paramAnonymousn.eKK().EUV.iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          Object localObject1 = (dog)localIterator.next();
          ac.v("MicroMsg.SubCoreExt", "AppId[%s], UserName[%s], Xml[%s]", new Object[] { paramAnonymousn.kac, ((dog)localObject1).ncR, ((dog)localObject1).FWe });
          if ((!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(((dog)localObject1).ncR)) && (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(((dog)localObject1).FWe)))
          {
            com.tencent.mm.model.az.ayM();
            Object localObject2 = com.tencent.mm.model.c.awB().aNr(((dog)localObject1).ncR);
            if ((localObject2 == null) || ((int)((com.tencent.mm.n.b)localObject2).fLJ <= 0))
            {
              ac.e("MicroMsg.SubCoreExt", "contact is null");
            }
            else if (((com.tencent.mm.storage.ai)localObject2).fad())
            {
              ac.w("MicroMsg.SubCoreExt", "isBizContact");
            }
            else
            {
              localObject2 = com.tencent.mm.pluginsdk.model.k.aFY(((dog)localObject1).FWe);
              if ((localObject2 != null) && (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(((k.b)localObject2).Dhd)))
              {
                ac.v("MicroMsg.SubCoreExt", "AppId[%s], openId[%s]", new Object[] { paramAnonymousn.kac, ((k.b)localObject2).Dhd });
                localObject1 = new cd(paramAnonymousn.kac, ((dog)localObject1).ncR, ((k.b)localObject2).Dhd);
                b.cmt().a((cd)localObject1);
                i = 1;
              }
            }
          }
        }
        if (i != 0) {
          b.this.cmy();
        }
        AppMethodBeat.o(24339);
      }
    };
    this.qsL = new ao(Looper.getMainLooper())
    {
      @JgMethodChecked(author=20, fComment="checked", lastDate="20140514", reviewer=20, vComment={com.jg.EType.INTENTCHECK})
      public final void handleMessage(Message arg1)
      {
        AppMethodBeat.i(24341);
        if ((com.tencent.mm.sdk.platformtools.ai.getContext() == null) || (!com.tencent.mm.model.az.agM()))
        {
          ac.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler wrong status");
          AppMethodBeat.o(24341);
          return;
        }
        Cursor localCursor = b.cms().fcr();
        if (localCursor == null)
        {
          ac.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler getValidOpenMsgListener cu == null");
          AppMethodBeat.o(24341);
          return;
        }
        ac.d("MicroMsg.SubCoreExt", "notifyMsgChangeHandler listener count = %s", new Object[] { Integer.valueOf(localCursor.getCount()) });
        if (localCursor.getCount() <= 0)
        {
          localCursor.close();
          ac.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler cu.getCount() <= 0");
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
              ac.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler waitForNotify.entrySet() == null");
              AppMethodBeat.o(24341);
              return;
            }
          }
          localbs = new com.tencent.mm.storage.bs();
        }
        catch (Exception ???)
        {
          ac.e("MicroMsg.SubCoreExt", "Exception in handleMessage, %s", new Object[] { ???.getMessage() });
          if (localCursor != null) {
            localCursor.close();
          }
          AppMethodBeat.o(24341);
          return;
        }
        com.tencent.mm.storage.bs localbs;
        localbs.convertFrom(localCursor);
        if ((com.tencent.mm.sdk.platformtools.bs.isNullOrNil(localbs.field_appId)) || (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(localbs.field_packageName)))
        {
          ac.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler wrong msgListener, appid = %s, package = %s", new Object[] { localbs.field_appId, localbs.field_packageName });
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
            localObject3 = com.tencent.mm.sdk.platformtools.bs.nullAsNil((String)???.getKey());
            localObject4 = (Integer)???.getValue();
            com.tencent.mm.model.az.ayM();
            ??? = com.tencent.mm.model.c.awG().aNI((String)localObject3);
            if ((??? != null) && (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(???.field_username)) && (???.field_unReadCount <= 0))
            {
              ac.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler no unread in conversation");
            }
            else if ((!w.xs((String)localObject3)) && (!w.sQ((String)localObject3)) && (!w.wH((String)localObject3)))
            {
              Object localObject5 = b.cmt();
              ??? = localbs.field_appId;
              if ((??? == null) || (???.length() <= 0) || (localObject3 == null)) {
                break label1139;
              }
              if (((String)localObject3).length() <= 0)
              {
                break label1139;
                label499:
                if ((??? != null) && (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(???.field_openId)) && (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(???.field_username))) {
                  break label715;
                }
                ac.d("MicroMsg.SubCoreExt", "notifyMsgChangeHandler openId is null, go get it.");
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
                localObject5 = ((ce)localObject5).db.a("UserOpenIdInApp", null, "appId=? and username=? ", new String[] { com.tencent.mm.sdk.platformtools.bs.aLh(???), com.tencent.mm.sdk.platformtools.bs.aLh((String)localObject3) }, null, null, null, 2);
                if (!((Cursor)localObject5).moveToFirst())
                {
                  ac.w("MicroMsg.scanner.UserOpenIdInAppStorage", "get null with appId-%s, username-%s:", new Object[] { ???, localObject3 });
                  ((Cursor)localObject5).close();
                  ??? = null;
                  break label499;
                }
                ??? = new cd();
                ???.convertFrom((Cursor)localObject5);
                ((Cursor)localObject5).close();
                break label499;
                label686:
                b.a(b.this).put(localObject3, Integer.valueOf(???.intValue() + ((Integer)localObject4).intValue()));
              }
              label715:
              ac.v("MicroMsg.SubCoreExt", "username[%s], appId[%s], openId[%s]", new Object[] { ???.field_username, ???.field_appId, ???.field_openId });
              localArrayList.add(String.format("%s,%s,%s", new Object[] { ???.field_openId, localObject4, Long.valueOf(System.currentTimeMillis() - 1600L) }));
            }
          }
          if (localLinkedList.size() > 0)
          {
            ac.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler doGetGetUserInfoInApp");
            localObject4 = b.this;
            ??? = localbs.field_appId;
            if ((!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(???)) && (localLinkedList.size() > 0))
            {
              localObject2 = com.tencent.mm.pluginsdk.model.k.eKA();
              localObject3 = com.tencent.mm.sdk.platformtools.ai.getContext();
              localObject4 = ((b)localObject4).qsK;
              ac.d("MicroMsg.GetUserInfoInAppLogic", "getGetUserInfoInApp");
              if (!com.tencent.mm.pluginsdk.model.k.Dha) {
                ((com.tencent.mm.pluginsdk.model.k)localObject2).eKB();
              }
              if ((com.tencent.mm.model.az.agM()) && (localObject3 != null))
              {
                if (localLinkedList.size() != 0) {
                  break label929;
                }
                ac.d("MicroMsg.GetUserInfoInAppLogic", "userNameList empty");
              }
            }
          }
          while (localArrayList.size() <= 0)
          {
            localCursor.close();
            ac.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler userDataList.size() <= 0");
            AppMethodBeat.o(24341);
            return;
            label929:
            ((com.tencent.mm.pluginsdk.model.k)localObject2).Dhc = ((com.tencent.mm.pluginsdk.model.k.a)localObject4);
            ??? = new com.tencent.mm.pluginsdk.model.n(???, localLinkedList);
            com.tencent.mm.pluginsdk.model.app.ap.dnB();
            com.tencent.mm.pluginsdk.model.app.e.a(14, ???);
          }
          if (localbs.field_status != 1) {
            break label1144;
          }
        }
        label1139:
        label1144:
        for (int i = 1;; i = 0)
        {
          if (i == 0)
          {
            ac.w("MicroMsg.SubCoreExt", "invalid msgListener, appid = %s, package = %s", new Object[] { localbs.field_appId, localbs.field_packageName });
            break label311;
          }
          if ((com.tencent.mm.sdk.platformtools.bs.isNullOrNil(localbs.field_appId)) || (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(localbs.field_packageName))) {
            break label311;
          }
          ac.i("MicroMsg.SubCoreExt", "notify app, appId = %s, package = %s", new Object[] { localbs.field_appId, localbs.field_packageName });
          ??? = new Intent("com.tencent.mm.plugin.openapi.Intent.ACTION_NOTIFY_MSG");
          ???.addCategory("com.tencent.mm.category." + localbs.field_packageName);
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
          com.tencent.mm.sdk.platformtools.ai.getContext().sendBroadcast(???);
          break label311;
          break;
          ??? = null;
          break label499;
        }
      }
    };
    this.qsM = new LinkedList();
    this.qsN = 60L;
    this.qsO = new ao(Looper.getMainLooper())
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
              localObject2 = com.tencent.mm.pluginsdk.model.app.h.k((String)localObject1, false, false);
              if (localObject2 == null)
              {
                ac.w("MicroMsg.SubCoreExt", "appInfo is null");
                continue;
              }
              if (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId)) {
                break label137;
              }
            }
            catch (Exception paramAnonymousMessage)
            {
              ac.e("MicroMsg.SubCoreExt", "exception in onAppInfoStgChange, %s", new Object[] { paramAnonymousMessage.getMessage() });
              AppMethodBeat.o(24342);
              return;
            }
            ac.w("MicroMsg.SubCoreExt", "appId is null");
            continue;
            ac.d("MicroMsg.SubCoreExt", "onAppInfoStgChange, notify[%s], appFlag[%s], id[%s]", new Object[] { localObject1, Integer.valueOf(((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appInfoFlag), ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId });
            localObject1 = b.cms().aOv(((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId);
            if (localObject1 != null) {
              break;
            }
            ac.w("MicroMsg.SubCoreExt", "openMsgListener is null, appId = %s", new Object[] { ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId });
          }
          if (!com.tencent.mm.pluginsdk.model.app.h.n((com.tencent.mm.pluginsdk.model.app.g)localObject2)) {
            break;
          }
        } while (((com.tencent.mm.storage.bs)localObject1).field_status == 1);
        bt localbt;
        for (((com.tencent.mm.storage.bs)localObject1).field_status = 1;; ((com.tencent.mm.storage.bs)localObject1).field_status = 0)
        {
          localbt = b.cms();
          localObject2 = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId;
          if ((!com.tencent.mm.sdk.platformtools.bs.isNullOrNil((String)localObject2)) && (localObject1 != null) && (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(((com.tencent.mm.storage.bs)localObject1).field_appId))) {
            break label289;
          }
          ac.w("MicroMsg.OpenMsgListenerStorage", "wrong argument");
          break;
          if (((com.tencent.mm.storage.bs)localObject1).field_status == 0) {
            break;
          }
        }
        label289:
        ContentValues localContentValues = ((com.tencent.mm.storage.bs)localObject1).convertTo();
        if (localContentValues.size() > 0) {}
        for (int i = localbt.db.update("OpenMsgListener", localContentValues, "appId=?", new String[] { com.tencent.mm.sdk.platformtools.bs.aLh((String)localObject2) });; i = 0)
        {
          ac.d("MicroMsg.OpenMsgListenerStorage", "update: id=%s, ret=%s ", new Object[] { ((com.tencent.mm.storage.bs)localObject1).field_appId, Integer.valueOf(i) });
          break;
          label360:
          b.b(b.this).clear();
          AppMethodBeat.o(24342);
          return;
        }
      }
    };
    this.qsP = new com.tencent.mm.sdk.e.k.a()
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
    this.pAm = new n.b()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.sdk.e.n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(24335);
        if ((paramAnonymousObject == null) || (!(paramAnonymousObject instanceof String)))
        {
          ac.d("MicroMsg.SubCoreExt", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousn, paramAnonymousObject });
          AppMethodBeat.o(24335);
          return;
        }
        if (!com.tencent.mm.model.az.agM())
        {
          ac.i("MicroMsg.SubCoreExt", "onNotifyChange acc not ready");
          AppMethodBeat.o(24335);
          return;
        }
        com.tencent.mm.model.az.ayM();
        if (paramAnonymousn == com.tencent.mm.model.c.awB()) {
          b.d(b.this);
        }
        AppMethodBeat.o(24335);
      }
    };
    this.qsQ = true;
    this.qsR = false;
    AppMethodBeat.o(24346);
  }
  
  public static b cmq()
  {
    AppMethodBeat.i(24347);
    com.tencent.mm.model.az.ayG();
    b localb2 = (b)bz.yz("plugin.ext");
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      com.tencent.mm.model.az.ayG().a("plugin.ext", localb1);
    }
    AppMethodBeat.o(24347);
    return localb1;
  }
  
  public static ae cmr()
  {
    AppMethodBeat.i(24348);
    com.tencent.mm.kernel.g.agP().afT();
    if (cmq().qsC == null)
    {
      localObject = cmq();
      com.tencent.mm.model.az.ayM();
      ((b)localObject).qsC = new ae(com.tencent.mm.model.c.agw());
    }
    Object localObject = cmq().qsC;
    AppMethodBeat.o(24348);
    return localObject;
  }
  
  public static bt cms()
  {
    AppMethodBeat.i(24349);
    com.tencent.mm.kernel.g.agP().afT();
    if (cmq().qsD == null)
    {
      localObject = cmq();
      com.tencent.mm.model.az.ayM();
      ((b)localObject).qsD = new bt(com.tencent.mm.model.c.agw());
    }
    Object localObject = cmq().qsD;
    AppMethodBeat.o(24349);
    return localObject;
  }
  
  public static ce cmt()
  {
    AppMethodBeat.i(24350);
    com.tencent.mm.kernel.g.agP().afT();
    if (cmq().qsE == null)
    {
      localObject = cmq();
      com.tencent.mm.model.az.ayM();
      ((b)localObject).qsE = new ce(com.tencent.mm.model.c.agw());
    }
    Object localObject = cmq().qsE;
    AppMethodBeat.o(24350);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.ext.a.a cmu()
  {
    AppMethodBeat.i(24351);
    com.tencent.mm.kernel.g.agP().afT();
    if (cmq().qsF == null)
    {
      localObject = cmq();
      com.tencent.mm.model.az.ayM();
      ((b)localObject).qsF = new com.tencent.mm.plugin.ext.a.a(com.tencent.mm.model.c.agw());
    }
    Object localObject = cmq().qsF;
    AppMethodBeat.o(24351);
    return localObject;
  }
  
  private static void cmv()
  {
    AppMethodBeat.i(24353);
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(com.tencent.mm.kernel.g.agR().ghC);
    if (!locale.exists()) {
      locale.mkdirs();
    }
    locale = new com.tencent.mm.vfs.e(com.tencent.mm.kernel.g.agR().ghC + "image/ext/pcm");
    if (!locale.exists()) {
      locale.mkdirs();
    }
    ac.i("MicroMsg.SubCoreExt", "summerpcm accPath[%s] [%s]", new Object[] { com.tencent.mm.kernel.g.agR().ghC, com.tencent.mm.sdk.platformtools.bs.eWi() });
    AppMethodBeat.o(24353);
  }
  
  public static String cmw()
  {
    AppMethodBeat.i(24356);
    String str = com.tencent.mm.kernel.g.agR().ghC + "image/ext/pcm";
    AppMethodBeat.o(24356);
    return str;
  }
  
  public static void cmx()
  {
    AppMethodBeat.i(24357);
    Object localObject = (String)cmr().get(ah.a.GJD, null);
    ac.i("MicroMsg.SubCoreExt", "sendSportBroadcast pkgNames = ".concat(String.valueOf(localObject)));
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
        com.tencent.mm.sdk.platformtools.ai.getContext().sendBroadcast(localIntent);
        i += 1;
      }
    }
    AppMethodBeat.o(24357);
  }
  
  private void kR(boolean paramBoolean)
  {
    AppMethodBeat.i(24361);
    if (!this.qsQ)
    {
      AppMethodBeat.o(24361);
      return;
    }
    if ((paramBoolean) && (this.qsR))
    {
      ac.i("MicroMsg.SubCoreExt", "fromStartApp and already try to init");
      AppMethodBeat.o(24361);
      return;
    }
    if ((!paramBoolean) && (!qsS))
    {
      AppMethodBeat.o(24361);
      return;
    }
    ac.i("MicroMsg.SubCoreExt", "initLocalVoiceControl,fromStartApp:%s,hasTryToInit:%s,hasCallApi:%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.qsR), Boolean.valueOf(qsS) });
    this.qsQ = false;
    com.tencent.mm.model.az.agU().m(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24336);
        Object localObject2;
        int i;
        int j;
        try
        {
          localObject2 = com.tencent.mm.m.g.ZY().getValue("VoiceRecognizeSprSoMD5");
          localObject3 = com.tencent.mm.m.g.ZY().getValue("VoiceRecognizeSprDataMD5");
          if ((localObject2 == null) || (localObject3 == null) || (q.is64BitRuntime()))
          {
            ac.i("MicroMsg.SubCoreExt", "error mMd5So:%s,  mMd5Data:%s", new Object[] { localObject2, localObject3 });
            b.e(b.this);
            AppMethodBeat.o(24336);
            return;
          }
          Object localObject1 = "/system/lib/";
          if (Build.VERSION.SDK_INT >= 24) {
            localObject1 = "/vendor/lib/";
          }
          ac.i("MicroMsg.SubCoreExt", "mMd5So:%s,  mMd5Data:%s,  mSoPath:%s", new Object[] { localObject2, localObject3, localObject1 });
          l = System.currentTimeMillis();
          Object localObject5 = com.qq.wx.voice.embed.recognizer.b.a.bLr;
          Object localObject4 = com.tencent.mm.sdk.platformtools.ai.getContext();
          localObject5 = ((com.qq.wx.voice.embed.recognizer.b)localObject5).bLq;
          if (((com.qq.wx.voice.embed.recognizer.e)localObject5).d) {
            i = 0;
          }
          for (;;)
          {
            localObject1 = com.tencent.mm.sdk.platformtools.ai.eUY();
            ac.i("MicroMsg.SubCoreExt", "checkFiles ret:%s,use time:%s", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
            if (i != 0) {
              break label700;
            }
            l = System.currentTimeMillis();
            localObject3 = new LinkedList();
            ((List)localObject3).add("tmessage");
            ((List)localObject3).add("officialaccounts");
            ((List)localObject3).add("helper_entry");
            com.tencent.mm.model.az.ayM();
            localObject2 = com.tencent.mm.model.c.awJ().alJ("@t.qq.com");
            if (localObject2 != null) {
              ((List)localObject3).add(((bu)localObject2).name);
            }
            localObject2 = new ArrayList();
            com.tencent.mm.model.az.ayM();
            localObject3 = com.tencent.mm.model.c.awB().a("@all.contact.android", null, (List)localObject3, null, true, true);
            if (localObject3 != null) {
              break;
            }
            ac.w("MicroMsg.SubCoreExt", "initLocalVoiceControl cu is null");
            b.e(b.this);
            AppMethodBeat.o(24336);
            return;
            j = ((com.qq.wx.voice.embed.recognizer.e)localObject5).bLx.checkFiles((Context)localObject4, (String)localObject1, (String)localObject2, (String)localObject3);
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
          ac.i("MicroMsg.SubCoreExt", "initLocalVoiceControl Exception:%s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(24336);
          return;
        }
        ac.i("MicroMsg.SubCoreExt", "init cusor,count:%s,use time:%s", new Object[] { Integer.valueOf(((Cursor)localObject3).getCount()), Long.valueOf(System.currentTimeMillis() - l) });
        long l = System.currentTimeMillis();
        Object localObject3 = com.qq.wx.voice.embed.recognizer.b.a.bLr.bLq;
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
            ac.i("MicroMsg.SubCoreExt", "init ret:%s,use time:%s", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
            b.e(b.this);
          }
          for (;;)
          {
            b.e(b.this);
            AppMethodBeat.o(24336);
            return;
            if (((com.qq.wx.voice.embed.recognizer.e)localObject3).e)
            {
              j = ((com.qq.wx.voice.embed.recognizer.e)localObject3).bLx.update((ArrayList)localObject2);
              i = j;
              if (j < 0) {
                break;
              }
              break label741;
            }
            j = ((com.qq.wx.voice.embed.recognizer.e)localObject3).bLx.init((ArrayList)localObject2);
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
  
  public static com.tencent.mm.storage.ai tj(long paramLong)
  {
    AppMethodBeat.i(24358);
    if ((com.tencent.mm.model.az.agM()) && (paramLong > 0L))
    {
      com.tencent.mm.model.az.ayM();
      com.tencent.mm.storage.ai localai = com.tencent.mm.model.c.awB().AO(paramLong);
      AppMethodBeat.o(24358);
      return localai;
    }
    AppMethodBeat.o(24358);
    return null;
  }
  
  public static void tk(long paramLong)
  {
    AppMethodBeat.i(24359);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(24359);
      return;
    }
    try
    {
      com.tencent.mm.model.az.ayM();
      if (com.tencent.mm.model.c.awD().vS(paramLong))
      {
        com.tencent.mm.model.az.ayM();
        com.tencent.mm.plugin.messenger.foundation.a.a.h localh = com.tencent.mm.model.c.awD();
        com.tencent.mm.model.az.ayM();
        localh.aq(com.tencent.mm.model.c.awD().vP(paramLong));
        AppMethodBeat.o(24359);
        return;
      }
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.SubCoreExt", localException.getMessage());
      ac.printErrStackTrace("MicroMsg.SubCoreExt", localException, "", new Object[0]);
      AppMethodBeat.o(24359);
      return;
    }
    ac.e("MicroMsg.SubCoreExt", "msgId is out of range, ".concat(String.valueOf(paramLong)));
    AppMethodBeat.o(24359);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public final void cmy()
  {
    AppMethodBeat.i(24360);
    this.qsL.removeMessages(0);
    this.qsL.sendEmptyMessageDelayed(0, 1600L);
    AppMethodBeat.o(24360);
  }
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(24354);
    Object localObject = new fj();
    ((fj)localObject).dfb.op = 1;
    if (!com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject)) {
      ac.e("MicroMsg.SubCoreExt", "ExtAgentLifeEvent event fail in onAccountPostReset");
    }
    com.tencent.mm.pluginsdk.model.k.eKA().eKB();
    com.tencent.mm.model.az.ayM();
    com.tencent.mm.model.c.awD().a(this.qsJ, null);
    if (this.qsG == null) {
      this.qsG = new a();
    }
    com.tencent.mm.sdk.b.a.GpY.c(this.qsG);
    if (this.qsH == null) {
      this.qsH = new b();
    }
    com.tencent.mm.sdk.b.a.GpY.c(this.qsH);
    localObject = com.tencent.mm.pluginsdk.model.app.ap.dny();
    if (localObject != null) {
      ((com.tencent.mm.pluginsdk.model.app.j)localObject).add(this.qsP);
    }
    localObject = com.tencent.mm.sdk.platformtools.ai.eUY();
    this.qsR = ((SharedPreferences)localObject).getBoolean("hasTryToInitVoiceControlData", false);
    qsS = ((SharedPreferences)localObject).getBoolean("hasCallVoiceControlApi", false);
    ac.i("MicroMsg.SubCoreExt", "onAccountPostReset,hasTryToInit:%s,hasCallApi:%s", new Object[] { Boolean.valueOf(this.qsR), Boolean.valueOf(qsS) });
    com.tencent.mm.model.az.ayM();
    com.tencent.mm.model.c.awB().a(this.pAm);
    kR(true);
    com.tencent.mm.plugin.ext.d.c.cmM();
    cmv();
    AppMethodBeat.o(24354);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(24355);
    if (this.qsG != null) {
      com.tencent.mm.sdk.b.a.GpY.d(this.qsG);
    }
    if (this.qsH != null) {
      com.tencent.mm.sdk.b.a.GpY.d(this.qsH);
    }
    Object localObject = com.tencent.mm.pluginsdk.model.app.ap.dny();
    if (localObject != null) {
      ((com.tencent.mm.pluginsdk.model.app.j)localObject).remove(this.qsP);
    }
    com.tencent.mm.model.az.ayM();
    com.tencent.mm.model.c.awD().a(this.qsJ);
    localObject = new fj();
    ((fj)localObject).dfb.op = 2;
    if (!com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject)) {
      ac.e("MicroMsg.SubCoreExt", "ExtAgentLifeEvent event fail in onAccountRelease");
    }
    localObject = com.tencent.mm.pluginsdk.model.k.eKA();
    if (com.tencent.mm.model.az.agM())
    {
      com.tencent.mm.pluginsdk.model.k.Dha = false;
      com.tencent.mm.pluginsdk.model.app.ap.dnB().b(14, (u)localObject);
    }
    com.tencent.mm.model.az.ayM();
    com.tencent.mm.model.c.awB().b(this.pAm);
    com.tencent.mm.plugin.ext.d.c.cmN();
    AppMethodBeat.o(24355);
  }
  
  public void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(24352);
    cmv();
    AppMethodBeat.o(24352);
  }
  
  public static final class a
    extends com.tencent.mm.sdk.b.c<fr>
  {
    public a()
    {
      AppMethodBeat.i(161360);
      this.__eventId = fr.class.getName().hashCode();
      AppMethodBeat.o(161360);
    }
  }
  
  public static final class b
    extends com.tencent.mm.sdk.b.c<fx>
  {
    public b()
    {
      super();
      AppMethodBeat.i(161361);
      this.__eventId = fx.class.getName().hashCode();
      AppMethodBeat.o(161361);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.b
 * JD-Core Version:    0.7.0.1
 */