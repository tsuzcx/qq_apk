package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.cn.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.protocal.protobuf.agj;
import com.tencent.mm.protocal.protobuf.agk;
import com.tencent.mm.protocal.protobuf.dsj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
{
  private static int gkh = 98304;
  private static int gki = 4;
  private boolean bsb;
  private final EmojiInfo gjb;
  private boolean gkj;
  private boolean gkk;
  private String gkl;
  private List<String> gkm;
  private String gkn;
  public b gko;
  private List<c> gkp;
  private int gkq;
  private int gkr;
  private int gks;
  private long gkt;
  private boolean gku;
  
  public k(EmojiInfo paramEmojiInfo, boolean paramBoolean, String paramString1, List<String> paramList, String paramString2)
  {
    AppMethodBeat.i(104456);
    this.bsb = false;
    this.gkp = new ArrayList();
    this.gkr = 2;
    ad.i("MicroMsg.EmojiUploadHelper", "EmojiUploadHelper: isCapture %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.gjb = paramEmojiInfo;
    this.gkj = paramBoolean;
    this.gkk = true;
    this.gkl = paramString1;
    this.gkm = paramList;
    this.gkn = paramString2;
    this.gkt = System.currentTimeMillis();
    int m = paramEmojiInfo.field_size;
    int n = (int)Math.ceil(m * 1.0D / gkh);
    this.gkq = (n * 2);
    this.gks = 0;
    int i = 0;
    while (i < n)
    {
      int i1 = i * gkh;
      int k = gkh;
      int j = k;
      if (i1 + k > m) {
        j = m - i1;
      }
      paramString1 = new c((byte)0);
      paramString1.index = i;
      paramString1.start = i1;
      paramString1.cSb = j;
      this.gkp.add(paramString1);
      i += 1;
    }
    ad.i("MicroMsg.EmojiUploadHelper", "start upload emoji, md5 %s, totalLen %d, parts %d, file %s", new Object[] { paramEmojiInfo.Lb(), Integer.valueOf(m), Integer.valueOf(n), paramEmojiInfo.gzQ() });
    i = 0;
    while (i < gki)
    {
      aeS();
      i += 1;
    }
    AppMethodBeat.o(104456);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(104458);
    j localj;
    if ((this.gko != null) && (!this.gku))
    {
      this.gku = true;
      if (paramInt2 == -434)
      {
        if (!this.gkj) {
          break label93;
        }
        localj = j.gkf;
        j.dq(true);
        g.ajC().ajl().set(al.a.Iqw, Boolean.TRUE);
      }
    }
    for (;;)
    {
      this.gko.b(paramInt1, paramInt2, paramString, paramBoolean);
      if (paramInt2 == 0)
      {
        paramString = j.gkf;
        j.aeQ();
      }
      AppMethodBeat.o(104458);
      return;
      label93:
      localj = j.gkf;
      j.dp(true);
      g.ajC().ajl().set(al.a.Iqv, Boolean.TRUE);
    }
  }
  
  private void aeS()
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
        Iterator localIterator = this.gkp.iterator();
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
                ad.w("MicroMsg.EmojiUploadHelper", "all parts finished but not completed");
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
        if (this.gks >= this.gkq)
        {
          ad.w("MicroMsg.EmojiUploadHelper", "req count is %d, max is %d; toRun part is %d", new Object[] { Integer.valueOf(this.gks), Integer.valueOf(this.gkq), Integer.valueOf(localc1.index) });
          a(3, -2, null, false);
          AppMethodBeat.o(104457);
          break;
        }
        this.gks += 1;
        localc1.retryCount += 1;
        localc1.running = true;
        ad.i("MicroMsg.EmojiUploadHelper", "start part %d, retry count %d", new Object[] { Integer.valueOf(localc1.index), Integer.valueOf(localc1.retryCount) });
        new a(this.gjb, localc1, this.gkj, this.gkk, this.gkl, this.gkm, this.gkn).aED().g(new com.tencent.mm.vending.c.a() {});
        AppMethodBeat.o(104457);
        break;
      }
    }
  }
  
  public final class a
    extends com.tencent.mm.al.a<agk>
  {
    public a(k.c paramc, boolean paramBoolean1, boolean paramBoolean2, String paramString1, List<String> paramList, String paramString2)
    {
      AppMethodBeat.i(104454);
      this$1 = new agj();
      dsj localdsj = new dsj();
      localdsj.MD5 = paramc.Lb();
      localdsj.xcL = paramBoolean1.start;
      localdsj.xcK = paramc.field_size;
      localdsj.HFj = paramBoolean2;
      localdsj.GdZ = paramList;
      Object localObject;
      localdsj.HFl = localObject;
      localdsj.Geb = paramc.field_lensId;
      localdsj.Gea = paramc.field_attachTextColor;
      if (paramString2 != null) {
        localdsj.HFk.addAll(paramString2);
      }
      if (paramBoolean2) {}
      for (int i = 1;; i = 0)
      {
        k.this.FAu = i;
        k.this.Ger.add(localdsj);
        k.this.Get = paramString1;
        localdsj.HFi = new b(a(paramc, paramBoolean1.start, paramBoolean1.cSb));
        paramc = new b.a();
        paramc.hNM = k.this;
        paramc.hNN = new agk();
        paramc.uri = "/cgi-bin/micromsg-bin/mmemojiupload";
        paramc.funcId = 703;
        c(paramc.aDC());
        AppMethodBeat.o(104454);
        return;
      }
    }
    
    private byte[] a(EmojiInfo paramEmojiInfo, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(104455);
      Object localObject;
      if ((paramEmojiInfo.field_reserved4 & EmojiInfo.Ofi) == EmojiInfo.Ofi)
      {
        localObject = ((d)g.ad(d.class)).getProvider().a(paramEmojiInfo);
        if (!bt.cC((byte[])localObject))
        {
          paramEmojiInfo = new byte[paramInt2];
          ad.d("CgiEmojiUpload", "total length:%d dataLen:%d ", new Object[] { Integer.valueOf(localObject.length), Integer.valueOf(paramInt2) });
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
        ad.w("CgiEmojiUpload", "buffer is null.");
        paramEmojiInfo = new byte[0];
        continue;
        synchronized (k.b(k.this))
        {
          paramEmojiInfo.field_start = paramInt1;
          localObject = paramEmojiInfo.lG(paramInt1, paramInt2);
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
    public int cSb;
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