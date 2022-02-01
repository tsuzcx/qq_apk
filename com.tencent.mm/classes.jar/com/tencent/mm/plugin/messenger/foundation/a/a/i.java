package com.tencent.mm.plugin.messenger.foundation.a.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IStorage;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cc.a;
import com.tencent.mm.storage.cc.c;
import com.tencent.mm.storage.cc.d;
import com.tencent.mm.storage.cc.f;
import com.tencent.mm.storage.e;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public abstract interface i
  extends IStorage
{
  public abstract Cursor F(String paramString, long paramLong1, long paramLong2);
  
  public abstract Cursor G(String paramString, long paramLong1, long paramLong2);
  
  public abstract int H(String paramString, long paramLong1, long paramLong2);
  
  public abstract long Hq(String paramString);
  
  public abstract int I(String paramString, long paramLong1, long paramLong2);
  
  public abstract Cursor I(String paramString, int paramInt, long paramLong);
  
  public abstract Cursor J(String paramString, int paramInt, long paramLong);
  
  public abstract Cursor J(String paramString, long paramLong1, long paramLong2);
  
  public abstract int JL(String paramString);
  
  public abstract boolean JM(String paramString);
  
  public abstract int K(String paramString, long paramLong1, long paramLong2);
  
  public abstract int L(String paramString, long paramLong1, long paramLong2);
  
  public abstract Cursor M(String paramString, long paramLong1, long paramLong2);
  
  public abstract List<cc> N(String paramString, long paramLong1, long paramLong2);
  
  public abstract Cursor a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean);
  
  public abstract void a(long paramLong, cc paramcc);
  
  public abstract void a(a parama);
  
  public abstract void a(a parama, Looper paramLooper);
  
  public abstract void a(b paramb);
  
  public abstract void a(c paramc);
  
  public abstract void a(e parame);
  
  public abstract List<cc> aB(String paramString, int paramInt1, int paramInt2);
  
  public abstract Cursor aC(String paramString, int paramInt1, int paramInt2);
  
  public abstract void aLB(String paramString);
  
  public abstract void aLC(String paramString);
  
  public abstract void aLD(String paramString);
  
  public abstract Cursor aLE(String paramString);
  
  public abstract cc aLF(String paramString);
  
  public abstract cc aLG(String paramString);
  
  public abstract cc aLH(String paramString);
  
  public abstract cc aLI(String paramString);
  
  public abstract cc aLJ(String paramString);
  
  public abstract List<cc> aLL(String paramString);
  
  public abstract Cursor aLM(String paramString);
  
  public abstract void aLN(String paramString);
  
  public abstract int aLO(String paramString);
  
  public abstract int aLP(String paramString);
  
  public abstract Cursor aLQ(String paramString);
  
  public abstract Cursor aLR(String paramString);
  
  public abstract cc.d aLS(String paramString);
  
  public abstract cc.f aLT(String paramString);
  
  public abstract cc.a aLU(String paramString);
  
  public abstract cc.c aLV(String paramString);
  
  public abstract int aLW(String paramString);
  
  public abstract int aLX(String paramString);
  
  public abstract String aLY(String paramString);
  
  public abstract long aLZ(String paramString);
  
  public abstract long aMa(String paramString);
  
  public abstract cc aMb(String paramString);
  
  public abstract int aMc(String paramString);
  
  public abstract List<cc> aMd(String paramString);
  
  public abstract long aMe(String paramString);
  
  public abstract Cursor aMf(String paramString);
  
  public abstract long aMg(String paramString);
  
  public abstract void aT(String paramString, long paramLong);
  
  public abstract cc aU(String paramString, long paramLong);
  
  public abstract cc aV(String paramString, long paramLong);
  
  public abstract cc aW(String paramString, long paramLong);
  
  public abstract cc aX(String paramString, long paramLong);
  
  public abstract cc aY(String paramString, long paramLong);
  
  public abstract void aY(ArrayList<Long> paramArrayList);
  
  public abstract int aZ(cc paramcc);
  
  public abstract boolean aZ(String paramString, long paramLong);
  
  public abstract cc aaD(int paramInt);
  
  public abstract List<cc> aaE(int paramInt);
  
  public abstract Cursor ar(String paramString1, String paramString2, int paramInt);
  
  public abstract Cursor b(String paramString, long paramLong1, long paramLong2, int paramInt);
  
  public abstract void b(long paramLong, cc paramcc);
  
  public abstract void bCI();
  
  public abstract long ba(cc paramcc);
  
  public abstract cc ba(String paramString, long paramLong);
  
  public abstract Cursor bb(String paramString, long paramLong);
  
  public abstract void bb(cc paramcc);
  
  public abstract int bc(cc paramcc);
  
  public abstract long bc(String paramString, long paramLong);
  
  public abstract int bd(String paramString, long paramLong);
  
  public abstract int be(String paramString, long paramLong);
  
  public abstract int bf(String paramString, long paramLong);
  
  public abstract int bg(String paramString, long paramLong);
  
  public abstract String bh(String paramString, long paramLong);
  
  public abstract Cursor bi(String paramString, long paramLong);
  
  public abstract cc bj(String paramString, long paramLong);
  
  public abstract cc bk(String paramString, long paramLong);
  
  public abstract long c(cc paramcc, boolean paramBoolean);
  
  public abstract Cursor c(String paramString, long paramLong1, long paramLong2, int paramInt);
  
  public abstract Cursor d(String paramString, long paramLong1, long paramLong2, int paramInt);
  
  public abstract void d(String paramString1, String paramString2, String[] paramArrayOfString);
  
  public abstract List<cc> e(String paramString, long paramLong, boolean paramBoolean);
  
  public abstract void e(h paramh, String paramString);
  
  public abstract List<cc> fQ(String paramString, int paramInt);
  
  public abstract List<cc> fR(String paramString, int paramInt);
  
  public abstract List<cc> fS(String paramString, int paramInt);
  
  public abstract Cursor fT(String paramString, int paramInt);
  
  public abstract Cursor fU(String paramString, int paramInt);
  
  public abstract Cursor fV(String paramString, int paramInt);
  
  public abstract int fW(String paramString, int paramInt);
  
  public abstract Cursor fX(String paramString, int paramInt);
  
  public abstract Cursor fY(String paramString, int paramInt);
  
  public abstract int fZ(String paramString, int paramInt);
  
  public abstract Cursor ga(String paramString, int paramInt);
  
  public abstract cc[] gb(String paramString, int paramInt);
  
  public abstract void gbi();
  
  public abstract void gbj();
  
  public abstract void gbk();
  
  public abstract ArrayList<cc> gbl();
  
  public abstract List<cc> gbm();
  
  public abstract Cursor gbn();
  
  public abstract String gbo();
  
  public abstract String gbp();
  
  public abstract int gbq();
  
  public abstract List<cc> gbr();
  
  public abstract Cursor gc(String paramString, int paramInt);
  
  public abstract h getDB();
  
  public abstract List<cc> i(String paramString, long paramLong, int paramInt);
  
  public abstract List<cc> iV(List<String> paramList);
  
  public abstract List<cc> j(String paramString, long paramLong, int paramInt);
  
  public abstract int k(String paramString, long paramLong, int paramInt);
  
  public abstract List<cc> ka(String paramString, int paramInt);
  
  public abstract cc kf(String paramString1, String paramString2);
  
  public abstract Cursor kg(String paramString1, String paramString2);
  
  public abstract int kh(String paramString1, String paramString2);
  
  public abstract LinkedList<cc> ki(String paramString1, String paramString2);
  
  public abstract long l(String paramString, long paramLong, int paramInt);
  
  public abstract long m(String paramString, long paramLong, int paramInt);
  
  public abstract Cursor n(String paramString, long paramLong, int paramInt);
  
  public abstract List<cc> n(String paramString, ArrayList<Long> paramArrayList);
  
  public abstract cc sl(long paramLong);
  
  public abstract int sm(long paramLong);
  
  public abstract boolean sn(long paramLong);
  
  public abstract boolean so(long paramLong);
  
  public abstract void sp(long paramLong);
  
  public static abstract interface a
  {
    public abstract void onNotifyChange(i parami, i.c paramc);
  }
  
  public static final class b
  {
    private a[] KRi;
    public int KRj;
    public String name;
    public long oGz;
    
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
        if (paramArrayOfa[0].KRl < paramArrayOfa[0].KRk) {
          break label157;
        }
        bool1 = true;
        label65:
        Assert.assertTrue(bool1);
        if (paramArrayOfa[1].KRl < paramArrayOfa[1].KRk) {
          break label163;
        }
        bool1 = true;
        label89:
        Assert.assertTrue(bool1);
        if (paramArrayOfa[1].KRk < paramArrayOfa[0].KRl) {
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
        this.KRi = paramArrayOfa;
        this.KRj = paramInt;
        this.oGz = paramArrayOfa[0].KRk;
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
    
    public static a[] d(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
    {
      AppMethodBeat.i(43079);
      a locala1 = new a((byte)0);
      locala1.KRk = paramLong1;
      locala1.KRl = paramLong2;
      a locala2 = new a((byte)0);
      locala2.KRk = paramLong3;
      locala2.KRl = paramLong4;
      AppMethodBeat.o(43079);
      return new a[] { locala1, locala2 };
    }
    
    public final void aaF(int paramInt)
    {
      AppMethodBeat.i(43077);
      Log.i("MicroMsg.MsgTable", "summermsg setMsgLocalId [%d, %d]  regions[%d, %d] stack[%s]", new Object[] { Long.valueOf(this.oGz), Integer.valueOf(paramInt), Long.valueOf(this.KRi[0].KRl), Long.valueOf(this.KRi[1].KRk), Util.getStack() });
      if ((paramInt > this.KRi[0].KRl) && (paramInt < this.KRi[1].KRk))
      {
        Log.i("MicroMsg.MsgTable", "summermsg setMsgLocalId revised msgLocalId to %d", new Object[] { Long.valueOf(this.KRi[1].KRk) });
        this.oGz = this.KRi[1].KRk;
        f.Ozc.idkeyStat(111L, 169L, 1L, false);
        AppMethodBeat.o(43077);
        return;
      }
      this.oGz = paramInt;
      AppMethodBeat.o(43077);
    }
    
    /* Error */
    public final void bd(cc paramcc)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 113
      //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 52	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:KRi	[Lcom/tencent/mm/plugin/messenger/foundation/a/a/i$b$a;
      //   11: iconst_0
      //   12: aaload
      //   13: astore_2
      //   14: aload_0
      //   15: getfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:oGz	J
      //   18: aload_2
      //   19: getfield 47	com/tencent/mm/plugin/messenger/foundation/a/a/i$b$a:KRl	J
      //   22: lcmp
      //   23: ifne +73 -> 96
      //   26: aload_0
      //   27: aload_0
      //   28: getfield 52	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:KRi	[Lcom/tencent/mm/plugin/messenger/foundation/a/a/i$b$a;
      //   31: iconst_1
      //   32: aaload
      //   33: getfield 50	com/tencent/mm/plugin/messenger/foundation/a/a/i$b$a:KRk	J
      //   36: putfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:oGz	J
      //   39: getstatic 102	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
      //   42: ldc2_w 103
      //   45: ldc2_w 114
      //   48: lconst_1
      //   49: iconst_0
      //   50: invokevirtual 110	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
      //   53: invokestatic 121	com/tencent/mm/sdk/crash/CrashReportFactory:isBackupMerge	()Z
      //   56: ifne +24 -> 80
      //   59: ldc 70
      //   61: ldc 123
      //   63: iconst_1
      //   64: anewarray 4	java/lang/Object
      //   67: dup
      //   68: iconst_0
      //   69: aload_0
      //   70: getfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:oGz	J
      //   73: invokestatic 78	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   76: aastore
      //   77: invokestatic 94	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   80: aload_1
      //   81: aload_0
      //   82: getfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:oGz	J
      //   85: invokevirtual 129	com/tencent/mm/storage/cc:setMsgId	(J)V
      //   88: ldc 113
      //   90: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   93: aload_0
      //   94: monitorexit
      //   95: return
      //   96: aload_0
      //   97: aload_0
      //   98: getfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:oGz	J
      //   101: lconst_1
      //   102: ladd
      //   103: putfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:oGz	J
      //   106: goto -53 -> 53
      //   109: astore_1
      //   110: aload_0
      //   111: monitorexit
      //   112: aload_1
      //   113: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	114	0	this	b
      //   0	114	1	paramcc	cc
      //   13	6	2	locala	a
      // Exception table:
      //   from	to	target	type
      //   2	53	109	finally
      //   53	80	109	finally
      //   80	93	109	finally
      //   96	106	109	finally
    }
    
    public final boolean sq(long paramLong)
    {
      a[] arrayOfa = this.KRi;
      int k = arrayOfa.length;
      int i = 0;
      while (i < k)
      {
        a locala = arrayOfa[i];
        if ((paramLong >= locala.KRk) && (paramLong <= locala.KRl)) {}
        for (int j = 1; j != 0; j = 0) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    
    public static final class a
    {
      long KRk;
      long KRl;
    }
  }
  
  public static class c
  {
    public String KRm;
    public int KRn;
    public int KRo;
    public long KRp;
    public int apS;
    public ArrayList<cc> mZo;
    public String talker;
    public long vEb;
    
    public c(String paramString1, String paramString2, cc paramcc)
    {
      this(paramString1, paramString2, paramcc, 0);
    }
    
    public c(String paramString1, String paramString2, cc paramcc, int paramInt)
    {
      AppMethodBeat.i(43080);
      this.mZo = new ArrayList();
      this.KRn = 0;
      this.KRo = 0;
      this.KRp = 0L;
      this.vEb = -1L;
      this.talker = paramString1;
      this.KRm = paramString2;
      this.apS = paramInt;
      if (paramcc != null) {
        l = paramcc.field_bizChatId;
      }
      this.vEb = l;
      if (paramcc != null) {
        this.mZo.add(paramcc);
      }
      AppMethodBeat.o(43080);
    }
    
    public c(String paramString1, String paramString2, cc paramcc, int paramInt, byte paramByte)
    {
      this(paramString1, paramString2, paramcc, 0);
      this.KRo = paramInt;
    }
    
    public static boolean be(cc paramcc)
    {
      return (paramcc != null) && (paramcc.field_isSend == 0) && (paramcc.field_status == 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.a.i
 * JD-Core Version:    0.7.0.1
 */