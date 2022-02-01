package com.tencent.mm.modelimage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.b.b;
import com.tencent.mm.j.a;
import com.tencent.mm.j.a.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.br;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.report.service.g.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class q
{
  private static q oIN;
  ConcurrentHashMap<Long, d> oIL;
  public c oIM;
  public ConcurrentHashMap<Long, e> oIO;
  private ArrayList<Long> oIP;
  ArrayList<e> oIQ;
  
  public q()
  {
    AppMethodBeat.i(150733);
    this.oIL = new ConcurrentHashMap();
    this.oIO = new ConcurrentHashMap();
    this.oIP = new ArrayList();
    this.oIQ = new ArrayList();
    this.oIM = new c();
    AppMethodBeat.o(150733);
  }
  
  private boolean Oj(String paramString)
  {
    AppMethodBeat.i(150740);
    Iterator localIterator = this.oIQ.iterator();
    while (localIterator.hasNext()) {
      if (((e)localIterator.next()).oJb.equals(paramString))
      {
        AppMethodBeat.o(150740);
        return true;
      }
    }
    AppMethodBeat.o(150740);
    return false;
  }
  
  public static q bJO()
  {
    AppMethodBeat.i(150734);
    if (oIN == null) {}
    try
    {
      if (oIN == null) {
        oIN = new q();
      }
      q localq = oIN;
      AppMethodBeat.o(150734);
      return localq;
    }
    finally
    {
      AppMethodBeat.o(150734);
    }
  }
  
  private static int j(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(150743);
    boolean bool = z.h(paramString1, paramString2, paramBoolean);
    paramBoolean = bool;
    if (bool)
    {
      paramBoolean = bool;
      if (c.NN(paramString1))
      {
        Log.i("MicroMsg.SendImgSpeeder", "getCompressType send no compress as bigImg");
        paramBoolean = false;
      }
    }
    if (paramBoolean)
    {
      AppMethodBeat.o(150743);
      return 1;
    }
    AppMethodBeat.o(150743);
    return 0;
  }
  
  public final ArrayList<String> Oh(String paramString)
  {
    AppMethodBeat.i(150735);
    ArrayList localArrayList = new ArrayList();
    if (!Util.isNullOrNil(paramString))
    {
      Iterator localIterator = this.oIO.values().iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (paramString.equals(locale.hHa)) {
          localArrayList.add(locale.oJb);
        }
      }
    }
    AppMethodBeat.o(150735);
    return localArrayList;
  }
  
  public final ArrayList<Integer> Oi(String paramString)
  {
    AppMethodBeat.i(150736);
    Object localObject1 = this.oIO.values();
    Object localObject2 = ((Collection)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      e locale = (e)((Iterator)localObject2).next();
      PString localPString = new PString();
      PInt localPInt1 = new PInt();
      PInt localPInt2 = new PInt();
      locale.oJe = r.bKa().a(locale.hHa, locale.oJb, locale.oGu, locale.source, locale.hOX, localPString, localPInt1, localPInt2, locale.oJc, locale.oJd, locale.msgId, locale.oJi, locale.oJj, locale.oJk, -1);
      cc localcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(locale.msgId);
      if (Util.isNullOrNil(localcc.field_imgPath))
      {
        localcc.BT(localPString.value);
        localcc.pW(localPInt1.value);
        localcc.pX(localPInt2.value);
        ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(locale.msgId, localcc);
      }
    }
    if (!Util.isNullOrNil(paramString))
    {
      localObject1 = ((Collection)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (e)((Iterator)localObject1).next();
        if (!paramString.equals(((e)localObject2).hHa))
        {
          this.oIO.remove(Long.valueOf(((e)localObject2).msgId));
          this.oIP.remove(Long.valueOf(((e)localObject2).msgId));
          Log.e("MicroMsg.SendImgSpeeder", "fatal!! Send user mis-match, want:%s, fact:%s", new Object[] { paramString, ((e)localObject2).hHa });
        }
      }
    }
    paramString = new ArrayList();
    int i = 0;
    while (i < this.oIP.size())
    {
      paramString.add(Integer.valueOf((int)((e)this.oIO.get(this.oIP.get(i))).oJe));
      i += 1;
    }
    this.oIO.clear();
    this.oIP.clear();
    Log.i("MicroMsg.SendImgSpeeder", "syncImgData, id size %d", new Object[] { Integer.valueOf(paramString.size()) });
    AppMethodBeat.o(150736);
    return paramString;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean, int paramInt3)
  {
    AppMethodBeat.i(239010);
    if (Oj(paramString1))
    {
      AppMethodBeat.o(239010);
      return;
    }
    int i = j(paramString1, paramString2, paramBoolean);
    PString localPString = new PString();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    b localb1 = null;
    b localb2 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    if (bJP())
    {
      localObject2 = this.oIM.wx(1);
      localObject1 = this.oIM.wx(2);
      localb1 = ((b)localObject2).oIY;
      localb2 = ((b)localObject1).oIY;
      localObject1 = ((b)localObject1).des;
      localObject2 = ((b)localObject2).des;
    }
    r.bKa().a(paramString2, paramString1, i, localPString, localPInt1, localPInt2, paramInt2, paramInt3, (String)localObject1);
    localObject1 = e.a(paramString1, i, paramInt1, paramInt2, (String)localObject1, (String)localObject2, localPString, localPInt1, localPInt2, localb1, localb2);
    ((e)localObject1).hHa = paramString2;
    this.oIQ.add(localObject1);
    Log.i("MicroMsg.SendImgSpeeder", "summersafecdn img path %s has prebuild, user:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(239010);
  }
  
  public final void a(ArrayList<String> paramArrayList, boolean paramBoolean, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(239006);
    Log.i("MicroMsg.SendImgSpeeder", "summersafecdn sendThumbImg fileSize:%d, compressImg[%b], source[%d], user:%s", new Object[] { Integer.valueOf(paramArrayList.size()), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), paramString });
    a(paramArrayList, paramBoolean, paramString);
    Object localObject1 = new ArrayList();
    if (paramArrayList.size() == 9)
    {
      g.ahw(18);
      paramArrayList = paramArrayList.iterator();
    }
    Object localObject2;
    for (;;)
    {
      if (!paramArrayList.hasNext()) {
        break label264;
      }
      localObject2 = (String)paramArrayList.next();
      if ((localObject2 == null) || (((String)localObject2).equals("")) || (!y.ZC((String)localObject2)))
      {
        Log.d("MicroMsg.SendImgSpeeder", " doSendImage : filePath is null or empty");
        continue;
        if (paramArrayList.size() == 1)
        {
          boolean bool = NetStatusUtil.isWifi(MMApplicationContext.getContext());
          g.ahw(25);
          if (!bool) {
            break;
          }
          if (z.h((String)paramArrayList.get(0), paramString, paramBoolean))
          {
            g.ahw(23);
            break;
          }
          g.ahw(21);
          break;
        }
        g.ahw(24);
        break;
      }
      if (ImgUtil.isGif((String)localObject2)) {
        Log.i("MicroMsg.SendImgSpeeder", "[cpan] is gif coutinue. did not add filePath:%s filesize:%d", new Object[] { localObject2, Long.valueOf(y.bEl((String)localObject2)) });
      } else if (!Oj((String)localObject2)) {
        ((ArrayList)localObject1).add(localObject2);
      }
    }
    label264:
    paramArrayList = ((ArrayList)localObject1).iterator();
    while (paramArrayList.hasNext()) {
      a(paramInt1, paramInt2, (String)paramArrayList.next(), paramString, paramBoolean, paramInt3);
    }
    paramArrayList = new ArrayList();
    long l1 = com.tencent.mm.kernel.h.baE().mCN.beginTransaction(Thread.currentThread().getId());
    ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLB("SendImgSpeeder");
    paramInt1 = 1;
    paramInt2 = 0;
    if (paramInt2 < this.oIQ.size())
    {
      localObject1 = (e)this.oIQ.get(paramInt2);
      if (ImgUtil.isGif(((e)localObject1).oJb)) {
        Log.i("MicroMsg.SendImgSpeeder", "[cpan] is gif coutinue. did not add to msg table");
      }
      for (;;)
      {
        paramInt2 += 1;
        break;
        localObject2 = new cc();
        ((cc)localObject2).setType(ab.IY(paramString));
        ((cc)localObject2).BS(paramString);
        ((cc)localObject2).pI(1);
        ((cc)localObject2).setStatus(1);
        ((cc)localObject2).BT(((e)localObject1).oJf.value);
        ((cc)localObject2).pW(((e)localObject1).oJg.value);
        ((cc)localObject2).pX(((e)localObject1).oJh.value);
        String str = bt.bCQ();
        if (((str != null) && (!str.equals(((fi)localObject2).jUr))) || ((str == null) && (((fi)localObject2).jUr != null))) {
          ((cc)localObject2).AU(str);
        }
        a.a.aOb().n((cc)localObject2);
        ((cc)localObject2).setCreateTime(br.JN(((fi)localObject2).field_talker));
        paramArrayList.add(localObject2);
        long l2 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().ba((cc)localObject2);
        if (l2 <= 0L)
        {
          Log.e("MicroMsg.SendImgSpeeder", "insert error! %s", new Object[] { paramString });
          paramInt1 = 0;
        }
        else
        {
          ((e)localObject1).msgId = l2;
          this.oIO.put(Long.valueOf(((e)localObject1).msgId), localObject1);
          this.oIP.add(Long.valueOf(((e)localObject1).msgId));
          paramInt1 = 0;
        }
      }
    }
    this.oIQ.clear();
    if (l1 > 0L) {
      com.tencent.mm.kernel.h.baE().mCN.endTransaction(l1);
    }
    if (paramInt1 != 0) {
      ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLC("SendImgSpeeder");
    }
    AppMethodBeat.o(239006);
  }
  
  public final void a(ArrayList<String> paramArrayList, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(239002);
    Object localObject1 = this.oIQ.iterator();
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject4 = (e)((Iterator)localObject1).next();
      if ((!paramArrayList.contains(((e)localObject4).oJb)) || ((!Util.isNullOrNil(((e)localObject4).hHa)) && (!((e)localObject4).hHa.equalsIgnoreCase(paramString))) || ((!Util.isNullOrNil(paramString)) && (!paramString.equalsIgnoreCase(((e)localObject4).hHa))))
      {
        localObject2 = r.bKa().a(((e)localObject4).oJd, "", ".jpg", false);
        localObject3 = ((com.tencent.mm.plugin.emoji.c.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.emoji.c.c.class)).anI((String)localObject2);
        localObject4 = r.bKa().a(((e)localObject4).oJc, "th_", "", false);
        y.deleteFile((String)localObject2);
        y.deleteFile((String)localObject3);
        y.deleteFile((String)localObject4);
        Log.i("MicroMsg.SendImgSpeeder", "confirmFinalImgTask: delete %s, %s, %s", new Object[] { localObject2, localObject3, localObject4 });
        ((Iterator)localObject1).remove();
      }
      else
      {
        ((e)localObject4).oGu = j(((e)localObject4).oJb, paramString, paramBoolean);
      }
    }
    paramString = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      localObject1 = (String)paramArrayList.next();
      localObject2 = this.oIQ.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (e)((Iterator)localObject2).next();
        if (((e)localObject3).oJb.equals(localObject1)) {
          paramString.add(localObject3);
        }
      }
    }
    this.oIQ.clear();
    this.oIQ.addAll(paramString);
    AppMethodBeat.o(239002);
  }
  
  public final boolean bJP()
  {
    AppMethodBeat.i(150741);
    if ((this.oIQ.size() > 0) && (g.a.gNV().OAj <= 2))
    {
      Log.i("MicroMsg.SendImgSpeeder", "cpu core is low ,do not use multi mode");
      AppMethodBeat.o(150741);
      return false;
    }
    AppMethodBeat.o(150741);
    return true;
  }
  
  public final boolean iT(long paramLong)
  {
    AppMethodBeat.i(150737);
    boolean bool = this.oIL.containsKey(Long.valueOf(paramLong));
    AppMethodBeat.o(150737);
    return bool;
  }
  
  public final d iU(long paramLong)
  {
    AppMethodBeat.i(150738);
    d locald = (d)this.oIL.get(Long.valueOf(paramLong));
    AppMethodBeat.o(150738);
    return locald;
  }
  
  static final class b
  {
    String des;
    b oIY;
  }
  
  public static final class c
  {
    private LinkedList<q.b> oIZ;
    private LinkedList<q.b> oJa;
    
    public c()
    {
      AppMethodBeat.i(150724);
      this.oIZ = new LinkedList();
      this.oJa = new LinkedList();
      AppMethodBeat.o(150724);
    }
    
    private static boolean Ok(String paramString)
    {
      AppMethodBeat.i(150728);
      if (y.bEl(paramString) > 0L)
      {
        Log.e("MicroMsg.SendImgSpeeder", "file has exist %s", new Object[] { paramString });
        AppMethodBeat.o(150728);
        return false;
      }
      AppMethodBeat.o(150728);
      return true;
    }
    
    private static q.b bJT()
    {
      AppMethodBeat.i(150726);
      q.b localb = new q.b((byte)0);
      if (Util.isNullOrNil(null)) {}
      String str;
      for (localb.des = j.bJJ();; localb.des = null)
      {
        str = r.bKa().Oc(localb.des);
        if (Ok(str)) {
          break;
        }
        AppMethodBeat.o(150726);
        return null;
      }
      localb.oIY = new b(str);
      AppMethodBeat.o(150726);
      return localb;
    }
    
    private static q.b bJU()
    {
      AppMethodBeat.i(150727);
      q.b localb = new q.b((byte)0);
      if (Util.isNullOrNil(null)) {}
      String str;
      for (localb.des = j.bJJ();; localb.des = null)
      {
        str = r.bKa().Ob(localb.des);
        if (Ok(str)) {
          break;
        }
        AppMethodBeat.o(150727);
        return null;
      }
      localb.oIY = new b(str);
      AppMethodBeat.o(150727);
      return localb;
    }
    
    private void bJV()
    {
      for (;;)
      {
        int i;
        try
        {
          AppMethodBeat.i(150730);
          StringBuilder localStringBuilder = new StringBuilder();
          i = 0;
          if (i < this.oIZ.size())
          {
            localStringBuilder.append(((q.b)this.oIZ.get(i)).des);
            if (i != this.oIZ.size() - 1) {
              localStringBuilder.append("-");
            }
          }
          else
          {
            Log.d("MicroMsg.SendImgSpeeder", "sync big des to file %s ", new Object[] { localStringBuilder.toString() });
            com.tencent.mm.kernel.h.baE().ban().B(348176, localStringBuilder.toString());
            AppMethodBeat.o(150730);
            return;
          }
        }
        finally {}
        i += 1;
      }
    }
    
    private void bJW()
    {
      for (;;)
      {
        int i;
        try
        {
          AppMethodBeat.i(150731);
          StringBuilder localStringBuilder = new StringBuilder();
          i = 0;
          if (i < this.oJa.size())
          {
            localStringBuilder.append(((q.b)this.oJa.get(i)).des);
            if (i != this.oJa.size() - 1) {
              localStringBuilder.append("-");
            }
          }
          else
          {
            Log.d("MicroMsg.SendImgSpeeder", "sync thumb des to file %s ", new Object[] { localStringBuilder.toString() });
            com.tencent.mm.kernel.h.baE().ban().B(348177, localStringBuilder.toString());
            AppMethodBeat.o(150731);
            return;
          }
        }
        finally {}
        i += 1;
      }
    }
    
    public final void bJS()
    {
      int j = 0;
      try
      {
        AppMethodBeat.i(150725);
        int i = this.oIZ.size();
        int k;
        q.b localb;
        if (i < 0)
        {
          k = 5 - i;
          i = 0;
          while (i < k)
          {
            localb = bJT();
            this.oIZ.add(localb);
            i += 1;
          }
          Log.i("MicroMsg.SendImgSpeeder", "add big File pool added size %d , all size %d", new Object[] { Integer.valueOf(k), Integer.valueOf(this.oIZ.size()) });
          bJV();
        }
        i = this.oJa.size();
        if (i < 0)
        {
          k = 5 - i;
          i = j;
          while (i < k)
          {
            localb = bJU();
            this.oJa.add(localb);
            i += 1;
          }
          bJW();
          Log.i("MicroMsg.SendImgSpeeder", "add big thumb pool added size %d , all size %d", new Object[] { Integer.valueOf(k), Integer.valueOf(this.oJa.size()) });
        }
        AppMethodBeat.o(150725);
        return;
      }
      finally {}
    }
    
    public final q.b wx(int paramInt)
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.i(150729);
          q.b localb1 = null;
          if (paramInt == 1)
          {
            if (this.oIZ.size() > 0)
            {
              localb1 = (q.b)this.oIZ.remove();
              bJV();
              bJS();
              AppMethodBeat.o(150729);
              return localb1;
            }
            localb1 = bJT();
            continue;
          }
          if (paramInt == 2) {
            if (this.oJa.size() > 0)
            {
              localb1 = (q.b)this.oJa.remove();
              bJW();
            }
            else
            {
              q.b localb2 = bJU();
            }
          }
        }
        finally {}
      }
    }
  }
  
  public static final class d
  {
    public long offset;
    public long total;
  }
  
  public static final class e
  {
    String hHa;
    int hOX;
    long msgId;
    int oGu;
    String oJb;
    String oJc;
    String oJd;
    long oJe;
    PString oJf;
    PInt oJg;
    PInt oJh;
    b oJi;
    b oJj;
    q.a oJk;
    int source;
    
    public static e a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, PString paramPString, PInt paramPInt1, PInt paramPInt2, b paramb1, b paramb2)
    {
      AppMethodBeat.i(150732);
      e locale = new e();
      locale.oJb = paramString1;
      locale.oGu = paramInt1;
      locale.source = paramInt2;
      locale.hOX = paramInt3;
      locale.oJc = paramString2;
      locale.oJf = paramPString;
      locale.oJh = paramPInt2;
      locale.oJg = paramPInt1;
      locale.oJd = paramString3;
      locale.oJj = paramb2;
      locale.oJi = paramb1;
      if (q.bJQ().bJP()) {
        q.a.a(locale);
      }
      AppMethodBeat.o(150732);
      return locale;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelimage.q
 * JD-Core Version:    0.7.0.1
 */