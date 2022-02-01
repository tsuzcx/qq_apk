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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.e.c;
import com.tencent.mm.ui.q.a;
import java.util.LinkedList;

public final class d
  extends b
{
  private b.b iiA;
  private String iiy;
  private b.a iiz;
  private int[] mv;
  
  public d(Context paramContext, q.a parama)
  {
    super(paramContext, new com.tencent.mm.plugin.account.friend.a.a());
    AppMethodBeat.i(110138);
    this.iiA = new b.b()
    {
      public final void d(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        AppMethodBeat.i(110135);
        ad.i("MicroMsg.MobileFriendAdapter", "[cpan] postion:%d md5:%s status:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString, Integer.valueOf(paramAnonymousInt2) });
        final com.tencent.mm.plugin.account.friend.a.a locala = (com.tencent.mm.plugin.account.friend.a.a)d.this.getItem(paramAnonymousInt1);
        if (locala == null)
        {
          ad.e("MicroMsg.MobileFriendAdapter", "[cpan] mobile Friend is null. mobile:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(110135);
          return;
        }
        ad.d("MicroMsg.MobileFriendAdapter", "mobile friend:%s", new Object[] { locala.toString() });
        if (locala.status == 1)
        {
          paramAnonymousString = new com.tencent.mm.pluginsdk.ui.applet.a(d.a(d.this), new a.a()
          {
            public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
            {
              AppMethodBeat.i(110132);
              ad.i("MicroMsg.MobileFriendAdapter", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2), paramAnonymous2String1, paramAnonymous2String2 });
              com.tencent.mm.plugin.account.friend.a.a locala = ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).Cf(paramAnonymous2String2);
              if (locala != null)
              {
                if (paramAnonymous2Boolean1)
                {
                  locala.username = paramAnonymous2String1;
                  locala.status = 2;
                  locala.gUd = 2;
                  ad.d("MicroMsg.MobileFriendAdapter", "f :%s", new Object[] { locala.toString() });
                  ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).a(paramAnonymous2String2, locala);
                  d.this.Wd();
                  by.asD().d(26, new Object[0]);
                  AppMethodBeat.o(110132);
                }
              }
              else {
                ad.w("MicroMsg.MobileFriendAdapter", "cpan mobile friend is null. qq:%s", new Object[] { paramAnonymous2String2 });
              }
              AppMethodBeat.o(110132);
            }
          });
          paramAnonymousString.BXs = new com.tencent.mm.pluginsdk.ui.applet.a.b()
          {
            public final boolean at(String paramAnonymous2String, int paramAnonymous2Int)
            {
              AppMethodBeat.i(110133);
              Intent localIntent = new Intent();
              localIntent.putExtra("Contact_User", locala.getUsername());
              localIntent.putExtra("Contact_Nick", locala.getNickName());
              localIntent.putExtra("Contact_Scene", 13);
              localIntent.putExtra("sayhi_with_sns_perm_send_verify", true);
              localIntent.putExtra("sayhi_with_sns_perm_add_remark", true);
              localIntent.putExtra("sayhi_with_jump_to_profile", true);
              localIntent.putExtra(e.c.FHR, paramAnonymous2String);
              localIntent.putExtra("sayhi_verify_add_errcode", paramAnonymous2Int);
              paramAnonymous2Int = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pxj, 0);
              paramAnonymous2String = ".ui.SayHiWithSnsPermissionUI";
              if (paramAnonymous2Int == 1) {
                paramAnonymous2String = ".ui.SayHiWithSnsPermissionUI2";
              }
              for (;;)
              {
                com.tencent.mm.bs.d.b(d.b(d.this), "profile", paramAnonymous2String, localIntent, 1);
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
          paramAnonymousString.iny = locala.JS();
          paramAnonymousString.BXy = false;
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(Integer.valueOf(13));
          paramAnonymousString.b(locala.getUsername(), localLinkedList, false);
        }
        AppMethodBeat.o(110135);
      }
    };
    super.a(parama);
    this.context = paramContext;
    vw(true);
    AppMethodBeat.o(110138);
  }
  
  private static String a(com.tencent.mm.plugin.account.friend.a.a parama)
  {
    AppMethodBeat.i(110143);
    if (parama.ijK == 123)
    {
      AppMethodBeat.o(110143);
      return "#";
    }
    char c = (char)parama.ijK;
    AppMethodBeat.o(110143);
    return String.valueOf(c);
  }
  
  public final void BW(String paramString)
  {
    AppMethodBeat.i(110139);
    this.iiy = bt.aFQ(paramString.trim());
    cHX();
    Wd();
    AppMethodBeat.o(110139);
  }
  
  public final void Wd()
  {
    AppMethodBeat.i(110141);
    cHX();
    setCursor(((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).Ce(this.iiy));
    this.mv = new int[getCount()];
    if ((this.iiz != null) && (this.iiy != null)) {
      this.iiz.pY(getCursor().getCount());
    }
    notifyDataSetChanged();
    AppMethodBeat.o(110141);
  }
  
  public final void We()
  {
    AppMethodBeat.i(110140);
    Wd();
    AppMethodBeat.o(110140);
  }
  
  public final void a(b.a parama)
  {
    this.iiz = parama;
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
      paramViewGroup.iiE = paramInt;
      paramViewGroup.account = locala.JS();
      paramViewGroup.status = locala.status;
      paramViewGroup.iiN.setText(locala.aIv());
      paramViewGroup.iiO.setText(this.context.getString(2131759668) + locala.getNickName());
      com.tencent.mm.pluginsdk.ui.a.b.c(paramViewGroup.fuj, locala.getUsername());
      switch (locala.status)
      {
      default: 
        switch (locala.gUd)
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
            if (!bt.isNullOrNil((String)localObject)) {
              break label640;
            }
            ad.w("MicroMsg.MobileFriendAdapter", "get display show head return null, user[%s] pos[%d]", new Object[] { locala.getUsername(), Integer.valueOf(paramInt) });
            paramViewGroup.iiM.setVisibility(8);
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
      if (locala.gUd == 2)
      {
        paramViewGroup.iiG.setClickable(false);
        paramViewGroup.iiG.setBackgroundDrawable(null);
        paramViewGroup.fxX.setText(2131759664);
        paramViewGroup.fxX.setTextColor(this.context.getResources().getColor(2131100544));
        break label160;
      }
      paramViewGroup.iiG.setClickable(true);
      paramViewGroup.iiG.setBackgroundResource(2131231365);
      paramViewGroup.fxX.setText(2131759663);
      paramViewGroup.fxX.setTextColor(this.context.getResources().getColor(2131101182));
      break label160;
      if ((((k)g.ab(k.class)).apM().aHT(locala.getUsername())) || (u.aqG().equals(locala.getUsername())))
      {
        paramViewGroup.iiG.setClickable(false);
        paramViewGroup.iiG.setBackgroundDrawable(null);
        paramViewGroup.fxX.setText(2131759662);
        paramViewGroup.fxX.setTextColor(this.context.getResources().getColor(2131100544));
        break label160;
      }
      if (locala.gUd == 2)
      {
        paramViewGroup.iiG.setClickable(false);
        paramViewGroup.iiG.setBackgroundDrawable(null);
        paramViewGroup.fxX.setText(2131759667);
        paramViewGroup.fxX.setTextColor(this.context.getResources().getColor(2131100544));
        break label160;
      }
      paramViewGroup.iiG.setClickable(true);
      paramViewGroup.iiG.setBackgroundResource(2131231365);
      paramViewGroup.fxX.setText(2131759661);
      paramViewGroup.fxX.setTextColor(this.context.getResources().getColor(2131101182));
      break label160;
      paramViewGroup.fxX.setVisibility(4);
      paramViewGroup.iiP.setVisibility(0);
      break label192;
      paramViewGroup.fxX.setVisibility(0);
      paramViewGroup.iiP.setVisibility(4);
      break label192;
      i = ((com.tencent.mm.plugin.account.friend.a.a)localObject).ijK;
      break label212;
      label640:
      paramViewGroup.iiM.setVisibility(0);
      paramViewGroup.iiM.setText((CharSequence)localObject);
      paramViewGroup.iiM.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      continue;
      label671:
      if (locala.ijK != i) {}
      for (i = 1;; i = 0)
      {
        localObject = a(locala);
        if ((!bt.isNullOrNil((String)localObject)) && (i != 0)) {
          break label748;
        }
        ad.w("MicroMsg.MobileFriendAdapter", "get display show head return null, user[%s] pos[%d]", new Object[] { locala.getUsername(), Integer.valueOf(paramInt) });
        paramViewGroup.iiM.setVisibility(8);
        break;
      }
      label748:
      paramViewGroup.iiM.setVisibility(0);
      paramViewGroup.iiM.setText((CharSequence)localObject);
      paramViewGroup.iiM.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
  }
  
  final class a
  {
    String account;
    ImageView fuj;
    TextView fxX;
    int iiE;
    View iiG;
    TextView iiM;
    TextView iiN;
    TextView iiO;
    ProgressBar iiP;
    int status;
    
    public a(View paramView)
    {
      AppMethodBeat.i(110137);
      this.iiM = ((TextView)paramView.findViewById(2131300294));
      this.fuj = ((ImageView)paramView.findViewById(2131300293));
      this.iiN = ((TextView)paramView.findViewById(2131300295));
      this.iiO = ((TextView)paramView.findViewById(2131300298));
      this.iiG = paramView.findViewById(2131300292);
      this.fxX = ((TextView)paramView.findViewById(2131300297));
      this.iiP = ((ProgressBar)paramView.findViewById(2131300296));
      this.iiG.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(110136);
          if (d.f(d.this) != null) {
            d.f(d.this).d(d.a.this.iiE, d.a.this.account, d.a.this.status);
          }
          AppMethodBeat.o(110136);
        }
      });
      AppMethodBeat.o(110137);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.d
 * JD-Core Version:    0.7.0.1
 */