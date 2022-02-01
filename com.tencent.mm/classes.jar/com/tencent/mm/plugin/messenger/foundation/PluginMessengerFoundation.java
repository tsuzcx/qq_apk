package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.b;
import com.tencent.mm.ak.f.d;
import com.tencent.mm.ba.o;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.al;
import com.tencent.mm.model.am;
import com.tencent.mm.model.cc;
import com.tencent.mm.modelmulti.n;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.plugin.messenger.foundation.a.u.a;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.protocal.protobuf.bva;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cf;
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
  private com.tencent.mm.plugin.messenger.foundation.a.b ByP;
  private com.tencent.mm.model.e hnK;
  private d xNn;
  private e xNo;
  private cc xWH;
  private com.tencent.mm.plugin.chatroom.a xWI;
  public int xWJ;
  private am xWK;
  
  public PluginMessengerFoundation()
  {
    AppMethodBeat.i(116903);
    this.hnK = new com.tencent.mm.model.e();
    this.xWH = new cc();
    this.xWI = new com.tencent.mm.plugin.chatroom.a();
    this.xWJ = 0;
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
        return bp.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("CONTACT_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return ao.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("OPLOG_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return com.tencent.mm.ba.j.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("CONVERSATION_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return aq.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("ROLEINFO_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return bv.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("STRANGER_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return ca.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("DeletedConversationInfo".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return at.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("LBSVERIFYMESSAGE_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return bm.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("SHAKEVERIFYMESSAGE_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return by.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("VERIFY_CONTACT_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return cf.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("FMESSAGE_MSGINFO_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return be.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("FMESSAGE_CONVERSATION_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return bc.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("CHATROOM_MSGSEQ_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return aa.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("GetSysCmdMsgInfo".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return bi.SQL_CREATE;
      }
    });
    AppMethodBeat.o(116908);
    return localHashMap;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(116906);
    com.tencent.mm.plugin.zero.c.DeT = new com.tencent.mm.cn.c()
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
    com.tencent.mm.kernel.g.agN().a(com.tencent.mm.plugin.messenger.foundation.a.t.class, new com.tencent.mm.kernel.c.e(new n()));
    com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.zero.a.d.class);
    if (paramg.ahL())
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
        
        public void processModContact(bva paramAnonymousbva, String paramAnonymousString, byte[] paramAnonymousArrayOfByte, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(169108);
          a.processModContact(paramAnonymousbva, paramAnonymousString, paramAnonymousArrayOfByte, paramAnonymousBoolean1, paramAnonymousBoolean2);
          AppMethodBeat.o(169108);
        }
        
        public void removeContactAssembler(com.tencent.mm.plugin.messenger.foundation.a.c paramAnonymousc)
        {
          AppMethodBeat.i(169109);
          a.removeContactAssembler(paramAnonymousc);
          AppMethodBeat.o(169109);
        }
      });
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.messenger.foundation.a.j.class, new com.tencent.mm.plugin.messenger.foundation.a.j()
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
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.chatroom.a.c.class, this.xWI);
      CoreService.Ui();
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
    if (paramg.ahL())
    {
      this.xNn = new d();
      com.tencent.mm.kernel.g.a(k.class, new com.tencent.mm.kernel.c.e(this.xNn));
      this.xNo = new e();
      com.tencent.mm.kernel.g.a(l.class, new com.tencent.mm.kernel.c.e(this.xNo));
    }
    AppMethodBeat.o(116907);
  }
  
  public com.tencent.mm.plugin.messenger.foundation.a.b getBizTimeLineCallback()
  {
    return this.ByP;
  }
  
  public List<al> getDataTransferList()
  {
    AppMethodBeat.i(116912);
    if (this.xWK != null)
    {
      localObject = this.xWK.getDataTransferList();
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
  
  public cc getSysCmdMsgExtension()
  {
    return this.xWH;
  }
  
  public boolean ifAddTicketByActionFlag(String paramString)
  {
    AppMethodBeat.i(116914);
    boolean bool;
    if (this.xWJ == 0) {
      bool = false;
    }
    for (;;)
    {
      ac.i("MicroMsg.TAG", "ifAddTicketByActionFlag %s %s", new Object[] { paramString, Boolean.valueOf(bool) });
      AppMethodBeat.o(116914);
      return bool;
      if (com.tencent.mm.model.w.wn(paramString))
      {
        if (bs.jl(this.xWJ & 0x1, 1)) {
          bool = true;
        }
      }
      else if ((com.tencent.mm.model.w.sQ(paramString)) && (bs.jl(this.xWJ & 0x2, 2)))
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
    f.d.a(Integer.valueOf(10000), this.hnK);
    f.d.a(Integer.valueOf(1), this.hnK);
    f.d.a(Integer.valueOf(10001), this.xWH);
    f.d.a(Integer.valueOf(10002), this.xWH);
    AppMethodBeat.o(116909);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(116910);
    f.d.b(Integer.valueOf(10000), this.hnK);
    f.d.b(Integer.valueOf(1), this.hnK);
    f.d.b(Integer.valueOf(10001), this.xWH);
    f.d.b(Integer.valueOf(10002), this.xWH);
    AppMethodBeat.o(116910);
  }
  
  public void onDataBaseClosed(h paramh1, h paramh2) {}
  
  public void onDataBaseOpened(h paramh1, h paramh2)
  {
    AppMethodBeat.i(116911);
    com.tencent.mm.model.t.axu();
    paramh1 = this.xNn;
    paramh2 = com.tencent.mm.kernel.g.agR().ghG;
    com.tencent.mm.kernel.g.agR();
    paramh1.uGv = new o(new com.tencent.mm.ba.j(paramh2));
    paramh1.uGw = new com.tencent.mm.ba.a();
    paramh1.uGr = new ao(paramh2);
    paramh1.uGs = new ca(paramh2);
    paramh1.uGu = new aq(paramh2);
    paramh1.uGt = new bp(paramh2, paramh1.uGr, paramh1.uGu);
    paramh1.uGx = new bv(paramh2);
    paramh1.uGy = new at(paramh2);
    paramh1.uGz = new be(paramh2);
    paramh1.uGA = new bc(paramh2);
    paramh1.uGB = new bm(paramh2);
    paramh1.uGC = new by(paramh2);
    paramh1.uGD = new cf(paramh2);
    paramh1.uGE = new aa(paramh2);
    paramh1.uGF = new bi(paramh2);
    AppMethodBeat.o(116911);
  }
  
  public void setBizTimeLineCallback(com.tencent.mm.plugin.messenger.foundation.a.b paramb)
  {
    this.ByP = paramb;
  }
  
  public void setEnSendMsgActionFlag(int paramInt)
  {
    AppMethodBeat.i(116913);
    ac.i("MicroMsg.TAG", "setEnSendMsgActionFlag %s", new Object[] { Integer.valueOf(paramInt) });
    this.xWJ = paramInt;
    AppMethodBeat.o(116913);
  }
  
  public void setIDataTransferFactoryDelegate(am paramam)
  {
    this.xWK = paramam;
  }
  
  public String toString()
  {
    return "plugin-messenger-foundation";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation
 * JD-Core Version:    0.7.0.1
 */