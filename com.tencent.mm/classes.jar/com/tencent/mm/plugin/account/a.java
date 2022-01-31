package com.tencent.mm.plugin.account;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.d;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.account.friend.a.an;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.account.friend.a.b;
import com.tencent.mm.plugin.account.friend.a.d;
import com.tencent.mm.plugin.account.friend.a.f;
import com.tencent.mm.plugin.account.friend.a.h;
import com.tencent.mm.plugin.account.friend.a.k;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.protocal.protobuf.bai;
import java.util.HashMap;
import java.util.LinkedList;

public class a
  implements at
{
  private static HashMap<Integer, h.d> baseDBFactories;
  private b grS;
  private h grT;
  private k grU;
  private an grV;
  private ap grW;
  private com.tencent.mm.plugin.account.friend.a.q grX;
  private o grY;
  private d grZ;
  private LinkedList<bai> gsa;
  private com.tencent.mm.plugin.account.friend.a.c gsb;
  private com.tencent.mm.plugin.account.friend.a.e gsc;
  private f gsd;
  private com.tencent.mm.sdk.b.c gse;
  private com.tencent.mm.sdk.b.c gsf;
  private com.tencent.mm.sdk.b.c gsg;
  private com.tencent.mm.sdk.b.c gsh;
  
  static
  {
    AppMethodBeat.i(124644);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("ADDR_UPLOAD_TABLE".hashCode()), new a.7());
    baseDBFactories.put(Integer.valueOf("FACE_BOOK_FIREND_TABLE".hashCode()), new a.8());
    baseDBFactories.put(Integer.valueOf("FRIEND_EXT_TABLE".hashCode()), new a.9());
    baseDBFactories.put(Integer.valueOf("QQ_GROUP_TABLE".hashCode()), new a.10());
    baseDBFactories.put(Integer.valueOf("QQ_LIST_TABLE".hashCode()), new a.11());
    baseDBFactories.put(Integer.valueOf("INVITEFRIENDOPEN_TABLE".hashCode()), new h.d()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.account.friend.a.q.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("GOOGLE_FRIEND_TABLE".hashCode()), new a.2());
    AppMethodBeat.o(124644);
  }
  
  public a()
  {
    AppMethodBeat.i(124630);
    this.grZ = new d();
    this.gsa = null;
    this.gsb = new com.tencent.mm.plugin.account.friend.a.c();
    this.gsc = new com.tencent.mm.plugin.account.friend.a.e();
    this.gsd = new f();
    this.gse = new a.1(this);
    this.gsf = new a.5(this);
    this.gsg = new a.6(this);
    this.gsh = new a.3(this);
    AppMethodBeat.o(124630);
  }
  
  private static a apq()
  {
    try
    {
      AppMethodBeat.i(124631);
      a locala = (a)com.tencent.mm.model.q.S(a.class);
      AppMethodBeat.o(124631);
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
    AppMethodBeat.i(124640);
    g.RJ().QQ();
    apq().gsa = null;
    AppMethodBeat.o(124640);
  }
  
  public static b getAddrUploadStg()
  {
    AppMethodBeat.i(124632);
    g.RJ().QQ();
    if (apq().grS == null) {
      apq().grS = new b(g.RL().eHS);
    }
    b localb = apq().grS;
    AppMethodBeat.o(124632);
    return localb;
  }
  
  public static h getFacebookFrdStg()
  {
    AppMethodBeat.i(124633);
    g.RJ().QQ();
    if (apq().grT == null) {
      apq().grT = new h(g.RL().eHS);
    }
    h localh = apq().grT;
    AppMethodBeat.o(124633);
    return localh;
  }
  
  public static k getFrdExtStg()
  {
    AppMethodBeat.i(124634);
    g.RJ().QQ();
    if (apq().grU == null) {
      apq().grU = new k(g.RL().eHS);
    }
    k localk = apq().grU;
    AppMethodBeat.o(124634);
    return localk;
  }
  
  public static LinkedList<bai> getFriendData()
  {
    AppMethodBeat.i(124639);
    g.RJ().QQ();
    LinkedList localLinkedList = apq().gsa;
    AppMethodBeat.o(124639);
    return localLinkedList;
  }
  
  public static o getGoogleFriendStorage()
  {
    AppMethodBeat.i(124643);
    g.RJ().QQ();
    if (apq().grY == null) {
      apq().grY = new o(g.RL().eHS);
    }
    o localo = apq().grY;
    AppMethodBeat.o(124643);
    return localo;
  }
  
  public static com.tencent.mm.plugin.account.friend.a.q getInviteFriendOpenStg()
  {
    AppMethodBeat.i(124636);
    g.RJ().QQ();
    if (apq().grX == null) {
      apq().grX = new com.tencent.mm.plugin.account.friend.a.q(g.RL().eHS);
    }
    com.tencent.mm.plugin.account.friend.a.q localq = apq().grX;
    AppMethodBeat.o(124636);
    return localq;
  }
  
  public static an getQQGroupStg()
  {
    AppMethodBeat.i(124635);
    g.RJ().QQ();
    if (apq().grV == null) {
      apq().grV = new an(g.RL().eHS);
    }
    an localan = apq().grV;
    AppMethodBeat.o(124635);
    return localan;
  }
  
  public static ap getQQListStg()
  {
    AppMethodBeat.i(124637);
    g.RJ().QQ();
    if (apq().grW == null) {
      apq().grW = new ap(g.RL().eHS);
    }
    ap localap = apq().grW;
    AppMethodBeat.o(124637);
    return localap;
  }
  
  public static void setFriendData(LinkedList<bai> paramLinkedList)
  {
    AppMethodBeat.i(124638);
    g.RJ().QQ();
    apq().gsa = paramLinkedList;
    AppMethodBeat.o(124638);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(124642);
    e.d.a(Integer.valueOf(42), this.grZ);
    e.d.a(Integer.valueOf(66), this.grZ);
    com.tencent.mm.sdk.b.a.ymk.c(this.gsh);
    com.tencent.mm.sdk.b.a.ymk.c(this.gsg);
    com.tencent.mm.sdk.b.a.ymk.c(this.gsb);
    com.tencent.mm.sdk.b.a.ymk.c(this.gsc);
    com.tencent.mm.sdk.b.a.ymk.c(this.gsd);
    com.tencent.mm.sdk.b.a.ymk.c(this.gse);
    com.tencent.mm.sdk.b.a.ymk.c(this.gsf);
    ((n)g.G(n.class)).getFTSTaskDaemon().a(-86016, new a.4(this));
    AppMethodBeat.o(124642);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(124641);
    com.tencent.mm.sdk.b.a.ymk.d(this.gsh);
    com.tencent.mm.sdk.b.a.ymk.d(this.gsg);
    com.tencent.mm.sdk.b.a.ymk.d(this.gsb);
    com.tencent.mm.sdk.b.a.ymk.d(this.gsc);
    com.tencent.mm.sdk.b.a.ymk.d(this.gsd);
    com.tencent.mm.sdk.b.a.ymk.d(this.gse);
    com.tencent.mm.sdk.b.a.ymk.d(this.gsf);
    e.d.b(Integer.valueOf(42), this.grZ);
    e.d.b(Integer.valueOf(66), this.grZ);
    this.gsa = null;
    AppMethodBeat.o(124641);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.a
 * JD-Core Version:    0.7.0.1
 */