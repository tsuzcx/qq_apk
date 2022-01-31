package com.tencent.mm.plugin.account.friend.a;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class l
{
  private static Map<String, String> gxy = null;
  
  public static boolean a(String paramString, Context paramContext, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108371);
    boolean bool = com.tencent.mm.pluginsdk.a.b(paramString, paramContext, paramArrayOfByte);
    AppMethodBeat.o(108371);
    return bool;
  }
  
  public static void ap(List<String> paramList)
  {
    AppMethodBeat.i(108375);
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(108375);
      return;
    }
    HashSet localHashSet = new HashSet();
    Iterator localIterator = ((ArrayList)((j)g.E(j.class)).bPP().bPV()).iterator();
    while (localIterator.hasNext())
    {
      ax localax = (ax)localIterator.next();
      bi.a locala = ((j)g.E(j.class)).bPQ().Ty(localax.field_msgContent);
      if (locala != null)
      {
        String str1 = locala.yOj;
        String str2 = locala.yOi;
        if (((locala.scene == 10) || (locala.scene == 11)) && ((paramList.contains(str1)) || (paramList.contains(str2)))) {
          localHashSet.add(localax.field_talker);
        }
      }
    }
    ab.d("MicroMsg.FriendLogic", "deleteMobileFMessage(md5List), delete fmsg and fconv, talker size = " + localHashSet.size());
    paramList = localHashSet.iterator();
    while (paramList.hasNext()) {
      xi((String)paramList.next());
    }
    AppMethodBeat.o(108375);
  }
  
  public static void aq(List<a> paramList)
  {
    AppMethodBeat.i(108377);
    if (paramList == null)
    {
      ab.e("MicroMsg.FriendLogic", "sync address book failed, null info list");
      AppMethodBeat.o(108377);
      return;
    }
    ((b)((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).X(paramList);
    AppMethodBeat.o(108377);
  }
  
  public static boolean aqo()
  {
    AppMethodBeat.i(108364);
    if ((g.RL() != null) && (g.RL().Ru() != null))
    {
      boolean bool = bo.a((Boolean)g.RL().Ru().get(12322, Boolean.TRUE), true);
      AppMethodBeat.o(108364);
      return bool;
    }
    ab.e("MicroMsg.FriendLogic", "[arthurdan.UploadPhone] Notice!!!! MMKernel.storage() is null!!!");
    AppMethodBeat.o(108364);
    return false;
  }
  
  public static boolean aqp()
  {
    AppMethodBeat.i(108365);
    l.a locala = aqq();
    ab.i("MicroMsg.FriendLogic", "isTipInMobileFriend, state %s", new Object[] { locala.toString() });
    if (locala == l.a.gxB)
    {
      boolean bool = bo.a((Boolean)g.RL().Ru().get(12322, Boolean.FALSE), false);
      ab.i("MicroMsg.FriendLogic", "USERINFO_UPLOAD_ADDR_LOOK_UP %B", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(108365);
        return true;
      }
      AppMethodBeat.o(108365);
      return false;
    }
    AppMethodBeat.o(108365);
    return false;
  }
  
  public static l.a aqq()
  {
    AppMethodBeat.i(108366);
    for (;;)
    {
      try
      {
        localObject2 = (String)g.RL().Ru().get(4097, "");
        String str = (String)g.RL().Ru().get(6, "");
        boolean bool = r.ZR();
        ab.i("MicroMsg.FriendLogic", "isUpload " + bool + " stat " + r.Zr());
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
              localObject1 = l.a.gxz;
              AppMethodBeat.o(108366);
              return localObject1;
            }
            if ((localObject1 != null) && (localObject2 == null))
            {
              localObject1 = l.a.gxA;
              AppMethodBeat.o(108366);
              return localObject1;
            }
            if (bool)
            {
              localObject1 = l.a.gxB;
              AppMethodBeat.o(108366);
              return localObject1;
            }
            localObject1 = l.a.gxC;
            AppMethodBeat.o(108366);
            return localObject1;
          }
        }
      }
      catch (Exception localException)
      {
        locala = l.a.gxz;
        AppMethodBeat.o(108366);
        return locala;
      }
      l.a locala = null;
      continue;
      label189:
      Object localObject2 = null;
    }
  }
  
  public static void aqr()
  {
    AppMethodBeat.i(108367);
    g.RL().Ru().set(4097, "");
    g.RL().Ru().set(6, "");
    AppMethodBeat.o(108367);
  }
  
  public static String aqs()
  {
    AppMethodBeat.i(108368);
    String str = (String)g.RL().Ru().get(6, "");
    AppMethodBeat.o(108368);
    return str;
  }
  
  public static boolean aqt()
  {
    AppMethodBeat.i(108369);
    boolean bool = g.RG();
    if (!bool)
    {
      ab.i("MicroMsg.FriendLogic", "canSyncAddrBook isAccHasReady: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(108369);
      return false;
    }
    if (aqq() == l.a.gxB) {}
    for (int i = 1; i == 0; i = 0)
    {
      ab.i("MicroMsg.FriendLogic", "canSyncAddrBook userBindOpMobile: %b", new Object[] { Boolean.FALSE });
      AppMethodBeat.o(108369);
      return false;
    }
    bool = aqo();
    if (!bool)
    {
      ab.i("MicroMsg.FriendLogic", "canSyncAddrBook isUploadContact: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(108369);
      return false;
    }
    AppMethodBeat.o(108369);
    return true;
  }
  
  public static boolean aqu()
  {
    return true;
  }
  
  public static void aqv() {}
  
  public static void aqw()
  {
    AppMethodBeat.i(108372);
    b localb = (b)((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg();
    int i = localb.fnw.delete("addr_upload2", null, null);
    ab.d("MicroMsg.AddrUploadStorage", "delete addr_upload2");
    if (i > 0) {
      localb.b(5, localb, null);
    }
    AppMethodBeat.o(108372);
  }
  
  public static void aqx()
  {
    AppMethodBeat.i(108373);
    Object localObject = new HashSet();
    Iterator localIterator = ((ArrayList)((j)g.E(j.class)).bPP().bPV()).iterator();
    while (localIterator.hasNext())
    {
      ax localax = (ax)localIterator.next();
      bi.a locala = ((j)g.E(j.class)).bPQ().Ty(localax.field_msgContent);
      if ((locala != null) && ((locala.scene == 10) || (locala.scene == 11))) {
        ((HashSet)localObject).add(localax.field_talker);
      }
    }
    ab.d("MicroMsg.FriendLogic", "deleteMobileFMessage, delete fmsg and fconv, talker size = " + ((HashSet)localObject).size());
    localObject = ((HashSet)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      xi((String)((Iterator)localObject).next());
    }
    AppMethodBeat.o(108373);
  }
  
  public static List<String> aqy()
  {
    AppMethodBeat.i(108379);
    Cursor localCursor = ((b)((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).fnw.a("select addr_upload2.md5 from addr_upload2 where addr_upload2.uploadtime = 0 AND addr_upload2.type = 1", null, 2);
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext()) {
      localArrayList.add(localCursor.getString(0));
    }
    localCursor.close();
    AppMethodBeat.o(108379);
    return localArrayList;
  }
  
  public static List<String> aqz()
  {
    AppMethodBeat.i(108380);
    Cursor localCursor = ((b)((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).fnw.a("select addr_upload2.moblie from addr_upload2 where addr_upload2.uploadtime = 0 AND addr_upload2.type = 0", null, 2);
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext())
    {
      String str = com.tencent.mm.pluginsdk.a.xw(localCursor.getString(0));
      if (com.tencent.mm.pluginsdk.a.akS(str)) {
        localArrayList.add(str);
      }
    }
    localCursor.close();
    AppMethodBeat.o(108380);
    return localArrayList;
  }
  
  public static void ar(List<String> paramList)
  {
    AppMethodBeat.i(108378);
    if (paramList == null)
    {
      ab.e("MicroMsg.FriendLogic", "set uploaded mobile contact failed, null info list");
      AppMethodBeat.o(108378);
      return;
    }
    ((b)((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).ao(paramList);
    AppMethodBeat.o(108378);
  }
  
  public static Bitmap b(String paramString, Context paramContext)
  {
    AppMethodBeat.i(108370);
    paramString = com.tencent.mm.pluginsdk.a.a(paramString, paramContext, false);
    AppMethodBeat.o(108370);
    return paramString;
  }
  
  public static void dx(boolean paramBoolean)
  {
    AppMethodBeat.i(140100);
    if ((paramBoolean) && (!((Boolean)g.RL().Ru().get(12322, Boolean.FALSE)).booleanValue())) {
      g.RL().Ru().set(ac.a.yMa, Boolean.TRUE);
    }
    g.RL().Ru().set(12322, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(140100);
  }
  
  public static boolean mT(int paramInt)
  {
    AppMethodBeat.i(108381);
    am localam = ((an)((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).mU(paramInt);
    boolean bool = ((ap)((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).mV(paramInt);
    if (localam == null)
    {
      AppMethodBeat.o(108381);
      return false;
    }
    if ((localam.gyB == 1) || (bool))
    {
      AppMethodBeat.o(108381);
      return true;
    }
    AppMethodBeat.o(108381);
    return false;
  }
  
  private static void xi(String paramString)
  {
    AppMethodBeat.i(108374);
    ab.i("MicroMsg.FriendLogic", "clearFMsgAndFConvByTalker, rowId: %d, talker: %s", new Object[] { Long.valueOf(0L), paramString });
    ab.i("MicroMsg.FriendLogic", "clearFMsgAndFConvByTalker, delete fconversation, ret = ".concat(String.valueOf(((j)g.E(j.class)).bPO().p(0L, paramString))));
    ab.i("MicroMsg.FriendLogic", "clearFMsgAndFConvByTalker, delete fmsginfo, ret = ".concat(String.valueOf(((j)g.E(j.class)).bPP().Td(paramString))));
    AppMethodBeat.o(108374);
  }
  
  public static String xj(String paramString)
  {
    AppMethodBeat.i(108376);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(108376);
      return "";
    }
    Object localObject = (b)((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg();
    paramString = "select addr_upload2.realname from addr_upload2 where addr_upload2.id = \"" + a.wV(paramString) + "\"";
    localObject = ((b)localObject).fnw.a(paramString, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(108376);
      return "";
    }
    paramString = "";
    if (((Cursor)localObject).moveToFirst()) {
      paramString = ((Cursor)localObject).getString(0);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(108376);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.l
 * JD-Core Version:    0.7.0.1
 */