package com.tencent.mm.plugin.fingerprint.faceid.auth;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.i;

public final class b
  extends i
  implements LifecycleObserver
{
  TextView iKV;
  private View ipf;
  FrameAnimatorImageView kkF;
  TextView kkG;
  private TextView kkH;
  ViewGroup kkI;
  private ViewGroup kkJ;
  private b.a kkK;
  
  private b(Context paramContext)
  {
    super(paramContext, a.j.FaceIdDialogStyle);
    initView();
  }
  
  private b(Context paramContext, int paramInt)
  {
    super(paramContext, a.j.FaceIdDialogStyle);
    initView();
  }
  
  public b(Context paramContext, a parama)
  {
    this(paramContext, parama, null);
  }
  
  public b(Context paramContext, a parama, Bundle paramBundle)
  {
    this(paramContext);
    this.kkK = new b.a(this, parama, paramBundle);
    setOnShowListener(this.kkK);
    setOnDismissListener(this.kkK);
    setOnCancelListener(this.kkK);
    setCancelable(false);
    setCanceledOnTouchOutside(false);
  }
  
  private void initView()
  {
    this.ipf = View.inflate(getContext(), a.g.faceid_auth_dialog, null);
    this.kkJ = ((ViewGroup)this.ipf.findViewById(a.f.fiad_toast_layout));
    this.kkF = ((FrameAnimatorImageView)this.ipf.findViewById(a.f.fiad_face_iv));
    this.iKV = ((TextView)this.ipf.findViewById(a.f.fiad_tips_tv));
    this.kkG = ((TextView)this.ipf.findViewById(a.f.fiad_right_btn));
    this.kkH = ((TextView)this.ipf.findViewById(a.f.fiad_left_btn));
    this.kkI = ((ViewGroup)this.ipf.findViewById(a.f.fiad_bottom_layout));
    this.ipf.setBackgroundColor(0);
    this.iKV.setTextColor(Color.parseColor("#888888"));
    this.kkH.setOnClickListener(new b.1(this));
    this.kkG.setOnClickListener(new b.2(this));
  }
  
  public final void aSt()
  {
    getWindow().setDimAmount(0.5F);
    this.ipf.setBackgroundResource(a.e.popup_bg_without_shadow);
    this.kkJ.setBackground(null);
    this.iKV.setTextColor(Color.parseColor("#111111"));
    this.iKV.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.d.BodyTextSize));
  }
  
  public final void c(Animation.AnimationListener paramAnimationListener)
  {
    this.kkF.setImageResource(a.e.faceid_failed_icon);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), a.a.faceid_failed_shake);
    this.kkF.startAnimation(localAnimation);
    if (paramAnimationListener != null) {
      localAnimation.setAnimationListener(paramAnimationListener);
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
  public final void onActivityStop()
  {
    y.i("MicroMsg.WalletFaceIdDialog", "activity pause");
    b.a.a(this.kkK);
    dismiss();
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(this.ipf);
  }
  
  protected final void onStart()
  {
    super.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.b
 * JD-Core Version:    0.7.0.1
 */