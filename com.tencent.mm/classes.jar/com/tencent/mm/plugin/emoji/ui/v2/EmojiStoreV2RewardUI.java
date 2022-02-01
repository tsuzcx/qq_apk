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
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.f.p;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.ui.GridInScrollView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.EmotionPrice;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.protocal.protobuf.ajg;
import com.tencent.mm.protocal.protobuf.hh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.vfs.s;
import java.util.LinkedList;

public class EmojiStoreV2RewardUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, com.tencent.mm.ak.i
{
  private ProgressDialog jZH;
  private MMHandler mHandler;
  public int rbG;
  private String rbM;
  public String rcq;
  private Button rhU;
  private GetEmotionRewardResponse rhu;
  public boolean rlA;
  private View.OnClickListener rlB;
  private View.OnClickListener rlC;
  private TextWatcher rlD;
  private com.tencent.mm.plugin.emoji.model.i rlE;
  private AnimationDrawable rlk;
  public int rln;
  private EmojiStoreV2RewardBannerView rlo;
  private GridInScrollView rlp;
  private View rlq;
  private View rlr;
  private MMFormInputView rls;
  private TextView rlt;
  private TextView rlu;
  private b rlv;
  private com.tencent.mm.plugin.emoji.f.b rlw;
  private String rlx;
  private String rly;
  private EmojiStoreV2RewardUI.a rlz;
  
