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
  public static int dfA = 18432;
  private i deS;
  private int dfs;
  private int dft;
  private int dfu;
  private int dfv;
  private ArrayList<String> dfw;
  private HashMap<String, g> dfx;
  private HashMap<String, byte[]> dfy;
  private HashMap<String, Integer> dfz;
  
  public e()
  {
    AppMethodBeat.i(136866);
    this.dfv = 0;
    this.dfw = new ArrayList();
    this.dfx = new HashMap();
    this.dfy = new HashMap();
    this.dfz = new HashMap();
    this.deS = new d();
    this.deS.init();
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
      paramList = ((com.tencent.mm.audio.mix.a.e)paramList.get(0)).dcZ;
      AppMethodBeat.o(136871);
      return paramList;
    }
    if (this.deS == null)
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioSyncMixController", "mixer is null");
      AppMethodBeat.o(136871);
      return null;
    }
    paramList = this.deS.J(paramList);
    if (paramList != null)
    {
      paramList = paramList.dcZ;
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
        if ((locale1 != null) && (locale1.dcZ != null) && (!TextUtils.isEmpty(locale1.ddg))) {
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
    if (this.dfx.containsKey(locale1.ddg))
    {
      paramList = (g)this.dfx.get(locale1.ddg);
      locale2 = new com.tencent.mm.audio.mix.a.e();
      locale2.dcZ = paramList.J(locale1.dcZ);
      locale2.ddg = locale1.ddg;
      locale2.ddj = locale1.ddj;
      locale2.channels = locale1.channels;
      locale2.sampleRate = locale1.sampleRate;
      locale2.dcY = locale1.dcY;
      if (i != 0)
      {
        arrayOfByte1 = locale2.dcZ;
        if ((arrayOfByte1 != null) && (arrayOfByte1.length != 0))
        {
          paramList = null;
          if (!this.dfy.containsKey(locale2.ddg)) {
            break label840;
          }
          paramList = (byte[])this.dfy.get(locale2.ddg);
        }
      }
    }
    label416:
    label582:
    label840:
    for (int j = ((Integer)this.dfz.get(locale2.ddg)).intValue();; j = 0)
    {
      if ((j > 0) && (paramList != null)) {
        if (arrayOfByte1.length <= dfA - j)
        {
          System.arraycopy(arrayOfByte1, 0, paramList, j, arrayOfByte1.length);
          j = arrayOfByte1.length + j;
          label339:
          if (j <= this.dfv) {
            break label582;
          }
          j -= this.dfv;
          arrayOfByte1 = new byte[this.dfv];
          System.arraycopy(paramList, 0, arrayOfByte1, 0, this.dfv);
          locale2.dcZ = arrayOfByte1;
          arrayOfByte1 = new byte[j];
          System.arraycopy(paramList, this.dfv, arrayOfByte1, 0, j);
          Arrays.fill(paramList, 0, dfA, (byte)0);
          System.arraycopy(arrayOfByte1, 0, paramList, 0, j);
          this.dfz.put(locale2.ddg, Integer.valueOf(j));
          this.dfy.put(locale2.ddg, paramList);
        }
      }
      do
      {
        for (;;)
        {
          if (locale2.dcZ.equals(locale1.dcZ))
          {
            paramList = new byte[locale2.dcZ.length];
            System.arraycopy(locale2.dcZ, 0, paramList, 0, locale2.dcZ.length);
            locale2.dcZ = paramList;
          }
          paramList = locale2;
          break;
          paramList = new f(locale1.ddg, locale1.sampleRate, locale1.channels, locale1.dcY, this.dfs, this.dft, this.dfu);
          this.dfx.put(locale1.ddg, paramList);
          break label154;
          System.arraycopy(arrayOfByte1, 0, paramList, j, dfA - j);
          j = dfA - j + j;
          break label339;
          arrayOfByte1 = new byte[this.dfv];
          System.arraycopy(paramList, 0, arrayOfByte1, 0, j);
          locale2.dcZ = arrayOfByte1;
          j = 0;
          Arrays.fill(paramList, 0, dfA, (byte)0);
          break label416;
          if (arrayOfByte1.length >= this.dfv) {
            break label667;
          }
          paramList = new byte[this.dfv];
          Arrays.fill(paramList, 0, this.dfv, (byte)0);
          System.arraycopy(arrayOfByte1, 0, paramList, 0, arrayOfByte1.length);
          locale2.dcZ = paramList;
        }
      } while (arrayOfByte1.length <= this.dfv);
      byte[] arrayOfByte2 = new byte[this.dfv];
      Arrays.fill(arrayOfByte2, 0, this.dfv, (byte)0);
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, this.dfv);
      locale2.dcZ = arrayOfByte2;
      if (paramList == null) {
        if (arrayOfByte1.length > dfA)
        {
          j = arrayOfByte1.length;
          label733:
          dfA = j;
          paramList = new byte[j];
        }
      }
      for (;;)
      {
        Arrays.fill(paramList, 0, dfA, (byte)0);
        System.arraycopy(arrayOfByte1, this.dfv, paramList, 0, arrayOfByte1.length - this.dfv);
        j = arrayOfByte1.length;
        int k = this.dfv;
        this.dfz.put(locale2.ddg, Integer.valueOf(j - k));
        this.dfy.put(locale2.ddg, paramList);
        break;
        j = dfA;
        break label733;
        paramList = L(localArrayList);
        AppMethodBeat.o(136868);
        return paramList;
      }
    }
  }
  
  public final byte[] Pi()
  {
    AppMethodBeat.i(136869);
    Object localObject = new ArrayList();
    Iterator localIterator = this.dfw.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (this.dfy.containsKey(str))
      {
        byte[] arrayOfByte1 = (byte[])this.dfy.get(str);
        int i = ((Integer)this.dfz.get(str)).intValue();
        com.tencent.mm.audio.mix.a.e locale = new com.tencent.mm.audio.mix.a.e();
        byte[] arrayOfByte2 = new byte[this.dfv];
        if ((i > 0) && (i <= this.dfv)) {
          System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
        }
        for (;;)
        {
          locale.dcZ = arrayOfByte2;
          ((List)localObject).add(locale);
          this.dfz.put(str, Integer.valueOf(0));
          Arrays.fill(arrayOfByte1, 0, dfA, (byte)0);
          this.dfy.put(str, arrayOfByte1);
          break;
          if (arrayOfByte1 != null) {
            System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, this.dfv);
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
    this.dfs = paramInt1;
    this.dft = paramInt2;
    this.dfu = paramInt3;
    this.dfv = paramInt4;
    if (this.dfv <= 0) {
      if (2 != paramInt3) {
        break label98;
      }
    }
    label98:
    for (paramInt3 = 16;; paramInt3 = 8)
    {
      this.dfv = (paramInt3 * (paramInt1 * paramInt2) * 20 / 8 / 1000);
      AppMethodBeat.o(136867);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(136870);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioSyncMixController", "release, ids size:%d", new Object[] { Integer.valueOf(this.dfw.size()) });
    Iterator localIterator = this.dfw.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (this.dfx.containsKey(str))
      {
        g localg = (g)this.dfx.remove(str);
        if (localg != null) {
          localg.release();
        }
      }
      this.dfy.remove(str);
      this.dfz.remove(str);
    }
    this.dfx.clear();
    this.dfy.clear();
    this.dfz.clear();
    this.dfw.clear();
    if (this.deS != null) {
      this.deS = null;
    }
    AppMethodBeat.o(136870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.e
 * JD-Core Version:    0.7.0.1
 */