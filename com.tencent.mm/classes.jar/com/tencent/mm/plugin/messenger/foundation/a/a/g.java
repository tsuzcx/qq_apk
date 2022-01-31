package com.tencent.mm.plugin.messenger.foundation.a.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.cf.h;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.storage.bi.b;
import com.tencent.mm.storage.bi.c;
import com.tencent.mm.storage.bi.d;
import com.tencent.mm.storage.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public abstract interface g
  extends f
{
  public abstract Cursor E(String paramString1, String paramString2, int paramInt);
  
  public abstract void H(ArrayList<Long> paramArrayList);
  
  public abstract bi HA(String paramString);
  
  public abstract bi HB(String paramString);
  
  public abstract bi HC(String paramString);
  
  public abstract List<bi> HD(String paramString);
  
  public abstract Cursor HE(String paramString);
  
  public abstract void HF(String paramString);
  
  public abstract int HG(String paramString);
  
  public abstract boolean HH(String paramString);
  
  public abstract int HI(String paramString);
  
  public abstract Cursor HJ(String paramString);
  
  public abstract Cursor HK(String paramString);
  
  public abstract bi.c HL(String paramString);
  
  public abstract bi.d HM(String paramString);
  
  public abstract bi.a HN(String paramString);
  
  public abstract bi.b HO(String paramString);
  
  public abstract int HP(String paramString);
  
  public abstract boolean HQ(String paramString);
  
  public abstract int HR(String paramString);
  
  public abstract int HS(String paramString);
  
  public abstract String HT(String paramString);
  
  public abstract long HU(String paramString);
  
  public abstract long HV(String paramString);
  
  public abstract long HW(String paramString);
  
  public abstract bi HX(String paramString);
  
  public abstract int HY(String paramString);
  
  public abstract List<bi> HZ(String paramString);
  
  public abstract void Hv(String paramString);
  
  public abstract void Hw(String paramString);
  
  public abstract void Hx(String paramString);
  
  public abstract Cursor Hy(String paramString);
  
  public abstract bi Hz(String paramString);
  
  public abstract long Ia(String paramString);
  
  public abstract Cursor Ib(String paramString);
  
  public abstract void N(String paramString, long paramLong);
  
  public abstract bi O(String paramString, long paramLong);
  
  public abstract bi P(String paramString, long paramLong);
  
  public abstract bi Q(String paramString, long paramLong);
  
  public abstract List<bi> R(String paramString, long paramLong);
  
  public abstract int S(bi parambi);
  
  public abstract List<bi> S(String paramString, long paramLong);
  
  public abstract long T(bi parambi);
  
  public abstract bi T(String paramString, long paramLong);
  
  public abstract bi U(String paramString, long paramLong);
  
  public abstract void U(bi parambi);
  
  public abstract int V(bi parambi);
  
  public abstract boolean V(String paramString, long paramLong);
  
  public abstract bi W(String paramString, long paramLong);
  
  public abstract List<bi> W(String paramString, int paramInt1, int paramInt2);
  
  public abstract long X(String paramString, long paramLong);
  
  public abstract Cursor X(String paramString, int paramInt1, int paramInt2);
  
  public abstract int Y(String paramString, long paramLong);
  
  public abstract int Z(String paramString, long paramLong);
  
  public abstract Cursor a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean);
  
  public abstract void a(long paramLong, bi parambi);
  
  public abstract void a(h paramh, String paramString);
  
  public abstract void a(a parama);
  
  public abstract void a(a parama, Looper paramLooper);
  
  public abstract void a(b paramb);
  
  public abstract void a(c paramc);
  
  public abstract void a(e parame);
  
  public abstract int aa(String paramString, long paramLong);
  
  public abstract String ab(String paramString, long paramLong);
  
  public abstract bi ac(String paramString, long paramLong);
  
  public abstract bi ad(String paramString, long paramLong);
  
  public abstract long b(bi parambi, boolean paramBoolean);
  
  public abstract Cursor b(String paramString, long paramLong1, long paramLong2, int paramInt);
  
  public abstract void b(long paramLong, bi parambi);
  
  public abstract void b(String paramString1, String paramString2, String[] paramArrayOfString);
  
  public abstract List<bi> bM(String paramString, int paramInt);
  
  public abstract List<bi> bN(String paramString, int paramInt);
  
  public abstract Cursor bO(String paramString, int paramInt);
  
  public abstract Cursor bP(String paramString, int paramInt);
  
  public abstract int bQ(String paramString, int paramInt);
  
  public abstract Cursor bR(String paramString, int paramInt);
  
  public abstract Cursor bS(String paramString, int paramInt);
  
  public abstract int bT(String paramString, int paramInt);
  
  public abstract Cursor bU(String paramString, int paramInt);
  
  public abstract bi[] bV(String paramString, int paramInt);
  
  public abstract Cursor bW(String paramString, int paramInt);
  
  public abstract h bhV();
  
  public abstract void bhW();
  
  public abstract void bhX();
  
  public abstract void bhY();
  
  public abstract ArrayList<bi> bhZ();
  
  public abstract List<bi> bia();
  
  public abstract Cursor bib();
  
  public abstract String bic();
  
  public abstract String bid();
  
  public abstract List<bi> bie();
  
  public abstract Cursor c(String paramString, long paramLong1, long paramLong2, int paramInt);
  
  public abstract int d(String paramString, long paramLong, int paramInt);
  
  public abstract Cursor d(String paramString, long paramLong1, long paramLong2, int paramInt);
  
  public abstract bi dP(String paramString1, String paramString2);
  
  public abstract Cursor dQ(String paramString1, String paramString2);
  
  public abstract int dR(String paramString1, String paramString2);
  
  public abstract LinkedList<bi> dS(String paramString1, String paramString2);
  
  public abstract long e(String paramString, long paramLong, int paramInt);
  
  public abstract long f(String paramString, long paramLong, int paramInt);
  
  public abstract Cursor f(String paramString, int paramInt, long paramLong);
  
  public abstract bi fd(long paramLong);
  
  public abstract int fe(long paramLong);
  
  public abstract boolean ff(long paramLong);
  
  public abstract boolean fg(long paramLong);
  
  public abstract void fh(long paramLong);
  
  public abstract Cursor g(String paramString, int paramInt, long paramLong);
  
  public abstract Cursor g(String paramString, long paramLong, int paramInt);
  
  public abstract List<bi> g(String paramString, long paramLong, boolean paramBoolean);
  
  public abstract Cursor p(String paramString, long paramLong1, long paramLong2);
  
  public abstract int q(String paramString, long paramLong1, long paramLong2);
  
  public abstract int r(String paramString, long paramLong1, long paramLong2);
  
  public abstract Cursor s(String paramString, long paramLong1, long paramLong2);
  
  public abstract int t(String paramString, long paramLong1, long paramLong2);
  
  public abstract bi tE(int paramInt);
  
  public abstract int u(String paramString, long paramLong1, long paramLong2);
  
  public abstract Cursor v(String paramString, long paramLong1, long paramLong2);
  
  public static abstract interface a
  {
    public abstract void a(g paramg, g.c paramc);
  }
  
  public static final class b
  {
    public long enx;
    public a[] mdp;
    public int mdq;
    public String name;
    
    public b(int paramInt, String paramString, a[] paramArrayOfa)
    {
      if (paramString.length() > 0)
      {
        bool1 = true;
        Assert.assertTrue(bool1);
        this.name = paramString;
        if (paramArrayOfa.length != 2) {
          break label141;
        }
        bool1 = true;
        label36:
        Assert.assertTrue(bool1);
        if (paramArrayOfa[0].mds < paramArrayOfa[0].mdr) {
          break label147;
        }
        bool1 = true;
        label60:
        Assert.assertTrue(bool1);
        if (paramArrayOfa[1].mds < paramArrayOfa[1].mdr) {
          break label153;
        }
        bool1 = true;
        label84:
        Assert.assertTrue(bool1);
        if (paramArrayOfa[1].mdr < paramArrayOfa[0].mds) {
          break label159;
        }
      }
      label141:
      label147:
      label153:
      label159:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        Assert.assertTrue(bool1);
        this.mdp = paramArrayOfa;
        this.mdq = paramInt;
        this.enx = paramArrayOfa[0].mdr;
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label36;
        bool1 = false;
        break label60;
        bool1 = false;
        break label84;
      }
    }
    
    public static a[] a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
    {
      a locala1 = new a((byte)0);
      locala1.mdr = paramLong1;
      locala1.mds = paramLong2;
      a locala2 = new a((byte)0);
      locala2.mdr = paramLong3;
      locala2.mds = paramLong4;
      return new a[] { locala1, locala2 };
    }
    
    /* Error */
    public final void bif()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 45	com/tencent/mm/plugin/messenger/foundation/a/a/g$b:mdp	[Lcom/tencent/mm/plugin/messenger/foundation/a/a/g$b$a;
      //   6: iconst_0
      //   7: aaload
      //   8: astore_1
      //   9: aload_0
      //   10: getfield 49	com/tencent/mm/plugin/messenger/foundation/a/a/g$b:enx	J
      //   13: aload_1
      //   14: getfield 40	com/tencent/mm/plugin/messenger/foundation/a/a/g$b$a:mds	J
      //   17: lcmp
      //   18: ifne +60 -> 78
      //   21: aload_0
      //   22: aload_0
      //   23: getfield 45	com/tencent/mm/plugin/messenger/foundation/a/a/g$b:mdp	[Lcom/tencent/mm/plugin/messenger/foundation/a/a/g$b$a;
      //   26: iconst_1
      //   27: aaload
      //   28: getfield 43	com/tencent/mm/plugin/messenger/foundation/a/a/g$b$a:mdr	J
      //   31: putfield 49	com/tencent/mm/plugin/messenger/foundation/a/a/g$b:enx	J
      //   34: getstatic 61	com/tencent/mm/plugin/report/f:nEG	Lcom/tencent/mm/plugin/report/f;
      //   37: ldc2_w 62
      //   40: ldc2_w 64
      //   43: lconst_1
      //   44: iconst_0
      //   45: invokevirtual 68	com/tencent/mm/plugin/report/f:a	(JJJZ)V
      //   48: invokestatic 74	com/tencent/mm/sdk/a/b:cqm	()Z
      //   51: ifne +24 -> 75
      //   54: ldc 76
      //   56: ldc 78
      //   58: iconst_1
      //   59: anewarray 4	java/lang/Object
      //   62: dup
      //   63: iconst_0
      //   64: aload_0
      //   65: getfield 49	com/tencent/mm/plugin/messenger/foundation/a/a/g$b:enx	J
      //   68: invokestatic 84	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   71: aastore
      //   72: invokestatic 90	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   75: aload_0
      //   76: monitorexit
      //   77: return
      //   78: aload_0
      //   79: aload_0
      //   80: getfield 49	com/tencent/mm/plugin/messenger/foundation/a/a/g$b:enx	J
      //   83: lconst_1
      //   84: ladd
      //   85: putfield 49	com/tencent/mm/plugin/messenger/foundation/a/a/g$b:enx	J
      //   88: goto -40 -> 48
      //   91: astore_1
      //   92: aload_0
      //   93: monitorexit
      //   94: aload_1
      //   95: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	96	0	this	b
      //   8	6	1	locala	a
      //   91	4	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	48	91	finally
      //   48	75	91	finally
      //   78	88	91	finally
    }
    
    public final boolean fi(long paramLong)
    {
      a[] arrayOfa = this.mdp;
      int k = arrayOfa.length;
      int i = 0;
      while (i < k)
      {
        a locala = arrayOfa[i];
        if ((paramLong >= locala.mdr) && (paramLong <= locala.mds)) {}
        for (int j = 1; j != 0; j = 0) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    
    private static final class a
    {
      public long mdr;
      public long mds;
    }
  }
  
  public static final class c
  {
    public long idK = -1L;
    public String mdt;
    public ArrayList<bi> mdu = new ArrayList();
    public int mdv;
    public int mdw = 0;
    public int mdx = 0;
    public long mdy = 0L;
    public String talker;
    
    public c(String paramString1, String paramString2, bi parambi)
    {
      this(paramString1, paramString2, parambi, 0);
    }
    
    public c(String paramString1, String paramString2, bi parambi, int paramInt)
    {
      this.talker = paramString1;
      this.mdt = paramString2;
      this.mdv = paramInt;
      if (parambi != null) {
        l = parambi.field_bizChatId;
      }
      this.idK = l;
      if (parambi != null) {
        this.mdu.add(parambi);
      }
    }
    
    public c(String paramString1, String paramString2, bi parambi, int paramInt, byte paramByte)
    {
      this(paramString1, paramString2, parambi, 0);
      this.mdx = paramInt;
    }
    
    public static boolean W(bi parambi)
    {
      return (parambi != null) && (parambi.field_isSend == 0) && (parambi.field_status == 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.a.g
 * JD-Core Version:    0.7.0.1
 */