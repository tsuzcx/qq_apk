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
import com.tencent.mm.g.a.vh;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bhl;
import com.tencent.mm.protocal.protobuf.bxs;
import com.tencent.mm.protocal.protobuf.chy;
import com.tencent.mm.protocal.protobuf.cmb;
import com.tencent.mm.protocal.protobuf.cmc;
import com.tencent.mm.protocal.protobuf.dav;
import com.tencent.mm.protocal.protobuf.dbp;
import com.tencent.mm.protocal.protobuf.dca;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.LinkedList;
import org.json.JSONObject;

public class MallWalletSectionCellView
  extends LinearLayout
{
  private static final int nEC;
  public View jGG;
  public View nyo;
  public CdnImageView tvf;
  public TextView tvg;
  public TextView tvh;
  public CdnImageView tvi;
  public TextView tvj;
  public ImageView tvk;
  public ImageView tvl;
  public TextView tvm;
  public TextView tvn;
  public ViewGroup tvo;
  public TextView tvp;
  public WcPayMoneyLoadingView tvq;
  public ProgressBar tvr;
  private chy tvs;
  
  static
  {
    AppMethodBeat.i(66156);
    nEC = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 16);
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
  
  private int ba(float paramFloat)
  {
    AppMethodBeat.i(66153);
    int i = com.tencent.mm.cd.a.fromDPToPix(getContext(), (int)paramFloat);
    AppMethodBeat.o(66153);
    return i;
  }
  
  private void cNH()
  {
    AppMethodBeat.i(66154);
    this.tvm.setVisibility(8);
    this.tvk.setVisibility(8);
    this.tvl.setVisibility(8);
    this.tvn.setVisibility(8);
    if ((this.tvs != null) && (this.tvs.type == 4)) {
      this.tvh.setText("");
    }
    AppMethodBeat.o(66154);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(66151);
    this.jGG = LayoutInflater.from(paramContext).inflate(2131494727, this, true);
    this.tvf = ((CdnImageView)this.jGG.findViewById(2131302633));
    this.tvg = ((TextView)this.jGG.findViewById(2131302641));
    this.tvh = ((TextView)this.jGG.findViewById(2131302630));
    this.tvi = ((CdnImageView)this.jGG.findViewById(2131302639));
    this.tvj = ((TextView)this.jGG.findViewById(2131302640));
    this.tvk = ((ImageView)this.jGG.findViewById(2131302637));
    this.tvl = ((ImageView)this.jGG.findViewById(2131302638));
    this.tvm = ((TextView)this.jGG.findViewById(2131302635));
    this.tvn = ((TextView)this.jGG.findViewById(2131302636));
    this.nyo = this.jGG.findViewById(2131302631);
    this.tvo = ((ViewGroup)this.jGG.findViewById(2131302634));
    this.tvp = ((TextView)this.jGG.findViewById(2131302632));
    this.tvq = ((WcPayMoneyLoadingView)this.jGG.findViewById(2131302629));
    this.tvr = ((ProgressBar)this.jGG.findViewById(2131306757));
    this.tvq.setLoadingPb(this.tvr);
    setOrientation(1);
    setBackgroundResource(2131232873);
    AppMethodBeat.o(66151);
  }
  
  public final void a(final dav paramdav, final JSONObject paramJSONObject, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    AppMethodBeat.i(66152);
    com.tencent.mm.plugin.wallet_core.utils.g.a(this.tvf, paramdav.EsC);
    label86:
    Object localObject;
    cmb localcmb;
    label115:
    label123:
    int i;
    if ((paramdav.EsF != null) && (!bt.isNullOrNil(paramdav.EsF.url)))
    {
      com.tencent.mm.plugin.wallet_core.utils.g.a(this.tvi, paramdav.EsF, 2131234606, true);
      if ((paramdav.EsD == null) || (paramdav.EsD.size() <= 0)) {
        break label604;
      }
      com.tencent.mm.plugin.wallet_core.utils.g.a(this.tvg, (dbp)paramdav.EsD.get(0), null);
      if (paramdav.EsH == null) {
        break label733;
      }
      localObject = this.tvp;
      localcmb = paramdav.EsH;
      if ((localcmb != null) && (localObject != null)) {
        break label616;
      }
      this.tvp.setVisibility(0);
      if ((paramdav.EsE == null) || (paramdav.EsE.size() <= 0)) {
        break label790;
      }
      if (bt.isNullOrNil(paramString)) {
        break label751;
      }
      localObject = this.tvq;
      if (paramBoolean2) {
        break label745;
      }
      paramBoolean2 = true;
      label162:
      ((WcPayMoneyLoadingView)localObject).bV(paramString, paramBoolean2);
      this.tvq.setVisibility(0);
      this.tvh.setVisibility(8);
      label188:
      if ((paramdav.EsE == null) || (paramdav.EsE.size() <= 1)) {
        break label876;
      }
      com.tencent.mm.plugin.wallet_core.utils.g.a(this.tvj, (dbp)paramdav.EsE.get(1), null);
      label225:
      if ((paramdav.EsG == null) || (paramJSONObject == null)) {
        break label1063;
      }
      this.tvs = paramdav.EsG;
      if (paramJSONObject.optInt(paramdav.EsG.DuV, 0) != 1) {
        break label888;
      }
      i = 1;
      label263:
      long l = paramJSONObject.optLong(String.format("%s_expiretime", new Object[] { paramdav.EsG.DuV }), 0L);
      int j = i;
      if (l > 0L)
      {
        j = i;
        if (System.currentTimeMillis() > l)
        {
          ad.i("MicroMsg.MallWalletSectionCellView", "red dot expired: %s, %s", new Object[] { paramdav.EsG.DuV, Long.valueOf(l) });
          j = 0;
        }
      }
      cNH();
      if (j == 0) {
        break label1056;
      }
      if (paramdav.EsG.type != 1) {
        break label905;
      }
      if (bt.ai(this.tvh.getText())) {
        break label894;
      }
      this.tvl.setVisibility(0);
      label389:
      i = nEC;
      int k = nEC;
      j = nEC;
      int m = nEC;
      if (paramdav.Ehd != null)
      {
        paramString = paramdav.Ehd;
        if (paramString.left > 0.0F) {
          i = ba(paramString.left);
        }
        if (paramString.right > 0.0F) {
          j = ba(paramString.right);
        }
        if (paramString.top > 0.0F) {
          k = ba(paramString.top);
        }
        if (paramString.bottom > 0.0F) {
          m = ba(paramString.bottom);
        }
        this.tvo.setPadding(i, k, j, m);
      }
      if (!paramBoolean1) {
        break label1070;
      }
      this.tvg.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(66146);
          ad.d("MicroMsg.MallWalletSectionCellView", "x: %s, left: %s", new Object[] { Float.valueOf(MallWalletSectionCellView.this.tvg.getX()), Integer.valueOf(MallWalletSectionCellView.this.tvg.getLeft()) });
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 1);
          localLayoutParams.leftMargin = MallWalletSectionCellView.this.tvg.getLeft();
          MallWalletSectionCellView.this.nyo.setLayoutParams(localLayoutParams);
          MallWalletSectionCellView.this.nyo.setVisibility(0);
          AppMethodBeat.o(66146);
        }
      });
    }
    for (;;)
    {
      if (paramdav.Cvq != null) {
        setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(66147);
            com.tencent.mm.plugin.wallet_core.utils.g.a(MallWalletSectionCellView.this.getContext(), paramdav.Cvq, null);
            paramAnonymousView = new vh();
            paramAnonymousView.dAL.dAM = paramdav.CDW;
            com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousView);
            MallWalletSectionCellView.a(MallWalletSectionCellView.this);
            if ((paramJSONObject != null) && (paramdav.EsG != null))
            {
              paramJSONObject.remove(paramdav.EsG.DuV);
              paramJSONObject.remove(String.format("%s_expiretime", new Object[] { paramdav.EsG.DuV }));
              com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fsb, paramJSONObject.toString());
            }
            paramAnonymousView = "";
            int i;
            if (paramdav.Cvq.type == 1)
            {
              paramAnonymousView = paramdav.Cvq.url;
              i = 1;
            }
            for (;;)
            {
              h.vKh.f(16502, new Object[] { Integer.valueOf(2), paramAnonymousView, Integer.valueOf(i) });
              AppMethodBeat.o(66147);
              return;
              if (paramdav.Cvq.type == 2)
              {
                if (paramdav.Cvq.Ehg != null) {
                  paramAnonymousView = paramdav.Cvq.Ehg.username;
                }
                i = 2;
              }
              else if (paramdav.Cvq.type == 4)
              {
                paramAnonymousView = paramdav.Cvq.url;
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
      this.tvi.setImageResource(2131690517);
      this.tvi.setColorFilter(getContext().getResources().getColor(2131099982), PorterDuff.Mode.SRC_ATOP);
      break;
      label604:
      this.tvg.setText("");
      break label86;
      label616:
      com.tencent.mm.plugin.wallet_core.utils.g.a((TextView)localObject, localcmb.Dah, null);
      com.tencent.mm.plugin.wallet_core.utils.g.a((View)localObject, localcmb.Ehd);
      i = (int)localcmb.Ehf;
      if ((localcmb.Ehf & 0xFF000000) == 0L) {
        i = (int)(localcmb.Ehf | 0xFF000000);
      }
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setShape(0);
      if (localcmb.Ehe > 0.0F) {
        localGradientDrawable.setCornerRadius(com.tencent.mm.cd.a.fromDPToPix(((TextView)localObject).getContext(), (int)localcmb.Ehe));
      }
      localGradientDrawable.setColor(i);
      ((TextView)localObject).setBackground(localGradientDrawable);
      break label115;
      label733:
      this.tvp.setVisibility(8);
      break label123;
      label745:
      paramBoolean2 = false;
      break label162;
      label751:
      com.tencent.mm.plugin.wallet_core.utils.g.a(this.tvh, (dbp)paramdav.EsE.get(0), null);
      this.tvq.setVisibility(8);
      this.tvh.setVisibility(0);
      break label188;
      label790:
      if (!bt.isNullOrNil(paramString))
      {
        paramString = this.tvq;
        if (!paramBoolean2) {}
        for (paramBoolean2 = true;; paramBoolean2 = false)
        {
          paramString.bV("", paramBoolean2);
          this.tvq.setVisibility(0);
          this.tvh.setVisibility(8);
          break;
        }
      }
      this.tvh.setText("");
      this.tvq.setVisibility(8);
      this.tvh.setVisibility(0);
      break label188;
      label876:
      this.tvj.setVisibility(8);
      break label225;
      label888:
      i = 0;
      break label263;
      label894:
      this.tvk.setVisibility(0);
      break label389;
      label905:
      if (paramdav.EsG.type == 2)
      {
        this.tvm.setVisibility(0);
        break label389;
      }
      if (paramdav.EsG.type == 3)
      {
        this.tvn.setText(com.tencent.mm.plugin.wallet_core.utils.g.a(getContext(), paramdav.EsG.Dah));
        this.tvn.setVisibility(0);
        break label389;
      }
      if (paramdav.EsG.type == 4)
      {
        this.tvl.setVisibility(0);
        com.tencent.mm.plugin.wallet_core.utils.g.a(this.tvh, paramdav.EsG.Dah, null);
        paramString = this.tvq;
        paramString.setVisibility(8);
        if (paramString.iiP != null) {
          paramString.iiP.setVisibility(8);
        }
        paramString.removeCallbacks(paramString.AuQ);
        break label389;
      }
      cNH();
      break label389;
      label1056:
      cNH();
      break label389;
      label1063:
      cNH();
      break label389;
      label1070:
      this.nyo.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallWalletSectionCellView
 * JD-Core Version:    0.7.0.1
 */