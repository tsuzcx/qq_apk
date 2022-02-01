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
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.luckymoney.f2f.a.c;
import com.tencent.mm.plugin.luckymoney.model.l;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBeforeDetailUI;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.cma;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.a;
import java.io.IOException;

@a(3)
public class LuckyMoneyF2FReceiveUI
  extends LuckyMoneyBaseUI
{
  private DisplayMetrics iuy;
  private String pBl;
  private String uhB;
  private String uiJ;
  private int uiK;
  private String uiP;
  private String uiR;
  private String uiS;
  private TextView ujo;
  private View uko;
  private CdnImageView ukp;
  private TextView ukq;
  private ImageView ukr;
  private ValueAnimator uks;
  private ValueAnimator ukt;
  private Intent uku;
  private boolean ukv = false;
  
  public int getLayoutId()
  {
    return 2131494643;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65109);
    super.onCreate(paramBundle);
    this.uko = findViewById(2131301918);
    this.ukp = ((CdnImageView)findViewById(2131301921));
    this.ujo = ((TextView)findViewById(2131301922));
    this.ukq = ((TextView)findViewById(2131301924));
    this.ukr = ((ImageView)findViewById(2131301931));
    this.ukr.setOnClickListener(new View.OnClickListener()
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
    this.pBl = getIntent().getStringExtra("key_share_url");
    k.TG(6);
    doSceneProgress(new c(this.pBl), true);
    this.iuy = getResources().getDisplayMetrics();
    this.uks = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F }).setDuration(300L);
    this.ukt = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(300L);
    this.ukt.setStartDelay(1000L);
    this.uks.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(65103);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        LuckyMoneyF2FReceiveUI.c(LuckyMoneyF2FReceiveUI.this).setTranslationY(-f * LuckyMoneyF2FReceiveUI.b(LuckyMoneyF2FReceiveUI.this).heightPixels);
        AppMethodBeat.o(65103);
      }
    });
    this.uks.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(65104);
        ac.i("LuckyMoneyF2FReceiveUI", "packet top in animator end");
        LuckyMoneyF2FReceiveUI.a(LuckyMoneyF2FReceiveUI.this).start();
        AppMethodBeat.o(65104);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    this.ukt.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(65105);
        ac.i("LuckyMoneyF2FReceiveUI", "packet exit animator end");
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
    if (this.ukv) {
      finish();
    }
    AppMethodBeat.o(65110);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(65112);
    ac.i("LuckyMoneyF2FReceiveUI", "errType: %d,errCode: %d,errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!(paramn instanceof c))
    {
      AppMethodBeat.o(65112);
      return true;
    }
    Object localObject1 = (c)paramn;
    paramInt1 = ((c)localObject1).dBA;
    paramInt2 = ((c)localObject1).uiI;
    this.uiK = ((c)localObject1).uiK;
    int i = ((c)localObject1).uiM;
    Object localObject2 = ((c)localObject1).uiN;
    String str = ((c)localObject1).uiO;
    ac.i("LuckyMoneyF2FReceiveUI", "hbStatus: %d, recvStatus:%d, errorType:%d", new Object[] { Integer.valueOf(((c)localObject1).dBA), Integer.valueOf(((c)localObject1).uiI), Integer.valueOf(((c)localObject1).dcp) });
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
      this.uhB = ((c)localObject1).uhB;
      this.uiJ = ((c)localObject1).uiJ;
      this.uiR = ((c)localObject1).uiR;
      this.uiS = ((c)localObject1).uiS;
      this.uiP = ((c)localObject1).uiP;
      this.uku = new Intent();
      if (bs.isNullOrNil(this.uiR))
      {
        if ((!bs.isNullOrNil(this.uiJ)) && (!w.wG(this.uiJ)))
        {
          paramString = new i();
          paramString.username = this.uiJ;
          p.aBw().b(paramString);
        }
        z.b(this.ukp, null, this.uiJ);
        label305:
        paramString = new l();
        paramString.dBN = this.uiK;
        paramString.uhB = this.uhB;
        paramString.dBA = paramInt1;
        paramString.dBB = paramInt2;
        paramString.uiO = str;
        paramString.uiM = i;
        paramString.ulT = this.uiJ;
        paramString.uiN = ((String)localObject2);
        if (!bs.isNullOrNil(this.uiS)) {
          break label633;
        }
        paramString.uly = z.wj(this.uiJ);
        label387:
        paramString.uiP = this.uiP;
        paramString.dBz = 2;
        ac.i("LuckyMoneyF2FReceiveUI", "is most lucky %d", new Object[] { Integer.valueOf(((c)localObject1).uiQ) });
        if (((c)localObject1).uiQ > 0) {
          paramString.ulx = getString(2131760891);
        }
        if (!bs.isNullOrNil(this.uiR)) {
          break label644;
        }
      }
      for (paramString.ulz = z.aki(this.uiJ);; paramString.ulz = this.uiR)
      {
        try
        {
          this.uku.putExtra("key_detail_info", paramString.toByteArray());
          paramString = ((c)localObject1).uiL;
          if (paramString != null)
          {
            localObject1 = new RealnameGuideHelper();
            ((RealnameGuideHelper)localObject1).b(String.valueOf(paramString.DLr), paramString.unV, paramString.unW, paramString.unX, paramString.unY, paramn.getType());
            this.uku.putExtra("key_realname_guide_helper", (Parcelable)localObject1);
          }
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            int j;
            label633:
            ac.e("LuckyMoneyF2FReceiveUI", "lucky detail toBytes error: " + paramString.getMessage());
            label644:
            continue;
            if (!bs.T(new String[] { this.uhB, this.uiJ })) {
              z.a(this, this.ujo, z.wj(this.uiJ));
            }
          }
        }
        if (bs.isNullOrNil(this.uiS)) {
          break label684;
        }
        z.a(this, this.ujo, this.uiS);
        z.a(this, this.ukq, this.uiP);
        this.uks.start();
        getContentView().setVisibility(0);
        break;
        j = BackwardSupportUtil.b.g(this, 48.0F);
        this.ukp.setRoundCorner(true);
        this.ukp.r(this.uiR, j, j, 2131231876);
        break label305;
        paramString.uly = this.uiS;
        break label387;
      }
    }
    label684:
    if (((c)localObject1).uiL != null)
    {
      ac.i("LuckyMoneyF2FReceiveUI", "need real name verify");
      localObject2 = ((c)localObject1).uiL;
      localObject1 = new RealnameGuideHelper();
      ((RealnameGuideHelper)localObject1).b(String.valueOf(((cma)localObject2).DLr), ((cma)localObject2).unV, ((cma)localObject2).unW, ((cma)localObject2).unX, ((cma)localObject2).unY, paramn.getType());
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
        public final Intent r(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          return null;
        }
      }, false))
      {
        this.ukv = true;
        AppMethodBeat.o(65112);
        return true;
      }
    }
    paramn = paramString;
    if (bs.isNullOrNil(paramString)) {
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