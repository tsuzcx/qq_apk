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
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.av.r.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.aa.model.b.g.c;
import com.tencent.mm.plugin.aa.model.b.g.d;
import com.tencent.mm.plugin.aa.model.b.g.e;
import com.tencent.mm.plugin.aa.model.i;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.utils.WcPayTextApppearanceSpan;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.w;
import com.tencent.mm.protocal.protobuf.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.view.ViewAnimHelper;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e.a;
import java.util.List;

public class PaylistAAUI
  extends BaseAAPresenterActivity
{
  private static int jYE = 1;
  private static int jYF = 2;
  private static int jYG = 3;
  private static int jYH = 4;
  private String dFw;
  private String dXh;
  private Dialog jUC;
  private int jUH;
  private Dialog jUV;
  private String jVs;
  private String jVt;
  private String jVv;
  private com.tencent.mm.plugin.aa.model.b.g jVw;
  private View jWj;
  private String jYA;
  private String jYB;
  private int jYC;
  private long jYD;
  private com.tencent.mm.plugin.aa.model.b.f jYk;
  private LinearLayout jYl;
  private LinearLayout jYm;
  private LinearLayout jYn;
  private LinearLayout jYo;
  private LinearLayout jYp;
  private RelativeLayout jYq;
  private WalletTextView jYr;
  private Button jYs;
  private TextView jYt;
  private TextView jYu;
  private String jYv;
  private TextView jYw;
  private TextView jYx;
  private TextView jYy;
  private TextView jYz;
  private String title;
  
  public PaylistAAUI()
  {
    AppMethodBeat.i(63734);
    this.jVw = ((com.tencent.mm.plugin.aa.model.b.g)aq(com.tencent.mm.plugin.aa.model.b.g.class));
    this.jYk = ((com.tencent.mm.plugin.aa.model.b.f)au(com.tencent.mm.plugin.aa.model.b.f.class));
    this.jUV = null;
    this.jUC = null;
    AppMethodBeat.o(63734);
  }
  
  private static boolean P(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 == com.tencent.mm.plugin.aa.model.a.jRS) && (paramInt2 != com.tencent.mm.plugin.aa.model.a.jRW) && (paramInt3 == com.tencent.mm.plugin.aa.model.a.jRO);
  }
  
  private void a(final TextView paramTextView, SpannableString paramSpannableString, String paramString, final y paramy)
  {
    AppMethodBeat.i(213128);
    Object localObject1 = getResources().getDrawable(2131690732);
    ((Drawable)localObject1).setColorFilter(getResources().getColor(2131099783), PorterDuff.Mode.SRC_ATOP);
    ((Drawable)localObject1).setBounds(0, 0, at.fromDPToPix(getContext(), 20), at.fromDPToPix(getContext(), 20));
    localObject1 = new com.tencent.mm.ui.widget.a((Drawable)localObject1);
    com.tencent.mm.wallet_core.ui.e locale = new com.tencent.mm.wallet_core.ui.e(new e.a()
    {
      public final void bmr()
      {
        AppMethodBeat.i(213127);
        Log.i("MicroMsg.Aa.PaylistAAUI", "launcherTipTv img click");
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(213126);
            com.tencent.mm.plugin.report.service.h.CyF.a(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(12), Integer.valueOf(PaylistAAUI.c(PaylistAAUI.this)) });
            if (PaylistAAUI.g(PaylistAAUI.this) == null) {
              PaylistAAUI.a(PaylistAAUI.this, com.tencent.mm.ui.base.h.a(PaylistAAUI.this, 3, 2131821007, PaylistAAUI.this.getString(2131762446), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                {
                  AppMethodBeat.i(213124);
                  if ((PaylistAAUI.g(PaylistAAUI.this) != null) && (PaylistAAUI.g(PaylistAAUI.this).isShowing())) {
                    PaylistAAUI.g(PaylistAAUI.this).dismiss();
                  }
                  AppMethodBeat.o(213124);
                }
              }));
            }
            q.bcU().a(PaylistAAUI.27.this.jYT.KBA, new r.a()
            {
              public final void a(String paramAnonymous3String1, Bitmap paramAnonymous3Bitmap, String paramAnonymous3String2)
              {
                AppMethodBeat.i(213125);
                Log.i("MicroMsg.Aa.PaylistAAUI", "onLoadImageEnd() url:%s path:%s", new Object[] { paramAnonymous3String1, paramAnonymous3String2 });
                if ((PaylistAAUI.g(PaylistAAUI.this) != null) && (PaylistAAUI.g(PaylistAAUI.this).isShowing())) {
                  PaylistAAUI.g(PaylistAAUI.this).dismiss();
                }
                if (paramAnonymous3Bitmap != null)
                {
                  paramAnonymous3String1 = new Intent();
                  paramAnonymous3String1.putExtra("use_scene", 2);
                  paramAnonymous3String1.putExtra("scene", 1);
                  paramAnonymous3String1.putExtra("url", PaylistAAUI.27.this.jYT.KBA);
                  paramAnonymous3String1.putExtra("path", paramAnonymous3String2);
                  paramAnonymous3Bitmap = ViewAnimHelper.q(PaylistAAUI.27.this.gym, PaylistAAUI.this.getContext().getWindow().getDecorView());
                  paramAnonymous3String2 = paramAnonymous3Bitmap.QMg;
                  paramAnonymous3String2.right = (paramAnonymous3String2.left + com.tencent.mm.cb.a.fromDPToPix(PaylistAAUI.this.getContext(), 30));
                  paramAnonymous3Bitmap.QMg.set(paramAnonymous3String2);
                  paramAnonymous3String1.putExtra("view_info", paramAnonymous3Bitmap);
                  paramAnonymous3String1.putExtra("aa_type", PaylistAAUI.c(PaylistAAUI.this));
                  com.tencent.mm.br.c.b(PaylistAAUI.this, "aa", ".ui.AAImagPreviewUI", paramAnonymous3String1, 100);
                  AppMethodBeat.o(213125);
                  return;
                }
                Toast.makeText(PaylistAAUI.this, 2131755042, 1).show();
                AppMethodBeat.o(213125);
              }
            });
            AppMethodBeat.o(213126);
          }
        });
        AppMethodBeat.o(213127);
      }
    });
    final SpannableStringBuilder localSpannableStringBuilder2 = new SpannableStringBuilder(paramSpannableString);
    SpannableStringBuilder localSpannableStringBuilder1 = new SpannableStringBuilder(paramString);
    if (!Util.isNullOrNil(paramy.KBA))
    {
      localSpannableStringBuilder2.setSpan(localObject1, 0, 1, 17);
      localSpannableStringBuilder2.setSpan(locale, 0, localSpannableStringBuilder1.length(), 18);
    }
    Object localObject2 = paramTextView.getPaint();
    int i = paramTextView.getMeasuredWidth();
    float f1 = ((TextPaint)localObject2).measureText(" ...  ");
    float f2 = at.fromDPToPix(getContext(), 19);
    float f3 = i;
    paramString = new StaticLayout(localSpannableStringBuilder2, (TextPaint)localObject2, i, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    i = paramString.getLineCount();
    Log.d("MicroMsg.Aa.PaylistAAUI", "lineCount ： %s", new Object[] { Integer.valueOf(i) });
    if (i <= 0)
    {
      Log.i("MicroMsg.Aa.PaylistAAUI", "lineCount <= 0");
      AppMethodBeat.o(213128);
      return;
    }
    if (i <= 2)
    {
      paramTextView.setText(localSpannableStringBuilder2);
      AppMethodBeat.o(213128);
      return;
    }
    i = paramString.getLineEnd(0);
    localSpannableStringBuilder2 = new SpannableStringBuilder(paramSpannableString.subSequence(0, i + new StaticLayout(paramSpannableString.subSequence(i, paramSpannableString.length()), (TextPaint)localObject2, (int)(f3 - (f1 + f2)), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false).getLineEnd(0)));
    localSpannableStringBuilder2.append(" ...  ");
    if (!Util.isNullOrNil(paramy.KBA))
    {
      localSpannableStringBuilder2.setSpan(localObject1, 0, 1, 17);
      localSpannableStringBuilder2.setSpan(locale, 0, localSpannableStringBuilder1.length(), 18);
    }
    localObject2 = getResources().getDrawable(2131689474);
    ((Drawable)localObject2).setColorFilter(getResources().getColor(2131099749), PorterDuff.Mode.SRC_ATOP);
    ((Drawable)localObject2).setBounds(0, 0, at.fromDPToPix(getContext(), 19), at.fromDPToPix(getContext(), 19));
    localSpannableStringBuilder2.setSpan(new com.tencent.mm.ui.widget.a((Drawable)localObject2), localSpannableStringBuilder2.length() - 1, localSpannableStringBuilder2.length(), 33);
    localObject2 = new SpannableStringBuilder(paramSpannableString);
    ((SpannableStringBuilder)localObject2).append(" ");
    if (!Util.isNullOrNil(paramy.KBA))
    {
      ((SpannableStringBuilder)localObject2).setSpan(localObject1, 0, 1, 17);
      ((SpannableStringBuilder)localObject2).setSpan(locale, 0, localSpannableStringBuilder1.length(), 18);
    }
    paramy = getResources().getDrawable(2131689473);
    paramy.setColorFilter(getResources().getColor(2131099749), PorterDuff.Mode.SRC_ATOP);
    paramy.setBounds(0, 0, at.fromDPToPix(getContext(), 19), at.fromDPToPix(getContext(), 19));
    ((SpannableStringBuilder)localObject2).setSpan(new com.tencent.mm.ui.widget.a(paramy), ((SpannableStringBuilder)localObject2).length() - 1, ((SpannableStringBuilder)localObject2).length(), 33);
    if (paramString.getLineCount() > 2)
    {
      paramTextView.setText(localSpannableStringBuilder2);
      paramTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(213101);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/PaylistAAUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (paramAnonymousView.isSelected())
          {
            paramTextView.setText(localSpannableStringBuilder2);
            paramTextView.setSelected(false);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/PaylistAAUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(213101);
            return;
            paramTextView.setText(this.jYK);
            paramTextView.setSelected(true);
          }
        }
      });
      paramTextView.setSelected(true);
      AppMethodBeat.o(213128);
      return;
    }
    paramTextView.setText(paramSpannableString);
    paramTextView.setOnClickListener(null);
    AppMethodBeat.o(213128);
  }
  
  private void a(y paramy)
  {
    AppMethodBeat.i(213129);
    if (i.aQ(paramy.KBx) != null)
    {
      this.jYm.setVisibility(8);
      this.jYl.setVisibility(0);
      paramy = getString(2131755085, new Object[] { Double.valueOf(i.o(paramy.KBY)) });
      String str = getString(2131763855) + paramy;
      SpannableString localSpannableString = new SpannableString(str);
      WcPayTextApppearanceSpan localWcPayTextApppearanceSpan = new WcPayTextApppearanceSpan((int)this.jYw.getTextSize(), ColorStateList.valueOf(getResources().getColor(2131100924)));
      localWcPayTextApppearanceSpan.IoX = com.tencent.mm.wallet_core.ui.f.gA(getContext());
      int i = str.lastIndexOf(paramy);
      int j = str.lastIndexOf(paramy);
      localSpannableString.setSpan(localWcPayTextApppearanceSpan, i, paramy.length() + j, 17);
      this.jYw.setText(localSpannableString);
      this.jYw.setTextColor(getResources().getColor(2131100924));
      AppMethodBeat.o(213129);
      return;
    }
    this.jYm.setVisibility(0);
    this.jYl.setVisibility(8);
    this.jYr = ((WalletTextView)findViewById(2131305267));
    this.jYr.setVisibility(8);
    ((TextView)this.jYm.findViewById(2131305834)).setVisibility(8);
    this.jYs = ((Button)this.jYm.findViewById(2131305832));
    if ((paramy.state == com.tencent.mm.plugin.aa.model.a.jRP) || (paramy.state == com.tencent.mm.plugin.aa.model.a.jRQ))
    {
      this.jYs.setVisibility(8);
      AppMethodBeat.o(213129);
      return;
    }
    this.jYs.setText(getString(2131763843));
    this.jYs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(213102);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/PaylistAAUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.i("MicroMsg.Aa.PaylistAAUI", "click mInstantPayBtn ForCustomize");
        paramAnonymousView = PaylistAAUI.this.getIntent();
        paramAnonymousView.putExtra("user_name", PaylistAAUI.e(PaylistAAUI.this));
        paramAnonymousView.putExtra("user_real_name", PaylistAAUI.h(PaylistAAUI.this));
        com.tencent.mm.br.c.b(PaylistAAUI.this, "aa", ".ui.AARemittanceUI", paramAnonymousView, 234);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/PaylistAAUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(213102);
      }
    });
    paramy = (LinearLayout.LayoutParams)this.jYs.getLayoutParams();
    paramy.topMargin = 0;
    this.jYs.setLayoutParams(paramy);
    AppMethodBeat.o(213129);
  }
  
  private void a(List<w> paramList, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(63738);
    ((TextView)findViewById(2131305849)).setText(paramString);
    paramString = this.jYy;
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
      localLinearLayout1 = (LinearLayout)findViewById(2131305850);
      localLinearLayout1.removeAllViews();
      i = 0;
      if (i >= paramList.size()) {
        break label830;
      }
      localObject2 = (w)paramList.get(i);
      if (i < paramList.size() - 1) {
        break label519;
      }
      j = 1;
      localObject1 = (LinearLayout)getLayoutInflater().inflate(2131495901, localLinearLayout1, false);
      paramString = (ImageView)((LinearLayout)localObject1).findViewById(2131305838);
      localObject3 = (TextView)((LinearLayout)localObject1).findViewById(2131305841);
      localTextView1 = (TextView)((LinearLayout)localObject1).findViewById(2131305842);
      localTextView2 = (TextView)((LinearLayout)localObject1).findViewById(2131305839);
      localLinearLayout2 = (LinearLayout)((LinearLayout)localObject1).findViewById(2131305840);
      a.b.c(paramString, ((w)localObject2).KBN);
      localObject4 = getContext();
      localObject5 = this.jYk;
      paramString = ((w)localObject2).KBN;
      if (!Util.isNullOrNil(paramString)) {
        break label525;
      }
      paramString = "";
      ((TextView)localObject3).setText(l.b((Context)localObject4, paramString, ((TextView)localObject3).getTextSize()));
      if (((w)localObject2).KBP != com.tencent.mm.plugin.aa.model.a.jRZ) {
        break label576;
      }
      paramString = getString(2131755085, new Object[] { Double.valueOf(i.o(((w)localObject2).KBF)) });
      localObject3 = getString(2131763855) + paramString;
      localObject4 = new SpannableString((CharSequence)localObject3);
      localObject5 = new WcPayTextApppearanceSpan((int)localTextView1.getTextSize(), ColorStateList.valueOf(getResources().getColor(2131100924)));
      ((WcPayTextApppearanceSpan)localObject5).IoX = com.tencent.mm.wallet_core.ui.f.aS(getContext(), 7);
      k = ((String)localObject3).lastIndexOf(paramString);
      m = ((String)localObject3).lastIndexOf(paramString);
      ((SpannableString)localObject4).setSpan(localObject5, k, paramString.length() + m, 17);
      localTextView1.setText((CharSequence)localObject4);
      localTextView1.setTextColor(getResources().getColor(2131100924));
      localTextView1.setVisibility(0);
      if (Util.isNullOrNil(((w)localObject2).KBL)) {
        break label559;
      }
      localTextView2.setText(((w)localObject2).KBL);
      localTextView2.setVisibility(0);
      localLinearLayout2.setGravity(48);
      label447:
      localLinearLayout1.addView((View)localObject1);
      label454:
      paramString = ((LinearLayout)localObject1).findViewById(2131299682);
      if (j == 0) {
        break label810;
      }
      paramString.setBackgroundColor(getContext().getResources().getColor(2131099648));
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
      localObject5 = ((com.tencent.mm.vending.app.a)localObject5).QYU.getStringExtra("chatroom");
      paramString = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(paramString, (String)localObject5);
      break label218;
      label559:
      localLinearLayout2.setGravity(16);
      localTextView2.setVisibility(8);
      break label447;
      label576:
      if (((w)localObject2).KBP == com.tencent.mm.plugin.aa.model.a.jRY)
      {
        paramString = getString(2131755085, new Object[] { Double.valueOf(i.o(((w)localObject2).KBF)) });
        localObject2 = getString(2131763834) + paramString;
        localObject3 = new SpannableString((CharSequence)localObject2);
        localObject4 = new WcPayTextApppearanceSpan((int)localTextView1.getTextSize(), ColorStateList.valueOf(getResources().getColor(2131100926)));
        ((WcPayTextApppearanceSpan)localObject4).IoX = com.tencent.mm.wallet_core.ui.f.aS(getContext(), 7);
        k = ((String)localObject2).lastIndexOf(paramString);
        m = ((String)localObject2).lastIndexOf(paramString);
        ((SpannableString)localObject3).setSpan(localObject4, k, paramString.length() + m, 17);
        localTextView1.setText((CharSequence)localObject3);
        localTextView1.setTextColor(getResources().getColor(2131100926));
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
      paramString.setBackgroundColor(getContext().getResources().getColor(2131101085));
    }
    label830:
    AppMethodBeat.o(63738);
  }
  
  private void bmY()
  {
    AppMethodBeat.i(63736);
    this.jUV = com.tencent.mm.wallet_core.ui.h.c(this, false, null);
    this.jWj.setVisibility(4);
    this.jVw.jUk.bmq().f(new com.tencent.mm.vending.c.a() {}).a(new com.tencent.mm.vending.g.d.a()
    {
      public final void cn(final Object paramAnonymousObject)
      {
        AppMethodBeat.i(63719);
        Log.i("MicroMsg.Aa.PaylistAAUI", "onInterrupt: %s", new Object[] { paramAnonymousObject });
        PaylistAAUI.this.hideLoading();
        if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof com.tencent.mm.protocal.protobuf.a)))
        {
          paramAnonymousObject = (com.tencent.mm.protocal.protobuf.a)paramAnonymousObject;
          localObject = paramAnonymousObject.dQx;
          String str1 = paramAnonymousObject.lHA;
          String str2 = paramAnonymousObject.lHB;
          com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(PaylistAAUI.this.getContext());
          locala.boo((String)localObject);
          locala.bou(str2).c(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(213122);
              Log.i("MicroMsg.Aa.PaylistAAUI", "click getPayListDetail onInterrupt Item");
              com.tencent.mm.wallet_core.ui.f.p(PaylistAAUI.this.getContext(), paramAnonymousObject.qwt, false);
              AppMethodBeat.o(213122);
            }
          });
          locala.bov(str1);
          locala.hbn().show();
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
  
  private void bmw()
  {
    AppMethodBeat.i(213130);
    if (Util.isNullOrNil(this.jYv))
    {
      str1 = getString(2131763840);
      com.tencent.mm.wallet_core.ui.f.a(this.jYt, str1, 0, str1.length(), new com.tencent.mm.wallet_core.ui.e(new e.a()
      {
        public final void bmr()
        {
          AppMethodBeat.i(213117);
          PaylistAAUI.n(PaylistAAUI.this);
          com.tencent.mm.plugin.report.service.h.CyF.a(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(10), Integer.valueOf(PaylistAAUI.c(PaylistAAUI.this)) });
          AppMethodBeat.o(213117);
        }
      }), getContext());
      this.jYt.setVisibility(0);
      this.jYu.setVisibility(8);
      AppMethodBeat.o(213130);
      return;
    }
    String str1 = getString(2131763841);
    String str2 = getString(2131757673, new Object[] { this.jYv, str1 });
    SpannableString localSpannableString = l.c(this, str2);
    com.tencent.mm.wallet_core.ui.f.a(this.jYu, str2, localSpannableString.length() - str1.length(), localSpannableString.length(), new com.tencent.mm.wallet_core.ui.e(new e.a()
    {
      public final void bmr()
      {
        AppMethodBeat.i(213118);
        PaylistAAUI.n(PaylistAAUI.this);
        com.tencent.mm.plugin.report.service.h.CyF.a(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(10), Integer.valueOf(PaylistAAUI.c(PaylistAAUI.this)) });
        AppMethodBeat.o(213118);
      }
    }), getContext());
    this.jYt.setVisibility(8);
    this.jYu.setVisibility(0);
    AppMethodBeat.o(213130);
  }
  
  public final void b(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(63742);
    if (paramInt == -1)
    {
      Log.i("MicroMsg.Aa.PaylistAAUI", "pay success, payMsgId: %s", new Object[] { this.dXh });
      RealnameGuideHelper localRealnameGuideHelper = (RealnameGuideHelper)paramIntent.getParcelableExtra("key_realname_guide_helper");
      if (localRealnameGuideHelper != null)
      {
        Log.i("MicroMsg.Aa.PaylistAAUI", "do realname guide");
        Intent localIntent = new Intent();
        localIntent.putExtra("key_realname_guide_helper", localRealnameGuideHelper);
        com.tencent.mm.br.c.b(this, "wallet_core", ".id_verify.RealnameDialogActivity", localIntent);
      }
      i.SB(this.jVv);
      finish();
      this.jVw.jUm.w(this.dXh, this.jYA, this.jVt).f(new PaylistAAUI.13(this));
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(407L, 12L, 1L, false);
      paramIntent = paramIntent.getStringExtra("key_trans_id");
      this.jVw.jUn.b(this.jYD, this.dFw, paramIntent);
    }
    AppMethodBeat.o(63742);
  }
  
  public int getLayoutId()
  {
    return 2131495902;
  }
  
  public void hideLoading()
  {
    AppMethodBeat.i(63743);
    if ((this.jUV != null) && (this.jUV.isShowing()))
    {
      this.jUV.dismiss();
      this.jUV = null;
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
          paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.axQ(), "com/tencent/mm/plugin/aa/ui/PaylistAAUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramIntent.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/PaylistAAUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    setActionbarColor(getResources().getColor(2131101424));
    this.jVv = getIntent().getStringExtra("chatroom");
    this.jYl = ((LinearLayout)findViewById(2131305844));
    this.jYm = ((LinearLayout)findViewById(2131305833));
    this.jYn = ((LinearLayout)findViewById(2131305823));
    this.jYo = ((LinearLayout)findViewById(2131305846));
    this.jYq = ((RelativeLayout)findViewById(2131305828));
    this.jYw = ((TextView)findViewById(2131305845));
    ao.a(this.jYw.getPaint(), 0.8F);
    this.jYx = ((TextView)findViewById(2131305827));
    this.jWj = findViewById(2131307160);
    this.jYy = ((TextView)findViewById(2131305847));
    ao.a(this.jYy.getPaint(), 0.8F);
    this.jYy.setClickable(true);
    this.jYy.setOnTouchListener(new o(this));
    paramBundle = new SpannableStringBuilder(getString(2131763862));
    paramBundle.setSpan(new com.tencent.mm.wallet_core.ui.e(new e.a()
    {
      public final void bmr()
      {
        AppMethodBeat.i(63718);
        Log.i("MicroMsg.Aa.PaylistAAUI", "click AlertMsgTips");
        if (!ab.Eq(PaylistAAUI.a(PaylistAAUI.this))) {}
        for (int i = 2131766955;; i = 2131766953)
        {
          f.a locala = new f.a(PaylistAAUI.this);
          locala.aC(PaylistAAUI.this.getString(2131766956));
          View localView = aa.jQ(PaylistAAUI.this).inflate(2131496783, null);
          ImageView localImageView = (ImageView)localView.findViewById(2131302526);
          TextView localTextView = (TextView)localView.findViewById(2131308977);
          localImageView.setImageResource(2131234381);
          localTextView.setText(i);
          locala.hu(localView);
          locala.apa(2131755976);
          locala.boB(PaylistAAUI.this.getString(2131755761));
          locala.JnN = false;
          locala.a(new f.c()new f.c
          {
            public final void e(boolean paramAnonymous2Boolean, String paramAnonymous2String) {}
          }, new f.c()
          {
            public final void e(boolean paramAnonymous2Boolean, String paramAnonymous2String)
            {
              AppMethodBeat.i(63717);
              PaylistAAUI.b(PaylistAAUI.this);
              AppMethodBeat.o(63717);
            }
          });
          locala.show();
          com.tencent.mm.plugin.report.service.h.CyF.a(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(7), Integer.valueOf(PaylistAAUI.c(PaylistAAUI.this)) });
          AppMethodBeat.o(63718);
          return;
        }
      }
    }), 0, paramBundle.length(), 18);
    this.jYy.setText(paramBundle);
    this.jYz = ((TextView)findViewById(2131305826));
    ao.a(this.jYz.getPaint(), 0.8F);
    bmY();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.PaylistAAUI
 * JD-Core Version:    0.7.0.1
 */