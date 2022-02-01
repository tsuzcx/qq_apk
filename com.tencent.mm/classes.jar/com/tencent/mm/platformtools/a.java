package com.tencent.mm.platformtools;

import android.os.Looper;
import android.os.Message;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bq;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public static final HashSet<com.tencent.mm.plugin.account.a.a.b> itC;
  private static final com.tencent.mm.plugin.account.a.a.b itD;
  private static Thread thread;
  
  static
  {
    AppMethodBeat.i(127672);
    thread = null;
    itC = new HashSet();
    itD = new com.tencent.mm.plugin.account.a.a.b()
    {
      public final void eM(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(127662);
        ac.i("MicroMsg.AddrBookSyncHelper", "syncAddrBookAndUpload onSyncEnd suc:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(127662);
          return;
        }
        System.currentTimeMillis();
        l.aPH();
        com.tencent.mm.plugin.account.friend.a.ao localao = new com.tencent.mm.plugin.account.friend.a.ao(l.aPL(), l.aPK());
        com.tencent.mm.kernel.g.agi().a(localao, 0);
        AppMethodBeat.o(127662);
      }
    };
    AppMethodBeat.o(127672);
  }
  
  public static boolean aMY()
  {
    AppMethodBeat.i(127670);
    boolean bool = syncAddrBook(itD);
    AppMethodBeat.o(127670);
    return bool;
  }
  
  public static boolean aMZ()
  {
    return a.hEi;
  }
  
  public static boolean syncAddrBook(com.tencent.mm.plugin.account.a.a.b paramb)
  {
    AppMethodBeat.i(127671);
    long l = Thread.currentThread().getId();
    boolean bool = l.aPF();
    if (!bool)
    {
      ac.e("MicroMsg.AddrBookSyncHelper", "canSync:%b, skip", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(127671);
      return false;
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(127663);
        if ((a.aNa() != null) && (a.aNa().isAlive())) {}
        for (boolean bool = true;; bool = false)
        {
          ac.i("MicroMsg.AddrBookSyncHelper", "syncAddrBook running:%b setSize:%d call:%d callback:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(a.itC.size()), Long.valueOf(this.itE), this.itF });
          a.itC.add(this.itF);
          if (!bool) {
            break;
          }
          AppMethodBeat.o(127663);
          return;
        }
        l.fn(true);
        com.tencent.e.h.JZN.aV(new a.a((byte)0));
        AppMethodBeat.o(127663);
      }
    });
    AppMethodBeat.o(127671);
    return true;
  }
  
  static final class a
    implements com.tencent.e.i.h
  {
    public static boolean hEi;
    private static final com.tencent.mm.sdk.platformtools.ao itL;
    private static byte[] lock;
    private List<String[]> itG;
    private List<String[]> itH;
    private List<com.tencent.mm.plugin.account.friend.a.a> itI;
    private List<com.tencent.mm.plugin.account.friend.a.a> itJ;
    private bq itK;
    
    static
    {
      AppMethodBeat.i(127669);
      hEi = false;
      lock = new byte[0];
      itL = new com.tencent.mm.sdk.platformtools.ao(Looper.getMainLooper())
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(127664);
          if (!com.tencent.mm.kernel.g.agM())
          {
            AppMethodBeat.o(127664);
            return;
          }
          f.a locala = new f.a();
          int i = a.itC.size();
          boolean bool = Boolean.parseBoolean(paramAnonymousMessage.obj.toString());
          paramAnonymousMessage = a.itC.iterator();
          while (paramAnonymousMessage.hasNext()) {
            ((com.tencent.mm.plugin.account.a.a.b)paramAnonymousMessage.next()).eM(bool);
          }
          a.itC.clear();
          ac.i("MicroMsg.AddrBookSyncHelper", "callBackHandler setSize:%d time:%d", new Object[] { Integer.valueOf(i), Long.valueOf(locala.YH()) });
          AppMethodBeat.o(127664);
        }
      };
      AppMethodBeat.o(127669);
    }
    
    private static void aNb()
    {
      AppMethodBeat.i(127667);
      bq localbq = new bq("MicroMsg.AddrBookSyncHelper", "delete");
      ArrayList localArrayList = new ArrayList();
      List localList = com.tencent.mm.pluginsdk.a.hf(ai.getContext());
      Iterator localIterator = ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).aPu().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String[])localIterator.next();
        String str = bs.nullAsNil(localObject[0]);
        localObject = bs.nullAsNil(localObject[1]);
        if ((!str.equals("")) && (!localList.contains(str))) {
          localArrayList.add(localObject);
        }
      }
      if (localArrayList.size() > 0)
      {
        ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).aJ(localArrayList);
        l.aL(localArrayList);
      }
      localbq.addSplit("end");
      localbq.dumpToLog();
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
        ac.e("MicroMsg.AddrBookSyncHelper", "sync address book failed, null info list");
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
          long l = bs.aLz(paramList[4]);
          if ((str2 != null) && (!str2.equals("")))
          {
            paramList = "";
            if (paramInt == 1) {
              paramList = com.tencent.mm.b.g.getMessageDigest(str2.getBytes());
            }
            if (paramInt == 0)
            {
              paramList = com.tencent.mm.pluginsdk.a.GG(str2);
              if (bs.isNullOrNil(paramList)) {
                ac.d("MicroMsg.AddrBookSyncHelper", "formatted mobile null, continue");
              } else {
                paramList = com.tencent.mm.b.g.getMessageDigest(paramList.getBytes());
              }
            }
            else
            {
              com.tencent.mm.plugin.account.friend.a.a locala = new com.tencent.mm.plugin.account.friend.a.a();
              locala.realName = str1;
              locala.iJK = f.Fw(str1);
              locala.iJL = f.Fv(str1);
              locala.iJI = localObject1;
              locala.huz = localObject2;
              locala.Ge(paramList);
              locala.iKl = l;
              locala.iJR = locala.aac();
              if (paramInt == 1) {
                locala.exO = str2;
              }
              if (paramInt == 0) {
                locala.iJO = str2;
              }
              locala.type = paramInt;
              locala.drx = 1095798;
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
        this.itK = new bq("MicroMsg.AddrBookSyncHelper", "sync addrBook");
        this.itK.addSplit("sync begin");
        ac.d("MicroMsg.AddrBookSyncHelper", "reading email info");
        this.itG = com.tencent.mm.pluginsdk.a.he(ai.getContext());
        if (this.itG != null) {
          ac.i("MicroMsg.AddrBookSyncHelper", "sync address book email size: " + this.itG.size());
        }
        this.itJ = d(1, this.itG);
        ac.d("MicroMsg.AddrBookSyncHelper", "reading mobile info");
        this.itH = com.tencent.mm.pluginsdk.a.hd(ai.getContext());
        if (this.itH != null) {
          ac.i("MicroMsg.AddrBookSyncHelper", "sync address book mobile size: " + this.itH.size());
        }
        this.itI = d(0, this.itH);
        ac.d("MicroMsg.AddrBookSyncHelper", "reading done, begin sync to addr_upload");
        if ((this.itG != null) && (this.itJ.size() > 0))
        {
          i = 0;
          if (i < this.itJ.size())
          {
            ac.i("MicroMsg.AddrBookSyncHelper", "sync email index: ".concat(String.valueOf(i)));
            if (i + 100 < this.itJ.size()) {}
            for (localObject1 = c(this.itJ, i, i + 100);; localObject1 = c((List)localObject1, i, ((List)localObject1).size()))
            {
              ac.i("MicroMsg.AddrBookSyncHelper", "sync email listToSync size: " + ((List)localObject1).size());
              l.aM((List)localObject1);
              i += 100;
              break;
              localObject1 = this.itJ;
            }
          }
        }
        if ((this.itI == null) || (this.itI.size() == 0))
        {
          ac.i("MicroMsg.AddrBookSyncHelper", "mobile list null stop service");
          localObject1 = itL.obtainMessage();
          ((Message)localObject1).obj = Boolean.FALSE;
          itL.sendMessage((Message)localObject1);
          AppMethodBeat.o(127666);
          return;
        }
        int i = 0;
        if (i < this.itI.size())
        {
          ac.i("MicroMsg.AddrBookSyncHelper", "sync mobile index: ".concat(String.valueOf(i)));
          if (!com.tencent.mm.kernel.g.agM())
          {
            ac.i("MicroMsg.AddrBookSyncHelper", "account not ready, stop sync");
            localObject1 = itL.obtainMessage();
            ((Message)localObject1).obj = Boolean.FALSE;
            itL.sendMessage((Message)localObject1);
            AppMethodBeat.o(127666);
            return;
          }
          if (i + 100 < this.itI.size()) {}
          for (localObject1 = c(this.itI, i, i + 100);; localObject1 = c((List)localObject1, i, ((List)localObject1).size()))
          {
            ac.i("MicroMsg.AddrBookSyncHelper", "sync mobile listToSync size: " + ((List)localObject1).size());
            l.aM((List)localObject1);
            i += 100;
            break;
            localObject1 = this.itI;
          }
        }
        ac.i("MicroMsg.AddrBookSyncHelper", "sync ok");
        if (!com.tencent.mm.kernel.g.agM())
        {
          ac.i("MicroMsg.AddrBookSyncHelper", "account not ready, exit");
          localObject1 = itL.obtainMessage();
          ((Message)localObject1).obj = Boolean.FALSE;
          itL.sendMessage((Message)localObject1);
          AppMethodBeat.o(127666);
          return;
        }
        aNb();
        System.currentTimeMillis();
        l.aPH();
        this.itK.addSplit("sync ok");
        this.itK.dumpToLog();
        Object localObject1 = itL.obtainMessage();
        ((Message)localObject1).obj = Boolean.TRUE;
        itL.sendMessage((Message)localObject1);
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