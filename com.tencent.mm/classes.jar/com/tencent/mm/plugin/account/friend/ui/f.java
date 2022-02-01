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
import com.tencent.mm.ak.c;
import com.tencent.mm.b.p;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class f
  extends d
{
  private final int adG;
  private final MMActivity fLP;
  private String jbP;
  private d.a jgh;
  boolean jgp;
  private a jgq;
  
  public f(MMActivity paramMMActivity, int paramInt)
  {
    super(paramMMActivity, new as());
    AppMethodBeat.i(131267);
    this.jgp = false;
    this.jgq = new a()
    {
      public final void f(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        AppMethodBeat.i(131264);
        ad.d("MicroMsg.QQFriendAdapterCaseB", "[cpan] postion:%d qq:%s status:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString, Integer.valueOf(paramAnonymousInt2) });
        as localas = (as)f.this.getItem(paramAnonymousInt1);
        if (localas == null)
        {
          ad.e("MicroMsg.QQFriendAdapterCaseB", "[cpan] qq friend is null. qq:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(131264);
          return;
        }
        ad.d("MicroMsg.QQFriendAdapterCaseB", "qq friend:%s", new Object[] { localas.toString() });
        if (localas.jeS == 1)
        {
          paramAnonymousString = new com.tencent.mm.pluginsdk.ui.applet.a(f.a(f.this), new a.a()
          {
            public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
            {
              AppMethodBeat.i(131263);
              ad.i("MicroMsg.QQFriendAdapterCaseB", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2), paramAnonymous2String1, paramAnonymous2String2 });
              long l = new p(p.er(paramAnonymous2String2)).longValue();
              as localas = ((at)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).sB(l);
              if ((paramAnonymous2Boolean1) && (localas != null)) {
                localas.username = paramAnonymous2String1;
              }
              if (localas != null)
              {
                localas.hMU = 2;
                ad.d("MicroMsg.QQFriendAdapterCaseB", "f :%s", new Object[] { localas.toString() });
                ((at)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(l, localas);
                f.this.Zu();
              }
              for (;;)
              {
                if ((paramAnonymous2Boolean1) && (localas != null)) {
                  f.JN(paramAnonymous2String1);
                }
                AppMethodBeat.o(131263);
                return;
                ad.w("MicroMsg.QQFriendAdapterCaseB", "cpan qq friend is null. qq:%s", new Object[] { paramAnonymous2String2 });
              }
            }
          });
          paramAnonymousString.jgN = localas.jeR;
          paramAnonymousString.EUT = false;
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(Integer.valueOf(12));
          if (bt.isNullOrNil(localas.getUsername()))
          {
            ad.w("MicroMsg.QQFriendAdapterCaseB", "[cpan] qq friend username is null.");
            AppMethodBeat.o(131264);
            return;
          }
          paramAnonymousString.b(localas.getUsername(), localLinkedList, true);
          localas.hMU = 1;
          ((at)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(localas.jeR, localas);
          f.this.Zu();
        }
        AppMethodBeat.o(131264);
      }
    };
    this.fLP = paramMMActivity;
    this.adG = paramInt;
    this.jgp = paramMMActivity.getIntent().getBooleanExtra("qqgroup_sendmessage", false);
    xk(true);
    AppMethodBeat.o(131267);
  }
  
  private static String b(as paramas)
  {
    AppMethodBeat.i(131272);
    if (paramas.hMT == 123)
    {
      AppMethodBeat.o(131272);
      return "#";
    }
    char c = (char)paramas.hMT;
    AppMethodBeat.o(131272);
    return String.valueOf(c);
  }
  
  public final void De(String paramString) {}
  
  public final void Jo(String paramString)
  {
    AppMethodBeat.i(131268);
    this.jbP = bt.aQN(paramString.trim());
    det();
    Zu();
    AppMethodBeat.o(131268);
  }
  
  public final void Zu()
  {
    AppMethodBeat.i(131270);
    det();
    if (bt.isNullOrNil(this.jbP)) {
      setCursor(((at)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).F(this.adG, this.jgp));
    }
    for (;;)
    {
      if ((this.jgh != null) && (this.jbP != null)) {
        this.jgh.rl(getCursor().getCount());
      }
      notifyDataSetChanged();
      AppMethodBeat.o(131270);
      return;
      setCursor(((at)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).b(this.adG, this.jbP, this.jgp));
    }
  }
  
  public final void Zv()
  {
    AppMethodBeat.i(131269);
    Zu();
    AppMethodBeat.o(131269);
  }
  
  public final void a(d.a parama)
  {
    this.jgh = parama;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(131271);
    as localas = (as)getItem(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.fLP, 2131494181, null);
      paramViewGroup = new b(paramView);
      paramView.setTag(paramViewGroup);
      paramViewGroup.jbV = paramInt;
      paramViewGroup.account = localas.jeR;
      paramViewGroup.status = localas.jeS;
      paramViewGroup.jcd.setText(k.b(this.fLP, localas.getDisplayName(), paramViewGroup.jcd.getTextSize()));
      paramViewGroup.jce.setText(k.b(this.fLP, localas.VC(), paramViewGroup.jce.getTextSize()));
      if (!this.jgp) {
        break label364;
      }
      if (p.er(paramViewGroup.account) == 0) {
        break label847;
      }
    }
    label182:
    label198:
    label847:
    for (Object localObject = c.rO(localas.jeR);; localObject = null)
    {
      int i;
      if (localObject == null)
      {
        paramViewGroup.fRd.setImageDrawable(com.tencent.mm.cc.a.l(this.fLP, 2131690013));
        if (!this.jgp) {
          break label379;
        }
        paramViewGroup.jbX.setVisibility(8);
        localObject = (as)getItem(paramInt - 1);
        if (localObject != null) {
          break label680;
        }
        i = -1;
        label218:
        if (localObject == null) {
          break label690;
        }
        localObject = ((as)localObject).toString();
        label230:
        ad.d("MicroMsg.QQFriendAdapterCaseB", "qq friend pre:%s", new Object[] { localObject });
        if (localas == null) {
          break label698;
        }
        localObject = localas.toString();
        ad.d("MicroMsg.QQFriendAdapterCaseB", "qq friend:%s", new Object[] { localObject });
        if (paramInt != 0) {
          break label737;
        }
        localObject = b(localas);
        if (!bt.isNullOrNil((String)localObject)) {
          break label706;
        }
        ad.w("MicroMsg.QQFriendAdapterCaseB", "get display show head return null, user[%s] pos[%d]", new Object[] { localas.getUsername(), Integer.valueOf(paramInt) });
        paramViewGroup.jcc.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(131271);
        return paramView;
        paramViewGroup = (b)paramView.getTag();
        break;
        paramViewGroup.fRd.setImageBitmap((Bitmap)localObject);
        break label182;
        label364:
        a.b.c(paramViewGroup.fRd, localas.getUsername());
        break label182;
        label379:
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
            paramViewGroup.jcf.setVisibility(4);
            break;
            if ((((l)g.ab(l.class)).azp().aTg(localas.getUsername())) || (u.aAm().equals(localas.getUsername())))
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
            break;
          }
        }
        paramViewGroup.fUR.setVisibility(4);
        paramViewGroup.jcf.setVisibility(0);
        break label198;
        i = ((as)localObject).hMT;
        break label218;
        localObject = "";
        break label230;
        localObject = "";
        break label260;
        paramViewGroup.jcc.setVisibility(0);
        paramViewGroup.jcc.setText((CharSequence)localObject);
        paramViewGroup.jcc.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        continue;
        label737:
        if (localas.hMT != i) {}
        for (i = 1;; i = 0)
        {
          localObject = b(localas);
          if ((!bt.isNullOrNil((String)localObject)) && (i != 0)) {
            break label816;
          }
          ad.w("MicroMsg.QQFriendAdapterCaseB", "get display show head return null, user[%s] pos[%d]", new Object[] { localas.getUsername(), Integer.valueOf(paramInt) });
          paramViewGroup.jcc.setVisibility(8);
          break;
        }
        paramViewGroup.jcc.setVisibility(0);
        paramViewGroup.jcc.setText((CharSequence)localObject);
        paramViewGroup.jcc.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      }
    }
  }
  
  static abstract interface a
  {
    public abstract void f(int paramInt1, String paramString, int paramInt2);
  }
  
  final class b
  {
    String account;
    ImageView fRd;
    TextView fUR;
    int jbV;
    View jbX;
    TextView jcc;
    TextView jcd;
    TextView jce;
    ProgressBar jcf;
    int status;
    
    public b(View paramView)
    {
      AppMethodBeat.i(131266);
      this.jcc = ((TextView)paramView.findViewById(2131300294));
      this.fRd = ((ImageView)paramView.findViewById(2131300293));
      this.jcd = ((TextView)paramView.findViewById(2131300295));
      this.jce = ((TextView)paramView.findViewById(2131300298));
      this.jbX = paramView.findViewById(2131300292);
      this.fUR = ((TextView)paramView.findViewById(2131300297));
      this.jcf = ((ProgressBar)paramView.findViewById(2131300296));
      this.jbX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(131265);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/QQFriendAdapterCaseB$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (f.b(f.this) != null) {
            f.b(f.this).f(f.b.this.jbV, f.b.this.account, f.b.this.status);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/QQFriendAdapterCaseB$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(131265);
        }
      });
      AppMethodBeat.o(131266);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.f
 * JD-Core Version:    0.7.0.1
 */