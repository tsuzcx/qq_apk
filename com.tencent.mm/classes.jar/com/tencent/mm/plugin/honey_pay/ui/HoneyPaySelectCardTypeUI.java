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
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.caj;
import com.tencent.mm.protocal.protobuf.cak;
import com.tencent.mm.protocal.protobuf.cal;
import com.tencent.mm.protocal.protobuf.yp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import com.tencent.mm.wallet_core.ui.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HoneyPaySelectCardTypeUI
  extends HoneyPayBaseUI
{
  private LinearLayout yma;
  private List<cak> ymb;
  private int ymc;
  private cal ymd;
  
  private void refreshView()
  {
    AppMethodBeat.i(64850);
    this.yma.removeAllViews();
    if ((this.ymb == null) || (this.ymb.isEmpty()))
    {
      AppMethodBeat.o(64850);
      return;
    }
    Iterator localIterator = this.ymb.iterator();
    if (localIterator.hasNext())
    {
      cak localcak = (cak)localIterator.next();
      a locala = new a((byte)0);
      Object localObject1;
      Object localObject2;
      if (localcak.LWF == null)
      {
        localObject1 = getContext();
        localObject2 = this.yma;
        localObject1 = LayoutInflater.from((Context)localObject1).inflate(2131495031, (ViewGroup)localObject2, false);
        locala.a((View)localObject1, localcak);
      }
      for (;;)
      {
        this.yma.addView((View)localObject1);
        break;
        localObject2 = getContext();
        localObject1 = this.yma;
        localObject1 = LayoutInflater.from((Context)localObject2).inflate(2131495032, (ViewGroup)localObject1, false);
        locala.a((View)localObject1, localcak);
        locala.ykj = ((CdnImageView)((View)localObject1).findViewById(2131302459));
        locala.ymh = ((TextView)((View)localObject1).findViewById(2131302460));
        locala.ykj.setUrl(localcak.LWF.icon);
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
        localSpannableStringBuilder.append(localcak.LWF.MfC);
        localSpannableStringBuilder.append(localcak.LWF.MfD);
        localSpannableStringBuilder.setSpan(new com.tencent.mm.plugin.wallet_core.ui.q(new HoneyPaySelectCardTypeUI.a.1(locala, localcak, (Context)localObject2)), localcak.LWF.MfC.length(), localSpannableStringBuilder.length(), 34);
        locala.ymh.setOnTouchListener(new o((Context)localObject2));
        locala.ymh.setClickable(true);
        locala.ymh.setText(localSpannableStringBuilder);
      }
    }
    AppMethodBeat.o(64850);
  }
  
  public int getLayoutId()
  {
    return 2131495033;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64846);
    this.yma = ((LinearLayout)$(2131302461));
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
      localObject = new com.tencent.mm.plugin.honey_pay.a.b((String)localObject, this.ymc);
      ((com.tencent.mm.plugin.honey_pay.a.b)localObject).t(this);
      doSceneProgress((com.tencent.mm.ak.q)localObject, true);
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
    this.wwG = 2131100596;
    super.onCreate(paramBundle);
    addSceneEndListener(2618);
    addSceneEndListener(2926);
    setMMTitle(2131761692);
    paramBundle = getIntent().getParcelableArrayListExtra("key_card_type_list");
    if ((paramBundle != null) && (!paramBundle.isEmpty()))
    {
      this.ymb = new ArrayList();
      try
      {
        paramBundle = paramBundle.iterator();
        while (paramBundle.hasNext())
        {
          HoneyPayCardType localHoneyPayCardType = (HoneyPayCardType)paramBundle.next();
          cak localcak = new cak();
          localcak.parseFrom(localHoneyPayCardType.zy);
          this.ymb.add(localcak);
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(64848);
    if ((paramq instanceof com.tencent.mm.plugin.honey_pay.a.b))
    {
      paramString = (com.tencent.mm.plugin.honey_pay.a.b)paramq;
      paramString.a(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq)
        {
          AppMethodBeat.i(64841);
          HoneyPaySelectCardTypeUI.a(HoneyPaySelectCardTypeUI.this, paramString.yjy.LjF, paramString.yjy.LjE, paramString.yjy.LjG, paramString.yjy.LjH, paramString.username, paramString.yjy.yPK, paramString.yjy.qGB);
          AppMethodBeat.o(64841);
        }
      }).b(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq) {}
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq) {}
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
    public CdnImageView ykj;
    public TextView ykt;
    public CdnImageView ymf;
    public TextView ymg;
    public TextView ymh;
    public ImageView ymi;
    
    private a() {}
    
    final void a(View paramView, final cak paramcak)
    {
      AppMethodBeat.i(64844);
      this.ymf = ((CdnImageView)paramView.findViewById(2131302456));
      this.ykt = ((TextView)paramView.findViewById(2131302458));
      this.ymg = ((TextView)paramView.findViewById(2131302457));
      this.ymi = ((ImageView)paramView.findViewById(2131302455));
      this.ymf.setImageResource(c.aB(paramcak.nHh, paramcak.MfE));
      this.ykt.setText(paramcak.pTn);
      this.ymg.setText(paramcak.pWf);
      if (paramcak.MfE)
      {
        Log.i("MicroMsg.HoneyPaySelectCardTypeUI", "disable this card");
        paramView.setEnabled(false);
        this.ykt.setEnabled(false);
        this.ymg.setEnabled(false);
        this.ymi.setVisibility(8);
        AppMethodBeat.o(64844);
        return;
      }
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64843);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPaySelectCardTypeUI$CardTypeViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          Log.i("MicroMsg.HoneyPaySelectCardTypeUI", "card type clicked");
          if (HoneyPaySelectCardTypeUI.a(HoneyPaySelectCardTypeUI.this) != null) {
            HoneyPaySelectCardTypeUI.a(HoneyPaySelectCardTypeUI.this, HoneyPaySelectCardTypeUI.a(HoneyPaySelectCardTypeUI.this));
          }
          for (;;)
          {
            a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPaySelectCardTypeUI$CardTypeViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(64843);
            return;
            HoneyPaySelectCardTypeUI.a(HoneyPaySelectCardTypeUI.this, paramcak.nHh);
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