package com.tencent.mm.plugin.backup.g;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.plugin.backup.f.j;
import com.tencent.mm.plugin.backup.i.x;
import com.tencent.mm.plugin.backup.i.y;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.protocal.protobuf.ig;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.io.InputStream;
import java.util.HashSet;
import java.util.LinkedList;

public final class c
  extends b
{
  private static String TAG = "MicroMsg.BackupDataPushScene";
  private f ghB;
  public x nEC;
  private y nED;
  private int nEE;
  private a nEF;
  private PByteArray nEp;
  
  private c(final b paramb, String paramString, a parama, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21708);
    this.nEC = new x();
    this.nED = new y();
    this.nEE = 0;
    this.nEp = new PByteArray();
    this.nEF = null;
    this.nEC.nJE = paramString;
    this.nEC.nJF = 2;
    this.ghB = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21700);
        paramAnonymousString = (c)paramAnonymousn;
        paramb.g(c.a.a(c.b(paramAnonymousString), paramAnonymousString), paramAnonymousString.nEC.nJE, paramAnonymousString.bJO());
        AppMethodBeat.o(21700);
      }
    };
    this.nEF = parama;
    a.b(parama, this);
    paramb = this.nEF;
    if (paramb.hPI <= 0)
    {
      paramb = new Pair(Integer.valueOf(0), new byte[0]);
      if ((paramb.second == null) || (paramb.first == null))
      {
        ae.w(TAG, "BackupDataPushScene media backFileOp getNext error, file path:%s", new Object[] { this.nEF.filePath });
        this.nEC.nIq = null;
        AppMethodBeat.o(21708);
      }
    }
    else
    {
      long l;
      label192:
      int i;
      if (paramb.hPI - paramb.offset > 524288L)
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
        l = paramb.hPI - paramb.offset;
        break label192;
      }
    }
    parama = (byte[])paramb.second;
    this.nEC.nJG = this.nEF.hPI;
    this.nEC.nJH = ((Integer)paramb.first).intValue();
    this.nEC.nJI = (this.nEC.nJH + parama.length);
    paramb = this.nEC;
    if (this.nEC.nJI == this.nEC.nJG) {}
    for (boolean bool = true;; bool = false)
    {
      paramb.nIq = a(parama, bool, paramArrayOfByte);
      ae.d(TAG, "BackupDataPushScene msgid:%s, size:%d", new Object[] { paramString, Integer.valueOf(this.nEC.nJG) });
      bJN();
      AppMethodBeat.o(21708);
      return;
    }
  }
  
  private c(final b paramb, String paramString, LinkedList<if> paramLinkedList, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21709);
    this.nEC = new x();
    this.nED = new y();
    this.nEE = 0;
    this.nEp = new PByteArray();
    this.nEF = null;
    this.nEC.nJE = paramString;
    this.nEC.nJF = 1;
    this.ghB = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21701);
        paramAnonymousString = (c)paramAnonymousn;
        paramb.g(true, paramAnonymousString.nEC.nJE, paramAnonymousString.bJO());
        AppMethodBeat.o(21701);
      }
    };
    try
    {
      paramb = new ig();
      paramb.nIE = paramLinkedList;
      paramb.nID = paramLinkedList.size();
      paramb = paramb.toByteArray();
      paramString = paramb;
      if (paramb == null) {
        paramString = new byte[0];
      }
      this.nEC.nJH = 0;
      this.nEC.nJI = paramString.length;
      this.nEC.nJG = paramString.length;
      this.nEC.nIq = a(paramString, true, paramArrayOfByte);
      bJN();
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
      ae.e(paramString, "BackupDataPushScene text, BakChatMsgList to buf error, list size[%d], errMsg:%s", new Object[] { Integer.valueOf(i), paramb.getMessage() });
      paramb = null;
      break;
    }
  }
  
  private static com.tencent.mm.bw.b a(byte[] paramArrayOfByte1, boolean paramBoolean, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(21713);
    if ((bu.cG(paramArrayOfByte2) > 0) && (bu.cG(paramArrayOfByte1) > 0))
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
    if (paramString2.hPI <= 0) {
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
      j = (int)(paramString2.hPI / 524288L);
      i = j;
      if (paramString2.hPI % 524288L != 0L) {
        i = j + 1;
      }
    }
    AppMethodBeat.o(21706);
  }
  
  public static void a(b paramb, c paramc, String paramString, LinkedList<if> paramLinkedList, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21707);
    paramc.a(new c(paramb, paramString, paramLinkedList, paramArrayOfByte));
    AppMethodBeat.o(21707);
  }
  
  private void bJN()
  {
    AppMethodBeat.i(21711);
    this.nEE = bJJ();
    try
    {
      j.a(this.nEC.toByteArray(), this.nEE, (short)getType(), this.nEp, b.nya);
      a(this.nEE, this.nEp);
      AppMethodBeat.o(21711);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace(TAG, localException, "PacketBackupDataPush to buf fail:%s", new Object[] { localException.toString() });
      AppMethodBeat.o(21711);
    }
  }
  
  public final boolean bJH()
  {
    AppMethodBeat.i(21712);
    byte[] arrayOfByte = this.nEp.value;
    int i = this.nEE;
    if (b.nEt != null) {
      ae.i("MicroMsg.BackupBaseScene", "doSceneSameThread ret[%d], sendSeq[%d], type[%d], buflen[%d]", new Object[] { Integer.valueOf(b.nEt.m(i, arrayOfByte)), Integer.valueOf(i), Integer.valueOf(getType()), Integer.valueOf(arrayOfByte.length) });
    }
    AppMethodBeat.o(21712);
    return true;
  }
  
  public final int bJO()
  {
    if (this.nEp.value == null) {
      return 0;
    }
    return this.nEp.value.length;
  }
  
  public final a bJx()
  {
    return this.nED;
  }
  
  public final a bJy()
  {
    return this.nEC;
  }
  
  public final int getType()
  {
    return 6;
  }
  
  public final void xG(int paramInt)
  {
    AppMethodBeat.i(21710);
    this.ghB.onSceneEnd(0, this.nED.nJb, "", this);
    AppMethodBeat.o(21710);
  }
  
  static final class a
  {
    private static String TAG = "MicroMsg.BackupDataPushScene.BackFileOp";
    String filePath;
    int hPI;
    private HashSet<c> nEI;
    private InputStream nEJ;
    int offset;
    
    public a(String paramString)
    {
      AppMethodBeat.i(21702);
      this.nEI = new HashSet();
      this.filePath = null;
      this.hPI = 0;
      this.offset = 0;
      this.nEJ = null;
      this.filePath = paramString;
      this.hPI = ((int)o.aZR(this.filePath));
      if (this.hPI < 0) {
        this.hPI = 0;
      }
      AppMethodBeat.o(21702);
    }
    
    final boolean b(byte[] paramArrayOfByte, boolean paramBoolean)
    {
      AppMethodBeat.i(21703);
      try
      {
        if (this.nEJ == null) {
          this.nEJ = o.openRead(this.filePath);
        }
        int i = this.nEJ.read(paramArrayOfByte);
        int j = paramArrayOfByte.length;
        if (i != j)
        {
          AppMethodBeat.o(21703);
          return false;
        }
        if (paramBoolean) {
          this.nEJ.close();
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