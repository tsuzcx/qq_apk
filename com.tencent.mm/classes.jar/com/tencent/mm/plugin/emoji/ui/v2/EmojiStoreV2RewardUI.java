package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Message;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.ay.a.c.k;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.i.a;
import com.tencent.mm.plugin.emoji.i.b;
import com.tencent.mm.plugin.emoji.i.d;
import com.tencent.mm.plugin.emoji.i.e;
import com.tencent.mm.plugin.emoji.i.f;
import com.tencent.mm.plugin.emoji.i.h;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.n;
import com.tencent.mm.plugin.emoji.ui.GridInScrollView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.akg;
import com.tencent.mm.protocal.protobuf.buj;
import com.tencent.mm.protocal.protobuf.gv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.vfs.u;
import java.util.LinkedList;

public class EmojiStoreV2RewardUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, i
{
  private MMHandler mHandler;
  private ProgressDialog mRa;
  public int uEL;
  private String uER;
  public String uFv;
  private buj uKD;
  private Button uLd;
  private EmojiStoreV2RewardBannerView uOA;
  private GridInScrollView uOB;
  private View uOC;
  private View uOD;
  private MMFormInputView uOE;
  private TextView uOF;
  private TextView uOG;
  private b uOH;
  private com.tencent.mm.plugin.emoji.f.b uOI;
  private String uOJ;
  private String uOK;
  private EmojiStoreV2RewardUI.a uOL;
  public boolean uOM;
  private View.OnClickListener uON;
  private View.OnClickListener uOO;
  private TextWatcher uOP;
  private n uOQ;
  private AnimationDrawable uOw;
  public int uOz;
  
