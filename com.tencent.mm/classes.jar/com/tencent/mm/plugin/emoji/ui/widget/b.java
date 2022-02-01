package com.tencent.mm.plugin.emoji.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.h.c;
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.plugin.emoji.h.f;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.j;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/widget/MMWecoinPayHalfDialog;", "", "mContext", "Landroid/content/Context;", "mGoodName", "", "mGoodWecoin", "mAccountWecoin", "mConfirmCallback", "Lkotlin/Function0;", "", "mWecoinBalanceClickCallback", "mUserCancelCallback", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "DEFAULT_PADDING_LEFT", "", "DEFAULT_PADDING_RIGHT", "balanceWecoinTv", "Landroid/widget/TextView;", "dialog", "Lcom/tencent/mm/ui/widget/dialog/MMHalfBottomDialog;", "goodWecoinTv", "hidingStatus", "", "getMAccountWecoin", "()Ljava/lang/String;", "getMConfirmCallback", "()Lkotlin/jvm/functions/Function0;", "setMConfirmCallback", "(Lkotlin/jvm/functions/Function0;)V", "getMContext", "()Landroid/content/Context;", "getMGoodName", "getMGoodWecoin", "mPaddingLeft", "mPaddingRight", "getMUserCancelCallback", "setMUserCancelCallback", "mUserConfirmClicked", "getMWecoinBalanceClickCallback", "setMWecoinBalanceClickCallback", "progressBar", "Landroid/widget/ProgressBar;", "wecoinBalanceArea", "Landroid/view/View;", "getLayoutId", "isHiding", "tryHide", "tryShow", "paddingLeft", "paddingRight", "updateBalanceWecoin", "numberString", "updateGoodWecoin", "Companion", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a ydh;
  private int bjD;
  private int bjF;
  public j lCH;
  private final Context mContext;
  private ProgressBar progressBar;
  private final String ydi;
  private final String ydj;
  private final String ydk;
  private kotlin.g.a.a<ah> ydl;
  private kotlin.g.a.a<ah> ydm;
  private kotlin.g.a.a<? extends Object> ydn;
  private TextView ydo;
  private TextView ydp;
  private View ydq;
  public boolean ydr;
  private final int yds;
  private final int ydt;
  private boolean ydu;
  
  static
  {
    AppMethodBeat.i(270772);
    ydh = new b.a((byte)0);
    AppMethodBeat.o(270772);
  }
  
  public b(Context paramContext, String paramString1, String paramString2, String paramString3, kotlin.g.a.a<ah> parama1, kotlin.g.a.a<ah> parama2, kotlin.g.a.a<? extends Object> parama)
  {
    AppMethodBeat.i(270757);
    this.mContext = paramContext;
    this.ydi = paramString1;
    this.ydj = paramString2;
    this.ydk = paramString3;
    this.ydl = parama1;
    this.ydm = parama2;
    this.ydn = parama;
    this.ydr = true;
    this.yds = com.tencent.mm.cd.a.bs(this.mContext, h.c.Edge_2A);
    this.ydt = this.yds;
    this.bjD = this.yds;
    this.bjF = this.ydt;
    AppMethodBeat.o(270757);
  }
  
  private static final void a(b paramb)
  {
    AppMethodBeat.i(270761);
    s.u(paramb, "this$0");
    paramb.ydu = true;
    kotlin.g.a.a locala = paramb.ydl;
    if (locala != null) {
      locala.invoke();
    }
    paramb = paramb.lCH;
    if (paramb != null) {
      paramb.cyW();
    }
    AppMethodBeat.o(270761);
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(270764);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/widget/MMWecoinPayHalfDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramb = paramb.lCH;
    if (paramb != null) {
      paramb.cyW();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/emoji/ui/widget/MMWecoinPayHalfDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(270764);
  }
  
  private static final void b(b paramb)
  {
    AppMethodBeat.i(270768);
    s.u(paramb, "this$0");
    if (!paramb.ydu)
    {
      paramb = paramb.ydn;
      if (paramb != null) {
        paramb.invoke();
      }
      Log.i("MicroMsg.MMWecoinPayConfirmBottomDialog", "dialog dismiss, user cancel");
      AppMethodBeat.o(270768);
      return;
    }
    Log.i("MicroMsg.MMWecoinPayConfirmBottomDialog", "dialog dismiss, user clicked pay confirm");
    AppMethodBeat.o(270768);
  }
  
  private static final void b(b paramb, View paramView)
  {
    AppMethodBeat.i(270766);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/widget/MMWecoinPayHalfDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramb = paramb.ydm;
    if (paramb != null) {
      paramb.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/emoji/ui/widget/MMWecoinPayHalfDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(270766);
  }
  
  public final void aoZ(String paramString)
  {
    AppMethodBeat.i(270784);
    s.u(paramString, "numberString");
    TextView localTextView = this.ydo;
    if (localTextView != null) {
      localTextView.setText((CharSequence)paramString);
    }
    AppMethodBeat.o(270784);
  }
  
  public final void dDn()
  {
    AppMethodBeat.i(270782);
    if (this.lCH == null)
    {
      this.lCH = new j(this.mContext, 2, 0);
      localObject1 = this.lCH;
      if (localObject1 != null) {
        ((j)localObject1).au((CharSequence)this.mContext.getResources().getString(h.h.wecoin_pay_dialog_button_wording));
      }
      localObject1 = this.lCH;
      if (localObject1 != null) {
        ((j)localObject1).aFe(0);
      }
      localObject1 = this.lCH;
      if (localObject1 != null) {
        ((j)localObject1).agfR = new b..ExternalSyntheticLambda2(this);
      }
      localObject1 = LayoutInflater.from(this.mContext).inflate(h.f.wecoin_pay_confirm_bottom_dialog_custom_view, null);
      if (localObject1 != null)
      {
        this.ydo = ((TextView)((View)localObject1).findViewById(h.e.account_wecoin_tv));
        localObject2 = this.ydo;
        if (localObject2 != null) {
          ((TextView)localObject2).setText((CharSequence)this.ydk);
        }
        this.ydp = ((TextView)((View)localObject1).findViewById(h.e.good_wecoin_tv));
        localObject2 = this.ydp;
        if (localObject2 != null) {
          ((TextView)localObject2).setText((CharSequence)this.ydj);
        }
        ((ImageView)((View)localObject1).findViewById(h.e.close_icon_btn)).setOnClickListener(new b..ExternalSyntheticLambda1(this));
        ((TextView)((View)localObject1).findViewById(h.e.good_name_tv)).setText((CharSequence)this.ydi);
        this.progressBar = ((ProgressBar)((View)localObject1).findViewById(h.e.account_wecoin_progress));
        this.ydq = ((View)localObject1).findViewById(h.e.account_wecoin_group);
        localObject2 = this.ydq;
        if (localObject2 != null) {
          ((View)localObject2).setOnClickListener(new b..ExternalSyntheticLambda0(this));
        }
      }
      Object localObject2 = this.lCH;
      if (localObject2 != null) {
        ((j)localObject2).agfT = new b..ExternalSyntheticLambda3(this);
      }
      localObject2 = this.lCH;
      if (localObject2 != null) {
        ((j)localObject2).F((View)localObject1, this.bjD, this.bjF);
      }
    }
    Object localObject1 = this.lCH;
    if (localObject1 != null) {
      ((j)localObject1).dDn();
    }
    this.ydr = false;
    AppMethodBeat.o(270782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */