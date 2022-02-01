package com.tencent.mm.plugin.messenger.foundation;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.am.g.d;
import com.tencent.mm.autogen.a.dp;
import com.tencent.mm.autogen.a.dp.a;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.av;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.y;
import com.tencent.mm.modelmulti.s;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.ab;
import com.tencent.mm.plugin.messenger.foundation.a.ab.a;
import com.tencent.mm.plugin.messenger.foundation.a.ad;
import com.tencent.mm.plugin.messenger.foundation.a.ae;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.protocal.protobuf.dph;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.a.b.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cd;
import com.tencent.mm.storage.cn;
import com.tencent.mm.storage.cq;
import com.tencent.mm.storage.cs;
import com.tencent.mm.storage.cx;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import junit.framework.Assert;

public class PluginMessengerFoundation
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.api.bucket.d, av, v
{
  private com.tencent.mm.storage.a.b akiA;
  private com.tencent.mm.storage.c.b akiB;
  private cl akiC;
  private com.tencent.mm.plugin.chatroom.a akiD;
  public int akiE;
  private av akiF;
  private com.tencent.mm.plugin.messenger.foundation.a.d akiG;
  private e akiy;
  private f akiz;
  private final IListener<dp> maL;
  private com.tencent.mm.model.e ole;
  
  public PluginMessengerFoundation()
  {
    AppMethodBeat.i(116903);
    this.ole = new com.tencent.mm.model.e();
    this.akiC = new cl();
    this.akiD = new com.tencent.mm.plugin.chatroom.a();
    this.akiE = 0;
    this.maL = new IListener(com.tencent.mm.app.f.hfK)
    {
      public boolean callback(dp paramAnonymousdp)
      {
        AppMethodBeat.i(288655);
        if (paramAnonymousdp.hDE.action == 1)
        {
          Log.i("MicroMsg.TAG", "do init start");
          com.tencent.mm.model.ab.maI = true;
        }
        for (;;)
        {
          AppMethodBeat.o(288655);
          return false;
          if (paramAnonymousdp.hDE.action == 2)
          {
            Log.i("MicroMsg.TAG", "do init end");
            com.tencent.mm.model.ab.maI = false;
          }
        }
      }
    };
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
        return cd.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("CONTACT_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return ba.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("OPLOG_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return com.tencent.mm.ay.j.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("CONVERSATION_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return bc.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("ROLEINFO_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return cn.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("STRANGER_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return cs.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("FRIEND_USER_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return bt.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("DeletedConversationInfo".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return bf.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("LBSVERIFYMESSAGE_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return ca.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("SHAKEVERIFYMESSAGE_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return cq.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("VERIFY_CONTACT_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return cx.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("FMESSAGE_MSGINFO_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return bq.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("FMESSAGE_CONVERSATION_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return bo.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("CHATROOM_MSGSEQ_TABLE".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return am.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("GetSysCmdMsgInfo".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return bw.SQL_CREATE;
      }
    });
    b.a locala = com.tencent.mm.storage.a.b.admP;
    localHashMap.put(Integer.valueOf(com.tencent.mm.storage.a.b.gGG().hashCode()), new PluginMessengerFoundation.19(this));
    AppMethodBeat.o(116908);
    return localHashMap;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(116906);
    com.tencent.mm.plugin.zero.c.XMN = new com.tencent.mm.cp.c()
    {
      public com.tencent.mm.plugin.zero.a.f get()
      {
        AppMethodBeat.i(169107);
        i locali = new i();
        AppMethodBeat.o(169107);
        return locali;
      }
    };
    Object localObject = new b();
    ab.a.a(2, (ab)localObject);
    ab.a.a(17, (ab)localObject);
    ab.a.a(4, (ab)localObject);
    ab.a.a(7, new c());
    localObject = new d();
    ab.a.a(5, (ab)localObject);
    ab.a.a(8, (ab)localObject);
    ab.a.a(9, (ab)localObject);
    ab.a.a(1, new j());
    com.tencent.mm.kernel.h.baA().a(aa.class, new com.tencent.mm.kernel.c.e(new s()));
    com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.zero.a.d.class);
    if (paramg.bbA())
    {
      new com.tencent.mm.plugin.zero.tasks.b().before(this);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.messenger.foundation.a.g.class, new com.tencent.mm.plugin.messenger.foundation.a.g()
      {
        public com.tencent.mm.vending.b.b addContactAssembler(com.tencent.mm.plugin.messenger.foundation.a.f paramAnonymousf)
        {
          AppMethodBeat.i(116899);
          paramAnonymousf = b.addContactAssembler(paramAnonymousf);
          AppMethodBeat.o(116899);
          return paramAnonymousf;
        }
        
        public void processModContact(dph paramAnonymousdph, String paramAnonymousString, byte[] paramAnonymousArrayOfByte, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, int paramAnonymousInt)
        {
          AppMethodBeat.i(288670);
          b.processModContact(paramAnonymousdph, paramAnonymousString, paramAnonymousArrayOfByte, paramAnonymousBoolean1, paramAnonymousBoolean2, paramAnonymousInt);
          AppMethodBeat.o(288670);
        }
        
        public void removeContactAssembler(com.tencent.mm.plugin.messenger.foundation.a.f paramAnonymousf)
        {
          AppMethodBeat.i(169109);
          b.removeContactAssembler(paramAnonymousf);
          AppMethodBeat.o(169109);
        }
      });
      com.tencent.mm.kernel.h.b(m.class, new m()
      {
        public void addSyncDoCmdCallback(ad paramAnonymousad)
        {
          AppMethodBeat.i(116901);
          i.addSyncDoCmdCallback(paramAnonymousad);
          AppMethodBeat.o(116901);
        }
        
        public g.b processAddMsg(g.a paramAnonymousa, ae paramAnonymousae)
        {
          AppMethodBeat.i(116900);
          paramAnonymousa = d.processAddMsg(paramAnonymousa, paramAnonymousae);
          AppMethodBeat.o(116900);
          return paramAnonymousa;
        }
        
        public void removeSyncDoCmdCallback(ad paramAnonymousad)
        {
          AppMethodBeat.i(116902);
          i.removeSyncDoCmdCallback(paramAnonymousad);
          AppMethodBeat.o(116902);
        }
      });
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.chatroom.a.b.class, this.akiD);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.messenger.foundation.a.b.class, new a());
      com.tencent.mm.kernel.h.b(r.class, new g());
      CoreService.aKp();
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
    if (paramg.bbA())
    {
      this.akiy = new e();
      com.tencent.mm.kernel.h.a(n.class, new com.tencent.mm.kernel.c.e(this.akiy));
      this.akiz = new f();
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.messenger.foundation.a.o.class, new com.tencent.mm.kernel.c.e(this.akiz));
    }
    AppMethodBeat.o(116907);
  }
  
  public com.tencent.mm.plugin.messenger.foundation.a.d getBizTimeLineCallback()
  {
    return this.akiG;
  }
  
  public List<com.tencent.mm.model.au> getDataTransferList()
  {
    AppMethodBeat.i(116912);
    if (this.akiF != null)
    {
      localObject = this.akiF.getDataTransferList();
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
  
  public com.tencent.mm.storage.a.b getFileMsgInfoStorage()
  {
    AppMethodBeat.i(288701);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (this.akiA == null)
    {
      com.tencent.mm.kernel.h.baF();
      this.akiA = new com.tencent.mm.storage.a.b(com.tencent.mm.kernel.h.baE().mCN);
    }
    com.tencent.mm.storage.a.b localb = this.akiA;
    AppMethodBeat.o(288701);
    return localb;
  }
  
  public com.tencent.mm.storage.c.b getRecentForwardInfoStorage()
  {
    AppMethodBeat.i(288705);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (this.akiB == null) {
      this.akiB = new com.tencent.mm.storage.c.b();
    }
    com.tencent.mm.storage.c.b localb = this.akiB;
    AppMethodBeat.o(288705);
    return localb;
  }
  
  public cl getSysCmdMsgExtension()
  {
    return this.akiC;
  }
  
  public boolean ifAddTicketByActionFlag(String paramString)
  {
    AppMethodBeat.i(116914);
    boolean bool;
    if (this.akiE == 0) {
      bool = false;
    }
    for (;;)
    {
      Log.i("MicroMsg.TAG", "ifAddTicketByActionFlag %s %s", new Object[] { paramString, Boolean.valueOf(bool) });
      AppMethodBeat.o(116914);
      return bool;
      if (com.tencent.mm.storage.au.bwH(paramString))
      {
        if (Util.isEqual(this.akiE & 0x1, 1)) {
          bool = true;
        }
      }
      else if ((com.tencent.mm.storage.au.bwE(paramString)) && (Util.isEqual(this.akiE & 0x2, 2)))
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
    alias(v.class);
    AppMethodBeat.o(116904);
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(116909);
    this.maL.alive();
    g.d.a(Integer.valueOf(10000), this.ole);
    g.d.a(Integer.valueOf(1), this.ole);
    g.d.a(Integer.valueOf(10001), this.akiC);
    g.d.a(Integer.valueOf(10002), this.akiC);
    ((com.tencent.mm.plugin.zero.a.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.zero.a.d.class)).addNotifyReceiverCallback(new h());
    AppMethodBeat.o(116909);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(116910);
    this.maL.dead();
    g.d.b(Integer.valueOf(10000), this.ole);
    g.d.b(Integer.valueOf(1), this.ole);
    g.d.b(Integer.valueOf(10001), this.akiC);
    g.d.b(Integer.valueOf(10002), this.akiC);
    AppMethodBeat.o(116910);
  }
  
  public void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2) {}
  
  public void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(116911);
    y.bAK();
    paramh1 = this.akiy;
    paramh2 = com.tencent.mm.kernel.h.baE().mCN;
    com.tencent.mm.kernel.h.baE();
    paramh1.KQz = new com.tencent.mm.ay.o(new com.tencent.mm.ay.j(paramh2));
    paramh1.KQA = new com.tencent.mm.ay.a();
    paramh1.KQu = new ba(paramh2);
    paramh1.KQv = new cs(paramh2);
    paramh1.KQw = new bt(paramh2);
    paramh1.KQy = new bc(paramh2);
    paramh1.KQx = new cd(paramh2, paramh1.KQu, paramh1.KQy);
    paramh1.KQB = new cn(paramh2);
    paramh1.KQC = new bf(paramh2);
    paramh1.KQD = new bq(paramh2);
    paramh1.KQE = new bo(paramh2);
    paramh1.KQF = new ca(paramh2);
    paramh1.KQG = new cq(paramh2);
    paramh1.KQH = new cx(paramh2);
    paramh1.KQI = new am(paramh2);
    paramh1.KQJ = new bw(paramh2);
    AppMethodBeat.o(116911);
  }
  
  public void setBizTimeLineCallback(com.tencent.mm.plugin.messenger.foundation.a.d paramd)
  {
    this.akiG = paramd;
  }
  
  public void setEnSendMsgActionFlag(int paramInt)
  {
    AppMethodBeat.i(116913);
    Log.i("MicroMsg.TAG", "setEnSendMsgActionFlag %s", new Object[] { Integer.valueOf(paramInt) });
    this.akiE = paramInt;
    AppMethodBeat.o(116913);
  }
  
  public void setIDataTransferFactoryDelegate(av paramav)
  {
    this.akiF = paramav;
  }
  
  public String toString()
  {
    return "plugin-messenger-foundation";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation
 * JD-Core Version:    0.7.0.1
 */