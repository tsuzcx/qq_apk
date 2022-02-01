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
import com.tencent.mm.aj.c;
import com.tencent.mm.b.p;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class f
  extends d
{
  private final int adG;
  private final MMActivity fNT;
  private String jeI;
  private d.a jja;
  boolean jji;
  private a jjj;
  
  public f(MMActivity paramMMActivity, int paramInt)
  {
    super(paramMMActivity, new as());
    AppMethodBeat.i(131267);
    this.jji = false;
    this.jjj = new a()
    {
      public final void f(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        AppMethodBeat.i(131264);
        ae.d("MicroMsg.QQFriendAdapterCaseB", "[cpan] postion:%d qq:%s status:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString, Integer.valueOf(paramAnonymousInt2) });
        as localas = (as)f.this.getItem(paramAnonymousInt1);
        if (localas == null)
        {
          ae.e("MicroMsg.QQFriendAdapterCaseB", "[cpan] qq friend is null. qq:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(131264);
          return;
        }
        ae.d("MicroMsg.QQFriendAdapterCaseB", "qq friend:%s", new Object[] { localas.toString() });
        if (localas.jhL == 1)
        {
          paramAnonymousString = new com.tencent.mm.pluginsdk.ui.applet.a(f.a(f.this), new a.a()
          {
            public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
            {
              AppMethodBeat.i(131263);
              ae.i("MicroMsg.QQFriendAdapterCaseB", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2), paramAnonymous2String1, paramAnonymous2String2 });
              long l = new p(p.ew(paramAnonymous2String2)).longValue();
              as localas = ((at)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).sO(l);
              if ((paramAnonymous2Boolean1) && (localas != null)) {
                localas.username = paramAnonymous2String1;
              }
              if (localas != null)
              {
                localas.hPN = 2;
                ae.d("MicroMsg.QQFriendAdapterCaseB", "f :%s", new Object[] { localas.toString() });
                ((at)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(l, localas);
                f.this.ZD();
              }
              for (;;)
              {
                if ((paramAnonymous2Boolean1) && (localas != null)) {
                  f.Km(paramAnonymous2String1);
                }
                AppMethodBeat.o(131263);
                return;
                ae.w("MicroMsg.QQFriendAdapterCaseB", "cpan qq friend is null. qq:%s", new Object[] { paramAnonymous2String2 });
              }
            }
          });
          paramAnonymousString.jjG = localas.jhK;
          paramAnonymousString.Fno = false;
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(Integer.valueOf(12));
          if (bu.isNullOrNil(localas.getUsername()))
          {
            ae.w("MicroMsg.QQFriendAdapterCaseB", "[cpan] qq friend username is null.");
            AppMethodBeat.o(131264);
            return;
          }
          paramAnonymousString.b(localas.getUsername(), localLinkedList, true);
          localas.hPN = 1;
          ((at)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(localas.jhK, localas);
          f.this.ZD();
        }
        AppMethodBeat.o(131264);
      }
    };
    this.fNT = paramMMActivity;
    this.adG = paramInt;
    this.jji = paramMMActivity.getIntent().getBooleanExtra("qqgroup_sendmessage", false);
    xs(true);
    AppMethodBeat.o(131267);
  }
  
  private static String b(as paramas)
  {
    AppMethodBeat.i(131272);
    if (paramas.hPM == 123)
    {
      AppMethodBeat.o(131272);
      return "#";
    }
    char c = (char)paramas.hPM;
    AppMethodBeat.o(131272);
    return String.valueOf(c);
  }
  
  public final void DG(String paramString) {}
  
  public final void JN(String paramString)
  {
    AppMethodBeat.i(131268);
    this.jeI = bu.aSk(paramString.trim());
    dhl();
    ZD();
    AppMethodBeat.o(131268);
  }
  
  public final void ZD()
  {
    AppMethodBeat.i(131270);
    dhl();
    if (bu.isNullOrNil(this.jeI)) {
      setCursor(((at)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).F(this.adG, this.jji));
    }
    for (;;)
    {
      if ((this.jja != null) && (this.jeI != null)) {
        this.jja.ro(getCursor().getCount());
      }
      notifyDataSetChanged();
      AppMethodBeat.o(131270);
      return;
      setCursor(((at)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).b(this.adG, this.jeI, this.jji));
    }
  }
  
  public final void ZE()
  {
    AppMethodBeat.i(131269);
    ZD();
    AppMethodBeat.o(131269);
  }
  
  public final void a(d.a parama)
  {
    this.jja = parama;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(131271);
    as localas = (as)getItem(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.fNT, 2131494181, null);
      paramViewGroup = new b(paramView);
      paramView.setTag(paramViewGroup);
      paramViewGroup.jeO = paramInt;
      paramViewGroup.account = localas.jhK;
      paramViewGroup.status = localas.jhL;
      paramViewGroup.jeW.setText(k.b(this.fNT, localas.getDisplayName(), paramViewGroup.jeW.getTextSize()));
      paramViewGroup.jeX.setText(k.b(this.fNT, localas.VK(), paramViewGroup.jeX.getTextSize()));
      if (!this.jji) {
        break label364;
      }
      if (p.ew(paramViewGroup.account) == 0) {
        break label847;
      }
    }
    label182:
    label198:
    label847:
    for (Object localObject = c.sb(localas.jhK);; localObject = null)
    {
      int i;
      if (localObject == null)
      {
        paramViewGroup.fTj.setImageDrawable(com.tencent.mm.cb.a.l(this.fNT, 2131690013));
        if (!this.jji) {
          break label379;
        }
        paramViewGroup.jeQ.setVisibility(8);
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
        ae.d("MicroMsg.QQFriendAdapterCaseB", "qq friend pre:%s", new Object[] { localObject });
        if (localas == null) {
          break label698;
        }
        localObject = localas.toString();
        ae.d("MicroMsg.QQFriendAdapterCaseB", "qq friend:%s", new Object[] { localObject });
        if (paramInt != 0) {
          break label737;
        }
        localObject = b(localas);
        if (!bu.isNullOrNil((String)localObject)) {
          break label706;
        }
        ae.w("MicroMsg.QQFriendAdapterCaseB", "get display show head return null, user[%s] pos[%d]", new Object[] { localas.getUsername(), Integer.valueOf(paramInt) });
        paramViewGroup.jeV.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(131271);
        return paramView;
        paramViewGroup = (b)paramView.getTag();
        break;
        paramViewGroup.fTj.setImageBitmap((Bitmap)localObject);
        break label182;
        label364:
        a.b.c(paramViewGroup.fTj, localas.getUsername());
        break label182;
        label379:
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
            paramViewGroup.jeY.setVisibility(4);
            break;
            if ((((l)g.ab(l.class)).azF().aUH(localas.getUsername())) || (v.aAC().equals(localas.getUsername())))
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
            break;
          }
        }
        paramViewGroup.fWX.setVisibility(4);
        paramViewGroup.jeY.setVisibility(0);
        break label198;
        i = ((as)localObject).hPM;
        break label218;
        localObject = "";
        break label230;
        localObject = "";
        break label260;
        paramViewGroup.jeV.setVisibility(0);
        paramViewGroup.jeV.setText((CharSequence)localObject);
        paramViewGroup.jeV.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        continue;
        label737:
        if (localas.hPM != i) {}
        for (i = 1;; i = 0)
        {
          localObject = b(localas);
          if ((!bu.isNullOrNil((String)localObject)) && (i != 0)) {
            break label816;
          }
          ae.w("MicroMsg.QQFriendAdapterCaseB", "get display show head return null, user[%s] pos[%d]", new Object[] { localas.getUsername(), Integer.valueOf(paramInt) });
          paramViewGroup.jeV.setVisibility(8);
          break;
        }
        paramViewGroup.jeV.setVisibility(0);
        paramViewGroup.jeV.setText((CharSequence)localObject);
        paramViewGroup.jeV.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
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
    ImageView fTj;
    TextView fWX;
    int jeO;
    View jeQ;
    TextView jeV;
    TextView jeW;
    TextView jeX;
    ProgressBar jeY;
    int status;
    
    public b(View paramView)
    {
      AppMethodBeat.i(131266);
      this.jeV = ((TextView)paramView.findViewById(2131300294));
      this.fTj = ((ImageView)paramView.findViewById(2131300293));
      this.jeW = ((TextView)paramView.findViewById(2131300295));
      this.jeX = ((TextView)paramView.findViewById(2131300298));
      this.jeQ = paramView.findViewById(2131300292);
      this.fWX = ((TextView)paramView.findViewById(2131300297));
      this.jeY = ((ProgressBar)paramView.findViewById(2131300296));
      this.jeQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(131265);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/QQFriendAdapterCaseB$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (f.b(f.this) != null) {
            f.b(f.this).f(f.b.this.jeO, f.b.this.account, f.b.this.status);
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