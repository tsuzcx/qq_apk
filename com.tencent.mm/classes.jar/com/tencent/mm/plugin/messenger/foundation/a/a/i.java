package com.tencent.mm.plugin.messenger.foundation.a.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IStorage;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.a;
import com.tencent.mm.storage.ca.b;
import com.tencent.mm.storage.ca.c;
import com.tencent.mm.storage.ca.d;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public abstract interface i
  extends IStorage
{
  public abstract Cursor B(String paramString, long paramLong1, long paramLong2);
  
  public abstract Cursor C(String paramString, long paramLong1, long paramLong2);
  
  public abstract int D(String paramString, long paramLong1, long paramLong2);
  
  public abstract int E(String paramString, long paramLong1, long paramLong2);
  
  public abstract Cursor F(String paramString, long paramLong1, long paramLong2);
  
  public abstract int G(String paramString, long paramLong1, long paramLong2);
  
  public abstract Cursor G(String paramString, int paramInt, long paramLong);
  
  public abstract int H(String paramString, long paramLong1, long paramLong2);
  
  public abstract Cursor H(String paramString, int paramInt, long paramLong);
  
  public abstract ca Hb(long paramLong);
  
  public abstract int Hc(long paramLong);
  
  public abstract boolean Hd(long paramLong);
  
  public abstract boolean He(long paramLong);
  
  public abstract void Hf(long paramLong);
  
  public abstract Cursor I(String paramString, long paramLong1, long paramLong2);
  
  public abstract List<ca> J(String paramString, long paramLong1, long paramLong2);
  
  public abstract int Ku(String paramString);
  
  public abstract boolean Kv(String paramString);
  
  public abstract ca Qo(int paramInt);
  
  public abstract List<ca> Qp(int paramInt);
  
  public abstract Cursor a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean);
  
  public abstract void a(long paramLong, ca paramca);
  
  public abstract void a(a parama);
  
  public abstract void a(a parama, Looper paramLooper);
  
  public abstract void a(b paramb);
  
  public abstract void a(c paramc);
  
  public abstract void a(com.tencent.mm.storage.e parame);
  
  public abstract int aB(ca paramca);
  
  public abstract long aC(ca paramca);
  
  public abstract void aD(ca paramca);
  
  public abstract int aE(ca paramca);
  
  public abstract ca aEA(String paramString);
  
  public abstract List<ca> aEB(String paramString);
  
  public abstract Cursor aEC(String paramString);
  
  public abstract void aED(String paramString);
  
  public abstract int aEE(String paramString);
  
  public abstract int aEF(String paramString);
  
  public abstract Cursor aEG(String paramString);
  
  public abstract Cursor aEH(String paramString);
  
  public abstract ca.c aEI(String paramString);
  
  public abstract ca.d aEJ(String paramString);
  
  public abstract ca.a aEK(String paramString);
  
  public abstract ca.b aEL(String paramString);
  
  public abstract int aEM(String paramString);
  
  public abstract int aEN(String paramString);
  
  public abstract String aEO(String paramString);
  
  public abstract long aEP(String paramString);
  
  public abstract long aEQ(String paramString);
  
  public abstract long aER(String paramString);
  
  public abstract ca aES(String paramString);
  
  public abstract int aET(String paramString);
  
  public abstract List<ca> aEU(String paramString);
  
  public abstract long aEV(String paramString);
  
  public abstract Cursor aEW(String paramString);
  
  public abstract long aEX(String paramString);
  
  public abstract void aEs(String paramString);
  
  public abstract void aEt(String paramString);
  
  public abstract void aEu(String paramString);
  
  public abstract Cursor aEv(String paramString);
  
  public abstract ca aEw(String paramString);
  
  public abstract ca aEx(String paramString);
  
  public abstract ca aEy(String paramString);
  
  public abstract ca aEz(String paramString);
  
  public abstract void aI(String paramString, long paramLong);
  
  public abstract ca aJ(String paramString, long paramLong);
  
  public abstract ca aK(String paramString, long paramLong);
  
  public abstract ca aL(String paramString, long paramLong);
  
  public abstract ca aM(String paramString, long paramLong);
  
  public abstract ca aN(String paramString, long paramLong);
  
  public abstract boolean aO(String paramString, long paramLong);
  
  public abstract ca aP(String paramString, long paramLong);
  
  public abstract Cursor aQ(String paramString, long paramLong);
  
  public abstract long aR(String paramString, long paramLong);
  
  public abstract int aS(String paramString, long paramLong);
  
  public abstract int aT(String paramString, long paramLong);
  
  public abstract int aU(String paramString, long paramLong);
  
  public abstract int aV(String paramString, long paramLong);
  
  public abstract void aVO();
  
  public abstract String aW(String paramString, long paramLong);
  
  public abstract ca aX(String paramString, long paramLong);
  
  public abstract Cursor aY(String paramString, long paramLong);
  
  public abstract ca aZ(String paramString, long paramLong);
  
  public abstract Cursor ae(String paramString1, String paramString2, int paramInt);
  
  public abstract List<ca> as(String paramString, int paramInt1, int paramInt2);
  
  public abstract Cursor at(String paramString, int paramInt1, int paramInt2);
  
  public abstract void ay(ArrayList<Long> paramArrayList);
  
  public abstract Cursor b(String paramString, long paramLong1, long paramLong2, int paramInt);
  
  public abstract void b(long paramLong, ca paramca);
  
  public abstract long c(ca paramca, boolean paramBoolean);
  
  public abstract Cursor c(String paramString, long paramLong1, long paramLong2, int paramInt);
  
  public abstract void c(String paramString1, String paramString2, String[] paramArrayOfString);
  
  public abstract Cursor d(String paramString, long paramLong1, long paramLong2, int paramInt);
  
  public abstract void e(h paramh, String paramString);
  
  public abstract Cursor eA(String paramString, int paramInt);
  
  public abstract Cursor eB(String paramString, int paramInt);
  
  public abstract int eC(String paramString, int paramInt);
  
  public abstract Cursor eD(String paramString, int paramInt);
  
  public abstract Cursor eE(String paramString, int paramInt);
  
  public abstract int eF(String paramString, int paramInt);
  
  public abstract Cursor eG(String paramString, int paramInt);
  
  public abstract ca[] eH(String paramString, int paramInt);
  
  public abstract Cursor eI(String paramString, int paramInt);
  
  public abstract void eiH();
  
  public abstract void eiI();
  
  public abstract void eiJ();
  
  public abstract ArrayList<ca> eiK();
  
  public abstract List<ca> eiL();
  
  public abstract Cursor eiM();
  
  public abstract String eiN();
  
  public abstract String eiO();
  
  public abstract int eiP();
  
  public abstract List<ca> eiQ();
  
  public abstract List<ca> ew(String paramString, int paramInt);
  
  public abstract List<ca> ex(String paramString, int paramInt);
  
  public abstract List<ca> ey(String paramString, int paramInt);
  
  public abstract Cursor ez(String paramString, int paramInt);
  
  public abstract List<ca> f(String paramString, long paramLong, int paramInt);
  
  public abstract List<ca> f(String paramString, long paramLong, boolean paramBoolean);
  
  public abstract List<ca> fw(List<String> paramList);
  
  public abstract List<ca> g(String paramString, long paramLong, int paramInt);
  
  public abstract h getDB();
  
  public abstract int h(String paramString, long paramLong, int paramInt);
  
  public abstract long i(String paramString, long paramLong, int paramInt);
  
  public abstract ca iG(String paramString1, String paramString2);
  
  public abstract Cursor iH(String paramString1, String paramString2);
  
  public abstract int iI(String paramString1, String paramString2);
  
  public abstract LinkedList<ca> iJ(String paramString1, String paramString2);
  
  public abstract long j(String paramString, long paramLong, int paramInt);
  
  public abstract Cursor k(String paramString, long paramLong, int paramInt);
  
  public abstract List<ca> k(String paramString, ArrayList<Long> paramArrayList);
  
  public static abstract interface a
  {
    public abstract void a(i parami, i.c paramc);
  }
  
  public static final class b
  {
    public long iXv;
    public String name;
    private a[] zqj;
    public int zqk;
    
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
        if (paramArrayOfa[0].zqm < paramArrayOfa[0].zql) {
          break label157;
        }
        bool1 = true;
        label65:
        Assert.assertTrue(bool1);
        if (paramArrayOfa[1].zqm < paramArrayOfa[1].zql) {
          break label163;
        }
        bool1 = true;
        label89:
        Assert.assertTrue(bool1);
        if (paramArrayOfa[1].zql < paramArrayOfa[0].zqm) {
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
        this.zqj = paramArrayOfa;
        this.zqk = paramInt;
        this.iXv = paramArrayOfa[0].zql;
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
      locala1.zql = paramLong1;
      locala1.zqm = paramLong2;
      a locala2 = new a((byte)0);
      locala2.zql = paramLong3;
      locala2.zqm = paramLong4;
      AppMethodBeat.o(43079);
      return new a[] { locala1, locala2 };
    }
    
    public final boolean Hg(long paramLong)
    {
      a[] arrayOfa = this.zqj;
      int k = arrayOfa.length;
      int i = 0;
      while (i < k)
      {
        a locala = arrayOfa[i];
        if ((paramLong >= locala.zql) && (paramLong <= locala.zqm)) {}
        for (int j = 1; j != 0; j = 0) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    
    public final void Qq(int paramInt)
    {
      AppMethodBeat.i(43077);
      Log.i("MicroMsg.MsgTable", "summermsg setMsgLocalId [%d, %d]  regions[%d, %d] stack[%s]", new Object[] { Long.valueOf(this.iXv), Integer.valueOf(paramInt), Long.valueOf(this.zqj[0].zqm), Long.valueOf(this.zqj[1].zql), Util.getStack() });
      if ((paramInt > this.zqj[0].zqm) && (paramInt < this.zqj[1].zql))
      {
        Log.i("MicroMsg.MsgTable", "summermsg setMsgLocalId revised msgLocalId to %d", new Object[] { Long.valueOf(this.zqj[1].zql) });
        this.iXv = this.zqj[1].zql;
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(111L, 169L, 1L, false);
        AppMethodBeat.o(43077);
        return;
      }
      this.iXv = paramInt;
      AppMethodBeat.o(43077);
    }
    
    /* Error */
    public final void aF(ca paramca)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 114
      //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 52	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:zqj	[Lcom/tencent/mm/plugin/messenger/foundation/a/a/i$b$a;
      //   11: iconst_0
      //   12: aaload
      //   13: astore_2
      //   14: aload_0
      //   15: getfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:iXv	J
      //   18: aload_2
      //   19: getfield 47	com/tencent/mm/plugin/messenger/foundation/a/a/i$b$a:zqm	J
      //   22: lcmp
      //   23: ifne +73 -> 96
      //   26: aload_0
      //   27: aload_0
      //   28: getfield 52	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:zqj	[Lcom/tencent/mm/plugin/messenger/foundation/a/a/i$b$a;
      //   31: iconst_1
      //   32: aaload
      //   33: getfield 50	com/tencent/mm/plugin/messenger/foundation/a/a/i$b$a:zql	J
      //   36: putfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:iXv	J
      //   39: getstatic 103	com/tencent/mm/plugin/report/e:Cxv	Lcom/tencent/mm/plugin/report/e;
      //   42: ldc2_w 104
      //   45: ldc2_w 115
      //   48: lconst_1
      //   49: iconst_0
      //   50: invokevirtual 111	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
      //   53: invokestatic 122	com/tencent/mm/sdk/crash/CrashReportFactory:isBackupMerge	()Z
      //   56: ifne +24 -> 80
      //   59: ldc 71
      //   61: ldc 124
      //   63: iconst_1
      //   64: anewarray 4	java/lang/Object
      //   67: dup
      //   68: iconst_0
      //   69: aload_0
      //   70: getfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:iXv	J
      //   73: invokestatic 79	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   76: aastore
      //   77: invokestatic 95	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   80: aload_1
      //   81: aload_0
      //   82: getfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:iXv	J
      //   85: invokevirtual 130	com/tencent/mm/storage/ca:setMsgId	(J)V
      //   88: ldc 114
      //   90: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   93: aload_0
      //   94: monitorexit
      //   95: return
      //   96: aload_0
      //   97: aload_0
      //   98: getfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:iXv	J
      //   101: lconst_1
      //   102: ladd
      //   103: putfield 56	com/tencent/mm/plugin/messenger/foundation/a/a/i$b:iXv	J
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
      long zql;
      long zqm;
    }
  }
  
  public static final class c
  {
    public ArrayList<ca> hIs;
    public long ppv;
    public int tYD;
    public String talker;
    public String zqn;
    public int zqo;
    public int zqp;
    public long zqq;
    
    public c(String paramString1, String paramString2, ca paramca)
    {
      this(paramString1, paramString2, paramca, 0);
    }
    
    public c(String paramString1, String paramString2, ca paramca, int paramInt)
    {
      AppMethodBeat.i(43080);
      this.hIs = new ArrayList();
      this.zqo = 0;
      this.zqp = 0;
      this.zqq = 0L;
      this.ppv = -1L;
      this.talker = paramString1;
      this.zqn = paramString2;
      this.tYD = paramInt;
      if (paramca != null) {
        l = paramca.field_bizChatId;
      }
      this.ppv = l;
      if (paramca != null) {
        this.hIs.add(paramca);
      }
      AppMethodBeat.o(43080);
    }
    
    public c(String paramString1, String paramString2, ca paramca, int paramInt, byte paramByte)
    {
      this(paramString1, paramString2, paramca, 0);
      this.zqp = paramInt;
    }
    
    public static boolean aG(ca paramca)
    {
      return (paramca != null) && (paramca.field_isSend == 0) && (paramca.field_status == 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.a.i
 * JD-Core Version:    0.7.0.1
 */