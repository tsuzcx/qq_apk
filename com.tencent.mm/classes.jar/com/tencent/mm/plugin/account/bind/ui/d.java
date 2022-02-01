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
import com.tencent.mm.by.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.bind.a.d;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.f.d;
import com.tencent.mm.ui.v.a;
import java.util.LinkedList;

public final class d
  extends b
{
  private int[] bBW;
  private String mUk;
  private b.a mUl;
  private b.b mUm;
  
  public d(Context paramContext, v.a parama)
  {
    super(paramContext, new com.tencent.mm.plugin.account.friend.a.a());
    AppMethodBeat.i(110138);
    this.mUm = new b.b()
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
              com.tencent.mm.plugin.account.friend.a.a locala = ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.sdk.a.a)h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getAddrUploadStg()).aaA(paramAnonymous2String2);
              if (locala != null)
              {
                if (paramAnonymous2Boolean1)
                {
                  locala.username = paramAnonymous2String1;
                  locala.status = 2;
                  locala.lBb = 2;
                  Log.d("MicroMsg.MobileFriendAdapter", "f :%s", new Object[] { locala.toString() });
                  ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.sdk.a.a)h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getAddrUploadStg()).a(paramAnonymous2String2, locala);
                  d.this.atr();
                  cg.bfp().e(26, new Object[0]);
                  AppMethodBeat.o(110132);
                }
              }
              else {
                Log.w("MicroMsg.MobileFriendAdapter", "cpan mobile friend is null. qq:%s", new Object[] { paramAnonymous2String2 });
              }
              AppMethodBeat.o(110132);
            }
          });
          paramAnonymousString.ReH = new com.tencent.mm.pluginsdk.ui.applet.a.b()
          {
            public final boolean m(String paramAnonymous2String1, int paramAnonymous2Int, String paramAnonymous2String2)
            {
              AppMethodBeat.i(242267);
              Intent localIntent = new Intent();
              localIntent.putExtra("Contact_User", locala.getUsername());
              localIntent.putExtra("Contact_Nick", locala.getNickName());
              localIntent.putExtra("Contact_Scene", 13);
              localIntent.putExtra("sayhi_with_sns_perm_send_verify", true);
              localIntent.putExtra("sayhi_with_sns_perm_add_remark", true);
              localIntent.putExtra("sayhi_with_jump_to_profile", true);
              localIntent.putExtra(f.d.VRW, paramAnonymous2String1);
              localIntent.putExtra("sayhi_verify_add_errcode", paramAnonymous2Int);
              paramAnonymous2Int = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vWD, 2);
              int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vWG, 5000);
              paramAnonymous2String2 = ".ui.SayHiWithSnsPermissionUI";
              if ((!as.bvK(locala.getUsername())) && (paramAnonymous2Int == 1)) {
                paramAnonymous2String1 = ".ui.SayHiWithSnsPermissionUI2";
              }
              for (;;)
              {
                c.b(d.b(d.this), "profile", paramAnonymous2String1, localIntent, 1);
                AppMethodBeat.o(242267);
                return true;
                paramAnonymous2String1 = paramAnonymous2String2;
                if (!as.bvK(locala.getUsername()))
                {
                  paramAnonymous2String1 = paramAnonymous2String2;
                  if (paramAnonymous2Int == 2)
                  {
                    paramAnonymous2String1 = paramAnonymous2String2;
                    if (ab.bef() >= i) {
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
          paramAnonymousString.mZh = locala.getMd5();
          paramAnonymousString.fgi = false;
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(Integer.valueOf(13));
          paramAnonymousString.b(locala.getUsername(), localLinkedList, false);
        }
        AppMethodBeat.o(110135);
      }
    };
    super.a(parama);
    this.context = paramContext;
    Fx(true);
    AppMethodBeat.o(110138);
  }
  
  private static String a(com.tencent.mm.plugin.account.friend.a.a parama)
  {
    AppMethodBeat.i(110143);
    if (parama.mVw == 123)
    {
      AppMethodBeat.o(110143);
      return "#";
    }
    char c = (char)parama.mVw;
    AppMethodBeat.o(110143);
    return String.valueOf(c);
  }
  
  public final void a(b.a parama)
  {
    this.mUl = parama;
  }
  
  public final void aas(String paramString)
  {
    AppMethodBeat.i(110139);
    this.mUk = Util.escapeSqlValue(paramString.trim());
    eKd();
    atr();
    AppMethodBeat.o(110139);
  }
  
  public final void atr()
  {
    AppMethodBeat.i(110141);
    eKd();
    v(((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.sdk.a.a)h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getAddrUploadStg()).aaz(this.mUk));
    this.bBW = new int[getCount()];
    if ((this.mUl != null) && (this.mUk != null)) {
      this.mUl.yi(hK().getCount());
    }
    notifyDataSetChanged();
    AppMethodBeat.o(110141);
  }
  
  public final void ats()
  {
    AppMethodBeat.i(110140);
    atr();
    AppMethodBeat.o(110140);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(110142);
    com.tencent.mm.plugin.account.friend.a.a locala = (com.tencent.mm.plugin.account.friend.a.a)getItem(paramInt);
    label164:
    label196:
    Object localObject;
    int i;
    if (paramView == null)
    {
      paramView = View.inflate(this.context, a.f.friend_list_item, null);
      paramViewGroup = new a(paramView);
      paramView.setTag(paramViewGroup);
      paramViewGroup.mUq = paramInt;
      paramViewGroup.account = locala.getMd5();
      paramViewGroup.status = locala.status;
      paramViewGroup.mUy.setText(locala.bxT());
      paramViewGroup.mUz.setText(this.context.getString(a.i.friend_weixin) + locala.getNickName());
      com.tencent.mm.pluginsdk.ui.a.b.c(paramViewGroup.jiu, locala.getUsername());
      switch (locala.status)
      {
      default: 
        switch (locala.lBb)
        {
        default: 
          localObject = (com.tencent.mm.plugin.account.friend.a.a)getItem(paramInt - 1);
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
            paramViewGroup.mUx.setVisibility(8);
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
      if (locala.lBb == 2)
      {
        paramViewGroup.mUs.setClickable(false);
        paramViewGroup.mUs.setBackgroundDrawable(null);
        paramViewGroup.jmj.setText(a.i.friend_invited);
        paramViewGroup.jmj.setTextColor(this.context.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.lightgrey));
        break label164;
      }
      paramViewGroup.mUs.setClickable(true);
      paramViewGroup.mUs.setBackgroundResource(a.d.btn_solid_green);
      paramViewGroup.jmj.setText(a.i.friend_invite);
      paramViewGroup.jmj.setTextColor(this.context.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.white_text_color));
      break label164;
      if ((((n)h.ae(n.class)).bbL().bwd(locala.getUsername())) || (z.bcZ().equals(locala.getUsername())))
      {
        paramViewGroup.mUs.setClickable(false);
        paramViewGroup.mUs.setBackgroundDrawable(null);
        paramViewGroup.jmj.setText(a.i.friend_added);
        paramViewGroup.jmj.setTextColor(this.context.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.lightgrey));
        break label164;
      }
      if (locala.lBb == 2)
      {
        paramViewGroup.mUs.setClickable(false);
        paramViewGroup.mUs.setBackgroundDrawable(null);
        paramViewGroup.jmj.setText(a.i.friend_waiting_ask);
        paramViewGroup.jmj.setTextColor(this.context.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.lightgrey));
        break label164;
      }
      paramViewGroup.mUs.setClickable(true);
      paramViewGroup.mUs.setBackgroundResource(a.d.btn_solid_green);
      paramViewGroup.jmj.setText(a.i.friend_add);
      paramViewGroup.jmj.setTextColor(this.context.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.white_text_color));
      break label164;
      paramViewGroup.jmj.setVisibility(4);
      paramViewGroup.mUB.setVisibility(0);
      break label196;
      paramViewGroup.jmj.setVisibility(0);
      paramViewGroup.mUB.setVisibility(4);
      break label196;
      i = ((com.tencent.mm.plugin.account.friend.a.a)localObject).mVw;
      break label216;
      label646:
      paramViewGroup.mUx.setVisibility(0);
      paramViewGroup.mUx.setText((CharSequence)localObject);
      paramViewGroup.mUx.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      continue;
      label677:
      if (locala.mVw != i) {}
      for (i = 1;; i = 0)
      {
        localObject = a(locala);
        if ((!Util.isNullOrNil((String)localObject)) && (i != 0)) {
          break label756;
        }
        Log.w("MicroMsg.MobileFriendAdapter", "get display show head return null, user[%s] pos[%d]", new Object[] { locala.getUsername(), Integer.valueOf(paramInt) });
        paramViewGroup.mUx.setVisibility(8);
        break;
      }
      label756:
      paramViewGroup.mUx.setVisibility(0);
      paramViewGroup.mUx.setText((CharSequence)localObject);
      paramViewGroup.mUx.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
  }
  
  final class a
  {
    String account;
    ImageView jiu;
    TextView jmj;
    ProgressBar mUB;
    int mUq;
    View mUs;
    TextView mUx;
    TextView mUy;
    TextView mUz;
    int status;
    
    public a(View paramView)
    {
      AppMethodBeat.i(110137);
      this.mUx = ((TextView)paramView.findViewById(a.e.friend_item_catalog));
      this.jiu = ((ImageView)paramView.findViewById(a.e.friend_item_avatar_iv));
      this.mUy = ((TextView)paramView.findViewById(a.e.friend_item_nickname));
      this.mUz = ((TextView)paramView.findViewById(a.e.friend_item_wx_nickname));
      this.mUs = paramView.findViewById(a.e.friend_item_action_view);
      this.jmj = ((TextView)paramView.findViewById(a.e.friend_item_status_tv));
      this.mUB = ((ProgressBar)paramView.findViewById(a.e.friend_item_status_pb));
      this.mUs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(110136);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/MobileFriendAdapterCaseB$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (d.f(d.this) != null) {
            d.f(d.this).e(d.a.this.mUq, d.a.this.account, d.a.this.status);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/MobileFriendAdapterCaseB$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(110136);
        }
      });
      AppMethodBeat.o(110137);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.d
 * JD-Core Version:    0.7.0.1
 */