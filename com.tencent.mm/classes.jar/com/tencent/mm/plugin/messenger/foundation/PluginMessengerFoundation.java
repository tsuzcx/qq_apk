package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.ak.e.d;
import com.tencent.mm.ba.j;
import com.tencent.mm.ba.o;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.u;
import com.tencent.mm.modelmulti.n;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.messenger.foundation.a.w;
import com.tencent.mm.plugin.messenger.foundation.a.x.a;
import com.tencent.mm.plugin.messenger.foundation.a.z;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.protocal.protobuf.caj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.ch;
import com.tencent.mm.storage.cm;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import junit.framework.Assert;

public class PluginMessengerFoundation
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.api.bucket.d, ap, s
{
  private d Emj;
  private e Enm;
  private com.tencent.mm.model.cf FaR;
  private com.tencent.mm.plugin.chatroom.a FaS;
  public int FaT;
  private ap FaU;
  private com.tencent.mm.plugin.messenger.foundation.a.b FaV;
  private com.tencent.mm.model.e hIU;
  
  public PluginMessengerFoundation()
  {
    AppMethodBeat.i(116903);
    this.hIU = new com.tencent.mm.model.e();
    this.FaR = new com.tencent.mm.model.cf();
    this.FaS = new com.tencent.mm.plugin.chatroom.a();
    this.FaT = 0;
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
        return bw.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("CONTACT_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return at.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("OPLOG_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return j.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("CONVERSATION_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return av.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("ROLEINFO_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return cc.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("STRANGER_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return ch.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("FRIEND_USER_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return bm.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("DeletedConversationInfo".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return ay.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("LBSVERIFYMESSAGE_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return bt.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("SHAKEVERIFYMESSAGE_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return com.tencent.mm.storage.cf.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("VERIFY_CONTACT_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return cm.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("FMESSAGE_MSGINFO_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return bj.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("FMESSAGE_CONVERSATION_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return bh.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("CHATROOM_MSGSEQ_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return af.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("GetSysCmdMsgInfo".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return bp.SQL_CREATE;
      }
    });
    AppMethodBeat.o(116908);
    return localHashMap;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(116906);
    com.tencent.mm.plugin.zero.c.Fbk = new com.tencent.mm.cm.c()
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
    x.a.a(2, (com.tencent.mm.plugin.messenger.foundation.a.x)localObject);
    x.a.a(17, (com.tencent.mm.plugin.messenger.foundation.a.x)localObject);
    x.a.a(4, (com.tencent.mm.plugin.messenger.foundation.a.x)localObject);
    x.a.a(7, new b());
    localObject = new c();
    x.a.a(5, (com.tencent.mm.plugin.messenger.foundation.a.x)localObject);
    x.a.a(8, (com.tencent.mm.plugin.messenger.foundation.a.x)localObject);
    x.a.a(9, (com.tencent.mm.plugin.messenger.foundation.a.x)localObject);
    x.a.a(1, new g());
    com.tencent.mm.kernel.g.ajN().a(w.class, new com.tencent.mm.kernel.c.e(new n()));
    com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.zero.a.d.class);
    if (paramg.akL())
    {
      new com.tencent.mm.plugin.zero.tasks.b().before(this);
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.messenger.foundation.a.e.class, new com.tencent.mm.plugin.messenger.foundation.a.e()
      {
        public com.tencent.mm.vending.b.b addContactAssembler(com.tencent.mm.plugin.messenger.foundation.a.d paramAnonymousd)
        {
          AppMethodBeat.i(116899);
          paramAnonymousd = a.addContactAssembler(paramAnonymousd);
          AppMethodBeat.o(116899);
          return paramAnonymousd;
        }
        
        public void processModContact(caj paramAnonymouscaj, String paramAnonymousString, byte[] paramAnonymousArrayOfByte, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, int paramAnonymousInt)
        {
          AppMethodBeat.i(211750);
          a.processModContact(paramAnonymouscaj, paramAnonymousString, paramAnonymousArrayOfByte, paramAnonymousBoolean1, paramAnonymousBoolean2, paramAnonymousInt);
          AppMethodBeat.o(211750);
        }
        
        public void removeContactAssembler(com.tencent.mm.plugin.messenger.foundation.a.d paramAnonymousd)
        {
          AppMethodBeat.i(169109);
          a.removeContactAssembler(paramAnonymousd);
          AppMethodBeat.o(169109);
        }
      });
      com.tencent.mm.kernel.g.b(k.class, new k()
      {
        public void addSyncDoCmdCallback(z paramAnonymousz)
        {
          AppMethodBeat.i(116901);
          f.addSyncDoCmdCallback(paramAnonymousz);
          AppMethodBeat.o(116901);
        }
        
        public e.b processAddMsg(e.a paramAnonymousa, aa paramAnonymousaa)
        {
          AppMethodBeat.i(116900);
          paramAnonymousa = c.processAddMsg(paramAnonymousa, paramAnonymousaa);
          AppMethodBeat.o(116900);
          return paramAnonymousa;
        }
        
        public void removeSyncDoCmdCallback(z paramAnonymousz)
        {
          AppMethodBeat.i(116902);
          f.removeSyncDoCmdCallback(paramAnonymousz);
          AppMethodBeat.o(116902);
        }
      });
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.chatroom.a.c.class, this.FaS);
      CoreService.WH();
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
    if (paramg.akL())
    {
      this.Emj = new d();
      com.tencent.mm.kernel.g.a(l.class, new com.tencent.mm.kernel.c.e(this.Emj));
      this.Enm = new e();
      com.tencent.mm.kernel.g.a(m.class, new com.tencent.mm.kernel.c.e(this.Enm));
    }
    AppMethodBeat.o(116907);
  }
  
  public com.tencent.mm.plugin.messenger.foundation.a.b getBizTimeLineCallback()
  {
    return this.FaV;
  }
  
  public List<ao> getDataTransferList()
  {
    AppMethodBeat.i(116912);
    if (this.FaU != null)
    {
      localObject = this.FaU.getDataTransferList();
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
  
  public com.tencent.mm.model.cf getSysCmdMsgExtension()
  {
    return this.FaR;
  }
  
  public boolean ifAddTicketByActionFlag(String paramString)
  {
    AppMethodBeat.i(116914);
    boolean bool;
    if (this.FaT == 0) {
      bool = false;
    }
    for (;;)
    {
      ae.i("MicroMsg.TAG", "ifAddTicketByActionFlag %s %s", new Object[] { paramString, Boolean.valueOf(bool) });
      AppMethodBeat.o(116914);
      return bool;
      if (com.tencent.mm.model.x.zS(paramString))
      {
        if (bu.jB(this.FaT & 0x1, 1)) {
          bool = true;
        }
      }
      else if ((com.tencent.mm.model.x.wb(paramString)) && (bu.jB(this.FaT & 0x2, 2)))
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
    alias(s.class);
    AppMethodBeat.o(116904);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(116909);
    e.d.a(Integer.valueOf(10000), this.hIU);
    e.d.a(Integer.valueOf(1), this.hIU);
    e.d.a(Integer.valueOf(10001), this.FaR);
    e.d.a(Integer.valueOf(10002), this.FaR);
    AppMethodBeat.o(116909);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(116910);
    e.d.b(Integer.valueOf(10000), this.hIU);
    e.d.b(Integer.valueOf(1), this.hIU);
    e.d.b(Integer.valueOf(10001), this.FaR);
    e.d.b(Integer.valueOf(10002), this.FaR);
    AppMethodBeat.o(116910);
  }
  
  public void onDataBaseClosed(h paramh1, h paramh2) {}
  
  public void onDataBaseOpened(h paramh1, h paramh2)
  {
    AppMethodBeat.i(116911);
    u.aAA();
    paramh1 = this.Emj;
    paramh2 = com.tencent.mm.kernel.g.ajR().gDX;
    com.tencent.mm.kernel.g.ajR();
    paramh1.vVw = new o(new j(paramh2));
    paramh1.vVx = new com.tencent.mm.ba.a();
    paramh1.vVr = new at(paramh2);
    paramh1.vVs = new ch(paramh2);
    paramh1.vVt = new bm(paramh2);
    paramh1.vVv = new av(paramh2);
    paramh1.vVu = new bw(paramh2, paramh1.vVr, paramh1.vVv);
    paramh1.vVy = new cc(paramh2);
    paramh1.vVz = new ay(paramh2);
    paramh1.vVA = new bj(paramh2);
    paramh1.vVB = new bh(paramh2);
    paramh1.vVC = new bt(paramh2);
    paramh1.vVD = new com.tencent.mm.storage.cf(paramh2);
    paramh1.vVE = new cm(paramh2);
    paramh1.vVF = new af(paramh2);
    paramh1.vVG = new bp(paramh2);
    AppMethodBeat.o(116911);
  }
  
  public void setBizTimeLineCallback(com.tencent.mm.plugin.messenger.foundation.a.b paramb)
  {
    this.FaV = paramb;
  }
  
  public void setEnSendMsgActionFlag(int paramInt)
  {
    AppMethodBeat.i(116913);
    ae.i("MicroMsg.TAG", "setEnSendMsgActionFlag %s", new Object[] { Integer.valueOf(paramInt) });
    this.FaT = paramInt;
    AppMethodBeat.o(116913);
  }
  
  public void setIDataTransferFactoryDelegate(ap paramap)
  {
    this.FaU = paramap;
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