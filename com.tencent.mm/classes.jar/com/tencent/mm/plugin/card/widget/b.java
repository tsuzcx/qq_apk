package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.plugin.card.c.n;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.ui.CardDetailUI.a;
import com.tencent.mm.plugin.card.ui.CardDetailUI.a.6;
import com.tencent.mm.plugin.card.ui.CardDetailUI.a.7;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.protocal.protobuf.fum;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  extends a
{
  private final String TAG = "MicroMsg.CardWidgetCommon";
  protected TextView mll;
  private boolean wEY = false;
  protected TextView wKP;
  protected TextView wKQ;
  protected Button wKR;
  protected LinearLayout wKS;
  protected TextView wKT;
  protected WeImageView wKU;
  protected ImageView wKV;
  protected ImageView wKW;
  protected ImageView wKX;
  protected ViewGroup wKY;
  protected ImageView wKZ;
  protected TextView wLa;
  protected ImageView wLb;
  protected View wLc;
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  private static void a(String paramString, ImageView paramImageView, int paramInt)
  {
    AppMethodBeat.i(293773);
    Object localObject = new c.a();
    ((c.a)localObject).prefixPath = com.tencent.mm.loader.i.b.bmz();
    ((c.a)localObject).oKH = r.bKf();
    ((c.a)localObject).fullPath = m.akH(paramString);
    ((c.a)localObject).oKp = true;
    if (paramInt > 0) {
      ((c.a)localObject).oKI = paramInt;
    }
    for (((c.a)localObject).nrc = true;; ((c.a)localObject).nrc = false)
    {
      ((c.a)localObject).oKn = true;
      localObject = ((c.a)localObject).bKx();
      r.bKe().a(paramString, paramImageView, (c)localObject);
      AppMethodBeat.o(293773);
      return;
    }
  }
  
  public final void IO(int paramInt)
  {
    AppMethodBeat.i(113896);
    AppMethodBeat.o(113896);
  }
  
  public final void P(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(113899);
    if (this.wKR != null)
    {
      aek localaek = this.wru.djL().ZbH;
      if ((localaek != null) && (!TextUtils.isEmpty(localaek.title)) && (localaek.ZeU != 0L) && (this.wru.djF()))
      {
        this.wKR.setClickable(false);
        this.wKR.setVisibility(0);
        this.wKU.setVisibility(8);
        AppMethodBeat.o(113899);
        return;
      }
      if ((this.wru.djL().ZbG != null) && (!TextUtils.isEmpty(this.wru.djL().ZbG.title)) && (!TextUtils.isEmpty(this.wru.djL().ZbG.url)) && (this.wru.djF()))
      {
        this.wKR.setVisibility(0);
        this.wKR.setEnabled(true);
        if ((!TextUtils.isEmpty(this.wru.djL().code)) && (this.wru.djL().Zby != 0))
        {
          this.wKU.setVisibility(0);
          AppMethodBeat.o(113899);
          return;
        }
        this.wKU.setVisibility(8);
        AppMethodBeat.o(113899);
        return;
      }
      if ((paramBoolean1) && (!TextUtils.isEmpty(this.wru.djL().code)) && (this.wru.djF()))
      {
        this.wKR.setVisibility(0);
        this.wKR.setEnabled(paramBoolean2);
        this.wKU.setVisibility(8);
        AppMethodBeat.o(113899);
        return;
      }
      if ((paramBoolean1) && (!this.wru.djF()))
      {
        this.wKR.setVisibility(0);
        this.wKR.setEnabled(false);
        this.wKU.setVisibility(8);
        AppMethodBeat.o(113899);
        return;
      }
      this.wKR.setVisibility(8);
      this.wKU.setVisibility(8);
    }
    AppMethodBeat.o(113899);
  }
  
  protected final void doX()
  {
    AppMethodBeat.i(113893);
    this.mll = ((TextView)this.wKN.findViewById(a.d.fvy));
    this.wKP = ((TextView)this.wKN.findViewById(a.d.whO));
    this.wKQ = ((TextView)this.wKN.findViewById(a.d.wfs));
    this.wKR = ((Button)this.wKN.findViewById(a.d.wfT));
    this.wKS = ((LinearLayout)this.wKN.findViewById(a.d.gdN));
    this.wLc = this.wKN.findViewById(a.d.wjK);
    this.wKU = ((WeImageView)this.wKN.findViewById(a.d.wfN));
    this.wKT = ((TextView)this.wKN.findViewById(a.d.whm));
    this.wKV = ((ImageView)this.wKN.findViewById(a.d.weO));
    this.wKY = ((ViewGroup)this.wKN.findViewById(a.d.wjL));
    this.wKZ = ((ImageView)this.wKN.findViewById(a.d.wkT));
    this.wLa = ((TextView)this.wKN.findViewById(a.d.wkU));
    this.wLb = ((ImageView)this.wKN.findViewById(a.d.wkS));
    this.wKW = ((ImageView)this.wKN.findViewById(a.d.wjI));
    this.wKX = ((ImageView)this.wKN.findViewById(a.d.wjJ));
    aw.d(this.uov.getPaint());
    aw.d(this.mll.getPaint());
    AppMethodBeat.o(113893);
  }
  
  protected final void doY()
  {
    AppMethodBeat.i(113894);
    Object localObject1;
    Object localObject2;
    label516:
    if ((this.wru.djK().ZdK != null) && (this.wru.djK().ZdK.size() > 0))
    {
      localObject1 = (aek)this.wru.djK().ZdK.get(0);
      if (!Util.isNullOrNil(((aek)localObject1).title)) {
        this.mll.setText(((aek)localObject1).title);
      }
      if (!Util.isNullOrNil(((aek)localObject1).wsz))
      {
        this.wKP.setText(((aek)localObject1).wsz);
        this.wKP.setVisibility(0);
        localObject2 = (LinearLayout.LayoutParams)this.wKP.getLayoutParams();
        if (Util.isNullOrNil(((aek)localObject1).wsA)) {
          break label580;
        }
        this.wKQ.setText(((aek)localObject1).wsA);
        this.wKQ.setVisibility(0);
        ((LinearLayout.LayoutParams)localObject2).bottomMargin = 0;
        label154:
        this.wKP.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.wKP.invalidate();
      }
    }
    else
    {
      if (Util.isNullOrNil(this.wru.djK().Zev)) {
        break label609;
      }
      l.f(this.wKV, this.wru.djK().Zev);
      this.wKV.setVisibility(0);
      label214:
      if (this.wru.djL() != null)
      {
        if (this.wru.djL().ZbP == null) {
          break label621;
        }
        localObject1 = this.wru.djL().ZbP;
        this.wKY.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 23) {
          this.wKY.setForeground(this.mContext.getResources().getDrawable(a.c.weD));
        }
        l.f(this.wKZ, ((aek)localObject1).Zmo);
        this.wLa.setText(((aek)localObject1).title);
        l.f(this.wLb, ((aek)localObject1).Zmp);
        this.wKY.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(293772);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/widget/CardWidgetCommon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (!Util.isNullOrNil(this.wLd.YIZ)) {
              ((cn)h.az(cn.class)).getFinderUtilApi().G(b.this.mContext, this.wLd.YIZ, l.doT());
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/widget/CardWidgetCommon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(293772);
              return;
              if (!Util.isNullOrNil(this.wLd.Zdw)) {
                com.tencent.mm.plugin.card.c.b.V(b.this.wru.djO(), this.wLd.Zdw, this.wLd.Zdx);
              } else if (!Util.isNullOrNil(this.wLd.url)) {
                com.tencent.mm.plugin.card.c.b.a((MMActivity)b.this.mContext, this.wLd.url, 0);
              }
            }
          }
        });
        if (this.wru.djL().ZbQ == null) {
          break label645;
        }
        localObject1 = this.wru.djL().ZbQ;
        this.wKW.setVisibility(0);
        this.wLc.setVisibility(8);
        a(((aek)localObject1).Zmq, this.wKW, com.tencent.mm.cd.a.fromDPToPix(this.mContext, 1));
        if (Util.isNullOrNil(((aek)localObject1).Zmr)) {
          break label633;
        }
        a(((aek)localObject1).Zmr, this.wKX, 0);
        this.wKX.setVisibility(0);
        this.wKW.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(293770);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/widget/CardWidgetCommon$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if ((!Util.isNullOrNil(this.wLf.ZeX)) && (!Util.isNullOrNil(this.wLf.mdD))) {
              ((cn)h.az(cn.class)).getFinderUtilApi().h(b.this.mContext, this.wLf.ZeX, this.wLf.mdD, l.doT());
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/widget/CardWidgetCommon$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(293770);
              return;
              if (!Util.isNullOrNil(this.wLf.Zdw)) {
                com.tencent.mm.plugin.card.c.b.V(b.this.wru.djO(), this.wLf.Zdw, this.wLf.Zdx);
              } else if (!Util.isNullOrNil(this.wLf.url)) {
                com.tencent.mm.plugin.card.c.b.a((MMActivity)b.this.mContext, this.wLf.url, 0);
              }
            }
          }
        });
        localObject1 = (CardDetailUI.a)((MMActivity)this.mContext).component(CardDetailUI.a.class);
        localObject2 = (ImageView)((CardDetailUI.a)localObject1).findViewById(a.d.wjJ);
        if ((localObject2 == null) || (!((ImageView)localObject2).isShown())) {
          break label674;
        }
        ((CardDetailUI.a)localObject1).view(a.e.wmv, a.d.wjI).desc(new CardDetailUI.a.6((CardDetailUI.a)localObject1)).type(ViewType.Button);
      }
      label339:
      if ((this.wKR != null) && (this.wKU != null)) {
        break label705;
      }
      label433:
      label449:
      Log.e("MicroMsg.CardWidgetCommon", "consumeBtn == null || mCardCodeImg == null");
    }
    label645:
    label1301:
    label1687:
    for (;;)
    {
      this.wKN.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(293769);
          int j = com.tencent.mm.cd.a.ms(b.this.mContext) - com.tencent.mm.cd.a.br(b.this.mContext, a.b.Edge_2A) - com.tencent.mm.cd.a.br(b.this.mContext, a.b.Edge_4A);
          int i = j;
          if (b.this.wKO.isShown()) {
            i = j - com.tencent.mm.cd.a.fromDPToPix(b.this.mContext, 48);
          }
          j = i;
          if (b.this.wKY.isShown()) {
            j = i - b.this.wKY.getWidth();
          }
          i = j;
          if (b.this.wKV.isShown()) {
            i = j - com.tencent.mm.cd.a.fromDPToPix(b.this.mContext, 20);
          }
          if (i > 0) {
            b.this.uov.setMaxWidth(i);
          }
          AppMethodBeat.o(293769);
        }
      });
      this.wKN.invalidate();
      AppMethodBeat.o(113894);
      return;
      this.wKP.setVisibility(8);
      break;
      label580:
      this.wKQ.setVisibility(8);
      ((LinearLayout.LayoutParams)localObject2).bottomMargin = this.mContext.getResources().getDimensionPixelSize(a.b.LargerPadding);
      break label154;
      label609:
      this.wKV.setVisibility(8);
      break label214;
      label621:
      this.wKY.setVisibility(8);
      break label339;
      label633:
      this.wKX.setVisibility(8);
      break label433;
      this.wKW.setVisibility(8);
      this.wKX.setVisibility(8);
      this.wLc.setVisibility(0);
      break label449;
      label674:
      ((CardDetailUI.a)localObject1).view(a.e.wmv, a.d.wjI).desc(new CardDetailUI.a.7((CardDetailUI.a)localObject1)).type(ViewType.Button);
      break label516;
      label705:
      if (this.wru.djL() == null)
      {
        Log.e("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo() == null");
        this.wKR.setVisibility(8);
        this.wKU.setVisibility(8);
      }
      else
      {
        if (this.wru.djL().ZbG != null)
        {
          Log.i("MicroMsg.CardWidgetCommon", "operate_field.title is " + this.wru.djL().ZbG.title);
          Log.d("MicroMsg.CardWidgetCommon", "operate_field.url is " + this.wru.djL().ZbG.url);
          Log.i("MicroMsg.CardWidgetCommon", "operate_field.aux_title is " + this.wru.djL().ZbG.wsA);
        }
        localObject1 = this.wru.djL().ZbH;
        if (localObject1 != null)
        {
          Log.i("MicroMsg.CardWidgetCommon", "limit_field.title is " + ((aek)localObject1).title);
          Log.i("MicroMsg.CardWidgetCommon", "limit_field.show_flag is " + ((aek)localObject1).ZeU);
          Log.i("MicroMsg.CardWidgetCommon", "limit_field.aux_title is " + ((aek)localObject1).wsA);
        }
        Object localObject3 = this.wru.djK().Zec;
        localObject2 = (LinearLayout)this.wKS.findViewById(a.d.wgc);
        if ((localObject3 != null) && (!Util.isNullOrNil(((fum)localObject3).abSI)))
        {
          ((LinearLayout)localObject2).setVisibility(0);
          ((LinearLayout)localObject2).removeAllViews();
          localObject3 = ((fum)localObject3).abSI.iterator();
        }
        while (((Iterator)localObject3).hasNext())
        {
          aek localaek = (aek)((Iterator)localObject3).next();
          View localView = LayoutInflater.from(this.mContext).inflate(a.e.wmx, (ViewGroup)localObject2, false);
          TextView localTextView1 = (TextView)localView.findViewById(a.d.wgf);
          TextView localTextView2 = (TextView)localView.findViewById(a.d.wgb);
          localTextView1.setText(localaek.title);
          localTextView2.setText(localaek.wsz);
          ((LinearLayout)localObject2).addView(localView);
          continue;
          ((LinearLayout)localObject2).setVisibility(8);
        }
        if ((localObject1 != null) && (!TextUtils.isEmpty(((aek)localObject1).title)) && (((aek)localObject1).ZeU != 0L) && (this.wru.djF()))
        {
          this.wKR.setClickable(false);
          this.wKR.setVisibility(0);
          this.wKR.setTextColor(this.mContext.getResources().getColor(a.a.White));
          this.wKR.setText(((aek)localObject1).title);
          if ((localObject1 != null) && (!TextUtils.isEmpty(((aek)localObject1).wsz)))
          {
            this.wKT.setText(((aek)localObject1).wsz);
            this.wKT.setVisibility(0);
          }
          for (;;)
          {
            this.wKU.setVisibility(8);
            if ((((aek)localObject1).ZeU & 0x2) <= 0L) {
              break label1301;
            }
            this.wKR.setBackgroundDrawable(l.ag(this.mContext, l.convertStringToRGB(this.wru.djK().nRQ, 150)));
            break;
            this.wKT.setVisibility(8);
          }
          if ((((aek)localObject1).ZeU & 0x4) > 0L)
          {
            this.wKR.setBackgroundDrawable(l.ag(this.mContext, this.mContext.getResources().getColor(a.a.light_grey)));
            this.wKR.setTextColor(this.mContext.getResources().getColor(a.a.UN_BW_0_Alpha_0_5));
          }
          else
          {
            this.wKR.setBackgroundDrawable(l.ag(this.mContext, l.alv(this.wru.djK().nRQ)));
          }
        }
        else if ((this.wru.djL().ZbG != null) && (!TextUtils.isEmpty(this.wru.djL().ZbG.title)) && (!TextUtils.isEmpty(this.wru.djL().ZbG.url)) && (this.wru.djF()))
        {
          this.wKR.setClickable(true);
          if (Build.VERSION.SDK_INT >= 23) {
            this.wKR.setForeground(this.mContext.getResources().getDrawable(a.c.wek));
          }
          this.wKR.setVisibility(0);
          this.wKR.setBackgroundDrawable(l.ag(this.mContext, l.alv(this.wru.djK().nRQ)));
          this.wKR.setTextColor(this.mContext.getResources().getColorStateList(a.a.White));
          this.wKR.setText(this.wru.djL().ZbG.title);
          if ((this.wru.djL().ZbG != null) && (!TextUtils.isEmpty(this.wru.djL().ZbG.wsA)))
          {
            this.wKT.setText(this.wru.djL().ZbG.wsA);
            this.wKT.setVisibility(0);
          }
          for (;;)
          {
            if (TextUtils.isEmpty(this.wru.djL().code)) {
              break label1687;
            }
            this.wKU.setVisibility(0);
            break;
            this.wKT.setVisibility(8);
          }
          this.wKU.setVisibility(8);
        }
        else if ((!TextUtils.isEmpty(this.wru.djL().code)) && (this.wru.djF()))
        {
          Log.i("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo().code is valid");
          this.wKU.setVisibility(8);
          this.wKT.setVisibility(8);
          this.wKR.setClickable(true);
          if (Build.VERSION.SDK_INT >= 23) {
            this.wKR.setForeground(this.mContext.getResources().getDrawable(a.c.wek));
          }
          this.wKR.setVisibility(0);
          this.wKR.setBackgroundDrawable(l.ag(this.mContext, l.alv(this.wru.djK().nRQ)));
          this.wKR.setTextColor(this.mContext.getResources().getColorStateList(a.a.White));
          this.wKR.setText(a.g.wqt);
        }
        else if (!this.wru.djF())
        {
          Log.i("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo().status is " + this.wru.djL().status);
          this.wKU.setVisibility(8);
          this.wKT.setVisibility(8);
          this.wKR.setClickable(true);
          this.wKR.setVisibility(0);
          this.wKR.setTextColor(this.mContext.getResources().getColor(a.a.grey_background_text_color));
          this.wKR.setBackgroundDrawable(l.ag(this.mContext, this.mContext.getResources().getColor(a.a.wdz)));
          if (!TextUtils.isEmpty(this.wru.djK().Zeh)) {
            this.wKR.setText(this.wru.djK().Zeh);
          } else {
            n.i(this.wKR, this.wru.djL().status);
          }
        }
        else
        {
          Log.i("MicroMsg.CardWidgetCommon", "operate_field and code is empty!");
          this.wKR.setVisibility(8);
          this.wKT.setVisibility(8);
          this.wKU.setVisibility(8);
        }
      }
    }
  }
  
  public final void nl(boolean paramBoolean)
  {
    AppMethodBeat.i(113901);
    this.wEY = paramBoolean;
    AppMethodBeat.o(113901);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(113898);
    super.setOnClickListener(paramOnClickListener);
    if (this.wKR != null) {
      this.wKR.setOnClickListener(paramOnClickListener);
    }
    if (this.wKU != null) {
      this.wKU.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(113898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.b
 * JD-Core Version:    0.7.0.1
 */