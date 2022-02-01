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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.friend.a.b;
import com.tencent.mm.plugin.account.friend.a.c;
import com.tencent.mm.plugin.account.friend.a.d;
import com.tencent.mm.plugin.account.friend.a.f;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.plugin.account.friend.model.ap;
import com.tencent.mm.plugin.account.friend.model.aq;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class e
  extends d
{
  private final int kW;
  private final MMActivity lzt;
  private String pQS;
  private final a pVh;
  private final c pVi;
  private d.a pVj;
  boolean pVk;
  private a pVl;
  
  public e(MMActivity paramMMActivity, int paramInt)
  {
    super(paramMMActivity, new ap());
    AppMethodBeat.i(131256);
    this.pVk = false;
    this.pVl = new a()
    {
      public final void f(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        AppMethodBeat.i(131250);
        Log.d("MicroMsg.QQFriendAdapter", "[cpan] postion:%d qq:%s status:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString, Integer.valueOf(paramAnonymousInt2) });
        ap localap = (ap)e.this.getItem(paramAnonymousInt1);
        if (localap == null)
        {
          Log.e("MicroMsg.QQFriendAdapter", "[cpan] qq friend is null. qq:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(131250);
          return;
        }
        if (Util.isNullOrNil(localap.getUsername()))
        {
          Log.e("MicroMsg.QQFriendAdapter", "[cpan] qq friend username is null. qq:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(131250);
          return;
        }
        Log.d("MicroMsg.QQFriendAdapter", "qq friend:%s", new Object[] { localap.toString() });
        if (localap.pTV == 0)
        {
          paramAnonymousInt1 = com.tencent.mm.b.p.hw(localap.pTU);
          paramAnonymousString = new g(e.a(e.this), new g.a()
          {
            public final void y(boolean paramAnonymous2Boolean, String paramAnonymous2String)
            {
              AppMethodBeat.i(131248);
              paramAnonymous2String = ((aq)((com.tencent.mm.plugin.account.sdk.a.a)h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg()).jt(com.tencent.mm.b.p.hw(paramAnonymous2String));
              if (paramAnonymous2String != null)
              {
                paramAnonymous2String.osD = 2;
                Log.d("MicroMsg.QQFriendAdapter", "qq friend onSendInviteEmail:%s", new Object[] { paramAnonymous2String.toString() });
                ((aq)((com.tencent.mm.plugin.account.sdk.a.a)h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg()).a(paramAnonymous2String.pTU, paramAnonymous2String);
                e.this.aNy();
                AppMethodBeat.o(131248);
                return;
              }
              Log.w("MicroMsg.QQFriendAdapter", "cpan qq friedn is null. qq:%s", new Object[] { paramAnonymous2String });
              AppMethodBeat.o(131248);
            }
          }, (byte)0);
          paramAnonymousString.v(new int[] { paramAnonymousInt1 });
          paramAnonymousString.pVP = localap.pTU;
          localap.osD = 1;
          ((aq)((com.tencent.mm.plugin.account.sdk.a.a)h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg()).a(localap.pTU, localap);
          e.this.aNy();
          AppMethodBeat.o(131250);
          return;
        }
        if (localap.pTV == 1)
        {
          paramAnonymousString = new com.tencent.mm.pluginsdk.ui.applet.a(e.a(e.this), new com.tencent.mm.pluginsdk.ui.applet.a.a()
          {
            public final void canAddContact(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
            {
              AppMethodBeat.i(131249);
              Log.i("MicroMsg.QQFriendAdapter", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2), paramAnonymous2String1, paramAnonymous2String2 });
              long l = new com.tencent.mm.b.p(com.tencent.mm.b.p.hw(paramAnonymous2String2)).longValue();
              ap localap = ((aq)((com.tencent.mm.plugin.account.sdk.a.a)h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg()).jt(l);
              if ((localap != null) && (paramAnonymous2Boolean1)) {
                localap.username = paramAnonymous2String1;
              }
              if (localap != null)
              {
                localap.osD = 2;
                Log.d("MicroMsg.QQFriendAdapter", "f :%s", new Object[] { localap.toString() });
                ((aq)((com.tencent.mm.plugin.account.sdk.a.a)h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg()).a(l, localap);
                e.this.aNy();
              }
              for (;;)
              {
                if ((paramAnonymous2Boolean1) && (localap != null)) {
                  e.Tj(paramAnonymous2String1);
                }
                AppMethodBeat.o(131249);
                return;
                Log.w("MicroMsg.QQFriendAdapter", "cpan qq friend is null. qq:%s", new Object[] { paramAnonymous2String2 });
              }
            }
          });
          paramAnonymousString.pVP = localap.pTU;
          paramAnonymousString.hks = false;
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(Integer.valueOf(12));
          paramAnonymousString.b(localap.getUsername(), localLinkedList, true);
          localap.osD = 1;
          ((aq)((com.tencent.mm.plugin.account.sdk.a.a)h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg()).a(localap.pTU, localap);
          e.this.aNy();
        }
        AppMethodBeat.o(131250);
      }
    };
    this.lzt = paramMMActivity;
    this.kW = paramInt;
    this.pVk = paramMMActivity.getIntent().getBooleanExtra("qqgroup_sendmessage", false);
    this.pVh = new a(paramMMActivity, new a.a()
    {
      public final void Ti(String paramAnonymousString)
      {
        AppMethodBeat.i(131251);
        Object localObject = (aq)((com.tencent.mm.plugin.account.sdk.a.a)h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg();
        ap localap = ((aq)localObject).Tf(paramAnonymousString);
        if (localap == null)
        {
          Log.w("MicroMsg.QQFriendAdapter", "[cpan] dealSucc failed. qqlist is null. username is :%s", new Object[] { String.valueOf(paramAnonymousString) });
          AppMethodBeat.o(131251);
          return;
        }
        localap.pTV = 2;
        ((aq)localObject).a(localap.pTU, localap);
        e.this.notifyDataSetChanged();
        localObject = ((n)h.ax(n.class)).bzA().JE(paramAnonymousString);
        if (localObject != null) {
          if (((((az)localObject).field_conRemark == null) || (((az)localObject).field_conRemark.equals(""))) && (localap != null) && (localap.bXw() != null) && (!localap.bXw().equals(""))) {
            ab.c((au)localObject, localap.bXw());
          }
        }
        for (;;)
        {
          ch.bDg().f(26, new Object[0]);
          AppMethodBeat.o(131251);
          return;
          localap = ((aq)((com.tencent.mm.plugin.account.sdk.a.a)h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg()).Tf(paramAnonymousString);
          if (localap != null)
          {
            localap.bXz();
            Log.d("MicroMsg.QQFriendAdapter", "user " + paramAnonymousString + " qq " + localap.pTU);
            ((aq)((com.tencent.mm.plugin.account.sdk.a.a)h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg()).a(localap.pTU, localap);
          }
        }
      }
      
      public final void al(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(131252);
        if (paramAnonymousBoolean)
        {
          ap localap = ((aq)((com.tencent.mm.plugin.account.sdk.a.a)h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg()).Tf(paramAnonymousString);
          if (localap == null) {
            break label109;
          }
          localap.bXz();
          Log.d("MicroMsg.QQFriendAdapter", "user " + paramAnonymousString + " qq " + localap.pTU);
          ((aq)((com.tencent.mm.plugin.account.sdk.a.a)h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg()).a(localap.pTU, localap);
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
    this.pVi = new c(paramMMActivity, new c.a()
    {
      public final void hO(boolean paramAnonymousBoolean)
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
  
  public final void LM(String paramString)
  {
    AppMethodBeat.i(131261);
    notifyDataSetChanged();
    AppMethodBeat.o(131261);
  }
  
  public final void SM(String paramString)
  {
    AppMethodBeat.i(131257);
    this.pQS = Util.escapeSqlValue(paramString.trim());
    fSd();
    aNy();
    AppMethodBeat.o(131257);
  }
  
  public final void a(d.a parama)
  {
    this.pVj = parama;
  }
  
  public final void aNy()
  {
    AppMethodBeat.i(131259);
    fSd();
    if (Util.isNullOrNil(this.pQS)) {
      w(((aq)((com.tencent.mm.plugin.account.sdk.a.a)h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg()).aa(this.kW, this.pVk));
    }
    for (;;)
    {
      if ((this.pVj != null) && (this.pQS != null)) {
        this.pVj.yo(Fv().getCount());
      }
      notifyDataSetChanged();
      AppMethodBeat.o(131259);
      return;
      w(((aq)((com.tencent.mm.plugin.account.sdk.a.a)h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg()).b(this.kW, this.pQS, this.pVk));
    }
  }
  
  public final void aNz()
  {
    AppMethodBeat.i(131258);
    aNy();
    AppMethodBeat.o(131258);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(131260);
    ap localap = (ap)getItem(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.lzt, a.d.qq_friend_item, null);
      paramViewGroup = new b(paramView);
      paramView.setTag(paramViewGroup);
      paramViewGroup.pQY = paramInt;
      paramViewGroup.pVo = localap.pTU;
      paramViewGroup.status = localap.pTV;
      paramViewGroup.pQZ.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this.lzt, localap.getDisplayName(), paramViewGroup.pQZ.getTextSize()));
      if (com.tencent.mm.b.p.hw(localap.pTU) == 0) {
        break label621;
      }
    }
    label164:
    label210:
    label621:
    for (Bitmap localBitmap = com.tencent.mm.modelavatar.d.iy(localap.pTU);; localBitmap = null)
    {
      if (localBitmap == null)
      {
        paramViewGroup.lKK.setImageDrawable(com.tencent.mm.cd.a.m(this.lzt, a.f.default_avatar));
        if (!this.pVk) {
          break label210;
        }
        paramViewGroup.pRa.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(131260);
        return paramView;
        paramViewGroup = (b)paramView.getTag();
        break;
        paramViewGroup.lKK.setImageBitmap(localBitmap);
        break label164;
        switch (localap.pTV)
        {
        }
        for (;;)
        {
          switch (localap.osD)
          {
          default: 
            break;
          case 0: 
          case 2: 
            paramViewGroup.lPf.setVisibility(0);
            paramViewGroup.njj.setVisibility(4);
            break;
            if (localap.osD == 2)
            {
              paramViewGroup.pRa.setClickable(false);
              paramViewGroup.pRa.setBackgroundDrawable(null);
              paramViewGroup.lPf.setText(a.g.friend_invited);
              paramViewGroup.lPf.setTextColor(this.lzt.getResources().getColor(com.tencent.mm.plugin.account.friend.a.a.lightgrey));
            }
            else
            {
              paramViewGroup.pRa.setClickable(true);
              paramViewGroup.pRa.setBackgroundResource(a.b.btn_solid_green);
              paramViewGroup.lPf.setText(a.g.friend_invite);
              paramViewGroup.lPf.setTextColor(this.lzt.getResources().getColor(com.tencent.mm.plugin.account.friend.a.a.white_text_color));
              continue;
              if ((((n)h.ax(n.class)).bzA().bxr(localap.getUsername())) || (z.bAM().equals(localap.getUsername())))
              {
                paramViewGroup.pRa.setClickable(false);
                paramViewGroup.pRa.setBackgroundDrawable(null);
                paramViewGroup.lPf.setText(a.g.friend_added);
                paramViewGroup.lPf.setTextColor(this.lzt.getResources().getColor(com.tencent.mm.plugin.account.friend.a.a.lightgrey));
              }
              else if (localap.osD == 2)
              {
                paramViewGroup.pRa.setClickable(false);
                paramViewGroup.pRa.setBackgroundDrawable(null);
                paramViewGroup.lPf.setText(a.g.friend_waiting_ask);
                paramViewGroup.lPf.setTextColor(this.lzt.getResources().getColor(com.tencent.mm.plugin.account.friend.a.a.lightgrey));
              }
              else
              {
                paramViewGroup.pRa.setClickable(true);
                paramViewGroup.pRa.setBackgroundResource(a.b.btn_solid_green);
                paramViewGroup.lPf.setText(a.g.friend_add);
                paramViewGroup.lPf.setTextColor(this.lzt.getResources().getColor(com.tencent.mm.plugin.account.friend.a.a.white_text_color));
              }
            }
            break;
          }
        }
        paramViewGroup.lPf.setVisibility(4);
        paramViewGroup.njj.setVisibility(0);
      }
    }
  }
  
  static abstract interface a
  {
    public abstract void f(int paramInt1, String paramString, int paramInt2);
  }
  
  final class b
  {
    ImageView lKK;
    TextView lPf;
    ProgressBar njj;
    int pQY;
    TextView pQZ;
    View pRa;
    String pVo;
    int status;
    
    public b(View paramView)
    {
      AppMethodBeat.i(131255);
      this.lKK = ((ImageView)paramView.findViewById(a.c.contactitem_avatar_iv));
      this.pQZ = ((TextView)paramView.findViewById(a.c.qq_friend_name));
      this.pRa = paramView.findViewById(a.c.qq_friend_action_view);
      this.lPf = ((TextView)paramView.findViewById(a.c.qq_friend_status_tv));
      this.njj = ((ProgressBar)paramView.findViewById(a.c.qq_friend_status_pb));
      this.pRa.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(131254);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/friend/ui/QQFriendAdapterCaseA$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (e.b(e.this) != null) {
            e.b(e.this).f(e.b.this.pQY, e.b.this.pVo, e.b.this.status);
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