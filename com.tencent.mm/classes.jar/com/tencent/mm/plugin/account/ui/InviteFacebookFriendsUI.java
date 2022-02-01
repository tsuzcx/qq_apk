package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.bb.h.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.account.friend.a.p;
import com.tencent.mm.plugin.account.model.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.g.a.b;
import com.tencent.mm.ui.g.a.c.a;
import com.tencent.mm.ui.q.a;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.tools.r.b;
import java.util.ArrayList;
import java.util.List;

public class InviteFacebookFriendsUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private ProgressDialog fpP = null;
  private ListView iiS;
  private View iiU;
  String iiW;
  a iqQ;
  private final int recommendType = 5;
  
  private void bI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(128048);
    com.tencent.mm.ui.base.h.a(this, paramString2, paramString1, new InviteFacebookFriendsUI.2(this), null);
    AppMethodBeat.o(128048);
  }
  
  public int getLayoutId()
  {
    return 2131493996;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128047);
    this.iiS = ((ListView)findViewById(2131302352));
    Object localObject1 = (TextView)findViewById(2131299468);
    ((TextView)localObject1).setText(2131758789);
    Object localObject2 = new r((byte)0);
    ((r)localObject2).Htp = new r.b()
    {
      public final boolean BX(String paramAnonymousString)
      {
        return false;
      }
      
      public final void BY(String paramAnonymousString)
      {
        AppMethodBeat.i(128021);
        InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this, bt.aFQ(paramAnonymousString));
        paramAnonymousString = InviteFacebookFriendsUI.this;
        if (paramAnonymousString.iqQ != null)
        {
          InviteFacebookFriendsUI.a locala = paramAnonymousString.iqQ;
          locala.iiy = bt.aFQ(paramAnonymousString.iiW.trim());
          locala.cHX();
          locala.Wd();
        }
        AppMethodBeat.o(128021);
      }
      
      public final void aIj() {}
      
      public final void aIk() {}
      
      public final void aIl() {}
      
      public final void aIm() {}
    };
    addSearchMenu(true, (r)localObject2);
    this.iqQ = new a(this, new q.a()
    {
      public final void aIp()
      {
        AppMethodBeat.i(128023);
        if (u.arj())
        {
          if (InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this).getCount() == 0)
          {
            this.iqB.setVisibility(0);
            AppMethodBeat.o(128023);
            return;
          }
          this.iqB.setVisibility(8);
        }
        AppMethodBeat.o(128023);
      }
    });
    this.iiS.setAdapter(this.iqQ);
    this.iiU = findViewById(2131302353);
    this.iiS.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(128024);
        if (InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this).aJP().length >= 50)
        {
          com.tencent.mm.ui.base.h.j(InviteFacebookFriendsUI.this, 2131758795, 2131755906);
          AppMethodBeat.o(128024);
          return;
        }
        InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this).qf(paramAnonymousInt - InviteFacebookFriendsUI.b(InviteFacebookFriendsUI.this).getHeaderViewsCount());
        if (InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this).aJP().length > 0)
        {
          InviteFacebookFriendsUI.this.showOptionMenu(true);
          AppMethodBeat.o(128024);
          return;
        }
        InviteFacebookFriendsUI.this.showOptionMenu(false);
        AppMethodBeat.o(128024);
      }
    });
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.InviteFacebookFriendsUI", "isBindForFacebookApp:" + u.arj());
    if (u.arj())
    {
      this.iiS.setVisibility(0);
      this.iiU.setVisibility(8);
      long l = bt.f((Long)com.tencent.mm.kernel.g.afB().afk().get(65831, null));
      localObject1 = bt.nullAsNil((String)com.tencent.mm.kernel.g.afB().afk().get(65830, null));
      if ((bt.vM(l) > 86400000L) && (((String)localObject1).length() > 0))
      {
        localObject2 = new com.tencent.mm.ui.g.a.c(getString(2131758773));
        ((com.tencent.mm.ui.g.a.c)localObject2).aLA((String)localObject1);
        new j((com.tencent.mm.ui.g.a.c)localObject2, new com.tencent.mm.plugin.account.model.k()
        {
          public final void onError(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(128026);
            super.onError(paramAnonymousInt, paramAnonymousString);
            if (paramAnonymousInt == 3) {
              InviteFacebookFriendsUI.c(InviteFacebookFriendsUI.this);
            }
            AppMethodBeat.o(128026);
          }
          
          public final void w(Bundle paramAnonymousBundle)
          {
            AppMethodBeat.i(128025);
            super.w(paramAnonymousBundle);
            AppMethodBeat.o(128025);
          }
        }).aIh();
      }
      localObject1 = new com.tencent.mm.plugin.account.friend.a.ad();
      ((com.tencent.mm.plugin.account.friend.a.ad)localObject1).aIZ();
      localObject2 = new av(new InviteFacebookFriendsUI.6(this, (com.tencent.mm.plugin.account.friend.a.ad)localObject1), false);
      if (bt.l((Integer)com.tencent.mm.kernel.g.afB().afk().get(65829, null)) <= 0) {
        break label441;
      }
      com.tencent.mm.kernel.g.afB().afk().set(65829, Integer.valueOf(1));
      com.tencent.mm.kernel.g.aeS().a((n)localObject1, 0);
    }
    for (;;)
    {
      AppCompatActivity localAppCompatActivity = getContext();
      getString(2131755906);
      this.fpP = com.tencent.mm.ui.base.h.b(localAppCompatActivity, getString(2131762072), true, new InviteFacebookFriendsUI.7(this, (av)localObject2, (com.tencent.mm.plugin.account.friend.a.ad)localObject1));
      setBackBtn(new InviteFacebookFriendsUI.8(this));
      setToTop(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128030);
          paramAnonymousView = InviteFacebookFriendsUI.b(InviteFacebookFriendsUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
          Object localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.adn(), "com/tencent/mm/plugin/account/ui/InviteFacebookFriendsUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.c.b((ListView)paramAnonymousView.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/account/ui/InviteFacebookFriendsUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          AppMethodBeat.o(128030);
        }
      });
      addTextOptionMenu(0, getString(2131758793), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(128037);
          com.tencent.mm.ui.g.a.c localc = new com.tencent.mm.ui.g.a.c(InviteFacebookFriendsUI.this.getString(2131758773));
          Bundle localBundle = new Bundle();
          localBundle.putString("message", InviteFacebookFriendsUI.this.getString(2131758792));
          final long[] arrayOfLong = InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this).aJP();
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
            public final void a(b paramAnonymous2b)
            {
              AppMethodBeat.i(128034);
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite error");
              AppMethodBeat.o(128034);
            }
            
            public final void a(com.tencent.mm.ui.g.a.e paramAnonymous2e)
            {
              AppMethodBeat.i(128033);
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite error");
              AppMethodBeat.o(128033);
            }
            
            public final void onCancel()
            {
              AppMethodBeat.i(128036);
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite cancle");
              AppMethodBeat.o(128036);
            }
            
            public final void w(Bundle paramAnonymous2Bundle)
            {
              AppMethodBeat.i(128035);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.InviteFacebookFriendsUI", "fbinvite oncomplete");
              paramAnonymous2Bundle = new ArrayList();
              paramAnonymous2Bundle.add(new h.a(33, Integer.toString(arrayOfLong.length)));
              ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apL().c(new com.tencent.mm.bb.h(paramAnonymous2Bundle));
              paramAnonymous2Bundle = arrayOfLong;
              int j = paramAnonymous2Bundle.length;
              int i = 0;
              while (i < j)
              {
                long l = paramAnonymous2Bundle[i];
                p localp = new p();
                localp.username = Long.toString(l);
                localp.ikD = 5;
                localp.cIT = ((int)bt.aGK());
                com.tencent.mm.plugin.account.a.getInviteFriendOpenStg().b(localp);
                i += 1;
              }
              com.tencent.mm.ui.base.h.b(InviteFacebookFriendsUI.this, 2131758794, 2131755906, 2131755939, 2131755831, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                {
                  AppMethodBeat.i(128031);
                  InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this).Wd();
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
          });
          AppMethodBeat.o(128037);
          return true;
        }
      });
      showOptionMenu(false);
      AppMethodBeat.o(128047);
      return;
      label441:
      ((av)localObject2).av(5000L, 5000L);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128045);
    super.onCreate(paramBundle);
    setMMTitle(2131758796);
    com.tencent.mm.kernel.g.aeS().a(32, this);
    initView();
    AppMethodBeat.o(128045);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128046);
    com.tencent.mm.kernel.g.aeS().b(32, this);
    this.iqQ.cHX();
    super.onDestroy();
    AppMethodBeat.o(128046);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128049);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.InviteFacebookFriendsUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramn.getType() != 32)
    {
      AppMethodBeat.o(128049);
      return;
    }
    if (this.fpP != null)
    {
      this.fpP.dismiss();
      this.fpP = null;
    }
    if ((paramInt1 == 4) && (paramInt2 == -68))
    {
      paramn = paramString;
      if (bt.isNullOrNil(paramString)) {
        paramn = "error";
      }
      bI(getString(2131755906), paramn);
      AppMethodBeat.o(128049);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.iqQ.a(null, null);
      AppMethodBeat.o(128049);
      return;
    }
    Toast.makeText(this, 2131761250, 0).show();
    AppMethodBeat.o(128049);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static final class a
    extends com.tencent.mm.ui.q<com.tencent.mm.plugin.account.friend.a.g>
  {
    String iiy;
    private boolean[] ims;
    private int[] mv;
    
    public a(Context paramContext, q.a parama)
    {
      super(new com.tencent.mm.plugin.account.friend.a.g());
      AppMethodBeat.i(128038);
      super.a(parama);
      AppMethodBeat.o(128038);
    }
    
    public final void Wd()
    {
      AppMethodBeat.i(128042);
      com.tencent.mm.plugin.account.friend.a.h localh = com.tencent.mm.plugin.account.a.getFacebookFrdStg();
      String str = this.iiy;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" where facebookfriend.status = 102 ");
      if ((str != null) && (str.length() > 0))
      {
        localStringBuilder.append(" and ( ");
        localStringBuilder.append("facebookfriend.fbname like '%" + str + "%' or ");
        localStringBuilder.append("facebookfriend.nickname like '%" + str + "%' or ");
        localStringBuilder.append("facebookfriend.username like '%" + str + "%' ) ");
      }
      setCursor(localh.gPa.a("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend  " + localStringBuilder.toString() + " order by  case when status = 100 then 0  when status = 102 then 3  when status = 101 then 1 else 2 end  , nicknamepyinitial", null, 0));
      this.mv = new int[getCount()];
      this.ims = new boolean[getCount()];
      super.notifyDataSetChanged();
      AppMethodBeat.o(128042);
    }
    
    public final void We()
    {
      AppMethodBeat.i(128043);
      Wd();
      AppMethodBeat.o(128043);
    }
    
    public final long[] aJP()
    {
      AppMethodBeat.i(128040);
      Object localObject = this.ims;
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
        if (this.ims[j] == 0) {
          break label108;
        }
        localObject[i] = ((com.tencent.mm.plugin.account.friend.a.g)getItem(j)).evr;
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
      com.tencent.mm.plugin.account.friend.a.g localg = (com.tencent.mm.plugin.account.friend.a.g)getItem(paramInt);
      Bitmap localBitmap;
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramView = View.inflate(this.context, 2131493930, null);
        paramViewGroup.fuj = ((ImageView)paramView.findViewById(2131298722));
        paramViewGroup.iiF = ((TextView)paramView.findViewById(2131303561));
        paramViewGroup.imv = ((TextView)paramView.findViewById(2131301064));
        paramViewGroup.imw = ((CheckBox)paramView.findViewById(2131301078));
        paramView.setTag(paramViewGroup);
        paramViewGroup.iiF.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, localg.aIF(), paramViewGroup.iiF.getTextSize()));
        localBitmap = com.tencent.mm.ak.c.vH(localg.evr);
        if (localBitmap != null) {
          break label221;
        }
        paramViewGroup.fuj.setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131690013));
        label165:
        paramViewGroup.imw.setChecked(this.ims[paramInt]);
        if (!com.tencent.mm.plugin.account.a.getInviteFriendOpenStg().Cq(Long.toString(localg.evr))) {
          break label233;
        }
        paramViewGroup.imv.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(128039);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label221:
        paramViewGroup.fuj.setImageBitmap(localBitmap);
        break label165;
        label233:
        paramViewGroup.imv.setVisibility(8);
      }
    }
    
    public final void qf(int paramInt)
    {
      AppMethodBeat.i(128041);
      if ((paramInt < 0) || (paramInt >= this.ims.length))
      {
        AppMethodBeat.o(128041);
        return;
      }
      boolean[] arrayOfBoolean = this.ims;
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
      ImageView fuj;
      TextView iiF;
      TextView imv;
      CheckBox imw;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI
 * JD-Core Version:    0.7.0.1
 */