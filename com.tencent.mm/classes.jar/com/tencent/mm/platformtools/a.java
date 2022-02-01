package com.tencent.mm.platformtools;

import android.os.Looper;
import android.os.Message;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.TimeLogger;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public static final HashSet<com.tencent.mm.plugin.account.a.a.b> jMm;
  private static final com.tencent.mm.plugin.account.a.a.b jMn;
  private static Thread thread;
  
  static
  {
    AppMethodBeat.i(127672);
    thread = null;
    jMm = new HashSet();
    jMn = new com.tencent.mm.plugin.account.a.a.b()
    {
      public final void fG(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(127662);
        Log.i("MicroMsg.AddrBookSyncHelper", "syncAddrBookAndUpload onSyncEnd suc:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(127662);
          return;
        }
        System.currentTimeMillis();
        l.boe();
        ao localao = new ao(l.boi(), l.boh());
        com.tencent.mm.kernel.g.azz().a(localao, 0);
        AppMethodBeat.o(127662);
      }
    };
    AppMethodBeat.o(127672);
  }
  
  public static boolean blm()
  {
    AppMethodBeat.i(127670);
    boolean bool = syncAddrBook(jMn);
    AppMethodBeat.o(127670);
    return bool;
  }
  
  public static boolean bln()
  {
    return a.iUD;
  }
  
  public static boolean syncAddrBook(com.tencent.mm.plugin.account.a.a.b paramb)
  {
    AppMethodBeat.i(127671);
    long l = Thread.currentThread().getId();
    boolean bool = l.boc();
    if (!bool)
    {
      Log.e("MicroMsg.AddrBookSyncHelper", "canSync:%b, skip", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(127671);
      return false;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(127663);
        if ((a.blo() != null) && (a.blo().isAlive())) {}
        for (boolean bool = true;; bool = false)
        {
          Log.i("MicroMsg.AddrBookSyncHelper", "syncAddrBook running:%b setSize:%d call:%d callback:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(a.jMm.size()), Long.valueOf(this.jMo), this.jMp });
          a.jMm.add(this.jMp);
          if (!bool) {
            break;
          }
          AppMethodBeat.o(127663);
          return;
        }
        l.gl(true);
        com.tencent.f.h.RTc.ba(new a.a((byte)0));
        AppMethodBeat.o(127663);
      }
    });
    AppMethodBeat.o(127671);
    return true;
  }
  
  static final class a
    implements com.tencent.f.i.h
  {
    public static boolean iUD;
    private static final MMHandler jMv;
    private static byte[] lock;
    private List<String[]> jMq;
    private List<String[]> jMr;
    private List<com.tencent.mm.plugin.account.friend.a.a> jMs;
    private List<com.tencent.mm.plugin.account.friend.a.a> jMt;
    private TimeLogger jMu;
    
    static
    {
      AppMethodBeat.i(127669);
      iUD = false;
      lock = new byte[0];
      jMv = new MMHandler(Looper.getMainLooper())
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(127664);
          if (!com.tencent.mm.kernel.g.aAc())
          {
            AppMethodBeat.o(127664);
            return;
          }
          f.a locala = new f.a();
          int i = a.jMm.size();
          boolean bool = Boolean.parseBoolean(paramAnonymousMessage.obj.toString());
          paramAnonymousMessage = a.jMm.iterator();
          while (paramAnonymousMessage.hasNext()) {
            ((com.tencent.mm.plugin.account.a.a.b)paramAnonymousMessage.next()).fG(bool);
          }
          a.jMm.clear();
          Log.i("MicroMsg.AddrBookSyncHelper", "callBackHandler setSize:%d time:%d", new Object[] { Integer.valueOf(i), Long.valueOf(locala.apr()) });
          AppMethodBeat.o(127664);
        }
      };
      AppMethodBeat.o(127669);
    }
    
    private static void blp()
    {
      AppMethodBeat.i(127667);
      TimeLogger localTimeLogger = new TimeLogger("MicroMsg.AddrBookSyncHelper", "delete");
      ArrayList localArrayList = new ArrayList();
      List localList = com.tencent.mm.pluginsdk.b.ik(MMApplicationContext.getContext());
      Iterator localIterator = ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).bnS().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String[])localIterator.next();
        String str = Util.nullAsNil(localObject[0]);
        localObject = Util.nullAsNil(localObject[1]);
        if ((!str.equals("")) && (!localList.contains(str))) {
          localArrayList.add(localObject);
        }
      }
      if (localArrayList.size() > 0)
      {
        ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).aT(localArrayList);
        l.aV(localArrayList);
      }
      localTimeLogger.addSplit("end");
      localTimeLogger.dumpToLog();
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
        Log.e("MicroMsg.AddrBookSyncHelper", "sync address book failed, null info list");
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
          long l = Util.safeParseLong(paramList[4]);
          if ((str2 != null) && (!str2.equals("")))
          {
            paramList = "";
            if (paramInt == 1) {
              paramList = com.tencent.mm.b.g.getMessageDigest(str2.getBytes());
            }
            if (paramInt == 0)
            {
              paramList = com.tencent.mm.pluginsdk.b.Ts(str2);
              if (Util.isNullOrNil(paramList)) {
                Log.d("MicroMsg.AddrBookSyncHelper", "formatted mobile null, continue");
              } else {
                paramList = com.tencent.mm.b.g.getMessageDigest(paramList.getBytes());
              }
            }
            else
            {
              com.tencent.mm.plugin.account.friend.a.a locala = new com.tencent.mm.plugin.account.friend.a.a();
              locala.realName = str1;
              locala.kdP = f.Si(str1);
              locala.kdQ = f.Sh(str1);
              locala.kdN = localObject1;
              locala.iKR = localObject2;
              locala.setMd5(paramList);
              locala.keq = l;
              locala.kdW = locala.aqN();
              if (paramInt == 1) {
                locala.fuD = str2;
              }
              if (paramInt == 0) {
                locala.kdT = str2;
              }
              locala.type = paramInt;
              locala.cSx = 1095798;
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
        this.jMu = new TimeLogger("MicroMsg.AddrBookSyncHelper", "sync addrBook");
        this.jMu.addSplit("sync begin");
        Log.d("MicroMsg.AddrBookSyncHelper", "reading email info");
        this.jMq = com.tencent.mm.pluginsdk.b.ij(MMApplicationContext.getContext());
        if (this.jMq != null) {
          Log.i("MicroMsg.AddrBookSyncHelper", "sync address book email size: " + this.jMq.size());
        }
        this.jMt = d(1, this.jMq);
        Log.d("MicroMsg.AddrBookSyncHelper", "reading mobile info");
        this.jMr = com.tencent.mm.pluginsdk.b.ii(MMApplicationContext.getContext());
        if (this.jMr != null) {
          Log.i("MicroMsg.AddrBookSyncHelper", "sync address book mobile size: " + this.jMr.size());
        }
        this.jMs = d(0, this.jMr);
        Log.d("MicroMsg.AddrBookSyncHelper", "reading done, begin sync to addr_upload");
        if ((this.jMq != null) && (this.jMt.size() > 0))
        {
          i = 0;
          if (i < this.jMt.size())
          {
            Log.i("MicroMsg.AddrBookSyncHelper", "sync email index: ".concat(String.valueOf(i)));
            if (i + 100 < this.jMt.size()) {}
            for (localObject1 = c(this.jMt, i, i + 100);; localObject1 = c((List)localObject1, i, ((List)localObject1).size()))
            {
              Log.i("MicroMsg.AddrBookSyncHelper", "sync email listToSync size: " + ((List)localObject1).size());
              l.aW((List)localObject1);
              i += 100;
              break;
              localObject1 = this.jMt;
            }
          }
        }
        if ((this.jMs == null) || (this.jMs.size() == 0))
        {
          Log.i("MicroMsg.AddrBookSyncHelper", "mobile list null stop service");
          localObject1 = jMv.obtainMessage();
          ((Message)localObject1).obj = Boolean.FALSE;
          jMv.sendMessage((Message)localObject1);
          AppMethodBeat.o(127666);
          return;
        }
        int i = 0;
        if (i < this.jMs.size())
        {
          Log.i("MicroMsg.AddrBookSyncHelper", "sync mobile index: ".concat(String.valueOf(i)));
          if (!com.tencent.mm.kernel.g.aAc())
          {
            Log.i("MicroMsg.AddrBookSyncHelper", "account not ready, stop sync");
            localObject1 = jMv.obtainMessage();
            ((Message)localObject1).obj = Boolean.FALSE;
            jMv.sendMessage((Message)localObject1);
            AppMethodBeat.o(127666);
            return;
          }
          if (i + 100 < this.jMs.size()) {}
          for (localObject1 = c(this.jMs, i, i + 100);; localObject1 = c((List)localObject1, i, ((List)localObject1).size()))
          {
            Log.i("MicroMsg.AddrBookSyncHelper", "sync mobile listToSync size: " + ((List)localObject1).size());
            l.aW((List)localObject1);
            i += 100;
            break;
            localObject1 = this.jMs;
          }
        }
        Log.i("MicroMsg.AddrBookSyncHelper", "sync ok");
        if (!com.tencent.mm.kernel.g.aAc())
        {
          Log.i("MicroMsg.AddrBookSyncHelper", "account not ready, exit");
          localObject1 = jMv.obtainMessage();
          ((Message)localObject1).obj = Boolean.FALSE;
          jMv.sendMessage((Message)localObject1);
          AppMethodBeat.o(127666);
          return;
        }
        blp();
        System.currentTimeMillis();
        l.boe();
        this.jMu.addSplit("sync ok");
        this.jMu.dumpToLog();
        Object localObject1 = jMv.obtainMessage();
        ((Message)localObject1).obj = Boolean.TRUE;
        jMv.sendMessage((Message)localObject1);
        AppMethodBeat.o(127666);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.platformtools.a
 * JD-Core Version:    0.7.0.1
 */