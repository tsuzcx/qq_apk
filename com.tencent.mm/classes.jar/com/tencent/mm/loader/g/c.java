package com.tencent.mm.loader.g;

import android.graphics.Bitmap;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/model/LoadResult;", "R", "", "()V", "status", "", "from", "value", "(IILjava/lang/Object;)V", "data", "", "contentType", "", "([BLjava/lang/String;)V", "([BILjava/lang/String;)V", "getContentType", "()Ljava/lang/String;", "setContentType", "(Ljava/lang/String;)V", "getData", "()[B", "setData", "([B)V", "getFrom", "()I", "setFrom", "(I)V", "getStatus", "setStatus", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "isValid", "", "(Ljava/lang/Object;)Lcom/tencent/mm/loader/model/LoadResult;", "Companion", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c<R>
{
  private static final int STATUS_DEFAULT = -1;
  public static final c.a nse = new c.a((byte)0);
  private static final int nsf = 0;
  private static final int nsg = 1;
  private static final int nsh = 2;
  private static final int nsi = 3;
  private static final int nsj = 4;
  private static final int nsk = 0;
  private static final int nsl = 1;
  private static final int nsm = 2;
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
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.Bitmap");
      }
      return !((Bitmap)localObject).isRecycled();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.g.c
 * JD-Core Version:    0.7.0.1
 */