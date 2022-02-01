package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.b;
import com.tencent.mm.al.e.d;
import com.tencent.mm.bb.j;
import com.tencent.mm.bb.o;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.am;
import com.tencent.mm.model.an;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.t;
import com.tencent.mm.modelmulti.n;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.messenger.foundation.a.w.a;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.plugin.messenger.foundation.a.z;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.protocal.protobuf.bzp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.cb;
import com.tencent.mm.storage.ce;
import com.tencent.mm.storage.cg;
import com.tencent.mm.storage.cl;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import junit.framework.Assert;

public class PluginMessengerFoundation
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.api.bucket.d, an, r
{
  public int OdA;
  private an OdB;
  private com.tencent.mm.plugin.messenger.foundation.a.b OdC;
  private d Odw;
  private e Odx;
  private cd Ody;
  private com.tencent.mm.plugin.chatroom.a Odz;
  private com.tencent.mm.model.e hGc;
  
  public PluginMessengerFoundation()
  {
    AppMethodBeat.i(116903);
    this.hGc = new com.tencent.mm.model.e();
    this.Ody = new cd();
    this.Odz = new com.tencent.mm.plugin.chatroom.a();
    this.OdA = 0;
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
        return bv.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("CONTACT_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return as.SQL_CREATE;
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
        return au.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("ROLEINFO_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return cb.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("STRANGER_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return cg.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("FRIEND_USER_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return bl.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("DeletedConversationInfo".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return ax.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("LBSVERIFYMESSAGE_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return bs.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("SHAKEVERIFYMESSAGE_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return ce.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("VERIFY_CONTACT_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return cl.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("FMESSAGE_MSGINFO_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return bi.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("FMESSAGE_CONVERSATION_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return bg.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("CHATROOM_MSGSEQ_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return ae.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("GetSysCmdMsgInfo".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return bo.SQL_CREATE;
      }
    });
    AppMethodBeat.o(116908);
    return localHashMap;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(116906);
    com.tencent.mm.plugin.zero.c.EIM = new com.tencent.mm.cn.c()
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
    w.a.a(2, (com.tencent.mm.plugin.messenger.foundation.a.w)localObject);
    w.a.a(17, (com.tencent.mm.plugin.messenger.foundation.a.w)localObject);
    w.a.a(4, (com.tencent.mm.plugin.messenger.foundation.a.w)localObject);
    w.a.a(7, new b());
    localObject = new c();
    w.a.a(5, (com.tencent.mm.plugin.messenger.foundation.a.w)localObject);
    w.a.a(8, (com.tencent.mm.plugin.messenger.foundation.a.w)localObject);
    w.a.a(9, (com.tencent.mm.plugin.messenger.foundation.a.w)localObject);
    w.a.a(1, new g());
    com.tencent.mm.kernel.g.ajy().a(v.class, new com.tencent.mm.kernel.c.e(new n()));
    com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.zero.a.d.class);
    if (paramg.akw())
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
        
        public void processModContact(bzp paramAnonymousbzp, String paramAnonymousString, byte[] paramAnonymousArrayOfByte, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, int paramAnonymousInt)
        {
          AppMethodBeat.i(217581);
          a.processModContact(paramAnonymousbzp, paramAnonymousString, paramAnonymousArrayOfByte, paramAnonymousBoolean1, paramAnonymousBoolean2, paramAnonymousInt);
          AppMethodBeat.o(217581);
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
        public void addSyncDoCmdCallback(y paramAnonymousy)
        {
          AppMethodBeat.i(116901);
          f.addSyncDoCmdCallback(paramAnonymousy);
          AppMethodBeat.o(116901);
        }
        
        public e.b processAddMsg(e.a paramAnonymousa, z paramAnonymousz)
        {
          AppMethodBeat.i(116900);
          paramAnonymousa = c.processAddMsg(paramAnonymousa, paramAnonymousz);
          AppMethodBeat.o(116900);
          return paramAnonymousa;
        }
        
        public void removeSyncDoCmdCallback(y paramAnonymousy)
        {
          AppMethodBeat.i(116902);
          f.removeSyncDoCmdCallback(paramAnonymousy);
          AppMethodBeat.o(116902);
        }
      });
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.chatroom.a.c.class, this.Odz);
      CoreService.Wz();
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
    if (paramg.akw())
    {
      this.Odw = new d();
      com.tencent.mm.kernel.g.a(l.class, new com.tencent.mm.kernel.c.e(this.Odw));
      this.Odx = new e();
      com.tencent.mm.kernel.g.a(m.class, new com.tencent.mm.kernel.c.e(this.Odx));
    }
    AppMethodBeat.o(116907);
  }
  
  public com.tencent.mm.plugin.messenger.foundation.a.b getBizTimeLineCallback()
  {
    return this.OdC;
  }
  
  public List<am> getDataTransferList()
  {
    AppMethodBeat.i(116912);
    if (this.OdB != null)
    {
      localObject = this.OdB.getDataTransferList();
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
  
  public cd getSysCmdMsgExtension()
  {
    return this.Ody;
  }
  
  public boolean ifAddTicketByActionFlag(String paramString)
  {
    AppMethodBeat.i(116914);
    boolean bool;
    if (this.OdA == 0) {
      bool = false;
    }
    for (;;)
    {
      ad.i("MicroMsg.TAG", "ifAddTicketByActionFlag %s %s", new Object[] { paramString, Boolean.valueOf(bool) });
      AppMethodBeat.o(116914);
      return bool;
      if (com.tencent.mm.model.w.zi(paramString))
      {
        if (bt.jx(this.OdA & 0x1, 1)) {
          bool = true;
        }
      }
      else if ((com.tencent.mm.model.w.vF(paramString)) && (bt.jx(this.OdA & 0x2, 2)))
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
    alias(r.class);
    AppMethodBeat.o(116904);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(116909);
    e.d.a(Integer.valueOf(10000), this.hGc);
    e.d.a(Integer.valueOf(1), this.hGc);
    e.d.a(Integer.valueOf(10001), this.Ody);
    e.d.a(Integer.valueOf(10002), this.Ody);
    AppMethodBeat.o(116909);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(116910);
    e.d.b(Integer.valueOf(10000), this.hGc);
    e.d.b(Integer.valueOf(1), this.hGc);
    e.d.b(Integer.valueOf(10001), this.Ody);
    e.d.b(Integer.valueOf(10002), this.Ody);
    AppMethodBeat.o(116910);
  }
  
  public void onDataBaseClosed(h paramh1, h paramh2) {}
  
  public void onDataBaseOpened(h paramh1, h paramh2)
  {
    AppMethodBeat.i(116911);
    t.aAk();
    paramh1 = this.Odw;
    paramh2 = com.tencent.mm.kernel.g.ajC().gBq;
    com.tencent.mm.kernel.g.ajC();
    paramh1.vJs = new o(new j(paramh2));
    paramh1.vJt = new com.tencent.mm.bb.a();
    paramh1.vJn = new as(paramh2);
    paramh1.vJo = new cg(paramh2);
    paramh1.vJp = new bl(paramh2);
    paramh1.vJr = new au(paramh2);
    paramh1.vJq = new bv(paramh2, paramh1.vJn, paramh1.vJr);
    paramh1.vJu = new cb(paramh2);
    paramh1.vJv = new ax(paramh2);
    paramh1.vJw = new bi(paramh2);
    paramh1.vJx = new bg(paramh2);
    paramh1.vJy = new bs(paramh2);
    paramh1.vJz = new ce(paramh2);
    paramh1.vJA = new cl(paramh2);
    paramh1.vJB = new ae(paramh2);
    paramh1.vJC = new bo(paramh2);
    AppMethodBeat.o(116911);
  }
  
  public void setBizTimeLineCallback(com.tencent.mm.plugin.messenger.foundation.a.b paramb)
  {
    this.OdC = paramb;
  }
  
  public void setEnSendMsgActionFlag(int paramInt)
  {
    AppMethodBeat.i(116913);
    ad.i("MicroMsg.TAG", "setEnSendMsgActionFlag %s", new Object[] { Integer.valueOf(paramInt) });
    this.OdA = paramInt;
    AppMethodBeat.o(116913);
  }
  
  public void setIDataTransferFactoryDelegate(an paraman)
  {
    this.OdB = paraman;
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