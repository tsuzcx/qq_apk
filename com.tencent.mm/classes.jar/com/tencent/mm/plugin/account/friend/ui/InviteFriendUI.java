package com.tencent.mm.plugin.account.friend.ui;

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
import com.tencent.mm.autogen.a.sp;
import com.tencent.mm.autogen.a.sp.b;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.f;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.AvatarStorage.a;
import com.tencent.mm.modelavatar.d;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.account.friend.a.b;
import com.tencent.mm.plugin.account.friend.a.c;
import com.tencent.mm.plugin.account.friend.a.d;
import com.tencent.mm.plugin.account.friend.a.f;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.plugin.account.friend.model.i;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u.b;
import com.tencent.mm.ui.base.u.d;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class InviteFriendUI
  extends MMActivity
  implements AvatarStorage.a
{
  private ImageView avatar;
  private String pUR;
  private int pUS;
  private String pUT;
  private String pUU;
  private String pUV;
  private Button pUW;
  private int pUX;
  private int pUY;
  private String pUZ = null;
  private String pVa = null;
  
  public final void LM(String paramString)
  {
    AppMethodBeat.i(131246);
    if ((this.pUR == null) || (this.pUR.equals("")))
    {
      AppMethodBeat.o(131246);
      return;
    }
    long l = d.Lx(paramString);
    if ((l > 0L) && (this.pUR.equals(String.valueOf(l))) && (this.pUS == 0)) {
      this.avatar.setImageBitmap(d.a(paramString, false, -1, null));
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
    this.avatar = ((ImageView)findViewById(a.c.invite_friend_avatar_iv));
    TextView localTextView1 = (TextView)findViewById(a.c.invite_friend_nickname_tv);
    TextView localTextView3 = (TextView)findViewById(a.c.invite_friend_num_tv);
    TextView localTextView2 = (TextView)findViewById(a.c.invite_friend_not_reg);
    this.pUW = ((Button)findViewById(a.c.invite_friend_invite_btn));
    Button localButton = (Button)findViewById(a.c.invite_friend_send_qq_message);
    localTextView1.setText(this.pUT);
    localTextView2.setText(getString(a.g.invite_friend_not_reg, new Object[] { this.pUT }));
    label209:
    long l;
    if (this.pUS == 1)
    {
      this.avatar.setBackgroundDrawable(com.tencent.mm.cd.a.m(this, a.f.default_mobile_avatar));
      localTextView3.setText(getString(a.g.app_field_mobile) + this.pUR);
      localObject = com.tencent.mm.b.g.getMessageDigest(this.pUR.getBytes());
      if (!com.tencent.mm.kernel.h.baE().isSDCardAvailable())
      {
        localObject = q.bFp().dO(MMApplicationContext.getContext());
        if (localObject == null) {
          break label594;
        }
        this.avatar.setImageBitmap((Bitmap)localObject);
      }
    }
    else if (this.pUS == 0)
    {
      this.avatar.setBackgroundDrawable(com.tencent.mm.cd.a.m(this, a.f.default_qq_avatar));
      localTextView3.setText(getString(a.g.app_field_qquin) + this.pUR);
      l = p.hw(this.pUR);
      if (l == 0L) {
        break label663;
      }
    }
    label389:
    label401:
    label663:
    for (Object localObject = d.iy(l);; localObject = null)
    {
      if (localObject == null)
      {
        this.avatar.setImageDrawable(com.tencent.mm.cd.a.m(this, a.f.default_qq_avatar));
        label300:
        localButton.setVisibility(0);
        if (this.pUS == 2)
        {
          this.pUW.setText(a.g.gcontact_send_invite);
          this.avatar.setBackgroundDrawable(com.tencent.mm.cd.a.m(this, a.b.default_google_avatar));
          localTextView3.setText(getString(a.g.app_field_email) + this.pUR);
          if (com.tencent.mm.kernel.h.baE().isSDCardAvailable()) {
            break label622;
          }
          localObject = q.bFp().dO(MMApplicationContext.getContext());
          if (localObject == null) {
            break label633;
          }
          this.avatar.setImageBitmap((Bitmap)localObject);
          if (TextUtils.isEmpty(this.pUT))
          {
            localTextView1.setText(Util.subStringEmail(this.pUR));
            localTextView2.setText(getString(a.g.invite_friend_not_reg, new Object[] { Util.subStringEmail(this.pUR) }));
          }
        }
        if (this.pUS == 3)
        {
          this.pUW.setText(a.g.invite_friend_linkedin_invite);
          localObject = r.a(new e(this.pVa, this.pVa));
          if (localObject == null) {
            break label650;
          }
          this.avatar.setImageBitmap((Bitmap)localObject);
        }
      }
      for (;;)
      {
        localButton.setVisibility(8);
        this.pUW.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(131238);
            Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
            switch (InviteFriendUI.a(InviteFriendUI.this))
            {
            }
            label768:
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(131238);
              return;
              localObject1 = (String)com.tencent.mm.kernel.h.baE().ban().d(42, "");
              if (localObject1 != null)
              {
                paramAnonymousView = (View)localObject1;
                if (((String)localObject1).length() != 0) {}
              }
              else
              {
                paramAnonymousView = (String)com.tencent.mm.kernel.h.baE().ban().d(2, "");
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
                  localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject3);
                  com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
                  com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  InviteFriendUI.c(InviteFriendUI.this);
                }
              }
              else if (((HashMap)localObject2).size() > 1)
              {
                localObject4 = new com.tencent.mm.ui.tools.l(InviteFriendUI.this);
                ((com.tencent.mm.ui.tools.l)localObject4).Vti = new u.b()
                {
                  public final void onAttach(ImageView paramAnonymous2ImageView1, ImageView paramAnonymous2ImageView2, MenuItem paramAnonymous2MenuItem)
                  {
                    AppMethodBeat.i(304838);
                    paramAnonymous2ImageView2 = paramAnonymous2MenuItem.getTitle();
                    paramAnonymous2ImageView1.setImageDrawable(((ResolveInfo)this.pVc.get(paramAnonymous2ImageView2)).loadIcon(this.pVd));
                    AppMethodBeat.o(304838);
                  }
                };
                ((com.tencent.mm.ui.tools.l)localObject4).Vtj = new u.d()
                {
                  public final void onAttach(TextView paramAnonymous2TextView, MenuItem paramAnonymous2MenuItem)
                  {
                    AppMethodBeat.i(131233);
                    paramAnonymous2MenuItem = paramAnonymous2MenuItem.getTitle();
                    paramAnonymous2MenuItem = ((ResolveInfo)this.pVc.get(paramAnonymous2MenuItem)).loadLabel(this.pVd);
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
                ((com.tencent.mm.ui.tools.l)localObject4).Vtg = new u.g()
                {
                  public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymous2s)
                  {
                    AppMethodBeat.i(131234);
                    Iterator localIterator = this.pVc.keySet().iterator();
                    while (localIterator.hasNext()) {
                      paramAnonymous2s.add((String)localIterator.next());
                    }
                    AppMethodBeat.o(131234);
                  }
                };
                ((com.tencent.mm.ui.tools.l)localObject4).GAC = new u.i()
                {
                  public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(131235);
                    Object localObject = paramAnonymous2MenuItem.getTitle();
                    paramAnonymous2MenuItem = new Intent();
                    paramAnonymous2MenuItem.setComponent(new ComponentName(((ResolveInfo)this.pVc.get(localObject)).activityInfo.packageName, ((ResolveInfo)this.pVc.get(localObject)).activityInfo.name));
                    paramAnonymous2MenuItem.setAction("android.intent.action.SENDTO");
                    paramAnonymous2MenuItem.setData(this.pVf);
                    paramAnonymous2MenuItem.putExtra("sms_body", paramAnonymousView);
                    localObject = InviteFriendUI.this;
                    paramAnonymous2MenuItem = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymous2MenuItem);
                    com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymous2MenuItem.aYi(), "com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$1$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    ((InviteFriendUI)localObject).startActivity((Intent)paramAnonymous2MenuItem.sb(0));
                    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$1$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(131235);
                  }
                };
                ((com.tencent.mm.ui.tools.l)localObject4).jDd();
                InviteFriendUI.c(InviteFriendUI.this);
              }
              else
              {
                Toast.makeText(InviteFriendUI.this, a.g.selectsmsapp_none, 1).show();
                continue;
                int i = p.hw(InviteFriendUI.b(InviteFriendUI.this));
                new g(InviteFriendUI.this, new g.a()
                {
                  public final void y(boolean paramAnonymous2Boolean, String paramAnonymous2String)
                  {
                    AppMethodBeat.i(131236);
                    if (paramAnonymous2Boolean) {
                      InviteFriendUI.this.finish();
                    }
                    AppMethodBeat.o(131236);
                  }
                }).v(new int[] { i });
                continue;
                paramAnonymousView = new h(InviteFriendUI.this, new h.a()
                {
                  public final void hP(boolean paramAnonymous2Boolean)
                  {
                    AppMethodBeat.i(131237);
                    if (paramAnonymous2Boolean) {
                      ((com.tencent.mm.plugin.account.friend.model.l)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getGoogleFriendStorage()).bo(InviteFriendUI.d(InviteFriendUI.this), 1);
                    }
                    AppMethodBeat.o(131237);
                  }
                });
                localObject2 = InviteFriendUI.e(InviteFriendUI.this);
                localObject1 = InviteFriendUI.b(InviteFriendUI.this);
                com.tencent.mm.kernel.h.aZW().a(489, paramAnonymousView);
                localObject2 = ((com.tencent.mm.plugin.account.friend.model.l)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getGoogleFriendStorage()).Tc((String)localObject2);
                if ((localObject2 == null) || (((Cursor)localObject2).getCount() <= 1)) {
                  paramAnonymousView.Tk((String)localObject1);
                }
                for (;;)
                {
                  if (localObject2 == null) {
                    break label768;
                  }
                  ((Cursor)localObject2).close();
                  break;
                  paramAnonymousView.f((Cursor)localObject2);
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
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            paramAnonymousView = new sp();
            paramAnonymousView.hVM.opType = 0;
            paramAnonymousView.hVM.hVO = (InviteFriendUI.b(InviteFriendUI.this) + "@qqim");
            paramAnonymousView.hVM.hVP = InviteFriendUI.f(InviteFriendUI.this);
            paramAnonymousView.publish();
            if (paramAnonymousView.hVN.hCQ) {
              com.tencent.mm.plugin.account.sdk.a.pFn.d(new Intent().putExtra("Chat_User", InviteFriendUI.b(InviteFriendUI.this) + "@qqim"), InviteFriendUI.this);
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
        localObject = ((com.tencent.mm.plugin.account.friend.model.b)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getAddrUploadStg()).SU((String)localObject);
        if (localObject != null)
        {
          localObject = i.a(((com.tencent.mm.plugin.account.friend.model.a)localObject).bWH(), this);
          break;
        }
        localObject = null;
        break;
        label594:
        this.avatar.setImageDrawable(com.tencent.mm.cd.a.m(this, a.f.default_mobile_avatar));
        break label209;
        this.avatar.setImageBitmap((Bitmap)localObject);
        break label300;
        label622:
        localObject = d.Ls(this.pUU);
        break label389;
        label633:
        this.avatar.setImageDrawable(com.tencent.mm.cd.a.m(this, a.b.default_google_avatar));
        break label401;
        this.avatar.setImageResource(a.f.default_avatar);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(131241);
    super.onCreate(paramBundle);
    setMMTitle(a.g.invite_friend_title);
    paramBundle = getIntent();
    this.pUS = paramBundle.getIntExtra("friend_type", -1);
    this.pUT = paramBundle.getStringExtra("friend_nick");
    this.pUR = paramBundle.getStringExtra("friend_num");
    this.pUU = paramBundle.getStringExtra("friend_googleID");
    this.pUV = paramBundle.getStringExtra("friend_googleItemID");
    this.pUR = Util.nullAsNil(this.pUR);
    this.pUZ = paramBundle.getStringExtra("friend_linkedInID");
    this.pVa = paramBundle.getStringExtra("friend_linkedInPicUrl");
    initView();
    this.pUX = paramBundle.getIntExtra("search_kvstat_scene", 0);
    this.pUY = paramBundle.getIntExtra("search_kvstat_position", 0);
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
    q.bFp().e(this);
    AppMethodBeat.o(131242);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(131243);
    super.onResume();
    q.bFp().d(this);
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