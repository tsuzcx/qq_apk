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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.d;
import com.tencent.mm.am.f.a;
import com.tencent.mm.am.q;
import com.tencent.mm.an.t;
import com.tencent.mm.b.p;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.account.friend.a.b;
import com.tencent.mm.plugin.account.friend.a.c;
import com.tencent.mm.plugin.account.friend.a.d;
import com.tencent.mm.plugin.account.friend.a.f;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q.b;
import com.tencent.mm.ui.base.q.c;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.tools.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class InviteFriendUI
  extends MMActivity
  implements f.a
{
  private ImageView mWb;
  private String mYj;
  private int mYk;
  private String mYl;
  private String mYm;
  private String mYn;
  private Button mYo;
  private int mYp;
  private int mYq;
  private String mYr = null;
  private String mYs = null;
  
  public final void TM(String paramString)
  {
    AppMethodBeat.i(131246);
    if ((this.mYj == null) || (this.mYj.equals("")))
    {
      AppMethodBeat.o(131246);
      return;
    }
    long l = d.Tv(paramString);
    if ((l > 0L) && (this.mYj.equals(String.valueOf(l))) && (this.mYk == 0)) {
      this.mWb.setImageBitmap(d.a(paramString, false, -1, null));
    }
    AppMethodBeat.o(131246);
  }
  
  public int getLayoutId()
  {
    return a.d.invite_friend;
  }
  
  public void initView()
  {
    AppMethodBeat.i(131245);
    this.mWb = ((ImageView)findViewById(a.c.invite_friend_avatar_iv));
    TextView localTextView1 = (TextView)findViewById(a.c.invite_friend_nickname_tv);
    TextView localTextView3 = (TextView)findViewById(a.c.invite_friend_num_tv);
    TextView localTextView2 = (TextView)findViewById(a.c.invite_friend_not_reg);
    this.mYo = ((Button)findViewById(a.c.invite_friend_invite_btn));
    Button localButton = (Button)findViewById(a.c.invite_friend_send_qq_message);
    localTextView1.setText(this.mYl);
    localTextView2.setText(getString(a.g.invite_friend_not_reg, new Object[] { this.mYl }));
    label209:
    long l;
    if (this.mYk == 1)
    {
      this.mWb.setBackgroundDrawable(com.tencent.mm.ci.a.m(this, a.f.default_mobile_avatar));
      localTextView3.setText(getString(a.g.app_field_mobile) + this.mYj);
      localObject = com.tencent.mm.b.g.getMessageDigest(this.mYj.getBytes());
      if (!com.tencent.mm.kernel.h.aHG().isSDCardAvailable())
      {
        localObject = q.bhz().cT(MMApplicationContext.getContext());
        if (localObject == null) {
          break label594;
        }
        this.mWb.setImageBitmap((Bitmap)localObject);
      }
    }
    else if (this.mYk == 0)
    {
      this.mWb.setBackgroundDrawable(com.tencent.mm.ci.a.m(this, a.f.default_qq_avatar));
      localTextView3.setText(getString(a.g.app_field_qquin) + this.mYj);
      l = p.fT(this.mYj);
      if (l == 0L) {
        break label663;
      }
    }
    label389:
    label401:
    label663:
    for (Object localObject = d.Go(l);; localObject = null)
    {
      if (localObject == null)
      {
        this.mWb.setImageDrawable(com.tencent.mm.ci.a.m(this, a.f.default_qq_avatar));
        label300:
        localButton.setVisibility(0);
        if (this.mYk == 2)
        {
          this.mYo.setText(a.g.gcontact_send_invite);
          this.mWb.setBackgroundDrawable(com.tencent.mm.ci.a.m(this, a.b.default_google_avatar));
          localTextView3.setText(getString(a.g.app_field_email) + this.mYj);
          if (com.tencent.mm.kernel.h.aHG().isSDCardAvailable()) {
            break label622;
          }
          localObject = q.bhz().cT(MMApplicationContext.getContext());
          if (localObject == null) {
            break label633;
          }
          this.mWb.setImageBitmap((Bitmap)localObject);
          if (TextUtils.isEmpty(this.mYl))
          {
            localTextView1.setText(Util.subStringEmail(this.mYj));
            localTextView2.setText(getString(a.g.invite_friend_not_reg, new Object[] { Util.subStringEmail(this.mYj) }));
          }
        }
        if (this.mYk == 3)
        {
          this.mYo.setText(a.g.invite_friend_linkedin_invite);
          localObject = u.a(new e(this.mYs, this.mYs));
          if (localObject == null) {
            break label650;
          }
          this.mWb.setImageBitmap((Bitmap)localObject);
        }
      }
      for (;;)
      {
        localButton.setVisibility(8);
        this.mYo.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(131238);
            Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
            switch (InviteFriendUI.a(InviteFriendUI.this))
            {
            }
            label768:
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(131238);
              return;
              localObject1 = (String)com.tencent.mm.kernel.h.aHG().aHp().b(42, "");
              if (localObject1 != null)
              {
                paramAnonymousView = (View)localObject1;
                if (((String)localObject1).length() != 0) {}
              }
              else
              {
                paramAnonymousView = (String)com.tencent.mm.kernel.h.aHG().aHp().b(2, "");
              }
              paramAnonymousView = InviteFriendUI.this.getString(a.g.invite_sms, new Object[] { paramAnonymousView });
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
                  localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject3);
                  com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
                  com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  InviteFriendUI.c(InviteFriendUI.this);
                }
              }
              else if (((HashMap)localObject2).size() > 1)
              {
                localObject4 = new m(InviteFriendUI.this);
                ((m)localObject4).ODW = new q.b()
                {
                  public final void a(ImageView paramAnonymous2ImageView, MenuItem paramAnonymous2MenuItem)
                  {
                    AppMethodBeat.i(131232);
                    paramAnonymous2MenuItem = paramAnonymous2MenuItem.getTitle();
                    paramAnonymous2ImageView.setImageDrawable(((ResolveInfo)this.mYu.get(paramAnonymous2MenuItem)).loadIcon(this.mYv));
                    AppMethodBeat.o(131232);
                  }
                };
                ((m)localObject4).ODX = new q.c()
                {
                  public final void a(TextView paramAnonymous2TextView, MenuItem paramAnonymous2MenuItem)
                  {
                    AppMethodBeat.i(131233);
                    paramAnonymous2MenuItem = paramAnonymous2MenuItem.getTitle();
                    paramAnonymous2MenuItem = ((ResolveInfo)this.mYu.get(paramAnonymous2MenuItem)).loadLabel(this.mYv);
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
                ((m)localObject4).ODT = new q.f()
                {
                  public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymous2o)
                  {
                    AppMethodBeat.i(131234);
                    Iterator localIterator = this.mYu.keySet().iterator();
                    while (localIterator.hasNext()) {
                      paramAnonymous2o.add((String)localIterator.next());
                    }
                    AppMethodBeat.o(131234);
                  }
                };
                ((m)localObject4).ODU = new q.g()
                {
                  public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(131235);
                    Object localObject = paramAnonymous2MenuItem.getTitle();
                    paramAnonymous2MenuItem = new Intent();
                    paramAnonymous2MenuItem.setComponent(new ComponentName(((ResolveInfo)this.mYu.get(localObject)).activityInfo.packageName, ((ResolveInfo)this.mYu.get(localObject)).activityInfo.name));
                    paramAnonymous2MenuItem.setAction("android.intent.action.SENDTO");
                    paramAnonymous2MenuItem.setData(this.mYx);
                    paramAnonymous2MenuItem.putExtra("sms_body", paramAnonymousView);
                    localObject = InviteFriendUI.this;
                    paramAnonymous2MenuItem = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymous2MenuItem);
                    com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymous2MenuItem.aFh(), "com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$1$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    ((InviteFriendUI)localObject).startActivity((Intent)paramAnonymous2MenuItem.sf(0));
                    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$1$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(131235);
                  }
                };
                ((m)localObject4).hYu();
                InviteFriendUI.c(InviteFriendUI.this);
              }
              else
              {
                Toast.makeText(InviteFriendUI.this, a.g.selectsmsapp_none, 1).show();
                continue;
                int i = p.fT(InviteFriendUI.b(InviteFriendUI.this));
                new g(InviteFriendUI.this, new g.a()
                {
                  public final void l(boolean paramAnonymous2Boolean, String paramAnonymous2String)
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
                  public final void gZ(boolean paramAnonymous2Boolean)
                  {
                    AppMethodBeat.i(131237);
                    if (paramAnonymous2Boolean) {
                      ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getGoogleFriendStorage()).aY(InviteFriendUI.d(InviteFriendUI.this), 1);
                    }
                    AppMethodBeat.o(131237);
                  }
                });
                localObject2 = InviteFriendUI.e(InviteFriendUI.this);
                localObject1 = InviteFriendUI.b(InviteFriendUI.this);
                com.tencent.mm.kernel.h.aGY().a(489, paramAnonymousView);
                localObject2 = ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getGoogleFriendStorage()).aaJ((String)localObject2);
                if ((localObject2 == null) || (((Cursor)localObject2).getCount() <= 1)) {
                  paramAnonymousView.aaR((String)localObject1);
                }
                for (;;)
                {
                  if (localObject2 == null) {
                    break label768;
                  }
                  ((Cursor)localObject2).close();
                  break;
                  paramAnonymousView.e((Cursor)localObject2);
                }
              }
            }
          }
        });
        localButton.setOnClickListener(new InviteFriendUI.2(this));
        setBackBtn(new InviteFriendUI.3(this));
        AppMethodBeat.o(131245);
        return;
        localObject = ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getAddrUploadStg()).aaA((String)localObject);
        if (localObject != null)
        {
          localObject = l.a(((com.tencent.mm.plugin.account.friend.a.a)localObject).bxS(), this);
          break;
        }
        localObject = null;
        break;
        label594:
        this.mWb.setImageDrawable(com.tencent.mm.ci.a.m(this, a.f.default_mobile_avatar));
        break label209;
        this.mWb.setImageBitmap((Bitmap)localObject);
        break label300;
        label622:
        localObject = d.Tq(this.mYm);
        break label389;
        label633:
        this.mWb.setImageDrawable(com.tencent.mm.ci.a.m(this, a.b.default_google_avatar));
        break label401;
        this.mWb.setImageResource(a.f.default_avatar);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(131241);
    super.onCreate(paramBundle);
    setMMTitle(a.g.invite_friend_title);
    paramBundle = getIntent();
    this.mYk = paramBundle.getIntExtra("friend_type", -1);
    this.mYl = paramBundle.getStringExtra("friend_nick");
    this.mYj = paramBundle.getStringExtra("friend_num");
    this.mYm = paramBundle.getStringExtra("friend_googleID");
    this.mYn = paramBundle.getStringExtra("friend_googleItemID");
    this.mYj = Util.nullAsNil(this.mYj);
    this.mYr = paramBundle.getStringExtra("friend_linkedInID");
    this.mYs = paramBundle.getStringExtra("friend_linkedInPicUrl");
    initView();
    this.mYp = paramBundle.getIntExtra("search_kvstat_scene", 0);
    this.mYq = paramBundle.getIntExtra("search_kvstat_position", 0);
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
    q.bhz().e(this);
    AppMethodBeat.o(131242);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(131243);
    super.onResume();
    q.bhz().d(this);
    AppMethodBeat.o(131243);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.InviteFriendUI
 * JD-Core Version:    0.7.0.1
 */