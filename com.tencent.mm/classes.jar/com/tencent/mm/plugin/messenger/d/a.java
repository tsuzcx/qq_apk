package com.tencent.mm.plugin.messenger.d;

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
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.b.d;
import com.tencent.mm.plugin.messenger.e.b;
import com.tencent.mm.plugin.messenger.e.b.b;
import com.tencent.mm.protocal.protobuf.dcw;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class a
  extends b
  implements i
{
  private com.tencent.mm.plugin.messenger.b.a EVX;
  private String EVY;
  private String EVZ;
  private String EWa;
  private String EWb;
  private String EWc;
  private ProgressDialog iXX;
  private long msgId;
  private String oFx;
  private WeakReference<Context> qHe;
  
  public a(b.b paramb)
  {
    super(paramb);
    AppMethodBeat.i(212986);
    this.iXX = null;
    com.tencent.mm.kernel.h.aGY().a(3713, this);
    AppMethodBeat.o(212986);
  }
  
  private static CharSequence concactSpannable(ArrayList<CharSequence> paramArrayList)
  {
    AppMethodBeat.i(212995);
    SpannableString localSpannableString = new SpannableString("");
    Iterator localIterator = paramArrayList.iterator();
    for (paramArrayList = localSpannableString; localIterator.hasNext(); paramArrayList = TextUtils.concat(new CharSequence[] { paramArrayList, (CharSequence)localIterator.next() })) {}
    AppMethodBeat.o(212995);
    return paramArrayList;
  }
  
  private void ht(Context paramContext)
  {
    AppMethodBeat.i(212997);
    if (this.iXX == null)
    {
      paramContext.getString(b.d.app_tip);
      this.iXX = com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(b.d.openim_switch_user_verify), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(213443);
          com.tencent.mm.kernel.h.aGY().a(a.a(a.this));
          AppMethodBeat.o(213443);
        }
      });
      AppMethodBeat.o(212997);
      return;
    }
    if (!this.iXX.isShowing()) {
      this.iXX.show();
    }
    AppMethodBeat.o(212997);
  }
  
  public final CharSequence b(final Map<String, String> paramMap, final String paramString, final Bundle paramBundle, final WeakReference<Context> paramWeakReference, final WeakReference<NeatTextView> paramWeakReference1)
  {
    AppMethodBeat.i(212992);
    if (paramMap == null)
    {
      AppMethodBeat.o(212992);
      return null;
    }
    if (paramBundle != null) {}
    for (final String str1 = paramBundle.getString("conv_talker_username");; str1 = "")
    {
      String str2 = Util.nullAsNil((String)paramMap.get(paramString + ".title"));
      SpannableString localSpannableString = new SpannableString(str2);
      localSpannableString.setSpan(new com.tencent.mm.plugin.messenger.a.a(paramBundle, paramMap)
      {
        public final void onClickImp(View paramAnonymousView)
        {
          AppMethodBeat.i(213036);
          a.a(a.this, paramBundle.getLong("msg_id"));
          a.a(a.this, paramMap, paramString, paramWeakReference);
          ((e)com.tencent.mm.kernel.h.ae(e.class)).a("new_link_succeed_contact", paramMap, paramBundle);
          AppMethodBeat.o(213036);
        }
      }, 0, str2.length(), 33);
      AppMethodBeat.o(212992);
      return localSpannableString;
    }
  }
  
  public final String eSz()
  {
    return "new_link_succeed_contact";
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(213001);
    Log.i("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "onSceneEnd errType = %d, errCode = %d, errMsg = %s, scenetype:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramq.getType()) });
    if ((this.iXX != null) && (this.iXX.isShowing())) {
      this.iXX.dismiss();
    }
    if ((paramq instanceof com.tencent.mm.plugin.messenger.b.a))
    {
      if (paramInt2 == -3600)
      {
        new f.a(MMApplicationContext.getContext()).bBl(MMApplicationContext.getContext().getString(b.d.openim_not_auto_succeed_dialog_message)).ayp(b.d.welcome_i_know).b(null).show();
        com.tencent.mm.plugin.messenger.f.a.Z(this.msgId, 7);
        AppMethodBeat.o(213001);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject = (com.tencent.mm.plugin.messenger.b.a)paramq;
        if (((com.tencent.mm.plugin.messenger.b.a)localObject).EVV == null) {}
        for (localObject = null;; localObject = ((com.tencent.mm.plugin.messenger.b.a)localObject).EVV)
        {
          paramInt1 = ((com.tencent.mm.plugin.messenger.b.a)paramq).action;
          if (localObject == null) {
            break label333;
          }
          Log.i("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "NetSceneOpenImNotAutoSucceed ret:%s action:%s", new Object[] { Integer.valueOf(((dcw)localObject).BaseResponse.CqV), Integer.valueOf(paramInt1) });
          if (paramInt1 != 1) {
            break label326;
          }
          if ((this.qHe != null) && (this.qHe.get() != null)) {
            break;
          }
          Log.e("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "NOT_AUTO_SUCCEED_ACTION_PREPARE context == null");
          AppMethodBeat.o(213001);
          return;
        }
        paramString = new f.a((Context)this.qHe.get());
        paramString.HL(false);
        paramString.bBl(this.EVY).bBq(this.EVZ).bBp(this.oFx).c(new f.c()
        {
          public final void g(boolean paramAnonymousBoolean, String paramAnonymousString)
          {
            AppMethodBeat.i(213319);
            Log.i("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "click %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            if (paramAnonymousBoolean)
            {
              if ((a.b(a.this) == null) || (a.b(a.this).get() == null))
              {
                Log.e("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "onDialogClick context == null");
                AppMethodBeat.o(213319);
                return;
              }
              paramAnonymousString = (Context)a.b(a.this).get();
              a.a(a.this, new com.tencent.mm.plugin.messenger.b.a(a.c(a.this), a.d(a.this), a.e(a.this), 2));
              com.tencent.mm.kernel.h.aGY().a(a.a(a.this), 0);
              a.a(a.this, paramAnonymousString);
              com.tencent.mm.plugin.messenger.f.a.Z(a.f(a.this), 9);
              AppMethodBeat.o(213319);
              return;
            }
            com.tencent.mm.plugin.messenger.f.a.Z(a.f(a.this), 10);
            AppMethodBeat.o(213319);
          }
        }).show();
        com.tencent.mm.plugin.messenger.f.a.Z(this.msgId, 8);
        label326:
        AppMethodBeat.o(213001);
        return;
        label333:
        Log.e("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "notAutoSucceedResp is null");
      }
      Object localObject = MMApplicationContext.getContext();
      paramq = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramq = MMApplicationContext.getContext().getString(b.d.app_err_system_busy_tip);
      }
      w.makeText((Context)localObject, paramq, 0).show();
      com.tencent.mm.plugin.messenger.f.a.Z(this.msgId, 6);
    }
    AppMethodBeat.o(213001);
  }
  
  public final void release()
  {
    AppMethodBeat.i(212988);
    super.release();
    com.tencent.mm.kernel.h.aGY().b(3713, this);
    AppMethodBeat.o(212988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.d.a
 * JD-Core Version:    0.7.0.1
 */