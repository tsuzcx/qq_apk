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
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.e.d;
import com.tencent.mm.ui.s.a;
import java.util.LinkedList;

public final class d
  extends b
{
  private String kcL;
  private b.a kcM;
  private b.b kcN;
  private int[] pt;
  
  public d(Context paramContext, s.a parama)
  {
    super(paramContext, new com.tencent.mm.plugin.account.friend.a.a());
    AppMethodBeat.i(110138);
    this.kcN = new b.b()
    {
      public final void e(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        AppMethodBeat.i(110135);
        Log.i("MicroMsg.MobileFriendAdapter", "[cpan] postion:%d md5:%s status:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString, Integer.valueOf(paramAnonymousInt2) });
        final com.tencent.mm.plugin.account.friend.a.a locala = (com.tencent.mm.plugin.account.friend.a.a)d.this.getItem(paramAnonymousInt1);
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
            public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
            {
              AppMethodBeat.i(110132);
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
                  d.this.anp();
                  cf.aWl().f(26, new Object[0]);
                  AppMethodBeat.o(110132);
                }
              }
              else {
                Log.w("MicroMsg.MobileFriendAdapter", "cpan mobile friend is null. qq:%s", new Object[] { paramAnonymous2String2 });
              }
              AppMethodBeat.o(110132);
            }
          });
          paramAnonymousString.Kea = new com.tencent.mm.pluginsdk.ui.applet.a.b()
          {
            public final boolean aE(String paramAnonymous2String, int paramAnonymous2Int)
            {
              AppMethodBeat.i(110133);
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
                c.b(d.b(d.this), "profile", paramAnonymous2String, localIntent, 1);
                AppMethodBeat.o(110133);
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
          if ((d.c(d.this) instanceof MobileFriendUI)) {
            ((MobileFriendUI)d.e(d.this)).mmSetOnActivityResultCallback(new MMActivity.a()
            {
              public final void d(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
              {
                AppMethodBeat.i(110134);
                if ((paramAnonymous2Int1 == 1) && (paramAnonymous2Int2 == -1)) {
                  ((MobileFriendUI)d.d(d.this)).b(locala);
                }
                AppMethodBeat.o(110134);
              }
            });
          }
          paramAnonymousString.khI = locala.getMd5();
          paramAnonymousString.Kee = false;
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(Integer.valueOf(13));
          paramAnonymousString.b(locala.getUsername(), localLinkedList, false);
        }
        AppMethodBeat.o(110135);
      }
    };
    super.a(parama);
    this.context = paramContext;
    Bh(true);
    AppMethodBeat.o(110138);
  }
  
  private static String a(com.tencent.mm.plugin.account.friend.a.a parama)
  {
    AppMethodBeat.i(110143);
    if (parama.kdW == 123)
    {
      AppMethodBeat.o(110143);
      return "#";
    }
    char c = (char)parama.kdW;
    AppMethodBeat.o(110143);
    return String.valueOf(c);
  }
  
  public final void SM(String paramString)
  {
    AppMethodBeat.i(110139);
    this.kcL = Util.escapeSqlValue(paramString.trim());
    ebf();
    anp();
    AppMethodBeat.o(110139);
  }
  
  public final void a(b.a parama)
  {
    this.kcM = parama;
  }
  
  public final void anp()
  {
    AppMethodBeat.i(110141);
    ebf();
    setCursor(((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).ST(this.kcL));
    this.pt = new int[getCount()];
    if ((this.kcM != null) && (this.kcL != null)) {
      this.kcM.ve(getCursor().getCount());
    }
    notifyDataSetChanged();
    AppMethodBeat.o(110141);
  }
  
  public final void anq()
  {
    AppMethodBeat.i(110140);
    anp();
    AppMethodBeat.o(110140);
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
      paramView = View.inflate(this.context, 2131494735, null);
      paramViewGroup = new a(paramView);
      paramView.setTag(paramViewGroup);
      paramViewGroup.kcR = paramInt;
      paramViewGroup.account = locala.getMd5();
      paramViewGroup.status = locala.status;
      paramViewGroup.kcZ.setText(locala.bnK());
      paramViewGroup.kda.setText(this.context.getString(2131760989) + locala.getNickName());
      com.tencent.mm.pluginsdk.ui.a.b.c(paramViewGroup.gyr, locala.getUsername());
      switch (locala.status)
      {
      default: 
        switch (locala.iKU)
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
            if (!Util.isNullOrNil((String)localObject)) {
              break label640;
            }
            Log.w("MicroMsg.MobileFriendAdapter", "get display show head return null, user[%s] pos[%d]", new Object[] { locala.getUsername(), Integer.valueOf(paramInt) });
            paramViewGroup.kcY.setVisibility(8);
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
      if (locala.iKU == 2)
      {
        paramViewGroup.kcT.setClickable(false);
        paramViewGroup.kcT.setBackgroundDrawable(null);
        paramViewGroup.gCd.setText(2131760985);
        paramViewGroup.gCd.setTextColor(this.context.getResources().getColor(2131100682));
        break label160;
      }
      paramViewGroup.kcT.setClickable(true);
      paramViewGroup.kcT.setBackgroundResource(2131231429);
      paramViewGroup.gCd.setText(2131760984);
      paramViewGroup.gCd.setTextColor(this.context.getResources().getColor(2131101427));
      break label160;
      if ((((l)g.af(l.class)).aSN().bjG(locala.getUsername())) || (z.aTY().equals(locala.getUsername())))
      {
        paramViewGroup.kcT.setClickable(false);
        paramViewGroup.kcT.setBackgroundDrawable(null);
        paramViewGroup.gCd.setText(2131760983);
        paramViewGroup.gCd.setTextColor(this.context.getResources().getColor(2131100682));
        break label160;
      }
      if (locala.iKU == 2)
      {
        paramViewGroup.kcT.setClickable(false);
        paramViewGroup.kcT.setBackgroundDrawable(null);
        paramViewGroup.gCd.setText(2131760988);
        paramViewGroup.gCd.setTextColor(this.context.getResources().getColor(2131100682));
        break label160;
      }
      paramViewGroup.kcT.setClickable(true);
      paramViewGroup.kcT.setBackgroundResource(2131231429);
      paramViewGroup.gCd.setText(2131760982);
      paramViewGroup.gCd.setTextColor(this.context.getResources().getColor(2131101427));
      break label160;
      paramViewGroup.gCd.setVisibility(4);
      paramViewGroup.kdb.setVisibility(0);
      break label192;
      paramViewGroup.gCd.setVisibility(0);
      paramViewGroup.kdb.setVisibility(4);
      break label192;
      i = ((com.tencent.mm.plugin.account.friend.a.a)localObject).kdW;
      break label212;
      label640:
      paramViewGroup.kcY.setVisibility(0);
      paramViewGroup.kcY.setText((CharSequence)localObject);
      paramViewGroup.kcY.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      continue;
      label671:
      if (locala.kdW != i) {}
      for (i = 1;; i = 0)
      {
        localObject = a(locala);
        if ((!Util.isNullOrNil((String)localObject)) && (i != 0)) {
          break label748;
        }
        Log.w("MicroMsg.MobileFriendAdapter", "get display show head return null, user[%s] pos[%d]", new Object[] { locala.getUsername(), Integer.valueOf(paramInt) });
        paramViewGroup.kcY.setVisibility(8);
        break;
      }
      label748:
      paramViewGroup.kcY.setVisibility(0);
      paramViewGroup.kcY.setText((CharSequence)localObject);
      paramViewGroup.kcY.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
  }
  
  final class a
  {
    String account;
    TextView gCd;
    ImageView gyr;
    int kcR;
    View kcT;
    TextView kcY;
    TextView kcZ;
    TextView kda;
    ProgressBar kdb;
    int status;
    
    public a(View paramView)
    {
      AppMethodBeat.i(110137);
      this.kcY = ((TextView)paramView.findViewById(2131301784));
      this.gyr = ((ImageView)paramView.findViewById(2131301783));
      this.kcZ = ((TextView)paramView.findViewById(2131301785));
      this.kda = ((TextView)paramView.findViewById(2131301788));
      this.kcT = paramView.findViewById(2131301782);
      this.gCd = ((TextView)paramView.findViewById(2131301787));
      this.kdb = ((ProgressBar)paramView.findViewById(2131301786));
      this.kcT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(110136);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/MobileFriendAdapterCaseB$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (d.f(d.this) != null) {
            d.f(d.this).e(d.a.this.kcR, d.a.this.account, d.a.this.status);
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