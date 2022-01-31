package com.tencent.mm.plugin.messenger.foundation.a.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.sdk.e.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.storage.bi.b;
import com.tencent.mm.storage.bi.c;
import com.tencent.mm.storage.bi.d;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public abstract interface h
  extends g
{
  public abstract Cursor A(String paramString, long paramLong1, long paramLong2);
  
  public abstract int B(String paramString, long paramLong1, long paramLong2);
  
  public abstract int C(String paramString, long paramLong1, long paramLong2);
  
  public abstract Cursor D(String paramString, long paramLong1, long paramLong2);
  
  public abstract void J(ArrayList<Long> paramArrayList);
  
  public abstract Cursor L(String paramString1, String paramString2, int paramInt);
  
  public abstract int TA(String paramString);
  
  public abstract int TB(String paramString);
  
  public abstract String TC(String paramString);
  
  public abstract long TD(String paramString);
  
  public abstract long TE(String paramString);
  
  public abstract long TF(String paramString);
  
  public abstract bi TG(String paramString);
  
  public abstract int TH(String paramString);
  
  public abstract List<bi> TI(String paramString);
  
  public abstract long TJ(String paramString);
  
  public abstract Cursor TK(String paramString);
  
  public abstract void Th(String paramString);
  
  public abstract void Ti(String paramString);
  
  public abstract void Tj(String paramString);
  
  public abstract Cursor Tk(String paramString);
  
  public abstract bi Tl(String paramString);
  
  public abstract bi Tm(String paramString);
  
  public abstract bi Tn(String paramString);
  
  public abstract bi To(String paramString);
  
  public abstract List<bi> Tp(String paramString);
  
  public abstract Cursor Tq(String paramString);
  
  public abstract void Tr(String paramString);
  
  public abstract int Ts(String paramString);
  
  public abstract int Tt(String paramString);
  
  public abstract Cursor Tu(String paramString);
  
  public abstract Cursor Tv(String paramString);
  
  public abstract bi.c Tw(String paramString);
  
  public abstract bi.d Tx(String paramString);
  
  public abstract bi.a Ty(String paramString);
  
  public abstract bi.b Tz(String paramString);
  
  public abstract int Y(bi parambi);
  
  public abstract long Z(bi parambi);
  
  public abstract Cursor a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean);
  
  public abstract void a(long paramLong, bi parambi);
  
  public abstract void a(com.tencent.mm.cg.h paramh, String paramString);
  
  public abstract void a(a parama);
  
  public abstract void a(a parama, Looper paramLooper);
  
  public abstract void a(b paramb);
  
  public abstract void a(c paramc);
  
  public abstract void a(com.tencent.mm.storage.e parame);
  
  public abstract void aa(bi parambi);
  
  public abstract void aaL();
  
  public abstract int ab(bi parambi);
  
  public abstract void af(String paramString, long paramLong);
  
  public abstract bi ag(String paramString, long paramLong);
  
  public abstract bi ah(String paramString, long paramLong);
  
  public abstract bi ai(String paramString, long paramLong);
  
  public abstract List<bi> aj(String paramString, long paramLong);
  
  public abstract List<bi> ak(String paramString, long paramLong);
  
  public abstract bi al(String paramString, long paramLong);
  
  public abstract bi am(String paramString, long paramLong);
  
  public abstract List<bi> am(String paramString, int paramInt1, int paramInt2);
  
  public abstract Cursor an(String paramString, int paramInt1, int paramInt2);
  
  public abstract boolean an(String paramString, long paramLong);
  
  public abstract bi ao(String paramString, long paramLong);
  
  public abstract long ap(String paramString, long paramLong);
  
  public abstract int aq(String paramString, long paramLong);
  
  public abstract int ar(String paramString, long paramLong);
  
  public abstract int as(String paramString, long paramLong);
  
  public abstract String at(String paramString, long paramLong);
  
  public abstract bi au(String paramString, long paramLong);
  
  public abstract bi av(String paramString, long paramLong);
  
  public abstract Cursor b(String paramString, long paramLong1, long paramLong2, int paramInt);
  
  public abstract void b(long paramLong, bi parambi);
  
  public abstract void b(String paramString1, String paramString2, String[] paramArrayOfString);
  
  public abstract com.tencent.mm.cg.h bPX();
  
  public abstract void bPY();
  
  public abstract void bPZ();
  
  public abstract void bQa();
  
  public abstract ArrayList<bi> bQb();
  
  public abstract List<bi> bQc();
  
  public abstract Cursor bQd();
  
  public abstract String bQe();
  
  public abstract String bQf();
  
  public abstract List<bi> bQg();
  
  public abstract long c(bi parambi, boolean paramBoolean);
  
  public abstract Cursor c(String paramString, long paramLong1, long paramLong2, int paramInt);
  
  public abstract List<bi> cC(String paramString, int paramInt);
  
  public abstract List<bi> cD(String paramString, int paramInt);
  
  public abstract Cursor cE(String paramString, int paramInt);
  
  public abstract Cursor cF(String paramString, int paramInt);
  
  public abstract Cursor cG(String paramString, int paramInt);
  
  public abstract int cH(String paramString, int paramInt);
  
  public abstract Cursor cI(String paramString, int paramInt);
  
  public abstract Cursor cJ(String paramString, int paramInt);
  
  public abstract int cK(String paramString, int paramInt);
  
  public abstract Cursor cL(String paramString, int paramInt);
  
  public abstract bi[] cM(String paramString, int paramInt);
  
  public abstract Cursor cN(String paramString, int paramInt);
  
  public abstract Cursor d(String paramString, long paramLong1, long paramLong2, int paramInt);
  
  public abstract int f(String paramString, long paramLong, int paramInt);
  
  public abstract bi fi(String paramString1, String paramString2);
  
  public abstract Cursor fj(String paramString1, String paramString2);
  
  public abstract int fk(String paramString1, String paramString2);
  
  public abstract LinkedList<bi> fl(String paramString1, String paramString2);
  
  public abstract long g(String paramString, long paramLong, int paramInt);
  
  public abstract List<bi> g(String paramString, long paramLong, boolean paramBoolean);
  
  public abstract long h(String paramString, long paramLong, int paramInt);
  
  public abstract Cursor i(String paramString, long paramLong, int paramInt);
  
  public abstract Cursor j(String paramString, int paramInt, long paramLong);
  
  public abstract Cursor k(String paramString, int paramInt, long paramLong);
  
  public abstract bi kB(long paramLong);
  
  public abstract int kC(long paramLong);
  
  public abstract boolean kD(long paramLong);
  
  public abstract boolean kE(long paramLong);
  
  public abstract void kF(long paramLong);
  
  public abstract int pw(String paramString);
  
  public abstract boolean px(String paramString);
  
  public abstract Cursor w(String paramString, long paramLong1, long paramLong2);
  
  public abstract Cursor x(String paramString, long paramLong1, long paramLong2);
  
  public abstract int y(String paramString, long paramLong1, long paramLong2);
  
  public abstract bi yU(int paramInt);
  
  public abstract int z(String paramString, long paramLong1, long paramLong2);
  
  public static abstract interface a
  {
    public abstract void a(h paramh, h.c paramc);
  }
  
  public static final class b
  {
    public long fDU;
    public String name;
    private a[] oDL;
    public int oDM;
    
    public b(int paramInt, String paramString, a[] paramArrayOfa)
    {
      AppMethodBeat.i(60017);
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
        if (paramArrayOfa[0].oDO < paramArrayOfa[0].oDN) {
          break label157;
        }
        bool1 = true;
        label65:
        Assert.assertTrue(bool1);
        if (paramArrayOfa[1].oDO < paramArrayOfa[1].oDN) {
          break label163;
        }
        bool1 = true;
        label89:
        Assert.assertTrue(bool1);
        if (paramArrayOfa[1].oDN < paramArrayOfa[0].oDO) {
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
        this.oDL = paramArrayOfa;
        this.oDM = paramInt;
        this.fDU = paramArrayOfa[0].oDN;
        AppMethodBeat.o(60017);
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
    
    public static a[] a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
    {
      AppMethodBeat.i(60020);
      a locala1 = new a((byte)0);
      locala1.oDN = paramLong1;
      locala1.oDO = paramLong2;
      a locala2 = new a((byte)0);
      locala2.oDN = paramLong3;
      locala2.oDO = paramLong4;
      AppMethodBeat.o(60020);
      return new a[] { locala1, locala2 };
    }
    
    /* Error */
    public final void ac(bi parambi)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 68
      //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 52	com/tencent/mm/plugin/messenger/foundation/a/a/h$b:oDL	[Lcom/tencent/mm/plugin/messenger/foundation/a/a/h$b$a;
      //   11: iconst_0
      //   12: aaload
      //   13: astore_2
      //   14: aload_0
      //   15: getfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/h$b:fDU	J
      //   18: aload_2
      //   19: getfield 47	com/tencent/mm/plugin/messenger/foundation/a/a/h$b$a:oDO	J
      //   22: lcmp
      //   23: ifne +73 -> 96
      //   26: aload_0
      //   27: aload_0
      //   28: getfield 52	com/tencent/mm/plugin/messenger/foundation/a/a/h$b:oDL	[Lcom/tencent/mm/plugin/messenger/foundation/a/a/h$b$a;
      //   31: iconst_1
      //   32: aaload
      //   33: getfield 50	com/tencent/mm/plugin/messenger/foundation/a/a/h$b$a:oDN	J
      //   36: putfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/h$b:fDU	J
      //   39: getstatic 74	com/tencent/mm/plugin/report/e:qrI	Lcom/tencent/mm/plugin/report/e;
      //   42: ldc2_w 75
      //   45: ldc2_w 77
      //   48: lconst_1
      //   49: iconst_0
      //   50: invokevirtual 82	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
      //   53: invokestatic 88	com/tencent/mm/sdk/a/b:dsh	()Z
      //   56: ifne +24 -> 80
      //   59: ldc 90
      //   61: ldc 92
      //   63: iconst_1
      //   64: anewarray 4	java/lang/Object
      //   67: dup
      //   68: iconst_0
      //   69: aload_0
      //   70: getfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/h$b:fDU	J
      //   73: invokestatic 98	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   76: aastore
      //   77: invokestatic 103	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   80: aload_1
      //   81: aload_0
      //   82: getfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/h$b:fDU	J
      //   85: invokevirtual 109	com/tencent/mm/storage/bi:setMsgId	(J)V
      //   88: ldc 68
      //   90: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   93: aload_0
      //   94: monitorexit
      //   95: return
      //   96: aload_0
      //   97: aload_0
      //   98: getfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/h$b:fDU	J
      //   101: lconst_1
      //   102: ladd
      //   103: putfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/h$b:fDU	J
      //   106: goto -53 -> 53
      //   109: astore_1
      //   110: aload_0
      //   111: monitorexit
      //   112: aload_1
      //   113: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	114	0	this	b
      //   0	114	1	parambi	bi
      //   13	6	2	locala	a
      // Exception table:
      //   from	to	target	type
      //   2	53	109	finally
      //   53	80	109	finally
      //   80	93	109	finally
      //   96	106	109	finally
    }
    
    public final boolean kG(long paramLong)
    {
      a[] arrayOfa = this.oDL;
      int k = arrayOfa.length;
      int i = 0;
      while (i < k)
      {
        a locala = arrayOfa[i];
        if ((paramLong >= locala.oDN) && (paramLong <= locala.oDO)) {}
        for (int j = 1; j != 0; j = 0) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    
    public final void yV(int paramInt)
    {
      AppMethodBeat.i(60018);
      ab.i("MicroMsg.MsgTable", "summermsg setMsgLocalId [%d, %d]  regions[%d, %d] stack[%s]", new Object[] { Long.valueOf(this.fDU), Integer.valueOf(paramInt), Long.valueOf(this.oDL[0].oDO), Long.valueOf(this.oDL[1].oDN), bo.dtY() });
      if ((paramInt > this.oDL[0].oDO) && (paramInt < this.oDL[1].oDN))
      {
        ab.i("MicroMsg.MsgTable", "summermsg setMsgLocalId revised msgLocalId to %d", new Object[] { Long.valueOf(this.oDL[1].oDN) });
        this.fDU = this.oDL[1].oDN;
        com.tencent.mm.plugin.report.e.qrI.idkeyStat(111L, 169L, 1L, false);
        AppMethodBeat.o(60018);
        return;
      }
      this.fDU = paramInt;
      AppMethodBeat.o(60018);
    }
    
    public static final class a
    {
      long oDN;
      long oDO;
    }
  }
  
  public static final class c
  {
    public long jUy;
    public String oDP;
    public ArrayList<bi> oDQ;
    public int oDR;
    public int oDS;
    public int oDT;
    public long oDU;
    public String talker;
    
    public c(String paramString1, String paramString2, bi parambi)
    {
      this(paramString1, paramString2, parambi, 0);
    }
    
    public c(String paramString1, String paramString2, bi parambi, int paramInt)
    {
      AppMethodBeat.i(60021);
      this.oDQ = new ArrayList();
      this.oDS = 0;
      this.oDT = 0;
      this.oDU = 0L;
      this.jUy = -1L;
      this.talker = paramString1;
      this.oDP = paramString2;
      this.oDR = paramInt;
      if (parambi != null) {
        l = parambi.field_bizChatId;
      }
      this.jUy = l;
      if (parambi != null) {
        this.oDQ.add(parambi);
      }
      AppMethodBeat.o(60021);
    }
    
    public c(String paramString1, String paramString2, bi parambi, int paramInt, byte paramByte)
    {
      this(paramString1, paramString2, parambi, 0);
      this.oDT = paramInt;
    }
    
    public static boolean ad(bi parambi)
    {
      return (parambi != null) && (parambi.field_isSend == 0) && (parambi.field_status == 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.a.h
 * JD-Core Version:    0.7.0.1
 */