package com.tencent.mm.plugin.account;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.ab.a;
import com.tencent.mm.am.g.d;
import com.tencent.mm.model.be;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.account.friend.model.BindQQEventListenerImpl;
import com.tencent.mm.plugin.account.friend.model.FMessageMobileFilterListenerImpl;
import com.tencent.mm.plugin.account.friend.model.FMsgGetNameListener;
import com.tencent.mm.plugin.account.friend.model.am;
import com.tencent.mm.plugin.account.friend.model.ao;
import com.tencent.mm.plugin.account.friend.model.aq;
import com.tencent.mm.plugin.account.friend.model.e;
import com.tencent.mm.plugin.account.friend.model.l;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.protocal.protobuf.dib;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.LinkedList;

public class b
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.plugin.account.friend.model.b pNg;
  private e pNh;
  private com.tencent.mm.plugin.account.friend.model.h pNi;
  private ao pNj;
  private aq pNk;
  private com.tencent.mm.plugin.account.friend.model.n pNl;
  private l pNm;
  private am pNn;
  private com.tencent.mm.plugin.account.friend.model.c pNo;
  private LinkedList<dib> pNp;
  private BindQQEventListenerImpl pNq;
  private FMessageMobileFilterListenerImpl pNr;
  private FMsgGetNameListener pNs;
  private IListener pNt;
  private IListener pNu;
  private IListener pNv;
  private IListener pNw;
  
  static
  {
    AppMethodBeat.i(127798);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("ADDR_UPLOAD_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.account.friend.model.b.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("FACE_BOOK_FIREND_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return e.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("FRIEND_EXT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.account.friend.model.h.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("QQ_GROUP_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return ao.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("QQ_LIST_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return aq.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("INVITEFRIENDOPEN_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.account.friend.model.n.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("GOOGLE_FRIEND_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return l.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("OLD_ACCOUNT_FRIEND_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return am.SQL_CREATE;
      }
    });
    AppMethodBeat.o(127798);
  }
  
  public b()
  {
    AppMethodBeat.i(127784);
    this.pNo = new com.tencent.mm.plugin.account.friend.model.c();
    this.pNp = null;
    this.pNq = new BindQQEventListenerImpl();
    this.pNr = new FMessageMobileFilterListenerImpl();
    this.pNs = new FMsgGetNameListener();
    this.pNt = new SubCoreFriend.1(this, com.tencent.mm.app.f.hfK);
    this.pNu = new SubCoreFriend.2(this, com.tencent.mm.app.f.hfK);
    this.pNv = new SubCoreFriend.3(this, com.tencent.mm.app.f.hfK);
    this.pNw = new SubCoreFriend.12(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(127784);
  }
  
  private static b bVZ()
  {
    try
    {
      AppMethodBeat.i(127785);
      b localb = (b)y.aL(b.class);
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
    com.tencent.mm.kernel.h.baC().aZJ();
    bVZ().pNp = null;
    AppMethodBeat.o(127794);
  }
  
  public static com.tencent.mm.plugin.account.friend.model.b getAddrUploadStg()
  {
    AppMethodBeat.i(127786);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (bVZ().pNg == null) {
      bVZ().pNg = new com.tencent.mm.plugin.account.friend.model.b(com.tencent.mm.kernel.h.baE().mCN);
    }
    com.tencent.mm.plugin.account.friend.model.b localb = bVZ().pNg;
    AppMethodBeat.o(127786);
    return localb;
  }
  
  public static e getFacebookFrdStg()
  {
    AppMethodBeat.i(127787);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (bVZ().pNh == null) {
      bVZ().pNh = new e(com.tencent.mm.kernel.h.baE().mCN);
    }
    e locale = bVZ().pNh;
    AppMethodBeat.o(127787);
    return locale;
  }
  
  public static com.tencent.mm.plugin.account.friend.model.h getFrdExtStg()
  {
    AppMethodBeat.i(127788);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (bVZ().pNi == null) {
      bVZ().pNi = new com.tencent.mm.plugin.account.friend.model.h(com.tencent.mm.kernel.h.baE().mCN);
    }
    com.tencent.mm.plugin.account.friend.model.h localh = bVZ().pNi;
    AppMethodBeat.o(127788);
    return localh;
  }
  
  public static LinkedList<dib> getFriendData()
  {
    AppMethodBeat.i(127793);
    com.tencent.mm.kernel.h.baC().aZJ();
    LinkedList localLinkedList = bVZ().pNp;
    AppMethodBeat.o(127793);
    return localLinkedList;
  }
  
  public static l getGoogleFriendStorage()
  {
    AppMethodBeat.i(127797);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (bVZ().pNm == null) {
      bVZ().pNm = new l(com.tencent.mm.kernel.h.baE().mCN);
    }
    l locall = bVZ().pNm;
    AppMethodBeat.o(127797);
    return locall;
  }
  
  public static com.tencent.mm.plugin.account.friend.model.n getInviteFriendOpenStg()
  {
    AppMethodBeat.i(127790);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (bVZ().pNl == null) {
      bVZ().pNl = new com.tencent.mm.plugin.account.friend.model.n(com.tencent.mm.kernel.h.baE().mCN);
    }
    com.tencent.mm.plugin.account.friend.model.n localn = bVZ().pNl;
    AppMethodBeat.o(127790);
    return localn;
  }
  
  public static am getOldAccountFriendStorage()
  {
    AppMethodBeat.i(184137);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (bVZ().pNn == null) {
      bVZ().pNn = new am(com.tencent.mm.kernel.h.baE().mCN);
    }
    am localam = bVZ().pNn;
    AppMethodBeat.o(184137);
    return localam;
  }
  
  public static ao getQQGroupStg()
  {
    AppMethodBeat.i(127789);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (bVZ().pNj == null) {
      bVZ().pNj = new ao(com.tencent.mm.kernel.h.baE().mCN);
    }
    ao localao = bVZ().pNj;
    AppMethodBeat.o(127789);
    return localao;
  }
  
  public static aq getQQListStg()
  {
    AppMethodBeat.i(127791);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (bVZ().pNk == null) {
      bVZ().pNk = new aq(com.tencent.mm.kernel.h.baE().mCN);
    }
    aq localaq = bVZ().pNk;
    AppMethodBeat.o(127791);
    return localaq;
  }
  
  public static void setFriendData(LinkedList<dib> paramLinkedList)
  {
    AppMethodBeat.i(127792);
    com.tencent.mm.kernel.h.baC().aZJ();
    bVZ().pNp = paramLinkedList;
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
    g.d.a(Integer.valueOf(42), this.pNo);
    g.d.a(Integer.valueOf(66), this.pNo);
    this.pNw.alive();
    this.pNv.alive();
    this.pNq.alive();
    this.pNr.alive();
    this.pNs.alive();
    this.pNt.alive();
    this.pNu.alive();
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon().a(-86016, new b.3(this));
    com.tencent.mm.am.ab.ovu = new ab.a()
    {
      public final boolean bGy()
      {
        AppMethodBeat.i(304617);
        if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zuE, 0) == 0)
        {
          AppMethodBeat.o(304617);
          return true;
        }
        AppMethodBeat.o(304617);
        return false;
      }
    };
    AppMethodBeat.o(127796);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(127795);
    this.pNw.dead();
    this.pNv.dead();
    this.pNq.dead();
    this.pNr.dead();
    this.pNs.dead();
    this.pNt.dead();
    this.pNu.dead();
    g.d.b(Integer.valueOf(42), this.pNo);
    g.d.b(Integer.valueOf(66), this.pNo);
    this.pNp = null;
    AppMethodBeat.o(127795);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.b
 * JD-Core Version:    0.7.0.1
 */