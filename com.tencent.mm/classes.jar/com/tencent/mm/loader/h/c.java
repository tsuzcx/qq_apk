package com.tencent.mm.loader.h;

import android.graphics.Bitmap;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/loader/model/LoadResult;", "R", "", "()V", "status", "", "from", "value", "(IILjava/lang/Object;)V", "data", "", "contentType", "", "([BLjava/lang/String;)V", "([BILjava/lang/String;)V", "getContentType", "()Ljava/lang/String;", "setContentType", "(Ljava/lang/String;)V", "getData", "()[B", "setData", "([B)V", "getFrom", "()I", "setFrom", "(I)V", "getStatus", "setStatus", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "isValid", "", "(Ljava/lang/Object;)Lcom/tencent/mm/loader/model/LoadResult;", "Companion", "libimageloader_release"})
public final class c<R>
{
  private static final int STATUS_DEFAULT = -1;
  private static final int STATUS_OK = 0;
  private static final int glA = 1;
  private static final int glB = 2;
  private static final int glC = 3;
  private static final int glD = 4;
  private static final int glE = 0;
  private static final int glF = 1;
  private static final int glG = 2;
  public static final a glH = new a((byte)0);
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/loader/model/LoadResult$Companion;", "", "()V", "FROM_FILE", "", "getFROM_FILE", "()I", "FROM_MEMORY", "getFROM_MEMORY", "FROM_NET", "getFROM_NET", "STATUS_DECODE_FAILED", "getSTATUS_DECODE_FAILED", "STATUS_DEFAULT", "getSTATUS_DEFAULT", "STATUS_DOWNLOAD_FAILED", "getSTATUS_DOWNLOAD_FAILED", "STATUS_MD5CHECK_FAILED", "getSTATUS_MD5CHECK_FAILED", "STATUS_OK", "getSTATUS_OK", "STATUS_OVER_LIMIT", "getSTATUS_OVER_LIMIT", "status", "Lcom/tencent/mm/loader/model/LoadResult;", "R", "libimageloader_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.h.c
 * JD-Core Version:    0.7.0.1
 */