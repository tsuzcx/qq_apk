package com.tencent.mm.platformtools;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class a$a
  implements Runnable
{
  private static byte[] dMQ = new byte[0];
  private static final ah eRg = new ah(Looper.getMainLooper())
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      if (!com.tencent.mm.kernel.g.DK()) {
        return;
      }
      g.a locala = new g.a();
      int i = a.eQX.size();
      boolean bool = Boolean.parseBoolean(paramAnonymousMessage.obj.toString());
      paramAnonymousMessage = a.eQX.iterator();
      while (paramAnonymousMessage.hasNext()) {
        ((com.tencent.mm.plugin.account.a.a.b)paramAnonymousMessage.next()).bW(bool);
      }
      a.eQX.clear();
      y.i("MicroMsg.AddrBookSyncHelper", "callBackHandler setSize:%d time:%d", new Object[] { Integer.valueOf(i), Long.valueOf(locala.zJ()) });
    }
  };
  public static boolean ekO = false;
  private List<String[]> eRb;
  private List<String[]> eRc;
  private List<com.tencent.mm.plugin.account.friend.a.a> eRd;
  private List<com.tencent.mm.plugin.account.friend.a.a> eRe;
  private bi eRf;
  
  private static void UJ()
  {
    bi localbi = new bi("MicroMsg.AddrBookSyncHelper", "delete");
    ArrayList localArrayList = new ArrayList();
    List localList = com.tencent.mm.pluginsdk.a.eI(ae.getContext());
    Iterator localIterator = ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).WG().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String[])localIterator.next();
      String str = bk.pm(localObject[0]);
      localObject = bk.pm(localObject[1]);
      if ((!str.equals("")) && (!localList.contains(str))) {
        localArrayList.add(localObject);
      }
    }
    if (localArrayList.size() > 0)
    {
      ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).af(localArrayList);
      l.ah(localArrayList);
    }
    localbi.addSplit("end");
    localbi.dumpToLog();
  }
  
  private static List<com.tencent.mm.plugin.account.friend.a.a> a(List<com.tencent.mm.plugin.account.friend.a.a> paramList, int paramInt1, int paramInt2)
  {
    LinkedList localLinkedList = new LinkedList();
    while (paramInt1 < paramInt2)
    {
      localLinkedList.add(paramList.get(paramInt1));
      paramInt1 += 1;
    }
    return localLinkedList;
  }
  
  private static List<com.tencent.mm.plugin.account.friend.a.a> c(int paramInt, List<String[]> paramList)
  {
    if (paramList == null)
    {
      y.e("MicroMsg.AddrBookSyncHelper", "sync address book failed, null info list");
      return new LinkedList();
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
        long l = bk.ZS(paramList[4]);
        if ((str2 != null) && (!str2.equals("")))
        {
          paramList = "";
          if (paramInt == 1) {
            paramList = com.tencent.mm.a.g.o(str2.getBytes());
          }
          if (paramInt == 0)
          {
            paramList = com.tencent.mm.pluginsdk.a.qa(str2);
            if (bk.bl(paramList)) {
              y.d("MicroMsg.AddrBookSyncHelper", "formatted mobile null, continue");
            } else {
              paramList = com.tencent.mm.a.g.o(paramList.getBytes());
            }
          }
          else
          {
            com.tencent.mm.plugin.account.friend.a.a locala = new com.tencent.mm.plugin.account.friend.a.a();
            locala.dBS = str1;
            locala.feY = g.oZ(str1);
            locala.feZ = g.oY(str1);
            locala.feW = localObject1;
            locala.ebN = localObject2;
            locala.pG(paramList);
            locala.ffz = l;
            locala.fff = locala.AE();
            if (paramInt == 1) {
              locala.cCt = str2;
            }
            if (paramInt == 0) {
              locala.ffc = str2;
            }
            locala.type = paramInt;
            locala.bcw = 1095798;
            localArrayList.add(locala);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public final void run()
  {
    for (;;)
    {
      synchronized (dMQ)
      {
        this.eRf = new bi("MicroMsg.AddrBookSyncHelper", "sync addrBook");
        this.eRf.addSplit("sync begin");
        y.d("MicroMsg.AddrBookSyncHelper", "reading email info");
        this.eRb = com.tencent.mm.pluginsdk.a.eH(ae.getContext());
        if (this.eRb != null) {
          y.i("MicroMsg.AddrBookSyncHelper", "sync address book email size: " + this.eRb.size());
        }
        this.eRe = c(1, this.eRb);
        y.d("MicroMsg.AddrBookSyncHelper", "reading mobile info");
        this.eRc = com.tencent.mm.pluginsdk.a.eG(ae.getContext());
        if (this.eRc != null) {
          y.i("MicroMsg.AddrBookSyncHelper", "sync address book mobile size: " + this.eRc.size());
        }
        this.eRd = c(0, this.eRc);
        y.d("MicroMsg.AddrBookSyncHelper", "reading done, begin sync to addr_upload");
        if ((this.eRb != null) && (this.eRe.size() > 0))
        {
          i = 0;
          if (i < this.eRe.size())
          {
            y.i("MicroMsg.AddrBookSyncHelper", "sync email index: " + i);
            if (i + 100 < this.eRe.size())
            {
              localObject1 = a(this.eRe, i, i + 100);
              y.i("MicroMsg.AddrBookSyncHelper", "sync email listToSync size: " + ((List)localObject1).size());
              l.ai((List)localObject1);
              i += 100;
              continue;
            }
            localObject1 = a(this.eRe, i, this.eRe.size());
            continue;
          }
        }
        if ((this.eRd != null) && (this.eRd.size() != 0)) {
          break label639;
        }
        y.i("MicroMsg.AddrBookSyncHelper", "mobile list null stop service");
        Object localObject1 = eRg.obtainMessage();
        ((Message)localObject1).obj = Boolean.valueOf(false);
        eRg.sendMessage((Message)localObject1);
        return;
        if (i >= this.eRd.size()) {
          break label541;
        }
        y.i("MicroMsg.AddrBookSyncHelper", "sync mobile index: " + i);
        if (!com.tencent.mm.kernel.g.DK())
        {
          y.i("MicroMsg.AddrBookSyncHelper", "account not ready, stop sync");
          localObject1 = eRg.obtainMessage();
          ((Message)localObject1).obj = Boolean.valueOf(false);
          eRg.sendMessage((Message)localObject1);
          return;
        }
      }
      if (i + 100 < this.eRd.size()) {}
      for (Object localObject3 = a(this.eRd, i, i + 100);; localObject3 = a(this.eRd, i, this.eRd.size()))
      {
        y.i("MicroMsg.AddrBookSyncHelper", "sync mobile listToSync size: " + ((List)localObject3).size());
        l.ai((List)localObject3);
        i += 100;
        break;
      }
      label541:
      y.i("MicroMsg.AddrBookSyncHelper", "sync ok");
      if (!com.tencent.mm.kernel.g.DK())
      {
        y.i("MicroMsg.AddrBookSyncHelper", "account not ready, exit");
        localObject3 = eRg.obtainMessage();
        ((Message)localObject3).obj = Boolean.valueOf(false);
        eRg.sendMessage((Message)localObject3);
        return;
      }
      UJ();
      System.currentTimeMillis();
      this.eRf.addSplit("sync ok");
      this.eRf.dumpToLog();
      localObject3 = eRg.obtainMessage();
      ((Message)localObject3).obj = Boolean.valueOf(true);
      eRg.sendMessage((Message)localObject3);
      return;
      label639:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.platformtools.a.a
 * JD-Core Version:    0.7.0.1
 */