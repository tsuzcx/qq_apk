package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.c;
import com.tencent.mm.al.c.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.co.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.protocal.protobuf.adb;
import com.tencent.mm.protocal.protobuf.adc;
import com.tencent.mm.protocal.protobuf.dhd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vending.c.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j
{
  private static int fMW = 98304;
  private static int fMX = 4;
  private boolean bhb;
  private final EmojiInfo fLP;
  private boolean fMY;
  private boolean fMZ;
  private String fNa;
  private List<String> fNb;
  private String fNc;
  public b fNd;
  private List<c> fNe;
  private int fNf;
  private int fNg;
  private int fNh;
  private long fNi;
  private boolean fNj;
  
  public j(EmojiInfo paramEmojiInfo, boolean paramBoolean, String paramString1, List<String> paramList, String paramString2)
  {
    AppMethodBeat.i(104456);
    this.bhb = false;
    this.fNe = new ArrayList();
    this.fNg = 2;
    ad.i("MicroMsg.EmojiUploadHelper", "EmojiUploadHelper: isCapture %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.fLP = paramEmojiInfo;
    this.fMY = paramBoolean;
    this.fMZ = true;
    this.fNa = paramString1;
    this.fNb = paramList;
    this.fNc = paramString2;
    this.fNi = System.currentTimeMillis();
    int m = paramEmojiInfo.field_size;
    int n = (int)Math.ceil(m * 1.0D / fMW);
    this.fNf = (n * 2);
    this.fNh = 0;
    int i = 0;
    while (i < n)
    {
      int i1 = i * fMW;
      int k = fMW;
      int j = k;
      if (i1 + k > m) {
        j = m - i1;
      }
      paramString1 = new c((byte)0);
      paramString1.index = i;
      paramString1.start = i1;
      paramString1.cJQ = j;
      this.fNe.add(paramString1);
      i += 1;
    }
    ad.i("MicroMsg.EmojiUploadHelper", "start upload emoji, md5 %s, totalLen %d, parts %d, file %s", new Object[] { paramEmojiInfo.JS(), Integer.valueOf(m), Integer.valueOf(n), paramEmojiInfo.gaa() });
    i = 0;
    while (i < fMX)
    {
      abp();
      i += 1;
    }
    AppMethodBeat.o(104456);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(104458);
    i locali;
    if ((this.fNd != null) && (!this.fNj))
    {
      this.fNj = true;
      if (paramInt2 == -434)
      {
        if (!this.fMY) {
          break label93;
        }
        locali = i.fMT;
        i.dp(true);
        g.afB().afk().set(ae.a.Fgp, Boolean.TRUE);
      }
    }
    for (;;)
    {
      this.fNd.b(paramInt1, paramInt2, paramString, paramBoolean);
      if (paramInt2 == 0)
      {
        paramString = i.fMT;
        i.abn();
      }
      AppMethodBeat.o(104458);
      return;
      label93:
      locali = i.fMT;
      i.jdMethod_do(true);
      g.afB().afk().set(ae.a.Fgo, Boolean.TRUE);
    }
  }
  
  private void abp()
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
        if (this.bhb)
        {
          AppMethodBeat.o(104457);
          return;
        }
        Iterator localIterator = this.fNe.iterator();
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
        if (this.fNh >= this.fNf)
        {
          ad.w("MicroMsg.EmojiUploadHelper", "req count is %d, max is %d; toRun part is %d", new Object[] { Integer.valueOf(this.fNh), Integer.valueOf(this.fNf), Integer.valueOf(localc1.index) });
          a(3, -2, null, false);
          AppMethodBeat.o(104457);
          break;
        }
        this.fNh += 1;
        localc1.retryCount += 1;
        localc1.running = true;
        ad.i("MicroMsg.EmojiUploadHelper", "start part %d, retry count %d", new Object[] { Integer.valueOf(localc1.index), Integer.valueOf(localc1.retryCount) });
        new a(this.fLP, localc1, this.fMY, this.fMZ, this.fNa, this.fNb, this.fNc).auK().g(new a() {});
        AppMethodBeat.o(104457);
        break;
      }
    }
  }
  
  public final class a
    extends c<adc>
  {
    public a(j.c paramc, boolean paramBoolean1, boolean paramBoolean2, String paramString1, List<String> paramList, String paramString2)
    {
      AppMethodBeat.i(104454);
      this$1 = new adb();
      dhd localdhd = new dhd();
      localdhd.MD5 = paramc.JS();
      localdhd.uKR = paramBoolean1.start;
      localdhd.uKQ = paramc.field_size;
      localdhd.Ext = paramBoolean2;
      localdhd.Ddq = paramList;
      Object localObject;
      localdhd.Exv = localObject;
      localdhd.Dds = paramc.field_lensId;
      localdhd.Ddr = paramc.field_attachTextColor;
      if (paramString2 != null) {
        localdhd.Exu.addAll(paramString2);
      }
      if (paramBoolean2) {}
      for (int i = 1;; i = 0)
      {
        j.this.CCC = i;
        j.this.DdI.add(localdhd);
        j.this.DdK = paramString1;
        localdhd.Exs = new b(a(paramc, paramBoolean1.start, paramBoolean1.cJQ));
        paramc = new b.a();
        paramc.gUU = j.this;
        paramc.gUV = new adc();
        paramc.uri = "/cgi-bin/micromsg-bin/mmemojiupload";
        paramc.funcId = 703;
        this.rr = paramc.atI();
        AppMethodBeat.o(104454);
        return;
      }
    }
    
    private byte[] a(EmojiInfo paramEmojiInfo, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(104455);
      Object localObject;
      if ((paramEmojiInfo.field_reserved4 & EmojiInfo.LCl) == EmojiInfo.LCl)
      {
        localObject = ((d)g.ad(d.class)).getProvider().a(paramEmojiInfo);
        if (!bt.cw((byte[])localObject))
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
        synchronized (j.b(j.this))
        {
          paramEmojiInfo.field_start = paramInt1;
          localObject = paramEmojiInfo.lk(paramInt1, paramInt2);
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
    public int cJQ;
    public boolean completed;
    public int index;
    public int retryCount;
    public boolean running;
    public int start;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.j
 * JD-Core Version:    0.7.0.1
 */