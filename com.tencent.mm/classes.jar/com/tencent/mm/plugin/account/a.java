package com.tencent.mm.plugin.account;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.d;
import com.tencent.mm.g.a.bb;
import com.tencent.mm.g.a.ig;
import com.tencent.mm.g.a.is;
import com.tencent.mm.g.a.sk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.account.friend.a.ar;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.account.friend.a.b;
import com.tencent.mm.plugin.account.friend.a.d;
import com.tencent.mm.plugin.account.friend.a.f;
import com.tencent.mm.plugin.account.friend.a.h;
import com.tencent.mm.plugin.account.friend.a.k;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.plugin.account.friend.a.q;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.protocal.protobuf.bly;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.LinkedList;

public class a
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private b ieT;
  private h ieU;
  private k ieV;
  private ar ieW;
  private at ieX;
  private q ieY;
  private o ieZ;
  private ap ifa;
  private d ifb;
  private LinkedList<bly> ifc;
  private com.tencent.mm.plugin.account.friend.a.c ifd;
  private com.tencent.mm.plugin.account.friend.a.e ife;
  private f iff;
  private com.tencent.mm.sdk.b.c ifg;
  private com.tencent.mm.sdk.b.c ifh;
  private com.tencent.mm.sdk.b.c ifi;
  private com.tencent.mm.sdk.b.c ifj;
  
  static
  {
    AppMethodBeat.i(127798);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("ADDR_UPLOAD_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return b.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("FACE_BOOK_FIREND_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return h.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("FRIEND_EXT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return k.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("QQ_GROUP_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return ar.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("QQ_LIST_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return at.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("INVITEFRIENDOPEN_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return q.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("GOOGLE_FRIEND_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return o.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("OLD_ACCOUNT_FRIEND_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return ap.SQL_CREATE;
      }
    });
    AppMethodBeat.o(127798);
  }
  
  public a()
  {
    AppMethodBeat.i(127784);
    this.ifb = new d();
    this.ifc = null;
    this.ifd = new com.tencent.mm.plugin.account.friend.a.c();
    this.ife = new com.tencent.mm.plugin.account.friend.a.e();
    this.iff = new f();
    this.ifg = new com.tencent.mm.sdk.b.c() {};
    this.ifh = new com.tencent.mm.sdk.b.c() {};
    this.ifi = new com.tencent.mm.sdk.b.c() {};
    this.ifj = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(127784);
  }
  
  private static a aHM()
  {
    try
    {
      AppMethodBeat.i(127785);
      a locala = (a)t.ap(a.class);
      AppMethodBeat.o(127785);
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void clearFriendData()
  {
    AppMethodBeat.i(127794);
    g.afz().aeD();
    aHM().ifc = null;
    AppMethodBeat.o(127794);
  }
  
  public static b getAddrUploadStg()
  {
    AppMethodBeat.i(127786);
    g.afz().aeD();
    if (aHM().ieT == null) {
      aHM().ieT = new b(g.afB().gda);
    }
    b localb = aHM().ieT;
    AppMethodBeat.o(127786);
    return localb;
  }
  
  public static h getFacebookFrdStg()
  {
    AppMethodBeat.i(127787);
    g.afz().aeD();
    if (aHM().ieU == null) {
      aHM().ieU = new h(g.afB().gda);
    }
    h localh = aHM().ieU;
    AppMethodBeat.o(127787);
    return localh;
  }
  
  public static k getFrdExtStg()
  {
    AppMethodBeat.i(127788);
    g.afz().aeD();
    if (aHM().ieV == null) {
      aHM().ieV = new k(g.afB().gda);
    }
    k localk = aHM().ieV;
    AppMethodBeat.o(127788);
    return localk;
  }
  
  public static LinkedList<bly> getFriendData()
  {
    AppMethodBeat.i(127793);
    g.afz().aeD();
    LinkedList localLinkedList = aHM().ifc;
    AppMethodBeat.o(127793);
    return localLinkedList;
  }
  
  public static o getGoogleFriendStorage()
  {
    AppMethodBeat.i(127797);
    g.afz().aeD();
    if (aHM().ieZ == null) {
      aHM().ieZ = new o(g.afB().gda);
    }
    o localo = aHM().ieZ;
    AppMethodBeat.o(127797);
    return localo;
  }
  
  public static q getInviteFriendOpenStg()
  {
    AppMethodBeat.i(127790);
    g.afz().aeD();
    if (aHM().ieY == null) {
      aHM().ieY = new q(g.afB().gda);
    }
    q localq = aHM().ieY;
    AppMethodBeat.o(127790);
    return localq;
  }
  
  public static ap getOldAccountFriendStorage()
  {
    AppMethodBeat.i(184137);
    g.afz().aeD();
    if (aHM().ifa == null) {
      aHM().ifa = new ap(g.afB().gda);
    }
    ap localap = aHM().ifa;
    AppMethodBeat.o(184137);
    return localap;
  }
  
  public static ar getQQGroupStg()
  {
    AppMethodBeat.i(127789);
    g.afz().aeD();
    if (aHM().ieW == null) {
      aHM().ieW = new ar(g.afB().gda);
    }
    ar localar = aHM().ieW;
    AppMethodBeat.o(127789);
    return localar;
  }
  
  public static at getQQListStg()
  {
    AppMethodBeat.i(127791);
    g.afz().aeD();
    if (aHM().ieX == null) {
      aHM().ieX = new at(g.afB().gda);
    }
    at localat = aHM().ieX;
    AppMethodBeat.o(127791);
    return localat;
  }
  
  public static void setFriendData(LinkedList<bly> paramLinkedList)
  {
    AppMethodBeat.i(127792);
    g.afz().aeD();
    aHM().ifc = paramLinkedList;
    AppMethodBeat.o(127792);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(127796);
    f.d.a(Integer.valueOf(42), this.ifb);
    f.d.a(Integer.valueOf(66), this.ifb);
    com.tencent.mm.sdk.b.a.ESL.c(this.ifj);
    com.tencent.mm.sdk.b.a.ESL.c(this.ifi);
    com.tencent.mm.sdk.b.a.ESL.c(this.ifd);
    com.tencent.mm.sdk.b.a.ESL.c(this.ife);
    com.tencent.mm.sdk.b.a.ESL.c(this.iff);
    com.tencent.mm.sdk.b.a.ESL.c(this.ifg);
    com.tencent.mm.sdk.b.a.ESL.c(this.ifh);
    ((n)g.ad(n.class)).getFTSTaskDaemon().a(-86016, new a.5(this));
    AppMethodBeat.o(127796);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(127795);
    com.tencent.mm.sdk.b.a.ESL.d(this.ifj);
    com.tencent.mm.sdk.b.a.ESL.d(this.ifi);
    com.tencent.mm.sdk.b.a.ESL.d(this.ifd);
    com.tencent.mm.sdk.b.a.ESL.d(this.ife);
    com.tencent.mm.sdk.b.a.ESL.d(this.iff);
    com.tencent.mm.sdk.b.a.ESL.d(this.ifg);
    com.tencent.mm.sdk.b.a.ESL.d(this.ifh);
    f.d.b(Integer.valueOf(42), this.ifb);
    f.d.b(Integer.valueOf(66), this.ifb);
    this.ifc = null;
    AppMethodBeat.o(127795);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.a
 * JD-Core Version:    0.7.0.1
 */