package com.tencent.mm.plugin.appbrand.ui.recents;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.appusage.ap.d;
import com.tencent.mm.plugin.appbrand.au.d;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import org.xwalk.core.Log;

public abstract class f
  extends a
  implements View.OnClickListener
{
  private FragmentActivity mActivity;
  private ViewGroup rdg;
  private ImageView rdh;
  private WeImageView rdi;
  private View rdj;
  private ImageView rdk;
  private MMAnimateView rdl;
  private TextView rdm;
  private View rdn;
  protected akt rdo;
  
  f(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    this.mActivity = paramFragmentActivity;
    this.rdg = ((ViewGroup)LayoutInflater.from(paramFragmentActivity).inflate(au.g.app_brand_recents_list_header_folder_entrance, paramViewGroup, false));
    this.rdg.setOnClickListener(this);
    ((TextView)this.rdg.findViewById(au.f.title)).setText(getTitle());
    this.rdh = ((ImageView)this.rdg.findViewById(au.f.app_brand_entrance_arrow));
    this.rdi = ((WeImageView)this.rdg.findViewById(au.f.icon));
    this.rdn = this.rdg.findViewById(au.f.red_dot);
    if (this.rdi != null) {
      a(this.rdi);
    }
    this.rdj = this.rdg.findViewById(au.f.showcase);
    this.rdk = ((ImageView)this.rdg.findViewById(au.f.showcase_iv_left));
    this.rdl = ((MMAnimateView)this.rdg.findViewById(au.f.showcase_iv_right));
    this.rdm = ((TextView)this.rdg.findViewById(au.f.showcase_text));
  }
  
  private void cld()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.rdj, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(30L);
    localObjectAnimator.start();
  }
  
  public final void CX(int paramInt)
  {
    if (this.rdh != null) {
      this.rdh.setVisibility(paramInt);
    }
    TextView localTextView = (TextView)this.rdg.findViewById(au.f.title);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localTextView.getLayoutParams();
    localLayoutParams.leftMargin = this.rdg.getResources().getDimensionPixelOffset(au.d.app_brand_header_title_left_margin);
    localTextView.setLayoutParams(localLayoutParams);
  }
  
  public final void CY(int paramInt)
  {
    this.rdg.setBackgroundResource(paramInt);
  }
  
  public final void b(final akt paramakt)
  {
    if (paramakt == null) {}
    final ap.d locald;
    do
    {
      return;
      this.rdo = paramakt;
      locald = ap.d.zm(paramakt.CKC);
    } while (locald == null);
    Log.i("AppBrandLauncherListHeaderFolderEntrance", "[showShowCaseView]  wording=" + paramakt.wording + " icon_url=" + paramakt.ufC + " icon_url2=" + paramakt.SvC);
    new f.a(paramakt.ufC, paramakt.SvC, new a.a()
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
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(180391);
              f.a(f.this, f.1.this.rdp, f.1.this.rdq, paramAnonymousBitmap, paramAnonymousArrayOfByte);
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
  
  public void cfx()
  {
    setViewEnable(true);
  }
  
  public final void cfy()
  {
    this.rdl.stop();
  }
  
  protected final FragmentActivity getActivity()
  {
    return this.mActivity;
  }
  
  public final View getItemView()
  {
    return this.rdg;
  }
  
  protected abstract String getTitle();
  
  public final void jO(boolean paramBoolean)
  {
    Log.i("AppBrandLauncherListHeaderFolderEntrance", "[showRedDot] showRedDot == ".concat(String.valueOf(paramBoolean)));
    View localView = this.rdn;
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
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  public final void onPause()
  {
    this.rdl.pause();
  }
  
  public void onResume()
  {
    b(this.rdo);
    this.rdl.resume();
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