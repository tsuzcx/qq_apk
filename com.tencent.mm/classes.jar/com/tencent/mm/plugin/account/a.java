package com.tencent.mm.plugin.account;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.d;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.g.a.in;
import com.tencent.mm.g.a.iz;
import com.tencent.mm.g.a.st;
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
import com.tencent.mm.protocal.protobuf.bpw;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.LinkedList;

public class a
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private b iFc;
  private h iFd;
  private k iFe;
  private ar iFf;
  private at iFg;
  private q iFh;
  private o iFi;
  private ap iFj;
  private d iFk;
  private LinkedList<bpw> iFl;
  private com.tencent.mm.plugin.account.friend.a.c iFm;
  private com.tencent.mm.plugin.account.friend.a.e iFn;
  private f iFo;
  private com.tencent.mm.sdk.b.c iFp;
  private com.tencent.mm.sdk.b.c iFq;
  private com.tencent.mm.sdk.b.c iFr;
  private com.tencent.mm.sdk.b.c iFs;
  
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
    baseDBFactories.put(Integer.valueOf("OLD_ACCOUNT_FRIEND_TABLE".hashCode()), new a.3());
    AppMethodBeat.o(127798);
  }
  
  public a()
  {
    AppMethodBeat.i(127784);
    this.iFk = new d();
    this.iFl = null;
    this.iFm = new com.tencent.mm.plugin.account.friend.a.c();
    this.iFn = new com.tencent.mm.plugin.account.friend.a.e();
    this.iFo = new f();
    this.iFp = new com.tencent.mm.sdk.b.c() {};
    this.iFq = new com.tencent.mm.sdk.b.c() {};
    this.iFr = new com.tencent.mm.sdk.b.c() {};
    this.iFs = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(127784);
  }
  
  private static a aOD()
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
    g.agP().afT();
    aOD().iFl = null;
    AppMethodBeat.o(127794);
  }
  
  public static b getAddrUploadStg()
  {
    AppMethodBeat.i(127786);
    g.agP().afT();
    if (aOD().iFc == null) {
      aOD().iFc = new b(g.agR().ghG);
    }
    b localb = aOD().iFc;
    AppMethodBeat.o(127786);
    return localb;
  }
  
  public static h getFacebookFrdStg()
  {
    AppMethodBeat.i(127787);
    g.agP().afT();
    if (aOD().iFd == null) {
      aOD().iFd = new h(g.agR().ghG);
    }
    h localh = aOD().iFd;
    AppMethodBeat.o(127787);
    return localh;
  }
  
  public static k getFrdExtStg()
  {
    AppMethodBeat.i(127788);
    g.agP().afT();
    if (aOD().iFe == null) {
      aOD().iFe = new k(g.agR().ghG);
    }
    k localk = aOD().iFe;
    AppMethodBeat.o(127788);
    return localk;
  }
  
  public static LinkedList<bpw> getFriendData()
  {
    AppMethodBeat.i(127793);
    g.agP().afT();
    LinkedList localLinkedList = aOD().iFl;
    AppMethodBeat.o(127793);
    return localLinkedList;
  }
  
  public static o getGoogleFriendStorage()
  {
    AppMethodBeat.i(127797);
    g.agP().afT();
    if (aOD().iFi == null) {
      aOD().iFi = new o(g.agR().ghG);
    }
    o localo = aOD().iFi;
    AppMethodBeat.o(127797);
    return localo;
  }
  
  public static q getInviteFriendOpenStg()
  {
    AppMethodBeat.i(127790);
    g.agP().afT();
    if (aOD().iFh == null) {
      aOD().iFh = new q(g.agR().ghG);
    }
    q localq = aOD().iFh;
    AppMethodBeat.o(127790);
    return localq;
  }
  
  public static ap getOldAccountFriendStorage()
  {
    AppMethodBeat.i(184137);
    g.agP().afT();
    if (aOD().iFj == null) {
      aOD().iFj = new ap(g.agR().ghG);
    }
    ap localap = aOD().iFj;
    AppMethodBeat.o(184137);
    return localap;
  }
  
  public static ar getQQGroupStg()
  {
    AppMethodBeat.i(127789);
    g.agP().afT();
    if (aOD().iFf == null) {
      aOD().iFf = new ar(g.agR().ghG);
    }
    ar localar = aOD().iFf;
    AppMethodBeat.o(127789);
    return localar;
  }
  
  public static at getQQListStg()
  {
    AppMethodBeat.i(127791);
    g.agP().afT();
    if (aOD().iFg == null) {
      aOD().iFg = new at(g.agR().ghG);
    }
    at localat = aOD().iFg;
    AppMethodBeat.o(127791);
    return localat;
  }
  
  public static void setFriendData(LinkedList<bpw> paramLinkedList)
  {
    AppMethodBeat.i(127792);
    g.agP().afT();
    aOD().iFl = paramLinkedList;
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
    f.d.a(Integer.valueOf(42), this.iFk);
    f.d.a(Integer.valueOf(66), this.iFk);
    com.tencent.mm.sdk.b.a.GpY.c(this.iFs);
    com.tencent.mm.sdk.b.a.GpY.c(this.iFr);
    com.tencent.mm.sdk.b.a.GpY.c(this.iFm);
    com.tencent.mm.sdk.b.a.GpY.c(this.iFn);
    com.tencent.mm.sdk.b.a.GpY.c(this.iFo);
    com.tencent.mm.sdk.b.a.GpY.c(this.iFp);
    com.tencent.mm.sdk.b.a.GpY.c(this.iFq);
    ((n)g.ad(n.class)).getFTSTaskDaemon().a(-86016, new a.5(this));
    AppMethodBeat.o(127796);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(127795);
    com.tencent.mm.sdk.b.a.GpY.d(this.iFs);
    com.tencent.mm.sdk.b.a.GpY.d(this.iFr);
    com.tencent.mm.sdk.b.a.GpY.d(this.iFm);
    com.tencent.mm.sdk.b.a.GpY.d(this.iFn);
    com.tencent.mm.sdk.b.a.GpY.d(this.iFo);
    com.tencent.mm.sdk.b.a.GpY.d(this.iFp);
    com.tencent.mm.sdk.b.a.GpY.d(this.iFq);
    f.d.b(Integer.valueOf(42), this.iFk);
    f.d.b(Integer.valueOf(66), this.iFk);
    this.iFl = null;
    AppMethodBeat.o(127795);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.a
 * JD-Core Version:    0.7.0.1
 */