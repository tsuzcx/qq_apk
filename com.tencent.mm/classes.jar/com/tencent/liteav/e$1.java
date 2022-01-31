package com.tencent.liteav;

import com.tencent.liteav.a.a.b;
import com.tencent.liteav.renderer.b;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;
import com.tencent.ugc.TXRecordCommon.TXRecordResult;

class e$1
  implements a.b
{
  e$1(e parame) {}
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    TXRecordCommon.TXRecordResult localTXRecordResult;
    if (e.a(this.a) != null)
    {
      localTXRecordResult = new TXRecordCommon.TXRecordResult();
      if (paramInt != 0) {
        break label85;
      }
    }
    label85:
    for (localTXRecordResult.retCode = 0;; localTXRecordResult.retCode = -1)
    {
      localTXRecordResult.descMsg = paramString1;
      localTXRecordResult.videoPath = paramString2;
      localTXRecordResult.coverPath = paramString3;
      e.a(this.a).onRecordComplete(localTXRecordResult);
      e.b(this.a).a(null);
      e.b(this.a).a(null);
      return;
    }
  }
  
  public void a(long paramLong)
  {
    if (e.a(this.a) != null) {
      e.a(this.a).onRecordProgress(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.e.1
 * JD-Core Version:    0.7.0.1
 */