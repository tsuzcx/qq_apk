package com.tencent.mm.plugin.account.a.a;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.n;
import java.util.LinkedList;

public abstract interface a
  extends d
{
  public abstract void clearFriendData();
  
  public abstract n getAddrUploadStg();
  
  public abstract k getFacebookFrdStg();
  
  public abstract k getFrdExtStg();
  
  public abstract LinkedList getFriendData();
  
  public abstract k getGoogleFriendStorage();
  
  public abstract k getInviteFriendOpenStg();
  
  public abstract j getOldAccountFriendStorage();
  
  public abstract k getQQGroupStg();
  
  public abstract n getQQListStg();
  
  public abstract void removeSelfAccount(Context paramContext);
  
  public abstract void setFriendData(LinkedList paramLinkedList);
  
  public abstract void showAddrBookUploadConfirm(Activity paramActivity, Runnable paramRunnable, boolean paramBoolean, int paramInt);
  
  public abstract boolean syncAddrBook(b paramb);
  
  public abstract void syncAddrBookAndUpload();
  
  public abstract void syncUploadMContactStatus(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void updateAllContact();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.a.a.a
 * JD-Core Version:    0.7.0.1
 */