package com.tencent.liteav;

import com.tencent.liteav.a.a.b;
import com.tencent.liteav.renderer.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;
import com.tencent.ugc.TXRecordCommon.TXRecordResult;

class e$1
  implements a.b
{
  e$1(e parame) {}
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(67359);
    TXRecordCommon.TXRecordResult localTXRecordResult;
    if (e.a(this.a) != null)
    {
      localTXRecordResult = new TXRecordCommon.TXRecordResult();
      if (paramInt != 0) {
        break label95;
      }
    }
    label95:
    for (localTXRecordResult.retCode = 0;; localTXRecordResult.retCode = -1)
    {
      localTXRecordResult.descMsg = paramString1;
      localTXRecordResult.videoPath = paramString2;
      localTXRecordResult.coverPath = paramString3;
      e.a(this.a).onRecordComplete(localTXRecordResult);
      e.b(this.a).a(null);
      e.b(this.a).a(null);
      AppMethodBeat.o(67359);
      return;
    }
  }
  
  public void a(long paramLong)
  {
    AppMethodBeat.i(67360);
    if (e.a(this.a) != null) {
      e.a(this.a).onRecordProgress(paramLong);
    }
    AppMethodBeat.o(67360);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.e.1
 * JD-Core Version:    0.7.0.1
 */