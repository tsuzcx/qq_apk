package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.bq.d;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.luckymoney.model.ac;
import com.tencent.mm.plugin.luckymoney.model.ad;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.ar;
import com.tencent.mm.plugin.luckymoney.model.k;
import com.tencent.mm.plugin.luckymoney.model.s;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.luckymoney.model.y;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.wallet_core.c.a;
import java.io.IOException;

@a(3)
public class LuckyMoneyBusiReceiveUI
  extends LuckyMoneyBaseUI
{
  private TextView ojg;
  private ImageView ojp;
  private TextView okf;
  private Button okg;
  private View okk;
  private ImageView oml;
  private String orH = null;
  private String orJ = null;
  private int orL = 0;
  private TextView orT;
  private TextView orU;
  private View orV;
  private ImageView orW;
  private TextView orX;
  private View orY;
  private TextView orZ;
  private Button osa;
  private TextView osb;
  private CheckBox osc;
  private int osd;
  private String ose = null;
  private int osf = 0;
  private ad osg;
  private RealnameGuideHelper osh;
  private p tipDialog = null;
  
  private void aO(int paramInt, String paramString)
  {
    AppMethodBeat.i(42634);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LuckyMoneyBusiReceiveUI", "markResult resultCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    Intent localIntent = new Intent();
    localIntent.putExtra("key_result_errmsg", paramString);
    setResult(paramInt, localIntent);
    AppMethodBeat.o(42634);
  }
  
  private void init()
  {
    AppMethodBeat.i(42628);
    this.tipDialog = com.tencent.mm.ui.base.h.b(getContext(), getString(2131301086), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(42616);
        if ((LuckyMoneyBusiReceiveUI.a(LuckyMoneyBusiReceiveUI.this) != null) && (LuckyMoneyBusiReceiveUI.a(LuckyMoneyBusiReceiveUI.this).isShowing())) {
          LuckyMoneyBusiReceiveUI.a(LuckyMoneyBusiReceiveUI.this).dismiss();
        }
        LuckyMoneyBusiReceiveUI.this.orz.forceCancel();
        if ((LuckyMoneyBusiReceiveUI.b(LuckyMoneyBusiReceiveUI.this).getVisibility() == 8) || (LuckyMoneyBusiReceiveUI.c(LuckyMoneyBusiReceiveUI.this).getVisibility() == 4))
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LuckyMoneyBusiReceiveUI", "user cancel & finish");
          LuckyMoneyBusiReceiveUI.this.finish();
        }
        AppMethodBeat.o(42616);
      }
    });
    if (this.osd == 3) {
      doSceneProgress(new com.tencent.mm.plugin.luckymoney.model.ab(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url")), false);
    }
    for (;;)
    {
      aO(0, "");
      AppMethodBeat.o(42628);
      return;
      if (this.osd == 4)
      {
        doSceneProgress(new com.tencent.mm.plugin.luckymoney.model.ab(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("key_wxapi_sign"), getIntent().getStringExtra("key_wxapi_package_name")), false);
        continue;
      }
      try
      {
        this.orH = Uri.parse(bo.nullAsNil(this.orJ)).getQueryParameter("sendid");
        label241:
        if (!bo.isNullOrNil(this.orH))
        {
          doSceneProgress(new ad(this.orH, this.orJ, this.osd, getIntent().getStringExtra("packageExt")), false);
          continue;
        }
        finish();
        com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.LuckyMoneyBusiReceiveUI", "sendid null & finish");
      }
      catch (Exception localException)
      {
        break label241;
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2130970019;
  }
  
  public void initView()
  {
    AppMethodBeat.i(42631);
    this.okk = findViewById(2131825583);
    this.ojp = ((ImageView)findViewById(2131825586));
    this.okf = ((TextView)findViewById(2131825587));
    this.orU = ((TextView)findViewById(2131825595));
    this.orT = ((TextView)findViewById(2131825588));
    this.okg = ((Button)findViewById(2131825596));
    this.oml = ((ImageView)findViewById(2131825600));
    this.orV = findViewById(2131825592);
    this.ojg = ((TextView)findViewById(2131825593));
    this.orW = ((ImageView)findViewById(2131825585));
    this.orX = ((TextView)findViewById(2131825599));
    this.orY = findViewById(2131825589);
    this.orZ = ((TextView)findViewById(2131825590));
    this.osa = ((Button)findViewById(2131825597));
    this.osb = ((TextView)findViewById(2131825594));
    this.osc = ((CheckBox)findViewById(2131825598));
    this.oml.setOnClickListener(new LuckyMoneyBusiReceiveUI.3(this));
    setContentViewVisibility(8);
    AppMethodBeat.o(42631);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(42633);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(42633);
      return;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        String str = paramIntent.getStringExtra("Select_Conv_User");
        com.tencent.mm.plugin.report.service.h.qsU.e(11701, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), str });
        if (!bo.isNullOrNil(str)) {
          doSceneProgress(new ar(str, this.orH, "v1.0"));
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42627);
    super.onCreate(paramBundle);
    this.orJ = getIntent().getStringExtra("key_native_url");
    this.osd = getIntent().getIntExtra("key_way", 5);
    this.orL = getIntent().getIntExtra("key_static_from_scene", 0);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LuckyMoneyBusiReceiveUI", "nativeurl=" + bo.nullAsNil(this.orJ) + ", mWay=" + this.osd);
    init();
    com.tencent.mm.plugin.report.service.h.qsU.e(11701, new Object[] { Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    initView();
    addSceneEndListener(980);
    AppMethodBeat.o(42627);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(42630);
    super.onDestroy();
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    removeSceneEndListener(980);
    AppMethodBeat.o(42630);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(42629);
    if ((paramIntent != null) && (paramIntent.hasExtra("key_is_realname_verify_process")))
    {
      if (paramIntent.getIntExtra("realname_verify_process_ret", 0) == -1)
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LuckyMoneyBusiReceiveUI", "new intent from realname verify process succ");
        init();
        AppMethodBeat.o(42629);
        return;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LuckyMoneyBusiReceiveUI", "new intent from realname verify process cancel");
      aO(-1, "");
      finish();
    }
    AppMethodBeat.o(42629);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(42632);
    if ((paramm instanceof ad))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.osg = ((ad)paramm);
        this.orH = this.osg.ojA;
        this.osf = this.osg.cMP;
        com.tencent.mm.plugin.report.service.h.qsU.e(13050, new Object[] { Integer.valueOf(this.orL), Integer.valueOf(1), this.osg.ooM });
        if (this.osg.cMR == 2)
        {
          aO(-1, "");
          doSceneProgress(new af(this.orH, 11, 0, this.orJ, "v1.0"), false);
          AppMethodBeat.o(42632);
          return true;
        }
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.hide();
        }
        x.l(this.ojp, this.osg.ooQ);
        x.a(getContext(), this.okf, this.osg.ooG);
        x.i(this.orW, this.osg.onI);
        if ((this.osg.cMR != 1) && (this.osg.cMQ != 4) && (this.osg.cMQ != 5) && (this.osg.cMQ != 1)) {
          if (!bo.isNullOrNil(this.osg.ooM))
          {
            this.ose = this.osg.ooM;
            if (this.osg.ooN == 1) {
              this.osc.setVisibility(8);
            }
          }
          else
          {
            this.okg.setOnClickListener(new LuckyMoneyBusiReceiveUI.4(this));
            if (bo.isNullOrNil(this.osg.onq)) {
              break label466;
            }
            this.orT.setText(this.osg.onq);
            label345:
            if (bo.isNullOrNil(this.osg.ooR)) {
              break label478;
            }
            this.orU.setText(this.osg.ooR);
          }
        }
        for (;;)
        {
          x.a(this.okk, null);
          getContentView().setVisibility(0);
          break;
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LuckyMoneyBusiReceiveUI", "show checkbox for " + this.osg.ooM);
          if (this.osg.ooK == 1) {
            this.osc.setChecked(true);
          }
          for (;;)
          {
            this.osc.setText(this.osg.ooL);
            break;
            this.osc.setChecked(false);
          }
          label466:
          this.orT.setVisibility(8);
          break label345;
          label478:
          this.orU.setVisibility(8);
          continue;
          com.tencent.mm.plugin.report.service.h.qsU.e(11701, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
          this.orT.setVisibility(4);
          this.orU.setText(this.osg.onq);
          this.okg.setVisibility(8);
          if (this.osf == 1)
          {
            this.orX.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(42620);
                com.tencent.mm.plugin.report.service.h.qsU.e(11701, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
                paramAnonymousView = new Intent();
                paramAnonymousView.setClass(LuckyMoneyBusiReceiveUI.this.getContext(), LuckyMoneyBusiDetailUI.class);
                paramAnonymousView.putExtra("key_native_url", LuckyMoneyBusiReceiveUI.j(LuckyMoneyBusiReceiveUI.this));
                paramAnonymousView.putExtra("key_sendid", LuckyMoneyBusiReceiveUI.h(LuckyMoneyBusiReceiveUI.this).ojA);
                paramAnonymousView.putExtra("key_static_from_scene", LuckyMoneyBusiReceiveUI.g(LuckyMoneyBusiReceiveUI.this));
                LuckyMoneyBusiReceiveUI.this.startActivity(paramAnonymousView);
                LuckyMoneyBusiReceiveUI.this.finish();
                AppMethodBeat.o(42620);
              }
            });
            this.orX.setVisibility(0);
          }
          else
          {
            this.orX.setVisibility(8);
          }
        }
      }
    }
    else if ((paramm instanceof ac))
    {
      x.d(this.okg);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        aO(-1, "");
        paramm = (ac)paramm;
        if (paramm.cMR == 2)
        {
          if ((paramm.kNn <= 1) || ((paramm.onF != null) && (paramm.onF.eoD != 1)))
          {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LuckyMoneyBusiReceiveUI", "can not atomic go detail");
            paramString = new Intent();
            paramString.putExtra("key_sendid", paramm.ojA);
            paramString.putExtra("key_static_from_scene", this.orL);
            if (paramm.okp != null) {
              paramString.putExtra("key_realname_guide_helper", paramm.okp);
            }
            try
            {
              paramString.putExtra("key_detail_info", paramm.ooO.toByteArray());
              paramString.putExtra("key_jump_from", 2);
              if (g.Nq().getInt("PlayCoinSound", 0) > 0) {
                paramString.putExtra("play_sound", true);
              }
              d.b(getContext(), "luckymoney", ".ui.LuckyMoneyBusiDetailUI", paramString);
              finish();
              AppMethodBeat.o(42632);
              return true;
            }
            catch (IOException paramm)
            {
              for (;;)
              {
                com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.LuckyMoneyBusiReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + paramm.getLocalizedMessage());
              }
            }
          }
          paramString = findViewById(2131825584);
          TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -paramString.getHeight());
          localTranslateAnimation.setDuration(400L);
          localTranslateAnimation.setFillAfter(true);
          localTranslateAnimation.setAnimationListener(new LuckyMoneyBusiReceiveUI.6(this, paramString));
          paramString.startAnimation(localTranslateAnimation);
          this.ojg.setText(com.tencent.mm.wallet_core.ui.e.E(paramm.cNd / 100.0D));
          this.okf.setText(paramm.ooG);
          this.orT.setVisibility(8);
          this.orU.setVisibility(8);
          this.orV.setVisibility(0);
          this.okg.setVisibility(8);
          if (!bo.isNullOrNil(paramm.ooJ))
          {
            paramString = paramm.ooJ;
            this.osa.setText(paramString);
            this.osb.setVisibility(0);
            com.tencent.mm.plugin.report.service.h.qsU.e(11701, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LuckyMoneyBusiReceiveUI", "totalNum:" + paramm.kNn);
            if ((paramm.kNn <= 1) && ((paramm.onF == null) || (paramm.onF.eoD != 1))) {
              break label1182;
            }
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LuckyMoneyBusiReceiveUI", "can atomic");
            this.osh = paramm.okp;
            this.osa.setOnClickListener(new LuckyMoneyBusiReceiveUI.7(this, paramm));
            label1155:
            this.osa.setVisibility(0);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(42632);
          return true;
          paramString = getString(2131301320);
          break;
          label1182:
          this.osa.setOnClickListener(new LuckyMoneyBusiReceiveUI.8(this));
          break label1155;
          this.orT.setVisibility(4);
          this.orU.setText(paramm.onq);
          this.okg.setVisibility(8);
          if (this.osf == 1)
          {
            this.orX.setOnClickListener(new LuckyMoneyBusiReceiveUI.9(this, paramm));
            this.orX.setVisibility(0);
          }
          else
          {
            this.orX.setVisibility(8);
          }
        }
      }
      if (paramInt2 == 416)
      {
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.hide();
        }
        paramString = new Bundle();
        paramString.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyBusiReceiveUI");
        paramString.putString("realname_verify_process_jump_plugin", "luckymoney");
        this.okg.setBackgroundResource(2130838860);
        new LuckyMoneyBusiReceiveUI.10(this);
        boolean bool = x.a(this, paramInt2, paramm, paramString, false, new c.a()
        {
          public final Intent p(int paramAnonymousInt, Bundle paramAnonymousBundle)
          {
            AppMethodBeat.i(42617);
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LuckyMoneyBusiReceiveUI", "re");
            AppMethodBeat.o(42617);
            return null;
          }
        }, 1005);
        AppMethodBeat.o(42632);
        return bool;
      }
    }
    else
    {
      if ((paramm instanceof ar))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          com.tencent.mm.ui.base.h.bO(this, getString(2131300637));
          com.tencent.mm.plugin.report.service.h.qsU.e(11701, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
          finish();
          AppMethodBeat.o(42632);
          return true;
        }
        com.tencent.mm.ui.base.h.bO(this, paramString);
        AppMethodBeat.o(42632);
        return true;
      }
      if ((paramm instanceof com.tencent.mm.plugin.luckymoney.model.ab))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          doSceneProgress(new ad(this.orH, this.orJ, this.osd, getIntent().getStringExtra("packageExt")));
          AppMethodBeat.o(42632);
          return true;
        }
      }
      else
      {
        if ((paramm instanceof y))
        {
          AppMethodBeat.o(42632);
          return true;
        }
        if ((paramm instanceof af))
        {
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.hide();
          }
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            paramm = (af)paramm;
            paramString = new Intent();
            paramString.setClass(getContext(), LuckyMoneyBusiDetailUI.class);
            try
            {
              paramString.putExtra("key_detail_info", paramm.ooO.toByteArray());
              paramString.putExtra("key_jump_from", 2);
              paramString.putExtra("key_native_url", this.orJ);
              paramString.putExtra("key_sendid", this.orH);
              paramString.putExtra("key_static_from_scene", this.orL);
              startActivity(paramString);
              finish();
              AppMethodBeat.o(42632);
              return true;
            }
            catch (IOException paramm)
            {
              for (;;)
              {
                com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.LuckyMoneyBusiReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + paramm.getLocalizedMessage());
              }
            }
          }
        }
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      aO(2, paramString);
    }
    AppMethodBeat.o(42632);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI
 * JD-Core Version:    0.7.0.1
 */