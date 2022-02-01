package com.tencent.mm.plugin.account.friend.model;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.cc.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class i
{
  private static Map<String, String> pSN = null;
  
  private static void Ta(String paramString)
  {
    AppMethodBeat.i(131035);
    Log.i("MicroMsg.FriendLogic", "clearFMsgAndFConvByTalker, rowId: %d, talker: %s", new Object[] { Long.valueOf(0L), paramString });
    Log.i("MicroMsg.FriendLogic", "clearFMsgAndFConvByTalker, delete fconversation, ret = ".concat(String.valueOf(((n)com.tencent.mm.kernel.h.ax(n.class)).gaX().S(0L, paramString))));
    Log.i("MicroMsg.FriendLogic", "clearFMsgAndFConvByTalker, delete fmsginfo, ret = ".concat(String.valueOf(((n)com.tencent.mm.kernel.h.ax(n.class)).gaY().aLw(paramString))));
    AppMethodBeat.o(131035);
  }
  
  public static String Tb(String paramString)
  {
    AppMethodBeat.i(131037);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(131037);
      return "";
    }
    Object localObject = (b)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getAddrUploadStg();
    paramString = "select addr_upload2.realname from addr_upload2 where addr_upload2.id = " + a.SQ(paramString);
    localObject = ((b)localObject).omV.rawQuery(paramString, null, 2);
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
    paramString = com.tencent.mm.pluginsdk.b.b(paramString, paramContext, false);
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
  
  public static boolean bWU()
  {
    AppMethodBeat.i(131025);
    if ((com.tencent.mm.kernel.h.baE() != null) && (com.tencent.mm.kernel.h.baE().ban() != null))
    {
      boolean bool = Util.nullAs((Boolean)com.tencent.mm.kernel.h.baE().ban().d(12322, Boolean.TRUE), true);
      AppMethodBeat.o(131025);
      return bool;
    }
    Log.e("MicroMsg.FriendLogic", "[arthurdan.UploadPhone] Notice!!!! MMKernel.storage() is null!!!");
    AppMethodBeat.o(131025);
    return false;
  }
  
  public static boolean bWV()
  {
    AppMethodBeat.i(131026);
    a locala = bWW();
    Log.i("MicroMsg.FriendLogic", "isTipInMobileFriend, state %s", new Object[] { locala.toString() });
    if (locala == a.pSQ)
    {
      boolean bool = Util.nullAs((Boolean)com.tencent.mm.kernel.h.baE().ban().d(12322, Boolean.FALSE), false);
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
  
  public static a bWW()
  {
    AppMethodBeat.i(131027);
    for (;;)
    {
      try
      {
        localObject2 = (String)com.tencent.mm.kernel.h.baE().ban().d(4097, "");
        String str = (String)com.tencent.mm.kernel.h.baE().ban().d(6, "");
        boolean bool = z.bBC();
        Log.i("MicroMsg.FriendLogic", "isUpload " + bool + " stat " + z.bAQ());
        if (localObject2 != null)
        {
          Object localObject1 = localObject2;
          if (((String)localObject2).length() > 0)
          {
            if (str == null) {
              break label189;
            }
            localObject2 = str;
            if (str.length() <= 0) {
              break label189;
            }
            if ((localObject1 == null) && (localObject2 == null))
            {
              localObject1 = a.pSO;
              AppMethodBeat.o(131027);
              return localObject1;
            }
            if ((localObject1 != null) && (localObject2 == null))
            {
              localObject1 = a.pSP;
              AppMethodBeat.o(131027);
              return localObject1;
            }
            if (bool)
            {
              localObject1 = a.pSQ;
              AppMethodBeat.o(131027);
              return localObject1;
            }
            localObject1 = a.pSR;
            AppMethodBeat.o(131027);
            return localObject1;
          }
        }
      }
      catch (Exception localException)
      {
        locala = a.pSO;
        AppMethodBeat.o(131027);
        return locala;
      }
      a locala = null;
      continue;
      label189:
      Object localObject2 = null;
    }
  }
  
  public static void bWX()
  {
    AppMethodBeat.i(131028);
    com.tencent.mm.kernel.h.baE().ban().B(4097, "");
    com.tencent.mm.kernel.h.baE().ban().B(6, "");
    AppMethodBeat.o(131028);
  }
  
  public static boolean bWY()
  {
    AppMethodBeat.i(131030);
    boolean bool = com.tencent.mm.kernel.h.baz();
    if (!bool)
    {
      Log.i("MicroMsg.FriendLogic", "canSyncAddrBook isAccHasReady: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(131030);
      return false;
    }
    if (bWW() == a.pSQ) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.i("MicroMsg.FriendLogic", "canSyncAddrBook userBindOpMobile: %b", new Object[] { Boolean.FALSE });
      AppMethodBeat.o(131030);
      return false;
    }
    bool = bWU();
    if (!bool)
    {
      Log.i("MicroMsg.FriendLogic", "canSyncAddrBook isUploadContact: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(131030);
      return false;
    }
    AppMethodBeat.o(131030);
    return true;
  }
  
  public static boolean bWZ()
  {
    return true;
  }
  
  public static void bXa() {}
  
  public static void bXb()
  {
    AppMethodBeat.i(131033);
    b localb = (b)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getAddrUploadStg();
    int i = localb.omV.delete("addr_upload2", null, null);
    Log.d("MicroMsg.AddrUploadStorage", "delete addr_upload2");
    if (i > 0) {
      localb.doNotify(5, localb, null);
    }
    AppMethodBeat.o(131033);
  }
  
  public static void bXc()
  {
    AppMethodBeat.i(131034);
    Object localObject = new HashSet();
    Iterator localIterator = ((ArrayList)((n)com.tencent.mm.kernel.h.ax(n.class)).gaY().gbe()).iterator();
    while (localIterator.hasNext())
    {
      bp localbp = (bp)localIterator.next();
      cc.a locala = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLU(localbp.field_msgContent);
      if ((locala != null) && ((locala.scene == 10) || (locala.scene == 11))) {
        ((HashSet)localObject).add(localbp.field_talker);
      }
    }
    Log.d("MicroMsg.FriendLogic", "deleteMobileFMessage, delete fmsg and fconv, talker size = " + ((HashSet)localObject).size());
    localObject = ((HashSet)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      Ta((String)((Iterator)localObject).next());
    }
    AppMethodBeat.o(131034);
  }
  
  public static List<String> bXd()
  {
    AppMethodBeat.i(131040);
    Cursor localCursor = ((b)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getAddrUploadStg()).omV.rawQuery("select addr_upload2.md5 from addr_upload2 where addr_upload2.uploadtime = 0 AND addr_upload2.type = 1", null, 2);
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext()) {
      localArrayList.add(localCursor.getString(0));
    }
    localCursor.close();
    AppMethodBeat.o(131040);
    return localArrayList;
  }
  
  public static List<String> bXe()
  {
    AppMethodBeat.i(131041);
    Cursor localCursor = ((b)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getAddrUploadStg()).omV.rawQuery("select addr_upload2.moblie from addr_upload2 where addr_upload2.uploadtime = 0 AND addr_upload2.type = 0", null, 2);
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext())
    {
      String str = com.tencent.mm.pluginsdk.b.Tu(localCursor.getString(0));
      if (com.tencent.mm.pluginsdk.b.boN(str)) {
        localArrayList.add(str);
      }
    }
    localCursor.close();
    AppMethodBeat.o(131041);
    return localArrayList;
  }
  
  public static void cA(List<String> paramList)
  {
    AppMethodBeat.i(131039);
    if (paramList == null)
    {
      Log.e("MicroMsg.FriendLogic", "set uploaded mobile contact failed, null info list");
      AppMethodBeat.o(131039);
      return;
    }
    ((b)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getAddrUploadStg()).cx(paramList);
    AppMethodBeat.o(131039);
  }
  
  public static void cy(List<String> paramList)
  {
    AppMethodBeat.i(131036);
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(131036);
      return;
    }
    HashSet localHashSet = new HashSet();
    Iterator localIterator = ((ArrayList)((n)com.tencent.mm.kernel.h.ax(n.class)).gaY().gbe()).iterator();
    while (localIterator.hasNext())
    {
      bp localbp = (bp)localIterator.next();
      cc.a locala = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLU(localbp.field_msgContent);
      if (locala != null)
      {
        String str1 = locala.adkA;
        String str2 = locala.adkz;
        if (((locala.scene == 10) || (locala.scene == 11)) && ((paramList.contains(str1)) || (paramList.contains(str2)))) {
          localHashSet.add(localbp.field_talker);
        }
      }
    }
    Log.d("MicroMsg.FriendLogic", "deleteMobileFMessage(md5List), delete fmsg and fconv, talker size = " + localHashSet.size());
    paramList = localHashSet.iterator();
    while (paramList.hasNext()) {
      Ta((String)paramList.next());
    }
    AppMethodBeat.o(131036);
  }
  
  public static void cz(List<a> paramList)
  {
    AppMethodBeat.i(131038);
    if (paramList == null)
    {
      Log.e("MicroMsg.FriendLogic", "sync address book failed, null info list");
      AppMethodBeat.o(131038);
      return;
    }
    ((b)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getAddrUploadStg()).bY(paramList);
    AppMethodBeat.o(131038);
  }
  
  public static void hN(boolean paramBoolean)
  {
    AppMethodBeat.i(131024);
    if ((paramBoolean) && (!((Boolean)com.tencent.mm.kernel.h.baE().ban().d(12322, Boolean.FALSE)).booleanValue())) {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acZj, Boolean.TRUE);
    }
    com.tencent.mm.kernel.h.baE().ban().B(12322, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(131024);
  }
  
  public static boolean yr(int paramInt)
  {
    AppMethodBeat.i(131042);
    an localan = ((ao)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQGroupStg()).ys(paramInt);
    boolean bool = ((aq)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg()).yt(paramInt);
    if (localan == null)
    {
      AppMethodBeat.o(131042);
      return false;
    }
    if ((localan.pTR == 1) || (bool))
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
      pSO = new a("NO_INIT", 0);
      pSP = new a("SET_MOBILE", 1);
      pSQ = new a("SUCC", 2);
      pSR = new a("SUCC_UNLOAD", 3);
      pSS = new a[] { pSO, pSP, pSQ, pSR };
      AppMethodBeat.o(131023);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.i
 * JD-Core Version:    0.7.0.1
 */