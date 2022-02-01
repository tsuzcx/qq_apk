package com.tencent.mm.plugin.messenger.foundation.a.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IStorage;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.a;
import com.tencent.mm.storage.ca.b;
import com.tencent.mm.storage.ca.c;
import com.tencent.mm.storage.ca.d;
import com.tencent.mm.storage.e;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public abstract interface i
  extends IStorage
{
  public abstract Cursor A(String paramString, long paramLong1, long paramLong2);
  
  public abstract Cursor B(String paramString, long paramLong1, long paramLong2);
  
  public abstract int C(String paramString, long paramLong1, long paramLong2);
  
  public abstract int D(String paramString, long paramLong1, long paramLong2);
  
  public abstract Cursor E(String paramString, long paramLong1, long paramLong2);
  
  public abstract int F(String paramString, long paramLong1, long paramLong2);
  
  public abstract int G(String paramString, long paramLong1, long paramLong2);
  
  public abstract Cursor H(String paramString, int paramInt, long paramLong);
  
  public abstract Cursor H(String paramString, long paramLong1, long paramLong2);
  
  public abstract Cursor I(String paramString, int paramInt, long paramLong);
  
  public abstract List<ca> I(String paramString, long paramLong1, long paramLong2);
  
  public abstract ca Oq(long paramLong);
  
  public abstract int Or(long paramLong);
  
  public abstract boolean Os(long paramLong);
  
  public abstract boolean Ot(long paramLong);
  
  public abstract void Ou(long paramLong);
  
  public abstract int RN(String paramString);
  
  public abstract boolean RO(String paramString);
  
  public abstract ca WB(int paramInt);
  
  public abstract List<ca> WC(int paramInt);
  
  public abstract void a(long paramLong, ca paramca);
  
  public abstract void a(a parama);
  
  public abstract void a(a parama, Looper paramLooper);
  
  public abstract void a(b paramb);
  
  public abstract void a(c paramc);
  
  public abstract void a(e parame);
  
  public abstract void aF(ArrayList<Long> paramArrayList);
  
  public abstract void aK(String paramString, long paramLong);
  
  public abstract int aL(ca paramca);
  
  public abstract ca aL(String paramString, long paramLong);
  
  public abstract long aM(ca paramca);
  
  public abstract ca aM(String paramString, long paramLong);
  
  public abstract ca aN(String paramString, long paramLong);
  
  public abstract void aN(ca paramca);
  
  public abstract int aO(ca paramca);
  
  public abstract ca aO(String paramString, long paramLong);
  
  public abstract void aOC(String paramString);
  
  public abstract void aOD(String paramString);
  
  public abstract void aOE(String paramString);
  
  public abstract Cursor aOF(String paramString);
  
  public abstract ca aOG(String paramString);
  
  public abstract ca aOH(String paramString);
  
  public abstract ca aOI(String paramString);
  
  public abstract ca aOJ(String paramString);
  
  public abstract ca aOK(String paramString);
  
  public abstract List<ca> aOL(String paramString);
  
  public abstract Cursor aOM(String paramString);
  
  public abstract void aON(String paramString);
  
  public abstract int aOO(String paramString);
  
  public abstract int aOP(String paramString);
  
  public abstract Cursor aOQ(String paramString);
  
  public abstract Cursor aOR(String paramString);
  
  public abstract ca.c aOS(String paramString);
  
  public abstract ca.d aOT(String paramString);
  
  public abstract ca.a aOU(String paramString);
  
  public abstract ca.b aOV(String paramString);
  
  public abstract int aOW(String paramString);
  
  public abstract int aOX(String paramString);
  
  public abstract String aOY(String paramString);
  
  public abstract long aOZ(String paramString);
  
  public abstract ca aP(String paramString, long paramLong);
  
  public abstract long aPa(String paramString);
  
  public abstract long aPb(String paramString);
  
  public abstract ca aPc(String paramString);
  
  public abstract int aPd(String paramString);
  
  public abstract List<ca> aPe(String paramString);
  
  public abstract long aPf(String paramString);
  
  public abstract Cursor aPg(String paramString);
  
  public abstract long aPh(String paramString);
  
  public abstract boolean aQ(String paramString, long paramLong);
  
  public abstract ca aR(String paramString, long paramLong);
  
  public abstract Cursor aS(String paramString, long paramLong);
  
  public abstract long aT(String paramString, long paramLong);
  
  public abstract int aU(String paramString, long paramLong);
  
  public abstract int aV(String paramString, long paramLong);
  
  public abstract int aW(String paramString, long paramLong);
  
  public abstract int aX(String paramString, long paramLong);
  
  public abstract String aY(String paramString, long paramLong);
  
  public abstract Cursor aZ(String paramString, long paramLong);
  
  public abstract Cursor aj(String paramString1, String paramString2, int paramInt);
  
  public abstract List<ca> au(String paramString, int paramInt1, int paramInt2);
  
  public abstract Cursor av(String paramString, int paramInt1, int paramInt2);
  
  public abstract Cursor b(String paramString, long paramLong1, long paramLong2, int paramInt);
  
  public abstract Cursor b(String paramString, long paramLong1, long paramLong2, boolean paramBoolean);
  
  public abstract void b(long paramLong, ca paramca);
  
  public abstract ca ba(String paramString, long paramLong);
  
  public abstract void beR();
  
  public abstract long c(ca paramca, boolean paramBoolean);
  
  public abstract Cursor c(String paramString, long paramLong1, long paramLong2, int paramInt);
  
  public abstract Cursor d(String paramString, long paramLong1, long paramLong2, int paramInt);
  
  public abstract void d(String paramString1, String paramString2, String[] paramArrayOfString);
  
  public abstract List<ca> e(String paramString, long paramLong, boolean paramBoolean);
  
  public abstract void e(h paramh, String paramString);
  
  public abstract void eSn();
  
  public abstract void eSo();
  
  public abstract void eSp();
  
  public abstract ArrayList<ca> eSq();
  
  public abstract List<ca> eSr();
  
  public abstract Cursor eSs();
  
  public abstract String eSt();
  
  public abstract String eSu();
  
  public abstract int eSv();
  
  public abstract List<ca> eSw();
  
  public abstract List<ca> eX(String paramString, int paramInt);
  
  public abstract List<ca> eY(String paramString, int paramInt);
  
  public abstract List<ca> eZ(String paramString, int paramInt);
  
  public abstract List<ca> fY(List<String> paramList);
  
  public abstract Cursor fa(String paramString, int paramInt);
  
  public abstract Cursor fb(String paramString, int paramInt);
  
  public abstract Cursor fc(String paramString, int paramInt);
  
  public abstract int fd(String paramString, int paramInt);
  
  public abstract Cursor fe(String paramString, int paramInt);
  
  public abstract Cursor ff(String paramString, int paramInt);
  
  public abstract int fg(String paramString, int paramInt);
  
  public abstract Cursor fh(String paramString, int paramInt);
  
  public abstract ca[] fi(String paramString, int paramInt);
  
  public abstract Cursor fj(String paramString, int paramInt);
  
  public abstract List<ca> g(String paramString, long paramLong, int paramInt);
  
  public abstract h getDB();
  
  public abstract List<ca> h(String paramString, long paramLong, int paramInt);
  
  public abstract int i(String paramString, long paramLong, int paramInt);
  
  public abstract ca iR(String paramString1, String paramString2);
  
  public abstract Cursor iS(String paramString1, String paramString2);
  
  public abstract int iT(String paramString1, String paramString2);
  
  public abstract LinkedList<ca> iU(String paramString1, String paramString2);
  
  public abstract long j(String paramString, long paramLong, int paramInt);
  
  public abstract long k(String paramString, long paramLong, int paramInt);
  
  public abstract Cursor l(String paramString, long paramLong, int paramInt);
  
  public abstract List<ca> m(String paramString, ArrayList<Long> paramArrayList);
  
  public static abstract interface a
  {
    public abstract void onNotifyChange(i parami, i.c paramc);
  }
  
  public static final class b
  {
    private a[] EVI;
    public int EVJ;
    public long lNP;
    public String name;
    
    public b(int paramInt, String paramString, a[] paramArrayOfa)
    {
      AppMethodBeat.i(43076);
      if (paramString.length() > 0)
      {
        bool1 = true;
        Assert.assertTrue(bool1);
        this.name = paramString;
        if (paramArrayOfa.length != 2) {
          break label151;
        }
        bool1 = true;
        label41:
        Assert.assertTrue(bool1);
        if (paramArrayOfa[0].EVL < paramArrayOfa[0].EVK) {
          break label157;
        }
        bool1 = true;
        label65:
        Assert.assertTrue(bool1);
        if (paramArrayOfa[1].EVL < paramArrayOfa[1].EVK) {
          break label163;
        }
        bool1 = true;
        label89:
        Assert.assertTrue(bool1);
        if (paramArrayOfa[1].EVK < paramArrayOfa[0].EVL) {
          break label169;
        }
      }
      label151:
      label157:
      label163:
      label169:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        Assert.assertTrue(bool1);
        this.EVI = paramArrayOfa;
        this.EVJ = paramInt;
        this.lNP = paramArrayOfa[0].EVK;
        AppMethodBeat.o(43076);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label41;
        bool1 = false;
        break label65;
        bool1 = false;
        break label89;
      }
    }
    
    public static a[] b(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
    {
      AppMethodBeat.i(43079);
      a locala1 = new a((byte)0);
      locala1.EVK = paramLong1;
      locala1.EVL = paramLong2;
      a locala2 = new a((byte)0);
      locala2.EVK = paramLong3;
      locala2.EVL = paramLong4;
      AppMethodBeat.o(43079);
      return new a[] { locala1, locala2 };
    }
    
    public final boolean Ov(long paramLong)
    {
      a[] arrayOfa = this.EVI;
      int k = arrayOfa.length;
      int i = 0;
      while (i < k)
      {
        a locala = arrayOfa[i];
        if ((paramLong >= locala.EVK) && (paramLong <= locala.EVL)) {}
        for (int j = 1; j != 0; j = 0) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    
    public final void WD(int paramInt)
    {
      AppMethodBeat.i(43077);
      Log.i("MicroMsg.MsgTable", "summermsg setMsgLocalId [%d, %d]  regions[%d, %d] stack[%s]", new Object[] { Long.valueOf(this.lNP), Integer.valueOf(paramInt), Long.valueOf(this.EVI[0].EVL), Long.valueOf(this.EVI[1].EVK), Util.getStack() });
      if ((paramInt > this.EVI[0].EVL) && (paramInt < this.EVI[1].EVK))
      {
        Log.i("MicroMsg.MsgTable", "summermsg setMsgLocalId revised msgLocalId to %d", new Object[] { Long.valueOf(this.EVI[1].EVK) });
        this.lNP = this.EVI[1].EVK;
        f.Iyx.idkeyStat(111L, 169L, 1L, false);
        AppMethodBeat.o(43077);
        return;
      }
      this.lNP = paramInt;
      AppMethodBeat.o(43077);
    }
    
    /* Error */
    public final void aP(ca paramca)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 114
      //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 52	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:EVI	[Lcom/tencent/mm/plugin/messenger/foundation/a/a/i$b$a;
      //   11: iconst_0
      //   12: aaload
      //   13: astore_2
      //   14: aload_0
      //   15: getfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:lNP	J
      //   18: aload_2
      //   19: getfield 47	com/tencent/mm/plugin/messenger/foundation/a/a/i$b$a:EVL	J
      //   22: lcmp
      //   23: ifne +73 -> 96
      //   26: aload_0
      //   27: aload_0
      //   28: getfield 52	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:EVI	[Lcom/tencent/mm/plugin/messenger/foundation/a/a/i$b$a;
      //   31: iconst_1
      //   32: aaload
      //   33: getfield 50	com/tencent/mm/plugin/messenger/foundation/a/a/i$b$a:EVK	J
      //   36: putfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:lNP	J
      //   39: getstatic 103	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
      //   42: ldc2_w 104
      //   45: ldc2_w 115
      //   48: lconst_1
      //   49: iconst_0
      //   50: invokevirtual 111	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
      //   53: invokestatic 122	com/tencent/mm/sdk/crash/CrashReportFactory:isBackupMerge	()Z
      //   56: ifne +24 -> 80
      //   59: ldc 71
      //   61: ldc 124
      //   63: iconst_1
      //   64: anewarray 4	java/lang/Object
      //   67: dup
      //   68: iconst_0
      //   69: aload_0
      //   70: getfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:lNP	J
      //   73: invokestatic 79	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   76: aastore
      //   77: invokestatic 95	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   80: aload_1
      //   81: aload_0
      //   82: getfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:lNP	J
      //   85: invokevirtual 130	com/tencent/mm/storage/ca:setMsgId	(J)V
      //   88: ldc 114
      //   90: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   93: aload_0
      //   94: monitorexit
      //   95: return
      //   96: aload_0
      //   97: aload_0
      //   98: getfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:lNP	J
      //   101: lconst_1
      //   102: ladd
      //   103: putfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:lNP	J
      //   106: goto -53 -> 53
      //   109: astore_1
      //   110: aload_0
      //   111: monitorexit
      //   112: aload_1
      //   113: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	114	0	this	b
      //   0	114	1	paramca	ca
      //   13	6	2	locala	a
      // Exception table:
      //   from	to	target	type
      //   2	53	109	finally
      //   53	80	109	finally
      //   80	93	109	finally
      //   96	106	109	finally
    }
    
    public static final class a
    {
      long EVK;
      long EVL;
    }
  }
  
  public static class c
  {
    public String EVM;
    public int EVN;
    public int EVO;
    public long EVP;
    public ArrayList<ca> kvM;
    public long syu;
    public String talker;
    public int xKO;
    
    public c(String paramString1, String paramString2, ca paramca)
    {
      this(paramString1, paramString2, paramca, 0);
    }
    
    public c(String paramString1, String paramString2, ca paramca, int paramInt)
    {
      AppMethodBeat.i(43080);
      this.kvM = new ArrayList();
      this.EVN = 0;
      this.EVO = 0;
      this.EVP = 0L;
      this.syu = -1L;
      this.talker = paramString1;
      this.EVM = paramString2;
      this.xKO = paramInt;
      if (paramca != null) {
        l = paramca.field_bizChatId;
      }
      this.syu = l;
      if (paramca != null) {
        this.kvM.add(paramca);
      }
      AppMethodBeat.o(43080);
    }
    
    public c(String paramString1, String paramString2, ca paramca, int paramInt, byte paramByte)
    {
      this(paramString1, paramString2, paramca, 0);
      this.EVO = paramInt;
    }
    
    public static boolean aQ(ca paramca)
    {
      return (paramca != null) && (paramca.field_isSend == 0) && (paramca.field_status == 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.a.i
 * JD-Core Version:    0.7.0.1
 */