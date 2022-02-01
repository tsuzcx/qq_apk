package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
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
import com.tencent.mm.am.p;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.luckymoney.f2f.a.c;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBeforeDetailUI;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.utils.j.a;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.aqf;
import com.tencent.mm.protocal.protobuf.dfc;
import com.tencent.mm.protocal.protobuf.eme;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.e.a;
import java.io.IOException;

@com.tencent.mm.ui.base.a(3)
public class LuckyMoneyF2FReceiveUI
  extends LuckyMoneyBaseUI
{
  private String CAf;
  private TextView KoV;
  private String Kov;
  private String Kox;
  private String Koy;
  private View KpV;
  private CdnImageView KpW;
  private TextView KpX;
  private ImageView KpY;
  private ValueAnimator KpZ;
  private ValueAnimator Kqa;
  private Intent Kqb;
  private boolean Kqc = false;
  private int amount;
  private String ihI;
  private DisplayMetrics metrics;
  private String ytZ;
  
  public int getLayoutId()
  {
    return a.g.lucky_money_f2f_receive_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65109);
    super.onCreate(paramBundle);
    this.KpV = findViewById(a.f.lucky_money_receive_ll_1);
    this.KpW = ((CdnImageView)findViewById(a.f.lucky_money_receive_sender_avatar));
    this.KoV = ((TextView)findViewById(a.f.lucky_money_receive_sender_nickname));
    this.KpX = ((TextView)findViewById(a.f.lucky_money_receive_tips));
    this.KpY = ((ImageView)findViewById(a.f.lucky_money_recieve_close_btn));
    this.KpY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65102);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/f2f/ui/LuckyMoneyF2FReceiveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        LuckyMoneyF2FReceiveUI.a(LuckyMoneyF2FReceiveUI.this).cancel();
        LuckyMoneyF2FReceiveUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/f2f/ui/LuckyMoneyF2FReceiveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(65102);
      }
    });
    getContentView().setVisibility(8);
    this.ytZ = getIntent().getStringExtra("key_share_url");
    com.tencent.mm.plugin.wallet_core.model.k.asj(6);
    doSceneProgress(new c(this.ytZ), true);
    this.metrics = getResources().getDisplayMetrics();
    this.KpZ = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F }).setDuration(300L);
    this.Kqa = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(300L);
    this.Kqa.setStartDelay(1000L);
    this.KpZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(65103);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        LuckyMoneyF2FReceiveUI.c(LuckyMoneyF2FReceiveUI.this).setTranslationY(-f * LuckyMoneyF2FReceiveUI.b(LuckyMoneyF2FReceiveUI.this).heightPixels);
        AppMethodBeat.o(65103);
      }
    });
    this.KpZ.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(65104);
        Log.i("LuckyMoneyF2FReceiveUI", "packet top in animator end");
        LuckyMoneyF2FReceiveUI.a(LuckyMoneyF2FReceiveUI.this).start();
        AppMethodBeat.o(65104);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    this.Kqa.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(65105);
        Log.i("LuckyMoneyF2FReceiveUI", "packet exit animator end");
        if (LuckyMoneyF2FReceiveUI.d(LuckyMoneyF2FReceiveUI.this) != null) {
          LuckyMoneyF2FReceiveUI.a(LuckyMoneyF2FReceiveUI.this, LuckyMoneyBeforeDetailUI.class, LuckyMoneyF2FReceiveUI.d(LuckyMoneyF2FReceiveUI.this));
        }
        LuckyMoneyF2FReceiveUI.this.setResult(-1, null);
        LuckyMoneyF2FReceiveUI.this.finish();
        if (LuckyMoneyF2FReceiveUI.d(LuckyMoneyF2FReceiveUI.this) != null) {
          LuckyMoneyF2FReceiveUI.this.overridePendingTransition(a.a.pop_in, a.a.pop_out);
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
    if (this.Kqc) {
      finish();
    }
    AppMethodBeat.o(65110);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(65112);
    Log.i("LuckyMoneyF2FReceiveUI", "errType: %d,errCode: %d,errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!(paramp instanceof c))
    {
      AppMethodBeat.o(65112);
      return true;
    }
    Object localObject1 = (c)paramp;
    paramInt1 = ((c)localObject1).ihz;
    paramInt2 = ((c)localObject1).Koq;
    this.amount = ((c)localObject1).amount;
    int i = ((c)localObject1).Kos;
    Object localObject2 = ((c)localObject1).Kot;
    Object localObject3 = ((c)localObject1).Kou;
    Log.i("LuckyMoneyF2FReceiveUI", "hbStatus: %d, recvStatus:%d, errorType:%d", new Object[] { Integer.valueOf(((c)localObject1).ihz), Integer.valueOf(((c)localObject1).Koq), Integer.valueOf(((c)localObject1).hDx) });
    if (com.tencent.mm.plugin.wallet_core.utils.j.a(((c)localObject1).Kop.ZxA))
    {
      new com.tencent.mm.plugin.wallet_core.utils.j(this).a(((c)localObject1).Kop.ZxA, new j.a()
      {
        public final void a(dfc paramAnonymousdfc)
        {
          AppMethodBeat.i(283858);
          if ((paramAnonymousdfc.action == 2) && (this.Kqe.Koz != null))
          {
            paramAnonymousdfc = new c(LuckyMoneyF2FReceiveUI.e(LuckyMoneyF2FReceiveUI.this), this.Kqe.Koz);
            LuckyMoneyF2FReceiveUI.this.doSceneProgress(paramAnonymousdfc, true);
            AppMethodBeat.o(283858);
            return;
          }
          LuckyMoneyF2FReceiveUI.this.finish();
          AppMethodBeat.o(283858);
        }
      });
      AppMethodBeat.o(65112);
      return true;
    }
    Log.w("HABBYGE-MALI", "recvStatus=%s, hbStatus=%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    if (paramInt2 == 2)
    {
      if (paramInt1 == 5)
      {
        com.tencent.mm.ui.base.k.d(this, getString(a.i.lucky_money_f2f_has_expired), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(65107);
            LuckyMoneyF2FReceiveUI.this.finish();
            AppMethodBeat.o(65107);
          }
        });
        AppMethodBeat.o(65112);
        return true;
      }
      this.CAf = ((c)localObject1).CAf;
      this.ihI = ((c)localObject1).ihI;
      this.Kox = ((c)localObject1).Kox;
      this.Koy = ((c)localObject1).Koy;
      this.Kov = ((c)localObject1).Kov;
      this.Kqb = new Intent();
      if (Util.isNullOrNil(this.Kox))
      {
        if ((!Util.isNullOrNil(this.ihI)) && (!ab.IR(this.ihI)))
        {
          paramString = new com.tencent.mm.modelavatar.j();
          paramString.username = this.ihI;
          com.tencent.mm.modelavatar.q.bFE().b(paramString);
        }
        ah.a(this.KpW, null, this.ihI);
        label382:
        paramString = new com.tencent.mm.plugin.luckymoney.model.q();
        paramString.ihV = this.amount;
        paramString.CAf = this.CAf;
        paramString.ihz = paramInt1;
        paramString.ihA = paramInt2;
        paramString.Kou = ((String)localObject3);
        paramString.Kos = i;
        paramString.Ksi = this.ihI;
        paramString.Kot = ((String)localObject2);
        if (!Util.isNullOrNil(this.Koy)) {
          break label710;
        }
        paramString.KrN = ah.ID(this.ihI);
        label464:
        paramString.Kov = this.Kov;
        paramString.ihy = 2;
        Log.i("LuckyMoneyF2FReceiveUI", "is most lucky %d", new Object[] { Integer.valueOf(((c)localObject1).Kow) });
        if (((c)localObject1).Kow > 0) {
          paramString.KrM = getString(a.i.lucky_money_lucky_best);
        }
        if (!Util.isNullOrNil(this.Kox)) {
          break label721;
        }
      }
      for (paramString.KrO = ah.aKC(this.ihI);; paramString.KrO = this.Kox)
      {
        try
        {
          this.Kqb.putExtra("key_detail_info", paramString.toByteArray());
          paramString = ((c)localObject1).Kor;
          if (paramString != null)
          {
            localObject1 = new RealnameGuideHelper();
            ((RealnameGuideHelper)localObject1).a(String.valueOf(paramString.YAF), paramString.KuO, paramString.rGU, paramString.right_button_wording, paramString.KuP, paramp.getType());
            this.Kqb.putExtra("key_realname_guide_helper", (Parcelable)localObject1);
          }
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            int j;
            label710:
            label721:
            Log.e("LuckyMoneyF2FReceiveUI", "lucky detail toBytes error: " + paramString.getMessage());
            continue;
            if (!Util.isNullOrNil(new String[] { this.CAf, this.ihI })) {
              ah.a(this, this.KoV, ah.ID(this.ihI));
            }
          }
        }
        if (Util.isNullOrNil(this.Koy)) {
          break label761;
        }
        ah.a(this, this.KoV, this.Koy);
        ah.a(this, this.KpX, this.Kov);
        this.KpZ.start();
        getContentView().setVisibility(0);
        break;
        j = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 48.0F);
        this.KpW.setRoundCorner(true);
        this.KpW.w(this.Kox, j, j, a.e.default_avatar_shadow);
        break label382;
        paramString.KrN = this.Koy;
        break label464;
      }
    }
    label761:
    if (((c)localObject1).Kor != null)
    {
      Log.i("LuckyMoneyF2FReceiveUI", "need real name verify");
      localObject3 = ((c)localObject1).Kor;
      localObject2 = new RealnameGuideHelper();
      ((RealnameGuideHelper)localObject2).a(String.valueOf(((eme)localObject3).YAF), ((eme)localObject3).KuO, ((eme)localObject3).rGU, ((eme)localObject3).right_button_wording, ((eme)localObject3).KuP, paramp.getType());
      paramp = new Bundle();
      paramp.putString("realname_verify_process_jump_activity", ".f2f.ui.LuckyMoneyF2FReceiveUI");
      paramp.putString("realname_verify_process_jump_plugin", "luckymoney");
      if (((RealnameGuideHelper)localObject2).a(this, paramp, new DialogInterface.OnClickListener()new e.a
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(283860);
          if ((this.Kqe.Koz != null) && (this.Kqe.Koz.Op.length > 0))
          {
            paramAnonymousDialogInterface = new c(LuckyMoneyF2FReceiveUI.e(LuckyMoneyF2FReceiveUI.this), this.Kqe.Koz);
            LuckyMoneyF2FReceiveUI.this.doSceneProgress(paramAnonymousDialogInterface, true);
            AppMethodBeat.o(283860);
            return;
          }
          LuckyMoneyF2FReceiveUI.this.finish();
          AppMethodBeat.o(283860);
        }
      }, new e.a()
      {
        public final Intent v(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          return null;
        }
      }, false))
      {
        this.Kqc = true;
        AppMethodBeat.o(65112);
        return true;
      }
    }
    paramp = paramString;
    if (Util.isNullOrNil(paramString)) {
      paramp = getString(a.i.lucky_money_f2f_receive_fail);
    }
    com.tencent.mm.ui.base.k.d(this, paramp, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(283859);
        LuckyMoneyF2FReceiveUI.this.finish();
        AppMethodBeat.o(283859);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FReceiveUI
 * JD-Core Version:    0.7.0.1
 */