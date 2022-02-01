package com.tencent.mm.plugin.backup.g;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.plugin.backup.f.j;
import com.tencent.mm.plugin.backup.i.x;
import com.tencent.mm.plugin.backup.i.y;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.protocal.protobuf.hv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.io.InputStream;
import java.util.HashSet;
import java.util.LinkedList;

public final class c
  extends b
{
  private static String TAG = "MicroMsg.BackupDataPushScene";
  private g gWw;
  public x mwJ;
  private y mwK;
  private int mwL;
  private a mwM;
  private PByteArray mww;
  
  private c(final b paramb, String paramString, a parama, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21708);
    this.mwJ = new x();
    this.mwK = new y();
    this.mwL = 0;
    this.mww = new PByteArray();
    this.mwM = null;
    this.mwJ.mBL = paramString;
    this.mwJ.mBM = 2;
    this.gWw = new g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21700);
        paramAnonymousString = (c)paramAnonymousn;
        paramb.g(c.a.a(c.b(paramAnonymousString), paramAnonymousString), paramAnonymousString.mwJ.mBL, paramAnonymousString.bxL());
        AppMethodBeat.o(21700);
      }
    };
    this.mwM = parama;
    a.b(parama, this);
    paramb = this.mwM;
    if (paramb.gTY <= 0)
    {
      paramb = new Pair(Integer.valueOf(0), new byte[0]);
      if ((paramb.second == null) || (paramb.first == null))
      {
        ad.w(TAG, "BackupDataPushScene media backFileOp getNext error, file path:%s", new Object[] { this.mwM.filePath });
        this.mwJ.mAx = null;
        AppMethodBeat.o(21708);
      }
    }
    else
    {
      long l;
      label192:
      int i;
      if (paramb.gTY - paramb.offset > 524288L)
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
        l = paramb.gTY - paramb.offset;
        break label192;
      }
    }
    parama = (byte[])paramb.second;
    this.mwJ.mBN = this.mwM.gTY;
    this.mwJ.mBO = ((Integer)paramb.first).intValue();
    this.mwJ.mBP = (this.mwJ.mBO + parama.length);
    paramb = this.mwJ;
    if (this.mwJ.mBP == this.mwJ.mBN) {}
    for (boolean bool = true;; bool = false)
    {
      paramb.mAx = a(parama, bool, paramArrayOfByte);
      ad.d(TAG, "BackupDataPushScene msgid:%s, size:%d", new Object[] { paramString, Integer.valueOf(this.mwJ.mBN) });
      bxK();
      AppMethodBeat.o(21708);
      return;
    }
  }
  
  private c(final b paramb, String paramString, LinkedList<hu> paramLinkedList, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21709);
    this.mwJ = new x();
    this.mwK = new y();
    this.mwL = 0;
    this.mww = new PByteArray();
    this.mwM = null;
    this.mwJ.mBL = paramString;
    this.mwJ.mBM = 1;
    this.gWw = new g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21701);
        paramAnonymousString = (c)paramAnonymousn;
        paramb.g(true, paramAnonymousString.mwJ.mBL, paramAnonymousString.bxL());
        AppMethodBeat.o(21701);
      }
    };
    try
    {
      paramb = new hv();
      paramb.mAL = paramLinkedList;
      paramb.mAK = paramLinkedList.size();
      paramb = paramb.toByteArray();
      paramString = paramb;
      if (paramb == null) {
        paramString = new byte[0];
      }
      this.mwJ.mBO = 0;
      this.mwJ.mBP = paramString.length;
      this.mwJ.mBN = paramString.length;
      this.mwJ.mAx = a(paramString, true, paramArrayOfByte);
      bxK();
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
      ad.e(paramString, "BackupDataPushScene text, BakChatMsgList to buf error, list size[%d], errMsg:%s", new Object[] { Integer.valueOf(i), paramb.getMessage() });
      paramb = null;
      break;
    }
  }
  
  private static com.tencent.mm.bx.b a(byte[] paramArrayOfByte1, boolean paramBoolean, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(21713);
    if ((bt.cx(paramArrayOfByte2) > 0) && (bt.cx(paramArrayOfByte1) > 0))
    {
      paramArrayOfByte1 = new com.tencent.mm.bx.b(AesEcb.aesCryptEcb(paramArrayOfByte1, paramArrayOfByte2, true, paramBoolean));
      AppMethodBeat.o(21713);
      return paramArrayOfByte1;
    }
    paramArrayOfByte1 = new com.tencent.mm.bx.b(paramArrayOfByte1);
    AppMethodBeat.o(21713);
    return paramArrayOfByte1;
  }
  
  public static void a(b paramb, c paramc, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21706);
    paramString2 = new a(paramString2);
    int i;
    if (paramString2.gTY <= 0) {
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
      j = (int)(paramString2.gTY / 524288L);
      i = j;
      if (paramString2.gTY % 524288L != 0L) {
        i = j + 1;
      }
    }
    AppMethodBeat.o(21706);
  }
  
  public static void a(b paramb, c paramc, String paramString, LinkedList<hu> paramLinkedList, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21707);
    paramc.a(new c(paramb, paramString, paramLinkedList, paramArrayOfByte));
    AppMethodBeat.o(21707);
  }
  
  private void bxK()
  {
    AppMethodBeat.i(21711);
    this.mwL = bxG();
    try
    {
      j.a(this.mwJ.toByteArray(), this.mwL, (short)getType(), this.mww, b.mqf);
      a(this.mwL, this.mww);
      AppMethodBeat.o(21711);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace(TAG, localException, "PacketBackupDataPush to buf fail:%s", new Object[] { localException.toString() });
      AppMethodBeat.o(21711);
    }
  }
  
  public final boolean bxE()
  {
    AppMethodBeat.i(21712);
    byte[] arrayOfByte = this.mww.value;
    int i = this.mwL;
    if (b.mwA != null) {
      ad.i("MicroMsg.BackupBaseScene", "doSceneSameThread ret[%d], sendSeq[%d], type[%d], buflen[%d]", new Object[] { Integer.valueOf(b.mwA.m(i, arrayOfByte)), Integer.valueOf(i), Integer.valueOf(getType()), Integer.valueOf(arrayOfByte.length) });
    }
    AppMethodBeat.o(21712);
    return true;
  }
  
  public final int bxL()
  {
    if (this.mww.value == null) {
      return 0;
    }
    return this.mww.value.length;
  }
  
  public final a bxu()
  {
    return this.mwK;
  }
  
  public final a bxv()
  {
    return this.mwJ;
  }
  
  public final int getType()
  {
    return 6;
  }
  
  public final void wf(int paramInt)
  {
    AppMethodBeat.i(21710);
    this.gWw.onSceneEnd(0, this.mwK.mBi, "", this);
    AppMethodBeat.o(21710);
  }
  
  static final class a
  {
    private static String TAG = "MicroMsg.BackupDataPushScene.BackFileOp";
    String filePath;
    int gTY;
    private HashSet<c> mwP;
    private InputStream mwQ;
    int offset;
    
    public a(String paramString)
    {
      AppMethodBeat.i(21702);
      this.mwP = new HashSet();
      this.filePath = null;
      this.gTY = 0;
      this.offset = 0;
      this.mwQ = null;
      this.filePath = paramString;
      this.gTY = ((int)i.aMN(this.filePath));
      if (this.gTY < 0) {
        this.gTY = 0;
      }
      AppMethodBeat.o(21702);
    }
    
    final boolean b(byte[] paramArrayOfByte, boolean paramBoolean)
    {
      AppMethodBeat.i(21703);
      try
      {
        if (this.mwQ == null) {
          this.mwQ = i.openRead(this.filePath);
        }
        int i = this.mwQ.read(paramArrayOfByte);
        int j = paramArrayOfByte.length;
        if (i != j)
        {
          AppMethodBeat.o(21703);
          return false;
        }
        if (paramBoolean) {
          this.mwQ.close();
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