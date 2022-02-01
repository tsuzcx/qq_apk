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
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class f
  extends d
{
  private final int abP;
  private String iIG;
  private final MMActivity iMV;
  private d.a iMY;
  boolean iNg;
  private a iNh;
  
  public f(MMActivity paramMMActivity, int paramInt)
  {
    super(paramMMActivity, new as());
    AppMethodBeat.i(131267);
    this.iNg = false;
    this.iNh = new a()
    {
      public final void f(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        AppMethodBeat.i(131264);
        ac.d("MicroMsg.QQFriendAdapterCaseB", "[cpan] postion:%d qq:%s status:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString, Integer.valueOf(paramAnonymousInt2) });
        as localas = (as)f.this.getItem(paramAnonymousInt1);
        if (localas == null)
        {
          ac.e("MicroMsg.QQFriendAdapterCaseB", "[cpan] qq friend is null. qq:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(131264);
          return;
        }
        ac.d("MicroMsg.QQFriendAdapterCaseB", "qq friend:%s", new Object[] { localas.toString() });
        if (localas.iLJ == 1)
        {
          paramAnonymousString = new com.tencent.mm.pluginsdk.ui.applet.a(f.a(f.this), new a.a()
          {
            public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
            {
              AppMethodBeat.i(131263);
              ac.i("MicroMsg.QQFriendAdapterCaseB", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2), paramAnonymous2String1, paramAnonymous2String2 });
              long l = new p(p.dv(paramAnonymous2String2)).longValue();
              as localas = ((at)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).qC(l);
              if ((paramAnonymous2Boolean1) && (localas != null)) {
                localas.username = paramAnonymous2String1;
              }
              if (localas != null)
              {
                localas.huC = 2;
                ac.d("MicroMsg.QQFriendAdapterCaseB", "f :%s", new Object[] { localas.toString() });
                ((at)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(l, localas);
                f.this.Xb();
              }
              for (;;)
              {
                if ((paramAnonymous2Boolean1) && (localas != null)) {
                  f.Gy(paramAnonymous2String1);
                }
                AppMethodBeat.o(131263);
                return;
                ac.w("MicroMsg.QQFriendAdapterCaseB", "cpan qq friend is null. qq:%s", new Object[] { paramAnonymous2String2 });
              }
            }
          });
          paramAnonymousString.iNE = localas.iLI;
          paramAnonymousString.DpP = false;
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(Integer.valueOf(12));
          if (bs.isNullOrNil(localas.getUsername()))
          {
            ac.w("MicroMsg.QQFriendAdapterCaseB", "[cpan] qq friend username is null.");
            AppMethodBeat.o(131264);
            return;
          }
          paramAnonymousString.b(localas.getUsername(), localLinkedList, true);
          localas.huC = 1;
          ((at)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(localas.iLI, localas);
          f.this.Xb();
        }
        AppMethodBeat.o(131264);
      }
    };
    this.iMV = paramMMActivity;
    this.abP = paramInt;
    this.iNg = paramMMActivity.getIntent().getBooleanExtra("qqgroup_sendmessage", false);
    wy(true);
    AppMethodBeat.o(131267);
  }
  
  private static String b(as paramas)
  {
    AppMethodBeat.i(131272);
    if (paramas.huB == 123)
    {
      AppMethodBeat.o(131272);
      return "#";
    }
    char c = (char)paramas.huB;
    AppMethodBeat.o(131272);
    return String.valueOf(c);
  }
  
  public final void Af(String paramString) {}
  
  public final void FZ(String paramString)
  {
    AppMethodBeat.i(131268);
    this.iIG = bs.aLh(paramString.trim());
    cVi();
    Xb();
    AppMethodBeat.o(131268);
  }
  
  public final void Xb()
  {
    AppMethodBeat.i(131270);
    cVi();
    if (bs.isNullOrNil(this.iIG)) {
      setCursor(((at)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).F(this.abP, this.iNg));
    }
    for (;;)
    {
      if ((this.iMY != null) && (this.iIG != null)) {
        this.iMY.qL(getCursor().getCount());
      }
      notifyDataSetChanged();
      AppMethodBeat.o(131270);
      return;
      setCursor(((at)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).b(this.abP, this.iIG, this.iNg));
    }
  }
  
  public final void Xc()
  {
    AppMethodBeat.i(131269);
    Xb();
    AppMethodBeat.o(131269);
  }
  
  public final void a(d.a parama)
  {
    this.iMY = parama;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(131271);
    as localas = (as)getItem(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.iMV, 2131494181, null);
      paramViewGroup = new b(paramView);
      paramView.setTag(paramViewGroup);
      paramViewGroup.iIM = paramInt;
      paramViewGroup.account = localas.iLI;
      paramViewGroup.status = localas.iLJ;
      paramViewGroup.iIU.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.iMV, localas.getDisplayName(), paramViewGroup.iIU.getTextSize()));
      paramViewGroup.iIV.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.iMV, localas.Tn(), paramViewGroup.iIV.getTextSize()));
      if (!this.iNg) {
        break label364;
      }
      if (p.dv(paramViewGroup.account) == 0) {
        break label847;
      }
    }
    label182:
    label198:
    label847:
    for (Object localObject = c.pP(localas.iLI);; localObject = null)
    {
      int i;
      if (localObject == null)
      {
        paramViewGroup.fxQ.setImageDrawable(com.tencent.mm.cc.a.l(this.iMV, 2131690013));
        if (!this.iNg) {
          break label379;
        }
        paramViewGroup.iIO.setVisibility(8);
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
        ac.d("MicroMsg.QQFriendAdapterCaseB", "qq friend pre:%s", new Object[] { localObject });
        if (localas == null) {
          break label698;
        }
        localObject = localas.toString();
        ac.d("MicroMsg.QQFriendAdapterCaseB", "qq friend:%s", new Object[] { localObject });
        if (paramInt != 0) {
          break label737;
        }
        localObject = b(localas);
        if (!bs.isNullOrNil((String)localObject)) {
          break label706;
        }
        ac.w("MicroMsg.QQFriendAdapterCaseB", "get display show head return null, user[%s] pos[%d]", new Object[] { localas.getUsername(), Integer.valueOf(paramInt) });
        paramViewGroup.iIT.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(131271);
        return paramView;
        paramViewGroup = (b)paramView.getTag();
        break;
        paramViewGroup.fxQ.setImageBitmap((Bitmap)localObject);
        break label182;
        label364:
        a.b.c(paramViewGroup.fxQ, localas.getUsername());
        break label182;
        label379:
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
            paramViewGroup.iIW.setVisibility(4);
            break;
            if ((((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNo(localas.getUsername())) || (u.axw().equals(localas.getUsername())))
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
            break;
          }
        }
        paramViewGroup.fBE.setVisibility(4);
        paramViewGroup.iIW.setVisibility(0);
        break label198;
        i = ((as)localObject).huB;
        break label218;
        localObject = "";
        break label230;
        localObject = "";
        break label260;
        paramViewGroup.iIT.setVisibility(0);
        paramViewGroup.iIT.setText((CharSequence)localObject);
        paramViewGroup.iIT.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        continue;
        label737:
        if (localas.huB != i) {}
        for (i = 1;; i = 0)
        {
          localObject = b(localas);
          if ((!bs.isNullOrNil((String)localObject)) && (i != 0)) {
            break label816;
          }
          ac.w("MicroMsg.QQFriendAdapterCaseB", "get display show head return null, user[%s] pos[%d]", new Object[] { localas.getUsername(), Integer.valueOf(paramInt) });
          paramViewGroup.iIT.setVisibility(8);
          break;
        }
        paramViewGroup.iIT.setVisibility(0);
        paramViewGroup.iIT.setText((CharSequence)localObject);
        paramViewGroup.iIT.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
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
    TextView fBE;
    ImageView fxQ;
    int iIM;
    View iIO;
    TextView iIT;
    TextView iIU;
    TextView iIV;
    ProgressBar iIW;
    int status;
    
    public b(View paramView)
    {
      AppMethodBeat.i(131266);
      this.iIT = ((TextView)paramView.findViewById(2131300294));
      this.fxQ = ((ImageView)paramView.findViewById(2131300293));
      this.iIU = ((TextView)paramView.findViewById(2131300295));
      this.iIV = ((TextView)paramView.findViewById(2131300298));
      this.iIO = paramView.findViewById(2131300292);
      this.fBE = ((TextView)paramView.findViewById(2131300297));
      this.iIW = ((ProgressBar)paramView.findViewById(2131300296));
      this.iIO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(131265);
          if (f.b(f.this) != null) {
            f.b(f.this).f(f.b.this.iIM, f.b.this.account, f.b.this.status);
          }
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