package com.tencent.mm.audio.mix.f;

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
  public static int dwK = 18432;
  private int dwC;
  private int dwD;
  private int dwE;
  private int dwF;
  private ArrayList<String> dwG;
  private HashMap<String, h> dwH;
  private HashMap<String, byte[]> dwI;
  private HashMap<String, Integer> dwJ;
  private i dwc;
  
  public e()
  {
    AppMethodBeat.i(136866);
    this.dwF = 0;
    this.dwG = new ArrayList();
    this.dwH = new HashMap();
    this.dwI = new HashMap();
    this.dwJ = new HashMap();
    this.dwc = new d();
    this.dwc.init();
    AppMethodBeat.o(136866);
  }
  
  private byte[] R(List<com.tencent.mm.audio.mix.a.e> paramList)
  {
    AppMethodBeat.i(136871);
    if (paramList.isEmpty())
    {
      com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioSyncMixController", "list is invalid");
      AppMethodBeat.o(136871);
      return null;
    }
    if (paramList.size() == 1)
    {
      paramList = ((com.tencent.mm.audio.mix.a.e)paramList.get(0)).dtQ;
      AppMethodBeat.o(136871);
      return paramList;
    }
    if (this.dwc == null)
    {
      com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioSyncMixController", "mixer is null");
      AppMethodBeat.o(136871);
      return null;
    }
    paramList = this.dwc.P(paramList);
    if (paramList != null)
    {
      paramList = paramList.dtQ;
      AppMethodBeat.o(136871);
      return paramList;
    }
    AppMethodBeat.o(136871);
    return null;
  }
  
  public final byte[] Q(List<com.tencent.mm.audio.mix.a.e> paramList)
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
        if ((locale1 != null) && (locale1.dtQ != null) && (!TextUtils.isEmpty(locale1.dtX))) {
          break;
        }
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioSyncMixController", "track or pcmData is null, or audioId is empty");
        paramList = locale1;
        localArrayList.add(paramList);
      }
    }
    label154:
    com.tencent.mm.audio.mix.a.e locale2;
    byte[] arrayOfByte1;
    if (this.dwH.containsKey(locale1.dtX))
    {
      paramList = (h)this.dwH.get(locale1.dtX);
      locale2 = new com.tencent.mm.audio.mix.a.e();
      locale2.dtQ = paramList.X(locale1.dtQ);
      locale2.dtX = locale1.dtX;
      locale2.dua = locale1.dua;
      locale2.channels = locale1.channels;
      locale2.sampleRate = locale1.sampleRate;
      locale2.dtP = locale1.dtP;
      if (i != 0)
      {
        arrayOfByte1 = locale2.dtQ;
        if ((arrayOfByte1 != null) && (arrayOfByte1.length != 0))
        {
          paramList = null;
          if (!this.dwI.containsKey(locale2.dtX)) {
            break label840;
          }
          paramList = (byte[])this.dwI.get(locale2.dtX);
        }
      }
    }
    label416:
    label582:
    label840:
    for (int j = ((Integer)this.dwJ.get(locale2.dtX)).intValue();; j = 0)
    {
      if ((j > 0) && (paramList != null)) {
        if (arrayOfByte1.length <= dwK - j)
        {
          System.arraycopy(arrayOfByte1, 0, paramList, j, arrayOfByte1.length);
          j = arrayOfByte1.length + j;
          label339:
          if (j <= this.dwF) {
            break label582;
          }
          j -= this.dwF;
          arrayOfByte1 = new byte[this.dwF];
          System.arraycopy(paramList, 0, arrayOfByte1, 0, this.dwF);
          locale2.dtQ = arrayOfByte1;
          arrayOfByte1 = new byte[j];
          System.arraycopy(paramList, this.dwF, arrayOfByte1, 0, j);
          Arrays.fill(paramList, 0, dwK, (byte)0);
          System.arraycopy(arrayOfByte1, 0, paramList, 0, j);
          this.dwJ.put(locale2.dtX, Integer.valueOf(j));
          this.dwI.put(locale2.dtX, paramList);
        }
      }
      do
      {
        for (;;)
        {
          if (locale2.dtQ.equals(locale1.dtQ))
          {
            paramList = new byte[locale2.dtQ.length];
            System.arraycopy(locale2.dtQ, 0, paramList, 0, locale2.dtQ.length);
            locale2.dtQ = paramList;
          }
          paramList = locale2;
          break;
          paramList = new g(locale1.dtX, locale1.sampleRate, locale1.channels, locale1.dtP, this.dwC, this.dwD, this.dwE);
          this.dwH.put(locale1.dtX, paramList);
          break label154;
          System.arraycopy(arrayOfByte1, 0, paramList, j, dwK - j);
          j = dwK - j + j;
          break label339;
          arrayOfByte1 = new byte[this.dwF];
          System.arraycopy(paramList, 0, arrayOfByte1, 0, j);
          locale2.dtQ = arrayOfByte1;
          j = 0;
          Arrays.fill(paramList, 0, dwK, (byte)0);
          break label416;
          if (arrayOfByte1.length >= this.dwF) {
            break label667;
          }
          paramList = new byte[this.dwF];
          Arrays.fill(paramList, 0, this.dwF, (byte)0);
          System.arraycopy(arrayOfByte1, 0, paramList, 0, arrayOfByte1.length);
          locale2.dtQ = paramList;
        }
      } while (arrayOfByte1.length <= this.dwF);
      byte[] arrayOfByte2 = new byte[this.dwF];
      Arrays.fill(arrayOfByte2, 0, this.dwF, (byte)0);
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, this.dwF);
      locale2.dtQ = arrayOfByte2;
      if (paramList == null) {
        if (arrayOfByte1.length > dwK)
        {
          j = arrayOfByte1.length;
          label733:
          dwK = j;
          paramList = new byte[j];
        }
      }
      for (;;)
      {
        Arrays.fill(paramList, 0, dwK, (byte)0);
        System.arraycopy(arrayOfByte1, this.dwF, paramList, 0, arrayOfByte1.length - this.dwF);
        j = arrayOfByte1.length;
        int k = this.dwF;
        this.dwJ.put(locale2.dtX, Integer.valueOf(j - k));
        this.dwI.put(locale2.dtX, paramList);
        break;
        j = dwK;
        break label733;
        paramList = R(localArrayList);
        AppMethodBeat.o(136868);
        return paramList;
      }
    }
  }
  
  public final byte[] ZC()
  {
    AppMethodBeat.i(136869);
    Object localObject = new ArrayList();
    Iterator localIterator = this.dwG.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (this.dwI.containsKey(str))
      {
        byte[] arrayOfByte1 = (byte[])this.dwI.get(str);
        int i = ((Integer)this.dwJ.get(str)).intValue();
        com.tencent.mm.audio.mix.a.e locale = new com.tencent.mm.audio.mix.a.e();
        byte[] arrayOfByte2 = new byte[this.dwF];
        if ((i > 0) && (i <= this.dwF)) {
          System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
        }
        for (;;)
        {
          locale.dtQ = arrayOfByte2;
          ((List)localObject).add(locale);
          this.dwJ.put(str, Integer.valueOf(0));
          Arrays.fill(arrayOfByte1, 0, dwK, (byte)0);
          this.dwI.put(str, arrayOfByte1);
          break;
          if (arrayOfByte1 != null) {
            System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, this.dwF);
          }
        }
      }
    }
    localObject = R((List)localObject);
    AppMethodBeat.o(136869);
    return localObject;
  }
  
  public final void r(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(136867);
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioSyncMixController", "init, outSample:%d, outChannel:%d, outBitDepth:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.dwC = paramInt1;
    this.dwD = paramInt2;
    this.dwE = paramInt3;
    this.dwF = paramInt4;
    if (this.dwF <= 0) {
      if (2 != paramInt3) {
        break label98;
      }
    }
    label98:
    for (paramInt3 = 16;; paramInt3 = 8)
    {
      this.dwF = (paramInt3 * (paramInt1 * paramInt2) * 20 / 8 / 1000);
      AppMethodBeat.o(136867);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(136870);
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioSyncMixController", "release, ids size:%d", new Object[] { Integer.valueOf(this.dwG.size()) });
    Iterator localIterator = this.dwG.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (this.dwH.containsKey(str))
      {
        h localh = (h)this.dwH.remove(str);
        if (localh != null) {
          localh.release();
        }
      }
      this.dwI.remove(str);
      this.dwJ.remove(str);
    }
    this.dwH.clear();
    this.dwI.clear();
    this.dwJ.clear();
    this.dwG.clear();
    if (this.dwc != null) {
      this.dwc = null;
    }
    AppMethodBeat.o(136870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.f.e
 * JD-Core Version:    0.7.0.1
 */