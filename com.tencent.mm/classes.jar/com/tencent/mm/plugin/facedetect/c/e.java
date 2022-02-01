package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public class e
  extends a
{
  private static final String TAG;
  private boolean isRetry = false;
  private String rgK;
  private String rgL;
  private int rgM;
  
  static
  {
    AppMethodBeat.i(103684);
    TAG = "MicroMsg." + e.class.getSimpleName();
    AppMethodBeat.o(103684);
  }
  
  e(Context paramContext, f paramf, int paramInt1, int paramInt2)
  {
    super(paramContext, paramf, paramInt1, paramInt2);
    this.rgM = paramInt1;
  }
  
  private void u(final int paramInt1, final int paramInt2, final String paramString)
  {
    AppMethodBeat.i(103682);
    b(paramInt1, paramInt2, paramString, null);
    Context localContext = aj.getContext();
    if (paramString == null) {}
    for (String str = localContext.getString(2131758686);; str = paramString)
    {
      paramString = com.tencent.mm.plugin.facedetect.ui.a.b(2131232130, str, localContext.getString(2131758760), null, new View.OnClickListener()new View.OnClickListener
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(103674);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetect/controller/FaceVerifyController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (this.rgO) {
            e.a(e.this);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/controller/FaceVerifyController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(103674);
            return;
            e.this.a(paramInt1, paramInt2, paramString, this.rgP);
          }
        }
      }, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(103675);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetect/controller/FaceVerifyController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          e.this.a(paramInt1, paramInt2, paramString, this.rgP);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/controller/FaceVerifyController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(103675);
        }
      });
      paramString.status = 3;
      a(true, false, paramString);
      AppMethodBeat.o(103682);
      return;
    }
  }
  
  public final void aT(int paramInt, String paramString)
  {
    AppMethodBeat.i(103680);
    ad.i(TAG, "alvinluo onCancel, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (!FaceDetectReporter.cth().rhS) {
      FaceDetectReporter.cth().a(FaceDetectReporter.DL(this.rgM), this.isRetry, 2, 1, paramInt);
    }
    a(1, paramInt, paramString, null);
    AppMethodBeat.o(103680);
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, Bundle paramBundle) {}
  
  public final boolean c(int paramInt, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(103679);
    ad.i(TAG, "alvinluo onUploadEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0), paramString });
    if (paramInt != 0)
    {
      FaceDetectReporter.cth().a(FaceDetectReporter.DL(this.rgM), this.isRetry, 1, 2, 90012);
      u(paramInt, 0, paramString);
      AppMethodBeat.o(103679);
      return true;
    }
    if ((paramBundle == null) || (bt.isNullOrNil(paramBundle.getString("key_pic_cdn_id"))))
    {
      ad.e(TAG, "hy: not return cdn id!");
      u(4, 6, "not return cdn id");
      AppMethodBeat.o(103679);
      return true;
    }
    this.rgK = paramBundle.getString("key_pic_cdn_id");
    this.rgL = paramBundle.getString("key_cdn_aes_key");
    ad.v(TAG, "hy: start upload: picCdnId: %s, aes key: %s", new Object[] { this.rgK, this.rgL });
    paramBundle = new Bundle();
    paramBundle.putString("err_msg", paramString);
    paramBundle.putString("key_pic_cdn_id", this.rgK);
    paramBundle.putString("key_cdn_aes_key", this.rgL);
    paramBundle.putInt("check_alive_type", this.rgE);
    a(paramInt, 0, paramString, paramBundle);
    AppMethodBeat.o(103679);
    return false;
  }
  
  public final n csL()
  {
    return null;
  }
  
  public final Bundle csM()
  {
    AppMethodBeat.i(103681);
    Bundle localBundle = new Bundle();
    localBundle.putLong("k_bio_id", csJ());
    AppMethodBeat.o(103681);
    return localBundle;
  }
  
  public final void f(int paramInt1, int paramInt2, String paramString, n paramn) {}
  
  public final void onRelease()
  {
    AppMethodBeat.i(103677);
    if (!FaceDetectReporter.cth().rhS) {
      FaceDetectReporter.cth().a(FaceDetectReporter.DL(this.rgM), this.isRetry, 2, 1, 90006);
    }
    AppMethodBeat.o(103677);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(103676);
    ad.i(TAG, "alvinluo onStart and create report session");
    FaceDetectReporter.cth().cti();
    FaceDetectReporter.cth().ab(FaceDetectReporter.DL(this.rgM), this.isRetry);
    AppMethodBeat.o(103676);
  }
  
  public final void t(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(103678);
    ad.v(TAG, "alvinluo onCollectEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    AppMethodBeat.o(103678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.c.e
 * JD-Core Version:    0.7.0.1
 */