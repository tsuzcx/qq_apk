package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.bind.a.d;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.f.e;
import com.tencent.mm.ui.x.a;
import java.util.LinkedList;

public final class d
  extends b
{
  private int[] duY;
  private String pQS;
  private b.a pQT;
  private b.b pQU;
  
  public d(Context paramContext, x.a parama)
  {
    super(paramContext, new com.tencent.mm.plugin.account.friend.model.a());
    AppMethodBeat.i(110138);
    this.pQU = new b.b()
    {
      public final void e(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        AppMethodBeat.i(110135);
        Log.i("MicroMsg.MobileFriendAdapter", "[cpan] postion:%d md5:%s status:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString, Integer.valueOf(paramAnonymousInt2) });
        final com.tencent.mm.plugin.account.friend.model.a locala = (com.tencent.mm.plugin.account.friend.model.a)d.this.getItem(paramAnonymousInt1);
        if (locala == null)
        {
          Log.e("MicroMsg.MobileFriendAdapter", "[cpan] mobile Friend is null. mobile:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(110135);
          return;
        }
        Log.d("MicroMsg.MobileFriendAdapter", "mobile friend:%s", new Object[] { locala.toString() });
        if (locala.status == 1)
        {
          paramAnonymousString = new com.tencent.mm.pluginsdk.ui.applet.a(d.a(d.this), new a.a()
          {
            public final void canAddContact(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
            {
              AppMethodBeat.i(110132);
              Log.i("MicroMsg.MobileFriendAdapter", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2), paramAnonymous2String1, paramAnonymous2String2 });
              com.tencent.mm.plugin.account.friend.model.a locala = ((com.tencent.mm.plugin.account.friend.model.b)((com.tencent.mm.plugin.account.sdk.a.a)h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getAddrUploadStg()).SU(paramAnonymous2String2);
              if (locala != null)
              {
                if (paramAnonymous2Boolean1)
                {
                  locala.username = paramAnonymous2String1;
                  locala.status = 2;
                  locala.osD = 2;
                  Log.d("MicroMsg.MobileFriendAdapter", "f :%s", new Object[] { locala.toString() });
                  ((com.tencent.mm.plugin.account.friend.model.b)((com.tencent.mm.plugin.account.sdk.a.a)h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getAddrUploadStg()).a(paramAnonymous2String2, locala);
                  d.this.aNy();
                  ch.bDg().f(26, new Object[0]);
                  AppMethodBeat.o(110132);
                }
              }
              else {
                Log.w("MicroMsg.MobileFriendAdapter", "cpan mobile friend is null. qq:%s", new Object[] { paramAnonymous2String2 });
              }
              AppMethodBeat.o(110132);
            }
          });
          paramAnonymousString.YaM = new com.tencent.mm.pluginsdk.ui.applet.a.b()
          {
            public final boolean n(String paramAnonymous2String1, int paramAnonymous2Int, String paramAnonymous2String2)
            {
              AppMethodBeat.i(304873);
              Intent localIntent = new Intent();
              localIntent.putExtra("Contact_User", locala.getUsername());
              localIntent.putExtra("Contact_Nick", locala.getNickName());
              localIntent.putExtra("Contact_Scene", 13);
              localIntent.putExtra("sayhi_with_sns_perm_send_verify", true);
              localIntent.putExtra("sayhi_with_sns_perm_add_remark", true);
              localIntent.putExtra("sayhi_with_jump_to_profile", true);
              localIntent.putExtra(f.e.adwe, paramAnonymous2String1);
              localIntent.putExtra("sayhi_verify_add_errcode", paramAnonymous2Int);
              paramAnonymous2Int = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpi, 2);
              int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpl, 5000);
              paramAnonymous2String2 = ".ui.SayHiWithSnsPermissionUI";
              if ((!au.bwO(locala.getUsername())) && (paramAnonymous2Int == 1)) {
                paramAnonymous2String1 = ".ui.SayHiWithSnsPermissionUI2";
              }
              for (;;)
              {
                com.tencent.mm.br.c.b(d.b(d.this), "profile", paramAnonymous2String1, localIntent, 1);
                AppMethodBeat.o(304873);
                return true;
                paramAnonymous2String1 = paramAnonymous2String2;
                if (!au.bwO(locala.getUsername()))
                {
                  paramAnonymous2String1 = paramAnonymous2String2;
                  if (paramAnonymous2Int == 2)
                  {
                    paramAnonymous2String1 = paramAnonymous2String2;
                    if (ab.bBW() >= i) {
                      paramAnonymous2String1 = ".ui.SayHiWithSnsPermissionUI3";
                    }
                  }
                }
              }
            }
          };
          if ((d.c(d.this) instanceof MobileFriendUI)) {
            ((MobileFriendUI)d.e(d.this)).mmSetOnActivityResultCallback(new MMActivity.a()
            {
              public final void mmOnActivityResult(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
              {
                AppMethodBeat.i(110134);
                if ((paramAnonymous2Int1 == 1) && (paramAnonymous2Int2 == -1)) {
                  ((MobileFriendUI)d.d(d.this)).b(locala);
                }
                AppMethodBeat.o(110134);
              }
            });
          }
          paramAnonymousString.pVP = locala.getMd5();
          paramAnonymousString.hks = false;
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(Integer.valueOf(13));
          paramAnonymousString.b(locala.getUsername(), localLinkedList, false);
        }
        AppMethodBeat.o(110135);
      }
    };
    super.a(parama);
    this.context = paramContext;
    Lh(true);
    AppMethodBeat.o(110138);
  }
  
  private static String a(com.tencent.mm.plugin.account.friend.model.a parama)
  {
    AppMethodBeat.i(110143);
    if (parama.pSd == 123)
    {
      AppMethodBeat.o(110143);
      return "#";
    }
    char c = (char)parama.pSd;
    AppMethodBeat.o(110143);
    return String.valueOf(c);
  }
  
  public final void SM(String paramString)
  {
    AppMethodBeat.i(110139);
    this.pQS = Util.escapeSqlValue(paramString.trim());
    fSd();
    aNy();
    AppMethodBeat.o(110139);
  }
  
  public final void a(b.a parama)
  {
    this.pQT = parama;
  }
  
  public final void aNy()
  {
    AppMethodBeat.i(110141);
    fSd();
    w(((com.tencent.mm.plugin.account.friend.model.b)((com.tencent.mm.plugin.account.sdk.a.a)h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getAddrUploadStg()).ST(this.pQS));
    this.duY = new int[getCount()];
    if ((this.pQT != null) && (this.pQS != null)) {
      this.pQT.yo(Fv().getCount());
    }
    notifyDataSetChanged();
    AppMethodBeat.o(110141);
  }
  
  public final void aNz()
  {
    AppMethodBeat.i(110140);
    aNy();
    AppMethodBeat.o(110140);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(110142);
    com.tencent.mm.plugin.account.friend.model.a locala = (com.tencent.mm.plugin.account.friend.model.a)getItem(paramInt);
    label164:
    label196:
    Object localObject;
    int i;
    if (paramView == null)
    {
      paramView = View.inflate(this.context, a.f.friend_list_item, null);
      paramViewGroup = new a(paramView);
      paramView.setTag(paramViewGroup);
      paramViewGroup.pQY = paramInt;
      paramViewGroup.account = locala.getMd5();
      paramViewGroup.status = locala.status;
      paramViewGroup.pRg.setText(locala.bWI());
      paramViewGroup.pRh.setText(this.context.getString(a.i.friend_weixin) + locala.getNickName());
      com.tencent.mm.pluginsdk.ui.a.b.g(paramViewGroup.lKK, locala.getUsername());
      switch (locala.status)
      {
      default: 
        switch (locala.osD)
        {
        default: 
          localObject = (com.tencent.mm.plugin.account.friend.model.a)getItem(paramInt - 1);
          if (localObject == null)
          {
            i = -1;
            label216:
            if (paramInt != 0) {
              break label677;
            }
            localObject = a(locala);
            if (!Util.isNullOrNil((String)localObject)) {
              break label646;
            }
            Log.w("MicroMsg.MobileFriendAdapter", "get display show head return null, user[%s] pos[%d]", new Object[] { locala.getUsername(), Integer.valueOf(paramInt) });
            paramViewGroup.pRf.setVisibility(8);
          }
          break;
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(110142);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      if (locala.osD == 2)
      {
        paramViewGroup.pRa.setClickable(false);
        paramViewGroup.pRa.setBackgroundDrawable(null);
        paramViewGroup.lPf.setText(a.i.friend_invited);
        paramViewGroup.lPf.setTextColor(this.context.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.lightgrey));
        break label164;
      }
      paramViewGroup.pRa.setClickable(true);
      paramViewGroup.pRa.setBackgroundResource(a.d.btn_solid_green);
      paramViewGroup.lPf.setText(a.i.friend_invite);
      paramViewGroup.lPf.setTextColor(this.context.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.white_text_color));
      break label164;
      if ((((n)h.ax(n.class)).bzA().bxr(locala.getUsername())) || (z.bAM().equals(locala.getUsername())))
      {
        paramViewGroup.pRa.setClickable(false);
        paramViewGroup.pRa.setBackgroundDrawable(null);
        paramViewGroup.lPf.setText(a.i.friend_added);
        paramViewGroup.lPf.setTextColor(this.context.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.lightgrey));
        break label164;
      }
      if (locala.osD == 2)
      {
        paramViewGroup.pRa.setClickable(false);
        paramViewGroup.pRa.setBackgroundDrawable(null);
        paramViewGroup.lPf.setText(a.i.friend_waiting_ask);
        paramViewGroup.lPf.setTextColor(this.context.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.lightgrey));
        break label164;
      }
      paramViewGroup.pRa.setClickable(true);
      paramViewGroup.pRa.setBackgroundResource(a.d.btn_solid_green);
      paramViewGroup.lPf.setText(a.i.friend_add);
      paramViewGroup.lPf.setTextColor(this.context.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.white_text_color));
      break label164;
      paramViewGroup.lPf.setVisibility(4);
      paramViewGroup.pRi.setVisibility(0);
      break label196;
      paramViewGroup.lPf.setVisibility(0);
      paramViewGroup.pRi.setVisibility(4);
      break label196;
      i = ((com.tencent.mm.plugin.account.friend.model.a)localObject).pSd;
      break label216;
      label646:
      paramViewGroup.pRf.setVisibility(0);
      paramViewGroup.pRf.setText((CharSequence)localObject);
      paramViewGroup.pRf.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      continue;
      label677:
      if (locala.pSd != i) {}
      for (i = 1;; i = 0)
      {
        localObject = a(locala);
        if ((!Util.isNullOrNil((String)localObject)) && (i != 0)) {
          break label756;
        }
        Log.w("MicroMsg.MobileFriendAdapter", "get display show head return null, user[%s] pos[%d]", new Object[] { locala.getUsername(), Integer.valueOf(paramInt) });
        paramViewGroup.pRf.setVisibility(8);
        break;
      }
      label756:
      paramViewGroup.pRf.setVisibility(0);
      paramViewGroup.pRf.setText((CharSequence)localObject);
      paramViewGroup.pRf.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
  }
  
  final class a
  {
    String account;
    ImageView lKK;
    TextView lPf;
    int pQY;
    View pRa;
    TextView pRf;
    TextView pRg;
    TextView pRh;
    ProgressBar pRi;
    int status;
    
    public a(View paramView)
    {
      AppMethodBeat.i(110137);
      this.pRf = ((TextView)paramView.findViewById(a.e.friend_item_catalog));
      this.lKK = ((ImageView)paramView.findViewById(a.e.friend_item_avatar_iv));
      this.pRg = ((TextView)paramView.findViewById(a.e.friend_item_nickname));
      this.pRh = ((TextView)paramView.findViewById(a.e.friend_item_wx_nickname));
      this.pRa = paramView.findViewById(a.e.friend_item_action_view);
      this.lPf = ((TextView)paramView.findViewById(a.e.friend_item_status_tv));
      this.pRi = ((ProgressBar)paramView.findViewById(a.e.friend_item_status_pb));
      this.pRa.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(110136);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/MobileFriendAdapterCaseB$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (d.f(d.this) != null) {
            d.f(d.this).e(d.a.this.pQY, d.a.this.account, d.a.this.status);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/MobileFriendAdapterCaseB$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(110136);
        }
      });
      AppMethodBeat.o(110137);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.d
 * JD-Core Version:    0.7.0.1
 */