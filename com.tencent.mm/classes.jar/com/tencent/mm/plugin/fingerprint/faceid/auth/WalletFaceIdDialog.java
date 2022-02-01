package com.tencent.mm.plugin.fingerprint.faceid.auth;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.lifecycle.h.a;
import androidx.lifecycle.k;
import androidx.lifecycle.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fingerprint.b.p;
import com.tencent.mm.plugin.fingerprint.d.c;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.i;
import com.tencent.soter.a.g.f;

public class WalletFaceIdDialog
  extends i
  implements k
{
  FrameAnimatorImageView BxF;
  TextView BxG;
  private TextView BxH;
  ViewGroup BxI;
  private ViewGroup BxJ;
  private a BxK;
  private View mrI;
  TextView qCM;
  
  private WalletFaceIdDialog(Context paramContext)
  {
    super(paramContext, a.j.FaceIdDialogStyle);
    AppMethodBeat.i(64279);
    this.mrI = View.inflate(getContext(), a.g.faceid_auth_dialog, null);
    this.BxJ = ((ViewGroup)this.mrI.findViewById(a.f.fiad_toast_layout));
    this.BxF = ((FrameAnimatorImageView)this.mrI.findViewById(a.f.fiad_face_iv));
    this.qCM = ((TextView)this.mrI.findViewById(a.f.fiad_tips_tv));
    this.BxG = ((TextView)this.mrI.findViewById(a.f.fiad_right_btn));
    this.BxH = ((TextView)this.mrI.findViewById(a.f.fiad_left_btn));
    this.BxI = ((ViewGroup)this.mrI.findViewById(a.f.fiad_bottom_layout));
    ar.a(this.BxH.getPaint(), 0.8F);
    ar.a(this.BxG.getPaint(), 0.8F);
    this.mrI.setBackgroundColor(0);
    this.BxH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64257);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fingerprint/faceid/auth/WalletFaceIdDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.d("MicroMsg.WalletFaceIdDialog", "click dismiss btn");
        paramAnonymousView = WalletFaceIdDialog.a(WalletFaceIdDialog.this);
        Log.i("MicroMsg.WalletFaceIdDialog", "click left btn");
        if (paramAnonymousView.BxQ) {
          paramAnonymousView.onAuthFail(-1);
        }
        for (;;)
        {
          WalletFaceIdDialog.this.dismiss();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fingerprint/faceid/auth/WalletFaceIdDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(64257);
          return;
          paramAnonymousView.onAuthCancel();
        }
      }
    });
    this.BxG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64258);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fingerprint/faceid/auth/WalletFaceIdDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
        Log.d("MicroMsg.WalletFaceIdDialog", "click right btn");
        paramAnonymousView = WalletFaceIdDialog.a(WalletFaceIdDialog.this);
        Log.i("MicroMsg.WalletFaceIdDialog", "click right btn");
        localObject = paramAnonymousView.BxM;
        ((WalletFaceIdDialog)localObject).BxG.setEnabled(false);
        ((WalletFaceIdDialog)localObject).qCM.setText(a.i.faceid_auth_dialog_verify);
        paramAnonymousView.eol();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fingerprint/faceid/auth/WalletFaceIdDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64258);
      }
    });
    AppMethodBeat.o(64279);
  }
  
  public WalletFaceIdDialog(Context paramContext, a parama, Bundle paramBundle)
  {
    this(paramContext);
    AppMethodBeat.i(64278);
    this.BxK = new a(this, parama, paramBundle);
    setOnShowListener(this.BxK);
    setOnDismissListener(this.BxK);
    setOnCancelListener(this.BxK);
    setCancelable(false);
    setCanceledOnTouchOutside(false);
    AppMethodBeat.o(64278);
  }
  
  public final void d(Animation.AnimationListener paramAnimationListener)
  {
    AppMethodBeat.i(64287);
    this.BxF.setImageResource(a.e.faceid_failed_icon);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), a.a.faceid_failed_shake);
    this.BxF.startAnimation(localAnimation);
    if (paramAnimationListener != null) {
      localAnimation.setAnimationListener(paramAnimationListener);
    }
    AppMethodBeat.o(64287);
  }
  
  public final void eoi()
  {
    AppMethodBeat.i(64285);
    getWindow().setDimAmount(0.5F);
    this.mrI.setBackgroundResource(a.e.popup_bg_without_shadow);
    this.BxJ.setBackground(null);
    AppMethodBeat.o(64285);
  }
  
  public final void eoj()
  {
    AppMethodBeat.i(64286);
    Log.d("MicroMsg.WalletFaceIdDialog", "trigger load start");
    this.BxF.a(a.e.faceid_verify_trigger, new FrameAnimatorImageView.a()
    {
      public final void onStop()
      {
        AppMethodBeat.i(64259);
        Log.d("MicroMsg.WalletFaceIdDialog", "trigger load finish");
        WalletFaceIdDialog.b(WalletFaceIdDialog.this).a(a.e.faceid_verify_breath, null);
        AppMethodBeat.o(64259);
      }
    });
    AppMethodBeat.o(64286);
  }
  
  @t(jl=h.a.ON_STOP)
  public void onActivityStop()
  {
    AppMethodBeat.i(64288);
    Log.i("MicroMsg.WalletFaceIdDialog", "activity pause");
    a.a(this.BxK);
    dismiss();
    AppMethodBeat.o(64288);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64281);
    super.onCreate(paramBundle);
    setContentView(this.mrI);
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
    WalletFaceIdDialog BxM;
    private com.tencent.mm.plugin.fingerprint.d.a BxN;
    private a BxO;
    private int BxP;
    boolean BxQ;
    private c BxR;
    private Bundle mab;
    private int retryCount;
    private int scene;
    
    public a(WalletFaceIdDialog paramWalletFaceIdDialog, a parama, Bundle paramBundle)
    {
      AppMethodBeat.i(64264);
      this.retryCount = 0;
      this.BxQ = false;
      this.BxR = new c()
      {
        public final void hu(int paramAnonymousInt1, int paramAnonymousInt2)
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
      this.BxM = paramWalletFaceIdDialog;
      this.BxO = parama;
      this.mab = paramBundle;
      if (this.mab != null) {
        this.scene = this.mab.getInt("face_auth_scene");
      }
      AppMethodBeat.o(64264);
    }
    
    private void eok()
    {
      AppMethodBeat.i(64265);
      this.BxN.userCancel();
      AppMethodBeat.o(64265);
    }
    
    final void eol()
    {
      AppMethodBeat.i(64266);
      Log.i("MicroMsg.WalletFaceIdDialog", "req faceid auth");
      if (this.BxN == null)
      {
        Log.w("MicroMsg.WalletFaceIdDialog", "mgr is null");
        AppMethodBeat.o(64266);
        return;
      }
      this.BxN.userCancel();
      if (!this.BxN.eoB())
      {
        Log.w("MicroMsg.WalletFaceIdDialog", "no faceid enrolled");
        onAuthFail(-2);
        AppMethodBeat.o(64266);
        return;
      }
      if (Util.isNullOrNil(p.ByH.ByB))
      {
        Log.i("MicroMsg.WalletFaceIdDialog", "no challenge");
        onAuthFail(-3);
        AppMethodBeat.o(64266);
        return;
      }
      this.BxN.a(this.BxR);
      this.BxM.eoj();
      AppMethodBeat.o(64266);
    }
    
    final void onAuthCancel()
    {
      AppMethodBeat.i(64268);
      Log.i("MicroMsg.WalletFaceIdDialog", "auth cancel");
      if (this.BxO != null)
      {
        this.BxO.onAuthCancel();
        this.BxO = null;
      }
      AppMethodBeat.o(64268);
    }
    
    final void onAuthFail(int paramInt)
    {
      AppMethodBeat.i(64267);
      Log.i("MicroMsg.WalletFaceIdDialog", "auth fail");
      if (this.BxO != null)
      {
        this.BxO.onAuthFail(paramInt);
        this.BxO = null;
      }
      this.BxM.dismiss();
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
      eok();
      if (this.scene == 1) {
        onAuthCancel();
      }
      AppMethodBeat.o(64269);
    }
    
    public final void onShow(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(64270);
      Log.i("MicroMsg.WalletFaceIdDialog", "face id dialog show");
      this.BxN = ((com.tencent.mm.plugin.fingerprint.d.a)h.ae(com.tencent.mm.plugin.fingerprint.d.a.class));
      f.ipn().ipo();
      eol();
      AppMethodBeat.o(64270);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdDialog
 * JD-Core Version:    0.7.0.1
 */