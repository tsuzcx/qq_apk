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
  public static int fpu = 18432;
  private i foL;
  private int fpl;
  private int fpm;
  private int fpn;
  private int fpo;
  private ArrayList<String> fpp;
  private HashMap<String, h> fpq;
  private HashMap<String, byte[]> fpr;
  private HashMap<String, Integer> fpt;
  
  public e()
  {
    AppMethodBeat.i(136866);
    this.fpo = 0;
    this.fpp = new ArrayList();
    this.fpq = new HashMap();
    this.fpr = new HashMap();
    this.fpt = new HashMap();
    this.foL = new d();
    this.foL.init();
    AppMethodBeat.o(136866);
  }
  
  private byte[] O(List<com.tencent.mm.audio.mix.a.e> paramList)
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
      paramList = ((com.tencent.mm.audio.mix.a.e)paramList.get(0)).fmy;
      AppMethodBeat.o(136871);
      return paramList;
    }
    if (this.foL == null)
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioSyncMixController", "mixer is null");
      AppMethodBeat.o(136871);
      return null;
    }
    paramList = this.foL.M(paramList);
    if (paramList != null)
    {
      paramList = paramList.fmy;
      AppMethodBeat.o(136871);
      return paramList;
    }
    AppMethodBeat.o(136871);
    return null;
  }
  
  public final byte[] N(List<com.tencent.mm.audio.mix.a.e> paramList)
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
        if ((locale1 != null) && (locale1.fmy != null) && (!TextUtils.isEmpty(locale1.fmF))) {
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
    if (this.fpq.containsKey(locale1.fmF))
    {
      paramList = (h)this.fpq.get(locale1.fmF);
      locale2 = new com.tencent.mm.audio.mix.a.e();
      locale2.fmy = paramList.ae(locale1.fmy);
      locale2.fmF = locale1.fmF;
      locale2.fmI = locale1.fmI;
      locale2.channels = locale1.channels;
      locale2.sampleRate = locale1.sampleRate;
      locale2.fmx = locale1.fmx;
      if (i != 0)
      {
        arrayOfByte1 = locale2.fmy;
        if ((arrayOfByte1 != null) && (arrayOfByte1.length != 0))
        {
          paramList = null;
          if (!this.fpr.containsKey(locale2.fmF)) {
            break label840;
          }
          paramList = (byte[])this.fpr.get(locale2.fmF);
        }
      }
    }
    label416:
    label582:
    label840:
    for (int j = ((Integer)this.fpt.get(locale2.fmF)).intValue();; j = 0)
    {
      if ((j > 0) && (paramList != null)) {
        if (arrayOfByte1.length <= fpu - j)
        {
          System.arraycopy(arrayOfByte1, 0, paramList, j, arrayOfByte1.length);
          j = arrayOfByte1.length + j;
          label339:
          if (j <= this.fpo) {
            break label582;
          }
          j -= this.fpo;
          arrayOfByte1 = new byte[this.fpo];
          System.arraycopy(paramList, 0, arrayOfByte1, 0, this.fpo);
          locale2.fmy = arrayOfByte1;
          arrayOfByte1 = new byte[j];
          System.arraycopy(paramList, this.fpo, arrayOfByte1, 0, j);
          Arrays.fill(paramList, 0, fpu, (byte)0);
          System.arraycopy(arrayOfByte1, 0, paramList, 0, j);
          this.fpt.put(locale2.fmF, Integer.valueOf(j));
          this.fpr.put(locale2.fmF, paramList);
        }
      }
      do
      {
        for (;;)
        {
          if (locale2.fmy.equals(locale1.fmy))
          {
            paramList = new byte[locale2.fmy.length];
            System.arraycopy(locale2.fmy, 0, paramList, 0, locale2.fmy.length);
            locale2.fmy = paramList;
          }
          paramList = locale2;
          break;
          paramList = new g(locale1.fmF, locale1.sampleRate, locale1.channels, locale1.fmx, this.fpl, this.fpm, this.fpn);
          this.fpq.put(locale1.fmF, paramList);
          break label154;
          System.arraycopy(arrayOfByte1, 0, paramList, j, fpu - j);
          j = fpu - j + j;
          break label339;
          arrayOfByte1 = new byte[this.fpo];
          System.arraycopy(paramList, 0, arrayOfByte1, 0, j);
          locale2.fmy = arrayOfByte1;
          j = 0;
          Arrays.fill(paramList, 0, fpu, (byte)0);
          break label416;
          if (arrayOfByte1.length >= this.fpo) {
            break label667;
          }
          paramList = new byte[this.fpo];
          Arrays.fill(paramList, 0, this.fpo, (byte)0);
          System.arraycopy(arrayOfByte1, 0, paramList, 0, arrayOfByte1.length);
          locale2.fmy = paramList;
        }
      } while (arrayOfByte1.length <= this.fpo);
      byte[] arrayOfByte2 = new byte[this.fpo];
      Arrays.fill(arrayOfByte2, 0, this.fpo, (byte)0);
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, this.fpo);
      locale2.fmy = arrayOfByte2;
      if (paramList == null) {
        if (arrayOfByte1.length > fpu)
        {
          j = arrayOfByte1.length;
          label733:
          fpu = j;
          paramList = new byte[j];
        }
      }
      for (;;)
      {
        Arrays.fill(paramList, 0, fpu, (byte)0);
        System.arraycopy(arrayOfByte1, this.fpo, paramList, 0, arrayOfByte1.length - this.fpo);
        j = arrayOfByte1.length;
        int k = this.fpo;
        this.fpt.put(locale2.fmF, Integer.valueOf(j - k));
        this.fpr.put(locale2.fmF, paramList);
        break;
        j = fpu;
        break label733;
        paramList = O(localArrayList);
        AppMethodBeat.o(136868);
        return paramList;
      }
    }
  }
  
  public final byte[] ael()
  {
    AppMethodBeat.i(136869);
    Object localObject = new ArrayList();
    Iterator localIterator = this.fpp.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (this.fpr.containsKey(str))
      {
        byte[] arrayOfByte1 = (byte[])this.fpr.get(str);
        int i = ((Integer)this.fpt.get(str)).intValue();
        com.tencent.mm.audio.mix.a.e locale = new com.tencent.mm.audio.mix.a.e();
        byte[] arrayOfByte2 = new byte[this.fpo];
        if ((i > 0) && (i <= this.fpo)) {
          System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
        }
        for (;;)
        {
          locale.fmy = arrayOfByte2;
          ((List)localObject).add(locale);
          this.fpt.put(str, Integer.valueOf(0));
          Arrays.fill(arrayOfByte1, 0, fpu, (byte)0);
          this.fpr.put(str, arrayOfByte1);
          break;
          if (arrayOfByte1 != null) {
            System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, this.fpo);
          }
        }
      }
    }
    localObject = O((List)localObject);
    AppMethodBeat.o(136869);
    return localObject;
  }
  
  public final void release()
  {
    AppMethodBeat.i(136870);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioSyncMixController", "release, ids size:%d", new Object[] { Integer.valueOf(this.fpp.size()) });
    Iterator localIterator = this.fpp.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (this.fpq.containsKey(str))
      {
        h localh = (h)this.fpq.remove(str);
        if (localh != null) {
          localh.release();
        }
      }
      this.fpr.remove(str);
      this.fpt.remove(str);
    }
    this.fpq.clear();
    this.fpr.clear();
    this.fpt.clear();
    this.fpp.clear();
    if (this.foL != null) {
      this.foL = null;
    }
    AppMethodBeat.o(136870);
  }
  
  public final void t(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(136867);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioSyncMixController", "init, outSample:%d, outChannel:%d, outBitDepth:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.fpl = paramInt1;
    this.fpm = paramInt2;
    this.fpn = paramInt3;
    this.fpo = paramInt4;
    if (this.fpo <= 0) {
      if (2 != paramInt3) {
        break label98;
      }
    }
    label98:
    for (paramInt3 = 16;; paramInt3 = 8)
    {
      this.fpo = (paramInt3 * (paramInt1 * paramInt2) * 20 / 8 / 1000);
      AppMethodBeat.o(136867);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.e
 * JD-Core Version:    0.7.0.1
 */