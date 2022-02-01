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
  public static int cVM = 18432;
  private int cVE;
  private int cVF;
  private int cVG;
  private int cVH;
  private ArrayList<String> cVI;
  private HashMap<String, g> cVJ;
  private HashMap<String, byte[]> cVK;
  private HashMap<String, Integer> cVL;
  private i cVe;
  
  public e()
  {
    AppMethodBeat.i(136866);
    this.cVH = 0;
    this.cVI = new ArrayList();
    this.cVJ = new HashMap();
    this.cVK = new HashMap();
    this.cVL = new HashMap();
    this.cVe = new d();
    this.cVe.init();
    AppMethodBeat.o(136866);
  }
  
  private byte[] U(List<com.tencent.mm.audio.mix.a.e> paramList)
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
      paramList = ((com.tencent.mm.audio.mix.a.e)paramList.get(0)).cTk;
      AppMethodBeat.o(136871);
      return paramList;
    }
    if (this.cVe == null)
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioSyncMixController", "mixer is null");
      AppMethodBeat.o(136871);
      return null;
    }
    paramList = this.cVe.S(paramList);
    if (paramList != null)
    {
      paramList = paramList.cTk;
      AppMethodBeat.o(136871);
      return paramList;
    }
    AppMethodBeat.o(136871);
    return null;
  }
  
  public final byte[] ND()
  {
    AppMethodBeat.i(136869);
    Object localObject = new ArrayList();
    Iterator localIterator = this.cVI.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (this.cVK.containsKey(str))
      {
        byte[] arrayOfByte1 = (byte[])this.cVK.get(str);
        int i = ((Integer)this.cVL.get(str)).intValue();
        com.tencent.mm.audio.mix.a.e locale = new com.tencent.mm.audio.mix.a.e();
        byte[] arrayOfByte2 = new byte[this.cVH];
        if ((i > 0) && (i <= this.cVH)) {
          System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
        }
        for (;;)
        {
          locale.cTk = arrayOfByte2;
          ((List)localObject).add(locale);
          this.cVL.put(str, Integer.valueOf(0));
          Arrays.fill(arrayOfByte1, 0, cVM, (byte)0);
          this.cVK.put(str, arrayOfByte1);
          break;
          if (arrayOfByte1 != null) {
            System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, this.cVH);
          }
        }
      }
    }
    localObject = U((List)localObject);
    AppMethodBeat.o(136869);
    return localObject;
  }
  
  public final byte[] T(List<com.tencent.mm.audio.mix.a.e> paramList)
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
        if ((locale1 != null) && (locale1.cTk != null) && (!TextUtils.isEmpty(locale1.cTr))) {
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
    if (this.cVJ.containsKey(locale1.cTr))
    {
      paramList = (g)this.cVJ.get(locale1.cTr);
      locale2 = new com.tencent.mm.audio.mix.a.e();
      locale2.cTk = paramList.L(locale1.cTk);
      locale2.cTr = locale1.cTr;
      locale2.cTu = locale1.cTu;
      locale2.channels = locale1.channels;
      locale2.sampleRate = locale1.sampleRate;
      locale2.cTj = locale1.cTj;
      if (i != 0)
      {
        arrayOfByte1 = locale2.cTk;
        if ((arrayOfByte1 != null) && (arrayOfByte1.length != 0))
        {
          paramList = null;
          if (!this.cVK.containsKey(locale2.cTr)) {
            break label840;
          }
          paramList = (byte[])this.cVK.get(locale2.cTr);
        }
      }
    }
    label416:
    label582:
    label840:
    for (int j = ((Integer)this.cVL.get(locale2.cTr)).intValue();; j = 0)
    {
      if ((j > 0) && (paramList != null)) {
        if (arrayOfByte1.length <= cVM - j)
        {
          System.arraycopy(arrayOfByte1, 0, paramList, j, arrayOfByte1.length);
          j = arrayOfByte1.length + j;
          label339:
          if (j <= this.cVH) {
            break label582;
          }
          j -= this.cVH;
          arrayOfByte1 = new byte[this.cVH];
          System.arraycopy(paramList, 0, arrayOfByte1, 0, this.cVH);
          locale2.cTk = arrayOfByte1;
          arrayOfByte1 = new byte[j];
          System.arraycopy(paramList, this.cVH, arrayOfByte1, 0, j);
          Arrays.fill(paramList, 0, cVM, (byte)0);
          System.arraycopy(arrayOfByte1, 0, paramList, 0, j);
          this.cVL.put(locale2.cTr, Integer.valueOf(j));
          this.cVK.put(locale2.cTr, paramList);
        }
      }
      do
      {
        for (;;)
        {
          if (locale2.cTk.equals(locale1.cTk))
          {
            paramList = new byte[locale2.cTk.length];
            System.arraycopy(locale2.cTk, 0, paramList, 0, locale2.cTk.length);
            locale2.cTk = paramList;
          }
          paramList = locale2;
          break;
          paramList = new f(locale1.cTr, locale1.sampleRate, locale1.channels, locale1.cTj, this.cVE, this.cVF, this.cVG);
          this.cVJ.put(locale1.cTr, paramList);
          break label154;
          System.arraycopy(arrayOfByte1, 0, paramList, j, cVM - j);
          j = cVM - j + j;
          break label339;
          arrayOfByte1 = new byte[this.cVH];
          System.arraycopy(paramList, 0, arrayOfByte1, 0, j);
          locale2.cTk = arrayOfByte1;
          j = 0;
          Arrays.fill(paramList, 0, cVM, (byte)0);
          break label416;
          if (arrayOfByte1.length >= this.cVH) {
            break label667;
          }
          paramList = new byte[this.cVH];
          Arrays.fill(paramList, 0, this.cVH, (byte)0);
          System.arraycopy(arrayOfByte1, 0, paramList, 0, arrayOfByte1.length);
          locale2.cTk = paramList;
        }
      } while (arrayOfByte1.length <= this.cVH);
      byte[] arrayOfByte2 = new byte[this.cVH];
      Arrays.fill(arrayOfByte2, 0, this.cVH, (byte)0);
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, this.cVH);
      locale2.cTk = arrayOfByte2;
      if (paramList == null) {
        if (arrayOfByte1.length > cVM)
        {
          j = arrayOfByte1.length;
          label733:
          cVM = j;
          paramList = new byte[j];
        }
      }
      for (;;)
      {
        Arrays.fill(paramList, 0, cVM, (byte)0);
        System.arraycopy(arrayOfByte1, this.cVH, paramList, 0, arrayOfByte1.length - this.cVH);
        j = arrayOfByte1.length;
        int k = this.cVH;
        this.cVL.put(locale2.cTr, Integer.valueOf(j - k));
        this.cVK.put(locale2.cTr, paramList);
        break;
        j = cVM;
        break label733;
        paramList = U(localArrayList);
        AppMethodBeat.o(136868);
        return paramList;
      }
    }
  }
  
  public final void r(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(136867);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioSyncMixController", "init, outSample:%d, outChannel:%d, outBitDepth:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.cVE = paramInt1;
    this.cVF = paramInt2;
    this.cVG = paramInt3;
    this.cVH = paramInt4;
    if (this.cVH <= 0) {
      if (2 != paramInt3) {
        break label98;
      }
    }
    label98:
    for (paramInt3 = 16;; paramInt3 = 8)
    {
      this.cVH = (paramInt3 * (paramInt1 * paramInt2) * 20 / 8 / 1000);
      AppMethodBeat.o(136867);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(136870);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioSyncMixController", "release, ids size:%d", new Object[] { Integer.valueOf(this.cVI.size()) });
    Iterator localIterator = this.cVI.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (this.cVJ.containsKey(str))
      {
        g localg = (g)this.cVJ.remove(str);
        if (localg != null) {
          localg.release();
        }
      }
      this.cVK.remove(str);
      this.cVL.remove(str);
    }
    this.cVJ.clear();
    this.cVK.clear();
    this.cVL.clear();
    this.cVI.clear();
    if (this.cVe != null) {
      this.cVe = null;
    }
    AppMethodBeat.o(136870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.e
 * JD-Core Version:    0.7.0.1
 */