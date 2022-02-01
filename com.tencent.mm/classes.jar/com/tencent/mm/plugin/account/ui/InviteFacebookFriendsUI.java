package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.d;
import com.tencent.mm.bd.i.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.plugin.account.friend.a.p;
import com.tencent.mm.plugin.account.model.k;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.i.a.c;
import com.tencent.mm.ui.i.a.c.a;
import com.tencent.mm.ui.i.a.e;
import com.tencent.mm.ui.tools.t.b;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.v.a;
import java.util.ArrayList;
import java.util.List;

public class InviteFacebookFriendsUI
  extends MMActivity
  implements com.tencent.mm.an.i
{
  private ProgressDialog iXX = null;
  private ListView mUE;
  private View mUG;
  String mUI;
  a ncX;
  private final int recommendType = 5;
  
  private void ch(String paramString1, String paramString2)
  {
    AppMethodBeat.i(128048);
    com.tencent.mm.ui.base.h.a(this, paramString2, paramString1, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(128022);
        Object localObject = new Intent(InviteFacebookFriendsUI.this.getContext(), FacebookAuthUI.class);
        ((Intent)localObject).putExtra("is_force_unbind", true);
        paramAnonymousDialogInterface = InviteFacebookFriendsUI.this.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/account/ui/InviteFacebookFriendsUI$10", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/account/ui/InviteFacebookFriendsUI$10", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        InviteFacebookFriendsUI.this.finish();
        AppMethodBeat.o(128022);
      }
    }, null);
    AppMethodBeat.o(128048);
  }
  
  public int getLayoutId()
  {
    return r.g.fb_friend;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128047);
    this.mUE = ((ListView)findViewById(r.f.mobile_friend_lv));
    Object localObject1 = (TextView)findViewById(r.f.empty_msg_tip_tv);
    ((TextView)localObject1).setText(r.j.facebook_empty_friend_tip);
    Object localObject2 = new com.tencent.mm.ui.tools.t((byte)0);
    ((com.tencent.mm.ui.tools.t)localObject2).XUl = new t.b()
    {
      public final boolean aat(String paramAnonymousString)
      {
        return false;
      }
      
      public final void aau(String paramAnonymousString)
      {
        AppMethodBeat.i(128021);
        InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this, Util.escapeSqlValue(paramAnonymousString));
        paramAnonymousString = InviteFacebookFriendsUI.this;
        if (paramAnonymousString.ncX != null)
        {
          InviteFacebookFriendsUI.a locala = paramAnonymousString.ncX;
          locala.mUk = Util.escapeSqlValue(paramAnonymousString.mUI.trim());
          locala.eKd();
          locala.atr();
        }
        AppMethodBeat.o(128021);
      }
      
      public final void bxH() {}
      
      public final void bxI() {}
      
      public final void bxJ() {}
      
      public final void bxK() {}
    };
    addSearchMenu(true, (com.tencent.mm.ui.tools.t)localObject2);
    this.ncX = new a(this, new v.a()
    {
      public final void bxN()
      {
        AppMethodBeat.i(128023);
        if (z.bdH())
        {
          if (InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this).getCount() == 0)
          {
            this.ncI.setVisibility(0);
            AppMethodBeat.o(128023);
            return;
          }
          this.ncI.setVisibility(8);
        }
        AppMethodBeat.o(128023);
      }
    });
    this.mUE.setAdapter(this.ncX);
    this.mUG = findViewById(r.f.mobile_friend_mobile_not_bind_ll);
    this.mUE.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(128024);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/InviteFacebookFriendsUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        if (InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this).bzq().length >= 50)
        {
          com.tencent.mm.ui.base.h.p(InviteFacebookFriendsUI.this, r.j.facebook_invitefriends_tips_max, r.j.app_tip);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/InviteFacebookFriendsUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(128024);
          return;
        }
        InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this).yp(paramAnonymousInt - InviteFacebookFriendsUI.b(InviteFacebookFriendsUI.this).getHeaderViewsCount());
        if (InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this).bzq().length > 0) {
          InviteFacebookFriendsUI.this.showOptionMenu(true);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/InviteFacebookFriendsUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(128024);
          return;
          InviteFacebookFriendsUI.this.showOptionMenu(false);
        }
      }
    });
    Log.d("MicroMsg.InviteFacebookFriendsUI", "isBindForFacebookApp:" + z.bdH());
    if (z.bdH())
    {
      this.mUE.setVisibility(0);
      this.mUG.setVisibility(8);
      long l = Util.nullAsNil((Long)com.tencent.mm.kernel.h.aHG().aHp().b(65831, null));
      localObject1 = Util.nullAsNil((String)com.tencent.mm.kernel.h.aHG().aHp().b(65830, null));
      if ((Util.milliSecondsToNow(l) > 86400000L) && (((String)localObject1).length() > 0))
      {
        localObject2 = new c(getString(r.j.facebook_app_id));
        ((c)localObject2).bAo((String)localObject1);
        new com.tencent.mm.plugin.account.model.j((c)localObject2, new k()
        {
          public final void K(Bundle paramAnonymousBundle)
          {
            AppMethodBeat.i(128025);
            super.K(paramAnonymousBundle);
            AppMethodBeat.o(128025);
          }
          
          public final void onError(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(128026);
            super.onError(paramAnonymousInt, paramAnonymousString);
            if (paramAnonymousInt == 3) {
              InviteFacebookFriendsUI.c(InviteFacebookFriendsUI.this);
            }
            AppMethodBeat.o(128026);
          }
        }).bxF();
      }
      localObject1 = new ad();
      ((ad)localObject1).byw();
      localObject2 = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(128027);
          com.tencent.mm.kernel.h.aHG().aHp().i(65829, Integer.valueOf(1));
          com.tencent.mm.kernel.h.aGY().a(this.ncJ, 0);
          AppMethodBeat.o(128027);
          return false;
        }
      }, false);
      if (Util.nullAsNil((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(65829, null)) <= 0) {
        break label447;
      }
      com.tencent.mm.kernel.h.aHG().aHp().i(65829, Integer.valueOf(1));
      com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)localObject1, 0);
    }
    for (;;)
    {
      AppCompatActivity localAppCompatActivity = getContext();
      getString(r.j.app_tip);
      this.iXX = com.tencent.mm.ui.base.h.a(localAppCompatActivity, getString(r.j.qq_friend_loading), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128028);
          this.ncK.stopTimer();
          com.tencent.mm.kernel.h.aGY().a(this.ncJ);
          AppMethodBeat.o(128028);
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(128029);
          InviteFacebookFriendsUI.this.hideVKB();
          InviteFacebookFriendsUI.this.finish();
          AppMethodBeat.o(128029);
          return true;
        }
      });
      setToTop(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128030);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/InviteFacebookFriendsUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          paramAnonymousView = InviteFacebookFriendsUI.b(InviteFacebookFriendsUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
          localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aFh(), "com/tencent/mm/plugin/account/ui/InviteFacebookFriendsUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramAnonymousView.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/account/ui/InviteFacebookFriendsUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/InviteFacebookFriendsUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128030);
        }
      });
      addTextOptionMenu(0, getString(r.j.facebook_invitefriends_sendinvite), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(128037);
          c localc = new c(InviteFacebookFriendsUI.this.getString(r.j.facebook_app_id));
          Bundle localBundle = new Bundle();
          localBundle.putString("message", InviteFacebookFriendsUI.this.getString(r.j.facebook_invite_message));
          final long[] arrayOfLong = InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this).bzq();
          paramAnonymousMenuItem = Long.toString(arrayOfLong[0]);
          int i = 1;
          while (i < arrayOfLong.length)
          {
            paramAnonymousMenuItem = paramAnonymousMenuItem + ",";
            paramAnonymousMenuItem = paramAnonymousMenuItem + Long.toString(arrayOfLong[i]);
            i += 1;
          }
          localBundle.putString("to", paramAnonymousMenuItem);
          localc.a(InviteFacebookFriendsUI.this, "apprequests", localBundle, new c.a()
          {
            public final void K(Bundle paramAnonymous2Bundle)
            {
              AppMethodBeat.i(128035);
              Log.i("MicroMsg.InviteFacebookFriendsUI", "fbinvite oncomplete");
              paramAnonymous2Bundle = new ArrayList();
              paramAnonymous2Bundle.add(new i.a(33, Integer.toString(arrayOfLong.length)));
              ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(new com.tencent.mm.bd.i(paramAnonymous2Bundle));
              paramAnonymous2Bundle = arrayOfLong;
              int j = paramAnonymous2Bundle.length;
              int i = 0;
              while (i < j)
              {
                long l = paramAnonymous2Bundle[i];
                p localp = new p();
                localp.username = Long.toString(l);
                localp.mWp = 5;
                localp.eZP = ((int)Util.nowSecond());
                com.tencent.mm.plugin.account.b.getInviteFriendOpenStg().b(localp);
                i += 1;
              }
              com.tencent.mm.ui.base.h.a(InviteFacebookFriendsUI.this, r.j.facebook_invitefriends_tips_invitemore, r.j.app_tip, r.j.app_yes, r.j.app_no, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                {
                  AppMethodBeat.i(128031);
                  InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this).atr();
                  AppMethodBeat.o(128031);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                {
                  AppMethodBeat.i(128032);
                  InviteFacebookFriendsUI.this.finish();
                  AppMethodBeat.o(128032);
                }
              });
              AppMethodBeat.o(128035);
            }
            
            public final void a(com.tencent.mm.ui.i.a.b paramAnonymous2b)
            {
              AppMethodBeat.i(128034);
              Log.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite error");
              AppMethodBeat.o(128034);
            }
            
            public final void a(e paramAnonymous2e)
            {
              AppMethodBeat.i(128033);
              Log.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite error");
              AppMethodBeat.o(128033);
            }
            
            public final void onCancel()
            {
              AppMethodBeat.i(128036);
              Log.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite cancle");
              AppMethodBeat.o(128036);
            }
          });
          AppMethodBeat.o(128037);
          return true;
        }
      });
      showOptionMenu(false);
      AppMethodBeat.o(128047);
      return;
      label447:
      ((MTimerHandler)localObject2).startTimer(5000L);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128045);
    super.onCreate(paramBundle);
    setMMTitle(r.j.facebook_invitefriends_title);
    com.tencent.mm.kernel.h.aGY().a(32, this);
    initView();
    AppMethodBeat.o(128045);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128046);
    com.tencent.mm.kernel.h.aGY().b(32, this);
    this.ncX.eKd();
    super.onDestroy();
    AppMethodBeat.o(128046);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(128049);
    Log.i("MicroMsg.InviteFacebookFriendsUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramq.getType() != 32)
    {
      AppMethodBeat.o(128049);
      return;
    }
    if (this.iXX != null)
    {
      this.iXX.dismiss();
      this.iXX = null;
    }
    if ((paramInt1 == 4) && (paramInt2 == -68))
    {
      paramq = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramq = "error";
      }
      ch(getString(r.j.app_tip), paramq);
      AppMethodBeat.o(128049);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.ncX.onNotifyChange(null, null);
      AppMethodBeat.o(128049);
      return;
    }
    Toast.makeText(this, r.j.mobile_friend_err, 0).show();
    AppMethodBeat.o(128049);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static final class a
    extends v<g>
  {
    private int[] bBW;
    String mUk;
    private boolean[] mYc;
    
    public a(Context paramContext, v.a parama)
    {
      super(new g());
      AppMethodBeat.i(128038);
      super.a(parama);
      AppMethodBeat.o(128038);
    }
    
    public final void atr()
    {
      AppMethodBeat.i(128042);
      com.tencent.mm.plugin.account.friend.a.h localh = com.tencent.mm.plugin.account.b.getFacebookFrdStg();
      String str = this.mUk;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" where facebookfriend.status = 102 ");
      if ((str != null) && (str.length() > 0))
      {
        localStringBuilder.append(" and ( ");
        localStringBuilder.append("facebookfriend.fbname like '%" + str + "%' or ");
        localStringBuilder.append("facebookfriend.nickname like '%" + str + "%' or ");
        localStringBuilder.append("facebookfriend.username like '%" + str + "%' ) ");
      }
      v(localh.lvy.rawQuery("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend  " + localStringBuilder.toString() + " order by  case when status = 100 then 0  when status = 102 then 3  when status = 101 then 1 else 2 end  , nicknamepyinitial", null));
      this.bBW = new int[getCount()];
      this.mYc = new boolean[getCount()];
      super.notifyDataSetChanged();
      AppMethodBeat.o(128042);
    }
    
    public final void ats()
    {
      AppMethodBeat.i(128043);
      atr();
      AppMethodBeat.o(128043);
    }
    
    public final long[] bzq()
    {
      AppMethodBeat.i(128040);
      Object localObject = this.mYc;
      int m = localObject.length;
      int i = 0;
      int k;
      for (int j = 0; i < m; j = k)
      {
        k = j;
        if (localObject[i] != 0) {
          k = j + 1;
        }
        i += 1;
      }
      localObject = new long[j];
      i = 0;
      j = 0;
      if (j < getCount())
      {
        if (this.mYc[j] == 0) {
          break label108;
        }
        localObject[i] = ((g)getItem(j)).hDe;
        i += 1;
      }
      label108:
      for (;;)
      {
        j += 1;
        break;
        AppMethodBeat.o(128040);
        return localObject;
      }
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(128039);
      g localg = (g)getItem(paramInt);
      Bitmap localBitmap;
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramView = View.inflate(this.context, r.g.facebook_invite_friend_item, null);
        paramViewGroup.jiu = ((ImageView)paramView.findViewById(r.f.contactitem_avatar_iv));
        paramViewGroup.mUr = ((TextView)paramView.findViewById(r.f.qq_friend_name));
        paramViewGroup.mYf = ((TextView)paramView.findViewById(r.f.invite_friends_open_already_state));
        paramViewGroup.mYg = ((CheckBox)paramView.findViewById(r.f.inviteqqfriends_send_cb));
        paramView.setTag(paramViewGroup);
        paramViewGroup.mUr.setText(l.b(this.context, localg.byc(), paramViewGroup.mUr.getTextSize()));
        localBitmap = d.Tt(localg.hDe);
        if (localBitmap != null) {
          break label227;
        }
        paramViewGroup.jiu.setImageDrawable(com.tencent.mm.ci.a.m(this.context, r.i.default_avatar));
        label171:
        paramViewGroup.mYg.setChecked(this.mYc[paramInt]);
        if (!com.tencent.mm.plugin.account.b.getInviteFriendOpenStg().aaL(Long.toString(localg.hDe))) {
          break label239;
        }
        paramViewGroup.mYf.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(128039);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label227:
        paramViewGroup.jiu.setImageBitmap(localBitmap);
        break label171;
        label239:
        paramViewGroup.mYf.setVisibility(8);
      }
    }
    
    public final void yp(int paramInt)
    {
      AppMethodBeat.i(128041);
      if ((paramInt < 0) || (paramInt >= this.mYc.length))
      {
        AppMethodBeat.o(128041);
        return;
      }
      boolean[] arrayOfBoolean = this.mYc;
      if (arrayOfBoolean[paramInt] == 0) {}
      for (int i = 1;; i = 0)
      {
        arrayOfBoolean[paramInt] = i;
        super.notifyDataSetChanged();
        AppMethodBeat.o(128041);
        return;
      }
    }
    
    public static final class a
    {
      ImageView jiu;
      TextView mUr;
      TextView mYf;
      CheckBox mYg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI
 * JD-Core Version:    0.7.0.1
 */