package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wk;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bpn;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.protocal.protobuf.csf;
import com.tencent.mm.protocal.protobuf.cwp;
import com.tencent.mm.protocal.protobuf.cwq;
import com.tencent.mm.protocal.protobuf.dlu;
import com.tencent.mm.protocal.protobuf.dmo;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.LinkedList;
import org.json.JSONObject;

public class MallWalletSectionCellView
  extends LinearLayout
{
  private static final int oKX;
  public View kBS;
  public View oEI;
  public TextView vGA;
  public CdnImageView vGB;
  public TextView vGC;
  public ImageView vGD;
  public ImageView vGE;
  public TextView vGF;
  public TextView vGG;
  public ViewGroup vGH;
  public TextView vGI;
  public WcPayMoneyLoadingView vGJ;
  public ProgressBar vGK;
  private csf vGL;
  public CdnImageView vGy;
  public TextView vGz;
  
  static
  {
    AppMethodBeat.i(66156);
    oKX = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 16);
    AppMethodBeat.o(66156);
  }
  
  public MallWalletSectionCellView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(66148);
    init(paramContext);
    AppMethodBeat.o(66148);
  }
  
  public MallWalletSectionCellView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(66149);
    init(paramContext);
    AppMethodBeat.o(66149);
  }
  
  public MallWalletSectionCellView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(66150);
    init(paramContext);
    AppMethodBeat.o(66150);
  }
  
  private int bk(float paramFloat)
  {
    AppMethodBeat.i(66153);
    int i = com.tencent.mm.cc.a.fromDPToPix(getContext(), (int)paramFloat);
    AppMethodBeat.o(66153);
    return i;
  }
  
  private void dkI()
  {
    AppMethodBeat.i(66154);
    this.vGF.setVisibility(8);
    this.vGD.setVisibility(8);
    this.vGE.setVisibility(8);
    this.vGG.setVisibility(8);
    if ((this.vGL != null) && (this.vGL.type == 4)) {
      this.vGA.setText("");
    }
    AppMethodBeat.o(66154);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(66151);
    this.kBS = LayoutInflater.from(paramContext).inflate(2131494727, this, true);
    this.vGy = ((CdnImageView)this.kBS.findViewById(2131302633));
    this.vGz = ((TextView)this.kBS.findViewById(2131302641));
    this.vGA = ((TextView)this.kBS.findViewById(2131302630));
    this.vGB = ((CdnImageView)this.kBS.findViewById(2131302639));
    this.vGC = ((TextView)this.kBS.findViewById(2131302640));
    this.vGD = ((ImageView)this.kBS.findViewById(2131302637));
    this.vGE = ((ImageView)this.kBS.findViewById(2131302638));
    this.vGF = ((TextView)this.kBS.findViewById(2131302635));
    this.vGG = ((TextView)this.kBS.findViewById(2131302636));
    this.oEI = this.kBS.findViewById(2131302631);
    this.vGH = ((ViewGroup)this.kBS.findViewById(2131302634));
    this.vGI = ((TextView)this.kBS.findViewById(2131302632));
    this.vGJ = ((WcPayMoneyLoadingView)this.kBS.findViewById(2131302629));
    this.vGK = ((ProgressBar)this.kBS.findViewById(2131306757));
    this.vGJ.setLoadingPb(this.vGK);
    setOrientation(1);
    setBackgroundResource(2131232873);
    AppMethodBeat.o(66151);
  }
  
  public final void a(final dlu paramdlu, final JSONObject paramJSONObject, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    AppMethodBeat.i(66152);
    com.tencent.mm.plugin.wallet_core.utils.g.a(this.vGy, paramdlu.HAj);
    label86:
    Object localObject;
    cwp localcwp;
    label115:
    label123:
    int i;
    if ((paramdlu.HAm != null) && (!bt.isNullOrNil(paramdlu.HAm.url)))
    {
      com.tencent.mm.plugin.wallet_core.utils.g.a(this.vGB, paramdlu.HAm, 2131234606, true);
      if ((paramdlu.HAk == null) || (paramdlu.HAk.size() <= 0)) {
        break label604;
      }
      com.tencent.mm.plugin.wallet_core.utils.g.a(this.vGz, (dmo)paramdlu.HAk.get(0), null);
      if (paramdlu.HAo == null) {
        break label733;
      }
      localObject = this.vGI;
      localcwp = paramdlu.HAo;
      if ((localcwp != null) && (localObject != null)) {
        break label616;
      }
      this.vGI.setVisibility(0);
      if ((paramdlu.HAl == null) || (paramdlu.HAl.size() <= 0)) {
        break label790;
      }
      if (bt.isNullOrNil(paramString)) {
        break label751;
      }
      localObject = this.vGJ;
      if (paramBoolean2) {
        break label745;
      }
      paramBoolean2 = true;
      label162:
      ((WcPayMoneyLoadingView)localObject).ck(paramString, paramBoolean2);
      this.vGJ.setVisibility(0);
      this.vGA.setVisibility(8);
      label188:
      if ((paramdlu.HAl == null) || (paramdlu.HAl.size() <= 1)) {
        break label876;
      }
      com.tencent.mm.plugin.wallet_core.utils.g.a(this.vGC, (dmo)paramdlu.HAl.get(1), null);
      label225:
      if ((paramdlu.HAn == null) || (paramJSONObject == null)) {
        break label1063;
      }
      this.vGL = paramdlu.HAn;
      if (paramJSONObject.optInt(paramdlu.HAn.Gzv, 0) != 1) {
        break label888;
      }
      i = 1;
      label263:
      long l = paramJSONObject.optLong(String.format("%s_expiretime", new Object[] { paramdlu.HAn.Gzv }), 0L);
      int j = i;
      if (l > 0L)
      {
        j = i;
        if (System.currentTimeMillis() > l)
        {
          ad.i("MicroMsg.MallWalletSectionCellView", "red dot expired: %s, %s", new Object[] { paramdlu.HAn.Gzv, Long.valueOf(l) });
          j = 0;
        }
      }
      dkI();
      if (j == 0) {
        break label1056;
      }
      if (paramdlu.HAn.type != 1) {
        break label905;
      }
      if (bt.ai(this.vGA.getText())) {
        break label894;
      }
      this.vGE.setVisibility(0);
      label389:
      i = oKX;
      int k = oKX;
      j = oKX;
      int m = oKX;
      if (paramdlu.Hor != null)
      {
        paramString = paramdlu.Hor;
        if (paramString.left > 0.0F) {
          i = bk(paramString.left);
        }
        if (paramString.right > 0.0F) {
          j = bk(paramString.right);
        }
        if (paramString.top > 0.0F) {
          k = bk(paramString.top);
        }
        if (paramString.bottom > 0.0F) {
          m = bk(paramString.bottom);
        }
        this.vGH.setPadding(i, k, j, m);
      }
      if (!paramBoolean1) {
        break label1070;
      }
      this.vGz.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(66146);
          ad.d("MicroMsg.MallWalletSectionCellView", "x: %s, left: %s", new Object[] { Float.valueOf(MallWalletSectionCellView.this.vGz.getX()), Integer.valueOf(MallWalletSectionCellView.this.vGz.getLeft()) });
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 1);
          localLayoutParams.leftMargin = MallWalletSectionCellView.this.vGz.getLeft();
          MallWalletSectionCellView.this.oEI.setLayoutParams(localLayoutParams);
          MallWalletSectionCellView.this.oEI.setVisibility(0);
          AppMethodBeat.o(66146);
        }
      });
    }
    for (;;)
    {
      if (paramdlu.FsR != null) {
        setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(66147);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallWalletSectionCellView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            com.tencent.mm.plugin.wallet_core.utils.g.a(MallWalletSectionCellView.this.getContext(), paramdlu.FsR, null);
            paramAnonymousView = new wk();
            paramAnonymousView.dKK.aQj = paramdlu.FBS;
            com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousView);
            MallWalletSectionCellView.a(MallWalletSectionCellView.this);
            if ((paramJSONObject != null) && (paramdlu.HAn != null))
            {
              paramJSONObject.remove(paramdlu.HAn.Gzv);
              paramJSONObject.remove(String.format("%s_expiretime", new Object[] { paramdlu.HAn.Gzv }));
              com.tencent.mm.kernel.g.ajC().ajl().set(al.a.ICm, paramJSONObject.toString());
            }
            paramAnonymousView = "";
            int i;
            if (paramdlu.FsR.type == 1)
            {
              paramAnonymousView = paramdlu.FsR.url;
              i = 1;
            }
            for (;;)
            {
              com.tencent.mm.plugin.report.service.g.yhR.f(16502, new Object[] { Integer.valueOf(2), paramAnonymousView, Integer.valueOf(i) });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallWalletSectionCellView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(66147);
              return;
              if (paramdlu.FsR.type == 2)
              {
                if (paramdlu.FsR.Hou != null) {
                  paramAnonymousView = paramdlu.FsR.Hou.username;
                }
                i = 2;
              }
              else if (paramdlu.FsR.type == 4)
              {
                paramAnonymousView = paramdlu.FsR.url;
                i = 3;
              }
              else
              {
                i = 0;
              }
            }
          }
        });
      }
      AppMethodBeat.o(66152);
      return;
      this.vGB.setImageResource(2131690517);
      this.vGB.setColorFilter(getContext().getResources().getColor(2131099982), PorterDuff.Mode.SRC_ATOP);
      break;
      label604:
      this.vGz.setText("");
      break label86;
      label616:
      com.tencent.mm.plugin.wallet_core.utils.g.a((TextView)localObject, localcwp.Gav, null);
      com.tencent.mm.plugin.wallet_core.utils.g.a((View)localObject, localcwp.Hor);
      i = (int)localcwp.Hot;
      if ((localcwp.Hot & 0xFF000000) == 0L) {
        i = (int)(localcwp.Hot | 0xFF000000);
      }
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setShape(0);
      if (localcwp.Hos > 0.0F) {
        localGradientDrawable.setCornerRadius(com.tencent.mm.cc.a.fromDPToPix(((TextView)localObject).getContext(), (int)localcwp.Hos));
      }
      localGradientDrawable.setColor(i);
      ((TextView)localObject).setBackground(localGradientDrawable);
      break label115;
      label733:
      this.vGI.setVisibility(8);
      break label123;
      label745:
      paramBoolean2 = false;
      break label162;
      label751:
      com.tencent.mm.plugin.wallet_core.utils.g.a(this.vGA, (dmo)paramdlu.HAl.get(0), null);
      this.vGJ.setVisibility(8);
      this.vGA.setVisibility(0);
      break label188;
      label790:
      if (!bt.isNullOrNil(paramString))
      {
        paramString = this.vGJ;
        if (!paramBoolean2) {}
        for (paramBoolean2 = true;; paramBoolean2 = false)
        {
          paramString.ck("", paramBoolean2);
          this.vGJ.setVisibility(0);
          this.vGA.setVisibility(8);
          break;
        }
      }
      this.vGA.setText("");
      this.vGJ.setVisibility(8);
      this.vGA.setVisibility(0);
      break label188;
      label876:
      this.vGC.setVisibility(8);
      break label225;
      label888:
      i = 0;
      break label263;
      label894:
      this.vGD.setVisibility(0);
      break label389;
      label905:
      if (paramdlu.HAn.type == 2)
      {
        this.vGF.setVisibility(0);
        break label389;
      }
      if (paramdlu.HAn.type == 3)
      {
        this.vGG.setText(com.tencent.mm.plugin.wallet_core.utils.g.a(getContext(), paramdlu.HAn.Gav));
        this.vGG.setVisibility(0);
        break label389;
      }
      if (paramdlu.HAn.type == 4)
      {
        this.vGE.setVisibility(0);
        com.tencent.mm.plugin.wallet_core.utils.g.a(this.vGA, paramdlu.HAn.Gav, null);
        paramString = this.vGJ;
        paramString.setVisibility(8);
        if (paramString.jcf != null) {
          paramString.jcf.setVisibility(8);
        }
        paramString.removeCallbacks(paramString.DnC);
        break label389;
      }
      dkI();
      break label389;
      label1056:
      dkI();
      break label389;
      label1063:
      dkI();
      break label389;
      label1070:
      this.oEI.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallWalletSectionCellView
 * JD-Core Version:    0.7.0.1
 */