package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.cm.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.protocal.protobuf.ags;
import com.tencent.mm.protocal.protobuf.agt;
import com.tencent.mm.protocal.protobuf.dtg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
{
  private static int gmB = 98304;
  private static int gmC = 4;
  private boolean bsb;
  private final EmojiInfo glt;
  private boolean gmD;
  private boolean gmE;
  private String gmF;
  private List<String> gmG;
  private String gmH;
  public b gmI;
  private List<c> gmJ;
  private int gmK;
  private int gmL;
  private int gmM;
  private long gmN;
  private boolean gmO;
  
  public k(EmojiInfo paramEmojiInfo, boolean paramBoolean, String paramString1, List<String> paramList, String paramString2)
  {
    AppMethodBeat.i(104456);
    this.bsb = false;
    this.gmJ = new ArrayList();
    this.gmL = 2;
    ae.i("MicroMsg.EmojiUploadHelper", "EmojiUploadHelper: isCapture %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.glt = paramEmojiInfo;
    this.gmD = paramBoolean;
    this.gmE = true;
    this.gmF = paramString1;
    this.gmG = paramList;
    this.gmH = paramString2;
    this.gmN = System.currentTimeMillis();
    int m = paramEmojiInfo.field_size;
    int n = (int)Math.ceil(m * 1.0D / gmB);
    this.gmK = (n * 2);
    this.gmM = 0;
    int i = 0;
    while (i < n)
    {
      int i1 = i * gmB;
      int k = gmB;
      int j = k;
      if (i1 + k > m) {
        j = m - i1;
      }
      paramString1 = new c((byte)0);
      paramString1.index = i;
      paramString1.start = i1;
      paramString1.cSL = j;
      this.gmJ.add(paramString1);
      i += 1;
    }
    ae.i("MicroMsg.EmojiUploadHelper", "start upload emoji, md5 %s, totalLen %d, parts %d, file %s", new Object[] { paramEmojiInfo.Lj(), Integer.valueOf(m), Integer.valueOf(n), paramEmojiInfo.fSQ() });
    i = 0;
    while (i < gmC)
    {
      afg();
      i += 1;
    }
    AppMethodBeat.o(104456);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(104458);
    j localj;
    if ((this.gmI != null) && (!this.gmO))
    {
      this.gmO = true;
      if (paramInt2 == -434)
      {
        if (!this.gmD) {
          break label93;
        }
        localj = j.gmz;
        j.dq(true);
        g.ajR().ajA().set(am.a.IKS, Boolean.TRUE);
      }
    }
    for (;;)
    {
      this.gmI.b(paramInt1, paramInt2, paramString, paramBoolean);
      if (paramInt2 == 0)
      {
        paramString = j.gmz;
        j.afe();
      }
      AppMethodBeat.o(104458);
      return;
      label93:
      localj = j.gmz;
      j.dp(true);
      g.ajR().ajA().set(am.a.IKR, Boolean.TRUE);
    }
  }
  
  private void afg()
  {
    Object localObject = null;
    int i = 1;
    int j = 0;
    label41:
    label316:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(104457);
        if (this.bsb)
        {
          AppMethodBeat.o(104457);
          return;
        }
        Iterator localIterator = this.gmJ.iterator();
        if (!localIterator.hasNext()) {
          break label316;
        }
        c localc2 = (c)localIterator.next();
        if (!localc2.completed) {
          if (!localc2.running)
          {
            localObject = localc2;
            i = j;
            if (localObject == null)
            {
              if (i != 0)
              {
                ae.w("MicroMsg.EmojiUploadHelper", "all parts finished but not completed");
                a(4, 4, null, false);
              }
              AppMethodBeat.o(104457);
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
        break label41;
        if (this.gmM >= this.gmK)
        {
          ae.w("MicroMsg.EmojiUploadHelper", "req count is %d, max is %d; toRun part is %d", new Object[] { Integer.valueOf(this.gmM), Integer.valueOf(this.gmK), Integer.valueOf(localc1.index) });
          a(3, -2, null, false);
          AppMethodBeat.o(104457);
          break;
        }
        this.gmM += 1;
        localc1.retryCount += 1;
        localc1.running = true;
        ae.i("MicroMsg.EmojiUploadHelper", "start part %d, retry count %d", new Object[] { Integer.valueOf(localc1.index), Integer.valueOf(localc1.retryCount) });
        new a(this.glt, localc1, this.gmD, this.gmE, this.gmF, this.gmG, this.gmH).aET().g(new com.tencent.mm.vending.c.a() {});
        AppMethodBeat.o(104457);
        break;
      }
    }
  }
  
  public final class a
    extends com.tencent.mm.ak.a<agt>
  {
    public a(k.c paramc, boolean paramBoolean1, boolean paramBoolean2, String paramString1, List<String> paramList, String paramString2)
    {
      AppMethodBeat.i(104454);
      this$1 = new ags();
      dtg localdtg = new dtg();
      localdtg.MD5 = paramc.Lj();
      localdtg.xsC = paramBoolean1.start;
      localdtg.xsB = paramc.field_size;
      localdtg.HYW = paramBoolean2;
      localdtg.GwG = paramList;
      Object localObject;
      localdtg.HYY = localObject;
      localdtg.GwI = paramc.field_lensId;
      localdtg.GwH = paramc.field_attachTextColor;
      if (paramString2 != null) {
        localdtg.HYX.addAll(paramString2);
      }
      if (paramBoolean2) {}
      for (int i = 1;; i = 0)
      {
        k.this.uqG = i;
        k.this.GwY.add(localdtg);
        k.this.Gxa = paramString1;
        localdtg.HYV = new b(a(paramc, paramBoolean1.start, paramBoolean1.cSL));
        paramc = new b.a();
        paramc.hQF = k.this;
        paramc.hQG = new agt();
        paramc.uri = "/cgi-bin/micromsg-bin/mmemojiupload";
        paramc.funcId = 703;
        c(paramc.aDS());
        AppMethodBeat.o(104454);
        return;
      }
    }
    
    private byte[] a(EmojiInfo paramEmojiInfo, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(104455);
      Object localObject;
      if ((paramEmojiInfo.field_reserved4 & EmojiInfo.OAp) == EmojiInfo.OAp)
      {
        localObject = ((d)g.ad(d.class)).getProvider().a(paramEmojiInfo);
        if (!bu.cF((byte[])localObject))
        {
          paramEmojiInfo = new byte[paramInt2];
          ae.d("CgiEmojiUpload", "total length:%d dataLen:%d ", new Object[] { Integer.valueOf(localObject.length), Integer.valueOf(paramInt2) });
          System.arraycopy(localObject, paramInt1, paramEmojiInfo, 0, paramInt2);
        }
      }
      for (;;)
      {
        localObject = paramEmojiInfo;
        if (paramEmojiInfo == null) {
          localObject = new byte[0];
        }
        AppMethodBeat.o(104455);
        return localObject;
        ae.w("CgiEmojiUpload", "buffer is null.");
        paramEmojiInfo = new byte[0];
        continue;
        synchronized (k.b(k.this))
        {
          paramEmojiInfo.field_start = paramInt1;
          localObject = paramEmojiInfo.jD(paramInt1, paramInt2);
          paramEmojiInfo.field_start = 0;
          paramEmojiInfo = (EmojiInfo)localObject;
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void b(int paramInt1, int paramInt2, String paramString, boolean paramBoolean);
  }
  
  final class c
  {
    public int cSL;
    public boolean completed;
    public int index;
    public int retryCount;
    public boolean running;
    public int start;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.k
 * JD-Core Version:    0.7.0.1
 */