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
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.wallet.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.i;
import com.tencent.soter.a.g.f;

public class WalletFaceIdDialog
  extends i
  implements LifecycleObserver
{
  private View iCk;
  TextView kRB;
  FrameAnimatorImageView mFu;
  TextView mFv;
  private TextView mFw;
  ViewGroup mFx;
  private ViewGroup mFy;
  private a mFz;
  
  private WalletFaceIdDialog(Context paramContext)
  {
    super(paramContext, 2131493223);
    AppMethodBeat.i(41415);
    initView();
    AppMethodBeat.o(41415);
  }
  
  private WalletFaceIdDialog(Context paramContext, int paramInt)
  {
    super(paramContext, 2131493223);
    AppMethodBeat.i(41416);
    initView();
    AppMethodBeat.o(41416);
  }
  
  public WalletFaceIdDialog(Context paramContext, a parama)
  {
    this(paramContext, parama, null);
  }
  
  public WalletFaceIdDialog(Context paramContext, a parama, Bundle paramBundle)
  {
    this(paramContext);
    AppMethodBeat.i(41414);
    this.mFz = new a(this, parama, paramBundle);
    setOnShowListener(this.mFz);
    setOnDismissListener(this.mFz);
    setOnCancelListener(this.mFz);
    setCancelable(false);
    setCanceledOnTouchOutside(false);
    AppMethodBeat.o(41414);
  }
  
  private void byM()
  {
    AppMethodBeat.i(41420);
    this.iCk.setBackgroundColor(0);
    this.kRB.setTextColor(Color.parseColor("#888888"));
    AppMethodBeat.o(41420);
  }
  
  private void initView()
  {
    AppMethodBeat.i(41419);
    this.iCk = View.inflate(getContext(), 2130969520, null);
    this.mFy = ((ViewGroup)this.iCk.findViewById(2131823971));
    this.mFu = ((FrameAnimatorImageView)this.iCk.findViewById(2131823972));
    this.kRB = ((TextView)this.iCk.findViewById(2131823973));
    this.mFv = ((TextView)this.iCk.findViewById(2131823976));
    this.mFw = ((TextView)this.iCk.findViewById(2131823975));
    this.mFx = ((ViewGroup)this.iCk.findViewById(2131823974));
    byM();
    this.mFw.setOnClickListener(new WalletFaceIdDialog.1(this));
    this.mFv.setOnClickListener(new WalletFaceIdDialog.2(this));
    AppMethodBeat.o(41419);
  }
  
  public final void byN()
  {
    AppMethodBeat.i(41421);
    getWindow().setDimAmount(0.5F);
    this.iCk.setBackgroundResource(2130839961);
    this.mFy.setBackground(null);
    this.kRB.setTextColor(Color.parseColor("#111111"));
    this.kRB.setTextSize(0, getContext().getResources().getDimensionPixelSize(2131427507));
    AppMethodBeat.o(41421);
  }
  
  public final void byO()
  {
    AppMethodBeat.i(41422);
    ab.d("MicroMsg.WalletFaceIdDialog", "trigger load start");
    this.mFu.a(2130838789, new WalletFaceIdDialog.3(this));
    AppMethodBeat.o(41422);
  }
  
  public final void d(Animation.AnimationListener paramAnimationListener)
  {
    AppMethodBeat.i(41423);
    this.mFu.setImageResource(2130838736);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2131034172);
    this.mFu.startAnimation(localAnimation);
    if (paramAnimationListener != null) {
      localAnimation.setAnimationListener(paramAnimationListener);
    }
    AppMethodBeat.o(41423);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
  public void onActivityStop()
  {
    AppMethodBeat.i(41424);
    ab.i("MicroMsg.WalletFaceIdDialog", "activity pause");
    a.a(this.mFz);
    dismiss();
    AppMethodBeat.o(41424);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41417);
    super.onCreate(paramBundle);
    setContentView(this.iCk);
    AppMethodBeat.o(41417);
  }
  
  protected void onStart()
  {
    AppMethodBeat.i(41418);
    super.onStart();
    AppMethodBeat.o(41418);
  }
  
  static final class a
    implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener, DialogInterface.OnShowListener
  {
    private Bundle fPG;
    WalletFaceIdDialog mFB;
    private l mFC;
    private a mFD;
    private int mFE;
    boolean mFF;
    private d mFG;
    private int retryCount;
    private int scene;
    
    public a(WalletFaceIdDialog paramWalletFaceIdDialog, a parama, Bundle paramBundle)
    {
      AppMethodBeat.i(41400);
      this.retryCount = 0;
      this.mFF = false;
      this.mFG = new WalletFaceIdDialog.a.1(this);
      this.mFB = paramWalletFaceIdDialog;
      this.mFD = parama;
      this.fPG = paramBundle;
      if (this.fPG != null) {
        this.scene = this.fPG.getInt("face_auth_scene");
      }
      AppMethodBeat.o(41400);
    }
    
    private void byP()
    {
      AppMethodBeat.i(41401);
      this.mFC.userCancel();
      AppMethodBeat.o(41401);
    }
    
    final void byQ()
    {
      AppMethodBeat.i(41402);
      ab.i("MicroMsg.WalletFaceIdDialog", "req faceid auth");
      if (this.mFC == null)
      {
        ab.w("MicroMsg.WalletFaceIdDialog", "mgr is null");
        AppMethodBeat.o(41402);
        return;
      }
      this.mFC.bzh();
      this.mFC.bzg();
      if (!this.mFC.bzo())
      {
        ab.w("MicroMsg.WalletFaceIdDialog", "no faceid enrolled");
        onAuthFail(-2);
        AppMethodBeat.o(41402);
        return;
      }
      if (bo.isNullOrNil(x.uli.mGC))
      {
        ab.i("MicroMsg.WalletFaceIdDialog", "no challenge");
        onAuthFail(-3);
        AppMethodBeat.o(41402);
        return;
      }
      this.mFC.a(this.mFG);
      this.mFB.byO();
      AppMethodBeat.o(41402);
    }
    
    final void onAuthCancel()
    {
      AppMethodBeat.i(41404);
      ab.i("MicroMsg.WalletFaceIdDialog", "auth cancel");
      if (this.mFD != null)
      {
        this.mFD.onAuthCancel();
        this.mFD = null;
      }
      AppMethodBeat.o(41404);
    }
    
    final void onAuthFail(int paramInt)
    {
      AppMethodBeat.i(41403);
      ab.i("MicroMsg.WalletFaceIdDialog", "auth fail");
      if (this.mFD != null)
      {
        this.mFD.onAuthFail(paramInt);
        this.mFD = null;
      }
      this.mFB.dismiss();
      AppMethodBeat.o(41403);
    }
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(41407);
      ab.d("MicroMsg.WalletFaceIdDialog", "face id dialog cancel");
      onAuthCancel();
      AppMethodBeat.o(41407);
    }
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(41405);
      ab.i("MicroMsg.WalletFaceIdDialog", "face id dialog dismiss");
      byP();
      if (this.scene == 1) {
        onAuthCancel();
      }
      AppMethodBeat.o(41405);
    }
    
    public final void onShow(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(41406);
      ab.i("MicroMsg.WalletFaceIdDialog", "face id dialog show");
      this.mFC = ((l)g.E(l.class));
      f.dVD().dVE();
      byQ();
      AppMethodBeat.o(41406);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdDialog
 * JD-Core Version:    0.7.0.1
 */