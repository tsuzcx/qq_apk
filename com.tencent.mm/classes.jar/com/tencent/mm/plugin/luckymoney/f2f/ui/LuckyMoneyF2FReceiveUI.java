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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBeforeDetailUI;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.alm;
import com.tencent.mm.protocal.protobuf.dju;
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
  private String ehh;
  private DisplayMetrics metrics;
  private String rCq;
  private String yQE;
  private int yRL;
  private String yRQ;
  private String yRS;
  private String yRT;
  private TextView ySp;
  private View yTp;
  private CdnImageView yTq;
  private TextView yTr;
  private ImageView yTs;
  private ValueAnimator yTt;
  private ValueAnimator yTu;
  private Intent yTv;
  private boolean yTw = false;
  
  public int getLayoutId()
  {
    return 2131495365;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65109);
    super.onCreate(paramBundle);
    this.yTp = findViewById(2131304240);
    this.yTq = ((CdnImageView)findViewById(2131304244));
    this.ySp = ((TextView)findViewById(2131304245));
    this.yTr = ((TextView)findViewById(2131304247));
    this.yTs = ((ImageView)findViewById(2131304254));
    this.yTs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65102);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/f2f/ui/LuckyMoneyF2FReceiveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        LuckyMoneyF2FReceiveUI.a(LuckyMoneyF2FReceiveUI.this).cancel();
        LuckyMoneyF2FReceiveUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/f2f/ui/LuckyMoneyF2FReceiveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(65102);
      }
    });
    getContentView().setVisibility(8);
    this.rCq = getIntent().getStringExtra("key_share_url");
    k.aeJ(6);
    doSceneProgress(new com.tencent.mm.plugin.luckymoney.f2f.a.c(this.rCq), true);
    this.metrics = getResources().getDisplayMetrics();
    this.yTt = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F }).setDuration(300L);
    this.yTu = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(300L);
    this.yTu.setStartDelay(1000L);
    this.yTt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(65103);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        LuckyMoneyF2FReceiveUI.c(LuckyMoneyF2FReceiveUI.this).setTranslationY(-f * LuckyMoneyF2FReceiveUI.b(LuckyMoneyF2FReceiveUI.this).heightPixels);
        AppMethodBeat.o(65103);
      }
    });
    this.yTt.addListener(new Animator.AnimatorListener()
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
    this.yTu.addListener(new Animator.AnimatorListener()
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
          LuckyMoneyF2FReceiveUI.this.overridePendingTransition(2130772119, 2130772124);
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
    if (this.yTw) {
      finish();
    }
    AppMethodBeat.o(65110);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(65112);
    Log.i("LuckyMoneyF2FReceiveUI", "errType: %d,errCode: %d,errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!(paramq instanceof com.tencent.mm.plugin.luckymoney.f2f.a.c))
    {
      AppMethodBeat.o(65112);
      return true;
    }
    Object localObject1 = (com.tencent.mm.plugin.luckymoney.f2f.a.c)paramq;
    paramInt1 = ((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).egZ;
    paramInt2 = ((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).yRK;
    this.yRL = ((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).yRL;
    int i = ((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).yRN;
    Object localObject2 = ((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).yRO;
    String str = ((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).yRP;
    Log.i("LuckyMoneyF2FReceiveUI", "hbStatus: %d, recvStatus:%d, errorType:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).egZ), Integer.valueOf(((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).yRK), Integer.valueOf(((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).dGe) });
    if (com.tencent.mm.plugin.wallet_core.utils.c.a(((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).yRJ.Lus))
    {
      paramString = new com.tencent.mm.plugin.wallet_core.utils.c(this);
      paramString.b(((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).yRJ.Lus);
      paramString.IoO = true;
      AppMethodBeat.o(65112);
      return true;
    }
    if (paramInt2 == 2)
    {
      if (paramInt1 == 5)
      {
        h.d(this, getString(2131762631), "", new DialogInterface.OnClickListener()
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
      this.yQE = ((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).yQE;
      this.ehh = ((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).ehh;
      this.yRS = ((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).yRS;
      this.yRT = ((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).yRT;
      this.yRQ = ((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).yRQ;
      this.yTv = new Intent();
      if (Util.isNullOrNil(this.yRS))
      {
        if ((!Util.isNullOrNil(this.ehh)) && (!ab.IS(this.ehh)))
        {
          paramString = new i();
          paramString.username = this.ehh;
          p.aYB().b(paramString);
        }
        af.a(this.yTq, null, this.ehh);
        label352:
        paramString = new com.tencent.mm.plugin.luckymoney.model.q();
        paramString.eht = this.yRL;
        paramString.yQE = this.yQE;
        paramString.egZ = paramInt1;
        paramString.eha = paramInt2;
        paramString.yRP = str;
        paramString.yRN = i;
        paramString.yVy = this.ehh;
        paramString.yRO = ((String)localObject2);
        if (!Util.isNullOrNil(this.yRT)) {
          break label680;
        }
        paramString.yVd = af.Ir(this.ehh);
        label434:
        paramString.yRQ = this.yRQ;
        paramString.egY = 2;
        Log.i("LuckyMoneyF2FReceiveUI", "is most lucky %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).yRR) });
        if (((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).yRR > 0) {
          paramString.yVc = getString(2131762660);
        }
        if (!Util.isNullOrNil(this.yRS)) {
          break label691;
        }
      }
      for (paramString.yVe = af.aDw(this.ehh);; paramString.yVe = this.yRS)
      {
        try
        {
          this.yTv.putExtra("key_detail_info", paramString.toByteArray());
          paramString = ((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).yRM;
          if (paramString != null)
          {
            localObject1 = new RealnameGuideHelper();
            ((RealnameGuideHelper)localObject1).b(String.valueOf(paramString.KCl), paramString.yXJ, paramString.lHA, paramString.lHB, paramString.yXK, paramq.getType());
            this.yTv.putExtra("key_realname_guide_helper", (Parcelable)localObject1);
          }
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            int j;
            label680:
            label691:
            Log.e("LuckyMoneyF2FReceiveUI", "lucky detail toBytes error: " + paramString.getMessage());
            continue;
            if (!Util.isNullOrNil(new String[] { this.yQE, this.ehh })) {
              af.a(this, this.ySp, af.Ir(this.ehh));
            }
          }
        }
        if (Util.isNullOrNil(this.yRT)) {
          break label731;
        }
        af.a(this, this.ySp, this.yRT);
        af.a(this, this.yTr, this.yRQ);
        this.yTt.start();
        getContentView().setVisibility(0);
        break;
        j = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 48.0F);
        this.yTq.setRoundCorner(true);
        this.yTq.s(this.yRS, j, j, 2131231958);
        break label352;
        paramString.yVd = this.yRT;
        break label434;
      }
    }
    label731:
    if (((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).yRM != null)
    {
      Log.i("LuckyMoneyF2FReceiveUI", "need real name verify");
      localObject2 = ((com.tencent.mm.plugin.luckymoney.f2f.a.c)localObject1).yRM;
      localObject1 = new RealnameGuideHelper();
      ((RealnameGuideHelper)localObject1).b(String.valueOf(((dju)localObject2).KCl), ((dju)localObject2).yXJ, ((dju)localObject2).lHA, ((dju)localObject2).lHB, ((dju)localObject2).yXK, paramq.getType());
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
        public final Intent q(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          return null;
        }
      }, false))
      {
        this.yTw = true;
        AppMethodBeat.o(65112);
        return true;
      }
    }
    paramq = paramString;
    if (Util.isNullOrNil(paramString)) {
      paramq = getString(2131762637);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FReceiveUI
 * JD-Core Version:    0.7.0.1
 */