package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;

public class e
  extends a
{
  private static final String TAG;
  private boolean isRetry = false;
  private String qwU;
  private String qwV;
  private int qwW;
  
  static
  {
    AppMethodBeat.i(103684);
    TAG = "MicroMsg." + e.class.getSimpleName();
    AppMethodBeat.o(103684);
  }
  
  e(Context paramContext, f paramf, int paramInt1, int paramInt2)
  {
    super(paramContext, paramf, paramInt1, paramInt2);
    this.qwW = paramInt1;
  }
  
  private void u(final int paramInt1, final int paramInt2, final String paramString)
  {
    AppMethodBeat.i(103682);
    b(paramInt1, paramInt2, paramString, null);
    Context localContext = ai.getContext();
    if (paramString == null) {}
    for (String str = localContext.getString(2131758686);; str = paramString)
    {
      paramString = com.tencent.mm.plugin.facedetect.ui.a.b(2131232130, str, localContext.getString(2131758760), null, new View.OnClickListener()new View.OnClickListener
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(103674);
          if (this.qwY)
          {
            e.a(e.this);
            AppMethodBeat.o(103674);
            return;
          }
          e.this.a(paramInt1, paramInt2, paramString, this.qwZ);
          AppMethodBeat.o(103674);
        }
      }, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(103675);
          e.this.a(paramInt1, paramInt2, paramString, this.qwZ);
          AppMethodBeat.o(103675);
        }
      });
      paramString.status = 3;
      a(true, false, paramString);
      AppMethodBeat.o(103682);
      return;
    }
  }
  
  public final void aQ(int paramInt, String paramString)
  {
    AppMethodBeat.i(103680);
    ac.i(TAG, "alvinluo onCancel, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (!FaceDetectReporter.cnC().qyc) {
      FaceDetectReporter.cnC().a(FaceDetectReporter.CT(this.qwW), this.isRetry, 2, 1, paramInt);
    }
    a(1, paramInt, paramString, null);
    AppMethodBeat.o(103680);
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, Bundle paramBundle) {}
  
  public final boolean c(int paramInt, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(103679);
    ac.i(TAG, "alvinluo onUploadEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0), paramString });
    if (paramInt != 0)
    {
      FaceDetectReporter.cnC().a(FaceDetectReporter.CT(this.qwW), this.isRetry, 1, 2, 90012);
      u(paramInt, 0, paramString);
      AppMethodBeat.o(103679);
      return true;
    }
    if ((paramBundle == null) || (bs.isNullOrNil(paramBundle.getString("key_pic_cdn_id"))))
    {
      ac.e(TAG, "hy: not return cdn id!");
      u(4, 6, "not return cdn id");
      AppMethodBeat.o(103679);
      return true;
    }
    this.qwU = paramBundle.getString("key_pic_cdn_id");
    this.qwV = paramBundle.getString("key_cdn_aes_key");
    ac.v(TAG, "hy: start upload: picCdnId: %s, aes key: %s", new Object[] { this.qwU, this.qwV });
    paramBundle = new Bundle();
    paramBundle.putString("err_msg", paramString);
    paramBundle.putString("key_pic_cdn_id", this.qwU);
    paramBundle.putString("key_cdn_aes_key", this.qwV);
    paramBundle.putInt("check_alive_type", this.qwO);
    a(paramInt, 0, paramString, paramBundle);
    AppMethodBeat.o(103679);
    return false;
  }
  
  public final n cng()
  {
    return null;
  }
  
  public final Bundle cnh()
  {
    AppMethodBeat.i(103681);
    Bundle localBundle = new Bundle();
    localBundle.putLong("k_bio_id", cne());
    AppMethodBeat.o(103681);
    return localBundle;
  }
  
  public final void f(int paramInt1, int paramInt2, String paramString, n paramn) {}
  
  public final void onRelease()
  {
    AppMethodBeat.i(103677);
    if (!FaceDetectReporter.cnC().qyc) {
      FaceDetectReporter.cnC().a(FaceDetectReporter.CT(this.qwW), this.isRetry, 2, 1, 90006);
    }
    AppMethodBeat.o(103677);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(103676);
    ac.i(TAG, "alvinluo onStart and create report session");
    FaceDetectReporter.cnC().cnD();
    FaceDetectReporter.cnC().ab(FaceDetectReporter.CT(this.qwW), this.isRetry);
    AppMethodBeat.o(103676);
  }
  
  public final void t(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(103678);
    ac.v(TAG, "alvinluo onCollectEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    AppMethodBeat.o(103678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.c.e
 * JD-Core Version:    0.7.0.1
 */