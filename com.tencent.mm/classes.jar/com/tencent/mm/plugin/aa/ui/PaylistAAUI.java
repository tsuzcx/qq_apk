package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelimage.s.a;
import com.tencent.mm.plugin.aa.model.b.g;
import com.tencent.mm.plugin.aa.model.b.g.d;
import com.tencent.mm.plugin.aa.model.b.g.e;
import com.tencent.mm.plugin.aa.model.j;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.utils.WcPayTextApppearanceSpan;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.ad;
import com.tencent.mm.protocal.protobuf.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k.b;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.view.ViewAnimHelper;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.WcPayBannerView;
import com.tencent.mm.wallet_core.ui.f.a;
import com.tencent.mm.wallet_core.ui.i;
import com.tencent.mm.wallet_core.ui.l;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PaylistAAUI
  extends BaseAAPresenterActivity
{
  private static int pMD = 1;
  private static int pME = 2;
  private static int pMF = 3;
  private static int pMG = 4;
  private String hCI;
  private String hWQ;
  private int pIC;
  private Dialog pIQ;
  private Dialog pIx;
  private String pJn;
  private String pJo;
  private String pJq;
  private g pJr;
  private View pKd;
  private WcPayBannerView pLM;
  private String pMA;
  private int pMB;
  private long pMC;
  private com.tencent.mm.plugin.aa.model.b.f pMj;
  private LinearLayout pMk;
  private LinearLayout pMl;
  private LinearLayout pMm;
  private LinearLayout pMn;
  private LinearLayout pMo;
  private RelativeLayout pMp;
  private WalletTextView pMq;
  private Button pMr;
  private TextView pMs;
  private TextView pMt;
  private String pMu;
  private TextView pMv;
  private TextView pMw;
  private TextView pMx;
  private TextView pMy;
  private String pMz;
  private String title;
  
  public PaylistAAUI()
  {
    AppMethodBeat.i(63734);
    this.pJr = ((g)aI(g.class));
    this.pMj = ((com.tencent.mm.plugin.aa.model.b.f)aM(com.tencent.mm.plugin.aa.model.b.f.class));
    this.pIQ = null;
    this.pIx = null;
    AppMethodBeat.o(63734);
  }
  
  private void a(final TextView paramTextView, SpannableString paramSpannableString, String paramString, final com.tencent.mm.protocal.protobuf.z paramz)
  {
    AppMethodBeat.i(268521);
    Object localObject1 = getResources().getDrawable(a.h.icons_outlined_album);
    ((Drawable)localObject1).setColorFilter(getResources().getColor(a.c.Link), PorterDuff.Mode.SRC_ATOP);
    ((Drawable)localObject1).setBounds(0, 0, bd.fromDPToPix(getContext(), 20), bd.fromDPToPix(getContext(), 20));
    localObject1 = new com.tencent.mm.ui.widget.a((Drawable)localObject1, 1);
    com.tencent.mm.wallet_core.ui.f localf = new com.tencent.mm.wallet_core.ui.f(new f.a()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(268537);
        Log.i("MicroMsg.Aa.PaylistAAUI", "launcherTipTv img click");
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(268472);
            com.tencent.mm.plugin.report.service.h.OAn.b(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(12), Integer.valueOf(PaylistAAUI.c(PaylistAAUI.this)) });
            if (PaylistAAUI.h(PaylistAAUI.this) == null) {
              PaylistAAUI.a(PaylistAAUI.this, com.tencent.mm.ui.base.k.a(PaylistAAUI.this, 3, a.j.LuckyMoneyNoAnimDialog, PaylistAAUI.this.getString(a.i.loading_tips), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                {
                  AppMethodBeat.i(268423);
                  if ((PaylistAAUI.h(PaylistAAUI.this) != null) && (PaylistAAUI.h(PaylistAAUI.this).isShowing())) {
                    PaylistAAUI.h(PaylistAAUI.this).dismiss();
                  }
                  AppMethodBeat.o(268423);
                }
              }));
            }
            r.bKd().a(PaylistAAUI.27.this.pMS.YzT, new s.a()
            {
              public final void onLoadImageEnd(String paramAnonymous3String1, Bitmap paramAnonymous3Bitmap, String paramAnonymous3String2)
              {
                AppMethodBeat.i(268428);
                Log.i("MicroMsg.Aa.PaylistAAUI", "onLoadImageEnd() url:%s path:%s", new Object[] { paramAnonymous3String1, paramAnonymous3String2 });
                if ((PaylistAAUI.h(PaylistAAUI.this) != null) && (PaylistAAUI.h(PaylistAAUI.this).isShowing())) {
                  PaylistAAUI.h(PaylistAAUI.this).dismiss();
                }
                if (paramAnonymous3Bitmap != null)
                {
                  paramAnonymous3String1 = new Intent();
                  paramAnonymous3String1.putExtra("use_scene", 2);
                  paramAnonymous3String1.putExtra("scene", 1);
                  paramAnonymous3String1.putExtra("url", PaylistAAUI.27.this.pMS.YzT);
                  paramAnonymous3String1.putExtra("path", paramAnonymous3String2);
                  paramAnonymous3Bitmap = ViewAnimHelper.z(PaylistAAUI.27.this.lKF, PaylistAAUI.this.getContext().getWindow().getDecorView());
                  paramAnonymous3String2 = paramAnonymous3Bitmap.agcX;
                  paramAnonymous3String2.right = (paramAnonymous3String2.left + com.tencent.mm.cd.a.fromDPToPix(PaylistAAUI.this.getContext(), 30));
                  paramAnonymous3Bitmap.agcX.set(paramAnonymous3String2);
                  paramAnonymous3String1.putExtra("view_info", paramAnonymous3Bitmap);
                  paramAnonymous3String1.putExtra("aa_type", PaylistAAUI.c(PaylistAAUI.this));
                  com.tencent.mm.br.c.b(PaylistAAUI.this, "aa", ".ui.AAImagPreviewUI", paramAnonymous3String1, 100);
                  AppMethodBeat.o(268428);
                  return;
                }
                Toast.makeText(PaylistAAUI.this, a.i.aa_list_load_img_fail, 1).show();
                AppMethodBeat.o(268428);
              }
            });
            AppMethodBeat.o(268472);
          }
        });
        AppMethodBeat.o(268537);
      }
    });
    final SpannableStringBuilder localSpannableStringBuilder2 = new SpannableStringBuilder(paramSpannableString);
    SpannableStringBuilder localSpannableStringBuilder1 = new SpannableStringBuilder(paramString);
    if (!Util.isNullOrNil(paramz.YzT))
    {
      localSpannableStringBuilder2.setSpan(localObject1, 0, 1, 17);
      localSpannableStringBuilder2.setSpan(localf, 0, localSpannableStringBuilder1.length(), 18);
    }
    Object localObject2 = paramTextView.getPaint();
    int i = paramTextView.getMeasuredWidth();
    float f1 = ((TextPaint)localObject2).measureText(" ...  ");
    float f2 = bd.fromDPToPix(getContext(), 19);
    float f3 = i;
    paramString = new StaticLayout(localSpannableStringBuilder2, (TextPaint)localObject2, i, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    i = paramString.getLineCount();
    Log.d("MicroMsg.Aa.PaylistAAUI", "lineCount ： %s", new Object[] { Integer.valueOf(i) });
    if (i <= 0)
    {
      Log.i("MicroMsg.Aa.PaylistAAUI", "lineCount <= 0");
      AppMethodBeat.o(268521);
      return;
    }
    if (i <= 2)
    {
      paramTextView.setText(localSpannableStringBuilder2);
      AppMethodBeat.o(268521);
      return;
    }
    i = paramString.getLineEnd(0);
    localSpannableStringBuilder2 = new SpannableStringBuilder(paramSpannableString.subSequence(0, i + new StaticLayout(paramSpannableString.subSequence(i, paramSpannableString.length()), (TextPaint)localObject2, (int)(f3 - (f1 + f2)), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false).getLineEnd(0)));
    localSpannableStringBuilder2.append(" ...  ");
    if (!Util.isNullOrNil(paramz.YzT))
    {
      localSpannableStringBuilder2.setSpan(localObject1, 0, 1, 17);
      localSpannableStringBuilder2.setSpan(localf, 0, localSpannableStringBuilder1.length(), 18);
    }
    localObject2 = getResources().getDrawable(a.h.aa_paylist_unfold);
    ((Drawable)localObject2).setColorFilter(getResources().getColor(a.c.FG_2), PorterDuff.Mode.SRC_ATOP);
    ((Drawable)localObject2).setBounds(0, 0, bd.fromDPToPix(getContext(), 19), bd.fromDPToPix(getContext(), 19));
    localSpannableStringBuilder2.setSpan(new com.tencent.mm.ui.widget.a((Drawable)localObject2, 1), localSpannableStringBuilder2.length() - 1, localSpannableStringBuilder2.length(), 33);
    localObject2 = new SpannableStringBuilder(paramSpannableString);
    ((SpannableStringBuilder)localObject2).append(" ");
    if (!Util.isNullOrNil(paramz.YzT))
    {
      ((SpannableStringBuilder)localObject2).setSpan(localObject1, 0, 1, 17);
      ((SpannableStringBuilder)localObject2).setSpan(localf, 0, localSpannableStringBuilder1.length(), 18);
    }
    paramz = getResources().getDrawable(a.h.aa_paylist_collapse);
    paramz.setColorFilter(getResources().getColor(a.c.FG_2), PorterDuff.Mode.SRC_ATOP);
    paramz.setBounds(0, 0, bd.fromDPToPix(getContext(), 19), bd.fromDPToPix(getContext(), 19));
    ((SpannableStringBuilder)localObject2).setSpan(new com.tencent.mm.ui.widget.a(paramz, 1), ((SpannableStringBuilder)localObject2).length() - 1, ((SpannableStringBuilder)localObject2).length(), 33);
    if (paramString.getLineCount() > 2)
    {
      paramTextView.setText(localSpannableStringBuilder2);
      paramTextView.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(268572);
          if (paramAnonymousView.isSelected())
          {
            paramTextView.setText(localSpannableStringBuilder2);
            paramTextView.setSelected(false);
            AppMethodBeat.o(268572);
            return;
          }
          paramTextView.setText(this.pMJ);
          paramTextView.setSelected(true);
          AppMethodBeat.o(268572);
        }
      });
      paramTextView.setSelected(true);
      AppMethodBeat.o(268521);
      return;
    }
    paramTextView.setText(paramSpannableString);
    paramTextView.setOnClickListener(null);
    AppMethodBeat.o(268521);
  }
  
  private void a(com.tencent.mm.protocal.protobuf.z paramz)
  {
    AppMethodBeat.i(268531);
    if (j.ct(paramz.YzQ) != null)
    {
      this.pMl.setVisibility(8);
      this.pMk.setVisibility(0);
      paramz = getString(a.i.aa_yuan_new_style, new Object[] { Double.valueOf(j.E(paramz.YAr)) });
      String str = getString(a.i.paylist_aa_paid_money_item_title_new) + paramz;
      SpannableString localSpannableString = new SpannableString(str);
      WcPayTextApppearanceSpan localWcPayTextApppearanceSpan = new WcPayTextApppearanceSpan((int)this.pMv.getTextSize(), ColorStateList.valueOf(getResources().getColor(a.c.paylist_done_receipt_text_color)));
      localWcPayTextApppearanceSpan.VYs = i.nS(getContext());
      int i = str.lastIndexOf(paramz);
      int j = str.lastIndexOf(paramz);
      localSpannableString.setSpan(localWcPayTextApppearanceSpan, i, paramz.length() + j, 17);
      this.pMv.setText(localSpannableString);
      this.pMv.setTextColor(getResources().getColor(a.c.paylist_done_receipt_text_color));
      AppMethodBeat.o(268531);
      return;
    }
    this.pMl.setVisibility(0);
    this.pMk.setVisibility(8);
    this.pMq = ((WalletTextView)findViewById(a.f.need_pay_amount_tv));
    this.pMq.setVisibility(8);
    ((TextView)this.pMl.findViewById(a.f.paylist_aa_instant_pay_tip_tv)).setVisibility(8);
    this.pMr = ((Button)this.pMl.findViewById(a.f.paylist_aa_instant_pay_btn));
    if ((paramz.state == com.tencent.mm.plugin.aa.model.b.pFL) || (paramz.state == com.tencent.mm.plugin.aa.model.b.pFM))
    {
      this.pMr.setVisibility(8);
      AppMethodBeat.o(268531);
      return;
    }
    this.pMr.setText(getString(a.i.paylist_aa_instant_pay));
    this.pMr.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(268571);
        Log.i("MicroMsg.Aa.PaylistAAUI", "click mInstantPayBtn ForCustomize");
        paramAnonymousView = PaylistAAUI.this.getIntent();
        paramAnonymousView.putExtra("user_name", PaylistAAUI.f(PaylistAAUI.this));
        paramAnonymousView.putExtra("user_real_name", PaylistAAUI.i(PaylistAAUI.this));
        com.tencent.mm.br.c.b(PaylistAAUI.this, "aa", ".ui.AARemittanceUI", paramAnonymousView, 234);
        AppMethodBeat.o(268571);
      }
    });
    paramz = (LinearLayout.LayoutParams)this.pMr.getLayoutParams();
    paramz.topMargin = 0;
    this.pMr.setLayoutParams(paramz);
    AppMethodBeat.o(268531);
  }
  
  private void a(List<x> paramList, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(63738);
    ((TextView)findViewById(a.f.paylist_aa_top_member_hint_tv)).setText(paramString);
    paramString = this.pMx;
    int i;
    LinearLayout localLinearLayout1;
    label58:
    Object localObject2;
    int j;
    label98:
    Object localObject1;
    Object localObject3;
    TextView localTextView2;
    TextView localTextView1;
    LinearLayout localLinearLayout2;
    Object localObject4;
    Object localObject5;
    label218:
    int k;
    int m;
    if (paramBoolean)
    {
      i = 0;
      paramString.setVisibility(i);
      localLinearLayout1 = (LinearLayout)findViewById(a.f.paylist_aa_top_member_layout);
      localLinearLayout1.removeAllViews();
      i = 0;
      if (i >= paramList.size()) {
        break label874;
      }
      localObject2 = (x)paramList.get(i);
      if (i < paramList.size() - 1) {
        break label563;
      }
      j = 1;
      localObject1 = (LinearLayout)getLayoutInflater().inflate(a.g.paylist_aa_memeber_item, localLinearLayout1, false);
      paramString = (ImageView)((LinearLayout)localObject1).findViewById(a.f.paylist_aa_member_avatar_iv);
      localObject3 = (TextView)((LinearLayout)localObject1).findViewById(a.f.paylist_aa_member_name_tv);
      localTextView2 = (TextView)((LinearLayout)localObject1).findViewById(a.f.paylist_aa_member_pay_state_tv);
      localTextView1 = (TextView)((LinearLayout)localObject1).findViewById(a.f.paylist_aa_member_desc);
      localLinearLayout2 = (LinearLayout)((LinearLayout)localObject1).findViewById(a.f.paylist_aa_member_layout);
      a.b.g(paramString, ((x)localObject2).nQV);
      localObject4 = getContext();
      localObject5 = this.pMj;
      paramString = ((x)localObject2).nQV;
      if (!Util.isNullOrNil(paramString)) {
        break label569;
      }
      paramString = "";
      ((TextView)localObject3).setText(p.b((Context)localObject4, paramString, ((TextView)localObject3).getTextSize()));
      if (((x)localObject2).YAi != com.tencent.mm.plugin.aa.model.b.pFV) {
        break label620;
      }
      paramString = getString(a.i.aa_yuan_new_style, new Object[] { Double.valueOf(j.E(((x)localObject2).YzZ)) });
      localObject3 = getString(a.i.paylist_aa_paid_money_item_title_new) + paramString;
      localObject4 = new SpannableString((CharSequence)localObject3);
      localObject5 = new WcPayTextApppearanceSpan((int)localTextView2.getTextSize(), ColorStateList.valueOf(getResources().getColor(a.c.paylist_done_receipt_text_color)));
      ((WcPayTextApppearanceSpan)localObject5).VYs = i.bE(getContext(), 7);
      k = ((String)localObject3).lastIndexOf(paramString);
      m = ((String)localObject3).lastIndexOf(paramString);
      ((SpannableString)localObject4).setSpan(localObject5, k, paramString.length() + m, 17);
      localTextView2.setText((CharSequence)localObject4);
      localTextView2.setTextColor(getResources().getColor(a.c.paylist_done_receipt_text_color));
      localTextView2.setVisibility(0);
      if (Util.isNullOrNil(((x)localObject2).YAf)) {
        break label603;
      }
      localTextView1.setText(((x)localObject2).YAf);
      localTextView1.setVisibility(0);
      localLinearLayout2.setGravity(48);
      label447:
      localLinearLayout1.addView((View)localObject1);
      label454:
      paramString = ((LinearLayout)localObject1).findViewById(a.f.divider);
      if (j == 0) {
        break label854;
      }
      paramString.setBackgroundColor(getContext().getResources().getColor(a.c.BG_0));
      localObject1 = paramString.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = 0;
      paramString.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    for (;;)
    {
      localTextView1.setContentDescription(getString(a.i.launch_aa_paylist_member_desc_prefix_accessibility) + "，" + localTextView1.getText().toString());
      i += 1;
      break label58;
      i = 8;
      break;
      label563:
      j = 0;
      break label98;
      label569:
      localObject5 = ((com.tencent.mm.vending.app.a)localObject5).agtI.getStringExtra("chatroom");
      paramString = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.a.b.class)).aV(paramString, (String)localObject5);
      break label218;
      label603:
      localLinearLayout2.setGravity(16);
      localTextView1.setVisibility(8);
      break label447;
      label620:
      if (((x)localObject2).YAi == com.tencent.mm.plugin.aa.model.b.pFU)
      {
        paramString = getString(a.i.aa_yuan_new_style, new Object[] { Double.valueOf(j.E(((x)localObject2).YzZ)) });
        localObject2 = getString(a.i.paylist_aa_by_person_member_unpaid_title_new) + paramString;
        localObject3 = new SpannableString((CharSequence)localObject2);
        localObject4 = new WcPayTextApppearanceSpan((int)localTextView2.getTextSize(), ColorStateList.valueOf(getResources().getColor(a.c.paylist_unreceipt_text_color)));
        ((WcPayTextApppearanceSpan)localObject4).VYs = i.bE(getContext(), 7);
        k = ((String)localObject2).lastIndexOf(paramString);
        m = ((String)localObject2).lastIndexOf(paramString);
        ((SpannableString)localObject3).setSpan(localObject4, k, paramString.length() + m, 17);
        localTextView2.setText((CharSequence)localObject3);
        localTextView2.setTextColor(getResources().getColor(a.c.paylist_unreceipt_text_color));
        localTextView2.setVisibility(0);
        localTextView1.setVisibility(8);
        localLinearLayout2.setGravity(16);
        localLinearLayout1.addView((View)localObject1);
        break label454;
      }
      localTextView2.setVisibility(8);
      localTextView1.setVisibility(8);
      localLinearLayout2.setGravity(16);
      localLinearLayout1.addView((View)localObject1);
      break label454;
      label854:
      paramString.setBackgroundColor(getContext().getResources().getColor(a.c.small_line_color));
    }
    label874:
    AppMethodBeat.o(63738);
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, List<x> paramList)
  {
    AppMethodBeat.i(268532);
    if ((!Util.isNullOrNil(this.pJq)) && (!au.bwG(this.pJq)) && (!au.bwP(this.pJq)) && (paramInt4 == 4) && (paramList.size() == 1))
    {
      AppMethodBeat.o(268532);
      return false;
    }
    if ((paramInt1 == com.tencent.mm.plugin.aa.model.b.pFO) && (paramInt2 != com.tencent.mm.plugin.aa.model.b.pFS) && (paramInt3 == com.tencent.mm.plugin.aa.model.b.pFK))
    {
      AppMethodBeat.o(268532);
      return true;
    }
    AppMethodBeat.o(268532);
    return false;
  }
  
  private void bVW()
  {
    AppMethodBeat.i(63736);
    this.pIQ = l.c(this, false, null);
    this.pKd.setVisibility(4);
    this.pJr.pIf.bVq().f(new com.tencent.mm.vending.c.a() {}).a(new d.a()
    {
      public final void onInterrupt(final Object paramAnonymousObject)
      {
        AppMethodBeat.i(63719);
        Log.i("MicroMsg.Aa.PaylistAAUI", "onInterrupt: %s", new Object[] { paramAnonymousObject });
        PaylistAAUI.this.hideLoading();
        if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof com.tencent.mm.protocal.protobuf.a)))
        {
          paramAnonymousObject = (com.tencent.mm.protocal.protobuf.a)paramAnonymousObject;
          localObject = paramAnonymousObject.wording;
          String str1 = paramAnonymousObject.rGU;
          String str2 = paramAnonymousObject.right_button_wording;
          e.a locala = new e.a(PaylistAAUI.this.getContext());
          locala.bDw((String)localObject);
          locala.bDC(str2).c(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(268546);
              Log.i("MicroMsg.Aa.PaylistAAUI", "click getPayListDetail onInterrupt Item");
              i.p(PaylistAAUI.this.getContext(), paramAnonymousObject.wYO, false);
              AppMethodBeat.o(268546);
            }
          });
          locala.bDD(str1);
          locala.jHH().show();
          AppMethodBeat.o(63719);
          return;
        }
        Object localObject = PaylistAAUI.this;
        if (paramAnonymousObject == null) {}
        for (paramAnonymousObject = "";; paramAnonymousObject = paramAnonymousObject.toString())
        {
          PaylistAAUI.a((PaylistAAUI)localObject, paramAnonymousObject);
          AppMethodBeat.o(63719);
          return;
        }
      }
    });
    AppMethodBeat.o(63736);
  }
  
  private void bVu()
  {
    AppMethodBeat.i(268540);
    if (Util.isNullOrNil(this.pMu))
    {
      str1 = getString(a.i.paylist_aa_instant_add_desc);
      i.a(this.pMs, str1, 0, str1.length(), new com.tencent.mm.wallet_core.ui.f(new f.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(268504);
          PaylistAAUI.o(PaylistAAUI.this);
          com.tencent.mm.plugin.report.service.h.OAn.b(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(10), Integer.valueOf(PaylistAAUI.c(PaylistAAUI.this)) });
          AppMethodBeat.o(268504);
        }
      }), getContext());
      this.pMs.setVisibility(0);
      this.pMt.setVisibility(8);
      AppMethodBeat.o(268540);
      return;
    }
    String str1 = getString(a.i.paylist_aa_instant_desc);
    String str2 = getString(a.i.collect_main_add_desc_title_changed, new Object[] { this.pMu, str1 });
    SpannableString localSpannableString = p.b(this, str2);
    i.a(this.pMt, str2, localSpannableString.length() - str1.length(), localSpannableString.length(), new com.tencent.mm.wallet_core.ui.f(new f.a()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(268501);
        PaylistAAUI.o(PaylistAAUI.this);
        com.tencent.mm.plugin.report.service.h.OAn.b(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(10), Integer.valueOf(PaylistAAUI.c(PaylistAAUI.this)) });
        AppMethodBeat.o(268501);
      }
    }), getContext());
    this.pMs.setVisibility(8);
    this.pMt.setVisibility(0);
    AppMethodBeat.o(268540);
  }
  
  public final void c(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(63742);
    if (paramInt == -1)
    {
      Log.i("MicroMsg.Aa.PaylistAAUI", "pay success, payMsgId: %s", new Object[] { this.hWQ });
      RealnameGuideHelper localRealnameGuideHelper = (RealnameGuideHelper)paramIntent.getParcelableExtra("key_realname_guide_helper");
      if (localRealnameGuideHelper != null)
      {
        Log.i("MicroMsg.Aa.PaylistAAUI", "do realname guide");
        Intent localIntent = new Intent();
        localIntent.putExtra("key_realname_guide_helper", localRealnameGuideHelper);
        com.tencent.mm.br.c.b(this, "wallet_core", ".id_verify.RealnameDialogActivity", localIntent);
      }
      j.SB(this.pJq);
      finish();
      this.pJr.pIh.C(this.hWQ, this.pMz, this.pJo).f(new com.tencent.mm.vending.c.a() {});
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(407L, 12L, 1L, false);
      paramIntent = paramIntent.getStringExtra("key_trans_id");
      this.pJr.pIi.b(this.pMC, this.hCI, paramIntent);
    }
    AppMethodBeat.o(63742);
  }
  
  public int getLayoutId()
  {
    return a.g.paylist_aa_ui;
  }
  
  public void hideLoading()
  {
    AppMethodBeat.i(63743);
    if ((this.pIQ != null) && (this.pIQ.isShowing()))
    {
      this.pIQ.dismiss();
      this.pIQ = null;
    }
    AppMethodBeat.o(63743);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(63741);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 233)
    {
      c(paramInt2, paramIntent);
      AppMethodBeat.o(63741);
      return;
    }
    if (paramInt1 == 222)
    {
      if (paramInt2 == -1)
      {
        paramIntent = paramIntent.getStringExtra("Select_Conv_User");
        Log.i("MicroMsg.Aa.PaylistAAUI", "select chatroom：%s", new Object[] { paramIntent });
        if (!Util.isNullOrNil(paramIntent))
        {
          Intent localIntent = new Intent(getContext(), LaunchAAUI.class);
          localIntent.putExtra("enter_scene", 3);
          localIntent.putExtra("chatroom_name", paramIntent);
          paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
          com.tencent.mm.hellhoundlib.a.a.b(this, paramIntent.aYi(), "com/tencent/mm/plugin/aa/ui/PaylistAAUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramIntent.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/aa/ui/PaylistAAUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(63741);
      }
    }
    else if ((paramInt1 == 234) && (paramInt2 == -1))
    {
      Log.i("MicroMsg.Aa.PaylistAAUI", "PAY_AA_TYPE_BY_PERSON_CUSTOMIZE_CODE resultCode == RESULT_OK");
      finish();
    }
    AppMethodBeat.o(63741);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(63735);
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(63709);
        PaylistAAUI.this.finish();
        AppMethodBeat.o(63709);
        return false;
      }
    });
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(a.c.white));
    this.pJq = getIntent().getStringExtra("chatroom");
    this.pMk = ((LinearLayout)findViewById(a.f.paylist_aa_pay_info_layout));
    this.pMl = ((LinearLayout)findViewById(a.f.paylist_aa_instant_pay_layout));
    this.pMm = ((LinearLayout)findViewById(a.f.paylist_aa_bottom_layout));
    this.pMn = ((LinearLayout)findViewById(a.f.paylist_aa_pay_list_layout));
    this.pMp = ((RelativeLayout)findViewById(a.f.paylist_aa_container));
    this.pMv = ((TextView)findViewById(a.f.paylist_aa_pay_info_msg_tv));
    this.pLM = ((WcPayBannerView)findViewById(a.f.wc_pay_banner_layout));
    this.pLM.jPz();
    aw.a(this.pMv.getPaint(), 0.8F);
    this.pMw = ((TextView)findViewById(a.f.paylist_aa_close_info_msg_tv));
    this.pKd = findViewById(a.f.root_container);
    this.pMx = ((TextView)findViewById(a.f.paylist_aa_send_tip_tv));
    aw.a(this.pMx.getPaint(), 0.8F);
    this.pMx.setClickable(true);
    this.pMx.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s(this));
    paramBundle = new SpannableStringBuilder(getString(a.i.paylist_aa_recevier_send_tip_title));
    paramBundle.setSpan(new com.tencent.mm.wallet_core.ui.f(new f.a()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(268522);
        Log.i("MicroMsg.Aa.PaylistAAUI", "click AlertMsgTips");
        int i = a.i.urge_aa_confirm_msg;
        if (!au.bwE(PaylistAAUI.a(PaylistAAUI.this))) {
          i = a.i.urge_aa_confirm_msg_single;
        }
        for (;;)
        {
          paramAnonymousView = new g.a(PaylistAAUI.this);
          paramAnonymousView.bf(PaylistAAUI.this.getString(a.i.urge_aa_confirm_msg_title));
          View localView = af.mU(PaylistAAUI.this).inflate(a.g.urge_aa_dialog_centerview, null);
          ImageView localImageView = (ImageView)localView.findViewById(a.f.image);
          TextView localTextView = (TextView)localView.findViewById(a.f.text);
          localImageView.setImageResource(a.e.paylist_urge_atall_hint);
          localTextView.setText(i);
          paramAnonymousView.mg(localView);
          paramAnonymousView.aEX(a.i.app_send);
          paramAnonymousView.bDJ(PaylistAAUI.this.getString(a.i.app_cancel));
          paramAnonymousView.Xdm = false;
          paramAnonymousView.a(new com.tencent.mm.ui.widget.a.g.c()new com.tencent.mm.ui.widget.a.g.c
          {
            public final void onDialogClick(boolean paramAnonymous2Boolean, String paramAnonymous2String) {}
          }, new com.tencent.mm.ui.widget.a.g.c()
          {
            public final void onDialogClick(boolean paramAnonymous2Boolean, String paramAnonymous2String)
            {
              AppMethodBeat.i(63717);
              PaylistAAUI.b(PaylistAAUI.this);
              AppMethodBeat.o(63717);
            }
          });
          paramAnonymousView.show();
          com.tencent.mm.plugin.report.service.h.OAn.b(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(7), Integer.valueOf(PaylistAAUI.c(PaylistAAUI.this)) });
          AppMethodBeat.o(268522);
          return;
        }
      }
    }), 0, paramBundle.length(), 18);
    this.pMx.setText(paramBundle);
    this.pMy = ((TextView)findViewById(a.f.paylist_aa_bottom_tip_tv));
    aw.a(this.pMy.getPaint(), 0.8F);
    bVW();
    AppMethodBeat.o(63735);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(63737);
    super.onDestroy();
    AppMethodBeat.o(63737);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public boolean shouldEnsureSoterConnection()
  {
    return true;
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(268643);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.aa.model.a.class);
    AppMethodBeat.o(268643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.PaylistAAUI
 * JD-Core Version:    0.7.0.1
 */