package com.tencent.mm.platformtools;

import android.os.Looper;
import android.os.Message;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public static final HashSet<com.tencent.mm.plugin.account.a.a.b> hTx;
  private static final com.tencent.mm.plugin.account.a.a.b hTy;
  private static Thread thread;
  
  static
  {
    AppMethodBeat.i(127672);
    thread = null;
    hTx = new HashSet();
    hTy = new com.tencent.mm.plugin.account.a.a.b()
    {
      public final void er(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(127662);
        ad.i("MicroMsg.AddrBookSyncHelper", "syncAddrBookAndUpload onSyncEnd suc:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(127662);
          return;
        }
        System.currentTimeMillis();
        l.aIQ();
        ao localao = new ao(l.aIU(), l.aIT());
        com.tencent.mm.kernel.g.aeS().a(localao, 0);
        AppMethodBeat.o(127662);
      }
    };
    AppMethodBeat.o(127672);
  }
  
  public static boolean aGl()
  {
    AppMethodBeat.i(127670);
    boolean bool = syncAddrBook(hTy);
    AppMethodBeat.o(127670);
    return bool;
  }
  
  public static boolean aGm()
  {
    return a.hdF;
  }
  
  public static boolean syncAddrBook(com.tencent.mm.plugin.account.a.a.b paramb)
  {
    AppMethodBeat.i(127671);
    long l = Thread.currentThread().getId();
    boolean bool = l.aIO();
    if (!bool)
    {
      ad.e("MicroMsg.AddrBookSyncHelper", "canSync:%b, skip", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(127671);
      return false;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(127663);
        if ((a.aGn() != null) && (a.aGn().isAlive())) {}
        for (boolean bool = true;; bool = false)
        {
          ad.i("MicroMsg.AddrBookSyncHelper", "syncAddrBook running:%b setSize:%d call:%d callback:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(a.hTx.size()), Long.valueOf(this.hTz), this.hTA });
          a.hTx.add(this.hTA);
          if (!bool) {
            break;
          }
          AppMethodBeat.o(127663);
          return;
        }
        l.eT(true);
        com.tencent.e.h.Iye.aS(new a.a((byte)0));
        AppMethodBeat.o(127663);
      }
    });
    AppMethodBeat.o(127671);
    return true;
  }
  
  static final class a
    implements com.tencent.e.i.h
  {
    private static final ap hTG;
    public static boolean hdF;
    private static byte[] lock;
    private List<String[]> hTB;
    private List<String[]> hTC;
    private List<com.tencent.mm.plugin.account.friend.a.a> hTD;
    private List<com.tencent.mm.plugin.account.friend.a.a> hTE;
    private br hTF;
    
    static
    {
      AppMethodBeat.i(127669);
      hdF = false;
      lock = new byte[0];
      hTG = new ap(Looper.getMainLooper())
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(127664);
          if (!com.tencent.mm.kernel.g.afw())
          {
            AppMethodBeat.o(127664);
            return;
          }
          f.a locala = new f.a();
          int i = a.hTx.size();
          boolean bool = Boolean.parseBoolean(paramAnonymousMessage.obj.toString());
          paramAnonymousMessage = a.hTx.iterator();
          while (paramAnonymousMessage.hasNext()) {
            ((com.tencent.mm.plugin.account.a.a.b)paramAnonymousMessage.next()).er(bool);
          }
          a.hTx.clear();
          ad.i("MicroMsg.AddrBookSyncHelper", "callBackHandler setSize:%d time:%d", new Object[] { Integer.valueOf(i), Long.valueOf(locala.XK()) });
          AppMethodBeat.o(127664);
        }
      };
      AppMethodBeat.o(127669);
    }
    
    private static void aGo()
    {
      AppMethodBeat.i(127667);
      br localbr = new br("MicroMsg.AddrBookSyncHelper", "delete");
      ArrayList localArrayList = new ArrayList();
      List localList = com.tencent.mm.pluginsdk.a.gU(aj.getContext());
      Iterator localIterator = ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).aID().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String[])localIterator.next();
        String str = bt.nullAsNil(localObject[0]);
        localObject = bt.nullAsNil(localObject[1]);
        if ((!str.equals("")) && (!localList.contains(str))) {
          localArrayList.add(localObject);
        }
      }
      if (localArrayList.size() > 0)
      {
        ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).aL(localArrayList);
        l.aN(localArrayList);
      }
      localbr.addSplit("end");
      localbr.dumpToLog();
      AppMethodBeat.o(127667);
    }
    
    private static List<com.tencent.mm.plugin.account.friend.a.a> c(List<com.tencent.mm.plugin.account.friend.a.a> paramList, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(127665);
      LinkedList localLinkedList = new LinkedList();
      while (paramInt1 < paramInt2)
      {
        localLinkedList.add(paramList.get(paramInt1));
        paramInt1 += 1;
      }
      AppMethodBeat.o(127665);
      return localLinkedList;
    }
    
    private static List<com.tencent.mm.plugin.account.friend.a.a> d(int paramInt, List<String[]> paramList)
    {
      AppMethodBeat.i(127668);
      if (paramList == null)
      {
        ad.e("MicroMsg.AddrBookSyncHelper", "sync address book failed, null info list");
        paramList = new LinkedList();
        AppMethodBeat.o(127668);
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
          long l = bt.aGi(paramList[4]);
          if ((str2 != null) && (!str2.equals("")))
          {
            paramList = "";
            if (paramInt == 1) {
              paramList = com.tencent.mm.b.g.getMessageDigest(str2.getBytes());
            }
            if (paramInt == 0)
            {
              paramList = com.tencent.mm.pluginsdk.a.CD(str2);
              if (bt.isNullOrNil(paramList)) {
                ad.d("MicroMsg.AddrBookSyncHelper", "formatted mobile null, continue");
              } else {
                paramList = com.tencent.mm.b.g.getMessageDigest(paramList.getBytes());
              }
            }
            else
            {
              com.tencent.mm.plugin.account.friend.a.a locala = new com.tencent.mm.plugin.account.friend.a.a();
              locala.realName = str1;
              locala.ijD = f.Bs(str1);
              locala.ijE = f.Br(str1);
              locala.ijB = localObject1;
              locala.gUa = localObject2;
              locala.Cb(paramList);
              locala.ike = l;
              locala.ijK = locala.Zh();
              if (paramInt == 1) {
                locala.evs = str2;
              }
              if (paramInt == 0) {
                locala.ijH = str2;
              }
              locala.type = paramInt;
              locala.dtM = 1095798;
              localArrayList.add(locala);
            }
          }
        }
      }
      AppMethodBeat.o(127668);
      return localArrayList;
    }
    
    public final String getKey()
    {
      return "AddrBookSyncHelper_addrBookRead";
    }
    
    public final void run()
    {
      AppMethodBeat.i(127666);
      synchronized (lock)
      {
        this.hTF = new br("MicroMsg.AddrBookSyncHelper", "sync addrBook");
        this.hTF.addSplit("sync begin");
        ad.d("MicroMsg.AddrBookSyncHelper", "reading email info");
        this.hTB = com.tencent.mm.pluginsdk.a.gT(aj.getContext());
        if (this.hTB != null) {
          ad.i("MicroMsg.AddrBookSyncHelper", "sync address book email size: " + this.hTB.size());
        }
        this.hTE = d(1, this.hTB);
        ad.d("MicroMsg.AddrBookSyncHelper", "reading mobile info");
        this.hTC = com.tencent.mm.pluginsdk.a.gS(aj.getContext());
        if (this.hTC != null) {
          ad.i("MicroMsg.AddrBookSyncHelper", "sync address book mobile size: " + this.hTC.size());
        }
        this.hTD = d(0, this.hTC);
        ad.d("MicroMsg.AddrBookSyncHelper", "reading done, begin sync to addr_upload");
        if ((this.hTB != null) && (this.hTE.size() > 0))
        {
          i = 0;
          if (i < this.hTE.size())
          {
            ad.i("MicroMsg.AddrBookSyncHelper", "sync email index: ".concat(String.valueOf(i)));
            if (i + 100 < this.hTE.size()) {}
            for (localObject1 = c(this.hTE, i, i + 100);; localObject1 = c((List)localObject1, i, ((List)localObject1).size()))
            {
              ad.i("MicroMsg.AddrBookSyncHelper", "sync email listToSync size: " + ((List)localObject1).size());
              l.aO((List)localObject1);
              i += 100;
              break;
              localObject1 = this.hTE;
            }
          }
        }
        if ((this.hTD == null) || (this.hTD.size() == 0))
        {
          ad.i("MicroMsg.AddrBookSyncHelper", "mobile list null stop service");
          localObject1 = hTG.obtainMessage();
          ((Message)localObject1).obj = Boolean.FALSE;
          hTG.sendMessage((Message)localObject1);
          AppMethodBeat.o(127666);
          return;
        }
        int i = 0;
        if (i < this.hTD.size())
        {
          ad.i("MicroMsg.AddrBookSyncHelper", "sync mobile index: ".concat(String.valueOf(i)));
          if (!com.tencent.mm.kernel.g.afw())
          {
            ad.i("MicroMsg.AddrBookSyncHelper", "account not ready, stop sync");
            localObject1 = hTG.obtainMessage();
            ((Message)localObject1).obj = Boolean.FALSE;
            hTG.sendMessage((Message)localObject1);
            AppMethodBeat.o(127666);
            return;
          }
          if (i + 100 < this.hTD.size()) {}
          for (localObject1 = c(this.hTD, i, i + 100);; localObject1 = c((List)localObject1, i, ((List)localObject1).size()))
          {
            ad.i("MicroMsg.AddrBookSyncHelper", "sync mobile listToSync size: " + ((List)localObject1).size());
            l.aO((List)localObject1);
            i += 100;
            break;
            localObject1 = this.hTD;
          }
        }
        ad.i("MicroMsg.AddrBookSyncHelper", "sync ok");
        if (!com.tencent.mm.kernel.g.afw())
        {
          ad.i("MicroMsg.AddrBookSyncHelper", "account not ready, exit");
          localObject1 = hTG.obtainMessage();
          ((Message)localObject1).obj = Boolean.FALSE;
          hTG.sendMessage((Message)localObject1);
          AppMethodBeat.o(127666);
          return;
        }
        aGo();
        System.currentTimeMillis();
        l.aIQ();
        this.hTF.addSplit("sync ok");
        this.hTF.dumpToLog();
        Object localObject1 = hTG.obtainMessage();
        ((Message)localObject1).obj = Boolean.TRUE;
        hTG.sendMessage((Message)localObject1);
        AppMethodBeat.o(127666);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.platformtools.a
 * JD-Core Version:    0.7.0.1
 */