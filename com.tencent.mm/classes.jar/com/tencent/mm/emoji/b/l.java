package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.co.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.protocal.protobuf.ajb;
import com.tencent.mm.protocal.protobuf.ajc;
import com.tencent.mm.protocal.protobuf.ene;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vending.c.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class l
{
  private static int gXt = 98304;
  private static int gXu = 4;
  private boolean brW;
  private final EmojiInfo gWm;
  public b gXA;
  private List<c> gXB;
  private int gXC;
  private int gXD;
  private int gXE;
  private long gXF;
  private boolean gXG;
  private boolean gXv;
  private boolean gXw;
  private String gXx;
  private List<String> gXy;
  private String gXz;
  
  public l(EmojiInfo paramEmojiInfo, boolean paramBoolean, String paramString1, List<String> paramList, String paramString2)
  {
    AppMethodBeat.i(104456);
    this.brW = false;
    this.gXB = new ArrayList();
    this.gXD = 2;
    Log.i("MicroMsg.EmojiUploadHelper", "EmojiUploadHelper: isCapture %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.gWm = paramEmojiInfo;
    this.gXv = paramBoolean;
    this.gXw = true;
    this.gXx = paramString1;
    this.gXy = paramList;
    this.gXz = paramString2;
    this.gXF = System.currentTimeMillis();
    int m = paramEmojiInfo.field_size;
    int n = (int)Math.ceil(m * 1.0D / gXt);
    this.gXC = (n * 2);
    this.gXE = 0;
    int i = 0;
    while (i < n)
    {
      int i1 = i * gXt;
      int k = gXt;
      int j = k;
      if (i1 + k > m) {
        j = m - i1;
      }
      paramString1 = new c((byte)0);
      paramString1.index = i;
      paramString1.start = i1;
      paramString1.djh = j;
      this.gXB.add(paramString1);
      i += 1;
    }
    Log.i("MicroMsg.EmojiUploadHelper", "start upload emoji, md5 %s, totalLen %d, parts %d, file %s", new Object[] { paramEmojiInfo.getMd5(), Integer.valueOf(m), Integer.valueOf(n), paramEmojiInfo.hRM() });
    i = 0;
    while (i < gXu)
    {
      auU();
      i += 1;
    }
    AppMethodBeat.o(104456);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(104458);
    k localk;
    if ((this.gXA != null) && (!this.gXG))
    {
      this.gXG = true;
      if (paramInt2 == -434)
      {
        if (!this.gXv) {
          break label93;
        }
        localk = k.gXr;
        k.ea(true);
        g.aAh().azQ().set(ar.a.NSQ, Boolean.TRUE);
      }
    }
    for (;;)
    {
      this.gXA.b(paramInt1, paramInt2, paramString, paramBoolean);
      if (paramInt2 == 0)
      {
        paramString = k.gXr;
        k.auS();
      }
      AppMethodBeat.o(104458);
      return;
      label93:
      localk = k.gXr;
      k.dZ(true);
      g.aAh().azQ().set(ar.a.NSP, Boolean.TRUE);
    }
  }
  
  private void auU()
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
        if (this.brW)
        {
          AppMethodBeat.o(104457);
          return;
        }
        Iterator localIterator = this.gXB.iterator();
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
                Log.w("MicroMsg.EmojiUploadHelper", "all parts finished but not completed");
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
        if (this.gXE >= this.gXC)
        {
          Log.w("MicroMsg.EmojiUploadHelper", "req count is %d, max is %d; toRun part is %d", new Object[] { Integer.valueOf(this.gXE), Integer.valueOf(this.gXC), Integer.valueOf(localc1.index) });
          a(3, -2, null, false);
          AppMethodBeat.o(104457);
          break;
        }
        this.gXE += 1;
        localc1.retryCount += 1;
        localc1.running = true;
        Log.i("MicroMsg.EmojiUploadHelper", "start part %d, retry count %d", new Object[] { Integer.valueOf(localc1.index), Integer.valueOf(localc1.retryCount) });
        new a(this.gWm, localc1, this.gXv, this.gXw, this.gXx, this.gXy, this.gXz).aYI().g(new a() {});
        AppMethodBeat.o(104457);
        break;
      }
    }
  }
  
  public final class a
    extends c<ajc>
  {
    public a(l.c paramc, boolean paramBoolean1, boolean paramBoolean2, String paramString1, List<String> paramList, String paramString2)
    {
      AppMethodBeat.i(104454);
      this$1 = new ajb();
      ene localene = new ene();
      localene.MD5 = paramc.getMd5();
      localene.BsG = paramBoolean1.start;
      localene.BsF = paramc.field_size;
      localene.Nld = paramBoolean2;
      localene.Lsm = paramList;
      Object localObject;
      localene.Nlf = localObject;
      localene.Lso = paramc.field_lensId;
      localene.Lsn = paramc.field_attachTextColor;
      if (paramString2 != null) {
        localene.Nle.addAll(paramString2);
      }
      if (paramBoolean2) {}
      for (int i = 1;; i = 0)
      {
        l.this.xIY = i;
        l.this.LsE.add(localene);
        l.this.LsG = paramString1;
        localene.Nlc = new b(a(paramc, paramBoolean1.start, paramBoolean1.djh));
        paramc = new d.a();
        paramc.iLN = l.this;
        paramc.iLO = new ajc();
        paramc.uri = "/cgi-bin/micromsg-bin/mmemojiupload";
        paramc.funcId = 703;
        c(paramc.aXF());
        AppMethodBeat.o(104454);
        return;
      }
    }
    
    private byte[] a(EmojiInfo paramEmojiInfo, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(104455);
      Object localObject;
      if ((paramEmojiInfo.field_reserved4 & EmojiInfo.UuK) == EmojiInfo.UuK)
      {
        localObject = ((d)g.ah(d.class)).getProvider().a(paramEmojiInfo);
        if (!Util.isNullOrNil((byte[])localObject))
        {
          paramEmojiInfo = new byte[paramInt2];
          Log.d("CgiEmojiUpload", "total length:%d dataLen:%d ", new Object[] { Integer.valueOf(localObject.length), Integer.valueOf(paramInt2) });
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
        Log.w("CgiEmojiUpload", "buffer is null.");
        paramEmojiInfo = new byte[0];
        continue;
        synchronized (l.b(l.this))
        {
          paramEmojiInfo.field_start = paramInt1;
          localObject = paramEmojiInfo.ht(paramInt1, paramInt2);
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
    public boolean completed;
    public int djh;
    public int index;
    public int retryCount;
    public boolean running;
    public int start;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.b.l
 * JD-Core Version:    0.7.0.1
 */