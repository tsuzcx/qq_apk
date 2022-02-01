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
import com.tencent.mm.model.cb;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class e
  extends d
{
  private final int adG;
  private final MMActivity fNT;
  private String jeI;
  private final a jiY;
  private final c jiZ;
  private d.a jja;
  boolean jjb;
  private a jjc;
  
  public e(MMActivity paramMMActivity, int paramInt)
  {
    super(paramMMActivity, new as());
    AppMethodBeat.i(131256);
    this.jjb = false;
    this.jjc = new a()
    {
      public final void f(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        AppMethodBeat.i(131250);
        ae.d("MicroMsg.QQFriendAdapter", "[cpan] postion:%d qq:%s status:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString, Integer.valueOf(paramAnonymousInt2) });
        as localas = (as)e.this.getItem(paramAnonymousInt1);
        if (localas == null)
        {
          ae.e("MicroMsg.QQFriendAdapter", "[cpan] qq friend is null. qq:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(131250);
          return;
        }
        if (bu.isNullOrNil(localas.getUsername()))
        {
          ae.e("MicroMsg.QQFriendAdapter", "[cpan] qq friend username is null. qq:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(131250);
          return;
        }
        ae.d("MicroMsg.QQFriendAdapter", "qq friend:%s", new Object[] { localas.toString() });
        if (localas.jhL == 0)
        {
          paramAnonymousInt1 = p.ew(localas.jhK);
          paramAnonymousString = new g(e.a(e.this), new g.a()
          {
            public final void h(boolean paramAnonymous2Boolean, String paramAnonymous2String)
            {
              AppMethodBeat.i(131248);
              paramAnonymous2String = ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).sO(p.ew(paramAnonymous2String));
              if (paramAnonymous2String != null)
              {
                paramAnonymous2String.hPN = 2;
                ae.d("MicroMsg.QQFriendAdapter", "qq friend onSendInviteEmail:%s", new Object[] { paramAnonymous2String.toString() });
                ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(paramAnonymous2String.jhK, paramAnonymous2String);
                e.this.ZD();
                AppMethodBeat.o(131248);
                return;
              }
              ae.w("MicroMsg.QQFriendAdapter", "cpan qq friedn is null. qq:%s", new Object[] { paramAnonymous2String });
              AppMethodBeat.o(131248);
            }
          }, (byte)0);
          paramAnonymousString.r(new int[] { paramAnonymousInt1 });
          paramAnonymousString.jjG = localas.jhK;
          localas.hPN = 1;
          ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(localas.jhK, localas);
          e.this.ZD();
          AppMethodBeat.o(131250);
          return;
        }
        if (localas.jhL == 1)
        {
          paramAnonymousString = new com.tencent.mm.pluginsdk.ui.applet.a(e.a(e.this), new com.tencent.mm.pluginsdk.ui.applet.a.a()
          {
            public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
            {
              AppMethodBeat.i(131249);
              ae.i("MicroMsg.QQFriendAdapter", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2), paramAnonymous2String1, paramAnonymous2String2 });
              long l = new p(p.ew(paramAnonymous2String2)).longValue();
              as localas = ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).sO(l);
              if ((localas != null) && (paramAnonymous2Boolean1)) {
                localas.username = paramAnonymous2String1;
              }
              if (localas != null)
              {
                localas.hPN = 2;
                ae.d("MicroMsg.QQFriendAdapter", "f :%s", new Object[] { localas.toString() });
                ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(l, localas);
                e.this.ZD();
              }
              for (;;)
              {
                if ((paramAnonymous2Boolean1) && (localas != null)) {
                  e.Km(paramAnonymous2String1);
                }
                AppMethodBeat.o(131249);
                return;
                ae.w("MicroMsg.QQFriendAdapter", "cpan qq friend is null. qq:%s", new Object[] { paramAnonymous2String2 });
              }
            }
          });
          paramAnonymousString.jjG = localas.jhK;
          paramAnonymousString.Fno = false;
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(Integer.valueOf(12));
          paramAnonymousString.b(localas.getUsername(), localLinkedList, true);
          localas.hPN = 1;
          ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(localas.jhK, localas);
          e.this.ZD();
        }
        AppMethodBeat.o(131250);
      }
    };
    this.fNT = paramMMActivity;
    this.adG = paramInt;
    this.jjb = paramMMActivity.getIntent().getBooleanExtra("qqgroup_sendmessage", false);
    this.jiY = new a(paramMMActivity, new a.a()
    {
      public final void Kl(String paramAnonymousString)
      {
        AppMethodBeat.i(131251);
        Object localObject = (at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg();
        as localas = ((at)localObject).Ki(paramAnonymousString);
        if (localas == null)
        {
          ae.w("MicroMsg.QQFriendAdapter", "[cpan] dealSucc failed. qqlist is null. username is :%s", new Object[] { String.valueOf(paramAnonymousString) });
          AppMethodBeat.o(131251);
          return;
        }
        localas.jhL = 2;
        ((at)localObject).a(localas.jhK, localas);
        e.this.notifyDataSetChanged();
        localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(paramAnonymousString);
        if (localObject != null) {
          if (((((aw)localObject).field_conRemark == null) || (((aw)localObject).field_conRemark.equals(""))) && (localas != null) && (localas.aTN() != null) && (!localas.aTN().equals(""))) {
            x.c((an)localObject, localas.aTN());
          }
        }
        for (;;)
        {
          cb.aCN().d(26, new Object[0]);
          AppMethodBeat.o(131251);
          return;
          localas = ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).Ki(paramAnonymousString);
          if (localas != null)
          {
            localas.aTQ();
            ae.d("MicroMsg.QQFriendAdapter", "user " + paramAnonymousString + " qq " + localas.jhK);
            ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(localas.jhK, localas);
          }
        }
      }
      
      public final void ab(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(131252);
        if (paramAnonymousBoolean)
        {
          as localas = ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).Ki(paramAnonymousString);
          if (localas == null) {
            break label109;
          }
          localas.aTQ();
          ae.d("MicroMsg.QQFriendAdapter", "user " + paramAnonymousString + " qq " + localas.jhK);
          ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(localas.jhK, localas);
        }
        for (;;)
        {
          e.this.notifyDataSetChanged();
          AppMethodBeat.o(131252);
          return;
          label109:
          ae.w("MicroMsg.QQFriendAdapter", "[cpan] dealFail failed. qqlist is null. username is :%s", new Object[] { String.valueOf(paramAnonymousString) });
        }
      }
    });
    this.jiZ = new c(paramMMActivity, new c.a()
    {
      public final void ft(boolean paramAnonymousBoolean)
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
  
  public final void DG(String paramString)
  {
    AppMethodBeat.i(131261);
    notifyDataSetChanged();
    AppMethodBeat.o(131261);
  }
  
  public final void JN(String paramString)
  {
    AppMethodBeat.i(131257);
    this.jeI = bu.aSk(paramString.trim());
    dhl();
    ZD();
    AppMethodBeat.o(131257);
  }
  
  public final void ZD()
  {
    AppMethodBeat.i(131259);
    dhl();
    if (bu.isNullOrNil(this.jeI)) {
      setCursor(((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).F(this.adG, this.jjb));
    }
    for (;;)
    {
      if ((this.jja != null) && (this.jeI != null)) {
        this.jja.ro(getCursor().getCount());
      }
      notifyDataSetChanged();
      AppMethodBeat.o(131259);
      return;
      setCursor(((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).b(this.adG, this.jeI, this.jjb));
    }
  }
  
  public final void ZE()
  {
    AppMethodBeat.i(131258);
    ZD();
    AppMethodBeat.o(131258);
  }
  
  public final void a(d.a parama)
  {
    this.jja = parama;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(131260);
    as localas = (as)getItem(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.fNT, 2131495151, null);
      paramViewGroup = new b(paramView);
      paramView.setTag(paramViewGroup);
      paramViewGroup.jeO = paramInt;
      paramViewGroup.jjf = localas.jhK;
      paramViewGroup.status = localas.jhL;
      paramViewGroup.jeP.setText(k.b(this.fNT, localas.getDisplayName(), paramViewGroup.jeP.getTextSize()));
      if (p.ew(localas.jhK) == 0) {
        break label621;
      }
    }
    label163:
    label209:
    label621:
    for (Bitmap localBitmap = com.tencent.mm.aj.c.sb(localas.jhK);; localBitmap = null)
    {
      if (localBitmap == null)
      {
        paramViewGroup.fTj.setImageDrawable(com.tencent.mm.cb.a.l(this.fNT, 2131690013));
        if (!this.jjb) {
          break label209;
        }
        paramViewGroup.jeQ.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(131260);
        return paramView;
        paramViewGroup = (b)paramView.getTag();
        break;
        paramViewGroup.fTj.setImageBitmap(localBitmap);
        break label163;
        switch (localas.jhL)
        {
        }
        for (;;)
        {
          switch (localas.hPN)
          {
          default: 
            break;
          case 0: 
          case 2: 
            paramViewGroup.fWX.setVisibility(0);
            paramViewGroup.gYT.setVisibility(4);
            break;
            if (localas.hPN == 2)
            {
              paramViewGroup.jeQ.setClickable(false);
              paramViewGroup.jeQ.setBackgroundDrawable(null);
              paramViewGroup.fWX.setText(2131759664);
              paramViewGroup.fWX.setTextColor(this.fNT.getResources().getColor(2131100544));
            }
            else
            {
              paramViewGroup.jeQ.setClickable(true);
              paramViewGroup.jeQ.setBackgroundResource(2131231365);
              paramViewGroup.fWX.setText(2131759663);
              paramViewGroup.fWX.setTextColor(this.fNT.getResources().getColor(2131101182));
              continue;
              if ((((l)com.tencent.mm.kernel.g.ab(l.class)).azF().aUH(localas.getUsername())) || (v.aAC().equals(localas.getUsername())))
              {
                paramViewGroup.jeQ.setClickable(false);
                paramViewGroup.jeQ.setBackgroundDrawable(null);
                paramViewGroup.fWX.setText(2131759662);
                paramViewGroup.fWX.setTextColor(this.fNT.getResources().getColor(2131100544));
              }
              else if (localas.hPN == 2)
              {
                paramViewGroup.jeQ.setClickable(false);
                paramViewGroup.jeQ.setBackgroundDrawable(null);
                paramViewGroup.fWX.setText(2131759667);
                paramViewGroup.fWX.setTextColor(this.fNT.getResources().getColor(2131100544));
              }
              else
              {
                paramViewGroup.jeQ.setClickable(true);
                paramViewGroup.jeQ.setBackgroundResource(2131231365);
                paramViewGroup.fWX.setText(2131759661);
                paramViewGroup.fWX.setTextColor(this.fNT.getResources().getColor(2131101182));
              }
            }
            break;
          }
        }
        paramViewGroup.fWX.setVisibility(4);
        paramViewGroup.gYT.setVisibility(0);
      }
    }
  }
  
  static abstract interface a
  {
    public abstract void f(int paramInt1, String paramString, int paramInt2);
  }
  
  final class b
  {
    ImageView fTj;
    TextView fWX;
    ProgressBar gYT;
    int jeO;
    TextView jeP;
    View jeQ;
    String jjf;
    int status;
    
    public b(View paramView)
    {
      AppMethodBeat.i(131255);
      this.fTj = ((ImageView)paramView.findViewById(2131298722));
      this.jeP = ((TextView)paramView.findViewById(2131303561));
      this.jeQ = paramView.findViewById(2131303555);
      this.fWX = ((TextView)paramView.findViewById(2131303563));
      this.gYT = ((ProgressBar)paramView.findViewById(2131303562));
      this.jeQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(131254);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/QQFriendAdapterCaseA$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (e.b(e.this) != null) {
            e.b(e.this).f(e.b.this.jeO, e.b.this.jjf, e.b.this.status);
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