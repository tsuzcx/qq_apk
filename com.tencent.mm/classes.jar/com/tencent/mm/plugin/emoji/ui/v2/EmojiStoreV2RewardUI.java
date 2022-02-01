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
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.ui.GridInScrollView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.EmotionPrice;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.protocal.protobuf.agn;
import com.tencent.mm.protocal.protobuf.gu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.z;
import java.util.LinkedList;

public class EmojiStoreV2RewardUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, com.tencent.mm.al.f
{
  private ProgressDialog iYL;
  private ap mHandler;
  private int pEK;
  private String pEQ;
  private String pFt;
  private GetEmotionRewardResponse pJQ;
  private Button pKp;
  private AnimationDrawable pNG;
  private int pNJ;
  private EmojiStoreV2RewardBannerView pNK;
  private GridInScrollView pNL;
  private View pNM;
  private View pNN;
  private MMFormInputView pNO;
  private TextView pNP;
  private TextView pNQ;
  private b pNR;
  private com.tencent.mm.plugin.emoji.f.b pNS;
  private String pNT;
  private String pNU;
  private EmojiStoreV2RewardUI.a pNV;
  private boolean pNW;
  private View.OnClickListener pNX;
  private View.OnClickListener pNY;
  private TextWatcher pNZ;
  private com.tencent.mm.plugin.emoji.model.i pOa;
  
