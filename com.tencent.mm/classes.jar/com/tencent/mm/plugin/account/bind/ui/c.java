package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
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

public final class c
  extends b
{
  private int[] duY;
  private String pQS;
  private b.a pQT;
  private b.b pQU;
  
  public c(Context paramContext, x.a parama)
  {
    super(paramContext, new com.tencent.mm.plugin.account.friend.model.a());
    AppMethodBeat.i(110126);
    this.pQU = new b.b()
    {
      public final void e(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        AppMethodBeat.i(110123);
        Log.d("MicroMsg.MobileFriendAdapter", "[cpan] postion:%d md5:%s status:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString, Integer.valueOf(paramAnonymousInt2) });
        final com.tencent.mm.plugin.account.friend.model.a locala = (com.tencent.mm.plugin.account.friend.model.a)c.this.getItem(paramAnonymousInt1);
        if (locala == null)
        {
          Log.e("MicroMsg.MobileFriendAdapter", "[cpan] mobile Friend is null. mobile:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(110123);
          return;
        }
        Log.d("MicroMsg.MobileFriendAdapter", "mobile friend:%s", new Object[] { locala.toString() });
        if (locala.status == 1)
        {
          paramAnonymousString = new com.tencent.mm.pluginsdk.ui.applet.a(c.a(c.this), new a.a()
          {
            public final void canAddContact(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
            {
              AppMethodBeat.i(110120);
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
                  c.this.aNy();
                  ch.bDg().f(26, new Object[0]);
                  AppMethodBeat.o(110120);
                }
              }
              else {
                Log.w("MicroMsg.MobileFriendAdapter", "cpan qq friend is null. qq:%s", new Object[] { paramAnonymous2String2 });
              }
              AppMethodBeat.o(110120);
            }
          });
          paramAnonymousString.YaM = new com.tencent.mm.pluginsdk.ui.applet.a.b()
          {
            public final boolean n(String paramAnonymous2String1, int paramAnonymous2Int, String paramAnonymous2String2)
            {
              AppMethodBeat.i(304886);
              Intent localIntent = new Intent();
              localIntent.putExtra("Contact_User", locala.getUsername());
              localIntent.putExtra("Contact_Nick", locala.getNickName());
              localIntent.putExtra("Contact_Scene", 13);
              localIntent.putExtra("sayhi_with_sns_perm_send_verify", true);
              localIntent.putExtra("sayhi_with_sns_perm_add_remark", true);
              localIntent.putExtra("sayhi_with_jump_to_profile", true);
              localIntent.putExtra(f.e.adwe, paramAnonymous2String1);
              localIntent.putExtra("sayhi_verify_add_errcode", paramAnonymous2Int);
              paramAnonymous2Int = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zpi, 2);
              int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zpl, 5000);
              paramAnonymous2String2 = ".ui.SayHiWithSnsPermissionUI";
              if ((!au.bwO(locala.getUsername())) && (paramAnonymous2Int == 1)) {
                paramAnonymous2String1 = ".ui.SayHiWithSnsPermissionUI2";
              }
              for (;;)
              {
                com.tencent.mm.br.c.b(c.b(c.this), "profile", paramAnonymous2String1, localIntent, 1);
                AppMethodBeat.o(304886);
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
          if ((c.c(c.this) instanceof MobileFriendUI)) {
            ((MobileFriendUI)c.e(c.this)).mmSetOnActivityResultCallback(new MMActivity.a()
            {
              public final void mmOnActivityResult(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
              {
                AppMethodBeat.i(110122);
                if ((paramAnonymous2Int1 == 1) && (paramAnonymous2Int2 == -1)) {
                  ((MobileFriendUI)c.d(c.this)).b(locala);
                }
                AppMethodBeat.o(110122);
              }
            });
          }
          paramAnonymousString.pVP = locala.getMd5();
          paramAnonymousString.hks = false;
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(Integer.valueOf(13));
          paramAnonymousString.b(locala.getUsername(), localLinkedList, false);
        }
        AppMethodBeat.o(110123);
      }
    };
    super.a(parama);
    this.context = paramContext;
    AppMethodBeat.o(110126);
  }
  
  public final void SM(String paramString)
  {
    AppMethodBeat.i(110127);
    this.pQS = Util.escapeSqlValue(paramString.trim());
    fSd();
    aNy();
    AppMethodBeat.o(110127);
  }
  
  public final void a(b.a parama)
  {
    this.pQT = parama;
  }
  
  public final void aNy()
  {
    AppMethodBeat.i(110129);
    fSd();
    w(((com.tencent.mm.plugin.account.friend.model.b)((com.tencent.mm.plugin.account.sdk.a.a)h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getAddrUploadStg()).SS(this.pQS));
    this.duY = new int[getCount()];
    if ((this.pQT != null) && (this.pQS != null)) {
      this.pQT.yo(Fv().getCount());
    }
    notifyDataSetChanged();
    AppMethodBeat.o(110129);
  }
  
  public final void aNz()
  {
    AppMethodBeat.i(110128);
    aNy();
    AppMethodBeat.o(110128);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(110130);
    com.tencent.mm.plugin.account.friend.model.a locala = (com.tencent.mm.plugin.account.friend.model.a)getItem(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.context, a.f.mobile_friend_item, null);
      paramViewGroup = new a(paramView);
      paramViewGroup.pQZ = ((TextView)paramView.findViewById(a.e.mobile_friend_name));
      paramView.setTag(paramViewGroup);
      paramViewGroup.pQY = paramInt;
      paramViewGroup.md5 = locala.getMd5();
      paramViewGroup.status = locala.status;
      paramViewGroup.pQZ.setText(locala.bWI());
      switch (locala.status)
      {
      default: 
        label128:
        switch (locala.osD)
        {
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(110130);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      if (locala.osD == 2)
      {
        paramViewGroup.pRa.setClickable(false);
        paramViewGroup.pRa.setBackgroundDrawable(null);
        paramViewGroup.lPf.setText(a.i.friend_invited);
        paramViewGroup.lPf.setTextColor(this.context.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.lightgrey));
        break label128;
      }
      paramViewGroup.pRa.setClickable(true);
      paramViewGroup.pRa.setBackgroundResource(a.d.btn_solid_green);
      paramViewGroup.lPf.setText(a.i.friend_invite);
      paramViewGroup.lPf.setTextColor(this.context.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.white));
      break label128;
      Log.d("MicroMsg.MobileFriendAdapter", "username:%s", new Object[] { locala.getUsername() });
      if ((((n)h.ax(n.class)).bzA().bxr(locala.getUsername())) || (z.bAM().equals(locala.getUsername())))
      {
        paramViewGroup.pRa.setClickable(false);
        paramViewGroup.pRa.setBackgroundDrawable(null);
        paramViewGroup.lPf.setText(a.i.friend_added);
        paramViewGroup.lPf.setTextColor(this.context.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.lightgrey));
        break label128;
      }
      if (locala.osD == 2)
      {
        paramViewGroup.pRa.setClickable(false);
        paramViewGroup.pRa.setBackgroundDrawable(null);
        paramViewGroup.lPf.setText(a.i.friend_waiting_ask);
        paramViewGroup.lPf.setTextColor(this.context.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.lightgrey));
        break label128;
      }
      paramViewGroup.pRa.setClickable(true);
      paramViewGroup.pRa.setBackgroundResource(a.d.btn_solid_green);
      paramViewGroup.lPf.setText(a.i.friend_add);
      paramViewGroup.lPf.setTextColor(this.context.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.white));
      break label128;
      paramViewGroup.lPf.setVisibility(4);
      paramViewGroup.njj.setVisibility(0);
      continue;
      paramViewGroup.lPf.setVisibility(0);
      paramViewGroup.njj.setVisibility(4);
    }
  }
  
  final class a
  {
    TextView lPf;
    String md5;
    ProgressBar njj;
    int pQY;
    TextView pQZ;
    View pRa;
    int status;
    
    public a(View paramView)
    {
      AppMethodBeat.i(110125);
      this.pQZ = ((TextView)paramView.findViewById(a.e.mobile_friend_name));
      this.pRa = paramView.findViewById(a.e.mobile_friend_action_view);
      this.lPf = ((TextView)paramView.findViewById(a.e.mobile_friend_status_tv));
      this.njj = ((ProgressBar)paramView.findViewById(a.e.mobile_friend_status_pb));
      this.pRa.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(110124);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/MobileFriendAdapterCaseA$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (c.f(c.this) != null) {
            c.f(c.this).e(c.a.this.pQY, c.a.this.md5, c.a.this.status);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/MobileFriendAdapterCaseA$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(110124);
        }
      });
      AppMethodBeat.o(110125);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.c
 * JD-Core Version:    0.7.0.1
 */