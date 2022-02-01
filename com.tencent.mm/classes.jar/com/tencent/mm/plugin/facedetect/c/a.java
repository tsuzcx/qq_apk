package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import com.tencent.mm.plugin.facedetect.b.c;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import java.lang.ref.WeakReference;

public abstract class a
{
  private com.tencent.mm.remoteservice.d gVN = null;
  private Context mContext;
  private int sPn;
  protected com.tencent.mm.plugin.facedetect.b.d sPo = null;
  protected c sPp = null;
  protected WeakReference<f> sQl;
  protected boolean sQm = false;
  private int sQn = -1;
  private int sQo;
  protected com.tencent.mm.plugin.facedetect.b.a sQp = null;
  protected boolean sQq = false;
  
  a(Context paramContext, f paramf, int paramInt1, int paramInt2)
  {
    this.mContext = paramContext;
    this.sPn = paramInt1;
    this.sQl = new WeakReference(paramf);
    this.sQo = 0;
    this.sQp = new com.tencent.mm.plugin.facedetect.b.a(paramInt1, 0);
    this.sQn = FaceDetectReporter.HK(paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.c.a
 * JD-Core Version:    0.7.0.1
 */