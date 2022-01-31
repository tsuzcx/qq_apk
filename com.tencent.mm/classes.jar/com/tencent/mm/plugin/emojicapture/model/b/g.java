package com.tencent.mm.plugin.emojicapture.model.b;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.platformtools.y;

public final class g
{
  final String TAG;
  int jlA;
  private int jlB;
  public float jlC;
  float jlD;
  float jlE;
  float jlF;
  final c jli;
  private final int jlk;
  private int jls;
  private int jlt;
  private int jlu;
  int jlv;
  float jlw;
  long jlx;
  Bitmap jly;
  private int jlz;
  
  public g(String paramString, c paramc, int paramInt)
  {
    this.jli = paramc;
    this.jlk = paramInt;
    this.TAG = "MicroMsg.MixFrameSyncMgr";
    this.jlw = -1.0F;
    paramc = d.MH(paramString);
    if ((paramc instanceof a))
    {
      this.jlt = paramc.eIM;
      this.jlu = paramc.jlu;
      this.jlC = (1000.0F / paramc.eIM);
      this.jls = ((int)(this.jlt * (this.jlu / 1000.0D)));
    }
    for (;;)
    {
      this.jlB = (this.jlk * 20);
      if (this.jlB > 30) {
        this.jlB = 30;
      }
      this.jlC /= this.jlk;
      this.jlE = (1000.0F / this.jlB);
      if (this.jlE < this.jlC) {
        this.jlE = this.jlC;
      }
      this.jlz = ((int)(this.jlu / this.jlk / this.jlE));
      this.jlA = 0;
      y.i(this.TAG, "init MixFrameSyncMgr,videoPath:" + paramString + ", videoPlayRate:" + this.jlk + ", fps:" + this.jlt + ", duration:" + this.jlu + ", frameCount:" + this.jls + ", frameDuration:" + this.jlC + ", targetFrameRate:" + this.jlB + ", targetFrameCount:" + this.jlz + ", targetFrameDuration:" + this.jlE);
      return;
      this.jls = 0;
      this.jlt = 0;
      this.jlC = 0.0F;
      this.jlu = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.g
 * JD-Core Version:    0.7.0.1
 */