package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import com.tencent.mm.plugin.facedetect.b.b;
import com.tencent.mm.plugin.facedetect.b.e;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import java.lang.ref.WeakReference;

public abstract class a
{
  private Context mContext;
  private com.tencent.mm.remoteservice.d pfZ = null;
  private int ybL = -1;
  private int zRn;
  protected e zRo = null;
  protected com.tencent.mm.plugin.facedetect.b.d zRp = null;
  protected WeakReference<f> zSp;
  protected boolean zSq = false;
  private int zSr;
  protected b zSs = null;
  protected boolean zSt = false;
  
  a(Context paramContext, f paramf, int paramInt1, int paramInt2)
  {
    this.mContext = paramContext;
    this.zRn = paramInt1;
    this.zSp = new WeakReference(paramf);
    this.zSr = 0;
    this.zSs = new b(paramInt1, 0);
    this.ybL = FaceDetectReporter.Mr(paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.c.a
 * JD-Core Version:    0.7.0.1
 */