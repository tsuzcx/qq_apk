package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.d;
import com.tencent.mm.az.n;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.bz;
import com.tencent.mm.modelmulti.m;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.r.a;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.al;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.cb;
import com.tencent.mm.storage.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import junit.framework.Assert;

public class PluginMessengerFoundation
  extends f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.api.bucket.d, com.tencent.mm.model.aj, p
{
  private com.tencent.mm.model.e flW;
  private d oDu;
  private e oDv;
  private bz oDw;
  private com.tencent.mm.plugin.chatroom.a oDx;
  private com.tencent.mm.model.aj oDy;
  private com.tencent.mm.plugin.messenger.foundation.a.b oDz;
  
  public PluginMessengerFoundation()
  {
    AppMethodBeat.i(1050);
    this.flW = new com.tencent.mm.model.e();
    this.oDw = new bz();
    this.oDx = new com.tencent.mm.plugin.chatroom.a();
    AppMethodBeat.o(1050);
  }
  
  public HashMap<Integer, h.d> collectDatabaseFactory()
  {
    AppMethodBeat.i(1055);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("MESSAGE_TABLE".hashCode()), new PluginMessengerFoundation.12(this));
    localHashMap.put(Integer.valueOf("CONTACT_TABLE".hashCode()), new PluginMessengerFoundation.13(this));
    localHashMap.put(Integer.valueOf("OPLOG_TABLE".hashCode()), new PluginMessengerFoundation.14(this));
    localHashMap.put(Integer.valueOf("CONVERSATION_TABLE".hashCode()), new PluginMessengerFoundation.15(this));
    localHashMap.put(Integer.valueOf("ROLEINFO_TABLE".hashCode()), new PluginMessengerFoundation.16(this));
    localHashMap.put(Integer.valueOf("STRANGER_TABLE".hashCode()), new PluginMessengerFoundation.17(this));
    localHashMap.put(Integer.valueOf("DeletedConversationInfo".hashCode()), new PluginMessengerFoundation.2(this));
    localHashMap.put(Integer.valueOf("LBSVERIFYMESSAGE_TABLE".hashCode()), new PluginMessengerFoundation.3(this));
    localHashMap.put(Integer.valueOf("SHAKEVERIFYMESSAGE_TABLE".hashCode()), new h.d()
    {
      public final String[] getSQLs()
      {
        return bu.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("VERIFY_CONTACT_TABLE".hashCode()), new h.d()
    {
      public final String[] getSQLs()
      {
        return cb.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("FMESSAGE_MSGINFO_TABLE".hashCode()), new h.d()
    {
      public final String[] getSQLs()
      {
        return ay.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("FMESSAGE_CONVERSATION_TABLE".hashCode()), new PluginMessengerFoundation.7(this));
    localHashMap.put(Integer.valueOf("CHATROOM_MSGSEQ_TABLE".hashCode()), new PluginMessengerFoundation.8(this));
    localHashMap.put(Integer.valueOf("GetSysCmdMsgInfo".hashCode()), new PluginMessengerFoundation.9(this));
    AppMethodBeat.o(1055);
    return localHashMap;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(1053);
    ab.i("MicroMsg.TAG", "init thread pool[%s] current tid[%d] priority[%d] process[%s]", new Object[] { com.tencent.mm.sdk.g.d.ysm, Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(Thread.currentThread().getPriority()), ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.RI().Rj()).mProcessName });
    com.tencent.mm.plugin.zero.c.vJk = new PluginMessengerFoundation.1(this);
    Object localObject = new a();
    r.a.a(2, (r)localObject);
    r.a.a(17, (r)localObject);
    r.a.a(4, (r)localObject);
    r.a.a(7, new b());
    localObject = new c();
    r.a.a(5, (r)localObject);
    r.a.a(8, (r)localObject);
    r.a.a(9, (r)localObject);
    r.a.a(1, new g());
    com.tencent.mm.kernel.g.RH().a(com.tencent.mm.plugin.messenger.foundation.a.q.class, new com.tencent.mm.kernel.c.e(new m()));
    com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.zero.a.d.class);
    if (paramg.SD())
    {
      new com.tencent.mm.plugin.zero.tasks.b().before(this);
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.messenger.foundation.a.d.class, new PluginMessengerFoundation.10(this));
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.messenger.foundation.a.i.class, new PluginMessengerFoundation.11(this));
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.chatroom.a.c.class, this.oDx);
    }
    AppMethodBeat.o(1053);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(1052);
    dependsOn(PluginZero.class);
    AppMethodBeat.o(1052);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(1054);
    if (paramg.SD())
    {
      this.oDu = new d();
      com.tencent.mm.kernel.g.a(j.class, new com.tencent.mm.kernel.c.e(this.oDu));
      this.oDv = new e();
      com.tencent.mm.kernel.g.a(k.class, new com.tencent.mm.kernel.c.e(this.oDv));
    }
    AppMethodBeat.o(1054);
  }
  
  public com.tencent.mm.plugin.messenger.foundation.a.b getBizTimeLineCallback()
  {
    return this.oDz;
  }
  
  public List<ai> getDataTransferList()
  {
    AppMethodBeat.i(1059);
    if (this.oDy != null)
    {
      localObject = this.oDy.getDataTransferList();
      if (((List)localObject).size() > 8) {
        Assert.assertTrue("Do not add more IDataTransfer from mIDataTransferFactoryDelegate!!!!!!!!!!!", false);
      }
      AppMethodBeat.o(1059);
      return localObject;
    }
    Object localObject = new ArrayList();
    AppMethodBeat.o(1059);
    return localObject;
  }
  
  public bz getSysCmdMsgExtension()
  {
    return this.oDw;
  }
  
  public void installed()
  {
    AppMethodBeat.i(1051);
    alias(p.class);
    AppMethodBeat.o(1051);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(1056);
    e.d.a(Integer.valueOf(10000), this.flW);
    e.d.a(Integer.valueOf(1), this.flW);
    e.d.a(Integer.valueOf(10001), this.oDw);
    e.d.a(Integer.valueOf(10002), this.oDw);
    AppMethodBeat.o(1056);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(1057);
    e.d.b(Integer.valueOf(10000), this.flW);
    e.d.b(Integer.valueOf(1), this.flW);
    e.d.b(Integer.valueOf(10001), this.oDw);
    e.d.b(Integer.valueOf(10002), this.oDw);
    AppMethodBeat.o(1057);
  }
  
  public void onDataBaseClosed(com.tencent.mm.cg.h paramh1, com.tencent.mm.cg.h paramh2) {}
  
  public void onDataBaseOpened(com.tencent.mm.cg.h paramh1, com.tencent.mm.cg.h paramh2)
  {
    AppMethodBeat.i(1058);
    com.tencent.mm.model.q.Zl();
    paramh1 = this.oDu;
    paramh2 = com.tencent.mm.kernel.g.RL().eHS;
    com.tencent.mm.kernel.g.RL();
    paramh1.oDj = new n(new com.tencent.mm.az.i(paramh2));
    paramh1.oDk = new com.tencent.mm.az.a();
    paramh1.oDf = new com.tencent.mm.storage.aj(paramh2);
    paramh1.oDg = new bw(paramh2);
    paramh1.oDi = new al(paramh2);
    paramh1.oDh = new bj(paramh2, paramh1.oDf, paramh1.oDi);
    paramh1.oDl = new br(paramh2);
    paramh1.oDm = new ao(paramh2);
    paramh1.oDn = new ay(paramh2);
    paramh1.oDo = new aw(paramh2);
    paramh1.oDp = new bg(paramh2);
    paramh1.oDq = new bu(paramh2);
    paramh1.oDr = new cb(paramh2);
    paramh1.oDs = new x(paramh2);
    paramh1.oDt = new bc(paramh2);
    AppMethodBeat.o(1058);
  }
  
  public void setBizTimeLineCallback(com.tencent.mm.plugin.messenger.foundation.a.b paramb)
  {
    this.oDz = paramb;
  }
  
  public void setIDataTransferFactoryDelegate(com.tencent.mm.model.aj paramaj)
  {
    this.oDy = paramaj;
  }
  
  public String toString()
  {
    return "plugin-messenger-foundation";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation
 * JD-Core Version:    0.7.0.1
 */