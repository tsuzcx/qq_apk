package com.tencent.mm.plugin.account;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.account.friend.a.ar;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.account.friend.a.k;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.plugin.account.friend.a.q;
import com.tencent.mm.plugin.account.model.m;
import com.tencent.mm.protocal.protobuf.cik;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.LinkedList;

public class PluginAccount
  extends f
  implements com.tencent.mm.plugin.account.a.a.a
{
  public void clearFriendData()
  {
    AppMethodBeat.i(127764);
    a.clearFriendData();
    AppMethodBeat.o(127764);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(127754);
    com.tencent.mm.br.b.bfQ("account");
    pin(new com.tencent.mm.model.y(m.class));
    pin(new com.tencent.mm.model.y(a.class));
    pin(new com.tencent.mm.model.y(com.tencent.mm.plugin.account.security.a.g.class));
    Log.i("MicroMsg.PluginAccount", "execute PluginAccount");
    AppMethodBeat.o(127754);
  }
  
  public com.tencent.mm.plugin.account.friend.a.b getAddrUploadStg()
  {
    AppMethodBeat.i(127755);
    com.tencent.mm.plugin.account.friend.a.b localb = a.getAddrUploadStg();
    AppMethodBeat.o(127755);
    return localb;
  }
  
  public com.tencent.mm.plugin.account.friend.a.h getFacebookFrdStg()
  {
    AppMethodBeat.i(127756);
    com.tencent.mm.plugin.account.friend.a.h localh = a.getFacebookFrdStg();
    AppMethodBeat.o(127756);
    return localh;
  }
  
  public k getFrdExtStg()
  {
    AppMethodBeat.i(127757);
    k localk = a.getFrdExtStg();
    AppMethodBeat.o(127757);
    return localk;
  }
  
  public LinkedList<cik> getFriendData()
  {
    AppMethodBeat.i(127763);
    LinkedList localLinkedList = a.getFriendData();
    AppMethodBeat.o(127763);
    return localLinkedList;
  }
  
  public o getGoogleFriendStorage()
  {
    AppMethodBeat.i(127761);
    o localo = a.getGoogleFriendStorage();
    AppMethodBeat.o(127761);
    return localo;
  }
  
  public q getInviteFriendOpenStg()
  {
    AppMethodBeat.i(127759);
    q localq = a.getInviteFriendOpenStg();
    AppMethodBeat.o(127759);
    return localq;
  }
  
  public ap getOldAccountFriendStorage()
  {
    AppMethodBeat.i(184132);
    ap localap = a.getOldAccountFriendStorage();
    AppMethodBeat.o(184132);
    return localap;
  }
  
  public String getPhoneNum(Context paramContext, String paramString)
  {
    AppMethodBeat.i(127768);
    paramContext = com.tencent.mm.platformtools.h.getPhoneNum(paramContext, paramString);
    AppMethodBeat.o(127768);
    return paramContext;
  }
  
  public ar getQQGroupStg()
  {
    AppMethodBeat.i(127758);
    ar localar = a.getQQGroupStg();
    AppMethodBeat.o(127758);
    return localar;
  }
  
  public at getQQListStg()
  {
    AppMethodBeat.i(127760);
    at localat = a.getQQListStg();
    AppMethodBeat.o(127760);
    return localat;
  }
  
  public void removeSelfAccount(Context paramContext)
  {
    AppMethodBeat.i(127767);
    t.ds(paramContext);
    AppMethodBeat.o(127767);
  }
  
  public void setFriendData(LinkedList paramLinkedList)
  {
    AppMethodBeat.i(127762);
    a.setFriendData(paramLinkedList);
    AppMethodBeat.o(127762);
  }
  
  public void showAddrBookUploadConfirm(Activity paramActivity, Runnable paramRunnable, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(127766);
    com.tencent.mm.platformtools.y.showAddrBookUploadConfirm(paramActivity, paramRunnable, paramBoolean, paramInt);
    AppMethodBeat.o(127766);
  }
  
  public boolean syncAddrBook(com.tencent.mm.plugin.account.a.a.b paramb)
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
    com.tencent.mm.platformtools.a.blm();
    AppMethodBeat.o(127765);
  }
  
  public void syncUploadMContactStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(127769);
    com.tencent.mm.platformtools.y.syncUploadMContactStatus(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(127769);
  }
  
  public void updateAllContact()
  {
    AppMethodBeat.i(127771);
    t.dt(MMApplicationContext.getContext());
    AppMethodBeat.o(127771);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.PluginAccount
 * JD-Core Version:    0.7.0.1
 */