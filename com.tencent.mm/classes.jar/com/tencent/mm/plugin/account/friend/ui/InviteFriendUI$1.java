package com.tencent.mm.plugin.account.friend.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.account.friend.a.h;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.tools.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class InviteFriendUI$1
  implements View.OnClickListener
{
  InviteFriendUI$1(InviteFriendUI paramInviteFriendUI) {}
  
  public final void onClick(View paramView)
  {
    switch (InviteFriendUI.a(this.fhT))
    {
    }
    for (;;)
    {
      return;
      Object localObject1 = (String)com.tencent.mm.kernel.g.DP().Dz().get(42, "");
      if (localObject1 != null)
      {
        paramView = (View)localObject1;
        if (((String)localObject1).length() != 0) {}
      }
      else
      {
        paramView = (String)com.tencent.mm.kernel.g.DP().Dz().get(2, "");
      }
      paramView = this.fhT.getString(a.h.invite_sms, new Object[] { paramView });
      localObject1 = Uri.parse("smsto:" + InviteFriendUI.b(this.fhT));
      Object localObject2 = new Intent("android.intent.action.SENDTO", (Uri)localObject1);
      ((Intent)localObject2).putExtra("sms_body", paramView);
      Object localObject3 = this.fhT.getPackageManager();
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
          localObject3 = (String)((Iterator)localObject3).next();
          localObject4 = new Intent();
          ((Intent)localObject4).setComponent(new ComponentName(((ResolveInfo)((HashMap)localObject2).get(localObject3)).activityInfo.packageName, ((ResolveInfo)((HashMap)localObject2).get(localObject3)).activityInfo.name));
          ((Intent)localObject4).setAction("android.intent.action.SENDTO");
          ((Intent)localObject4).setData((Uri)localObject1);
          ((Intent)localObject4).putExtra("sms_body", paramView);
          this.fhT.startActivity((Intent)localObject4);
          InviteFriendUI.c(this.fhT);
        }
      }
      else
      {
        if (((HashMap)localObject2).size() > 1)
        {
          localObject4 = new j(this.fhT);
          ((j)localObject4).wdr = new InviteFriendUI.1.1(this, (HashMap)localObject2, (PackageManager)localObject3);
          ((j)localObject4).wds = new InviteFriendUI.1.2(this, (HashMap)localObject2, (PackageManager)localObject3);
          ((j)localObject4).phH = new InviteFriendUI.1.3(this, (HashMap)localObject2);
          ((j)localObject4).phI = new InviteFriendUI.1.4(this, (HashMap)localObject2, (Uri)localObject1, paramView);
          ((j)localObject4).bJQ();
          InviteFriendUI.c(this.fhT);
          return;
        }
        Toast.makeText(this.fhT, a.h.selectsmsapp_none, 1).show();
        return;
        int i = com.tencent.mm.a.o.bS(InviteFriendUI.b(this.fhT));
        new g(this.fhT, new InviteFriendUI.1.5(this)).g(new int[] { i });
        return;
        paramView = new h(this.fhT, new InviteFriendUI.1.6(this));
        localObject2 = InviteFriendUI.e(this.fhT);
        localObject1 = InviteFriendUI.b(this.fhT);
        com.tencent.mm.kernel.g.Dk().a(489, paramView);
        localObject2 = ((com.tencent.mm.plugin.account.friend.a.o)((a)com.tencent.mm.kernel.g.t(a.class)).getGoogleFriendStorage()).pP((String)localObject2);
        if ((localObject2 == null) || (((Cursor)localObject2).getCount() <= 1)) {
          paramView.pU((String)localObject1);
        }
        while (localObject2 != null)
        {
          ((Cursor)localObject2).close();
          return;
          paramView.e((Cursor)localObject2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.InviteFriendUI.1
 * JD-Core Version:    0.7.0.1
 */