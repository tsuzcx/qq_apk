package com.tencent.mm.plugin.ipcall.a;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.a.g.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;
import java.util.HashMap;

public final class a
{
  private static a nLQ = null;
  private long endTime;
  ak handler;
  private boolean isLoading;
  public ArrayList<a.a> nLP;
  private long startTime;
  
  private a()
  {
    AppMethodBeat.i(21706);
    this.isLoading = false;
    this.nLP = new ArrayList();
    this.startTime = -1L;
    this.endTime = -1L;
    this.handler = new a.1(this, Looper.getMainLooper());
    AppMethodBeat.o(21706);
  }
  
  public static a bIY()
  {
    AppMethodBeat.i(21707);
    if (nLQ == null) {
      nLQ = new a();
    }
    a locala = nLQ;
    AppMethodBeat.o(21707);
    return locala;
  }
  
  public final void a(a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(21708);
    if (parama != null) {
      this.nLP.add(parama);
    }
    if (this.isLoading)
    {
      ab.d("MicroMsg.IPCallAddressBookLoader", "loadAllAddressItem, isLoading is true, ignore");
      AppMethodBeat.o(21708);
      return;
    }
    this.startTime = System.currentTimeMillis();
    if ((b.bJS().size() == 0) || (!paramBoolean))
    {
      ab.d("MicroMsg.IPCallAddressBookLoader", "loadFromSystemAddressBook");
      long l = System.currentTimeMillis();
      new b();
      parama = b.bJR();
      ab.d("MicroMsg.IPCallAddressBookLoader", "getAllAddressItemFromSystemPhoneBook, used %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      Message localMessage = this.handler.obtainMessage();
      localMessage.obj = parama;
      this.handler.sendMessage(localMessage);
      this.isLoading = true;
      AppMethodBeat.o(21708);
      return;
    }
    AppMethodBeat.o(21708);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.a
 * JD-Core Version:    0.7.0.1
 */