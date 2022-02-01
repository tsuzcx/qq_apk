package com.tencent.mm.plugin.messenger.e;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.b.e;
import com.tencent.mm.plugin.messenger.f.b;
import com.tencent.mm.plugin.messenger.f.b.b;
import com.tencent.mm.protocal.protobuf.dup;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class a
  extends b
  implements com.tencent.mm.am.h
{
  private com.tencent.mm.plugin.messenger.c.a KRH;
  private String KRI;
  private String KRJ;
  private String KRK;
  private String KRL;
  private String KRM;
  private ProgressDialog lzP;
  private long msgId;
  private String rIB;
  private WeakReference<Context> tLO;
  
  public a(b.b paramb)
  {
    super(paramb);
    AppMethodBeat.i(288531);
    this.lzP = null;
    com.tencent.mm.kernel.h.aZW().a(3713, this);
    AppMethodBeat.o(288531);
  }
  
  private static CharSequence concactSpannable(ArrayList<CharSequence> paramArrayList)
  {
    AppMethodBeat.i(288536);
    SpannableString localSpannableString = new SpannableString("");
    Iterator localIterator = paramArrayList.iterator();
    for (paramArrayList = localSpannableString; localIterator.hasNext(); paramArrayList = TextUtils.concat(new CharSequence[] { paramArrayList, (CharSequence)localIterator.next() })) {}
    AppMethodBeat.o(288536);
    return paramArrayList;
  }
  
  private void iO(Context paramContext)
  {
    AppMethodBeat.i(288541);
    if (this.lzP == null)
    {
      paramContext.getString(b.e.app_tip);
      this.lzP = k.a(paramContext, paramContext.getString(b.e.openim_switch_user_verify), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(288520);
          com.tencent.mm.kernel.h.aZW().a(a.a(a.this));
          AppMethodBeat.o(288520);
        }
      });
      AppMethodBeat.o(288541);
      return;
    }
    if (!this.lzP.isShowing()) {
      this.lzP.show();
    }
    AppMethodBeat.o(288541);
  }
  
  public final CharSequence b(final Map<String, String> paramMap, final String paramString, final Bundle paramBundle, final WeakReference<Context> paramWeakReference, final WeakReference<NeatTextView> paramWeakReference1)
  {
    AppMethodBeat.i(288590);
    if (paramMap == null)
    {
      AppMethodBeat.o(288590);
      return null;
    }
    if (paramBundle != null) {}
    for (final String str1 = paramBundle.getString("conv_talker_username");; str1 = "")
    {
      String str2 = Util.nullAsNil((String)paramMap.get(paramString + ".title"));
      SpannableString localSpannableString = new SpannableString(str2);
      localSpannableString.setSpan(new com.tencent.mm.plugin.messenger.a.a(paramBundle)
      {
        public final void onClickImp(View paramAnonymousView)
        {
          AppMethodBeat.i(288524);
          a.a(a.this, paramBundle.getLong("msg_id"));
          a.a(a.this, paramMap, paramString, paramWeakReference);
          ((e)com.tencent.mm.kernel.h.ax(e.class)).a("new_link_succeed_contact", paramMap, paramBundle);
          AppMethodBeat.o(288524);
        }
      }, 0, str2.length(), 33);
      AppMethodBeat.o(288590);
      return localSpannableString;
    }
  }
  
  public final String gbt()
  {
    return "new_link_succeed_contact";
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(288600);
    Log.i("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "onSceneEnd errType = %d, errCode = %d, errMsg = %s, scenetype:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramp.getType()) });
    if ((this.lzP != null) && (this.lzP.isShowing())) {
      this.lzP.dismiss();
    }
    if ((paramp instanceof com.tencent.mm.plugin.messenger.c.a))
    {
      if (paramInt2 == -3600)
      {
        new g.a(MMApplicationContext.getContext()).bDE(MMApplicationContext.getContext().getString(b.e.openim_not_auto_succeed_dialog_message)).aEX(b.e.welcome_i_know).b(null).show();
        com.tencent.mm.plugin.messenger.g.a.aq(this.msgId, 7);
        AppMethodBeat.o(288600);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject = (com.tencent.mm.plugin.messenger.c.a)paramp;
        if (((com.tencent.mm.plugin.messenger.c.a)localObject).KRv == null) {}
        for (localObject = null;; localObject = ((com.tencent.mm.plugin.messenger.c.a)localObject).KRv)
        {
          paramInt1 = ((com.tencent.mm.plugin.messenger.c.a)paramp).action;
          if (localObject == null) {
            break label333;
          }
          Log.i("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "NetSceneOpenImNotAutoSucceed ret:%s action:%s", new Object[] { Integer.valueOf(((dup)localObject).BaseResponse.Idd), Integer.valueOf(paramInt1) });
          if (paramInt1 != 1) {
            break label326;
          }
          if ((this.tLO != null) && (this.tLO.get() != null)) {
            break;
          }
          Log.e("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "NOT_AUTO_SUCCEED_ACTION_PREPARE context == null");
          AppMethodBeat.o(288600);
          return;
        }
        paramString = new g.a((Context)this.tLO.get());
        paramString.NF(false);
        paramString.bDE(this.KRI).bDJ(this.KRJ).bDI(this.rIB).c(new g.c()
        {
          public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString)
          {
            AppMethodBeat.i(288529);
            Log.i("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "click %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            if (paramAnonymousBoolean)
            {
              if ((a.b(a.this) == null) || (a.b(a.this).get() == null))
              {
                Log.e("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "onDialogClick context == null");
                AppMethodBeat.o(288529);
                return;
              }
              paramAnonymousString = (Context)a.b(a.this).get();
              a.a(a.this, new com.tencent.mm.plugin.messenger.c.a(a.c(a.this), a.d(a.this), a.e(a.this), 2));
              com.tencent.mm.kernel.h.aZW().a(a.a(a.this), 0);
              a.a(a.this, paramAnonymousString);
              com.tencent.mm.plugin.messenger.g.a.aq(a.f(a.this), 9);
              AppMethodBeat.o(288529);
              return;
            }
            com.tencent.mm.plugin.messenger.g.a.aq(a.f(a.this), 10);
            AppMethodBeat.o(288529);
          }
        }).show();
        com.tencent.mm.plugin.messenger.g.a.aq(this.msgId, 8);
        label326:
        AppMethodBeat.o(288600);
        return;
        label333:
        Log.e("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "notAutoSucceedResp is null");
      }
      Object localObject = MMApplicationContext.getContext();
      paramp = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramp = MMApplicationContext.getContext().getString(b.e.app_err_system_busy_tip);
      }
      aa.makeText((Context)localObject, paramp, 0).show();
      com.tencent.mm.plugin.messenger.g.a.aq(this.msgId, 6);
    }
    AppMethodBeat.o(288600);
  }
  
  public final void release()
  {
    AppMethodBeat.i(288582);
    super.release();
    com.tencent.mm.kernel.h.aZW().b(3713, this);
    AppMethodBeat.o(288582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.e.a
 * JD-Core Version:    0.7.0.1
 */