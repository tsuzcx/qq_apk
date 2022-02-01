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
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.ba.i.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.plugin.account.friend.a.p;
import com.tencent.mm.plugin.account.model.k;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.h.a.c.a;
import com.tencent.mm.ui.s.a;
import com.tencent.mm.ui.tools.s.b;
import java.util.ArrayList;
import java.util.List;

public class InviteFacebookFriendsUI
  extends MMActivity
  implements com.tencent.mm.ak.i
{
  private ProgressDialog gtM = null;
  private ListView kde;
  private View kdg;
  String kdi;
  a klh;
  private final int recommendType = 5;
  
  private void cb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(128048);
    com.tencent.mm.ui.base.h.a(this, paramString2, paramString1, new InviteFacebookFriendsUI.2(this), null);
    AppMethodBeat.o(128048);
  }
  
  public int getLayoutId()
  {
    return 2131494166;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128047);
    this.kde = ((ListView)findViewById(2131304749));
    Object localObject1 = (TextView)findViewById(2131300096);
    ((TextView)localObject1).setText(2131759110);
    Object localObject2 = new com.tencent.mm.ui.tools.s((byte)0);
    ((com.tencent.mm.ui.tools.s)localObject2).Qwi = new s.b()
    {
      public final boolean SN(String paramAnonymousString)
      {
        return false;
      }
      
      public final void SO(String paramAnonymousString)
      {
        AppMethodBeat.i(128021);
        InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this, Util.escapeSqlValue(paramAnonymousString));
        paramAnonymousString = InviteFacebookFriendsUI.this;
        if (paramAnonymousString.klh != null)
        {
          InviteFacebookFriendsUI.a locala = paramAnonymousString.klh;
          locala.kcL = Util.escapeSqlValue(paramAnonymousString.kdi.trim());
          locala.ebf();
          locala.anp();
        }
        AppMethodBeat.o(128021);
      }
      
      public final void bnA() {}
      
      public final void bnB() {}
      
      public final void bny() {}
      
      public final void bnz() {}
    };
    addSearchMenu(true, (com.tencent.mm.ui.tools.s)localObject2);
    this.klh = new a(this, new s.a()
    {
      public final void bnE()
      {
        AppMethodBeat.i(128023);
        if (z.aUF())
        {
          if (InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this).getCount() == 0)
          {
            this.kkS.setVisibility(0);
            AppMethodBeat.o(128023);
            return;
          }
          this.kkS.setVisibility(8);
        }
        AppMethodBeat.o(128023);
      }
    });
    this.kde.setAdapter(this.klh);
    this.kdg = findViewById(2131304750);
    this.kde.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(128024);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/InviteFacebookFriendsUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        if (InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this).bpe().length >= 50)
        {
          com.tencent.mm.ui.base.h.n(InviteFacebookFriendsUI.this, 2131759116, 2131755998);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/InviteFacebookFriendsUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(128024);
          return;
        }
        InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this).vl(paramAnonymousInt - InviteFacebookFriendsUI.b(InviteFacebookFriendsUI.this).getHeaderViewsCount());
        if (InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this).bpe().length > 0) {
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
    Log.d("MicroMsg.InviteFacebookFriendsUI", "isBindForFacebookApp:" + z.aUF());
    if (z.aUF())
    {
      this.kde.setVisibility(0);
      this.kdg.setVisibility(8);
      long l = Util.nullAsNil((Long)com.tencent.mm.kernel.g.aAh().azQ().get(65831, null));
      localObject1 = Util.nullAsNil((String)com.tencent.mm.kernel.g.aAh().azQ().get(65830, null));
      if ((Util.milliSecondsToNow(l) > 86400000L) && (((String)localObject1).length() > 0))
      {
        localObject2 = new com.tencent.mm.ui.h.a.c(getString(2131759094));
        ((com.tencent.mm.ui.h.a.c)localObject2).bnE((String)localObject1);
        new k((com.tencent.mm.ui.h.a.c)localObject2, new com.tencent.mm.plugin.account.model.l()
        {
          public final void E(Bundle paramAnonymousBundle)
          {
            AppMethodBeat.i(128025);
            super.E(paramAnonymousBundle);
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
        }).bnw();
      }
      localObject1 = new ad();
      ((ad)localObject1).bon();
      localObject2 = new MTimerHandler(new InviteFacebookFriendsUI.6(this, (ad)localObject1), false);
      if (Util.nullAsNil((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(65829, null)) <= 0) {
        break label439;
      }
      com.tencent.mm.kernel.g.aAh().azQ().set(65829, Integer.valueOf(1));
      com.tencent.mm.kernel.g.azz().a((com.tencent.mm.ak.q)localObject1, 0);
    }
    for (;;)
    {
      AppCompatActivity localAppCompatActivity = getContext();
      getString(2131755998);
      this.gtM = com.tencent.mm.ui.base.h.a(localAppCompatActivity, getString(2131764090), true, new InviteFacebookFriendsUI.7(this, (MTimerHandler)localObject2, (ad)localObject1));
      setBackBtn(new InviteFacebookFriendsUI.8(this));
      setToTop(new InviteFacebookFriendsUI.9(this));
      addTextOptionMenu(0, getString(2131759114), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(128037);
          com.tencent.mm.ui.h.a.c localc = new com.tencent.mm.ui.h.a.c(InviteFacebookFriendsUI.this.getString(2131759094));
          Bundle localBundle = new Bundle();
          localBundle.putString("message", InviteFacebookFriendsUI.this.getString(2131759113));
          final long[] arrayOfLong = InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this).bpe();
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
            public final void E(Bundle paramAnonymous2Bundle)
            {
              AppMethodBeat.i(128035);
              Log.i("MicroMsg.InviteFacebookFriendsUI", "fbinvite oncomplete");
              paramAnonymous2Bundle = new ArrayList();
              paramAnonymous2Bundle.add(new i.a(33, Integer.toString(arrayOfLong.length)));
              ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new com.tencent.mm.ba.i(paramAnonymous2Bundle));
              paramAnonymous2Bundle = arrayOfLong;
              int j = paramAnonymous2Bundle.length;
              int i = 0;
              while (i < j)
              {
                long l = paramAnonymous2Bundle[i];
                p localp = new p();
                localp.username = Long.toString(l);
                localp.keQ = 5;
                localp.dii = ((int)Util.nowSecond());
                com.tencent.mm.plugin.account.a.getInviteFriendOpenStg().b(localp);
                i += 1;
              }
              com.tencent.mm.ui.base.h.a(InviteFacebookFriendsUI.this, 2131759115, 2131755998, 2131756033, 2131755917, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                {
                  AppMethodBeat.i(128031);
                  InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this).anp();
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
            
            public final void a(com.tencent.mm.ui.h.a.b paramAnonymous2b)
            {
              AppMethodBeat.i(128034);
              Log.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite error");
              AppMethodBeat.o(128034);
            }
            
            public final void a(com.tencent.mm.ui.h.a.e paramAnonymous2e)
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
      label439:
      ((MTimerHandler)localObject2).startTimer(5000L);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128045);
    super.onCreate(paramBundle);
    setMMTitle(2131759117);
    com.tencent.mm.kernel.g.azz().a(32, this);
    initView();
    AppMethodBeat.o(128045);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128046);
    com.tencent.mm.kernel.g.azz().b(32, this);
    this.klh.ebf();
    super.onDestroy();
    AppMethodBeat.o(128046);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(128049);
    Log.i("MicroMsg.InviteFacebookFriendsUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramq.getType() != 32)
    {
      AppMethodBeat.o(128049);
      return;
    }
    if (this.gtM != null)
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    if ((paramInt1 == 4) && (paramInt2 == -68))
    {
      paramq = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramq = "error";
      }
      cb(getString(2131755998), paramq);
      AppMethodBeat.o(128049);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.klh.onNotifyChange(null, null);
      AppMethodBeat.o(128049);
      return;
    }
    Toast.makeText(this, 2131763076, 0).show();
    AppMethodBeat.o(128049);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static final class a
    extends com.tencent.mm.ui.s<com.tencent.mm.plugin.account.friend.a.g>
  {
    String kcL;
    private boolean[] kgD;
    private int[] pt;
    
    public a(Context paramContext, s.a parama)
    {
      super(new com.tencent.mm.plugin.account.friend.a.g());
      AppMethodBeat.i(128038);
      super.a(parama);
      AppMethodBeat.o(128038);
    }
    
    public final void anp()
    {
      AppMethodBeat.i(128042);
      com.tencent.mm.plugin.account.friend.a.h localh = com.tencent.mm.plugin.account.a.getFacebookFrdStg();
      String str = this.kcL;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" where facebookfriend.status = 102 ");
      if ((str != null) && (str.length() > 0))
      {
        localStringBuilder.append(" and ( ");
        localStringBuilder.append("facebookfriend.fbname like '%" + str + "%' or ");
        localStringBuilder.append("facebookfriend.nickname like '%" + str + "%' or ");
        localStringBuilder.append("facebookfriend.username like '%" + str + "%' ) ");
      }
      setCursor(localh.iFy.rawQuery("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend  " + localStringBuilder.toString() + " order by  case when status = 100 then 0  when status = 102 then 3  when status = 101 then 1 else 2 end  , nicknamepyinitial", null));
      this.pt = new int[getCount()];
      this.kgD = new boolean[getCount()];
      super.notifyDataSetChanged();
      AppMethodBeat.o(128042);
    }
    
    public final void anq()
    {
      AppMethodBeat.i(128043);
      anp();
      AppMethodBeat.o(128043);
    }
    
    public final long[] bpe()
    {
      AppMethodBeat.i(128040);
      Object localObject = this.kgD;
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
        if (this.kgD[j] == 0) {
          break label108;
        }
        localObject[i] = ((com.tencent.mm.plugin.account.friend.a.g)getItem(j)).fuC;
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
        paramView = View.inflate(this.context, 2131494098, null);
        paramViewGroup.gyr = ((ImageView)paramView.findViewById(2131299160));
        paramViewGroup.kcS = ((TextView)paramView.findViewById(2131306336));
        paramViewGroup.kgG = ((TextView)paramView.findViewById(2131302718));
        paramViewGroup.kgH = ((CheckBox)paramView.findViewById(2131302732));
        paramView.setTag(paramViewGroup);
        paramViewGroup.kcS.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, localg.bnT(), paramViewGroup.kcS.getTextSize()));
        localBitmap = com.tencent.mm.aj.c.LY(localg.fuC);
        if (localBitmap != null) {
          break label221;
        }
        paramViewGroup.gyr.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131690042));
        label165:
        paramViewGroup.kgH.setChecked(this.kgD[paramInt]);
        if (!com.tencent.mm.plugin.account.a.getInviteFriendOpenStg().Tf(Long.toString(localg.fuC))) {
          break label233;
        }
        paramViewGroup.kgG.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(128039);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label221:
        paramViewGroup.gyr.setImageBitmap(localBitmap);
        break label165;
        label233:
        paramViewGroup.kgG.setVisibility(8);
      }
    }
    
    public final void vl(int paramInt)
    {
      AppMethodBeat.i(128041);
      if ((paramInt < 0) || (paramInt >= this.kgD.length))
      {
        AppMethodBeat.o(128041);
        return;
      }
      boolean[] arrayOfBoolean = this.kgD;
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
      ImageView gyr;
      TextView kcS;
      TextView kgG;
      CheckBox kgH;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI
 * JD-Core Version:    0.7.0.1
 */