  public EmojiStoreV2RewardUI()
  {
    AppMethodBeat.i(109287);
    this.pNV = EmojiStoreV2RewardUI.a.pOc;
    this.pNW = false;
    this.mHandler = new ap()
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
          if ((!bt.isNullOrNil(paramAnonymousMessage)) && (com.tencent.mm.vfs.i.fv(paramAnonymousMessage)))
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
            ad.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "path is null or file no exists");
            AppMethodBeat.o(109270);
            return;
            EmojiStoreV2RewardUI.c(EmojiStoreV2RewardUI.this);
          }
        }
      }
    };
    this.pNX = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109271);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (EmojiStoreV2RewardUI.d(EmojiStoreV2RewardUI.this) != null)
        {
          paramAnonymousView = EmojiStoreV2RewardUI.d(EmojiStoreV2RewardUI.this).Cf(0);
          if (EmojiStoreV2RewardUI.e(EmojiStoreV2RewardUI.this).getText() != null)
          {
            paramAnonymousView.Number = EmojiStoreV2RewardUI.e(EmojiStoreV2RewardUI.this).getText().toString();
            EmojiStoreV2RewardUI.a(EmojiStoreV2RewardUI.this, EmojiStoreV2RewardUI.f(EmojiStoreV2RewardUI.this), paramAnonymousView);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109271);
          return;
          ad.w("MicroMsg.emoji.EmojiStoreV2RewardUI", "mRewardInputView is null");
          continue;
          ad.w("MicroMsg.emoji.EmojiStoreV2RewardUI", "mAdapter is null.");
        }
      }
    };
    this.pNY = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109272);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (EmojiStoreV2RewardUI.g(EmojiStoreV2RewardUI.this) == EmojiStoreV2RewardUI.a.pOc) {
          EmojiStoreV2RewardUI.a(EmojiStoreV2RewardUI.this, EmojiStoreV2RewardUI.a.pOd);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109272);
      }
    };
    this.pNZ = new TextWatcher()
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
          EmojiStoreV2RewardUI.e(EmojiStoreV2RewardUI.this).getContentEditText().setTextColor(EmojiStoreV2RewardUI.this.getContext().getResources().getColor(2131100798));
          EmojiStoreV2RewardUI.h(EmojiStoreV2RewardUI.this).setEnabled(false);
          AppMethodBeat.o(109273);
          return;
        }
        EmojiStoreV2RewardUI.e(EmojiStoreV2RewardUI.this).getContentEditText().setTextColor(EmojiStoreV2RewardUI.this.getContext().getResources().getColor(2131100711));
        EmojiStoreV2RewardUI.h(EmojiStoreV2RewardUI.this).setEnabled(true);
        AppMethodBeat.o(109273);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    this.pOa = new com.tencent.mm.plugin.emoji.model.i(new com.tencent.mm.aw.a.c.k()
    {
      public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(109274);
        if ((!bt.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equalsIgnoreCase(EmojiStoreV2RewardUI.i(EmojiStoreV2RewardUI.this))))
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
    if (parama == EmojiStoreV2RewardUI.a.pOd)
    {
      this.pNV = EmojiStoreV2RewardUI.a.pOd;
      if (this.pNN != null)
      {
        this.pNN.setVisibility(0);
        this.pNN.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772095));
        this.pNO.getContentEditText().requestFocus();
        showVKB();
        this.pNM.setVisibility(8);
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
  
  private void a(String paramString, EmotionPrice paramEmotionPrice)
  {
    AppMethodBeat.i(109297);
    aRX();
    this.pNS = new com.tencent.mm.plugin.emoji.f.b(paramString, paramEmotionPrice);
    com.tencent.mm.kernel.g.ajB().gAO.a(this.pNS, 0);
    AppMethodBeat.o(109297);
  }
  
  private void aRX()
  {
    AppMethodBeat.i(109298);
    getString(2131755906);
    this.iYL = h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(109277);
        com.tencent.mm.kernel.g.ajB().gAO.a(EmojiStoreV2RewardUI.m(EmojiStoreV2RewardUI.this));
        AppMethodBeat.o(109277);
      }
    });
    AppMethodBeat.o(109298);
  }
  
  private void abY(String paramString)
  {
    AppMethodBeat.i(109299);
    h.a(getContext(), paramString, null, getString(2131758304), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(109299);
  }
  
  private void kA(boolean paramBoolean)
  {
    AppMethodBeat.i(109300);
    ad.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "doGetRewardScene");
    if (paramBoolean)
    {
      localo = new com.tencent.mm.plugin.emoji.f.o(this.pFt, com.tencent.mm.plugin.emoji.f.o.pGg);
      com.tencent.mm.kernel.g.ajB().gAO.a(localo, 0);
      AppMethodBeat.o(109300);
      return;
    }
    com.tencent.mm.plugin.emoji.f.o localo = new com.tencent.mm.plugin.emoji.f.o(this.pFt, com.tencent.mm.plugin.emoji.f.o.pGh);
    com.tencent.mm.kernel.g.ajB().gAO.a(localo, 0);
    aRX();
    AppMethodBeat.o(109300);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(109293);
    if (this.pJQ != null)
    {
      this.pNP.setVisibility(0);
      this.pNQ.setVisibility(0);
      if ((this.pJQ.Reward != null) && (!bt.isNullOrNil(this.pJQ.Reward.Gex)))
      {
        this.pNT = this.pJQ.Reward.Gex;
        com.tencent.mm.emoji.d.a locala = com.tencent.mm.emoji.d.a.gqn;
        this.pNU = EmojiLogic.j(com.tencent.mm.emoji.d.a.agp(), this.pFt, this.pNT);
        if (com.tencent.mm.vfs.i.fv(this.pNU))
        {
          this.pNK.setImageFilePath(this.pNU);
          this.pNK.setScaleType(ImageView.ScaleType.FIT_XY);
          if ((this.pNG != null) && (this.pNG.isRunning())) {
            this.pNG.stop();
          }
        }
      }
    }
    while ((this.pJQ != null) && (this.pJQ.Price != null))
    {
      this.pNL.setVisibility(0);
      this.pNR.Y(this.pJQ.Price);
      AppMethodBeat.o(109293);
      return;
      com.tencent.mm.aw.q.aIJ().a(this.pNT, this.pNK, e.j(this.pFt, this.pNT, new Object[0]), this.pOa);
      this.pNK.setBackgroundDrawable(getResources().getDrawable(2131232083));
      this.pNK.setImageDrawable(this.pNG);
      this.pNK.setScaleType(ImageView.ScaleType.CENTER);
      this.pNG.start();
      continue;
      this.pNK.setBackgroundDrawable(getResources().getDrawable(2131232083));
      this.pNK.setImageDrawable(this.pNG);
      this.pNK.setScaleType(ImageView.ScaleType.CENTER);
      this.pNG.start();
      continue;
      this.pNP.setVisibility(8);
      this.pNQ.setVisibility(8);
    }
    this.pNL.setVisibility(8);
    AppMethodBeat.o(109293);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131493822;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109292);
    if (bt.isNullOrNil(this.pEQ)) {
      setMMTitle(2131758352);
    }
    for (;;)
    {
      setMMSubTitle(2131766182);
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
      this.pNM = findViewById(2131304159);
      this.pNN = findViewById(2131304160);
      this.pNO = ((MMFormInputView)findViewById(2131304161));
      this.pKp = ((Button)findViewById(2131304162));
      this.pKp.setOnClickListener(this.pNX);
      this.pKp.setEnabled(false);
      this.pNO.setInputType(8194);
      this.pNO.addTextChangedListener(this.pNZ);
      this.pNO.getContentEditText().setFilters(new InputFilter[] { new InputFilter.LengthFilter(12) });
      this.pNP = ((TextView)findViewById(2131304157));
      this.pNP.setOnClickListener(this.pNY);
      this.pNQ = ((TextView)findViewById(2131304155));
      this.pNK = ((EmojiStoreV2RewardBannerView)findViewById(2131297198));
      this.pNL = ((GridInScrollView)findViewById(16908298));
      this.pNR = new b();
      this.pNL.setAdapter(this.pNR);
      this.pNL.setOnItemClickListener(this);
      this.pNG = ((AnimationDrawable)getResources().getDrawable(2131232019));
      AppMethodBeat.o(109292);
      return;
      setMMTitle(getString(2131758371, new Object[] { this.pEQ }));
    }
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
        paramIntent = new Intent();
        paramIntent.setClass(this, EmojiStoreV2RewardThanksUI.class);
        paramIntent.putExtra("extra_id", this.pFt);
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.ahp(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI", "startThanksUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramIntent.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI", "startThanksUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.g.yhR.f(12738, new Object[] { this.pFt, Integer.valueOf(this.pNJ), Integer.valueOf(this.pEK), Integer.valueOf(1) });
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(408L, 9L, 1L, false);
        kA(true);
        finish();
        AppMethodBeat.o(109295);
        return;
      }
      if (paramInt2 == 0)
      {
        com.tencent.mm.plugin.report.service.g.yhR.f(12738, new Object[] { this.pFt, Integer.valueOf(this.pNJ), Integer.valueOf(this.pEK), Integer.valueOf(3) });
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(408L, 3L, 1L, false);
        AppMethodBeat.o(109295);
        return;
      }
      if (!this.pNW)
      {
        this.pNW = true;
        com.tencent.mm.plugin.report.service.g.yhR.f(12738, new Object[] { this.pFt, Integer.valueOf(this.pNJ), Integer.valueOf(this.pEK), Integer.valueOf(2) });
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(408L, 4L, 1L, false);
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(109290);
    ad.i("MicroMsg.emoji.EmojiStoreV2RewardUI", keyboardState());
    if (this.pNV == EmojiStoreV2RewardUI.a.pOc)
    {
      if (this.pNW) {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(408L, 2L, 1L, false);
      }
      for (;;)
      {
        super.onBackPressed();
        AppMethodBeat.o(109290);
        return;
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(408L, 1L, 1L, false);
        com.tencent.mm.plugin.report.service.g.yhR.f(12738, new Object[] { this.pFt, Integer.valueOf(this.pNJ), Integer.valueOf(this.pEK), Integer.valueOf(4) });
      }
    }
    a(EmojiStoreV2RewardUI.a.pOc);
    AppMethodBeat.o(109290);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109288);
    super.onCreate(paramBundle);
    this.pFt = getIntent().getStringExtra("extra_id");
    this.pEQ = getIntent().getStringExtra("name");
    this.pEK = getIntent().getIntExtra("scene", 0);
    this.pNJ = getIntent().getIntExtra("pageType", 0);
    initView();
    this.pJQ = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILs.aUU(this.pFt);
    if ((this.pJQ != null) && (this.pJQ.Reward != null))
    {
      com.tencent.mm.aw.q.aIJ().a(this.pJQ.Reward.Gey, null, e.j(this.pFt, this.pJQ.Reward.Gey, new Object[0]));
      com.tencent.mm.aw.q.aIJ().a(this.pJQ.Reward.Gez, null, e.j(this.pFt, this.pJQ.Reward.Gez, new Object[0]));
    }
    for (;;)
    {
      updateView();
      com.tencent.mm.kernel.g.ajB().gAO.a(830, this);
      com.tencent.mm.kernel.g.ajB().gAO.a(822, this);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(408L, 0L, 1L, false);
      AppMethodBeat.o(109288);
      return;
      kA(false);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109289);
    com.tencent.mm.kernel.g.ajB().gAO.b(830, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(822, this);
    if ((this.pNG != null) && (this.pNG.isRunning())) {
      this.pNG.stop();
    }
    com.tencent.mm.aw.q.aIJ().a(null, this.pNK);
    this.pOa.pEG = null;
    this.pOa = null;
    super.onDestroy();
    AppMethodBeat.o(109289);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(109294);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramAdapterView);
    localb.bd(paramView);
    localb.mr(paramInt);
    localb.qY(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
    if (this.pNR != null)
    {
      paramAdapterView = this.pNR.Cf(paramInt);
      if (paramAdapterView != null)
      {
        ad.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "onItemClick position:%d", new Object[] { Integer.valueOf(paramInt) });
        a(this.pFt, paramAdapterView);
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(109294);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(109296);
    if ((this.iYL != null) && (this.iYL.isShowing())) {
      this.iYL.dismiss();
    }
    int i = paramn.getType();
    switch (i)
    {
    default: 
      ad.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "unknown scene. type:%d", new Object[] { Integer.valueOf(i) });
    }
    do
    {
      AppMethodBeat.o(109296);
      return;
      Object localObject = (com.tencent.mm.plugin.emoji.f.b)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = new Bundle();
        paramString.putBoolean("extinfo_key_10", true);
        paramn = getContext();
        String str = ((com.tencent.mm.plugin.emoji.f.b)localObject).cha().FyM;
        localObject = ((com.tencent.mm.plugin.emoji.f.b)localObject).cha().gsT;
        if (!bt.isNullOrNil(str))
        {
          localObject = com.tencent.mm.pluginsdk.wallet.f.aj(str, (String)localObject, 5);
          ((PayInfo)localObject).htZ = paramString;
          com.tencent.mm.pluginsdk.wallet.f.a(paramn, (PayInfo)localObject, 8001);
        }
        AppMethodBeat.o(109296);
        return;
      }
      if (paramInt1 == 4)
      {
        if (!this.pNW)
        {
          this.pNW = true;
          com.tencent.mm.plugin.report.service.g.yhR.f(12738, new Object[] { this.pFt, Integer.valueOf(this.pNJ), Integer.valueOf(this.pEK), Integer.valueOf(2) });
        }
        if (paramInt2 == com.tencent.mm.plugin.emoji.f.b.pFq)
        {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(408L, 6L, 1L, false);
          if (bt.isNullOrNil(paramString))
          {
            abY(getString(2131758358));
            AppMethodBeat.o(109296);
            return;
          }
          abY(paramString);
          AppMethodBeat.o(109296);
          return;
        }
        if (paramInt2 == com.tencent.mm.plugin.emoji.f.b.pFr)
        {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(408L, 7L, 1L, false);
          if (bt.isNullOrNil(paramString))
          {
            abY(getString(2131758360));
            AppMethodBeat.o(109296);
            return;
          }
          abY(paramString);
          AppMethodBeat.o(109296);
          return;
        }
        if (paramInt2 == com.tencent.mm.plugin.emoji.f.b.pFs)
        {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(408L, 5L, 1L, false);
          if (bt.isNullOrNil(paramString))
          {
            abY(getString(2131758359));
            AppMethodBeat.o(109296);
            return;
          }
          abY(paramString);
          AppMethodBeat.o(109296);
          return;
        }
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(408L, 8L, 1L, false);
        Toast.makeText(this, getString(2131758310), 0).show();
        AppMethodBeat.o(109296);
        return;
      }
      if (!this.pNW)
      {
        this.pNW = true;
        com.tencent.mm.plugin.report.service.g.yhR.f(12738, new Object[] { this.pFt, Integer.valueOf(this.pNJ), Integer.valueOf(this.pEK), Integer.valueOf(2) });
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(408L, 8L, 1L, false);
      Toast.makeText(this, getString(2131758310), 0).show();
      AppMethodBeat.o(109296);
      return;
    } while (!(paramn instanceof com.tencent.mm.plugin.emoji.f.o));
    paramString = (com.tencent.mm.plugin.emoji.f.o)paramn;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ad.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "update emotion reward success.");
      this.pJQ = paramString.chl();
      com.tencent.mm.aw.q.aIJ().a(this.pJQ.Reward.Gey, null, e.j(this.pFt, this.pJQ.Reward.Gey, new Object[0]));
      this.mHandler.sendEmptyMessage(1002);
      AppMethodBeat.o(109296);
      return;
    }
    ad.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "update emotion reward failed.");
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
    private LinkedList<EmotionPrice> pNz;
    
    b() {}
    
    public final EmotionPrice Cf(int paramInt)
    {
      AppMethodBeat.i(109283);
      if ((paramInt < 0) || (paramInt > getCount()))
      {
        AppMethodBeat.o(109283);
        return null;
      }
      if (this.pNz == null)
      {
        AppMethodBeat.o(109283);
        return null;
      }
      EmotionPrice localEmotionPrice = (EmotionPrice)this.pNz.get(paramInt);
      AppMethodBeat.o(109283);
      return localEmotionPrice;
    }
    
    public final void Y(LinkedList<EmotionPrice> paramLinkedList)
    {
      AppMethodBeat.i(109281);
      if (this.pNz == null) {
        this.pNz = new LinkedList();
      }
      this.pNz.clear();
      this.pNz.addAll(paramLinkedList);
      notifyDataSetChanged();
      AppMethodBeat.o(109281);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(109282);
      if (this.pNz == null)
      {
        AppMethodBeat.o(109282);
        return 0;
      }
      int i = this.pNz.size();
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
        paramView = z.jO(EmojiStoreV2RewardUI.this.getContext()).inflate(2131493820, null);
        paramViewGroup = new EmojiStoreV2RewardUI.c(EmojiStoreV2RewardUI.this, paramView);
        paramView.setTag(paramViewGroup);
        EmotionPrice localEmotionPrice = Cf(paramInt);
        if (localEmotionPrice == null) {
          break label122;
        }
        paramViewGroup.pOf.setVisibility(0);
        paramViewGroup.pOf.setText(localEmotionPrice.Number + localEmotionPrice.Label);
      }
      for (;;)
      {
        AppMethodBeat.o(109284);
        return paramView;
        paramViewGroup = (EmojiStoreV2RewardUI.c)paramView.getTag();
        break;
        label122:
        paramViewGroup.pOf.setVisibility(8);
      }
    }
  }
  
  final class c
  {
    TextView pOf;
    
    public c(View paramView)
    {
      AppMethodBeat.i(109286);
      this.pOf = ((TextView)paramView.findViewById(2131303404));
      AppMethodBeat.o(109286);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI
 * JD-Core Version:    0.7.0.1
 */