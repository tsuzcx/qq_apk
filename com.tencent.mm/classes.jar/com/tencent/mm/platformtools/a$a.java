package com.tencent.mm.platformtools;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bm;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class a$a
  implements Runnable
{
  private static byte[] eKs;
  public static boolean fBf;
  private static final ak gjb;
  private List<String[]> giW;
  private List<String[]> giX;
  private List<com.tencent.mm.plugin.account.friend.a.a> giY;
  private List<com.tencent.mm.plugin.account.friend.a.a> giZ;
  private bm gja;
  
  static
  {
    AppMethodBeat.i(124511);
    fBf = false;
    eKs = new byte[0];
    gjb = new ak(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(124506);
        if (!com.tencent.mm.kernel.g.RG())
        {
          AppMethodBeat.o(124506);
          return;
        }
        g.a locala = new g.a();
        int i = a.giS.size();
        boolean bool = Boolean.parseBoolean(paramAnonymousMessage.obj.toString());
        paramAnonymousMessage = a.giS.iterator();
        while (paramAnonymousMessage.hasNext()) {
          ((com.tencent.mm.plugin.account.a.a.b)paramAnonymousMessage.next()).cY(bool);
        }
        a.giS.clear();
        ab.i("MicroMsg.AddrBookSyncHelper", "callBackHandler setSize:%d time:%d", new Object[] { Integer.valueOf(i), Long.valueOf(locala.Mm()) });
        AppMethodBeat.o(124506);
      }
    };
    AppMethodBeat.o(124511);
  }
  
  private static void aoi()
  {
    AppMethodBeat.i(124509);
    bm localbm = new bm("MicroMsg.AddrBookSyncHelper", "delete");
    ArrayList localArrayList = new ArrayList();
    List localList = com.tencent.mm.pluginsdk.a.fI(ah.getContext());
    Iterator localIterator = ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).aqi().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String[])localIterator.next();
      String str = bo.nullAsNil(localObject[0]);
      localObject = bo.nullAsNil(localObject[1]);
      if ((!str.equals("")) && (!localList.contains(str))) {
        localArrayList.add(localObject);
      }
    }
    if (localArrayList.size() > 0)
    {
      ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).an(localArrayList);
      l.ap(localArrayList);
    }
    localbm.addSplit("end");
    localbm.dumpToLog();
    AppMethodBeat.o(124509);
  }
  
  private static List<com.tencent.mm.plugin.account.friend.a.a> b(List<com.tencent.mm.plugin.account.friend.a.a> paramList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(124507);
    LinkedList localLinkedList = new LinkedList();
    while (paramInt1 < paramInt2)
    {
      localLinkedList.add(paramList.get(paramInt1));
      paramInt1 += 1;
    }
    AppMethodBeat.o(124507);
    return localLinkedList;
  }
  
  private static List<com.tencent.mm.plugin.account.friend.a.a> c(int paramInt, List<String[]> paramList)
  {
    AppMethodBeat.i(124510);
    if (paramList == null)
    {
      ab.e("MicroMsg.AddrBookSyncHelper", "sync address book failed, null info list");
      paramList = new LinkedList();
      AppMethodBeat.o(124510);
      return paramList;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (String[])localIterator.next();
      if (paramList != null)
      {
        Object localObject1 = paramList[0];
        String str1 = paramList[1];
        String str2 = paramList[2];
        Object localObject2 = paramList[3];
        long l = bo.apW(paramList[4]);
        if ((str2 != null) && (!str2.equals("")))
        {
          paramList = "";
          if (paramInt == 1) {
            paramList = com.tencent.mm.a.g.w(str2.getBytes());
          }
          if (paramInt == 0)
          {
            paramList = com.tencent.mm.pluginsdk.a.xw(str2);
            if (bo.isNullOrNil(paramList)) {
              ab.d("MicroMsg.AddrBookSyncHelper", "formatted mobile null, continue");
            } else {
              paramList = com.tencent.mm.a.g.w(paramList.getBytes());
            }
          }
          else
          {
            com.tencent.mm.plugin.account.friend.a.a locala = new com.tencent.mm.plugin.account.friend.a.a();
            locala.ezj = str1;
            locala.gwG = g.wr(str1);
            locala.gwH = g.wq(str1);
            locala.gwE = localObject1;
            locala.fsf = localObject2;
            locala.wW(paramList);
            locala.gxh = l;
            locala.gwN = locala.Nu();
            if (paramInt == 1) {
              locala.dqF = str2;
            }
            if (paramInt == 0) {
              locala.gwK = str2;
            }
            locala.type = paramInt;
            locala.bsY = 1095798;
            localArrayList.add(locala);
          }
        }
      }
    }
    AppMethodBeat.o(124510);
    return localArrayList;
  }
  
  public final void run()
  {
    AppMethodBeat.i(124508);
    synchronized (eKs)
    {
      this.gja = new bm("MicroMsg.AddrBookSyncHelper", "sync addrBook");
      this.gja.addSplit("sync begin");
      ab.d("MicroMsg.AddrBookSyncHelper", "reading email info");
      this.giW = com.tencent.mm.pluginsdk.a.fH(ah.getContext());
      if (this.giW != null) {
        ab.i("MicroMsg.AddrBookSyncHelper", "sync address book email size: " + this.giW.size());
      }
      this.giZ = c(1, this.giW);
      ab.d("MicroMsg.AddrBookSyncHelper", "reading mobile info");
      this.giX = com.tencent.mm.pluginsdk.a.fG(ah.getContext());
      if (this.giX != null) {
        ab.i("MicroMsg.AddrBookSyncHelper", "sync address book mobile size: " + this.giX.size());
      }
      this.giY = c(0, this.giX);
      ab.d("MicroMsg.AddrBookSyncHelper", "reading done, begin sync to addr_upload");
      if ((this.giW != null) && (this.giZ.size() > 0))
      {
        i = 0;
        if (i < this.giZ.size())
        {
          ab.i("MicroMsg.AddrBookSyncHelper", "sync email index: ".concat(String.valueOf(i)));
          if (i + 100 < this.giZ.size()) {}
          for (localObject1 = b(this.giZ, i, i + 100);; localObject1 = b((List)localObject1, i, ((List)localObject1).size()))
          {
            ab.i("MicroMsg.AddrBookSyncHelper", "sync email listToSync size: " + ((List)localObject1).size());
            l.aq((List)localObject1);
            i += 100;
            break;
            localObject1 = this.giZ;
          }
        }
      }
      if ((this.giY == null) || (this.giY.size() == 0))
      {
        ab.i("MicroMsg.AddrBookSyncHelper", "mobile list null stop service");
        localObject1 = gjb.obtainMessage();
        ((Message)localObject1).obj = Boolean.FALSE;
        gjb.sendMessage((Message)localObject1);
        AppMethodBeat.o(124508);
        return;
      }
      int i = 0;
      if (i < this.giY.size())
      {
        ab.i("MicroMsg.AddrBookSyncHelper", "sync mobile index: ".concat(String.valueOf(i)));
        if (!com.tencent.mm.kernel.g.RG())
        {
          ab.i("MicroMsg.AddrBookSyncHelper", "account not ready, stop sync");
          localObject1 = gjb.obtainMessage();
          ((Message)localObject1).obj = Boolean.FALSE;
          gjb.sendMessage((Message)localObject1);
          AppMethodBeat.o(124508);
          return;
        }
        if (i + 100 < this.giY.size()) {}
        for (localObject1 = b(this.giY, i, i + 100);; localObject1 = b((List)localObject1, i, ((List)localObject1).size()))
        {
          ab.i("MicroMsg.AddrBookSyncHelper", "sync mobile listToSync size: " + ((List)localObject1).size());
          l.aq((List)localObject1);
          i += 100;
          break;
          localObject1 = this.giY;
        }
      }
      ab.i("MicroMsg.AddrBookSyncHelper", "sync ok");
      if (!com.tencent.mm.kernel.g.RG())
      {
        ab.i("MicroMsg.AddrBookSyncHelper", "account not ready, exit");
        localObject1 = gjb.obtainMessage();
        ((Message)localObject1).obj = Boolean.FALSE;
        gjb.sendMessage((Message)localObject1);
        AppMethodBeat.o(124508);
        return;
      }
      aoi();
      System.currentTimeMillis();
      l.aqv();
      this.gja.addSplit("sync ok");
      this.gja.dumpToLog();
      Object localObject1 = gjb.obtainMessage();
      ((Message)localObject1).obj = Boolean.TRUE;
      gjb.sendMessage((Message)localObject1);
      AppMethodBeat.o(124508);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.platformtools.a.a
 * JD-Core Version:    0.7.0.1
 */