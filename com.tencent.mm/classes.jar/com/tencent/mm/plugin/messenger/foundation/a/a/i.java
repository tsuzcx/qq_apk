package com.tencent.mm.plugin.messenger.foundation.a.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.sdk.e.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bu.a;
import com.tencent.mm.storage.bu.b;
import com.tencent.mm.storage.bu.c;
import com.tencent.mm.storage.bu.d;
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
  
  public abstract int Bm(String paramString);
  
  public abstract boolean Bn(String paramString);
  
  public abstract int C(String paramString, long paramLong1, long paramLong2);
  
  public abstract int D(String paramString, long paramLong1, long paramLong2);
  
  public abstract Cursor E(String paramString, long paramLong1, long paramLong2);
  
  public abstract int F(String paramString, long paramLong1, long paramLong2);
  
  public abstract int G(String paramString, long paramLong1, long paramLong2);
  
  public abstract Cursor H(String paramString, long paramLong1, long paramLong2);
  
  public abstract Cursor I(String paramString, int paramInt, long paramLong);
  
  public abstract List<bu> I(String paramString, long paramLong1, long paramLong2);
  
  public abstract Cursor J(String paramString, int paramInt, long paramLong);
  
  public abstract bu JN(int paramInt);
  
  public abstract Cursor a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean);
  
  public abstract void a(long paramLong, bu parambu);
  
  public abstract void a(a parama);
  
  public abstract void a(a parama, Looper paramLooper);
  
  public abstract void a(b paramb);
  
  public abstract void a(c paramc);
  
  public abstract void a(com.tencent.mm.storage.e parame);
  
  public abstract void aCa();
  
  public abstract void aH(String paramString, long paramLong);
  
  public abstract bu aI(String paramString, long paramLong);
  
  public abstract bu aJ(String paramString, long paramLong);
  
  public abstract bu aK(String paramString, long paramLong);
  
  public abstract bu aL(String paramString, long paramLong);
  
  public abstract bu aM(String paramString, long paramLong);
  
  public abstract boolean aN(String paramString, long paramLong);
  
  public abstract bu aO(String paramString, long paramLong);
  
  public abstract Cursor aP(String paramString, long paramLong);
  
  public abstract long aQ(String paramString, long paramLong);
  
  public abstract int aR(String paramString, long paramLong);
  
  public abstract int aS(String paramString, long paramLong);
  
  public abstract int aT(String paramString, long paramLong);
  
  public abstract int aU(String paramString, long paramLong);
  
  public abstract String aV(String paramString, long paramLong);
  
  public abstract bu aW(String paramString, long paramLong);
  
  public abstract bu aX(String paramString, long paramLong);
  
  public abstract Cursor ab(String paramString1, String paramString2, int paramInt);
  
  public abstract void ak(ArrayList<Long> paramArrayList);
  
  public abstract List<bu> ap(String paramString, int paramInt1, int paramInt2);
  
  public abstract void apS(String paramString);
  
  public abstract void apT(String paramString);
  
  public abstract void apU(String paramString);
  
  public abstract Cursor apV(String paramString);
  
  public abstract bu apW(String paramString);
  
  public abstract bu apX(String paramString);
  
  public abstract bu apY(String paramString);
  
  public abstract bu apZ(String paramString);
  
  public abstract Cursor aq(String paramString, int paramInt1, int paramInt2);
  
  public abstract bu aqa(String paramString);
  
  public abstract List<bu> aqb(String paramString);
  
  public abstract Cursor aqc(String paramString);
  
  public abstract void aqd(String paramString);
  
  public abstract int aqe(String paramString);
  
  public abstract int aqf(String paramString);
  
  public abstract Cursor aqg(String paramString);
  
  public abstract Cursor aqh(String paramString);
  
  public abstract bu.c aqi(String paramString);
  
  public abstract bu.d aqj(String paramString);
  
  public abstract bu.a aqk(String paramString);
  
  public abstract bu.b aql(String paramString);
  
  public abstract int aqm(String paramString);
  
  public abstract int aqn(String paramString);
  
  public abstract String aqo(String paramString);
  
  public abstract long aqp(String paramString);
  
  public abstract long aqq(String paramString);
  
  public abstract long aqr(String paramString);
  
  public abstract bu aqs(String paramString);
  
  public abstract int aqt(String paramString);
  
  public abstract List<bu> aqu(String paramString);
  
  public abstract long aqv(String paramString);
  
  public abstract Cursor aqw(String paramString);
  
  public abstract long aqx(String paramString);
  
  public abstract int ar(bu parambu);
  
  public abstract long as(bu parambu);
  
  public abstract void at(bu parambu);
  
  public abstract int au(bu parambu);
  
  public abstract Cursor b(String paramString, long paramLong1, long paramLong2, int paramInt);
  
  public abstract void b(long paramLong, bu parambu);
  
  public abstract long c(bu parambu, boolean paramBoolean);
  
  public abstract Cursor c(String paramString, long paramLong1, long paramLong2, int paramInt);
  
  public abstract void c(String paramString1, String paramString2, String[] paramArrayOfString);
  
  public abstract Cursor d(String paramString, long paramLong1, long paramLong2, int paramInt);
  
  public abstract void d(h paramh, String paramString);
  
  public abstract void dlT();
  
  public abstract void dlU();
  
  public abstract void dlV();
  
  public abstract ArrayList<bu> dlW();
  
  public abstract List<bu> dlX();
  
  public abstract Cursor dlY();
  
  public abstract String dlZ();
  
  public abstract String dma();
  
  public abstract int dmb();
  
  public abstract List<bu> dmc();
  
  public abstract List<bu> eb(String paramString, int paramInt);
  
  public abstract List<bu> ec(String paramString, int paramInt);
  
  public abstract List<bu> ed(String paramString, int paramInt);
  
  public abstract Cursor ee(String paramString, int paramInt);
  
  public abstract Cursor ef(String paramString, int paramInt);
  
  public abstract Cursor eg(String paramString, int paramInt);
  
  public abstract int eh(String paramString, int paramInt);
  
  public abstract Cursor ei(String paramString, int paramInt);
  
  public abstract Cursor ej(String paramString, int paramInt);
  
  public abstract int ek(String paramString, int paramInt);
  
  public abstract Cursor el(String paramString, int paramInt);
  
  public abstract bu[] em(String paramString, int paramInt);
  
  public abstract Cursor en(String paramString, int paramInt);
  
  public abstract List<bu> f(String paramString, long paramLong, int paramInt);
  
  public abstract List<bu> f(String paramString, long paramLong, boolean paramBoolean);
  
  public abstract List<bu> g(String paramString, long paramLong, int paramInt);
  
  public abstract h getDB();
  
  public abstract int h(String paramString, long paramLong, int paramInt);
  
  public abstract bu hQ(String paramString1, String paramString2);
  
  public abstract Cursor hR(String paramString1, String paramString2);
  
  public abstract int hS(String paramString1, String paramString2);
  
  public abstract LinkedList<bu> hT(String paramString1, String paramString2);
  
  public abstract long i(String paramString, long paramLong, int paramInt);
  
  public abstract long j(String paramString, long paramLong, int paramInt);
  
  public abstract Cursor k(String paramString, long paramLong, int paramInt);
  
  public abstract bu xY(long paramLong);
  
  public abstract int xZ(long paramLong);
  
  public abstract boolean ya(long paramLong);
  
  public abstract boolean yb(long paramLong);
  
  public abstract void yc(long paramLong);
  
  public static abstract interface a
  {
    public abstract void a(i parami, i.c paramc);
  }
  
  public static final class b
  {
    public long hZF;
    public String name;
    private a[] vKa;
    public int vKb;
    
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
        if (paramArrayOfa[0].vKd < paramArrayOfa[0].vKc) {
          break label157;
        }
        bool1 = true;
        label65:
        Assert.assertTrue(bool1);
        if (paramArrayOfa[1].vKd < paramArrayOfa[1].vKc) {
          break label163;
        }
        bool1 = true;
        label89:
        Assert.assertTrue(bool1);
        if (paramArrayOfa[1].vKc < paramArrayOfa[0].vKd) {
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
        this.vKa = paramArrayOfa;
        this.vKb = paramInt;
        this.hZF = paramArrayOfa[0].vKc;
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
      locala1.vKc = paramLong1;
      locala1.vKd = paramLong2;
      a locala2 = new a((byte)0);
      locala2.vKc = paramLong3;
      locala2.vKd = paramLong4;
      AppMethodBeat.o(43079);
      return new a[] { locala1, locala2 };
    }
    
    public final void JO(int paramInt)
    {
      AppMethodBeat.i(43077);
      ad.i("MicroMsg.MsgTable", "summermsg setMsgLocalId [%d, %d]  regions[%d, %d] stack[%s]", new Object[] { Long.valueOf(this.hZF), Integer.valueOf(paramInt), Long.valueOf(this.vKa[0].vKd), Long.valueOf(this.vKa[1].vKc), bt.flS() });
      if ((paramInt > this.vKa[0].vKd) && (paramInt < this.vKa[1].vKc))
      {
        ad.i("MicroMsg.MsgTable", "summermsg setMsgLocalId revised msgLocalId to %d", new Object[] { Long.valueOf(this.vKa[1].vKc) });
        this.hZF = this.vKa[1].vKc;
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(111L, 169L, 1L, false);
        AppMethodBeat.o(43077);
        return;
      }
      this.hZF = paramInt;
      AppMethodBeat.o(43077);
    }
    
    /* Error */
    public final void av(bu parambu)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 112
      //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 52	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:vKa	[Lcom/tencent/mm/plugin/messenger/foundation/a/a/i$b$a;
      //   11: iconst_0
      //   12: aaload
      //   13: astore_2
      //   14: aload_0
      //   15: getfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:hZF	J
      //   18: aload_2
      //   19: getfield 47	com/tencent/mm/plugin/messenger/foundation/a/a/i$b$a:vKd	J
      //   22: lcmp
      //   23: ifne +73 -> 96
      //   26: aload_0
      //   27: aload_0
      //   28: getfield 52	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:vKa	[Lcom/tencent/mm/plugin/messenger/foundation/a/a/i$b$a;
      //   31: iconst_1
      //   32: aaload
      //   33: getfield 50	com/tencent/mm/plugin/messenger/foundation/a/a/i$b$a:vKc	J
      //   36: putfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:hZF	J
      //   39: getstatic 101	com/tencent/mm/plugin/report/e:ygI	Lcom/tencent/mm/plugin/report/e;
      //   42: ldc2_w 102
      //   45: ldc2_w 113
      //   48: lconst_1
      //   49: iconst_0
      //   50: invokevirtual 109	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
      //   53: invokestatic 120	com/tencent/mm/sdk/a/b:fjP	()Z
      //   56: ifne +24 -> 80
      //   59: ldc 69
      //   61: ldc 122
      //   63: iconst_1
      //   64: anewarray 4	java/lang/Object
      //   67: dup
      //   68: iconst_0
      //   69: aload_0
      //   70: getfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:hZF	J
      //   73: invokestatic 77	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   76: aastore
      //   77: invokestatic 93	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   80: aload_1
      //   81: aload_0
      //   82: getfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:hZF	J
      //   85: invokevirtual 128	com/tencent/mm/storage/bu:setMsgId	(J)V
      //   88: ldc 112
      //   90: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   93: aload_0
      //   94: monitorexit
      //   95: return
      //   96: aload_0
      //   97: aload_0
      //   98: getfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:hZF	J
      //   101: lconst_1
      //   102: ladd
      //   103: putfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:hZF	J
      //   106: goto -53 -> 53
      //   109: astore_1
      //   110: aload_0
      //   111: monitorexit
      //   112: aload_1
      //   113: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	114	0	this	b
      //   0	114	1	parambu	bu
      //   13	6	2	locala	a
      // Exception table:
      //   from	to	target	type
      //   2	53	109	finally
      //   53	80	109	finally
      //   80	93	109	finally
      //   96	106	109	finally
    }
    
    public final boolean yd(long paramLong)
    {
      a[] arrayOfa = this.vKa;
      int k = arrayOfa.length;
      int i = 0;
      while (i < k)
      {
        a locala = arrayOfa[i];
        if ((paramLong >= locala.vKc) && (paramLong <= locala.vKd)) {}
        for (int j = 1; j != 0; j = 0) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    
    public static final class a
    {
      long vKc;
      long vKd;
    }
  }
  
  public static final class c
  {
    public ArrayList<bu> gNE;
    public long nYO;
    public int scY;
    public String talker;
    public String vKe;
    public int vKf;
    public int vKg;
    public long vKh;
    
    public c(String paramString1, String paramString2, bu parambu)
    {
      this(paramString1, paramString2, parambu, 0);
    }
    
    public c(String paramString1, String paramString2, bu parambu, int paramInt)
    {
      AppMethodBeat.i(43080);
      this.gNE = new ArrayList();
      this.vKf = 0;
      this.vKg = 0;
      this.vKh = 0L;
      this.nYO = -1L;
      this.talker = paramString1;
      this.vKe = paramString2;
      this.scY = paramInt;
      if (parambu != null) {
        l = parambu.field_bizChatId;
      }
      this.nYO = l;
      if (parambu != null) {
        this.gNE.add(parambu);
      }
      AppMethodBeat.o(43080);
    }
    
    public c(String paramString1, String paramString2, bu parambu, int paramInt, byte paramByte)
    {
      this(paramString1, paramString2, parambu, 0);
      this.vKg = paramInt;
    }
    
    public static boolean aw(bu parambu)
    {
      return (parambu != null) && (parambu.field_isSend == 0) && (parambu.field_status == 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.a.i
 * JD-Core Version:    0.7.0.1
 */