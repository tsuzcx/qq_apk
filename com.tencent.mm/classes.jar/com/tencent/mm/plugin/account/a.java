package com.tencent.mm.plugin.account;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.d;
import com.tencent.mm.g.a.bf;
import com.tencent.mm.g.a.iv;
import com.tencent.mm.g.a.jh;
import com.tencent.mm.g.a.tk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
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
import com.tencent.mm.protocal.protobuf.buj;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.LinkedList;

public class a
  implements ax
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.sdk.b.c iYA;
  private com.tencent.mm.sdk.b.c iYB;
  private b iYl;
  private h iYm;
  private k iYn;
  private ar iYo;
  private at iYp;
  private q iYq;
  private o iYr;
  private ap iYs;
  private d iYt;
  private LinkedList<buj> iYu;
  private com.tencent.mm.plugin.account.friend.a.c iYv;
  private com.tencent.mm.plugin.account.friend.a.e iYw;
  private f iYx;
  private com.tencent.mm.sdk.b.c iYy;
  private com.tencent.mm.sdk.b.c iYz;
  
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
    baseDBFactories.put(Integer.valueOf("INVITEFRIENDOPEN_TABLE".hashCode()), new a.13());
    baseDBFactories.put(Integer.valueOf("GOOGLE_FRIEND_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return o.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("OLD_ACCOUNT_FRIEND_TABLE".hashCode()), new a.3());
    AppMethodBeat.o(127798);
  }
  
  public a()
  {
    AppMethodBeat.i(127784);
    this.iYt = new d();
    this.iYu = null;
    this.iYv = new com.tencent.mm.plugin.account.friend.a.c();
    this.iYw = new com.tencent.mm.plugin.account.friend.a.e();
    this.iYx = new f();
    this.iYy = new com.tencent.mm.sdk.b.c() {};
    this.iYz = new com.tencent.mm.sdk.b.c() {};
    this.iYA = new com.tencent.mm.sdk.b.c() {};
    this.iYB = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(127784);
  }
  
  private static a aRP()
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
    g.ajA().aiF();
    aRP().iYu = null;
    AppMethodBeat.o(127794);
  }
  
  public static b getAddrUploadStg()
  {
    AppMethodBeat.i(127786);
    g.ajA().aiF();
    if (aRP().iYl == null) {
      aRP().iYl = new b(g.ajC().gBq);
    }
    b localb = aRP().iYl;
    AppMethodBeat.o(127786);
    return localb;
  }
  
  public static h getFacebookFrdStg()
  {
    AppMethodBeat.i(127787);
    g.ajA().aiF();
    if (aRP().iYm == null) {
      aRP().iYm = new h(g.ajC().gBq);
    }
    h localh = aRP().iYm;
    AppMethodBeat.o(127787);
    return localh;
  }
  
  public static k getFrdExtStg()
  {
    AppMethodBeat.i(127788);
    g.ajA().aiF();
    if (aRP().iYn == null) {
      aRP().iYn = new k(g.ajC().gBq);
    }
    k localk = aRP().iYn;
    AppMethodBeat.o(127788);
    return localk;
  }
  
  public static LinkedList<buj> getFriendData()
  {
    AppMethodBeat.i(127793);
    g.ajA().aiF();
    LinkedList localLinkedList = aRP().iYu;
    AppMethodBeat.o(127793);
    return localLinkedList;
  }
  
  public static o getGoogleFriendStorage()
  {
    AppMethodBeat.i(127797);
    g.ajA().aiF();
    if (aRP().iYr == null) {
      aRP().iYr = new o(g.ajC().gBq);
    }
    o localo = aRP().iYr;
    AppMethodBeat.o(127797);
    return localo;
  }
  
  public static q getInviteFriendOpenStg()
  {
    AppMethodBeat.i(127790);
    g.ajA().aiF();
    if (aRP().iYq == null) {
      aRP().iYq = new q(g.ajC().gBq);
    }
    q localq = aRP().iYq;
    AppMethodBeat.o(127790);
    return localq;
  }
  
  public static ap getOldAccountFriendStorage()
  {
    AppMethodBeat.i(184137);
    g.ajA().aiF();
    if (aRP().iYs == null) {
      aRP().iYs = new ap(g.ajC().gBq);
    }
    ap localap = aRP().iYs;
    AppMethodBeat.o(184137);
    return localap;
  }
  
  public static ar getQQGroupStg()
  {
    AppMethodBeat.i(127789);
    g.ajA().aiF();
    if (aRP().iYo == null) {
      aRP().iYo = new ar(g.ajC().gBq);
    }
    ar localar = aRP().iYo;
    AppMethodBeat.o(127789);
    return localar;
  }
  
  public static at getQQListStg()
  {
    AppMethodBeat.i(127791);
    g.ajA().aiF();
    if (aRP().iYp == null) {
      aRP().iYp = new at(g.ajC().gBq);
    }
    at localat = aRP().iYp;
    AppMethodBeat.o(127791);
    return localat;
  }
  
  public static void setFriendData(LinkedList<buj> paramLinkedList)
  {
    AppMethodBeat.i(127792);
    g.ajA().aiF();
    aRP().iYu = paramLinkedList;
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
    e.d.a(Integer.valueOf(42), this.iYt);
    e.d.a(Integer.valueOf(66), this.iYt);
    com.tencent.mm.sdk.b.a.IbL.c(this.iYB);
    com.tencent.mm.sdk.b.a.IbL.c(this.iYA);
    com.tencent.mm.sdk.b.a.IbL.c(this.iYv);
    com.tencent.mm.sdk.b.a.IbL.c(this.iYw);
    com.tencent.mm.sdk.b.a.IbL.c(this.iYx);
    com.tencent.mm.sdk.b.a.IbL.c(this.iYy);
    com.tencent.mm.sdk.b.a.IbL.c(this.iYz);
    ((n)g.ad(n.class)).getFTSTaskDaemon().a(-86016, new a.5(this));
    AppMethodBeat.o(127796);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(127795);
    com.tencent.mm.sdk.b.a.IbL.d(this.iYB);
    com.tencent.mm.sdk.b.a.IbL.d(this.iYA);
    com.tencent.mm.sdk.b.a.IbL.d(this.iYv);
    com.tencent.mm.sdk.b.a.IbL.d(this.iYw);
    com.tencent.mm.sdk.b.a.IbL.d(this.iYx);
    com.tencent.mm.sdk.b.a.IbL.d(this.iYy);
    com.tencent.mm.sdk.b.a.IbL.d(this.iYz);
    e.d.b(Integer.valueOf(42), this.iYt);
    e.d.b(Integer.valueOf(66), this.iYt);
    this.iYu = null;
    AppMethodBeat.o(127795);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.a
 * JD-Core Version:    0.7.0.1
 */