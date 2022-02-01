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
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.account.friend.a.ah;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.h.d;
import java.util.ArrayList;

public final class h
  implements com.tencent.mm.ak.g
{
  private Context context;
  private ProgressDialog huQ;
  a iNH;
  
  public h(Context paramContext, a parama)
  {
    this.context = paramContext;
    this.iNH = parama;
  }
  
  final void Gz(final String paramString)
  {
    AppMethodBeat.i(131316);
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(paramString);
    paramString = new ah((ArrayList)localObject);
    com.tencent.mm.kernel.g.agi().a(paramString, 0);
    localObject = this.context;
    this.context.getString(2131760378);
    this.huQ = com.tencent.mm.ui.base.h.b((Context)localObject, this.context.getString(2131760376), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(131313);
        com.tencent.mm.kernel.g.agi().a(paramString);
        h.this.iNH.fp(false);
        AppMethodBeat.o(131313);
      }
    });
    AppMethodBeat.o(131316);
  }
  
  final void c(Cursor paramCursor)
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
        localObject = new com.tencent.mm.plugin.account.friend.a.n();
        ((com.tencent.mm.plugin.account.friend.a.n)localObject).convertFrom(paramCursor);
        localArrayList1.add(((com.tencent.mm.plugin.account.friend.a.n)localObject).field_googlegmail);
        localArrayList2.add(Integer.valueOf(i));
        localArrayList3.add(localObject);
        paramCursor.moveToNext();
        i += 1;
      }
      localArrayList2.add(Integer.valueOf(-1));
    }
    paramCursor = this.context;
    Object localObject = this.context.getResources().getString(2131760028);
    this.context.getResources().getString(2131755691);
    com.tencent.mm.ui.base.h.a(paramCursor, (String)localObject, localArrayList1, localArrayList2, new h.d()
    {
      public final void ct(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(131312);
        if (paramAnonymousInt2 != -1) {
          h.this.Gz(((com.tencent.mm.plugin.account.friend.a.n)localArrayList3.get(paramAnonymousInt2)).field_googlegmail);
        }
        AppMethodBeat.o(131312);
      }
    });
    AppMethodBeat.o(131315);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(131317);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    ac.i("MicroMsg.SendInviteGoogleContact", "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
    if (paramn.getType() != 489)
    {
      AppMethodBeat.o(131317);
      return;
    }
    if (this.huQ != null)
    {
      this.huQ.dismiss();
      this.huQ = null;
    }
    com.tencent.mm.kernel.g.agi().b(489, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ac.i("MicroMsg.SendInviteGoogleContact", "dealSendInviteSuccess");
      com.tencent.mm.ui.base.h.a(this.context, 2131760375, 2131755906, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(131314);
          h.this.iNH.fp(true);
          AppMethodBeat.o(131314);
        }
      });
      AppMethodBeat.o(131317);
      return;
    }
    ac.i("MicroMsg.SendInviteGoogleContact", "dealSendInviteFail");
    this.iNH.fp(false);
    AppMethodBeat.o(131317);
  }
  
  public static abstract interface a
  {
    public abstract void fp(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.h
 * JD-Core Version:    0.7.0.1
 */