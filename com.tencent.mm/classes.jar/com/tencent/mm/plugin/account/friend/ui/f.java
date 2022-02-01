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
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class f
  extends d
{
  private final int aaU;
  private String iiy;
  private final MMActivity imP;
  private d.a imS;
  boolean ina;
  private a inb;
  
  public f(MMActivity paramMMActivity, int paramInt)
  {
    super(paramMMActivity, new as());
    AppMethodBeat.i(131267);
    this.ina = false;
    this.inb = new a()
    {
      public final void e(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
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
        if (localas.ilC == 1)
        {
          paramAnonymousString = new com.tencent.mm.pluginsdk.ui.applet.a(f.a(f.this), new a.a()
          {
            public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
            {
              AppMethodBeat.i(131263);
              ad.i("MicroMsg.QQFriendAdapterCaseB", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2), paramAnonymous2String1, paramAnonymous2String2 });
              long l = new p(p.dG(paramAnonymous2String2)).longValue();
              as localas = ((at)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).mN(l);
              if ((paramAnonymous2Boolean1) && (localas != null)) {
                localas.username = paramAnonymous2String1;
              }
              if (localas != null)
              {
                localas.gUd = 2;
                ad.d("MicroMsg.QQFriendAdapterCaseB", "f :%s", new Object[] { localas.toString() });
                ((at)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(l, localas);
                f.this.Wd();
              }
              for (;;)
              {
                if ((paramAnonymous2Boolean1) && (localas != null)) {
                  f.Cv(paramAnonymous2String1);
                }
                AppMethodBeat.o(131263);
                return;
                ad.w("MicroMsg.QQFriendAdapterCaseB", "cpan qq friend is null. qq:%s", new Object[] { paramAnonymous2String2 });
              }
            }
          });
          paramAnonymousString.iny = localas.ilB;
          paramAnonymousString.BXy = false;
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(Integer.valueOf(12));
          if (bt.isNullOrNil(localas.getUsername()))
          {
            ad.w("MicroMsg.QQFriendAdapterCaseB", "[cpan] qq friend username is null.");
            AppMethodBeat.o(131264);
            return;
          }
          paramAnonymousString.b(localas.getUsername(), localLinkedList, true);
          localas.gUd = 1;
          ((at)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(localas.ilB, localas);
          f.this.Wd();
        }
        AppMethodBeat.o(131264);
      }
    };
    this.imP = paramMMActivity;
    this.aaU = paramInt;
    this.ina = paramMMActivity.getIntent().getBooleanExtra("qqgroup_sendmessage", false);
    vw(true);
    AppMethodBeat.o(131267);
  }
  
  private static String b(as paramas)
  {
    AppMethodBeat.i(131272);
    if (paramas.gUc == 123)
    {
      AppMethodBeat.o(131272);
      return "#";
    }
    char c = (char)paramas.gUc;
    AppMethodBeat.o(131272);
    return String.valueOf(c);
  }
  
  public final void BW(String paramString)
  {
    AppMethodBeat.i(131268);
    this.iiy = bt.aFQ(paramString.trim());
    cHX();
    Wd();
    AppMethodBeat.o(131268);
  }
  
  public final void Wd()
  {
    AppMethodBeat.i(131270);
    cHX();
    if (bt.isNullOrNil(this.iiy)) {
      setCursor(((at)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).F(this.aaU, this.ina));
    }
    for (;;)
    {
      if ((this.imS != null) && (this.iiy != null)) {
        this.imS.pY(getCursor().getCount());
      }
      notifyDataSetChanged();
      AppMethodBeat.o(131270);
      return;
      setCursor(((at)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).b(this.aaU, this.iiy, this.ina));
    }
  }
  
  public final void We()
  {
    AppMethodBeat.i(131269);
    Wd();
    AppMethodBeat.o(131269);
  }
  
  public final void a(d.a parama)
  {
    this.imS = parama;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(131271);
    as localas = (as)getItem(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.imP, 2131494181, null);
      paramViewGroup = new b(paramView);
      paramView.setTag(paramViewGroup);
      paramViewGroup.iiE = paramInt;
      paramViewGroup.account = localas.ilB;
      paramViewGroup.status = localas.ilC;
      paramViewGroup.iiN.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.imP, localas.getDisplayName(), paramViewGroup.iiN.getTextSize()));
      paramViewGroup.iiO.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.imP, localas.Su(), paramViewGroup.iiO.getTextSize()));
      if (!this.ina) {
        break label364;
      }
      if (p.dG(paramViewGroup.account) == 0) {
        break label847;
      }
    }
    label182:
    label198:
    label847:
    for (Object localObject = c.mb(localas.ilB);; localObject = null)
    {
      int i;
      if (localObject == null)
      {
        paramViewGroup.fuj.setImageDrawable(com.tencent.mm.cd.a.l(this.imP, 2131690013));
        if (!this.ina) {
          break label379;
        }
        paramViewGroup.iiG.setVisibility(8);
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
        paramViewGroup.iiM.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(131271);
        return paramView;
        paramViewGroup = (b)paramView.getTag();
        break;
        paramViewGroup.fuj.setImageBitmap((Bitmap)localObject);
        break label182;
        label364:
        a.b.c(paramViewGroup.fuj, localas.getUsername());
        break label182;
        label379:
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
            paramViewGroup.iiP.setVisibility(4);
            break;
            if ((((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHT(localas.getUsername())) || (u.aqG().equals(localas.getUsername())))
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
            break;
          }
        }
        paramViewGroup.fxX.setVisibility(4);
        paramViewGroup.iiP.setVisibility(0);
        break label198;
        i = ((as)localObject).gUc;
        break label218;
        localObject = "";
        break label230;
        localObject = "";
        break label260;
        paramViewGroup.iiM.setVisibility(0);
        paramViewGroup.iiM.setText((CharSequence)localObject);
        paramViewGroup.iiM.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        continue;
        label737:
        if (localas.gUc != i) {}
        for (i = 1;; i = 0)
        {
          localObject = b(localas);
          if ((!bt.isNullOrNil((String)localObject)) && (i != 0)) {
            break label816;
          }
          ad.w("MicroMsg.QQFriendAdapterCaseB", "get display show head return null, user[%s] pos[%d]", new Object[] { localas.getUsername(), Integer.valueOf(paramInt) });
          paramViewGroup.iiM.setVisibility(8);
          break;
        }
        paramViewGroup.iiM.setVisibility(0);
        paramViewGroup.iiM.setText((CharSequence)localObject);
        paramViewGroup.iiM.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      }
    }
  }
  
  public final void vZ(String paramString) {}
  
  static abstract interface a
  {
    public abstract void e(int paramInt1, String paramString, int paramInt2);
  }
  
  final class b
  {
    String account;
    ImageView fuj;
    TextView fxX;
    int iiE;
    View iiG;
    TextView iiM;
    TextView iiN;
    TextView iiO;
    ProgressBar iiP;
    int status;
    
    public b(View paramView)
    {
      AppMethodBeat.i(131266);
      this.iiM = ((TextView)paramView.findViewById(2131300294));
      this.fuj = ((ImageView)paramView.findViewById(2131300293));
      this.iiN = ((TextView)paramView.findViewById(2131300295));
      this.iiO = ((TextView)paramView.findViewById(2131300298));
      this.iiG = paramView.findViewById(2131300292);
      this.fxX = ((TextView)paramView.findViewById(2131300297));
      this.iiP = ((ProgressBar)paramView.findViewById(2131300296));
      this.iiG.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(131265);
          if (f.b(f.this) != null) {
            f.b(f.this).e(f.b.this.iiE, f.b.this.account, f.b.this.status);
          }
          AppMethodBeat.o(131265);
        }
      });
      AppMethodBeat.o(131266);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.f
 * JD-Core Version:    0.7.0.1
 */