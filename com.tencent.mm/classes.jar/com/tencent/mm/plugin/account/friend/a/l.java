package com.tencent.mm.plugin.account.friend.a;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bl.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class l
{
  private static Map<String, String> ikv = null;
  
  private static void Cm(String paramString)
  {
    AppMethodBeat.i(131035);
    ad.i("MicroMsg.FriendLogic", "clearFMsgAndFConvByTalker, rowId: %d, talker: %s", new Object[] { Long.valueOf(0L), paramString });
    ad.i("MicroMsg.FriendLogic", "clearFMsgAndFConvByTalker, delete fconversation, ret = ".concat(String.valueOf(((k)g.ab(k.class)).cOG().u(0L, paramString))));
    ad.i("MicroMsg.FriendLogic", "clearFMsgAndFConvByTalker, delete fmsginfo, ret = ".concat(String.valueOf(((k)g.ab(k.class)).cOH().agh(paramString))));
    AppMethodBeat.o(131035);
  }
  
  public static String Cn(String paramString)
  {
    AppMethodBeat.i(131037);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(131037);
      return "";
    }
    Object localObject = (b)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg();
    paramString = "select addr_upload2.realname from addr_upload2 where addr_upload2.id = " + a.Ca(paramString);
    localObject = ((b)localObject).gPa.a(paramString, null, 2);
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
    paramString = com.tencent.mm.pluginsdk.a.a(paramString, paramContext, false);
    AppMethodBeat.o(131031);
    return paramString;
  }
  
  public static boolean a(String paramString, Context paramContext, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131032);
    boolean bool = com.tencent.mm.pluginsdk.a.b(paramString, paramContext, paramArrayOfByte);
    AppMethodBeat.o(131032);
    return bool;
  }
  
  public static boolean aIJ()
  {
    AppMethodBeat.i(131025);
    if ((g.afB() != null) && (g.afB().afk() != null))
    {
      boolean bool = bt.a((Boolean)g.afB().afk().get(12322, Boolean.TRUE), true);
      AppMethodBeat.o(131025);
      return bool;
    }
    ad.e("MicroMsg.FriendLogic", "[arthurdan.UploadPhone] Notice!!!! MMKernel.storage() is null!!!");
    AppMethodBeat.o(131025);
    return false;
  }
  
  public static boolean aIK()
  {
    AppMethodBeat.i(131026);
    a locala = aIL();
    ad.i("MicroMsg.FriendLogic", "isTipInMobileFriend, state %s", new Object[] { locala.toString() });
    if (locala == a.iky)
    {
      boolean bool = bt.a((Boolean)g.afB().afk().get(12322, Boolean.FALSE), false);
      ad.i("MicroMsg.FriendLogic", "USERINFO_UPLOAD_ADDR_LOOK_UP %B", new Object[] { Boolean.valueOf(bool) });
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
  
  public static a aIL()
  {
    AppMethodBeat.i(131027);
    for (;;)
    {
      try
      {
        localObject2 = (String)g.afB().afk().get(4097, "");
        String str = (String)g.afB().afk().get(6, "");
        boolean bool = u.arl();
        ad.i("MicroMsg.FriendLogic", "isUpload " + bool + " stat " + u.aqK());
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
              localObject1 = a.ikw;
              AppMethodBeat.o(131027);
              return localObject1;
            }
            if ((localObject1 != null) && (localObject2 == null))
            {
              localObject1 = a.ikx;
              AppMethodBeat.o(131027);
              return localObject1;
            }
            if (bool)
            {
              localObject1 = a.iky;
              AppMethodBeat.o(131027);
              return localObject1;
            }
            localObject1 = a.ikz;
            AppMethodBeat.o(131027);
            return localObject1;
          }
        }
      }
      catch (Exception localException)
      {
        locala = a.ikw;
        AppMethodBeat.o(131027);
        return locala;
      }
      a locala = null;
      continue;
      label189:
      Object localObject2 = null;
    }
  }
  
  public static void aIM()
  {
    AppMethodBeat.i(131028);
    g.afB().afk().set(4097, "");
    g.afB().afk().set(6, "");
    AppMethodBeat.o(131028);
  }
  
  public static String aIN()
  {
    AppMethodBeat.i(131029);
    String str = (String)g.afB().afk().get(6, "");
    AppMethodBeat.o(131029);
    return str;
  }
  
  public static boolean aIO()
  {
    AppMethodBeat.i(131030);
    boolean bool = g.afw();
    if (!bool)
    {
      ad.i("MicroMsg.FriendLogic", "canSyncAddrBook isAccHasReady: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(131030);
      return false;
    }
    if (aIL() == a.iky) {}
    for (int i = 1; i == 0; i = 0)
    {
      ad.i("MicroMsg.FriendLogic", "canSyncAddrBook userBindOpMobile: %b", new Object[] { Boolean.FALSE });
      AppMethodBeat.o(131030);
      return false;
    }
    bool = aIJ();
    if (!bool)
    {
      ad.i("MicroMsg.FriendLogic", "canSyncAddrBook isUploadContact: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(131030);
      return false;
    }
    AppMethodBeat.o(131030);
    return true;
  }
  
  public static boolean aIP()
  {
    return true;
  }
  
  public static void aIQ() {}
  
  public static void aIR()
  {
    AppMethodBeat.i(131033);
    b localb = (b)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg();
    int i = localb.gPa.delete("addr_upload2", null, null);
    ad.d("MicroMsg.AddrUploadStorage", "delete addr_upload2");
    if (i > 0) {
      localb.b(5, localb, null);
    }
    AppMethodBeat.o(131033);
  }
  
  public static void aIS()
  {
    AppMethodBeat.i(131034);
    Object localObject = new HashSet();
    Iterator localIterator = ((ArrayList)((k)g.ab(k.class)).cOH().cOO()).iterator();
    while (localIterator.hasNext())
    {
      ba localba = (ba)localIterator.next();
      bl.a locala = ((k)g.ab(k.class)).cOI().agC(localba.field_msgContent);
      if ((locala != null) && ((locala.scene == 10) || (locala.scene == 11))) {
        ((HashSet)localObject).add(localba.field_talker);
      }
    }
    ad.d("MicroMsg.FriendLogic", "deleteMobileFMessage, delete fmsg and fconv, talker size = " + ((HashSet)localObject).size());
    localObject = ((HashSet)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      Cm((String)((Iterator)localObject).next());
    }
    AppMethodBeat.o(131034);
  }
  
  public static List<String> aIT()
  {
    AppMethodBeat.i(131040);
    Cursor localCursor = ((b)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).gPa.a("select addr_upload2.md5 from addr_upload2 where addr_upload2.uploadtime = 0 AND addr_upload2.type = 1", null, 2);
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext()) {
      localArrayList.add(localCursor.getString(0));
    }
    localCursor.close();
    AppMethodBeat.o(131040);
    return localArrayList;
  }
  
  public static List<String> aIU()
  {
    AppMethodBeat.i(131041);
    Cursor localCursor = ((b)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).gPa.a("select addr_upload2.moblie from addr_upload2 where addr_upload2.uploadtime = 0 AND addr_upload2.type = 0", null, 2);
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext())
    {
      String str = com.tencent.mm.pluginsdk.a.CD(localCursor.getString(0));
      if (com.tencent.mm.pluginsdk.a.aAm(str)) {
        localArrayList.add(str);
      }
    }
    localCursor.close();
    AppMethodBeat.o(131041);
    return localArrayList;
  }
  
  public static void aN(List<String> paramList)
  {
    AppMethodBeat.i(131036);
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(131036);
      return;
    }
    HashSet localHashSet = new HashSet();
    Iterator localIterator = ((ArrayList)((k)g.ab(k.class)).cOH().cOO()).iterator();
    while (localIterator.hasNext())
    {
      ba localba = (ba)localIterator.next();
      bl.a locala = ((k)g.ab(k.class)).cOI().agC(localba.field_msgContent);
      if (locala != null)
      {
        String str1 = locala.FzW;
        String str2 = locala.FzV;
        if (((locala.scene == 10) || (locala.scene == 11)) && ((paramList.contains(str1)) || (paramList.contains(str2)))) {
          localHashSet.add(localba.field_talker);
        }
      }
    }
    ad.d("MicroMsg.FriendLogic", "deleteMobileFMessage(md5List), delete fmsg and fconv, talker size = " + localHashSet.size());
    paramList = localHashSet.iterator();
    while (paramList.hasNext()) {
      Cm((String)paramList.next());
    }
    AppMethodBeat.o(131036);
  }
  
  public static void aO(List<a> paramList)
  {
    AppMethodBeat.i(131038);
    if (paramList == null)
    {
      ad.e("MicroMsg.FriendLogic", "sync address book failed, null info list");
      AppMethodBeat.o(131038);
      return;
    }
    ((b)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).ao(paramList);
    AppMethodBeat.o(131038);
  }
  
  public static void aP(List<String> paramList)
  {
    AppMethodBeat.i(131039);
    if (paramList == null)
    {
      ad.e("MicroMsg.FriendLogic", "set uploaded mobile contact failed, null info list");
      AppMethodBeat.o(131039);
      return;
    }
    ((b)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).aM(paramList);
    AppMethodBeat.o(131039);
  }
  
  public static void eT(boolean paramBoolean)
  {
    AppMethodBeat.i(131024);
    if ((paramBoolean) && (!((Boolean)g.afB().afk().get(12322, Boolean.FALSE)).booleanValue())) {
      g.afB().afk().set(ae.a.FvC, Boolean.TRUE);
    }
    g.afB().afk().set(12322, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(131024);
  }
  
  public static boolean qb(int paramInt)
  {
    AppMethodBeat.i(131042);
    aq localaq = ((ar)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).qc(paramInt);
    boolean bool = ((at)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).qd(paramInt);
    if (localaq == null)
    {
      AppMethodBeat.o(131042);
      return false;
    }
    if ((localaq.ily == 1) || (bool))
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
      ikw = new a("NO_INIT", 0);
      ikx = new a("SET_MOBILE", 1);
      iky = new a("SUCC", 2);
      ikz = new a("SUCC_UNLOAD", 3);
      ikA = new a[] { ikw, ikx, iky, ikz };
      AppMethodBeat.o(131023);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.l
 * JD-Core Version:    0.7.0.1
 */