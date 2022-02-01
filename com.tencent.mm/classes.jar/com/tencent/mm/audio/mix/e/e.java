package com.tencent.mm.audio.mix.e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.c.g;
import com.tencent.mm.audio.mix.c.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class e
{
  public static int htD = 18432;
  private i hsV;
  private HashMap<String, h> htA;
  public HashMap<String, byte[]> htB;
  public HashMap<String, Integer> htC;
  public int htv;
  public int htw;
  public int htx;
  public int hty;
  public ArrayList<String> htz;
  
  public e()
  {
    AppMethodBeat.i(136866);
    this.hty = 0;
    this.htz = new ArrayList();
    this.htA = new HashMap();
    this.htB = new HashMap();
    this.htC = new HashMap();
    this.hsV = new d();
    this.hsV.init();
    AppMethodBeat.o(136866);
  }
  
  public final byte[] bn(List<com.tencent.mm.audio.mix.a.e> paramList)
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
        if ((locale1 != null) && (locale1.hqJ != null) && (!TextUtils.isEmpty(locale1.hqQ))) {
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
    if (this.htA.containsKey(locale1.hqQ))
    {
      paramList = (h)this.htA.get(locale1.hqQ);
      locale2 = new com.tencent.mm.audio.mix.a.e();
      locale2.hqJ = paramList.ae(locale1.hqJ);
      locale2.hqQ = locale1.hqQ;
      locale2.hqT = locale1.hqT;
      locale2.channels = locale1.channels;
      locale2.sampleRate = locale1.sampleRate;
      locale2.hqI = locale1.hqI;
      if (i != 0)
      {
        arrayOfByte1 = locale2.hqJ;
        if ((arrayOfByte1 != null) && (arrayOfByte1.length != 0))
        {
          paramList = null;
          if (!this.htB.containsKey(locale2.hqQ)) {
            break label840;
          }
          paramList = (byte[])this.htB.get(locale2.hqQ);
        }
      }
    }
    label416:
    label582:
    label840:
    for (int j = ((Integer)this.htC.get(locale2.hqQ)).intValue();; j = 0)
    {
      if ((j > 0) && (paramList != null)) {
        if (arrayOfByte1.length <= htD - j)
        {
          System.arraycopy(arrayOfByte1, 0, paramList, j, arrayOfByte1.length);
          j = arrayOfByte1.length + j;
          label339:
          if (j <= this.hty) {
            break label582;
          }
          j -= this.hty;
          arrayOfByte1 = new byte[this.hty];
          System.arraycopy(paramList, 0, arrayOfByte1, 0, this.hty);
          locale2.hqJ = arrayOfByte1;
          arrayOfByte1 = new byte[j];
          System.arraycopy(paramList, this.hty, arrayOfByte1, 0, j);
          Arrays.fill(paramList, 0, htD, (byte)0);
          System.arraycopy(arrayOfByte1, 0, paramList, 0, j);
          this.htC.put(locale2.hqQ, Integer.valueOf(j));
          this.htB.put(locale2.hqQ, paramList);
        }
      }
      do
      {
        for (;;)
        {
          if (locale2.hqJ.equals(locale1.hqJ))
          {
            paramList = new byte[locale2.hqJ.length];
            System.arraycopy(locale2.hqJ, 0, paramList, 0, locale2.hqJ.length);
            locale2.hqJ = paramList;
          }
          paramList = locale2;
          break;
          paramList = new g(locale1.hqQ, locale1.sampleRate, locale1.channels, locale1.hqI, this.htv, this.htw, this.htx);
          this.htA.put(locale1.hqQ, paramList);
          break label154;
          System.arraycopy(arrayOfByte1, 0, paramList, j, htD - j);
          j = htD - j + j;
          break label339;
          arrayOfByte1 = new byte[this.hty];
          System.arraycopy(paramList, 0, arrayOfByte1, 0, j);
          locale2.hqJ = arrayOfByte1;
          j = 0;
          Arrays.fill(paramList, 0, htD, (byte)0);
          break label416;
          if (arrayOfByte1.length >= this.hty) {
            break label667;
          }
          paramList = new byte[this.hty];
          Arrays.fill(paramList, 0, this.hty, (byte)0);
          System.arraycopy(arrayOfByte1, 0, paramList, 0, arrayOfByte1.length);
          locale2.hqJ = paramList;
        }
      } while (arrayOfByte1.length <= this.hty);
      byte[] arrayOfByte2 = new byte[this.hty];
      Arrays.fill(arrayOfByte2, 0, this.hty, (byte)0);
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, this.hty);
      locale2.hqJ = arrayOfByte2;
      if (paramList == null) {
        if (arrayOfByte1.length > htD)
        {
          j = arrayOfByte1.length;
          label733:
          htD = j;
          paramList = new byte[j];
        }
      }
      for (;;)
      {
        Arrays.fill(paramList, 0, htD, (byte)0);
        System.arraycopy(arrayOfByte1, this.hty, paramList, 0, arrayOfByte1.length - this.hty);
        j = arrayOfByte1.length;
        int k = this.hty;
        this.htC.put(locale2.hqQ, Integer.valueOf(j - k));
        this.htB.put(locale2.hqQ, paramList);
        break;
        j = htD;
        break label733;
        paramList = bo(localArrayList);
        AppMethodBeat.o(136868);
        return paramList;
      }
    }
  }
  
  public final byte[] bo(List<com.tencent.mm.audio.mix.a.e> paramList)
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
      paramList = ((com.tencent.mm.audio.mix.a.e)paramList.get(0)).hqJ;
      AppMethodBeat.o(136871);
      return paramList;
    }
    if (this.hsV == null)
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioSyncMixController", "mixer is null");
      AppMethodBeat.o(136871);
      return null;
    }
    paramList = this.hsV.bm(paramList);
    if (paramList != null)
    {
      paramList = paramList.hqJ;
      AppMethodBeat.o(136871);
      return paramList;
    }
    AppMethodBeat.o(136871);
    return null;
  }
  
  public final void release()
  {
    AppMethodBeat.i(136870);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioSyncMixController", "release, ids size:%d", new Object[] { Integer.valueOf(this.htz.size()) });
    Iterator localIterator = this.htz.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (this.htA.containsKey(str))
      {
        h localh = (h)this.htA.remove(str);
        if (localh != null) {
          localh.release();
        }
      }
      this.htB.remove(str);
      this.htC.remove(str);
    }
    this.htA.clear();
    this.htB.clear();
    this.htC.clear();
    this.htz.clear();
    if (this.hsV != null) {
      this.hsV = null;
    }
    AppMethodBeat.o(136870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.e
 * JD-Core Version:    0.7.0.1
 */