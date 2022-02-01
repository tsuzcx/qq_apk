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
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.g.a.qc.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o.b;
import com.tencent.mm.ui.base.o.c;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class InviteFriendUI
  extends MMActivity
  implements e.a
{
  private ImageView keC;
  private String kgK;
  private int kgL;
  private String kgM;
  private String kgN;
  private String kgO;
  private Button kgP;
  private int kgQ;
  private int kgR;
  private String kgS = null;
  private String kgT = null;
  
  public final void Mr(String paramString)
  {
    AppMethodBeat.i(131246);
    if ((this.kgK == null) || (this.kgK.equals("")))
    {
      AppMethodBeat.o(131246);
      return;
    }
    long l = c.Ma(paramString);
    if ((l > 0L) && (this.kgK.equals(String.valueOf(l))) && (this.kgL == 0)) {
      this.keC.setImageBitmap(c.a(paramString, false, -1, null));
    }
    AppMethodBeat.o(131246);
  }
  
  public int getLayoutId()
  {
    return 2131495078;
  }
  
  public void initView()
  {
    AppMethodBeat.i(131245);
    this.keC = ((ImageView)findViewById(2131302708));
    TextView localTextView1 = (TextView)findViewById(2131302713);
    TextView localTextView3 = (TextView)findViewById(2131302715);
    TextView localTextView2 = (TextView)findViewById(2131302714);
    this.kgP = ((Button)findViewById(2131302711));
    Button localButton = (Button)findViewById(2131302716);
    localTextView1.setText(this.kgM);
    localTextView2.setText(getString(2131761800, new Object[] { this.kgM }));
    Object localObject;
    if (this.kgL == 1)
    {
      this.keC.setBackgroundDrawable(com.tencent.mm.cb.a.l(this, 2131690057));
      localTextView3.setText(getString(2131755823) + this.kgK);
      localObject = com.tencent.mm.b.g.getMessageDigest(this.kgK.getBytes());
      if (!com.tencent.mm.kernel.g.aAh().isSDCardAvailable())
      {
        localObject = com.tencent.mm.aj.p.aYn().cW(MMApplicationContext.getContext());
        if (localObject == null) {
          break label580;
        }
        this.keC.setImageBitmap((Bitmap)localObject);
      }
    }
    else
    {
      label200:
      if (this.kgL == 0)
      {
        this.keC.setBackgroundDrawable(com.tencent.mm.cb.a.l(this, 2131690062));
        localTextView3.setText(getString(2131755828) + this.kgK);
        long l = com.tencent.mm.b.p.fd(this.kgK);
        localObject = null;
        if (l != 0L) {
          localObject = c.Ah(l);
        }
        if (localObject != null) {
          break label596;
        }
        this.keC.setImageDrawable(com.tencent.mm.cb.a.l(this, 2131690062));
        localButton.setVisibility(0);
      }
      label290:
      if (this.kgL == 2)
      {
        this.kgP.setText(2131761407);
        this.keC.setBackgroundDrawable(com.tencent.mm.cb.a.l(this, 2131231960));
        localTextView3.setText(getString(2131755811) + this.kgK);
        if (com.tencent.mm.kernel.g.aAh().isSDCardAvailable()) {
          break label607;
        }
        localObject = com.tencent.mm.aj.p.aYn().cW(MMApplicationContext.getContext());
        label376:
        if (localObject == null) {
          break label618;
        }
        this.keC.setImageBitmap((Bitmap)localObject);
        if (TextUtils.isEmpty(this.kgM))
        {
          localTextView1.setText(Util.subStringEmail(this.kgK));
          localTextView2.setText(getString(2131761800, new Object[] { Util.subStringEmail(this.kgK) }));
        }
      }
      label388:
      if (this.kgL == 3)
      {
        this.kgP.setText(2131761799);
        localObject = u.a(new com.tencent.mm.pluginsdk.ui.tools.e(this.kgT, this.kgT));
        if (localObject == null) {
          break label634;
        }
        this.keC.setImageBitmap((Bitmap)localObject);
      }
    }
    for (;;)
    {
      localButton.setVisibility(8);
      this.kgP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(131238);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
          switch (InviteFriendUI.a(InviteFriendUI.this))
          {
          }
          label767:
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(131238);
            return;
            localObject1 = (String)com.tencent.mm.kernel.g.aAh().azQ().get(42, "");
            if (localObject1 != null)
            {
              paramAnonymousView = (View)localObject1;
              if (((String)localObject1).length() != 0) {}
            }
            else
            {
              paramAnonymousView = (String)com.tencent.mm.kernel.g.aAh().azQ().get(2, "");
            }
            paramAnonymousView = InviteFriendUI.this.getString(2131761818, new Object[] { paramAnonymousView });
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
                localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject3);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                InviteFriendUI.c(InviteFriendUI.this);
              }
            }
            else if (((HashMap)localObject2).size() > 1)
            {
              localObject4 = new com.tencent.mm.ui.tools.l(InviteFriendUI.this);
              ((com.tencent.mm.ui.tools.l)localObject4).HMa = new o.b()
              {
                public final void a(ImageView paramAnonymous2ImageView, MenuItem paramAnonymous2MenuItem)
                {
                  AppMethodBeat.i(131232);
                  paramAnonymous2MenuItem = paramAnonymous2MenuItem.getTitle();
                  paramAnonymous2ImageView.setImageDrawable(((ResolveInfo)this.kgV.get(paramAnonymous2MenuItem)).loadIcon(this.kgW));
                  AppMethodBeat.o(131232);
                }
              };
              ((com.tencent.mm.ui.tools.l)localObject4).HMb = new o.c()
              {
                public final void a(TextView paramAnonymous2TextView, MenuItem paramAnonymous2MenuItem)
                {
                  AppMethodBeat.i(131233);
                  paramAnonymous2MenuItem = paramAnonymous2MenuItem.getTitle();
                  paramAnonymous2MenuItem = ((ResolveInfo)this.kgV.get(paramAnonymous2MenuItem)).loadLabel(this.kgW);
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
              ((com.tencent.mm.ui.tools.l)localObject4).HLX = new o.f()
              {
                public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymous2m)
                {
                  AppMethodBeat.i(131234);
                  Iterator localIterator = this.kgV.keySet().iterator();
                  while (localIterator.hasNext()) {
                    paramAnonymous2m.add((String)localIterator.next());
                  }
                  AppMethodBeat.o(131234);
                }
              };
              ((com.tencent.mm.ui.tools.l)localObject4).HLY = new o.g()
              {
                public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(131235);
                  Object localObject = paramAnonymous2MenuItem.getTitle();
                  paramAnonymous2MenuItem = new Intent();
                  paramAnonymous2MenuItem.setComponent(new ComponentName(((ResolveInfo)this.kgV.get(localObject)).activityInfo.packageName, ((ResolveInfo)this.kgV.get(localObject)).activityInfo.name));
                  paramAnonymous2MenuItem.setAction("android.intent.action.SENDTO");
                  paramAnonymous2MenuItem.setData(this.kgY);
                  paramAnonymous2MenuItem.putExtra("sms_body", paramAnonymousView);
                  localObject = InviteFriendUI.this;
                  paramAnonymous2MenuItem = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymous2MenuItem);
                  com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymous2MenuItem.axQ(), "com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$1$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  ((InviteFriendUI)localObject).startActivity((Intent)paramAnonymous2MenuItem.pG(0));
                  com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$1$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  AppMethodBeat.o(131235);
                }
              };
              ((com.tencent.mm.ui.tools.l)localObject4).gXI();
              InviteFriendUI.c(InviteFriendUI.this);
            }
            else
            {
              Toast.makeText(InviteFriendUI.this, 2131765173, 1).show();
              continue;
              int i = com.tencent.mm.b.p.fd(InviteFriendUI.b(InviteFriendUI.this));
              new g(InviteFriendUI.this, new g.a()
              {
                public final void i(boolean paramAnonymous2Boolean, String paramAnonymous2String)
                {
                  AppMethodBeat.i(131236);
                  if (paramAnonymous2Boolean) {
                    InviteFriendUI.this.finish();
                  }
                  AppMethodBeat.o(131236);
                }
              }).t(new int[] { i });
              continue;
              paramAnonymousView = new h(InviteFriendUI.this, new h.a()
              {
                public final void gn(boolean paramAnonymous2Boolean)
                {
                  AppMethodBeat.i(131237);
                  if (paramAnonymous2Boolean) {
                    ((o)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).aF(InviteFriendUI.d(InviteFriendUI.this), 1);
                  }
                  AppMethodBeat.o(131237);
                }
              });
              localObject2 = InviteFriendUI.e(InviteFriendUI.this);
              localObject1 = InviteFriendUI.b(InviteFriendUI.this);
              com.tencent.mm.kernel.g.azz().a(489, paramAnonymousView);
              localObject2 = ((o)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).Td((String)localObject2);
              if ((localObject2 == null) || (((Cursor)localObject2).getCount() <= 1)) {
                paramAnonymousView.Tl((String)localObject1);
              }
              for (;;)
              {
                if (localObject2 == null) {
                  break label767;
                }
                ((Cursor)localObject2).close();
                break;
                paramAnonymousView.c((Cursor)localObject2);
              }
            }
          }
        }
      });
      localButton.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(131239);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = new qc();
          paramAnonymousView.dWm.opType = 0;
          paramAnonymousView.dWm.dWo = (InviteFriendUI.b(InviteFriendUI.this) + "@qqim");
          paramAnonymousView.dWm.dWp = InviteFriendUI.f(InviteFriendUI.this);
          EventCenter.instance.publish(paramAnonymousView);
          if (paramAnonymousView.dWn.dFE) {
            com.tencent.mm.plugin.account.a.a.jRt.d(new Intent().putExtra("Chat_User", InviteFriendUI.b(InviteFriendUI.this) + "@qqim"), InviteFriendUI.this);
          }
          InviteFriendUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
      localObject = ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).SU((String)localObject);
      if (localObject != null)
      {
        localObject = com.tencent.mm.plugin.account.friend.a.l.a(((com.tencent.mm.plugin.account.friend.a.a)localObject).bnJ(), this);
        break;
      }
      localObject = null;
      break;
      label580:
      this.keC.setImageDrawable(com.tencent.mm.cb.a.l(this, 2131690057));
      break label200;
      label596:
      this.keC.setImageBitmap((Bitmap)localObject);
      break label290;
      label607:
      localObject = c.LV(this.kgN);
      break label376;
      label618:
      this.keC.setImageDrawable(com.tencent.mm.cb.a.l(this, 2131231960));
      break label388;
      label634:
      this.keC.setImageResource(2131690042);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(131241);
    super.onCreate(paramBundle);
    setMMTitle(2131761802);
    paramBundle = getIntent();
    this.kgL = paramBundle.getIntExtra("friend_type", -1);
    this.kgM = paramBundle.getStringExtra("friend_nick");
    this.kgK = paramBundle.getStringExtra("friend_num");
    this.kgN = paramBundle.getStringExtra("friend_googleID");
    this.kgO = paramBundle.getStringExtra("friend_googleItemID");
    this.kgK = Util.nullAsNil(this.kgK);
    this.kgS = paramBundle.getStringExtra("friend_linkedInID");
    this.kgT = paramBundle.getStringExtra("friend_linkedInPicUrl");
    initView();
    this.kgQ = paramBundle.getIntExtra("search_kvstat_scene", 0);
    this.kgR = paramBundle.getIntExtra("search_kvstat_position", 0);
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
    com.tencent.mm.aj.p.aYn().e(this);
    AppMethodBeat.o(131242);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(131243);
    super.onResume();
    com.tencent.mm.aj.p.aYn().d(this);
    AppMethodBeat.o(131243);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.InviteFriendUI
 * JD-Core Version:    0.7.0.1
 */