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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.n;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.luckymoney.f2f.a.c;
import com.tencent.mm.plugin.luckymoney.model.l;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBeforeDetailUI;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.cgx;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.a;
import java.io.IOException;

@a(3)
public class LuckyMoneyF2FReceiveUI
  extends LuckyMoneyBaseUI
{
  private DisplayMetrics hUu;
  private String oYa;
  private String sZn;
  private String taA;
  private String taC;
  private String taD;
  private TextView taZ;
  private String tau;
  private int tav;
  private View tbZ;
  private CdnImageView tca;
  private TextView tcb;
  private ImageView tcc;
  private ValueAnimator tcd;
  private ValueAnimator tce;
  private Intent tcf;
  private boolean tcg = false;
  
  public int getLayoutId()
  {
    return 2131494643;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65109);
    super.onCreate(paramBundle);
    this.tbZ = findViewById(2131301918);
    this.tca = ((CdnImageView)findViewById(2131301921));
    this.taZ = ((TextView)findViewById(2131301922));
    this.tcb = ((TextView)findViewById(2131301924));
    this.tcc = ((ImageView)findViewById(2131301931));
    this.tcc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65102);
        LuckyMoneyF2FReceiveUI.a(LuckyMoneyF2FReceiveUI.this).cancel();
        LuckyMoneyF2FReceiveUI.this.finish();
        AppMethodBeat.o(65102);
      }
    });
    getContentView().setVisibility(8);
    this.oYa = getIntent().getStringExtra("key_share_url");
    k.Rx(6);
    doSceneProgress(new c(this.oYa), true);
    this.hUu = getResources().getDisplayMetrics();
    this.tcd = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F }).setDuration(300L);
    this.tce = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(300L);
    this.tce.setStartDelay(1000L);
    this.tcd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(65103);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        LuckyMoneyF2FReceiveUI.c(LuckyMoneyF2FReceiveUI.this).setTranslationY(-f * LuckyMoneyF2FReceiveUI.b(LuckyMoneyF2FReceiveUI.this).heightPixels);
        AppMethodBeat.o(65103);
      }
    });
    this.tcd.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(65104);
        ad.i("LuckyMoneyF2FReceiveUI", "packet top in animator end");
        LuckyMoneyF2FReceiveUI.a(LuckyMoneyF2FReceiveUI.this).start();
        AppMethodBeat.o(65104);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    this.tce.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(65105);
        ad.i("LuckyMoneyF2FReceiveUI", "packet exit animator end");
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
    if (this.tcg) {
      finish();
    }
    AppMethodBeat.o(65110);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(65112);
    ad.i("LuckyMoneyF2FReceiveUI", "errType: %d,errCode: %d,errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!(paramn instanceof c))
    {
      AppMethodBeat.o(65112);
      return true;
    }
    Object localObject1 = (c)paramn;
    paramInt1 = ((c)localObject1).dDO;
    paramInt2 = ((c)localObject1).tat;
    this.tav = ((c)localObject1).tav;
    int i = ((c)localObject1).tax;
    Object localObject2 = ((c)localObject1).tay;
    String str = ((c)localObject1).taz;
    ad.i("LuckyMoneyF2FReceiveUI", "hbStatus: %d, recvStatus:%d, errorType:%d", new Object[] { Integer.valueOf(((c)localObject1).dDO), Integer.valueOf(((c)localObject1).tat), Integer.valueOf(((c)localObject1).deV) });
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
      this.sZn = ((c)localObject1).sZn;
      this.tau = ((c)localObject1).tau;
      this.taC = ((c)localObject1).taC;
      this.taD = ((c)localObject1).taD;
      this.taA = ((c)localObject1).taA;
      this.tcf = new Intent();
      if (bt.isNullOrNil(this.taC))
      {
        if ((!bt.isNullOrNil(this.tau)) && (!w.sD(this.tau)))
        {
          paramString = new i();
          paramString.username = this.tau;
          p.auF().b(paramString);
        }
        z.b(this.tca, null, this.tau);
        label305:
        paramString = new l();
        paramString.dEb = this.tav;
        paramString.sZn = this.sZn;
        paramString.dDO = paramInt1;
        paramString.dDP = paramInt2;
        paramString.taz = str;
        paramString.tax = i;
        paramString.tdE = this.tau;
        paramString.tay = ((String)localObject2);
        if (!bt.isNullOrNil(this.taD)) {
          break label633;
        }
        paramString.tdj = z.sg(this.tau);
        label387:
        paramString.taA = this.taA;
        paramString.dDN = 2;
        ad.i("LuckyMoneyF2FReceiveUI", "is most lucky %d", new Object[] { Integer.valueOf(((c)localObject1).taB) });
        if (((c)localObject1).taB > 0) {
          paramString.tdi = getString(2131760891);
        }
        if (!bt.isNullOrNil(this.taC)) {
          break label644;
        }
      }
      for (paramString.tdk = z.afo(this.tau);; paramString.tdk = this.taC)
      {
        try
        {
          this.tcf.putExtra("key_detail_info", paramString.toByteArray());
          paramString = ((c)localObject1).taw;
          if (paramString != null)
          {
            localObject1 = new RealnameGuideHelper();
            ((RealnameGuideHelper)localObject1).b(String.valueOf(paramString.Cta), paramString.tfG, paramString.tfH, paramString.tfI, paramString.tfJ, paramn.getType());
            this.tcf.putExtra("key_realname_guide_helper", (Parcelable)localObject1);
          }
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            int j;
            label633:
            ad.e("LuckyMoneyF2FReceiveUI", "lucky detail toBytes error: " + paramString.getMessage());
            label644:
            continue;
            if (!bt.T(new String[] { this.sZn, this.tau })) {
              z.a(this, this.taZ, z.sg(this.tau));
            }
          }
        }
        if (bt.isNullOrNil(this.taD)) {
          break label684;
        }
        z.a(this, this.taZ, this.taD);
        z.a(this, this.tcb, this.taA);
        this.tcd.start();
        getContentView().setVisibility(0);
        break;
        j = BackwardSupportUtil.b.g(this, 48.0F);
        this.tca.setRoundCorner(true);
        this.tca.r(this.taC, j, j, 2131231876);
        break label305;
        paramString.tdj = this.taD;
        break label387;
      }
    }
    label684:
    if (((c)localObject1).taw != null)
    {
      ad.i("LuckyMoneyF2FReceiveUI", "need real name verify");
      localObject2 = ((c)localObject1).taw;
      localObject1 = new RealnameGuideHelper();
      ((RealnameGuideHelper)localObject1).b(String.valueOf(((cgx)localObject2).Cta), ((cgx)localObject2).tfG, ((cgx)localObject2).tfH, ((cgx)localObject2).tfI, ((cgx)localObject2).tfJ, paramn.getType());
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
        public final Intent q(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          return null;
        }
      }, false))
      {
        this.tcg = true;
        AppMethodBeat.o(65112);
        return true;
      }
    }
    paramn = paramString;
    if (bt.isNullOrNil(paramString)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FReceiveUI
 * JD-Core Version:    0.7.0.1
 */