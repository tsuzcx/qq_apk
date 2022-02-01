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
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.e.c;
import com.tencent.mm.ui.r.a;
import java.util.LinkedList;

public final class d
  extends b
{
  private String jeI;
  private b.a jeJ;
  private b.b jeK;
  private int[] pq;
  
  public d(Context paramContext, r.a parama)
  {
    super(paramContext, new com.tencent.mm.plugin.account.friend.a.a());
    AppMethodBeat.i(110138);
    this.jeK = new b.b()
    {
      public final void e(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        AppMethodBeat.i(110135);
        ae.i("MicroMsg.MobileFriendAdapter", "[cpan] postion:%d md5:%s status:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString, Integer.valueOf(paramAnonymousInt2) });
        final com.tencent.mm.plugin.account.friend.a.a locala = (com.tencent.mm.plugin.account.friend.a.a)d.this.getItem(paramAnonymousInt1);
        if (locala == null)
        {
          ae.e("MicroMsg.MobileFriendAdapter", "[cpan] mobile Friend is null. mobile:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(110135);
          return;
        }
        ae.d("MicroMsg.MobileFriendAdapter", "mobile friend:%s", new Object[] { locala.toString() });
        if (locala.status == 1)
        {
          paramAnonymousString = new com.tencent.mm.pluginsdk.ui.applet.a(d.a(d.this), new a.a()
          {
            public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
            {
              AppMethodBeat.i(110132);
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
                  d.this.ZD();
                  cb.aCN().d(26, new Object[0]);
                  AppMethodBeat.o(110132);
                }
              }
              else {
                ae.w("MicroMsg.MobileFriendAdapter", "cpan mobile friend is null. qq:%s", new Object[] { paramAnonymous2String2 });
              }
              AppMethodBeat.o(110132);
            }
          });
          paramAnonymousString.Fni = new com.tencent.mm.pluginsdk.ui.applet.a.b()
          {
            public final boolean aA(String paramAnonymous2String, int paramAnonymous2Int)
            {
              AppMethodBeat.i(110133);
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
                com.tencent.mm.br.d.b(d.b(d.this), "profile", paramAnonymous2String, localIntent, 1);
                AppMethodBeat.o(110133);
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
          if ((d.c(d.this) instanceof MobileFriendUI)) {
            ((MobileFriendUI)d.e(d.this)).mmSetOnActivityResultCallback(new MMActivity.a()
            {
              public final void c(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
              {
                AppMethodBeat.i(110134);
                if ((paramAnonymous2Int1 == 1) && (paramAnonymous2Int2 == -1)) {
                  ((MobileFriendUI)d.d(d.this)).b(locala);
                }
                AppMethodBeat.o(110134);
              }
            });
          }
          paramAnonymousString.jjG = locala.Lj();
          paramAnonymousString.Fno = false;
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(Integer.valueOf(13));
          paramAnonymousString.b(locala.getUsername(), localLinkedList, false);
        }
        AppMethodBeat.o(110135);
      }
    };
    super.a(parama);
    this.context = paramContext;
    xs(true);
    AppMethodBeat.o(110138);
  }
  
  private static String a(com.tencent.mm.plugin.account.friend.a.a parama)
  {
    AppMethodBeat.i(110143);
    if (parama.jfT == 123)
    {
      AppMethodBeat.o(110143);
      return "#";
    }
    char c = (char)parama.jfT;
    AppMethodBeat.o(110143);
    return String.valueOf(c);
  }
  
  public final void JN(String paramString)
  {
    AppMethodBeat.i(110139);
    this.jeI = bu.aSk(paramString.trim());
    dhl();
    ZD();
    AppMethodBeat.o(110139);
  }
  
  public final void ZD()
  {
    AppMethodBeat.i(110141);
    dhl();
    setCursor(((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).JV(this.jeI));
    this.pq = new int[getCount()];
    if ((this.jeJ != null) && (this.jeI != null)) {
      this.jeJ.ro(getCursor().getCount());
    }
    notifyDataSetChanged();
    AppMethodBeat.o(110141);
  }
  
  public final void ZE()
  {
    AppMethodBeat.i(110140);
    ZD();
    AppMethodBeat.o(110140);
  }
  
  public final void a(b.a parama)
  {
    this.jeJ = parama;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(110142);
    com.tencent.mm.plugin.account.friend.a.a locala = (com.tencent.mm.plugin.account.friend.a.a)getItem(paramInt);
    label160:
    label192:
    Object localObject;
    int i;
    if (paramView == null)
    {
      paramView = View.inflate(this.context, 2131494181, null);
      paramViewGroup = new a(paramView);
      paramView.setTag(paramViewGroup);
      paramViewGroup.jeO = paramInt;
      paramViewGroup.account = locala.Lj();
      paramViewGroup.status = locala.status;
      paramViewGroup.jeW.setText(locala.aSX());
      paramViewGroup.jeX.setText(this.context.getString(2131759668) + locala.getNickName());
      com.tencent.mm.pluginsdk.ui.a.b.c(paramViewGroup.fTj, locala.getUsername());
      switch (locala.status)
      {
      default: 
        switch (locala.hPN)
        {
        default: 
          localObject = (com.tencent.mm.plugin.account.friend.a.a)getItem(paramInt - 1);
          if (localObject == null)
          {
            i = -1;
            label212:
            if (paramInt != 0) {
              break label671;
            }
            localObject = a(locala);
            if (!bu.isNullOrNil((String)localObject)) {
              break label640;
            }
            ae.w("MicroMsg.MobileFriendAdapter", "get display show head return null, user[%s] pos[%d]", new Object[] { locala.getUsername(), Integer.valueOf(paramInt) });
            paramViewGroup.jeV.setVisibility(8);
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
      if (locala.hPN == 2)
      {
        paramViewGroup.jeQ.setClickable(false);
        paramViewGroup.jeQ.setBackgroundDrawable(null);
        paramViewGroup.fWX.setText(2131759664);
        paramViewGroup.fWX.setTextColor(this.context.getResources().getColor(2131100544));
        break label160;
      }
      paramViewGroup.jeQ.setClickable(true);
      paramViewGroup.jeQ.setBackgroundResource(2131231365);
      paramViewGroup.fWX.setText(2131759663);
      paramViewGroup.fWX.setTextColor(this.context.getResources().getColor(2131101182));
      break label160;
      if ((((l)g.ab(l.class)).azF().aUH(locala.getUsername())) || (v.aAC().equals(locala.getUsername())))
      {
        paramViewGroup.jeQ.setClickable(false);
        paramViewGroup.jeQ.setBackgroundDrawable(null);
        paramViewGroup.fWX.setText(2131759662);
        paramViewGroup.fWX.setTextColor(this.context.getResources().getColor(2131100544));
        break label160;
      }
      if (locala.hPN == 2)
      {
        paramViewGroup.jeQ.setClickable(false);
        paramViewGroup.jeQ.setBackgroundDrawable(null);
        paramViewGroup.fWX.setText(2131759667);
        paramViewGroup.fWX.setTextColor(this.context.getResources().getColor(2131100544));
        break label160;
      }
      paramViewGroup.jeQ.setClickable(true);
      paramViewGroup.jeQ.setBackgroundResource(2131231365);
      paramViewGroup.fWX.setText(2131759661);
      paramViewGroup.fWX.setTextColor(this.context.getResources().getColor(2131101182));
      break label160;
      paramViewGroup.fWX.setVisibility(4);
      paramViewGroup.jeY.setVisibility(0);
      break label192;
      paramViewGroup.fWX.setVisibility(0);
      paramViewGroup.jeY.setVisibility(4);
      break label192;
      i = ((com.tencent.mm.plugin.account.friend.a.a)localObject).jfT;
      break label212;
      label640:
      paramViewGroup.jeV.setVisibility(0);
      paramViewGroup.jeV.setText((CharSequence)localObject);
      paramViewGroup.jeV.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      continue;
      label671:
      if (locala.jfT != i) {}
      for (i = 1;; i = 0)
      {
        localObject = a(locala);
        if ((!bu.isNullOrNil((String)localObject)) && (i != 0)) {
          break label748;
        }
        ae.w("MicroMsg.MobileFriendAdapter", "get display show head return null, user[%s] pos[%d]", new Object[] { locala.getUsername(), Integer.valueOf(paramInt) });
        paramViewGroup.jeV.setVisibility(8);
        break;
      }
      label748:
      paramViewGroup.jeV.setVisibility(0);
      paramViewGroup.jeV.setText((CharSequence)localObject);
      paramViewGroup.jeV.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
  }
  
  final class a
  {
    String account;
    ImageView fTj;
    TextView fWX;
    int jeO;
    View jeQ;
    TextView jeV;
    TextView jeW;
    TextView jeX;
    ProgressBar jeY;
    int status;
    
    public a(View paramView)
    {
      AppMethodBeat.i(110137);
      this.jeV = ((TextView)paramView.findViewById(2131300294));
      this.fTj = ((ImageView)paramView.findViewById(2131300293));
      this.jeW = ((TextView)paramView.findViewById(2131300295));
      this.jeX = ((TextView)paramView.findViewById(2131300298));
      this.jeQ = paramView.findViewById(2131300292);
      this.fWX = ((TextView)paramView.findViewById(2131300297));
      this.jeY = ((ProgressBar)paramView.findViewById(2131300296));
      this.jeQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(110136);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/MobileFriendAdapterCaseB$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (d.f(d.this) != null) {
            d.f(d.this).e(d.a.this.jeO, d.a.this.account, d.a.this.status);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/MobileFriendAdapterCaseB$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(110136);
        }
      });
      AppMethodBeat.o(110137);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.d
 * JD-Core Version:    0.7.0.1
 */