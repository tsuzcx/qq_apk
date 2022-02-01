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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.luckymoney.f2f.a.c;
import com.tencent.mm.plugin.luckymoney.model.l;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBeforeDetailUI;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.cra;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.a;
import java.io.IOException;

@com.tencent.mm.ui.base.a(3)
public class LuckyMoneyF2FReceiveUI
  extends LuckyMoneyBaseUI
{
  private DisplayMetrics iNB;
  private String qeQ;
  private String vkl;
  private String vlA;
  private TextView vlW;
  private String vlr;
  private int vls;
  private String vlx;
  private String vlz;
  private View vmW;
  private CdnImageView vmX;
  private TextView vmY;
  private ImageView vmZ;
  private ValueAnimator vna;
  private ValueAnimator vnb;
  private Intent vnc;
  private boolean vnd = false;
  
  public int getLayoutId()
  {
    return 2131494643;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65109);
    super.onCreate(paramBundle);
    this.vmW = findViewById(2131301918);
    this.vmX = ((CdnImageView)findViewById(2131301921));
    this.vlW = ((TextView)findViewById(2131301922));
    this.vmY = ((TextView)findViewById(2131301924));
    this.vmZ = ((ImageView)findViewById(2131301931));
    this.vmZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65102);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/f2f/ui/LuckyMoneyF2FReceiveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        LuckyMoneyF2FReceiveUI.a(LuckyMoneyF2FReceiveUI.this).cancel();
        LuckyMoneyF2FReceiveUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/f2f/ui/LuckyMoneyF2FReceiveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(65102);
      }
    });
    getContentView().setVisibility(8);
    this.qeQ = getIntent().getStringExtra("key_share_url");
    k.Vy(6);
    doSceneProgress(new c(this.qeQ), true);
    this.iNB = getResources().getDisplayMetrics();
    this.vna = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F }).setDuration(300L);
    this.vnb = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(300L);
    this.vnb.setStartDelay(1000L);
    this.vna.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(65103);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        LuckyMoneyF2FReceiveUI.c(LuckyMoneyF2FReceiveUI.this).setTranslationY(-f * LuckyMoneyF2FReceiveUI.b(LuckyMoneyF2FReceiveUI.this).heightPixels);
        AppMethodBeat.o(65103);
      }
    });
    this.vna.addListener(new Animator.AnimatorListener()
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
    this.vnb.addListener(new Animator.AnimatorListener()
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
    if (this.vnd) {
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
    paramInt1 = ((c)localObject1).dNN;
    paramInt2 = ((c)localObject1).vlq;
    this.vls = ((c)localObject1).vls;
    int i = ((c)localObject1).vlu;
    Object localObject2 = ((c)localObject1).vlv;
    String str = ((c)localObject1).vlw;
    ad.i("LuckyMoneyF2FReceiveUI", "hbStatus: %d, recvStatus:%d, errorType:%d", new Object[] { Integer.valueOf(((c)localObject1).dNN), Integer.valueOf(((c)localObject1).vlq), Integer.valueOf(((c)localObject1).dnL) });
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
      this.vkl = ((c)localObject1).vkl;
      this.vlr = ((c)localObject1).vlr;
      this.vlz = ((c)localObject1).vlz;
      this.vlA = ((c)localObject1).vlA;
      this.vlx = ((c)localObject1).vlx;
      this.vnc = new Intent();
      if (bt.isNullOrNil(this.vlz))
      {
        if ((!bt.isNullOrNil(this.vlr)) && (!w.zD(this.vlr)))
        {
          paramString = new i();
          paramString.username = this.vlr;
          p.aEx().b(paramString);
        }
        z.b(this.vmX, null, this.vlr);
        label305:
        paramString = new l();
        paramString.dOa = this.vls;
        paramString.vkl = this.vkl;
        paramString.dNN = paramInt1;
        paramString.dNO = paramInt2;
        paramString.vlw = str;
        paramString.vlu = i;
        paramString.voz = this.vlr;
        paramString.vlv = ((String)localObject2);
        if (!bt.isNullOrNil(this.vlA)) {
          break label633;
        }
        paramString.voe = z.ze(this.vlr);
        label387:
        paramString.vlx = this.vlx;
        paramString.dNM = 2;
        ad.i("LuckyMoneyF2FReceiveUI", "is most lucky %d", new Object[] { Integer.valueOf(((c)localObject1).vly) });
        if (((c)localObject1).vly > 0) {
          paramString.vod = getString(2131760891);
        }
        if (!bt.isNullOrNil(this.vlz)) {
          break label644;
        }
      }
      for (paramString.vof = z.aoV(this.vlr);; paramString.vof = this.vlz)
      {
        try
        {
          this.vnc.putExtra("key_detail_info", paramString.toByteArray());
          paramString = ((c)localObject1).vlt;
          if (paramString != null)
          {
            localObject1 = new RealnameGuideHelper();
            ((RealnameGuideHelper)localObject1).b(String.valueOf(paramString.Fqw), paramString.vqB, paramString.kzK, paramString.kzL, paramString.vqC, paramn.getType());
            this.vnc.putExtra("key_realname_guide_helper", (Parcelable)localObject1);
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
            if (!bt.V(new String[] { this.vkl, this.vlr })) {
              z.a(this, this.vlW, z.ze(this.vlr));
            }
          }
        }
        if (bt.isNullOrNil(this.vlA)) {
          break label684;
        }
        z.a(this, this.vlW, this.vlA);
        z.a(this, this.vmY, this.vlx);
        this.vna.start();
        getContentView().setVisibility(0);
        break;
        j = BackwardSupportUtil.b.g(this, 48.0F);
        this.vmX.setRoundCorner(true);
        this.vmX.r(this.vlz, j, j, 2131231876);
        break label305;
        paramString.voe = this.vlA;
        break label387;
      }
    }
    label684:
    if (((c)localObject1).vlt != null)
    {
      ad.i("LuckyMoneyF2FReceiveUI", "need real name verify");
      localObject2 = ((c)localObject1).vlt;
      localObject1 = new RealnameGuideHelper();
      ((RealnameGuideHelper)localObject1).b(String.valueOf(((cra)localObject2).Fqw), ((cra)localObject2).vqB, ((cra)localObject2).kzK, ((cra)localObject2).kzL, ((cra)localObject2).vqC, paramn.getType());
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
        this.vnd = true;
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