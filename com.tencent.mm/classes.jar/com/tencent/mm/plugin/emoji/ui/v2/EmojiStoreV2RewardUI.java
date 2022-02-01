package com.tencent.mm.plugin.emoji.ui.v2;

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
import com.tencent.mm.kernel.c;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.emoji.g.d;
import com.tencent.mm.plugin.emoji.h.a;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.h.d;
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.plugin.emoji.h.f;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.emoji.mgr.e;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.q;
import com.tencent.mm.plugin.emoji.ui.GridInScrollView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.ciy;
import com.tencent.mm.protocal.protobuf.goi;
import com.tencent.mm.protocal.protobuf.ho;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.vfs.y;
import java.util.LinkedList;

public class EmojiStoreV2RewardUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, com.tencent.mm.am.h
{
  private MMHandler mHandler;
  private ProgressDialog pNH;
  public String xNX;
  public int xNn;
  private String xNt;
  private goi xSZ;
  private Button xTC;
  private q xXA;
  private AnimationDrawable xXg;
  public int xXj;
  private EmojiStoreV2RewardBannerView xXk;
  private GridInScrollView xXl;
  private View xXm;
  private View xXn;
  private MMFormInputView xXo;
  private TextView xXp;
  private TextView xXq;
  private b xXr;
  private com.tencent.mm.plugin.emoji.e.b xXs;
  private String xXt;
  private String xXu;
  private EmojiStoreV2RewardUI.a xXv;
  public boolean xXw;
  private View.OnClickListener xXx;
  private View.OnClickListener xXy;
  private TextWatcher xXz;
  
