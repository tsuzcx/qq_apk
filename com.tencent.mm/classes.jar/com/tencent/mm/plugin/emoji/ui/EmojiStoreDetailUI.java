package com.tencent.mm.plugin.emoji.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.as.a.c.j;
import com.tencent.mm.as.o;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.emoji.e.j.1;
import com.tencent.mm.plugin.emoji.f.b;
import com.tencent.mm.plugin.emoji.f.c;
import com.tencent.mm.plugin.emoji.f.d;
import com.tencent.mm.plugin.emoji.f.e;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.ui.v2.DonorsAvatarView;
import com.tencent.mm.pluginsdk.model.h.a;
import com.tencent.mm.pluginsdk.ui.emoji.BannerEmojiView;
import com.tencent.mm.protocal.c.afc;
import com.tencent.mm.protocal.c.afk;
import com.tencent.mm.protocal.c.bcq;
import com.tencent.mm.protocal.c.bel;
import com.tencent.mm.protocal.c.vj;
import com.tencent.mm.protocal.c.vm;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoSizeTextView;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.LinkedList;

public class EmojiStoreDetailUI
  extends MMActivity
  implements View.OnClickListener, f, j.a
{
  private int dsI;
  private ProgressDialog faz;
  private View hrf;
  private ProgressBar iUH;
  private long iYu = 0L;
  private String iYv = "";
  private com.tencent.mm.plugin.emoji.h.c iYy;
  private String iZD;
  private String iZE;
  private String iZF;
  private int jbA;
  private com.tencent.mm.sdk.b.c jbE = new EmojiStoreDetailUI.1(this);
  private vj jbS = new vj();
  private String jbT = "";
  private int jdD;
  private String jdE;
  private boolean jdF;
  private boolean jdG = false;
  private int jdH = -1;
  private com.tencent.mm.plugin.emoji.f.m jdI;
  private com.tencent.mm.plugin.emoji.f.h jdJ;
  private com.tencent.mm.plugin.emoji.f.p jdK;
  private EmojiStoreDetailUI.a jdL;
  private afk jdM = null;
  private boolean jdN;
  private TextView jdO;
  private View jdP;
  private EmojiDetailScrollView jdQ;
  private BannerEmojiView jdR;
  private TextView jdS;
  private MMAutoSizeTextView jdT;
  private TextView jdU;
  private TextView jdV;
  private TextView jdW;
  private EmojiDetailGridView jdX;
  private ImageView jdY;
  private View jdZ;
  private afc jeA;
  private boolean jeB = false;
  private boolean jeC = true;
  private View.OnClickListener jeD = new EmojiStoreDetailUI.12(this);
  private View.OnClickListener jeE = new EmojiStoreDetailUI.16(this);
  private View.OnClickListener jeF = new EmojiStoreDetailUI.17(this);
  private View.OnClickListener jeG = new EmojiStoreDetailUI.18(this);
  private com.tencent.mm.as.a.c.i jeH = new EmojiStoreDetailUI.20(this);
  private j jeI = new EmojiStoreDetailUI.21(this);
  private h.a jeJ = new EmojiStoreDetailUI.15(this);
  private TextView jea;
  private TextView jeb;
  private int jec;
  private View jed;
  private ProgressBar jee;
  private View jef;
  private ImageView jeg;
  private TextView jeh;
  private View jei;
  private View jej;
  private TextView jek;
  private Button jel;
  private DonorsAvatarView jem;
  private TextView jen;
  private int jeo;
  private int jep;
  private int jeq;
  private String jer;
  private boolean jes;
  private int jet;
  private int jeu = -1;
  private String jev;
  private String[] jew = new String[1];
  private boolean jex = false;
  private View jey;
  private boolean jez = true;
  private Context mContext;
  private ah mHandler = new EmojiStoreDetailUI.19(this);
  private int mNumColumns;
  private int xL;
  
  private void AR(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(f.h.emoji_play_failed);
    }
    com.tencent.mm.ui.base.h.a(this, str, "", new EmojiStoreDetailUI.4(this));
  }
  
  private void aJd()
  {
    this.hrf.setVisibility(0);
    this.jdP.setVisibility(8);
    this.jdQ.setVisibility(8);
    this.jdO.setText(f.h.emoji_no_find);
  }
  
  private void aJe()
  {
    y.i("MicroMsg.emoji.EmojiStoreDetailUI", "[handleLoadDataFailed]");
    if ((this.jbS == null) || (this.jbS.sSh == 0))
    {
      this.hrf.setVisibility(0);
      this.jdP.setVisibility(8);
    }
  }
  
  private void aJf()
  {
    this.jdM = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().uBg.acJ(this.iZD);
  }
  
  private void aJg()
  {
    if ((com.tencent.mm.plugin.emoji.a.a.e.cC(this.jbS.sSh, 64)) && (com.tencent.mm.plugin.emoji.e.l.aHz()))
    {
      this.jdK = new com.tencent.mm.plugin.emoji.f.p(this.iZD, com.tencent.mm.plugin.emoji.f.p.jab);
      g.DO().dJT.a(this.jdK, 0);
    }
  }
  
  private boolean aJh()
  {
    boolean bool = com.tencent.mm.plugin.emoji.h.a.aJh();
    this.jdN = bool;
    if (bool) {}
    for (int i = 7;; i = 3)
    {
      this.jdH = i;
      return bool;
    }
  }
  
  private void aJi()
  {
    if (!bk.bl(this.jbS.sSc)) {
      setMMTitle(this.jbS.sSc);
    }
    y.d("MicroMsg.emoji.EmojiStoreDetailUI", "mData.PanelUrl:%s", new Object[] { this.jbS.sSp });
    this.jdP.setVisibility(0);
    this.hrf.setVisibility(8);
    ff(true);
    this.jdT.setText(this.jbS.sSc);
    this.jdU.setText(this.jbS.sSm);
    this.jdW.setText(this.jbS.sSd);
    label208:
    label493:
    LinearLayout.LayoutParams localLayoutParams1;
    if (com.tencent.mm.plugin.emoji.a.a.e.cC(this.jbS.sSg, 1))
    {
      this.jdS.setVisibility(8);
      aJk();
      aJl();
      aJm();
      if ((com.tencent.mm.plugin.emoji.h.a.Bh(this.iZD)) || ((this.jbS.sSs != null) && (this.jbS.sSs.size() > 0) && (((bcq)this.jbS.sSs.get(0)).txX != null))) {
        break label650;
      }
      this.jey.setVisibility(8);
      this.jdX.setProductId(this.iZD);
      if (this.jdL != null) {
        this.jdL.notifyDataSetInvalidated();
      }
      y.d("MicroMsg.emoji.EmojiStoreDetailUI", "mData.PackFlag:%s", new Object[] { this.jbS.sSh });
      if ((this.jbS.sSh & 0x10) == 16) {
        addIconOptionMenu(0, f.g.ofm_send_icon, new EmojiStoreDetailUI.7(this));
      }
      this.jdT.setMaxWidth(this.jec - this.jed.getWidth() - com.tencent.mm.cb.a.aa(this.mController.uMN, f.c.NormalPadding) * 2 - this.jdS.getWidth() - com.tencent.mm.cb.a.aa(this.mController.uMN, f.c.ListPadding) * 2);
      this.jdT.setVisibility(8);
      this.jdT.setVisibility(0);
      if ((this.jbS.sSx == null) || (this.jbS.sSx.tcH == 0) || (this.jeq == 6)) {
        break label661;
      }
      this.jei.setVisibility(0);
      this.jef.setVisibility(0);
      o.ON().a(this.jbS.sSx.sSy, this.jeg, com.tencent.mm.plugin.emoji.e.e.cK(this.iZD, this.jbS.sSx.sSy));
      this.jeh.setText(this.jbS.sSx.kRZ);
      this.jef.setOnClickListener(new EmojiStoreDetailUI.6(this));
      if ((this.jbS.sSh & 0x20) != 32) {
        break label682;
      }
      localLayoutParams1 = (LinearLayout.LayoutParams)this.jeb.getLayoutParams();
      LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)this.jea.getLayoutParams();
      this.jeb.setVisibility(0);
      localLayoutParams1.weight = 1.0F;
      localLayoutParams1.gravity = 3;
      localLayoutParams1.leftMargin = com.tencent.mm.cb.a.aa(this.mController.uMN, f.c.NormalPadding);
      this.jeb.setLayoutParams(localLayoutParams1);
      this.jeb.setGravity(3);
      localLayoutParams2.weight = 1.0F;
      localLayoutParams2.gravity = 5;
      localLayoutParams2.rightMargin = com.tencent.mm.cb.a.aa(this.mController.uMN, f.c.NormalPadding);
      this.jea.setLayoutParams(localLayoutParams2);
      this.jea.setGravity(5);
    }
    for (;;)
    {
      aJj();
      return;
      this.jdS.setVisibility(0);
      this.jdS.setText(f.h.emoji_type_gif);
      break;
      label650:
      this.jey.setVisibility(0);
      break label208;
      label661:
      this.jei.setVisibility(8);
      this.jef.setVisibility(8);
      break label493;
      label682:
      localLayoutParams1 = (LinearLayout.LayoutParams)this.jea.getLayoutParams();
      localLayoutParams1.gravity = 17;
      this.jea.setLayoutParams(localLayoutParams1);
      this.jea.setGravity(17);
      this.jeb.setVisibility(8);
    }
  }
  
  private void aJk()
  {
    if (com.tencent.mm.plugin.emoji.a.a.e.cC(this.jbS.sSg, 8))
    {
      this.jep = 0;
      y.i("MicroMsg.emoji.EmojiStoreDetailUI", "PackFlag:%d", new Object[] { Integer.valueOf(this.jbS.sSh) });
      if ((!com.tencent.mm.plugin.emoji.a.a.e.cC(this.jbS.sSh, 8)) || (!com.tencent.mm.plugin.emoji.a.a.e.pU(this.jbS.sSg))) {
        break label152;
      }
      this.jdH = 8;
    }
    for (;;)
    {
      if (this.jdN) {
        this.jdH = 7;
      }
      return;
      if (com.tencent.mm.plugin.emoji.a.a.e.cC(this.jbS.sSg, 4))
      {
        this.jep = 0;
        break;
      }
      if ((!this.jes) && (TextUtils.isEmpty(this.jbS.sSf)))
      {
        this.jep = 0;
        break;
      }
      this.jep = 1;
      break;
      label152:
      if ((com.tencent.mm.plugin.emoji.a.a.e.cC(this.jbS.sSh, 1)) || (com.tencent.mm.plugin.emoji.a.a.e.cC(this.jbS.sSg, 8))) {
        this.jdH = 3;
      } else if (com.tencent.mm.plugin.emoji.a.a.e.pU(this.jbS.sSg)) {
        this.jdH = 0;
      } else if ((!this.jes) && ((TextUtils.isEmpty(this.jbS.sSn)) || (this.jbS.sSn.equals("0")))) {
        this.jdH = 0;
      } else if (this.jes)
      {
        if (TextUtils.isEmpty(this.jev)) {
          this.jdH = this.jet;
        } else {
          this.jdH = 4;
        }
      }
      else {
        this.jdH = 4;
      }
    }
  }
  
  private void aJl()
  {
    for (;;)
    {
      if (com.tencent.mm.plugin.emoji.h.a.Bh(this.iZD)) {
        aJh();
      }
      switch (this.jdH)
      {
      case 1: 
      case 2: 
      case 9: 
      default: 
        y.w("MicroMsg.emoji.EmojiStoreDetailUI", "unknow product status:%d", new Object[] { Integer.valueOf(this.jdH) });
      case 8: 
      case 0: 
      case 4: 
      case 3: 
      case 6: 
      case 7: 
        do
        {
          do
          {
            return;
            this.jee.setVisibility(8);
            this.jdV.setTextColor(getResources().getColorStateList(f.b.emoji_download_finish_color));
            this.jdV.setBackgroundResource(f.d.btn_solid_white);
            this.jdV.setText(f.h.emoji_store_expire);
            this.jdV.setEnabled(false);
            return;
            this.jee.setVisibility(8);
            this.jdV.setTextColor(getResources().getColorStateList(f.b.white_text_color_selector));
            this.jdV.setBackgroundResource(f.d.btn_solid_green);
            this.jdV.setText(f.h.emoji_store_download);
            this.jdV.setEnabled(true);
            return;
            this.jee.setVisibility(8);
            this.jdV.setTextColor(getResources().getColorStateList(f.b.white_text_color_selector));
            this.jdV.setBackgroundResource(f.d.btn_solid_green);
            this.jdV.setEnabled(true);
            if (this.jes)
            {
              if (bk.bl(this.jev))
              {
                this.jdV.setText("");
                return;
              }
              this.jdV.setText(this.jev);
              return;
            }
            this.jdV.setText(this.jbS.sSf);
            this.jdH = 4;
            return;
            this.jee.setVisibility(8);
            this.jdV.setTextColor(getResources().getColorStateList(f.b.white_text_color_selector));
            this.jdV.setBackgroundResource(f.d.btn_solid_green);
            this.jdV.setText(f.h.emoji_store_download);
            this.jdV.setEnabled(true);
            return;
            this.jee.setVisibility(8);
            this.jdV.setEnabled(false);
            this.jdZ.setVisibility(0);
            this.jdY.setVisibility(0);
            this.jdV.setVisibility(4);
          } while (this.jdD == 3);
          return;
          this.jee.setVisibility(8);
          this.jdV.setEnabled(true);
          this.jdV.setBackgroundResource(f.d.btn_solid_green);
          this.jdV.setText(f.h.emoji_store_used_now);
          this.jdZ.setVisibility(8);
          this.iUH.setProgress(0);
          this.jdY.setVisibility(4);
          this.jdV.setVisibility(0);
        } while (this.jdD == 3);
        return;
      case 5: 
        this.jee.setVisibility(8);
        this.jdV.setBackgroundResource(f.d.btn_solid_green);
        this.jdV.setText(f.h.emoji_store_download);
        this.jdV.setEnabled(true);
      case 11: 
        this.jee.setVisibility(0);
        this.jdV.setVisibility(0);
        this.jdV.setBackgroundResource(f.d.white_bigbtn_tips_normal);
        this.jdV.setText("");
        this.jdV.setEnabled(false);
        this.jdZ.setVisibility(8);
        this.iUH.setProgress(0);
        this.jdY.setVisibility(4);
        return;
      case 10: 
      case 12: 
        this.jee.setVisibility(8);
        this.jdV.setVisibility(0);
        this.jdV.setBackgroundResource(f.d.btn_solid_green);
        this.jdV.setText(f.h.emoji_store_play);
        this.jdV.setEnabled(true);
        this.jdZ.setVisibility(8);
        this.iUH.setProgress(0);
        this.jdY.setVisibility(4);
        return;
      }
      aJk();
    }
  }
  
  private void aJm()
  {
    if ((this.jeB) && ((this.jeA == null) || ((this.jeA.tcU & 0x1) != 1)) && ((this.jbS == null) || (!com.tencent.mm.plugin.emoji.a.a.e.cC(this.jbS.sSh, 1))) && (this.jeA != null) && (!TextUtils.isEmpty(this.jeA.tcT)))
    {
      this.jdV.setText(this.jeA.tcT);
      this.jdV.setTextColor(this.mController.uMN.getResources().getColor(f.b.half_alpha_black));
      this.jdV.setBackgroundDrawable(null);
      this.jdV.setEnabled(false);
    }
  }
  
  private void aJn()
  {
    com.tencent.mm.ui.base.h.a(this, f.h.emoji_store_cancle_download_msg, 0, f.h.emoji_store_stop_download, f.h.emoji_store_continue_download, new EmojiStoreDetailUI.8(this), new EmojiStoreDetailUI.9(this));
  }
  
  private void aJo()
  {
    if (com.tencent.mm.plugin.emoji.h.a.Bh(this.iZD))
    {
      com.tencent.mm.plugin.emoji.f.b.aHY();
      com.tencent.mm.plugin.emoji.f.b.aHZ();
      return;
    }
    this.jdJ = new com.tencent.mm.plugin.emoji.f.h(this.iZD, this.iZF, this.iZE);
    g.DO().dJT.a(this.jdJ, 0);
    switch (this.jbA)
    {
    default: 
      return;
    case 9: 
      com.tencent.mm.plugin.report.service.h.nFQ.f(11598, new Object[] { Integer.valueOf(2), this.iZD });
      return;
    case 10: 
      com.tencent.mm.plugin.report.service.h.nFQ.f(11598, new Object[] { Integer.valueOf(1), this.iZD });
      return;
    }
    com.tencent.mm.plugin.report.service.h.nFQ.f(11598, new Object[] { Integer.valueOf(3), this.iZD });
  }
  
  private void ff(boolean paramBoolean)
  {
    Object localObject = null;
    String str;
    if (!bk.bl(this.jbS.sSk))
    {
      if (!paramBoolean) {
        break label93;
      }
      localObject = this.iZD;
      str = this.jbS.sSk;
      com.tencent.mm.cb.a.getDensity(this.mContext);
    }
    for (localObject = EmojiLogic.a((String)localObject, str, this.jeH);; localObject = EmojiLogic.t((String)localObject, 4, str))
    {
      if ((localObject != null) && (this.jdR != null)) {
        this.jdR.setImageFilePath(((EmojiInfo)localObject).cwL());
      }
      if (com.tencent.mm.plugin.emoji.h.a.Bh(this.iZD)) {
        this.jdR.setImageResource(f.d.tuzi_banner);
      }
      return;
      label93:
      localObject = this.iZD;
      str = this.jbS.sSk;
      com.tencent.mm.cb.a.getDensity(this.mContext);
    }
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.l paraml)
  {
    pX(1001);
  }
  
  public final void aJj()
  {
    if ((com.tencent.mm.plugin.emoji.a.a.e.cC(this.jbS.sSh, 64)) && (com.tencent.mm.plugin.emoji.e.l.aHz()))
    {
      if (this.jdM != null)
      {
        this.jej.setVisibility(0);
        this.jel.setText(f.h.emoji_store_reward);
        this.jek.setText(this.jdM.tdo.sSC);
        this.jek.setLongClickable(false);
        if (this.jdM.tcW > 0)
        {
          this.jen.setVisibility(0);
          String str1 = String.valueOf(this.jdM.tcW);
          String str2 = String.format(getString(f.h.emoji_store_reward_info), new Object[] { Integer.valueOf(this.jdM.tcW) });
          SpannableString localSpannableString = new SpannableString(str2);
          int i = str2.indexOf(str1);
          if (i >= 0) {
            localSpannableString.setSpan(new ForegroundColorSpan(getResources().getColor(f.b.emotion_reward_link_color)), i, str1.length() + i, 33);
          }
          this.jen.setText(localSpannableString);
        }
        while ((this.jdM.tcX != null) && (this.jdM.tcX.size() > 0))
        {
          this.jem.setVisibility(0);
          this.jem.c(this.iZD, this.jdM.tcX);
          return;
          this.jen.setVisibility(8);
        }
        this.jem.setVisibility(8);
        return;
      }
      this.jej.setVisibility(8);
      aJg();
      return;
    }
    this.jej.setVisibility(8);
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return f.f.emoji_store_detail;
  }
  
  public final void h(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    y.d("MicroMsg.emoji.EmojiStoreDetailUI", "productId:%s,status:%d, progress:%d, cdnClientID:%s, ", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
    if ((bk.bl(paramString1)) || (!paramString1.equals(this.iZD))) {}
    do
    {
      do
      {
        return;
        if (!TextUtils.isEmpty(paramString2)) {
          this.jer = paramString2;
        }
        if (paramInt1 != -1) {
          break;
        }
      } while (this.jdH == -1);
      this.jdH = -1;
      pX(1003);
      return;
      if (paramInt1 == 7)
      {
        this.jdH = 7;
        pX(1003);
        return;
      }
      if (paramInt1 != 6) {
        break;
      }
    } while ((TextUtils.isEmpty(paramString1)) || (!paramString1.equals(this.iZD)));
    this.jdH = 6;
    this.xL = paramInt2;
    pX(1004);
    return;
    y.w("MicroMsg.emoji.EmojiStoreDetailUI", "[onExchange] do nothing.");
  }
  
  protected final void initView()
  {
    if (!bk.bl(this.iZE)) {
      setMMTitle(this.iZE);
    }
    setBackBtn(new EmojiStoreDetailUI.2(this));
    this.dsI = com.tencent.mm.cb.a.aa(this.mContext, f.c.emoji_detail_item_margin);
    this.jeo = getResources().getDimensionPixelSize(f.c.emoji_detail_item_image_size);
    this.jeo = com.tencent.mm.cb.a.aa(this.mContext, f.c.emoji_detail_item_image_size);
    this.mNumColumns = 4;
    this.jdQ = ((EmojiDetailScrollView)findViewById(f.e.scrollview));
    this.hrf = findViewById(f.e.empty);
    this.jdO = ((TextView)this.hrf.findViewById(f.e.empty_content));
    this.jdP = findViewById(f.e.emoji_store_detail);
    this.jdR = ((BannerEmojiView)findViewById(f.e.emoji_image));
    int i = this.jdR.getRight();
    int j = this.jdR.getLeft();
    int k = this.jdR.getPaddingRight();
    int m = this.jdR.getPaddingLeft();
    this.jdR.setMinimumHeight((int)((i - j - k - m) * 0.56F));
    this.jdS = ((TextView)findViewById(f.e.emoji_tip));
    this.jdT = ((MMAutoSizeTextView)findViewById(f.e.emoji_title));
    this.jdU = ((TextView)findViewById(f.e.emoji_copyright));
    this.jdV = ((TextView)findViewById(f.e.emoji_type));
    this.jdW = ((TextView)findViewById(f.e.emoji_destrition));
    this.jec = com.tencent.mm.cb.a.fj(this.mController.uMN);
    this.jed = findViewById(f.e.emoji_action);
    this.jdX = ((EmojiDetailGridView)findViewById(f.e.emoji_gridview));
    ProgressBar localProgressBar;
    if (com.tencent.mm.plugin.emoji.h.a.Bh(this.iZD))
    {
      this.jdL = new EmojiStoreDetailUI.b(this);
      this.jdZ = findViewById(f.e.emoji_progress);
      this.iUH = ((ProgressBar)findViewById(f.e.emoji_download_progress));
      this.jdY = ((ImageView)findViewById(f.e.emoji_close));
      this.jdY.setOnClickListener(this);
      this.jdZ.setVisibility(8);
      this.jdY.setVisibility(8);
      this.iUH.setProgress(0);
      this.jdX.setAdapter(this.jdL);
      this.jdX.setColumnWidth(this.jeo);
      this.jdX.setNumColumns(this.mNumColumns);
      this.jdX.setHorizontalSpacing(this.dsI);
      this.jdX.setVerticalSpacing(this.dsI);
      this.jdX.setEmojiDetailScrollView(this.jdQ);
      this.jdX.setFromDetail(true);
      this.jdX.setIsShowPopWin(false);
      this.jdX.setOnItemClickListener(new EmojiStoreDetailUI.3(this));
      this.jdV.setOnClickListener(this);
      this.jea = ((TextView)findViewById(f.e.emoji_service));
      this.jeb = ((TextView)findViewById(f.e.emoji_complaints));
      this.jea.setOnClickListener(this.jeD);
      this.jeb.setOnClickListener(this.jeE);
      this.jee = ((ProgressBar)findViewById(f.e.emoji_google_price_loading));
      localProgressBar = this.jee;
      if (!this.jes) {
        break label758;
      }
    }
    label758:
    for (i = 0;; i = 8)
    {
      localProgressBar.setVisibility(i);
      this.jey = findViewById(f.e.emoji_long_touch_pre_tips);
      this.jei = findViewById(f.e.emoji_designer_line_2);
      this.jef = findViewById(f.e.designer_bar_container);
      this.jeg = ((ImageView)findViewById(f.e.designer_icon));
      this.jeh = ((TextView)findViewById(f.e.designer_title));
      this.jej = findViewById(f.e.emoji_reward);
      this.jek = ((TextView)findViewById(f.e.reward_begword));
      this.jel = ((Button)findViewById(f.e.reward_btn));
      this.jen = ((TextView)findViewById(f.e.reward_info));
      this.jem = ((DonorsAvatarView)findViewById(f.e.reward_avatar));
      this.jel.setOnClickListener(this.jeF);
      this.jen.setOnClickListener(this.jeG);
      return;
      this.jdL = new EmojiStoreDetailUI.a(this);
      break;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.d("MicroMsg.emoji.EmojiStoreDetailUI", "onActivityResult. requestCode:[%d] resultCode:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    String str1;
    Object localObject;
    if (paramInt1 == 2001)
    {
      str1 = "";
      paramInt1 = 0;
      if (paramIntent != null)
      {
        paramInt1 = paramIntent.getIntExtra("key_err_code", 0);
        y.w("MicroMsg.emoji.EmojiStoreDetailUI", "errCode:" + paramInt1);
        str1 = paramIntent.getStringExtra("key_err_msg");
        y.w("MicroMsg.emoji.EmojiStoreDetailUI", "errMsg:" + str1);
      }
      this.jex = false;
      if (paramInt2 == -1) {
        if ((paramIntent != null) && (paramInt1 == 0))
        {
          localObject = paramIntent.getStringArrayListExtra("key_response_product_ids");
          paramIntent = paramIntent.getStringArrayListExtra("key_response_series_ids");
          if ((localObject != null) && (((ArrayList)localObject).contains(this.iZD)))
          {
            paramInt1 = 0;
            while (paramInt1 < ((ArrayList)localObject).size())
            {
              if (this.iZD.equals(((ArrayList)localObject).get(paramInt1))) {
                this.iZF = ((String)paramIntent.get(paramInt1));
              }
              paramInt1 += 1;
            }
            this.jbS.sSh = 1;
            aJo();
            this.jdH = 6;
            com.tencent.mm.ui.base.h.bC(this, str1);
            if (q.Gv()) {
              com.tencent.mm.plugin.report.service.h.nFQ.a(166L, 4L, 1L, false);
            }
          }
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          com.tencent.mm.plugin.report.service.h.nFQ.a(166L, 0L, 1L, false);
          return;
          this.jdH = -1;
          aJl();
          AR(str1);
          return;
          if ((paramIntent != null) && (paramInt1 == 100000002))
          {
            aJo();
            this.jdH = 6;
            this.jdL.notifyDataSetChanged();
            if (q.Gv())
            {
              com.tencent.mm.plugin.report.service.h.nFQ.a(166L, 7L, 1L, false);
              return;
            }
            com.tencent.mm.plugin.report.service.h.nFQ.a(166L, 3L, 1L, false);
            return;
          }
          if ((paramIntent != null) && (paramInt1 == 1))
          {
            this.jdH = -1;
            aJl();
            if (q.Gv())
            {
              com.tencent.mm.plugin.report.service.h.nFQ.a(166L, 6L, 1L, false);
              return;
            }
            com.tencent.mm.plugin.report.service.h.nFQ.a(166L, 2L, 1L, false);
            return;
          }
          this.jdH = -1;
          aJl();
          AR(str1);
          if (q.Gv())
          {
            com.tencent.mm.plugin.report.service.h.nFQ.a(166L, 5L, 1L, false);
            return;
          }
          com.tencent.mm.plugin.report.service.h.nFQ.a(166L, 1L, 1L, false);
          return;
          this.jdH = -1;
          aJl();
          if (q.Gv())
          {
            com.tencent.mm.plugin.report.service.h.nFQ.a(166L, 6L, 1L, false);
            return;
          }
          com.tencent.mm.plugin.report.service.h.nFQ.a(166L, 2L, 1L, false);
          return;
          if (paramInt1 != 2002) {
            break;
          }
        } while (paramInt2 != -1);
        paramIntent = paramIntent.getStringExtra("Select_Conv_User");
      } while (bk.bl(paramIntent));
      y.d("MicroMsg.emoji.EmojiStoreDetailUI", ".." + paramIntent);
      str1 = this.iZD;
      localObject = this.jbS.sSc;
      String str2 = this.jbS.sSd;
      String str3 = this.jbS.kSy;
      String str4 = this.jbS.sSv;
      paramInt1 = this.jbS.sSh;
      String str5 = getResources().getString(f.h.app_emoji_share);
      str5 = str5 + (String)localObject;
      String str6 = getString(f.h.app_send);
      String str7 = getString(f.h.confirm_dialog_edittext_hint);
      ((com.tencent.mm.pluginsdk.h)g.r(com.tencent.mm.pluginsdk.h.class)).a(this, paramIntent, str5, str6, str7, str3, new j.1(paramIntent, str1, (String)localObject, str2, str3, str4, paramInt1, this));
      return;
    } while ((paramInt1 != this.iYy.hcT) || (paramInt2 != -1));
    y.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks use emoji to : %s", new Object[] { paramIntent.getStringExtra("Select_Conv_User") });
    com.tencent.mm.plugin.emoji.h.c.a(paramIntent, this.iZD, this);
    com.tencent.mm.plugin.report.service.h.nFQ.f(12069, new Object[] { Integer.valueOf(3), this.iZD });
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == f.e.emoji_type)
    {
      if (this.jdH == 7)
      {
        paramView = getIntent().getStringExtra("to_talker_name");
        if ((!bk.bl(paramView)) && (this.jdG))
        {
          com.tencent.mm.plugin.emoji.h.c.a(paramView, this.iZD, this);
          y.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks kv stat update click use emoji");
          com.tencent.mm.plugin.report.service.h.nFQ.aC(11076, "0, ");
        }
      }
      do
      {
        return;
        this.iYy.x(this);
        com.tencent.mm.plugin.report.service.h.nFQ.f(12069, new Object[] { Integer.valueOf(2), this.iZD });
        break;
        switch (this.jdH)
        {
        case 1: 
        case 2: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        default: 
          y.e("MicroMsg.emoji.EmojiStoreDetailUI", "can not product status.%d", new Object[] { Integer.valueOf(this.jdH) });
          return;
        }
      } while (this.jex);
      y.d("MicroMsg.emoji.EmojiStoreDetailUI", "mProductId:%s, mData.PackPrice:%s,PriceType:%s", new Object[] { this.iZD, this.jbS.sSf, this.jbS.sSo });
      paramView = new Intent();
      paramView.putExtra("key_product_id", this.iZD);
      if (this.jes)
      {
        paramView.putExtra("key_currency_type", "");
        paramView.putExtra("key_price", this.jev);
      }
      for (;;)
      {
        d.b(this, "wallet_index", ".ui.WalletIapUI", paramView, 2001);
        com.tencent.mm.plugin.report.service.h.nFQ.f(12066, new Object[] { Integer.valueOf(2), Integer.valueOf(this.jeq), "", this.iZD, Long.valueOf(this.iYu), this.iYv });
        this.jex = true;
        return;
        paramView.putExtra("key_currency_type", this.jbS.sSo);
        paramView.putExtra("key_price", this.jbS.sSn);
      }
      aJo();
      this.jdH = 6;
      aJl();
      com.tencent.mm.plugin.report.service.h.nFQ.f(12066, new Object[] { Integer.valueOf(1), Integer.valueOf(this.jeq), "", this.iZD, Long.valueOf(this.iYu), this.iYv });
      return;
      this.jdH = 3;
      aJl();
      return;
      switch (this.jeu)
      {
      default: 
        paramView = getString(f.h.emoji_unknow);
      }
      for (;;)
      {
        com.tencent.mm.ui.base.h.b(this, paramView, null, true);
        return;
        paramView = getString(f.h.emoji_google_no_install);
        continue;
        paramView = getString(f.h.emoji_no_on_sale);
        continue;
        paramView = getString(f.h.emoji_timeout);
      }
      y.i("MicroMsg.emoji.EmojiStoreDetailUI", "can not be clicked.");
      return;
      y.i("MicroMsg.emoji.EmojiStoreDetailUI", "can not be clicked.");
      return;
    }
    if (i == f.e.emoji_download_progress)
    {
      aJn();
      return;
    }
    if (i == f.e.emoji_close)
    {
      aJn();
      return;
    }
    y.w("MicroMsg.emoji.EmojiStoreDetailUI", "click view is unknow.");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jes = q.Gv();
    this.iYy = new com.tencent.mm.plugin.emoji.h.c(2003);
    paramBundle = getIntent();
    this.iZD = getIntent().getStringExtra("extra_id");
    this.jbA = getIntent().getIntExtra("preceding_scence", -1);
    this.iZE = getIntent().getStringExtra("extra_name");
    this.jdD = getIntent().getIntExtra("call_by", -1);
    Object localObject = getIntent().getStringExtra("sns_object_data");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.iZD = EmojiLogic.AA((String)localObject);
      this.jbA = 0;
      this.jbA = 10;
      com.tencent.mm.plugin.report.service.h.nFQ.f(10993, new Object[] { Integer.valueOf(3), this.iZD });
    }
    if (TextUtils.isEmpty(this.iZD))
    {
      y.d("MicroMsg.emoji.EmojiStoreDetailUI", "[hadleIntent] product id is null.");
      finish();
    }
    if (this.jbA == -1)
    {
      y.e("MicroMsg.emoji.EmojiStoreDetailUI", "[hadleIntent] emoticon preceding scence no set!");
      finish();
    }
    this.jez = paramBundle.getBooleanExtra("check_clickflag", true);
    this.jer = paramBundle.getStringExtra("cdn_client_id");
    this.jeq = paramBundle.getIntExtra("download_entrance_scene", 0);
    this.iYu = paramBundle.getLongExtra("searchID", 0L);
    this.iYv = bk.aM(paramBundle.getStringExtra("docID"), "");
    localObject = paramBundle.getStringExtra("extra_copyright");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.jbS.sSm = ((String)localObject);
    }
    localObject = paramBundle.getStringExtra("extra_coverurl");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.jbS.sSk = ((String)localObject);
    }
    localObject = paramBundle.getStringExtra("extra_description");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.jbS.sSd = ((String)localObject);
    }
    localObject = paramBundle.getStringExtra("extra_price");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.jbS.sSf = ((String)localObject);
    }
    int i = paramBundle.getIntExtra("extra_type", -1);
    if (i != -1) {
      this.jbS.sSg = i;
    }
    i = paramBundle.getIntExtra("extra_flag", -1);
    if (i != -1) {
      this.jbS.sSh = i;
    }
    localObject = paramBundle.getStringExtra("extra_price_type");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.jbS.sSo = ((String)localObject);
    }
    localObject = paramBundle.getStringExtra("extra_price_num");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.jbS.sSn = ((String)localObject);
    }
    if (this.jes)
    {
      this.jev = paramBundle.getStringExtra("google_price");
      if (TextUtils.isEmpty(this.jev))
      {
        this.jet = 11;
        com.tencent.mm.pluginsdk.model.h.a(this, this.jew, this.jeJ);
      }
    }
    this.jdF = paramBundle.getBooleanExtra("reward_tip", false);
    this.jew[0] = this.iZD;
    this.jbS.syc = this.iZD;
    this.jbS.sSc = this.iZE;
    this.jbS.sSu = this.jdE;
    this.jbS.hQQ = -1;
    this.mContext = this;
    initView();
    if (!com.tencent.mm.plugin.emoji.h.a.Bh(this.iZD)) {
      if (this.jbS == null)
      {
        this.jdI = new com.tencent.mm.plugin.emoji.f.m(this.iZD, this.jbA);
        g.DO().dJT.a(this.jdI, 0);
        if ((this.jdD == -1) || (this.jdD == 3))
        {
          this.jdP.setVisibility(8);
          this.hrf.setVisibility(8);
          getString(f.h.app_tip);
          this.faz = com.tencent.mm.ui.base.h.b(this, getString(f.h.app_waiting), true, new EmojiStoreDetailUI.5(this));
        }
        aJf();
        if (!this.jez) {
          break label980;
        }
        paramBundle = new com.tencent.mm.plugin.emoji.f.l(this.iZD);
        g.DO().dJT.a(paramBundle, 0);
      }
    }
    for (;;)
    {
      aJi();
      com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().uBc.c(this);
      com.tencent.mm.sdk.b.a.udP.c(this.jbE);
      g.DO().dJT.a(822, this);
      i = getIntent().getIntExtra("extra_status", -1);
      int j = getIntent().getIntExtra("extra_progress", 0);
      h(this.iZD, i, j, this.jer);
      this.jeC = true;
      com.tencent.mm.plugin.report.service.h.nFQ.f(12740, new Object[] { Integer.valueOf(1), "", this.iZD, "", Integer.valueOf(this.jeq), Integer.valueOf(26) });
      if ((this.jdF) && (this.jdQ != null)) {
        this.mHandler.postDelayed(new EmojiStoreDetailUI.22(this), 0L);
      }
      return;
      if ((!bk.bl(this.jbT)) && (this.jbT.equalsIgnoreCase(x.fB(this.mContext))))
      {
        this.jdI = new com.tencent.mm.plugin.emoji.f.m(this.iZD, this.jbA, this.jbS.hQQ);
        break;
      }
      this.jdI = new com.tencent.mm.plugin.emoji.f.m(this.iZD, this.jbA);
      break;
      label980:
      this.jeB = true;
      this.jeA = EmojiLogic.aHK();
      continue;
      paramBundle = this.mController.uMN;
      localObject = new vj();
      ((vj)localObject).syc = EmojiGroupInfo.uCQ;
      ((vj)localObject).sSc = paramBundle.getString(f.h.emoji_store_tuzi_title);
      ((vj)localObject).sSd = paramBundle.getString(f.h.emoji_store_tuzi_desc);
      ((vj)localObject).sSe = paramBundle.getString(f.h.emoji_store_tuzi_auth);
      ((vj)localObject).sSf = "";
      ((vj)localObject).sSg = 0;
      ((vj)localObject).sSh = 1;
      ((vj)localObject).sSk = "";
      ((vj)localObject).sSl = 0;
      ((vj)localObject).sSm = paramBundle.getString(f.h.emoji_store_tuzi_copyright);
      ((vj)localObject).sSp = "";
      ((vj)localObject).sSn = "";
      ((vj)localObject).sSo = "";
      ((vj)localObject).sSt = paramBundle.getString(f.h.emoji_store_tuzi_timelimitStr);
      this.jbS = ((vj)localObject);
      this.jeB = true;
      this.jeA = EmojiLogic.aHK();
      aJh();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().uBc.d(this);
    com.tencent.mm.sdk.b.a.udP.d(this.jbE);
    g.DO().dJT.b(822, this);
    if (this.jdX != null) {
      this.jdX.release();
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    g.DO().dJT.b(412, this);
    g.DO().dJT.b(521, this);
    g.DO().dJT.b(423, this);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    this.jdH = paramBundle.getInt("status");
    this.xL = paramBundle.getInt("progress");
  }
  
  protected void onResume()
  {
    super.onResume();
    g.DO().dJT.a(412, this);
    g.DO().dJT.a(521, this);
    g.DO().dJT.a(423, this);
    this.jex = false;
    if (!this.jeC)
    {
      aJf();
      pX(1007);
    }
    aJg();
    this.jeC = false;
    pX(1001);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putInt("status", this.jdH);
    paramBundle.putInt("progress", this.xL);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((this.faz != null) && (this.faz.isShowing())) {
      this.faz.dismiss();
    }
    switch (paramm.getType())
    {
    }
    do
    {
      return;
      y.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_GetEmotionDetail");
      paramString = (com.tencent.mm.plugin.emoji.f.m)paramm;
      if ((paramString != null) && (!bk.bl(paramString.iZD)) && (paramString.iZD.equalsIgnoreCase(this.iZD)))
      {
        if (paramInt1 == 0)
        {
          if (paramInt2 == 0)
          {
            this.jbS = paramString.aIg();
            pX(1002);
            return;
          }
          if (paramInt2 == 1)
          {
            aJd();
            return;
          }
          this.jdO.setText(f.h.emoji_store_load_failed);
          aJe();
          return;
        }
        if (paramInt2 == 5)
        {
          if ((paramString != null) && (paramString.aIg() != null)) {
            this.jbS.sSh = paramString.aIg().sSh;
          }
          pX(1002);
          return;
        }
        if (paramInt2 == 1)
        {
          aJd();
          return;
        }
        this.jdQ.setVisibility(8);
        this.hrf.setVisibility(0);
        this.jdO.setText(f.h.emoji_store_load_failed_network);
        aJe();
        return;
      }
      y.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
      return;
      y.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_ExchangeEmotionPack");
      paramString = (com.tencent.mm.plugin.emoji.f.h)paramm;
      if ((paramString != null) && (!bk.bl(paramString.iZD)) && (paramString.iZD.equalsIgnoreCase(this.iZD)))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.jer = paramString.eoQ;
          this.jdH = 6;
          aJl();
          return;
        }
        this.jdH = -1;
        aJl();
        paramString = this.iZE;
        com.tencent.mm.ui.base.h.a(this, String.format(getString(f.h.emoji_store_download_failed_msg), new Object[] { paramString }), "", new EmojiStoreDetailUI.10(this), new EmojiStoreDetailUI.11(this));
        return;
      }
      y.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
      return;
      y.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_GetEmotionDesc");
      paramString = (com.tencent.mm.plugin.emoji.f.l)paramm;
      if ((paramString != null) && (!bk.bl(paramString.iZs)) && (paramString.iZs.equalsIgnoreCase(this.iZD))) {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.jeA = ((afc)paramString.dmK.ecF.ecN);
          this.jeB = true;
          aJm();
        }
      }
      for (;;)
      {
        this.jeB = true;
        aJm();
        return;
        this.jeA = null;
        break;
        y.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
      }
      y.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_MMGetEmotionReward");
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    this.jdM = ((com.tencent.mm.plugin.emoji.f.p)paramm).aIk();
    pX(1007);
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  protected void onStop()
  {
    super.onStop();
  }
  
  public final void pX(int paramInt)
  {
    if (this.mHandler != null) {
      this.mHandler.sendEmptyMessage(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI
 * JD-Core Version:    0.7.0.1
 */