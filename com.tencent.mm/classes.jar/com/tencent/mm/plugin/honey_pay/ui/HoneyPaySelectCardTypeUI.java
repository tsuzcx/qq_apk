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
import com.tencent.mm.protocal.protobuf.bis;
import com.tencent.mm.protocal.protobuf.bit;
import com.tencent.mm.protocal.protobuf.biu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  private LinearLayout tFd;
  private List<bit> tFe;
  private int tFf;
  private biu tFg;
  
  private void refreshView()
  {
    AppMethodBeat.i(64850);
    this.tFd.removeAllViews();
    if ((this.tFe == null) || (this.tFe.isEmpty()))
    {
      AppMethodBeat.o(64850);
      return;
    }
    Iterator localIterator = this.tFe.iterator();
    if (localIterator.hasNext())
    {
      bit localbit = (bit)localIterator.next();
      a locala = new a((byte)0);
      Object localObject1;
      Object localObject2;
      if (localbit.EPJ == null)
      {
        localObject1 = getContext();
        localObject2 = this.tFd;
        localObject1 = LayoutInflater.from((Context)localObject1).inflate(2131494453, (ViewGroup)localObject2, false);
        locala.a((View)localObject1, localbit);
      }
      for (;;)
      {
        this.tFd.addView((View)localObject1);
        break;
        localObject2 = getContext();
        localObject1 = this.tFd;
        localObject1 = LayoutInflater.from((Context)localObject2).inflate(2131494454, (ViewGroup)localObject1, false);
        locala.a((View)localObject1, localbit);
        locala.tDk = ((CdnImageView)((View)localObject1).findViewById(2131300865));
        locala.tFk = ((TextView)((View)localObject1).findViewById(2131300866));
        locala.tDk.setUrl(localbit.EPJ.drM);
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
        localSpannableStringBuilder.append(localbit.EPJ.EXE);
        localSpannableStringBuilder.append(localbit.EPJ.EXF);
        localSpannableStringBuilder.setSpan(new q(new HoneyPaySelectCardTypeUI.a.1(locala, localbit, (Context)localObject2)), localbit.EPJ.EXE.length(), localSpannableStringBuilder.length(), 34);
        locala.tFk.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n((Context)localObject2));
        locala.tFk.setClickable(true);
        locala.tFk.setText(localSpannableStringBuilder);
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
    this.tFd = ((LinearLayout)$(2131300867));
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
      ac.i("MicroMsg.HoneyPaySelectCardTypeUI", "select friend: %s", new Object[] { localObject });
      ac.i("MicroMsg.HoneyPaySelectCardTypeUI", "do check user: %s", new Object[] { localObject });
      localObject = new b((String)localObject, this.tFf);
      ((b)localObject).r(this);
      doSceneProgress((com.tencent.mm.ak.n)localObject, true);
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(64849);
      return;
      label101:
      ac.i("MicroMsg.HoneyPaySelectCardTypeUI", "cancel add friend");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64845);
    this.tCS = 2131100492;
    super.onCreate(paramBundle);
    addSceneEndListener(2618);
    addSceneEndListener(2926);
    setMMTitle(2131760306);
    paramBundle = getIntent().getParcelableArrayListExtra("key_card_type_list");
    if ((paramBundle != null) && (!paramBundle.isEmpty()))
    {
      this.tFe = new ArrayList();
      try
      {
        paramBundle = paramBundle.iterator();
        while (paramBundle.hasNext())
        {
          HoneyPayCardType localHoneyPayCardType = (HoneyPayCardType)paramBundle.next();
          bit localbit = new bit();
          localbit.parseFrom(localHoneyPayCardType.xy);
          this.tFe.add(localbit);
        }
        initView();
      }
      catch (IOException paramBundle)
      {
        ac.printErrStackTrace("MicroMsg.HoneyPaySelectCardTypeUI", paramBundle, "", new Object[0]);
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
    if ((paramn instanceof b))
    {
      paramString = (b)paramn;
      paramString.a(new HoneyPaySelectCardTypeUI.3(this, paramString)).b(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn) {}
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn) {}
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
    public CdnImageView tDk;
    public TextView tDu;
    public CdnImageView tFi;
    public TextView tFj;
    public TextView tFk;
    public ImageView tFl;
    
    private a() {}
    
    final void a(View paramView, final bit parambit)
    {
      AppMethodBeat.i(64844);
      this.tFi = ((CdnImageView)paramView.findViewById(2131300862));
      this.tDu = ((TextView)paramView.findViewById(2131300864));
      this.tFj = ((TextView)paramView.findViewById(2131300863));
      this.tFl = ((ImageView)paramView.findViewById(2131300861));
      this.tFi.setImageResource(c.ak(parambit.lRv, parambit.EXG));
      this.tDu.setText(parambit.nVJ);
      this.tFj.setText(parambit.nYv);
      if (parambit.EXG)
      {
        ac.i("MicroMsg.HoneyPaySelectCardTypeUI", "disable this card");
        paramView.setEnabled(false);
        this.tDu.setEnabled(false);
        this.tFj.setEnabled(false);
        this.tFl.setVisibility(8);
        AppMethodBeat.o(64844);
        return;
      }
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64843);
          ac.i("MicroMsg.HoneyPaySelectCardTypeUI", "card type clicked");
          if (HoneyPaySelectCardTypeUI.a(HoneyPaySelectCardTypeUI.this) != null)
          {
            HoneyPaySelectCardTypeUI.a(HoneyPaySelectCardTypeUI.this, HoneyPaySelectCardTypeUI.a(HoneyPaySelectCardTypeUI.this));
            AppMethodBeat.o(64843);
            return;
          }
          HoneyPaySelectCardTypeUI.a(HoneyPaySelectCardTypeUI.this, parambit.lRv);
          HoneyPaySelectCardTypeUI.b(HoneyPaySelectCardTypeUI.this);
          AppMethodBeat.o(64843);
        }
      });
      AppMethodBeat.o(64844);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPaySelectCardTypeUI
 * JD-Core Version:    0.7.0.1
 */