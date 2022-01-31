package com.tencent.mm.ai.a;

import com.tencent.mm.ai.z;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.be;

final class e$1
  implements Runnable
{
  e$1(String paramString, boolean paramBoolean) {}
  
  public final void run()
  {
    Object localObject1 = z.MB();
    Object localObject2 = this.ehz;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("delete from BizChatConversation");
    ((StringBuilder)localObject3).append(" where brandUserName = '").append((String)localObject2).append("' ");
    localObject3 = ((StringBuilder)localObject3).toString();
    boolean bool = ((b)localObject1).dXw.gk("BizChatConversation", (String)localObject3);
    y.i("MicroMsg.BizConversationStorage", "deleteByBrandUserName sql %s,%s", new Object[] { localObject3, Boolean.valueOf(bool) });
    Object localObject4;
    if (bool)
    {
      localObject3 = new a();
      localObject4 = new b.a.b();
      ((b.a.b)localObject4).ehm = -1L;
      ((b.a.b)localObject4).bJw = ((String)localObject2);
      ((b.a.b)localObject4).ehl = b.a.a.ehi;
      ((b.a.b)localObject4).ehn = ((a)localObject3);
      ((b)localObject1).eeJ.bV(localObject4);
      ((b)localObject1).eeJ.doNotify();
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().abu(this.ehz);
    localObject1 = z.MA();
    localObject2 = this.ehz;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("delete from BizChatInfo");
    ((StringBuilder)localObject3).append(" where brandUserName = '").append((String)localObject2).append("' ");
    localObject3 = ((StringBuilder)localObject3).toString();
    bool = ((d)localObject1).dXw.gk("BizChatInfo", (String)localObject3);
    y.i("MicroMsg.BizChatInfoStorage", "deleteByBrandUserName sql %s,%s", new Object[] { localObject3, Boolean.valueOf(bool) });
    if (bool)
    {
      localObject3 = new c();
      localObject4 = new d.a.b();
      ((d.a.b)localObject4).ehm = -1L;
      ((d.a.b)localObject4).bJw = ((String)localObject2);
      ((d.a.b)localObject4).ehw = d.a.a.eht;
      ((d.a.b)localObject4).ehx = ((c)localObject3);
      ((d)localObject1).eeJ.bV(localObject4);
      ((d)localObject1).eeJ.doNotify();
    }
    com.tencent.mm.vfs.e.K(e.bT(this.ehz), true);
    if (this.ehA)
    {
      localObject1 = z.MC();
      localObject2 = this.ehz;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("delete from BizChatUserInfo");
      ((StringBuilder)localObject3).append(" where brandUserName = '").append((String)localObject2).append("' ");
      localObject2 = ((StringBuilder)localObject3).toString();
      bool = ((k)localObject1).dXw.gk("BizChatUserInfo", (String)localObject2);
      y.i("MicroMsg.BizChatUserInfoStorage", "deleteByBrandUserName sql %s,%s", new Object[] { localObject2, Boolean.valueOf(bool) });
      if (bool)
      {
        localObject2 = new j();
        localObject3 = new k.a.b();
        ((k.a.b)localObject3).ehY = k.a.a.ehV;
        ((k.a.b)localObject3).ehZ = ((j)localObject2);
        ((k)localObject1).eeJ.bV(localObject3);
        ((k)localObject1).eeJ.doNotify();
      }
      z.MD().lA(this.ehz);
      com.tencent.mm.vfs.e.K(e.ly(this.ehz), true);
    }
    ai.d(new e.1.1(this));
  }
  
  public final String toString()
  {
    return super.toString() + "|deleteMsgByTalkers";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ai.a.e.1
 * JD-Core Version:    0.7.0.1
 */