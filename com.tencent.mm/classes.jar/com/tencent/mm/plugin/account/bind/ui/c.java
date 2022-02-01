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
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.pluginsdk.ui.applet.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.e.d;
import com.tencent.mm.ui.s.a;
import java.util.LinkedList;

public final class c
  extends b
{
  private String kcL;
  private b.a kcM;
  private b.b kcN;
  private int[] pt;
  
  public c(Context paramContext, s.a parama)
  {
    super(paramContext, new com.tencent.mm.plugin.account.friend.a.a());
    AppMethodBeat.i(110126);
    this.kcN = new b.b()
    {
      public final void e(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        AppMethodBeat.i(110123);
        Log.d("MicroMsg.MobileFriendAdapter", "[cpan] postion:%d md5:%s status:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString, Integer.valueOf(paramAnonymousInt2) });
        final com.tencent.mm.plugin.account.friend.a.a locala = (com.tencent.mm.plugin.account.friend.a.a)c.this.getItem(paramAnonymousInt1);
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
            public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
            {
              AppMethodBeat.i(110120);
              Log.i("MicroMsg.MobileFriendAdapter", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2), paramAnonymous2String1, paramAnonymous2String2 });
              com.tencent.mm.plugin.account.friend.a.a locala = ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).SU(paramAnonymous2String2);
              if (locala != null)
              {
                if (paramAnonymous2Boolean1)
                {
                  locala.username = paramAnonymous2String1;
                  locala.status = 2;
                  locala.iKU = 2;
                  Log.d("MicroMsg.MobileFriendAdapter", "f :%s", new Object[] { locala.toString() });
                  ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).a(paramAnonymous2String2, locala);
                  c.this.anp();
                  cf.aWl().f(26, new Object[0]);
                  AppMethodBeat.o(110120);
                }
              }
              else {
                Log.w("MicroMsg.MobileFriendAdapter", "cpan qq friend is null. qq:%s", new Object[] { paramAnonymous2String2 });
              }
              AppMethodBeat.o(110120);
            }
          });
          paramAnonymousString.Kea = new a.b()
          {
            public final boolean aE(String paramAnonymous2String, int paramAnonymous2Int)
            {
              AppMethodBeat.i(110121);
              Intent localIntent = new Intent();
              localIntent.putExtra("Contact_User", locala.getUsername());
              localIntent.putExtra("Contact_Nick", locala.getNickName());
              localIntent.putExtra("Contact_Scene", 13);
              localIntent.putExtra("sayhi_with_sns_perm_send_verify", true);
              localIntent.putExtra("sayhi_with_sns_perm_add_remark", true);
              localIntent.putExtra("sayhi_with_jump_to_profile", true);
              localIntent.putExtra(e.d.OyT, paramAnonymous2String);
              localIntent.putExtra("sayhi_verify_add_errcode", paramAnonymous2Int);
              paramAnonymous2Int = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.slQ, 2);
              int i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.slT, 1000);
              String str = ".ui.SayHiWithSnsPermissionUI";
              if ((!as.bjp(locala.getUsername())) && (paramAnonymous2Int == 1)) {
                paramAnonymous2String = ".ui.SayHiWithSnsPermissionUI2";
              }
              for (;;)
              {
                com.tencent.mm.br.c.b(c.b(c.this), "profile", paramAnonymous2String, localIntent, 1);
                AppMethodBeat.o(110121);
                return true;
                paramAnonymous2String = str;
                if (!as.bjp(locala.getUsername()))
                {
                  paramAnonymous2String = str;
                  if (paramAnonymous2Int == 2)
                  {
                    paramAnonymous2String = str;
                    if (ab.aVc() >= i) {
                      paramAnonymous2String = ".ui.SayHiWithSnsPermissionUI3";
                    }
                  }
                }
              }
            }
          };
          if ((c.c(c.this) instanceof MobileFriendUI)) {
            ((MobileFriendUI)c.e(c.this)).mmSetOnActivityResultCallback(new MMActivity.a()
            {
              public final void d(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
              {
                AppMethodBeat.i(110122);
                if ((paramAnonymous2Int1 == 1) && (paramAnonymous2Int2 == -1)) {
                  ((MobileFriendUI)c.d(c.this)).b(locala);
                }
                AppMethodBeat.o(110122);
              }
            });
          }
          paramAnonymousString.khI = locala.getMd5();
          paramAnonymousString.Kee = false;
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
    this.kcL = Util.escapeSqlValue(paramString.trim());
    ebf();
    anp();
    AppMethodBeat.o(110127);
  }
  
  public final void a(b.a parama)
  {
    this.kcM = parama;
  }
  
  public final void anp()
  {
    AppMethodBeat.i(110129);
    ebf();
    setCursor(((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).SS(this.kcL));
    this.pt = new int[getCount()];
    if ((this.kcM != null) && (this.kcL != null)) {
      this.kcM.ve(getCursor().getCount());
    }
    notifyDataSetChanged();
    AppMethodBeat.o(110129);
  }
  
  public final void anq()
  {
    AppMethodBeat.i(110128);
    anp();
    AppMethodBeat.o(110128);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(110130);
    com.tencent.mm.plugin.account.friend.a.a locala = (com.tencent.mm.plugin.account.friend.a.a)getItem(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.context, 2131495662, null);
      paramViewGroup = new a(paramView);
      paramViewGroup.kcS = ((TextView)paramView.findViewById(2131304752));
      paramView.setTag(paramViewGroup);
      paramViewGroup.kcR = paramInt;
      paramViewGroup.md5 = locala.getMd5();
      paramViewGroup.status = locala.status;
      paramViewGroup.kcS.setText(locala.bnK());
      switch (locala.status)
      {
      default: 
        label124:
        switch (locala.iKU)
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
      if (locala.iKU == 2)
      {
        paramViewGroup.kcT.setClickable(false);
        paramViewGroup.kcT.setBackgroundDrawable(null);
        paramViewGroup.gCd.setText(2131760985);
        paramViewGroup.gCd.setTextColor(this.context.getResources().getColor(2131100682));
        break label124;
      }
      paramViewGroup.kcT.setClickable(true);
      paramViewGroup.kcT.setBackgroundResource(2131231429);
      paramViewGroup.gCd.setText(2131760984);
      paramViewGroup.gCd.setTextColor(this.context.getResources().getColor(2131101424));
      break label124;
      Log.d("MicroMsg.MobileFriendAdapter", "username:%s", new Object[] { locala.getUsername() });
      if ((((l)g.af(l.class)).aSN().bjG(locala.getUsername())) || (z.aTY().equals(locala.getUsername())))
      {
        paramViewGroup.kcT.setClickable(false);
        paramViewGroup.kcT.setBackgroundDrawable(null);
        paramViewGroup.gCd.setText(2131760983);
        paramViewGroup.gCd.setTextColor(this.context.getResources().getColor(2131100682));
        break label124;
      }
      if (locala.iKU == 2)
      {
        paramViewGroup.kcT.setClickable(false);
        paramViewGroup.kcT.setBackgroundDrawable(null);
        paramViewGroup.gCd.setText(2131760988);
        paramViewGroup.gCd.setTextColor(this.context.getResources().getColor(2131100682));
        break label124;
      }
      paramViewGroup.kcT.setClickable(true);
      paramViewGroup.kcT.setBackgroundResource(2131231429);
      paramViewGroup.gCd.setText(2131760982);
      paramViewGroup.gCd.setTextColor(this.context.getResources().getColor(2131101424));
      break label124;
      paramViewGroup.gCd.setVisibility(4);
      paramViewGroup.hRO.setVisibility(0);
      continue;
      paramViewGroup.gCd.setVisibility(0);
      paramViewGroup.hRO.setVisibility(4);
    }
  }
  
  final class a
  {
    TextView gCd;
    ProgressBar hRO;
    int kcR;
    TextView kcS;
    View kcT;
    String md5;
    int status;
    
    public a(View paramView)
    {
      AppMethodBeat.i(110125);
      this.kcS = ((TextView)paramView.findViewById(2131304752));
      this.kcT = paramView.findViewById(2131304744);
      this.gCd = ((TextView)paramView.findViewById(2131304755));
      this.hRO = ((ProgressBar)paramView.findViewById(2131304754));
      this.kcT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(110124);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/MobileFriendAdapterCaseA$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (c.f(c.this) != null) {
            c.f(c.this).e(c.a.this.kcR, c.a.this.md5, c.a.this.status);
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