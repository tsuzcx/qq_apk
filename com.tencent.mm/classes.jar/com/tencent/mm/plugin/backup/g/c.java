package com.tencent.mm.plugin.backup.g;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.plugin.backup.f.j;
import com.tencent.mm.plugin.backup.i.x;
import com.tencent.mm.plugin.backup.i.y;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.protocal.protobuf.it;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class c
  extends b
{
  private static String TAG = "MicroMsg.BackupDataPushScene";
  private i gNh;
  private y oPA;
  private int oPB;
  private c.a oPC;
  private PByteArray oPm;
  public x oPz;
  
  private c(final b paramb, String paramString, c.a parama, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21708);
    this.oPz = new x();
    this.oPA = new y();
    this.oPB = 0;
    this.oPm = new PByteArray();
    this.oPC = null;
    this.oPz.oUz = paramString;
    this.oPz.oUA = 2;
    this.gNh = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(21700);
        paramAnonymousString = (c)paramAnonymousq;
        paramb.g(c.a.a(c.b(paramAnonymousString), paramAnonymousString), paramAnonymousString.oPz.oUz, paramAnonymousString.cgH());
        AppMethodBeat.o(21700);
      }
    };
    this.oPC = parama;
    c.a.b(parama, this);
    paramb = this.oPC;
    if (paramb.iKP <= 0)
    {
      paramb = new Pair(Integer.valueOf(0), new byte[0]);
      if ((paramb.second == null) || (paramb.first == null))
      {
        Log.w(TAG, "BackupDataPushScene media backFileOp getNext error, file path:%s", new Object[] { this.oPC.filePath });
        this.oPz.oTm = null;
        AppMethodBeat.o(21708);
      }
    }
    else
    {
      long l;
      label192:
      int i;
      if (paramb.iKP - paramb.offset > 524288L)
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
        l = paramb.iKP - paramb.offset;
        break label192;
      }
    }
    parama = (byte[])paramb.second;
    this.oPz.oUB = this.oPC.iKP;
    this.oPz.oUC = ((Integer)paramb.first).intValue();
    this.oPz.oUD = (this.oPz.oUC + parama.length);
    paramb = this.oPz;
    if (this.oPz.oUD == this.oPz.oUB) {}
    for (boolean bool = true;; bool = false)
    {
      paramb.oTm = a(parama, bool, paramArrayOfByte);
      Log.d(TAG, "BackupDataPushScene msgid:%s, size:%d", new Object[] { paramString, Integer.valueOf(this.oPz.oUB) });
      cgG();
      AppMethodBeat.o(21708);
      return;
    }
  }
  
  private c(final b paramb, String paramString, LinkedList<is> paramLinkedList, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21709);
    this.oPz = new x();
    this.oPA = new y();
    this.oPB = 0;
    this.oPm = new PByteArray();
    this.oPC = null;
    this.oPz.oUz = paramString;
    this.oPz.oUA = 1;
    this.gNh = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(21701);
        paramAnonymousString = (c)paramAnonymousq;
        paramb.g(true, paramAnonymousString.oPz.oUz, paramAnonymousString.cgH());
        AppMethodBeat.o(21701);
      }
    };
    try
    {
      paramb = new it();
      paramb.oTA = paramLinkedList;
      paramb.oTz = paramLinkedList.size();
      paramb = paramb.toByteArray();
      paramString = paramb;
      if (paramb == null) {
        paramString = new byte[0];
      }
      this.oPz.oUC = 0;
      this.oPz.oUD = paramString.length;
      this.oPz.oUB = paramString.length;
      this.oPz.oTm = a(paramString, true, paramArrayOfByte);
      cgG();
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
  
  private static com.tencent.mm.bw.b a(byte[] paramArrayOfByte1, boolean paramBoolean, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(21713);
    if ((Util.getLength(paramArrayOfByte2) > 0) && (Util.getLength(paramArrayOfByte1) > 0))
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
    paramString2 = new c.a(paramString2);
    int i;
    if (paramString2.iKP <= 0) {
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
      j = (int)(paramString2.iKP / 524288L);
      i = j;
      if (paramString2.iKP % 524288L != 0L) {
        i = j + 1;
      }
    }
    AppMethodBeat.o(21706);
  }
  
  public static void a(b paramb, c paramc, String paramString, LinkedList<is> paramLinkedList, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21707);
    paramc.a(new c(paramb, paramString, paramLinkedList, paramArrayOfByte));
    AppMethodBeat.o(21707);
  }
  
  private void cgG()
  {
    AppMethodBeat.i(21711);
    this.oPB = cgC();
    try
    {
      j.a(this.oPz.toByteArray(), this.oPB, (short)getType(), this.oPm, b.oIY);
      a(this.oPB, this.oPm);
      AppMethodBeat.o(21711);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(TAG, localException, "PacketBackupDataPush to buf fail:%s", new Object[] { localException.toString() });
      AppMethodBeat.o(21711);
    }
  }
  
  public final void Bm(int paramInt)
  {
    AppMethodBeat.i(21710);
    this.gNh.onSceneEnd(0, this.oPA.oTW, "", this);
    AppMethodBeat.o(21710);
  }
  
  public final boolean cgA()
  {
    AppMethodBeat.i(21712);
    byte[] arrayOfByte = this.oPm.value;
    int i = this.oPB;
    if (b.oPq != null) {
      Log.i("MicroMsg.BackupBaseScene", "doSceneSameThread ret[%d], sendSeq[%d], type[%d], buflen[%d]", new Object[] { Integer.valueOf(b.oPq.m(i, arrayOfByte)), Integer.valueOf(i), Integer.valueOf(getType()), Integer.valueOf(arrayOfByte.length) });
    }
    AppMethodBeat.o(21712);
    return true;
  }
  
  public final int cgH()
  {
    if (this.oPm.value == null) {
      return 0;
    }
    return this.oPm.value.length;
  }
  
  public final a cgq()
  {
    return this.oPA;
  }
  
  public final a cgr()
  {
    return this.oPz;
  }
  
  public final int getType()
  {
    return 6;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.c
 * JD-Core Version:    0.7.0.1
 */