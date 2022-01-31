package com.tencent.mm.plugin.ipcall.a;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.ipcall.a.g.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;

public final class a
{
  private static a lou = null;
  private long endTime = -1L;
  ah handler = new a.1(this, Looper.getMainLooper());
  private boolean isLoading = false;
  public ArrayList<a> lot = new ArrayList();
  private long startTime = -1L;
  
  public static a bbR()
  {
    if (lou == null) {
      lou = new a();
    }
    return lou;
  }
  
  public final void a(a parama, boolean paramBoolean)
  {
    if (parama != null) {
      this.lot.add(parama);
    }
    if (this.isLoading) {
      y.d("MicroMsg.IPCallAddressBookLoader", "loadAllAddressItem, isLoading is true, ignore");
    }
    do
    {
      return;
      this.startTime = System.currentTimeMillis();
    } while ((b.bcL().size() != 0) && (paramBoolean));
    y.d("MicroMsg.IPCallAddressBookLoader", "loadFromSystemAddressBook");
    long l = System.currentTimeMillis();
    new b();
    parama = b.bcK();
    y.d("MicroMsg.IPCallAddressBookLoader", "getAllAddressItemFromSystemPhoneBook, used %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    Message localMessage = this.handler.obtainMessage();
    localMessage.obj = parama;
    this.handler.sendMessage(localMessage);
    this.isLoading = true;
  }
  
  public static abstract interface a
  {
    public abstract void aog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.a
 * JD-Core Version:    0.7.0.1
 */