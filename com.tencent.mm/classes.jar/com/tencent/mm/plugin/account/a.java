package com.tencent.mm.plugin.account;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.d;
import com.tencent.mm.g.a.bf;
import com.tencent.mm.g.a.iw;
import com.tencent.mm.g.a.ji;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
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
import com.tencent.mm.protocal.protobuf.bvd;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.LinkedList;

public class a
  implements az
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private b jbe;
  private h jbf;
  private k jbg;
  private ar jbh;
  private at jbi;
  private q jbj;
  private o jbk;
  private ap jbl;
  private d jbm;
  private LinkedList<bvd> jbn;
  private com.tencent.mm.plugin.account.friend.a.c jbo;
  private com.tencent.mm.plugin.account.friend.a.e jbp;
  private f jbq;
  private com.tencent.mm.sdk.b.c jbr;
  private com.tencent.mm.sdk.b.c jbs;
  private com.tencent.mm.sdk.b.c jbt;
  private com.tencent.mm.sdk.b.c jbu;
  
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
    this.jbm = new d();
    this.jbn = null;
    this.jbo = new com.tencent.mm.plugin.account.friend.a.c();
    this.jbp = new com.tencent.mm.plugin.account.friend.a.e();
    this.jbq = new f();
    this.jbr = new com.tencent.mm.sdk.b.c() {};
    this.jbs = new com.tencent.mm.sdk.b.c() {};
    this.jbt = new com.tencent.mm.sdk.b.c() {};
    this.jbu = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(127784);
  }
  
  private static a aSo()
  {
    try
    {
      AppMethodBeat.i(127785);
      a locala = (a)u.ap(a.class);
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
    g.ajP().aiU();
    aSo().jbn = null;
    AppMethodBeat.o(127794);
  }
  
  public static b getAddrUploadStg()
  {
    AppMethodBeat.i(127786);
    g.ajP().aiU();
    if (aSo().jbe == null) {
      aSo().jbe = new b(g.ajR().gDX);
    }
    b localb = aSo().jbe;
    AppMethodBeat.o(127786);
    return localb;
  }
  
  public static h getFacebookFrdStg()
  {
    AppMethodBeat.i(127787);
    g.ajP().aiU();
    if (aSo().jbf == null) {
      aSo().jbf = new h(g.ajR().gDX);
    }
    h localh = aSo().jbf;
    AppMethodBeat.o(127787);
    return localh;
  }
  
  public static k getFrdExtStg()
  {
    AppMethodBeat.i(127788);
    g.ajP().aiU();
    if (aSo().jbg == null) {
      aSo().jbg = new k(g.ajR().gDX);
    }
    k localk = aSo().jbg;
    AppMethodBeat.o(127788);
    return localk;
  }
  
  public static LinkedList<bvd> getFriendData()
  {
    AppMethodBeat.i(127793);
    g.ajP().aiU();
    LinkedList localLinkedList = aSo().jbn;
    AppMethodBeat.o(127793);
    return localLinkedList;
  }
  
  public static o getGoogleFriendStorage()
  {
    AppMethodBeat.i(127797);
    g.ajP().aiU();
    if (aSo().jbk == null) {
      aSo().jbk = new o(g.ajR().gDX);
    }
    o localo = aSo().jbk;
    AppMethodBeat.o(127797);
    return localo;
  }
  
  public static q getInviteFriendOpenStg()
  {
    AppMethodBeat.i(127790);
    g.ajP().aiU();
    if (aSo().jbj == null) {
      aSo().jbj = new q(g.ajR().gDX);
    }
    q localq = aSo().jbj;
    AppMethodBeat.o(127790);
    return localq;
  }
  
  public static ap getOldAccountFriendStorage()
  {
    AppMethodBeat.i(184137);
    g.ajP().aiU();
    if (aSo().jbl == null) {
      aSo().jbl = new ap(g.ajR().gDX);
    }
    ap localap = aSo().jbl;
    AppMethodBeat.o(184137);
    return localap;
  }
  
  public static ar getQQGroupStg()
  {
    AppMethodBeat.i(127789);
    g.ajP().aiU();
    if (aSo().jbh == null) {
      aSo().jbh = new ar(g.ajR().gDX);
    }
    ar localar = aSo().jbh;
    AppMethodBeat.o(127789);
    return localar;
  }
  
  public static at getQQListStg()
  {
    AppMethodBeat.i(127791);
    g.ajP().aiU();
    if (aSo().jbi == null) {
      aSo().jbi = new at(g.ajR().gDX);
    }
    at localat = aSo().jbi;
    AppMethodBeat.o(127791);
    return localat;
  }
  
  public static void setFriendData(LinkedList<bvd> paramLinkedList)
  {
    AppMethodBeat.i(127792);
    g.ajP().aiU();
    aSo().jbn = paramLinkedList;
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
    e.d.a(Integer.valueOf(42), this.jbm);
    e.d.a(Integer.valueOf(66), this.jbm);
    com.tencent.mm.sdk.b.a.IvT.c(this.jbu);
    com.tencent.mm.sdk.b.a.IvT.c(this.jbt);
    com.tencent.mm.sdk.b.a.IvT.c(this.jbo);
    com.tencent.mm.sdk.b.a.IvT.c(this.jbp);
    com.tencent.mm.sdk.b.a.IvT.c(this.jbq);
    com.tencent.mm.sdk.b.a.IvT.c(this.jbr);
    com.tencent.mm.sdk.b.a.IvT.c(this.jbs);
    ((n)g.ad(n.class)).getFTSTaskDaemon().a(-86016, new a.5(this));
    AppMethodBeat.o(127796);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(127795);
    com.tencent.mm.sdk.b.a.IvT.d(this.jbu);
    com.tencent.mm.sdk.b.a.IvT.d(this.jbt);
    com.tencent.mm.sdk.b.a.IvT.d(this.jbo);
    com.tencent.mm.sdk.b.a.IvT.d(this.jbp);
    com.tencent.mm.sdk.b.a.IvT.d(this.jbq);
    com.tencent.mm.sdk.b.a.IvT.d(this.jbr);
    com.tencent.mm.sdk.b.a.IvT.d(this.jbs);
    e.d.b(Integer.valueOf(42), this.jbm);
    e.d.b(Integer.valueOf(66), this.jbm);
    this.jbn = null;
    AppMethodBeat.o(127795);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.a
 * JD-Core Version:    0.7.0.1
 */