  public EmojiStoreV2RewardUI()
  {
    AppMethodBeat.i(109287);
    this.uOL = EmojiStoreV2RewardUI.a.uOS;
    this.uOM = false;
    this.mHandler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(109270);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(109270);
          return;
          paramAnonymousMessage = (String)paramAnonymousMessage.obj;
          if ((!Util.isNullOrNil(paramAnonymousMessage)) && (u.agG(paramAnonymousMessage)))
          {
            EmojiStoreV2RewardUI.a(EmojiStoreV2RewardUI.this).setImageFilePath(paramAnonymousMessage);
            EmojiStoreV2RewardUI.a(EmojiStoreV2RewardUI.this).setScaleType(ImageView.ScaleType.FIT_XY);
            if ((EmojiStoreV2RewardUI.b(EmojiStoreV2RewardUI.this) != null) && (EmojiStoreV2RewardUI.b(EmojiStoreV2RewardUI.this).isRunning()))
            {
              EmojiStoreV2RewardUI.b(EmojiStoreV2RewardUI.this).stop();
              AppMethodBeat.o(109270);
            }
          }
          else
          {
            Log.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "path is null or file no exists");
            AppMethodBeat.o(109270);
            return;
            EmojiStoreV2RewardUI.c(EmojiStoreV2RewardUI.this);
          }
        }
      }
    };
    this.uON = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109271);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (EmojiStoreV2RewardUI.d(EmojiStoreV2RewardUI.this) != null)
        {
          paramAnonymousView = EmojiStoreV2RewardUI.d(EmojiStoreV2RewardUI.this).JJ(0);
          if (EmojiStoreV2RewardUI.e(EmojiStoreV2RewardUI.this).getText() != null)
          {
            paramAnonymousView.VHM = EmojiStoreV2RewardUI.e(EmojiStoreV2RewardUI.this).getText().toString();
            EmojiStoreV2RewardUI.a(EmojiStoreV2RewardUI.this, EmojiStoreV2RewardUI.f(EmojiStoreV2RewardUI.this), paramAnonymousView);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109271);
          return;
          Log.w("MicroMsg.emoji.EmojiStoreV2RewardUI", "mRewardInputView is null");
          continue;
          Log.w("MicroMsg.emoji.EmojiStoreV2RewardUI", "mAdapter is null.");
        }
      }
    };
    this.uOO = new EmojiStoreV2RewardUI.3(this);
    this.uOP = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(109273);
        float f1;
        if (EmojiStoreV2RewardUI.h(EmojiStoreV2RewardUI.this) != null) {
          if ((paramAnonymousEditable != null) && (paramAnonymousEditable.length() > 0))
          {
            String str = paramAnonymousEditable.toString();
            int i = str.indexOf(".");
            if ((i > 0) && (str.length() - i - 1 > 2)) {
              paramAnonymousEditable.delete(i + 3, i + 4);
            }
            f1 = 0.0F;
          }
        }
        try
        {
          float f2 = Float.valueOf(paramAnonymousEditable.toString()).floatValue();
          f1 = f2;
        }
        catch (NumberFormatException paramAnonymousEditable)
        {
          label92:
          break label92;
        }
        if ((f1 > 200.0F) || (f1 < 1.0F))
        {
          EmojiStoreV2RewardUI.e(EmojiStoreV2RewardUI.this).getContentEditText().setTextColor(EmojiStoreV2RewardUI.this.getContext().getResources().getColor(i.b.red));
          EmojiStoreV2RewardUI.h(EmojiStoreV2RewardUI.this).setEnabled(false);
          AppMethodBeat.o(109273);
          return;
        }
        EmojiStoreV2RewardUI.e(EmojiStoreV2RewardUI.this).getContentEditText().setTextColor(EmojiStoreV2RewardUI.this.getContext().getResources().getColor(i.b.normal_text_color));
        EmojiStoreV2RewardUI.h(EmojiStoreV2RewardUI.this).setEnabled(true);
        AppMethodBeat.o(109273);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    this.uOQ = new n(new k()
    {
      public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(109274);
        if ((!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equalsIgnoreCase(EmojiStoreV2RewardUI.i(EmojiStoreV2RewardUI.this))))
        {
          paramAnonymousString = new Message();
          paramAnonymousString.what = 1001;
          paramAnonymousString.obj = EmojiStoreV2RewardUI.j(EmojiStoreV2RewardUI.this);
          EmojiStoreV2RewardUI.k(EmojiStoreV2RewardUI.this).sendMessage(paramAnonymousString);
        }
        AppMethodBeat.o(109274);
      }
    });
    AppMethodBeat.o(109287);
  }
  
  private void a(EmojiStoreV2RewardUI.a parama)
  {
    AppMethodBeat.i(109291);
    if (parama == EmojiStoreV2RewardUI.a.uOT)
    {
      this.uOL = EmojiStoreV2RewardUI.a.uOT;
      if (this.uOD != null)
      {
        this.uOD.setVisibility(0);
        this.uOD.startAnimation(AnimationUtils.loadAnimation(getContext(), i.a.pop_in));
        this.uOE.getContentEditText().requestFocus();
        showVKB();
        this.uOC.setVisibility(8);
        AppMethodBeat.o(109291);
      }
    }
    else
    {
      hideVKB();
      this.mHandler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(109275);
          EmojiStoreV2RewardUI.l(EmojiStoreV2RewardUI.this);
          AppMethodBeat.o(109275);
        }
      }, 300L);
    }
    AppMethodBeat.o(109291);
  }
  
  private void a(String paramString, akf paramakf)
  {
    AppMethodBeat.i(109297);
    bxs();
    this.uOI = new com.tencent.mm.plugin.emoji.f.b(paramString, paramakf);
    com.tencent.mm.kernel.h.aHF().kcd.a(this.uOI, 0);
    AppMethodBeat.o(109297);
  }
  
  private void auQ(String paramString)
  {
    AppMethodBeat.i(109299);
    com.tencent.mm.ui.base.h.a(getContext(), paramString, null, getString(i.h.emoji_sort_i_know), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(109299);
  }
  
  private void bxs()
  {
    AppMethodBeat.i(109298);
    getString(i.h.app_tip);
    this.mRa = com.tencent.mm.ui.base.h.a(this, getString(i.h.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(109277);
        com.tencent.mm.kernel.h.aHF().kcd.a(EmojiStoreV2RewardUI.m(EmojiStoreV2RewardUI.this));
        AppMethodBeat.o(109277);
      }
    });
    AppMethodBeat.o(109298);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(109293);
    if (this.uKD != null)
    {
      this.uOF.setVisibility(0);
      this.uOG.setVisibility(0);
      if ((this.uKD.VIh != null) && (!Util.isNullOrNil(this.uKD.VIh.Svb)))
      {
        this.uOJ = this.uKD.VIh.Svb;
        this.uOK = EmojiLogic.j(com.tencent.mm.plugin.emoji.i.b.bcb(), this.uFv, this.uOJ);
        if (u.agG(this.uOK))
        {
          this.uOA.setImageFilePath(this.uOK);
          this.uOA.setScaleType(ImageView.ScaleType.FIT_XY);
          if ((this.uOw != null) && (this.uOw.isRunning())) {
            this.uOw.stop();
          }
        }
      }
    }
    while ((this.uKD != null) && (this.uKD.VIg != null))
    {
      this.uOB.setVisibility(0);
      this.uOH.X(this.uKD.VIg);
      AppMethodBeat.o(109293);
      return;
      com.tencent.mm.ay.q.bml().a(this.uOJ, this.uOA, e.l(this.uFv, this.uOJ, new Object[0]), this.uOQ);
      this.uOA.setBackgroundDrawable(getResources().getDrawable(i.d.emotion_reward_banner_bg_color));
      this.uOA.setImageDrawable(this.uOw);
      this.uOA.setScaleType(ImageView.ScaleType.CENTER);
      this.uOw.start();
      continue;
      this.uOA.setBackgroundDrawable(getResources().getDrawable(i.d.emotion_reward_banner_bg_color));
      this.uOA.setImageDrawable(this.uOw);
      this.uOA.setScaleType(ImageView.ScaleType.CENTER);
      this.uOw.start();
      continue;
      this.uOF.setVisibility(8);
      this.uOG.setVisibility(8);
    }
    this.uOB.setVisibility(8);
    AppMethodBeat.o(109293);
  }
  
  public final void cWM()
  {
    AppMethodBeat.i(256378);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this, EmojiStoreV2RewardThanksUI.class);
    ((Intent)localObject).putExtra("extra_id", this.uFv);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI", "startThanksUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI", "startThanksUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(256378);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return i.f.emoji_store_v2_rewardl_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109292);
    if (Util.isNullOrNil(this.uER)) {
      setMMTitle(i.h.emoji_store_reward);
    }
    for (;;)
    {
      setMMSubTitle(i.h.wechat_authenticate_safely);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(109276);
          EmojiStoreV2RewardUI.this.onBackPressed();
          AppMethodBeat.o(109276);
          return true;
        }
      });
      this.uOC = findViewById(i.e.reward_main);
      this.uOD = findViewById(i.e.reward_other);
      this.uOE = ((MMFormInputView)findViewById(i.e.reward_other_price_et));
      this.uLd = ((Button)findViewById(i.e.reward_reward_btn));
      this.uLd.setOnClickListener(this.uON);
      this.uLd.setEnabled(false);
      this.uOE.setInputType(8194);
      this.uOE.addTextChangedListener(this.uOP);
      this.uOE.getContentEditText().setFilters(new InputFilter[] { new InputFilter.LengthFilter(12) });
      this.uOF = ((TextView)findViewById(i.e.reward_custom));
      this.uOF.setOnClickListener(this.uOO);
      this.uOG = ((TextView)findViewById(i.e.reward_choose_price));
      this.uOA = ((EmojiStoreV2RewardBannerView)findViewById(i.e.beg_pic));
      this.uOB = ((GridInScrollView)findViewById(16908298));
      this.uOH = new b();
      this.uOB.setAdapter(this.uOH);
      this.uOB.setOnItemClickListener(this);
      this.uOw = ((AnimationDrawable)getResources().getDrawable(i.d.emoji_doge_loading));
      AppMethodBeat.o(109292);
      return;
      setMMTitle(getString(i.h.emoji_store_reward_to_designer, new Object[] { this.uER }));
    }
  }
  
  public final void mM(boolean paramBoolean)
  {
    AppMethodBeat.i(109300);
    Log.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "doGetRewardScene");
    if (paramBoolean)
    {
      localp = new com.tencent.mm.plugin.emoji.f.p(this.uFv, com.tencent.mm.plugin.emoji.f.p.uGk);
      com.tencent.mm.kernel.h.aHF().kcd.a(localp, 0);
      AppMethodBeat.o(109300);
      return;
    }
    com.tencent.mm.plugin.emoji.f.p localp = new com.tencent.mm.plugin.emoji.f.p(this.uFv, com.tencent.mm.plugin.emoji.f.p.uGl);
    com.tencent.mm.kernel.h.aHF().kcd.a(localp, 0);
    bxs();
    AppMethodBeat.o(109300);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109295);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109295);
      return;
      if (paramInt2 == -1)
      {
        cWM();
        com.tencent.mm.plugin.report.service.h.IzE.a(12738, new Object[] { this.uFv, Integer.valueOf(this.uOz), Integer.valueOf(this.uEL), Integer.valueOf(1) });
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(408L, 9L, 1L, false);
        mM(true);
        finish();
        AppMethodBeat.o(109295);
        return;
      }
      if (paramInt2 == 0)
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(12738, new Object[] { this.uFv, Integer.valueOf(this.uOz), Integer.valueOf(this.uEL), Integer.valueOf(3) });
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(408L, 3L, 1L, false);
        AppMethodBeat.o(109295);
        return;
      }
      if (!this.uOM)
      {
        this.uOM = true;
        com.tencent.mm.plugin.report.service.h.IzE.a(12738, new Object[] { this.uFv, Integer.valueOf(this.uOz), Integer.valueOf(this.uEL), Integer.valueOf(2) });
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(408L, 4L, 1L, false);
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(109290);
    Log.i("MicroMsg.emoji.EmojiStoreV2RewardUI", keyboardState());
    if (this.uOL == EmojiStoreV2RewardUI.a.uOS)
    {
      if (this.uOM) {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(408L, 2L, 1L, false);
      }
      for (;;)
      {
        super.onBackPressed();
        AppMethodBeat.o(109290);
        return;
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(408L, 1L, 1L, false);
        com.tencent.mm.plugin.report.service.h.IzE.a(12738, new Object[] { this.uFv, Integer.valueOf(this.uOz), Integer.valueOf(this.uEL), Integer.valueOf(4) });
      }
    }
    a(EmojiStoreV2RewardUI.a.uOS);
    AppMethodBeat.o(109290);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109288);
    super.onCreate(paramBundle);
    this.uFv = getIntent().getStringExtra("extra_id");
    this.uER = getIntent().getStringExtra("name");
    this.uEL = getIntent().getIntExtra("scene", 0);
    this.uOz = getIntent().getIntExtra("pageType", 0);
    initView();
    this.uKD = com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr().VFM.bxU(this.uFv);
    if ((this.uKD != null) && (this.uKD.VIh != null))
    {
      com.tencent.mm.ay.q.bml().a(this.uKD.VIh.Svc, null, e.l(this.uFv, this.uKD.VIh.Svc, new Object[0]));
      com.tencent.mm.ay.q.bml().a(this.uKD.VIh.Svd, null, e.l(this.uFv, this.uKD.VIh.Svd, new Object[0]));
    }
    for (;;)
    {
      updateView();
      com.tencent.mm.kernel.h.aHF().kcd.a(830, this);
      com.tencent.mm.kernel.h.aHF().kcd.a(822, this);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(408L, 0L, 1L, false);
      AppMethodBeat.o(109288);
      return;
      mM(false);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109289);
    com.tencent.mm.kernel.h.aHF().kcd.b(830, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(822, this);
    if ((this.uOw != null) && (this.uOw.isRunning())) {
      this.uOw.stop();
    }
    com.tencent.mm.ay.q.bml().a(null, this.uOA);
    this.uOQ.uEG = null;
    this.uOQ = null;
    super.onDestroy();
    AppMethodBeat.o(109289);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(109294);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramAdapterView);
    localb.bn(paramView);
    localb.sg(paramInt);
    localb.Fs(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
    if (this.uOH != null)
    {
      paramAdapterView = this.uOH.JJ(paramInt);
      if (paramAdapterView != null)
      {
        Log.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "onItemClick position:%d", new Object[] { Integer.valueOf(paramInt) });
        a(this.uFv, paramAdapterView);
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(109294);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(109296);
    if ((this.mRa != null) && (this.mRa.isShowing())) {
      this.mRa.dismiss();
    }
    int i = paramq.getType();
    switch (i)
    {
    default: 
      Log.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "unknown scene. type:%d", new Object[] { Integer.valueOf(i) });
    }
    do
    {
      AppMethodBeat.o(109296);
      return;
      Object localObject = (com.tencent.mm.plugin.emoji.f.b)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        boolean bool = ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).isSwitch2InWxAppPay(((com.tencent.mm.plugin.emoji.f.b)localObject).cUY().RLK);
        Log.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "doEmojiReward, isSwitch2InWxAppPay:%b", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).startInWxAppPayUseCase(this, ((com.tencent.mm.plugin.emoji.f.b)localObject).cUY().RLK, "", "", 5, 0);
          AppMethodBeat.o(109296);
          return;
        }
        paramString = new Bundle();
        paramString.putBoolean("extinfo_key_10", true);
        paramq = getContext();
        String str = ((com.tencent.mm.plugin.emoji.f.b)localObject).cUY().RLK;
        localObject = ((com.tencent.mm.plugin.emoji.f.b)localObject).cUY().jUi;
        if (!Util.isNullOrNil(str))
        {
          localObject = f.az(str, (String)localObject, 5);
          ((PayInfo)localObject).lfu = paramString;
          f.a(paramq, (PayInfo)localObject, 8001);
        }
        AppMethodBeat.o(109296);
        return;
      }
      if (paramInt1 == 4)
      {
        if (!this.uOM)
        {
          this.uOM = true;
          com.tencent.mm.plugin.report.service.h.IzE.a(12738, new Object[] { this.uFv, Integer.valueOf(this.uOz), Integer.valueOf(this.uEL), Integer.valueOf(2) });
        }
        if (paramInt2 == com.tencent.mm.plugin.emoji.f.b.uFs)
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(408L, 6L, 1L, false);
          if (Util.isNullOrNil(paramString))
          {
            auQ(getString(i.h.emoji_store_reward_magic_pay_limite));
            AppMethodBeat.o(109296);
            return;
          }
          auQ(paramString);
          AppMethodBeat.o(109296);
          return;
        }
        if (paramInt2 == com.tencent.mm.plugin.emoji.f.b.uFt)
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(408L, 7L, 1L, false);
          if (Util.isNullOrNil(paramString))
          {
            auQ(getString(i.h.emoji_store_reward_magic_receive_limite));
            AppMethodBeat.o(109296);
            return;
          }
          auQ(paramString);
          AppMethodBeat.o(109296);
          return;
        }
        if (paramInt2 == com.tencent.mm.plugin.emoji.f.b.uFu)
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(408L, 5L, 1L, false);
          if (Util.isNullOrNil(paramString))
          {
            auQ(getString(i.h.emoji_store_reward_magic_pay_self));
            AppMethodBeat.o(109296);
            return;
          }
          auQ(paramString);
          AppMethodBeat.o(109296);
          return;
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(408L, 8L, 1L, false);
        Toast.makeText(this, getString(i.h.emoji_store_ask_reward_failed), 0).show();
        AppMethodBeat.o(109296);
        return;
      }
      if (!this.uOM)
      {
        this.uOM = true;
        com.tencent.mm.plugin.report.service.h.IzE.a(12738, new Object[] { this.uFv, Integer.valueOf(this.uOz), Integer.valueOf(this.uEL), Integer.valueOf(2) });
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(408L, 8L, 1L, false);
      Toast.makeText(this, getString(i.h.emoji_store_ask_reward_failed), 0).show();
      AppMethodBeat.o(109296);
      return;
    } while (!(paramq instanceof com.tencent.mm.plugin.emoji.f.p));
    paramString = (com.tencent.mm.plugin.emoji.f.p)paramq;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "update emotion reward success.");
      this.uKD = paramString.cVi();
      com.tencent.mm.ay.q.bml().a(this.uKD.VIh.Svc, null, e.l(this.uFv, this.uKD.VIh.Svc, new Object[0]));
      this.mHandler.sendEmptyMessage(1002);
      AppMethodBeat.o(109296);
      return;
    }
    Log.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "update emotion reward failed.");
    AppMethodBeat.o(109296);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class b
    extends BaseAdapter
  {
    private LinkedList<akf> uOp;
    
    b() {}
    
    public final akf JJ(int paramInt)
    {
      AppMethodBeat.i(109283);
      if ((paramInt < 0) || (paramInt > getCount()))
      {
        AppMethodBeat.o(109283);
        return null;
      }
      if (this.uOp == null)
      {
        AppMethodBeat.o(109283);
        return null;
      }
      akf localakf = (akf)this.uOp.get(paramInt);
      AppMethodBeat.o(109283);
      return localakf;
    }
    
    public final void X(LinkedList<akf> paramLinkedList)
    {
      AppMethodBeat.i(109281);
      if (this.uOp == null) {
        this.uOp = new LinkedList();
      }
      this.uOp.clear();
      this.uOp.addAll(paramLinkedList);
      notifyDataSetChanged();
      AppMethodBeat.o(109281);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(109282);
      if (this.uOp == null)
      {
        AppMethodBeat.o(109282);
        return 0;
      }
      int i = this.uOp.size();
      AppMethodBeat.o(109282);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(109284);
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramView = ad.kS(EmojiStoreV2RewardUI.this.getContext()).inflate(i.f.emoji_store_v2_reward_item, null);
        paramViewGroup = new EmojiStoreV2RewardUI.c(EmojiStoreV2RewardUI.this, paramView);
        paramView.setTag(paramViewGroup);
        akf localakf = JJ(paramInt);
        if (localakf == null) {
          break label123;
        }
        paramViewGroup.uOV.setVisibility(0);
        paramViewGroup.uOV.setText(localakf.VHM + localakf.CRn);
      }
      for (;;)
      {
        AppMethodBeat.o(109284);
        return paramView;
        paramViewGroup = (EmojiStoreV2RewardUI.c)paramView.getTag();
        break;
        label123:
        paramViewGroup.uOV.setVisibility(8);
      }
    }
  }
  
  final class c
  {
    TextView uOV;
    
    public c(View paramView)
    {
      AppMethodBeat.i(109286);
      this.uOV = ((TextView)paramView.findViewById(i.e.priece));
      AppMethodBeat.o(109286);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI
 * JD-Core Version:    0.7.0.1
 */