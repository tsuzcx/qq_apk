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
  private View hIZ;
  TextView lln;
  FrameAnimatorImageView rbm;
  TextView rbn;
  private TextView rbo;
  ViewGroup rbp;
  private ViewGroup rbq;
  private a rbr;
  
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
    this.rbr = new a(this, parama, paramBundle);
    setOnShowListener(this.rbr);
    setOnDismissListener(this.rbr);
    setOnCancelListener(this.rbr);
    setCancelable(false);
    setCanceledOnTouchOutside(false);
    AppMethodBeat.o(64278);
  }
  
  private void ctH()
  {
    AppMethodBeat.i(64284);
    this.hIZ.setBackgroundColor(0);
    this.lln.setTextColor(getContext().getResources().getColor(2131100212));
    AppMethodBeat.o(64284);
  }
  
  private void initView()
  {
    AppMethodBeat.i(64283);
    this.hIZ = View.inflate(getContext(), 2131493933, null);
    this.rbq = ((ViewGroup)this.hIZ.findViewById(2131299911));
    this.rbm = ((FrameAnimatorImageView)this.hIZ.findViewById(2131299907));
    this.lln = ((TextView)this.hIZ.findViewById(2131299910));
    this.rbn = ((TextView)this.hIZ.findViewById(2131299909));
    this.rbo = ((TextView)this.hIZ.findViewById(2131299908));
    this.rbp = ((ViewGroup)this.hIZ.findViewById(2131299906));
    ctH();
    this.rbo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64257);
        ad.d("MicroMsg.WalletFaceIdDialog", "click dismiss btn");
        paramAnonymousView = WalletFaceIdDialog.a(WalletFaceIdDialog.this);
        ad.i("MicroMsg.WalletFaceIdDialog", "click left btn");
        if (paramAnonymousView.rbx) {
          paramAnonymousView.onAuthFail(-1);
        }
        for (;;)
        {
          WalletFaceIdDialog.this.dismiss();
          AppMethodBeat.o(64257);
          return;
          paramAnonymousView.onAuthCancel();
        }
      }
    });
    this.rbn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64258);
        ad.d("MicroMsg.WalletFaceIdDialog", "click right btn");
        paramAnonymousView = WalletFaceIdDialog.a(WalletFaceIdDialog.this);
        ad.i("MicroMsg.WalletFaceIdDialog", "click right btn");
        WalletFaceIdDialog localWalletFaceIdDialog = paramAnonymousView.rbt;
        localWalletFaceIdDialog.rbn.setEnabled(false);
        localWalletFaceIdDialog.lln.setText(2131758804);
        paramAnonymousView.ctL();
        AppMethodBeat.o(64258);
      }
    });
    AppMethodBeat.o(64283);
  }
  
  public final void ctI()
  {
    AppMethodBeat.i(64285);
    getWindow().setDimAmount(0.5F);
    this.hIZ.setBackgroundResource(2131233633);
    this.rbq.setBackground(null);
    this.lln.setTextColor(getContext().getResources().getColor(2131100711));
    this.lln.setTextSize(0, getContext().getResources().getDimensionPixelSize(2131165200));
    AppMethodBeat.o(64285);
  }
  
  public final void ctJ()
  {
    AppMethodBeat.i(64286);
    ad.d("MicroMsg.WalletFaceIdDialog", "trigger load start");
    this.rbm.a(2131232230, new FrameAnimatorImageView.a()
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
    this.rbm.setImageResource(2131232177);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772038);
    this.rbm.startAnimation(localAnimation);
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
    a.a(this.rbr);
    dismiss();
    AppMethodBeat.o(64288);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64281);
    super.onCreate(paramBundle);
    setContentView(this.hIZ);
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
    private Bundle hsl;
    WalletFaceIdDialog rbt;
    private com.tencent.mm.plugin.fingerprint.d.a rbu;
    private a rbv;
    private int rbw;
    boolean rbx;
    private c rby;
    private int retryCount;
    private int scene;
    
    public a(WalletFaceIdDialog paramWalletFaceIdDialog, a parama, Bundle paramBundle)
    {
      AppMethodBeat.i(64264);
      this.retryCount = 0;
      this.rbx = false;
      this.rby = new c()
      {
        public final void fE(int paramAnonymousInt1, int paramAnonymousInt2)
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
      this.rbt = paramWalletFaceIdDialog;
      this.rbv = parama;
      this.hsl = paramBundle;
      if (this.hsl != null) {
        this.scene = this.hsl.getInt("face_auth_scene");
      }
      AppMethodBeat.o(64264);
    }
    
    private void ctK()
    {
      AppMethodBeat.i(64265);
      this.rbu.userCancel();
      AppMethodBeat.o(64265);
    }
    
    final void ctL()
    {
      AppMethodBeat.i(64266);
      ad.i("MicroMsg.WalletFaceIdDialog", "req faceid auth");
      if (this.rbu == null)
      {
        ad.w("MicroMsg.WalletFaceIdDialog", "mgr is null");
        AppMethodBeat.o(64266);
        return;
      }
      this.rbu.userCancel();
      if (!this.rbu.cub())
      {
        ad.w("MicroMsg.WalletFaceIdDialog", "no faceid enrolled");
        onAuthFail(-2);
        AppMethodBeat.o(64266);
        return;
      }
      if (bt.isNullOrNil(p.rcp.rcj))
      {
        ad.i("MicroMsg.WalletFaceIdDialog", "no challenge");
        onAuthFail(-3);
        AppMethodBeat.o(64266);
        return;
      }
      this.rbu.a(this.rby);
      this.rbt.ctJ();
      AppMethodBeat.o(64266);
    }
    
    final void onAuthCancel()
    {
      AppMethodBeat.i(64268);
      ad.i("MicroMsg.WalletFaceIdDialog", "auth cancel");
      if (this.rbv != null)
      {
        this.rbv.onAuthCancel();
        this.rbv = null;
      }
      AppMethodBeat.o(64268);
    }
    
    final void onAuthFail(int paramInt)
    {
      AppMethodBeat.i(64267);
      ad.i("MicroMsg.WalletFaceIdDialog", "auth fail");
      if (this.rbv != null)
      {
        this.rbv.onAuthFail(paramInt);
        this.rbv = null;
      }
      this.rbt.dismiss();
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
      ctK();
      if (this.scene == 1) {
        onAuthCancel();
      }
      AppMethodBeat.o(64269);
    }
    
    public final void onShow(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(64270);
      ad.i("MicroMsg.WalletFaceIdDialog", "face id dialog show");
      this.rbu = ((com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class));
      f.fnw().fnx();
      ctL();
      AppMethodBeat.o(64270);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdDialog
 * JD-Core Version:    0.7.0.1
 */