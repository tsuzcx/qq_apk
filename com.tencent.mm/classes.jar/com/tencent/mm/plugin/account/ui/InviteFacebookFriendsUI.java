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
import com.tencent.mm.ak.n;
import com.tencent.mm.ba.i.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.plugin.account.friend.a.p;
import com.tencent.mm.plugin.account.model.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.g.a.b;
import com.tencent.mm.ui.g.a.c.a;
import com.tencent.mm.ui.r.a;
import com.tencent.mm.ui.tools.r.b;
import java.util.ArrayList;
import java.util.List;

public class InviteFacebookFriendsUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private ProgressDialog fts = null;
  private ListView iIZ;
  private View iJb;
  String iJd;
  a iQX;
  private final int recommendType = 5;
  
  private void bQ(String paramString1, String paramString2)
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
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/account/ui/InviteFacebookFriendsUI$10", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/account/ui/InviteFacebookFriendsUI$10", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        InviteFacebookFriendsUI.this.finish();
        AppMethodBeat.o(128022);
      }
    }, null);
    AppMethodBeat.o(128048);
  }
  
  public int getLayoutId()
  {
    return 2131493996;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128047);
    this.iIZ = ((ListView)findViewById(2131302352));
    Object localObject1 = (TextView)findViewById(2131299468);
    ((TextView)localObject1).setText(2131758789);
    Object localObject2 = new com.tencent.mm.ui.tools.r((byte)0);
    ((com.tencent.mm.ui.tools.r)localObject2).ITM = new r.b()
    {
      public final boolean Ga(String paramAnonymousString)
      {
        return false;
      }
      
      public final void Gb(String paramAnonymousString)
      {
        AppMethodBeat.i(128021);
        InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this, bs.aLh(paramAnonymousString));
        paramAnonymousString = InviteFacebookFriendsUI.this;
        if (paramAnonymousString.iQX != null)
        {
          InviteFacebookFriendsUI.a locala = paramAnonymousString.iQX;
          locala.iIG = bs.aLh(paramAnonymousString.iJd.trim());
          locala.cVi();
          locala.Xb();
        }
        AppMethodBeat.o(128021);
      }
      
      public final void aPa() {}
      
      public final void aPb() {}
      
      public final void aPc() {}
      
      public final void aPd() {}
    };
    addSearchMenu(true, (com.tencent.mm.ui.tools.r)localObject2);
    this.iQX = new a(this, new r.a()
    {
      public final void aPg()
      {
        AppMethodBeat.i(128023);
        if (u.axZ())
        {
          if (InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this).getCount() == 0)
          {
            this.iQI.setVisibility(0);
            AppMethodBeat.o(128023);
            return;
          }
          this.iQI.setVisibility(8);
        }
        AppMethodBeat.o(128023);
      }
    });
    this.iIZ.setAdapter(this.iQX);
    this.iJb = findViewById(2131302353);
    this.iIZ.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(128024);
        if (InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this).aQG().length >= 50)
        {
          com.tencent.mm.ui.base.h.l(InviteFacebookFriendsUI.this, 2131758795, 2131755906);
          AppMethodBeat.o(128024);
          return;
        }
        InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this).qS(paramAnonymousInt - InviteFacebookFriendsUI.b(InviteFacebookFriendsUI.this).getHeaderViewsCount());
        if (InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this).aQG().length > 0)
        {
          InviteFacebookFriendsUI.this.showOptionMenu(true);
          AppMethodBeat.o(128024);
          return;
        }
        InviteFacebookFriendsUI.this.showOptionMenu(false);
        AppMethodBeat.o(128024);
      }
    });
    ac.d("MicroMsg.InviteFacebookFriendsUI", "isBindForFacebookApp:" + u.axZ());
    if (u.axZ())
    {
      this.iIZ.setVisibility(0);
      this.iJb.setVisibility(8);
      long l = bs.g((Long)com.tencent.mm.kernel.g.agR().agA().get(65831, null));
      localObject1 = bs.nullAsNil((String)com.tencent.mm.kernel.g.agR().agA().get(65830, null));
      if ((bs.Ap(l) > 86400000L) && (((String)localObject1).length() > 0))
      {
        localObject2 = new com.tencent.mm.ui.g.a.c(getString(2131758773));
        ((com.tencent.mm.ui.g.a.c)localObject2).aRc((String)localObject1);
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
        }).aOY();
      }
      localObject1 = new ad();
      ((ad)localObject1).aPQ();
      localObject2 = new au(new au.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(128027);
          com.tencent.mm.kernel.g.agR().agA().set(65829, Integer.valueOf(1));
          com.tencent.mm.kernel.g.agi().a(this.iQJ, 0);
          AppMethodBeat.o(128027);
          return false;
        }
      }, false);
      if (bs.m((Integer)com.tencent.mm.kernel.g.agR().agA().get(65829, null)) <= 0) {
        break label441;
      }
      com.tencent.mm.kernel.g.agR().agA().set(65829, Integer.valueOf(1));
      com.tencent.mm.kernel.g.agi().a((n)localObject1, 0);
    }
    for (;;)
    {
      AppCompatActivity localAppCompatActivity = getContext();
      getString(2131755906);
      this.fts = com.tencent.mm.ui.base.h.b(localAppCompatActivity, getString(2131762072), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128028);
          this.iQK.stopTimer();
          com.tencent.mm.kernel.g.agi().a(this.iQJ);
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
          paramAnonymousView = InviteFacebookFriendsUI.b(InviteFacebookFriendsUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
          Object localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.aeD(), "com/tencent/mm/plugin/account/ui/InviteFacebookFriendsUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.c.b((ListView)paramAnonymousView.lR(0));
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
          final long[] arrayOfLong = InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this).aQG();
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
              ac.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite error");
              AppMethodBeat.o(128034);
            }
            
            public final void a(com.tencent.mm.ui.g.a.e paramAnonymous2e)
            {
              AppMethodBeat.i(128033);
              ac.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite error");
              AppMethodBeat.o(128033);
            }
            
            public final void onCancel()
            {
              AppMethodBeat.i(128036);
              ac.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite cancle");
              AppMethodBeat.o(128036);
            }
            
            public final void w(Bundle paramAnonymous2Bundle)
            {
              AppMethodBeat.i(128035);
              ac.i("MicroMsg.InviteFacebookFriendsUI", "fbinvite oncomplete");
              paramAnonymous2Bundle = new ArrayList();
              paramAnonymous2Bundle.add(new i.a(33, Integer.toString(arrayOfLong.length)));
              ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awA().c(new com.tencent.mm.ba.i(paramAnonymous2Bundle));
              paramAnonymous2Bundle = arrayOfLong;
              int j = paramAnonymous2Bundle.length;
              int i = 0;
              while (i < j)
              {
                long l = paramAnonymous2Bundle[i];
                p localp = new p();
                localp.username = Long.toString(l);
                localp.iKK = 5;
                localp.cGa = ((int)bs.aNx());
                com.tencent.mm.plugin.account.a.getInviteFriendOpenStg().b(localp);
                i += 1;
              }
              com.tencent.mm.ui.base.h.b(InviteFacebookFriendsUI.this, 2131758794, 2131755906, 2131755939, 2131755831, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                {
                  AppMethodBeat.i(128031);
                  InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this).Xb();
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
      ((au)localObject2).au(5000L, 5000L);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128045);
    super.onCreate(paramBundle);
    setMMTitle(2131758796);
    com.tencent.mm.kernel.g.agi().a(32, this);
    initView();
    AppMethodBeat.o(128045);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128046);
    com.tencent.mm.kernel.g.agi().b(32, this);
    this.iQX.cVi();
    super.onDestroy();
    AppMethodBeat.o(128046);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128049);
    ac.i("MicroMsg.InviteFacebookFriendsUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramn.getType() != 32)
    {
      AppMethodBeat.o(128049);
      return;
    }
    if (this.fts != null)
    {
      this.fts.dismiss();
      this.fts = null;
    }
    if ((paramInt1 == 4) && (paramInt2 == -68))
    {
      paramn = paramString;
      if (bs.isNullOrNil(paramString)) {
        paramn = "error";
      }
      bQ(getString(2131755906), paramn);
      AppMethodBeat.o(128049);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.iQX.a(null, null);
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
    String iIG;
    private boolean[] iMy;
    private int[] nw;
    
    public a(Context paramContext, r.a parama)
    {
      super(new com.tencent.mm.plugin.account.friend.a.g());
      AppMethodBeat.i(128038);
      super.a(parama);
      AppMethodBeat.o(128038);
    }
    
    public final void Xb()
    {
      AppMethodBeat.i(128042);
      com.tencent.mm.plugin.account.friend.a.h localh = com.tencent.mm.plugin.account.a.getFacebookFrdStg();
      String str = this.iIG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" where facebookfriend.status = 102 ");
      if ((str != null) && (str.length() > 0))
      {
        localStringBuilder.append(" and ( ");
        localStringBuilder.append("facebookfriend.fbname like '%" + str + "%' or ");
        localStringBuilder.append("facebookfriend.nickname like '%" + str + "%' or ");
        localStringBuilder.append("facebookfriend.username like '%" + str + "%' ) ");
      }
      setCursor(localh.hpA.a("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend  " + localStringBuilder.toString() + " order by  case when status = 100 then 0  when status = 102 then 3  when status = 101 then 1 else 2 end  , nicknamepyinitial", null, 0));
      this.nw = new int[getCount()];
      this.iMy = new boolean[getCount()];
      super.notifyDataSetChanged();
      AppMethodBeat.o(128042);
    }
    
    public final void Xc()
    {
      AppMethodBeat.i(128043);
      Xb();
      AppMethodBeat.o(128043);
    }
    
    public final long[] aQG()
    {
      AppMethodBeat.i(128040);
      Object localObject = this.iMy;
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
        if (this.iMy[j] == 0) {
          break label108;
        }
        localObject[i] = ((com.tencent.mm.plugin.account.friend.a.g)getItem(j)).exN;
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
        paramViewGroup.fxQ = ((ImageView)paramView.findViewById(2131298722));
        paramViewGroup.iIN = ((TextView)paramView.findViewById(2131303561));
        paramViewGroup.iMB = ((TextView)paramView.findViewById(2131301064));
        paramViewGroup.iMC = ((CheckBox)paramView.findViewById(2131301078));
        paramView.setTag(paramViewGroup);
        paramViewGroup.iIN.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, localg.aPw(), paramViewGroup.iIN.getTextSize()));
        localBitmap = com.tencent.mm.aj.c.zN(localg.exN);
        if (localBitmap != null) {
          break label221;
        }
        paramViewGroup.fxQ.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131690013));
        label165:
        paramViewGroup.iMC.setChecked(this.iMy[paramInt]);
        if (!com.tencent.mm.plugin.account.a.getInviteFriendOpenStg().Gt(Long.toString(localg.exN))) {
          break label233;
        }
        paramViewGroup.iMB.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(128039);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label221:
        paramViewGroup.fxQ.setImageBitmap(localBitmap);
        break label165;
        label233:
        paramViewGroup.iMB.setVisibility(8);
      }
    }
    
    public final void qS(int paramInt)
    {
      AppMethodBeat.i(128041);
      if ((paramInt < 0) || (paramInt >= this.iMy.length))
      {
        AppMethodBeat.o(128041);
        return;
      }
      boolean[] arrayOfBoolean = this.iMy;
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
      ImageView fxQ;
      TextView iIN;
      TextView iMB;
      CheckBox iMC;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI
 * JD-Core Version:    0.7.0.1
 */