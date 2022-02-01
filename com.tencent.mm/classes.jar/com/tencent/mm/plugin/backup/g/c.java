package com.tencent.mm.plugin.backup.g;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.plugin.backup.f.j;
import com.tencent.mm.plugin.backup.i.x;
import com.tencent.mm.plugin.backup.i.y;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.protocal.protobuf.ii;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.io.InputStream;
import java.util.HashSet;
import java.util.LinkedList;

public final class c
  extends b
{
  private static String TAG = "MicroMsg.BackupDataPushScene";
  private i jxB;
  private PByteArray rRj;
  public x rRw;
  private y rRx;
  private int rRy;
  private a rRz;
  
  private c(final b paramb, String paramString, a parama, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21708);
    this.rRw = new x();
    this.rRx = new y();
    this.rRy = 0;
    this.rRj = new PByteArray();
    this.rRz = null;
    this.rRw.rWy = paramString;
    this.rRw.rWz = 2;
    this.jxB = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(21700);
        paramAnonymousString = (c)paramAnonymousq;
        paramb.g(c.a.a(c.b(paramAnonymousString), paramAnonymousString), paramAnonymousString.rRw.rWy, paramAnonymousString.ctT());
        AppMethodBeat.o(21700);
      }
    };
    this.rRz = parama;
    a.b(parama, this);
    paramb = this.rRz;
    if (paramb.lAW <= 0)
    {
      paramb = new Pair(Integer.valueOf(0), new byte[0]);
      if ((paramb.second == null) || (paramb.first == null))
      {
        Log.w(TAG, "BackupDataPushScene media backFileOp getNext error, file path:%s", new Object[] { this.rRz.filePath });
        this.rRw.rVk = null;
        AppMethodBeat.o(21708);
      }
    }
    else
    {
      long l;
      label192:
      int i;
      if (paramb.lAW - paramb.offset > 524288L)
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
        l = paramb.lAW - paramb.offset;
        break label192;
      }
    }
    parama = (byte[])paramb.second;
    this.rRw.rWA = this.rRz.lAW;
    this.rRw.rWB = ((Integer)paramb.first).intValue();
    this.rRw.rWC = (this.rRw.rWB + parama.length);
    paramb = this.rRw;
    if (this.rRw.rWC == this.rRw.rWA) {}
    for (boolean bool = true;; bool = false)
    {
      paramb.rVk = a(parama, bool, paramArrayOfByte);
      Log.d(TAG, "BackupDataPushScene msgid:%s, size:%d", new Object[] { paramString, Integer.valueOf(this.rRw.rWA) });
      ctS();
      AppMethodBeat.o(21708);
      return;
    }
  }
  
  private c(final b paramb, String paramString, LinkedList<ih> paramLinkedList, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21709);
    this.rRw = new x();
    this.rRx = new y();
    this.rRy = 0;
    this.rRj = new PByteArray();
    this.rRz = null;
    this.rRw.rWy = paramString;
    this.rRw.rWz = 1;
    this.jxB = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(21701);
        paramAnonymousString = (c)paramAnonymousq;
        paramb.g(true, paramAnonymousString.rRw.rWy, paramAnonymousString.ctT());
        AppMethodBeat.o(21701);
      }
    };
    try
    {
      paramb = new ii();
      paramb.rVy = paramLinkedList;
      paramb.rVx = paramLinkedList.size();
      paramb = paramb.toByteArray();
      paramString = paramb;
      if (paramb == null) {
        paramString = new byte[0];
      }
      this.rRw.rWB = 0;
      this.rRw.rWC = paramString.length;
      this.rRw.rWA = paramString.length;
      this.rRw.rVk = a(paramString, true, paramArrayOfByte);
      ctS();
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
      Log.e(paramString, "BackupDataPushScene text, BakChatMsgList to buf error, list size[%d], errMsg:%s", new Object[] { Integer.valueOf(i), paramb.getMessage() });
      paramb = null;
      break;
    }
  }
  
  private static com.tencent.mm.cd.b a(byte[] paramArrayOfByte1, boolean paramBoolean, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(21713);
    if ((Util.getLength(paramArrayOfByte2) > 0) && (Util.getLength(paramArrayOfByte1) > 0))
    {
      paramArrayOfByte1 = new com.tencent.mm.cd.b(AesEcb.aesCryptEcb(paramArrayOfByte1, paramArrayOfByte2, true, paramBoolean));
      AppMethodBeat.o(21713);
      return paramArrayOfByte1;
    }
    paramArrayOfByte1 = new com.tencent.mm.cd.b(paramArrayOfByte1);
    AppMethodBeat.o(21713);
    return paramArrayOfByte1;
  }
  
  public static void a(b paramb, c paramc, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21706);
    paramString2 = new a(paramString2);
    int i;
    if (paramString2.lAW <= 0) {
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
      j = (int)(paramString2.lAW / 524288L);
      i = j;
      if (paramString2.lAW % 524288L != 0L) {
        i = j + 1;
      }
    }
    AppMethodBeat.o(21706);
  }
  
  public static void a(b paramb, c paramc, String paramString, LinkedList<ih> paramLinkedList, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21707);
    paramc.a(new c(paramb, paramString, paramLinkedList, paramArrayOfByte));
    AppMethodBeat.o(21707);
  }
  
  private void ctS()
  {
    AppMethodBeat.i(21711);
    this.rRy = ctO();
    try
    {
      j.a(this.rRw.toByteArray(), this.rRy, (short)getType(), this.rRj, csc());
      a(this.rRy, this.rRj);
      AppMethodBeat.o(21711);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(TAG, localException, "PacketBackupDataPush to buf fail:%s", new Object[] { localException.toString() });
      AppMethodBeat.o(21711);
    }
  }
  
  public final void EN(int paramInt)
  {
    AppMethodBeat.i(21710);
    this.jxB.onSceneEnd(0, this.rRx.rVU, "", this);
    AppMethodBeat.o(21710);
  }
  
  public final a ctC()
  {
    return this.rRx;
  }
  
  public final a ctD()
  {
    return this.rRw;
  }
  
  public final boolean ctM()
  {
    AppMethodBeat.i(21712);
    super.N(this.rRj.value, this.rRy);
    AppMethodBeat.o(21712);
    return true;
  }
  
  public final int ctT()
  {
    if (this.rRj.value == null) {
      return 0;
    }
    return this.rRj.value.length;
  }
  
  public final int getType()
  {
    return 6;
  }
  
  static final class a
  {
    private static String TAG = "MicroMsg.BackupDataPushScene.BackFileOp";
    String filePath;
    int lAW;
    int offset;
    private HashSet<c> rRC;
    private InputStream rRD;
    
    public a(String paramString)
    {
      AppMethodBeat.i(21702);
      this.rRC = new HashSet();
      this.filePath = null;
      this.lAW = 0;
      this.offset = 0;
      this.rRD = null;
      this.filePath = paramString;
      this.lAW = ((int)u.bBQ(this.filePath));
      if (this.lAW < 0) {
        this.lAW = 0;
      }
      AppMethodBeat.o(21702);
    }
    
    final boolean b(byte[] paramArrayOfByte, boolean paramBoolean)
    {
      AppMethodBeat.i(21703);
      try
      {
        if (this.rRD == null) {
          this.rRD = u.Tf(this.filePath);
        }
        int i = this.rRD.read(paramArrayOfByte);
        int j = paramArrayOfByte.length;
        if (i != j)
        {
          AppMethodBeat.o(21703);
          return false;
        }
        if (paramBoolean) {
          this.rRD.close();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.c
 * JD-Core Version:    0.7.0.1
 */