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
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class f
  extends d
{
  private final int adT;
  private final MMActivity gte;
  private String kcL;
  private d.a khc;
  boolean khk;
  private a khl;
  
  public f(MMActivity paramMMActivity, int paramInt)
  {
    super(paramMMActivity, new as());
    AppMethodBeat.i(131267);
    this.khk = false;
    this.khl = new a()
    {
      public final void f(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        AppMethodBeat.i(131264);
        Log.d("MicroMsg.QQFriendAdapterCaseB", "[cpan] postion:%d qq:%s status:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString, Integer.valueOf(paramAnonymousInt2) });
        as localas = (as)f.this.getItem(paramAnonymousInt1);
        if (localas == null)
        {
          Log.e("MicroMsg.QQFriendAdapterCaseB", "[cpan] qq friend is null. qq:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(131264);
          return;
        }
        Log.d("MicroMsg.QQFriendAdapterCaseB", "qq friend:%s", new Object[] { localas.toString() });
        if (localas.kfO == 1)
        {
          paramAnonymousString = new com.tencent.mm.pluginsdk.ui.applet.a(f.a(f.this), new a.a()
          {
            public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
            {
              AppMethodBeat.i(131263);
              Log.i("MicroMsg.QQFriendAdapterCaseB", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2), paramAnonymous2String1, paramAnonymous2String2 });
              long l = new p(p.fd(paramAnonymous2String2)).longValue();
              as localas = ((at)((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).AT(l);
              if ((paramAnonymous2Boolean1) && (localas != null)) {
                localas.username = paramAnonymous2String1;
              }
              if (localas != null)
              {
                localas.iKU = 2;
                Log.d("MicroMsg.QQFriendAdapterCaseB", "f :%s", new Object[] { localas.toString() });
                ((at)((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(l, localas);
                f.this.anp();
              }
              for (;;)
              {
                if ((paramAnonymous2Boolean1) && (localas != null)) {
                  f.Tk(paramAnonymous2String1);
                }
                AppMethodBeat.o(131263);
                return;
                Log.w("MicroMsg.QQFriendAdapterCaseB", "cpan qq friend is null. qq:%s", new Object[] { paramAnonymous2String2 });
              }
            }
          });
          paramAnonymousString.khI = localas.kfN;
          paramAnonymousString.Kee = false;
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(Integer.valueOf(12));
          if (Util.isNullOrNil(localas.getUsername()))
          {
            Log.w("MicroMsg.QQFriendAdapterCaseB", "[cpan] qq friend username is null.");
            AppMethodBeat.o(131264);
            return;
          }
          paramAnonymousString.b(localas.getUsername(), localLinkedList, true);
          localas.iKU = 1;
          ((at)((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(localas.kfN, localas);
          f.this.anp();
        }
        AppMethodBeat.o(131264);
      }
    };
    this.gte = paramMMActivity;
    this.adT = paramInt;
    this.khk = paramMMActivity.getIntent().getBooleanExtra("qqgroup_sendmessage", false);
    Bh(true);
    AppMethodBeat.o(131267);
  }
  
  private static String b(as paramas)
  {
    AppMethodBeat.i(131272);
    if (paramas.iKT == 123)
    {
      AppMethodBeat.o(131272);
      return "#";
    }
    char c = (char)paramas.iKT;
    AppMethodBeat.o(131272);
    return String.valueOf(c);
  }
  
  public final void Mr(String paramString) {}
  
  public final void SM(String paramString)
  {
    AppMethodBeat.i(131268);
    this.kcL = Util.escapeSqlValue(paramString.trim());
    ebf();
    anp();
    AppMethodBeat.o(131268);
  }
  
  public final void a(d.a parama)
  {
    this.khc = parama;
  }
  
  public final void anp()
  {
    AppMethodBeat.i(131270);
    ebf();
    if (Util.isNullOrNil(this.kcL)) {
      setCursor(((at)((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).J(this.adT, this.khk));
    }
    for (;;)
    {
      if ((this.khc != null) && (this.kcL != null)) {
        this.khc.ve(getCursor().getCount());
      }
      notifyDataSetChanged();
      AppMethodBeat.o(131270);
      return;
      setCursor(((at)((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).b(this.adT, this.kcL, this.khk));
    }
  }
  
  public final void anq()
  {
    AppMethodBeat.i(131269);
    anp();
    AppMethodBeat.o(131269);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(131271);
    as localas = (as)getItem(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.gte, 2131494735, null);
      paramViewGroup = new b(paramView);
      paramView.setTag(paramViewGroup);
      paramViewGroup.kcR = paramInt;
      paramViewGroup.account = localas.kfN;
      paramViewGroup.status = localas.kfO;
      paramViewGroup.kcZ.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.gte, localas.getDisplayName(), paramViewGroup.kcZ.getTextSize()));
      paramViewGroup.kda.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.gte, localas.getNickname(), paramViewGroup.kda.getTextSize()));
      if (!this.khk) {
        break label364;
      }
      if (p.fd(paramViewGroup.account) == 0) {
        break label847;
      }
    }
    label182:
    label198:
    label847:
    for (Object localObject = c.Ah(localas.kfN);; localObject = null)
    {
      int i;
      if (localObject == null)
      {
        paramViewGroup.gyr.setImageDrawable(com.tencent.mm.cb.a.l(this.gte, 2131690042));
        if (!this.khk) {
          break label379;
        }
        paramViewGroup.kcT.setVisibility(8);
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
        Log.d("MicroMsg.QQFriendAdapterCaseB", "qq friend pre:%s", new Object[] { localObject });
        if (localas == null) {
          break label698;
        }
        localObject = localas.toString();
        Log.d("MicroMsg.QQFriendAdapterCaseB", "qq friend:%s", new Object[] { localObject });
        if (paramInt != 0) {
          break label737;
        }
        localObject = b(localas);
        if (!Util.isNullOrNil((String)localObject)) {
          break label706;
        }
        Log.w("MicroMsg.QQFriendAdapterCaseB", "get display show head return null, user[%s] pos[%d]", new Object[] { localas.getUsername(), Integer.valueOf(paramInt) });
        paramViewGroup.kcY.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(131271);
        return paramView;
        paramViewGroup = (b)paramView.getTag();
        break;
        paramViewGroup.gyr.setImageBitmap((Bitmap)localObject);
        break label182;
        label364:
        a.b.c(paramViewGroup.gyr, localas.getUsername());
        break label182;
        label379:
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
            paramViewGroup.kdb.setVisibility(4);
            break;
            if ((((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjG(localas.getUsername())) || (z.aTY().equals(localas.getUsername())))
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
            break;
          }
        }
        paramViewGroup.gCd.setVisibility(4);
        paramViewGroup.kdb.setVisibility(0);
        break label198;
        i = ((as)localObject).iKT;
        break label218;
        localObject = "";
        break label230;
        localObject = "";
        break label260;
        paramViewGroup.kcY.setVisibility(0);
        paramViewGroup.kcY.setText((CharSequence)localObject);
        paramViewGroup.kcY.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        continue;
        label737:
        if (localas.iKT != i) {}
        for (i = 1;; i = 0)
        {
          localObject = b(localas);
          if ((!Util.isNullOrNil((String)localObject)) && (i != 0)) {
            break label816;
          }
          Log.w("MicroMsg.QQFriendAdapterCaseB", "get display show head return null, user[%s] pos[%d]", new Object[] { localas.getUsername(), Integer.valueOf(paramInt) });
          paramViewGroup.kcY.setVisibility(8);
          break;
        }
        paramViewGroup.kcY.setVisibility(0);
        paramViewGroup.kcY.setText((CharSequence)localObject);
        paramViewGroup.kcY.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
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
    TextView gCd;
    ImageView gyr;
    int kcR;
    View kcT;
    TextView kcY;
    TextView kcZ;
    TextView kda;
    ProgressBar kdb;
    int status;
    
    public b(View paramView)
    {
      AppMethodBeat.i(131266);
      this.kcY = ((TextView)paramView.findViewById(2131301784));
      this.gyr = ((ImageView)paramView.findViewById(2131301783));
      this.kcZ = ((TextView)paramView.findViewById(2131301785));
      this.kda = ((TextView)paramView.findViewById(2131301788));
      this.kcT = paramView.findViewById(2131301782);
      this.gCd = ((TextView)paramView.findViewById(2131301787));
      this.kdb = ((ProgressBar)paramView.findViewById(2131301786));
      this.kcT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(131265);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/QQFriendAdapterCaseB$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (f.b(f.this) != null) {
            f.b(f.this).f(f.b.this.kcR, f.b.this.account, f.b.this.status);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/QQFriendAdapterCaseB$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(131265);
        }
      });
      AppMethodBeat.o(131266);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.f
 * JD-Core Version:    0.7.0.1
 */