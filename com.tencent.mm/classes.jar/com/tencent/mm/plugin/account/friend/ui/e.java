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
import com.tencent.mm.plugin.account.friend.a.b;
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

public final class e
  extends d
{
  private final MMActivity iXq;
  private final int ka;
  private String mUk;
  private final c mYA;
  private d.a mYB;
  boolean mYC;
  private a mYD;
  private final a mYz;
  
  public e(MMActivity paramMMActivity, int paramInt)
  {
    super(paramMMActivity, new as());
    AppMethodBeat.i(131256);
    this.mYC = false;
    this.mYD = new a()
    {
      public final void f(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        AppMethodBeat.i(131250);
        Log.d("MicroMsg.QQFriendAdapter", "[cpan] postion:%d qq:%s status:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString, Integer.valueOf(paramAnonymousInt2) });
        as localas = (as)e.this.getItem(paramAnonymousInt1);
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
        if (localas.mXn == 0)
        {
          paramAnonymousInt1 = p.fT(localas.mXm);
          paramAnonymousString = new g(e.a(e.this), new g.a()
          {
            public final void l(boolean paramAnonymous2Boolean, String paramAnonymous2String)
            {
              AppMethodBeat.i(131248);
              paramAnonymous2String = ((at)((com.tencent.mm.plugin.account.sdk.a.a)h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg()).Hd(p.fT(paramAnonymous2String));
              if (paramAnonymous2String != null)
              {
                paramAnonymous2String.lBb = 2;
                Log.d("MicroMsg.QQFriendAdapter", "qq friend onSendInviteEmail:%s", new Object[] { paramAnonymous2String.toString() });
                ((at)((com.tencent.mm.plugin.account.sdk.a.a)h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg()).a(paramAnonymous2String.mXm, paramAnonymous2String);
                e.this.atr();
                AppMethodBeat.o(131248);
                return;
              }
              Log.w("MicroMsg.QQFriendAdapter", "cpan qq friedn is null. qq:%s", new Object[] { paramAnonymous2String });
              AppMethodBeat.o(131248);
            }
          }, (byte)0);
          paramAnonymousString.t(new int[] { paramAnonymousInt1 });
          paramAnonymousString.mZh = localas.mXm;
          localas.lBb = 1;
          ((at)((com.tencent.mm.plugin.account.sdk.a.a)h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg()).a(localas.mXm, localas);
          e.this.atr();
          AppMethodBeat.o(131250);
          return;
        }
        if (localas.mXn == 1)
        {
          paramAnonymousString = new com.tencent.mm.pluginsdk.ui.applet.a(e.a(e.this), new com.tencent.mm.pluginsdk.ui.applet.a.a()
          {
            public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
            {
              AppMethodBeat.i(131249);
              Log.i("MicroMsg.QQFriendAdapter", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2), paramAnonymous2String1, paramAnonymous2String2 });
              long l = new p(p.fT(paramAnonymous2String2)).longValue();
              as localas = ((at)((com.tencent.mm.plugin.account.sdk.a.a)h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg()).Hd(l);
              if ((localas != null) && (paramAnonymous2Boolean1)) {
                localas.username = paramAnonymous2String1;
              }
              if (localas != null)
              {
                localas.lBb = 2;
                Log.d("MicroMsg.QQFriendAdapter", "f :%s", new Object[] { localas.toString() });
                ((at)((com.tencent.mm.plugin.account.sdk.a.a)h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg()).a(l, localas);
                e.this.atr();
              }
              for (;;)
              {
                if ((paramAnonymous2Boolean1) && (localas != null)) {
                  e.aaQ(paramAnonymous2String1);
                }
                AppMethodBeat.o(131249);
                return;
                Log.w("MicroMsg.QQFriendAdapter", "cpan qq friend is null. qq:%s", new Object[] { paramAnonymous2String2 });
              }
            }
          });
          paramAnonymousString.mZh = localas.mXm;
          paramAnonymousString.fgi = false;
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(Integer.valueOf(12));
          paramAnonymousString.b(localas.getUsername(), localLinkedList, true);
          localas.lBb = 1;
          ((at)((com.tencent.mm.plugin.account.sdk.a.a)h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg()).a(localas.mXm, localas);
          e.this.atr();
        }
        AppMethodBeat.o(131250);
      }
    };
    this.iXq = paramMMActivity;
    this.ka = paramInt;
    this.mYC = paramMMActivity.getIntent().getBooleanExtra("qqgroup_sendmessage", false);
    this.mYz = new a(paramMMActivity, new e.2(this));
    this.mYA = new c(paramMMActivity, new e.3(this));
    AppMethodBeat.o(131256);
  }
  
  public final void TM(String paramString)
  {
    AppMethodBeat.i(131261);
    notifyDataSetChanged();
    AppMethodBeat.o(131261);
  }
  
  public final void a(d.a parama)
  {
    this.mYB = parama;
  }
  
  public final void aas(String paramString)
  {
    AppMethodBeat.i(131257);
    this.mUk = Util.escapeSqlValue(paramString.trim());
    eKd();
    atr();
    AppMethodBeat.o(131257);
  }
  
  public final void atr()
  {
    AppMethodBeat.i(131259);
    eKd();
    if (Util.isNullOrNil(this.mUk)) {
      v(((at)((com.tencent.mm.plugin.account.sdk.a.a)h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg()).L(this.ka, this.mYC));
    }
    for (;;)
    {
      if ((this.mYB != null) && (this.mUk != null)) {
        this.mYB.yi(hK().getCount());
      }
      notifyDataSetChanged();
      AppMethodBeat.o(131259);
      return;
      v(((at)((com.tencent.mm.plugin.account.sdk.a.a)h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg()).b(this.ka, this.mUk, this.mYC));
    }
  }
  
  public final void ats()
  {
    AppMethodBeat.i(131258);
    atr();
    AppMethodBeat.o(131258);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(131260);
    as localas = (as)getItem(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.iXq, a.d.qq_friend_item, null);
      paramViewGroup = new b(paramView);
      paramView.setTag(paramViewGroup);
      paramViewGroup.mUq = paramInt;
      paramViewGroup.mYG = localas.mXm;
      paramViewGroup.status = localas.mXn;
      paramViewGroup.mUr.setText(l.b(this.iXq, localas.getDisplayName(), paramViewGroup.mUr.getTextSize()));
      if (p.fT(localas.mXm) == 0) {
        break label621;
      }
    }
    label164:
    label210:
    label621:
    for (Bitmap localBitmap = com.tencent.mm.am.d.Go(localas.mXm);; localBitmap = null)
    {
      if (localBitmap == null)
      {
        paramViewGroup.jiu.setImageDrawable(com.tencent.mm.ci.a.m(this.iXq, a.f.default_avatar));
        if (!this.mYC) {
          break label210;
        }
        paramViewGroup.mUs.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(131260);
        return paramView;
        paramViewGroup = (b)paramView.getTag();
        break;
        paramViewGroup.jiu.setImageBitmap(localBitmap);
        break label164;
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
            paramViewGroup.kGl.setVisibility(4);
            break;
            if (localas.lBb == 2)
            {
              paramViewGroup.mUs.setClickable(false);
              paramViewGroup.mUs.setBackgroundDrawable(null);
              paramViewGroup.jmj.setText(a.g.friend_invited);
              paramViewGroup.jmj.setTextColor(this.iXq.getResources().getColor(com.tencent.mm.plugin.account.friend.a.a.lightgrey));
            }
            else
            {
              paramViewGroup.mUs.setClickable(true);
              paramViewGroup.mUs.setBackgroundResource(a.b.btn_solid_green);
              paramViewGroup.jmj.setText(a.g.friend_invite);
              paramViewGroup.jmj.setTextColor(this.iXq.getResources().getColor(com.tencent.mm.plugin.account.friend.a.a.white_text_color));
              continue;
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
                paramViewGroup.mUs.setBackgroundResource(a.b.btn_solid_green);
                paramViewGroup.jmj.setText(a.g.friend_add);
                paramViewGroup.jmj.setTextColor(this.iXq.getResources().getColor(com.tencent.mm.plugin.account.friend.a.a.white_text_color));
              }
            }
            break;
          }
        }
        paramViewGroup.jmj.setVisibility(4);
        paramViewGroup.kGl.setVisibility(0);
      }
    }
  }
  
  static abstract interface a
  {
    public abstract void f(int paramInt1, String paramString, int paramInt2);
  }
  
  final class b
  {
    ImageView jiu;
    TextView jmj;
    ProgressBar kGl;
    int mUq;
    TextView mUr;
    View mUs;
    String mYG;
    int status;
    
    public b(View paramView)
    {
      AppMethodBeat.i(131255);
      this.jiu = ((ImageView)paramView.findViewById(a.c.contactitem_avatar_iv));
      this.mUr = ((TextView)paramView.findViewById(a.c.qq_friend_name));
      this.mUs = paramView.findViewById(a.c.qq_friend_action_view);
      this.jmj = ((TextView)paramView.findViewById(a.c.qq_friend_status_tv));
      this.kGl = ((ProgressBar)paramView.findViewById(a.c.qq_friend_status_pb));
      this.mUs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(131254);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/friend/ui/QQFriendAdapterCaseA$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (e.b(e.this) != null) {
            e.b(e.this).f(e.b.this.mUq, e.b.this.mYG, e.b.this.status);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/QQFriendAdapterCaseA$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(131254);
        }
      });
      AppMethodBeat.o(131255);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.e
 * JD-Core Version:    0.7.0.1
 */