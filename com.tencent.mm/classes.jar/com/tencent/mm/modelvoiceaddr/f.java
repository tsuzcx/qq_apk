package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.ac;

public final class f
  implements com.tencent.mm.ai.f
{
  public static int ckX;
  private static final String gbo;
  private static final String gbp;
  com.tencent.mm.audio.b.c ciR;
  private c.a cjD;
  public int gbj;
  public int gbq;
  int gbr;
  boolean gbs;
  private int gbt;
  public boolean gbu;
  f.b gbv;
  com.tencent.mm.audio.e.a gbw;
  com.tencent.qqpinyin.voicerecoapi.c gbx;
  private a gby;
  ak handler;
  
  static
  {
    AppMethodBeat.i(116703);
    gbo = ac.eQv + "tmp_voiceaddr.spx";
    gbp = ac.eQv + "tmp_voiceaddr.amr";
    ckX = 100;
    AppMethodBeat.o(116703);
  }
  
  public f(f.b paramb, int paramInt)
  {
    AppMethodBeat.i(116696);
    this.gbj = 1;
    this.gbq = 0;
    this.gbr = 0;
    this.gbs = false;
    this.gbt = 500000;
    this.gbu = false;
    this.gbv = null;
    this.gbx = null;
    this.gby = null;
    this.cjD = new f.1(this);
    this.handler = new f.2(this);
    this.gbv = paramb;
    this.gbj = paramInt;
    if (this.gbj == 1) {}
    for (paramInt = i;; paramInt = 1500000)
    {
      this.gbt = paramInt;
      AppMethodBeat.o(116696);
      return;
    }
  }
  
  private void finish()
  {
    AppMethodBeat.i(116698);
    ab.i("MicroMsg.SceneVoiceAddr", "finish");
    ab.b("MicroMsg.SceneVoiceAddr", "finish", new Object[0]);
    if (this.gby != null) {
      this.gby.amB();
    }
    this.handler.sendEmptyMessage(2);
    if (!this.gbs) {
      this.handler.sendEmptyMessage(3);
    }
    reset();
    AppMethodBeat.o(116698);
  }
  
  private void reset()
  {
    AppMethodBeat.i(116700);
    ab.i("MicroMsg.SceneVoiceAddr", "reset");
    try
    {
      if (this.ciR != null)
      {
        this.ciR.Et();
        this.ciR = null;
      }
      if (this.gbw != null)
      {
        this.gbw.Fb();
        this.gbw = null;
      }
      if (this.gbx != null) {
        this.gbx.stop();
      }
      this.gbx = null;
      if (this.gby != null)
      {
        this.gby.amB();
        this.gby = null;
      }
      this.gbr = 0;
      this.gbs = false;
      return;
    }
    finally
    {
      AppMethodBeat.o(116700);
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(116699);
    this.gbv = null;
    finish();
    AppMethodBeat.o(116699);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(116697);
    long l;
    if (this.gbj == 0)
    {
      ab.d("MicroMsg.SceneVoiceAddr", "removeSceneEndListener MMFunc_UploadInputVoice");
      g.Rc().b(349, this);
      paramString = ((a)paramm).amC();
      l = ((a)paramm).amD();
      if (paramString != null) {
        break label135;
      }
    }
    label135:
    for (int i = -1;; i = paramString.length)
    {
      ab.i("MicroMsg.SceneVoiceAddr", "onSceneEnd errType:%d errCode:%d list:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      if (this.gbv == null) {
        break label154;
      }
      if ((paramInt2 == 0) && (paramInt1 == 0)) {
        break label142;
      }
      this.gbv.amJ();
      cancel();
      AppMethodBeat.o(116697);
      return;
      g.Rc().b(206, this);
      break;
    }
    label142:
    this.gbv.a(paramString, l);
    label154:
    AppMethodBeat.o(116697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.f
 * JD-Core Version:    0.7.0.1
 */