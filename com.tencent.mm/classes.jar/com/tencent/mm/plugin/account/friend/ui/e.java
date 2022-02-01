package com.tencent.mm.plugin.account.friend.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class e
  extends d
{
  private final int adG;
  private final MMActivity fLP;
  private String jbP;
  private final a jgf;
  private final c jgg;
  private d.a jgh;
  boolean jgi;
  private a jgj;
  
  public e(MMActivity paramMMActivity, int paramInt)
  {
    super(paramMMActivity, new as());
    AppMethodBeat.i(131256);
    this.jgi = false;
    this.jgj = new a()
    {
      public final void f(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        AppMethodBeat.i(131250);
        ad.d("MicroMsg.QQFriendAdapter", "[cpan] postion:%d qq:%s status:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString, Integer.valueOf(paramAnonymousInt2) });
        as localas = (as)e.this.getItem(paramAnonymousInt1);
        if (localas == null)
        {
          ad.e("MicroMsg.QQFriendAdapter", "[cpan] qq friend is null. qq:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(131250);
          return;
        }
        if (bt.isNullOrNil(localas.getUsername()))
        {
          ad.e("MicroMsg.QQFriendAdapter", "[cpan] qq friend username is null. qq:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(131250);
          return;
        }
        ad.d("MicroMsg.QQFriendAdapter", "qq friend:%s", new Object[] { localas.toString() });
        if (localas.jeS == 0)
        {
          paramAnonymousInt1 = p.er(localas.jeR);
          paramAnonymousString = new g(e.a(e.this), new g.a()
          {
            public final void h(boolean paramAnonymous2Boolean, String paramAnonymous2String)
            {
              AppMethodBeat.i(131248);
              paramAnonymous2String = ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).sB(p.er(paramAnonymous2String));
              if (paramAnonymous2String != null)
              {
                paramAnonymous2String.hMU = 2;
                ad.d("MicroMsg.QQFriendAdapter", "qq friend onSendInviteEmail:%s", new Object[] { paramAnonymous2String.toString() });
                ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(paramAnonymous2String.jeR, paramAnonymous2String);
                e.this.Zu();
                AppMethodBeat.o(131248);
                return;
              }
              ad.w("MicroMsg.QQFriendAdapter", "cpan qq friedn is null. qq:%s", new Object[] { paramAnonymous2String });
              AppMethodBeat.o(131248);
            }
          }, (byte)0);
          paramAnonymousString.r(new int[] { paramAnonymousInt1 });
          paramAnonymousString.jgN = localas.jeR;
          localas.hMU = 1;
          ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(localas.jeR, localas);
          e.this.Zu();
          AppMethodBeat.o(131250);
          return;
        }
        if (localas.jeS == 1)
        {
          paramAnonymousString = new com.tencent.mm.pluginsdk.ui.applet.a(e.a(e.this), new com.tencent.mm.pluginsdk.ui.applet.a.a()
          {
            public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
            {
              AppMethodBeat.i(131249);
              ad.i("MicroMsg.QQFriendAdapter", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2), paramAnonymous2String1, paramAnonymous2String2 });
              long l = new p(p.er(paramAnonymous2String2)).longValue();
              as localas = ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).sB(l);
              if ((localas != null) && (paramAnonymous2Boolean1)) {
                localas.username = paramAnonymous2String1;
              }
              if (localas != null)
              {
                localas.hMU = 2;
                ad.d("MicroMsg.QQFriendAdapter", "f :%s", new Object[] { localas.toString() });
                ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(l, localas);
                e.this.Zu();
              }
              for (;;)
              {
                if ((paramAnonymous2Boolean1) && (localas != null)) {
                  e.JN(paramAnonymous2String1);
                }
                AppMethodBeat.o(131249);
                return;
                ad.w("MicroMsg.QQFriendAdapter", "cpan qq friend is null. qq:%s", new Object[] { paramAnonymous2String2 });
              }
            }
          });
          paramAnonymousString.jgN = localas.jeR;
          paramAnonymousString.EUT = false;
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(Integer.valueOf(12));
          paramAnonymousString.b(localas.getUsername(), localLinkedList, true);
          localas.hMU = 1;
          ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(localas.jeR, localas);
          e.this.Zu();
        }
        AppMethodBeat.o(131250);
      }
    };
    this.fLP = paramMMActivity;
    this.adG = paramInt;
    this.jgi = paramMMActivity.getIntent().getBooleanExtra("qqgroup_sendmessage", false);
    this.jgf = new a(paramMMActivity, new a.a()
    {
      public final void JM(String paramAnonymousString)
      {
        AppMethodBeat.i(131251);
        Object localObject = (at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg();
        as localas = ((at)localObject).JJ(paramAnonymousString);
        if (localas == null)
        {
          ad.w("MicroMsg.QQFriendAdapter", "[cpan] dealSucc failed. qqlist is null. username is :%s", new Object[] { String.valueOf(paramAnonymousString) });
          AppMethodBeat.o(131251);
          return;
        }
        localas.jeS = 2;
        ((at)localObject).a(localas.jeR, localas);
        e.this.notifyDataSetChanged();
        localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(paramAnonymousString);
        if (localObject != null) {
          if (((((aw)localObject).field_conRemark == null) || (((aw)localObject).field_conRemark.equals(""))) && (localas != null) && (localas.aTo() != null) && (!localas.aTo().equals(""))) {
            w.c((am)localObject, localas.aTo());
          }
        }
        for (;;)
        {
          bz.aCx().d(26, new Object[0]);
          AppMethodBeat.o(131251);
          return;
          localas = ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).JJ(paramAnonymousString);
          if (localas != null)
          {
            localas.aTr();
            ad.d("MicroMsg.QQFriendAdapter", "user " + paramAnonymousString + " qq " + localas.jeR);
            ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(localas.jeR, localas);
          }
        }
      }
      
      public final void ab(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(131252);
        if (paramAnonymousBoolean)
        {
          as localas = ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).JJ(paramAnonymousString);
          if (localas == null) {
            break label109;
          }
          localas.aTr();
          ad.d("MicroMsg.QQFriendAdapter", "user " + paramAnonymousString + " qq " + localas.jeR);
          ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(localas.jeR, localas);
        }
        for (;;)
        {
          e.this.notifyDataSetChanged();
          AppMethodBeat.o(131252);
          return;
          label109:
          ad.w("MicroMsg.QQFriendAdapter", "[cpan] dealFail failed. qqlist is null. username is :%s", new Object[] { String.valueOf(paramAnonymousString) });
        }
      }
    });
    this.jgg = new c(paramMMActivity, new c.a()
    {
      public final void fs(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(131253);
        if (paramAnonymousBoolean) {
          e.this.notifyDataSetChanged();
        }
        AppMethodBeat.o(131253);
      }
    });
    AppMethodBeat.o(131256);
  }
  
  public final void De(String paramString)
  {
    AppMethodBeat.i(131261);
    notifyDataSetChanged();
    AppMethodBeat.o(131261);
  }
  
  public final void Jo(String paramString)
  {
    AppMethodBeat.i(131257);
    this.jbP = bt.aQN(paramString.trim());
    det();
    Zu();
    AppMethodBeat.o(131257);
  }
  
  public final void Zu()
  {
    AppMethodBeat.i(131259);
    det();
    if (bt.isNullOrNil(this.jbP)) {
      setCursor(((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).F(this.adG, this.jgi));
    }
    for (;;)
    {
      if ((this.jgh != null) && (this.jbP != null)) {
        this.jgh.rl(getCursor().getCount());
      }
      notifyDataSetChanged();
      AppMethodBeat.o(131259);
      return;
      setCursor(((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).b(this.adG, this.jbP, this.jgi));
    }
  }
  
  public final void Zv()
  {
    AppMethodBeat.i(131258);
    Zu();
    AppMethodBeat.o(131258);
  }
  
  public final void a(d.a parama)
  {
    this.jgh = parama;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(131260);
    as localas = (as)getItem(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.fLP, 2131495151, null);
      paramViewGroup = new b(paramView);
      paramView.setTag(paramViewGroup);
      paramViewGroup.jbV = paramInt;
      paramViewGroup.jgm = localas.jeR;
      paramViewGroup.status = localas.jeS;
      paramViewGroup.jbW.setText(k.b(this.fLP, localas.getDisplayName(), paramViewGroup.jbW.getTextSize()));
      if (p.er(localas.jeR) == 0) {
        break label621;
      }
    }
    label163:
    label209:
    label621:
    for (Bitmap localBitmap = com.tencent.mm.ak.c.rO(localas.jeR);; localBitmap = null)
    {
      if (localBitmap == null)
      {
        paramViewGroup.fRd.setImageDrawable(com.tencent.mm.cc.a.l(this.fLP, 2131690013));
        if (!this.jgi) {
          break label209;
        }
        paramViewGroup.jbX.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(131260);
        return paramView;
        paramViewGroup = (b)paramView.getTag();
        break;
        paramViewGroup.fRd.setImageBitmap(localBitmap);
        break label163;
        switch (localas.jeS)
        {
        }
        for (;;)
        {
          switch (localas.hMU)
          {
          default: 
            break;
          case 0: 
          case 2: 
            paramViewGroup.fUR.setVisibility(0);
            paramViewGroup.gWg.setVisibility(4);
            break;
            if (localas.hMU == 2)
            {
              paramViewGroup.jbX.setClickable(false);
              paramViewGroup.jbX.setBackgroundDrawable(null);
              paramViewGroup.fUR.setText(2131759664);
              paramViewGroup.fUR.setTextColor(this.fLP.getResources().getColor(2131100544));
            }
            else
            {
              paramViewGroup.jbX.setClickable(true);
              paramViewGroup.jbX.setBackgroundResource(2131231365);
              paramViewGroup.fUR.setText(2131759663);
              paramViewGroup.fUR.setTextColor(this.fLP.getResources().getColor(2131101182));
              continue;
              if ((((l)com.tencent.mm.kernel.g.ab(l.class)).azp().aTg(localas.getUsername())) || (u.aAm().equals(localas.getUsername())))
              {
                paramViewGroup.jbX.setClickable(false);
                paramViewGroup.jbX.setBackgroundDrawable(null);
                paramViewGroup.fUR.setText(2131759662);
                paramViewGroup.fUR.setTextColor(this.fLP.getResources().getColor(2131100544));
              }
              else if (localas.hMU == 2)
              {
                paramViewGroup.jbX.setClickable(false);
                paramViewGroup.jbX.setBackgroundDrawable(null);
                paramViewGroup.fUR.setText(2131759667);
                paramViewGroup.fUR.setTextColor(this.fLP.getResources().getColor(2131100544));
              }
              else
              {
                paramViewGroup.jbX.setClickable(true);
                paramViewGroup.jbX.setBackgroundResource(2131231365);
                paramViewGroup.fUR.setText(2131759661);
                paramViewGroup.fUR.setTextColor(this.fLP.getResources().getColor(2131101182));
              }
            }
            break;
          }
        }
        paramViewGroup.fUR.setVisibility(4);
        paramViewGroup.gWg.setVisibility(0);
      }
    }
  }
  
  static abstract interface a
  {
    public abstract void f(int paramInt1, String paramString, int paramInt2);
  }
  
  final class b
  {
    ImageView fRd;
    TextView fUR;
    ProgressBar gWg;
    int jbV;
    TextView jbW;
    View jbX;
    String jgm;
    int status;
    
    public b(View paramView)
    {
      AppMethodBeat.i(131255);
      this.fRd = ((ImageView)paramView.findViewById(2131298722));
      this.jbW = ((TextView)paramView.findViewById(2131303561));
      this.jbX = paramView.findViewById(2131303555);
      this.fUR = ((TextView)paramView.findViewById(2131303563));
      this.gWg = ((ProgressBar)paramView.findViewById(2131303562));
      this.jbX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(131254);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/QQFriendAdapterCaseA$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (e.b(e.this) != null) {
            e.b(e.this).f(e.b.this.jbV, e.b.this.jgm, e.b.this.status);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/QQFriendAdapterCaseA$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(131254);
        }
      });
      AppMethodBeat.o(131255);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.e
 * JD-Core Version:    0.7.0.1
 */