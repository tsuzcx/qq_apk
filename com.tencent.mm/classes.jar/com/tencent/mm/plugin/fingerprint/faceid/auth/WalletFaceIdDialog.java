package com.tencent.mm.plugin.fingerprint.faceid.auth;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fingerprint.c.c;
import com.tencent.mm.plugin.fingerprint.mgr.j;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.a.i;
import com.tencent.mm.wallet_core.ui.k;
import com.tencent.soter.a.g.f;

public class WalletFaceIdDialog
  extends i
  implements p
{
  FrameAnimatorImageView Hfi;
  TextView Hfj;
  private TextView Hfk;
  ViewGroup Hfl;
  private ViewGroup Hfm;
  private a Hfn;
  private View plc;
  TextView tHK;
  
  private WalletFaceIdDialog(Context paramContext)
  {
    super(paramContext, a.j.FaceIdDialogStyle);
    AppMethodBeat.i(64279);
    this.plc = View.inflate(getContext(), a.g.faceid_auth_dialog, null);
    this.Hfm = ((ViewGroup)this.plc.findViewById(a.f.fiad_toast_layout));
    this.Hfi = ((FrameAnimatorImageView)this.plc.findViewById(a.f.fiad_face_iv));
    this.tHK = ((TextView)this.plc.findViewById(a.f.fiad_tips_tv));
    this.Hfj = ((TextView)this.plc.findViewById(a.f.fiad_right_btn));
    this.Hfk = ((TextView)this.plc.findViewById(a.f.fiad_left_btn));
    this.Hfl = ((ViewGroup)this.plc.findViewById(a.f.fiad_bottom_layout));
    aw.a(this.Hfk.getPaint(), 0.8F);
    aw.a(this.Hfj.getPaint(), 0.8F);
    this.plc.setBackgroundColor(0);
    this.Hfk.setOnClickListener(new k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(275246);
        Log.d("MicroMsg.WalletFaceIdDialog", "click dismiss btn");
        paramAnonymousView = WalletFaceIdDialog.a(WalletFaceIdDialog.this);
        Log.i("MicroMsg.WalletFaceIdDialog", "click left btn");
        if (paramAnonymousView.Hft) {
          paramAnonymousView.onAuthFail(-1);
        }
        for (;;)
        {
          WalletFaceIdDialog.this.dismiss();
          AppMethodBeat.o(275246);
          return;
          paramAnonymousView.onAuthCancel();
        }
      }
    });
    this.Hfj.setOnClickListener(new k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(275243);
        Log.d("MicroMsg.WalletFaceIdDialog", "click right btn");
        paramAnonymousView = WalletFaceIdDialog.a(WalletFaceIdDialog.this);
        Log.i("MicroMsg.WalletFaceIdDialog", "click right btn");
        WalletFaceIdDialog localWalletFaceIdDialog = paramAnonymousView.Hfp;
        localWalletFaceIdDialog.Hfj.setEnabled(false);
        localWalletFaceIdDialog.tHK.setText(a.i.faceid_auth_dialog_verify);
        localWalletFaceIdDialog.tHK.post(new WalletFaceIdDialog.4(localWalletFaceIdDialog));
        paramAnonymousView.fto();
        AppMethodBeat.o(275243);
      }
    });
    AppMethodBeat.o(64279);
  }
  
  public WalletFaceIdDialog(Context paramContext, a parama, Bundle paramBundle)
  {
    this(paramContext);
    AppMethodBeat.i(64278);
    this.Hfn = new a(this, parama, paramBundle);
    setOnShowListener(this.Hfn);
    setOnDismissListener(this.Hfn);
    setOnCancelListener(this.Hfn);
    setCancelable(false);
    setCanceledOnTouchOutside(false);
    AppMethodBeat.o(64278);
  }
  
  public final void d(Animation.AnimationListener paramAnimationListener)
  {
    AppMethodBeat.i(64287);
    this.Hfi.setImageResource(a.e.faceid_failed_icon);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), a.a.faceid_failed_shake);
    this.Hfi.startAnimation(localAnimation);
    if (paramAnimationListener != null) {
      localAnimation.setAnimationListener(paramAnimationListener);
    }
    AppMethodBeat.o(64287);
  }
  
  public final void ftl()
  {
    AppMethodBeat.i(64285);
    getWindow().setDimAmount(0.5F);
    this.plc.setBackgroundResource(a.e.popup_bg_without_shadow);
    this.Hfm.setBackground(null);
    AppMethodBeat.o(64285);
  }
  
  public final void ftm()
  {
    AppMethodBeat.i(64286);
    Log.d("MicroMsg.WalletFaceIdDialog", "trigger load start");
    this.Hfi.a(a.e.faceid_verify_trigger, new FrameAnimatorImageView.a()
    {
      public final void onStop()
      {
        AppMethodBeat.i(275241);
        Log.d("MicroMsg.WalletFaceIdDialog", "trigger load finish");
        WalletFaceIdDialog.c(WalletFaceIdDialog.this).a(a.e.faceid_verify_breath, null);
        AppMethodBeat.o(275241);
      }
    });
    AppMethodBeat.o(64286);
  }
  
  @z(Ho=j.a.ON_STOP)
  public void onActivityStop()
  {
    AppMethodBeat.i(64288);
    Log.i("MicroMsg.WalletFaceIdDialog", "activity pause");
    a.a(this.Hfn);
    dismiss();
    AppMethodBeat.o(64288);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64281);
    super.onCreate(paramBundle);
    setContentView(this.plc);
    AppMethodBeat.o(64281);
  }
  
  protected void onStart()
  {
    AppMethodBeat.i(64282);
    super.onStart();
    AppMethodBeat.o(64282);
  }
  
  static final class a
    implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener, DialogInterface.OnShowListener
  {
    WalletFaceIdDialog Hfp;
    private com.tencent.mm.plugin.fingerprint.c.a Hfq;
    private a Hfr;
    private int Hfs;
    boolean Hft;
    private c Hfu;
    private Bundle oSS;
    private int retryCount;
    private int scene;
    
    public a(WalletFaceIdDialog paramWalletFaceIdDialog, a parama, Bundle paramBundle)
    {
      AppMethodBeat.i(64264);
      this.retryCount = 0;
      this.Hft = false;
      this.Hfu = new c()
      {
        public final void iP(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(64260);
          Log.i("MicroMsg.WalletFaceIdDialog", "auth result: %s, retry: %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(WalletFaceIdDialog.a.b(WalletFaceIdDialog.a.this)) });
          switch (paramAnonymousInt1)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(64260);
            return;
            Log.i("MicroMsg.WalletFaceIdDialog", "identify success");
            WalletFaceIdDialog.a.a(WalletFaceIdDialog.a.this, paramAnonymousInt2);
            WalletFaceIdDialog.a.c(WalletFaceIdDialog.a.this);
            WalletFaceIdDialog.a.b(WalletFaceIdDialog.a.this, paramAnonymousInt2);
            AppMethodBeat.o(64260);
            return;
            WalletFaceIdDialog.a.c(WalletFaceIdDialog.a.this);
            if (WalletFaceIdDialog.a.b(WalletFaceIdDialog.a.this) < 2)
            {
              WalletFaceIdDialog.a.d(WalletFaceIdDialog.a.this);
              AppMethodBeat.o(64260);
              return;
            }
            WalletFaceIdDialog.a.c(WalletFaceIdDialog.a.this, paramAnonymousInt1);
          }
        }
      };
      this.Hfp = paramWalletFaceIdDialog;
      this.Hfr = parama;
      this.oSS = paramBundle;
      if (this.oSS != null) {
        this.scene = this.oSS.getInt("face_auth_scene");
      }
      AppMethodBeat.o(64264);
    }
    
    private void ftn()
    {
      AppMethodBeat.i(64265);
      this.Hfq.userCancel();
      AppMethodBeat.o(64265);
    }
    
    final void fto()
    {
      AppMethodBeat.i(64266);
      Log.i("MicroMsg.WalletFaceIdDialog", "req faceid auth");
      if (this.Hfq == null)
      {
        Log.w("MicroMsg.WalletFaceIdDialog", "mgr is null");
        AppMethodBeat.o(64266);
        return;
      }
      this.Hfq.userCancel();
      if (!this.Hfq.ftE())
      {
        Log.w("MicroMsg.WalletFaceIdDialog", "no faceid enrolled");
        onAuthFail(-2);
        AppMethodBeat.o(64266);
        return;
      }
      if (Util.isNullOrNil(j.Hgj.Hgd))
      {
        Log.i("MicroMsg.WalletFaceIdDialog", "no challenge");
        onAuthFail(-3);
        AppMethodBeat.o(64266);
        return;
      }
      this.Hfq.a(this.Hfu);
      this.Hfp.ftm();
      AppMethodBeat.o(64266);
    }
    
    final void onAuthCancel()
    {
      AppMethodBeat.i(64268);
      Log.i("MicroMsg.WalletFaceIdDialog", "auth cancel");
      if (this.Hfr != null)
      {
        this.Hfr.onAuthCancel();
        this.Hfr = null;
      }
      AppMethodBeat.o(64268);
    }
    
    final void onAuthFail(int paramInt)
    {
      AppMethodBeat.i(64267);
      Log.i("MicroMsg.WalletFaceIdDialog", "auth fail");
      if (this.Hfr != null)
      {
        this.Hfr.onAuthFail(paramInt);
        this.Hfr = null;
      }
      this.Hfp.dismiss();
      AppMethodBeat.o(64267);
    }
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(64271);
      Log.d("MicroMsg.WalletFaceIdDialog", "face id dialog cancel");
      onAuthCancel();
      AppMethodBeat.o(64271);
    }
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(64269);
      Log.i("MicroMsg.WalletFaceIdDialog", "face id dialog dismiss");
      ftn();
      if (this.scene == 1) {
        onAuthCancel();
      }
      AppMethodBeat.o(64269);
    }
    
    public final void onShow(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(64270);
      Log.i("MicroMsg.WalletFaceIdDialog", "face id dialog show");
      this.Hfq = ((com.tencent.mm.plugin.fingerprint.c.a)h.ax(com.tencent.mm.plugin.fingerprint.c.a.class));
      f.jYD().jYE();
      fto();
      AppMethodBeat.o(64270);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdDialog
 * JD-Core Version:    0.7.0.1
 */