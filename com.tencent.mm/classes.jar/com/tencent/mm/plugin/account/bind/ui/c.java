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
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.by;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.pluginsdk.ui.applet.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.e.c;
import com.tencent.mm.ui.q.a;
import java.util.LinkedList;

public final class c
  extends b
{
  private b.b iiA;
  private String iiy;
  private b.a iiz;
  private int[] mv;
  
  public c(Context paramContext, q.a parama)
  {
    super(paramContext, new com.tencent.mm.plugin.account.friend.a.a());
    AppMethodBeat.i(110126);
    this.iiA = new b.b()
    {
      public final void d(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        AppMethodBeat.i(110123);
        ad.d("MicroMsg.MobileFriendAdapter", "[cpan] postion:%d md5:%s status:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString, Integer.valueOf(paramAnonymousInt2) });
        final com.tencent.mm.plugin.account.friend.a.a locala = (com.tencent.mm.plugin.account.friend.a.a)c.this.getItem(paramAnonymousInt1);
        if (locala == null)
        {
          ad.e("MicroMsg.MobileFriendAdapter", "[cpan] mobile Friend is null. mobile:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(110123);
          return;
        }
        ad.d("MicroMsg.MobileFriendAdapter", "mobile friend:%s", new Object[] { locala.toString() });
        if (locala.status == 1)
        {
          paramAnonymousString = new com.tencent.mm.pluginsdk.ui.applet.a(c.a(c.this), new a.a()
          {
            public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
            {
              AppMethodBeat.i(110120);
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
                  c.this.Wd();
                  by.asD().d(26, new Object[0]);
                  AppMethodBeat.o(110120);
                }
              }
              else {
                ad.w("MicroMsg.MobileFriendAdapter", "cpan qq friend is null. qq:%s", new Object[] { paramAnonymous2String2 });
              }
              AppMethodBeat.o(110120);
            }
          });
          paramAnonymousString.BXs = new a.b()
          {
            public final boolean at(String paramAnonymous2String, int paramAnonymous2Int)
            {
              AppMethodBeat.i(110121);
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
                d.b(c.b(c.this), "profile", paramAnonymous2String, localIntent, 1);
                AppMethodBeat.o(110121);
                return true;
                if (paramAnonymous2Int == 2) {
                  paramAnonymous2String = ".ui.SayHiWithSnsPermissionUI3";
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
          paramAnonymousString.iny = locala.JS();
          paramAnonymousString.BXy = false;
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
  
  public final void BW(String paramString)
  {
    AppMethodBeat.i(110127);
    this.iiy = bt.aFQ(paramString.trim());
    cHX();
    Wd();
    AppMethodBeat.o(110127);
  }
  
  public final void Wd()
  {
    AppMethodBeat.i(110129);
    cHX();
    setCursor(((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).Cd(this.iiy));
    this.mv = new int[getCount()];
    if ((this.iiz != null) && (this.iiy != null)) {
      this.iiz.pY(getCursor().getCount());
    }
    notifyDataSetChanged();
    AppMethodBeat.o(110129);
  }
  
  public final void We()
  {
    AppMethodBeat.i(110128);
    Wd();
    AppMethodBeat.o(110128);
  }
  
  public final void a(b.a parama)
  {
    this.iiz = parama;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(110130);
    com.tencent.mm.plugin.account.friend.a.a locala = (com.tencent.mm.plugin.account.friend.a.a)getItem(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.context, 2131494922, null);
      paramViewGroup = new a(paramView);
      paramViewGroup.iiF = ((TextView)paramView.findViewById(2131302355));
      paramView.setTag(paramViewGroup);
      paramViewGroup.iiE = paramInt;
      paramViewGroup.md5 = locala.JS();
      paramViewGroup.status = locala.status;
      paramViewGroup.iiF.setText(locala.aIv());
      switch (locala.status)
      {
      default: 
        label124:
        switch (locala.gUd)
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
      if (locala.gUd == 2)
      {
        paramViewGroup.iiG.setClickable(false);
        paramViewGroup.iiG.setBackgroundDrawable(null);
        paramViewGroup.fxX.setText(2131759664);
        paramViewGroup.fxX.setTextColor(this.context.getResources().getColor(2131100544));
        break label124;
      }
      paramViewGroup.iiG.setClickable(true);
      paramViewGroup.iiG.setBackgroundResource(2131231365);
      paramViewGroup.fxX.setText(2131759663);
      paramViewGroup.fxX.setTextColor(this.context.getResources().getColor(2131101179));
      break label124;
      ad.d("MicroMsg.MobileFriendAdapter", "username:%s", new Object[] { locala.getUsername() });
      if ((((k)g.ab(k.class)).apM().aHT(locala.getUsername())) || (u.aqG().equals(locala.getUsername())))
      {
        paramViewGroup.iiG.setClickable(false);
        paramViewGroup.iiG.setBackgroundDrawable(null);
        paramViewGroup.fxX.setText(2131759662);
        paramViewGroup.fxX.setTextColor(this.context.getResources().getColor(2131100544));
        break label124;
      }
      if (locala.gUd == 2)
      {
        paramViewGroup.iiG.setClickable(false);
        paramViewGroup.iiG.setBackgroundDrawable(null);
        paramViewGroup.fxX.setText(2131759667);
        paramViewGroup.fxX.setTextColor(this.context.getResources().getColor(2131100544));
        break label124;
      }
      paramViewGroup.iiG.setClickable(true);
      paramViewGroup.iiG.setBackgroundResource(2131231365);
      paramViewGroup.fxX.setText(2131759661);
      paramViewGroup.fxX.setTextColor(this.context.getResources().getColor(2131101179));
      break label124;
      paramViewGroup.fxX.setVisibility(4);
      paramViewGroup.iiH.setVisibility(0);
      continue;
      paramViewGroup.fxX.setVisibility(0);
      paramViewGroup.iiH.setVisibility(4);
    }
  }
  
  final class a
  {
    TextView fxX;
    int iiE;
    TextView iiF;
    View iiG;
    ProgressBar iiH;
    String md5;
    int status;
    
    public a(View paramView)
    {
      AppMethodBeat.i(110125);
      this.iiF = ((TextView)paramView.findViewById(2131302355));
      this.iiG = paramView.findViewById(2131302347);
      this.fxX = ((TextView)paramView.findViewById(2131302358));
      this.iiH = ((ProgressBar)paramView.findViewById(2131302357));
      this.iiG.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(110124);
          if (c.f(c.this) != null) {
            c.f(c.this).d(c.a.this.iiE, c.a.this.md5, c.a.this.status);
          }
          AppMethodBeat.o(110124);
        }
      });
      AppMethodBeat.o(110125);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.c
 * JD-Core Version:    0.7.0.1
 */