package com.tencent.mm.modelvoiceaddr;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.f.b.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac;

public final class f
  implements com.tencent.mm.ah.f
{
  public static int bEl = 100;
  private static final String eLH = ac.dOP + "tmp_voiceaddr.spx";
  private static final String eLI = ac.dOP + "tmp_voiceaddr.amr";
  private c.a bCP = new f.1(this);
  com.tencent.mm.f.b.c bCc;
  public int eLC = 1;
  public int eLJ = 0;
  int eLK = 0;
  boolean eLL = false;
  private int eLM = 500000;
  public boolean eLN = false;
  b eLO = null;
  com.tencent.mm.f.c.a eLP;
  com.tencent.qqpinyin.voicerecoapi.c eLQ = null;
  private a eLR = null;
  ah handler = new f.2(this);
  
  public f(b paramb, int paramInt)
  {
    this.eLO = paramb;
    this.eLC = paramInt;
    if (this.eLC == 1) {}
    for (paramInt = i;; paramInt = 1500000)
    {
      this.eLM = paramInt;
      return;
    }
  }
  
  private void finish()
  {
    y.i("MicroMsg.SceneVoiceAddr", "finish");
    y.l("MicroMsg.SceneVoiceAddr", "finish", new Object[0]);
    if (this.eLR != null) {
      this.eLR.Tp();
    }
    this.handler.sendEmptyMessage(2);
    if (!this.eLL) {
      this.handler.sendEmptyMessage(3);
    }
    reset();
  }
  
  private void reset()
  {
    y.i("MicroMsg.SceneVoiceAddr", "reset");
    try
    {
      if (this.bCc != null)
      {
        this.bCc.uh();
        this.bCc = null;
      }
      if (this.eLP != null)
      {
        this.eLP.uE();
        this.eLP = null;
      }
      if (this.eLQ != null) {
        this.eLQ.stop();
      }
      this.eLQ = null;
      if (this.eLR != null)
      {
        this.eLR.Tp();
        this.eLR = null;
      }
      this.eLK = 0;
      this.eLL = false;
      return;
    }
    finally {}
  }
  
  public final void cancel()
  {
    this.eLO = null;
    finish();
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    long l;
    if (this.eLC == 0)
    {
      y.d("MicroMsg.SceneVoiceAddr", "removeSceneEndListener MMFunc_UploadInputVoice");
      g.Dk().b(349, this);
      paramString = ((a)paramm).Tq();
      l = ((a)paramm).Tr();
      if (paramString != null) {
        break label125;
      }
    }
    label125:
    for (int i = -1;; i = paramString.length)
    {
      y.i("MicroMsg.SceneVoiceAddr", "onSceneEnd errType:%d errCode:%d list:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      if (this.eLO != null)
      {
        if ((paramInt2 == 0) && (paramInt1 == 0)) {
          break label132;
        }
        this.eLO.Tx();
        cancel();
      }
      return;
      g.Dk().b(206, this);
      break;
    }
    label132:
    this.eLO.a(paramString, l);
  }
  
  public static abstract interface b
  {
    public abstract void Tx();
    
    public abstract void Ty();
    
    public abstract void a(String[] paramArrayOfString, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.f
 * JD-Core Version:    0.7.0.1
 */