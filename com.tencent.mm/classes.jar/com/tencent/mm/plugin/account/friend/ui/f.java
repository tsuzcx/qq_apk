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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.friend.a.c;
import com.tencent.mm.plugin.account.friend.a.d;
import com.tencent.mm.plugin.account.friend.a.f;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class f
  extends d
{
  private final MMActivity iXq;
  private final int ka;
  private String mUk;
  private d.a mYB;
  boolean mYJ;
  private a mYK;
  
  public f(MMActivity paramMMActivity, int paramInt)
  {
    super(paramMMActivity, new as());
    AppMethodBeat.i(131267);
    this.mYJ = false;
    this.mYK = new a()
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
        if (localas.mXn == 1)
        {
          paramAnonymousString = new com.tencent.mm.pluginsdk.ui.applet.a(f.a(f.this), new com.tencent.mm.pluginsdk.ui.applet.a.a()
          {
            public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
            {
              AppMethodBeat.i(131263);
              Log.i("MicroMsg.QQFriendAdapterCaseB", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2), paramAnonymous2String1, paramAnonymous2String2 });
              long l = new p(p.fT(paramAnonymous2String2)).longValue();
              as localas = ((at)((com.tencent.mm.plugin.account.sdk.a.a)h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg()).Hd(l);
              if ((paramAnonymous2Boolean1) && (localas != null)) {
                localas.username = paramAnonymous2String1;
              }
              if (localas != null)
              {
                localas.lBb = 2;
                Log.d("MicroMsg.QQFriendAdapterCaseB", "f :%s", new Object[] { localas.toString() });
                ((at)((com.tencent.mm.plugin.account.sdk.a.a)h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg()).a(l, localas);
                f.this.atr();
              }
              for (;;)
              {
                if ((paramAnonymous2Boolean1) && (localas != null)) {
                  f.aaQ(paramAnonymous2String1);
                }
                AppMethodBeat.o(131263);
                return;
                Log.w("MicroMsg.QQFriendAdapterCaseB", "cpan qq friend is null. qq:%s", new Object[] { paramAnonymous2String2 });
              }
            }
          });
          paramAnonymousString.mZh = localas.mXm;
          paramAnonymousString.fgi = false;
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(Integer.valueOf(12));
          if (Util.isNullOrNil(localas.getUsername()))
          {
            Log.w("MicroMsg.QQFriendAdapterCaseB", "[cpan] qq friend username is null.");
            AppMethodBeat.o(131264);
            return;
          }
          paramAnonymousString.b(localas.getUsername(), localLinkedList, true);
          localas.lBb = 1;
          ((at)((com.tencent.mm.plugin.account.sdk.a.a)h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg()).a(localas.mXm, localas);
          f.this.atr();
        }
        AppMethodBeat.o(131264);
      }
    };
    this.iXq = paramMMActivity;
    this.ka = paramInt;
    this.mYJ = paramMMActivity.getIntent().getBooleanExtra("qqgroup_sendmessage", false);
    Fx(true);
    AppMethodBeat.o(131267);
  }
  
  private static String b(as paramas)
  {
    AppMethodBeat.i(131272);
    if (paramas.lBa == 123)
    {
      AppMethodBeat.o(131272);
      return "#";
    }
    char c = (char)paramas.lBa;
    AppMethodBeat.o(131272);
    return String.valueOf(c);
  }
  
  public final void TM(String paramString) {}
  
  public final void a(d.a parama)
  {
    this.mYB = parama;
  }
  
  public final void aas(String paramString)
  {
    AppMethodBeat.i(131268);
    this.mUk = Util.escapeSqlValue(paramString.trim());
    eKd();
    atr();
    AppMethodBeat.o(131268);
  }
  
  public final void atr()
  {
    AppMethodBeat.i(131270);
    eKd();
    if (Util.isNullOrNil(this.mUk)) {
      v(((at)((com.tencent.mm.plugin.account.sdk.a.a)h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg()).L(this.ka, this.mYJ));
    }
    for (;;)
    {
      if ((this.mYB != null) && (this.mUk != null)) {
        this.mYB.yi(hK().getCount());
      }
      notifyDataSetChanged();
      AppMethodBeat.o(131270);
      return;
      v(((at)((com.tencent.mm.plugin.account.sdk.a.a)h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg()).b(this.ka, this.mUk, this.mYJ));
    }
  }
  
  public final void ats()
  {
    AppMethodBeat.i(131269);
    atr();
    AppMethodBeat.o(131269);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(131271);
    as localas = (as)getItem(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.iXq, a.d.friend_list_item, null);
      paramViewGroup = new b(paramView);
      paramView.setTag(paramViewGroup);
      paramViewGroup.mUq = paramInt;
      paramViewGroup.account = localas.mXm;
      paramViewGroup.status = localas.mXn;
      paramViewGroup.mUy.setText(l.b(this.iXq, localas.getDisplayName(), paramViewGroup.mUy.getTextSize()));
      paramViewGroup.mUz.setText(l.b(this.iXq, localas.getNickname(), paramViewGroup.mUz.getTextSize()));
      if (!this.mYJ) {
        break label365;
      }
      if (p.fT(paramViewGroup.account) == 0) {
        break label847;
      }
    }
    label183:
    label199:
    label847:
    for (Object localObject = com.tencent.mm.am.d.Go(localas.mXm);; localObject = null)
    {
      int i;
      if (localObject == null)
      {
        paramViewGroup.jiu.setImageDrawable(com.tencent.mm.ci.a.m(this.iXq, a.f.default_avatar));
        if (!this.mYJ) {
          break label380;
        }
        paramViewGroup.mUs.setVisibility(8);
        localObject = (as)getItem(paramInt - 1);
        if (localObject != null) {
          break label680;
        }
        i = -1;
        label219:
        if (localObject == null) {
          break label690;
        }
        localObject = ((as)localObject).toString();
        label231:
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
        paramViewGroup.mUx.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(131271);
        return paramView;
        paramViewGroup = (b)paramView.getTag();
        break;
        paramViewGroup.jiu.setImageBitmap((Bitmap)localObject);
        break label183;
        label365:
        com.tencent.mm.pluginsdk.ui.a.b.c(paramViewGroup.jiu, localas.getUsername());
        break label183;
        label380:
        switch (localas.mXn)
        {
        }
        for (;;)
        {
          switch (localas.lBb)
          {
          default: 
            break;
          case 0: 
          case 2: 
            paramViewGroup.jmj.setVisibility(0);
            paramViewGroup.mUB.setVisibility(4);
            break;
            if ((((n)h.ae(n.class)).bbL().bwd(localas.getUsername())) || (z.bcZ().equals(localas.getUsername())))
            {
              paramViewGroup.mUs.setClickable(false);
              paramViewGroup.mUs.setBackgroundDrawable(null);
              paramViewGroup.jmj.setText(a.g.friend_added);
              paramViewGroup.jmj.setTextColor(this.iXq.getResources().getColor(com.tencent.mm.plugin.account.friend.a.a.lightgrey));
            }
            else if (localas.lBb == 2)
            {
              paramViewGroup.mUs.setClickable(false);
              paramViewGroup.mUs.setBackgroundDrawable(null);
              paramViewGroup.jmj.setText(a.g.friend_waiting_ask);
              paramViewGroup.jmj.setTextColor(this.iXq.getResources().getColor(com.tencent.mm.plugin.account.friend.a.a.lightgrey));
            }
            else
            {
              paramViewGroup.mUs.setClickable(true);
              paramViewGroup.mUs.setBackgroundResource(com.tencent.mm.plugin.account.friend.a.b.btn_solid_green);
              paramViewGroup.jmj.setText(a.g.friend_add);
              paramViewGroup.jmj.setTextColor(this.iXq.getResources().getColor(com.tencent.mm.plugin.account.friend.a.a.white_text_color));
            }
            break;
          }
        }
        paramViewGroup.jmj.setVisibility(4);
        paramViewGroup.mUB.setVisibility(0);
        break label199;
        i = ((as)localObject).lBa;
        break label219;
        localObject = "";
        break label231;
        localObject = "";
        break label261;
        paramViewGroup.mUx.setVisibility(0);
        paramViewGroup.mUx.setText((CharSequence)localObject);
        paramViewGroup.mUx.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        continue;
        label737:
        if (localas.lBa != i) {}
        for (i = 1;; i = 0)
        {
          localObject = b(localas);
          if ((!Util.isNullOrNil((String)localObject)) && (i != 0)) {
            break label816;
          }
          Log.w("MicroMsg.QQFriendAdapterCaseB", "get display show head return null, user[%s] pos[%d]", new Object[] { localas.getUsername(), Integer.valueOf(paramInt) });
          paramViewGroup.mUx.setVisibility(8);
          break;
        }
        paramViewGroup.mUx.setVisibility(0);
        paramViewGroup.mUx.setText((CharSequence)localObject);
        paramViewGroup.mUx.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
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
    ImageView jiu;
    TextView jmj;
    ProgressBar mUB;
    int mUq;
    View mUs;
    TextView mUx;
    TextView mUy;
    TextView mUz;
    int status;
    
    public b(View paramView)
    {
      AppMethodBeat.i(131266);
      this.mUx = ((TextView)paramView.findViewById(a.c.friend_item_catalog));
      this.jiu = ((ImageView)paramView.findViewById(a.c.friend_item_avatar_iv));
      this.mUy = ((TextView)paramView.findViewById(a.c.friend_item_nickname));
      this.mUz = ((TextView)paramView.findViewById(a.c.friend_item_wx_nickname));
      this.mUs = paramView.findViewById(a.c.friend_item_action_view);
      this.jmj = ((TextView)paramView.findViewById(a.c.friend_item_status_tv));
      this.mUB = ((ProgressBar)paramView.findViewById(a.c.friend_item_status_pb));
      this.mUs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(131265);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/friend/ui/QQFriendAdapterCaseB$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (f.b(f.this) != null) {
            f.b(f.this).f(f.b.this.mUq, f.b.this.account, f.b.this.status);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/QQFriendAdapterCaseB$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(131265);
        }
      });
      AppMethodBeat.o(131266);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.f
 * JD-Core Version:    0.7.0.1
 */