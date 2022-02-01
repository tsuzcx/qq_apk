package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.cn.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.protocal.protobuf.aea;
import com.tencent.mm.protocal.protobuf.aeb;
import com.tencent.mm.protocal.protobuf.dms;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vending.c.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
{
  private static int fQH = 98304;
  private static int fQI = 4;
  private boolean bhH;
  private final EmojiInfo fPB;
  private boolean fQJ;
  private boolean fQK;
  private String fQL;
  private List<String> fQM;
  private String fQN;
  public b fQO;
  private List<c> fQP;
  private int fQQ;
  private int fQR;
  private int fQS;
  private long fQT;
  private boolean fQU;
  
  public k(EmojiInfo paramEmojiInfo, boolean paramBoolean, String paramString1, List<String> paramList, String paramString2)
  {
    AppMethodBeat.i(104456);
    this.bhH = false;
    this.fQP = new ArrayList();
    this.fQR = 2;
    ac.i("MicroMsg.EmojiUploadHelper", "EmojiUploadHelper: isCapture %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.fPB = paramEmojiInfo;
    this.fQJ = paramBoolean;
    this.fQK = true;
    this.fQL = paramString1;
    this.fQM = paramList;
    this.fQN = paramString2;
    this.fQT = System.currentTimeMillis();
    int m = paramEmojiInfo.field_size;
    int n = (int)Math.ceil(m * 1.0D / fQH);
    this.fQQ = (n * 2);
    this.fQS = 0;
    int i = 0;
    while (i < n)
    {
      int i1 = i * fQH;
      int k = fQH;
      int j = k;
      if (i1 + k > m) {
        j = m - i1;
      }
      paramString1 = new c((byte)0);
      paramString1.index = i;
      paramString1.start = i1;
      paramString1.cGX = j;
      this.fQP.add(paramString1);
      i += 1;
    }
    ac.i("MicroMsg.EmojiUploadHelper", "start upload emoji, md5 %s, totalLen %d, parts %d, file %s", new Object[] { paramEmojiInfo.JC(), Integer.valueOf(m), Integer.valueOf(n), paramEmojiInfo.ghd() });
    i = 0;
    while (i < fQI)
    {
      aco();
      i += 1;
    }
    AppMethodBeat.o(104456);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(104458);
    j localj;
    if ((this.fQO != null) && (!this.fQU))
    {
      this.fQU = true;
      if (paramInt2 == -434)
      {
        if (!this.fQJ) {
          break label93;
        }
        localj = j.fQF;
        j.jdMethod_do(true);
        g.agR().agA().set(ah.a.GEd, Boolean.TRUE);
      }
    }
    for (;;)
    {
      this.fQO.b(paramInt1, paramInt2, paramString, paramBoolean);
      if (paramInt2 == 0)
      {
        paramString = j.fQF;
        j.acm();
      }
      AppMethodBeat.o(104458);
      return;
      label93:
      localj = j.fQF;
      j.dn(true);
      g.agR().agA().set(ah.a.GEc, Boolean.TRUE);
    }
  }
  
  private void aco()
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
        if (this.bhH)
        {
          AppMethodBeat.o(104457);
          return;
        }
        Iterator localIterator = this.fQP.iterator();
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
                ac.w("MicroMsg.EmojiUploadHelper", "all parts finished but not completed");
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
        if (this.fQS >= this.fQQ)
        {
          ac.w("MicroMsg.EmojiUploadHelper", "req count is %d, max is %d; toRun part is %d", new Object[] { Integer.valueOf(this.fQS), Integer.valueOf(this.fQQ), Integer.valueOf(localc1.index) });
          a(3, -2, null, false);
          AppMethodBeat.o(104457);
          break;
        }
        this.fQS += 1;
        localc1.retryCount += 1;
        localc1.running = true;
        ac.i("MicroMsg.EmojiUploadHelper", "start part %d, retry count %d", new Object[] { Integer.valueOf(localc1.index), Integer.valueOf(localc1.retryCount) });
        new a(this.fPB, localc1, this.fQJ, this.fQK, this.fQL, this.fQM, this.fQN).aBB().g(new a() {});
        AppMethodBeat.o(104457);
        break;
      }
    }
  }
  
  public final class a
    extends c<aeb>
  {
    public a(k.c paramc, boolean paramBoolean1, boolean paramBoolean2, String paramString1, List<String> paramList, String paramString2)
    {
      AppMethodBeat.i(104454);
      this$1 = new aea();
      dms localdms = new dms();
      localdms.MD5 = paramc.JC();
      localdms.vTI = paramBoolean1.start;
      localdms.vTH = paramc.field_size;
      localdms.FUv = paramBoolean2;
      localdms.Eww = paramList;
      Object localObject;
      localdms.FUx = localObject;
      localdms.Ewy = paramc.field_lensId;
      localdms.Ewx = paramc.field_attachTextColor;
      if (paramString2 != null) {
        localdms.FUw.addAll(paramString2);
      }
      if (paramBoolean2) {}
      for (int i = 1;; i = 0)
      {
        k.this.DUZ = i;
        k.this.EwO.add(localdms);
        k.this.EwQ = paramString1;
        localdms.FUu = new b(a(paramc, paramBoolean1.start, paramBoolean1.cGX));
        paramc = new b.a();
        paramc.hvt = k.this;
        paramc.hvu = new aeb();
        paramc.uri = "/cgi-bin/micromsg-bin/mmemojiupload";
        paramc.funcId = 703;
        this.rr = paramc.aAz();
        AppMethodBeat.o(104454);
        return;
      }
    }
    
    private byte[] a(EmojiInfo paramEmojiInfo, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(104455);
      Object localObject;
      if ((paramEmojiInfo.field_reserved4 & EmojiInfo.Kgm) == EmojiInfo.Kgm)
      {
        localObject = ((d)g.ad(d.class)).getProvider().a(paramEmojiInfo);
        if (!bs.cv((byte[])localObject))
        {
          paramEmojiInfo = new byte[paramInt2];
          ac.d("CgiEmojiUpload", "total length:%d dataLen:%d ", new Object[] { Integer.valueOf(localObject.length), Integer.valueOf(paramInt2) });
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
        ac.w("CgiEmojiUpload", "buffer is null.");
        paramEmojiInfo = new byte[0];
        continue;
        synchronized (k.b(k.this))
        {
          paramEmojiInfo.field_start = paramInt1;
          localObject = paramEmojiInfo.jn(paramInt1, paramInt2);
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
    public int cGX;
    public boolean completed;
    public int index;
    public int retryCount;
    public boolean running;
    public int start;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.k
 * JD-Core Version:    0.7.0.1
 */