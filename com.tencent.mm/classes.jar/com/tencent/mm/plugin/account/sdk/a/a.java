package com.tencent.mm.plugin.account.sdk.a;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEx;
import java.util.LinkedList;

public abstract interface a
  extends d
{
  public abstract void clearFriendData();
  
  public abstract MStorageEx getAddrUploadStg();
  
  public abstract MStorage getFacebookFrdStg();
  
  public abstract MStorage getFrdExtStg();
  
  public abstract LinkedList getFriendData();
  
  public abstract MStorage getGoogleFriendStorage();
  
  public abstract MStorage getInviteFriendOpenStg();
  
  public abstract MAutoStorage getOldAccountFriendStorage();
  
  public abstract MStorage getQQGroupStg();
  
  public abstract MStorageEx getQQListStg();
  
  public abstract void removeSelfAccount(Context paramContext);
  
  public abstract void setFriendData(LinkedList paramLinkedList);
  
  public abstract void showAddrBookUploadConfirm(Activity paramActivity, Runnable paramRunnable, boolean paramBoolean, int paramInt);
  
  public abstract boolean syncAddrBook(b paramb);
  
  public abstract void syncAddrBookAndUpload();
  
  public abstract void syncUploadMContactStatus(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void updateAllContact();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.sdk.a.a
 * JD-Core Version:    0.7.0.1
 */