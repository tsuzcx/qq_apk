package com.tencent.mm.plugin.account;

import com.tencent.mm.ah.e.d;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.account.friend.a.an;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.account.friend.a.d;
import com.tencent.mm.plugin.account.friend.a.f;
import com.tencent.mm.plugin.account.friend.a.h;
import com.tencent.mm.plugin.account.friend.a.k;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.plugin.account.friend.a.q;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.protocal.c.auc;
import java.util.HashMap;
import java.util.LinkedList;

public class b
  implements ar
{
  private static HashMap<Integer, h.d> dgp;
  private com.tencent.mm.plugin.account.friend.a.b eZZ;
  private h faa;
  private k fab;
  private an fac;
  private ap fad;
  private q fae;
  private o faf;
  private d fag = new d();
  private LinkedList<auc> fah = null;
  private com.tencent.mm.plugin.account.friend.a.c fai = new com.tencent.mm.plugin.account.friend.a.c();
  private com.tencent.mm.plugin.account.friend.a.e faj = new com.tencent.mm.plugin.account.friend.a.e();
  private f fak = new f();
  private com.tencent.mm.sdk.b.c fal = new b.1(this);
  private com.tencent.mm.sdk.b.c fam = new b.5(this);
  private com.tencent.mm.sdk.b.c fan = new b.6(this);
  private com.tencent.mm.sdk.b.c fao = new b.3(this);
  
  static
  {
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("ADDR_UPLOAD_TABLE".hashCode()), new b.7());
    dgp.put(Integer.valueOf("FACE_BOOK_FIREND_TABLE".hashCode()), new b.8());
    dgp.put(Integer.valueOf("FRIEND_EXT_TABLE".hashCode()), new b.9());
    dgp.put(Integer.valueOf("QQ_GROUP_TABLE".hashCode()), new b.10());
    dgp.put(Integer.valueOf("QQ_LIST_TABLE".hashCode()), new b.11());
    dgp.put(Integer.valueOf("INVITEFRIENDOPEN_TABLE".hashCode()), new b.12());
    dgp.put(Integer.valueOf("GOOGLE_FRIEND_TABLE".hashCode()), new b.2());
  }
  
  private static b VU()
  {
    try
    {
      b localb = (b)p.B(b.class);
      return localb;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void clearFriendData()
  {
    g.DN().CX();
    VU().fah = null;
  }
  
  public static com.tencent.mm.plugin.account.friend.a.b getAddrUploadStg()
  {
    g.DN().CX();
    if (VU().eZZ == null) {
      VU().eZZ = new com.tencent.mm.plugin.account.friend.a.b(g.DP().dKu);
    }
    return VU().eZZ;
  }
  
  public static h getFacebookFrdStg()
  {
    g.DN().CX();
    if (VU().faa == null) {
      VU().faa = new h(g.DP().dKu);
    }
    return VU().faa;
  }
  
  public static k getFrdExtStg()
  {
    g.DN().CX();
    if (VU().fab == null) {
      VU().fab = new k(g.DP().dKu);
    }
    return VU().fab;
  }
  
  public static LinkedList<auc> getFriendData()
  {
    g.DN().CX();
    return VU().fah;
  }
  
  public static o getGoogleFriendStorage()
  {
    g.DN().CX();
    if (VU().faf == null) {
      VU().faf = new o(g.DP().dKu);
    }
    return VU().faf;
  }
  
  public static q getInviteFriendOpenStg()
  {
    g.DN().CX();
    if (VU().fae == null) {
      VU().fae = new q(g.DP().dKu);
    }
    return VU().fae;
  }
  
  public static an getQQGroupStg()
  {
    g.DN().CX();
    if (VU().fac == null) {
      VU().fac = new an(g.DP().dKu);
    }
    return VU().fac;
  }
  
  public static ap getQQListStg()
  {
    g.DN().CX();
    if (VU().fad == null) {
      VU().fad = new ap(g.DP().dKu);
    }
    return VU().fad;
  }
  
  public static void setFriendData(LinkedList<auc> paramLinkedList)
  {
    g.DN().CX();
    VU().fah = paramLinkedList;
  }
  
  public final void bh(boolean paramBoolean)
  {
    e.d.a(Integer.valueOf(42), this.fag);
    e.d.a(Integer.valueOf(66), this.fag);
    com.tencent.mm.sdk.b.a.udP.c(this.fao);
    com.tencent.mm.sdk.b.a.udP.c(this.fan);
    com.tencent.mm.sdk.b.a.udP.c(this.fai);
    com.tencent.mm.sdk.b.a.udP.c(this.faj);
    com.tencent.mm.sdk.b.a.udP.c(this.fak);
    com.tencent.mm.sdk.b.a.udP.c(this.fal);
    com.tencent.mm.sdk.b.a.udP.c(this.fam);
    ((n)g.t(n.class)).getFTSTaskDaemon().a(-86016, new b.4(this));
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.fao);
    com.tencent.mm.sdk.b.a.udP.d(this.fan);
    com.tencent.mm.sdk.b.a.udP.d(this.fai);
    com.tencent.mm.sdk.b.a.udP.d(this.faj);
    com.tencent.mm.sdk.b.a.udP.d(this.fak);
    com.tencent.mm.sdk.b.a.udP.d(this.fal);
    com.tencent.mm.sdk.b.a.udP.d(this.fam);
    e.d.b(Integer.valueOf(42), this.fag);
    e.d.b(Integer.valueOf(66), this.fag);
    this.fah = null;
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return dgp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.b
 * JD-Core Version:    0.7.0.1
 */