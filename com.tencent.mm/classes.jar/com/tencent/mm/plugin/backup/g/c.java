package com.tencent.mm.plugin.backup.g;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.bv.a;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.plugin.backup.f.j;
import com.tencent.mm.plugin.backup.i.x;
import com.tencent.mm.plugin.backup.i.y;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.protocal.protobuf.gy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class c
  extends b
{
  private static String TAG = "MicroMsg.BackupDataPushScene";
  private f fur;
  private PByteArray jFc;
  public x jFp;
  private y jFq;
  private int jFr;
  private c.a jFs;
  
  private c(c.b paramb, String paramString, c.a parama, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(17649);
    this.jFp = new x();
    this.jFq = new y();
    this.jFr = 0;
    this.jFc = new PByteArray();
    this.jFs = null;
    this.jFp.jKw = paramString;
    this.jFp.jKx = 2;
    this.fur = new c.1(this, paramb);
    this.jFs = parama;
    c.a.b(parama, this);
    paramb = this.jFs;
    if (paramb.fsd <= 0)
    {
      paramb = new Pair(Integer.valueOf(0), new byte[0]);
      if ((paramb.second == null) || (paramb.first == null))
      {
        ab.w(TAG, "BackupDataPushScene media backFileOp getNext error, file path:%s", new Object[] { this.jFs.filePath });
        this.jFp.jJh = null;
        AppMethodBeat.o(17649);
      }
    }
    else
    {
      if (paramb.fsd - paramb.offset > 524288L) {}
      int i;
      for (long l = 524288L;; l = paramb.fsd - paramb.offset)
      {
        i = (int)l;
        paramString = new byte[i];
        if (paramb.jFw == null) {
          break label273;
        }
        System.arraycopy(paramb.jFw, paramb.offset, paramString, 0, i);
        int j = paramb.offset;
        paramb.offset += i;
        paramb = new Pair(Integer.valueOf(j), paramString);
        break;
      }
      label273:
      if (i < 524288L) {}
      for (bool = true;; bool = false)
      {
        paramb.c(paramString, bool);
        break;
      }
    }
    paramString = (byte[])paramb.second;
    this.jFp.jKy = this.jFs.fsd;
    this.jFp.jKz = ((Integer)paramb.first).intValue();
    this.jFp.jKA = (this.jFp.jKz + paramString.length);
    paramb = this.jFp;
    if (this.jFp.jKA == this.jFp.jKy) {}
    for (boolean bool = true;; bool = false)
    {
      paramb.jJh = a(paramString, bool, paramArrayOfByte);
      aUB();
      AppMethodBeat.o(17649);
      return;
    }
  }
  
  private c(c.b paramb, String paramString, LinkedList<gx> paramLinkedList, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(17650);
    this.jFp = new x();
    this.jFq = new y();
    this.jFr = 0;
    this.jFc = new PByteArray();
    this.jFs = null;
    this.jFp.jKw = paramString;
    this.jFp.jKx = 1;
    this.fur = new c.2(this, paramb);
    try
    {
      paramb = new gy();
      paramb.jJv = paramLinkedList;
      paramb.jJu = paramLinkedList.size();
      paramb = paramb.toByteArray();
      paramString = paramb;
      if (paramb == null) {
        paramString = new byte[0];
      }
      this.jFp.jKz = 0;
      this.jFp.jKA = paramString.length;
      this.jFp.jKy = paramString.length;
      this.jFp.jJh = a(paramString, true, paramArrayOfByte);
      aUB();
      AppMethodBeat.o(17650);
      return;
    }
    catch (Exception paramb)
    {
      paramString = TAG;
      if (paramLinkedList != null) {}
    }
    for (int i = -1;; i = paramLinkedList.size())
    {
      ab.e(paramString, "BackupDataPushScene text, BakChatMsgList to buf error, list size[%d], errMsg:%s", new Object[] { Integer.valueOf(i), paramb.getMessage() });
      paramb = null;
      break;
    }
  }
  
  private static com.tencent.mm.bv.b a(byte[] paramArrayOfByte1, boolean paramBoolean, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(17654);
    if ((bo.cf(paramArrayOfByte2) > 0) && (bo.cf(paramArrayOfByte1) > 0))
    {
      paramArrayOfByte1 = new com.tencent.mm.bv.b(AesEcb.aesCryptEcb(paramArrayOfByte1, paramArrayOfByte2, true, paramBoolean));
      AppMethodBeat.o(17654);
      return paramArrayOfByte1;
    }
    paramArrayOfByte1 = new com.tencent.mm.bv.b(paramArrayOfByte1);
    AppMethodBeat.o(17654);
    return paramArrayOfByte1;
  }
  
  public static void a(c.b paramb, c.c paramc, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(17647);
    paramString2 = new c.a(paramString2);
    int i;
    if (paramString2.fsd <= 0) {
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
      j = (int)(paramString2.fsd / 524288L);
      i = j;
      if (paramString2.fsd % 524288L != 0L) {
        i = j + 1;
      }
    }
    AppMethodBeat.o(17647);
  }
  
  public static void a(c.b paramb, c.c paramc, String paramString, LinkedList<gx> paramLinkedList, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(17648);
    paramc.a(new c(paramb, paramString, paramLinkedList, paramArrayOfByte));
    AppMethodBeat.o(17648);
  }
  
  private void aUB()
  {
    AppMethodBeat.i(17652);
    this.jFr = aUx();
    try
    {
      j.a(this.jFp.toByteArray(), this.jFr, (short)getType(), this.jFc, b.jyJ);
      a(this.jFr, this.jFc);
      AppMethodBeat.o(17652);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace(TAG, localException, "PacketBackupDataPush to buf fail:%s", new Object[] { localException.toString() });
      AppMethodBeat.o(17652);
    }
  }
  
  public final int aUC()
  {
    if (this.jFc.value == null) {
      return 0;
    }
    return this.jFc.value.length;
  }
  
  public final a aUl()
  {
    return this.jFq;
  }
  
  public final a aUm()
  {
    return this.jFp;
  }
  
  public final boolean aUv()
  {
    AppMethodBeat.i(17653);
    byte[] arrayOfByte = this.jFc.value;
    int i = this.jFr;
    if (b.jFg != null) {
      ab.i("MicroMsg.BackupBaseScene", "doSceneSameThread ret[%d], sendSeq[%d], type[%d], buflen[%d]", new Object[] { Integer.valueOf(b.jFg.k(i, arrayOfByte)), Integer.valueOf(i), Integer.valueOf(getType()), Integer.valueOf(arrayOfByte.length) });
    }
    AppMethodBeat.o(17653);
    return true;
  }
  
  public final int getType()
  {
    return 6;
  }
  
  public final void rt(int paramInt)
  {
    AppMethodBeat.i(17651);
    this.fur.onSceneEnd(0, this.jFq.jJS, "", this);
    AppMethodBeat.o(17651);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.c
 * JD-Core Version:    0.7.0.1
 */