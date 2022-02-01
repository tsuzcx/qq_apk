package com.tencent.mm.plugin.account.friend.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.or;
import com.tencent.mm.g.a.or.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.account.friend.a.b;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.a;
import com.tencent.mm.ui.base.n.b;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class InviteFriendUI
  extends MMActivity
  implements e.a
{
  private ImageView ikp;
  private int imA;
  private String imB;
  private String imC;
  private String imD;
  private Button imE;
  private int imF;
  private int imG;
  private String imH = null;
  private String imI = null;
  private String imz;
  
  public int getLayoutId()
  {
    return 2131494486;
  }
  
  public void initView()
  {
    AppMethodBeat.i(131245);
    this.ikp = ((ImageView)findViewById(2131301054));
    TextView localTextView1 = (TextView)findViewById(2131301059);
    TextView localTextView3 = (TextView)findViewById(2131301061);
    TextView localTextView2 = (TextView)findViewById(2131301060);
    this.imE = ((Button)findViewById(2131301057));
    Button localButton = (Button)findViewById(2131301062);
    localTextView1.setText(this.imB);
    localTextView2.setText(getString(2131760355, new Object[] { this.imB }));
    Object localObject;
    if (this.imA == 1)
    {
      this.ikp.setBackgroundDrawable(com.tencent.mm.cd.a.l(this, 2131690027));
      localTextView3.setText(getString(2131755748) + this.imz);
      localObject = com.tencent.mm.b.g.getMessageDigest(this.imz.getBytes());
      if (!com.tencent.mm.kernel.g.afB().isSDCardAvailable())
      {
        localObject = com.tencent.mm.ak.p.auq().cs(aj.getContext());
        if (localObject == null) {
          break label579;
        }
        this.ikp.setImageBitmap((Bitmap)localObject);
      }
    }
    else
    {
      label200:
      if (this.imA == 0)
      {
        this.ikp.setBackgroundDrawable(com.tencent.mm.cd.a.l(this, 2131690032));
        localTextView3.setText(getString(2131755753) + this.imz);
        long l = com.tencent.mm.b.p.dG(this.imz);
        localObject = null;
        if (l != 0L) {
          localObject = c.mb(l);
        }
        if (localObject != null) {
          break label595;
        }
        this.ikp.setImageDrawable(com.tencent.mm.cd.a.l(this, 2131690032));
        localButton.setVisibility(0);
      }
      label290:
      if (this.imA == 2)
      {
        this.imE.setText(2131760029);
        this.ikp.setBackgroundDrawable(com.tencent.mm.cd.a.l(this, 2131231878));
        localTextView3.setText(getString(2131755739) + this.imz);
        if (com.tencent.mm.kernel.g.afB().isSDCardAvailable()) {
          break label606;
        }
        localObject = com.tencent.mm.ak.p.auq().cs(aj.getContext());
        label376:
        if (localObject == null) {
          break label617;
        }
        this.ikp.setImageBitmap((Bitmap)localObject);
        if (TextUtils.isEmpty(this.imB))
        {
          localTextView1.setText(bt.aGr(this.imz));
          localTextView2.setText(getString(2131760355, new Object[] { bt.aGr(this.imz) }));
        }
      }
      label388:
      if (this.imA == 3)
      {
        this.imE.setText(2131760354);
        localObject = u.a(new com.tencent.mm.pluginsdk.ui.tools.e(this.imI, this.imI));
        if (localObject == null) {
          break label633;
        }
        this.ikp.setImageBitmap((Bitmap)localObject);
      }
    }
    for (;;)
    {
      localButton.setVisibility(8);
      this.imE.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(131238);
          switch (InviteFriendUI.a(InviteFriendUI.this))
          {
          }
          label739:
          for (;;)
          {
            AppMethodBeat.o(131238);
            return;
            Object localObject1 = (String)com.tencent.mm.kernel.g.afB().afk().get(42, "");
            if (localObject1 != null)
            {
              paramAnonymousView = (View)localObject1;
              if (((String)localObject1).length() != 0) {}
            }
            else
            {
              paramAnonymousView = (String)com.tencent.mm.kernel.g.afB().afk().get(2, "");
            }
            paramAnonymousView = InviteFriendUI.this.getString(2131760373, new Object[] { paramAnonymousView });
            localObject1 = Uri.parse("smsto:" + InviteFriendUI.b(InviteFriendUI.this));
            Object localObject2 = new Intent("android.intent.action.SENDTO", (Uri)localObject1);
            ((Intent)localObject2).putExtra("sms_body", paramAnonymousView);
            Object localObject3 = InviteFriendUI.this.getPackageManager();
            Object localObject4 = ((PackageManager)localObject3).queryIntentActivities((Intent)localObject2, 65536);
            localObject2 = new HashMap();
            localObject4 = ((List)localObject4).iterator();
            while (((Iterator)localObject4).hasNext())
            {
              ResolveInfo localResolveInfo = (ResolveInfo)((Iterator)localObject4).next();
              if (!localResolveInfo.activityInfo.packageName.equals("com.whatsapp")) {
                ((HashMap)localObject2).put(localResolveInfo.activityInfo.name, localResolveInfo);
              }
            }
            if (((HashMap)localObject2).size() == 1)
            {
              localObject3 = ((HashMap)localObject2).keySet().iterator();
              if (((Iterator)localObject3).hasNext())
              {
                localObject4 = (String)((Iterator)localObject3).next();
                localObject3 = new Intent();
                ((Intent)localObject3).setComponent(new ComponentName(((ResolveInfo)((HashMap)localObject2).get(localObject4)).activityInfo.packageName, ((ResolveInfo)((HashMap)localObject2).get(localObject4)).activityInfo.name));
                ((Intent)localObject3).setAction("android.intent.action.SENDTO");
                ((Intent)localObject3).setData((Uri)localObject1);
                ((Intent)localObject3).putExtra("sms_body", paramAnonymousView);
                paramAnonymousView = InviteFriendUI.this;
                localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject3);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                InviteFriendUI.c(InviteFriendUI.this);
              }
              AppMethodBeat.o(131238);
              return;
            }
            if (((HashMap)localObject2).size() > 1)
            {
              localObject4 = new com.tencent.mm.ui.tools.l(InviteFriendUI.this);
              ((com.tencent.mm.ui.tools.l)localObject4).Hsb = new n.a()
              {
                public final void a(ImageView paramAnonymous2ImageView, MenuItem paramAnonymous2MenuItem)
                {
                  AppMethodBeat.i(131232);
                  paramAnonymous2MenuItem = paramAnonymous2MenuItem.getTitle();
                  paramAnonymous2ImageView.setImageDrawable(((ResolveInfo)this.imK.get(paramAnonymous2MenuItem)).loadIcon(this.imL));
                  AppMethodBeat.o(131232);
                }
              };
              ((com.tencent.mm.ui.tools.l)localObject4).Hsc = new n.b()
              {
                public final void a(TextView paramAnonymous2TextView, MenuItem paramAnonymous2MenuItem)
                {
                  AppMethodBeat.i(131233);
                  paramAnonymous2MenuItem = paramAnonymous2MenuItem.getTitle();
                  paramAnonymous2MenuItem = ((ResolveInfo)this.imK.get(paramAnonymous2MenuItem)).loadLabel(this.imL);
                  if (paramAnonymous2MenuItem != null)
                  {
                    paramAnonymous2TextView.setText(paramAnonymous2MenuItem.toString());
                    AppMethodBeat.o(131233);
                    return;
                  }
                  paramAnonymous2TextView.setText("");
                  AppMethodBeat.o(131233);
                }
              };
              ((com.tencent.mm.ui.tools.l)localObject4).HrX = new n.c()
              {
                public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
                {
                  AppMethodBeat.i(131234);
                  Iterator localIterator = this.imK.keySet().iterator();
                  while (localIterator.hasNext()) {
                    paramAnonymous2l.add((String)localIterator.next());
                  }
                  AppMethodBeat.o(131234);
                }
              };
              ((com.tencent.mm.ui.tools.l)localObject4).HrY = new n.d()
              {
                public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(131235);
                  Object localObject = paramAnonymous2MenuItem.getTitle();
                  paramAnonymous2MenuItem = new Intent();
                  paramAnonymous2MenuItem.setComponent(new ComponentName(((ResolveInfo)this.imK.get(localObject)).activityInfo.packageName, ((ResolveInfo)this.imK.get(localObject)).activityInfo.name));
                  paramAnonymous2MenuItem.setAction("android.intent.action.SENDTO");
                  paramAnonymous2MenuItem.setData(this.imN);
                  paramAnonymous2MenuItem.putExtra("sms_body", paramAnonymousView);
                  localObject = InviteFriendUI.this;
                  paramAnonymous2MenuItem = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymous2MenuItem);
                  com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymous2MenuItem.adn(), "com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$1$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  ((InviteFriendUI)localObject).startActivity((Intent)paramAnonymous2MenuItem.lS(0));
                  com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$1$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  AppMethodBeat.o(131235);
                }
              };
              ((com.tencent.mm.ui.tools.l)localObject4).fdQ();
              InviteFriendUI.c(InviteFriendUI.this);
              AppMethodBeat.o(131238);
              return;
            }
            Toast.makeText(InviteFriendUI.this, 2131763024, 1).show();
            AppMethodBeat.o(131238);
            return;
            int i = com.tencent.mm.b.p.dG(InviteFriendUI.b(InviteFriendUI.this));
            new g(InviteFriendUI.this, new g.a()
            {
              public final void f(boolean paramAnonymous2Boolean, String paramAnonymous2String)
              {
                AppMethodBeat.i(131236);
                if (paramAnonymous2Boolean) {
                  InviteFriendUI.this.finish();
                }
                AppMethodBeat.o(131236);
              }
            }).q(new int[] { i });
            AppMethodBeat.o(131238);
            return;
            paramAnonymousView = new h(InviteFriendUI.this, new h.a()
            {
              public final void eV(boolean paramAnonymous2Boolean)
              {
                AppMethodBeat.i(131237);
                if (paramAnonymous2Boolean) {
                  ((o)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).au(InviteFriendUI.d(InviteFriendUI.this), 1);
                }
                AppMethodBeat.o(131237);
              }
            });
            localObject2 = InviteFriendUI.e(InviteFriendUI.this);
            localObject1 = InviteFriendUI.b(InviteFriendUI.this);
            com.tencent.mm.kernel.g.aeS().a(489, paramAnonymousView);
            localObject2 = ((o)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).Co((String)localObject2);
            if ((localObject2 == null) || (((Cursor)localObject2).getCount() <= 1)) {
              paramAnonymousView.Cw((String)localObject1);
            }
            for (;;)
            {
              if (localObject2 == null) {
                break label739;
              }
              ((Cursor)localObject2).close();
              break;
              paramAnonymousView.d((Cursor)localObject2);
            }
          }
        }
      });
      localButton.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(131239);
          paramAnonymousView = new or();
          paramAnonymousView.dtR.opType = 0;
          paramAnonymousView.dtR.dtT = (InviteFriendUI.b(InviteFriendUI.this) + "@qqim");
          paramAnonymousView.dtR.dtU = InviteFriendUI.f(InviteFriendUI.this);
          com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousView);
          if (paramAnonymousView.dtS.dew) {
            com.tencent.mm.plugin.account.a.a.hYt.d(new Intent().putExtra("Chat_User", InviteFriendUI.b(InviteFriendUI.this) + "@qqim"), InviteFriendUI.this);
          }
          InviteFriendUI.this.finish();
          AppMethodBeat.o(131239);
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(131240);
          InviteFriendUI.this.finish();
          AppMethodBeat.o(131240);
          return true;
        }
      });
      AppMethodBeat.o(131245);
      return;
      localObject = ((b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).Cf((String)localObject);
      if (localObject != null)
      {
        localObject = com.tencent.mm.plugin.account.friend.a.l.a(((com.tencent.mm.plugin.account.friend.a.a)localObject).aIu(), this);
        break;
      }
      localObject = null;
      break;
      label579:
      this.ikp.setImageDrawable(com.tencent.mm.cd.a.l(this, 2131690027));
      break label200;
      label595:
      this.ikp.setImageBitmap((Bitmap)localObject);
      break label290;
      label606:
      localObject = c.vE(this.imC);
      break label376;
      label617:
      this.ikp.setImageDrawable(com.tencent.mm.cd.a.l(this, 2131231878));
      break label388;
      label633:
      this.ikp.setImageResource(2131690013);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(131241);
    super.onCreate(paramBundle);
    setMMTitle(2131760357);
    paramBundle = getIntent();
    this.imA = paramBundle.getIntExtra("friend_type", -1);
    this.imB = paramBundle.getStringExtra("friend_nick");
    this.imz = paramBundle.getStringExtra("friend_num");
    this.imC = paramBundle.getStringExtra("friend_googleID");
    this.imD = paramBundle.getStringExtra("friend_googleItemID");
    this.imz = bt.nullAsNil(this.imz);
    this.imH = paramBundle.getStringExtra("friend_linkedInID");
    this.imI = paramBundle.getStringExtra("friend_linkedInPicUrl");
    initView();
    this.imF = paramBundle.getIntExtra("search_kvstat_scene", 0);
    this.imG = paramBundle.getIntExtra("search_kvstat_position", 0);
    AppMethodBeat.o(131241);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(131244);
    super.onDestroy();
    AppMethodBeat.o(131244);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(131242);
    super.onPause();
    com.tencent.mm.ak.p.auq().e(this);
    AppMethodBeat.o(131242);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(131243);
    super.onResume();
    com.tencent.mm.ak.p.auq().d(this);
    AppMethodBeat.o(131243);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void vZ(String paramString)
  {
    AppMethodBeat.i(131246);
    if ((this.imz == null) || (this.imz.equals("")))
    {
      AppMethodBeat.o(131246);
      return;
    }
    long l = c.vJ(paramString);
    if ((l > 0L) && (this.imz.equals(String.valueOf(l))) && (this.imA == 0)) {
      this.ikp.setImageBitmap(c.a(paramString, false, -1, null));
    }
    AppMethodBeat.o(131246);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.InviteFriendUI
 * JD-Core Version:    0.7.0.1
 */