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
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.ui.GridInScrollView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.EmotionPrice;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.protocal.protobuf.aee;
import com.tencent.mm.protocal.protobuf.gn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.z;
import java.util.LinkedList;

public class EmojiStoreV2RewardUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, com.tencent.mm.ak.g
{
  private ProgressDialog iFC;
  private ao mHandler;
  private String pbJ;
  private int pba;
  private String pbg;
  private Button pgN;
  private GetEmotionRewardResponse pgo;
  private com.tencent.mm.plugin.emoji.model.i pkA;
  private AnimationDrawable pkg;
  private int pkj;
  private EmojiStoreV2RewardBannerView pkk;
  private GridInScrollView pkl;
  private View pkm;
  private View pkn;
  private MMFormInputView pko;
  private TextView pkp;
  private TextView pkq;
  private b pkr;
  private com.tencent.mm.plugin.emoji.f.b pks;
  private String pkt;
  private String pku;
  private EmojiStoreV2RewardUI.a pkv;
  private boolean pkw;
  private View.OnClickListener pkx;
  private View.OnClickListener pky;
  private TextWatcher pkz;
  
  public EmojiStoreV2RewardUI()
  {
    AppMethodBeat.i(109287);
    this.pkv = EmojiStoreV2RewardUI.a.pkC;
    this.pkw = false;
    this.mHandler = new ao()
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
          if ((!bs.isNullOrNil(paramAnonymousMessage)) && (com.tencent.mm.vfs.i.eA(paramAnonymousMessage)))
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
            ac.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "path is null or file no exists");
            AppMethodBeat.o(109270);
            return;
            EmojiStoreV2RewardUI.c(EmojiStoreV2RewardUI.this);
          }
        }
      }
    };
    this.pkx = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109271);
        if (EmojiStoreV2RewardUI.d(EmojiStoreV2RewardUI.this) != null)
        {
          paramAnonymousView = EmojiStoreV2RewardUI.d(EmojiStoreV2RewardUI.this).Bx(0);
          if (EmojiStoreV2RewardUI.e(EmojiStoreV2RewardUI.this).getText() != null)
          {
            paramAnonymousView.Number = EmojiStoreV2RewardUI.e(EmojiStoreV2RewardUI.this).getText().toString();
            EmojiStoreV2RewardUI.a(EmojiStoreV2RewardUI.this, EmojiStoreV2RewardUI.f(EmojiStoreV2RewardUI.this), paramAnonymousView);
            AppMethodBeat.o(109271);
            return;
          }
          ac.w("MicroMsg.emoji.EmojiStoreV2RewardUI", "mRewardInputView is null");
          AppMethodBeat.o(109271);
          return;
        }
        ac.w("MicroMsg.emoji.EmojiStoreV2RewardUI", "mAdapter is null.");
        AppMethodBeat.o(109271);
      }
    };
    this.pky = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109272);
        if (EmojiStoreV2RewardUI.g(EmojiStoreV2RewardUI.this) == EmojiStoreV2RewardUI.a.pkC) {
          EmojiStoreV2RewardUI.a(EmojiStoreV2RewardUI.this, EmojiStoreV2RewardUI.a.pkD);
        }
        AppMethodBeat.o(109272);
      }
    };
    this.pkz = new TextWatcher()
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
    this.pkA = new com.tencent.mm.plugin.emoji.model.i(new com.tencent.mm.av.a.c.k()
    {
      public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(109274);
        if ((!bs.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equalsIgnoreCase(EmojiStoreV2RewardUI.i(EmojiStoreV2RewardUI.this))))
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
  
  private void Ys(String paramString)
  {
    AppMethodBeat.i(109299);
    com.tencent.mm.ui.base.h.a(getContext(), paramString, null, getString(2131758304), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(109299);
  }
  
  private void a(EmojiStoreV2RewardUI.a parama)
  {
    AppMethodBeat.i(109291);
    if (parama == EmojiStoreV2RewardUI.a.pkD)
    {
      this.pkv = EmojiStoreV2RewardUI.a.pkD;
      if (this.pkn != null)
      {
        this.pkn.setVisibility(0);
        this.pkn.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772095));
        this.pko.getContentEditText().requestFocus();
        showVKB();
        this.pkm.setVisibility(8);
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
    aOL();
    this.pks = new com.tencent.mm.plugin.emoji.f.b(paramString, paramEmotionPrice);
    com.tencent.mm.kernel.g.agQ().ghe.a(this.pks, 0);
    AppMethodBeat.o(109297);
  }
  
  private void aOL()
  {
    AppMethodBeat.i(109298);
    getString(2131755906);
    this.iFC = com.tencent.mm.ui.base.h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(109277);
        com.tencent.mm.kernel.g.agQ().ghe.a(EmojiStoreV2RewardUI.m(EmojiStoreV2RewardUI.this));
        AppMethodBeat.o(109277);
      }
    });
    AppMethodBeat.o(109298);
  }
  
  private void cL()
  {
    AppMethodBeat.i(109293);
    if (this.pgo != null)
    {
      this.pkp.setVisibility(0);
      this.pkq.setVisibility(0);
      if ((this.pgo.Reward != null) && (!bs.isNullOrNil(this.pgo.Reward.EwU)))
      {
        this.pkt = this.pgo.Reward.EwU;
        com.tencent.mm.emoji.d.a locala = com.tencent.mm.emoji.d.a.fWM;
        this.pku = EmojiLogic.j(com.tencent.mm.emoji.d.a.adJ(), this.pbJ, this.pkt);
        if (com.tencent.mm.vfs.i.eA(this.pku))
        {
          this.pkk.setImageFilePath(this.pku);
          this.pkk.setScaleType(ImageView.ScaleType.FIT_XY);
          if ((this.pkg != null) && (this.pkg.isRunning())) {
            this.pkg.stop();
          }
        }
      }
    }
    while ((this.pgo != null) && (this.pgo.Price != null))
    {
      this.pkl.setVisibility(0);
      this.pkr.X(this.pgo.Price);
      AppMethodBeat.o(109293);
      return;
      com.tencent.mm.av.o.aFB().a(this.pkt, this.pkk, e.j(this.pbJ, this.pkt, new Object[0]), this.pkA);
      this.pkk.setBackgroundDrawable(getResources().getDrawable(2131232083));
      this.pkk.setImageDrawable(this.pkg);
      this.pkk.setScaleType(ImageView.ScaleType.CENTER);
      this.pkg.start();
      continue;
      this.pkk.setBackgroundDrawable(getResources().getDrawable(2131232083));
      this.pkk.setImageDrawable(this.pkg);
      this.pkk.setScaleType(ImageView.ScaleType.CENTER);
      this.pkg.start();
      continue;
      this.pkp.setVisibility(8);
      this.pkq.setVisibility(8);
    }
    this.pkl.setVisibility(8);
    AppMethodBeat.o(109293);
  }
  
  private void kp(boolean paramBoolean)
  {
    AppMethodBeat.i(109300);
    ac.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "doGetRewardScene");
    if (paramBoolean)
    {
      localo = new com.tencent.mm.plugin.emoji.f.o(this.pbJ, com.tencent.mm.plugin.emoji.f.o.pcw);
      com.tencent.mm.kernel.g.agQ().ghe.a(localo, 0);
      AppMethodBeat.o(109300);
      return;
    }
    com.tencent.mm.plugin.emoji.f.o localo = new com.tencent.mm.plugin.emoji.f.o(this.pbJ, com.tencent.mm.plugin.emoji.f.o.pcx);
    com.tencent.mm.kernel.g.agQ().ghe.a(localo, 0);
    aOL();
    AppMethodBeat.o(109300);
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
    if (bs.isNullOrNil(this.pbg)) {
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
      this.pkm = findViewById(2131304159);
      this.pkn = findViewById(2131304160);
      this.pko = ((MMFormInputView)findViewById(2131304161));
      this.pgN = ((Button)findViewById(2131304162));
      this.pgN.setOnClickListener(this.pkx);
      this.pgN.setEnabled(false);
      this.pko.setInputType(8194);
      this.pko.addTextChangedListener(this.pkz);
      this.pko.getContentEditText().setFilters(new InputFilter[] { new InputFilter.LengthFilter(12) });
      this.pkp = ((TextView)findViewById(2131304157));
      this.pkp.setOnClickListener(this.pky);
      this.pkq = ((TextView)findViewById(2131304155));
      this.pkk = ((EmojiStoreV2RewardBannerView)findViewById(2131297198));
      this.pkl = ((GridInScrollView)findViewById(16908298));
      this.pkr = new b();
      this.pkl.setAdapter(this.pkr);
      this.pkl.setOnItemClickListener(this);
      this.pkg = ((AnimationDrawable)getResources().getDrawable(2131232019));
      AppMethodBeat.o(109292);
      return;
      setMMTitle(getString(2131758371, new Object[] { this.pbg }));
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
        paramIntent.putExtra("extra_id", this.pbJ);
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.aeD(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI", "startThanksUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramIntent.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI", "startThanksUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.h.wUl.f(12738, new Object[] { this.pbJ, Integer.valueOf(this.pkj), Integer.valueOf(this.pba), Integer.valueOf(1) });
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(408L, 9L, 1L, false);
        kp(true);
        finish();
        AppMethodBeat.o(109295);
        return;
      }
      if (paramInt2 == 0)
      {
        com.tencent.mm.plugin.report.service.h.wUl.f(12738, new Object[] { this.pbJ, Integer.valueOf(this.pkj), Integer.valueOf(this.pba), Integer.valueOf(3) });
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(408L, 3L, 1L, false);
        AppMethodBeat.o(109295);
        return;
      }
      if (!this.pkw)
      {
        this.pkw = true;
        com.tencent.mm.plugin.report.service.h.wUl.f(12738, new Object[] { this.pbJ, Integer.valueOf(this.pkj), Integer.valueOf(this.pba), Integer.valueOf(2) });
      }
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(408L, 4L, 1L, false);
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(109290);
    ac.i("MicroMsg.emoji.EmojiStoreV2RewardUI", keyboardState());
    if (this.pkv == EmojiStoreV2RewardUI.a.pkC)
    {
      if (this.pkw) {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(408L, 2L, 1L, false);
      }
      for (;;)
      {
        super.onBackPressed();
        AppMethodBeat.o(109290);
        return;
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(408L, 1L, 1L, false);
        com.tencent.mm.plugin.report.service.h.wUl.f(12738, new Object[] { this.pbJ, Integer.valueOf(this.pkj), Integer.valueOf(this.pba), Integer.valueOf(4) });
      }
    }
    a(EmojiStoreV2RewardUI.a.pkC);
    AppMethodBeat.o(109290);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109288);
    super.onCreate(paramBundle);
    this.pbJ = getIntent().getStringExtra("extra_id");
    this.pbg = getIntent().getStringExtra("name");
    this.pba = getIntent().getIntExtra("scene", 0);
    this.pkj = getIntent().getIntExtra("pageType", 0);
    initView();
    this.pgo = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GYe.aPd(this.pbJ);
    if ((this.pgo != null) && (this.pgo.Reward != null))
    {
      com.tencent.mm.av.o.aFB().a(this.pgo.Reward.EwV, null, e.j(this.pbJ, this.pgo.Reward.EwV, new Object[0]));
      com.tencent.mm.av.o.aFB().a(this.pgo.Reward.EwW, null, e.j(this.pbJ, this.pgo.Reward.EwW, new Object[0]));
    }
    for (;;)
    {
      cL();
      com.tencent.mm.kernel.g.agQ().ghe.a(830, this);
      com.tencent.mm.kernel.g.agQ().ghe.a(822, this);
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(408L, 0L, 1L, false);
      AppMethodBeat.o(109288);
      return;
      kp(false);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109289);
    com.tencent.mm.kernel.g.agQ().ghe.b(830, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(822, this);
    if ((this.pkg != null) && (this.pkg.isRunning())) {
      this.pkg.stop();
    }
    com.tencent.mm.av.o.aFB().a(null, this.pkk);
    this.pkA.paW = null;
    this.pkA = null;
    super.onDestroy();
    AppMethodBeat.o(109289);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(109294);
    if (this.pkr != null)
    {
      paramAdapterView = this.pkr.Bx(paramInt);
      if (paramAdapterView != null)
      {
        ac.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "onItemClick position:%d", new Object[] { Integer.valueOf(paramInt) });
        a(this.pbJ, paramAdapterView);
      }
    }
    AppMethodBeat.o(109294);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(109296);
    if ((this.iFC != null) && (this.iFC.isShowing())) {
      this.iFC.dismiss();
    }
    int i = paramn.getType();
    switch (i)
    {
    default: 
      ac.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "unknown scene. type:%d", new Object[] { Integer.valueOf(i) });
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
        String str = ((com.tencent.mm.plugin.emoji.f.b)localObject).ccw().DTt;
        localObject = ((com.tencent.mm.plugin.emoji.f.b)localObject).ccw().fZx;
        if (!bs.isNullOrNil(str))
        {
          localObject = f.af(str, (String)localObject, 5);
          ((PayInfo)localObject).hbR = paramString;
          f.a(paramn, (PayInfo)localObject, 8001);
        }
        AppMethodBeat.o(109296);
        return;
      }
      if (paramInt1 == 4)
      {
        if (!this.pkw)
        {
          this.pkw = true;
          com.tencent.mm.plugin.report.service.h.wUl.f(12738, new Object[] { this.pbJ, Integer.valueOf(this.pkj), Integer.valueOf(this.pba), Integer.valueOf(2) });
        }
        if (paramInt2 == com.tencent.mm.plugin.emoji.f.b.pbG)
        {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(408L, 6L, 1L, false);
          if (bs.isNullOrNil(paramString))
          {
            Ys(getString(2131758358));
            AppMethodBeat.o(109296);
            return;
          }
          Ys(paramString);
          AppMethodBeat.o(109296);
          return;
        }
        if (paramInt2 == com.tencent.mm.plugin.emoji.f.b.pbH)
        {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(408L, 7L, 1L, false);
          if (bs.isNullOrNil(paramString))
          {
            Ys(getString(2131758360));
            AppMethodBeat.o(109296);
            return;
          }
          Ys(paramString);
          AppMethodBeat.o(109296);
          return;
        }
        if (paramInt2 == com.tencent.mm.plugin.emoji.f.b.pbI)
        {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(408L, 5L, 1L, false);
          if (bs.isNullOrNil(paramString))
          {
            Ys(getString(2131758359));
            AppMethodBeat.o(109296);
            return;
          }
          Ys(paramString);
          AppMethodBeat.o(109296);
          return;
        }
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(408L, 8L, 1L, false);
        Toast.makeText(this, getString(2131758310), 0).show();
        AppMethodBeat.o(109296);
        return;
      }
      if (!this.pkw)
      {
        this.pkw = true;
        com.tencent.mm.plugin.report.service.h.wUl.f(12738, new Object[] { this.pbJ, Integer.valueOf(this.pkj), Integer.valueOf(this.pba), Integer.valueOf(2) });
      }
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(408L, 8L, 1L, false);
      Toast.makeText(this, getString(2131758310), 0).show();
      AppMethodBeat.o(109296);
      return;
    } while (!(paramn instanceof com.tencent.mm.plugin.emoji.f.o));
    paramString = (com.tencent.mm.plugin.emoji.f.o)paramn;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ac.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "update emotion reward success.");
      this.pgo = paramString.ccH();
      com.tencent.mm.av.o.aFB().a(this.pgo.Reward.EwV, null, e.j(this.pbJ, this.pgo.Reward.EwV, new Object[0]));
      this.mHandler.sendEmptyMessage(1002);
      AppMethodBeat.o(109296);
      return;
    }
    ac.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "update emotion reward failed.");
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
    private LinkedList<EmotionPrice> pjZ;
    
    b() {}
    
    public final EmotionPrice Bx(int paramInt)
    {
      AppMethodBeat.i(109283);
      if ((paramInt < 0) || (paramInt > getCount()))
      {
        AppMethodBeat.o(109283);
        return null;
      }
      if (this.pjZ == null)
      {
        AppMethodBeat.o(109283);
        return null;
      }
      EmotionPrice localEmotionPrice = (EmotionPrice)this.pjZ.get(paramInt);
      AppMethodBeat.o(109283);
      return localEmotionPrice;
    }
    
    public final void X(LinkedList<EmotionPrice> paramLinkedList)
    {
      AppMethodBeat.i(109281);
      if (this.pjZ == null) {
        this.pjZ = new LinkedList();
      }
      this.pjZ.clear();
      this.pjZ.addAll(paramLinkedList);
      notifyDataSetChanged();
      AppMethodBeat.o(109281);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(109282);
      if (this.pjZ == null)
      {
        AppMethodBeat.o(109282);
        return 0;
      }
      int i = this.pjZ.size();
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
        paramView = z.jD(EmojiStoreV2RewardUI.this.getContext()).inflate(2131493820, null);
        paramViewGroup = new EmojiStoreV2RewardUI.c(EmojiStoreV2RewardUI.this, paramView);
        paramView.setTag(paramViewGroup);
        EmotionPrice localEmotionPrice = Bx(paramInt);
        if (localEmotionPrice == null) {
          break label122;
        }
        paramViewGroup.pkF.setVisibility(0);
        paramViewGroup.pkF.setText(localEmotionPrice.Number + localEmotionPrice.Label);
      }
      for (;;)
      {
        AppMethodBeat.o(109284);
        return paramView;
        paramViewGroup = (EmojiStoreV2RewardUI.c)paramView.getTag();
        break;
        label122:
        paramViewGroup.pkF.setVisibility(8);
      }
    }
  }
  
  final class c
  {
    TextView pkF;
    
    public c(View paramView)
    {
      AppMethodBeat.i(109286);
      this.pkF = ((TextView)paramView.findViewById(2131303404));
      AppMethodBeat.o(109286);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI
 * JD-Core Version:    0.7.0.1
 */