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
import com.tencent.mm.protocal.protobuf.bns;
import com.tencent.mm.protocal.protobuf.bnt;
import com.tencent.mm.protocal.protobuf.bnu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.ui.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HoneyPaySelectCardTypeUI
  extends HoneyPayBaseUI
{
  private List<bnt> uTA;
  private int uTB;
  private bnu uTC;
  private LinearLayout uTz;
  
  private void refreshView()
  {
    AppMethodBeat.i(64850);
    this.uTz.removeAllViews();
    if ((this.uTA == null) || (this.uTA.isEmpty()))
    {
      AppMethodBeat.o(64850);
      return;
    }
    Iterator localIterator = this.uTA.iterator();
    if (localIterator.hasNext())
    {
      bnt localbnt = (bnt)localIterator.next();
      a locala = new a((byte)0);
      Object localObject1;
      Object localObject2;
      if (localbnt.GSA == null)
      {
        localObject1 = getContext();
        localObject2 = this.uTz;
        localObject1 = LayoutInflater.from((Context)localObject1).inflate(2131494453, (ViewGroup)localObject2, false);
        locala.a((View)localObject1, localbnt);
      }
      for (;;)
      {
        this.uTz.addView((View)localObject1);
        break;
        localObject2 = getContext();
        localObject1 = this.uTz;
        localObject1 = LayoutInflater.from((Context)localObject2).inflate(2131494454, (ViewGroup)localObject1, false);
        locala.a((View)localObject1, localbnt);
        locala.uRG = ((CdnImageView)((View)localObject1).findViewById(2131300865));
        locala.uTG = ((TextView)((View)localObject1).findViewById(2131300866));
        locala.uRG.setUrl(localbnt.GSA.dEM);
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
        localSpannableStringBuilder.append(localbnt.GSA.HaC);
        localSpannableStringBuilder.append(localbnt.GSA.HaD);
        localSpannableStringBuilder.setSpan(new q(new HoneyPaySelectCardTypeUI.a.1(locala, localbnt, (Context)localObject2)), localbnt.GSA.HaC.length(), localSpannableStringBuilder.length(), 34);
        locala.uTG.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n((Context)localObject2));
        locala.uTG.setClickable(true);
        locala.uTG.setText(localSpannableStringBuilder);
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
    this.uTz = ((LinearLayout)$(2131300867));
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
      ae.i("MicroMsg.HoneyPaySelectCardTypeUI", "select friend: %s", new Object[] { localObject });
      ae.i("MicroMsg.HoneyPaySelectCardTypeUI", "do check user: %s", new Object[] { localObject });
      localObject = new com.tencent.mm.plugin.honey_pay.a.b((String)localObject, this.uTB);
      ((com.tencent.mm.plugin.honey_pay.a.b)localObject).t(this);
      doSceneProgress((com.tencent.mm.ak.n)localObject, true);
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(64849);
      return;
      label101:
      ae.i("MicroMsg.HoneyPaySelectCardTypeUI", "cancel add friend");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64845);
    this.uRo = 2131100492;
    super.onCreate(paramBundle);
    addSceneEndListener(2618);
    addSceneEndListener(2926);
    setMMTitle(2131760306);
    paramBundle = getIntent().getParcelableArrayListExtra("key_card_type_list");
    if ((paramBundle != null) && (!paramBundle.isEmpty()))
    {
      this.uTA = new ArrayList();
      try
      {
        paramBundle = paramBundle.iterator();
        while (paramBundle.hasNext())
        {
          HoneyPayCardType localHoneyPayCardType = (HoneyPayCardType)paramBundle.next();
          bnt localbnt = new bnt();
          localbnt.parseFrom(localHoneyPayCardType.zr);
          this.uTA.add(localbnt);
        }
        initView();
      }
      catch (IOException paramBundle)
      {
        ae.printErrStackTrace("MicroMsg.HoneyPaySelectCardTypeUI", paramBundle, "", new Object[0]);
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(64848);
    if ((paramn instanceof com.tencent.mm.plugin.honey_pay.a.b))
    {
      paramString = (com.tencent.mm.plugin.honey_pay.a.b)paramn;
      paramString.a(new HoneyPaySelectCardTypeUI.3(this, paramString)).b(new HoneyPaySelectCardTypeUI.2(this)).c(new HoneyPaySelectCardTypeUI.1(this));
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
    public CdnImageView uRG;
    public TextView uRQ;
    public CdnImageView uTE;
    public TextView uTF;
    public TextView uTG;
    public ImageView uTH;
    
    private a() {}
    
    final void a(View paramView, final bnt parambnt)
    {
      AppMethodBeat.i(64844);
      this.uTE = ((CdnImageView)paramView.findViewById(2131300862));
      this.uRQ = ((TextView)paramView.findViewById(2131300864));
      this.uTF = ((TextView)paramView.findViewById(2131300863));
      this.uTH = ((ImageView)paramView.findViewById(2131300861));
      this.uTE.setImageResource(c.ar(parambnt.mwj, parambnt.HaE));
      this.uRQ.setText(parambnt.oFF);
      this.uTF.setText(parambnt.oIr);
      if (parambnt.HaE)
      {
        ae.i("MicroMsg.HoneyPaySelectCardTypeUI", "disable this card");
        paramView.setEnabled(false);
        this.uRQ.setEnabled(false);
        this.uTF.setEnabled(false);
        this.uTH.setVisibility(8);
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
          a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPaySelectCardTypeUI$CardTypeViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ae.i("MicroMsg.HoneyPaySelectCardTypeUI", "card type clicked");
          if (HoneyPaySelectCardTypeUI.a(HoneyPaySelectCardTypeUI.this) != null) {
            HoneyPaySelectCardTypeUI.a(HoneyPaySelectCardTypeUI.this, HoneyPaySelectCardTypeUI.a(HoneyPaySelectCardTypeUI.this));
          }
          for (;;)
          {
            a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPaySelectCardTypeUI$CardTypeViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(64843);
            return;
            HoneyPaySelectCardTypeUI.a(HoneyPaySelectCardTypeUI.this, parambnt.mwj);
            HoneyPaySelectCardTypeUI.b(HoneyPaySelectCardTypeUI.this);
          }
        }
      });
      AppMethodBeat.o(64844);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPaySelectCardTypeUI
 * JD-Core Version:    0.7.0.1
 */