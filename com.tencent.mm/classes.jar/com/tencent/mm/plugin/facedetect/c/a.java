package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import com.tencent.mm.plugin.facedetect.b.b;
import com.tencent.mm.plugin.facedetect.b.e;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import java.lang.ref.WeakReference;

public abstract class a
{
  private com.tencent.mm.remoteservice.d jGJ = null;
  private Context mContext;
  private int wvi;
  protected e wvj = null;
  protected com.tencent.mm.plugin.facedetect.b.d wvk = null;
  protected WeakReference<f> wwi;
  protected boolean wwj = false;
  private int wwk = -1;
  private int wwl;
  protected b wwm = null;
  protected boolean wwn = false;
  
  a(Context paramContext, f paramf, int paramInt1, int paramInt2)
  {
    this.mContext = paramContext;
    this.wvi = paramInt1;
    this.wwi = new WeakReference(paramf);
    this.wwl = 0;
    this.wwm = new b(paramInt1, 0);
    this.wwk = FaceDetectReporter.Lu(paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.c.a
 * JD-Core Version:    0.7.0.1
 */