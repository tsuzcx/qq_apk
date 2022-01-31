package com.tencent.mm.aj.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.z;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.be;

final class e$1
  implements Runnable
{
  e$1(String paramString, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(11529);
    Object localObject1 = z.afl();
    Object localObject2 = this.fxD;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("delete from BizChatConversation");
    ((StringBuilder)localObject3).append(" where brandUserName = '").append((String)localObject2).append("' ");
    localObject3 = ((StringBuilder)localObject3).toString();
    boolean bool = ((b)localObject1).db.execSQL("BizChatConversation", (String)localObject3);
    ab.i("MicroMsg.BizConversationStorage", "deleteByBrandUserName sql %s,%s", new Object[] { localObject3, Boolean.valueOf(bool) });
    Object localObject4;
    if (bool)
    {
      localObject3 = new a();
      localObject4 = new b.a.b();
      ((b.a.b)localObject4).fxq = -1L;
      ((b.a.b)localObject4).cqQ = ((String)localObject2);
      ((b.a.b)localObject4).fxp = b.a.a.fxm;
      ((b.a.b)localObject4).fxr = ((a)localObject3);
      ((b)localObject1).fuL.cy(localObject4);
      ((b)localObject1).fuL.doNotify();
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YF().arF(this.fxD);
    localObject1 = z.afk();
    localObject2 = this.fxD;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("delete from BizChatInfo");
    ((StringBuilder)localObject3).append(" where brandUserName = '").append((String)localObject2).append("' ");
    localObject3 = ((StringBuilder)localObject3).toString();
    bool = ((d)localObject1).db.execSQL("BizChatInfo", (String)localObject3);
    ab.i("MicroMsg.BizChatInfoStorage", "deleteByBrandUserName sql %s,%s", new Object[] { localObject3, Boolean.valueOf(bool) });
    if (bool)
    {
      localObject3 = new c();
      localObject4 = new d.a.b();
      ((d.a.b)localObject4).fxq = -1L;
      ((d.a.b)localObject4).cqQ = ((String)localObject2);
      ((d.a.b)localObject4).fxA = d.a.a.fxx;
      ((d.a.b)localObject4).fxB = ((c)localObject3);
      ((d)localObject1).fuL.cy(localObject4);
      ((d)localObject1).fuL.doNotify();
    }
    com.tencent.mm.vfs.e.O(e.cV(this.fxD), true);
    if (this.fxE)
    {
      localObject1 = z.afm();
      localObject2 = this.fxD;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("delete from BizChatUserInfo");
      ((StringBuilder)localObject3).append(" where brandUserName = '").append((String)localObject2).append("' ");
      localObject2 = ((StringBuilder)localObject3).toString();
      bool = ((k)localObject1).db.execSQL("BizChatUserInfo", (String)localObject2);
      ab.i("MicroMsg.BizChatUserInfoStorage", "deleteByBrandUserName sql %s,%s", new Object[] { localObject2, Boolean.valueOf(bool) });
      if (bool)
      {
        localObject2 = new j();
        localObject3 = new k.a.b();
        ((k.a.b)localObject3).fyc = k.a.a.fxZ;
        ((k.a.b)localObject3).fyd = ((j)localObject2);
        ((k)localObject1).fuL.cy(localObject3);
        ((k)localObject1).fuL.doNotify();
      }
      z.afn().sw(this.fxD);
      com.tencent.mm.vfs.e.O(e.su(this.fxD), true);
    }
    al.d(new e.1.1(this));
    AppMethodBeat.o(11529);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(11530);
    String str = super.toString() + "|deleteMsgByTalkers";
    AppMethodBeat.o(11530);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.aj.a.e.1
 * JD-Core Version:    0.7.0.1
 */