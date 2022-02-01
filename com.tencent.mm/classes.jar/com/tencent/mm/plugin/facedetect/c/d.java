package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends a
{
  private String appId;
  private boolean isRetry;
  private String jsonString;
  private String sQu;
  private float sQv;
  private boolean sQw;
  
  d(Context paramContext, f paramf, int paramInt, Bundle paramBundle)
  {
    super(paramContext, paramf, paramInt, 0);
    AppMethodBeat.i(186363);
    this.isRetry = false;
    this.sQq = true;
    this.appId = paramBundle.getString("appId", null);
    this.jsonString = paramBundle.getString("request_verify_pre_info", null);
    this.sQu = paramBundle.getString("feedbackUrl", null);
    this.sQv = paramBundle.getFloat("key_current_light", 0.0F);
    this.sQw = paramBundle.getBoolean("key_upload_video", false);
    AppMethodBeat.o(186363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.c.d
 * JD-Core Version:    0.7.0.1
 */