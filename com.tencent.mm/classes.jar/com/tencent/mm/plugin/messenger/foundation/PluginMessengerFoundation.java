package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.b;
import com.tencent.mm.al.f.d;
import com.tencent.mm.bb.i;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.am;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.plugin.messenger.foundation.a.u.a;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.z;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import junit.framework.Assert;

public class PluginMessengerFoundation
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.api.bucket.d, am, q
{
  private d LmB;
  private e LmC;
  private com.tencent.mm.model.cc LmD;
  private com.tencent.mm.plugin.chatroom.a LmE;
  public int LmF;
  private am LmG;
  private com.tencent.mm.plugin.messenger.foundation.a.b LmH;
  private com.tencent.mm.model.e gNk;
  
  public PluginMessengerFoundation()
  {
    AppMethodBeat.i(116903);
    this.gNk = new com.tencent.mm.model.e();
    this.LmD = new com.tencent.mm.model.cc();
    this.LmE = new com.tencent.mm.plugin.chatroom.a();
    this.LmF = 0;
    AppMethodBeat.o(116903);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(116908);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("MESSAGE_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return bm.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("CONTACT_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return com.tencent.mm.storage.al.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("OPLOG_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return i.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("CONVERSATION_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return an.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("ROLEINFO_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return bs.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("STRANGER_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return bx.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("DeletedConversationInfo".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return aq.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("LBSVERIFYMESSAGE_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return bj.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("SHAKEVERIFYMESSAGE_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return bv.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("VERIFY_CONTACT_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return com.tencent.mm.storage.cc.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("FMESSAGE_MSGINFO_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return bb.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("FMESSAGE_CONVERSATION_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return az.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("CHATROOM_MSGSEQ_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return z.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("GetSysCmdMsgInfo".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return bf.SQL_CREATE;
      }
    });
    AppMethodBeat.o(116908);
    return localHashMap;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(116906);
    com.tencent.mm.plugin.zero.c.BMJ = new com.tencent.mm.co.c()
    {
      public com.tencent.mm.plugin.zero.a.f get()
      {
        AppMethodBeat.i(169107);
        f localf = new f();
        AppMethodBeat.o(169107);
        return localf;
      }
    };
    Object localObject = new a();
    u.a.a(2, (u)localObject);
    u.a.a(17, (u)localObject);
    u.a.a(4, (u)localObject);
    u.a.a(7, new b());
    localObject = new c();
    u.a.a(5, (u)localObject);
    u.a.a(8, (u)localObject);
    u.a.a(9, (u)localObject);
    u.a.a(1, new g());
    com.tencent.mm.kernel.g.afx().a(com.tencent.mm.plugin.messenger.foundation.a.t.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.modelmulti.n()));
    com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.zero.a.d.class);
    if (paramg.agu())
    {
      new com.tencent.mm.plugin.zero.tasks.b().before(this);
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.messenger.foundation.a.d.class, new com.tencent.mm.plugin.messenger.foundation.a.d()
      {
        public com.tencent.mm.vending.b.b addContactAssembler(com.tencent.mm.plugin.messenger.foundation.a.c paramAnonymousc)
        {
          AppMethodBeat.i(116899);
          paramAnonymousc = a.addContactAssembler(paramAnonymousc);
          AppMethodBeat.o(116899);
          return paramAnonymousc;
        }
        
        public void processModContact(bqj paramAnonymousbqj, String paramAnonymousString, byte[] paramAnonymousArrayOfByte, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(169108);
          a.processModContact(paramAnonymousbqj, paramAnonymousString, paramAnonymousArrayOfByte, paramAnonymousBoolean1, paramAnonymousBoolean2);
          AppMethodBeat.o(169108);
        }
        
        public void removeContactAssembler(com.tencent.mm.plugin.messenger.foundation.a.c paramAnonymousc)
        {
          AppMethodBeat.i(169109);
          a.removeContactAssembler(paramAnonymousc);
          AppMethodBeat.o(169109);
        }
      });
      com.tencent.mm.kernel.g.b(j.class, new j()
      {
        public void addSyncDoCmdCallback(com.tencent.mm.plugin.messenger.foundation.a.w paramAnonymousw)
        {
          AppMethodBeat.i(116901);
          f.addSyncDoCmdCallback(paramAnonymousw);
          AppMethodBeat.o(116901);
        }
        
        public f.b processAddMsg(f.a paramAnonymousa, x paramAnonymousx)
        {
          AppMethodBeat.i(116900);
          paramAnonymousa = c.processAddMsg(paramAnonymousa, paramAnonymousx);
          AppMethodBeat.o(116900);
          return paramAnonymousa;
        }
        
        public void removeSyncDoCmdCallback(com.tencent.mm.plugin.messenger.foundation.a.w paramAnonymousw)
        {
          AppMethodBeat.i(116902);
          f.removeSyncDoCmdCallback(paramAnonymousw);
          AppMethodBeat.o(116902);
        }
      });
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.chatroom.a.c.class, this.LmE);
      CoreService.To();
    }
    AppMethodBeat.o(116906);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(116905);
    dependsOn(PluginZero.class);
    AppMethodBeat.o(116905);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(116907);
    if (paramg.agu())
    {
      this.LmB = new d();
      com.tencent.mm.kernel.g.a(k.class, new com.tencent.mm.kernel.c.e(this.LmB));
      this.LmC = new e();
      com.tencent.mm.kernel.g.a(l.class, new com.tencent.mm.kernel.c.e(this.LmC));
    }
    AppMethodBeat.o(116907);
  }
  
  public com.tencent.mm.plugin.messenger.foundation.a.b getBizTimeLineCallback()
  {
    return this.LmH;
  }
  
  public List<com.tencent.mm.model.al> getDataTransferList()
  {
    AppMethodBeat.i(116912);
    if (this.LmG != null)
    {
      localObject = this.LmG.getDataTransferList();
      if (((List)localObject).size() > 8) {
        Assert.assertTrue("Do not add more IDataTransfer from mIDataTransferFactoryDelegate!!!!!!!!!!!", false);
      }
      AppMethodBeat.o(116912);
      return localObject;
    }
    Object localObject = new ArrayList();
    AppMethodBeat.o(116912);
    return localObject;
  }
  
  public com.tencent.mm.model.cc getSysCmdMsgExtension()
  {
    return this.LmD;
  }
  
  public boolean ifAddTicketByActionFlag(String paramString)
  {
    AppMethodBeat.i(116914);
    boolean bool;
    if (this.LmF == 0) {
      bool = false;
    }
    for (;;)
    {
      ad.i("MicroMsg.TAG", "ifAddTicketByActionFlag %s %s", new Object[] { paramString, Boolean.valueOf(bool) });
      AppMethodBeat.o(116914);
      return bool;
      if (com.tencent.mm.model.w.sk(paramString))
      {
        if (bt.iY(this.LmF & 0x1, 1)) {
          bool = true;
        }
      }
      else if ((com.tencent.mm.model.w.pF(paramString)) && (bt.iY(this.LmF & 0x2, 2)))
      {
        bool = true;
        continue;
      }
      bool = false;
    }
  }
  
  public void installed()
  {
    AppMethodBeat.i(116904);
    alias(q.class);
    AppMethodBeat.o(116904);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(116909);
    f.d.a(Integer.valueOf(10000), this.gNk);
    f.d.a(Integer.valueOf(1), this.gNk);
    f.d.a(Integer.valueOf(10001), this.LmD);
    f.d.a(Integer.valueOf(10002), this.LmD);
    AppMethodBeat.o(116909);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(116910);
    f.d.b(Integer.valueOf(10000), this.gNk);
    f.d.b(Integer.valueOf(1), this.gNk);
    f.d.b(Integer.valueOf(10001), this.LmD);
    f.d.b(Integer.valueOf(10002), this.LmD);
    AppMethodBeat.o(116910);
  }
  
  public void onDataBaseClosed(h paramh1, h paramh2) {}
  
  public void onDataBaseOpened(h paramh1, h paramh2)
  {
    AppMethodBeat.i(116911);
    com.tencent.mm.model.t.aqE();
    paramh1 = this.LmB;
    paramh2 = com.tencent.mm.kernel.g.afB().gda;
    com.tencent.mm.kernel.g.afB();
    paramh1.txX = new com.tencent.mm.bb.n(new i(paramh2));
    paramh1.txY = new com.tencent.mm.bb.a();
    paramh1.txT = new com.tencent.mm.storage.al(paramh2);
    paramh1.txU = new bx(paramh2);
    paramh1.txW = new an(paramh2);
    paramh1.txV = new bm(paramh2, paramh1.txT, paramh1.txW);
    paramh1.txZ = new bs(paramh2);
    paramh1.tya = new aq(paramh2);
    paramh1.tyb = new bb(paramh2);
    paramh1.tyc = new az(paramh2);
    paramh1.tyd = new bj(paramh2);
    paramh1.tye = new bv(paramh2);
    paramh1.tyf = new com.tencent.mm.storage.cc(paramh2);
    paramh1.tyg = new z(paramh2);
    paramh1.tyh = new bf(paramh2);
    AppMethodBeat.o(116911);
  }
  
  public void setBizTimeLineCallback(com.tencent.mm.plugin.messenger.foundation.a.b paramb)
  {
    this.LmH = paramb;
  }
  
  public void setEnSendMsgActionFlag(int paramInt)
  {
    AppMethodBeat.i(116913);
    ad.i("MicroMsg.TAG", "setEnSendMsgActionFlag %s", new Object[] { Integer.valueOf(paramInt) });
    this.LmF = paramInt;
    AppMethodBeat.o(116913);
  }
  
  public void setIDataTransferFactoryDelegate(am paramam)
  {
    this.LmG = paramam;
  }
  
  public String toString()
  {
    return "plugin-messenger-foundation";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation
 * JD-Core Version:    0.7.0.1
 */