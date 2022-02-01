package com.tencent.mm.platformtools;

import android.os.Looper;
import android.os.Message;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.b.g;
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
  public static final HashSet<com.tencent.mm.plugin.account.sdk.a.b> mDt;
  private static final com.tencent.mm.plugin.account.sdk.a.b mDu;
  private static Thread thread;
  
  static
  {
    AppMethodBeat.i(127672);
    thread = null;
    mDt = new HashSet();
    mDu = new com.tencent.mm.plugin.account.sdk.a.b()
    {
      public final void gr(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(127662);
        Log.i("MicroMsg.AddrBookSyncHelper", "syncAddrBookAndUpload onSyncEnd suc:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(127662);
          return;
        }
        System.currentTimeMillis();
        l.byn();
        ao localao = new ao(l.byr(), l.byq());
        com.tencent.mm.kernel.h.aGY().a(localao, 0);
        AppMethodBeat.o(127662);
      }
    };
    AppMethodBeat.o(127672);
  }
  
  public static boolean bvc()
  {
    AppMethodBeat.i(127670);
    boolean bool = syncAddrBook(mDu);
    AppMethodBeat.o(127670);
    return bool;
  }
  
  public static boolean bvd()
  {
    return a.jQz;
  }
  
  public static boolean syncAddrBook(com.tencent.mm.plugin.account.sdk.a.b paramb)
  {
    AppMethodBeat.i(127671);
    long l = Thread.currentThread().getId();
    boolean bool = l.byl();
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
        if ((a.bve() != null) && (a.bve().isAlive())) {}
        for (boolean bool = true;; bool = false)
        {
          Log.i("MicroMsg.AddrBookSyncHelper", "syncAddrBook running:%b setSize:%d call:%d callback:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(a.mDt.size()), Long.valueOf(this.mDv), this.mDw });
          a.mDt.add(this.mDw);
          if (!bool) {
            break;
          }
          AppMethodBeat.o(127663);
          return;
        }
        l.gX(true);
        com.tencent.e.h.ZvG.bh(new a.a((byte)0));
        AppMethodBeat.o(127663);
      }
    });
    AppMethodBeat.o(127671);
    return true;
  }
  
  static final class a
    implements com.tencent.e.i.h
  {
    public static boolean jQz;
    private static byte[] lock;
    private static final MMHandler mDD;
    private List<com.tencent.mm.plugin.account.friend.a.a> mDA;
    private TimeLogger mDC;
    private List<String[]> mDx;
    private List<String[]> mDy;
    private List<com.tencent.mm.plugin.account.friend.a.a> mDz;
    
    static
    {
      AppMethodBeat.i(127669);
      jQz = false;
      lock = new byte[0];
      mDD = new a.a.1(Looper.getMainLooper());
      AppMethodBeat.o(127669);
    }
    
    private static void bvf()
    {
      AppMethodBeat.i(127667);
      TimeLogger localTimeLogger = new TimeLogger("MicroMsg.AddrBookSyncHelper", "delete");
      ArrayList localArrayList = new ArrayList();
      List localList = com.tencent.mm.pluginsdk.b.jn(MMApplicationContext.getContext());
      Iterator localIterator = ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getAddrUploadStg()).byb().iterator();
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
        ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getAddrUploadStg()).aR(localArrayList);
        l.aT(localArrayList);
      }
      localTimeLogger.addSplit("end");
      localTimeLogger.dumpToLog();
      AppMethodBeat.o(127667);
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
              paramList = g.getMessageDigest(str2.getBytes());
            }
            if (paramInt == 0)
            {
              paramList = com.tencent.mm.pluginsdk.b.aaY(str2);
              if (Util.isNullOrNil(paramList)) {
                Log.d("MicroMsg.AddrBookSyncHelper", "formatted mobile null, continue");
              } else {
                paramList = g.getMessageDigest(paramList.getBytes());
              }
            }
            else
            {
              com.tencent.mm.plugin.account.friend.a.a locala = new com.tencent.mm.plugin.account.friend.a.a();
              locala.realName = str1;
              locala.mVp = f.ZK(str1);
              locala.mVq = f.ZJ(str1);
              locala.mVn = localObject1;
              locala.lAY = localObject2;
              locala.setMd5(paramList);
              locala.mVQ = l;
              locala.mVw = locala.axh();
              if (paramInt == 1) {
                locala.hDf = str2;
              }
              if (paramInt == 0) {
                locala.mVt = str2;
              }
              locala.type = paramInt;
              locala.cUP = 1095798;
              localArrayList.add(locala);
            }
          }
        }
      }
      AppMethodBeat.o(127668);
      return localArrayList;
    }
    
    private static List<com.tencent.mm.plugin.account.friend.a.a> d(List<com.tencent.mm.plugin.account.friend.a.a> paramList, int paramInt1, int paramInt2)
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
    
    public final String getKey()
    {
      return "AddrBookSyncHelper_addrBookRead";
    }
    
    public final void run()
    {
      AppMethodBeat.i(127666);
      synchronized (lock)
      {
        this.mDC = new TimeLogger("MicroMsg.AddrBookSyncHelper", "sync addrBook");
        this.mDC.addSplit("sync begin");
        Log.d("MicroMsg.AddrBookSyncHelper", "reading email info");
        this.mDx = com.tencent.mm.pluginsdk.b.jm(MMApplicationContext.getContext());
        if (this.mDx != null) {
          Log.i("MicroMsg.AddrBookSyncHelper", "sync address book email size: " + this.mDx.size());
        }
        this.mDA = d(1, this.mDx);
        Log.d("MicroMsg.AddrBookSyncHelper", "reading mobile info");
        this.mDy = com.tencent.mm.pluginsdk.b.jl(MMApplicationContext.getContext());
        if (this.mDy != null) {
          Log.i("MicroMsg.AddrBookSyncHelper", "sync address book mobile size: " + this.mDy.size());
        }
        this.mDz = d(0, this.mDy);
        Log.d("MicroMsg.AddrBookSyncHelper", "reading done, begin sync to addr_upload");
        if ((this.mDx != null) && (this.mDA.size() > 0))
        {
          i = 0;
          if (i < this.mDA.size())
          {
            Log.i("MicroMsg.AddrBookSyncHelper", "sync email index: ".concat(String.valueOf(i)));
            if (i + 100 < this.mDA.size()) {}
            for (localObject1 = d(this.mDA, i, i + 100);; localObject1 = d((List)localObject1, i, ((List)localObject1).size()))
            {
              Log.i("MicroMsg.AddrBookSyncHelper", "sync email listToSync size: " + ((List)localObject1).size());
              l.aU((List)localObject1);
              i += 100;
              break;
              localObject1 = this.mDA;
            }
          }
        }
        if ((this.mDz == null) || (this.mDz.size() == 0))
        {
          Log.i("MicroMsg.AddrBookSyncHelper", "mobile list null stop service");
          localObject1 = mDD.obtainMessage();
          ((Message)localObject1).obj = Boolean.FALSE;
          mDD.sendMessage((Message)localObject1);
          AppMethodBeat.o(127666);
          return;
        }
        int i = 0;
        if (i < this.mDz.size())
        {
          Log.i("MicroMsg.AddrBookSyncHelper", "sync mobile index: ".concat(String.valueOf(i)));
          if (!com.tencent.mm.kernel.h.aHB())
          {
            Log.i("MicroMsg.AddrBookSyncHelper", "account not ready, stop sync");
            localObject1 = mDD.obtainMessage();
            ((Message)localObject1).obj = Boolean.FALSE;
            mDD.sendMessage((Message)localObject1);
            AppMethodBeat.o(127666);
            return;
          }
          if (i + 100 < this.mDz.size()) {}
          for (localObject1 = d(this.mDz, i, i + 100);; localObject1 = d((List)localObject1, i, ((List)localObject1).size()))
          {
            Log.i("MicroMsg.AddrBookSyncHelper", "sync mobile listToSync size: " + ((List)localObject1).size());
            l.aU((List)localObject1);
            i += 100;
            break;
            localObject1 = this.mDz;
          }
        }
        Log.i("MicroMsg.AddrBookSyncHelper", "sync ok");
        if (!com.tencent.mm.kernel.h.aHB())
        {
          Log.i("MicroMsg.AddrBookSyncHelper", "account not ready, exit");
          localObject1 = mDD.obtainMessage();
          ((Message)localObject1).obj = Boolean.FALSE;
          mDD.sendMessage((Message)localObject1);
          AppMethodBeat.o(127666);
          return;
        }
        bvf();
        System.currentTimeMillis();
        l.byn();
        this.mDC.addSplit("sync ok");
        this.mDC.dumpToLog();
        Object localObject1 = mDD.obtainMessage();
        ((Message)localObject1).obj = Boolean.TRUE;
        mDD.sendMessage((Message)localObject1);
        AppMethodBeat.o(127666);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.platformtools.a
 * JD-Core Version:    0.7.0.1
 */