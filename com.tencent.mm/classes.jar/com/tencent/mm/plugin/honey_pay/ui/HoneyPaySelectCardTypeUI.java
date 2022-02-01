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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.honey_pay.model.HoneyPayCardType;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bna;
import com.tencent.mm.protocal.protobuf.bnb;
import com.tencent.mm.protocal.protobuf.bnc;
import com.tencent.mm.protocal.protobuf.xc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import com.tencent.mm.wallet_core.ui.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HoneyPaySelectCardTypeUI
  extends HoneyPayBaseUI
{
  private LinearLayout uHM;
  private List<bnb> uHN;
  private int uHO;
  private bnc uHP;
  
  private void refreshView()
  {
    AppMethodBeat.i(64850);
    this.uHM.removeAllViews();
    if ((this.uHN == null) || (this.uHN.isEmpty()))
    {
      AppMethodBeat.o(64850);
      return;
    }
    Iterator localIterator = this.uHN.iterator();
    if (localIterator.hasNext())
    {
      bnb localbnb = (bnb)localIterator.next();
      a locala = new a((byte)0);
      Object localObject1;
      Object localObject2;
      if (localbnb.Gza == null)
      {
        localObject1 = getContext();
        localObject2 = this.uHM;
        localObject1 = LayoutInflater.from((Context)localObject1).inflate(2131494453, (ViewGroup)localObject2, false);
        locala.a((View)localObject1, localbnb);
      }
      for (;;)
      {
        this.uHM.addView((View)localObject1);
        break;
        localObject2 = getContext();
        localObject1 = this.uHM;
        localObject1 = LayoutInflater.from((Context)localObject2).inflate(2131494454, (ViewGroup)localObject1, false);
        locala.a((View)localObject1, localbnb);
        locala.uFT = ((CdnImageView)((View)localObject1).findViewById(2131300865));
        locala.uHT = ((TextView)((View)localObject1).findViewById(2131300866));
        locala.uFT.setUrl(localbnb.Gza.dDH);
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
        localSpannableStringBuilder.append(localbnb.Gza.GHa);
        localSpannableStringBuilder.append(localbnb.Gza.GHb);
        localSpannableStringBuilder.setSpan(new q(new HoneyPaySelectCardTypeUI.a.1(locala, localbnb, (Context)localObject2)), localbnb.Gza.GHa.length(), localSpannableStringBuilder.length(), 34);
        locala.uHT.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n((Context)localObject2));
        locala.uHT.setClickable(true);
        locala.uHT.setText(localSpannableStringBuilder);
      }
    }
    AppMethodBeat.o(64850);
  }
  
  public int getLayoutId()
  {
    return 2131494455;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64846);
    this.uHM = ((LinearLayout)$(2131300867));
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
      ad.i("MicroMsg.HoneyPaySelectCardTypeUI", "select friend: %s", new Object[] { localObject });
      ad.i("MicroMsg.HoneyPaySelectCardTypeUI", "do check user: %s", new Object[] { localObject });
      localObject = new com.tencent.mm.plugin.honey_pay.a.b((String)localObject, this.uHO);
      ((com.tencent.mm.plugin.honey_pay.a.b)localObject).t(this);
      doSceneProgress((com.tencent.mm.al.n)localObject, true);
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(64849);
      return;
      label101:
      ad.i("MicroMsg.HoneyPaySelectCardTypeUI", "cancel add friend");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64845);
    this.uFB = 2131100492;
    super.onCreate(paramBundle);
    addSceneEndListener(2618);
    addSceneEndListener(2926);
    setMMTitle(2131760306);
    paramBundle = getIntent().getParcelableArrayListExtra("key_card_type_list");
    if ((paramBundle != null) && (!paramBundle.isEmpty()))
    {
      this.uHN = new ArrayList();
      try
      {
        paramBundle = paramBundle.iterator();
        while (paramBundle.hasNext())
        {
          HoneyPayCardType localHoneyPayCardType = (HoneyPayCardType)paramBundle.next();
          bnb localbnb = new bnb();
          localbnb.parseFrom(localHoneyPayCardType.zr);
          this.uHN.add(localbnb);
        }
        initView();
      }
      catch (IOException paramBundle)
      {
        ad.printErrStackTrace("MicroMsg.HoneyPaySelectCardTypeUI", paramBundle, "", new Object[0]);
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(64848);
    if ((paramn instanceof com.tencent.mm.plugin.honey_pay.a.b))
    {
      paramString = (com.tencent.mm.plugin.honey_pay.a.b)paramn;
      paramString.a(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
        {
          AppMethodBeat.i(64841);
          HoneyPaySelectCardTypeUI.a(HoneyPaySelectCardTypeUI.this, paramString.uFh.FWv, paramString.uFh.FWu, paramString.uFh.FWw, paramString.uFh.FWx, paramString.username, paramString.uFh.vjr, paramString.uFh.pkr);
          AppMethodBeat.o(64841);
        }
      }).b(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn) {}
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn) {}
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
    public CdnImageView uFT;
    public TextView uGd;
    public CdnImageView uHR;
    public TextView uHS;
    public TextView uHT;
    public ImageView uHU;
    
    private a() {}
    
    final void a(View paramView, final bnb parambnb)
    {
      AppMethodBeat.i(64844);
      this.uHR = ((CdnImageView)paramView.findViewById(2131300862));
      this.uGd = ((TextView)paramView.findViewById(2131300864));
      this.uHS = ((TextView)paramView.findViewById(2131300863));
      this.uHU = ((ImageView)paramView.findViewById(2131300861));
      this.uHR.setImageResource(c.ao(parambnb.mrl, parambnb.GHc));
      this.uGd.setText(parambnb.ozd);
      this.uHS.setText(parambnb.oBP);
      if (parambnb.GHc)
      {
        ad.i("MicroMsg.HoneyPaySelectCardTypeUI", "disable this card");
        paramView.setEnabled(false);
        this.uGd.setEnabled(false);
        this.uHS.setEnabled(false);
        this.uHU.setVisibility(8);
        AppMethodBeat.o(64844);
        return;
      }
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64843);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPaySelectCardTypeUI$CardTypeViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ad.i("MicroMsg.HoneyPaySelectCardTypeUI", "card type clicked");
          if (HoneyPaySelectCardTypeUI.a(HoneyPaySelectCardTypeUI.this) != null) {
            HoneyPaySelectCardTypeUI.a(HoneyPaySelectCardTypeUI.this, HoneyPaySelectCardTypeUI.a(HoneyPaySelectCardTypeUI.this));
          }
          for (;;)
          {
            a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPaySelectCardTypeUI$CardTypeViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(64843);
            return;
            HoneyPaySelectCardTypeUI.a(HoneyPaySelectCardTypeUI.this, parambnb.mrl);
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