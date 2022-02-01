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
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.plugin.luckymoney.model.aj;
import com.tencent.mm.plugin.luckymoney.model.ak;
import com.tencent.mm.plugin.luckymoney.model.al;
import com.tencent.mm.plugin.luckymoney.model.ao;
import com.tencent.mm.plugin.luckymoney.model.bf;
import com.tencent.mm.plugin.luckymoney.model.i;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;

@com.tencent.mm.ui.base.a(3)
public class LuckyMoneyBusiReceiveUI
  extends LuckyMoneyBaseUI
{
  private com.tencent.mm.ui.base.q tipDialog = null;
  private TextView yQk;
  private ImageView yQt;
  private TextView yRk;
  private Button yRl;
  private View yRp;
  private ImageView yTs;
  private String yUc = null;
  private String yUq = null;
  private TextView zcA;
  private Button zcB;
  private TextView zcC;
  private CheckBox zcD;
  private int zcE;
  private String zcF = null;
  private int zcG = 0;
  private al zcH;
  private RealnameGuideHelper zcI;
  private int zcm = 0;
  private TextView zcu;
  private TextView zcv;
  private View zcw;
  private ImageView zcx;
  private TextView zcy;
  private View zcz;
  
  private void bE(int paramInt, String paramString)
  {
    AppMethodBeat.i(65501);
    Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "markResult resultCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    Intent localIntent = new Intent();
    localIntent.putExtra("key_result_errmsg", paramString);
    setResult(paramInt, localIntent);
    AppMethodBeat.o(65501);
  }
  
  private void init()
  {
    AppMethodBeat.i(65495);
    this.tipDialog = com.tencent.mm.ui.base.h.a(getContext(), getString(2131762446), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(65483);
        if ((LuckyMoneyBusiReceiveUI.a(LuckyMoneyBusiReceiveUI.this) != null) && (LuckyMoneyBusiReceiveUI.a(LuckyMoneyBusiReceiveUI.this).isShowing())) {
          LuckyMoneyBusiReceiveUI.a(LuckyMoneyBusiReceiveUI.this).dismiss();
        }
        LuckyMoneyBusiReceiveUI.this.zbX.forceCancel();
        if ((LuckyMoneyBusiReceiveUI.b(LuckyMoneyBusiReceiveUI.this).getVisibility() == 8) || (LuckyMoneyBusiReceiveUI.c(LuckyMoneyBusiReceiveUI.this).getVisibility() == 4))
        {
          Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "user cancel & finish");
          LuckyMoneyBusiReceiveUI.this.finish();
        }
        AppMethodBeat.o(65483);
      }
    });
    if (this.zcE == 3) {
      doSceneProgress(new aj(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url")), false);
    }
    for (;;)
    {
      bE(0, "");
      AppMethodBeat.o(65495);
      return;
      if (this.zcE == 4)
      {
        doSceneProgress(new aj(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("key_wxapi_sign"), getIntent().getStringExtra("key_wxapi_package_name")), false);
        continue;
      }
      try
      {
        this.yUc = Uri.parse(Util.nullAsNil(this.yUq)).getQueryParameter("sendid");
        label241:
        if (!Util.isNullOrNil(this.yUc))
        {
          doSceneProgress(new al(this.yUc, this.yUq, this.zcE, getIntent().getStringExtra("packageExt")), false);
          continue;
        }
        finish();
        Log.w("MicroMsg.LuckyMoneyBusiReceiveUI", "sendid null & finish");
      }
      catch (Exception localException)
      {
        break label241;
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2131495353;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65498);
    this.yRp = findViewById(2131304021);
    this.yQt = ((ImageView)findViewById(2131304025));
    this.yRk = ((TextView)findViewById(2131304026));
    this.zcv = ((TextView)findViewById(2131304022));
    this.zcu = ((TextView)findViewById(2131304030));
    this.yRl = ((Button)findViewById(2131304023));
    this.yTs = ((ImageView)findViewById(2131304033));
    this.zcw = findViewById(2131304020);
    this.yQk = ((TextView)findViewById(2131304019));
    this.zcx = ((ImageView)findViewById(2131304034));
    this.zcy = ((TextView)findViewById(2131304032));
    this.zcz = findViewById(2131304027);
    this.zcA = ((TextView)findViewById(2131304028));
    this.zcB = ((Button)findViewById(2131304035));
    this.zcC = ((TextView)findViewById(2131304024));
    this.zcD = ((CheckBox)findViewById(2131304036));
    this.yTs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65485);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = new Bundle();
        paramAnonymousView.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyBusiReceiveUI");
        paramAnonymousView.putString("realname_verify_process_jump_plugin", "luckymoney");
        if ((LuckyMoneyBusiReceiveUI.d(LuckyMoneyBusiReceiveUI.this) != null) && (LuckyMoneyBusiReceiveUI.d(LuckyMoneyBusiReceiveUI.this).a(LuckyMoneyBusiReceiveUI.this, paramAnonymousView, null, null, true))) {
          LuckyMoneyBusiReceiveUI.e(LuckyMoneyBusiReceiveUI.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(65485);
          return;
          LuckyMoneyBusiReceiveUI.this.finish();
        }
      }
    });
    setContentViewVisibility(8);
    AppMethodBeat.o(65498);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(65500);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(65500);
      return;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        String str = paramIntent.getStringExtra("Select_Conv_User");
        com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), str });
        if (!Util.isNullOrNil(str)) {
          doSceneProgress(new bf(str, this.yUc, "v1.0"));
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65494);
    super.onCreate(paramBundle);
    this.yUq = getIntent().getStringExtra("key_native_url");
    this.zcE = getIntent().getIntExtra("key_way", 5);
    this.zcm = getIntent().getIntExtra("key_static_from_scene", 0);
    Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "nativeurl=" + Util.nullAsNil(this.yUq) + ", mWay=" + this.zcE);
    init();
    com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    initView();
    addSceneEndListener(980);
    AppMethodBeat.o(65494);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65497);
    super.onDestroy();
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    removeSceneEndListener(980);
    AppMethodBeat.o(65497);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(65496);
    if ((paramIntent != null) && (paramIntent.hasExtra("key_is_realname_verify_process")))
    {
      if (paramIntent.getIntExtra("realname_verify_process_ret", 0) == -1)
      {
        Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "new intent from realname verify process succ");
        init();
        AppMethodBeat.o(65496);
        return;
      }
      Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "new intent from realname verify process cancel");
      bE(-1, "");
      finish();
    }
    AppMethodBeat.o(65496);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(65499);
    if ((paramq instanceof al))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.zcH = ((al)paramq);
        paramString = new ae();
        paramString.field_mNativeUrl = this.yUq;
        paramString.field_hbType = this.zcH.egY;
        paramString.field_hbStatus = this.zcH.egZ;
        paramString.field_receiveStatus = this.zcH.eha;
        t.fQE().a(paramString);
        this.yUc = this.zcH.yQE;
        this.zcG = this.zcH.egY;
        com.tencent.mm.plugin.report.service.h.CyF.a(13050, new Object[] { Integer.valueOf(this.zcm), Integer.valueOf(1), this.zcH.yWR });
        if (this.zcH.eha == 2)
        {
          bE(-1, "");
          doSceneProgress(new ao(this.yUc, 11, 0, this.yUq, "v1.0"), false);
          AppMethodBeat.o(65499);
          return true;
        }
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.hide();
        }
        af.r(this.yQt, this.zcH.yWV);
        af.a(getContext(), this.yRk, this.zcH.yWL);
        af.o(this.zcx, this.zcH.yVt);
        if ((this.zcH.eha != 1) && (this.zcH.egZ != 4) && (this.zcH.egZ != 5) && (this.zcH.egZ != 1)) {
          if (!Util.isNullOrNil(this.zcH.yWR))
          {
            this.zcF = this.zcH.yWR;
            if (this.zcH.yWS == 1) {
              this.zcD.setVisibility(8);
            }
          }
          else
          {
            this.yRl.setOnClickListener(new LuckyMoneyBusiReceiveUI.4(this));
            if (Util.isNullOrNil(this.zcH.yVb)) {
              break label523;
            }
            this.zcu.setText(this.zcH.yVb);
            label402:
            if (Util.isNullOrNil(this.zcH.yWW)) {
              break label535;
            }
            this.zcv.setText(this.zcH.yWW);
          }
        }
        for (;;)
        {
          af.a(this.yRp, null);
          getContentView().setVisibility(0);
          break;
          Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "show checkbox for " + this.zcH.yWR);
          if (this.zcH.yWP == 1) {
            this.zcD.setChecked(true);
          }
          for (;;)
          {
            this.zcD.setText(this.zcH.yWQ);
            break;
            this.zcD.setChecked(false);
          }
          label523:
          this.zcu.setVisibility(8);
          break label402;
          label535:
          this.zcv.setVisibility(8);
          continue;
          com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
          this.zcu.setVisibility(4);
          this.zcv.setText(this.zcH.yVb);
          this.yRl.setVisibility(8);
          if (this.zcG == 1)
          {
            this.zcy.setOnClickListener(new LuckyMoneyBusiReceiveUI.5(this));
            this.zcy.setVisibility(0);
          }
          else
          {
            this.zcy.setVisibility(8);
          }
        }
      }
    }
    else if ((paramq instanceof ak))
    {
      af.d(this.yRl);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        bE(-1, "");
        paramq = (ak)paramq;
        paramString = new ae();
        paramString.field_mNativeUrl = this.yUq;
        paramString.field_hbType = paramq.yWT.egY;
        paramString.field_receiveAmount = paramq.yWT.eht;
        paramString.field_receiveTime = System.currentTimeMillis();
        paramString.field_hbStatus = paramq.yWT.egZ;
        paramString.field_receiveStatus = paramq.yWT.eha;
        if (paramString.field_receiveAmount > 0L) {
          t.fQE().a(paramString);
        }
        if (paramq.eha == 2)
        {
          if ((paramq.qwe <= 1) || ((paramq.yVq != null) && (paramq.yVq.gGn != 1)))
          {
            Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "can not atomic go detail");
            paramString = new Intent();
            paramString.putExtra("key_sendid", paramq.yQE);
            paramString.putExtra("key_static_from_scene", this.zcm);
            if (paramq.yRu != null) {
              paramString.putExtra("key_realname_guide_helper", paramq.yRu);
            }
            try
            {
              paramString.putExtra("key_detail_info", paramq.yWT.toByteArray());
              paramString.putExtra("key_jump_from", 2);
              if (com.tencent.mm.n.h.aqJ().getInt("PlayCoinSound", 0) > 0) {
                paramString.putExtra("play_sound", true);
              }
              c.b(getContext(), "luckymoney", ".ui.LuckyMoneyBusiDetailUI", paramString);
              finish();
              AppMethodBeat.o(65499);
              return true;
            }
            catch (IOException paramq)
            {
              for (;;)
              {
                Log.w("MicroMsg.LuckyMoneyBusiReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + paramq.getLocalizedMessage());
              }
            }
          }
          paramString = findViewById(2131304031);
          TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -paramString.getHeight());
          localTranslateAnimation.setDuration(400L);
          localTranslateAnimation.setFillAfter(true);
          localTranslateAnimation.setAnimationListener(new LuckyMoneyBusiReceiveUI.6(this, paramString));
          paramString.startAnimation(localTranslateAnimation);
          this.yQk.setText(com.tencent.mm.wallet_core.ui.f.formatMoney2f(paramq.eht / 100.0D));
          this.yRk.setText(paramq.yWL);
          this.zcu.setVisibility(8);
          this.zcv.setVisibility(8);
          this.zcw.setVisibility(0);
          this.yRl.setVisibility(8);
          if (!Util.isNullOrNil(paramq.yWO))
          {
            paramString = paramq.yWO;
            this.zcB.setText(paramString);
            this.zcC.setVisibility(0);
            com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
            Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "totalNum:" + paramq.qwe);
            if ((paramq.qwe <= 1) && ((paramq.yVq == null) || (paramq.yVq.gGn != 1))) {
              break label1327;
            }
            Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "can atomic");
            this.zcI = paramq.yRu;
            this.zcB.setOnClickListener(new LuckyMoneyBusiReceiveUI.7(this, paramq));
            label1300:
            this.zcB.setVisibility(0);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(65499);
          return true;
          paramString = getString(2131762739);
          break;
          label1327:
          this.zcB.setOnClickListener(new LuckyMoneyBusiReceiveUI.8(this));
          break label1300;
          this.zcu.setVisibility(4);
          this.zcv.setText(paramq.yVb);
          this.yRl.setVisibility(8);
          if (this.zcG == 1)
          {
            this.zcy.setOnClickListener(new LuckyMoneyBusiReceiveUI.9(this, paramq));
            this.zcy.setVisibility(0);
          }
          else
          {
            this.zcy.setVisibility(8);
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
        this.yRl.setBackgroundResource(2131232445);
        boolean bool = af.a(this, paramInt2, paramq, paramString, false, new LuckyMoneyBusiReceiveUI.10(this), new LuckyMoneyBusiReceiveUI.2(this), 1005);
        AppMethodBeat.o(65499);
        return bool;
      }
    }
    else
    {
      if ((paramq instanceof bf))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          com.tencent.mm.ui.base.h.cD(this, getString(2131761619));
          com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
          finish();
          AppMethodBeat.o(65499);
          return true;
        }
        com.tencent.mm.ui.base.h.cD(this, paramString);
        AppMethodBeat.o(65499);
        return true;
      }
      if ((paramq instanceof aj))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          doSceneProgress(new al(this.yUc, this.yUq, this.zcE, getIntent().getStringExtra("packageExt")));
          AppMethodBeat.o(65499);
          return true;
        }
      }
      else
      {
        if ((paramq instanceof ag))
        {
          AppMethodBeat.o(65499);
          return true;
        }
        if ((paramq instanceof ao))
        {
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.hide();
          }
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            paramq = (ao)paramq;
            paramString = new Intent();
            paramString.setClass(getContext(), LuckyMoneyBusiDetailUI.class);
            try
            {
              paramString.putExtra("key_detail_info", paramq.yWT.toByteArray());
              paramString.putExtra("key_jump_from", 2);
              paramString.putExtra("key_native_url", this.yUq);
              paramString.putExtra("key_sendid", this.yUc);
              paramString.putExtra("key_static_from_scene", this.zcm);
              paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
              com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)paramString.pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              finish();
              AppMethodBeat.o(65499);
              return true;
            }
            catch (IOException paramq)
            {
              for (;;)
              {
                Log.w("MicroMsg.LuckyMoneyBusiReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + paramq.getLocalizedMessage());
              }
            }
          }
        }
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      bE(2, paramString);
    }
    AppMethodBeat.o(65499);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI
 * JD-Core Version:    0.7.0.1
 */