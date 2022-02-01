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
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.pluginsdk.ui.applet.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.e.c;
import com.tencent.mm.ui.r.a;
import java.util.LinkedList;

public final class c
  extends b
{
  private String jeI;
  private b.a jeJ;
  private b.b jeK;
  private int[] pq;
  
  public c(Context paramContext, r.a parama)
  {
    super(paramContext, new com.tencent.mm.plugin.account.friend.a.a());
    AppMethodBeat.i(110126);
    this.jeK = new b.b()
    {
      public final void e(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        AppMethodBeat.i(110123);
        ae.d("MicroMsg.MobileFriendAdapter", "[cpan] postion:%d md5:%s status:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString, Integer.valueOf(paramAnonymousInt2) });
        final com.tencent.mm.plugin.account.friend.a.a locala = (com.tencent.mm.plugin.account.friend.a.a)c.this.getItem(paramAnonymousInt1);
        if (locala == null)
        {
          ae.e("MicroMsg.MobileFriendAdapter", "[cpan] mobile Friend is null. mobile:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(110123);
          return;
        }
        ae.d("MicroMsg.MobileFriendAdapter", "mobile friend:%s", new Object[] { locala.toString() });
        if (locala.status == 1)
        {
          paramAnonymousString = new com.tencent.mm.pluginsdk.ui.applet.a(c.a(c.this), new a.a()
          {
            public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
            {
              AppMethodBeat.i(110120);
              ae.i("MicroMsg.MobileFriendAdapter", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2), paramAnonymous2String1, paramAnonymous2String2 });
              com.tencent.mm.plugin.account.friend.a.a locala = ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).JW(paramAnonymous2String2);
              if (locala != null)
              {
                if (paramAnonymous2Boolean1)
                {
                  locala.username = paramAnonymous2String1;
                  locala.status = 2;
                  locala.hPN = 2;
                  ae.d("MicroMsg.MobileFriendAdapter", "f :%s", new Object[] { locala.toString() });
                  ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).a(paramAnonymous2String2, locala);
                  c.this.ZD();
                  cb.aCN().d(26, new Object[0]);
                  AppMethodBeat.o(110120);
                }
              }
              else {
                ae.w("MicroMsg.MobileFriendAdapter", "cpan qq friend is null. qq:%s", new Object[] { paramAnonymous2String2 });
              }
              AppMethodBeat.o(110120);
            }
          });
          paramAnonymousString.Fni = new a.b()
          {
            public final boolean aA(String paramAnonymous2String, int paramAnonymous2Int)
            {
              AppMethodBeat.i(110121);
              Intent localIntent = new Intent();
              localIntent.putExtra("Contact_User", locala.getUsername());
              localIntent.putExtra("Contact_Nick", locala.getNickName());
              localIntent.putExtra("Contact_Scene", 13);
              localIntent.putExtra("sayhi_with_sns_perm_send_verify", true);
              localIntent.putExtra("sayhi_with_sns_perm_add_remark", true);
              localIntent.putExtra("sayhi_with_jump_to_profile", true);
              localIntent.putExtra(e.c.JoX, paramAnonymous2String);
              localIntent.putExtra("sayhi_verify_add_errcode", paramAnonymous2Int);
              paramAnonymous2Int = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qOK, 0);
              String str = ".ui.SayHiWithSnsPermissionUI";
              if ((!an.aUq(locala.getUsername())) && (paramAnonymous2Int == 1)) {
                paramAnonymous2String = ".ui.SayHiWithSnsPermissionUI2";
              }
              for (;;)
              {
                d.b(c.b(c.this), "profile", paramAnonymous2String, localIntent, 1);
                AppMethodBeat.o(110121);
                return true;
                paramAnonymous2String = str;
                if (!an.aUq(locala.getUsername()))
                {
                  paramAnonymous2String = str;
                  if (paramAnonymous2Int == 2) {
                    paramAnonymous2String = ".ui.SayHiWithSnsPermissionUI3";
                  }
                }
              }
            }
          };
          if ((c.c(c.this) instanceof MobileFriendUI)) {
            ((MobileFriendUI)c.e(c.this)).mmSetOnActivityResultCallback(new MMActivity.a()
            {
              public final void c(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
              {
                AppMethodBeat.i(110122);
                if ((paramAnonymous2Int1 == 1) && (paramAnonymous2Int2 == -1)) {
                  ((MobileFriendUI)c.d(c.this)).b(locala);
                }
                AppMethodBeat.o(110122);
              }
            });
          }
          paramAnonymousString.jjG = locala.Lj();
          paramAnonymousString.Fno = false;
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
  
  public final void JN(String paramString)
  {
    AppMethodBeat.i(110127);
    this.jeI = bu.aSk(paramString.trim());
    dhl();
    ZD();
    AppMethodBeat.o(110127);
  }
  
  public final void ZD()
  {
    AppMethodBeat.i(110129);
    dhl();
    setCursor(((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).JU(this.jeI));
    this.pq = new int[getCount()];
    if ((this.jeJ != null) && (this.jeI != null)) {
      this.jeJ.ro(getCursor().getCount());
    }
    notifyDataSetChanged();
    AppMethodBeat.o(110129);
  }
  
  public final void ZE()
  {
    AppMethodBeat.i(110128);
    ZD();
    AppMethodBeat.o(110128);
  }
  
  public final void a(b.a parama)
  {
    this.jeJ = parama;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(110130);
    com.tencent.mm.plugin.account.friend.a.a locala = (com.tencent.mm.plugin.account.friend.a.a)getItem(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.context, 2131494922, null);
      paramViewGroup = new a(paramView);
      paramViewGroup.jeP = ((TextView)paramView.findViewById(2131302355));
      paramView.setTag(paramViewGroup);
      paramViewGroup.jeO = paramInt;
      paramViewGroup.md5 = locala.Lj();
      paramViewGroup.status = locala.status;
      paramViewGroup.jeP.setText(locala.aSX());
      switch (locala.status)
      {
      default: 
        label124:
        switch (locala.hPN)
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
      if (locala.hPN == 2)
      {
        paramViewGroup.jeQ.setClickable(false);
        paramViewGroup.jeQ.setBackgroundDrawable(null);
        paramViewGroup.fWX.setText(2131759664);
        paramViewGroup.fWX.setTextColor(this.context.getResources().getColor(2131100544));
        break label124;
      }
      paramViewGroup.jeQ.setClickable(true);
      paramViewGroup.jeQ.setBackgroundResource(2131231365);
      paramViewGroup.fWX.setText(2131759663);
      paramViewGroup.fWX.setTextColor(this.context.getResources().getColor(2131101179));
      break label124;
      ae.d("MicroMsg.MobileFriendAdapter", "username:%s", new Object[] { locala.getUsername() });
      if ((((l)g.ab(l.class)).azF().aUH(locala.getUsername())) || (v.aAC().equals(locala.getUsername())))
      {
        paramViewGroup.jeQ.setClickable(false);
        paramViewGroup.jeQ.setBackgroundDrawable(null);
        paramViewGroup.fWX.setText(2131759662);
        paramViewGroup.fWX.setTextColor(this.context.getResources().getColor(2131100544));
        break label124;
      }
      if (locala.hPN == 2)
      {
        paramViewGroup.jeQ.setClickable(false);
        paramViewGroup.jeQ.setBackgroundDrawable(null);
        paramViewGroup.fWX.setText(2131759667);
        paramViewGroup.fWX.setTextColor(this.context.getResources().getColor(2131100544));
        break label124;
      }
      paramViewGroup.jeQ.setClickable(true);
      paramViewGroup.jeQ.setBackgroundResource(2131231365);
      paramViewGroup.fWX.setText(2131759661);
      paramViewGroup.fWX.setTextColor(this.context.getResources().getColor(2131101179));
      break label124;
      paramViewGroup.fWX.setVisibility(4);
      paramViewGroup.gYT.setVisibility(0);
      continue;
      paramViewGroup.fWX.setVisibility(0);
      paramViewGroup.gYT.setVisibility(4);
    }
  }
  
  final class a
  {
    TextView fWX;
    ProgressBar gYT;
    int jeO;
    TextView jeP;
    View jeQ;
    String md5;
    int status;
    
    public a(View paramView)
    {
      AppMethodBeat.i(110125);
      this.jeP = ((TextView)paramView.findViewById(2131302355));
      this.jeQ = paramView.findViewById(2131302347);
      this.fWX = ((TextView)paramView.findViewById(2131302358));
      this.gYT = ((ProgressBar)paramView.findViewById(2131302357));
      this.jeQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(110124);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/MobileFriendAdapterCaseA$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (c.f(c.this) != null) {
            c.f(c.this).e(c.a.this.jeO, c.a.this.md5, c.a.this.status);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/MobileFriendAdapterCaseA$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(110124);
        }
      });
      AppMethodBeat.o(110125);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.c
 * JD-Core Version:    0.7.0.1
 */