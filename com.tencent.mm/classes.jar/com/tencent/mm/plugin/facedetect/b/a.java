package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.i.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.facedetect.model.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

public final class a
  implements f
{
  public m mgA;
  public long mgB;
  public int mgC;
  public int mgD;
  public g.a mgE;
  public int mgs;
  public d mgt;
  public c mgu;
  public boolean mgv;
  public boolean mgw;
  public long mgx;
  public int mgy;
  public m mgz;
  
  public a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59);
    this.mgs = -1;
    this.mgt = null;
    this.mgu = null;
    this.mgv = false;
    this.mgw = false;
    this.mgx = 0L;
    this.mgy = 0;
    this.mgz = null;
    this.mgA = null;
    this.mgB = -1L;
    this.mgC = -1;
    this.mgE = new a.1(this);
    this.mgs = paramInt1;
    this.mgD = paramInt2;
    AppMethodBeat.o(59);
  }
  
  public final void btV()
  {
    AppMethodBeat.i(60);
    if (this.mgA != null) {
      g.Rc().b(this.mgA.getType(), this);
    }
    AppMethodBeat.o(60);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool = false;
    AppMethodBeat.i(62);
    ab.i("MicroMsg.FaceUploadProcessor", "hy: scene: %s, errType: %d, errCode: %d, errMsg: %s", new Object[] { paramm.toString(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (((paramm instanceof u)) || ((paramm instanceof v)))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (b)paramm;
        this.mgx = paramString.btW();
        e.jI(this.mgx);
        if (paramString.btX() == null)
        {
          ab.e("MicroMsg.FaceUploadProcessor", "hy: backend not return config");
          p(2, 90015, "face motion config from server is null");
          AppMethodBeat.o(62);
          return;
        }
        paramString = paramString.btX();
        paramInt1 = paramString.length;
        if (this.mgt == null) {
          bool = true;
        }
        ab.i("MicroMsg.FaceUploadProcessor", "configLen: %d, mUploadCallback == null: %b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(bool) });
        if (this.mgu != null) {
          this.mgu.e(this.mgx, paramString);
        }
        AppMethodBeat.o(62);
        return;
      }
      if (this.mgu != null)
      {
        this.mgu.aw(paramInt1, "get face bio config failed");
        AppMethodBeat.o(62);
      }
    }
    else if ((this.mgA != null) && (paramm.getType() == this.mgA.getType()))
    {
      this.mgC = ((int)(System.currentTimeMillis() - this.mgB));
      if (this.mgt != null) {
        this.mgt.f(paramInt1, paramInt2, paramString, paramm);
      }
    }
    AppMethodBeat.o(62);
  }
  
  public final void p(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(61);
    al.d(new a.2(this, paramInt1, paramInt2, paramString));
    AppMethodBeat.o(61);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.a
 * JD-Core Version:    0.7.0.1
 */