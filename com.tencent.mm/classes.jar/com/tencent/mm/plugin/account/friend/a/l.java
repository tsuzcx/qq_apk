package com.tencent.mm.plugin.account.friend.a;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import com.tencent.mm.cf.h;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  private static Map<String, String> ffQ = null;
  
  public static void WM()
  {
    com.tencent.mm.kernel.g.DP().Dz().o(12322, Boolean.valueOf(true));
  }
  
  public static boolean WN()
  {
    if ((com.tencent.mm.kernel.g.DP() != null) && (com.tencent.mm.kernel.g.DP().Dz() != null)) {
      return bk.a((Boolean)com.tencent.mm.kernel.g.DP().Dz().get(12322, Boolean.valueOf(true)), true);
    }
    y.e("MicroMsg.FriendLogic", "[arthurdan.UploadPhone] Notice!!!! MMKernel.storage() is null!!!");
    return false;
  }
  
  public static boolean WO()
  {
    l.a locala = WP();
    y.i("MicroMsg.FriendLogic", "isTipInMobileFriend, state %s", new Object[] { locala.toString() });
    if (locala == l.a.ffT)
    {
      boolean bool = bk.a((Boolean)com.tencent.mm.kernel.g.DP().Dz().get(12322, Boolean.valueOf(false)), false);
      y.i("MicroMsg.FriendLogic", "USERINFO_UPLOAD_ADDR_LOOK_UP %B", new Object[] { Boolean.valueOf(bool) });
      return !bool;
    }
    return false;
  }
  
  public static l.a WP()
  {
    for (;;)
    {
      try
      {
        localObject3 = (String)com.tencent.mm.kernel.g.DP().Dz().get(4097, "");
        String str = (String)com.tencent.mm.kernel.g.DP().Dz().get(6, "");
        boolean bool = q.GN();
        y.i("MicroMsg.FriendLogic", "isUpload " + bool + " stat " + q.Gn());
        if (localObject3 != null)
        {
          Object localObject1 = localObject3;
          if (((String)localObject3).length() > 0)
          {
            if (str == null) {
              break label151;
            }
            localObject3 = str;
            if (str.length() <= 0) {
              break label151;
            }
            if ((localObject1 == null) && (localObject3 == null)) {
              return l.a.ffR;
            }
            if ((localObject1 != null) && (localObject3 == null)) {
              return l.a.ffS;
            }
            if (bool) {
              return l.a.ffT;
            }
            localObject1 = l.a.ffU;
            return localObject1;
          }
        }
      }
      catch (Exception localException)
      {
        return l.a.ffR;
      }
      Object localObject2 = null;
      continue;
      label151:
      Object localObject3 = null;
    }
  }
  
  public static void WQ()
  {
    com.tencent.mm.kernel.g.DP().Dz().o(4097, "");
    com.tencent.mm.kernel.g.DP().Dz().o(6, "");
  }
  
  public static String WR()
  {
    return (String)com.tencent.mm.kernel.g.DP().Dz().get(6, "");
  }
  
  public static boolean WS()
  {
    boolean bool = com.tencent.mm.kernel.g.DK();
    if (!bool)
    {
      y.i("MicroMsg.FriendLogic", "canSyncAddrBook isAccHasReady: %b", new Object[] { Boolean.valueOf(bool) });
      return false;
    }
    if (WP() == l.a.ffT) {}
    for (int i = 1; i == 0; i = 0)
    {
      y.i("MicroMsg.FriendLogic", "canSyncAddrBook userBindOpMobile: %b", new Object[] { Boolean.valueOf(false) });
      return false;
    }
    bool = WN();
    if (!bool)
    {
      y.i("MicroMsg.FriendLogic", "canSyncAddrBook isUploadContact: %b", new Object[] { Boolean.valueOf(bool) });
      return false;
    }
    return true;
  }
  
  public static void WT()
  {
    b localb = (b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg();
    int i = localb.dXo.delete("addr_upload2", null, null);
    y.d("MicroMsg.AddrUploadStorage", "delete addr_upload2");
    if (i > 0) {
      localb.b(5, localb, null);
    }
  }
  
  public static void WU()
  {
    Object localObject = new HashSet();
    Iterator localIterator = ((ArrayList)((j)com.tencent.mm.kernel.g.r(j.class)).bhN().bhT()).iterator();
    while (localIterator.hasNext())
    {
      ax localax = (ax)localIterator.next();
      bi.a locala = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HN(localax.field_msgContent);
      if ((locala != null) && ((locala.scene == 10) || (locala.scene == 11))) {
        ((HashSet)localObject).add(localax.field_talker);
      }
    }
    y.d("MicroMsg.FriendLogic", "deleteMobileFMessage, delete fmsg and fconv, talker size = " + ((HashSet)localObject).size());
    localObject = ((HashSet)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      pN((String)((Iterator)localObject).next());
    }
  }
  
  public static List<String> WV()
  {
    Cursor localCursor = ((b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).dXo.a("select addr_upload2.md5 from addr_upload2 where addr_upload2.uploadtime = 0 AND addr_upload2.type = 1", null, 2);
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext()) {
      localArrayList.add(localCursor.getString(0));
    }
    localCursor.close();
    return localArrayList;
  }
  
  public static List<String> WW()
  {
    Cursor localCursor = ((b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).dXo.a("select addr_upload2.moblie from addr_upload2 where addr_upload2.uploadtime = 0 AND addr_upload2.type = 0", null, 2);
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext())
    {
      String str = com.tencent.mm.pluginsdk.a.qa(localCursor.getString(0));
      if (com.tencent.mm.pluginsdk.a.Vw(str)) {
        localArrayList.add(str);
      }
    }
    localCursor.close();
    return localArrayList;
  }
  
  public static boolean a(String paramString, Context paramContext, byte[] paramArrayOfByte)
  {
    return com.tencent.mm.pluginsdk.a.b(paramString, paramContext, paramArrayOfByte);
  }
  
  public static void ah(List<String> paramList)
  {
    if (paramList.size() == 0) {}
    for (;;)
    {
      return;
      HashSet localHashSet = new HashSet();
      Iterator localIterator = ((ArrayList)((j)com.tencent.mm.kernel.g.r(j.class)).bhN().bhT()).iterator();
      while (localIterator.hasNext())
      {
        ax localax = (ax)localIterator.next();
        bi.a locala = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HN(localax.field_msgContent);
        if (locala != null)
        {
          String str1 = locala.uBX;
          String str2 = locala.uBW;
          if (((locala.scene == 10) || (locala.scene == 11)) && ((paramList.contains(str1)) || (paramList.contains(str2)))) {
            localHashSet.add(localax.field_talker);
          }
        }
      }
      y.d("MicroMsg.FriendLogic", "deleteMobileFMessage(md5List), delete fmsg and fconv, talker size = " + localHashSet.size());
      paramList = localHashSet.iterator();
      while (paramList.hasNext()) {
        pN((String)paramList.next());
      }
    }
  }
  
  public static void ai(List<a> paramList)
  {
    if (paramList == null)
    {
      y.e("MicroMsg.FriendLogic", "sync address book failed, null info list");
      return;
    }
    ((b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).Q(paramList);
  }
  
  public static void aj(List<String> paramList)
  {
    if (paramList == null)
    {
      y.e("MicroMsg.FriendLogic", "set uploaded mobile contact failed, null info list");
      return;
    }
    ((b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).ag(paramList);
  }
  
  public static Bitmap b(String paramString, Context paramContext)
  {
    return com.tencent.mm.pluginsdk.a.a(paramString, paramContext, false);
  }
  
  public static boolean jY(int paramInt)
  {
    am localam = ((an)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).jZ(paramInt);
    boolean bool = ((ap)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).ka(paramInt);
    if (localam == null) {
      return false;
    }
    return (localam.fgT == 1) || (bool);
  }
  
  private static void pN(String paramString)
  {
    y.i("MicroMsg.FriendLogic", "clearFMsgAndFConvByTalker, rowId: %d, talker: %s", new Object[] { Long.valueOf(0L), paramString });
    boolean bool = ((j)com.tencent.mm.kernel.g.r(j.class)).bhM().p(0L, paramString);
    y.i("MicroMsg.FriendLogic", "clearFMsgAndFConvByTalker, delete fconversation, ret = " + bool);
    bool = ((j)com.tencent.mm.kernel.g.r(j.class)).bhN().Hr(paramString);
    y.i("MicroMsg.FriendLogic", "clearFMsgAndFConvByTalker, delete fmsginfo, ret = " + bool);
  }
  
  public static String pO(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return "";
    }
    Object localObject = (b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg();
    paramString = "select addr_upload2.realname from addr_upload2 where addr_upload2.id = \"" + a.pF(paramString) + "\"";
    localObject = ((b)localObject).dXo.a(paramString, null, 2);
    if (localObject == null) {
      return "";
    }
    paramString = "";
    if (((Cursor)localObject).moveToFirst()) {
      paramString = ((Cursor)localObject).getString(0);
    }
    ((Cursor)localObject).close();
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.l
 * JD-Core Version:    0.7.0.1
 */