package com.tencent.mm.plugin.messenger.foundation.a.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.sdk.e.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bl.a;
import com.tencent.mm.storage.bl.b;
import com.tencent.mm.storage.bl.c;
import com.tencent.mm.storage.bl.d;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public abstract interface h
  extends g
{
  public abstract Cursor B(String paramString, long paramLong1, long paramLong2);
  
  public abstract Cursor C(String paramString, long paramLong1, long paramLong2);
  
  public abstract int D(String paramString, long paramLong1, long paramLong2);
  
  public abstract int E(String paramString, long paramLong1, long paramLong2);
  
  public abstract Cursor F(String paramString, long paramLong1, long paramLong2);
  
  public abstract int G(String paramString, long paramLong1, long paramLong2);
  
  public abstract bl Gu(int paramInt);
  
  public abstract int H(String paramString, long paramLong1, long paramLong2);
  
  public abstract Cursor I(String paramString, long paramLong1, long paramLong2);
  
  public abstract List<bl> J(String paramString, long paramLong1, long paramLong2);
  
  public abstract Cursor X(String paramString1, String paramString2, int paramInt);
  
  public abstract Cursor a(String paramString, long paramLong1, long paramLong2, int paramInt);
  
  public abstract Cursor a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean);
  
  public abstract void a(long paramLong, bl parambl);
  
  public abstract void a(a parama);
  
  public abstract void a(a parama, Looper paramLooper);
  
  public abstract void a(b paramb);
  
  public abstract void a(c paramc);
  
  public abstract void a(com.tencent.mm.storage.e parame);
  
  public abstract void aC(String paramString, long paramLong);
  
  public abstract bl aD(String paramString, long paramLong);
  
  public abstract bl aE(String paramString, long paramLong);
  
  public abstract bl aF(String paramString, long paramLong);
  
  public abstract List<bl> aG(String paramString, long paramLong);
  
  public abstract List<bl> aH(String paramString, long paramLong);
  
  public abstract bl aI(String paramString, long paramLong);
  
  public abstract bl aJ(String paramString, long paramLong);
  
  public abstract boolean aK(String paramString, long paramLong);
  
  public abstract bl aL(String paramString, long paramLong);
  
  public abstract Cursor aM(String paramString, long paramLong);
  
  public abstract long aN(String paramString, long paramLong);
  
  public abstract int aO(String paramString, long paramLong);
  
  public abstract int aP(String paramString, long paramLong);
  
  public abstract int aQ(String paramString, long paramLong);
  
  public abstract int aR(String paramString, long paramLong);
  
  public abstract String aS(String paramString, long paramLong);
  
  public abstract bl aT(String paramString, long paramLong);
  
  public abstract bl aU(String paramString, long paramLong);
  
  public abstract void aa(ArrayList<Long> paramArrayList);
  
  public abstract bl.c agA(String paramString);
  
  public abstract bl.d agB(String paramString);
  
  public abstract bl.a agC(String paramString);
  
  public abstract bl.b agD(String paramString);
  
  public abstract int agE(String paramString);
  
  public abstract int agF(String paramString);
  
  public abstract String agG(String paramString);
  
  public abstract long agH(String paramString);
  
  public abstract long agI(String paramString);
  
  public abstract long agJ(String paramString);
  
  public abstract bl agK(String paramString);
  
  public abstract int agL(String paramString);
  
  public abstract List<bl> agM(String paramString);
  
  public abstract long agN(String paramString);
  
  public abstract Cursor agO(String paramString);
  
  public abstract void agl(String paramString);
  
  public abstract void agm(String paramString);
  
  public abstract void agn(String paramString);
  
  public abstract Cursor ago(String paramString);
  
  public abstract bl agp(String paramString);
  
  public abstract bl agq(String paramString);
  
  public abstract bl agr(String paramString);
  
  public abstract bl ags(String paramString);
  
  public abstract List<bl> agt(String paramString);
  
  public abstract Cursor agu(String paramString);
  
  public abstract void agv(String paramString);
  
  public abstract int agw(String paramString);
  
  public abstract int agx(String paramString);
  
  public abstract Cursor agy(String paramString);
  
  public abstract Cursor agz(String paramString);
  
  public abstract int am(bl parambl);
  
  public abstract List<bl> am(String paramString, int paramInt1, int paramInt2);
  
  public abstract long an(bl parambl);
  
  public abstract Cursor an(String paramString, int paramInt1, int paramInt2);
  
  public abstract void ao(bl parambl);
  
  public abstract int ap(bl parambl);
  
  public abstract void asf();
  
  public abstract Cursor b(String paramString, long paramLong1, long paramLong2, int paramInt);
  
  public abstract void b(long paramLong, bl parambl);
  
  public abstract void b(String paramString1, String paramString2, String[] paramArrayOfString);
  
  public abstract long c(bl parambl, boolean paramBoolean);
  
  public abstract Cursor c(String paramString, long paramLong1, long paramLong2, int paramInt);
  
  public abstract void c(com.tencent.mm.storagebase.h paramh, String paramString);
  
  public abstract void cOQ();
  
  public abstract void cOR();
  
  public abstract void cOS();
  
  public abstract ArrayList<bl> cOT();
  
  public abstract List<bl> cOU();
  
  public abstract Cursor cOV();
  
  public abstract String cOW();
  
  public abstract String cOX();
  
  public abstract int cOY();
  
  public abstract List<bl> cOZ();
  
  public abstract List<bl> dE(String paramString, int paramInt);
  
  public abstract List<bl> dF(String paramString, int paramInt);
  
  public abstract Cursor dG(String paramString, int paramInt);
  
  public abstract Cursor dH(String paramString, int paramInt);
  
  public abstract Cursor dI(String paramString, int paramInt);
  
  public abstract int dJ(String paramString, int paramInt);
  
  public abstract Cursor dK(String paramString, int paramInt);
  
  public abstract Cursor dL(String paramString, int paramInt);
  
  public abstract int dM(String paramString, int paramInt);
  
  public abstract Cursor dN(String paramString, int paramInt);
  
  public abstract bl[] dO(String paramString, int paramInt);
  
  public abstract Cursor dP(String paramString, int paramInt);
  
  public abstract int f(String paramString, long paramLong, int paramInt);
  
  public abstract long g(String paramString, long paramLong, int paramInt);
  
  public abstract List<bl> g(String paramString, long paramLong, boolean paramBoolean);
  
  public abstract com.tencent.mm.storagebase.h getDB();
  
  public abstract long h(String paramString, long paramLong, int paramInt);
  
  public abstract bl hn(String paramString1, String paramString2);
  
  public abstract Cursor ho(String paramString1, String paramString2);
  
  public abstract int hp(String paramString1, String paramString2);
  
  public abstract LinkedList<bl> hq(String paramString1, String paramString2);
  
  public abstract Cursor i(String paramString, long paramLong, int paramInt);
  
  public abstract Cursor m(String paramString, int paramInt, long paramLong);
  
  public abstract Cursor n(String paramString, int paramInt, long paramLong);
  
  public abstract bl rm(long paramLong);
  
  public abstract int rn(long paramLong);
  
  public abstract boolean ro(long paramLong);
  
  public abstract boolean rp(long paramLong);
  
  public abstract void rq(long paramLong);
  
  public abstract int uh(String paramString);
  
  public abstract boolean ui(String paramString);
  
  public static abstract interface a
  {
    public abstract void a(h paramh, h.c paramc);
  }
  
  public static final class b
  {
    public long hgs;
    public String name;
    public int tyA;
    private a[] tyz;
    
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
        if (paramArrayOfa[0].tyC < paramArrayOfa[0].tyB) {
          break label157;
        }
        bool1 = true;
        label65:
        Assert.assertTrue(bool1);
        if (paramArrayOfa[1].tyC < paramArrayOfa[1].tyB) {
          break label163;
        }
        bool1 = true;
        label89:
        Assert.assertTrue(bool1);
        if (paramArrayOfa[1].tyB < paramArrayOfa[0].tyC) {
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
        this.tyz = paramArrayOfa;
        this.tyA = paramInt;
        this.hgs = paramArrayOfa[0].tyB;
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
      locala1.tyB = paramLong1;
      locala1.tyC = paramLong2;
      a locala2 = new a((byte)0);
      locala2.tyB = paramLong3;
      locala2.tyC = paramLong4;
      AppMethodBeat.o(43079);
      return new a[] { locala1, locala2 };
    }
    
    public final void Gv(int paramInt)
    {
      AppMethodBeat.i(43077);
      ad.i("MicroMsg.MsgTable", "summermsg setMsgLocalId [%d, %d]  regions[%d, %d] stack[%s]", new Object[] { Long.valueOf(this.hgs), Integer.valueOf(paramInt), Long.valueOf(this.tyz[0].tyC), Long.valueOf(this.tyz[1].tyB), bt.eGN() });
      if ((paramInt > this.tyz[0].tyC) && (paramInt < this.tyz[1].tyB))
      {
        ad.i("MicroMsg.MsgTable", "summermsg setMsgLocalId revised msgLocalId to %d", new Object[] { Long.valueOf(this.tyz[1].tyB) });
        this.hgs = this.tyz[1].tyB;
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(111L, 169L, 1L, false);
        AppMethodBeat.o(43077);
        return;
      }
      this.hgs = paramInt;
      AppMethodBeat.o(43077);
    }
    
    /* Error */
    public final void aq(bl parambl)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 112
      //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 52	com/tencent/mm/plugin/messenger/foundation/a/a/h$b:tyz	[Lcom/tencent/mm/plugin/messenger/foundation/a/a/h$b$a;
      //   11: iconst_0
      //   12: aaload
      //   13: astore_2
      //   14: aload_0
      //   15: getfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/h$b:hgs	J
      //   18: aload_2
      //   19: getfield 47	com/tencent/mm/plugin/messenger/foundation/a/a/h$b$a:tyC	J
      //   22: lcmp
      //   23: ifne +73 -> 96
      //   26: aload_0
      //   27: aload_0
      //   28: getfield 52	com/tencent/mm/plugin/messenger/foundation/a/a/h$b:tyz	[Lcom/tencent/mm/plugin/messenger/foundation/a/a/h$b$a;
      //   31: iconst_1
      //   32: aaload
      //   33: getfield 50	com/tencent/mm/plugin/messenger/foundation/a/a/h$b$a:tyB	J
      //   36: putfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/h$b:hgs	J
      //   39: getstatic 101	com/tencent/mm/plugin/report/e:vIY	Lcom/tencent/mm/plugin/report/e;
      //   42: ldc2_w 102
      //   45: ldc2_w 113
      //   48: lconst_1
      //   49: iconst_0
      //   50: invokevirtual 109	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
      //   53: invokestatic 120	com/tencent/mm/sdk/a/b:eES	()Z
      //   56: ifne +24 -> 80
      //   59: ldc 69
      //   61: ldc 122
      //   63: iconst_1
      //   64: anewarray 4	java/lang/Object
      //   67: dup
      //   68: iconst_0
      //   69: aload_0
      //   70: getfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/h$b:hgs	J
      //   73: invokestatic 77	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   76: aastore
      //   77: invokestatic 93	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   80: aload_1
      //   81: aload_0
      //   82: getfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/h$b:hgs	J
      //   85: invokevirtual 128	com/tencent/mm/storage/bl:setMsgId	(J)V
      //   88: ldc 112
      //   90: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   93: aload_0
      //   94: monitorexit
      //   95: return
      //   96: aload_0
      //   97: aload_0
      //   98: getfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/h$b:hgs	J
      //   101: lconst_1
      //   102: ladd
      //   103: putfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/h$b:hgs	J
      //   106: goto -53 -> 53
      //   109: astore_1
      //   110: aload_0
      //   111: monitorexit
      //   112: aload_1
      //   113: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	114	0	this	b
      //   0	114	1	parambl	bl
      //   13	6	2	locala	a
      // Exception table:
      //   from	to	target	type
      //   2	53	109	finally
      //   53	80	109	finally
      //   80	93	109	finally
      //   96	106	109	finally
    }
    
    public final boolean rr(long paramLong)
    {
      a[] arrayOfa = this.tyz;
      int k = arrayOfa.length;
      int i = 0;
      while (i < k)
      {
        a locala = arrayOfa[i];
        if ((paramLong >= locala.tyB) && (paramLong <= locala.tyC)) {}
        for (int j = 1; j != 0; j = 0) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    
    public static final class a
    {
      long tyB;
      long tyC;
    }
  }
  
  public static final class c
  {
    public long mUQ;
    public int qzn;
    public String talker;
    public String tyD;
    public ArrayList<bl> tyE;
    public int tyF;
    public int tyG;
    public long tyH;
    
    public c(String paramString1, String paramString2, bl parambl)
    {
      this(paramString1, paramString2, parambl, 0);
    }
    
    public c(String paramString1, String paramString2, bl parambl, int paramInt)
    {
      AppMethodBeat.i(43080);
      this.tyE = new ArrayList();
      this.tyF = 0;
      this.tyG = 0;
      this.tyH = 0L;
      this.mUQ = -1L;
      this.talker = paramString1;
      this.tyD = paramString2;
      this.qzn = paramInt;
      if (parambl != null) {
        l = parambl.field_bizChatId;
      }
      this.mUQ = l;
      if (parambl != null) {
        this.tyE.add(parambl);
      }
      AppMethodBeat.o(43080);
    }
    
    public c(String paramString1, String paramString2, bl parambl, int paramInt, byte paramByte)
    {
      this(paramString1, paramString2, parambl, 0);
      this.tyG = paramInt;
    }
    
    public static boolean ar(bl parambl)
    {
      return (parambl != null) && (parambl.field_isSend == 0) && (parambl.field_status == 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.a.h
 * JD-Core Version:    0.7.0.1
 */