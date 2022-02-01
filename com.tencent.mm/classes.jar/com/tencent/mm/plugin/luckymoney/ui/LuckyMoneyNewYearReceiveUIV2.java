package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.aeg;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.hv;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.emoji.model.i.a;
import com.tencent.mm.plugin.emoji.model.s;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.luckymoney.model.aa;
import com.tencent.mm.plugin.luckymoney.model.ac;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.ba;
import com.tencent.mm.plugin.textstatus.a.w.a;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.utils.j;
import com.tencent.mm.plugin.wallet_core.utils.j.a;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.dfc;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.pulldown.c;
import java.util.ArrayList;
import java.util.List;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

@com.tencent.mm.ui.base.a(3)
@c(0)
public class LuckyMoneyNewYearReceiveUIV2
  extends LuckyMoneyBaseUI
{
  private String Ilf;
  private TextView JCr;
  private LuckyMoneyAutoScrollView KDH;
  private TextView KDI;
  private TextView KDJ;
  private LinearLayout KDK;
  private ImageView KDL;
  private LinearLayout KDM;
  private LinearLayout KDN;
  private MMAnimateView KDO;
  private TextView KDP;
  private LinearLayout KDQ;
  private TextView KDR;
  private ImageView KDS;
  private ImageView KDT;
  private MMAnimateView KDU;
  private ImageView KDV;
  private View KDW;
  private BaseEmojiView KDX;
  private boolean KDY;
  private int KDZ;
  private String KEa;
  private String KEb;
  private boolean KEc;
  private View KEi;
  private View KEj;
  private PAGView KEk;
  private PAGView.PAGViewListener KEl;
  private PAGView.PAGViewListener KEm;
  private View KEn;
  private View KEo;
  private TextView KEp;
  private ImageView KEq;
  private View KEr;
  private boolean KEs;
  private boolean KEt;
  private com.tencent.mm.plugin.luckymoney.model.bf KEu;
  private final IListener KEv;
  private View KnV;
  private String KqM;
  public int KuI;
  public aa KuL;
  private String ihx;
  private String imagePath;
  private String lMU;
  private MMHandler mHandler;
  private View plc;
  private com.tencent.mm.ui.base.w tipDialog;
  private TextView ttK;
  private cc wPy;
  private i.a xMB;
  private EmojiInfo xRp;
  private ImageView xaN;
  
  public LuckyMoneyNewYearReceiveUIV2()
  {
    AppMethodBeat.i(284150);
    this.tipDialog = null;
    this.KuI = 0;
    this.KDY = false;
    this.Ilf = "";
    this.KEa = "";
    this.KEb = "";
    this.imagePath = "";
    this.mHandler = new MMHandler();
    this.KEc = false;
    this.KuL = new aa();
    this.KEs = false;
    this.KEt = false;
    this.KEv = new IListener(com.tencent.mm.app.f.hfK) {};
    this.xMB = new i.a()
    {
      public final void a(final boolean paramAnonymousBoolean, final EmojiInfo paramAnonymousEmojiInfo)
      {
        AppMethodBeat.i(284543);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(284215);
            if ((paramAnonymousEmojiInfo != null) && (LuckyMoneyNewYearReceiveUIV2.b(LuckyMoneyNewYearReceiveUIV2.this) != null) && (LuckyMoneyNewYearReceiveUIV2.b(LuckyMoneyNewYearReceiveUIV2.this).getMd5().equals(paramAnonymousEmojiInfo.getMd5())))
            {
              if (paramAnonymousBoolean)
              {
                Log.i("MicroMsg.LuckyMoneyNewYearReceiveUIV2", "somethings success.");
                LuckyMoneyNewYearReceiveUIV2.a(LuckyMoneyNewYearReceiveUIV2.this, s.getEmojiStorageMgr().adju.bza(LuckyMoneyNewYearReceiveUIV2.b(LuckyMoneyNewYearReceiveUIV2.this).getMd5()));
                LuckyMoneyNewYearReceiveUIV2.c(LuckyMoneyNewYearReceiveUIV2.this).setVisibility(8);
                LuckyMoneyNewYearReceiveUIV2.d(LuckyMoneyNewYearReceiveUIV2.this).setVisibility(0);
                LuckyMoneyNewYearReceiveUIV2.d(LuckyMoneyNewYearReceiveUIV2.this).setScaleType(ImageView.ScaleType.CENTER_CROP);
                LuckyMoneyNewYearReceiveUIV2.d(LuckyMoneyNewYearReceiveUIV2.this).setEmojiInfo(LuckyMoneyNewYearReceiveUIV2.b(LuckyMoneyNewYearReceiveUIV2.this));
                AppMethodBeat.o(284215);
                return;
              }
              Log.i("MicroMsg.LuckyMoneyNewYearReceiveUIV2", "somethings error.");
              LuckyMoneyNewYearReceiveUIV2.c(LuckyMoneyNewYearReceiveUIV2.this).setVisibility(8);
              LuckyMoneyNewYearReceiveUIV2.e(LuckyMoneyNewYearReceiveUIV2.this).setVisibility(0);
            }
            AppMethodBeat.o(284215);
          }
        });
        AppMethodBeat.o(284543);
      }
    };
    AppMethodBeat.o(284150);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(284152);
    this.KEs = true;
    doSceneProgress(new ba(paramInt1, paramInt2, paramString1, paramString2, ah.fXi(), com.tencent.mm.model.z.bAO(), getIntent().getStringExtra("key_username"), "v1.0", paramString3), false);
    AppMethodBeat.o(284152);
  }
  
  private void aac(int paramInt)
  {
    AppMethodBeat.i(284156);
    Log.i("MicroMsg.LuckyMoneyNewYearReceiveUIV2", "dealMessageInfo() localReceiveStatus:%s newStatus:%s", new Object[] { Integer.valueOf(this.KDZ), Integer.valueOf(paramInt) });
    if (this.wPy == null)
    {
      Log.i("MicroMsg.LuckyMoneyNewYearReceiveUIV2", "dealMessageInfo() mEmojiInfo == null");
      AppMethodBeat.o(284156);
      return;
    }
    if ((Util.isEqual(this.KDZ, paramInt)) || (Util.isEqual(this.KDZ, 2)))
    {
      AppMethodBeat.o(284156);
      return;
    }
    try
    {
      Object localObject2 = new StringBuilder(this.wPy.field_content);
      Object localObject1 = new StringBuilder();
      int i = ((StringBuilder)localObject2).indexOf("<localreceivestatus>");
      StringBuilder localStringBuilder;
      if ((i > 0) && (i < ((StringBuilder)localObject2).length()))
      {
        localStringBuilder = new StringBuilder(((StringBuilder)localObject2).substring(0, i + 20));
        localObject1 = ((StringBuilder)localObject2).substring(i + 21);
        localStringBuilder.append(paramInt).append((String)localObject1);
      }
      for (;;)
      {
        this.wPy.setContent(localStringBuilder.toString());
        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(this.wPy.field_msgId, this.wPy);
        Log.i("MicroMsg.LuckyMoneyNewYearReceiveUIV2", "dealMessageInfo() success msgXml:%s", new Object[] { localStringBuilder });
        AppMethodBeat.o(284156);
        return;
        i = ((StringBuilder)localObject2).indexOf("<emoji>");
        if ((i > 0) && (i < ((StringBuilder)localObject2).length()))
        {
          ((StringBuilder)localObject1).append("<localreceivestatus>").append(paramInt).append("</localreceivestatus>");
          localStringBuilder = new StringBuilder(((StringBuilder)localObject2).substring(0, i + 7));
          localObject2 = ((StringBuilder)localObject2).substring(i + 7).trim();
          localStringBuilder.append((CharSequence)localObject1).append((String)localObject2);
        }
        else
        {
          i = ((StringBuilder)localObject2).indexOf("<wcpayinfo>");
          ((StringBuilder)localObject1).append("<emoji><localreceivestatus>").append(paramInt).append("</localreceivestatus></emoji>");
          localStringBuilder = new StringBuilder(((StringBuilder)localObject2).substring(0, i));
          localObject2 = ((StringBuilder)localObject2).substring(i).trim();
          localStringBuilder.append((CharSequence)localObject1).append((String)localObject2);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      Log.i("MicroMsg.LuckyMoneyNewYearReceiveUIV2", "dealMessageInfo() Exception:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(284156);
    }
  }
  
  private void aad(final int paramInt)
  {
    AppMethodBeat.i(284160);
    Log.i("MicroMsg.LuckyMoneyNewYearReceiveUIV2", "exchangeExpressionState() state:%s", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.threadpool.h.ahAA.bk(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(284116);
        switch (paramInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(284116);
          return;
          LuckyMoneyNewYearReceiveUIV2.o(LuckyMoneyNewYearReceiveUIV2.this).setVisibility(8);
          LuckyMoneyNewYearReceiveUIV2.p(LuckyMoneyNewYearReceiveUIV2.this).setVisibility(0);
          LuckyMoneyNewYearReceiveUIV2.q(LuckyMoneyNewYearReceiveUIV2.this);
          AppMethodBeat.o(284116);
          return;
          LuckyMoneyNewYearReceiveUIV2.o(LuckyMoneyNewYearReceiveUIV2.this).setVisibility(0);
          LuckyMoneyNewYearReceiveUIV2.p(LuckyMoneyNewYearReceiveUIV2.this).setVisibility(8);
          LuckyMoneyNewYearReceiveUIV2.q(LuckyMoneyNewYearReceiveUIV2.this);
          LuckyMoneyNewYearReceiveUIV2.f(LuckyMoneyNewYearReceiveUIV2.this);
          AppMethodBeat.o(284116);
          return;
          LuckyMoneyNewYearReceiveUIV2.o(LuckyMoneyNewYearReceiveUIV2.this).setVisibility(8);
          LuckyMoneyNewYearReceiveUIV2.p(LuckyMoneyNewYearReceiveUIV2.this).setVisibility(8);
          LuckyMoneyNewYearReceiveUIV2.r(LuckyMoneyNewYearReceiveUIV2.this).setVisibility(0);
          LuckyMoneyNewYearReceiveUIV2.l(LuckyMoneyNewYearReceiveUIV2.this).setVisibility(0);
          LuckyMoneyNewYearReceiveUIV2.a(LuckyMoneyNewYearReceiveUIV2.this, "start");
          AppMethodBeat.o(284116);
          return;
          LuckyMoneyNewYearReceiveUIV2.o(LuckyMoneyNewYearReceiveUIV2.this).setVisibility(0);
          LuckyMoneyNewYearReceiveUIV2.p(LuckyMoneyNewYearReceiveUIV2.this).setVisibility(8);
          LuckyMoneyNewYearReceiveUIV2.d(LuckyMoneyNewYearReceiveUIV2.this).setVisibility(8);
          LuckyMoneyNewYearReceiveUIV2.c(LuckyMoneyNewYearReceiveUIV2.this).setVisibility(0);
          LuckyMoneyNewYearReceiveUIV2.s(LuckyMoneyNewYearReceiveUIV2.this).setImageResource(a.h.lucky_money_newyear_creat_loading);
          LuckyMoneyNewYearReceiveUIV2.s(LuckyMoneyNewYearReceiveUIV2.this).setImageResource(a.e.lucky_money_newyear_loading_anim);
          RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
          localRotateAnimation.setDuration(1000L);
          localRotateAnimation.setRepeatCount(-1);
          localRotateAnimation.setInterpolator(new LinearInterpolator());
          LuckyMoneyNewYearReceiveUIV2.s(LuckyMoneyNewYearReceiveUIV2.this).startAnimation(localRotateAnimation);
          LuckyMoneyNewYearReceiveUIV2.a(LuckyMoneyNewYearReceiveUIV2.this).alive();
          ac.ka(LuckyMoneyNewYearReceiveUIV2.this.KuL.Ktr, LuckyMoneyNewYearReceiveUIV2.this.KuL.pdv);
        }
      }
    });
    AppMethodBeat.o(284160);
  }
  
  private void fYz()
  {
    AppMethodBeat.i(284165);
    this.KEj.setVisibility(8);
    this.KEk.setVisibility(8);
    ac.a(this.KEk, this.KEl, this.KEm);
    AppMethodBeat.o(284165);
  }
  
  private void ye(boolean paramBoolean)
  {
    AppMethodBeat.i(284158);
    if (paramBoolean)
    {
      this.KDQ.setVisibility(8);
      ((RelativeLayout.LayoutParams)this.KDQ.getLayoutParams()).addRule(3, a.f.lucky_money_newyear_receive_invalid_status);
      this.KDR.setText(getString(a.i.lucky_money_see_detail));
      this.KDQ.setOnClickListener(new LuckyMoneyNewYearReceiveUIV2.3(this));
      AppMethodBeat.o(284158);
      return;
    }
    this.KDQ.setVisibility(8);
    this.KDQ.setOnClickListener(new LuckyMoneyNewYearReceiveUIV2.4(this));
    this.KDR.setText(getString(a.i.lucky_money_saved_tips));
    AppMethodBeat.o(284158);
  }
  
  private void yf(boolean paramBoolean)
  {
    AppMethodBeat.i(284169);
    if (!Util.isNullOrNil(this.KuL.Kts))
    {
      Log.i("MicroMsg.LuckyMoneyNewYearReceiveUIV2", "show StatusLayout:%s", new Object[] { this.KuL.Kts });
      if (paramBoolean) {
        ac.hY(this.KEn);
      }
      for (;;)
      {
        this.KEp.setText(getString(a.i.lucky_money_newyear_status_click_tips_right, new Object[] { this.KuL.Kts }));
        ((com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class)).setIcon(this.KEq, "2022_hb", com.tencent.mm.plugin.textstatus.a.a.c.ThO, com.tencent.mm.plugin.textstatus.a.a.a.Thr);
        this.KEn.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(284541);
            Object localObject1 = new b();
            ((b)localObject1).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUIV2$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aYj());
            Log.i("MicroMsg.LuckyMoneyNewYearReceiveUIV2", "click StatusLayout");
            com.tencent.mm.plugin.report.service.h.OAn.b(13079, new Object[] { Integer.valueOf(11), Integer.valueOf(2) });
            paramAnonymousView = new hv();
            paramAnonymousView.iPe = 15L;
            paramAnonymousView.bMH();
            paramAnonymousView = new w.a();
            localObject1 = new ArrayList();
            Object localObject2 = new TextStatusJumpInfo();
            ((TextStatusJumpInfo)localObject2).jumpType = "3";
            ((TextStatusJumpInfo)localObject2).busiBuf = "https://support.weixin.qq.com/security/readtemplate?t=w_security_center_website/upgrade&scene=1#wechat_redirect";
            ((List)localObject1).add(localObject2);
            localObject2 = paramAnonymousView.bdr("2022_hb").bdu("red_packet_2022@inner");
            String str = LuckyMoneyNewYearReceiveUIV2.this.KuL.videoUrl;
            ((w.a)localObject2).ThS.Tog.mediaUrl = str;
            str = LuckyMoneyNewYearReceiveUIV2.this.KuL.Ktu;
            ((w.a)localObject2).ThS.Tog.mediaThumbUrl = str;
            int i = LuckyMoneyNewYearReceiveUIV2.this.KuL.videoWidth;
            ((w.a)localObject2).ThS.Tog.mediaWidth = i;
            i = LuckyMoneyNewYearReceiveUIV2.this.KuL.videoHeight;
            ((w.a)localObject2).ThS.Tog.mediaHeight = i;
            ((w.a)localObject2).bdw(LuckyMoneyNewYearReceiveUIV2.this.KuL.verifyInfo).bdx(LuckyMoneyNewYearReceiveUIV2.this.KuL.Kts).aol(2).ls((List)localObject1);
            ((com.tencent.mm.plugin.textstatus.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.textstatus.a.n.class)).a(LuckyMoneyNewYearReceiveUIV2.this.getContext(), paramAnonymousView.ThS);
            LuckyMoneyNewYearReceiveUIV2.this.finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUIV2$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(284541);
          }
        });
        AppMethodBeat.o(284169);
        return;
        this.KEn.setVisibility(0);
      }
    }
    this.KEn.setVisibility(8);
    AppMethodBeat.o(284169);
  }
  
  public int getLayoutId()
  {
    return a.g.lucky_money_newyear_receive_ui_v2;
  }
  
  public void initView()
  {
    AppMethodBeat.i(284274);
    setActionbarColor(-839716110);
    this.plc = findViewById(a.f.lucky_money_new_year_receive_root);
    if (aw.isDarkMode())
    {
      this.plc.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.c.BW_0_Alpha_0_8);
      setActionbarColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.BW_0_Alpha_0_8));
      setNavigationbarColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.BW_0_Alpha_0_8));
    }
    for (;;)
    {
      this.KnV = findViewById(a.f.lucky_money_newyear_receive_ll);
      this.KDH = ((LuckyMoneyAutoScrollView)findViewById(a.f.lucky_money_newyear_receive_amount));
      this.KDI = ((TextView)findViewById(a.f.lucky_money_amount_unit_title_tv));
      this.JCr = ((TextView)findViewById(a.f.lucky_money_newyear_receive_wishing));
      this.xaN = ((ImageView)findViewById(a.f.lucky_money_newyear_receive_avatar));
      this.KDK = ((LinearLayout)findViewById(a.f.lucky_money_newyear_receive_status_layout));
      this.ttK = ((TextView)findViewById(a.f.lucky_money_newyear_receive_status));
      this.KDL = ((ImageView)findViewById(a.f.lucky_money_newyear_receive_status_icon));
      this.KDJ = ((TextView)findViewById(a.f.lucky_money_newyear_receive_title));
      this.KDM = ((LinearLayout)findViewById(a.f.lucky_money_newyear_receive_senderdesc));
      this.KDU = ((MMAnimateView)findViewById(a.f.particle_gif_image));
      this.KDV = ((ImageView)findViewById(a.f.lucky_money_new_year_good));
      this.KDW = findViewById(a.f.lucky_money_new_year_expression_layout);
      this.KDX = ((BaseEmojiView)findViewById(a.f.lucky_money_new_year_expression));
      this.KDP = ((TextView)findViewById(a.f.lucky_money_new_year_reload_expression));
      this.KDN = ((LinearLayout)findViewById(a.f.lucky_money_new_year_loading_expression));
      this.KDO = ((MMAnimateView)findViewById(a.f.loading_image));
      this.KDQ = ((LinearLayout)findViewById(a.f.lucky_money_click_area));
      this.KDR = ((TextView)findViewById(a.f.lucky_money_click_tv));
      this.KEn = findViewById(a.f.lucky_money_newyear_status_click_area_container);
      this.KEo = findViewById(a.f.lucky_money_newyear_status_click_area_ll);
      this.KEp = ((TextView)findViewById(a.f.lucky_money_newyear_status_tips_right));
      this.KEq = ((ImageView)findViewById(a.f.lucky_money_newyear_status_tips_iv));
      this.KEr = findViewById(a.f.lucky_money_newyear_status_line);
      this.KEr.setAlpha(0.3F);
      this.KEj = findViewById(a.f.lucky_money_new_year_pag_video_layout);
      this.KEk = ((PAGView)findViewById(a.f.lucky_money_new_year_pag_video_receive));
      this.KEl = new PAGView.PAGViewListener()
      {
        public final void onAnimationCancel(PAGView paramAnonymousPAGView) {}
        
        public final void onAnimationEnd(PAGView paramAnonymousPAGView)
        {
          AppMethodBeat.i(284127);
          LuckyMoneyNewYearReceiveUIV2.a(LuckyMoneyNewYearReceiveUIV2.this, "loop");
          AppMethodBeat.o(284127);
        }
        
        public final void onAnimationRepeat(PAGView paramAnonymousPAGView) {}
        
        public final void onAnimationStart(PAGView paramAnonymousPAGView) {}
      };
      this.KEm = new PAGView.PAGViewListener()
      {
        public final void onAnimationCancel(PAGView paramAnonymousPAGView) {}
        
        public final void onAnimationEnd(PAGView paramAnonymousPAGView) {}
        
        public final void onAnimationRepeat(PAGView paramAnonymousPAGView) {}
        
        public final void onAnimationStart(PAGView paramAnonymousPAGView) {}
      };
      this.KEk.addListener(this.KEl);
      this.KEk.setRepeatCount(1);
      this.KEk.setScaleMode(3);
      this.KDP.setOnClickListener(new LuckyMoneyNewYearReceiveUIV2.12(this));
      this.KDS = ((ImageView)findViewById(a.f.lucky_money_new_year_take_cancle_iv));
      this.KDS.setOnClickListener(new LuckyMoneyNewYearReceiveUIV2.13(this));
      this.KEi = findViewById(a.f.lucky_money_new_year_bottom_ll);
      this.KDT = ((ImageView)findViewById(a.f.lucky_money_new_year_take_cancle_good_iv));
      this.KDT.setOnClickListener(new LuckyMoneyNewYearReceiveUIV2.14(this));
      setContentViewVisibility(8);
      this.tipDialog = k.a(getContext(), getString(a.i.loading_tips), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(284490);
          if ((LuckyMoneyNewYearReceiveUIV2.g(LuckyMoneyNewYearReceiveUIV2.this) != null) && (LuckyMoneyNewYearReceiveUIV2.g(LuckyMoneyNewYearReceiveUIV2.this).isShowing())) {
            LuckyMoneyNewYearReceiveUIV2.g(LuckyMoneyNewYearReceiveUIV2.this).dismiss();
          }
          LuckyMoneyNewYearReceiveUIV2.this.KzD.forceCancel();
          if ((LuckyMoneyNewYearReceiveUIV2.h(LuckyMoneyNewYearReceiveUIV2.this).getVisibility() == 8) || (LuckyMoneyNewYearReceiveUIV2.i(LuckyMoneyNewYearReceiveUIV2.this).getVisibility() == 4))
          {
            Log.i("MicroMsg.LuckyMoneyNewYearReceiveUIV2", "usr cancel, & visibility not visiable, so finish");
            LuckyMoneyNewYearReceiveUIV2.this.finish();
          }
          AppMethodBeat.o(284490);
        }
      });
      Log.i("MicroMsg.LuckyMoneyNewYearReceiveUIV2", "setBackgroundContainerSize");
      Object localObject1 = com.tencent.mm.ui.bf.bf(getContext());
      int i = ((Point)localObject1).x;
      int j = ((Point)localObject1).y;
      int k = com.tencent.mm.ui.bf.getStatusBarHeight(getContext());
      int m = com.tencent.mm.ui.bf.bk(getContext());
      int n = com.tencent.mm.cd.a.fromDPToPix(getContext(), 320);
      int i1 = com.tencent.mm.cd.a.fromDPToPix(getContext(), 560);
      localObject1 = this.KnV.getLayoutParams();
      int i2 = com.tencent.mm.cd.a.fromDPToPix(getContext(), 48) + com.tencent.mm.cd.a.fromDPToPix(getContext(), 40);
      Log.i("MicroMsg.LuckyMoneyNewYearReceiveUIV2", "screenWidth：%s containerRealWidth:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(n) });
      if (i <= n)
      {
        Log.i("MicroMsg.LuckyMoneyNewYearReceiveUIV2", "need adjust width");
        ((ViewGroup.LayoutParams)localObject1).width = (i - com.tencent.mm.cd.a.fromDPToPix(getContext(), 48));
      }
      Log.i("MicroMsg.LuckyMoneyNewYearReceiveUIV2", "carsonhe screenHeighh：%s  statusHeight:%s containerRealHeight + buttonHeight:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i1 + i2) });
      if (j - k - m < i1 + i2)
      {
        this.KEt = true;
        Log.i("MicroMsg.LuckyMoneyNewYearReceiveUIV2", "need adjust height");
        ((ViewGroup.LayoutParams)localObject1).height = (j - k - m - i2);
        Object localObject2 = (RelativeLayout.LayoutParams)findViewById(a.f.lucky_money_newyear_receive_desc_area).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 72);
        findViewById(a.f.lucky_money_newyear_receive_desc_area).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = (RelativeLayout.LayoutParams)this.KEr.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 36);
        this.KEr.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = (RelativeLayout.LayoutParams)this.KEn.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 6);
        this.KEn.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = (RelativeLayout.LayoutParams)this.KDM.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 6);
        this.KDM.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = (LinearLayout.LayoutParams)this.KEi.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 24);
        this.KEi.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      this.KnV.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      AppMethodBeat.o(284274);
      return;
      this.plc.setBackgroundColor(-839716110);
      setActionbarColor(-839716110);
      setNavigationbarColor(-839716110);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(284261);
    super.onCreate(paramBundle);
    this.lMU = getIntent().getStringExtra("key_username");
    this.Ilf = getIntent().getStringExtra("key_emoji_md5");
    long l = getIntent().getLongExtra("key_msgid", 0L);
    this.wPy = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().sl(l);
    this.KDZ = getIntent().getIntExtra("key_msg_newyear_localreceivestatus", 0);
    this.ihx = getIntent().getStringExtra("key_native_url");
    Log.i("MicroMsg.LuckyMoneyNewYearReceiveUIV2", "emojiMd5:" + this.Ilf);
    paramBundle = Uri.parse(Util.nullAsNil(this.ihx));
    try
    {
      this.KqM = paramBundle.getQueryParameter("sendid");
      initView();
      if (!Util.isNullOrNil(this.KqM))
      {
        doSceneProgress(new com.tencent.mm.plugin.luckymoney.model.bf(Util.getInt(paramBundle.getQueryParameter("channelid"), 1), this.KqM, this.ihx, 1, "v1.0", ""), false);
        if (this.tipDialog != null) {
          this.tipDialog.show();
        }
        AppMethodBeat.o(284261);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.i("MicroMsg.LuckyMoneyNewYearReceiveUIV2", "onCreate() Exception:%s", new Object[] { localException.getMessage() });
      }
      finish();
      Log.w("MicroMsg.LuckyMoneyNewYearReceiveUIV2", "sendid null & finish");
      AppMethodBeat.o(284261);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(284268);
    super.onDestroy();
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    s.dAj().xMB = null;
    fYz();
    if (this.KDO != null)
    {
      this.KDO.pause();
      this.KDO.stop();
    }
    this.KEv.dead();
    AppMethodBeat.o(284268);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(284265);
    super.onResume();
    if (this.KEc) {
      finish();
    }
    AppMethodBeat.o(284265);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, p paramp)
  {
    AppMethodBeat.i(284282);
    Log.i("MicroMsg.LuckyMoneyNewYearReceiveUIV2", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramp.getType());
    label353:
    boolean bool;
    if ((paramp instanceof com.tencent.mm.plugin.luckymoney.model.bf))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (com.tencent.mm.plugin.luckymoney.model.bf)paramp;
        this.KEu = paramString;
        this.KuI = paramString.KuI;
        if (paramString.fXn())
        {
          Log.i("MicroMsg.LuckyMoneyNewYearReceiveUIV2", "is Sender hb!");
          if (paramString.ihz != 4) {
            this.KDM.setVisibility(8);
          }
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          if (paramString.ihz != 5)
          {
            paramp = com.tencent.mm.wallet_core.ui.i.formatMoney2f(paramString.KuU / 100.0D);
            this.KDH.setContentDescription(paramp);
            this.KDH.setFinalText(paramp);
            this.KDH.fYc();
            ah.a(getContext(), this.JCr, paramString.Kmq);
            this.KDK.setVisibility(8);
            this.KDM.setVisibility(0);
            this.KEr.setVisibility(0);
            if (paramString.ihz == 4)
            {
              a.b.h(this.xaN, this.lMU);
              aac(2);
              this.KDJ.setText(paramString.KrL);
              this.KDJ.setTextSize(1, 16.0F);
              if (!this.KEt)
              {
                paramp = (RelativeLayout.LayoutParams)this.KDM.getLayoutParams();
                paramp.bottomMargin = com.tencent.mm.cd.a.fromDPToPix(this, 20);
                this.KDM.setLayoutParams(paramp);
              }
              this.KDM.invalidate();
              findViewById(a.f.lucky_money_newyear_receive_desc_area).setVisibility(0);
              this.KEr.setVisibility(0);
              setContentViewVisibility(0);
              ah.a(this.KnV, null);
              this.KDS.setVisibility(0);
              this.KDT.setVisibility(8);
              if (!this.KEs)
              {
                this.KuL = paramString.KuL;
                if (!paramString.fXn()) {
                  yf(false);
                }
                bool = true;
                if ((paramString.ihz == 5) || (paramString.ihz == 1)) {
                  bool = false;
                }
                Log.i("MicroMsg.LuckyMoneyNewYearReceiveUIV2", "receiveScene.hbStatus is " + paramString.ihz + ", isValidStatus is " + bool);
                if ((!Util.isEqual(this.KuI, 1)) || (Util.isNullOrNil(this.Ilf))) {
                  break label1214;
                }
                paramInt1 = 1;
                label492:
                if ((paramInt1 == 0) || (!bool)) {
                  break label1219;
                }
                aad(2);
              }
            }
          }
        }
        for (;;)
        {
          this.KDH.jF(getResources().getDimensionPixelOffset(a.d.lucky_money_newyear_num_width_for_normal), getResources().getDimensionPixelOffset(a.d.lucky_money_newyear_num_height_for_normal));
          this.KDH.invalidate();
          this.JCr.setVisibility(0);
          this.KEr.setVisibility(0);
          AppMethodBeat.o(284282);
          return true;
          this.xaN.setVisibility(8);
          break;
          findViewById(a.f.lucky_money_newyear_receive_desc_area).setVisibility(8);
          ((TextView)findViewById(a.f.lucky_money_newyear_receive_invalid_status)).setText(paramString.KrL);
          ((TextView)findViewById(a.f.lucky_money_newyear_receive_invalid_status)).setVisibility(0);
          ((TextView)findViewById(a.f.lucky_money_newyear_receive_invalid_status)).setTextSize(24.0F);
          ye(true);
          aac(1);
          break label353;
          Log.i("MicroMsg.LuckyMoneyNewYearReceiveUIV2", "is receiver hb!");
          if (!TextUtils.isEmpty(getIntent().getStringExtra("key_username")))
          {
            a.b.h(this.xaN, getIntent().getStringExtra("key_username"));
            label688:
            this.KDJ.setTextSize(1, 16.0F);
            ah.a(getContext(), this.KDJ, paramString.KuS + getString(a.i.lucky_money_newyear_send_hb));
            if (!this.KEt)
            {
              paramp = (RelativeLayout.LayoutParams)this.KDM.getLayoutParams();
              paramp.bottomMargin = com.tencent.mm.cd.a.fromDPToPix(this, 20);
              this.KDM.setLayoutParams(paramp);
            }
            this.KDM.invalidate();
            this.KDM.setVisibility(8);
            this.KDK.setVisibility(8);
            if ((paramString.ihA != 0) || (paramString.ihz == 4) || (paramString.ihz == 5) || (paramString.ihz == 1)) {
              break label1007;
            }
            if (!"0".equals(paramString.Kua)) {
              break label980;
            }
            com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, this.KzD, paramString.Kub, paramString.Kuc, paramString.Kud, paramString.Kue, new com.tencent.mm.plugin.wallet_core.id_verify.util.a.a()
            {
              public final boolean run(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(284518);
                Log.i("MicroMsg.LuckyMoneyNewYearReceiveUIV2", "showDisclaimerDialog resultCode=" + paramAnonymousInt1 + ";errCode=" + paramAnonymousInt2 + ";errMsg=" + paramAnonymousString + ";hadAgree = " + paramAnonymousBoolean);
                if (paramAnonymousInt1 == 1) {
                  LuckyMoneyNewYearReceiveUIV2.this.finish();
                }
                for (;;)
                {
                  AppMethodBeat.o(284518);
                  return true;
                  if (paramAnonymousInt1 == 2) {
                    LuckyMoneyNewYearReceiveUIV2.a(LuckyMoneyNewYearReceiveUIV2.this, paramString.msgType, paramString.channelId, paramString.CAf, paramString.ihx, paramString.KuX);
                  } else if ((paramAnonymousInt1 == 0) && (paramAnonymousBoolean)) {
                    LuckyMoneyNewYearReceiveUIV2.a(LuckyMoneyNewYearReceiveUIV2.this, paramString.msgType, paramString.channelId, paramString.CAf, paramString.ihx, paramString.KuX);
                  }
                }
              }
            });
          }
          for (;;)
          {
            paramp = (LinearLayout.LayoutParams)this.KDK.getLayoutParams();
            paramp.topMargin = getResources().getDimensionPixelOffset(a.d.lucky_money_newyear_receive_status_layout_top_margin_for_receiver);
            this.KDK.setLayoutParams(paramp);
            this.KDK.invalidate();
            this.ttK.setTextSize(1, 12.0F);
            this.KDS.setVisibility(8);
            this.KDT.setVisibility(0);
            break;
            if (TextUtils.isEmpty(paramString.KrO)) {
              break label688;
            }
            ah.a(this.xaN, paramString.KrO, paramString.Ksi);
            break label688;
            label980:
            a(paramString.msgType, paramString.channelId, paramString.CAf, paramString.ihx, paramString.KuX);
          }
          label1007:
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          if (paramString.ihz != 5)
          {
            paramp = com.tencent.mm.wallet_core.ui.i.formatMoney2f(paramString.KuU / 100.0D);
            this.KDH.setContentDescription(paramp);
            this.KDH.setFinalText(paramp);
            this.KDH.fYc();
            ah.a(getContext(), this.JCr, paramString.Kmq);
            aac(2);
            ye(false);
            this.KEr.setVisibility(0);
            findViewById(a.f.lucky_money_newyear_receive_desc_area).setVisibility(0);
          }
          for (;;)
          {
            setContentViewVisibility(0);
            ah.a(this.KnV, null);
            break;
            this.KDQ.setVisibility(8);
            findViewById(a.f.lucky_money_newyear_receive_desc_area).setVisibility(8);
            ((TextView)findViewById(a.f.lucky_money_newyear_receive_invalid_status)).setText(paramString.KrL);
            ((TextView)findViewById(a.f.lucky_money_newyear_receive_invalid_status)).setVisibility(0);
            ((TextView)findViewById(a.f.lucky_money_newyear_receive_invalid_status)).setTextSize(24.0F);
            aac(1);
          }
          label1214:
          paramInt1 = 0;
          break label492;
          label1219:
          if (ac.fXh()) {
            aad(1);
          } else {
            aad(3);
          }
        }
      }
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      AppMethodBeat.o(284282);
      return false;
    }
    if ((paramp instanceof ba))
    {
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ba)paramp;
        if (j.a(paramString.KtV))
        {
          setContentViewVisibility(4);
          new j(this).a(paramString.KtV, new j.a()
          {
            public final void a(dfc paramAnonymousdfc)
            {
              AppMethodBeat.i(284508);
              if (paramAnonymousdfc.action == 2)
              {
                Log.i("MicroMsg.LuckyMoneyNewYearReceiveUIV2", "click left button");
                LuckyMoneyNewYearReceiveUIV2.a(LuckyMoneyNewYearReceiveUIV2.this, LuckyMoneyNewYearReceiveUIV2.j(LuckyMoneyNewYearReceiveUIV2.this).msgType, LuckyMoneyNewYearReceiveUIV2.j(LuckyMoneyNewYearReceiveUIV2.this).channelId, LuckyMoneyNewYearReceiveUIV2.j(LuckyMoneyNewYearReceiveUIV2.this).CAf, LuckyMoneyNewYearReceiveUIV2.j(LuckyMoneyNewYearReceiveUIV2.this).ihx, LuckyMoneyNewYearReceiveUIV2.j(LuckyMoneyNewYearReceiveUIV2.this).KuX, paramString.KuK);
                AppMethodBeat.o(284508);
                return;
              }
              Log.i("MicroMsg.LuckyMoneyNewYearReceiveUIV2", "click right button");
              LuckyMoneyNewYearReceiveUIV2.this.finish();
              AppMethodBeat.o(284508);
            }
          });
          AppMethodBeat.o(284282);
          return true;
        }
        setContentViewVisibility(0);
        this.KEs = false;
        this.KuI = paramString.KuI;
        this.KuL = paramString.KuL;
        this.KDH.jF(getResources().getDimensionPixelOffset(a.d.lucky_money_newyear_num_width_for_normal), getResources().getDimensionPixelOffset(a.d.lucky_money_newyear_num_height_for_normal));
        this.KDH.invalidate();
        this.JCr.setVisibility(0);
        if (!Util.isEqual(this.KuI, 1)) {
          if (ac.fXh()) {
            aad(1);
          }
        }
        for (;;)
        {
          paramp = paramString.KtU;
          this.ttK.setText(paramString.KtU.KrL);
          com.tencent.threadpool.h.ahAA.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(284484);
              LuckyMoneyNewYearReceiveUIV2.a(LuckyMoneyNewYearReceiveUIV2.this, paramString);
              AppMethodBeat.o(284484);
            }
          }, 500L);
          if ((paramp.ihz == 4) && (!TextUtils.isEmpty(paramString.KtU.KrL))) {
            this.KDL.setVisibility(8);
          }
          ye(false);
          setContentViewVisibility(0);
          ah.a(this.KnV, null);
          aac(2);
          AppMethodBeat.o(284282);
          return true;
          aad(3);
          continue;
          if (!Util.isNullOrNil(this.Ilf)) {
            aad(2);
          } else if (ac.fXh()) {
            aad(1);
          } else {
            aad(3);
          }
        }
      }
      if (paramInt2 == 416)
      {
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.dismiss();
        }
        this.KEc = true;
        paramString = new Bundle();
        paramString.putString("realname_verify_process_jump_activity", ".pay.ui.WalletPayUChangeBankcardUI");
        paramString.putString("realname_verify_process_jump_plugin", "wallet_payu");
        bool = ah.a(this, paramInt2, paramp, paramString, true, null, null, 1004);
        AppMethodBeat.o(284282);
        return bool;
      }
      paramp = paramString;
      if (TextUtils.isEmpty(paramString)) {
        paramp = getString(a.i.wallet_unknown_err);
      }
      k.a(this, paramp, null, false, new LuckyMoneyNewYearReceiveUIV2.2(this));
      AppMethodBeat.o(284282);
      return true;
    }
    AppMethodBeat.o(284282);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUIV2
 * JD-Core Version:    0.7.0.1
 */