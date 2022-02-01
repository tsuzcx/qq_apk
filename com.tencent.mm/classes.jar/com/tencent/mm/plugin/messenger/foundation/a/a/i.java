package com.tencent.mm.plugin.messenger.foundation.a.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.sdk.e.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.a;
import com.tencent.mm.storage.bv.b;
import com.tencent.mm.storage.bv.c;
import com.tencent.mm.storage.bv.d;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public abstract interface i
  extends g
{
  public abstract Cursor A(String paramString, long paramLong1, long paramLong2);
  
  public abstract Cursor B(String paramString, long paramLong1, long paramLong2);
  
  public abstract int BO(String paramString);
  
  public abstract boolean BP(String paramString);
  
  public abstract int C(String paramString, long paramLong1, long paramLong2);
  
  public abstract int D(String paramString, long paramLong1, long paramLong2);
  
  public abstract Cursor E(String paramString, long paramLong1, long paramLong2);
  
  public abstract int F(String paramString, long paramLong1, long paramLong2);
  
  public abstract int G(String paramString, long paramLong1, long paramLong2);
  
  public abstract Cursor H(String paramString, int paramInt, long paramLong);
  
  public abstract Cursor H(String paramString, long paramLong1, long paramLong2);
  
  public abstract Cursor I(String paramString, int paramInt, long paramLong);
  
  public abstract List<bv> I(String paramString, long paramLong1, long paramLong2);
  
  public abstract bv Km(int paramInt);
  
  public abstract List<bv> Kn(int paramInt);
  
  public abstract Cursor a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean);
  
  public abstract void a(long paramLong, bv parambv);
  
  public abstract void a(a parama);
  
  public abstract void a(a parama, Looper paramLooper);
  
  public abstract void a(b paramb);
  
  public abstract void a(c paramc);
  
  public abstract void a(com.tencent.mm.storage.e parame);
  
  public abstract void aCq();
  
  public abstract void aI(String paramString, long paramLong);
  
  public abstract bv aJ(String paramString, long paramLong);
  
  public abstract bv aK(String paramString, long paramLong);
  
  public abstract bv aL(String paramString, long paramLong);
  
  public abstract bv aM(String paramString, long paramLong);
  
  public abstract bv aN(String paramString, long paramLong);
  
  public abstract boolean aO(String paramString, long paramLong);
  
  public abstract bv aP(String paramString, long paramLong);
  
  public abstract Cursor aQ(String paramString, long paramLong);
  
  public abstract long aR(String paramString, long paramLong);
  
  public abstract int aS(String paramString, long paramLong);
  
  public abstract int aT(String paramString, long paramLong);
  
  public abstract int aU(String paramString, long paramLong);
  
  public abstract int aV(String paramString, long paramLong);
  
  public abstract String aW(String paramString, long paramLong);
  
  public abstract bv aX(String paramString, long paramLong);
  
  public abstract bv aY(String paramString, long paramLong);
  
  public abstract Cursor ab(String paramString1, String paramString2, int paramInt);
  
  public abstract void ak(ArrayList<Long> paramArrayList);
  
  public abstract List<bv> ap(String paramString, int paramInt1, int paramInt2);
  
  public abstract int aq(bv parambv);
  
  public abstract Cursor aq(String paramString, int paramInt1, int paramInt2);
  
  public abstract void aqX(String paramString);
  
  public abstract void aqY(String paramString);
  
  public abstract void aqZ(String paramString);
  
  public abstract long ar(bv parambv);
  
  public abstract long arA(String paramString);
  
  public abstract Cursor arB(String paramString);
  
  public abstract long arC(String paramString);
  
  public abstract Cursor ara(String paramString);
  
  public abstract bv arb(String paramString);
  
  public abstract bv arc(String paramString);
  
  public abstract bv ard(String paramString);
  
  public abstract bv are(String paramString);
  
  public abstract bv arf(String paramString);
  
  public abstract List<bv> arg(String paramString);
  
  public abstract Cursor arh(String paramString);
  
  public abstract void ari(String paramString);
  
  public abstract int arj(String paramString);
  
  public abstract int ark(String paramString);
  
  public abstract Cursor arl(String paramString);
  
  public abstract Cursor arm(String paramString);
  
  public abstract bv.c arn(String paramString);
  
  public abstract bv.d aro(String paramString);
  
  public abstract bv.a arp(String paramString);
  
  public abstract bv.b arq(String paramString);
  
  public abstract int arr(String paramString);
  
  public abstract int ars(String paramString);
  
  public abstract String art(String paramString);
  
  public abstract long aru(String paramString);
  
  public abstract long arv(String paramString);
  
  public abstract long arw(String paramString);
  
  public abstract bv arx(String paramString);
  
  public abstract int ary(String paramString);
  
  public abstract List<bv> arz(String paramString);
  
  public abstract void as(bv parambv);
  
  public abstract int at(bv parambv);
  
  public abstract Cursor b(String paramString, long paramLong1, long paramLong2, int paramInt);
  
  public abstract void b(long paramLong, bv parambv);
  
  public abstract long c(bv parambv, boolean paramBoolean);
  
  public abstract Cursor c(String paramString, long paramLong1, long paramLong2, int paramInt);
  
  public abstract void c(String paramString1, String paramString2, String[] paramArrayOfString);
  
  public abstract Cursor d(String paramString, long paramLong1, long paramLong2, int paramInt);
  
  public abstract void d(h paramh, String paramString);
  
  public abstract void doS();
  
  public abstract void doT();
  
  public abstract void doU();
  
  public abstract ArrayList<bv> doV();
  
  public abstract List<bv> doW();
  
  public abstract Cursor doX();
  
  public abstract String doY();
  
  public abstract String doZ();
  
  public abstract int dpa();
  
  public abstract List<bv> dpb();
  
  public abstract List<bv> eB(List<String> paramList);
  
  public abstract List<bv> ei(String paramString, int paramInt);
  
  public abstract List<bv> ej(String paramString, int paramInt);
  
  public abstract List<bv> ek(String paramString, int paramInt);
  
  public abstract Cursor el(String paramString, int paramInt);
  
  public abstract Cursor em(String paramString, int paramInt);
  
  public abstract Cursor en(String paramString, int paramInt);
  
  public abstract int eo(String paramString, int paramInt);
  
  public abstract Cursor ep(String paramString, int paramInt);
  
  public abstract Cursor eq(String paramString, int paramInt);
  
  public abstract int er(String paramString, int paramInt);
  
  public abstract Cursor es(String paramString, int paramInt);
  
  public abstract bv[] et(String paramString, int paramInt);
  
  public abstract Cursor eu(String paramString, int paramInt);
  
  public abstract List<bv> f(String paramString, long paramLong, int paramInt);
  
  public abstract List<bv> f(String paramString, long paramLong, boolean paramBoolean);
  
  public abstract List<bv> g(String paramString, long paramLong, int paramInt);
  
  public abstract h getDB();
  
  public abstract int h(String paramString, long paramLong, int paramInt);
  
  public abstract bv hX(String paramString1, String paramString2);
  
  public abstract Cursor hY(String paramString1, String paramString2);
  
  public abstract int hZ(String paramString1, String paramString2);
  
  public abstract long i(String paramString, long paramLong, int paramInt);
  
  public abstract LinkedList<bv> ia(String paramString1, String paramString2);
  
  public abstract long j(String paramString, long paramLong, int paramInt);
  
  public abstract Cursor k(String paramString, long paramLong, int paramInt);
  
  public abstract bv ys(long paramLong);
  
  public abstract int yt(long paramLong);
  
  public abstract boolean yu(long paramLong);
  
  public abstract boolean yv(long paramLong);
  
  public abstract void yw(long paramLong);
  
  public static abstract interface a
  {
    public abstract void a(i parami, i.c paramc);
  }
  
  public static final class b
  {
    public long icx;
    public String name;
    private a[] vWe;
    public int vWf;
    
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
        if (paramArrayOfa[0].vWh < paramArrayOfa[0].vWg) {
          break label157;
        }
        bool1 = true;
        label65:
        Assert.assertTrue(bool1);
        if (paramArrayOfa[1].vWh < paramArrayOfa[1].vWg) {
          break label163;
        }
        bool1 = true;
        label89:
        Assert.assertTrue(bool1);
        if (paramArrayOfa[1].vWg < paramArrayOfa[0].vWh) {
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
        this.vWe = paramArrayOfa;
        this.vWf = paramInt;
        this.icx = paramArrayOfa[0].vWg;
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
      locala1.vWg = paramLong1;
      locala1.vWh = paramLong2;
      a locala2 = new a((byte)0);
      locala2.vWg = paramLong3;
      locala2.vWh = paramLong4;
      AppMethodBeat.o(43079);
      return new a[] { locala1, locala2 };
    }
    
    public final void Ko(int paramInt)
    {
      AppMethodBeat.i(43077);
      ae.i("MicroMsg.MsgTable", "summermsg setMsgLocalId [%d, %d]  regions[%d, %d] stack[%s]", new Object[] { Long.valueOf(this.icx), Integer.valueOf(paramInt), Long.valueOf(this.vWe[0].vWh), Long.valueOf(this.vWe[1].vWg), bu.fpN() });
      if ((paramInt > this.vWe[0].vWh) && (paramInt < this.vWe[1].vWg))
      {
        ae.i("MicroMsg.MsgTable", "summermsg setMsgLocalId revised msgLocalId to %d", new Object[] { Long.valueOf(this.vWe[1].vWg) });
        this.icx = this.vWe[1].vWg;
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(111L, 169L, 1L, false);
        AppMethodBeat.o(43077);
        return;
      }
      this.icx = paramInt;
      AppMethodBeat.o(43077);
    }
    
    /* Error */
    public final void au(bv parambv)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 112
      //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 52	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:vWe	[Lcom/tencent/mm/plugin/messenger/foundation/a/a/i$b$a;
      //   11: iconst_0
      //   12: aaload
      //   13: astore_2
      //   14: aload_0
      //   15: getfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:icx	J
      //   18: aload_2
      //   19: getfield 47	com/tencent/mm/plugin/messenger/foundation/a/a/i$b$a:vWh	J
      //   22: lcmp
      //   23: ifne +73 -> 96
      //   26: aload_0
      //   27: aload_0
      //   28: getfield 52	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:vWe	[Lcom/tencent/mm/plugin/messenger/foundation/a/a/i$b$a;
      //   31: iconst_1
      //   32: aaload
      //   33: getfield 50	com/tencent/mm/plugin/messenger/foundation/a/a/i$b$a:vWg	J
      //   36: putfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:icx	J
      //   39: getstatic 101	com/tencent/mm/plugin/report/e:ywz	Lcom/tencent/mm/plugin/report/e;
      //   42: ldc2_w 102
      //   45: ldc2_w 113
      //   48: lconst_1
      //   49: iconst_0
      //   50: invokevirtual 109	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
      //   53: invokestatic 120	com/tencent/mm/sdk/a/b:fnH	()Z
      //   56: ifne +24 -> 80
      //   59: ldc 69
      //   61: ldc 122
      //   63: iconst_1
      //   64: anewarray 4	java/lang/Object
      //   67: dup
      //   68: iconst_0
      //   69: aload_0
      //   70: getfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:icx	J
      //   73: invokestatic 77	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   76: aastore
      //   77: invokestatic 93	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   80: aload_1
      //   81: aload_0
      //   82: getfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:icx	J
      //   85: invokevirtual 128	com/tencent/mm/storage/bv:setMsgId	(J)V
      //   88: ldc 112
      //   90: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   93: aload_0
      //   94: monitorexit
      //   95: return
      //   96: aload_0
      //   97: aload_0
      //   98: getfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:icx	J
      //   101: lconst_1
      //   102: ladd
      //   103: putfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:icx	J
      //   106: goto -53 -> 53
      //   109: astore_1
      //   110: aload_0
      //   111: monitorexit
      //   112: aload_1
      //   113: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	114	0	this	b
      //   0	114	1	parambv	bv
      //   13	6	2	locala	a
      // Exception table:
      //   from	to	target	type
      //   2	53	109	finally
      //   53	80	109	finally
      //   80	93	109	finally
      //   96	106	109	finally
    }
    
    public final boolean yx(long paramLong)
    {
      a[] arrayOfa = this.vWe;
      int k = arrayOfa.length;
      int i = 0;
      while (i < k)
      {
        a locala = arrayOfa[i];
        if ((paramLong >= locala.vWg) && (paramLong <= locala.vWh)) {}
        for (int j = 1; j != 0; j = 0) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    
    public static final class a
    {
      long vWg;
      long vWh;
    }
  }
  
  public static final class c
  {
    public ArrayList<bv> gQn;
    public long oex;
    public int slP;
    public String talker;
    public String vWi;
    public int vWj;
    public int vWk;
    public long vWl;
    
    public c(String paramString1, String paramString2, bv parambv)
    {
      this(paramString1, paramString2, parambv, 0);
    }
    
    public c(String paramString1, String paramString2, bv parambv, int paramInt)
    {
      AppMethodBeat.i(43080);
      this.gQn = new ArrayList();
      this.vWj = 0;
      this.vWk = 0;
      this.vWl = 0L;
      this.oex = -1L;
      this.talker = paramString1;
      this.vWi = paramString2;
      this.slP = paramInt;
      if (parambv != null) {
        l = parambv.field_bizChatId;
      }
      this.oex = l;
      if (parambv != null) {
        this.gQn.add(parambv);
      }
      AppMethodBeat.o(43080);
    }
    
    public c(String paramString1, String paramString2, bv parambv, int paramInt, byte paramByte)
    {
      this(paramString1, paramString2, parambv, 0);
      this.vWk = paramInt;
    }
    
    public static boolean av(bv parambv)
    {
      return (parambv != null) && (parambv.field_isSend == 0) && (parambv.field_status == 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.a.i
 * JD-Core Version:    0.7.0.1
 */