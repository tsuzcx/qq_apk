package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.j.f.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.facedetect.model.e;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  implements f
{
  public int jMm = -1;
  public d jMn = null;
  public c jMo = null;
  public boolean jMp = false;
  public boolean jMq = false;
  public long jMr = 0L;
  public int jMs = 0;
  public m jMt = null;
  public m jMu = null;
  public long jMv = -1L;
  public int jMw = -1;
  public int jMx;
  public f.a jMy = new a.1(this);
  
  public a(int paramInt1, int paramInt2)
  {
    this.jMm = paramInt1;
    this.jMx = paramInt2;
  }
  
  public final void aNS()
  {
    if (this.jMu != null) {
      g.Dk().b(this.jMu.getType(), this);
    }
  }
  
  public final void l(int paramInt1, int paramInt2, String paramString)
  {
    ai.d(new a.2(this, paramInt1, paramInt2, paramString));
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool = false;
    y.i("MicroMsg.FaceUploadProcessor", "hy: scene: %s, errType: %d, errCode: %d, errMsg: %s", new Object[] { paramm.toString(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (((paramm instanceof u)) || ((paramm instanceof v))) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (b)paramm;
        this.jMr = paramString.aNT();
        e.el(this.jMr);
        if (paramString.aNU() == null)
        {
          y.e("MicroMsg.FaceUploadProcessor", "hy: backend not return config");
          l(2, 90015, "face motion config from server is null");
        }
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramString = paramString.aNU();
            paramInt1 = paramString.length;
            if (this.jMn == null) {
              bool = true;
            }
            y.i("MicroMsg.FaceUploadProcessor", "configLen: %d, mUploadCallback == null: %b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(bool) });
          } while (this.jMo == null);
          this.jMo.e(this.jMr, paramString);
          return;
        } while (this.jMo == null);
        this.jMo.ad(paramInt1, "get face bio config failed");
        return;
      } while ((this.jMu == null) || (paramm.getType() != this.jMu.getType()));
      this.jMw = ((int)(System.currentTimeMillis() - this.jMv));
    } while (this.jMn == null);
    this.jMn.h(paramInt1, paramInt2, paramString, paramm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.a
 * JD-Core Version:    0.7.0.1
 */