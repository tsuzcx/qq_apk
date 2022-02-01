package com.tencent.mm.plugin.aa.ui;

import android.app.Activity;
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
import android.view.View.OnClickListener;
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
import com.tencent.mm.ay.q;
import com.tencent.mm.ay.r;
import com.tencent.mm.ay.r.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.aa.model.b.g.c;
import com.tencent.mm.plugin.aa.model.b.g.d;
import com.tencent.mm.plugin.aa.model.b.g.e;
import com.tencent.mm.plugin.expt.b.b.a;
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
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.s;
import com.tencent.mm.protocal.protobuf.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.view.ViewAnimHelper;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PaylistAAUI
  extends BaseAAPresenterActivity
{
  private static int mPV = 1;
  private static int mPW = 2;
  private static int mPX = 3;
  private static int mPY = 4;
  private String fQT;
  private String fyd;
  private Dialog mLP;
  private int mLU;
  private String mMF;
  private String mMG;
  private String mMI;
  private com.tencent.mm.plugin.aa.model.b.g mMJ;
  private Dialog mMi;
  private View mNv;
  private com.tencent.mm.plugin.aa.model.b.f mPB;
  private LinearLayout mPC;
  private LinearLayout mPD;
  private LinearLayout mPE;
  private LinearLayout mPF;
  private LinearLayout mPG;
  private RelativeLayout mPH;
  private WalletTextView mPI;
  private Button mPJ;
  private TextView mPK;
  private TextView mPL;
  private String mPM;
  private TextView mPN;
  private TextView mPO;
  private TextView mPP;
  private TextView mPQ;
  private String mPR;
  private String mPS;
  private int mPT;
  private long mPU;
  private String title;
  
  public PaylistAAUI()
  {
    AppMethodBeat.i(63734);
    this.mMJ = ((com.tencent.mm.plugin.aa.model.b.g)ap(com.tencent.mm.plugin.aa.model.b.g.class));
    this.mPB = ((com.tencent.mm.plugin.aa.model.b.f)at(com.tencent.mm.plugin.aa.model.b.f.class));
    this.mMi = null;
    this.mLP = null;
    AppMethodBeat.o(63734);
  }
  
  private void a(final TextView paramTextView, SpannableString paramSpannableString, String paramString, final com.tencent.mm.protocal.protobuf.z paramz)
  {
    AppMethodBeat.i(245627);
    Object localObject1 = getResources().getDrawable(a.h.icons_outlined_album);
    ((Drawable)localObject1).setColorFilter(getResources().getColor(a.c.Link), PorterDuff.Mode.SRC_ATOP);
    ((Drawable)localObject1).setBounds(0, 0, aw.fromDPToPix(getContext(), 20), aw.fromDPToPix(getContext(), 20));
    localObject1 = new com.tencent.mm.ui.widget.a((Drawable)localObject1, 1);
    com.tencent.mm.wallet_core.ui.f localf = new com.tencent.mm.wallet_core.ui.f(new com.tencent.mm.wallet_core.ui.f.a()
    {
      public final void bwz()
      {
        AppMethodBeat.i(274890);
        Log.i("MicroMsg.Aa.PaylistAAUI", "launcherTipTv img click");
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(272718);
            com.tencent.mm.plugin.report.service.h.IzE.a(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(12), Integer.valueOf(PaylistAAUI.c(PaylistAAUI.this)) });
            if (PaylistAAUI.g(PaylistAAUI.this) == null) {
              PaylistAAUI.a(PaylistAAUI.this, com.tencent.mm.ui.base.h.a(PaylistAAUI.this, 3, a.j.LuckyMoneyNoAnimDialog, PaylistAAUI.this.getString(a.i.loading_tips), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                {
                  AppMethodBeat.i(272812);
                  if ((PaylistAAUI.g(PaylistAAUI.this) != null) && (PaylistAAUI.g(PaylistAAUI.this).isShowing())) {
                    PaylistAAUI.g(PaylistAAUI.this).dismiss();
                  }
                  AppMethodBeat.o(272812);
                }
              }));
            }
            q.bmk().a(PaylistAAUI.27.this.mQk.RDq, new r.a()
            {
              public final void a(String paramAnonymous3String1, Bitmap paramAnonymous3Bitmap, String paramAnonymous3String2)
              {
                AppMethodBeat.i(272441);
                Log.i("MicroMsg.Aa.PaylistAAUI", "onLoadImageEnd() url:%s path:%s", new Object[] { paramAnonymous3String1, paramAnonymous3String2 });
                if ((PaylistAAUI.g(PaylistAAUI.this) != null) && (PaylistAAUI.g(PaylistAAUI.this).isShowing())) {
                  PaylistAAUI.g(PaylistAAUI.this).dismiss();
                }
                if (paramAnonymous3Bitmap != null)
                {
                  paramAnonymous3String1 = new Intent();
                  paramAnonymous3String1.putExtra("use_scene", 2);
                  paramAnonymous3String1.putExtra("scene", 1);
                  paramAnonymous3String1.putExtra("url", PaylistAAUI.27.this.mQk.RDq);
                  paramAnonymous3String1.putExtra("path", paramAnonymous3String2);
                  paramAnonymous3Bitmap = ViewAnimHelper.q(PaylistAAUI.27.this.jip, PaylistAAUI.this.getContext().getWindow().getDecorView());
                  paramAnonymous3String2 = paramAnonymous3Bitmap.YkY;
                  paramAnonymous3String2.right = (paramAnonymous3String2.left + com.tencent.mm.ci.a.fromDPToPix(PaylistAAUI.this.getContext(), 30));
                  paramAnonymous3Bitmap.YkY.set(paramAnonymous3String2);
                  paramAnonymous3String1.putExtra("view_info", paramAnonymous3Bitmap);
                  paramAnonymous3String1.putExtra("aa_type", PaylistAAUI.c(PaylistAAUI.this));
                  com.tencent.mm.by.c.b(PaylistAAUI.this, "aa", ".ui.AAImagPreviewUI", paramAnonymous3String1, 100);
                  AppMethodBeat.o(272441);
                  return;
                }
                Toast.makeText(PaylistAAUI.this, a.i.aa_list_load_img_fail, 1).show();
                AppMethodBeat.o(272441);
              }
            });
            AppMethodBeat.o(272718);
          }
        });
        AppMethodBeat.o(274890);
      }
    });
    SpannableStringBuilder localSpannableStringBuilder2 = new SpannableStringBuilder(paramSpannableString);
    SpannableStringBuilder localSpannableStringBuilder1 = new SpannableStringBuilder(paramString);
    if (!Util.isNullOrNil(paramz.RDq))
    {
      localSpannableStringBuilder2.setSpan(localObject1, 0, 1, 17);
      localSpannableStringBuilder2.setSpan(localf, 0, localSpannableStringBuilder1.length(), 18);
    }
    Object localObject2 = paramTextView.getPaint();
    int i = paramTextView.getMeasuredWidth();
    float f1 = ((TextPaint)localObject2).measureText(" ...  ");
    float f2 = aw.fromDPToPix(getContext(), 19);
    float f3 = i;
    paramString = new StaticLayout(localSpannableStringBuilder2, (TextPaint)localObject2, i, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    i = paramString.getLineCount();
    Log.d("MicroMsg.Aa.PaylistAAUI", "lineCount ： %s", new Object[] { Integer.valueOf(i) });
    if (i <= 0)
    {
      Log.i("MicroMsg.Aa.PaylistAAUI", "lineCount <= 0");
      AppMethodBeat.o(245627);
      return;
    }
    if (i <= 2)
    {
      paramTextView.setText(localSpannableStringBuilder2);
      AppMethodBeat.o(245627);
      return;
    }
    i = paramString.getLineEnd(0);
    localSpannableStringBuilder2 = new SpannableStringBuilder(paramSpannableString.subSequence(0, i + new StaticLayout(paramSpannableString.subSequence(i, paramSpannableString.length()), (TextPaint)localObject2, (int)(f3 - (f1 + f2)), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false).getLineEnd(0)));
    localSpannableStringBuilder2.append(" ...  ");
    if (!Util.isNullOrNil(paramz.RDq))
    {
      localSpannableStringBuilder2.setSpan(localObject1, 0, 1, 17);
      localSpannableStringBuilder2.setSpan(localf, 0, localSpannableStringBuilder1.length(), 18);
    }
    localObject2 = getResources().getDrawable(a.h.aa_paylist_unfold);
    ((Drawable)localObject2).setColorFilter(getResources().getColor(a.c.FG_2), PorterDuff.Mode.SRC_ATOP);
    ((Drawable)localObject2).setBounds(0, 0, aw.fromDPToPix(getContext(), 19), aw.fromDPToPix(getContext(), 19));
    localSpannableStringBuilder2.setSpan(new com.tencent.mm.ui.widget.a((Drawable)localObject2, 1), localSpannableStringBuilder2.length() - 1, localSpannableStringBuilder2.length(), 33);
    localObject2 = new SpannableStringBuilder(paramSpannableString);
    ((SpannableStringBuilder)localObject2).append(" ");
    if (!Util.isNullOrNil(paramz.RDq))
    {
      ((SpannableStringBuilder)localObject2).setSpan(localObject1, 0, 1, 17);
      ((SpannableStringBuilder)localObject2).setSpan(localf, 0, localSpannableStringBuilder1.length(), 18);
    }
    paramz = getResources().getDrawable(a.h.aa_paylist_collapse);
    paramz.setColorFilter(getResources().getColor(a.c.FG_2), PorterDuff.Mode.SRC_ATOP);
    paramz.setBounds(0, 0, aw.fromDPToPix(getContext(), 19), aw.fromDPToPix(getContext(), 19));
    ((SpannableStringBuilder)localObject2).setSpan(new com.tencent.mm.ui.widget.a(paramz, 1), ((SpannableStringBuilder)localObject2).length() - 1, ((SpannableStringBuilder)localObject2).length(), 33);
    if (paramString.getLineCount() > 2)
    {
      paramTextView.setText(localSpannableStringBuilder2);
      paramTextView.setOnClickListener(new PaylistAAUI.2(this, paramTextView, localSpannableStringBuilder2, (SpannableStringBuilder)localObject2));
      paramTextView.setSelected(true);
      AppMethodBeat.o(245627);
      return;
    }
    paramTextView.setText(paramSpannableString);
    paramTextView.setOnClickListener(null);
    AppMethodBeat.o(245627);
  }
  
  private void a(com.tencent.mm.protocal.protobuf.z paramz)
  {
    AppMethodBeat.i(245628);
    if (com.tencent.mm.plugin.aa.model.i.aO(paramz.RDn) != null)
    {
      this.mPD.setVisibility(8);
      this.mPC.setVisibility(0);
      paramz = getString(a.i.aa_yuan_new_style, new Object[] { Double.valueOf(com.tencent.mm.plugin.aa.model.i.o(paramz.RDO)) });
      String str = getString(a.i.paylist_aa_paid_money_item_title_new) + paramz;
      SpannableString localSpannableString = new SpannableString(str);
      WcPayTextApppearanceSpan localWcPayTextApppearanceSpan = new WcPayTextApppearanceSpan((int)this.mPN.getTextSize(), ColorStateList.valueOf(getResources().getColor(a.c.paylist_done_receipt_text_color)));
      localWcPayTextApppearanceSpan.PhE = com.tencent.mm.wallet_core.ui.g.lN(getContext());
      int i = str.lastIndexOf(paramz);
      int j = str.lastIndexOf(paramz);
      localSpannableString.setSpan(localWcPayTextApppearanceSpan, i, paramz.length() + j, 17);
      this.mPN.setText(localSpannableString);
      this.mPN.setTextColor(getResources().getColor(a.c.paylist_done_receipt_text_color));
      AppMethodBeat.o(245628);
      return;
    }
    this.mPD.setVisibility(0);
    this.mPC.setVisibility(8);
    this.mPI = ((WalletTextView)findViewById(a.f.need_pay_amount_tv));
    this.mPI.setVisibility(8);
    ((TextView)this.mPD.findViewById(a.f.paylist_aa_instant_pay_tip_tv)).setVisibility(8);
    this.mPJ = ((Button)this.mPD.findViewById(a.f.paylist_aa_instant_pay_btn));
    if ((paramz.state == com.tencent.mm.plugin.aa.model.a.mJc) || (paramz.state == com.tencent.mm.plugin.aa.model.a.mJd))
    {
      this.mPJ.setVisibility(8);
      AppMethodBeat.o(245628);
      return;
    }
    this.mPJ.setText(getString(a.i.paylist_aa_instant_pay));
    this.mPJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(270669);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/aa/ui/PaylistAAUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.Aa.PaylistAAUI", "click mInstantPayBtn ForCustomize");
        paramAnonymousView = PaylistAAUI.this.getIntent();
        paramAnonymousView.putExtra("user_name", PaylistAAUI.e(PaylistAAUI.this));
        paramAnonymousView.putExtra("user_real_name", PaylistAAUI.h(PaylistAAUI.this));
        com.tencent.mm.by.c.b(PaylistAAUI.this, "aa", ".ui.AARemittanceUI", paramAnonymousView, 234);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/PaylistAAUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(270669);
      }
    });
    paramz = (LinearLayout.LayoutParams)this.mPJ.getLayoutParams();
    paramz.topMargin = 0;
    this.mPJ.setLayoutParams(paramz);
    AppMethodBeat.o(245628);
  }
  
  private void a(List<x> paramList, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(63738);
    ((TextView)findViewById(a.f.paylist_aa_top_member_hint_tv)).setText(paramString);
    paramString = this.mPP;
    int i;
    LinearLayout localLinearLayout1;
    label58:
    Object localObject2;
    int j;
    label98:
    Object localObject1;
    Object localObject3;
    TextView localTextView1;
    TextView localTextView2;
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
        break label830;
      }
      localObject2 = (x)paramList.get(i);
      if (i < paramList.size() - 1) {
        break label519;
      }
      j = 1;
      localObject1 = (LinearLayout)getLayoutInflater().inflate(a.g.paylist_aa_memeber_item, localLinearLayout1, false);
      paramString = (ImageView)((LinearLayout)localObject1).findViewById(a.f.paylist_aa_member_avatar_iv);
      localObject3 = (TextView)((LinearLayout)localObject1).findViewById(a.f.paylist_aa_member_name_tv);
      localTextView1 = (TextView)((LinearLayout)localObject1).findViewById(a.f.paylist_aa_member_pay_state_tv);
      localTextView2 = (TextView)((LinearLayout)localObject1).findViewById(a.f.paylist_aa_member_desc);
      localLinearLayout2 = (LinearLayout)((LinearLayout)localObject1).findViewById(a.f.paylist_aa_member_layout);
      a.b.c(paramString, ((x)localObject2).llP);
      localObject4 = getContext();
      localObject5 = this.mPB;
      paramString = ((x)localObject2).llP;
      if (!Util.isNullOrNil(paramString)) {
        break label525;
      }
      paramString = "";
      ((TextView)localObject3).setText(l.b((Context)localObject4, paramString, ((TextView)localObject3).getTextSize()));
      if (((x)localObject2).RDF != com.tencent.mm.plugin.aa.model.a.mJm) {
        break label576;
      }
      paramString = getString(a.i.aa_yuan_new_style, new Object[] { Double.valueOf(com.tencent.mm.plugin.aa.model.i.o(((x)localObject2).RDw)) });
      localObject3 = getString(a.i.paylist_aa_paid_money_item_title_new) + paramString;
      localObject4 = new SpannableString((CharSequence)localObject3);
      localObject5 = new WcPayTextApppearanceSpan((int)localTextView1.getTextSize(), ColorStateList.valueOf(getResources().getColor(a.c.paylist_done_receipt_text_color)));
      ((WcPayTextApppearanceSpan)localObject5).PhE = com.tencent.mm.wallet_core.ui.g.bl(getContext(), 7);
      k = ((String)localObject3).lastIndexOf(paramString);
      m = ((String)localObject3).lastIndexOf(paramString);
      ((SpannableString)localObject4).setSpan(localObject5, k, paramString.length() + m, 17);
      localTextView1.setText((CharSequence)localObject4);
      localTextView1.setTextColor(getResources().getColor(a.c.paylist_done_receipt_text_color));
      localTextView1.setVisibility(0);
      if (Util.isNullOrNil(((x)localObject2).RDC)) {
        break label559;
      }
      localTextView2.setText(((x)localObject2).RDC);
      localTextView2.setVisibility(0);
      localLinearLayout2.setGravity(48);
      label447:
      localLinearLayout1.addView((View)localObject1);
      label454:
      paramString = ((LinearLayout)localObject1).findViewById(a.f.divider);
      if (j == 0) {
        break label810;
      }
      paramString.setBackgroundColor(getContext().getResources().getColor(a.c.BG_0));
      localObject1 = paramString.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = 0;
      paramString.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    for (;;)
    {
      i += 1;
      break label58;
      i = 8;
      break;
      label519:
      j = 0;
      break label98;
      label525:
      localObject5 = ((com.tencent.mm.vending.app.a)localObject5).Yzk.getStringExtra("chatroom");
      paramString = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.a.b.class)).aL(paramString, (String)localObject5);
      break label218;
      label559:
      localLinearLayout2.setGravity(16);
      localTextView2.setVisibility(8);
      break label447;
      label576:
      if (((x)localObject2).RDF == com.tencent.mm.plugin.aa.model.a.mJl)
      {
        paramString = getString(a.i.aa_yuan_new_style, new Object[] { Double.valueOf(com.tencent.mm.plugin.aa.model.i.o(((x)localObject2).RDw)) });
        localObject2 = getString(a.i.paylist_aa_by_person_member_unpaid_title_new) + paramString;
        localObject3 = new SpannableString((CharSequence)localObject2);
        localObject4 = new WcPayTextApppearanceSpan((int)localTextView1.getTextSize(), ColorStateList.valueOf(getResources().getColor(a.c.paylist_unreceipt_text_color)));
        ((WcPayTextApppearanceSpan)localObject4).PhE = com.tencent.mm.wallet_core.ui.g.bl(getContext(), 7);
        k = ((String)localObject2).lastIndexOf(paramString);
        m = ((String)localObject2).lastIndexOf(paramString);
        ((SpannableString)localObject3).setSpan(localObject4, k, paramString.length() + m, 17);
        localTextView1.setText((CharSequence)localObject3);
        localTextView1.setTextColor(getResources().getColor(a.c.paylist_unreceipt_text_color));
        localTextView1.setVisibility(0);
        localTextView2.setVisibility(8);
        localLinearLayout2.setGravity(16);
        localLinearLayout1.addView((View)localObject1);
        break label454;
      }
      localTextView1.setVisibility(8);
      localTextView2.setVisibility(8);
      localLinearLayout2.setGravity(16);
      localLinearLayout1.addView((View)localObject1);
      break label454;
      label810:
      paramString.setBackgroundColor(getContext().getResources().getColor(a.c.small_line_color));
    }
    label830:
    AppMethodBeat.o(63738);
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, List<x> paramList)
  {
    AppMethodBeat.i(245629);
    if ((!Util.isNullOrNil(this.mMI)) && (!ab.PP(this.mMI)) && (!as.bvL(this.mMI)) && (paramInt4 == 4) && (paramList.size() == 1))
    {
      AppMethodBeat.o(245629);
      return false;
    }
    if ((paramInt1 == com.tencent.mm.plugin.aa.model.a.mJf) && (paramInt2 != com.tencent.mm.plugin.aa.model.a.mJj) && (paramInt3 == com.tencent.mm.plugin.aa.model.a.mJb))
    {
      AppMethodBeat.o(245629);
      return true;
    }
    AppMethodBeat.o(245629);
    return false;
  }
  
  private void bwE()
  {
    AppMethodBeat.i(245632);
    if (Util.isNullOrNil(this.mPM))
    {
      str1 = getString(a.i.paylist_aa_instant_add_desc);
      com.tencent.mm.wallet_core.ui.g.a(this.mPK, str1, 0, str1.length(), new com.tencent.mm.wallet_core.ui.f(new com.tencent.mm.wallet_core.ui.f.a()
      {
        public final void bwz()
        {
          AppMethodBeat.i(276552);
          PaylistAAUI.n(PaylistAAUI.this);
          com.tencent.mm.plugin.report.service.h.IzE.a(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(10), Integer.valueOf(PaylistAAUI.c(PaylistAAUI.this)) });
          AppMethodBeat.o(276552);
        }
      }), getContext());
      this.mPK.setVisibility(0);
      this.mPL.setVisibility(8);
      AppMethodBeat.o(245632);
      return;
    }
    String str1 = getString(a.i.paylist_aa_instant_desc);
    String str2 = getString(a.i.collect_main_add_desc_title_changed, new Object[] { this.mPM, str1 });
    SpannableString localSpannableString = l.c(this, str2);
    com.tencent.mm.wallet_core.ui.g.a(this.mPL, str2, localSpannableString.length() - str1.length(), localSpannableString.length(), new com.tencent.mm.wallet_core.ui.f(new com.tencent.mm.wallet_core.ui.f.a()
    {
      public final void bwz()
      {
        AppMethodBeat.i(260722);
        PaylistAAUI.n(PaylistAAUI.this);
        com.tencent.mm.plugin.report.service.h.IzE.a(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(10), Integer.valueOf(PaylistAAUI.c(PaylistAAUI.this)) });
        AppMethodBeat.o(260722);
      }
    }), getContext());
    this.mPK.setVisibility(8);
    this.mPL.setVisibility(0);
    AppMethodBeat.o(245632);
  }
  
  private void bxh()
  {
    AppMethodBeat.i(63736);
    this.mMi = com.tencent.mm.wallet_core.ui.i.c(this, false, null);
    this.mNv.setVisibility(4);
    this.mMJ.mLx.bwy().f(new com.tencent.mm.vending.c.a() {}).a(new com.tencent.mm.vending.g.d.a()
    {
      public final void cm(final Object paramAnonymousObject)
      {
        AppMethodBeat.i(63719);
        Log.i("MicroMsg.Aa.PaylistAAUI", "onInterrupt: %s", new Object[] { paramAnonymousObject });
        PaylistAAUI.this.hideLoading();
        if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof com.tencent.mm.protocal.protobuf.a)))
        {
          paramAnonymousObject = (com.tencent.mm.protocal.protobuf.a)paramAnonymousObject;
          localObject = paramAnonymousObject.wording;
          String str1 = paramAnonymousObject.oDJ;
          String str2 = paramAnonymousObject.oDK;
          com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(PaylistAAUI.this.getContext());
          locala.bBd((String)localObject);
          locala.bBj(str2).c(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(234398);
              Log.i("MicroMsg.Aa.PaylistAAUI", "click getPayListDetail onInterrupt Item");
              com.tencent.mm.wallet_core.ui.g.p(PaylistAAUI.this.getContext(), paramAnonymousObject.tVu, false);
              AppMethodBeat.o(234398);
            }
          });
          locala.bBk(str1);
          locala.icu().show();
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
  
  public final void b(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(63742);
    if (paramInt == -1)
    {
      Log.i("MicroMsg.Aa.PaylistAAUI", "pay success, payMsgId: %s", new Object[] { this.fQT });
      RealnameGuideHelper localRealnameGuideHelper = (RealnameGuideHelper)paramIntent.getParcelableExtra("key_realname_guide_helper");
      if (localRealnameGuideHelper != null)
      {
        Log.i("MicroMsg.Aa.PaylistAAUI", "do realname guide");
        Intent localIntent = new Intent();
        localIntent.putExtra("key_realname_guide_helper", localRealnameGuideHelper);
        com.tencent.mm.by.c.b(this, "wallet_core", ".id_verify.RealnameDialogActivity", localIntent);
      }
      com.tencent.mm.plugin.aa.model.i.aah(this.mMI);
      finish();
      this.mMJ.mLz.z(this.fQT, this.mPR, this.mMG).f(new com.tencent.mm.vending.c.a() {});
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(407L, 12L, 1L, false);
      paramIntent = paramIntent.getStringExtra("key_trans_id");
      this.mMJ.mLA.b(this.mPU, this.fyd, paramIntent);
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
    if ((this.mMi != null) && (this.mMi.isShowing()))
    {
      this.mMi.dismiss();
      this.mMi = null;
    }
    AppMethodBeat.o(63743);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(63741);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 233)
    {
      b(paramInt2, paramIntent);
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
          paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
          com.tencent.mm.hellhoundlib.a.a.b(this, paramIntent.aFh(), "com/tencent/mm/plugin/aa/ui/PaylistAAUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramIntent.sf(0));
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
    this.mMI = getIntent().getStringExtra("chatroom");
    this.mPC = ((LinearLayout)findViewById(a.f.paylist_aa_pay_info_layout));
    this.mPD = ((LinearLayout)findViewById(a.f.paylist_aa_instant_pay_layout));
    this.mPE = ((LinearLayout)findViewById(a.f.paylist_aa_bottom_layout));
    this.mPF = ((LinearLayout)findViewById(a.f.paylist_aa_pay_list_layout));
    this.mPH = ((RelativeLayout)findViewById(a.f.paylist_aa_container));
    this.mPN = ((TextView)findViewById(a.f.paylist_aa_pay_info_msg_tv));
    ar.a(this.mPN.getPaint(), 0.8F);
    this.mPO = ((TextView)findViewById(a.f.paylist_aa_close_info_msg_tv));
    this.mNv = findViewById(a.f.root_container);
    this.mPP = ((TextView)findViewById(a.f.paylist_aa_send_tip_tv));
    ar.a(this.mPP.getPaint(), 0.8F);
    this.mPP.setClickable(true);
    this.mPP.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o(this));
    paramBundle = new SpannableStringBuilder(getString(a.i.paylist_aa_recevier_send_tip_title));
    paramBundle.setSpan(new com.tencent.mm.wallet_core.ui.f(new com.tencent.mm.wallet_core.ui.f.a()
    {
      public final void bwz()
      {
        AppMethodBeat.i(63718);
        Log.i("MicroMsg.Aa.PaylistAAUI", "click AlertMsgTips");
        int i = a.i.urge_aa_confirm_msg;
        if (!ab.Lj(PaylistAAUI.a(PaylistAAUI.this))) {
          i = a.i.urge_aa_confirm_msg_single;
        }
        for (;;)
        {
          com.tencent.mm.ui.widget.a.f.a locala = new com.tencent.mm.ui.widget.a.f.a(PaylistAAUI.this);
          locala.aR(PaylistAAUI.this.getString(a.i.urge_aa_confirm_msg_title));
          View localView = com.tencent.mm.ui.ad.kS(PaylistAAUI.this).inflate(a.g.urge_aa_dialog_centerview, null);
          ImageView localImageView = (ImageView)localView.findViewById(a.f.image);
          TextView localTextView = (TextView)localView.findViewById(a.f.text);
          localImageView.setImageResource(a.e.paylist_urge_atall_hint);
          localTextView.setText(i);
          locala.iK(localView);
          locala.ayp(a.i.app_send);
          locala.bBq(PaylistAAUI.this.getString(a.i.app_cancel));
          locala.Qlf = false;
          locala.a(new f.c()new f.c
          {
            public final void g(boolean paramAnonymous2Boolean, String paramAnonymous2String) {}
          }, new f.c()
          {
            public final void g(boolean paramAnonymous2Boolean, String paramAnonymous2String)
            {
              AppMethodBeat.i(63717);
              PaylistAAUI.b(PaylistAAUI.this);
              AppMethodBeat.o(63717);
            }
          });
          locala.show();
          com.tencent.mm.plugin.report.service.h.IzE.a(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(7), Integer.valueOf(PaylistAAUI.c(PaylistAAUI.this)) });
          AppMethodBeat.o(63718);
          return;
        }
      }
    }), 0, paramBundle.length(), 18);
    this.mPP.setText(paramBundle);
    this.mPQ = ((TextView)findViewById(a.f.paylist_aa_bottom_tip_tv));
    ar.a(this.mPQ.getPaint(), 0.8F);
    bxh();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.PaylistAAUI
 * JD-Core Version:    0.7.0.1
 */