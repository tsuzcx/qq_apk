package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.honey_pay.a.b;
import com.tencent.mm.plugin.honey_pay.model.HoneyPayCardType;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.wallet_core.ui.s.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.aas;
import com.tencent.mm.protocal.protobuf.cyn;
import com.tencent.mm.protocal.protobuf.cyo;
import com.tencent.mm.protocal.protobuf.cyp;
import com.tencent.mm.protocal.protobuf.dus;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.wallet_core.model.r;
import com.tencent.mm.wallet_core.model.r.a;
import com.tencent.mm.wallet_core.ui.i;
import com.tencent.mm.wallet_core.ui.k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class HoneyPaySelectCardTypeUI
  extends HoneyPayBaseUI
{
  private LinearLayout JDo;
  private List<cyo> JDp;
  private int JDq;
  private cyp JDr;
  
  private void refreshView()
  {
    AppMethodBeat.i(64850);
    this.JDo.removeAllViews();
    if ((this.JDp == null) || (this.JDp.isEmpty()))
    {
      AppMethodBeat.o(64850);
      return;
    }
    Iterator localIterator = this.JDp.iterator();
    if (localIterator.hasNext())
    {
      cyo localcyo = (cyo)localIterator.next();
      a locala = new a((byte)0);
      Object localObject1;
      Object localObject2;
      if (localcyo.aate == null)
      {
        localObject1 = getContext();
        localObject2 = this.JDo;
        localObject1 = LayoutInflater.from((Context)localObject1).inflate(a.g.honey_pay_select_cardtype_item, (ViewGroup)localObject2, false);
        locala.a((View)localObject1, localcyo);
      }
      for (;;)
      {
        this.JDo.addView((View)localObject1);
        break;
        localObject2 = getContext();
        localObject1 = this.JDo;
        localObject1 = LayoutInflater.from((Context)localObject2).inflate(a.g.honey_pay_select_cardtype_item_with_operations, (ViewGroup)localObject1, false);
        locala.a((View)localObject1, localcyo);
        locala.JBh = ((CdnImageView)((View)localObject1).findViewById(a.f.hpsc_operations_icon_iv));
        locala.JDv = ((TextView)((View)localObject1).findViewById(a.f.hpsc_operations_tv));
        locala.JBh.setUrl(localcyo.aate.icon);
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
        localSpannableStringBuilder.append(localcyo.aate.aaDq);
        localSpannableStringBuilder.append(localcyo.aate.aaDr);
        localSpannableStringBuilder.setSpan(new com.tencent.mm.plugin.wallet_core.ui.s(new HoneyPaySelectCardTypeUI.a.1(locala, localcyo, (Context)localObject2)), localcyo.aate.aaDq.length(), localSpannableStringBuilder.length(), 34);
        locala.JDv.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s((Context)localObject2));
        locala.JDv.setClickable(true);
        locala.JDv.setText(localSpannableStringBuilder);
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
    this.JDo = ((LinearLayout)$(a.f.hpsc_top_layout));
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
      localObject = new b((String)localObject, this.JDq);
      ((b)localObject).r(this);
      doSceneProgress((p)localObject, true);
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
    this.GRg = a.c.honey_pay_grey_bg_1;
    super.onCreate(paramBundle);
    addSceneEndListener(2618);
    addSceneEndListener(2926);
    setMMTitle("");
    paramBundle = getIntent().getParcelableArrayListExtra("key_card_type_list");
    if ((paramBundle != null) && (!paramBundle.isEmpty()))
    {
      this.JDp = new ArrayList();
      try
      {
        paramBundle = paramBundle.iterator();
        while (paramBundle.hasNext())
        {
          HoneyPayCardType localHoneyPayCardType = (HoneyPayCardType)paramBundle.next();
          cyo localcyo = new cyo();
          localcyo.parseFrom(localHoneyPayCardType.Op);
          this.JDp.add(localcyo);
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, p paramp)
  {
    AppMethodBeat.i(64848);
    if ((paramp instanceof b))
    {
      paramString = (b)paramp;
      paramString.a(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(64841);
          paramAnonymousString = "";
          try
          {
            if (paramString.JAw.ign != null) {
              paramAnonymousString = Base64.encodeToString(paramString.JAw.ign.toByteArray(), 2);
            }
            HoneyPaySelectCardTypeUI.a(HoneyPaySelectCardTypeUI.this, paramString.JAw.Zjg, paramString.JAw.Zjf, paramString.JAw.Zjh, paramString.JAw.Zji, paramString.username, paramString.JAw.Kmq, paramString.JAw.icon_url, paramAnonymousString);
            AppMethodBeat.o(64841);
            return;
          }
          catch (IOException paramAnonymousString)
          {
            Log.printErrStackTrace("MicroMsg.HoneyPaySelectCardTypeUI", paramAnonymousString, "", new Object[0]);
            AppMethodBeat.o(64841);
          }
        }
      }).b(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp) {}
      }).c(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp) {}
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
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(267450);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(HoneyPaySelectCardTypeUI.b.class);
    AppMethodBeat.o(267450);
  }
  
  final class a
  {
    public CdnImageView JBh;
    public TextView JBr;
    public WeImageView JDt;
    public TextView JDu;
    public TextView JDv;
    public ImageView JDw;
    
    private a() {}
    
    final void a(View paramView, final cyo paramcyo)
    {
      AppMethodBeat.i(64844);
      this.JDt = ((WeImageView)paramView.findViewById(a.f.hpsc_avatar_iv));
      this.JBr = ((TextView)paramView.findViewById(a.f.hpsc_card_type_tv));
      this.JDu = ((TextView)paramView.findViewById(a.f.hpsc_card_type_desc_tv));
      this.JDw = ((ImageView)paramView.findViewById(a.f.hpsc_arrow_iv));
      this.JDt.setImageResource(c.YP(paramcyo.tNW));
      if (paramcyo.aaDs) {
        this.JDt.setIconColor(HoneyPaySelectCardTypeUI.this.getContext().getResources().getColor(a.c.FG_2));
      }
      for (;;)
      {
        this.JBr.setText(paramcyo.wtN);
        this.JDu.setText(paramcyo.lym);
        if (!paramcyo.aaDs) {
          break;
        }
        Log.i("MicroMsg.HoneyPaySelectCardTypeUI", "disable this card");
        paramView.setEnabled(false);
        this.JDw.setVisibility(8);
        this.JBr.setTextColor(HoneyPaySelectCardTypeUI.this.getContext().getResources().getColor(a.c.FG_2));
        this.JDu.setTextColor(HoneyPaySelectCardTypeUI.this.getContext().getResources().getColor(a.c.FG_2));
        AppMethodBeat.o(64844);
        return;
        this.JDt.setIconColor(HoneyPaySelectCardTypeUI.this.getContext().getResources().getColor(a.c.Yellow));
      }
      paramView.setOnClickListener(new k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(267327);
          Log.i("MicroMsg.HoneyPaySelectCardTypeUI", "card type clicked");
          if (HoneyPaySelectCardTypeUI.a(HoneyPaySelectCardTypeUI.this) != null)
          {
            HoneyPaySelectCardTypeUI.a(HoneyPaySelectCardTypeUI.this, HoneyPaySelectCardTypeUI.a(HoneyPaySelectCardTypeUI.this));
            AppMethodBeat.o(267327);
            return;
          }
          HoneyPaySelectCardTypeUI.a(HoneyPaySelectCardTypeUI.this, paramcyo.tNW);
          HoneyPaySelectCardTypeUI.b(HoneyPaySelectCardTypeUI.this);
          AppMethodBeat.o(267327);
        }
      });
      AppMethodBeat.o(64844);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPaySelectCardTypeUI
 * JD-Core Version:    0.7.0.1
 */