package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.plugin.account.friend.a.ah;
import com.tencent.mm.plugin.account.friend.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h.e;
import java.util.ArrayList;

public final class h
  implements i
{
  private Context context;
  private ProgressDialog lBo;
  private a mZk;
  
  public h(Context paramContext, a parama)
  {
    this.context = paramContext;
    this.mZk = parama;
  }
  
  final void aaR(final String paramString)
  {
    AppMethodBeat.i(131316);
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(paramString);
    paramString = new ah((ArrayList)localObject);
    com.tencent.mm.kernel.h.aGY().a(paramString, 0);
    localObject = this.context;
    this.context.getString(a.g.inviteqqfriends_title);
    this.lBo = com.tencent.mm.ui.base.h.a((Context)localObject, this.context.getString(a.g.inviteqqfriends_inviting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(131313);
        com.tencent.mm.kernel.h.aGY().a(paramString);
        h.a(h.this).gZ(false);
        AppMethodBeat.o(131313);
      }
    });
    AppMethodBeat.o(131316);
  }
  
  final void e(Cursor paramCursor)
  {
    AppMethodBeat.i(131315);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    final ArrayList localArrayList3 = new ArrayList();
    if (paramCursor != null)
    {
      paramCursor.moveToFirst();
      int j = paramCursor.getCount();
      int i = 0;
      while (i < j)
      {
        localObject = new n();
        ((n)localObject).convertFrom(paramCursor);
        localArrayList1.add(((n)localObject).field_googlegmail);
        localArrayList2.add(Integer.valueOf(i));
        localArrayList3.add(localObject);
        paramCursor.moveToNext();
        i += 1;
      }
      localArrayList2.add(Integer.valueOf(-1));
    }
    paramCursor = this.context;
    Object localObject = this.context.getResources().getString(a.g.gcontact_select_email);
    this.context.getResources().getString(a.g.app_cancel);
    com.tencent.mm.ui.base.h.a(paramCursor, (String)localObject, localArrayList1, localArrayList2, new h.e()
    {
      public final void cS(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(131312);
        if (paramAnonymousInt2 != -1) {
          h.a(h.this, ((n)localArrayList3.get(paramAnonymousInt2)).field_googlegmail);
        }
        AppMethodBeat.o(131312);
      }
    });
    AppMethodBeat.o(131315);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(131317);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    Log.i("MicroMsg.SendInviteGoogleContact", "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
    if (paramq.getType() != 489)
    {
      AppMethodBeat.o(131317);
      return;
    }
    if (this.lBo != null)
    {
      this.lBo.dismiss();
      this.lBo = null;
    }
    com.tencent.mm.kernel.h.aGY().b(489, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Log.i("MicroMsg.SendInviteGoogleContact", "dealSendInviteSuccess");
      com.tencent.mm.ui.base.h.a(this.context, a.g.inviteqqfriends_invite_success, a.g.app_tip, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(131314);
          h.a(h.this).gZ(true);
          AppMethodBeat.o(131314);
        }
      });
      AppMethodBeat.o(131317);
      return;
    }
    Log.i("MicroMsg.SendInviteGoogleContact", "dealSendInviteFail");
    this.mZk.gZ(false);
    AppMethodBeat.o(131317);
  }
  
  public static abstract interface a
  {
    public abstract void gZ(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.h
 * JD-Core Version:    0.7.0.1
 */