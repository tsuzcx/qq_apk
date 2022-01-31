package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ck.f;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{
  private static int iYV = 98304;
  private static int iYW = 4;
  private boolean aES = false;
  private final EmojiInfo hNs;
  private boolean iYX;
  private boolean iYY;
  private String iYZ;
  private List<String> iZa;
  private String iZb;
  public a.b iZc;
  private List<a.c> iZd = new ArrayList();
  private int iZe;
  private int iZf = 2;
  private int iZg;
  private long iZh;
  
  public a(EmojiInfo paramEmojiInfo, boolean paramBoolean1, boolean paramBoolean2, String paramString1, List<String> paramList, String paramString2)
  {
    this.hNs = paramEmojiInfo;
    this.iYX = paramBoolean1;
    this.iYY = paramBoolean2;
    this.iYZ = paramString1;
    this.iZa = paramList;
    this.iZb = paramString2;
    this.iZh = System.currentTimeMillis();
    int m = paramEmojiInfo.field_size;
    int n = (int)Math.ceil(m * 1.0D / iYV);
    this.iZe = (n * 2);
    this.iZg = 0;
    int i = 0;
    while (i < n)
    {
      int i1 = i * iYV;
      int k = iYV;
      int j = k;
      if (i1 + k > m) {
        j = m - i1;
      }
      paramString1 = new a.c(this, (byte)0);
      paramString1.index = i;
      paramString1.start = i1;
      paramString1.bvi = j;
      this.iZd.add(paramString1);
      i += 1;
    }
    y.i("MicroMsg.EmojiUploadHelper", "start upload emoji, md5 %s, totalLen %d, parts %d", new Object[] { paramEmojiInfo.Wv(), Integer.valueOf(m), Integer.valueOf(n) });
    i = 0;
    while (i < iYW)
    {
      aHX();
      i += 1;
    }
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    if (this.iZc != null) {
      this.iZc.b(paramInt1, paramInt2, paramString, paramBoolean);
    }
  }
  
  private void aHX()
  {
    Object localObject = null;
    int i = 1;
    int j = 0;
    label32:
    label302:
    for (;;)
    {
      try
      {
        boolean bool = this.aES;
        if (bool) {
          return;
        }
        Iterator localIterator = this.iZd.iterator();
        if (!localIterator.hasNext()) {
          break label302;
        }
        a.c localc2 = (a.c)localIterator.next();
        if (!localc2.iZk) {
          if (!localc2.bDX)
          {
            localObject = localc2;
            i = j;
            if (localObject == null)
            {
              if (i == 0) {
                continue;
              }
              y.w("MicroMsg.EmojiUploadHelper", "all parts finished but not completed");
              a(4, -2, null, false);
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
        break label32;
        if (this.iZg >= this.iZe)
        {
          y.w("MicroMsg.EmojiUploadHelper", "req count is %d, max is %d; toRun part is %d", new Object[] { Integer.valueOf(this.iZg), Integer.valueOf(this.iZe), Integer.valueOf(localc1.index) });
          a(3, -2, null, false);
          break;
        }
        this.iZg += 1;
        localc1.retryCount += 1;
        localc1.bDX = true;
        y.i("MicroMsg.EmojiUploadHelper", "start part %d, retry count %d", new Object[] { Integer.valueOf(localc1.index), Integer.valueOf(localc1.retryCount) });
        new a.a(this, this.hNs, localc1, this.iYX, this.iYY, this.iYZ, this.iZa, this.iZb).Km().g(new a.1(this, localc1));
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.a
 * JD-Core Version:    0.7.0.1
 */