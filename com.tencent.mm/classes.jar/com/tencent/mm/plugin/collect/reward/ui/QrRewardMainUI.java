package com.tencent.mm.plugin.collect.reward.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ak.c;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.h;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.np;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class QrRewardMainUI
  extends QrRewardBaseUI
{
  private String cdi;
  private String desc;
  private String fGC;
  private final int iIM = com.tencent.mm.cb.a.fromDPToPix(this.mController.uMN, 200);
  private Button iIN;
  private ViewGroup iIO;
  private ViewGroup iIP;
  private RelativeLayout iIQ;
  private CdnImageView iIR;
  private ImageView iIS;
  private ImageView iIT;
  private MMEditText iIU;
  private TextView iIV;
  private TextView iIW;
  private TextView iIX;
  private TextView iIY;
  private ScrollView iIZ;
  private String iJa;
  private String iJb;
  private String iJc;
  private int iJd;
  private int iJe;
  private boolean iJf;
  private boolean iJg;
  private boolean mIsOpen = false;
  private String username;
  
  private void aEJ()
  {
    if (com.tencent.mm.plugin.collect.reward.b.a.aEF().aEG())
    {
      CdnImageView localCdnImageView = this.iIR;
      com.tencent.mm.plugin.collect.reward.b.a locala = com.tencent.mm.plugin.collect.reward.b.a.aEF();
      localCdnImageView.ah(com.tencent.mm.plugin.collect.reward.b.a.iIi + locala.aEH(), this.iIM, this.iIM);
      this.iIQ.setVisibility(0);
      return;
    }
    this.iIQ.setVisibility(4);
  }
  
  private void aEK()
  {
    int j = Math.round(this.iIM * (this.iJe * 1.0F / this.iJd));
    int i = j;
    if (j <= 0) {
      i = 248;
    }
    ViewGroup.LayoutParams localLayoutParams = this.iIT.getLayoutParams();
    localLayoutParams.width = i;
    localLayoutParams.height = i;
    this.iIT.setLayoutParams(localLayoutParams);
    localLayoutParams = this.iIS.getLayoutParams();
    localLayoutParams.width = i;
    localLayoutParams.height = i;
    this.iIS.setLayoutParams(localLayoutParams);
    localLayoutParams = this.iIU.getLayoutParams();
    localLayoutParams.width = (i - 30);
    localLayoutParams.height = (i - 30);
    this.iIU.setLayoutParams(localLayoutParams);
    this.iIU.setTextSize(0, i * 2 / 3);
    this.iIP.requestLayout();
    if (!bk.bl(this.desc)) {
      this.iIV.setText(j.a(this, getString(a.i.qr_reward_wrap_text, new Object[] { this.desc }), this.iIV.getTextSize()));
    }
    for (;;)
    {
      eK(bk.bl(this.iJa));
      return;
      this.iIV.setText("");
    }
  }
  
  private void aEL()
  {
    if (!bk.bl(this.iJb))
    {
      this.iIX.setClickable(true);
      this.iIX.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m(this));
      com.tencent.mm.plugin.wallet_core.ui.m localm = new com.tencent.mm.plugin.wallet_core.ui.m(new QrRewardMainUI.7(this));
      SpannableString localSpannableString = new SpannableString(this.iJb);
      localSpannableString.setSpan(localm, 0, localSpannableString.length(), 18);
      this.iIX.setText(localSpannableString);
      this.iIX.setVisibility(0);
      return;
    }
    this.iIX.setVisibility(8);
  }
  
  private void aEM()
  {
    if (!bk.bl(this.iJa))
    {
      this.iIU.setText(j.a(this.mController.uMN, this.iJa, this.iIU.getTextSize()));
      this.iIU.setSelection(this.iJa.length());
    }
  }
  
  private void aEN()
  {
    y.i("MicroMsg.QrRewardMainUI", "do set photo word");
    h localh = new h(this.iJa);
    localh.w(this);
    a(localh, true, false);
  }
  
  private void eK(boolean paramBoolean)
  {
    y.i("MicroMsg.QrRewardMainUI", "switch mode: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.iIS.setVisibility(0);
      this.iIU.setVisibility(4);
      a.b.a(this.iIS, this.username, 0.03F, true);
      return;
    }
    this.iIS.setVisibility(4);
    this.iIU.setVisibility(0);
  }
  
  private void l(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((this.fGC != null) && (this.fGC.equals(paramString1))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = com.tencent.mm.plugin.collect.reward.b.a.aEF().aEG();
      y.i("MicroMsg.QrRewardMainUI", "do download photo: %s, same url: %s, pic exist: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((paramBoolean) || (!bool1) || (!bool2))
      {
        com.tencent.mm.plugin.collect.reward.b.a locala = com.tencent.mm.plugin.collect.reward.b.a.aEF();
        QrRewardMainUI.6 local6 = new QrRewardMainUI.6(this);
        y.i("MicroMsg.QrRewardCdnDownloadHelper", "downloadImage. imageId:%s", new Object[] { paramString1 });
        Object localObject = new File(com.tencent.mm.plugin.collect.reward.b.a.iIi);
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        localObject = new com.tencent.mm.j.f();
        ((com.tencent.mm.j.f)localObject).ceg = false;
        ((com.tencent.mm.j.f)localObject).dlP = locala;
        ((com.tencent.mm.j.f)localObject).field_fullpath = (com.tencent.mm.plugin.collect.reward.b.a.iIi + locala.aEH());
        ((com.tencent.mm.j.f)localObject).field_mediaId = bk.pm(c.a("QrRewardImg", bk.UY(), q.GQ().field_username, ""));
        ((com.tencent.mm.j.f)localObject).field_fileId = paramString1;
        ((com.tencent.mm.j.f)localObject).field_aesKey = paramString2;
        ((com.tencent.mm.j.f)localObject).field_fileType = com.tencent.mm.j.a.MediaType_FILE;
        ((com.tencent.mm.j.f)localObject).field_priority = com.tencent.mm.j.a.dlk;
        ((com.tencent.mm.j.f)localObject).field_needStorage = false;
        ((com.tencent.mm.j.f)localObject).field_isStreamMedia = false;
        ((com.tencent.mm.j.f)localObject).field_appType = 0;
        ((com.tencent.mm.j.f)localObject).field_bzScene = 0;
        if (locala.hLB == null) {
          locala.hLB = new HashMap();
        }
        locala.hLB.put(((com.tencent.mm.j.f)localObject).field_mediaId, local6);
        if (!com.tencent.mm.ak.f.Nd().b((com.tencent.mm.j.f)localObject, -1)) {
          y.e("MicroMsg.QrRewardCdnDownloadHelper", "ljd: cdntra addSendTask failed. imageId:%s", new Object[] { paramString1 });
        }
      }
      return;
    }
  }
  
  protected final boolean VK()
  {
    return false;
  }
  
  public final boolean c(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ah.m paramm)
  {
    if ((paramm instanceof com.tencent.mm.plugin.collect.reward.a.b))
    {
      paramString = (com.tencent.mm.plugin.collect.reward.a.b)paramm;
      paramString.a(new QrRewardMainUI.16(this, paramString)).b(new QrRewardMainUI.15(this, paramString)).c(new QrRewardMainUI.14(this, paramString));
    }
    while (!(paramm instanceof h)) {
      return true;
    }
    paramString = (h)paramm;
    paramString.a(new QrRewardMainUI.3(this, paramString)).b(new a.a()
    {
      public final void i(com.tencent.mm.ah.m paramAnonymousm)
      {
        y.e("MicroMsg.QrRewardMainUI", "set word error: %s, %s", new Object[] { Integer.valueOf(paramString.iIh.iHq), paramString.iIh.iHr });
        QrRewardMainUI.a(QrRewardMainUI.this, (String)g.DP().Dz().get(ac.a.uyd, ""));
        QrRewardMainUI.c(QrRewardMainUI.this, QrRewardMainUI.k(QrRewardMainUI.this));
        QrRewardMainUI.l(QrRewardMainUI.this).setText("");
        QrRewardMainUI.i(QrRewardMainUI.this);
        if (!bk.bl(paramString.iIh.iHr)) {
          Toast.makeText(QrRewardMainUI.this, paramString.iIh.iHr, 0).show();
        }
      }
    }).c(new QrRewardMainUI.17(this));
    this.iIU.clearFocus();
    this.iIU.setCursorVisible(false);
    return true;
  }
  
  protected final int getLayoutId()
  {
    return a.g.qr_reward_main_ui;
  }
  
  protected final void initView()
  {
    this.iIN = ((Button)findViewById(a.f.qrmu_open_reward_btn));
    this.iIO = ((ViewGroup)findViewById(a.f.qrmu_no_code_layout));
    this.iIP = ((ViewGroup)findViewById(a.f.qrmu_main_layout));
    this.iIR = ((CdnImageView)findViewById(a.f.qrmu_code_iv));
    this.iIV = ((TextView)findViewById(a.f.qrmu_desc_tv));
    this.iIS = ((ImageView)findViewById(a.f.qrmu_code_avatar_iv));
    this.iIT = ((ImageView)findViewById(a.f.qrmu_code_avatar_border_iv));
    this.iIQ = ((RelativeLayout)findViewById(a.f.qrmu_code_layout));
    this.iIU = ((MMEditText)findViewById(a.f.qrmu_code_word_et));
    this.iIW = ((TextView)findViewById(a.f.qrmu_save_code_tv));
    this.iIY = ((TextView)findViewById(a.f.qrmu_set_code_tv));
    this.iIX = ((TextView)findViewById(a.f.qrmu_bottom_tv));
    a.b.a(this.iIS, this.username, 0.03F, true);
    try
    {
      this.iIU.setText(j.a(this.mController.uMN, this.iJa, this.iIU.getTextSize()));
      this.iIU.setSelection(this.iJa.length());
      this.iIU.addTextChangedListener(new QrRewardMainUI.1(this));
      this.iIU.setOnEditorActionListener(new QrRewardMainUI.10(this));
      this.iIT.setOnClickListener(new QrRewardMainUI.11(this));
      this.iIW.setClickable(true);
      this.iIW.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m(this));
      com.tencent.mm.plugin.wallet_core.ui.m localm = new com.tencent.mm.plugin.wallet_core.ui.m(new QrRewardMainUI.12(this));
      SpannableString localSpannableString = new SpannableString(getString(a.i.qr_reward_save_code_btn_text));
      localSpannableString.setSpan(localm, 0, localSpannableString.length(), 18);
      this.iIW.setText(localSpannableString);
      this.iIY.setClickable(true);
      this.iIY.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m(this));
      localm = new com.tencent.mm.plugin.wallet_core.ui.m(new QrRewardMainUI.13(this));
      localSpannableString = new SpannableString(getString(a.i.qr_reward_set_money_title));
      localSpannableString.setSpan(localm, 0, localSpannableString.length(), 18);
      this.iIY.setText(localSpannableString);
      aEJ();
      aEK();
      aEM();
      aEL();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.QrRewardMainUI", localException, "", new Object[0]);
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        this.desc = paramIntent.getStringExtra("key_desc");
        this.iJd = paramIntent.getIntExtra("key_photo_width", 900);
        this.iJe = paramIntent.getIntExtra("key_icon_width", 343);
        boolean bool = paramIntent.getBooleanExtra("key_return_from_first", true);
        y.i("MicroMsg.QrRewardMainUI", "return from first: %s", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          this.iIP.setVisibility(0);
          this.iIO.setVisibility(8);
        }
        this.iJg = true;
        aEK();
        String str = paramIntent.getStringExtra("key_photo_url");
        l(str, paramIntent.getStringExtra("key_photo_aeskey"), true);
        this.fGC = str;
      }
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow().getAttributes();
    if (paramBundle.screenBrightness < 0.85F)
    {
      paramBundle.screenBrightness = 0.85F;
      getWindow().setAttributes(paramBundle);
    }
    kh(1323);
    kh(1649);
    this.iJd = ((Integer)g.DP().Dz().get(ac.a.uyb, Integer.valueOf(900))).intValue();
    this.iJe = ((Integer)g.DP().Dz().get(ac.a.uyc, Integer.valueOf(343))).intValue();
    this.desc = ((String)g.DP().Dz().get(ac.a.uye, ""));
    this.iJa = ((String)g.DP().Dz().get(ac.a.uyd, ""));
    this.iJb = ((String)g.DP().Dz().get(ac.a.uyi, ""));
    this.iJc = ((String)g.DP().Dz().get(ac.a.uyj, ""));
    this.fGC = ((String)g.DP().Dz().get(ac.a.uyk, ""));
    if (!bk.bl((String)g.DP().Dz().get(ac.a.uyh, ""))) {
      this.iJg = true;
    }
    this.username = q.Gj();
    setMMTitle(a.i.qr_reward_main_title);
    initView();
    if ((com.tencent.mm.plugin.collect.reward.b.a.aEF().aEG()) && (this.iJg)) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.QrRewardMainUI", "do get code: %s", new Object[] { Boolean.valueOf(bool) });
      paramBundle = new com.tencent.mm.plugin.collect.reward.a.b(bool);
      paramBundle.w(this);
      if (!bool) {
        break;
      }
      a(paramBundle, false, false);
      return;
    }
    a(paramBundle, true, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ki(1323);
    ki(1649);
    com.tencent.mm.plugin.collect.reward.b.a locala = com.tencent.mm.plugin.collect.reward.b.a.aEF();
    y.d("MicroMsg.QrRewardCdnDownloadHelper", "do clear callback");
    if (locala.hLB != null)
    {
      y.i("MicroMsg.QrRewardCdnDownloadHelper", "callback size: %s", new Object[] { Integer.valueOf(locala.hLB.size()) });
      locala.hLB.clear();
    }
  }
  
  public final void onKeyboardStateChanged()
  {
    super.onKeyboardStateChanged();
    y.i("MicroMsg.QrRewardMainUI", "key board changed: %s", new Object[] { Integer.valueOf(this.mController.uNh) });
    if (this.mController.uNh == 2)
    {
      this.iJa = this.iIU.getText().toString();
      aEN();
      if (bk.bl(this.iJa)) {
        eK(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI
 * JD-Core Version:    0.7.0.1
 */