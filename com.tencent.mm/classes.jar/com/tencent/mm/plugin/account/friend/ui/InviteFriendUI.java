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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.pa;
import com.tencent.mm.g.a.pa.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.account.friend.a.b;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
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
  private ImageView iKw;
  private String iMF;
  private int iMG;
  private String iMH;
  private String iMI;
  private String iMJ;
  private Button iMK;
  private int iML;
  private int iMM;
  private String iMN = null;
  private String iMO = null;
  
  public final void Af(String paramString)
  {
    AppMethodBeat.i(131246);
    if ((this.iMF == null) || (this.iMF.equals("")))
    {
      AppMethodBeat.o(131246);
      return;
    }
    long l = c.zP(paramString);
    if ((l > 0L) && (this.iMF.equals(String.valueOf(l))) && (this.iMG == 0)) {
      this.iKw.setImageBitmap(c.a(paramString, false, -1, null));
    }
    AppMethodBeat.o(131246);
  }
  
  public int getLayoutId()
  {
    return 2131494486;
  }
  
  public void initView()
  {
    AppMethodBeat.i(131245);
    this.iKw = ((ImageView)findViewById(2131301054));
    TextView localTextView1 = (TextView)findViewById(2131301059);
    TextView localTextView3 = (TextView)findViewById(2131301061);
    TextView localTextView2 = (TextView)findViewById(2131301060);
    this.iMK = ((Button)findViewById(2131301057));
    Button localButton = (Button)findViewById(2131301062);
    localTextView1.setText(this.iMH);
    localTextView2.setText(getString(2131760355, new Object[] { this.iMH }));
    Object localObject;
    if (this.iMG == 1)
    {
      this.iKw.setBackgroundDrawable(com.tencent.mm.cc.a.l(this, 2131690027));
      localTextView3.setText(getString(2131755748) + this.iMF);
      localObject = com.tencent.mm.b.g.getMessageDigest(this.iMF.getBytes());
      if (!com.tencent.mm.kernel.g.agR().isSDCardAvailable())
      {
        localObject = com.tencent.mm.aj.p.aBh().cB(ai.getContext());
        if (localObject == null) {
          break label580;
        }
        this.iKw.setImageBitmap((Bitmap)localObject);
      }
    }
    else
    {
      label200:
      if (this.iMG == 0)
      {
        this.iKw.setBackgroundDrawable(com.tencent.mm.cc.a.l(this, 2131690032));
        localTextView3.setText(getString(2131755753) + this.iMF);
        long l = com.tencent.mm.b.p.dv(this.iMF);
        localObject = null;
        if (l != 0L) {
          localObject = c.pP(l);
        }
        if (localObject != null) {
          break label596;
        }
        this.iKw.setImageDrawable(com.tencent.mm.cc.a.l(this, 2131690032));
        localButton.setVisibility(0);
      }
      label290:
      if (this.iMG == 2)
      {
        this.iMK.setText(2131760029);
        this.iKw.setBackgroundDrawable(com.tencent.mm.cc.a.l(this, 2131231878));
        localTextView3.setText(getString(2131755739) + this.iMF);
        if (com.tencent.mm.kernel.g.agR().isSDCardAvailable()) {
          break label607;
        }
        localObject = com.tencent.mm.aj.p.aBh().cB(ai.getContext());
        label376:
        if (localObject == null) {
          break label618;
        }
        this.iKw.setImageBitmap((Bitmap)localObject);
        if (TextUtils.isEmpty(this.iMH))
        {
          localTextView1.setText(bs.aLI(this.iMF));
          localTextView2.setText(getString(2131760355, new Object[] { bs.aLI(this.iMF) }));
        }
      }
      label388:
      if (this.iMG == 3)
      {
        this.iMK.setText(2131760354);
        localObject = u.a(new com.tencent.mm.pluginsdk.ui.tools.e(this.iMO, this.iMO));
        if (localObject == null) {
          break label634;
        }
        this.iKw.setImageBitmap((Bitmap)localObject);
      }
    }
    for (;;)
    {
      localButton.setVisibility(8);
      this.iMK.setOnClickListener(new View.OnClickListener()
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
            Object localObject1 = (String)com.tencent.mm.kernel.g.agR().agA().get(42, "");
            if (localObject1 != null)
            {
              paramAnonymousView = (View)localObject1;
              if (((String)localObject1).length() != 0) {}
            }
            else
            {
              paramAnonymousView = (String)com.tencent.mm.kernel.g.agR().agA().get(2, "");
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
                localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject3);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                InviteFriendUI.c(InviteFriendUI.this);
              }
              AppMethodBeat.o(131238);
              return;
            }
            if (((HashMap)localObject2).size() > 1)
            {
              localObject4 = new com.tencent.mm.ui.tools.l(InviteFriendUI.this);
              ((com.tencent.mm.ui.tools.l)localObject4).ISy = new n.a()
              {
                public final void a(ImageView paramAnonymous2ImageView, MenuItem paramAnonymous2MenuItem)
                {
                  AppMethodBeat.i(131232);
                  paramAnonymous2MenuItem = paramAnonymous2MenuItem.getTitle();
                  paramAnonymous2ImageView.setImageDrawable(((ResolveInfo)this.iMQ.get(paramAnonymous2MenuItem)).loadIcon(this.iMR));
                  AppMethodBeat.o(131232);
                }
              };
              ((com.tencent.mm.ui.tools.l)localObject4).ISz = new n.b()
              {
                public final void a(TextView paramAnonymous2TextView, MenuItem paramAnonymous2MenuItem)
                {
                  AppMethodBeat.i(131233);
                  paramAnonymous2MenuItem = paramAnonymous2MenuItem.getTitle();
                  paramAnonymous2MenuItem = ((ResolveInfo)this.iMQ.get(paramAnonymous2MenuItem)).loadLabel(this.iMR);
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
              ((com.tencent.mm.ui.tools.l)localObject4).ISu = new n.c()
              {
                public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
                {
                  AppMethodBeat.i(131234);
                  Iterator localIterator = this.iMQ.keySet().iterator();
                  while (localIterator.hasNext()) {
                    paramAnonymous2l.add((String)localIterator.next());
                  }
                  AppMethodBeat.o(131234);
                }
              };
              ((com.tencent.mm.ui.tools.l)localObject4).ISv = new n.d()
              {
                public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(131235);
                  Object localObject = paramAnonymous2MenuItem.getTitle();
                  paramAnonymous2MenuItem = new Intent();
                  paramAnonymous2MenuItem.setComponent(new ComponentName(((ResolveInfo)this.iMQ.get(localObject)).activityInfo.packageName, ((ResolveInfo)this.iMQ.get(localObject)).activityInfo.name));
                  paramAnonymous2MenuItem.setAction("android.intent.action.SENDTO");
                  paramAnonymous2MenuItem.setData(this.iMT);
                  paramAnonymous2MenuItem.putExtra("sms_body", paramAnonymousView);
                  localObject = InviteFriendUI.this;
                  paramAnonymous2MenuItem = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymous2MenuItem);
                  com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymous2MenuItem.aeD(), "com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$1$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  ((InviteFriendUI)localObject).startActivity((Intent)paramAnonymous2MenuItem.lR(0));
                  com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$1$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  AppMethodBeat.o(131235);
                }
              };
              ((com.tencent.mm.ui.tools.l)localObject4).ftL();
              InviteFriendUI.c(InviteFriendUI.this);
              AppMethodBeat.o(131238);
              return;
            }
            Toast.makeText(InviteFriendUI.this, 2131763024, 1).show();
            AppMethodBeat.o(131238);
            return;
            int i = com.tencent.mm.b.p.dv(InviteFriendUI.b(InviteFriendUI.this));
            new g(InviteFriendUI.this, new g.a()
            {
              public final void g(boolean paramAnonymous2Boolean, String paramAnonymous2String)
              {
                AppMethodBeat.i(131236);
                if (paramAnonymous2Boolean) {
                  InviteFriendUI.this.finish();
                }
                AppMethodBeat.o(131236);
              }
            }).r(new int[] { i });
            AppMethodBeat.o(131238);
            return;
            paramAnonymousView = new h(InviteFriendUI.this, new h.a()
            {
              public final void fp(boolean paramAnonymous2Boolean)
              {
                AppMethodBeat.i(131237);
                if (paramAnonymous2Boolean) {
                  ((o)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).ay(InviteFriendUI.d(InviteFriendUI.this), 1);
                }
                AppMethodBeat.o(131237);
              }
            });
            localObject2 = InviteFriendUI.e(InviteFriendUI.this);
            localObject1 = InviteFriendUI.b(InviteFriendUI.this);
            com.tencent.mm.kernel.g.agi().a(489, paramAnonymousView);
            localObject2 = ((o)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).Gr((String)localObject2);
            if ((localObject2 == null) || (((Cursor)localObject2).getCount() <= 1)) {
              paramAnonymousView.Gz((String)localObject1);
            }
            for (;;)
            {
              if (localObject2 == null) {
                break label739;
              }
              ((Cursor)localObject2).close();
              break;
              paramAnonymousView.c((Cursor)localObject2);
            }
          }
        }
      });
      localButton.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(131239);
          paramAnonymousView = new pa();
          paramAnonymousView.drC.opType = 0;
          paramAnonymousView.drC.drE = (InviteFriendUI.b(InviteFriendUI.this) + "@qqim");
          paramAnonymousView.drC.drF = InviteFriendUI.f(InviteFriendUI.this);
          com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousView);
          if (paramAnonymousView.drD.dbS) {
            com.tencent.mm.plugin.account.a.a.iyx.d(new Intent().putExtra("Chat_User", InviteFriendUI.b(InviteFriendUI.this) + "@qqim"), InviteFriendUI.this);
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
      localObject = ((b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).Gi((String)localObject);
      if (localObject != null)
      {
        localObject = com.tencent.mm.plugin.account.friend.a.l.a(((com.tencent.mm.plugin.account.friend.a.a)localObject).aPl(), this);
        break;
      }
      localObject = null;
      break;
      label580:
      this.iKw.setImageDrawable(com.tencent.mm.cc.a.l(this, 2131690027));
      break label200;
      label596:
      this.iKw.setImageBitmap((Bitmap)localObject);
      break label290;
      label607:
      localObject = c.zK(this.iMI);
      break label376;
      label618:
      this.iKw.setImageDrawable(com.tencent.mm.cc.a.l(this, 2131231878));
      break label388;
      label634:
      this.iKw.setImageResource(2131690013);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(131241);
    super.onCreate(paramBundle);
    setMMTitle(2131760357);
    paramBundle = getIntent();
    this.iMG = paramBundle.getIntExtra("friend_type", -1);
    this.iMH = paramBundle.getStringExtra("friend_nick");
    this.iMF = paramBundle.getStringExtra("friend_num");
    this.iMI = paramBundle.getStringExtra("friend_googleID");
    this.iMJ = paramBundle.getStringExtra("friend_googleItemID");
    this.iMF = bs.nullAsNil(this.iMF);
    this.iMN = paramBundle.getStringExtra("friend_linkedInID");
    this.iMO = paramBundle.getStringExtra("friend_linkedInPicUrl");
    initView();
    this.iML = paramBundle.getIntExtra("search_kvstat_scene", 0);
    this.iMM = paramBundle.getIntExtra("search_kvstat_position", 0);
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
    com.tencent.mm.aj.p.aBh().e(this);
    AppMethodBeat.o(131242);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(131243);
    super.onResume();
    com.tencent.mm.aj.p.aBh().d(this);
    AppMethodBeat.o(131243);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.InviteFriendUI
 * JD-Core Version:    0.7.0.1
 */