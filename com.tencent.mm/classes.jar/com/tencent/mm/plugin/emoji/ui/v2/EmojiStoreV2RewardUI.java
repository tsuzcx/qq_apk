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
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.ui.GridInScrollView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.EmotionPrice;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.gu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.z;
import java.util.LinkedList;

public class EmojiStoreV2RewardUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, com.tencent.mm.ak.f
{
  private ProgressDialog jbE;
  private aq mHandler;
  private String pLX;
  private int pLo;
  private String pLu;
  private Button pQU;
  private GetEmotionRewardResponse pQv;
  private EmojiStoreV2RewardUI.a pUA;
  private boolean pUB;
  private View.OnClickListener pUC;
  private View.OnClickListener pUD;
  private TextWatcher pUE;
  private i pUF;
  private AnimationDrawable pUl;
  private int pUo;
  private EmojiStoreV2RewardBannerView pUp;
  private GridInScrollView pUq;
  private View pUr;
  private View pUs;
  private MMFormInputView pUt;
  private TextView pUu;
  private TextView pUv;
  private b pUw;
  private com.tencent.mm.plugin.emoji.f.b pUx;
  private String pUy;
  private String pUz;
  
  public EmojiStoreV2RewardUI()
  {
    AppMethodBeat.i(109287);
    this.pUA = EmojiStoreV2RewardUI.a.pUH;
    this.pUB = false;
    this.mHandler = new aq()
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
          if ((!bu.isNullOrNil(paramAnonymousMessage)) && (com.tencent.mm.vfs.o.fB(paramAnonymousMessage)))
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
            ae.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "path is null or file no exists");
            AppMethodBeat.o(109270);
            return;
            EmojiStoreV2RewardUI.c(EmojiStoreV2RewardUI.this);
          }
        }
      }
    };
    this.pUC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109271);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (EmojiStoreV2RewardUI.d(EmojiStoreV2RewardUI.this) != null)
        {
          paramAnonymousView = EmojiStoreV2RewardUI.d(EmojiStoreV2RewardUI.this).Cr(0);
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
          ae.w("MicroMsg.emoji.EmojiStoreV2RewardUI", "mRewardInputView is null");
          continue;
          ae.w("MicroMsg.emoji.EmojiStoreV2RewardUI", "mAdapter is null.");
        }
      }
    };
    this.pUD = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109272);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (EmojiStoreV2RewardUI.g(EmojiStoreV2RewardUI.this) == EmojiStoreV2RewardUI.a.pUH) {
          EmojiStoreV2RewardUI.a(EmojiStoreV2RewardUI.this, EmojiStoreV2RewardUI.a.pUI);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109272);
      }
    };
    this.pUE = new TextWatcher()
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
    this.pUF = new i(new com.tencent.mm.av.a.c.k()
    {
      public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(109274);
        if ((!bu.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equalsIgnoreCase(EmojiStoreV2RewardUI.i(EmojiStoreV2RewardUI.this))))
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
    if (parama == EmojiStoreV2RewardUI.a.pUI)
    {
      this.pUA = EmojiStoreV2RewardUI.a.pUI;
      if (this.pUs != null)
      {
        this.pUs.setVisibility(0);
        this.pUs.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772095));
        this.pUt.getContentEditText().requestFocus();
        showVKB();
        this.pUr.setVisibility(8);
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
    aSw();
    this.pUx = new com.tencent.mm.plugin.emoji.f.b(paramString, paramEmotionPrice);
    com.tencent.mm.kernel.g.ajQ().gDv.a(this.pUx, 0);
    AppMethodBeat.o(109297);
  }
  
  private void aSw()
  {
    AppMethodBeat.i(109298);
    getString(2131755906);
    this.jbE = h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(109277);
        com.tencent.mm.kernel.g.ajQ().gDv.a(EmojiStoreV2RewardUI.m(EmojiStoreV2RewardUI.this));
        AppMethodBeat.o(109277);
      }
    });
    AppMethodBeat.o(109298);
  }
  
  private void acP(String paramString)
  {
    AppMethodBeat.i(109299);
    h.a(getContext(), paramString, null, getString(2131758304), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(109299);
  }
  
  private void kz(boolean paramBoolean)
  {
    AppMethodBeat.i(109300);
    ae.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "doGetRewardScene");
    if (paramBoolean)
    {
      localo = new com.tencent.mm.plugin.emoji.f.o(this.pLX, com.tencent.mm.plugin.emoji.f.o.pMK);
      com.tencent.mm.kernel.g.ajQ().gDv.a(localo, 0);
      AppMethodBeat.o(109300);
      return;
    }
    com.tencent.mm.plugin.emoji.f.o localo = new com.tencent.mm.plugin.emoji.f.o(this.pLX, com.tencent.mm.plugin.emoji.f.o.pML);
    com.tencent.mm.kernel.g.ajQ().gDv.a(localo, 0);
    aSw();
    AppMethodBeat.o(109300);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(109293);
    if (this.pQv != null)
    {
      this.pUu.setVisibility(0);
      this.pUv.setVisibility(0);
      if ((this.pQv.Reward != null) && (!bu.isNullOrNil(this.pQv.Reward.Gxf)))
      {
        this.pUy = this.pQv.Reward.Gxf;
        com.tencent.mm.emoji.d.a locala = com.tencent.mm.emoji.d.a.gsI;
        this.pUz = EmojiLogic.j(com.tencent.mm.emoji.d.a.agD(), this.pLX, this.pUy);
        if (com.tencent.mm.vfs.o.fB(this.pUz))
        {
          this.pUp.setImageFilePath(this.pUz);
          this.pUp.setScaleType(ImageView.ScaleType.FIT_XY);
          if ((this.pUl != null) && (this.pUl.isRunning())) {
            this.pUl.stop();
          }
        }
      }
    }
    while ((this.pQv != null) && (this.pQv.Price != null))
    {
      this.pUq.setVisibility(0);
      this.pUw.Y(this.pQv.Price);
      AppMethodBeat.o(109293);
      return;
      com.tencent.mm.av.q.aJb().a(this.pUy, this.pUp, e.j(this.pLX, this.pUy, new Object[0]), this.pUF);
      this.pUp.setBackgroundDrawable(getResources().getDrawable(2131232083));
      this.pUp.setImageDrawable(this.pUl);
      this.pUp.setScaleType(ImageView.ScaleType.CENTER);
      this.pUl.start();
      continue;
      this.pUp.setBackgroundDrawable(getResources().getDrawable(2131232083));
      this.pUp.setImageDrawable(this.pUl);
      this.pUp.setScaleType(ImageView.ScaleType.CENTER);
      this.pUl.start();
      continue;
      this.pUu.setVisibility(8);
      this.pUv.setVisibility(8);
    }
    this.pUq.setVisibility(8);
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
    if (bu.isNullOrNil(this.pLu)) {
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
      this.pUr = findViewById(2131304159);
      this.pUs = findViewById(2131304160);
      this.pUt = ((MMFormInputView)findViewById(2131304161));
      this.pQU = ((Button)findViewById(2131304162));
      this.pQU.setOnClickListener(this.pUC);
      this.pQU.setEnabled(false);
      this.pUt.setInputType(8194);
      this.pUt.addTextChangedListener(this.pUE);
      this.pUt.getContentEditText().setFilters(new InputFilter[] { new InputFilter.LengthFilter(12) });
      this.pUu = ((TextView)findViewById(2131304157));
      this.pUu.setOnClickListener(this.pUD);
      this.pUv = ((TextView)findViewById(2131304155));
      this.pUp = ((EmojiStoreV2RewardBannerView)findViewById(2131297198));
      this.pUq = ((GridInScrollView)findViewById(16908298));
      this.pUw = new b();
      this.pUq.setAdapter(this.pUw);
      this.pUq.setOnItemClickListener(this);
      this.pUl = ((AnimationDrawable)getResources().getDrawable(2131232019));
      AppMethodBeat.o(109292);
      return;
      setMMTitle(getString(2131758371, new Object[] { this.pLu }));
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
        paramIntent.putExtra("extra_id", this.pLX);
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.ahE(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI", "startThanksUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramIntent.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI", "startThanksUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.g.yxI.f(12738, new Object[] { this.pLX, Integer.valueOf(this.pUo), Integer.valueOf(this.pLo), Integer.valueOf(1) });
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(408L, 9L, 1L, false);
        kz(true);
        finish();
        AppMethodBeat.o(109295);
        return;
      }
      if (paramInt2 == 0)
      {
        com.tencent.mm.plugin.report.service.g.yxI.f(12738, new Object[] { this.pLX, Integer.valueOf(this.pUo), Integer.valueOf(this.pLo), Integer.valueOf(3) });
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(408L, 3L, 1L, false);
        AppMethodBeat.o(109295);
        return;
      }
      if (!this.pUB)
      {
        this.pUB = true;
        com.tencent.mm.plugin.report.service.g.yxI.f(12738, new Object[] { this.pLX, Integer.valueOf(this.pUo), Integer.valueOf(this.pLo), Integer.valueOf(2) });
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(408L, 4L, 1L, false);
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(109290);
    ae.i("MicroMsg.emoji.EmojiStoreV2RewardUI", keyboardState());
    if (this.pUA == EmojiStoreV2RewardUI.a.pUH)
    {
      if (this.pUB) {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(408L, 2L, 1L, false);
      }
      for (;;)
      {
        super.onBackPressed();
        AppMethodBeat.o(109290);
        return;
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(408L, 1L, 1L, false);
        com.tencent.mm.plugin.report.service.g.yxI.f(12738, new Object[] { this.pLX, Integer.valueOf(this.pUo), Integer.valueOf(this.pLo), Integer.valueOf(4) });
      }
    }
    a(EmojiStoreV2RewardUI.a.pUH);
    AppMethodBeat.o(109290);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109288);
    super.onCreate(paramBundle);
    this.pLX = getIntent().getStringExtra("extra_id");
    this.pLu = getIntent().getStringExtra("name");
    this.pLo = getIntent().getIntExtra("scene", 0);
    this.pUo = getIntent().getIntExtra("pageType", 0);
    initView();
    this.pQv = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().JfZ.aWv(this.pLX);
    if ((this.pQv != null) && (this.pQv.Reward != null))
    {
      com.tencent.mm.av.q.aJb().a(this.pQv.Reward.Gxg, null, e.j(this.pLX, this.pQv.Reward.Gxg, new Object[0]));
      com.tencent.mm.av.q.aJb().a(this.pQv.Reward.Gxh, null, e.j(this.pLX, this.pQv.Reward.Gxh, new Object[0]));
    }
    for (;;)
    {
      updateView();
      com.tencent.mm.kernel.g.ajQ().gDv.a(830, this);
      com.tencent.mm.kernel.g.ajQ().gDv.a(822, this);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(408L, 0L, 1L, false);
      AppMethodBeat.o(109288);
      return;
      kz(false);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109289);
    com.tencent.mm.kernel.g.ajQ().gDv.b(830, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(822, this);
    if ((this.pUl != null) && (this.pUl.isRunning())) {
      this.pUl.stop();
    }
    com.tencent.mm.av.q.aJb().a(null, this.pUp);
    this.pUF.pLk = null;
    this.pUF = null;
    super.onDestroy();
    AppMethodBeat.o(109289);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(109294);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramAdapterView);
    localb.bd(paramView);
    localb.mu(paramInt);
    localb.rl(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
    if (this.pUw != null)
    {
      paramAdapterView = this.pUw.Cr(paramInt);
      if (paramAdapterView != null)
      {
        ae.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "onItemClick position:%d", new Object[] { Integer.valueOf(paramInt) });
        a(this.pLX, paramAdapterView);
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(109294);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(109296);
    if ((this.jbE != null) && (this.jbE.isShowing())) {
      this.jbE.dismiss();
    }
    int i = paramn.getType();
    switch (i)
    {
    default: 
      ae.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "unknown scene. type:%d", new Object[] { Integer.valueOf(i) });
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
        String str = ((com.tencent.mm.plugin.emoji.f.b)localObject).ciq().FRk;
        localObject = ((com.tencent.mm.plugin.emoji.f.b)localObject).ciq().gvv;
        if (!bu.isNullOrNil(str))
        {
          localObject = com.tencent.mm.pluginsdk.wallet.f.al(str, (String)localObject, 5);
          ((PayInfo)localObject).hwN = paramString;
          com.tencent.mm.pluginsdk.wallet.f.a(paramn, (PayInfo)localObject, 8001);
        }
        AppMethodBeat.o(109296);
        return;
      }
      if (paramInt1 == 4)
      {
        if (!this.pUB)
        {
          this.pUB = true;
          com.tencent.mm.plugin.report.service.g.yxI.f(12738, new Object[] { this.pLX, Integer.valueOf(this.pUo), Integer.valueOf(this.pLo), Integer.valueOf(2) });
        }
        if (paramInt2 == com.tencent.mm.plugin.emoji.f.b.pLU)
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(408L, 6L, 1L, false);
          if (bu.isNullOrNil(paramString))
          {
            acP(getString(2131758358));
            AppMethodBeat.o(109296);
            return;
          }
          acP(paramString);
          AppMethodBeat.o(109296);
          return;
        }
        if (paramInt2 == com.tencent.mm.plugin.emoji.f.b.pLV)
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(408L, 7L, 1L, false);
          if (bu.isNullOrNil(paramString))
          {
            acP(getString(2131758360));
            AppMethodBeat.o(109296);
            return;
          }
          acP(paramString);
          AppMethodBeat.o(109296);
          return;
        }
        if (paramInt2 == com.tencent.mm.plugin.emoji.f.b.pLW)
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(408L, 5L, 1L, false);
          if (bu.isNullOrNil(paramString))
          {
            acP(getString(2131758359));
            AppMethodBeat.o(109296);
            return;
          }
          acP(paramString);
          AppMethodBeat.o(109296);
          return;
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(408L, 8L, 1L, false);
        Toast.makeText(this, getString(2131758310), 0).show();
        AppMethodBeat.o(109296);
        return;
      }
      if (!this.pUB)
      {
        this.pUB = true;
        com.tencent.mm.plugin.report.service.g.yxI.f(12738, new Object[] { this.pLX, Integer.valueOf(this.pUo), Integer.valueOf(this.pLo), Integer.valueOf(2) });
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(408L, 8L, 1L, false);
      Toast.makeText(this, getString(2131758310), 0).show();
      AppMethodBeat.o(109296);
      return;
    } while (!(paramn instanceof com.tencent.mm.plugin.emoji.f.o));
    paramString = (com.tencent.mm.plugin.emoji.f.o)paramn;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ae.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "update emotion reward success.");
      this.pQv = paramString.ciB();
      com.tencent.mm.av.q.aJb().a(this.pQv.Reward.Gxg, null, e.j(this.pLX, this.pQv.Reward.Gxg, new Object[0]));
      this.mHandler.sendEmptyMessage(1002);
      AppMethodBeat.o(109296);
      return;
    }
    ae.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "update emotion reward failed.");
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
    private LinkedList<EmotionPrice> pUe;
    
    b() {}
    
    public final EmotionPrice Cr(int paramInt)
    {
      AppMethodBeat.i(109283);
      if ((paramInt < 0) || (paramInt > getCount()))
      {
        AppMethodBeat.o(109283);
        return null;
      }
      if (this.pUe == null)
      {
        AppMethodBeat.o(109283);
        return null;
      }
      EmotionPrice localEmotionPrice = (EmotionPrice)this.pUe.get(paramInt);
      AppMethodBeat.o(109283);
      return localEmotionPrice;
    }
    
    public final void Y(LinkedList<EmotionPrice> paramLinkedList)
    {
      AppMethodBeat.i(109281);
      if (this.pUe == null) {
        this.pUe = new LinkedList();
      }
      this.pUe.clear();
      this.pUe.addAll(paramLinkedList);
      notifyDataSetChanged();
      AppMethodBeat.o(109281);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(109282);
      if (this.pUe == null)
      {
        AppMethodBeat.o(109282);
        return 0;
      }
      int i = this.pUe.size();
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
        paramView = z.jV(EmojiStoreV2RewardUI.this.getContext()).inflate(2131493820, null);
        paramViewGroup = new EmojiStoreV2RewardUI.c(EmojiStoreV2RewardUI.this, paramView);
        paramView.setTag(paramViewGroup);
        EmotionPrice localEmotionPrice = Cr(paramInt);
        if (localEmotionPrice == null) {
          break label122;
        }
        paramViewGroup.pUK.setVisibility(0);
        paramViewGroup.pUK.setText(localEmotionPrice.Number + localEmotionPrice.Label);
      }
      for (;;)
      {
        AppMethodBeat.o(109284);
        return paramView;
        paramViewGroup = (EmojiStoreV2RewardUI.c)paramView.getTag();
        break;
        label122:
        paramViewGroup.pUK.setVisibility(8);
      }
    }
  }
  
  final class c
  {
    TextView pUK;
    
    public c(View paramView)
    {
      AppMethodBeat.i(109286);
      this.pUK = ((TextView)paramView.findViewById(2131303404));
      AppMethodBeat.o(109286);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI
 * JD-Core Version:    0.7.0.1
 */