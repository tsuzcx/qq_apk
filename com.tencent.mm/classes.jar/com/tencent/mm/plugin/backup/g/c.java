package com.tencent.mm.plugin.backup.g;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.plugin.backup.f.j;
import com.tencent.mm.plugin.backup.i.x;
import com.tencent.mm.plugin.backup.i.y;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.hy;
import com.tencent.mm.protocal.protobuf.hz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.io.InputStream;
import java.util.HashSet;
import java.util.LinkedList;

public final class c
  extends b
{
  private static String TAG = "MicroMsg.BackupDataPushScene";
  private g hwV;
  public x mYK;
  private y mYL;
  private int mYM;
  private a mYN;
  private PByteArray mYx;
  
  private c(final b paramb, String paramString, a parama, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21708);
    this.mYK = new x();
    this.mYL = new y();
    this.mYM = 0;
    this.mYx = new PByteArray();
    this.mYN = null;
    this.mYK.ndM = paramString;
    this.mYK.ndN = 2;
    this.hwV = new g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21700);
        paramAnonymousString = (c)paramAnonymousn;
        paramb.g(c.a.a(c.b(paramAnonymousString), paramAnonymousString), paramAnonymousString.mYK.ndM, paramAnonymousString.bEH());
        AppMethodBeat.o(21700);
      }
    };
    this.mYN = parama;
    a.b(parama, this);
    paramb = this.mYN;
    if (paramb.hux <= 0)
    {
      paramb = new Pair(Integer.valueOf(0), new byte[0]);
      if ((paramb.second == null) || (paramb.first == null))
      {
        ac.w(TAG, "BackupDataPushScene media backFileOp getNext error, file path:%s", new Object[] { this.mYN.filePath });
        this.mYK.ncy = null;
        AppMethodBeat.o(21708);
      }
    }
    else
    {
      long l;
      label192:
      int i;
      if (paramb.hux - paramb.offset > 524288L)
      {
        l = 524288L;
        i = (int)l;
        parama = new byte[i];
        if (i >= 524288L) {
          break label272;
        }
      }
      label272:
      for (bool = true;; bool = false)
      {
        paramb.b(parama, bool);
        int j = paramb.offset;
        paramb.offset += i;
        paramb = new Pair(Integer.valueOf(j), parama);
        break;
        l = paramb.hux - paramb.offset;
        break label192;
      }
    }
    parama = (byte[])paramb.second;
    this.mYK.ndO = this.mYN.hux;
    this.mYK.ndP = ((Integer)paramb.first).intValue();
    this.mYK.ndQ = (this.mYK.ndP + parama.length);
    paramb = this.mYK;
    if (this.mYK.ndQ == this.mYK.ndO) {}
    for (boolean bool = true;; bool = false)
    {
      paramb.ncy = a(parama, bool, paramArrayOfByte);
      ac.d(TAG, "BackupDataPushScene msgid:%s, size:%d", new Object[] { paramString, Integer.valueOf(this.mYK.ndO) });
      bEG();
      AppMethodBeat.o(21708);
      return;
    }
  }
  
  private c(final b paramb, String paramString, LinkedList<hy> paramLinkedList, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21709);
    this.mYK = new x();
    this.mYL = new y();
    this.mYM = 0;
    this.mYx = new PByteArray();
    this.mYN = null;
    this.mYK.ndM = paramString;
    this.mYK.ndN = 1;
    this.hwV = new g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21701);
        paramAnonymousString = (c)paramAnonymousn;
        paramb.g(true, paramAnonymousString.mYK.ndM, paramAnonymousString.bEH());
        AppMethodBeat.o(21701);
      }
    };
    try
    {
      paramb = new hz();
      paramb.ncM = paramLinkedList;
      paramb.ncL = paramLinkedList.size();
      paramb = paramb.toByteArray();
      paramString = paramb;
      if (paramb == null) {
        paramString = new byte[0];
      }
      this.mYK.ndP = 0;
      this.mYK.ndQ = paramString.length;
      this.mYK.ndO = paramString.length;
      this.mYK.ncy = a(paramString, true, paramArrayOfByte);
      bEG();
      AppMethodBeat.o(21709);
      return;
    }
    catch (Exception paramb)
    {
      paramString = TAG;
      if (paramLinkedList != null) {}
    }
    for (int i = -1;; i = paramLinkedList.size())
    {
      ac.e(paramString, "BackupDataPushScene text, BakChatMsgList to buf error, list size[%d], errMsg:%s", new Object[] { Integer.valueOf(i), paramb.getMessage() });
      paramb = null;
      break;
    }
  }
  
  private static com.tencent.mm.bw.b a(byte[] paramArrayOfByte1, boolean paramBoolean, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(21713);
    if ((bs.cw(paramArrayOfByte2) > 0) && (bs.cw(paramArrayOfByte1) > 0))
    {
      paramArrayOfByte1 = new com.tencent.mm.bw.b(AesEcb.aesCryptEcb(paramArrayOfByte1, paramArrayOfByte2, true, paramBoolean));
      AppMethodBeat.o(21713);
      return paramArrayOfByte1;
    }
    paramArrayOfByte1 = new com.tencent.mm.bw.b(paramArrayOfByte1);
    AppMethodBeat.o(21713);
    return paramArrayOfByte1;
  }
  
  public static void a(b paramb, c paramc, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21706);
    paramString2 = new a(paramString2);
    int i;
    if (paramString2.hux <= 0) {
      i = 1;
    }
    for (;;)
    {
      int j = 0;
      while (j < i)
      {
        paramc.a(new c(paramb, paramString1, paramString2, paramArrayOfByte));
        j += 1;
      }
      j = (int)(paramString2.hux / 524288L);
      i = j;
      if (paramString2.hux % 524288L != 0L) {
        i = j + 1;
      }
    }
    AppMethodBeat.o(21706);
  }
  
  public static void a(b paramb, c paramc, String paramString, LinkedList<hy> paramLinkedList, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21707);
    paramc.a(new c(paramb, paramString, paramLinkedList, paramArrayOfByte));
    AppMethodBeat.o(21707);
  }
  
  private void bEG()
  {
    AppMethodBeat.i(21711);
    this.mYM = bEC();
    try
    {
      j.a(this.mYK.toByteArray(), this.mYM, (short)getType(), this.mYx, b.mSg);
      a(this.mYM, this.mYx);
      AppMethodBeat.o(21711);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace(TAG, localException, "PacketBackupDataPush to buf fail:%s", new Object[] { localException.toString() });
      AppMethodBeat.o(21711);
    }
  }
  
  public final boolean bEA()
  {
    AppMethodBeat.i(21712);
    byte[] arrayOfByte = this.mYx.value;
    int i = this.mYM;
    if (b.mYB != null) {
      ac.i("MicroMsg.BackupBaseScene", "doSceneSameThread ret[%d], sendSeq[%d], type[%d], buflen[%d]", new Object[] { Integer.valueOf(b.mYB.m(i, arrayOfByte)), Integer.valueOf(i), Integer.valueOf(getType()), Integer.valueOf(arrayOfByte.length) });
    }
    AppMethodBeat.o(21712);
    return true;
  }
  
  public final int bEH()
  {
    if (this.mYx.value == null) {
      return 0;
    }
    return this.mYx.value.length;
  }
  
  public final a bEq()
  {
    return this.mYL;
  }
  
  public final a bEr()
  {
    return this.mYK;
  }
  
  public final int getType()
  {
    return 6;
  }
  
  public final void wW(int paramInt)
  {
    AppMethodBeat.i(21710);
    this.hwV.onSceneEnd(0, this.mYL.ndj, "", this);
    AppMethodBeat.o(21710);
  }
  
  static final class a
  {
    private static String TAG = "MicroMsg.BackupDataPushScene.BackFileOp";
    String filePath;
    int hux;
    private HashSet<c> mYQ;
    private InputStream mYR;
    int offset;
    
    public a(String paramString)
    {
      AppMethodBeat.i(21702);
      this.mYQ = new HashSet();
      this.filePath = null;
      this.hux = 0;
      this.offset = 0;
      this.mYR = null;
      this.filePath = paramString;
      this.hux = ((int)i.aSp(this.filePath));
      if (this.hux < 0) {
        this.hux = 0;
      }
      AppMethodBeat.o(21702);
    }
    
    final boolean b(byte[] paramArrayOfByte, boolean paramBoolean)
    {
      AppMethodBeat.i(21703);
      try
      {
        if (this.mYR == null) {
          this.mYR = i.openRead(this.filePath);
        }
        int i = this.mYR.read(paramArrayOfByte);
        int j = paramArrayOfByte.length;
        if (i != j)
        {
          AppMethodBeat.o(21703);
          return false;
        }
        if (paramBoolean) {
          this.mYR.close();
        }
        AppMethodBeat.o(21703);
        return true;
      }
      catch (Exception paramArrayOfByte)
      {
        AppMethodBeat.o(21703);
      }
      return false;
    }
  }
  
  public static abstract interface b
  {
    public abstract void g(boolean paramBoolean, String paramString, int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void a(c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.c
 * JD-Core Version:    0.7.0.1
 */