package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.d;
import com.tencent.mm.ba.j;
import com.tencent.mm.ba.o;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.as;
import com.tencent.mm.model.at;
import com.tencent.mm.model.y;
import com.tencent.mm.modelmulti.n;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.messenger.foundation.a.w;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.plugin.messenger.foundation.a.x.a;
import com.tencent.mm.plugin.messenger.foundation.a.z;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cb;
import com.tencent.mm.storage.cm;
import com.tencent.mm.storage.co;
import com.tencent.mm.storage.ct;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import junit.framework.Assert;

public class PluginMessengerFoundation
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.api.bucket.d, at, s
{
  private d Uqf;
  private e Uqg;
  private com.tencent.mm.model.cj Uqh;
  private com.tencent.mm.plugin.chatroom.a Uqi;
  public int Uqj;
  private at Uqk;
  private com.tencent.mm.plugin.messenger.foundation.a.b Uql;
  private com.tencent.mm.model.e iDE;
  
  public PluginMessengerFoundation()
  {
    AppMethodBeat.i(116903);
    this.iDE = new com.tencent.mm.model.e();
    this.Uqh = new com.tencent.mm.model.cj();
    this.Uqi = new com.tencent.mm.plugin.chatroom.a();
    this.Uqj = 0;
    AppMethodBeat.o(116903);
  }
  
  public HashMap<Integer, com.tencent.mm.storagebase.h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(116908);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("MESSAGE_TABLE".hashCode()), new com.tencent.mm.storagebase.h.b()
    {
      public String[] getSQLs()
      {
        return cb.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("CONTACT_TABLE".hashCode()), new com.tencent.mm.storagebase.h.b()
    {
      public String[] getSQLs()
      {
        return ay.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("OPLOG_TABLE".hashCode()), new com.tencent.mm.storagebase.h.b()
    {
      public String[] getSQLs()
      {
        return j.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("CONVERSATION_TABLE".hashCode()), new com.tencent.mm.storagebase.h.b()
    {
      public String[] getSQLs()
      {
        return ba.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("ROLEINFO_TABLE".hashCode()), new com.tencent.mm.storagebase.h.b()
    {
      public String[] getSQLs()
      {
        return com.tencent.mm.storage.cj.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("STRANGER_TABLE".hashCode()), new com.tencent.mm.storagebase.h.b()
    {
      public String[] getSQLs()
      {
        return co.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("FRIEND_USER_TABLE".hashCode()), new com.tencent.mm.storagebase.h.b()
    {
      public String[] getSQLs()
      {
        return br.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("DeletedConversationInfo".hashCode()), new com.tencent.mm.storagebase.h.b()
    {
      public String[] getSQLs()
      {
        return bd.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("LBSVERIFYMESSAGE_TABLE".hashCode()), new com.tencent.mm.storagebase.h.b()
    {
      public String[] getSQLs()
      {
        return by.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("SHAKEVERIFYMESSAGE_TABLE".hashCode()), new com.tencent.mm.storagebase.h.b()
    {
      public String[] getSQLs()
      {
        return cm.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("VERIFY_CONTACT_TABLE".hashCode()), new com.tencent.mm.storagebase.h.b()
    {
      public String[] getSQLs()
      {
        return ct.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("FMESSAGE_MSGINFO_TABLE".hashCode()), new com.tencent.mm.storagebase.h.b()
    {
      public String[] getSQLs()
      {
        return bo.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("FMESSAGE_CONVERSATION_TABLE".hashCode()), new com.tencent.mm.storagebase.h.b()
    {
      public String[] getSQLs()
      {
        return bm.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("CHATROOM_MSGSEQ_TABLE".hashCode()), new com.tencent.mm.storagebase.h.b()
    {
      public String[] getSQLs()
      {
        return ak.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("GetSysCmdMsgInfo".hashCode()), new com.tencent.mm.storagebase.h.b()
    {
      public String[] getSQLs()
      {
        return bu.SQL_CREATE;
      }
    });
    AppMethodBeat.o(116908);
    return localHashMap;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(116906);
    com.tencent.mm.plugin.zero.c.JSe = new com.tencent.mm.co.c()
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
    x.a.a(2, (x)localObject);
    x.a.a(17, (x)localObject);
    x.a.a(4, (x)localObject);
    x.a.a(7, new b());
    localObject = new c();
    x.a.a(5, (x)localObject);
    x.a.a(8, (x)localObject);
    x.a.a(9, (x)localObject);
    x.a.a(1, new g());
    com.tencent.mm.kernel.g.aAd().a(w.class, new com.tencent.mm.kernel.c.e(new n()));
    com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.zero.a.d.class);
    if (paramg.aBb())
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
        
        public void processModContact(cpl paramAnonymouscpl, String paramAnonymousString, byte[] paramAnonymousArrayOfByte, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, int paramAnonymousInt)
        {
          AppMethodBeat.i(187480);
          a.processModContact(paramAnonymouscpl, paramAnonymousString, paramAnonymousArrayOfByte, paramAnonymousBoolean1, paramAnonymousBoolean2, paramAnonymousInt);
          AppMethodBeat.o(187480);
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
        
        public com.tencent.mm.ak.h.b processAddMsg(h.a paramAnonymousa, aa paramAnonymousaa)
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
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.chatroom.a.c.class, this.Uqi);
      CoreService.akv();
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
    if (paramg.aBb())
    {
      this.Uqf = new d();
      com.tencent.mm.kernel.g.a(l.class, new com.tencent.mm.kernel.c.e(this.Uqf));
      this.Uqg = new e();
      com.tencent.mm.kernel.g.a(m.class, new com.tencent.mm.kernel.c.e(this.Uqg));
    }
    AppMethodBeat.o(116907);
  }
  
  public com.tencent.mm.plugin.messenger.foundation.a.b getBizTimeLineCallback()
  {
    return this.Uql;
  }
  
  public List<as> getDataTransferList()
  {
    AppMethodBeat.i(116912);
    if (this.Uqk != null)
    {
      localObject = this.Uqk.getDataTransferList();
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
  
  public com.tencent.mm.model.cj getSysCmdMsgExtension()
  {
    return this.Uqh;
  }
  
  public boolean ifAddTicketByActionFlag(String paramString)
  {
    AppMethodBeat.i(116914);
    boolean bool;
    if (this.Uqj == 0) {
      bool = false;
    }
    for (;;)
    {
      Log.i("MicroMsg.TAG", "ifAddTicketByActionFlag %s %s", new Object[] { paramString, Boolean.valueOf(bool) });
      AppMethodBeat.o(116914);
      return bool;
      if (ab.Iu(paramString))
      {
        if (Util.isEqual(this.Uqj & 0x1, 1)) {
          bool = true;
        }
      }
      else if ((ab.Eq(paramString)) && (Util.isEqual(this.Uqj & 0x2, 2)))
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
    h.d.a(Integer.valueOf(10000), this.iDE);
    h.d.a(Integer.valueOf(1), this.iDE);
    h.d.a(Integer.valueOf(10001), this.Uqh);
    h.d.a(Integer.valueOf(10002), this.Uqh);
    AppMethodBeat.o(116909);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(116910);
    h.d.b(Integer.valueOf(10000), this.iDE);
    h.d.b(Integer.valueOf(1), this.iDE);
    h.d.b(Integer.valueOf(10001), this.Uqh);
    h.d.b(Integer.valueOf(10002), this.Uqh);
    AppMethodBeat.o(116910);
  }
  
  public void onDataBaseClosed(h paramh1, h paramh2) {}
  
  public void onDataBaseOpened(h paramh1, h paramh2)
  {
    AppMethodBeat.i(116911);
    y.aTW();
    paramh1 = this.Uqf;
    paramh2 = com.tencent.mm.kernel.g.aAh().hqK;
    com.tencent.mm.kernel.g.aAh();
    paramh1.zpB = new o(new j(paramh2));
    paramh1.zpC = new com.tencent.mm.ba.a();
    paramh1.zpw = new ay(paramh2);
    paramh1.zpx = new co(paramh2);
    paramh1.zpy = new br(paramh2);
    paramh1.zpA = new ba(paramh2);
    paramh1.zpz = new cb(paramh2, paramh1.zpw, paramh1.zpA);
    paramh1.zpD = new com.tencent.mm.storage.cj(paramh2);
    paramh1.zpE = new bd(paramh2);
    paramh1.zpF = new bo(paramh2);
    paramh1.zpG = new bm(paramh2);
    paramh1.zpH = new by(paramh2);
    paramh1.zpI = new cm(paramh2);
    paramh1.zpJ = new ct(paramh2);
    paramh1.zpK = new ak(paramh2);
    paramh1.zpL = new bu(paramh2);
    AppMethodBeat.o(116911);
  }
  
  public void setBizTimeLineCallback(com.tencent.mm.plugin.messenger.foundation.a.b paramb)
  {
    this.Uql = paramb;
  }
  
  public void setEnSendMsgActionFlag(int paramInt)
  {
    AppMethodBeat.i(116913);
    Log.i("MicroMsg.TAG", "setEnSendMsgActionFlag %s", new Object[] { Integer.valueOf(paramInt) });
    this.Uqj = paramInt;
    AppMethodBeat.o(116913);
  }
  
  public void setIDataTransferFactoryDelegate(at paramat)
  {
    this.Uqk = paramat;
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