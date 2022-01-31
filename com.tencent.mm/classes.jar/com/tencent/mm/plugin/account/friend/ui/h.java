package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.h;
import com.tencent.mm.plugin.account.friend.a.ae;
import com.tencent.mm.plugin.account.friend.a.n;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

public final class h
  implements f
{
  private Context context;
  private ProgressDialog ecf;
  a fiH;
  
  public h(Context paramContext, a parama)
  {
    this.context = paramContext;
    this.fiH = parama;
  }
  
  final void e(Cursor paramCursor)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    if (paramCursor != null)
    {
      paramCursor.moveToFirst();
      int j = paramCursor.getCount();
      int i = 0;
      while (i < j)
      {
        localObject = new n();
        ((n)localObject).d(paramCursor);
        localArrayList1.add(((n)localObject).field_googlegmail);
        localArrayList2.add(Integer.valueOf(i));
        localArrayList3.add(localObject);
        paramCursor.moveToNext();
        i += 1;
      }
      localArrayList2.add(Integer.valueOf(-1));
    }
    paramCursor = this.context;
    Object localObject = this.context.getResources().getString(a.h.gcontact_select_email);
    this.context.getResources().getString(a.h.app_cancel);
    com.tencent.mm.ui.base.h.a(paramCursor, (String)localObject, localArrayList1, localArrayList2, new h.1(this, localArrayList3));
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    y.i("MicroMsg.SendInviteGoogleContact", "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
    if (paramm.getType() != 489) {
      return;
    }
    if (this.ecf != null)
    {
      this.ecf.dismiss();
      this.ecf = null;
    }
    g.Dk().b(489, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      y.i("MicroMsg.SendInviteGoogleContact", "dealSendInviteSuccess");
      com.tencent.mm.ui.base.h.a(this.context, a.h.inviteqqfriends_invite_success, a.h.app_tip, new h.3(this));
      return;
    }
    y.i("MicroMsg.SendInviteGoogleContact", "dealSendInviteFail");
    this.fiH.cw(false);
  }
  
  final void pU(String paramString)
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(paramString);
    paramString = new ae((ArrayList)localObject);
    g.Dk().a(paramString, 0);
    localObject = this.context;
    this.context.getString(a.h.inviteqqfriends_title);
    this.ecf = com.tencent.mm.ui.base.h.b((Context)localObject, this.context.getString(a.h.inviteqqfriends_inviting), true, new h.2(this, paramString));
  }
  
  public static abstract interface a
  {
    public abstract void cw(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.h
 * JD-Core Version:    0.7.0.1
 */