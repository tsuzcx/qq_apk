package com.tencent.mm.plugin.appbrand.ui.recents;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.appusage.ap.d;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.protocal.protobuf.ahg;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import org.xwalk.core.Log;

public abstract class f
  extends a
  implements View.OnClickListener
{
  FragmentActivity mActivity;
  private ImageView mOA;
  private MMAnimateView mOB;
  private TextView mOC;
  private View mOD;
  protected ahg mOE;
  private ViewGroup mOw;
  private ImageView mOx;
  private WeImageView mOy;
  private View mOz;
  
  f(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    this.mActivity = paramFragmentActivity;
    this.mOw = ((ViewGroup)LayoutInflater.from(paramFragmentActivity).inflate(2131493037, paramViewGroup, false));
    this.mOw.setOnClickListener(this);
    ((TextView)this.mOw.findViewById(2131305902)).setText(getTitle());
    this.mOx = ((ImageView)this.mOw.findViewById(2131296712));
    this.mOy = ((WeImageView)this.mOw.findViewById(2131300874));
    this.mOD = this.mOw.findViewById(2131303917);
    if (this.mOy != null) {
      a(this.mOy);
    }
    this.mOz = this.mOw.findViewById(2131304794);
    this.mOA = ((ImageView)this.mOw.findViewById(2131304795));
    this.mOB = ((MMAnimateView)this.mOw.findViewById(2131304796));
    this.mOC = ((TextView)this.mOw.findViewById(2131304797));
  }
  
  private void bBt()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mOz, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(30L);
    localObjectAnimator.start();
  }
  
  public final void b(final ahg paramahg)
  {
    if (paramahg == null) {}
    final ap.d locald;
    do
    {
      return;
      this.mOE = paramahg;
      locald = ap.d.sf(paramahg.uoi);
    } while (locald == null);
    Log.i("AppBrandLauncherListHeaderFolderEntrance", "[showShowCaseView]  wording=" + paramahg.dyI + " icon_url=" + paramahg.pqW + " icon_url2=" + paramahg.Gxy);
    new f.a(paramahg.pqW, paramahg.Gxy, new a.a()
    {
      public final void b(final Bitmap paramAnonymousBitmap, final byte[] paramAnonymousArrayOfByte)
      {
        int i = 0;
        AppMethodBeat.i(180392);
        StringBuilder localStringBuilder = new StringBuilder("[LoadShowcaseImageTask#onLoadDone]  bitmap == null ");
        boolean bool;
        if (paramAnonymousBitmap == null)
        {
          bool = true;
          localStringBuilder = localStringBuilder.append(bool).append(" rightImageBytes length=");
          if (paramAnonymousArrayOfByte != null) {
            break label82;
          }
        }
        for (;;)
        {
          Log.i("AppBrandLauncherListHeaderFolderEntrance", i);
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(180391);
              f.a(f.this, f.1.this.mOF, f.1.this.mOG, paramAnonymousBitmap, paramAnonymousArrayOfByte);
              AppMethodBeat.o(180391);
            }
          });
          AppMethodBeat.o(180392);
          return;
          bool = false;
          break;
          label82:
          i = paramAnonymousArrayOfByte.length;
        }
      }
    }).start();
  }
  
  public final View bBp()
  {
    return this.mOw;
  }
  
  public void bwp()
  {
    hL(true);
  }
  
  protected final FragmentActivity getActivity()
  {
    return this.mActivity;
  }
  
  protected abstract String getTitle();
  
  public final void hM(boolean paramBoolean)
  {
    Log.i("AppBrandLauncherListHeaderFolderEntrance", "[showRedDot] showRedDot == ".concat(String.valueOf(paramBoolean)));
    View localView = this.mOD;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  public final void onDetached()
  {
    this.mOB.stop();
  }
  
  public final void onPause()
  {
    this.mOB.pause();
  }
  
  public void onResume()
  {
    b(this.mOE);
    this.mOB.resume();
  }
  
  public final void vF(int paramInt)
  {
    if (this.mOx != null) {
      this.mOx.setVisibility(paramInt);
    }
    TextView localTextView = (TextView)this.mOw.findViewById(2131305902);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localTextView.getLayoutParams();
    localLayoutParams.leftMargin = this.mOw.getResources().getDimensionPixelOffset(2131165786);
    localTextView.setLayoutParams(localLayoutParams);
  }
  
  public final void vG(int paramInt)
  {
    this.mOw.setBackgroundResource(paramInt);
  }
  
  static abstract interface a$a
  {
    public abstract void b(Bitmap paramBitmap, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.f
 * JD-Core Version:    0.7.0.1
 */