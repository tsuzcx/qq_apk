package com.tencent.mm.plugin.account;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.model.p;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.friend.a.an;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.account.friend.a.h;
import com.tencent.mm.plugin.account.friend.a.k;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.plugin.account.friend.a.q;
import com.tencent.mm.protocal.c.auc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public class PluginAccount
  extends f
  implements com.tencent.mm.plugin.account.a.a.a
{
  public void clearFriendData() {}
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    c.Xg("account");
    pin(new p(com.tencent.mm.plugin.account.model.i.class));
    pin(new p(b.class));
    pin(new p(com.tencent.mm.plugin.account.security.a.g.class));
    y.i("MicroMsg.PluginAccount", "execute PluginAccount");
  }
  
  public com.tencent.mm.plugin.account.friend.a.b getAddrUploadStg()
  {
    return b.getAddrUploadStg();
  }
  
  public h getFacebookFrdStg()
  {
    return b.getFacebookFrdStg();
  }
  
  public k getFrdExtStg()
  {
    return b.getFrdExtStg();
  }
  
  public LinkedList<auc> getFriendData()
  {
    return b.getFriendData();
  }
  
  public o getGoogleFriendStorage()
  {
    return b.getGoogleFriendStorage();
  }
  
  public q getInviteFriendOpenStg()
  {
    return b.getInviteFriendOpenStg();
  }
  
  public String getPhoneNum(Context paramContext, String paramString)
  {
    return com.tencent.mm.platformtools.i.getPhoneNum(paramContext, paramString);
  }
  
  public an getQQGroupStg()
  {
    return b.getQQGroupStg();
  }
  
  public ap getQQListStg()
  {
    return b.getQQListStg();
  }
  
  public void removeSelfAccount(Context paramContext)
  {
    w.bM(paramContext);
  }
  
  public void setFriendData(LinkedList paramLinkedList)
  {
    b.setFriendData(paramLinkedList);
  }
  
  public void showAddrBookUploadConfirm(Activity paramActivity, Runnable paramRunnable, boolean paramBoolean, int paramInt)
  {
    z.showAddrBookUploadConfirm(paramActivity, paramRunnable, paramBoolean, paramInt);
  }
  
  public boolean syncAddrBook(com.tencent.mm.plugin.account.a.a.b paramb)
  {
    return com.tencent.mm.platformtools.a.syncAddrBook(paramb);
  }
  
  public void syncAddrBookAndUpload()
  {
    com.tencent.mm.platformtools.a.UG();
  }
  
  public void syncUploadMContactStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    z.syncUploadMContactStatus(paramBoolean1, paramBoolean2);
  }
  
  public void updateAllContact()
  {
    w.bN(ae.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.PluginAccount
 * JD-Core Version:    0.7.0.1
 */