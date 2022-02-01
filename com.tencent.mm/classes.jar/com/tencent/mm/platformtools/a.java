package com.tencent.mm.platformtools;

import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.plugin.account.friend.model.al;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.TimeLogger;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public static final HashSet<com.tencent.mm.plugin.account.sdk.a.b> pAa;
  private static final com.tencent.mm.plugin.account.sdk.a.b pAb;
  private static Thread thread;
  
  static
  {
    AppMethodBeat.i(127672);
    thread = null;
    pAa = new HashSet();
    pAb = new com.tencent.mm.plugin.account.sdk.a.b()
    {
      public final void hi(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(127662);
        Log.i("MicroMsg.AddrBookSyncHelper", "syncAddrBookAndUpload onSyncEnd suc:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(127662);
          return;
        }
        System.currentTimeMillis();
        com.tencent.mm.plugin.account.friend.model.i.bXa();
        al localal = new al(com.tencent.mm.plugin.account.friend.model.i.bXe(), com.tencent.mm.plugin.account.friend.model.i.bXd());
        com.tencent.mm.kernel.h.aZW().a(localal, 0);
        AppMethodBeat.o(127662);
      }
    };
    AppMethodBeat.o(127672);
  }
  
  public static boolean bTl()
  {
    AppMethodBeat.i(127670);
    boolean bool = syncAddrBook(pAb);
    AppMethodBeat.o(127670);
    return bool;
  }
  
  public static void bTm()
  {
    AppMethodBeat.i(234065);
    MultiProcessMMKV.getDefault().putInt("ADDRBOOK_HAD_UPDATE_KEY", 2).apply();
    AppMethodBeat.o(234065);
  }
  
  public static void bTn()
  {
    AppMethodBeat.i(234070);
    MultiProcessMMKV.getDefault().putInt("ADDRBOOK_HAD_UPDATE_KEY", 1).apply();
    AppMethodBeat.o(234070);
  }
  
  public static boolean bTo()
  {
    AppMethodBeat.i(234074);
    if (MultiProcessMMKV.getDefault().getInt("ADDRBOOK_HAD_UPDATE_KEY", 0) != 1)
    {
      AppMethodBeat.o(234074);
      return true;
    }
    AppMethodBeat.o(234074);
    return false;
  }
  
  public static boolean bTp()
  {
    return a.mpH;
  }
  
  public static boolean syncAddrBook(com.tencent.mm.plugin.account.sdk.a.b paramb)
  {
    AppMethodBeat.i(127671);
    long l = Thread.currentThread().getId();
    boolean bool = com.tencent.mm.plugin.account.friend.model.i.bWY();
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
        if ((a.bTq() != null) && (a.bTq().isAlive())) {}
        for (boolean bool = true;; bool = false)
        {
          Log.i("MicroMsg.AddrBookSyncHelper", "syncAddrBook running:%b setSize:%d call:%d callback:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(a.pAa.size()), Long.valueOf(this.pAc), this.pAd });
          a.pAa.add(this.pAd);
          if (!bool) {
            break;
          }
          AppMethodBeat.o(127663);
          return;
        }
        com.tencent.mm.plugin.account.friend.model.i.hN(true);
        com.tencent.threadpool.h.ahAA.bp(new a.a((byte)0));
        AppMethodBeat.o(127663);
      }
    });
    AppMethodBeat.o(127671);
    return true;
  }
  
  static final class a
    implements com.tencent.threadpool.i.h
  {
    private static byte[] lock;
    public static boolean mpH;
    private static final MMHandler pAj;
    private List<String[]> pAe;
    private List<String[]> pAf;
    private List<com.tencent.mm.plugin.account.friend.model.a> pAg;
    private List<com.tencent.mm.plugin.account.friend.model.a> pAh;
    private TimeLogger pAi;
    
    static
    {
      AppMethodBeat.i(127669);
      mpH = false;
      lock = new byte[0];
      pAj = new MMHandler(Looper.getMainLooper())
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(127664);
          if (!com.tencent.mm.kernel.h.baz())
          {
            AppMethodBeat.o(127664);
            return;
          }
          f.a locala = new f.a();
          int i = a.pAa.size();
          boolean bool = Boolean.parseBoolean(paramAnonymousMessage.obj.toString());
          paramAnonymousMessage = a.pAa.iterator();
          while (paramAnonymousMessage.hasNext()) {
            ((com.tencent.mm.plugin.account.sdk.a.b)paramAnonymousMessage.next()).hi(bool);
          }
          a.pAa.clear();
          Log.i("MicroMsg.AddrBookSyncHelper", "callBackHandler setSize:%d time:%d", new Object[] { Integer.valueOf(i), Long.valueOf(locala.aPY()) });
          AppMethodBeat.o(127664);
        }
      };
      AppMethodBeat.o(127669);
    }
    
    private List<String> bTr()
    {
      AppMethodBeat.i(234007);
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = this.pAf.iterator();
      while (localIterator.hasNext()) {
        localLinkedList.add(((String[])localIterator.next())[2]);
      }
      AppMethodBeat.o(234007);
      return localLinkedList;
    }
    
    private void bTs()
    {
      AppMethodBeat.i(127667);
      TimeLogger localTimeLogger = new TimeLogger("MicroMsg.AddrBookSyncHelper", "delete");
      ArrayList localArrayList = new ArrayList();
      List localList = bTr();
      Iterator localIterator = ((com.tencent.mm.plugin.account.friend.model.b)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getAddrUploadStg()).bWQ().iterator();
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
        ((com.tencent.mm.plugin.account.friend.model.b)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getAddrUploadStg()).cw(localArrayList);
        com.tencent.mm.plugin.account.friend.model.i.cy(localArrayList);
      }
      localTimeLogger.addSplit("end");
      localTimeLogger.dumpToLog();
      AppMethodBeat.o(127667);
    }
    
    private static List<com.tencent.mm.plugin.account.friend.model.a> j(List<com.tencent.mm.plugin.account.friend.model.a> paramList, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(127665);
      LinkedList localLinkedList = new LinkedList();
      while (paramInt1 < paramInt2)
      {
        localLinkedList.add((com.tencent.mm.plugin.account.friend.model.a)paramList.get(paramInt1));
        paramInt1 += 1;
      }
      AppMethodBeat.o(127665);
      return localLinkedList;
    }
    
    private static List<com.tencent.mm.plugin.account.friend.model.a> s(int paramInt, List<String[]> paramList)
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
              paramList = g.getMessageDigest(str2.getBytes());
            }
            if (paramInt == 0)
            {
              paramList = com.tencent.mm.pluginsdk.b.Tu(str2);
              if (Util.isNullOrNil(paramList)) {
                Log.d("MicroMsg.AddrBookSyncHelper", "formatted mobile null, continue");
              } else {
                paramList = g.getMessageDigest(paramList.getBytes());
              }
            }
            else
            {
              com.tencent.mm.plugin.account.friend.model.a locala = new com.tencent.mm.plugin.account.friend.model.a();
              locala.realName = str1;
              locala.pRW = f.Sa(str1);
              locala.pRX = f.RZ(str1);
              locala.pRU = localObject1;
              locala.osA = localObject2;
              locala.setMd5(paramList);
              locala.pSx = l;
              locala.pSd = locala.aRH();
              if (paramInt == 1) {
                locala.kab = str2;
              }
              if (paramInt == 0) {
                locala.pSa = str2;
              }
              locala.type = paramInt;
              locala.eQp = 1095798;
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
        a.bTn();
        this.pAi = new TimeLogger("MicroMsg.AddrBookSyncHelper", "sync addrBook");
        this.pAi.addSplit("sync begin");
        Log.d("MicroMsg.AddrBookSyncHelper", "reading email info");
        MMApplicationContext.getContext();
        this.pAe = new LinkedList();
        if (this.pAe != null) {
          Log.i("MicroMsg.AddrBookSyncHelper", "sync address book email size: " + this.pAe.size());
        }
        this.pAh = s(1, this.pAe);
        Log.d("MicroMsg.AddrBookSyncHelper", "reading mobile info");
        this.pAf = com.tencent.mm.pluginsdk.b.lj(MMApplicationContext.getContext());
        if (this.pAf != null) {
          Log.i("MicroMsg.AddrBookSyncHelper", "sync address book mobile size: " + this.pAf.size());
        }
        this.pAg = s(0, this.pAf);
        Log.d("MicroMsg.AddrBookSyncHelper", "reading done, begin sync to addr_upload");
        if ((this.pAe != null) && (this.pAh.size() > 0))
        {
          i = 0;
          if (i < this.pAh.size())
          {
            Log.i("MicroMsg.AddrBookSyncHelper", "sync email index: ".concat(String.valueOf(i)));
            if (i + 100 < this.pAh.size()) {}
            for (localObject1 = j(this.pAh, i, i + 100);; localObject1 = j((List)localObject1, i, ((List)localObject1).size()))
            {
              Log.i("MicroMsg.AddrBookSyncHelper", "sync email listToSync size: " + ((List)localObject1).size());
              com.tencent.mm.plugin.account.friend.model.i.cz((List)localObject1);
              i += 100;
              break;
              localObject1 = this.pAh;
            }
          }
        }
        if ((this.pAg == null) || (this.pAg.size() == 0))
        {
          Log.i("MicroMsg.AddrBookSyncHelper", "mobile list null stop service");
          localObject1 = pAj.obtainMessage();
          ((Message)localObject1).obj = Boolean.FALSE;
          pAj.sendMessage((Message)localObject1);
          AppMethodBeat.o(127666);
          return;
        }
        int i = 0;
        if (i < this.pAg.size())
        {
          Log.i("MicroMsg.AddrBookSyncHelper", "sync mobile index: ".concat(String.valueOf(i)));
          if (!com.tencent.mm.kernel.h.baz())
          {
            Log.i("MicroMsg.AddrBookSyncHelper", "account not ready, stop sync");
            localObject1 = pAj.obtainMessage();
            ((Message)localObject1).obj = Boolean.FALSE;
            pAj.sendMessage((Message)localObject1);
            AppMethodBeat.o(127666);
            return;
          }
          if (i + 100 < this.pAg.size()) {}
          for (localObject1 = j(this.pAg, i, i + 100);; localObject1 = j((List)localObject1, i, ((List)localObject1).size()))
          {
            Log.i("MicroMsg.AddrBookSyncHelper", "sync mobile listToSync size: " + ((List)localObject1).size());
            com.tencent.mm.plugin.account.friend.model.i.cz((List)localObject1);
            i += 100;
            break;
            localObject1 = this.pAg;
          }
        }
        Log.i("MicroMsg.AddrBookSyncHelper", "sync ok");
        if (!com.tencent.mm.kernel.h.baz())
        {
          Log.i("MicroMsg.AddrBookSyncHelper", "account not ready, exit");
          localObject1 = pAj.obtainMessage();
          ((Message)localObject1).obj = Boolean.FALSE;
          pAj.sendMessage((Message)localObject1);
          AppMethodBeat.o(127666);
          return;
        }
        bTs();
        System.currentTimeMillis();
        com.tencent.mm.plugin.account.friend.model.i.bXa();
        this.pAi.addSplit("sync ok");
        this.pAi.dumpToLog();
        Object localObject1 = pAj.obtainMessage();
        ((Message)localObject1).obj = Boolean.TRUE;
        pAj.sendMessage((Message)localObject1);
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