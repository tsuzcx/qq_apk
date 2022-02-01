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
  public static int dey = 18432;
  private i ddQ;
  private int deq;
  private int der;
  private int des;
  private int det;
  private ArrayList<String> deu;
  private HashMap<String, g> dev;
  private HashMap<String, byte[]> dew;
  private HashMap<String, Integer> dex;
  
  public e()
  {
    AppMethodBeat.i(136866);
    this.det = 0;
    this.deu = new ArrayList();
    this.dev = new HashMap();
    this.dew = new HashMap();
    this.dex = new HashMap();
    this.ddQ = new d();
    this.ddQ.init();
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
      paramList = ((com.tencent.mm.audio.mix.a.e)paramList.get(0)).dbX;
      AppMethodBeat.o(136871);
      return paramList;
    }
    if (this.ddQ == null)
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioSyncMixController", "mixer is null");
      AppMethodBeat.o(136871);
      return null;
    }
    paramList = this.ddQ.J(paramList);
    if (paramList != null)
    {
      paramList = paramList.dbX;
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
        if ((locale1 != null) && (locale1.dbX != null) && (!TextUtils.isEmpty(locale1.dce))) {
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
    if (this.dev.containsKey(locale1.dce))
    {
      paramList = (g)this.dev.get(locale1.dce);
      locale2 = new com.tencent.mm.audio.mix.a.e();
      locale2.dbX = paramList.J(locale1.dbX);
      locale2.dce = locale1.dce;
      locale2.dch = locale1.dch;
      locale2.channels = locale1.channels;
      locale2.sampleRate = locale1.sampleRate;
      locale2.dbW = locale1.dbW;
      if (i != 0)
      {
        arrayOfByte1 = locale2.dbX;
        if ((arrayOfByte1 != null) && (arrayOfByte1.length != 0))
        {
          paramList = null;
          if (!this.dew.containsKey(locale2.dce)) {
            break label840;
          }
          paramList = (byte[])this.dew.get(locale2.dce);
        }
      }
    }
    label416:
    label582:
    label840:
    for (int j = ((Integer)this.dex.get(locale2.dce)).intValue();; j = 0)
    {
      if ((j > 0) && (paramList != null)) {
        if (arrayOfByte1.length <= dey - j)
        {
          System.arraycopy(arrayOfByte1, 0, paramList, j, arrayOfByte1.length);
          j = arrayOfByte1.length + j;
          label339:
          if (j <= this.det) {
            break label582;
          }
          j -= this.det;
          arrayOfByte1 = new byte[this.det];
          System.arraycopy(paramList, 0, arrayOfByte1, 0, this.det);
          locale2.dbX = arrayOfByte1;
          arrayOfByte1 = new byte[j];
          System.arraycopy(paramList, this.det, arrayOfByte1, 0, j);
          Arrays.fill(paramList, 0, dey, (byte)0);
          System.arraycopy(arrayOfByte1, 0, paramList, 0, j);
          this.dex.put(locale2.dce, Integer.valueOf(j));
          this.dew.put(locale2.dce, paramList);
        }
      }
      do
      {
        for (;;)
        {
          if (locale2.dbX.equals(locale1.dbX))
          {
            paramList = new byte[locale2.dbX.length];
            System.arraycopy(locale2.dbX, 0, paramList, 0, locale2.dbX.length);
            locale2.dbX = paramList;
          }
          paramList = locale2;
          break;
          paramList = new f(locale1.dce, locale1.sampleRate, locale1.channels, locale1.dbW, this.deq, this.der, this.des);
          this.dev.put(locale1.dce, paramList);
          break label154;
          System.arraycopy(arrayOfByte1, 0, paramList, j, dey - j);
          j = dey - j + j;
          break label339;
          arrayOfByte1 = new byte[this.det];
          System.arraycopy(paramList, 0, arrayOfByte1, 0, j);
          locale2.dbX = arrayOfByte1;
          j = 0;
          Arrays.fill(paramList, 0, dey, (byte)0);
          break label416;
          if (arrayOfByte1.length >= this.det) {
            break label667;
          }
          paramList = new byte[this.det];
          Arrays.fill(paramList, 0, this.det, (byte)0);
          System.arraycopy(arrayOfByte1, 0, paramList, 0, arrayOfByte1.length);
          locale2.dbX = paramList;
        }
      } while (arrayOfByte1.length <= this.det);
      byte[] arrayOfByte2 = new byte[this.det];
      Arrays.fill(arrayOfByte2, 0, this.det, (byte)0);
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, this.det);
      locale2.dbX = arrayOfByte2;
      if (paramList == null) {
        if (arrayOfByte1.length > dey)
        {
          j = arrayOfByte1.length;
          label733:
          dey = j;
          paramList = new byte[j];
        }
      }
      for (;;)
      {
        Arrays.fill(paramList, 0, dey, (byte)0);
        System.arraycopy(arrayOfByte1, this.det, paramList, 0, arrayOfByte1.length - this.det);
        j = arrayOfByte1.length;
        int k = this.det;
        this.dex.put(locale2.dce, Integer.valueOf(j - k));
        this.dew.put(locale2.dce, paramList);
        break;
        j = dey;
        break label733;
        paramList = L(localArrayList);
        AppMethodBeat.o(136868);
        return paramList;
      }
    }
  }
  
  public final byte[] Pk()
  {
    AppMethodBeat.i(136869);
    Object localObject = new ArrayList();
    Iterator localIterator = this.deu.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (this.dew.containsKey(str))
      {
        byte[] arrayOfByte1 = (byte[])this.dew.get(str);
        int i = ((Integer)this.dex.get(str)).intValue();
        com.tencent.mm.audio.mix.a.e locale = new com.tencent.mm.audio.mix.a.e();
        byte[] arrayOfByte2 = new byte[this.det];
        if ((i > 0) && (i <= this.det)) {
          System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
        }
        for (;;)
        {
          locale.dbX = arrayOfByte2;
          ((List)localObject).add(locale);
          this.dex.put(str, Integer.valueOf(0));
          Arrays.fill(arrayOfByte1, 0, dey, (byte)0);
          this.dew.put(str, arrayOfByte1);
          break;
          if (arrayOfByte1 != null) {
            System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, this.det);
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
    this.deq = paramInt1;
    this.der = paramInt2;
    this.des = paramInt3;
    this.det = paramInt4;
    if (this.det <= 0) {
      if (2 != paramInt3) {
        break label98;
      }
    }
    label98:
    for (paramInt3 = 16;; paramInt3 = 8)
    {
      this.det = (paramInt3 * (paramInt1 * paramInt2) * 20 / 8 / 1000);
      AppMethodBeat.o(136867);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(136870);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioSyncMixController", "release, ids size:%d", new Object[] { Integer.valueOf(this.deu.size()) });
    Iterator localIterator = this.deu.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (this.dev.containsKey(str))
      {
        g localg = (g)this.dev.remove(str);
        if (localg != null) {
          localg.release();
        }
      }
      this.dew.remove(str);
      this.dex.remove(str);
    }
    this.dev.clear();
    this.dew.clear();
    this.dex.clear();
    this.deu.clear();
    if (this.ddQ != null) {
      this.ddQ = null;
    }
    AppMethodBeat.o(136870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.e
 * JD-Core Version:    0.7.0.1
 */