package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.e.b;
import com.tencent.mm.ah.e.d;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.bx;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.r.a;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.aj;
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
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.api.bucket.d, ai, com.tencent.mm.plugin.messenger.foundation.a.p
{
  private com.tencent.mm.model.e dVM = new com.tencent.mm.model.e();
  private d mcR;
  private e mcS;
  private bx mcT = new bx();
  private com.tencent.mm.plugin.chatroom.a mcU = new com.tencent.mm.plugin.chatroom.a();
  private ai mcV;
  private com.tencent.mm.plugin.messenger.foundation.a.b mcW;
  
  public HashMap<Integer, h.d> collectDatabaseFactory()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("MESSAGE_TABLE".hashCode()), new PluginMessengerFoundation.12(this));
    localHashMap.put(Integer.valueOf("CONTACT_TABLE".hashCode()), new PluginMessengerFoundation.13(this));
    localHashMap.put(Integer.valueOf("OPLOG_TABLE".hashCode()), new PluginMessengerFoundation.14(this));
    localHashMap.put(Integer.valueOf("CONVERSATION_TABLE".hashCode()), new PluginMessengerFoundation.15(this));
    localHashMap.put(Integer.valueOf("ROLEINFO_TABLE".hashCode()), new PluginMessengerFoundation.16(this));
    localHashMap.put(Integer.valueOf("STRANGER_TABLE".hashCode()), new PluginMessengerFoundation.17(this));
    localHashMap.put(Integer.valueOf("DeletedConversationInfo".hashCode()), new PluginMessengerFoundation.2(this));
    localHashMap.put(Integer.valueOf("LBSVERIFYMESSAGE_TABLE".hashCode()), new PluginMessengerFoundation.3(this));
    localHashMap.put(Integer.valueOf("SHAKEVERIFYMESSAGE_TABLE".hashCode()), new PluginMessengerFoundation.4(this));
    localHashMap.put(Integer.valueOf("VERIFY_CONTACT_TABLE".hashCode()), new PluginMessengerFoundation.5(this));
    localHashMap.put(Integer.valueOf("FMESSAGE_MSGINFO_TABLE".hashCode()), new h.d()
    {
      public final String[] rK()
      {
        return ay.dXp;
      }
    });
    localHashMap.put(Integer.valueOf("FMESSAGE_CONVERSATION_TABLE".hashCode()), new PluginMessengerFoundation.7(this));
    localHashMap.put(Integer.valueOf("CHATROOM_MSGSEQ_TABLE".hashCode()), new PluginMessengerFoundation.8(this));
    localHashMap.put(Integer.valueOf("GetSysCmdMsgInfo".hashCode()), new PluginMessengerFoundation.9(this));
    return localHashMap;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    y.i("MicroMsg.TAG", "init thread pool[%s] current tid[%d] priority[%d] process[%s]", new Object[] { com.tencent.mm.sdk.f.e.csu(), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(Thread.currentThread().getPriority()), ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.DM().Dr()).dIA });
    com.tencent.mm.plugin.zero.c.rSq = new PluginMessengerFoundation.1(this);
    Object localObject = new a();
    r.a.a(2, (r)localObject);
    r.a.a(17, (r)localObject);
    r.a.a(4, (r)localObject);
    r.a.a(7, new b());
    localObject = new c();
    r.a.a(5, (r)localObject);
    r.a.a(8, (r)localObject);
    r.a.a(9, (r)localObject);
    r.a.a(1, new h());
    com.tencent.mm.kernel.g.DL().a(q.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.modelmulti.m()));
    com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.zero.a.d.class);
    if (paramg.Ex())
    {
      new com.tencent.mm.plugin.zero.tasks.b().before(this);
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.messenger.foundation.a.d.class, new PluginMessengerFoundation.10(this));
      com.tencent.mm.kernel.g.a(i.class, new i()
      {
        public final e.b a(e.a paramAnonymousa, t paramAnonymoust)
        {
          return c.a(paramAnonymousa, paramAnonymoust);
        }
      });
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.chatroom.a.c.class, this.mcU);
    }
  }
  
  public void dependency()
  {
    dependsOn(PluginZero.class);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    if (paramg.Ex())
    {
      this.mcR = new d();
      com.tencent.mm.kernel.g.a(j.class, new com.tencent.mm.kernel.c.e(this.mcR));
      this.mcS = new e();
      com.tencent.mm.kernel.g.a(k.class, new com.tencent.mm.kernel.c.e(this.mcS));
    }
  }
  
  public com.tencent.mm.plugin.messenger.foundation.a.b getBizTimeLineCallback()
  {
    return this.mcW;
  }
  
  public List<ah> getDataTransferList()
  {
    if (this.mcV != null)
    {
      List localList = this.mcV.getDataTransferList();
      if (localList.size() > 8) {
        Assert.assertTrue("Do not add more IDataTransfer from mIDataTransferFactoryDelegate!!!!!!!!!!!", false);
      }
      return localList;
    }
    return new ArrayList();
  }
  
  public bx getSysCmdMsgExtension()
  {
    return this.mcT;
  }
  
  public void installed()
  {
    alias(com.tencent.mm.plugin.messenger.foundation.a.p.class);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    e.d.a(Integer.valueOf(10000), this.dVM);
    e.d.a(Integer.valueOf(1), this.dVM);
    e.d.a(Integer.valueOf(10001), this.mcT);
    e.d.a(Integer.valueOf(10002), this.mcT);
  }
  
  public void onAccountRelease()
  {
    e.d.b(Integer.valueOf(10000), this.dVM);
    e.d.b(Integer.valueOf(1), this.dVM);
    e.d.b(Integer.valueOf(10001), this.mcT);
    e.d.b(Integer.valueOf(10002), this.mcT);
  }
  
  public void onDataBaseClosed(com.tencent.mm.cf.h paramh1, com.tencent.mm.cf.h paramh2) {}
  
  public void onDataBaseOpened(com.tencent.mm.cf.h paramh1, com.tencent.mm.cf.h paramh2)
  {
    com.tencent.mm.model.p.Gh();
    paramh1 = this.mcR;
    paramh2 = com.tencent.mm.kernel.g.DP().dKu;
    com.tencent.mm.cf.h localh = com.tencent.mm.kernel.g.DP().dKv;
    paramh1.mcH = new com.tencent.mm.ay.m(new com.tencent.mm.ay.h(paramh2));
    paramh1.mcD = new aj(paramh2);
    paramh1.mcE = new bw(paramh2);
    paramh1.mcG = new al(paramh2);
    paramh1.mcF = new bj(paramh2, paramh1.mcD, paramh1.mcG);
    paramh1.mcI = new br(paramh2);
    paramh1.mcJ = new ao(paramh2);
    paramh1.mcK = new ay(paramh2);
    paramh1.mcL = new aw(paramh2);
    paramh1.mcM = new bg(paramh2);
    paramh1.mcN = new bu(paramh2);
    paramh1.mcO = new cb(paramh2);
    paramh1.mcP = new x(paramh2);
    paramh1.mcQ = new bc(paramh2);
  }
  
  public void setBizTimeLineCallback(com.tencent.mm.plugin.messenger.foundation.a.b paramb)
  {
    this.mcW = paramb;
  }
  
  public void setIDataTransferFactoryDelegate(ai paramai)
  {
    this.mcV = paramai;
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