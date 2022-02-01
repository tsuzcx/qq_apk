package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends a
{
  private String appId;
  private String hTL;
  private boolean vBn;
  private String zSx;
  private float zSy;
  private boolean zSz;
  
  d(Context paramContext, f paramf, int paramInt, Bundle paramBundle)
  {
    super(paramContext, paramf, paramInt, 0);
    AppMethodBeat.i(271870);
    this.vBn = false;
    this.zSt = true;
    this.appId = paramBundle.getString("appId", null);
    this.hTL = paramBundle.getString("request_verify_pre_info", null);
    this.zSx = paramBundle.getString("feedbackUrl", null);
    this.zSy = paramBundle.getFloat("key_current_light", 0.0F);
    this.zSz = paramBundle.getBoolean("key_upload_video", false);
    AppMethodBeat.o(271870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.c.d
 * JD-Core Version:    0.7.0.1
 */