  public EmojiStoreV2RewardUI()
  {
    AppMethodBeat.i(109287);
    this.xXv = EmojiStoreV2RewardUI.a.xXC;
    this.xXw = false;
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
          if ((!Util.isNullOrNil(paramAnonymousMessage)) && (y.ZC(paramAnonymousMessage)))
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
    this.xXx = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109271);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (EmojiStoreV2RewardUI.d(EmojiStoreV2RewardUI.this) != null)
        {
          paramAnonymousView = EmojiStoreV2RewardUI.d(EmojiStoreV2RewardUI.this).Ku(0);
          if (EmojiStoreV2RewardUI.e(EmojiStoreV2RewardUI.this).getText() != null)
          {
            paramAnonymousView.akkx = EmojiStoreV2RewardUI.e(EmojiStoreV2RewardUI.this).getText().toString();
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
    this.xXy = new EmojiStoreV2RewardUI.3(this);
    this.xXz = new TextWatcher()
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
          EmojiStoreV2RewardUI.e(EmojiStoreV2RewardUI.this).getContentEditText().setTextColor(EmojiStoreV2RewardUI.this.getContext().getResources().getColor(h.b.red));
          EmojiStoreV2RewardUI.h(EmojiStoreV2RewardUI.this).setEnabled(false);
          AppMethodBeat.o(109273);
          return;
        }
        EmojiStoreV2RewardUI.e(EmojiStoreV2RewardUI.this).getContentEditText().setTextColor(EmojiStoreV2RewardUI.this.getContext().getResources().getColor(h.b.normal_text_color));
        EmojiStoreV2RewardUI.h(EmojiStoreV2RewardUI.this).setEnabled(true);
        AppMethodBeat.o(109273);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    this.xXA = new q(new com.tencent.mm.modelimage.loader.b.k()
    {
      public final void onImageLoadComplete(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
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
    if (parama == EmojiStoreV2RewardUI.a.xXD)
    {
      this.xXv = EmojiStoreV2RewardUI.a.xXD;
      if (this.xXn != null)
      {
        this.xXn.setVisibility(0);
        this.xXn.startAnimation(AnimationUtils.loadAnimation(getContext(), h.a.pop_in));
        this.xXo.getContentEditText().requestFocus();
        showVKB();
        this.xXm.setVisibility(8);
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
  
  private void a(String paramString, ciy paramciy)
  {
    AppMethodBeat.i(109297);
    showLoadingDialog();
    this.xXs = new com.tencent.mm.plugin.emoji.e.b(paramString, paramciy);
    com.tencent.mm.kernel.h.baD().mCm.a(this.xXs, 0);
    AppMethodBeat.o(109297);
  }
  
  private void aoP(String paramString)
  {
    AppMethodBeat.i(109299);
    com.tencent.mm.ui.base.k.a(getContext(), paramString, null, getString(h.h.emoji_sort_i_know), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(109299);
  }
  
  private void showLoadingDialog()
  {
    AppMethodBeat.i(109298);
    getString(h.h.app_tip);
    this.pNH = com.tencent.mm.ui.base.k.a(this, getString(h.h.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(109277);
        com.tencent.mm.kernel.h.baD().mCm.a(EmojiStoreV2RewardUI.m(EmojiStoreV2RewardUI.this));
        AppMethodBeat.o(109277);
      }
    });
    AppMethodBeat.o(109298);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(109293);
    if (this.xSZ != null)
    {
      this.xXp.setVisibility(0);
      this.xXq.setVisibility(0);
      if ((this.xSZ.aklh != null) && (!Util.isNullOrNil(this.xSZ.aklh.ZuT)))
      {
        this.xXt = this.xSZ.aklh.ZuT;
        this.xXu = EmojiLogic.o(d.bzQ(), this.xNX, this.xXt);
        if (y.ZC(this.xXu))
        {
          this.xXk.setImageFilePath(this.xXu);
          this.xXk.setScaleType(ImageView.ScaleType.FIT_XY);
          if ((this.xXg != null) && (this.xXg.isRunning())) {
            this.xXg.stop();
          }
        }
      }
    }
    while ((this.xSZ != null) && (this.xSZ.aklg != null))
    {
      this.xXl.setVisibility(0);
      this.xXr.aa(this.xSZ.aklg);
      AppMethodBeat.o(109293);
      return;
      r.bKe().a(this.xXt, this.xXk, e.m(this.xNX, this.xXt, new Object[0]), this.xXA);
      this.xXk.setBackgroundDrawable(getResources().getDrawable(h.d.emotion_reward_banner_bg_color));
      this.xXk.setImageDrawable(this.xXg);
      this.xXk.setScaleType(ImageView.ScaleType.CENTER);
      this.xXg.start();
      continue;
      this.xXk.setBackgroundDrawable(getResources().getDrawable(h.d.emotion_reward_banner_bg_color));
      this.xXk.setImageDrawable(this.xXg);
      this.xXk.setScaleType(ImageView.ScaleType.CENTER);
      this.xXg.start();
      continue;
      this.xXp.setVisibility(8);
      this.xXq.setVisibility(8);
    }
    this.xXl.setVisibility(8);
    AppMethodBeat.o(109293);
  }
  
  public final void dCs()
  {
    AppMethodBeat.i(270814);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this, EmojiStoreV2RewardThanksUI.class);
    ((Intent)localObject).putExtra("extra_id", this.xNX);
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI", "startThanksUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI", "startThanksUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(270814);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return h.f.emoji_store_v2_rewardl_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109292);
    if (Util.isNullOrNil(this.xNt)) {
      setMMTitle(h.h.emoji_store_reward);
    }
    for (;;)
    {
      setMMSubTitle(h.h.wechat_authenticate_safely);
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
      this.xXm = findViewById(h.e.reward_main);
      this.xXn = findViewById(h.e.reward_other);
      this.xXo = ((MMFormInputView)findViewById(h.e.reward_other_price_et));
      this.xTC = ((Button)findViewById(h.e.reward_reward_btn));
      this.xTC.setOnClickListener(this.xXx);
      this.xTC.setEnabled(false);
      this.xXo.setInputType(8194);
      this.xXo.addTextChangedListener(this.xXz);
      this.xXo.getContentEditText().setFilters(new InputFilter[] { new InputFilter.LengthFilter(12) });
      this.xXp = ((TextView)findViewById(h.e.reward_custom));
      this.xXp.setOnClickListener(this.xXy);
      this.xXq = ((TextView)findViewById(h.e.reward_choose_price));
      this.xXk = ((EmojiStoreV2RewardBannerView)findViewById(h.e.beg_pic));
      this.xXl = ((GridInScrollView)findViewById(16908298));
      this.xXr = new b();
      this.xXl.setAdapter(this.xXr);
      this.xXl.setOnItemClickListener(this);
      this.xXg = ((AnimationDrawable)getResources().getDrawable(h.d.emoji_doge_loading));
      AppMethodBeat.o(109292);
      return;
      setMMTitle(getString(h.h.emoji_store_reward_to_designer, new Object[] { this.xNt }));
    }
  }
  
  public final void oj(boolean paramBoolean)
  {
    AppMethodBeat.i(109300);
    Log.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "doGetRewardScene");
    if (paramBoolean)
    {
      localp = new com.tencent.mm.plugin.emoji.e.p(this.xNX, com.tencent.mm.plugin.emoji.e.p.xOO);
      com.tencent.mm.kernel.h.baD().mCm.a(localp, 0);
      AppMethodBeat.o(109300);
      return;
    }
    com.tencent.mm.plugin.emoji.e.p localp = new com.tencent.mm.plugin.emoji.e.p(this.xNX, com.tencent.mm.plugin.emoji.e.p.xOP);
    com.tencent.mm.kernel.h.baD().mCm.a(localp, 0);
    showLoadingDialog();
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
        dCs();
        com.tencent.mm.plugin.report.service.h.OAn.b(12738, new Object[] { this.xNX, Integer.valueOf(this.xXj), Integer.valueOf(this.xNn), Integer.valueOf(1) });
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(408L, 9L, 1L, false);
        oj(true);
        finish();
        AppMethodBeat.o(109295);
        return;
      }
      if (paramInt2 == 0)
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(12738, new Object[] { this.xNX, Integer.valueOf(this.xXj), Integer.valueOf(this.xNn), Integer.valueOf(3) });
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(408L, 3L, 1L, false);
        AppMethodBeat.o(109295);
        return;
      }
      if (!this.xXw)
      {
        this.xXw = true;
        com.tencent.mm.plugin.report.service.h.OAn.b(12738, new Object[] { this.xNX, Integer.valueOf(this.xXj), Integer.valueOf(this.xNn), Integer.valueOf(2) });
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(408L, 4L, 1L, false);
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(109290);
    Log.i("MicroMsg.emoji.EmojiStoreV2RewardUI", keyboardState());
    if (this.xXv == EmojiStoreV2RewardUI.a.xXC)
    {
      if (this.xXw) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(408L, 2L, 1L, false);
      }
      for (;;)
      {
        super.onBackPressed();
        AppMethodBeat.o(109290);
        return;
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(408L, 1L, 1L, false);
        com.tencent.mm.plugin.report.service.h.OAn.b(12738, new Object[] { this.xNX, Integer.valueOf(this.xXj), Integer.valueOf(this.xNn), Integer.valueOf(4) });
      }
    }
    a(EmojiStoreV2RewardUI.a.xXC);
    AppMethodBeat.o(109290);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109288);
    super.onCreate(paramBundle);
    this.xNX = getIntent().getStringExtra("extra_id");
    this.xNt = getIntent().getStringExtra("name");
    this.xNn = getIntent().getIntExtra("scene", 0);
    this.xXj = getIntent().getIntExtra("pageType", 0);
    initView();
    this.xSZ = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjA.bzk(this.xNX);
    if ((this.xSZ != null) && (this.xSZ.aklh != null))
    {
      r.bKe().a(this.xSZ.aklh.ZuU, null, e.m(this.xNX, this.xSZ.aklh.ZuU, new Object[0]));
      r.bKe().a(this.xSZ.aklh.ZuV, null, e.m(this.xNX, this.xSZ.aklh.ZuV, new Object[0]));
    }
    for (;;)
    {
      updateView();
      com.tencent.mm.kernel.h.baD().mCm.a(830, this);
      com.tencent.mm.kernel.h.baD().mCm.a(822, this);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(408L, 0L, 1L, false);
      AppMethodBeat.o(109288);
      return;
      oj(false);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109289);
    com.tencent.mm.kernel.h.baD().mCm.b(830, this);
    com.tencent.mm.kernel.h.baD().mCm.b(822, this);
    if ((this.xXg != null) && (this.xXg.isRunning())) {
      this.xXg.stop();
    }
    r.bKe().a(null, this.xXk);
    this.xXA.xNi = null;
    this.xXA = null;
    super.onDestroy();
    AppMethodBeat.o(109289);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(109294);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramAdapterView);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.hB(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
    if (this.xXr != null)
    {
      paramAdapterView = this.xXr.Ku(paramInt);
      if (paramAdapterView != null)
      {
        Log.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "onItemClick position:%d", new Object[] { Integer.valueOf(paramInt) });
        a(this.xNX, paramAdapterView);
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(109294);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(109296);
    if ((this.pNH != null) && (this.pNH.isShowing())) {
      this.pNH.dismiss();
    }
    int i = paramp.getType();
    switch (i)
    {
    default: 
      Log.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "unknown scene. type:%d", new Object[] { Integer.valueOf(i) });
    }
    do
    {
      AppMethodBeat.o(109296);
      return;
      Object localObject = (com.tencent.mm.plugin.emoji.e.b)paramp;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        boolean bool = ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).isSwitch2InWxAppPay(((com.tencent.mm.plugin.emoji.e.b)localObject).dAx().YIV);
        Log.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "doEmojiReward, isSwitch2InWxAppPay:%b", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).startInWxAppPayUseCase(this, ((com.tencent.mm.plugin.emoji.e.b)localObject).dAx().YIV, "", "", 5, 0);
          AppMethodBeat.o(109296);
          return;
        }
        paramString = new Bundle();
        paramString.putBoolean("extinfo_key_10", true);
        paramp = getContext();
        String str = ((com.tencent.mm.plugin.emoji.e.b)localObject).dAx().YIV;
        localObject = ((com.tencent.mm.plugin.emoji.e.b)localObject).dAx().muA;
        if (!Util.isNullOrNil(str))
        {
          localObject = f.aL(str, (String)localObject, 5);
          ((PayInfo)localObject).nKf = paramString;
          f.a(paramp, (PayInfo)localObject, 8001);
        }
        AppMethodBeat.o(109296);
        return;
      }
      if (paramInt1 == 4)
      {
        if (!this.xXw)
        {
          this.xXw = true;
          com.tencent.mm.plugin.report.service.h.OAn.b(12738, new Object[] { this.xNX, Integer.valueOf(this.xXj), Integer.valueOf(this.xNn), Integer.valueOf(2) });
        }
        if (paramInt2 == com.tencent.mm.plugin.emoji.e.b.xNU)
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(408L, 6L, 1L, false);
          if (Util.isNullOrNil(paramString))
          {
            aoP(getString(h.h.emoji_store_reward_magic_pay_limite));
            AppMethodBeat.o(109296);
            return;
          }
          aoP(paramString);
          AppMethodBeat.o(109296);
          return;
        }
        if (paramInt2 == com.tencent.mm.plugin.emoji.e.b.xNV)
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(408L, 7L, 1L, false);
          if (Util.isNullOrNil(paramString))
          {
            aoP(getString(h.h.emoji_store_reward_magic_receive_limite));
            AppMethodBeat.o(109296);
            return;
          }
          aoP(paramString);
          AppMethodBeat.o(109296);
          return;
        }
        if (paramInt2 == com.tencent.mm.plugin.emoji.e.b.xNW)
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(408L, 5L, 1L, false);
          if (Util.isNullOrNil(paramString))
          {
            aoP(getString(h.h.emoji_store_reward_magic_pay_self));
            AppMethodBeat.o(109296);
            return;
          }
          aoP(paramString);
          AppMethodBeat.o(109296);
          return;
        }
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(408L, 8L, 1L, false);
        Toast.makeText(this, getString(h.h.emoji_store_ask_reward_failed), 0).show();
        AppMethodBeat.o(109296);
        return;
      }
      if (!this.xXw)
      {
        this.xXw = true;
        com.tencent.mm.plugin.report.service.h.OAn.b(12738, new Object[] { this.xNX, Integer.valueOf(this.xXj), Integer.valueOf(this.xNn), Integer.valueOf(2) });
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(408L, 8L, 1L, false);
      Toast.makeText(this, getString(h.h.emoji_store_ask_reward_failed), 0).show();
      AppMethodBeat.o(109296);
      return;
    } while (!(paramp instanceof com.tencent.mm.plugin.emoji.e.p));
    paramString = (com.tencent.mm.plugin.emoji.e.p)paramp;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "update emotion reward success.");
      this.xSZ = paramString.dAH();
      r.bKe().a(this.xSZ.aklh.ZuU, null, e.m(this.xNX, this.xSZ.aklh.ZuU, new Object[0]));
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
    private LinkedList<ciy> xWZ;
    
    b() {}
    
    public final ciy Ku(int paramInt)
    {
      AppMethodBeat.i(109283);
      if ((paramInt < 0) || (paramInt > getCount()))
      {
        AppMethodBeat.o(109283);
        return null;
      }
      if (this.xWZ == null)
      {
        AppMethodBeat.o(109283);
        return null;
      }
      ciy localciy = (ciy)this.xWZ.get(paramInt);
      AppMethodBeat.o(109283);
      return localciy;
    }
    
    public final void aa(LinkedList<ciy> paramLinkedList)
    {
      AppMethodBeat.i(109281);
      if (this.xWZ == null) {
        this.xWZ = new LinkedList();
      }
      this.xWZ.clear();
      this.xWZ.addAll(paramLinkedList);
      notifyDataSetChanged();
      AppMethodBeat.o(109281);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(109282);
      if (this.xWZ == null)
      {
        AppMethodBeat.o(109282);
        return 0;
      }
      int i = this.xWZ.size();
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
        paramView = af.mU(EmojiStoreV2RewardUI.this.getContext()).inflate(h.f.emoji_store_v2_reward_item, null);
        paramViewGroup = new EmojiStoreV2RewardUI.c(EmojiStoreV2RewardUI.this, paramView);
        paramView.setTag(paramViewGroup);
        ciy localciy = Ku(paramInt);
        if (localciy == null) {
          break label123;
        }
        paramViewGroup.xXF.setVisibility(0);
        paramViewGroup.xXF.setText(localciy.akkx + localciy.ILD);
      }
      for (;;)
      {
        AppMethodBeat.o(109284);
        return paramView;
        paramViewGroup = (EmojiStoreV2RewardUI.c)paramView.getTag();
        break;
        label123:
        paramViewGroup.xXF.setVisibility(8);
      }
    }
  }
  
  final class c
  {
    TextView xXF;
    
    public c(View paramView)
    {
      AppMethodBeat.i(109286);
      this.xXF = ((TextView)paramView.findViewById(h.e.priece));
      AppMethodBeat.o(109286);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI
 * JD-Core Version:    0.7.0.1
 */