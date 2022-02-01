package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.n;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.luckymoney.model.l;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBeforeDetailUI;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.aiy;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.a;
import java.io.IOException;

@com.tencent.mm.ui.base.a(3)
public class LuckyMoneyF2FReceiveUI
  extends LuckyMoneyBaseUI
{
  private DisplayMetrics iQv;
  private String qlv;
  private String vwq;
  private String vxC;
  private String vxE;
  private String vxF;
  private String vxw;
  private int vxx;
  private TextView vyb;
  private View vzb;
  private CdnImageView vzc;
  private TextView vzd;
  private ImageView vze;
  private ValueAnimator vzf;
  private ValueAnimator vzg;
  private Intent vzh;
  private boolean vzi = false;
  
  public int getLayoutId()
  {
    return 2131494643;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65109);
    super.onCreate(paramBundle);
    this.vzb = findViewById(2131301918);
    this.vzc = ((CdnImageView)findViewById(2131301921));
    this.vyb = ((TextView)findViewById(2131301922));
    this.vzd = ((TextView)findViewById(2131301924));
    this.vze = ((ImageView)findViewById(2131301931));
    this.vze.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65102);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/f2f/ui/LuckyMoneyF2FReceiveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        LuckyMoneyF2FReceiveUI.a(LuckyMoneyF2FReceiveUI.this).cancel();
        LuckyMoneyF2FReceiveUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/f2f/ui/LuckyMoneyF2FReceiveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(65102);
      }
    });
    getContentView().setVisibility(8);
    this.qlv = getIntent().getStringExtra("key_share_url");
    k.Wf(6);
    doSceneProgress(new com.tencent.mm.plugin.luckymoney.f2f.a.c(this.qlv), true);
    this.iQv = getResources().getDisplayMetrics();
    this.vzf = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F }).setDuration(300L);
    this.vzg = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(300L);
    this.vzg.setStartDelay(1000L);
    this.vzf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(65103);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        LuckyMoneyF2FReceiveUI.c(LuckyMoneyF2FReceiveUI.this).setTranslationY(-f * LuckyMoneyF2FReceiveUI.b(LuckyMoneyF2FReceiveUI.this).heightPixels);
        AppMethodBeat.o(65103);
      }
    });
    this.vzf.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(65104);
        ae.i("LuckyMoneyF2FReceiveUI", "packet top in animator end");
        LuckyMoneyF2FReceiveUI.a(LuckyMoneyF2FReceiveUI.this).start();
        AppMethodBeat.o(65104);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    this.vzg.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(65105);
        ae.i("LuckyMoneyF2FReceiveUI", "packet exit animator end");
        if (LuckyMoneyF2FReceiveUI.d(LuckyMoneyF2FReceiveUI.this) != null) {
          LuckyMoneyF2FReceiveUI.a(LuckyMoneyF2FReceiveUI.this, LuckyMoneyBeforeDetailUI.class, LuckyMoneyF2FReceiveUI.d(LuckyMoneyF2FReceiveUI.this));
        }
        LuckyMoneyF2FReceiveUI.this.setResult(-1, null);
        LuckyMoneyF2FReceiveUI.this.finish();
        if (LuckyMoneyF2FReceiveUI.d(LuckyMoneyF2FReceiveUI.this) != null) {
          LuckyMoneyF2FReceiveUI.this.overridePendingTransition(2130772095, 2130772100);
        }
        AppMethodBeat.o(65105);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    AppMethodBeat.o(65109);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65110);
    super.onResume();
    addSceneEndListener(1997);
    if (this.vzi) {
      finish();
    }
    AppMethodBeat.o(65110);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(65112);
    ae.i("LuckyMoneyF2FReceiveUI", "errType: %d,errCode: %d,errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!(paramn instanceof com.tencent.mm.plugin.luckymoney.f2f.a.c))
    {
      AppMethodBeat.o(65112);
      return true;
    }
    Object localObject1 = (com.tencent.mm.plugin.luckymoney.f2f.a.c)paramn;
    paramInt1 = ((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).dPd;
    paramInt2 = ((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).vxv;
    this.vxx = ((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).vxx;
    int i = ((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).vxz;
    Object localObject2 = ((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).vxA;
    String str = ((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).vxB;
    ae.i("LuckyMoneyF2FReceiveUI", "hbStatus: %d, recvStatus:%d, errorType:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).dPd), Integer.valueOf(((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).vxv), Integer.valueOf(((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).doQ) });
    if (com.tencent.mm.plugin.wallet_core.utils.c.a(((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).vxu.GyE))
    {
      paramString = new com.tencent.mm.plugin.wallet_core.utils.c(this);
      paramString.b(((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).vxu.GyE);
      paramString.DFD = true;
      AppMethodBeat.o(65112);
      return true;
    }
    if (paramInt2 == 2)
    {
      if (paramInt1 == 5)
      {
        h.d(this, getString(2131760862), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(65106);
            LuckyMoneyF2FReceiveUI.this.finish();
            AppMethodBeat.o(65106);
          }
        });
        AppMethodBeat.o(65112);
        return true;
      }
      this.vwq = ((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).vwq;
      this.vxw = ((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).vxw;
      this.vxE = ((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).vxE;
      this.vxF = ((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).vxF;
      this.vxC = ((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).vxC;
      this.vzh = new Intent();
      if (bu.isNullOrNil(this.vxE))
      {
        if ((!bu.isNullOrNil(this.vxw)) && (!x.An(this.vxw)))
        {
          paramString = new i();
          paramString.username = this.vxw;
          p.aEN().b(paramString);
        }
        z.b(this.vzc, null, this.vxw);
        label352:
        paramString = new l();
        paramString.dPq = this.vxx;
        paramString.vwq = this.vwq;
        paramString.dPd = paramInt1;
        paramString.dPe = paramInt2;
        paramString.vxB = str;
        paramString.vxz = i;
        paramString.vAE = this.vxw;
        paramString.vxA = ((String)localObject2);
        if (!bu.isNullOrNil(this.vxF)) {
          break label680;
        }
        paramString.vAj = z.zO(this.vxw);
        label434:
        paramString.vxC = this.vxC;
        paramString.dPc = 2;
        ae.i("LuckyMoneyF2FReceiveUI", "is most lucky %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).vxD) });
        if (((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).vxD > 0) {
          paramString.vAi = getString(2131760891);
        }
        if (!bu.isNullOrNil(this.vxE)) {
          break label691;
        }
      }
      for (paramString.vAk = z.aqa(this.vxw);; paramString.vAk = this.vxE)
      {
        try
        {
          this.vzh.putExtra("key_detail_info", paramString.toByteArray());
          paramString = ((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).vxy;
          if (paramString != null)
          {
            localObject1 = new RealnameGuideHelper();
            ((RealnameGuideHelper)localObject1).b(String.valueOf(paramString.FIU), paramString.vCG, paramString.kCZ, paramString.kDa, paramString.vCH, paramn.getType());
            this.vzh.putExtra("key_realname_guide_helper", (Parcelable)localObject1);
          }
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            int j;
            label680:
            label691:
            ae.e("LuckyMoneyF2FReceiveUI", "lucky detail toBytes error: " + paramString.getMessage());
            continue;
            if (!bu.V(new String[] { this.vwq, this.vxw })) {
              z.a(this, this.vyb, z.zO(this.vxw));
            }
          }
        }
        if (bu.isNullOrNil(this.vxF)) {
          break label731;
        }
        z.a(this, this.vyb, this.vxF);
        z.a(this, this.vzd, this.vxC);
        this.vzf.start();
        getContentView().setVisibility(0);
        break;
        j = BackwardSupportUtil.b.h(this, 48.0F);
        this.vzc.setRoundCorner(true);
        this.vzc.r(this.vxE, j, j, 2131231876);
        break label352;
        paramString.vAj = this.vxF;
        break label434;
      }
    }
    label731:
    if (((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).vxy != null)
    {
      ae.i("LuckyMoneyF2FReceiveUI", "need real name verify");
      localObject2 = ((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).vxy;
      localObject1 = new RealnameGuideHelper();
      ((RealnameGuideHelper)localObject1).b(String.valueOf(((cru)localObject2).FIU), ((cru)localObject2).vCG, ((cru)localObject2).kCZ, ((cru)localObject2).kDa, ((cru)localObject2).vCH, paramn.getType());
      paramn = new Bundle();
      paramn.putString("realname_verify_process_jump_activity", ".f2f.ui.LuckyMoneyF2FReceiveUI");
      paramn.putString("realname_verify_process_jump_plugin", "luckymoney");
      if (((RealnameGuideHelper)localObject1).a(this, paramn, new DialogInterface.OnClickListener()new d.a
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(65107);
          LuckyMoneyF2FReceiveUI.this.finish();
          AppMethodBeat.o(65107);
        }
      }, new d.a()
      {
        public final Intent s(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          return null;
        }
      }, false))
      {
        this.vzi = true;
        AppMethodBeat.o(65112);
        return true;
      }
    }
    paramn = paramString;
    if (bu.isNullOrNil(paramString)) {
      paramn = getString(2131760868);
    }
    h.d(this, paramn, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(65108);
        LuckyMoneyF2FReceiveUI.this.finish();
        AppMethodBeat.o(65108);
      }
    });
    AppMethodBeat.o(65112);
    return true;
  }
  
  public void onStop()
  {
    AppMethodBeat.i(65111);
    super.onStop();
    removeSceneEndListener(1997);
    AppMethodBeat.o(65111);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FReceiveUI
 * JD-Core Version:    0.7.0.1
 */