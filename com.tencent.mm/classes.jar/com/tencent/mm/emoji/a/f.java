package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f
{
  private static int ewB = 98304;
  private static int ewC = 4;
  private boolean aLC;
  private final EmojiInfo evH;
  private boolean ewD;
  private boolean ewE;
  private String ewF;
  private List<String> ewG;
  private String ewH;
  public b ewI;
  private List<c> ewJ;
  private int ewK;
  private int ewL;
  private int ewM;
  private long ewN;
  private boolean ewO;
  
  public f(EmojiInfo paramEmojiInfo, boolean paramBoolean1, boolean paramBoolean2, String paramString1, List<String> paramList, String paramString2)
  {
    AppMethodBeat.i(62244);
    this.aLC = false;
    this.ewJ = new ArrayList();
    this.ewL = 2;
    ab.i("MicroMsg.EmojiUploadHelper", "EmojiUploadHelper: isCapture %s", new Object[] { Boolean.valueOf(paramBoolean1) });
    this.evH = paramEmojiInfo;
    this.ewD = paramBoolean1;
    this.ewE = paramBoolean2;
    this.ewF = paramString1;
    this.ewG = paramList;
    this.ewH = paramString2;
    this.ewN = System.currentTimeMillis();
    int m = paramEmojiInfo.field_size;
    int n = (int)Math.ceil(m * 1.0D / ewB);
    this.ewK = (n * 2);
    this.ewM = 0;
    int i = 0;
    while (i < n)
    {
      int i1 = i * ewB;
      int k = ewB;
      int j = k;
      if (i1 + k > m) {
        j = m - i1;
      }
      paramString1 = new c((byte)0);
      paramString1.index = i;
      paramString1.start = i1;
      paramString1.bWt = j;
      this.ewJ.add(paramString1);
      i += 1;
    }
    ab.i("MicroMsg.EmojiUploadHelper", "start upload emoji, md5 %s, totalLen %d, parts %d, file %s", new Object[] { paramEmojiInfo.Al(), Integer.valueOf(m), Integer.valueOf(n), paramEmojiInfo.dQB() });
    i = 0;
    while (i < ewC)
    {
      OG();
      i += 1;
    }
    AppMethodBeat.o(62244);
  }
  
  private void OG()
  {
    Object localObject = null;
    int i = 1;
    int j = 0;
    label39:
    label308:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(62245);
        if (this.aLC)
        {
          AppMethodBeat.o(62245);
          return;
        }
        Iterator localIterator = this.ewJ.iterator();
        if (!localIterator.hasNext()) {
          break label308;
        }
        c localc2 = (c)localIterator.next();
        if (!localc2.ewR) {
          if (!localc2.running)
          {
            localObject = localc2;
            i = j;
            if (localObject == null)
            {
              if (i != 0)
              {
                ab.w("MicroMsg.EmojiUploadHelper", "all parts finished but not completed");
                a(4, 4, null, false);
              }
              AppMethodBeat.o(62245);
            }
          }
          else
          {
            i = 0;
          }
        }
      }
      finally {}
      for (;;)
      {
        break label39;
        if (this.ewM >= this.ewK)
        {
          ab.w("MicroMsg.EmojiUploadHelper", "req count is %d, max is %d; toRun part is %d", new Object[] { Integer.valueOf(this.ewM), Integer.valueOf(this.ewK), Integer.valueOf(localc1.index) });
          a(3, -2, null, false);
          AppMethodBeat.o(62245);
          break;
        }
        this.ewM += 1;
        localc1.retryCount += 1;
        localc1.running = true;
        ab.i("MicroMsg.EmojiUploadHelper", "start part %d, retry count %d", new Object[] { Integer.valueOf(localc1.index), Integer.valueOf(localc1.retryCount) });
        new f.a(this, this.evH, localc1, this.ewD, this.ewE, this.ewF, this.ewG, this.ewH).adl().g(new f.1(this, localc1));
        AppMethodBeat.o(62245);
        break;
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(62246);
    e locale;
    if ((this.ewI != null) && (!this.ewO))
    {
      this.ewO = true;
      if (paramInt2 == -434)
      {
        if (!this.ewD) {
          break label107;
        }
        locale = e.ewz;
        e.co(true);
        g.RL().Ru().set(ac.a.yxV, Boolean.TRUE);
      }
      this.ewI.b(paramInt1, paramInt2, paramString, paramBoolean);
      if (paramInt2 == 0)
      {
        if (!this.ewD) {
          break label134;
        }
        d.Oz().cm(true);
      }
    }
    for (;;)
    {
      paramString = e.ewz;
      e.OE();
      AppMethodBeat.o(62246);
      return;
      label107:
      locale = e.ewz;
      e.cn(true);
      g.RL().Ru().set(ac.a.yxU, Boolean.TRUE);
      break;
      label134:
      d.Oz().ck(true);
      d.Oz().cj(true);
    }
  }
  
  public final void a(b paramb)
  {
    this.ewI = paramb;
  }
  
  public static abstract interface b
  {
    public abstract void b(int paramInt1, int paramInt2, String paramString, boolean paramBoolean);
  }
  
  final class c
  {
    public int bWt;
    public boolean ewR;
    public int index;
    public int retryCount;
    public boolean running;
    public int start;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.emoji.a.f
 * JD-Core Version:    0.7.0.1
 */