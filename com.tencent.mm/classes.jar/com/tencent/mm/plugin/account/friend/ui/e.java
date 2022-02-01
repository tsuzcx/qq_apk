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
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.by;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class e
  extends d
{
  private final int aaU;
  private String iiy;
  private final MMActivity imP;
  private final a imQ;
  private final c imR;
  private d.a imS;
  boolean imT;
  private a imU;
  
  public e(MMActivity paramMMActivity, int paramInt)
  {
    super(paramMMActivity, new as());
    AppMethodBeat.i(131256);
    this.imT = false;
    this.imU = new a()
    {
      public final void e(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
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
        if (localas.ilC == 0)
        {
          paramAnonymousInt1 = p.dG(localas.ilB);
          paramAnonymousString = new g(e.a(e.this), new g.a()
          {
            public final void f(boolean paramAnonymous2Boolean, String paramAnonymous2String)
            {
              AppMethodBeat.i(131248);
              paramAnonymous2String = ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).mN(p.dG(paramAnonymous2String));
              if (paramAnonymous2String != null)
              {
                paramAnonymous2String.gUd = 2;
                ad.d("MicroMsg.QQFriendAdapter", "qq friend onSendInviteEmail:%s", new Object[] { paramAnonymous2String.toString() });
                ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(paramAnonymous2String.ilB, paramAnonymous2String);
                e.this.Wd();
                AppMethodBeat.o(131248);
                return;
              }
              ad.w("MicroMsg.QQFriendAdapter", "cpan qq friedn is null. qq:%s", new Object[] { paramAnonymous2String });
              AppMethodBeat.o(131248);
            }
          }, (byte)0);
          paramAnonymousString.q(new int[] { paramAnonymousInt1 });
          paramAnonymousString.iny = localas.ilB;
          localas.gUd = 1;
          ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(localas.ilB, localas);
          e.this.Wd();
          AppMethodBeat.o(131250);
          return;
        }
        if (localas.ilC == 1)
        {
          paramAnonymousString = new com.tencent.mm.pluginsdk.ui.applet.a(e.a(e.this), new com.tencent.mm.pluginsdk.ui.applet.a.a()
          {
            public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
            {
              AppMethodBeat.i(131249);
              ad.i("MicroMsg.QQFriendAdapter", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2), paramAnonymous2String1, paramAnonymous2String2 });
              long l = new p(p.dG(paramAnonymous2String2)).longValue();
              as localas = ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).mN(l);
              if ((localas != null) && (paramAnonymous2Boolean1)) {
                localas.username = paramAnonymous2String1;
              }
              if (localas != null)
              {
                localas.gUd = 2;
                ad.d("MicroMsg.QQFriendAdapter", "f :%s", new Object[] { localas.toString() });
                ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(l, localas);
                e.this.Wd();
              }
              for (;;)
              {
                if ((paramAnonymous2Boolean1) && (localas != null)) {
                  e.Cv(paramAnonymous2String1);
                }
                AppMethodBeat.o(131249);
                return;
                ad.w("MicroMsg.QQFriendAdapter", "cpan qq friend is null. qq:%s", new Object[] { paramAnonymous2String2 });
              }
            }
          });
          paramAnonymousString.iny = localas.ilB;
          paramAnonymousString.BXy = false;
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(Integer.valueOf(12));
          paramAnonymousString.b(localas.getUsername(), localLinkedList, true);
          localas.gUd = 1;
          ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(localas.ilB, localas);
          e.this.Wd();
        }
        AppMethodBeat.o(131250);
      }
    };
    this.imP = paramMMActivity;
    this.aaU = paramInt;
    this.imT = paramMMActivity.getIntent().getBooleanExtra("qqgroup_sendmessage", false);
    this.imQ = new a(paramMMActivity, new a.a()
    {
      public final void Cu(String paramAnonymousString)
      {
        AppMethodBeat.i(131251);
        Object localObject = (at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg();
        as localas = ((at)localObject).Cr(paramAnonymousString);
        if (localas == null)
        {
          ad.w("MicroMsg.QQFriendAdapter", "[cpan] dealSucc failed. qqlist is null. username is :%s", new Object[] { String.valueOf(paramAnonymousString) });
          AppMethodBeat.o(131251);
          return;
        }
        localas.ilC = 2;
        ((at)localObject).a(localas.ilB, localas);
        e.this.notifyDataSetChanged();
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramAnonymousString);
        if (localObject != null) {
          if (((((au)localObject).field_conRemark == null) || (((au)localObject).field_conRemark.equals(""))) && (localas != null) && (localas.aJl() != null) && (!localas.aJl().equals(""))) {
            w.c((af)localObject, localas.aJl());
          }
        }
        for (;;)
        {
          by.asD().d(26, new Object[0]);
          AppMethodBeat.o(131251);
          return;
          localas = ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).Cr(paramAnonymousString);
          if (localas != null)
          {
            localas.aJo();
            ad.d("MicroMsg.QQFriendAdapter", "user " + paramAnonymousString + " qq " + localas.ilB);
            ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(localas.ilB, localas);
          }
        }
      }
      
      public final void aa(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(131252);
        if (paramAnonymousBoolean)
        {
          as localas = ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).Cr(paramAnonymousString);
          if (localas == null) {
            break label109;
          }
          localas.aJo();
          ad.d("MicroMsg.QQFriendAdapter", "user " + paramAnonymousString + " qq " + localas.ilB);
          ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(localas.ilB, localas);
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
    this.imR = new c(paramMMActivity, new c.a()
    {
      public final void eU(boolean paramAnonymousBoolean)
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
  
  public final void BW(String paramString)
  {
    AppMethodBeat.i(131257);
    this.iiy = bt.aFQ(paramString.trim());
    cHX();
    Wd();
    AppMethodBeat.o(131257);
  }
  
  public final void Wd()
  {
    AppMethodBeat.i(131259);
    cHX();
    if (bt.isNullOrNil(this.iiy)) {
      setCursor(((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).F(this.aaU, this.imT));
    }
    for (;;)
    {
      if ((this.imS != null) && (this.iiy != null)) {
        this.imS.pY(getCursor().getCount());
      }
      notifyDataSetChanged();
      AppMethodBeat.o(131259);
      return;
      setCursor(((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).b(this.aaU, this.iiy, this.imT));
    }
  }
  
  public final void We()
  {
    AppMethodBeat.i(131258);
    Wd();
    AppMethodBeat.o(131258);
  }
  
  public final void a(d.a parama)
  {
    this.imS = parama;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(131260);
    as localas = (as)getItem(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.imP, 2131495151, null);
      paramViewGroup = new b(paramView);
      paramView.setTag(paramViewGroup);
      paramViewGroup.iiE = paramInt;
      paramViewGroup.imX = localas.ilB;
      paramViewGroup.status = localas.ilC;
      paramViewGroup.iiF.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.imP, localas.getDisplayName(), paramViewGroup.iiF.getTextSize()));
      if (p.dG(localas.ilB) == 0) {
        break label621;
      }
    }
    label163:
    label209:
    label621:
    for (Bitmap localBitmap = com.tencent.mm.ak.c.mb(localas.ilB);; localBitmap = null)
    {
      if (localBitmap == null)
      {
        paramViewGroup.fuj.setImageDrawable(com.tencent.mm.cd.a.l(this.imP, 2131690013));
        if (!this.imT) {
          break label209;
        }
        paramViewGroup.iiG.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(131260);
        return paramView;
        paramViewGroup = (b)paramView.getTag();
        break;
        paramViewGroup.fuj.setImageBitmap(localBitmap);
        break label163;
        switch (localas.ilC)
        {
        }
        for (;;)
        {
          switch (localas.gUd)
          {
          default: 
            break;
          case 0: 
          case 2: 
            paramViewGroup.fxX.setVisibility(0);
            paramViewGroup.iiH.setVisibility(4);
            break;
            if (localas.gUd == 2)
            {
              paramViewGroup.iiG.setClickable(false);
              paramViewGroup.iiG.setBackgroundDrawable(null);
              paramViewGroup.fxX.setText(2131759664);
              paramViewGroup.fxX.setTextColor(this.imP.getResources().getColor(2131100544));
            }
            else
            {
              paramViewGroup.iiG.setClickable(true);
              paramViewGroup.iiG.setBackgroundResource(2131231365);
              paramViewGroup.fxX.setText(2131759663);
              paramViewGroup.fxX.setTextColor(this.imP.getResources().getColor(2131101182));
              continue;
              if ((((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHT(localas.getUsername())) || (u.aqG().equals(localas.getUsername())))
              {
                paramViewGroup.iiG.setClickable(false);
                paramViewGroup.iiG.setBackgroundDrawable(null);
                paramViewGroup.fxX.setText(2131759662);
                paramViewGroup.fxX.setTextColor(this.imP.getResources().getColor(2131100544));
              }
              else if (localas.gUd == 2)
              {
                paramViewGroup.iiG.setClickable(false);
                paramViewGroup.iiG.setBackgroundDrawable(null);
                paramViewGroup.fxX.setText(2131759667);
                paramViewGroup.fxX.setTextColor(this.imP.getResources().getColor(2131100544));
              }
              else
              {
                paramViewGroup.iiG.setClickable(true);
                paramViewGroup.iiG.setBackgroundResource(2131231365);
                paramViewGroup.fxX.setText(2131759661);
                paramViewGroup.fxX.setTextColor(this.imP.getResources().getColor(2131101182));
              }
            }
            break;
          }
        }
        paramViewGroup.fxX.setVisibility(4);
        paramViewGroup.iiH.setVisibility(0);
      }
    }
  }
  
  public final void vZ(String paramString)
  {
    AppMethodBeat.i(131261);
    notifyDataSetChanged();
    AppMethodBeat.o(131261);
  }
  
  static abstract interface a
  {
    public abstract void e(int paramInt1, String paramString, int paramInt2);
  }
  
  final class b
  {
    ImageView fuj;
    TextView fxX;
    int iiE;
    TextView iiF;
    View iiG;
    ProgressBar iiH;
    String imX;
    int status;
    
    public b(View paramView)
    {
      AppMethodBeat.i(131255);
      this.fuj = ((ImageView)paramView.findViewById(2131298722));
      this.iiF = ((TextView)paramView.findViewById(2131303561));
      this.iiG = paramView.findViewById(2131303555);
      this.fxX = ((TextView)paramView.findViewById(2131303563));
      this.iiH = ((ProgressBar)paramView.findViewById(2131303562));
      this.iiG.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(131254);
          if (e.b(e.this) != null) {
            e.b(e.this).e(e.b.this.iiE, e.b.this.imX, e.b.this.status);
          }
          AppMethodBeat.o(131254);
        }
      });
      AppMethodBeat.o(131255);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.e
 * JD-Core Version:    0.7.0.1
 */