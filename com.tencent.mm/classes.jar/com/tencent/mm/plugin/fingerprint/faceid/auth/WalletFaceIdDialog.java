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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.i;
import com.tencent.soter.a.g.f;

public class WalletFaceIdDialog
  extends i
  implements LifecycleObserver
{
  private View iFK;
  TextView mpP;
  FrameAnimatorImageView trb;
  TextView trc;
  private TextView trd;
  ViewGroup tre;
  private ViewGroup trf;
  private a trg;
  
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
    this.trg = new a(this, parama, paramBundle);
    setOnShowListener(this.trg);
    setOnDismissListener(this.trg);
    setOnCancelListener(this.trg);
    setCancelable(false);
    setCanceledOnTouchOutside(false);
    AppMethodBeat.o(64278);
  }
  
  private void cRN()
  {
    AppMethodBeat.i(64284);
    this.iFK.setBackgroundColor(0);
    this.mpP.setTextColor(getContext().getResources().getColor(2131100212));
    AppMethodBeat.o(64284);
  }
  
  private void initView()
  {
    AppMethodBeat.i(64283);
    this.iFK = View.inflate(getContext(), 2131493933, null);
    this.trf = ((ViewGroup)this.iFK.findViewById(2131299911));
    this.trb = ((FrameAnimatorImageView)this.iFK.findViewById(2131299907));
    this.mpP = ((TextView)this.iFK.findViewById(2131299910));
    this.trc = ((TextView)this.iFK.findViewById(2131299909));
    this.trd = ((TextView)this.iFK.findViewById(2131299908));
    this.tre = ((ViewGroup)this.iFK.findViewById(2131299906));
    cRN();
    this.trd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64257);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fingerprint/faceid/auth/WalletFaceIdDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.d("MicroMsg.WalletFaceIdDialog", "click dismiss btn");
        paramAnonymousView = WalletFaceIdDialog.a(WalletFaceIdDialog.this);
        ae.i("MicroMsg.WalletFaceIdDialog", "click left btn");
        if (paramAnonymousView.trm) {
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
    this.trc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64258);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fingerprint/faceid/auth/WalletFaceIdDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        ae.d("MicroMsg.WalletFaceIdDialog", "click right btn");
        paramAnonymousView = WalletFaceIdDialog.a(WalletFaceIdDialog.this);
        ae.i("MicroMsg.WalletFaceIdDialog", "click right btn");
        localObject = paramAnonymousView.tri;
        ((WalletFaceIdDialog)localObject).trc.setEnabled(false);
        ((WalletFaceIdDialog)localObject).mpP.setText(2131758804);
        paramAnonymousView.cRR();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fingerprint/faceid/auth/WalletFaceIdDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64258);
      }
    });
    AppMethodBeat.o(64283);
  }
  
  public final void cRO()
  {
    AppMethodBeat.i(64285);
    getWindow().setDimAmount(0.5F);
    this.iFK.setBackgroundResource(2131233633);
    this.trf.setBackground(null);
    this.mpP.setTextColor(getContext().getResources().getColor(2131100711));
    this.mpP.setTextSize(0, getContext().getResources().getDimensionPixelSize(2131165200));
    AppMethodBeat.o(64285);
  }
  
  public final void cRP()
  {
    AppMethodBeat.i(64286);
    ae.d("MicroMsg.WalletFaceIdDialog", "trigger load start");
    this.trb.a(2131232230, new FrameAnimatorImageView.a()
    {
      public final void onStop()
      {
        AppMethodBeat.i(64259);
        ae.d("MicroMsg.WalletFaceIdDialog", "trigger load finish");
        WalletFaceIdDialog.b(WalletFaceIdDialog.this).a(2131232227, null);
        AppMethodBeat.o(64259);
      }
    });
    AppMethodBeat.o(64286);
  }
  
  public final void d(Animation.AnimationListener paramAnimationListener)
  {
    AppMethodBeat.i(64287);
    this.trb.setImageResource(2131232177);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772038);
    this.trb.startAnimation(localAnimation);
    if (paramAnimationListener != null) {
      localAnimation.setAnimationListener(paramAnimationListener);
    }
    AppMethodBeat.o(64287);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
  public void onActivityStop()
  {
    AppMethodBeat.i(64288);
    ae.i("MicroMsg.WalletFaceIdDialog", "activity pause");
    a.a(this.trg);
    dismiss();
    AppMethodBeat.o(64288);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64281);
    super.onCreate(paramBundle);
    setContentView(this.iFK);
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
    private Bundle ioY;
    private int retryCount;
    private int scene;
    WalletFaceIdDialog tri;
    private com.tencent.mm.plugin.fingerprint.d.a trj;
    private a trk;
    private int trl;
    boolean trm;
    private c trn;
    
    public a(WalletFaceIdDialog paramWalletFaceIdDialog, a parama, Bundle paramBundle)
    {
      AppMethodBeat.i(64264);
      this.retryCount = 0;
      this.trm = false;
      this.trn = new c()
      {
        public final void gb(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(64260);
          ae.i("MicroMsg.WalletFaceIdDialog", "auth result: %s, retry: %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(WalletFaceIdDialog.a.b(WalletFaceIdDialog.a.this)) });
          switch (paramAnonymousInt1)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(64260);
            return;
            ae.i("MicroMsg.WalletFaceIdDialog", "identify success");
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
      this.tri = paramWalletFaceIdDialog;
      this.trk = parama;
      this.ioY = paramBundle;
      if (this.ioY != null) {
        this.scene = this.ioY.getInt("face_auth_scene");
      }
      AppMethodBeat.o(64264);
    }
    
    private void cRQ()
    {
      AppMethodBeat.i(64265);
      this.trj.userCancel();
      AppMethodBeat.o(64265);
    }
    
    final void cRR()
    {
      AppMethodBeat.i(64266);
      ae.i("MicroMsg.WalletFaceIdDialog", "req faceid auth");
      if (this.trj == null)
      {
        ae.w("MicroMsg.WalletFaceIdDialog", "mgr is null");
        AppMethodBeat.o(64266);
        return;
      }
      this.trj.userCancel();
      if (!this.trj.cSh())
      {
        ae.w("MicroMsg.WalletFaceIdDialog", "no faceid enrolled");
        onAuthFail(-2);
        AppMethodBeat.o(64266);
        return;
      }
      if (bu.isNullOrNil(p.tse.trY))
      {
        ae.i("MicroMsg.WalletFaceIdDialog", "no challenge");
        onAuthFail(-3);
        AppMethodBeat.o(64266);
        return;
      }
      this.trj.a(this.trn);
      this.tri.cRP();
      AppMethodBeat.o(64266);
    }
    
    final void onAuthCancel()
    {
      AppMethodBeat.i(64268);
      ae.i("MicroMsg.WalletFaceIdDialog", "auth cancel");
      if (this.trk != null)
      {
        this.trk.onAuthCancel();
        this.trk = null;
      }
      AppMethodBeat.o(64268);
    }
    
    final void onAuthFail(int paramInt)
    {
      AppMethodBeat.i(64267);
      ae.i("MicroMsg.WalletFaceIdDialog", "auth fail");
      if (this.trk != null)
      {
        this.trk.onAuthFail(paramInt);
        this.trk = null;
      }
      this.tri.dismiss();
      AppMethodBeat.o(64267);
    }
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(64271);
      ae.d("MicroMsg.WalletFaceIdDialog", "face id dialog cancel");
      onAuthCancel();
      AppMethodBeat.o(64271);
    }
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(64269);
      ae.i("MicroMsg.WalletFaceIdDialog", "face id dialog dismiss");
      cRQ();
      if (this.scene == 1) {
        onAuthCancel();
      }
      AppMethodBeat.o(64269);
    }
    
    public final void onShow(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(64270);
      ae.i("MicroMsg.WalletFaceIdDialog", "face id dialog show");
      this.trj = ((com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class));
      f.fZD().fZE();
      cRR();
      AppMethodBeat.o(64270);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdDialog
 * JD-Core Version:    0.7.0.1
 */