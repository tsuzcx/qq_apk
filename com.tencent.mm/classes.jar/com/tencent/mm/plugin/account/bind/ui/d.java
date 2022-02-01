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
import com.tencent.mm.model.by;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.e.c;
import com.tencent.mm.ui.r.a;
import java.util.LinkedList;

public final class d
  extends b
{
  private String iIG;
  private b.a iIH;
  private b.b iII;
  private int[] nw;
  
  public d(Context paramContext, r.a parama)
  {
    super(paramContext, new com.tencent.mm.plugin.account.friend.a.a());
    AppMethodBeat.i(110138);
    this.iII = new b.b()
    {
      public final void e(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        AppMethodBeat.i(110135);
        ac.i("MicroMsg.MobileFriendAdapter", "[cpan] postion:%d md5:%s status:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString, Integer.valueOf(paramAnonymousInt2) });
        final com.tencent.mm.plugin.account.friend.a.a locala = (com.tencent.mm.plugin.account.friend.a.a)d.this.getItem(paramAnonymousInt1);
        if (locala == null)
        {
          ac.e("MicroMsg.MobileFriendAdapter", "[cpan] mobile Friend is null. mobile:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(110135);
          return;
        }
        ac.d("MicroMsg.MobileFriendAdapter", "mobile friend:%s", new Object[] { locala.toString() });
        if (locala.status == 1)
        {
          paramAnonymousString = new com.tencent.mm.pluginsdk.ui.applet.a(d.a(d.this), new a.a()
          {
            public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
            {
              AppMethodBeat.i(110132);
              ac.i("MicroMsg.MobileFriendAdapter", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2), paramAnonymous2String1, paramAnonymous2String2 });
              com.tencent.mm.plugin.account.friend.a.a locala = ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).Gi(paramAnonymous2String2);
              if (locala != null)
              {
                if (paramAnonymous2Boolean1)
                {
                  locala.username = paramAnonymous2String1;
                  locala.status = 2;
                  locala.huC = 2;
                  ac.d("MicroMsg.MobileFriendAdapter", "f :%s", new Object[] { locala.toString() });
                  ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).a(paramAnonymous2String2, locala);
                  d.this.Xb();
                  by.azu().d(26, new Object[0]);
                  AppMethodBeat.o(110132);
                }
              }
              else {
                ac.w("MicroMsg.MobileFriendAdapter", "cpan mobile friend is null. qq:%s", new Object[] { paramAnonymous2String2 });
              }
              AppMethodBeat.o(110132);
            }
          });
          paramAnonymousString.DpJ = new com.tencent.mm.pluginsdk.ui.applet.a.b()
          {
            public final boolean ax(String paramAnonymous2String, int paramAnonymous2Int)
            {
              AppMethodBeat.i(110133);
              Intent localIntent = new Intent();
              localIntent.putExtra("Contact_User", locala.getUsername());
              localIntent.putExtra("Contact_Nick", locala.getNickName());
              localIntent.putExtra("Contact_Scene", 13);
              localIntent.putExtra("sayhi_with_sns_perm_send_verify", true);
              localIntent.putExtra("sayhi_with_sns_perm_add_remark", true);
              localIntent.putExtra("sayhi_with_jump_to_profile", true);
              localIntent.putExtra(e.c.HgZ, paramAnonymous2String);
              localIntent.putExtra("sayhi_verify_add_errcode", paramAnonymous2Int);
              paramAnonymous2Int = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.qbC, 0);
              paramAnonymous2String = ".ui.SayHiWithSnsPermissionUI";
              if (paramAnonymous2Int == 1) {
                paramAnonymous2String = ".ui.SayHiWithSnsPermissionUI2";
              }
              for (;;)
              {
                com.tencent.mm.br.d.b(d.b(d.this), "profile", paramAnonymous2String, localIntent, 1);
                AppMethodBeat.o(110133);
                return true;
                if (paramAnonymous2Int == 2) {
                  paramAnonymous2String = ".ui.SayHiWithSnsPermissionUI3";
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
          paramAnonymousString.iNE = locala.JC();
          paramAnonymousString.DpP = false;
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(Integer.valueOf(13));
          paramAnonymousString.b(locala.getUsername(), localLinkedList, false);
        }
        AppMethodBeat.o(110135);
      }
    };
    super.a(parama);
    this.context = paramContext;
    wy(true);
    AppMethodBeat.o(110138);
  }
  
  private static String a(com.tencent.mm.plugin.account.friend.a.a parama)
  {
    AppMethodBeat.i(110143);
    if (parama.iJR == 123)
    {
      AppMethodBeat.o(110143);
      return "#";
    }
    char c = (char)parama.iJR;
    AppMethodBeat.o(110143);
    return String.valueOf(c);
  }
  
  public final void FZ(String paramString)
  {
    AppMethodBeat.i(110139);
    this.iIG = bs.aLh(paramString.trim());
    cVi();
    Xb();
    AppMethodBeat.o(110139);
  }
  
  public final void Xb()
  {
    AppMethodBeat.i(110141);
    cVi();
    setCursor(((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).Gh(this.iIG));
    this.nw = new int[getCount()];
    if ((this.iIH != null) && (this.iIG != null)) {
      this.iIH.qL(getCursor().getCount());
    }
    notifyDataSetChanged();
    AppMethodBeat.o(110141);
  }
  
  public final void Xc()
  {
    AppMethodBeat.i(110140);
    Xb();
    AppMethodBeat.o(110140);
  }
  
  public final void a(b.a parama)
  {
    this.iIH = parama;
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
      paramViewGroup.iIM = paramInt;
      paramViewGroup.account = locala.JC();
      paramViewGroup.status = locala.status;
      paramViewGroup.iIU.setText(locala.aPm());
      paramViewGroup.iIV.setText(this.context.getString(2131759668) + locala.getNickName());
      com.tencent.mm.pluginsdk.ui.a.b.c(paramViewGroup.fxQ, locala.getUsername());
      switch (locala.status)
      {
      default: 
        switch (locala.huC)
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
            if (!bs.isNullOrNil((String)localObject)) {
              break label640;
            }
            ac.w("MicroMsg.MobileFriendAdapter", "get display show head return null, user[%s] pos[%d]", new Object[] { locala.getUsername(), Integer.valueOf(paramInt) });
            paramViewGroup.iIT.setVisibility(8);
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
      if (locala.huC == 2)
      {
        paramViewGroup.iIO.setClickable(false);
        paramViewGroup.iIO.setBackgroundDrawable(null);
        paramViewGroup.fBE.setText(2131759664);
        paramViewGroup.fBE.setTextColor(this.context.getResources().getColor(2131100544));
        break label160;
      }
      paramViewGroup.iIO.setClickable(true);
      paramViewGroup.iIO.setBackgroundResource(2131231365);
      paramViewGroup.fBE.setText(2131759663);
      paramViewGroup.fBE.setTextColor(this.context.getResources().getColor(2131101182));
      break label160;
      if ((((k)g.ab(k.class)).awB().aNo(locala.getUsername())) || (u.axw().equals(locala.getUsername())))
      {
        paramViewGroup.iIO.setClickable(false);
        paramViewGroup.iIO.setBackgroundDrawable(null);
        paramViewGroup.fBE.setText(2131759662);
        paramViewGroup.fBE.setTextColor(this.context.getResources().getColor(2131100544));
        break label160;
      }
      if (locala.huC == 2)
      {
        paramViewGroup.iIO.setClickable(false);
        paramViewGroup.iIO.setBackgroundDrawable(null);
        paramViewGroup.fBE.setText(2131759667);
        paramViewGroup.fBE.setTextColor(this.context.getResources().getColor(2131100544));
        break label160;
      }
      paramViewGroup.iIO.setClickable(true);
      paramViewGroup.iIO.setBackgroundResource(2131231365);
      paramViewGroup.fBE.setText(2131759661);
      paramViewGroup.fBE.setTextColor(this.context.getResources().getColor(2131101182));
      break label160;
      paramViewGroup.fBE.setVisibility(4);
      paramViewGroup.iIW.setVisibility(0);
      break label192;
      paramViewGroup.fBE.setVisibility(0);
      paramViewGroup.iIW.setVisibility(4);
      break label192;
      i = ((com.tencent.mm.plugin.account.friend.a.a)localObject).iJR;
      break label212;
      label640:
      paramViewGroup.iIT.setVisibility(0);
      paramViewGroup.iIT.setText((CharSequence)localObject);
      paramViewGroup.iIT.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      continue;
      label671:
      if (locala.iJR != i) {}
      for (i = 1;; i = 0)
      {
        localObject = a(locala);
        if ((!bs.isNullOrNil((String)localObject)) && (i != 0)) {
          break label748;
        }
        ac.w("MicroMsg.MobileFriendAdapter", "get display show head return null, user[%s] pos[%d]", new Object[] { locala.getUsername(), Integer.valueOf(paramInt) });
        paramViewGroup.iIT.setVisibility(8);
        break;
      }
      label748:
      paramViewGroup.iIT.setVisibility(0);
      paramViewGroup.iIT.setText((CharSequence)localObject);
      paramViewGroup.iIT.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
  }
  
  final class a
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
    
    public a(View paramView)
    {
      AppMethodBeat.i(110137);
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
          AppMethodBeat.i(110136);
          if (d.f(d.this) != null) {
            d.f(d.this).e(d.a.this.iIM, d.a.this.account, d.a.this.status);
          }
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