package com.tencent.mm.audio.mix.e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.c.f;
import com.tencent.mm.audio.mix.c.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class e
{
  public static int cTi = 18432;
  private i cSA;
  private int cTa;
  private int cTb;
  private int cTc;
  private int cTd;
  private ArrayList<String> cTe;
  private HashMap<String, g> cTf;
  private HashMap<String, byte[]> cTg;
  private HashMap<String, Integer> cTh;
  
  public e()
  {
    AppMethodBeat.i(136866);
    this.cTd = 0;
    this.cTe = new ArrayList();
    this.cTf = new HashMap();
    this.cTg = new HashMap();
    this.cTh = new HashMap();
    this.cSA = new d();
    this.cSA.init();
    AppMethodBeat.o(136866);
  }
  
  private byte[] L(List<com.tencent.mm.audio.mix.a.e> paramList)
  {
    AppMethodBeat.i(136871);
    if (paramList.isEmpty())
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioSyncMixController", "list is invalid");
      AppMethodBeat.o(136871);
      return null;
    }
    if (paramList.size() == 1)
    {
      paramList = ((com.tencent.mm.audio.mix.a.e)paramList.get(0)).cQH;
      AppMethodBeat.o(136871);
      return paramList;
    }
    if (this.cSA == null)
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioSyncMixController", "mixer is null");
      AppMethodBeat.o(136871);
      return null;
    }
    paramList = this.cSA.J(paramList);
    if (paramList != null)
    {
      paramList = paramList.cQH;
      AppMethodBeat.o(136871);
      return paramList;
    }
    AppMethodBeat.o(136871);
    return null;
  }
  
  public final byte[] K(List<com.tencent.mm.audio.mix.a.e> paramList)
  {
    AppMethodBeat.i(136868);
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(136868);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramList.size() > 1) {}
    com.tencent.mm.audio.mix.a.e locale1;
    for (int i = 1;; i = 0)
    {
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label823;
        }
        locale1 = (com.tencent.mm.audio.mix.a.e)localIterator.next();
        if ((locale1 != null) && (locale1.cQH != null) && (!TextUtils.isEmpty(locale1.cQO))) {
          break;
        }
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioSyncMixController", "track or pcmData is null, or audioId is empty");
        paramList = locale1;
        localArrayList.add(paramList);
      }
    }
    label154:
    com.tencent.mm.audio.mix.a.e locale2;
    byte[] arrayOfByte1;
    if (this.cTf.containsKey(locale1.cQO))
    {
      paramList = (g)this.cTf.get(locale1.cQO);
      locale2 = new com.tencent.mm.audio.mix.a.e();
      locale2.cQH = paramList.J(locale1.cQH);
      locale2.cQO = locale1.cQO;
      locale2.cQR = locale1.cQR;
      locale2.channels = locale1.channels;
      locale2.sampleRate = locale1.sampleRate;
      locale2.cQG = locale1.cQG;
      if (i != 0)
      {
        arrayOfByte1 = locale2.cQH;
        if ((arrayOfByte1 != null) && (arrayOfByte1.length != 0))
        {
          paramList = null;
          if (!this.cTg.containsKey(locale2.cQO)) {
            break label840;
          }
          paramList = (byte[])this.cTg.get(locale2.cQO);
        }
      }
    }
    label416:
    label582:
    label840:
    for (int j = ((Integer)this.cTh.get(locale2.cQO)).intValue();; j = 0)
    {
      if ((j > 0) && (paramList != null)) {
        if (arrayOfByte1.length <= cTi - j)
        {
          System.arraycopy(arrayOfByte1, 0, paramList, j, arrayOfByte1.length);
          j = arrayOfByte1.length + j;
          label339:
          if (j <= this.cTd) {
            break label582;
          }
          j -= this.cTd;
          arrayOfByte1 = new byte[this.cTd];
          System.arraycopy(paramList, 0, arrayOfByte1, 0, this.cTd);
          locale2.cQH = arrayOfByte1;
          arrayOfByte1 = new byte[j];
          System.arraycopy(paramList, this.cTd, arrayOfByte1, 0, j);
          Arrays.fill(paramList, 0, cTi, (byte)0);
          System.arraycopy(arrayOfByte1, 0, paramList, 0, j);
          this.cTh.put(locale2.cQO, Integer.valueOf(j));
          this.cTg.put(locale2.cQO, paramList);
        }
      }
      do
      {
        for (;;)
        {
          if (locale2.cQH.equals(locale1.cQH))
          {
            paramList = new byte[locale2.cQH.length];
            System.arraycopy(locale2.cQH, 0, paramList, 0, locale2.cQH.length);
            locale2.cQH = paramList;
          }
          paramList = locale2;
          break;
          paramList = new f(locale1.cQO, locale1.sampleRate, locale1.channels, locale1.cQG, this.cTa, this.cTb, this.cTc);
          this.cTf.put(locale1.cQO, paramList);
          break label154;
          System.arraycopy(arrayOfByte1, 0, paramList, j, cTi - j);
          j = cTi - j + j;
          break label339;
          arrayOfByte1 = new byte[this.cTd];
          System.arraycopy(paramList, 0, arrayOfByte1, 0, j);
          locale2.cQH = arrayOfByte1;
          j = 0;
          Arrays.fill(paramList, 0, cTi, (byte)0);
          break label416;
          if (arrayOfByte1.length >= this.cTd) {
            break label667;
          }
          paramList = new byte[this.cTd];
          Arrays.fill(paramList, 0, this.cTd, (byte)0);
          System.arraycopy(arrayOfByte1, 0, paramList, 0, arrayOfByte1.length);
          locale2.cQH = paramList;
        }
      } while (arrayOfByte1.length <= this.cTd);
      byte[] arrayOfByte2 = new byte[this.cTd];
      Arrays.fill(arrayOfByte2, 0, this.cTd, (byte)0);
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, this.cTd);
      locale2.cQH = arrayOfByte2;
      if (paramList == null) {
        if (arrayOfByte1.length > cTi)
        {
          j = arrayOfByte1.length;
          label733:
          cTi = j;
          paramList = new byte[j];
        }
      }
      for (;;)
      {
        Arrays.fill(paramList, 0, cTi, (byte)0);
        System.arraycopy(arrayOfByte1, this.cTd, paramList, 0, arrayOfByte1.length - this.cTd);
        j = arrayOfByte1.length;
        int k = this.cTd;
        this.cTh.put(locale2.cQO, Integer.valueOf(j - k));
        this.cTg.put(locale2.cQO, paramList);
        break;
        j = cTi;
        break label733;
        paramList = L(localArrayList);
        AppMethodBeat.o(136868);
        return paramList;
      }
    }
  }
  
  public final byte[] NB()
  {
    AppMethodBeat.i(136869);
    Object localObject = new ArrayList();
    Iterator localIterator = this.cTe.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (this.cTg.containsKey(str))
      {
        byte[] arrayOfByte1 = (byte[])this.cTg.get(str);
        int i = ((Integer)this.cTh.get(str)).intValue();
        com.tencent.mm.audio.mix.a.e locale = new com.tencent.mm.audio.mix.a.e();
        byte[] arrayOfByte2 = new byte[this.cTd];
        if ((i > 0) && (i <= this.cTd)) {
          System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
        }
        for (;;)
        {
          locale.cQH = arrayOfByte2;
          ((List)localObject).add(locale);
          this.cTh.put(str, Integer.valueOf(0));
          Arrays.fill(arrayOfByte1, 0, cTi, (byte)0);
          this.cTg.put(str, arrayOfByte1);
          break;
          if (arrayOfByte1 != null) {
            System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, this.cTd);
          }
        }
      }
    }
    localObject = L((List)localObject);
    AppMethodBeat.o(136869);
    return localObject;
  }
  
  public final void r(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(136867);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioSyncMixController", "init, outSample:%d, outChannel:%d, outBitDepth:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.cTa = paramInt1;
    this.cTb = paramInt2;
    this.cTc = paramInt3;
    this.cTd = paramInt4;
    if (this.cTd <= 0) {
      if (2 != paramInt3) {
        break label98;
      }
    }
    label98:
    for (paramInt3 = 16;; paramInt3 = 8)
    {
      this.cTd = (paramInt3 * (paramInt1 * paramInt2) * 20 / 8 / 1000);
      AppMethodBeat.o(136867);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(136870);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioSyncMixController", "release, ids size:%d", new Object[] { Integer.valueOf(this.cTe.size()) });
    Iterator localIterator = this.cTe.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (this.cTf.containsKey(str))
      {
        g localg = (g)this.cTf.remove(str);
        if (localg != null) {
          localg.release();
        }
      }
      this.cTg.remove(str);
      this.cTh.remove(str);
    }
    this.cTf.clear();
    this.cTg.clear();
    this.cTh.clear();
    this.cTe.clear();
    if (this.cSA != null) {
      this.cSA = null;
    }
    AppMethodBeat.o(136870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.e
 * JD-Core Version:    0.7.0.1
 */