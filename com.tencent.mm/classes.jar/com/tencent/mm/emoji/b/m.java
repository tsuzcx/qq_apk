package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.c.a;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.b.e;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.protocal.protobuf.ajr;
import com.tencent.mm.protocal.protobuf.exm;
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

public final class m
{
  private static int jIr = 98304;
  private static int jIs = 4;
  private boolean bby;
  private final EmojiInfo jHh;
  private int jIA;
  private int jIB;
  private int jIC;
  private long jID;
  private boolean jIE;
  private boolean jIt;
  private boolean jIu;
  private String jIv;
  private List<String> jIw;
  private String jIx;
  public b jIy;
  private List<c> jIz;
  
  public m(EmojiInfo paramEmojiInfo, boolean paramBoolean, String paramString1, List<String> paramList, String paramString2)
  {
    AppMethodBeat.i(104456);
    this.bby = false;
    this.jIz = new ArrayList();
    this.jIB = 2;
    Log.i("MicroMsg.EmojiUploadHelper", "EmojiUploadHelper: isCapture %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.jHh = paramEmojiInfo;
    this.jIt = paramBoolean;
    this.jIu = true;
    this.jIv = paramString1;
    this.jIw = paramList;
    this.jIx = paramString2;
    this.jID = System.currentTimeMillis();
    int m = paramEmojiInfo.field_size;
    int n = (int)Math.ceil(m * 1.0D / jIr);
    this.jIA = (n * 2);
    this.jIC = 0;
    int i = 0;
    while (i < n)
    {
      int i1 = i * jIr;
      int k = jIr;
      int j = k;
      if (i1 + k > m) {
        j = m - i1;
      }
      paramString1 = new c((byte)0);
      paramString1.index = i;
      paramString1.start = i1;
      paramString1.faO = j;
      this.jIz.add(paramString1);
      i += 1;
    }
    Log.i("MicroMsg.EmojiUploadHelper", "start upload emoji, md5 %s, totalLen %d, parts %d, file %s", new Object[] { paramEmojiInfo.getMd5(), Integer.valueOf(m), Integer.valueOf(n), paramEmojiInfo.ifh() });
    i = 0;
    while (i < jIs)
    {
      aBP();
      i += 1;
    }
    AppMethodBeat.o(104456);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(104458);
    if ((this.jIy != null) && (!this.jIE))
    {
      this.jIE = true;
      if (paramInt2 == -434)
      {
        if (!this.jIt) {
          break label84;
        }
        h.aHG().aHp().set(ar.a.VgO, Boolean.TRUE);
      }
    }
    for (;;)
    {
      this.jIy.b(paramInt1, paramInt2, paramString, paramBoolean);
      if (paramInt2 == 0)
      {
        paramString = l.jIq;
        l.aBO();
      }
      AppMethodBeat.o(104458);
      return;
      label84:
      h.aHG().aHp().set(ar.a.VgN, Boolean.TRUE);
    }
  }
  
  private void aBP()
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
        if (this.bby)
        {
          AppMethodBeat.o(104457);
          return;
        }
        Iterator localIterator = this.jIz.iterator();
        if (!localIterator.hasNext()) {
          break label316;
        }
        c localc2 = (c)localIterator.next();
        if (!localc2.jIH) {
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
        if (this.jIC >= this.jIA)
        {
          Log.w("MicroMsg.EmojiUploadHelper", "req count is %d, max is %d; toRun part is %d", new Object[] { Integer.valueOf(this.jIC), Integer.valueOf(this.jIA), Integer.valueOf(localc1.index) });
          a(3, -2, null, false);
          AppMethodBeat.o(104457);
          break;
        }
        this.jIC += 1;
        localc1.retryCount += 1;
        localc1.running = true;
        Log.i("MicroMsg.EmojiUploadHelper", "start part %d, retry count %d", new Object[] { Integer.valueOf(localc1.index), Integer.valueOf(localc1.retryCount) });
        new a(this.jHh, localc1, this.jIt, this.jIu, this.jIv, this.jIw, this.jIx).bhW().g(new a() {});
        AppMethodBeat.o(104457);
        break;
      }
    }
  }
  
  public final class a
    extends c<ajr>
  {
    public a(m.c paramc, boolean paramBoolean1, boolean paramBoolean2, String paramString1, List<String> paramList, String paramString2)
    {
      AppMethodBeat.i(104454);
      this$1 = new ajq();
      exm localexm = new exm();
      localexm.MD5 = paramc.getMd5();
      localexm.Hna = paramBoolean1.start;
      localexm.HmZ = paramc.field_size;
      localexm.UxO = paramBoolean2;
      localexm.AttachedText = paramList;
      Object localObject;
      localexm.UxQ = localObject;
      localexm.LensId = paramc.field_lensId;
      localexm.AttachedTextColor = paramc.field_attachTextColor;
      if (paramString2 != null) {
        localexm.UxP.addAll(paramString2);
      }
      if (paramBoolean2) {}
      for (int i = 1;; i = 0)
      {
        m.this.CNe = i;
        m.this.Sud.add(localexm);
        m.this.Suf = paramString1;
        localexm.UxN = new b(a(paramc, paramBoolean1.start, paramBoolean1.faO));
        paramc = new d.a();
        paramc.lBU = m.this;
        paramc.lBV = new ajr();
        paramc.uri = "/cgi-bin/micromsg-bin/mmemojiupload";
        paramc.funcId = 703;
        c(paramc.bgN());
        AppMethodBeat.o(104454);
        return;
      }
    }
    
    private byte[] a(EmojiInfo paramEmojiInfo, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(104455);
      Object localObject;
      if ((paramEmojiInfo.field_reserved4 & EmojiInfo.ZuM) == EmojiInfo.ZuM)
      {
        localObject = ((d)h.ag(d.class)).getProvider().a(paramEmojiInfo);
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
        synchronized (m.b(m.this))
        {
          paramEmojiInfo.field_start = paramInt1;
          localObject = paramEmojiInfo.oH(paramInt1, paramInt2);
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
    public int faO;
    public int index;
    public boolean jIH;
    public int retryCount;
    public boolean running;
    public int start;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.b.m
 * JD-Core Version:    0.7.0.1
 */