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
  public static int cgP = 18432;
  private int cgH;
  private int cgI;
  private int cgJ;
  private int cgK;
  private ArrayList<String> cgL;
  private HashMap<String, g> cgM;
  private HashMap<String, byte[]> cgN;
  private HashMap<String, Integer> cgO;
  private i cgg;
  
  public e()
  {
    AppMethodBeat.i(137117);
    this.cgK = 0;
    this.cgL = new ArrayList();
    this.cgM = new HashMap();
    this.cgN = new HashMap();
    this.cgO = new HashMap();
    this.cgg = new d();
    this.cgg.init();
    AppMethodBeat.o(137117);
  }
  
  private byte[] I(List<com.tencent.mm.audio.mix.a.d> paramList)
  {
    AppMethodBeat.i(137122);
    if (paramList.isEmpty())
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioSyncMixController", "list is invalid");
      AppMethodBeat.o(137122);
      return null;
    }
    if (paramList.size() == 1)
    {
      paramList = ((com.tencent.mm.audio.mix.a.d)paramList.get(0)).cem;
      AppMethodBeat.o(137122);
      return paramList;
    }
    if (this.cgg == null)
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioSyncMixController", "mixer is null");
      AppMethodBeat.o(137122);
      return null;
    }
    paramList = this.cgg.G(paramList);
    if (paramList != null)
    {
      paramList = paramList.cem;
      AppMethodBeat.o(137122);
      return paramList;
    }
    AppMethodBeat.o(137122);
    return null;
  }
  
  public final byte[] DU()
  {
    AppMethodBeat.i(137120);
    Object localObject = new ArrayList();
    Iterator localIterator = this.cgL.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (this.cgN.containsKey(str))
      {
        byte[] arrayOfByte1 = (byte[])this.cgN.get(str);
        int i = ((Integer)this.cgO.get(str)).intValue();
        com.tencent.mm.audio.mix.a.d locald = new com.tencent.mm.audio.mix.a.d();
        byte[] arrayOfByte2 = new byte[this.cgK];
        if ((i > 0) && (i <= this.cgK)) {
          System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
        }
        for (;;)
        {
          locald.cem = arrayOfByte2;
          ((List)localObject).add(locald);
          this.cgO.put(str, Integer.valueOf(0));
          Arrays.fill(arrayOfByte1, 0, cgP, (byte)0);
          this.cgN.put(str, arrayOfByte1);
          break;
          if (arrayOfByte1 != null) {
            System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, this.cgK);
          }
        }
      }
    }
    localObject = I((List)localObject);
    AppMethodBeat.o(137120);
    return localObject;
  }
  
  public final byte[] H(List<com.tencent.mm.audio.mix.a.d> paramList)
  {
    AppMethodBeat.i(137119);
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(137119);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramList.size() > 1) {}
    com.tencent.mm.audio.mix.a.d locald1;
    for (int i = 1;; i = 0)
    {
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label823;
        }
        locald1 = (com.tencent.mm.audio.mix.a.d)localIterator.next();
        if ((locald1 != null) && (locald1.cem != null) && (!TextUtils.isEmpty(locald1.ceu))) {
          break;
        }
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioSyncMixController", "track or pcmData is null, or audioId is empty");
        paramList = locald1;
        localArrayList.add(paramList);
      }
    }
    label154:
    com.tencent.mm.audio.mix.a.d locald2;
    byte[] arrayOfByte1;
    if (this.cgM.containsKey(locald1.ceu))
    {
      paramList = (g)this.cgM.get(locald1.ceu);
      locald2 = new com.tencent.mm.audio.mix.a.d();
      locald2.cem = paramList.E(locald1.cem);
      locald2.ceu = locald1.ceu;
      locald2.cex = locald1.cex;
      locald2.channels = locald1.channels;
      locald2.sampleRate = locald1.sampleRate;
      locald2.cel = locald1.cel;
      if (i != 0)
      {
        arrayOfByte1 = locald2.cem;
        if ((arrayOfByte1 != null) && (arrayOfByte1.length != 0))
        {
          paramList = null;
          if (!this.cgN.containsKey(locald2.ceu)) {
            break label840;
          }
          paramList = (byte[])this.cgN.get(locald2.ceu);
        }
      }
    }
    label416:
    label582:
    label840:
    for (int j = ((Integer)this.cgO.get(locald2.ceu)).intValue();; j = 0)
    {
      if ((j > 0) && (paramList != null)) {
        if (arrayOfByte1.length <= cgP - j)
        {
          System.arraycopy(arrayOfByte1, 0, paramList, j, arrayOfByte1.length);
          j = arrayOfByte1.length + j;
          label339:
          if (j <= this.cgK) {
            break label582;
          }
          j -= this.cgK;
          arrayOfByte1 = new byte[this.cgK];
          System.arraycopy(paramList, 0, arrayOfByte1, 0, this.cgK);
          locald2.cem = arrayOfByte1;
          arrayOfByte1 = new byte[j];
          System.arraycopy(paramList, this.cgK, arrayOfByte1, 0, j);
          Arrays.fill(paramList, 0, cgP, (byte)0);
          System.arraycopy(arrayOfByte1, 0, paramList, 0, j);
          this.cgO.put(locald2.ceu, Integer.valueOf(j));
          this.cgN.put(locald2.ceu, paramList);
        }
      }
      do
      {
        for (;;)
        {
          if (locald2.cem.equals(locald1.cem))
          {
            paramList = new byte[locald2.cem.length];
            System.arraycopy(locald2.cem, 0, paramList, 0, locald2.cem.length);
            locald2.cem = paramList;
          }
          paramList = locald2;
          break;
          paramList = new f(locald1.ceu, locald1.sampleRate, locald1.channels, locald1.cel, this.cgH, this.cgI, this.cgJ);
          this.cgM.put(locald1.ceu, paramList);
          break label154;
          System.arraycopy(arrayOfByte1, 0, paramList, j, cgP - j);
          j = cgP - j + j;
          break label339;
          arrayOfByte1 = new byte[this.cgK];
          System.arraycopy(paramList, 0, arrayOfByte1, 0, j);
          locald2.cem = arrayOfByte1;
          j = 0;
          Arrays.fill(paramList, 0, cgP, (byte)0);
          break label416;
          if (arrayOfByte1.length >= this.cgK) {
            break label667;
          }
          paramList = new byte[this.cgK];
          Arrays.fill(paramList, 0, this.cgK, (byte)0);
          System.arraycopy(arrayOfByte1, 0, paramList, 0, arrayOfByte1.length);
          locald2.cem = paramList;
        }
      } while (arrayOfByte1.length <= this.cgK);
      byte[] arrayOfByte2 = new byte[this.cgK];
      Arrays.fill(arrayOfByte2, 0, this.cgK, (byte)0);
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, this.cgK);
      locald2.cem = arrayOfByte2;
      if (paramList == null) {
        if (arrayOfByte1.length > cgP)
        {
          j = arrayOfByte1.length;
          label733:
          cgP = j;
          paramList = new byte[j];
        }
      }
      for (;;)
      {
        Arrays.fill(paramList, 0, cgP, (byte)0);
        System.arraycopy(arrayOfByte1, this.cgK, paramList, 0, arrayOfByte1.length - this.cgK);
        j = arrayOfByte1.length;
        int k = this.cgK;
        this.cgO.put(locald2.ceu, Integer.valueOf(j - k));
        this.cgN.put(locald2.ceu, paramList);
        break;
        j = cgP;
        break label733;
        paramList = I(localArrayList);
        AppMethodBeat.o(137119);
        return paramList;
      }
    }
  }
  
  public final void q(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(137118);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioSyncMixController", "init, outSample:%d, outChannel:%d, outBitDepth:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.cgH = paramInt1;
    this.cgI = paramInt2;
    this.cgJ = paramInt3;
    this.cgK = paramInt4;
    if (this.cgK <= 0) {
      if (2 != paramInt3) {
        break label98;
      }
    }
    label98:
    for (paramInt3 = 16;; paramInt3 = 8)
    {
      this.cgK = (paramInt3 * (paramInt1 * paramInt2) * 20 / 8 / 1000);
      AppMethodBeat.o(137118);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(137121);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioSyncMixController", "release, ids size:%d", new Object[] { Integer.valueOf(this.cgL.size()) });
    Iterator localIterator = this.cgL.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (this.cgM.containsKey(str))
      {
        g localg = (g)this.cgM.remove(str);
        if (localg != null) {
          localg.release();
        }
      }
      this.cgN.remove(str);
      this.cgO.remove(str);
    }
    this.cgM.clear();
    this.cgN.clear();
    this.cgO.clear();
    this.cgL.clear();
    if (this.cgg != null) {
      this.cgg = null;
    }
    AppMethodBeat.o(137121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.e
 * JD-Core Version:    0.7.0.1
 */