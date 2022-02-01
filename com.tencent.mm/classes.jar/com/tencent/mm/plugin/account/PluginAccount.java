package com.tencent.mm.plugin.account;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.model.y;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.account.friend.model.am;
import com.tencent.mm.plugin.account.friend.model.ao;
import com.tencent.mm.plugin.account.friend.model.aq;
import com.tencent.mm.plugin.account.friend.model.e;
import com.tencent.mm.plugin.account.friend.model.h;
import com.tencent.mm.plugin.account.friend.model.n;
import com.tencent.mm.protocal.protobuf.dib;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.LinkedList;

public class PluginAccount
  extends f
  implements com.tencent.mm.plugin.account.sdk.a.a
{
  public void clearFriendData()
  {
    AppMethodBeat.i(127764);
    b.clearFriendData();
    AppMethodBeat.o(127764);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(127754);
    com.tencent.mm.br.b.bsa("account");
    pin(new y(com.tencent.mm.plugin.account.model.l.class));
    pin(new y(b.class));
    pin(new y(com.tencent.mm.plugin.account.security.model.g.class));
    Log.i("MicroMsg.PluginAccount", "execute PluginAccount");
    AppMethodBeat.o(127754);
  }
  
  public com.tencent.mm.plugin.account.friend.model.b getAddrUploadStg()
  {
    AppMethodBeat.i(127755);
    com.tencent.mm.plugin.account.friend.model.b localb = b.getAddrUploadStg();
    AppMethodBeat.o(127755);
    return localb;
  }
  
  public e getFacebookFrdStg()
  {
    AppMethodBeat.i(127756);
    e locale = b.getFacebookFrdStg();
    AppMethodBeat.o(127756);
    return locale;
  }
  
  public h getFrdExtStg()
  {
    AppMethodBeat.i(127757);
    h localh = b.getFrdExtStg();
    AppMethodBeat.o(127757);
    return localh;
  }
  
  public LinkedList<dib> getFriendData()
  {
    AppMethodBeat.i(127763);
    LinkedList localLinkedList = b.getFriendData();
    AppMethodBeat.o(127763);
    return localLinkedList;
  }
  
  public com.tencent.mm.plugin.account.friend.model.l getGoogleFriendStorage()
  {
    AppMethodBeat.i(127761);
    com.tencent.mm.plugin.account.friend.model.l locall = b.getGoogleFriendStorage();
    AppMethodBeat.o(127761);
    return locall;
  }
  
  public n getInviteFriendOpenStg()
  {
    AppMethodBeat.i(127759);
    n localn = b.getInviteFriendOpenStg();
    AppMethodBeat.o(127759);
    return localn;
  }
  
  public am getOldAccountFriendStorage()
  {
    AppMethodBeat.i(184132);
    am localam = b.getOldAccountFriendStorage();
    AppMethodBeat.o(184132);
    return localam;
  }
  
  public ao getQQGroupStg()
  {
    AppMethodBeat.i(127758);
    ao localao = b.getQQGroupStg();
    AppMethodBeat.o(127758);
    return localao;
  }
  
  public aq getQQListStg()
  {
    AppMethodBeat.i(127760);
    aq localaq = b.getQQListStg();
    AppMethodBeat.o(127760);
    return localaq;
  }
  
  public void removeSelfAccount(Context paramContext)
  {
    AppMethodBeat.i(127767);
    AppMethodBeat.o(127767);
  }
  
  public void setFriendData(LinkedList paramLinkedList)
  {
    AppMethodBeat.i(127762);
    b.setFriendData(paramLinkedList);
    AppMethodBeat.o(127762);
  }
  
  public void showAddrBookUploadConfirm(Activity paramActivity, Runnable paramRunnable, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(127766);
    v.showAddrBookUploadConfirm(paramActivity, paramRunnable, paramBoolean, paramInt);
    AppMethodBeat.o(127766);
  }
  
  public boolean syncAddrBook(com.tencent.mm.plugin.account.sdk.a.b paramb)
  {
    AppMethodBeat.i(127770);
    boolean bool = com.tencent.mm.platformtools.a.syncAddrBook(paramb);
    AppMethodBeat.o(127770);
    return bool;
  }
  
  public void syncAddrBookAndUpload()
  {
    AppMethodBeat.i(127765);
    MMApplicationContext.getContext();
    com.tencent.mm.platformtools.a.bTl();
    AppMethodBeat.o(127765);
  }
  
  public void syncUploadMContactStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(127769);
    v.syncUploadMContactStatus(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(127769);
  }
  
  public void updateAllContact()
  {
    AppMethodBeat.i(127771);
    AppMethodBeat.o(127771);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.PluginAccount
 * JD-Core Version:    0.7.0.1
 */