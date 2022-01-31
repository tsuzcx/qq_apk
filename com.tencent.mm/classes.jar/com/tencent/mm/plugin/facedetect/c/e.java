package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public class e
  extends a
{
  private static final String TAG;
  private boolean isRetry = false;
  private int mhA;
  private String mhy;
  private String mhz;
  
  static
  {
    AppMethodBeat.i(159);
    TAG = "MicroMsg." + e.class.getSimpleName();
    AppMethodBeat.o(159);
  }
  
  e(Context paramContext, f paramf, int paramInt1, int paramInt2)
  {
    super(paramContext, paramf, paramInt1, paramInt2);
    this.mhA = paramInt1;
  }
  
  private void r(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(157);
    b(paramInt1, paramInt2, paramString, null);
    Context localContext = ah.getContext();
    if (paramString == null) {}
    for (String str = localContext.getString(2131299529);; str = paramString)
    {
      paramString = com.tencent.mm.plugin.facedetect.ui.a.b(2130838689, str, localContext.getString(2131299603), null, new e.1(this, paramInt1, paramInt2, paramString), new e.2(this, paramInt1, paramInt2, paramString));
      paramString.status = 3;
      a(true, false, paramString);
      AppMethodBeat.o(157);
      return;
    }
  }
  
  public final void ax(int paramInt, String paramString)
  {
    AppMethodBeat.i(155);
    ab.i(TAG, "alvinluo onCancel, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (!FaceDetectReporter.buB().miH) {
      FaceDetectReporter.buB().b(FaceDetectReporter.vG(this.mhA), this.isRetry, 2, 1, paramInt);
    }
    a(1, paramInt, paramString, null);
    AppMethodBeat.o(155);
  }
  
  public final m buf()
  {
    return null;
  }
  
  public final Bundle bug()
  {
    AppMethodBeat.i(156);
    Bundle localBundle = new Bundle();
    localBundle.putLong("k_bio_id", bud());
    AppMethodBeat.o(156);
    return localBundle;
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, Bundle paramBundle) {}
  
  public final boolean c(int paramInt, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(154);
    ab.i(TAG, "alvinluo onUploadEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0), paramString });
    if (paramInt != 0)
    {
      FaceDetectReporter.buB().b(FaceDetectReporter.vG(this.mhA), this.isRetry, 1, 2, 90012);
      r(paramInt, 0, paramString);
      AppMethodBeat.o(154);
      return true;
    }
    if ((paramBundle == null) || (bo.isNullOrNil(paramBundle.getString("key_pic_cdn_id"))))
    {
      ab.e(TAG, "hy: not return cdn id!");
      r(4, 6, "not return cdn id");
      AppMethodBeat.o(154);
      return true;
    }
    this.mhy = paramBundle.getString("key_pic_cdn_id");
    this.mhz = paramBundle.getString("key_cdn_aes_key");
    ab.v(TAG, "hy: start upload: picCdnId: %s, aes key: %s", new Object[] { this.mhy, this.mhz });
    paramBundle = new Bundle();
    paramBundle.putString("err_msg", paramString);
    paramBundle.putString("key_pic_cdn_id", this.mhy);
    paramBundle.putString("key_cdn_aes_key", this.mhz);
    paramBundle.putInt("check_alive_type", this.mhs);
    a(paramInt, 0, paramString, paramBundle);
    AppMethodBeat.o(154);
    return false;
  }
  
  public final void f(int paramInt1, int paramInt2, String paramString, m paramm) {}
  
  public final void onRelease()
  {
    AppMethodBeat.i(152);
    if (!FaceDetectReporter.buB().miH) {
      FaceDetectReporter.buB().b(FaceDetectReporter.vG(this.mhA), this.isRetry, 2, 1, 90006);
    }
    AppMethodBeat.o(152);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(151);
    ab.i(TAG, "alvinluo onStart and create report session");
    FaceDetectReporter.buB().buC();
    FaceDetectReporter.buB().T(FaceDetectReporter.vG(this.mhA), this.isRetry);
    AppMethodBeat.o(151);
  }
  
  public final void q(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(153);
    ab.v(TAG, "alvinluo onCollectEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    AppMethodBeat.o(153);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.c.e
 * JD-Core Version:    0.7.0.1
 */