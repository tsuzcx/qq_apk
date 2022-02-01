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
  private String wwr;
  private float wws;
  private boolean wwt;
  
  d(Context paramContext, f paramf, int paramInt, Bundle paramBundle)
  {
    super(paramContext, paramf, paramInt, 0);
    AppMethodBeat.i(195766);
    this.isRetry = false;
    this.wwn = true;
    this.appId = paramBundle.getString("appId", null);
    this.jsonString = paramBundle.getString("request_verify_pre_info", null);
    this.wwr = paramBundle.getString("feedbackUrl", null);
    this.wws = paramBundle.getFloat("key_current_light", 0.0F);
    this.wwt = paramBundle.getBoolean("key_upload_video", false);
    AppMethodBeat.o(195766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.c.d
 * JD-Core Version:    0.7.0.1
 */