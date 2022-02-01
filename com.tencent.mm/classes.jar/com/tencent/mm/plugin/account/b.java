package com.tencent.mm.plugin.account;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.ac.a;
import com.tencent.mm.an.h.d;
import com.tencent.mm.f.a.bm;
import com.tencent.mm.f.a.vm;
import com.tencent.mm.model.be;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.account.friend.a.ar;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.account.friend.a.c;
import com.tencent.mm.plugin.account.friend.a.e;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.plugin.account.friend.a.q;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.protocal.protobuf.crg;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.LinkedList;

public class b
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.plugin.account.friend.a.k mQA;
  private ar mQB;
  private at mQC;
  private q mQD;
  private o mQE;
  private ap mQF;
  private com.tencent.mm.plugin.account.friend.a.d mQG;
  private LinkedList<crg> mQH;
  private c mQI;
  private e mQJ;
  private com.tencent.mm.plugin.account.friend.a.f mQK;
  private IListener mQL;
  private IListener mQM;
  private IListener mQN;
  private IListener mQO;
  private com.tencent.mm.plugin.account.friend.a.b mQy;
  private com.tencent.mm.plugin.account.friend.a.h mQz;
  
  static
  {
    AppMethodBeat.i(127798);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("ADDR_UPLOAD_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.account.friend.a.b.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("FACE_BOOK_FIREND_TABLE".hashCode()), new b.10());
    baseDBFactories.put(Integer.valueOf("FRIEND_EXT_TABLE".hashCode()), new b.11());
    baseDBFactories.put(Integer.valueOf("QQ_GROUP_TABLE".hashCode()), new b.12());
    baseDBFactories.put(Integer.valueOf("QQ_LIST_TABLE".hashCode()), new b.13());
    baseDBFactories.put(Integer.valueOf("INVITEFRIENDOPEN_TABLE".hashCode()), new b.14());
    baseDBFactories.put(Integer.valueOf("GOOGLE_FRIEND_TABLE".hashCode()), new b.2());
    baseDBFactories.put(Integer.valueOf("OLD_ACCOUNT_FRIEND_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return ap.SQL_CREATE;
      }
    });
    AppMethodBeat.o(127798);
  }
  
  public b()
  {
    AppMethodBeat.i(127784);
    this.mQG = new com.tencent.mm.plugin.account.friend.a.d();
    this.mQH = null;
    this.mQI = new c();
    this.mQJ = new e();
    this.mQK = new com.tencent.mm.plugin.account.friend.a.f();
    this.mQL = new IListener() {};
    this.mQM = new b.7(this);
    this.mQN = new b.8(this);
    this.mQO = new IListener() {};
    AppMethodBeat.o(127784);
  }
  
  private static b bxk()
  {
    try
    {
      AppMethodBeat.i(127785);
      b localb = (b)y.as(b.class);
      AppMethodBeat.o(127785);
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
    AppMethodBeat.i(127794);
    com.tencent.mm.kernel.h.aHE().aGH();
    bxk().mQH = null;
    AppMethodBeat.o(127794);
  }
  
  public static com.tencent.mm.plugin.account.friend.a.b getAddrUploadStg()
  {
    AppMethodBeat.i(127786);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (bxk().mQy == null) {
      bxk().mQy = new com.tencent.mm.plugin.account.friend.a.b(com.tencent.mm.kernel.h.aHG().kcF);
    }
    com.tencent.mm.plugin.account.friend.a.b localb = bxk().mQy;
    AppMethodBeat.o(127786);
    return localb;
  }
  
  public static com.tencent.mm.plugin.account.friend.a.h getFacebookFrdStg()
  {
    AppMethodBeat.i(127787);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (bxk().mQz == null) {
      bxk().mQz = new com.tencent.mm.plugin.account.friend.a.h(com.tencent.mm.kernel.h.aHG().kcF);
    }
    com.tencent.mm.plugin.account.friend.a.h localh = bxk().mQz;
    AppMethodBeat.o(127787);
    return localh;
  }
  
  public static com.tencent.mm.plugin.account.friend.a.k getFrdExtStg()
  {
    AppMethodBeat.i(127788);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (bxk().mQA == null) {
      bxk().mQA = new com.tencent.mm.plugin.account.friend.a.k(com.tencent.mm.kernel.h.aHG().kcF);
    }
    com.tencent.mm.plugin.account.friend.a.k localk = bxk().mQA;
    AppMethodBeat.o(127788);
    return localk;
  }
  
  public static LinkedList<crg> getFriendData()
  {
    AppMethodBeat.i(127793);
    com.tencent.mm.kernel.h.aHE().aGH();
    LinkedList localLinkedList = bxk().mQH;
    AppMethodBeat.o(127793);
    return localLinkedList;
  }
  
  public static o getGoogleFriendStorage()
  {
    AppMethodBeat.i(127797);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (bxk().mQE == null) {
      bxk().mQE = new o(com.tencent.mm.kernel.h.aHG().kcF);
    }
    o localo = bxk().mQE;
    AppMethodBeat.o(127797);
    return localo;
  }
  
  public static q getInviteFriendOpenStg()
  {
    AppMethodBeat.i(127790);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (bxk().mQD == null) {
      bxk().mQD = new q(com.tencent.mm.kernel.h.aHG().kcF);
    }
    q localq = bxk().mQD;
    AppMethodBeat.o(127790);
    return localq;
  }
  
  public static ap getOldAccountFriendStorage()
  {
    AppMethodBeat.i(184137);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (bxk().mQF == null) {
      bxk().mQF = new ap(com.tencent.mm.kernel.h.aHG().kcF);
    }
    ap localap = bxk().mQF;
    AppMethodBeat.o(184137);
    return localap;
  }
  
  public static ar getQQGroupStg()
  {
    AppMethodBeat.i(127789);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (bxk().mQB == null) {
      bxk().mQB = new ar(com.tencent.mm.kernel.h.aHG().kcF);
    }
    ar localar = bxk().mQB;
    AppMethodBeat.o(127789);
    return localar;
  }
  
  public static at getQQListStg()
  {
    AppMethodBeat.i(127791);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (bxk().mQC == null) {
      bxk().mQC = new at(com.tencent.mm.kernel.h.aHG().kcF);
    }
    at localat = bxk().mQC;
    AppMethodBeat.o(127791);
    return localat;
  }
  
  public static void setFriendData(LinkedList<crg> paramLinkedList)
  {
    AppMethodBeat.i(127792);
    com.tencent.mm.kernel.h.aHE().aGH();
    bxk().mQH = paramLinkedList;
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
    h.d.a(Integer.valueOf(42), this.mQG);
    h.d.a(Integer.valueOf(66), this.mQG);
    EventCenter.instance.addListener(this.mQO);
    EventCenter.instance.addListener(this.mQN);
    EventCenter.instance.addListener(this.mQI);
    EventCenter.instance.addListener(this.mQJ);
    EventCenter.instance.addListener(this.mQK);
    EventCenter.instance.addListener(this.mQL);
    EventCenter.instance.addListener(this.mQM);
    ((n)com.tencent.mm.kernel.h.ag(n.class)).getFTSTaskDaemon().a(-86016, new com.tencent.mm.plugin.fts.a.a.a()
    {
      public final boolean aEv()
      {
        AppMethodBeat.i(184136);
        Object localObject = new com.tencent.mm.y.a();
        ((n)com.tencent.mm.kernel.h.ag(n.class)).registerIndexStorage((i)localObject);
        ((i)localObject).create();
        localObject = new com.tencent.mm.y.b();
        ((n)com.tencent.mm.kernel.h.ag(n.class)).registerNativeLogic(9, (com.tencent.mm.plugin.fts.a.k)localObject);
        ((com.tencent.mm.plugin.fts.a.k)localObject).create();
        localObject = new com.tencent.mm.y.a.a();
        ((n)com.tencent.mm.kernel.h.ag(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
        AppMethodBeat.o(184136);
        return true;
      }
      
      public final String getName()
      {
        return "InitFTSFriendPluginTask";
      }
    });
    com.tencent.mm.an.ac.lDJ = new ac.a()
    {
      public final boolean biO()
      {
        AppMethodBeat.i(218783);
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wbi, 0) == 0)
        {
          AppMethodBeat.o(218783);
          return true;
        }
        AppMethodBeat.o(218783);
        return false;
      }
    };
    AppMethodBeat.o(127796);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(127795);
    EventCenter.instance.removeListener(this.mQO);
    EventCenter.instance.removeListener(this.mQN);
    EventCenter.instance.removeListener(this.mQI);
    EventCenter.instance.removeListener(this.mQJ);
    EventCenter.instance.removeListener(this.mQK);
    EventCenter.instance.removeListener(this.mQL);
    EventCenter.instance.removeListener(this.mQM);
    h.d.b(Integer.valueOf(42), this.mQG);
    h.d.b(Integer.valueOf(66), this.mQG);
    this.mQH = null;
    AppMethodBeat.o(127795);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.b
 * JD-Core Version:    0.7.0.1
 */