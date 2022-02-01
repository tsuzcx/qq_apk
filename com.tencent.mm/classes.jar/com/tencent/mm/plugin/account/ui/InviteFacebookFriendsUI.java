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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ba.i;
import com.tencent.mm.ba.i.a;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.plugin.account.friend.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.g.a.c.a;
import com.tencent.mm.ui.r.a;
import com.tencent.mm.ui.tools.r.b;
import java.util.ArrayList;
import java.util.List;

public class InviteFacebookFriendsUI
  extends MMActivity
  implements f
{
  private ProgressDialog fOC = null;
  private ListView jfb;
  private View jfd;
  String jff;
  a jmY;
  private final int recommendType = 5;
  
  private void bS(String paramString1, String paramString2)
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
    this.jfb = ((ListView)findViewById(2131302352));
    Object localObject1 = (TextView)findViewById(2131299468);
    ((TextView)localObject1).setText(2131758789);
    Object localObject2 = new com.tencent.mm.ui.tools.r((byte)0);
    ((com.tencent.mm.ui.tools.r)localObject2).Lhk = new r.b()
    {
      public final boolean JO(String paramAnonymousString)
      {
        return false;
      }
      
      public final void JP(String paramAnonymousString)
      {
        AppMethodBeat.i(128021);
        InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this, bu.aSk(paramAnonymousString));
        paramAnonymousString = InviteFacebookFriendsUI.this;
        if (paramAnonymousString.jmY != null)
        {
          InviteFacebookFriendsUI.a locala = paramAnonymousString.jmY;
          locala.jeI = bu.aSk(paramAnonymousString.jff.trim());
          locala.dhl();
          locala.ZD();
        }
        AppMethodBeat.o(128021);
      }
      
      public final void aSL() {}
      
      public final void aSM() {}
      
      public final void aSN() {}
      
      public final void aSO() {}
    };
    addSearchMenu(true, (com.tencent.mm.ui.tools.r)localObject2);
    this.jmY = new a(this, new r.a()
    {
      public final void aSR()
      {
        AppMethodBeat.i(128023);
        if (v.aBi())
        {
          if (InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this).getCount() == 0)
          {
            this.jmJ.setVisibility(0);
            AppMethodBeat.o(128023);
            return;
          }
          this.jmJ.setVisibility(8);
        }
        AppMethodBeat.o(128023);
      }
    });
    this.jfb.setAdapter(this.jmY);
    this.jfd = findViewById(2131302353);
    this.jfb.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(128024);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/InviteFacebookFriendsUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        if (InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this).aUr().length >= 50)
        {
          com.tencent.mm.ui.base.h.l(InviteFacebookFriendsUI.this, 2131758795, 2131755906);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/InviteFacebookFriendsUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(128024);
          return;
        }
        InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this).rv(paramAnonymousInt - InviteFacebookFriendsUI.b(InviteFacebookFriendsUI.this).getHeaderViewsCount());
        if (InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this).aUr().length > 0) {
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
    ae.d("MicroMsg.InviteFacebookFriendsUI", "isBindForFacebookApp:" + v.aBi());
    if (v.aBi())
    {
      this.jfb.setVisibility(0);
      this.jfd.setVisibility(8);
      long l = bu.i((Long)com.tencent.mm.kernel.g.ajR().ajA().get(65831, null));
      localObject1 = bu.nullAsNil((String)com.tencent.mm.kernel.g.ajR().ajA().get(65830, null));
      if ((bu.DD(l) > 86400000L) && (((String)localObject1).length() > 0))
      {
        localObject2 = new com.tencent.mm.ui.g.a.c(getString(2131758773));
        ((com.tencent.mm.ui.g.a.c)localObject2).aYB((String)localObject1);
        new com.tencent.mm.plugin.account.model.j((com.tencent.mm.ui.g.a.c)localObject2, new com.tencent.mm.plugin.account.model.k()
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
          
          public final void y(Bundle paramAnonymousBundle)
          {
            AppMethodBeat.i(128025);
            super.y(paramAnonymousBundle);
            AppMethodBeat.o(128025);
          }
        }).aSJ();
      }
      localObject1 = new ad();
      ((ad)localObject1).aTB();
      localObject2 = new aw(new InviteFacebookFriendsUI.6(this, (ad)localObject1), false);
      if (bu.o((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(65829, null)) <= 0) {
        break label441;
      }
      com.tencent.mm.kernel.g.ajR().ajA().set(65829, Integer.valueOf(1));
      com.tencent.mm.kernel.g.ajj().a((n)localObject1, 0);
    }
    for (;;)
    {
      AppCompatActivity localAppCompatActivity = getContext();
      getString(2131755906);
      this.fOC = com.tencent.mm.ui.base.h.b(localAppCompatActivity, getString(2131762072), true, new InviteFacebookFriendsUI.7(this, (aw)localObject2, (ad)localObject1));
      setBackBtn(new InviteFacebookFriendsUI.8(this));
      setToTop(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128030);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/InviteFacebookFriendsUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          paramAnonymousView = InviteFacebookFriendsUI.b(InviteFacebookFriendsUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
          localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahE(), "com/tencent/mm/plugin/account/ui/InviteFacebookFriendsUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.c.b((ListView)paramAnonymousView.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/account/ui/InviteFacebookFriendsUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/InviteFacebookFriendsUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
          final long[] arrayOfLong = InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this).aUr();
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
            public final void a(com.tencent.mm.ui.g.a.b paramAnonymous2b)
            {
              AppMethodBeat.i(128034);
              ae.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite error");
              AppMethodBeat.o(128034);
            }
            
            public final void a(com.tencent.mm.ui.g.a.e paramAnonymous2e)
            {
              AppMethodBeat.i(128033);
              ae.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite error");
              AppMethodBeat.o(128033);
            }
            
            public final void onCancel()
            {
              AppMethodBeat.i(128036);
              ae.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite cancle");
              AppMethodBeat.o(128036);
            }
            
            public final void y(Bundle paramAnonymous2Bundle)
            {
              AppMethodBeat.i(128035);
              ae.i("MicroMsg.InviteFacebookFriendsUI", "fbinvite oncomplete");
              paramAnonymous2Bundle = new ArrayList();
              paramAnonymous2Bundle.add(new i.a(33, Integer.toString(arrayOfLong.length)));
              ((l)com.tencent.mm.kernel.g.ab(l.class)).azE().d(new i(paramAnonymous2Bundle));
              paramAnonymous2Bundle = arrayOfLong;
              int j = paramAnonymous2Bundle.length;
              int i = 0;
              while (i < j)
              {
                long l = paramAnonymous2Bundle[i];
                p localp = new p();
                localp.username = Long.toString(l);
                localp.jgM = 5;
                localp.cRP = ((int)bu.aRi());
                com.tencent.mm.plugin.account.a.getInviteFriendOpenStg().b(localp);
                i += 1;
              }
              com.tencent.mm.ui.base.h.a(InviteFacebookFriendsUI.this, 2131758794, 2131755906, 2131755939, 2131755831, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                {
                  AppMethodBeat.i(128031);
                  InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this).ZD();
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
      ((aw)localObject2).ay(5000L, 5000L);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128045);
    super.onCreate(paramBundle);
    setMMTitle(2131758796);
    com.tencent.mm.kernel.g.ajj().a(32, this);
    initView();
    AppMethodBeat.o(128045);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128046);
    com.tencent.mm.kernel.g.ajj().b(32, this);
    this.jmY.dhl();
    super.onDestroy();
    AppMethodBeat.o(128046);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128049);
    ae.i("MicroMsg.InviteFacebookFriendsUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramn.getType() != 32)
    {
      AppMethodBeat.o(128049);
      return;
    }
    if (this.fOC != null)
    {
      this.fOC.dismiss();
      this.fOC = null;
    }
    if ((paramInt1 == 4) && (paramInt2 == -68))
    {
      paramn = paramString;
      if (bu.isNullOrNil(paramString)) {
        paramn = "error";
      }
      bS(getString(2131755906), paramn);
      AppMethodBeat.o(128049);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.jmY.a(null, null);
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
    extends com.tencent.mm.ui.r<com.tencent.mm.plugin.account.friend.a.g>
  {
    String jeI;
    private boolean[] jiB;
    private int[] pq;
    
    public a(Context paramContext, r.a parama)
    {
      super(new com.tencent.mm.plugin.account.friend.a.g());
      AppMethodBeat.i(128038);
      super.a(parama);
      AppMethodBeat.o(128038);
    }
    
    public final void ZD()
    {
      AppMethodBeat.i(128042);
      com.tencent.mm.plugin.account.friend.a.h localh = com.tencent.mm.plugin.account.a.getFacebookFrdStg();
      String str = this.jeI;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" where facebookfriend.status = 102 ");
      if ((str != null) && (str.length() > 0))
      {
        localStringBuilder.append(" and ( ");
        localStringBuilder.append("facebookfriend.fbname like '%" + str + "%' or ");
        localStringBuilder.append("facebookfriend.nickname like '%" + str + "%' or ");
        localStringBuilder.append("facebookfriend.username like '%" + str + "%' ) ");
      }
      setCursor(localh.hKK.a("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend  " + localStringBuilder.toString() + " order by  case when status = 100 then 0  when status = 102 then 3  when status = 101 then 1 else 2 end  , nicknamepyinitial", null, 0));
      this.pq = new int[getCount()];
      this.jiB = new boolean[getCount()];
      super.notifyDataSetChanged();
      AppMethodBeat.o(128042);
    }
    
    public final void ZE()
    {
      AppMethodBeat.i(128043);
      ZD();
      AppMethodBeat.o(128043);
    }
    
    public final long[] aUr()
    {
      AppMethodBeat.i(128040);
      Object localObject = this.jiB;
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
        if (this.jiB[j] == 0) {
          break label108;
        }
        localObject[i] = ((com.tencent.mm.plugin.account.friend.a.g)getItem(j)).eQX;
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
        paramViewGroup.fTj = ((ImageView)paramView.findViewById(2131298722));
        paramViewGroup.jeP = ((TextView)paramView.findViewById(2131303561));
        paramViewGroup.jiE = ((TextView)paramView.findViewById(2131301064));
        paramViewGroup.jiF = ((CheckBox)paramView.findViewById(2131301078));
        paramView.setTag(paramViewGroup);
        paramViewGroup.jeP.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, localg.aTh(), paramViewGroup.jeP.getTextSize()));
        localBitmap = com.tencent.mm.aj.c.Do(localg.eQX);
        if (localBitmap != null) {
          break label221;
        }
        paramViewGroup.fTj.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131690013));
        label165:
        paramViewGroup.jiF.setChecked(this.jiB[paramInt]);
        if (!com.tencent.mm.plugin.account.a.getInviteFriendOpenStg().Kh(Long.toString(localg.eQX))) {
          break label233;
        }
        paramViewGroup.jiE.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(128039);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label221:
        paramViewGroup.fTj.setImageBitmap(localBitmap);
        break label165;
        label233:
        paramViewGroup.jiE.setVisibility(8);
      }
    }
    
    public final void rv(int paramInt)
    {
      AppMethodBeat.i(128041);
      if ((paramInt < 0) || (paramInt >= this.jiB.length))
      {
        AppMethodBeat.o(128041);
        return;
      }
      boolean[] arrayOfBoolean = this.jiB;
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
      ImageView fTj;
      TextView jeP;
      TextView jiE;
      CheckBox jiF;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI
 * JD-Core Version:    0.7.0.1
 */