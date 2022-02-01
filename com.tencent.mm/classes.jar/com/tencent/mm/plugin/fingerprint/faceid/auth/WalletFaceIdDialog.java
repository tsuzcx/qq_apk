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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.i;
import com.tencent.soter.a.g.f;

public class WalletFaceIdDialog
  extends i
  implements LifecycleObserver
{
  private View ijA;
  TextView lLe;
  FrameAnimatorImageView sjG;
  TextView sjH;
  private TextView sjI;
  ViewGroup sjJ;
  private ViewGroup sjK;
  private a sjL;
  
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
    this.sjL = new a(this, parama, paramBundle);
    setOnShowListener(this.sjL);
    setOnDismissListener(this.sjL);
    setOnCancelListener(this.sjL);
    setCancelable(false);
    setCanceledOnTouchOutside(false);
    AppMethodBeat.o(64278);
  }
  
  private void cGT()
  {
    AppMethodBeat.i(64284);
    this.ijA.setBackgroundColor(0);
    this.lLe.setTextColor(getContext().getResources().getColor(2131100212));
    AppMethodBeat.o(64284);
  }
  
  private void initView()
  {
    AppMethodBeat.i(64283);
    this.ijA = View.inflate(getContext(), 2131493933, null);
    this.sjK = ((ViewGroup)this.ijA.findViewById(2131299911));
    this.sjG = ((FrameAnimatorImageView)this.ijA.findViewById(2131299907));
    this.lLe = ((TextView)this.ijA.findViewById(2131299910));
    this.sjH = ((TextView)this.ijA.findViewById(2131299909));
    this.sjI = ((TextView)this.ijA.findViewById(2131299908));
    this.sjJ = ((ViewGroup)this.ijA.findViewById(2131299906));
    cGT();
    this.sjI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64257);
        ac.d("MicroMsg.WalletFaceIdDialog", "click dismiss btn");
        paramAnonymousView = WalletFaceIdDialog.a(WalletFaceIdDialog.this);
        ac.i("MicroMsg.WalletFaceIdDialog", "click left btn");
        if (paramAnonymousView.sjR) {
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
    this.sjH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64258);
        ac.d("MicroMsg.WalletFaceIdDialog", "click right btn");
        paramAnonymousView = WalletFaceIdDialog.a(WalletFaceIdDialog.this);
        ac.i("MicroMsg.WalletFaceIdDialog", "click right btn");
        WalletFaceIdDialog localWalletFaceIdDialog = paramAnonymousView.sjN;
        localWalletFaceIdDialog.sjH.setEnabled(false);
        localWalletFaceIdDialog.lLe.setText(2131758804);
        paramAnonymousView.cGX();
        AppMethodBeat.o(64258);
      }
    });
    AppMethodBeat.o(64283);
  }
  
  public final void cGU()
  {
    AppMethodBeat.i(64285);
    getWindow().setDimAmount(0.5F);
    this.ijA.setBackgroundResource(2131233633);
    this.sjK.setBackground(null);
    this.lLe.setTextColor(getContext().getResources().getColor(2131100711));
    this.lLe.setTextSize(0, getContext().getResources().getDimensionPixelSize(2131165200));
    AppMethodBeat.o(64285);
  }
  
  public final void cGV()
  {
    AppMethodBeat.i(64286);
    ac.d("MicroMsg.WalletFaceIdDialog", "trigger load start");
    this.sjG.a(2131232230, new FrameAnimatorImageView.a()
    {
      public final void onStop()
      {
        AppMethodBeat.i(64259);
        ac.d("MicroMsg.WalletFaceIdDialog", "trigger load finish");
        WalletFaceIdDialog.b(WalletFaceIdDialog.this).a(2131232227, null);
        AppMethodBeat.o(64259);
      }
    });
    AppMethodBeat.o(64286);
  }
  
  public final void d(Animation.AnimationListener paramAnimationListener)
  {
    AppMethodBeat.i(64287);
    this.sjG.setImageResource(2131232177);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772038);
    this.sjG.startAnimation(localAnimation);
    if (paramAnimationListener != null) {
      localAnimation.setAnimationListener(paramAnimationListener);
    }
    AppMethodBeat.o(64287);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
  public void onActivityStop()
  {
    AppMethodBeat.i(64288);
    ac.i("MicroMsg.WalletFaceIdDialog", "activity pause");
    a.a(this.sjL);
    dismiss();
    AppMethodBeat.o(64288);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64281);
    super.onCreate(paramBundle);
    setContentView(this.ijA);
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
    private Bundle hSN;
    private int retryCount;
    private int scene;
    WalletFaceIdDialog sjN;
    private com.tencent.mm.plugin.fingerprint.d.a sjO;
    private a sjP;
    private int sjQ;
    boolean sjR;
    private c sjS;
    
    public a(WalletFaceIdDialog paramWalletFaceIdDialog, a parama, Bundle paramBundle)
    {
      AppMethodBeat.i(64264);
      this.retryCount = 0;
      this.sjR = false;
      this.sjS = new c()
      {
        public final void fL(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(64260);
          ac.i("MicroMsg.WalletFaceIdDialog", "auth result: %s, retry: %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(WalletFaceIdDialog.a.b(WalletFaceIdDialog.a.this)) });
          switch (paramAnonymousInt1)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(64260);
            return;
            ac.i("MicroMsg.WalletFaceIdDialog", "identify success");
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
      this.sjN = paramWalletFaceIdDialog;
      this.sjP = parama;
      this.hSN = paramBundle;
      if (this.hSN != null) {
        this.scene = this.hSN.getInt("face_auth_scene");
      }
      AppMethodBeat.o(64264);
    }
    
    private void cGW()
    {
      AppMethodBeat.i(64265);
      this.sjO.userCancel();
      AppMethodBeat.o(64265);
    }
    
    final void cGX()
    {
      AppMethodBeat.i(64266);
      ac.i("MicroMsg.WalletFaceIdDialog", "req faceid auth");
      if (this.sjO == null)
      {
        ac.w("MicroMsg.WalletFaceIdDialog", "mgr is null");
        AppMethodBeat.o(64266);
        return;
      }
      this.sjO.userCancel();
      if (!this.sjO.cHn())
      {
        ac.w("MicroMsg.WalletFaceIdDialog", "no faceid enrolled");
        onAuthFail(-2);
        AppMethodBeat.o(64266);
        return;
      }
      if (bs.isNullOrNil(p.skJ.skD))
      {
        ac.i("MicroMsg.WalletFaceIdDialog", "no challenge");
        onAuthFail(-3);
        AppMethodBeat.o(64266);
        return;
      }
      this.sjO.a(this.sjS);
      this.sjN.cGV();
      AppMethodBeat.o(64266);
    }
    
    final void onAuthCancel()
    {
      AppMethodBeat.i(64268);
      ac.i("MicroMsg.WalletFaceIdDialog", "auth cancel");
      if (this.sjP != null)
      {
        this.sjP.onAuthCancel();
        this.sjP = null;
      }
      AppMethodBeat.o(64268);
    }
    
    final void onAuthFail(int paramInt)
    {
      AppMethodBeat.i(64267);
      ac.i("MicroMsg.WalletFaceIdDialog", "auth fail");
      if (this.sjP != null)
      {
        this.sjP.onAuthFail(paramInt);
        this.sjP = null;
      }
      this.sjN.dismiss();
      AppMethodBeat.o(64267);
    }
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(64271);
      ac.d("MicroMsg.WalletFaceIdDialog", "face id dialog cancel");
      onAuthCancel();
      AppMethodBeat.o(64271);
    }
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(64269);
      ac.i("MicroMsg.WalletFaceIdDialog", "face id dialog dismiss");
      cGW();
      if (this.scene == 1) {
        onAuthCancel();
      }
      AppMethodBeat.o(64269);
    }
    
    public final void onShow(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(64270);
      ac.i("MicroMsg.WalletFaceIdDialog", "face id dialog show");
      this.sjO = ((com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class));
      f.fDM().fDN();
      cGX();
      AppMethodBeat.o(64270);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdDialog
 * JD-Core Version:    0.7.0.1
 */