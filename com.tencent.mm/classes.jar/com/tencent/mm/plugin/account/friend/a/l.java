package com.tencent.mm.plugin.account.friend.a;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.ca.a;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class l
{
  private static Map<String, String> keI = null;
  
  private static void Tb(String paramString)
  {
    AppMethodBeat.i(131035);
    Log.i("MicroMsg.FriendLogic", "clearFMsgAndFConvByTalker, rowId: %d, talker: %s", new Object[] { Long.valueOf(0L), paramString });
    Log.i("MicroMsg.FriendLogic", "clearFMsgAndFConvByTalker, delete fconversation, ret = ".concat(String.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiw().x(0L, paramString))));
    Log.i("MicroMsg.FriendLogic", "clearFMsgAndFConvByTalker, delete fmsginfo, ret = ".concat(String.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eix().aEn(paramString))));
    AppMethodBeat.o(131035);
  }
  
  public static String Tc(String paramString)
  {
    AppMethodBeat.i(131037);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(131037);
      return "";
    }
    Object localObject = (b)((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg();
    paramString = "select addr_upload2.realname from addr_upload2 where addr_upload2.id = " + a.SQ(paramString);
    localObject = ((b)localObject).iFy.rawQuery(paramString, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(131037);
      return "";
    }
    paramString = "";
    if (((Cursor)localObject).moveToFirst()) {
      paramString = ((Cursor)localObject).getString(0);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(131037);
    return paramString;
  }
  
  public static Bitmap a(String paramString, Context paramContext)
  {
    AppMethodBeat.i(131031);
    paramString = com.tencent.mm.pluginsdk.b.a(paramString, paramContext, false);
    AppMethodBeat.o(131031);
    return paramString;
  }
  
  public static boolean a(String paramString, Context paramContext, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131032);
    boolean bool = com.tencent.mm.pluginsdk.b.b(paramString, paramContext, paramArrayOfByte);
    AppMethodBeat.o(131032);
    return bool;
  }
  
  public static void aV(List<String> paramList)
  {
    AppMethodBeat.i(131036);
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(131036);
      return;
    }
    HashSet localHashSet = new HashSet();
    Iterator localIterator = ((ArrayList)((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eix().eiD()).iterator();
    while (localIterator.hasNext())
    {
      bn localbn = (bn)localIterator.next();
      ca.a locala = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEK(localbn.field_msgContent);
      if (locala != null)
      {
        String str1 = locala.OqL;
        String str2 = locala.OqK;
        if (((locala.scene == 10) || (locala.scene == 11)) && ((paramList.contains(str1)) || (paramList.contains(str2)))) {
          localHashSet.add(localbn.field_talker);
        }
      }
    }
    Log.d("MicroMsg.FriendLogic", "deleteMobileFMessage(md5List), delete fmsg and fconv, talker size = " + localHashSet.size());
    paramList = localHashSet.iterator();
    while (paramList.hasNext()) {
      Tb((String)paramList.next());
    }
    AppMethodBeat.o(131036);
  }
  
  public static void aW(List<a> paramList)
  {
    AppMethodBeat.i(131038);
    if (paramList == null)
    {
      Log.e("MicroMsg.FriendLogic", "sync address book failed, null info list");
      AppMethodBeat.o(131038);
      return;
    }
    ((b)((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).av(paramList);
    AppMethodBeat.o(131038);
  }
  
  public static void aX(List<String> paramList)
  {
    AppMethodBeat.i(131039);
    if (paramList == null)
    {
      Log.e("MicroMsg.FriendLogic", "set uploaded mobile contact failed, null info list");
      AppMethodBeat.o(131039);
      return;
    }
    ((b)((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).aU(paramList);
    AppMethodBeat.o(131039);
  }
  
  public static boolean bnX()
  {
    AppMethodBeat.i(131025);
    if ((g.aAh() != null) && (g.aAh().azQ() != null))
    {
      boolean bool = Util.nullAs((Boolean)g.aAh().azQ().get(12322, Boolean.TRUE), true);
      AppMethodBeat.o(131025);
      return bool;
    }
    Log.e("MicroMsg.FriendLogic", "[arthurdan.UploadPhone] Notice!!!! MMKernel.storage() is null!!!");
    AppMethodBeat.o(131025);
    return false;
  }
  
  public static boolean bnY()
  {
    AppMethodBeat.i(131026);
    a locala = bnZ();
    Log.i("MicroMsg.FriendLogic", "isTipInMobileFriend, state %s", new Object[] { locala.toString() });
    if (locala == a.keL)
    {
      boolean bool = Util.nullAs((Boolean)g.aAh().azQ().get(12322, Boolean.FALSE), false);
      Log.i("MicroMsg.FriendLogic", "USERINFO_UPLOAD_ADDR_LOOK_UP %B", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(131026);
        return true;
      }
      AppMethodBeat.o(131026);
      return false;
    }
    AppMethodBeat.o(131026);
    return false;
  }
  
  public static a bnZ()
  {
    AppMethodBeat.i(131027);
    for (;;)
    {
      try
      {
        localObject2 = (String)g.aAh().azQ().get(4097, "");
        String str = (String)g.aAh().azQ().get(6, "");
        boolean bool = z.aUI();
        Log.i("MicroMsg.FriendLogic", "isUpload " + bool + " stat " + z.aUc());
        if (localObject2 != null)
        {
          Object localObject1 = localObject2;
          if (((String)localObject2).length() > 0)
          {
            if (str == null) {
              break label197;
            }
            localObject2 = str;
            if (str.length() <= 0) {
              break label197;
            }
            if ((localObject1 == null) && (localObject2 == null))
            {
              localObject1 = a.keJ;
              AppMethodBeat.o(131027);
              return localObject1;
            }
            if ((localObject1 != null) && (localObject2 == null))
            {
              localObject1 = a.keK;
              AppMethodBeat.o(131027);
              return localObject1;
            }
            if (bool)
            {
              localObject1 = a.keL;
              AppMethodBeat.o(131027);
              return localObject1;
            }
            localObject1 = a.keM;
            AppMethodBeat.o(131027);
            return localObject1;
          }
        }
      }
      catch (Exception localException)
      {
        locala = a.keJ;
        AppMethodBeat.o(131027);
        return locala;
      }
      a locala = null;
      continue;
      label197:
      Object localObject2 = null;
    }
  }
  
  public static void boa()
  {
    AppMethodBeat.i(131028);
    g.aAh().azQ().set(4097, "");
    g.aAh().azQ().set(6, "");
    AppMethodBeat.o(131028);
  }
  
  public static String bob()
  {
    AppMethodBeat.i(131029);
    String str = (String)g.aAh().azQ().get(6, "");
    AppMethodBeat.o(131029);
    return str;
  }
  
  public static boolean boc()
  {
    AppMethodBeat.i(131030);
    boolean bool = g.aAc();
    if (!bool)
    {
      Log.i("MicroMsg.FriendLogic", "canSyncAddrBook isAccHasReady: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(131030);
      return false;
    }
    if (bnZ() == a.keL) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.i("MicroMsg.FriendLogic", "canSyncAddrBook userBindOpMobile: %b", new Object[] { Boolean.FALSE });
      AppMethodBeat.o(131030);
      return false;
    }
    bool = bnX();
    if (!bool)
    {
      Log.i("MicroMsg.FriendLogic", "canSyncAddrBook isUploadContact: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(131030);
      return false;
    }
    AppMethodBeat.o(131030);
    return true;
  }
  
  public static boolean bod()
  {
    return true;
  }
  
  public static void boe() {}
  
  public static void bof()
  {
    AppMethodBeat.i(131033);
    b localb = (b)((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg();
    int i = localb.iFy.delete("addr_upload2", null, null);
    Log.d("MicroMsg.AddrUploadStorage", "delete addr_upload2");
    if (i > 0) {
      localb.doNotify(5, localb, null);
    }
    AppMethodBeat.o(131033);
  }
  
  public static void bog()
  {
    AppMethodBeat.i(131034);
    Object localObject = new HashSet();
    Iterator localIterator = ((ArrayList)((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eix().eiD()).iterator();
    while (localIterator.hasNext())
    {
      bn localbn = (bn)localIterator.next();
      ca.a locala = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEK(localbn.field_msgContent);
      if ((locala != null) && ((locala.scene == 10) || (locala.scene == 11))) {
        ((HashSet)localObject).add(localbn.field_talker);
      }
    }
    Log.d("MicroMsg.FriendLogic", "deleteMobileFMessage, delete fmsg and fconv, talker size = " + ((HashSet)localObject).size());
    localObject = ((HashSet)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      Tb((String)((Iterator)localObject).next());
    }
    AppMethodBeat.o(131034);
  }
  
  public static List<String> boh()
  {
    AppMethodBeat.i(131040);
    Cursor localCursor = ((b)((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).iFy.rawQuery("select addr_upload2.md5 from addr_upload2 where addr_upload2.uploadtime = 0 AND addr_upload2.type = 1", null, 2);
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext()) {
      localArrayList.add(localCursor.getString(0));
    }
    localCursor.close();
    AppMethodBeat.o(131040);
    return localArrayList;
  }
  
  public static List<String> boi()
  {
    AppMethodBeat.i(131041);
    Cursor localCursor = ((b)((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).iFy.rawQuery("select addr_upload2.moblie from addr_upload2 where addr_upload2.uploadtime = 0 AND addr_upload2.type = 0", null, 2);
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext())
    {
      String str = com.tencent.mm.pluginsdk.b.Ts(localCursor.getString(0));
      if (com.tencent.mm.pluginsdk.b.bcT(str)) {
        localArrayList.add(str);
      }
    }
    localCursor.close();
    AppMethodBeat.o(131041);
    return localArrayList;
  }
  
  public static void gl(boolean paramBoolean)
  {
    AppMethodBeat.i(131024);
    if ((paramBoolean) && (!((Boolean)g.aAh().azQ().get(12322, Boolean.FALSE)).booleanValue())) {
      g.aAh().azQ().set(ar.a.Ojh, Boolean.TRUE);
    }
    g.aAh().azQ().set(12322, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(131024);
  }
  
  public static boolean vh(int paramInt)
  {
    AppMethodBeat.i(131042);
    aq localaq = ((ar)((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).vi(paramInt);
    boolean bool = ((at)((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).vj(paramInt);
    if (localaq == null)
    {
      AppMethodBeat.o(131042);
      return false;
    }
    if ((localaq.kfK == 1) || (bool))
    {
      AppMethodBeat.o(131042);
      return true;
    }
    AppMethodBeat.o(131042);
    return false;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(131023);
      keJ = new a("NO_INIT", 0);
      keK = new a("SET_MOBILE", 1);
      keL = new a("SUCC", 2);
      keM = new a("SUCC_UNLOAD", 3);
      keN = new a[] { keJ, keK, keL, keM };
      AppMethodBeat.o(131023);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.l
 * JD-Core Version:    0.7.0.1
 */