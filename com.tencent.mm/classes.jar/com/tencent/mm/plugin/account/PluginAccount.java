package com.tencent.mm.plugin.account;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.friend.a.an;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.account.friend.a.h;
import com.tencent.mm.plugin.account.friend.a.k;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.plugin.account.model.j;
import com.tencent.mm.protocal.protobuf.bai;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.LinkedList;

public class PluginAccount
  extends f
  implements com.tencent.mm.plugin.account.a.a.a
{
  public void clearFriendData()
  {
    AppMethodBeat.i(124606);
    a.clearFriendData();
    AppMethodBeat.o(124606);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(124596);
    c.anb("account");
    pin(new com.tencent.mm.model.q(j.class));
    pin(new com.tencent.mm.model.q(a.class));
    pin(new com.tencent.mm.model.q(com.tencent.mm.plugin.account.security.a.g.class));
    ab.i("MicroMsg.PluginAccount", "execute PluginAccount");
    AppMethodBeat.o(124596);
  }
  
  public com.tencent.mm.plugin.account.friend.a.b getAddrUploadStg()
  {
    AppMethodBeat.i(124597);
    com.tencent.mm.plugin.account.friend.a.b localb = a.getAddrUploadStg();
    AppMethodBeat.o(124597);
    return localb;
  }
  
  public h getFacebookFrdStg()
  {
    AppMethodBeat.i(124598);
    h localh = a.getFacebookFrdStg();
    AppMethodBeat.o(124598);
    return localh;
  }
  
  public k getFrdExtStg()
  {
    AppMethodBeat.i(124599);
    k localk = a.getFrdExtStg();
    AppMethodBeat.o(124599);
    return localk;
  }
  
  public LinkedList<bai> getFriendData()
  {
    AppMethodBeat.i(124605);
    LinkedList localLinkedList = a.getFriendData();
    AppMethodBeat.o(124605);
    return localLinkedList;
  }
  
  public o getGoogleFriendStorage()
  {
    AppMethodBeat.i(124603);
    o localo = a.getGoogleFriendStorage();
    AppMethodBeat.o(124603);
    return localo;
  }
  
  public com.tencent.mm.plugin.account.friend.a.q getInviteFriendOpenStg()
  {
    AppMethodBeat.i(124601);
    com.tencent.mm.plugin.account.friend.a.q localq = a.getInviteFriendOpenStg();
    AppMethodBeat.o(124601);
    return localq;
  }
  
  public String getPhoneNum(Context paramContext, String paramString)
  {
    AppMethodBeat.i(124610);
    paramContext = i.getPhoneNum(paramContext, paramString);
    AppMethodBeat.o(124610);
    return paramContext;
  }
  
  public an getQQGroupStg()
  {
    AppMethodBeat.i(124600);
    an localan = a.getQQGroupStg();
    AppMethodBeat.o(124600);
    return localan;
  }
  
  public ap getQQListStg()
  {
    AppMethodBeat.i(124602);
    ap localap = a.getQQListStg();
    AppMethodBeat.o(124602);
    return localap;
  }
  
  public void removeSelfAccount(Context paramContext)
  {
    AppMethodBeat.i(124609);
    w.ct(paramContext);
    AppMethodBeat.o(124609);
  }
  
  public void setFriendData(LinkedList paramLinkedList)
  {
    AppMethodBeat.i(124604);
    a.setFriendData(paramLinkedList);
    AppMethodBeat.o(124604);
  }
  
  public void showAddrBookUploadConfirm(Activity paramActivity, Runnable paramRunnable, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(124608);
    z.showAddrBookUploadConfirm(paramActivity, paramRunnable, paramBoolean, paramInt);
    AppMethodBeat.o(124608);
  }
  
  public boolean syncAddrBook(com.tencent.mm.plugin.account.a.a.b paramb)
  {
    AppMethodBeat.i(124612);
    boolean bool = com.tencent.mm.platformtools.a.syncAddrBook(paramb);
    AppMethodBeat.o(124612);
    return bool;
  }
  
  public void syncAddrBookAndUpload()
  {
    AppMethodBeat.i(124607);
    ah.getContext();
    com.tencent.mm.platformtools.a.aof();
    AppMethodBeat.o(124607);
  }
  
  public void syncUploadMContactStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(124611);
    z.syncUploadMContactStatus(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(124611);
  }
  
  public void updateAllContact()
  {
    AppMethodBeat.i(124613);
    w.cu(ah.getContext());
    AppMethodBeat.o(124613);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.PluginAccount
 * JD-Core Version:    0.7.0.1
 */