package com.tencent.mm.plugin.fingerprint.faceid.auth;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.p;
import com.tencent.mm.plugin.fingerprint.d.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.i;
import com.tencent.soter.a.g.f;

public class WalletFaceIdDialog
  extends i
  implements LifecycleObserver
{
  private View iCR;
  TextView mkS;
  FrameAnimatorImageView tgi;
  TextView tgj;
  private TextView tgk;
  ViewGroup tgl;
  private ViewGroup tgm;
  private a tgn;
  
  private WalletFaceIdDialog(Context paramContext)
  {
    super(paramContext, 2131820899);
    AppMethodBeat.i(64279);
    initView();
    AppMethodBeat.o(64279);
  }
  
  private WalletFaceIdDialog(Context paramContext, int paramInt)
  {
    super(paramContext, 2131820899);
    AppMethodBeat.i(64280);
    initView();
    AppMethodBeat.o(64280);
  }
  
  public WalletFaceIdDialog(Context paramContext, a parama)
  {
    this(paramContext, parama, null);
  }
  
  public WalletFaceIdDialog(Context paramContext, a parama, Bundle paramBundle)
  {
    this(paramContext);
    AppMethodBeat.i(64278);
    this.tgn = new a(this, parama, paramBundle);
    setOnShowListener(this.tgn);
    setOnDismissListener(this.tgn);
    setOnCancelListener(this.tgn);
    setCancelable(false);
    setCanceledOnTouchOutside(false);
    AppMethodBeat.o(64278);
  }
  
  private void cPi()
  {
    AppMethodBeat.i(64284);
    this.iCR.setBackgroundColor(0);
    this.mkS.setTextColor(getContext().getResources().getColor(2131100212));
    AppMethodBeat.o(64284);
  }
  
  private void initView()
  {
    AppMethodBeat.i(64283);
    this.iCR = View.inflate(getContext(), 2131493933, null);
    this.tgm = ((ViewGroup)this.iCR.findViewById(2131299911));
    this.tgi = ((FrameAnimatorImageView)this.iCR.findViewById(2131299907));
    this.mkS = ((TextView)this.iCR.findViewById(2131299910));
    this.tgj = ((TextView)this.iCR.findViewById(2131299909));
    this.tgk = ((TextView)this.iCR.findViewById(2131299908));
    this.tgl = ((ViewGroup)this.iCR.findViewById(2131299906));
    cPi();
    this.tgk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64257);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fingerprint/faceid/auth/WalletFaceIdDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.d("MicroMsg.WalletFaceIdDialog", "click dismiss btn");
        paramAnonymousView = WalletFaceIdDialog.a(WalletFaceIdDialog.this);
        ad.i("MicroMsg.WalletFaceIdDialog", "click left btn");
        if (paramAnonymousView.tgt) {
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
    this.tgj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64258);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fingerprint/faceid/auth/WalletFaceIdDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        ad.d("MicroMsg.WalletFaceIdDialog", "click right btn");
        paramAnonymousView = WalletFaceIdDialog.a(WalletFaceIdDialog.this);
        ad.i("MicroMsg.WalletFaceIdDialog", "click right btn");
        localObject = paramAnonymousView.tgp;
        ((WalletFaceIdDialog)localObject).tgj.setEnabled(false);
        ((WalletFaceIdDialog)localObject).mkS.setText(2131758804);
        paramAnonymousView.cPm();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fingerprint/faceid/auth/WalletFaceIdDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64258);
      }
    });
    AppMethodBeat.o(64283);
  }
  
  public final void cPj()
  {
    AppMethodBeat.i(64285);
    getWindow().setDimAmount(0.5F);
    this.iCR.setBackgroundResource(2131233633);
    this.tgm.setBackground(null);
    this.mkS.setTextColor(getContext().getResources().getColor(2131100711));
    this.mkS.setTextSize(0, getContext().getResources().getDimensionPixelSize(2131165200));
    AppMethodBeat.o(64285);
  }
  
  public final void cPk()
  {
    AppMethodBeat.i(64286);
    ad.d("MicroMsg.WalletFaceIdDialog", "trigger load start");
    this.tgi.a(2131232230, new FrameAnimatorImageView.a()
    {
      public final void onStop()
      {
        AppMethodBeat.i(64259);
        ad.d("MicroMsg.WalletFaceIdDialog", "trigger load finish");
        WalletFaceIdDialog.b(WalletFaceIdDialog.this).a(2131232227, null);
        AppMethodBeat.o(64259);
      }
    });
    AppMethodBeat.o(64286);
  }
  
  public final void d(Animation.AnimationListener paramAnimationListener)
  {
    AppMethodBeat.i(64287);
    this.tgi.setImageResource(2131232177);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772038);
    this.tgi.startAnimation(localAnimation);
    if (paramAnimationListener != null) {
      localAnimation.setAnimationListener(paramAnimationListener);
    }
    AppMethodBeat.o(64287);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
  public void onActivityStop()
  {
    AppMethodBeat.i(64288);
    ad.i("MicroMsg.WalletFaceIdDialog", "activity pause");
    a.a(this.tgn);
    dismiss();
    AppMethodBeat.o(64288);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64281);
    super.onCreate(paramBundle);
    setContentView(this.iCR);
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
    private Bundle ime;
    private int retryCount;
    private int scene;
    WalletFaceIdDialog tgp;
    private com.tencent.mm.plugin.fingerprint.d.a tgq;
    private a tgr;
    private int tgs;
    boolean tgt;
    private c tgu;
    
    public a(WalletFaceIdDialog paramWalletFaceIdDialog, a parama, Bundle paramBundle)
    {
      AppMethodBeat.i(64264);
      this.retryCount = 0;
      this.tgt = false;
      this.tgu = new c()
      {
        public final void gb(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(64260);
          ad.i("MicroMsg.WalletFaceIdDialog", "auth result: %s, retry: %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(WalletFaceIdDialog.a.b(WalletFaceIdDialog.a.this)) });
          switch (paramAnonymousInt1)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(64260);
            return;
            ad.i("MicroMsg.WalletFaceIdDialog", "identify success");
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
      this.tgp = paramWalletFaceIdDialog;
      this.tgr = parama;
      this.ime = paramBundle;
      if (this.ime != null) {
        this.scene = this.ime.getInt("face_auth_scene");
      }
      AppMethodBeat.o(64264);
    }
    
    private void cPl()
    {
      AppMethodBeat.i(64265);
      this.tgq.userCancel();
      AppMethodBeat.o(64265);
    }
    
    final void cPm()
    {
      AppMethodBeat.i(64266);
      ad.i("MicroMsg.WalletFaceIdDialog", "req faceid auth");
      if (this.tgq == null)
      {
        ad.w("MicroMsg.WalletFaceIdDialog", "mgr is null");
        AppMethodBeat.o(64266);
        return;
      }
      this.tgq.userCancel();
      if (!this.tgq.cPC())
      {
        ad.w("MicroMsg.WalletFaceIdDialog", "no faceid enrolled");
        onAuthFail(-2);
        AppMethodBeat.o(64266);
        return;
      }
      if (bt.isNullOrNil(p.thl.thf))
      {
        ad.i("MicroMsg.WalletFaceIdDialog", "no challenge");
        onAuthFail(-3);
        AppMethodBeat.o(64266);
        return;
      }
      this.tgq.a(this.tgu);
      this.tgp.cPk();
      AppMethodBeat.o(64266);
    }
    
    final void onAuthCancel()
    {
      AppMethodBeat.i(64268);
      ad.i("MicroMsg.WalletFaceIdDialog", "auth cancel");
      if (this.tgr != null)
      {
        this.tgr.onAuthCancel();
        this.tgr = null;
      }
      AppMethodBeat.o(64268);
    }
    
    final void onAuthFail(int paramInt)
    {
      AppMethodBeat.i(64267);
      ad.i("MicroMsg.WalletFaceIdDialog", "auth fail");
      if (this.tgr != null)
      {
        this.tgr.onAuthFail(paramInt);
        this.tgr = null;
      }
      this.tgp.dismiss();
      AppMethodBeat.o(64267);
    }
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(64271);
      ad.d("MicroMsg.WalletFaceIdDialog", "face id dialog cancel");
      onAuthCancel();
      AppMethodBeat.o(64271);
    }
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(64269);
      ad.i("MicroMsg.WalletFaceIdDialog", "face id dialog dismiss");
      cPl();
      if (this.scene == 1) {
        onAuthCancel();
      }
      AppMethodBeat.o(64269);
    }
    
    public final void onShow(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(64270);
      ad.i("MicroMsg.WalletFaceIdDialog", "face id dialog show");
      this.tgq = ((com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class));
      f.fVe().fVf();
      cPm();
      AppMethodBeat.o(64270);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdDialog
 * JD-Core Version:    0.7.0.1
 */