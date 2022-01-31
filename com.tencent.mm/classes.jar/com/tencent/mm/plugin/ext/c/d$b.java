package com.tencent.mm.plugin.ext.c;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d$b
{
  int arA;
  int arz;
  byte[] cFD;
  public String cqq;
  Rect mfj;
  int rotate;
  
  public d$b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, Rect paramRect, String paramString)
  {
    this.cFD = paramArrayOfByte;
    this.arz = paramInt1;
    this.arA = paramInt2;
    this.rotate = paramInt3;
    this.mfj = paramRect;
    this.cqq = paramString;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(20413);
    StringBuilder localStringBuilder = new StringBuilder("RetrieveResult{yuvDataLength=");
    if (this.cFD != null) {}
    for (Object localObject = Integer.valueOf(this.cFD.length);; localObject = "null")
    {
      localObject = localObject + ", previewWidth=" + this.arz + ", previewHeight=" + this.arA + ", rotate=" + this.rotate + ", scanRect=" + this.mfj + ", md5=" + this.cqq + '}';
      AppMethodBeat.o(20413);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.c.d.b
 * JD-Core Version:    0.7.0.1
 */