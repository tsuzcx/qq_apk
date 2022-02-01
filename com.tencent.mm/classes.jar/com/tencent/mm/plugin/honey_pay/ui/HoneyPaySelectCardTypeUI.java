package com.tencent.mm.plugin.honey_pay.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.honey_pay.model.HoneyPayCardType;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.cik;
import com.tencent.mm.protocal.protobuf.cil;
import com.tencent.mm.protocal.protobuf.cim;
import com.tencent.mm.protocal.protobuf.yv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HoneyPaySelectCardTypeUI
  extends HoneyPayBaseUI
{
  private LinearLayout DMc;
  private List<cil> DMd;
  private int DMe;
  private cim DMf;
  
  private void refreshView()
  {
    AppMethodBeat.i(64850);
    this.DMc.removeAllViews();
    if ((this.DMd == null) || (this.DMd.isEmpty()))
    {
      AppMethodBeat.o(64850);
      return;
    }
    Iterator localIterator = this.DMd.iterator();
    if (localIterator.hasNext())
    {
      cil localcil = (cil)localIterator.next();
      a locala = new a((byte)0);
      Object localObject1;
      Object localObject2;
      if (localcil.TfM == null)
      {
        localObject1 = getContext();
        localObject2 = this.DMc;
        localObject1 = LayoutInflater.from((Context)localObject1).inflate(a.g.honey_pay_select_cardtype_item, (ViewGroup)localObject2, false);
        locala.a((View)localObject1, localcil);
      }
      for (;;)
      {
        this.DMc.addView((View)localObject1);
        break;
        localObject2 = getContext();
        localObject1 = this.DMc;
        localObject1 = LayoutInflater.from((Context)localObject2).inflate(a.g.honey_pay_select_cardtype_item_with_operations, (ViewGroup)localObject1, false);
        locala.a((View)localObject1, localcil);
        locala.DKl = ((CdnImageView)((View)localObject1).findViewById(a.f.hpsc_operations_icon_iv));
        locala.DMj = ((TextView)((View)localObject1).findViewById(a.f.hpsc_operations_tv));
        locala.DKl.setUrl(localcil.TfM.icon);
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
        localSpannableStringBuilder.append(localcil.TfM.Tpo);
        localSpannableStringBuilder.append(localcil.TfM.Tpp);
        localSpannableStringBuilder.setSpan(new com.tencent.mm.plugin.wallet_core.ui.r(new HoneyPaySelectCardTypeUI.a.1(locala, localcil, (Context)localObject2)), localcil.TfM.Tpo.length(), localSpannableStringBuilder.length(), 34);
        locala.DMj.setOnTouchListener(new o((Context)localObject2));
        locala.DMj.setClickable(true);
        locala.DMj.setText(localSpannableStringBuilder);
      }
    }
    AppMethodBeat.o(64850);
  }
  
  public int getLayoutId()
  {
    return a.g.honey_pay_select_cardtype_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64846);
    this.DMc = ((LinearLayout)$(a.f.hpsc_top_layout));
    AppMethodBeat.o(64846);
  }
  
  public boolean needExecuteBackListener()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(64849);
    if (paramInt1 == 1)
    {
      if (paramInt2 != -1) {
        break label101;
      }
      Object localObject = paramIntent.getStringExtra("Select_Conv_User");
      Log.i("MicroMsg.HoneyPaySelectCardTypeUI", "select friend: %s", new Object[] { localObject });
      Log.i("MicroMsg.HoneyPaySelectCardTypeUI", "do check user: %s", new Object[] { localObject });
      localObject = new com.tencent.mm.plugin.honey_pay.a.b((String)localObject, this.DMe);
      ((com.tencent.mm.plugin.honey_pay.a.b)localObject).u(this);
      doSceneProgress((q)localObject, true);
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(64849);
      return;
      label101:
      Log.i("MicroMsg.HoneyPaySelectCardTypeUI", "cancel add friend");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64845);
    this.BkW = a.c.honey_pay_grey_bg_1;
    super.onCreate(paramBundle);
    addSceneEndListener(2618);
    addSceneEndListener(2926);
    setMMTitle(a.i.honey_pay_select_card_type_title);
    paramBundle = getIntent().getParcelableArrayListExtra("key_card_type_list");
    if ((paramBundle != null) && (!paramBundle.isEmpty()))
    {
      this.DMd = new ArrayList();
      try
      {
        paramBundle = paramBundle.iterator();
        while (paramBundle.hasNext())
        {
          HoneyPayCardType localHoneyPayCardType = (HoneyPayCardType)paramBundle.next();
          cil localcil = new cil();
          localcil.parseFrom(localHoneyPayCardType.UH);
          this.DMd.add(localcil);
        }
        initView();
      }
      catch (IOException paramBundle)
      {
        Log.printErrStackTrace("MicroMsg.HoneyPaySelectCardTypeUI", paramBundle, "", new Object[0]);
      }
    }
    refreshView();
    AppMethodBeat.o(64845);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64847);
    removeSceneEndListener(2618);
    removeSceneEndListener(2926);
    super.onDestroy();
    AppMethodBeat.o(64847);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(64848);
    if ((paramq instanceof com.tencent.mm.plugin.honey_pay.a.b))
    {
      paramString = (com.tencent.mm.plugin.honey_pay.a.b)paramq;
      paramString.a(new com.tencent.mm.wallet_core.c.r.a()
      {
        public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(64841);
          HoneyPaySelectCardTypeUI.a(HoneyPaySelectCardTypeUI.this, paramString.DJA.SkW, paramString.DJA.SkV, paramString.DJA.SkX, paramString.DJA.SkY, paramString.username, paramString.DJA.EtJ, paramString.DJA.ufC);
          AppMethodBeat.o(64841);
        }
      }).b(new com.tencent.mm.wallet_core.c.r.a()
      {
        public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq) {}
      }).c(new com.tencent.mm.wallet_core.c.r.a()
      {
        public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq) {}
      });
    }
    AppMethodBeat.o(64848);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
  {
    public CdnImageView DKl;
    public TextView DKv;
    public CdnImageView DMh;
    public TextView DMi;
    public TextView DMj;
    public ImageView DMk;
    
    private a() {}
    
    final void a(View paramView, final cil paramcil)
    {
      AppMethodBeat.i(64844);
      this.DMh = ((CdnImageView)paramView.findViewById(a.f.hpsc_avatar_iv));
      this.DKv = ((TextView)paramView.findViewById(a.f.hpsc_card_type_tv));
      this.DMi = ((TextView)paramView.findViewById(a.f.hpsc_card_type_desc_tv));
      this.DMk = ((ImageView)paramView.findViewById(a.f.hpsc_arrow_iv));
      this.DMh.setImageResource(c.aH(paramcil.qJt, paramcil.Tpq));
      this.DKv.setText(paramcil.tpo);
      this.DMi.setText(paramcil.tsf);
      if (paramcil.Tpq)
      {
        Log.i("MicroMsg.HoneyPaySelectCardTypeUI", "disable this card");
        paramView.setEnabled(false);
        this.DKv.setEnabled(false);
        this.DMi.setEnabled(false);
        this.DMk.setVisibility(8);
        AppMethodBeat.o(64844);
        return;
      }
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64843);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/plugin/honey_pay/ui/HoneyPaySelectCardTypeUI$CardTypeViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.i("MicroMsg.HoneyPaySelectCardTypeUI", "card type clicked");
          if (HoneyPaySelectCardTypeUI.a(HoneyPaySelectCardTypeUI.this) != null) {
            HoneyPaySelectCardTypeUI.a(HoneyPaySelectCardTypeUI.this, HoneyPaySelectCardTypeUI.a(HoneyPaySelectCardTypeUI.this));
          }
          for (;;)
          {
            a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPaySelectCardTypeUI$CardTypeViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(64843);
            return;
            HoneyPaySelectCardTypeUI.a(HoneyPaySelectCardTypeUI.this, paramcil.qJt);
            HoneyPaySelectCardTypeUI.b(HoneyPaySelectCardTypeUI.this);
          }
        }
      });
      AppMethodBeat.o(64844);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPaySelectCardTypeUI
 * JD-Core Version:    0.7.0.1
 */