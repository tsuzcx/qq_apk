package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.d;
import com.tencent.mm.bd.j;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.f.a.df;
import com.tencent.mm.f.a.df.a;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.at;
import com.tencent.mm.model.au;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.ab.a;
import com.tencent.mm.plugin.messenger.foundation.a.ad;
import com.tencent.mm.plugin.messenger.foundation.a.ae;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.protocal.protobuf.cyb;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.a.b.a;
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
import com.tencent.mm.storage.cn;
import com.tencent.mm.storage.cp;
import com.tencent.mm.storage.cu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import junit.framework.Assert;

public class PluginMessengerFoundation
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.api.bucket.d, au, v
{
  private au OdA;
  private com.tencent.mm.plugin.messenger.foundation.a.d OdB;
  private e Odi;
  private f Odj;
  private com.tencent.mm.storage.a.b Odk;
  private com.tencent.mm.model.ck Odl;
  private com.tencent.mm.plugin.chatroom.a Ody;
  public int Odz;
  private final IListener<df> jxr;
  private com.tencent.mm.model.e ltF;
  
  public PluginMessengerFoundation()
  {
    AppMethodBeat.i(116903);
    this.ltF = new com.tencent.mm.model.e();
    this.Odl = new com.tencent.mm.model.ck();
    this.Ody = new com.tencent.mm.plugin.chatroom.a();
    this.Odz = 0;
    this.jxr = new IListener()
    {
      public boolean callback(df paramAnonymousdf)
      {
        AppMethodBeat.i(189610);
        if (paramAnonymousdf.fyV.action == 1)
        {
          Log.i("MicroMsg.TAG", "do init start");
          com.tencent.mm.model.ab.jxo = true;
        }
        for (;;)
        {
          AppMethodBeat.o(189610);
          return false;
          if (paramAnonymousdf.fyV.action == 2)
          {
            Log.i("MicroMsg.TAG", "do init end");
            com.tencent.mm.model.ab.jxo = false;
          }
        }
      }
    };
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
        return com.tencent.mm.storage.ck.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("STRANGER_TABLE".hashCode()), new com.tencent.mm.storagebase.h.b()
    {
      public String[] getSQLs()
      {
        return cp.SQL_CREATE;
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
        return cn.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("VERIFY_CONTACT_TABLE".hashCode()), new com.tencent.mm.storagebase.h.b()
    {
      public String[] getSQLs()
      {
        return cu.SQL_CREATE;
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
    b.a locala = com.tencent.mm.storage.a.b.VIT;
    localHashMap.put(Integer.valueOf(com.tencent.mm.storage.a.b.fuQ().hashCode()), new com.tencent.mm.storagebase.h.b()
    {
      public String[] getSQLs()
      {
        AppMethodBeat.i(187713);
        Object localObject = com.tencent.mm.storage.a.b.VIT;
        localObject = com.tencent.mm.storage.a.b.dqy();
        AppMethodBeat.o(187713);
        return localObject;
      }
    });
    AppMethodBeat.o(116908);
    return localHashMap;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(116906);
    com.tencent.mm.plugin.zero.c.QRh = new com.tencent.mm.cw.c()
    {
      public com.tencent.mm.plugin.zero.a.f get()
      {
        AppMethodBeat.i(169107);
        h localh = new h();
        AppMethodBeat.o(169107);
        return localh;
      }
    };
    Object localObject = new b();
    ab.a.a(2, (com.tencent.mm.plugin.messenger.foundation.a.ab)localObject);
    ab.a.a(17, (com.tencent.mm.plugin.messenger.foundation.a.ab)localObject);
    ab.a.a(4, (com.tencent.mm.plugin.messenger.foundation.a.ab)localObject);
    ab.a.a(7, new c());
    localObject = new d();
    ab.a.a(5, (com.tencent.mm.plugin.messenger.foundation.a.ab)localObject);
    ab.a.a(8, (com.tencent.mm.plugin.messenger.foundation.a.ab)localObject);
    ab.a.a(9, (com.tencent.mm.plugin.messenger.foundation.a.ab)localObject);
    ab.a.a(1, new i());
    com.tencent.mm.kernel.h.aHC().a(aa.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.modelmulti.n()));
    com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.zero.a.d.class);
    if (paramg.aIE())
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
        
        public void processModContact(cyb paramAnonymouscyb, String paramAnonymousString, byte[] paramAnonymousArrayOfByte, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, int paramAnonymousInt)
        {
          AppMethodBeat.i(187767);
          b.processModContact(paramAnonymouscyb, paramAnonymousString, paramAnonymousArrayOfByte, paramAnonymousBoolean1, paramAnonymousBoolean2, paramAnonymousInt);
          AppMethodBeat.o(187767);
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
          h.addSyncDoCmdCallback(paramAnonymousad);
          AppMethodBeat.o(116901);
        }
        
        public com.tencent.mm.an.h.b processAddMsg(h.a paramAnonymousa, ae paramAnonymousae)
        {
          AppMethodBeat.i(116900);
          paramAnonymousa = d.processAddMsg(paramAnonymousa, paramAnonymousae);
          AppMethodBeat.o(116900);
          return paramAnonymousa;
        }
        
        public void removeSyncDoCmdCallback(ad paramAnonymousad)
        {
          AppMethodBeat.i(116902);
          h.removeSyncDoCmdCallback(paramAnonymousad);
          AppMethodBeat.o(116902);
        }
      });
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.chatroom.a.b.class, this.Ody);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.messenger.foundation.a.b.class, new a());
      com.tencent.mm.kernel.h.b(r.class, new g());
      CoreService.aqr();
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
    if (paramg.aIE())
    {
      this.Odi = new e();
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.messenger.foundation.a.n.class, new com.tencent.mm.kernel.c.e(this.Odi));
      this.Odj = new f();
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.messenger.foundation.a.o.class, new com.tencent.mm.kernel.c.e(this.Odj));
    }
    AppMethodBeat.o(116907);
  }
  
  public com.tencent.mm.plugin.messenger.foundation.a.d getBizTimeLineCallback()
  {
    return this.OdB;
  }
  
  public List<at> getDataTransferList()
  {
    AppMethodBeat.i(116912);
    if (this.OdA != null)
    {
      localObject = this.OdA.getDataTransferList();
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
    AppMethodBeat.i(188415);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (this.Odk == null)
    {
      com.tencent.mm.kernel.h.aHH();
      this.Odk = new com.tencent.mm.storage.a.b(com.tencent.mm.kernel.h.aHG().kcF);
    }
    com.tencent.mm.storage.a.b localb = this.Odk;
    AppMethodBeat.o(188415);
    return localb;
  }
  
  public com.tencent.mm.model.ck getSysCmdMsgExtension()
  {
    return this.Odl;
  }
  
  public boolean ifAddTicketByActionFlag(String paramString)
  {
    AppMethodBeat.i(116914);
    boolean bool;
    if (this.Odz == 0) {
      bool = false;
    }
    for (;;)
    {
      Log.i("MicroMsg.TAG", "ifAddTicketByActionFlag %s %s", new Object[] { paramString, Boolean.valueOf(bool) });
      AppMethodBeat.o(116914);
      return bool;
      if (com.tencent.mm.model.ab.PM(paramString))
      {
        if (Util.isEqual(this.Odz & 0x1, 1)) {
          bool = true;
        }
      }
      else if ((com.tencent.mm.model.ab.Lj(paramString)) && (Util.isEqual(this.Odz & 0x2, 2)))
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
    this.jxr.alive();
    h.d.a(Integer.valueOf(10000), this.ltF);
    h.d.a(Integer.valueOf(1), this.ltF);
    h.d.a(Integer.valueOf(10001), this.Odl);
    h.d.a(Integer.valueOf(10002), this.Odl);
    AppMethodBeat.o(116909);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(116910);
    this.jxr.dead();
    h.d.b(Integer.valueOf(10000), this.ltF);
    h.d.b(Integer.valueOf(1), this.ltF);
    h.d.b(Integer.valueOf(10001), this.Odl);
    h.d.b(Integer.valueOf(10002), this.Odl);
    AppMethodBeat.o(116910);
  }
  
  public void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2) {}
  
  public void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(116911);
    y.bcX();
    paramh1 = this.Odi;
    paramh2 = com.tencent.mm.kernel.h.aHG().kcF;
    com.tencent.mm.kernel.h.aHG();
    paramh1.EUZ = new com.tencent.mm.bd.o(new j(paramh2));
    paramh1.EVa = new com.tencent.mm.bd.a();
    paramh1.EUU = new ay(paramh2);
    paramh1.EUV = new cp(paramh2);
    paramh1.EUW = new br(paramh2);
    paramh1.EUY = new ba(paramh2);
    paramh1.EUX = new cb(paramh2, paramh1.EUU, paramh1.EUY);
    paramh1.EVb = new com.tencent.mm.storage.ck(paramh2);
    paramh1.EVc = new bd(paramh2);
    paramh1.EVd = new bo(paramh2);
    paramh1.EVe = new bm(paramh2);
    paramh1.EVf = new by(paramh2);
    paramh1.EVg = new cn(paramh2);
    paramh1.EVh = new cu(paramh2);
    paramh1.EVi = new ak(paramh2);
    paramh1.EVj = new bu(paramh2);
    AppMethodBeat.o(116911);
  }
  
  public void setBizTimeLineCallback(com.tencent.mm.plugin.messenger.foundation.a.d paramd)
  {
    this.OdB = paramd;
  }
  
  public void setEnSendMsgActionFlag(int paramInt)
  {
    AppMethodBeat.i(116913);
    Log.i("MicroMsg.TAG", "setEnSendMsgActionFlag %s", new Object[] { Integer.valueOf(paramInt) });
    this.Odz = paramInt;
    AppMethodBeat.o(116913);
  }
  
  public void setIDataTransferFactoryDelegate(au paramau)
  {
    this.OdA = paramau;
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