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
  public static final HashSet<com.tencent.mm.plugin.account.a.a.b> iMF;
  private static final com.tencent.mm.plugin.account.a.a.b iMG;
  private static Thread thread;
  
  static
  {
    AppMethodBeat.i(127672);
    thread = null;
    iMF = new HashSet();
    iMG = new com.tencent.mm.plugin.account.a.a.b()
    {
      public final void eO(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(127662);
        ad.i("MicroMsg.AddrBookSyncHelper", "syncAddrBookAndUpload onSyncEnd suc:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(127662);
          return;
        }
        System.currentTimeMillis();
        l.aST();
        ao localao = new ao(l.aSX(), l.aSW());
        com.tencent.mm.kernel.g.aiU().a(localao, 0);
        AppMethodBeat.o(127662);
      }
    };
    AppMethodBeat.o(127672);
  }
  
  public static boolean aQj()
  {
    AppMethodBeat.i(127670);
    boolean bool = syncAddrBook(iMG);
    AppMethodBeat.o(127670);
    return bool;
  }
  
  public static boolean aQk()
  {
    return a.hWN;
  }
  
  public static boolean syncAddrBook(com.tencent.mm.plugin.account.a.a.b paramb)
  {
    AppMethodBeat.i(127671);
    long l = Thread.currentThread().getId();
    boolean bool = l.aSR();
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
        if ((a.aQl() != null) && (a.aQl().isAlive())) {}
        for (boolean bool = true;; bool = false)
        {
          ad.i("MicroMsg.AddrBookSyncHelper", "syncAddrBook running:%b setSize:%d call:%d callback:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(a.iMF.size()), Long.valueOf(this.iMH), this.iMI });
          a.iMF.add(this.iMI);
          if (!bool) {
            break;
          }
          AppMethodBeat.o(127663);
          return;
        }
        l.fr(true);
        com.tencent.e.h.LTJ.aU(new a.a((byte)0));
        AppMethodBeat.o(127663);
      }
    });
    AppMethodBeat.o(127671);
    return true;
  }
  
  static final class a
    implements com.tencent.e.i.h
  {
    public static boolean hWN;
    private static final ap iMO;
    private static byte[] lock;
    private List<String[]> iMJ;
    private List<String[]> iMK;
    private List<com.tencent.mm.plugin.account.friend.a.a> iML;
    private List<com.tencent.mm.plugin.account.friend.a.a> iMM;
    private br iMN;
    
    static
    {
      AppMethodBeat.i(127669);
      hWN = false;
      lock = new byte[0];
      iMO = new ap(Looper.getMainLooper())
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(127664);
          if (!com.tencent.mm.kernel.g.ajx())
          {
            AppMethodBeat.o(127664);
            return;
          }
          f.a locala = new f.a();
          int i = a.iMF.size();
          boolean bool = Boolean.parseBoolean(paramAnonymousMessage.obj.toString());
          paramAnonymousMessage = a.iMF.iterator();
          while (paramAnonymousMessage.hasNext()) {
            ((com.tencent.mm.plugin.account.a.a.b)paramAnonymousMessage.next()).eO(bool);
          }
          a.iMF.clear();
          ad.i("MicroMsg.AddrBookSyncHelper", "callBackHandler setSize:%d time:%d", new Object[] { Integer.valueOf(i), Long.valueOf(locala.abj()) });
          AppMethodBeat.o(127664);
        }
      };
      AppMethodBeat.o(127669);
    }
    
    private static void aQm()
    {
      AppMethodBeat.i(127667);
      br localbr = new br("MicroMsg.AddrBookSyncHelper", "delete");
      ArrayList localArrayList = new ArrayList();
      List localList = com.tencent.mm.pluginsdk.b.hk(aj.getContext());
      Iterator localIterator = ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).aSG().iterator();
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
        ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).aK(localArrayList);
        l.aM(localArrayList);
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
          long l = bt.aRf(paramList[4]);
          if ((str2 != null) && (!str2.equals("")))
          {
            paramList = "";
            if (paramInt == 1) {
              paramList = com.tencent.mm.b.g.getMessageDigest(str2.getBytes());
            }
            if (paramInt == 0)
            {
              paramList = com.tencent.mm.pluginsdk.b.JV(str2);
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
              locala.jcT = f.IM(str1);
              locala.jcU = f.IL(str1);
              locala.jcR = localObject1;
              locala.hMR = localObject2;
              locala.Jt(paramList);
              locala.jdu = l;
              locala.jda = locala.acE();
              if (paramInt == 1) {
                locala.ePn = str2;
              }
              if (paramInt == 0) {
                locala.jcX = str2;
              }
              locala.type = paramInt;
              locala.dDp = 1095798;
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
        this.iMN = new br("MicroMsg.AddrBookSyncHelper", "sync addrBook");
        this.iMN.addSplit("sync begin");
        ad.d("MicroMsg.AddrBookSyncHelper", "reading email info");
        this.iMJ = com.tencent.mm.pluginsdk.b.hj(aj.getContext());
        if (this.iMJ != null) {
          ad.i("MicroMsg.AddrBookSyncHelper", "sync address book email size: " + this.iMJ.size());
        }
        this.iMM = d(1, this.iMJ);
        ad.d("MicroMsg.AddrBookSyncHelper", "reading mobile info");
        this.iMK = com.tencent.mm.pluginsdk.b.hi(aj.getContext());
        if (this.iMK != null) {
          ad.i("MicroMsg.AddrBookSyncHelper", "sync address book mobile size: " + this.iMK.size());
        }
        this.iML = d(0, this.iMK);
        ad.d("MicroMsg.AddrBookSyncHelper", "reading done, begin sync to addr_upload");
        if ((this.iMJ != null) && (this.iMM.size() > 0))
        {
          i = 0;
          if (i < this.iMM.size())
          {
            ad.i("MicroMsg.AddrBookSyncHelper", "sync email index: ".concat(String.valueOf(i)));
            if (i + 100 < this.iMM.size()) {}
            for (localObject1 = c(this.iMM, i, i + 100);; localObject1 = c((List)localObject1, i, ((List)localObject1).size()))
            {
              ad.i("MicroMsg.AddrBookSyncHelper", "sync email listToSync size: " + ((List)localObject1).size());
              l.aN((List)localObject1);
              i += 100;
              break;
              localObject1 = this.iMM;
            }
          }
        }
        if ((this.iML == null) || (this.iML.size() == 0))
        {
          ad.i("MicroMsg.AddrBookSyncHelper", "mobile list null stop service");
          localObject1 = iMO.obtainMessage();
          ((Message)localObject1).obj = Boolean.FALSE;
          iMO.sendMessage((Message)localObject1);
          AppMethodBeat.o(127666);
          return;
        }
        int i = 0;
        if (i < this.iML.size())
        {
          ad.i("MicroMsg.AddrBookSyncHelper", "sync mobile index: ".concat(String.valueOf(i)));
          if (!com.tencent.mm.kernel.g.ajx())
          {
            ad.i("MicroMsg.AddrBookSyncHelper", "account not ready, stop sync");
            localObject1 = iMO.obtainMessage();
            ((Message)localObject1).obj = Boolean.FALSE;
            iMO.sendMessage((Message)localObject1);
            AppMethodBeat.o(127666);
            return;
          }
          if (i + 100 < this.iML.size()) {}
          for (localObject1 = c(this.iML, i, i + 100);; localObject1 = c((List)localObject1, i, ((List)localObject1).size()))
          {
            ad.i("MicroMsg.AddrBookSyncHelper", "sync mobile listToSync size: " + ((List)localObject1).size());
            l.aN((List)localObject1);
            i += 100;
            break;
            localObject1 = this.iML;
          }
        }
        ad.i("MicroMsg.AddrBookSyncHelper", "sync ok");
        if (!com.tencent.mm.kernel.g.ajx())
        {
          ad.i("MicroMsg.AddrBookSyncHelper", "account not ready, exit");
          localObject1 = iMO.obtainMessage();
          ((Message)localObject1).obj = Boolean.FALSE;
          iMO.sendMessage((Message)localObject1);
          AppMethodBeat.o(127666);
          return;
        }
        aQm();
        System.currentTimeMillis();
        l.aST();
        this.iMN.addSplit("sync ok");
        this.iMN.dumpToLog();
        Object localObject1 = iMO.obtainMessage();
        ((Message)localObject1).obj = Boolean.TRUE;
        iMO.sendMessage((Message)localObject1);
        AppMethodBeat.o(127666);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.platformtools.a
 * JD-Core Version:    0.7.0.1
 */