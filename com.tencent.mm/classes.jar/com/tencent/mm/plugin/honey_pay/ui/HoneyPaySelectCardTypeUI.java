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
import com.tencent.mm.plugin.honey_pay.a.b;
import com.tencent.mm.plugin.honey_pay.model.HoneyPayCardType;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bfa;
import com.tencent.mm.protocal.protobuf.bfb;
import com.tencent.mm.protocal.protobuf.bfc;
import com.tencent.mm.protocal.protobuf.ut;
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
  private LinearLayout sxo;
  private List<bfb> sxp;
  private int sxq;
  private bfc sxr;
  
  private void refreshView()
  {
    AppMethodBeat.i(64850);
    this.sxo.removeAllViews();
    if ((this.sxp == null) || (this.sxp.isEmpty()))
    {
      AppMethodBeat.o(64850);
      return;
    }
    Iterator localIterator = this.sxp.iterator();
    if (localIterator.hasNext())
    {
      bfb localbfb = (bfb)localIterator.next();
      a locala = new a((byte)0);
      Object localObject1;
      Object localObject2;
      if (localbfb.DuA == null)
      {
        localObject1 = getContext();
        localObject2 = this.sxo;
        localObject1 = LayoutInflater.from((Context)localObject1).inflate(2131494453, (ViewGroup)localObject2, false);
        locala.a((View)localObject1, localbfb);
      }
      for (;;)
      {
        this.sxo.addView((View)localObject1);
        break;
        localObject2 = getContext();
        localObject1 = this.sxo;
        localObject1 = LayoutInflater.from((Context)localObject2).inflate(2131494454, (ViewGroup)localObject1, false);
        locala.a((View)localObject1, localbfb);
        locala.svv = ((CdnImageView)((View)localObject1).findViewById(2131300865));
        locala.sxv = ((TextView)((View)localObject1).findViewById(2131300866));
        locala.svv.setUrl(localbfb.DuA.dub);
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
        localSpannableStringBuilder.append(localbfb.DuA.DCi);
        localSpannableStringBuilder.append(localbfb.DuA.DCj);
        localSpannableStringBuilder.setSpan(new q(new HoneyPaySelectCardTypeUI.a.1(locala, localbfb, (Context)localObject2)), localbfb.DuA.DCi.length(), localSpannableStringBuilder.length(), 34);
        locala.sxv.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n((Context)localObject2));
        locala.sxv.setClickable(true);
        locala.sxv.setText(localSpannableStringBuilder);
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
    this.sxo = ((LinearLayout)$(2131300867));
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
      localObject = new b((String)localObject, this.sxq);
      ((b)localObject).q(this);
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
    this.svd = 2131100492;
    super.onCreate(paramBundle);
    addSceneEndListener(2618);
    addSceneEndListener(2926);
    setMMTitle(2131760306);
    paramBundle = getIntent().getParcelableArrayListExtra("key_card_type_list");
    if ((paramBundle != null) && (!paramBundle.isEmpty()))
    {
      this.sxp = new ArrayList();
      try
      {
        paramBundle = paramBundle.iterator();
        while (paramBundle.hasNext())
        {
          HoneyPayCardType localHoneyPayCardType = (HoneyPayCardType)paramBundle.next();
          bfb localbfb = new bfb();
          localbfb.parseFrom(localHoneyPayCardType.wA);
          this.sxp.add(localbfb);
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
    if ((paramn instanceof b))
    {
      paramString = (b)paramn;
      paramString.a(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
        {
          AppMethodBeat.i(64841);
          HoneyPaySelectCardTypeUI.a(HoneyPaySelectCardTypeUI.this, paramString.suJ.CWA, paramString.suJ.CWz, paramString.suJ.CWB, paramString.suJ.CWC, paramString.username, paramString.suJ.sYt, paramString.suJ.odo);
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
    public TextView svF;
    public CdnImageView svv;
    public CdnImageView sxt;
    public TextView sxu;
    public TextView sxv;
    public ImageView sxw;
    
    private a() {}
    
    final void a(View paramView, final bfb parambfb)
    {
      AppMethodBeat.i(64844);
      this.sxt = ((CdnImageView)paramView.findViewById(2131300862));
      this.svF = ((TextView)paramView.findViewById(2131300864));
      this.sxu = ((TextView)paramView.findViewById(2131300863));
      this.sxw = ((ImageView)paramView.findViewById(2131300861));
      this.sxt.setImageResource(c.ah(parambfb.lpz, parambfb.DCk));
      this.svF.setText(parambfb.nsJ);
      this.sxu.setText(parambfb.nvv);
      if (parambfb.DCk)
      {
        ad.i("MicroMsg.HoneyPaySelectCardTypeUI", "disable this card");
        paramView.setEnabled(false);
        this.svF.setEnabled(false);
        this.sxu.setEnabled(false);
        this.sxw.setVisibility(8);
        AppMethodBeat.o(64844);
        return;
      }
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64843);
          ad.i("MicroMsg.HoneyPaySelectCardTypeUI", "card type clicked");
          if (HoneyPaySelectCardTypeUI.a(HoneyPaySelectCardTypeUI.this) != null)
          {
            HoneyPaySelectCardTypeUI.a(HoneyPaySelectCardTypeUI.this, HoneyPaySelectCardTypeUI.a(HoneyPaySelectCardTypeUI.this));
            AppMethodBeat.o(64843);
            return;
          }
          HoneyPaySelectCardTypeUI.a(HoneyPaySelectCardTypeUI.this, parambfb.lpz);
          HoneyPaySelectCardTypeUI.b(HoneyPaySelectCardTypeUI.this);
          AppMethodBeat.o(64843);
        }
      });
      AppMethodBeat.o(64844);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPaySelectCardTypeUI
 * JD-Core Version:    0.7.0.1
 */