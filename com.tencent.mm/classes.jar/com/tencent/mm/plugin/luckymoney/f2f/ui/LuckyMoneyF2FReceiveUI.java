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
import com.tencent.mm.am.j;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.luckymoney.f2f.a.c;
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBeforeDetailUI;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.utils.g;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.a;
import java.io.IOException;

@com.tencent.mm.ui.base.a(3)
public class LuckyMoneyF2FReceiveUI
  extends LuckyMoneyBaseUI
{
  private String EvN;
  private String EvP;
  private String EvQ;
  private TextView Ewm;
  private View Exm;
  private CdnImageView Exn;
  private TextView Exo;
  private ImageView Exp;
  private ValueAnimator Exq;
  private ValueAnimator Exr;
  private Intent Exs;
  private boolean Ext = false;
  private int amount;
  private String gby;
  private DisplayMetrics metrics;
  private String vhY;
  private String ybP;
  
  public int getLayoutId()
  {
    return a.g.lucky_money_f2f_receive_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65109);
    super.onCreate(paramBundle);
    this.Exm = findViewById(a.f.lucky_money_receive_ll_1);
    this.Exn = ((CdnImageView)findViewById(a.f.lucky_money_receive_sender_avatar));
    this.Ewm = ((TextView)findViewById(a.f.lucky_money_receive_sender_nickname));
    this.Exo = ((TextView)findViewById(a.f.lucky_money_receive_tips));
    this.Exp = ((ImageView)findViewById(a.f.lucky_money_recieve_close_btn));
    this.Exp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65102);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/f2f/ui/LuckyMoneyF2FReceiveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        LuckyMoneyF2FReceiveUI.a(LuckyMoneyF2FReceiveUI.this).cancel();
        LuckyMoneyF2FReceiveUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/f2f/ui/LuckyMoneyF2FReceiveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(65102);
      }
    });
    getContentView().setVisibility(8);
    this.vhY = getIntent().getStringExtra("key_share_url");
    com.tencent.mm.plugin.wallet_core.model.k.amw(6);
    doSceneProgress(new c(this.vhY), true);
    this.metrics = getResources().getDisplayMetrics();
    this.Exq = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F }).setDuration(300L);
    this.Exr = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(300L);
    this.Exr.setStartDelay(1000L);
    this.Exq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(65103);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        LuckyMoneyF2FReceiveUI.c(LuckyMoneyF2FReceiveUI.this).setTranslationY(-f * LuckyMoneyF2FReceiveUI.b(LuckyMoneyF2FReceiveUI.this).heightPixels);
        AppMethodBeat.o(65103);
      }
    });
    this.Exq.addListener(new Animator.AnimatorListener()
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
    this.Exr.addListener(new Animator.AnimatorListener()
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
    if (this.Ext) {
      finish();
    }
    AppMethodBeat.o(65110);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(65112);
    Log.i("LuckyMoneyF2FReceiveUI", "errType: %d,errCode: %d,errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!(paramq instanceof c))
    {
      AppMethodBeat.o(65112);
      return true;
    }
    Object localObject1 = (c)paramq;
    paramInt1 = ((c)localObject1).gbp;
    paramInt2 = ((c)localObject1).EvI;
    this.amount = ((c)localObject1).amount;
    int i = ((c)localObject1).EvK;
    Object localObject2 = ((c)localObject1).EvL;
    String str = ((c)localObject1).EvM;
    Log.i("LuckyMoneyF2FReceiveUI", "hbStatus: %d, recvStatus:%d, errorType:%d", new Object[] { Integer.valueOf(((c)localObject1).gbp), Integer.valueOf(((c)localObject1).EvI), Integer.valueOf(((c)localObject1).fyO) });
    if (g.a(((c)localObject1).EvH.SwQ))
    {
      paramString = new g(this);
      paramString.b(((c)localObject1).EvH.SwQ);
      paramString.Phv = true;
      AppMethodBeat.o(65112);
      return true;
    }
    Log.w("HABBYGE-MALI", "recvStatus=%s, hbStatus=%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    if (paramInt2 == 2)
    {
      if (paramInt1 == 5)
      {
        h.d(this, getString(a.i.lucky_money_f2f_has_expired), "", new DialogInterface.OnClickListener()
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
      this.ybP = ((c)localObject1).ybP;
      this.gby = ((c)localObject1).gby;
      this.EvP = ((c)localObject1).EvP;
      this.EvQ = ((c)localObject1).EvQ;
      this.EvN = ((c)localObject1).EvN;
      this.Exs = new Intent();
      if (Util.isNullOrNil(this.EvP))
      {
        if ((!Util.isNullOrNil(this.gby)) && (!ab.Ql(this.gby)))
        {
          paramString = new j();
          paramString.username = this.gby;
          com.tencent.mm.am.q.bhP().b(paramString);
        }
        ag.a(this.Exn, null, this.gby);
        label379:
        paramString = new com.tencent.mm.plugin.luckymoney.model.q();
        paramString.gbJ = this.amount;
        paramString.ybP = this.ybP;
        paramString.gbp = paramInt1;
        paramString.gbq = paramInt2;
        paramString.EvM = str;
        paramString.EvK = i;
        paramString.Ezw = this.gby;
        paramString.EvL = ((String)localObject2);
        if (!Util.isNullOrNil(this.EvQ)) {
          break label707;
        }
        paramString.Eza = ag.PI(this.gby);
        label461:
        paramString.EvN = this.EvN;
        paramString.gbo = 2;
        Log.i("LuckyMoneyF2FReceiveUI", "is most lucky %d", new Object[] { Integer.valueOf(((c)localObject1).EvO) });
        if (((c)localObject1).EvO > 0) {
          paramString.EyZ = getString(a.i.lucky_money_lucky_best);
        }
        if (!Util.isNullOrNil(this.EvP)) {
          break label718;
        }
      }
      for (paramString.Ezb = ag.aNF(this.gby);; paramString.Ezb = this.EvP)
      {
        try
        {
          this.Exs.putExtra("key_detail_info", paramString.toByteArray());
          paramString = ((c)localObject1).EvJ;
          if (paramString != null)
          {
            localObject1 = new RealnameGuideHelper();
            ((RealnameGuideHelper)localObject1).a(String.valueOf(paramString.REc), paramString.EBN, paramString.oDJ, paramString.oDK, paramString.EBO, paramq.getType());
            this.Exs.putExtra("key_realname_guide_helper", (Parcelable)localObject1);
          }
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            int j;
            label707:
            label718:
            Log.e("LuckyMoneyF2FReceiveUI", "lucky detail toBytes error: " + paramString.getMessage());
            continue;
            if (!Util.isNullOrNil(new String[] { this.ybP, this.gby })) {
              ag.a(this, this.Ewm, ag.PI(this.gby));
            }
          }
        }
        if (Util.isNullOrNil(this.EvQ)) {
          break label758;
        }
        ag.a(this, this.Ewm, this.EvQ);
        ag.a(this, this.Exo, this.EvN);
        this.Exq.start();
        getContentView().setVisibility(0);
        break;
        j = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 48.0F);
        this.Exn.setRoundCorner(true);
        this.Exn.w(this.EvP, j, j, a.e.default_avatar_shadow);
        break label379;
        paramString.Eza = this.EvQ;
        break label461;
      }
    }
    label758:
    if (((c)localObject1).EvJ != null)
    {
      Log.i("LuckyMoneyF2FReceiveUI", "need real name verify");
      localObject2 = ((c)localObject1).EvJ;
      localObject1 = new RealnameGuideHelper();
      ((RealnameGuideHelper)localObject1).a(String.valueOf(((dtj)localObject2).REc), ((dtj)localObject2).EBN, ((dtj)localObject2).oDJ, ((dtj)localObject2).oDK, ((dtj)localObject2).EBO, paramq.getType());
      paramq = new Bundle();
      paramq.putString("realname_verify_process_jump_activity", ".f2f.ui.LuckyMoneyF2FReceiveUI");
      paramq.putString("realname_verify_process_jump_plugin", "luckymoney");
      if (((RealnameGuideHelper)localObject1).a(this, paramq, new DialogInterface.OnClickListener()new d.a
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
        this.Ext = true;
        AppMethodBeat.o(65112);
        return true;
      }
    }
    paramq = paramString;
    if (Util.isNullOrNil(paramString)) {
      paramq = getString(a.i.lucky_money_f2f_receive_fail);
    }
    h.d(this, paramq, "", new DialogInterface.OnClickListener()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FReceiveUI
 * JD-Core Version:    0.7.0.1
 */