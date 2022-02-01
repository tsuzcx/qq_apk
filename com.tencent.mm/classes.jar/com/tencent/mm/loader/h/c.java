package com.tencent.mm.loader.h;

import android.graphics.Bitmap;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/loader/model/LoadResult;", "R", "", "()V", "status", "", "from", "value", "(IILjava/lang/Object;)V", "data", "", "contentType", "", "([BLjava/lang/String;)V", "([BILjava/lang/String;)V", "getContentType", "()Ljava/lang/String;", "setContentType", "(Ljava/lang/String;)V", "getData", "()[B", "setData", "([B)V", "getFrom", "()I", "setFrom", "(I)V", "getStatus", "setStatus", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "isValid", "", "(Ljava/lang/Object;)Lcom/tencent/mm/loader/model/LoadResult;", "Companion", "libimageloader_release"})
public final class c<R>
{
  private static final int STATUS_DEFAULT = -1;
  private static final int STATUS_OK = 0;
  private static final int hiY = 1;
  private static final int hiZ = 2;
  private static final int hja = 3;
  private static final int hjb = 4;
  private static final int hjc = 0;
  private static final int hjd = 1;
  private static final int hje = 2;
  public static final c.a hjf = new c.a((byte)0);
  public int from;
  public int status;
  public R value;
  
  public c()
  {
    this.status = STATUS_DEFAULT;
  }
  
  public c(int paramInt1, int paramInt2, R paramR)
  {
    this.status = paramInt1;
    this.from = paramInt2;
    this.value = paramR;
  }
  
  public final boolean isValid()
  {
    if (this.value == null) {
      return false;
    }
    if ((this.value instanceof Bitmap))
    {
      Object localObject = this.value;
      if (localObject == null) {
        throw new v("null cannot be cast to non-null type android.graphics.Bitmap");
      }
      return !((Bitmap)localObject).isRecycled();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.h.c
 * JD-Core Version:    0.7.0.1
 */