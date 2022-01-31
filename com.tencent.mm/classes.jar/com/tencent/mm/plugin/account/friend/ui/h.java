package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ae;
import com.tencent.mm.plugin.account.friend.a.n;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

public final class h
  implements f
{
  private Context context;
  private ProgressDialog fsw;
  a gAo;
  
  public h(Context paramContext, a parama)
  {
    this.context = paramContext;
    this.gAo = parama;
  }
  
  final void c(Cursor paramCursor)
  {
    AppMethodBeat.i(108655);
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
    Object localObject = this.context.getResources().getString(2131300492);
    this.context.getResources().getString(2131296888);
    com.tencent.mm.ui.base.h.a(paramCursor, (String)localObject, localArrayList1, localArrayList2, new h.1(this, localArrayList3));
    AppMethodBeat.o(108655);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(108657);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    ab.i("MicroMsg.SendInviteGoogleContact", "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
    if (paramm.getType() != 489)
    {
      AppMethodBeat.o(108657);
      return;
    }
    if (this.fsw != null)
    {
      this.fsw.dismiss();
      this.fsw = null;
    }
    g.Rc().b(489, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ab.i("MicroMsg.SendInviteGoogleContact", "dealSendInviteSuccess");
      com.tencent.mm.ui.base.h.a(this.context, 2131300774, 2131297087, new h.3(this));
      AppMethodBeat.o(108657);
      return;
    }
    ab.i("MicroMsg.SendInviteGoogleContact", "dealSendInviteFail");
    this.gAo.dz(false);
    AppMethodBeat.o(108657);
  }
  
  final void xq(String paramString)
  {
    AppMethodBeat.i(108656);
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(paramString);
    paramString = new ae((ArrayList)localObject);
    g.Rc().a(paramString, 0);
    localObject = this.context;
    this.context.getString(2131300777);
    this.fsw = com.tencent.mm.ui.base.h.b((Context)localObject, this.context.getString(2131300775), true, new h.2(this, paramString));
    AppMethodBeat.o(108656);
  }
  
  public static abstract interface a
  {
    public abstract void dz(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.h
 * JD-Core Version:    0.7.0.1
 */