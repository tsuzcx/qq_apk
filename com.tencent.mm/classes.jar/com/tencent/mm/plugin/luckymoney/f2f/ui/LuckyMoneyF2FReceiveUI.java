package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.luckymoney.f2f.a.c;
import com.tencent.mm.plugin.luckymoney.model.k;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.protocal.protobuf.bry;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import java.io.IOException;

@a(3)
public class LuckyMoneyF2FReceiveUI
  extends LuckyMoneyBaseUI
{
  private DisplayMetrics gjH;
  private String lHq;
  private String ojA;
  private String okG;
  private int okH;
  private String okM;
  private ImageView oli;
  private TextView olj;
  private View omj;
  private TextView omk;
  private ImageView oml;
  private ValueAnimator omm;
  private ValueAnimator omn;
  private Intent omo;
  private boolean omp = false;
  
  public int getLayoutId()
  {
    return 2130970029;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42219);
    super.onCreate(paramBundle);
    this.omj = findViewById(2131825684);
    this.oli = ((ImageView)findViewById(2131825680));
    this.olj = ((TextView)findViewById(2131825681));
    this.omk = ((TextView)findViewById(2131825686));
    this.oml = ((ImageView)findViewById(2131825688));
    this.oml.setOnClickListener(new LuckyMoneyF2FReceiveUI.1(this));
    getContentView().setVisibility(8);
    this.lHq = getIntent().getStringExtra("key_share_url");
    com.tencent.mm.plugin.wallet_core.model.m.Iy(6);
    doSceneProgress(new c(this.lHq), true);
    this.gjH = getResources().getDisplayMetrics();
    this.omm = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F }).setDuration(300L);
    this.omn = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(300L);
    this.omn.setStartDelay(1000L);
    this.omm.addUpdateListener(new LuckyMoneyF2FReceiveUI.2(this));
    this.omm.addListener(new LuckyMoneyF2FReceiveUI.3(this));
    this.omn.addListener(new LuckyMoneyF2FReceiveUI.4(this));
    AppMethodBeat.o(42219);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(42220);
    super.onResume();
    addSceneEndListener(1997);
    if (this.omp) {
      finish();
    }
    AppMethodBeat.o(42220);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(42222);
    ab.i("LuckyMoneyF2FReceiveUI", "errType: %d,errCode: %d,errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!(paramm instanceof c))
    {
      AppMethodBeat.o(42222);
      return true;
    }
    Object localObject1 = (c)paramm;
    paramInt1 = ((c)localObject1).cMQ;
    paramInt2 = ((c)localObject1).okF;
    this.okH = ((c)localObject1).okH;
    int i = ((c)localObject1).okJ;
    Object localObject2 = ((c)localObject1).okK;
    String str = ((c)localObject1).okL;
    ab.i("LuckyMoneyF2FReceiveUI", "hbStatus: %d, recvStatus:%d, errorType:%d", new Object[] { Integer.valueOf(((c)localObject1).cMQ), Integer.valueOf(((c)localObject1).okF), Integer.valueOf(((c)localObject1).cpX) });
    if (paramInt2 == 2)
    {
      if (paramInt1 == 5) {
        com.tencent.mm.ui.base.h.a(this, getString(2131301220), "", new LuckyMoneyF2FReceiveUI.5(this));
      }
      for (;;)
      {
        AppMethodBeat.o(42222);
        return true;
        this.ojA = ((c)localObject1).ojA;
        this.okG = ((c)localObject1).okG;
        this.okM = ((c)localObject1).okM;
        this.omo = new Intent();
        if ((!bo.isNullOrNil(this.okG)) && (!t.nT(this.okG)))
        {
          paramString = new com.tencent.mm.ah.h();
          paramString.username = this.okG;
          o.adg().b(paramString);
        }
        x.b(this.oli, null, this.okG);
        paramString = new k();
        paramString.cNd = this.okH;
        paramString.ojA = this.ojA;
        paramString.cMQ = paramInt1;
        paramString.cMR = paramInt2;
        paramString.okL = str;
        paramString.okJ = i;
        paramString.onN = this.okG;
        paramString.okK = ((String)localObject2);
        paramString.ons = x.nD(this.okG);
        paramString.okM = this.okM;
        paramString.cMP = 2;
        ab.i("LuckyMoneyF2FReceiveUI", "is most lucky %d", new Object[] { Integer.valueOf(((c)localObject1).okN) });
        if (((c)localObject1).okN > 0) {
          paramString.onr = getString(2131301249);
        }
        paramString.ont = x.St(this.okG);
        try
        {
          this.omo.putExtra("key_detail_info", paramString.toByteArray());
          paramString = ((c)localObject1).okI;
          if (paramString != null)
          {
            localObject1 = new RealnameGuideHelper();
            ((RealnameGuideHelper)localObject1).a(String.valueOf(paramString.wkQ), paramString.opB, paramString.opC, paramString.opD, paramString.opE, paramm.getType());
            this.omo.putExtra("key_realname_guide_helper", (Parcelable)localObject1);
          }
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            ab.e("LuckyMoneyF2FReceiveUI", "lucky detail toBytes error: " + paramString.getMessage());
          }
        }
        if (!bo.Q(new String[] { this.ojA, this.okG }))
        {
          x.a(this, this.olj, x.nD(this.okG));
          x.a(this, this.omk, this.okM);
          this.omm.start();
          getContentView().setVisibility(0);
        }
      }
    }
    if (((c)localObject1).okI != null)
    {
      ab.i("LuckyMoneyF2FReceiveUI", "need real name verify");
      localObject2 = ((c)localObject1).okI;
      localObject1 = new RealnameGuideHelper();
      ((RealnameGuideHelper)localObject1).a(String.valueOf(((bry)localObject2).wkQ), ((bry)localObject2).opB, ((bry)localObject2).opC, ((bry)localObject2).opD, ((bry)localObject2).opE, paramm.getType());
      paramm = new Bundle();
      paramm.putString("realname_verify_process_jump_activity", ".f2f.ui.LuckyMoneyF2FReceiveUI");
      paramm.putString("realname_verify_process_jump_plugin", "luckymoney");
      if (((RealnameGuideHelper)localObject1).a(this, paramm, new LuckyMoneyF2FReceiveUI.6(this), new LuckyMoneyF2FReceiveUI.7(this), false))
      {
        this.omp = true;
        AppMethodBeat.o(42222);
        return true;
      }
    }
    paramm = paramString;
    if (bo.isNullOrNil(paramString)) {
      paramm = getString(2131301226);
    }
    com.tencent.mm.ui.base.h.a(this, paramm, "", new LuckyMoneyF2FReceiveUI.8(this));
    AppMethodBeat.o(42222);
    return true;
  }
  
  public void onStop()
  {
    AppMethodBeat.i(42221);
    super.onStop();
    removeSceneEndListener(1997);
    AppMethodBeat.o(42221);
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