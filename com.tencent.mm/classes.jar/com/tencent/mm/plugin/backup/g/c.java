package com.tencent.mm.plugin.backup.g;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.plugin.backup.f.j;
import com.tencent.mm.plugin.backup.i.x;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.protocal.protobuf.je;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.InputStream;
import java.util.HashSet;
import java.util.LinkedList;

public final class c
  extends b
{
  private static String TAG = "MicroMsg.BackupDataPushScene";
  private h maV;
  public x vcM;
  private com.tencent.mm.plugin.backup.i.y vcN;
  private int vcO;
  private a vcP;
  private PByteArray vcz;
  
  private c(final b paramb, String paramString, a parama, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21708);
    this.vcM = new x();
    this.vcN = new com.tencent.mm.plugin.backup.i.y();
    this.vcO = 0;
    this.vcz = new PByteArray();
    this.vcP = null;
    this.vcM.vhN = paramString;
    this.vcM.vhO = 2;
    this.maV = new h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(21700);
        paramAnonymousString = (c)paramAnonymousp;
        paramb.f(c.a.a(c.b(paramAnonymousString), paramAnonymousString), paramAnonymousString.vcM.vhN, paramAnonymousString.cWD());
        AppMethodBeat.o(21700);
      }
    };
    this.vcP = parama;
    a.b(parama, this);
    paramb = this.vcP;
    if (paramb.osy <= 0)
    {
      paramb = new Pair(Integer.valueOf(0), new byte[0]);
      if ((paramb.second == null) || (paramb.first == null))
      {
        Log.w(TAG, "BackupDataPushScene media backFileOp getNext error, file path:%s", new Object[] { this.vcP.filePath });
        this.vcM.vgA = null;
        AppMethodBeat.o(21708);
      }
    }
    else
    {
      long l;
      label192:
      int i;
      if (paramb.osy - paramb.offset > 524288L)
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
        l = paramb.osy - paramb.offset;
        break label192;
      }
    }
    parama = (byte[])paramb.second;
    this.vcM.vhP = this.vcP.osy;
    this.vcM.vhQ = ((Integer)paramb.first).intValue();
    this.vcM.vhR = (this.vcM.vhQ + parama.length);
    paramb = this.vcM;
    if (this.vcM.vhR == this.vcM.vhP) {}
    for (boolean bool = true;; bool = false)
    {
      paramb.vgA = a(parama, bool, paramArrayOfByte);
      Log.d(TAG, "BackupDataPushScene msgid:%s, size:%d", new Object[] { paramString, Integer.valueOf(this.vcM.vhP) });
      cWC();
      AppMethodBeat.o(21708);
      return;
    }
  }
  
  private c(final b paramb, String paramString, LinkedList<jd> paramLinkedList, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21709);
    this.vcM = new x();
    this.vcN = new com.tencent.mm.plugin.backup.i.y();
    this.vcO = 0;
    this.vcz = new PByteArray();
    this.vcP = null;
    this.vcM.vhN = paramString;
    this.vcM.vhO = 1;
    this.maV = new h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(21701);
        paramAnonymousString = (c)paramAnonymousp;
        paramb.f(true, paramAnonymousString.vcM.vhN, paramAnonymousString.cWD());
        AppMethodBeat.o(21701);
      }
    };
    try
    {
      paramb = new je();
      paramb.vgO = paramLinkedList;
      paramb.vgN = paramLinkedList.size();
      paramb = paramb.toByteArray();
      paramString = paramb;
      if (paramb == null) {
        paramString = new byte[0];
      }
      this.vcM.vhQ = 0;
      this.vcM.vhR = paramString.length;
      this.vcM.vhP = paramString.length;
      this.vcM.vgA = a(paramString, true, paramArrayOfByte);
      cWC();
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
  
  private static com.tencent.mm.bx.b a(byte[] paramArrayOfByte1, boolean paramBoolean, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(21713);
    if ((Util.getLength(paramArrayOfByte2) > 0) && (Util.getLength(paramArrayOfByte1) > 0))
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
    if (paramString2.osy <= 0) {
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
      j = (int)(paramString2.osy / 524288L);
      i = j;
      if (paramString2.osy % 524288L != 0L) {
        i = j + 1;
      }
    }
    AppMethodBeat.o(21706);
  }
  
  public static void a(b paramb, c paramc, String paramString, LinkedList<jd> paramLinkedList, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21707);
    paramc.a(new c(paramb, paramString, paramLinkedList, paramArrayOfByte));
    AppMethodBeat.o(21707);
  }
  
  private void cWC()
  {
    AppMethodBeat.i(21711);
    this.vcO = cWy();
    try
    {
      j.a(this.vcM.toByteArray(), this.vcO, (short)getType(), this.vcz, cUM());
      a(this.vcO, this.vcz);
      AppMethodBeat.o(21711);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(TAG, localException, "PacketBackupDataPush to buf fail:%s", new Object[] { localException.toString() });
      AppMethodBeat.o(21711);
    }
  }
  
  public final void Fo(int paramInt)
  {
    AppMethodBeat.i(21710);
    this.maV.onSceneEnd(0, this.vcN.vhk, "", this);
    AppMethodBeat.o(21710);
  }
  
  public final int cWD()
  {
    if (this.vcz.value == null) {
      return 0;
    }
    return this.vcz.value.length;
  }
  
  public final a cWm()
  {
    return this.vcN;
  }
  
  public final a cWn()
  {
    return this.vcM;
  }
  
  public final boolean cWw()
  {
    AppMethodBeat.i(21712);
    boolean bool = super.M(this.vcz.value, this.vcO);
    if (!bool) {
      this.maV.onSceneEnd(1, -2, "doScene failed", this);
    }
    AppMethodBeat.o(21712);
    return bool;
  }
  
  public final int getType()
  {
    return 6;
  }
  
  static final class a
  {
    private static String TAG = "MicroMsg.BackupDataPushScene.BackFileOp";
    String filePath;
    int offset;
    int osy;
    private HashSet<c> vcS;
    private InputStream vcT;
    
    public a(String paramString)
    {
      AppMethodBeat.i(21702);
      this.vcS = new HashSet();
      this.filePath = null;
      this.osy = 0;
      this.offset = 0;
      this.vcT = null;
      this.filePath = paramString;
      this.osy = ((int)com.tencent.mm.vfs.y.bEl(this.filePath));
      if (this.osy < 0) {
        this.osy = 0;
      }
      AppMethodBeat.o(21702);
    }
    
    final boolean b(byte[] paramArrayOfByte, boolean paramBoolean)
    {
      AppMethodBeat.i(21703);
      try
      {
        if (this.vcT == null) {
          this.vcT = com.tencent.mm.vfs.y.Lh(this.filePath);
        }
        int i = this.vcT.read(paramArrayOfByte);
        int j = paramArrayOfByte.length;
        if (i != j)
        {
          AppMethodBeat.o(21703);
          return false;
        }
        if (paramBoolean) {
          this.vcT.close();
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
    public abstract void f(boolean paramBoolean, String paramString, int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void a(c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.c
 * JD-Core Version:    0.7.0.1
 */