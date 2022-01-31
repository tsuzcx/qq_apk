package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.at.a.c.j;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.plugin.emoji.e.l.1;
import com.tencent.mm.plugin.emoji.f.k;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.ui.v2.DonorsAvatarView;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardDetailUI;
import com.tencent.mm.pluginsdk.model.h.a;
import com.tencent.mm.pluginsdk.ui.emoji.BannerEmojiView;
import com.tencent.mm.protocal.protobuf.EmotionDetail;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.protocal.protobuf.PackThumbExt;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.protocal.protobuf.ajz;
import com.tencent.mm.protocal.protobuf.zr;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoSizeTextView;
import java.util.ArrayList;
import java.util.LinkedList;

public class EmojiStoreDetailUI
  extends MMActivity
  implements View.OnClickListener, f, k.a
{
  private ProgressDialog gsr;
  private ProgressBar ldL;
  private String lhA;
  private com.tencent.mm.plugin.emoji.h.c lhD;
  private long lhz;
  private String liu;
  private String liv;
  private String liw;
  private EmotionDetail lkB;
  private String lkC;
  private int lkj;
  private com.tencent.mm.sdk.b.c lkn;
  private boolean lmA;
  private TextView lmB;
  private View lmC;
  private EmojiDetailScrollView lmD;
  private BannerEmojiView lmE;
  private TextView lmF;
  private MMAutoSizeTextView lmG;
  private TextView lmH;
  private TextView lmI;
  private TextView lmJ;
  private EmojiDetailGridView lmK;
  private ImageView lmL;
  private View lmM;
  private TextView lmN;
  private TextView lmO;
  private int lmP;
  private View lmQ;
  private ProgressBar lmR;
  private View lmS;
  private ImageView lmT;
  private TextView lmU;
  private View lmV;
  private View lmW;
  private TextView lmX;
  private Button lmY;
  private DonorsAvatarView lmZ;
  private int lmq;
  private String lmr;
  private boolean lms;
  private boolean lmt;
  private int lmu;
  private com.tencent.mm.plugin.emoji.f.l lmv;
  private com.tencent.mm.plugin.emoji.f.g lmw;
  private com.tencent.mm.plugin.emoji.f.o lmx;
  private EmojiStoreDetailUI.a lmy;
  private GetEmotionRewardResponse lmz;
  private TextView lna;
  private int lnb;
  private int lnc;
  private int lnd;
  private String lne;
  private boolean lnf;
  private int lnh;
  private int lni;
  private String lnj;
  private String lnk;
  private String lnl;
  private String[] lnm;
  private boolean lnn;
  private View lno;
  private boolean lnp;
  private ajz lnq;
  private boolean lnr;
  private boolean lns;
  private View.OnClickListener lnt;
  private View.OnClickListener lnu;
  private View.OnClickListener lnv;
  private View.OnClickListener lnw;
  private com.tencent.mm.at.a.c.i lnx;
  private j lny;
  private h.a lnz;
  private Context mContext;
  private ak mHandler;
  private int mNumColumns;
  private int mPadding;
  private View xy;
  private int ym;
  
  public EmojiStoreDetailUI()
  {
    AppMethodBeat.i(53449);
    this.lmt = false;
    this.lmu = -1;
    this.lkB = new EmotionDetail();
    this.lkC = "";
    this.lmz = null;
    this.lhz = 0L;
    this.lhA = "";
    this.lni = -1;
    this.lnm = new String[1];
    this.lnn = false;
    this.lnp = true;
    this.lnr = false;
    this.lns = true;
    this.lkn = new EmojiStoreDetailUI.1(this);
    this.lnt = new EmojiStoreDetailUI.12(this);
    this.lnu = new EmojiStoreDetailUI.16(this);
    this.lnv = new EmojiStoreDetailUI.17(this);
    this.lnw = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(53435);
        paramAnonymousView = new Intent();
        paramAnonymousView.setClass(EmojiStoreDetailUI.this, EmojiStoreV2RewardDetailUI.class);
        paramAnonymousView.putExtra("extra_id", EmojiStoreDetailUI.a(EmojiStoreDetailUI.this));
        paramAnonymousView.putExtra("extra_iconurl", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).IconUrl);
        paramAnonymousView.putExtra("extra_name", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PackName);
        if (EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PersonalDesigner != null) {
          paramAnonymousView.putExtra("name", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PersonalDesigner.Name);
        }
        EmojiStoreDetailUI.this.startActivity(paramAnonymousView);
        AppMethodBeat.o(53435);
      }
    };
    this.mHandler = new EmojiStoreDetailUI.19(this);
    this.lnx = new EmojiStoreDetailUI.20(this);
    this.lny = new EmojiStoreDetailUI.21(this);
    this.lnz = new EmojiStoreDetailUI.15(this);
    AppMethodBeat.o(53449);
  }
  
  private void KT(String paramString)
  {
    AppMethodBeat.i(53465);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(2131299162);
    }
    com.tencent.mm.ui.base.h.a(this, str, "", new EmojiStoreDetailUI.4(this));
    AppMethodBeat.o(53465);
  }
  
  private void bmE()
  {
    AppMethodBeat.i(53461);
    this.xy.setVisibility(0);
    this.lmC.setVisibility(8);
    this.lmD.setVisibility(8);
    this.lmB.setText(2131299152);
    AppMethodBeat.o(53461);
  }
  
  private void bmF()
  {
    AppMethodBeat.i(53462);
    ab.i("MicroMsg.emoji.EmojiStoreDetailUI", "[handleLoadDataFailed]");
    if ((this.lkB == null) || (this.lkB.PackFlag == 0))
    {
      this.xy.setVisibility(0);
      this.lmC.setVisibility(8);
    }
    AppMethodBeat.o(53462);
  }
  
  private void bmG()
  {
    AppMethodBeat.i(53466);
    this.lmz = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().yNs.asX(this.liu);
    AppMethodBeat.o(53466);
  }
  
  private void bmH()
  {
    AppMethodBeat.i(53467);
    if ((e.ea(this.lkB.PackFlag, 64)) && (com.tencent.mm.emoji.a.h.OH()))
    {
      this.lmx = new com.tencent.mm.plugin.emoji.f.o(this.liu, com.tencent.mm.plugin.emoji.f.o.liS);
      com.tencent.mm.kernel.g.RK().eHt.a(this.lmx, 0);
    }
    AppMethodBeat.o(53467);
  }
  
  private boolean bmI()
  {
    AppMethodBeat.i(53468);
    boolean bool = com.tencent.mm.plugin.emoji.h.a.bmI();
    this.lmA = bool;
    if (bool) {}
    for (int i = 7;; i = 3)
    {
      this.lmu = i;
      AppMethodBeat.o(53468);
      return bool;
    }
  }
  
  private void bmJ()
  {
    AppMethodBeat.i(53469);
    if (!bo.isNullOrNil(this.lkB.PackName)) {
      setMMTitle(this.lkB.PackName);
    }
    ab.d("MicroMsg.emoji.EmojiStoreDetailUI", "mData.PanelUrl:%s", new Object[] { this.lkB.PanelUrl });
    this.lmC.setVisibility(0);
    this.xy.setVisibility(8);
    gG(true);
    this.lmG.setText(this.lkB.PackName);
    this.lmH.setText(this.lkB.PackCopyright);
    this.lmJ.setText(this.lkB.PackDesc);
    if (e.ea(this.lkB.PackType, 1)) {
      this.lmF.setVisibility(8);
    }
    for (;;)
    {
      bmN();
      bmO();
      bmP();
      bmQ();
      bmR();
      this.lmG.setMaxWidth(this.lmP - this.lmQ.getWidth() - com.tencent.mm.cb.a.ao(getContext(), 2131427808) * 2 - this.lmF.getWidth() - com.tencent.mm.cb.a.ao(getContext(), 2131427781) * 2);
      this.lmG.setVisibility(8);
      this.lmG.setVisibility(0);
      bmK();
      bmM();
      bmL();
      AppMethodBeat.o(53469);
      return;
      this.lmF.setVisibility(0);
      this.lmF.setText(2131299285);
    }
  }
  
  private void bmK()
  {
    AppMethodBeat.i(53471);
    if ((this.lkB.PersonalDesigner != null) && (this.lkB.PersonalDesigner.DesignerUin != 0) && (this.lnd != 6))
    {
      this.lmV.setVisibility(0);
      this.lmS.setVisibility(0);
      com.tencent.mm.at.o.ahG().a(this.lkB.PersonalDesigner.HeadUrl, this.lmT, com.tencent.mm.plugin.emoji.e.g.dL(this.liu, this.lkB.PersonalDesigner.HeadUrl));
      this.lmU.setText(this.lkB.PersonalDesigner.Name);
      this.lmS.setOnClickListener(new EmojiStoreDetailUI.6(this));
      AppMethodBeat.o(53471);
      return;
    }
    this.lmV.setVisibility(8);
    this.lmS.setVisibility(8);
    AppMethodBeat.o(53471);
  }
  
  private void bmM()
  {
    AppMethodBeat.i(53473);
    if ((this.lkB.PackFlag & 0x20) == 32)
    {
      localLayoutParams1 = (LinearLayout.LayoutParams)this.lmO.getLayoutParams();
      LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)this.lmN.getLayoutParams();
      this.lmO.setVisibility(0);
      localLayoutParams1.weight = 1.0F;
      localLayoutParams1.gravity = 3;
      localLayoutParams1.leftMargin = com.tencent.mm.cb.a.ao(getContext(), 2131427808);
      this.lmO.setLayoutParams(localLayoutParams1);
      this.lmO.setGravity(3);
      localLayoutParams2.weight = 1.0F;
      localLayoutParams2.gravity = 5;
      localLayoutParams2.rightMargin = com.tencent.mm.cb.a.ao(getContext(), 2131427808);
      this.lmN.setLayoutParams(localLayoutParams2);
      this.lmN.setGravity(5);
      AppMethodBeat.o(53473);
      return;
    }
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.lmN.getLayoutParams();
    localLayoutParams1.gravity = 17;
    this.lmN.setLayoutParams(localLayoutParams1);
    this.lmN.setGravity(17);
    this.lmO.setVisibility(8);
    AppMethodBeat.o(53473);
  }
  
  private void bmN()
  {
    AppMethodBeat.i(53474);
    if (e.ea(this.lkB.PackType, 8))
    {
      this.lnc = 0;
      ab.i("MicroMsg.emoji.EmojiStoreDetailUI", "PackFlag:%d", new Object[] { Integer.valueOf(this.lkB.PackFlag) });
      if ((!e.ea(this.lkB.PackFlag, 8)) || (!e.uo(this.lkB.PackType))) {
        break label164;
      }
      this.lmu = 8;
    }
    for (;;)
    {
      if (this.lmA) {
        this.lmu = 7;
      }
      AppMethodBeat.o(53474);
      return;
      if (e.ea(this.lkB.PackType, 4))
      {
        this.lnc = 0;
        break;
      }
      if ((!this.lnf) && (TextUtils.isEmpty(this.lkB.PackPrice)))
      {
        this.lnc = 0;
        break;
      }
      this.lnc = 1;
      break;
      label164:
      if ((e.ea(this.lkB.PackFlag, 1)) || (e.ea(this.lkB.PackType, 8))) {
        this.lmu = 3;
      } else if (e.uo(this.lkB.PackType)) {
        this.lmu = 0;
      } else if ((!this.lnf) && ((TextUtils.isEmpty(this.lkB.PriceNum)) || (this.lkB.PriceNum.equals("0")))) {
        this.lmu = 0;
      } else if (this.lnf)
      {
        if (TextUtils.isEmpty(this.lnj)) {
          this.lmu = this.lnh;
        } else {
          this.lmu = 4;
        }
      }
      else {
        this.lmu = 4;
      }
    }
  }
  
  private void bmO()
  {
    AppMethodBeat.i(53475);
    if (com.tencent.mm.plugin.emoji.h.a.Lj(this.liu)) {
      bmI();
    }
    switch (this.lmu)
    {
    case 1: 
    case 2: 
    case 9: 
    default: 
      ab.w("MicroMsg.emoji.EmojiStoreDetailUI", "unknow product status:%d", new Object[] { Integer.valueOf(this.lmu) });
    }
    for (;;)
    {
      bmP();
      AppMethodBeat.o(53475);
      return;
      this.lmR.setVisibility(8);
      this.lmI.setTextColor(getResources().getColorStateList(2131689978));
      this.lmI.setBackgroundResource(2130838050);
      this.lmI.setText(2131299196);
      this.lmI.setEnabled(false);
      continue;
      this.lmR.setVisibility(8);
      this.lmI.setTextColor(getResources().getColorStateList(2131690799));
      this.lmI.setBackgroundResource(2130838045);
      this.lmI.setText(2131299193);
      this.lmI.setEnabled(true);
      continue;
      this.lmR.setVisibility(8);
      this.lmI.setTextColor(getResources().getColorStateList(2131690799));
      this.lmI.setBackgroundResource(2130838045);
      this.lmI.setEnabled(true);
      if (this.lnf)
      {
        if (bo.isNullOrNil(this.lnj)) {
          this.lmI.setText("");
        } else {
          this.lmI.setText(this.lnj);
        }
      }
      else
      {
        this.lmI.setText(this.lkB.PackPrice);
        this.lmu = 4;
        continue;
        this.lmR.setVisibility(8);
        this.lmI.setTextColor(getResources().getColorStateList(2131690799));
        this.lmI.setBackgroundResource(2130838045);
        this.lmI.setText(2131299193);
        this.lmI.setEnabled(true);
        continue;
        this.lmR.setVisibility(8);
        this.lmI.setEnabled(false);
        this.lmM.setVisibility(0);
        this.lmL.setVisibility(0);
        this.lmI.setVisibility(4);
        if (this.lmq != 3)
        {
          continue;
          this.lmR.setVisibility(8);
          this.lmI.setVisibility(0);
          this.lmI.setEnabled(true);
          this.lmI.setBackgroundResource(2130838045);
          this.lmI.setText(2131299262);
          this.lmM.setVisibility(8);
          this.ldL.setProgress(0);
          this.lmL.setVisibility(4);
          if (this.lmq != 3)
          {
            continue;
            this.lmR.setVisibility(8);
            this.lmI.setBackgroundResource(2130838045);
            this.lmI.setText(2131299193);
            this.lmI.setEnabled(true);
            this.lmR.setVisibility(0);
            this.lmI.setVisibility(0);
            this.lmI.setBackgroundResource(2130840962);
            this.lmI.setText("");
            this.lmI.setEnabled(false);
            this.lmM.setVisibility(8);
            this.ldL.setProgress(0);
            this.lmL.setVisibility(4);
            continue;
            this.lmR.setVisibility(8);
            this.lmI.setVisibility(0);
            this.lmI.setBackgroundResource(2130838045);
            this.lmI.setText(2131299217);
            this.lmI.setEnabled(true);
            this.lmM.setVisibility(8);
            this.ldL.setProgress(0);
            this.lmL.setVisibility(4);
            continue;
            bmN();
            bmO();
          }
        }
      }
    }
  }
  
  private void bmP()
  {
    AppMethodBeat.i(53476);
    if ((this.lnr) && ((this.lnq == null) || ((this.lnq.xbm & 0x1) != 1)) && ((this.lkB == null) || (!e.ea(this.lkB.PackFlag, 1))) && (this.lnq != null) && (!TextUtils.isEmpty(this.lnq.xbl)))
    {
      this.lmI.setText(this.lnq.xbl);
      this.lmI.setTextColor(getContext().getResources().getColor(2131690159));
      this.lmI.setBackgroundDrawable(null);
      this.lmI.setEnabled(false);
    }
    AppMethodBeat.o(53476);
  }
  
  private void bmQ()
  {
    AppMethodBeat.i(53477);
    if ((!com.tencent.mm.plugin.emoji.h.a.Lj(this.liu)) && ((this.lkB.ThumbExtList == null) || (this.lkB.ThumbExtList.size() <= 0) || (((PackThumbExt)this.lkB.ThumbExtList.get(0)).PreviewUrl == null))) {
      this.lno.setVisibility(8);
    }
    for (;;)
    {
      this.lmK.setProductId(this.liu);
      if (this.lmy != null) {
        this.lmy.notifyDataSetInvalidated();
      }
      AppMethodBeat.o(53477);
      return;
      this.lno.setVisibility(0);
    }
  }
  
  private void bmR()
  {
    AppMethodBeat.i(53478);
    ab.d("MicroMsg.emoji.EmojiStoreDetailUI", "mData.PackFlag:%s", new Object[] { this.lkB.PackFlag });
    if ((this.lkB.PackFlag & 0x10) == 16) {
      addIconOptionMenu(0, 2131231823, new EmojiStoreDetailUI.7(this));
    }
    AppMethodBeat.o(53478);
  }
  
  private void bmS()
  {
    AppMethodBeat.i(53479);
    com.tencent.mm.ui.base.h.a(this, 2131299185, 0, 2131299250, 2131299188, new EmojiStoreDetailUI.8(this), new EmojiStoreDetailUI.9(this));
    AppMethodBeat.o(53479);
  }
  
  private void bmT()
  {
    AppMethodBeat.i(53481);
    if (com.tencent.mm.plugin.emoji.h.a.Lj(this.liu))
    {
      com.tencent.mm.plugin.emoji.f.a.blw();
      com.tencent.mm.plugin.emoji.f.a.blx();
      AppMethodBeat.o(53481);
      return;
    }
    this.lmw = new com.tencent.mm.plugin.emoji.f.g(this.liu, this.liw, this.liv);
    com.tencent.mm.kernel.g.RK().eHt.a(this.lmw, 0);
    switch (this.lkj)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(53481);
      return;
      com.tencent.mm.plugin.report.service.h.qsU.e(11598, new Object[] { Integer.valueOf(1), this.liu });
      AppMethodBeat.o(53481);
      return;
      com.tencent.mm.plugin.report.service.h.qsU.e(11598, new Object[] { Integer.valueOf(3), this.liu });
      AppMethodBeat.o(53481);
      return;
      com.tencent.mm.plugin.report.service.h.qsU.e(11598, new Object[] { Integer.valueOf(2), this.liu });
    }
  }
  
  private void gG(boolean paramBoolean)
  {
    AppMethodBeat.i(53470);
    Object localObject = null;
    String str;
    if (!bo.isNullOrNil(this.lkB.CoverUrl))
    {
      if (!paramBoolean) {
        break label105;
      }
      localObject = this.liu;
      str = this.lkB.CoverUrl;
      com.tencent.mm.cb.a.getDensity(this.mContext);
    }
    for (localObject = EmojiLogic.a((String)localObject, str, this.lnx);; localObject = EmojiLogic.s((String)localObject, 4, str))
    {
      if ((localObject != null) && (this.lmE != null)) {
        this.lmE.setImageFilePath(((EmojiInfo)localObject).dQB());
      }
      if (com.tencent.mm.plugin.emoji.h.a.Lj(this.liu)) {
        this.lmE.setImageResource(2130840633);
      }
      AppMethodBeat.o(53470);
      return;
      label105:
      localObject = this.liu;
      str = this.lkB.CoverUrl;
      com.tencent.mm.cb.a.getDensity(this.mContext);
    }
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(53464);
    ut(1001);
    AppMethodBeat.o(53464);
  }
  
  public final void bmL()
  {
    AppMethodBeat.i(53472);
    if ((e.ea(this.lkB.PackFlag, 64)) && (com.tencent.mm.emoji.a.h.OH()))
    {
      if (this.lmz != null)
      {
        this.lmW.setVisibility(0);
        this.lmY.setText(2131299226);
        this.lmX.setText(this.lmz.Reward.wQD);
        this.lmX.setLongClickable(false);
        if (this.lmz.DonorNum > 0)
        {
          this.lna.setVisibility(0);
          String str1 = String.valueOf(this.lmz.DonorNum);
          String str2 = String.format(getString(2131299230), new Object[] { Integer.valueOf(this.lmz.DonorNum) });
          SpannableString localSpannableString = new SpannableString(str2);
          int i = str2.indexOf(str1);
          if (i >= 0) {
            localSpannableString.setSpan(new ForegroundColorSpan(getResources().getColor(2131689988)), i, str1.length() + i, 33);
          }
          this.lna.setText(localSpannableString);
        }
        while ((this.lmz.Donors != null) && (this.lmz.Donors.size() > 0))
        {
          this.lmZ.setVisibility(0);
          this.lmZ.c(this.liu, this.lmz.Donors);
          AppMethodBeat.o(53472);
          return;
          this.lna.setVisibility(8);
        }
        this.lmZ.setVisibility(8);
        AppMethodBeat.o(53472);
        return;
      }
      this.lmW.setVisibility(8);
      bmH();
      AppMethodBeat.o(53472);
      return;
    }
    this.lmW.setVisibility(8);
    AppMethodBeat.o(53472);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969382;
  }
  
  public final void h(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(53480);
    ab.d("MicroMsg.emoji.EmojiStoreDetailUI", "productId:%s,status:%d, progress:%d, cdnClientID:%s, ", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
    if ((bo.isNullOrNil(paramString1)) || (!paramString1.equals(this.liu)))
    {
      AppMethodBeat.o(53480);
      return;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      this.lne = paramString2;
    }
    if (paramInt1 == -1)
    {
      if (this.lmu != -1)
      {
        this.lmu = -1;
        ut(1003);
        AppMethodBeat.o(53480);
      }
    }
    else
    {
      if (paramInt1 == 7)
      {
        this.lmu = 7;
        ut(1003);
        AppMethodBeat.o(53480);
        return;
      }
      if (paramInt1 == 6)
      {
        if ((!TextUtils.isEmpty(paramString1)) && (paramString1.equals(this.liu)))
        {
          this.lmu = 6;
          this.ym = paramInt2;
          ut(1004);
          AppMethodBeat.o(53480);
        }
      }
      else {
        ab.w("MicroMsg.emoji.EmojiStoreDetailUI", "[onExchange] do nothing.");
      }
    }
    AppMethodBeat.o(53480);
  }
  
  public void initView()
  {
    AppMethodBeat.i(53451);
    if (!bo.isNullOrNil(this.liv)) {
      setMMTitle(this.liv);
    }
    setBackBtn(new EmojiStoreDetailUI.2(this));
    this.mPadding = com.tencent.mm.cb.a.ao(this.mContext, 2131428354);
    this.lnb = getResources().getDimensionPixelSize(2131428353);
    this.lnb = com.tencent.mm.cb.a.ao(this.mContext, 2131428353);
    this.mNumColumns = 4;
    this.lmD = ((EmojiDetailScrollView)findViewById(2131823222));
    this.xy = findViewById(2131821788);
    this.lmB = ((TextView)this.xy.findViewById(2131823644));
    this.lmC = findViewById(2131823625);
    this.lmE = ((BannerEmojiView)findViewById(2131823626));
    int i = this.lmE.getRight();
    int j = this.lmE.getLeft();
    int k = this.lmE.getPaddingRight();
    int m = this.lmE.getPaddingLeft();
    this.lmE.setMinimumHeight((int)((i - j - k - m) * 0.56F));
    this.lmF = ((TextView)findViewById(2131823629));
    this.lmG = ((MMAutoSizeTextView)findViewById(2131823628));
    this.lmH = ((TextView)findViewById(2131823641));
    this.lmI = ((TextView)findViewById(2131823631));
    this.lmJ = ((TextView)findViewById(2131823636));
    this.lmP = com.tencent.mm.cb.a.gw(getContext());
    this.lmQ = findViewById(2131823630);
    this.lmK = ((EmojiDetailGridView)findViewById(2131823638));
    ProgressBar localProgressBar;
    if (com.tencent.mm.plugin.emoji.h.a.Lj(this.liu))
    {
      this.lmy = new EmojiStoreDetailUI.b(this);
      this.lmM = findViewById(2131823632);
      this.ldL = ((ProgressBar)findViewById(2131823633));
      this.lmL = ((ImageView)findViewById(2131823634));
      this.lmL.setOnClickListener(this);
      this.lmM.setVisibility(8);
      this.lmL.setVisibility(8);
      this.ldL.setProgress(0);
      this.lmK.setAdapter(this.lmy);
      this.lmK.setColumnWidth(this.lnb);
      this.lmK.setNumColumns(this.mNumColumns);
      this.lmK.setHorizontalSpacing(this.mPadding);
      this.lmK.setVerticalSpacing(this.mPadding);
      this.lmK.setEmojiDetailScrollView(this.lmD);
      this.lmK.setFromDetail(true);
      this.lmK.setIsShowPopWin(true);
      this.lmK.setOnItemClickListener(new EmojiStoreDetailUI.3(this));
      this.lmI.setOnClickListener(this);
      this.lmN = ((TextView)findViewById(2131823642));
      this.lmO = ((TextView)findViewById(2131823643));
      this.lmN.setOnClickListener(this.lnt);
      this.lmO.setOnClickListener(this.lnu);
      this.lmR = ((ProgressBar)findViewById(2131823635));
      localProgressBar = this.lmR;
      if (!this.lnf) {
        break label767;
      }
    }
    label767:
    for (i = 0;; i = 8)
    {
      localProgressBar.setVisibility(i);
      this.lno = findViewById(2131823637);
      this.lmV = findViewById(2131823639);
      this.lmS = findViewById(2131823653);
      this.lmT = ((ImageView)findViewById(2131823654));
      this.lmU = ((TextView)findViewById(2131823655));
      this.lmW = findViewById(2131823640);
      this.lmX = ((TextView)findViewById(2131823681));
      this.lmY = ((Button)findViewById(2131823682));
      this.lna = ((TextView)findViewById(2131823683));
      this.lmZ = ((DonorsAvatarView)findViewById(2131823684));
      this.lmY.setOnClickListener(this.lnv);
      this.lna.setOnClickListener(this.lnw);
      AppMethodBeat.o(53451);
      return;
      this.lmy = new EmojiStoreDetailUI.a(this);
      break;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(53463);
    ab.d("MicroMsg.emoji.EmojiStoreDetailUI", "onActivityResult. requestCode:[%d] resultCode:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    String str1;
    Object localObject;
    if (paramInt1 == 2001)
    {
      str1 = "";
      paramInt1 = 0;
      if (paramIntent != null)
      {
        paramInt1 = paramIntent.getIntExtra("key_err_code", 0);
        ab.w("MicroMsg.emoji.EmojiStoreDetailUI", "errCode:".concat(String.valueOf(paramInt1)));
        str1 = paramIntent.getStringExtra("key_err_msg");
        ab.w("MicroMsg.emoji.EmojiStoreDetailUI", "errMsg:".concat(String.valueOf(str1)));
      }
      this.lnn = false;
      if (paramInt2 == -1)
      {
        if ((paramIntent != null) && (paramInt1 == 0))
        {
          localObject = paramIntent.getStringArrayListExtra("key_response_product_ids");
          paramIntent = paramIntent.getStringArrayListExtra("key_response_series_ids");
          if ((localObject != null) && (((ArrayList)localObject).contains(this.liu)))
          {
            paramInt1 = 0;
            while (paramInt1 < ((ArrayList)localObject).size())
            {
              if (this.liu.equals(((ArrayList)localObject).get(paramInt1))) {
                this.liw = ((String)paramIntent.get(paramInt1));
              }
              paramInt1 += 1;
            }
            this.lkB.PackFlag = 1;
            bmT();
            this.lmu = 6;
            com.tencent.mm.ui.base.h.bO(this, str1);
            if (r.ZA())
            {
              com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(166L, 4L, 1L, false);
              AppMethodBeat.o(53463);
              return;
            }
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(166L, 0L, 1L, false);
            AppMethodBeat.o(53463);
            return;
          }
          this.lmu = -1;
          bmO();
          KT(str1);
          AppMethodBeat.o(53463);
          return;
        }
        if ((paramIntent != null) && (paramInt1 == 100000002))
        {
          bmT();
          this.lmu = 6;
          this.lmy.notifyDataSetChanged();
          if (r.ZA())
          {
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(166L, 7L, 1L, false);
            AppMethodBeat.o(53463);
            return;
          }
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(166L, 3L, 1L, false);
          AppMethodBeat.o(53463);
          return;
        }
        if ((paramIntent != null) && (paramInt1 == 1))
        {
          this.lmu = -1;
          bmO();
          if (r.ZA())
          {
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(166L, 6L, 1L, false);
            AppMethodBeat.o(53463);
            return;
          }
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(166L, 2L, 1L, false);
          AppMethodBeat.o(53463);
          return;
        }
        this.lmu = -1;
        bmO();
        KT(str1);
        if (r.ZA())
        {
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(166L, 5L, 1L, false);
          AppMethodBeat.o(53463);
          return;
        }
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(166L, 1L, 1L, false);
        AppMethodBeat.o(53463);
        return;
      }
      this.lmu = -1;
      bmO();
      if (r.ZA())
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(166L, 6L, 1L, false);
        AppMethodBeat.o(53463);
        return;
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(166L, 2L, 1L, false);
      AppMethodBeat.o(53463);
      return;
    }
    if (paramInt1 == 2002)
    {
      if (paramInt2 == -1)
      {
        paramIntent = paramIntent.getStringExtra("Select_Conv_User");
        if (!bo.isNullOrNil(paramIntent))
        {
          ab.d("MicroMsg.emoji.EmojiStoreDetailUI", "..".concat(String.valueOf(paramIntent)));
          str1 = this.liu;
          localObject = this.lkB.PackName;
          String str2 = this.lkB.PackDesc;
          String str3 = this.lkB.IconUrl;
          String str4 = this.lkB.OldRedirectUrl;
          paramInt1 = this.lkB.PackFlag;
          String str5 = getResources().getString(2131296917);
          str5 = str5 + (String)localObject;
          String str6 = getString(2131297067);
          String str7 = getString(2131298500);
          ((com.tencent.mm.pluginsdk.i)com.tencent.mm.kernel.g.E(com.tencent.mm.pluginsdk.i.class)).a(this, paramIntent, str5, str6, str7, str3, new l.1(paramIntent, str1, (String)localObject, str2, str3, str4, paramInt1, this));
        }
        AppMethodBeat.o(53463);
      }
    }
    else if (paramInt1 == this.lhD.iMG)
    {
      if (paramInt2 == -1)
      {
        ab.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks use emoji to : %s", new Object[] { paramIntent.getStringExtra("Select_Conv_User") });
        com.tencent.mm.plugin.emoji.h.c.a(paramIntent, this.liu, this);
        com.tencent.mm.plugin.report.service.h.qsU.e(12069, new Object[] { Integer.valueOf(3), this.liu });
        AppMethodBeat.o(53463);
      }
    }
    else if ((paramInt1 == 2004) && (paramInt2 == -1)) {
      com.tencent.mm.ui.widget.snackbar.b.l(this, getContext().getString(2131297070));
    }
    AppMethodBeat.o(53463);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(53459);
    int i = paramView.getId();
    if (i == 2131823631)
    {
      if (this.lmu == 7)
      {
        paramView = getIntent().getStringExtra("to_talker_name");
        if ((!bo.isNullOrNil(paramView)) && (this.lmt)) {
          com.tencent.mm.plugin.emoji.h.c.a(paramView, this.liu, this);
        }
        for (;;)
        {
          ab.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks kv stat update click use emoji");
          com.tencent.mm.plugin.report.service.h.qsU.kvStat(11076, "0, ");
          AppMethodBeat.o(53459);
          return;
          this.lhD.A(this);
          com.tencent.mm.plugin.report.service.h.qsU.e(12069, new Object[] { Integer.valueOf(2), this.liu });
        }
      }
      switch (this.lmu)
      {
      case 1: 
      case 2: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      default: 
        ab.e("MicroMsg.emoji.EmojiStoreDetailUI", "can not product status.%d", new Object[] { Integer.valueOf(this.lmu) });
      case 4: 
        do
        {
          AppMethodBeat.o(53459);
          return;
        } while (this.lnn);
        ab.i("MicroMsg.emoji.EmojiStoreDetailUI", "mProductId:%s, mData.PackPrice:%s,PriceType:%s", new Object[] { this.liu, this.lkB.PackPrice, this.lkB.PriceType });
        paramView = new Intent();
        paramView.putExtra("key_product_id", this.liu);
        if (this.lnf)
        {
          paramView.putExtra("key_currency_type", this.lnk);
          paramView.putExtra("key_price", this.lnk + this.lnl);
        }
        for (;;)
        {
          d.b(this, "wallet_index", ".ui.WalletIapUI", paramView, 2001);
          com.tencent.mm.plugin.report.service.h.qsU.e(12066, new Object[] { Integer.valueOf(2), Integer.valueOf(this.lnd), "", this.liu, Long.valueOf(this.lhz), this.lhA });
          this.lnn = true;
          AppMethodBeat.o(53459);
          return;
          paramView.putExtra("key_currency_type", this.lkB.PriceType);
          paramView.putExtra("key_price", this.lkB.PriceNum);
        }
      case 0: 
      case 3: 
        bmT();
        this.lmu = 6;
        bmO();
        com.tencent.mm.plugin.report.service.h.qsU.e(12066, new Object[] { Integer.valueOf(1), Integer.valueOf(this.lnd), "", this.liu, Long.valueOf(this.lhz), this.lhA });
        AppMethodBeat.o(53459);
        return;
      case 5: 
        this.lmu = 3;
        bmO();
        AppMethodBeat.o(53459);
        return;
      case 10: 
      case 12: 
        switch (this.lni)
        {
        default: 
          paramView = getString(2131299286);
        }
        for (;;)
        {
          com.tencent.mm.ui.base.h.b(this, paramView, null, true);
          AppMethodBeat.o(53459);
          return;
          paramView = getString(2131299145);
          continue;
          paramView = getString(2131299153);
          continue;
          paramView = getString(2131299281);
        }
      case 11: 
        ab.i("MicroMsg.emoji.EmojiStoreDetailUI", "can not be clicked.");
        AppMethodBeat.o(53459);
        return;
      }
      ab.i("MicroMsg.emoji.EmojiStoreDetailUI", "can not be clicked.");
      AppMethodBeat.o(53459);
      return;
    }
    if (i == 2131823633)
    {
      bmS();
      AppMethodBeat.o(53459);
      return;
    }
    if (i == 2131823634)
    {
      bmS();
      AppMethodBeat.o(53459);
      return;
    }
    ab.w("MicroMsg.emoji.EmojiStoreDetailUI", "click view is unknow.");
    AppMethodBeat.o(53459);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(53450);
    super.onCreate(paramBundle);
    this.lnf = r.ZA();
    this.lhD = new com.tencent.mm.plugin.emoji.h.c(2003);
    paramBundle = getIntent();
    this.liu = getIntent().getStringExtra("extra_id");
    this.lkj = getIntent().getIntExtra("preceding_scence", -1);
    this.liv = getIntent().getStringExtra("extra_name");
    this.lmq = getIntent().getIntExtra("call_by", -1);
    Object localObject = getIntent().getStringExtra("sns_object_data");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.liu = EmojiLogic.KB((String)localObject);
      this.lkj = 0;
      this.lkj = 10;
      com.tencent.mm.plugin.report.service.h.qsU.e(10993, new Object[] { Integer.valueOf(3), this.liu });
    }
    if (TextUtils.isEmpty(this.liu))
    {
      ab.d("MicroMsg.emoji.EmojiStoreDetailUI", "[hadleIntent] product id is null.");
      finish();
    }
    if (this.lkj == -1)
    {
      ab.e("MicroMsg.emoji.EmojiStoreDetailUI", "[hadleIntent] emoticon preceding scence no set!");
      finish();
    }
    this.lnp = paramBundle.getBooleanExtra("check_clickflag", true);
    this.lne = paramBundle.getStringExtra("cdn_client_id");
    this.lnd = paramBundle.getIntExtra("download_entrance_scene", 0);
    this.lhz = paramBundle.getLongExtra("searchID", 0L);
    this.lhA = bo.bf(paramBundle.getStringExtra("docID"), "");
    localObject = paramBundle.getStringExtra("extra_copyright");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.lkB.PackCopyright = ((String)localObject);
    }
    localObject = paramBundle.getStringExtra("extra_coverurl");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.lkB.CoverUrl = ((String)localObject);
    }
    localObject = paramBundle.getStringExtra("extra_description");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.lkB.PackDesc = ((String)localObject);
    }
    localObject = paramBundle.getStringExtra("extra_price");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.lkB.PackPrice = ((String)localObject);
    }
    int i = paramBundle.getIntExtra("extra_type", -1);
    if (i != -1) {
      this.lkB.PackType = i;
    }
    i = paramBundle.getIntExtra("extra_flag", -1);
    if (i != -1) {
      this.lkB.PackFlag = i;
    }
    localObject = paramBundle.getStringExtra("extra_price_type");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.lkB.PriceType = ((String)localObject);
    }
    localObject = paramBundle.getStringExtra("extra_price_num");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.lkB.PriceNum = ((String)localObject);
    }
    if (this.lnf)
    {
      this.lnh = 11;
      com.tencent.mm.pluginsdk.model.h.a(this, this.lnm, this.lnz);
    }
    this.lms = paramBundle.getBooleanExtra("reward_tip", false);
    this.lnm[0] = this.liu;
    this.lkB.ProductID = this.liu;
    this.lkB.PackName = this.liv;
    this.lkB.ShareDesc = this.lmr;
    this.lkB.Version = -1;
    this.mContext = this;
    initView();
    if (!com.tencent.mm.plugin.emoji.h.a.Lj(this.liu)) {
      if (this.lkB == null)
      {
        this.lmv = new com.tencent.mm.plugin.emoji.f.l(this.liu, this.lkj);
        com.tencent.mm.kernel.g.RK().eHt.a(this.lmv, 0);
        if ((this.lmq == -1) || (this.lmq == 3))
        {
          this.lmC.setVisibility(8);
          this.xy.setVisibility(8);
          getString(2131297087);
          this.gsr = com.tencent.mm.ui.base.h.b(this, getString(2131297112), true, new EmojiStoreDetailUI.5(this));
        }
        bmG();
        if (!this.lnp) {
          break label971;
        }
        paramBundle = new k(this.liu);
        com.tencent.mm.kernel.g.RK().eHt.a(paramBundle, 0);
      }
    }
    for (;;)
    {
      bmJ();
      com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().yNo.add(this);
      com.tencent.mm.sdk.b.a.ymk.c(this.lkn);
      com.tencent.mm.kernel.g.RK().eHt.a(822, this);
      i = getIntent().getIntExtra("extra_status", -1);
      int j = getIntent().getIntExtra("extra_progress", 0);
      h(this.liu, i, j, this.lne);
      this.lns = true;
      com.tencent.mm.plugin.report.service.h.qsU.e(12740, new Object[] { Integer.valueOf(1), "", this.liu, "", Integer.valueOf(this.lnd), Integer.valueOf(26) });
      if ((this.lms) && (this.lmD != null)) {
        this.mHandler.postDelayed(new EmojiStoreDetailUI.22(this), 0L);
      }
      AppMethodBeat.o(53450);
      return;
      if ((!bo.isNullOrNil(this.lkC)) && (this.lkC.equalsIgnoreCase(aa.gP(this.mContext))))
      {
        this.lmv = new com.tencent.mm.plugin.emoji.f.l(this.liu, this.lkj, this.lkB.Version);
        break;
      }
      this.lmv = new com.tencent.mm.plugin.emoji.f.l(this.liu, this.lkj);
      break;
      label971:
      this.lnr = true;
      this.lnq = EmojiLogic.blk();
      continue;
      paramBundle = getContext();
      localObject = new EmotionDetail();
      ((EmotionDetail)localObject).ProductID = EmojiGroupInfo.yPd;
      ((EmotionDetail)localObject).PackName = paramBundle.getString(2131299259);
      ((EmotionDetail)localObject).PackDesc = paramBundle.getString(2131299257);
      ((EmotionDetail)localObject).PackAuthInfo = paramBundle.getString(2131299255);
      ((EmotionDetail)localObject).PackPrice = "";
      ((EmotionDetail)localObject).PackType = 0;
      ((EmotionDetail)localObject).PackFlag = 1;
      ((EmotionDetail)localObject).CoverUrl = "";
      ((EmotionDetail)localObject).PackExpire = 0;
      ((EmotionDetail)localObject).PackCopyright = paramBundle.getString(2131299256);
      ((EmotionDetail)localObject).PanelUrl = "";
      ((EmotionDetail)localObject).PriceNum = "";
      ((EmotionDetail)localObject).PriceType = "";
      ((EmotionDetail)localObject).TimeLimitStr = paramBundle.getString(2131299258);
      this.lkB = ((EmotionDetail)localObject);
      this.lnr = true;
      this.lnq = EmojiLogic.blk();
      bmI();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(53456);
    super.onDestroy();
    com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().yNo.remove(this);
    com.tencent.mm.sdk.b.a.ymk.d(this.lkn);
    com.tencent.mm.kernel.g.RK().eHt.b(822, this);
    if (this.lmK != null) {
      this.lmK.release();
    }
    this.mHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(53456);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(53454);
    super.onPause();
    com.tencent.mm.kernel.g.RK().eHt.b(412, this);
    com.tencent.mm.kernel.g.RK().eHt.b(521, this);
    com.tencent.mm.kernel.g.RK().eHt.b(423, this);
    AppMethodBeat.o(53454);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(53458);
    this.lmu = paramBundle.getInt("status");
    this.ym = paramBundle.getInt("progress");
    AppMethodBeat.o(53458);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(53453);
    super.onResume();
    com.tencent.mm.kernel.g.RK().eHt.a(412, this);
    com.tencent.mm.kernel.g.RK().eHt.a(521, this);
    com.tencent.mm.kernel.g.RK().eHt.a(423, this);
    this.lnn = false;
    if (!this.lns)
    {
      bmG();
      ut(1007);
    }
    bmH();
    this.lns = false;
    ut(1001);
    AppMethodBeat.o(53453);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(53457);
    paramBundle.putInt("status", this.lmu);
    paramBundle.putInt("progress", this.ym);
    AppMethodBeat.o(53457);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(53460);
    ab.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((this.gsr != null) && (this.gsr.isShowing())) {
      this.gsr.dismiss();
    }
    switch (paramm.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(53460);
      return;
      if ((paramm instanceof com.tencent.mm.plugin.emoji.f.l))
      {
        ab.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_GetEmotionDetail");
        paramString = (com.tencent.mm.plugin.emoji.f.l)paramm;
        if ((paramString != null) && (!bo.isNullOrNil(paramString.liu)) && (paramString.liu.equalsIgnoreCase(this.liu)))
        {
          if (paramInt1 == 0)
          {
            if (paramInt2 == 0)
            {
              this.lkB = paramString.blF();
              ut(1002);
              AppMethodBeat.o(53460);
              return;
            }
            if (paramInt2 == 1)
            {
              bmE();
              AppMethodBeat.o(53460);
              return;
            }
            this.lmB.setText(2131299204);
            bmF();
            AppMethodBeat.o(53460);
            return;
          }
          if (paramInt2 == 5)
          {
            if ((paramString != null) && (paramString.blF() != null)) {
              this.lkB.PackFlag = paramString.blF().PackFlag;
            }
            ut(1002);
            AppMethodBeat.o(53460);
            return;
          }
          if (paramInt2 == 1)
          {
            bmE();
            AppMethodBeat.o(53460);
            return;
          }
          this.lmD.setVisibility(8);
          this.xy.setVisibility(0);
          this.lmB.setText(2131299205);
          bmF();
          AppMethodBeat.o(53460);
          return;
        }
        ab.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
        AppMethodBeat.o(53460);
        return;
        if ((paramm instanceof com.tencent.mm.plugin.emoji.f.g))
        {
          ab.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_ExchangeEmotionPack");
          paramString = (com.tencent.mm.plugin.emoji.f.g)paramm;
          if ((paramString == this.lmw) && (!bo.isNullOrNil(paramString.liu)) && (paramString.liu.equalsIgnoreCase(this.liu)))
          {
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              this.lne = paramString.fFo;
              this.lmu = 6;
              bmO();
              AppMethodBeat.o(53460);
              return;
            }
            this.lmu = -1;
            bmO();
            paramString = this.liv;
            com.tencent.mm.ui.base.h.a(this, String.format(getString(2131299194), new Object[] { paramString }), "", new EmojiStoreDetailUI.10(this), new EmojiStoreDetailUI.11(this));
            AppMethodBeat.o(53460);
            return;
          }
          ab.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
          AppMethodBeat.o(53460);
          return;
          ab.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_GetEmotionDesc");
          paramString = (k)paramm;
          if ((paramString != null) && (!bo.isNullOrNil(paramString.lig)) && (paramString.lig.equalsIgnoreCase(this.liu))) {
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              this.lnq = ((ajz)paramString.rr.fsW.fta);
              this.lnr = true;
              bmP();
            }
          }
          for (;;)
          {
            this.lnr = true;
            bmP();
            AppMethodBeat.o(53460);
            return;
            this.lnq = null;
            break;
            ab.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
          }
          if ((paramm instanceof com.tencent.mm.plugin.emoji.f.o))
          {
            ab.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_MMGetEmotionReward");
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              this.lmz = ((com.tencent.mm.plugin.emoji.f.o)paramm).blJ();
              ut(1007);
            }
          }
        }
      }
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(53452);
    super.onStart();
    AppMethodBeat.o(53452);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(53455);
    super.onStop();
    AppMethodBeat.o(53455);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void ut(int paramInt)
  {
    AppMethodBeat.i(53482);
    if (this.mHandler != null) {
      this.mHandler.sendEmptyMessage(paramInt);
    }
    AppMethodBeat.o(53482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI
 * JD-Core Version:    0.7.0.1
 */