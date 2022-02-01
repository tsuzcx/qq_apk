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
import com.tencent.mm.g.c.ax;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class e
  extends d
{
  private final int adT;
  private final MMActivity gte;
  private String kcL;
  private final a kha;
  private final c khb;
  private d.a khc;
  boolean khd;
  private a khe;
  
  public e(MMActivity paramMMActivity, int paramInt)
  {
    super(paramMMActivity, new com.tencent.mm.plugin.account.friend.a.as());
    AppMethodBeat.i(131256);
    this.khd = false;
    this.khe = new a()
    {
      public final void f(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        AppMethodBeat.i(131250);
        Log.d("MicroMsg.QQFriendAdapter", "[cpan] postion:%d qq:%s status:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString, Integer.valueOf(paramAnonymousInt2) });
        com.tencent.mm.plugin.account.friend.a.as localas = (com.tencent.mm.plugin.account.friend.a.as)e.this.getItem(paramAnonymousInt1);
        if (localas == null)
        {
          Log.e("MicroMsg.QQFriendAdapter", "[cpan] qq friend is null. qq:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(131250);
          return;
        }
        if (Util.isNullOrNil(localas.getUsername()))
        {
          Log.e("MicroMsg.QQFriendAdapter", "[cpan] qq friend username is null. qq:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(131250);
          return;
        }
        Log.d("MicroMsg.QQFriendAdapter", "qq friend:%s", new Object[] { localas.toString() });
        if (localas.kfO == 0)
        {
          paramAnonymousInt1 = p.fd(localas.kfN);
          paramAnonymousString = new g(e.a(e.this), new g.a()
          {
            public final void i(boolean paramAnonymous2Boolean, String paramAnonymous2String)
            {
              AppMethodBeat.i(131248);
              paramAnonymous2String = ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).AT(p.fd(paramAnonymous2String));
              if (paramAnonymous2String != null)
              {
                paramAnonymous2String.iKU = 2;
                Log.d("MicroMsg.QQFriendAdapter", "qq friend onSendInviteEmail:%s", new Object[] { paramAnonymous2String.toString() });
                ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(paramAnonymous2String.kfN, paramAnonymous2String);
                e.this.anp();
                AppMethodBeat.o(131248);
                return;
              }
              Log.w("MicroMsg.QQFriendAdapter", "cpan qq friedn is null. qq:%s", new Object[] { paramAnonymous2String });
              AppMethodBeat.o(131248);
            }
          }, (byte)0);
          paramAnonymousString.t(new int[] { paramAnonymousInt1 });
          paramAnonymousString.khI = localas.kfN;
          localas.iKU = 1;
          ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(localas.kfN, localas);
          e.this.anp();
          AppMethodBeat.o(131250);
          return;
        }
        if (localas.kfO == 1)
        {
          paramAnonymousString = new com.tencent.mm.pluginsdk.ui.applet.a(e.a(e.this), new com.tencent.mm.pluginsdk.ui.applet.a.a()
          {
            public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
            {
              AppMethodBeat.i(131249);
              Log.i("MicroMsg.QQFriendAdapter", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2), paramAnonymous2String1, paramAnonymous2String2 });
              long l = new p(p.fd(paramAnonymous2String2)).longValue();
              com.tencent.mm.plugin.account.friend.a.as localas = ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).AT(l);
              if ((localas != null) && (paramAnonymous2Boolean1)) {
                localas.username = paramAnonymous2String1;
              }
              if (localas != null)
              {
                localas.iKU = 2;
                Log.d("MicroMsg.QQFriendAdapter", "f :%s", new Object[] { localas.toString() });
                ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(l, localas);
                e.this.anp();
              }
              for (;;)
              {
                if ((paramAnonymous2Boolean1) && (localas != null)) {
                  e.Tk(paramAnonymous2String1);
                }
                AppMethodBeat.o(131249);
                return;
                Log.w("MicroMsg.QQFriendAdapter", "cpan qq friend is null. qq:%s", new Object[] { paramAnonymous2String2 });
              }
            }
          });
          paramAnonymousString.khI = localas.kfN;
          paramAnonymousString.Kee = false;
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(Integer.valueOf(12));
          paramAnonymousString.b(localas.getUsername(), localLinkedList, true);
          localas.iKU = 1;
          ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(localas.kfN, localas);
          e.this.anp();
        }
        AppMethodBeat.o(131250);
      }
    };
    this.gte = paramMMActivity;
    this.adT = paramInt;
    this.khd = paramMMActivity.getIntent().getBooleanExtra("qqgroup_sendmessage", false);
    this.kha = new a(paramMMActivity, new a.a()
    {
      public final void Tj(String paramAnonymousString)
      {
        AppMethodBeat.i(131251);
        Object localObject = (at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg();
        com.tencent.mm.plugin.account.friend.a.as localas = ((at)localObject).Tg(paramAnonymousString);
        if (localas == null)
        {
          Log.w("MicroMsg.QQFriendAdapter", "[cpan] dealSucc failed. qqlist is null. username is :%s", new Object[] { String.valueOf(paramAnonymousString) });
          AppMethodBeat.o(131251);
          return;
        }
        localas.kfO = 2;
        ((at)localObject).a(localas.kfN, localas);
        e.this.notifyDataSetChanged();
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramAnonymousString);
        if (localObject != null) {
          if (((((ax)localObject).field_conRemark == null) || (((ax)localObject).field_conRemark.equals(""))) && (localas != null) && (localas.boz() != null) && (!localas.boz().equals(""))) {
            ab.c((com.tencent.mm.storage.as)localObject, localas.boz());
          }
        }
        for (;;)
        {
          cf.aWl().f(26, new Object[0]);
          AppMethodBeat.o(131251);
          return;
          localas = ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).Tg(paramAnonymousString);
          if (localas != null)
          {
            localas.boC();
            Log.d("MicroMsg.QQFriendAdapter", "user " + paramAnonymousString + " qq " + localas.kfN);
            ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(localas.kfN, localas);
          }
        }
      }
      
      public final void ae(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(131252);
        if (paramAnonymousBoolean)
        {
          com.tencent.mm.plugin.account.friend.a.as localas = ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).Tg(paramAnonymousString);
          if (localas == null) {
            break label109;
          }
          localas.boC();
          Log.d("MicroMsg.QQFriendAdapter", "user " + paramAnonymousString + " qq " + localas.kfN);
          ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(localas.kfN, localas);
        }
        for (;;)
        {
          e.this.notifyDataSetChanged();
          AppMethodBeat.o(131252);
          return;
          label109:
          Log.w("MicroMsg.QQFriendAdapter", "[cpan] dealFail failed. qqlist is null. username is :%s", new Object[] { String.valueOf(paramAnonymousString) });
        }
      }
    });
    this.khb = new c(paramMMActivity, new c.a()
    {
      public final void gm(boolean paramAnonymousBoolean)
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
  
  public final void Mr(String paramString)
  {
    AppMethodBeat.i(131261);
    notifyDataSetChanged();
    AppMethodBeat.o(131261);
  }
  
  public final void SM(String paramString)
  {
    AppMethodBeat.i(131257);
    this.kcL = Util.escapeSqlValue(paramString.trim());
    ebf();
    anp();
    AppMethodBeat.o(131257);
  }
  
  public final void a(d.a parama)
  {
    this.khc = parama;
  }
  
  public final void anp()
  {
    AppMethodBeat.i(131259);
    ebf();
    if (Util.isNullOrNil(this.kcL)) {
      setCursor(((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).J(this.adT, this.khd));
    }
    for (;;)
    {
      if ((this.khc != null) && (this.kcL != null)) {
        this.khc.ve(getCursor().getCount());
      }
      notifyDataSetChanged();
      AppMethodBeat.o(131259);
      return;
      setCursor(((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).b(this.adT, this.kcL, this.khd));
    }
  }
  
  public final void anq()
  {
    AppMethodBeat.i(131258);
    anp();
    AppMethodBeat.o(131258);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(131260);
    com.tencent.mm.plugin.account.friend.a.as localas = (com.tencent.mm.plugin.account.friend.a.as)getItem(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.gte, 2131495994, null);
      paramViewGroup = new b(paramView);
      paramView.setTag(paramViewGroup);
      paramViewGroup.kcR = paramInt;
      paramViewGroup.khh = localas.kfN;
      paramViewGroup.status = localas.kfO;
      paramViewGroup.kcS.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.gte, localas.getDisplayName(), paramViewGroup.kcS.getTextSize()));
      if (p.fd(localas.kfN) == 0) {
        break label621;
      }
    }
    label163:
    label209:
    label621:
    for (Bitmap localBitmap = com.tencent.mm.aj.c.Ah(localas.kfN);; localBitmap = null)
    {
      if (localBitmap == null)
      {
        paramViewGroup.gyr.setImageDrawable(com.tencent.mm.cb.a.l(this.gte, 2131690042));
        if (!this.khd) {
          break label209;
        }
        paramViewGroup.kcT.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(131260);
        return paramView;
        paramViewGroup = (b)paramView.getTag();
        break;
        paramViewGroup.gyr.setImageBitmap(localBitmap);
        break label163;
        switch (localas.kfO)
        {
        }
        for (;;)
        {
          switch (localas.iKU)
          {
          default: 
            break;
          case 0: 
          case 2: 
            paramViewGroup.gCd.setVisibility(0);
            paramViewGroup.hRO.setVisibility(4);
            break;
            if (localas.iKU == 2)
            {
              paramViewGroup.kcT.setClickable(false);
              paramViewGroup.kcT.setBackgroundDrawable(null);
              paramViewGroup.gCd.setText(2131760985);
              paramViewGroup.gCd.setTextColor(this.gte.getResources().getColor(2131100682));
            }
            else
            {
              paramViewGroup.kcT.setClickable(true);
              paramViewGroup.kcT.setBackgroundResource(2131231429);
              paramViewGroup.gCd.setText(2131760984);
              paramViewGroup.gCd.setTextColor(this.gte.getResources().getColor(2131101427));
              continue;
              if ((((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjG(localas.getUsername())) || (z.aTY().equals(localas.getUsername())))
              {
                paramViewGroup.kcT.setClickable(false);
                paramViewGroup.kcT.setBackgroundDrawable(null);
                paramViewGroup.gCd.setText(2131760983);
                paramViewGroup.gCd.setTextColor(this.gte.getResources().getColor(2131100682));
              }
              else if (localas.iKU == 2)
              {
                paramViewGroup.kcT.setClickable(false);
                paramViewGroup.kcT.setBackgroundDrawable(null);
                paramViewGroup.gCd.setText(2131760988);
                paramViewGroup.gCd.setTextColor(this.gte.getResources().getColor(2131100682));
              }
              else
              {
                paramViewGroup.kcT.setClickable(true);
                paramViewGroup.kcT.setBackgroundResource(2131231429);
                paramViewGroup.gCd.setText(2131760982);
                paramViewGroup.gCd.setTextColor(this.gte.getResources().getColor(2131101427));
              }
            }
            break;
          }
        }
        paramViewGroup.gCd.setVisibility(4);
        paramViewGroup.hRO.setVisibility(0);
      }
    }
  }
  
  static abstract interface a
  {
    public abstract void f(int paramInt1, String paramString, int paramInt2);
  }
  
  final class b
  {
    TextView gCd;
    ImageView gyr;
    ProgressBar hRO;
    int kcR;
    TextView kcS;
    View kcT;
    String khh;
    int status;
    
    public b(View paramView)
    {
      AppMethodBeat.i(131255);
      this.gyr = ((ImageView)paramView.findViewById(2131299160));
      this.kcS = ((TextView)paramView.findViewById(2131306336));
      this.kcT = paramView.findViewById(2131306330);
      this.gCd = ((TextView)paramView.findViewById(2131306338));
      this.hRO = ((ProgressBar)paramView.findViewById(2131306337));
      this.kcT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(131254);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/QQFriendAdapterCaseA$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (e.b(e.this) != null) {
            e.b(e.this).f(e.b.this.kcR, e.b.this.khh, e.b.this.status);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/QQFriendAdapterCaseA$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(131254);
        }
      });
      AppMethodBeat.o(131255);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.e
 * JD-Core Version:    0.7.0.1
 */