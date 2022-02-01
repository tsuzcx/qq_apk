package com.tencent.mm.plugin.messenger.c;

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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.d.b;
import com.tencent.mm.plugin.messenger.d.b.b;
import com.tencent.mm.plugin.messenger.d.c;
import com.tencent.mm.plugin.messenger.d.c.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ccv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class a
  extends b
  implements f
{
  private ProgressDialog fMu;
  String kBv;
  WeakReference<Context> lVh;
  long msgId;
  com.tencent.mm.plugin.messenger.b.a vKo;
  String vKp;
  String vKq;
  String vKr;
  String vKs;
  String vKt;
  
  public a(b.b paramb)
  {
    super(paramb);
    AppMethodBeat.i(211846);
    this.fMu = null;
    g.aiU().a(3713, this);
    AppMethodBeat.o(211846);
  }
  
  static CharSequence concactSpannable(ArrayList<CharSequence> paramArrayList)
  {
    AppMethodBeat.i(211849);
    SpannableString localSpannableString = new SpannableString("");
    Iterator localIterator = paramArrayList.iterator();
    for (paramArrayList = localSpannableString; localIterator.hasNext(); paramArrayList = TextUtils.concat(new CharSequence[] { paramArrayList, (CharSequence)localIterator.next() })) {}
    AppMethodBeat.o(211849);
    return paramArrayList;
  }
  
  public final CharSequence b(final Map<String, String> paramMap, final String paramString, final Bundle paramBundle, final WeakReference<Context> paramWeakReference, final WeakReference<NeatTextView> paramWeakReference1)
  {
    AppMethodBeat.i(211848);
    if (paramMap == null)
    {
      AppMethodBeat.o(211848);
      return null;
    }
    if (paramBundle != null) {}
    for (final String str1 = paramBundle.getString("conv_talker_username");; str1 = "")
    {
      String str2 = bt.nullAsNil((String)paramMap.get(paramString + ".title"));
      SpannableString localSpannableString = new SpannableString(str2);
      localSpannableString.setSpan(new com.tencent.mm.plugin.messenger.a.a()
      {
        public final void onClickImp(View paramAnonymousView)
        {
          AppMethodBeat.i(211843);
          a.this.msgId = paramBundle.getLong("msg_id");
          a locala = a.this;
          Map localMap = paramMap;
          String str1 = paramString;
          WeakReference localWeakReference = paramWeakReference;
          if (localWeakReference != null) {}
          ArrayList localArrayList;
          c.a locala1;
          do
          {
            try
            {
              if (localWeakReference.get() != null)
              {
                locala.lVh = localWeakReference;
                if ("new_tmpl_type_succeed_contact_window".equals((String)localMap.get(str1 + ".window_template.$type")))
                {
                  locala.vKp = bt.bI((String)localMap.get(str1 + ".window_template.title"), "");
                  locala.vKq = bt.bI((String)localMap.get(str1 + ".window_template.cancel_wording"), "");
                  locala.kBv = bt.bI((String)localMap.get(str1 + ".window_template.confirm_wording"), "");
                  locala.vKr = bt.bI((String)localMap.get(str1 + ".origin_username"), "");
                  locala.vKs = bt.bI((String)localMap.get(str1 + ".heir_username"), "");
                  locala.vKt = bt.bI((String)localMap.get(str1 + ".succeed_ticket"), "");
                  paramAnonymousView = c.aqD(locala.vKp);
                  if ((paramAnonymousView == null) || (paramAnonymousView.size() <= 0)) {
                    break label711;
                  }
                  localArrayList = new ArrayList();
                  Iterator localIterator = paramAnonymousView.iterator();
                  for (;;)
                  {
                    if (!localIterator.hasNext()) {
                      break label697;
                    }
                    locala1 = (c.a)localIterator.next();
                    if ((locala1 != null) && (locala1.content != null))
                    {
                      if (locala1.type != 0) {
                        break;
                      }
                      localArrayList.add(new SpannableString(k.c(aj.getContext(), locala1.content)));
                    }
                  }
                }
              }
              ((e)g.ab(e.class)).a("new_link_succeed_contact", paramMap, paramBundle);
            }
            catch (Exception paramAnonymousView)
            {
              ad.e("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "Exception:%s %s", new Object[] { paramAnonymousView.getClass().getSimpleName(), paramAnonymousView.getMessage() });
            }
            AppMethodBeat.o(211843);
            return;
          } while (locala1.type != 1);
          int i = 0;
          for (;;)
          {
            paramAnonymousView = str1 + ".window_template.link_list.link";
            if (i != 0) {
              paramAnonymousView = paramAnonymousView + i;
            }
            for (;;)
            {
              if (bt.isNullOrNil((String)localMap.get(paramAnonymousView))) {
                break label763;
              }
              String str2 = (String)localMap.get(paramAnonymousView + ".$name");
              String str3 = (String)localMap.get(paramAnonymousView + ".$type");
              if ((!locala1.content.equals(str2)) || (!"link_plain".equals(str3))) {
                break label765;
              }
              localArrayList.add(bt.bI((String)localMap.get(paramAnonymousView + ".plain"), ""));
              break label765;
              label697:
              locala.vKp = a.concactSpannable(localArrayList).toString();
              label711:
              locala.fK((Context)localWeakReference.get());
              locala.vKo = new com.tencent.mm.plugin.messenger.b.a(locala.vKr, locala.vKs, locala.vKt, 1);
              g.aiU().a(locala.vKo, 0);
              break;
            }
            label763:
            break;
            label765:
            i += 1;
          }
        }
      }, 0, str2.length(), 33);
      AppMethodBeat.o(211848);
      return localSpannableString;
    }
  }
  
  public final String dmf()
  {
    return "new_link_succeed_contact";
  }
  
  final void fK(Context paramContext)
  {
    AppMethodBeat.i(211850);
    if (this.fMu == null)
    {
      paramContext.getString(2131755906);
      this.fMu = h.b(paramContext, paramContext.getString(2131761820), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(211844);
          g.aiU().a(a.this.vKo);
          AppMethodBeat.o(211844);
        }
      });
      AppMethodBeat.o(211850);
      return;
    }
    if (!this.fMu.isShowing()) {
      this.fMu.show();
    }
    AppMethodBeat.o(211850);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(211851);
    ad.i("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "onSceneEnd errType = %d, errCode = %d, errMsg = %s, scenetype:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.getType()) });
    if ((this.fMu != null) && (this.fMu.isShowing())) {
      this.fMu.dismiss();
    }
    if ((paramn instanceof com.tencent.mm.plugin.messenger.b.a))
    {
      if (paramInt2 == -3600)
      {
        new f.a(aj.getContext()).aXO(aj.getContext().getString(2131766240)).afp(2131766205).b(null).show();
        com.tencent.mm.plugin.messenger.e.a.R(this.msgId, 7);
        AppMethodBeat.o(211851);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject = (com.tencent.mm.plugin.messenger.b.a)paramn;
        if (((com.tencent.mm.plugin.messenger.b.a)localObject).vKn == null) {}
        for (localObject = null;; localObject = ((com.tencent.mm.plugin.messenger.b.a)localObject).vKn)
        {
          paramInt1 = ((com.tencent.mm.plugin.messenger.b.a)paramn).action;
          if (localObject == null) {
            break label325;
          }
          ad.i("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "NetSceneOpenImNotAutoSucceed ret:%s action:%s", new Object[] { Integer.valueOf(((ccv)localObject).BaseResponse.Ret), Integer.valueOf(paramInt1) });
          if (paramInt1 != 1) {
            break label319;
          }
          if ((this.lVh != null) && (this.lVh.get() != null)) {
            break;
          }
          ad.e("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "NOT_AUTO_SUCCEED_ACTION_PREPARE context == null");
          AppMethodBeat.o(211851);
          return;
        }
        paramString = new f.a((Context)this.lVh.get());
        paramString.yU(false);
        paramString.aXO(this.vKp).aXT(this.vKq).aXS(this.kBv).c(new f.c()
        {
          public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
          {
            AppMethodBeat.i(211845);
            ad.i("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "click %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            if (paramAnonymousBoolean)
            {
              if ((a.this.lVh == null) || (a.this.lVh.get() == null))
              {
                ad.e("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "onDialogClick context == null");
                AppMethodBeat.o(211845);
                return;
              }
              paramAnonymousString = (Context)a.this.lVh.get();
              a.this.vKo = new com.tencent.mm.plugin.messenger.b.a(a.this.vKr, a.this.vKs, a.this.vKt, 2);
              g.aiU().a(a.this.vKo, 0);
              a.this.fK(paramAnonymousString);
              com.tencent.mm.plugin.messenger.e.a.R(a.this.msgId, 9);
              AppMethodBeat.o(211845);
              return;
            }
            com.tencent.mm.plugin.messenger.e.a.R(a.this.msgId, 10);
            AppMethodBeat.o(211845);
          }
        }).show();
        com.tencent.mm.plugin.messenger.e.a.R(this.msgId, 8);
        label319:
        AppMethodBeat.o(211851);
        return;
        label325:
        ad.e("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "notAutoSucceedResp is null");
      }
      Object localObject = aj.getContext();
      paramn = paramString;
      if (bt.isNullOrNil(paramString)) {
        paramn = aj.getContext().getString(2131755733);
      }
      t.makeText((Context)localObject, paramn, 0).show();
      com.tencent.mm.plugin.messenger.e.a.R(this.msgId, 6);
    }
    AppMethodBeat.o(211851);
  }
  
  public final void release()
  {
    AppMethodBeat.i(211847);
    super.release();
    g.aiU().b(3713, this);
    AppMethodBeat.o(211847);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.c.a
 * JD-Core Version:    0.7.0.1
 */