package com.tencent.mm.plugin.ext;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Looper;
import android.os.Message;
import com.jg.JgMethodChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.a.a;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.i;
import com.tencent.mm.pluginsdk.model.i.a;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

final class b$7
  extends ak
{
  b$7(b paramb, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  @JgMethodChecked(author=20, fComment="checked", lastDate="20140514", reviewer=20, vComment={com.jg.EType.INTENTCHECK})
  public final void handleMessage(Message arg1)
  {
    AppMethodBeat.i(20266);
    if ((ah.getContext() == null) || (!aw.RG()))
    {
      ab.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler wrong status");
      AppMethodBeat.o(20266);
      return;
    }
    Cursor localCursor = b.bts().dyD();
    if (localCursor == null)
    {
      ab.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler getValidOpenMsgListener cu == null");
      AppMethodBeat.o(20266);
      return;
    }
    ab.d("MicroMsg.SubCoreExt", "notifyMsgChangeHandler listener count = %s", new Object[] { Integer.valueOf(localCursor.getCount()) });
    if (localCursor.getCount() <= 0)
    {
      localCursor.close();
      ab.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler cu.getCount() <= 0");
      AppMethodBeat.o(20266);
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
      synchronized (this.mdJ)
      {
        localHashMap.putAll(b.a(this.mdJ));
        b.a(this.mdJ).clear();
        localLinkedList = new LinkedList();
        localArrayList = new ArrayList();
        if (localHashMap.entrySet() == null)
        {
          ab.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler waitForNotify.entrySet() == null");
          AppMethodBeat.o(20266);
          return;
        }
      }
      localbo = new com.tencent.mm.storage.bo();
    }
    catch (Exception ???)
    {
      ab.e("MicroMsg.SubCoreExt", "Exception in handleMessage, %s", new Object[] { ???.getMessage() });
      if (localCursor != null) {
        localCursor.close();
      }
      AppMethodBeat.o(20266);
      return;
    }
    com.tencent.mm.storage.bo localbo;
    localbo.convertFrom(localCursor);
    if ((com.tencent.mm.sdk.platformtools.bo.isNullOrNil(localbo.field_appId)) || (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(localbo.field_packageName)))
    {
      ab.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler wrong msgListener, appid = %s, package = %s", new Object[] { localbo.field_appId, localbo.field_packageName });
      label311:
      if (!localCursor.moveToNext())
      {
        label320:
        localCursor.close();
        AppMethodBeat.o(20266);
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
        localObject3 = com.tencent.mm.sdk.platformtools.bo.nullAsNil((String)???.getKey());
        localObject4 = (Integer)???.getValue();
        aw.aaz();
        ??? = c.YF().arH((String)localObject3);
        if ((??? != null) && (!com.tencent.mm.sdk.platformtools.bo.isNullOrNil(???.field_username)) && (???.field_unReadCount <= 0))
        {
          ab.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler no unread in conversation");
        }
        else if ((!t.oE((String)localObject3)) && (!t.lA((String)localObject3)) && (!t.nU((String)localObject3)))
        {
          Object localObject5 = b.btt();
          ??? = localbo.field_appId;
          if ((??? == null) || (???.length() <= 0) || (localObject3 == null)) {
            break label1139;
          }
          if (((String)localObject3).length() <= 0)
          {
            break label1139;
            label499:
            if ((??? != null) && (!com.tencent.mm.sdk.platformtools.bo.isNullOrNil(???.field_openId)) && (!com.tencent.mm.sdk.platformtools.bo.isNullOrNil(???.field_username))) {
              break label715;
            }
            ab.d("MicroMsg.SubCoreExt", "notifyMsgChangeHandler openId is null, go get it.");
            ??? = (Integer)b.a(this.mdJ).get(localObject3);
            if (??? != null) {
              break label686;
            }
            b.a(this.mdJ).put(localObject3, localObject4);
          }
          for (;;)
          {
            localLinkedList.add(localObject3);
            break;
            localObject5 = ((ca)localObject5).db.a("UserOpenIdInApp", null, "appId=? and username=? ", new String[] { com.tencent.mm.sdk.platformtools.bo.wC(???), com.tencent.mm.sdk.platformtools.bo.wC((String)localObject3) }, null, null, null, 2);
            if (!((Cursor)localObject5).moveToFirst())
            {
              ab.w("MicroMsg.scanner.UserOpenIdInAppStorage", "get null with appId-%s, username-%s:", new Object[] { ???, localObject3 });
              ((Cursor)localObject5).close();
              ??? = null;
              break label499;
            }
            ??? = new bz();
            ???.convertFrom((Cursor)localObject5);
            ((Cursor)localObject5).close();
            break label499;
            label686:
            b.a(this.mdJ).put(localObject3, Integer.valueOf(???.intValue() + ((Integer)localObject4).intValue()));
          }
          label715:
          ab.v("MicroMsg.SubCoreExt", "username[%s], appId[%s], openId[%s]", new Object[] { ???.field_username, ???.field_appId, ???.field_openId });
          localArrayList.add(String.format("%s,%s,%s", new Object[] { ???.field_openId, localObject4, Long.valueOf(System.currentTimeMillis() - 1600L) }));
        }
      }
      if (localLinkedList.size() > 0)
      {
        ab.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler doGetGetUserInfoInApp");
        localObject4 = this.mdJ;
        ??? = localbo.field_appId;
        if ((!com.tencent.mm.sdk.platformtools.bo.isNullOrNil(???)) && (localLinkedList.size() > 0))
        {
          localObject2 = i.dkZ();
          localObject3 = ah.getContext();
          localObject4 = ((b)localObject4).mdA;
          ab.d("MicroMsg.GetUserInfoInAppLogic", "getGetUserInfoInApp");
          if (!i.vKi) {
            ((i)localObject2).dla();
          }
          if ((aw.RG()) && (localObject3 != null))
          {
            if (localLinkedList.size() != 0) {
              break label929;
            }
            ab.d("MicroMsg.GetUserInfoInAppLogic", "userNameList empty");
          }
        }
      }
      while (localArrayList.size() <= 0)
      {
        localCursor.close();
        ab.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler userDataList.size() <= 0");
        AppMethodBeat.o(20266);
        return;
        label929:
        ((i)localObject2).vKk = ((i.a)localObject4);
        ??? = new l(???, localLinkedList);
        al.caf();
        d.a(14, ???);
      }
      if (localbo.field_status != 1) {
        break label1144;
      }
    }
    label1139:
    label1144:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        ab.w("MicroMsg.SubCoreExt", "invalid msgListener, appid = %s, package = %s", new Object[] { localbo.field_appId, localbo.field_packageName });
        break label311;
      }
      if ((com.tencent.mm.sdk.platformtools.bo.isNullOrNil(localbo.field_appId)) || (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(localbo.field_packageName))) {
        break label311;
      }
      ab.i("MicroMsg.SubCoreExt", "notify app, appId = %s, package = %s", new Object[] { localbo.field_appId, localbo.field_packageName });
      ??? = new Intent("com.tencent.mm.plugin.openapi.Intent.ACTION_NOTIFY_MSG");
      ???.addCategory("com.tencent.mm.category." + localbo.field_packageName);
      a.a(12, new b.7.1(this, ???));
      ???.putExtra("EXTRA_EXT_OPEN_NOTIFY_TYPE", "NEW_MESSAGE");
      ???.putStringArrayListExtra("EXTRA_EXT_OPEN_USER_DATA", localArrayList);
      ah.getContext().sendBroadcast(???);
      break label311;
      break;
      ??? = null;
      break label499;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.b.7
 * JD-Core Version:    0.7.0.1
 */