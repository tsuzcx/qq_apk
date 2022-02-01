package com.tencent.mm.plugin.account;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.ac.a;
import com.tencent.mm.ak.h.d;
import com.tencent.mm.g.a.bh;
import com.tencent.mm.g.a.jl;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.account.friend.a.ar;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.account.friend.a.c;
import com.tencent.mm.plugin.account.friend.a.f;
import com.tencent.mm.plugin.account.friend.a.h;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.plugin.account.friend.a.q;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.protocal.protobuf.cik;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.LinkedList;

public class a
  implements bd
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.plugin.account.friend.a.b jZh;
  private h jZi;
  private com.tencent.mm.plugin.account.friend.a.k jZj;
  private ar jZk;
  private at jZl;
  private q jZm;
  private o jZn;
  private ap jZo;
  private com.tencent.mm.plugin.account.friend.a.d jZp;
  private LinkedList<cik> jZq;
  private c jZr;
  private com.tencent.mm.plugin.account.friend.a.e jZs;
  private f jZt;
  private IListener jZu;
  private IListener jZv;
  private IListener jZw;
  private IListener jZx;
  
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
        return com.tencent.mm.plugin.account.friend.a.k.SQL_CREATE;
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
    this.jZp = new com.tencent.mm.plugin.account.friend.a.d();
    this.jZq = null;
    this.jZr = new c();
    this.jZs = new com.tencent.mm.plugin.account.friend.a.e();
    this.jZt = new f();
    this.jZu = new IListener() {};
    this.jZv = new a.7(this);
    this.jZw = new IListener() {};
    this.jZx = new IListener() {};
    AppMethodBeat.o(127784);
  }
  
  private static a bnb()
  {
    try
    {
      AppMethodBeat.i(127785);
      a locala = (a)y.at(a.class);
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
    g.aAf().azk();
    bnb().jZq = null;
    AppMethodBeat.o(127794);
  }
  
  public static com.tencent.mm.plugin.account.friend.a.b getAddrUploadStg()
  {
    AppMethodBeat.i(127786);
    g.aAf().azk();
    if (bnb().jZh == null) {
      bnb().jZh = new com.tencent.mm.plugin.account.friend.a.b(g.aAh().hqK);
    }
    com.tencent.mm.plugin.account.friend.a.b localb = bnb().jZh;
    AppMethodBeat.o(127786);
    return localb;
  }
  
  public static h getFacebookFrdStg()
  {
    AppMethodBeat.i(127787);
    g.aAf().azk();
    if (bnb().jZi == null) {
      bnb().jZi = new h(g.aAh().hqK);
    }
    h localh = bnb().jZi;
    AppMethodBeat.o(127787);
    return localh;
  }
  
  public static com.tencent.mm.plugin.account.friend.a.k getFrdExtStg()
  {
    AppMethodBeat.i(127788);
    g.aAf().azk();
    if (bnb().jZj == null) {
      bnb().jZj = new com.tencent.mm.plugin.account.friend.a.k(g.aAh().hqK);
    }
    com.tencent.mm.plugin.account.friend.a.k localk = bnb().jZj;
    AppMethodBeat.o(127788);
    return localk;
  }
  
  public static LinkedList<cik> getFriendData()
  {
    AppMethodBeat.i(127793);
    g.aAf().azk();
    LinkedList localLinkedList = bnb().jZq;
    AppMethodBeat.o(127793);
    return localLinkedList;
  }
  
  public static o getGoogleFriendStorage()
  {
    AppMethodBeat.i(127797);
    g.aAf().azk();
    if (bnb().jZn == null) {
      bnb().jZn = new o(g.aAh().hqK);
    }
    o localo = bnb().jZn;
    AppMethodBeat.o(127797);
    return localo;
  }
  
  public static q getInviteFriendOpenStg()
  {
    AppMethodBeat.i(127790);
    g.aAf().azk();
    if (bnb().jZm == null) {
      bnb().jZm = new q(g.aAh().hqK);
    }
    q localq = bnb().jZm;
    AppMethodBeat.o(127790);
    return localq;
  }
  
  public static ap getOldAccountFriendStorage()
  {
    AppMethodBeat.i(184137);
    g.aAf().azk();
    if (bnb().jZo == null) {
      bnb().jZo = new ap(g.aAh().hqK);
    }
    ap localap = bnb().jZo;
    AppMethodBeat.o(184137);
    return localap;
  }
  
  public static ar getQQGroupStg()
  {
    AppMethodBeat.i(127789);
    g.aAf().azk();
    if (bnb().jZk == null) {
      bnb().jZk = new ar(g.aAh().hqK);
    }
    ar localar = bnb().jZk;
    AppMethodBeat.o(127789);
    return localar;
  }
  
  public static at getQQListStg()
  {
    AppMethodBeat.i(127791);
    g.aAf().azk();
    if (bnb().jZl == null) {
      bnb().jZl = new at(g.aAh().hqK);
    }
    at localat = bnb().jZl;
    AppMethodBeat.o(127791);
    return localat;
  }
  
  public static void setFriendData(LinkedList<cik> paramLinkedList)
  {
    AppMethodBeat.i(127792);
    g.aAf().azk();
    bnb().jZq = paramLinkedList;
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
    h.d.a(Integer.valueOf(42), this.jZp);
    h.d.a(Integer.valueOf(66), this.jZp);
    EventCenter.instance.addListener(this.jZx);
    EventCenter.instance.addListener(this.jZw);
    EventCenter.instance.addListener(this.jZr);
    EventCenter.instance.addListener(this.jZs);
    EventCenter.instance.addListener(this.jZt);
    EventCenter.instance.addListener(this.jZu);
    EventCenter.instance.addListener(this.jZv);
    ((n)g.ah(n.class)).getFTSTaskDaemon().a(-86016, new com.tencent.mm.plugin.fts.a.a.a()
    {
      public final boolean execute()
      {
        AppMethodBeat.i(184136);
        Object localObject = new com.tencent.mm.w.a();
        ((n)g.ah(n.class)).registerIndexStorage((i)localObject);
        ((i)localObject).create();
        localObject = new com.tencent.mm.w.b();
        ((n)g.ah(n.class)).registerNativeLogic(9, (com.tencent.mm.plugin.fts.a.k)localObject);
        ((com.tencent.mm.plugin.fts.a.k)localObject).create();
        localObject = new com.tencent.mm.w.a.a();
        ((n)g.ah(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
        AppMethodBeat.o(184136);
        return true;
      }
      
      public final String getName()
      {
        return "InitFTSFriendPluginTask";
      }
    });
    com.tencent.mm.ak.ac.iNB = new ac.a()
    {
      public final boolean aZy()
      {
        AppMethodBeat.i(196845);
        if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.spm, 0) == 0)
        {
          AppMethodBeat.o(196845);
          return true;
        }
        AppMethodBeat.o(196845);
        return false;
      }
    };
    AppMethodBeat.o(127796);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(127795);
    EventCenter.instance.removeListener(this.jZx);
    EventCenter.instance.removeListener(this.jZw);
    EventCenter.instance.removeListener(this.jZr);
    EventCenter.instance.removeListener(this.jZs);
    EventCenter.instance.removeListener(this.jZt);
    EventCenter.instance.removeListener(this.jZu);
    EventCenter.instance.removeListener(this.jZv);
    h.d.b(Integer.valueOf(42), this.jZp);
    h.d.b(Integer.valueOf(66), this.jZp);
    this.jZq = null;
    AppMethodBeat.o(127795);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.a
 * JD-Core Version:    0.7.0.1
 */