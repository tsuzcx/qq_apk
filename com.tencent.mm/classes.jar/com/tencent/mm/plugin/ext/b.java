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
import com.tencent.mm.g.a.fn;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.g.a.gb;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.pluginsdk.model.k.b;
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.protocal.protobuf.duu;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cb;
import com.tencent.mm.storage.ck;
import com.tencent.mm.storage.cl;
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
  implements az
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private static boolean rkM;
  n.b qkw;
  private a rkA;
  private b rkB;
  private HashMap<String, Integer> rkC;
  private i.a rkD;
  com.tencent.mm.pluginsdk.model.k.a rkE;
  private aq rkF;
  private LinkedList<String> rkG;
  private final long rkH;
  private aq rkI;
  private com.tencent.mm.sdk.e.k.a rkJ;
  private boolean rkK;
  private boolean rkL;
  private final long rkv;
  private aj rkw;
  private ca rkx;
  private cl rky;
  private com.tencent.mm.plugin.ext.a.a rkz;
  
  static
  {
    AppMethodBeat.i(24363);
    int i = com.tencent.mm.compatible.deviceinfo.m.aao();
    try
    {
      if (!Build.CPU_ABI.contains("armeabi")) {
        ae.e("hakon SilkCodec", "x86 machines not supported.");
      }
      for (;;)
      {
        HashMap localHashMap = new HashMap();
        baseDBFactories = localHashMap;
        localHashMap.put(Integer.valueOf("OPENMSGLISTENER_TABLE".hashCode()), new h.b()
        {
          public final String[] getSQLs()
          {
            return ca.SQL_CREATE;
          }
        });
        baseDBFactories.put(Integer.valueOf("USEROPENIDINAPP_TABLE".hashCode()), new h.b()
        {
          public final String[] getSQLs()
          {
            return cl.SQL_CREATE;
          }
        });
        baseDBFactories.put(Integer.valueOf("WXATOKENINFO_TABLE".hashCode()), new b.5());
        rkM = false;
        AppMethodBeat.o(24363);
        return;
        if ((i & 0x400) == 0) {
          break;
        }
        b.class.getClassLoader();
        com.tencent.mm.compatible.util.j.vN("wechatvoicesilk");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("hakon SilkCodec", "load library failed!");
        continue;
        if ((i & 0x200) != 0) {
          ae.e("hakon SilkCodec", "load library failed! silk don't support armv6!!!!");
        } else {
          ae.e("hakon SilkCodec", "load library failed! silk don't support armv5!!!!");
        }
      }
    }
  }
  
  public b()
  {
    AppMethodBeat.i(24346);
    this.rkv = 1600L;
    this.rkC = new HashMap();
    this.rkD = new i.a()
    {
      public final void a(i arg1, i.c paramAnonymousc)
      {
        AppMethodBeat.i(24338);
        if ((??? == null) || (paramAnonymousc == null) || (paramAnonymousc.gQn == null))
        {
          ae.e("MicroMsg.SubCoreExt", "onMsgChange, wrong args");
          AppMethodBeat.o(24338);
          return;
        }
        for (;;)
        {
          int i;
          synchronized (b.this)
          {
            Object localObject = b.ctz().fwz();
            if (localObject == null)
            {
              ae.i("MicroMsg.SubCoreExt", "onMsgChange onNotifyChange getValidOpenMsgListener cu == null");
              AppMethodBeat.o(24338);
              return;
            }
            ae.d("MicroMsg.SubCoreExt", "onMsgChange onNotifyChange listener count = %s", new Object[] { Integer.valueOf(((Cursor)localObject).getCount()) });
            if (((Cursor)localObject).getCount() <= 0)
            {
              ((Cursor)localObject).close();
              ae.i("MicroMsg.SubCoreExt", "onMsgChange onNotifyChange cu.getCount() <= 0");
              AppMethodBeat.o(24338);
              return;
            }
            ((Cursor)localObject).close();
            i = 0;
            if (i < paramAnonymousc.gQn.size())
            {
              localObject = (bv)paramAnonymousc.gQn.get(i);
              if ((localObject == null) || (((ei)localObject).field_isSend != 0) || (((ei)localObject).field_status == 4) || (((bv)localObject).getType() == 9999) || (((bv)localObject).getType() == 10000) || (x.Ba(((ei)localObject).field_talker)) || (x.Be(((ei)localObject).field_talker))) {
                break label412;
              }
              Integer localInteger = (Integer)b.a(b.this).get(((ei)localObject).field_talker);
              if (localInteger == null)
              {
                b.a(b.this).put(((ei)localObject).field_talker, Integer.valueOf(1));
                ae.d("MicroMsg.SubCoreExt", "onMsgChange %s, %d", new Object[] { ((ei)localObject).field_talker, Integer.valueOf(1) });
              }
              else
              {
                b.a(b.this).put(((ei)localObject).field_talker, Integer.valueOf(localInteger.intValue() + 1));
                ae.d("MicroMsg.SubCoreExt", "onMsgChange %s, %d", new Object[] { ((ei)localObject).field_talker, Integer.valueOf(localInteger.intValue() + 1) });
              }
            }
          }
          if (b.a(b.this).size() > 0) {
            b.this.ctF();
          }
          for (;;)
          {
            AppMethodBeat.o(24338);
            return;
            ae.i("MicroMsg.SubCoreExt", "notifyMsgUsers.size < 1");
          }
          label412:
          i += 1;
        }
      }
    };
    this.rkE = new com.tencent.mm.pluginsdk.model.k.a()
    {
      public final void a(com.tencent.mm.pluginsdk.model.n paramAnonymousn)
      {
        AppMethodBeat.i(24339);
        if (paramAnonymousn == null)
        {
          AppMethodBeat.o(24339);
          return;
        }
        Iterator localIterator = paramAnonymousn.fds().GXV.iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          Object localObject1 = (duu)localIterator.next();
          ae.v("MicroMsg.SubCoreExt", "AppId[%s], UserName[%s], Xml[%s]", new Object[] { paramAnonymousn.kxO, ((duu)localObject1).nIJ, ((duu)localObject1).IaH });
          if ((!bu.isNullOrNil(((duu)localObject1).nIJ)) && (!bu.isNullOrNil(((duu)localObject1).IaH)))
          {
            bc.aCg();
            Object localObject2 = com.tencent.mm.model.c.azF().aUK(((duu)localObject1).nIJ);
            if ((localObject2 == null) || ((int)((com.tencent.mm.contact.c)localObject2).ght <= 0))
            {
              ae.e("MicroMsg.SubCoreExt", "contact is null");
            }
            else if (((an)localObject2).fug())
            {
              ae.w("MicroMsg.SubCoreExt", "isBizContact");
            }
            else
            {
              localObject2 = com.tencent.mm.pluginsdk.model.k.aMU(((duu)localObject1).IaH);
              if ((localObject2 != null) && (!bu.isNullOrNil(((k.b)localObject2).Fel)))
              {
                ae.v("MicroMsg.SubCoreExt", "AppId[%s], openId[%s]", new Object[] { paramAnonymousn.kxO, ((k.b)localObject2).Fel });
                localObject1 = new ck(paramAnonymousn.kxO, ((duu)localObject1).nIJ, ((k.b)localObject2).Fel);
                b.ctA().a((ck)localObject1);
                i = 1;
              }
            }
          }
        }
        if (i != 0) {
          b.this.ctF();
        }
        AppMethodBeat.o(24339);
      }
    };
    this.rkF = new aq(Looper.getMainLooper())
    {
      @JgMethodChecked(author=20, fComment="checked", lastDate="20140514", reviewer=20, vComment={com.jg.EType.INTENTCHECK})
      public final void handleMessage(Message arg1)
      {
        AppMethodBeat.i(24341);
        if ((ak.getContext() == null) || (!bc.ajM()))
        {
          ae.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler wrong status");
          AppMethodBeat.o(24341);
          return;
        }
        Cursor localCursor = b.ctz().fwz();
        if (localCursor == null)
        {
          ae.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler getValidOpenMsgListener cu == null");
          AppMethodBeat.o(24341);
          return;
        }
        ae.d("MicroMsg.SubCoreExt", "notifyMsgChangeHandler listener count = %s", new Object[] { Integer.valueOf(localCursor.getCount()) });
        if (localCursor.getCount() <= 0)
        {
          localCursor.close();
          ae.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler cu.getCount() <= 0");
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
              ae.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler waitForNotify.entrySet() == null");
              AppMethodBeat.o(24341);
              return;
            }
          }
          localbz = new bz();
        }
        catch (Exception ???)
        {
          ae.e("MicroMsg.SubCoreExt", "Exception in handleMessage, %s", new Object[] { ???.getMessage() });
          if (localCursor != null) {
            localCursor.close();
          }
          AppMethodBeat.o(24341);
          return;
        }
        bz localbz;
        localbz.convertFrom(localCursor);
        if ((bu.isNullOrNil(localbz.field_appId)) || (bu.isNullOrNil(localbz.field_packageName)))
        {
          ae.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler wrong msgListener, appid = %s, package = %s", new Object[] { localbz.field_appId, localbz.field_packageName });
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
            localObject3 = bu.nullAsNil((String)???.getKey());
            localObject4 = (Integer)???.getValue();
            bc.aCg();
            ??? = com.tencent.mm.model.c.azL().aVa((String)localObject3);
            if ((??? != null) && (!bu.isNullOrNil(???.field_username)) && (???.field_unReadCount <= 0))
            {
              ae.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler no unread in conversation");
            }
            else if ((!x.Ba((String)localObject3)) && (!x.wb((String)localObject3)) && (!x.Ao((String)localObject3)))
            {
              Object localObject5 = b.ctA();
              ??? = localbz.field_appId;
              if ((??? == null) || (???.length() <= 0) || (localObject3 == null)) {
                break label1139;
              }
              if (((String)localObject3).length() <= 0)
              {
                break label1139;
                label499:
                if ((??? != null) && (!bu.isNullOrNil(???.field_openId)) && (!bu.isNullOrNil(???.field_username))) {
                  break label715;
                }
                ae.d("MicroMsg.SubCoreExt", "notifyMsgChangeHandler openId is null, go get it.");
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
                localObject5 = ((cl)localObject5).db.a("UserOpenIdInApp", null, "appId=? and username=? ", new String[] { bu.aSk(???), bu.aSk((String)localObject3) }, null, null, null, 2);
                if (!((Cursor)localObject5).moveToFirst())
                {
                  ae.w("MicroMsg.scanner.UserOpenIdInAppStorage", "get null with appId-%s, username-%s:", new Object[] { ???, localObject3 });
                  ((Cursor)localObject5).close();
                  ??? = null;
                  break label499;
                }
                ??? = new ck();
                ???.convertFrom((Cursor)localObject5);
                ((Cursor)localObject5).close();
                break label499;
                label686:
                b.a(b.this).put(localObject3, Integer.valueOf(???.intValue() + ((Integer)localObject4).intValue()));
              }
              label715:
              ae.v("MicroMsg.SubCoreExt", "username[%s], appId[%s], openId[%s]", new Object[] { ???.field_username, ???.field_appId, ???.field_openId });
              localArrayList.add(String.format("%s,%s,%s", new Object[] { ???.field_openId, localObject4, Long.valueOf(System.currentTimeMillis() - 1600L) }));
            }
          }
          if (localLinkedList.size() > 0)
          {
            ae.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler doGetGetUserInfoInApp");
            localObject4 = b.this;
            ??? = localbz.field_appId;
            if ((!bu.isNullOrNil(???)) && (localLinkedList.size() > 0))
            {
              localObject2 = com.tencent.mm.pluginsdk.model.k.fdi();
              localObject3 = ak.getContext();
              localObject4 = ((b)localObject4).rkE;
              ae.d("MicroMsg.GetUserInfoInAppLogic", "getGetUserInfoInApp");
              if (!com.tencent.mm.pluginsdk.model.k.Fei) {
                ((com.tencent.mm.pluginsdk.model.k)localObject2).fdj();
              }
              if ((bc.ajM()) && (localObject3 != null))
              {
                if (localLinkedList.size() != 0) {
                  break label929;
                }
                ae.d("MicroMsg.GetUserInfoInAppLogic", "userNameList empty");
              }
            }
          }
          while (localArrayList.size() <= 0)
          {
            localCursor.close();
            ae.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler userDataList.size() <= 0");
            AppMethodBeat.o(24341);
            return;
            label929:
            ((com.tencent.mm.pluginsdk.model.k)localObject2).Fek = ((com.tencent.mm.pluginsdk.model.k.a)localObject4);
            ??? = new com.tencent.mm.pluginsdk.model.n(???, localLinkedList);
            ao.dBj();
            com.tencent.mm.pluginsdk.model.app.e.a(14, ???);
          }
          if (localbz.field_status != 1) {
            break label1144;
          }
        }
        label1139:
        label1144:
        for (int i = 1;; i = 0)
        {
          if (i == 0)
          {
            ae.w("MicroMsg.SubCoreExt", "invalid msgListener, appid = %s, package = %s", new Object[] { localbz.field_appId, localbz.field_packageName });
            break label311;
          }
          if ((bu.isNullOrNil(localbz.field_appId)) || (bu.isNullOrNil(localbz.field_packageName))) {
            break label311;
          }
          ae.i("MicroMsg.SubCoreExt", "notify app, appId = %s, package = %s", new Object[] { localbz.field_appId, localbz.field_packageName });
          ??? = new Intent("com.tencent.mm.plugin.openapi.Intent.ACTION_NOTIFY_MSG");
          ???.addCategory("com.tencent.mm.category." + localbz.field_packageName);
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
          ak.getContext().sendBroadcast(???);
          break label311;
          break;
          ??? = null;
          break label499;
        }
      }
    };
    this.rkG = new LinkedList();
    this.rkH = 60L;
    this.rkI = new aq(Looper.getMainLooper())
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
                ae.w("MicroMsg.SubCoreExt", "appInfo is null");
                continue;
              }
              if (!bu.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId)) {
                break label137;
              }
            }
            catch (Exception paramAnonymousMessage)
            {
              ae.e("MicroMsg.SubCoreExt", "exception in onAppInfoStgChange, %s", new Object[] { paramAnonymousMessage.getMessage() });
              AppMethodBeat.o(24342);
              return;
            }
            ae.w("MicroMsg.SubCoreExt", "appId is null");
            continue;
            ae.d("MicroMsg.SubCoreExt", "onAppInfoStgChange, notify[%s], appFlag[%s], id[%s]", new Object[] { localObject1, Integer.valueOf(((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appInfoFlag), ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId });
            localObject1 = b.ctz().aVN(((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId);
            if (localObject1 != null) {
              break;
            }
            ae.w("MicroMsg.SubCoreExt", "openMsgListener is null, appId = %s", new Object[] { ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId });
          }
          if (!h.n((com.tencent.mm.pluginsdk.model.app.g)localObject2)) {
            break;
          }
        } while (((bz)localObject1).field_status == 1);
        ca localca;
        for (((bz)localObject1).field_status = 1;; ((bz)localObject1).field_status = 0)
        {
          localca = b.ctz();
          localObject2 = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId;
          if ((!bu.isNullOrNil((String)localObject2)) && (localObject1 != null) && (!bu.isNullOrNil(((bz)localObject1).field_appId))) {
            break label289;
          }
          ae.w("MicroMsg.OpenMsgListenerStorage", "wrong argument");
          break;
          if (((bz)localObject1).field_status == 0) {
            break;
          }
        }
        label289:
        ContentValues localContentValues = ((bz)localObject1).convertTo();
        if (localContentValues.size() > 0) {}
        for (int i = localca.db.update("OpenMsgListener", localContentValues, "appId=?", new String[] { bu.aSk((String)localObject2) });; i = 0)
        {
          ae.d("MicroMsg.OpenMsgListenerStorage", "update: id=%s, ret=%s ", new Object[] { ((bz)localObject1).field_appId, Integer.valueOf(i) });
          break;
          label360:
          b.b(b.this).clear();
          AppMethodBeat.o(24342);
          return;
        }
      }
    };
    this.rkJ = new com.tencent.mm.sdk.e.k.a()
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
    this.qkw = new n.b()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.sdk.e.n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(24335);
        if ((paramAnonymousObject == null) || (!(paramAnonymousObject instanceof String)))
        {
          ae.d("MicroMsg.SubCoreExt", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousn, paramAnonymousObject });
          AppMethodBeat.o(24335);
          return;
        }
        if (!bc.ajM())
        {
          ae.i("MicroMsg.SubCoreExt", "onNotifyChange acc not ready");
          AppMethodBeat.o(24335);
          return;
        }
        bc.aCg();
        if (paramAnonymousn == com.tencent.mm.model.c.azF()) {
          b.d(b.this);
        }
        AppMethodBeat.o(24335);
      }
    };
    this.rkK = true;
    this.rkL = false;
    AppMethodBeat.o(24346);
  }
  
  public static cl ctA()
  {
    AppMethodBeat.i(24350);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (ctx().rky == null)
    {
      localObject = ctx();
      bc.aCg();
      ((b)localObject).rky = new cl(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = ctx().rky;
    AppMethodBeat.o(24350);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.ext.a.a ctB()
  {
    AppMethodBeat.i(24351);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (ctx().rkz == null)
    {
      localObject = ctx();
      bc.aCg();
      ((b)localObject).rkz = new com.tencent.mm.plugin.ext.a.a(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = ctx().rkz;
    AppMethodBeat.o(24351);
    return localObject;
  }
  
  private static void ctC()
  {
    AppMethodBeat.i(24353);
    com.tencent.mm.vfs.k localk = new com.tencent.mm.vfs.k(com.tencent.mm.kernel.g.ajR().gDT);
    if (!localk.exists()) {
      localk.mkdirs();
    }
    localk = new com.tencent.mm.vfs.k(com.tencent.mm.kernel.g.ajR().gDT + "image/ext/pcm");
    if (!localk.exists()) {
      localk.mkdirs();
    }
    ae.i("MicroMsg.SubCoreExt", "summerpcm accPath[%s] [%s]", new Object[] { com.tencent.mm.kernel.g.ajR().gDT, bu.fpN() });
    AppMethodBeat.o(24353);
  }
  
  public static String ctD()
  {
    AppMethodBeat.i(24356);
    String str = com.tencent.mm.kernel.g.ajR().gDT + "image/ext/pcm";
    AppMethodBeat.o(24356);
    return str;
  }
  
  public static void ctE()
  {
    AppMethodBeat.i(24357);
    Object localObject = (String)cty().get(am.a.IQt, null);
    ae.i("MicroMsg.SubCoreExt", "sendSportBroadcast pkgNames = ".concat(String.valueOf(localObject)));
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
        ak.getContext().sendBroadcast(localIntent);
        i += 1;
      }
    }
    AppMethodBeat.o(24357);
  }
  
  public static b ctx()
  {
    AppMethodBeat.i(24347);
    bc.aCa();
    b localb2 = (b)cc.Ca("plugin.ext");
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      bc.aCa().a("plugin.ext", localb1);
    }
    AppMethodBeat.o(24347);
    return localb1;
  }
  
  public static aj cty()
  {
    AppMethodBeat.i(24348);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (ctx().rkw == null)
    {
      localObject = ctx();
      bc.aCg();
      ((b)localObject).rkw = new aj(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = ctx().rkw;
    AppMethodBeat.o(24348);
    return localObject;
  }
  
  public static ca ctz()
  {
    AppMethodBeat.i(24349);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (ctx().rkx == null)
    {
      localObject = ctx();
      bc.aCg();
      ((b)localObject).rkx = new ca(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = ctx().rkx;
    AppMethodBeat.o(24349);
    return localObject;
  }
  
  private void lk(boolean paramBoolean)
  {
    AppMethodBeat.i(24361);
    if (!this.rkK)
    {
      AppMethodBeat.o(24361);
      return;
    }
    if ((paramBoolean) && (this.rkL))
    {
      ae.i("MicroMsg.SubCoreExt", "fromStartApp and already try to init");
      AppMethodBeat.o(24361);
      return;
    }
    if ((!paramBoolean) && (!rkM))
    {
      AppMethodBeat.o(24361);
      return;
    }
    ae.i("MicroMsg.SubCoreExt", "initLocalVoiceControl,fromStartApp:%s,hasTryToInit:%s,hasCallApi:%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.rkL), Boolean.valueOf(rkM) });
    this.rkK = false;
    bc.ajU().n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24336);
        Object localObject2;
        int i;
        int j;
        try
        {
          localObject2 = com.tencent.mm.n.g.acL().getValue("VoiceRecognizeSprSoMD5");
          localObject3 = com.tencent.mm.n.g.acL().getValue("VoiceRecognizeSprDataMD5");
          if ((localObject2 == null) || (localObject3 == null) || (q.is64BitRuntime()))
          {
            ae.i("MicroMsg.SubCoreExt", "error mMd5So:%s,  mMd5Data:%s", new Object[] { localObject2, localObject3 });
            b.e(b.this);
            AppMethodBeat.o(24336);
            return;
          }
          Object localObject1 = "/system/lib/";
          if (Build.VERSION.SDK_INT >= 24) {
            localObject1 = "/vendor/lib/";
          }
          ae.i("MicroMsg.SubCoreExt", "mMd5So:%s,  mMd5Data:%s,  mSoPath:%s", new Object[] { localObject2, localObject3, localObject1 });
          l = System.currentTimeMillis();
          Object localObject5 = com.qq.wx.voice.embed.recognizer.b.a.bVE;
          Object localObject4 = ak.getContext();
          localObject5 = ((com.qq.wx.voice.embed.recognizer.b)localObject5).bVD;
          if (((com.qq.wx.voice.embed.recognizer.e)localObject5).d) {
            i = 0;
          }
          for (;;)
          {
            localObject1 = ak.fox();
            ae.i("MicroMsg.SubCoreExt", "checkFiles ret:%s,use time:%s", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
            if (i != 0) {
              break label700;
            }
            l = System.currentTimeMillis();
            localObject3 = new LinkedList();
            ((List)localObject3).add("tmessage");
            ((List)localObject3).add("officialaccounts");
            ((List)localObject3).add("helper_entry");
            bc.aCg();
            localObject2 = com.tencent.mm.model.c.azO().arD("@t.qq.com");
            if (localObject2 != null) {
              ((List)localObject3).add(((cb)localObject2).name);
            }
            localObject2 = new ArrayList();
            bc.aCg();
            localObject3 = com.tencent.mm.model.c.azF().a("@all.contact.android", null, (List)localObject3, null, true, true);
            if (localObject3 != null) {
              break;
            }
            ae.w("MicroMsg.SubCoreExt", "initLocalVoiceControl cu is null");
            b.e(b.this);
            AppMethodBeat.o(24336);
            return;
            j = ((com.qq.wx.voice.embed.recognizer.e)localObject5).bVK.checkFiles((Context)localObject4, (String)localObject1, (String)localObject2, (String)localObject3);
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
          ae.i("MicroMsg.SubCoreExt", "initLocalVoiceControl Exception:%s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(24336);
          return;
        }
        ae.i("MicroMsg.SubCoreExt", "init cusor,count:%s,use time:%s", new Object[] { Integer.valueOf(((Cursor)localObject3).getCount()), Long.valueOf(System.currentTimeMillis() - l) });
        long l = System.currentTimeMillis();
        Object localObject3 = com.qq.wx.voice.embed.recognizer.b.a.bVE.bVD;
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
            ae.i("MicroMsg.SubCoreExt", "init ret:%s,use time:%s", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
            b.e(b.this);
          }
          for (;;)
          {
            b.e(b.this);
            AppMethodBeat.o(24336);
            return;
            if (((com.qq.wx.voice.embed.recognizer.e)localObject3).e)
            {
              j = ((com.qq.wx.voice.embed.recognizer.e)localObject3).bVK.update((ArrayList)localObject2);
              i = j;
              if (j < 0) {
                break;
              }
              break label741;
            }
            j = ((com.qq.wx.voice.embed.recognizer.e)localObject3).bVK.init((ArrayList)localObject2);
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
  
  public static an vw(long paramLong)
  {
    AppMethodBeat.i(24358);
    if ((bc.ajM()) && (paramLong > 0L))
    {
      bc.aCg();
      an localan = com.tencent.mm.model.c.azF().Ed(paramLong);
      AppMethodBeat.o(24358);
      return localan;
    }
    AppMethodBeat.o(24358);
    return null;
  }
  
  public static void vx(long paramLong)
  {
    AppMethodBeat.i(24359);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(24359);
      return;
    }
    try
    {
      bc.aCg();
      if (com.tencent.mm.model.c.azI().yv(paramLong))
      {
        bc.aCg();
        i locali = com.tencent.mm.model.c.azI();
        bc.aCg();
        locali.as(com.tencent.mm.model.c.azI().ys(paramLong));
        AppMethodBeat.o(24359);
        return;
      }
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.SubCoreExt", localException.getMessage());
      ae.printErrStackTrace("MicroMsg.SubCoreExt", localException, "", new Object[0]);
      AppMethodBeat.o(24359);
      return;
    }
    ae.e("MicroMsg.SubCoreExt", "msgId is out of range, ".concat(String.valueOf(paramLong)));
    AppMethodBeat.o(24359);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public final void ctF()
  {
    AppMethodBeat.i(24360);
    this.rkF.removeMessages(0);
    this.rkF.sendEmptyMessageDelayed(0, 1600L);
    AppMethodBeat.o(24360);
  }
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(24354);
    Object localObject = new fn();
    ((fn)localObject).drC.op = 1;
    if (!com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject)) {
      ae.e("MicroMsg.SubCoreExt", "ExtAgentLifeEvent event fail in onAccountPostReset");
    }
    com.tencent.mm.pluginsdk.model.k.fdi().fdj();
    bc.aCg();
    com.tencent.mm.model.c.azI().a(this.rkD, null);
    if (this.rkA == null) {
      this.rkA = new a();
    }
    com.tencent.mm.sdk.b.a.IvT.c(this.rkA);
    if (this.rkB == null) {
      this.rkB = new b();
    }
    com.tencent.mm.sdk.b.a.IvT.c(this.rkB);
    localObject = ao.dBg();
    if (localObject != null) {
      ((com.tencent.mm.pluginsdk.model.app.j)localObject).add(this.rkJ);
    }
    localObject = ak.fox();
    this.rkL = ((SharedPreferences)localObject).getBoolean("hasTryToInitVoiceControlData", false);
    rkM = ((SharedPreferences)localObject).getBoolean("hasCallVoiceControlApi", false);
    ae.i("MicroMsg.SubCoreExt", "onAccountPostReset,hasTryToInit:%s,hasCallApi:%s", new Object[] { Boolean.valueOf(this.rkL), Boolean.valueOf(rkM) });
    bc.aCg();
    com.tencent.mm.model.c.azF().a(this.qkw);
    lk(true);
    com.tencent.mm.plugin.ext.d.c.ctT();
    ctC();
    AppMethodBeat.o(24354);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(24355);
    if (this.rkA != null) {
      com.tencent.mm.sdk.b.a.IvT.d(this.rkA);
    }
    if (this.rkB != null) {
      com.tencent.mm.sdk.b.a.IvT.d(this.rkB);
    }
    Object localObject = ao.dBg();
    if (localObject != null) {
      ((com.tencent.mm.pluginsdk.model.app.j)localObject).remove(this.rkJ);
    }
    bc.aCg();
    com.tencent.mm.model.c.azI().a(this.rkD);
    localObject = new fn();
    ((fn)localObject).drC.op = 2;
    if (!com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject)) {
      ae.e("MicroMsg.SubCoreExt", "ExtAgentLifeEvent event fail in onAccountRelease");
    }
    localObject = com.tencent.mm.pluginsdk.model.k.fdi();
    if (bc.ajM())
    {
      com.tencent.mm.pluginsdk.model.k.Fei = false;
      ao.dBj().b(14, (u)localObject);
    }
    bc.aCg();
    com.tencent.mm.model.c.azF().b(this.qkw);
    com.tencent.mm.plugin.ext.d.c.ctU();
    AppMethodBeat.o(24355);
  }
  
  public void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(24352);
    ctC();
    AppMethodBeat.o(24352);
  }
  
  public static final class a
    extends com.tencent.mm.sdk.b.c<fv>
  {
    public a()
    {
      AppMethodBeat.i(161360);
      this.__eventId = fv.class.getName().hashCode();
      AppMethodBeat.o(161360);
    }
  }
  
  public static final class b
    extends com.tencent.mm.sdk.b.c<gb>
  {
    public b()
    {
      super();
      AppMethodBeat.i(161361);
      this.__eventId = gb.class.getName().hashCode();
      AppMethodBeat.o(161361);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.b
 * JD-Core Version:    0.7.0.1
 */