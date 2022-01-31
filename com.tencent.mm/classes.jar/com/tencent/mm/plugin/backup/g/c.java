package com.tencent.mm.plugin.backup.g;

import android.util.Pair;
import com.tencent.mm.ah.f;
import com.tencent.mm.bv.a;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.plugin.backup.f.j;
import com.tencent.mm.plugin.backup.i.x;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.fo;
import com.tencent.mm.protocal.c.fp;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public final class c
  extends b
{
  private static String TAG = "MicroMsg.BackupDataPushScene";
  private f eeo;
  private PByteArray hLA = new PByteArray();
  public x hLN = new x();
  private com.tencent.mm.plugin.backup.i.y hLO = new com.tencent.mm.plugin.backup.i.y();
  private int hLP = 0;
  private c.a hLQ = null;
  
  private c(c.b paramb, String paramString, c.a parama, byte[] paramArrayOfByte)
  {
    this.hLN.hQV = paramString;
    this.hLN.hQW = 2;
    this.eeo = new c.1(this, paramb);
    this.hLQ = parama;
    c.a.b(parama, this);
    paramb = this.hLQ;
    if (paramb.ebK <= 0)
    {
      paramb = new Pair(Integer.valueOf(0), new byte[0]);
      if ((paramb.second == null) || (paramb.first == null))
      {
        com.tencent.mm.sdk.platformtools.y.w(TAG, "BackupDataPushScene media backFileOp getNext error, file path:%s", new Object[] { this.hLQ.filePath });
        this.hLN.hPF = null;
      }
    }
    else
    {
      if (paramb.ebK - paramb.offset > 524288L) {}
      int i;
      for (long l = 524288L;; l = paramb.ebK - paramb.offset)
      {
        i = (int)l;
        paramString = new byte[i];
        if (paramb.hLU == null) {
          break label264;
        }
        System.arraycopy(paramb.hLU, paramb.offset, paramString, 0, i);
        int j = paramb.offset;
        paramb.offset += i;
        paramb = new Pair(Integer.valueOf(j), paramString);
        break;
      }
      label264:
      if (i < 524288L) {}
      for (bool1 = true;; bool1 = false)
      {
        paramb.b(paramString, bool1);
        break;
      }
    }
    paramString = (byte[])paramb.second;
    this.hLN.hQX = this.hLQ.ebK;
    this.hLN.hQY = ((Integer)paramb.first).intValue();
    this.hLN.hQZ = (this.hLN.hQY + paramString.length);
    paramb = this.hLN;
    if (this.hLN.hQZ == this.hLN.hQX) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramb.hPF = a(paramString, bool1, paramArrayOfByte);
      auZ();
      return;
    }
  }
  
  private c(c.b paramb, String paramString, LinkedList<fo> paramLinkedList, byte[] paramArrayOfByte)
  {
    this.hLN.hQV = paramString;
    this.hLN.hQW = 1;
    this.eeo = new c.2(this, paramb);
    try
    {
      paramb = new fp();
      paramb.hPT = paramLinkedList;
      paramb.hPS = paramLinkedList.size();
      paramb = paramb.toByteArray();
      paramString = paramb;
      if (paramb == null) {
        paramString = new byte[0];
      }
      this.hLN.hQY = 0;
      this.hLN.hQZ = paramString.length;
      this.hLN.hQX = paramString.length;
      this.hLN.hPF = a(paramString, true, paramArrayOfByte);
      auZ();
      return;
    }
    catch (Exception paramb)
    {
      paramString = TAG;
      if (paramLinkedList != null) {}
    }
    for (int i = -1;; i = paramLinkedList.size())
    {
      com.tencent.mm.sdk.platformtools.y.e(paramString, "BackupDataPushScene text, BakChatMsgList to buf error, list size[%d], errMsg:%s", new Object[] { Integer.valueOf(i), paramb.getMessage() });
      paramb = null;
      break;
    }
  }
  
  private static com.tencent.mm.bv.b a(byte[] paramArrayOfByte1, boolean paramBoolean, byte[] paramArrayOfByte2)
  {
    if ((bk.bF(paramArrayOfByte2) > 0) && (bk.bF(paramArrayOfByte1) > 0)) {
      return new com.tencent.mm.bv.b(AesEcb.aesCryptEcb(paramArrayOfByte1, paramArrayOfByte2, true, paramBoolean));
    }
    return new com.tencent.mm.bv.b(paramArrayOfByte1);
  }
  
  public static void a(c.b paramb, c paramc, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    paramString2 = new c.a(paramString2);
    int i;
    if (paramString2.ebK <= 0) {
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
      j = (int)(paramString2.ebK / 524288L);
      i = j;
      if (paramString2.ebK % 524288L != 0L) {
        i = j + 1;
      }
    }
  }
  
  public static void a(c.b paramb, c paramc, String paramString, LinkedList<fo> paramLinkedList, byte[] paramArrayOfByte)
  {
    paramc.a(new c(paramb, paramString, paramLinkedList, paramArrayOfByte));
  }
  
  private void auZ()
  {
    this.hLP = auV();
    try
    {
      j.a(this.hLN.toByteArray(), this.hLP, (short)6, this.hLA, b.hFq);
      int i = this.hLP;
      ??? = this.hLA;
      this.hLA = new PByteArray();
      this.hLA.value = ((PByteArray)???).value;
      synchronized (b.hLC)
      {
        b.hLC.put(Integer.valueOf(i), this);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.y.printErrStackTrace(TAG, localException, "PacketBackupDataPush to buf fail:%s", new Object[] { localException.toString() });
    }
  }
  
  public final a auJ()
  {
    return this.hLO;
  }
  
  public final a auK()
  {
    return this.hLN;
  }
  
  public final boolean auT()
  {
    byte[] arrayOfByte = this.hLA.value;
    int i = this.hLP;
    if (b.hLE != null) {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BackupBaseScene", "doSceneSameThread ret[%d], sendSeq[%d], type[%d], buflen[%d]", new Object[] { Integer.valueOf(b.hLE.k(i, arrayOfByte)), Integer.valueOf(i), Integer.valueOf(getType()), Integer.valueOf(arrayOfByte.length) });
    }
    return true;
  }
  
  public final int ava()
  {
    if (this.hLA.value == null) {
      return 0;
    }
    return this.hLA.value.length;
  }
  
  public final int getType()
  {
    return 6;
  }
  
  public final void nF(int paramInt)
  {
    this.eeo.onSceneEnd(0, this.hLO.hQq, "", this);
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