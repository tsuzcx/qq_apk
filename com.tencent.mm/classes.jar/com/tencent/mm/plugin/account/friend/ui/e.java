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
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.by;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class e
  extends d
{
  private final int abP;
  private String iIG;
  private final MMActivity iMV;
  private final a iMW;
  private final c iMX;
  private d.a iMY;
  boolean iMZ;
  private a iNa;
  
  public e(MMActivity paramMMActivity, int paramInt)
  {
    super(paramMMActivity, new as());
    AppMethodBeat.i(131256);
    this.iMZ = false;
    this.iNa = new a()
    {
      public final void f(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        AppMethodBeat.i(131250);
        ac.d("MicroMsg.QQFriendAdapter", "[cpan] postion:%d qq:%s status:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString, Integer.valueOf(paramAnonymousInt2) });
        as localas = (as)e.this.getItem(paramAnonymousInt1);
        if (localas == null)
        {
          ac.e("MicroMsg.QQFriendAdapter", "[cpan] qq friend is null. qq:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(131250);
          return;
        }
        if (bs.isNullOrNil(localas.getUsername()))
        {
          ac.e("MicroMsg.QQFriendAdapter", "[cpan] qq friend username is null. qq:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(131250);
          return;
        }
        ac.d("MicroMsg.QQFriendAdapter", "qq friend:%s", new Object[] { localas.toString() });
        if (localas.iLJ == 0)
        {
          paramAnonymousInt1 = p.dv(localas.iLI);
          paramAnonymousString = new g(e.a(e.this), new g.a()
          {
            public final void g(boolean paramAnonymous2Boolean, String paramAnonymous2String)
            {
              AppMethodBeat.i(131248);
              paramAnonymous2String = ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).qC(p.dv(paramAnonymous2String));
              if (paramAnonymous2String != null)
              {
                paramAnonymous2String.huC = 2;
                ac.d("MicroMsg.QQFriendAdapter", "qq friend onSendInviteEmail:%s", new Object[] { paramAnonymous2String.toString() });
                ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(paramAnonymous2String.iLI, paramAnonymous2String);
                e.this.Xb();
                AppMethodBeat.o(131248);
                return;
              }
              ac.w("MicroMsg.QQFriendAdapter", "cpan qq friedn is null. qq:%s", new Object[] { paramAnonymous2String });
              AppMethodBeat.o(131248);
            }
          }, (byte)0);
          paramAnonymousString.r(new int[] { paramAnonymousInt1 });
          paramAnonymousString.iNE = localas.iLI;
          localas.huC = 1;
          ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(localas.iLI, localas);
          e.this.Xb();
          AppMethodBeat.o(131250);
          return;
        }
        if (localas.iLJ == 1)
        {
          paramAnonymousString = new com.tencent.mm.pluginsdk.ui.applet.a(e.a(e.this), new com.tencent.mm.pluginsdk.ui.applet.a.a()
          {
            public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
            {
              AppMethodBeat.i(131249);
              ac.i("MicroMsg.QQFriendAdapter", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2), paramAnonymous2String1, paramAnonymous2String2 });
              long l = new p(p.dv(paramAnonymous2String2)).longValue();
              as localas = ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).qC(l);
              if ((localas != null) && (paramAnonymous2Boolean1)) {
                localas.username = paramAnonymous2String1;
              }
              if (localas != null)
              {
                localas.huC = 2;
                ac.d("MicroMsg.QQFriendAdapter", "f :%s", new Object[] { localas.toString() });
                ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(l, localas);
                e.this.Xb();
              }
              for (;;)
              {
                if ((paramAnonymous2Boolean1) && (localas != null)) {
                  e.Gy(paramAnonymous2String1);
                }
                AppMethodBeat.o(131249);
                return;
                ac.w("MicroMsg.QQFriendAdapter", "cpan qq friend is null. qq:%s", new Object[] { paramAnonymous2String2 });
              }
            }
          });
          paramAnonymousString.iNE = localas.iLI;
          paramAnonymousString.DpP = false;
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(Integer.valueOf(12));
          paramAnonymousString.b(localas.getUsername(), localLinkedList, true);
          localas.huC = 1;
          ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(localas.iLI, localas);
          e.this.Xb();
        }
        AppMethodBeat.o(131250);
      }
    };
    this.iMV = paramMMActivity;
    this.abP = paramInt;
    this.iMZ = paramMMActivity.getIntent().getBooleanExtra("qqgroup_sendmessage", false);
    this.iMW = new a(paramMMActivity, new a.a()
    {
      public final void Gx(String paramAnonymousString)
      {
        AppMethodBeat.i(131251);
        Object localObject = (at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg();
        as localas = ((at)localObject).Gu(paramAnonymousString);
        if (localas == null)
        {
          ac.w("MicroMsg.QQFriendAdapter", "[cpan] dealSucc failed. qqlist is null. username is :%s", new Object[] { String.valueOf(paramAnonymousString) });
          AppMethodBeat.o(131251);
          return;
        }
        localas.iLJ = 2;
        ((at)localObject).a(localas.iLI, localas);
        e.this.notifyDataSetChanged();
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramAnonymousString);
        if (localObject != null) {
          if (((((av)localObject).field_conRemark == null) || (((av)localObject).field_conRemark.equals(""))) && (localas != null) && (localas.aQc() != null) && (!localas.aQc().equals(""))) {
            w.c((ai)localObject, localas.aQc());
          }
        }
        for (;;)
        {
          by.azu().d(26, new Object[0]);
          AppMethodBeat.o(131251);
          return;
          localas = ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).Gu(paramAnonymousString);
          if (localas != null)
          {
            localas.aQf();
            ac.d("MicroMsg.QQFriendAdapter", "user " + paramAnonymousString + " qq " + localas.iLI);
            ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(localas.iLI, localas);
          }
        }
      }
      
      public final void ab(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(131252);
        if (paramAnonymousBoolean)
        {
          as localas = ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).Gu(paramAnonymousString);
          if (localas == null) {
            break label109;
          }
          localas.aQf();
          ac.d("MicroMsg.QQFriendAdapter", "user " + paramAnonymousString + " qq " + localas.iLI);
          ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(localas.iLI, localas);
        }
        for (;;)
        {
          e.this.notifyDataSetChanged();
          AppMethodBeat.o(131252);
          return;
          label109:
          ac.w("MicroMsg.QQFriendAdapter", "[cpan] dealFail failed. qqlist is null. username is :%s", new Object[] { String.valueOf(paramAnonymousString) });
        }
      }
    });
    this.iMX = new c(paramMMActivity, new c.a()
    {
      public final void fo(boolean paramAnonymousBoolean)
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
  
  public final void Af(String paramString)
  {
    AppMethodBeat.i(131261);
    notifyDataSetChanged();
    AppMethodBeat.o(131261);
  }
  
  public final void FZ(String paramString)
  {
    AppMethodBeat.i(131257);
    this.iIG = bs.aLh(paramString.trim());
    cVi();
    Xb();
    AppMethodBeat.o(131257);
  }
  
  public final void Xb()
  {
    AppMethodBeat.i(131259);
    cVi();
    if (bs.isNullOrNil(this.iIG)) {
      setCursor(((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).F(this.abP, this.iMZ));
    }
    for (;;)
    {
      if ((this.iMY != null) && (this.iIG != null)) {
        this.iMY.qL(getCursor().getCount());
      }
      notifyDataSetChanged();
      AppMethodBeat.o(131259);
      return;
      setCursor(((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).b(this.abP, this.iIG, this.iMZ));
    }
  }
  
  public final void Xc()
  {
    AppMethodBeat.i(131258);
    Xb();
    AppMethodBeat.o(131258);
  }
  
  public final void a(d.a parama)
  {
    this.iMY = parama;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(131260);
    as localas = (as)getItem(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.iMV, 2131495151, null);
      paramViewGroup = new b(paramView);
      paramView.setTag(paramViewGroup);
      paramViewGroup.iIM = paramInt;
      paramViewGroup.iNd = localas.iLI;
      paramViewGroup.status = localas.iLJ;
      paramViewGroup.iIN.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.iMV, localas.getDisplayName(), paramViewGroup.iIN.getTextSize()));
      if (p.dv(localas.iLI) == 0) {
        break label621;
      }
    }
    label163:
    label209:
    label621:
    for (Bitmap localBitmap = com.tencent.mm.aj.c.pP(localas.iLI);; localBitmap = null)
    {
      if (localBitmap == null)
      {
        paramViewGroup.fxQ.setImageDrawable(com.tencent.mm.cc.a.l(this.iMV, 2131690013));
        if (!this.iMZ) {
          break label209;
        }
        paramViewGroup.iIO.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(131260);
        return paramView;
        paramViewGroup = (b)paramView.getTag();
        break;
        paramViewGroup.fxQ.setImageBitmap(localBitmap);
        break label163;
        switch (localas.iLJ)
        {
        }
        for (;;)
        {
          switch (localas.huC)
          {
          default: 
            break;
          case 0: 
          case 2: 
            paramViewGroup.fBE.setVisibility(0);
            paramViewGroup.gCw.setVisibility(4);
            break;
            if (localas.huC == 2)
            {
              paramViewGroup.iIO.setClickable(false);
              paramViewGroup.iIO.setBackgroundDrawable(null);
              paramViewGroup.fBE.setText(2131759664);
              paramViewGroup.fBE.setTextColor(this.iMV.getResources().getColor(2131100544));
            }
            else
            {
              paramViewGroup.iIO.setClickable(true);
              paramViewGroup.iIO.setBackgroundResource(2131231365);
              paramViewGroup.fBE.setText(2131759663);
              paramViewGroup.fBE.setTextColor(this.iMV.getResources().getColor(2131101182));
              continue;
              if ((((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNo(localas.getUsername())) || (u.axw().equals(localas.getUsername())))
              {
                paramViewGroup.iIO.setClickable(false);
                paramViewGroup.iIO.setBackgroundDrawable(null);
                paramViewGroup.fBE.setText(2131759662);
                paramViewGroup.fBE.setTextColor(this.iMV.getResources().getColor(2131100544));
              }
              else if (localas.huC == 2)
              {
                paramViewGroup.iIO.setClickable(false);
                paramViewGroup.iIO.setBackgroundDrawable(null);
                paramViewGroup.fBE.setText(2131759667);
                paramViewGroup.fBE.setTextColor(this.iMV.getResources().getColor(2131100544));
              }
              else
              {
                paramViewGroup.iIO.setClickable(true);
                paramViewGroup.iIO.setBackgroundResource(2131231365);
                paramViewGroup.fBE.setText(2131759661);
                paramViewGroup.fBE.setTextColor(this.iMV.getResources().getColor(2131101182));
              }
            }
            break;
          }
        }
        paramViewGroup.fBE.setVisibility(4);
        paramViewGroup.gCw.setVisibility(0);
      }
    }
  }
  
  static abstract interface a
  {
    public abstract void f(int paramInt1, String paramString, int paramInt2);
  }
  
  final class b
  {
    TextView fBE;
    ImageView fxQ;
    ProgressBar gCw;
    int iIM;
    TextView iIN;
    View iIO;
    String iNd;
    int status;
    
    public b(View paramView)
    {
      AppMethodBeat.i(131255);
      this.fxQ = ((ImageView)paramView.findViewById(2131298722));
      this.iIN = ((TextView)paramView.findViewById(2131303561));
      this.iIO = paramView.findViewById(2131303555);
      this.fBE = ((TextView)paramView.findViewById(2131303563));
      this.gCw = ((ProgressBar)paramView.findViewById(2131303562));
      this.iIO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(131254);
          if (e.b(e.this) != null) {
            e.b(e.this).f(e.b.this.iIM, e.b.this.iNd, e.b.this.status);
          }
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