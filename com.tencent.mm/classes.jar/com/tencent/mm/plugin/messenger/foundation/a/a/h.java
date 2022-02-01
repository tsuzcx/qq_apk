package com.tencent.mm.plugin.messenger.foundation.a.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.sdk.e.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bo.a;
import com.tencent.mm.storage.bo.b;
import com.tencent.mm.storage.bo.c;
import com.tencent.mm.storage.bo.d;
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
  
  public abstract int E(String paramString, long paramLong1, long paramLong2);
  
  public abstract int F(String paramString, long paramLong1, long paramLong2);
  
  public abstract Cursor G(String paramString, long paramLong1, long paramLong2);
  
  public abstract List<bo> H(String paramString, long paramLong1, long paramLong2);
  
  public abstract bo Iq(int paramInt);
  
  public abstract Cursor Y(String paramString1, String paramString2, int paramInt);
  
  public abstract Cursor a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean);
  
  public abstract void a(long paramLong, bo parambo);
  
  public abstract void a(a parama);
  
  public abstract void a(a parama, Looper paramLooper);
  
  public abstract void a(b paramb);
  
  public abstract void a(c paramc);
  
  public abstract void a(com.tencent.mm.storage.e parame);
  
  public abstract void aE(String paramString, long paramLong);
  
  public abstract bo aF(String paramString, long paramLong);
  
  public abstract bo aG(String paramString, long paramLong);
  
  public abstract bo aH(String paramString, long paramLong);
  
  public abstract List<bo> aI(String paramString, long paramLong);
  
  public abstract List<bo> aJ(String paramString, long paramLong);
  
  public abstract bo aK(String paramString, long paramLong);
  
  public abstract bo aL(String paramString, long paramLong);
  
  public abstract boolean aM(String paramString, long paramLong);
  
  public abstract bo aN(String paramString, long paramLong);
  
  public abstract Cursor aO(String paramString, long paramLong);
  
  public abstract long aP(String paramString, long paramLong);
  
  public abstract int aQ(String paramString, long paramLong);
  
  public abstract int aR(String paramString, long paramLong);
  
  public abstract int aS(String paramString, long paramLong);
  
  public abstract int aT(String paramString, long paramLong);
  
  public abstract String aU(String paramString, long paramLong);
  
  public abstract bo aV(String paramString, long paramLong);
  
  public abstract bo aW(String paramString, long paramLong);
  
  public abstract List<bo> al(String paramString, int paramInt1, int paramInt2);
  
  public abstract void al(ArrayList<Long> paramArrayList);
  
  public abstract String alA(String paramString);
  
  public abstract long alB(String paramString);
  
  public abstract long alC(String paramString);
  
  public abstract long alD(String paramString);
  
  public abstract bo alE(String paramString);
  
  public abstract int alF(String paramString);
  
  public abstract List<bo> alG(String paramString);
  
  public abstract long alH(String paramString);
  
  public abstract Cursor alI(String paramString);
  
  public abstract void alf(String paramString);
  
  public abstract void alg(String paramString);
  
  public abstract void alh(String paramString);
  
  public abstract Cursor ali(String paramString);
  
  public abstract bo alj(String paramString);
  
  public abstract bo alk(String paramString);
  
  public abstract bo all(String paramString);
  
  public abstract bo alm(String paramString);
  
  public abstract List<bo> aln(String paramString);
  
  public abstract Cursor alo(String paramString);
  
  public abstract void alp(String paramString);
  
  public abstract int alq(String paramString);
  
  public abstract int alr(String paramString);
  
  public abstract Cursor als(String paramString);
  
  public abstract Cursor alt(String paramString);
  
  public abstract bo.c alu(String paramString);
  
  public abstract bo.d alv(String paramString);
  
  public abstract bo.a alw(String paramString);
  
  public abstract bo.b alx(String paramString);
  
  public abstract int aly(String paramString);
  
  public abstract int alz(String paramString);
  
  public abstract Cursor am(String paramString, int paramInt1, int paramInt2);
  
  public abstract int ao(bo parambo);
  
  public abstract long ap(bo parambo);
  
  public abstract void aq(bo parambo);
  
  public abstract int ar(bo parambo);
  
  public abstract void ayW();
  
  public abstract Cursor b(String paramString, long paramLong1, long paramLong2, int paramInt);
  
  public abstract void b(long paramLong, bo parambo);
  
  public abstract void b(String paramString1, String paramString2, String[] paramArrayOfString);
  
  public abstract long c(bo parambo, boolean paramBoolean);
  
  public abstract Cursor c(String paramString, long paramLong1, long paramLong2, int paramInt);
  
  public abstract void c(com.tencent.mm.storagebase.h paramh, String paramString);
  
  public abstract Cursor d(String paramString, long paramLong1, long paramLong2, int paramInt);
  
  public abstract List<bo> dK(String paramString, int paramInt);
  
  public abstract List<bo> dL(String paramString, int paramInt);
  
  public abstract List<bo> dM(String paramString, int paramInt);
  
  public abstract Cursor dN(String paramString, int paramInt);
  
  public abstract Cursor dO(String paramString, int paramInt);
  
  public abstract Cursor dP(String paramString, int paramInt);
  
  public abstract int dQ(String paramString, int paramInt);
  
  public abstract Cursor dR(String paramString, int paramInt);
  
  public abstract Cursor dS(String paramString, int paramInt);
  
  public abstract int dT(String paramString, int paramInt);
  
  public abstract Cursor dU(String paramString, int paramInt);
  
  public abstract bo[] dV(String paramString, int paramInt);
  
  public abstract Cursor dW(String paramString, int paramInt);
  
  public abstract void dcA();
  
  public abstract void dcB();
  
  public abstract ArrayList<bo> dcC();
  
  public abstract List<bo> dcD();
  
  public abstract Cursor dcE();
  
  public abstract String dcF();
  
  public abstract String dcG();
  
  public abstract int dcH();
  
  public abstract List<bo> dcI();
  
  public abstract void dcz();
  
  public abstract int f(String paramString, long paramLong, int paramInt);
  
  public abstract long g(String paramString, long paramLong, int paramInt);
  
  public abstract List<bo> g(String paramString, long paramLong, boolean paramBoolean);
  
  public abstract com.tencent.mm.storagebase.h getDB();
  
  public abstract long h(String paramString, long paramLong, int paramInt);
  
  public abstract bo hG(String paramString1, String paramString2);
  
  public abstract Cursor hH(String paramString1, String paramString2);
  
  public abstract int hI(String paramString1, String paramString2);
  
  public abstract LinkedList<bo> hJ(String paramString1, String paramString2);
  
  public abstract Cursor i(String paramString, long paramLong, int paramInt);
  
  public abstract Cursor m(String paramString, int paramInt, long paramLong);
  
  public abstract Cursor n(String paramString, int paramInt, long paramLong);
  
  public abstract bo vP(long paramLong);
  
  public abstract int vQ(long paramLong);
  
  public abstract boolean vR(long paramLong);
  
  public abstract boolean vS(long paramLong);
  
  public abstract void vT(long paramLong);
  
  public abstract int yn(String paramString);
  
  public abstract boolean yo(String paramString);
  
  public abstract Cursor z(String paramString, long paramLong1, long paramLong2);
  
  public static abstract interface a
  {
    public abstract void a(h paramh, h.c paramc);
  }
  
  public static final class b
  {
    public long hGV;
    public String name;
    private a[] uGX;
    public int uGY;
    
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
        if (paramArrayOfa[0].uHa < paramArrayOfa[0].uGZ) {
          break label157;
        }
        bool1 = true;
        label65:
        Assert.assertTrue(bool1);
        if (paramArrayOfa[1].uHa < paramArrayOfa[1].uGZ) {
          break label163;
        }
        bool1 = true;
        label89:
        Assert.assertTrue(bool1);
        if (paramArrayOfa[1].uGZ < paramArrayOfa[0].uHa) {
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
        this.uGX = paramArrayOfa;
        this.uGY = paramInt;
        this.hGV = paramArrayOfa[0].uGZ;
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
    
    public static a[] a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
    {
      AppMethodBeat.i(43079);
      a locala1 = new a((byte)0);
      locala1.uGZ = paramLong1;
      locala1.uHa = paramLong2;
      a locala2 = new a((byte)0);
      locala2.uGZ = paramLong3;
      locala2.uHa = paramLong4;
      AppMethodBeat.o(43079);
      return new a[] { locala1, locala2 };
    }
    
    public final void Ir(int paramInt)
    {
      AppMethodBeat.i(43077);
      ac.i("MicroMsg.MsgTable", "summermsg setMsgLocalId [%d, %d]  regions[%d, %d] stack[%s]", new Object[] { Long.valueOf(this.hGV), Integer.valueOf(paramInt), Long.valueOf(this.uGX[0].uHa), Long.valueOf(this.uGX[1].uGZ), bs.eWi() });
      if ((paramInt > this.uGX[0].uHa) && (paramInt < this.uGX[1].uGZ))
      {
        ac.i("MicroMsg.MsgTable", "summermsg setMsgLocalId revised msgLocalId to %d", new Object[] { Long.valueOf(this.uGX[1].uGZ) });
        this.hGV = this.uGX[1].uGZ;
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(111L, 169L, 1L, false);
        AppMethodBeat.o(43077);
        return;
      }
      this.hGV = paramInt;
      AppMethodBeat.o(43077);
    }
    
    /* Error */
    public final void as(bo parambo)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 112
      //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 52	com/tencent/mm/plugin/messenger/foundation/a/a/h$b:uGX	[Lcom/tencent/mm/plugin/messenger/foundation/a/a/h$b$a;
      //   11: iconst_0
      //   12: aaload
      //   13: astore_2
      //   14: aload_0
      //   15: getfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/h$b:hGV	J
      //   18: aload_2
      //   19: getfield 47	com/tencent/mm/plugin/messenger/foundation/a/a/h$b$a:uHa	J
      //   22: lcmp
      //   23: ifne +73 -> 96
      //   26: aload_0
      //   27: aload_0
      //   28: getfield 52	com/tencent/mm/plugin/messenger/foundation/a/a/h$b:uGX	[Lcom/tencent/mm/plugin/messenger/foundation/a/a/h$b$a;
      //   31: iconst_1
      //   32: aaload
      //   33: getfield 50	com/tencent/mm/plugin/messenger/foundation/a/a/h$b$a:uGZ	J
      //   36: putfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/h$b:hGV	J
      //   39: getstatic 101	com/tencent/mm/plugin/report/e:wTc	Lcom/tencent/mm/plugin/report/e;
      //   42: ldc2_w 102
      //   45: ldc2_w 113
      //   48: lconst_1
      //   49: iconst_0
      //   50: invokevirtual 109	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
      //   53: invokestatic 120	com/tencent/mm/sdk/a/b:eUm	()Z
      //   56: ifne +24 -> 80
      //   59: ldc 69
      //   61: ldc 122
      //   63: iconst_1
      //   64: anewarray 4	java/lang/Object
      //   67: dup
      //   68: iconst_0
      //   69: aload_0
      //   70: getfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/h$b:hGV	J
      //   73: invokestatic 77	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   76: aastore
      //   77: invokestatic 93	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   80: aload_1
      //   81: aload_0
      //   82: getfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/h$b:hGV	J
      //   85: invokevirtual 128	com/tencent/mm/storage/bo:setMsgId	(J)V
      //   88: ldc 112
      //   90: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   93: aload_0
      //   94: monitorexit
      //   95: return
      //   96: aload_0
      //   97: aload_0
      //   98: getfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/h$b:hGV	J
      //   101: lconst_1
      //   102: ladd
      //   103: putfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/h$b:hGV	J
      //   106: goto -53 -> 53
      //   109: astore_1
      //   110: aload_0
      //   111: monitorexit
      //   112: aload_1
      //   113: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	114	0	this	b
      //   0	114	1	parambo	bo
      //   13	6	2	locala	a
      // Exception table:
      //   from	to	target	type
      //   2	53	109	finally
      //   53	80	109	finally
      //   80	93	109	finally
      //   96	106	109	finally
    }
    
    public final boolean vU(long paramLong)
    {
      a[] arrayOfa = this.uGX;
      int k = arrayOfa.length;
      int i = 0;
      while (i < k)
      {
        a locala = arrayOfa[i];
        if ((paramLong >= locala.uGZ) && (paramLong <= locala.uHa)) {}
        for (int j = 1; j != 0; j = 0) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    
    public static final class a
    {
      long uGZ;
      long uHa;
    }
  }
  
  public static final class c
  {
    public ArrayList<bo> gtT;
    public long nxq;
    public int rnT;
    public String talker;
    public String uHb;
    public int uHc;
    public int uHd;
    public long uHe;
    
    public c(String paramString1, String paramString2, bo parambo)
    {
      this(paramString1, paramString2, parambo, 0);
    }
    
    public c(String paramString1, String paramString2, bo parambo, int paramInt)
    {
      AppMethodBeat.i(43080);
      this.gtT = new ArrayList();
      this.uHc = 0;
      this.uHd = 0;
      this.uHe = 0L;
      this.nxq = -1L;
      this.talker = paramString1;
      this.uHb = paramString2;
      this.rnT = paramInt;
      if (parambo != null) {
        l = parambo.field_bizChatId;
      }
      this.nxq = l;
      if (parambo != null) {
        this.gtT.add(parambo);
      }
      AppMethodBeat.o(43080);
    }
    
    public c(String paramString1, String paramString2, bo parambo, int paramInt, byte paramByte)
    {
      this(paramString1, paramString2, parambo, 0);
      this.uHd = paramInt;
    }
    
    public static boolean at(bo parambo)
    {
      return (parambo != null) && (parambo.field_isSend == 0) && (parambo.field_status == 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.a.h
 * JD-Core Version:    0.7.0.1
 */