  public EmojiStoreV2RewardUI()
  {
    AppMethodBeat.i(109287);
    this.rlz = EmojiStoreV2RewardUI.a.rlG;
    this.rlA = false;
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
          if ((!Util.isNullOrNil(paramAnonymousMessage)) && (s.YS(paramAnonymousMessage)))
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
    this.rlB = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109271);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (EmojiStoreV2RewardUI.d(EmojiStoreV2RewardUI.this) != null)
        {
          paramAnonymousView = EmojiStoreV2RewardUI.d(EmojiStoreV2RewardUI.this).Gc(0);
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
          Log.w("MicroMsg.emoji.EmojiStoreV2RewardUI", "mRewardInputView is null");
          continue;
          Log.w("MicroMsg.emoji.EmojiStoreV2RewardUI", "mAdapter is null.");
        }
      }
    };
    this.rlC = new EmojiStoreV2RewardUI.3(this);
    this.rlD = new TextWatcher()
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
          EmojiStoreV2RewardUI.e(EmojiStoreV2RewardUI.this).getContentEditText().setTextColor(EmojiStoreV2RewardUI.this.getContext().getResources().getColor(2131100994));
          EmojiStoreV2RewardUI.h(EmojiStoreV2RewardUI.this).setEnabled(false);
          AppMethodBeat.o(109273);
          return;
        }
        EmojiStoreV2RewardUI.e(EmojiStoreV2RewardUI.this).getContentEditText().setTextColor(EmojiStoreV2RewardUI.this.getContext().getResources().getColor(2131100904));
        EmojiStoreV2RewardUI.h(EmojiStoreV2RewardUI.this).setEnabled(true);
        AppMethodBeat.o(109273);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    this.rlE = new com.tencent.mm.plugin.emoji.model.i(new com.tencent.mm.av.a.c.k()
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
    if (parama == EmojiStoreV2RewardUI.a.rlH)
    {
      this.rlz = EmojiStoreV2RewardUI.a.rlH;
      if (this.rlr != null)
      {
        this.rlr.setVisibility(0);
        this.rlr.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772119));
        this.rls.getContentEditText().requestFocus();
        showVKB();
        this.rlq.setVisibility(8);
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
    bnj();
    this.rlw = new com.tencent.mm.plugin.emoji.f.b(paramString, paramEmotionPrice);
    g.aAg().hqi.a(this.rlw, 0);
    AppMethodBeat.o(109297);
  }
  
  private void amW(String paramString)
  {
    AppMethodBeat.i(109299);
    com.tencent.mm.ui.base.h.a(getContext(), paramString, null, getString(2131758598), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(109299);
  }
  
  private void bnj()
  {
    AppMethodBeat.i(109298);
    getString(2131755998);
    this.jZH = com.tencent.mm.ui.base.h.a(this, getString(2131756029), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(109277);
        g.aAg().hqi.a(EmojiStoreV2RewardUI.m(EmojiStoreV2RewardUI.this));
        AppMethodBeat.o(109277);
      }
    });
    AppMethodBeat.o(109298);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(109293);
    if (this.rhu != null)
    {
      this.rlt.setVisibility(0);
      this.rlu.setVisibility(0);
      if ((this.rhu.Reward != null) && (!Util.isNullOrNil(this.rhu.Reward.LsL)))
      {
        this.rlx = this.rhu.Reward.LsL;
        com.tencent.mm.emoji.e.a locala = com.tencent.mm.emoji.e.a.hdT;
        this.rly = EmojiLogic.j(com.tencent.mm.emoji.e.a.awt(), this.rcq, this.rlx);
        if (s.YS(this.rly))
        {
          this.rlo.setImageFilePath(this.rly);
          this.rlo.setScaleType(ImageView.ScaleType.FIT_XY);
          if ((this.rlk != null) && (this.rlk.isRunning())) {
            this.rlk.stop();
          }
        }
      }
    }
    while ((this.rhu != null) && (this.rhu.Price != null))
    {
      this.rlp.setVisibility(0);
      this.rlv.Z(this.rhu.Price);
      AppMethodBeat.o(109293);
      return;
      com.tencent.mm.av.q.bcV().a(this.rlx, this.rlo, e.k(this.rcq, this.rlx, new Object[0]), this.rlE);
      this.rlo.setBackgroundDrawable(getResources().getDrawable(2131232175));
      this.rlo.setImageDrawable(this.rlk);
      this.rlo.setScaleType(ImageView.ScaleType.CENTER);
      this.rlk.start();
      continue;
      this.rlo.setBackgroundDrawable(getResources().getDrawable(2131232175));
      this.rlo.setImageDrawable(this.rlk);
      this.rlo.setScaleType(ImageView.ScaleType.CENTER);
      this.rlk.start();
      continue;
      this.rlt.setVisibility(8);
      this.rlu.setVisibility(8);
    }
    this.rlp.setVisibility(8);
    AppMethodBeat.o(109293);
  }
  
  public final void cIf()
  {
    AppMethodBeat.i(240182);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this, EmojiStoreV2RewardThanksUI.class);
    ((Intent)localObject).putExtra("extra_id", this.rcq);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI", "startThanksUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI", "startThanksUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(240182);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131493976;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109292);
    if (Util.isNullOrNil(this.rbM)) {
      setMMTitle(2131758646);
    }
    for (;;)
    {
      setMMSubTitle(2131768658);
      setBackBtn(new EmojiStoreV2RewardUI.7(this));
      this.rlq = findViewById(2131307059);
      this.rlr = findViewById(2131307060);
      this.rls = ((MMFormInputView)findViewById(2131307061));
      this.rhU = ((Button)findViewById(2131307062));
      this.rhU.setOnClickListener(this.rlB);
      this.rhU.setEnabled(false);
      this.rls.setInputType(8194);
      this.rls.addTextChangedListener(this.rlD);
      this.rls.getContentEditText().setFilters(new InputFilter[] { new InputFilter.LengthFilter(12) });
      this.rlt = ((TextView)findViewById(2131307057));
      this.rlt.setOnClickListener(this.rlC);
      this.rlu = ((TextView)findViewById(2131307055));
      this.rlo = ((EmojiStoreV2RewardBannerView)findViewById(2131297347));
      this.rlp = ((GridInScrollView)findViewById(16908298));
      this.rlv = new b();
      this.rlp.setAdapter(this.rlv);
      this.rlp.setOnItemClickListener(this);
      this.rlk = ((AnimationDrawable)getResources().getDrawable(2131232110));
      AppMethodBeat.o(109292);
      return;
      setMMTitle(getString(2131758665, new Object[] { this.rbM }));
    }
  }
  
  public final void lB(boolean paramBoolean)
  {
    AppMethodBeat.i(109300);
    Log.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "doGetRewardScene");
    if (paramBoolean)
    {
      localp = new p(this.rcq, p.rde);
      g.aAg().hqi.a(localp, 0);
      AppMethodBeat.o(109300);
      return;
    }
    p localp = new p(this.rcq, p.rdf);
    g.aAg().hqi.a(localp, 0);
    bnj();
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
        cIf();
        com.tencent.mm.plugin.report.service.h.CyF.a(12738, new Object[] { this.rcq, Integer.valueOf(this.rln), Integer.valueOf(this.rbG), Integer.valueOf(1) });
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(408L, 9L, 1L, false);
        lB(true);
        finish();
        AppMethodBeat.o(109295);
        return;
      }
      if (paramInt2 == 0)
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(12738, new Object[] { this.rcq, Integer.valueOf(this.rln), Integer.valueOf(this.rbG), Integer.valueOf(3) });
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(408L, 3L, 1L, false);
        AppMethodBeat.o(109295);
        return;
      }
      if (!this.rlA)
      {
        this.rlA = true;
        com.tencent.mm.plugin.report.service.h.CyF.a(12738, new Object[] { this.rcq, Integer.valueOf(this.rln), Integer.valueOf(this.rbG), Integer.valueOf(2) });
      }
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(408L, 4L, 1L, false);
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(109290);
    Log.i("MicroMsg.emoji.EmojiStoreV2RewardUI", keyboardState());
    if (this.rlz == EmojiStoreV2RewardUI.a.rlG)
    {
      if (this.rlA) {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(408L, 2L, 1L, false);
      }
      for (;;)
      {
        super.onBackPressed();
        AppMethodBeat.o(109290);
        return;
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(408L, 1L, 1L, false);
        com.tencent.mm.plugin.report.service.h.CyF.a(12738, new Object[] { this.rcq, Integer.valueOf(this.rln), Integer.valueOf(this.rbG), Integer.valueOf(4) });
      }
    }
    a(EmojiStoreV2RewardUI.a.rlG);
    AppMethodBeat.o(109290);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109288);
    super.onCreate(paramBundle);
    this.rcq = getIntent().getStringExtra("extra_id");
    this.rbM = getIntent().getStringExtra("name");
    this.rbG = getIntent().getIntExtra("scene", 0);
    this.rln = getIntent().getIntExtra("pageType", 0);
    initView();
    this.rhu = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpS.blu(this.rcq);
    if ((this.rhu != null) && (this.rhu.Reward != null))
    {
      com.tencent.mm.av.q.bcV().a(this.rhu.Reward.LsM, null, e.k(this.rcq, this.rhu.Reward.LsM, new Object[0]));
      com.tencent.mm.av.q.bcV().a(this.rhu.Reward.LsN, null, e.k(this.rcq, this.rhu.Reward.LsN, new Object[0]));
    }
    for (;;)
    {
      updateView();
      g.aAg().hqi.a(830, this);
      g.aAg().hqi.a(822, this);
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(408L, 0L, 1L, false);
      AppMethodBeat.o(109288);
      return;
      lB(false);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109289);
    g.aAg().hqi.b(830, this);
    g.aAg().hqi.b(822, this);
    if ((this.rlk != null) && (this.rlk.isRunning())) {
      this.rlk.stop();
    }
    com.tencent.mm.av.q.bcV().a(null, this.rlo);
    this.rlE.rbC = null;
    this.rlE = null;
    super.onDestroy();
    AppMethodBeat.o(109289);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(109294);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramAdapterView);
    localb.bm(paramView);
    localb.pH(paramInt);
    localb.zo(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
    if (this.rlv != null)
    {
      paramAdapterView = this.rlv.Gc(paramInt);
      if (paramAdapterView != null)
      {
        Log.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "onItemClick position:%d", new Object[] { Integer.valueOf(paramInt) });
        a(this.rcq, paramAdapterView);
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(109294);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(109296);
    if ((this.jZH != null) && (this.jZH.isShowing())) {
      this.jZH.dismiss();
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
        boolean bool = ((com.tencent.mm.pluginsdk.wallet.a)g.af(com.tencent.mm.pluginsdk.wallet.a.class)).isSwitch2InWxAppPay(((com.tencent.mm.plugin.emoji.f.b)localObject).cGp().KKR);
        Log.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "doEmojiReward, isSwitch2InWxAppPay:%b", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          ((com.tencent.mm.pluginsdk.wallet.a)g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startInWxAppPayUseCase(this, ((com.tencent.mm.plugin.emoji.f.b)localObject).cGp().KKR, "", "", 5, 0);
          AppMethodBeat.o(109296);
          return;
        }
        paramString = new Bundle();
        paramString.putBoolean("extinfo_key_10", true);
        paramq = getContext();
        String str = ((com.tencent.mm.plugin.emoji.f.b)localObject).cGp().KKR;
        localObject = ((com.tencent.mm.plugin.emoji.f.b)localObject).cGp().hik;
        if (!Util.isNullOrNil(str))
        {
          localObject = f.ap(str, (String)localObject, 5);
          ((PayInfo)localObject).iqp = paramString;
          f.a(paramq, (PayInfo)localObject, 8001);
        }
        AppMethodBeat.o(109296);
        return;
      }
      if (paramInt1 == 4)
      {
        if (!this.rlA)
        {
          this.rlA = true;
          com.tencent.mm.plugin.report.service.h.CyF.a(12738, new Object[] { this.rcq, Integer.valueOf(this.rln), Integer.valueOf(this.rbG), Integer.valueOf(2) });
        }
        if (paramInt2 == com.tencent.mm.plugin.emoji.f.b.rcn)
        {
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(408L, 6L, 1L, false);
          if (Util.isNullOrNil(paramString))
          {
            amW(getString(2131758652));
            AppMethodBeat.o(109296);
            return;
          }
          amW(paramString);
          AppMethodBeat.o(109296);
          return;
        }
        if (paramInt2 == com.tencent.mm.plugin.emoji.f.b.rco)
        {
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(408L, 7L, 1L, false);
          if (Util.isNullOrNil(paramString))
          {
            amW(getString(2131758654));
            AppMethodBeat.o(109296);
            return;
          }
          amW(paramString);
          AppMethodBeat.o(109296);
          return;
        }
        if (paramInt2 == com.tencent.mm.plugin.emoji.f.b.rcp)
        {
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(408L, 5L, 1L, false);
          if (Util.isNullOrNil(paramString))
          {
            amW(getString(2131758653));
            AppMethodBeat.o(109296);
            return;
          }
          amW(paramString);
          AppMethodBeat.o(109296);
          return;
        }
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(408L, 8L, 1L, false);
        Toast.makeText(this, getString(2131758604), 0).show();
        AppMethodBeat.o(109296);
        return;
      }
      if (!this.rlA)
      {
        this.rlA = true;
        com.tencent.mm.plugin.report.service.h.CyF.a(12738, new Object[] { this.rcq, Integer.valueOf(this.rln), Integer.valueOf(this.rbG), Integer.valueOf(2) });
      }
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(408L, 8L, 1L, false);
      Toast.makeText(this, getString(2131758604), 0).show();
      AppMethodBeat.o(109296);
      return;
    } while (!(paramq instanceof p));
    paramString = (p)paramq;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "update emotion reward success.");
      this.rhu = paramString.cGz();
      com.tencent.mm.av.q.bcV().a(this.rhu.Reward.LsM, null, e.k(this.rcq, this.rhu.Reward.LsM, new Object[0]));
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
    private LinkedList<EmotionPrice> rld;
    
    b() {}
    
    public final EmotionPrice Gc(int paramInt)
    {
      AppMethodBeat.i(109283);
      if ((paramInt < 0) || (paramInt > getCount()))
      {
        AppMethodBeat.o(109283);
        return null;
      }
      if (this.rld == null)
      {
        AppMethodBeat.o(109283);
        return null;
      }
      EmotionPrice localEmotionPrice = (EmotionPrice)this.rld.get(paramInt);
      AppMethodBeat.o(109283);
      return localEmotionPrice;
    }
    
    public final void Z(LinkedList<EmotionPrice> paramLinkedList)
    {
      AppMethodBeat.i(109281);
      if (this.rld == null) {
        this.rld = new LinkedList();
      }
      this.rld.clear();
      this.rld.addAll(paramLinkedList);
      notifyDataSetChanged();
      AppMethodBeat.o(109281);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(109282);
      if (this.rld == null)
      {
        AppMethodBeat.o(109282);
        return 0;
      }
      int i = this.rld.size();
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
        paramView = aa.jQ(EmojiStoreV2RewardUI.this.getContext()).inflate(2131493974, null);
        paramViewGroup = new EmojiStoreV2RewardUI.c(EmojiStoreV2RewardUI.this, paramView);
        paramView.setTag(paramViewGroup);
        EmotionPrice localEmotionPrice = Gc(paramInt);
        if (localEmotionPrice == null) {
          break label122;
        }
        paramViewGroup.rlJ.setVisibility(0);
        paramViewGroup.rlJ.setText(localEmotionPrice.Number + localEmotionPrice.Label);
      }
      for (;;)
      {
        AppMethodBeat.o(109284);
        return paramView;
        paramViewGroup = (EmojiStoreV2RewardUI.c)paramView.getTag();
        break;
        label122:
        paramViewGroup.rlJ.setVisibility(8);
      }
    }
  }
  
  final class c
  {
    TextView rlJ;
    
    public c(View paramView)
    {
      AppMethodBeat.i(109286);
      this.rlJ = ((TextView)paramView.findViewById(2131306125));
      AppMethodBeat.o(109286);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI
 * JD-Core Version:    0.7.0.1
 */