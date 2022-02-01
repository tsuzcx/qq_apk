package com.tencent.mm.platformtools;

import android.os.Looper;
import android.os.Message;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  private static final com.tencent.mm.plugin.account.a.a.b iPA;
  public static final HashSet<com.tencent.mm.plugin.account.a.a.b> iPz;
  private static Thread thread;
  
  static
  {
    AppMethodBeat.i(127672);
    thread = null;
    iPz = new HashSet();
    iPA = new com.tencent.mm.plugin.account.a.a.b()
    {
      public final void eQ(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(127662);
        ae.i("MicroMsg.AddrBookSyncHelper", "syncAddrBookAndUpload onSyncEnd suc:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(127662);
          return;
        }
        System.currentTimeMillis();
        l.aTs();
        ao localao = new ao(l.aTw(), l.aTv());
        com.tencent.mm.kernel.g.ajj().a(localao, 0);
        AppMethodBeat.o(127662);
      }
    };
    AppMethodBeat.o(127672);
  }
  
  public static boolean aQI()
  {
    AppMethodBeat.i(127670);
    boolean bool = syncAddrBook(iPA);
    AppMethodBeat.o(127670);
    return bool;
  }
  
  public static boolean aQJ()
  {
    return a.hZF;
  }
  
  public static boolean syncAddrBook(com.tencent.mm.plugin.account.a.a.b paramb)
  {
    AppMethodBeat.i(127671);
    long l = Thread.currentThread().getId();
    boolean bool = l.aTq();
    if (!bool)
    {
      ae.e("MicroMsg.AddrBookSyncHelper", "canSync:%b, skip", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(127671);
      return false;
    }
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(127663);
        if ((a.aQK() != null) && (a.aQK().isAlive())) {}
        for (boolean bool = true;; bool = false)
        {
          ae.i("MicroMsg.AddrBookSyncHelper", "syncAddrBook running:%b setSize:%d call:%d callback:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(a.iPz.size()), Long.valueOf(this.iPB), this.iPC });
          a.iPz.add(this.iPC);
          if (!bool) {
            break;
          }
          AppMethodBeat.o(127663);
          return;
        }
        l.fs(true);
        com.tencent.e.h.MqF.aR(new a.a((byte)0));
        AppMethodBeat.o(127663);
      }
    });
    AppMethodBeat.o(127671);
    return true;
  }
  
  static final class a
    implements com.tencent.e.i.h
  {
    public static boolean hZF;
    private static final aq iPI;
    private static byte[] lock;
    private List<String[]> iPD;
    private List<String[]> iPE;
    private List<com.tencent.mm.plugin.account.friend.a.a> iPF;
    private List<com.tencent.mm.plugin.account.friend.a.a> iPG;
    private bs iPH;
    
    static
    {
      AppMethodBeat.i(127669);
      hZF = false;
      lock = new byte[0];
      iPI = new aq(Looper.getMainLooper())
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(127664);
          if (!com.tencent.mm.kernel.g.ajM())
          {
            AppMethodBeat.o(127664);
            return;
          }
          f.a locala = new f.a();
          int i = a.iPz.size();
          boolean bool = Boolean.parseBoolean(paramAnonymousMessage.obj.toString());
          paramAnonymousMessage = a.iPz.iterator();
          while (paramAnonymousMessage.hasNext()) {
            ((com.tencent.mm.plugin.account.a.a.b)paramAnonymousMessage.next()).eQ(bool);
          }
          a.iPz.clear();
          ae.i("MicroMsg.AddrBookSyncHelper", "callBackHandler setSize:%d time:%d", new Object[] { Integer.valueOf(i), Long.valueOf(locala.abs()) });
          AppMethodBeat.o(127664);
        }
      };
      AppMethodBeat.o(127669);
    }
    
    private static void aQL()
    {
      AppMethodBeat.i(127667);
      bs localbs = new bs("MicroMsg.AddrBookSyncHelper", "delete");
      ArrayList localArrayList = new ArrayList();
      List localList = com.tencent.mm.pluginsdk.b.hq(ak.getContext());
      Iterator localIterator = ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).aTf().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String[])localIterator.next();
        String str = bu.nullAsNil(localObject[0]);
        localObject = bu.nullAsNil(localObject[1]);
        if ((!str.equals("")) && (!localList.contains(str))) {
          localArrayList.add(localObject);
        }
      }
      if (localArrayList.size() > 0)
      {
        ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).aK(localArrayList);
        l.aM(localArrayList);
      }
      localbs.addSplit("end");
      localbs.dumpToLog();
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
        ae.e("MicroMsg.AddrBookSyncHelper", "sync address book failed, null info list");
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
          long l = bu.aSC(paramList[4]);
          if ((str2 != null) && (!str2.equals("")))
          {
            paramList = "";
            if (paramInt == 1) {
              paramList = com.tencent.mm.b.g.getMessageDigest(str2.getBytes());
            }
            if (paramInt == 0)
            {
              paramList = com.tencent.mm.pluginsdk.b.Ku(str2);
              if (bu.isNullOrNil(paramList)) {
                ae.d("MicroMsg.AddrBookSyncHelper", "formatted mobile null, continue");
              } else {
                paramList = com.tencent.mm.b.g.getMessageDigest(paramList.getBytes());
              }
            }
            else
            {
              com.tencent.mm.plugin.account.friend.a.a locala = new com.tencent.mm.plugin.account.friend.a.a();
              locala.realName = str1;
              locala.jfM = f.Jl(str1);
              locala.jfN = f.Jk(str1);
              locala.jfK = localObject1;
              locala.hPK = localObject2;
              locala.JS(paramList);
              locala.jgn = l;
              locala.jfT = locala.acP();
              if (paramInt == 1) {
                locala.eQY = str2;
              }
              if (paramInt == 0) {
                locala.jfQ = str2;
              }
              locala.type = paramInt;
              locala.dEu = 1095798;
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
        this.iPH = new bs("MicroMsg.AddrBookSyncHelper", "sync addrBook");
        this.iPH.addSplit("sync begin");
        ae.d("MicroMsg.AddrBookSyncHelper", "reading email info");
        this.iPD = com.tencent.mm.pluginsdk.b.hp(ak.getContext());
        if (this.iPD != null) {
          ae.i("MicroMsg.AddrBookSyncHelper", "sync address book email size: " + this.iPD.size());
        }
        this.iPG = d(1, this.iPD);
        ae.d("MicroMsg.AddrBookSyncHelper", "reading mobile info");
        this.iPE = com.tencent.mm.pluginsdk.b.ho(ak.getContext());
        if (this.iPE != null) {
          ae.i("MicroMsg.AddrBookSyncHelper", "sync address book mobile size: " + this.iPE.size());
        }
        this.iPF = d(0, this.iPE);
        ae.d("MicroMsg.AddrBookSyncHelper", "reading done, begin sync to addr_upload");
        if ((this.iPD != null) && (this.iPG.size() > 0))
        {
          i = 0;
          if (i < this.iPG.size())
          {
            ae.i("MicroMsg.AddrBookSyncHelper", "sync email index: ".concat(String.valueOf(i)));
            if (i + 100 < this.iPG.size()) {}
            for (localObject1 = c(this.iPG, i, i + 100);; localObject1 = c((List)localObject1, i, ((List)localObject1).size()))
            {
              ae.i("MicroMsg.AddrBookSyncHelper", "sync email listToSync size: " + ((List)localObject1).size());
              l.aN((List)localObject1);
              i += 100;
              break;
              localObject1 = this.iPG;
            }
          }
        }
        if ((this.iPF == null) || (this.iPF.size() == 0))
        {
          ae.i("MicroMsg.AddrBookSyncHelper", "mobile list null stop service");
          localObject1 = iPI.obtainMessage();
          ((Message)localObject1).obj = Boolean.FALSE;
          iPI.sendMessage((Message)localObject1);
          AppMethodBeat.o(127666);
          return;
        }
        int i = 0;
        if (i < this.iPF.size())
        {
          ae.i("MicroMsg.AddrBookSyncHelper", "sync mobile index: ".concat(String.valueOf(i)));
          if (!com.tencent.mm.kernel.g.ajM())
          {
            ae.i("MicroMsg.AddrBookSyncHelper", "account not ready, stop sync");
            localObject1 = iPI.obtainMessage();
            ((Message)localObject1).obj = Boolean.FALSE;
            iPI.sendMessage((Message)localObject1);
            AppMethodBeat.o(127666);
            return;
          }
          if (i + 100 < this.iPF.size()) {}
          for (localObject1 = c(this.iPF, i, i + 100);; localObject1 = c((List)localObject1, i, ((List)localObject1).size()))
          {
            ae.i("MicroMsg.AddrBookSyncHelper", "sync mobile listToSync size: " + ((List)localObject1).size());
            l.aN((List)localObject1);
            i += 100;
            break;
            localObject1 = this.iPF;
          }
        }
        ae.i("MicroMsg.AddrBookSyncHelper", "sync ok");
        if (!com.tencent.mm.kernel.g.ajM())
        {
          ae.i("MicroMsg.AddrBookSyncHelper", "account not ready, exit");
          localObject1 = iPI.obtainMessage();
          ((Message)localObject1).obj = Boolean.FALSE;
          iPI.sendMessage((Message)localObject1);
          AppMethodBeat.o(127666);
          return;
        }
        aQL();
        System.currentTimeMillis();
        l.aTs();
        this.iPH.addSplit("sync ok");
        this.iPH.dumpToLog();
        Object localObject1 = iPI.obtainMessage();
        ((Message)localObject1).obj = Boolean.TRUE;
        iPI.sendMessage((Message)localObject1);
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