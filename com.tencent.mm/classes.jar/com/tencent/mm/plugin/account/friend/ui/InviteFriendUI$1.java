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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.tools.l;
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
    AppMethodBeat.i(108577);
    switch (InviteFriendUI.a(this.gzA))
    {
    }
    label681:
    for (;;)
    {
      AppMethodBeat.o(108577);
      return;
      Object localObject1 = (String)com.tencent.mm.kernel.g.RL().Ru().get(42, "");
      if (localObject1 != null)
      {
        paramView = (View)localObject1;
        if (((String)localObject1).length() != 0) {}
      }
      else
      {
        paramView = (String)com.tencent.mm.kernel.g.RL().Ru().get(2, "");
      }
      paramView = this.gzA.getString(2131300772, new Object[] { paramView });
      localObject1 = Uri.parse("smsto:" + InviteFriendUI.b(this.gzA));
      Object localObject2 = new Intent("android.intent.action.SENDTO", (Uri)localObject1);
      ((Intent)localObject2).putExtra("sms_body", paramView);
      Object localObject3 = this.gzA.getPackageManager();
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
          this.gzA.startActivity((Intent)localObject4);
          InviteFriendUI.c(this.gzA);
        }
        AppMethodBeat.o(108577);
        return;
      }
      if (((HashMap)localObject2).size() > 1)
      {
        localObject4 = new l(this.gzA);
        ((l)localObject4).AvY = new InviteFriendUI.1.1(this, (HashMap)localObject2, (PackageManager)localObject3);
        ((l)localObject4).AvZ = new InviteFriendUI.1.2(this, (HashMap)localObject2, (PackageManager)localObject3);
        ((l)localObject4).sao = new InviteFriendUI.1.3(this, (HashMap)localObject2);
        ((l)localObject4).sap = new InviteFriendUI.1.4(this, (HashMap)localObject2, (Uri)localObject1, paramView);
        ((l)localObject4).cwt();
        InviteFriendUI.c(this.gzA);
        AppMethodBeat.o(108577);
        return;
      }
      Toast.makeText(this.gzA, 2131303076, 1).show();
      AppMethodBeat.o(108577);
      return;
      int i = com.tencent.mm.a.p.cU(InviteFriendUI.b(this.gzA));
      new g(this.gzA, new InviteFriendUI.1.5(this)).o(new int[] { i });
      AppMethodBeat.o(108577);
      return;
      paramView = new h(this.gzA, new InviteFriendUI.1.6(this));
      localObject2 = InviteFriendUI.e(this.gzA);
      localObject1 = InviteFriendUI.b(this.gzA);
      com.tencent.mm.kernel.g.Rc().a(489, paramView);
      localObject2 = ((o)((a)com.tencent.mm.kernel.g.G(a.class)).getGoogleFriendStorage()).xk((String)localObject2);
      if ((localObject2 == null) || (((Cursor)localObject2).getCount() <= 1)) {
        paramView.xq((String)localObject1);
      }
      for (;;)
      {
        if (localObject2 == null) {
          break label681;
        }
        ((Cursor)localObject2).close();
        break;
        paramView.c((Cursor)localObject2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.InviteFriendUI.1
 * JD-Core Version:    0.7.0.1
 */